@file:JsQualifier("isc")
package isc

/**
 *  A JavaScript object specifying a range of dates. Values are DateRange.start
 *   and DateRange.end. If either value is omitted, the range is assumed to be
 *   open-ended in that direction - so if dateRange.start is omitted, the range will include any
 *   date earlier than the value specified in dateRange.end.
 */
open external class DateRange {
    /**
     *  The start of this DateRange.
     *  @type {RelativeDate | Date}
     *  @default null
     */
    open var start: dynamic = definedExternally
    /**
     *  The end of this DateRange.
     *  @type {RelativeDate | Date}
     *  @default null
     */
    open var end: dynamic = definedExternally
}