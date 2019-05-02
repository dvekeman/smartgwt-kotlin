@file:JsQualifier("isc")
package isc

/**
 *  EditProxy that handles DateItem when editMode is enabled.
 */
open external class DateItemEditProxy : FormItemEditProxy {
    /**
     *   Returns the text based on the current component state to be edited inline.
     *   Called by the EditProxy.inlineEditForm to obtain the starting edit value.
     * 
     *   Returns the component's value using Date.toShortDate.
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
     *  @param {string} the new component default value
     */
    override fun setInlineEditText(newValue: String): Unit = definedExternally
    companion object {
        /**
         *  Creates a new DateItemEditProxy
         * 
         *  @param typeCheckedProperties {Partial<DateItemEditProxy>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DateItemEditProxy} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DateItemEditProxy = definedExternally
    }
}