package sample

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div

interface AddTodoProps: RProps {
    var name: String
}

class AddTodo: RComponent<AddTodoProps, RState>() {
    override fun RBuilder.render() {
        div {
            +"Hello, ${props.name}"
        }
    }
}

fun RBuilder.addTodo(name: String = "John") = child(AddTodo::class) {
    attrs.name = name
}