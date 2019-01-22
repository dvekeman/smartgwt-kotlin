package sample

class MainPresenter(override val view: MainView, val model: MainModel) : Presenter<MainView, MainModel> {
    init {
        view.presenter = this
    }

    override fun dispose(): MainModel {
        view.dispose()
        return model
    }

    override fun restore(state: MainModel) {
//        view.setName(model.name)
    }
}