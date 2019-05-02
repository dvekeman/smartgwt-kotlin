@file:JsQualifier("isc")
package isc

/**
 *  Canvas that renders a DrawItem into a DrawPane and provides interactivity for
 *   that drawItem, including drag and drop.
 * 
 *   A DrawKnob can either be initialized with a DrawKnob.knobShape or created via
 *   the AutoChild pattern.
 * 
 *   DrawKnobs are used by the DrawItem.knobs subsystem.
 */
open external class DrawKnob : Canvas {
    /**
     *  The DrawItem instance rendered into this DrawKnob's drawPane
     *  @type {DrawItem}
     *  @default null
     */
    open var knobShape: DrawItem = definedExternally
    /**
     *  Default properties for this component's DrawKnob.knobShape. Has the
     *   following properties by default:
     * 
     *   radius : 5,
     *   lineWidth:2,
     *   fillColor:"#FF0000",
     *   fillOpacity:0.5,
     * 
     *   As with any auto-child defaults block, use Class.changeDefaults
     *   to modify this object.
     *  @type {DrawItem}
     *  @default "{...}"
     */
    open var knobShapeDefaults: DrawItem = definedExternally
    /**
     *  DrawPane into which this DrawKnob's DrawKnob.knobShape will be rendered.
     *  @type {DrawPane}
     *  @default null
     */
    open var drawPane: DrawPane = definedExternally
    /**
     *  X-Coordinate for this DrawKnob. DrawKnob will initially be drawn centered over this
     *   coordinate
     *  @type {Integer}
     *  @default null
     */
    open var x: Number = definedExternally
    /**
     *  Y-Coordinate for this DrawKnob. DrawKnob will initially be drawn centered over this
     *   coordinate
     *  @type {Integer}
     *  @default null
     */
    open var y: Number = definedExternally
    /**
     *   Sets the center point of the drawKnob. If the optional viewboxCoords
     *   argument is passed, coordinates are expected to be adjusted for drawPane pan
     *   and zoom. Otherwise coordinates are expected to be absolute pixel coordinates within
     *   the drawPane.
     * 
     *  @param {Integer} new x coordinate for this drawKnob
     *  @param {Integer} new y coordinate for this drawKnob
     *  @param {boolean=} If true, the x and y values are expected to be in the viewbox coordinate system (described DrawPane) - already adjusted for any zoom or pan applied to the drawPane.
     */
    open fun setCenterPoint(x: Number, y: Number, viewboxCoords: Boolean?): Unit = definedExternally
    /**
     *   Method called in response to the user dragging this DrawKnob. May be observed or overridden
     *   to allow drawItems to react to user drag interactions on this knob.
     * 
     *   Note that the default implementation does nothing. When working with draw knobs directly this
     *   is typically where you would both update the shape being controlled by the draw knob, and
     *   ensure the drawKnob gets repositioned. You may also need to update the drawKnob
     *   position in response to the drawItem being repositioned, resized, etc.
     * 
     * 
     *  @param {Integer} new x-coordinate of the drawKnob
     *  @param {Integer} new y-coordinate of the drawKnob
     *  @param {Integer} horizontal distance moved
     *  @param {Integer} vertical distance moved
     *  @param {string} either "start", "move", or "stop", to indicate the current phase of dragging of the DrawKnob for which the points need to be updated
     */
    open fun updatePoints(x: Number, y: Number, dX: Number, dY: Number, state: String): Unit = definedExternally
    companion object {
        /**
         *  Creates a new DrawKnob
         * 
         *  @param typeCheckedProperties {Partial<DrawKnob>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DrawKnob} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DrawKnob = definedExternally
    }
}