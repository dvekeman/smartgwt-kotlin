@file:JsQualifier("isc")
package isc

/**
 *  DrawItem subclass to render triangles
 */
open external class DrawTriangle : DrawPolygon {
    /**
     *  Array of points of the triangle. specified in the
     *   DrawPane.
     *  @type {Array<Partial<Point>>}
     *  @default "[[0,0], [50,50], [100,0]]"
     */
    override var points: Array<dynamic> = definedExternally
    /**
     *   Returns the incenter
     *   of the triangle in DrawPane.
     * 
     */
    override fun getCenter(): Point = definedExternally
    /**
     *   Resize by the specified delta
     * 
     *  @param {Distance} number of pixels to resize by horizontally
     *  @param {Distance} number of pixels to resize by vertically
     */
    override fun resizeBy(dX: dynamic, dY: dynamic): Unit = definedExternally
    companion object {
        /**
         *  Creates a new DrawTriangle
         * 
         *  @param typeCheckedProperties {Partial<DrawTriangle>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DrawTriangle} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DrawTriangle = definedExternally
    }
}