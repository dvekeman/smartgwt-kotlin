@file:JsQualifier("isc")
package isc

/**
 *  FormItem for rich text (HTML) editing. Makes use of a RichTextEditor as the
 *   editing interface.
 */
open external class RichTextItem : CanvasItem {
    /**
     *  If the user presses the "Tab" key, should focus be taken from this editor?
     *   If set to false a "Tab" keypress will cause a Tab character
     *   to be inserted into the text, and focus will be left in the edit area.
     *  @type {boolean}
     *  @default true
     */
    open var moveFocusOnTab: Boolean = definedExternally
    /**
     *  Should this item's value be saved in the form's values and hence returned from
     *   DynamicForm.getValues?
     * 
     *   shouldSaveValue:false is used to mark formItems which do not correspond to
     *   the underlying data model and should not save a value into the form's
     *   DynamicForm.values. Example includes visual separators, password re-type fields,
     *   or checkboxes used to show/hide other form items.
     * 
     *   A shouldSaveValue:false item should be given a value either via
     *   FormItem.defaultValue or by calling
     *   DynamicForm.setValue or
     *   FormItem.setValue. Providing a value via
     *   DynamicForm.values or DynamicForm.setValues
     *   will automatically switch the item to shouldSaveValue:true.
     * 
     *   Note that
     * 
     *  - if an item is shouldSaveValue true, but has no name, a warning is logged, and
     *     shouldSaveValue will be set to false.
     * 
     *  @type {boolean}
     *  @default true
     */
    override var shouldSaveValue: Boolean = definedExternally
    /**
     *  Don't show the title for rich text items by default
     *  @type {boolean}
     *  @default false
     */
    override var showTitle: Boolean = definedExternally
    /**
     *  By default RichTextItems take up an entire row
     *  @type {boolean}
     *  @default true
     */
    override var startRow: Boolean = definedExternally
    /**
     *  By default RichTextItems take up an entire row
     *  @type {boolean}
     *  @default true
     */
    override var endRow: Boolean = definedExternally
    /**
     *  By default RichTextItems take up an entire row
     *  @type {Integer | string}
     *  @default "\*"
     */
    override var colSpan: dynamic = definedExternally
    /**
     *  RichTextEditor.controlGroups to display for this editor.
     *   Each controlGroup should be a property set either on this item or on the RichTextEditor
     *   prototype and should be set to an array of ControlNames.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var controlGroups: Array<dynamic> = definedExternally
    /**
     *   Setter for RichTextItem.moveFocusOnTab.
     * 
     *  @param {boolean} new value for moveFocusOnTab
     */
    open fun setMoveFocusOnTab(moveFocusOnTab: Boolean): Unit = definedExternally
    companion object {
        /**
         *  Creates a new RichTextItem
         * 
         *  @param typeCheckedProperties {Partial<RichTextItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {RichTextItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): RichTextItem = definedExternally
    }
}