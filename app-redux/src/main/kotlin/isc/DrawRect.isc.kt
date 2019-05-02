@file:JsQualifier("isc")
package isc

/**
 *  DrawItem subclass to render rectangle shapes, optionally with rounded corners.
 */
open external class DrawRect : DrawItem {
    /**
     *  Left coordinate in pixels relative to the DrawPane.
     *  @type {Coordinate}
     *  @default "0"
     */
    open var left: Number = definedExternally
    /**
     *  Top coordinate in pixels relative to the DrawPane.
     *  @type {Coordinate}
     *  @default "0"
     */
    open var top: Number = definedExternally
    /**
     *  Width in pixels relative to the DrawPane.
     *  @type {Distance}
     *  @default "100"
     */
    open var width: dynamic = definedExternally
    /**
     *  Height in pixels relative to the DrawPane.
     *  @type {Distance}
     *  @default "100"
     */
    open var height: dynamic = definedExternally
    /**
     *  Rounding of corners, from 0 (square corners) to 1.0 (shorter edge is a semicircle).
     *  @type {Float}
     *  @default "0"
     */
    open var rounding: Number = definedExternally
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
     *  The mode in which the DrawItem.titleLabel (if shown) is rotated with
     *   this draw item.
     *  @type {TitleRotationMode}
     *  @default "withItemAlwaysUp"
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
     *   Move the drawRect such that it is centered over the specified coordinates.
     * 
     *  @param {Coordinate} left coordinate for new center position
     *  @param {Coordinate} top coordinate for new center postiion
     */
    open fun setCenter(left: Number, top: Number): Unit = definedExternally
    /**
     *   Get the center point of the rectangle.
     * 
     */
    override fun getCenter(): Point = definedExternally
    /**
     *   Returns the top, left, top+height, left+width
     * 
     */
    override fun getBoundingBox(): Array<dynamic> = definedExternally
    /**
     *   Returns true if the given point in the drawing coordinate system is within this DrawItem's shape,
     *   taking into account local transforms.
     * 
     *  @param {Integer} X coordinate of the test point.
     *  @param {Integer} Y coordinate of the test point.
     */
    override fun isPointInPath(x: Number, y: Number): Boolean = definedExternally
    /**
     *   Move the drawRect by the specified delta
     * 
     *  @param {Distance} number of pixels to move horizontally
     *  @param {Distance} number of pixels to move vertically
     */
    override fun moveBy(dX: dynamic, dY: dynamic): Unit = definedExternally
    /**
     *   Move the drawRect to the specified position
     * 
     *  @param {Integer} new left coordinate
     *  @param {Integer} new top coordinate
     */
    override fun moveTo(left: Number, top: Number): Unit = definedExternally
    /**
     *   Set the left coordinate of the drawRect
     * 
     *  @param {Coordinate} new left coordinate
     */
    open fun setLeft(left: Number): Unit = definedExternally
    /**
     *   Set the top coordinate of the drawRect
     * 
     *  @param {Coordinate} new top coordinate
     */
    open fun setTop(top: Number): Unit = definedExternally
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
    /**
     *   Set the width of the drawRect
     * 
     *  @param {Distance} new width
     */
    open fun setWidth(width: dynamic): Unit = definedExternally
    /**
     *   Set the height of the drawRect
     * 
     *  @param {Distance} new height
     */
    open fun setHeight(height: dynamic): Unit = definedExternally
    /**
     *   Move and resize the drawRect to match the specified coordinates and size.
     * 
     *  @param {Integer} new left coordinate
     *  @param {Integer} new top coordinate
     *  @param {Integer} new width
     *  @param {Integer} new height
     */
    open fun setRect(left: Number, top: Number, width: Number, height: Number): Unit = definedExternally
    /**
     *   Setter method for DrawRect.rounding
     * 
     *  @param {Float} new rounding value. Should be between zero (a rectangle) and 1 (shorter  edge is a semicircle)
     */
    open fun setRounding(rounding: Number): Unit = definedExternally
    companion object {
        /**
         *  Creates a new DrawRect
         * 
         *  @param typeCheckedProperties {Partial<DrawRect>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DrawRect} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DrawRect = definedExternally
    }
}