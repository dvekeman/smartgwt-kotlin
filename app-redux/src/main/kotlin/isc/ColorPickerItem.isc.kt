@file:JsQualifier("isc")
package isc

/**
 *  Form item for selecting a color via a pop-up ColorPicker. This is an alias of
 *   ColorItem.
 */
open external class ColorPickerItem : ColorItem {
    companion object {
        /**
         *  Creates a new ColorPickerItem
         * 
         *  @param typeCheckedProperties {Partial<ColorPickerItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ColorPickerItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ColorPickerItem = definedExternally
    }
}