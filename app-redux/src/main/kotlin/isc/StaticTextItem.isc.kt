@file:JsQualifier("isc")
package isc

/**
 *  A FormItem that displays an uneditable value.
 */
open external class StaticTextItem : FormItem {
    /**
     *  If FormItem.height is specified, should it be applied to the
     *   item's text box element?
     * 
     *   Overridden to be false for StaticTextItems by default.
     * 
     *   See FormItem.shouldApplyHeightToTextBox for more information.
     *  @type {boolean}
     *  @default false
     */
    override var applyHeightToTextBox: Boolean = definedExternally
    /**
     *  If the FormItem.textAlign is unset, should the FormItem.align
     *   setting, if set, be used for this StaticTextItem's textAlign?
     *  @type {boolean}
     *  @default true
     */
    override var applyAlignToText: Boolean = definedExternally
    /**
     *  If true, item contents can wrap. If false, all the contents should appear on a single line.
     *  @type {boolean}
     *  @default true
     */
    open var wrap: Boolean = definedExternally
    /**
     *  If true, text that exceeds the specified size of the form item will be clipped.
     *  @type {boolean}
     *  @default false
     */
    open var clipValue: Boolean = definedExternally
    /**
     *  Base CSS class for this item
     *  @type {FormItemBaseStyle}
     *  @default "staticTextItem"
     */
    override var textBoxStyle: String = definedExternally
    /**
     *  Should the user be able to select the text in this item?
     *  @type {boolean}
     *  @default true
     */
    override var canSelectText: Boolean = definedExternally
    /**
     *  By default HTML values in a staticTextItem will be interpreted by the browser.
     *   Setting this flag to true will causes HTML characters to be escaped, meaning the
     *   raw value of the field (for example "&lt;b&gt;AAA&lt;/b&gt;") is displayed
     *   to the user rather than the interpreted HTML (for example "AAA")
     *  @deprecated \* in favor of StaticTextItem.escapeHTML
     *  @type {boolean}
     *  @default null
     */
    open var outputAsHTML: Boolean = definedExternally
    /**
     *  Display format to use for date type values within this formItem.
     * 
     *   Note that Fields of type "date", "datetime" or "time" will
     *   be edited using a DateItem or TimeItem by default, but
     *   this can be overridden - for canEdit:false fields, a
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
     *   DynamicForm.datetimeFormatter. Otherwise for fields of type "date",
     *   default is to use the system-wide default short date format, configured via
     *   DateUtil.setShortDisplayFormat. For fields of type "datetime" or for Date values
     *   in fields whose type does not inherit from the logical "date" type, default is to use
     *   the system-wide normal date format configured via DateUtil.setNormalDisplayFormat
     *   (using "toNormalDate()" on logical "date" type fields is not desirable as this
     *   would display the time component of the date object to the user).
     *   Specify any valid DateDisplayFormat to
     *   change the format used by this item.
     *  @type {DateDisplayFormat}
     *  @default null
     */
    override var dateFormatter: 
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
     *  By default HTML values in a staticTextItem will be interpreted by the browser.
     *   Setting this flag to true causes HTML characters to be escaped, meaning the
     *   raw value of the field (for example "&lt;b&gt;AAA&lt;/b&gt;") is displayed
     *   to the user rather than the interpreted HTML (for example "AAA")
     *  @type {boolean}
     *  @default false
     */
    open var escapeHTML: Boolean = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "TextItemEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
    companion object {
        /**
         *  Creates a new StaticTextItem
         * 
         *  @param typeCheckedProperties {Partial<StaticTextItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {StaticTextItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): StaticTextItem = definedExternally
    }
}