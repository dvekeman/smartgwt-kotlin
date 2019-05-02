@file:JsQualifier("isc")
package isc

/**
 *  Lane shown in a Timeline view, or in a Calendar.dayView when
 *   Calendar.showDayLanes is true. Each lane is a row or column,
 *   respectively, that can contain a set of CalendarEvents. CalendarEvents are placed in
 *   lanes by matching the Lane.name property to the value of the
 *   Calendar.laneNameField property on the CalendarEvent.
 * 
 *   Lanes are typically used to show tasks assigned to different people, broadcasts planned for
 *   different channels, and similar displays.
 */
open external class Lane {
    /**
     *  To determine whether a CalendarEvent should be placed in this lane, the value of this
     *   attribute is compared with the Calendar.laneNameField property on the CalendarEvent.
     *  @type {string}
     *  @default null
     */
    open var name: String = definedExternally
    /**
     *  In Timelines, the height of this Lane's row. Has no effect when set on a Lane
     *   being displayed in a Calendar.dayView as a result of
     *   Calendar.showDayLanes being true.
     * 
     *   If set directly on a Lane.sublanes, overrides the default behavior of
     *   dividing the height equally among the lane's sublanes. Each sublane is still initially
     *   assigned an equal slice of the parent height, and the value for this sublane is
     *   then updated. So the overall height of the parent lane will change by the delta between the
     *   initial slice and the specified one.
     *  @type {number}
     *  @default null
     */
    open var height: dynamic = definedExternally
    /**
     *  When set on a Lane being displayed in a Calendar.dayView as a result of
     *   Calendar.showDayLanes being set, dictates the width of the Lane's column. Has no
     *   effect in Timelines.
     * 
     *   If set directly on a Lane.sublanes, overrides the default behavior of
     *   dividing the width equally among the lane's sublanes. Each sublane is still initially
     *   assigned an equal slice of the original parent width, and the value for this sublane is then
     *   updated. So the overall width of the parent lane will change by the delta between the
     *   initial slice and the specified one.
     *  @type {number}
     *  @default null
     */
    open var width: dynamic = definedExternally
    /**
     *  Title to show for this lane. Has no effect if set directly on Lane.sublanes.
     *  @type {HTMLString}
     *  @default null
     */
    open var title: String = definedExternally
    /**
     *  Array of Lane objects that will share the available space in the parent Lane,
     *   vertically in Calendar.timelineView and horizontally in
     *   Calendar.dayView.
     * 
     *   Only one level of sublanes is supported, so this attribute only has an effect on
     *   Calendar.lanes.
     * 
     *   Note that this feature is mutually exclusive with the
     *   Calendar.eventAutoArrange of events that share time.
     *  @type {Array<Partial<Lane>>}
     *  @default null
     */
    open var sublanes: Array<dynamic> = definedExternally
    /**
     *  The base name for the CSS class applied to Calendar.eventCanvas when they're
     *   rendered in this lane. See Calendar.eventStyleName.
     * 
     *   If set directly on a Lane.sublanes, overrides the corresponding value on
     *   the parent Calendar.lanes. See
     *   Calendar.getEventCanvasStyle for more information.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var eventStyleName: String = definedExternally
    /**
     *  The base style-name for normal cells in this Lane.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var styleName: String = definedExternally
    /**
     *  The base style-name for Calendar.laneFields displayed in this Lane.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var fieldStyleName: String = definedExternally
}