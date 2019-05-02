@file:JsQualifier("isc")
package isc

/**
 *  A FormItem for entering a date relative to today or relative to some other date, or a specific
 *   date. Typically used for filtering data by date.
 * 
 *   The RelativeDateItem consists of a ComboBoxItem where the user may directly choose
 *   one of several RelativeDateItem.presetOptions, choose to enter a
 *   RelativeDateItem.quantityField and TimeUnit
 *   (eg "4 months ago" or "3 years from now") or directly type in
 *   an absolute date value (7/18/2009).
 */
open external class RelativeDateItem : CanvasItem {
    /**
     *  Does this items relative date value refer to the start or end of the chosen date? Useful
     *   when using this item to generate filter criteria, such as the from or to value for an
     *   inclusive range.
     * 
     *   If unset "start" is assumed.
     *  @type {RelativeDateRangePosition}
     *  @default null
     */
    open var rangePosition: 
                            /**
                             *  Indicates this relative date should be treated as the start of the specified  logical date.
                             *  Indicates this relative date should be treated as the end of the specified logical  date.
                             */
                            String /* start |  end */ = definedExternally
    /**
     *  List of time units that will be offered for relative dates.
     * 
     *   Each available time unit option will cause two options to appear in the
     *   RelativeDateItem.valueField. For example, if "day" is an available TimeUnit
     *   option, there will be RelativeDateItem.daysAgoTitle and
     *   RelativeDateItem.daysFromNowTitle.
     *  @type {Array<Partial<TimeUnit>>}
     *  @default "["day", "week", "month"]"
     */
    open var timeUnitOptions: Array<dynamic> = definedExternally
    /**
     *  Should we show time-unit options in the past? If set to false, for each
     *   RelativeDateItem.timeUnitOptions we will show only future options [for example
     *   "N weeks from now"].
     * 
     *   Note: this does not change the RelativeDateItem.presetOptions, which show up in
     *   addition to the time-unit options ("N days from now", etc). The default
     *   preset options include both past and future presets so developers may wish to modify the
     *   presets to ensure only past options are available.
     *  @type {boolean}
     *  @default true
     */
    open var showPastOptions: Boolean = definedExternally
    /**
     *  Should we show time-unit options in the future? If set to false, for each
     *   RelativeDateItem.timeUnitOptions we will show only past options [for example
     *   "N weeks ago"].
     * 
     *   Note: this does not change the RelativeDateItem.presetOptions, which show up in
     *   addition to the time-unit options ("N days from now", etc). The default
     *   preset options include both past and future presets so developers may wish to modify the
     *   presets to ensure only future options are available.
     *  @type {boolean}
     *  @default true
     */
    open var showFutureOptions: Boolean = definedExternally
    /**
     *  When set to false, only relative dates can be entered - in this mode, the
     *   RelativeDateItem.showChooserIcon is hidden and the RelativeDateItem.valueField
     *   is switched from a ComboBoxItem, which allows text-entry, to a
     *   SelectItem which does not.
     *  @type {boolean}
     *  @default true
     */
    open var allowAbsoluteDates: Boolean = definedExternally
    /**
     *  A map from a granularity of time specified by a user to the granularity of time used for
     *   rounding.
     * 
     *   A relative date such as "n days from now" is normally shifted to the end of the day when
     *   used as a range endpoint, and the beginning of the day when used as the beginning of a range.
     *   (The rounding direction on some items can be specified via
     *   RelativeDateItem.rangePosition).
     *   This causes the intuitive behavior that "from yesterday to today" is from the beginning of
     *   yesterday to the end of today, and that "from today until 5 days from now" includes the
     *   entirety of Friday if today is Monday.
     * 
     *   This same rule can be applied to any time granularity, such that "from now until
     *   20 minutes from now" is up to 5:32 if it is now 5:11:34, and
     *   "from now until 2 months from now" means end of June if it is mid-April.
     * 
     *   User intuitions about where this rounding is expected for any given time period tend to
     *   vary based on what kind of event is being discussed and subtle phrasing differences
     *   (consider "up to one year from now", "until next year", "within the next couple of years").
     *   The defaults behaviors are:
     * 
     * 
     *  - for days, weeks and months round to day end/beginning
     * 
     *  - for hours, round to minute end/beginning
     * 
     *  - for minutes and seconds, round to second end/beginning
     * 
     *   To customize this rounding behavior, this attribute may be set to a simple javascript object
     *   mapping each timeUnit to the granularity for that timeUnit.
     *   For example the following config code would produce an item where the user could select
     *   only day or week values, and the selected value would be rounded to the beginning of the day
     *   if a day was selected, or the beginning of the week if a week was selected:
     * 
     *   {
     *     name:"fromDate", type:"RelativeDateItem",
     *     timeUnitOptions:["day", "week"],
     *     rangePosition:"start",
     *     rangeRoundingGranularity:{
     *       "day":"day",
     *       "week":"week"
     *     }
     *   }
     * 
     *  @type {object}
     *  @default "{...}"
     */
    open var rangeRoundingGranularity: dynamic = definedExternally
    /**
     *  The title to show for historical periods when the TimeUnit is "millisecond".
     *  @type {string}
     *  @default "N milliseconds ago"
     */
    open var millisecondsAgoTitle: String = definedExternally
    /**
     *  The title to show for historical periods when the TimeUnit is "second".
     *  @type {string}
     *  @default "N seconds ago"
     */
    open var secondsAgoTitle: String = definedExternally
    /**
     *  The title to show for historical periods when the TimeUnit is "minute".
     *  @type {string}
     *  @default "N minutes ago"
     */
    open var minutesAgoTitle: String = definedExternally
    /**
     *  The title to show for historical periods when the TimeUnit is "hour".
     *  @type {string}
     *  @default "N hours ago"
     */
    open var hoursAgoTitle: String = definedExternally
    /**
     *  The title to show for historical periods when the TimeUnit is "day".
     *  @type {string}
     *  @default "N days ago"
     */
    open var daysAgoTitle: String = definedExternally
    /**
     *  The title to show for historical periods when the TimeUnit is "week".
     *  @type {string}
     *  @default "N weeks ago"
     */
    open var weeksAgoTitle: String = definedExternally
    /**
     *  The title to show for historical periods when the TimeUnit is "month".
     *  @type {string}
     *  @default "N months ago"
     */
    open var monthsAgoTitle: String = definedExternally
    /**
     *  The title to show for historical periods when the TimeUnit is "quarter".
     *  @type {string}
     *  @default "N quarters ago"
     */
    open var quartersAgoTitle: String = definedExternally
    /**
     *  The title to show for historical periods when the TimeUnit is "year".
     *  @type {string}
     *  @default "N years ago"
     */
    open var yearsAgoTitle: String = definedExternally
    /**
     *  The title to show for future periods when the TimeUnit is "millisecond".
     *  @type {string}
     *  @default "N milliseconds from now"
     */
    open var millisecondsFromNowTitle: String = definedExternally
    /**
     *  The title to show for future periods when the TimeUnit is "second".
     *  @type {string}
     *  @default "N seconds from now"
     */
    open var secondsFromNowTitle: String = definedExternally
    /**
     *  The title to show for future periods when the TimeUnit is "minute".
     *  @type {string}
     *  @default "N minutes from now"
     */
    open var minutesFromNowTitle: String = definedExternally
    /**
     *  The title to show for future periods when the TimeUnit is "hour".
     *  @type {string}
     *  @default "N hours from now"
     */
    open var hoursFromNowTitle: String = definedExternally
    /**
     *  The title to show for future periods when the TimeUnit is "day".
     *  @type {string}
     *  @default "N days from now"
     */
    open var daysFromNowTitle: String = definedExternally
    /**
     *  The title to show for future periods when the TimeUnit is "week".
     *  @type {string}
     *  @default "N weeks from now"
     */
    open var weeksFromNowTitle: String = definedExternally
    /**
     *  The title to show for future periods when the TimeUnit is "month".
     *  @type {string}
     *  @default "N months from now"
     */
    open var monthsFromNowTitle: String = definedExternally
    /**
     *  The title to show for future periods when the TimeUnit is "quarter".
     *  @type {string}
     *  @default "N quarters from now"
     */
    open var quartersFromNowTitle: String = definedExternally
    /**
     *  The title to show for future periods when the TimeUnit is "year".
     *  @type {string}
     *  @default "N years from now"
     */
    open var yearsFromNowTitle: String = definedExternally
    /**
     *  Default value to show. Can be a concrete Date, a RelativeDateString that matches
     *   one of the RelativeDateItem.presetOptions, or one of the available
     *   RelativeDateItem.timeUnitOptions. If setting a TimeUnit,
     *   use RelativeDateItem.defaultQuantity to establish a default
     *   value for the RelativeDateItem.quantityField.
     *  @type {Date | RelativeDateString | TimeUnit}
     *  @default "$today"
     */
    override var defaultValue: dynamic = definedExternally
    /**
     *  What operator to use when RelativeDateItem.getCriterion
     * 
     *   is called.
     *  @type {OperatorId}
     *  @default "greaterThan"
     */
    override var operator: 
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
     *  Preset relative dates, such as "today" or "tomorrow", that the user can choose directly
     *   from the RelativeDateItem.valueField.
     * 
     *   Format is an Object mapping user-visible titles to RelativeDateShortcut or
     *   RelativeDateStrings. The default value (expressed in JSON) is:
     * 
     *   {
     *     "$today" : "Today",
     *     "$yesterday" : "Yesterday",
     *     "$tomorrow" : "Tomorrow",
     *     "$weekAgo" : "Current day of last week",
     *     "$weekFromNow" : "Current day of next week",
     *     "$monthAgo" : "Current day of last month",
     *     "$monthFromNow" : "Current day of next month"
     *   }
     * 
     *   In addition to these presets, options are shown for each of the
     *   TimeUnit.
     *  @type {object}
     *  @default "see below"
     */
    open var presetOptions: dynamic = definedExternally
    /**
     *  The FormItem.width for the RelativeDateItem.valueField
     *   in this item. Defaults to the current default value for the width attribute on the
     *   DateTimeItem class - this is assumed to be just wide enough to show a full
     *   datetime string, in the current global datetime format.
     * 
     *   Setting the width globally on the DateTimeItem class results
     *   in all text-based datetime entry fields assuming the same default width - this caters for
     *   custom date-time formatters that need differing amounts of space.
     *  @type {Integer | string}
     *  @default null
     */
    open var valueFieldWidth: dynamic = definedExternally
    /**
     *  ComboBoxItem field where a user may choose among
     *   RelativeDateItem.presetOptions,
     *   TimeUnit plus RelativeDateItem.quantityField, or
     *   direct entry of a date as text.
     *  @type {ComboBoxItem}
     *  @default null
     */
    override var valueField: String = definedExternally
    /**
     *  Default quantity to show in the RelativeDateItem.quantityField.
     *  @type {Integer}
     *  @default "1"
     */
    open var defaultQuantity: Number = definedExternally
    /**
     *  Minimum value to allow in the RelativeDateItem.quantityField.
     *  @type {Integer}
     *  @default "0"
     */
    open var minQuantity: Number = definedExternally
    /**
     *  Maximum value to allow in the RelativeDateItem.quantityField. Increasing this value may result in
     *   date miscalculations for very large numbers, due to Javascript Date limitations.
     *  @type {Integer}
     *  @default "999999"
     */
    open var maxQuantity: Number = definedExternally
    /**
     *  Field allowing user to pick units of time, eg, number of days.
     *  @type {SpinnerItem}
     *  @default null
     */
    open var quantityField: SpinnerItem = definedExternally
    /**
     *  Should we show the icon that displays a date-chooser?
     *  @type {boolean}
     *  @default true
     */
    open var showChooserIcon: Boolean = definedExternally
    /**
     *  Icon that launches a DateChooser for choosing an absolute date.
     *  @type {FormItemIcon}
     *  @default null
     */
    open var pickerIcon: FormItemIcon = definedExternally
    /**
     *  Prompt to show when the user hovers the mouse over the picker icon for this
     *   RelativeDateItem. May be overridden for localization of your application.
     *  @type {HTMLString}
     *  @default "Show Date Chooser"
     */
    override var pickerIconPrompt: String = definedExternally
    /**
     *  SmartClient class for the DateChooser autoChild displayed to allow the user
     *   to directly select dates.
     *  @type {string}
     *  @default "DateChooser"
     */
    override var pickerConstructor: String = definedExternally
    /**
     *  Base date for calculating the relative date entered by the user.
     * 
     *   The default is to use the current date.
     *  @type {Date}
     *  @default null
     */
    open var baseDate: Date = definedExternally
    /**
     *  Should the Calculated-Date be displayed to the right of the RelativeDateItem.pickerIcon.
     *  @type {boolean}
     *  @default true
     */
    open var showCalculatedDateField: Boolean = definedExternally
    /**
     *  Field that shows the current calculated date by adding the user-entered relative date to
     *   the RelativeDateItem.baseDate.
     *  @type {BlurbItem}
     *  @default null
     */
    open var calculatedDateField: BlurbItem = definedExternally
    /**
     *  Format for direct user input of date values.
     * 
     *   If unset, the input format will be determined based on the specified
     *   RelativeDateItem.displayFormat if possible, otherwise picked up from the Date class (see
     *   DateUtil.setInputFormat).
     * 
     * 
     *   Note: if entirely custom date formatting/parsing logic is required for this item,
     *   this attribute may be set to a function which takes a single parameter (the formatted
     *   date string) and returns a JavaScript date object.
     * 
     *  @type {DateInputFormat}
     *  @default null
     */
    override var inputFormat: String = definedExternally
    /**
     *  Format for displaying dates in the RelativeDateItem.valueField and RelativeDateItem.calculatedDateField.
     *   Defaults to the system-wide default established by
     *   DateUtil.setShortDisplayFormat, or if this item has its type specified as
     *   datetime, DateUtil.setShortDatetimeDisplayFormat.
     *  @deprecated \* in favor of RelativeDateItem.dateFormatter
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
     *  Format for displaying dates in the RelativeDateItem.valueField and RelativeDateItem.calculatedDateField.
     *   If unset a default DateDisplayFormat will be picked up from DynamicForm.dateFormatter
     *   (or DynamicForm.datetimeFormatter for datetime fields} or otherwise from
     *   the system-wide default established by DateUtil.setShortDisplayFormat, or
     *   if this item has its type specified as datetime,
     *   DateUtil.setShortDatetimeDisplayFormat.
     * 
     * 
     *   Note: if entirely custom date formatting/parsing logic is required for this item, this
     *   attribute may be set to a custom formatting function. In this case the function will be
     *   applied to the Date being formatted (for example this.getFullYear() would
     *   give you back the full year), and should return the formatted date string.
     * 
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
     *  Minimum date the selectors will allow the user to pick. The default value is January
     *   1st, 10 years before the current year.
     * 
     *   NOTE: by design, setting startDate and endDate will not
     *   always prevent the user from picking invalid values. In particular:
     * 
     * 
     *  - the set of available days will only be restricted if the start and end dates fall
     *   within the same month
     * 
     *  - the set of available months will only be restricted if the start and end dates fall
     *   within the same year
     * 
     * 
     *   This is by design as it allows the user to set the day, month and year in
     *   whatever order is convenient, rather than forcing them to pick in a specific order.
     * 
     *   For actual enforcement of a date being in correct range before data is submitted, a
     *   Validator of type "dateRange" should always be declared.
     *  @type {Date}
     *  @default "1/1/1995"
     */
    open var startDate: Date = definedExternally
    /**
     *  Maximum date the selectors will allow the user to pick. The default value is December
     *   31st, 5 years after the current year.
     * 
     *   See DateItem.startDate for details on how this restriction works.
     *  @type {Date}
     *  @default "12/31/2020"
     */
    open var endDate: Date = definedExternally
    /**
     *  Only used if we're showing the date in a text field. When parsing a date, if the year
     *   is specified with 1 or 2 digits and is less than the centuryThreshold, then the year will
     *   be assumed to be 20xx; otherwise it will be interpreted according to default browser
     *   behaviour, which will consider it to be 19xx.
     * 
     *   If you need to allow 1 and 2 digit years, set this attribute to
     *   null to have the control retain your year-value as entered.
     *  @type {number}
     *  @default "25"
     */
    open var centuryThreshold: Number = definedExternally
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
    override var shouldSaveValue: Boolean = definedExternally
    /**
     *  When set to true (the default), use a single shared date-picker across all widgets that
     *   use one. When false, create a new picker using the autoChild system. See
     *   picker and
     *   DateItem.pickerProperties for details on setting up an unshared
     *   picker.
     *  @type {boolean}
     *  @default true
     */
    open var useSharedPicker: Boolean = definedExternally
    /**
     *  When set to true, show a button that allows the calendar to be navigated by fiscal year.
     *  @type {boolean}
     *  @default false
     */
    open var showChooserFiscalYearPicker: Boolean = definedExternally
    /**
     *  When set to true, show a button that allows the calendar to be navigated by week or
     *   fiscal week, depending on the value of RelativeDateItem.showChooserFiscalYearPicker.
     *  @type {boolean}
     *  @default false
     */
    open var showChooserWeekPicker: Boolean = definedExternally
    /**
     *  If this item is editing a field of type "datetime", should the
     *   DateChooser display the DateChooser.showTimeItem,
     *   allowing the user to select a time?
     * 
     *   One case where developers will wish to suppress this time-field from being displayed
     *   is if a custom RelativeDateItem.dateFormatter has been specified which does not display the
     *   time portion of the selected date. In this case any value selected from the
     *   DateChooser's time field will be discarded when the picker is dismissed, making
     *   it a confusing UI for the end user.
     * 
     *   Has no effect if the field type is "date" - in this case the
     *   picker will never show the time field.
     *  @type {boolean}
     *  @default true
     */
    open var showPickerTimeItem: Boolean = definedExternally
    /**
     *  A set of properties to apply to the TimeItem displayed in the picker when
     *   RelativeDateItem.showPickerTimeItem is true.
     * 
     *   Has no effect for fields of type "date".
     *  @type {TimeItem}
     *  @default null
     */
    open var pickerTimeItemProperties: TimeItem = definedExternally
    /**
     *  When showing the DateChooser, should the
     *   DateChooser.showTimeItem be set to use 24-hour time?
     *   Has no effect for fields of type "date" rather than
     *   "datetime", or if RelativeDateItem.showPickerTimeItem is false.
     * 
     *   Default is true.
     *  @type {boolean}
     *  @default true
     */
    open var use24HourTime: Boolean = definedExternally
    /**
     *   RelativeDateItems do not make use of the standard FormItem.formatEditorValue and
     *   FormItem.parseEditorValue methods. Developers can customize the display values
     *   for these items in the following ways:
     * 
     *  - The RelativeDateItem.presetOptions map allows standard preset RelativeDateString
     *     and RelativeDateShortcut values to be mapped to custom display values
     * 
     *  - The text displayed for each of the RelativeDateItem.timeUnitOptions (e.g:"N days ago") may be
     *     customized via the per-time unit title attributes (RelativeDateItem.daysFromNowTitle,
     *     RelativeDateItem.daysAgoTitle, etc)
     * 
     *  - The RelativeDateItem.dateFormatter and RelativeDateItem.inputFormat may be used modify how date values
     *     are displayed (both in the text entry box and in the
     *    RelativeDateItem.showCalculatedDateField
     * 
     * 
     */
    open fun formatEditorValue(): Unit = definedExternally
    /**
     *   RelativeDateItems do not make use of the standard FormItem.formatEditorValue and
     *   FormItem.parseEditorValue methods. Developers can customize the display values
     *   for these items in the following ways:
     * 
     *  - The RelativeDateItem.presetOptions map allows standard preset RelativeDateString
     *     and RelativeDateShortcut values to be mapped to custom display values
     * 
     *  - The text displayed for each of the RelativeDateItem.timeUnitOptions (e.g:"N days ago") may be
     *     customized via the per-time unit title attributes (RelativeDateItem.daysFromNowTitle,
     *     RelativeDateItem.daysAgoTitle, etc)
     * 
     *  - The RelativeDateItem.dateFormatter and RelativeDateItem.inputFormat may be used modify how date values
     *     are displayed (both in the text entry box and in the
     *    RelativeDateItem.showCalculatedDateField
     * 
     * 
     */
    open fun parseEditorValue(): Unit = definedExternally
    /**
     *   Returns the current RelativeDate object for this item. Only applies if the user entered
     *   a relative date value (such as "Today") - if an absolute date was entered, this method
     *   returns null.
     *   Relative date objects have the following format:
     * 
     *     { _constructor: "RelativeDate", value: "$today" }
     * 
     * 
     * 
     */
    open fun getRelativeDate(): dynamic = definedExternally
    /**
     *   Get the criterion based on the values the user has entered.
     * 
     *  @param {boolean=} whether to use an absolute date in the Criterion produced.                By default a RelativeDate will be used if the user                entered a relative date value
     */
    open fun getCriterion(absolute: Boolean?): Criterion = definedExternally
    /**
     *   Returns the FiscalCalendar object that will be used by this item's DateChooser.
     * 
     * 
     */
    open fun getFiscalCalendar(): FiscalCalendar = definedExternally
    /**
     *   Sets the FiscalCalendar object that will be used by this item's DateChooser. If
     *   unset, the DateUtil.getFiscalCalendar is used.
     * 
     * 
     *  @param {FiscalCalendar=} the fiscal calendar for this chooser, if set, or the global      one otherwise
     */
    open fun setFiscalCalendar(fiscalCalendar: FiscalCalendar?): Unit = definedExternally
    /**
     *   If DateItem.useTextField is true this method returns a
     *   standard DateInputFormat, determining how values entered
     *   by the user are to be converted to Javascript Date objects.
     * 
     *   If an explicit DateItem.inputFormat has been specified it will be returned,
     *   otherwise, if a custom DateItem.dateFormatter or FormItem.format are
     *   specified, the input format will be automatically derived from that property.
     * 
     *   Otherwise, the global DateUtil.setInputFormat is used.
     * 
     *   Note that the inputFormat will ignore any separator characters and padding of values.
     *   However if necessary entirely custom date formatting and parsing may be achieved via the
     *   DateItem.formatEditorValue and
     *   DateItem.parseEditorValue methods.
     * 
     * 
     * 
     */
    open fun getInputFormat(): String = definedExternally
    /**
     *   Returns the raw text value typed into this items value text field
     * 
     */
    open fun getEnteredValue(): Unit = definedExternally
    companion object {
        /**
         *  Creates a new RelativeDateItem
         * 
         *  @param typeCheckedProperties {Partial<RelativeDateItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {RelativeDateItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): RelativeDateItem = definedExternally
        /**
         *   Converts a RelativeDate, RelativeDateShortcut,
         * 
         *   or RelativeDateString to a concrete Date.
         * 
         *  @param {RelativeDate} the relative date to convert
         *  @param {Date=} base value for conversion. Defaults to today
         */
        fun getAbsoluteDate(relativeDate: RelativeDate, baseDate: Date?): Date = definedExternally
    }
}