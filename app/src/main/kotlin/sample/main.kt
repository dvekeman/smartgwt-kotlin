package sample

import redux.*
import kotlin.browser.document
import kotlin.browser.window

typealias SampleStore = Store<AppState, RAction, WrapperAction>

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

    @Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE") 
    val store : SampleStore = 
            (state?.appState as SampleStore?) 
                    ?: createStore(reducer = ::todoApp, preloadedState = AppState(), enhancer = rEnhancer())
    val unsubscribe = store.subscribe { println("State changed to: ${store.state}") }

    if (document.body != null) {
        application = start(store)
    } else {
        application = null
        document.addEventListener("DOMContentLoaded", { e -> 
            application = start(store) 
        })
    }

}

/**
 * Given an initial store, startup the application
 */
fun start(store: SampleStore): ApplicationBase {
    val application = MainApplication(store)
    application.start()
    return application
}
