package main

import isc.Canvas.Companion.CENTER
import isc.Canvas.Companion.HIDDEN
import isc.VLayout
import isc.createStandardButton
import isc.createStandardLabel
import isc.withClickDispatch
import kotlinext.js.requireAll
import redux.RAction
import redux.state


/** STATE / MODEL -------------------------------------------------------------------------------------------------- **/

data class MainState(val visibleModule: Section)

/** ---------------------------------------------------------------------------------------------------------------- **/

/** ACTIONS / MESSAGES --------------------------------------------------------------------------------------------- **/

data class ChangeSection(val activeSection: Section) : RAction

/** ---------------------------------------------------------------------------------------------------------------- **/

/** REDUCER / UPDATE ----------------------------------------------------------------------------------------------- **/

fun mainReducer(mainState: MainState = MainState(visibleModule = Section.NONE), action: RAction) =
        when (action) {

            is ChangeSection ->
                mainState.copy(visibleModule = action.activeSection)

            else -> mainState

        }

/** -----------------------------------------------------------------------------------------------------------------**/


abstract class ApplicationBase {
    abstract fun start()
    abstract fun dispose(): SampleStore
}

enum class Section(val title: String) {
    NONE("HOME"), NEW_LISTGRID("SmartClient ListGrid"), OLD_LISTGRID("SmartGWT ListGrid")
}

/**
 * Bootstrap the Main view.
 */
class MainApplication(val store: SampleStore) : ApplicationBase() {

    // TODO: lateinit is dangerous...
    private lateinit var mainLayout: isc.Layout
    // TODO: lateinit is dangerous...
    private lateinit var bodyContainer: isc.Canvas

    /**
     * Start the application by show the main view.
     */
    override fun start() {
        requireAll(kotlinext.js.require.context("app-redux", true, js("/\\.css$/")))

        mainLayout = createMainLayout()
        mainLayout.draw()

        var visibleModule = store.getState().mainState.visibleModule
        store.subscribe {
            val newVisibleModule = store.getState().mainState.visibleModule

            if(visibleModule == newVisibleModule){
                println("No changes... (visibleModule: '$visibleModule') ")
                return@subscribe
            }

            visibleModule = newVisibleModule
            bodyContainer.removeChild(bodyContainer.children[0])

            when (store.state.mainState.visibleModule) {
                Section.NONE -> {
                    bodyContainer.addChild(createDefaultBody())
                }

                Section.NEW_LISTGRID -> {
                    bodyContainer.addChild(MainListGrid(store).getCanvas())
                }

                Section.OLD_LISTGRID -> {
                    // The js("...") part is ugly because - for some reason - 
                    // kotlin does not yet find the globalgwt namespace (will be fixed)
                    bodyContainer.addChild(js("globalgwt.GlobalGWT.lookup(\"mainLayout\")"))
                    // bodyContainer.addChild(globalgwt.lookup("mainLayout") as isc.Canvas)
                }
            }
        }
    }

    /**
     * Dispose the main view and return the application data (= store)
     */
    override fun dispose(): SampleStore {
        return store
    }

    private fun createMainLayout(): isc.Layout {
        mainLayout = isc.HLayout.create()
        mainLayout.setOverflow(HIDDEN)
        mainLayout.defaultLayoutAlign = CENTER
        mainLayout.setWidth("100%")
        mainLayout.setHeight("100%")
        mainLayout.addMember(createBody())
        return mainLayout
    }

    private fun createBody(): VLayout {

        val vlayout = isc.VLayout.create()
        vlayout.setWidth("100%")
        vlayout.setHeight("100%")
        vlayout.setOverflow(HIDDEN)

        val topBar = createTopBar()
        vlayout.addMember(topBar)

        bodyContainer = createBodyContainer()
        vlayout.addMember(bodyContainer)

        val footer = createFooter()
        vlayout.addMember(footer)

        return vlayout
    }

    private fun createTopBar(): isc.Canvas {
        val topbar = isc.HLayout.create()

        val menuButtons: Array<isc.Canvas> = Section.values()
                .map {
                    withClickDispatch(createStandardButton(it.title), store, ChangeSection(it))
                }
                .toTypedArray()
        topbar.addMembers(menuButtons)

        return topbar
    }

    private fun createDefaultBody(): isc.Canvas {
        val bodyLabel = createStandardLabel("BODY")
        return bodyLabel
    }

    private fun createBodyContainer(): isc.Canvas {
        val body = isc.Canvas.create()
        body.addChild(createDefaultBody())
        return body
    }

    private fun createFooter(): isc.Canvas {
        val footerLabel = createStandardLabel("FOOTER")
        val footer = isc.Canvas.create()
        footer.addChild(footerLabel)
        return footer
    }

}

