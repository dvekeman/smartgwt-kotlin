@file:JsQualifier("isc")
package isc

/**
 *  Button that saves the data in the form, by calling DynamicForm.submit when clicked.
 *   DynamicForm.submit for details on how to control what happens when a form is
 *   submitted.
 */
open external class SubmitItem : ButtonItem {
    /**
     *  SubmitItems show a title of "Submit" by default. May be overridden.
     *  @type {string}
     *  @default "Submit"
     */
    override var title: String = definedExternally
    companion object {
        /**
         *  Creates a new SubmitItem
         * 
         *  @param typeCheckedProperties {Partial<SubmitItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {SubmitItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): SubmitItem = definedExternally
    }
}