@file:JsQualifier("isc")
package isc

/**
 *  A subclass of EventCanvas, used to render
 *   Calendar.indicators at important points in
 *   CalendarView.
 * 
 *   An IndicatorCanvas is a non-interactive, semi-transparent canvas that highlights a portion of a
 *   calendar view, by rendering across all lanes and behind normal Calendar.data.
 * 
 *   By default, the canvas shows no label but does show a hover.
 * 
 *   Default styling is specified at the Calendar.indicatorStyleName
 *   and can be overridden for CalendarEvent.styleName.
 */
open external class IndicatorCanvas : EventCanvas {
    companion object {
        /**
         *  Creates a new IndicatorCanvas
         * 
         *  @param typeCheckedProperties {Partial<IndicatorCanvas>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {IndicatorCanvas} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): IndicatorCanvas = definedExternally
    }
}