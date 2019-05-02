@file:JsQualifier("isc")
package isc

/**
 *  The Menu widget class implements interactive menu widgets, with optional icons, submenus,
 *   and shortcut keys.
 * 
 *   A Menu is initialized with a set of MenuItems specified as Menu.items, each
 *   of which represents one row in the menu's display and specifies the action to take when that
 *   menu item is selected.
 * 
 *   Each MenuItem can have a MenuItem.title,
 *   MenuItem.icon, MenuItem.keys, optional
 *   MenuItem.submenu and various other settings. Alternatively, a MenuItem
 *   can contain an arbitrary widget via MenuItem.embeddedComponent.
 * 
 *   To create a context menu for a component, provide a Menu instance for the
 *   Canvas.contextMenu property. Note that some components like ListGrid have
 *   more specific properties because they have distinct regions or because they have a default
 *   set of context menu actions available (for example: ListGrid.headerContextMenu and
 *   related APIs).
 * 
 *   If you want a button that pops up a menu when clicked, or a bar of such buttons, see the
 *   MenuButton and MenuBar classes.
 * 
 *   To create a pop-up panel interface that looks nothing like a Menu (but still
 *   dismisses automatically on an outside click), use Canvas.showClickMask to arrange
 *   for automatic dismissal, and the Canvas.showNextTo utility method to place the
 *   component near whatever triggered it, while automatically staying on-screen.
 */
