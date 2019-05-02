@file:JsQualifier("isc")
package isc

/**
 *  A Button subclass that displays an IconButton.icon,
 *   IconButton.showButtonTitle and optional IconButton.menuIconSrc
 *   and is capable of horizontal and vertical IconButton.orientation.
 */
open external class IconButton : Button {
    /**
     *  The orientation of this IconButton. The default value, "horizontal", renders
     *   IconButton.icon, IconButton.showButtonTitle and potentially
     *   IconButton.menuIconSrc, from left to right: "vertical" does the same from
     *   top to bottom.
     *  @type {string}
     *  @default "horizontal"
     */
    open var orientation: String = definedExternally
    /**
     *  When used in a RibbonBar, the number of rows this button should occupy in a
     *   single ToolStripGroup.columnLayout.
     *  @type {number}
     *  @default "1"
     */
    open var rowSpan: Number = definedExternally
    /**
     *  Default CSS class for this button.
     *  @type {CSSStyleName}
     *  @default "iconButton"
     */
    override var baseStyle: String = definedExternally
    /**
     *  Whether to show the IconButton.menuIconSrc which fires the IconButton.menuIconClick
     *   notification method when clicked.
     *  @type {boolean}
     *  @default false
     */
    open var showMenuIcon: Boolean = definedExternally
    /**
     *  Base URL for an Image that shows a Menu when clicked. See also
     *   IconButton.showMenuIconDisabled and IconButton.showMenuIconOver.
     *  @type {SCImgURL}
     *  @default "[SKINIMG]/Menu/submenu_down.png"
     */
    open var menuIconSrc: String = definedExternally
    /**
     *  The width of the icon for this button.
     *  @type {number}
     *  @default "14"
     */
    open var menuIconWidth: Number = definedExternally
    /**
     *  The height of the icon for this button.
     *  @type {number}
     *  @default "13"
     */
    open var menuIconHeight: Number = definedExternally
    /**
     *  This attribute is not supported in this subclass. However, RTL mode is still supported.
     *  @type {string}
     *  @default null
     */
    override var iconOrientation: String = definedExternally
    /**
     *  This attribute is not supported in this subclass. However, RTL mode is still supported.
     *  @type {string}
     *  @default null
     */
    override var iconAlign: String = definedExternally
    /**
     *  Horizontal alignment of this button's content. If unset,
     *   IconButton.orientation are center-aligned and horizontal
     *   buttons left-aligned by default.
     *  @type {Alignment}
     *  @default null
     */
    override var align: 
                        /**
                         *  Center within container.
                         *  Stick to left side of container.
                         *  Stick to right side of container.
                         */
                        String /* center |  left |  right */ = definedExternally
    /**
     *  Vertical alignment of this button's content. If unset,
     *   IconButton.orientation are top-aligned and horizontal
     *   buttons center-aligned by default.
     *  @type {VerticalAlignment}
     *  @default null
     */
    override var valign: 
                         /**
                          *  At the top of the container
                          *  Center within container.
                          *  At the bottom of the container
                          */
                         String /* top |  center |  bottom */ = definedExternally
    /**
     *  showTitle is not applicable to this class - use IconButton.showButtonTitle
     *   instead.
     *  @type {boolean}
     *  @default null
     */
    open var showTitle: Boolean = definedExternally
    /**
     *  Whether to show the title-text for this IconButton. If set to false, title-text is omitted
     *   altogether and just the icon is displayed.
     *  @type {boolean}
     *  @default true
     */
    open var showButtonTitle: Boolean = definedExternally
    /**
     *  Whether to show an Icon in this IconButton. Set to false to render a text-only button.
     *  @type {boolean}
     *  @default null
     */
    open var showIcon: Boolean = definedExternally
    /**
     *  Icon to show to the left of or above the title, according to the button's Orientation.
     * 
     *   When specifying titleOrientation = "vertical", this icon will be stretched to
     *   the IconButton.largeIconSize unless a IconButton.largeIcon is specified.
     *  @type {SCImgURL}
     *  @default null
     */
    override var icon: String = definedExternally
    /**
     *  The size of the normal icon for this button.
     *  @type {number}
     *  @default "16"
     */
    override var iconSize: Number = definedExternally
    /**
     *  Icon to show above the title when Orientation is "vertical".
     * 
     *   If a largeIcon is not specified, the IconButton.icon will be stretched to
     *   the IconButton.largeIconSize.
     *  @type {SCImgURL}
     *  @default null
     */
    open var largeIcon: String = definedExternally
    /**
     *  The size of the large icon for this button. If IconButton.largeIcon is not specified, the
     *   IconButton.icon will be stretched to this size.
     *  @type {number}
     *  @default "32"
     */
    open var largeIconSize: Number = definedExternally
    /**
     *  If set to true, shows this button's Menu when a user clicks anywhere
     *   in the button, rather than specifically on the IconButton.menuIconSrc.
     *  @type {boolean}
     *  @default null
     */
    open var showMenuOnClick: Boolean = definedExternally
    /**
     *  Whether to show an Over version of the IconButton.menuIconSrc.
     *  @type {boolean}
     *  @default true
     */
    open var showMenuIconOver: Boolean = definedExternally
    /**
     *  Whether to show a Disabled version of the IconButton.menuIconSrc.
     *  @type {boolean}
     *  @default true
     */
    open var showMenuIconDisabled: Boolean = definedExternally
    /**
     *   Sets a new Icon for this button after initialization.
     * 
     * 
     */
    open fun setIcon(): Unit = definedExternally
    /**
     *   Sets a new Large-Icon for vertical buttons after initialization - synonymous with
     *   IconButton.setIcon for normal horizontal buttons.
     * 
     * 
     */
    open fun setLargeIcon(): Unit = definedExternally
    /**
     *   Notification method fired when a user clicks on the menuIcon on this IconButton.
     *   Return false to suppress the standard click handling code.
     * 
     * 
     * 
     */
    open fun menuIconClick(): Boolean = definedExternally
    /**
     *   Notification method fired when a user clicks on the IconButton.icon in this
     *   IconButton.
     *   Return false to suppress the standard click handling code.
     * 
     * 
     * 
     */
    override fun iconClick(): Boolean = definedExternally
    /**
     *   Notification method fired when a user clicks anywhere on this button. If the click occurred
     *   directly on the Button.icon or the IconButton.menuIconSrc,
     *   the related notifications IconButton.iconClick and
     *   IconButton.menuIconClick are fired first and must return false to
     *   prevent this notification from firing.
     * 
     *   If a Menu is installed then, by default, it is only displayed when a
     *   user clicks on the IconButton.menuIconSrc. This can be altered via
     *   IconButton.showMenuOnClick.
     * 
     * 
     */
    override fun click(): Boolean = definedExternally
    companion object {
        /**
         *  Creates a new IconButton
         * 
         *  @param typeCheckedProperties {Partial<IconButton>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {IconButton} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): IconButton = definedExternally
    }
}