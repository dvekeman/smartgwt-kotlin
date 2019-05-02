@file:JsQualifier("isc")
package isc

/**
 *  The DynamicForm manages a collection of FormItems which represent user input controls. The
 *   DynamicForm provides formLayout, value management, validation and
 *   databinding for the controls it manages.
 * 
 * 
 * 
 *   To create a DynamicForm, set DynamicForm.fields to an Array of Objects describing the
 *   FormItems you want to use. For example:
 * 
 *    isc.DynamicForm.create({
 *      fields:[
 *        {name:"userName", type:"text"}, // creates a TextItem
 *        {name:"usState", type:"select"} // creates a SelectItem
 *      ]
 *    })
 * 
 * 
 *   The item name is an identifier for the item that must be unique just within
 *   this form. It is used:
 * 
 * 
 *  - as the name under which the item's value is stored in the form (the form's
 *     current values are accessible as DynamicForm.getValues
 * 
 *  - when retrieving the FormItem's current value (via
 *     DynamicForm.getValue)
 * 
 *  - to retrieve the item itself via DynamicForm.getItem
 * 
 *   FormItems can also be created by binding the form to a DataSource via
 *   setDataSource(). In this case, FormItems are
 *   chosen based on the data type of the field - see FormItemType. You can override
 *   the automatically chosen FormItem via DataSourceField.editorType.
 * 
 *   FormItem lifecycle is managed by the DynamicForm itself. FormItem instances are created
 *   and destroyed automatically when new fields are added to the form.
 * 
 *   When using DataSource binding, you can also add additional FormItems not specified in the
 *   DataSource, or override any properties on the automatically generated FormItems, without
 *   having to re-declare any information that comes from the DataSource. See the QuickStart
 *   Guide chapter on Data Binding for an overview.
 * 
 *   All FormItems share a common set of properties for controlling formLayout. Other properties common to all FormItems are documented on the FormItem
 *   class, and properties specific to particular FormItems are documented on the respective
 *   FormItems.
 * 
 *   NOTE: For very simple forms consisting of exactly one item, you still use a DynamicForm.
 *   See the "fontSelector" form in the ${isc.DocUtils.linkForExampleId('toolstrip', 'Toolstrip example')}.
 */
