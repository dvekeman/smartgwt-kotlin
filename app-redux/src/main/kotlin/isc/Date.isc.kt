@file:JsQualifier("isc")
package isc

/**
 *  Extensions to the Date class, including added static methods on the Date object, and
 *   additional instance methods available on all date instances.
 */
open external class Date {
    /**
     *     Copy the value of this date into a new Date() object for independent manipulation
     * 
     */
    open fun duplicate(): Unit = definedExternally
    /**
     *   Return the abbreviated (up to 3 chars) day of week name for this date (Mon, Tue, etc).
     *   To modify the value returned by this method, set DateUtil.shortDayNames
     * 
     * 
     *  @param {Integer} Number of characters to return (Defaults to 3, can't be                 longer than 3)
     */
    open fun getShortDayName(length: Number): String = definedExternally
    /**
     *   Return the full day of week name for this date (Monday, Tuesday, etc).
     *   To modify the value returned by this method, set DateUtil.dayNames
     * 
     * 
     */
    open fun getDayName(): String = definedExternally
    /**
     *   Return the abbreviated name of the month for this date (Jan, Feb, etc)
     *   To modify the value returned by this method,
     *   set DateUtil.shortMonthNames
     *   .
     * 
     *  @param {Integer} Number of characters to return (Defaults to 3, can't be longer than 3)
     */
    open fun getShortMonthName(length: Number): String = definedExternally
    /**
     *   Return the full name of the month for this date (January, February, etc)
     *   To modify the value returned by this method,
     *   set DateUtil.shortMonthNames
     *   .
     * 
     */
    open fun getMonthName(): String = definedExternally
    /**
     *     Return a 2 digit year for this date.
     * 
     */
    open fun getShortYear(): String = definedExternally
    /**
     *   Returns an integer containing the week number.
     * 
     */
    open fun getWeek(): Number = definedExternally
    /**
     *   Returns the FiscalYear object appropriate for the the current date, according to the
     *   FiscalCalendar.
     * 
     */
    open fun getFiscalYear(): FiscalYear = definedExternally
    /**
     *   Returns the fiscal week number of the current date, according to the global
     *   DateUtil.setFiscalCalendar.
     * 
     *  @param {FiscalCalendar=} the object representing the starts of fiscal years
     */
    open fun getFiscalWeek(fiscalCalendar: FiscalCalendar?): Number = definedExternally
    /**
     *     Return this date in the format (UTC timezone):
     *    YYYYMMDDTHHMMSS[Z]
     * 
     */
    open fun toDateStamp(): String = definedExternally
    /**
     *   Returns the date as a formatted string using the format set up via the
     *   setNormalDisplayFormat() method. Note that the default formatter for this
     *   method is "toLocaleString".
     * 
     *  @param {DateDisplayFormat} Optional Format for the date returned
     */
    open fun toNormalDate(format: 
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
                                  String /* toString |  toLocaleString |  toUSShortDate |  toUSShortDatetime |  toEuropeanShortDate |  toEuropeanShortDatetime |  toJapanShortDate |  toJapanShortDatetime |  toSerializeableDate |  toDateStamp */): String = definedExternally
    /**
     *   Returns the datetime as a formatted string using the format set up via the
     *   setNormalDatetimeDisplayFormat() method.
     * 
     *  @param {DateDisplayFormat} Optional Format for the date returned
     *  @param {boolean=} If a custom timezone has been set via  Time.setDefaultDisplayTimezone(), by default date formatters will respect this timezone.  To suppress this behavior, this parameter should be set to false.
     */
    open fun toNormalDatetime(format: 
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
                                      String /* toString |  toLocaleString |  toUSShortDate |  toUSShortDatetime |  toEuropeanShortDate |  toEuropeanShortDatetime |  toJapanShortDate |  toJapanShortDatetime |  toSerializeableDate |  toDateStamp */, useCustomTimezone: Boolean?): String = definedExternally
    /**
     *   Returns the date as a formatted string using the format set up via the
     *   setShortDisplayFormat() method.
     * 
     *  @param {DateDisplayFormat} Optional Format for the date returned
     *  @param {boolean=} If a custom timezone has been set via  Time.setDefaultDisplayTimezone(), by default date formatters will respect this timezone.  to suppress this behavior, this parameter should be set to false.
     */
    open fun toShortDate(format: 
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
                                 String /* toString |  toLocaleString |  toUSShortDate |  toUSShortDatetime |  toEuropeanShortDate |  toEuropeanShortDatetime |  toJapanShortDate |  toJapanShortDatetime |  toSerializeableDate |  toDateStamp */, useCustomTimezone: Boolean?): String = definedExternally
    /**
     *   Returns the datetime as a formatted string using the format set up via the
     *   setShortDatetimeDisplayFormat() method.
     * 
     *  @param {DateDisplayFormat} Optional Format for the date returned
     *  @param {boolean=} If a custom timezone has been set via  Time.setDefaultDisplayTimezone(), by default date formatters will respect this timezone.  to suppress this behavior, this parameter should be set to false.
     */
    open fun toShortDateTime(format: 
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
                                     String /* toString |  toLocaleString |  toUSShortDate |  toUSShortDatetime |  toEuropeanShortDate |  toEuropeanShortDatetime |  toJapanShortDate |  toJapanShortDatetime |  toSerializeableDate |  toDateStamp */, useCustomTimezone: Boolean?): String = definedExternally
    /**
     *   Sets a new default separator that will be used when formatting dates. By default, this
     *   is a forward slash character: "/"
     * 
     *  @param {string} separator to use in dates
     */
    open fun setDefaultDateSeparator(separator: String): Unit = definedExternally
    /**
     *   gets the default date separator string
     * 
     */
    open fun getDefaultDateSeparator(): String = definedExternally
    /**
     *     Return this date in the format: MM/DD/YYYY
     * 
     */
    open fun toUSShortDate(): String = definedExternally
    /**
     *   Return this date in the format: MM/DD/YYYY HH:MM
     * 
     * 
     */
    open fun toUSShortDateTime(): String = definedExternally
    /**
     *     Return this date in the format: DD/MM/YYYY
     * 
     */
    open fun toEuropeanShortDate(): String = definedExternally
    /**
     *   Return this date in the format: DD/MM/YYYY HH:MM.
     * 
     */
    open fun toEuropeanShortDateTime(): String = definedExternally
    /**
     *   Return the date in this format: YYYY/MM/DD
     * 
     */
    open fun toJapanShortDate(): String = definedExternally
    /**
     *     Return this date in the format: YYYY/MM/DD HH:MM:SS
     * 
     */
    open fun toJapanShortDateTime(): String = definedExternally
    /**
     *   Return this date in 'serialized' format YYYY-MM-DD HH:MM:SS
     * 
     */
    open fun toSerializeableDate(): String = definedExternally
    /**
     *   Set the formatter for this date object to the method name passed in. After this call
     *   wherever appropriate SmartClient components will use this formatter function to return
     *   the date as a string.
     * 
     *  @param {string} name of a date formatter method on this Date
     *  @deprecated \* As of SmartClient 5.5 use the static methods       DateUtil.setNormalDisplayFormat and
     *         DateUtil.setShortDisplayFormat to set default formatters for all dates
     */
    open fun setFormatter(functionName: String): Unit = definedExternally
    /**
     *     Return this date in the format: MM/DD/YY HH:MM
     * 
     *  @deprecated \* As of SmartClient 5.5 use Date.toShortDate instead
     */
    open fun toPrettyString(): String = definedExternally
    companion object {
        /**
         *  This property may be set to an array of names of days of the week.
         *   For example:
         * 
         *   ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"]
         * 
         *   The appropriate day name will then be returned from Date.getDayName, and may
         *   be used whenever SmartClient components display day-names (for example in the
         *   DateItem).
         *  @deprecated \* Use DateUtil.dayNames.
         *  @type {Array<any>}
         *  @default null
         */
        var dayNames: Array<dynamic> = definedExternally
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
         *  @deprecated \* Use DateUtil.shortDayNames.
         *  @type {Array<any>}
         *  @default null
         */
        var shortDayNames: Array<dynamic> = definedExternally
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
         *  @deprecated \* Use DateUtil.monthNames.
         *  @type {Array<any>}
         *  @default null
         */
        var monthNames: Array<dynamic> = definedExternally
        /**
         *  This property may be set to an array of shortened month-names.
         *   For example:
         * 
         *   ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]
         * 
         *   The appropriate month name will then be returned from Date.getShortMonthName,
         *   and may be used whenever SmartClient components display month-names (for example in the
         *   DateItem).
         *  @deprecated \* Use DateUtil.shortMonthNames.
         *  @type {Array<any>}
         *  @default null
         */
        var shortMonthNames: Array<dynamic> = definedExternally
        /**
         *  Days that are considered "weekend" days.  Values should be the integers returned by the
         *   JavaScript built-in Date.getDay(), eg, 0 is Sunday and 6 is Saturday. Override to
         *   accommodate different workweeks such as Saudi Arabia (Saturday -> Wednesday) or Israel
         *   (Sunday -> Thursday).
         *  @deprecated \* Use DateUtil.weekendDays.
         *  @type {Array<Partial<Integer>>}
         *  @default null
         */
        var weekendDays: Array<dynamic> = definedExternally
        /**
         *   Create a new Date to represent a logical date value (rather than a specific datetime value),
         *   typically for display in a DataSourceField.type. The generated
         *   Date value will have year, month and date set to the specified values
         *   (in browser native local time).
         * 
         *  @param {Integer} full year
         *  @param {Integer} month (zero based, so 0 is January)
         *  @param {Integer} date within the month
         *  @deprecated \* Use DateUtil.createLogicalDate.
         */
        fun createLogicalDate(year: Number, month: Number, date: Number): Date = definedExternally
        /**
         *   Create a new Date object to represent a logical time value (rather than a specific datetime
         *   value), typically for display in a DataSourceField.type. The generated
         *   Date value will have year, month and date set to the epoch date (Jan 1 1970), and time
         *   elements set to the supplied hour, minute and second (in browser native local time).
         * 
         *  @param {Integer} hour (0-23)
         *  @param {Integer} minute (0-59)
         *  @param {Integer} second (0-59)
         *  @deprecated \* Use DateUtil.createLogicalTime.
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
         *  @deprecated \* Use DateUtil.getLogicalDateOnly.
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
         *  @deprecated \* Use DateUtil.getLogicalTimeOnly.
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
         *  @deprecated \* Use DateUtil.combineLogicalDateAndTime.
         */
        fun combineLogicalDateAndTime(date: Date, time: Date): Date = definedExternally
        /**
         *   Compare two dates; returns 0 if equal, -1 if the first date is greater (later), or 1 if
         *   the second date is greater. If either value is not a Date object, it is treated as the
         *   epoch (midnight on Jan 1 1970) for comparison purposes.
         * 
         *  @param {Date} first date to compare
         *  @param {Date} second date to compare
         *  @deprecated \* Use DateUtil.compareDates.
         */
        fun compareDates(date1: Date, date2: Date): Number = definedExternally
        /**
         *   Compare two dates, normalizing out the time elements so that only the date elements are
         *   considered; returns 0 if equal, -1 if the first date is greater (later), or 1 if
         *   the second date is greater.
         * 
         *  @param {Date} first date to compare
         *  @param {Date} second date to compare
         *  @deprecated \* Use DateUtil.compareLogicalDates.
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
         *  @deprecated \* Use DateUtil.setInputFormat.
         */
        fun setInputFormat(format: dynamic): Unit = definedExternally
        /**
         *   Retrieves the default format for strings being parsed into dates via
         *   DateUtil.parseInput()
         * 
         *  @deprecated \* Use DateUtil.getInputFormat.
         */
        fun getInputFormat(): String = definedExternally
        /**
         *   Parse a date passed in as a string, returning the appropriate date object.
         * 
         *  @param {string} date value as a string
         *  @param {DateInputFormat=} Format of the date string being passed.                   If not passed, the default date input format as set up                    via setInputFormat() will be used.
         *  @param {Integer=} For date formats that support a 2 digit                 year, if parsed year is 2 digits and less than this                  number, assume year to be 20xx rather than 19xx
         *  @param {boolean=} If the string passed in was not a valid date, in some cases we can convert to a      valid date (for example incrementing the year if the month is greater than 12).      This optional parameter will suppress such conversions - anything that doesn't      parse directly to a valid date will simply return null.
         *  @deprecated \* Use DateUtil.parseInput.
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
         *  @deprecated \* Use DateUtil.setNormalDisplayFormat.
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
         *  @deprecated \* Use DateUtil.setNormalDatetimeDisplayFormat.
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
         *  @deprecated \* Use DateUtil.setShortDisplayFormat.
         */
        fun setShortDisplayFormat(format: dynamic): Unit = definedExternally
        /**
         *   Sets a new default separator that will be used when formatting dates. By default, this
         *   is a forward slash character: "/"
         * 
         *  @param {string} separator to use in dates
         *  @deprecated \* Use DateUtil.setDefaultDateSeparator.
         */
        fun setDefaultDateSeparator(separator: String): Unit = definedExternally
        /**
         *   gets the default date separator string
         * 
         *  @deprecated \* Use DateUtil.getDefaultDateSeparator.
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
         *  @deprecated \* Use DateUtil.setShortDatetimeDisplayFormat.
         */
        fun setShortDatetimeDisplayFormat(format: dynamic): Unit = definedExternally
        /**
         *   Sets the global fiscal calendar, which is used for all calls to
         *   getFiscalYear() / getFiscalWeek() if those methods aren't passed a fiscalCalander.
         * 
         * 
         *  @param {FiscalCalendar} the object representing the start month and date of      the fiscal year in the current locale
         *  @deprecated \* Use DateUtil.setFiscalCalendar.
         */
        fun setFiscalCalendar(fiscalCalendar: FiscalCalendar): Unit = definedExternally
        /**
         *   Returns the global FiscalCalendar representing the start month and
         *   date of the fiscal year in the current locale.
         * 
         *  @deprecated \* Use DateUtil.getFiscalCalendar.
         */
        fun getFiscalCalendar(): FiscalCalendar = definedExternally
        /**
         *   Returns the start date of the fiscal year for the passed date.
         * 
         * 
         *  @param {Date | number} the date, or the year-number, to get the fiscal year for
         *  @param {FiscalCalendar=} the object representing the starts of one or more               fiscal years
         *  @deprecated \* Use DateUtil.getFiscalStartDate.
         */
        fun getFiscalStartDate(date: dynamic, fiscalCalendar: FiscalCalendar?): Date = definedExternally
        /**
         *   Sets the global attribute that dictates whether the DateChooser shelled
         *   from DateItem show a UI for working with Fiscal Years.
         * 
         * 
         *  @param {boolean} whether to show Fiscal Year pickers in DateChoosers by default
         *  @deprecated \* Use DateUtil.setShowChooserFiscalYearPickers.
         */
        fun setShowChooserFiscalYearPickers(showChooserFiscalYearPickers: Boolean): Unit = definedExternally
        /**
         *   Sets the global attribute that dictates whether the DateChooser shelled
         *   from DateItem show a UI for working with Weeks.
         * 
         * 
         *  @param {boolean} whether to show Fiscal Week pickers in DateChoosers by default
         *  @deprecated \* Use DateUtil.setShowChooserWeekPickers.
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
         *  @deprecated \* Use DateUtil.setFirstDayOfWeek.
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
         *  @deprecated \* Use DateUtil.getFirstDayOfWeek.
         */
        fun getFirstDayOfWeek(): Number = definedExternally
        /**
         *   Returns the FiscalYear object for the fiscal year in which the passed date exists.
         * 
         * 
         *  @param {Date | Integer} the date to get the fiscal year for
         *  @param {FiscalCalendar=} the object representing the start of the fiscal period
         *  @deprecated \* Use DateUtil.getFiscalYear.
         */
        fun getFiscalYear(date: dynamic, fiscalCalendar: FiscalCalendar?): FiscalYear = definedExternally
        /**
         *   Returns a date's week-number, according to the fiscal calendar
         * 
         * 
         *  @param {Date} the date to get the fiscal year for
         *  @param {FiscalCalendar=} the object representing the starts of fiscal years
         *  @deprecated \* Use DateUtil.getFiscalWeek.
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
         *  @deprecated \* Use DateUtil.setWeekendDays.
         */
        fun setWeekendDays(weekendDays: Array<dynamic>): Unit = definedExternally
        /**
         *   Return an array of days that are considered "weekend" days. Values will be the integers
         *   returned by the JavaScript built-in Date.getDay(), eg, 0 is Sunday and 6 is Saturday.
         *   Override DateUtil.weekendDays to accommodate different workweeks such as Saudi Arabia
         *   (Saturday -> Wednesday) or Israel (Sunday -> Thursday).
         * 
         *  @deprecated \* Use DateUtil.getWeekendDays.
         */
        fun getWeekendDays(): Array<dynamic> = definedExternally
    }
}