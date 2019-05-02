@file:JsQualifier("isc")
package isc

/**
 *  SectionHeader class based on an HLayout with StretchImg background.
 */
open external class ImgSectionHeader : HLayout {
    /**
     *  Custom controls to be shown on top of this section header.
     * 
     *   These controls are shown in the ImgSectionHeader.controlsLayout.
     * 
     *   Note that this is an init-time property. If you need to dynamically change what
     *   controls are displayed to the user, we would recommend embedding the
     *   controls in a Layout or similar container.
     *   This will allow you to show/hide or add/remove members at runtime
     *   by manipulating the existing control(s) set up at init time.
     *  @type {Array<Partial<Canvas>>}
     *  @default null
     */
    open var controls: Array<dynamic> = definedExternally
    /**
     *  A Layout containing specified ImgSectionHeader.controls if any. Sets
     *   Layout.membersMargin:5, Layout.defaultLayoutAlign:"center", and
     *   RTL-sensitive Layout.align (right by default).
     *  @type {Layout}
     *  @default null
     */
    open var controlsLayout: Layout = definedExternally
    /**
     *  Title to show for the section
     *  @type {HTMLString}
     *  @default null
     */
    open var title: String = definedExternally
    /**
     *  If the title for this section header is too large for the available space, should the title be
     *   clipped?
     * 
     *   This feature is supported only in browsers that support the CSS UI text-overflow
     *   property (IE6+, Firefox 7+, Safari, Chrome, Opera 9+).
     *  @type {boolean}
     *  @default true
     */
    open var clipTitle: Boolean = definedExternally
    /**
     *  If true and the title is clipped, then a hover containing the full title of this section header
     *   is enabled.
     *  @type {boolean}
     *  @default true
     */
    open var showClippedTitleOnHover: Boolean = definedExternally
    /**
     *  Optional icon to be shown with the button title text.
     * 
     *   Specify as the partial URL to an image, relative to the imgDir of this component.
     *   A sprited image can be specified using the SCSpriteConfig format.
     * 
     *   Note that the string "blank" is a valid setting for this attribute and will always
     *   result in the system blank image, with no state suffixes applied. Typically, this
     *   might be used when an iconStyle is also specified and the iconStyle renders the icon via
     *   a stateful background-image or other CSS approach.
     *  @type {SCImgURL}
     *  @default null
     */
    open var icon: String = definedExternally
    /**
     *  If this button is showing an icon should it be right or left aligned?
     *  @type {string}
     *  @default null
     */
    open var iconAlign: String = definedExternally
    /**
     *  Size in pixels of the icon image.
     * 
     *   The StatefulCanvas.iconWidth and StatefulCanvas.iconHeight
     *   properties can be used to configure width and height separately.
     * 
     *   Note: When configuring the properties of a StatefulCanvas (or derivative)
     *   AutoChild, it is best to set the iconWidth and iconHeight
     *   to the same value rather than setting an iconSize. This is because certain
     *   skins or customizations thereto might set the iconWidth and iconHeight,
     *   making the customization of the AutoChild's iconSize ineffective.
     *  @type {Integer}
     *  @default "16"
     */
    open var iconSize: Number = definedExternally
    /**
     *  Height in pixels of the icon image.
     * 
     *   If unset, defaults to StatefulCanvas.iconSize.
     *  @type {Integer}
     *  @default null
     */
    open var iconHeight: Number = definedExternally
    /**
     *  Width in pixels of the icon image.
     * 
     *   If unset, defaults to StatefulCanvas.iconSize.
     *  @type {Integer}
     *  @default null
     */
    open var iconWidth: Number = definedExternally
    /**
     *  If this button is showing an icon should it appear to the left or right of the title?
     *   valid options are "left" and "right".
     *  @type {string}
     *  @default "left"
     */
    open var iconOrientation: String = definedExternally
    /**
     *  Prompt displayed in hover canvas if Canvas.showHover is true.
     *  @type {HTMLString}
     *  @default null
     */
    override var prompt: String = definedExternally
    /**
     *  By default doubleClicks are disabled for SectionHeaders. All mouse click
     *   events will be handled as single clicks. Set this property to false
     *   to enable standard double-click handling.
     *  @type {boolean}
     *  @default true
     */
    override var noDoubleClicks: Boolean = definedExternally
    /**
     *  Background of the section header, based on a StretchImg.
     *  @type {StretchImg}
     *  @default null
     */
    open var background: StretchImg = definedExternally
    /**
     *   For a SectionHeader embedded in a SectionStack, this method will return
     *   a pointer to the SectionStack in which this section header is
     *   embedded.
     * 
     */
    open fun getSectionStack(): SectionStack = definedExternally
    /**
     *   Change the icon being shown for the header.
     * 
     *  @param {SCImgURL} URL of new icon
     */
    open fun setIcon(icon: String): Unit = definedExternally
    /**
     *   If this header is showing an icon should it appear to the left or right of the title?
     *   Valid options are "left" and "right".
     * 
     *  @param {string} the new orientation
     */
    open fun setIconOrientation(orientation: String): Unit = definedExternally
    /**
     *   Sets the horizontal alignment of the title.
     * 
     *  @param {string} the new alignment
     */
    override fun setAlign(align: dynamic): Unit = definedExternally
    /**
     *   Sets the text shown as a tooltip for the header.
     * 
     *  @param {HTMLString} the new tooltip
     */
    open fun setPrompt(prompt: String): Unit = definedExternally
    /**
     *   Is the title of this section header clipped by ImgSectionHeader.controls
     *   or the edge of the header?
     * 
     */
    open fun titleClipped(): Boolean = definedExternally
    /**
     *   Returns the HTML that is displayed by the default ImgSectionHeader.titleHover
     *   handler. Return null or an empty string to cancel the hover.
     * 
     * 
     *  @param {HTMLString} the HTML that would have been displayed by default
     */
    open fun titleHoverHTML(defaultHTML: String): String = definedExternally
    /**
     *   Optional stringMethod to fire when the user hovers over this section header and the title is
     *   clipped. If ImgSectionHeader.showClippedTitleOnHover is true, the default behavior is to
     *   show a hover canvas containing the HTML returned by ImgSectionHeader.titleHoverHTML.
     *   Return false to suppress this default behavior.
     * 
     */
    open fun titleHover(): Boolean = definedExternally
    companion object {
        /**
         *  Creates a new ImgSectionHeader
         * 
         *  @param typeCheckedProperties {Partial<ImgSectionHeader>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ImgSectionHeader} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ImgSectionHeader = definedExternally
    }
}