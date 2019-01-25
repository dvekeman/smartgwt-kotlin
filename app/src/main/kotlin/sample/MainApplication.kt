package sample

import kotlin.js.Date

/**
 * Bootstrap the Main view.
 */
class MainApplication(val store: SampleStore) : ApplicationBase() {

    private lateinit var view: MainView

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
        view.dispose()
        return store
    }
    
}