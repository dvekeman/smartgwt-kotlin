@file:JsQualifier("isc")
package isc

/**
 *  The Scrollbar widget implements cross-platform, image-based scrollbars that control the
 *   scrolling of content in other widgets. Scrollbar widgets are created and displayed
 *   automatically for widgets that require them, based on settings for Canvas.overflow.
 * 
 *   The scrollbar's appearance is based on a StretchImg for the "track", which consists
 *   of two fixed size buttons and a stretchable center segment, and the ScrollThumb,
 *   the draggable portion of the scrollbar, also a StretchImg, with an optional
 *   StretchImg.showGrip.
 */
open external class Scrollbar : StretchImg {
    /**
     *  The size of the square buttons (arrows) at the ends of this scrollbar. This overrides
     *   Canvas.scrollbarSize to set the width of a vertical scrollbar or the height of a
     *   horizontal scrollbar. If not set it will default to Canvas.scrollbarSize.
     *  @type {number}
     *  @default null
     */
    open var btnSize: Number = definedExternally
    /**
     *  If true, this scrollbar will automatically enable when the scrollTarget is
     *   scrollable (i.e., when the contents of the scrollTarget exceed its clip size in the
     *   direction relevant to this scrollbar), and automatically disable when the
     *   scrollTarget is not scrollable. Set this property to false for full manual control
     *   over a scrollbar's enabled state.
     *  @type {boolean}
     *  @default true
     */
    open var autoEnable: Boolean = definedExternally
    /**
     *  If true, displays a corner piece at the bottom end of a vertical scrollbar, or the
     *   right end of a horizontal scrollbar. This is typically set only when both horizontal
     *   and vertical scrollbars are displayed and about the same corner.
     *  @type {boolean}
     *  @default false
     */
    open var showCorner: Boolean = definedExternally
    /**
     *  If true, the thumb's appearance changes when it's clicked on.
     *  @type {boolean}
     *  @default false
     */
    open var allowThumbDownState: Boolean = definedExternally
    /**
     *  If true, the thumb's appearance changes when the user rolls over it.
     *  @type {boolean}
     *  @default false
     */
    open var allowThumbOverState: Boolean = definedExternally
    /**
     *  If true, the scrollbar uses a 5-segment rather than 3-segment image representation,
     *   where the 3 interior image segments have the same state (Down, Over, etc), independent
     *   of the two outermost image segments.
     * 
     *   This allows certain advanced skinning designs where the track-as-such (space in which
     *   the thumb may be dragged) has curved endcaps, and is also visually stateful (that is,
     *   changes when the mouse goes down, without affecting the appearance of the outermost
     *   segments).
     *  @type {boolean}
     *  @default false
     */
    open var showTrackEnds: Boolean = definedExternally
    /**
     *  Should the track buttons that allow page scrolling be shown?
     * 
     *  @type {boolean}
     *  @default true
     */
    open var showTrackButtons: Boolean = definedExternally
    /**
     *  The minimum pixel size of the draggable thumb regardless of how large the scrolling
     *   region becomes.
     *  @type {number}
     *  @default "12"
     */
    open var thumbMinSize: Number = definedExternally
    /**
     *  The minimum pixel width of the track end segments (if enabled with showTrackEnds).
     *  @type {number}
     *  @default "12"
     */
    open var trackEndWidth: Number = definedExternally
    /**
     *  The minimum pixel height of the track end segments (if enabled with showTrackEnds).
     *  @type {number}
     *  @default "12"
     */
    open var trackEndHeight: Number = definedExternally
    /**
     *  Number of pixels the thumb is allowed to overlap the buttons at each end of the track.
     *   Default prevents doubling of 1px borders. Set higher to allow media that shows curved
     *   joins between the track button and ScrollThumb.
     *  @type {number}
     *  @default "1"
     */
    open var thumbOverlap: Number = definedExternally
    /**
     *  Number of pixels the thumb is allowed to overlap the buttons at the start of the track.
     *   Default prevents doubling of 1px borders. Set higher to allow media that shows curved
     *   joins between the track button and ScrollThumb.
     *  @type {number}
     *  @default null
     */
    open var startThumbOverlap: Number = definedExternally
    /**
     *  Number of pixels the thumb is allowed to overlap the buttons at the end of the track.
     *   Default prevents doubling of 1px borders. Set higher to allow media that shows curved
     *   joins between the track button and ScrollThumb.
     *  @type {number}
     *  @default null
     */
    open var endThumbOverlap: Number = definedExternally
    /**
     *  Inset of the thumb relative to the track. An inset of N pixels means the thumb is 2N
     *   pixels smaller in breadth than the track.
     *  @type {number}
     *  @default null
     */
    open var thumbInset: Number = definedExternally
    /**
     *  Where are the skin images for the Scrollbar. This is local to the Page.getSkinDir.
     *  @type {SCImgURL}
     *  @default "images/Scrollbar/"
     */
    override var skinImgDir: String = definedExternally
    /**
     *  URL for the corner image, a singular image that appears in the corner when both h and v
     *   scrollbars are showing.
     *  @type {SCImgURL}
     *  @default "[SKIN]corner.gif"
     */
    open var cornerSrc: String = definedExternally
    /**
     *  Allows the size of the corner segment to be set independently of the Scrollbar.btnSize.
     *  @type {Integer}
     *  @default null
     */
    open var cornerSize: Number = definedExternally
    /**
     *  Base URL for the images used for the horizontal scrollbar track and end buttons.
     * 
     *   See StretchImg.items for a general explanation of how this base URL is
     *   transformed into various pieces and states.
     * 
     *   For a normal 3-segment track, the suffixes "_start", "_track" and "_end" are added to
     *   this URL. The "start" and "end" images should appear to be buttons (the user can click
     *   on these segments to scroll slowly). The "track" segment provides a background for the
     *   space in which the thumb can be dragged, and can also be clicked on to scroll quickly.
     * 
     *   For a 5-segment track (Scrollbar.showTrackEnds:true), the suffixes are "_start", "_track_start",
     *   "_track", "_track_end" and "_end".
     *  @type {SCImgURL}
     *  @default "[SKIN]hscroll.gif"
     */
    override var hSrc: String = definedExternally
    /**
     *  Base URL for the images used for the vertical scrollbar track and end buttons. See
     *   Scrollbar.hSrc for usage.
     *  @type {SCImgURL}
     *  @default "[SKIN]vscroll.gif"
     */
    override var vSrc: String = definedExternally
    /**
     *  The StretchItem for the start of a scrollbar (the "scroll up" or "scroll left" button
     *   image). The default is:
     *   { name:"start", width:"btnSize", height:"btnSize" }
     * 
     *  @type {StretchItem}
     *  @default "see below"
     */
    open var startImg: StretchItem = definedExternally
    /**
     *  The StretchItem for the start of a scrollbar track. The default is:
     *   { name:"track_start", width:"trackStartSize", height:"trackStartSize" }
     * 
     *  @type {StretchItem}
     *  @default "see below"
     */
    open var trackStartImg: StretchItem = definedExternally
    /**
     *  The StretchItem for the middle part of a scrollbar track, which usually takes up the majority
     *   of the width or height of the scrollbar. The default is:
     *   { name:"track", width:"\*", height:"\*" }
     * 
     *  @type {StretchItem}
     *  @default "see below"
     */
    open var trackImg: StretchItem = definedExternally
    /**
     *  The StretchItem for the end of a scrollbar track. The default is:
     *   { name:"track_end", width:"trackEndSize", height:"trackEndSize" }
     * 
     *  @type {StretchItem}
     *  @default "see below"
     */
    open var trackEndImg: StretchItem = definedExternally
    /**
     *  The StretchItem for the end of a scrollbar (the "scroll down" or "scroll right" button
     *   image). The default is:
     *   { name:"end", width:"btnSize", height:"btnSize" }
     * 
     *  @type {StretchItem}
     *  @default "see below"
     */
    open var endImg: StretchItem = definedExternally
    /**
     *  The StretchItem for the corner between vertical and horizontal scrollbars. The width
     *   and height are determined automatically, so StretchItem.width and StretchItem.height
     *   set on the cornerImg StretchItem are ignored. The default is:
     *   { name:"corner" }
     * 
     *  @type {StretchItem}
     *  @default "see below"
     */
    open var cornerImg: StretchItem = definedExternally
    /**
     *  The widget whose contents should be scrolled by this scrollbar. The scrollbar thumb
     *   is sized according to the amount of visible vs. scrollable content in this widget.
     *  @type {Canvas}
     *  @default null
     */
    open var scrollTarget: Canvas = definedExternally
    /**
     *       Sets or clears the scrollbar's scrollTarget. If no argument is provided, then the
     *       scrollTarget will be set to the scrollbar itself.
     * 
     * 
     *  @param {Canvas=} target canvas to be scrolled
     */
    open fun setScrollTarget(newTarget: Canvas?): Unit = definedExternally
    companion object {
        /**
         *  Creates a new Scrollbar
         * 
         *  @param typeCheckedProperties {Partial<Scrollbar>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Scrollbar} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Scrollbar = definedExternally
    }
}