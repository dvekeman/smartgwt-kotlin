@file:JsQualifier("isc")
package isc

/**
 *  Subclass of DateItem for manipulating FieldType.
 */
open external class DateTimeItem : DateItem {
    /**
     *  DateTimeItems show datetime values in a freeform text entry area.
     *  @type {boolean}
     *  @default true
     */
    override var useTextField: Boolean = definedExternally
    /**
     *  If DateTimeItem.useTextField is true and browserInputType is set to
     *   "datetime", then a native HTML5 local datetime input
     *   is used in place of a text input.
     * 
     *   The use of a native HTML5 datetime input causes certain features to be disabled. Input masks,
     *   the picker icon, and a custom DynamicForm.datetimeFormatter are not supported.
     *   In-field hints are currently supported in Chrome/Chromium/Opera 15 and iOS 5.0+, but future browser
     *   changes might force this support to be removed. Therefore, it is safest to not
     *   use in-field hints (set showHintInField to false) in conjunction with a native HTML5 datetime
     *   input. In-field hints are not supported in Opera 12 when using a native HTML5 datetime
     *   input. If in-field hints are not supported in the browser, then showHintInField has no
     *   effect and any hint will be shown to the side of the input.
     * 
     *   NOTES:
     * 
     * 
     *  - This feature requires specific CSS changes. Currently these changes have been made
     *      to the Enterprise, EnterpriseBlue, and Graphite skins only.
     * 
     *  - In Chrome/Chromium/Opera 15 and Opera 12, native datetime inputs need to be made
     *      wider in order to fit the full datetime value within the native control. However,
     *      on iOS 5.0+, the normal width is fine. Be sure to test the layout of the form in
     *      all browsers that you wish to support.
     * 
     *  @type {string}
     *  @default null
     */
    override var browserInputType: String = definedExternally
    /**
     *  This property can be used to customize the format in which datetimes are displayed.
     *   Should be set to a standard DateDisplayFormat or
     *   a function which will return a formatted date time string.
     * 
     *   If unset, the standard shortDateTime format as set up in
     *   DateUtil.setShortDatetimeDisplayFormat will be used.
     * 
     *   NOTE: you may need to update the DateTimeItem.inputFormat
     *   to ensure the DateItem is able to parse user-entered date strings back into Dates
     *  @type {DateDisplayFormat}
     *  @default null
     */
    override var displayFormat: 
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
     *  If DateItem.useTextField is true this property can be used to specify
     *   the input format for date strings.
     *   If unset, the input format will be determined based on the specified
     *   DateItem.dateFormatter if possible (see DateItem.getInputFormat), otherwise
     *   picked up from the Date class (see DateUtil.setInputFormat).
     * 
     *   Should be set to a standard DateInputFormat
     * 
     *   Note that the DateInputFormat property is sufficient to parse date or datetime
     *   strings specified in most standard date formats. However should an entirely custom
     *   parsing function be required developers can
     *   implement a custom DateItem.parseEditorValue method.
     * 
     * 
     *   This attribute does not have an effect if a native HTML5 date input is being used.
     *   See DateItem.browserInputType.
     *  @type {DateInputFormat}
     *  @default null
     */
    override var inputFormat: String = definedExternally
    companion object {
        /**
         *  Creates a new DateTimeItem
         * 
         *  @param typeCheckedProperties {Partial<DateTimeItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DateTimeItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DateTimeItem = definedExternally
    }
}