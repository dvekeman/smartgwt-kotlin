package main

import kotlinext.js.requireAll
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.h2
import react.dom.render
import react.redux.provider
import main.components.visibleMainListGrid
import kotlin.browser.document
import kotlin.js.Date

abstract class ApplicationBase {
    abstract fun start()
    abstract fun dispose(): SampleStore
}

/**
 * Bootstrap the Main view.
 */
class MainApplication(val store: SampleStore) : ApplicationBase() {

    /**
     * Start the application by show the main view.
     */
    override fun start() {
        store.dispatch(AddAppEvent("Startup at " + Date()))
        // view = MainView(store)
        startReactApp(store)
    }

    /**
     * Dispose the main view and return the application data (= store)
     */
    override fun dispose(): SampleStore {
        return store
    }
    
}

fun startReactApp(store: SampleStore) {
    requireAll(kotlinext.js.require.context("app-react-redux", true, js("/\\.css$/")))
    render(document.getElementById("kotlin-react-app")) {
        provider(store) {
            app()
        }
    }
}

class ReactApp : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div("MainApplication-header") {
            h2 {
                +"Welcome to React with Kotlin"
            }
        }
        visibleMainListGrid()
    }
}

fun RBuilder.app() = child(ReactApp::class) {}