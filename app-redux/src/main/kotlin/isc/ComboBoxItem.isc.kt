@file:JsQualifier("isc")
package isc

/**
 *  The Combobox is a text input field which can show a list of options via a drop-down
 *   PickList.
 * 
 *   The set of options will be filtered based on the current value in the text field, so only
 *   options that match what has been typed so far will be displayed.
 *   The set of options can be derived from a ValueMap or dynamically retrieved from a
 *   dataSource. See the PickList interface for further settings.
 * 
 *   The two most common use cases for ComboBoxItems are:
 * 
 *  - With ComboBoxItem.addUnknownValues set to true, the ComboBoxItem acts as a
 *   freeform text entry field with the picklist providing essentially a set of suggested completions
 *   similar to a URL bar in a web browser.
 * 
 *  - With ComboBoxItem.addUnknownValues set to false, the ComboBoxItem acts similarly
 *   to a SelectItem where a fixed set of options is available to the user and the text entry field
 *   is essentially used to filter which of these options are visible
 * 
 *   Other commonly used settings to configure ComboBoxItem behavior are:
 *   - ComboBoxItem.defaultToFirstOption - this will select the first option from the pickList
 *   as a default value for the item - and
 *   - ComboBoxItem.completeOnTab which causes the
 *   current selection in the pickList (if there is one) to be chosen when the user tabs out of the
 *   field, allowing a user to type a few characters and hit tab to auto-complete to the first matched
 *   option. completeOnTab is automatically set to true if ComboBoxItem.addUnknownValues is
 *   false.
 * 
 *   ComboBoxItem does not provide built-in support for multiple selection. For a Combobox
 *   that does provide such a multiple-select feature use MultiComboBoxItem.
 */
