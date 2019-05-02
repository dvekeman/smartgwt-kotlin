@file:JsQualifier("isc")
package isc

/**
 * 
 *   Tabs are specified as objects, not class instances. For example, when
 *   developing in JavaScript, a typical initialization block for a TabSet would look like
 *   this:
 * 
 *   TabSet.create({
 *     tabs: [
 *       {title: "tab1", pane: "pane1"},
 *       {title: "tab2"}
 *     ]
 *   });
 * 
 *   And in XML:
 * 
 *   &lt;TabSet&gt;
 *    &lt;tabs&gt;
 *      &lt;Tab title="tab1" pane="pane1"/&gt;
 *      &lt;Tab title="tab2"/&gt;
 *    &lt;/tabs&gt;
 *   &lt;/TabSet&gt;
 * 
 * 
 * 
 */
open external class Tab {
    /**
     *  Specifies the title of the this tab. To change the title after the TabSet
     *   has been created, call TabSet.setTabTitle.
     *  @type {HTMLString}
     *  @default null
     */
    open var title: String = definedExternally
    /**
     *  If specified, overrides the TabSet.canEditTabTitles setting, for this one tab
     *   only.
     * 
     *   Note that the TabSet's TabSet.titleEditEvent must be set to a
     *   supported TabTitleEditEvent in order for users to be able to edit this tab's
     *   title.
     * 
     *   After the TabSet has been created, you can change a tab's canEditTtile
     *   property by calling TabSet.setTabProperties.
     *  @type {boolean}
     *  @default null
     */
    open var canEditTitle: Boolean = definedExternally
    /**
     *  Specifies the prompt to be displayed when the mouse hovers over the tab.
     * 
     *   After the TabSet has been created, you can change a tab's prompt property by
     *   calling TabSet.setTabProperties.
     *  @type {HTMLString}
     *  @default null
     */
    open var prompt: String = definedExternally
    /**
     *  If TabSet.showTabPicker is true for this TabSet, if set this property will determine
     *   the title of the picker menu item for this tab. If unset, Tab.title will be used
     *   instead.
     * 
     *   After the TabSet has been created, you can change a tab's pickerTitle
     *   property by calling TabSet.setTabProperties.
     *  @type {HTMLString}
     *  @default null
     */
    open var pickerTitle: String = definedExternally
    /**
     *  Specifies the pane associated with this tab. You have two options for the value of
     *   the pane attribute:
     * 
     * 
     *  - ID - The global ID of an already created Canvas (or subclass).
     * 
     *  - Canvas - A live instance of a Canvas (or subclass).
     * 
     *   You can change the pane associated with a given tab after the TabSet has
     *   been created by calling TabSet.updateTab.
     *  @type {Canvas | GlobalId}
     *  @default null
     */
    open var pane: dynamic = definedExternally
    /**
     *  Space to leave around the pane within this Tab.
     *   If specified, this property takes precedence over TabSet.paneMargin
     *  @type {Integer}
     *  @default null
     */
    open var paneMargin: Number = definedExternally
    /**
     *  Optional ID for the tab, which can later be used to reference the tab.
     *   APIs requiring a reference to a tab will accept the tab's ID
     *   [including TabSet.selectTab, TabSet.updateTab, TabSet.removeTab].
     *   The ID will also be passed to the TabSet.tabSelected and TabSet.tabDeselected
     *   handler functions, if specified.
     * 
     *   Note that if you provide an ID, it must be globally unique. If you do not want a
     *   globally unique identifier, set Tab.name instead.
     *  @type {GlobalId}
     *  @default null
     */
    open var ID: String = definedExternally
    /**
     *  Optional name for the tab, which can later be used to reference the tab.
     *   APIs requiring a reference to a tab will accept the tab's name
     *   [including TabSet.selectTab, TabSet.updateTab, TabSet.removeTab].
     *   This name will also be passed to the TabSet.tabSelected and TabSet.tabDeselected
     *   handler functions, if specified.
     * 
     *   This identifier is requred to be locally unique to the TabSet and cannot be used to get
     *   a global reference to the Tab. If you want a global reference, set Tab.ID instead.
     *  @type {TabName}
     *  @default null
     */
    open var name: String = definedExternally
    /**
     *  You can specify an explicit width for the tab using this property. Note that tabs
     *   automatically size to make room for the full title, but if you want to e.g. specify a
     *   uniform width for all tabs in a TabSet, this property enables you to do so.
     * 
     *   After the TabSet has been created, you can change a tab's width
     *   property by calling TabSet.setTabProperties.
     *  @type {number}
     *  @default "100"
     */
    open var width: dynamic = definedExternally
    /**
     *  If enabled, the tab will collapse to show just its icon when showing the title would
     *   cause overflow of a containing TabBar. While collapsed, the tab will show its
     *   title on hover, unless an explicit hover has been specified such as by Tab.prompt.
     *  @type {boolean}
     *  @default false
     */
    open var canAdaptWidth: Boolean = definedExternally
    /**
     *  If specified, this tab will initially be rendered in a disabled state. To
     *   enable or disable tabs on the fly use the TabSet.enableTab, and
     *   TabSet.disableTab.
     *   methods.
     *  @type {boolean}
     *  @default null
     */
    open var disabled: Boolean = definedExternally
    /**
     *  If specified, this tab will show an icon next to the tab title.
     * 
     *   NOTE: if you enable TabSet.canCloseTabs,
     *   tab.icon is used for the close icon. TabSet.canCloseTabs describes
     *   a workaround to enable both a closeIcon and a second icon to be shown.
     * 
     *   Use TabSet.tabIconClick to add an event handler specifically for clicks on the icon.
     * 
     *   If a tab Tab.disabled, a different icon will be loaded by adding
     *   a suffix to the image name (see Button.icon).
     * 
     *   You should specify a size for the icon via Tab.iconSize or Tab.iconWidth
     *   and Tab.iconHeight. Without an explicitly specified size, tabs may be drawn
     *   overlapping or with gaps the first time a page is loaded, because the icon is not cached
     *   and therefore its size isn't known.
     * 
     *   After the TabSet has been created, you can change a tab's icon property by
     *   calling TabSet.setTabIcon.
     *  @type {SCImgURL}
     *  @default null
     */
    open var icon: String = definedExternally
    /**
     *  If Tab.icon is specified, this property may be used to specify a size for the icon.
     *   Per side sizing may be specified instead via Tab.iconWidth and Tab.iconHeight.
     * 
     *   After the TabSet has been created, you can change a tab's iconSize property
     *   by calling TabSet.setTabProperties.
     *  @type {Integer}
     *  @default "16"
     */
    open var iconSize: Number = definedExternally
    /**
     *  If Tab.icon is specified, this property may be used to specify a width for the
     *   icon.
     * 
     *   After the TabSet has been created, you can change a tab's iconWidth property
     *   by calling TabSet.setTabProperties.
     *  @type {Integer}
     *  @default null
     */
    open var iconWidth: Number = definedExternally
    /**
     *  If Tab.icon is specified, this property may be used to specify a height for the
     *   icon.
     * 
     *   After the TabSet has been created, you can change a tab's iconHeight
     *   property by calling TabSet.setTabProperties.
     *  @type {Integer}
     *  @default null
     */
    open var iconHeight: Number = definedExternally
    /**
     *  If TabSet.canReorderTabs is set to true, setting canReorder
     *   explicitly to false for some tab will disallow drag-reordering of
     *   this tab. Has no effect if canReorderTabs is not true at the tabSet level.
     * 
     *   Note that this setting also disallows a reorder of another tab into the slot before
     *   or following this tab. This means for tabs located at the beginning or end of the
     *   tab-bar, users cannot changing the index of the tab by dropping another
     *   before or after it. However if you have a canReorder:false
     *   tab which is not at the beginning or end of the tab bar, users can
     *   drag reorder other tabs around it which may ultimately change its position.
     *  @type {boolean}
     *  @default null
     */
    open var canReorder: Boolean = definedExternally
    /**
     *  Determines whether this tab should show a close icon allowing the user to dismiss the tab
     *   by clicking on the close icon directly. The URL for the close icon's image will be derived from
     *   TabSet.closeTabIcon by default, but may be overridden by explicitly specifying
     *   Tab.closeIcon.
     * 
     *   If unset or null, this property is derived from TabSet.canCloseTabs.
     * 
     *   Note that setting canClose means that Tab.icon cannot be used,
     *   because it's used for the Tab.closeIcon - see
     *   TabSet.canCloseTabs for a workaround.
     * 
     *   After the TabSet has been created, you can change a tab's canClose property
     *   by calling TabSet.setCanCloseTab.
     *  @type {boolean}
     *  @default null
     */
    open var canClose: Boolean = definedExternally
    /**
     *  Custom src for the close icon for this tab to display if it is closeable.
     *   See Tab.canClose and TabSet.canCloseTabs.
     *  @type {SCImgURL}
     *  @default null
     */
    open var closeIcon: String = definedExternally
    /**
     *  Size of the Tab.closeIcon for this tab. If unspecified the icon will be sized
     *   according to TabSet.closeTabIconSize
     *  @type {number}
     *  @default null
     */
    open var closeIconSize: Number = definedExternally
    /**
     *  Criteria to be evaluated to determine whether this Tab should be enabled. Re-evaluated
     *   whenever data in the Canvas.ruleScope changes.
     * 
     *   It works the same as Canvas.enableWhen
     *  @type {AdvancedCriteria}
     *  @default null
     */
    open var enableWhen: AdvancedCriteria = definedExternally
    /**
     *   Optional handler to fire when a tab is selected. As with TabSet.tabSelected this
     *   method only fires when the tabset is drawn.
     * 
     * 
     *  @param {TabSet} the tabSet containing the tab.
     *  @param {Integer} the index of the newly selected tab
     *  @param {Canvas} the newly selected tab's pane if set
     *  @param {string} the ID of the newly selected tab
     *  @param {Tab} pointer to the selected tab object
     *  @param {string} the name of the newly selected tab
     */
    open fun tabSelected(tabSet: TabSet, tabNum: Number, tabPane: Canvas, ID: String, tab: Tab, name: String): Unit = definedExternally
    /**
     *   Optional handler to fire when a tab is deselected. Returning false will cancel the
     *   new selection, leaving this tab selected. As with TabSet.tabSelected this
     *   method only fires when the tabset is drawn.
     * 
     * 
     *  @param {TabSet} the tabSet containing the tab.
     *  @param {Integer} the index of the deselected tab
     *  @param {Canvas} the deselected tab's pane if set
     *  @param {string} the ID of the deselected tab
     *  @param {Tab} pointer to the tab being deselected
     *  @param {Tab} pointer to the new tab being selected
     *  @param {string} the name of the deselected tab
     */
    open fun tabDeselected(tabSet: TabSet, tabNum: Number, tabPane: Canvas, ID: String, tab: Tab, newTab: Tab, name: String): Boolean = definedExternally
}