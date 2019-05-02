@file:JsQualifier("isc")
package isc

/**
 *  Provides a compact interface for editing a date range, by providing a formatted, read-only
 *   display of the current selected date range with an icon to launch a DateRangeDialog
 *   to edit the range.
 */
open external class MiniDateRangeItem : StaticTextItem {
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
     *  @default "textItem"
     */
    override var textBoxStyle: String = definedExternally
    /**
     *  Allow miniDateRangeItems' values to show up in the form's values array, or if
     *   DynamicForm.getValuesAsCriteria is called, for the criterion to be included
     *   in the returned AdvancedCriteria object
     *  @type {boolean}
     *  @default true
     */
    override var shouldSaveValue: Boolean = definedExternally
    /**
     *  Pop-up DateRangeDialog for entering a date range.
     *  @type {DateRangeDialog}
     *  @default null
     */
    open var rangeDialog: DateRangeDialog = definedExternally
    /**
     *  MiniDateRangeItems are marked as canFocus:true, and set up with properties such that focus
     *   will always go to the icon to launch the dateRange dialog. Set canFocus to false to
     *   suppress this behavior.
     *  @type {boolean}
     *  @default true
     */
    override var canFocus: Boolean = definedExternally
    /**
     *  MiniDateRangeItems rely on their icon being able to receive focus for normal user
     *   interaction as they have no other focusable element. canTabToIcons is
     *   overridden to achieve this even if the property has been set to false at
     *   the DynamicForm.canTabToIcons.
     *  @type {boolean}
     *  @default true
     */
    override var canTabToIcons: Boolean = definedExternally
    /**
     *  The text to prepend to the formatted date when only a MiniDateRangeItem.fromDate is supplied.
     *  @type {string}
     *  @default "Since"
     */
    open var fromDateOnlyPrefix: String = definedExternally
    /**
     *  The text to prepend to the formatted date when only a MiniDateRangeItem.toDate is supplied.
     *  @type {string}
     *  @default "Before"
     */
    open var toDateOnlyPrefix: String = definedExternally
    /**
     *  The prompt to show when the mouse is hovered over the MiniDateRangeItem.pickerIcon.
     *  @type {HTMLString}
     *  @default "Show Date Chooser"
     */
    override var pickerIconPrompt: String = definedExternally
    /**
     *  Icon that launches a DateChooser for choosing an absolute date.
     *  @type {FormItemIcon}
     *  @default null
     */
    open var pickerIcon: FormItemIcon = definedExternally
    /**
     *  Whether the DateRangeDialog opened when the
     *   MiniDateRangeItem.pickerIcon is clicked should display
     *   RelativeDateItems or DateItems.
     *  @type {boolean}
     *  @default true
     */
    open var allowRelativeDates: Boolean = definedExternally
    /**
     *  Format for displaying dates to the user.
     * 
     *   If this attribute is unset, the display value is formatted intelligently according to the
     *   dates involved. For example, if both dates appear in the same month, the value will be
     *   formatted as
     *   Month date1 - date2, Year
     *   and, if in different months of the same year,
     *   Month1 date1 - Month2 date2, Year.
     *   If either date-value is unset, the display-value is formatted according to
     *   MiniDateRangeItem.fromDateOnlyPrefix and
     *   MiniDateRangeItem.toDateOnlyPrefix.
     *  @type {DateDisplayFormat}
     *  @default null
     */
    open var dateDisplayFormat: 
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
     *  Initial value for the "from" date.
     *  @type {Date | RelativeDateString | TimeUnit}
     *  @default "today"
     */
    open var fromDate: dynamic = definedExternally
    /**
     *  Initial value for the "to" date.
     *  @type {Date | RelativeDateString | TimeUnit}
     *  @default "today"
     */
    open var toDate: dynamic = definedExternally
    /**
     *  If this attribute is set to true, the pop up date range dialog will automatically
     *   validate the user-entered "to" and "from" values on
     *   "OK"-click, and refuse to dismiss if these items contain invalid values.
     *  @type {boolean}
     *  @default true
     */
    open var autoValidate: Boolean = definedExternally
    /**
     *   Setter for MiniDateRangeItem.autoValidate
     * 
     *  @param {boolean} New auto-validate setting.
     */
    open fun setAutoValidate(autoValidate: Boolean): Unit = definedExternally
    /**
     *   Overridden to return true: dateRangeItems always generate AdvancedCriteria.
     * 
     */
    override fun hasAdvancedCriteria(): Boolean = definedExternally
    /**
     *   Returns the Criterion entered in the fields shown in the
     *   MiniDateRangeItem.rangeDialog.
     * 
     *   If both dates are entered, a Criterion with an "and" OperatorId
     *   and both "greaterOrEqual" and "lessOrEqual" sub-criteria will be returned. If either
     *   date is omitted, only the "greaterOrEqual" (from date) or "lessOrEqual" (to date)
     *   Criterion is returned.
     * 
     * 
     */
    open fun getCriterion(): Criterion = definedExternally
    /**
     *   Applies the specified criterion to this item for editing. Applies any specified
     *   "greaterOrEqual" operator criterion or sub-criterion to our DateRangeItem.fromField and any
     *   specified "lessOrEqual" operator criterion or sub-criterion to our DateRangeItem.toField.
     * 
     *   Note that a single "equals" criterion can also be passed. See
     *   DateRangeItem.canEditCriterion for more detail.
     * 
     *  @param {Criterion} criterion to edit
     */
    override fun setCriterion(criterion: Criterion): Unit = definedExternally
    /**
     *   Returns true if the specified criterion contains:
     * 
     *  - A single "lessOrEqual" or "greaterOrEqual" criterion on this field
     * 
     *  - An "and" type criterion containing a "lessOrEqual" and a "greaterOrEqual" criterion
     *       on this field
     * 
     *  - A single "equals" criterion. Internally, this will be converted into a range
     *       by constructing an "and" type criterion containing both a "lessOrEqual" and
     *       a "greaterOrEqual" criterion on this field. Note that subsequent calls to
     *       DateRangeItem.getCriterion will return this more complex
     *       criterion.
     * 
     * 
     *  @param {Criterion} criterion to test
     */
    override fun canEditCriterion(criterion: Criterion): Boolean = definedExternally
    /**
     *   Sets the value for this miniDateRangeItem. The value parameter is a
     *   DateRange object that optionally includes both start and end values.
     * 
     *  @param {DateRange} the new value for this item
     */
    override fun setValue(newValue: DateRange): Unit = definedExternally
    /**
     *   Retrieves the current value of this dateRangeItem. The return value is a
     *   DateRange object that excludes start and end values if they aren't
     *   set.
     * 
     */
    override fun getValue(): DateRange = definedExternally
    companion object {
        /**
         *  Creates a new MiniDateRangeItem
         * 
         *  @param typeCheckedProperties {Partial<MiniDateRangeItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {MiniDateRangeItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): MiniDateRangeItem = definedExternally
    }
}