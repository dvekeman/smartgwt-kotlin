package isc

import main.SampleStore
import redux.RAction

fun createStandardButton(title: String): isc.Button {
    val button = isc.IButton.create()
    button.setTitle(title)
    return button
}

fun withClickDispatch(canvas: isc.Canvas, store: SampleStore, action: RAction): isc.Canvas {
    canvas.asDynamic().click = {
        store.dispatch(action)
    }
    return canvas
}

fun createStandardLabel(contents: String): isc.Label {
    val label = isc.Label.create()
    label.setContents(contents)
    return label
}
