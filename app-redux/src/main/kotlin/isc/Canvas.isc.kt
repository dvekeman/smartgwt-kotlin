@file:JsQualifier("isc")
package isc

/**
 *  Base class for all SmartClient visual components (except FormItem).
 * 
 *   Canvas provides:
 * 
 * 
 *  - basic visual lifecycle support - creation and destruction of HTML via
 *     Canvas.draw and Canvas.clear, visibility via
 *     Canvas.show and Canvas.hide, z-layering via
 *     Canvas.bringToFront and Canvas.sendToBack.
 * 
 *  - consistent cross-browser Canvas.moveTo,
 *     Canvas.resizeTo and Canvas.getScrollHeight, with
 *     automatic compensation for CSSStyleName.
 * 
 *  - clipping, scrolling and overflow management of content via Canvas.overflow
 * 
 *  - consistent cross-browser Canvas.keyPress and Canvas.mouseDown
 *     events, including mobileDevelopment to mouse events
 * 
 *  - built-in drag and drop capabilities including Canvas.canDragReposition,
 *     Canvas.canDragResize, Canvas.canDragScroll
 *     and Canvas.snapToGrid behavior.
 * 
 *  - the ability to either contain Canvas.contents or
 *     Canvas.children, including
 *     Canvas.snapTo and
 *     Canvas.percentSource for children. For more advanced layout
 *     capabilities, see Layout.
 * 
 *  - various other details like Canvas.cursor,
 *     Canvas.showClickMask, Canvas.animateMove,
 *     Canvas.ariaRole, and
 *     Canvas.locateChildrenBy for automatedTesting.
 * 
 */
