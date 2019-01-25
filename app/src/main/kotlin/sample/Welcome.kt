package sample

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div

interface WelcomeProps: RProps {
    var name: String
}

class Welcome: RComponent<WelcomeProps, RState>() {
    override fun RBuilder.render() {
        div {
            +"Hello, ${props.name}"
        }
    }
}

fun RBuilder.welcome(name: String = "John") = child(Welcome::class) {
    attrs.name = name
}