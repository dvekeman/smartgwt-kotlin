@file:JsQualifier("isc")
package isc

/**
 *  An object literal with a particular set of properties used to configure the display of
 *   and interaction with the rows of a DetailViewer.
 */
open external class DetailViewerField : DBCField {
    /**
     *  Name property used to identify the field, and determines which attribute from
     *   records will be displayed in this field.
     * 
     *   Must be unique within the DetailViewer as well as a valid JavaScript identifier - see
     *   FieldName for details and how to check for validity.
     * 
     *   The attribute of the records to display in this field may also be set by
     *   DetailViewerField.displayField.
     *  @type {FieldName}
     *  @default null
     */
    open var name: String = definedExternally
    /**
     *  If displayField is defined for the field then the DetailViewer will
     *   display the displayField attribute of records instead of the attribute
     *   given by the DetailViewerField.name of the field.
     *  @type {string}
     *  @default null
     */
    open var displayField: String = definedExternally
    /**
     *  dataPath property allows this field to display detail from nested data structures
     *  @type {string}
     *  @default null
     */
    open var dataPath: String = definedExternally
    /**
     *  Display format to use for date type values within this field.
     * 
     *   The DetailViewerField.timeFormatter may also be used to format underlying Date values as
     *   times (omitting the date part entirely). If both dateFormatter and
     *   timeFormatter are specified on a field, for
     *   fields specified as DetailViewerField.type the
     *   timeFormatter will be used, otherwise the dateFormatter
     * 
     *   If field.dateFormatter and field.timeFormatter is unspecified,
     *   date display format may be defined at the component level via
     *   DetailViewer.dateFormatter, or for fields of type "datetime"
     *   DetailViewer.datetimeFormatter. Otherwise the
     *   default is to use the system-wide default normal date format, configured via
     *   DateUtil.setNormalDisplayFormat. Specify any valid
     *   DateDisplayFormat to change the format used by this item.
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
     *  Time-format to apply to date type values within this field. If specified, any
     *   dates displayed in this field will be formatted as times using the appropriate format.
     *   This is most commonly only applied to fields specified as type "time" though
     *   if no explicit DetailViewerField.dateFormatter is specified it will be respected for other
     *   fields as well.
     * 
     *   If unspecified, a timeFormatter may be defined
     *   DetailViewer.timeFormatter and will be respected by fields
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
     *  Size of images shown for fieldTypes image in this field.
     * 
     *   If set to a String, assumed to be a property on each record that specifies the image
     *   height. For example, if field.imageSize is "logoSize",
     *   record.logoSize will control the size of the image.
     *  @type {Integer | string}
     *  @default null
     */
    open var imageSize: dynamic = definedExternally
    /**
     *  Width of images shown for fieldTypes image in this field.
     * 
     *   If set to a String, assumed to be a property on each record that specifies the image
     *   width. For example, if field.imageWidth is "logoWidth",
     *   record.logoWidth will control the width of the image.
     *  @type {Integer | string}
     *  @default null
     */
    open var imageWidth: dynamic = definedExternally
    /**
     *  Height of image shown for fieldTypes image in this field.
     * 
     *   If set to a String, assumed to be a property on each record that specifies the image
     *   height. For example, if field.imageHeight is "logoHeight",
     *   record.logoHeight will control the height of the image.
     *  @type {Integer | string}
     *  @default null
     */
    open var imageHeight: dynamic = definedExternally
    /**
     *  If this field has type set to "image"
     *   and the URL for the image displayed is not absolute, the path of the URL will be relative
     *   to this string
     *  @type {string}
     *  @default null
     */
    open var imageURLPrefix: String = definedExternally
    /**
     *  The HTML to display for values of this field if the field type is set to "link".
     * 
     *   This property sets linkText that will be the same for all records. You can set linkText
     *   on a per-record basis via DetailViewerRecord.linkText.
     *  @type {string}
     *  @default null
     */
    open var linkText: String = definedExternally
    /**
     *  Name of the property in a DetailViewerRecord that holds the HTML to display for values
     *   of this field if the field type is set to "link".
     *  @type {string}
     *  @default null
     */
    open var linkTextProperty: String = definedExternally
    /**
     *  If this field has type set to "link", setting this property will apply a
     *   standard prefix to the link URL when displaying values of this field.
     *  @type {string}
     *  @default null
     */
    open var linkURLPrefix: String = definedExternally
    /**
     *  If this field has type set to "link", setting this property will apply a
     *   standard suffix to the link URL when displaying values of this field.
     *  @type {string}
     *  @default null
     */
    open var linkURLSuffix: String = definedExternally
    /**
     *  By default, clicking a link rendered by this item opens it in a new browser window. You
     *   can alter this behavior by setting this property. The value of this property will be
     *   passed as the value to the target attribute of the anchor tag used to render
     *   the link. target is applicable only if the field type is set to "link".
     *  @type {string}
     *  @default "_blank"
     */
    open var target: String = definedExternally
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
     *  Dictates whether the data in this field should be exported raw by
     *   DetailViewer.exportClientData. If set to true for a
     *   field, the values in the field-formatters will not be executed for data in this field.
     *  @type {boolean}
     *  @default null
     */
    open var exportRawValues: Boolean = definedExternally
    /**
     *  Determines whether this field can be hilited. Set to false to prevent this
     *   field from appearing in HiliteEditor.
     *  @type {boolean}
     *  @default null
     */
    open var canHilite: Boolean = definedExternally
    /**
     *  When DetailViewer.hiliteIcons are present, where the hilite icon will be placed
     *   relative to the field value. See HiliteIconPosition.
     *   Overrides DetailViewer.hiliteIconPosition
     *  @type {HiliteIconPosition}
     *  @default null
     */
    open var hiliteIconPosition: 
                                 /**
                                  *  icon will be placed before the normal cell contents
                                  *  icon will be placed after the normal cell contents
                                  *  icon will be shown instead of the normal cell contents
                                  */
                                 String /* before |  after |  replace */ = definedExternally
    /**
     *  Default width and height of DetailViewer.hiliteIcons in this field.
     *   Takes precedence over hiliteIconWidth, hiliteIconHeight and hiliteIconSize specified at
     *   the component level.
     *   Can be overridden via DetailViewerField.hiliteIconWidth and DetailViewerField.hiliteIconHeight
     *  @type {number}
     *  @default null
     */
    open var hiliteIconSize: Number = definedExternally
    /**
     *  Width for hilite icons for this field.
     *   Overrides DetailViewer.hiliteIconSize, DetailViewer.hiliteIconWidth, and
     *   DetailViewerField.hiliteIconSize.
     *  @type {number}
     *  @default null
     */
    open var hiliteIconWidth: Number = definedExternally
    /**
     *  Height for hilite icons for this field.
     *   Overrides DetailViewer.hiliteIconSize, DetailViewer.hiliteIconHeight, and
     *   DetailViewerField.hiliteIconSize.
     *  @type {number}
     *  @default null
     */
    open var hiliteIconHeight: Number = definedExternally
    /**
     *  How much padding should there be on the left of DetailViewer.hiliteIcons
     *   for this field?
     *   Overrides DetailViewer.hiliteIconLeftPadding
     *  @type {number}
     *  @default null
     */
    open var hiliteIconLeftPadding: Number = definedExternally
    /**
     *  How much padding should there be on the right of DetailViewer.hiliteIcons
     *   for this field?
     *   Overrides DetailViewer.hiliteIconRightPadding
     *  @type {number}
     *  @default null
     */
    open var hiliteIconRightPadding: Number = definedExternally
    /**
     *  Specifies the type of this DetailViewerField. By default (value is null)
     *   the field shows a field title on the left and the field value on the right. There are
     *   four special values for this attribute:
     * 
     * 
     *  - "header" - If you specify type "header", the field spans both the field name and
     *   field value columns and contains text defined in the DetailViewerField.value
     *   attribute with the style specified by DetailViewer.headerStyle. You can use this
     *   field type as a titled separator.
     * 
     *  - "separator" - If you specify type "separator", the field spans both the field name
     *   and the field value columns with no text, and is styled using the style specified via
     *   DetailViewer.separatorStyle. The height of the separator field can be controlled
     *   via DetailViewerField.height.
     * 
     *  - "image" For viewing, a thumbnail image is rendered in the field. The URL of the
     *   image is the value of the field, and should be absolute. The size of the image is
     *   controlled by DetailViewerField.imageSize,
     *   DetailViewerField.imageWidth, DetailViewerField.imageHeight
     * 
     *  - "link" For viewing, a clickable html link (using an HTML anchor tag: &lt;A&gt;)
     *   is rendered in the field. The target URL is the value of the field, which is also the
     *   default display value. You can override the display value by setting
     *   DetailViewerRecord.linkText or DetailViewerField.linkText.
     * 
     *   Clicking the link opens the URL in a new window by default. To change this behavior,
     *   you can set field.target, which works identically to the "target"
     *   attribute on an HTML anchor (&lt;A&gt;) tag. See DetailViewerField.target for
     *   more information.
     * 
     *  @type {string}
     *  @default null
     */
    open var type: String = definedExternally
    /**
     *  The title of the field as displayed on the left-hand side. If left unspecified, the
     *   title of the field is derived by looking up the value of
     *   DetailViewer.fieldIdProperty on this field. So, by default, the title of a field
     *   is the value of its "name" property.
     *  @type {HTMLString}
     *  @default null
     */
    open var title: String = definedExternally
    /**
     *  A property list (or an expression that evaluates to a property list)
     *   specifying a mapping of internal values to display values for the field (row).
     *  @type {object}
     *  @default null
     */
    open var valueMap: dynamic = definedExternally
    /**
     *  By default HTML values in DetailViewer cells will be interpreted by the browser.
     *   Setting this flag to true will causes HTML characters to be escaped, meaning the
     *   raw value of the field (for example "&lt;b&gt;AAA&lt;/b&gt;") is displayed
     *   to the user rather than the interpreted HTML (for example "AAA")
     *  @type {boolean}
     *  @default null
     */
    open var escapeHTML: Boolean = definedExternally
    /**
     *  When a field specifies its DetailViewerField.type to be "header", the value of
     *   this attribute specifies the header text.
     *  @type {HTMLString}
     *  @default "undefined"
     */
    open var value: String = definedExternally
    /**
     *  For DetailViewerField.type: "separator", this attribute specifies
     *   the height of the separator.
     *  @type {number}
     *  @default null
     */
    open var height: dynamic = definedExternally
    /**
     *  If specified, cells in this field will be rendered using this css className rather than
     *   DetailViewer.cellStyle
     *  @type {CSSStyleName}
     *  @default null
     */
    open var cellStyle: String = definedExternally
    /**
     *  If specified, when generating print HTML for this detailViewer,
     *   cells in this field will be rendered using this css className rather than
     *   DetailViewer.printCellStyle
     *  @type {CSSStyleName}
     *  @default null
     */
    open var printCellStyle: String = definedExternally
    /**
     *  For a field of type:"imageFile", indicates whether to stream the image and display it
     *   inline or to display the View and Download icons.
     *  @type {boolean}
     *  @default null
     */
    open var showFileInline: Boolean = definedExternally
    /**
     *  Dictates whether the data in this field be exported. Explicitly set this
     *   to false to prevent exporting. Has no effect if the underlying
     *   DataSourceField.canExport is explicitly set to
     *   canExport: false.
     *  @type {boolean}
     *  @default null
     */
    open var canExport: Boolean = definedExternally
    /**
     *  Indicates this field's values come from another, related DataSource.
     *   The individual field will inherit settings such as DetailViewerField.type
     *   and DetailViewerField.title from the related DataSource just like
     *   fields from the primary DataSource.
     *  @type {string}
     *  @default null
     */
    open var includeFrom: String = definedExternally
    /**
     *  The value to display for a cell whose value is null or the empty
     *   string after applying formatCellValue and valueMap (if any).
     * 
     *   This is the field-specific attribute. You may also set the emptyCellValue at the viewer
     *   level to define the emptyCellValue for all empty fields in the viewer.
     *  @type {HTMLString}
     *  @default null
     */
    open var emptyCellValue: String = definedExternally
    /**
     *   Optional method to format the value to display for this field's cells. Takes precedence
     *   over DetailViewer.formatCellValue for cells in this field.
     * 
     *  @param {string} the raw value of the cell
     *  @param {DetailViewerRecord} the record being displayed
     *  @param {DetailViewerField} the field being displayed
     *  @param {DetailViewer} the detailViewer containing this field
     */
    open fun formatCellValue(value: String, record: DetailViewerRecord, field: DetailViewerField, viewer: DetailViewer): Unit = definedExternally
    /**
     * 
     *   If specified on a field, this method is evaluated at draw time to determine whether or
     *   not to show this particular field.
     * 
     *   This method can be specified either as a function or a string that will be
     *   auto-converted to a function.
     * 
     * 
     *  @param {DetailViewer} The DetailViewer
     * \* @param {Array<Partial<DetailViewerRecord>>} 
     */
    open fun showIf(viewer: DetailViewer, valueList: Array<dynamic>): Boolean = definedExternally
    /**
     *   Optional method to return the CSS class for cells in this field. If specified, this method
     *   will be called from DetailViewer.getCellStyle, and should return a css class name.
     * 
     * 
     *  @param {string} actual value of this cell
     *  @param {object} field object for this cell
     *  @param {object} record object for this cell
     *  @param {DetailViewer} the viewer instance to which this cell belongs
     */
    open fun getCellStyle(value: String, field: dynamic, record: dynamic, viewer: DetailViewer): String = definedExternally
}