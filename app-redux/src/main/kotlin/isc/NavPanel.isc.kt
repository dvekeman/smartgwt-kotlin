@file:JsQualifier("isc")
package isc

/**
 *  Provides a list or tree of NavItem, each of which specifies a
 *   component to be displayed in a mutually exclusive fashion in the NavPanel.navDeck.
 * 
 *   A NavPanel can either have a flat list of NavItems or a hierarchy via
 *   NavItem.items - use NavPanel.isTree to explicitly control this.
 * 
 *   Because NavPanel extends SplitPane, it automatically shifts between side-by-side vs
 *   single panel display on handset-sized devices. Specifically, the NavPanel.navGrid is
 *   set as the SplitPane.navigationPane and the NavPanel.navDeck is set as the
 *   SplitPane.detailPane.
 * 
 *   Note that NavPanel is a fairly simple component to replicate by composing other
 *   SmartClient widgets. If you need a component that looks roughly like a
 *   NavPanel but will require lots of visual and behavioral customization, consider
 *   using the underlying components directly instead of deeply customizing the
 *   NavPanel class. A NavPanel is essentially just a TreeGrid
 *   and Deck in a SplitPane, with a ListGrid.recordClick
 *   handler to call Deck.setCurrentPane with a component ID stored as an attribute of
 *   each Record.
 */
open external class NavPanel : SplitPane {
    /**
     *  Whether the NavItems form a Tree or are just a flat list. If
     *   isTree is false, TreeGrid.showOpener will be set false on the
     *   NavPanel.navGrid so that space isn't wasted.
     * 
     *   The setting for isTree is defaulted immediately before initial draw, based
     *   on whether any NavItem has a list of subitems specified via NavItem.items.
     *   If no NavItems are provided before draw, isTree defaults to
     *   true. Auto-detection is never attempted again even if all
     *   NavItems are replaced.
     * 
     *   Set isTree explicitly if auto-detection doesn't yield the correct result
     *   for your application.
     *  @type {boolean}
     *  @default null
     */
    open var isTree: Boolean = definedExternally
    /**
     *  The TreeGrid used to display NavItems.
     *  @type {TreeGrid}
     *  @default null
     */
    open var navGrid: TreeGrid = definedExternally
    /**
     *  The Deck area where components specified via NavItem.pane are displayed.
     *  @type {Deck}
     *  @default null
     */
    open var navDeck: Deck = definedExternally
    /**
     *  CSS style used when NavItem.isHeader is set on an item.
     *   May be overridden for a specific header item by NavItem.customStyle.
     *  @type {CSSStyleName}
     *  @default "navItemHeader"
     */
    open var headerStyle: String = definedExternally
    /**
     *  Top-level navigation items to display. You can optionally specify a tree of items using
     *   NavItem.items.
     * 
     *   A separator between navigation items can be created by setting NavItem.isSeparator,
     *   and a header can be created via NavItem.isHeader.
     * 
     *   Each non-separator and non-header NavItem specifies a component to be displayed
     *   in the NavPanel.navDeck via NavItem.pane.
     * 
     *   NavItems can also be individually styled via ListGridRecord._baseStyle
     *   or NavItem.customStyle.
     *  @type {Array<Partial<NavItem>>}
     *  @default null
     */
    open var navItems: Array<dynamic> = definedExternally
    /**
     *  The current NavItem whose NavItem.pane is showing in the
     *   NavPanel.navDeck. This must be an item of this NavPanel if
     *   set.
     *  @type {NavItem}
     *  @default null
     */
    open var currentItem: NavItem = definedExternally
    /**
     *  The ID of the current NavItem whose NavItem.pane is showing in the
     *   NavPanel.navDeck. The NavItem must be an item of this
     *   NavPanel if set.
     * 
     *   The ID of a NavItem is the item's NavItem.id if set; otherwise, it
     *   is the ID of the item's NavItem.pane, though currentItemId may be
     *   initialized to either identifier.
     *  @type {Identifier}
     *  @default null
     */
    open var currentItemId: String = definedExternally
    /**
     *   Setter for NavPanel.currentItem. Note that NavPanel.currentItemId is also
     *   updated by this setter.
     * 
     *  @param {NavItem=} the new currentItem. May be null to hide the current item. If newCurrentItem is a separator or header item, then setCurrentItem() has no effect.
     */
    open fun setCurrentItem(newCurrentItem: NavItem?): Unit = definedExternally
    /**
     *   Setter for NavPanel.currentItemId. Note that NavPanel.currentItem is also
     *   updated by this setter and this.currentItemId may be normalized to a different
     *   identifier.
     * 
     *  @param {Identifier=} the ID of the new current item, which may be either the item's NavItem.id or the ID of the item's NavItem.pane. May be null or an empty string to hide the current item. If the item with ID newCurrentItemId is a separator or header item, then setCurrentItemId() has no effect.
     */
    open fun setCurrentItemId(newCurrentItemId: String?): Unit = definedExternally
    companion object {
        /**
         *  Creates a new NavPanel
         * 
         *  @param typeCheckedProperties {Partial<NavPanel>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {NavPanel} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): NavPanel = definedExternally
    }
}