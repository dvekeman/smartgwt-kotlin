@file:JsQualifier("isc")
package isc

/**
 *  The StretchImg widget class implements a widget type that displays a list of multiple images
 *   that make up a single image.
 */
open external class StretchImg : StatefulCanvas {
    /**
     *  Indicates whether the list of images is drawn vertically from top to bottom (true),
     *   or horizontally from left to right (false).
     *  @type {boolean}
     *  @default true
     */
    open var vertical: Boolean = definedExternally
    /**
     *  If the default items are used, capSize is the size in pixels of the first and last
     *       images in this stretchImg.
     *  @type {number}
     *  @default "2"
     */
    open var capSize: Number = definedExternally
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
    open var src: String = definedExternally
    /**
     *  Base URL for the image if StretchImg.vertical is false and
     *   StretchImg.src is unset.
     *  @type {SCImgURL}
     *  @default null
     */
    open var hSrc: String = definedExternally
    /**
     *  Base URL for the image if StretchImg.vertical is true and
     *   StretchImg.src is unset.
     *  @type {SCImgURL}
     *  @default null
     */
    open var vSrc: String = definedExternally
    /**
     *  Indicates whether the image should be tiled/cropped, stretched, or centered when the
     *       size of this widget does not match the size of the image. See ImageStyle for
     *       details.
     *  @type {ImageStyle}
     *  @default "stretch"
     */
    open var imageType: 
                        /**
                         *  Center (and don't stretch at all) the image if smaller than its enclosing frame.CENTER:"center",
                         *  Tile (repeat) the image if smaller than its enclosing frame.
                         *  Stretch the image to the size of its enclosing frame.
                         *  Allow the image to have natural size
                         */
                        String /* center |  tile |  stretch |  normal */ = definedExternally
    /**
     *  The list of images to display as an array of objects specifying the image names and
     *   sizes.
     * 
     *   The StretchItem.name is appended as a suffix to the StretchImg.src URL in order
     *   to fetch separate media files for each image. Alternatively a StretchItem may specify
     *   its own StretchItem.src.
     * 
     *   The StretchItem.height and StretchItem.width can be set to a number,
     *   "\*" (remaining space, divided amongst all images that specify "\*") or to the name of a
     *   property on this StretchImg component, such as "capSize" for the StretchImg.capSize.
     * 
     *   Height or width is only used for the axis along which images are stacked. For example, if
     *   StretchImg.vertical is true, images stack vertically and heights are used to size images on
     *   the vertical axis, but all images will have width matching the overall component size.
     * 
     *   For example, the default setting for items, which is used to produce
     *   stretchable buttons and headers with fixed-size endcaps, is as follows:
     * 
     *    items:[
     *      {height:"capSize", name:"start", width:"capSize"},
     *      {height:"\*", name:"stretch", width:"\*"},
     *      {height:"capSize", name:"end", width:"capSize"}
     *    ]
     * 
     *   Note that by default horizontal StretchImg instances will always render their items
     *   in left-to-right order, even if the page is localized for right-to-left display
     *   (see Page.isRTL). This default behavior may be overridden by setting the
     *   StretchImg.ignoreRTL flag to false.
     *  @type {Array<Partial<StretchItem>>}
     *  @default "see below"
     */
    open var items: Array<dynamic> = definedExternally
    /**
     *  Should the StretchImg.items for this StretchImg display left-to-right even
     *   if this page is displaying Page.isRTL?
     * 
     *   Only has an effect if this StretchImg is horizontal (StretchImg.vertical
     *   is set to false).
     * 
     *   Having this property set to true is usually desirable for the common pattern of media
     *   consisting of fixed size "end caps" and a stretchable center, because it allows the same
     *   media to be used for LTR and RTL pages.
     * 
     *   If set to false, items will be displayed in RTL order for RTL pages.
     *  @type {boolean}
     *  @default true
     */
    override var ignoreRTL: Boolean = definedExternally
    /**
     *  Should we show a "grip" image floating above the center of this widget?
     *  @type {boolean}
     *  @default null
     */
    open var showGrip: Boolean = definedExternally
    /**
     *  Suffix used the 'grip' image if StretchImg.showGrip is true.
     *  @type {string}
     *  @default "grip"
     */
    open var gripImgSuffix: String = definedExternally
    /**
     *  If StretchImg.showGrip is true, this property determines whether to show the
     *   'Down' state on the grip image when the user mousedown's on this widget.
     *   Has no effect if StatefulCanvas.showDown is false.
     *  @type {boolean}
     *  @default null
     */
    open var showDownGrip: Boolean = definedExternally
    /**
     *  If StretchImg.showGrip is true, this property determines whether to show the
     *   'Over' state on the grip image when the user rolls over on this widget.
     *   Has no effect if StatefulCanvas.showRollOver is false.
     *  @type {boolean}
     *  @default null
     */
    open var showRollOverGrip: Boolean = definedExternally
    /**
     *  Determines whether any specified StatefulCanvas.getTitle will be
     *   displayed for this component.
     *   Applies to Image-based components only, where the title will be rendered out in a label
     *   floating over the component
     *  @type {boolean}
     *  @default false
     */
    open var showTitle: Boolean = definedExternally
    /**
     *  If specified this css class will be applied to the individual item images within this StretchImg.
     *   May be overridden by specifying item-specific base styles to each object in the
     *   StretchImg.items. This base style will have standard stateful suffixes
     *   appended to indicate the state of this component (as described in
     *   StatefulCanvas.baseStyle).
     *  @type {CSSStyleName}
     *  @default null
     */
    open var itemBaseStyle: String = definedExternally
    /**
     *   Set the specified image's state to newState and update the displayed image given by
     *   whichPart, or set the state for all images to newState and update the displayed images
     *   if whichPart is not provided.
     * 
     *  @param {string} name for the new state ("off", "down", etc)
     *  @param {string=} name of the piece to set ("start", "stretch" or "end")      if not specified, sets them all
     */
    open fun setState(newState: 
                                /**
                                 *  state when mouse is not acting on this StatefulCanvas
                                 *  state when mouse is down
                                 *  state when mouse is over
                                 *  disabled
                                 */
                                String /*  |  Down |  Over |  Disabled */, whichPart: String?): Unit = definedExternally
    /**
     *   Changes the base StretchImg.src for this stretchImg, redrawing if necessary.
     * 
     * 
     *  @param {SCImgURL} new URL for the image
     */
    open fun setSrc(src: String): Unit = definedExternally
    /**
     *   Setter for StretchImg.items.
     * 
     *  @param {Array<Partial<StretchItem>>} the new array of items.
     */
    open fun setItems(items: Array<dynamic>): Unit = definedExternally
    /**
     *   Setter for StretchImg.ignoreRTL.
     * 
     *  @param {boolean} new value for ignoreRTL.
     */
    override fun setIgnoreRTL(ignoreRTL: Boolean): Unit = definedExternally
    companion object {
        /**
         *  Creates a new StretchImg
         * 
         *  @param typeCheckedProperties {Partial<StretchImg>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {StretchImg} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): StretchImg = definedExternally
    }
}