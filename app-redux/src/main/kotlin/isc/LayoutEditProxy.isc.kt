@file:JsQualifier("isc")
package isc

/**
 *  EditProxy that handles Layout objects when editMode is enabled.
 */
open external class LayoutEditProxy : CanvasEditProxy {
    companion object {
        /**
         *  Creates a new LayoutEditProxy
         * 
         *  @param typeCheckedProperties {Partial<LayoutEditProxy>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {LayoutEditProxy} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): LayoutEditProxy = definedExternally
    }
}