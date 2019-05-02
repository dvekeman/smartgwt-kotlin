@file:JsQualifier("isc")
package isc

/**
 *  A DrawPane is a container for drawing bitmap and vector graphics using browser's built-in
 *   freeform drawing capabilities. These include the HTML5 &lt;canvas&gt; tag and
 *   SVG (Scalable Vector Graphics) where available, and the VML (Vector Markup
 *   Language) for legacy browsers (Internet Explorer 8 and earlier).
 * 
 *   To draw in a DrawPane you create DrawLines, DrawOvals,
 *   DrawPaths and other DrawItem-based components, and place them in the
 *   DrawPane via DrawPane.drawItems or add them incrementally via
 *   DrawPane.addDrawItem.
 * 
 *   DrawItems support a variety of common features, such as
 *   Gradient, DrawItem.startArrow, events such as
 *   DrawItem.click and built-in DrawItem.knobs for end user
 *   resizing and manipulation of shapes.
 * 
 *   Common shapes such as DrawRect, DrawOval and
 *   DrawTriangle have dedicated DrawItem subclasses. For other shapes,
 *   consider:
 * 
 * 
 *  - DrawPath - a multi-segment line with straight segments, defined by a series
 *     of DrawPath.points
 * 
 *  - DrawPolygon - a closed shape with straight sides, defined by a series of
 *     DrawPolygon.points
 * 
 *  - DrawShape - a multi-segment line or closed shape whose sides can be defined by a
 *     series of commands, including curved arcs
 * 
 * 
 * 
 * 
 *   Note on Coordinate Systems
 *   There are three different coordinate systems involved when a DrawItem is drawn onto a DrawPane:
 * 
 * 
 *  - The "local coordinate system" for a DrawItem refers to the Cartesian coordinate system
 *     in which dimensional and positional values are interpreted. For example, when a
 *     DrawRect is configured with left:20, top:30, width:200, and height:100, the
 *     DrawRect represents a rectangle from (20, 30) to (220, 130) in its local coordinate
 *     system. For this same DrawRect, DrawRect.top is going to be 30 even if
 *     the shape is scaled by 3x, such that the (transformed) top coordinate in the drawing
 *     coordinate system actually lies outside the visible region of the DrawPane. Similarly,
 *     no matter what rotation is applied, DrawRect.top will continue to be 30.
 * 
 *     Use DrawItem.getBoundingBox to obtain the bounding box of the item in local
 *     coordinates. Subclass properties also typically provide data in the local coordinate
 *     system, such as DrawRect.left, DrawRect.top, DrawRect.width,
 *     DrawRect.height, DrawPath.points, and DrawTriangle.points.
 * 
 *     There is a local coordinate system for each DrawItem.
 * 
 *  - The "drawing coordinate system" refers to the Cartesian coordinate system shared by
 *     all DrawItems after their local transforms, such as DrawItem.scale or
 *     DrawItem.rotation, have been applied.
 * 
 *     Since DrawGroups pass through applied transforms to the underlying items,
 *     DrawGroup properties such as DrawGroup.left, DrawGroup.top,
 *     DrawGroup.width, and DrawGroup.height, represent coordinates in the drawing
 *     coordinate system, as does therefore DrawGroup.getBoundingBox. The APIs
 *     DrawPane.getDrawingPoint, DrawPane.getDrawingX, and
 *     DrawPane.getDrawingY, also return drawing coordinates.
 * 
 *     For DrawItems with no local transforms, the drawing coordinate system is identical to
 *     the local coordinate system.
 * 
 *  - The "global coordinate system" refers to the drawing coordinate system with global
 *     DrawPane transforms DrawPane.translate, DrawPane.zoomLevel and
 *     DrawPane.rotation applied.
 * 
 *     Use DrawItem.getResizeBoundingBox to obtain the bounding box of a
 *     DrawItem in global coordinates. The APIs DrawItem.getPageLeft and
 *     DrawItem.getPageTop reflect global coordinates rounded to the nearest pixel and
 *     offset by the page-relative coordinates of the DrawPane's top left corner.
 *     (See for example Canvas.getPageLeft and Canvas.getPageTop.)
 * 
 *     With the default global transforms, the global coordinate system is identical to the
 *     drawing coordinate system.
 * 
 * 
 *   The view port of the DrawPane is the rectangle in the global coordinate system from (0, 0)
 *   that is as wide as the DrawPane's Canvas.getInnerContentWidth
 *   and as high as the DrawPane's Canvas.getInnerContentHeight.
 *   Note: In the case of a FacetChart showing a FacetChart.canZoom,
 *   the view port height is decreased by the height of the zoom chart.
 * 
 *   One other coordinate system in use by a DrawPane when DrawPane.canDragScroll
 *   is enabled is the "viewbox coordinate system". The viewbox coordinate system is the drawing
 *   coordinate system with the DrawPane.translate and DrawPane.zoomLevel transforms
 *   applied.
 */
