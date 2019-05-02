@file:JsQualifier("isc")
package isc

/**
 *  FormItem for password fields, where text input by the user should not be shown in readable text.
 */
open external class PasswordItem : TextItem {
    companion object {
        /**
         *  Creates a new PasswordItem
         * 
         *  @param typeCheckedProperties {Partial<PasswordItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {PasswordItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): PasswordItem = definedExternally
    }
}