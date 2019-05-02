@file:JsQualifier("isc")
package isc

/**
 * 
 *   A TextItem for managing a text field that displays a floating point value. FloatItem is the
 *   default FormItem if the FormItem.type is "float".
 * 
 *   FloatItem displays its value according to the FormItem.decimalPrecision and
 *   FormItem.decimalPad properties of the FormItem. While the value is being edited,
 *   the item will display the value with its original precision and without extra zero-padding.
 * 
 */
open external class FloatItem : TextItem {
    /**
     *   Return the value tracked by this form item as a Float. If the value cannot
     *   be parsed to a valid float, null will be returned.
     * 
     * 
     */
    open fun getValueAsFloat(): Number = definedExternally
    companion object {
        /**
         *  Creates a new FloatItem
         * 
         *  @param typeCheckedProperties {Partial<FloatItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {FloatItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): FloatItem = definedExternally
    }
}