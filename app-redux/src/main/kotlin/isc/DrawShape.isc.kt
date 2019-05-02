@file:JsQualifier("isc")
package isc

/**
 *  DrawItem to render a shape defined by executing the series of drawing commands in the
 *   DrawShape.commands array.
 */
open external class DrawShape : DrawItem {
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
     *  The drawing commands that will be executed to render the shape.
     *  @type {Array<Partial<DrawShapeCommand>>}
     *  @default null
     */
    open var commands: Array<dynamic> = definedExternally
    /**
     *   Sets the DrawShape.commands that define this shape.
     * 
     *  @param {Array<Partial<DrawShapeCommand>>} the new commands.
     */
    open fun setCommands(commands: Array<dynamic>): Unit = definedExternally
    /**
     *   Move the drawShape by the specified delta
     * 
     *  @param {Distance} number of pixels to move horizontally
     *  @param {Distance} number of pixels to move vertically
     */
    override fun moveBy(dX: dynamic, dY: dynamic): Unit = definedExternally
    /**
     *   Resize by the specified delta
     * 
     *  @param {Distance} number of pixels to resize by horizontally
     *  @param {Distance} number of pixels to resize by vertically
     */
    override fun resizeBy(dX: dynamic, dY: dynamic): Unit = definedExternally
    companion object {
        /**
         *  Creates a new DrawShape
         * 
         *  @param typeCheckedProperties {Partial<DrawShape>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DrawShape} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DrawShape = definedExternally
    }
}