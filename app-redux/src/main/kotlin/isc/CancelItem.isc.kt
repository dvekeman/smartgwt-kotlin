@file:JsQualifier("isc")
package isc

/**
 *  Button that cancels any changes in the form, by calling DynamicForm.cancelEditing
 *   when clicked.
 *   See DynamicForm.cancelEditing for details on what happens when a form editing is
 *   cancelled.
 */
open external class CancelItem : ButtonItem {
    /**
     *  CancelItems show a title of "Cancel" by default. May be overridden.
     *  @type {string}
     *  @default "Cancel"
     */
    override var title: String = definedExternally
    companion object {
        /**
         *  Creates a new CancelItem
         * 
         *  @param typeCheckedProperties {Partial<CancelItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {CancelItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): CancelItem = definedExternally
    }
}