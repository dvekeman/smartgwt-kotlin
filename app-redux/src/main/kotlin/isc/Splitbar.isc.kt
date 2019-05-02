@file:JsQualifier("isc")
package isc

/**
 *  Resize bar for use in Layout.resizeBarClass, based on the
 *   StretchImg class. As with the ImgSplitbar class,
 *   widgets of this class can be displayed as a resize-bar for widgets
 *   in Layouts where showResizeBar is set to true. Provides a different appearance from
 *   the ImgSplitbar class.
 * 
 *   To specify the resizeBar class for some layout, use the Layout.resizeBarClass
 *   property.
 */
open external class Splitbar : StretchImg {
    /**
     *  When a Splitbar is created by a layout, the target property
     *   of the Splitbar will be a pointer to the member for which it is acting as a resizeBar.
     *   The Splitbar will be positioned next to its target, and will resize it on drag completion.
     * 
     *   See Layout.resizeBarClass, Canvas.showResizeBar and
     *   Canvas.resizeBarTarget for details on configuring the resize bars shown in Layouts.
     *  @type {Canvas}
     *  @default null
     */
    open var target: Canvas = definedExternally
    /**
     *  Is this split bar vertically orientated?
     *   When a Splitbar is created by a layout to be the resizeBar for some
     *   member of the layout, the vertical property will be set to true
     *   if the layout is horizontal, meaning this resizeBar will be taller than it is wide,
     *   and will allow horizontal resizing of the member.
     *  @type {boolean}
     *  @default null
     */
    override var vertical: Boolean = definedExternally
    /**
     *  The base URL for the image.
     * 
     *   The State for the component will be combined with this URL using the
     *   same approach as described in Img.src.
     *   Then the image segment StretchItem.name as specified by each StretchItem
     *   is added.
     * 
     *   For example, for a stretchImg in "Over" state with a src of "button.png"
     *   and a segment name of "stretch", the resulting URL would be "button_Over_stretch.png".
     *  @type {SCImgURL}
     *  @default null
     */
    override var src: String = definedExternally
    /**
     *  Base URL for the image if StretchImg.vertical is false and
     *   StretchImg.src is unset.
     *  @type {SCImgURL}
     *  @default null
     */
    override var hSrc: String = definedExternally
    /**
     *  Base URL for the image if StretchImg.vertical is true and
     *   StretchImg.src is unset.
     *  @type {SCImgURL}
     *  @default null
     */
    override var vSrc: String = definedExternally
    /**
     *  If the default items are used, capSize is the size in pixels of the first and last
     *       images in this stretchImg.
     *  @type {Integer}
     *  @default null
     */
    override var capSize: Number = definedExternally
    /**
     *  Default directory for skin images (those defined by the class), relative to the
     *   Page-wide Page.getSkinDir.
     *  @type {SCImgURL}
     *  @default null
     */
    override var skinImgDir: String = definedExternally
    /**
     *  Should we show a "grip" image floating above the center of this widget?
     *  @type {boolean}
     *  @default null
     */
    override var showGrip: Boolean = definedExternally
    /**
     *  Suffix used the 'grip' image if StretchImg.showGrip is true.
     *  @type {string}
     *  @default "grip"
     */
    override var gripImgSuffix: String = definedExternally
    /**
     *  If StretchImg.showGrip is true, this property determines whether to show the
     *   'Down' state on the grip image when the user mousedown's on this widget.
     *   Has no effect if StatefulCanvas.showDown is false.
     *  @type {boolean}
     *  @default null
     */
    override var showDownGrip: Boolean = definedExternally
    /**
     *  If StretchImg.showGrip is true, this property determines whether to show the
     *   'Over' state on the grip image when the user rolls over on this widget.
     *   Has no effect if StatefulCanvas.showRollOver is false.
     *  @type {boolean}
     *  @default null
     */
    override var showRollOverGrip: Boolean = definedExternally
    /**
     *  If Splitbar.showGrip is true, this property determines whether the grip image
     *   displayed should show the "Closed" state when the Splitbar.target
     *   is hidden. Note that if Splitbar.invertClosedGripIfTargetAfter is true, we
     *   may show the "closed" state when the target is visible, rather than when it is hidden.
     *  @type {boolean}
     *  @default null
     */
    open var showClosedGrip: Boolean = definedExternally
    /**
     *  Is the Splitbar.target being shown before or after the bar? This property is
     *   automatically populated for splitbars created by a layout.
     *  @type {boolean}
     *  @default null
     */
    open var targetAfter: Boolean = definedExternally
    /**
     *  If Splitbar.showClosedGrip is true, and Splitbar.targetAfter is true
     *   should we show the "closed" state for the grip when the target is visible (rather than
     *   when it is hidden).
     * 
     *   This property is useful for the case where the grip media is a simple directional arrow.
     *   The same image can be used for expanded state on one side of the bar or collapsed
     *   state on the other.
     *  @type {boolean}
     *  @default true
     */
    open var invertClosedGripIfTargetAfter: Boolean = definedExternally
    /**
     *  canDrag set to true to allow dragging of the split bar. Dragging the
     *   Splitbar will resize it's Splitbar.target
     *  @type {boolean}
     *  @default true
     */
    override var canDrag: Boolean = definedExternally
    /**
     *  If this property is true, a click on the Splitbar will collapse its
     *   Splitbar.target, hiding it and shifting the Splitbar and other members
     *   of the layout across to fill the newly available space. If the target is already hidden
     *   a click will expand it again (showing it at its normal size).
     * 
     *   Note that on touch devices, to enable collapsing/uncollapsing the target
     *   in response to a tap, Splitbar.canCollapseOnTap must be set to
     *   true.
     *  @type {boolean}
     *  @default true
     */
    open var canCollapse: Boolean = definedExternally
    /**
     *  If Splitbar.canCollapse is true, should a tap result in
     *   collapsing/uncollapsing the Splitbar.target? By default this is false
     *   because it can be difficult to tap a thin Splitbar.
     * 
     *   If this property is set to true, it is recommended to increase the width/height
     *   of the Splitbar on touch devices (see, e.g., Layout.resizeBarSize).
     *  @type {boolean}
     *  @default false
     */
    open var canCollapseOnTap: Boolean = definedExternally
    /**
     *  Splitbars' cursors are set at init time based on whether they are to be used for vertical or
     *   horizontal resize. To customize the cursor for this class, modify
     *   Splitbar.vResizeCursor or Splitbar.hResizeCursor rather than this property.
     *  @type {Cursor}
     *  @default "hand"
     */
    override var cursor: 
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
     *  Cursor to display if this Splitbar is to be used for vertical resize of widgets.
     *  @type {Cursor}
     *  @default "row-resize"
     */
    open var vResizeCursor: 
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
     *  Cursor to display if this Splitbar is to be used for horizontal resize of widgets.
     *  @type {Cursor}
     *  @default "col-resize"
     */
    open var hResizeCursor: 
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
    companion object {
        /**
         *  Creates a new Splitbar
         * 
         *  @param typeCheckedProperties {Partial<Splitbar>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Splitbar} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Splitbar = definedExternally
    }
}