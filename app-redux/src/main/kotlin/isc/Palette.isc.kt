@file:JsQualifier("isc")
package isc

external interface Palette {
    var defaultEditContext: dynamic
    var generateNames: Boolean
    fun setDefaultEditContext (defaultEditContext: dynamic): Unit
    fun makeEditNode (paletteNode: PaletteNode): EditNode
}