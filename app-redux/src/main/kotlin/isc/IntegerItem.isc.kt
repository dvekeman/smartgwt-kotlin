@file:JsQualifier("isc")
package isc

/**
 *  FormItem intended for inputting integer numbers.
 */
open external class IntegerItem : TextItem {
    /**
     *   Return the value tracked by this form item as a Integer. If the value cannot
     *   be parsed to an int that matches the original value, null will be returned.
     * 
     * 
     */
    open fun getValueAsInteger(): Number = definedExternally
    companion object {
        /**
         *  Creates a new IntegerItem
         * 
         *  @param typeCheckedProperties {Partial<IntegerItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {IntegerItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): IntegerItem = definedExternally
    }
}