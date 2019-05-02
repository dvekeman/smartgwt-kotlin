@file:JsQualifier("isc")
package isc

/**
 *  A "double slider" allowing the user to select a range via two draggable thumbs.
 */
open external class RangeSlider : Canvas {
    /**
     *  Thumb for the start of the range.
     *  @type {Snapbar}
     *  @default null
     */
    open var startThumb: Snapbar = definedExternally
    /**
     *  Thumb for the end of the range
     *  @type {Snapbar}
     *  @default null
     */
    open var endThumb: Snapbar = definedExternally
    /**
     *  Optional track of the RangeSlider. Set showTrack false to avoid showing
     *   a track so the RangeSlider can be superimposed over something else.
     *  @type {Canvas}
     *  @default null
     */
    open var track: Canvas = definedExternally
    /**
     *  Optional Scrollbar shown as a second way of adjusting the range.
     *  @type {Scrollbar}
     *  @default null
     */
    open var scrollbar: Scrollbar = definedExternally
    /**
     *  Whether the rangeSlider should be vertical or horizontal. Default is horizontal.
     *  @type {boolean}
     *  @default false
     */
    open var vertical: Boolean = definedExternally
    /**
     *  Set the minimum value (left/top of slider).
     *  @type {Float}
     *  @default "0"
     */
    open var minValue: Number = definedExternally
    /**
     *  Set the maximum value (right/bottom of slider).
     *  @type {Float}
     *  @default "0"
     */
    open var maxValue: Number = definedExternally
    /**
     *  The beginning of the selected range.
     *  @type {Float}
     *  @default "0"
     */
    open var startValue: Number = definedExternally
    /**
     *  The end of the selected range.
     *  @type {Float}
     *  @default "0"
     */
    open var endValue: Number = definedExternally
    /**
     *  Base style name for CSS styles applied to the background of the rangeSlider. The following
     *   suffixes are applied for different areas of the slider:
     * 
     * 
     *  - "Start": area of the slider before the startThumb
     * 
     *  - "Selected": area of the slider between the thumbs (the selected range)
     * 
     *  - "End": area of the slider after the endThumb
     * 
     *   .. and the following suffixes are applied in addition according to the slider's dynamic state:
     * 
     * 
     *  - "Over": if the mouse is over the segment
     * 
     *  - "Down": if the mouse is down on the segment
     * 
     *   For example, if the mouse is down in the area before the start thumb, that area will have the
     *   CSS style "rangeSliderStartDown".
     *  @type {CSSStyleName}
     *  @default "rangeSlider"
     */
    open var baseStyle: String = definedExternally
    /**
     *   Notification fired when the selected range is changed by the end user.
     * 
     * 
     *  @param {Float} new start value
     *  @param {Float} new end value
     *  @param {boolean} whether the user is still in the middle of a drag, so that expensive operations can be avoided if needed
     */
    open fun changed(startValue: Number, endValue: Number, isDragging: Boolean): Unit = definedExternally
    companion object {
        /**
         *  Creates a new RangeSlider
         * 
         *  @param typeCheckedProperties {Partial<RangeSlider>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {RangeSlider} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): RangeSlider = definedExternally
    }
}