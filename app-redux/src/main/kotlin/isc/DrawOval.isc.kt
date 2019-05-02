@file:JsQualifier("isc")
package isc

/**
 *  DrawItem subclass to render oval shapes, including circles.
 */
open external class DrawOval : DrawItem {
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
     *  Center point of the oval. If unset, derived from left/top/width/height.
     *  @type {Point}
     *  @default null
     */
    open var centerPoint: Point = definedExternally
    /**
     *  Radius of the oval. Since this is used to initialize the DrawOval.getRadiusX
     *   and DrawOval.getRadiusY radii, then the oval is a circle.
     * 
     *   If unset, the horizontal and vertical radii are set to half the DrawOval.width
     *   and DrawOval.height.
     *  @type {Distance}
     *  @default null
     */
    open var radius: dynamic = definedExternally
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
     *   Returns the top, left, top+height, left+width
     * 
     */
    override fun getBoundingBox(): Array<dynamic> = definedExternally
    /**
     *   Change the center point for this oval.
     * 
     *  @param {Coordinate} left coordinate (in the global coordinate system)
     *  @param {Coordinate} top coordinate (in the global coordinate system)
     */
    override fun setCenterPoint(left: Number, top: Number): Unit = definedExternally
    /**
     *   Move the drawOval by the specified delta
     * 
     *  @param {Distance} number of pixels to move horizontally
     *  @param {Distance} number of pixels to move vertically
     */
    override fun moveBy(dX: dynamic, dY: dynamic): Unit = definedExternally
    /**
     *   Move the drawOval to the specified left/top position. You may also call
     *   DrawOval.setCenterPoint to reposition the oval around a new center position.
     * 
     *  @param {Integer} new left coordinate
     *  @param {Integer} new top coordinate
     */
    override fun moveTo(left: Number, top: Number): Unit = definedExternally
    /**
     *   Set the left coordinate of the drawOval
     * 
     *  @param {Coordinate} new left coordinate
     */
    open fun setLeft(left: Number): Unit = definedExternally
    /**
     *   Set the top coordinate of the drawOval
     * 
     *  @param {Coordinate} new top coordinate
     */
    open fun setTop(top: Number): Unit = definedExternally
    /**
     *   Resize by the specified delta. Note that the resize will occur from the current top/left
     *   coordinates, meaning the center positon of the oval may change. You may also use
     *   DrawOval.setRadii to change the radius in either direction without modifying the
     *   centerpoint.
     * 
     *  @param {Distance} number of pixels to resize by horizontally
     *  @param {Distance} number of pixels to resize by vertically
     */
    override fun resizeBy(dX: dynamic, dY: dynamic): Unit = definedExternally
    /**
     *   Resize to the specified size. Note that the resize will occur from the current top/left
     *   coordinates, meaning the center positon of the oval may change. You may also use
     *   DrawOval.setRadii to change the radius in either direction without modifying the
     *   centerpoint.
     * 
     *  @param {Integer} new width
     *  @param {Integer} new height
     */
    override fun resizeTo(width: Number, height: Number): Unit = definedExternally
    /**
     *   Set the width of the drawOval
     * 
     *  @param {Distance} new width
     */
    open fun setWidth(width: dynamic): Unit = definedExternally
    /**
     *   Set the height of the drawOval
     * 
     *  @param {Distance} new height
     */
    open fun setHeight(height: dynamic): Unit = definedExternally
    /**
     *   Move and resize the drawOval to match the specified coordinates and size.
     * 
     *  @param {Integer} new left coordinate
     *  @param {Integer} new top coordinate
     *  @param {Integer} new width
     *  @param {Integer} new height
     */
    open fun setRect(left: Number, top: Number, width: Number, height: Number): Unit = definedExternally
    /**
     *   Returns the horizontal radius of the DrawOval.
     * 
     */
    open fun getRadiusX(): dynamic = definedExternally
    /**
     *   Returns the vertical radius of the DrawOval.
     * 
     */
    open fun getRadiusY(): dynamic = definedExternally
    /**
     *   Resize the drawOval by setting its horizontal and vertical radius, and retaining its current
     *   center point.
     * 
     *  @param {Distance} new horizontal radius
     *  @param {Distance} new vertical radius
     */
    open fun setRadii(rx: dynamic, ry: dynamic): Unit = definedExternally
    /**
     *   Resize the drawOval by setting its radius, and retaining its current center point.
     *   Equivalent to setRadii(radius, radius).
     * 
     *  @param {Distance} new radius. This will be applied on both axes, meaning calling this method will always result in the DrawOval being a circle.
     */
    open fun setRadius(radius: dynamic): Unit = definedExternally
    /**
     *   Resize and reposition the drawOval by setting its radius, and centerPoint.
     * 
     *  @param {Coordinate} new horizontal center point coordinate
     *  @param {Coordinate} new vertical center point coordinate
     *  @param {Distance} new horizontal radius
     *  @param {Distance} new vertical radius
     */
    open fun setOval(cx: Number, cy: Number, rx: dynamic, ry: dynamic): Unit = definedExternally
    /**
     *   Get the center of the oval.
     * 
     */
    override fun getCenter(): Point = definedExternally
    companion object {
        /**
         *  Creates a new DrawOval
         * 
         *  @param typeCheckedProperties {Partial<DrawOval>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DrawOval} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DrawOval = definedExternally
    }
}