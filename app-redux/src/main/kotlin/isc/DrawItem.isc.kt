@file:JsQualifier("isc")
package isc

/**
 *  Base class for graphical elements drawn in a DrawPane. All properties and methods
 *   documented here are available on all DrawItems unless otherwise specified.
 * 
 *   Each DrawItem has its own local transform that maps its
 *   DrawItem to the drawing coordinate system that is shared by
 *   all DrawItems in the same DrawPane (explained DrawPane). The local
 *   transform is a combination of rotation, scaling, and other affine transformations. The
 *   DrawItem is first DrawItem.translate, then DrawItem.scale,
 *   then DrawItem.xShearFactor in the direction of the x-axis, then
 *   DrawItem.yShearFactor in the directiton of the y-axis, and then finally
 *   DrawItem.rotation.
 * 
 *   Note that DrawItems as such should never be created, only concrete subclasses such as
 *   DrawGroup and DrawLine.
 * 
 *   See DrawPane for the different approaches to create DrawItems.
 */
open external class DrawItem : BaseWidget {
    /**
     *  Relative stacking order of this draw item with respect to other items in the same DrawPane
     *   or DrawGroup.
     * 
     *   null means that the zIndex has not been resolved. Upon adding this draw item to a
     *   DrawPane or DrawGroup, this item's zIndex will be resolved to
     *   the next higher auto-assigned zIndex. Note that this may still be less than another item's
     *   zIndex if DrawItem.bringToFront was called on that item.
     * 
     *   If two items within the same DrawPane or DrawGroup have the
     *   same zIndex, then they are stacked in the order in which they were added to the
     *   DrawPane or DrawGroup.
     * 
     *   When the DrawPane's DrawPane.drawingType is
     *   "bitmap",
     * 
     *   zIndex, DrawItem.bringToFront, and DrawItem.sendToBack are not supported
     *   for DrawLabels on iOS due to platform limitations.
     *  @type {Integer}
     *  @default null
     */
    open var zIndex: Number = definedExternally
    /**
     *  If set, specifies the cursor to display when the mouse pointer is over this DrawItem.
     *  @type {Cursor}
     *  @default null
     */
    open var cursor: 
                     /**
                      *  Use the default arrow cursor for this browser/OS.
                      *  Use the default cursor for this element type in this                browser/OS
                      *  Use the wait cursor.
                      *  Use the hand cursor.
                      *  Use the "move" (crosshairs) cursor.
                      *  Use the 'help' cursor.
                      *  Use the 'text' (i-beam) cursor.
                      *  Use the normal hand pointer that appears when you hover                over a link
                      *  Use the 'crosshair' ( + ) cursor.
                      *  Use the column resize cursor (horizontal double-tipped arrow)
                      *  Use the row resize cursor (vertical double-tipped arrow)
                      *  Use the "east resize" cursor.
                      *  Use the "west resize" cursor.
                      *  Use the "north resize" cursor.
                      *  Use the "south resize" cursor.
                      *  Use the "south-east resize" cursor.
                      *  Use the "north-east resize" cursor.
                      *  Use the "north-west resize" cursor.
                      *  Use the "south-west resize" cursor.
                      *  Use the "not-allowed" cursor.
                      */
                     String /* default |  auto |  wait |  hand |  move |  help |  text |  pointer |  arrow |  all-scroll |  crosshair |  col-resize |  row-resize |  e-resize |  w-resize |  n-resize |  s-resize |  se-resize |  ne-resize |  nw-resize |  sw-resize |  not-allowed */ = definedExternally
    /**
     *  Will this DrawItem fire hover events when the user hovers over it?
     *  @type {boolean}
     *  @default null
     */
    open var canHover: Boolean = definedExternally
    /**
     *  If DrawItem.canHover is true, should we show the global hover canvas by default
     *   when the user hovers over this DrawItem?
     *  @type {boolean}
     *  @default true
     */
    open var showHover: Boolean = definedExternally
    /**
     *  If this.canHover is true, how long should the mouse be kept over this
     *   widget before the hover event is fired
     *  @type {number}
     *  @default "300"
     */
    open var hoverDelay: Number = definedExternally
    /**
     *  Default DrawItem.getHoverHTML that is displayed in the global hover canvas if
     *   the user hovers over this DrawItem and DrawItem.showHover is true.
     *  @type {HTMLString}
     *  @default null
     */
    open var prompt: String = definedExternally
    /**
     *  DrawPane this drawItem should draw in.
     * 
     *   If this item has a DrawGroup, the drawGroup's drawPane is automatically used.
     *  @type {DrawPane}
     *  @default null
     */
    open var drawPane: DrawPane = definedExternally
    /**
     *  DrawGroup this drawItem is a member of.
     *  @type {DrawGroup}
     *  @default null
     */
    open var drawGroup: DrawGroup = definedExternally
    /**
     *  Pixel width for lines.
     *  @type {Integer}
     *  @default "3"
     */
    open var lineWidth: Number = definedExternally
    /**
     *  Line color
     *  @type {CSSColor}
     *  @default "#808080"
     */
    open var lineColor: String = definedExternally
    /**
     *  Opacity for lines, as a number between 0 (transparent) and 1 (opaque).
     *  @type {Float}
     *  @default "1.0"
     */
    open var lineOpacity: Number = definedExternally
    /**
     *  Pattern for lines, eg "solid" or "dash".
     * 
     *   Note that support in old browsers, such as Internet Explorer versions before IE11, is
     *   limited for DrawPane.drawingType "bitmap" to items with straight
     *   edges - DrawLines, DrawPaths, and DrawRects with no
     *   DrawRect.rounding.
     *  @type {LinePattern}
     *  @default "solid"
     */
    open var linePattern: 
                          /**
                           *  Solid line
                           *  Dotted line
                           *  Dashed line
                           *  Dotted line, with more tightly spaced dots
                           *  Dashed line, with shorter, more tightly spaced dashes
                           *  Dashed line, with longer, more widely spaced dashes
                           */
                          String /* solid |  dot |  dash |  shortdot |  shortdash |  longdash */ = definedExternally
    /**
     *  Style of drawing the endpoints of a line.
     * 
     *   Note that for dashed and dotted lines, the lineCap style affects each dash or dot.
     *  @type {LineCap}
     *  @default "round"
     */
    open var lineCap: 
                      /**
                       *  Semicircular rounding
                       *  Squared-off endpoint
                       *  Square endpoint, stops exactly at the line's end coordinates instead          of extending 1/2 lineWidth further as "round" and "square" do
                       */
                      String /* round |  square |  butt */ = definedExternally
    /**
     *  Fill color to use for shapes. The default of 'null' is transparent.
     *  @type {CSSColor}
     *  @default null
     */
    open var fillColor: String = definedExternally
    /**
     *  Fill gradient to use for shapes. If a string it uses the gradient identifier parameter provided in
     *   DrawPane.addGradient. Otherwise it expects one of SimpleGradient,
     *   LinearGradient or RadialGradient.
     *  @type {Gradient | string}
     *  @default null
     */
    open var fillGradient: dynamic = definedExternally
    /**
     *  Opacity of the fillColor, as a number between 0 (transparent) and 1 (opaque).
     *  @type {Float}
     *  @default "1.0"
     */
    open var fillOpacity: Number = definedExternally
    /**
     *  Shadow used for all DrawItem subtypes.
     *  @type {Shadow}
     *  @default null
     */
    open var shadow: Shadow = definedExternally
    /**
     *  Rotation in degrees about the DrawItem.getCenter.
     *   The positive direction is clockwise.
     *  @type {Float}
     *  @default "0.0"
     */
    open var rotation: Number = definedExternally
    /**
     *  The slope of an x-shearing transformation applied to this DrawItem. Each point in the
     *   shape is moved along the x-axis a distance that is proportional to the initial
     *   y-coordinate of the point.
     *  @type {Float}
     *  @default "0.0"
     */
    open var xShearFactor: Number = definedExternally
    /**
     *  The slope of a y-shearing transformation applied to this DrawItem. Each point in the
     *   shape is moved along the y-axis a distance that is proportional to the initial
     *   x-coordinate of the point.
     *  @type {Float}
     *  @default "0.0"
     */
    open var yShearFactor: Number = definedExternally
    /**
     *  Array holds 2 values representing scaling along x and y dimensions.
     *  @type {Array<Partial<Float>>}
     *  @default null
     */
    open var scale: Array<dynamic> = definedExternally
    /**
     *  Array holds two values representing translation along the x and y dimensions.
     *  @type {Array<Partial<Float>>}
     *  @default null
     */
    open var translate: Array<dynamic> = definedExternally
    /**
     *  Style of arrow head to draw at the beginning of the line or path.
     *  @type {ArrowStyle}
     *  @default null
     */
    open var startArrow: 
                         /**
                          *  Filled triangle.
                          *  Two lines are drawn on each side of the path.
                          */
                         String /* block |  open */ = definedExternally
    /**
     *  Style of arrow head to draw at the end of the line or path.
     *  @type {ArrowStyle}
     *  @default null
     */
    open var endArrow: 
                       /**
                        *  Filled triangle.
                        *  Two lines are drawn on each side of the path.
                        */
                       String /* block |  open */ = definedExternally
    /**
     *  Array of control knobs to display for this item. Each KnobType specified in this array
     *   will turn on UI element(s) allowing the user to manipulate this drawItem. To update the
     *   set of knobs at runtime use DrawItem.showKnobs and DrawItem.hideKnobs.
     * 
     *   NOTE: Unless otherwise documented, DrawItem types only support
     *   "resize" and "move"
     * 
     *   knobs.
     *  @type {Array<Partial<KnobType>>}
     *  @default null
     */
    open var knobs: Array<dynamic> = definedExternally
    /**
     *  A string to show at the DrawItem.getCenter of this DrawItem.
     * 
     *   When set to a non-null value (including an empty string), the DrawItem.titleLabel
     *   DrawLabel AutoChild will be created automatically and positioned at the center of
     *   this DrawItem.
     *  @type {string}
     *  @default null
     */
    open var title: String = definedExternally
    /**
     *  When a non-null DrawItem.title is set, this AutoChild is created
     *   automatically and positioned at the DrawItem.getCenter of this DrawItem
     *   . The titleLabel moves with this DrawItem and, depending
     *   on TitleRotationMode, can rotate with this DrawItem
     *   as well.
     * 
     *   The following autoChildUsage applies:
     *   DrawItem.title for DrawLabel.contents.
     * 
     *   Related to the titleLabel is the DrawItem.titleLabelBackground which allows a border to be placed around the titleLabel
     *   and/or a background added. By default, shapes that are commonly filled such as
     *   DrawTriangles, with the exception of DrawSectors, do not show the
     *   titleLabelBackground (see DrawItem.showTitleLabelBackground).
     *  @type {DrawLabel}
     *  @default null
     */
    open var titleLabel: DrawLabel = definedExternally
    /**
     *  Whether the DrawItem.titleLabel should be scaled to the maximum possible size that fits
     *   inside the bounds of this item. Currently only DrawRects and DrawPolygons
     *   with 90 degree angles are supported.
     * 
     *   Note that DrawItem.titleAutoFit isn't supported for rotated, sheared, or scaled
     *   DrawItems, and that therefore the value of TitleRotationMode, which relates
     *   to rotation of the item, is ignored when this property is set. However, we do support
     *   having the label automatically rotate to run vertically if there's more space - see
     *   DrawItem.titleAutoFitRotationMode.
     *  @type {boolean}
     *  @default false
     */
    open var titleAutoFit: Boolean = definedExternally
    /**
     *  Whether to rotate the DrawItem.titleLabel 90 degrees clockwise while trying to maximize its
     *   size in accordance with DrawItem.titleAutoFit. If automatic rotation is specified, the
     *   default, the label will be rotated if and only if it allows the label to become larger.
     *  @type {TitleAutoFitRotationMode}
     *  @default "auto"
     */
    open var titleAutoFitRotationMode: 
                                       /**
                                        *  do not rotate
                                        *  rotate only if doing so would allow label to be larger
                                        *  always rotate
                                        */
                                       String /* never |  auto |  always */ = definedExternally
    /**
     *  Specifies margin between label and item edges when using DrawItem.titleAutoFit.
     *  @type {number}
     *  @default "2"
     */
    open var titleAutoFitMargin: Number = definedExternally
    /**
     *  The mode in which the DrawItem.titleLabel (if shown) is rotated with
     *   this draw item.
     *  @type {TitleRotationMode}
     *  @default "neverRotate"
     */
    open var titleRotationMode: 
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
     *  If the DrawItem.titleLabel is showing, should the DrawItem.titleLabelBackground
     *   be created and placed behind the titleLabel?
     * 
     *   This defaults to true for DrawSectors and shapes that are not commonly filled
     *   (e.g. DrawLines).
     *  @type {boolean}
     *  @default false
     */
    open var showTitleLabelBackground: Boolean = definedExternally
    /**
     *  When the DrawItem.titleLabel is showing and DrawItem.showTitleLabelBackground
     *   is true, this DrawRect AutoChild is created and placed behind the
     *   titleLabel.
     *  @type {DrawRect}
     *  @default null
     */
    open var titleLabelBackground: DrawRect = definedExternally
    /**
     *  If the DrawItem.titleLabelBackground is visible, how much padding
     *   should be left between the bounds of the DrawItem.titleLabel and the edges of
     *   the titleLabelBackground?
     *  @type {Integer}
     *  @default "2"
     */
    open var titleLabelPadding: Number = definedExternally
    /**
     *  Constrains drag-resizing and drag-repositioning of this draw item to either the current
     *   visible area of the DrawPane or an arbitrary bounding box (if set to
     *   an array of the form [left, top, left + width, top + height]). When using
     *   a bounding box-type argument the left/top values can be negative, or the width/height
     *   values can be greater than the dimensions of the viewable area, to allow positioning
     *   or resizing the draw item beyond the confines of the draw pane.
     * 
     *   Note: keepInParentRect affects only user drag interactions, not programmatic moves or
     *   resizes.
     *  @type {boolean | Array<Partial<Float>>}
     *  @default null
     */
    open var keepInParentRect: dynamic = definedExternally
    /**
     *  If this DrawItem is showing "resize"
     * 
     *   DrawItem.knobs, should resizing the shape solely update the local
     *   transform (for example, the DrawItem's DrawItem.scale or
     *   DrawItem.translate)?.
     * 
     *   The default is false, which means that the DrawItem is allowed to modify
     *   its shape properties in order to fit within a given width and height. Some examples:
     * 
     * 
     *  - A DrawOval might decrease its DrawOval.radius
     *   when resized to a smaller size.
     * 
     *  - A DrawPath might change its DrawPath.points
     *   to lengthen all line segments in the path by some proportion so that it fits into a
     *   larger size.
     * 
     *   This approach allows a DrawItem to maintain the same
     *   DrawItem.lineWidth even as it is being resized.
     * 
     *   If this property is set to true then all visual aspects of the DrawItem,
     *   including the line width and the fill, will be magnified or reduced during resizes
     *   as if the DrawItem were placed under a lens.
     *  @type {boolean}
     *  @default false
     */
    open var resizeViaLocalTransformOnly: Boolean = definedExternally
    /**
     *  This property specifies the conditions for when proportional resizing is used.
     * 
     *   By default the DrawItem is forced to only resize proportionally while any modifier key
     *   specified in DrawItem.proportionalResizeModifiers is pressed. For example, the
     *   DrawItem will change its width and height by the same percentage as long as the "Shift"
     *   key is held down.
     * 
     *   Note that this property only has an effect if the DrawItem is showing
     *   "resize"
     * 
     *   DrawItem.knobs.
     *  @type {ProportionalResizeMode}
     *  @default "modifier"
     */
    open var proportionalResizing: 
                                   /**
                                    *  proportional resizing is never used
                                    *  proportional resizing is always used
                                    *  proportional resize is off by default, but holding down one of the Canvas.proportionalResizeModifiers turns proportional resize on for a given
                                    *   resize interaction
                                    *  proportional resize is on by default, but holding down one of the Canvas.proportionalResizeModifiers turns proportional resize off for a given
                                    *   resize interaction
                                    */
                                   String /* none |  always |  modifier |  modifierOff */ = definedExternally
    /**
     *  If DrawItem.proportionalResizing is set to "modifier"
     * 
     *   or "modifierOff"
     * 
     *   then proportional resizing of the DrawItem is activated or deactivated, respectively,
     *   whenever at least one key in this set of modifier keys is pressed.
     * 
     *   The keys allowed in this set are: "Alt", "Ctrl", and "Shift". If this set
     *   of keys is empty then proportional resizing is always used if
     *   proportionalResizing is "modifier"
     *   and is never used if
     *   proportionalResizing is "modifierOff"
     *   .
     *  @type {Array<Partial<KeyName>>}
     *  @default "["Shift"]"
     */
    open var proportionalResizeModifiers: Array<dynamic> = definedExternally
    /**
     *  An opaque object specifying the local transformation that should be applied to this
     *   DrawItem, obtained through a call to DrawItem.getShapeData.
     *   Note: if this property is specified, you should avoid also specifying a
     *   DrawItem.translate, DrawItem.scale, DrawItem.xShearFactor, DrawItem.yShearFactor, or DrawItem.rotation.
     *  @type {object}
     *  @default null
     */
    open var shapeData: dynamic = definedExternally
    /**
     *  Number of pixels the cursor needs to move before the EventHandler starts a drag operation.
     *  @type {number}
     *  @default "5"
     */
    open var dragStartDistance: Number = definedExternally
    /**
     *  Is this DrawItem draggable? If true, then the DrawItem can be drag-repositioned by the user.
     *  @type {boolean}
     *  @default false
     */
    open var canDrag: Boolean = definedExternally
    /**
     *  Context menu to show for this object, an instance of the Menu widget.
     * 
     *   Note: if Canvas.destroy is called on a canvas, any specified context menu is
     *   not automatically destroyed as well. This is in contrast to MenuButtons which
     *   automatically destroy their specified MenuButton.menu by default. The behavior
     *   is intentional as context menus are commonly reused across components.
     *  @type {Menu}
     *  @default null
     */
    open var contextMenu: Menu = definedExternally
    /**
     *  Should events inside this DrawItem be attributed to it regardless of which pixels are
     *   actually set, if no fill is specified? If set for DrawItems that aren't closed, will
     *   capture events occurring in the region that would filled if a fill were specified.
     *   This property is true by default for closed shapes, and false for paths, lines, etc.
     * 
     *   Note: this property must be true if you're writing to an HTML5 &lt;canvas&gt; element
     *   directly in your code (only applies to DrawingType "bitmap"
     *   ).
     *  @type {boolean}
     *  @default "varies"
     */
    open var eventOpaque: Boolean = definedExternally
    /**
     *  If this item is showing a
     *   "move"
     * 
     *   DrawItem.knobs, this attribute specifies where the knob should appear
     *   with respect to the draw item.
     * 
     *   The resize and move knobs show at the same position by default. However, when
     *   both knobs are shown the move knob is offset slightly to allow access to both.
     *   This position can be adjusted manually with DrawItem.moveKnobOffset.
     *  @type {MoveKnobPoint}
     *  @default "TL"
     */
    open var moveKnobPoint: 
                            /**
                             *  Top Left corner
                             *  Top Right corner
                             *  Bottom Left corner
                             *  Bottom Right corner
                             */
                            String /* TL |  TR |  BL |  BR */ = definedExternally
    /**
     *  If this item is showing a "move" DrawItem.knobs, this attribute
     *   allows you to specify an offset in pixels from the DrawItem.moveKnobPoint for the
     *   move knob. Offset should be specified as a 2-element array of [left offset, top offset].
     * 
     *   This offset overrides the built-in offset used when showing both resize and move knobs.
     *  @type {Array<Partial<Integer>>}
     *  @default null
     */
    open var moveKnobOffset: Array<dynamic> = definedExternally
    /**
     *  If this item is showing "move"
     * 
     *   DrawItem.knobs, this attribute specifies the AutoChild for the
     *   DrawKnob that allows a user to move the DrawItem with help of a knob located at
     *   DrawItem.moveKnobPoint. Default move knob shape is green circle.
     *  @type {DrawKnob}
     *  @default null
     */
    open var moveKnob: DrawKnob = definedExternally
    /**
     *  If this item is showing "rotate"
     * 
     *   DrawItem.knobs, this attribute specifies the AutoChild for the
     *   DrawKnob that allows a user to rotate the DrawItem with help of a knob located
     *   above. Default rotate knob shape is green circle.
     *  @type {DrawKnob}
     *  @default null
     */
    open var rotateKnob: DrawKnob = definedExternally
    /**
     *  If this item is showing "resize"
     * 
     *   DrawItem.knobs, this attribute
     *   specifies the points with respect to the draw item where resize knobs should appear.
     *  @type {Array<Partial<ResizeKnobPoint>>}
     *  @default "["TL","TR","BL","BR","T","R","B","L"]"
     */
    open var resizeKnobPoints: Array<dynamic> = definedExternally
    /**
     *  If this item is showing "resize"
     * 
     *   DrawItem.knobs, this attribute specifies the MultiAutoChild for the
     *   DrawKnob that allows a user to resize the DrawItem with help of knobs located at
     *   corners of a bounding rectangle of current DrawItem. The default shape is a light teal
     *   circle.
     *  @type {DrawKnob}
     *  @default null
     */
    open var cornerResizeKnob: DrawKnob = definedExternally
    /**
     *  If this item is showing "resize"
     * 
     *   DrawItem.knobs, this attribute specifies the MultiAutoChild for the
     *   DrawKnob that allows a user to resize the DrawItem with help of knobs located at
     *   centers of edges of a bounding rectangle of current DrawItem. The default shape is a light
     *   teal square.
     *  @type {DrawKnob}
     *  @default null
     */
    open var sideResizeKnob: DrawKnob = definedExternally
    /**
     *  If this item is showing "resize"
     * 
     *   DrawItem.knobs, this attribute specifies the AutoChild for the
     *   DrawRect that draws a rectangle frame which connects all resize knobs of current
     *   DrawItem.
     *  @type {DrawRect}
     *  @default null
     */
    open var resizeOutline: DrawRect = definedExternally
    /**
     *  If this item is showing "resize"
     * 
     *   DrawItem.knobs will the resize outline be shown or not.
     *  @type {boolean}
     *  @default true
     */
    open var showResizeOutline: Boolean = definedExternally
    /**
     *  If true, when a DrawItem is DrawItem.moveTo or DrawItem.resizeTo, the transform
     *   is applied by manipulating the shape coordinates, if possible, rather than by introducing
     *   scaling, shearing, rotation, or translation. This is only supported currently for
     *   DrawRect, DrawOval, DrawDiamond, DrawImage, and DrawLabel,
     *   and only if no shearing is already present. Further, it's only possible to keep the
     *   transform simple if both axes are scaled by the same amount during the resize (or end up at
     *   the same scale if the DrawItem is already scaled unevenly), unless the rotation angle is a
     *   multiple of 90 degrees.
     * 
     *   For DrawPolygon and other shapes not based on a box (top/left/width/height), we can't
     *   safely just modify coordinates to effect a resize as we can do for DrawRect (and
     *   similar), so resizing will normally introduce or modify the transform, potentially
     *   introducing scaling or shearing, rather than modifying coordinates. For such
     *   DrawItems, we avoid trying to manipulate the coordinates, in part, because there's a
     *   danger that the floating point error may accumulate over time and warp the shape.
     *  @type {boolean}
     *  @default true
     */
    open var useSimpleTransform: Boolean = definedExternally
    /**
     *  If this item is showing "startPoint"
     * 
     *   DrawItem.knobs, this attribute specifies the AutoChild for the
     *   DrawKnob for start point of current drawItem.
     *  @type {DrawKnob}
     *  @default null
     */
    open var startKnob: DrawKnob = definedExternally
    /**
     *  If this item is showing "endPoint"
     * 
     *   DrawItem.knobs, this attribute specifies the AutoChild for the
     *   DrawKnob for end point of current drawItem.
     *  @type {DrawKnob}
     *  @default null
     */
    open var endKnob: DrawKnob = definedExternally
    /**
     *  Flag indicating a drawItem has been destroyed, similar to Canvas.destroyed.
     *  @type {boolean}
     *  @default null
     */
    open var destroyed: Boolean = definedExternally
    /**
     *  Flag indicating a drawItem is mid-destruction, similar to Canvas.destroying.
     *  @type {boolean}
     *  @default null
     */
    open var destroying: Boolean = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "DrawItemEditProxy"
     */
    open var editProxyConstructor: String = definedExternally
    /**
     *   Sets a property on this DrawItem, calling the appropriate setter method if one is found and
     *   is Class.isMethodSupported.
     * 
     *  @param {string} name of the property to set
     *  @param {any} new value for the property
     */
    open fun setPropertyValue(propertyName: String, newValue: dynamic): Unit = definedExternally
    /**
     *   Returns the DrawItem.zIndex of this draw item.
     * 
     *  @param {boolean=} if true and this item's zIndex is null, resolve to the next higher zIndex.
     */
    open fun getZIndex(resolveToNumber: Boolean?): Number = definedExternally
    /**
     *   Setter for DrawItem.zIndex.
     * 
     *  @param {Integer} new zIndex. If null and this draw item is already in a DrawPane or DrawGroup, then this item's zIndex will be set to the next higher auto-assigned zIndex.  Note that when setting draw items' zIndexes via this advanced API, the application should take over management of all draw items' zIndexes, and DrawItem.bringToFront / DrawItem.sendToBack should not be used, as those APIs assume automatic management of zIndexes.
     */
    open fun setZIndex(newZIndex: Number): Unit = definedExternally
    /**
     *   Places this draw item at the top of the stacking order so that it appears in front of other
     *   draw items in the same DrawPane or DrawGroup.
     * 
     *   When the DrawPane's DrawPane.drawingType is
     *   "bitmap",
     * 
     *   DrawItem.zIndex, bringToFront(), and DrawItem.sendToBack are not supported
     *   for DrawLabels on iOS due to platform limitations.
     * 
     */
    open fun bringToFront(): Unit = definedExternally
    /**
     *   Places this draw item at the bottom of the stacking order so that it appears behind other
     *   draw items in the same DrawPane or DrawGroup.
     * 
     *   When the DrawPane's DrawPane.drawingType is
     *   "bitmap",
     * 
     *   DrawItem.zIndex, DrawItem.bringToFront, and sendToBack() are not supported
     *   for DrawLabels on iOS due to platform limitations.
     * 
     */
    open fun sendToBack(): Unit = definedExternally
    /**
     * 
     * 
     *  @param {Cursor} new cursor.
     */
    open fun setCursor(newCursor: 
                                  /**
                                   *  Use the default arrow cursor for this browser/OS.
                                   *  Use the default cursor for this element type in this                browser/OS
                                   *  Use the wait cursor.
                                   *  Use the hand cursor.
                                   *  Use the "move" (crosshairs) cursor.
                                   *  Use the 'help' cursor.
                                   *  Use the 'text' (i-beam) cursor.
                                   *  Use the normal hand pointer that appears when you hover                over a link
                                   *  Use the 'crosshair' ( + ) cursor.
                                   *  Use the column resize cursor (horizontal double-tipped arrow)
                                   *  Use the row resize cursor (vertical double-tipped arrow)
                                   *  Use the "east resize" cursor.
                                   *  Use the "west resize" cursor.
                                   *  Use the "north resize" cursor.
                                   *  Use the "south resize" cursor.
                                   *  Use the "south-east resize" cursor.
                                   *  Use the "north-east resize" cursor.
                                   *  Use the "north-west resize" cursor.
                                   *  Use the "south-west resize" cursor.
                                   *  Use the "not-allowed" cursor.
                                   */
                                  String /* default |  auto |  wait |  hand |  move |  help |  text |  pointer |  arrow |  all-scroll |  crosshair |  col-resize |  row-resize |  e-resize |  w-resize |  n-resize |  s-resize |  se-resize |  ne-resize |  nw-resize |  sw-resize |  not-allowed */): Unit = definedExternally
    /**
     *   Returns the center point of this draw item in local coordinates. Generally this is the
     *   center of the DrawItem.getBoundingBox, but some item types may use
     *   a different point. For example, DrawTriangle uses the
     *   incenter
     *   of the triangle.
     * 
     */
    open fun getCenter(): Point = definedExternally
    /**
     *   Calculates the bounding box of the shape in the DrawPane.
     * 
     *   Note that the bounding box of the shape when transformed into the global coordinate system
     *   is available from the method DrawItem.getResizeBoundingBox.
     * 
     * 
     */
    open fun getBoundingBox(): Array<dynamic> = definedExternally
    /**
     *   Calculates the bounding box of the shape reflected by the
     *   DrawItem.showResizeOutline shown when dragging the
     *   DrawItem.resizeKnobPoints. This method is similar to DrawItem.getBoundingBox
     *   except that the coordinates returned by this method are in the global coordinate system
     *   (described DrawPane) rather than the local coordinate system.
     * 
     */
    open fun getResizeBoundingBox(): Array<dynamic> = definedExternally
    /**
     *   Returns true if the given point in the drawing coordinate system, when converted to
     *   coordinates in this DrawItem's local coordinate system, is within the
     *   DrawItem.getBoundingBox of this DrawItem's shape.
     * 
     *   This method can be used to quickly check whether the given point is definitely not within
     *   the DrawItem shape. To check whether the point is within the DrawItem shape, use the slower
     *   but exact DrawItem.isPointInPath method.
     * 
     *  @param {Integer} X coordinate of the point in the drawing coordinate system.
     *  @param {Integer} Y coordinate of the point in the drawing coordinate system.
     */
    open fun isInBounds(x: Number, y: Number): Boolean = definedExternally
    /**
     *   Returns an opaque JavaScript object representing the current local transformation applied to
     *   the DrawItem's local coordinates, as defined by DrawItem.translate, DrawItem.scale,
     *   DrawItem.xShearFactor, DrawItem.yShearFactor, and DrawItem.rotation. The object may be serialized
     *   and deserialized as JSON, and passed into the constructor block as DrawItem.shapeData to
     *   restore the local transformation.
     *   Note: this doesn't include any sepatate configuration, such as for a DrawRect
     *   the current values of DrawRect.left, DrawRect.top,
     *   DrawRect.width, or DrawRect.height.
     * 
     * 
     */
    open fun getShapeData(): dynamic = definedExternally
    /**
     *   Returns true if the given point in the drawing coordinate system is within this DrawItem's shape,
     *   taking into account local transforms.
     * 
     *  @param {Integer} X coordinate of the test point.
     *  @param {Integer} Y coordinate of the test point.
     */
    open fun isPointInPath(x: Number, y: Number): Boolean = definedExternally
    /**
     *   Computes the angle in degrees from the positive X axis to the difference vector
     *   v2 - v1 between the two given vectors.
     * 
     *  @param {Double} X coordinate of v1
     *  @param {Double} Y coordinate of v1
     *  @param {Double} X coordinate of v2
     *  @param {Double} Y coordinate of v2
     */
    open fun computeAngle(px1: Number, py1: Number, px2: Number, py2: Number): Number = definedExternally
    /**
     *   Returns the page-relative left coordinate of the widget on the page, in pixels.
     * 
     */
    open fun getPageLeft(): Number = definedExternally
    /**
     *   Returns the page-relative top coordinate of the widget on the page, in pixels
     * 
     */
    open fun getPageTop(): Number = definedExternally
    /**
     *   Setter for DrawItem.canDrag.
     * 
     * 
     *  @param {boolean} new value for this.canDrag.
     */
    open fun setCanDrag(canDrag: Boolean): Unit = definedExternally
    /**
     *   Notification fired when the user starts to drag this DrawItem. Will only fire if DrawItem.canDrag
     *   is true.
     * 
     *   Note that if this item is part of a DrawGroup, then the group's DrawGroup.useGroupRect
     *   setting affects whether this item receives the notification. If useGroupRect is true, then
     *   this item will not receive the notification. Otherwise, the item receives the
     *   notification and notification bubbles up to the group.
     * 
     */
    open fun dragStart(): Boolean = definedExternally
    /**
     *   Notification fired for every mouseMove event triggered while the user is dragging this
     *   DrawItem. Will only fire if DrawItem.canDrag is true.
     * 
     *   Note that if this item is part of a DrawGroup, then the group's DrawGroup.useGroupRect
     *   setting affects whether this item receives the notification. If useGroupRect is true, then
     *   this item will not receive the notification. Otherwise, the item receives the
     *   notification and notification bubbles up to the group.
     * 
     */
    open fun dragMove(): Boolean = definedExternally
    /**
     *   Notification fired when the user stops dragging this DrawItem. Will only fire if DrawItem.canDrag
     *   is true.
     * 
     *   Note that if this item is part of a DrawGroup, then the group's DrawGroup.useGroupRect
     *   setting affects whether this item receives the notification. If useGroupRect is true, then
     *   this item will not receive the notification. Otherwise, the item receives the
     *   notification and notification bubbles up to the group.
     * 
     */
    open fun dragStop(): Boolean = definedExternally
    /**
     *   Notification fired when the user presses the left mouse button on this DrawItem.
     * 
     *   Note that if this item is part of a DrawGroup, then the group's DrawGroup.useGroupRect
     *   setting affects whether this item receives the notification. If useGroupRect is true, then
     *   this item will not receive the notification. Otherwise, the item receives the
     *   notification and notification bubbles up to the group.
     * 
     */
    open fun mouseDown(): Boolean = definedExternally
    /**
     *   Notification fired when the user releases the left mouse button on this DrawItem.
     * 
     *   Note that if this item is part of a DrawGroup, then the group's DrawGroup.useGroupRect
     *   setting affects whether this item receives the notification. If useGroupRect is true, then
     *   this item will not receive the notification. Otherwise, the item receives the
     *   notification and notification bubbles up to the group.
     * 
     */
    open fun mouseUp(): Boolean = definedExternally
    /**
     *   Notification fired when the user clicks on this DrawItem.
     * 
     *   Note that if this item is part of a DrawGroup, then the group's DrawGroup.useGroupRect
     *   setting affects whether this item receives the notification. If useGroupRect is true, then
     *   this item will not receive the notification. Otherwise, the item receives the
     *   notification and notification bubbles up to the group.
     * 
     */
    open fun click(): Boolean = definedExternally
    /**
     *   Notification fired when the mouse enters this DrawItem.
     * 
     *   Note that if this item is part of a DrawGroup, then the group's DrawGroup.useGroupRect
     *   setting affects whether this item receives the notification. If useGroupRect is true, then
     *   this item will not receive the notification. Otherwise, the item receives the
     *   notification and notification bubbles up to the group.
     * 
     */
    open fun mouseOver(): Boolean = definedExternally
    /**
     *   Notification fired when the user moves the mouse over this DrawItem.
     * 
     *   Note that if this item is part of a DrawGroup, then the group's DrawGroup.useGroupRect
     *   setting affects whether this item receives the notification. If useGroupRect is true, then
     *   this item will not receive the notification. Otherwise, the item receives the
     *   notification and notification bubbles up to the group.
     * 
     */
    open fun mouseMove(): Boolean = definedExternally
    /**
     *   Notification fired when the mouse leaves this DrawItem.
     * 
     *   Note that if this item is part of a DrawGroup, then the group's DrawGroup.useGroupRect
     *   setting affects whether this item receives the notification. If useGroupRect is true, then
     *   this item will not receive the notification. Otherwise, the item receives the
     *   notification and notification bubbles up to the group.
     * 
     */
    open fun mouseOut(): Boolean = definedExternally
    /**
     *   Executed when the right mouse button is clicked. The default implementation of
     *   this method auto-creates a Menu from the Canvas.contextMenu property on
     *   this component and then calls Menu.showContextMenu on it to show it.
     * 
     *   If you want to show a standard context menu, you can simply define your Menu and set it as the
     *   contextMenu property on your component - you do not need to override this method.
     * 
     *   If you want to do some other processing before showing a menu or do something else entirely, then
     *   you should override this method. Note that the return value from this method controls whether or
     *   not the native browser context menu is shown.
     * 
     * 
     */
    open fun showContextMenu(): Boolean = definedExternally
    /**
     *   If DrawItem.canHover is true for this DrawItem, the hover() string method will
     *   be fired when the user hovers over this DrawItem. If this method returns false, it will
     *   suppress the default behavior of showing a hover canvas if DrawItem.showHover
     *   is true.
     * 
     */
    open fun hover(): Boolean = definedExternally
    /**
     *   If DrawItem.showHover is true, when the user holds the mouse over this DrawItem for
     *   long enough to trigger a hover event, a hover canvas is shown by default. This method returns
     *   the contents of that hover canvas. Default implementation returns DrawItem.prompt -
     *   override for custom hover HTML. Note that returning null or an empty string will
     *   suppress the hover canvas altogether.
     * 
     */
    open fun getHoverHTML(): String = definedExternally
    /**
     *   Draws this item into its current DrawItem.drawPane.
     * 
     *   NOTE: For performance reasons, the DrawPane may draw this item on a
     *   delay to allow multiple items to be added and drawn at one time. The DrawPane.refreshNow
     *   API will force this item to be drawn immediately.
     * 
     */
    open fun draw(): Unit = definedExternally
    /**
     *   Called when we start drawing for this DrawItem to the DrawItem.drawPane's underlying
     *   HTML5 &lt;canvas&gt; element. Only called if the DrawingType is
     *   "bitmap".
     * 
     *   There is no default implementation of this method.
     * 
     */
    open fun drawStart(): Unit = definedExternally
    /**
     *   Called when we finish drawing for this DrawItem to the DrawItem.drawPane's underlying
     *   HTML5 &lt;canvas&gt; element. Only called if the DrawingType is
     *   "bitmap".
     * 
     *   There is no default implementation of this method.
     * 
     */
    open fun drawEnd(): Unit = definedExternally
    /**
     *   Notification method fired when this component is explicitly moved.
     *   Note that a component's position on the screen may also be changed due to an ancestor being
     *   moved. The Canvas.parentMoved method provides a notification entry point to catch
     *   that case as well.
     * 
     * 
     *  @param {Integer} horizontal difference between current and previous position
     *  @param {Integer} vertical difference between current and previous position
     */
    open fun moved(deltaX: Number, deltaY: Number): Unit = definedExternally
    /**
     *   Observable method called whenever a DrawItem changes size.
     * 
     */
    open fun resized(): Unit = definedExternally
    /**
     *   Shows a set of control knobs for this drawItem. Updates DrawItem.knobs to include the
     *   specified knobType, and if necessary draws out the appropriate control knobs.
     * 
     *  @param {KnobType | Array<Partial<KnobType>>} knobs to show
     */
    open fun showKnobs(knobType: dynamic): Unit = definedExternally
    /**
     *   Shows all supported control knobs for this drawItem. Updates DrawItem.knobs to include the
     *   supported knobTypes and if necessary draws out the appropriate control knobs.
     * 
     */
    open fun showAllKnobs(): Unit = definedExternally
    /**
     *   Hides a set of control knobs for this drawItem. Updates DrawItem.knobs to remove the
     *   specified knobType, and clears any drawn knobs for this knobType.
     * 
     *  @param {KnobType | Array<Partial<KnobType>>} knobs to hide
     */
    open fun hideKnobs(knobType: dynamic): Unit = definedExternally
    /**
     *   Hides all control knobs for this drawItem. Updates DrawItem.knobs to remove
     *   all knobTypes and clears any drawn knobs.
     * 
     */
    open fun hideAllKnobs(): Unit = definedExternally
    /**
     *   Setter for DrawItem.moveKnobOffset.
     * 
     *  @param {Array<Partial<Integer>>=} the new move knob offset. This is a 2-element array of [left offset, top offset]. If null, then [0,0]  is assumed.
     */
    open fun setMoveKnobOffset(newMoveKnobOffset: Array<dynamic>?): Unit = definedExternally
    /**
     *   Setter for the DrawItem.title of this DrawItem.
     * 
     *  @param {string=} new title.
     */
    open fun setTitle(newTitle: String?): Unit = definedExternally
    /**
     *   If DrawItem.canDrag is true and the DrawItem.knobs include "resize" knobs,
     *   then this notification method will be fired when the user drag-resizes the draw item.
     * 
     *  @param {string} provides which knob of the DrawItem.resizeKnobPoints was dragged
     *  @param {Integer} new x-coordinate of the knob
     *  @param {Integer} new y-coordinate of the knob
     *  @param {Integer} horizontal distance moved
     *  @param {Integer} vertical distance moved
     */
    open fun dragResizeMove(position: String, x: Number, y: Number, dX: Number, dY: Number): Unit = definedExternally
    /**
     *   Setter for DrawItem.drawPane.
     * 
     *  @param {DrawPane} new value for this.drawPane.
     */
    open fun setDrawPane(drawPane: DrawPane): Unit = definedExternally
    /**
     *   Erase this drawItem's visual representation and remove it from its DrawGroup (if any) and
     *   DrawPane.
     * 
     *   To re-draw the item within the DrawPane, call DrawItem.draw again, or use
     *   DrawPane.addDrawItem to move to another DrawGroup.
     * 
     * 
     */
    open fun erase(): Unit = definedExternally
    /**
     *   Permanently destroys this DrawItem, similar to Canvas.destroy.
     * 
     * 
     */
    override fun destroy(): Unit = definedExternally
    /**
     *   Generates a string containing the SVG source of this DrawItem.
     * 
     *   NOTE: The generated SVG source assumes that the default namespace is http://www.w3.org/2000/svg
     *   and that namespace prefix xlink refers to namespace name http://www.w3.org/1999/xlink.
     * 
     * 
     */
    open fun getSvgString(): Unit = definedExternally
    /**
     *   Make this drawItem visible.
     * 
     */
    open fun show(): Unit = definedExternally
    /**
     *   Hide this drawItem.
     * 
     */
    open fun hide(): Unit = definedExternally
    /**
     *   Update lineWidth for this drawItem.
     * 
     *  @param {Integer} new pixel lineWidth
     */
    open fun setLineWidth(width: Number): Unit = definedExternally
    /**
     *   Update lineColor for this drawItem.
     * 
     *  @param {CSSColor} new line color. Pass null for transparent.
     */
    open fun setLineColor(color: String): Unit = definedExternally
    /**
     *   Update lineOpacity for this drawItem.
     * 
     *  @param {Float} new opacity, as a number between 0 (transparent) and 1 (opaque).
     */
    open fun setLineOpacity(opacity: Number): Unit = definedExternally
    /**
     *   Update linePattern for this drawItem.
     * 
     *  @param {LinePattern} new linePattern to use
     */
    open fun setLinePattern(pattern: 
                                     /**
                                      *  Solid line
                                      *  Dotted line
                                      *  Dashed line
                                      *  Dotted line, with more tightly spaced dots
                                      *  Dashed line, with shorter, more tightly spaced dashes
                                      *  Dashed line, with longer, more widely spaced dashes
                                      */
                                     String /* solid |  dot |  dash |  shortdot |  shortdash |  longdash */): Unit = definedExternally
    /**
     *   Update lineCap for this drawItem.
     * 
     *  @param {LineCap} new lineCap to use
     */
    open fun setLineCap(cap: 
                             /**
                              *  Semicircular rounding
                              *  Squared-off endpoint
                              *  Square endpoint, stops exactly at the line's end coordinates instead          of extending 1/2 lineWidth further as "round" and "square" do
                              */
                             String /* round |  square |  butt */): Unit = definedExternally
    /**
     *   Update shadow for this drawItem.
     * 
     *  @param {Shadow} new shadow
     */
    open fun setShadow(shadow: Shadow): Unit = definedExternally
    /**
     *   Does this DrawItem Class.isMethodSupported DrawItem.setStartArrow?
     *   For example, this is false for DrawRect and DrawOval, and true for DrawLine.
     * 
     */
    open fun supportsStartArrow(): Boolean = definedExternally
    /**
     *   Set the arrowhead at the beginning of this path.
     * 
     *   NOTE: Not all DrawItem classes support arrowheads. You can use DrawItem.supportsStartArrow
     *   to dynamically check whether a DrawItem instance supports this method.
     * 
     *  @param {ArrowStyle} style of arrow to use
     */
    open fun setStartArrow(arrowStyle: 
                                       /**
                                        *  Filled triangle.
                                        *  Two lines are drawn on each side of the path.
                                        */
                                       String /* block |  open */): Unit = definedExternally
    /**
     *   Does this DrawItem Class.isMethodSupported DrawItem.setEndArrow?
     *   For example, this is false for DrawRect and DrawOval, and true for DrawLine.
     * 
     */
    open fun supportsEndArrow(): Boolean = definedExternally
    /**
     *   Set the arrowhead at the end of this path.
     * 
     *   NOTE: Not all DrawItem classes support arrowheads. You can use DrawItem.supportsEndArrow
     *   to dynamically check whether a DrawItem instance supports this method.
     * 
     *  @param {ArrowStyle} style of arrow to use
     */
    open fun setEndArrow(arrowStyle: 
                                     /**
                                      *  Filled triangle.
                                      *  Two lines are drawn on each side of the path.
                                      */
                                     String /* block |  open */): Unit = definedExternally
    /**
     *   Move the shape by the specified deltas for the left and top coordinate.
     * 
     * 
     *  @param {Integer} change to left coordinate in pixels
     *  @param {Integer} change to top coordinate in pixels
     */
    open fun moveBy(dX: dynamic, dY: dynamic): Unit = definedExternally
    /**
     *   Move the DrawItem to the specified coordinates in the global coordinate system. The
     *   specified coordinates will become the top-left point of the
     *   DrawItem.getResizeBoundingBox.
     * 
     *  @param {Integer} new left coordinate in pixels
     *  @param {Integer} new top coordinate in pixels
     */
    open fun moveTo(left: Number, top: Number): Unit = definedExternally
    /**
     *   Change the center point for this DrawItem.
     * 
     *  @param {Integer} X coordinate of the center point (in the global coordinate system).
     *  @param {Integer} Y coordinate of the center point (in the global coordinate system).
     */
    open fun setCenterPoint(left: Number, top: Number): Unit = definedExternally
    /**
     *   Resize the shape by the specified deltas.
     * 
     *  @param {Integer} number of pixels to resize by horizontally
     *  @param {Integer} number of pixels to resize by vertically
     */
    open fun resizeBy(dX: dynamic, dY: dynamic): Unit = definedExternally
    /**
     *   Resize to the specified size
     * 
     *  @param {Integer} new width
     *  @param {Integer} new height
     */
    open fun resizeTo(width: Number, height: Number): Unit = definedExternally
    /**
     *   Rotate the shape by the relative rotation in degrees
     * 
     *  @param {Float} number of degrees to rotate from current orientation.
     */
    open fun rotateBy(degrees: Number): Unit = definedExternally
    /**
     *   Rotate the shape by the absolute rotation in degrees
     * 
     *  @param {Float} number of degrees to rotate
     */
    open fun rotateTo(degrees: Number): Unit = definedExternally
    /**
     *   Scale the shape by the x, y multipliers
     * 
     *  @param {Float} scale in the x direction
     *  @param {Float} scale in the y direction
     */
    open fun scaleBy(x: Number, y: Number): Unit = definedExternally
    /**
     *   Scale the shape by the x, y multipliers
     * 
     *  @param {Float} scale in the x direction
     *  @param {Float} scale in the y direction
     */
    open fun scaleTo(x: Number, y: Number): Unit = definedExternally
    /**
     *   Update fillColor for this drawItem.
     * 
     *  @param {CSSColor} new fillColor to use. Pass null for transparent.
     */
    open fun setFillColor(color: String): Unit = definedExternally
    /**
     *   Update fillGradient for this drawItem.
     * 
     *  @param {Gradient} new gradient to use. Pass null for transparent.
     */
    open fun setFillGradient(gradient: Gradient): Unit = definedExternally
    /**
     *   Update fillOpacity for this drawItem.
     * 
     *  @param {Float} new opacity, as a number between 0 (transparent) and 1 (opaque).
     */
    open fun setFillOpacity(opacity: Number): Unit = definedExternally
    companion object {
        /**
         *  Creates a new DrawItem
         * 
         *  @param typeCheckedProperties {Partial<DrawItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DrawItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DrawItem = definedExternally
        /**
         *   Computes the angle in degrees from the positive X axis to the difference vector
         *   v2 - v1 between the two given vectors.
         * 
         *  @param {Double} X coordinate of v1
         *  @param {Double} Y coordinate of v1
         *  @param {Double} X coordinate of v2
         *  @param {Double} Y coordinate of v2
         */
        fun computeAngle(px1: Number, py1: Number, px2: Number, py2: Number): Number = definedExternally
    }
}