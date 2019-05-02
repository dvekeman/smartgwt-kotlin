@file:JsQualifier("isc")
package isc

/**
 *  FormItem that allows picking between several mutually exclusive options via a select list.
 * 
 *   Options may be derived from a dataSource or a valueMap.
 * 
 *   Note that to select the first option as a default value for the item,
 *   SelectItem.defaultToFirstOption may be set.
 */
open external class SelectItem : FormItem, PickList {
    /**
     *  Height of the FormItem. Can be either a number indicating a fixed height in pixels, a
     *   percentage indicating a percentage of the overall form's height, or "\*" indicating take
     *   whatever remaining space is available. See the formLayout overview for details.
     * 
     * 
     *   For form items having a SelectItem.showPickerIcon (e.g. SelectItem,
     *   ComboBoxItem) and SpinnerItems, if there is no explicit
     *   FormItem.pickerIconHeight, the pickerIcon will be sized to match the available
     *   space based on the specified item height.
     *   Note that if spriting is being used, and the image to be displayed in these icons
     *   is specified
     *   using css properties such as background-image, background-size,
     *   changing this value may result in an unexpected appearance as the image will not
     *   scale.
     *   Scaleable spriting can be achieved using the SCSpriteConfig format.
     *   See the section on spriting in the skinning for
     *   further information.
     *   Alternatively, the SelectItem.pickerIconStyle could be changed to a
     *   custom CSS style name, and in the case of SpinnerItems,
     *   the FormItemIcon.baseStyle and
     *   FormItemIcon.src of the SpinnerItem.increaseIcon
     *   and SpinnerItem.decreaseIcon AutoChildren could be customized.
     * 
     *   Note that when FormItem is rendered as read-only with readOnlyDisplay as "static"
     *   the property FormItem.staticHeight is used instead.
     *  @type {number}
     *  @default "19"
     */
    override var height: dynamic = definedExternally
    /**
     *  If this item's value is set (via SelectItem.setValue or similar) to a value which
     *   is not present in the ValueMap, should the value be rejected.
     * 
     *   If set to false the setValue() call will have no effect if the value
     *   is not a valid option.
     * 
     *   If set to true the item's value will be update to the new value, and
     *   the value will be added to the set of options displayed in the pick-list until the
     *   next call to SelectItem.setValueMap or SelectItem.setValue.
     * 
     *   Exception: If the value is set to null but there is no null entry in the
     *   valueMap for this item, setting addUnknownValues to true will not cause
     *   a null option to show up at the top of the select item pickList. Whether an empty
     *   option is shown in the pickList is governed by SelectItem.allowEmptyValue
     *   instead.
     * 
     *   Note that this property has no effect if the selectItem has a specified
     *   SelectItem.optionDataSource. If SelectItem.setValue is called on a databound SelectItem
     *   and the new value does not match any loaded options, the value will be accepted,
     *   but not added to the options displayed in the pickList. Also note that if a
     *   SelectItem.displayField exists, a fetch will be performed in an attempt to retrieve
     *   a valid display value, as described under FormItem.fetchMissingValues.
     *   If specified the FormItem.loadingDisplayValue will be displayed while the
     *   fetch is in progress, and then the real value (mapped to a display field value if
     *   a matching record was found) will be displayed when the fetch completes.
     *  @type {boolean}
     *  @default true
     */
    open var addUnknownValues: Boolean = definedExternally
    /**
     *  Static default value for this SelectItem. To default to the first option use
     *   SelectItem.defaultToFirstOption instead.
     *  @type {boolean}
     *  @default null
     */
    override var defaultValue: Boolean = definedExternally
    /**
     *  Select the first option as the default value for this SelectItem.
     * 
     *   If options are derived from a dataSource, the first value returned by the server will be
     *   used, otherwise the first value in the valueMap. Note that setting this property to
     *   true will trigger a fetch at soon as the form is created, because the form will try to
     *   establish a default value at that time.
     * 
     *   If enabled, this setting overrides SelectItem.defaultValue and
     *   SelectItem.defaultDynamicValue.
     *  @type {boolean}
     *  @default false
     */
    open var defaultToFirstOption: Boolean = definedExternally
    /**
     *  If true, multiple values may be selected.
     * 
     *   The SelectItem will either render as a drop-down allowing multiple selections, or a
     *   multi-row list of options similar to a small headerless ListGrid, based on the
     *   MultipleAppearance setting.
     * 
     *   The logical value of the formItem, as retrieved by FormItem.getValue
     *   and set via FormItem.setValue, is an Array of Strings reflecting the
     *   selected values.
     * 
     *   When this value is true, we disable doubleClick events by default, instead issuing two
     *   single clicks by forcibly setting Canvas.noDoubleClicks.
     *   If you need to work with doubleClick events, you can disable this default behavior by
     *   explicitly setting formItem.pickListProperties.noDoubleClicks: false.
     * 
     *   Note: multiple:true SelectItems with multipleAppearance:"grid" do not
     *   currently support optionDataSource binding. You can get around this by calling
     *   DataSource.fetchData directly and calling
     *   List.getValueMap to obtain a valueMap.
     *  @type {boolean}
     *  @default false
     */
    override var multiple: Boolean = definedExternally
    /**
     *  How should items with SelectItem.multiple set to 'true' be displayed?
     *  @type {MultipleAppearance}
     *  @default "picklist"
     */
    open var multipleAppearance: 
                                 /**
                                  *  a drop-down picklist that allows multiple choices by       clicking on a checkbox next to each item
                                  *  a grid that displays all items in-place. Multiple selection is        accomplished by ctrl-click or shift-click.
                                  */
                                 String /* picklist |  grid */ = definedExternally
    /**
     *  For SelectItem.optionDataSource items, this property will be passed
     *   to the generated ResultSet data object for the pickList as ResultSet.useClientFiltering.
     *   Setting to false will disable filtering on the client and ensure criteria are
     *   always passed to the DataSource directly.
     *  @type {boolean}
     *  @default null
     */
    override var useClientFiltering: Boolean = definedExternally
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
     *  Text to display when this form item has a null or undefined value.
     * 
     *   If the formItem has a databound pickList, and its FormItem.displayField or
     *   FormItem.valueField (if the former isn't set) has an undefined
     *   ListGridField.emptyCellValue setting, that field's
     *   emptyCellValue will automatically be set to the emptyDisplayValue.
     *  @type {HTMLString}
     *  @default "&amp;nbsp;"
     */
    override var emptyDisplayValue: String = definedExternally
    /**
     *  Base CSS class name for a form item's text box element.
     * 
     *   See formItemStyling for an overview of formItem styling, and
     *   the CompoundFormItem_skinning discussion for special
     *   skinning considerations.
     * 
     *   If the textBoxStyle is changed at runtime, FormItem.updateState
     *   must be called to update the visual state of this item.
     *  @type {FormItemBaseStyle}
     *  @default ""selectItemText", [IRA]"
     */
    override var textBoxStyle: String = definedExternally
    /**
     *  Base CSS class name for a form item's "control box". This is an HTML element
     *   which contains the text box and picker icon for the item.
     * 
     *   See FormItem.alwaysShowControlBox for details on when the control box
     *   is written out.
     * 
     *   See formItemStyling for an overview of formItem styling, and
     *   the CompoundFormItem_skinning discussion for special
     *   skinning considerations.
     *  @type {FormItemBaseStyle}
     *  @default ""selectItemControl", [IRA]"
     */
    override var controlStyle: String = definedExternally
    /**
     *  Base CSS class name for a form item's picker icon cell. If unset, inherits from
     *   this item's SelectItem.controlStyle.
     *  @type {FormItemBaseStyle}
     *  @default "selectItemPickerIcon"
     */
    override var pickerIconStyle: String = definedExternally
    /**
     *  When this item receives focus, should it be re-styled to indicate it has focus?
     * 
     *   See formItemStyling for more details on formItem styling.
     *  @type {boolean}
     *  @default "true, [IRWA]"
     */
    override var showFocused: Boolean = definedExternally
    /**
     *  If SelectItem.showPickerIcon is true for this item, this property governs the
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
     *  @default null
     */
    override var pickerIconWidth: Number = definedExternally
    /**
     *  If SelectItem.showPickerIcon is true for this item, this property governs the
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
     *  @default null
     */
    override var pickerIconHeight: Number = definedExternally
    /**
     *  If SelectItem.showPickerIcon is true for this item, this property governs the
     *   FormItemIcon.src of the picker icon image to be displayed.
     * 
     *   When skinning is enabled, this property will not
     *   be used to locate an image, instead, the image is drawn via CSS based on the
     *   SelectItem.pickerIconStyle property.
     *  @type {SCImgURL}
     *  @default "[SKIN]/DynamicForm/SelectItem_PickButton_icon.gif"
     */
    override var pickerIconSrc: String = definedExternally
    /**
     *  Should this SelectItem show a hilite when it receives keyboard focus?
     *  @deprecated \* As of SmartClient version 5.5, use SelectItem.showFocused instead.
     *  @type {boolean}
     *  @default true
     */
    open var hiliteOnFocus: Boolean = definedExternally
    /**
     *  Background color to apply to the select item's selected value when the SelectItem
     *   receives focus, if hiliteOnFocus is true.
     *  @deprecated \* As of SmartClient version 5.5, if SelectItem.showFocused is true, styling will be updated for this form item on focus. The hiliting effect can therefore
     *   be achieved via SelectItem.textBoxStyle and SelectItem.controlStyle
     *   instead.
     *  @type {string}
     *  @default "#316AC5"
     */
    open var hiliteColor: String = definedExternally
    /**
     *  Text color to apply to the select item's selected value when the SelectItem
     *   receives focus, if hiliteOnFocus is true.
     *  @deprecated \* As of SmartClient version 5.5, if SelectItem.showFocused is true, styling will be updated for this form item on focus. The hiliting effect can therefore
     *   be achieved via SelectItem.textBoxStyle and SelectItem.controlStyle
     *   instead.
     *  @type {string}
     *  @default "white"
     */
    open var hiliteTextColor: String = definedExternally
    /**
     *  How large should the pick button be rendered?
     *  @deprecated \* As of SmartClient version 5.5, pickButtonWidth has been deprecated in  favor of SelectItem.pickerIconWidth.
     *  @type {number}
     *  @default null
     */
    open var pickButtonWidth: Number = definedExternally
    /**
     *  How large should the pick button be rendered?
     *  @deprecated \* As of SmartClient version 5.5, pickButtonHeight has been deprecated in  favor of SelectItem.pickerIconHeight.
     *  @type {number}
     *  @default null
     */
    open var pickButtonHeight: Number = definedExternally
    /**
     *  Source for image to show for the pick button
     *  @deprecated \* As of SmartClient version 5.5, pickButtonSrc has been deprecated in  favor of SelectItem.pickerIconSrc.
     *  @type {string}
     *  @default null
     */
    open var pickButtonSrc: String = definedExternally
    /**
     *  When the user rolls over this item, should it be re-styled to indicate it has focus?
     * 
     *   By default this property is true for SelectItems, and SelectItem.updateTextBoxOnOver and
     *   SelectItem.updateControlOnOver are set to false. This means the picker icon will show
     *   over styling when the user rolls over the control table.
     *   These defaults may be overridden by different SmartClient skins.
     * 
     *   See formItemStyling for more details on formItem styling.
     *  @type {boolean}
     *  @default true
     */
    override var showOver: Boolean = definedExternally
    /**
     *  If FormItem.showOver is true, setting this property to false will explicitly
     *   disable showing the "Over" state for the TextBox element of this item.
     *  @type {boolean}
     *  @default false
     */
    override var updateTextBoxOnOver: Boolean = definedExternally
    /**
     *  If FormItem.showOver is true, setting this property to false will explicitly
     *   disable showing the "Over" state for the control table element of
     *   this item (if present).
     *  @type {boolean}
     *  @default false
     */
    override var updateControlOnOver: Boolean = definedExternally
    /**
     *  By default SelectItems do not allow users to select the text of the
     *   selected value.
     *  @type {boolean}
     *  @default false
     */
    override var canSelectText: Boolean = definedExternally
    /**
     *  If set to true, always show an empty option in this item's pickList, allowing the user
     *   to clear the value (even if there is no empty entry in the valueMap for the item).
     * 
     *   The empty value will be displayed with the
     *   FormItem.emptyDisplayValue.
     * 
     *   With a SelectItem.optionDataSource, enabling
     *   allowEmptyValue disables data paging by default - all data matching the
     *   PickList.pickListCriteria will be requested. However, enabling
     *   SelectItem.separateSpecialValues allows data paging to be used if required.
     * 
     *   See also SelectItem.specialValues as a way of providing several different special values in
     *   addition to an empty value, such as "Invalid". Note that setting
     *   specialValues disables the use of allowEmptyValue - see
     *   details of how to have an empty value while using specialValues in
     *   in SelectItem.specialValues.
     *  @type {boolean}
     *  @default false
     */
    open var allowEmptyValue: Boolean = definedExternally
    /**
     *  A set of "special" values such as "All", "None" or "Invalid" that do not appear in the normal
     *   ValueMap or in the data returned by the SelectItem.optionDataSource.
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
     *   Also, if an SelectItem.optionDataSource is used, SelectItem.specialValues that appear in the normal
     *   dataset will be updated by automatic cacheSync (if
     *   the SelectItem.displayField is updated). However when using a distinct SelectItem.valueField and
     *   SelectItem.displayField, you are required to provide SelectItem.specialValues as a map (there is no
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
     *  If true, SelectItem.specialValues such as the empty value will be shown in a
     *   separate non-scrolling area, in the SelectItem.separateValuesList. Aside from making these values
     *   more easily accessible, showing them in a separate list allows data paging to be used, which is
     *   disabled if the separateValues are shown in the normal drop-down list along with other values.
     *  @type {boolean}
     *  @default null
     */
    open var separateSpecialValues: Boolean = definedExternally
    /**
     *  AutoChild used to show SelectItem.specialValues.
     *  @type {ListGrid}
     *  @default null
     */
    open var separateValuesList: ListGrid = definedExternally
    /**
     *  If this select item retrieves its options from a dataSource, should options
     *   be fetched from the server when the item is first drawn, or should this fetch be
     *   delayed until the user opens the pickList.
     * 
     *   The default is true in order to allow the user to select a value via keyboard input
     *   while keyboard focus is on the SelectItem but the pickList has not actually been shown.
     *  @type {boolean}
     *  @default true
     */
    open var autoFetchData: Boolean = definedExternally
    /**
     *  If showing a hint for this form item, should it be shown within the field?
     *   CSS style for the hint is SelectItem.textBoxStyle with the suffix
     *   "Hint" appended to it.
     *  @type {boolean}
     *  @default null
     */
    open var showHintInField: Boolean = definedExternally
    /**
     *  Indicates whether or not this SelectItem will load its list of options
     *   DataSource.progressiveLoading. This property is copied onto the
     *   underlying PickList.
     *  @type {boolean}
     *  @default null
     */
    open var progressiveLoading: Boolean = definedExternally
    /**
     *  Select items will submit their containing form on enter keypress
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
     *  Causes the PickList to open when the spacebar is pressed, default false.
     * 
     *   For native OS widgets, space opens the PickList on Macs, but not on Windows. Consider
     *   using this setting if your users are almost entirely Mac users, or enabling it only for
     *   users running MacOS.
     * 
     *   However, before using this setting, consider that it means that Spacebar will not be able
     *   to be used for another purpose when focus is in a SelectItem.
     *  @type {boolean}
     *  @default false
     */
    open var openOnSpace: Boolean = definedExternally
    /**
     *  Causes the PickList to open when the down arrow is pressed, default false.
     * 
     *   For native OS widgets, the down arrow changes the value of a select on Windows, but
     *   opens the select on Macs. This setting is not recommended unless you are certain that
     *   all users of your applications will expect the Mac convention.
     *  @type {boolean}
     *  @default false
     */
    open var openOnDownArrow: Boolean = definedExternally
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
     *   incorporates a SelectItem.pickerNavigationBar and
     *   SelectItem.pickerExitButton that hides the expanded interface.
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
     *  NavigationButton to dismiss the picker interface, created when
     *   SelectItem.pickListPlacement indicates that the search interface takes over the
     *   entire panel or screen.
     * 
     *   The following autoChildUsage apply:
     * 
     * 
     *  - SelectItem.pickerExitButtonTitle for Button.title
     * 
     *  @type {NavigationButton}
     *  @default null
     */
    open var pickerExitButton: NavigationButton = definedExternally
    /**
     *  The title for the SelectItem.pickerExitButton.
     *  @type {HTMLString}
     *  @default "Done"
     */
    open var pickerExitButtonTitle: String = definedExternally
    /**
     *  Empty message to display in the selectItem if PickList.hideEmptyPickList
     *   is false.
     *  @type {string}
     *  @default "No items to show"
     */
    override var emptyPickListMessage: String = definedExternally
    /**
     *  NavigationBar created when SelectItem.pickListPlacement indicates that the search
     *   interface takes over the entire panel or screen.
     *  @type {NavigationBar}
     *  @default null
     */
    open var pickerNavigationBar: NavigationBar = definedExternally
    /**
     *  By default, if multiple keys are pressed in quick succession, a SelectItem will buffer
     *   them together and use the resulting multi-char string when searching. Set this
     *   attribute to false to force the item to match only one character at a time.
     *  @type {boolean}
     *  @default true
     */
    open var allowMultiCharSearch: Boolean = definedExternally
    /**
     *  By default HTML values in a selectItem will be interpreted by the browser.
     *   Setting this flag to true will causes HTML characters to be escaped, meaning the
     *   raw value of the field (for example "&lt;b&gt;AAA&lt;/b&gt;") is displayed
     *   to the user rather than the interpreted HTML (for example "AAA")
     *  @type {boolean}
     *  @default false
     */
    open var escapeHTML: Boolean = definedExternally
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
     *   setting SelectItem.pickListFields.
     * 
     *   The data will be retrieved via a "fetch" operation on the DataSource, passing the
     *   PickList.pickListCriteria (if set) as criteria, and passing
     *   SelectItem.optionFilterContext (if set) as DSRequest Properties.
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
     *   dataSource is backed by an XML flat file), you can set SelectItem.filterLocally to have the
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
     *  When applying filter criteria to pickList data, what type of matching to use.
     * 
     *   For a databound pickList (SelectItem.optionDataSource set), textMatchStyle is
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
     *   will cache and re-use datasets shown by pickLists in an LRU (least recently used) caching
     *   pattern.
     * 
     *   Setting this flag to false avoids this caching for situations where it is too aggressive.
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
     *   FormItem.displayField and SelectItem.pickListFields.
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
     *   SelectItem.getDisplayFieldName for more on this behavior.
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
     *   disable client-side filtering set the SelectItem.useClientFiltering property to false.
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
     *  If true, even non-matching options will be shown, with configurable
     *   PickList.separatorRows in between. Not valid for
     *   PickList.optionDataSource.
     *  @type {boolean}
     *  @default null
     */
    override var showAllOptions: Boolean = definedExternally
    /**
     *  Array of records to show between matching and non-matching rows in the PickList.
     * 
     *   Not valid for PickList.optionDataSource.
     *  @type {Array<Partial<ListGridRecord>>}
     *  @default "[{isSeparator:true}]"
     */
    override var separatorRows: Array<dynamic> = definedExternally
    /**
     *   Set the valueMap for this item.
     * 
     *  @param {Array<any> | object} new valueMap
     */
    override fun setValueMap(valueMap: dynamic): Unit = definedExternally
    /**
     *   Expression evaluated to determine the SelectItem.defaultValue when no value is
     *   provided for this item. To default to the first option use
     *   SelectItem.defaultToFirstOption instead.
     * 
     */
    open fun defaultDynamicValue(): Unit = definedExternally
    /**
     *   Notification method called when FormItem.showPending is enabled and
     *   this SelectItem should either clear or show its pending visual state.
     * 
     *   The default behavior is that the FormItem.titleStyle and
     *   FormItem.cellStyle are updated to include/exclude the "Pending" suffix.
     *   In addition, a SelectItem.multiple SelectItem when displayed in
     *   the pending state will apply FormItem.editPendingCSSText to any new value in the
     *   text box and also append "Pending" to the cells' ListGrid.baseStyle for cells
     *   in the pickList menu corresponding to new values. Returning false will
     *   cancel this default behavior.
     * 
     *  @param {DynamicForm} the managing DynamicForm instance.
     *  @param {FormItem} the form item itself (also available as "this").
     *  @param {boolean} true if the item should show its pending visual state; false otherwise.
     *  @param {any} the current form item value.
     *  @param {any} the value that would be restored by a call to DynamicForm.resetValues.
     */
    override fun pendingStatusChanged(form: DynamicForm, item: FormItem, pendingStatus: Boolean, newValue: dynamic, value: dynamic): Boolean = definedExternally
    /**
     *   Method to show a picker for this item. By default this method is called if the user
     *   clicks on a SelectItem.showPickerIcon. May also be called programmatically.
     * 
     *   Overridden from the default FormItem.showPicker implementation to show
     *   the PickList
     * 
     * 
     */
    override fun showPicker(): Unit = definedExternally
    /**
     *   Set the value of the form item to the value passed in
     * 
     *   NOTE: for valueMap'd items, newValue should be data value not displayed value
     * 
     *  @param {any} value to set the element to
     */
    override fun setValue(newValue: dynamic): Unit = definedExternally
    /**
     *   For a SelectItem with an SelectItem.optionDataSource and allowing multiple selection
     *   (SelectItem.multiple), returns the list of currently selected records, or
     *   null if none are selected.
     * 
     * 
     */
    open fun getSelectedRecords(): Array<dynamic> = definedExternally
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
     *  - If this item has an SelectItem.optionDataSource and an explicit
     *   FormItem.foreignDisplayField is specified, this will be returned.
     * 
     *  - Otherwise if an explicit SelectItem.displayField is specified it will be returned
     *   by default. If the displayField was specified on the underlying
     *   dataSource field, and no matching field is present in the SelectItem.optionDataSource for
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
     *   If this item is showing a dataBound pickList, this notification method will be fired
     *   when new data arrives from the server.
     * 
     *  @param {Integer} index of first row returned by the server
     *  @param {Integer} index of last row returned by the server
     *  @param {ResultSet} pointer to this pickList's data
     */
    override fun dataArrived(startRow: Number, endRow: Number, data: ResultSet): Unit = definedExternally
    /**
     *   Get the record returned from the SelectItem.optionDataSource when FormItem.fetchMissingValues
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
    /**
     *   stringMethods to return a set of filter criteria to be applied to
     *   the data displayed in the pickList when it is shown.
     * 
     *   If this is a databound item the criteria will be passed as criteria to
     *   DataSource.fetchData. Otherwise an equivalent client-side filter will be
     *   performed on the data returned by PickList.getClientPickListData.
     * 
     *   By default combines FormItem.optionCriteria with
     *   PickList.pickListCriteria if specified, otherwise an empty
     *   set of criteria so all records will be displayed.
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
     *   PickList.filterClientPickListData instead.
     * 
     *   As an example, for a formItem with PickList.valueField set to "valueFieldName", the
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
         *  Creates a new SelectItem
         * 
         *  @param typeCheckedProperties {Partial<SelectItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {SelectItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): SelectItem = definedExternally
    }
}