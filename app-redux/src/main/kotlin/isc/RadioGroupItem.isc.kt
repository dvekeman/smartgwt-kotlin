@file:JsQualifier("isc")
package isc

/**
 *  FormItem that shows a set of mutually exclusive options as a group of radio buttons.
 */
open external class RadioGroupItem : FormItem {
    /**
     *  True == display options vertically, false == display in a single row
     *  @type {boolean}
     *  @default true
     */
    open var vertical: Boolean = definedExternally
    /**
     *  If RadioGroupItem.vertical is false, and this item has a specified width, should
     *   options be spread out evenly to fill the specified width?
     *  @type {boolean}
     *  @default false
     */
    open var fillHorizontalSpace: Boolean = definedExternally
    /**
     *  Base CSS class applied to the text for items within this radio group.
     *  @type {FormItemBaseStyle}
     *  @default "labelAnchor"
     */
    override var textBoxStyle: String = definedExternally
    /**
     *  Should the text for items within this radio group wrap?
     *  @type {boolean}
     *  @default null
     */
    open var wrap: Boolean = definedExternally
    /**
     *  Map of properties to apply to generated items within this RadioGroup. This allows you to
     *   customize the generated radio items for this item.
     *  @type {RadioItem}
     *  @default null
     */
    open var itemProperties: RadioItem = definedExternally
    /**
     *  This property allows you to specify an initial set of disabled options within
     *   this radioGroup. Once the RadioGroupItem has been created RadioGroupItem.setValueDisabled
     *   should be used to enable and disable options.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var disabledValues: Array<dynamic> = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "SelectItemEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
    /**
     *   Setter for RadioGroupItem.textBoxStyle.
     * 
     *  @param {FormItemBaseStyle} new textBoxStyle.
     */
    open fun setTextBoxStyle(newTextBoxStyle: String): Unit = definedExternally
    /**
     *   Notification method called when FormItem.showPending is enabled and
     *   this radio group should either clear or show its pending visual state.
     * 
     *   The default behavior is that the FormItem.titleStyle and
     *   FormItem.cellStyle are updated to include/exclude the "Pending" suffix.
     *   In addition, the label for the newly-selected option will have a different color.
     *   Returning false will cancel this default behavior.
     * 
     *  @param {DynamicForm} the managing DynamicForm instance.
     *  @param {FormItem} the form item itself (also available as "this").
     *  @param {boolean} true if the item should show its pending visual state; false otherwise.
     *  @param {any} the current form item value.
     *  @param {any} the value that would be restored by a call to DynamicForm.resetValues.
     */
    override fun pendingStatusChanged(form: DynamicForm, item: FormItem, pendingStatus: Boolean, newValue: dynamic, value: dynamic): Boolean = definedExternally
    /**
     *   If defined, this method should return the HTML to display in a hover canvas when the
     *   user holds the mousepointer over one of the radio-items in this RadioGroupItem. Return
     *   null to suppress the hover canvas altogether.
     * 
     * 
     *  @param {any} The sub-value (radio-item) to get the hoverHTML for
     *  @param {RadioGroupItem} Pointer to this item
     *  @param {DynamicForm} This item's form
     */
    open fun valueHoverHTML(value: dynamic, item: RadioGroupItem, form: DynamicForm): String = definedExternally
    /**
     *   Disable or Enable a specific option within this radioGroup
     * 
     *  @param {any} value of option to disable
     *  @param {boolean} true to disable the option, false to enable it
     */
    open fun setValueDisabled(value: dynamic, disabled: Boolean): Unit = definedExternally
    companion object {
        /**
         *  Creates a new RadioGroupItem
         * 
         *  @param typeCheckedProperties {Partial<RadioGroupItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {RadioGroupItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): RadioGroupItem = definedExternally
    }
}