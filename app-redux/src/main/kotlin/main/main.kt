package main

import redux.RAction
import redux.Store
import redux.WrapperAction
import redux.state
import kotlin.browser.document
import kotlin.browser.window

typealias SampleStore = Store<AppState, RAction, WrapperAction>

val scheme = "http"
val host = "localhost"
val port = 8188

/** true if hosted by the backend. False if hosted separately */
val hosted = false

/**
 * Entrypoint for the application.
 * 
 * Two options
 * 
 * - hosted through the backend application, in which case the backend application calls #startApp
 * - self-hosted in which case the application starts up automatically
 * 
 * See #hosted option above.
 * 
 */
fun main(args: Array<String>) {
    println("main")

    if(hosted) {
        window.asDynamic().startApp = startApp
    } else {
        startApp()
    }
}

/**
 * Start an application
 * 
 * - Initialize the store (potenially initialize the store from the webpack hot module loader state)
 * - Create or reload the body of the HTML page
 */
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
        println(store.state)
    }

    val application = MainApplication(store)
    application.start()
    return application
}
