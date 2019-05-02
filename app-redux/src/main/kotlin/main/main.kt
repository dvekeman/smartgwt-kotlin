package main

import redux.RAction
import redux.Store
import redux.WrapperAction
import redux.state
import kotlin.browser.document
import kotlin.browser.window

typealias SampleStore = Store<AppState, RAction, WrapperAction>

/**
 * Entrypoint for the application.
 * 
 */
fun main(args: Array<String>) {
    println("main")
    startApp()
}

/**
 * Start an application
 * 
 * - Initialize the store (potenially initialize the store from the webpack hot module loader state)
 * - Create or reload the body of the HTML page
 */
@JsName("startApp")
val startApp: () -> Unit = {
    var application: ApplicationBase? = null

    val state = module.hot?.let { hot ->
        hot.accept()

        hot.dispose { data ->
            data.appState = application?.dispose()
        }

        hot.data
    }

    if (document.body != null) {
        application = start(state?.appState as SampleStore?)
    } else {
        application = null
        document.addEventListener("DOMContentLoaded", { e -> 
            application = start() 
        })
    }

}

/**
 * Given an initial store, startup the application
 */
fun start(initialStore: SampleStore? = null): ApplicationBase {
    @Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")

    val store : SampleStore = initialStore ?: createMainStore()
    val unsubscribe = store.subscribe { 
        println("State changed to: ")
        println(store.state.mainState)
    }

    val application = MainApplication(store)
    application.start()
    return application
}
