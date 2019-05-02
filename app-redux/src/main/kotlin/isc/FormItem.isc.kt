@file:JsQualifier("isc")
package isc

/**
 *  A UI component that can participate in a DynamicForm, allowing editing or display of one of
 *   the DynamicForm.values.
 * 
 *   FormItems are never created via the Class.create method,
 *   instead, an Array of plain Object are passed as
 *   DynamicForm.items when the form is created.
 * 
 * 
 * 
 *   See the DynamicForm documentation for details and sample code.
 */
open external class FormItem : Class {
    /**
     *  The DynamicForm picks a field renderer based on the type of the field (and sometimes other
     *   attributes of the field).
     *  @type {FormItemType}
     *  @default "text"
     */
    open var type: 
                   /**
                    *  Rendered as a TextItem, unless the length of the field (as specified by DataSourceField.length attribute) is larger than the value
                    *   specified by DynamicForm.longTextEditorThreshold, a
                    *   TextAreaItem is shown.
                    *  Rendered as a CheckboxItem
                    *  Same as text by default.           Consider setting editorType:SpinnerItem.
                    *  Same as text by default.           Consider setting editorType:SpinnerItem.
                    *  Rendered as a DateItem
                    *  Rendered as a TimeItem
                    *  Rendered as a SelectItem. Also true for any field that          specifies a FormItem.valueMap.
                    *            Consider setting editorType:ComboBoxItem.
                    *  Same as text
                    *  If DataSourceField.canEdit:false is set on the field,          the value is rendered as a LinkItem. Otherwise the field
                    *            is rendered as a TextItem.
                    *  Rendered as an image if not editable, or as a TextItem to edit          the URL or partial URL if editable
                    *  Rendered as a FileItem, or a ViewFileItem if not editable
                    *  Rendered as a FileItem, or a ViewFileItem if not editable
                    */
                   String /* text |  boolean |  integer |  float |  date |  time |  enum |  sequence |  link |  image |  imageFile |  binary */ = definedExternally
    /**
     *  Name of the FormItem to use for editing, eg "TextItem" or "SelectItem".
     * 
     *   The type of FormItem to use for editing is normally derived automatically from
     *   FormItem.type, which is the data type of the field, by the rules
     *   explained FormItemType.
     *  @type {any}
     *  @default null
     */
    open var editorType: dynamic = definedExternally
    /**
     *  Name for this form field. Must be unique within the form as well as a valid JavaScript
     *   identifier - see FieldName for details and how to check for validity.
     * 
     *   The FormItem's name determines the name of the property it edits within the form.
     * 
     *   Note that an item must have a valid name or FormItem.dataPath in order
     *   for its value to be validated and/or saved.
     *  @type {FieldName}
     *  @default null
     */
    open var name: String = definedExternally
    /**
     *  dataPath for this item. Allows the user to edit details nested data structures in a
     *   flat set of form fields
     * 
     *   Note that an item must have a valid dataPath or FormItem.name in order
     *   for its value to be validated and/or saved.
     *  @type {DataPath}
     *  @default null
     */
    open var dataPath: String = definedExternally
    /**
     *  User visible title for this form item.
     *  @type {HTMLString}
     *  @default null
     */
    open var title: String = definedExternally
    /**
     *  Value used when no value is provided for this item. Note that whenever this item's value
     *   is cleared programmatically (for example via item.clearValue() or
     *   item.setValue(null)), it will be
     *   reverted to the defaultValue.
     * 
     *   Developers should use the
     *   DynamicForm.values object if their intention is to provide an initial value for a
     *   field in a form rather than a value to use in place of null.
     * 
     *   Developers looking to provide a 'hint' or placeholder value for an empty item may wish to use
     *   FormItem.hint (possibly in conjunction with TextItem.showHintInField), or FormItem.prompt.
     * 
     *   Note: Some items provide a user interface allowing the user to explicitly clear them - for
     *   example a standard TextItem. If such an item has a defaultValue specified, and the user explicitly
     *   clears that value, the value of the item will be (correctly) reported as null, and will remain
     *   null over form item redraw()s. However any programmatic call to set the value to null
     *   (including, but not limited to item.clearValue(), item.setValue(null),
     *   dynamicForm.setValues(...) with a null value for this field, etc) will
     *   reset the item value to its default.
     *  @type {any}
     *  @default null
     */
    open var defaultValue: dynamic = definedExternally
    /**
     *  Value for this form item.
     *   This value may be set directly on the form item initialization
     *   block but is not updated on live items and should not be directly accessed.
     *   Once a form item has been created by the dynamicForm use FormItem.setValue and
     *   FormItem.getValue directly.
     *  @type {any}
     *  @default null
     */
    open var value: dynamic = definedExternally
    /**
     *  Global identifier for referring to the formItem in JavaScript. The ID property is
     *   optional if you do not need to refer to the widget from JavaScript, or can refer to it
     *   indirectly (for example, via form.getItem("itemName")).
     * 
     *   An internal, unique ID will automatically be created upon instantiation for any formItem
     *   where one is not provided.
     *  @type {GlobalId}
     *  @default null
     */
    open var ID: String = definedExternally
    /**
     *  Text to display when this form item has a null or undefined value.
     * 
     *   If the formItem has a databound pickList, and its FormItem.displayField or
     *   FormItem.valueField (if the former isn't set) has an undefined
     *   ListGridField.emptyCellValue setting, that field's
     *   emptyCellValue will automatically be set to the emptyDisplayValue.
     *  @type {string}
     *  @default ""
     */
    open var emptyDisplayValue: String = definedExternally
    /**
     *  Should this form item be hidden? Setting this property to true on
     *   an item configuration will have the same effect as having a FormItem.showIf
     *   implementation which returns false.
     * 
     *   Note this differs slightly from DataSourceField.hidden. That property
     *   will cause the field in question to be omitted entirely from databound
     *   components by default. A dataSourceField with hidden set to
     *   true can still be displayed in a DynamicForm either by being
     *   explicitly included in the specified DynamicForm.items, or
     *   by having DataBoundComponent.showHiddenFields set to true.
     *   In this case, this property will not be inherited onto the FormItem instance,
     *   meaning the item will be visible in the form even though the hidden
     *   property was set to true on the dataSourceField configuration object.
     *  @type {boolean}
     *  @default null
     */
    open var hidden: Boolean = definedExternally
    /**
     *  In a form, valueMaps are used for FormItem types that allow the user to pick from a
     *   limited set of values, such as a SelectItem. The valueMap can be either an Array of
     *   legal values or an Object where each property maps a stored value to a user-displayable
     *   value.
     * 
     *   To set the initial selection for a form item with a valueMap, use
     *   FormItem.defaultValue.
     * 
     *   See also DataSourceField.valueMap.
     *  @type {Array<any> | object}
     *  @default null
     */
    open var valueMap: dynamic = definedExternally
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
     *  @type {DataSource | string}
     *  @default null
     */
    open var optionDataSource: dynamic = definedExternally
    /**
     *  If this item has a specified optionDataSource, and this property is
     *   not null, this will be passed to the datasource as RPCRequest properties when
     *   performing the fetch operation on the dataSource to obtain a data-value to display-value
     *   mapping
     *  @type {RPCRequest}
     *  @default null
     */
    open var optionFilterContext: DSRequest = definedExternally
    /**
     *  If this item has a specified optionDataSource, and this property may be used
     *   to specify criteria to pass to the datasource when
     *   performing the fetch operation on the dataSource to obtain a data-value to display-value
     *   mapping.
     * 
     *   This property supports dynamicCriteria - use Criterion.valuePath
     *   to refer to values in the Canvas.ruleScope. Criteria are re-evaluated when
     *   the Canvas.getRuleContext changes.
     *  @type {Criteria}
     *  @default null
     */
    open var optionCriteria: dynamic = definedExternally
    /**
     *  If this item has a specified optionDataSource, this attribute may be set
     *   to specify an explicit DSRequest.operationId when performing a fetch against the
     *   option dataSource to pick up display value mapping.
     *  @type {string}
     *  @default null
     */
    open var optionOperationId: String = definedExternally
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
    open var valueField: String = definedExternally
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
     *   FormItem.getDisplayFieldName for more on this behavior.
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
    open var displayField: String = definedExternally
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
    open var useLocalDisplayFieldValue: Boolean = definedExternally
    /**
     *  For items with an FormItem.optionDataSource, this property specifies an explicit
     *   display field for records within the option dataSource. Typically this property
     *   will be set in conjunction with FormItem.displayField in the case where
     *   the name of the displayField within the record being edited differs from the
     *   displayField in the optionDataSource.
     * 
     *   See DataSourceField.foreignDisplayField for additional details.
     *  @type {string}
     *  @default null
     */
    open var foreignDisplayField: String = definedExternally
    /**
     *  If this item is displaying multiple values, this property will be the
     *   string that separates those values for display purposes.
     *  @type {string}
     *  @default ', '
     */
    open var multipleValueSeparator: String = definedExternally
    /**
     *  If this form item has a specified FormItem.optionDataSource, should the
     *   item ever perform a fetch against this dataSource to retrieve the related record.
     * 
     *   The fetch occurs if the item value is non null on initial draw of the form
     *   or whenever setValue() is called. Once the fetch completes, the returned record
     *   is available via the FormItem.getSelectedRecord api.
     * 
     *   By default, a fetch will only occur if FormItem.displayField is specified, and
     *   the item does not have an explicit FormItem.valueMap containing the
     *   data value as a key.
     *   However you can also set FormItem.alwaysFetchMissingValues to have a fetch occur
     *   even if no displayField is specified. This ensures
     *   FormItem.getSelectedRecord will return a record if possible - useful for
     *   custom formatter functions, etc.
     * 
     *   Note - for efficiency we cache the associated record once a fetch has been performed, meaning
     *   if the value changes, then reverts to a previously seen value, we do not kick
     *   off an additional fetch to pick up the display value for the previously seen data value.
     *   If necessary this cache may be explicitly invalidated via a call to
     *   FormItem.invalidateDisplayValueCache
     *  @type {boolean}
     *  @default true
     */
    open var fetchMissingValues: Boolean = definedExternally
    /**
     *  If this form item has a specified FormItem.optionDataSource and
     *   FormItem.fetchMissingValues is true, when the item value changes, a fetch will be
     *   performed against the optionDataSource to retrieve the related record
     *   if FormItem.displayField is specified and the new item value is not present in any
     *   valueMap explicitly specified on the item.
     * 
     *   Setting this property to true means that a fetch will occur against the optionDataSource
     *   to retrieve the related record even if FormItem.displayField is unset, or the
     *   item has a valueMap which explicitly contains this field's value.
     * 
     *   An example of a use case where this might be set would be if FormItem.formatValue
     *   or FormItem.formatEditorValue were written to display properties from the
     *   FormItem.getSelectedRecord.
     * 
     *   Note - for efficiency we cache the associated record once a fetch has been performed, meaning
     *   if the value changes, then reverts to a previously seen value, we do not kick
     *   off an additional fetch even if this property is true. If necessary this cache may be
     *   explicitly invalidated via a call to FormItem.invalidateDisplayValueCache
     *  @type {boolean}
     *  @default false
     */
    open var alwaysFetchMissingValues: Boolean = definedExternally
    /**
     *  Value shown in field when FormItem.fetchMissingValues is active and a
     *   fetch is pending. The field is read-only while a fetch is pending.
     * 
     *   Set to null to show actual value until display value is loaded.
     *  @type {string}
     *  @default "Loading..."
     */
    open var loadingDisplayValue: String = definedExternally
    /**
     *  If this form item is mapping data values to a display value by fetching records from a
     *   dataSource (see FormItem.optionDataSource, FormItem.displayField
     *   and FormItem.fetchMissingValues), setting this property to true ensures that when
     *   the form item value is set, entire data-set from the dataSource is loaded at once and
     *   used as a valueMap, rather than just loading the display value for the current value.
     *   This avoids the need to perform fetches each time setValue() is called with a new value.
     * 
     *   See also PickList.filterLocally for behavior on form items such as SelectItems
     *   that show pick-lists.
     *  @type {boolean}
     *  @default null
     */
    open var filterLocally: Boolean = definedExternally
    /**
     *  Display format to use for date type values within this formItem.
     * 
     *   Note that Fields of type "date", "datetime" or
     *   "time" will be edited using a DateItem or TimeItem by
     *   default, but this can be overridden - for canEdit:false fields, a
     *   StaticTextItem is used by default, and the developer can always specify
     *   a custom FormItem.editorType as well as FormItem.type.
     * 
     *   The FormItem.timeFormatter may also be used to format underlying Date values as
     *   times (ommitting the date part entirely). If both dateFormatter and
     *   timeFormatter are specified on an item, for
     *   fields specified as FormItem.type the
     *   timeFormatter will be used, otherwise the dateFormatter
     * 
     *   If item.dateFormatter and item.timeFormatter is unspecified,
     *   date display format may be defined at the component level via
     *   DynamicForm.dateFormatter, or for fields of type "datetime"
     *   DynamicForm.datetimeFormatter. Otherwise the
     *   default is to use the system-wide default short date format, configured via
     *   DateUtil.setShortDisplayFormat. Specify any valid DateDisplayFormat
     *   to change the format used by this item.
     * 
     *   Note that if this is a freeform editable field, such a TextItem, with type
     *   specified as "date" or "datetime" the system will automatically
     *   attempt to parse user entered values back to a Date value, assuming the entered string
     *   matches the date format for the field. Developers may further customize this via an
     *   explicit FormItem.inputFormat or via entirely custom
     * 
     *   FormItem.formatEditorValue and FormItem.parseEditorValue methods.
     * 
     * 
     *  @type {DateDisplayFormat}
     *  @default null
     */
    open var dateFormatter: 
                            /**
                             *  Default native browser 'toString()' implementation. May vary by browser.
                             *   Example: Fri Nov 04 2005 11:03:00 GMT-0800 (Pacific Standard Time)
                             *  Default native browser 'toLocaleString()' implementation. May vary by browser.
                             *   Example: Friday, November 04, 2005 11:03:00 AM
                             *  Short date in format MM/DD/YYYY. Example: 11/4/2005
                             *  Short date with time in format MM/DD/YYYY HH:MM Example: 11/4/2005 11:03
                             *  Short date in format DD/MM/YYYY. Example: 4/11/2005
                             *  Short date with time in format DD/MM/YYYY HH:MM Example: 4/11/2005 11:03
                             *  Short date in format YYYY/MM/DD. Example: 2005/11/4
                             *  Short date with time in format YYYY/MM/DD HH:MM Example: 2005/11/4 11:03
                             *  Date in the format YYYY-MM-DD HH:MM:SS Example: 2005-11-04 11:09:15
                             *  Date in the format &lt;YYYYMMDD&gt;T&lt;HHMMSS&gt;Z Example: 20051104T111001Z
                             * 
                             * 
                             *   Note: In addition to these standard formats, custom formatting can be set by passing
                             *   a function directly to DateUtil.setNormalDisplayFormat et al. This
                             *   function will then be executed whenever the appropriate formatter method is called [eg
                             *   Date.toNormalDate], in the scope of the date instance in question.
                             * 
                             *   Custom formatting can also be applied by passing a FormatString instead of a
                             *   DateDisplayFormat string to DateUtil.setNormalDisplayFormat et al. See
                             *   the FormatString docs for details.
                             */
                            String /* toString |  toLocaleString |  toUSShortDate |  toUSShortDatetime |  toEuropeanShortDate |  toEuropeanShortDatetime |  toJapanShortDate |  toJapanShortDatetime |  toSerializeableDate |  toDateStamp */ = definedExternally
    /**
     *  Time-format to apply to date type values within this formItem. If specified, any
     *   dates displayed in this item will be formatted as times using the appropriate format.
     *   This is most commonly only applied to fields specified as type "time" though
     *   if no explicit FormItem.dateFormatter is specified it will be respected for other
     *   fields as well.
     * 
     *   If unspecified, a timeFormatter may be defined
     *   DynamicForm.timeFormatter and will be respected by fields
     *   of type "time".
     *  @type {TimeDisplayFormat}
     *  @default null
     */
    open var timeFormatter: 
                            /**
                             *  String will display with seconds and am/pm indicator:[H]H:MM:SS am|pm.
                             *   Example: 3:25:15 pm
                             *  String will display with seconds in 24 hour time: [H]H:MM:SS.
                             *   Example: 15:25:15
                             *  String will display with seconds, with a 2 digit hour and am/pm indicator:
                             *   HH:MM:SS am|pm
                             *   Example: 03:25:15 pm
                             *  String will display with seconds, with a 2 digit hour in 24 hour format:
                             *   HH:MM:SS
                             *   Examples: 15:25:15, 03:16:45
                             *  String will have no seconds and be in 12 hour format:[H]H:MM am|pm
                             *   Example: 3:25 pm
                             *  String will have no seconds and be in 24 hour format: [H]H:MM
                             *   Example:15:25
                             *  String will have no seconds and will display a 2 digit hour, in 12 hour clock format:
                             *   HH:MM am|pm
                             *   Example: 03:25 pm
                             *  String will have no seconds and will display with a 2 digit hour in 24 hour clock format:
                             *   HH:MM
                             *   Examples: 15:25, 03:16
                             */
                            String /* toTime |  to24HourTime |  toPaddedTime |  toPadded24HourTime |  toShortTime |  toShort24HourTime |  toShortPaddedTime |  toShortPadded24HourTime */ = definedExternally
    /**
     *  Fields of type "date" or "time" will be edited using
     *   a DateItem or TimeItem by default.
     * 
     *   However this can be overridden - for canEdit:false fields, a
     *   StaticTextItem is used by default, and the developer can always specify
     *   a custom FormItem.editorType as well as FormItem.type.
     * 
     *   For fields of type "date", set this property to a valid
     *   DateDisplayFormat to specify how the date should be formatted.
     * 
     *   For fields of type "time", set this property to a valid
     *   TimeDisplayFormat to specify how the time should be formatted.
     * 
     *   Note that if FormItem.dateFormatter or FormItem.timeFormatter are specified
     *   they will take precedence over this setting.
     * 
     *   If this field is of type "date" and is editable, the
     *   FormItem.inputFormat may be used to specify how user-edited date strings will
     *   be parsed.
     *  @deprecated \* in favor of FormItem.format, FormItem.dateFormatter and FormItem.timeFormatter
     *  @type {any}
     *  @default null
     */
    open var displayFormat: dynamic = definedExternally
    /**
     *  For fields of type "date", if this is an editable field such as a
     *   TextItem, this property
     *   allows you to specify the DateItem.inputFormat applied to the item.
     *  @type {DateInputFormat}
     *  @default null
     */
    open var inputFormat: String = definedExternally
    /**
     *  Applies only to fields of type "float" and affects how many significant digits are shown.
     * 
     *   For example, with decimalPrecision 3, if the field value is 343.672677, 343.673 is shown.
     * 
     *   If the value is 125.2, 125.2 is shown - decimalPrecision will not cause extra zeros to be
     *   added. Use DataSourceField.decimalPad for this.
     * 
     *   A number is always shown with its original precision when edited.
     *  @type {number}
     *  @default null
     */
    open var decimalPrecision: Number = definedExternally
    /**
     *  Applies only to fields of type "float" and enforces a minimum number of digits shown after
     *   the decimal point.
     * 
     *   For example, a field value of 343.1, 343.104 and 343.09872677 would all be shown as 343.10
     *   if decimalPad is 2.
     * 
     *   The original unpadded value is always shown when the value is edited.
     *  @type {number}
     *  @default null
     */
    open var decimalPad: Number = definedExternally
    /**
     *  FormatString for numeric or date formatting. See DataSourceField.format.
     *  @type {FormatString}
     *  @default null
     */
    open var format: String = definedExternally
    /**
     *  FormatString used during exports for numeric or date formatting. See
     *   DataSourceField.exportFormat.
     *  @type {FormatString}
     *  @default null
     */
    open var exportFormat: String = definedExternally
    /**
     *  A mapping of logical form item values to SCImgURLs or the special value "blank",
     *   which means that no image will be displayed.
     *   If specified, when the form item is set to the value in question, an icon will be
     *   displayed with the appropriate source URL.
     *  @type {object}
     *  @default null
     */
    open var valueIcons: dynamic = definedExternally
    /**
     *  This property allows the developer to specify an icon to display when this item has
     *   no value. It is configured in the same way as any other valueIcon
     *   (see FormItem.valueIcons)
     *  @type {string}
     *  @default null
     */
    open var emptyValueIcon: String = definedExternally
    /**
     *  If FormItem.valueIcons is set, this property may be set to show the valueIcon
     *   only and prevent the standard form item element or text from displaying
     *  @type {boolean}
     *  @default null
     */
    open var showValueIconOnly: Boolean = definedExternally
    /**
     *  If FormItem.valueIcons is set, this property may be set to prevent the value
     *   icons from showing up next to the form items value
     *  @type {boolean}
     *  @default null
     */
    open var suppressValueIcon: Boolean = definedExternally
    /**
     *  If FormItem.valueIcons is specified, use this property to specify a width for
     *   the value icon written out.
     *  @type {number}
     *  @default null
     */
    open var valueIconWidth: Number = definedExternally
    /**
     *  If FormItem.valueIcons is specified, use this property to specify a height for the
     *   value icon written out.
     *  @type {number}
     *  @default null
     */
    open var valueIconHeight: Number = definedExternally
    /**
     *  If FormItem.valueIcons is specified, this property may be used to specify both
     *   the width and height of the icon written out.
     *   Note that FormItem.valueIconWidth and FormItem.valueIconHeight take
     *   precedence over this value, if specified.
     *  @type {number}
     *  @default "16"
     */
    open var valueIconSize: Number = definedExternally
    /**
     *  If we're showing a value icon, this attribute governs the amount of space between the
     *   icon and the start edge of the form item cell.
     * 
     *   NOTE: In RTL mode, the valueIconLeftPadding is applied to the right of
     *   the value icon.
     *  @type {number}
     *  @default "0"
     */
    open var valueIconLeftPadding: Number = definedExternally
    /**
     *  If we're showing a value icon, this attribute governs the amount of space between the
     *   icon and the value text.
     * 
     *   NOTE: In RTL mode, the valueIconRightPadding is applied to the left of
     *   the value icon.
     *  @type {number}
     *  @default "3"
     */
    open var valueIconRightPadding: Number = definedExternally
    /**
     *  Prefix to apply to the beginning of any FormItem.valueIcons when determining the
     *   URL for the image.
     *   Will not be applied if the valueIcon URL is absolute.
     *  @type {string}
     *  @default null
     */
    open var imageURLPrefix: String = definedExternally
    /**
     *  Suffix to apply to the end of any FormItem.valueIcons when determining the URL for
     *   the image. A common usage would be to specify a suffix of ".gif" in which
     *   case the valueIcons property would map values to the names of images without
     *   the ".gif" extension.
     *  @type {string}
     *  @default null
     */
    open var imageURLSuffix: String = definedExternally
    /**
     *  A Read-Only pointer to this formItem's DynamicForm widget.
     *  @type {DynamicForm}
     *  @default null
     */
    open var form: DynamicForm = definedExternally
    /**
     *  A Read-Only pointer to the SmartClient canvas that holds this form item. In most cases this
     *   will be the FormItem.form containing the item but in some cases
     *   editable components handle writing out form items directly. An example of this
     *   is editing - when a listGrid shows per-field editors, the
     *   containerWidget for each item will be the listGrid body.
     * 
     *   Note that even if the containerWidget is not a DynamicForm, a DynamicForm
     *   will still exist for the item (available as FormItem.form), allowing access
     *   to standard APIs such as DynamicForm.getValues
     *  @type {Canvas}
     *  @default null
     */
    open var containerWidget: Canvas = definedExternally
    /**
     *  Should we show a special 'picker' FormItemIcon for this form item? Picker
     *   icons are customizable via FormItem.pickerIconProperties. By default
     *   they will be rendered inside the form item's FormItem.controlStyle
     *   area. By default clicking the pickerIcon will call FormItem.showPicker.
     *  @type {boolean}
     *  @default null
     */
    open var showPickerIcon: Boolean = definedExternally
    /**
     *  If FormItem.showPickerIcon is true for this item, should the picker icon show
     *   a focused image when the form item has focus?
     *  @type {boolean}
     *  @default false
     */
    open var showFocusedPickerIcon: Boolean = definedExternally
    /**
     *  Block of default properties to apply to the pickerIcon for this widget.
     *   Intended for class-level customization: To modify this value we recommend using
     *   Class.changeDefaults rather than directly assigning a value to the property.
     *  @type {FormItemIcon}
     *  @default "..."
     */
    open var pickerIconDefaults: FormItemIcon = definedExternally
    /**
     *  If FormItem.showPickerIcon is true for this item, this block of properties will
     *   be applied to the pickerIcon. Allows for advanced customization of this icon.
     *  @type {FormItemIcon}
     *  @default null
     */
    open var pickerIconProperties: FormItemIcon = definedExternally
    /**
     *  If FormItem.showPickerIcon is true, this attribute specifies the
     *   FormItemIcon.name applied to the picker icon
     *  @type {Identifier}
     *  @default "picker"
     */
    open var pickerIconName: String = definedExternally
    /**
     *  If FormItem.showPickerIcon is true for this item, this property governs the
     *   FormItemIcon.src of the picker icon image to be displayed.
     * 
     *   skinning can be used for this image, by setting this property to
     *   a SCSpriteConfig formatted string.
     *  @type {SCImgURL}
     *  @default ""
     */
    open var pickerIconSrc: String = definedExternally
    /**
     *  If FormItem.showPickerIcon is true for this item, this property governs the
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
    open var pickerIconWidth: Number = definedExternally
    /**
     *  If FormItem.showPickerIcon is true for this item, this property governs the
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
    open var pickerIconHeight: Number = definedExternally
    /**
     *  Prompt to show when the user hovers the mouse over the picker icon.
     *  @type {HTMLString}
     *  @default null
     */
    open var pickerIconPrompt: String = definedExternally
    /**
     *  The component that will be displayed when FormItem.showPicker is called due to a click
     *   on the FormItem.showPickerIcon.
     * 
     *   Can be specified directly as a Canvas, or created automatically via the
     *   AutoChild pattern. The default autoChild configuration for the picker is
     *   a Canvas with backgroundColor set and no other modifications.
     * 
     *   Note that the picker is not automatically destroyed with the FormItem that uses it, in
     *   order to allow recycling of picker components. To destroy a single-use picker, override
     *   Canvas.destroy.
     *  @type {Canvas}
     *  @default null
     */
    open var picker: Canvas = definedExternally
    /**
     *  Class name of the picker to be created.
     *  @type {SCClassName}
     *  @default null
     */
    open var pickerConstructor: String = definedExternally
    /**
     *  Default properties for the picker.
     *  @type {Canvas}
     *  @default "{}"
     */
    open var pickerProperties: Canvas = definedExternally
    /**
     *  Validators for this form item.
     * 
     *   Note: these validators will only be run on the client; to
     *   do real client-server validation, validators must be specified via
     *   DataSourceField.validators.
     *  @type {Array<Partial<Validator>>}
     *  @default null
     */
    open var validators: Array<dynamic> = definedExternally
    /**
     *  Whether a non-empty value is required for this field to pass validation.
     * 
     *   If the user does not fill in the required field, the error message to be shown will
     *   be taken from these properties in the following order: FormItem.requiredMessage,
     *   DynamicForm.requiredMessage, DataSource.requiredMessage,
     *   Validator.requiredField.
     * 
     *   Note: if specified on a FormItem, required is only enforced on the
     *   client. required should generally be specified on a
     *   DataSourceField.
     *  @type {boolean}
     *  @default null
     */
    open var required: Boolean = definedExternally
    /**
     *  The required message for required field errors.
     *  @type {HTMLString}
     *  @default null
     */
    open var requiredMessage: String = definedExternally
    /**
     *  Criteria to be evaluated to determine whether this FormItem should be FormItem.required.
     * 
     *   Criteria are evaluated against the ${isc.DocUtils.linkForRef('method:DynamicForm.getValues','form\'s current values')} as well as
     *   the current Canvas.ruleScope. Criteria are re-evaluated every time
     *   form values or the rule context changes, whether by end user action or by programmatic calls.
     * 
     *   A basic criteria uses textMatchStyle:"exact". When specified in
     *   componentXML this property allows
     *   xmlCriteriaShorthand for defining criteria.
     * 
     *   Note: A FormItem using requiredWhen must have a FormItem.name defined.
     *  @type {Criteria}
     *  @default null
     */
    open var requiredWhen: dynamic = definedExternally
    /**
     *  Whether this item is currently visible.
     * 
     *   visible can only be set on creation. After creation, use
     *   FormItem.show and FormItem.hide to manipulate visibility.
     *  @type {boolean}
     *  @default true
     */
    open var visible: Boolean = definedExternally
    /**
     *  Criteria to be evaluated to determine whether this FormItem should be visible.
     * 
     *   Criteria are evaluated against the ${isc.DocUtils.linkForRef('method:DynamicForm.getValues','form\'s current values')} as well as
     *   the current Canvas.ruleScope. Criteria are re-evaluated every time
     *   form values or the rule context changes, whether by end user action or by programmatic calls.
     * 
     *   If both FormItem.showIf and visibleWhen are specified, visibleWhen is
     *   ignored.
     * 
     *   A basic criteria uses textMatchStyle:"exact". When specified in
     *   componentXML this property allows
     *   xmlCriteriaShorthand for defining criteria.
     * 
     *   Note: A FormItem using visibleWhen must have a FormItem.name defined. FormItem.shouldSaveValue can
     *   be set to false to prevent the field from storing its value
     *   into the form's values.
     *  @type {AdvancedCriteria}
     *  @default null
     */
    open var visibleWhen: AdvancedCriteria = definedExternally
    /**
     *  Is this form item editable (canEdit:true) or read-only (canEdit:false)? Setting the
     *   form item to non-editable causes it to render as read-only. Can be updated at runtime via
     *   the FormItem.setCanEdit method.
     * 
     *   Read-only appearance may be specified via FormItem.readOnlyDisplay.
     *   The default setting for this value ("readOnly") differs from
     *   the disabled state in that the form item is not rendered with disabled styling and
     *   most form items will allow copying of the contents while read-only but do not while
     *   disabled.
     * 
     *   Note that for forms bound to a DataSource, if this property is not explicitly
     *   set at the item level, its default value will match the
     *   DynamicForm.canEditFieldAttribute on the associated dataSource field.
     * 
     *   Developers should also be aware that the FormItem.readOnlyDisplay attribute is
     *   unrelated to the DataSourceField.readOnlyEditorType attribute. When a
     *   DynamicForm is first bound to a dataSource, for
     *   DataSourceField.canEdit DataSourceFields,
     *   DataSourceField.readOnlyEditorType will determine what FormItemType
     *   should be created for the field. Once created, a FormItem's type can not be changed.
     *   Setting FormItem.canEdit at runtime will simply change the appearance
     *   of the item to allow or disallow editing of the item.
     * 
     * 
     *  @type {boolean}
     *  @default null
     */
    open var canEdit: Boolean = definedExternally
    /**
     *  If this item is FormItem.getCanEdit, how should this item be displayed
     *   to the user? If set, overrides the form-level DynamicForm.readOnlyDisplay default.
     *  @type {ReadOnlyDisplayAppearance}
     *  @default null
     */
    open var readOnlyDisplay: 
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
     *  Base text box style to apply when this item is FormItem.getCanEdit and
     *   is using FormItem.readOnlyDisplay
     *   "static".
     * 
     *   If set, overrides the form-level DynamicForm.readOnlyTextBoxStyle default.
     *  @type {FormItemBaseStyle}
     *  @default null
     */
    open var readOnlyTextBoxStyle: String = definedExternally
    /**
     *  If this item is FormItem.getCanEdit and is using
     *   FormItem.readOnlyDisplay
     *   "static",
     * 
     *   should the item value be clipped if it overflows the specified size of the item?
     *   If set, overrides the form-level DynamicForm.clipStaticValue default.
     *  @type {boolean}
     *  @default null
     */
    open var clipStaticValue: Boolean = definedExternally
    /**
     *  Criteria to be evaluated to determine whether this FormItem should be made
     *   FormItem.setCanEdit. Appearance when read-only is determined by
     *   FormItem.readOnlyDisplay.
     * 
     *   Criteria are evaluated against the ${isc.DocUtils.linkForRef('method:DynamicForm.getValues','form\'s current values')} as well as
     *   the current Canvas.ruleScope. Criteria are re-evaluated every time
     *   form values or the rule context changes, whether by end user action or by programmatic calls.
     * 
     *   A basic criteria uses textMatchStyle:"exact". When specified in
     *   componentXML this property allows
     *   xmlCriteriaShorthand for defining criteria.
     * 
     *   Note: A FormItem using readOnlyWhen must have a FormItem.name defined. FormItem.shouldSaveValue can
     *   be set to false to prevent the field from storing its value
     *   into the form's values.
     *  @type {AdvancedCriteria}
     *  @default null
     */
    open var readOnlyWhen: AdvancedCriteria = definedExternally
    /**
     *  Whether this item is disabled. Can be updated at runtime via the setDisabled()
     *   method. Note that if the widget containing this formItem is disabled, the formItem will
     *   behave in a disabled manner regardless of the setting of the item.disabled property.
     * 
     *   Note that not all items can be disabled, and not all browsers show an obvious disabled style
     *   for native form elements.
     *  @type {boolean}
     *  @default false
     */
    open var disabled: Boolean = definedExternally
    /**
     *  If FormItem.canEdit is set to false, should FormItem.icons be disabled
     *   by default?
     * 
     *   This may also be specified at the icon level. See FormItemIcon.disableOnReadOnly.
     *  @type {boolean}
     *  @default true
     */
    open var disableIconsOnReadOnly: Boolean = definedExternally
    /**
     *  Is this form item focusable? Setting this property to true on an otherwise
     *   non-focusable element such as a StaticTextItem will cause the item to be
     *   included in the page's tab order and respond to keyboard events.
     *  @type {boolean}
     *  @default null
     */
    open var canFocus: Boolean = definedExternally
    /**
     *  If specified this governs the HTML accessKey for the item.
     * 
     *   This should be set to a character - when a user hits the html accessKey modifier for
     *   the browser, plus this character, focus will be given to the item.
     *   The accessKey modifier can vary by browser and platform.
     * 
     *   The following list of default behavior is for reference only, developers should also
     *   consult browser documentation for additional information.
     * 
     * 
     *  - Internet Explorer (all platforms): Alt + accessKey
     * 
     *  - Mozilla Firefox (Windows, Unix): Alt+Shift + accessKey
     * 
     *  - Mozilla Firefox (Mac): Ctrl+Opt + accessKey
     * 
     *  - Chrome and Safari (Windows, Unix): Alt + accessKey
     * 
     *  - Chrome and Safari (Mac): Ctrl+Opt + accessKey
     * 
     *  @type {string}
     *  @default null
     */
    open var accessKey: String = definedExternally
    /**
     *  TabIndex for the form item within the form, which controls the order in which controls
     *   are visited when the user hits the tab or shift-tab keys to navigate between items.
     * 
     *   tabIndex is automatically assigned as the order that items appear in the
     *   DynamicForm.items list.
     * 
     *   To specify the tabindex of an item within the page as a whole (not just this form), use
     *   FormItem.globalTabIndex instead.
     *  @type {Integer}
     *  @default null
     */
    open var tabIndex: Number = definedExternally
    /**
     *  TabIndex for the form item within the page. Takes precedence over any local tab index
     *   specified as FormItem.tabIndex.
     * 
     *   Use of this API is extremely advanced and essentially implies taking over
     *   management of tab index assignment for all components on the page.
     *  @type {Integer}
     *  @default null
     */
    open var globalTabIndex: Number = definedExternally
    /**
     *  Allows the DynamicForm.selectOnFocus behavior to be configured on a
     *   per-FormItem basis. Normally all items in a form default to the value of
     *   DynamicForm.selectOnFocus.
     *  @type {boolean}
     *  @default null
     */
    open var selectOnFocus: Boolean = definedExternally
    /**
     *  Allows the DynamicForm.selectOnClick behavior to be configured on a
     *   per-FormItem basis. Normally all items in a form default to the value of
     *   DynamicForm.selectOnClick.
     *  @type {boolean}
     *  @default null
     */
    open var selectOnClick: Boolean = definedExternally
    /**
     *  Should this form item fire its FormItem.change handler (and store its
     *   value in the form) on every keypress? Set to false to suppress the 'change'
     *   handler firing (and the value stored) on every keypress.
     * 
     *   Note: If false, the value returned by FormItem.getValue
     *   will not reflect the value displayed in the form item element as long as focus is in
     *   the form item element.
     *  @type {boolean}
     *  @default true
     */
    open var changeOnKeypress: Boolean = definedExternally
    /**
     *  Should we show a title cell for this formItem?
     * 
     *   Note: the default value of this attribute is overridden by some subclasses.
     *  @type {boolean}
     *  @default true
     */
    open var showTitle: Boolean = definedExternally
    /**
     *  On which side of this item should the title be placed. TitleOrientation
     *   lists valid options.
     * 
     *   Note that titles on the left or right take up a cell in tabular
     *   formLayout, but titles on top do not.
     *  @type {TitleOrientation}
     *  @default "left"
     */
    open var titleOrientation: String /* left |  top |  right */ = definedExternally
    /**
     *  Alignment of this item's title in its cell.
     * 
     *   If null, dynamically set according to text direction.
     *  @type {Alignment}
     *  @default null
     */
    open var titleAlign: 
                         /**
                          *  Center within container.
                          *  Stick to left side of container.
                          *  Stick to right side of container.
                          */
                         String /* center |  left |  right */ = definedExternally
    /**
     *  Vertical alignment of this item's title in its cell. Only applies when
     *   FormItem.titleOrientation is "left" or "right".
     *  @type {VerticalAlignment}
     *  @default "center"
     */
    open var titleVAlign: 
                          /**
                           *  At the top of the container
                           *  Center within container.
                           *  At the bottom of the container
                           */
                          String /* top |  center |  bottom */ = definedExternally
    /**
     *  If the title for this form item is showing, and is too large for the available space
     *   should the title be clipped?
     * 
     *   Null by default - if set to true or false, overrides DynamicForm.clipItemTitles.
     *  @type {boolean}
     *  @default null
     */
    open var clipTitle: Boolean = definedExternally
    /**
     *  If specified determines whether this items title should wrap.
     *   Overrides DynamicForm.wrapItemTitles at the DynamicForm level.
     *  @type {boolean}
     *  @default null
     */
    open var wrapTitle: Boolean = definedExternally
    /**
     *  If true, this item will cause the entire form to be redrawn
     *   when the item's "elementChanged" event is done firing
     *  @type {boolean}
     *  @default false
     */
    open var redrawOnChange: Boolean = definedExternally
    /**
     *  If true, form items will be validated when each item's "change" handler is fired
     *   as well as when the entire form is submitted or validated.
     * 
     *   Note that this property can also be set at the form level or on each validator;
     *   If true at the form or field level, validators not explicitly set with
     *   validateOnChange:false will be fired on change - displaying errors and
     *   rejecting the change on validation failure.
     *  @type {boolean}
     *  @default false
     */
    open var validateOnChange: Boolean = definedExternally
    /**
     *  If true, form items will be validated when each item's "editorExit" handler is fired
     *   as well as when the entire form is submitted or validated.
     * 
     *   Note that this property can also be set at the form level.
     *   If true at either level the validator will be fired on editorExit.
     *  @type {boolean}
     *  @default false
     */
    open var validateOnExit: Boolean = definedExternally
    /**
     *  Indicates that if validation fails, the user should not be allowed to exit
     *   the field - focus will be forced back into the field until the error is corrected.
     * 
     *   This property defaults to DynamicForm.stopOnError if unset.
     * 
     *   Enabling this property also implies FormItem.validateOnExit is automatically
     *   enabled. If there are server-based validators on this item, setting this property
     *   also implies that FormItem.synchronousValidation is forced on.
     *  @type {boolean}
     *  @default null
     */
    open var stopOnError: Boolean = definedExternally
    /**
     *  If validateOnChange is true, and validation fails for this item on change, with no suggested
     *   value, should we revert to the previous value, or continue to display the bad value entered
     *   by the user. May be set at the item or form level.
     *  @type {boolean}
     *  @default false
     */
    open var rejectInvalidValueOnChange: Boolean = definedExternally
    /**
     *  If enabled, whenever validation is triggered and a request to the server is required,
     *   user interactivity will be blocked until the request returns. Can be set for the entire
     *   form or individual FormItems.
     * 
     *   If false, the form will try to avoid blocking user interaction until it is strictly
     *   required. That is until the user attempts to use a FormItem whose state could be
     *   affected by a server request that has not yet returned.
     *  @type {boolean}
     *  @default null
     */
    open var synchronousValidation: Boolean = definedExternally
    /**
     *  Width of the FormItem. Can be either a number indicating a fixed width in pixels, or
     *   "\*" indicating the FormItem fills the space allocated to it's column (or columns, for a
     *   FormItem.colSpan item).
     * 
     * 
     *   See the formLayout overview for details.
     *  @type {Integer | string}
     *  @default "\*"
     */
    open var width: dynamic = definedExternally
    /**
     *  Height of the FormItem. Can be either a number indicating a fixed height in pixels, a
     *   percentage indicating a percentage of the overall form's height, or "\*" indicating take
     *   whatever remaining space is available. See the formLayout overview for details.
     * 
     * 
     *   For form items having a FormItem.showPickerIcon (e.g. SelectItem,
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
     *   Alternatively, the FormItem.pickerIconStyle could be changed to a
     *   custom CSS style name, and in the case of SpinnerItems,
     *   the FormItemIcon.baseStyle and
     *   FormItemIcon.src of the SpinnerItem.increaseIcon
     *   and SpinnerItem.decreaseIcon AutoChildren could be customized.
     * 
     *   Note that when FormItem is rendered as read-only with readOnlyDisplay as "static"
     *   the property FormItem.staticHeight is used instead.
     *  @type {Integer | string}
     *  @default "20"
     */
    open var height: dynamic = definedExternally
    /**
     *  Height of the FormItem when canEdit is false and
     *   readOnlyDisplay is "static". The normal FormItem.height is used
     *   if this property is not set.
     *  @type {Integer}
     *  @default null
     */
    open var staticHeight: Number = definedExternally
    /**
     *  If specified, this property will govern the height of the cell in which this form
     *   item is rendered.
     *   Will not apply when the containing DynamicForm sets itemLayout:"absolute".
     *  @type {number}
     *  @default null
     */
    open var cellHeight: Number = definedExternally
    /**
     *  Number of columns that this item's title spans.
     * 
     *   This setting only applies for items that are showing a title and whose
     *   TitleOrientation is either "left" or "right".
     *  @type {number}
     *  @default "1"
     */
    open var titleColSpan: Number = definedExternally
    /**
     *  Number of columns that this item spans.
     * 
     *   The colSpan setting does not include the title shown for items with
     *   FormItem.showTitle:true, so the effective colSpan is one higher than this
     *   setting for items that are showing a title and whose TitleOrientation is either
     *   "left" or "right".
     *  @type {Integer | string}
     *  @default "1"
     */
    open var colSpan: dynamic = definedExternally
    /**
     *  Number of rows that this item spans
     *  @type {number}
     *  @default "1"
     */
    open var rowSpan: Number = definedExternally
    /**
     *  Whether this item should always start a new row in the form layout.
     *  @type {boolean}
     *  @default false
     */
    open var startRow: Boolean = definedExternally
    /**
     *  Whether this item should end the row it's in in the form layout
     *  @type {boolean}
     *  @default false
     */
    open var endRow: Boolean = definedExternally
    /**
     *  Alignment of this item in its cell. Note that the alignment of text / content within this
     *   item is controlled separately via FormItem.textAlign (typically textAlign
     *   applies to items showing a "textBox", such as a TextItem or SelectItem,
     *   as well as text-only form item types such as StaticTextItem and HeaderItem).
     *   If FormItem.applyAlignToText is true, then the textAlign
     *   setting, if unset, will default to the align setting if set.
     *  @type {Alignment}
     *  @default null
     */
    open var align: 
                    /**
                     *  Center within container.
                     *  Stick to left side of container.
                     *  Stick to right side of container.
                     */
                    String /* center |  left |  right */ = definedExternally
    /**
     *  Vertical alignment of this item within its cell. This property governs the position
     *   of the item's text box within the cell (not the content within the text box).
     *   If FormItem.shouldApplyHeightToTextBox is true, for this to have a visible effect,
     *   the cell height must exceed the specified height of the item, either due to
     *   an explicit FormItem.cellHeight specification, or due to the row being expanded
     *   by another taller item.
     * 
     *   Has no effect if DynamicForm.itemLayout is set to "absolute" for the
     *   form.
     *  @type {VerticalAlignment}
     *  @default "center"
     */
    open var vAlign: 
                     /**
                      *  At the top of the container
                      *  Center within container.
                      *  At the bottom of the container
                      */
                     String /* top |  center |  bottom */ = definedExternally
    /**
     *  Alignment of the text / content within this form item. Note that FormItem.align may
     *   be used to control alignment of the entire form item within its cell. textAlign
     *   does not apply to all form item types; typically it applies only to items showing a "textBox",
     *   such as a TextItem or SelectItem, as well as text-only form item types
     *   such as StaticTextItem and HeaderItem.
     * 
     *   If FormItem.applyAlignToText is true, then textAlign
     *   will default to the align setting if set. Otherwise, if this item has
     *   FormItem.icons, then textAlign will default to
     *   "left"
     * 
     *   ("right"
     * 
     *   in Page.isRTL).
     *  @type {Alignment}
     *  @default null
     */
    open var textAlign: 
                        /**
                         *  Center within container.
                         *  Stick to left side of container.
                         *  Stick to right side of container.
                         */
                        String /* center |  left |  right */ = definedExternally
    /**
     *  If the FormItem.textAlign is unset, should the FormItem.align
     *   setting, if set, be used for this item's textAlign?
     * 
     *   applyAlignToText defaults to false for most form item types. It defaults
     *   to true for StaticTextItem and HeaderItem, which are text-based form item
     *   types that do not have a natural distinction between the item and its cell.
     *  @type {boolean}
     *  @default false
     */
    open var applyAlignToText: Boolean = definedExternally
    /**
     *  Left coordinate of this item in pixels. Applies only when the containing DynamicForm
     *   sets itemLayout:"absolute".
     *  @type {Integer}
     *  @default "0"
     */
    open var left: Number = definedExternally
    /**
     *  Top coordinate of this item in pixels. Applies only when the containing DynamicForm
     *   sets itemLayout:"absolute".
     *  @type {Integer}
     *  @default "0"
     */
    open var top: Number = definedExternally
    /**
     *  Set of autocompletion keywords to be used with the native "autocomplete" attribute,
     *   in accordance with the
     *   HTML5 Autofill specification.
     * 
     *   When autoCompleteKeywords are provided, the FormItem.autoComplete setting is ignored.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var autoCompleteKeywords: Array<dynamic> = definedExternally
    /**
     *  Should this item allow browser auto-completion of its value?
     *   Applies only to items based on native HTML form elements (TextItem,
     *   PasswordItem, etc), and will only have a user-visible impact for browsers
     *   where native autoComplete behavior is actually supported and enabled via user settings.
     * 
     *   Alternatively, FormItem.autoCompleteKeywords can be specified, in which case
     *   this setting is ignored. If autoCompleteKeywords are not provided, and
     *   autoComplete is not set on this FormItem, the value of
     *   DynamicForm.autoComplete is used.
     * 
     *   Note that even with this value set to "none", native browser
     *   auto-completion may occur for log in forms (forms containing username and
     *   PasswordItem fields). This behavior varies by browser, and is
     *   a result of an
     *   intentional change by some browser developers
     *   to disregard the HTML setting autocomplete=off for password items or
     *   log-in forms.
     * 
     *   In some browsers any form redraw (including a redraw from a call to
     *   DynamicForm.setValues) will re-populate the form with the natively
     *   remembered login credentials. This can make it very difficult to control the
     *   values displayed to the user, as a call to 'setValues()' may appear to be ignored.
     *   While behavior varies by browser we have specifically
     *   observed this behavior in Safari. Moreover in this browser, if the user
     *   asks the browser to remember login credentials for a URL, any form with a password
     *   item and a text item may be auto-filled with the remembered login credentials,
     *   even if the form's configuration and field names differ from those on the
     *   login form.
     * 
     *   If an application has both an initial log in form, and a separate form within
     *   the application which makes contains a Password item (a use case might be an
     *   interface for a user with manager privileges for modifying other users' passwords),
     *   this will cause the second form to autofill with unexpected values.
     * 
     *   Should this arise, developers can avoid this by making the initial log in
     *   interface into a separate log in page from the main application page.
     *   This is often good practice in any case for reasons outlined in the
     *   "Authentication" section of the Quick Start guide.
     *  @type {AutoComplete}
     *  @default null
     */
    open var autoComplete: 
                           /**
                            *  Disable browser autoComplete. Note that some browsers will disregard  this setting and still perform native autoComplete for certain items - typically
                            *    only for log in / password forms. See the discussion FormItem.autoComplete.
                            *  Allow native browser autoComplete.
                            */
                           String /* none |  native */ = definedExternally
    /**
     *  If this browser supports spell-checking of text editing elements, do we want this
     *   enabled for this item? If unset the property will be inherited from the containing form.
     * 
     *   Notes:
     *   - this property only applies to text based items such as TextItem and TextAreaItem.
     *   - this property is not supported on all browsers.
     *  @type {boolean}
     *  @default null
     */
    open var browserSpellCheck: Boolean = definedExternally
    /**
     *  Form item input type - governs which keyboard should be displayed for
     *   mobile devices (supported on iPhone / iPad)
     *  @type {string}
     *  @default null
     */
    open var browserInputType: String = definedExternally
    /**
     *  An array of descriptor objects for icons to display in a line after this form item.
     *   These icons are clickable images, often used to display some kind of helper for
     *   populating a form item.
     *  @type {Array<Partial<FormItemIcon>>}
     *  @default null
     */
    open var icons: Array<dynamic> = definedExternally
    /**
     *  Default icon image source.
     *   Specify as the partial URL to an image, relative to the imgDir of this component.
     *   To specify image source for a specific icon use the icon.src property.
     *   If this item is drawn in the disabled state, the url will be modified by adding
     *   "_Disabled" to get a disabled state image for the icon.
     *   If icon.showOver is true, this url will be modified by adding "_Over" to get
     *   an over state image for the icon.
     * 
     *   skinning can be used for this image, by setting this property to
     *   a SCSpriteConfig formatted string.
     *  @type {SCImgURL}
     *  @default "[SKIN]/DynamicForm/default_formItem_icon.gif"
     */
    open var defaultIconSrc: String = definedExternally
    /**
     *  If we're showing icons, should we change their image source to the appropriate over
     *   source when the user rolls over (or puts focus onto) them? Can be overridden on a per
     *   icon basis by the formItemIcon showOver property.
     *  @type {boolean}
     *  @default null
     */
    open var showOverIcons: Boolean = definedExternally
    /**
     *  If we're showing icons, should we change their image source to the appropriate
     *   focused source when this item has focus? Can be overridden on a per
     *   icon basis by the formItemIcon showFocused property.
     *  @type {boolean}
     *  @default null
     */
    open var showFocusedIcons: Boolean = definedExternally
    /**
     *  Horizontal space (in px) to leave between form item icons. The space appears either on
     *   the left or right of each icon. May be overridden at the icon level via FormItemIcon.hspace.
     *   Must be non-negative.
     *  @type {Integer}
     *  @default "3"
     */
    open var iconHSpace: Number = definedExternally
    /**
     *  How should icons be aligned vertically for this form item.
     *  @type {VerticalAlignment}
     *  @default "bottom"
     */
    open var iconVAlign: 
                         /**
                          *  At the top of the container
                          *  Center within container.
                          *  At the bottom of the container
                          */
                         String /* top |  center |  bottom */ = definedExternally
    /**
     *  Default width for form item icons. May be overridden at the icon level by FormItemIcon.width.
     *  @type {Integer}
     *  @default "20"
     */
    open var iconWidth: Number = definedExternally
    /**
     *  Default height for form item icons. May be overridden at the icon level by FormItemIcon.height.
     *  @type {Integer}
     *  @default "20"
     */
    open var iconHeight: Number = definedExternally
    /**
     *  This text is shown as a tooltip prompt when the cursor hovers over this item.
     *   When item is FormItem.setCanEdit a different hover can be shown with
     *   FormItem.readOnlyHover.
     *  @type {HTMLString}
     *  @default null
     */
    open var prompt: String = definedExternally
    /**
     *  This text is shown as a tooltip prompt when the cursor hovers over this item
     *   and the item is FormItem.setCanEdit.
     *  @type {HTMLString}
     *  @default null
     */
    open var readOnlyHover: String = definedExternally
    /**
     *  Default prompt (and tooltip-text) for icons.
     *  @type {HTMLString}
     *  @default ""
     */
    open var iconPrompt: String = definedExternally
    /**
     *  Set to false to suppress writing out any FormItem.icons for this item.
     *  @type {boolean}
     *  @default true
     */
    open var showIcons: Boolean = definedExternally
    /**
     *  Show the FormItem.icons when the item gets focus, and hide them when it loses focus.
     *   Can be overridden at the icon level by FormItemIcon.showOnFocus.
     * 
     *   Note that icons marked as disabled will not be shown on focus even if this flag is
     *   true by default. This may be overridden by FormItem.showDisabledIconsOnFocus.
     *  @type {boolean}
     *  @default null
     */
    open var showIconsOnFocus: Boolean = definedExternally
    /**
     *  If FormItem.showIconsOnFocus is true, should icons marked as disabled be
     *   shown on focus?
     * 
     *   Default setting is false - it is not commonly desirable to
     *   present a user with a disabled icon on focus.
     * 
     *   Can be overridden at the icon level by FormItemIcon.showDisabledOnFocus
     *  @type {boolean}
     *  @default false
     */
    open var showDisabledIconsOnFocus: Boolean = definedExternally
    /**
     *  Show the picker icon when the item gets focus, and hide it when it loses focus. Can be
     *   overridden at the icon level by FormItemIcon.showOnFocus.
     * 
     *   Note that a pickerIcon marked as disabled will not be shown on focus even if this flag is
     *   true by default. This may be overridden by FormItem.showDisabledIconsOnFocus.
     *  @type {boolean}
     *  @default null
     */
    open var showPickerIconOnFocus: Boolean = definedExternally
    /**
     *  If FormItem.showPickerIconOnFocus is true, should the picker icon be
     *   shown on focus if it is disabled (as in a read-only item, for example?)
     * 
     *   Default setting is false - it is not commonly desirable to
     *   present a user with a disabled icon on focus.
     * 
     *   Can be overridden at the icon level by FormItemIcon.showDisabledOnFocus
     *  @type {boolean}
     *  @default false
     */
    open var showDisabledPickerIconOnFocus: Boolean = definedExternally
    /**
     *  Should this item's FormItem.icons and
     *   FormItem.showPickerIcon be included in
     *   the page's tab order by default? If not explicitly set, this property
     *   will be derived from DynamicForm.canTabToIcons.
     * 
     *   Developers may also suppress tabbing to individual icons by
     *   setting FormItemIcon.tabIndex to -1.
     * 
     *   Note that if this form item has tabIndex -1, neither the form item nor the icons
     *   will be included in the page's tab order.
     *  @type {boolean}
     *  @default null
     */
    open var canTabToIcons: Boolean = definedExternally
    /**
     *  Height of the error icon, if we're showing icons when validation errors occur.
     *  @type {number}
     *  @default "16"
     */
    open var errorIconHeight: Number = definedExternally
    /**
     *  Height of the error icon, if we're showing icons when validation errors occur.
     *  @type {number}
     *  @default "16"
     */
    open var errorIconWidth: Number = definedExternally
    /**
     *  URL of the image to show as an error icon, if we're showing icons when validation
     *   errors occur.
     *  @type {SCImgURL}
     *  @default "[SKIN]/DynamicForm/validation_error_icon.png"
     */
    open var errorIconSrc: String = definedExternally
    /**
     *  DynamicForm.showErrorIcons,
     *   DynamicForm.showErrorText, and
     *   DynamicForm.showErrorStyle control how validation errors are
     *   displayed when they are displayed inline in the form (next to the form item where there
     *   is a validation error). To instead display all errors at the top of the form, set
     *   DynamicForm.showInlineErrors:false.
     * 
     *   showErrorIcons, showErrorText and showErrorStyle
     *   are all boolean properties, and can be set on a DynamicForm to control the behavior
     *   form-wide, or set on individual FormItems.
     * 
     *   The HTML displayed next to a form item with errors is generated by
     *   FormItem.getErrorHTML.
     *   The default implementation of that method respects showErrorIcons and
     *   showErrorText as follows:
     * 
     *   showErrorIcons, or showErrorIcon at the FormItem level controls
     *   whether an error icon should appear next to fields which have validation errors. The icon's
     *   appearance is governed by FormItem.errorIconSrc, FormItem.errorIconWidth and
     *   FormItem.errorIconHeight
     * 
     *   showErrorText determines whether the text of the validation error should be
     *   displayed next to fields which have validation errors. The attribute
     *   DynamicForm.showTitlesWithErrorMessages may be set to prefix error messages with the
     *   form item's title + ":" (may be desired if the item has
     *   FormItem.showTitle set to false).
     * 
     *   DynamicForm.errorOrientation controls where the error HTML should appear relative
     *   to form items. Therefore the combination of FormItem.showErrorText:false and
     *   FormItem.errorOrientation:"left" creates a compact validation error display
     *   consisting of just an icon, to the left of the item with the error message
     *   available via a hover (similar appearance to ListGrid validation error display).
     * 
     *   In addition to this, showErrorStyle determines whether fields with validation
     *   errors should have special styling applied to them. Error styling is achieved by
     *   applying suffixes to existing styling applied to various parts of the form item.
     *   See FormItemBaseStyle for more on this.
     *  @type {boolean}
     *  @default null
     */
    open var showErrorIcon: Boolean = definedExternally
    /**
     *  DynamicForm.showErrorIcons,
     *   DynamicForm.showErrorText, and
     *   DynamicForm.showErrorStyle control how validation errors are
     *   displayed when they are displayed inline in the form (next to the form item where there
     *   is a validation error). To instead display all errors at the top of the form, set
     *   DynamicForm.showInlineErrors:false.
     * 
     *   showErrorIcons, showErrorText and showErrorStyle
     *   are all boolean properties, and can be set on a DynamicForm to control the behavior
     *   form-wide, or set on individual FormItems.
     * 
     *   The HTML displayed next to a form item with errors is generated by
     *   FormItem.getErrorHTML.
     *   The default implementation of that method respects showErrorIcons and
     *   showErrorText as follows:
     * 
     *   showErrorIcons, or showErrorIcon at the FormItem level controls
     *   whether an error icon should appear next to fields which have validation errors. The icon's
     *   appearance is governed by FormItem.errorIconSrc, FormItem.errorIconWidth and
     *   FormItem.errorIconHeight
     * 
     *   showErrorText determines whether the text of the validation error should be
     *   displayed next to fields which have validation errors. The attribute
     *   DynamicForm.showTitlesWithErrorMessages may be set to prefix error messages with the
     *   form item's title + ":" (may be desired if the item has
     *   FormItem.showTitle set to false).
     * 
     *   DynamicForm.errorOrientation controls where the error HTML should appear relative
     *   to form items. Therefore the combination of FormItem.showErrorText:false and
     *   FormItem.errorOrientation:"left" creates a compact validation error display
     *   consisting of just an icon, to the left of the item with the error message
     *   available via a hover (similar appearance to ListGrid validation error display).
     * 
     *   In addition to this, showErrorStyle determines whether fields with validation
     *   errors should have special styling applied to them. Error styling is achieved by
     *   applying suffixes to existing styling applied to various parts of the form item.
     *   See FormItemBaseStyle for more on this.
     *  @type {boolean}
     *  @default null
     */
    open var showErrorText: Boolean = definedExternally
    /**
     *  DynamicForm.showErrorIcons,
     *   DynamicForm.showErrorText, and
     *   DynamicForm.showErrorStyle control how validation errors are
     *   displayed when they are displayed inline in the form (next to the form item where there
     *   is a validation error). To instead display all errors at the top of the form, set
     *   DynamicForm.showInlineErrors:false.
     * 
     *   showErrorIcons, showErrorText and showErrorStyle
     *   are all boolean properties, and can be set on a DynamicForm to control the behavior
     *   form-wide, or set on individual FormItems.
     * 
     *   The HTML displayed next to a form item with errors is generated by
     *   FormItem.getErrorHTML.
     *   The default implementation of that method respects showErrorIcons and
     *   showErrorText as follows:
     * 
     *   showErrorIcons, or showErrorIcon at the FormItem level controls
     *   whether an error icon should appear next to fields which have validation errors. The icon's
     *   appearance is governed by FormItem.errorIconSrc, FormItem.errorIconWidth and
     *   FormItem.errorIconHeight
     * 
     *   showErrorText determines whether the text of the validation error should be
     *   displayed next to fields which have validation errors. The attribute
     *   DynamicForm.showTitlesWithErrorMessages may be set to prefix error messages with the
     *   form item's title + ":" (may be desired if the item has
     *   FormItem.showTitle set to false).
     * 
     *   DynamicForm.errorOrientation controls where the error HTML should appear relative
     *   to form items. Therefore the combination of FormItem.showErrorText:false and
     *   FormItem.errorOrientation:"left" creates a compact validation error display
     *   consisting of just an icon, to the left of the item with the error message
     *   available via a hover (similar appearance to ListGrid validation error display).
     * 
     *   In addition to this, showErrorStyle determines whether fields with validation
     *   errors should have special styling applied to them. Error styling is achieved by
     *   applying suffixes to existing styling applied to various parts of the form item.
     *   See FormItemBaseStyle for more on this.
     *  @type {boolean}
     *  @default null
     */
    open var showErrorStyle: Boolean = definedExternally
    /**
     *  If DynamicForm.showInlineErrors is true, where should the error icon and text appear
     *   relative to the form item itself. Valid options are "top",
     *   "bottom", "left" or "right".
     *   If unset the orientation will be derived from DynamicForm.errorOrientation.
     *  @type {string}
     *  @default null
     */
    open var errorOrientation: String = definedExternally
    /**
     *  Specifies "hint" string to show next to the form item to indicate something to the user.
     *   This string generally appears to the right of the form item.
     *  @type {HTMLString}
     *  @default null
     */
    open var hint: String = definedExternally
    /**
     *  If a hint is defined for this form item, should it be shown?
     *  @type {boolean}
     *  @default true
     */
    open var showHint: Boolean = definedExternally
    /**
     *  If this item is showing a FormItem.hint, should the hint text be allowed to
     *   wrap? Setting this property to false will render the hint on a single line
     *   without wrapping, expanding the width required to render the item if necessary.
     * 
     *   If unset this property will be picked up from the DynamicForm.wrapHintText
     *   setting.
     * 
     *   This setting does not apply to hints that are TextItem.showHintInField.
     *  @type {boolean}
     *  @default null
     */
    open var wrapHintText: Boolean = definedExternally
    /**
     *  If this item is showing a FormItem.hint, this setting specifies how much
     *   horizontal space is made available for rendering the hint text by default.
     *   Typically this reflects how much space the hint text takes up before it wraps.
     * 
     *   Note that the presence of a hint may cause a form item to expand horizontally past its
     *   specified FormItem.width.
     *   This property value acts as a minimum - if the hint text can not wrap within this width
     *   (either due to FormItem.wrapHintText being set to false, or
     *   due to it containing long, un-wrappable content), it will further expand to take
     *   up the space it needs.
     * 
     *   If unset this property will be picked up from the DynamicForm.minHintWidth
     *   setting.
     * 
     *   This setting does not apply to hints that are TextItem.showHintInField.
     *  @type {Integer}
     *  @default null
     */
    open var minHintWidth: Number = definedExternally
    /**
     *  When this item receives focus, should it be re-styled to indicate it has focus?
     * 
     *   See formItemStyling for more details on formItem styling.
     *  @type {boolean}
     *  @default false
     */
    open var showFocused: Boolean = definedExternally
    /**
     *  When the user rolls over this item, should it be re-styled to indicate it has focus?
     * 
     *   When enabled, the "Over" styling is applied to the text box,
     *   control table (if present), and pickerIcon (if present), and any icons
     *   where FormItemIcon.showOver is true and FormItemIcon.showOverWhen is
     *   set to "textBox".
     *   These behaviors can be disabled piecemeal via FormItem.updateTextBoxOnOver,
     *   FormItem.updateControlOnOver and FormItem.updatePickerIconOnOver properties.
     * 
     *   Developers may also show rollover styling for other icons (see
     *   FormItem.showOverIcons and FormItemIcon.showOverWhen).
     * 
     *   See formItemStyling for more details on formItem styling.
     *  @type {boolean}
     *  @default false
     */
    open var showOver: Boolean = definedExternally
    /**
     *  If FormItem.showOver is true, setting this property to false will explicitly
     *   disable showing the "Over" state for the TextBox element of this item.
     *  @type {boolean}
     *  @default null
     */
    open var updateTextBoxOnOver: Boolean = definedExternally
    /**
     *  If FormItem.showOver is true, setting this property to false will explicitly
     *   disable showing the "Over" state for the control table element of
     *   this item (if present).
     *  @type {boolean}
     *  @default null
     */
    open var updateControlOnOver: Boolean = definedExternally
    /**
     *  If FormItem.showOver is true, setting this property to false will explicitly
     *   disable showing the "Over" state for the PickerIcon of this item (if present)
     *  @type {boolean}
     *  @default null
     */
    open var updatePickerIconOnOver: Boolean = definedExternally
    /**
     *  When this item is disabled, should it be re-styled to indicate its disabled state?
     * 
     *   See formItemStyling for more details on formItem styling.
     *  @type {boolean}
     *  @default true
     */
    open var showDisabled: Boolean = definedExternally
    /**
     *  When this item is in RTL mode, should its style name include an "RTL" suffix?
     *  @type {boolean}
     *  @default false
     */
    open var showRTL: Boolean = definedExternally
    /**
     *  When true, causes the "Pending" optional suffix to be added if the item's
     *   current value differs from the value that would be restored by a call to DynamicForm.resetValues.
     * 
     *   FormItem.shouldSaveValue must be true for this setting
     *   to have an effect.
     * 
     *   Styling of the value is updated only after the FormItem.change event is processed,
     *   so depending on the value of FormItem.changeOnKeypress, styling may
     *   be updated immediately on keystroke or only when the user leaves the field.
     * 
     *   Default styling is provided for the Enterprise, EnterpriseBlue, and Graphite skins only.
     *   showPending should not be enabled for an item when using a skin without
     *   default styling unless the default FormItem.pendingStatusChanged behavior is
     *   canceled and a custom pending visual state is implemented by the item.
     * 
     *   NOTE: Whether an item is shown as pending is not reflected to screen
     *   readers. Therefore, it is not advisable to design a UI where it is necessary for the user
     *   to know whether an item is shown as pending in order to work with the form.
     *  @type {boolean}
     *  @default null
     */
    open var showPending: Boolean = definedExternally
    /**
     *  For items that support SelectItem.multiple, this causes distinct CSS styling
     *   to be applied to values that the user has unselected.
     * 
     *   Only allowed when FormItem.showPending is true. Defaults
     *   to the form-level DynamicForm.showDeletions setting if set; otherwise, to the
     *   value of showPending.
     * 
     *   Only supported for MultiComboBoxItem and for SelectItem when
     *   SelectItem.multiple is set. The specific default behaviors are:
     * 
     * 
     *  - For MultiComboBoxItem, buttons corresponding to deleted values
     *     (also called "deselected buttons") will be disabled and have their Button.baseStyle
     *     set to MultiComboBoxItem.deselectedButtonStyle.
     * 
     *  - For a multiple SelectItem, FormItem.valueDeselectedCSSText is
     *     applied to any deleted value in the text box. In addition, "Deselected" is appended
     *     to the cells' ListGrid.baseStyle for cells in the pickList menu corresponding
     *     to deleted values.
     * 
     * 
     *   NOTE: When a value is shown as deleted, this is not reflected to screen
     *   readers, and screen readers are instructed to ignore the deleted value. Therefore, it is
     *   not advisable to design a UI where it is necessary for the user to know whether a value
     *   is shown as deleted in order to work with the form.
     *  @type {boolean}
     *  @default null
     */
    open var showDeletions: Boolean = definedExternally
    /**
     *  CSS style applied to the form item as a whole, including the text element, any icons, and
     *   any hint text for the item. Applied to the cell containing the form item.
     * 
     *   See formItemStyling for an overview of formItem styling, and
     *   the CompoundFormItem_skinning discussion for special
     *   skinning considerations.
     *  @type {FormItemBaseStyle}
     *  @default "formCell"
     */
    open var cellStyle: String = definedExternally
    /**
     *  CSS class for the "hint" string. For items that support
     *   TextItem.showHintInField, this only applies when showHintInField is false.
     *  @type {CSSStyleName}
     *  @default "formHint"
     */
    open var hintStyle: String = definedExternally
    /**
     *  By default, FormItem.canEdit fields use the same style name as editable
     *   fields for in-field hints, unless they are FormItem.isDisabled or
     *   configured to use a disabled ReadOnlyDisplayAppearance. This is described
     *   under TextItem.showHintInField
     * 
     *   If useDisabledHintStyleForReadOnly is set, the "HintDisabled" style will be
     *   used for read-only fields regardless of their ReadOnlyDisplayAppearance. This
     *   allows you to use a different in-field hint style for read-only fields without having to
     *   use a general disabled appearance for those fields
     *  @type {boolean}
     *  @default null
     */
    open var useDisabledHintStyleForReadOnly: Boolean = definedExternally
    /**
     *  Base CSS class name for a form item's title. Note that this is a FormItemBaseStyle so
     *   will pick up stateful suffixes on focus, disabled state change etc. by default.
     * 
     *   Note the appearance of the title is also affected by
     *   DynamicForm.titlePrefix/DynamicForm.titleSuffix and
     *   DynamicForm.requiredTitlePrefix/DynamicForm.requiredTitleSuffix.
     *  @type {FormItemBaseStyle}
     *  @default "formTitle"
     */
    open var titleStyle: String = definedExternally
    /**
     *  Base CSS stylename for a form item's title when generating print HTML for the item.
     *   If unset FormItem.titleStyle will be used instead.
     *  @type {FormItemBaseStyle}
     *  @default null
     */
    open var printTitleStyle: String = definedExternally
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
     *  @default null
     */
    open var textBoxStyle: String = definedExternally
    /**
     *  Base CSS class name for a form item's text box element when getting printable HTML for the
     *   form. If unset FormItem.textBoxStyle will be used instead. Note that focused styling
     *   will never be displayed while printing, though error and disabled styling will.
     *  @type {FormItemBaseStyle}
     *  @default null
     */
    open var printTextBoxStyle: String = definedExternally
    /**
     *  Base CSS class name for a form item's picker icon cell. If unset, inherits from
     *   this item's FormItem.controlStyle.
     *  @type {FormItemBaseStyle}
     *  @default null
     */
    open var pickerIconStyle: String = definedExternally
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
     *  @default null
     */
    open var controlStyle: String = definedExternally
    /**
     *  Custom CSS text to be applied to cells with pending edits that have not yet been
     *   submitted.
     *  @type {CSSText}
     *  @default "color:#0066CC;"
     */
    open var editPendingCSSText: String = definedExternally
    /**
     *  Custom CSS text to be applied to values that have been deleted, when
     *   FormItem.showDeletions is enabled.
     *  @type {CSSText}
     *  @default "color:#A8A8A8;text-decoration:line-through;"
     */
    open var valueDeselectedCSSText: String = definedExternally
    /**
     *  If set to true, when an item has errors and is focused, an "ErrorFocused" suffix
     *   will appear on the stylename.
     *  @type {boolean}
     *  @default false
     */
    open var showFocusedErrorState: Boolean = definedExternally
    /**
     *  CSS class for a form item's cell in the form layout
     *  @deprecated \* As of SmartClient version 5.5, deprecated in favor of FormItem.cellStyle
     *  @type {CSSStyleName}
     *  @default null
     */
    open var cellClassName: String = definedExternally
    /**
     *  CSS class for a form item's cell when a validation error is showing.
     *  @deprecated \* As of SmartClient version 5.5 deprecated in favor of FormItem.cellStyle
     *  @type {CSSStyleName}
     *  @default null
     */
    open var errorCellClassName: String = definedExternally
    /**
     *  CSS class for the form item's title.
     *  @deprecated \* As of SmartClient Version 5.5, use FormItem.titleStyle instead
     *  @type {CSSStyleName}
     *  @default null
     */
    open var titleClassName: String = definedExternally
    /**
     *  CSS class for a form item's title when a validation error is showing.
     *  @deprecated \* As of SmartClient Version 5.5, use FormItem.titleStyle instead
     *  @type {CSSStyleName}
     *  @default null
     */
    open var titleErrorClassName: String = definedExternally
    /**
     *  CSS class for the "hint" string.
     *  @deprecated \* As of SmartClient version 5.5, deprecated in favor of FormItem.hintStyle
     *  @type {CSSStyleName}
     *  @default null
     */
    open var hintClassName: String = definedExternally
    /**
     *  If specified, this is the number of milliseconds to wait between the user rolling over
     *   this form item, and triggering any hover action for it.
     *   If not specified this.form.itemHoverDelay will be used instead.
     *  @type {number}
     *  @default null
     */
    open var hoverDelay: Number = definedExternally
    /**
     *  Option to specify a width for any hover shown for this item.
     *  @type {any}
     *  @default null
     */
    open var hoverWidth: dynamic = definedExternally
    /**
     *  Option to specify a height for any hover shown for this item.
     *  @type {any}
     *  @default null
     */
    open var hoverHeight: dynamic = definedExternally
    /**
     *  Text alignment for text displayed in this item's hover canvas, if shown.
     *  @type {Alignment}
     *  @default null
     */
    open var hoverAlign: 
                         /**
                          *  Center within container.
                          *  Stick to left side of container.
                          *  Stick to right side of container.
                          */
                         String /* center |  left |  right */ = definedExternally
    /**
     *  Vertical text alignment for text displayed in this item's hover canvas, if shown.
     *  @type {VerticalAlignment}
     *  @default null
     */
    open var hoverVAlign: 
                          /**
                           *  At the top of the container
                           *  Center within container.
                           *  At the bottom of the container
                           */
                          String /* top |  center |  bottom */ = definedExternally
    /**
     *  Explicit CSS Style for any hover shown for this item.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var hoverStyle: String = definedExternally
    /**
     *  Opacity for any hover shown for this item
     *  @type {number}
     *  @default null
     */
    open var hoverOpacity: Number = definedExternally
    /**
     *  If true and the title is clipped, then a hover containing the full title of this item
     *   is enabled.
     * 
     *   The FormItem.titleHover method is called before the
     *   hover is displayed, allowing the hover to be canceled if desired. The HTML shown in the
     *   hover can be customized by overriding FormItem.titleHoverHTML.
     * 
     *  @type {boolean}
     *  @default true
     */
    open var showClippedTitleOnHover: Boolean = definedExternally
    /**
     *  If true and the value is clipped, then a hover containing the full value of this item
     *   is enabled.
     * 
     *   The FormItem.valueHover method is called before the
     *   hover is displayed, allowing the hover to be canceled if desired. The HTML shown in the
     *   hover can be customized by overriding FormItem.valueHoverHTML.
     * 
     *  @type {boolean}
     *  @default true
     */
    open var showClippedValueOnHover: Boolean = definedExternally
    /**
     *  Causes the original value to be shown to the end user when the user hovers over the
     *   FormItem as such (when the FormItem.itemHover event would fire).
     * 
     *   When FormItem.showOldValueInHover and the form's DynamicForm.showOldValueInHover
     *   are both unset, defaults to the value of FormItem.showPending.
     * 
     *   The message shown is controlled by FormItem.originalValueMessage.
     *  @type {boolean}
     *  @default null
     */
    open var showOldValueInHover: Boolean = definedExternally
    /**
     *  Message shown when FormItem.showOldValueInHover is enabled and
     *   the value has been modified.
     * 
     *   If unset, defaults to the form's DynamicForm.originalValueMessage. Otherwise,
     *   overrides the form-default originalValueMessage for this item.
     *  @type {HTMLString}
     *  @default null
     */
    open var originalValueMessage: String = definedExternally
    /**
     *  OperatorId to be used when DynamicForm.getValuesAsCriteria is called.
     * 
     *   item.operator can be used to create a form that offers search functions such
     *   as numeric range filtering, without the more advanced user interface of the
     *   FilterBuilder. For example, two SpinnerItems could be created with
     *   formItem.operator set to "greaterThan" and "lessThan" respectively to
     *   enable filtering by a numeric range.
     * 
     *   When item.operator is set for any FormItem in a form,
     *   form.getValuesAsCriteria() will return an AdvancedCriteria object
     *   instead of a normal Criteria object. Each FormItem will produce one
     *   Criterion affecting the DataSource field specified by FormItem.criteriaField.
     *   The criteria produced by the FormItems will be grouped under the logical operator
     *   provided by DynamicForm.operator.
     * 
     *   If operator is set for some fields but not others, the default operator is
     *   "equals" for fields with a valueMap or an optionDataSource, and for fields of type "enum"
     *   (or of a type that inherits from "enum"). The default operator for all other fields is
     *   controlled by DynamicForm.defaultSearchOperator.
     * 
     *   Note: formItem.operator is only supported for a form that has a
     *   DataBoundComponent.dataSource. In a form with no DataSource,
     *   setting formItem.operator will have no effect.
     *  @type {OperatorId}
     *  @default null
     */
    open var operator: 
                       /**
                        *  exactly equal to
                        *  not equal to
                        *  exactly equal to, if case is disregarded
                        *  not equal to, if case is disregarded
                        *  Greater than
                        *  Less than
                        *  Greater than or equal to
                        *  Less than or equal to
                        *  Contains as sub-string (match case)
                        *  Starts with (match case)
                        *  Ends with (match case)
                        *  Contains as sub-string (case insensitive)
                        *  Starts with (case insensitive)
                        *  Ends with (case insensitive)
                        *  Does not contain as sub-string (match case)
                        *  Does not start with (match case)
                        *  Does not end with (match case)
                        *  Does not contain as sub-string (case insensitive)
                        *  Does not start with (case insensitive)
                        *  Does not end with (case insensitive)
                        *  shortcut for "greaterThan" + "and" + "lessThan" (case insensitive)
                        *  shortcut for "greaterOrEqual" + "and" + "lessOrEqual" (case insensitive)
                        *  Basic GLOB matching using wildcards    (see DataSource.translatePatternOperators for more information on available patterns)
                        *  Basic GLOB matching using wildcards (case insensitive)    (see DataSource.translatePatternOperators for more information on available patterns)
                        *  GLOB matching using wildcards. Value is considered to meet the    criterion if it contains the pattern. See DataSource.translatePatternOperators
                        *      for more information on available patterns)
                        *  GLOB mathcing using wildcards. Value is considered to meet the    criterion if it starts with the pattern.See DataSource.translatePatternOperators
                        *      for more information on available patterns)
                        *  GLOB mathcing using wildcards. Value is considered to meet the    criterion if it starts with the pattern.See DataSource.translatePatternOperators
                        *      for more information on available patterns)
                        *  GLOB matching using wildcards. Value is considered to meet the    criterion if it contains the pattern. Matching is case insensitive. See
                        *      DataSource.translatePatternOperators for more information on available patterns)
                        *  GLOB matching using wildcards. Value is considered to meet the    criterion if it starts with the pattern. Matching is case insensitive.See
                        *      DataSource.translatePatternOperators for more information on available patterns)
                        *  GLOB matching using wildcards.Value is considered to meet the    criterion if it ends with the pattern. Matching is case insensitive. See
                        *      DataSource.translatePatternOperators for more information on available patterns)
                        *  Regular expression match
                        *  Regular expression match (case insensitive)
                        *  value is either null or the empty string. For numeric fields it behaves as isNull
                        *  value is neither null nor the empty string ("")
                        *  value is null
                        *  value is non-null. Note empty string ("") is non-null
                        *  value is in a set of values. Specify criterion.value as an Array
                        *  value is not in a set of values. Specify criterion.value as an Array
                        *  matches another field (match case, specify fieldName as criterion.value)
                        *  does not match another field (match case, specify fieldName as criterion.value)
                        *  matches another field (case insensitive, specify fieldName as criterion.value)
                        *  does not match another field (case insensitive, specify fieldName as criterion.value)
                        *  Greater than another field (specify fieldName as criterion.value)
                        *  Less than another field (specify fieldName as criterion.value)
                        *  Greater than or equal to another field    (specify fieldName as criterion.value)
                        *  Less than or equal to another field    (specify fieldName as criterion.value)
                        *  Contains as sub-string (match case) another field value    (specify fieldName as criterion.value)
                        *  Starts with (match case) another field value    (specify fieldName as criterion.value)
                        *  Ends with (match case) another field value    (specify fieldName as criterion.value)
                        *  Contains as sub-string (case insensitive) another field value    (specify fieldName as criterion.value)
                        *  Starts with (case insensitive) another field value    (specify fieldName as criterion.value)
                        *  Ends with (case insensitive) another field value    (specify fieldName as criterion.value)
                        *  Does not contain as sub-string (match case) another field value    (specify fieldName as criterion.value)
                        *  Does not start with (match case) another field value    (specify fieldName as criterion.value)
                        *  Does not end with (match case) another field value    (specify fieldName as criterion.value)
                        *  Does not contain as sub-string (case insensitive) another field value    (specify fieldName as criterion.value)
                        *  Does not start with (case insensitive) another field value    (specify fieldName as criterion.value)
                        *  Does not end with (case insensitive) another field value    (specify fieldName as criterion.value)
                        *  all subcriteria (criterion.criteria) are true
                        *  all subcriteria (criterion.criteria) are false
                        *  at least one subcriteria (criterion.criteria) is true
                        *  shortcut for "greaterThan" + "lessThan" + "and". Specify criterion.start     and criterion.end
                        *  shortcut for "greaterOrEqual" + "lessOrEqual" + "and". Specify     criterion.start and criterion.end
                        */
                       String /* equals |  notEqual |  iEquals |  iNotEqual |  greaterThan |  lessThan |  greaterOrEqual |  lessOrEqual |  contains |  startsWith |  endsWith |  iContains |  iStartsWith |  iEndsWith |  notContains |  notStartsWith |  notEndsWith |  iNotContains |  iNotStartsWith |  iNotEndsWith |  iBetween |  iBetweenInclusive |  matchesPattern |  iMatchesPattern |  containsPattern |  startsWithPattern |  endsWithPattern |  iContainsPattern |  iStartsWithPattern |  iEndsWithPattern |  regexp |  iregexp |  isBlank |  notBlank |  isNull |  notNull |  inSet |  notInSet |  equalsField |  notEqualField |  iEqualsField |  iNotEqualField |  greaterThanField |  lessThanField |  greaterOrEqualField |  lessOrEqualField |  containsField |  startsWithField |  endsWithField |  iContainsField |  iStartsWithField |  iEndsWithField |  notContainsField |  notStartsWithField |  notEndsWithField |  iNotContainsField |  iNotStartsWithField |  iNotEndsWithField |  and |  not |  or |  between |  betweenInclusive */ = definedExternally
    /**
     *  When using FormItem.operator, the name of the DataSource field for the
     *   Criterion this FormItem generates. If not specified, defaults to
     *   FormItem.name.
     * 
     *   Generally, because criteriaField defaults to item.name, you don't
     *   need to specify it. However, if more than one FormItem specifies criteria for the same
     *   DataSource field, they will need unique values for FormItem.name but should set
     *   FormItem.criteriaField to the name of DataSource field they both target.
     * 
     *   For example, if two DateItems are used to provide a min and max date for a single field called
     *   "joinDate", set FormItem.criteriaField to "joinDate" on both fields but give the fields
     *   distinct names (eg "minDate" and "maxDate") and use those names for any programmatic access,
     *   such as DynamicForm.setValue.
     *  @type {FieldName}
     *  @default null
     */
    open var criteriaField: String = definedExternally
    /**
     *  Formula to be used to calculate the numeric value of this FormItem. For a field of type
     *   "text" (or subtypes) FormItem.textFormula is used instead.
     * 
     *   Available fields for use in the formula are the current Canvas.ruleScope.
     *   The formula is re-evaluated every time the rule context changes.
     * 
     *   Values calculated by the formula will always replace the current value of a non-editable
     *   field. For an editable field, the current value will be replaced if the end user has not
     *   changed the value since the last time it was computed by the formula, or if the value of the
     *   field is invalid according to declared FormItem.validators.
     * 
     *   Note: A FormItem using a formula must have a FormItem.name defined. FormItem.shouldSaveValue can
     *   be set to false to prevent the formula field from storing the calculated value
     *   into the form's values.
     *  @type {UserFormula}
     *  @default null
     */
    open var formula: UserFormula = definedExternally
    /**
     *  Formula to be used to calculate the text value of this FormItem. For a numeric field
     *   FormItem.formula is used instead.
     * 
     *   Available fields for use in the formula are the current Canvas.ruleScope.
     *   The formula is re-evaluated every time the rule context changes.
     * 
     *   See FormItem.formula for details on available fields for the formula and when the
     *   formula is calculated.
     * 
     *   Note: A FormItem using a textFormula must have a FormItem.name defined. FormItem.shouldSaveValue can
     *   be set to false to prevent the formula field from storing the calculated value
     *   into the form's values.
     *  @type {UserSummary}
     *  @default null
     */
    open var textFormula: UserSummary = definedExternally
    /**
     *  Set this to true to allow the parent form to save it's data when 'Enter' is pressed on
     *   this formItem and DynamicForm.saveOnEnter is true on the parent form.
     *  @type {boolean}
     *  @default null
     */
    open var saveOnEnter: Boolean = definedExternally
    /**
     *  If true, indicates that this FormItem is capable of editing "opaque" values, ie,
     *   objects that are more complex than simple primitive types like numbers, strings and
     *   dates. Ordinarily, you use the SimpleType to
     *   convert these opaque values into "atomic" values that can be edited by the built-in
     *   editors like TextItem. However, sometimes you to create a custom editor
     *   that knows how to edit a particular opaque type in a domain-specific way - for example,
     *   a composite custom FormItem that allows the user to edit both a number and a currency
     *   code, both of which are needed to make a proper monetary amount (for that particular
     *   application).
     * 
     *   When this value is set, the FormItem will manage the opaque value directly, rather
     *   than it being filtered through calls to
     *   SimpleType.getAtomicValue and
     *   SimpleType.updateAtomicValue. Note, if you set this flag on
     *   a FormItem that does not have the ability to edit an opaque value (which is something
     *   that must be custom-coded) then you will get garbage in your editor, if not an outright
     *   crash.
     *  @type {boolean}
     *  @default null
     */
    open var canEditOpaqueValues: Boolean = definedExternally
    /**
     *  If true, multiple values may be selected.
     * 
     *   Only certain FormItems that support both singular and multiple values actually use
     *   this setting, such as SelectItem. Other FormItems such as
     *   MultiComboBoxItem are always effectively multiple:true, even if
     *   multiple:true is not set.
     *  @type {boolean}
     *  @default false
     */
    open var multiple: Boolean = definedExternally
    /**
     *  The destroyed attribute will be set to true if this item has been destroyed()
     *   Note that FormItem lifecycle is managed by the DynamicForm itself.
     *   FormItem instances are created and destroyed automatically when new fields are
     *   added to the form.
     *  @type {boolean}
     *  @default null
     */
    open var destroyed: Boolean = definedExternally
    /**
     *  When DynamicForm.showInlineErrors and FormItem.showErrorText are both true and
     *   FormItem.errorOrientation is "left" or "right", errorMessageWidth is the amount to reduce
     *   the width of the editor to accommodate the error message and icon.
     *  @type {Integer}
     *  @default "80"
     */
    open var errorMessageWidth: Number = definedExternally
    /**
     *  If FormItem.height is specified, should it be applied to the
     *   item's text box element?
     * 
     *   If unset, behavior is determined as described in FormItem.shouldApplyHeightToTextBox
     *  @type {boolean}
     *  @default null
     */
    open var applyHeightToTextBox: Boolean = definedExternally
    /**
     *  A formItem showing a FormItem.showPickerIcon will always
     *   write out a "control box" around the text box and picker icon. This is an HTML
     *   element styled using the specified FormItem.controlStyle.
     * 
     *   This attribute controls whether the control box should be written out even
     *   if the picker icon is not being shown. If unset, default behavior will write out
     *   a control table if FormItem.showPickerIcon is true and the icon is
     *   not suppressed via FormItemIcon.showIf. This means the control table
     *   can be written out with no visible picker if FormItem.showPickerIconOnFocus
     *   is true and the item does not have focus.
     * 
     *   This attribute is useful for developers who wish to rely on styling specified
     *   via the FormItem.controlStyle even while the picker icon is not visible.
     * 
     *   See the formItemStyling for details of the
     *   control table and other styling options.
     *  @type {boolean}
     *  @default null
     */
    open var alwaysShowControlBox: Boolean = definedExternally
    /**
     *  If specified, this overrides the DynamicForm.storeDisplayValues property
     *   for this field.
     *  @type {boolean}
     *  @default null
     */
    open var storeDisplayValues: Boolean = definedExternally
    /**
     *  When true, indicates that changes to this item will cause an automatic save on a
     *   DynamicForm.implicitSaveDelay, as well as when the entire form is
     *   submitted. If implicitSaveOnBlur is set to true on either this
     *   FormItem.implicitSaveOnBlur or it's
     *   DynamicForm.implicitSaveOnBlur, changes will also be automatically saved
     *   immediately on editorExit.
     *  @type {boolean}
     *  @default false
     */
    open var implicitSave: Boolean = definedExternally
    /**
     *  If set to true, this item's value will be saved immediately when its
     *   "editorExit" handler is fired. This attribute works separately from
     *   FormItem.implicitSave, which causes saves during editing, after a
     *   DynamicForm.implicitSaveDelay,
     *   and when the entire form is submitted.
     *  @type {boolean}
     *  @default false
     */
    open var implicitSaveOnBlur: Boolean = definedExternally
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
    open var shouldSaveValue: Boolean = definedExternally
    /**
     *  For items showing a text value, should the user be able to select the text in this item?
     *  @type {boolean}
     *  @default true
     */
    open var canSelectText: Boolean = definedExternally
    /**
     *  Does the current formItem support native cut and paste events?
     * 
     *   This attribute only applies to freeform text entry fields such as TextItem and
     *   TextAreaItem, and only if FormItem.changeOnKeypress is true.
     *   If true, developers can detect the user editing the value
     *   via cut or paste interactions (triggered from keyboard shortcuts or the native
     *   browser menu options) using the FormItem.isCutEvent and
     *   FormItem.isPasteEvent methods. This allows custom cut/paste handling
     *   to be added to the various change notification flow methods including
     *   FormItem.change, method:FormItem.handleChange and
     *   FormItem.transformInput.
     *  @type {boolean}
     *  @default false
     */
    open var supportsCutPasteEvents: Boolean = definedExternally
    /**
     *  For a form that produces filter criteria
     *   (see DynamicForm.getValuesAsCriteria), allows the user
     *   to type in simple expressions to cause filtering with that operator. For
     *   example, entering "&gt;5" means values greater than 5, and "&gt;0 and &lt;5" means values between
     *   0 and 5.
     * 
     *   The following table lists character sequences that can be entered as a prefix to a value,
     *   and the corresponding OperatorId that will be used.
     * 
     * 
     *   PrefixOperator
     *   &lt;lessThan
     *   &gt;greaterThan
     *   &lt;=lessThanOrEqual
     *   &gt;=greaterThanOrEqual
     *   someValue...someValuebetweenInclusive
     *   !notEqual
     *   ^startsWith
     *   |endsWith
     *   !^notStartsWith plus logical not
     *   !@notEndsWith plus logical not
     *   ~contains
     *   !~notContains
     *   $isBlank
     *   !$notBlank
     *   #isNull
     *   !#isNotNull
     *   ==exact match (for fields where 'contains' is the default)
     * 
     * 
     *   Two further special notations are allowed:
     * 
     * 
     *  - /regex/ means the value is taken as a regular expression and applied via the
     *   "regexp" operator
     * 
     *  - =.fieldName means the value should match the value of another field. Either the
     *   user-visible title of the field (field.title) or the field's name (field.name) may be used.
     * 
     * 
     *   In all cases, if an operator is disallowed for the field (via
     *   DataSourceField.validOperators at either the dataSource or field
     *   level), the operator character is ignored (treated as part of a literal value).
     * 
     *   By default, the case-insensitive version of the operator is used (eg, startsWith will
     *   actually use "iStartsWith"). To avoid this, explicitly set item.operator (the default
     *   operator) to any case sensitive operator (eg "equals" or "contains") and case sensitive
     *   operators will be used for user-entered expressions.
     * 
     *   Compound expressions (including "and" and "or") are allowed only for numeric or date/time
     *   types.
     * 
     *   Note that if the user does not type a prefix or use other special notation as described
     *   above, the operator specified via FormItem.operator is used, or if
     *   formItem.operator is unspecified, a default operator chosen as described
     *   under FormItem.operator.
     * 
     *   Also note that whatever you enter will be used literally, including any whitespace
     *   characters. For example if you input '== China ' then ' China ' will be the value.
     * 
     *   The allowExpression behavior can be enabled for every field in a form via
     *   DynamicForm.allowExpressions.
     * 
     *   Finally, note that, like FormItem.operator, enabling
     *   allowExpressions:true causes
     *   DynamicForm.getValuesAsCriteria) to return
     *   AdvancedCriteria.
     *  @type {boolean}
     *  @default null
     */
    open var allowExpressions: Boolean = definedExternally
    /**
     *  Array of valid filtering operators (eg "greaterThan") that are legal for this FormItem.
     * 
     *   Applies only to form/formItem when FormItem.allowExpressions is true, allowing the
     *   user to input expressions.
     *  @type {Array<Partial<OperatorId>>}
     *  @default null
     */
    open var validOperators: Array<dynamic> = definedExternally
    /**
     *  When AutoTest.getElement is used to parse locator strings generated by
     *   AutoTest.getLocator for this form item, should the item be identified?
     *   By default if the item has a name this will always be used, however for items with
     *   no name, the following options are available:
     * 
     * 
     *  - "title" use the title as an identifier within this form
     * 
     *  - "value" use the value of the item to identify it (often used
     *   for items with a static defaultValue such as HeaderItems
     * 
     *  - "index" use the index within the form's items array.
     * 
     * 
     *   If unset, and the item has no specified name, default behavior is to
     *   identify by title (if available), otherwise by index.
     *  @type {string}
     *  @default null
     */
    open var locateItemBy: String = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "FormItemEditProxy"
     */
    open var editProxyConstructor: String = definedExternally
    /**
     *  ARIA role of this formItem. Usually does not need to be manually set - see
     *   accessibility.
     *  @type {string}
     *  @default null
     */
    open var ariaRole: String = definedExternally
    /**
     *  ARIA state mappings for this formItem. Usually this does not need to be manually
     *   set - see accessibility.
     * 
     *   This attribute should be set to a mapping of aria state-names to values - for example
     *   to have the "aria-multiline" property be present with a value "true", you'd specify:
     * 
     *   { multiline : true }
     * 
     *  @type {object}
     *  @default null
     */
    open var ariaState: dynamic = definedExternally
    /**
     *   Setter for FormItem.readOnlyDisplay.
     * 
     *   Note that calling this method for a ButtonItem with ButtonItem.enableWhen
     *   set is an error, since FormItem.readOnlyDisplay is then considered to always be "disabled".
     * 
     *  @param {ReadOnlyDisplayAppearance} new readOnlyDisplay value.
     */
    open fun setReadOnlyDisplay(appearance: 
                                            /**
                                             *  Item value should appear within the form as a static block of text, similar to the default appearance of a StaticTextItem. This appearance may be
                                             *   modified via FormItem.readOnlyTextBoxStyle and FormItem.clipStaticValue.
                                             *  Item should appear unchanged, but user interaction to edit the item will be disallowed. Note that some interactions will be allowed, such as selecting text
                                             *   within a read-only TextItem for copy and paste. Exact implementation may vary by
                                             *   form item type.
                                             *  Item will appear disabled.
                                             */
                                            String /* static |  readOnly |  disabled */): Unit = definedExternally
    /**
     *   Notification method fires when the user clicks a FormItem.valueIcons for
     *   this item.
     * 
     *  @param {DynamicForm} the form containing this item
     *  @param {FormItem} the FormItem containing the valueIcon
     *  @param {any} the current value of the item.
     */
    open fun valueIconClick(form: DynamicForm, item: FormItem, value: dynamic): Boolean = definedExternally
    /**
     *   Returns true if this item's FormItem.containerWidget is a
     *   GridRenderer or GridRenderer subclass
     * 
     * 
     */
    open fun isInGrid(): Boolean = definedExternally
    /**
     *   If this item is being used to edit cells in a ListGrid (see FormItem.isInGrid),
     *   this method returns the grid in question.
     * 
     * 
     */
    open fun getListGrid(): ListGrid = definedExternally
    /**
     *   If this formItem is part of a ListGrid's
     *   ListGrid.canEdit, returns the number of the row currently being
     *   edited. If the formItem is not part of a ListGrid inline edit for any reason, this
     *   method returns null. Reasons for a formItem not being part of an inline edit include
     * 
     *  - The item is part of an ordinary DynamicForm, not an inline edit form
     * 
     *  - There is no row in the grid currently being edited
     * 
     *  - A row is being edited, but this formItem is not currently visible and is being
     *   excluded because of horizontal incremental rendering (where SmartClient avoids drawing
     *   grid columns that would not be visible without scrolling)
     * 
     * 
     * 
     */
    open fun getGridRowNum(): Number = definedExternally
    /**
     *   If this formItem is part of a ListGrid's
     *   ListGrid.canEdit, returns the number of the grid column this
     *   formItem is responsible for editing, but only if a row is currently being
     *   edited. If the formItem is not part of a ListGrid inline edit for any reason, this
     *   method returns null. Reasons for a formItem not being part of an inline edit include
     * 
     *  - The item is part of an ordinary DynamicForm, not an inline edit form
     * 
     *  - There is no row in the grid currently being edited
     * 
     *  - A row is being edited, but this formItem is not currently visible and is being
     *   excluded because of horizontal incremental rendering (where SmartClient avoids drawing
     *   grid columns that would not be visible without scrolling)
     * 
     * 
     * 
     */
    open fun getGridColNum(): Number = definedExternally
    /**
     *     Return the name for the this formItem.
     * 
     */
    open fun getFieldName(): String = definedExternally
    /**
     *   Return the dataPath for the this formItem.
     * 
     */
    open fun getDataPath(): String = definedExternally
    /**
     *   Return the fully-qualified dataPath for the this formItem (ie, the dataPath expressed
     *   in absolute terms from the root of the hierarchy, rather than relative to the item's
     *   parent form). Note that the item's name is substituted into the full dataPath if the
     *   item does not specify an explicit dataPath. For example, if we have a field called
     *   name that specifies no dataPath, on a form that specifies a dataPath of
     *   /order/items, this method will return /order/items/name
     * 
     */
    open fun getFullDataPath(): String = definedExternally
    /**
     *   Returns true if 'Enter' key presses in this formItem should allow a saveOnEnter: true
     *   parent form to save it's data. The default implementation returns the value of
     *   FormItem.saveOnEnter or false if that property is unset.
     * 
     */
    open fun shouldSaveOnEnter(): Boolean = definedExternally
    /**
     *   Returns the title HTML for this item.
     * 
     */
    open fun getTitle(): String = definedExternally
    /**
     *   Return true if the form item is currently visible. Note that like the similar
     *   Canvas.isVisible, it indicates visibility settings only and so
     *   will return true for an item that is not drawn.
     * 
     * 
     */
    open fun isVisible(): Boolean = definedExternally
    /**
     *   Return the coordinates of this object as a 4 element array.
     * 
     */
    open fun getRect(): Array<dynamic> = definedExternally
    /**
     *   Return the page-level coordinates of this object as a 4 element array.
     * 
     */
    open fun getPageRect(): Array<dynamic> = definedExternally
    /**
     *   If FormItem.height is specified, should it be applied to the
     *   item's text box element? If this method returns false, the
     *   text box will not have an explicit height applied, though the containing cell
     *   will be sized to accomodiate any specified height.
     * 
     *   This is used in cases where the text box does not have distinctive styling
     *   (for example in standard StaticTextItems). As the textBox has no explicit
     *   height, it fits the content. Since the text box is not visually distinct to
     *   the user, this makes FormItem.vAlign behave as expected with the
     *   text value of the item being vertically aligned within the cell.
     * 
     *   Default implementation will return FormItem.applyHeightToTextBox if explicitly set
     *   otherwise false if FormItem.readOnlyDisplay is set to
     *   "static" and the item is FormItem.getCanEdit, otherwise
     *   true.
     * 
     */
    open fun shouldApplyHeightToTextBox(): Boolean = definedExternally
    /**
     *   Returns the specified FormItem.height of this formItem in pixels.
     *   For heights specified as a percentage value or "\*", the
     *   pixel height may not be available prior to the item being drawn. In cases where
     *   the height has not yet been resolved to a pixel value, this method will return
     *   -1.
     * 
     */
    open fun getPixelHeight(): Number = definedExternally
    /**
     *   Output the drawn height for this item in pixels.
     *   Note: this is only reliable after this item has been written out into the DOM.
     * 
     */
    open fun getVisibleHeight(): Number = definedExternally
    /**
     *   Takes an icon definition object, and returns the height for that icon in px.
     * 
     *  @param {object} icon definition object for this item.
     */
    open fun getIconHeight(icon: dynamic): Number = definedExternally
    /**
     *   Output the width for this element. Note this returns the specified width for the
     *   element, which may be "\*" or a percentage value. Use 'getVisibleWidth()' to get the
     *   drawn width in pixels.
     * 
     */
    open fun getWidth(): dynamic = definedExternally
    /**
     *   Returns the specified FormItem.width of this formItem in pixels.
     *   For widths specified as a percentage value or "\*", the
     *   pixel width may not be available prior to the item being drawn. In cases where
     *   the width has not yet been resolved to a pixel value, this method will return
     *   -1.
     * 
     */
    open fun getPixelWidth(): Number = definedExternally
    /**
     *   Output the drawn width for this item in pixels. This method is only reliable after
     *   the item has been drawn into the page.
     * 
     */
    open fun getVisibleWidth(): Number = definedExternally
    /**
     *   Returns the visible width of this item's title in px. If that is not applicable (for
     *   example, the form item has no title) or cannot be determined (for example, the form
     *   is not drawn), returns 0.
     * 
     *  @param {boolean} If true, returns the visible width of the title text                 only; if false (the default) returns the width of the                  title cell
     */
    open fun getVisibleTitleWidth(labelOnly: Boolean): Number = definedExternally
    /**
     *   Takes an icon definition object, and returns the width for that icon in px.
     * 
     *  @param {object} icon definition object for this item.
     */
    open fun getIconWidth(icon: dynamic): Number = definedExternally
    /**
     *   For a form with DynamicForm.itemLayout:"absolute" only, set the left
     *   coordinate of this form item.
     * 
     *   Causes the form to redraw.
     * 
     */
    open fun setLeft(): Unit = definedExternally
    /**
     *   For a form with DynamicForm.itemLayout:"absolute" only, set the top
     *   coordinate of this form item.
     * 
     *   Causes the form to redraw.
     * 
     */
    open fun setTop(): Unit = definedExternally
    /**
     *   Update the visual state of a FormItem to reflect any changes in state or any changes in
     *   style settings (e.g. FormItem.textBoxStyle).
     * 
     *   Calls to updateState() normally occur automatically as a consequence of
     *   focus changes, items becoming disabled, etc. This method is advanced and intended only
     *   for use in workarounds.
     * 
     * 
     */
    open fun updateState(): Unit = definedExternally
    /**
     *   Except when printing and FormItem.getPrintValueIconStyle
     *   is implemented, this method is called to obtain the base CSS style to use on the
     *   FormItem.getValueIcon for the item's current value.
     * 
     *   If not null, the base style is suffixed with the state of the value icon
     *   ("", "Over", "Down", "Disabled").
     * 
     * 
     *  @param {any} value of this item.
     */
    open fun getValueIconStyle(value: dynamic): String = definedExternally
    /**
     *   If implemented, this method is called when printing to obtain
     *   the base CSS style to use on the FormItem.getPrintValueIcon
     *   for the item's current value.
     * 
     *   If not null, the base style is suffixed with the state of the value icon
     *   ("", "Over", "Down", "Disabled").
     * 
     *   NOTE: It is not recommended to apply CSS background-image styling to the
     *   value icon style. This is because browsers typically default to not printing background
     *   images.
     * 
     * 
     *  @param {any} value of this item.
     */
    open fun getPrintValueIconStyle(value: dynamic): String = definedExternally
    /**
     *   Optional method to retrieve a custom state suffix to append to the style name that is
     *   applied to some element of a formItem - see FormItemBaseStyle for more
     *   information on how state-based FormItem style names are derived.
     * 
     *   If this method exists on a formItem, the framework will call it, passing in the state
     *   suffix it has derived. Your getCustomState() implementation can make use
     *   of this derived state or ignore it. For example, if you wanted two different types of
     *   focus styling depending on some factor unrelated to focus, you would probably make use
     *   of the incoming "Focused" state and return something like "Focused1" or "Focused2". On
     *   the other hand, if you want your custom state to just override whatever the system
     *   derived, you would ignore the incoming state. Finally, if you do not wish to provide a
     *   custom style for this formItem element at this time - for example, you are only
     *   interested in providing a custom "textBox" style and this call is for a "cell" element
     *   type - your getCustomStyle() method should just return the state it was
     *   passed.
     * 
     *   This method is an advanced API, and you should only provide an implementation of it if
     *   you have specialized styling requirements. If you do implement it, note that it will
     *   be called very frequently, from rendering code: if your custom logic does significant
     *   processing, it could introduce a system-wide performance problem.
     * 
     * 
     *  @param {FormItemElementType} The element type to return a custom state for
     *  @param {string} The state suffix the system derived
     */
    open fun getCustomState(elementType: 
                                         /**
                                          *  The form item as a whole, including the text element, any icons,           and any hint text for the item. This is the cell containing the
                                          *             form item
                                          *  The "control" cell containing the text box and picker
                                          *  The cell containing the item's picker icon, if it has one
                                          *  The item's native text box, if it has one
                                          *  The cell containing the title
                                          */
                                         String /* cell |  control |  pickerIcon |  textBox |  title */, derivedState: String): String = definedExternally
    /**
     *   Setter for FormItem.cellStyle.
     * 
     * 
     *  @param {FormItemBaseStyle} the new cellStyle value.
     */
    open fun setCellStyle(newCellStyle: String): Unit = definedExternally
    /**
     *   Return the validation errors in the form associated with this item, if any.
     *   Errors will be returned as either a string (single error message) or an array of strings
     *   (multiple error messages).
     * 
     */
    open fun getErrors(): dynamic = definedExternally
    /**
     *   Output the HTML for an error message in a form element. Default behavior respects
     *   FormItem.showErrorIcon and FormItem.showErrorText as described in the
     *   documentation for those attributes.
     * 
     *  @param {string | Array<Partial<string>>} error message string or array of error messages
     */
    open fun getErrorHTML(error: dynamic): String = definedExternally
    /**
     *   Returns true if this item has been written out into the DOM.
     * 
     * 
     */
    open fun isDrawn(): Boolean = definedExternally
    /**
     *   Returns the desired tab-position of some icon with respect to other focusable
     *   sub-elements for this formItem.
     * 
     *   Default implementation returns the index of the icon in the icons array,
     *   (plus one if a pickerIcon is showing) meaning users can tab through icons in order.
     *   Has no effect for non-focusable icons.
     * 
     */
    open fun getIconTabPosition(): Number = definedExternally
    /**
     *   Returns the desired tab-position of the picker icon with respect to other focusable
     *   sub-elements for this formItem.
     * 
     *   Default implementation returns zero, making the picker the first focusable element
     *   after the items text box.
     * 
     */
    open fun getPickerIconTabPosition(): Number = definedExternally
    /**
     *   Adds a FormItemIcon to this item. If the optional index parameter is not passed,
     *   the icon is added to the end of the existing FormItem.icons.
     * 
     *   If the passed icon already exists in the FormItem.icons, by
     *   FormItemIcon.name, the original icon is moved to the new index and no new
     *   icon is added.
     * 
     *  @param {FormItemIcon} the icon to add
     *  @param {Integer=} the index to add the icon at - if omitted, add the icon to the end      of the current icon list
     */
    open fun addIcon(icon: FormItemIcon, index: Number?): FormItemIcon = definedExternally
    /**
     *   Given an icon's FormItemIcon.name, remove it from this item.
     * 
     *  @param {Identifier} the name of the icon to remove
     */
    open fun removeIcon(icon: String): Boolean = definedExternally
    /**
     *   Set an icon as enabled or disabled at runtime.
     * 
     *  @param {Identifier} FormItemIcon.name of the icon to be disabled/enabled.
     *  @param {boolean} true if icon should be disabled
     */
    open fun setIconDisabled(icon: String, disabled: Boolean): Unit = definedExternally
    /**
     *   This method will enable some icon in this item's FormItem.icons array, if it is
     *   currently disabled.
     * 
     * 
     *  @param {Identifier} FormItemIcon.name of the icon to be enabled.
     */
    open fun enableIcon(icon: String): Unit = definedExternally
    /**
     *   This method will disable some icon in this item's FormItem.icons array, if it is
     *   currently enabled.
     * 
     * 
     *  @param {Identifier} FormItemIcon.name of the icon to be disabled.
     */
    open fun disableIcon(icon: String): Unit = definedExternally
    /**
     *   This method will show some icon in this item's FormItem.icons array, if it is not
     *   already visible. Note that once this method has been called, any previously specified
     *   FormItemIcon.showIf will be discarded.
     * 
     *   Note that if the form item's showIcons property is set to false, no icons will be displayed
     *   for the item. In this case this method will not cause the icon to be displayed.
     * 
     * 
     *  @param {Identifier} FormItemIcon.name of the icon to be shown.
     */
    open fun showIcon(icon: String): Unit = definedExternally
    /**
     *   This method will hide some icon in this item's FormItem.icons array, if it is
     *   currently visible. Note that once this method has been called, any previously specified
     *   FormItemIcon.showIf will be discarded.
     * 
     * 
     *  @param {Identifier} FormItemIcon.name of the icon to be hidden.
     */
    open fun hideIcon(icon: String): Unit = definedExternally
    /**
     *   Sets FormItemIcon.showOnFocus for the supplied icon, and causes that icon's
     *   visibility to be updated and the item redrawn as appropriate.
     * 
     * 
     *  @param {Identifier} FormItemIcon.name of the icon to update
     *  @param {boolean} new value of FormItemIcon.showOnFocus
     */
    open fun setIconShowOnFocus(icon: String, showOnFocus: Boolean): Unit = definedExternally
    /**
     *   Sets FormItem.showIconsOnFocus and causes the visibility of all FormItem.icons to be updated
     *   and the item redrawn as appropriate.
     * 
     * 
     *  @param {boolean} new value of FormItem.showIconsOnFocus
     */
    open fun setShowIconsOnFocus(showIconsOnFocus: Boolean): Unit = definedExternally
    /**
     *   Sets FormItem.showPickerIconOnFocus and causes the visibility of the picker icon to be
     *   updated and the item redrawn as appropriate.
     * 
     * 
     *  @param {boolean} new value of FormItem.showPickerIconOnFocus
     */
    open fun setShowPickerIconOnFocus(showPickerIconOnFocus: Boolean): Unit = definedExternally
    /**
     *   Given a FormItemIcon.name, returns the FormItemIcon object.
     * 
     *  @param {Identifier} specified FormItemIcon.name
     */
    open fun getIcon(name: String): FormItemIcon = definedExternally
    /**
     *   Method to show a picker for this item. By default this method is called if the user
     *   clicks on a FormItem.showPickerIcon. May also be called programmatically.
     * 
     *   Default implementation lazily creates and shows the FormItem.picker.
     * 
     *   Developers wishing to show a custom picker widget can either implement a
     *   FormItem.pickerIconClick handler with an entirely custom implementation (and bypass
     *   the call to showPicker() altogether),
     *   override this method,
     *   or use the AutoChild to customize the automatically generated
     *   FormItem.picker.
     * 
     * 
     */
    open fun showPicker(): Unit = definedExternally
    /**
     *   Redraw this form item.
     * 
     *   Depending on the item and the FormItem.containerWidget it's embedded in, this may redraw
     *   this particular item or require a redraw of all items in the form.
     * 
     *   Do not call this method unless the documentation directs you to do so. Calling
     *   redraw() unnecessarily has significant performance consequences.
     * 
     * 
     *  @param {string=} optional reason for performing the redraw, which may appear in             diagnostic logs if enabled
     */
    open fun redraw(reason: String?): Unit = definedExternally
    /**
     *   Show this form item.
     * 
     *   This will cause the form to redraw. If this item had an item.showIf expression, it will
     *   be destroyed.
     * 
     */
    open fun show(): Unit = definedExternally
    /**
     *   Hide this form item.
     * 
     *   This will cause the form to redraw. If this item had an item.showIf expression, it will
     *   be destroyed.
     * 
     */
    open fun hide(): Unit = definedExternally
    /**
     *   Returns this item's value with any valueMap applied to it - the value as currently
     *   displayed to the user.
     * 
     *  @param {any=} optional stored value to be mapped to a display value. Default is to        use the form's current value
     */
    open fun getDisplayValue(value: dynamic?): dynamic = definedExternally
    /**
     *   Given a value for this FormItem, return the value to be displayed.
     * 
     *   This method is called by the framework to derive a display value for a given data value
     *   in a FormItem. Your own code can call this method if you need to programmatically obtain
     *   the display value (for example, to display in a hover prompt or error message). However,
     *   it is not intended as an override point, and you should not treat
     *   it as one.
     * 
     *   There are several supported ways to apply custom formatting to your form values:
     * 
     *  - If you want to apply a consistent custom format to every instance of a given
     *   SimpleType, specify a SimpleType.format on the SimpleType.
     *   This is the most general approach. Note, this is a static formatter: it will only
     *   affect the format of values the user can interact with if TextItem.formatOnBlur
     *   is set
     * 
     *  - If you want to apply a consistent custom format to a
     *   DataSourceField, the best approach is
     *   DataSourceField.format. This overrides SimpleType-level formatting and,
     *   again, is static formatting
     * 
     *  - For a FormItem that is not DataSource-described, or for special formats that
     *   should only be used on a particular form, FormItem.format can also be
     *   declared for individual FormItems. This overrides DataSource-level formatting
     * 
     *  - For temporal values, you can declare FormItem.dateFormatter
     *   and FormItem.timeFormatter at both FormItem and
     *   DynamicForm levels. Generally, however, we recommend the generic
     *   declarative FormItem.format as the simpler approach
     * 
     *  - If you want to apply a specialized format that cannot be expressed declaratively,
     *   use FormItem.formatValue
     * 
     *   for static-valued items like StaticTextItem or SelectItem,
     *   and FormItem.formatEditorValue
     * 
     *   for other types of FormItem
     * 
     *   Deriving the display value
     *   The process of deriving a display value from a data value involves the following steps:
     * 
     *  - If the item declares a FormItem.valueMap, the display value is
     *   derived by looking up the value in the valueMap
     * 
     *  - If the item does not have a valueMap - or the value was not found in the item's
     *   valueMap - and the item declares a FormItem.displayField
     *   and an FormItem.optionDataSource, the display value is derived
     *   by looking up the "displayField" corresponding to the value in the optionDataSource's
     *   local cache
     * 
     *  - Formatting is now applied to the derived display value. Note, it is perfectly normal
     *   at this point for no display value has to be derived - this will be the case for any
     *   field with no valueMap and no optionDataSource. In this case,
     *   the passed-in value is treated as the display value for all further purposes.
     * 
     *  - If the FormItem involves static display value(s), like StaticTextItem
     *       or SelectItem
     * 
     *  - If the FormItem
     *       has a FormItem.formatValue method, it is called
     * 
     * 
     *  - Otherwise, if the formItem declares a FormItem.format, the formst
     *         is applied in line with the rules of FormatString
     * 
     *  - Otherwise, if the FormItem is of a SimpleType that declares a
     *         SimpleType.format, the format is applied
     * 
     * 
     * 
     *  - Otherwise, if the FormItem
     *       has a FormItem.formatEditorValue method,
     *             it is called
     * 
     * 
     * 
     *  - Otherwise, if the FormItem is of a SimpleType that
     *       declares an SimpleType.editFormatter,
     * 
     *       the edit formatter is called
     * 
     *  - Otherwise, if the value is a Date:
     * 
     *  - If the formItem declares a FormItem.timeFormatter and no
     *         FormItem.dateFormatter, the timeFormatter is called
     * 
     *  - Otherwise, if the formItem is of a SimpleType that
     *         SimpleType.inheritsFrom "time", the value is formatted
     *         using the
     *         Time.shortDisplayFormat
     * 
     * 
     *  - Otherwise, the date or datetime is formatted using the rules described
     *         for FormItem.dateFormatter.
     * 
     * 
     * 
     *  - Otherwise, if the FormItem involves static display value(s) and is of a
     *       SimpleType that declares a
     *       SimpleType.normalDisplayFormatter, this is used
     * 
     *  - Otherwise, if the value is not null and is of a "simple" type (ie, it is not an
     *       object or an array), a display value is derived by calling the Javascript
     *       toLocaleString() method, if the value has one, or the
     *       toString() method if it does not
     * 
     *  - Otherwise, if the value is null or a zero-length string, the display value is
     *       set to the formItem's FormItem.emptyDisplayValue
     * 
     *  - Otherwise, the "display value" is the simple, unformatted data value that was
     *       passed in
     * 
     * 
     * 
     *   Treatment of arrays
     *   Ordinarily, arrays are treated like any other value. This means you can, for example,
     *   create a FormItem.formatEditorValue implementation
     * 
     *   that is capable of formatting an array-valued field in some way that makes sense for the
     *   particular application domain.
     * 
     *   However, for items that are marked to handle DataSourceField.multiple
     *   values, array values are treated differently. In this case, the display value is built
     *   up by calling mapValueToDisplay() recursively for each array entry, and
     *   concatenating these partial display values together using the
     *   FormItem.multipleValueSeparator.
     * 
     * 
     *  @param {any} value to be mapped to a display value
     */
    open fun mapValueToDisplay(value: dynamic): String = definedExternally
    /**
     *   Allows customization of how the FormItem's stored value is formatted for display.
     *   If you are considering using this method, you should first consider using
     *   FormItem.format, which provides for simple and flexible declarative
     *   formatting of dates, times and numbers, without the need to write formatting code.
     * 
     *   By default, this formatter will only be applied to static displays such
     *   as StaticTextItem or SelectItem, and does not apply to values
     *   displayed in a freely editable text entry field
     *   (such as a TextItem or TextAreaItem).
     * 
     *   To define formatting logic for editable text, developers may:
     * 
     * 
     *  - set TextItem.formatOnBlur to true, which causes the static formatter
     *   to be applied while the item does not have focus, and then be cleared when the user
     *   moves focus to the text field
     * 
     *  - use FormItem.formatEditorValue and supply a
     *   corresponding FormItem.parseEditorValue that can convert a formatted and subsequently
     *   user-edited value back to a stored value.
     * 
     * 
     *  @param {any} Underlying data value to format. May be null.
     *  @param {ListGridRecord} The record currently being edited by this form.   Essentially the form's current values object.
     *  @param {DynamicForm} pointer to the DynamicForm
     *  @param {FormItem} pointer to the FormItem
     */
    open fun formatValue(value: dynamic, record: ListGridRecord, form: DynamicForm, item: FormItem): String = definedExternally
    /**
     *   Allows customization of how the FormItem's stored value is formatted for display
     *   in an editable text entry area, such as a TextItem TextAreaItem. For
     *   display values which will not be directly editable by the user, use
     *   FormItem.formatValue instead.
     * 
     *   When customizing how values are displayed during editing, it is almost always necessary
     *   to provide a FormItem.parseEditorValue as well, in order to convert a formatted
     *   and subsequently user-edited value back to a stored value.
     * 
     * 
     *  @param {any} Underlying data value to format. May be null.
     *  @param {ListGridRecord} The record currently being edited by this form.   Essentially the form's current values object.
     *  @param {DynamicForm} pointer to the DynamicForm
     *  @param {FormItem} pointer to the FormItem
     */
    open fun formatEditorValue(value: dynamic, record: ListGridRecord, form: DynamicForm, item: FormItem): String = definedExternally
    /**
     *   Allows customization of how a used-entered text value is converted to the FormItem's
     *   logical stored value (the value available from FormItem.getValue).
     * 
     *   This method only applies to form items which show an editable text entry area, such at
     *   the TextItem or TextAreaItem.
     * 
     *   See also FormItem.formatEditorValue
     * 
     * 
     *  @param {string} value as entered by the user
     *  @param {DynamicForm} pointer to the dynamicForm containing this item
     *  @param {FormItem} pointer to this item
     */
    open fun parseEditorValue(value: String, form: DynamicForm, item: FormItem): dynamic = definedExternally
    /**
     *   Given a display value for this FormItem, return the underlying data value. This is
     *   done by reverse value-mapping, and/or parsing.
     * 
     *   This method is called by the framework to derive an underlying data value for a given
     *   display value (ie, the value the user sees and interacts with) in a FormItem. Your own
     *   code can call this method if you need to programmatically obtain the underlying data
     *   value for a given display value. However,
     *   it is not intended as an override point, and you should not treat
     *   it as one.
     * 
     *   If you have a field that requires the stored value to be different from the displayed
     *   value, and the requirement cannot be satisfied with a FormItem.valueMap
     *   for some reason, you can add custom parsing logic by
     *   implementing FormItem.parseEditorValue
     * 
     * 
     *   This method is also not intended as a place where you can validate, sanitize,
     *   transform or canonicalize user input
     * 
     *  - To ensure you get well-formed input values, use TextItem.mask or
     *   the FormItem.change
     * 
     * 
     * 
     *  - To transform or canonicalize input values, use a ValidatorType
     *   with "transformTo". See the link to "mask validator" for more details and an example of this
     * 
     *  - To transform or canonicalize input character-by-character as the user types, use
     *   FormItem.transformInput
     * 
     * 
     *   Deriving the data value
     *   The process of deriving an underlying data display value from a display value involves
     *   the following steps:
     * 
     *  - If the formItem
     *     declares a FormItem.parseEditorValue
     *     method,
     * 
     *     it is called
     * 
     *  - Otherwise, if the formItem is of a SimpleType that
     *     declares a SimpleType.parseInput method, it
     * 
     *     is called
     * 
     *  - If the formItem is of a SimpleType that
     *     SimpleType.inheritsFrom "date", "time" or "datetime", it will
     *     be parsed as a date, time or datetime. Note, this parsing step is applied on top of
     *     custom SimpleType- and FormItem-level parsing
     * 
     *  - If the formItem declares a FormItem.valueMap, a value is derived by
     *   looking up the display value (including the effects of any parsing we may have done so far)
     *   in the valueMap
     * 
     *   Note: Unlike the corollary method FormItem.mapValueToDisplay,
     *   there is no special built-in handling of DataSourceField.multiple:true
     *   fields. If you want an array to be parsed out of some user input, you must write the
     *   parser method to do so.
     * 
     *  @param {string} display value
     */
    open fun mapDisplayToValue(value: String): dynamic = definedExternally
    /**
     *   Set the valueMap for this item.
     * 
     *  @param {Array<any> | object} new valueMap
     */
    open fun setValueMap(valueMap: dynamic): Unit = definedExternally
    /**
     *   Method to set the FormItem.optionDataSource at runtime
     * 
     *  @param {DataSource} new optionDatasource
     */
    open fun setOptionDataSource(dataSource: DataSource): Unit = definedExternally
    /**
     *   Sets the FormItem.valueIcons for this item.
     * 
     *  @param {object} mapping of logical values for this item to icon src SCImgURLs or the special value "blank".
     */
    open fun setValueIcons(map: dynamic): Unit = definedExternally
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
    open fun getValueFieldName(): String = definedExternally
    /**
     *   Returns the displayField for this item.
     * 
     *   Behavior varies based on the configuration of this item, as follows:
     * 
     *  - If this item has an FormItem.optionDataSource and an explicit
     *   FormItem.foreignDisplayField is specified, this will be returned.
     * 
     *  - Otherwise if an explicit FormItem.displayField is specified it will be returned
     *   by default. If the displayField was specified on the underlying
     *   dataSource field, and no matching field is present in the FormItem.optionDataSource for
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
    open fun getDisplayFieldName(): String = definedExternally
    /**
     *   Returns the FormItem.optionDataSource for this item.
     * 
     *   Always uses item.optionDataSource if specified. Otherwise, if
     *   DataSourceField.foreignKey was specified, uses the target DataSource. Otherwise,
     *   uses the DataSource of this item's form (if one is configured).
     * 
     * 
     */
    open fun getOptionDataSource(): DataSource = definedExternally
    /**
     *   Set the value of the form item to the value passed in
     * 
     *   NOTE: for valueMap'd items, newValue should be data value not displayed value
     * 
     *  @param {any} value to set the element to
     */
    open fun setValue(newValue: dynamic): Unit = definedExternally
    /**
     *   If this field has a specified FormItem.optionDataSource, should we perform a fetch against
     *   that dataSource to find the record that matches this field's value?
     * 
     *   If the value is non-null, this method is called when the item is first rendered
     *   or whenever the value is changed via a call to FormItem.setValue. If it returns
     *   true, a fetch will be dispatched against the optionDataSource to get the record
     *   matching the value
     * 
     *   When the fetch completes, if a record was found that matches the
     *   data value (and the form item value has not subsequently changed again),
     *   the item will be re-rendered to reflect any changes to the display value,
     *   and the record matching the value
     *   will be available via FormItem.getSelectedRecord.
     * 
     *   Default behavior will return false if FormItem.fetchMissingValues is
     *   set to false. Otherwise it will return true if FormItem.alwaysFetchMissingValues is
     *   set to true, or if a FormItem.displayField is specified for this item and the item
     *   value is not already present in the item's valueMap.
     * 
     * 
     *  @param {any} The new data value of the item.
     */
    open fun shouldFetchMissingValue(newValue: dynamic): Boolean = definedExternally
    /**
     *   If this item has a specified FormItem.displayField, the value displayed to the
     *   user for this item may be derived from another field.
     * 
     *   The display field can be either another field value in the same record or a field that
     *   must be retrieved from a related FormItem.optionDataSource if
     *   FormItem.fetchMissingValues is true. In this latter case, we perform a fetch against
     *   the option dataSource when the item value changes in order to determine the
     *   display value to show (and we make the associated record available via
     *   FormItem.getSelectedRecord).
     * 
     *   We cache this data on the form item, so if the item value changes to a new value, then reverts
     *   to a previously-seen value, the display value and selected record are already available
     *   without the need for an additional fetch. The cached values will also be kept in synch with
     *   the dataSource data assuming it is modified via standard add, update or delete operations.
     * 
     *   This method explicitly invalidates this cache of optionDataSource data, and if the item value
     *   is non null and fetchMissingValues is still true, re-fetches the data.
     * 
     * 
     */
    open fun invalidateDisplayValueCache(): Unit = definedExternally
    /**
     *   Get the record returned from the FormItem.optionDataSource when FormItem.fetchMissingValues
     *   is true, and the missing value is fetched.
     * 
     *   FormItem.fetchMissingValues kicks off the fetch when the form item is initialized
     *   with a non null value or when setValue() is called on the item. Note that this method
     *   will return null before the fetch completes, or if no record is found in the
     *   optionDataSource matching the underlying value.
     * 
     */
    open fun getSelectedRecord(): ListGridRecord = definedExternally
    /**
     *   Clear the value for this form item.
     * 
     *   Note that if a default value is specified, value will be set to that default value,
     *   otherwise value will be cleared, (and removed from the containing form's values).
     * 
     */
    open fun clearValue(): Unit = definedExternally
    /**
     *   Sets the FormItem.prompt for this item.
     * 
     *  @param {HTMLString} new prompt for the item.
     */
    open fun setPrompt(newPrompt: String): Unit = definedExternally
    /**
     *   Sets the FormItem.hint for this item.
     * 
     *  @param {HTMLString} new hint for the item.
     */
    open fun setHint(newHint: String): Unit = definedExternally
    /**
     *   Set the hintStyle for this item
     * 
     *  @param {CSSStyleName} new style for hint text
     */
    open fun setHintStyle(hintStyle: String): Unit = definedExternally
    /**
     *   Store (and optionally show) a value for this form item.
     * 
     *   This method will fire standard FormItem.change and
     *   DynamicForm.itemChanged handlers, and store the value passed in such that
     *   subsequent calls to FormItem.getValue or DynamicForm.getValue will
     *   return the new value for this item.
     * 
     *   This method is intended to provide a way for custom formItems - most commonly
     *   CanvasItem - to provide a new interface to the user, allowing them
     *   to manipulate the item's value, for example in an embedded CanvasItem.canvas,
     *   or a pop-up dialog launched from an FormItemIcon, etc. Developers
     *   should call this method when the user interacts with this custom
     *   interface in order to store the changed value.
     * 
     *   CanvasItem.shouldSaveValue for CanvasItems is
     *   false by default. Custom CanvasItems will need to override shouldSaveValue
     *   to true if the values stored via this API should be included in the form's
     *   DynamicForm.getValues and saved with the form when
     *   DynamicForm.saveData is called.
     * 
     *   If you cannot easily detect interactions that should change the value as the
     *   user performs them, a workaround is to call
     *   storeValue right before the form saves.
     * 
     *   Note that this method is not designed for customizing a value which is already being
     *   saved by a standard user interaction. For example you should not call this method
     *   from a FormItem.change. Other APIs such as
     *   FormItem.transformInput exist for this.
     * 
     * 
     *  @param {any} value to save for this item
     *  @param {boolean=} Should the formItem be updated to display the new value?
     */
    open fun storeValue(value: dynamic, showValue: Boolean?): Unit = definedExternally
    /**
     *   Return the value tracked by this form item.
     * 
     *   Note that for FormItems that have a ValueMap or where a
     *   FormItem.formatValue has been defined, getValue() returns the
     *   underlying value of the FormItem, not the displayed value.
     * 
     * 
     */
    open fun getValue(): dynamic = definedExternally
    /**
     *   Manually sets this FormItem to the result of FormItem.formula or FormItem.textFormula.
     *   Formulas are normally automatically recomputed and the result automatically applied to the FormItem
     *   according to the rules described under FormItem.formula. applyFormula() exists
     *   to cover any rare cases where these rules are not correct.
     * 
     *   Calling applyFormula() has no effect if no FormItem.formula or
     *   FormItem.textFormula is configured for this FormItem.
     * 
     * 
     */
    open fun applyFormula(): Unit = definedExternally
    /**
     *   Is this form item editable or read-only?
     * 
     *   This setting differs from the enabled/disabled state in that most form items will
     *   allow copying of the contents while read-only but do not while disabled.
     * 
     */
    open fun getCanEdit(): Boolean = definedExternally
    /**
     *   Is this form item editable (canEdit:true) or read-only (canEdit:false)?
     *   Setting the form item to non-editable causes it to render as read-only,
     *   using the appearance specified via FormItem.readOnlyDisplay.
     * 
     *   The default appearance for canEdit:false items
     *   (readOnlyDisplay:"readOnly") differs from the disabled state in that
     *   the form item is not rendered with disabled styling and
     *   most form items will allow copying of the contents while read-only but do not while
     *   disabled.
     * 
     * 
     *  @param {boolean} Can this form item be edited?
     */
    open fun setCanEdit(canEdit: Boolean): Unit = definedExternally
    /**
     *   Does this form item produce an AdvancedCriteria sub criterion object?
     *   If this method returns true, DynamicForm.getValuesAsCriteria on the
     *   form containing this item will always return an AdvancedCriteria object, calling
     *   FormItem.getCriterion
     * 
     *   on each item to retrieve the individual criteria.
     * 
     *   Default implementation will return true if FormItem.operator is
     *   explicitly specified.
     * 
     * 
     */
    open fun hasAdvancedCriteria(): Boolean = definedExternally
    /**
     *   When a dynamic form is editing an advanced criteria
     *   object via DynamicForm.setValuesAsCriteria, this method is used to determine
     *   which sub-criteria apply to which form item(s).
     * 
     *   This method will be called on each item, and passed the sub-criterion of the
     *   AdvancedCriteria object. It should return true if the item can edit the criterion,
     *   otherwise false. If it returns true, setValuesAsCriteria() will call
     *   FormItem.setCriterion to actually apply the criterion to the form item, and
     *   DynamicForm.getValuesAsCriteria can subsequently retrieve the edited criterion
     *   by calling FormItem.getCriterion.
     * 
     *   Default implementation will return true if the criterion fieldName and
     *   operator match the fieldName and operator (or default operator) for
     *   this item.
     * 
     * 
     *  @param {Criterion} sub-criterion from an AdvancedCriteria object
     */
    open fun canEditCriterion(criterion: Criterion): Boolean = definedExternally
    /**
     *   Override this method if you need to provide a specialized criterion from this formItem
     *   when creating an AdvancedCriteria via DynamicForm.getValuesAsCriteria.
     * 
     *   This API is provided to allow you to specify a more complex criterion than the
     *   "field-operator-value" criterions that are built-in. Note that the built-in behavior is
     *   generally quite flexible and powerful enough for most requirements. An example of a case
     *   where you might want to override this method is if you wanted to implement a date range
     *   selection (ie, date &gt; x AND date &lt; y) on a form that was combining its other criteria
     *   fields with an "or" operator.
     * 
     *   Note that this method is part of the criteria editing subsystem: if overridden, it
     *   is likely that you will want to also override FormItem.hasAdvancedCriteria to
     *   ensure this method is called by the form, and to support editing of existing advanced
     *   criteria you may also need to override FormItem.canEditCriterion and
     *   FormItem.setCriterion.
     * 
     *   The default implementation will return a criterion including the form item value, fieldName
     *   and specified FormItem.operator, or a default operator derived from the
     *   form item data type if no explicit operator is specified.
     * 
     * 
     *  @param {TextMatchStyle=} If passed assume the textMatchStyle  will be used when performing a fetch operation with these criteria. This may impact  the criterion's operator property.
     */
    open fun getCriterion(textMatchStyle: 
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
                                          String /* exact |  exactCase |  substring |  startsWith */?): Criterion = definedExternally
    /**
     *   Update this form item to reflect a criterion object from within an AdvancedCriteria.
     *   Called by DynamicForm.setValuesAsCriteria when FormItem.canEditCriterion
     *   returns true for this item.
     * 
     *   Default implementation simply calls FormItem.setValue with the value
     *   of the criterion passed in
     * 
     *  @param {Criterion} criterion to edit
     */
    open fun setCriterion(criterion: Criterion): Unit = definedExternally
    /**
     *   Is the value clipped?
     * 
     *   The form item must have value clipping enabled. If a form item type supports the
     *   clipValue attribute, then clipValue must be true. TextItems and derivatives
     *   (e.g. SpinnerItem) automatically clip their values.
     * 
     * 
     */
    open fun valueClipped(): Boolean = definedExternally
    /**
     *     Clear all error messages for this item
     * 
     */
    open fun clearErrors(): Unit = definedExternally
    /**
     *   Set the error message(s) for this item
     * 
     *  @param {string | Array<Partial<string>>} error message(s)
     */
    open fun setErrors(errors: dynamic): Unit = definedExternally
    /**
     *   Return whether this item currently has any validation errors as
     *    a result of a previous validation pass.
     * 
     */
    open fun hasErrors(): Boolean = definedExternally
    /**
     *   Validate this item.
     * 
     * 
     */
    open fun validate(): Boolean = definedExternally
    /**
     *   Setter to mark this formItem as FormItem.required, or not required at runtime.
     *   Note that an alternative approach to updating the required flag directly
     *   would be to simply use a ValidatorType type validator.
     * 
     *   Note that this method will not re-validate this item by default or clear any
     *   existing validation errors. If desired, this may be achieved by calling
     *   FormItem.validate or DynamicForm.clearErrors.
     * 
     *  @param {boolean} new FormItem.required value.
     */
    open fun setRequired(required: Boolean): Unit = definedExternally
    /**
     *   For text-based items, this method returns the index of the start of the current
     *   selection if the item currently has the focus (if no text is selected, this equates to
     *   the current position of the text editing cursor). See TextItem.getSelectionRange
     *   for details of what is returned if the item does not have the focus (note, it is
     *   important to read this documentation, because the behavior when the item does not have
     *   the focus varies by browser)
     * 
     */
    open fun getCursorPosition(): Number = definedExternally
    /**
     *   This method is fired when the user rolls off this item (or the title for this item) and
     *   will clear any hover canvas shown by the item.
     * 
     */
    open fun stopHover(): Unit = definedExternally
    /**
     *   Optional stringMethod to fire when the user hovers over this item.
     *   Return false to suppress default behavior of showing a hover canvas containing the
     *   HTML returned by formItem.itemHoverHTML() /
     *   form.itemHoverHTML().
     * 
     * 
     *  @param {FormItem} Pointer to this item
     *  @param {DynamicForm} This items form
     */
    open fun itemHover(item: FormItem, form: DynamicForm): Unit = definedExternally
    /**
     *   Optional stringMethod to fire when the user hovers over this item's title.
     *   Return false to suppress default behavior of showing a hover canvas containing the
     *   HTML returned by formItem.titleHoverHTML() /
     *   form.titleHoverHTML().
     * 
     * 
     *  @param {FormItem} Pointer to this item
     *  @param {DynamicForm} This items form
     */
    open fun titleHover(item: FormItem, form: DynamicForm): Unit = definedExternally
    /**
     *   Optional stringMethod to fire when the user hovers over this item's value.
     *   Return false to suppress default behavior of showing a hover canvas containing the
     *   HTML returned by FormItem.valueHoverHTML / DynamicForm.valueHoverHTML.
     * 
     * 
     *  @param {FormItem} Pointer to this item
     *  @param {DynamicForm} This items form
     */
    open fun valueHover(item: FormItem, form: DynamicForm): Unit = definedExternally
    /**
     *   If defined, this method should return the HTML to display in a hover canvas when the
     *   user holds the mousepointer over this item's title. Return null to suppress the hover
     *   canvas altogether.
     * 
     *   If not defined, DynamicForm.titleHoverHTML will be evaluated to determine
     *   hover content instead.
     * 
     * 
     *  @param {FormItem} Pointer to this item
     *  @param {DynamicForm} This items form
     */
    open fun titleHoverHTML(item: FormItem, form: DynamicForm): String = definedExternally
    /**
     *   If defined, this method should return the HTML to display in a hover canvas when the
     *   user holds the mousepointer over this item's value. Return null to suppress the hover
     *   canvas altogether.
     * 
     *   If not defined, DynamicForm.valueHoverHTML will be evaluated to determine
     *   hover content instead.
     * 
     * 
     *  @param {FormItem} Pointer to this item
     *  @param {DynamicForm} This items form
     */
    open fun valueHoverHTML(item: FormItem, form: DynamicForm): String = definedExternally
    /**
     *   If defined, this method should return the HTML to display in a hover canvas when the
     *   user holds the mousepointer over this item. Return null to suppress the hover
     *   canvas altogether.
     * 
     *   If not defined, dynamicForm.itemHoverHTML() will be evaluated to
     *   determine hover content instead.
     * 
     * 
     *  @param {FormItem} Pointer to this item
     *  @param {DynamicForm} This items form
     */
    open fun itemHoverHTML(item: FormItem, form: DynamicForm): String = definedExternally
    /**
     *   Setter for FormItem.tabIndex.
     * 
     *  @param {Integer} new tabIndex for the item
     */
    open fun setTabIndex(tabIndex: Number): Unit = definedExternally
    /**
     *   Set this item to be enabled or disabled at runtime.
     * 
     *  @param {boolean} true if this item should be disabled
     */
    open fun setDisabled(disabled: Boolean): Unit = definedExternally
    /**
     *   Setter method for FormItem.showDisabled
     * 
     *  @param {boolean} new showDisabled setting
     */
    open fun setShowDisabled(showDisabled: Boolean): Unit = definedExternally
    /**
     *   Is this item disabled?
     * 
     */
    open fun isDisabled(): Boolean = definedExternally
    /**
     *   Set this item to be enabled at runtime.
     * 
     */
    open fun enable(): Unit = definedExternally
    /**
     *   Set this item to be disabled at runtime.
     * 
     */
    open fun disable(): Unit = definedExternally
    /**
     *   Returns true for items that can accept keyboard focus such as data items
     *   (TextItem, TextAreaItem, etc),
     *   CanvasItem with a focusable canvas, or items where FormItem.canFocus
     *   was explicitly set to true.
     * 
     * 
     */
    open fun getCanFocus(): Boolean = definedExternally
    /**
     *     Move the keyboard focus into this item's focusable element
     * 
     */
    open fun focusInItem(): Unit = definedExternally
    /**
     *     Takes focus from this form item's focusable element.
     * 
     */
    open fun blurItem(): Unit = definedExternally
    /**
     *   Returns true if this formItem has the keyboard focus. Note that in Internet Explorer
     *   focus notifications can be asynchronous (see EventHandler.synchronousFocusNotifications).
     *   In this case, this method can correctly
     *   return false when, intuitively, you would expect it to return true:
     * 
     *     someItem.focusInItem();
     *     if (someItem.isFocused()) {
     *       // In most browsers we would get here, but not in Internet Explorer with
     *       // EventHandler.synchronousFocusNotifications disabled
     *     }
     * 
     * 
     * 
     */
    open fun isFocused(): Boolean = definedExternally
    /**
     *   Shifts focus to the next focusable element after this item, skipping any elements
     *   nested inside the tabbing group for this item, such as sub-elements, nested canvases
     *   in a CanvasItem, or icons.
     * 
     *   This method makes use of the TabIndexManager.shiftFocusAfterGroup method to request
     *   focus be changed to the next registered entry. By default standard focusable
     *   SmartClient UI elements, including Canvases, FormItems, FormItemIcons, etc are
     *   registered with the TabIndexManager in the appropriate order, and will accept focus
     *   if Canvas.canFocus, and not FormItem.disabled or
     *   Canvas.showClickMask.
     * 
     *   Canvases support a similar method: Canvas.focusAfterGroup.
     * 
     *   NOTE: Focusable elements created directly in the raw HTML bootstrap or
     *   by application code will not be passed focus by this method unless they have also been
     *   explicitly registered with the TabIndexManager. See the tabOrderOverview
     *   for more information.
     * 
     *  @param {boolean} direction to shift focus - true to move forward, false to move     backwards (as with a shift+tab interaction).
     */
    open fun focusAfterItem(forward: Boolean): Unit = definedExternally
    /**
     *   Is the user performing a native "cut" event to modify the value of a freeform text
     *   field? This method may be invoked during change notification flow methods including
     *   FormItem.change, FormItem.changed and
     *   FormItem.transformInput. See FormItem.supportsCutPasteEvents.
     * 
     */
    open fun isCutEvent(): Boolean = definedExternally
    /**
     *   Is the user performing a native "paste" event to modify the value of a freeform text
     *   field? This method may be invoked during change notification flow methods including
     *   FormItem.change, FormItem.changed and
     *   FormItem.transformInput. See FormItem.supportsCutPasteEvents.
     * 
     */
    open fun isPasteEvent(): Boolean = definedExternally
    /**
     *   Should some keypress event on this item be prevented from bubbling (such that
     *   the containing form and ancestors do not receive the event).
     * 
     *   This method is called after standard item keypress handlers when the user presses
     *   a key while focused in this item. Returning true will suppress bubbling of the event
     *   to the containing form. This is useful to avoid having the form react to key
     *   events which "have meaning" to the focused item.
     * 
     *   Default implementation varies by item type. In short character keys
     *   are suppressed for all editable fields, as are keys which will modify the
     *   current state of the field
     *   ("Arrow" keys for moving around free form text editors, etc).
     * 
     * 
     *   Developers may override this method to allow the form to react to certain keypresses,
     *   for example allowing scrolling of the form when the user presses the arrow keys,
     *   but they should be aware that doing so could lead to confusing user experience
     *   if the keypress will also move the position of the caret within a text box (say).
     * 
     *   Note that when this method returns true, no Canvas.keyPress event
     *   will fire on the form for the key pressed. However developers will still receive the
     *   separate DynamicForm.itemKeyPress event.
     * 
     *  @param {KeyName} name of the key pressed
     *  @param {number} If this was a character key, this is the numeric value    for the character
     */
    open fun shouldStopKeyPressBubbling(keyName: String, characterValue: Number): Boolean = definedExternally
    /**
     *   Returns the left coordinate of this form item in pixels. Note that this method
     *   is only reliable after the item has been drawn.
     * 
     */
    open fun getLeft(): Number = definedExternally
    /**
     *   Returns the top coordinate of the form item in pixels. Note that this method is only
     *   reliable after the item has been drawn out.
     * 
     */
    open fun getTop(): Number = definedExternally
    /**
     *   Returns the drawn page-left coordinate of this form item in pixels.
     * 
     */
    open fun getPageLeft(): Number = definedExternally
    /**
     *   Returns the drawn page-top coordinate of this form item in pixels.
     * 
     */
    open fun getPageTop(): Number = definedExternally
    /**
     *   Expression that's evaluated to see if an item should be dynamically hidden.
     * 
     *   showIf() is evaluated whenever the form draws or redraws.
     * 
     *   Note that explicit calls to FormItem.show or FormItem.hide will
     *   will wipe out the showIf expression.
     * 
     *   Alternatively, you can use Criteria to declare when a FormItem is
     *   visible via FormItem.visibleWhen.
     * 
     * 
     *  @param {FormItem} the form item itself (also available as "this")
     *  @param {any} current value of the form item
     *  @param {DynamicForm} the managing DynamicForm instance
     *  @param {object} the current set of values for the form as a whole
     */
    open fun showIf(item: FormItem, value: dynamic, form: DynamicForm, values: dynamic): Boolean = definedExternally
    /**
     *   Expression evaluated to determine the FormItem.defaultValue when no value is
     *   provided for this item.
     * 
     *   If you don't need dynamic evaluation, you can just use item.defaultValue.
     * 
     * 
     *  @param {FormItem} the form item itself (also available as "this")
     *  @param {DynamicForm} the managing DynamicForm instance
     *  @param {object} the current set of values for the form as a whole
     */
    open fun defaultDynamicValue(item: FormItem, form: DynamicForm, values: dynamic): Unit = definedExternally
    /**
     *   Called when this FormItem receives focus.
     * 
     * 
     *  @param {DynamicForm} the managing DynamicForm instance
     *  @param {FormItem} the form item itself (also available as "this")
     */
    open fun focus(form: DynamicForm, item: FormItem): Unit = definedExternally
    /**
     *   Called when this FormItem loses focus.
     * 
     * 
     *  @param {DynamicForm} the managing DynamicForm instance
     *  @param {FormItem} the form item itself (also available as "this")
     */
    open fun blur(form: DynamicForm, item: FormItem): Unit = definedExternally
    /**
     *   Notification method fired when the user enters this formItem.
     *   Differs from FormItem.focus in that while focus and blur
     *   may fire multiple as the user navigates sub elements of an item (such as interacting
     *   with a pick list), editorEnter will typically fire once when the user
     *   starts to edit this item as a whole, and once when the user moves onto a different
     *   item or component
     * 
     *  @param {DynamicForm} form containing this item
     *  @param {FormItem} form item recieving focus
     *  @param {any} current item value.
     */
    open fun editorEnter(form: DynamicForm, item: FormItem, value: dynamic): Unit = definedExternally
    /**
     *   Notification method fired when the user leaves this formItem.
     *   Differs from FormItem.blur in that while focus and blur
     *   may fire multiple as the user navigates sub elements of an item (such as interacting
     *   with a pick list), editorEnter will typically fire once when the user
     *   starts to edit this item as a whole, and editorExit fires once when the
     *   user moves onto a different item or component
     * 
     *  @param {DynamicForm} form managing this form item
     *  @param {FormItem} pointer to the form item being managed
     *  @param {any} current value of the form item
     */
    open fun editorExit(form: DynamicForm, item: FormItem, value: dynamic): Unit = definedExternally
    /**
     *   Called when this FormItem is clicked on.
     * 
     *   Note: click() is available on StaticTextItem, BlurbItems, ButtonItem, and
     *   derivatives. Other form items (such as HiddenItem) do not support click().
     * 
     * 
     *  @param {DynamicForm} the managing DynamicForm instance
     *  @param {FormItem} the form item itself (also available as "this")
     */
    open fun click(form: DynamicForm, item: FormItem): Boolean = definedExternally
    /**
     *   Called when this FormItem is double-clicked.
     * 
     * 
     *  @param {DynamicForm} the managing DynamicForm instance
     *  @param {FormItem} the form item itself (also available as "this")
     */
    open fun doubleClick(form: DynamicForm, item: FormItem): Boolean = definedExternally
    /**
     *   Called when the mouse is right-clicked anywhere in this formItem. If the implementation
     *   returns false, default browser behavior is cancelled.
     * 
     *   Note that it can be bad practice to cancel this method if the mouse is over the data
     *   element for the item, because doing so would replace the builtin browser-default menus
     *   that users may expect. You can use DynamicForm.getEventItemInfo to return an
     *   FormItemEventInfo that can be used to determine which part of the
     *   item is under the mouse.
     * 
     * 
     *  @param {DynamicForm} the managing DynamicForm instance
     *  @param {FormItem} the form item itself (also available as "this")
     */
    open fun showContextMenu(form: DynamicForm, item: FormItem): Boolean = definedExternally
    /**
     *   Notification method called when the FormItem.showPickerIcon is clicked.
     *   This method will fire after the FormItemIcon.click handler for the
     *   FormItem.pickerIconProperties. If the event is not cancelled,
     *   the standard FormItem.iconClick will also fire.
     * 
     *   The default implementation will call FormItem.showPicker.
     * 
     * 
     *  @param {DynamicForm} the DynamicForm containing the picker icon's item.
     *  @param {FormItem} the FormItem containing the picker icon.
     *  @param {FormItemIcon} the picker icon.
     */
    open fun pickerIconClick(form: DynamicForm, item: FormItem, pickerIcon: FormItemIcon): Boolean = definedExternally
    /**
     *   Notification method called when the user clicks on a form item icon.
     * 
     *   The icon's FormItemIcon.click method if any is called first. Then, if the clicked
     *   icon is the FormItem.showPickerIcon, the FormItem.pickerIconClick method is
     *   called. Then, this method is called.
     * 
     *   This event may be cancelled by returning false to
     *   suppress the FormItem.click handler from also firing in response to the
     *   user interaction.
     * 
     * 
     *  @param {DynamicForm} a pointer to this item's form
     *  @param {FormItem} a pointer to this form item
     *  @param {FormItemIcon} a pointer to the icon that received the click event.
     */
    open fun iconClick(form: DynamicForm, item: FormItem, icon: FormItemIcon): Boolean = definedExternally
    /**
     *     StringMethod.
     *     Default action to fire when an icon has keyboard focus and the user types a key.
     *     May be overridden by setting keyPress on the form item icon directly.
     * 
     *  @param {KeyName} name of the key pressed
     *  @param {string} character produced by the keypress
     *  @param {DynamicForm} a pointer to this item's form
     *  @param {FormItem} a pointer to this form item
     *  @param {FormItemIcon} a pointer to the icon that received the click event.
     */
    open fun iconKeyPress(keyName: String, character: String, form: DynamicForm, item: FormItem, icon: FormItemIcon): Unit = definedExternally
    /**
     *   Called when a FormItem's value is about to change as the result of user interaction. This
     *   method fires after the user performed an action that would change the value of this field,
     *   but before the element itself is changed.
     * 
     *   Returning false cancels the change. Note that if what you want to do is
     *   transform the user's input, for example, automatically change separator
     *   characters to a standard separator character, you should implement
     *   FormItem.transformInput rather than using a combination of
     *   change() and setValue() to accomplish the same thing. Returning false from
     *   change is intended for rejecting input entirely, such as typing invalid
     *   characters.
     * 
     *   Note that if you ask the form for the current value in this handler, you will get the old
     *   value because the change has not yet been committed. The new value is available as a
     *   parameter to this method.
     * 
     * 
     *  @param {DynamicForm} the managing DynamicForm instance
     *  @param {FormItem} the form item itself (also available as "this")
     *  @param {any} The new value of the form item
     *  @param {any} The previous value of the form item
     */
    open fun change(form: DynamicForm, item: FormItem, value: dynamic, oldValue: dynamic): Boolean = definedExternally
    /**
     *   Called when a FormItem's value has been changed as the result of user interaction. This
     *   method fires after the newly specified value has been stored.
     * 
     *  @param {DynamicForm} the managing DynamicForm instance
     *  @param {FormItem} the form item itself (also available as "this")
     *  @param {any} The current value (after the change).
     */
    open fun changed(form: DynamicForm, item: FormItem, value: dynamic): Unit = definedExternally
    /**
     *   Notification method called when FormItem.showPending is enabled and this
     *   form item should either clear or show its "Pending" visual state.
     * 
     *   The default behavior is that the FormItem.titleStyle and
     *   FormItem.cellStyle are updated to include/exclude the "Pending" suffix.
     *   Standard form item types may implement additional default behavior (see any item-specific
     *   pendingStatusChanged() documentation). Returning false will cancel the default
     *   behavior.
     * 
     *   The pendingStatusChanged() notification method is typically used by CanvasItem-derived
     *   form items, where a custom or supplemental pending visual state is desired.
     * 
     *  @param {DynamicForm} the managing DynamicForm instance.
     *  @param {FormItem} the form item itself (also available as "this").
     *  @param {boolean} true if the item should show its pending visual state; false otherwise.
     *  @param {any} the current form item value.
     *  @param {any} the value that would be restored by a call to DynamicForm.resetValues.
     */
    open fun pendingStatusChanged(form: DynamicForm, item: FormItem, pendingStatus: Boolean, newValue: dynamic, value: dynamic): Boolean = definedExternally
    /**
     *   Called when a FormItem's value is about to change as the result of user interaction. This
     *   method fires after the user performed an action that would change the value of this field,
     *   and allows the developer to modify / reformat the value before it gets validated / saved.
     *   Fires before FormItem.change.
     * 
     *   Return the reformatted value.
     * 
     * 
     *  @param {DynamicForm} the managing DynamicForm instance
     *  @param {FormItem} the form item itself (also available as "this")
     *  @param {any} The new value of the form item
     *  @param {any} The previous (current) value of the form item
     */
    open fun transformInput(form: DynamicForm, item: FormItem, value: dynamic, oldValue: dynamic): dynamic = definedExternally
    /**
     *   Notification method fired when the user clicks the title for this item
     * 
     *  @param {DynamicForm} the managing DynamicForm instance
     *  @param {FormItem} the form item whose title was clicked
     */
    open fun titleClick(form: DynamicForm, item: FormItem): Boolean = definedExternally
    /**
     *   Notification method fired when the user double-clicks the title for this item
     * 
     *  @param {DynamicForm} the managing DynamicForm instance
     *  @param {FormItem} the form item whose title was double-clicked
     */
    open fun titleDoubleClick(form: DynamicForm, item: FormItem): Boolean = definedExternally
    /**
     *   StringMethod fired when the user presses a key while focused in this form item.
     * 
     * 
     *  @param {FormItem} Item over which the keypress occurred
     *  @param {DynamicForm} Pointer to the item's form
     *  @param {KeyName} Name of the key pressed (Example: "A", "Enter")
     *  @param {number} If this was a character key, this is the numeric value    for the character
     */
    open fun keyPress(item: FormItem, form: DynamicForm, keyName: String, characterValue: Number): Boolean = definedExternally
    /**
     *   StringMethod fired in response to a keydown while focused in this form item.
     * 
     * 
     *  @param {FormItem} Item over which the keydown occurred
     *  @param {DynamicForm} Pointer to the item's form
     *  @param {KeyName} Name of the key pressed (Example: "A", "Enter")
     */
    open fun keyDown(item: FormItem, form: DynamicForm, keyName: String): Boolean = definedExternally
    /**
     *   StringMethod fired in response to a keyup while focused in this form item.
     * 
     * 
     *  @param {FormItem} Item over which the keyup occurred
     *  @param {DynamicForm} Pointer to the item's form
     *  @param {KeyName} Name of the key pressed (Example: "A", "Enter")
     */
    open fun keyUp(item: FormItem, form: DynamicForm, keyName: String): Boolean = definedExternally
    /**
     *   Except when printing and FormItem.getPrintValueIcon
     *   is implemented, implementing this stringMethod allows the developer to specify the image
     *   source for an icon to be displayed for the current form item value.
     * 
     *   The special value "blank" means that no image will be displayed. This is typically used
     *   in conjunction with FormItem.getValueIconStyle to implement spriting of the
     *   value icon. Note that when spriting the value icon, it is recommended to implement
     *   getPrintValueIcon() and FormItem.getPrintValueIconStyle
     *   when printing.
     * 
     *   Takes precedence over FormItem.valueIcons
     * 
     *   The returned SCImgURL, if not null or "blank", will be suffixed with
     *   FormItem.imageURLSuffix.
     * 
     * 
     *  @param {any} value of the item.
     */
    open fun getValueIcon(value: dynamic): String = definedExternally
    /**
     *   If implemented, this stringMethod is called when printing to
     *   obtain the image source for an icon to be displayed for the current form item value.
     *   The special value "blank" means that no image will be displayed.
     * 
     *   Implementing getPrintValueIcon() may be useful in order to swap out the
     *   value icon with a more printer-friendly image (perhaps a grayscale-only image). Another
     *   use is to avoid spriting when printing. Value icon spriting may be problematic when
     *   printing because browsers typically default to not printing background images.
     * 
     *   Takes precedence over FormItem.valueIcons and FormItem.getValueIcon
     *   when printing.
     * 
     *   The returned SCImgURL, if not null or "blank", will be suffixed with
     *   FormItem.imageURLSuffix.
     * 
     * 
     *  @param {any} value of the item.
     */
    open fun getPrintValueIcon(value: dynamic): String = definedExternally
    companion object {
        /**
         *  Default FormItemIcon.hspace value for pickers
         *   created by FormItem.getPickerIcon.
         *  @type {Integer}
         *  @default "0"
         */
        var defaultPickerIconSpace: Number = definedExternally
        /**
         *  Default FormItemIcon.height value for pickers
         *   created by FormItem.getPickerIcon.
         *  @type {Integer}
         *  @default "22"
         */
        var defaultPickerIconHeight: Number = definedExternally
        /**
         *  Creates a new FormItem
         * 
         *  @param typeCheckedProperties {Partial<FormItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {FormItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): FormItem = definedExternally
        /**
         *   Returns a FormItemIcon for a standard picker with skin-specific
         *   settings.
         * 
         *  @param {PickerIconName} Name of picker icon
         *  @param {FormItemIcon=} Properties to apply to new picker icon
         */
        fun getPickerIcon(pickerName: 
                                      /**
                                       *  Picker icon to clear a field value.
                                       *  Picker icon to start a search.
                                       *  Picker icon to refresh a value.
                                       *  Picker icon for date value.
                                       *  Picker icon for a general combobox.
                                       */
                                      String /* clear |  search |  refresh |  date |  comboBox */, properties: FormItemIcon?): FormItemIcon = definedExternally
    }
}