@file:JsQualifier("isc")
package isc

/**
 *  Canvas to be used for Rich Text Editing
 */
open external class RichTextCanvas : Canvas {
    /**
     *  If the user presses the "Tab" key, should focus be taken from this editor?
     *   If set to false a "Tab" keypress will cause a Tab character
     *   to be inserted into the text, and focus will be left in the edit area.
     *  @type {boolean}
     *  @default true
     */
    open var moveFocusOnTab: Boolean = definedExternally
    /**
     *   Increases the indent for the currently selected paragraph. Within a list, increases the
     *   list level.
     * 
     */
    open fun indentSelection(): Unit = definedExternally
    /**
     *   Decreases the indent for the currently selected paragraph. Within a list, decreases the
     *   list level or breaks out of the list.
     * 
     */
    open fun outdentSelection(): Unit = definedExternally
    /**
     *   Converts the selection to an ordered list. If the selection is within an unordered list,
     *   the unordered list is converted to an ordered list.
     * 
     */
    open fun convertSelectionToOrderedList(): Unit = definedExternally
    /**
     *   Converts the selection to an unordered list. If the selection is within an ordered list,
     *   the ordered list is converted to an unordered list.
     * 
     */
    open fun convertSelectionToUnorderedList(): Unit = definedExternally
    /**
     *   Applies the given ListProperties to the currently selected HTML list, if any.
     *   If there is no list selected, then this method does nothing.
     * 
     *  @param {ListProperties} the list configuration to apply
     */
    open fun applyListProperties(listProperties: ListProperties): Unit = definedExternally
    companion object {
        /**
         *  Creates a new RichTextCanvas
         * 
         *  @param typeCheckedProperties {Partial<RichTextCanvas>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {RichTextCanvas} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): RichTextCanvas = definedExternally
    }
}