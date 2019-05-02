@file:JsQualifier("isc")
package isc

/**
 *  DrawItem subclass to render diamond shapes
 */
open external class DrawDiamond : DrawItem {
    /**
     *  Left coordinate of the diamond. This is the X coordinate of the western point of the
     *   diamond.
     *  @type {Coordinate}
     *  @default "0"
     */
    open var left: Number = definedExternally
    /**
     *  Top coordinate of the diamond. This is the Y coordinate of the northern point of the
     *   diamond.
     *  @type {Coordinate}
     *  @default "0"
     */
    open var top: Number = definedExternally
    /**
     *  Width of the diamond. Must be non-negative.
     *  @type {Distance}
     *  @default "100"
     */
    open var width: dynamic = definedExternally
    /**
     *  Height of the diamond. Must be non-negative.
     *  @type {Distance}
     *  @default "100"
     */
    open var height: dynamic = definedExternally
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
     *   Move and resize the drawDiamond to match the specified coordinates and size.
     * 
     *  @param {Integer} new left coordinate
     *  @param {Integer} new top coordinate
     *  @param {Integer} new width
     *  @param {Integer} new height
     */
    open fun setRect(left: Number, top: Number, width: Number, height: Number): Unit = definedExternally
    companion object {
        /**
         *  Creates a new DrawDiamond
         * 
         *  @param typeCheckedProperties {Partial<DrawDiamond>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DrawDiamond} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DrawDiamond = definedExternally
    }
}