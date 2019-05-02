@file:JsQualifier("isc")
package isc

/**
 *  CalendarView is a base class, extended by the various views available in a
 *   Calendar.
 */
open external class CalendarView : ListGrid {
    override fun selectAllRecords() = definedExternally

    /**
     *  The Calendar this view is in.
     *  @type {Calendar}
     *  @default null
     */
    open var calendar: Calendar = definedExternally
    /**
     *  The name of this view, used to identify it in the CalendarView.calendar.
     *  @type {string}
     *  @default null
     */
    open var viewName: String = definedExternally
    /**
     *  Should EventCanvas instances be reused when visible events change?
     *  @type {boolean}
     *  @default true
     */
    open var useEventCanvasPool: Boolean = definedExternally
    /**
     *  If specified, overrides Calendar.eventStyleName and dictates the CSS style to
     *   use for events rendered in this view. Has no effect on events that already have a
     *   CalendarEvent.styleName.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var eventStyleName: String = definedExternally
    /**
     *   Returns true if this view is the currently selected view in the parent calendar.
     * 
     */
    open fun isSelectedView(): Boolean = definedExternally
    /**
     *   Returns true if this is the Calendar.timelineView, false otherwise.
     * 
     */
    open fun isTimelineView(): Boolean = definedExternally
    /**
     *   Returns true if this is the Calendar.dayView, false otherwise.
     * 
     */
    open fun isDayView(): Boolean = definedExternally
    /**
     *   Returns true if this is the Calendar.weekView, false otherwise.
     * 
     */
    open fun isWeekView(): Boolean = definedExternally
    /**
     *   Returns true if this is the Calendar.monthView, false otherwise.
     * 
     */
    open fun isMonthView(): Boolean = definedExternally
    /**
     *   Rebuild this CalendarView, including a data refresh.
     * 
     */
    open fun rebuild(): Unit = definedExternally
    companion object {
        /**
         *  Creates a new CalendarView
         * 
         *  @param typeCheckedProperties {Partial<CalendarView>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {CalendarView} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): CalendarView = definedExternally
    }
}