open external class DrawPane : Canvas {
    /**
     *  Which type of drawing back-end should be used by this DrawPane? A default drawing
     *   back-end is automatically selected based on the browser.
     * 
     *   The drawingType can only be set to a drawing back-end type that is supported
     *   by the browser. It is provided for cases where the browser supports more than one drawing
     *   back-end. See the DrawingType documentation for the supported drawing back-ends
     *   and the list of browsers that support each type of drawing back-end.
     *  @type {DrawingType}
     *  @default "based on browser"
     */
    open var drawingType: 
                          /**
                           *  Use Scalable Vector Graphics (SVG). SVG is a W3C standard supported by IE9+, Chrome, Firefox 4+, Safari, and Opera.
                           *  Use an HTML5 &lt;canvas&gt; element. "bitmap" drawing is supported by IE9+, Chrome, Firefox, Safari, and Opera.
                           *  Use Vector Markup Language (VML). VML is a deprecated vector graphics technology supported only by Internet Explorer 6 through 9. In IE 6, 7, and 8, "vml" drawing is the only
                           *   supported drawing back-end.
                           */
                          String /* svg |  bitmap |  vml */ = definedExternally
    /**
     *  When DrawPane.canDragScroll is enabled, this is the width of the area
     *   in viewbox coordinates that can be accessed through drag-scrolling.
     *  @type {Integer}
     *  @default "1000"
     */
    open var drawingWidth: Number = definedExternally
    /**
     *  When DrawPane.canDragScroll is enabled, this is the height of the area
     *   in viewbox coordinates that can be accessed through drag-scrolling.
     *  @type {Integer}
     *  @default "1000"
     */
    open var drawingHeight: Number = definedExternally
    /**
     *  Can the user drag-scroll the DrawPane?
     *  @type {boolean}
     *  @default false
     */
    override var canDragScroll: Boolean = definedExternally
    /**
     *  Rotation in degrees for the DrawPane as a whole about the center of the
     *   DrawPane. The positive direction corresponds to clockwise rotation (for example,
     *   45 is rotation clockwise by 45 degrees and -10 is rotation counterclockwise by 10 degrees).
     *  @type {Float}
     *  @default "0"
     */
    open var rotation: Number = definedExternally
    /**
     *  Zoom for the DrawPane as a whole, where 1 is normal size.
     *  @type {Float}
     *  @default "1"
     */
    open var zoomLevel: Number = definedExternally
    /**
     *  Global translation. This array has two numbers. The first number is the X translation amount
     *   in pixels and the second number is the Y translation amount in pixels.
     *  @type {Array<Partial<Integer>>}
     *  @default null
     */
    open var translate: Array<dynamic> = definedExternally
    /**
     *  Array of gradients that can be referenced by DrawItems placed on this DrawPane.
     *   Each gradient must have an ID assigned to be used for reference.
     *  @type {Array<Partial<Gradient>>}
     *  @default null
     */
    open var gradients: Array<dynamic> = definedExternally
    /**
     *  Array of DrawItems to initially display in this DrawPane.
     *  @type {Array<Partial<DrawItem>>}
     *  @default null
     */
    open var drawItems: Array<dynamic> = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "DrawPaneEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
    /**
     *   Returns the X coordinate in the DrawPane of the last event.
     *   Note: If you need both the X and Y coordinates in the drawing coordinate system of the last event,
     *   it is more efficient to call DrawPane.getDrawingPoint instead.
     * 
     *   See the documentation of DrawPane.getDrawingPoint for a clarifying
     *   example.
     * 
     */
    open fun getDrawingX(): Number = definedExternally
    /**
     *   Returns the Y coordinate in the DrawPane of the last event.
     *   Note: If you need both the X and Y coordinates in the drawing coordinate system of the last event,
     *   it is more efficient to call DrawPane.getDrawingPoint instead.
     * 
     *   See the documentation of DrawPane.getDrawingPoint for a clarifying
     *   example.
     * 
     */
    open fun getDrawingY(): Number = definedExternally
    /**
     *   Returns the point of the last event in the DrawPane.
     * 
     *   To give a concrete example, suppose that this DrawPane has DrawPane.zoomLevel
     *   2 and drag-panning is not enabled (just to simplify this example). If Canvas.getOffsetX
     *   and Canvas.getOffsetY is (0, 0) (i.e. the mouse pointer is located at
     *   the top left point of this DrawPane), then getDrawingPoint() would return
     *   (0, 0). If getOffsetX/Y() is (20, 40), then getDrawingPoint() would return (10, 20) because
     *   when the 2&times; zoom level is applied, (10, 20) is translated to (20, 40) on the screen. You
     *   could, for example, create a new DrawLine with DrawLine.startPoint
     *   (10, 20) and when this line is drawn on screen, the position of the line's start point would
     *   be at offset (20, 40) on screen.
     * 
     */
    open fun getDrawingPoint(): Point = definedExternally
    /**
     *   Call DrawItem.erase on all DrawItems currently associated with the DrawPane.
     * 
     *   The DrawItems will continue to exist, and you can call draw() on them to make them appear again, or
     *   DrawItem.destroy to get rid of them permanetly. Use DrawPane.destroyItems to permanently
     *   get rid of all DrawItems.
     * 
     * 
     */
    open fun erase(): Unit = definedExternally
    /**
     *   Permanently DrawItem.destroy all DrawItems currently associated with this DrawPane,
     *   leaving the DrawPane itself intact
     * 
     */
    open fun destroyItems(): Unit = definedExternally
    /**
     *   Adds a draw item to this DrawPane. If already added to a DrawPane,
     *   the draw item is removed from its current DrawPane and added to this DrawPane.
     * 
     *   NOTE: For performance reasons, this DrawPane may draw the new item on a
     *   delay to allow multiple items to be added and drawn at one time. The DrawPane.refreshNow
     *   API will force the item to be drawn immediately.
     * 
     *  @param {DrawItem} item to add.
     *  @param {boolean} If explicitly set to false, and this drawPane is drawn, don't draw  the newly added item
     */
    open fun addDrawItem(item: DrawItem, autoDraw: Boolean): Unit = definedExternally
    /**
     *   Get a "data:" URL encoding the current contents of the DrawPane.
     * 
     *   The returned "data:" URLs can be used anywhere a URL to an image is valid, for example,
     *   Img.src.
     * 
     *   This method will directly return the data URL on modern browsers when using &lt;canvas&gt;-style
     *   rendering (the default), and if there are no DrawImages in this DrawPane
     *   that load cross-domain images.
     * 
     *   On legacy browers (any version of IE in "quirks" mode, all versions of IE prior to 9.0),
     *   or if there is a DrawImage that loads a cross-domain image, data
     *   URL generation requires a server trip and requires the SmartClient Server to be installed with
     *   the same set of javaModuleDependencies as are required for PDF
     *   export of charts in legacy IE. The method will return null and a callback must be passed,
     *   which fires when the data URL has been retrieved from the server.
     * 
     *   If the callback is passed but no server trip is required, the callback is fired immediately.
     * 
     *   For obtaining PNG or other image data for use in server-side processing (such as attaching to
     *   automated emails or saving to a database), see also the server-side APIs in
     *   com.isomorphic.contentexport.ImageExport.
     * 
     *   Note: It is recommended to pass a callback instead of relying on the method returning the
     *   data URL directly. This is because the callback will always be called with the generated
     *   data URL, whereas work-arounds for browser bugs may require asynchronous generation of the
     *   data URL, meaning that a data URL might not be returned immediately in certain browsers for
     *   certain DrawPane contents.
     * 
     * 
     *  @param {DataURLCallback=} callback to fire when the data URL is available. The callback is called regardless of whether the data URL is also returned.
     *  @param {DataURLFormat=} the format of the data URL. If not specified, then "all"  is assumed.
     */
    open fun getDataURL(callback: ((dataURL: String) -> Unit?), format: 
                                                                        /**
                                                                         *  Any MIME type supported by the browser is acceptable. Note: The exact MIME type used may depend on the browser, and may change from version to version of SmartClient.
                                                                         *  Generate an image/png data URL.
                                                                         */
                                                                        String /* any |  png */?): String = definedExternally
    /**
     *   Converts this DrawPane to the source of an &lt;svg&gt; element equivalent to the
     *   current drawing.
     * 
     *   In Pro edition and above, the returned string can be used with
     *   RPCManager.exportImage to download an image, or with server-side APIs in
     *   com.isomorphic.contentexport.ImageExport to obtain various kinds of images for further
     *   server-side processing.
     * 
     * 
     */
    open fun getSvgString(): String = definedExternally
    /**
     *   Retrieves printable HTML for this component and all printable subcomponents.
     * 
     *   By default any Canvas with children will simply collect the printable HTML of its
     *   children by calling getPrintHTML() on each child that is considered
     *   Canvas.shouldPrint.
     * 
     *   If overriding this method for a custom component, you should either return a String of
     *   printable HTML string directly or return null, and fire the callback (if provided)
     *   using Class.fireCallback.
     * 
     *   To return an empty print representation, return an empty string ("") rather than null.
     * 
     *   The printProperties argument, if passed, must be passed to any subcomponents on
     *   which getPrintHTML() is called.
     * 
     *   Notes on printing
     * 
     *   To print a DrawPane for export on IE8 and earlier, it is important to pass
     *   PrintProperties with PrintProperties.printForExport:true:
     * 
     *   var exportHTML = drawPane.getPrintHTML({ printForExport:true });
     * 
     * 
     *  @param {PrintProperties=} properties to configure printing behavior - may be null.
     *  @param {Callback=} optional callback. This is required to handle cases where HTML         generation is asynchronous - if a method generates HTML asynchronously, it should return          null, and fire the specified callback on completion of HTML generation. The          first parameter HTML should contain the generated print HTML.          The callback is only called if null is returned. Furthermore, the default          getPrintHTML() implementation always returns null and fires the callback          when a callback is provided.
     */
    override fun getPrintHTML(printProperties: PrintProperties?, callback: dynamic?): String = definedExternally
    /**
     *   Immediately draws or redraws any items of this DrawPane that are scheduled to be
     *   drawn or redrawn after a delay.
     * 
     *   For performance reasons, this DrawPane may delay refreshing its display to
     *   allow for multiple draw item updates to be drawn at the same time. If this is occurring,
     *   refreshNow() will immediately refresh the display instead of refreshing the display in a timer.
     * 
     */
    open fun refreshNow(): Unit = definedExternally
    /**
     *   Returns the DrawPane's underlying HTML5 &lt;canvas&gt; element. Will only return a valid
     *   element if the DrawingType is "bitmap".
     * 
     *   To create a DrawItem drawn by custom HTML5 &lt;canvas&gt; drawing code, you should:
     * 
     *  - Subclass the DrawRect class, setting DrawItem.lineOpacity to 0, and
     *   DrawItem.eventOpaque to true.
     * 
     *  - Define your HTML5 &lt;canvas&gt; drawing routine as DrawItem.drawStart or
     *   DrawItem.drawEnd.
     * 
     *  - Limit your drawing to the DrawItem's
     *   DrawItem.getResizeBoundingBox.
     * 
     * 
     */
    open fun getBitmap(): DOMElement = definedExternally
    /**
     *   Called when we start drawing to the underlying HTML5 &lt;canvas&gt; element of a DrawPane,
     *   right after the element is cleared. Only called if the DrawingType is
     *   "bitmap".
     * 
     *   There is no default implementation of this method.
     * 
     */
    open fun drawStart(): Unit = definedExternally
    /**
     *   Called after we finish drawing to the underlying HTML5 &lt;canvas&gt; element of a DrawPane,
     *   after the last DrawItem has been drawn. Only called if the DrawingType is
     *   "bitmap".
     * 
     *   There is no default implementation of this method.
     * 
     */
    open fun drawEnd(): Unit = definedExternally
    /**
     *   Sets the zoom on this DrawPane to the specified magnification, maintaining the
     *   current viewport position.
     * 
     * 
     *  @param {Float} Desired zoom level as a float where 1.0 is equivalent to 100% magnification. Must be greater than 0.
     */
    open fun setZoomLevel(zoomLevel: Number): Unit = definedExternally
    /**
     *   Synonym of DrawPane.setZoomLevel.
     * 
     *  @param {Float} Desired zoom level as a float where 1.0 is equivalent to 100% magnification. Must be greater than 0.
     */
    open fun zoom(zoomLevel: Number): Unit = definedExternally
    /**
     *   Sets the DrawPane.rotation of the DrawPane.
     * 
     * 
     *  @param {Float} the new rotation in degrees. The positive direction corresponds to clockwise rotation.
     */
    open fun setRotation(degrees: Number): Unit = definedExternally
    /**
     *   Synonym of DrawPane.setRotation.
     * 
     *  @param {Float} the new rotation in degrees. The positive direction corresponds to clockwise rotation.
     */
    open fun rotate(degrees: Number): Unit = definedExternally
    /**
     *   Add a new gradient to the drawPane shared gradient list (DrawPane.gradients). If the
     *   gradient does not have an ID a new one will be assigned.
     * 
     * 
     *  @param {Gradient} gradient to add
     */
    open fun addGradient(gradient: Gradient): String = definedExternally
    /**
     *   Returns gradient for gradientID.
     * 
     * 
     *  @param {Identifier} ID of gradient to retrieve
     */
    open fun getGradient(gradientID: String): Gradient = definedExternally
    /**
     *   Removes gradient for gradientID.
     * 
     * 
     *  @param {Identifier} ID of gradient to remove
     */
    open fun removeGradient(gradientID: String): Unit = definedExternally
    /**
     *   Creates a simple linear gradient which can be used by any DrawItem of this DrawPane.
     *   Any DrawItem's DrawItem.fillGradient can reference the gradient by the
     *   given ID.
     * 
     * 
     *  @param {Identifier} the ID of the simple linear gradient
     *  @param {SimpleGradient} the simple linear gradient
     *  @deprecated \* in favor of DrawPane.addGradient
     */
    open fun createSimpleGradient(id: String, simple: SimpleGradient): String = definedExternally
    /**
     *   Creates a linear gradient which can be used by any DrawItem of this DrawPane.
     *   Any DrawItem's DrawItem.fillGradient can reference the gradient by the
     *   given ID.
     * 
     * 
     *  @param {Identifier} the ID of the linear gradient
     *  @param {LinearGradient} the linear gradient
     *  @deprecated \* in favor of DrawPane.addGradient
     */
    open fun createLinearGradient(id: String, linearGradient: LinearGradient): String = definedExternally
    /**
     *   Creates a radial gradient which can be used by any DrawItem of this DrawPane.
     *   Any DrawItem's DrawItem.fillGradient can reference the gradient by the
     *   given ID.
     * 
     * 
     *  @param {Identifier} the ID of the radial gradient
     *  @param {RadialGradient} the radial gradient
     *  @deprecated \* in favor of DrawPane.addGradient
     */
    open fun createRadialGradient(id: String, radialGradient: RadialGradient): String = definedExternally
    companion object {
        /**
         *  Creates a new DrawPane
         * 
         *  @param typeCheckedProperties {Partial<DrawPane>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DrawPane} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DrawPane = definedExternally
        /**
         *   Computes the top-, left-, bottom-, and right-most coordinates in a list
         *   of points, then translates and scales all points to fit the entire shape
         *   into the given width and height.
         * 
         * 
         *   The example call below scales a set of points into a 100x100 thumbnail:
         * 
         * 
         *    var scaledPoints = DrawPane.scaleAndCenter(100, 100, 50, 50,
         *        [[500, 50], [525, 50], [550, 75], [575, 75],
         *         [600, 75], [600, 125], [575, 125], [550, 125],
         *         [525, 150], [500, 150]]);
         * 
         * 
         * 
         *  @param {Integer} width of target space
         *  @param {Integer} height of target space
         *  @param {Integer} center point x
         *  @param {Integer} center point y
         *  @param {Array<Partial<Point>>} list of points to scale and translate
         */
        fun scaleAndCenter(width: Number, height: Number, xc: Number, yc: Number, points: Array<dynamic>): Unit = definedExternally
        /**
         *   Computes a cubic Be&#769;zier curve polynomial:
         * 
         *   B(t) = (1 - t)3P1 + 3(1 - t)2tCP1 + 3(1 - t)t2CP2 + t3P2
         * 
         * 
         *  @param {Double} starting point coordinate
         *  @param {Double} first control point coordinate
         *  @param {Double} second control point coordinate
         *  @param {Double} end point coordinate
         *  @param {Double} the value of the parameter of the curve, between 0 and 1
         */
        fun bezier(p1: Number, cp1: Number, cp2: Number, p2: Number, t: Number): Number = definedExternally
        /**
         *   Computes the minimum and maximum value of the cubic Be&#769;zier curve polynomial
         *   defined in DrawPane.bezier,
         *   for 0 &le; t &le; 1.
         * 
         *  @param {Double} starting point coordinate
         *  @param {Double} first control point coordinate
         *  @param {Double} second control point coordinate
         *  @param {Double} end point coordinate
         */
        fun bezierExtrema(p1: Number, cp1: Number, cp2: Number, p2: Number): Array<dynamic> = definedExternally
        /**
         *   Calculate the bounding box of the cubic Be&#769;zier curve with endpoints
         *   p1 and p2 and control points cp1 and
         *   cp2.
         * 
         *  @param {Point} start point of the curve
         *  @param {Point} first cubic Be&#769;zier control point
         *  @param {Point} second cubic Be&#769;zier control point
         *  @param {Point} end point of the curve
         */
        fun getBezierBoundingBox(p1: Point, cp1: Point, cp2: Point, p2: Point): Array<dynamic> = definedExternally
        /**
         *   Computes the top-, left-, bottom-, and right-most coordinates containing the
         *   Be&#769;zier curve defined by startPoint, controlPoint1,
         *   controlPoint2, and endPoint, then translates and scales these
         *   four points to fit the entire curve into the given width and height.
         * 
         *  @param {Integer} width of target space
         *  @param {Integer} height of target space
         *  @param {Integer} center point x
         *  @param {Integer} center point y
         *  @param {Point} start point of the curve
         *  @param {Point} end point of the curve
         *  @param {Point} first cubic Be&#769;zier control point
         *  @param {Point} second cubic Be&#769;zier control point
         */
        fun scaleAndCenterBezier(width: Number, height: Number, xc: Number, yc: Number, startPoint: Point, endPoint: Point, controlPoint1: Point, controlPoint2: Point): Unit = definedExternally
        /**
         *   Calls DrawPane.getPolygonPoints with angles spread evenly over the full 360 degrees.
         * 
         *  @param {Integer} the number of vertices the polygon
         *  @param {Integer} width of target space
         *  @param {Integer} height of target space
         *  @param {Integer} center point x
         *  @param {Integer} center point y
         *  @param {Double} the angle (in radians) with respect to the center point of the first vertex of the polygon
         */
        fun getRegularPolygonPoints(n: Number, width: Number, height: Number, xc: Number, yc: Number, startAngle: Number): Array<dynamic> = definedExternally
        /**
         *   Computes an array of Points for a polygon that has an equal distance from its center to
         *   any of its vertices and that fits in the given width and height.
         * 
         *  @param {Integer} width of target space
         *  @param {Integer} height of target space
         *  @param {Integer} center point x
         *  @param {Integer} center point y
         *  @param {Array<Partial<Double>>} the complete list of angles (in radians) with respect to the center point at which the polygon must have vertices
         */
        fun getPolygonPoints(width: Number, height: Number, xc: Number, yc: Number, angles: Array<dynamic>): Array<dynamic> = definedExternally
    }
}