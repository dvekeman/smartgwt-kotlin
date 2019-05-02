@file:JsQualifier("isc")
package isc

/**
 *  Resize bar for use in Layout.resizeBarClass, based on the
 *   Img class. As with the Splitbar class,
 *   widgets of this class can be displayed as a resize-bar for widgets
 *   in Layouts where showResizeBar is set to true. Provides a different appearance from
 *   the Splitbar class.
 * 
 *   To specify the resizeBar class for some layout, use the Layout.resizeBarClass
 *   property.
 */
open external class ImgSplitbar : Img {
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
    open var vertical: Boolean = definedExternally
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
     *  Default directory for skin images (those defined by the class), relative to the
     *   Page-wide Page.getSkinDir.
     *  @type {SCImgURL}
     *  @default "images/SplitBar/"
     */
    override var skinImgDir: String = definedExternally
    /**
     *  The base filename for the image.
     * 
     *   This value will be combined with any specified StatefulCanvas.state
     *   to form a combined URL, changing the appearance of the component as the
     *   state changes.
     * 
     *   The following table lists out the standard set of combined URLs that
     *   may be generated. Subclasses may support additional state-derived media of course.
     *   Note that the src URL will be split such that the extension is always applied to the
     *   end of the combined string. For example in the following table, if src
     *   was set to "blank.gif", the Selected+Focused URL would be
     *   "blank_Selected_Focused.gif".
     * 
     *   URL for Img sourceDescription
     *   src+extensionDefault URL
     *   src+"_Selected"+extension
     *     Applied when StatefulCanvas.selected is set to true
     *   src+"_Focused"+extension
     *     Applied when the component has keyboard focus, if
     *     StatefulCanvas.showFocused is true, and
     *     StatefulCanvas.showFocusedAsOver is not true.
     *   src+"_Over"+extension
     *     Applied when the user rolls over the component if
     *       StatefulCanvas.showRollOver is set to true
     *   src+"_Down"+extension
     *     Applied when the user presses the mouse button over over the component if
     *       StatefulCanvas.showDown is set to true
     *   src+"_Disabled"+extension
     *     Applied to Canvas.disabled component
     *      if StatefulCanvas.showDisabled is true.
     *   Combined states
     *   src+"_Selected_Focused"+extension
     *     Combined Selected and focused state
     *   src+"_Selected_Over"+extension
     *     Combined Selected and rollOver state
     *   src+"_Focused_Over"+extension
     *     Combined Focused and rollOver state
     *   src+"_Selected_Focused_Over"+extension
     *     Combined Selected, Focused and rollOver state
     *   src+"_Selected_Down"+extension
     *     Combined Selected and mouse-down state
     *   src+"_Focused_Down"+extension
     *     Combined Focused and mouse-down state
     *   src+"_Selected_Focused_Down"+extension
     *     Combined Selected, Focused and mouse-down state
     *   src+"_Selected_Disabled"+extension
     *     Combined Selected and Disabled state
     * 
     *  @type {string}
     *  @default null
     */
    override var src: String = definedExternally
    /**
     *  Default src to display when ImgSplitbar.vertical is false,
     *   and ImgSplitbar.src is unset.
     *  @type {string}
     *  @default "[SKIN]hgrip.png"
     */
    open var hSrc: String = definedExternally
    /**
     *  Default src to display when ImgSplitbar.vertical is true,
     *   and ImgSplitbar.src is unset.
     *  @type {SCImgURL}
     *  @default "[SKIN]vgrip.png"
     */
    open var vSrc: String = definedExternally
    companion object {
        /**
         *  Creates a new ImgSplitbar
         * 
         *  @param typeCheckedProperties {Partial<ImgSplitbar>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ImgSplitbar} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ImgSplitbar = definedExternally
    }
}