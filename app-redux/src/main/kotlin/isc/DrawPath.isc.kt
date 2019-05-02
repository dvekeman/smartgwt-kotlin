@file:JsQualifier("isc")
package isc

/**
 *  Draws a multi-segment line.
 */
open external class DrawPath : DrawItem {
    /**
     *  DrawPath only supports the
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
     *  Array of Points for the line, specified in the DrawPane.
     *  @type {Array<Partial<Point>>}
     *  @default "[[0,0], [100,100]]"
     */
    open var points: Array<dynamic> = definedExternally
    /**
     *   Returns the min, max points
     * 
     */
    override fun getBoundingBox(): Array<dynamic> = definedExternally
    /**
     *   Get the mean center of the path.
     * 
     */
    override fun getCenter(): Point = definedExternally
    /**
     *   Move all points in the path such that the first point ends up at the specified coordinates
     *   and the line lengths and angles are unchanged.
     * 
     * 
     *  @param {Integer} new left coordinate in pixels
     *  @param {Integer} new top coordinate in pixels
     */
    open fun moveFirstPointTo(left: Number, top: Number): Unit = definedExternally
    /**
     *   Move the points by dX,dY
     * 
     * 
     *  @param {Distance} delta x coordinate in pixels
     *  @param {Distance} delta y coordinate in pixels
     */
    override fun moveBy(dX: dynamic, dY: dynamic): Unit = definedExternally
    /**
     *   Resize to the specified size
     * 
     *  @param {Integer} new width
     *  @param {Integer} new height
     */
    override fun resizeTo(width: Number, height: Number): Unit = definedExternally
    /**
     *   Resize by the specified delta
     * 
     *  @param {Distance} number of pixels to resize by horizontally
     *  @param {Distance} number of pixels to resize by vertically
     */
    override fun resizeBy(dX: dynamic, dY: dynamic): Unit = definedExternally
    companion object {
        /**
         *  Creates a new DrawPath
         * 
         *  @param typeCheckedProperties {Partial<DrawPath>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DrawPath} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DrawPath = definedExternally
    }
}