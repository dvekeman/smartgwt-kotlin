package sample

abstract class ApplicationBase {
    abstract fun start()
    abstract fun dispose(): SampleStore
}