open external class ComboBoxItem : TextItem, PickList {
    /**
     *  Static default value for this ComboBoxItem. To default to the first option use
     *   ComboBoxItem.defaultToFirstOption instead.
     *  @type {boolean}
     *  @default null
     */
    override var defaultValue: Boolean = definedExternally
    /**
     *  Select the first option as the default value for this ComboBoxItem. If options are derived
     *   from a dataSource, the first value returned by the server will be used, otherwise the first
     *   value in the valueMap. If enabled, this setting overrides ComboBoxItem.defaultValue
     *   and ComboBoxItem.defaultDynamicValue.
     *  @type {boolean}
     *  @default false
     */
    open var defaultToFirstOption: Boolean = definedExternally
    /**
     *  If showing a hint for this form item, should it be shown within the field?
     *   CSS style for the hint is SelectItem.textBoxStyle with the suffix
     *   "Hint" appended to it.
     *  @type {boolean}
     *  @default null
     */
    override var showHintInField: Boolean = definedExternally
    /**
     *  Not applicable to a ComboBoxItem.
     *  @type {string}
     *  @default null
     */
    override var mask: String = definedExternally
    /**
     *  Not applicable to a ComboBoxItem.
     *  @type {boolean}
     *  @default null
     */
    override var maskSaveLiterals: Boolean = definedExternally
    /**
     *  Not applicable to a ComboBoxItem.
     *  @type {string}
     *  @default " "
     */
    override var maskPadChar: String = definedExternally
    /**
     *  Not applicable to a ComboBoxItem.
     *  @type {string}
     *  @default "_"
     */
    override var maskPromptChar: String = definedExternally
    /**
     *  Not applicable to a ComboBoxItem.
     *  @type {boolean}
     *  @default null
     */
    override var maskOverwriteMode: Boolean = definedExternally
    /**
     *  Controls where the PickList is placed.
     *   Can be specified as a PanelPlacement
     *   or a specific widget that should be filled (by specifying an actual Canvas or
     *   Canvas.ID).
     * 
     *   Default behavior is to "fillPanel" if Browser.isHandset or
     *   Browser.isTablet, to better accomodate the smaller screen real estate and
     *   less precise
     *   pointing ability on such devices.
     * 
     *   When filling the whole screen, part of the screen or a specific panel, the expanded
     *   interface is created as a FormItem.picker, and
     *   incorporates a ComboBoxItem.pickerNavigationBar and
     *   ComboBoxItem.pickerExitButton that hides the expanded interface, as well
     *   as a separate ComboBoxItem.pickerSearchField.
     *  @type {PanelPlacement | Canvas | string}
     *  @default null
     */
    open var pickListPlacement: dynamic = definedExternally
    /**
     *  For PickList items with PickListItemIconPlacement set such that the pickList does
     *   not render near-origin, should specified FormItem.icons be rendered inline within
     *   the formItem itself, or within the ComboBoxItem.pickerNavigationBar.
     * 
     *   May be overridden at the icon level via FormItemIcon.iconPlacement.
     * 
     *   For mobile browsing with limited available screen space, icons rendered in
     *   the navigation bar may be easier for the user to interact with.
     *  @type {PickListItemIconPlacement}
     *  @default "both"
     */
    override var iconPlacement: 
                                /**
                                 *  icon will be displayed in the ComboBoxItem.pickerNavigationBar only (and not rendered
                                 *   inline within the formItem itself)
                                 *  icon will be displayed inline within the form item itself (and not within the
                                 *   ComboBoxItem.pickerNavigationBar
                                 *  icon will be displayed both inline (within the form item itself) and within the
                                 *   ComboBoxItem.pickerNavigationBar
                                 */
                                String /* pickerNavigationBar |  formItem |  both */ = definedExternally
    /**
     *  The pickerSearchField is a separate TextItem created for
     *   search string entry when ComboBoxItem.pickListPlacement indicates that the search
     *   interface takes over an entire panel or the entire screen.
     * 
     *   The following autoChildUsage apply:
     * 
     * 
     *  - ComboBoxItem.pickerSearchFieldHint for FormItem.hint
     * 
     *  @type {TextItem}
     *  @default null
     */
    open var pickerSearchField: TextItem = definedExternally
    /**
     *  FormItem.hint for the ComboBoxItem.pickerSearchField.
     *  @type {HTMLString}
     *  @default "Search"
     */
    open var pickerSearchFieldHint: String = definedExternally
    /**
     *  FormItem.hint for the ComboBoxItem.pickerSearchField when the combobox is configured to
     *   ComboBoxItem.addUnknownValues
     *  @type {HTMLString}
     *  @default "Search or enter new value"
     */
    open var pickerSearchOrNewValueFieldHint: String = definedExternally
    /**
     *  Form that contains the ComboBoxItem.pickerSearchField.
     *  @type {DynamicForm}
     *  @default null
     */
    open var pickerSearchForm: DynamicForm = definedExternally
    /**
     *  NavigationButton to dismiss the picker interface, created when
     *   ComboBoxItem.pickListPlacement indicates that the search interface takes over the
     *   entire panel or screen.
     * 
     *   The following autoChildUsage apply:
     * 
     * 
     *  - ComboBoxItem.pickerExitButtonTitle for Button.title
     * 
     *  @type {NavigationButton}
     *  @default null
     */
    open var pickerExitButton: NavigationButton = definedExternally
    /**
     *  The title for the ComboBoxItem.pickerExitButton.
     *  @type {HTMLString}
     *  @default "Cancel"
     */
    open var pickerExitButtonTitle: String = definedExternally
    /**
     *  NavigationButton to dismiss the picker interface and store out the
     *   value entered in the ComboBoxItem.pickerSearchField, created when
     *   ComboBoxItem.pickListPlacement indicates that the search interface takes over the
     *   entire panel or screen.
     * 
     *   This button will only be shown when ComboBoxItem.addUnknownValues is true.
     * 
     *   The following autoChildUsage apply:
     * 
     * 
     *  - ComboBoxItem.pickerSaveButtonTitle for Button.title
     * 
     *  @type {NavigationButton}
     *  @default null
     */
    open var pickerSaveButton: NavigationButton = definedExternally
    /**
     *  The title for the ComboBoxItem.pickerSaveButton.
     *  @type {HTMLString}
     *  @default "Accept"
     */
    open var pickerSaveButtonTitle: String = definedExternally
    /**
     *  Empty message to display in the comboboxItem if PickList.hideEmptyPickList
     *   is false.
     *  @type {string}
     *  @default "No items to show"
     */
    override var emptyPickListMessage: String = definedExternally
    /**
     *  NavigationBar created when ComboBoxItem.pickListPlacement indicates that the search
     *   interface takes over the entire panel or screen.
     *  @type {NavigationBar}
     *  @default null
     */
    open var pickerNavigationBar: NavigationBar = definedExternally
    /**
     *  Indicates whether or not this ComboBoxItem will load its list of options
     *   DataSource.progressiveLoading. This property is copied onto the
     *   underlying PickList.
     *  @type {boolean}
     *  @default true
     */
    open var progressiveLoading: Boolean = definedExternally
    /**
     *  Should we show a special 'picker' FormItemIcon for this form item? Picker
     *   icons are customizable via FormItem.pickerIconProperties. By default
     *   they will be rendered inside the form item's FormItem.controlStyle
     *   area. By default clicking the pickerIcon will call FormItem.showPicker.
     *  @type {boolean}
     *  @default true
     */
    override var showPickerIcon: Boolean = definedExternally
    /**
     *  If ComboBoxItem.showPickerIcon is true for this item, this property governs the
     *   size of the picker icon. If unset, the picker icon will be sized as a square to fit in the
     *   available height for the icon.
     * 
     *   Note that if spriting is being used, and the image to be displayed is specified
     *   using css properties such as background-image, background-size,
     *   changing this value may result in an unexpected appearance as the image will not
     *   scale.
     *   Scaleable spriting can be achieved using the SCSpriteConfig format.
     *   See the section on spriting in the skinning for
     *   further information.
     *  @type {Integer}
     *  @default "15"
     */
    override var pickerIconWidth: Number = definedExternally
    /**
     *  Don't specify an explicit height for the picker icon - instead have it size to match the
     *   height of the combo box item.
     *  @type {Integer}
     *  @default null
     */
    override var pickerIconHeight: Number = definedExternally
    /**
     *  If ComboBoxItem.showPickerIcon is true for this item, this property governs the
     *   FormItemIcon.src of the picker icon image to be displayed.
     * 
     *   When skinning is enabled, this property will not
     *   be used to locate an image, instead, the image is drawn via CSS based on the
     *   FormItem.pickerIconStyle property.
     *  @type {SCImgURL}
     *  @default "[SKIN]/DynamicForm/ComboBoxItem_PickButton_icon.gif"
     */
    override var pickerIconSrc: String = definedExternally
    /**
     *  Should the list of options be displayed whenever the user types into the
     *   combo-box textArea, or only when the user clicks on the pick button or uses the
     *   explicit Alt+Arrow Down key combination?
     *  @type {boolean}
     *  @default true
     */
    open var showPickListOnKeypress: Boolean = definedExternally
    /**
     *  ComboBox items will submit their containing form on enter keypress
     *   if DynamicForm.saveOnEnter is true. Setting this property to
     *   false will disable this behavior.
     * 
     *   Note that if the drop down list of options (pickList) is visible an
     *   Enter keypress is used to select a value from the available set of
     *   options and will not automatically cause form submission.
     *  @type {boolean}
     *  @default true
     */
    override var saveOnEnter: Boolean = definedExternally
    /**
     *  If true, when the pickList is showing, the user can select the current value by hitting
     *   the Tab key.
     * 
     *   Note that completeOnTab is not compatible with ComboBoxItem.formatOnBlur
     *  @type {boolean}
     *  @default null
     */
    open var completeOnTab: Boolean = definedExternally
    /**
     *  With formatOnBlur enabled, this comboBoxItem will format its value
     *   according to the rules described in FormItem.mapValueToDisplay as long as the
     *   item does not have focus. Once the user puts focus into the item
     *   the formatter will be removed. This provides a simple way for developers to
     *   show a nicely formatted display value in a freeform text field, without the need
     *   for an explicit FormItem.formatEditorValue
     *   and FormItem.parseEditorValue pair.
     * 
     *   Note that this attribute is not compatible with ComboBoxItem.completeOnTab
     *  @type {boolean}
     *  @default false
     */
    override var formatOnBlur: Boolean = definedExternally
    /**
     *  A set of "special" values such as "All", "None" or "Invalid" that do not appear in the normal
     *   ValueMap or in the data returned by the ComboBoxItem.optionDataSource.
     * 
     *   Like other uses of ValueMap, either a list of values or a mapping from stored to
     *   display value can be provided.
     * 
     *   These values can either be shown at the top of the list of values (in the order specified), or
     *   can be shown in a separate, non-scrolling region - the setting
     *   SelectItem.separateSpecialValues controls this. Note that data
     *   paging can only be used if separateSpecialValues is enabled.
     * 
     *   If specialValues are configured, SelectItem.allowEmptyValue is ignored - an empty
     *   value, if desired, must be included in the specialValues. To provide a
     *   specialValue which clears the value of the field, use the special constant
     *   PickList.emptyStoredValue.
     * 
     *   specialValues can also be used to take a value that does appear in the
     *   normal data and redundantly display it at the top of the list to make it more accessible. Note
     *   that in this case it is expected that the special value appears both at the top of the
     *   list and in it's normal position in the list, so this works best with
     *   SelectItem.separateSpecialValues mode enabled.
     * 
     *   Also, if an ComboBoxItem.optionDataSource is used, ComboBoxItem.specialValues that appear in the normal
     *   dataset will be updated by automatic cacheSync (if
     *   the ComboBoxItem.displayField is updated). However when using a distinct ComboBoxItem.valueField and
     *   ComboBoxItem.displayField, you are required to provide ComboBoxItem.specialValues as a map (there is no
     *   support for FormItem.fetchMissingValues automatically fetching appropriate display values).
     * 
     *   Note that specialValues are not supported in conjunction with MultiComboBoxItem. Whereas with
     *   SelectItem.multiple, specialValues will never be normal values
     *   that may be selected. So, specialValues should have options such as "Select All", "Select None" and others.
     *  @type {ValueMap}
     *  @default null
     */
    override var specialValues: dynamic = definedExternally
    /**
     *  If true, ComboBoxItem.specialValues special values such as the empty value will be shown in a
     *   separate non-scrolling area, in the ComboBoxItem.separateValuesList. Aside from making these values
     *   more easily accessible, showing them in a separate list allows data paging to be used, which is
     *   disabled if the separateValues are shown in the normal drop-down list along with other values.
     *  @type {boolean}
     *  @default null
     */
    open var separateSpecialValues: Boolean = definedExternally
    /**
     *  AutoChild used to show ComboBoxItem.specialValues.
     *  @type {ListGrid}
     *  @default null
     */
    open var separateValuesList: ListGrid = definedExternally
    /**
     *  This property controls whether the user can enter a value that is not present in the
     *   set of options for this item.
     * 
     *   If set to false, the value the user enters in the text box is essentially used to filter the
     *   set of options displayed in the pickList.
     * 
     *   In this mode, when focus is taken from the field, if the entered value does not match
     *   any entries in the ValueMap or ComboBoxItem.optionDataSource, it will be discarded. Note
     *   that in this mode, ComboBoxItem.completeOnTab behavior is automatically enabled
     *   so if the user enters a valid partial value such that one or more options is displayed in
     *   the pickList, and hits the Tab key, the first matching option will be chosen automatically.
     *   In this mode the user may also hit the "Escape" key to discard their edits.
     * 
     *   Note also that when addUnknownValues is set to false, the underlying value
     *   returned by FormItem.getValue will not be updated until a value is explicitly chosen. This
     *   means any change or changed handlers will not fire directly in response to the user typing
     *   in the field - they will fire when the user actually selects a value, or takes focus from
     *   the field.
     * 
     *   If this property is set to true, the user is not limited to entering values present in
     *   the set of options for the item. Instead the set of options essentially become a set of
     *   suggestions that may be used, or the user can enter an entirely new value.
     *  @type {boolean}
     *  @default true
     */
    open var addUnknownValues: Boolean = definedExternally
    /**
     *  If ComboBoxItem.addUnknownValues is false, this property
     *   determines whether
     *   the user can clear the comboBoxItem value, or whether they are constrained to
     *   choosing one of the available options (in which case clearing the text box will
     *   simply revert to the last picked value when the user leaves the field).
     * 
     *   See also ComboBoxItem.specialValues as a way of providing several different special values in
     *   addition to an empty value, such as "Invalid". Note that setting
     *   specialValues disables the use of allowEmptyValue - see
     *   details of how to have an empty value while using specialValues in
     *   in ComboBoxItem.specialValues.
     *  @type {boolean}
     *  @default true
     */
    open var allowEmptyValue: Boolean = definedExternally
    /**
     *  Optional "pending" style for this item's text box.
     * 
     *   If ComboBoxItem.addUnknownValues is false, when the user modifies the
     *   value displayed in the combobox item text box, the underlying data value (as returned
     *   from item.getValue()) is not immediately updated - instead the value is used to filter
     *   the set of results displayed in the comboBoxItem pickList.
     * 
     *   While the comboBoxItem is in this pending state (where the result of getEnteredValue() will
     *   not necessarily match the display value for whatever is returned by getValue()), the
     *   pendingTextBoxStyle may be applied to the text box for the item.
     * 
     *   When the element value is updated to display the actual value for the item (typically due
     *   to the user selecting a value from the pickList), the standard
     *   TextItem.textBoxStyle will be reapplied.
     * 
     *   May be left unset in which case the standard text box style is always applied.
     *   Has no effect if ComboBoxItem.addUnknownValues is true.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var pendingTextBoxStyle: String = definedExternally
    /**
     *  The Class to use when creating a picker of PickList.dataSetType for
     *   a FormItem. Must be a subclass of the builtin default,
     *   PickListMenu.
     *  @type {SCClassName}
     *  @default "PickListMenu"
     */
    override var pickListConstructor: String = definedExternally
    /**
     *  The Class to use when creating a picker of PickList.dataSetType for
     *   a FormItem. Must be a subclass of the builtin default,
     *   PickTreeMenu.
     *  @type {SCClassName}
     *  @default "PickTreeMenu"
     */
    override var pickTreeConstructor: String = definedExternally
    /**
     *  Whether to show the picker as a flat list, or a collapsible tree.
     * 
     *   The default value, "list", will use an instance of the
     *   PickList.pickListConstructor as the picker - "tree" will
     *   show an instance of PickList.pickTreeConstructor.
     *  @type {string}
     *  @default "list"
     */
    override var dataSetType: String = definedExternally
    /**
     *  If set, this FormItem will derive data to show in the PickList by fetching records from
     *   the specified optionDataSource. The fetched data will be used as a
     *   FormItem.valueMap by extracting the
     *   FormItem.valueField and FormItem.displayField in
     *   the loaded records, to derive one valueMap entry per record loaded from the
     *   optionDataSource. Multiple fields from the fetched data may be shown in the pickList by
     *   setting ComboBoxItem.pickListFields.
     * 
     *   The data will be retrieved via a "fetch" operation on the DataSource, passing the
     *   PickList.pickListCriteria (if set) as criteria, and passing
     *   ComboBoxItem.optionFilterContext (if set) as DSRequest Properties.
     * 
     *   The fetch will be triggered when the pickList is first shown, or, you can set
     *   SelectItem.autoFetchData to fetch when the FormItem is
     *   first drawn.
     * 
     *   Note that providing an initial value when
     *   FormItem.fetchMissingValues is enabled, or enabling
     *   SelectItem.defaultToFirstOption, can also cause a fetch to
     *   be initiated immediately upon form creation. You can also call PickList.fetchData
     *   at any time to manually trigger a fetch.
     * 
     *   Data paging is automatically enabled if the optionDataSource supports it. As the
     *   pickList is scrolled by the user, requests for additional data will be automatically
     *   issued.
     * 
     *   For a pickList attached to a ComboBoxItem, new fetches are
     *   issued as the user types, with criteria set as described under
     *   ComboBoxItem.getPickListFilterCriteria.
     *   If your dataSource is not capable of filtering results by search criteria (eg, the
     *   dataSource is backed by an XML flat file), you can set ComboBoxItem.filterLocally to have the
     *   entire dataset loaded up front and filtering performed in the browser. This disables
     *   data paging.
     * 
     *   Note that if a normal, static FormItem.valueMap is also specified
     *   for the field (either directly in the form item or as part of the field definition in
     *   the dataSource), it will be preferred to the data derived from the optionDataSource for
     *   whatever mappings are present.
     *  @type {DataSource | string}
     *  @default null
     */
    override var optionDataSource: dynamic = definedExternally
    /**
     *  This property allows the developer to specify which field[s] will be displayed in the
     *   drop down list of options.
     * 
     *   Only applies to databound pickLists (see PickList.optionDataSource, or pickLists
     *   with custom data set up via the advanced PickList.getClientPickListData method.
     * 
     *   If this property is unset, we display the PickList.displayField, if specified,
     *   otherwise the PickList.valueField.
     * 
     *   If there are multiple fields, column headers will be shown for each field, the
     *   height of which can be customized via the PickList.pickListHeaderHeight attribute.
     * 
     *   Each field to display should be specified as a ListGridField object. Note that
     *   unlike in ListGrid, dataSource fields marked as
     *   DataSourceField.hidden will be hidden by default in pickLists. To
     *   override this behavior, ensure that you specify an explicit value for
     *   ListGridField.showIf.
     *  @type {Array<Partial<ListGridField>>}
     *  @default null
     */
    override var pickListFields: Array<dynamic> = definedExternally
    /**
     *  For databound pickLists (see PickList.optionDataSource), by default SmartClient
     *   will cache and re-use datasets shown by different pickLists displayed by different
     *   SelectItems in an LRU (least recently used) caching pattern.
     * 
     *   Setting this flag to false avoids this caching for situations where it is too
     *   aggressive.
     * 
     *   Note that this does not control re-use of data within a single pickList. To
     *   control when client-side filtering is used in ComboBoxItem, see
     *   ComboBoxItem.useClientFiltering and ComboBoxItem.filterLocally.
     *  @type {boolean}
     *  @default true
     */
    override var cachePickListResults: Boolean = definedExternally
    /**
     *  If this item has a specified optionDataSource and this property is
     *   true, the list of fields used by this pickList will be passed to
     *   the datasource as DSRequest.outputs. If the datasource supports this feature
     *   the returned fields will be limited to this list. A custom datasource will need to
     *   add code to implement field limiting.
     * 
     *   This list of used fields consists of the values of FormItem.valueField,
     *   FormItem.displayField and ComboBoxItem.pickListFields.
     * 
     *   NOTE: When enabled, FormItem.getSelectedRecord will only include the
     *   fetched fields.
     *  @type {boolean}
     *  @default null
     */
    override var fetchDisplayedFieldsOnly: Boolean = definedExternally
    /**
     *  If this item has a specified optionDataSource, and this property is not
     *   null, this will be passed to the datasource as DSRequest properties when
     *   performing the filter operation on the dataSource to obtain the set of options for the
     *   list. This provides, among other capabilities, a way to trigger the server to return
     *   summary records.
     *  @type {DSRequest}
     *  @default null
     */
    override var optionFilterContext: DSRequest = definedExternally
    /**
     *  If this item has a specified optionDataSource, this attribute may be set
     *   to specify an explicit DSRequest.operationId when performing a fetch against the
     *   option dataSource to pick up display value mapping.
     *  @type {string}
     *  @default null
     */
    override var optionOperationId: String = definedExternally
    /**
     *  If set, this item will display a value from another field to the user instead of
     *   showing the underlying data value for the FormItem.name.
     * 
     *   This property is used in two ways:
     * 
     *   The item will display the displayField value from the
     *   DynamicForm.getValues if
     *   FormItem.useLocalDisplayFieldValue is true, (or if unset and the conditions
     *   outlined in the documentation for that property are met).
     * 
     *   If this field has an FormItem.optionDataSource, this property is used by
     *   default to identify which value to use as a display value in records from this
     *   related dataSource. In this usage the specified displayField must be
     *   explicitly defined in the optionDataSource to be used - see
     *   ComboBoxItem.getDisplayFieldName for more on this behavior.
     *   If not using FormItem.useLocalDisplayFieldValue, the display
     *   value for this item will be derived by performing a fetch against the
     *   FormItem.getOptionDataSource
     *   to find a record where the FormItem.getValueFieldName matches
     *   this item's value, and use the displayField value from that record.
     *   In addition to this, PickList-based form items that provide a list of possible
     *   options such as the SelectItem or ComboBoxItem will show the
     *   displayField values to the user by default, allowing them to choose
     *   a new data value (see FormItem.valueField) from a list of user-friendly
     *   display values.
     * 
     *   This essentially allows the specified optionDataSource to be used as
     *   a server based valueMap.
     * 
     *   If FormItem.useLocalDisplayFieldValue
     *   are being used and FormItem.storeDisplayValues is true, selecting a new value
     *   will update both the value for this field and the associated display-field value
     *   on the record being edited.
     * 
     *   Note: Developers may specify the FormItem.foreignDisplayField property
     *   in addition to displayField. This is useful for cases where the
     *   display field name in the local dataSource differs from the display field name in
     *   the optionDataSource. See the documentation for
     *   DataSourceField.foreignDisplayField for more on this.
     * 
     *   Note that if optionDataSource is set and no valid display field is
     *   specified,
     *   FormItem.getDisplayFieldName will return the dataSource title
     *   field by default.
     * 
     *   If a displayField is specified for a freeform text based item (such as a
     *   ComboBoxItem), any user-entered value will be treated as a display value.
     *   In this scenario, items will derive the data value for the item from the
     *   first record where the displayField value matches the user-entered value.
     *   To avoid ambiguity, developers may wish to avoid this usage if display values
     *   are not unique.
     *  @type {string}
     *  @default null
     */
    override var displayField: String = definedExternally
    /**
     *  If this form item maps data values to display values by retrieving the
     *   FormItem.displayField values from an
     *   FormItem.optionDataSource, this property
     *   denotes the the field to use as the underlying data value in records from the
     *   optionDataSource.
     *   If not explicitly supplied, the valueField name will be derived as
     *   described in FormItem.getValueFieldName.
     *  @type {string}
     *  @default null
     */
    override var valueField: String = definedExternally
    /**
     *  If filterLocally is set for this item, and this item is showing options
     *   from a dataSource, fetch the entire set of options from the server, and use these values
     *   to map the item value to the appropriate display value. Also use "local"
     *   type filtering on drop down list of options.
     * 
     *   This means data will only be fetched once from the server, and then filtered on the
     *   client.
     * 
     *   Note - when this property is set to false, filtering will still be
     *   performed on the client if a complete set of data for some criteria has been cached
     *   by a fetch, and a subsequent fetch has more restrictive criteria. To explicitly
     *   disable client-side filtering set the ComboBoxItem.useClientFiltering property to false.
     *  @type {boolean}
     *  @default false
     */
    override var filterLocally: Boolean = definedExternally
    /**
     *  If this item has a databound pickList (for example PickList.optionDataSource is
     *   set), this property can be used to provide static filter criteria when retrieving the data
     *   for the pickList.
     *  @type {Criteria}
     *  @default null
     */
    override var pickListCriteria: dynamic = definedExternally
    /**
     *  If this item is part of a databound form, and has a specified valueMap,
     *   by default we show the valueMap options in the pickList for the item.
     *   Setting this property to true will ensure that the options displayed in our pickList
     *   are derived from the form's dataSource.
     *  @type {boolean}
     *  @default null
     */
    override var showOptionsFromDataSource: Boolean = definedExternally
    /**
     *  If specified this properties block will be applied to the PickListMenu
     *   created for this FormItem.
     * 
     *   Note: Not every ListGrid property is supported when assigned to a pickList.
     *   Where there is a dedicated API on the form item (such as
     *   PickList.pickListCellHeight), we recommend that be used in
     *   favor of setting the equivalent property on the pickListProperties block.
     * 
     *   PickLists and ListGrid.showFilterEditor:
     *   ComboBoxItem do not support setting showFilterEditor
     *   to true on pickListProperties. This combination of settings leads to an ambiguous user
     *   exprience as the two sets of filter-criteria (those from the text-box and those from the
     *   pickList filter editor) interact with each other.
     *   SelectItem.pickListProperties is a valid way to create a filterable pickList, on
     *   a SelectItem, but this setting is not supported on a SelectItem with
     *   SelectItem.multiple set to true - this combination of settings can cause a
     *   selected value to be filtered out of view at which point further selection changes will
     *   discard that value.
     *   In general we recommend the ComboBoxItem class (with ComboBoxItem.addUnknownValues
     *   set as appropriate) as a better interface for filtering pickList data.
     *  @type {ListGrid}
     *  @default null
     */
    override var pickListProperties: ListGrid = definedExternally
    /**
     *  Specifies one or more fields by which this item should be initially sorted. It can be
     *   a ListGridField.name, or an array of field names - but note that, if
     *   multiple fields are supplied, then each will be sorted in the same
     *   ListGrid.sortDirection.
     * 
     *   For full sorting control, set PickList.initialSort to a list of
     *   custom SortSpecifier.
     * 
     *   This attribute can also be set to the index of a field in the fields array, but note
     *   that it will be converted to a string (field name) after initialization.
     *  @type {string | Array<Partial<string>> | Integer}
     *  @default null
     */
    override var sortField: dynamic = definedExternally
    /**
     *  An array of SortSpecifier objects used to set up the initial sort configuration
     *   for this pickList. If specified, this will be used instead of any
     *   PickList.sortField specified.
     *  @type {Array<Partial<SortSpecifier>>}
     *  @default null
     */
    override var initialSort: Array<dynamic> = definedExternally
    /**
     *  When this item is showing a PickList.dataSetType, this is
     *   the SelectItem.valueField of the record to use as the
     *   Tree.rootValue node.
     *  @type {string | number}
     *  @default null
     */
    override var rootNodeId: dynamic = definedExternally
    /**
     *  When this item is showing a PickList.dataSetType, which
     *   nodes should be opened automatically. Options are:
     * 
     * 
     *  - "none" - no nodes are opened automatically
     * 
     *  - "root" - opens the PickList.rootNodeId - in databound
     *         tree-pickers, this node is always hidden
     * 
     *  - "all" - when ResultTree.loadDataOnDemand, opens the
     *         PickList.rootNodeId and all of it's direct
     *         descendants - otherwise, opens all loaded nodes
     * 
     *  @type {string}
     *  @default "none"
     */
    override var autoOpenTree: String = definedExternally
    /**
     *  If this combo box retrieves its options from a dataSource, should options
     *   be fetched from the server when the item is first written out, or should this fetch be
     *   delayed until the user opens the pickList.
     *  @type {boolean}
     *  @default false
     */
    open var autoFetchData: Boolean = definedExternally
    /**
     *  Read-only property set by the ComboBoxItem to indicate whether we should use the
     *   current typed-in value as part of the filter criteria returned by
     *   ComboBoxItem.getPickListFilterCriteria. You can check this flag in order to
     *   mimic the ComboBoxItem's default behavior if you provide a custom implementation of
     *   getPickListFilterCriteria().
     *  @type {boolean}
     *  @default "varies"
     */
    open var filterWithValue: Boolean = definedExternally
    /**
     *  As the user types into this item's textBox, a comboBoxItem will show the
     *   pick-list of options, and filter the set of results displayed by the current value in the
     *   text box. For a databound comboBoxItem, by default the entered value is filtered against
     *   the ComboBoxItem.displayField if one is specified, otherwise the
     *   ComboBoxItem.valueField.
     * 
     *   This attribute allows the developer to explicitly change which fields to filter against,
     *   causing the user-entered text to be matched against any of the specified set of fields from
     *   the ComboBoxItem.optionDataSource.
     * 
     *   This essentially causes ComboBoxItem.getPickListFilterCriteria to return an AdvancedCriteria
     *   object representing "field1 starts with value or field2 starts with value or ...". The
     *   OperatorId used is controlled by TextMatchStyle as usual, that is,
     *   "startsWith" implies the operator "iStartsWith, "substring" implies "iContains" and "exact"
     *   implies "iEquals".
     * 
     *   The most common use case for this setting would be when a comboBoxItem is showing multiple
     *   ComboBoxItem.pickListFields - if the same set of fields is specified as
     *   ComboBoxItem.filterFields, the user can use the text-box to filter against
     *   whichever fields are visible in the pickList.
     * 
     *   For finer grained control over comboBoxItem filtering, the
     *   ComboBoxItem.getPickListFilterCriteria method may be overridden.
     * 
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var filterFields: Array<dynamic> = definedExternally
    /**
     *  For ComboBoxItem.optionDataSource items, this property will be passed
     *   to the generated ResultSet data object for the pickList as ResultSet.useClientFiltering.
     *   Setting to false will disable filtering on the client and ensure criteria are
     *   always passed to the DataSource directly.
     *  @type {boolean}
     *  @default null
     */
    override var useClientFiltering: Boolean = definedExternally
    /**
     *  Minimum length in characters before a search is performed. If too few characters
     *   are entered the pick list shows ComboBoxItem.searchStringTooShortMessage.
     *  @type {Integer}
     *  @default null
     */
    open var minimumSearchLength: Number = definedExternally
    /**
     *  Message to display in pick list when ComboBoxItem.minimumSearchLength characters have not been entered.
     *  @type {string}
     *  @default "Enter a longer search string to search"
     */
    open var searchStringTooShortMessage: String = definedExternally
    /**
     *  When applying filter criteria to pickList data, what type of matching to use.
     * 
     *   For a databound pickList (ComboBoxItem.optionDataSource set), textMatchStyle is
     *   sent to the server as DSRequest.textMatchStyle.
     * 
     *   For a non-databound pickList, textMatchStyle is applied by
     *   PickList.filterClientPickListData.
     *  @type {TextMatchStyle}
     *  @default "startsWith"
     */
    override var textMatchStyle: 
                                 /**
                                  *  case-insensitive exact match ("foo" matches "foo" and "FoO", but not "FooBar")
                                  *  case-sensitive exact match ("foo" matches only "foo")
                                  *  case-insenstive substring match ("foo" matches "foobar" and "BarFoo")
                                  *  case-insensitive prefix match ("foo" matches "FooBar" but not "BarFoo")
                                  *   textMatchStyle behavior is consistent across the client and all three of the built-in
                                  *   server DataSource implementations - SQL, Hibernate and JPA - to the maximum extent that is
                                  *   practical. Known inconsistencies, some of which can be tweaked with configuration settings,
                                  *   are described below
                                  * 
                                  *  - textMatchStyle can be disabled for any individual field with the
                                  *   DataSourceField.ignoreTextMatchStyle declaration. This behavior is consistent
                                  *   across client and server implementations, with the proviso that case-sensitive behavior
                                  *   is inherently inconsistent in the server-side implementations (see below for a more
                                  *   detailed discussion of this)
                                  * 
                                  *  - textMatchStyle is forced to "exactCase" for DataSourceField.primaryKey
                                  *   fields on update and remove operations, unless
                                  *   OperationBinding.allowMultiUpdate is in force. This means that a normal update
                                  *   or remove operation - which is constrained by a unique primaryKey value or combination, to
                                  *   affect only a single data row - will use an equality match on all primaryKey fields. This
                                  *   is desirable because it makes index usage more likely. Note that this means the key values
                                  *   "foo" and "FOO" are distinct, which is a change from previous behavior. For most databases,
                                  *   this change will have no effect because most databases do not by default allow primaryKey
                                  *   values that only differ in case anyway - if a table has a row with a PK of "foo" and you
                                  *   try to insert a row with a PK of "FOO", most databases will fail with a constraint violation.
                                  *   However, if you are using a database hat allows key values that differ only in case, and you
                                  *   need to support this for some reason, you can switch the framework back to the previous
                                  *   behavior by setting property allow.case.sensitive.pks to true in
                                  *   your server.properties file. Note, we do not recommend this; in fact, we do
                                  *   not recommend the use of text primaryKey fields at all. Where you have control ,we would
                                  *   always recommend the use of automatically incrementing numeric sequence keys.
                                  * 
                                  *  - textMatchStyle does not apply to boolean or temporal (date, datetime, time)
                                  *   DataSourceField.type. Such fields are always checked for equality. If
                                  *   you have a need for more complex matching, such as date-range checking, use AdvancedCriteria
                                  * 
                                  *  - Critiera values for temporal fields must be real dates (Javascript Date
                                  *   objects on the client, instances of java.util.Date on the server). Attempting
                                  *   to match against a string or any other type of value will result in an "always fails"
                                  *   clause being generated. This behavior is how the client code has always worked, but is a
                                  *   change for the server-side DataSources, in the interests of consistency. The previous
                                  *   behavior was:
                                  * 
                                  *  - SQLDataSource used to attempt to match the date column to the criteria value provided;
                                  *    if that value was an appropriately-formatted string, that attempt might have
                                  *    worked, but it would be database-specific. If you have an application that depends on
                                  *    this old behavior, you can switch it back on by adding the following to your
                                  *    server.properties file:
                                  *    sql.temporal.fields.require.date.criteria: false
                                  * 
                                  *  - HibernateDataSource and JPADataSource used to skip such clauses altogether, which
                                  *    results in the opposite behavior (there is an implied "always succeeds" clause, because
                                  *    the clause is not present in the query at all). If you have an application that depends on
                                  *    this old behavior, you can switch it back on by adding the following to your
                                  *    server.properties file:
                                  *    jpa.temporal.fields.require.date.criteria: false or
                                  *    hibernate.temporal.fields.require.date.criteria: false, as appropriate
                                  * 
                                  * 
                                  *  - textMatchStyle does not apply to fields used in the joins generated to satisfy
                                  *   DataSourceField.includeFrom declarations or entity relations in
                                  *   Hibernate or JPA. Again, such comparisons are always for equality
                                  * 
                                  *  - textMatchStyle is applied to numeric fields only if the supplied criteria value
                                  *   is a string. So for a numeric field "myNumber", we will match 10, 100, 110 and 1000 if a
                                  *   criteria value of "10" (the quoted string) is supplied, but we will only match 10 if a
                                  *   criteria value of 10 (the actual number) is supplied
                                  * 
                                  *  - This is a change in behavior for the server-side DataSource implementations, in the
                                  *    interests of consistency with the client behavior. Previously, all three of the built-in
                                  *    DataSource implementations applied textMatchStyle to numeric fields regardless of the
                                  *    criteria value's type. If you have an application that depends on this old behavior,
                                  *    you can switch it back on by adding the following to your server.properties
                                  *    file: sql.substring.numeric.criteria: true or
                                  *    hibernate.substring.numeric.criteria: true or
                                  *    jpa.substring.numeric.criteria: true, as appropriate
                                  * 
                                  * 
                                  *  - "exactCase" matching cannot be made consistent across all database providers because
                                  *   each database has its own idea of whether case-sensitive matching should be the default,
                                  *   and how to switch it on and off (if that is even possible)
                                  * 
                                  *  - Microsoft SQL Server must have case-sensitive matching enabled by setting a
                                  *    case-sensitive collation when the database is created (there are more fine-grained
                                  *    options, but we do not recommend them because of the scope for further inconsistency,
                                  *    where "exactCase" works correctly on table A but not on table B). See
                                  *    MSDN for details
                                  * 
                                  *  - HSQLDB has case sensitivity set with the SET IGNORECASE directive -
                                  *    see here
                                  * 
                                  *  - MySQL is case-insensitive, but since it provides an easy way to do per-query,
                                  *    case-sensitive matching in SQL, we work around it for that database, but only in
                                  *    SQL DataSources
                                  * 
                                  * 
                                  *  - If you are using Hibernate or JPA, whether "exactCase" works as expected depends
                                  *   entirely on the underlying database. Unlike the SQL DataSource, where we have fine-grained
                                  *   control of the SQL that the database executes, we are constrained by what the ORM will
                                  *   allow. This prevents us from compensating for database quirks, like we do with MySQL's
                                  *   case-insensitivity in the SQL DataSource
                                  * 
                                  */
                                 String /* exact |  exactCase |  substring |  startsWith */ = definedExternally
    /**
     *  If true, even non-matching options will be shown, with configurable
     *   ComboBoxItem.separatorRows in between. Not valid for
     *   ComboBoxItem.optionDataSource.
     *  @type {boolean}
     *  @default null
     */
    override var showAllOptions: Boolean = definedExternally
    /**
     *  Array of records to show between matching and non-matching rows in the PickList.
     * 
     *   Not valid for ComboBoxItem.optionDataSource.
     *  @type {Array<Partial<ListGridRecord>>}
     *  @default "[{isSeparator:true}]"
     */
    override var separatorRows: Array<dynamic> = definedExternally
    /**
     *  When a comboBoxItem is used to generate search criteria in a SearchForm this property
     *   governs whether, if the user explicitly chose an option from the pickList, we explicitly
     *   generate criteria that will search for an exact match against the chosen value.
     * 
     *   In order to achieve this, when this property is set to true, this item will generate
     *   AdvancedCriteria in its ComboBoxItem.getCriterion method
     *   .
     * 
     *   See ComboBoxItem.shouldGenerateExactMatchCriteria for behavior when this flag is unset.
     *  @type {boolean}
     *  @default null
     */
    open var generateExactMatchCriteria: Boolean = definedExternally
    /**
     *  The standard FormItem.allowExpressions behavior is always disabled for
     *   ComboBoxItem.
     * 
     *   The interface is not compatible with the allowExpressions feature.
     *   A ComboBoxItem normally starts fetching matches as you type, and that mixes
     *   very strangely with the idea of entering expressions like "a..b"
     *   - you will have the ComboBox seemingly switching back and forth between treating
     *   the text as a normal search string vs as a special expression on a per-keystroke
     *   basis.
     * 
     *   We recommend a normal TextItem as the correct UI element to supply for users to
     *   enter filter expressions.
     *  @type {boolean}
     *  @default null
     */
    override var allowExpressions: Boolean = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "SelectItemEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
    /**
     *  Maximum height to show the pick list before it starts to scroll.
     *   Note that by default the pickList will be sized to the height required by its content
     *   so it will be taller when more rows are available as selectable options
     *  @type {number}
     *  @default "300"
     */
    override var pickListHeight: Number = definedExternally
    /**
     *  Height for an empty pick list (showing the empty message), if the pick list has no
     *   records and PickList.hideEmptyPickList is false.
     *  @type {number}
     *  @default "100"
     */
    override var emptyPickListHeight: Number = definedExternally
    /**
     *  If this pickList contains no options, should it be hidden?
     *   If unset, default behavior is to allow the empty pickList to show if it is databound.
     *  @type {boolean}
     *  @default null
     */
    override var hideEmptyPickList: Boolean = definedExternally
    /**
     *  Default width to show the pickList.
     *   If not specified, the width of this form item's element will be used instead.
     * 
     *   Note that this is a minimum value - by default if the values displayed in this pickList
     *   are wider than the specified width the list will expand to accomodate them.
     *  @type {number}
     *  @default null
     */
    override var pickListWidth: Number = definedExternally
    /**
     *  Maximum width for this item's pickList.
     *   By default if the values displayed in this pickList are wider than the specified
     *   PickList.pickListWidth the pickList will render wide enough to accomodate them.
     *   This property allows the developer to limit how wide the pickList will render.
     *  @type {number}
     *  @default "400"
     */
    override var pickListMaxWidth: Number = definedExternally
    /**
     *  Base Style for pickList cells. See cellStyleSuffixes for details on how
     *   stateful suffixes are combined with the pickListBaseStyle to generate stateful cell styles.
     * 
     *   Note: if PickList.pickListTallBaseStyle is specified, this property will be used as the
     *   ListGrid.normalBaseStyle and that property will be applied
     *   to cells that do not match the default cell height, or if ListGrid.fastCellUpdates
     *   is true for the pickList in Internet Explorer.
     *  @type {CSSStyleName}
     *  @default "pickListCell"
     */
    override var pickListBaseStyle: String = definedExternally
    /**
     *  Optional ListGrid.tallBaseStyle for pickList cells. If unset,
     *   PickList.pickListBaseStyle will be applied to all cells.
     *  @type {CSSStyleName}
     *  @default null
     */
    override var pickListTallBaseStyle: String = definedExternally
    /**
     *  Default value for ListGrid.applyRowNumberStyle for this item's generated
     *   pickList.
     *  @type {boolean}
     *  @default false
     */
    override var pickListApplyRowNumberStyle: Boolean = definedExternally
    /**
     *  If true, when the pickList is shown, it will be shown via an animated reveal effect
     *  @type {boolean}
     *  @default false
     */
    override var animatePickList: Boolean = definedExternally
    /**
     *  If PickList.animatePickList is true, this attribute specifies the millisecond
     *   duration of the animation effect.
     *  @type {number}
     *  @default "200"
     */
    override var pickListAnimationTime: Number = definedExternally
    /**
     *  For a ComboBox or other pickList that accepts user-entered criteria, how many
     *   milliseconds to wait after the last user keystroke before fetching data from the server.
     *   The default setting will initiate a fetch if the user stops typing or pauses briefly.
     *  @type {number}
     *  @default "200"
     */
    override var fetchDelay: Number = definedExternally
    /**
     *  Cell Height for this item's pickList.
     *  @type {number}
     *  @default "16"
     */
    override var pickListCellHeight: Number = definedExternally
    /**
     *  If this pick list is showing multiple fields, this property determines the height of
     *   the column headers for those fields. Set to zero to suppress the headers entirely.
     *  @type {number}
     *  @default "22"
     */
    override var pickListHeaderHeight: Number = definedExternally
    /**
     *  If FormItem.displayField is specified for a field, should the
     *   display value for the field be picked up from the
     *   DynamicForm.getValues?
     * 
     *   This behavior is typically valuable for dataBound components where the
     *   displayField is specified at the DataSourceField level. See
     *   DataSourceField.displayField for more on this.
     * 
     *   Note that for DataSources backed by the
     *   serverDataIntegration, fields with a specified
     *   DataSourceField.foreignKey and DataSourceField.displayField will
     *   automatically have this property set to true if not explicitly set to false
     *   in the dataSource configuration.
     * 
     *   Otherwise, if not explicitly set, local display value will be used unless:
     * 
     * 
     *  - This item has an explicitly specified optionDataSource, rather than
     *     deriving its optionDataSource from a specified
     *     DataSourceField.foreignKey specification
     * 
     *  - The FormItem.name differs from the
     *     FormItem.getValueFieldName for the item
     * 
     *  @type {boolean}
     *  @default null
     */
    override var useLocalDisplayFieldValue: Boolean = definedExternally
    /**
     *  For Databound formItems, this property determines which column
     *   FormItem.valueIcons should show up in for this formItem's pickList.
     *   If unset, valueIcons show up in the PickList.displayField column if specified,
     *   otherwise the PickList.valueField column.
     *   In most cases only the displayField or valueField will be visible.
     *   This property is typically only required if custom PickList.pickListFields
     *   have been specified for this item.
     *  @type {string}
     *  @default null
     */
    override var valueIconField: String = definedExternally
    /**
     *   Expression evaluated to determine the ComboBoxItem.defaultValue when no value is
     *   provided for this item. To default to the first option use
     *   ComboBoxItem.defaultToFirstOption instead.
     * 
     */
    open fun defaultDynamicValue(): Unit = definedExternally
    /**
     *   Returns the raw text value that currently appears in the text field, which can differ from
     *   FormItem.getValue in various cases - for example:
     * 
     * 
     *  - for items that constrain the value range, such as a DateItem with
     *   DateItem.enforceDate:true, or a ComboBoxItem with
     *   ComboBoxItem.addUnknownValues:false
     * 
     *  - for items with a defined valueMap or edit value formatter and parser functions
     *   which converts display value to data value
     * 
     *  - while the item has focus if TextItem.changeOnKeypress is false
     * 
     * 
     */
    override fun getEnteredValue(): String = definedExternally
    /**
     *   Only applies to databound items (see PickList.optionDataSource).
     *   Performs a fetch type operation on this item's DataSource to retrieve the set of valid
     *   options for the item, based on the current PickList.pickListCriteria.
     * 
     *  @param {DSCallback=} Callback to fire when the fetch completes. Callback will        fire with 4 parameters:
     *  - item a pointer to the form item
     *  - dsResponse the DSResponse returned by the server
     *  - data the raw data returned by the server
     *  - dsRequest the DSRequest sent to the server
     *  @param {DSRequest=} properties to apply to the       dsRequest for this fetch.
     */
    override fun fetchData(callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Returns the displayField for this item.
     * 
     *   Behavior varies based on the configuration of this item, as follows:
     * 
     *  - If this item has an ComboBoxItem.optionDataSource and an explicit
     *   FormItem.foreignDisplayField is specified, this will be returned.
     * 
     *  - Otherwise if an explicit ComboBoxItem.displayField is specified it will be returned
     *   by default. If the displayField was specified on the underlying
     *   dataSource field, and no matching field is present in the ComboBoxItem.optionDataSource for
     *   the item, we avoid returning the specified displayField value and instead return the
     *   title field of the option DataSource. We do this to
     *   avoid confusion for the case where the displayField is intended as a display-field
     *   value for showing another field value within the same record in the underlying
     *   dataSource only.
     * 
     *  - If no explicit foreignDisplay or displayField
     *   specification was found, and the FormItem.valueField for this item is hidden in the
     *   FormItem.optionDataSource, this method will return the title field for
     *   the optionDataSource.
     * 
     * 
     */
    override fun getDisplayFieldName(): String = definedExternally
    /**
     *   Getter method to retrieve the FormItem.valueField for this item. For
     *   items with a specified FormItem.optionDataSource, this determines which
     *   field in that dataSource corresponds to the value for this item.
     * 
     *   If unset, if a DataSourceField.foreignKey exists
     *   between this field and the optionDataSource, this will be used,
     *   otherwise default behavior will return the FormItem.name of this field.
     * 
     * 
     */
    override fun getValueFieldName(): String = definedExternally
    /**
     *   Get the record returned from the ComboBoxItem.optionDataSource when FormItem.fetchMissingValues
     *   is true, and the missing value is fetched.
     * 
     *   FormItem.fetchMissingValues kicks off the fetch when the form item is initialized
     *   with a non null value or when setValue() is called on the item. Note that this method
     *   will return null before the fetch completes, or if no record is found in the
     *   optionDataSource matching the underlying value.
     * 
     */
    override fun getSelectedRecord(): ListGridRecord = definedExternally
    /**
     *   stringMethods to return filter criteria for options displayed for
     *   this item.
     * 
     *   See comboBoxFiltering for details on how pickList filter criteria
     *   are calculated by default for a comboBoxItem.
     * 
     * 
     */
    override fun getPickListFilterCriteria(): dynamic = definedExternally
    /**
     *   Returns the set of data to be displayed in this item's PickList.
     * 
     *   This method will be called for non-databound form items implementing the PickList
     *   interface. The default implementation will derive data from the item's valueMap -
     *   can be overridden to allow a custom set of options to be displayed.
     * 
     *   Note that for PickLists that filter data based on user input
     *   (ComboBoxItem), this method should return the data before
     *   filtering. To customize the data returned after filtering, override
     *   ComboBoxItem.filterClientPickListData instead.
     * 
     *   As an example, for a formItem with ComboBoxItem.valueField set to "valueFieldName", the
     *   default implementation would take a valueMap like the following:
     * 
     *     valueMap: { value1: "display 1", value2: "display 2" }
     * 
     *   .. and returning the following set of records:
     * 
     *     [
     *       { valueFieldName : "value1" },
     *       { valueFieldName : "value2" }
     *     ]
     * 
     *   Due to the valueMap, these records will appear as a two row pickList displayed as
     *   "display 1" and "display 2".
     * 
     * 
     */
    override fun getClientPickListData(): Array<dynamic> = definedExternally
    /**
     *   Returns the data to display in the pick list.
     * 
     *   The default implementation applies the criteria returned by
     *   PickList.getPickListFilterCriteria to the data returned by
     *   PickList.getClientPickListData. A record passes the filter if it has a
     *   matching value for all fields in the criteria object. Matching is performed according
     *   to TextMatchStyle.
     * 
     *   If PickList.showAllOptions is set, all values are shown, with matching values
     *   shown below a PickList.separatorRows.
     * 
     * 
     */
    override fun filterClientPickListData(): Array<dynamic> = definedExternally
    /**
     *   If this item is showing a dataBound pickList, this notification method will be fired
     *   when new data arrives from the server.
     * 
     *  @param {Integer} index of first row returned by the server
     *  @param {Integer} index of last row returned by the server
     *  @param {ResultSet} pointer to this pickList's data
     */
    override fun dataArrived(startRow: Number, endRow: Number, data: ResultSet): Unit = definedExternally
    /**
     *   When a comboBoxItem is used to generate search criteria in a SearchForm,
     *   if the user explicitly chose an option from the pickList, should the criterion generated
     *   by ComboBoxItem.getCriterion
     * 
     *   enforce a search for an exact match against the chosen value?
     * 
     *   In order to achieve this, when this property is set to true, this item will generate
     *   AdvancedCriteria in its ComboBoxItem.getCriterion
     * 
     *   method.
     * 
     *   Default implementation will return ComboBoxItem.generateExactMatchCriteria if specified, otherwise
     *   true if the DataSource for this item
     *   DataSource.supportsAdvancedCriteria, false if it
     *   does not.
     * 
     */
    open fun shouldGenerateExactMatchCriteria(): Boolean = definedExternally
    /**
     *   Will this item return advancedCriteria if DynamicForm.getValuesAsCriteria is
     *   called on this item's form?
     *   Overridden for ComboBoxItem to return true if ComboBoxItem.generateExactMatchCriteria is true
     *   - in this case if an exact value is chosen from our set of options (always the
     *   case if addUnkownValues is false), we will use advancedCriteria to ensure
     *   the generated search criteria exactly matches the chosen value for this item.
     * 
     *   Note that AdvancedCriteria are not supported by all dataSources. When a form is bound
     *   to a dataSource, we therefore default generateExactMatchCriteria to false unless
     *   the dataSource is known to support AdvancedCriteria.
     * 
     *   As with formItem.hasAdvancedCriteria() this will also return true if a Operator
     *   was explicitly specified for this item
     * 
     */
    override fun hasAdvancedCriteria(): Boolean = definedExternally
    /**
     *   Returns criterion derived from the current value of this item.
     * 
     *   If ComboBoxItem.addUnknownValues is true for this item, we implement the following behavior.
     *   If the user explicitly selected an item from the pickList, we treat this as an attempt
     *   to explicitly match the data value. In this case returned criteria will match the
     *   selected (data) value against this item's fieldName.
     *   If the user typed a value into the text field, we treat this as an attempt to do a substring
     *   type filter. In this case returned criteria will match the entered text value against the
     *   displayField for this item if one is specified.
     * 
     *   If ComboBoxItem.addUnknownValues is false we always match the chosen data value against the item's
     *   fieldName.
     * 
     *   Note that ComboBoxItem.shouldGenerateExactMatchCriteria will be called in the case when a
     *   value was explicitly picked from the set of options. If that method returns true, we will
     *   return AdvancedCriteria with an operator specified to ensure an exact match occurs.
     * 
     * 
     */
    open fun getCriterion(): Criterion = definedExternally
    /**
     *   This method is overridden in comboBoxItem. When addUnknownValues is true,
     *   comboBoxItems allow the user to edit substring match type criteria applied to the
     *   display field (if one is specified).
     * 
     *   The user can also edit criteria attempting to match exactly against the item's field name.
     * 
     * 
     */
    open fun canEditCriterion(): Unit = definedExternally
    /**
     *   Overridden to support editing criterion against the display field or value field when
     *   ComboBoxItem.addUnknownValues is true.
     * 
     */
    open fun setCriterion(): Unit = definedExternally
    /**
     *   PickLists can derive their data directly from a valueMap, or retrieve data from a
     *   dataSource to display as options.
     * 
     *   This method will return the dataSource used to populate the pickList, or null if
     *   none is specified (implies this list will derive its data from the valueMap for the item).
     *   Default implementation will return PickList.optionDataSource if specified,
     *   otherwise if this is a field with a specified foreignKey in a databound
     *   form, returns the dataSource for the foreignKey.
     *   Otherwise picks up this.form.dataSource if set.
     * 
     * 
     */
    override fun getOptionDataSource(): DataSource = definedExternally
    companion object {
        /**
         *  Special constant used to indicate that choosing this value from the PickList.specialValues list
         *   should result in selecting all of the values of the field. Only for use with specialValues
         *   - cannot be used elsewhere.
         *   This attribute may only be used when all matching records are being loaded, not when data paging is in use.
         *  @type {string}
         *  @default "\*\*selectAllValues\*\*"
         */
        var selectAllStoredValue: String = definedExternally
        /**
         *  Special constant used to indicate that choosing this value from the PickList.specialValues list
         *   should result in clearing the value of the field. Only for use with specialValues
         *   - cannot be used elsewhere.
         *  @type {string}
         *  @default "\*\*emptyValue\*\*"
         */
        var emptyStoredValue: String = definedExternally
        /**
         *  Creates a new ComboBoxItem
         * 
         *  @param typeCheckedProperties {Partial<ComboBoxItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ComboBoxItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ComboBoxItem = definedExternally
    }
}