@file:JsQualifier("isc")
package isc

/**
 *  TextForm item for managing a text field that displays a decimal value.
 */
open external class DoubleItem : FloatItem {
    /**
     *   Return the value tracked by this form item as a Double. If the value cannot
     *   be parsed to a valid double, null will be returned.
     * 
     * 
     */
    open fun getValueAsDouble(): Number = definedExternally
    companion object {
        /**
         *  Creates a new DoubleItem
         * 
         *  @param typeCheckedProperties {Partial<DoubleItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DoubleItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DoubleItem = definedExternally
    }
}