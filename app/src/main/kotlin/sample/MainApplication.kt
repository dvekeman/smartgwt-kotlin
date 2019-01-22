package sample

class MainApplication : ApplicationBase() {
    private lateinit var view: MainView
    private lateinit var presenter: MainPresenter
    private lateinit var model: MainModel

    override val stateKeys = listOf("main")

    override fun start(state: Map<String, Any>) {
        view = MainView()
        model = MainModel("")
        presenter = MainPresenter(view, model)
    }

    override fun dispose() = mapOf(
            "main" to presenter.dispose()
    )
}