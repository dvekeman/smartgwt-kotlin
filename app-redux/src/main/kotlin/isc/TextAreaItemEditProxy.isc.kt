@file:JsQualifier("isc")
package isc

/**
 *  EditProxy that handles TextAreaItem when editMode is enabled.
 */
open external class TextAreaItemEditProxy : TextItemEditProxy {
    companion object {
        /**
         *  Creates a new TextAreaItemEditProxy
         * 
         *  @param typeCheckedProperties {Partial<TextAreaItemEditProxy>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {TextAreaItemEditProxy} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): TextAreaItemEditProxy = definedExternally
    }
}