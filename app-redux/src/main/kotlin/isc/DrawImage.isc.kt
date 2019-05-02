@file:JsQualifier("isc")
package isc

/**
 *  DrawItem subclass to render embedded images.
 */
open external class DrawImage : DrawItem {
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
     *  @default "16"
     */
    open var width: dynamic = definedExternally
    /**
     *  Height in pixels relative to the DrawPane.
     *  @type {Distance}
     *  @default "16"
     */
    open var height: dynamic = definedExternally
    /**
     *  Title (tooltip hover text) for this image.
     *  @type {string}
     *  @default null
     */
    override var title: String = definedExternally
    /**
     *  URL to the image file.
     *  @type {URL}
     *  @default "blank.png"
     */
    open var src: String = definedExternally
    /**
     *  Configures whether a Matrix filter is used to render this DrawImage in Internet
     *   Explorer 6-8.
     * 
     *   With the default of null, matrix filters may be used unless
     *   Canvas.neverUseFilters has been set. When set explicitly to
     *   true, matrix filters may be used even if neverUseFilters is
     *   true.
     * 
     *   This setting exists due to platform limitations in Internet Explorer where it is
     *   impossible to implement shearing transforms on an image without a matrix filter. Shear
     *   can arise by:
     * 
     * 
     *  - specifying a nonzero DrawItem.xShearFactor or
     *   DrawItem.yShearFactor,
     * 
     *  - specifying a nonuniform DrawItem.scale (where the scale values along
     *   the x- and y-dimensions are not equal) and a nonzero DrawItem.rotation,
     *   or
     * 
     *  - using "resize"
     * 
     *   DrawItem.knobs on a rotated DrawImage.
     * 
     *   When prohibited from using a matrix filter, DrawImage will ignore the shearing
     *   components of its local transform. If any of the above conditions are met then the
     *   DrawImage might not be drawn correctly. Setting useMatrixFilter to
     *   true avoids this possibility but it also suffers from a range of
     *   side-effects mentioned IEFilters.
     *  @type {boolean}
     *  @default null
     */
    open var useMatrixFilter: Boolean = definedExternally
    /**
     *   Returns the top, left, top+width, left+height
     * 
     * 
     */
    override fun getBoundingBox(): Array<dynamic> = definedExternally
    /**
     *   Get the center point of the image.
     * 
     */
    override fun getCenter(): Point = definedExternally
    /**
     *   Change the URL of the image displayed.
     * 
     *  @param {URL} new URL
     */
    open fun setSrc(src: String): Unit = definedExternally
    /**
     *   Set the left coordinate of the drawImage.
     * 
     *  @param {Coordinate} new left coordinate
     */
    open fun setLeft(left: Number): Unit = definedExternally
    /**
     *   Set the top coordinate of the drawImage.
     * 
     *  @param {Coordinate} new top coordinate
     */
    open fun setTop(top: Number): Unit = definedExternally
    /**
     *   Set the width of the drawImage.
     * 
     *  @param {Distance} new width
     */
    open fun setWidth(width: dynamic): Unit = definedExternally
    /**
     *   Set the height of the drawImage.
     * 
     *  @param {Distance} new height
     */
    open fun setHeight(height: dynamic): Unit = definedExternally
    /**
     *   Updates the drawImage to match the specified coordinates and size in
     *   DrawPane.
     * 
     *  @param {Integer} new left coordinate
     *  @param {Integer} new top coordinate
     *  @param {Integer} new width
     *  @param {Integer} new height
     */
    open fun setRect(left: Number, top: Number, width: Number, height: Number): Unit = definedExternally
    /**
     *   Move the drawImage by the specified delta
     * 
     *  @param {Distance} number of pixels to move horizontally
     *  @param {Distance} number of pixels to move vertically
     */
    override fun moveBy(dX: dynamic, dY: dynamic): Unit = definedExternally
    /**
     *   Move the drawImage to the specified position
     * 
     *  @param {Integer} new left coordinate
     *  @param {Integer} new top coordinate
     */
    override fun moveTo(left: Number, top: Number): Unit = definedExternally
    companion object {
        /**
         *  Creates a new DrawImage
         * 
         *  @param typeCheckedProperties {Partial<DrawImage>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DrawImage} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DrawImage = definedExternally
    }
}