@file:JsQualifier("isc")
package isc

/**
 *  An ordinary JavaScript object containing properties that configures the display of
 *   and interaction with the columns of a ListGrid.
 */
open external class ListGridField : DBCField {
    /**
     *  When exporting data to Excel/OpenOffice format using ListGrid.exportData or
     *   ListGrid.exportClientData with ListGrid.exportFieldWidths set,
     *   set this flag false to cause this field to "opt out" of width export. Fields that opt out
     *   in this way have the corresponding spreadsheet column autosized (ie, made just wide enough
     *   that content is not clipped).
     * 
     *   This setting has no effect if listGrid.exportFieldWidths is not set.
     *  @type {boolean}
     *  @default true
     */
    open var exportFieldWidth: Boolean = definedExternally
    /**
     *  If this field can be grouped, this attribute represents the set of grouping styles that
     *   are available. For example, a "date" field might be able to be
     *   grouped by week or month, as well as by the date itself.
     * 
     *   If groupingModes are present and
     *   ListGrid.canGroupBy, the menu for this field includes a
     *   submenu of possible grouping modes generated from the groupingModes valueMap.
     *   When the user selects a particular grouping mode,
     *   ListGridField.groupingMode is set to the user's chosen mode,
     *   and this choice can be detected via the field parameter to
     *   ListGridField.getGroupValue in order to provide different modes of grouping.
     * 
     *   The user may also choose to group records without specifying a grouping mode, in this case,
     *   the ListGridField.defaultGroupingMode is used.
     * 
     *   Note that getGroupValue, groupingModes et al can be specified on
     *   SimpleType declarations. See this list of
     *   builtinGroupingModes for more information.
     *  @type {ValueMap}
     *  @default null
     */
    open var groupingModes: dynamic = definedExternally
    /**
     *  For a field that allows multiple ListGridField.groupingModes,
     *   the current grouping mode.
     * 
     *   This property is set when a user chooses a particular grouping mode, and may be set on
     *   ListGrid creation to affect the initial grouping.
     *  @type {Identifier}
     *  @default null
     */
    open var groupingMode: String = definedExternally
    /**
     *  Default groupingMode used when the user does not specify a mode or grouping is triggered
     *   programmatically and ListGridField.groupingMode is unset.
     *   See ListGridField.groupingModes.
     *  @type {Identifier}
     *  @default null
     */
    open var defaultGroupingMode: String = definedExternally
    /**
     *  For fields of type:"float" or derived from float, number of digits after the decimal point
     *   to consider when grouping.
     * 
     *   For example, groupPrecision:2 indicates that 45.238 and 45.231 group together,
     *   but 45.22 and 45.27 are separate.
     * 
     *   See also ListGridField.groupGranularity for grouping by broader
     *   ranges.
     *  @type {Integer}
     *  @default null
     */
    open var groupPrecision: Number = definedExternally
    /**
     *  Granularity of grouping for numeric fields.
     * 
     *   Groups will be formed based on ranges of values of size groupGranularity. For
     *   example, if groupGranularity were 1000, groups would be 0-1000, 1000-2000, etc.
     *  @type {Integer}
     *  @default null
     */
    open var groupGranularity: Number = definedExternally
    /**
     *  Determines whether this field can be hilited. Set to false to prevent this
     *   field from appearing in HiliteEditor.
     *  @type {boolean}
     *  @default null
     */
    open var canHilite: Boolean = definedExternally
    /**
     *  Determines whether hiliting for this field is shown in a group summary.
     *   Set to false to prevent this field from showing hilite in a group summary.
     * 
     *   All hilites in group summary rows can be controlled with the
     *   ListGrid.showHilitesInGroupSummary property.
     *  @type {boolean}
     *  @default null
     */
    open var showHilitesInGroupSummary: Boolean = definedExternally
    /**
     *  Determines whether this field will be groupable in the header context menu.
     *  @type {boolean}
     *  @default true
     */
    open var canGroupBy: Boolean = definedExternally
    /**
     *  When true, this field can only be used for sorting if the data is entirely client-side.
     *  @type {boolean}
     *  @default false
     */
    open var canSortClientOnly: Boolean = definedExternally
    /**
     *  When set to false, this field will not show a context menu in its header.
     *  @type {boolean}
     *  @default true
     */
    open var showDefaultContextMenu: Boolean = definedExternally
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
     *  Dictates whether the data in this field should be exported raw by
     *   ListGrid.exportClientData. If set to true for a
     *   field, the values in the field-formatters will not be executed for data in this field.
     *   Decreases the time taken for large exports.
     *  @type {boolean}
     *  @default null
     */
    open var exportRawValues: Boolean = definedExternally
    /**
     *  The value to display for a ListGridField when it appears in the ListGrid.summaryRow. The
     *   default for normal fields is null and for special fields, like the ListGrid.checkboxField,
     *   the default is to show a blank value (a non-breaking space).
     *  @type {HTMLString}
     *  @default null
     */
    open var summaryValue: String = definedExternally
    /**
     *  This property is a mapping from data values for this field to SCImgURL for
     *   icons to display for those data values.
     * 
     *   For example, given a field named "status" with possible values
     *   "Normal", "Slow", "Offline", the follow definition would show various icons for that
     *   field:
     * 
     * 
     * 
     *   fields : [
     *     { name:"status",
     *      valueIcons: {
     *        Normal : "greenIcon.png",
     *        Slow : "yellowIcon.png",
     *        Offline : "redIcon.png"
     *      }
     *     },
     *     ... other fields ...
     *   ]
     * 
     * 
     * 
     * 
     *   If a simple value-to-URL mapping is not enough, you can override ListGrid.getValueIcon
     *   to customize the behavior. You can even specify an empty valueIcons map
     *   and use ListGrid.getValueIcon to return arbitrary icons with no fixed mapping.
     * 
     *   valueIcons can either be displayed alongside the normal value or can
     *   replace the normal field value so that only the icon is shown. See
     *   ListGridField.showValueIconOnly. When placed alongside the value, use
     *   ListGridField.valueIconOrientation to control left- vs right-side placement.
     * 
     *   If inline editing is enabled for this field, editors displayed for this field will also
     *   show valueIcons. This may be overridden by explicitly setting
     *   ListGridField.editorValueIcons.
     * 
     *   Note that the following attributes related to valueIcon styling will also be picked up
     *   by the editor from the ListGridField object unless explicitly specified via the
     *   equivalent editor_ attributes:
     *   ListGridField.valueIconWidth
     *   ListGridField.valueIconHeight
     *   ListGridField.valueIconSize
     *   ListGridField.valueIconLeftPadding
     *   ListGridField.valueIconRightPadding
     *   ListGridField.imageURLPrefix
     *   ListGridField.imageURLSuffix
     * 
     *   If ListGridField.valueIconClick is defined for the field, a pointer
     *   cursor will be shown when the user rolls over the valueIcon, and the valueIconClick
     *   method will execute when the user clicks the icon.
     *  @type {Map<String>}
     *  @default null
     */
    open var valueIcons: Map<String> = definedExternally
    /**
     *  Default width and height of value icons in this field.
     *   Takes precedence over valueIconWidth, valueIconHeight and valueIconSize specified at
     *   the ListGrid level.
     *   Can be overridden via ListGridField.valueIconWidth and {ListGridField.valueIconHeight}
     *  @type {number}
     *  @default null
     */
    open var valueIconSize: Number = definedExternally
    /**
     *  Width for value icons for this listGrid field.
     *   Overrides ListGrid.valueIconSize, ListGrid.valueIconWidth, and
     *   ListGridField.valueIconSize.
     *  @type {number}
     *  @default null
     */
    open var valueIconWidth: Number = definedExternally
    /**
     *  Height for value icons for this listGrid field.
     *   Overrides ListGrid.valueIconSize, ListGrid.valueIconHeight, and
     *   ListGridField.valueIconSize.
     *  @type {number}
     *  @default null
     */
    open var valueIconHeight: Number = definedExternally
    /**
     *  How much padding should there be on the left of valueIcons for this field
     *   Overrides ListGrid.valueIconLeftPadding
     *  @type {number}
     *  @default null
     */
    open var valueIconLeftPadding: Number = definedExternally
    /**
     *  How much padding should there be on the right of valueIcons for this field
     *   Overrides ListGrid.valueIconRightPadding
     *  @type {number}
     *  @default null
     */
    open var valueIconRightPadding: Number = definedExternally
    /**
     *  When some cell in this field is being edited, setting this property will specify the
     *   value icons to display in the cell's editor. If unset, the editor's valueIcons
     *   will be determined in the same way as it would be for a static cell.
     *  @type {Map<String>}
     *  @default null
     */
    open var editorValueIcons: Map<String> = definedExternally
    /**
     *  When some cell in this field is being edited, setting this property will specify the
     *   width for value icons in the cell's editor. If unset, the editor's valueIcon width and
     *   height will be determined in the same way as it would be for a static cell.
     *  @type {number}
     *  @default null
     */
    open var editorValueIconWidth: Number = definedExternally
    /**
     *  When some cell in this field is being edited, setting this property will specify the
     *   height for value icons in the cell's editor. If unset, the editor's valueIcon width and
     *   height will be determined in the same way as it would be for a static cell.
     *  @type {number}
     *  @default null
     */
    open var editorValueIconHeight: Number = definedExternally
    /**
     *  If this field has a valueIcons property specified, setting this property causes
     *   the valueIcon for each value to be displayed in the cell without also showing the
     *   record's value for the field.
     * 
     *   If unset the default behavior is to show the icon only if an explicit valueMap is
     *   specified as well in addition to a valueIcons map, otherwise show both the valueIcon and
     *   value for the cell.
     * 
     *   Note that if this field is editable FormItem.showValueIconOnly will be passed
     *   through to editors displayed in this field.
     *  @type {boolean}
     *  @default null
     */
    open var showValueIconOnly: Boolean = definedExternally
    /**
     *  If this field has a valueIcons property specified, setting this property to true will
     *   prevent the valueIcon being written out into this field's cells.
     * 
     *   Note this property may also be set to false to avoid showing the standard
     *   ListGrid.booleanTrueImage and ListGrid.booleanFalseImage for fields of type
     *   boolean.
     *  @type {boolean}
     *  @default null
     */
    open var suppressValueIcon: Boolean = definedExternally
    /**
     *  If we're showing a valueIcon for this field should it appear to the left or the right
     *   of the text? By default the icon will appear to the left of the textual value -
     *   set this to "right" to show the icon on the right of the text.
     *   Has no effect if ListGridField.showValueIconOnly is true
     *  @type {string}
     *  @default null
     */
    open var valueIconOrientation: String = definedExternally
    /**
     *  When ListGrid.hiliteIcons are present, where the hilite icon will be placed
     *   relative to the field value. See HiliteIconPosition.
     *   Overrides ListGrid.hiliteIconPosition.
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
     *  Default width and height of ListGrid.hiliteIcons in this field.
     *   Takes precedence over hiliteIconWidth, hiliteIconHeight and hiliteIconSize specified at
     *   the component level.
     *   Can be overridden via ListGridField.hiliteIconWidth and
     *   ListGridField.hiliteIconHeight
     *  @type {number}
     *  @default null
     */
    open var hiliteIconSize: Number = definedExternally
    /**
     *  Width for hilite icons for this field.
     *   Overrides ListGrid.hiliteIconSize, ListGrid.hiliteIconWidth, and
     *   ListGridField.hiliteIconSize.
     *  @type {number}
     *  @default null
     */
    open var hiliteIconWidth: Number = definedExternally
    /**
     *  Height for hilite icons for this field.
     *   Overrides ListGrid.hiliteIconSize, ListGrid.hiliteIconHeight, and
     *   ListGridField.hiliteIconSize.
     *  @type {number}
     *  @default null
     */
    open var hiliteIconHeight: Number = definedExternally
    /**
     *  How much padding should there be on the left of DataBoundComponent.hiliteIcons
     *   for this field?
     *   Overrides ListGrid.hiliteIconLeftPadding
     *  @type {number}
     *  @default null
     */
    open var hiliteIconLeftPadding: Number = definedExternally
    /**
     *  How much padding should there be on the right of DataBoundComponent.hiliteIcons
     *   for this field?
     *   Overrides ListGrid.hiliteIconRightPadding
     *  @type {number}
     *  @default null
     */
    open var hiliteIconRightPadding: Number = definedExternally
    /**
     *  If this field has type [ListGridFieldType] set to "image"
     *   and the URL for the image displayed is not absolute, the path of the URL will be relative
     *   to this string
     *   Alternatively, if this field displays any valueIcons, this prefix will be applied to
     *   the beginning of any ListGridField.valueIcons when determining the
     *   URL for the image.
     *  @type {string}
     *  @default null
     */
    open var imageURLPrefix: String = definedExternally
    /**
     *  If any cells in this field are showing a value icon (see: ListGridField.valueIcons)
     *   or this is has ListGridFieldType set to "image", this the value
     *   of this property will be appended to the end of the URL for the icon displayed.
     *   Typical usage might be to append a file type such as ".gif" to the
     *   filename of the image.
     *   For editable fields, this property will also be passed through to any editors as
     *   FormItem.imageURLSuffix.
     *  @type {string}
     *  @default null
     */
    open var imageURLSuffix: String = definedExternally
    /**
     *  When some cell in this field is being edited, this property can be used to apply
     *   an explicit FormItem.imageURLPrefix to the editor in question.
     *   This can be used to modify the valueIcons within the editor.
     *   If unset, but ListGridField.imageURLPrefix is specified, that will be used
     *   instead.
     *  @type {string}
     *  @default null
     */
    open var editorImageURLPrefix: String = definedExternally
    /**
     *  When some cell in this field is being edited, this property can be used to apply
     *   an explicit FormItem.imageURLSuffix to the editor in question.
     *   This can be used to modify the valueIcons within the editor.
     *   If unset, but ListGridField.imageURLPrefix is specified, that will be used
     *   instead.
     *  @type {string}
     *  @default null
     */
    open var editorImageURLSuffix: String = definedExternally
    /**
     *  Size of images shown for fieldTypes image and imageFile in this field.
     *   This setting overrides the global ListGrid default ListGrid.imageSize.
     * 
     *   If set to a String, assumed to be a property on each record that specifies the image
     *   height. For example, if field.imageSize is "logoSize",
     *   record.logoSize will control the size of the image.
     *  @type {number}
     *  @default "16"
     */
    open var imageSize: Number = definedExternally
    /**
     *  Width of images shown for fieldTypes image and imageFile in this field.
     * 
     *   If set to a String, assumed to be a property on each record that specifies the image
     *   width. For example, if field.imageWidth is "logoWidth",
     *   record.logoWidth will control the width of the image.
     *  @type {number}
     *  @default "16"
     */
    open var imageWidth: Number = definedExternally
    /**
     *  Height of image shown for fieldTypes image and imageFile in this field.
     * 
     *   If set to a String, assumed to be a property on each record that specifies the image
     *   height. For example, if field.imageHeight is "logoHeight",
     *   record.logoHeight will control the height of the image.
     *  @type {number}
     *  @default "16"
     */
    open var imageHeight: Number = definedExternally
    /**
     *  ListGrids picks a renderer for the view and edit mode of a field based on this attribute.
     *   See ListGridFieldType for a summary of how types are rendered.
     *  @type {ListGridFieldType}
     *  @default "text"
     */
    open var type: 
                   /**
                    *  Simple text rendering for view. For editing a text entry field is shown. If the length of the field (as specified by the DataSourceField.length
                    *   attribute) is larger than the value specified by ListGrid.longTextEditorThreshold, a
                    *   text input icon is shown that, when clicked on (or field is focused in) opens a larger
                    *   editor that expands outside the boundaries of the cell (textarea by default, but
                    *   overrideable via ListGrid.longTextEditorType).
                    *  For viewing and editing a checkbox is shown with a check mark for the true value and no check mark for the false value. This behavior
                    *   may be suppressed by setting ListGridField.suppressValueIcon for the field. See
                    *   ListGrid.booleanTrueImage for customization.
                    *  A whole number, e.g. 123. Consider setting ListGridField.editorType to use a SpinnerItem.
                    *  A floating point (decimal) number, e.g. 1.23. Consider setting ListGridField.editorType to use a SpinnerItem.
                    *  Field value should be a Date instance representing a logical date, with no time of day information. See dateFormatAndStorage for
                    *   details of the logical date type and how it is represented and manipulated.
                    * 
                    *   Dates will be formatted using ListGridField.dateFormatter
                    *   if specified, otherwise
                    *   ListGrid.dateFormatter.
                    *   If both these attributes are unset, dates are formatted
                    *   using the standard DateUtil.setShortDisplayFormat for dates.
                    * 
                    *   For editing, by default a DateItem is used with DateItem.useTextField set
                    *   to true, providing textual date entry plus a pop-up date picker. The
                    *   DateItem.dateFormatter and DateItem.inputFormat
                    *   for the editor will be picked up from the ListGridField, if specified.
                    *  Field value should be a Date instance representing a logical time, meaning time value that does not have a specific day and also has no timezone. See
                    *   dateFormatAndStorage for details of the logical time type and how it is
                    *   represented and manipulated.
                    * 
                    *   Times will be formatted using ListGridField.timeFormatter
                    *   if specified,
                    *   otherwise ListGrid.timeFormatter.
                    * 
                    *   If both these attributes are unset, times are formatted using the standard
                    *   Time.shortDisplayFormat for times.
                    * 
                    *   For editing, by default a TimeItem is used. The
                    *   TimeItem.timeFormatter for the editor will be picked up from
                    *   the ListGridField, if specified.
                    *  Field value should be a Date instance representing a specific date and time value. See dateFormatAndStorage for details of the
                    *   datetime type and how it is represented and manipulated.
                    * 
                    *   Dates will be formatted using ListGridField.dateFormatter
                    *   if specified, otherwise
                    *   ListGrid.datetimeFormatter.
                    *   If both these attributes are unset, dates are formatted
                    *   using the standard DateUtil.setShortDatetimeDisplayFormat for
                    *   datetime values.
                    * 
                    *   For editing, by default a DateTimeItem is used, providing textual date entry plus
                    *   a pop-up date picker. The DateItem.dateFormatter and
                    *   DateItem.inputFormat for the editor will be picked up from the
                    *   ListGridField, if specified.
                    *  Same as text
                    *  Renders a clickable html link (using an HTML anchor tag: &lt;A&gt;). The target URL is the value of the field, which is also the default display value. You
                    *   can override the display value by setting ListGridRecord.linkText or
                    *   ListGridField.linkText.
                    * 
                    *   Clicking the link opens the URL in a new window by default. To change this behavior,
                    *   you can set field.target, which works identically to the "target"
                    *   attribute on an HTML anchor (&lt;A&gt;) tag. See ListGridField.target for more
                    *   information.
                    * 
                    *   In inline edit mode, this type works like a text field.
                    * 
                    *   To create a link not covered by this feature, consider using
                    *   ListGridField.formatCellValue along with Canvas.linkHTML, or simply
                    *   ListGrid.getCellStyle to look like a link, and providing
                    *   interactivity via ListGridField.recordClick.
                    *  Renders a different image in each row based on the value of the field. If this URL is not absolute, it is assumed to be relative to
                    *   ListGridField.imageURLPrefix if specified. The size of the image is controlled by
                    *   ListGridField.imageSize, ListGridField.imageWidth,
                    *   ListGridField.imageHeight (and by the similarly-named global default
                    *   attributes on the ListGrid itself).
                    * 
                    *   You can also specify the following attributes on the field: activeAreaHTML, and
                    *   extraStuff - these are passed to Canvas.imgHTML to generate the
                    *   final URL.
                    * 
                    *   Note if you want to display icons in addition to the normal cell value, you
                    *   can use ListGridField.valueIcons instead.
                    *  Shows ListGridField.icon in every cell, and also in the header. Useful for a field that is used as a button, for example, launches a detail
                    *   window or removes a row. Implement a ListGridField.recordClick
                    *   to define a behavior for the button.
                    * 
                    *   NOTE: for a field that shows different icons depending on the field value, see
                    *   ListGridField.valueIcons.
                    * 
                    *   type:"icon" also defaults to a small field width, accommodating just the icon
                    *   with padding, and to a blank header title, so that the header shows the icon only.
                    * 
                    *   ListGridField.iconWidth and related properties configure
                    *   the size of the icon both in the header and in body cells.
                    * 
                    *   If you want the icon to appear only in body cells and not in the header, set
                    *   ListGridField.cellIcon instead, leaving field.icon null.
                    *  For viewing, the grid renders a 'view' icon (looking glass) followed by a 'download' icon and then the name of the file is displayed in text. If the user clicks the
                    *   'view' icon, a new browser window is opened and the file is streamed to that browser
                    *   instance, using DataSource.viewFile. For images and other file types with
                    *   known handlers, the content is typically displayed inline - otherwise the browser will
                    *   ask the user how to handle the content. If the download icon is clicked,
                    *   DataSource.downloadFile is used to cause the browser to show a "save" dialog.
                    *   There is no inline editing mode for this field type.
                    *  Same as binary
                    *  Show a calculated summary based on other field values within the current record. See ListGridField.recordSummaryFunction for more information
                    *  Fields of this type can contain any data value and have no default formatting or validation behavior. This is useful as the
                    *   SimpleType.inheritsFrom for SimpleTypes
                    *   where you do not want any of the standard validation or formatting logic
                    *   to be inherited from the standard built-in types.
                    *  An integer number with locale-based formatting, e.g. 12,345,678. See localizedNumberFormatting
                    *   for more info.
                    *  A float number with locale-based formatting, e.g. 12,345.67. See localizedNumberFormatting
                    *   for more info.
                    *  A float number with locale-based formatting and using currency symbol, e.g. $12,345.67.
                    *   See localizedNumberFormatting
                    *   for more info.
                    *  A telephone number. Uses FormItem.browserInputType "tel" to hint to the device to restrict input. On most mobile devices that have
                    *   software keyboards, this cause a specialized keyboard to appear which
                    *   only allows entry of normal phone numbers. When displayed read-only,
                    *   a "phoneNumber" renders as an HTML link with the "tel:" URL scheme,
                    *   which will invoke the native phone dialing interface on most mobile
                    *   devices. In addition, the CSS style "sc_phoneNumber" is applied.
                    * 
                    *   By default, "phoneNumber" fields do not include validators, however the
                    *   following validator definition would limit to digits, dashes and the
                    *   "+" character:
                    *   xml:
                    * 
                    *     &lt;validator type="regexp" expression="^(\(?\+?[0-9]\*\)?)?[0-9_\- \(\)]\*$"
                    *       errorMessage="Phone number should be in the correct format e.g. +#(###)###-##-##" /&gt;
                    * 
                    * 
                    *   or directly in JavaScript:
                    * 
                    * 
                    *   {type:"regexp", expression:"^(\\(?\\+?[0-9]\*\\)?)?[0-9_\\- \\(\\)]\*$", 
                    *     errorMessage:"Phone number should be in the correct format e.g. +#(###)###-##-##"}
                    * 
                    * 
                    * 
                    *   and adding "#" and "\*" to the regular expressions above would allow for
                    *   users to enter special keys sometimes used for extension numbers or
                    *   pauses
                    */
                   String /* text |  boolean |  integer |  float |  date |  time |  datetime |  sequence |  link |  image |  icon |  binary |  imageFile |  summary |  any |  localeInt |  localeFloat |  localeCurrency |  phoneNumber */ = definedExternally
    /**
     *  Name of this field. Must be unique within this ListGrid as well as a valid JavaScript
     *   identifier - see FieldName for details and how to check for validity.
     * 
     *   The name of field is also the property in each record which holds the value for that
     *   field.
     * 
     *   If a ListGrid.dataSource is specified and the DataSource has a field with the
     *   same name, the ListGridField and DataSourceField are merged, with any properties on the
     *   ListGridField overriding those on the DataSourceField.
     *  @type {FieldName}
     *  @default null
     */
    open var name: String = definedExternally
    /**
     *  dataPath for this field. This property allows the grid to display details of nested data
     *   structures in a flat list of columns.
     *  @type {string}
     *  @default null
     */
    open var dataPath: String = definedExternally
    /**
     *  A title for this field, to display in the header for the field and in other
     *   contexts such as the ListGrid.canPickFields.
     * 
     *   Note: if you want to use HTML tags to affect the display of the header, you should do so
     *   via ListGridField.headerTitle instead so that other places where the title
     *   appears in the UI are not affected. For example, you might set headerTitle
     *   to an empty string to suppress the header title on a narrow column, but you would retain
     *   the normal title in the title property to avoid a blank menu item in the
     *   field picker menu, DataBoundComponent.editHilites and other contexts.
     * 
     *   Alternately you can specify a ListGridField.getFieldTitle method on the field to return the
     *   HTML for the field title.
     *  @type {string}
     *  @default null
     */
    open var title: String = definedExternally
    /**
     *  This property may be set to false to explicitly suppress display of
     *   the field title in the column header button for the field.
     *  @type {boolean}
     *  @default null
     */
    open var showTitle: Boolean = definedExternally
    /**
     *  Should the field title wrap if there is not enough space horizontally to accommodate it.
     *   If unset, default behavior is derived from ListGrid.wrapHeaderTitles. (This is a
     *   soft-wrap - if set the title will wrap at word boundaries.)
     * 
     *   Notes:
     * 
     *  - If autofitting is active, ListGridField.width and ListGridField.minWidth can be set to control the
     *   minimum field width - see the links for details.
     * 
     *  - This feature is incompatible with ListGrid.clipHeaderTitles, and
     *   clipHeaderTitles will be disabled for wrapping fields.
     *  @type {boolean}
     *  @default null
     */
    open var wrap: Boolean = definedExternally
    /**
     *  This property may be set to customize the wrap attribute for the
     *   canvas shown when the mouse hovers over cells in this field. Note that this causes a
     *   soft-wrap - if set, the hover text will wrap at word boundaries.
     * 
     *   If unset, default behavior is derived from ListGrid.headerHoverWrap.
     *  @type {boolean}
     *  @default null
     */
    open var hoverWrap: Boolean = definedExternally
    /**
     *  Specifies the width of the canvas shown when the mouse hovers over cells in this field.
     * 
     *   If unset, default behavior is derived from ListGrid.headerHoverWidth.
     *  @type {Integer}
     *  @default null
     */
    open var hoverWidth: Number = definedExternally
    /**
     *  By default, clicking a link rendered by this item opens it in a new browser window. You
     *   can alter this behavior by setting this property. The value of this property will be
     *   passed as the value to the target attribute of the anchor tag used to render
     *   the link.
     * 
     *   If you set listGridField.target to "javascript", the default behavior is to catch and
     *   consume mouse-clicks that would result in the link being followed. Instead, the
     *   ListGrid.cellClick event is fired for the containing cell.
     *  @type {string}
     *  @default "_blank"
     */
    open var target: String = definedExternally
    /**
     *  Marks field as initially hidden.
     *   The user will still be able to show the field via a context menu.
     *   This may be suppressed by setting ListGridField.canHide to false, or by
     *   setting ListGrid.canPickFields to false to suppress the
     *   field-picker entirely.
     * 
     *   To mark a field as completely hidden (not shown to a user at all, in any component), set
     *   DataSourceField.hidden instead.
     *  @type {boolean}
     *  @default null
     */
    open var hidden: Boolean = definedExternally
    /**
     *  Whether this field should be "frozen" for the purposes of horizontal scrolling. See
     *   frozenFields.
     *  @type {boolean}
     *  @default null
     */
    open var frozen: Boolean = definedExternally
    /**
     *  Whether this field should display freezing/unfreezing options in its header context menu.
     *   See frozenFields.
     *  @type {boolean}
     *  @default null
     */
    open var canFreeze: Boolean = definedExternally
    /**
     *  Whether this field should be automatically frozen when other fields are frozen. When
     *   true, the field will be automatically frozen to the extreme of the grid. The
     *   automatically generated ListGrid.checkboxField,
     *   ListGrid.expansionField and
     *   ListGrid.rowNumberField fields are examples of fields that specify
     *   autoFreeze: true.
     * 
     *   You can control the position of this field in the array of frozen fields by providing a
     *   ListGridField.getAutoFreezePosition implementation.
     *  @type {boolean}
     *  @default null
     */
    open var autoFreeze: Boolean = definedExternally
    /**
     *  If set to false, this field will be omitted from the column picker that appears in the
     *   header context menu when ListGrid.canPickFields is enabled. This means that the
     *   end user will not be able to hide it if it's currently shown, or show it if it's
     *   currently hidden.
     * 
     *   If this property is set to false, and the
     *   ListGrid.useAdvancedFieldPicker is shown, if the field
     *   is ListGridField.hidden, the field will not show in the list of available fields. If the
     *   field is visible, it will be displayed in the list of currently visible fields, but
     *   the advanced field picker user interface will disallow hiding it.
     *  @type {boolean}
     *  @default null
     */
    open var canHide: Boolean = definedExternally
    /**
     *  Whether this field can be dragResized using the mouse. If unset, the default behavior
     *   is governed by ListGrid.canResizeFields.
     *  @type {boolean}
     *  @default null
     */
    open var canDragResize: Boolean = definedExternally
    /**
     *  Whether this field can be reordered using the mouse. If unset, the default behavior is
     *   governed by ListGrid.canReorderFields. Note that setting this property to
     *   false will lock this field from being moved - that is, the user is
     *   prevented from moving this field directly by dragging with the mouse, or by dropping another
     *   field onto this field. However, unless this field is at the extreme edge of the grid,
     *   or all fields between it and the extreme edge of the grid are also
     *   canReorder: false, (ie, if there are unlocked fields on either side of this
     *   field), then it is possible that this locked field may be
     *   reordered automatically, as a result of the user dragging one unlocked field onto another
     *   unlocked field.
     *  @type {boolean}
     *  @default null
     */
    open var canReorder: Boolean = definedExternally
    /**
     *  If the user is navigating through the grid using the keyboard, record click or double click
     *   events may be generated via keyboard interactions (see ListGrid.generateClickOnSpace,
     *   ListGrid.generateClickOnEnter, ListGrid.generateDoubleClickOnSpace,
     *   ListGrid.generateDoubleClickOnEnter and ListGrid.arrowKeyAction).
     * 
     *   These synthetic events have both a target row and column.
     *   Setting this flag to true ensures that this field will never be considered the target for
     *   a keyboard click event.
     *  @type {boolean}
     *  @default null
     */
    open var ignoreKeyboardClicks: Boolean = definedExternally
    /**
     *  If true, then this field is excluded from the bound component's view state. In addition,
     *   the field will not be selected as the default title field
     *   by DataBoundComponent.getTitleField
     *   if DataBoundComponent.titleField is not provided.
     *  @type {boolean}
     *  @default null
     */
    open var excludeFromState: Boolean = definedExternally
    /**
     *  If ListGrid.showGridSummary is true, should this field show a summary value.
     *   If unset, this field will show a summary value in the summary row if an
     *   explicit ListGridField.summaryFunction is specified or if a
     *   SimpleType.getDefaultSummaryFunction is defined
     *   for the specified field type.
     *  @type {boolean}
     *  @default null
     */
    open var showGridSummary: Boolean = definedExternally
    /**
     *  If ListGrid.showGroupSummary is true, should this field show a summary value
     *   in a summary row when the grid is grouped?
     *   If unset, this field will show a summary value in the summary row if an
     *   explicit ListGridField.summaryFunction is specified or if a
     *   SimpleType.getDefaultSummaryFunction is defined
     *   for the specified field type.
     *  @type {boolean}
     *  @default null
     */
    open var showGroupSummary: Boolean = definedExternally
    /**
     *  If ListGrid.showGridSummary or ListGrid.showGroupSummary is true,
     *   this attribute can be used to specify
     *   an explicit SummaryFunction for calculating the summary value to
     *   display.
     * 
     *   If an array of summaryFunctions is specified, they will be executed in turn and the
     *   grid will show multiple summary rows at the grid or group level (or both)
     *   containing the resulting values.
     *  @type {SummaryFunction | Array<Partial<SummaryFunction>>}
     *  @default null
     */
    open var summaryFunction: dynamic = definedExternally
    /**
     *  If ListGrid.showGridSummary or ListGrid.showGroupSummary is true and the
     *   ListGridField.summaryFunction is set to "title", this attribute may be
     *   set to a string to display in the group and/or grid summary. If unspecified the
     *   ListGridField.title will show up in the summary.
     *  @type {string}
     *  @default null
     */
    open var summaryValueTitle: String = definedExternally
    /**
     *  Optional stringMethod to format the summary value displayed
     *   in the ListGrid.showGridSummary.
     *   Takes a single parameter value and should return the formatted version
     *   of that value. If specified this will be applied instead of any formatting logic applied
     *   via ListGridField.formatCellValue, ListGrid.formatCellValue, etc.
     * 
     *   Note that for fields with a specified summary function of "count", if no custom formatting
     *   is applied, we default to formatting the count value by appending
     *   field.pluralTitle if defined, otherwise field.title to the
     *   numeric count value returned by the standard count function. To change this behavior for
     *   such fields, specify an explicit 'formatGridSummary' and/or 'formatGroupSummary' method
     *  @type {StringMethod}
     *  @default null
     */
    open var formatGridSummary: String = definedExternally
    /**
     *  Optional stringMethod to format the group level summary values for this field displayed via
     *   ListGrid.showGroupSummary.
     *   Takes a single parameter value and should return the formatted version
     *   of that value. If specified this will be applied instead of any formatting logic applied
     *   via ListGridField.formatCellValue, ListGrid.formatCellValue, etc.
     * 
     *   Note that for fields with a specified summary function of "count", if no custom formatting
     *   is applied, we default to formatting the count value by appending
     *   field.pluralTitle if defined, otherwise field.title to the
     *   numeric count value returned by the standard count function. To change this behavior for
     *   such fields, specify an explicit 'formatGridSummary' and/or 'formatGroupSummary' method
     *  @type {StringMethod}
     *  @default null
     */
    open var formatGroupSummary: String = definedExternally
    /**
     *  Only applies to fields of type "summary".
     *   Fields of this type will display a calculated value based on the other field values
     *   within the current record.
     * 
     *   This attribute specifies how the summary field value will be calculated. See
     *   RecordSummaryFunction for valid options.
     * 
     *   A subset of the ListGrid's fields will be passed to the RecordSummaryFunction.
     *   Which fields to include is determined based on ListGridField.includeInRecordSummary
     * 
     *   If ListGrid.showGridSummary or ListGrid.showGroupSummary is true, this
     *   field's value in the summary row[s] will still be calculated by calling this method.
     *   In this case, the record object passed in will contain summary values for each field.
     *   If custom handling is required for this case, it may be detected by checking the
     *   record object's ListGridRecord.isGroupSummary and ListGridRecord.isGridSummary
     *   attributes.
     *  @type {RecordSummaryFunction}
     *  @default null
     */
    open var recordSummaryFunction: 
                                    /**
                                     *  Iterates through each field, picking up the numeric field values from the record and summing them.
                                     *  Iterates through each field, picking up the numeric field values from the record and calculating the mean value.
                                     *  Iterates through each field, picking up the numeric field values from the record and calculating the maximum value.
                                     *  Iterates through each field, picking up the numeric field values from the record and calculating the minimum value.
                                     *  Iterates through each field, picking up the numeric field values from the record and multiplying them together.
                                     */
                                    String /* sum |  avg |  max |  min |  multiplier */ = definedExternally
    /**
     *  Only applies to fields of type "summary".
     *   This attribute is set on a summary field, when calculating the summary value from
     *   some record, the summary function will only be passed the fields before this summary field.
     *   This may be useful for displaying running totals across a record.
     * 
     *   Note that this feature would typically be used with
     *   ListGrid.canReorderFields
     *  @type {boolean}
     *  @default null
     */
    open var partialSummary: Boolean = definedExternally
    /**
     *  If a listGrid is showing a field of type summary, should this field be passed to the
     *   recordSummaryFunction when calculating the summary value to display.
     *   If unset, fields are included if they are of type "integer" or "float" only (since most
     *   summary functions perform numeric calculations). See also
     *   ListGridField.includeInRecordSummaryFields.
     *  @type {boolean}
     *  @default null
     */
    open var includeInRecordSummary: Boolean = definedExternally
    /**
     *  If this listGrid has any fields of type "summary" and
     *   this field will be ListGridField.includeInRecordSummary in summary calculations
     *   by default, this attribute provides an opportunity to explicitly specify which summary fields
     *   the record should be displayed in.
     * 
     *   Specified as an array of fieldNames. If set, this field value will only be included for
     *   record summary value calculations for summary fields who's name is included in this array.
     *  @type {Array<Partial<FieldName>>}
     *  @default null
     */
    open var includeInRecordSummaryFields: Array<dynamic> = definedExternally
    /**
     *  If ListGridField.userFormula is set for this field, and this grid is showing
     *   ListGrid.showGroupSummary or a
     *   ListGrid.showGridSummary, this property determines what field value
     *   should be present in those summary rows. Should the field apply the user-formula to the
     *   calculated summary row, or should it apply a standard grid or group summary to the
     *   user-formula values displayed in the grid?
     * 
     *   Default behavior may be specified at the grid level via ListGrid.applyFormulaAfterSummary
     *  @type {boolean}
     *  @default null
     */
    open var applyAfterSummary: Boolean = definedExternally
    /**
     *  Optional icon to show next to the title for this field.
     *   Should be set to a URL to an image. Relative paths will be evaluated starting at
     *   the imgDir of this component. This URL is partial - it may be updated to indicate
     *   the current disabled (etc) state of the field.
     * 
     *   If ListGridField.type is set to "icon", this icon will also be shown
     *   in every cell of this field - see also ListGridField.cellIcon.
     * 
     *   To change this property after fields have been passed to ListGrid.setFields,
     *   use ListGrid.setFieldIcon.
     *  @type {SCImgURL}
     *  @default null
     */
    open var icon: String = definedExternally
    /**
     *  If ListGridField.icon is specified, this property can be used to specify the
     *   size of the icon to be displayed in the ListGrid header button.
     *   (See StatefulCanvas.iconSize)
     *  @type {Integer}
     *  @default null
     */
    open var iconSize: Number = definedExternally
    /**
     *  If ListGridField.icon is specified, this property can be used to specify the
     *   width of the icon to be displayed in the ListGrid header button.
     *   (See StatefulCanvas.iconWidth)
     *   If this field is editable, and ListGridField.editorIconWidth is unset, this
     *   property will be passed onto the editors for this field as FormItem.iconWidth,
     *   which will effect the default size for ListGridField.icons displayed
     *   in the editor.
     *  @type {Integer}
     *  @default null
     */
    open var iconWidth: Number = definedExternally
    /**
     *  If ListGridField.icon is specified, this property can be used to specify the
     *   height of the icon to be displayed in the ListGrid header button.
     *   (See StatefulCanvas.iconHeight)
     *   If this field is editable, and ListGridField.editorIconHeight is unset, this
     *   property will be passed onto the editors for this field as FormItem.iconWidth,
     *   which will effect the default size for ListGridField.icons displayed
     *   in the editor.
     *  @type {Integer}
     *  @default null
     */
    open var iconHeight: Number = definedExternally
    /**
     *  If this field is showing an icon, should it appear to the left or right of the title?
     *   Valid options are "left" or "right"
     *  @type {string}
     *  @default "left"
     */
    open var iconOrientation: String = definedExternally
    /**
     *  Pixels between icon and title text.
     *  @type {Integer}
     *  @default "6"
     */
    open var iconSpacing: Number = definedExternally
    /**
     *  If using an icon for this button, whether to switch the icon image if the button becomes
     *   disabled.
     *  @type {boolean}
     *  @default true
     */
    open var showDisabledIcon: Boolean = definedExternally
    /**
     *  If using an icon for this button, whether to switch the icon image on mouse rollover.
     *  @type {boolean}
     *  @default false
     */
    open var showRollOverIcon: Boolean = definedExternally
    /**
     *  If using an icon for this button, whether to switch the icon image when the button
     *   receives focus.
     * 
     *   If StatefulCanvas.showFocusedAsOver is true, the "Over" icon will be
     *   displayed when the canvas has focus, otherwise a separate "Focused" icon
     *   will be displayed
     *  @type {boolean}
     *  @default false
     */
    open var showFocusedIcon: Boolean = definedExternally
    /**
     *  If using an icon for this button, whether to switch the icon image when the mouse goes
     *   down on the button.
     *  @type {boolean}
     *  @default false
     */
    open var showDownIcon: Boolean = definedExternally
    /**
     *  If using an icon for this button, whether to switch the icon image when the button
     *   becomes selected.
     *  @type {boolean}
     *  @default false
     */
    open var showSelectedIcon: Boolean = definedExternally
    /**
     *  For a field of type:"icon" only, set the icon that appears in body cells. Unless
     *   setting ListGridField.icon, setting field.cellIcon will not show an
     *   icon in the header.
     * 
     *   To change this property after fields have been passed to ListGrid.setFields,
     *   use ListGrid.setFieldCellIcon.
     *  @type {SCImgURL}
     *  @default null
     */
    open var cellIcon: String = definedExternally
    /**
     *  For a field of type:"imageFile", indicates whether to stream the image and display it
     *   inline or to display the View and Download icons.
     *  @type {boolean}
     *  @default null
     */
    open var showFileInline: Boolean = definedExternally
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
     *  If this field is editable, this property can be used to specify
     *   FormItem.icons to be displayed in the editors displayed for this field
     *  @type {Array<Partial<FormItemIcon>>}
     *  @default null
     */
    open var icons: Array<dynamic> = definedExternally
    /**
     *  If this field is editable, this property will be passed to editors displayed for
     *   cells within this field as FormItem.iconWidth.
     *   If this property unset, the iconWidth property from the editor can be picked up from
     *   ListGridField.iconWidth instead.
     *  @type {number}
     *  @default null
     */
    open var editorIconWidth: Number = definedExternally
    /**
     *  If this field is editable, this property will be passed to editors displayed for
     *   cells within this field as FormItem.iconHeight.
     *   If this property unset, the iconHeight property from the editor can be picked up from
     *   ListGridField.iconHeight instead.
     *  @type {number}
     *  @default null
     */
    open var editorIconHeight: Number = definedExternally
    /**
     *  If this field is editable, this property will be passed to editors displayed for
     *   cells within this field as FormItem.defaultIconSrc.
     *  @type {string}
     *  @default null
     */
    open var defaultIconSrc: String = definedExternally
    /**
     *  If this field is editable, this property will be passed to editors displayed for
     *   cells within this field as FormItem.iconVAlign.
     *  @type {string}
     *  @default null
     */
    open var iconVAlign: String = definedExternally
    /**
     *  Optional long summary title for this field, provided in addition to
     *   ListGridField.title. This gives the developer an option to use a very short,
     *   or empty title for the ListGrid column (where space may be a factor), but have a longer
     *   value available to be used elsewhere.
     * 
     *   By default this value will be used for the title of the context-menu item
     *   for showing/hiding the listGrid field when the user right-clicks on the ListGrid header.
     *  @deprecated \* Rather than customizing the summaryTitle developers should typically use the ListGridField.headerTitle attribute to show a different
     *   title in the column header button than the title used elsewhere.
     *  @type {string}
     *  @default null
     */
    open var summaryTitle: String = definedExternally
    /**
     *  The width of this field, specified as either an absolute number of pixels,
     *   a percentage of the remaining space like "25%", or "\*" to split remaining space among
     *   all fields which have "\*".
     *   Caution: stretch sizes are currently ignored if the field is being autofitted
     *   (see ListGrid.autoFitFieldWidths), unless ListGrid.showHeader is false.
     * 
     *   Note: if autofitting is active for a field, the width will default to the numerical
     *   autofit width for that field (so it will not be stretched larger to fill available
     *   space). Otherwise, if not autofitting, the width will default to "\*" causing it to be
     *   automatically stretched.
     * 
     *   The width may be defaulted to a numerical value based on DataSourceField.length
     *   if no ListGridField.valueMap is set, subject to the initial values of
     *   ListGridField.minWidth and ListGrid.minFieldWidth. If you'd rather have the field
     *   stretched-sized to fit the available space, set its initial width to "\*".
     * 
     *   See also ListGrid.minFieldWidth to ensure no field goes below a minimum size.
     * 
     *   Use ListGrid.resizeField to programmatically change field width after creation.
     * 
     *   Use ListGrid.getFieldWidth to access the rendered field width after
     *   the ListGrid is drawn.
     *  @type {number | string}
     *  @default "\*"
     */
    open var width: dynamic = definedExternally
    /**
     *  When a field is subject to autofitting (see ListGrid.autoFitFieldWidths), sets the
     *   minimum width of the field. The actual allowed minimum will be the maximum of:
     * 
     *  - this property,
     * 
     *  - ListGridField.width (if a number),
     * 
     *  - the aufofit value determined by the widest value content in this field's column
     * 
     *  - ListGrid.minFieldWidth
     * 
     *  @type {number}
     *  @default null
     */
    open var minWidth: Number = definedExternally
    /**
     *  When ListGrid.showHeader is false and a field is subject to autofitting (see
     *   ListGrid.autoFitFieldWidths), sets the maximum width of the field. The actual
     *   effective maximum will be the largest of this property, ListGridField.minWidth, and
     *   ListGrid.minFieldWidth. That is, ListGridField.minWidth and
     *   ListGrid.minFieldWidth dominate this property.
     *  @type {number}
     *  @default null
     */
    open var maxWidth: Number = definedExternally
    /**
     *  Horizontal alignment for field's column header: "left", "right"
     *   or "center". Applied to the column header title and cells by default. A separate
     *   alignment for cells can be specified via ListGridField.cellAlign.
     *   If null, values are left-aligned. If this field is editable, the
     *   alignment of cells in the body will also be reflected in any editors for the field.
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
     *  Custom base style to apply to this field's header button instead of
     *   ListGrid.headerBaseStyle.
     *   Note that depending on the header button constructor, you may have to override
     *   ListGridField.headerTitleStyle as well.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var headerBaseStyle: String = definedExternally
    /**
     *  Custom base style to apply to this field's header button instead of
     *   ListGrid.spannedHeaderBaseStyle when the grid is showing header spans.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var spannedHeaderBaseStyle: String = definedExternally
    /**
     *  Custom titleStyle to apply to this field's header button instead of
     *   ListGrid.headerTitleStyle.
     *   Note that this will typically only have an effect if
     *   ListGrid.headerButtonConstructor is set to StretchImgButton or a subclass
     *   thereof.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var headerTitleStyle: String = definedExternally
    /**
     *  Optional title for the header button for this field. If specified this will be
     *   displayed in the header button instead of ListGridField.title or
     *   ListGridField.name. Set to an empty string to suppress the title in the
     *   header button entirely.
     *  @type {string}
     *  @default null
     */
    open var headerTitle: String = definedExternally
    /**
     *  Horizontal alignment for cells in this field's column: "left", "right"
     *   or "center".
     *   If null, alignment is derived from ListGridField.align. If this field is editable,
     *   the alignment of cells in the body will also be reflected in any editors for the field.
     *  @type {Alignment}
     *  @default null
     */
    open var cellAlign: 
                        /**
                         *  Center within container.
                         *  Stick to left side of container.
                         *  Stick to right side of container.
                         */
                        String /* center |  left |  right */ = definedExternally
    /**
     *  Custom base style to apply to all cells in this field instead of ListGrid.baseStyle
     *   To override the baseStyle at the row level, use
     *   ListGrid.recordBaseStyleProperty
     *   instead.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var baseStyle: String = definedExternally
    /**
     *  Enables or disables sorting by this column. If false, interactive
     *   sorting via header-clicks or menu-items will have no effect, but direct scripted calls
     *   to ListGrid.sort or ListGrid.setSort will work as
     *   expected.
     *  @type {boolean}
     *  @default true
     */
    open var canSort: Boolean = definedExternally
    /**
     *  Specifies the default sorting direction for this column. If specified on the
     *   ListGrid.sortField for the listGrid, sorting occurs
     *   automatically, otherwise this will be the default direction when the user clicks the
     *   field header, or calls ListGrid.sort without specifying an explicit sort
     *   direction.
     * 
     *   Overrides ListGrid.sortDirection
     *  @type {SortDirection}
     *  @default null
     */
    open var sortDirection: 
                            /**
                             *  Sort in ascending order (eg: A-Z, larger items later in the list)
                             *  Sort in descending order (eg: Z-A, larger items earlier in the list)
                             */
                            String /* ascending |  descending */ = definedExternally
    /**
     *  Should the cell content be natively selected (ready for copying to clip-board)
     *   on click?
     * 
     *   See ListGrid.selectCellTextOnClick for more information.
     *  @type {boolean}
     *  @default null
     */
    open var selectCellTextOnClick: Boolean = definedExternally
    /**
     *  Can this field be edited? May be overridden by setting the 'canEdit' property at the
     *   listGrid level. If not explicitly set and this grid is bound to a dataSource, the
     *   ListGrid.canEditFieldAttribute may be used to set default editability at the field level.
     * 
     *   For more dynamic control over whether fields can be edited, see
     *   ListGrid.canEditCell.
     * 
     * 
     *  @type {boolean}
     *  @default null
     */
    open var canEdit: Boolean = definedExternally
    /**
     *  If this field ListGridField.canEdit, this property can be used to
     *   specify a default value for this field's editor when adding new rows to the grid.
     *  @type {any}
     *  @default null
     */
    open var defaultValue: dynamic = definedExternally
    /**
     *  What to do when a user hits enter while editing this field?
     *   Overrides the enterKeyEditAction as specified at the listGrid level while
     *   focus is in this field.
     *  @type {EnterKeyEditAction}
     *  @default "done"
     */
    open var enterKeyEditAction: 
                                 /**
                                  *  end editing (will save edit values if ListGrid.autoSaveEdits is true).
                                  *  edit the next editable cell in the record
                                  *  edit the same field in the next editable record
                                  *  edit the first editable cell in next editable record
                                  */
                                 String /* done |  nextCell |  nextRow |  nextRowStart */ = definedExternally
    /**
     *  What to do when a user hits escape while editing this field?
     *   Overrides the escapeKeyEditAction as specified at the listGrid level while
     *   focus is in this field.
     *  @type {EscapeKeyEditAction}
     *  @default "cancel"
     */
    open var escapeKeyEditAction: 
                                  /**
                                   *  cancels the current edit and discards edit values
                                   *  end editing (will save edit values if ListGrid.autoSaveEdits is true).
                                   *  exit the editor (edit values will be left intact but not saved).
                                   *  do nothing special when the Escape key is pressed (ie, just ignore it)
                                   */
                                  String /* cancel |  done |  exit |  ignore */ = definedExternally
    /**
     *  Name of form item class to use for the form item created to edit this field.
     *     (Only used if this field is editable).
     *     Note: If this is not specified, the edit-form item type may be derived from the
     *     editorType property, typically inherited from datasource fields, or
     *     from the type of the field (showing the appropriate form item for
     *     the data-type). See the editing overview for more on editing ListGrid
     *     fields.
     *  @type {FormItemClassName}
     *  @default null
     */
    open var editorType: String = definedExternally
    /**
     *  Properties to apply the the form item created to edit this field. (Only used if
     *   this field is editable).
     * 
     *   For example, if you have a field "shoeSize" with DataSourceField.editorType set
     *   to "SpinnerItem" in order to use a SpinnerItem as your field editor, and you want to pass the
     *   SpinnerItem.step property to the created SpinnerItem:
     * 
     *    fields : [
     *      { name:"shoeSize", editorType:"SpinnerItem",
     *       editorProperties : { step:0.5 } },
     *      ... other fields ...
     *    ]
     * 
     *  @type {FormItem}
     *  @default null
     */
    open var editorProperties: FormItem = definedExternally
    /**
     *  In an editable ListGrid, initial value for this field when the user begins editing a new
     *   record.
     * 
     *   initialValue applies only if a new record is created by end user action (such
     *   as navigating past the end of the data when ListGrid.listEndEditAction is "next") or
     *   by a call to ListGrid.startEditingNew that does not specify the
     *   initialValues argument.
     *  @type {any}
     *  @default null
     */
    open var initialValue: dynamic = definedExternally
    /**
     *  Array of Validator objects for this field. When the user edits cells in
     *   this field, these validators will be applied to the edited value.
     *   Note: for databound listGrids, this property may be specified on the
     *   DataSourceField, enabling both client and server side validation.
     *  @type {Array<Partial<Validator>>}
     *  @default null
     */
    open var validators: Array<dynamic> = definedExternally
    /**
     *  If set to true, any ListGridField.validators for this field will be run whenever
     *   the value of the field is changed.
     * 
     *   Analogous to the FormItem.validateOnChange property.
     *  @type {boolean}
     *  @default null
     */
    open var validateOnChange: Boolean = definedExternally
    /**
     *  When the user edits cells in this field, is this value required to be non-empty
     *   in order for validation to pass.
     *   Note: for databound listGrids, this property may be specified on the
     *   DataSourceField, enabling both client and server side validation.
     *  @type {boolean}
     *  @default null
     */
    open var required: Boolean = definedExternally
    /**
     *  For fields of type "date", set this property to a valid
     *   DateDisplayFormat to specify how the date should be formatted.
     *   For fields of type "time", set this property to a valid
     *   TimeDisplayFormat to specify how the time should be formatted.
     *   If unset, display format may be set at the listGrid level via ListGrid.dateFormatter
     *   or ListGrid.timeFormatter.
     * 
     *   If this field is editable the displayFormat will also be passed to the editor created
     *   to edit this field. For dates you may also need to set ListGridField.inputFormat.
     *  @deprecated \* Use ListGridField.dateFormatter and ListGridField.timeFormatter instead.
     *  @type {any}
     *  @default null
     */
    open var displayFormat: dynamic = definedExternally
    /**
     *  Display format to use for date type values within this field.
     * 
     *   The ListGridField.timeFormatter may also be used to format underlying Date values as
     *   times (omitting the date part entirely). If both dateFormatter and
     *   timeFormatter are specified on a field, for
     *   fields specified as ListGridField.type the
     *   timeFormatter will be used, otherwise the dateFormatter
     * 
     *   If field.dateFormatter and field.timeFormatter is unspecified,
     *   date display format may be defined at the component level via
     *   ListGrid.dateFormatter, or for fields of type "datetime"
     *   ListGrid.datetimeFormatter. Otherwise the
     *   default is to use the system-wide default short date format, configured via
     *   DateUtil.setShortDisplayFormat. Specify any valid DateDisplayFormat to
     *   change the format used by this item.
     * 
     *   If this field is editable the dateFormatter will also be passed to the editor created
     *   to edit this field. Note that you can also specify an explicit ListGridField.inputFormat
     *   which will be passed through to the editor as well, though this is not typically required
     *   as the input format should be automatically derived by the SmartClient system
     *   for standard DateDisplayFormats.
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
     *   if no explicit ListGridField.dateFormatter is specified it will be respected for other
     *   fields as well.
     * 
     *   If unspecified, a timeFormatter may be defined
     *   ListGrid.timeFormatter and will be respected by fields
     *   of type "time".
     * 
     *   If this field is editable, the timeFormatter will also be passed to the editor created to
     *   edit this field as FormItem.timeFormatter.
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
     *  For fields of type "date" or "datetime", if this is an editable
     *   listGrid, this property allows you to specify the DateItem.inputFormat
     *   applied to the editor for this field.
     *  @type {DateInputFormat}
     *  @default null
     */
    open var inputFormat: String = definedExternally
    /**
     *  If set to true and ListGrid.canRemoveRecords is true, this field will be rendered
     *   as the remove-field for this grid. In most common usage scenarios this field will essentially
     *   be a placeholder indicating where the remove field should be rendered, meaning properties
     *   other than isRemoveField, such as name or title, may
     *   be left unset.
     *  @type {boolean}
     *  @default null
     */
    open var isRemoveField: Boolean = definedExternally
    /**
     *  If showing a filter row for this ListGrid, should the filter criteria for this
     *     field be editable
     *  @type {boolean}
     *  @default null
     */
    open var canFilter: Boolean = definedExternally
    /**
     *  If this listGrid is showing a filter row, this property can be used to specify a
     *   mapping of internal data to/from display values to be in the appropriate filter
     *   row form item.
     *  @type {object}
     *  @default null
     */
    open var filterEditorValueMap: dynamic = definedExternally
    /**
     *  If this ListGrid is showing a filter row, this property can be used to
     *     specify the form item class to use for the filter form item associated with this
     *     field
     *     (Only used if this field is not canFilter:false).
     *     Note: If this is not specified, the edit-form item type may be derived from the
     *     'editorType' property, typically inherited from datasource fields, or from the
     *     'type' of the field (showing the appropriate form item for the data-type).
     *  @type {FormItemClassName}
     *  @default null
     */
    open var filterEditorType: String = definedExternally
    /**
     *  If this ListGrid is showing a filter row, this property can be used to apply a default
     *   value to show in the filter editor for this field.
     *  @type {any}
     *  @default null
     */
    open var defaultFilterValue: dynamic = definedExternally
    /**
     *  If this ListGrid is showing a filter row
     *   (ListGrid.showFilterEditor:true), this property
     *   can be used to specify properties for the appropriate filter form item.
     *  @type {FormItem}
     *  @default null
     */
    open var filterEditorProperties: FormItem = definedExternally
    /**
     *  This value is managed by the menu item titled ListGrid.filterUsingText
     *   in the ListGrid.showHeaderContextMenu that appears when
     *   ListGrid.allowFilterOperators has been set to true.
     * 
     *   If you need to reset this filter operator you should call ListGrid.setFieldProperties, as in this example:
     * 
     *    listGrid.setFieldProperties(fieldName, {operator: null});
     * 
     *  @type {string}
     *  @default null
     */
    open var operator: String = definedExternally
    /**
     *  If we're showing the filterEditor (listGrid.showFilterEditor is true), this property
     *   determines whether this list should be filtered every time the user edits the value of
     *   the filter editor for this field.
     * 
     *   The ListGrid.fetchDelay governs the delay in milliseconds between the user editing the
     *   filter editor value, and the new filter being applied to the grid.
     *  @type {boolean}
     *  @default null
     */
    open var filterOnKeypress: Boolean = definedExternally
    /**
     *  Whether this field should be included in the printable representation of the grid.
     *  @type {boolean}
     *  @default null
     */
    open var shouldPrint: Boolean = definedExternally
    /**
     *  Whether to allow browser autoComplete when editing this field.
     * 
     *   If unset, defaults to listGrid.autoComplete
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
     *  By default HTML values in ListGrid cells will be interpreted by the browser.
     *   Setting this flag to true will causes HTML characters to be escaped, meaning the
     *   raw value of the field (for example "&lt;b&gt;AAA&lt;/b&gt;") is displayed
     *   to the user rather than the interpreted HTML (for example "AAA")
     *  @type {boolean}
     *  @default null
     */
    open var escapeHTML: Boolean = definedExternally
    /**
     *  The HTML to display in cells of this field if the fieldType is set to link.
     * 
     *   This property sets linkText that will be the same for all records. You can set linkText
     *   on a per-record basis via ListGridRecord.linkText.
     *  @type {string}
     *  @default null
     */
    open var linkText: String = definedExternally
    /**
     *  Name of the property in a ListGridRecord that holds the HTML to display in cells of this
     *   field if the fieldType is set to "link".
     *  @type {string}
     *  @default null
     */
    open var linkTextProperty: String = definedExternally
    /**
     *  If this field has type [ListGridFieldType] set to "link",
     *   setting this property will apply a standard prefix to the link URL for cells in this field.
     *  @type {string}
     *  @default null
     */
    open var linkURLPrefix: String = definedExternally
    /**
     *  If this field has type [ListGridFieldType] set to "link",
     *   setting this property will apply a standard suffix to the link URL for cells in this field.
     *  @type {string}
     *  @default null
     */
    open var linkURLSuffix: String = definedExternally
    /**
     *  Array of legal values for this field, or an Object where each property maps a stored
     *   value to a user-displayable value.
     *   Note that if this field is editable (see ListGrid.canEdit,
     *   ListGridField.canEdit), editors displayed for this field will pick up their
     *   valueMap either from this value or from ListGridField.editorValueMap.
     * 
     *   See also DataSourceField.valueMap.
     *  @type {object | Array<Partial<string>>}
     *  @default null
     */
    open var valueMap: dynamic = definedExternally
    /**
     *  If ListGridField.valueMap is set, and the grid is ListGrid.setSort
     *   by this field, should the data be sorted by the underlying data value or the
     *   mapped display value. If unset, will sort by display value. Set to false
     *   to sort by underlying data value. Note that this has no effect if
     *   a ListGridField.sortNormalizer has been specified.
     *  @type {boolean}
     *  @default null
     */
    open var sortByMappedValue: Boolean = definedExternally
    /**
     *  Indicates that this field should always be Array-valued. This property will be
     *   passed through to the generated edit-item when editing the field - so if
     *   ListGridField.valueMap is set, the default editor will be a SelectItem with
     *   SelectItem.multiple set to true.
     * 
     *   Note that for databound grids it typically makes sense to set DataSourceField.multiple
     *   rather than setting the property directly on the ListGridField object.
     *  @type {boolean}
     *  @default null
     */
    open var multiple: Boolean = definedExternally
    /**
     *  A valueMap to use for editors shown for this field. By default if this is not
     *   specified ListGridField.valueMap will be used instead.
     * 
     *   Dynamic valueMaps can be provided by implementing ListGrid.getEditorValueMap.
     *  @type {ValueMap}
     *  @default null
     */
    open var editorValueMap: dynamic = definedExternally
    /**
     *  The value to display for a cell whose value is null or the empty string after
     *   applying ListGridField.formatCellValue and valueMap (if any).
     * 
     *   This is the field-specific attribute. You may also set the emptyCellValue at the grid
     *   level to define the emptyCellValue for all empty fields in the grid.
     *  @type {HTMLString}
     *  @default "&amp;nbsp;"
     */
    open var emptyCellValue: String = definedExternally
    /**
     *  If true, automatically fetches records and derives a valueMap from
     *   ListGridField.optionDataSource.
     * 
     *   Same as ListGrid.autoFetchDisplayMap, but defined on a per-field basis.
     *  @type {boolean}
     *  @default null
     */
    open var autoFetchDisplayMap: Boolean = definedExternally
    /**
     *  If a ListGridField.displayField is set, should this field show record values from
     *   the displayField?
     * 
     *   If ListGridField.displayField is specified, and there is no separate
     *   ListGridField.optionDataSource, by default we will show display-field values
     *   from the same record. Setting this property to false would disable this behavior.
     * 
     *   Alternatively, if there is a ListGridField.optionDataSource (and
     *   ListGridField.autoFetchDisplayMap is false), the displayField would be ignored
     *   for the field and the underlying ListGridField.name would
     *   be displayed to the user. This property may be set to true to override this behavior and
     *   pick up values from the displayField for display in this field even when there
     *   is an optionDataSource set.
     * 
     *   Note that this property has no effect on fields with an explicitly specified valueMap, or
     *   with an optionDataSource where ListGridField.autoFetchDisplayMap is true.
     *  @type {boolean}
     *  @default null
     */
    open var displayValueFromRecord: Boolean = definedExternally
    /**
     *  For fields with an ListGridField.optionDataSource, where
     *   ListGridField.autoFetchDisplayMap is true, this property will govern
     *   the textMatchStyle attribute of the DSRequest parameter passed to
     *   DataSource.fetchData when retrieving the remote data set to be used as
     *   a basis for this field's valueMap.
     *  @type {TextMatchStyle}
     *  @default null
     */
    open var optionTextMatchStyle: 
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
     *  If this field has an optionDataSource specified and
     *   ListGridField.autoFetchDisplayMap is set, this attribute
     *   provides a way to customize the dataSource request issued to fetch the display map from
     *   the option dataSource. This provides, among other capabilities, a way to trigger the
     *   server to return summary records.
     *  @type {DSRequest}
     *  @default null
     */
    open var optionFilterContext: DSRequest = definedExternally
    /**
     *  If this field has an optionDataSource specified and
     *   ListGridField.autoFetchDisplayMap is set, this attribute
     *   provides a way to customize the DSRequest.operationId passed to
     *   dataSource.fetchData() when retrieving the display map from the option
     *   dataSource.
     *  @type {string}
     *  @default null
     */
    open var optionOperationId: String = definedExternally
    /**
     *  Derive a ValueMap by fetching records from another DataSource and extracting
     *   the ListGridField.valueField and
     *   ListGridField.displayField in the loaded records, to derive one
     *   valueMap entry per record loaded from the optionDataSource.
     * 
     *   Unlike the similar use of PickList.optionDataSource for PickList
     *   used during editing or filtering, listGridField.optionDataSource causes the
     *   entire set of records from the optionDataSource to be fetched, without paging.
     *   Hence listGridField.optionDataSource is appropriate only for smaller valueMaps. For very
     *   large valueMap situations, such as an accountId field that should be displayed as an
     *   accountName where there are thousands of accounts, the correct approach is:
     * 
     * 
     *  - do not set listGridField.optionDataSource
     * 
     *  - declare two fields in the DataSource, eg "accountId" and "accountName".
     * 
     *  - Set the ListGridField.displayField attribute on the data field to the
     *     name of the display field.
     * 
     *  - When fetching records for display in a grid, have your server send back values for
     *     both fields, but show only the data field ("accountId") in the grid.
     * 
     *   In this case the cells in the accountId field will show the record value from the
     *   accountName field. This approach means the valueMap will never be loaded in its
     *   entirety, instead, each loaded record contains the valueMapping for that one record, as
     *   a pair of fields within the record.
     * 
     *   If you are using the SmartClient Server Framework with the SQL or JPA/Hibernate built-in
     *   connectors, this entire approach can be achieved very easily using the
     *   DataSourceField.includeFrom setting - see the
     *   DataSourceField.includeFrom for details.
     * 
     *   Notes:
     * 
     * 
     *  - When using the above approach, it is key that the server return both
     *   the underlying stored value and the display value, as suggested above.
     *   This approach allows the PickList.optionDataSource property to be used to
     *   provide paged valueMaps during inline editing and
     *   ListGrid.showFilterEditor. This can be achieved by setting the
     *   optionDataSource attribute on the form item used to edit the field
     *   via ListGridField.editorProperties (for editing) or
     *   ListGridField.filterEditorProperties (for
     *   filtering), without specifying an optionDataSource at the listGridField level.
     *   Alternatively developers can use ListGridField.autoFetchDisplayMap to
     *   suppress the fetch against the optionDataSource at the listGrid level.
     * 
     *  - Setting listGridField.optionDataSource to the same dataSource as the
     *   listGrid is not the same as omitting the optionDataSource setting entirely. Unless
     *   ListGridField.autoFetchDisplayMap has been set to explicitly disable fetching,
     *   a fetch will be performed against the dataSource to build a valueMap which will be used
     *   as the definitive mapping from data to display values, rather than picking up the display
     *   values from the records themselves. This distinction is required to support cases where
     *   the ListGridField.valueField points to a different field in the grid (useful for
     *   hierarchical relationships, for example), or where ListGridField.optionCriteria or
     *   ListGridField.optionOperationId are specified and return different data from
     *   the records displayed within the grid.
     * 
     *  - If a displayField is specified, with no associated optionDataSource, and the field is
     *   editable, updating the edit value for the field may not automatically update the displayField
     *   edit value, meaning the user may not realize the edit value has been modified.
     *   If the new value came from the user editing the field, and the edit item has
     *   a valueMap or optionDataSource specified, the display value is picked up automatically and
     *   stored out on the displayField for the record. However if the value was set programmatically,
     *   the developer should also set the edit value for the display field to ensure the displayed
     *   value reflects the new edit value. Note that when this occurs, a warning will be logged
     *   which can be disabled via ListGrid.warnOnUnmappedValueFieldChange.
     * 
     *  - For very advanced usage a developer can use ListGridField.displayValueFromRecord
     *   to explicitly tell the grid whether or not to display the display field value for the record
     *   in this field when a displayField is specified. See documentation on that property for more
     *   information
     * 
     *  @type {string}
     *  @default null
     */
    open var optionDataSource: dynamic = definedExternally
    /**
     *  Specifies the ListGridField.optionDataSource field used to retrieve the stored
     *   values that are to be mapped to the display values (specified by
     *   ListGridField.displayField). Note that if this field is editable this will also
     *   be applied to this field's editors.
     *  @type {string}
     *  @default null
     */
    open var valueField: String = definedExternally
    /**
     *  Specifies the ListGridField.optionDataSource field used to retrieve the display
     *   values that are to be mapped from the internal values specified by ListGridField.valueField.
     * 
     *   If no optionDataSource is defined for the field, the cell will display
     *   the displayField value for the current record instead of the underlying value for
     *   this field. This approach can be used for situations where field values need a stored
     *   value to displayed value mapping, but the set of all possible values is too large to
     *   load as a ValueMap - see ListGridField.optionDataSource for more details
     *   on this approach. Note that if this field is editable this will also be applied to this
     *   field's editors. ${isc.DocUtils.linkForExampleId('largeValueMapSQL', 'This sample')} illustrates this
     *   approach achieved via a server-side SQL join.
     * 
     *   The display value for a record with a specified displayField can be
     *   picked up via ListGrid.getDisplayValue.
     *  @type {string}
     *  @default null
     */
    open var displayField: String = definedExternally
    /**
     *  For a field with displayField configured, should client-side sorting
     *   be performed on the display field value? Unless explicitly set to false
     *   the display field value is used.
     *  @type {boolean}
     *  @default null
     */
    open var sortByDisplayField: Boolean = definedExternally
    /**
     *  If ListGridField.optionDataSource is set for this ListGridField, criteria specified in this
     *   attribute will be passed to the dataSource when performing the fetch operation to
     *   determine data-value to display-value mappings
     *  @type {Criteria}
     *  @default null
     */
    open var optionCriteria: dynamic = definedExternally
    /**
     *  Indicates this field's values should be fetched from another, related DataSource.
     *   The individual field will inherit settings such as ListGridField.type
     *   and ListGridField.title from the related DataSource just like
     *   fields from the primary DataSource.
     * 
     *   When ListGrid.fetchData is called, the automatically created DSRequest will
     *   specify DSRequest.additionalOutputs requesting the field, and any Criteria
     *   generated by the component will likewise refer to the field from the related DataSource.
     * 
     *   It's an error to use this property if the ListGrid does not have a DataSource at all.
     *   The related DataSource must be loaded or a warning will be logged and the field
     *   definition ignored.
     * 
     *   This value is expected to be set to the following format
     *   dataSourceID.fieldName where dataSourceID is the ID of the
     *   related dataSource and fieldName is the name of the field from that dataSource
     *   from which you wish to retrieve values. Note that if this property is set and
     *   ListGridField.name is not explicitly specified, this field's name will
     *   default to the fieldName value from this property.
     * 
     *   Note about automatic cache updates: "update" and "add" operations
     *   submitted automatically by this ListGrid will include
     *   dsRequest.additionalOutputs to ensure all data necessary
     *   for cache updates is returned by the server.
     * 
     *   If your grid shows data that can be edited elsewhere in the UI (not by
     *   inline editing), to avoid problems with ResultSet automatic
     *   cache synchronization, you may need to switch from using
     *   listGridField.includeFrom to
     *   dataSourceField.includeFrom. This is because
     *   server responses to "add" and "update" operations which are initiated
     *   outside of this grid do not know about the
     *   listGridField.includeFrom setting, and so will not
     *   automatically return data for fields included in this way. Switching
     *   to dataSourceField.includeFrom ensures the field is
     *   always included in server responses, avoiding the issue.
     *  @type {string}
     *  @default null
     */
    open var includeFrom: String = definedExternally
    /**
     *  Should the user be allowed to perform one-time autofitting of this field via
     *   a header context-menu option?
     * 
     *   When enabled, the default header context menu for this field will
     *   include an item to auto-fit the field and users will be able to autofit the field
     *   via the ListGrid.headerAutoFitEvent.
     * 
     *   If unset, these behaviors are enabled when ListGrid.canAutoFitFields is true.
     * 
     *   If this property is set to false, and ListGrid.canAutoFitFields is true,
     *   this field will be ommitted from auto-fit when the user selects the header menu
     *   option to ListGrid.autoFitAllText.
     * 
     *   Note - this property governs user-initiated auto-fit only. It has no impact on
     *   autoFit set up via ListGridField.autoFitWidth and ListGrid.autoFitFieldWidths.
     * 
     *   Note that if ListGrid.showRecordComponents, per-cell record
     *   components are not taken into account when determining the size for column auto fit.
     *   The default ListGrid.getDefaultFieldWidth implementation looks at cell content
     *   only. We typically recommend that, for fields showing record-components,
     *   ListGridField.autoFitWidth and ListGrid.canAutoFitFields be disabled, or if
     *   the record components are of a predictable size, a ListGridField.defaultWidth
     *   be specified.
     *   This is particularly pertinent where ListGrid.recordComponentPosition
     *   is set to "within", in which case cells' content is often empty or completely covered
     *   by record-components.
     *  @type {boolean}
     *  @default null
     */
    open var canAutoFitWidth: Boolean = definedExternally
    /**
     *  Should this listGrid field autofit its width to either titles or content?
     * 
     *   This overrides the ListGrid.autoFitFieldWidths attribute on a per-field basis.
     * 
     *   Note that if ListGrid.showRecordComponents, per-cell record
     *   components are not taken into account when determining the size for column auto fit.
     *   The default ListGrid.getDefaultFieldWidth implementation looks at cell content
     *   only. We typically recommend that, for fields showing record-components,
     *   ListGridField.autoFitWidth and ListGridField.canAutoFitWidth be disabled, or if
     *   the record components are of a predictable size, a ListGridField.defaultWidth
     *   be specified.
     *   This is particularly pertinent where ListGrid.recordComponentPosition
     *   is set to "within", in which case cells' content is often empty or completely covered
     *   by record-components.
     *  @type {boolean}
     *  @default null
     */
    open var autoFitWidth: Boolean = definedExternally
    /**
     *  Optional "default width" for this field. If set, this value will be returned by the
     *   ListGrid.getDefaultFieldWidth method, and used as the autoFit size for
     *   the field's content.
     *  @type {Integer}
     *  @default null
     */
    open var defaultWidth: Number = definedExternally
    /**
     *  When a user requests column autofitting via the
     *   ListGrid.getHeaderContextMenuItems or via a
     *   ListGrid.headerAutoFitEvent, what autofit approach is used. If set, this
     *   setting overrides the autoFitWidthApproach specified at the ListGrid level.
     *  @type {AutoFitWidthApproach}
     *  @default null
     */
    open var autoFitWidthApproach: 
                                   /**
                                    *  Size field to fit to the data value(s) contained in the field.
                                    *  Size field to fit the field title
                                    *  Size field to fit either the field title or the data values in the field (whichever requires more space).
                                    */
                                   String /* value |  title |  both */ = definedExternally
    /**
     *  If set to true, custom HTML applied as part of hiliting will be applied after
     *   ListGrid.formatCellValue for each cell in this column. If false, hilite
     *   HTML will be applied before formatting.
     * 
     *   This attribute overrides ListGrid.hiliteHTMLAfterFormat as defined at the
     *   component level.
     *  @type {boolean}
     *  @default null
     */
    open var hiliteHTMLAfterFormat: Boolean = definedExternally
    /**
     *  Whether to show hovers for this field. The default hover will be the contents of the
     *   cell the user is hovering over, and can be customized via
     *   ListGridField.hoverHTML.
     * 
     *   ListGrid.canHover can be set to true to cause hovers to be shown for all fields
     *   by default. In this case, field.showHover can be set to false to suppress
     *   hovers for an individual field.
     * 
     *   All hovers can be disabled, regardless of other settings, by setting
     *   ListGrid.showHover to false.
     *  @type {boolean}
     *  @default null
     */
    open var showHover: Boolean = definedExternally
    /**
     *  When set to true and showHover is also true for the field, shows a widget hovering at
     *   the mouse point.
     * 
     *   A number of builtin modes are provided - see HoverMode.
     * 
     *   Also supported at the ListGrid.showHoverComponents.
     *  @type {boolean}
     *  @default null
     */
    open var showHoverComponents: Boolean = definedExternally
    /**
     *  Causes a tooltip hover to appear on the header generated for this field (effectively
     *   sets Canvas.prompt for the header).
     *  @type {HTMLString}
     *  @default null
     */
    open var prompt: String = definedExternally
    /**
     *  Per-field setting for ListGrid.allowFilterOperators. Can be used to enable
     *   the filter operators UI for a particular field if the ListGrid-level setting is not
     *   enabled, or to disable filter operators for a particular field if the ListGrid-level setting
     *   is enabled.
     *  @type {boolean}
     *  @default null
     */
    open var allowFilterOperators: Boolean = definedExternally
    /**
     *  Field-level setting for ListGrid.allowFilterExpressions:true - controls whether search
     *   expressions can be entered directly into the filter item for this field. You can also have
     *   parsing of the expression remove the operator symbol and apply it to an
     *   ListGrid.allowFilterOperators in the editor.,
     * 
     *   This attribute can also be set at the ListGrid.allowFilterExpressions.
     *  @type {boolean}
     *  @default null
     */
    open var allowFilterExpressions: Boolean = definedExternally
    /**
     *  Per-field setting for ListGrid.alwaysShowOperatorIcon. Can be used to force a particular
     *   field to always show it's ListGrid.operatorIcon, even if it has no
     *   filter-value, or is using the default ListGridField.filterOperator.
     *  @type {boolean}
     *  @default null
     */
    open var alwaysShowOperatorIcon: Boolean = definedExternally
    /**
     *  With the ListGrid.showFilterEditor showing, the Operator to
     *   use when matching values for this field.
     * 
     *   Note that you can set all FilterEditor fields to default to either substring or exact
     *   match via ListGrid.autoFetchTextMatchStyle, but if you
     *   want a mix of exact vs substring match on different fields, you need to use this
     *   property, and your ListGrid will produce AdvancedCriteria rather than the
     *   simpler Criteria format. This is automatically and transparently handled by the
     *   SmartClient Server's SQLDataSource and HibernateDataSource in Power Edition or above,
     *   but if you have your own filtering implementation, it will need to be able to handle
     *   AdvancedCriteria.
     *  @type {OperatorId}
     *  @default null
     */
    open var filterOperator: 
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
     *  Allows a boolean or ValueMap field to be edited without going into
     *   edit mode. When this attribute is set, clicking on the field will change the value - for
     *   boolean fields toggling between true and false, and for valueMapped
     *   fields, advancing the value to the next option in the valueMap.
     * 
     *   To enable this feature, ListGrid.canEdit must be set to true.
     *   For boolean type fields canToggle is true by default, meaning setting
     *   canEdit to true implies the user can toggle the value via a single click
     *   without going into edit mode. You can disable this by explicitly setting
     *   canToggle to false for a boolean field.
     *   Note that you can enable toggling only (without allowing the user to edit other fields)
     *   by just setting ListGrid.editEvent.
     * 
     *   If ListGrid.editEvent is set to "click", when the user clicks on the field,
     *   the value will be toggled, and inline editing will be triggered as usual.
     *   Otherwise the toggled value will be saved immediately to the server, or if
     *   ListGrid.autoSaveEdits has been set to false, will be stored as an edit value
     *   for the record.
     *  @type {boolean}
     *  @default "varies"
     */
    open var canToggle: Boolean = definedExternally
    /**
     *  If ListGrid.showHeaderMenuButton is true, when auto-fitting fields to
     *   the title width via ListGrid.autoFitFieldWidths or ListGridField.autoFitWidth,
     *   should the button be sized such that there is enough space for the header menu button to
     *   show without covering the field title?
     * 
     *   May be explicitly specified at the ListGridField.leaveHeaderMenuButtonSpace
     *   or at the ListGrid.leaveHeaderMenuButtonSpace. If not explicitly
     *   specified space will be left for fields with
     *   ListGridField.align set to "left" or "right", but not for
     *   fields with align set to "center".
     *  @type {boolean}
     *  @default null
     */
    open var leaveHeaderMenuButtonSpace: Boolean = definedExternally
    /**
     *  Delay in ms for hovers shown for cells in this field. If unset, the grid's
     *   hoverDelay will be used.
     * 
     *   This property also governes the hoverDelay for the header button. Developers wishing
     *   to have a different delay for hovers on the header can use ListGridField.headerHoverDelay
     *   in addition to this property.
     *  @type {Integer}
     *  @default null
     */
    open var hoverDelay: Number = definedExternally
    /**
     *  Delay in ms for hovers shown over this field's header.
     * 
     *   If unset, any ListGridField.hoverDelay will be used for both header hovers
     *   and hovers shown over cells in the grid's body.
     *  @type {Integer}
     *  @default null
     */
    open var headerHoverDelay: Number = definedExternally
    /**
     *  When set to false, don't apply alternate-row styling to this field.
     *  @type {boolean}
     *  @default null
     */
    open var showAlternateStyle: Boolean = definedExternally
    /**
     *  Formula definition for this field.
     * 
     *   Advanced applications that wish to save formulas separately from a grid's
     *   ListGrid.getViewState can provide a UserFormula as part of the field
     *   definition, and may subsequently access the formula is updated via the
     *   ListGrid.formulaUpdated notification.
     *  @type {UserFormula}
     *  @default null
     */
    open var userFormula: UserFormula = definedExternally
    /**
     *  Can formula be edited from header context menu? Setting attribute to
     *   false prevents editing. A null or true
     *   value allows editing.
     * 
     *   Has no effect when ListGrid.canAddFormulaFields is false.
     *  @type {boolean}
     *  @default null
     */
    open var canEditFormula: Boolean = definedExternally
    /**
     *  Shortcut to configure a FormItem.formula for the ListGridField.editorType used when this
     *   field is ListGrid.canEdit.
     *  @type {UserFormula}
     *  @default null
     */
    open var editorFormula: UserFormula = definedExternally
    /**
     *  Shortcut to configure a FormItem.textFormula for the ListGridField.editorType used when this
     *   field is ListGrid.canEdit.
     *  @type {UserSummary}
     *  @default null
     */
    open var editorTextFormula: UserSummary = definedExternally
    /**
     *  Summary definition for this field.
     * 
     *   Advanced applications that wish to save summaries separately from a grid's
     *   ListGrid.getViewState can provide a UserSummary as part of the
     *   field definition, and may subsequently access the summary is updated via the
     *   ListGrid.summaryUpdated notification.
     *  @type {UserSummary}
     *  @default null
     */
    open var userSummary: UserSummary = definedExternally
    /**
     *  Can summary be edited from header context menu? Setting attribute to
     *   false prevents editing. A null or true
     *   value allows editing.
     * 
     *   Has no effect when ListGrid.canAddSummaryFields is false.
     *  @type {boolean}
     *  @default null
     */
    open var canEditSummary: Boolean = definedExternally
    /**
     *   Return the value which records should be grouped by.
     * 
     *   All records for which getGroupValue() returns the same value appear in the same
     *   group. Default is the result of ListGrid.getCellValue.
     * 
     *   While any type of value may be returned, avoiding the use of string values may
     *   result in improved performance. In this case, ListGridField.getGroupTitle
     *   may be implemented to map a numeric group value into a legible string.
     * 
     * 
     *  @param {any} raw value for the cell, from the record for the row
     *  @param {ListGridRecord} Record object for the cell. Note: If this is a new row that has not been saved, in an  editable grid, it has no associated record object. In this case the edit values will  be passed in as this parameter (see ListGrid.getEditValues)
     *  @param {object} Field object for which to get group value
     *  @param {string} The name of the field
     *  @param {ListGrid} the ListGrid displaying the cell
     */
    open fun getGroupValue(value: dynamic, record: ListGridRecord, field: dynamic, fieldName: String, grid: ListGrid): dynamic = definedExternally
    /**
     *   Return the title that should be shown to the user for the group with the
     *   groupValue passed as a parameter.
     * 
     *   Default title is the groupValue itself.
     * 
     * 
     *  @param {any} the value from the group is created, the result of ListGridField.getGroupValue
     *  @param {GroupNode} the node in the grid containing the group.
     *  @param {object} Field object for which to get group value
     *  @param {string} The name of the field
     *  @param {ListGrid} the ListGrid displaying the cell
     */
    open fun getGroupTitle(groupValue: dynamic, groupNode: GroupNode, field: dynamic, fieldName: String, grid: ListGrid): dynamic = definedExternally
    /**
     * 
     *   Executed when the user clicks on a ListGridField.valueIcons within
     *   this field. Return false to suppress default behavior of firing ListGridField.recordClick
     *   handlers, etc.
     * 
     * 
     *  @param {ListGrid} the listGrid that contains the click event
     *  @param {ListGridRecord} the record that was clicked on
     *  @param {number} number of the record clicked on in the current set of                 displayed records (starts with 0)
     *  @param {ListGridField} the field that was clicked on (field definition)
     *  @param {any} raw value of the cell (before valueMap, etc applied)
     *  @param {FormItem} If this cell is being ListGrid.canEdit,  this method will fire when the user clicks the valueIcon on the edit item for the  cell, passing in the editor item as the editor parameter. If the cell  is not being edited, this value will be null.
     */
    open fun valueIconClick(viewer: ListGrid, record: ListGridRecord, recordNum: Number, field: ListGridField, rawValue: dynamic, editor: FormItem): Boolean = definedExternally
    /**
     *   If your derivation of the field title is more complex than specifying a static string,
     *   you can specify a getFieldTitle() method on your field to return the title string.
     *   Otherwise you can use the ListGridField.title attribute on the field to specify the title.
     * 
     *   You can use ListGrid.setFieldProperties to dynamically
     *   update the title.
     * 
     * 
     *  @param {ListGrid} pointer back to the ListGrid
     *  @param {number} index of this field in the grid's fields array.
     */
    open fun getFieldTitle(viewer: ListGrid, fieldNum: Number): String = definedExternally
    /**
     *   An optional stringMethods which if provided, is evaluated to
     *   conditionally determine whether this field should be displayed.
     *   Evaluated on initial draw, then reevaluated on explicit
     *   calls to listGrid.refreshFields() or listGrid.setFields().
     * 
     *   Use ListGridField.hidden:true or showIf:"false"
     *   to set a ListGrid field to initially hidden.
     *   The user will still be able to show the field via a context menu.
     *   This may be suppressed by setting ListGridField.canHide to false, or by
     *   setting ListGrid.canPickFields to false to suppress the
     *   field-picker entirely.
     * 
     *   Note that explicit calls to ListGrid.showField or hideField()
     *   will wipe out the showIf expression, as will the end user showing and
     *   hiding columns via the ListGrid.showHeaderContextMenu.
     * 
     *   Also note that fields marked as DataSourceField.detail will be hidden by
     *   default even if ListGrid.showDetailFields is true. To show detail fields
     *   inherited from a DataSource, include an explicit field definition for the field and
     *   set this property to return true.
     * 
     * 
     *  @param {ListGrid} A pointer to the listGrid containing the field
     *  @param {ListGridField} the ListGridField object
     *  @param {Integer} the index of the field
     */
    open fun showIf(list: ListGrid, field: ListGridField, fieldNum: Number): Boolean = definedExternally
    /**
     *   When a field has ListGridField.autoFreeze set to true, developers can
     *   implement this method to indicate where in the frozen-fields array this field should
     *   appear.
     * 
     *   Some automatically generated fields, such as
     *   ListGrid.rowNumberField,
     *   ListGrid.expansionField and
     *   ListGrid.checkboxField, provide default implementations of this
     *   method.
     * 
     */
    open fun getAutoFreezePosition(): Number = definedExternally
    /**
     *   If ListGrid.showGridSummary is true, and this method is specified it will be
     *   called to generate the summary value to be displayed in the grid summary row. Note that
     *   this is called instead of making use of the ListGridField.summaryFunction.
     * 
     *   As with ListGrid.getGridSummary this method may return an array of results -
     *   in this case each result will show up in a separate row in the ListGrid.summaryRow
     *   grid.
     * 
     *   If this grid is grouped, and ListGrid.showGroupSummary is true, this method
     *   will be passed a third parameter - an array of group-level summaries.
     * 
     *  @param {Array<Partial<ListGridRecord>>} records for which a summary is being generated
     *  @param {ListGridField} pointer to the field for which summary value is being generated
     *  @param {Array<Partial<object>>=} If this grid is grouped and ListGrid.showGridSummary is specified, this parameter contains an array of already-  calculated summary values for each group in the grid. Each element in this array will  be an object containing calculated summary values for each field in the grid, as well as  a specified groupValue and groupName, allowing the developer to determine which group this  summary value comes from
     */
    open fun getGridSummary(records: Array<dynamic>, field: ListGridField, groupSummaries: Array<dynamic>?): dynamic = definedExternally
    /**
     *   If ListGrid.showGroupSummary is true, and this method is specified it will be
     *   called to generate the field summary value to be displayed for each group level summary row.
     *   Note that this is called instead of making use of the ListGridField.summaryFunction.
     * 
     *   This method may return an array of results - in this case the group will show multiple summary
     *   rows, with each entry in the array showing up in a different record.
     * 
     * 
     *  @param {Array<Partial<ListGridRecord>>} records for which a summary is being generated (so all records in the group).
     *  @param {ListGridField} pointer to the field for which summary value is being generated
     *  @param {object=} object with specified groupValue and groupName for this group
     */
    open fun getGroupSummary(records: Array<dynamic>, field: ListGridField, groupNode: dynamic?): dynamic = definedExternally
    /**
     *   Only applies to ListGridFieldType fields. If specified, this
     *   method will be called to generate the record summary value to be displayed for each row
     *   in this field. When this method is called, current values for other
     *   ListGridFieldType fields have not yet been stored on the record, but
     *   are accessible via ListGrid.getRecordSummary.
     * 
     *   Note that if specified, this is called instead of making use of the
     *   ListGridField.recordSummaryFunction.
     * 
     *   If ListGrid.showGridSummary or ListGrid.showGroupSummary is true, this
     *   field's value in the summary row[s] will still be calculated by calling this method.
     *   In this case, the record object passed in will contain summary values for each field.
     *   If custom handling is required for this case, it may be detected by checking the
     *   record object's ListGridRecord.isGroupSummary and ListGridRecord.isGridSummary
     *   attributes.
     * 
     *  @param {ListGridRecord} record for which a summary is being generated
     *  @param {ListGridField} this field
     *  @param {ListGrid} the grid
     */
    open fun getRecordSummary(record: ListGridRecord, field: ListGridField, grid: ListGrid): dynamic = definedExternally
    /**
     *   Optional string method to return a long summary title for this field, if a dynamic
     *   summary title is required for this field.
     * 
     * 
     *  @param {ListGrid} pointer back to the ListGrid
     *  @param {ListGridField} pointer to the field object
     *  @deprecated \* Rather than customizing the summaryTitle developers should typically use the ListGridField.headerTitle attribute to show a different
     *   title in the column header button than the title used elsewhere.
     */
    open fun getSummaryTitle(viewer: ListGrid, field: ListGridField): Unit = definedExternally
    /**
     *   Optional function to return the value that should be used when sorting this field.
     * 
     *   Note that, if the dataset exceeds ListGrid.dataPageSize and hence paging is
     *   introduced, the grid relies on the server to provide sorting, and the sortNormalizer
     *   will no longer be called.
     * 
     *   For custom sort orders that can be executed both client and server, consider
     *   DataSourceField.sortByField.
     * 
     * 
     *  @param {object} record to normalize
     *  @param {string} name of the field on which sorting occurred
     *  @param {ListGrid} A pointer back to the list grid displaying this field will  be available as the context argument. Note that you can also get a pointer  to the field definition object by calling context.getField(fieldName)
     */
    open fun sortNormalizer(recordObject: dynamic, fieldName: String, context: ListGrid): dynamic = definedExternally
    /**
     *   If this field ListGridField.canEdit, this property can be used to
     *   set a dynamic default value which will show up in editors for this field.
     *   Will be applied to the editor for the field as FormItem.defaultDynamicValue
     * 
     * 
     *  @param {FormItem} The editor for the cell itself (also available as "this").               Note that in addition to the standard FormItem APIs available                on the editor, it also has:                - a pointer back to the containing listGrid                [item.grid]                - the colNum being edited [item.colNum]                - the rowNum being edited [item.rowNum]
     *  @param {DynamicForm} the managing DynamicForm instance
     *  @param {object} the current set of values for the form as a whole
     */
    open fun defaultDynamicValue(item: FormItem, form: DynamicForm, values: dynamic): Unit = definedExternally
    /**
     *   Callback fired when the user first starts editing a cell.
     * 
     *   This callback is typically used to establish dynamic default values via
     *   ListGrid.setEditValue or ListGrid.setEditValues.
     * 
     * 
     *  @param {ListGridRecord} record for the cell being edited. Will be null                for a new, unsaved record.
     *  @param {any} value for the cell being edited
     *  @param {Integer} row number for the cell
     *  @param {Integer} column number of the cell
     *  @param {ListGrid} ListGrid to which this field belongs
     */
    open fun editorEnter(record: ListGridRecord, value: dynamic, rowNum: Number, colNum: Number, grid: ListGrid): Unit = definedExternally
    /**
     *   Callback fired when the user attempts to navigate away from the current edit cell,
     *   or complete the current edit.
     *   Return false from this method to cancel the default behavior (Saving / cancelling the
     *   current edit / moving to the next edit cell)
     * 
     * 
     *  @param {EditCompletionEvent} What interaction triggered this                             edit cell exit
     *  @param {ListGridRecord} record for the cell being edited
     *  @param {any} new value for the cell being edited
     *  @param {Integer} row number for the cell
     *  @param {Integer} column number of the cell
     *  @param {ListGrid} ListGrid to which this field belongs
     */
    open fun editorExit(editCompletionEvent: 
                                             /**
                                              *  User clicked outside editor during edit.
                                              *  User started editing another row by clicking on it
                                              *  User started editing another row by double                clicking
                                              *  Enter pressed.
                                              *  User pressed Escape.
                                              *  Up arrow key pressed.
                                              *  down arrow key.
                                              *  User pressed Tab.
                                              *  User pressed Shift+Tab.
                                              *  Edit moved to a different field (same row)
                                              *  Edit completed via explicit function call
                                              */
                                             String /* click_outside |  click |  doubleClick |  enter |  escape |  arrow_up |  arrow_down |  tab |  shift_tab |  field_change |  programmatic */, record: ListGridRecord, newValue: dynamic, rowNum: Number, colNum: Number, grid: ListGrid): Boolean = definedExternally
    /**
     *   Callback fired when field changes value as the result of a cell edit. Fired only on
     *   successful save of edit, when the new value doesn't match the value before editing.
     * 
     *   Same signature as ListGrid.cellChanged, but defined on a per-field
     *   basis.
     * 
     * 
     *  @param {ListGridRecord} record for the cell being changed
     *  @param {any} new value for the cell
     *  @param {any} old value for the cell
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     *  @param {ListGrid} grid where cell was changed.
     */
    open fun cellChanged(record: ListGridRecord, newValue: dynamic, oldValue: dynamic, rowNum: Number, colNum: Number, grid: ListGrid): Unit = definedExternally
    /**
     * 
     *   Executed when this field is clicked on. Note that if ListGrid.recordClick is
     *   also defined, it will be fired for fields that define a recordClick handler if the
     *   field-level handler returns true. Return false to prevent the grid-level handler from firing.
     * 
     * 
     *  @param {ListGrid} the listGrid that contains the click event
     *  @param {ListGridRecord} the record that was clicked on
     *  @param {number} number of the record clicked on in the current set of                 displayed records (starts with 0)
     *  @param {ListGridField} the field that was clicked on (field definition)
     *  @param {number} number of the field clicked on in the listGrid.fields                 array
     *  @param {any} value of the cell (after valueMap, etc. applied)
     *  @param {any} raw value of the cell (before valueMap, etc applied)
     */
    open fun recordClick(viewer: ListGrid, record: ListGridRecord, recordNum: Number, field: ListGridField, fieldNum: Number, value: dynamic, rawValue: dynamic): Boolean = definedExternally
    /**
     * 
     *   Executed when this field is double-clicked. Note that if
     *   ListGrid.recordDoubleClick is also defined, it will be fired for fields that define
     *   a recordDoubleClick handler if the field-level handler returns true. Return false to prevent
     *   the grid-level handler from firing.
     * 
     * 
     * 
     *  @param {ListGrid} the listGrid that contains doubleclick event
     *  @param {ListGridRecord} the record that was double-clicked
     *  @param {number} number of the record clicked on in the current set of                 displayed records (starts with 0)
     *  @param {ListGridField} the field that was clicked on (field definition)
     *  @param {number} number of the field clicked on in the listGrid.fields                 array
     *  @param {object} value of the cell (after valueMap, etc. applied)
     *  @param {object} raw value of the cell (before valueMap, etc applied)
     */
    open fun recordDoubleClick(viewer: ListGrid, record: ListGridRecord, recordNum: Number, field: ListGridField, fieldNum: Number, value: dynamic, rawValue: dynamic): Boolean = definedExternally
    /**
     *   A stringMethod which returns the cell value to display for this field for some record.
     *   If defined, called by ListGrid.getCellValue(). Called in the scope of the field object.
     * 
     *   Deprecated as of Jan 12 05 in favor of ListGridField.formatCellValue, because
     *   'getCellValue()' is a lower-level API which handles (for example) returning the HTML
     *   for editors within the cell.
     * 
     * 
     *  @param {ListGrid} the ListGrid for which we're returning a cellValue
     *  @param {object} the current record object
     *  @param {number} row-index of the current record
     *  @param {ListGridField} current field object
     *  @param {number} column-index of the current field
     *  @param {any} unformatted value for this field, determined via             ListGrid.getRawCellValue()
     *  @deprecated \* As of SmartClient 5.5, use ListGridField.formatCellValue.
     */
    open fun getCellValue(viewer: ListGrid, record: dynamic, recordNum: Number, field: ListGridField, fieldNum: Number, value: dynamic): dynamic = definedExternally
    /**
     *   Return the HTML to display in cells of this field.
     * 
     *   Given the raw value for this field as taken from the record Formatter to apply to the
     *   static values displayed in cells for this field.
     * 
     *   Example usage: formatting a currency value stored in cents (so "100" to "$1.00")
     *   The value passed to this method is the raw value for the cell.
     *   Takes precedence over formatCellValue defined at the grid level for cells
     *   in this field.
     * 
     *   Note: this formatter will not be applied to the values displayed in cells being edited.
     *   The ListGridField.formatEditorValue is provided for that purpose.
     * 
     * 
     *  @param {any} raw value for the cell, from the record for the row
     *  @param {ListGridRecord} Record object for the cell. Note: If this is a new row that has not been saved, in an  editable grid, it has no associated record object. In this case the edit values will  be passed in as this parameter (see ListGrid.getEditValues)
     *  @param {number} row number for the cell
     *  @param {number} column number for the cell.
     *  @param {ListGrid} the ListGrid displaying the cell
     */
    open fun formatCellValue(value: dynamic, record: ListGridRecord, rowNum: Number, colNum: Number, grid: ListGrid): String = definedExternally
    /**
     *   Field-level formatter for inactive content.
     * 
     *   If present, this method will be invoked instead of ListGridField.formatCellValue in cases
     *   where the grid is rendering non-interactive content outside.
     *   See ListGrid.formatInactiveCellValue for more details.
     * 
     * 
     *  @param {any} raw value for the cell, from the record for the row
     *  @param {ListGridRecord} Record object for the cell. Note: If this is a new row that has not been saved, in an  editable grid, it has no associated record object. In this case the edit values will  be passed in as this parameter (see ListGrid.getEditValues)
     *  @param {number} row number for the cell
     *  @param {number} column number for the cell.
     *  @param {ListGrid} the ListGrid displaying the cell
     */
    open fun formatInactiveCellValue(value: dynamic, record: ListGridRecord, rowNum: Number, colNum: Number, grid: ListGrid): String = definedExternally
    /**
     *   Return the value to display in cells of this field which are being edited.
     * 
     *   Example usage: converting a stored value in cents (100) to a dollar-and-cents
     *   value in the editor (1.00)
     * 
     *   The value passed to this method is the raw value for the cell.
     * 
     *   formatEditorValue takes precedence over ListGrid.formatEditorValue
     *   defined at the grid level for cells in this field.
     * 
     *   To convert the formatted value displayed within an editor back to a raw value, implement
     *   ListGridField.parseEditorValue as well.
     * 
     * 
     *  @param {any} raw value for the cell being edited
     *  @param {ListGridRecord} Record object for the cell. Note: If this is a new row that has not been saved, in an  editable grid, it has no associated record object. In this case the edit values will  be passed in as this parameter.
     *  @param {number} row number for the cell
     *  @param {number} column number for the cell.
     *  @param {ListGrid} A pointer to the ListGrid displaying the cell
     */
    open fun formatEditorValue(value: dynamic, record: ListGridRecord, rowNum: Number, colNum: Number, grid: ListGrid): dynamic = definedExternally
    /**
     *   Method used to convert the value displayed in an editor for some cell in this field into
     *   a raw value for saving.
     *   Takes precedence over parseEditorValue defined at the grid level.
     * 
     * 
     *  @param {any} value displayed in the editor for the cell
     *  @param {object} record object for the row being edited. May be null if this             is a new row being added to the end of the list.
     *  @param {number} row number for the cell
     *  @param {number} column number for the cell.
     *  @param {ListGrid} A pointer to the ListGrid displaying the cell
     */
    open fun parseEditorValue(value: dynamic, record: dynamic, rowNum: Number, colNum: Number, grid: ListGrid): dynamic = definedExternally
    /**
     *   If this field is editable, any FormItem.change handler specified
     *   on the ListGridField will be passed onto the editors for this field.
     * 
     *   Note that if ListGridField.canToggle is true, the user may change the value of
     *   a boolean field without going into edit mode by single clicking on the field. In this
     *   case the ListGridField.change and ListGridField.changed handlers will
     *   fire but the form and item parameters will be null.
     * 
     * 
     *  @param {DynamicForm} the managing DynamicForm instance
     *  @param {FormItem} the editor (form item) itself (also available as "this").               Note that in addition to the standard FormItem APIs available                on the editor, it also has:                - a pointer back to the containing listGrid                [item.grid]                - the colNum being edited [item.colNum]                - the rowNum being edited [item.rowNum]
     *  @param {any} The new value of the form item
     *  @param {any} The previous value of the form item
     */
    open fun change(form: DynamicForm, item: FormItem, value: dynamic, oldValue: dynamic): Boolean = definedExternally
    /**
     *   If this field is editable, any FormItem.changed handler specified
     *   on the ListGridField will be passed onto the editors for this field.
     *   Note that if ListGridField.canToggle is true, the user may change the value of
     *   a boolean field without going into edit mode by single clicking on the field. In this
     *   case the ListGridField.change and ListGridField.changed handlers will
     *   fire but the form and item parameters will be null.
     * 
     * 
     *  @param {DynamicForm} the managing DynamicForm instance
     *  @param {FormItem} the editor (form item) itself (also available as "this").               Note that in addition to the standard FormItem APIs available                on the editor, it also has:                - a pointer back to the containing listGrid                [item.grid]                - the colNum being edited [item.colNum]                - the rowNum being edited [item.rowNum]
     *  @param {any} The current value (after the change).
     */
    open fun changed(form: DynamicForm, item: FormItem, value: dynamic): Unit = definedExternally
    /**
     *   StringMethod override point for returning HTML to be shown in hovers over cells in the
     *   column described by this field.
     * 
     *   Called only when ListGrid.canHover and ListGrid.showHover
     *   are both true.
     * 
     *   The value of "this" within the method will by the ListGridField.
     * 
     * 
     *  @param {ListGridRecord} record being hovered over
     *  @param {any} value of the cell being hovered over
     *  @param {number} row number where hover occurred
     *  @param {number} column number where hover occurred
     *  @param {ListGrid} ListGrid this field is a part of
     */
    open fun hoverHTML(record: ListGridRecord, value: dynamic, rowNum: Number, colNum: Number, grid: ListGrid): String = definedExternally
    /**
     *   Optional stringMethod to get a ListGridField.valueMap for a specific field.
     *   If present this method will be called from ListGrid.getEditorValueMap and the resulting
     *   valueMap will be used instead of any static specified valueMap for the field.
     * 
     *  @param {object} Field values for record being edited. Note that this will include            the current edit values for fields that have not yet been saved.             May be null, if editing a new record.
     *  @param {ListGridField} pointer to the listGridField
     *  @param {ListGrid} pointer back to this ListGrid instance.
     */
    open fun getEditorValueMap(values: dynamic, field: ListGridField, grid: ListGrid): dynamic = definedExternally
}