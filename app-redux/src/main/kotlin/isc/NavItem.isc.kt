@file:JsQualifier("isc")
package isc

/**
 *  Properties for a navigation item in a NavPanel.
 */
open external class NavItem : TreeNode {
    /**
     *  An optional ID for this NavItem. If specified, this must be unique within
     *   the NavPanel.
     *  @type {Identifier}
     *  @default null
     */
    override var id: String = definedExternally
    /**
     *  Title to show for this NavItem.
     *  @type {HTMLString}
     *  @default null
     */
    override var title: String = definedExternally
    /**
     *  Icon to show for this NavItem. If not specified, the
     *   ${isc.DocUtils.linkForRef('attr:TreeGrid.folderIcon','navGrid\'s folderIcon')} is used.
     *  @type {SCImgURL}
     *  @default null
     */
    override var icon: String = definedExternally
    /**
     *  Optional subitems of this NavItem.
     *  @type {Array<Partial<NavItem>>}
     *  @default null
     */
    open var items: Array<dynamic> = definedExternally
    /**
     *  If set, this NavItem will be styled like a header. In this case NavItem.pane
     *   is ignored and nothing happens when the header is clicked. However, NavItem.items can
     *   still be configured to place items hierarchically under the header.
     *  @type {boolean}
     *  @default null
     */
    open var isHeader: Boolean = definedExternally
    /**
     *  CSS style name used for this NavItem. If set and this NavItem
     *   is a NavItem.isHeader, this overrides the NavPanel's
     *   NavPanel.headerStyle.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var customStyle: String = definedExternally
    /**
     *  If set, this NavItem will be styled as a separator. A separator does not
     *   have a NavItem.pane and nothing happens when the separator is clicked.
     *  @type {boolean}
     *  @default null
     */
    open var isSeparator: Boolean = definedExternally
    /**
     *  Component to display in the NavPanel.navDeck when this NavItem is
     *   selected.
     * 
     *   A component can be provided directly, or its ID can be provided.
     *  @type {Canvas | Identifier}
     *  @default null
     */
    open var pane: dynamic = definedExternally
}