@file:JsQualifier("isc")
package isc

/**
 *  Every node in the tree is represented by a TreeNode object which is an object literal with a
 *   set of properties that configure the node.
 * 
 *   When a Tree is supplied as TreeGrid.data to TreeGrid, you can also set
 *   properties from ListGridRecord on the TreeNode (e.g. setting
 *   ListGridRecord.enabled:false on the node).
 */
open external class TreeNode {
    /**
     *  Default property name denoting whether this record is enabled. Property name may be
     *   modified for some grid via ListGrid.recordEnabledProperty.
     *  @type {boolean}
     *  @default null
     */
    open var enabled: Boolean = definedExternally
    /**
     *  Governs whether this node can be dragged. Only has an effect if this node is displayed in
     *   a TreeGrid where TreeGrid.canDragRecordsOut, TreeGrid.canReorderRecords
     *   or TreeGrid.canReparentNodes is true.
     *  @type {boolean}
     *  @default null
     */
    open var canDrag: Boolean = definedExternally
    /**
     *  Governs whether dragged data (typically other treeNodes) may be dropped over
     *   this node. Only has an effect if this node is displayed in a TreeGrid where
     *   TreeGrid.canAcceptDroppedRecords, TreeGrid.canReorderRecords or
     *   TreeGrid.canReparentNodes is true.
     *  @type {boolean}
     *  @default null
     */
    open var canAcceptDrop: Boolean = definedExternally
    /**
     *  Set to true or a string that is not equal to (ignoring case)
     *   "false" to explicitly mark this node as a folder. See Tree.isFolder for
     *   a full description of how the Tree determines whether a node is a folder or not.
     * 
     *   Note: the name of this property can be changed by setting Tree.isFolderProperty.
     *  @type {boolean | string}
     *  @default null
     */
    open var isFolder: dynamic = definedExternally
    /**
     *  Provides a name for the node that is unique among its immediate siblings, thus allowing a
     *   unique path to be used to identify the node, similar to a file system. See
     *   Tree.getPath.
     * 
     *   If the nameProperty is not set on a given node, the TreeNode.id will be used instead. If
     *   this is also missing, Tree.getName and Tree.getPath will auto-generate a
     *   unique name for you. Thus names are not required, but if the dataset you are using already
     *   has usable names for each node, using them can make APIs such as Tree.find more
     *   useful. Alternatively, if your dataset has unique ids consider providing those as
     *   TreeNode.id.
     * 
     *   If a value provided for the nameProperty of a node (e.g. node.name) is not a
     *   string, it will be converted to a string by the Tree via ""+value.
     * 
     *   This property is also used as the default title for the node (see Tree.getTitle)
     *   if TreeNode.title is not specified.
     * 
     *   Note: the name of this property can be changed by setting Tree.nameProperty.
     *  @type {string}
     *  @default "null, but see below"
     */
    open var name: String = definedExternally
    /**
     *  The title of the node as it should appear next to the node icon in the Tree. If left
     *   unset, the value of TreeNode.name is used by default. See the description in
     *   Tree.getTitle for full details.
     * 
     *   Note: the name of this property can be changed by setting Tree.titleProperty.
     *  @type {HTMLString}
     *  @default null
     */
    open var title: String = definedExternally
    /**
     *  Specifies the unique ID of this node.
     * 
     *   Required for trees with Tree.modelType "parent". With modelType:"parent", the unique
     *   ID of a node, together with the unique ID of its parent (see TreeNode.parentId) is
     *   used by Tree.linkNodes to link a list of nodes into a tree.
     * 
     *   Note: the name of this property can be changed by setting Tree.idField.
     *  @type {string | number}
     *  @default null
     */
    open var id: String = definedExternally
    /**
     *  For trees with modelType:"parent", this property specifies the unique ID of this node's
     *   parent node.
     *   The unique ID of a node, together with the unique ID of its parent is used by
     *   Tree.linkNodes to link a list of nodes into a tree.
     * 
     *   Note: the name of this property can be changed by setting Tree.parentIdField.
     *  @type {string | number}
     *  @default null
     */
    open var parentId: dynamic = definedExternally
    /**
     *  For trees with the modelType "children", this property specifies the children of this
     *   TreeNode.
     * 
     *   Note: the name of this property can be changed by setting Tree.childrenProperty
     *  @type {Array<Partial<TreeNode>>}
     *  @default null
     */
    open var children: Array<dynamic> = definedExternally
    /**
     *  This Property allows the developer to customize the icon displayed next to a node.
     *   Set node.icon to the URL of the desired icon to display and
     *   it will be shown instead of the standard TreeGrid.nodeIcon for this node.
     *   Note that if TreeNode.showOpenIcon and/or TreeNode.showDropIcon
     *   is true for this node, customized icons for folder nodes will be appended with the
     *   TreeGrid.openIconSuffix or TreeGrid.dropIconSuffix suffixes on state change
     *   as with the standard TreeGrid.folderIcon for this treeGrid. Also note that for
     *   custom folder icons, the TreeGrid.closedIconSuffix will never be appended.
     *   You can change the name of this property by setting
     *   TreeGrid.customIconProperty.
     *  @type {SCImgURL}
     *  @default null
     */
    open var icon: String = definedExternally
    /**
     *  For folder nodes showing custom icons (set via TreeNode.icon),
     *   this property allows the developer to specify on a per-node basis whether an
     *   open state icon should be displayed when the folder is open.
     *   Set node.showOpenIcon to true to show the open state
     *   icons, or false to suppress this.
     *   If not specified, this behavior is determined by TreeGrid.showCustomIconOpen
     *   for this node.
     *   You can change the name of this property by setting
     *   TreeGrid.customIconOpenProperty.
     *  @type {boolean}
     *  @default false
     */
    open var showOpenIcon: Boolean = definedExternally
    /**
     *  For folder nodes showing custom icons (set via TreeNode.icon),
     *   this property allows the developer to specify on a per-node basis whether a
     *   drop state icon should be displayed when the
     *   user drop-hovers over this folder.
     *   Set node.showDropIcon to true to show the drop state
     *   icon, or false to suppress this.
     *   If not specified, this behavior is determined by TreeGrid.showCustomIconDrop
     *   for this node.
     *   You can change the name of this property by setting
     *   TreeGrid.customIconDropProperty.
     *  @type {boolean}
     *  @default false
     */
    open var showDropIcon: Boolean = definedExternally
    /**
     *  For folder nodes showing custom icons (set via TreeNode.icon),
     *   this property allows the developer to specify on a per-node basis whether a
     *   selected state icon should be displayed when the folder is open.
     *   Set node.showSelectedIcon to true to show the selected state
     *   icons, or false to suppress this.
     *   If not specified, this behavior is determined by TreeGrid.showCustomIconSelected
     *   for this node.
     *   You can change the name of this property by setting
     *   TreeGrid.customIconSelectedProperty.
     *  @type {boolean}
     *  @default false
     */
    open var showSelectedIcon: Boolean = definedExternally
}