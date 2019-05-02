@file:JsQualifier("isc")
package isc

/**
 *  EditProxy that handles SectionStack objects when editMode is enabled.
 */
open external class SectionStackEditProxy : LayoutEditProxy {
    companion object {
        /**
         *  Creates a new SectionStackEditProxy
         * 
         *  @param typeCheckedProperties {Partial<SectionStackEditProxy>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {SectionStackEditProxy} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): SectionStackEditProxy = definedExternally
    }
}