open external class Canvas : BaseWidget {
    /**
     *  If this canvas is being displayed in a CanvasItem, this property will be set
     *   to point at the item. Otherwise this property will be null.
     *  @type {CanvasItem}
     *  @default null
     */
    open var canvasItem: CanvasItem = definedExternally
    /**
     *  Default total duration of animations. Can be overridden by setting animation times for
     *   specific animations, or by passing a duration parameter into the appropriate
     *   animate...() method.
     *  @type {number}
     *  @default "300"
     */
    open var animateTime: Number = definedExternally
    /**
     *  Default acceleration effect to apply to all animations on this Canvas.
     *   Can be overridden by setting animationAcceleration for specific animations or by passing
     *   an acceleration function directly into the appropriate method.
     *  @type {AnimationAcceleration}
     *  @default "smoothEnd"
     */
    open var animateAcceleration: 
                                  /**
                                   *  - animation will speed up as time elapses
                                   *  - animation will slow down as time elapses
                                   *  - animation will speed up in the middle
                                   *  - no bias
                                   */
                                  String /* smoothStart |  smoothEnd |  smoothStartEnd |  none */ = definedExternally
    /**
     *  Default animation effect to use if Canvas.animateShow is called without an
     *   explicit effect parameter
     *  @type {AnimateShowEffectId | AnimateShowEffect}
     *  @default "wipe"
     */
    open var animateShowEffect: dynamic = definedExternally
    /**
     *  Default animation effect to use if Canvas.animateHide is called without an
     *   explicit effect parameter
     *  @type {AnimateShowEffectId | AnimateShowEffect}
     *  @default "wipe"
     */
    open var animateHideEffect: dynamic = definedExternally
    /**
     *  Default time for performing an animated move. If unset, this.animateTime
     *   will be used by default instead
     *  @type {number}
     *  @default null
     */
    open var animateMoveTime: Number = definedExternally
    /**
     *  Default time for performing an animated resize. If unset, this.animateTime
     *   will be used by default instead
     *  @type {number}
     *  @default null
     */
    open var animateResizeTime: Number = definedExternally
    /**
     *  Default time for performing an animated setRect. If unset, this.animateTime
     *   will be used by default instead
     *  @type {number}
     *  @default null
     */
    open var animateRectTime: Number = definedExternally
    /**
     *  Default time for performing an animated fade. If unset, this.animateTime
     *   will be used by default instead
     *  @type {number}
     *  @default null
     */
    open var animateFadeTime: Number = definedExternally
    /**
     *  Default time for performing an animated scroll. If unset, this.animateTime
     *   will be used by default instead
     *  @type {number}
     *  @default null
     */
    open var animateScrollTime: Number = definedExternally
    /**
     *  Default time for performing an animated show. If unset, this.animateTime
     *   will be used by default instead
     *  @type {number}
     *  @default null
     */
    open var animateShowTime: Number = definedExternally
    /**
     *  Default time for performing an animated hide. If unset, this.animateTime
     *   will be used by default instead
     *  @type {number}
     *  @default null
     */
    open var animateHideTime: Number = definedExternally
    /**
     *  Default acceleration effect for performing an animated move. If unset,
     *   this.animateAcceleration will be used by default instead
     *  @type {AnimationAcceleration}
     *  @default null
     */
    open var animateMoveAcceleration: 
                                      /**
                                       *  - animation will speed up as time elapses
                                       *  - animation will slow down as time elapses
                                       *  - animation will speed up in the middle
                                       *  - no bias
                                       */
                                      String /* smoothStart |  smoothEnd |  smoothStartEnd |  none */ = definedExternally
    /**
     *  Default acceleration function for performing an animated resize. If unset,
     *   this.animateAcceleration will be used by default instead
     *  @type {AnimationAcceleration}
     *  @default null
     */
    open var animateResizeAcceleration: 
                                        /**
                                         *  - animation will speed up as time elapses
                                         *  - animation will slow down as time elapses
                                         *  - animation will speed up in the middle
                                         *  - no bias
                                         */
                                        String /* smoothStart |  smoothEnd |  smoothStartEnd |  none */ = definedExternally
    /**
     *  Default acceleration function for performing an animated move and resize. If unset,
     *   this.animateAcceleration will be used by default instead
     *  @type {AnimationAcceleration}
     *  @default null
     */
    open var animateRectAcceleration: 
                                      /**
                                       *  - animation will speed up as time elapses
                                       *  - animation will slow down as time elapses
                                       *  - animation will speed up in the middle
                                       *  - no bias
                                       */
                                      String /* smoothStart |  smoothEnd |  smoothStartEnd |  none */ = definedExternally
    /**
     *  Default acceleration function for performing an animated scroll. If unset,
     *   this.animateAcceleration will be used by default instead
     *  @type {AnimationAcceleration}
     *  @default null
     */
    open var animateScrollAcceleration: 
                                        /**
                                         *  - animation will speed up as time elapses
                                         *  - animation will slow down as time elapses
                                         *  - animation will speed up in the middle
                                         *  - no bias
                                         */
                                        String /* smoothStart |  smoothEnd |  smoothStartEnd |  none */ = definedExternally
    /**
     *  Default acceleration function for performing an animated show. If unset,
     *   this.animateAcceleration will be used by default instead
     *  @type {AnimationAcceleration}
     *  @default null
     */
    open var animateShowAcceleration: 
                                      /**
                                       *  - animation will speed up as time elapses
                                       *  - animation will slow down as time elapses
                                       *  - animation will speed up in the middle
                                       *  - no bias
                                       */
                                      String /* smoothStart |  smoothEnd |  smoothStartEnd |  none */ = definedExternally
    /**
     *  Default acceleration function for performing an animated hide. If unset,
     *   this.animateAcceleration will be used by default instead
     *  @type {AnimationAcceleration}
     *  @default null
     */
    open var animateHideAcceleration: 
                                      /**
                                       *  - animation will speed up as time elapses
                                       *  - animation will slow down as time elapses
                                       *  - animation will speed up in the middle
                                       *  - no bias
                                       */
                                      String /* smoothStart |  smoothEnd |  smoothStartEnd |  none */ = definedExternally
    /**
     *  When this Canvas is included as a member in a Layout, layoutAlign controls alignment on the
     *   breadth axis of the layout. Default is "left" for a VLayout, "top" for an HLayout.
     *  @type {Alignment | VerticalAlignment}
     *  @default null
     */
    open var layoutAlign: dynamic = definedExternally
    /**
     *  When this Canvas is included as a member in a Layout, whether a resizeBar should be shown
     *   after this member in the layout, to allow it to be resized.
     * 
     *   Whether a resizeBar is actually shown also depends on the
     *   Layout.defaultResizeBars attribute of the layout, and whether this
     *   Canvas is the last layout member.
     * 
     *   By default the resize bar acts on the Canvas that it is declared on. If you want the resize
     *   bar to instead act on the next member of the Layout (e.g. to collapse down or to the right),
     *   set Canvas.resizeBarTarget as well.
     *  @type {boolean}
     *  @default false
     */
    open var showResizeBar: Boolean = definedExternally
    /**
     *  When this Canvas is included as a member in a Layout, and Canvas.showResizeBar is set to
     *   true so that a resizeBar is created, resizeBarTarget:"next" can be
     *   set to indicate that the resizeBar should resize the next member of the layout rather than
     *   this one. For resizeBars that support hiding their target member when clicked on,
     *   resizeBarTarget:"next" also means that the next member will be the one hidden.
     * 
     *   This is typically used to create a 3-way split pane, where left and right-hand sections can
     *   be resized or hidden to allow a center section to expand.
     * 
     *   NOTE: as with any Layout, to ensure all available space is used, one or more members
     *   must maintain a flexible size (eg 75%, or \*). In a two pane Layout with a normal resize
     *   bar, to fill all space after a user resizes, the member on the right should have
     *   flexible size. With resizeBarTarget:"next", the member on the left should have
     *   flexible size.
     *  @type {string}
     *  @default null
     */
    open var resizeBarTarget: String = definedExternally
    /**
     *  When this Canvas is included as a member in a Layout, extra blank space that should be left
     *   after this member in a Layout.
     *  @type {PositiveInteger}
     *  @default "0"
     */
    open var extraSpace: Number = definedExternally
    /**
     *  Configures where the Opacity filter is used for IE6-8.
     * 
     *   With the default of null, opacity filters are used unless
     *   Canvas.neverUseFilters has been set. When set explicitly to true,
     *   opacity filters are used even if neverUseFilters is true.
     * 
     *   See IEFilters for background.
     *  @type {boolean}
     *  @default null
     */
    open var useOpacityFilter: Boolean = definedExternally
    /**
     *  Global identifier for referring to a widget in JavaScript. The ID property is optional if
     *   you do not need to refer to the widget from JavaScript, or can refer to it indirectly
     *   (for example, by storing the reference returned by Class.create).
     * 
     *   An internal, unique ID will automatically be created upon instantiation for any canvas
     *   where one is not provided.
     * 
     *   The ID property should be unique in the global scope. If window[ID]
     *   is already assigned to something else a warning will be logged using the developer console,
     *   and the existing reference will be replaced, calling Canvas.destroy on the
     *   previous object if it is a SmartClient Class instance.
     * 
     *   Automatically generated IDs will be unique as long as the canvases they refer to remain
     *   active - once a canvas with an automatically generated ID has been destroyed, its ID may be
     *   reused for the next canvas created with no explicitly specified ID.
     *  @type {GlobalId}
     *  @default null
     */
    open var ID: String = definedExternally
    /**
     *  If true, this canvas will draw itself immediately after it is created.
     * 
     *   Note that you should turn this OFF for any canvases that are provided as children
     *   of other canvases, or they will draw initially, then be clear()ed and drawn again when
     *   added as children, causing a large performance penalty.
     * 
     *   For example, the following code is incorrect and will cause extra draw()s:
     * 
     * 
     *     isc.Layout.create({
     *       members : [
     *         isc.ListGrid.create()
     *       ]
     *     });
     * 
     *   It should instead be:
     * 
     *     isc.Layout.create({
     *       members : [
     *         isc.ListGrid.create({ autoDraw: false })
     *       ]
     *     });
     * 
     *   In order to avoid unwanted autoDrawing systematically, it is recommend that you call
     *   isc.setAutoDraw immediately after SmartClient is loaded
     *   and before any components are created, then set autoDraw:true or call
     *   draw() explicitly to draw components.
     * 
     *   Otherwise, if the global setting for autoDraw remains true, you must set
     *   autoDraw:false, as shown above, on every component in your application that
     *   should not immediately draw: all Canvas children, Layout members, Window items, Tab
     *   panes, etc, however deeply nested. Forgetting to set autoDraw:false will result in one
     *   more clear()s - these are reported on the Results tab of the
     *   debugging, and can be tracked to individual components by
     *   using the "clears" log category in the Developer Console.
     *  @type {boolean}
     *  @default true
     */
    open var autoDraw: Boolean = definedExternally
    /**
     *  This Canvas's immediate parent, if any.
     * 
     *   Can be initialized, but any subsequent manipulation should be via
     *   Canvas.addChild and Canvas.removeChild calls
     *   on the parent.
     *  @deprecated \* As of Smartclient version 9.1, deprecated in favor of Canvas.parentCanvas       and Canvas.getParentCanvas
     *  @type {Canvas}
     *  @default null
     */
    open var parentElement: Canvas = definedExternally
    /**
     *  This Canvas's immediate parent, if any.
     * 
     *   Can be initialized, but any subsequent manipulation should be via
     *   Canvas.addChild and Canvas.removeChild calls
     *   on the parent. The parent Canvas should be fetched using
     *   Canvas.getParentCanvas.
     *  @type {Canvas}
     *  @default null
     */
    open var parentCanvas: Canvas = definedExternally
    /**
     *  The top-most Canvas (i.e., not a child of any other Canvas), if any, in this widget's
     *   containment hierarchy.
     *  @type {Canvas}
     *  @default null
     */
    open var topElement: Canvas = definedExternally
    /**
     *  This Canvas's "master" (the Canvas to which it was added as a peer), if any.
     *  @deprecated \* In favor or Canvas.getMasterCanvas as of SmartClient release 9.1
     *  @type {Canvas}
     *  @default null
     */
    open var masterElement: Canvas = definedExternally
    /**
     *  Array of all Canvii that are immediate children of this Canvas.
     * 
     *   Use Canvas.addChild and Canvas.removeChild to add and remove children after a Canvas
     *   has been created/drawn.
     *  @type {Array<Partial<Canvas>>}
     *  @default null
     */
    open var children: Array<dynamic> = definedExternally
    /**
     *  Array of all Canvii that are peers of this Canvas.
     * 
     *   Use Canvas.addPeer and Canvas.removePeer to add and remove peers after a Canvas
     *   has been created/drawn.
     *  @type {Array<Partial<Canvas>>}
     *  @default null
     */
    open var peers: Array<dynamic> = definedExternally
    /**
     *  This initialization property allows developers to create a canvas using the
     *   Class.addAutoChild method, and have it added as a child to some other
     *   component. This property may be set to the childName of another
     *   already-created auto-child, or "none" to cause the component to be
     *   created without being added as a child to any other widget.
     *   If unset, the canvas will be added as a child to the component on which
     *   addAutoChild(...) was called.
     * 
     *   See autoChildren for an overview of the autoChild subsystem.
     *  @type {string}
     *  @default null
     */
    open var autoParent: String = definedExternally
    /**
     *  If specified as a pointer to an HTML element present in the DOM, this canvas will be
     *   rendered inside that element on Canvas.draw.
     * 
     *   NOTES:
     *   This feature is intended for temporary integration with legacy page architectures only;
     *   the native browser's reaction to DOM insertion is unspecified and unsupported. For
     *   consistent cross-browser layout and positioning semantics, use Canvas parents
     *   (especially Layouts) and use absolute positioning at top level.
     * 
     *   Persistence of htmlElement: If Canvas.htmlPosition is set to "replace"
     *   the htmlElement will be removed from the DOM when the canvas is drawn - therefore the
     *   htmlElement attribute will be cleared at this time.
     *   Otherwise if a Canvas is clear()d and then draw()n again it will
     *   be rendered inside the same htmlElement.
     *   If a Canvas is added as a child to Canvas parent, its htmlElement will be dropped.
     * 
     *   Canvas.position should typically be set to "relative" if the widget
     *   is to be rendered inline within a standard page.
     *  @type {DOMElement}
     *  @default null
     */
    open var htmlElement: DOMElement = definedExternally
    /**
     *  If Canvas.htmlElement is specified, this attribute specifies the position where
     *   the canvas should be inserted relative to the htmlElement in the DOM.
     *  @type {DrawPosition}
     *  @default "afterBegin"
     */
    open var htmlPosition: 
                           /**
                            *  insert before the target element
                            *  insert as the target element's first child
                            *  insert as the target element's last child
                            *  insert after the target element
                            *  replace the target element
                            */
                           String /* beforeBegin |  afterBegin |  beforeEnd |  afterEnd |  replace */ = definedExternally
    /**
     *  If Canvas.htmlElement is specified, should this canvas initially be drawn
     *   at the same dimensions as the htmlElement?
     *   Note: setting this property will not force the canvas to resize if the element
     *   subsequently resizes (for example due to page reflow).
     *  @type {boolean}
     *  @default null
     */
    open var matchElement: Boolean = definedExternally
    /**
     *  Absolute or relative, corresponding to the "absolute" (with respect to parent) or
     *   "relative" (with respect to document flow) values for the CSS position attribute.
     * 
     *   Setting position:"relative" enables SmartClient components to be embedded
     *   directly into the native HTML flow of a page, causing the component to be rendered
     *   within an existing DOM structure.
     *   This attribute should only be set to "relative" on a top level component
     *   (a component with no Canvas.getParentCanvas).
     * 
     *   There are 2 ways to embed relatively positioned canvases in the DOM - by default the
     *   component will be written out inline when it gets Canvas.draw. For example
     *   to embed a canvas in an HTML table you could use this code:
     * 
     *   &lt;table&gt;
     *    &lt;tr&gt;
     *     &lt;td&gt;
     *      &lt;script&gt;
     *       isc.Canvas.create({autoDraw:true, backgroundColor:"red", position:"relative"});
     *      &lt;/script&gt;
     *     &lt;td&gt;
     *    &lt;/tr&gt;
     *   &lt;/table&gt;
     * 
     *   Alternatively you can make use of the Canvas.htmlElement attribute.
     * 
     *   Relative positioning is intended as a short-term integration scenario while incrementally
     *   upgrading existing applications.
     *   Note that relative positioning is not used to manage layout within SmartClient components -
     *   instead the Layout class would typically be used.
     *   For best consistency and flexibility across browsers, all SmartClient layout managers
     *   use absolute positioning.
     * 
     *   For canvases with a specified Canvas.htmlElement, this attribute defaults to
     *   "relative". In all other cases the default value will be
     *   "absolute".
     *  @type {Positioning}
     *  @default null
     */
    open var position: 
                       /**
                        *  The canvas is absolutely positioned with respect to its                 parent.
                        *  The canvas is relatively positioned according to the                 document flow.
                        */
                       String /* absolute |  relative */ = definedExternally
    /**
     *  Number of pixels the left side of the widget is offset to the right from its default
     *   drawing context (either its parent's topleft corner, or the document flow, depending on
     *   the value of the Canvas.position property).
     * 
     *   Can also be set as a percentage, specified as a String ending in '%', eg, "50%". In
     *   this case the top coordinate is considered as a percentage of the specified width of
     *   the Canvas.getParentCanvas.
     *  @type {number | string}
     *  @default "0"
     */
    open var left: dynamic = definedExternally
    /**
     *  Number of pixels the top of the widget is offset down from its default drawing context
     *   (either its parent's top-left corner, or the document flow, depending on the value of
     *   the Canvas.position property).
     * 
     *   Can also be set as a percentage, specified as a String ending in '%', eg, "50%". In
     *   this case the top coordinate is considered as a percentage of the specified height of
     *   the Canvas.getParentCanvas.
     *  @type {number | string}
     *  @default "0"
     */
    open var top: dynamic = definedExternally
    /**
     *  If set, overrides the global Canvas.defaultPageSpace.
     *  @type {Integer}
     *  @default null
     */
    open var leavePageSpace: Number = definedExternally
    /**
     *  Size for this component's horizontal dimension.
     * 
     *   Can be a number of pixels, or a percentage like "50%". Percentage sizes are resolved to
     *   pixel values as follows:
     * 
     * 
     *  - If a canvas has a specified Canvas.percentSource, sizing will be
     *     a percentage of the size of that widget (see also Canvas.percentBox).
     * 
     *  - Otherwise, if a canvas has a Canvas.getMasterCanvas, and
     *     Canvas.snapTo is set for the widget, sizing will be a percentage of
     *     the size of that widget (see also Canvas.percentBox).
     * 
     *  - Otherwise if this is a child of some other canvas, percentages will be based on the
     *     inner size of the Canvas.getParentCanvas's viewport.
     * 
     *  - Otherwise, for top level widgets, sizing is calculated as a percentage of page size.
     * 
     *   Note that if a Canvas.maxWidth or Canvas.minWidth are specified
     *   (or Canvas.maxHeight / Canvas.minHeight for heights), these
     *   properties act as explicit pixel limits on the canvas' size. For example, a canvas
     *   with Canvas.maxWidth set to 500, and width specified as
     *   "100%" will not render larger than 500 pixels in width even if there is more
     *   space available in the parent canvas or percentSource.
     * 
     *   Layout may specially interpret percentage sizes on their children,
     *   and also allow "\*" as a size.
     * 
     *   Note that if Canvas.overflow is set to "visible", this size is a
     *   minimum, and the component may overflow to show all content and/or children.
     * 
     *   If trying to establish a default width for a custom component, set
     *   Canvas.defaultWidth instead.
     *  @type {number | string}
     *  @default null
     */
    open var width: dynamic = definedExternally
    /**
     *  Size for this component's vertical dimension.
     * 
     *   Can be a number of pixels, or a percentage like "50%". See documentation for
     *   Canvas.width for details on how percentage values are resolved actual size.
     * 
     *   Note that if Canvas.overflow is set to "visible", this size is a
     *   minimum, and the component may overflow to show all content and/or children.
     * 
     *   If trying to establish a default height for a custom component, set
     *   Canvas.defaultHeight instead.
     *  @type {number | string}
     *  @default null
     */
    open var height: dynamic = definedExternally
    /**
     *  For custom components, establishes a default width for the component.
     * 
     *   For a component that should potentially be sized automatically by a Layout, set this
     *   property rather than Canvas.width directly, because Layouts regard a width setting as
     *   an explicit size that shouldn't be changed.
     *  @type {Integer}
     *  @default "100"
     */
    open var defaultWidth: Number = definedExternally
    /**
     *  For custom components, establishes a default height for the component.
     * 
     *   For a component that should potentially be sized automatically by a Layout, set this
     *   property rather than Canvas.height directly, because Layouts regard a height setting as
     *   an explicit size that shouldn't be changed.
     *  @type {Integer}
     *  @default "100"
     */
    open var defaultHeight: Number = definedExternally
    /**
     *  Minimum width available to this Canvas.
     * 
     *   The minWidth and Canvas.minHeight settings apply to:
     * 
     * 
     *  - For a canvas being managed as a member of a Layout, the minimum size the
     *     layout should apply to the canvas.
     * 
     *  - For a canvas with a width or height specified as a percent value, a minimum
     *     numeric pixel value to limit how large the canvas is sized.
     * 
     *  - determining size for a Canvas in a CanvasItem (minHeight only)
     * 
     *  - end user Canvas.canDragResize
     * 
     *  - minimum size when using Overflow "visible" outside of a Layout - minimum
     *     size will be the greater of this setting or the minimum size needed to make all
     *     content visible
     * 
     * 
     *   Minimum sizes do not apply in various other circumstances where sizes are being
     *   determined, such as ListGrid.showRecordComponents.
     * 
     *   See also Layout.minMemberLength as a way of establishing minimum sizes along
     *   the length axis for all members of a Layout with a single setting.
     *  @type {number}
     *  @default null
     */
    open var minWidth: Number = definedExternally
    /**
     *  Minimum height available to this Canvas. See Canvas.minWidth for details of behavior.
     *  @type {number}
     *  @default null
     */
    open var minHeight: Number = definedExternally
    /**
     *  Maximum width available to this Canvas.
     * 
     *   The maxWidth and Canvas.maxHeight settings apply to:
     * 
     * 
     *  - For a canvas being managed as a member of a Layout, the maximum size the
     *     layout should apply to the canvas.
     * 
     *  - For a canvas with a width or height specified as a percent value, a maximum
     *     numeric pixel value to limit how large the canvas is sized.
     * 
     *  - determining size for a Canvas in a CanvasItem (maxHeight only)
     * 
     *  - end user Canvas.canDragResize
     * 
     *   Maximum sizes do not apply in various other circumstances where sizes are being
     *   determined, such as ListGrid.showRecordComponents.
     *  @type {number}
     *  @default "10000"
     */
    open var maxWidth: Number = definedExternally
    /**
     *  Maximum height available to this Canvas. See Canvas.maxWidth for details of behavior.
     *  @type {number}
     *  @default "10000"
     */
    open var maxHeight: Number = definedExternally
    /**
     *  Minimum width that this Canvas can be resized to by a user. Actual limit will be maximum
     *   of dragMinWidth and Canvas.minWidth.
     * 
     *   Note that a Canvas with overflow:"visible" has an implicit minimize size based on it's
     *   contents.
     * 
     *   Note that dragMinWidth affects only user-initiated drag resizes. To set
     *   the minimum width of a Canvas embedded in a Layout, you can set +{minWidth}, or
     *   Layout.minMemberLength to constrain the minimum size along the length axis of all
     *   members of the Layout.
     *  @type {number}
     *  @default "10"
     */
    open var dragMinWidth: Number = definedExternally
    /**
     *  Minimum height that this Canvas can be resized to by a user. See Canvas.dragMinWidth
     *   for details of behavior.
     *  @type {number}
     *  @default "10"
     */
    open var dragMinHeight: Number = definedExternally
    /**
     *  Maximum width that this Canvas can be resized to by a user. Actual limit will be minimum
     *   of dragMaxWidth and Canvas.maxWidth.
     *  @type {number}
     *  @default "10000"
     */
    open var dragMaxWidth: Number = definedExternally
    /**
     *  Sets maximum height that this Canvas can be resized to by a user. Actual limit will be
     *   minimum of dragMaxHeight and Canvas.maxHeight.
     *  @type {number}
     *  @default "10000"
     */
    open var dragMaxHeight: Number = definedExternally
    /**
     *  This is an advanced setting. If set to true, when a widget is
     *   Canvas.hide, the widget's handle will be resized such that
     *   it takes up no space, in addition to having its css visibility
     *   property set to "hidden".
     * 
     *   In addition to preventing the size of this widget from impacting the
     *   Canvas.getScrollWidth of any parent widget while hidden, this
     *   setting works around a native bug observed in Internet Explorer 10, whereby
     *   an &lt;IFRAME&gt; element with visibility set to hidden can
     *   cause rendering problems, if the HTML loaded by the &lt;IFRAME&gt;
     *   contains a &lt;frameset&gt;. In this case the browser may
     *   refuse to draw other elements at the same coordinates with a lower z-index than
     *   the hidden frame. Setting this property to true works around
     *   this problem for cases where an &lt;IFRAME&gt; containing a
     *   &lt;frameset will be rendered out, for example in an
     *   HTMLFlow with contentsType set to "page".
     *  @type {boolean}
     *  @default false
     */
    open var shrinkElementOnHide: Boolean = definedExternally
    /**
     *  If set to true, the widget's parent (if any) will automatically be shown whenever the
     *     widget is shown.
     *  @type {boolean}
     *  @default false
     */
    open var autoShowParent: Boolean = definedExternally
    /**
     *  Controls widget visibility when the widget is initialized. See Visibility type for
     *     details.
     *  @type {Visibility}
     *  @default "inherit"
     */
    open var visibility: 
                         /**
                          *  The widget visibility will match that of its parent                 (usually visible).
                          *  The widget will always be visible whether its parent is                 or not.
                          *  The widget will always be hidden even when its parent is                 visible.
                          */
                         String /* inherit |  visible |  hidden */ = definedExternally
    /**
     *  When this widget is hidden (see Canvas.visibility and Canvas.hide),
     *   should display:none be applied to the Canvas.getOuterElement?
     * 
     *   This setting is not supported for general use, but in certain cases, it has been shown
     *   that display:none is a work-around for browser bugs involving burn-through of iframes or
     *   plugins, where the content of the iframe or plugin may still be visible despite the
     *   containing widget being hidden.
     *  @type {boolean}
     *  @default false
     */
    open var hideUsingDisplayNone: Boolean = definedExternally
    /**
     *  Whether native drag selection of contained text is allowed within this Canvas.
     * 
     *   Note that setting this property to false will not avoid text selection
     *   which is initiated outside this Canvas from continuing into this Canvas, even if text
     *   selection began in another Canvas.
     *  @type {boolean}
     *  @default false
     */
    open var canSelectText: Boolean = definedExternally
    /**
     *  The CSS class applied to this widget as a whole.
     *  @deprecated \* In favor or Canvas.styleName as of SmartClient release 5.5
     *  @type {CSSStyleName}
     *  @default "normal"
     */
    open var className: String = definedExternally
    /**
     *  The CSS class applied to this widget as a whole.
     *  @type {CSSStyleName}
     *  @default "normal"
     */
    open var styleName: String = definedExternally
    /**
     *  The contents of a canvas or label widget. Any HTML string is acceptable.
     *  @type {HTMLString}
     *  @default "&amp;nbsp;"
     */
    open var contents: String = definedExternally
    /**
     *  Dynamic contents allows the contents string to be treated as a simple, but powerful
     *   template. When this attribute is set to true, expressions of the form &#36;{arbitrary JS
     *   here} are replaced by the result of the evaluation of the JS code inside the curly
     *   brackets. This evaluation happens at draw time. If you want to trigger a re-evaluation
     *   of the expressions in the contents string you can call markForRedraw() on the canvas.
     * 
     *   You can use this feature to build some simple custom components. For example, let's say
     *   you want to show the value of a Slider in a Canvas somewhere on the screen. You can do
     *   this by observing the valueChanged() method on the slider and calling setContents() on
     *   your canvas with the new string or you can set the contents of the canvas to something
     *   like:
     * 
     *   "The slider value is &#36;{sliderInstance.getValue()}."
     * 
     *   Next you set dynamicContents: true on the canvas, observe valueChanged() on the slider
     *   and call canvas.markForRedraw() in that observation. This approach is cleaner than
     *   setContents() when the Canvas is aggregating several values or dynamic expressions.
     *   Like so:
     * 
     * 
     *   Slider.create({
     *     ID: "mySlider"
     *   });
     * 
     *   Canvas.create({
     *     ID: "myCanvas",
     *     dynamicContents: true,
     *     contents: "The slider value is &#36;{mySlider.getValue()}."
     *   });
     * 
     *   myCanvas.observe(mySlider, "valueChanged",
     *           "observer.markForRedraw()");
     * 
     *   You can embed an arbitrary number of dynamic expressions in the contents string. The
     *   search and replace is optimized for speed.
     * 
     *   If an error occurs during the evaluation of one of the expressions, a warning is logged
     *   to the ISC Developer Console and the error string is embedded in place of the expected
     *   value in the Canvas.
     * 
     *   The value of a function is its return value. The value of any variable is the same as
     *   that returned by its toString() representation.
     * 
     *   Inside the evaluation contentext, this points to the canvas instance that
     *   has the dynamicContents string as its contents - in other words the canvas instance on
     *   which the template is declared.
     *  @type {boolean}
     *  @default false
     */
    open var dynamicContents: Boolean = definedExternally
    /**
     *  An optional map of name:value parameters that will be available within the scope of the
     *   dynamicContents evaluation. For example - if you have e.g:
     * 
     *   Canvas.create({
     *    dynamicContents: true,
     *    dynamicContentsVars: {
     *      name: "Bob"
     *    },
     *    contents: "hello &#36;{name}"
     *   });
     * 
     *   The above will create a canvas with contents hello Bob. You can add, remove, and
     *   change values in the dynamicContentsVars object literal, just call
     *   markForRedraw() on the canvas to have the dynamicContents template re-evaluated.
     * 
     *   Note that this is always available inside a dynamic contents string and points to
     *   the canvas instance containing the dynamic contents.
     * 
     *   Used only if Canvas.dynamicContents : true has been set.
     *  @type {ValueMap}
     *  @default null
     */
    open var dynamicContentsVars: dynamic = definedExternally
    /**
     *  Set the CSS Margin, in pixels, for this component. Margin provides blank space outside
     *   of the border.
     * 
     *   This property sets the same thickness of margin on every side. Differing per-side
     *   margins can be set in a CSS style and applied via Canvas.styleName.
     * 
     *   Note that the specified size of the widget will be the size including the margin
     *   thickness on each side.
     *  @type {number}
     *  @default null
     */
    open var margin: Number = definedExternally
    /**
     *  Set the CSS padding of this component, in pixels. Padding provides space between the
     *   border and the component's contents.
     * 
     *   This property sets the same thickness of padding on every side. Differing per-side
     *   padding can be set in a CSS style and applied via Canvas.styleName.
     * 
     *   Note that CSS padding does not affect the placement of Canvas.children. To
     *   provide a blank area around children, either use Canvas.margin or use
     *   a Layout as the parent instead, and use properties such as
     *   Layout.layoutMargin to create blank space.
     *  @type {number}
     *  @default null
     */
    open var padding: Number = definedExternally
    /**
     *  Set the CSS border of this component, as a CSS string including border-width,
     *   border-style, and/or color (eg "2px solid blue").
     * 
     *   This property applies the same border to all four sides of this component. Different
     *   per-side borders can be set in a CSS style and applied via Canvas.styleName.
     * 
     *   If Canvas.isGroup is set to true then border is derived from the
     *   Canvas.groupBorderCSS attribute, not from the explicit border property.
     *  @type {string}
     *  @default null
     */
    open var border: String = definedExternally
    /**
     *  The background color for this widget. It corresponds to the CSS background-color
     *   attribute. You can set this property to an RGB value (e.g. #22AAFF) or a named color
     *   (e.g. red) from a list of browser supported color names.
     *  @type {CSSColor}
     *  @default null
     */
    open var backgroundColor: String = definedExternally
    /**
     *  URL for a background image for this widget (corresponding to the CSS "background-image"
     *   attribute).
     *  @type {SCImgURL}
     *  @default null
     */
    open var backgroundImage: String = definedExternally
    /**
     *  Specifies how the background image should be tiled if this widget
     *   is larger than the image. It corresponds to the CSS background-repeat
     *   attribute.
     * 
     *   The default of null means no background-repeat CSS will be
     *   written out. See BackgroundRepeat type for details on other settings.
     * 
     *   NOTE: this setting directly sets the CSS property background-repeat but
     *   does not attempt to work around various known bugs with this setting, or lack of support
     *   in IE6. If you need to apply CSS-based workarounds for browser limitations with
     *   this setting, it's best to do so via setting Canvas.styleName.
     *  @type {BackgroundRepeat}
     *  @default null
     */
    open var backgroundRepeat: 
                               /**
                                *  Tile the background image horizontally and vertically.
                                *  Don't tile the background image at all.
                                *  Repeat the background image horizontally but not vertically.
                                *  Repeat the background image vertically but not horizontally.
                                */
                               String /* repeat |  no-repeat |  repeat-x |  repeat-y */ = definedExternally
    /**
     *  Specifies how the background image should be positioned on the widget.
     *     It corresponds to the CSS background-position attribute. If unset,
     *     no background-position attribute is specified if a background image is
     *     specified.
     *  @type {string}
     *  @default null
     */
    open var backgroundPosition: String = definedExternally
    /**
     *  Default directory for app-specific images, relative to the Page-wide
     *   Page.getAppImgDir.
     *  @type {URL}
     *  @default ""
     */
    open var appImgDir: String = definedExternally
    /**
     *  Default directory for skin images (those defined by the class), relative to the
     *   Page-wide Page.getSkinDir.
     *  @type {SCImgURL}
     *  @default "images/"
     */
    open var skinImgDir: String = definedExternally
    /**
     *  Specifies the cursor image to display when the mouse pointer is
     *     over this widget. It corresponds to the CSS cursor attribute. See Cursor type for
     *     different cursors.
     * 
     *     See also Canvas.disabledCursor and Canvas.noDropCursor.
     *  @type {Cursor}
     *  @default "default"
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
     *  Specifies the cursor image to display when the mouse pointer is
     *     over this widget if this widget is disabled. It corresponds to the CSS cursor
     *     attribute. See Cursor type for different cursors.
     *  @type {Cursor}
     *  @default "default"
     */
    open var disabledCursor: 
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
     *  Specifies the cursor image to display when the user drags a droppable canvas
     *     over this if it is not a valid drop target for the event and
     *     EventHandler.showNoDropIndicator is true.
     *  @type {Cursor}
     *  @default "not-allowed"
     */
    open var noDropCursor: 
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
     *  Renders the widget to be partly transparent. A widget's opacity property may
     *     be set to any number between 0 (transparent) to 100 (opaque).
     *     Null means don't specify opacity directly, 100 is fully opaque.
     *     Note that heavy use of opacity may have a performance impact on some older
     *     browsers.
     * 
     *     In older versions of Internet Explorer (Pre IE9 / HTML5), opacity is achieved
     *     through proprietary filters. If
     *     Canvas.neverUseFilters within this application
     *     developers must set Canvas.useOpacityFilter to true for specific components
     *     on which opacity support is required.
     * 
     *     Also note that opacity is incompatible
     *     with Canvas.useBackMask.
     *  @type {number}
     *  @default null
     */
    open var opacity: Number = definedExternally
    /**
     *  Controls what happens when the drawn size of the content of a Canvas is either
     *       greater or smaller than the specified size of the Canvas. Similar to the CSS
     *       property overflow, but consistent across browsers. See Overflow type for
     *       details.
     *  @type {Overflow}
     *  @default "visible"
     */
    open var overflow: 
                       /**
                        *  Content that extends beyond the widget's width or height is               displayed.
                        *                 Note: To have the content be sized only by the drawn size of
                        *                 the content set the overflow to be Canvas.VISIBLE and specify
                        *                 a small size, allowing the size to expand to the size required
                        *                 by the content.
                        *                 Leaving the width / height for the widget undefined will use the
                        *                 default value of 100, and setting the size to zero may cause the
                        *                 widget not to draw.
                        *  Content that extends beyond the widget's width or height is               clipped (hidden).
                        *  Horizontal and/or vertical scrollbars are displayed only if               necessary. Content that extends beyond the remaining visible
                        *                 area is clipped.
                        *  Horizontal and vertical scrollbars are always drawn inside the               widget. Content that extends beyond the remaining visible area
                        *                 is clipped, and can be accessed via scrolling.
                        *  Clip horizontally but extend the canvas's clip region               vertically if necessary. Note: only supported for
                        *                 specific widget subclasses.
                        *  Clip vertically but extend the canvas's clip region               horizontally if necessary. Note: only supported
                        *                 for specific widget subclasses.
                        */
                       String /* visible |  hidden |  auto |  scroll |  clip-h |  clip-v */ = definedExternally
    /**
     *  Indicates that this component is able to render itself at multiple possible sizes, in order
     *   to fit into less space when very little space is available, or to display more information
     *   or provide more immediate access to functionality when more space is available.
     * 
     *   Unlike simply indicating a flexible size via width:"\*", setting canAdaptWidth
     *   indicates that a component has 2 (or more) different ways of rendering itself with different
     *   discrete sizes, but does not have the ability to use every additional available pixel.
     * 
     *   For example, a menu embedded in a toolbar might show as only a fixed-size icon which reveals
     *   menu options when clicked, or if enough space is available, could show all of the menu
     *   options directly in the toolbar. In this example, the menu should either be allocated just
     *   enough space for an icon, or enough space for all options to appear inline; any other
     *   amount of space being allocated is just a waste.
     * 
     *   When a component with canAdaptWidth is part of a Layout, Canvas.adaptWidthBy
     *   will be called every time component sizes are being calculated, passing a positive or
     *   negative pixel value:
     * 
     * 
     *  - a positive pixel value indicates a surplus - all other component's minimum sizes
     *     can be accommodated, including any Canvas.minWidth declared on the
     *     canAdaptWidth component itself
     * 
     *  - a negative pixel value indicates that the containing layout is going to be
     *     forced to Overflow (introduce scrollbars, clip content, etc) unless some
     *     component or set of components gives up at least this many pixels
     * 
     * 
     *   If a non-zero value is returned from adaptWidthBy, this means that the
     *   component is willing to shrink or expand by that many pixels. Returning 0 means that the
     *   component is unable to reduce size further, or for a surplus, cannot make good use of the
     *   surplus space.
     * 
     * 
     *  - A call to Canvas.adaptWidthBy may surrender as many pixels as desired
     *   (as long as the widget won't drop below its minimum allowed width), no matter whether a
     *   positive (surplus) or negative (overflow) pixel value is supplied, but
     * 
     *  - A call to Canvas.adaptWidthBy may not increase its size by more than the number of
     *   offered pixels - so if an overflow is present, it may not increase its size at all.
     * 
     * 
     *   Note that when the initial width is specified as a stretch size (e.g. "\*"), then after
     *   Canvas.adaptWidthBy is called, the Framework will stretch (but not shrink) the
     *   member like any other stretch-size Layout member, but the unadaptedWidth
     *   argument will always reflect the unstretched width requested by the previous call to
     *   Canvas.adaptWidthBy. This behavior may be disabled by specifying the initial
     *   width as a number, or leaving it unspecified.
     * 
     *   Behavior is slightly different for overflow: "visible" members - in this case the
     *   unadaptedWidth passed in will reflect the current visible width of the
     *   member, rather than the last width requested by the previous call to
     *   Canvas.adaptWidthBy or the specified width (on the first call). However, note that the
     *   visible length will match your requested width unless the member is actually overflowed.
     *   Stretch sizing is not supported for adaptive-width members with overflow: "visible".
     * 
     *   Caution: you must either determine the current size of the canvas by maintaining your own
     *   internal state, or use the unadaptedWidth parameter passed to
     *   Canvas.adaptWidthBy. You must not call Canvas.getWidth or Canvas.getVisibleWidth
     *   on the canvas itself inside Canvas.adaptWidthBy as the size is in the processing of
     *   being determined, but you may draw children or call Canvas.getVisibleWidth on them, as
     *   we guarantee that the adaptive-width canvas is drawn before the first call to
     *   Canvas.adaptWidthBy. An example of drawing children in Canvas.adaptWidthBy to
     *   compute overall width may be seen in the
     *   ${isc.DocUtils.linkForExampleId('inlinedMenuMobileSample', 'Inlined Menu Mobile Sample')}.
     * 
     *   Note that reasonable settings for Canvas.minWidth should be applied to all other
     *   flexible-sized members of a layout where a canAdaptWidth component appears,
     *   because when too little space is available, a canAdaptWidth component will
     *   absorb all available space until minimums for other components are hit (or the
     *   canAdaptWidth component reaches its maximum size). If more than one
     *   canAdaptWidth component is present, Canvas.adaptiveWidthPriority to give priority
     *   to a particular component when allocating space.
     * 
     *   All of the above behaviors are exactly the same for height, using
     *   Canvas.canAdaptHeight and Canvas.adaptHeightBy.
     *  @type {boolean}
     *  @default null
     */
    open var canAdaptWidth: Boolean = definedExternally
    /**
     *  See Canvas.canAdaptWidth.
     *  @type {boolean}
     *  @default null
     */
    open var canAdaptHeight: Boolean = definedExternally
    /**
     *  If multiple widgets in the same Layout have Canvas.canAdaptWidth,
     *   adaptiveWidthPriority can be set to indicate which of the components should be
     *   given priority access to space.
     * 
     *   The widget with the highest priority setting will be offered surplus space first, and asked
     *   to give up space last. Lack of a priority setting is treated as zero. Any adaptive widgets
     *   with the same priority setting will be asked to give up or release space according to their
     *   order in Layout.members.
     *  @type {Integer}
     *  @default null
     */
    open var adaptiveWidthPriority: Number = definedExternally
    /**
     *  See Canvas.adaptiveWidthPriority.
     *  @type {Integer}
     *  @default null
     */
    open var adaptiveHeightPriority: Number = definedExternally
    /**
     *  Whether to use the browser's native scrollbars or SmartClient-based scrollbars.
     * 
     *   SmartClient-based scrollbars are skinnable, giving you complete control over look and
     *   feel. SmartClient-based scrollbars also enable some interactions not possible with
     *   native scrollbars, such as ListGrid.fixedRecordHeights
     *   in grids in combination with ListGrid.dataPageSize.
     * 
     *   Native browser scrollbars are slightly faster simply because there are less SmartClient
     *   components that need to be created, drawn and updated. Each visible SmartClient-based
     *   scrollbar on the screen has roughly the impact of two StretchImgButtons.
     * 
     *   SmartClient is always aware of the size of the scrollbar, regardless of whether native
     *   or custom scrollbars are used, and regardless of what operating system and/or operating
     *   system "theme" or "skin" is in use. This means SmartClient will correctly report the
     *   Canvas.getViewportHeight, that is, the interior area of the
     *   widget excluding space taken by scrollbars, which is key for exactly filling a component
     *   with content without creating unnecessary scrolling.
     * 
     *   The showCustomScrollbars setting is typically overridden in load_skin.js in
     *   order to change the default for all SmartClient components at once.
     *   This may be achieved via the static Canvas.setShowCustomScrollbars method or
     *   via a simple addProperties block, like so:
     * 
     *     isc.Canvas.addProperties({ showCustomScrollbars:false });
     * 
     * 
     *   On Browser.isTouch, custom scrollbars are disabled in favor of enabling
     *   native touch scrolling if available. However, custom scrollbars and native touch
     *   scrolling can be enabled for the component by setting Canvas.alwaysShowScrollbars
     *   to true.
     *  @type {boolean}
     *  @default true
     */
    open var showCustomScrollbars: Boolean = definedExternally
    /**
     *  Whether this canvas should receive eventHandling from its scrollbars,
     *   which are Canvas.peers. Normally, a canvas only gets bubbled events from
     *   its Canvas.children.
     * 
     *   Note that this property only has an impact if Canvas.showCustomScrollbars is true.
     *  @type {boolean}
     *  @default true
     */
    open var receiveScrollbarEvents: Boolean = definedExternally
    /**
     *  On Browser.isTouch that support native touch scrolling, if
     *   Canvas.showCustomScrollbars is true and touch
     *   scrolling has not been disabled by the Canvas.useTouchScrolling and/or
     *   Canvas.disableTouchScrollingForDrag settings, should custom scrollbars and
     *   native touch scrolling be enabled for this component? If false or unset,
     *   then only native touch scrolling will be enabled. If true, then both scrolling
     *   mechanisms will be enabled.
     * 
     *   NOTE: Because native touch scrolling (also called momentum scrolling)
     *   is computationally intensive, some mobile browsers implement an optimization where the state
     *   of the DOM for the element being scrolled will be frozen or partially frozen during
     *   the scroll animation. This results in a delay between when the scroll position reaches
     *   a certain point in the animation and when the positions of the custom scrollbar thumbs
     *   are updated to reflect that scroll position.
     *  @type {boolean}
     *  @default null
     */
    open var alwaysShowScrollbars: Boolean = definedExternally
    /**
     *  On Browser.isTouch, if this Canvas can be scrolled,
     *   should touch-dragging the content area result in scrolling? Set to false
     *   if touch-dragging should not cause scrolling. Note that setting to false
     *   enables the use of Canvas.showCustomScrollbars on touch devices.
     * 
     *   useTouchScrolling can default to false if
     *   Canvas.disableTouchScrollingForDrag is true
     *   and various built-in drag operations are enabled that normally interfere with touch scrolling
     *   (e.g. ListGrid.canDragSelect and ListGrid.canReorderRecords).
     * 
     *   When touch scrolling is disabled, it can be difficult to interact with parts of the
     *   custom scrollbars at their default size of 16 pixels. In touch browsers, any touch 8px
     *   before the thumb of a Scrollbar will be mapped to the thumb, but
     *   the other parts of the scrollbar do not have a similar tolerance applied. The width of
     *   the custom scrollbars can be increased by setting the Canvas.scrollbarSize to a
     *   larger value, but note that when skinning, changing the
     *   scrollbarSize may cause tiling of certain images and backgrounds that make
     *   up the custom scrollbar. This can be fixed for a component by creating it with
     *   Canvas.scrollbarConstructor set to "Scrollbar"&mdash;a basic scrollbar class that
     *   does not employ spriting.
     *  @type {boolean}
     *  @default null
     */
    open var useTouchScrolling: Boolean = definedExternally
    /**
     *  Disables Canvas.useTouchScrolling whenever a built-in drag operation has been enabled which is
     *   known to be non-functional if touch scrolling is enabled. Default behavior is to leave touch
     *   scrolling enabled even if it makes other enabled drag operations non-functional, since any
     *   accessibility application must provide an alternative way to perform
     *   drag and drop operations anyway.
     * 
     *   disableTouchScrollingForDrag exists so that applications can change the default
     *   setting on a per-component basis (via
     *   Class.changeDefaults),
     *   in order to make a system-wide or
     *   per-component-type decision about whether to favor touch scrolling vs retaining the ability to
     *   drag and drop via finger drags, instead of having to set useTouchScrolling on each
     *   individual instance.
     * 
     *   See the mobileDevelopment for more background
     *   information.
     *  @type {boolean}
     *  @default null
     */
    open var disableTouchScrollingForDrag: Boolean = definedExternally
    /**
     *  How thick should we make the scrollbars for this canvas. This only applies if
     *   Canvas.showCustomScrollbars is true.
     * 
     *   NOTE: When skinning, changing the
     *   scrollbarSize may cause tiling of certain images and backgrounds that make
     *   up the custom scrollbar. This can be fixed for a component by creating it with
     *   Canvas.scrollbarConstructor set to "Scrollbar"&mdash;a basic scrollbar class
     *   that does not employ spriting.
     *  @type {number}
     *  @default "16"
     */
    open var scrollbarSize: Number = definedExternally
    /**
     *  The class that will be used to create custom scrollbars for this component. Set this
     *   attribute to a Scrollbar subclass with e.g. a different skinImgDir, to customize scrollbar
     *   appearance for this component only.
     * 
     *   When skinning and supported by the skin, the default
     *   scrollbarConstructor is changed to a different scrollbar class which handles
     *   scrollbar spriting. Spriting of the scrollbars of an individual component can therefore
     *   be disabled by creating the component with scrollbarConstructor set to the
     *   "Scrollbar" class. "Scrollbar" is a basic scrollbar class that does not employ spriting.
     *  @type {string}
     *  @default "Scrollbar"
     */
    open var scrollbarConstructor: String = definedExternally
    /**
     *  If set to true, the widget will be disabled. A widget is only considered enabled
     *   if it is individually enabled and all parents above it in the containment hierarchy
     *   are enabled. This allows you to enable or disable all components of a complex
     *   nested widget by enabling or disabling the top-level parent only.
     *  @type {boolean}
     *  @default false
     */
    open var disabled: Boolean = definedExternally
    /**
     *  If set to true, this widget will be enabled, if set to false, or null, this
     *   widget will be disabled.
     *  @deprecated \* As of SmartClient version 5.5 this property has been deprecated. The  Canvas.disabled property will be used to govern enabled/disabled state instead
     *   if this.enabled has not been changed from its default value.
     *  @type {boolean}
     *  @default "unset"
     */
    open var enabled: Boolean = definedExternally
    /**
     *  Criteria to be evaluated to determine whether this Canvas should be visible. Re-evaluated
     *   whenever data in the Canvas.ruleScope changes.
     * 
     *   A basic criteria uses textMatchStyle:"exact". When specified in
     *   componentXML this property allows
     *   xmlCriteriaShorthand for defining criteria.
     *  @type {AdvancedCriteria}
     *  @default null
     */
    open var visibleWhen: AdvancedCriteria = definedExternally
    /**
     *  Criteria to be evaluated to determine whether this Canvas should be enabled. Re-evaluated
     *   whenever data in the Canvas.ruleScope changes.
     * 
     *   A basic criteria uses textMatchStyle:"exact". When specified in
     *   componentXML this property allows
     *   xmlCriteriaShorthand for defining criteria.
     *  @type {AdvancedCriteria}
     *  @default null
     */
    open var enableWhen: AdvancedCriteria = definedExternally
    /**
     *  Should this element be redrawn in response to a resize?
     * 
     *   Should be set to true for components whose Canvas.getInnerHTML will not
     *   automatically reflow to fit the component's new size.
     *  @type {boolean}
     *  @default null
     */
    open var redrawOnResize: Boolean = definedExternally
    /**
     *  Can this widget be allowed to become the target of keyboard events?
     * 
     *   If canFocus is unset (the default), only scrollable widgets with visible scrollbars are
     *   focusable, to allow for keyboard scrolling.
     * 
     *   A widget normally receives focus by being clicked on or tabbed to.
     *  @type {boolean}
     *  @default null
     */
    open var canFocus: Boolean = definedExternally
    /**
     *  If specified this governs the tabIndex of the widget in the page's tab order.
     *   Setting this value to -1 will ensure the canvas does not show up
     *   in the page's tab order, though if Canvas.canFocus is true, the user
     *   may still give it keyboard focus by clicking on the widget directly.
     * 
     *   By default SmartClient auto-assigns tab-indices, ensuring focusable widgets
     *   are reachable by tabbing in an intuitive order based on widget hierarchy and
     *   draw order. Specifying an explicit tab index means a widget will not participate
     *   in this automatic tab position allocation and is typically not recommended except
     *   for very simple cases.
     * 
     *   For more information on automatic tab index assignment, including recommended
     *   approaches for customizing tab order assignation, see the tabOrderOverview.
     *   Developers may call Canvas.clearExplicitTabIndex to clear any explicitly
     *   assigned tab index, and have the widget participate in automatic tab position allocation.
     * 
     *   canvas.tabIndex cannot be set to greater than
     *   Canvas.TAB_INDEX_FLOOR - as we reserve the values above this range for
     *   auto-assigned tab-indices.
     *  @type {number}
     *  @default null
     */
    open var tabIndex: Number = definedExternally
    /**
     *  If specified this governs the HTML accessKey for the widget.
     * 
     *   This should be set to a character - when a user hits the html accessKey modifier for
     *   the browser, plus this character, focus will be given to the widget in question.
     *   The accessKey modifier can vary by browser and platform.
     * 
     *   The following list of default behavior is for reference only, developers should also
     *   consult browser documentation for additional information.
     * 
     * 
     *  - Internet Explorer (all platforms): Alt + accessKey
     * 
     *  - Mozilla Firefox (Windows, Unix): Alt+Shift + accessKey
     * 
     *  - Mozilla Firefox (Mac): Ctrl+Opt + accessKey
     * 
     *  - Chrome and Safari (Windows, Unix): Alt + accessKey
     * 
     *  - Chrome and Safari (Mac): Ctrl+Opt + accessKey
     * 
     *  @type {string}
     *  @default null
     */
    open var accessKey: String = definedExternally
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
     *  Default class used to construct menus created by this component, including context menus.
     *  @type {SCClassName}
     *  @default "Menu"
     */
    open var menuConstructor: String = definedExternally
    /**
     *  Prompt displayed in hover canvas if Canvas.showHover is true.
     *  @type {HTMLString}
     *  @default null
     */
    open var prompt: String = definedExternally
    /**
     *  If set, native HTML5 drag and drop will be used for all drags initiated on this widget
     *   (on browsers where this is supported).
     * 
     *   When using native HTML5 drags, the same series of events fires as for a normal drag
     *   (Canvas.dragStart, Canvas.dropMove, etc.), and the Canvas.dragType / Canvas.dropTypes
     *   system works. Canvas.dragAppearance is not supported; however,
     *   basic customization of the browser's tracker image is supported in certain browsers via
     *   the EventHandler.setDragTrackerImage API.
     * 
     *   The primary difference with a native drag is that it can be cross-frame; that is, the
     *   user can drag out of the current browser window and drop into a different window or tab.
     * 
     *   To provide information that will be available to a foreign frame, use
     *   EventHandler.setNativeDragData. This API must be called when the Canvas.dragStart
     *   event fires, and will not work if called at any other time.
     * 
     *   However, due to browser bugs and/or browser-imposed limitations, the information provided to
     *   setNativeDragData cannot be accessed in the foreign frame until the actual drop
     *   occurs (mouse button released). This means drop eligibility cannot be determined dynamically
     *   based on the dragged data; instead, eligibility can only be determined based on the
     *   Canvas.dragType / Canvas.dropTypes system. For this reason, a Canvas.dragType must
     *   be set on the source of a drag.
     * 
     *   NOTE: Although Internet Explorer 10+ and Edge support a subset of the
     *   HTML5 drag and drop standard,
     *   native drag and drop is disabled in IE and Edge because cross-window drags&mdash;the
     *   primary purpose of this API&mdash;are not possible.
     *  @type {boolean}
     *  @default null
     */
    open var useNativeDrag: Boolean = definedExternally
    /**
     *  Indicates whether this widget can initiate custom drag-and-drop operations (other than
     *   reposition or resize). Normally Canvas.canDragReposition or Canvas.canDragResize would
     *   be used instead of this property.
     * 
     *   Note: this property may be manipulated by higher-level dragging semantics.
     * 
     *   If Canvas.useNativeDrag is true and this widget has been drawn, then this widget must be
     *   Canvas.redraw in order for a change of the value of this attribute to take effect.
     *  @type {boolean}
     *  @default false
     */
    open var canDrag: Boolean = definedExternally
    /**
     *  Number of pixels the cursor needs to move before the EventHandler starts a drag operation.
     *  @type {number}
     *  @default "5"
     */
    open var dragStartDistance: Number = definedExternally
    /**
     *  If this Canvas is canAcceptDrop:true, when the user drags a droppable widget over
     *     an edge of the widget, should we scroll to show the rest of the widget's content?
     *     Returned from canvas.shouldDragScroll() if there are scrollbars.
     *  @type {boolean}
     *  @default true
     */
    open var canDragScroll: Boolean = definedExternally
    /**
     *  If this widget supports drag-scrolling, This property specifies how many ms the
     *     user must hover over the drag-scroll threshold before scrolling begins.
     *  @type {number}
     *  @default "100"
     */
    open var dragScrollDelay: Number = definedExternally
    /**
     *  This indicates how the system will test for droppable targets: either by intersection
     *   with the mouse or intersection with the rectangle of the dragMoveTarget.
     *  @type {DragIntersectStyle}
     *  @default "mouse"
     */
    open var dragIntersectStyle: 
                                 /**
                                  *  Look for drop targets that are under the current mouse cursor position.
                                  *  Look for drop targets by intersection of the entire rect of the drag        target with the droppable target.
                                  */
                                 String /* mouse |  rect */ = definedExternally
    /**
     *  Indicates whether this widget can be moved by a user of your application by simply
     *     dragging with the mouse.
     *  @type {boolean}
     *  @default false
     */
    open var canDragReposition: Boolean = definedExternally
    /**
     *  Cursor to switch to if the mouse is over a widget that is drag repositionable.
     *  @type {Cursor}
     *  @default "move"
     */
    open var dragRepositionCursor: 
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
     *  Indicates whether this widget can be resized by dragging on the edges and/or corners of
     *     the widget with the mouse.
     *  @type {boolean}
     *  @default false
     */
    open var canDragResize: Boolean = definedExternally
    /**
     *  If Canvas.canDragResize is true, this property specifies the conditions for when
     *   proportional resizing is used. The default is "none"
     * 
     *   , which means that proportional resizing is disabled.
     *  @type {ProportionalResizeMode}
     *  @default "none"
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
     *  If Canvas.proportionalResizing is set to "modifier"
     * 
     *   or "modifierOff"
     * 
     *   then proportional resizing of the widget is activated or deactivated, respectively,
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
     *  When drag resizing is enabled via Canvas.canDragResize, restricts resizes to only
     *   certain edges or corners.
     * 
     *   The default of null indicates the widget can be resized from any corner or edge (if
     *   canDragResize is true).
     * 
     *   To restrict resizing to only certain corners, set resizeFrom to an Array of
     *   EdgeNames.
     *  @type {Array<Partial<EdgeName>>}
     *  @default null
     */
    open var resizeFrom: Array<dynamic> = definedExternally
    /**
     *  This flag controls whether we register the component as a maskable item with the
     *   EventHandler. If enabled, a backmask will be automatically created for the
     *   dragMoveTarget on the fly to avoid burnthrough e.g. by plugins or frames.
     * 
     *   Note that this property will be defaulted to false unless the canvas contains an
     *   IFrame, in which case it will be defaulted to true.
     * 
     *   The Canvas.dragMaskType property controls what kind of mask is used in case
     *   useDragMask is enabled.
     *  @type {boolean}
     *  @default null
     */
    open var useDragMask: Boolean = definedExternally
    /**
     *  This property controls what kind of mask is used in case Canvas.useDragMask is
     *   enabled.
     *  @type {DragMaskType}
     *  @default "div"
     */
    open var dragMaskType: 
                           /**
                            *  creates an element with ordinary HTML content that will block events
                            *  creates an iframe with empty content
                            *  hides the contents of this widget temporarily
                            *  no mask
                            */
                           String /* div |  iframe |  hide |  none */ = definedExternally
    /**
     *  Will this Canvas fire hover events when the user hovers over it, or one of its children?
     *  @type {boolean}
     *  @default null
     */
    open var canHover: Boolean = definedExternally
    /**
     *  If this.canHover is true, how long should the mouse be kept over this
     *   widget before the hover event is fired
     *  @type {number}
     *  @default "300"
     */
    open var hoverDelay: Number = definedExternally
    /**
     *  If this.canHover is true, should we show the global hover canvas by default
     *   when the user hovers over this canvas?
     *  @type {boolean}
     *  @default true
     */
    open var showHover: Boolean = definedExternally
    /**
     *  If Canvas.showHover is true, this property can be used to customize
     *   the width of the hover canvas shown. See also Canvas.hoverAutoFitWidth and
     *   Canvas.hoverAutoFitMaxWidth.
     *  @type {Integer}
     *  @default "1"
     */
    open var hoverWidth: Number = definedExternally
    /**
     *  if Canvas.showHover is true, this property will cause the specified
     *   Canvas.hoverWidth to be treated as a minimum width for the hover. If the
     *   hover content string exceeds this, the hover will expand to accomodate it
     *   up to Canvas.hoverAutoFitMaxWidth (without the text wrapping).
     * 
     *   Using this settings differs from simply disabling wrapping via
     *   Canvas.hoverWrap as the content will wrap if the
     *   Canvas.hoverAutoFitMaxWidth is exceeded.
     *  @type {boolean}
     *  @default true
     */
    open var hoverAutoFitWidth: Boolean = definedExternally
    /**
     *  Maximum auto-fit width for a hover if Canvas.hoverAutoFitWidth is
     *   enabled. May be specified as a pixel value, or a percentage of page width.
     *  @type {number | string}
     *  @default "100"
     */
    open var hoverAutoFitMaxWidth: dynamic = definedExternally
    /**
     *  If this.showHover is true, this property can be used to customize the
     *   height of the hover canvas shown.
     *  @type {Integer}
     *  @default null
     */
    open var hoverHeight: Number = definedExternally
    /**
     *  If this.showHover is true, this property can be used to customize the
     *   alignment of content in the hover canvas.
     *  @type {Alignment}
     *  @default null
     */
    open var hoverAlign: 
                         /**
                          *  Center within container.
                          *  Stick to left side of container.
                          *  Stick to right side of container.
                          */
                         String /* center |  left |  right */ = definedExternally
    /**
     *  If this.showHover is true, this property can be used to customize the
     *   vertical alignment of content in the hover canvas.
     *  @type {VerticalAlignment}
     *  @default null
     */
    open var hoverVAlign: 
                          /**
                           *  At the top of the container
                           *  Center within container.
                           *  At the bottom of the container
                           */
                          String /* top |  center |  bottom */ = definedExternally
    /**
     *  If this.showHover is true, this property can be used to customize the
     *   whether content in the hover canvas is displayed in a single line, or wraps.
     * 
     *   Note that if developers wish to have hovers expand horizontally to fit their
     *   text without wrapping \*up to some maximum\*, and then wrap rather than exceeding
     *   that maximum, the Canvas.hoverAutoFitWidth and Canvas.hoverAutoFitMaxWidth attributes
     *   may be used instead of simply setting hoverWrap to false.
     *  @type {boolean}
     *  @default null
     */
    open var hoverWrap: Boolean = definedExternally
    /**
     *  If this.showHover is true, this property can be used to specify the
     *   css style to apply to the hover canvas.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var hoverStyle: String = definedExternally
    /**
     *  If this.showHover is true, should the hover canvas be shown with opacity
     *   other than 100?
     *  @type {number}
     *  @default null
     */
    open var hoverOpacity: Number = definedExternally
    /**
     *  If this.showHover is true, should this widget's hover canvas be moved with
     *   the mouse while visible?
     *  @type {boolean}
     *  @default null
     */
    open var hoverMoveWithMouse: Boolean = definedExternally
    /**
     *  If this.showHover is true and Canvas.getHoverComponent is implemented, should
     *   the hoverCanvas returned from it be automatically destroyed when it is hidden?
     * 
     *   The default of null indicates that the component will be automatically
     *   destroyed. Set to false to prevent this.
     *  @type {boolean}
     *  @default null
     */
    open var hoverAutoDestroy: Boolean = definedExternally
    /**
     *  How far into the edge of an object do we consider the "edge" for drag resize purposes?
     *  @type {number}
     *  @default "5"
     */
    open var edgeMarginSize: Number = definedExternally
    /**
     *  If the widget has drag resize configured on one or more of it's edges, and the
     *   edgeMarginSize is large enough that the remaining space is less than
     *   minNonEdgeSize, the edgeMarginSize will be reduced such that the non-edge
     *   part of the widget is at least 1/3 of the total space (with two draggable edges) or half
     *   of it (with one draggable edge).
     *  @type {Integer}
     *  @default "0"
     */
    open var minNonEdgeSize: Number = definedExternally
    /**
     *  Cursor to use when over each edge of a Canvas that is drag resizable.
     * 
     *   To disable drag resize cursors, set the edgeCursorMap property to null.
     *  @type {object}
     *  @default "{...}"
     */
    open var edgeCursorMap: dynamic = definedExternally
    /**
     *  Constrains drag-resizing and drag-repositioning of this canvas to either the rect of its
     *   parent (if set to true) or an arbitrary rect based on its parent (if set to a
     *   [Left,Top,Width,Height] rect array). In the latter mode you may use negative offsets
     *   for left/top and a width/height greater than the visible or scroll width of the parent
     *   to allow positioning beyond the confines of the parent.
     * 
     *   If this canvas has no parent, constrains dragging to within the browser window.
     * 
     *   Affects target and outline dragAppearance, not tracker.
     * 
     *   Note: keepInParentRect affects only user drag interactions, not programmatic moves.
     * 
     *   Example use cases:
     *   keepInParentRect: true - confine to parent
     *   keepInParentRect: [0, 0, 500, 500] - confine to top left 500x500 region within parent
     *   keepInParentRect: [0, 0, 10000, 10000] - in combination with
     *   overflow: "auto", confine to parent, but allow moving off the right and bottom of the
     *   parent to force scrolling (and hence enlarge the scrollWidth of the parent).
     *  @type {boolean | Array<Partial<Integer>>}
     *  @default null
     */
    open var keepInParentRect: dynamic = definedExternally
    /**
     *  Visual appearance to show when the object is being dragged. May be overridden for
     *   dragResize or dragReposition events via Canvas.dragResizeAppearance
     *   and Canvas.dragRepositionAppearance.
     *  @type {DragAppearance}
     *  @default "outline"
     */
    open var dragAppearance: 
                             /**
                              *  No default drag appearance is indicated. Your custom dragging routines should
                              *     implement some behavior that indicates that the user is in a dragging situation,
                              *     and where the mouse is.
                              *  A "drag tracker" object is automatically shown and moved around with the
                              *     mouse. This is generally set to an icon that represents what is being dragged. The
                              *     default tracker is a 10 pixel black square, but you can customize this icon. This
                              *     dragAppearance is not recommended for use with drag resizing or drag moving.
                              *  The target object is actually moved, resized, etc. in real time. This is
                              *     recommended for drag repositioning, but not for drag resizing of complex objects.
                              *  An outline the size of the target object is moved, resized, etc. with the
                              *     mouse. This is recommended for drag resizing, especially for objects that take a
                              *     significant amount of time to draw.
                              */
                             String /* none |  tracker |  target |  outline */ = definedExternally
    /**
     *  If Canvas.canDragResize is true, this attributes specifies the visual appearance
     *   to show during drag resize. If unset Canvas.dragAppearance will be used.
     *  @type {DragAppearance}
     *  @default null
     */
    open var dragResizeAppearance: 
                                   /**
                                    *  No default drag appearance is indicated. Your custom dragging routines should
                                    *     implement some behavior that indicates that the user is in a dragging situation,
                                    *     and where the mouse is.
                                    *  A "drag tracker" object is automatically shown and moved around with the
                                    *     mouse. This is generally set to an icon that represents what is being dragged. The
                                    *     default tracker is a 10 pixel black square, but you can customize this icon. This
                                    *     dragAppearance is not recommended for use with drag resizing or drag moving.
                                    *  The target object is actually moved, resized, etc. in real time. This is
                                    *     recommended for drag repositioning, but not for drag resizing of complex objects.
                                    *  An outline the size of the target object is moved, resized, etc. with the
                                    *     mouse. This is recommended for drag resizing, especially for objects that take a
                                    *     significant amount of time to draw.
                                    */
                                   String /* none |  tracker |  target |  outline */ = definedExternally
    /**
     *  If Canvas.canDragReposition is true, this attributes specifies the visual appearance
     *   to show during drag reposition. If unset Canvas.dragAppearance will be used.
     *  @type {DragAppearance}
     *  @default null
     */
    open var dragRepositionAppearance: 
                                       /**
                                        *  No default drag appearance is indicated. Your custom dragging routines should
                                        *     implement some behavior that indicates that the user is in a dragging situation,
                                        *     and where the mouse is.
                                        *  A "drag tracker" object is automatically shown and moved around with the
                                        *     mouse. This is generally set to an icon that represents what is being dragged. The
                                        *     default tracker is a 10 pixel black square, but you can customize this icon. This
                                        *     dragAppearance is not recommended for use with drag resizing or drag moving.
                                        *  The target object is actually moved, resized, etc. in real time. This is
                                        *     recommended for drag repositioning, but not for drag resizing of complex objects.
                                        *  An outline the size of the target object is moved, resized, etc. with the
                                        *     mouse. This is recommended for drag resizing, especially for objects that take a
                                        *     significant amount of time to draw.
                                        */
                                       String /* none |  tracker |  target |  outline */ = definedExternally
    /**
     *  Sets a dragType for this widget used, to be compared to
     *   Canvas.dropTypes on possible drop target widgets. See
     *   Canvas.dropTypes for a full explanation.
     *  @type {string}
     *  @default null
     */
    open var dragType: String = definedExternally
    /**
     *  When a drag and drop interaction occurs, if a Canvas.dragType is
     *   configured on the source widget, it is compared to the dropTypes configured
     *   on the target widget, and a drop is only allowed if the dragType is listed
     *   in the target widget's dropTypes array.
     * 
     *   The default setting means any dragType is eligible for dropping on this
     *   widget, including no dragType setting.
     * 
     *   See also Canvas.willAcceptDrop for dynamic determination of drop eligibility.
     *  @type {Array<Partial<string>> | string}
     *  @default "\*\*anything\*\*"
     */
    open var dropTypes: dynamic = definedExternally
    /**
     *  A different widget that should be actually dragged when dragging initiates on this
     *   widget. One example of this is to have a child widget that drags its parent, as with a
     *   drag box. Because the parent automatically repositions its children, setting the drag
     *   target of the child to the parent and then dragging the child will result in both
     *   widgets being moved.
     *   Valid dragTarget values are:
     *   - null (default) [this widget is its own drag target]
     *   - another widget, or widget ID
     *   - "parent" drag target is this widget's
     *    Canvas.getParentCanvas
     *   - "top" drag target is this widget's
     *    Canvas.topElement
     *  @type {Canvas | string}
     *  @default null
     */
    open var dragTarget: dynamic = definedExternally
    /**
     *  When this widget is dragged, if its dragAppearance is "target", should
     *   we show a shadow behind the canvas during the drag.
     *  @type {boolean}
     *  @default null
     */
    open var showDragShadow: Boolean = definedExternally
    /**
     *  If this widget has dragAppearance "target", this value specifies the
     *   opacity to render the target while it is being dragged. A null value implies we do
     *   not modify the opacity.
     *  @type {Integer}
     *  @default null
     */
    open var dragOpacity: Number = definedExternally
    /**
     *  Indicates that this object can be dropped on top of other widgets. Only valid if
     *   canDrag or canDragReposition is true.
     *  @type {boolean}
     *  @default false
     */
    open var canDrop: Boolean = definedExternally
    /**
     *  Indicates that this object can receive dropped widgets (i.e. other widgets can be
     *   dropped on top of it).
     *  @type {boolean}
     *  @default false
     */
    open var canAcceptDrop: Boolean = definedExternally
    /**
     *  When explicitly set to false, disallows drop before this member in the Layout.
     *  @type {boolean}
     *  @default null
     */
    open var canDropBefore: Boolean = definedExternally
    /**
     *  Amount of time (in milliseconds) before mouseStillDown events start to be fired
     *   repeatedly for this canvas. See Canvas.mouseStillDown for details.
     *  @type {Integer}
     *  @default "400"
     */
    open var mouseStillDownInitialDelay: Number = definedExternally
    /**
     *  Amount of time (in milliseconds) between repeated 'mouseStillDown' events for this
     *   canvas. See Canvas.mouseStillDown for details.
     *  @type {Integer}
     *  @default "100"
     */
    open var mouseStillDownDelay: Number = definedExternally
    /**
     *  Amount of time (in milliseconds) between which two clicks are considered a single click
     *  @type {Integer}
     *  @default "250"
     */
    open var doubleClickDelay: Number = definedExternally
    /**
     *  If true, this canvas will receive all mouse-clicks as single Canvas.click
     *   events rather than as Canvas.doubleClick events.
     *  @type {boolean}
     *  @default null
     */
    open var noDoubleClicks: Boolean = definedExternally
    /**
     *  In earlier versions of Internet Explorer (pre IE9), a native limitation
     *   exists whereby if HTML elements are
     *   overlapping on the page, certain elements can appear to "burn through"
     *   elements in the same position with a higher z-index.
     *   Specific cases in which this have been observed include Applets,
     *   &lt;IFRAME&gt; elements, and for
     *   older versions of IE, native &lt;SELECT&gt; items.
     * 
     *   The backMask is a workaround for this issue. If useBackMask is
     *   set to true, the component will render an empty &lt;IFRAME&gt; element
     *   behind the canvas, which prevents this effect in all known cases.
     * 
     *   Has no effect in other browsers.
     *  @type {boolean}
     *  @default false
     */
    open var useBackMask: Boolean = definedExternally
    /**
     *  If this canvas has its size specified as a percentage, this property allows the user to
     *   explicitly designate another canvas upon which sizing will be based.
     * 
     *   If unset percentage sizing is based on
     *   - the Canvas.getMasterCanvas if there is one and
     *    Canvas.snapTo is set,
     *   - otherwise on the amount of space available in this widget's parent canvas, if this is
     *    a child of some other widget
     *   - otherwise the page size.
     *  @type {Canvas}
     *  @default null
     */
    open var percentSource: Canvas = definedExternally
    /**
     *  Governs the model to be used when sizing canvases with percentage width or height, or
     *   positioning widgets with a specified Canvas.snapTo.
     * 
     *   Only affects widgets with a a specified Canvas.percentSource, or
     *   widgets that have Canvas.snapTo set and are peers of some
     *   Canvas.getMasterCanvas.
     * 
     *   Determines whether the coordinates used for sizing (for percentage sized widgets) and
     *   positioning (if snapTo is set) should be relative to the visible size or the
     *   viewport size of the percentSource or Canvas.getMasterCanvas widget.
     *  @type {PercentBoxModel}
     *  @default "visible"
     */
    open var percentBox: 
                         /**
                          *  use coordinates relative to the {Canvas.getVisibleHeight,visibleHeight} and width of the other canvas
                          *  use coordinates relative to the {Canvas.getViewportHeight,viewportHeight} and width of the other canvas
                          */
                         String /* visible |  viewport */ = definedExternally
    /**
     *  Position this widget such that it is aligned with ("snapped to") an edge of its
     *   Canvas.getMasterCanvas (if specified), or its
     *   Canvas.getParentCanvas.
     * 
     *   Note that this property also impacts the sizing of this widget. If this widgets size
     *   is specified as a percent value, and has no explicit
     *   Canvas.percentSource, sizing will be calculated based on the size of the
     *   Canvas.getMasterCanvas when snapTo is set.
     * 
     *   Possible values: BR, BL, TR, TL, R, L, B, T, C where B=Bottom, T=Top, L=Left, R=right
     *   and C=center
     * 
     *   Standard snapTo behavior will attach the outer edge of the widget to the parent or master
     *   element - for example setting snapTo to "B" would align the
     *   bottom edge of this component with the bottom edge of the master or parent element
     *   (and center this component horizontally over its master or parent element).
     *   Canvas.snapEdge can be specified to change this behavior allowing the developer
     *   to, for example, align the top edge of this component with the bottom edge of its
     *   Canvas.getMasterCanvas.
     * 
     *   Canvas.snapOffsetLeft and Canvas.snapOffsetTop may also be specified to
     *   offset the element from exact snapTo alignment.
     *  @type {string}
     *  @default null
     */
    open var snapTo: String = definedExternally
    /**
     *  If Canvas.snapTo is defined to this widget, this property can be used to
     *   define which edge of this widget should be snapped to an edge of the master or parent
     *   element.
     * 
     *   If unspecified the, default snapTo behavior is set up to align the "snapTo" edge of this
     *   widget with the snapTo edge of the master or parent.
     *  @type {string}
     *  @default null
     */
    open var snapEdge: String = definedExternally
    /**
     *  If Canvas.snapTo is defined for this widget, this property can be used to
     *   specify an offset in px or percentage for the left coordinate of this widget.
     * 
     *   For example if snapTo is specified as "L" and
     *   snapOffsetLeft is set to 6, this widget will be rendered 6px inside the left
     *   edge of its parent or master element. Alternatively if snapTo was set
     *   to "R", a snapOffsetLeft value of -6 would cause the
     *   component to be rendered 6px inside the right edge of its parent or Canvas.getMasterCanvas.
     *  @type {Integer}
     *  @default null
     */
    open var snapOffsetLeft: Number = definedExternally
    /**
     *  If Canvas.snapTo is defined for this widget, this property can be used to
     *   specify an offset in px or percentage for the top coordinate of this widget.
     * 
     *   For example if snapTo is specified as "T" and
     *   snapOffsetTop is set to 6, this widget will be rendered 6px below the top
     *   edge of its parent or master element. . Alternatively if snapTo was set
     *   to "B", a snapOffsetTop value of -6 would cause the
     *   component to be rendered 6px inside the bottom edge of its parent or Canvas.getMasterCanvas.
     *  @type {Integer}
     *  @default null
     */
    open var snapOffsetTop: Number = definedExternally
    /**
     *  Causes this canvas to snap to its parent's grid when dragging.
     *  @type {boolean}
     *  @default null
     */
    open var snapToGrid: Boolean = definedExternally
    /**
     *  Causes this canvas to snap to its parent's grid when resizing.
     *   Note that this value defaults to the Canvas's
     *   Canvas.snapToGrid value if undefined.
     *  @type {boolean}
     *  @default null
     */
    open var snapResizeToGrid: Boolean = definedExternally
    /**
     *  If true, causes this canvas's children to snap to its grid when dragging.
     *   This behavior can be overridden on a per-child basis by setting the
     *   Canvas.snapToGrid value on the child.
     *  @type {boolean}
     *  @default null
     */
    open var childrenSnapToGrid: Boolean = definedExternally
    /**
     *  If true, causes this canvas's children to snap to its grid when resizing.
     *   This behavior can be overridden on a per-child basis by setting the
     *   Canvas.snapToGrid or
     *   Canvas.snapResizeToGrid value on the child.
     *  @type {boolean}
     *  @default null
     */
    open var childrenSnapResizeToGrid: Boolean = definedExternally
    /**
     *  The horizontal grid size to use, in pixels, when snap-to-grid is enabled.
     *  @type {number}
     *  @default "20"
     */
    open var snapHGap: Number = definedExternally
    /**
     *  The vertical grid size to use, in pixels, when snap-to-grid is enabled.
     *  @type {number}
     *  @default "20"
     */
    open var snapVGap: Number = definedExternally
    /**
     *  The horizontal snap direction.
     *   Set this value to "before" to snap to the nearest gridpoint to the left;
     *   set it to "after" to snap to the nearest gridpoint to the right; and set
     *   it to "nearest" to snap to the nearest gridpoint in either direction.
     *  @type {string}
     *  @default "after"
     */
    open var snapHDirection: String = definedExternally
    /**
     *  The vertical snap direction.
     *   Set this value to "before" to snap to the nearest gridpoint above;
     *   set it to "after" to snap to the nearest gridpoint below; and set
     *   it to "nearest" to snap to the nearest gridpoint in either direction.
     *  @type {string}
     *  @default "after"
     */
    open var snapVDirection: String = definedExternally
    /**
     *  Describes which axes to apply snap-to-grid to.
     *   Valid values are "horizontal", "vertical" or "both".
     *  @type {string}
     *  @default "both"
     */
    open var snapAxis: String = definedExternally
    /**
     *  When this canvas is dropped onto an object supporting snap-to-grid, should it snap
     *   to the grid (true, the default) or just drop wherever the mouse is (false).
     *  @type {boolean}
     *  @default true
     */
    open var snapOnDrop: Boolean = definedExternally
    /**
     *  Should this canvas print its children absolutely positioned when generating
     *   Canvas.getPrintHTML.
     * 
     *   By default explicitly specified absolute positioning and sizing is ignored when generating
     *   print HTML. This is done intentionally: there is no way for the framework to predict how
     *   explicit sizes will translate to a the printed page and if HTML for printing includes
     *   the same absolute positioning and sizing as is displayed within an application it is very
     *   common to encounter undesirable effects, such as seeing tables get broken over several
     *   pages horizontally when there is enough room to print them on a single page of paper.
     * 
     *   In some cases, however, a developer may wish to have explicit sizing and positioning
     *   respected within the print-view.
     *   Setting this attribute to true will cause this to occur.
     *  @type {boolean}
     *  @default false
     */
    open var printChildrenAbsolutelyPositioned: Boolean = definedExternally
    /**
     *  This boolean flag will be set to true by framework logic while generating print HTML
     *   for this widget as a result to a call to Canvas.showPrintPreview
     *   (or just Canvas.getPrintHTML). Note that this flag is set recursively as
     *   parent widgets generate print HTML for their children.
     * 
     *   This is a read-only property and should not be modified by application code.
     *  @type {boolean}
     *  @default false
     */
    open var isPrinting: Boolean = definedExternally
    /**
     *  Whether this canvas should be included in a printable view.
     * 
     *   Default is to:
     * 
     * 
     *  - omit all peers (edges generated by showEdges:true, etc)
     * 
     *  - omit anything considered a "control", such as a button or menu (see
     *   PrintProperties.omitControls)
     * 
     *  - include everything else not marked shouldPrint:false
     * 
     *  @type {boolean}
     *  @default null
     */
    open var shouldPrint: Boolean = definedExternally
    /**
     *  Is it possible that a call to Canvas.redraw on this widget will change its
     *   size?
     * 
     *   Used by framework layout code when determining whether a component which has been
     *   Canvas.markForRedraw needs an immediate redraw to determine
     *   its drawn size.
     * 
     *   If unset, default behavior assumes any component with overflow set to "visible"
     *   may change size on redraw, and any component with overflow set to "hidden", "scroll",
     *   or "auto" will not. This property overrides that behavior, and may be used to indicate
     *   that some component with non visible overflow can change size on redraw.
     *   An example use case would be a custom component with an override to explicitly
     *   resize the component as part of the redraw() flow.
     *  @type {boolean}
     *  @default null
     */
    open var sizeMayChangeOnRedraw: Boolean = definedExternally
    /**
     *  If this property is set to true, the Canvas.destroy method
     *   has been called on this canvas. This implies the canvas is no longer valid. Its ID has been
     *   removed from global scope, and calling standard canvas APIs on it is likely to result in
     *   errors.
     *  @type {boolean}
     *  @default null
     */
    open var destroyed: Boolean = definedExternally
    /**
     *  This property is set to true when the Canvas.destroy method is called on a widget.
     *   If this property is true, but Canvas.destroyed is not, this indicates the canvas is
     *   in the process of being destroyed.
     *  @type {boolean}
     *  @default null
     */
    open var destroying: Boolean = definedExternally
    /**
     *  Automatically generated mask canvas displayed when Canvas.showComponentMask is called.
     *  @type {Canvas}
     *  @default null
     */
    open var componentMask: Canvas = definedExternally
    /**
     *  Defaults for the Canvas.componentMask autoChild.
     *   Default properties include Canvas.backgroundColor being set to "black" and
     *   Canvas.opacity being set to 20.
     *  @type {Canvas}
     *  @default "{...}"
     */
    open var componentMaskDefaults: Canvas = definedExternally
    /**
     *  The minimum speed in pixels per second that must be reached for momentum scrolling to kick in.
     *   This setting only applies to touch-enabled devices.
     *  @type {Double}
     *  @default "200"
     */
    open var momentumScrollMinSpeed: Number = definedExternally
    /**
     *  Should canvases with no Canvas.getParentCanvas be moved to
     *   the end of the TabIndexManager tree on draw()?
     * 
     *   If set to false, the tab-position will not be modified on draw.
     * 
     *   This property is useful for cases where the tab position of a widget will be managed
     *   by some explicit tabIndex management code.
     *  @type {boolean}
     *  @default true
     */
    open var updateTabPositionOnDraw: Boolean = definedExternally
    /**
     *  Should canvases with a Canvas.getParentCanvas be added to
     *   the TabIndexManager under the parent as described in Canvas.updateChildTabPositions and
     *   Canvas.updateChildTabPosition?
     * 
     *   If set to false, the tab-position will not be modified on parent change.
     * 
     *   This property is useful for cases where the tab position of a widget will be managed
     *   by something other than the parent canvas, for example for
     *   CanvasItem.canvas.
     *  @type {boolean}
     *  @default true
     */
    open var updateTabPositionOnReparent: Boolean = definedExternally
    /**
     *  When set to true, shows a widget hovering at the mouse point instead of the builtin
     *   hover label. Override Canvas.getHoverComponent to provide the
     *   Canvas to show as the hoverComponent.
     *  @type {boolean}
     *  @default false
     */
    open var showHoverComponents: Boolean = definedExternally
    /**
     *  Whether to show a snap grid for this Canvas. Note that the grid is only shown
     *   when either Canvas.childrenSnapToGrid or Canvas.childrenSnapResizeToGrid
     *   is true.
     * 
     *   Grid is based on Canvas.snapHGap and Canvas.snapVGap properties.
     *  @type {boolean}
     *  @default null
     */
    open var showSnapGrid: Boolean = definedExternally
    /**
     *  If enabled while Canvas.childrenSnapToGrid is enabled, children dragged within this Canvas
     *   will also snap to positions where their edges or center lines would be aligned with the
     *   edges or centers of other components, and lines will be shown to point out the possible
     *   alignment (with appearance controlled by Canvas.snapAlignCenterLineStyle and
     *   Canvas.snapAlignEdgeLineStyle respectively.
     * 
     *   By default, edge- or center-snapping is enabled for all components, but the set of eligible
     *   components can be explicitly set via Canvas.snapAlignCandidates.
     * 
     *   See also Canvas.childrenSnapCenterAlign and Canvas.childrenSnapEdgeAlign for enabling or
     *   disabling center alignment or edge alignment individually.
     *  @type {boolean}
     *  @default null
     */
    open var childrenSnapAlign: Boolean = definedExternally
    /**
     *  Flag to disable snapping to alignment when children of this Canvas are resized
     *  @type {boolean}
     *  @default null
     */
    open var childrenResizeSnapAlign: Boolean = definedExternally
    /**
     *  See Canvas.childrenSnapAlign. This setting enables or disables snapping on center
     *   alignment only.
     *  @type {boolean}
     *  @default null
     */
    open var childrenSnapCenterAlign: Boolean = definedExternally
    /**
     *  See Canvas.childrenSnapAlign. This setting enables or disables snapping on edge
     *   alignment only.
     *  @type {boolean}
     *  @default null
     */
    open var childrenSnapEdgeAlign: Boolean = definedExternally
    /**
     *  Flag to disable snapping to alignment when this Canvas is dragged when
     *   Canvas.childrenSnapAlign is enabled on this Canvas' parent.
     * 
     *   To control snapping to align for the children dragged within this Canvas, see
     *   Canvas.childrenSnapAlign instead.
     *  @type {boolean}
     *  @default null
     */
    open var snapToAlign: Boolean = definedExternally
    /**
     *  Flag to disable snapping to alignment when this Canvas is resized.
     * 
     *   To control snapping to align for the children resized within this Canvas, see
     *   Canvas.childrenResizeSnapAlign instead.
     *  @type {boolean}
     *  @default null
     */
    open var snapResizeToAlign: Boolean = definedExternally
    /**
     *  Flag to disable snapping to center alignment when this Canvas is dragged when
     *   Canvas.childrenSnapAlign is enabled on this Canvas' parent.
     *  @type {boolean}
     *  @default null
     */
    open var snapToCenterAlign: Boolean = definedExternally
    /**
     *  Flag to disable snapping to edge alignment when this Canvas is dragged when
     *   Canvas.childrenSnapAlign is enabled on this Canvas' parent.
     *  @type {boolean}
     *  @default null
     */
    open var snapToEdgeAlign: Boolean = definedExternally
    /**
     *  Flag to disable snapping to alignment against this Canvas when other Canvases
     *   dragged into the same parent when Canvas.childrenSnapAlign is enabled on this
     *   Canvas' parent.
     *  @type {boolean}
     *  @default null
     */
    open var isSnapAlignCandidate: Boolean = definedExternally
    /**
     *  When Canvas.childrenSnapAlign is enabled, list of candidates to check for alignment.
     * 
     *   If a list of snapAlignCandidates is never provided, the default is to use all
     *   children that are not explicitly excluded via Canvas.isSnapAlignCandidate, including
     *   automatically adding newly added children as candidates, and ignoring children that have
     *   been removed. Use Canvas.addSnapAlignCandidate and Canvas.removeSnapAlignCandidate to add
     *   and remove special candidates while retaining all children as default candidates.
     * 
     *   Possible candidates which are not drawn or are hidden are automatically ignored.
     *  @type {Array<Partial<Canvas>>}
     *  @default null
     */
    open var snapAlignCandidates: Array<dynamic> = definedExternally
    /**
     *  CSS border declaration used for the line shown to indicate snapping to a center line when
     *   Canvas.childrenSnapAlign is set.
     *  @type {string}
     *  @default "1px solid blue"
     */
    open var snapAlignCenterLineStyle: String = definedExternally
    /**
     *  CSS border declaration used for the line shown to indicate snapping to a edge line when
     *   Canvas.childrenSnapAlign is set.
     *  @type {string}
     *  @default "1px solid #555555"
     */
    open var snapAlignEdgeLineStyle: String = definedExternally
    /**
     *  Whether an EdgedCanvas should be used to show image-based edges around this
     *   component.
     *  @type {boolean}
     *  @default false
     */
    open var showEdges: Boolean = definedExternally
    /**
     *  Size in pixels for corners and edges
     *  @type {number}
     *  @default "10"
     */
    open var edgeSize: Number = definedExternally
    /**
     *  Amount the contained Canvas should be offset. Defaults to edgeSize; set to less than
     *   edgeSize to allow the contained Canvas to overlap the edge and corner media.
     *  @type {number}
     *  @default null
     */
    open var edgeOffset: Number = definedExternally
    /**
     *  Base name of images for edges. Extensions for each corner or edge piece will be added
     *   to this image URL, before the extension. For example, with the default base name of
     *   "edge.gif", the top-left corner image will be "edge_TL.gif".
     * 
     *   The full list of extensions is: "_TL", "_TR", "_BL", "_BR", "_T", "_L", "_B", "_R",
     *   "_center".
     *  @type {SCImgURL}
     *  @default "[SKIN]edge.gif"
     */
    open var edgeImage: String = definedExternally
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
    open var customEdges: Array<dynamic> = definedExternally
    /**
     *  Background color for the EdgedCanvas created to decorate this component. This can be used
     *   to provide an underlying "tint" color for translucent edge media
     *  @type {CSSColor}
     *  @default null
     */
    open var edgeBackgroundColor: String = definedExternally
    /**
     *  Opacity of the edges. Defaults to matching this.opacity.
     *   if Canvas.setOpacity is called on a Canvas where edgeOpacity is set,
     *   edgeOpacity will be considered a percentage of the parent's opacity (so 50% opaque parent plus
     *   edgeOpacity 50 means 25% opaque edges)
     *  @type {Integer}
     *  @default null
     */
    open var edgeOpacity: Number = definedExternally
    /**
     *  Whether to show media in the center section, that is, behind the decorated Canvas.
     *  @type {boolean}
     *  @default false
     */
    open var edgeShowCenter: Boolean = definedExternally
    /**
     *  Background color for the center section only. Can be used as a surrogate background
     *   color for the decorated Canvas, if the Canvas is set to partially overlap the edges and
     *   hence can't show a background color itself without occluding media.
     *  @type {CSSColor}
     *  @default null
     */
    open var edgeCenterBackgroundColor: String = definedExternally
    /**
     *  Whether to show a drop shadow for this Canvas.
     * 
     *   Shadows may be rendered using Canvas.useCSSShadow or via images.
     *   The appearance of shadows can be customized via
     *   Canvas.shadowColor (for css-based shadows) or Canvas.shadowImage
     *   (for image based shadows), Canvas.shadowDepth,
     *   Canvas.shadowOffset and Canvas.shadowSoftness.
     * 
     *   When Canvas.useCSSShadow is false, developers should be aware that the drop shadow
     *   is rendered as a Canvas.peers and is drawn outside the specified
     *   width and height of the widget meaning a widget with shadows
     *   takes up a little more space than it otherwise would. A full screen canvas with showShadow set
     *   to true as this would be likely to cause browser scrollbars to appear - developers can handle
     *   this by either setting this property to false on full-screen widgets, or by setting
     *   overflow to "hidden" on the &lt;body&gt; element if browser-level scrolling is
     *   never intended to occur.
     *  @type {boolean}
     *  @default false
     */
    open var showShadow: Boolean = definedExternally
    /**
     *  Depth of the shadow, or the virtual height above the page of the widget throwing the shadow.
     * 
     *   This is a single parameter that can be used to control both shadowSoftness and
     *   shadowOffset.
     *  @type {number}
     *  @default "4"
     */
    open var shadowDepth: Number = definedExternally
    /**
     *  Offset of the shadow. Defaults to half of shadowDepth if unset.
     * 
     *   Because of the blurred edges, a shadow is larger than the originating component by
     *   2xsoftness. An shadowOffset of 0 means that the shadow will extend around the
     *   originating component equally in all directions.
     * 
     *   If Canvas.useCSSShadow are being used, separate vertical and
     *   horizontal offsets may be specified via Canvas.shadowHOffset and
     *   Canvas.shadowVOffset.
     *  @type {number}
     *  @default null
     */
    open var shadowOffset: Number = definedExternally
    /**
     *  Horizontal offset for the Canvas.showShadow. Takes precedence over
     *   Canvas.shadowOffset if set. Has no effect if Canvas.useCSSShadow
     *   are not being used for this canvas.
     *  @type {number}
     *  @default null
     */
    open var shadowHOffset: Number = definedExternally
    /**
     *  Vertical offset for the Canvas.showShadow. Takes precedence over
     *   Canvas.shadowOffset if set. Has no effect if Canvas.useCSSShadow
     *   are not being used for this canvas.
     *  @type {number}
     *  @default null
     */
    open var shadowVOffset: Number = definedExternally
    /**
     *  Softness, or degree of blurring, of the shadow.
     * 
     *   A shadow with softness:x is 2x pixels larger in each direction than the element
     *   throwing the shadow, and the media for each edge should be x pixels wide/tall.
     * 
     *   Defaults to shadowDepth if unset.
     *  @type {number}
     *  @default null
     */
    open var shadowSoftness: Number = definedExternally
    /**
     *  If Canvas.useCSSShadow is false, (or for browsers that do not support
     *   css3), this property supplies the base name of the series of images for the sides,
     *   corners, and center of the shadow.
     * 
     *   The actual image names fetched for the dropShadow combine the segment name and the
     *   shadowDepth setting. For example, given "ds.png" as the base name, a depth of
     *   4, and the top-left segment of the shadow, we'd use "ds4_TL.png".
     * 
     *   The names for segments are the same as those given for controlling resizable edges; see
     *   Canvas.resizeFrom. The center segment has the name "center". The center segment is
     *   the only segment that doesn't include the depth in the URL, so the final image name for the
     *   center given a baseName of "ds.png" would be just "ds_center.png".
     *  @type {SCImgURL}
     *  @default "[SKIN]ds.png"
     */
    open var shadowImage: String = definedExternally
    /**
     *  If Canvas.showShadow is true, should we use the css box-shadow property
     *   (where supported) to achieve the shadow?
     * 
     *   Set this property to false to switch to a media-based approach, achieved by
     *   rendering the Canvas.shadowImage in an automatically generated peer.
     *   This approach is also used regardless of this property value in older browsers
     *   where the css box-shadow property isn't supported.
     * 
     *   See also Canvas.shadowColor, Canvas.shadowDepth,
     *   Canvas.shadowOffset, Canvas.shadowSoftness and Canvas.shadowSpread
     *  @type {boolean}
     *  @default true
     */
    open var useCSSShadow: Boolean = definedExternally
    /**
     *  Color for the css-based drop shadow shown if Canvas.useCSSShadow is true
     *   and Canvas.showShadow is true.
     * 
     *   Has no effect if we are not using css-based shadows - in that case, use
     *   Canvas.shadowImage instead.
     *  @type {CSSColor}
     *  @default "#AAAAAA"
     */
    open var shadowColor: String = definedExternally
    /**
     *  Explicit spread for the css-based drop shadow shown if Canvas.useCSSShadow is true
     *   and Canvas.showShadow is true. This property governs how much larger than the
     *   widget the shadow will appear. A negative value (coupled with an explicit offset) will
     *   result in a smaller shadow.
     * 
     *   Has no effect if we are not using css-based shadows - in that case, use
     *   Canvas.shadowImage instead.
     *  @type {Integer}
     *  @default null
     */
    open var shadowSpread: Number = definedExternally
    /**
     *  Should a grouping frame be shown around this canvas.
     *  @type {boolean}
     *  @default false
     */
    open var isGroup: Boolean = definedExternally
    /**
     *  Sets the style for the grouping frame around the canvas. Only necessary when Canvas.isGroup
     *   is set to true.
     *  @type {string}
     *  @default "2px solid black"
     */
    open var groupBorderCSS: String = definedExternally
    /**
     *  Sets the style for the grouping label. Only necessary when Canvas.isGroup
     *   is set to true.
     * 
     *   Note that Canvas.groupLabelBackgroundColor overrides any background-color of this style.
     *  @type {CSSStyleName}
     *  @default "groupLabel"
     */
    open var groupLabelStyleName: String = definedExternally
    /**
     *  If set, the background color of the grouping label. Only applicable when Canvas.isGroup
     *   is set to true.
     * 
     *   This corresponds to the CSS background-color property on the grouping label. You can set this
     *   property to an RGB value (e.g. #22AAFF) or a named color (e.g. red) from a list of browser supported
     *   color names.
     * 
     *  @type {CSSColor}
     *  @default null
     */
    open var groupLabelBackgroundColor: String = definedExternally
    /**
     *  The title/label for the grouping. Only applicable when Canvas.isGroup is set to true.
     *  @type {HTMLString}
     *  @default null
     */
    open var groupTitle: String = definedExternally
    /**
     *  Canvas.ID of the component that gathers the context for evaluation of criteria-based
     *   rules specified by properties such as FormItem.visibleWhen.
     * 
     *   If not specified, this component will search through it's Canvas.parentCanvas chain until it
     *   either reaches the top or reaches a parent marked Canvas.isRuleScope. Determination of the
     *   ruleScope happens when the component is first drawn.
     * 
     *   The component designated as the ruleScope manages a nested data structure called
     *   the "rule context" which contains information from all DataBoundComponents that are
     *   registered with the ruleScope. By specifying Criterion.fieldName as a
     *   DataPath, AdvancedCriteria defined in properties such as
     *   FormItem.visibleWhen can access any part of the rule context.
     * 
     *   By default, the rule context contains data as follows:
     * 
     * 
     *  - any DataBoundComponent that has a DataSource contributes the values of the
     *    selected record or record being edited under the ID of the DataSource. For any collision
     *    an editable display (such as a form or editable grid) wins over a static display (such as
     *    a non-editable grid with a selection.)
     * 
     *  - any ListGrid or other component that manages a selection and has been assigned an explicit
     *    Canvas.ID will contribute the values of the selected record under
     *    &lt;componentId&gt;.selectedRecord, and also contributes 3 flags for checking
     *    for selection: anySelected, multiSelected,
     *    numSelected.
     * 
     *  - any DynamicForm or other component that edits values and has been assigned an explicit
     *    Canvas.ID contributes its current values under
     *    &lt;componentId&gt;.values, and contributes a flag hasChanges.
     * 
     *  - any DynamicForm or ListGrid that has been assigned an explicit Canvas.ID
     *    contributes a value &lt;componentId&gt;.focusField. When present the value
     *    indicates the component has focus along with the name of the field that has focus. Its absense
     *    indicates the component does not have focus at all.
     * 
     *  - any ListGrid that has been assigned an explicit Canvas.ID contributes a flag
     *    isGrouped under &lt;componentId&gt;.
     * 
     *   For example, given a screen where:
     * 
     * 
     *  - a ListGrid with ID "itemGrid" and DynamicForm with ID "itemForm" are both bound to the
     *    supplyItem sample DataSource
     * 
     *  - the ListGrid has a single selection, and the record selected in the ListGrid is being
     *    edited in the form, and has been changed
     * 
     *   The default rule context available from Canvas.getRuleContext, expressed as JSON, would be:
     * 
     *   {
     *   supplyItem : {
     *     itemID : "654321",
     *     itemName : "Sewing Machine",
     *     price : 5.50, // note: user change
     *     ..other properties..
     *   },
     *   itemForm.values : {
     *     itemID : "654321",
     *     itemName : "Sewing Machine",
     *     price : 5.50, // note: user change
     *     ..other properties..
     *   },
     *   itemForm.focusField : "itemName",
     *   itemForm.hasChanges : true,
     *   itemGrid.selectedRecord : {
     *     itemID : "654321",
     *     itemName : "Sewing Machine",
     *     price : 3.50, // note: old price
     *     ..other properties..
     *   },
     *   itemGrid.anySelected : true,
     *   itemGrid.multiSelected : false,
     *   itemGrid.numSelected : 1,
     *   itemGrid.isGrouped : false
     *   }
     * 
     *   In addition, an application can put custom data into the ruleScope via Canvas.provideRuleContext.
     *  @type {string}
     *  @default null
     */
    override var ruleScope: String = definedExternally
    /**
     *  Marks this Canvas as the Canvas.ruleScope that will be discovered by any contained
     *   DataBoundComponents which do not specify an explicit ruleScope.
     *  @type {boolean}
     *  @default null
     */
    open var isRuleScope: Boolean = definedExternally
    /**
     *  ValuesManager for managing values displayed in this component.
     *   If specified at initialization time, this component will be added to the valuesManager via
     *   ValuesManager.addMember.
     * 
     *   ValuesManagers allow different fields of a single object to be displayed or edited
     *   across multiple UI components. Given a single values object, a valuesManager will handle
     *   determining the appropriate field values for its member components and displaying them /
     *   responding to edits if the components support this.
     * 
     *   Data may be derived simply from the specified fieldNames within the member components, or for
     *   complex nested data structures can be specified by both component and field-level
     *   DataPath.
     * 
     *   Note that components may be automatically bound to an existing valuesManager attached to a
     *   parent component if dataPath is specified. See Canvas.dataPath for more information.
     *   Also note that if a databound component has a specified dataSource and dataPath but no specified
     *   valuesManager object one will be automatically generated as part of the databinding process
     *  @type {ValuesManager | GlobalId}
     *  @default null
     */
    open var valuesManager: dynamic = definedExternally
    /**
     *  A dataPath may be specified on any canvas. This provides a straightforward way to display or
     *   edit complex nested data.
     * 
     *   For components which support displaying or editing data values, (such as DynamicForm or
     *   ListGrid components), the dataPath may be set to specify how the components data is
     *   accessed. In this case the dataPath essentially specifies a nested object to edit - typically
     *   a path to a field value within a dataSource record. Note that a ValuesManager will be required
     *   to handle connecting the dataBoundcomponent to the appropriate sub object. This may be explicitly
     *   specified on the component, or a parent of the component, or automatically generated
     *   if a DataSource is specified on either the component or a parent thereof.
     * 
     *   To provide a simple example - if a complex object existed with the following format:
     * 
     *   { companyName:"Some Company",
     *    address:{  street:"123 Main Street", city:"New York", state:"NY" }
     *   }
     * 
     *   a developer could specify a DynamicForm instance with 'dataPath' set to "address" to edit
     *   the nested address object:
     * 
     *   isc.ValuesManager.create({
     *     ID:'vm',
     *     values: { companyName:"Some Company",
     *         address:{  street:"123 Main Street", city:"New York", state:"NY" }
     *     }
     *   });
     * 
     *   isc.DynamicForm.create({
     *     valuesManager:"vm",
     *     dataPath:"address",
     *     items:[{name:"street"}, {name:"city"}, {name:"state"}]
     *   });
     * 
     *   If a component is specified with a dataPath attribute but does not have an
     *   explicitly specified valuesManager, it will check its parent element chain for a specified
     *   valuesManager and automatically bind to that. This simplifies binding multiple components used
     *   to view or edit a nested data structure as the valuesManager needs only be defined once at a
     *   reasonably high level component. Here's an example of this approach:
     * 
     *   isc.ValuesManager.create({
     *     ID:'vm',
     *     values: { companyName:"Some Company",
     *         address:{  street:"123 Main Street", city:"New York", state:"NY" }
     *     }
     *   });
     * 
     *   isc.Layout.create({
     *     valuesManager:vm,
     *     members:[
     *       isc.DynamicForm.create({
     *         dataPath:"/",
     *         items:[{name:"companyName"}]
     *       }),
     *       isc.DynamicForm.create({
     *         dataPath:"address",
     *         items:[{name:"street"}, {name:"city"}, {name:"state"}]
     *       })
     *     ]
     *   });
     * 
     *   Note that in this case the valuesManager is specified on a Layout, which has no 'values'
     *   management behavior of its own, but contains items with a specified dataPath which do. In this
     *   example you'd see 2 forms allowing editing of the nested data structure.
     * 
     *   dataPaths from multiple nested components may also be combined. For example:
     * 
     *   isc.ValuesManager.create({
     *     ID:'vm',
     *     values: { companyName:"Some Company",
     *         address:{  street:"123 Main Street", city:"New York", state:"NY" }
     *         parentCompany:{
     *           companyName:"Some Corporation",
     *           address:{  street:"1 High Street", city:"New York", state:"NY" }
     *         }
     *     }
     *   });
     * 
     *   isc.Layout.create({
     *     valuesManager:vm,
     *     members:[
     *       isc.DynamicForm.create({
     *         dataPath:"/",
     *         items:[{name:"companyName"}]
     *       }),
     *       isc.DynamicForm.create({
     *         dataPath:"address",
     *         items:[{name:"street"}, {name:"city"}, {name:"state"}]
     *       }),
     *       isc.Layout.create({
     *         dataPath:"parentCompany",
     *         members:[
     *           isc.DynamicForm.create({
     *             dataPath:"/",
     *             items:[{name:"companyName", type:"staticText"}]
     *           }),
     *           isc.DetailViewer.create({
     *             dataPath:"address",
     *             fields:[{name:"street", name:"city", name:"state"}]
     *           })
     *         ]
     *       })
     *     ]
     *   });
     * 
     *   In this example the detailViewer will display data from the parentCompany.address
     *   object within the base record.
     * 
     *   Note that if a component has a specified dataSource and shows child components with a
     *   specified dataPath, there is no need to explicitly declare a valuesManager at all. If a component
     *   with a dataPath has a dataSource, or an ancestor with a dataSource specified, it will, a
     *   valuesManager will automatically be generated on the higher level component (and be available as
     *   component.valuesManager).
     *  @type {DataPath}
     *  @default null
     */
    open var dataPath: String = definedExternally
    /**
     *  Strategy to use when locating children in this canvas from an autoTest locator string.
     *  @type {LocatorStrategy}
     *  @default null
     */
    open var locateChildrenBy: 
                               /**
                                *  Match by name if possible.
                                *  Match by title if possible.
                                *  Match by index
                                */
                               String /* name |  title |  index */ = definedExternally
    /**
     *  LocatorTypeStrategy to use when finding children within this canvas.
     *  @type {LocatorTypeStrategy}
     *  @default null
     */
    open var locateChildrenType: 
                                 /**
                                  *  Match by class if possible
                                  *  Ignore specific class and match by the SmartClient framework superclass.
                                  *  Ignore class altogether and attempt to match by role
                                  *  Don't attempt to compare type in any way
                                  */
                                 String /* Class |  scClass |  role |  none */ = definedExternally
    /**
     *  Strategy to use when locating peers of this canvas from an autoTest locator string.
     *  @type {LocatorStrategy}
     *  @default null
     */
    open var locatePeersBy: 
                            /**
                             *  Match by name if possible.
                             *  Match by title if possible.
                             *  Match by index
                             */
                            String /* name |  title |  index */ = definedExternally
    /**
     *  LocatorTypeStrategy to use when finding peers of this canvas.
     *  @type {LocatorTypeStrategy}
     *  @default null
     */
    open var locatePeersType: 
                              /**
                               *  Match by class if possible
                               *  Ignore specific class and match by the SmartClient framework superclass.
                               *  Ignore class altogether and attempt to match by role
                               *  Don't attempt to compare type in any way
                               */
                              String /* Class |  scClass |  role |  none */ = definedExternally
    /**
     *  When nodes are added to an EditContext, should they be masked by setting
     *   EditProxy.useEditMask true if not explicitly set?
     *  @deprecated \* As of SmartClient version 10.0, deprecated in favor of EditProxy.autoMaskChildren
     *  @type {boolean}
     *  @default null
     */
    open var autoMaskComponents: Boolean = definedExternally
    /**
     *  An EditProxy controls the behaviors of a component when it is placed into
     *   devTools.
     * 
     *   The editProxy AutoChild is created when a component is first placed into
     *   edit mode via Canvas.setEditMode.
     * 
     *   editProxy properties can be supplied on a PaletteNode or
     *   EditNode as PaletteNode.editProxyProperties, but must
     *   be provided before the component is first placed into edit mode.
     * 
     *   Most editable components use a custom EditProxy. See the documentation for
     *   each class' Canvas.editProxyConstructor to determine
     *   the class.
     *  @type {EditProxy}
     *  @default null
     */
    open var editProxy: EditProxy = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "CanvasEditProxy"
     */
    open var editProxyConstructor: String = definedExternally
    /**
     *  The component's EditNode for a component that has been created by a
     *   Palette from a PaletteNode.
     *  @type {EditNode}
     *  @default null
     */
    open var editNode: EditNode = definedExternally
    /**
     *  ARIA role of this component. Usually does not need to be manually set - see
     *   accessibility.
     *  @type {string}
     *  @default null
     */
    open var ariaRole: String = definedExternally
    /**
     *  ARIA state mappings for this component. Usually this does not need to be manually
     *   set - see accessibility.
     * 
     *   This attribute should be set to a mapping of aria state-names to values - for example
     *   to have the "aria-haspopup" property be present with a value "true", you'd specify:
     * 
     *   { haspopup : true }
     * 
     *  @type {object}
     *  @default null
     */
    open var ariaState: dynamic = definedExternally
    /**
     *   Animate a reposition of this canvas from its current position to the specified position
     * 
     *  @param {Integer} new left position (or null for unchanged)
     *  @param {Integer} new top position (or null for unchanged)
     *  @param {AnimationCallback=} When the move completes this callback will be            fired. Single 'earlyFinish' parameter will be passed if the            animation was cut short, for example by a call to the non-animated            APIs Canvas.moveTo or Canvas.moveBy.
     *  @param {Integer=} Duration in ms of the animated move
     *  @param {AnimationAcceleration=} Optional acceleration effect to bias the ratios
     */
    open fun animateMove(left: Number, top: Number, callback: ((earlyFinish: Boolean) -> Unit?), duration: Number?, acceleration: 
                                                                                                                                  /**
                                                                                                                                   *  - animation will speed up as time elapses
                                                                                                                                   *  - animation will slow down as time elapses
                                                                                                                                   *  - animation will speed up in the middle
                                                                                                                                   *  - no bias
                                                                                                                                   */
                                                                                                                                  String /* smoothStart |  smoothEnd |  smoothStartEnd |  none */?): Unit = definedExternally
    /**
     *   Animate a resize of this canvas from its current size to the specified size
     * 
     *  @param {Integer} new width (or null for unchanged)
     *  @param {Integer} new height (or null for unchanged)
     *  @param {AnimationCallback=} When the resize completes this callback will be            fired. Single 'earlyFinish' parameter will be passed if the            animation was cut short, for example by a call to the non-animated            APIs Canvas.resizeTo or Canvas.resizeBy.
     *  @param {Integer=} Duration in ms of the animated resize
     *  @param {AnimationAcceleration=} Optional acceleration effect to apply to the resize
     */
    open fun animateResize(width: Number, height: Number, callback: ((earlyFinish: Boolean) -> Unit?), duration: Number?, acceleration: 
                                                                                                                                        /**
                                                                                                                                         *  - animation will speed up as time elapses
                                                                                                                                         *  - animation will slow down as time elapses
                                                                                                                                         *  - animation will speed up in the middle
                                                                                                                                         *  - no bias
                                                                                                                                         */
                                                                                                                                        String /* smoothStart |  smoothEnd |  smoothStartEnd |  none */?): Unit = definedExternally
    /**
     *   Animate a reposition / resize of this canvas from its current size and position.
     * 
     *  @param {Integer} new left position (or null for unchanged)
     *  @param {Integer} new top position (or null for unchanged)
     *  @param {Integer} new width (or null for unchanged)
     *  @param {Integer} new height (or null for unchanged)
     *  @param {AnimationCallback=} When the setRect completes this callback will be            fired. Single 'earlyFinish' parameter will be passed if the            animation was cut short, for example by a call to the non-animated            API Canvas.setRect.
     *  @param {Integer=} Duration in ms of the animated setRect
     *  @param {AnimationAcceleration=} Optional acceleration effect to apply to the animation
     */
    open fun animateRect(left: Number, top: Number, width: Number, height: Number, callback: ((earlyFinish: Boolean) -> Unit?), duration: Number?, acceleration: 
                                                                                                                                                                 /**
                                                                                                                                                                  *  - animation will speed up as time elapses
                                                                                                                                                                  *  - animation will slow down as time elapses
                                                                                                                                                                  *  - animation will speed up in the middle
                                                                                                                                                                  *  - no bias
                                                                                                                                                                  */
                                                                                                                                                                 String /* smoothStart |  smoothEnd |  smoothStartEnd |  none */?): Unit = definedExternally
    /**
     *   Animate a change in opacity from the widget's current opacity to the specified opacity.
     * 
     *  @param {Integer} desired final opacity
     *  @param {AnimationCallback=} When the fade completes this callback will be            fired. Single 'earlyFinish' parameter will be passed if the            animation was cut short, for example by a call to the non-animated            API Canvas.setOpacity.
     *  @param {Integer=} Duration in ms of the animated fade
     *  @param {AnimationAcceleration=} Optional animation acceleration to bias the ratios
     */
    open fun animateFade(opacity: Number, callback: ((earlyFinish: Boolean) -> Unit?), duration: Number?, acceleration: 
                                                                                                                        /**
                                                                                                                         *  - animation will speed up as time elapses
                                                                                                                         *  - animation will slow down as time elapses
                                                                                                                         *  - animation will speed up in the middle
                                                                                                                         *  - no bias
                                                                                                                         */
                                                                                                                        String /* smoothStart |  smoothEnd |  smoothStartEnd |  none */?): Unit = definedExternally
    /**
     *   Animate a scroll from the current scroll position to the specified position.
     * 
     *  @param {Integer} desired final left scroll position
     *  @param {Integer} desired final top scroll position
     *  @param {AnimationCallback=} When the scroll completes this callback will be            fired. Single 'earlyFinish' parameter will be passed if the            animation was cut short, for example by a call to the non-animated            APIs Canvas.scrollTo or Canvas.scrollBy.
     *  @param {Integer=} Duration in ms of the animated scroll
     *  @param {AnimationAcceleration=} Optional acceleration to bias the animation ratios
     */
    open fun animateScroll(scrollLeft: Number, scrollTop: Number, callback: ((earlyFinish: Boolean) -> Unit?), duration: Number?, acceleration: 
                                                                                                                                                /**
                                                                                                                                                 *  - animation will speed up as time elapses
                                                                                                                                                 *  - animation will slow down as time elapses
                                                                                                                                                 *  - animation will speed up in the middle
                                                                                                                                                 *  - no bias
                                                                                                                                                 */
                                                                                                                                                String /* smoothStart |  smoothEnd |  smoothStartEnd |  none */?): Unit = definedExternally
    /**
     *   Show a canvas by growing it vertically to its fully drawn height over a period of time.
     *   This method will not fire if the widget is already drawn and visible, or has overflow
     *   other than "visible" or "hidden".
     * 
     *  @param {AnimateShowEffectId | AnimateShowEffect=} Animation effect to use   when revealing the widget. If ommitted, default behavior can be configured via    Canvas.animateShowEffect
     *  @param {AnimationCallback=} When the show completes this callback will be            fired. Single 'earlyFinish' parameter will be passed if the            animation was cut short, for example by a call to the non-animated            API Canvas.show.
     *  @param {Integer=} Duration in ms of the animated show. If unset, duration will be  picked up from Canvas.animateShowTime
     *  @param {AnimationAcceleration=} Optional acceleration effect function to  bias the animation ratios. If unset, acceleration will be picked up from  Canvas.animateShowAcceleration
     */
    open fun animateShow(effect: dynamic?, callback: ((earlyFinish: Boolean) -> Unit?), duration: Number?, acceleration: 
                                                                                                                         /**
                                                                                                                          *  - animation will speed up as time elapses
                                                                                                                          *  - animation will slow down as time elapses
                                                                                                                          *  - animation will speed up in the middle
                                                                                                                          *  - no bias
                                                                                                                          */
                                                                                                                         String /* smoothStart |  smoothEnd |  smoothStartEnd |  none */?): Unit = definedExternally
    /**
     *   Hide a canvas by shrinking it vertically to zero height over a period of time.
     *   This method will not fire if the widget is already drawn and visible, or has overflow
     *   other than "visible" or "hidden".
     * 
     *  @param {AnimateShowEffectId | AnimateShowEffect=} How should the content of the window be hidden during the hide? If ommitted, default behavior can be configured via  Canvas.animateHideEffect
     *  @param {AnimationCallback=} When the hide completes this callback will be            fired. Single 'earlyFinish' parameter will be passed if the            animation was cut short, for example by a call to the non-animated            API Canvas.hide.
     *  @param {Integer=} Duration in ms of the animated hide. If unset, duration will be  picked up from Canvas.animateHideTime
     *  @param {AnimationAcceleration=} Optional acceleration effect function to bias  the animation ratios. If unset, acceleration will be picked up from  Canvas.animateShowTime
     */
    open fun animateHide(effect: dynamic?, callback: ((earlyFinish: Boolean) -> Unit?), duration: Number?, acceleration: 
                                                                                                                         /**
                                                                                                                          *  - animation will speed up as time elapses
                                                                                                                          *  - animation will slow down as time elapses
                                                                                                                          *  - animation will speed up in the middle
                                                                                                                          *  - no bias
                                                                                                                          */
                                                                                                                         String /* smoothStart |  smoothEnd |  smoothStartEnd |  none */?): Unit = definedExternally
    /**
     *   When this Canvas is included as a member in a Layout, dynamically updates whether a
     *   resizeBar should be shown after this member in the layout, to allow it to be resized.
     * 
     *   Whether a resizeBar is actually shown also depends on the
     *   Layout.defaultResizeBars attribute of the layout, and whether this
     *   Canvas is the last layout member.
     * 
     *  @param {boolean} setting for this.showResizeBar
     */
    open fun setShowResizeBar(show: Boolean): Unit = definedExternally
    /**
     *   See Canvas.canAdaptWidth.
     * 
     *  @param {Integer} surplus (if positive) or overflow (if negative)
     *  @param {Integer} width of member currently assumed by parent layout
     */
    open fun adaptWidthBy(pixelDifference: Number, unadaptedWidth: Number): Number = definedExternally
    /**
     *   See Canvas.canAdaptWidth.
     * 
     *  @param {Integer} surplus (if positive) or overflow (if negative)
     *  @param {Integer} height of member currently assumed by parent layout
     */
    open fun adaptHeightBy(pixelDifference: Number, unadaptedHeight: Number): Number = definedExternally
    /**
     * 
     *   This method performs some basic initialization common to all UI components. To do custom UI
     *   component initialization, you should generally override Canvas.initWidget. This
     *   method does the following, in order:
     * 
     * 
     *  - Sets up a global reference to this instance as described in Canvas.ID.
     * 
     *  - Ensures certain numeric properties have numeric values (e.g. width, height, padding,
     *   margin)
     * 
     *  - Ensures Canvas.children and Canvas.peers are Arrays.
     * 
     *  - Calls Canvas.initWidget
     * 
     *  - Creates Canvas.showEdges and Canvas.showShadow, if so configured.
     * 
     *  - Calls Canvas.draw if Canvas.autoDraw is set on instance or globally.
     * 
     *   Unless you're in an advanced scenario where you need to inject code before the above
     *   logic executes, place your initialization logic in initWidget() rather than init(). If you
     *   do decided to override this method, you must call the superclass implementation like so:
     * 
     *    this.Super("init", arguments);
     * 
     * 
     * 
     *  @param {any=} All arguments initially passed to Class.create
     */
    override fun init(vararg args: Any): Unit = definedExternally
    /**
     * 
     *   For custom components, perform any initialization specific to your widget subclass.
     * 
     *   When creating a subclass of any Canvas-based component, you should generally override
     *   this method rather than overriding Class.init. This is because Canvas has its own
     *   Class.init override which performs some generally desirable initialization - see
     *   Canvas.init for details.
     * 
     *   This method is called by Canvas.init when a component is create()d. When
     *   overriding this method, You must call the superClass initWidget implementation, like
     *   so:
     * 
     *    this.Super("initWidget", arguments);
     * 
     * 
     *   In general, if you are going to call functionality supported by your superclass (eg calling
     *   addTab() when your superclass is a TabSet), call Super() first. However, you can generally
     *   assign properties to this before calling Super() as a way of mimicking the
     *   effect of the property being passed to Class.create on normal instance
     *   construction. For example, when subclassing a DynamicForm, you could set this.items to a
     *   generated set of items before calling Super().
     * 
     *   NOTE: child creation: if you are creating a component that auto-creates certain children (eg
     *   a Window which creates a Header child), typical practice is to create those children
     *   immediately before drawing by overriding draw(). This postpones work until it is really
     *   necessary and avoids having to update children if settings are changed between creation and
     *   draw(). Alternatively, if you prefer callers to directly manipulate auto-created children,
     *   it's best to create them earlier in initWidget(), in order to allow manipulation before
     *   draw.
     * 
     * 
     *  @param {any=} All arguments initially passed to Class.create
     */
    open fun initWidget(vararg args: Any): Unit = definedExternally
    /**
     *   Retrieve a child of this Canvas by it's Canvas.getLocalId.
     * 
     * 
     *  @param {string} local ID of the Canvas
     */
    open fun getByLocalId(localId: String): Canvas = definedExternally
    /**
     *   Retrieve the local ID of this canvas. If no local ID is assigned the normal
     *   canvas ID is returned making this method a safe replacement for Canvas.getID.
     * 
     *   A "local ID" is name for a child widget which is unique only for this parent, and not globally
     *   unique as is required for Canvas.ID. Widgets receive local IDs when loaded via
     *   RPCManager.loadScreen or RPCManager.cacheScreens and
     *   RPCManager.createScreen.
     * 
     * 
     */
    open fun getLocalId(): String = definedExternally
    /**
     *     Returns the boolean true, if the widget has been completely drawn, and false otherwise.
     * 
     */
    open fun isDrawn(): Boolean = definedExternally
    /**
     *     When a widget instance is created, it is assigned a unique global identifier that can be
     *     used to access the instance by name. The getID method returns this ID for a particular
     *     instance. Global IDs are essential when you need to embed a widget reference in a string,
     *     usually a string that will be evaluated in the future and/or in another object, where you
     *     may not have access to a variable or parameter holding the widget's reference.
     * 
     * 
     */
    override fun getID(): String = definedExternally
    /**
     *   Return the inner HTML for this canvas. Called when the canvas is drawn or redrawn;
     *   override to customize.
     * 
     * 
     */
    open fun getInnerHTML(): String = definedExternally
    /**
     *   Setter for Canvas.snapOffsetLeft.
     * 
     *  @param {Integer} new snapOffsetLeft value.
     */
    open fun setSnapOffsetLeft(snapOffsetLeft: Number): Unit = definedExternally
    /**
     *   Setter for Canvas.snapOffsetTop.
     * 
     *  @param {Integer} new snapOffsetTop value.
     */
    open fun setSnapOffsetTop(snapOffsetTop: Number): Unit = definedExternally
    /**
     *     Draws the widget on the page.
     * 
     */
    open fun draw(): Canvas = definedExternally
    /**
     *   Retrieves printable HTML for this component and all printable subcomponents.
     * 
     *   By default any Canvas with children will simply collect the printable HTML of its children
     *   by calling getPrintHTML() on each child that is considered Canvas.shouldPrint.
     *   If a callback is provided, then null is always returned and the callback is fired asynchronously.
     * 
     *   If overriding this method for a custom component, you should either return a String
     *   of printable HTML directly or return null and fire the provided callback using
     *   Class.fireCallback.
     * 
     *   To return an empty print representation, return an empty string ("") rather than null.
     * 
     *   The printProperties argument, if passed, must be passed to any subcomponents on
     *   which getPrintHTML() is called.
     * 
     *   Default implementation will set Canvas.isPrinting flag to true to indicate
     *   printing is in progress, and clear this flag when the printing has completed (possibly via
     *   an asynchronous callback).
     * 
     *   NOTE: Expecting a direct return value from the default implementation is deprecated usage.
     *   This is because small changes to an application (such as adding a few more data points to a chart
     *   or adding another button) or using certain browsers can make it necessary to generate the HTML
     *   asynchronously. Thus, application code should not rely on the return value and always pass
     *   a callback.
     * 
     * 
     *  @param {PrintProperties=} properties to configure printing behavior - may be null.
     *  @param {Callback=} optional callback. This is required to handle cases where HTML         generation is asynchronous - if a method generates HTML asynchronously, it should return          null, and fire the specified callback on completion of HTML generation. The          first parameter HTML should contain the generated print HTML.          The callback is only called if null is returned. Furthermore, the default          getPrintHTML() implementation always returns null and fires the callback          when a callback is provided.
     */
    open fun getPrintHTML(printProperties: PrintProperties?, callback: dynamic?): String = definedExternally
    /**
     *   Setter for the Canvas.htmlElement.
     * 
     *  @param {DOMElement} New htmlElement for this canvas, or Null to clear the existing               htmlElement
     */
    open fun setHtmlElement(element: DOMElement): Unit = definedExternally
    /**
     *   Setter for the Canvas.htmlPosition.
     * 
     *  @param {DrawPosition} New htmlPosition for this canvas
     */
    open fun setHtmlPosition(element: 
                                      /**
                                       *  insert before the target element
                                       *  insert as the target element's first child
                                       *  insert as the target element's last child
                                       *  insert after the target element
                                       *  replace the target element
                                       */
                                      String /* beforeBegin |  afterBegin |  beforeEnd |  afterEnd |  replace */): Unit = definedExternally
    /**
     *   Returns whether a canvas is waiting to be redrawn. Will return true if
     *   Canvas.markForRedraw has been called, but this canvas has not yet been
     *   redrawn.
     * 
     */
    open fun isDirty(): Boolean = definedExternally
    /**
     *   Marks the widget as "dirty" so that it will be added to a queue for redraw. Redraw of dirty
     *   components is handled by a looping timer and will after a very short delay (typically less than
     *   100ms). In most cases it is recommended that developers use markForRedraw()
     *   instead of calling Canvas.redraw directly. Since this method queues the redraw, multiple
     *   calls to markForRedraw() within a single thread of execution will only lead to a single DOM
     *   manipulation which greatly improves application performance.
     * 
     * 
     *  @param {string=} ["no reason provided"] reason for performing the redraw
     */
    open fun markForRedraw(reason: String?): Unit = definedExternally
    /**
     *   Redraws the widget immediately with its current property values.
     * 
     *   Generally, if you want a Canvas to redraw, call markForRedraw() - this will cause the Canvas to
     *   be redrawn when current processing ends, so that a series of modifications made to a Canvas will
     *   cause it to redraw only once.
     * 
     *   Only call redraw() directly if you need immediate responsiveness, for example you are redrawing
     *   in response to continuous mouse motion.
     * 
     * 
     *  @param {string=} ["no reason provided"] reason for performing the redraw
     */
    open fun redraw(reason: String?): Unit = definedExternally
    /**
     *   Remove all visual representation of a Canvas, including all child or member Canvases, or
     *   managed top-level components such as the ListGrid drop location indicator.
     * 
     *   This is more expensive than hide(), because in order to become visible again, the Canvas must
     *   be draw()n again. Generally, application code has no reason to call clear() unless it is
     *   attempting to do advanced memory management. If you want to temporarily hide a Canvas, use
     *   hide() and show(), and if you want to permanently destroy a Canvas, use Canvas.destroy.
     * 
     *   You would only use clear() if you were managing a very large pool of components and you
     *   wanted to reclaim some of the memory used by components that had not been used in a while,
     *   while still being able to just draw() them to make them active and visible again.
     * 
     *   Note: a clear() will happen as part of moving a Canvas to a different parent. See
     *   Canvas.addChild.
     * 
     * 
     */
    open fun clear(): Unit = definedExternally
    /**
     *   Permanently destroy a Canvas and all of it's children / members, recursively.
     * 
     *   Like Canvas.clear, calling destroy() removes all HTML for the component;
     *   unlike clear(), a destroyed Canvas is permanently unusable: it cannot be draw()'n again,
     *   cannot be referenced by its global ID, and is eligible for garbage collection (assuming
     *   that application code is not holding a reference to the Canvas).
     * 
     *   Any attempt to call a method on a destroyed Canvas will generally result in an error. If your
     *   application is forced to hold onto Canvas's that might be destroy()d without warning, you can
     *   avoid errors by checking for the Canvas.destroyed property. If you override certain Canvas
     *   methods, your code may be called while a Canvas is being destroy()d; in this case you can avoid
     *   extra work (and possibly errors) by checking for the Canvas.destroying property.
     * 
     *   Note that destroy() should not be called directly in event handling code for this
     *   canvas. For this reason, wherever possible we recommend using Canvas.markForDestroy
     *   instead of calling this method directly.
     * 
     * 
     */
    override fun destroy(): Unit = definedExternally
    /**
     *   Canvas.destroy this canvas on a timeout. This method should be used instead of
     *   calling canvas.destroy() directly unless there's a reason a the canvas needs to be
     *   destroyed synchronously. By using a timeout, this method ensures the destroy() will
     *   occur after the current thread of execution completes. This allows you to easily mark canvases
     *   for destruction while they're handling events, which must complete before the canvas can be
     *   destroyed.
     * 
     */
    open fun markForDestroy(): Unit = definedExternally
    /**
     *   Returns the outer DOM element of this Canvas. This method is provided for the
     *   very rare cases where a programmer needs to examine the DOM hierarchy created by
     *   a drawn SmartClient component.
     * 
     *   Direct manipulation of the DOM elements created by SmartClient components
     *   is not supported. SmartClient components should be rendered or cleared using
     *   standard methods such as Canvas.draw, Canvas.clear. If direct
     *   integration with existing DOM structures is required, this should be achieved via the
     *   Canvas.htmlElement attribute, rather than by attempting to move the
     *   component's outer element via native browser APIs.
     *   The content of SmartClient components' DOM elements should also not be directly
     *   manipulated using native browser APIs - standard methods such as
     *   Canvas.setContents, Canvas.addChild, Canvas.removeChild,
     *   Canvas.markForRedraw and Canvas.redraw should be used instead.
     * 
     *   In some cases, the element returned may match the element returned by
     *   Canvas.getContentElement, but this will not always be the case.
     * 
     *   If the widget is undrawn, this method will return null.
     * 
     * 
     */
    open fun getOuterElement(): DOMElement = definedExternally
    /**
     *   Returns the DOM element for this Canvas which contains the Canvas.contents, or
     *   for Canvas.getParentCanvas, the DOM elements for any drawn
     *   children. This method is provided for the
     *   very rare cases where a programmer needs to examine the DOM hierarchy created by
     *   a drawn SmartClient component.
     * 
     *   Direct manipulation of the DOM elements created by SmartClient components
     *   is not supported. SmartClient components should be rendered or cleared using
     *   standard methods such as Canvas.draw, Canvas.clear. If direct
     *   integration with existing DOM structures is required, this should be achieved via the
     *   Canvas.htmlElement attribute, rather than by attempting to move the
     *   component's outer element via native browser APIs.
     *   The content of SmartClient components' DOM elements should also not be directly
     *   manipulated using native browser APIs - standard methods such as
     *   Canvas.setContents, Canvas.addChild, Canvas.removeChild,
     *   Canvas.markForRedraw and Canvas.redraw should be used instead.
     * 
     *   In some cases, the element returned may match the element returned by
     *   Canvas.getOuterElement, but this will not always be the case.
     * 
     *   If the widget is undrawn, this method will return null.
     * 
     * 
     */
    open fun getContentElement(): DOMElement = definedExternally
    /**
     *   Adds newChild as a child of this widget, set up a named object reference (i.e., this[name])
     *   to the new widget if name argument is provided, and draw the child if this widget has been
     *   drawn already.
     * 
     *   If newChild has a parent it will be removed from it. If it has a master, it will be detached
     *   from it if the master is a child of a different parent. If newChild has peers, they'll be
     *   added to this widget as children as well.
     * 
     * 
     *  @param {Canvas} new child canvas to add
     *  @param {string=} name to assign to child (eg: this[name] == child)
     *  @param {boolean=} if false, child will not automatically be drawn (only                     for advanced use)
     */
    open fun addChild(newChild: Canvas, name: String?, autoDraw: Boolean?): Canvas = definedExternally
    /**
     *   Remove a peer from this Canvas
     * 
     *  @param {Canvas} Peer to be removed from this canvas
     *  @param {string=} If this peer was assigned a name when added via addPeer(), it should            be passed in here to ensure no reference is kept to the peer
     */
    open fun removePeer(peer: Canvas, name: String?): Unit = definedExternally
    /**
     *   Make this Canvas no longer a peer of its master
     * 
     */
    open fun depeer(): Unit = definedExternally
    /**
     *   Remove this canvas from its parent if it has one.
     * 
     */
    open fun deparent(): Unit = definedExternally
    /**
     *   Remove a child from this parent.
     * 
     *  @param {Canvas} Child canvas to remove from this parent.
     *  @param {string=} If the child canvas was assigned a name when added via addChild(), it            should be passed in here to ensure no reference is kept to the child
     */
    open fun removeChild(child: Canvas, name: String?): Unit = definedExternally
    /**
     *   Adds newPeer as a peer of this widget (also making it a child of this widget's parent, if
     *   any), set up a named object reference (i.e., this[name]) to the new widget if name is
     *   provided, and draw the peer if this widget has been drawn already.
     * 
     *   The widget to be added as a peer will be removed from its old master and/or parent, if any,
     *   and it will be added as a child to the parent of this canvas (if any)
     * 
     * 
     *  @param {Canvas} new peer widget to add
     *  @param {string=} name to assign to peer (eg: this[peer] == child)
     *  @param {boolean=} if true, peer will not automatically be drawn (only               for advanced use)
     *  @param {boolean=} if true, when draw is called on the master widget, the peer              will be drawn before the master
     */
    open fun addPeer(newPeer: Canvas, name: String?, autoDraw: Boolean?, preDraw: Boolean?): Canvas = definedExternally
    /**
     *   Set the snapTo property of this canvas, and handle repositioning.
     * 
     * 
     *  @param {string} new snapTo value
     */
    open fun setSnapTo(snapTo: String): Unit = definedExternally
    /**
     *   Return the snapTo value of this object
     * 
     * 
     */
    open fun getSnapTo(): String = definedExternally
    /**
     *   Set the snapEdge property of this canvas, and handle repositioning.
     * 
     * 
     *  @param {string} new snapEdge value
     */
    open fun setSnapEdge(snapEdge: String): Unit = definedExternally
    /**
     *   Return the snapEdge value of this object
     * 
     * 
     */
    open fun getSnapEdge(): String = definedExternally
    /**
     *   Returns the parent of this canvas, if any.
     * 
     */
    open fun getParentCanvas(): Canvas = definedExternally
    /**
     *   Returns this canvas's "master" (the canvas to which it was added as a peer), if any.
     * 
     */
    open fun getMasterCanvas(): Canvas = definedExternally
    /**
     *   Returns an array of object references to all ancestors of this widget in the containment
     *   hierarchy, starting with the direct parent and ending with the top element.
     * 
     */
    open fun getParentElements(): Array<dynamic> = definedExternally
    /**
     *     Returns true if element is a descendant of this widget (i.e., exists below this widget in
     *     the containment hierarchy); and false otherwise.
     * 
     *  @param {Canvas} the canvas to be tested
     *  @param {boolean=} If passed this method will return true if the canvas                parameter is a pointer to this widget.
     */
    open fun contains(canvas: Canvas, testSelf: Boolean?): Boolean = definedExternally
    /**
     *   Show a clickMask over the entire screen that intercepts mouse clicks and fires some action.
     *   The mask created will be associated with this canvas - calling this method multiple times
     *   will not show multiple (stacked) clickMasks if the mask associated with this canvas is
     *   already up.
     * 
     *   The clickMask useful for modal dialogs, menus and similar uses, where any click outside of
     *   some Canvas should either be suppressed (as in a modal dialog) or just cause something (like
     *   dismissing a menu).
     * 
     * 
     *  @param {Callback} action to fire when the user clicks on the mask
     *  @param {ClickMaskMode} whether to automatically hide the clickMask on mouseDown                   and suppress the mouseDown event from reaching                    the target under the mouse
     *  @param {any | Array<Partial<any>>} initially unmasked targets for this clickMask. Note that if this is a "hard"  mask, unmasked children of masked parents are not supported so any non-top-level widgets  passed in will have their parents unmasked. Children of unmasked parents can never be  masked, so you need only include the top widget of a hierarchy.
     */
    open fun showClickMask(clickAction: dynamic, mode: 
                                                       /**
                                                        *  When the mask receives a click, it will fire its click action,          and cancel the event, leaving the clickMask up.
                                                        *  When the mask receives a click, it will fire its click action,          then dismiss the clickMask and allow the event to proceed to its target.
                                                        */
                                                       String /* hard |  soft */, unmaskedTargets: dynamic): String = definedExternally
    /**
     *   Hides the click mask associated with this canvas.
     * 
     *  @param {string=} optional ID of specific clickMask to hide. If not passed,           defaults to hiding the click mask associated with this widget only.
     */
    open fun hideClickMask(ID: String?): Unit = definedExternally
    /**
     *   Determines whether a clickmask is showing
     * 
     *  @param {string=} optional ID of specific clickMask to check. If not passed,           checks for the click mask associated with this widget only.
     */
    open fun clickMaskUp(ID: String?): Boolean = definedExternally
    /**
     *   Temporariy block all user interaction with children of this widget, with the exception of those
     *   passed in in the unmaskedChildren parameter. Children will remain blocked until
     *   Canvas.hideComponentMask is called.
     * 
     *   This method will show the Canvas.componentMask canvas to block mouse interaction with
     *   children, and temporarily remove masked children from the page's tab-order.
     * 
     *   This behavior differs from the standard Canvas.showClickMask in that the
     *   modal mask shown by Canvas.showClickMask will cover the entire screen and typically only
     *   allow "unmasking" of top level components.
     * 
     *   Use Canvas.hideComponentMask to hide the component level mask.
     * 
     * 
     *  @param {Array<Partial<Canvas>>=} Children passed into this parameter will continue to    be interactive while other children are blocked. They will be moved above the componentMask in    the page's z-order and remain accessible via keyboard navigation. Note that this array should    contain direct children of this widget only.
     */
    open fun showComponentMask(unmaskedChildren: Array<dynamic>?): Unit = definedExternally
    /**
     *   Hide the Canvas.showComponentMask for this widget
     * 
     *  @param {boolean=} By default when the component-level mask is hidden   it will attempt to reset focus to whatever had focus before the mask was shown.    Pass this parameter to suppress this behavior.
     */
    open fun hideComponentMask(suppressFocusReset: Boolean?): Unit = definedExternally
    /**
     *   Set all four coordinates, relative to the enclosing context, at once.
     * 
     *   Moves the widget so that its top-left corner is at the specified top-left coordinates,
     *   then resizes it to the specified width and height.
     * 
     * 
     *  @param {number | Array<any> | object=} new left coordinate, Array of                         coordinates in parameter order, or Object                          with left, top, width, height properties.                          If an Array or Object is passed, the                          remaining parameters are ignored.
     *  @param {number=} new top coordinate
     *  @param {number=} new width
     *  @param {number=} new height
     */
    open fun setRect(left: dynamic?, top: Number?, width: Number?, height: Number?): Boolean = definedExternally
    /**
     *       Return the left coordinate of this object, relative to its enclosing context, in pixels.
     * 
     */
    open fun getLeft(): Number = definedExternally
    /**
     *       Set the left coordinate of this object, relative to its enclosing context, in pixels.
     *       NOTE: if you're setting multiple coordinates, use setRect(), moveTo() or resizeTo()
     *       instead
     * 
     *  @param {number | string} new left coordinate
     */
    open fun setLeft(left: dynamic): Unit = definedExternally
    /**
     *   Return the top coordinate of this object, relative to its enclosing context, in pixels.
     * 
     */
    open fun getTop(): Number = definedExternally
    /**
     *   Set the top coordinate of this object, relative to its enclosing context, in pixels.
     * 
     *   NOTE: if you're setting multiple coordinates, use setRect() or moveTo() instead
     * 
     * 
     *  @param {number | string} new top coordinate
     */
    open fun setTop(top: dynamic): Unit = definedExternally
    /**
     *   Setter for Canvas.leavePageSpace.
     * 
     * 
     *  @param {Integer} new value for leavePageSpace.
     */
    open fun setLeavePageSpace(newPageSpace: Number): Unit = definedExternally
    /**
     *   Return the width of this object, in pixels.
     * 
     */
    open fun getWidth(): Number = definedExternally
    /**
     *   Resizes the widget horizontally to the specified width (moves the right side of the
     *   widget). The width parameter can be expressed as a percentage of viewport size or as
     *   the number of pixels.
     * 
     *   NOTE: if you're setting multiple coordinates, use resizeTo() or setRect() instead
     * 
     * 
     *  @param {number | string} new width
     */
    open fun setWidth(width: dynamic): Unit = definedExternally
    /**
     *   Return the height of this object, in pixels.
     * 
     */
    open fun getHeight(): Number = definedExternally
    /**
     *   Resizes the widget vertically to the specified height (moves the bottom side of the
     *   widget). The height parameter can be expressed as a percentage of viewport size or as
     *   the number of pixels.
     * 
     *   NOTE: if you're setting multiple coordinates, use resizeTo() or setRect() instead
     * 
     * 
     *  @param {number | string} new height
     */
    open fun setHeight(height: dynamic): Unit = definedExternally
    /**
     *   Resizes the widget horizontally if required to satisfy the specified Canvas.minWidth.
     * 
     * 
     *  @param {number} new minimum width
     */
    open fun setMinWidth(width: Number): Unit = definedExternally
    /**
     *   Resizes the widget vertically if required to satisfy the specified Canvas.minHeight.
     * 
     * 
     *  @param {number} new minimum height
     */
    open fun setMinHeight(height: Number): Unit = definedExternally
    /**
     *   Return the right coordinate of this object as rendered, relative to its enclosing context,
     *   in pixels.
     * 
     * 
     */
    open fun getRight(): Number = definedExternally
    /**
     *   Resizes the widget horizontally to position its right side at the specified coordinate.
     * 
     *   NOTE: if you're setting multiple coordinates, use setRect(), moveTo() or resizeTo()
     *   instead
     * 
     * 
     *  @param {number} new right coordinate
     */
    open fun setRight(right: Number): Unit = definedExternally
    /**
     *   Return the bottom coordinate of this object as rendered, relative to its enclosing context,
     *   in pixels.
     * 
     * 
     */
    open fun getBottom(): Number = definedExternally
    /**
     *   Resizes the widget vertically to position its bottom edge at the specified coordinate.
     * 
     *   NOTE: if you're setting multiple coordinates, use setRect(), moveTo() or resizeTo()
     *   instead
     * 
     * 
     *  @param {number} new bottom coordinate
     */
    open fun setBottom(bottom: Number): Unit = definedExternally
    /**
     *   Returns the scrollable width of the widget's contents, including children, ignoring
     *   clipping.
     * 
     */
    open fun getScrollWidth(): Number = definedExternally
    /**
     *       Returns the scrollable height of the widget's contents, including children, ignoring
     *       clipping.
     * 
     */
    open fun getScrollHeight(): Number = definedExternally
    /**
     *   Get the number of pixels this Canvas is scrolled from its left edge.
     * 
     */
    open fun getScrollLeft(): Number = definedExternally
    /**
     *   Get the number of pixels this Canvas is scrolled from its top edge.
     * 
     */
    open fun getScrollTop(): Number = definedExternally
    /**
     *   Set the page-relative left coordinate of this widget.
     * 
     * 
     *  @param {number} new left coordinate in pixels
     */
    open fun setPageLeft(left: Number): Unit = definedExternally
    /**
     *   Set the page-relative top coordinate of this widget.
     * 
     * 
     *  @param {number} new top coordinate in pixels
     */
    open fun setPageTop(top: Number): Unit = definedExternally
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
     *   Return the page-relative right coordinate of this object, in pixels.
     * 
     * 
     */
    open fun getPageRight(): Number = definedExternally
    /**
     *   Return the page-relative bottom coordinate of this object, in pixels.
     * 
     */
    open fun getPageBottom(): Number = definedExternally
    /**
     *   Set the CSS Margin, in pixels, for this component. Margin provides blank space outside of
     *   the border.
     * 
     *   This property sets the same thickness of margin on every side. Differing per-side
     *   margins can be set in a CSS style and applied via Canvas.styleName.
     * 
     *   Note that the specified size of the widget will be the size including the margin
     *   thickness on each side.
     * 
     * 
     *  @param {number} new margin in pixels
     */
    open fun setMargin(margin: Number): Unit = definedExternally
    /**
     *   Set the CSS padding of this component, in pixels. Padding provides space between the border
     *   and the component's contents.
     * 
     *   This property sets the same thickness of padding on every side. Differing per-side
     *   padding can be set in a CSS style and applied via Canvas.styleName.
     * 
     * 
     *  @param {number} new padding in pixels
     */
    open fun setPadding(newPadding: Number): Unit = definedExternally
    /**
     *   Return whether or not this object contains the specified global (x,y) coordinates.
     * 
     *   Will return false if any parent canvas does not contain the specified point, (EG:
     *   you're hovering over an element's absolute location, but it is scrolled out of
     *   view in a parent element)
     * 
     * 
     *  @param {Integer} GLOBAL x-coordinate
     *  @param {Integer} GLOBAL y-coordinate
     *  @param {boolean=} point lies specifically within our viewport                       (drawn area excluding margins and scrollbars if                        present)
     */
    open fun containsPoint(x: Number, y: Number, withinViewport: Boolean?): Boolean = definedExternally
    /**
     *   Does this widget contain the specified global (x,y) coordinates, and have no other widgets
     *   also at the specified position, obscuring this one? This is commonly used for (for example)
     *   drag and drop interactions.
     * 
     * 
     *  @param {number} GLOBAL x-coordinate
     *  @param {number} GLOBAL y-coordinate
     *  @param {boolean=} point lies within our viewport rather than                       just our drawn area
     *  @param {Canvas=} If passed ignore widget(s), do not check whether                     those widgets occludes this one.
     *  @param {Canvas=} If passed, only check for siblings occluding the       component up as far as the specified parent widget.
     */
    open fun visibleAtPoint(x: Number, y: Number, withinViewport: Boolean?, ignoreWidgets: Canvas?, upToParent: Canvas?): Boolean = definedExternally
    /**
     *       Returns true if the rectangles of this widget and the specified widget overlap.
     * 
     *  @param {Canvas} other canvas to test for intersection
     */
    open fun intersects(other: Canvas): Boolean = definedExternally
    /**
     *       Returns true if the rectangle of this widget intersects with the rectangle coordinates
     *       passed in, and false otherwise.
     * 
     *  @param {number | Array<any>} left coord of rect (or rect array)
     *  @param {number} top coord of rect
     *  @param {number} width of rect
     *  @param {number} height of rect
     */
    open fun intersectsRect(left: dynamic, top: Number, width: Number, height: Number): Boolean = definedExternally
    /**
     *   Returns true if the rectangle of this widget encloses the rectangle of the specified widget.
     * 
     *  @param {Canvas} other canvas to test for enclosure
     */
    open fun encloses(other: Canvas): Boolean = definedExternally
    /**
     *   Returns true if the rectangle of this widget encloses the rectangle coordinates
     *   passed in, and false otherwise.
     * 
     *  @param {number | Array<Partial<number>>} left coord of rect (or rect array)
     *  @param {number} top coord of rect
     *  @param {number} width of rect
     *  @param {number} height of rect
     */
    open fun enclosesRect(left: dynamic, top: Number, width: Number, height: Number): Boolean = definedExternally
    /**
     *       Return true if the last event's mouse coordinates are within the bounds of this component.
     *     NOTE: Z-ordering is not considered for the purposes of this test. If the coordinate you're
     *     testing is occluded by other component, but the X,Y coordinates are still within the bounds
     *     of that component, this method will return true.
     * 
     * 
     */
    open fun containsEvent(): Boolean = definedExternally
    /**
     *   Return the X-coordinate of the last event relative to the left edge of the content of this
     *   Canvas.
     * 
     *   NOTE: To get a coordinate relative to the viewport of this Canvas, subtract
     *   this.getScrollLeft()
     * 
     * 
     */
    open fun getOffsetX(): Number = definedExternally
    /**
     *   Return the Y-coordinate of the last event, relative to the top edge of the content of this
     *   Canvas.
     * 
     *   NOTE: To get a coordinate relative to the viewport of this Canvas, subtract
     *   this.getScrollTop()
     * 
     * 
     */
    open fun getOffsetY(): Number = definedExternally
    /**
     *   Returns the thickness of this widget's scrollbars.
     *   For canvases showing custom scrollbars this is determined from this.scrollbarSize
     * 
     * 
     */
    open fun getScrollbarSize(): Number = definedExternally
    /**
     *   Returns the width of the viewport onto the scrollable content.
     * 
     * 
     */
    open fun getViewportWidth(): Number = definedExternally
    /**
     *   Returns the height of the viewport onto the scrollable content.
     * 
     * 
     */
    open fun getViewportHeight(): Number = definedExternally
    /**
     *   Returns the amount of space available for (an) absolutely positioned child widget(s) or
     *   absolutely positioned HTML content, without introducing clipping, scrolling or overflow.
     * 
     *   This is the space within the viewport of the widget (including padding, but excluding
     *   margins, borders or scrollbars) rendered at its specified size.
     * 
     * 
     */
    open fun getInnerHeight(): Number = definedExternally
    /**
     *   Returns the amount of space available for absolutely positioned child widget(s) or
     *   absolutely positioned HTML content, without introducing clipping, scrolling or overflow.
     * 
     *   This is the space within the viewport of the widget (including padding, but excluding
     *   margins, borders or scrollbars) rendered at its specified size.
     * 
     * 
     */
    open fun getInnerWidth(): Number = definedExternally
    /**
     *   Returns the amount of space available for interior content (or relatively positioned child
     *   widget(s)) without introducing clipping, scrolling or overflow.
     *   This is the space within the viewport of the widget (not including padding, and excluding
     *   margins, borders or scrollbars) rendered at its specified size.
     * 
     * 
     */
    open fun getInnerContentHeight(): Number = definedExternally
    /**
     *   Returns the amount of space available for interior content (or relatively positioned child
     *   widget(s)) without introducing clipping, scrolling or overflow.
     *   This is the space within the viewport of the widget (not including padding, and excluding
     *   margins, borders or scrollbars) rendered at its specified size.
     * 
     * 
     */
    open fun getInnerContentWidth(): Number = definedExternally
    /**
     *     Return the visible width of the Canvas.
     * 
     * 
     */
    open fun getVisibleWidth(): Number = definedExternally
    /**
     *     Return the visible height of the Canvas.
     * 
     * 
     */
    open fun getVisibleHeight(): Number = definedExternally
    /**
     *       Moves the widget deltaX pixels to the right and deltaY pixels down. Pass negative
     *       numbers to move up and/or to the left.
     * 
     *  @param {Integer} amount to move horizontally (may be negative)
     *  @param {Integer} amount to move vertically (may be negative)
     */
    open fun moveBy(deltaX: dynamic, deltaY: dynamic): Boolean = definedExternally
    /**
     *   Moves the widget so that its top-left corner is at the specified coordinates.
     * 
     *   This method will also accept a single parameter as an object array with left and top given
     *   as properties.
     * 
     * 
     *  @param {number | object=} x-coordinate to move to in LOCAL coordinates                       or Object with left and top properties.
     *  @param {number=} y-coordinate to move to in LOCAL coordinates
     */
    open fun moveTo(left: dynamic?, top: Number?): Boolean = definedExternally
    /**
     *   Get an offset to be used when calculating snap positioning. Returns 0 by default.
     * 
     * 
     *  @param {Canvas=} the child that is being snapped
     */
    open fun getVSnapOrigin(snapChild: Canvas?): Number = definedExternally
    /**
     *   Get an offset to be used when calculating snap positioning. Returns 0 by default.
     * 
     * 
     *  @param {Canvas=} the child that is being snapped
     */
    open fun getHSnapOrigin(snapChild: Canvas?): Number = definedExternally
    /**
     *   Show this widget next to another widget on the page, positioned such that it will
     *   not extend beyond the browser viewport.
     * 
     *   Note that this method simply sets the coordinates of the widget and displays it (using
     *   a Canvas.animateShow by default). It will
     *   not change the Canvas.parentElement of either component.
     * 
     *   An example use case might be showing a menu next to a menu-button.
     * 
     * 
     *  @param {Canvas} Canvas to show next to
     *  @param {string=} Which side of the other canvas should we put. Options are                 "top", "bottom", "left", "right". (Defaults to "right")
     *  @param {boolean=} This argument controls whether this canvas can be positioned on top of the other  widget if there isn't room to put it next to the other widget extending out of the  browser viewport  If 'canOcclude' is true, simply shift this widget over the other widget, so that  it ends up onscreen. If 'canOcclude' is false, avoid extending offscreen  by positioning this widget on the other side of the other widget.
     *  @param {boolean=} If false do not use an animation to show the component.
     */
    open fun showNextTo(otherWidget: Canvas, side: String?, canOcclude: Boolean?, skipAnimation: Boolean?): Unit = definedExternally
    /**
     *   Move this canvas to the specified point, or as close to the specified point as possible
     *   without this widget extending beyond the edge of the browser viewport on any side.
     * 
     *  @param {number=} Left coordinate (defaults to mouse position)
     *  @param {number=} Top coordinate (defaults to mouse position)
     */
    open fun placeNear(left: Number?, top: Number?): Unit = definedExternally
    /**
     *       Resizes the widget, adding deltaX to its width and deltaY to its height (moves the right
     *       and/or bottom sides of the widget).
     * 
     *  @param {number=} amount to resize horizontally (may be negative)
     *  @param {number=} amount to resize vertically (may be negative)
     */
    open fun resizeBy(deltaX: dynamic?, deltaY: dynamic?): Boolean = definedExternally
    /**
     *   Observable method called whenever a Canvas changes size. Note that if this canvas is
     *   Canvas.overflow, and is waiting for a queued redraw (see
     *   Canvas.isDirty), the value for Canvas.getVisibleWidth and
     *   Canvas.getVisibleHeight will be unreliable until redraw() fires.
     * 
     */
    open fun resized(): Unit = definedExternally
    /**
     *   Setter method for the Canvas.percentSource attribute.
     * 
     *  @param {Canvas=} eterNew percent source (if omitted existing                   percentSource will just be cleared).
     */
    open fun setPercentSource(sourceWidget: Canvas?): Unit = definedExternally
    /**
     * 
     *   layoutChildren() is where a Canvas should implement a sizing policy for it's
     *   Canvas children. Since layoutChildren calls parentResized() on its children,
     *   Canvas.parentResized is a good place for a child to implement a layout policy that
     *   can be used within any parent.
     * 
     *   Recommended practice for a Canvas that manages Canvas children is to create those children
     *   without any initial coordinate or size settings and do all sizing when layoutChildren() is
     *   called.
     * 
     *   layoutChildren() is always called at least once before children are drawn, and is called
     *   automatically whenever the viewport size changes (which includes both resizing and
     *   introduction/removal of scrolling). layoutChildren() can also be manually invoked in any
     *   other component-specific situation which changes the layout.
     * 
     *   NOTE: layoutChildren() may be called before draw() if a widget is resized before draw(), so
     *   be sure to avoid errors such as assuming that any children you automatically create have
     *   already been created.
     * 
     *   NOTE: auto-sizing: layoutChildren() is also called once during the initial draw(), before
     *   children are drawn, with a "reason" of "initial draw". During this invocation of
     *   layoutChildren() it is legal to directly draw children (call child.draw()), which is
     *   otherwise never allowed. This allows a Canvas to implement an auto-sizing layout policy by
     *   drawing some children before deciding on the sizes of remaining children, which is far more
     *   efficient than drawing all children and resizing some of them after they are drawn.
     * 
     *  @param {string} reason why layoutChildren() is being called, passed when framework            code invokes layoutChildren()
     */
    open fun layoutChildren(reason: String): Unit = definedExternally
    /**
     *       Resizes the widget to the specified width and height (moves the right and/ or bottom
     *       sides of the widget). The width and height parameters can be expressed as a percentage
     *       of viewport size or as the number of pixels.
     * 
     *  @param {number=} new width for canvas.
     *  @param {number=} new height for canvas
     */
    open fun resizeTo(width: Number?, height: Number?): Boolean = definedExternally
    /**
     *   Fires when the interior size of the parent changes, including parent resize and
     *   scrollbar introduction or removal.
     * 
     *   This method allows a child to implement a layout policy that can be used within any
     *   parent, such as a Resizer component that always snaps to the parent's
     *   bottom-right corner. The default implementation of this method applies a child's
     *   percent sizes, if any, or implements layout based on the Canvas.snapTo property
     * 
     */
    open fun parentResized(): Unit = definedExternally
    /**
     *   If Canvas.dragAppearance is set to "tracker", this method will be called
     *   (if defined), when the user starts to drag this widget. It is an opportunity to update the
     *   drag tracker to display something relative to this canvas. Typical implementation will
     *   be to call EventHandler.setDragTracker, passing in the desired custom tracker HTML
     *   as a string
     * 
     */
    open fun setDragTracker(): Boolean = definedExternally
    /**
     *   If this widget is showing scrollbars, and a user drags close to the edge of the viewport,
     *   should we scroll the viewport in the appropriate direction?
     *   Returns this.canDragScroll if there are scrollbars, else false.
     * 
     */
    open fun shouldDragScroll(): Unit = definedExternally
    /**
     *   Update the Canvas.overflow of a Canvas after it has been created.
     * 
     *  @param {Overflow} New overflow value.
     */
    open fun setOverflow(newOverflow: 
                                      /**
                                       *  Content that extends beyond the widget's width or height is               displayed.
                                       *                 Note: To have the content be sized only by the drawn size of
                                       *                 the content set the overflow to be Canvas.VISIBLE and specify
                                       *                 a small size, allowing the size to expand to the size required
                                       *                 by the content.
                                       *                 Leaving the width / height for the widget undefined will use the
                                       *                 default value of 100, and setting the size to zero may cause the
                                       *                 widget not to draw.
                                       *  Content that extends beyond the widget's width or height is               clipped (hidden).
                                       *  Horizontal and/or vertical scrollbars are displayed only if               necessary. Content that extends beyond the remaining visible
                                       *                 area is clipped.
                                       *  Horizontal and vertical scrollbars are always drawn inside the               widget. Content that extends beyond the remaining visible area
                                       *                 is clipped, and can be accessed via scrolling.
                                       *  Clip horizontally but extend the canvas's clip region               vertically if necessary. Note: only supported for
                                       *                 specific widget subclasses.
                                       *  Clip vertically but extend the canvas's clip region               horizontally if necessary. Note: only supported
                                       *                 for specific widget subclasses.
                                       */
                                      String /* visible |  hidden |  auto |  scroll |  clip-h |  clip-v */): Unit = definedExternally
    /**
     *   This method tells a component to adjust for changes in the size of its content that happen
     *   outside of SmartClient APIs. This may include:
     * 
     * 
     *  - size changes due to "replaced" HTML elements (elements that may change size after their
     *     content loads, such as &lt;img&gt; tags with no sizes). To avoid the need to call
     *     adjustForContent(), specify sizes on replaced elements wherever possible.
     * 
     * 
     *  - modification of HTML contained in a Canvas by direct manipulation of the DOM - see the
     *     domIntegration. Note that only contents
     *     supplied to a widget via Canvas.contents or via an override of
     *     Canvas.getInnerHTML should be manipulated directly. Contents automatically
     *     generated by SmartClient components (such as the basic structure of a Button) should
     *     never be manipulated: these structures are considered internal, differ by platform,
     *     and will change without notice.
     * 
     * 
     * 
     *  @param {boolean} By default the adjustment will occur on a small delay for performance reasons.  Pass in this parameter to force immediate adjustment.
     */
    open fun adjustForContent(immediate: Boolean): Unit = definedExternally
    /**
     *   Returns the scrollTop required to scroll vertically to the end of this widget's content.
     * 
     */
    open fun getScrollBottom(): Number = definedExternally
    /**
     *   Returns the scrollLeft required to scroll horizontally to the end of this widget's content.
     * 
     */
    open fun getScrollRight(): Number = definedExternally
    /**
     *   Vertically scrolls the content of the widget to 0
     * 
     * 
     */
    open fun scrollToTop(): Unit = definedExternally
    /**
     *   Vertically scrolls the content of the widget to the end of its content
     * 
     * 
     */
    open fun scrollToBottom(): Unit = definedExternally
    /**
     *   Horizontally scrolls the content of the widget to 0
     * 
     * 
     */
    open fun scrollToLeft(): Unit = definedExternally
    /**
     *   Horizontally scrolls the content of the widget to the end of its content
     * 
     * 
     */
    open fun scrollToRight(): Unit = definedExternally
    /**
     *   Scroll this widget by some pixel increment in either (or both) direction(s).
     * 
     * 
     *  @param {number} Number of pixels to scroll horizontally
     *  @param {number} Number of pixels to scroll vertically
     */
    open fun scrollBy(dX: Number, dY: Number): Unit = definedExternally
    /**
     *   Scroll this widget by some percentage of scroll size in either (or both) direction(s).
     * 
     * 
     *  @param {number | string} Percentage to scroll horizontally. Will accept either                   a numeric percent value, or a string like "10%".
     *  @param {number | string} Percentage to scroll horizontally. Will accept either                   a numeric percent value, or a string like "10%".
     */
    open fun scrollByPercent(dX: dynamic, dY: dynamic): Unit = definedExternally
    /**
     *   Scrolls the content of the widget so that the origin (top-left corner) of the content
     *   is left pixels to the left and top pixels above the widget's top-left corner (but still
     *   clipped by the widget's dimensions).
     * 
     *   This is guaranteed to be called whenever this Canvas is scrolled, whether scrolling is
     *   initiated programmatically, by custom scrollbars, or a by a native scrollbar.
     * 
     * 
     *  @param {Integer=} the left coordinate
     *  @param {Integer=} the top coordinate
     */
    open fun scrollTo(left: Number?, top: Number?): Unit = definedExternally
    /**
     *   Scroll this widget to some position specified as a percentage of scroll size in either
     *   (or both) direction(s).
     * 
     * 
     *  @param {number | string} Left Percentage position to scroll to                    Will accept either a numeric percent value, or a                     string like "10%".
     *  @param {number | string} Top Percentage position to scroll to                    Will accept either a numeric percent value, or a                    string like "10%".
     */
    open fun scrollToPercent(left: dynamic, top: dynamic): Unit = definedExternally
    /**
     *   This method is the programmatic equivalent of the user pressing the "Page Up" key while
     *   this widget has the focus. It scrolls the widget's content upwards by the viewport
     *   height, if the content can be scrolled that far upwards
     * 
     */
    open fun pageScrollUp(): Unit = definedExternally
    /**
     *   This method is the programmatic equivalent of the user pressing the "Page Down" key while
     *   this widget has the focus. It scrolls the widget's content downwards by the viewport
     *   height, if the content can be scrolled that far downwards
     * 
     */
    open fun pageScrollDown(): Unit = definedExternally
    /**
     *   Sets this widget's visibility to "inherit", so that it becomes visible if all of its parents
     *   are visible or it has no parents.
     * 
     *   If the widget has not yet been drawn (and doesn't have a parent or master), this method
     *   calls the draw method as well.
     * 
     * 
     */
    open fun show(): Unit = definedExternally
    /**
     *   Recursively show the canvas and all its parents so the canvas will be visible.
     * 
     *   If the widget has not yet been drawn, this method calls the draw method as well.
     * 
     * 
     */
    open fun showRecursively(): Unit = definedExternally
    /**
     *   Returns this Canvas's "panel container". A panel container is a widget that manages a
     *   collection of panels, like a TabSet or SectionStack. If this
     *   Canvas is not a child of such a panel container, this method returns null.
     * 
     * 
     */
    open fun getPanelContainer(): Canvas = definedExternally
    /**
     *   Sets this Canvas's "panel container". A panel container is a widget that manages a
     *   collection of panels, like a TabSet or SectionStack. SmartClient
     *   uses this method internally when child panels are added to panel container widgets; if you
     *   need to create a panel container widget that does not extend one of the built-in ones (these
     *   are TabSet, SectionStack and Window), your code
     *   should do the same thing.
     * 
     * 
     *  @param {Canvas} The container widget for this canvas
     */
    open fun setPanelContainer(container: Canvas): Unit = definedExternally
    /**
     *   For "panel container" widgets like TabSet or SectionStack, this
     *   method reveals the child Canvas passed in by whatever means is applicable for the particular
     *   type of container. For example, when called on a TabSet, it selects the tab containing the
     *   passed-in child.
     * 
     *   For other types of Canvas, this method simply shows the passed-in child if it is not
     *   currently visible.
     * 
     *   If the passed-in widget is not a child of this Canvas, this method has no effect
     * 
     * 
     *  @param {GlobalId | Canvas} the child Canvas to reveal, or its global ID
     */
    open fun revealChild(child: dynamic): Unit = definedExternally
    /**
     *       Sets the widget's CSS visibility attribute to "hidden".
     * 
     */
    open fun hide(): Unit = definedExternally
    /**
     *   Returns true if the widget is visible, taking all parents into account, so that a widget
     *   which is not hidden might still report itself as not visible if it is within a hidden
     *   parent.
     * 
     *   NOTE: Undrawn widgets will report themselves as visible if they would be visible if drawn.
     * 
     * 
     */
    open fun isVisible(): Boolean = definedExternally
    /**
     *   set the enabled state of this object.
     * 
     * 
     *  @param {boolean} pass false to disable or anything else to enable
     *  @deprecated \* As of Smartclient version 5.5, deprecated in favor of Canvas.setDisabled
     */
    open fun setEnabled(newState: Boolean): Unit = definedExternally
    /**
     *   set the disabled state of this object
     * 
     *  @param {boolean} new disabled state of this object - pass true to disable the widget
     */
    open fun setDisabled(disabled: Boolean): Unit = definedExternally
    /**
     *   Enables this widget and any children / peers of this widget.
     * 
     */
    open fun enable(): Unit = definedExternally
    /**
     *   Disables this widget and any children and peers of this widget.
     * 
     */
    open fun disable(): Unit = definedExternally
    /**
     *   Is this canvas disabled? Note that the disabled state is inherited - this method will return
     *   true if this widget, or any of its ancestors are marked disabled.
     * 
     */
    open fun isDisabled(): Boolean = definedExternally
    /**
     *   Returns true if the widget and all widgets above it in the containment hierarchy are enabled.
     *   Returns false otherwise.
     * 
     *  @deprecated \* As of SmartClient version 5.5 deprecated in favor of Canvas.isDisabled.
     */
    open fun isEnabled(): Boolean = definedExternally
    /**
     *   Change whether a widget can accept keyboard focus.
     * 
     *  @param {boolean} whether the widget should now accept focus
     */
    open fun setCanFocus(canFocus: Boolean): Unit = definedExternally
    /**
     *   Returns true if this Canvas has the keyboard focus. Note that in Internet Explorer
     *   focus notifications can be asynchronous (see EventHandler.synchronousFocusNotifications).
     *   In this case, canvas.isFocused() method can correctly
     *   return false when, intuitively, you would expect it to return true:
     * 
     *     someCanvas.focus();
     *     if (someCanvas.isFocused()) {
     *       // In most browsers we would get here, but not in Internet Explorer with
     *       // EventHandler.synchronousFocusNotifications disabled.
     *     }
     * 
     */
    open fun isFocused(): Boolean = definedExternally
    /**
     *   If this canvas can accept focus, give it keyboard focus. After this method, the canvas
     *   will appear focused and will receive keyboard events.
     * 
     */
    open fun focus(): Unit = definedExternally
    /**
     *   If this canvas has keyboard focus, blur it. After this method, the canvas
     *   will no longer appear focused and will stop receiving keyboard events.
     * 
     */
    open fun blur(): Unit = definedExternally
    /**
     *   Returns true if the keyboard focus is in this Canvas or any child of this Canvas.
     * 
     */
    open fun containsFocus(): Boolean = definedExternally
    /**
     *   Set the accessKey for this canvas.
     * 
     *   The accessKey can be set to any alphanumeric character (symbols not supported)
     *   Having set an accessKey, the canvas will be given focus when the user hits
     *   Alt+[accessKey], or in Mozilla Firefox 2.0 and above, Shift+Alt+[accessKey].
     * 
     * 
     *  @param {string} Character to use as an accessKey for this widget. Case Insensitive.
     */
    open fun setAccessKey(accessKey: String): Unit = definedExternally
    /**
     *   If an explicit Canvas.tabIndex was assigned to this widget, clear it.
     *   This will enable automatic tab index managment behaviors via the TabIndexManager class
     *   as described in the tabOrderOverview
     * 
     */
    open fun clearExplicitTabIndex(): Unit = definedExternally
    /**
     *   This method is executed on draw. Default implementation for top-level widgets ensures
     *   this widget is at the end of the tab-sequence.
     * 
     *   Has no effect if this canvas is embedded in a Canvas.getParentCanvas.
     * 
     */
    open fun updateTabPositionForDraw(): Unit = definedExternally
    /**
     *   Update the childrens' tab positions, slotting them under this widget in the
     *   TabIndexManager, in the order defined by Canvas.getChildTabPosition.
     *   This method will skip any children where Canvas.updateTabPositionOnReparent is
     *   false.
     * 
     *   This method is called automatically on canvas draw(). It may be overridden by subclasses
     *   for custom tab-order behavior.
     * 
     */
    open fun updateChildTabPositions(): Unit = definedExternally
    /**
     *   Ensure that a specific child is slotted correctly into the page's tab order. Default
     *   implementation will, if Canvas.updateTabPositionOnReparent is true, ensure
     *   the child canvas shows up in the TabIndexManager tree
     *   under the entry for this widget (the parent), in the position returned
     *   by Canvas.getChildTabPosition.
     * 
     *   This method is called automatically in cases where a single child's tab position may
     *   need to be updated - such as if a child is added to a drawn parent.
     * 
     *   See also Canvas.updateChildTabPositions
     * 
     * 
     *  @param {Canvas} child to have tab position updated.
     */
    open fun updateChildTabPosition(child: Canvas): Unit = definedExternally
    /**
     *   For a given child widget where Canvas.updateTabPositionOnReparent is true,
     *   return the expected tab position within this parent.
     *   Default implementation will any explicit relative tab position specified by
     *   Canvas.setRelativeTabPosition, and otherwise put children in the
     *   same order as defined in the children array
     * 
     *   Overridden in the Layout class to return the position in the members array.
     * 
     *  @param {Canvas} Child to get local tab position for
     */
    open fun getChildTabPosition(child: Canvas): Number = definedExternally
    /**
     *   Setter for the Canvas.updateTabPositionOnReparent attribute.
     * 
     *  @param {boolean} new value for canvas.updateTabPositionOnReparent
     */
    open fun setUpdateTabPositionOnReparent(updateOnReparent: Boolean): Unit = definedExternally
    /**
     *   Assign a relative tab position for this canvas. The meaning of a "relative" tab position
     *   varies depending on where the canvas is in the page.
     * 
     *   For canvases with no specified Canvas.getParentCanvas, (or where
     *   Canvas.updateTabPositionOnReparent is false), this method will and move the
     *   canvas to the appropriate tab-position among other top level canvases. It will also disable
     *   Canvas.updateTabPositionOnDraw so if this method is called before draw, drawing
     *   this canvas will not cause its tab position to change.
     * 
     *   For canvases embedded in a Canvas.getParentCanvas, this method will move the
     *   canvas to the appropriate tab position among the other children of the parent.
     *   Implementation note: This is achieved by setting an internal property to
     *   indicate the new tab position which will be respected by the default
     *   Canvas.getChildTabPosition implementation, and calling
     *   Canvas.updateChildTabPositions to implement a reflow. Therefore if
     *   Canvas.getChildTabPosition has been overridden, this method may have no effect.
     * 
     *   As with other APIs related to TabIndexManager, tab indices
     *   are treated as a hierarchy by default. By setting the relative tab position of a
     *   canvas which is not itself focusable but has focusable descendents, these descendents'
     *   tab position will be updated.
     * 
     *   Note that after this method has been called, the tab position can be modified by
     *   subsequent code to shift another sibling in front of this one, or reparent this canvas.
     * 
     * 
     *  @param {Integer} new relative tab position
     */
    open fun setRelativeTabPosition(position: Number): Unit = definedExternally
    /**
     *   Assign an explicit Canvas.tabIndex to this widget at runtime.
     * 
     *   Developers may also call Canvas.clearExplicitTabIndex to clear any explicitly
     *   assigned tab index, and have the widget participate in automatic tab position allocation.
     *   For more information see Canvas.tabIndex
     * 
     * 
     *  @param {number} New tabIndex for this widget. Must be less than             Canvas.TAB_INDEX_FLOOR to avoid interfering with auto-assigned              tab indices on the page.
     */
    open fun setTabIndex(tabIndex: Number): Unit = definedExternally
    /**
     *   Shifts focus to the next focusable element after this one. This programatically
     *   simulates the user experience of a Tab keypress, and is used automatically when
     *   a blocking Canvas.showClickMask is up to ensure focus does not
     *   move to any masked elements in the UI.
     * 
     *   This method makes use of the TabIndexManager.shiftFocus method to request
     *   focus be changed to the adjacent registered entry. By default standard focusable
     *   SmartClient UI elements, including Canvases, FormItems, FormItemIcons, etc are
     *   registered with the TabIndexManager in the appropriate order, and will accept focus
     *   if Canvas.canFocus, and not FormItem.disabled or
     *   Canvas.showClickMask.
     * 
     *   The TabIndexManager maintains a hierarchy of focusable targets - so if a parent
     *   canvas contains focusable children, they will typically be nested under the parent
     *   canvas in this hierarchy. If you want to shift focus to the next target outside this
     *   hierarchy (IE: skip any children and put focus into the next widget on the page
     *   outside this one), you can use use Canvas.focusAfterGroup.
     * 
     *   NOTE: Focusable elements created directly in the raw HTML bootstrap or
     *   by application code will not be passed focus by this method unless they have also been
     *   explicitly registered with the TabIndexManager. See the tabOrderOverview
     *   for more information.
     * 
     * 
     */
    open fun focusInNextTabElement(): Unit = definedExternally
    /**
     *   Shifts focus to the next focusable element after this one, skipping any elements
     *   nested inside the tabbing group for this canvas, such as focusable children.
     * 
     *   This method makes use of the TabIndexManager.shiftFocusAfterGroup method to request
     *   focus be changed to the next registered entry. By default standard focusable
     *   SmartClient UI elements, including Canvases, FormItems, FormItemIcons, etc are
     *   registered with the TabIndexManager in the appropriate order, and will accept focus
     *   if Canvas.canFocus, and not FormItem.disabled or
     *   Canvas.showClickMask.
     * 
     *   This method differs from Canvas.focusInNextTabElement in that it will
     *   skip any descendants of this widget in the TabIndexManager's hierarchy of potential
     *   focus target. By default this means focus will be moved to the next target on the
     *   page which is not a descendant of this widget.
     * 
     *   FormItems support a similar method: FormItem.focusAfterItem.
     * 
     *   NOTE: Focusable elements created directly in the raw HTML bootstrap or
     *   by application code will not be passed focus by this method unless they have also been
     *   explicitly registered with the TabIndexManager. See the tabOrderOverview
     *   for more information.
     * 
     * 
     */
    open fun focusAfterGroup(): Unit = definedExternally
    /**
     *   Shifts focus to the previous focusable element before this one. This programatically
     *   simulates the user experience of a Shift+Tab keypress.
     * 
     *   This method makes use of the TabIndexManager.shiftFocus method to request
     *   focus be changed to the adjacent registered entry. By default standard focusable
     *   SmartClient UI elements, including Canvases, FormItems, FormItemIcons, etc are
     *   registered with the TabIndexManager in the appropriate order, and will accept focus
     *   if Canvas.canFocus, and not FormItem.disabled or
     *   Canvas.showClickMask.
     * 
     *   NOTE: Focusable elements created directly in the raw HTML bootstrap or
     *   by application code will not be passed focus by this method unless they have also been
     *   explicitly registered with the TabIndexManager. See the tabOrderOverview
     *   for more information.
     * 
     * 
     */
    open fun focusInPreviousTabElement(): Unit = definedExternally
    /**
     *   Shifts focus to the start or end of this canvas and its descendants.
     * 
     *   This method makes use of the TabIndexManager.shiftFocusWithinGroup API to
     *   request focus be changed within the set of focusable targets registered under
     *   this canvas.
     * 
     *   If the start parameter is true, if the canvas itself is focusable it will
     *   be given focus, otherwise the first focusable descendant will be given focus.
     *   If the start parameter is false, the last focusable descendant will be
     *   given focus (or if the canvas itself is focusable but there are no focusable descendants,
     *   it will receive focus).
     * 
     *   A use case for this might be to programmatically shift focus to the first or last
     *   button in a toolbar or similar.
     * 
     *  @param {boolean} Should we focus at the start or the end of this widget and its  descendants.
     */
    open fun focusAtEnd(start: Boolean): Unit = definedExternally
    /**
     *   Get the z-Index of this canvas.
     * 
     * 
     *  @param {boolean} If passed true, for undrawn widgets, resolve "auto" to the next available zIndex.
     */
    open fun getZIndex(resolveToNumber: Boolean): Number = definedExternally
    /**
     *   Puts this widget at the top of the stacking order, so it appears in front of all other
     *   widgets in the same parent.
     * 
     */
    open fun bringToFront(): Unit = definedExternally
    /**
     *   Puts this widget at the bottom of the stacking order, so it appears behind all other
     *   widgets in the same parent.
     * 
     */
    open fun sendToBack(): Unit = definedExternally
    /**
     *   Puts this widget just above the specified widget in the stacking order, so it appears in
     *   front of the specified widget if both widgets have the same parent.
     * 
     *  @param {Canvas} canvas to move above
     */
    open fun moveAbove(canvas: Canvas): Unit = definedExternally
    /**
     *   Puts this widget just below the specified widget in the stacking order, so it appears
     *   behind the specified widget if both widgets have the same parent.
     * 
     *  @param {Canvas} canvas to move below
     */
    open fun moveBelow(canvas: Canvas): Unit = definedExternally
    /**
     *     Returns the contents of a Canvas. The contents are an HTML string.
     * 
     */
    open fun getContents(): String = definedExternally
    /**
     *   Changes the contents of a widget to newContents, an HTML string.
     * 
     *   When Canvas.dynamicContents is set, setContents() can
     *   also be called with no arguments to cause contents to be re-evaluated.
     * 
     * 
     *  @param {HTMLString=} an HTML string to be set as the contents of this widget
     */
    open fun setContents(newContents: String?): Unit = definedExternally
    /**
     *   Sets the background color of this component to newColor.
     * 
     *  @param {CSSColor} new background color, or null to remove the current background color.
     */
    open fun setBackgroundColor(newColor: String): Unit = definedExternally
    /**
     *       Sets the background to an image file given by newImage. This URL should be given as a
     *       string relative to the image directory for the page (./images by default).
     * 
     *  @param {SCImgURL} new URL (local to Page image directory) for background image
     */
    open fun setBackgroundImage(newImage: String): Unit = definedExternally
    /**
     *   Set the CSS border of this component, as a CSS string including border-width,
     *   border-style, and/or color (eg "2px solid blue").
     * 
     *   This property applies the same border to all four sides of this component. Different
     *   per-side borders can be set in a CSS style and applied via Canvas.styleName.
     * 
     * 
     *  @param {string} new border to set to (eg: "2px solid black")
     */
    open fun setBorder(newBorder: String): Unit = definedExternally
    /**
     *   Sets the opacity for the widget to the newOpacity value. This newOpacity
     *   value must be within the range of 0 (transparent) to 100 (opaque).
     *   Null means don't specify opacity directly.
     *   Note that heavy use of opacity may have a performance impact on some older
     *   browsers.
     * 
     *   In older versions of Internet Explorer (Pre IE9 / HTML5), opacity is achieved
     *   through proprietary filters. If
     *   Canvas.neverUseFilters within this application
     *   developers must set Canvas.useOpacityFilter to true for specific components
     *   on which opacity support is required.
     * 
     *   Also note that opacity is incompatible
     *   with Canvas.useBackMask.
     * 
     *  @param {number} new opacity level
     */
    open fun setOpacity(newOpacity: Number): Unit = definedExternally
    /**
     *       Sets the cursor for this widget to cursor. See the cursor property
     *       for possible values.
     * 
     *  @param {Cursor} new cursor
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
     *   When Canvas.showHoverComponents is true, this method is called to get the component to show
     *   as a hover for this Canvas. There is no default implementation of this method, so you need
     *   to override it with an implementation that returns a Canvas that suits your needs.
     * 
     *   By default, components returned by getHoverComponent() will not be
     *   automatically destroyed when the hover is hidden. To enforce this, set
     *   Canvas.hoverAutoDestroy to true on the returned component.
     * 
     * 
     */
    open fun getHoverComponent(): Canvas = definedExternally
    /**
     *   Handler fired on a delay when the user hovers the mouse over this hover-target.
     *   Default implementation will fire this.hover() (if defined), and handle
     *   showing the hover canvas if this.showHover is true.
     * 
     */
    open fun handleHover(): Unit = definedExternally
    /**
     *   If this canvas is currently showing a hover (see Canvas.handleHover), this method
     *   can be called to update the contents of the hover. Has no effect if the hover canvas is not
     *   showing for this widget.
     * 
     *  @param {string=} Option to specify new HTML for the hover. If not passed, the result  of Canvas.getHoverHTML will be used instead. Note that if the  hover HTML is empty the hover will be hidden.
     */
    open fun updateHover(hoverHTML: String?): Unit = definedExternally
    /**
     *   If Canvas.showHover is true for this canvas, this notification method will be
     *   fired whenever the hover shown in response to Canvas.handleHover is
     *   hidden. This method may be observed or overridden.
     * 
     */
    open fun hoverHidden(): Unit = definedExternally
    /**
     *   If canHover is true for this widget, the hover string method will
     *   be fired when the user hovers over this canvas. If this method returns false, it will
     *   suppress the default behavior of showing a hover canvas if this.showHover
     *   is true.
     * 
     */
    open fun hover(): Boolean = definedExternally
    /**
     *   If this.showHover is true, when the user holds the mouse over this Canvas for
     *   long enough to trigger a hover event, a hover canvas is shown by default. This method returns
     *   the contents of that hover canvas. Default implementation returns this.prompt -
     *   override for custom hover HTML. Note that returning null or an empty string will
     *   suppress the hover canvas altogether.
     * 
     */
    open fun getHoverHTML(): String = definedExternally
    /**
     *   Sets the CSS class for this widget
     * 
     *  @param {CSSStyleName} new CSS class name (must be defined previously)
     *  @deprecated \* As of SmartClient version 5.5, use Canvas.setStyleName instead.
     */
    open fun setClassName(newClass: String): Unit = definedExternally
    /**
     *   Sets the CSS class for this widget
     * 
     *  @param {CSSStyleName} new CSS style name
     */
    open fun setStyleName(newStyle: String): Unit = definedExternally
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
     * 
     *   The default implementation of this method hides the contextMenu currently being shown for this
     *   component (which occurs when the mouse button that toggles the context menu is released).
     *   Override if you want some other behavior.
     * 
     * 
     */
    open fun hideContextMenu(): Unit = definedExternally
    /**
     * 
     *   Executed when mouse enters this widget. No default implementation.
     * 
     * 
     */
    open fun mouseOver(): Boolean = definedExternally
    /**
     *   Executed when the left mouse button is pressed on this widget. No default implementation.
     * 
     * 
     */
    open fun mouseDown(): Boolean = definedExternally
    /**
     *   Executed when the right mouse button is pressed on this widget. No default implementation.
     * 
     * 
     */
    open fun rightMouseDown(): Boolean = definedExternally
    /**
     * 
     *   Repeating notification method for the user holding the left mouse button down over this
     *   canvas.
     * 
     *   The mouseStillDown event is fired immediately when the mouse goes down.
     *   If the user holds the mouse down, after a pause of
     *   Canvas.mouseStillDownInitialDelay, it will begin to fire repeatedly every
     *   Canvas.mouseStillDownDelay milliseconds.
     * 
     *   This provides developers with a simple way to handle the common "repeated action"
     *   use case where a user can click a UI element to perform an action once, or click
     *   and hold to perform the action repeatedly.
     *   Examples of this include standard scrollbar button behavior and buttons
     *   to increase or decrease the value in a spinner type input element.
     * 
     *   This event is not native to JavaScript, but is provided by the ISC system.
     * 
     * 
     */
    open fun mouseStillDown(): Boolean = definedExternally
    /**
     * 
     *   Executed when the mouse moves within this widget. No default implementation.
     * 
     * 
     */
    open fun mouseMove(): Boolean = definedExternally
    /**
     * 
     *   Executed when the mouse leaves this widget. No default implementation.
     * 
     * 
     */
    open fun mouseOut(): Boolean = definedExternally
    /**
     * 
     *   Executed when the left mouse is released on this widget. No default implementation.
     * 
     * 
     */
    open fun mouseUp(): Boolean = definedExternally
    /**
     * 
     *   Executed when the left mouse is clicked (pressed and then released) on this widget. No default
     *   implementation.
     * 
     * 
     */
    open fun click(): Boolean = definedExternally
    /**
     * 
     *   Executed when the left mouse button is clicked twice in rapid succession (within
     *   Canvas.doubleClickDelay by default) in this object.
     * 
     * 
     */
    open fun doubleClick(): Boolean = definedExternally
    /**
     * 
     *   Executed when the mouse wheel is actuated.
     * 
     * 
     */
    open fun mouseWheel(): Boolean = definedExternally
    /**
     * 
     *   Executed when dragging first starts. No default implementation. Create this handler to set
     *   things up for the drag reposition.
     * 
     * 
     */
    open fun dragRepositionStart(): Boolean = definedExternally
    /**
     * 
     *   Executed every time the mouse moves while drag-repositioning. If this method
     *   does not return false, the Canvas.dragTarget (or outline if
     *   Canvas.dragAppearance is set to "outline") will automatically be moved as appropriate
     *   whenever the mouse moves.
     * 
     * 
     */
    open fun dragRepositionMove(): Boolean = definedExternally
    /**
     * 
     *   Executed when the mouse button is released at the end of the drag. Your
     *   widget can use this opportunity to fire custom code based upon where the
     *   mouse button was released, etc.
     * 
     *   Returning true from this handler will cause the Canvas.dragTarget (or outline if
     *   Canvas.dragAppearance is set to "outline") to be left in its current
     *   location. Returning false from this handler will cause it to snap back to its
     *   original location.
     * 
     * 
     */
    open fun dragRepositionStop(): Boolean = definedExternally
    /**
     * 
     *   Executed when resize dragging first starts. No default implementation.
     *   Create this handler to set things up for the drag resize.
     * 
     * 
     */
    open fun dragResizeStart(): Boolean = definedExternally
    /**
     * 
     *   Executed every time the mouse moves while drag-resizing. If this method
     *   does not return false, the Canvas.dragTarget (or outline if
     *   Canvas.dragAppearance is set to "outline") will automatically be moved as appropriate
     *   whenever the mouse moves.
     * 
     * 
     */
    open fun dragResizeMove(): Boolean = definedExternally
    /**
     * 
     *   Executed when the mouse button is released at the end of the drag resize. Your
     *   widget can use this opportunity to fire custom code based upon where the
     *   mouse button was released, etc.
     * 
     *   Returning true from this handler will cause the Canvas.dragTarget (or outline if
     *   Canvas.dragAppearance is set to "outline") to be left at its current size. Returning
     *   false from this handler will cause it to snap back to its original location size
     * 
     * 
     */
    open fun dragResizeStop(): Boolean = definedExternally
    /**
     *   Executed when dragging first starts. Your widget can use this opportunity to set
     *   things up for the drag, such as setting the drag tracker. Returning false from this
     *   event handler will cancel the drag action entirely.
     * 
     *   A drag action is considered to be begin when the mouse has moved
     *   Canvas.dragStartDistance with the left mouse down.
     * 
     * 
     */
    open fun dragStart(): Boolean = definedExternally
    /**
     *   Executed every time the mouse moves while dragging this canvas.
     * 
     * 
     */
    open fun dragMove(): Boolean = definedExternally
    /**
     *   Executed when the mouse button is released at the end of the drag. Your widget can
     *   use this opportunity to fire code based on the last location of the drag or reset any
     *   visual state that was sent.
     * 
     * 
     */
    open fun dragStop(): Boolean = definedExternally
    /**
     * 
     *   Executed when the compatible dragged object is first moved over this drop target. Your
     *   implementation can use this to show a custom visual indication that the object can be
     *   dropped here.
     * 
     * 
     */
    open fun dropOver(): Boolean = definedExternally
    /**
     * 
     *   Executed whenever the compatible dragged object is moved over this drop target. You
     *   can use this to show a custom visual indication of where the drop would occur within the
     *   widget, or to show the Canvas.noDropCursor to indicate that
     *   this is not a valid drop target, typically if Canvas.willAcceptDrop returns false.
     * 
     *   For details on showing a 'no drop' cursor when the user drags over all invalid drop
     *   targets, see EventHandler.showNoDropIndicator.
     * 
     * 
     */
    open fun dropMove(): Boolean = definedExternally
    /**
     * 
     *   Executed when the dragged object is no longer over this drop target, including when the drag
     *   interaction is ending with a drop on this drop target. If you have set a visual indication
     *   in dropOver or dropMove, you should reset it to its normal state in dropOut.
     * 
     * 
     */
    open fun dropOut(): Boolean = definedExternally
    /**
     * 
     *   Executed when the mouse button is released over a compatible drop target at the end of
     *   a drag sequence. Your widget should implement whatever it wants to do when receiving a
     *   drop here. For example, in a file moving interface, a drop might mean that you should
     *   move or copy the dragged file into the folder it was dropped on, or dropping something in
     *   a trash can might mean to clear it from the screen.
     * 
     * 
     */
    open fun drop(): Boolean = definedExternally
    /**
     * 
     *   Executed when a key is pressed on a focusable widget (Canvas.canFocus: true).
     * 
     *   Use EventHandler.getKey to find out the KeyName of the key that
     *   was pressed, and use EventHandler.shiftKeyDown and related functions to determine
     *   whether modifier keys were down.
     * 
     * 
     */
    open fun keyDown(): Boolean = definedExternally
    /**
     * 
     *   Executed when a key is released on a focusable widget (Canvas.canFocus: true).
     * 
     *   Use EventHandler.getKey to find out the KeyName of the key that
     *   was pressed, and use EventHandler.shiftKeyDown and related functions to determine
     *   whether modifier keys were down.
     * 
     * 
     */
    open fun keyUp(): Boolean = definedExternally
    /**
     * 
     *   Executed when a key is pressed and released on a focusable widget (Canvas.canFocus:
     *   true).
     * 
     *   Use EventHandler.getKey to find out the KeyName of the key that
     *   was pressed, and use EventHandler.shiftKeyDown and related functions to determine
     *   whether modifier keys were down.
     * 
     * 
     */
    open fun keyPress(): Boolean = definedExternally
    /**
     * 
     *   Returns true if the widget object being dragged can be dropped on this widget, and
     *   false otherwise. The default implementation of this method simply compares the
     *   Canvas.dragType of the dragTarget (the component being dragged from)
     *   with the list of Canvas.dropTypes on this Canvas. If the Canvas.dropTypes
     *   list contains the Canvas.dragType value, then this method returns true. Otherwise it
     *   returns false.
     *   No matter what you return, Canvas.dropOver and Canvas.dropMove
     *   will still be called, and their return values will determine whether those events are bubbled
     *   to parent elements.
     *   However, what you return from willAcceptDrop() does determine whether
     *   Canvas.drop will be called.
     * 
     * 
     *  - If you return true, then drop() will be called, and its return value
     *   will determine whether the event is bubbled to parent elements
     * 
     *  - If you return false, then drop() will not be called, and the event
     *   will not be bubbled.
     * 
     *  - If you return null, then drop() will not be called, but the event
     *   will be bubbled to parent elements (giving them a chance to handle the drop).
     * 
     *   So, you should return false to definitively deny a drop, and return null if it could
     *   make sense to allow a parent element, such as a Layout, to handle the drop.
     * 
     * 
     */
    open fun willAcceptDrop(): Boolean = definedExternally
    /**
     * 
     *   Override this method to provide a custom snap-to grid. Note that you do not need to do
     *   this if your grid is regular (ie, grid points are every x pixels); regular grids should be
     *   defined using Canvas.snapHGap and Canvas.snapVGap.
     *   You should only override this method if you want to provide support for a grid of
     *   irregularly-placed points
     * 
     * 
     *  @param {Integer} x-coordinate of the drag event relative to the inside of this widget
     *  @param {string=} "before" or "after" denoting whether the returned coordinate should  match the left or right edge of the current square. If unset Canvas.snapHDirection will  be used by default
     */
    open fun getHSnapPosition(coordinate: Number, direction: String?): Number = definedExternally
    /**
     *   Override this method to provide a custom snap-to grid. Note that you do not need to do
     *   this if your grid is regular (ie, grid points are every x pixels) - regular grids should be
     *   defined using Canvas.snapHGap and Canvas.snapVGap.
     *   You should only override this method if you want to provide support for a grid of
     *   irregularly-placed points
     * 
     * 
     *  @param {Integer} y-coordinate of the drag event relative to the inside of this widget
     *  @param {string=} "before" or "after" denoting whether the returned coordinate should  match the top or bottom edge of the current square. If unset Canvas.snapHDirection will  be used by default
     */
    open fun getVSnapPosition(coordinate: Number, direction: String?): Number = definedExternally
    /**
     *   Override this method to give programmatic control over whether or not the parameter
     *   dragTarget should snap to this object's grid when dropped. Note that this only applies
     *   if snap-to-grid is enabled on either dragTarget or this object. See
     *   Canvas.snapToGrid and Canvas.childrenSnapToGrid.
     * 
     *   The default implementation simply returns true.
     * 
     * 
     *  @param {Canvas} The object about to be dropped
     */
    open fun shouldSnapOnDrop(dragTarget: Canvas): Boolean = definedExternally
    /**
     *   Set the showSnapGrid property.
     * 
     * \* @param {boolean} 
     */
    open fun setShowSnapGrid(show: Boolean): Unit = definedExternally
    /**
     *   Add a candidate to Canvas.snapAlignCandidates. Duplicates are automatically avoided.
     * 
     * 
     * \* @param {Canvas} 
     */
    open fun addSnapAlignCandidate(newCandidate: Canvas): Unit = definedExternally
    /**
     *   Remove a candidate from Canvas.snapAlignCandidates. If the passed widget was not actually
     *   a candidate, nothing happens and no warning is logged.
     * 
     * 
     * \* @param {Canvas} 
     */
    open fun removeSnapAlignCandidate(candidate: Canvas): Unit = definedExternally
    /**
     *   Return the full URL for an image to be drawn in this canvas.
     * 
     *   If the passed URL begins with the special prefix "[SKIN]", it will have the
     *   widget.skinImgDir and Page.skinImgDir prepended. Otherwise the image is assumed to be
     *   application-specific, and will have the widget.appImgDir and Page.appImgDir automatically
     *   prepended.
     * 
     *   Note that if passed an absolute path (starting with "/" or "http://" for example), no extra
     *   image directory information will be prepended to the generated URL.//
     * 
     * 
     *  @param {string} URL local to skin or application image directory
     *  @param {string=} optional image directory to override the default for this Canvas
     */
    open fun getImgURL(URL: String, imgDir: String?): String = definedExternally
    /**
     *   Generates the HTML for an image unique to this Canvas.
     * 
     *   The full URL for the image will be formed according to the rules documented for
     *   Canvas.getImgURL.
     * 
     *   The created image will have an identifier unique to this Canvas, and subsequent calls to
     *   Canvas.getImage and
     *   Canvas.setImage
     *   with the name passed to this function will act on the image object produced by the HTML
     *   returned from this call.
     * 
     * 
     *  @param {SCImgURL} URL local to the skin or application directory.   NOTE: instead of passing several parameters, you can pass an object as the 'src'    parameter with properties for all the various function parameters with, eg:    canvas.imgHTML( {src:"foo", width:10, height:10} );
     *  @param {number=} width of the image
     *  @param {number=} height of the image
     *  @param {string=} name for the image
     *  @param {string=} additional attributes to write in the tag
     *  @param {string=} image-specific image directory to override the default                 for this Canvas
     */
    open fun imgHTML(src: String, width: Number?, height: Number?, name: String?, extraStuff: String?, imgDir: String?): String = definedExternally
    /**
     *   Retrieve a native image or SVG object element by name.
     * 
     *   The element must have been created from HTML generated by calling
     *   Canvas.imgHTML on this particular Canvas.
     * 
     * 
     *  @param {string} name of the image or SVG object to get, as originally passed to               imgHTML()
     */
    open fun getImage(identifier: String): DOMElement = definedExternally
    /**
     *   Set the URL of an image or SVG object element by name.
     * 
     *   The element must have been created from HTML generated by calling
     *   canvas.imgHTML() on this particular Canvas.
     * 
     * 
     *  @param {string} name of the image to change, as originally passed to               imgHTML
     *  @param {SCImgURL} URL for the image
     *  @param {string=} optional image directory, overrides the default for this Canvas
     */
    open fun setImage(identifier: String, URL: String, imgDir: String?): Unit = definedExternally
    /**
     *   Generates the HTML for a standard link (anchor) element.
     * 
     * 
     *  @param {string} URL for the link to point to
     *  @param {HTMLString=} HTML to display in the link element (defaults to the href)
     *  @param {string=} Target window for the link (defaults to opening in a new, unnamed window)
     *  @param {string=} optional ID for the link element to be written out
     *  @param {Integer=} optional tabIndex for the link
     *  @param {string=} optional accessKey for the link
     */
    open fun linkHTML(href: String, text: String?, target: String?, ID: String?, tabIndex: Number?, accessKey: String?): String = definedExternally
    /**
     *   Set the Canvas.edgeOpacity and mark the canvas for redraw
     * 
     *  @param {Integer} new edge-opacity level
     */
    open fun setEdgeOpacity(newOpacity: Number): Unit = definedExternally
    /**
     *   Method to update Canvas.showShadow.
     * 
     *  @param {boolean} true if the shadow should be visible false if not
     */
    open fun setShowShadow(showShadow: Boolean): Unit = definedExternally
    /**
     *   Setter for Canvas.groupLabelBackgroundColor.
     * 
     *  @param {CSSColor} the new grouping label background color.
     */
    open fun setGroupLabelBackgroundColor(groupLabelBackgroundColor: String): Unit = definedExternally
    /**
     *   Setter for Canvas.groupTitle.
     * 
     *  @param {HTMLString} The new title for the grouping.
     */
    open fun setGroupTitle(newTitle: String): Unit = definedExternally
    /**
     *   Get the current value of the rule context collected by the Canvas.ruleScope of this component
     *   (which may be this component itself or whatever component is managing the
     *   ruleScope for this component).
     * 
     *   If the databoundOnly parameter is passed as true, only data from components that
     *   actually have a DataSource is included.
     * 
     *   Use Canvas.ruleContextChanged to get a notification of changes to the rule context.
     * 
     * 
     *  @param {boolean=} whether to include only data from components that have a                 DataSource
     */
    open fun getRuleContext(databoundOnly: Boolean?): dynamic = definedExternally
    /**
     *   Notification that the rule context gathered by the Canvas.ruleScope has changed.
     * 
     *   This notification fires only on the component designated as the Canvas.ruleScope; components
     *   that are merely contributing data to the rule context do not fire
     *   ruleContextChanged.
     * 
     *  @param {object} the new rule context
     */
    open fun ruleContextChanged(data: dynamic): Unit = definedExternally
    /**
     *   Provide data to the Canvas.ruleScope component, to be made available in the rule context at the
     *   specified path.
     * 
     *   path must be one or more valid identifiers with either dot (.) or slash (/) used
     *   as a separator.
     * 
     *   data can be any value, including both atomic values like a Boolean or String, or a
     *   nested data structure. Pass data as null to remove data from the
     *   context at the specified path
     * 
     *   dbc is the DataBoundComponent to be identified as the owner of the rule context
     *   contribution. This component is used to handle any conflicts between multiple components
     *   contributing to the same base path (i.e. first segment of path). For any collision an editable
     *   display (such as a form or editable grid) wins over a static display (such as a non-editable
     *   grid with a selection). Hidden components have lowest priority even if editable. For two
     *   editable components the first becomes the owner.
     * 
     * 
     *  @param {string} path where data should be made available
     *  @param {any} data to contribute to rule context
     *  @param {DataBoundComponent=} dataBoundComponent contributing to ruleContext
     */
    open fun provideRuleContext(path: String, data: dynamic, dbc: DataBoundComponent?): Unit = definedExternally
    /**
     *   Notification method fire when an ancestor of this component's position changes.
     * 
     *  @param {Canvas} the ancestor that moved
     *  @param {Integer} horizontal difference between current and previous position
     *  @param {Integer} vertical difference between current and previous position
     */
    open fun parentMoved(parent: Canvas, deltaX: Number, deltaY: Number): Unit = definedExternally
    /**
     *   Notification method fired when this component is explicitly moved.
     *   Note that a component's position on the screen may also changed due to an ancestor being
     *   moved. The Canvas.parentMoved method provides a notification entry point to catch
     *   that case as well.
     * 
     * 
     *  @param {Integer} horizontal difference between current and previous position
     *  @param {Integer} vertical difference between current and previous position
     */
    open fun moved(deltaX: Number, deltaY: Number): Unit = definedExternally
    /**
     *   Notification function fired when this widget receives or loses keyboard focus.
     * 
     *  @param {boolean} If true this widget now has keyboard focus
     */
    open fun focusChanged(hasFocus: Boolean): Unit = definedExternally
    /**
     *   Notification that this component has just scrolled. Use with
     *   Class.observe.
     * 
     *   Fires for both CSS and Scrollbar.
     * 
     * 
     */
    open fun scrolled(): Unit = definedExternally
    /**
     *   Notification fired when this canvas becomes visible or hidden to the user.
     *   Note - this method is fired when the Canvas.isVisible state of this
     *   component changes. It may be fired in response an explicit call to Canvas.show
     *   or Canvas.hide, or in response to a parent component
     *   being shown or hidden when this widgets Canvas.visibility is set to "inherit".
     * 
     *   Note that a call to Canvas.show or Canvas.hide will not always fire this
     *   notification. If this widget has a hidden parent, show or hide would change this
     *   components Canvas.visibility property, and may update the CSS visibility attribute
     *   of the drawn handle in the DOM, but would not actually hide or reveal the component to
     *   the user and as such the notification would not fire.
     * 
     *   Note also that this notification will only be fired for components which have been
     *   Canvas.draw.
     * 
     *  @param {boolean} whether the canvas is visible to the user
     */
    open fun visibilityChanged(isVisible: Boolean): Unit = definedExternally
    /**
     *   Setter for the Canvas.valuesManager attribute. This method may be called directly at
     *   runtime to set the ValuesManager for a component; it has the same effect as calling
     *   ValuesManager.addMember, passing in this DataBoundComponent.
     * 
     *  @param {ValuesManager} new dataPath
     */
    open fun setValuesManager(valuesManager: dynamic): Unit = definedExternally
    /**
     *   Setter for the Canvas.dataPath attribute. This method may be called directly at runtime
     *   to set the dataPath on a component, and will also be re-run automatically whenever a canvas'
     *   parent changes due to a call to addChild(). This method handles automatically binding
     *   the component to the appropriate valuesManager if necessary.
     * 
     *  @param {DataPath} new dataPath
     */
    open fun setDataPath(dataPath: String): Unit = definedExternally
    /**
     *   Returns a fully qualified DataPath for this canvas. This is calculated by combining
     *   the canvas' specified DataPath with the dataPath of any parent
     *   canvases up to whichever canvas has a specified Canvas.valuesManager specified to actually
     *   manage values from this component.
     * 
     */
    open fun getFullDataPath(): String = definedExternally
    /**
     *   When using the devTools framework and asking an
     *   EditContext to EditContext.serializeAllEditNodes,
     *   updateEditNode is called during the serialization process on each
     *   EditNode.liveObject.
     * 
     *   You can implement updateEditNode on your liveObject and make
     *   updates to EditNode.defaults to save state "lazily" - just as serialization is
     *   occurring - instead of updating editNode.defaults as the end user makes
     *   changes. This can be useful if constantly calculating changes to
     *   editNode.defaults would slow down interactivity.
     * 
     *   Note: best practice is to use EditContext.setNodeProperties and
     *   EditContext.removeNodeProperties to change properties, rather than directly
     *   modifying EditNode.defaults.
     * 
     * 
     *  @param {EditContext} the EditContext
     *  @param {EditNode} the EditNode
     */
    open fun updateEditNode(editContext: EditContext, editNode: EditNode): Unit = definedExternally
    /**
     *   Enable or disable edit mode for this component. Components in editMode must be
     *   associated with an EditNode within an EditContext.
     * 
     *   Components with editMode enabled support certain editing interactions which
     *   vary depending on the componentType and settings on the
     *   Canvas.editProxy.
     * 
     *   To disable edit mode just pass editingOn as false. The other parameters are
     *   not needed.
     * 
     *   To enable edit mode on this component all three parameters are required. The
     *   editNode is the edit node for this component as it exists within the
     *   editContext.
     * 
     *   An alternative method, EditContext.enableEditing, can be used when
     *   only an editContext and editNode are available.
     * 
     *   Placing a component into editMode causes the component's
     *   Canvas.editProxy to be created.
     * 
     * 
     *  @param {boolean} true to enable editMode; false to disable
     *  @param {EditContext=} the EditContext
     *  @param {EditNode=} the EditNode
     */
    open fun setEditMode(editingOn: Boolean, editContext: EditContext?, editNode: EditNode?): Unit = definedExternally
    /**
     *   Set a specific ARIA state for this component.
     * 
     * 
     *  @param {string} aria state to update
     *  @param {string | boolean | Integer | Float} value for the aria state
     */
    open fun setAriaState(stateName: String, stateValue: dynamic): Unit = definedExternally
    companion object {
        /**
         *  A declared value of the enum type s
         *   Overflow and
         *   Cursor.
         *  @type {Constant}
         *  @default "auto"
         */
        var AUTO: String = definedExternally
        /**
         *  A declared value of the enum type
         *   Positioning.
         *  @type {Constant}
         *  @default "absolute"
         */
        var ABSOLUTE: String = definedExternally
        /**
         *  A declared value of the enum type
         *   Positioning.
         *  @type {Constant}
         *  @default "relative"
         */
        var RELATIVE: String = definedExternally
        /**
         *  A declared value of the enum type
         *   Visibility.
         *  @type {Constant}
         *  @default "inherit"
         */
        var INHERIT: String = definedExternally
        /**
         *  A declared value of the enum type s
         *   Overflow and
         *   Visibility.
         *  @type {Constant}
         *  @default "visible"
         */
        var VISIBLE: String = definedExternally
        /**
         *  A declared value of the enum type s
         *   Overflow and
         *   Visibility.
         *  @type {Constant}
         *  @default "hidden"
         */
        var HIDDEN: String = definedExternally
        /**
         *  A declared value of the enum type
         *   Overflow.
         *  @type {Constant}
         *  @default "scroll"
         */
        var SCROLL: String = definedExternally
        /**
         *  A declared value of the enum type
         *   Overflow.
         *  @type {Constant}
         *  @default "clip-h"
         */
        var CLIP_H: String = definedExternally
        /**
         *  A declared value of the enum type
         *   Overflow.
         *  @type {Constant}
         *  @default "clip-v"
         */
        var CLIP_V: String = definedExternally
        /**
         *  A declared value of the enum type s
         *   ImageStyle,
         *   VerticalAlignment and
         *   Alignment.
         *  @type {Constant}
         *  @default "center"
         */
        var CENTER: String = definedExternally
        /**
         *  A declared value of the enum type s
         *   Side,
         *   Alignment and
         *   Direction.
         *  @type {Constant}
         *  @default "left"
         */
        var LEFT: String = definedExternally
        /**
         *  A declared value of the enum type s
         *   Side,
         *   Alignment and
         *   Direction.
         *  @type {Constant}
         *  @default "right"
         */
        var RIGHT: String = definedExternally
        /**
         *  A declared value of the enum type s
         *   VerticalAlignment and
         *   Side.
         *  @type {Constant}
         *  @default "top"
         */
        var TOP: String = definedExternally
        /**
         *  A declared value of the enum type s
         *   VerticalAlignment and
         *   Side.
         *  @type {Constant}
         *  @default "bottom"
         */
        var BOTTOM: String = definedExternally
        /**
         *  A declared value of the enum type
         *   Direction.
         *  @type {Constant}
         *  @default "up"
         */
        var UP: String = definedExternally
        /**
         *  A declared value of the enum type
         *   Direction.
         *  @type {Constant}
         *  @default "down"
         */
        var DOWN: String = definedExternally
        /**
         *  A declared value of the enum type
         *   Cursor.
         *  @type {Constant}
         *  @default "default"
         */
        var DEFAULT: String = definedExternally
        /**
         *  A declared value of the enum type
         *   Cursor.
         *  @type {Constant}
         *  @default "wait"
         */
        var WAIT: String = definedExternally
        /**
         *  A declared value of the enum type
         *   Cursor.
         *  @type {Constant}
         *  @default "hand"
         */
        var HAND: String = definedExternally
        /**
         *  A declared value of the enum type
         *   Cursor.
         *  @type {Constant}
         *  @default "pointer"
         */
        var POINTER: String = definedExternally
        /**
         *  A declared value of the enum type
         *   Cursor.
         *  @type {Constant}
         *  @default "help"
         */
        var HELP: String = definedExternally
        /**
         *  A declared value of the enum type
         *   Cursor.
         *  @type {Constant}
         *  @default "text"
         */
        var TEXT: String = definedExternally
        /**
         *  A declared value of the enum type
         *   ImageStyle.
         *  @type {Constant}
         *  @default "tile"
         */
        var TILE: String = definedExternally
        /**
         *  A declared value of the enum type
         *   ImageStyle.
         *  @type {Constant}
         *  @default "stretch"
         */
        var STRETCH: String = definedExternally
        /**
         *  A declared value of the enum type
         *   ImageStyle.
         *  @type {Constant}
         *  @default "normal"
         */
        var NORMAL: String = definedExternally
        /**
         *  A declared value of the enum type
         *   BackgroundRepeat.
         *  @type {Constant}
         *  @default "repeat"
         */
        var REPEAT: String = definedExternally
        /**
         *  A declared value of the enum type
         *   BackgroundRepeat.
         *  @type {Constant}
         *  @default "no-repeat"
         */
        var NO_REPEAT: String = definedExternally
        /**
         *  A declared value of the enum type
         *   BackgroundRepeat.
         *  @type {Constant}
         *  @default "repeat-x"
         */
        var REPEAT_X: String = definedExternally
        /**
         *  A declared value of the enum type
         *   BackgroundRepeat.
         *  @type {Constant}
         *  @default "repeat-y"
         */
        var REPEAT_Y: String = definedExternally
        /**
         *  Specifies the lower limit for automatically assigned tab indices for focusable canvii.
         *  @type {Integer}
         *  @default "1000"
         */
        var TAB_INDEX_FLOOR: Number = definedExternally
        /**
         *  If set, the AlphaImageLoader IE filter will never be used.  Does not remove
         *   AlphaImageLoader usage in already-drawn components.
         * 
         *   See IEFilters for background.
         *  @type {boolean}
         *  @default null
         */
        var neverUsePNGWorkaround: Boolean = definedExternally
        /**
         *  Disables automatic use of filters in IE by default. Filters will only be used if
         *   Canvas.useOpacityFilter is explicitly set to true on a component.
         * 
         *   Does not remove filters on already drawn components, or which are applied via CSS.
         * 
         *   See IEFilters for background.
         *  @type {boolean}
         *  @default null
         */
        var neverUseFilters: Boolean = definedExternally
        /**
         *  If enabled, uses a moderately expensive workaround to allow the use of IE filters in CSS
         *   to produce gradient effects for buttons, grid rows, and other elements, without the use
         *   of image backgrounds.
         * 
         *   See IEFilters for background.
         *  @type {boolean}
         *  @default true
         */
        var allowExternalFilters: Boolean = definedExternally
        /**
         *  Image URL to be displayed while data is being loaded (if enabled for the widget
         *   waiting for data). Must be square; Canvas.loadingImageSize specifies the width
         *   and height.
         *  @type {SCImgURL}
         *  @default "[SKINIMG]loadingSmall.gif"
         */
        var loadingImageSrc: String = definedExternally
        /**
         *  Specifies the width and height of Canvas.loadingImageSrc.
         *  @type {Integer}
         *  @default "16"
         */
        var loadingImageSize: Number = definedExternally
        /**
         *  A fixed number of pixels at the top of the page in which components will not be placed.
         *   This is overridable per-instance via the Canvas.leavePageSpace attribute.
         *   Essentially, the effect is that all top-level components are shifted down this number of
         *   pixels, and the page height is treated as this number of pixels less than the
         *   real page height.
         * 
         *   This attribute can be useful on certain mobile devices, when components should not be
         *   placed in a top portion of the screen. For example, on iOS devices in certain configurations,
         *   this can be set to 20 to avoid placing any component into the status bar area. Or, if
         *   using iOS 7.1's 'minimal-ui' viewport parameter, this can be set to 20 to avoid placing
         *   any component into the top 20px area of the screen, which if tapped on iPhone in landscape,
         *   causes Mobile Safari's address bar and tab bar to be shown.
         * 
         *   This setting can be changed at runtime by calling Canvas.setDefaultPageSpace.
         * 
         *   Note: As documented by the mobileDevelopment
         *   page, when the SmartClient application is running in Mobile Safari on iPhone running iOS 7.1 or
         *   later, and neither the isc_useDefaultViewport nor the isc_useMinimalUI
         *   global is set to false when the framework is loaded, then the framework
         *   will automatically set the defaultPageSpace to 0 in portrait orientation,
         *   and to 20 in landscape orientation.
         *  @type {Integer}
         *  @default "0"
         */
        var defaultPageSpace: Number = definedExternally
        /**
         *  A declared value of the enum type
         *   DragDataAction.
         *  @type {Constant}
         *  @default "copy"
         */
        var COPY: String = definedExternally
        /**
         *  A declared value of the enum type s
         *   DragDataAction and
         *   Cursor.
         *  @type {Constant}
         *  @default "move"
         */
        var MOVE: String = definedExternally
        /**
         *  Creates a new Canvas
         * 
         *  @param typeCheckedProperties {Partial<Canvas>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Canvas} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Canvas = definedExternally
        /**
         *   Changes the system-wide Canvas.neverUseFilters setting.
         * 
         *  @param {boolean} new setting
         */
        fun setNeverUseFilters(neverUseFilters: Boolean): Unit = definedExternally
        /**
         *   Changes the system-wide Canvas.allowExternalFilters setting.
         * 
         *  @param {boolean} new setting
         */
        fun setAllowExternalFilters(allExternalFilters: Boolean): Unit = definedExternally
        /**
         *   Changes the global Canvas.defaultPageSpace.
         * 
         * 
         *  @param {Integer} the new value for defaultPageSpace.
         */
        fun setDefaultPageSpace(newDefaultPageSpace: Number): Unit = definedExternally
        /**
         *   Check if an event is within an "edge" of this canvas.
         * 
         * 
         *  @param {Array<Partial<EdgeName>>=} Array of legal edges. Default is all the edges that                    allow resizing (see Canvas.resizeFrom)
         */
        fun getEventEdge(edgeMask: Array<dynamic>?): 
                                                     /**
                                                      *  top edge
                                                      *  bottom edge
                                                      *  left edge
                                                      *  right edge
                                                      *  top-left corner
                                                      *  top-right corner
                                                      *  bottom-left corner
                                                      *  bottom-right corner
                                                      *  center
                                                      */
                                                     String /* T |  B |  L |  R |  TL |  TR |  BL |  BR |  C */ = definedExternally
        /**
         *   Retrieve a Canvas by it's global Canvas.ID.
         * 
         *  @param {string} global ID of the Canvas
         */
        fun getById(ID: String): Canvas = definedExternally
        /**
         *   Modify the size of fonts for some or all stylesheets defined in the page.
         * 
         *   This method can be used to dynamically increase or decrease font size for all of the fonts
         *   in your application, or just fonts defined in your chosen SmartClient skin (the latter can
         *   be achieved by passing styleSheets as "skin_styles.css" - the default name for
         *   the CSS file used in each SmartClient skin).
         * 
         *   resizeFonts() must be called after the skin has been loaded, and before any
         *   components have been created. Calling resizeFonts() at a later time is not
         *   supported (you will notice that font sizes still increase, however, this approach is not
         *   supported).
         * 
         *   Some browsers will disallow access or modification of styleSheets if they are loaded from a
         *   domain that is different from the loading page. In this case resizeFonts()
         *   cannot be used.
         * 
         *   This method has a small performance penalty which depends on the browser, number of
         *   stylesheets being modified, and age of your machine. With modern browsers on modern
         *   machines resizing just skin fonts, the impact is basically negligible (&lt;5ms).
         * 
         *   Certain controls such as icons are resized when fonts are resized (see
         *   Canvas.setAutoResizeIcons and Canvas.setAutoResizeAutoChildAttributes)
         *   so you might want to set resizeRelatedControls to false where
         *   you are just trying to make fonts in a dynamically loaded stylesheet match previously
         *   loaded fonts, but controls such as icons should not be resized upwards again.
         * 
         * 
         *  @param {Integer} size to change fonts by. Can be negative to shrink fonts
         *  @param {string=} optional regular expression pattern for matching stylesheets
         *  @param {boolean=} resize icons and autoChild attributes? Set to false    to suppress default behavior.
         */
        fun resizeFonts(sizeChange: Number, styleSheets: String?, resizeRelatedControls: Boolean?): Unit = definedExternally
        /**
         *   Change the basic size of UI components in the current skin by "delta" pixels. Must be
         *   called after the skin has been loaded, but before any components are created.
         * 
         *   The size of a text input control implies the size of most other controls:
         * 
         * 
         *  - all other FormItems (eg selects) need to be the same size or mixed controls will look
         *     odd. This includes Buttons
         * 
         *  - anything that potentially contains a FormItem needs to be as tall or slightly taller:
         *     this includes grid row (inline editing), Window.headerControls,
         *     TabBar and SectionHeaders
         * 
         * 
         *   Because of this necessary uniformity, just specifying a single pixel value is enough for the
         *   framework to resize all core controls, with several caveats:
         * 
         * 
         *  - skins that make extensive use of images (eg TreeFrog) will stretch those images, which
         *     may result in ugly artifacts in some combinations of operating system and browser, for
         *     which no workaround is possible. For this reason, resizeControls() is
         *     only officially supported for Tahoe, Enterprise, EnterpriseBlue and Graphite skins, and only in
         *     skinning
         * 
         *  - even in Enterprise-series skins, TreeGrid.showConnectors
         *     vertically stretch, becoming obviously blurry and misshapen with an increase of 4-5px.
         *     To avoid this, replace the tree connector media (see TreeGrid.connectorImage).
         * 
         *  - FormItemIcons are not resized by default, because stretched icons generally look
         *     worse than non-scaled icons that are a bit smaller than the input field
         * 
         *  - images that use skinning will not be stretched because the sizes
         *     for these controls are embedded in CSS. In most cases, this is desirable; for example,
         *     the downward chevron shape used for SelectItem controls doesn't stretch, and looks
         *     better that way.
         * 
         * 
         * 
         *  @param {Integer} number of pixels to increase or decrease from current size
         */
        fun resizeControls(delta: Number): Unit = definedExternally
        /**
         *   Should icons be automatically resized with Canvas.resizeControls and
         *   Canvas.resizeFonts?
         * 
         *   If true, icon attributes registered for resize with policy "controls" will
         *   be resized when resizeControls() runs, and icons registered
         *   with policy "fonts" will resize when resizeFonts() runs.
         * 
         *   To resize icons with other policies, developers should call
         *   Canvas.resizeIcons directly
         * 
         * 
         * 
         *  @param {boolean} true if icons should be auto-resized
         */
        fun setAutoResizeIcons(autoResizeIcons: Boolean): Unit = definedExternally
        /**
         *   Should registered autoChild attributes be automatically resized with
         *   Canvas.resizeControls and
         *   Canvas.resizeFonts?
         * 
         *   If true, attributes registered for resize with policy "controls" will
         *   be resized when resizeControls() runs, and icons registered
         *   with policy "fonts" will resize when resizeFonts() runs.
         * 
         *   To resize autoChild attributes with other policies, developers should call
         *   Canvas.resizeAutoChildAttributes directly
         * 
         * 
         * 
         *  @param {boolean} true if attributes should be auto-resized
         */
        fun setAutoResizeAutoChildAttributes(autoResize: Boolean): Unit = definedExternally
        /**
         *   Change the basic size of icons in the current skin by "delta" pixels. This method may
         *   be invoked automatically from Canvas.resizeControls.
         * 
         *   Must be called after the skin has been loaded, but before any components are created.
         * 
         * 
         *  @param {string} Which set of icons should be resized? This should correspond to the  iconSizingPolicy argument applied when   Canvas.registerIconSizingAttributes.
         *  @param {Integer} number of pixels to increase or decrease from current size
         */
        fun resizeIcons(policy: String, delta: Number): Unit = definedExternally
        /**
         *   Register numeric or measure type properties of some class(es) as
         *   "icon sizing attributes". These are
         *   properties that should be adjusted when Canvas.resizeIcons is called.
         *   Typically these will consist of icon width and height attributes on some SmartClient
         *   class, such as ListGrid.checkboxFieldImageHeight and
         *   ListGrid.checkboxFieldImageWidth.
         * 
         *   The policy parameter allows icons to be grouped together into sets so particular types of
         *   UI element can be resized in a targeted manner. For example, the width and height of
         *   an icon which will appear aligned with a line of text would typically want to be resized
         *   at the same time as font sizes are adjusted, whereas an icon that corresponds to a
         *   block of control UI (such as a picker icon that sits outside of an associated FormItem),
         *   should be resized when that control element is resized.
         * 
         *   A policy can be any string. To modify the sizes of attributes registered under some
         *   policy, that same policy string should be passed to the Canvas.resizeIcons method.
         * 
         *   The attributes parameter consists of a JavaScript object where each key specifies
         *   the name of the class on which the attributes, with its value set to an array, indicating
         *   the attribute(s) to register within that class.
         * 
         *   Icon sizing attributes can be specified individually or in pairs. When a single attribute
         *   passed in, a call to Canvas.resizeIcons will modify that attribute by the
         *   delta parameter. If a pair of attributes is passed in, this is assumed to
         *   be a height,width pair. When Canvas.resizeIcons is called in this case,
         *   both attributes will be modified such that they maintain the same scale. In other words,
         *   the first registered attribute (typically the height) will be adjusted by the specified
         *   delta (a simple numeric adjustment). The second attribute will be adjusted by
         *   a numeric delta calculated to have the same ratio to the original width as the
         *   provided delta had to the original height. This allows icons to be resized without
         *   becoming distorted.
         * 
         *   For example, the following code would register FormItem attributes "valueIconSize",
         *   "valueIconWidth" and "valueIconHeight" for resizing as part of the "fonts" policy,
         *   such that both "valueIconSize" and "valueIconHeight" would be changed by the value passed
         *   to resizeIcons(..), and "valueIconWidth" would be changed such that the
         *   width/height ratio was retained.
         * 
         *   isc.Canvas.registerIconSizingAttributes(
         *    "fonts",
         *    {
         *     FormItem:[
         *       "valueIconSize",
         *       ["valueIconHeight", "valueIconWidth"]
         *     ]
         *    }
         *   );
         * 
         * 
         *   The Canvas.setAutoResizeIcons feature will cause icon attributes
         *   registered with policy "controls" to be resized when Canvas.resizeControls
         *   is run and attributes registered as "fonts" to be resized when
         *   Canvas.resizeFonts is run.
         * 
         * 
         *  @param {string} Icon sizing policy for this set of attributes
         *  @param {object} The attribute(s) to register for resizing.
         */
        fun registerIconSizingAttributes(policy: String, attributes: dynamic): Unit = definedExternally
        /**
         *   Register numeric or measure type properties of on autoChild properties blocks for
         *   some class(es).
         *   These are
         *   properties that should be adjusted when Canvas.resizeAutoChildAttributes is called.
         *   Typically these will consist of width and height attributes on some autoChild defaults block
         *   for some SmartClient class, such as Window.closeButtonDefaults
         *   (to modify width and height of Window.closeButton).
         * 
         *   As with Canvas.registerIconSizingAttributes, the policy parameter allows
         *   attributes to be grouped together into sets so particular types of
         *   UI element can be resized in a targeted manner. For example, the width and height of
         *   an icon which will appear aligned with a line of text would typically want to be resized
         *   at the same time as font sizes are adjusted, whereas an icon that corresponds to a
         *   block of control UI (such as a picker icon that sits outside of an associated FormItem),
         *   should be resized when that control element is resized.
         * 
         *   A policy can be any string. To modify the sizes of attributes registered under some
         *   policy, that same policy string should be passed to the Canvas.resizeAutoChildAttributes
         *   method.
         * 
         *   The className should be the name of the class on which the auto child properties block
         *   exists.
         * 
         *   The attributes parameter consists of a JavaScript object where each key specifies
         *   the name of the autoChild properties block to modify, with its value set to an array,
         *   indicating the attribute(s) to register.
         * 
         *   Sizing attributes can be specified individually or in pairs. When a single attribute
         *   passed in, a call to Canvas.resizeAutoChildAttributes will modify that attribute by the
         *   delta parameter. If a pair of attributes is passed in, this is assumed to
         *   be a height,width pair. When Canvas.resizeAutoChildAttributes is called in this case,
         *   both attributes will be modified such that they maintain the same scale. In other words,
         *   the first registered attribute (typically the height) will be adjusted by the specified
         *   delta (a simple numeric adjustment). The second attribute will be adjusted by
         *   a numeric delta calculated to have the same ratio to the original width as the
         *   provided delta had to the original height. This allows icons to be resized without
         *   becoming distorted.
         * 
         *   For example, the following code would register the attributes "width" and "height" properties
         *   on the "closeButtonDefaults" properties block, within the Window class - thus
         *   customizing the default size of the Window.closeButton autoChild.
         *   It registers them as part of the "controls" policy.
         * 
         *   isc.Canvas.registerAutoChildSizingAttributes(
         *    "fonts",
         *    "Window",
         *    {
         *     closeButtonDefaults:[
         *       ["height", "width"]
         *     ]
         *    }
         *   );
         * 
         * 
         *   The Canvas.setAutoResizeAutoChildAttributes
         *   feature will cause registered autoChild attributes to resize automatically.
         *   Those registered with policy "controls" to be resized when Canvas.resizeControls
         *   is run and attributes registered as "fonts" to be resized when
         *   Canvas.resizeFonts is run.
         * 
         * 
         *  @param {string} Sizing policy for this set of attributes
         *  @param {string} Name of the class containing the autoChild configuration block to edit
         *  @param {object} The attribute(s) to register for resizing.
         */
        fun registerAutoChildSizingAttributes(policy: String, className: String, attributes: dynamic): Unit = definedExternally
        /**
         *   Change the value of attributes registered via Canvas.registerAutoChildSizingAttributes
         *   by some number of pixels. This method may
         *   be invoked automatically from Canvas.resizeControls or Canvas.resizeFonts
         * 
         *   Must be called after the skin has been loaded, but before any components are created.
         * 
         * 
         *  @param {string} Which set of attributes should be resized? This should correspond to the  sizing policy argument applied when   Canvas.registerAutoChildSizingAttributes.
         *  @param {Integer} number of pixels to increase or decrease from current size
         */
        fun resizeAutoChildAttributes(policy: String, delta: Number): Unit = definedExternally
        /**
         *   Whether to use the browser's native scrollbars or SmartClient-based scrollbars by default
         *   for all canvases.
         * 
         *   This method changes the default value of Canvas.showCustomScrollbars.
         * 
         *  @param {boolean} whether to show custom (SmartClient-based) scrollbars  rather than css-scrollbars by default.
         */
        fun setShowCustomScrollbars(showCustomScrollbars: Boolean): Unit = definedExternally
        /**
         *   Returns print-formatted HTML for the specified list of components.
         * 
         * 
         *  @param {Array<Partial<Canvas>>} Components to get the print HTML for. Strings of raw HTML may also be included in this array, and will be integrated into the final HTML at the appropriate  point.
         *  @param {PrintProperties} properties affecting print output
         *  @param {Callback=} Callback to fire when the method completes. The generated print HTML will be passed in as the first parameter HTML.
         *  @param {HTMLString=} Optional HTML separator to render between each component's printable HTML
         */
        fun getPrintHTML(components: Array<dynamic>, printProperties: PrintProperties, callback: dynamic?, separator: String?): String = definedExternally
        /**
         *   Generates the HTML for an image. Also available at the
         *   Canvas.imgHTML.
         * 
         * 
         *  @param {SCImgURL} URL local to the skin or application directory.   NOTE: instead of passing several parameters, you can pass an object as the 'src'    parameter with properties for all the various function parameters with, eg:    canvas.imgHTML( {src:"foo", width:10, height:10} );
         *  @param {number=} width of the image
         *  @param {number=} height of the image
         *  @param {string=} name for the image
         *  @param {string=} additional attributes to write in the tag
         *  @param {string=} image-specific image directory
         */
        fun imgHTML(src: String, width: Number?, height: Number?, name: String?, extraStuff: String?, imgDir: String?): String = definedExternally
        /**
         *       Given a string and a character, hilite the first occurrence of the character in the
         *       string (if it occurs), preferring uppercase to lowercase.
         * 
         * 
         *  @param {string} String to return with hilited character
         *  @param {string} Character to hilite
         *  @param {string=} Prefix to apply to hilighted character - defaults to                   "&lt;span style='text-decoration:underline;'&gt;"
         *  @param {string=} Suffix to apply to hilited character - defaults to                     "&lt;/span&gt;"
         */
        fun hiliteCharacter(string: String, character: String, hilitePrefix: String?, hiliteSuffix: String?): String = definedExternally
        /**
         *   Return the position for snapper to be placed in order to "snap to" an edge or
         *   corner of target, in the same sense as Canvas.snapTo.
         * 
         *   Default for snapEdge is the opposite edge or corner from
         *   snapTo. For example, snapTo of "T" (top) means snapEdge
         *   will default to "B" (bottom), so the returned coordinates would place snapper
         *   centered along the top edge of target. A snapTo of "TL" (top left)
         *   means snapEdge will default to "BR" (bottom right), so the returned coordinates
         *   would place the bottom right of snapper at the top left corner of
         *   target.
         * 
         *   target can be passed as either a Canvas or 4-element Array giving the top, left,
         *   width and height of the target.
         *   snapper can be passed as either a Canvas or a
         *   two-element Array of the width and height of the rectangle to be placed.
         * 
         * 
         *  @param {Canvas | Array<Partial<Integer>>} canvas to snap to
         *  @param {string} edge against which to snap
         *  @param {Canvas | Array<Partial<Integer>>} canvas being snapped
         *  @param {string=} optional edge to snapTo. Default is the opposite edge or corner from snapTo
         */
        fun getSnapPosition(target: dynamic, snapTo: String, snapper: dynamic, snapEdge: String?): Point = definedExternally
        /**
         *   Generate printable HTML for the designated components and trigger the native print
         *   dialog, without never showing the printable HTML to the user.
         * 
         * 
         *  @param {Array<Partial<Canvas>>} components to get the print HTML for. May also include    raw HTML strings which will be folded into the generated print output
         *  @param {PrintProperties=} object for customizing the print HTML output
         */
        fun printComponents(components: Array<dynamic>, printProperties: PrintProperties?): Unit = definedExternally
        /**
         *   Creates a printCanvas containing the full printHTML for a series of components, passing
         *   it as an argument to the callback (if supplied) when it fires. Note that the generated
         *   preview canvas will be drawn automatically by this method. Developers may also
         *   explicitly create a PrintCanvas instance and populate it with HTML derived from the
         *   Canvas.getPrintHTML for finer grained control over when the print canvas is
         *   drawn.
         * 
         *  @param {Array<Partial<Canvas>>} components to get the print HTML for. May also include  raw HTML strings which will be folded into the generated print output
         *  @param {PrintProperties=} PrintProperties object for customizing the print HTML output
         *  @param {Canvas=} properties to apply to the generated printPreview Canvas.
         *  @param {PrintCanvasCallback=} callback to fire when the print preview canvas has been populated  with the printable HTML. The generated canvas will be passed to the callback as a single   printPreview parameter.
         *  @param {string=} optional string of HTML to render between each component
         */
        fun getPrintPreview(components: Array<dynamic>, printProperties: PrintProperties?, previewProperties: Canvas?, callback: ((printPreview: PrintCanvas) -> Unit?), separator: String?): Unit = definedExternally
        /**
         *   Generate and show a PrintWindow containing a PrintCanvas
         *   showing a printable view of the components passed in.
         * 
         * 
         *  @param {Array<Partial<Canvas>>} components to get the print HTML for. May also include raw HTML strings which will be folded into the generated print output
         *  @param {PrintProperties=} PrintProperties object for customizing the   print HTML output
         *  @param {PrintWindow=} Properties to apply to the   generated print window.
         *  @param {Callback=} callback to fire when the print preview canvas has   been populated with the printable HTML. This callback takes 2 parameters:   printPreview - a pointer to the generated print canvas shown in the   body of the print window.   printWindow - a pointer to the generated print window and
         *  @param {string=} Optional HTML separator to render between each component's printable           HTML
         */
        fun showPrintPreview(components: Array<dynamic>, printProperties: PrintProperties?, printWindowProperties: PrintWindow?, callback: dynamic?, separator: String?): Unit = definedExternally
    }
}