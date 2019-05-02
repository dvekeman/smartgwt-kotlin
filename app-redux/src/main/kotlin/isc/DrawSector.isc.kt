@file:JsQualifier("isc")
package isc

/**
 *  DrawItem subclass to render Pie Slices.
 */
open external class DrawSector : DrawItem {
    /**
     *  DrawSector only supports the
     *   "move"
     * 
     *   knob type.
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
     *  Rotation in degrees about the DrawSector.centerPoint of the DrawSector.
     *   The positive direction is clockwise.
     *  @type {Float}
     *  @default "0.0"
     */
    override var rotation: Number = definedExternally
    /**
     *  Center point of the sector
     *  @type {Point}
     *  @default "[0,0]"
     */
    open var centerPoint: Point = definedExternally
    /**
     *  Start angle of the sector in degrees. Default of 0.0 will create a sector that starts
     *   with a line from the DrawSector.centerPoint and extends to the right for the indicated
     *   DrawSector.radius, then sweeps clockwise toward the DrawSector.endAngle.
     *  @type {Float}
     *  @default "0.0"
     */
    open var startAngle: Number = definedExternally
    /**
     *  End angle of the sector in degrees.
     *  @type {Float}
     *  @default "20.0"
     */
    open var endAngle: Number = definedExternally
    /**
     *  Radius of the sector.
     *  @type {Distance}
     *  @default "100"
     */
    open var radius: dynamic = definedExternally
    /**
     *   Returns the centerPoint endPoint
     * 
     */
    override fun getBoundingBox(): Array<dynamic> = definedExternally
    /**
     *   Returns the sector's DrawSector.centerPoint.
     * 
     */
    override fun getCenter(): Point = definedExternally
    /**
     *   Calculates the coordinates of the midpoint of this DrawSector's circular arc. The formula
     *   for this point is:
     * 
     *   var averageAngle = (startAngle + endAngle) / 2; // in degrees
     *  [centerX + radius \* cosdeg(averageAngle), centerY + radius \* sindeg(averageAngle)]
     * 
     * 
     */
    open fun getArcMidpoint(): Point = definedExternally
    /**
     *   Change the center point for this sector.
     * 
     *  @param {Coordinate} X coordinate of the center point (in the global coordinate system).
     *  @param {Coordinate} Y coordinate of the center point (in the global coordinate system.
     */
    override fun setCenterPoint(left: Number, top: Number): Unit = definedExternally
    /**
     *   Move the DrawSector by the specified amounts.
     * 
     *  @param {Distance} number of pixels to move by horizontally
     *  @param {Distance} number of pixels to move by vertically
     */
    override fun moveBy(dX: dynamic, dY: dynamic): Unit = definedExternally
    companion object {
        /**
         *  Creates a new DrawSector
         * 
         *  @param typeCheckedProperties {Partial<DrawSector>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DrawSector} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DrawSector = definedExternally
        /**
         *   Calculates the midpoint coordinates of the circular arc of the sector defined by the
         *   given centerPoint, startAngle, endAngle, and radius. The formula for this point is:
         * 
         *   var averageAngle = (startAngle + endAngle) / 2; // in degrees
         *  [centerX + radius \* cosdeg(averageAngle), centerY + radius \* sindeg(averageAngle)]
         * 
         * 
         *  @param {Double} X coordinate of the center point of the sector.
         *  @param {Double} Y coordinate of the center point of the sector.
         *  @param {Double} start angle of the sector in degrees.
         *  @param {Double} end angle of the sector in degrees.
         *  @param {Double} radius of the sector.
         */
        fun getArcMidpoint(centerX: Number, centerY: Number, startAngle: Number, endAngle: Number, radius: Number): Point = definedExternally
    }
}