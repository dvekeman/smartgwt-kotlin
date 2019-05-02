@file:JsQualifier("isc")
package isc

/**
 *  Grouping titles that will be displayed when data is grouped
 *   in a ListGrid.
 */
open external class GroupingMessages : Class {
    companion object {
        /**
         *  When a ListGrid is grouped by a date field in 'Upcoming' mode,
         *   this is the group title for all records in which the grouped date field occurs today,
         *   relative to the current date.
         *  @type {string}
         *  @default "Today"
         */
        var upcomingTodayTitle: String = definedExternally
        /**
         *  When a ListGrid is grouped by a date field in 'Upcoming' mode,
         *   this is the group title for all records in which the grouped date field occurs tomorrow,
         *   relative to the current date.
         *  @type {string}
         *  @default "Tomorrow"
         */
        var upcomingTomorrowTitle: String = definedExternally
        /**
         *  When a ListGrid is grouped by a date field in 'Upcoming' mode,
         *   this is the group title for all records in which the grouped date field occurs this week,
         *   relative to the current date.
         *  @type {string}
         *  @default "This Week"
         */
        var upcomingThisWeekTitle: String = definedExternally
        /**
         *  When a ListGrid is grouped by a date field in 'Upcoming' mode,
         *   this is the group title for all records in which the grouped date field occurs next week,
         *   relative to the current date.
         *  @type {string}
         *  @default "Next Week"
         */
        var upcomingNextWeekTitle: String = definedExternally
        /**
         *  When a ListGrid is grouped by a date field in 'Upcoming' mode,
         *   this is the group title for all records in which the grouped date field occurs next month,
         *   relative to the current date.
         *  @type {string}
         *  @default "Next Month"
         */
        var upcomingNextMonthTitle: String = definedExternally
        /**
         *  When a ListGrid is grouped by a date field in 'Upcoming' mode,
         *   this is the group title for all records in which the grouped date field occurs before
         *   the current date.
         *  @type {string}
         *  @default "Before"
         */
        var upcomingBeforeTitle: String = definedExternally
        /**
         *  When a ListGrid is grouped by a date field in 'Upcoming' mode,
         *   this is the group title for all records in which the grouped date field occurs later than
         *   one month after today's date.
         *  @type {string}
         *  @default "Later"
         */
        var upcomingLaterTitle: String = definedExternally
        /**
         *  Title to use for the menu option which groups a date field by day of week, across all
         *   weeks and years. For example, all values that are on any Tuesday are grouped together.
         *  @type {string}
         *  @default "by Day"
         */
        var byDayTitle: String = definedExternally
        /**
         *  Title to use for the menu option which groups a date field by week number, across all
         *   years. For example, all values that are in Week 30 of any year are grouped together.
         *  @type {string}
         *  @default "by Week"
         */
        var byWeekTitle: String = definedExternally
        /**
         *  Title to use for the menu option which groups a date field by month number, across all
         *   years. For example, all values that are in December of any year are grouped together.
         *  @type {string}
         *  @default "by Month"
         */
        var byMonthTitle: String = definedExternally
        /**
         *  Title to use for the menu option which groups a date field by quarter, across all
         *   years. For example, all values that are in Q4 of any year are grouped together.
         *  @type {string}
         *  @default "by Quarter"
         */
        var byQuarterTitle: String = definedExternally
        /**
         *  Title to use for the menu option which groups a date field by year.
         *  @type {string}
         *  @default "by Year"
         */
        var byYearTitle: String = definedExternally
        /**
         *  Title to use for the menu option which groups a date field by day of month, across all
         *   months and years. For example, all values that are on day 25 of any month in any year
         *   are grouped together.
         *  @type {string}
         *  @default "by Day of Month"
         */
        var byDayOfMonthTitle: String = definedExternally
        /**
         *  Title to use for the menu option which groups a date field by upcoming dates.
         *  @type {string}
         *  @default "by Upcoming"
         */
        var byUpcomingTitle: String = definedExternally
        /**
         *  Title to use for the menu option which groups a date field by specific dates. All
         *   values that are within the 24 hours of a specific date in a given year are
         *   grouped together.
         *  @type {string}
         *  @default "by Date"
         */
        var byDateTitle: String = definedExternally
        /**
         *  Title to use for the menu option which groups a date field by week number and year. All
         *   values that are in the same week in a given year are grouped together.
         *  @type {string}
         *  @default "by Week and Year"
         */
        var byWeekAndYearTitle: String = definedExternally
        /**
         *  Title to use for the menu option which groups a date field by month number and year.
         *   All values that are in the same month in a given year are grouped together.
         *  @type {string}
         *  @default "by Month and Year"
         */
        var byMonthAndYearTitle: String = definedExternally
        /**
         *  Title to use for the menu option which groups a date field by quarter and year. All
         *   values that are in the same quarter of a given year are grouped together.
         *  @type {string}
         *  @default "by Quarter and Year"
         */
        var byQuarterAndYearTitle: String = definedExternally
        /**
         *  Title to use for the menu option which groups a date field by specific day of week. All
         *   values that are in the same week and day of a given year are grouped together.
         *  @type {string}
         *  @default "by Day of specific Week"
         */
        var byDayOfWeekAndYearTitle: String = definedExternally
        /**
         *  Title to use for the menu option which groups a date field by specific day of month. All
         *   values that are in the same day and month of a given year are grouped together.
         *  @type {string}
         *  @default "by Day of specific Month"
         */
        var byDayOfMonthAndYearTitle: String = definedExternally
        /**
         *  Title to use for the menu option which groups a time field by hours.
         *  @type {string}
         *  @default "by Hours"
         */
        var byHoursTitle: String = definedExternally
        /**
         *  Title to use for the menu option which groups a time field by minutes.
         *  @type {string}
         *  @default "by Minutes"
         */
        var byMinutesTitle: String = definedExternally
        /**
         *  Title to use for the menu option which groups a time field by seconds.
         *  @type {string}
         *  @default "by Seconds"
         */
        var bySecondsTitle: String = definedExternally
        /**
         *  Title to use for the menu option which groups a time field by milliseconds.
         *  @type {string}
         *  @default "by Milliseconds"
         */
        var byMillisecondsTitle: String = definedExternally
        /**
         *  Title to use for the week number grouping mode
         *  @type {string}
         *  @default "Week #"
         */
        var weekNumberTitle: String = definedExternally
        /**
         *  Suffix to append to the timezoneMinutes grouping mode
         *  @type {string}
         *  @default "minutes"
         */
        var timezoneMinutesSuffix: String = definedExternally
        /**
         *  Suffix to append to the timezoneSeconds grouping mode
         *  @type {string}
         *  @default "seconds"
         */
        var timezoneSecondsSuffix: String = definedExternally
        /**
         *  Creates a new GroupingMessages
         * 
         *  @param typeCheckedProperties {Partial<GroupingMessages>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {GroupingMessages} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): GroupingMessages = definedExternally
    }
}