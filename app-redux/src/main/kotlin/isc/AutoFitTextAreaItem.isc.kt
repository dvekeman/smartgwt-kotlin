@file:JsQualifier("isc")
package isc

/**
 *  Class for editable multi-line text areas (uses HTML &lt;TEXTAREA&gt; object)
 *   automatically expands to accomodate its content
 */
open external class AutoFitTextAreaItem : TextAreaItem {
    /**
     *  If specified, the autoFitTextArea will not grow taller than this height
     *  @type {Integer}
     *  @default null
     */
    open var maxHeight: Number = definedExternally
    companion object {
        /**
         *  Creates a new AutoFitTextAreaItem
         * 
         *  @param typeCheckedProperties {Partial<AutoFitTextAreaItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {AutoFitTextAreaItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): AutoFitTextAreaItem = definedExternally
    }
}