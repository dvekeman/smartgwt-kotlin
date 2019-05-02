@file:JsQualifier("isc")
package isc

/**
 *  Allows a user to select an absolute or relative range of dates via two
 *   RelativeDateItems (if DateRangeItem.allowRelativeDates is true) or two
 *   DateItem.
 * 
 *   The item's FormItem.type is expected to be one of "date" or "datetime" and
 *   dictates whether the dates in the range include a time portion. If unset and the item's
 *   form is databound, the data type is detected from the associated
 *   DataSourceField. If there is no such field, or the form is not
 *   databound, the default data type value is "date".
 * 
 *   DateRangeItem is just a convenience relative to using two RelativeDateItem or
 *   DateItem controls in a form, then using FormItem.operator and
 *   FormItem.criteriaField to cause them to produce a date range. If you need more
 *   control over layout, validation, event handling or any other aspect of appearance or
 *   behavior, stop using DateRangeItem and use two DateItem/RelativeDateItem controls directly
 *   instead.
 */
open external class DateRangeItem : CanvasItem {
    /**
     *  Controls the placement of the DateRangeItem.toField and DateRangeItem.fromField in the
     *   DateRangeItem.dateRangeForm.
     * 
     *   Note that we don't recommend "horizontal" placement for mobile, and we also don't recommend
     *   it for DateRangeItem.allowRelativeDates mode, since RelativeDateItem changes width
     *   drastically during editing, which causes a lot of unpleasant side-to-side shifting of
     *   controls.
     *  @type {DateFieldLayout}
     *  @default "vertical"
     */
    open var fieldLayout: 
                          /**
                           *  fields are placed horizontally
                           *  fields are placed vertically
                           */
                          String /* horizontal |  vertical */ = definedExternally
    /**
     *  Allow dateRangeItems' values to show up in the form's values array, or if
     *   DynamicForm.getValuesAsCriteria is called, for the criterion to be included
     *   in the returned AdvancedCriteria object
     *  @type {boolean}
     *  @default true
     */
    override var shouldSaveValue: Boolean = definedExternally
    /**
     *  The title for the DateRangeItem.fromField part of the range.
     *  @type {string}
     *  @default "From"
     */
    open var fromTitle: String = definedExternally
    /**
     *  The title for the DateRangeItem.toField part of the range.
     *  @type {string}
     *  @default "To"
     */
    open var toTitle: String = definedExternally
    /**
     *  The title orientation for the to / from sub-items. If unset this will be derived from
     *   FormItem.titleOrientation or
     *   DynamicForm.titleOrientation.
     *  @type {TitleOrientation}
     *  @default null
     */
    open var innerTitleOrientation: String /* left |  top |  right */ = definedExternally
    /**
     *  Whether to allow the user to specify relative dates (via RelativeDateItems) or whether
     *   dates are absolute (via DateItems).
     *  @type {boolean}
     *  @default false
     */
    open var allowRelativeDates: Boolean = definedExternally
    /**
     *  The field for the "from" date - a RelativeDateItem or DateItem according to
     *   DateRangeItem.allowRelativeDates.
     *  @type {FormItem}
     *  @default null
     */
    open var fromField: FormItem = definedExternally
    /**
     *  The field for the "to" date - a RelativeDateItem or DateItem according to
     *   DateRangeItem.allowRelativeDates.
     *  @type {FormItem}
     *  @default null
     */
    open var toField: FormItem = definedExternally
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
     *  Format for direct user input of date values.
     * 
     *   If unset, the input format will be determined based on the specified
     *   DateDisplayFormat if possible, otherwise picked up from the Date class (see
     *   DateUtil.setInputFormat).
     *  @deprecated \* This property is supported but the standard FormItem.dateFormatter and DateRangeItem.inputFormat
     *   may now be used to specify date formatting parsing behavior for dateRangeItems
     *  @type {DateInputFormat}
     *  @default null
     */
    open var dateInputFormat: String = definedExternally
    /**
     *  For fields of type "date", if this is an editable field such as a
     *   TextItem, this property
     *   allows you to specify the DateItem.inputFormat applied to the item.
     *  @type {DateInputFormat}
     *  @default null
     */
    override var inputFormat: String = definedExternally
    /**
     *  Format for displaying dates in to the user.
     *   Defaults to the system-wide default established by DateUtil.setNormalDisplayFormat.
     *  @deprecated \* This property is supported but the standard FormItem.dateFormatter and DateRangeItem.inputFormat
     *   may now be used to specify date formatting parsing behavior for dateRangeItems
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
     *  Not applicable to a DateRangeItem.
     *  @type {UserFormula}
     *  @default null
     */
    override var formula: UserFormula = definedExternally
    /**
     *  Not applicable to a DateRangeItem.
     *  @type {UserSummary}
     *  @default null
     */
    override var textFormula: UserSummary = definedExternally
    /**
     *  If this attribute is set to true when getCriteria() is
     *   called, the item will validate the "to" and "from" fields and
     *   return null if either field fails validation.
     *   See DateRangeItem.validateRange
     *  @type {boolean}
     *  @default false
     */
    open var validateCriteria: Boolean = definedExternally
    /**
     *  DynamicForm AutoChild automatically created by the dateRangeItem and applied
     *   to the item as CanvasItem.canvas.
     *   This DynamicForm contains the "from" and "to" fields the user will interact with to actually
     *   select a date-range. Note that as a standard autoChild, developers may customize this form
     *   by modifying dateRangeProperties.
     *  @type {DynamicForm}
     *  @default null
     */
    open var dateRangeForm: DynamicForm = definedExternally
    /**
     *  The FormItem class to create when DateRangeItem.allowRelativeDates is true.
     *  @type {string}
     *  @default "RelativeDateItem"
     */
    open var relativeItemConstructor: String = definedExternally
    /**
     *  The FormItem class to create when DateRangeItem.allowRelativeDates is false,
     *   but the DateRangeItem does not have type "datetime".
     *  @type {string}
     *  @default "DateItem"
     */
    open var absoluteItemConstructor: String = definedExternally
    /**
     *  The FormItem class to create when DateRangeItem.allowRelativeDates is false,
     *   and the DateRangeItem's type is "datetime".
     *  @type {string}
     *  @default "DateTimeItem"
     */
    open var absoluteDateTimeItemConstructor: String = definedExternally
    /**
     *  Error message to display if the user enters a date range where the "To" field value
     *   is earlier than the "From" field value.
     *  @type {string}
     *  @default '"To" field value cannot be earlier than "From" field value.'
     */
    open var invalidRangeErrorMessage: String = definedExternally
    /**
     *   Sets the DateRangeItem.fromDate for this DateRangeItem.
     * 
     *  @param {Date | RelativeDateString | TimeUnit} the date from which this item should start it's range
     */
    open fun setFromDate(fromDate: dynamic): Unit = definedExternally
    /**
     *   Sets the DateRangeItem.toDate for this DateRangeItem.
     * 
     *  @param {Date | RelativeDateString | TimeUnit} the date at which this item should end it's range
     */
    open fun setToDate(fromDate: dynamic): Unit = definedExternally
    /**
     *   Overridden to return true: dateRangeItems always generate AdvancedCriteria.
     * 
     */
    override fun hasAdvancedCriteria(): Boolean = definedExternally
    /**
     *   Returns the Criterion entered in the date field.
     * 
     *   A Criterion with an "and" OperatorId will be
     *   returned with both a "greaterOrEqual" and "lessOrEqual" sub-criteria. If either date is
     *   omitted, only the "greaterOrEqual" (from date) or "lessOrEqual" (to date) Criterion is
     *   included.
     * 
     * 
     */
    override fun getCriterion(): Criterion = definedExternally
    /**
     *   Validate both "to" and "from" date-fields.
     * 
     */
    open fun validateRange(): Boolean = definedExternally
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
     *   Sets the value for this dateRangeItem. The value parameter is a
     *   DateRange object that optionally includes both start and end values. If
     *   passed null, both start- and end-range values are cleared.
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
         *  Creates a new DateRangeItem
         * 
         *  @param typeCheckedProperties {Partial<DateRangeItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DateRangeItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DateRangeItem = definedExternally
    }
}