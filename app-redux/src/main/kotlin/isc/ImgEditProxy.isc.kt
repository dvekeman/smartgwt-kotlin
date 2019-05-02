@file:JsQualifier("isc")
package isc

/**
 *  EditProxy that handles Img objects when editMode is enabled.
 */
open external class ImgEditProxy : CanvasEditProxy {
    companion object {
        /**
         *  Creates a new ImgEditProxy
         * 
         *  @param typeCheckedProperties {Partial<ImgEditProxy>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ImgEditProxy} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ImgEditProxy = definedExternally
    }
}