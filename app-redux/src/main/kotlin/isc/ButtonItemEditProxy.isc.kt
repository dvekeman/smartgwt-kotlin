@file:JsQualifier("isc")
package isc

/**
 *  EditProxy that handles ButtonItem when editMode is enabled.
 */
open external class ButtonItemEditProxy : FormItemEditProxy {
    /**
     *   Returns the text based on the current component state to be edited inline.
     *   Called by the EditProxy.inlineEditForm to obtain the starting edit value.
     * 
     *   Returns the component's title or name.
     * 
     * 
     */
    override fun getInlineEditText(): Unit = definedExternally
    /**
     *   Save the new value into the component's state. Called by the
     *   EditProxy.inlineEditForm to commit the change.
     * 
     *   Updates the component's defaultValue.
     * 
     * 
     *  @param {string} the new component defaultValue
     */
    override fun setInlineEditText(newValue: String): Unit = definedExternally
    companion object {
        /**
         *  Creates a new ButtonItemEditProxy
         * 
         *  @param typeCheckedProperties {Partial<ButtonItemEditProxy>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ButtonItemEditProxy} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ButtonItemEditProxy = definedExternally
    }
}