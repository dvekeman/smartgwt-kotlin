@file:JsQualifier("isc")
package isc

/**
 *  Form item representing a member of a radio group, subclassed from NativeCheckboxItem.
 *   RadioItems items are created and managed automatically by RadioGroupItem instances
 *   and should not be instantiated directly.
 */
open external class RadioItem : NativeCheckboxItem {
    companion object {
        /**
         *  Creates a new RadioItem
         * 
         *  @param typeCheckedProperties {Partial<RadioItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {RadioItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): RadioItem = definedExternally
    }
}