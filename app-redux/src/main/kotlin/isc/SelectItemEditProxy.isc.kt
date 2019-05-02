@file:JsQualifier("isc")
package isc

/**
 *  EditProxy that handles SelectItem, ComboBoxItem
 *   and RadioGroupItem when editMode is enabled.
 */
open external class SelectItemEditProxy : FormItemEditProxy {
    /**
     *   Returns the text based on the current component state to be edited inline.
     *   Called by the EditProxy.inlineEditForm to obtain the starting edit value.
     * 
     *   Returns the component's valueMap one-per-line as specified in
     *   FormItemEditProxy.valueMapDisplaySeparatorChar. Current value(s)
     *   is indicated with FormItemEditProxy.valueMapSelectedChar.
     * 
     * 
     */
    override fun getInlineEditText(): Unit = definedExternally
    /**
     *   Save the new value into the component's state. Called by the
     *   EditProxy.inlineEditForm to commit the change.
     * 
     *   Updates the component's valueMap and current value.
     * 
     * 
     *  @param {string} the new component valueMap
     */
    override fun setInlineEditText(newValue: String): Unit = definedExternally
    companion object {
        /**
         *  Creates a new SelectItemEditProxy
         * 
         *  @param typeCheckedProperties {Partial<SelectItemEditProxy>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {SelectItemEditProxy} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): SelectItemEditProxy = definedExternally
    }
}