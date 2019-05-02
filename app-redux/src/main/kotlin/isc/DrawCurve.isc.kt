@file:JsQualifier("isc")
package isc

/**
 *  DrawItem that renders cubic bezier curves.
 */
open external class DrawCurve : DrawItem {
    /**
     *  Array of control knobs to display for this item. Each KnobType specified in this
     *   will turn on UI element(s) allowing the user to manipulate this DrawCurve. To update the
     *   set of knobs at runtime use DrawItem.showKnobs and DrawItem.hideKnobs.
     * 
     *   DrawCurve supports the
     *   "startPoint", "endPoint", "controlPoint1", and "controlPoint2"
     * 
     *   knob types.
     *  @type {Array<Partial<KnobType>>}
     *  @default null
     */
    override var knobs: Array<dynamic> = definedExternally
    /**
     *  If the DrawItem.titleLabel is showing, should the DrawItem.titleLabelBackground
     *   be created and placed behind the titleLabel?
     * 
     *   This defaults to true for DrawSectors and shapes that are not commonly filled
     *   (e.g. DrawLines).
     *  @type {boolean}
     *  @default true
     */
    override var showTitleLabelBackground: Boolean = definedExternally
    /**
     *  Start point of the curve
     *  @type {Point}
     *  @default "[0,0]"
     */
    open var startPoint: Point = definedExternally
    /**
     *  End point of the curve
     *  @type {Point}
     *  @default "[100,100]"
     */
    open var endPoint: Point = definedExternally
    /**
     *  First cubic bezier control point.
     *  @type {Point}
     *  @default "[100,0]"
     */
    open var controlPoint1: Point = definedExternally
    /**
     *  Second cubic bezier control point.
     *  @type {Point}
     *  @default "[0,100]"
     */
    open var controlPoint2: Point = definedExternally
    /**
     *  Style of drawing the endpoints of a line.
     * 
     *   Note that for dashed and dotted lines, the lineCap style affects each dash or dot.
     *  @type {LineCap}
     *  @default "butt"
     */
    override var lineCap: 
                          /**
                           *  Semicircular rounding
                           *  Squared-off endpoint
                           *  Square endpoint, stops exactly at the line's end coordinates instead          of extending 1/2 lineWidth further as "round" and "square" do
                           */
                          String /* round |  square |  butt */ = definedExternally
    /**
     *  If this item is showing "controlPoint1"
     * 
     *   DrawItem.knobs, this attribute specifies the AutoChild for the
     *   DrawKnob for control point 1 of current drawCurve.
     *  @type {DrawKnob}
     *  @default null
     */
    open var c1Knob: DrawKnob = definedExternally
    /**
     *  If this item is showing "controlPoint2"
     * 
     *   DrawItem.knobs, this attribute specifies the AutoChild for the
     *   DrawKnob for control point 2 of current drawCurve.
     *  @type {DrawKnob}
     *  @default null
     */
    open var c2Knob: DrawKnob = definedExternally
    /**
     *   Get the center point of the rectangle from the curve's DrawCurve.startPoint
     *   to the DrawCurve.endPoint.
     * 
     */
    override fun getCenter(): Point = definedExternally
    /**
     *   Update the startPoint
     * 
     * 
     *  @param {Coordinate} left coordinate for start point, in pixels
     *  @param {Coordinate} top coordinate for start point, in pixels
     */
    open fun setStartPoint(left: Number, top: Number): Unit = definedExternally
    /**
     *   Update the endPoint
     * 
     * 
     *  @param {Coordinate} left coordinate for end point, in pixels
     *  @param {Coordinate} top coordinate for end point, in pixels
     */
    open fun setEndPoint(left: Number, top: Number): Unit = definedExternally
    /**
     *   Updates the first cubic B&#233;zier control point.
     * 
     * 
     *  @param {Coordinate} left coordinate for control point, in pixels
     *  @param {Coordinate} top coordinate for control point, in pixels
     */
    open fun setControlPoint1(left: Number, top: Number): Unit = definedExternally
    /**
     *   Updates the second cubic B&#233;zier control point.
     * 
     * 
     *  @param {Coordinate} left coordinate for control point, in pixels
     *  @param {Coordinate} top coordinate for control point, in pixels
     */
    open fun setControlPoint2(left: Number, top: Number): Unit = definedExternally
    /**
     *   Returns the smallest box containing the entire curve.
     * 
     */
    override fun getBoundingBox(): Array<dynamic> = definedExternally
    /**
     *   Move the start point, end point, and control points of the curve such that the
     *   DrawCurve.startPoint ends up at the specified coordinates and the shape of the curve is
     *   unchanged.
     * 
     * 
     *  @param {Integer} new x coordinate in pixels
     *  @param {Integer} new y coordinate in pixels
     */
    open fun moveStartPointTo(x: Number, y: Number): Unit = definedExternally
    /**
     *   Increment start, end and control points of this curve
     * 
     * 
     *  @param {Distance} new x coordinate in pixels
     *  @param {Distance} new y coordinate in pixels
     */
    override fun moveBy(dX: dynamic, dY: dynamic): Unit = definedExternally
    companion object {
        /**
         *  Creates a new DrawCurve
         * 
         *  @param typeCheckedProperties {Partial<DrawCurve>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DrawCurve} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DrawCurve = definedExternally
    }
}