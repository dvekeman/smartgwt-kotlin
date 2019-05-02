@file:JsQualifier("isc")
package isc

/**
 *  DrawItem subclass to render line segments.
 */
open external class DrawLine : DrawItem {
    /**
     *  Array of control knobs to display for this item. Each KnobType specified in this
     *   will turn on UI element(s) allowing the user to manipulate this DrawLine. To update the
     *   set of knobs at runtime use DrawItem.showKnobs and DrawItem.hideKnobs.
     * 
     *   DrawLine supports the
     *   "startPoint", "endPoint", and "move"
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
     *  Starting left coordinate of the line. Overrides left coordinate of DrawLine.startPoint if
     *   both are set.
     *  @type {Coordinate}
     *  @default "0"
     */
    open var startLeft: Number = definedExternally
    /**
     *  Starting top coordinate of the line. Overrides top coordinate of DrawLine.startPoint if
     *   both are set.
     *  @type {Coordinate}
     *  @default "0"
     */
    open var startTop: Number = definedExternally
    /**
     *  Ending left coordinate of the line. Overrides left coordinate of DrawLine.endPoint if
     *   both are set.
     *  @type {Coordinate}
     *  @default "100"
     */
    open var endLeft: Number = definedExternally
    /**
     *  Ending top coordinate of the line. Overrides top coordinate of DrawLine.endPoint if
     *   both are set.
     *  @type {Coordinate}
     *  @default "100"
     */
    open var endTop: Number = definedExternally
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
     *   Returns a bounding box for the DrawLine, taking into account the
     *   DrawItem.lineWidth.
     * 
     * 
     */
    override fun getBoundingBox(): Array<dynamic> = definedExternally
    /**
     *   Get the midpoint of the line.
     * 
     */
    override fun getCenter(): Point = definedExternally
    /**
     *   Returns true if the given point in the drawing coordinate system is within this DrawItem's shape,
     *   taking into account local transforms.
     * 
     *  @param {Integer} X coordinate of the test point.
     *  @param {Integer} Y coordinate of the test point.
     */
    override fun isPointInPath(x: Number, y: Number): Boolean = definedExternally
    /**
     *   Move both the start and end points of the line by a relative amount.
     * 
     * 
     *  @param {Distance} change to left coordinate in pixels
     *  @param {Distance} change to top coordinate in pixels
     */
    override fun moveBy(dX: dynamic, dY: dynamic): Unit = definedExternally
    /**
     *   Move both the start and end points of the line such that the DrawLine.startPoint ends up at
     *   the specified coordinate and the line length and angle are unchanged.
     * 
     * 
     *  @param {Integer} new left coordinate in pixels
     *  @param {Integer} new top coordinate in pixels
     */
    open fun moveStartPointTo(left: Number, top: Number): Unit = definedExternally
    companion object {
        /**
         *  Creates a new DrawLine
         * 
         *  @param typeCheckedProperties {Partial<DrawLine>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DrawLine} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DrawLine = definedExternally
    }
}