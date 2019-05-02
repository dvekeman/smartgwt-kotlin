@file:JsQualifier("isc")
package isc

/**
 *  DrawItem subclass to render polygons
 */
open external class DrawPolygon : DrawPath {
    /**
     *  DrawPolygon only supports the
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
     *  @default false
     */
    override var showTitleLabelBackground: Boolean = definedExternally
    /**
     *  Array of points of the polygon, specified in the DrawPane.
     *  @type {Array<Partial<Point>>}
     *  @default "[[0,0], [50,50], [100,0]]"
     */
    override var points: Array<dynamic> = definedExternally
    /**
     *  Style of drawing the corners of the polygon.
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
    companion object {
        /**
         *  Creates a new DrawPolygon
         * 
         *  @param typeCheckedProperties {Partial<DrawPolygon>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DrawPolygon} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DrawPolygon = definedExternally
    }
}