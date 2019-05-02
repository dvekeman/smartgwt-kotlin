@file:JsQualifier("isc")
package isc

/**
 *  EditProxy that handles Progressbar objects when editMode is enabled.
 */
open external class ProgressbarEditProxy : StatefulCanvasEditProxy {
    /**
     *   Returns the text based on the current component state to be edited inline.
     *   Called by the EditProxy.inlineEditForm to obtain the starting edit value.
     * 
     *   Returns the component's percentDone.
     * 
     * 
     */
    override fun getInlineEditText(): Unit = definedExternally
    /**
     *   Save the new value into the component's state. Called by the
     *   EditProxy.inlineEditForm to commit the change.
     * 
     *   Updates the component's percentDone.
     * 
     * 
     *  @param {string} the new component percentDone
     */
    override fun setInlineEditText(newValue: String): Unit = definedExternally
    companion object {
        /**
         *  Creates a new ProgressbarEditProxy
         * 
         *  @param typeCheckedProperties {Partial<ProgressbarEditProxy>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ProgressbarEditProxy} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ProgressbarEditProxy = definedExternally
    }
}