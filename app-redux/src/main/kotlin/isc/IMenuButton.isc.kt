@file:JsQualifier("isc")
package isc

/**
 *  IMenuButton based version of the MenuButton class.
 */
open external class IMenuButton : MenuButton {
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
     *  Show menu button image (up / down arrowhead) for this menu button.
     *  @type {boolean}
     *  @default true
     */
    override var showMenuButtonImage: Boolean = definedExternally
    /**
     *  Image for menu button indicating that the button expands a menu. This image is shown
     *   for menus expanding down from the button.  Menu direction is controlled by
     *   MenuButton.showMenuBelow.
     *  @type {SCImgURL}
     *  @default "[SKIN]menu_button.gif"
     */
    override var menuButtonImage: String = definedExternally
    /**
     *  Image for menu button indicating that the button expands a menu. This image is shown
     *   for menus expanding up from the button.  Menu direction is controlled by
     *   MenuButton.showMenuBelow.
     *  @type {SCImgURL}
     *  @default "[SKIN]menu_button_up.gif"
     */
    override var menuButtonImageUp: String = definedExternally
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
    override var showMenuBelow: Boolean = definedExternally
    /**
     *  The horizontal alignment of this button's menu, in relation to the button. When unset,
     *   default behavior is to align the right edges of button and menu if the page is in RTL
     *   mode, and the left edges otherwise.
     *  @type {Alignment}
     *  @default null
     */
    override var menuAlign: 
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
    override var menu: Menu = definedExternally
    /**
     *  Allows you to specify an animation effect to apply to the menu when it is being shown.
     *   Valid options are "none" (no animation), "fade", "slide" and "wipe".
     *   If unspecified falls through to menu.showAnimationEffect
     *  @type {string}
     *  @default null
     */
    override var menuAnimationEffect: String = definedExternally
    /**
     *  If this menuButton is Canvas.destroy, should it also destroy
     *   its MenuButton.menu?
     *  @type {boolean}
     *  @default true
     */
    override var autoDestroyMenu: Boolean = definedExternally
    /**
     *   Setter for the 'showMenuButtonImage' property - shows/hides the menu button image
     *   at runtime.
     * 
     * 
     *  @param {boolean} Should the image be shown
     */
    override fun setShowMenuButtonImage(show: Boolean): Unit = definedExternally
    /**
     *   Setter for the 'showMenuButtonBelow' property - determines whether the menu will be
     *   shown above or below the menubutton.
     * 
     *  @param {boolean} True if the menu should be shown below the menubutton.
     */
    override fun setShowMenuBelow(below: Boolean): Unit = definedExternally
    companion object {
        /**
         *  Creates a new IMenuButton
         * 
         *  @param typeCheckedProperties {Partial<IMenuButton>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {IMenuButton} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): IMenuButton = definedExternally
    }
}