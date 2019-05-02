@file:JsQualifier("isc")
package isc

/**
 *  EditProxy that handles Canvas objects when editMode is enabled.
 */
open external class CanvasEditProxy : EditProxy {
    companion object {
        /**
         *  Creates a new CanvasEditProxy
         * 
         *  @param typeCheckedProperties {Partial<CanvasEditProxy>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {CanvasEditProxy} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): CanvasEditProxy = definedExternally
    }
}