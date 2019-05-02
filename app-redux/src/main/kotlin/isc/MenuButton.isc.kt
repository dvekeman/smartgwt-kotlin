@file:JsQualifier("isc")
package isc

/**
 *  Simple subclass of button associated with a menu widget (gets shown below the button).
 */
open external class MenuButton : Button {
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "MenuEditEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
    /**
     *  Default title for the button.
     *  @type {string}
     *  @default "Show Menu"
     */
    override var title: String = definedExternally
    /**
     *  Default height of the button.
     *  @type {number | string}
     *  @default "22"
     */
    override var height: dynamic = definedExternally
    /**
     *  This property corresponds to the inherited Button.icon property,
     *   which is used to display the menuButtonImage, so anything you attempt
     *   to set there would be clobbered by the internal usage.
     * 
     *   You could add an icon via the MenuButton.title property,
     *   by using Canvas.imgHTML to generate an appropriate
     *   &lt;img&gt; tag and pre-pending it to your title.
     *  @type {SCImgURL}
     *  @default null
     */
    override var icon: String = definedExternally
    /**
     *  Show menu button image (up / down arrowhead) for this menu button.
     *  @type {boolean}
     *  @default true
     */
    open var showMenuButtonImage: Boolean = definedExternally
    /**
     *  Image for menu button indicating that the button expands a menu. This image is shown
     *   for menus expanding down from the button.  Menu direction is controlled by
     *   MenuButton.showMenuBelow.
     *  @type {SCImgURL}
     *  @default "[SKIN]menu_button.gif"
     */
    open var menuButtonImage: String = definedExternally
    /**
     *  Image for menu button indicating that the button expands a menu. This image is shown
     *   for menus expanding up from the button.  Menu direction is controlled by
     *   MenuButton.showMenuBelow.
     *  @type {SCImgURL}
     *  @default "[SKIN]menu_button_up.gif"
     */
    open var menuButtonImageUp: String = definedExternally
    /**
     *  If this MenuButton has a specified Canvas.accessKey, underline it
     *   in the title of the button by default
     *  @type {boolean}
     *  @default true
     */
    override var hiliteAccessKey: Boolean = definedExternally
    /**
     *  The menu drops down below the menu button.
     *     Set to false if the menu should appear above the menu button.
     *  @type {boolean}
     *  @default true
     */
    open var showMenuBelow: Boolean = definedExternally
    /**
     *  The horizontal alignment of this button's menu, in relation to the button. When unset,
     *   default behavior is to align the right edges of button and menu if the page is in RTL
     *   mode, and the left edges otherwise.
     *  @type {Alignment}
     *  @default null
     */
    open var menuAlign: 
                        /**
                         *  Center within container.
                         *  Stick to left side of container.
                         *  Stick to right side of container.
                         */
                        String /* center |  left |  right */ = definedExternally
    /**
     *  The menu to show.
     * 
     *   For a menu button with no menu (menu: null) the up/down arrow image can
     *   be suppressed by setting
     *   MenuButton.showMenuButtonImage: false.
     *  @type {Menu}
     *  @default null
     */
    open var menu: Menu = definedExternally
    /**
     *  Allows you to specify an animation effect to apply to the menu when it is being shown.
     *   Valid options are "none" (no animation), "fade", "slide" and "wipe".
     *   If unspecified falls through to menu.showAnimationEffect
     *  @type {string}
     *  @default null
     */
    open var menuAnimationEffect: String = definedExternally
    /**
     *  If this menuButton is Canvas.destroy, should it also destroy
     *   its MenuButton.menu?
     *  @type {boolean}
     *  @default true
     */
    open var autoDestroyMenu: Boolean = definedExternally
    /**
     *  Should the menu be shown automatically when the mouse moves over the button?
     * 
     *   When enabled, menus used with this MenuButton should not be used with any
     *   other component.
     *  @type {boolean}
     *  @default false
     */
    open var showMenuOnRollOver: Boolean = definedExternally
    /**
     *  When MenuButton.showMenuOnRollOver is true, this is the delay
     *   in milliseconds before the menu is automatically hidden following mouseOut.
     *  @type {number}
     *  @default "250"
     */
    open var rollOverMenuHideDelay: Number = definedExternally
    /**
     *   Setter for the 'showMenuButtonImage' property - shows/hides the menu button image
     *   at runtime.
     * 
     * 
     *  @param {boolean} Should the image be shown
     */
    open fun setShowMenuButtonImage(show: Boolean): Unit = definedExternally
    /**
     *   Setter for the 'showMenuButtonBelow' property - determines whether the menu will be
     *   shown above or below the menubutton.
     * 
     *  @param {boolean} True if the menu should be shown below the menubutton.
     */
    open fun setShowMenuBelow(below: Boolean): Unit = definedExternally
    /**
     *   Programmaticly forces this MenuButton to show it's menu.
     * 
     */
    open fun showMenu(): Unit = definedExternally
    companion object {
        /**
         *  Creates a new MenuButton
         * 
         *  @param typeCheckedProperties {Partial<MenuButton>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {MenuButton} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): MenuButton = definedExternally
    }
}