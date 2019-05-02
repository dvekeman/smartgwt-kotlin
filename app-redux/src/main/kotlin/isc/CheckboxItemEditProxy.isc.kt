@file:JsQualifier("isc")
package isc

/**
 *  EditProxy that handles CheckboxItem when editMode is enabled.
 */
open external class CheckboxItemEditProxy : FormItemEditProxy {
    /**
     *   Returns the text based on the current component state to be edited inline.
     *   Called by the EditProxy.inlineEditForm to obtain the starting edit value.
     * 
     *   Returns the component's value as [ ] or [x].
     * 
     * 
     */
    override fun getInlineEditText(): Unit = definedExternally
    /**
     *   Save the new value into the component's state. Called by the
     *   EditProxy.inlineEditForm to commit the change.
     * 
     *   Updates the component's value.
     * 
     * 
     *  @param {string} the new component value
     */
    override fun setInlineEditText(newValue: String): Unit = definedExternally
    companion object {
        /**
         *  Creates a new CheckboxItemEditProxy
         * 
         *  @param typeCheckedProperties {Partial<CheckboxItemEditProxy>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {CheckboxItemEditProxy} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): CheckboxItemEditProxy = definedExternally
    }
}