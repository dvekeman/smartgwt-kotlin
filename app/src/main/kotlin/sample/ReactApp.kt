package sample

import kotlinext.js.require
import kotlinext.js.requireAll
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.h2
import react.dom.render
import react.redux.provider
import sample.containers.visibleMainListGrid
import kotlin.browser.document

fun startReactApp(store: SampleStore) {
    requireAll(require.context("app", true, js("/\\.css$/")))
    render(document.getElementById("kotlin-react-app")) {
        provider(store) {
            app()
        }
    }
}

class ReactApp : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div("App-header") {
            h2 {
                +"Welcome to React with Kotlin"
            }
        }
        visibleMainListGrid()
    }
}

fun RBuilder.app() = child(ReactApp::class) {}
