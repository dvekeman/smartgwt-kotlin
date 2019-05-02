@file:JsQualifier("isc")
package isc

/**
 *  A MenuBar is a bar of buttons used to show a set of menus.
 */
open external class MenuBar : Toolbar {
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "MenuEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
    /**
     *  An array of menu object initializers or instantiated menu objects. Buttons for each
     *   menu item will automatically be created. See the Menu Widget Class for fundamental
     *   menu properties and other properties. Titles for the buttons are derived from the
     *   title property of each menu.
     *  @type {Array<Partial<Menu>>}
     *  @default null
     */
    open var menus: Array<dynamic> = definedExternally
    /**
     *  By default exclude menubars from the page's tab order. To include a menubar in the page's
     *   tab order, set tabIndex to an explicit tab index, or null for automatically
     *   assigned tabIndex
     *  @type {number}
     *  @default "-1"
     */
    override var tabIndex: Number = definedExternally
    /**
     *   Invalid to call on Menubar, use MenuBar.setMenus instead.
     * 
     *  @param {Array<Partial<Button>>=} invalid; do not call
     */
    override fun setButtons(newButtons: Array<dynamic>?): Unit = definedExternally
    /**
     *   Dynamically reset the set of menus displayed by this menu bar.
     * 
     *  @param {Array<Partial<Menu>>} array of new menus for this menubar
     */
    open fun setMenus(menus: Array<dynamic>): Unit = definedExternally
    /**
     *   Dynamically update the menuBar to include additional menus. Will update the visible set
     *   of buttons as appropriate
     * 
     *  @param {Array<any>} Array of new menus to add
     *  @param {number} desired starting position of the new menus in the existing menus  array
     */
    open fun addMenus(newMenus: Array<dynamic>, position: Number): Unit = definedExternally
    /**
     *   Dynamically remove menus from the menuBar. Will update the visible set of buttons as
     *   appropriate.
     * 
     *  @param {Array<any>} Array of menus to remove (will accept actual Menu components,            or numbers representing the index of the menus in the current menus array)
     */
    open fun removeMenus(menus: Array<dynamic>): Unit = definedExternally
    /**
     *   Shows (opens) a menu.
     * 
     *  @param {Menu | Integer} menu to show (may be specified as a menu object, or index of                  the menu from MenuBar.menus).
     */
    open fun showMenu(menu: dynamic): Unit = definedExternally
    companion object {
        /**
         *  Creates a new MenuBar
         * 
         *  @param typeCheckedProperties {Partial<MenuBar>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {MenuBar} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): MenuBar = definedExternally
    }
}