open external class Menu : ListGrid {
    /**
     *  Custom properties for the automatically generated icon column.
     * 
     *   See Menu.showIcons for an overview of the icon column.
     *  @type {ListGridField}
     *  @default null
     */
    open var iconFieldProperties: ListGridField = definedExternally
    /**
     *  Default properties for the automatically generated icon column.
     *   Default object includes properties to set width and to show icon for this column.
     * 
     *   To modify the behavior or appearance of this column, developers may set
     *   Menu.iconFieldProperties at the instance level, or override this
     *   object at the class level. If overriding this object, we recommend using
     *   Class.changeDefaults rather than replacing this object entirely.
     * 
     *   See Menu.showIcons for an overview of the icon column.
     *  @type {ListGridField}
     *  @default "object"
     */
    open var iconFieldDefaults: ListGridField = definedExternally
    /**
     *  Custom properties for the automatically generated title column.
     *  @type {ListGridField}
     *  @default null
     */
    open var titleFieldProperties: ListGridField = definedExternally
    /**
     *  Default properties for the automatically generated title column.
     *   Default object includes properties to set width and to show title for this column.
     * 
     *   To modify the behavior or appearance of this column, developers may set
     *   Menu.titleFieldProperties at the instance level, or override this
     *   object at the class level. If overriding this object, we recommend using
     *   Class.changeDefaults rather than replacing this object entirely.
     *  @type {ListGridField}
     *  @default "object"
     */
    open var titleFieldDefaults: ListGridField = definedExternally
    /**
     *  Custom properties for the automatically generated key column.
     * 
     *   See Menu.showKeys for an overview of the key column.
     *  @type {ListGridField}
     *  @default null
     */
    open var keyFieldProperties: ListGridField = definedExternally
    /**
     *  Default properties for the automatically generated key column.
     *   Default object includes properties to set width and to show key for this column.
     * 
     *   To modify the behavior or appearance of this column, developers may set
     *   Menu.keyFieldProperties at the instance level, or override this
     *   object at the class level. If overriding this object, we recommend using
     *   Class.changeDefaults rather than replacing this object entirely.
     * 
     *   See Menu.showKeys for an overview of the key column.
     *  @type {ListGridField}
     *  @default "object"
     */
    open var keyFieldDefaults: ListGridField = definedExternally
    /**
     *  Custom properties for the automatically generated submenu column.
     * 
     *   See Menu.showSubmenus for an overview of the submenu column.
     *  @type {ListGridField}
     *  @default null
     */
    open var submenuFieldProperties: ListGridField = definedExternally
    /**
     *  Default properties for the automatically generated submenu column.
     *   Default object includes properties to set width, align and to show submenu icon for this
     *   column.
     * 
     *   To modify the behavior or appearance of this column, developers may set
     *   Menu.submenuFieldProperties at the instance level, or override this
     *   object at the class level. If overriding this object, we recommend using
     *   Class.changeDefaults rather than replacing this object entirely.
     * 
     *   See Menu.showSubmenus for an overview of the submenu column.
     *  @type {ListGridField}
     *  @default "object"
     */
    open var submenuFieldDefaults: ListGridField = definedExternally
    /**
     *  An array of menuItem objects, specifying the menu items this menu should show.
     * 
     *   Data may also be set to a Tree in which case a hierarchy of menus and
     *   submenus will automatically be generated to match the tree structure. See also
     *   Menu.dataSource for dynamically fetching menuItems and submenus from a
     *   hierarchical DataSource.
     *  @type {Array<Partial<MenuItem>> | Array<Partial<Record>> | Tree | any}
     *  @default null
     */
    override var data: dynamic = definedExternally
    /**
     *  Synonym for Menu.data
     *  @type {Array<Partial<MenuItem>>}
     *  @default null
     */
    open var items: Array<dynamic> = definedExternally
    /**
     *  Optional DataSource to fetch menuItems and submenus from, instead of using Menu.items.
     * 
     *   Data is tree-based in menus, so the provided DataSource should be set up for hierarchical
     *   fetching - see the treeDataBinding.
     * 
     *   Note that, although Menu is a subclass of ListGrid, some APIs, like
     *   ListGrid.setCriteria and ListGrid.autoFetchData
     *   are not supported in menus. If a dataSource is supplied, it is automatically fetched
     *   against as required, without the need for autoFetchData. To apply criteria to the
     *   fetches made in this way, see Menu.initialCriteria.
     *   Moreover, fetchData() is also an example of a ListGrid API that doesn't apply to menu, and, as
     *   was done for setCriteria() and other APIs like setCriteria().
     *  @type {DataSource}
     *  @default null
     */
    override var dataSource: dynamic = definedExternally
    /**
     *  Criteria to be used when fetching items for this Menu. Note that
     *   ListGrid.setCriteria is not supported in Menus.
     *  @type {Criteria}
     *  @default null
     */
    override var initialCriteria: dynamic = definedExternally
    /**
     *  This DataBoundComponent attribute is non-functional in Menus, where fetches are always
     *   automatic.
     *  @type {boolean}
     *  @default false
     */
    override var autoFetchData: Boolean = definedExternally
    /**
     *  For a Menu that uses a DataSource, these properties will be passed to
     *   the automatically-created ResultTree. This can be used for various customizations such as
     *   modifying the automatically-chosen Tree.parentIdField.
     *  @type {Tree}
     *  @default null
     */
    override var dataProperties: ResultSet = definedExternally
    /**
     *  Optional target canvas for this menu. Available as a parameter to dynamic menuItem configuration
     *   methods such as MenuItem.checkIf.
     * 
     *   Whenever a Menu is shown as a contextMenu by a widget due to Canvas.contextMenu
     *   being set, menu.target is automatically set to the widget that showed the
     *   contextMenu.
     * 
     *   If this item has any MenuItem.submenu the target will be propagated down
     *   to these child menus.
     *  @type {Canvas}
     *  @default null
     */
    open var target: Canvas = definedExternally
    /**
     *  Array of columns to show for this menu.
     *   Standard menu fields may be included by specifying MenuFieldID
     *   directly. Additional custom fields may be specified as ListGridField objects.
     *   If this property is unset, default behavior will show the
     *   MenuFieldID, with the exception of any that have
     *   been suppressed via Menu.showIcons, Menu.showKeys and Menu.showSubmenus
     *  @type {Array<Partial<MenuFieldID>> | Array<Partial<ListGridField>>}
     *  @default null
     */
    override var fields: Array<dynamic> = definedExternally
    /**
     *  CSS style used for the body of this menu when there is no icon field. When there is an
     *   icon field, then Menu.iconBodyStyleName, if set, will override this setting.
     * 
     *   If applying a background-color to the body via a CSS style applied using this property,
     *   be sure to set ListGrid.bodyBackgroundColor to null.
     *  @type {CSSStyleName}
     *  @default "normal"
     */
    override var bodyStyleName: String = definedExternally
    /**
     *  If set, the CSS style used for the body of this menu when there is an icon field.
     *   In RTL mode, the iconBodyStyleName is suffixed with "RTL", which allows skins
     *   to apply different styles in LTR and RTL modes.
     * 
     *   Note: Any skin which uses iconBodyStyleName should add "RTL" styles as well,
     *   even if identical to LTR styles. Otherwise, menus may lose their styling in RTL mode.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var iconBodyStyleName: String = definedExternally
    /**
     *  The default menu width.
     *  @type {Integer}
     *  @default "150"
     */
    override var defaultWidth: Number = definedExternally
    /**
     *  The height of each item in the menu, in pixels.
     *  @type {number}
     *  @default "20"
     */
    override var cellHeight: Number = definedExternally
    /**
     *  Menus will not draw on initialization, until they're explicitly show()n
     *  @type {boolean}
     *  @default false
     */
    override var autoDraw: Boolean = definedExternally
    /**
     *  CSS style for a normal cell
     *  @type {CSSStyleName}
     *  @default "menu"
     */
    override var baseStyle: String = definedExternally
    /**
     *  Explicitly disable alternateRecordStyles at the menu level by default so setting
     *   to true for all ListGrids will not impact menus' appearance.
     *  @type {boolean}
     *  @default false
     */
    override var alternateRecordStyles: Boolean = definedExternally
    /**
     *  A boolean indicating whether this menu should use shortcut keys. Set useKeys to
     *   false in a menu's initialization block to explicitly disable shortcut keys.
     *  @type {boolean}
     *  @default true
     */
    open var useKeys: Boolean = definedExternally
    /**
     *  A boolean, indicating whether the shortcut key column should be displayed. If
     *   showKeys is not set, the menu will show the key column only if one of its items
     *   specifies a keys property. If showKeys is false, the keys will not be displayed,
     *   but will still function.
     *  @type {boolean}
     *  @default true
     */
    open var showKeys: Boolean = definedExternally
    /**
     *  A boolean, indicating whether the checkmark/custom icon column should be displayed.
     *  @type {boolean}
     *  @default true
     */
    open var showIcons: Boolean = definedExternally
    /**
     *  A boolean, indicating whether the submenu indicator column should be displayed. If
     *   showSubmenus is not set, the menu will show the indicator column only if one of its
     *   items specifies a submenu property. If showSubmenus is false, the submenu arrows
     *   will not be displayed, but submenus will still appear on rollover.
     *  @type {boolean}
     *  @default true
     */
    open var showSubmenus: Boolean = definedExternally
    /**
     *  Should submenus show up on our left or right. Can validly be set to "left"
     *   or "right". If unset, submenus show up on the right by default in
     *   Left-to-right text mode, or on the left in Right-to-left text mode (see Page.isRTL).
     *  @type {string}
     *  @default null
     */
    open var submenuDirection: String = definedExternally
    /**
     *  Message to show when a menu is shown with no items.
     *  @type {HTMLString}
     *  @default "[Empty menu]"
     */
    override var emptyMessage: String = definedExternally
    /**
     *  The default width applied to custom icons in this menu. This is used whenever
     *       item.iconWidth is not specified.
     *  @type {number}
     *  @default "16"
     */
    open var iconWidth: Number = definedExternally
    /**
     *  The default height applied to custom icons in this menu. This is used whenever
     *       item.iconHeight is not specified.
     *  @type {number}
     *  @default "16"
     */
    open var iconHeight: Number = definedExternally
    /**
     *  When this menu is shown how should it animate into view? By default the menu will just
     *   show at the specified size/position. Options for animated show effects are "fade"
     *   to fade from transparent to visible, "slide" to slide the menu into view,
     *   or "wipe" to have the menu grow into view, revealing its content as it
     *   grows. Can be overridden by passing the 'animationEffect' parameter to 'menu.show()'
     *  @type {string}
     *  @default null
     */
    open var showAnimationEffect: String = definedExternally
    /**
     *  Default image to use for the submenu indicator. Valid src, width and height must be
     *   specified. See ImgProperties for format.
     *   If Menu.submenuDirection is set to "left", the image src will have
     *   the suffix "_left" appended to it.
     *  @type {Img}
     *  @default "{...}"
     */
    open var submenuImage: Img = definedExternally
    /**
     *  Default image to use for the submenu indicator when item is disabled. Valid src, width and
     *   height must be specified. See ImgProperties for format.
     *   If Menu.submenuDirection is set to "left", the image src will have
     *   the suffix "_left" appended to it.
     *  @type {Img}
     *  @default "{...}"
     */
    open var submenuDisabledImage: Img = definedExternally
    /**
     *  Default image to display for checkmarked items. See ImgProperties for format.
     *   Valid src, width and height must be specified.
     *  @type {Img}
     *  @default "{...}"
     */
    open var checkmarkImage: Img = definedExternally
    /**
     *  Default image to display for disabled checkmarked items. See ImgProperties
     *   for format. Valid src, width and height must be specified.
     *  @type {Img}
     *  @default "{...}"
     */
    open var checkmarkDisabledImage: Img = definedExternally
    /**
     *  If true, clicking or pressing Enter on a menu item that has a submenu will
     *   select that item (with standard behavior of hiding the menus, calling click
     *   handlers, etc) instead of showing the submenu.
     *  @type {boolean}
     *  @default null
     */
    open var canSelectParentItems: Boolean = definedExternally
    /**
     *  When false, when a menu item is chosen (via mouse click or keyboard), the menu is not
     *   automatically hidden, staying in place for further interactivity
     *  @type {boolean}
     *  @default true
     */
    open var autoDismiss: Boolean = definedExternally
    /**
     *  When true any generated submenus will inherit Menu.autoDismiss
     *   from this menu.
     *  @type {boolean}
     *  @default true
     */
    open var cascadeAutoDismiss: Boolean = definedExternally
    /**
     *  When false, when a user clicks outside the menu, or hits the Escape key, this menu
     *   will not be automatically hidden, staying in place for further interactivity.
     *  @type {boolean}
     *  @default true
     */
    open var autoDismissOnBlur: Boolean = definedExternally
    /**
     *  When using a Tree or hierarchical DataSource as the menu's data, optional subclass of
     *   Menu that should be used when generating submenus.
     *  @type {SCClassName}
     *  @default null
     */
    open var submenuConstructor: String = definedExternally
    /**
     *  When using a Tree or hierarchical DataSource as the menu's data, submenus are
     *   automatically generated from child nodes. fetchSubmenus
     *   can be set to false to disable this for the whole menu, or can be set false on a
     *   per-item basis via MenuItem.fetchSubmenus.
     *  @type {boolean}
     *  @default true
     */
    open var fetchSubmenus: Boolean = definedExternally
    /**
     *  Where should the menu be placed on the screen?
     * 
     *   Default is to use PanelPlacement "fillScreen" if Browser.isHandset. In
     *   any non-handset device, placement is unset, so the menu defaults to normal
     *   placement (near the originating MenuButton, or the mouse for a context menu, or
     *   according to left/top/width/height for a manually created Menu).
     * 
     *   When using any placement setting that fills a portion of the screen or a
     *   panel, submenus are displayed by sliding them into place on top of the currently active
     *   menu, and a NavigationBar is used to manage navigation to the
     *   main menu (and provide dismissal, via a Menu.cancelButtonTitle.
     *  @type {PanelPlacement}
     *  @default null
     */
    open var placement: 
                        /**
                         *  classic placement for menus, pop-up lists and pickers in desktop           interfaces: near the control that was clicked (a search field,
                         *             MenuButton, etc). Note: this setting does not apply when there is
                         *             no originating control (such as a dialog that appears due to session
                         *             timeout), in which case centering will generally be used
                         *  fill the nearest containing panel managed by a device-aware layout such as          SplitPane, which will generally be equivalent to "fillScreen" for a
                         *            Browser.isHandset. Note: this setting does not
                         *            apply if there is no clear container for the component originating the UI,
                         *            in which case, "fillScreen" will generally be used.
                         *  fill the entire screen
                         *  fill the bottom half of the screen. This is the default behavior on iOS6/7           for plain HTML &lt;select&gt;, but note that native apps rarely use
                         *             this interface for picking from lists and it is not generally recommended.
                         *  this setting disables all panelPlacement sizing and positioning logic.           Explicitly specified size and positioning will be used.
                         */
                        String /* nearOrigin |  fillPanel |  fillScreen |  halfScreen |  none */ = definedExternally
    /**
     *  Navigation bar shown when Menu.placement setting indicates that the menu should
     *   be shown filling a portion of the screen or a panel.
     *  @type {NavigationBar}
     *  @default null
     */
    open var navigationBar: NavigationBar = definedExternally
    /**
     *  Title for the "Done" button shown when the NavigationBar is present.
     *  @type {HTMLString}
     *  @default "Done"
     */
    open var cancelButtonTitle: String = definedExternally
    /**
     *  When the Menu.placement setting indicates that the menu should be shown filling
     *   a portion of the screen or a panel, navStack is a container element
     *   created to hold the NavigationBar and any submenus that are shown by the menu.
     *  @type {Canvas}
     *  @default null
     */
    open var navStack: Canvas = definedExternally
    /**
     *  showEdges dynamically defaults to false when the Menu.placement setting
     *   indicates the Menu will be filling a portion of the screen or a panel.
     *  @type {boolean}
     *  @default null
     */
    override var showEdges: Boolean = definedExternally
    /**
     *  Whether to show a drop shadow for this Canvas.
     * 
     *   Developers should be aware that the drop shadow
     *   is drawn outside the specified width and height of the widget meaning a widget with shadows
     *   takes up a little more space than it otherwise would. A full screen canvas with showShadow set
     *   to true as this would be likely to cause browser scrollbars to appear - developers can handle
     *   this by either setting this property to false on full-screen widgets, or by setting
     *   overflow to "hidden" on the &lt;body&gt; element browser-level scrolling is never intended to occur.
     * 
     *   showShadow dynamically defaults to false when the Menu.placement setting
     *   indicates the Menu will be filling a portion of the screen or a panel.
     *  @type {boolean}
     *  @default null
     */
    override var showShadow: Boolean = definedExternally
    /**
     *  If set, alternative body style for the menu used when there is no icon field and the
     *   Menu.placement settings indicate the menu will be filling a portion of the screen or
     *   a panel. Generally this alternative style should not have rounded or excessively large
     *   edges. If unset, then Menu.bodyStyleName is used instead.
     * 
     *   When there is an icon field, Menu.iconFillSpaceStyleName, if set, overrides this setting.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var fillSpaceStyleName: String = definedExternally
    /**
     *  If set, alternative body style for the menu used when there is an icon field and the
     *   Menu.placement settings indicate the menu will be filling a portion of the screen or
     *   a panel. Generally this alternative style should not have rounded or excessively large
     *   edges. In RTL mode, the iconFillSpaceStyleName is suffixed with "RTL", which
     *   allows skins to apply different styles in LTR and RTL modes. If unset, then
     *   Menu.iconBodyStyleName is used instead.
     * 
     *   Note: Like iconBodyStyleName, any skin which uses iconFillSpaceStyleName
     *   should add "RTL" styles as well, even if identical to LTR styles. Otherwise, menus may
     *   lose their styling in RTL mode.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var iconFillSpaceStyleName: String = definedExternally
    /**
     *  For a menu that has a MenuButton generated for it automatically (for example when
     *   included in a MenuBar, the width that the MenuButton should have. If unset, the
     *   MenuButton will be as wide as menu.width.
     *  @type {Integer}
     *  @default null
     */
    open var menuButtonWidth: Number = definedExternally
    /**
     *   This DataBoundComponent method is not supported - use
     *   Menu.initialCriteria to apply criteria to the fetches made by
     *   menus.
     * 
     *  @param {Criteria | AdvancedCriteria} new criteria to show
     */
    override fun setCriteria(criteria: dynamic): Unit = definedExternally
    /**
     *   This DataBoundComponent method does not apply to Menu.
     * 
     * 
     *  @param {Criteria=} Search criteria. If a DynamicForm is passed                     in as this argument instead of a raw criteria                      object, will be derived by calling                      DynamicForm.getValuesAsCriteria
     *  @param {DSCallback=} callback to invoke when a fetch is complete. Fires                     only if server contact was required
     *  @param {DSRequest=} additional properties to set on the DSRequest                     that will be issued
     */
    override fun fetchData(criteria: dynamic?, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Show or hide the checkmark/custom icon column at runtime.
     * 
     * 
     *  @param {boolean} whether the icon column should be displayed
     */
    open fun setShowIcons(showIcons: Boolean): Unit = definedExternally
    /**
     *   Show or hide the submenu indicator column at runtime.
     * 
     * 
     *  @param {boolean} whether the submenu indicator column should be displayed
     */
    open fun setShowSubmenus(showSubmenus: Boolean): Unit = definedExternally
    /**
     *   Executed when a menu item with no click handler is clicked by the user. This
     *   itemClick handler must be specified as a function. It is passed an item parameter that
     *   is a reference to the clicked menu item.
     * 
     * 
     *  @param {object} pointer to the item in question
     *  @param {number=} Index of the column clicked by the user. May be null if             this menu item was activated in response to a keyboard event.
     */
    open fun itemClick(item: dynamic, colNum: Number?): Boolean = definedExternally
    /**
     *   Show this menu as a context menu, that is, immediately adjacent to the current mouse position.
     * 
     * 
     */
    override fun showContextMenu(): Boolean = definedExternally
    /**
     *   Change the set of items to display in this menu
     * 
     *  @param {Array<Partial<MenuItem>> | Array<Partial<Record>> | Tree | any} new items for this menu
     */
    override fun setData(newData: dynamic): Unit = definedExternally
    /**
     *   Synonym for Menu.setData.
     * 
     *  @param {Array<Partial<MenuItem>>} new items for this menu
     */
    open fun setItems(items: Array<dynamic>): Unit = definedExternally
    /**
     *   Hide the context menu - alias for hide()
     * 
     */
    override fun hideContextMenu(): Unit = definedExternally
    /**
     *   Get a particular MenuItem by index.
     * 
     *   If passed a MenuItem, returns it.
     * 
     * 
     *  @param {Integer} index of the MenuItem
     */
    open fun getItem(item: Number): MenuItem = definedExternally
    /**
     *   Set arbitrary properties for a particular menu item.
     * 
     * 
     *  @param {Integer} index of the MenuItem
     *  @param {MenuItem} properties to apply to the item
     */
    open fun setItemProperties(item: Number, properties: MenuItem): Unit = definedExternally
    /**
     *   Given a MenuItem, return it's index in the items array.
     * 
     * 
     *  @param {MenuItem | Integer} index of the item or MenuItem itself
     */
    open fun getItemNum(item: dynamic): Number = definedExternally
    /**
     *   Get all the MenuItems in the current menu as an Array.
     * 
     * 
     */
    open fun getItems(): Array<dynamic> = definedExternally
    /**
     *   Return the CSS class for a cell. By default this method has the following implementation:
     *   - return any custom style for the record (GridRenderer.recordCustomStyleProperty)
     *    if defined.
     *   - create a style name based on the result of GridRenderer.getBaseStyle and the
     *    state of the record using the rules described in cellStyleSuffixes.
     * 
     *   Cell Styles are customizable by:
     * 
     * 
     *  - attaching a custom style to a record by setting
     *    record[this.recordCustomStyleProperty] to some valid CSS style name.
     * 
     *  - modifying the base style returned by getBaseStyle() [see that method for further
     *     documentation on this]
     * 
     *  - overriding this function
     * 
     * 
     *   In addition to this, GridRenderer.getCellCSSText may be overriden to
     *   provide custom cssText to apply on top of the styling attributes derived from the named
     *   style.
     * 
     * 
     * 
     *  @param {ListGridRecord} record object for this row and column
     *  @param {number} number of the row
     *  @param {number} number of the column
     */
    override fun getCellStyle(record: ListGridRecord, rowNum: Number, colNum: Number): String = definedExternally
    /**
     *   Show the submenu for the specified item, if it has one.
     * 
     *   Normally triggered automatically by user interaction.
     * 
     * 
     *  @param {MenuItem | number} the item in question, or it's index
     */
    open fun showSubmenu(item: dynamic): Unit = definedExternally
    /**
     *   Get the submenu for a particular menu item.
     * 
     *   Override to provide dynamic generation of submenus.
     * 
     * 
     *  @param {MenuItem | number} the item in question, or it's index
     */
    open fun getSubmenu(item: dynamic): Menu = definedExternally
    /**
     *   Enables or disables the menu item according to the value of newState, and redraws
     *   the menu if necessary. Returns true if there's a change in the enabled state.
     * 
     * 
     *  @param {MenuItem | number} MenuItem in question, or it's index
     *  @param {boolean=} true to enable the menu item, false to disable it. If not               passed, true is assumed
     */
    open fun setItemEnabled(item: dynamic, newState: Boolean?): Boolean = definedExternally
    /**
     *   Checks or unchecks the menu item according to the value of newState, and redraws
     *   the menu if necessary. Returns true if there's a change in the checked state.
     * 
     * 
     *  @param {MenuItem | number} MenuItem in question, or it's index
     *  @param {boolean=} true to check the menu item, false to uncheck it. If not               passed, true is assumed
     */
    open fun setItemChecked(item: dynamic, newState: Boolean?): Boolean = definedExternally
    /**
     *   Sets the title of a particular menu item to the string specified by newTitle and
     *   redraws the menu if necessary.
     * 
     * 
     *  @param {MenuItem | number} MenuItem in question, or it's index
     *  @param {string} new title
     */
    open fun setItemTitle(item: dynamic, newTitle: String): Boolean = definedExternally
    /**
     *   Sets the icon and disabled icon (if specified) for a particular menu item and redraws
     *   the menu if necessary. Returns true if the icon changed.
     * 
     * 
     *  @param {MenuItem | number} MenuItem in question, or it's index
     *  @param {string} new icon URL
     *  @param {string=} new icon URL for disabled image
     */
    open fun setItemIcon(item: dynamic, newIcon: String, newDisabledIcon: String?): Boolean = definedExternally
    companion object {
        /**
         *  Creates a new Menu
         * 
         *  @param typeCheckedProperties {Partial<Menu>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Menu} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Menu = definedExternally
        /**
         *   Hide all menus that are currently open. This method is useful to hide the current set of
         *   menus including submenus, and dismiss the menu's clickMask.
         * 
         * 
         */
        fun hideAllMenus(): Unit = definedExternally
    }
}