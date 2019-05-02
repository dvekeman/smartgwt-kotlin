@file:JsQualifier("isc")
package isc

/**
 *  An object representing a relative date, useful for representing date ranges etc in criteria.
 *   RelativeDate objects may be created directly by SmartClient components such as the
 *   RelativeDateItem.
 * 
 *   RelativeDate objects will have "_constructor" set to "RelativeDate"
 *   and must have a specified RelativeDate.value. Any other attributes are optional.
 */
open external class RelativeDate {
    /**
     *  The value of this relative date, specified as a RelativeDateString
     *   or RelativeDateShortcut.
     *  @type {RelativeDateString | RelativeDateShortcut}
     *  @default null
     */
    open var value: String = definedExternally
    /**
     *  If this relative date has its value specified as a RelativeDateShortcut which doesn't
     *   specify an exact time-period boundary - for example "$yesterday", this attribute
     *   may be set to specify whether the date should be interpreted as the start or end boundary of
     *   the time period.
     *  @type {RelativeDateRangePosition}
     *  @default null
     */
    open var rangePosition: 
                            /**
                             *  Indicates this relative date should be treated as the start of the specified  logical date.
                             *  Indicates this relative date should be treated as the end of the specified logical  date.
                             */
                            String /* start |  end */ = definedExternally
}