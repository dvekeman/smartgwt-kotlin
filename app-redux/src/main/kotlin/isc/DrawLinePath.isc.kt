@file:JsQualifier("isc")
package isc

/**
 *  DrawItem subclass to render a connector between two points. If the points are aligned
 *   on one axis, this connector will draw as a straight line. If the points are offset on
 *   both axes and there is enough space, the connector will by default draw short horizontal
 *   segments from the start and end points, and a diagonal segment connecting the ends of these
 *   'tail' segments. Connector style and orientation defaults may be changed through
 *   configuration.
 */
open external class DrawLinePath : DrawItem {
    /**
     *  The ConnectorStyle controlling the presentation and behavior of this line's
     *   tail segments.
     *  @type {ConnectorStyle}
     *  @default "diagonal"
     */
    open var connectorStyle: 
                             /**
                              *  Center segment is drawn diagonally between tail connector segments
                              *  Center segment is drawn perpendicular to tail connector segments
                              */
                             String /* diagonal |  rightAngle */ = definedExternally
    /**
     *  The ConnectorOrientation controlling the orientation and behavior of this line's
     *   tail segments.
     *  @type {ConnectorOrientation}
     *  @default "auto"
     */
    open var connectorOrientation: 
                                   /**
                                    *  Tail segments are always horizontal; best for left-to-right connectors
                                    *  Tail segments are always vertical; best for top-to-bottom connectors
                                    *  Tail segments flip orientation according to longer axis of bounding box: if the        bounding box is wider than it is tall, center segment is vertical
                                    */
                                   String /* horizontal |  vertical |  auto */ = definedExternally
    /**
     *  Array of control knobs to display for this item. Each KnobType specified in this
     *   will turn on UI element(s) allowing the user to manipulate this DrawLinePath. To update the
     *   set of knobs at runtime use DrawItem.showKnobs and DrawItem.hideKnobs.
     * 
     *   DrawLinePath supports the
     *   "startPoint", "endPoint", "controlPoint1", and "controlPoint2"
     * 
     *   knob types.
     *  @type {Array<Partial<KnobType>>}
     *  @default null
     */
    override var knobs: Array<dynamic> = definedExternally
    /**
     *  The mode in which the DrawItem.titleLabel (if shown) is rotated with
     *   this draw item.
     *  @type {TitleRotationMode}
     *  @default "withLineAlwaysUp"
     */
    override var titleRotationMode: 
                                    /**
                                     *  the titleLabel is never rotated with the item.
                                     *  the titleLabel is rotated exactly to match the item's rotation (see DrawItem.rotation).
                                     *  the titleLabel is rotated exactly to match the item's rotation, except that at certain rotations, the titleLabel is flipped
                                     *   by 180&deg; so that the title text is never upside down.
                                     *  (applies only to DrawLine and DrawLinePath) the titleLabel is rotated to match the line or center segment.
                                     * 
                                     *   If used on a DrawItem that is not a DrawLine or DrawLinePath,
                                     *   then the effect is the same as
                                     *   "withItem".
                                     * 
                                     *  (applies only to DrawLine and DrawLinePath) the titleLabel is rotated to match the line or center segment, except that
                                     *   at certain rotations, the titleLabel is flipped by 180&deg; so that the
                                     *   title text is never upside down.
                                     * 
                                     *   If used on a DrawItem that is not a DrawLine or DrawLinePath,
                                     *   then the effect is the same as
                                     *   "withItemAlwaysUp".
                                     * 
                                     */
                                    String /* neverRotate |  withItem |  withItemAlwaysUp |  withLine |  withLineAlwaysUp */ = definedExternally
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
     *  Start point of the line
     *  @type {Point}
     *  @default "[0,0]"
     */
    open var startPoint: Point = definedExternally
    /**
     *  End point of the line
     *  @type {Point}
     *  @default "[100,100]"
     */
    open var endPoint: Point = definedExternally
    /**
     *  The point at which the leading tail segment joins the connecting center segment.
     *  @type {Point}
     *  @default null
     */
    open var controlPoint1: Point = definedExternally
    /**
     *  The point at which the trailing tail segment joins the connecting center segment.
     *   Has no effect on lines with right angle ConnectorStyles.
     *  @type {Point}
     *  @default null
     */
    open var controlPoint2: Point = definedExternally
    /**
     *  Length of the horizontal/vertical "tail segments" between the start and end points of
     *   this DrawLinePath and the connecting center segment.
     *  @type {Distance}
     *  @default "30"
     */
    open var tailSize: dynamic = definedExternally
    /**
     *  Starting left coordinate of the line. Overrides left coordinate of DrawLinePath.startPoint if
     *   both are set.
     *  @type {Coordinate}
     *  @default "0 , IRW"
     */
    open var startLeft: Number = definedExternally
    /**
     *  Starting top coordinate of the line. Overrides top coordinate of DrawLinePath.startPoint if
     *   both are set.
     *  @type {Coordinate}
     *  @default "0 , IRW"
     */
    open var startTop: Number = definedExternally
    /**
     *  Ending left coordinate of the line. Overrides left coordinate of DrawLinePath.endPoint if
     *   both are set.
     *  @type {Coordinate}
     *  @default "0 , IRW"
     */
    open var endLeft: Number = definedExternally
    /**
     *  Ending top coordinate of the line. Overrides top coordinate of DrawLinePath.endPoint if
     *   both are set.
     *  @type {Coordinate}
     *  @default "0 , IRW"
     */
    open var endTop: Number = definedExternally
    /**
     *  Style of arrow head to draw at the end of the line or path.
     *  @type {ArrowStyle}
     *  @default ""open", IRW"
     */
    override var endArrow: 
                           /**
                            *  Filled triangle.
                            *  Two lines are drawn on each side of the path.
                            */
                           String /* block |  open */ = definedExternally
    /**
     *   Get the center point of the line path.
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
     *   Sets the coordinates of the controlPoint1 knob and by extension the coordinates of this
     *   DrawLinePath's leading tail segment.
     * 
     *  @param {Coordinate} left coordinate for start point, in pixels
     *  @param {Coordinate} top coordinate for start point, in pixels
     */
    open fun setControlPoint1(left: Number, top: Number): Unit = definedExternally
    /**
     *   Sets the coordinates of the controlPoint2 knob and by extension the coordinates of this
     *   DrawLinePath's trailing tail segment.
     * 
     *  @param {Coordinate} left coordinate for start point, in pixels
     *  @param {Coordinate} top coordinate for start point, in pixels
     */
    open fun setControlPoint2(left: Number, top: Number): Unit = definedExternally
    /**
     *   Returns the startPoint, endPoint
     * 
     */
    override fun getBoundingBox(): Array<dynamic> = definedExternally
    /**
     *   Move both the start and end points of the line by a relative amount.
     * 
     * 
     *  @param {Distance} change to left coordinate in pixels
     *  @param {Distance} change to top coordinate in pixels
     */
    override fun moveBy(dX: dynamic, dY: dynamic): Unit = definedExternally
    /**
     *   Moves the line path such that the DrawLinePath.startPoint ends up at the specified point.
     * 
     * 
     *  @param {Integer} new left coordinate in pixels
     *  @param {Integer} new top coordinate in pixels
     */
    open fun moveStartPointTo(left: Number, top: Number): Unit = definedExternally
    companion object {
        /**
         *  Creates a new DrawLinePath
         * 
         *  @param typeCheckedProperties {Partial<DrawLinePath>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DrawLinePath} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DrawLinePath = definedExternally
    }
}