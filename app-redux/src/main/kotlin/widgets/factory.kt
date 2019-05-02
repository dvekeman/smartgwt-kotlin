package widgets

import main.SampleStore
import redux.RAction

@Suppress("UNUSED_PARAMETER")
fun createStandardButton(title: String): isc.Button {
    // second `title` is the parameter value
    return isc.IButton.create(js("""
{ title: title }
        """), null)
}

fun withClickDispatch(canvas: isc.Canvas, store: SampleStore, action: RAction): isc.Canvas {
    canvas.asDynamic().click = {
        println("Dispatching: store: ")
        println(store)
        println("Dispatching: action: $action")
        store.dispatch(action)
    }
    return canvas
}

@Suppress("UNUSED_PARAMETER")
fun createStandardLabel(contents: String): isc.Label {
    // second `contents` is the parameter value
    return isc.Label.create(js("""
{ contents: contents }
    """), null)
}
