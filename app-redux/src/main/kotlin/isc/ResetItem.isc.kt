@file:JsQualifier("isc")
package isc

/**
 *  Button that resets the form to default values, by calling
 *   DynamicForm.resetValues()
 * 
 *   If you define a click handler on this item, you can return false to cancel the reset.
 */
open external class ResetItem : ButtonItem {
    companion object {
        /**
         *  Creates a new ResetItem
         * 
         *  @param typeCheckedProperties {Partial<ResetItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ResetItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ResetItem = definedExternally
    }
}