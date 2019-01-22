package sample

import kotlin.browser.window

fun main(args: Array<String>) {
    println("main")

    window.asDynamic().startApp = startApp
}

val startApp: () -> ApplicationBase = { 
    println("startApp...")
    val initialState = emptyMap<String, Any>()
    startAppWithState(initialState)
}

fun startAppWithState(state: dynamic): ApplicationBase {
    val application = MainApplication()
    application.start(state?.appState ?: emptyMap())

    return application
}

