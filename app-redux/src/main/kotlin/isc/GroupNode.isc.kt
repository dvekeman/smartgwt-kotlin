@file:JsQualifier("isc")
package isc

/**
 *  An auto-generated subclass of TreeNode representing the group nodes
 *   in a grouped ListGrid.
 */
open external class GroupNode {
    /**
     *  Array of ListGridRecord that belong to this group, or, for multi-field grouping, array
     *   of groupNodes of subgroups under this groupNode.
     *  @type {Array<Partial<ListGridRecord>> | GroupNode}
     *  @default "see below"
     */
    open var groupMembers: dynamic = definedExternally
    /**
     *  The computed title for the group, which results from ListGridField.getGroupTitle
     *  @type {HTMLString}
     *  @default "see below"
     */
    open var groupTitle: String = definedExternally
    /**
     *  The value from which groups are computed for a field,
     *   which results from ListGridField.getGroupValue
     *  @type {any}
     *  @default "see below"
     */
    open var groupValue: dynamic = definedExternally
}