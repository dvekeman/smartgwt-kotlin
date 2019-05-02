@file:JsQualifier("isc")
package isc

/**
 *  Displays one or more records "horizontally" with one property per line.
 */
open external class DetailViewer : Canvas, DataBoundComponent {
    /**
     *  Criteria to be used when DetailViewer.autoFetchData is set.
     * 
     *   This property supports dynamicCriteria - use Criterion.valuePath
     *   to refer to values in the Canvas.ruleScope.
     *  @type {Criteria}
     *  @default null
     */
    override var initialCriteria: dynamic = definedExternally
    /**
     *  If true, when this component is first drawn, automatically call this.fetchData().
     *   Criteria for this fetch may be picked up from DetailViewer.initialCriteria, and textMatchStyle may
     *   be specified via ListGrid.autoFetchTextMatchStyle.
     * 
     *   NOTE: if autoFetchData is set, calling
     *   ListGrid.fetchData before draw will cause two requests to be issued, one from the manual
     *   call to fetchData() and one from the autoFetchData setting. The second request will use
     *   only DetailViewer.initialCriteria and not any other criteria or settings from the first request.
     *   Generally, turn off autoFetchData if you are going to manually call ListGrid.fetchData at any time.
     *  @type {boolean}
     *  @default false
     */
    override var autoFetchData: Boolean = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "DetailViewerEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
    /**
     *  A single record object or an array of them, specifying data. Note that DetailViewers do
     *   not observe changes to the data array (in other words they will not automatically
     *   re-draw when the data provided via this property is altered).
     *  @type {Array<Partial<DetailViewerRecord>> | Array<Partial<Record>> | any}
     *  @default null
     */
    open var data: dynamic = definedExternally
    /**
     *  DetailViewers do not yet support paging, and will fetch and render all available
     *   records.
     *  @type {FetchMode}
     *  @default "basic"
     */
    override var dataFetchMode: 
                                /**
                                 *  All records that match the current filter are fetched. Sorting is        performed on the client.
                                 *  Only requested ranges of records are fetched, with predictive fetch        ahead. Sorting is performed on the server.
                                 *  All records available from the DataSource are fetched. Filtering by        search criteria and sorting are both performed on the client.
                                 */
                                String /* basic |  paged |  local */ = definedExternally
    /**
     *  The DataSource that this component should bind to for default fields and for performing
     *   DSRequest.
     * 
     *   Can be specified as either a DataSource instance or the String ID of a DataSource.
     *  @type {DataSource | GlobalId}
     *  @default null
     */
    override var dataSource: dynamic = definedExternally
    /**
     *  Height of rows rendered by the DetailViewer. Acts as a minimum - the DetailViewer never
     *   clips values. This attribute can be set as null.
     *  @type {Integer}
     *  @default "19"
     */
    open var rowHeight: Number = definedExternally
    /**
     *  An array of field objects, specifying the order and type of fields to display in this
     *   DetailViewer. In DetailViewers, the fields specify rows.
     *  @type {Array<Partial<DetailViewerField>>}
     *  @default null
     */
    override var fields: Array<dynamic> = definedExternally
    /**
     *  Specifies a list of icons that can be used in DataBoundComponent.editHilites.
     * 
     *   hiliteIcons should be specified as an Array of SCImgURL.
     *   When present, the hilite editing interface shown when DataBoundComponent.editHilites is called
     *   will offer the user a drop down for picking one of these icons when defining either a
     *   simple or advanced hilite rule.
     * 
     *   If the user picks an icon, the created hiliting rule will have Hilite.icon set to
     *   the chosen icon. DataBoundComponent.hiliteIconPosition controls where the icon will
     *   appear for that field -- the default is that it appears in front of the normal cell content.
     *   This can also be overridden at the field level.
     *  @type {Array<Partial<string>>}
     *  @default "["[SKINIMG]/Dialog/notify.png", "[SKINIMG]/Dialog/warn.png", "[SKINIMG]/actions/approve.png"]"
     */
    override var hiliteIcons: Array<dynamic> = definedExternally
    /**
     *  When DetailViewer.hiliteIcons are present, where the hilite icon will be placed
     *   relative to the field value. See HiliteIconPosition. Can be overridden at the
     *   field level.
     *  @type {HiliteIconPosition}
     *  @default "before"
     */
    override var hiliteIconPosition: 
                                     /**
                                      *  icon will be placed before the normal cell contents
                                      *  icon will be placed after the normal cell contents
                                      *  icon will be shown instead of the normal cell contents
                                      */
                                     String /* before |  after |  replace */ = definedExternally
    /**
     *  Default width and height of DetailViewer.hiliteIcons for this component.
     *   Can be overridden at the component level via explicit
     *   DetailViewer.hiliteIconWidth and
     *   DetailViewer.hiliteIconHeight, or at the field level via
     *   ListGridField.hiliteIconSize,
     *   ListGridField.hiliteIconWidth and
     *   ListGridField.hiliteIconHeight
     *  @type {number}
     *  @default "12"
     */
    override var hiliteIconSize: Number = definedExternally
    /**
     *  Width for hilite icons for this component.
     *   Overrides DetailViewer.hiliteIconSize.
     *   Can be overridden at the field level.
     *  @type {number}
     *  @default null
     */
    override var hiliteIconWidth: Number = definedExternally
    /**
     *  Height for hilite icons for this listGrid.
     *   Overrides DetailViewer.hiliteIconSize.
     *   Can be overridden at the field level
     *  @type {number}
     *  @default null
     */
    override var hiliteIconHeight: Number = definedExternally
    /**
     *  How much padding should there be on the left of DetailViewer.hiliteIcons by default?
     *   Can be overridden at the field level
     *  @type {number}
     *  @default "2"
     */
    override var hiliteIconLeftPadding: Number = definedExternally
    /**
     *  How much padding should there be on the right of DetailViewer.hiliteIcons by default?
     *   Can be overridden at the field level
     *  @type {number}
     *  @default "2"
     */
    override var hiliteIconRightPadding: Number = definedExternally
    /**
     *  Name of the field in the DetailViewerRecord which specifies the data property for that record.
     *  @type {string}
     *  @default "name"
     */
    open var fieldIdProperty: String = definedExternally
    /**
     *  The number of records to display in a block. A block is a horizontal row on a page
     *       containing one or more records, as specified by the value of recordsPerBlock. The
     *       height of a block is equal to the height of a single record. The default setting of
     *       1 causes each record to appear by itself in a vertical row. Setting recordsPerBlock
     *       to 2 would cause records to appear side by side in groups of two.
     *       Use a value of "\*" to indicate all records.
     *  @type {number}
     *  @default "1"
     */
    open var recordsPerBlock: Number = definedExternally
    /**
     *  A string (HTML acceptable) that will be written to a page to separate blocks.
     *  @type {HTMLString}
     *  @default "&lt;br&gt;&lt;br&gt;"
     */
    open var blockSeparator: String = definedExternally
    /**
     *  Whether to show the field when the value is null
     *  @type {boolean}
     *  @default true
     */
    open var showEmptyField: Boolean = definedExternally
    /**
     *  Text to show for an empty cell
     *  @type {HTMLString}
     *  @default "&amp;nbsp;"
     */
    open var emptyCellValue: String = definedExternally
    /**
     *  text to put before a label
     *  @type {HTMLString}
     *  @default ""
     */
    open var labelPrefix: String = definedExternally
    /**
     *  text to put after a label
     *  @type {HTMLString}
     *  @default ":"
     */
    open var labelSuffix: String = definedExternally
    /**
     *  Horizontal alignment of value-labels in this viewer. If unspecified, defaults to
     *   "left" when in RTL mode and "right" otherwise.
     *  @type {Alignment}
     *  @default null
     */
    open var labelAlign: 
                         /**
                          *  Center within container.
                          *  Stick to left side of container.
                          *  Stick to right side of container.
                          */
                         String /* center |  left |  right */ = definedExternally
    /**
     *  Horizontal alignment of values in this viewer. If unspecified, defaults to
     *   "right" when in RTL mode and "left" otherwise.
     *  @type {Alignment}
     *  @default null
     */
    open var valueAlign: 
                         /**
                          *  Center within container.
                          *  Stick to left side of container.
                          *  Stick to right side of container.
                          */
                         String /* center |  left |  right */ = definedExternally
    /**
     *  Should the label be allowed to wrap, or be fixed to one line no matter how long
     *  @type {boolean}
     *  @default false
     */
    open var wrapLabel: Boolean = definedExternally
    /**
     *  Whether values should be allowed to wrap by default, or should be shown on one line
     *   regardless of length.
     *  @type {boolean}
     *  @default true
     */
    open var wrapValues: Boolean = definedExternally
    /**
     *  CSS style for the component as a whole.
     *  @type {CSSStyleName}
     *  @default "detailViewer"
     */
    override var styleName: String = definedExternally
    /**
     *  CSS style for each block (one record's worth of data).
     *  @type {CSSStyleName}
     *  @default "detailBlock"
     */
    open var blockStyle: String = definedExternally
    /**
     *  CSS style for a normal detail label
     *  @type {CSSStyleName}
     *  @default "detailLabel"
     */
    open var labelStyle: String = definedExternally
    /**
     *  CSS style for a normal value
     *  @type {CSSStyleName}
     *  @default "detail"
     */
    open var cellStyle: String = definedExternally
    /**
     *  CSS style for a header
     *  @type {CSSStyleName}
     *  @default "detailHeader"
     */
    open var headerStyle: String = definedExternally
    /**
     *  Optional CSS style for a cell in printable HTML for this component. If unset
     *   DetailViewer.cellStyle will be used for printing as well as normal presentation.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var printCellStyle: String = definedExternally
    /**
     *  Optional CSS style for a label cell in printable HTML for this component. If unset
     *   DetailViewer.labelStyle will be used for printing as well as normal presentation.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var printLabelStyle: String = definedExternally
    /**
     *  Optional CSS style for a header in printable HTML for this component. If unset
     *   DetailViewer.headerStyle will be used for printing as well as normal presentation.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var printHeaderStyle: String = definedExternally
    /**
     *  CSS style for a separator
     *  @type {CSSStyleName}
     *  @default "detail"
     */
    open var separatorStyle: String = definedExternally
    /**
     *  How should Date type values be displayed in this DetailViewer by default?
     * 
     *   This property specifies the default DateDisplayFormat to apply to Date values
     *   displayed in this grid for all fields except those of DetailViewerField.type
     *   (See also DetailViewer.timeFormatter).
     *   If DetailViewer.datetimeFormatter is specified, that will be applied by default
     *   to fields of type "datetime".
     * 
     *   Note that if DetailViewerField.dateFormatter or DetailViewerField.timeFormatter are
     *   specified those properties will take precedence over the component level settings.
     * 
     *   If unset, date values will be formatted according to the system wide
     *   DateUtil.setNormalDisplayFormat.
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
     *  Display format to use for fields specified as type 'datetime'. Default is to use the
     *   system-wide default long ("normal") date time format, configured via
     *   DateUtil.setNormalDatetimeDisplayFormat. Specify any
     *   valid DateDisplayFormat to change the display format for datetimes used by this
     *   viewer.
     * 
     *   May be specified as a function. If specified as a function, this function will
     *   be executed in the scope of the Date
     *   and should return the formatted string.
     * 
     * 
     *   May also be specified at the field level via
     *   DetailViewerField.dateFormatter
     *  @type {DateDisplayFormat}
     *  @default null
     */
    open var datetimeFormatter: 
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
     *  Display format to use for fields specified as type 'time'. May also be specified at
     *   the field level via DetailViewerField.timeFormatter.
     *   If unset, time fields will be formatted based on the system wide
     *   Time.setNormalDisplayFormat
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
     *  Property name on a record that will hold the link text for that record.
     * 
     *   This property is configurable to avoid possible collision with data values in the
     *   record.
     * 
     *   Use DetailViewerField.linkTextProperty if you have more than one link field and
     *   the fields' records do not use the same property to store the linkText.
     *  @type {string}
     *  @default "linkText"
     */
    open var linkTextProperty: String = definedExternally
    /**
     *  Show DetailViewer.emptyMessage when there is no data to display?
     *  @type {boolean}
     *  @default true
     */
    open var showEmptyMessage: Boolean = definedExternally
    /**
     *  The string to display in the body of a detailViewer with no records.
     *  @type {HTMLString}
     *  @default "No items to display."
     */
    open var emptyMessage: String = definedExternally
    /**
     *  CSS style to display this message in
     *  @type {CSSStyleName}
     *  @default "normal"
     */
    open var emptyMessageStyle: String = definedExternally
    /**
     *  The string to display in the body of a detailViewer which is loading records.
     *   Use "&#36;{loadingImage}" to include Canvas.loadingImageSrc.
     *  @type {HTMLString}
     *  @default "&amp;nbsp;${loadingImage}"
     */
    open var loadingMessage: String = definedExternally
    /**
     *  CSS style to use for the DetailViewer.loadingMessage.
     *  @type {CSSStyleName}
     *  @default "normal"
     */
    open var loadingMessageStyle: String = definedExternally
    /**
     *  Whether to show fields marked detail:true when a DataBoundComponent is
     *   given a DataSource but no component.fields.
     * 
     *   The detail property is used on DataSource fields to mark fields that
     *   shouldn't appear by default in a view that tries to show many records in a small space.
     *  @type {boolean}
     *  @default true
     */
    override var showDetailFields: Boolean = definedExternally
    /**
     *  Instance of FieldPickerWindow used if DetailViewer.canPickFields is set.
     *  @type {FieldPickerWindow}
     *  @default null
     */
    open var fieldPickerWindow: FieldPickerWindow = definedExternally
    /**
     *  If set, right-clicking on the DetailViewer will show a context menu that offers to bring up a
     *   FieldPicker for configuring which fields are displayed and their order.
     *  @type {boolean}
     *  @default false
     */
    open var canPickFields: Boolean = definedExternally
    /**
     *  The title for the Configure Fields menu item.
     *  @type {string}
     *  @default "Configure Fields..."
     */
    open var configureFieldsText: String = definedExternally
    /**
     *  Names of properties on DetailViewerField for which the FieldPicker should
     *   show an editing interface, for convenience.
     * 
     *   For example, specify ["decimalPad", "decimalPrecision"] to allow end users to modify
     *   DetailViewerField.decimalPad and DetailViewerField.decimalPrecision respectively.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var fieldPickerFieldProperties: Array<dynamic> = definedExternally
    /**
     *  Before we start editing values in this DataBoundComponent, should we perform a deep clone
     *   of the underlying values. See DataSource.deepCloneOnEdit for details of what this means.
     * 
     *   If this value is not explicitly set, it defaults to the value of DataSource.deepCloneOnEdit.
     *   This value can be overridden per-field with DataSourceField.deepCloneOnEdit.
     * 
     *   Like the other deepCloneOnEdit settings, this flag only has an effect if you are
     *   editing a values object that contains nested objects or arrays, using
     *   Canvas.dataPaths.
     *  @type {boolean}
     *  @default null
     */
    override var deepCloneOnEdit: Boolean = definedExternally
    /**
     *  When editing values in this DataBoundComponent, should we perform a deep clone of values
     *   that are not associated with a field (ie, attributes on the record that do not map to a
     *   component field either directly by name, or by FormItem.dataPath. If this value is
     *   not explicitly set, it defaults to the value of
     *   DataSource.deepCloneNonFieldValuesOnEdit if there is a dataSource, or to the value
     *   of the static DataSource.deepCloneNonFieldValuesOnEdit if there is no
     *   dataSource.
     * 
     *   Like the other deepCloneOnEdit settings, this flag only has an effect if you are
     *   editing a values object that contains nested objects or arrays.
     *  @type {boolean}
     *  @default null
     */
    override var deepCloneNonFieldValuesOnEdit: Boolean = definedExternally
    /**
     *  When using DataBoundComponent.dataFetchMode, how many records to fetch at a time. If set to
     *   a positive integer, dataPageSize will override the default
     *   ResultSet.resultSize for ResultSets automatically created when you call
     *   method:DataBoundComponent.fetchData (and similarly for the ResultTree.resultSize of
     *   ResultTrees). Leaving dataPageSize at its default means to just use the default page
     *   size of the data container.
     * 
     *   Note that regardless of the dataPageSize setting, a component will always fetch
     *   all of data that it needs to draw. Settings such as
     *   ListGrid.showAllRecords,
     *   ListGrid.drawAllMaxCells and
     *   ListGrid.drawAheadRatio can cause more rows than the configured
     *   dataPageSize to be fetched.
     *  @type {Integer}
     *  @default null
     */
    override var dataPageSize: Number = definedExternally
    /**
     *  Delay in milliseconds before fetching data.
     * 
     *   This setting only applies to the ResultSet automatically created by calling
     *   ListGrid.fetchData. If a pre-existing ResultSet is passed to setData() instead, it's
     *   existing setting for ResultSet.fetchDelay applies.
     *  @type {Integer}
     *  @default null
     */
    override var dataFetchDelay: Number = definedExternally
    /**
     *  If true, the set of fields given by the "default binding" (see
     *   DataBoundComponent.fields) is used, with any fields specified in
     *   component.fields acting as overrides that can suppress or modify the
     *   display of individual fields, without having to list the entire set of fields that
     *   should be shown.
     * 
     *   If component.fields contains fields that are not found in the DataSource,
     *   they will be shown after the most recently referred to DataSource field. If the new
     *   fields appear first, they will be shown first.
     * 
     *   ${isc.DocUtils.linkForExampleId('validationFieldBinding', 'This example')} shows a mixture of component
     *   fields and DataSource fields, and how they interact for validation.
     * 
     *   This setting may be cleared if a FieldPicker is used to edit the component's field
     *   order.
     *  @type {boolean}
     *  @default false
     */
    override var useAllDataSourceFields: Boolean = definedExternally
    /**
     *  Whether to show fields marked hidden:true when a DataBoundComponent is given a
     *   DataSource but no component.fields.
     * 
     *   The hidden property is used on DataSource fields to mark fields that are
     *   never of meaning to an end user.
     *  @type {boolean}
     *  @default false
     */
    override var showHiddenFields: Boolean = definedExternally
    /**
     *  Whether to show fields of non-atomic types when a DataBoundComponent is given a
     *   DataSource but no component.fields.
     * 
     *   If true, the component will show fields that declare a complex type, for example, a
     *   field 'shippingAddress' that declares type 'Address', where 'Address' is the ID of a
     *   DataSource that declares the fields of a shipping address (city, street name, etc).
     * 
     *   Such fields may need custom formatters or editors in order to create a usable interface,
     *   for example, an Address field in a ListGrid might use a custom formatter to combine the
     *   relevant fields of an address into one column, and might use a pop-up dialog for
     *   editing.
     *  @type {boolean}
     *  @default true
     */
    override var showComplexFields: Boolean = definedExternally
    /**
     *  DSRequest.operationId this component should use when performing fetch operations.
     *  @type {string}
     *  @default null
     */
    override var fetchOperation: String = definedExternally
    /**
     *  DSRequest.operationId this component should use when performing update operations.
     *  @type {string}
     *  @default null
     */
    override var updateOperation: String = definedExternally
    /**
     *  DSRequest.operationId this component should use when performing add operations.
     *  @type {string}
     *  @default null
     */
    override var addOperation: String = definedExternally
    /**
     *  DSRequest.operationId this component should use when performing remove operations.
     *  @type {string}
     *  @default null
     */
    override var removeOperation: String = definedExternally
    /**
     *  The list of field-names to export. If provided, the field-list in the exported output is
     *   limited and sorted as per the list.
     * 
     *   If exportFields is not provided, the exported output includes all visible fields
     *   from this component, sorted as they appear.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    override var exportFields: Array<dynamic> = definedExternally
    /**
     *  Setting exportAll to true prevents the component from passing it's list of fields to the
     *   export call. The result is the export of all visible fields from DataSource.fields.
     * 
     *   If exportAll is false, an export operation will first consider
     *   DataBoundComponent.exportFields, if it's set, and fall back on all visible fields from
     *   DataSource.fields otherwise.
     *  @type {boolean}
     *  @default false
     */
    override var exportAll: Boolean = definedExternally
    /**
     *  If Summary rows exist for this component, whether to include them when exporting client data.
     *  @type {boolean}
     *  @default true
     */
    override var exportIncludeSummaries: Boolean = definedExternally
    /**
     *  Flag controlling when to recategorize records being dropped on a databound
     *   component from another databound component.
     *  @type {RecategorizeMode}
     *  @default "checked"
     */
    override var dragRecategorize: 
                                   /**
                                    *  recategorize is always applied
                                    *  recategorize if normal checks pass
                                    *  never recategorize
                                    */
                                   String /* always |  checked |  never */ = definedExternally
    /**
     *  If set, detect and prevent duplicate records from being transferred to this component, either via
     *   drag and drop or via DataBoundComponent.transferSelectedData. When a duplicate transfer is detected,
     *   a dialog will appear showing the DataBoundComponent.duplicateDragMessage.
     * 
     *   If the component either does not have a DataSource or has a DataSource with no
     *   DataSourceField.primaryKey declared, duplicate checking is off by
     *   default. If duplicate checking is enabled, it looks for an existing record in the dataset
     *   that has all of the properties of the dragged record, and considers that a duplicate.
     * 
     *   For DragDataAction:"copy" where the target DataSource is related to the source
     *   DataSource by foreignKey, a duplicate means that the target list, as filtered by the current
     *   criteria, already has a record whose value for the foreignKey field matches the
     *   primaryKey of the record being transferred.
     * 
     *   For example, consider dragging "employees" to "teams", where "teams" has a field
     *   "teams.employeeId" which is a foreignKey pointing to "employees.id", and the target
     *   grid has search criteria causing it to show all the members of one team. A duplicate -
     *   adding an employee to the same team twice - is when the target grid's dataset contains an
     *   record with "employeeId" matching the "id" field of the dropped employee.
     *  @type {boolean}
     *  @default null
     */
    override var preventDuplicates: Boolean = definedExternally
    /**
     *  Message to show when a user attempts to transfer duplicate records into this component, and
     *   DataBoundComponent.preventDuplicates is enabled.
     * 
     *   If set to null, duplicates will not be reported and the dragged duplicates will not be
     *   saved.
     *  @type {string}
     *  @default "Duplicates not allowed"
     */
    override var duplicateDragMessage: String = definedExternally
    /**
     *  Indicates whether the text of the offlineMessage property should be displayed if no data is
     *   available because we do not have a suitable offline cache
     *  @type {boolean}
     *  @default true
     */
    override var showOfflineMessage: Boolean = definedExternally
    /**
     *  Message to display when this DataBoundComponent attempts to load data that is not available
     *   because the browser is currently offline. Depending on the component, the message is either
     *   displayed in the component's body, or in a pop-up warning dialog.
     *  @type {string}
     *  @default "This data not available while offline"
     */
    override var offlineMessage: String = definedExternally
    /**
     *  Message to display when this DataBoundComponent attempts to save data while the application
     *   is offline.
     *  @type {string}
     *  @default "Data cannot be saved because you are not online"
     */
    override var offlineSaveMessage: String = definedExternally
    /**
     *  Indicates whether to add "drop values" to items dropped on this component, if both
     *       the source and target widgets are databound, either to the same DataSource or
     *       to different DataSources that are related via a foreign key. "Drop values" are
     *       properties of the dropped item that you wish to change (and persist) as a
     *       result of the item being dropped on this grid.
     * 
     *       If this value is true and this component is databound, DataBoundComponent.getDropValues will
     *       be called for every databound item dropped on this grid, and an update performed
     *       on the item
     *  @type {boolean}
     *  @default true
     */
    override var addDropValues: Boolean = definedExternally
    /**
     *  When an item is dropped on this component, and DataBoundComponent.addDropValues is true and both
     *       the source and target widgets are databound, either to the same DataSource or
     *       to different DataSources that are related via a foreign key, this object
     *       provides the "drop values" that SmartClient will apply to the dropped object
     *       before updating it.
     * 
     *       If this property is not defined, SmartClient defaults to returning the selection
     *       criteria currently in place for this component. Thus, any databound items (for example,
     *       rows from other grids bound to the same DataSource) dropped on the grid will,
     *       by default, be subjected to an update that makes them conform to the grid's
     *       current filter criteria.
     *  @type {object}
     *  @default null
     */
    override var dropValues: dynamic = definedExternally
    /**
     *  Does this component represent singular or multiple "records" objects?
     *   Options are "multiple" or "single", or "either"
     *  @type {string}
     *  @default "multiple"
     */
    override var dataArity: String = definedExternally
    /**
     *  Indicates whether or not this component will load its data
     *   DataSource.progressiveLoading.
     *  @type {boolean}
     *  @default null
     */
    override var progressiveLoading: Boolean = definedExternally
    /**
     *  If this component is bound to a dataSource, this attribute may be specified to customize
     *   what fields from the dataSource may be edited by default. For example the SearchForm
     *   class has this attribute set to "canFilter" which allows search forms to edit
     *   dataSource fields marked as canEdit:false (but not those marked as
     *   canFilter:false).
     * 
     *   Note that if canEdit is explicitly specified on a field in
     *   the DataBoundComponent.fields array, that property will be respected in preference to
     *   the canEditAttribute value. (See FormItem.canEdit, ListGridField.canEdit).
     *   Also note that individual dataBoundComponents may have additional logic around whether a field
     *   can be edited - for example ListGrid.canEditCell may be overridden.
     *  @type {Identifier}
     *  @default "canEdit"
     */
    override var canEditFieldAttribute: String = definedExternally
    /**
     *  The useFlatFields flag causes all simple type fields anywhere in a nested
     *   set of DataSources to be exposed as a flat list for form binding.
     * 
     *   useFlatFields is typically used with imported metadata, such as
     *   XMLTools.loadXMLSchema from a
     *   XMLTools.loadWSDL, as a means of eliminating levels of XML
     *   nesting that aren't meaningful in a user interface, without the cumbersome and fragile
     *   process of mapping form fields to XML structures.
     * 
     *   For example, having called WebService.getInputDS to retrieve the input message
     *   schema for a web service operation whose input message looks like this:
     * 
     *   &lt;FindServices&gt;
     *     &lt;searchFor&gt;search text&lt;/searchFor&gt;
     *     &lt;Options&gt;
     *       &lt;caseSensitive&gt;false&lt;/caseSensitive&gt;
     *     &lt;/Options&gt;
     *     &lt;IncludeInSearch&gt;
     *       &lt;serviceName&gt;true&lt;/serviceName&gt;
     *       &lt;documentation&gt;true&lt;/documentation&gt;
     *       &lt;keywords&gt;true&lt;/keywords&gt;
     *     &lt;/IncludeInSearch&gt;
     *   &lt;/FindServices&gt;
     * 
     *   Setting useFlatFields on a DynamicForm that is bound to this input
     *   message schema would result in 5 FormItem reflecting the 5 simple type
     *   fields in the message.
     * 
     *   For this form, the result of DynamicForm.getValues might look
     *   like:
     * 
     *   {
     *    searchFor: "search text",
     *    caseSensitive: false,
     *    serviceName: true,
     *    documentation : true,
     *    keywords : true
     *   }
     *   When contacting a WebService, these values can be automatically
     *   mapped to the structure of the input message for a web service operation by setting
     *   WSRequest.useFlatFields (for use with WebService.callOperation) or by setting
     *   DSRequest.useFlatFields (for use with a DataSource that is
     *   wsdlBinding via
     *   OperationBinding.wsOperation).
     * 
     *   Using these two facilities in conjunction (component.useFlatFields and
     *   request.useFlatFields) allows gratuitous nesting to be consistently bypassed in both the user
     *   presentation and when providing the data for XML messages.
     * 
     *   You can also set OperationBinding.useFlatFields to automatically enable
     *   "flattened" XML serialization (request.useFlatFields) for all DataSource requests of a
     *   particular operationType.
     * 
     *   Note that useFlatFields is not generally recommended for use with structures
     *   where multiple simple type fields exist with the same name, however if used with such a
     *   structure, the first field to use a given name wins. "first" means the first field
     *   encountered in a depth first search. "wins" means only the first field will be present as a
     *   field when data binding.
     *  @type {boolean}
     *  @default null
     */
    override var useFlatFields: Boolean = definedExternally
    /**
     *  If this attribute is set to false, any attributes in the component's values object that do
     *   not map to a DataSourceField or FormItem will not
     *   be tracked when checking for changes. You should only set this flag to false if you know
     *   that your code does not store additional, non-field values in the component's data, or if
     *   you do store such values, but you don't care that they are not checked for changes.
     *   This flag is primarily provided to avoid performance issues in cases where developers are
     *   storing large numbers of extra attributes in component data; generally speaking, you should
     *   only consider setting it to false if you have a use case like this.
     * 
     *   Note, even with this flag set to false, these extra values will still be managed and stored
     *   by SmartClient; they just will not be checked when the component's values are inspected to
     *   see if they have changed. This may lead to methods like ListGrid.rowHasChanges
     *   returning false when you are expecting it to return true. In this case, either switch this
     *   flag back to true (or just do not set it false), or provide a field definition for the
     *   affected attribute(s).
     *  @type {boolean}
     *  @default true
     */
    override var canChangeNonFieldValues: Boolean = definedExternally
    /**
     *  Criteria that are never shown to or edited by the user and are cumulative with any criteria
     *   provided via DataBoundComponent.initialCriteria, method:DataBoundComponent.setCriteria
     *   etc.
     *  @type {Criteria}
     *  @default null
     */
    override var implicitCriteria: dynamic = definedExternally
    /**
     *  Adds an item to the header context menu allowing users to launch a dialog to define
     *   grid hilites using the HiliteEditor.
     * 
     *   User-added hilites can be persisted via DataBoundComponent.getHiliteState and
     *   DataBoundComponent.setHiliteState.
     *  @type {boolean}
     *  @default false
     */
    override var canEditHilites: Boolean = definedExternally
    /**
     *  Hilites to be applied to the data for this component. See hiliting.
     *  @type {Array<Partial<Hilite>>}
     *  @default null
     */
    override var hilites: Array<dynamic> = definedExternally
    /**
     *  Marker that can be set on a record to flag that record as hilited. Should be set to a value
     *   that matches Hilite.id for a hilite defined on this component.
     *  @type {string}
     *  @default "_hilite"
     */
    override var hiliteProperty: String = definedExternally
    /**
     *  Initial hilite state for the grid.
     * 
     *   ListGrid.viewState can be used to initialize all view properties of the grid.
     *   When doing so, hiliteState is not needed because viewState
     *   includes it as well. If both are provided, hiliteState has priority for
     *   hilite state.
     * 
     * 
     *   To retrieve current state call DataBoundComponent.getHiliteState.
     * 
     *  @type {string}
     *  @default null
     */
    override var hiliteState: String = definedExternally
    /**
     *  The strategy to use when generating names for new fields in this component. The default
     *   strategy, "simple", combines the field-type with an index maintained by field-type and
     *   component instance. For example, "formulaField1".
     *  @type {FieldNamingStrategy}
     *  @default "simple"
     */
    override var fieldNamingStrategy: 
                                      /**
                                       *  generate names in the format fieldTypeX, where field type might be     "formulaField" and X is an index specific to the field-type and component instance
                                       *  generates a UUID for all generated field names
                                       */
                                      String /* simple |  uuid */ = definedExternally
    /**
     *  Text for a menu item allowing users to edit grid highlights.
     *  @type {string}
     *  @default "Edit Highlights..."
     */
    override var editHilitesText: String = definedExternally
    /**
     *  The title for the DataBoundComponent.editHilites dialog.
     *  @type {string}
     *  @default "Edit Highlights"
     */
    override var editHilitesDialogTitle: String = definedExternally
    /**
     *  The title for the DataBoundComponent.fieldEditorWindow used to edit calculated
     *   fields.
     * 
     *   This is a dynamic string - text within &#36;{...} are dynamic variables and will
     *   be evaluated as JS code whenever the message is displayed.
     * 
     *   Two dynamic variables are available - "builderType", either Formula or Summary, and
     *   "fieldTitle", which is the title of the calculated field being edited.
     *  @type {HTMLString}
     *  @default "${builderType} Editor [${fieldTitle}]"
     */
    override var fieldEditorWindowTitle: String = definedExternally
    /**
     *  The Window used to edit calculated fields for this component.
     *  @type {Window}
     *  @default null
     */
    override var fieldEditorWindow: Window = definedExternally
    /**
     *  This component's HiliteEditor instance used to allow the user to create, modify, or delete
     *   hilites.
     * 
     *   The following autoChildUsage apply:
     * 
     * 
     *  - DataBoundComponent.hiliteIcons for HiliteEditor.hiliteIcons
     * 
     *  @type {HiliteEditor}
     *  @default null
     */
    override var hiliteEditor: HiliteEditor = definedExternally
    /**
     *  Indicates what to do with data dragged into another DataBoundComponent. See
     *   DragDataAction type for details.
     *  @type {DragDataAction}
     *  @default "move"
     */
    override var dragDataAction: 
                                 /**
                                  *  Don't do anything, resulting in the same data being in both lists.
                                  *  Copy the data leaving the original in our list.
                                  *  Remove the data from this list so it can be moved into the other list.
                                  */
                                 String /* none |  copy |  move */ = definedExternally
    /**
     *  CSS Style to apply to the drag tracker when dragging occurs on this component.
     *  @type {CSSStyleName}
     *  @default "gridDragTracker"
     */
    override var dragTrackerStyle: String = definedExternally
    /**
     *  If the result of a formula evaluation is invalid (specifically, if isNaN(result)==true),
     *   badFormulaResultValue is displayed instead. The default value is ".".
     *  @type {string}
     *  @default "."
     */
    override var badFormulaResultValue: String = definedExternally
    /**
     *  If a summary format string contains an invalid field reference, replace the reference
     *   with the missingSummaryFieldValue. The default value is "-".
     *  @type {string}
     *  @default "-"
     */
    override var missingSummaryFieldValue: String = definedExternally
    /**
     *  Adds an item to the header context menu allowing users to launch a dialog to define a new
     *   field based on values present in other fields, using the FormulaBuilder.
     * 
     *   User-added formula fields can be persisted via ListGrid.getFieldState and
     *   ListGrid.setFieldState.
     *  @type {boolean}
     *  @default false
     */
    override var canAddFormulaFields: Boolean = definedExternally
    /**
     *  Text for a menu item allowing users to add a formula field
     *  @type {string}
     *  @default "Add formula column..."
     */
    override var addFormulaFieldText: String = definedExternally
    /**
     *  Text for a menu item allowing users to edit a formula field
     *  @type {string}
     *  @default "Edit formula..."
     */
    override var editFormulaFieldText: String = definedExternally
    /**
     *  Text for a menu item allowing users to remove a formula field
     *  @type {string}
     *  @default "Remove formula"
     */
    override var removeFormulaFieldText: String = definedExternally
    /**
     *  Adds an item to the header context menu allowing users to launch a dialog to define a new
     *   text field that can contain both user-defined text and the formatted values present in other
     *   fields, using the SummaryBuilder.
     * 
     *   User-added summary fields can be persisted via ListGrid.getFieldState and
     *   ListGrid.setFieldState.
     *  @type {boolean}
     *  @default false
     */
    override var canAddSummaryFields: Boolean = definedExternally
    /**
     *  Text for a menu item allowing users to add a formula field
     *  @type {string}
     *  @default "Add summary column..."
     */
    override var addSummaryFieldText: String = definedExternally
    /**
     *  Text for a menu item allowing users to edit the formatter for a field
     *  @type {string}
     *  @default "Edit summary format..."
     */
    override var editSummaryFieldText: String = definedExternally
    /**
     *  Text for a menu item allowing users to remove a summary field
     *  @type {string}
     *  @default "Remove summary format..."
     */
    override var removeSummaryFieldText: String = definedExternally
    /**
     *  When assembling a value for a DataBoundComponent.canAddSummaryFields, if a referenced
     *   field is hilited, should the hilite HTML be included in the summary field value?
     * 
     *   To control hilites showing in group summaries, see ListGrid.showHilitesInGroupSummary.
     *  @type {boolean}
     *  @default true
     */
    override var includeHilitesInSummaryFields: Boolean = definedExternally
    /**
     *  Best field to use for a user-visible title for an individual record from this
     *   component.
     * 
     *   This attribute has the same function as DataSource.iconField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var titleField: String = definedExternally
    /**
     *  Designates a field of FieldType:"image" as the field to use when rendering a
     *   record as an image, for example, in a TileGrid.
     * 
     *   This attribute has the same function as DataSource.iconField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var iconField: String = definedExternally
    /**
     *  Name of the field that has the second most pertinent piece of textual information in the
     *   record, for use when a DataBoundComponent needs to show a short summary of a record.
     * 
     *   This attribute has the same function as DataSource.infoField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var infoField: String = definedExternally
    /**
     *  Name of the field that has the most pertinent numeric, date, or enum value, for use when a
     *   DataBoundComponent needs to show a short summary of a record.
     * 
     *   This attribute has the same function as DataSource.dataField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var dataField: String = definedExternally
    /**
     *  Name of the field that has a long description of the record, or has the primary text data
     *   value for a record that represents an email message, SMS, log or similar.
     * 
     *   This attribute has the same function as DataSource.descriptionField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var descriptionField: String = definedExternally
    /**
     *  The message to display to the user if an export of a DataBoundComponent's data is attempted
     *   while the DataBoundComponent's data is null or an empty list.
     *  @type {string}
     *  @default "You are attempting to export an empty dataset"
     */
    override var emptyExportMessage: String = definedExternally
    /**
     *  Properties to apply to the MultiSortDialog which gets automatically generated
     *   when DataBoundComponent.askForSort is called.
     * 
     *   See also ListGrid.showHeaderSpanTitlesInSortEditor and ListGrid.sortEditorSpanTitleSeparator
     *  @type {MultiSortDialog}
     *  @default null
     */
    override var multiSortDialogProperties: MultiSortDialog = definedExternally
    /**
     *  Class level defaults to apply to the MultiSortDialog which gets automatically
     *   generated when DataBoundComponent.askForSort is called.
     * 
     *   See also ListGrid.showHeaderSpanTitlesInSortEditor and ListGrid.sortEditorSpanTitleSeparator
     *  @type {MultiSortDialog}
     *  @default null
     */
    override var multiSortDialogDefaults: MultiSortDialog = definedExternally
    /**
     *  For databound components that support editing, the error message for a failed validator
     *   that does not specify its own errorMessage.
     *  @type {HTMLString}
     *  @default "Invalid value"
     */
    override var unknownErrorMessage: String = definedExternally
    /**
     *  A message to display to the user if server-side validation fails with an error but the
     *   server did not provide an error message
     *  @type {string}
     *  @default "Error during validation; no error details were provided"
     */
    override var noErrorDetailsMessage: String = definedExternally
    /**
     *   Sends the current filter criteria and sort direction to the server, then exports data in the
     *   requested DSRequest.exportAs.
     * 
     *   A variety of DSRequest settings, such as
     *   DSRequest.exportAs and DSRequest.exportFilename, affect the
     *   exporting process: see DSRequest.exportResults for further detail.
     * 
     *   Note that data exported via this method does not include any client-side formatting and
     *   relies on both the SmartClient server and server-side DataSources. To export client-data
     *   with formatters applied,
     *   see ListGrid.exportClientData, which still requires the
     *   SmartClient server but does not rely on server-side DataSource definitions (.ds.xml files).
     * 
     *   For more information on exporting data, see DataSource.exportData.
     * 
     * 
     *  @param {DSRequest=} additional properties to set on the DSRequest                      that will be issued
     *  @param {DSCallback=} callback to invoke on completion. Note that this parameter                 only applies where DSRequest.exportToClient is                  explicitly set to false, because file downloads do not                  provide ordinary SmartClient callbacks
     */
    override fun exportData(requestProperties: DSRequest?, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?)): Unit = definedExternally
    /**
     *   Exports this component's data with client-side formatters applied, so is suitable for direct
     *   display to users. See ListGrid.exportClientData for details of the general
     *   requirements and restrictions when exporting client data.
     * 
     *   The following notes apply when exporting client data from DetailViewers:
     * 
     *  - Data is exported in "grid" format, with each record shown in a single row and each
     *     column representing a single field. This is quite different from the way DetailViewers
     *     display records in the browser
     * 
     * 
     *   If your detailViewer has custom formatters, formatted values will be exported by default, with
     *   HTML normalized to text where possible. Since some levels of HTML normalizing aren't
     *   possible, this may result in missing or incorrect export values. In this case, you have
     *   two possible approaches:
     * 
     *  - Set DetailViewerField.exportRawValues on the field. This will export
     *     the raw underlying value of the field; your formatter will not be called
     * 
     *  - Have your formatter call DetailViewer.isExportingClientData
     *     and perform whatever alternative formatting you require if that method returns true
     * 
     * 
     *  @param {DSRequest=} Request properties for the export. Note that specifying DSRequest.exportData on the request properties  allows the developer to pass in an explicit data set to export.
     *  @param {RPCCallback=} Optional callback. If you specify DSRequest.exportToClient: false in the request  properties, this callback will fire after export completes. Otherwise the callback will  fire right before the download request is made to the server.
     */
    open fun exportClientData(requestProperties: DSRequest?, callback: ((response: RPCResponse, rawData: dynamic, request: RPCRequest) -> Unit?)): Unit = definedExternally
    /**
     *   Returns true if this component is currently
     *   DetailViewer.exportClientData. This method can be called from
     *   custom cell formatters if you need to return a different formatted value for an export
     *   than for a live detailViewer
     * 
     */
    open fun isExportingClientData(): Boolean = definedExternally
    /**
     * 
     *   Displays the currently selected record(s) of the selectionComponent widget (typically a
     *   listGrid) in the detailViewer.
     * 
     * 
     *  @param {ListGrid | GlobalId} the ListGrid or ID of a ListGrid whose currently selected   record(s) is/are to be edited
     */
    open fun viewSelectedData(selectionComponent: dynamic): Unit = definedExternally
    /**
     *   Sets the data displayed by this detail viewer.
     * 
     * 
     *  @param {Array<Partial<DetailViewerRecord>> | Array<Partial<Record>> | any} new data to be displayed
     */
    open fun setData(newData: dynamic): Unit = definedExternally
    /**
     *   Based on the relationship between the DataSource this component is bound to and the
     *   DataSource specified as the "schema" argument, call fetchData() to retrieve records in this
     *   data set that are related to the passed-in record.
     * 
     *   Relationships between DataSources are declared via DataSourceField.foreignKey.
     * 
     *   For example, given two related DataSources "orders" and "orderItems", where we want to fetch
     *   the "orderItems" that belong to a given "order". "orderItems" should declare a field that
     *   is a DataSourceField.foreignKey to the "orders" table (for example, it
     *   might be named "orderId" with foreignKey="orders.id"). Then, to load the records related to
     *   a given "order", call fetchRelatedData() on the component bound to "orderItems", pass the
     *   "orders" DataSource as the "schema" and pass a record from the "orders" DataSource as the
     *   "record" argument.
     * 
     *   Note: When you expect a large number of records to be returned it is not recommended to
     *   display these in the DetailViewer as it doesn't have the same level of support for large
     *   datasets as the ListGrid.
     * 
     * 
     *  @param {ListGridRecord} DataSource record
     *  @param {Canvas | DataSource | GlobalId} schema of the DataSource record, or              DataBoundComponent already bound to that schema
     *  @param {DSCallback=} callback to invoke on completion
     *  @param {DSRequest=} additional properties to set on the DSRequest                      that will be issued
     */
    open fun fetchRelatedData(record: ListGridRecord, schema: dynamic, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Check whether a field is currently visible
     * 
     * 
     *  @param {string | DetailViewerField} field to be checked
     */
    open fun fieldIsVisible(field: dynamic): Boolean = definedExternally
    /**
     *   Return CSS text for styling this cell, which will be applied in addition to the CSS class
     *   for the cell, as overrides.
     * 
     *   "CSS text" means semicolon-separated style settings, suitable for inclusion in a CSS
     *   stylesheet or in a STYLE attribute of an HTML element.
     * 
     * 
     *  @param {any} actual value of this cell
     *  @param {DetailViewerField} field object for this cell
     *  @param {Record} record object for this cell
     *  @param {DetailViewer} the viewer instance to which this cell belongs
     */
    open fun getCellCSSText(value: dynamic, field: DetailViewerField, record: Record, viewer: DetailViewer): String = definedExternally
    /**
     *   Return the CSS class for a cell. Default implementation calls
     *   DetailViewerField.getCellStyle on the field if defined, otherwise
     *   returns DetailViewer.cellStyle
     * 
     *  @param {any} actual value of this cell
     *  @param {DetailViewerField} field object for this cell
     *  @param {Record} record object for this cell
     *  @param {DetailViewer} the viewer instance to which this cell belongs
     */
    open fun getCellStyle(value: dynamic, field: DetailViewerField, record: Record, viewer: DetailViewer): String = definedExternally
    /**
     *   Optional method to format the value to display for cells in this DetailViewer.
     *   Note that if DetailViewerField.formatCellValue is specified this method will not
     *   be called for cells within that field.
     * 
     *  @param {string} the raw value of the cell (may be formatted by  DetailViewerField.formatCellValue
     *  @param {DetailViewerRecord} the record being displayed
     *  @param {DetailViewerField} the field being displayed
     */
    open fun formatCellValue(value: String, record: DetailViewerRecord, field: DetailViewerField): Unit = definedExternally
    /**
     *   Get the index of the provided record.
     * 
     *   Override in subclasses to provide more specific behavior, for instance, when data holds a
     *   large number of records
     * 
     * 
     *  @param {Record} the record whose index is to be retrieved
     */
    override fun getRecordIndex(record: Record): Number = definedExternally
    /**
     *   Return the message to show if the component has no data. Default implementation returns a
     *   centered DetailViewer.emptyMessage or "&amp;nbsp;" if showEmptyMessage is false. If
     *   the component has no data because the browser is offline, we instead display the
     *   DataBoundComponent.offlineMessage or "&amp;nbsp;" if showOfflineMessage is false
     * 
     */
    open fun emptyMessageHTML(): String = definedExternally
    /**
     *   Returns a snapshot of the current view state of this DetailViewer.
     *   This includes the field, sort and hilite state of the grid, returned as a
     *   DetailViewerViewState object.
     *   This object can be passed to DetailViewer.setViewState to reset this detail
     *   viewer's view state to the current state (assuming the same data / fields are present in
     *   the detail viewer).
     * 
     */
    open fun getViewState(): String = definedExternally
    /**
     *   Reset this detail viewer's view state to match the DetailViewerViewState object passed in.
     *   Used to restore previous state retrieved from the detail viewer by a call to
     *   DetailViewer.getViewState.
     * 
     * 
     *  @param {DetailViewerViewState} Object describing the desired view state for the detail viewer
     */
    open fun setViewState(viewState: String): Unit = definedExternally
    /**
     *   This method is invoked on the source component whenever a drag operation or
     *   DataBoundComponent.transferSelectedData completes. This method is called when the entire chain of
     *   operations - including, for databound components, server-side updates and subsequent
     *   integration of the changes into the client-side cache - has completed.
     *   There is no default implementation of this method; you are intended to override it if you
     *   are interested in being notified when drag operations complete.
     * 
     * 
     */
    override fun dragComplete(): Unit = definedExternally
    /**
     *   This method is invoked whenever a drop operation or DataBoundComponent.transferSelectedData
     *   targeting this component completes. A drop is considered to be complete when all the client-
     *   side transfer operations have finished. This includes any server turnarounds SmartClient
     *   needs to make to check for duplicate records in the target component; it specifically does
     *   not include any add or update operations sent to the server for databound components. If
     *   you want to be notified when the entire drag operation - including server updates and cache
     *   synchronization - has completed, override DataBoundComponent.dragComplete
     *   on the source component.
     *   There is no default implementation of this method; you are intended to override it if you
     *   are interested in being notified when drop operations complete.
     * 
     * 
     *  @param {Array<Partial<Record>>} The list of records actually transferred to          this component (note that this is not necessarily the same thing as the           list of records dragged out of the source component because it doesn't           include records that were excluded because of collisions with existing           records)
     */
    override fun dropComplete(transferredRecords: Array<dynamic>): Unit = definedExternally
    /**
     *   For a component with a specified DataSource, find the associated dataSource field object
     *   from a specified DataPath.
     * 
     *  @param {DataPath} dataPath for which the field definition should be returned.
     */
    override fun getDataPathField(dataPath: String): Unit = definedExternally
    /**
     *   Can the field be edited? This base method always returns false, but it's
     *   overridden by subclasses such as DynamicForm and ListGrid.
     * 
     * 
     *  @param {object | number | string} field object or identifier
     */
    override fun fieldIsEditable(field: dynamic): Boolean = definedExternally
    /**
     *   Return a field by a field index or field name.
     * 
     * 
     *  @param {FieldName | number} field index or field.name
     */
    override fun getField(fieldID: dynamic): dynamic = definedExternally
    /**
     *   Find the index of a currently visible field.
     * 
     * 
     *  @param {FieldName | string} field name or field
     */
    override fun getFieldNum(fieldName: String): Number = definedExternally
    /**
     *   This API is equivalent to List.find but searches for a matching record among already-loaded data only.
     *   Use ListGrid.fetchData to load data from the server.
     * 
     *  @param {AdvancedCriteria} AdvancedCriteria to use with
     */
    override fun find(advancedCriteria: AdvancedCriteria): dynamic = definedExternally
    /**
     *   This API is equivalent to List.findAll but searches for a matching record among already-loaded data only.
     *   Use ListGrid.fetchData to load data from the server.
     * 
     *  @param {AdvancedCriteria} AdvancedCriteria to use with
     */
    override fun findAll(advancedCriteria: AdvancedCriteria): Array<dynamic> = definedExternally
    /**
     *   This API is equivalent to List.findIndex but searches for a matching record among already-loaded data only.
     *   Use ListGrid.fetchData to load data from the server.
     * 
     *  @param {AdvancedCriteria} AdvancedCriteria to use with
     */
    override fun findIndex(advancedCriteria: AdvancedCriteria): Number = definedExternally
    /**
     *   This API is equivalent to List.findNextIndex but searches for a matching record among already-loaded data only.
     *   Use ListGrid.fetchData to load data from the server.
     * 
     *  @param {Integer} first index to consider
     *  @param {AdvancedCriteria} AdvancedCriteria to use with
     *  @param {Integer=} last index to consider
     */
    override fun findNextIndex(startIndex: Number, advancedCriteria: AdvancedCriteria, endIndex: Number?): Number = definedExternally
    /**
     *   Bind to a new DataSource.
     * 
     *   Like passing the "dataSource" property on creation, binding to a DataSource means that the
     *   component will use the DataSource to provide default data for its fields.
     * 
     *   When binding to a new DataSource, if the component has any existing "fields" or has a dataset,
     *   these will be discarded by default, since it is assumed the new DataSource may represent a
     *   completely unrelated set of objects. If the old "fields" are still relevant, pass them to
     *   setDataSource().
     * 
     * 
     *  @param {GlobalId | DataSource} DataSource to bind to
     *  @param {Array<Partial<DataSourceField>>=} optional array of fields to use
     */
    override fun setDataSource(dataSource: dynamic, fields: Array<dynamic>?): Unit = definedExternally
    /**
     *   Returns an array of Alignment for this grid
     * 
     */
    override fun getFieldAlignments(): Array<dynamic> = definedExternally
    /**
     *   Compares the specified criteria with the current criteria applied to this component's
     *   data object and determines whether the new criteria could be satisfied from the currently
     *   cached set of data, or if a new filter/fetch operation will be required.
     * 
     *   This is equivalent to calling this.data.willFetchData(...).
     *   Always returns true if this component is not showing a set of data from the dataSource.
     * 
     *   Note that to predict correctly the decision that will be made by filter/fetch, you'll need to
     *   pass the same TextMatchStyle that will be used by the future filter/fetch. Fetching
     *   manually (e.g. ListGrid.fetchData) will by default use "exact" while filtering
     *   (e.g. ListGrid.filterData) will by default use "substring". If the component
     *   is configured for autofetch (i.e. ListGrid.autoFetchData: true), that will
     *   use ListGrid.autoFetchTextMatchStyle, which defaults to "substring". If nothing/null
     *   is passed for the style, this method assumes you want the style from the last filter/fetch.
     * 
     *   To determine what TextMatchStyle is being used, check the RPC Tab of the
     *   debugging and check the relevant DSRequest.
     * 
     * 
     *  @param {Criteria} new criteria to test.
     *  @param {TextMatchStyle=} New text match style. If not passed assumes    textMatchStyle will not be modified.
     */
    override fun willFetchData(newCriteria: dynamic, textMatchStyle: 
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
                                                                     String /* exact |  exactCase |  substring |  startsWith */?): Boolean = definedExternally
    /**
     *   Attempt to find the record in the resultSet that has a primary key value that matches the
     *   passed in parameter value. Only the locally cached data will be searched.
     *   Checks only loaded rows and will not trigger a fetch. Returns null if there is no match,
     *   data is not loaded, or there is no ResultSet.dataSource.
     * 
     *   Note, if you pass a simple value to this method, it will be matched against the first
     *   primaryKey field. For DataSources with a composite primary key (multiple primaryKey fields),
     *   pass
     *   a criteria object containing just your primaryKeys, like this:
     *   { firstPkField: "value", secondPkField: 25 }.
     * 
     * 
     * 
     *  @param {object} primary key value to search for
     */
    override fun findByKey(keyValue: dynamic): Record = definedExternally
    /**
     * 
     *   Select/deselect a Record passed in explicitly, or by index.
     * 
     * 
     *  @param {Record | number} record (or row number) to select
     *  @param {boolean=} new selection state (if null, defaults to true)
     */
    override fun selectRecord(record: dynamic, newState: Boolean?): Unit = definedExternally
    /**
     *   Select a single Record passed in explicitly, or by index, and deselect everything else.
     *   When programmatic selection of records is a requirement and
     *   ListGrid.selectionType is "single", use this method rather than
     *   DataBoundComponent.selectRecord to
     *   enforce mutually-exclusive record-selection.
     * 
     * 
     *  @param {Record | number} record (or row number) to select
     */
    override fun selectSingleRecord(record: dynamic): Unit = definedExternally
    /**
     * 
     *   Deselect a Record passed in explicitly, or by index.
     * 
     *   Synonym for selectRecord(record, false)
     * 
     * 
     *  @param {Record | number} record (or row number) to deselect
     */
    override fun deselectRecord(record: dynamic): Unit = definedExternally
    /**
     * 
     *   Select/deselect a list of Records passed in explicitly, or by index.
     * 
     *   Note that developers may wish to use DataBoundComponent.selectRange to select a single
     *   contiguous range.
     * 
     * 
     *  @param {Array<Partial<Record>> | number} records (or row numbers) to select
     *  @param {boolean=} new selection state (if null, defaults to true)
     */
    override fun selectRecords(records: dynamic, newState: Boolean?): Unit = definedExternally
    /**
     * 
     *   Deselect a list of Records passed in explicitly, or by index.
     * 
     *   Synonym for selectRecords(records, false)
     * 
     *   Note that developers may wish to use DataBoundComponent.deselectRange to select a single
     *   contiguous range.
     * 
     * 
     *  @param {Array<Partial<Record>> | number} records (or row numbers) to deselect
     */
    override fun deselectRecords(records: dynamic): Unit = definedExternally
    /**
     *   Select all records
     * 
     * 
     */
    override fun selectAllRecords(): Unit = definedExternally
    /**
     * 
     *   Deselect all records
     * 
     * 
     */
    override fun deselectAllRecords(): Unit = definedExternally
    /**
     *   Select a contiguous range of records by index
     * 
     *  @param {Integer} start of selection range
     *  @param {Integer} end of selection range (non-inclusive)
     *  @param {boolean=} new selection state (if null, defaults to true)
     */
    override fun selectRange(startRow: Number, endRow: Number, newState: Boolean?): Unit = definedExternally
    /**
     *   Deselect a contiguous range of records by index.
     * 
     *   This is a synonym for selectRange(startRow, endRow, false);
     * 
     *  @param {Integer} start of selection range
     *  @param {Integer} end of selection range (non-inclusive)
     */
    override fun deselectRange(startRow: Number, endRow: Number): Unit = definedExternally
    /**
     *   Whether at least one item is selected
     * 
     */
    override fun anySelected(): Boolean = definedExternally
    /**
     *   Returns the number of selected records.
     * 
     * 
     */
    override fun getSelectionLength(): Number = definedExternally
    /**
     *   Return the set of hilite-objects currently applied to this DataBoundComponent. These
     *   can be serialized for storage and then restored to a component later via
     *   DataBoundComponent.setHilites.
     * 
     * 
     */
    override fun getHilites(): Array<dynamic> = definedExternally
    /**
     *   Accepts an array of hilite objects and applies them to this DataBoundComponent. See also
     *   DataBoundComponent.getHilites for a method of retrieving the hilite
     *   array for storage, including hilites manually added by the user.
     * 
     * 
     *  @param {Array<Partial<Hilite>>} Array of hilite objects
     */
    override fun setHilites(hilites: Array<dynamic>): Unit = definedExternally
    /**
     *   Get the current hilites encoded as a String, for saving.
     * 
     * 
     */
    override fun getHiliteState(): String = definedExternally
    /**
     *   Set the current hilites based on a hiliteState String previously returned from
     *   DataBoundComponent.getHiliteState.
     * 
     *  @param {string} hilites state encoded as a String
     */
    override fun setHiliteState(hiliteState: String): Unit = definedExternally
    /**
     *   Enable / disable a DataBoundComponent.hilites
     * 
     * 
     *  @param {string} ID of hilite to enable
     *  @param {boolean=} new enabled state to apply - if null, defaults to true
     */
    override fun enableHilite(hiliteID: String, enable: Boolean?): Unit = definedExternally
    /**
     *   Disable a hilite
     * 
     * 
     *  @param {string} ID of hilite to disable
     */
    override fun disableHilite(hiliteID: String): Unit = definedExternally
    /**
     *   Enable all hilites.
     * 
     * 
     *  @param {boolean=} new enabled state to apply - if null, defaults to true
     */
    override fun enableHiliting(enable: Boolean?): Unit = definedExternally
    /**
     *   Disable all hilites.
     * 
     * 
     */
    override fun disableHiliting(): Unit = definedExternally
    /**
     *   Shows a HiliteEditor interface allowing end-users to edit
     *   the data-hilites currently in use by this DataBoundComponent.
     * 
     * 
     */
    override fun editHilites(): Unit = definedExternally
    /**
     * 
     *   Transfer a list of Records from another component (does not have to be a databound
     *   component) into this component. This method is only applicable to list-type components,
     *   such as ListGrid, TreeGrid or TileGrid
     * 
     *   This method implements the automatic drag-copy and drag-move behaviors of components like
     *   ListGrid, and calling it is equivalent to completing a drag and drop of the
     *   dropRecords.
     * 
     *   Note that this method is asynchronous - it may need to perform server turnarounds to prevent
     *   duplicates in the target component's data. If you wish to be notified when the transfer
     *   process has completed, you can either pass the optional callback to this method or implement
     *   the DataBoundComponent.dropComplete method on this component.
     * 
     *   See also DataBoundComponent.transferSelectedData.
     * 
     * 
     *  @param {Array<Partial<Record>>} Records to transfer to this component
     *  @param {Record} The target record (eg, of a drop interaction), for context
     *  @param {Integer} Insert point in this component's data for the transferred records
     *  @param {Canvas} The databound or non-databound component from which the records              are to be transferred.
     *  @param {Callback=} optional callback to be fired when the transfer process has completed
     */
    override fun transferRecords(dropRecords: Array<dynamic>, targetRecord: Record, index: Number, sourceWidget: Canvas, callback: dynamic?): Unit = definedExternally
    /**
     *   Returns the "drop values" to apply to a record dropped on this component prior to update. Only
     *   applicable to databound components - see DataBoundComponent.dropValues for more details. If multiple records
     *   are being dropped, this method is called for each of them in turn.
     * 
     *   The default implementation of this method returns the following:
     * 
     * 
     *  - Nothing, if DataBoundComponent.addDropValues is false
     * 
     *  - dropValues, if that property is set. If the component's criteria object is applicable (as explained
     *   in the next item), it is merged into dropValues, with properties in dropValues taking precedence.
     * 
     *  - The component's criteria object, if the most recent textMatchStyle for the component was "exact"
     *     and it is simple criteria (ie, not an AdvancedCriteria object)
     * 
     *  - Otherwise nothing
     * 
     * 
     *   You can override this method if you need more complex setting of drop values than can be
     *   provided by simply supplying a dropValues object.
     * 
     * 
     *  @param {Record} record being dropped
     *  @param {DataSource} dataSource the record being dropped is bound to
     *  @param {Record} record being dropped on
     *  @param {Integer} index of record being dropped on
     *  @param {Canvas} widget where dragging began
     */
    override fun getDropValues(record: Record, sourceDS: DataSource, targetRecord: Record, index: Number, sourceWidget: Canvas): dynamic = definedExternally
    /**
     * 
     *   During a drag-and-drop interaction, this method is called to transfer a set of records that
     *   were dropped onto some other component. This method is called after the set of records has
     *   been copied to the other component. Whether or not this component's data is modified is
     *   determined by the value of DataBoundComponent.dragDataAction.
     * 
     *   With a dragDataAction of "move", a databound component will issue "remove"
     *   dsRequests against its DataSource to actually remove the data, via
     *   DataSource.removeData.
     * 
     * 
     */
    override fun transferDragData(): Array<dynamic> = definedExternally
    /**
     * 
     *   During a drag-and-drop interaction, this method returns the set of records being dragged out
     *   of the component. In the default implementation, this is the list of currently selected
     *   records.
     * 
     *   This method is consulted by ListGrid.willAcceptDrop.
     * 
     * 
     *  @param {DataBoundComponent} source component from which the records will be transferred
     */
    override fun getDragData(source: DataBoundComponent): Array<dynamic> = definedExternally
    /**
     *   Simulates a drag / drop type transfer of the selected records in some other component to this
     *   component, without requiring any user interaction. This method acts on the dropped records
     *   exactly as if they had been dropped in an actual drag / drop interaction, including any
     *   special databound behavior invoked by calling
     *   DataBoundComponent.getDropValues for each dropped record.
     * 
     *   To transfer all data in, for example, a ListGrid, call
     *   ListGrid.selectAllRecords first.
     * 
     *   Note that drag/drop type transfers of records between components are asynchronous operations:
     *   SmartClient may need to perform server turnarounds to establish whether dropped records
     *   already exist in the target component. Therefore, it is possible to issue a call to
     *   transferSelectedData() and/or the drop() method of a databound
     *   component whilst a transfer is still active. When this happens, SmartClient adds the
     *   second and subsequent transfer requests to a queue and runs them one after the other. If
     *   you want to be notified when a transfer process has actually completed, either provide a
     *   callback to this method or implement DataBoundComponent.dropComplete.
     * 
     *   See the dragging documentation for an overview of list grid drag/drop data
     *   transfer.
     * 
     * 
     *  @param {DataBoundComponent} source component from which the records will be transferred
     *  @param {Integer=} target index (drop position) of the rows within this grid.
     *  @param {Callback=} optional callback to be fired when the transfer process has            completed. The callback will be passed a single parameter "records",            the list of records actually transferred to this component.
     */
    override fun transferSelectedData(source: DataBoundComponent, index: Number?, callback: dynamic?): Unit = definedExternally
    /**
     *   Sets the custom tracker HTML to display next to the mouse when the user initiates a drag
     *   operation on this component. Default implementation will examine ListGrid.dragTrackerMode
     *   and set the custom drag tracker to display the appropriate HTML based on the selected record.
     * 
     *   To display custom drag tracker HTML, this method may be overridden - call
     *   EventHandler.setDragTracker to actually update the drag tracker HTML.
     * 
     */
    override fun setDragTracker(): Boolean = definedExternally
    /**
     *   Convenience method to display a FormulaBuilder to create a new Formula Field. This
     *   is equivalent to calling DataBoundComponent.editFormulaField with
     *   no parameter.
     * 
     * 
     */
    override fun addFormulaField(): Unit = definedExternally
    /**
     *   Method to display a FormulaBuilder to edit a formula Field. If the function is called
     *   without a parameter, a new field will be created when the formula is saved.
     * 
     * 
     *  @param {string} Field to edit or null to add a new formula field
     */
    override fun editFormulaField(field: String): Unit = definedExternally
    /**
     *   Get the computed value of a DataBoundComponent.canAddFormulaFields.
     * 
     *  @param {string} field that has a formula
     *  @param {Record} record to use to compute formula value
     */
    override fun getFormulaFieldValue(field: ListGridField, record: Record): dynamic = definedExternally
    /**
     *   Convenience method to display a SummaryBuilder to create a new Summary Field. This
     *   is equivalent to calling DataBoundComponent.editSummaryField with
     *   no parameter.
     * 
     * 
     */
    override fun addSummaryField(): Unit = definedExternally
    /**
     *   Method to display a SummaryBuilder to edit a Summary Field. If the function is called
     *   without a parameter, a new field will be created when the summary is saved.
     * 
     * 
     *  @param {string} Field to edit or null to add a new summary column
     */
    override fun editSummaryField(field: String): Unit = definedExternally
    /**
     *   Get the computed value of a DataBoundComponent.canAddSummaryFields.
     * 
     *  @param {string} field that has a summary format
     *  @param {Record} record to use to compute formula value
     */
    override fun getSummaryFieldValue(field: ListGridField, record: Record): String = definedExternally
    /**
     *   When assembling a value for a DataBoundComponent.canAddSummaryFields, if a referenced
     *   field is hilited, should the hilite HTML be included in the summary field value?
     * 
     *   Example use case: Consider a grid containing a numeric field, and a summary field
     *   which contains some string value, plus the contents of the numeric field.
     *   If a hilite is defined for the grid which turns the numeric field text red when
     *   the value is negative, this property will govern whether the number will also be
     *   rendered in red within the summary field cells. Any other text in the summary field
     *   cells would not be effected by this hilite.
     * 
     *   Default implementation returns DataBoundComponent.includeHilitesInSummaryFields.
     * 
     *   To control hilites showing in group summaries, see ListGrid.showHilitesInGroupSummary.
     * 
     * 
     *  @param {string} name of the summary field
     *  @param {string} name of the field referenced by this summary
     */
    override fun shouldIncludeHiliteInSummaryField(summaryFieldName: String, usedFieldName: String): Boolean = definedExternally
    /**
     *   Get the value of the titleField for the passed record
     * 
     *   Override in subclasses
     * 
     * 
     *  @param {Record} the record whose index is to be retrieved
     */
    override fun getTitleFieldValue(record: Record): String = definedExternally
    /**
     *   Method to return the fieldName which represents the "title" for records in this
     *   Component.
     *   If this.titleField is explicitly specified it will always be used.
     *   Otherwise, default implementation will check DataSource.titleField for databound
     *   compounds.
     *   For non databound components returns the first defined field name of "title",
     *   "name", or "id" where the field is visible. If we don't find any
     *   field-names that match these titles, the first field in the component will be used instead.
     * 
     */
    override fun getTitleField(): String = definedExternally
    /**
     *   Return all CSS style declarations associated with the hilites of a record's field.
     * 
     *  @param {Record} \* @param {string} if set, returned CSS will be appended to this text
     *  @param {string} field object identifying whose CSS is to be returned
     */
    override fun getRecordHiliteCSSText(record: Record, cssText: String, field: String): String = definedExternally
    /**
     *   Return the SortSpecifiers representing the current sort configuration of this
     *   component.
     * 
     */
    override fun getSort(): Array<dynamic> = definedExternally
    /**
     *   Sort this component by a list of SortSpecifiers. If the component's data is not a
     *   ResultSet, only the first specifier is applied.
     * 
     * 
     *  @param {Array<Partial<SortSpecifier>>} List of SortSpecifier objects, one  per sort-field and direction
     */
    override fun setSort(sortSpecifiers: Array<dynamic>): Unit = definedExternally
    /**
     *   Show a dialog to configure the sorting of multiple fields on this component. Calls through
     *   to MultiSortDialog.askForSort, passing this component as the fieldSource and the
     *   current DataBoundComponent.getSort if there is one.
     * 
     *   The generated multiSortDialog can be customized via DataBoundComponent.multiSortDialogDefaults,
     *   DataBoundComponent.multiSortDialogProperties.
     * 
     * 
     */
    override fun askForSort(): Unit = definedExternally
    /**
     *   Returns true if the component's current data model is marked as offline. This does not
     *   necessarily mean that the component has no data; it may have data that was supplied from
     *   the Offline.
     * 
     */
    override fun isOffline(): Boolean = definedExternally
    /**
     *   Shows a FieldPicker interface allowing end-users to edit
     *   the fields currently shown by this DataBoundComponent.
     * 
     * 
     */
    override fun editFields(): Unit = definedExternally
    /**
     *   Notification method fired when a user-generated field is added to this component via
     *   DataBoundComponent.editFormulaField or DataBoundComponent.editSummaryField.
     * 
     *   Returning false from this method will prevent the field being added at all. Note that
     *   this also provides an opportunity to modify the generated field object - any changes
     *   made to the field parameter will show up when the field is displayed in the ListGrid.
     * 
     * 
     *  @param {ListGridField} User generated summary or formula field
     */
    override fun userAddedField(field: ListGridField): Boolean = definedExternally
    /**
     *   Called when the selection changes. Note that this method fires exactly once for any given
     *   change to the selection unlike the ListGrid.selectionChanged event.
     * 
     *   This event is fired once after selection/deselection has completed. The result is
     *   one event per mouse-down event. For a drag selection there will be two events fired:
     *   one when the first record is selected and one when the range is completed.
     * 
     *   This event is also fired when selection is updated by a direct call to one of the
     *   DataBoundComponent select/deselect methods. Calls on the Selection
     *   object do not trigger this event.
     * 
     * 
     *  @param {object} first selected record in the selection, if any, which may or may not be the first record in sort order if the DataBoundComponent is sorted. This parameter is typically used when only one record can be selected at a time.
     *  @param {Array<Partial<object>>} List of records that are now selected
     */
    override fun selectionUpdated(record: dynamic, recordList: Array<dynamic>): Unit = definedExternally
    companion object {
        /**
         *  Creates a new DetailViewer
         * 
         *  @param typeCheckedProperties {Partial<DetailViewer>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DetailViewer} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DetailViewer = definedExternally
        /**
         *   Returns whether there are any pending DSRequests initiated by this
         *   DataBoundComponent. May not include any requests sent by directly calling the
         *   DataSource APIs (rather than the DataBoundComponent APIs).
         * 
         * 
         */
        fun requestsArePending(): Boolean = definedExternally
    }
}