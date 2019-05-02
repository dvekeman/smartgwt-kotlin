@file:JsQualifier("isc")
package isc

/**
 *  EditProxy that handles TabSet objects when editMode is enabled.
 */
open external class TabSetEditProxy : CanvasEditProxy {
    /**
     *   Returns the text based on the current component state to be edited inline.
     *   Called by the EditProxy.inlineEditForm to obtain the starting edit value.
     * 
     *   Returns a comma-separated list of tab titles. A " [x]" suffix is added
     *   for any tab with canClose enabled.
     * 
     * 
     */
    override fun getInlineEditText(): Unit = definedExternally
    /**
     *   Save the new value into the component's state. Called by the
     *   EditProxy.inlineEditForm to commit the change.
     * 
     *   Takes a comma-separated list of tab titles. Add " [x]" to a title
     *   to enable canClose for the tab.
     * 
     * 
     *  @param {string} the new component state
     */
    override fun setInlineEditText(newValue: String): Unit = definedExternally
    companion object {
        /**
         *  Creates a new TabSetEditProxy
         * 
         *  @param typeCheckedProperties {Partial<TabSetEditProxy>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {TabSetEditProxy} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): TabSetEditProxy = definedExternally
    }
}