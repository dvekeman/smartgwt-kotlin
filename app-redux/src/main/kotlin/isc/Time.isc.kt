@file:JsQualifier("isc")
package isc

/**
 *  Helper methods and system-wide defaults for dealing with time values and time display formats.
 * 
 *   This class includes utility methods for the creation and display of logical time values, as well
 *   as modifying the default display timezone for datetime type values. See
 *   dateFormatAndStorage for more information on working with dates, times and datetimes
 *   in SmartClient.
 */
open external class Time : Class {
    companion object {
        /**
         *  Hour offset from UTC to use when formatting FieldType type fields for
         *   display to the user.
         * 
         *   Has no effect on fields specified as logical date (field.type = "date";) and
         *   logical time (field.type = "time") fields.
         *  @deprecated \* As of 7.0 this attribute has been deprecated in favor of Time.setDefaultDisplayTimezone
         *  @type {number}
         *  @default null
         */
        var UTCHoursOffset: Number = definedExternally
        /**
         *  Standard formatter to be used when converting a date to a time-string via Time.toTime
         *  @type {TimeDisplayFormat | Function}
         *  @default "toTime"
         */
        var displayFormat: dynamic = definedExternally
        /**
         *  Standard formatter to be used when converting a date to a time-string via Time.toShortTime
         *  @type {TimeDisplayFormat | Function}
         *  @default "toShortTime"
         */
        var shortDisplayFormat: dynamic = definedExternally
        /**
         *  String appended to times to indicate am (when not using 24 hour format).
         *  @type {string}
         *  @default " am"
         */
        var AMIndicator: String = definedExternally
        /**
         *  String appended to times to indicate am (when not using 24 hour format).
         *  @type {string}
         *  @default " pm"
         */
        var PMIndicator: String = definedExternally
        /**
         *  Determines whether datetime formatters should consider the effect of Daylight Saving
         *   Time when computing offsets from UTC. By default, this flag is set during framework
         *   initialization if SmartClient detects that it is running in a locale that is observing
         *   DST this year. If you do not want DST adjustments to be applied, set this flag to
         *   false.
         *   Note that setting this flag to true will have no effect unless you are in a locale
         *   that is observing Daylight Saving Time for the date in question; this is because
         *   we rely on the browser for offset information, and browsers are only capable of
         *   returning local date and time information for the computer's current locale.
         * 
         *   This setting will not have any impact on the display of fields specified as type "time" or
         *   "date" (logical dates and logical times) - only on datetime type values. See
         *   dateFormatAndStorage for information on working with dates, times and datetimes
         *   in SmartClient.
         *  @type {boolean}
         *  @default "true (see description)"
         */
        var adjustForDST: Boolean = definedExternally
        /**
         *  Indicate whether calls to DateUtil.format with no formatter show times in
         *   24-hour format. This includes UI elements, such as TimeItem and
         *   Calendar, when no formatters are provided.
         *  @type {boolean}
         *  @default true
         */
        var use24HourTime: Boolean = definedExternally
        /**
         *  The separator character to include between hours, minutes and seconds when parsing and
         *   formatting Time strings.
         *  @type {string}
         *  @default ":"
         */
        var defaultTimeSeparator: String = definedExternally
        /**
         *  The separator character to include before the milliseconds element when parsing and
         *   formatting Time strings.
         *  @type {string}
         *  @default "."
         */
        var defaultMillisecondSeparator: String = definedExternally
        /**
         *  Creates a new Time
         * 
         *  @param typeCheckedProperties {Partial<Time>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Time} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Time = definedExternally
        /**
         *   Sets the offset from UTC to use when formatting values of type FieldType
         *   with standard display formatters.
         * 
         *   This property affects how dates are displayed and also the
         *   assumed timezone for user-input. For a concrete example - assume this method has been called
         *   and passed a value of "+01:00", and an application has a DateTimeItem visible in
         *   a DynamicForm. If the value of this field is set to the current date, with UTC time set to
         *   "10:00", the time portion of the value displayed in the form item will be "11:00".
         *   Similarly if a user modifies the time value in the text box to be "16:00", a call to
         *   FormItem.getValue for the item will return a date object with UTC time set to 15:00.
         * 
         *   Interaction with daylight savings time: The specified "defaultDisplayTimezone" should
         *   reflect the correct UTC offset for the current date, for which it will always be exactly respected;
         *   adjustment will only be made for dates that fall outside the current daylight savings time mode.
         * 
         *   In other words if DST is currently not in effect (IE: the current date is a Winter date),
         *   any other dates where DST is not in effect will be formatted to exactly respect the specified
         *   defaultDisplayTimezone (so for defaultDisplayTimezone of "+01:00", the display
         *   string will be 1 hour ahead of the UTC time on the date in question), and any
         *   dates where DST is in effect would be further adjusted to account for DST
         *   (so the display string would be 2 hours ahead for dates that fall in the Summer).
         *   Alternatively if DST currently is in effect (EG: Current date is a Summer date)
         *   the situation is reversed. Any date value for which DST should be applied
         *   will be be formatted for display with an offset of 1 hour from UTC - and any date value
         *   for which DST should not be applied would be formatted with an offset of 0 hours from UTC.
         * 
         *   Note that the Time.adjustForDST property may be set to false to
         *   disable this logic - in this case the time portion of dates will always be offset from
         *   UTC by exactly the specified defaultDisplayOffset, regardless of whether they fall in the
         *   range where Daylight Savings Time would usually be applied or not.
         * 
         *   Note that if a custom timezone is specified, it will not effect native javascript
         *   date formatting functions such as toLocaleString().
         *   See dateFormatAndStorage for more on how SmartClient handles date and time
         *   formatting and storage.
         * 
         *   If this method is never called, the default display timezone for times and datetimes will
         *   be derived from the native browser local timezone.
         * 
         *   Note that the displayTimezone effects datetime fields only and has no effect on fields
         *   specified as logical date (field.type = "date";) or
         *   logical time (field.type = "time").
         * 
         * 
         *  @param {string} offset from UTC. This should be a string in the format  +/-HH:MM for example "-08:00"
         */
        fun setDefaultDisplayTimezone(offset: String): Unit = definedExternally
        /**
         *   Returns the default display timezone set up by Time.setDefaultDisplayTimezone.
         *   If no explicit timezone has been set this will return the browser locale timezone offset.
         * 
         */
        fun getDefaultDisplayTimezone(): String = definedExternally
        /**
         *   Given a date object, return the time associated with the date as a formatted string.
         *   If no formatter is passed, use the standard formatter set up via
         *   Time.setNormalDisplayFormat.
         * 
         * 
         *  @param {Date} Date to convert to a time string.
         *  @param {TimeDisplayFormat | FormatString | Function=} Optional custom formatter to use. Will accept a function (which will be passed a pointer to the  Date to format), a format string, or a string designating a standard formatter
         *  @param {boolean=} Is the date passed in a representation of a logical time value such as a value from a "time" type field on a dataSource or a datetime value?  For datetime values the formatted string will respect any custom  Time.setDefaultDisplayTimezone. If not explicitly specified, the date passed in will be assumed to be a datetime unless it was created explicitly as a time via Time.createLogicalTime or similar APIs.
         */
        fun toTime(date: Date, formatter: dynamic?, logicalTime: Boolean?): Unit = definedExternally
        /**
         *   Given a date object, return the time associated with the date as a short string.
         *   If no formatter is passed, use the standard formatter set up via Time.setShortDisplayFormat
         * 
         *  @param {Date} Date to convert to a time string.
         *  @param {TimeDisplayFormat | FormatString | Function=} Optional custom formatter to use. Will accept a function (which will be passed a pointer to the  Date to format), a format string, or a string designating a standard formatter
         *  @param {boolean=} Is the date passed in a representation of a logical time value such as a value from a "time" type field on a dataSource or a datetime value?  For datetime values the formatted string will respect any custom  Time.setDefaultDisplayTimezone. If not explicitly specified, the date passed in will be assumed to be a datetime unless it was created explicitly as a time via Time.createLogicalTime or similar APIs.
         */
        fun toShortTime(date: Date, formatter: dynamic?, logicalTime: Boolean?): Unit = definedExternally
        /**
         *   Converts a time-string such as 1:00pm to a new Date object
         *   representing a logical time value (rather than a specific datetime
         *   value), typically for display in a DataSourceField.type.
         *   Accepts most formats of time string. The generated
         *   Date value will have year, month and date set to the epoch date (Jan 1 1970), and time
         *   elements set to the supplied hour, minute and second (in browser native local time).
         * 
         *   See dateFormatAndStorage for more information on date, time and datetime
         *   values in SmartClient.
         * 
         * 
         *  @param {string} time string to convert to a date
         *  @param {boolean} If this method is passed a timeString in an unrecognized format, return null rather than a date object with time set to 00:00:00
         */
        fun parseInput(timeString: String, validTime: Boolean): Unit = definedExternally
        /**
         *   Creates a date object with the time set to the hours, minutes and seconds passed in.
         *   Unless the UTCTime parameter is passed in, parameters are assumed
         *   to specify the time in native local display time.
         * 
         *  @param {number=} Hours for the date (defaults to zero)
         *  @param {number=} Minutes for the date (defaults to zero)
         *  @param {number=} Seconds for the date (defaults to zero)
         *  @param {number=} Milliseconds for the date (defaults to zero)
         *  @param {boolean=} If true, treat the time passed in as UTC time rather than local time
         *  @deprecated \* use Time.createLogicalTime instead.
         */
        fun createDate(hours: Number?, minutes: Number?, seconds: Number?, milliseconds: Number?, UTCTime: Boolean?): Unit = definedExternally
        /**
         *   Create a new Date object to represent a logical time value (rather than a specific datetime
         *   value), typically for display in a DataSourceField.type. The generated
         *   Date value will have year, month and date set to the epoch date (Jan 1 1970), and time
         *   elements set to the supplied hour, minute and second (in browser native local time).
         * 
         *   See dateFormatAndStorage for more information on date, time and datetime
         *   values in SmartClient.
         * 
         * 
         *  @param {Integer} hour (0-23)
         *  @param {Integer} minute (0-59)
         *  @param {Integer} second (0-59)
         */
        fun createLogicalTime(hour: Number, minute: Number, second: Number): Date = definedExternally
        /**
         *   Sets the default format for strings returned by Time.toShortTime.
         * 
         *  @param {TimeDisplayFormat | FormatString | Function} Optional custom formatter to use. Will accept a function (which will be passed a pointer to the  Date to format), a format string, or a string designating a standard formatter
         */
        fun setShortDisplayFormat(formatter: dynamic): Unit = definedExternally
        /**
         *   Sets the default format for strings returned by Time.toTime.
         * 
         *  @param {TimeDisplayFormat | FormatString | Function} Optional custom formatter to use. Will accept a function (which will be passed a pointer to the  Date to format), a format string, or a string designating a standard formatter
         */
        fun setNormalDisplayFormat(formatter: dynamic): Unit = definedExternally
        /**
         *   Compares the times of 2 dates, or strings. If a string is passed as one of the
         *   parameters it should be in a format that converts to a valid time such as "1:30pm",
         *   "13:30", or "1:30:45pm"
         * 
         *  @param {Date | string} First time to compare
         *  @param {Date | string} Second time to compare
         */
        fun compareTimes(time1: dynamic, time2: dynamic): Boolean = definedExternally
    }
}