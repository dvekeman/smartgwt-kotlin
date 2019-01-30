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
import kotlin.js.Date

abstract class ApplicationBase {
    abstract fun start()
    abstract fun dispose(): SampleStore
}

enum class Section(val title: String) {
    NONE("None"), NEW_LISTGRID("New ListGrid"), OLD_LISTGRID("Old ListGrid")
}

/** ACTIONS >>> **/
data class ChangeSection(val activeSection: Section) : RAction
/** <<< ACTIONS **/

/** REDUCER >>> **/
fun mainReducer(mainState: MainState = MainState(visibleModule = Section.NONE), action: RAction) = when (action) {

    is ChangeSection ->
        mainState.copy(visibleModule = action.activeSection)

    else -> mainState

}

/** <<< REDUCER **/

data class MainState(val visibleModule: Section)

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
        store.dispatch(AddAppEvent("Startup at " + Date()))
        requireAll(kotlinext.js.require.context("app-redux", true, js("/\\.css$/")))

        mainLayout = createMainLayout()
        mainLayout.draw()

        store.subscribe {
            bodyContainer.removeChild(bodyContainer.children[0])

            when (store.state.mainState.visibleModule) {
                Section.NONE -> {
                    bodyContainer.addChild(createDefaultBody())
                }

                Section.NEW_LISTGRID -> {
                    bodyContainer.addChild(MainListGrid(store).getCanvas())
                }

                Section.OLD_LISTGRID -> {
                    TODO()
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

