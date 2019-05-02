@file:JsQualifier("isc")
package isc

/**
 *  EditProxy that handles DrawPane when editMode is enabled.
 */
open external class DrawPaneEditProxy : CanvasEditProxy {
    companion object {
        /**
         *  Creates a new DrawPaneEditProxy
         * 
         *  @param typeCheckedProperties {Partial<DrawPaneEditProxy>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DrawPaneEditProxy} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DrawPaneEditProxy = definedExternally
    }
}