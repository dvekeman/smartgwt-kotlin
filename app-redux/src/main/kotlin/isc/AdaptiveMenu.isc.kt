@file:JsQualifier("isc")
package isc

/**
 *  A menu that can either show its menu options inline, or show them via a drop-down,
 *   depending on available space in the surrounding Layout or ToolStrip.
 * 
 *   See Canvas.canAdaptWidth for background on adaptive layout.
 */
open external class AdaptiveMenu : Layout {
    /**
     *  Whether the AdaptiveMenu should show some menu items inline as soon as there is enough space,
     *   or should strictly switch between showing
     *  @type {boolean}
     *  @default true
     */
    open var partialInlining: Boolean = definedExternally
    /**
     *  Placement of inlined items relative to the main MenuButton. Default is to place items
     *   above the menu if the parent is a Layout with Layout.orientation,
     *   otherwise to the left of the menuButton (or right if the Page.isRTL.
     * 
     *   A setting of "center" is invalid and will cause a warning and be ignored
     *  @type {Alignment | VerticalAlignment}
     *  @default null
     */
    open var inlinePlacement: dynamic = definedExternally
    /**
     *  Default setting for MenuItem.showIconOnlyInline. Individual items can set
     *   showIconOnlyInline to override this setting.
     *  @type {boolean}
     *  @default false
     */
    open var showIconOnlyInline: Boolean = definedExternally
    /**
     *  MenuItems to be show either inline or as a drop-down Menu.
     * 
     *   When shown inline, items are rendered as different AutoChild according to the
     *   settings on the MenuItem:
     * 
     * 
     *  - normal MenuItems render as the AdaptiveMenu.inlineMenuItem, a ToolStripButton AutoChild
     * 
     *  - MenuItems that have submenus render as the AdaptiveMenu.inlineSubmenuItem, a
     *     MenuButton AutoChild
     * 
     *  - MenuItems with MenuItem.showIconOnlyInline set render as the
     *     AdaptiveMenu.inlineImgButton, a ToolStripButton AutoChild
     * 
     *  - MenuItems where MenuItem.embeddedComponent has been specified will have the
     *     embedded component displayed directly instead (no AutoChild involvement here). If the
     *     control should have different appearance when inlined vs embedded in the menu, one way
     *     to achieve this is to detect whether the parent is a Menu when it is drawn.
     * 
     *  @type {Array<Partial<MenuItem>>}
     *  @default null
     */
    open var items: Array<dynamic> = definedExternally
    /**
     *  Instance of the normal (non-Adaptive) Menu class used to show items that do not fit inline.
     *  @type {Menu}
     *  @default null
     */
    open var menu: Menu = definedExternally
    /**
     *  MenuButton used as a drop-down control for showing any items of the menu that are not
     *   displayed inline.
     *  @type {MenuButton}
     *  @default null
     */
    open var menuButton: MenuButton = definedExternally
    /**
     *  Title used for the MenuButton.
     *  @type {HTMLString}
     *  @default null
     */
    open var menuButtonTitle: String = definedExternally
    /**
     *  Icon used for the MenuButton. Default of null means to use the default for the
     *   MenuButton class.
     *  @type {SCImgURL}
     *  @default null
     */
    open var menuButtonIcon: String = definedExternally
    /**
     *  MultiAutoChild used to create inline menu items.
     * 
     *   The MenuItem.icon and MenuItem.title will be rendered via Button.icon and
     *   Button.title respectively; other MenuItem appearance-related properties do not
     *   apply.
     *  @type {ToolStripButton}
     *  @default null
     */
    open var inlineMenuItem: ToolStripButton = definedExternally
    /**
     *  MultiAutoChild used to create inline menu items for menu items that have a submenu.
     * 
     *   The MenuItem.icon and MenuItem.title will be rendered via
     *   IconButton.icon and Button.title respectively; other MenuItem
     *   appearance-related properties do not apply.
     *  @type {IconMenuButton}
     *  @default null
     */
    open var inlineSubmenuItem: IconMenuButton = definedExternally
    /**
     *  Whether ToolStripSeparator should be shown for inline menu items.
     *   True by default for horizontal Layout.orientation, false for vertical.
     *  @type {boolean}
     *  @default null
     */
    open var showInlineSeparators: Boolean = definedExternally
    /**
     *  ToolStripButton to display when AdaptiveMenu.showIconOnlyInline is set for one MenuItem
     *  @type {ImgButton}
     *  @default null
     */
    open var inlineImgButton: ImgButton = definedExternally
    /**
     * 
     * 
     *  @param {Array<Partial<MenuItem>> | MenuItem} array of menuItems to replace current menuItems
     */
    open fun setItems(items: dynamic): Unit = definedExternally
    /**
     * 
     * 
     * \* @param {boolean} 
     */
    open fun setPartialInlining(partialInlining: Boolean): Unit = definedExternally
    companion object {
        /**
         *  Creates a new AdaptiveMenu
         * 
         *  @param typeCheckedProperties {Partial<AdaptiveMenu>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {AdaptiveMenu} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): AdaptiveMenu = definedExternally
    }
}