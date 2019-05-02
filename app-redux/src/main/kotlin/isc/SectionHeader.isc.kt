@file:JsQualifier("isc")
package isc

/**
 *  Simple SectionHeader class based on a Label with an icon, skinnable via CSS.
 */
open external class SectionHeader : Label {
    /**
     *  Title to show for the section
     *  @type {HTMLString}
     *  @default null
     */
    override var title: String = definedExternally
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
    override var showClippedTitleOnHover: Boolean = definedExternally
    /**
     *  Custom controls to be shown on top of this section header.
     * 
     *   These controls are shown in the SectionHeader.controlsLayout.
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
     *  A Layout containing specified SectionHeader.controls if any. Sets
     *   Layout.membersMargin:5, Layout.defaultLayoutAlign:"center", and
     *   RTL-sensitive Layout.align (right by default).
     *  @type {Layout}
     *  @default null
     */
    open var controlsLayout: Layout = definedExternally
    /**
     *  Base filename of the icon that represents open and closed states. The default settings
     *   also change the icon for disabled sections, so a total of four images are required
     *   (opened, closed, Disabled_opened, Disabled_closed).
     * 
     *   Not shown if SectionStackSection.canCollapse is false.
     *  @type {SCImgURL}
     *  @default "[SKIN]SectionHeader/opener.gif"
     */
    override var icon: String = definedExternally
    /**
     *  CSS class for the section header.
     *  @type {CSSStyleName}
     *  @default "sectionHeader"
     */
    override var baseStyle: String = definedExternally
    /**
     *  By default doubleClicks are disabled for SectionHeaders. All mouse click
     *   events will be handled as single clicks. Set this property to false
     *   to enable standard double-click handling.
     *  @type {boolean}
     *  @default true
     */
    override var noDoubleClicks: Boolean = definedExternally
    /**
     *   For a SectionHeader embedded in a SectionStack, this method will return
     *   a pointer to the SectionStack in which this section header is
     *   embedded.
     * 
     */
    open fun getSectionStack(): SectionStack = definedExternally
    /**
     *   Is the title of this section header clipped by SectionHeader.controls
     *   or the edge of the header?
     * 
     */
    override fun titleClipped(): Boolean = definedExternally
    /**
     *   Returns the HTML that is displayed by the default SectionHeader.titleHover
     *   handler. Return null or an empty string to cancel the hover.
     * 
     * 
     *  @param {HTMLString} the HTML that would have been displayed by default
     */
    override fun titleHoverHTML(defaultHTML: String): String = definedExternally
    /**
     *   Optional stringMethod to fire when the user hovers over this section header and the title is
     *   clipped. If SectionHeader.showClippedTitleOnHover is true, the default behavior is to
     *   show a hover canvas containing the HTML returned by SectionHeader.titleHoverHTML.
     *   Return false to suppress this default behavior.
     * 
     */
    override fun titleHover(): Boolean = definedExternally
    companion object {
        /**
         *  Creates a new SectionHeader
         * 
         *  @param typeCheckedProperties {Partial<SectionHeader>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {SectionHeader} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): SectionHeader = definedExternally
    }
}