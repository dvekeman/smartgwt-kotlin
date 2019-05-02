@file:JsQualifier("isc")
package isc

/**
 *  A MultiComboBoxItem is a combo box that allows the user to select multiple options. Each
 *   selected option is represented as a button that can be clicked to deselect the option.
 * 
 *   The relative layout of the buttons to the combo box is specified with the
 *   MultiComboBoxItem.layoutStyle attribute. The buttons will be kept in the order that
 *   they were added, with the most recently added button being adjacent to the combo box.
 * 
 *   MultiComboBoxItem uses the AutoChild pattern to construct the
 *   MultiComboBoxItem.comboBox and the MultiComboBoxItem.button
 *   so that they can be easily customized. For example, you can customize the criteria used to
 *   fetch by
 *   overriding ComboBoxItem.getPickListFilterCriteria via
 *   MultiComboBoxItem.comboBox.
 * 
 */
open external class MultiComboBoxItem : CanvasItem {
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
     *  The optionDataSource of the combo box.
     *  @type {DataSource | string}
     *  @default null
     */
    override var optionDataSource: dynamic = definedExternally
    /**
     *  Similar to ComboBoxItem.addUnknownValues, controls whether additional values can be
     *   added to the ComboBox or whether the user must choose from the available values in the picklist
     *   only.
     * 
     *   If this setting is changed after the MultiComboBoxItem has been created, the current value of
     *   the item is reset to null and all buttons for non-default values (values not in the FormItem.defaultValue
     *   array) are removed.
     *  @type {boolean}
     *  @default false
     */
    open var addUnknownValues: Boolean = definedExternally
    /**
     *  If true, hitting tab always exits the field, and will also add a value to the list of
     *   selected values if there is match (and depending on the setting for
     *   MultiComboBoxItem.addUnknownValues).
     * 
     *   If false, if the user has typed in a value and hits tab, focus remains in the field.
     *   If there is a match or if MultiComboBoxItem.addUnknownValues is true, a value will be added.
     *   Otherwise, the input cursor remains at the end of the entered value.
     *  @type {boolean}
     *  @default true
     */
    open var alwaysExitOnTab: Boolean = definedExternally
    /**
     *  Should the MultiComboBoxItem fetch data from the MultiComboBoxItem.optionDataSource
     *   immediately or wait until the user first opens the pickList.
     *  @type {boolean}
     *  @default false
     */
    open var autoFetchData: Boolean = definedExternally
    /**
     *  The valueMap of the combo box.
     *  @type {Array<any> | object}
     *  @default null
     */
    override var valueMap: dynamic = definedExternally
    /**
     *  An AutoChild attribute to create the combo box in a MultiComboBoxItem.
     *  @type {ComboBoxItem}
     *  @default null
     */
    open var comboBox: ComboBoxItem = definedExternally
    /**
     *  The DynamicForm holding the MultiComboBoxItem.comboBox.
     *  @type {DynamicForm}
     *  @default null
     */
    open var comboForm: DynamicForm = definedExternally
    /**
     *  If this item has a specified optionDataSource, this attribute may be set
     *   to specify an explicit DSRequest.operationId when performing a fetch against the
     *   option dataSource to pick up display value mapping.
     *  @type {string}
     *  @default null
     */
    override var optionOperationId: String = definedExternally
    /**
     *  The displayField of the combo box.
     *  @type {string}
     *  @default null
     */
    override var displayField: String = definedExternally
    /**
     *  The valueField of the combo box.
     *  @type {string}
     *  @default null
     */
    override var valueField: String = definedExternally
    /**
     *  The layout used to arrange the MultiComboBoxItem.comboForm and the buttons
     *   representing the values of the MultiComboBoxItem. Note that the constructor cannot be changed
     *   (setting a valueLayoutConstructor has no effect) because the exact layout class used depends
     *   on the current MultiComboBoxItem.layoutStyle.
     *  @type {Layout}
     *  @default null
     */
    open var valueLayout: Layout = definedExternally
    /**
     *  An AutoChild attribute used to create the buttons in the MultiComboBoxItem.
     *  @type {IButton}
     *  @default null
     */
    open var button: IButton = definedExternally
    /**
     *  When FormItem.showPending is true, the Button.baseStyle
     *   used on MultiComboBoxItem.button that are in the "Pending" visual state.
     * 
     *   If unset, then the baseStyle of pending buttons is not changed.
     *  @type {CSSStyleName}
     *  @default "buttonPending"
     */
    open var pendingButtonStyle: String = definedExternally
    /**
     *  When FormItem.showDeletions is true, the Button.baseStyle
     *   used on MultiComboBoxItem.button for values that have been deleted (also called "deselected
     *   buttons").
     * 
     *   If unset, then the baseStyle of deselected buttons is not changed.
     * 
     *   NOTE: Deselected buttons are also disabled, so styling should be provided
     *   for the deselectedButtonStyle&nbsp;+&nbsp;"Disabled" style name.
     *  @type {CSSStyleName}
     *  @default "buttonDeselected"
     */
    open var deselectedButtonStyle: String = definedExternally
    /**
     *  Specifies the layout style of the combo box and the buttons in the MultiComboBoxItem.
     *   Available values are "flow" (the default), "horizontal", "horizontalReverse",
     *   "vertical", and "verticalReverse".
     * 
     * 
     * 
     *  - "flow":&nbsp; The buttons appear to the left of the combo box. When there is no
     *   more room, the combo box and/or buttons flow onto a new line. The buttons autoFit
     *   by default.
     * 
     *  - "horizontal":&nbsp; The combo box appears on right and buttons are horizontally
     *   stacked directly left of it. The buttons must autofit.
     * 
     *  - "horizontalReverse":&nbsp; Like "horizontal" but the combo box appears on the left.
     *   The buttons must autofit.
     * 
     *  - "vertical":&nbsp; The combo box appears on top and buttons are stacked beneath it.
     *   Buttons do not autofit by default.
     * 
     *  - "verticalReverse":&nbsp; Like "vertical" but the combo box appears at bottom.
     *   The buttons do not autofit by default.
     * 
     *  @type {MultiComboBoxLayoutStyle}
     *  @default "flow"
     */
    open var layoutStyle: 
                          /**
                           *  use a FlowLayout, showing values first, then the text entry area
                           *  use a FlowLayout, with the text entry first and values shown afterwards
                           *  Use a horizontal layout with the combo box on the right
                           *  Use a horizontal layout with the combo box on the left
                           *  Use a vertical layout
                           *  Use a vertical layout with the combo box at the bottom
                           */
                          String /* flow |  flowReverse |  horizontal |  horizontalReverse |  vertical |  verticalReverse */ = definedExternally
    /**
     *  Specifies whether to autofit the buttons in the MultiComboBoxItem. The
     *   default value is true if MultiComboBoxItem.layoutStyle is "flow", but false for a
     *   layoutStyle of "vertical" or "verticalReverse". If the layoutStyle
     *   is "horizontal" or "horizontalReverse" then the buttons will autofit regardless
     *   of the setting of this property.
     *  @type {boolean}
     *  @default null
     */
    open var autoFitButtons: Boolean = definedExternally
    /**
     *  Specifies the size of the combo box field.
     * 
     *   Note that this attribute only has an effect in "flow", "horizontal", and
     *   "horizontalReverse" MultiComboBoxItem.layoutStyle. In the other modes, the combo box
     *   is as wide as the overall MultiComboBoxItem.
     *  @type {number}
     *  @default "130"
     */
    open var comboBoxWidth: Number = definedExternally
    /**
     *  Specifies whether to arrange the buttons of the MultiComboBoxItem in the order that they were
     *   selected (the default), or to sort the buttons by MultiComboBoxItem.displayField.
     *  @type {boolean}
     *  @default true
     */
    open var useInsertionOrder: Boolean = definedExternally
    /**
     *   This method will be called whenever this FormItem's value is being set via a programmatic
     *   call to e.g: DynamicForm.setValues or FormItem.setValue and may be
     *   overridden by CanvasItems intended to support displaying data values to update the
     *   embedded Canvas to reflect the value passed in.
     * 
     *   The value of a MultiComboBoxItem to the form is an array of valueField values corresponding
     *   to the selected combo box options.
     * 
     *  @param {any} new display value for the item. This is the value after applying  any custom formatter or valueMap
     *  @param {any} underlying data value for the item
     *  @param {DynamicForm} the dynamicForm in which this item is contained
     *  @param {CanvasItem} the live form item instance
     */
    override fun showValue(displayValue: dynamic, dataValue: dynamic, form: DynamicForm, item: CanvasItem): Unit = definedExternally
    /**
     *  @param {MultiComboBoxLayoutStyle} the new layout style
     */
    open fun setLayoutStyle(layoutStyle: 
                                         /**
                                          *  use a FlowLayout, showing values first, then the text entry area
                                          *  use a FlowLayout, with the text entry first and values shown afterwards
                                          *  Use a horizontal layout with the combo box on the right
                                          *  Use a horizontal layout with the combo box on the left
                                          *  Use a vertical layout
                                          *  Use a vertical layout with the combo box at the bottom
                                          */
                                         String /* flow |  flowReverse |  horizontal |  horizontalReverse |  vertical |  verticalReverse */): Unit = definedExternally
    /**
     *   Sets the MultiComboBoxItem.autoFitButtons property.
     * 
     *  @param {boolean} whether to autofit the buttons
     */
    open fun setAutoFitButtons(autoFitButtons: Boolean): Unit = definedExternally
    /**
     *   Notification method called when FormItem.showPending is enabled and this
     *   MultiComboBoxItem should either clear or show its pending visual state.
     * 
     *   The default behavior is that the FormItem.titleStyle and
     *   FormItem.cellStyle are updated to include/exclude the "Pending" suffix.
     *   In addition, when displayed in the pending state and a
     *   MultiComboBoxItem.pendingButtonStyle is set, then:
     * 
     * 
     *  - If MultiComboBoxItem.useInsertionOrder is false, buttons for
     *     any new values will have their Button.baseStyle set to
     *     pendingButtonStyle; otherwise
     * 
     *  - (useInsertionOrder is true) buttons for values will have their
     *     Button.baseStyle set to pendingButtonStyle if either the
     *     value is new or it is in a different place within the value array.
     * 
     *   Returning false will cancel this default behavior.
     * 
     *  @param {DynamicForm} the managing DynamicForm instance.
     *  @param {FormItem} the form item itself (also available as "this").
     *  @param {boolean} true if the item should show its pending visual state; false otherwise.
     *  @param {any} the current form item value.
     *  @param {any} the value that would be restored by a call to DynamicForm.resetValues.
     */
    override fun pendingStatusChanged(form: DynamicForm, item: FormItem, pendingStatus: Boolean, newValue: dynamic, value: dynamic): Boolean = definedExternally
    companion object {
        /**
         *  The default hint string.
         *  @type {string}
         *  @default "Enter values"
         */
        var defaultHint: String = definedExternally
        /**
         *  Creates a new MultiComboBoxItem
         * 
         *  @param typeCheckedProperties {Partial<MultiComboBoxItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {MultiComboBoxItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): MultiComboBoxItem = definedExternally
    }
}