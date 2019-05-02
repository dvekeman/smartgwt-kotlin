@file:JsQualifier("isc")
package isc

/**
 *  EdgedCanvas acts as a decorative, image-based frame around another single Canvas.
 */
open external class EdgedCanvas : Canvas {
    /**
     *  Standard skin directory for edge images (sides and corners).
     *  @type {SCImgURL}
     *  @default "images/edges/"
     */
    override var skinImgDir: String = definedExternally
    /**
     *  Base name of images for edges. Extensions for each corner or edge piece will be added
     *   to this image URL, before the extension. For example, with the default base name of
     *   "edge.gif", the top-left corner image will be "edge_TL.gif".
     * 
     *   The full list of extensions is: "_TL", "_TR", "_BL", "_BR", "_T", "_L", "_B", "_R",
     *   "_center".
     *  @type {SCImgURL}
     *  @default "[SKIN]/rounded/frame/FFFFFF/6.png"
     */
    override var edgeImage: String = definedExternally
    /**
     *  CSS color (WITHOUT "#") for the edges. If specified, will be used as part of image
     *   names. Example: "edge_88FF88_TL.gif".
     *  @type {CSSColor}
     *  @default null
     */
    open var edgeColor: String = definedExternally
    /**
     *  Array of side names ("T", "B", "L", "R") specifying which sides of the decorated
     *   component should show edges. For example:
     *     customEdges : ["T", "B"]
     * 
     *   .. would show edges only on the top and bottom of a component.
     * 
     *   The default of null means edges will be shown on all sides.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    override var customEdges: Array<dynamic> = definedExternally
    /**
     *  Whether to show media in the center section, that is, behind the decorated Canvas.
     *  @type {boolean}
     *  @default false
     */
    open var showCenter: Boolean = definedExternally
    /**
     *  Size in pixels for corners and edges
     *  @type {Integer}
     *  @default "6"
     */
    override var edgeSize: Number = definedExternally
    /**
     *  Height in pixels for left corners and edges. Defaults to edgeSize when unset.
     *  @type {Integer}
     *  @default null
     */
    open var edgeLeft: Number = definedExternally
    /**
     *  Height in pixels for right corners and edges. Defaults to edgeSize when unset.
     *  @type {Integer}
     *  @default null
     */
    open var edgeRight: Number = definedExternally
    /**
     *  Height in pixels for top corners and edges. Defaults to edgeSize when unset.
     *  @type {Integer}
     *  @default null
     */
    open var edgeTop: Number = definedExternally
    /**
     *  Height in pixels for bottom corners and edges. Defaults to edgeSize when unset.
     *  @type {Integer}
     *  @default null
     */
    open var edgeBottom: Number = definedExternally
    /**
     *  Amount the contained Canvas should be offset. Defaults to edgeSize; set to less than
     *   edgeSize to allow the contained Canvas to overlap the edge and corner media.
     *  @type {Integer}
     *  @default null
     */
    override var edgeOffset: Number = definedExternally
    /**
     *  Amount the contained Canvas should be offset from the top. Defaults to the size for
     *   the top edge. Set smaller to allow the contained Canvas to overlap the edge and
     *   corner media.
     *  @type {Integer}
     *  @default null
     */
    open var edgeOffsetTop: Number = definedExternally
    /**
     *  Amount the contained Canvas should be offset from the bottom. Defaults to the size for
     *   the bottom edge. Set smaller to allow the contained Canvas to overlap the edge and
     *   corner media.
     *  @type {Integer}
     *  @default null
     */
    open var edgeOffsetBottom: Number = definedExternally
    /**
     *  Amount the contained Canvas should be offset from the left. Defaults to the size for
     *   the left edge. Set smaller to allow the contained Canvas to overlap the edge and
     *   corner media.
     *  @type {Integer}
     *  @default null
     */
    open var edgeOffsetLeft: Number = definedExternally
    /**
     *  Amount the contained Canvas should be offset from the right. Defaults to the size for
     *   the right edge. Set smaller to allow the contained Canvas to overlap the edge and
     *   corner media.
     *  @type {Integer}
     *  @default null
     */
    open var edgeOffsetRight: Number = definedExternally
    /**
     *  Background color for the center section only. Can be used as a surrogate background
     *   color for the decorated Canvas, if the Canvas is set to partially overlap the edges and
     *   hence can't show a background color itself without occluding media.
     *  @type {CSSColor}
     *  @default null
     */
    open var centerBackgroundColor: String = definedExternally
    /**
     *  Optional property specifying the CSS ClassName to apply to the various parts of this edged canvas
     *   (top, bottom, corners, sides and center). To
     *   apply separate styles for each part, use EdgedCanvas.addEdgeStyleSuffix.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var edgeStyleName: String = definedExternally
    /**
     *  If specified, the EdgedCanvas.edgeStyleName will be treated as a base style name and
     *   appended with following suffixes to support separate styling per cell:
     * 
     *   _TL (top left cell)
     *   _T (top center cell)
     *   _TR (top right cell)
     *   _L (middle left cell)
     *   _C (center cell)
     *   _R (middle right cell)
     *   _BL (bottom left cell)
     *   _B (bottom center cell)
     *   _BR (bottom right cell)
     *  @type {boolean}
     *  @default false
     */
    open var addEdgeStyleSuffix: Boolean = definedExternally
    companion object {
        /**
         *  Creates a new EdgedCanvas
         * 
         *  @param typeCheckedProperties {Partial<EdgedCanvas>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {EdgedCanvas} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): EdgedCanvas = definedExternally
    }
}