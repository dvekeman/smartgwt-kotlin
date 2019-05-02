@file:JsQualifier("isc")
package isc

/**
 *  Object specifying an item in a Menu. Each MenuItem can have a
 *   MenuItem.title, MenuItem.icon, MenuItem.keys, optional MenuItem.submenu and various other settings. Alternatively, a
 *   MenuItem can contain an arbitrary widget via MenuItem.embeddedComponent.
 * 
 *   MenuItems are specified as plain Object, usually with
 *   ObjectLiteral notation. For example:
 * 
 *   isc.Menu.create({
 *     items : [
 *       {title: "item1", click: "alert(1)"},
 *       {title: "item2"}
 *     ]
 *   });
 * 
 *   Do not use isc.MenuItem.create() - this is invalid.
 * 
 * 
 * 
 *   Alternatively, Menus support binding to a Menu.dataSource.
 * 
 *   As another option, here's a sample of a Menu in componentXML:
 * 
 *   &lt;Menu&gt;
 *    &lt;items&gt;
 *      &lt;MenuItem title="item1" click="alert(1)"/&gt;
 *      &lt;MenuItem title="item2"/&gt;
 *    &lt;/items&gt;
 *   &lt;/Menu&gt;
 * 
 */
open external class MenuItem : ListGridRecord {
    /**
     *  The text displayed for the menu item
     *  @type {HTMLString}
     *  @default null
     */
    open var title: String = definedExternally
    /**
     *  A reference to another menu, to display as a submenu when the mouse cursor hovers over
     *   this menu item.
     *  @type {Menu}
     *  @default null
     */
    open var submenu: Menu = definedExternally
    /**
     *  A MenuItem that has a submenu normally cannot be selected, instead clicking or hitting Enter
     *   while keyboard focus is on the item shows the submenu. Setting canSelectParent:true allows
     *   a menu item with a submenu to be selected directly.
     *  @type {boolean}
     *  @default null
     */
    open var canSelectParent: Boolean = definedExternally
    /**
     *  When set to true, this menu item shows a horizontal separator instead of
     *   the MenuItem.title text. Typically specified as the only property of a menu item,
     *   since the separator will not respond to mouse events.
     *  @type {boolean}
     *  @default false
     */
    override var isSeparator: Boolean = definedExternally
    /**
     *  Affects the visual style and interactivity of the menu item. If set to
     *   false, the menu item will not respond to mouse rollovers or clicks.
     * 
     *   If you need to set this state dynamically, use MenuItem.enableIf instead.
     *  @type {boolean}
     *  @default true
     */
    override var enabled: Boolean = definedExternally
    /**
     *  If true, this item displays a standard checkmark image to the left of its title. You
     *   can set the checkmark image URL by setting Menu.checkmarkImage.
     * 
     *   If you need to set this state dynamically, use MenuItem.checkIf instead.
     *  @type {boolean}
     *  @default null
     */
    open var checked: Boolean = definedExternally
    /**
     *  The filename for this item's custom icon when the item is disabled. If both this property
     *   and MenuItem.checked are both specified, only the icon specified by this property
     *   will be displayed. The path to the loaded skin directory and the skinImgDir are prepended
     *   to this filename to form the full URL.
     * 
     *   If you need to set this state dynamically, use MenuItem.dynamicIcon instead.
     *  @type {string}
     *  @default null
     */
    open var disabledIcon: String = definedExternally
    /**
     *  The filename for this item's custom icon. If both this property and
     *   MenuItem.checked are both specified, only the icon specified by this property will be
     *   displayed. The path to the loaded skin directory and the skinImgDir are prepended to
     *   this filename to form the full URL. If this item is disabled, and MenuItem.disabledIcon
     *   is set, then that icon will be used instead.
     * 
     *   If you need to set this state dynamically, use MenuItem.dynamicIcon instead.
     *  @type {string}
     *  @default null
     */
    open var icon: String = definedExternally
    /**
     *  The width applied to this item's icon. The default of 16 can be changed
     *   for all MenuItems by overriding Menu.iconWidth.
     *  @type {number}
     *  @default "16"
     */
    open var iconWidth: Number = definedExternally
    /**
     *  The height applied to this item's icon. The default of 16 can be changed
     *   for all MenuItems by overriding Menu.iconHeight.
     *  @type {number}
     *  @default "16"
     */
    open var iconHeight: Number = definedExternally
    /**
     *  Shortcut key(s) to fire the menu item action. Each key can be defined as a KeyIdentifier.
     *   To apply multiple shortcut keys to this item, set this property to an array of such key
     *   identifiers.
     *  @type {KeyIdentifier | Array<Partial<KeyIdentifier>>}
     *  @default null
     */
    open var keys: dynamic = definedExternally
    /**
     *  A string to display in the shortcut-key column for this item. If not
     *   specified, the first KeyName value in MenuItem.keys will be used by default.
     *  @type {string}
     *  @default "see below"
     */
    open var keyTitle: String = definedExternally
    /**
     *  If false, no submenus will be fetched for this MenuItem. This can be set globally via
     *   Menu.fetchSubmenus.
     *  @type {boolean}
     *  @default true
     */
    open var fetchSubmenus: Boolean = definedExternally
    /**
     *  Criteria to be evaluated to determine whether this MenuItem should be disabled. Re-evaluated
     *   each time the menu is shown.
     * 
     *   A basic criteria uses textMatchStyle:"exact". When specified in
     *   componentXML this property allows
     *   xmlCriteriaShorthand for defining criteria.
     *  @type {AdvancedCriteria}
     *  @default null
     */
    open var enableWhen: AdvancedCriteria = definedExternally
    /**
     *  Arbitrary UI component that should appear in this MenuItem. See
     *   ListGridRecord.embeddedComponent for an overview and options for controlling placement.
     * 
     *   When embeddedComponent is used in a MenuItem certain default behaviors apply:
     * 
     * 
     *  - MenuItem.autoDismiss defaults to false and clicks on embeddedComponents are
     *     not bubbled to the menuItem - if an interaction with an embeddedComponent is
     *     expected to dismiss the menu, custom code should call menu.hide or
     *     Menu.hideAllMenus as appropriate, before proceeding
     * 
     *  - the default behavior for MenuItem.embeddedComponentPosition is "expand".
     * 
     *  - the component is placed over the title and key fields by default
     *   - use MenuItem.embeddedComponentFields to override
     * 
     *  - rollOver styling is disabled by default (as though ListGridRecord.showRollOver were
     *   set to false)
     * 
     *  @type {Canvas}
     *  @default null
     */
    override var embeddedComponent: Canvas = definedExternally
    /**
     *  See ListGridRecord.embeddedComponentPosition, except that when used in a
     *   menuItem, default behavior is EmbeddedPosition "expand".
     *  @type {EmbeddedPosition}
     *  @default null
     */
    override var embeddedComponentPosition: 
                                            /**
                                             *  component should be placed underneath normal record or cell content,    expanding the records. Expanding records can result in variable height rows,
                                             *      in which case ListGrid.virtualScrolling should be
                                             *      enabled.
                                             *  component should be placed within the normal area of the record or cell.    Percentage sizes will be treated as percentages of the record and
                                             *      Canvas.snapTo positioning settings are also allowed and refer to the
                                             *      rectangle of the record or cell. Note that for components embedded within cells,
                                             *      cell align and vAlign will be used if snapTo is unset (so top / left alignment
                                             *      of cell content will map to snapTo of "TL", etc).
                                             */
                                            String /* expand |  within */ = definedExternally
    /**
     *  See ListGridRecord.embeddedComponentFields. Default for a MenuItem is to cover the
     *   title and key fields, leaving the icon and submenu fields visible.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    override var embeddedComponentFields: Array<dynamic> = definedExternally
    /**
     *  Whether a click on this specific menuItem automatically dismisses the menu. See
     *   Menu.autoDismiss.
     *  @type {boolean}
     *  @default null
     */
    open var autoDismiss: Boolean = definedExternally
    /**
     *  When used in an AdaptiveMenu, should this MenuItem show only it's
     *   MenuItem.icon when displayed inline?
     *  @type {boolean}
     *  @default null
     */
    open var showIconOnlyInline: Boolean = definedExternally
    /**
     *   Contains the condition that will enable or disable the current menuItem. The handler must be specified
     *   as a function or string of script. Return false to disable the menuItem or true to enable it
     * 
     *   If you don't need to set this state dynamically, use MenuItem.enabled instead.
     * 
     *   May be defined as a stringMethods.
     * 
     * 
     *  @param {Canvas} Menu.target attribute for the top level menu.
     *  @param {Menu} Menu contains the reference to the menu that contains the current item
     *  @param {MenuItem} contains the reference to the current item
     */
    open fun enableIf(target: Canvas, menu: Menu, item: MenuItem): Boolean = definedExternally
    /**
     *   Contains the condition that will check or uncheck the current menuItem. The handler must be specified
     *   as a function or string of script. Return false to uncheck the menuItem or true to check it
     * 
     *   If you don't need to set this state dynamically, use MenuItem.checked instead.
     * 
     *   May be defined as a stringMethods.
     * 
     * 
     *  @param {Canvas} Menu.target attribute for the top level menu.
     *  @param {Menu} Menu contains the reference to the menu that contains the current item
     *  @param {MenuItem} contains the reference to the current item
     */
    open fun checkIf(target: Canvas, menu: Menu, item: MenuItem): Boolean = definedExternally
    /**
     *   Contains the condition that will change the current items' title when met. The handler must be specified
     *   as a function or string of script.
     * 
     *   If you don't need to set this state dynamically, use MenuItem.title instead.
     * 
     *   May be defined as a stringMethods.
     * 
     * 
     *  @param {Canvas} Menu.target attribute for the top level menu.
     *  @param {Menu} Menu contains the reference to the menu that contains the current item
     *  @param {MenuItem} contains the reference to the current item
     */
    open fun dynamicTitle(target: Canvas, menu: Menu, item: MenuItem): String = definedExternally
    /**
     *   Contains the condition that will change the current items' icon when met. The handler must be specified
     *   as a function or string of script.
     * 
     *   If you don't need to set this state dynamically, use MenuItem.icon instead.
     * 
     *   May be defined as a stringMethods.
     * 
     * 
     *  @param {Canvas} Menu.target attribute for the top level menu.
     *  @param {Menu} Menu contains the reference to the menu that contains the current item
     *  @param {MenuItem} contains the reference to the current item
     */
    open fun dynamicIcon(target: Canvas, menu: Menu, item: MenuItem): String = definedExternally
    /**
     *   Executed when this menu item is clicked by the user. The click handler must be specified
     *   as a function or string of script. Return false to suppress the Menu.itemClick
     *   handler if specified.
     * 
     * 
     *  @param {Canvas} for a menu shown as a context menu, the Canvas the menu was shown            on. Otherwise the Menu instance of which this             MenuItem is a member.
     *  @param {MenuItem} The MenuItem that was clicked on.
     *  @param {Menu} The Menu instance of which this MenuItem is a             member.
     *  @param {number=} Index of the column the user clicked. May be null if the             user activated the menu via a keyboard event.
     */
    open fun click(target: Canvas, item: MenuItem, menu: Menu, colNum: Number?): Unit = definedExternally
    /**
     *   Action to fire when this menu is activated.
     * 
     */
    open fun action(): Unit = definedExternally
}