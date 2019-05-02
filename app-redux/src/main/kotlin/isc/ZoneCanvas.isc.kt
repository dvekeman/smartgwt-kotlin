@file:JsQualifier("isc")
package isc

/**
 *  A subclass of EventCanvas, used to render
 *   Calendar.zones in CalendarView.
 * 
 *   A ZoneCanvas is a semi-transparent canvas that highlights a portion of a
 *   calendar view, by rendering across all lanes and behind normal Calendar.data.
 * 
 *   By default, the canvas shows a bottom-aligned label containing the
 *   CalendarEvent.name.
 *   Default styling is specified at the Calendar.zoneStyleName
 *   and can be overridden for CalendarEvent.styleName.
 */
open external class ZoneCanvas : EventCanvas {
    companion object {
        /**
         *  Creates a new ZoneCanvas
         * 
         *  @param typeCheckedProperties {Partial<ZoneCanvas>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ZoneCanvas} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ZoneCanvas = definedExternally
    }
}