@file:JsQualifier("isc")
package isc

/**
 *  A subclass of IconButton that shows a menuIcon by default and implements showMenu().
 * 
 *   This class has IconButton.showMenuIcon set to true by default,
 *   and has a IconButton.menuIconClick handler which will show the specified
 *   IconMenuButton.menu via a call to IconMenuButton.showMenu.
 *   This menuIconClick handler cancels default click behavior, so, if a user clicks the menu
 *   item, any specified Canvas.click for the button as a whole will not fire.
 */
open external class IconMenuButton : IconButton {
    /**
     *  The menu to show when the IconButton.menuIconSrc is clicked.
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
     *   Shows this button's IconMenuButton.menu. Called automatically when a user clicks the
     *   IconButton.menuIconSrc.
     * 
     * 
     */
    open fun showMenu(): Boolean = definedExternally
    companion object {
        /**
         *  Creates a new IconMenuButton
         * 
         *  @param typeCheckedProperties {Partial<IconMenuButton>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {IconMenuButton} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): IconMenuButton = definedExternally
    }
}