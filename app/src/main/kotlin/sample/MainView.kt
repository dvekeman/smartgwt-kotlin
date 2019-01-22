package sample

class MainView {
    lateinit var presenter: MainPresenter

    init {
        register()
    }

    fun dispose() {
        unregister()
    }

    private fun register() {
        
    }

    private fun unregister() {
    }
}
