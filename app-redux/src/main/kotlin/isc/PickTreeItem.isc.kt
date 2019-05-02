@file:JsQualifier("isc")
package isc

/**
 *  FormItem that allows picking a value from a hierarchical data model.
 */
open external class PickTreeItem : CanvasItem {
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
     *  The visible button created by a PickTreeItem is an AutoChild of type
     *   TreeMenuButton by default.
     *  @type {Canvas}
     *  @default null
     */
    open var button: Canvas = definedExternally
    /**
     *  When FormItem.showPending is true, the Button.baseStyle
     *   of the PickTreeItem.button when in the "Pending" visual state.
     * 
     *   If unset, then the baseStyle of the button is not changed.
     *  @type {CSSStyleName}
     *  @default "buttonPending"
     */
    open var pendingButtonStyle: String = definedExternally
    /**
     *  If specified, the tree of possible options will be derived from the dataSource as a
     *   ResultTree, rather than using this.valueTree. Options can be loaded on demand or up
     *   front according tp PickTreeItem.loadDataOnDemand.
     *  @type {DataSource | string}
     *  @default null
     */
    open var dataSource: dynamic = definedExternally
    /**
     *  For a PickTreeItem that uses a DataSource, these properties will be passed to
     *   the automatically-created ResultTree. This can be used for various customizations such as
     *   modifying the automatically-chosen Tree.parentIdField.
     *  @type {Tree}
     *  @default null
     */
    open var dataProperties: Tree = definedExternally
    /**
     *  A Tree of options from which the user can select.
     *  @type {Tree}
     *  @default null
     */
    open var valueTree: Tree = definedExternally
    /**
     *  If this is a databound item, should the load our set of possible options be loaded
     *   on demand (as submenus are displayed), or upfront?
     *  @type {boolean}
     *  @default null
     */
    open var loadDataOnDemand: Boolean = definedExternally
    /**
     *  Specifies an alternative field from which display values should be retrieved for this
     *   item.
     * 
     *   If this item is not databound (PickTreeItem.dataSource is unset), this is
     *   implemented by picking up the value of the specified field from the
     *   PickTreeItem.valueTree.
     * 
     *   Otherwise this item will attempt to map its underlying value to a display value
     *   by retrieving a record from the PickTreeItem.dataSource where the
     *   PickTreeItem.valueField matches this item's value, and displaying the
     *   displayField value from that record.
     *  @type {string}
     *  @default null
     */
    override var displayField: String = definedExternally
    /**
     *  Which field in the tree-data should be returned as this item's value?
     *   If unspecified, the path will be used
     *  @type {string}
     *  @default null
     */
    override var valueField: String = definedExternally
    /**
     *  This message will be displayed as a single, disabled option in any empty menu/submenu
     *   created from this item's data tree.
     *  @type {HTMLString}
     *  @default "No items to display"
     */
    open var emptyMenuMessage: String = definedExternally
    /**
     *  Text to display when this form item has a null or undefined value.
     * 
     *   If the formItem has a databound pickList, and its FormItem.displayField or
     *   FormItem.valueField (if the former isn't set) has an undefined emptyCellValue
     *   field, that field will automatically be set using the emptyDisplayValue property.
     * 
     *   If the emptyDisplayValue is null (the default) then this item will use the standard title
     *   of the tree menu button that is shown when no values are selected.
     *  @type {HTMLString}
     *  @default null
     */
    override var emptyDisplayValue: String = definedExternally
    /**
     *  If this item is FormItem.getCanEdit, how should this item be displayed
     *   to the user? If set, overrides the form-level DynamicForm.readOnlyDisplay default.
     *  @type {ReadOnlyDisplayAppearance}
     *  @default "disabled"
     */
    override var readOnlyDisplay: 
                                  /**
                                   *  Item value should appear within the form as a static block of text, similar to the default appearance of a StaticTextItem. This appearance may be
                                   *   modified via FormItem.readOnlyTextBoxStyle and FormItem.clipStaticValue.
                                   *  Item should appear unchanged, but user interaction to edit the item will be disallowed. Note that some interactions will be allowed, such as selecting text
                                   *   within a read-only TextItem for copy and paste. Exact implementation may vary by
                                   *   form item type.
                                   *  Item will appear disabled.
                                   */
                                  String /* static |  readOnly |  disabled */ = definedExternally
    /**
     *  If true, clicking or pressing Enter on a menu item that has a submenu will
     *   select that item (with standard behavior of hiding the menus, calling click
     *   handlers, etc) instead of showing the submenu.
     *  @type {boolean}
     *  @default null
     */
    open var canSelectParentItems: Boolean = definedExternally
    /**
     *  If set, this FormItem will map stored values to display values as though a
     *   ValueMap were specified, by fetching records from the
     *   specified optionDataSource and extracting the
     *   FormItem.valueField and
     *   FormItem.displayField in loaded records, to derive one
     *   valueMap entry per record loaded from the optionDataSource.
     * 
     *   With the default setting of FormItem.fetchMissingValues, fetches will be initiated against
     *   the optionDataSource any time the FormItem has a non-null value and no corresponding
     *   display value is available. This includes when the form is first initialized, as well
     *   as any subsequent calls to FormItem.setValue, such as may happen when
     *   DynamicForm.editRecord is called. Retrieved values are automatically cached by
     *   the FormItem.
     * 
     *   Note that if a normal, static FormItem.valueMap is also specified for
     *   the field (either directly in the form item or as part of the field definition in the
     *   dataSource), it will be preferred to the data derived from the optionDataSource for
     *   whatever mappings are present.
     * 
     *   In a databound form, if FormItem.displayField is specified for a FormItem and
     *   optionDataSource is unset, optionDataSource will default to
     *   the form's current DataSource
     *  @type {DataSource}
     *  @default null
     */
    override var optionDataSource: dynamic = definedExternally
    /**
     *   Setter to change the PickTreeItem.valueTree at runtime
     * 
     *  @param {Tree} new value tree for the item
     */
    open fun setValueTree(valueTree: Tree): Unit = definedExternally
    /**
     *   Notification method called when FormItem.showPending is enabled and
     *   this PickTreeItem should either clear or show its pending visual state.
     * 
     *   The default behavior is that the FormItem.titleStyle and
     *   FormItem.cellStyle are updated to include/exclude the "Pending" suffix.
     *   In addition, when displayed in the pending state and a
     *   PickTreeItem.pendingButtonStyle is set, then the PickTreeItem.button's
     *   Button.baseStyle is set to pendingButtonStyle.
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
     *   Only applies to databound items (see PickTreeItem.optionDataSource).
     *   Performs a fetch type operation on this item's DataSource to retrieve/refresh the tree
     *   of data displayed as rows in this items menu.
     * 
     */
    open fun fetchData(): Unit = definedExternally
    /**
     *   Setter for PickTreeItem.emptyDisplayValue.
     * 
     * \* @param {HTMLString} 
     */
    open fun setEmptyDisplayValue(emptyDisplayValue: String): Unit = definedExternally
    companion object {
        /**
         *  Creates a new PickTreeItem
         * 
         *  @param typeCheckedProperties {Partial<PickTreeItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {PickTreeItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): PickTreeItem = definedExternally
    }
}