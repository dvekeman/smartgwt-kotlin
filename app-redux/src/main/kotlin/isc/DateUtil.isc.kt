@file:JsQualifier("isc")
package isc

/**
 *  Static singleton class containing APIs for interacting with Dates.
 */
open external class DateUtil : Class {
    companion object {
        /**
         *  This property may be set to an array of names of days of the week.
         *   For example:
         * 
         *   ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"]
         * 
         *   The appropriate day name will then be returned from Date.getShortDayName, and may
         *   be used whenever SmartClient components display day-names (for example in the
         *   DateItem).
         *   Note: For US based applications the first item in the array should be the name for Sunday,
         *   then Monday, Tuesday, etc. For browsers with different locales this may vary.
         *   To determine the first day for some locale, you can run the following code:
         * 
         *    alert(new Date(2000, 0, 2).getDay());
         * 
         *   You should see an alert with a number between zero and 6. This represents the numerical
         *   'day' value for Sunday for your browser's locale, since Jan 2nd 2000 was a Sunday.
         *   Therefore if this code alerted the number 6, Sunday should appear last in your list
         *   of day-names, and Monday first.
         *  @type {Array<any>}
         *  @default null
         */
        var shortDayNames: Array<dynamic> = definedExternally
        /**
         *  This property may be set to an array of names of days of the week.
         *   For example:
         * 
         *   ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"]
         * 
         *   The appropriate day name will then be returned from Date.getDayName, and may
         *   be used whenever SmartClient components display day-names (for example in the
         *   DateItem).
         *  @type {Array<any>}
         *  @default null
         */
        var dayNames: Array<dynamic> = definedExternally
        /**
         *  This property may be set to an array of shortened month-names.
         *   For example:
         * 
         *   ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]
         * 
         *   The appropriate month name will then be returned from Date.getShortMonthName,
         *   and may be used whenever SmartClient components display month-names (for example in the
         *   DateItem).
         *  @type {Array<any>}
         *  @default null
         */
        var shortMonthNames: Array<dynamic> = definedExternally
        /**
         *  This property may be set to an array of names of months.
         *   For example:
         * 
         *   ["January", "February", "March", "April", "May", "June", "July",
         *   "August", "September", "October", "November", "December"]
         * 
         *   The appropriate month name will then be returned from Date.getMonthName,
         *   and may be used whenever SmartClient components display month-names (for example in the
         *   DateItem).
         *  @type {Array<any>}
         *  @default null
         */
        var monthNames: Array<dynamic> = definedExternally
        /**
         *  Days that are considered "weekend" days.  Values should be the integers returned by the
         *   JavaScript built-in Date.getDay(), eg, 0 is Sunday and 6 is Saturday. Override to
         *   accommodate different workweeks such as Saudi Arabia (Saturday -> Wednesday) or Israel
         *   (Sunday -> Thursday).
         *  @type {Array<Partial<Integer>>}
         *  @default "[0, 6]"
         */
        var weekendDays: Array<dynamic> = definedExternally
        /**
         *  Creates a new DateUtil
         * 
         *  @param typeCheckedProperties {Partial<DateUtil>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DateUtil} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DateUtil = definedExternally
        /**
         *   Return the parameter date formatted according to the parameter FormatString.
         *   This method is used to implement the DataSourceField.format
         *   functionality, but it can also be used to format arbitrary dates programmatically.
         * 
         *  @param {Date} The date to format
         *  @param {FormatString} The format to apply to this date
         */
        fun format(date: Date, format: String): String = definedExternally
        /**
         *   Create a new Date to represent a logical date value (rather than a specific datetime value),
         *   typically for display in a DataSourceField.type. The generated
         *   Date value will have year, month and date set to the specified values
         *   (in browser native local time).
         * 
         *  @param {Integer} full year
         *  @param {Integer} month (zero based, so 0 is January)
         *  @param {Integer} date within the month
         */
        fun createLogicalDate(year: Number, month: Number, date: Number): Date = definedExternally
        /**
         *   Returns the full year from the passed datetime, as it will be displayed to the user.
         *   This might not be the same value as that returned by getFullYear() if a
         *   Time.setDefaultDisplayTimezone
         *   has been applied. Only necessary for datetimes - for logical dates and times, this
         *   method returns the same value as getFullYear().
         * 
         *  @param {Date} datetime instance to work with
         */
        fun getDisplayYear(datetime: Date): Number = definedExternally
        /**
         *   Returns the month number from the passed datetime, as it will be displayed to the user.
         *   This might not be the same value as that returned by getMonth() if a
         *   Time.setDefaultDisplayTimezone
         *   has been applied. Only necessary for datetimes - for logical dates and times, this
         *   method returns the same value as getMonth().
         * 
         *  @param {Date} datetime instance to work with
         */
        fun getDisplayMonth(datetime: Date): Number = definedExternally
        /**
         *   Returns the day of month from the passed datetime, as it will be displayed to the user.
         *   This might not be the same value as that returned by getDate() if a
         *   Time.setDefaultDisplayTimezone
         *   has been applied. Only necessary for datetimes - for logical dates and times, this
         *   method returns the same value as getDate().
         * 
         *  @param {Date} datetime instance to work with
         */
        fun getDisplayDay(datetime: Date): Number = definedExternally
        /**
         *   Returns the hours value from the passed datetime, as it will be displayed to the user.
         *   This might not be the same value as that returned by getHours() if a
         *   Time.setDefaultDisplayTimezone
         *   has been applied. Only necessary for datetimes - for logical dates and times, this
         *   method returns the same value as getHours().
         * 
         *  @param {Date} datetime instance to work with
         */
        fun getDisplayHours(datetime: Date): Number = definedExternally
        /**
         *   Returns the minutes value from the passed datetime, as it will be displayed to the user.
         *   This might not be the same value as that returned by getMinutes() if a
         *   Time.setDefaultDisplayTimezone
         *   has been applied. Only necessary for datetimes - for logical dates and times, this
         *   method returns the same value as getMinutes().
         * 
         *  @param {Date} datetime instance to work with
         */
        fun getDisplayMinutes(datetime: Date): Number = definedExternally
        /**
         *   Create a new Date object to represent a logical time value (rather than a specific datetime
         *   value), typically for display in a DataSourceField.type. The generated
         *   Date value will have year, month and date set to the epoch date (Jan 1 1970), and time
         *   elements set to the supplied hour, minute and second (in browser native local time).
         * 
         *  @param {Integer} hour (0-23)
         *  @param {Integer} minute (0-59)
         *  @param {Integer} second (0-59)
         */
        fun createLogicalTime(hour: Number, minute: Number, second: Number): Date = definedExternally
        /**
         *   Get a logical date - a value appropriate for a DataSourceField of type "date" - from a
         *   datetime value (a value from a DataSourceField of type "datetime").
         * 
         *   This method correctly takes into account the current
         *   Time.setDefaultDisplayTimezone, specifically, the returned Date
         *   will reflect the day, month and year that appears when the datetime is rendered
         *   by a SmartClient component rather than the date values that would be returned by
         *   Date.getDay() et al (which can differ, since getDay() uses the browser's local timezone).
         * 
         *   For further background on date, time and datetime types, storage and transmission, see
         *   dateFormatAndStorage.
         * 
         * 
         *  @param {Date} a Date instance representing a datetime value
         */
        fun getLogicalDateOnly(date: Date): Date = definedExternally
        /**
         *   Get a logical time - a value appropriate for a DataSourceField of type "time" - from a
         *   datetime value (a value from a DataSourceField of type "datetime").
         * 
         *   This method correctly takes into account the current
         *   Time.setDefaultDisplayTimezone, specifically, the returned Date will
         *   reflect the hour, minute and second that appears when the datetime is rendered by a SmartClient
         *   component rather than the time values that would be returned by Date.getHours() et al (which
         *   can differ, since getHours() uses the browser's local timezone).
         * 
         *   For further background on date, time and datetime types, storage and transmission, see
         *   dateFormatAndStorage.
         * 
         * 
         *  @param {Date} a Date instance representing a datetime value
         */
        fun getLogicalTimeOnly(date: Date): Date = definedExternally
        /**
         *   Combine a logical date (a value appropriate for a DataSourceField of type "date") with a
         *   logical time (a value appropriate for a DataSourceField of type "time") into a datetime
         *   value (a value appropriate for a DataSourceField of type "datetime")
         * 
         *   This method correctly takes into account the current
         *   Time.setDefaultDisplayTimezone, specifically, the returned datetime
         *   value will show the same date and time as the passed date and time objects when rendered by
         *   a SmartClient component that has been configured with a field of type "datetime".
         * 
         *   For further background on date, time and datetime types, storage and transmission, see
         *   dateFormatAndStorage.
         * 
         * 
         *  @param {Date} a Date instance representing logical date value
         *  @param {Date} a Date instance representing logical time value
         */
        fun combineLogicalDateAndTime(date: Date, time: Date): Date = definedExternally
        /**
         *   Compare two dates; returns 0 if equal, -1 if the first date is greater (later), or 1 if
         *   the second date is greater. If either value is not a Date object, it is treated as the
         *   epoch (midnight on Jan 1 1970) for comparison purposes.
         * 
         *  @param {Date} first date to compare
         *  @param {Date} second date to compare
         */
        fun compareDates(date1: Date, date2: Date): Number = definedExternally
        /**
         *   Compare two dates, normalizing out the time elements so that only the date elements are
         *   considered; returns 0 if equal, -1 if the first date is greater (later), or 1 if
         *   the second date is greater.
         * 
         *  @param {Date} first date to compare
         *  @param {Date} second date to compare
         */
        fun compareLogicalDates(date1: Date, date2: Date): Number = definedExternally
        /**
         *   Sets up the default system-wide input format for strings being parsed into dates via
         *   DateUtil.parseInput(). This will effect how SmartClient components showing
         *   editable date or datetime fields parse user-entered values into live Date objects.
         * 
         *   The input format can be specified as a DateInputFormat - a 3 character string like
         *   "MDY" indicating the order of the Month, Day and Year components of date strings.
         * 
         *   As an example - an input format of "MDY" would parse "01/02/1999" to Jan 2nd 1999
         *   This standard parsing logic will also handle date-time strings such as "01/02/1999 08:45", or
         *   "01/02/1999 16:21:05".
         * 
         *   Notes:
         * 
         * 
         *  - If the inputFormat is not explicitly set,the system automatically determines
         *     the standard input format will be based on the specified
         *     DateUtil.setShortDisplayFormat wherever possible.
         *     For example if the short display format has been set to "toEuropeanShortDate" the input
         *     format will default to "DMY".
         * 
         *  - The default date parsing functionality built into SmartClient will handle dates presented
         *     with any separator string, and can handle 1 or 2 digit day and month values and 2 or 4
         *     digit year values. This means that in many cases custom date display formats can be parsed
         *     back to Date values without the need for a custom parser function. However if more
         *     sophisticated parsing logic is required, a function may be passed into this method. In
         *     this case the parser function should be able to handle parsing date and datetime values
         *     formatted via
         *     Date.toShortDate and Date.toShortDateTime.
         * 
         * 
         *  - Date parsing and formatting logic may be overridden at the component level by setting
         *     properties directly on the component or field in question.
         * 
         * 
         *  @param {DateInputFormat | Function} Default format for strings to be parsed into Dates.  If this method is passed a function, it is expected to take a single parameter (the formatted date string), and return the appropriate Javascript Date object (or null if appropriate).
         */
        fun setInputFormat(format: dynamic): Unit = definedExternally
        /**
         *   Retrieves the default format for strings being parsed into dates via
         *   DateUtil.parseInput()
         * 
         */
        fun getInputFormat(): String = definedExternally
        /**
         *   Parse a date passed in as a string, returning the appropriate date object.
         * 
         *  @param {string} date value as a string
         *  @param {DateInputFormat=} Format of the date string being passed.                   If not passed, the default date input format as set up                    via setInputFormat() will be used.
         *  @param {Integer=} For date formats that support a 2 digit                 year, if parsed year is 2 digits and less than this                  number, assume year to be 20xx rather than 19xx
         *  @param {boolean=} If the string passed in was not a valid date, in some cases we can convert to a      valid date (for example incrementing the year if the month is greater than 12).      This optional parameter will suppress such conversions - anything that doesn't      parse directly to a valid date will simply return null.
         */
        fun parseInput(dateString: String, format: String?, centuryThreshold: Number?, suppressConversion: Boolean?): Date = definedExternally
        /**
         *   Set the default formatter for date objects to the method name passed in. After calling this
         *   method, subsequent calls to Date.toNormalDate
         *   will return a string formatted
         *   according to this format specification. Note: this will be the standard long date format used
         *   by SmartClient components.
         * 
         *   The format parameter may be a FormatString, a DateDisplayFormat
         *   string, or a function. If passed a function, this function will be executed in the scope of
         *   the Date and should return the formatted string.
         * 
         *   Initial default normalDisplayFormat is "toLocaleString"
         * 
         *  @param {FormatString | DateDisplayFormat | Function} new formatter
         */
        fun setNormalDisplayFormat(format: dynamic): Unit = definedExternally
        /**
         *   Set the default normal format for datetime values. After calling this method, subsequent
         *   calls to Date.toNormalDatetime
         *   will return a string formatted according to
         *   this format specification. Note that this will be the standard datetime format used by
         *   SmartClient components.
         * 
         *   The format parameter may be a FormatString, a DateDisplayFormat
         *   string, or a function. If passed a function, this function will be executed in the scope of
         *   the Date and should return the formatted string.
         * 
         * 
         *  @param {FormatString | DateDisplayFormat | Function} new formatter
         */
        fun setNormalDatetimeDisplayFormat(format: dynamic): Unit = definedExternally
        /**
         *   Set the default short format for dates. After calling this method, subsequent calls to
         *   Date.toShortDate
         *   will return a string formatted
         *   according to this format specification. Note that this will be the standard short date
         *   format used by SmartClient components.
         * 
         *   The format parameter may be a FormatString, a DateDisplayFormat
         *   string, or a function. If passed a function, this function will be executed in the scope of
         *   the Date and should return the formatted string.
         * 
         *   Initial default shortDateFormat is "toUSShortDate". This property
         *   is commonly modified for localization of applications. See
         *   http://en.wikipedia.org/wiki/Date_format_by_country
         *   for a useful overview of standard date formats per country.
         * 
         * 
         *  @param {FormatString | DateDisplayFormat | Function} new formatter
         */
        fun setShortDisplayFormat(format: dynamic): Unit = definedExternally
        /**
         *   Sets a new default separator that will be used when formatting dates. By default, this
         *   is a forward slash character: "/"
         * 
         *  @param {string} separator to use in dates
         */
        fun setDefaultDateSeparator(separator: String): Unit = definedExternally
        /**
         *   gets the default date separator string
         * 
         */
        fun getDefaultDateSeparator(): String = definedExternally
        /**
         *   Set the default short format for datetime values. After calling this method, subsequent
         *   calls to Date.toShortDateTime
         *   will return a string formatted
         *   according to this format specification. Note that this will be the standard datetime format
         *   used by SmartClient components.
         * 
         *   The format parameter may be a FormatString, a DateDisplayFormat
         *   string, or a function. If passed a function, this function will be executed in the scope of
         *   the Date and should return the formatted string.
         * 
         *   Initial default format is "toUSShortDatetime". See
         *   http://en.wikipedia.org/wiki/Date_format_by_country
         *   for a useful overview of standard date formats per country.
         * 
         * 
         *  @param {FormatString | DateDisplayFormat | Function} new formatter
         */
        fun setShortDatetimeDisplayFormat(format: dynamic): Unit = definedExternally
        /**
         *   Sets the global fiscal calendar, which is used for all calls to
         *   getFiscalYear() / getFiscalWeek() if those methods aren't passed a fiscalCalander.
         * 
         * 
         *  @param {FiscalCalendar} the object representing the start month and date of      the fiscal year in the current locale
         */
        fun setFiscalCalendar(fiscalCalendar: FiscalCalendar): Unit = definedExternally
        /**
         *   Returns the global FiscalCalendar representing the start month and
         *   date of the fiscal year in the current locale.
         * 
         */
        fun getFiscalCalendar(): FiscalCalendar = definedExternally
        /**
         *   Returns the start date of the fiscal year for the passed date.
         * 
         * 
         *  @param {Date | number} the date, or the year-number, to get the fiscal year for
         *  @param {FiscalCalendar=} the object representing the starts of one or more               fiscal years
         */
        fun getFiscalStartDate(date: dynamic, fiscalCalendar: FiscalCalendar?): Date = definedExternally
        /**
         *   Sets the global attribute that dictates whether the DateChooser shelled
         *   from DateItem show a UI for working with Fiscal Years.
         * 
         * 
         *  @param {boolean} whether to show Fiscal Year pickers in DateChoosers by default
         */
        fun setShowChooserFiscalYearPickers(showChooserFiscalYearPickers: Boolean): Unit = definedExternally
        /**
         *   Sets the global attribute that dictates whether the DateChooser shelled
         *   from DateItem show a UI for working with Weeks.
         * 
         * 
         *  @param {boolean} whether to show Fiscal Week pickers in DateChoosers by default
         */
        fun setShowChooserWeekPickers(showChooserWeekPickers: Boolean): Unit = definedExternally
        /**
         *   Sets the global attribute that dictates which day should be treated as the first day of the
         *   week in calendars and date calculations. The parameter is expected to be an integer value
         *   between 0 (Sunday) and 6 (Saturday).
         * 
         *   The default value is picked up from the current locale.
         * 
         * 
         *  @param {Integer} the number of the day to use as the first day of the week
         */
        fun setFirstDayOfWeek(firstDayOfWeek: Number): Unit = definedExternally
        /**
         *   Returns the global attribute that dictates which day should be treated as the first day of
         *   the week in calendars and date calculations. The parameter is expected to be an integer
         *   value between 0 (Sunday) and 6 (Saturday).
         * 
         *   The default value is picked up from the current locale.
         * 
         * 
         */
        fun getFirstDayOfWeek(): Number = definedExternally
        /**
         *   Returns the FiscalYear object for the fiscal year in which the passed date exists.
         * 
         * 
         *  @param {Date | Integer} the date to get the fiscal year for
         *  @param {FiscalCalendar=} the object representing the start of the fiscal period
         */
        fun getFiscalYear(date: dynamic, fiscalCalendar: FiscalCalendar?): FiscalYear = definedExternally
        /**
         *   Returns a date's week-number, according to the fiscal calendar
         * 
         * 
         *  @param {Date} the date to get the fiscal year for
         *  @param {FiscalCalendar=} the object representing the starts of fiscal years
         */
        fun getFiscalWeek(date: Date, fiscalCalendar: FiscalCalendar?): Number = definedExternally
        /**
         *   Sets the days that are considered DateUtil.weekendDays. The parameter
         *   should be array of the integers returned by the JavaScript built-in Date.getDay(), eg, 0 is
         *   Sunday and 6 is Saturday. Override to accommodate different workweeks such as Saudi Arabia
         *   (Saturday -> Wednesday) or Israel (Sunday -> Thursday).
         * 
         * 
         *  @param {Array<Partial<Integer>>} the array of day-numbers to assign as weekend days
         */
        fun setWeekendDays(weekendDays: Array<dynamic>): Unit = definedExternally
        /**
         *   Return an array of days that are considered "weekend" days. Values will be the integers
         *   returned by the JavaScript built-in Date.getDay(), eg, 0 is Sunday and 6 is Saturday.
         *   Override DateUtil.weekendDays to accommodate different workweeks such as Saudi Arabia
         *   (Saturday -> Wednesday) or Israel (Sunday -> Thursday).
         * 
         */
        fun getWeekendDays(): Array<dynamic> = definedExternally
        /**
         *   Converts a RelativeDateShortcut to a RelativeDateString.
         * 
         *  @param {RelativeDateShortcut} shortcut string to convert
         *  @param {RelativeDateRangePosition=} Are we interested in the start or end of the specified relative date? This applies to shortcuts which do not specify a specific  moment (such as $today) - it does not apply to shortcuts which  already specify a specific moment such as $startOfToday. If unspecified  rangePosition is always assumed to be "start"
         */
        fun mapRelativeDateShortcut(relativeDate: String, rangePosition: 
                                                                         /**
                                                                          *  Indicates this relative date should be treated as the start of the specified  logical date.
                                                                          *  Indicates this relative date should be treated as the end of the specified logical  date.
                                                                          */
                                                                         String /* start |  end */?): String = definedExternally
        /**
         *   Converts a RelativeDate, RelativeDateShortcut,
         * 
         *   or RelativeDateString to a concrete Date.
         * 
         *  @param {RelativeDate | RelativeDateShortcut | RelativeDateString} the relative  date to convert
         *  @param {Date=} base value for conversion. Defaults to the current date/time.
         *  @param {RelativeDateRangePosition=} optional date-range position. Only has an effect  if the date passed in is a RelativeDateShortcut where the range position   is not implicit, such as "$yesterday"
         *  @param {boolean=} should the generated date be marked as a "logical" date? A  logical date object is a Date value where the time component is ignored for formatting and  serialization purposes - such as the date displayed within a component field of  specified type "date". See dateFormatAndStorage for more on logical dates vs  datetime type values.
         */
        fun getAbsoluteDate(relativeDate: dynamic, baseDate: Date?, rangePosition: 
                                                                                   /**
                                                                                    *  Indicates this relative date should be treated as the start of the specified  logical date.
                                                                                    *  Indicates this relative date should be treated as the end of the specified logical  date.
                                                                                    */
                                                                                   String /* start |  end */?, isLogicalDate: Boolean?): Date = definedExternally
        /**
         *   Returns the start of some period, like day, week or month, relative to a passed Date
         *   instance.
         * 
         *  @param {Date} the base date to find the period start from
         *  @param {string} the period to return the start of, one of mn/h/d/w/m/y
         *  @param {boolean=} process and return a logicalDate with no time element
         *  @param {Integer=} which day should be considered the firstDayOfWeek -         overrides the default provided by the locale
         */
        fun getStartOf(date: Date, period: String, logicalDate: Boolean?, firstDayOfWeek: Number?): Date = definedExternally
        /**
         *   Returns the end of some period, like day, week or month, relative to a passed Date
         *   instance.
         * 
         *  @param {Date} the base date to find the period end from
         *  @param {string} the period to return the end of, one of mn/h/d/w/m/y
         *  @param {boolean=} process and return a logicalDate with no time element
         *  @param {Integer=} which day should be considered the firstDayOfWeek -         overrides the default provided by the locale
         */
        fun getEndOf(date: Date, period: String, logicalDate: Boolean?, firstDayOfWeek: Number?): Date = definedExternally
    }
}