open external class DynamicForm : Canvas, DataBoundComponent {
    /**
     *  Synonym for DynamicForm.fields
     *  @type {Array<Partial<FormItem>>}
     *  @default null
     */
    open var items: Array<dynamic> = definedExternally
    /**
     *  An array of field objects, specifying the order, layout, and types of each field in the
     *   DynamicForm.
     * 
     *   When both dynamicForm.fields and dynamicForm.dataSource are
     *   set, dynamicForm.fields acts as a set of overrides as explained in
     *   DataBoundComponent.fields.
     * 
     *   See formLayout for information about how flags specified on
     *   the FormItems control how the form is laid out.
     *  @type {Array<Partial<FormItem>>}
     *  @default null
     */
    override var fields: Array<dynamic> = definedExternally
    /**
     *  An Object containing the initial values of the form as properties, where each
     *   propertyName is the name of a Items in the form, and each property
     *   value is the value held by that form item.
     * 
     *   The form's values may contain values that are not managed by any FormItem, and these
     *   values will be preserved and available when the form values are subsequently retrieved
     *   via DynamicForm.getValues.
     * 
     *   Providing values on initialization is equivalent to calling DynamicForm.setValues.
     * 
     *   As the user manipulates form items to change values, change events fire
     *   FormItem.change and
     *   DynamicForm.itemChange.
     * 
     *   Note that form values are logical values, for example, the value of a DateItem is
     *   a JavaScript Date object, not a String, even if the user enters the date via a text
     *   input. Likewise the value of a TextItem or CheckboxItem that started out
     *   null remains null until the user changes it; the value will not be automatically
     *   converted to the null string ("") or false respectively, as happens with native HTML
     *   elements.
     *  @type {object}
     *  @default null
     */
    open var values: dynamic = definedExternally
    /**
     *  Layout style to use with this form.
     * 
     *   The default of "table" uses a tabular layout similar to HTML tables, but with much more
     *   powerful control over sizing, item visibility and reflow, overflow handling, etc.
     * 
     *   itemLayout:"absolute" allows absolute positioning of every form item. This
     *   provides maximum flexibility in placement, with the following limitations:
     * 
     *  - titles, which normally take up an adjacent cell, are not shown. Use
     *     StaticTextItems to show titles
     * 
     *  - no automatic reflow when showing or hiding items. FormItem.setLeft
     *     and FormItem.setTop can be used for manual reflow.
     * 
     *  - only pixel and percent sizes are allowed, no "\*". Percent widths mean percentage
     *     of the overall form size rather than the column size
     * 
     *  - with different font styling or internationalized titles, items may overlap that did
     *     not overlap in the skin used at design time
     * 
     *  @type {string}
     *  @default "table"
     */
    open var itemLayout: String = definedExternally
    /**
     *  The number of columns of titles and items in this form's layout grid. A title and
     *   corresponding item each have their own column, so to display two form elements per
     *   row (each having a title and item), you would set this property to 4.
     *  @type {number}
     *  @default "2"
     */
    open var numCols: Number = definedExternally
    /**
     *  If true, we ensure that column widths are at least as large as you specify them. This
     *   means that if any single column overflows (due to, eg, a long unbreakable title),
     *   the form as a whole overflows.
     * 
     *   If false, columns will have their specified sizes as long as no column overflows. If
     *   any column overflows, space will be taken from any other columns that aren't filling the
     *   available room, until there is no more free space, in which case the form as a whole
     *   overflows.
     *  @type {boolean}
     *  @default false
     */
    open var fixedColWidths: Boolean = definedExternally
    /**
     *  An array of widths for the columns of items in this form's layout grid.
     * 
     *   If specified, these widths should sum to the total width of the form (form.width).
     *   If not specified, we assume every other column will contain form item titles, and so
     *   should have form.titleWidth, and all other columns should share the
     *   remaining space.
     * 
     *   Acceptable values for each element in the array are:
     * 
     * 
     *  - A number (e.g. 100) representing the number of pixel widths to allocate to a
     *     column.
     * 
     *  - A percent (e.g. 20%) representing the percentage of the total form.width to
     *     allocate to a column.
     * 
     *  - "\*" (all) to allocate remaining width (form.width minus all specified column
     *     widths). Multiple columns can use "\*", in which case remaining width is divided
     *     between all columns marked "\*".
     * 
     *  @type {Array<any>}
     *  @default null
     */
    open var colWidths: Array<dynamic> = definedExternally
    /**
     *  Minimum width of a form column.
     *  @type {number}
     *  @default "20"
     */
    open var minColWidth: Number = definedExternally
    /**
     *  The amount of empty space, in pixels, surrounding each form item within its cell in
     *   the layout grid.
     *  @type {number}
     *  @default "2"
     */
    open var cellPadding: Number = definedExternally
    /**
     *  Width of border for the table that form is drawn in. This is primarily used for debugging
     *   form layout.
     *  @type {number}
     *  @default "0"
     */
    open var cellBorder: Number = definedExternally
    /**
     *  If the form has sections, [implemented as SectionItems], this attribute controls
     *   whether multiple sections can be expanded at once.
     *  @type {VisibilityMode}
     *  @default "multiple"
     */
    open var sectionVisibilityMode: 
                                    /**
                                     *  Only one section can be expanded at a time.
                                     *  Multiple sections can be expanded at the same time, and will share space.
                                     */
                                    String /* mutex |  multiple */ = definedExternally
    /**
     *  For databound forms, whether to show fields marked as detail fields.
     *  @type {boolean}
     *  @default true
     */
    override var showDetailFields: Boolean = definedExternally
    /**
     *  When creating form items for fields with text type data, if the specified length of the
     *   field exceeds this threshold we will create form item of type
     *   this.longTextEditorType (a TextAreaItem by default), rather than a simple
     *   text item. Overridden by explicitly specifying editorType for the field.
     *  @type {number}
     *  @default "255"
     */
    open var longTextEditorThreshold: Number = definedExternally
    /**
     *  Name of the Form Item class to use for text fields which exceed the
     *   longTextEditorThreshold for this form.
     *  @type {string}
     *  @default "textArea"
     */
    open var longTextEditorType: String = definedExternally
    /**
     *  Default DateDisplayFormat for Date type values displayed in this form.
     * 
     *   If some field's value is set to a native Date object, how should it be displayed to the
     *   user? If specified this is the default display format to use, and will apply to all fields
     *   except those specified as FormItem.type
     *   (See DynamicForm.timeFormatter).
     * 
     *   May be overridden at the component level for fields of type datetime via
     *   DynamicForm.datetimeFormatter.
     * 
     *   Note that if specified, FormItem.dateFormatter and FormItem.timeFormatter
     *   take precedence over the format specified at the component level.
     * 
     *   If no explicit formatter is specified at the field or component level, dates will be
     *   formatted according to the system-wide
     *   DateUtil.setShortDisplayFormat or
     *   DateUtil.setShortDatetimeDisplayFormat depending
     *   on the specified field type.
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
     *  Default TimeDisplayFormat for FormItem.type field values displayed
     *   in this form.
     * 
     *   Note that if specified, FormItem.dateFormatter and FormItem.timeFormatter
     *   take precedence over the format specified at the component level.
     * 
     *   If no explicit formatter is specified at the field or component level, time values will be
     *   formatted according to the system-wide
     *   Time.setNormalDisplayFormat.
     *   specified field type.
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
     *  Default DateDisplayFormat for Date type values displayed in this form in fields
     *   of type datetime.
     * 
     *   For datetime fields, this attribute will be used instead of DynamicForm.dateFormatter
     *   when formatting Date values.
     * 
     *   Note that if specified, FormItem.dateFormatter and FormItem.timeFormatter
     *   take precedence over the format specified at the component level.
     * 
     *   If no explicit formatter is specified at the field or component level, datetime field
     *   values will be formatted according to the system-wide
     *   DateUtil.setShortDatetimeDisplayFormat.
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
     *  If set at init time, this dynamicForm will be created as a member form of the
     *   specified valuesManager. To update the form's valuesManager after init, use the
     *   DynamicForm.setValuesManager, or the
     *   ValuesManager.addMember /
     *   ValuesManager.removeMember APIs on
     *   ValuesManager.
     *  @type {ValuesManager | GlobalId}
     *  @default null
     */
    override var valuesManager: dynamic = definedExternally
    /**
     *  Default orientation for titles for items in this form. TitleOrientation
     *   lists valid options.
     * 
     *   Note that titles on the left or right take up a cell in tabular
     *   formLayout, but titles on top do not.
     *  @type {TitleOrientation}
     *  @default "left"
     */
    open var titleOrientation: String /* left |  top |  right */ = definedExternally
    /**
     *  The string pre-pended to the title of every item in this form. See also +{requiredTitlePrefix} for
     *   fields that are required.
     *  @type {HTMLString}
     *  @default ""
     */
    open var titlePrefix: String = definedExternally
    /**
     *  The string pre-pended to the title of an item in this form if its
     *   titleOrientation property is set to "right".
     *  @type {HTMLString}
     *  @default ":&amp;nbsp;"
     */
    open var rightTitlePrefix: String = definedExternally
    /**
     *  The string appended to the title of every item in this form. See also +{requiredTitleSuffix} for
     *   fields that are required.
     *  @type {HTMLString}
     *  @default "&amp;nbsp;:"
     */
    open var titleSuffix: String = definedExternally
    /**
     *  The string appended to the title of an item in this form if its titleOrientation
     *   property is set to "right".
     *  @type {HTMLString}
     *  @default ""
     */
    open var rightTitleSuffix: String = definedExternally
    /**
     *  The width in pixels allocated to the title of every item in this form. If you
     *       don't specify explicit DynamicForm.colWidths, you can set this
     *       value to the string "\*" to divide the usable space evenly between titles and
     *       fields.
     *  @type {number | "\*"}
     *  @default "100"
     */
    open var titleWidth: dynamic = definedExternally
    /**
     *  Should the titles for form items be clipped if they are too large for the available
     *   space?
     * 
     *   Can be overridden for individual items via FormItem.clipTitle.
     *  @type {boolean}
     *  @default false
     */
    open var clipItemTitles: Boolean = definedExternally
    /**
     *  Whether titles for form items should wrap. If not specified, titles will wrap by
     *   default. Can be overridden for individual items via FormItem.wrapTitle
     *  @type {boolean}
     *  @default null
     */
    open var wrapItemTitles: Boolean = definedExternally
    /**
     *  If true, field errors are written into the form next to the item(s) where the errors
     *   occurred. Errors may appear as text or just an icon (via DynamicForm.showErrorText:false).
     * 
     *   If false, errors are written at the top of the form.
     * 
     *   To do some other kind of error display, override DynamicForm.showErrors.
     *  @type {boolean}
     *  @default true
     */
    open var showInlineErrors: Boolean = definedExternally
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
     *   to form items. Therefore the combination of DynamicForm.showErrorText:false and
     *   DynamicForm.errorOrientation:"left" creates a compact validation error display
     *   consisting of just an icon, to the left of the item with the error message
     *   available via a hover (similar appearance to ListGrid validation error display).
     * 
     *   In addition to this, showErrorStyle determines whether fields with validation
     *   errors should have special styling applied to them. Error styling is achieved by
     *   applying suffixes to existing styling applied to various parts of the form item.
     *   See FormItemBaseStyle for more on this.
     *  @type {boolean}
     *  @default true
     */
    open var showErrorIcons: Boolean = definedExternally
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
     *   to form items. Therefore the combination of DynamicForm.showErrorText:false and
     *   DynamicForm.errorOrientation:"left" creates a compact validation error display
     *   consisting of just an icon, to the left of the item with the error message
     *   available via a hover (similar appearance to ListGrid validation error display).
     * 
     *   In addition to this, showErrorStyle determines whether fields with validation
     *   errors should have special styling applied to them. Error styling is achieved by
     *   applying suffixes to existing styling applied to various parts of the form item.
     *   See FormItemBaseStyle for more on this.
     *  @type {boolean}
     *  @default false
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
     *   to form items. Therefore the combination of DynamicForm.showErrorText:false and
     *   DynamicForm.errorOrientation:"left" creates a compact validation error display
     *   consisting of just an icon, to the left of the item with the error message
     *   available via a hover (similar appearance to ListGrid validation error display).
     * 
     *   In addition to this, showErrorStyle determines whether fields with validation
     *   errors should have special styling applied to them. Error styling is achieved by
     *   applying suffixes to existing styling applied to various parts of the form item.
     *   See FormItemBaseStyle for more on this.
     *  @type {boolean}
     *  @default true
     */
    open var showErrorStyle: Boolean = definedExternally
    /**
     *  If DynamicForm.showInlineErrors is true, where should the error icon and text appear
     *   relative to form items? Valid options are "top",
     *   "bottom", "left" or "right".
     *   May be overridden at the item level via FormItem.errorOrientation.
     *  @type {string}
     *  @default "left"
     */
    open var errorOrientation: String = definedExternally
    /**
     *  If DynamicForm.showInlineErrors is false we show all errors for the form item in
     *   a single item rendered at the top of the form.
     *   This attribute contains a properties block for this item.
     *  @type {object}
     *  @default null
     */
    open var errorItemProperties: dynamic = definedExternally
    /**
     *  If DynamicForm.showInlineErrors is false we show all errors for the form item in
     *   a single item rendered at the top of the form.
     *   This attribute specifies the cellStyle to apply to this item.
     *  @type {string}
     *  @default "formCellError"
     */
    open var errorItemCellStyle: String = definedExternally
    /**
     *  If DynamicForm.showInlineErrors is false, all errors for the items
     *   in the form are rendered as a single item at the top of the form. This attribute specifies
     *   an introductory message rendered out before the individual error messages.
     *  @type {HTMLString}
     *  @default "The following errors were found:"
     */
    open var errorsPreamble: String = definedExternally
    /**
     *  Indicates whether on validation failure, the error message displayed to the
     *       user should be pre-pended with the title for the item.
     *  @type {boolean}
     *  @default false
     */
    open var showTitlesWithErrorMessages: Boolean = definedExternally
    /**
     *  Indicates whether the titles of required items in this form should use the special
     *   prefix and suffix specified by the next two properties, instead of the standard
     *   prefix and suffix.
     *  @type {boolean}
     *  @default true
     */
    open var hiliteRequiredFields: Boolean = definedExternally
    /**
     *  The string pre-pended to the title of every required item in this form if
     *   DynamicForm.hiliteRequiredFields is true.
     *  @type {HTMLString}
     *  @default "&lt;b&gt;"
     */
    open var requiredTitlePrefix: String = definedExternally
    /**
     *  The string pre-pended to the title of every required item in this form if
     *   DynamicForm.hiliteRequiredFields is true and the TitleOrientation property is set to "right".
     *  @type {HTMLString}
     *  @default "&lt;b&gt;:&amp;nbsp;"
     */
    open var requiredRightTitlePrefix: String = definedExternally
    /**
     *  The string appended to the title of every required item in this form if
     *   DynamicForm.hiliteRequiredFields is true.
     *  @type {HTMLString}
     *  @default "&amp;nbsp;:&lt;/b&gt;"
     */
    open var requiredTitleSuffix: String = definedExternally
    /**
     *  The string appended to the title of every required item in this form if
     *   DynamicForm.hiliteRequiredFields is true and the TitleOrientation property is set to "right".
     *  @type {HTMLString}
     *  @default "&lt;/b&gt;"
     */
    open var requiredRightTitleSuffix: String = definedExternally
    /**
     *  The required message for required field errors.
     *  @type {HTMLString}
     *  @default null
     */
    open var requiredMessage: String = definedExternally
    /**
     *  If set to false, the form will be marked read-only. A widget on the form
     *   is editable if either (1) beginning with the widget and continuing up the containment
     *   hierarchy, including the form, the first widget to have a non-null canEdit
     *   attribute has canEdit:true, or (2) neither the widget nor any parent has a non-null
     *   canEdit attribute. This setting allows you to enable or disable the default
     *   editability of the form's items at one time.
     * 
     *   This setting differs from the enabled/disabled state in that most form items will
     *   allow copying of the contents while read-only but do not while disabled.
     * 
     *   Note that a form is considered editable if canEdit is null (default) or
     *   true.
     * 
     * 
     *  @type {boolean}
     *  @default null
     */
    open var canEdit: Boolean = definedExternally
    /**
     *  If DynamicForm.canEdit is set to false, how should the items in this
     *   form be displayed to the user?
     * 
     *   Can be overridden via FormItem.readOnlyDisplay on individual form items.
     *  @type {ReadOnlyDisplayAppearance}
     *  @default "readOnly"
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
     *  Default FormItem.readOnlyTextBoxStyle setting for items in this form.
     *  @type {FormItemBaseStyle}
     *  @default "staticTextItem"
     */
    open var readOnlyTextBoxStyle: String = definedExternally
    /**
     *  Default FormItem.clipStaticValue setting for items in this form. When unset, this
     *   is equivalent to false.
     *  @type {boolean}
     *  @default null
     */
    open var clipStaticValue: Boolean = definedExternally
    /**
     *  Default FormItem.showDeletions setting for items in this form.
     *  @type {boolean}
     *  @default null
     */
    open var showDeletions: Boolean = definedExternally
    /**
     *  Should items within this form that are showing a FormItem.hint have the hint text
     *   wrap? May be overridden at the item level via FormItem.wrapHintText. If
     *   wrapHintText is unset on both the form and item, then the default behavior
     *   is not wrapping the hint.
     * 
     *   This setting does not apply to hints that are TextItem.showHintInField.
     *  @type {boolean}
     *  @default true
     */
    open var wrapHintText: Boolean = definedExternally
    /**
     *  Minimum horizontal space made available for FormItem.hint text.
     *   Typically this reflects how much space the hint text takes up before it wraps.
     *   May be overridden at the item level via FormItem.minHintWidth.
     * 
     *   This setting does not apply to hints that are TextItem.showHintInField.
     *  @type {Integer}
     *  @default "80"
     */
    open var minHintWidth: Number = definedExternally
    /**
     *  If the user rolls over an item, how long a delay before we fire any hover action / show
     *   a hover for that item?
     *  @type {number}
     *  @default "500"
     */
    open var itemHoverDelay: Number = definedExternally
    /**
     *  A default width for hovers shown for items
     *  @type {any}
     *  @default null
     */
    open var itemHoverWidth: dynamic = definedExternally
    /**
     *  A default height for hovers shown for items
     *  @type {any}
     *  @default null
     */
    open var itemHoverHeight: dynamic = definedExternally
    /**
     *  Text alignment for hovers shown for items
     *  @type {Alignment}
     *  @default null
     */
    open var itemHoverAlign: 
                             /**
                              *  Center within container.
                              *  Stick to left side of container.
                              *  Stick to right side of container.
                              */
                             String /* center |  left |  right */ = definedExternally
    /**
     *  Vertical text alignment for hovers shown for items
     *  @type {any}
     *  @default null
     */
    open var itemHoverVAlign: dynamic = definedExternally
    /**
     *  CSS Style for hovers shown for items
     *  @type {CSSStyleName}
     *  @default "formHover"
     */
    open var itemHoverStyle: String = definedExternally
    /**
     *  Opacity for hovers shown for items
     *  @type {number}
     *  @default null
     */
    open var itemHoverOpacity: Number = definedExternally
    /**
     *  Default setting for the form items' FormItem.showOldValueInHover setting.
     *  @type {boolean}
     *  @default null
     */
    open var showOldValueInHover: Boolean = definedExternally
    /**
     *  Default template HTML string when an item does not set its own FormItem.originalValueMessage.
     * 
     *   Variables in the template are substituted as follows:
     * 
     * 
     *    Variable
     *    Substitution
     * 
     * 
     *    $value
     *    The item's old value as stored in the
     *      object
     *      returned by DynamicForm.getOldValues.
     * 
     * 
     *    $newValue
     *    The item's new value.
     * 
     * 
     * 
     *   For $value and $newValue, any formatters or stored/display value
     *   mapping will be applied.
     *  @type {HTMLString}
     *  @default "Original value: $value"
     */
    open var originalValueMessage: String = definedExternally
    /**
     *  A property list of itemName:errorMessage pairs, specifying the set of error messages
     *       displayed with the corresponding form elements. Each errorMessage may be either a
     *       single string or an array of strings, for example:
     *       {fieldName:errors, fieldName:errors}
     *       where each errors object will be either an error message string or an array
     *       of error message strings.
     *  @type {object}
     *  @default null
     */
    open var errors: dynamic = definedExternally
    /**
     *  If true, form fields will be validated when each item's "change" handler is fired
     *   as well as when the entire form is submitted or validated.
     * 
     *   Note that this property can also be set at the item level or on each validator
     *   to enable finer granularity validation in response to user interaction.
     *   If true at the form or field level, validators not explicitly set with
     *   validateOnChange:false will be fired on change - displaying errors and
     *   rejecting the change on validation failure.
     *  @type {boolean}
     *  @default false
     */
    open var validateOnChange: Boolean = definedExternally
    /**
     *  If validateOnChange is true, and validation fails for an item on change, with no suggested
     *   value, should we revert to the previous value, or continue to display the bad value entered
     *   by the user. May be set at the item or form level.
     *  @type {boolean}
     *  @default null
     */
    open var rejectInvalidValueOnChange: Boolean = definedExternally
    /**
     *  The error message for a failed validator that does not specify its own errorMessage.
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
     *  If true, form items will be validated when each item's "editorExit" handler is fired
     *   as well as when the entire form is submitted or validated.
     * 
     *   Note that this property can also be set at the item level to enable finer granularity
     *   validation in response to user interaction - if true at either level, validation
     *   will occur on editorExit.
     *  @type {boolean}
     *  @default false
     */
    open var validateOnExit: Boolean = definedExternally
    /**
     *  When true, indicates that changes to items in this form will be automatically saved on a
     *   DynamicForm.implicitSaveDelay, as well as when the entire form is
     *   submitted. Unless DynamicForm.implicitSaveOnBlur is set
     *   to false, changes will also be automatically saved on editorExit for each item. This
     *   attribute can also be set directly on FormItems.
     *  @type {boolean}
     *  @default false
     */
    open var implicitSave: Boolean = definedExternally
    /**
     *  If true, form item values will be automatically saved when each item's "editorExit"
     *   handler is fired as well as on a delay and when the entire form is submitted. This
     *   attribute can also be set directly on FormItems.
     *  @type {boolean}
     *  @default false
     */
    open var implicitSaveOnBlur: Boolean = definedExternally
    /**
     *  When DynamicForm.implicitSave is true, this attribute dictates the
     *   millisecond delay after which form items are automatically saved during editing.
     *  @type {number}
     *  @default "2000"
     */
    open var implicitSaveDelay: Number = definedExternally
    /**
     *  Indicates that if validation fails, the user should not be allowed to exit
     *   the field - focus will be forced back into the field until the error is corrected.
     * 
     *   Enabling this property also implies FormItem.validateOnExit is automatically
     *   enabled. If there are server-based validators on this item, setting this property
     *   also implies that FormItem.synchronousValidation is forced on.
     *  @type {boolean}
     *  @default null
     */
    open var stopOnError: Boolean = definedExternally
    /**
     *  If enabled, whenever validation is triggered and a request to the server is required,
     *   user interactivity will be blocked until the request returns. Can be set for the entire
     *   form or individual FormItems.
     * 
     *   If false, the form will try to avoid blocking user interaction until it is strictly
     *   required. That is until the user attempts to use a FormItem whose state could be
     *   affected by a server request that has not yet returned.
     *  @type {boolean}
     *  @default false
     */
    open var synchronousValidation: Boolean = definedExternally
    /**
     *  If true, when the form is drawn, focus will automatically be put into the first focusable
     *   element in the form.
     *   Note that to put focus in a different item you can explicitly call
     *   dynamicForm.focusInItem(itemName)
     *  @type {boolean}
     *  @default false
     */
    open var autoFocus: Boolean = definedExternally
    /**
     *  If true, when DynamicForm.validate fails focus will automatically
     *   be put into the first focusable field which failed validation.
     *  @type {boolean}
     *  @default true
     */
    open var autoFocusOnError: Boolean = definedExternally
    /**
     *  If this property is set to true, whenever a text-based field in this form
     *   (TextItem, TextAreaItem) is given focus programmatically
     *   (see DynamicForm.focusInItem), all text within the item will be selected.
     * 
     *   Note that this flag affects only programmatic focus. It's the normal behavior of text
     *   fields to select all text if the user navigates into them via keyboard, or if the user
     *   navigates via mouse, to place the text insertion point at the mouse click, and
     *   SmartClient preserves these behaviors. selectOnFocus is only needed for
     *   cases like a form within a pop-up dialog that should have the first field selected.
     * 
     *   If you also want the value to be selected when the user clicks on the field, set
     *   DynamicForm.selectOnClick instead.
     * 
     *   If selectOnFocus is false, the selection is not modified on focus - any
     *   previous selection within the item will be maintained.
     * 
     *   May be overridden at the form item level via FormItem.selectOnFocus.
     *  @type {boolean}
     *  @default false
     */
    open var selectOnFocus: Boolean = definedExternally
    /**
     *  If this property is set to true, whenever a text-based field in this form
     *   (TextItem, TextAreaItem) is given focus - whether
     *   programmatically (see DynamicForm.focusInItem), or via a mouse click, all text
     *   within the item will be selected.
     * 
     *   If you only want the value to be selected when on programmatic focus or keyboard
     *   navigation (this is the native browser behavior), set
     *   DynamicForm.selectOnFocus instead.
     * 
     *   May be overridden at the form item level via FormItem.selectOnClick.
     *  @type {boolean}
     *  @default false
     */
    open var selectOnClick: Boolean = definedExternally
    /**
     *  DynamicForms are considered to have focus if any of their form items have focus.
     *   Note that setting dynamicForm.canFocus to false will have no effect on
     *   whether form items within the form may receive focus. This property will only govern
     *   whether the form may receive focus if the form contains no focusable items.
     *  @type {boolean}
     *  @default true
     */
    override var canFocus: Boolean = definedExternally
    /**
     *  Should this form allow browser auto-completion of its items' values?
     *   Applies only to items based on native HTML form elements (TextItem,
     *   PasswordItem, etc), and will only have a user-visible impact for browsers
     *   where native autoComplete behavior is actually supported and enabled via user settings.
     * 
     *   This property may be explicitly specified per item via FormItem.autoComplete.
     * 
     *   Note that even with this value set to "none", native browser
     *   auto-completion may occur for log in forms (forms containing username and
     *   PasswordItem fields). This behavior varies by browser, and is
     *   a result of an
     *   intentional change by some browser developers
     *   to disregard the HTML setting autocomplete=off for password items or
     *   log-in forms.
     *  @type {AutoComplete}
     *  @default "none"
     */
    open var autoComplete: 
                           /**
                            *  Disable browser autoComplete. Note that some browsers will disregard  this setting and still perform native autoComplete for certain items - typically
                            *    only for log in / password forms. See the discussion FormItem.autoComplete.
                            *  Allow native browser autoComplete.
                            */
                           String /* none |  native */ = definedExternally
    /**
     *  If this browser has a 'spellCheck' feature for text-based form item elements, should
     *   it be used for items in this form? Can be overridden at the item level via
     *   FormItem.browserSpellCheck
     * 
     *   Notes:
     *   - this property only applies to text based items such as TextItem and TextAreaItem.
     *   - this property is not supported on all browsers.
     *  @type {boolean}
     *  @default true
     */
    open var browserSpellCheck: Boolean = definedExternally
    /**
     *  validationURL can be set to do server-side validation against a different URL from where
     *   the form will ultimately save, as part of an incremental upgrade strategy for Struts and
     *   Struts-like applications.
     * 
     *   If set, calling DynamicForm.submit causes an RPC to be sent to this URL to
     *   perform server-side validation of the form values. If the validation fails, the
     *   validation errors returned by the server are rendered in the form. If the validation
     *   succeeds, the form is submitted to the URL specified by DynamicForm.action.
     * 
     *   The form values are available on the server as request parameters (just like a normal form
     *   submit) and also as the values of a DSRequest sent as an RPC alongside the normal
     *   submit.
     * 
     *   The expected response to this request is a DSResponse sent via the RPC mechanism. If
     *   validation is successful, an empty response with the STATUS_SUCCESS status code is
     *   sufficient. If there are validation errors, the DSResponse should have the status set to
     *   STATUS_VALIDATION_ERROR and the errors should be set on the response via the
     *   addError()/setErrorReport() API on DSResponse. See the javadoc for DSResponse for
     *   details.
     * 
     *   See the Struts examples in [webroot]/examples/struts for usage examples.
     *  @type {URL}
     *  @default null
     */
    open var validationURL: String = definedExternally
    /**
     *  If set to true, client-side validators will not run on the form when validate() is
     *   called. Server-side validators (if any) will still run on attempted save.
     *  @type {boolean}
     *  @default null
     */
    open var disableValidation: Boolean = definedExternally
    /**
     *  The name of the special field sent to the server as part of DynamicForm.cancel
     *  @type {string}
     *  @default "org.apache.struts.taglib.html.CANCEL"
     */
    open var cancelParamName: String = definedExternally
    /**
     *  The value of the special field sent to the server as part of DynamicForm.cancel
     *  @type {string}
     *  @default "cancel"
     */
    open var cancelParamValue: String = definedExternally
    /**
     *  The URL to which the form will submit its values.
     * 
     *   NOTE: this is used only in the very rare case that a form is used to submit data
     *   directly to a URL. Normal server contact is through RPCManager.
     *   See DynamicForm.canSubmit for more on this.
     *  @type {URL}
     *  @default "#"
     */
    open var action: String = definedExternally
    /**
     *  The name of a window or frame that will receive the results returned by the form's
     *   action. The default null indicates to use the current frame.
     * 
     *   NOTE: this is used only in the very rare case that a form is used to submit data
     *   directly to a URL. Normal server contact is through
     *   dataBoundComponentMethods.
     *  @type {string}
     *  @default null
     */
    open var target: String = definedExternally
    /**
     *  The mechanism by which form data is sent to the action URL. See FormMethod type
     *   for details.
     * 
     *   NOTE: this is used only in the very rare case that a form is used to submit data
     *   directly to a URL. Normal server contact is through
     *   dataBoundComponentMethods.
     *  @type {FormMethod}
     *  @default "POST"
     */
    open var method: 
                     /**
                      *  GET request -- URL encoding (~4K max)
                      *  POST request -- separate field encoding (no max)
                      */
                     String /* GET |  POST */ = definedExternally
    /**
     *  encoding for the form, use MULTIPART_ENCODING for file upload forms
     *  @type {Encoding}
     *  @default "normal"
     */
    open var encoding: 
                       /**
                        *  normal form encoding ("application/x-www-form-urlencoded")
                        *  form encoding for forms with INPUT file elements, that                  is, forms that upload files ("multipart/form-data")
                        */
                       String /* normal |  multipart */ = definedExternally
    /**
     *  Governs whether this form will be used to perform a standard HTML form submission.
     *   Note that if true, DynamicForm.submit will perform a native HTML submission
     *   to the specified DynamicForm.action URL.
     *   Wherever possible we strongly recommend using the
     *   dataBoundComponentMethods to send data to
     *   the server as they provide a far more sophisticated interface, with built in
     *   options for server validation, required fields, etc.
     *  @type {boolean}
     *  @default false
     */
    open var canSubmit: Boolean = definedExternally
    /**
     *  If true, when the user hits the Enter key while focused in a text-item in
     *   this form, we automatically submit the form to the server using the
     *   DynamicForm.submit method.
     *  @type {boolean}
     *  @default false
     */
    open var saveOnEnter: Boolean = definedExternally
    /**
     *  Keyboard shortcut that causes the value of the currently focused form item to be reverted
     *   to whatever value would be shown if DynamicForm.resetValues were called.
     *  @type {KeyIdentifier}
     *  @default null
     */
    open var revertValueKey: KeyIdentifier = definedExternally
    /**
     *  When FormItem.operator has been set for any FormItem in this form, what
     *   logical operator should be applied across the Criterion produced by the form
     *   items? Only applicable to forms that have a DataBoundComponent.dataSource.
     *  @type {OperatorId}
     *  @default "and"
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
     *  If set, this DynamicForm will set both
     *   DataBoundComponent.showComplexFields and
     *   showComplexFieldsRecursively on any nested component used for showing/editing
     *   a complex field. Thus any of this form's items that handle complex fields will themselves
     *   also show complex fields. This allows for handling of field structures of any complexity.
     * 
     *   If set, this value automatically sets DataBoundComponent.showComplexFields
     *   as well.
     *  @type {boolean}
     *  @default null
     */
    open var showComplexFieldsRecursively: Boolean = definedExternally
    /**
     *  FormItem class to use for any singular (ie, non-list) complex fields
     *   on this DynamicForm.
     *  @type {string}
     *  @default "NestedEditorItem"
     */
    open var nestedEditorType: String = definedExternally
    /**
     *  FormItem class to use for any list-type complex fields on this DynamicForm.
     *   List-type fields are denoted by marking them multiple: true in the
     *   DataSource.
     *  @type {string}
     *  @default "NestedListEditorItem"
     */
    open var nestedListEditorType: String = definedExternally
    /**
     *  This property applies to all of the items that a form has, and works according to
     *   FormItem.showPending.
     *   Also, in a form with showPending:true, an individual FormItem can set
     *   showPending:false and vice versa.
     *  @type {boolean}
     *  @default null
     */
    open var showPending: Boolean = definedExternally
    /**
     *  How to fetch and manage records retrieve from the server. See FetchMode.
     * 
     *   This setting only applies to the ResultSet automatically created by calling
     *   ListGrid.fetchData. If a pre-existing ResultSet is passed to setData() instead, it's
     *   existing setting for ResultSet.fetchMode applies.
     *  @type {FetchMode}
     *  @default "paged"
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
     *  Default OperatorId to use for fields in a form that produces
     *   AdvancedCriteria. Default is "iContains" unless DynamicForm.allowExpressions is
     *   enabled for the form as a whole, in which case the default is
     *   DataSource.translatePatternOperators.
     * 
     *   Does not apply to special fields where exact match is obviously the right default
     *   setting, such as fields of type:"enum", or fields with a
     *   FormItem.valueMap or FormItem.optionDataSource.
     * 
     *   defaultSearchOperator also has no effect in a form that does not produce
     *   AdvancedCriteria - see DynamicForm.getValuesAsCriteria for
     *   settings that cause a form to produce AdvancedCriteria.
     *  @type {OperatorId}
     *  @default null
     */
    open var defaultSearchOperator: 
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
     *  Should users be able to tab into the FormItem.icons and
     *   FormItem.showPickerIcon for items within this form by default?
     * 
     *   May be overridden at the item level by FormItem.canTabToIcons.
     * 
     *   Developers may also suppress tabbing to individual icons by
     *   setting FormItemIcon.tabIndex to -1.
     *  @type {boolean}
     *  @default true
     */
    open var canTabToIcons: Boolean = definedExternally
    /**
     *  For editable fields with a specified FormItem.displayField and
     *   FormItem.optionDataSource, if the user selects a new value (typically from
     *   PickList based item such as a SelectItem), should the selected displayValue be updated
     *   on the record being edited in addition to the value for the actual item.
     *   Note that this only applies for fields using
     *   FormItem.useLocalDisplayFieldValue - typically
     *   DataSourceField.foreignKey where the display field is
     *   DataSourceField.includeFrom another dataSource.
     * 
     *   Default value is true. This is typically desirable for editing records
     *   with a displayField-mapped field, as it ensures the edited record will be be updated
     *   to contain the correct display value as well as the correct data value. As such, the
     *   expected display value is available on the record for display (for example in a ListGrid
     *   cell).
     * 
     *   It may not be desirable for an interface specifically intended for
     *   DynamicForm.getValuesAsCriteria - in this case, results ought
     *   to be limited by an item's actual selected value, not by whatever text is displayed to
     *   the user.
     * 
     *   See DataSourceField.displayField for more details.
     * 
     *   Note: the modified display field value will be passed to the server along with the
     *   modified foreignKey field value if a
     *   DynamicForm.saveData is performed. This occurs
     *   even if the displayField is
     *   DataSourceField.includeFrom and therefore
     *   read-only. In this case the server will simply ignore the modified display field value.
     *   This is as expected - a subsequent fetch for the same record would recalculate the
     *   displayField value on the server using the updated foreignKey field value (and return
     *   the same display value previously displayed to the user).
     * 
     *   This attribute can also be set for FormItem.storeDisplayValues.
     *  @type {boolean}
     *  @default true
     */
    open var storeDisplayValues: Boolean = definedExternally
    /**
     *  If true, the headers for any SectionStackSection.items will be included in the page's tab
     *   order for accessibility. May also be set at the item level via SectionItem.canTabToHeader
     * 
     *   If unset, section headers will be focusable if isc.setScreenReaderMode
     * 
     *   has been called.
     *   See accessibility.
     *  @type {boolean}
     *  @default null
     */
    open var canTabToSectionHeaders: Boolean = definedExternally
    /**
     *  Default alignment for item titles. If unset default alignment will be derived from
     *   Page.isRTL as described in DynamicForm.getTitleAlign
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
     *  Warning to display to the user if an attempt to DynamicForm.submitForm a
     *   form is unable to submit to the server. The most common cause for this failure is that the user
     *   has typed an invalid file-path into an upload type field.
     *  @type {string}
     *  @default "Form was unable to be submitted. The most likely cause for this is an invalid value in an upload field."
     */
    open var formSubmitFailedWarning: String = definedExternally
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
     *  For a form that produces filter criteria
     *   (see DynamicForm.getValuesAsCriteria), allows the user to
     *   enter simple expressions in any field in this form that takes text input.
     * 
     *   Also note that enabling allowExpressions for an entire form changes the
     *   DynamicForm.defaultSearchOperator to
     *   DataSource.translatePatternOperators,
     *   so that simple search expressions similar to SQL "LIKE" patterns can be entered in most
     *   fields.
     * 
     *   See FormItem.allowExpressions for details.
     *  @type {boolean}
     *  @default null
     */
    open var allowExpressions: Boolean = definedExternally
    /**
     *  Default TextItem.suppressBrowserClearIcon value for TextItems within this
     *   form.
     *  @type {boolean}
     *  @default false
     */
    open var suppressBrowserClearIcons: Boolean = definedExternally
    /**
     *  If true, when this component is first drawn, automatically call this.fetchData().
     *   Criteria for this fetch may be picked up from DynamicForm.initialCriteria, and textMatchStyle may
     *   be specified via ListGrid.autoFetchTextMatchStyle.
     * 
     *   NOTE: if autoFetchData is set, calling
     *   ListGrid.fetchData before draw will cause two requests to be issued, one from the manual
     *   call to fetchData() and one from the autoFetchData setting. The second request will use
     *   only DynamicForm.initialCriteria and not any other criteria or settings from the first request.
     *   Generally, turn off autoFetchData if you are going to manually call ListGrid.fetchData at any time.
     *  @type {boolean}
     *  @default false
     */
    override var autoFetchData: Boolean = definedExternally
    /**
     *  If DynamicForm.autoFetchData is true, this attribute allows the developer to
     *   specify a textMatchStyle for the initial ListGrid.fetchData call.
     *  @type {TextMatchStyle}
     *  @default null
     */
    open var autoFetchTextMatchStyle: 
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
     *  Criteria to be used when DynamicForm.autoFetchData is set.
     * 
     *   This property supports dynamicCriteria - use Criterion.valuePath
     *   to refer to values in the Canvas.ruleScope.
     *  @type {Criteria}
     *  @default null
     */
    override var initialCriteria: dynamic = definedExternally
    /**
     *  Associated userTask if current dynamic form used along with workflow.
     *   See UserTask for more details.
     *  @type {UserTask}
     *  @default null
     */
    open var userTask: UserTask = definedExternally
    /**
     *  When calling DynamicForm.saveData on a form or valuesManager, by default if the server
     *   returns an error code, any callback passed into saveData() will not be fired.
     *   If the error code returned by the server indicates a validation error, it will be
     *   displayed to the user by updating the form items to show the error messages, and firing
     *   any specified hiddenValidationErrors handler, otherwise the standard RPCManager
     *   error handling logic would be invoked.
     * 
     *   Developers who want to handle errors themselves can override this default by specifying
     *   RPCRequest.willHandleError on the DSRequest. In this case the callback passed in
     *   will be fired even if the server returns an error status code.
     * 
     *   If suppressValidationErrorCallback is set to true, if a save attempt returns
     *   a validation error code, the user-specified callback will not be fired
     *   even if willHandleError:true was specified on the dsRequest
     *   - though for other error codes, the callback would be fired if willHandleError is
     *   specified on the request.
     *   Note that this is the historical behavior for
     *   SmartClient builds 8.0 and earlier
     * 
     *  @type {boolean}
     *  @default false
     */
    open var suppressValidationErrorCallback: Boolean = definedExternally
    /**
     *  Default DSOperationType to be performed when DynamicForm.saveData is called.
     *   This property is automatically set on a call to DynamicForm.editRecord or
     *   DynamicForm.editNewRecord, or may be set directly via
     *   DynamicForm.setSaveOperationType.
     * 
     *   If saveOperationType is unset, the form will heuristically determine
     *   whether an "add" or "update" operation is intended based on whether the primaryKey field
     *   is present and editable.
     *  @type {DSOperationType}
     *  @default null
     */
    open var saveOperationType: 
                                /**
                                 *  Fetch one or more records that match a set of search criteria.
                                 *  Store new records
                                 *  Update an existing record
                                 *  Remove (delete) an existing record
                                 *  perform some arbitrary custom logic that is not a CRUD operation.            Format of the inputs and outputs is unconstrained, and the operation
                                 *              will be ignored for cache sync purposes by ResultSets. See
                                 *              DataSource.performCustomOperation.
                                 *  Run server-side validation for "add" or "update" without actually            adding or updating anything. See DataSource.validateData.
                                 *  Retrieve a file stored in a binary field in a DataSource record, and            allow the browser to choose whether to view it directly or prompt the
                                 *              user to save. See binaryFields.
                                 *  Like "viewFile", but the HTTP header Content-Disposition is used to            suggest that the browser show a save dialog. See binaryFields.
                                 *  Takes a List of Maps and stores the data in Admin Console XML test            data format
                                 *  Upload formatted client data and export it to Excel, XML and other            formats. Used automatically by
                                 *              DataSource.exportClientData
                                 *              and cannot be used directly. Usable only with the SmartClient server
                                 *              framework.
                                 *  Use the DataSource as a fileSource.            Used automatically by DataSource.getFile, and
                                 *              would not normally be used directly. Usable only with
                                 *              the SmartClient server framework.
                                 *  Use the DataSource as a fileSource.            Used automatically by DataSource.hasFile, and
                                 *              would not normally be used directly. Usable only with
                                 *              the SmartClient server framework.
                                 *  Use the DataSource as a fileSource.            Used automatically by DataSource.listFiles, and
                                 *              would not normally be used directly. Usable only with
                                 *              the SmartClient server framework.
                                 *  Use the DataSource as a fileSource.            Used automatically by DataSource.removeFile, and
                                 *              would not normally be used directly. Usable only with
                                 *              the SmartClient server framework.
                                 *  Use the DataSource as a fileSource.            Used automatically by DataSource.saveFile, and
                                 *              would not normally be used directly. Usable only with
                                 *              the SmartClient server framework.
                                 *  Use the DataSource as a fileSource.            Used automatically by DataSource.renameFile, and
                                 *              would not normally be used directly. Usable only with
                                 *              the SmartClient server framework.
                                 *  Use the DataSource as a fileSource.            Used automatically by DataSource.getFileVersion, and
                                 *              would not normally be used directly. Usable only with
                                 *              the SmartClient server framework.
                                 *  Use the DataSource as a fileSource.            Used automatically by DataSource.hasFileVersion, and
                                 *              would not normally be used directly. Usable only with
                                 *              the SmartClient server framework.
                                 *  Use the DataSource as a fileSource.            Used automatically by DataSource.listFileVersions, and
                                 *              would not normally be used directly. Usable only with
                                 *              the SmartClient server framework.
                                 *  Use the DataSource as a fileSource.            Used automatically by DataSource.removeFileVersion, and
                                 *              would not normally be used directly. Usable only with
                                 *              the SmartClient server framework.
                                 */
                                String /* fetch |  add |  update |  remove |  custom |  validate |  viewFile |  downloadFile |  storeTestData |  clientExport |  getFile |  hasFile |  listFiles |  removeFile |  saveFile |  renameFile |  getFileVersion |  hasFileVersion |  listFileVersions |  removeFileVersion */ = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "FormEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
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
     *  When DataBoundComponent.hiliteIcons are present, where the hilite icon will be placed
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
     *  Default width and height of DataBoundComponent.hiliteIcons for this component.
     *   Can be overridden at the component level via explicit
     *   DataBoundComponent.hiliteIconWidth and
     *   DataBoundComponent.hiliteIconHeight, or at the field level via
     *   ListGridField.hiliteIconSize,
     *   ListGridField.hiliteIconWidth and
     *   ListGridField.hiliteIconHeight
     *  @type {number}
     *  @default "12"
     */
    override var hiliteIconSize: Number = definedExternally
    /**
     *  Width for hilite icons for this component.
     *   Overrides DataBoundComponent.hiliteIconSize.
     *   Can be overridden at the field level.
     *  @type {number}
     *  @default null
     */
    override var hiliteIconWidth: Number = definedExternally
    /**
     *  Height for hilite icons for this listGrid.
     *   Overrides DataBoundComponent.hiliteIconSize.
     *   Can be overridden at the field level
     *  @type {number}
     *  @default null
     */
    override var hiliteIconHeight: Number = definedExternally
    /**
     *  How much padding should there be on the left of DataBoundComponent.hiliteIcons by default?
     *   Can be overridden at the field level
     *  @type {number}
     *  @default "2"
     */
    override var hiliteIconLeftPadding: Number = definedExternally
    /**
     *  How much padding should there be on the right of DataBoundComponent.hiliteIcons by default?
     *   Can be overridden at the field level
     *  @type {number}
     *  @default "2"
     */
    override var hiliteIconRightPadding: Number = definedExternally
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
     *   Binds this dynamicForm to a DynamicForm.valuesManager at runtime.
     * 
     *  @param {ValuesManager | GlobalId} the ValuesManager that controls this                         form's values
     */
    override fun setValuesManager(valuesManager: dynamic): Unit = definedExternally
    /**
     * 
     *   Returns the form item type (Class Name) to be created for some field.
     *   By default field.editorType will be used if present - otherwise backs off to
     *   deriving the appropriate form item type from the data type of the field (see
     *   FormItemType for details.
     * 
     * 
     *  @param {object} field definition for which we are deriving form item type.
     *  @param {object=} Current set of values being edited by this form. May be null.
     */
    open fun getEditorType(field: dynamic, values: dynamic?): String = definedExternally
    /**
     *   Synonym for DynamicForm.setFields
     * 
     * 
     *  @param {Array<Partial<FormItem>>} list of new items to show in the form
     */
    open fun setItems(itemList: Array<dynamic>): Unit = definedExternally
    /**
     *   Set the DynamicForm.fields for this DynamicForm. Takes an array of item
     *   definitions, which will be converted to FormItems and displayed in the form.
     * 
     * 
     *   Note: Do not attempt to create FormItem instances directly. This method should be
     *   passed the raw properties for each item only.
     * 
     * 
     *   Objects passed to setFields() may not be reused in other forms and may not be
     *   used in subsequent calls to setFields() with the same form, new objects must be
     *   created instead.
     * 
     *   To create a form where some items are conditionally present, rather than repeated calls to
     *   setFields() or setItems(), you should generally use
     *   FormItem.hide and FormItem.show and/or FormItem.showIf rather than
     *   calling setItems() or setFields(). setItems() and
     *   setFields() are appropriate for dynamically generated forms where there are
     *   few if any items that are the same each time the form is used.
     * 
     * 
     *  @param {Array<Partial<FormItem>>} list of new items to show in the form
     */
    open fun setFields(itemList: Array<dynamic>): Unit = definedExternally
    /**
     *   Method to retrieve the DynamicForm.fields for this DynamicForm.
     * 
     * 
     */
    open fun getFields(): Array<dynamic> = definedExternally
    /**
     *   Method to retrieve the DynamicForm.fields for this DynamicForm.
     * 
     * 
     */
    open fun getItems(): Array<dynamic> = definedExternally
    /**
     *   This method is called automatically by the DynamicForm when the set of items changes
     *   and ensures that items show up in the correct tab order positions.
     * 
     *   Makes use of DynamicForm.sortItemsIntoTabOrder to order the items and ensures
     *   the items are ordered in the TabIndexManager correctly.
     * 
     */
    open fun assignItemsTabPositions(): Unit = definedExternally
    /**
     *   Helper method to take our specified items and sort them into their desired
     *   tab sequence
     * 
     *   Default behavior will respect explicitly specified tab index as a local tab
     *   index, otherwise just use specified order within the items array
     * 
     */
    open fun sortItemsIntoTabOrder(): Array<dynamic> = definedExternally
    /**
     *   Modify this form's TitleOrientation at runtime
     * 
     *  @param {TitleOrientation} new default item titleOrientation
     */
    open fun setTitleOrientation(orientation: String /* left |  top |  right */): Unit = definedExternally
    /**
     *   Replaces the current values of the entire form with the values passed in.
     * 
     *   Note: when working with a form that is saving to a DataSource, you would typically call
     *   either DynamicForm.editRecord for an existing record, or DynamicForm.editNewRecord for a new
     *   record. In addition to setting the current values of the form, these APIs establish the
     *   DSRequest.operationType used to save ("update" vs "add").
     * 
     *   Values should be provided as an Object containing the new values as properties, where each
     *   propertyName is the name of a Items in the form, and each property value is
     *   the value to apply to that form item via FormItem.setValue.
     * 
     *   Values with no corresponding form item may also be passed, will be tracked by the form
     *   and returned by subsequent calls to DynamicForm.getValues.
     * 
     *   Any FormItem for which a value is not provided will revert to its
     *   FormItem.defaultValue. To cause all FormItems to revert to default
     *   values, pass null.
     * 
     *   This method also calls DynamicForm.rememberValues so that a subsequent later call to
     *   DynamicForm.resetValues will revert to the passed values.
     * 
     * 
     *  @param {object=} values for the form, or null to reset all items to default values
     */
    open fun setValues(newData: dynamic?): Unit = definedExternally
    /**
     *     Make a snapshot of the current set of values, so we can reset to them later.
     *     Creates a new object, then adds all non-method properties of values
     *     to the new object. Use resetValues() to revert to these values.
     *       Note that this method is automatically called when the values for this form are
     *       set programmatically via a call to DynamicForm.setValues.
     * 
     * 
     */
    open fun rememberValues(): dynamic = definedExternally
    /**
     * 
     *   Same as DynamicForm.reset.
     * 
     * 
     */
    open fun resetValues(): Unit = definedExternally
    /**
     *   Reset to default form values and clear errors
     * 
     */
    open fun clearValues(): Unit = definedExternally
    /**
     *   Compares the current set of values with the values stored by the call to the
     *   DynamicForm.rememberValues method. rememberValues() runs when the
     *   form is initialized and on every call to DynamicForm.setValues.
     *   Returns true if the values have changed, and false otherwise.
     * 
     */
    open fun valuesHaveChanged(): Boolean = definedExternally
    /**
     *   Returns the set of values last stored by DynamicForm.rememberValues.
     *   Note that rememberValues() is called automatically by
     *   DynamicForm.setValues, and on form initialization, so this typically contains
     *   all values as they were before the user edited them.
     * 
     * 
     */
    open fun getOldValues(): dynamic = definedExternally
    /**
     *   Returns all values within this DynamicForm that have changed since
     *   DynamicForm.rememberValues last ran. Note that DynamicForm.rememberValues
     *   runs on dynamicForm initialization, and with every call to DynamicForm.setValues
     *   so this will typically contain all values the user has explicitly edited since then.
     * 
     */
    open fun getChangedValues(): dynamic = definedExternally
    /**
     *   An Object containing the values of the form as properties, where each propertyName is
     *   the name of a Items in the form, and each property value is the value
     *   held by that form item.
     * 
     * 
     */
    open fun getValues(): dynamic = definedExternally
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
     * 
     *  @param {ListGridRecord} DataSource record
     *  @param {Canvas | DataSource | GlobalId} schema of the DataSource record, or              DataBoundComponent already bound to that schema
     *  @param {DSCallback=} callback to invoke on completion
     *  @param {DSRequest=} additional properties to set on the DSRequest                      that will be issued
     */
    open fun fetchRelatedData(record: ListGridRecord, schema: dynamic, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Return search criteria based on the current set of values within this form.
     * 
     *   The returned search criteria will be a simple Criteria object, except for
     *   in the following cases, in which case an AdvancedCriteria object will be returned:
     * 
     * 
     *  - The advanced parameter may be passed to explicitly request a
     *   AdvancedCriteria object be returned
     * 
     *  - If DynamicForm.setValuesAsCriteria was called with an AdvancedCriteria
     *     object, this method will return advanced criteria.
     * 
     *  - If DynamicForm.operator is set to "or" rather than
     *     "and" the generated criteria will always be advanced.
     * 
     *  - If any item within this form returns true for FormItem.hasAdvancedCriteria,
     *     which can be caused by setting FormItem.operator, and is always true for
     *     items such as DateRangeItem
     * 
     *  - If FormItem.allowExpressions is enabled
     * 
     *   The criteria returned will be picked up from the current values for this form. For simple
     *   criteria, each form item simply maps its value to it's fieldName. See
     *   FormItem.getCriterion
     * 
     *   for details on how form items generate advanced criteria.
     *   Note that any values or criteria specified via DynamicForm.setValues or
     *   DynamicForm.setValuesAsCriteria which do not correspond to an item within the form will be
     *   combined with the live item values when criteria are generated.
     * 
     *   The returned criteria object can be used to filter data via methods such as
     *   ListGrid.fetchData, DataSource.fetchData, or, for more advanced usage,
     *   ResultSet.setCriteria.
     * 
     *   Note that any form field which the user has left blank is omitted as criteria, that is,
     *   a blank field is assumed to mean "allow any value for this field" and not "this field must
     *   be blank". Examples of empty values include a blank text field or SelectItem with an empty
     *   selection.
     * 
     * 
     *  @param {boolean} if true, return an AdvancedCriteria object even if the  form item values could be represented in a simple Criterion object.
     *  @param {TextMatchStyle=} This parameter may be passed to indicate whether  the criteria are to be applied to a substring match (filter) or exact match (fetch).  When advanced criteria are returned this parameter will cause the appropriate  operator to be generated for individual fields' criterion clauses.
     */
    open fun getValuesAsCriteria(advanced: Boolean, textMatchStyle: 
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
                                                                    String /* exact |  exactCase |  substring |  startsWith */?): dynamic = definedExternally
    /**
     *   This method will display the specified criteria in this form for editing. The criteria
     *   parameter may be a simple Criterion object or an AdvancedCriteria object.
     * 
     *   For simple criteria, the specified fieldName will be used to apply criteria to form items,
     *   as with a standard setValues() call.
     * 
     *   For AdvancedCriteria, behavior is as follows:
     * 
     * 
     *  - If the top level operator doesn't match the DynamicForm.operator for
     *   this form, the entire criteria will be nested in an outer advanced criteria object with
     *   the appropriate operator.
     * 
     *  - Each criterion within AdvancedCriteria will be applied to a form item if
     *   FormItem.shouldSaveValue is true for the item and
     *   FormItem.canEditCriterion returns true for the criterion in question. By default
     *   this method checks for a match with both the fieldName and operator
     *   of the criterion. The criterion is actually passed to the item for editing via
     *   FormItem.setCriterion
     *   .
     *   Note that these methods may be overridden for custom
     *   handling. Also note that the default CanvasItem.setCriterion implementation
     *    handles editing nested criteria via embedded dynamicForms.
     * 
     *  - Criteria which don't map to any form item will be stored directly on the form and
     *   recombined with the edited values from each item when DynamicForm.getValuesAsCriteria is
     *   called.
     * 
     * 
     *  @param {Criterion} criteria to edit.
     */
    open fun setValuesAsCriteria(criteria: Criterion): Unit = definedExternally
    /**
     *   Return an AdvancedCriteria object based on the current set of values within this form.
     * 
     *   Similar to DynamicForm.getValuesAsCriteria, except the returned criteria object
     *   is guaranteed to be an AdvancedCriteria object, even if none of the form's fields has a
     *   specified FormItem.operator
     * 
     * 
     *  @param {TextMatchStyle=} If specified the text match style will be used to  generate the appropriate operator for per field criteria.
     */
    open fun getValuesAsAdvancedCriteria(textMatchStyle: 
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
                                                         String /* exact |  exactCase |  substring |  startsWith */?): AdvancedCriteria = definedExternally
    /**
     *   Retrieve a FormItem in this form by it's FormItem.name,
     *   FormItem.dataPath, or index within
     *   the DynamicForm.items array.
     * 
     *   FormItems that also have a FormItem.ID may be accessed directly as a global variable
     *   window[itemID] or just itemID
     * 
     * 
     *  @param {string | Integer} name of the item you're looking for
     */
    open fun getItem(itemName: dynamic): FormItem = definedExternally
    /**
     *   Synonym for dynamicForm.getItem()
     * 
     * 
     *  @param {FieldName} name of the item you're looking for
     */
    override fun getField(fieldID: dynamic): FormItem = definedExternally
    /**
     *   Returns the value stored in the form for some field.
     * 
     *  @param {string} name of the field for which you're retrieving a value. Nested     values may be retrieved by passing in a DataPath
     */
    open fun getValue(fieldName: String): dynamic = definedExternally
    /**
     *    Sets the value for some field
     * 
     *  @param {string} Name of the field being updated. A DataPath may              be passed to set nested values
     *  @param {string} New value.
     */
    open fun setValue(fieldName: String, value: String): Unit = definedExternally
    /**
     *   Clears the value for some field via a call to FormItem.clearValue if appropriate.
     *   If there is no item associated with the field name, the field will just be cleared within
     *   our stored set of values.
     * 
     *  @param {string} Name of the field being cleared. A DataPath may be used for clearing details of nested data structures.
     */
    open fun clearValue(fieldName: String): Unit = definedExternally
    /**
     *   Show a form item via FormItem.show
     * 
     *  @param {string} Name of the item to show
     */
    open fun showItem(itemName: String): Unit = definedExternally
    /**
     *   Hide a form item via FormItem.hide
     * 
     *  @param {string} Name of the item to show
     */
    open fun hideItem(itemName: String): Unit = definedExternally
    /**
     *   Set the valueMap for a specified item
     * 
     *  @param {string} itemName of the item upon which the valueMap should be set.
     *  @param {ValueMap} new valueMap for the field in question.
     */
    open fun setValueMap(itemName: String, valueMap: dynamic): Unit = definedExternally
    /**
     *   Returns any errors that are currently visible to the user for this form, without performing
     *   validation.
     * 
     * 
     */
    open fun getErrors(): dynamic = definedExternally
    /**
     *   Returns any errors that are currently visible to the user for the specified field in this
     *   form, without performing validation.
     * 
     * 
     *  @param {string} fieldName to check for errors
     */
    open fun getFieldErrors(fieldName: String): dynamic = definedExternally
    /**
     *   Setter for validation errors on this form. Errors passed in should be a Javascript object
     *   of the format
     *   {fieldName1:errors, fieldName2:errors}
     *   Where the errors value may be either a string (single error message) or an
     *   array of strings (if multiple errors should be applied to the field in question).
     * 
     *  @param {object} list of errors as an object with the field names as keys
     *  @param {boolean} If true redraw form to display errors now. Otherwise errors can be displayed by calling    DynamicForm.showErrors    Note: When the errors are shown,    DynamicForm.handleHiddenValidationErrors will    be fired for errors on hidden fields, or with no associated formItem.
     */
    open fun setErrors(errors: dynamic, showErrors: Boolean): Unit = definedExternally
    /**
     *       Sets error message(s) for the specified itemName to the error string or array of
     *       strings. You must call form.markForRedraw() to display the new error message(s).
     *       Note: you can call this multiple times for an individual itemName
     *    which will result in an array of errors being remembered.
     * 
     * 
     *  @param {string} name of the item to set
     *  @param {string | Array<any>} error message string or array of strings
     *  @deprecated \* This method has been deprecated as of SmartClient release 5.7. Use DynamicForm.addFieldErrors or DynamicForm.setFieldErrors instead
     */
    open fun setError(itemName: String, errorMessage: dynamic): Unit = definedExternally
    /**
     *   Adds field validation error[s] to the specified field. Errors passed in will be added
     *   to any existing errors on the field caused by validation or a previous call to this method.
     * 
     *   The errors parameter may be passed in as a string (a single error message), or an array of
     *   strings.
     *   The showErrors parameter allows the errors to be displayed immediately. Alternatively, call
     *   DynamicForm.showFieldErrors to display the errors for this field.
     * 
     *  @param {string} field to apply the new errors to
     *  @param {string | Array<Partial<string>>} errors to apply to the field in question
     *  @param {boolean} If true this method will fall through to DynamicForm.showFieldErrors to update the display
     */
    open fun addFieldErrors(fieldName: String, errors: dynamic, show: Boolean): Unit = definedExternally
    /**
     *   Set field validation error[s] for some field.
     *   The errors parameter may be passed in as a string (a single error message), or an array of
     *   strings.
     *   The showErrors parameter allows the errors to be displayed immediately. Alternatively, an
     *   explicit call to DynamicForm.showFieldErrors will display the errors for this field.
     * 
     *  @param {string} field to apply the new errors to
     *  @param {string | Array<Partial<string>>} errors to apply to the field in question
     *  @param {boolean} If true this method will fall through to DynamicForm.showFieldErrors to update the display
     */
    open fun setFieldErrors(fieldName: String, errors: dynamic, show: Boolean): Unit = definedExternally
    /**
     *   Clear any validation errors on the field passed in.
     * 
     *  @param {string} field to clear errors from
     *  @param {boolean} If true this method will fall through to DynamicForm.showFieldErrors to update the display
     */
    open fun clearFieldErrors(fieldName: String, show: Boolean): Unit = definedExternally
    /**
     *   Clears all errors for this DynamicForm.
     * 
     *  @param {boolean} If true, redraw the form to clear any visible error messages.
     */
    open fun clearErrors(show: Boolean): Unit = definedExternally
    /**
     *   Returns whether there are currently any errors visible to the user for this form, without
     *   performing validation.
     * 
     *   Note that validation errors are set up automatically by validation (see DynamicForm.validate),
     *   or may be explicitly set via DynamicForm.setErrors or
     *   DynamicForm.setFieldErrors.
     * 
     */
    open fun hasErrors(): Boolean = definedExternally
    /**
     *   Returns whether there are currently any errors visible to the user for the specified field in
     *   this form, without performing any validation.
     * 
     *   Note that validation errors are set up automatically by validation (see DynamicForm.validate),
     *   or may be explicitly set via DynamicForm.setErrors or
     *   DynamicForm.setFieldErrors.
     * 
     *  @param {string} field to test for validation errors
     */
    open fun hasFieldErrors(fieldName: String): Boolean = definedExternally
    /**
     *   If DynamicForm.showInlineErrors is false, the form will render all errors in a list at
     *   the top of the form. This method returns the HTML for this list of errors.
     * 
     *  @param {object} Map of field names to error messages. Each field may contain a single            error message (string) or an array of errors
     */
    open fun getErrorsHTML(errors: dynamic): String = definedExternally
    /**
     *   If DynamicForm.showInlineErrors is true, this method is called for each item in the form
     *   and returns the error HTML to be written out next to the item.
     *   Default implementation falls through to FormItem.getErrorHTML on the item in question.
     * 
     *  @param {FormItem} Form item for which the HTML should be retrieved
     *  @param {string | Array<any>} Error message to display for the item, or array of error message               strings.
     */
    open fun getItemErrorHTML(item: FormItem, error: dynamic): Unit = definedExternally
    /**
     *   Return the orientation of the title for a specific item or the default title orientation if
     *   no item is passed.
     * 
     * 
     *  @param {FormItem=} item to check
     */
    open fun getTitleOrientation(item: FormItem?): String /* left |  top |  right */ = definedExternally
    /**
     *   Get the alignment for the title for some item. Default implementation is as follows:
     * 
     *  - If FormItem.titleAlign is specified, it will be respected
     * 
     *  - Otherwise if DynamicForm.titleAlign is set, it will be
     *       respected
     * 
     *  - Otherwise titles will be aligned according to Page.isRTL,
     *       with this method returning "right" if text direction is LTR,
     *       or "left" if text direction is RTL.
     * 
     * 
     *  @param {FormItem} item for which we're getting title alignment
     */
    open fun getTitleAlign(item: FormItem): 
                                            /**
                                             *  Center within container.
                                             *  Stick to left side of container.
                                             *  Stick to right side of container.
                                             */
                                            String /* center |  left |  right */ = definedExternally
    /**
     *   Is the title for the given form item clipped? The form item must have title clipping enabled.
     * 
     * 
     *  @param {FormItem} the form item.
     */
    open fun titleClipped(item: FormItem): Boolean = definedExternally
    /**
     *   Submits the form to the URL defined by DynamicForm.action,
     *   identically to how a plain HTML &lt;form&gt; element would submit data,
     *   as either an HTTP GET or POST as specified by DynamicForm.method.
     * 
     *   Notes:
     * 
     * 
     *  - this is used only in the very rare case that a form is used to submit data
     *   directly to a URL. Normal server contact is through
     *   dataBoundComponentMethods.
     * 
     *  - For this method to reliably include values for every field in the grid,
     *     DynamicForm.canSubmit must be set to true
     * 
     *  - To submit values for fields that do not have an editor, use HiddenItem
     *   with a FormItem.defaultValue set. This is analogous to &lt;input type="hidden"&gt;
     *   in HTML forms.
     * 
     * 
     */
    open fun submitForm(): Unit = definedExternally
    /**
     *   Method called when an attempt to DynamicForm.submitForm a
     *   form is unable to submit to the server. Default behavior is to display the
     *   DynamicForm.formSubmitFailedWarning in a warning dialog.
     *   The most common cause for this failure is that the user
     *   has typed an invalid file-path into an upload type field.
     * 
     */
    open fun formSubmitFailed(): Unit = definedExternally
    /**
     *   Sets the DynamicForm.action for this form.
     * 
     *  @param {URL} New action URL
     */
    open fun setAction(action: String): Unit = definedExternally
    /**
     *   Sets the DynamicForm.target for this form.
     * 
     *  @param {string} New submission target
     */
    open fun setTarget(target: String): Unit = definedExternally
    /**
     *   Sets the DynamicForm.method for this form.
     * 
     *  @param {FormMethod} html form submission method (get or post)
     */
    open fun setMethod(method: 
                               /**
                                *  GET request -- URL encoding (~4K max)
                                *  POST request -- separate field encoding (no max)
                                */
                               String /* GET |  POST */): Unit = definedExternally
    /**
     *   Validates the form without submitting it, and redraws the form to display error messages
     *   if there are any validation errors. Returns true if validation succeeds, or false if
     *   validation fails.
     * 
     *   For databound forms, any DataSource field validators will be run even if there is no
     *   associated item in the form. Validators will also be run on hidden form items. In both
     *   these cases, validation failure can be handled via
     *   DynamicForm.handleHiddenValidationErrors.
     * 
     *   If this form has any fields which require server-side validation (see
     *   Validator.serverCondition) this will also be initialized. Such validation will
     *   occur asynchronously. Developers can use DynamicForm.isPendingAsyncValidation and
     *   DynamicForm.handleAsyncValidationReply to detect and respond to asynchronous
     *   validation.
     * 
     *   Note that for silent validation, DynamicForm.valuesAreValid (client-side) and
     *   DynamicForm.checkForValidationErrors (client and server-side) can be used instead.
     * 
     * 
     *  @param {boolean=} Should validators be processed for non-visible fields     such as dataSource fields with no associated item or fields with visibility set to     "hidden"?
     */
    open fun validate(validateHiddenFields: Boolean?): Boolean = definedExternally
    /**
     *   Method to determine whether the current form values would pass validation.
     *   This method operates client-side, without contacting the server, running validators on the
     *   form's values and returning a value indicating whether validation was successful.
     * 
     *   Unlike DynamicForm.validate this method will not store the errors on the DynamicForm
     *   or display them to the user.
     * 
     *   Note that DynamicForm.checkForValidationErrors allows for checking for server-side errors, and
     *   finding out what those errors are via a callback.
     * 
     * 
     *  @param {boolean} Should validators be processed for non-visible fields     such as dataSource fields with no associated item or fields with visibility set to     "hidden"?
     *  @param {boolean=} If unset, this method returns a simple boolean value indicating success or failure of validation. If this parameter is passed, this method will return an object mapping each field name to the errors(s) encountered on validation failure, or null if validation was successful.
     */
    open fun valuesAreValid(validateHiddenFields: Boolean, returnErrors: Boolean?): dynamic = definedExternally
    /**
     *   Performs silent validation of the current form values, like DynamicForm.valuesAreValid. In
     *   contrast to DynamicForm.valuesAreValid, this method allows checking for server-side errors, and
     *   finding out what the errors are.
     * 
     *   The callback must be passed unless server-side validation is being skipped, and If passed,
     *   it always fires, errors or not, firing synchronously if server validation is skipped.
     * 
     * 
     *  @param {ValidationStatusCallback} callback to invoke after validation is complete
     *  @param {boolean=} should validators be processed for non-visible fields     such as dataSource fields with no associated item or fields with visibility set to     "hidden"
     *  @param {boolean=} whether to skip doing server-side validation
     */
    open fun checkForValidationErrors(callback: ((errorMap: Map<dynamic>) -> Unit), validateHiddenFields: Boolean?, skipServerValidation: Boolean?): Map<dynamic> = definedExternally
    /**
     *   Call DynamicForm.validate to check for validation errors. If no errors are found,
     *   return the current values for this form, otherwise return null.
     * 
     */
    open fun getValidatedValues(): dynamic = definedExternally
    /**
     *   If this form has any outstanding validation errors, show them now.
     *   This method is called when the set of errors is changed by DynamicForm.setErrors or
     *   DynamicForm.validate.
     *   Default implementation will redraw the form to display error messages and call
     *   DynamicForm.handleHiddenValidationErrors to
     *   display errors with no visible field.
     *   Note that this method may be overridden to perform custom display of validation errors.
     * 
     */
    open fun showErrors(): Unit = definedExternally
    /**
     *   If this form has any outstanding validation errors for the field passed in, show them now.
     *   Called when field errors are set directly via DynamicForm.setFieldErrors /
     *   DynamicForm.addFieldErrors / DynamicForm.clearFieldErrors.
     *   Default implementation simply falls through to DynamicForm.showErrors.
     * 
     *  @param {string} field to show errors for
     */
    open fun showFieldErrors(fieldName: String): Unit = definedExternally
    /**
     *   Returns true if this DynamicForm has the keyboard focus.
     * 
     *   Unlike standard canvases, for a DynamicForm this method will return true when keyboard
     *   focus is currently on one of the form's DynamicForm.items.
     * 
     *   Note that in some cases the items of a form may be written directly into a different
     *   FormItem.containerWidget. In this case the dynamicForm containing the
     *   items may not have been drawn on the page itself, but this method can still return true
     *   if one of the items has focus.
     * 
     */
    override fun isFocused(): Boolean = definedExternally
    /**
     *   Return the current focus item for this form.
     * 
     *   This is the item which either currently has focus, or if focus is not
     *   currently within this form, would be given focus on a call to
     *   DynamicForm.focus. May return null if this form has never had focus,
     *   in which case a call to form.focus() would put focus into the
     *   first focusable item within the the form.
     * 
     *   Note that if focus is currently in a sub-item of a class:ContainerItem,
     *   this method will return the parent ContainerItem, not the sub-item.
     * 
     */
    open fun getFocusItem(): FormItem = definedExternally
    /**
     *   Give keyboard focus to this form. If this form has had focus before, focus will be
     *   passed to the item which last had focus (see DynamicForm.getFocusItem) -
     *   otherwise focus will be passed to the first focusable item in the form.
     * 
     *   To put focus in a specific item, use DynamicForm.focusInItem instead.
     * 
     */
    override fun focus(): Unit = definedExternally
    /**
     *   Move the keyboard focus into a particular item.
     * 
     *  @param {number | string | FormItem} Item (or reference to) item to focus in.
     */
    open fun focusInItem(itemName: dynamic): Unit = definedExternally
    /**
     *   If the current mouse event occurred over an item in this dynamicForm, returns that item.
     * 
     */
    open fun getEventItem(): FormItem = definedExternally
    /**
     *   If the current mouse event occurred over an item, or the title of an item in this
     *   dynamicForm, return details about where the event occurred.
     * 
     */
    open fun getEventItemInfo(): FormItemEventInfo = definedExternally
    /**
     *   Retrieves the HTML to display in a hover canvas when the user holds the mouse pointer over
     *   some item. Return null to suppress the hover canvas altogether.
     *   Default implementation returns the prompt for the item if defined.
     *   Can be overridden via item.itemHoverHTML()
     * 
     * 
     *  @param {FormItem} Item the user is hovering over.
     */
    open fun itemHoverHTML(item: FormItem): Unit = definedExternally
    /**
     *   Retrieves the HTML to display in a hover canvas when the user holds the mouse pointer over
     *   some item's title. Return null to suppress the hover canvas altogether.
     *   Default implementation returns the prompt for the item if defined. If no prompt is defined
     *   and the item title is clipped, the item title will be shown in a hover by default.
     *   Can be overridden by FormItem.titleHoverHTML.
     * 
     * 
     *  @param {FormItem} Item the user is hovering over.
     */
    open fun titleHoverHTML(item: FormItem): String = definedExternally
    /**
     *   Retrieves the HTML to display in a hover canvas when the user holds the mousepointer over
     *   some item's value. Return null to suppress the hover canvas altogether.
     *   Can be overridden by FormItem.valueHoverHTML.
     * 
     * 
     *  @param {FormItem} Item the user is hovering over.
     */
    open fun valueHoverHTML(item: FormItem): Unit = definedExternally
    /**
     *   Is this form editable or read-only? Setting the form to non-editable causes all
     *   form items to render as read-only unless a form item is specifically marked as editable
     *   (the item's FormItem.canEdit attribute is true).
     * 
     * 
     *  @param {boolean} Can this form be edited?
     */
    open fun setCanEdit(canEdit: Boolean): Unit = definedExternally
    /**
     *   Can the field be edited? This method looks at DynamicForm.canEdit for the grid as well as the
     *   FormItem.canEdit value, to determine whether editing is actually allowed.
     *   For a detailed discussion, see the documentation at DynamicForm.canEdit.
     * 
     * 
     *  @param {FormItem | number | string} field object or identifier
     */
    override fun fieldIsEditable(field: dynamic): Boolean = definedExternally
    /**
     *   Setter for the DynamicForm.readOnlyDisplay attribute.
     * 
     *  @param {ReadOnlyDisplayAppearance} New read-only display appearance.
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
     *   Handler fired when the entire set of values is replaced, as by a call to
     *   DynamicForm.setValues, DynamicForm.resetValues or DynamicForm.editRecord.
     * 
     *   Note that it is invalid to call such methods from this handler because doing so would
     *   result in an infinite loop.
     * 
     * 
     */
    open fun valuesChanged(): Unit = definedExternally
    /**
     *   Handler fired when there is a changed() event fired on a FormItem within this form.
     * 
     *   Fires after the change() handler on the FormItem itself, and only if the item did not
     *   cancel the change event and chooses to allow it to propagate to the form as a whole.
     * 
     * 
     *  @param {FormItem} the FormItem where the change event occurred
     *  @param {any} new value for the FormItem
     */
    open fun itemChanged(item: FormItem, newValue: dynamic): Unit = definedExternally
    /**
     *   Handler fired when there is a change() event fired on a FormItem within this form.
     * 
     *   Fires after the change() handler on the FormItem itself, and only if the item did not
     *   cancel the change event and chooses to allow it to propagate to the form as a whole.
     * 
     * 
     *  @param {FormItem} the FormItem where the change event occurred
     *  @param {any} new value for the FormItem
     *  @param {any} value the FormItem had previous to this change() event
     */
    open fun itemChange(item: FormItem, newValue: dynamic, oldValue: dynamic): Boolean = definedExternally
    /**
     *   Handler fired when a FormItem within this form receives a keypress event.
     * 
     *   Fires after the keyPress handler on the FormItem itself, and only if the item did not
     *   cancel the event and chooses to allow it to propagate to the form as a whole.
     * 
     * 
     *  @param {FormItem} the FormItem where the change event occurred
     *  @param {KeyName} name of the key that was pressed (EG: "A", "Space")
     *  @param {number} numeric character value of the pressed key.
     */
    open fun itemKeyPress(item: FormItem, keyName: String, characterValue: Number): Boolean = definedExternally
    /**
     *   Called when the mouse is right-clicked in some formItem. If the implementation
     *   returns false, default browser behavior is cancelled.
     * 
     *   Note that it can be bad practice to cancel this method if the mouse is over the data
     *   element of an item, because doing so would replace the builtin browser-default menus
     *   that users may expect. You can use DynamicForm.getEventItemInfo to return an
     *   FormItemEventInfo that can be used to determine which part of the
     *   item is under the mouse.
     * 
     * 
     *  @param {FormItem} the form item showing its context menu
     */
    open fun showItemContextMenu(item: FormItem): Boolean = definedExternally
    /**
     *   Triggered when a SubmitItem is included in the form is submitted and gets pressed.
     * 
     * 
     *  @param {object} the form values
     *  @param {DynamicForm} the form being submitted
     */
    open fun submitValues(values: dynamic, form: DynamicForm): Unit = definedExternally
    /**
     *   Method to display validation error messages for fields that are not currently visible
     *   in this form.
     *   This will be called when validation fails for
     *   - a hidden field in this form
     *   - if this form is databound, a datasource field with specified validators, for which we
     *    have no specified form item.
     *   Implement this to provide custom validation error handling for these fields.
     *   By default hidden validation errors will be logged as warnings in the developerConsole.
     *   Return false from this method to suppress that behavior.
     * 
     *  @param {object} The set of errors returned - this is an object of the form           &nbsp;&nbsp;{fieldName:errors}            Where the 'errors' object is either a single string or an array            of strings containing the error messages for the field.
     */
    open fun handleHiddenValidationErrors(errors: dynamic): Boolean = definedExternally
    /**
     *   Notification fired when an asynchronous validation completes.
     * 
     *  @param {boolean} true if validation succeeded, false if it failed
     *  @param {object} Map of errors by fieldName. Will be null if validation succeeded.
     */
    open fun handleAsyncValidationReply(success: Boolean, errors: dynamic): Unit = definedExternally
    /**
     *   Is this component waiting for an asynchronous validation to complete?
     *   This method will return true after DynamicForm.validate is called on a component with
     *   server-side validators for some field(s), until the server responds.
     * 
     *   Note that the notification method DynamicForm.handleAsyncValidationReply will be fired
     *   when validation completes.
     * 
     */
    open fun isPendingAsyncValidation(): Boolean = definedExternally
    /**
     * 
     *   Prepare to edit a new record by clearing the current set of values (or replacing them
     *   with initialValues if specified).
     * 
     *   This method will also call DynamicForm.setSaveOperationType to ensure
     *   subsequent calls to saveData() will use an add rather than
     *   an update operation.
     * 
     * 
     *  @param {object | Record=} initial set of values for the editor as a map of field names to their corresponding   values
     */
    open fun editNewRecord(initialValues: dynamic?): Unit = definedExternally
    /**
     * 
     *   Edit an existing record. Updates this editors values to match the values of the record
     *   passed in, via DynamicForm.setValues.
     * 
     *   This method will also call DynamicForm.setSaveOperationType to ensure
     *   subsequent calls to saveData() will use an update rather than
     *   an add operation.
     * 
     * 
     *  @param {Record} the record to be edited as a map of field names to their corresponding values
     */
    open fun editRecord(record: Record): Unit = definedExternally
    /**
     * 
     *   Edit the record selected in the specified selection component (typically a
     *   ListGrid).
     * 
     *   Updates the values of this editor to match the selected record's values.
     * 
     *   If this form has a dataSource, then saving via DynamicForm.saveData will use the
     *   "update" operation type.
     * 
     * 
     *  @param {ListGrid | GlobalId} the ListGrid or ID of a ListGrid whose currently selected   record(s) is/are to be edited
     */
    open fun editSelectedData(selectionComponent: dynamic): Unit = definedExternally
    /**
     * 
     *   validateData() can be used to check for errors in server-side validators
     *   without showing such errors to the user. Errors, if any, can be discovered by looking at
     *   the DSResponse object returned in the callback.
     * 
     *   validateData() will first call DynamicForm.validate to check for client-side
     *   errors, and will return false without contacting the server if errors are
     *   present. In this case, any errors detected client-side will be displayed; to avoid this
     *   and purely perform silent, server-side validation, you can use
     *   DataSource.validateData with the form's DynamicForm.getValues.
     *   DynamicForm.valuesAreValid can be used in lieu of a call to DynamicForm.validate if silent
     *   checking of client-side errors is also desired.
     * 
     * 
     *  @param {DSCallback=} callback to invoke on completion
     *  @param {DSRequest=} additional properties to set on                          the DSRequest that will be issued
     */
    open fun validateData(callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Boolean = definedExternally
    /**
     * 
     *   Resets values to the state it was the last time setValues() or
     *   rememberValues() was called. If neither of those methods has been called,
     *   values will be set back to their initial values at init time.
     * 
     * 
     */
    open fun reset(): Unit = definedExternally
    /**
     * 
     *   This method exists for clean integration with existing server frameworks that have a 'cancel'
     *   feature which typically clears session state associated with the form. When this method is
     *   called, an RPC is sent to the server with a parameter named
     *   DynamicForm.cancelParamName with the value
     *   DynamicForm.cancelParamValue.
     * 
     *   Note that no other form data is sent. By default the current top-level page is replaced with the
     *   reply. If you wish to ignore the server reply instead, call this method like this:
     * 
     *   dynamicFormInstance.cancel({ignoreTimeout: true, target: null});
     * 
     * 
     *  @param {DSRequest=} additional properties to set on the RPCRequest                     that will be issued
     */
    open fun cancel(requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   If the form or valuesManager has associated userTask workflow task than notify it about
     *   cancelling the changes.
     * 
     */
    open fun cancelEditing(): Unit = definedExternally
    /**
     *   Finish editing and store edited values in Process.state.
     * 
     */
    open fun completeEditing(): Unit = definedExternally
    /**
     *   submit() is automatically called when a SubmitItem included in the
     *   form is clicked, or, if DynamicForm.saveOnEnter is set, when the
     *   "Enter" key is pressed in a text input. Submit can also be manually called.
     * 
     *   If this form is part of a ValuesManager, this method will simply fall through to
     *   the submit method on the valuesManager. If not, and
     *   DynamicForm.submitValues exists, it will be called, and
     *   no further action will be taken.
     * 
     *   Otherwise, default behavior varies based on DynamicForm.canSubmit: if
     *   canSubmit is false, DynamicForm.saveData will be called to
     *   handle saving via SmartClient databinding.
     * 
     *   If canSubmit is true, the form will be submitted like an ordinary HTML
     *   form via DynamicForm.submitForm.
     * 
     *   The parameters to submit() apply only if submit() will be
     *   calling DynamicForm.saveData. If you override submit(), you can safely
     *   ignore the parameters as SmartClient framework code does not pass them.
     * 
     * 
     *  @param {DSCallback=} callback to invoke on completion.                     [Ignored if this.canSubmit is true]
     *  @param {DSRequest=} additional properties to set on the DSRequest                     that will be issued                      [Ignored if this.canSubmit is true]
     */
    open fun submit(callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     * 
     *   Validate and then save the form's current values to the DataSource this form is
     *   bound to.
     * 
     *   If client-side validators are defined, they are executed first, and if any errors are
     *   found the save is aborted and the form will show the errors.
     * 
     *   If client-side validation passes, a DSRequest will be sent, exactly as though
     *   DataSource.addData or DataSource.updateData had been called with
     *   ${isc.DocUtils.linkForRef('method:DynamicForm.getValues','the form\'s values')} as data. The
     *   DSRequest.operationType will be either "update" or "add", depending on the
     *   current DynamicForm.saveOperationType.
     * 
     *   On either a client-side or server-side validation failure, validation errors will be
     *   displayed in the form. Visible items within a DynamicForm will be redrawn to display
     *   errors. Validation failure occurring on hidden items, or DataSource fields with no
     *   associated form items may be handled via DynamicForm.handleHiddenValidationErrors
     *   or ValuesManager.handleHiddenValidationErrors.
     * 
     *   In the case of a validation error, the callback will not be called by default
     *   since the form has already handled the failed save by displaying the validation errors
     *   to the user. If you need to do something additional in this case, you can set
     *   RPCRequest.willHandleError via the requestProperties parameter to
     *   force your callback to be invoked. However, first consider:
     * 
     * 
     *  - if you are trying to customize display of validation errors, there are several
     *   DynamicForm.showErrorIcons and DynamicForm.showErrors may be a better
     *   place to put customizations.
     * 
     *  - for unrecoverable general errors (eg server is down),
     *   RPCManager.handleError in invoked, so consider placing
     *   customizations there unless an unrecoverable error should be handled specially by this
     *   specific form.
     * 
     * 
     * 
     *  @param {DSCallback=} callback to invoke on completion
     *  @param {DSRequest=} additional properties to set on the DSRequest                      that will be issued
     */
    open fun saveData(callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Returns true if DynamicForm.saveOperationType is currently "add". See
     *   DynamicForm.saveOperationType.
     * 
     * 
     */
    open fun isNewRecord(): Boolean = definedExternally
    /**
     *   Setter for the default DSOperationType when DynamicForm.saveData is called.
     *   Note that this property can also be set by calling DynamicForm.editRecord or
     *   DynamicForm.editNewRecord
     * 
     * 
     *  @param {DSOperationType} Operation type to use as a default. Valid values are "add" or "update".
     */
    open fun setSaveOperationType(operationType: 
                                                 /**
                                                  *  Fetch one or more records that match a set of search criteria.
                                                  *  Store new records
                                                  *  Update an existing record
                                                  *  Remove (delete) an existing record
                                                  *  perform some arbitrary custom logic that is not a CRUD operation.            Format of the inputs and outputs is unconstrained, and the operation
                                                  *              will be ignored for cache sync purposes by ResultSets. See
                                                  *              DataSource.performCustomOperation.
                                                  *  Run server-side validation for "add" or "update" without actually            adding or updating anything. See DataSource.validateData.
                                                  *  Retrieve a file stored in a binary field in a DataSource record, and            allow the browser to choose whether to view it directly or prompt the
                                                  *              user to save. See binaryFields.
                                                  *  Like "viewFile", but the HTTP header Content-Disposition is used to            suggest that the browser show a save dialog. See binaryFields.
                                                  *  Takes a List of Maps and stores the data in Admin Console XML test            data format
                                                  *  Upload formatted client data and export it to Excel, XML and other            formats. Used automatically by
                                                  *              DataSource.exportClientData
                                                  *              and cannot be used directly. Usable only with the SmartClient server
                                                  *              framework.
                                                  *  Use the DataSource as a fileSource.            Used automatically by DataSource.getFile, and
                                                  *              would not normally be used directly. Usable only with
                                                  *              the SmartClient server framework.
                                                  *  Use the DataSource as a fileSource.            Used automatically by DataSource.hasFile, and
                                                  *              would not normally be used directly. Usable only with
                                                  *              the SmartClient server framework.
                                                  *  Use the DataSource as a fileSource.            Used automatically by DataSource.listFiles, and
                                                  *              would not normally be used directly. Usable only with
                                                  *              the SmartClient server framework.
                                                  *  Use the DataSource as a fileSource.            Used automatically by DataSource.removeFile, and
                                                  *              would not normally be used directly. Usable only with
                                                  *              the SmartClient server framework.
                                                  *  Use the DataSource as a fileSource.            Used automatically by DataSource.saveFile, and
                                                  *              would not normally be used directly. Usable only with
                                                  *              the SmartClient server framework.
                                                  *  Use the DataSource as a fileSource.            Used automatically by DataSource.renameFile, and
                                                  *              would not normally be used directly. Usable only with
                                                  *              the SmartClient server framework.
                                                  *  Use the DataSource as a fileSource.            Used automatically by DataSource.getFileVersion, and
                                                  *              would not normally be used directly. Usable only with
                                                  *              the SmartClient server framework.
                                                  *  Use the DataSource as a fileSource.            Used automatically by DataSource.hasFileVersion, and
                                                  *              would not normally be used directly. Usable only with
                                                  *              the SmartClient server framework.
                                                  *  Use the DataSource as a fileSource.            Used automatically by DataSource.listFileVersions, and
                                                  *              would not normally be used directly. Usable only with
                                                  *              the SmartClient server framework.
                                                  *  Use the DataSource as a fileSource.            Used automatically by DataSource.removeFileVersion, and
                                                  *              would not normally be used directly. Usable only with
                                                  *              the SmartClient server framework.
                                                  */
                                                 String /* fetch |  add |  update |  remove |  custom |  validate |  viewFile |  downloadFile |  storeTestData |  clientExport |  getFile |  hasFile |  listFiles |  removeFile |  saveFile |  renameFile |  getFileVersion |  hasFileVersion |  listFileVersions |  removeFileVersion */): Unit = definedExternally
    /**
     *   Returns the DSOperationType to be performed when DynamicForm.saveData is
     *   called. Valid options are "add" or "update".
     * 
     *   If a DSRequest configuration object is passed in containing an explicit operationType
     *   this will be returned. Otherwise DynamicForm.saveOperationType will be returned.
     *   This attribute is automatically set via calls to data binding methods such as
     *   DynamicForm.editNewRecord, or it may be set explicitly.
     * 
     *   If no explicit saveOperationType is specified for this form, the system will
     *   look at the current values for the form. If the form has no value for
     *   the DataSource.getPrimaryKeyField, or that field is
     *   editable and has been modified we assume an add operation, otherwise an update.
     *   If the form is a member of a ValuesManager, the primary key field value
     *   will be derived from the valuesManager's values object.
     * 
     * 
     *  @param {DSRequest=} Optional DSRequest config block for the save operation
     */
    open fun getSaveOperationType(requestProperties: DSRequest?): 
                                                                  /**
                                                                   *  Fetch one or more records that match a set of search criteria.
                                                                   *  Store new records
                                                                   *  Update an existing record
                                                                   *  Remove (delete) an existing record
                                                                   *  perform some arbitrary custom logic that is not a CRUD operation.            Format of the inputs and outputs is unconstrained, and the operation
                                                                   *              will be ignored for cache sync purposes by ResultSets. See
                                                                   *              DataSource.performCustomOperation.
                                                                   *  Run server-side validation for "add" or "update" without actually            adding or updating anything. See DataSource.validateData.
                                                                   *  Retrieve a file stored in a binary field in a DataSource record, and            allow the browser to choose whether to view it directly or prompt the
                                                                   *              user to save. See binaryFields.
                                                                   *  Like "viewFile", but the HTTP header Content-Disposition is used to            suggest that the browser show a save dialog. See binaryFields.
                                                                   *  Takes a List of Maps and stores the data in Admin Console XML test            data format
                                                                   *  Upload formatted client data and export it to Excel, XML and other            formats. Used automatically by
                                                                   *              DataSource.exportClientData
                                                                   *              and cannot be used directly. Usable only with the SmartClient server
                                                                   *              framework.
                                                                   *  Use the DataSource as a fileSource.            Used automatically by DataSource.getFile, and
                                                                   *              would not normally be used directly. Usable only with
                                                                   *              the SmartClient server framework.
                                                                   *  Use the DataSource as a fileSource.            Used automatically by DataSource.hasFile, and
                                                                   *              would not normally be used directly. Usable only with
                                                                   *              the SmartClient server framework.
                                                                   *  Use the DataSource as a fileSource.            Used automatically by DataSource.listFiles, and
                                                                   *              would not normally be used directly. Usable only with
                                                                   *              the SmartClient server framework.
                                                                   *  Use the DataSource as a fileSource.            Used automatically by DataSource.removeFile, and
                                                                   *              would not normally be used directly. Usable only with
                                                                   *              the SmartClient server framework.
                                                                   *  Use the DataSource as a fileSource.            Used automatically by DataSource.saveFile, and
                                                                   *              would not normally be used directly. Usable only with
                                                                   *              the SmartClient server framework.
                                                                   *  Use the DataSource as a fileSource.            Used automatically by DataSource.renameFile, and
                                                                   *              would not normally be used directly. Usable only with
                                                                   *              the SmartClient server framework.
                                                                   *  Use the DataSource as a fileSource.            Used automatically by DataSource.getFileVersion, and
                                                                   *              would not normally be used directly. Usable only with
                                                                   *              the SmartClient server framework.
                                                                   *  Use the DataSource as a fileSource.            Used automatically by DataSource.hasFileVersion, and
                                                                   *              would not normally be used directly. Usable only with
                                                                   *              the SmartClient server framework.
                                                                   *  Use the DataSource as a fileSource.            Used automatically by DataSource.listFileVersions, and
                                                                   *              would not normally be used directly. Usable only with
                                                                   *              the SmartClient server framework.
                                                                   *  Use the DataSource as a fileSource.            Used automatically by DataSource.removeFileVersion, and
                                                                   *              would not normally be used directly. Usable only with
                                                                   *              the SmartClient server framework.
                                                                   */
                                                                  String /* fetch |  add |  update |  remove |  custom |  validate |  viewFile |  downloadFile |  storeTestData |  clientExport |  getFile |  hasFile |  listFiles |  removeFile |  saveFile |  renameFile |  getFileVersion |  hasFileVersion |  listFileVersions |  removeFileVersion */ = definedExternally
    /**
     *   Retrieve data that matches the provided criteria, and edit the first record returned
     * 
     * 
     *  @param {Criteria=} search criteria
     *  @param {DSCallback=} callback to invoke on completion
     *  @param {DSRequest=} additional properties to set on the DSRequest                      that will be issued
     */
    open fun fetchData(criteria: dynamic?, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Retrieve data that matches the provided criteria, and edit the first record returned.
     *   Differs from DynamicForm.fetchData in that a case insensitive substring match
     *   will be performed against the criteria to retrieve the data.
     * 
     * 
     *  @param {Criteria=} search criteria
     *  @param {DSCallback=} callback to invoke on completion
     *  @param {DSRequest=} additional properties to set on the DSRequest                      that will be issued
     */
    open fun filterData(criteria: dynamic?, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
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
         *  A declared value of the enum type
         *   FormMethod.
         *  @type {Constant}
         *  @default "GET"
         */
        var GET: String = definedExternally
        /**
         *  A declared value of the enum type
         *   FormMethod.
         *  @type {Constant}
         *  @default "POST"
         */
        var POST: String = definedExternally
        /**
         *  A declared value of the enum type
         *   Encoding.
         *  @type {Constant}
         *  @default "normal"
         */
        var NORMAL: String = definedExternally
        /**
         *  A declared value of the enum type
         *   Encoding.
         *  @type {Constant}
         *  @default "multipart"
         */
        var MULTIPART: String = definedExternally
        /**
         *  Creates a new DynamicForm
         * 
         *  @param typeCheckedProperties {Partial<DynamicForm>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DynamicForm} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DynamicForm = definedExternally
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