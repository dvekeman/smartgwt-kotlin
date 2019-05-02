@file:JsQualifier("isc")
package isc

/**
 *  Settings for use with DataSource.recordsAsText.
 */
open external class TextExportSettings : TextSettings {
    /**
     *  Separator between Records. Default is a newline character ("\n").
     *  @type {string}
     *  @default "\n"
     */
    override var lineSeparator: String = definedExternally
    /**
     *  Whether to surround each value with quotes ("").
     *  @type {boolean}
     *  @default true
     */
    open var quoteValues: Boolean = definedExternally
    /**
     *  Text to export for a field with a null value. If this property is null, then
     *   null fields will be assumed to have the default value for their field type.
     *  @type {string}
     *  @default ""
     */
    open var nullValueText: String = definedExternally
    /**
     *  Whether to convert each field's value to the corresponding display value
     *   for export. Default of false will directly export the field's value.
     *  @type {boolean}
     *  @default false
     */
    open var useDisplayValue: Boolean = definedExternally
    /**
     *  If set, all text fields will use the indicated ForceTextApproach unless they have
     *   a specific setting for DataSourceField.exportForceText.
     *  @type {ForceTextApproach}
     *  @default null
     */
    open var forceText: 
                        /**
                         *  a leading space character is added
                         *  text value is turned into a trivial Excel formula (eg "car" becomes ="car"). In Excel, this renders just the value "car" but editing the cell reveals the formula.
                         */
                        String /* leadingSpace |  formula */ = definedExternally
    /**
     *  Format to use when outputting date values. Default is to use the format expected by
     *   Microsoft Excel (eg 1-2-2011), which Excel will turn into a real date value (see
     *   excelPasting). The current month-day-year order as set by
     *   DateUtil.setInputFormat will be used.
     *  @type {DateDisplayFormat}
     *  @default null
     */
    open var dateFormat: 
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
     *  Format to use when outputting datetime values. Default is to combine the configured date
     *   and time formats with a space (" ").
     *  @type {DateDisplayFormat}
     *  @default null
     */
    open var dateTimeFormat: 
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
     *  Format to use when outputting time values. Default is 24 hour time.
     *  @type {TimeDisplayFormat}
     *  @default null
     */
    open var timeFormat: 
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
    companion object {
        /**
         *  Creates a new TextExportSettings
         * 
         *  @param typeCheckedProperties {Partial<TextExportSettings>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {TextExportSettings} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): TextExportSettings = definedExternally
    }
}