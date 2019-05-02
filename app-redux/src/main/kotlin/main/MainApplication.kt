package main

import kotlinext.js.requireAll
import redux.RAction
import redux.state
import widgets.MainListGrid
import widgets.createStandardButton
import widgets.createStandardLabel
import widgets.withClickDispatch


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

    private lateinit var mainLayout: isc.Layout
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

            if (visibleModule == newVisibleModule) {
                println("No changes... (visibleModule: '$visibleModule') ")
                return@subscribe
            }

            visibleModule = newVisibleModule
            bodyContainer.removeChild(bodyContainer.children[0], name = null)

            when (store.state.mainState.visibleModule) {
                Section.NONE -> {
                    bodyContainer.addChild(createDefaultBody(), name = null, autoDraw = true)
                }

                Section.NEW_LISTGRID -> {
                    println("Adding NEW_LISTGRID to the bodyContainer")
                    bodyContainer.addChild(MainListGrid(store).getCanvas(), name = null, autoDraw = true)
                }

                Section.OLD_LISTGRID -> {
                    println("Adding OLD_LISTGRID to the bodyContainer")
                    bodyContainer.addChild(globalgwt.lookup("mainLayout").asDynamic(), name = null, autoDraw = true)
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
        mainLayout = isc.HLayout.create(js("""
{ overflow: "hidden"
, width: "100%"
, height: "100%"
}
        """), null)
        mainLayout.addMember(createBody(), position = null)
        return mainLayout
    }

    @JsName("createBody")
    private fun createBody(): isc.VLayout {

        val bodyLayout = isc.VLayout.create(js("""
{ width: "100%"
, height: "100%"
, overflow: "hidden"
}
            """
        ), null)
        bodyLayout.addMembers(arrayOf(createTopBar(), createBodyContainer(), createFooter()), position = null)
        return bodyLayout

    }

    private fun createTopBar(): isc.Canvas {
        val topbar = isc.HLayout.create(js("""{}"""), null)

        val menuButtons: Array<isc.Canvas> = Section.values()
                .map {
                    withClickDispatch(createStandardButton(it.title), store, ChangeSection(it))
                }
                .toTypedArray()
        topbar.addMembers(menuButtons, position = null)

        return topbar
    }

    private fun createDefaultBody(): isc.Canvas {
        return createStandardLabel("BODY")
    }

    private fun createBodyContainer(): isc.Canvas {
        val body = isc.Canvas.create(js("""{}"""), null)
        body.addChild(createDefaultBody(), name = "body", autoDraw = true)
        return body
    }

    private fun createFooter(): isc.Canvas {
        val footerLabel = createStandardLabel("FOOTER")
        val footer = isc.Canvas.create(null, null)
        footer.addChild(footerLabel, name = "footer", autoDraw = true)
        return footer
    }

}

