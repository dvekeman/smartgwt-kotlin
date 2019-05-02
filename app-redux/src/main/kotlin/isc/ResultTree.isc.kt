@file:JsQualifier("isc")
package isc

/**
 *  ResultTrees are an implementation of the Tree API, used to handle hierarchical
 *   data, whose nodes are DataSource records which are retrieved from a server.
 * 
 *   Modifying ResultTrees
 * 
 *   ResultTree nodes cannot be directly added or removed from a
 *   ResultTree.fetchMode ResultTree via Tree APIs such as
 *   Tree.add or Tree.remove, since such trees are considered to be read-only
 *   by virtue of containing ResultSets, which are read-only data structures. Even in
 *   other FetchModes, calling such APIs will only update the local cache of the
 *   ResultTree, rather than triggering any server traffict to update the DataSource.
 * 
 *   Use DataSource.addData/DataSource.removeData to add/remove
 *   rows from the DataSource, and the ResultTree will reflect the changes
 *   automatically. Alternatively, the DataSource.updateCaches method may be called to
 *   only update local caches of the DataSource in question, without generating any server
 *   traffic.
 * 
 *   To create a locally modifiable cache of records from a DataSource, you can use
 *   DataSource.fetchData to retrieve a List of records which can be modified directly,
 *   or you can create a client-only DataSource from the retrieved data to share a
 *   modifiable cache between several DataBoundComponents.
 */
open external class ResultTree : Tree {
    /**
     *  Selects the model used to construct the tree representation. See TreeModelType for
     *   the available options and their implications.
     * 
     *   If the "parent" modelType is used, you can provide the initial parent-linked data set to the
     *   tree via the Tree.data attribute. If the "children" modelType is used, you can
     *   provide the initial tree structure to the Tree via the Tree.root attribute.
     *  @type {TreeModelType}
     *  @default "parent"
     */
    override var modelType: 
                            /**
                             *  In this model, each node has an ID unique across the whole tree and a parent ID that points to its parent. The name of the unique ID property can be specified
                             *   via Tree.idField and the name of the parent ID property can be specified via
                             *   Tree.parentIdField. The initial set of nodes can be passed in as a list to
                             *   Tree.data and also added as a list later via Tree.linkNodes.
                             *   Whether or not a given node is a folder is determined by the value of the property specified
                             *   by Tree.isFolderProperty.
                             * 
                             *   The "parent" modelType is best for integrating with relational storage (because nodes can
                             *   map easily to rows in a table) and collections of Beans and is the model used for DataBound
                             *   trees.
                             *  In this model, nodes specify their children as a list of nodes. The property that holds the children nodes is determined by Tree.childrenProperty.
                             *   Nodes are not required to have an ID that is unique across the whole tree (in fact, no ID is
                             *   required at all). Node names (specified by the Tree.nameProperty, unique within
                             *   their siblings, are optional but not required. Whether or not a given node is a folder is
                             *   determined by the presence of the children list (Tree.childrenProperty).
                             */
                            String /* parent |  children */ = definedExternally
    /**
     *  Optional initial data for the tree. If the ResultTree.fetchMode is
     *   "basic" or "local" then the format of this data is exactly
     *   the same Tree.parentIdField-linked list of tree nodes as
     *   documented on Tree.data (when the modelType is set to
     *   "parent"). If the fetchMode is "paged" then the
     *   format is extended to allow the ResultTree.childCountProperty
     *   to be set on folder nodes.
     * 
     *   Providing an initial set of nodes in this way does not affect the behavior of the
     *   ResultTree in its loading of unloaded folders. An equivalent result is achieved if the
     *   first fetch from the server returns this same data.
     * 
     *   If fetchMode is "paged" then you may make folder-by-folder
     *   choices as to whether to use paging for the childen of each folder. If you would like
     *   to use paging in a folder then you may include a partial list of that folder's children
     *   with the data, provided that you set the childCountProperty to the total
     *   number of children. Otherwise you will need to include either all children of the
     *   folder or none of the children. Open folders without any children provided will cause
     *   immediate, new fetches for the children, as usual.
     * 
     *   Because the initial data is treated exactly as though it were returned from the tree's
     *   first server fetch, the order of the initial data must match the initial sort order of
     *   the TreeGrid displaying the data or, if no such sort is specified, the native storage
     *   order on the server. For example, consider initial data containing n
     *   records having the parentId "X", meaning they are all in
     *   the same folder. These n records are the records at indices
     *   0 through (n - 1) that are stored on the server under the
     *   parent node. If the childCountProperty set on the parent node indicates
     *   that there are m > n total rows under the parent node then the records at
     *   indices n to (m - 1) will be fetched from the server as the user
     *   scrolls the additional rows into view.
     *  @type {Array<Partial<TreeNode>>}
     *  @default null
     */
    override var data: Array<dynamic> = definedExternally
    /**
     *  What DataSource is this resultTree associated with?
     *  @type {DataSource | GlobalId}
     *  @default null
     */
    open var dataSource: dynamic = definedExternally
    /**
     *  Does this resultTree load data incrementally as folders within the tree are opened, or
     *   is it all loaded in a single request? Must be true if ResultTree.fetchMode is
     *   "paged".
     *  @type {boolean}
     *  @default true
     */
    open var loadDataOnDemand: Boolean = definedExternally
    /**
     *  Controls what happens to the ResultTree.getOpenState - the set of
     *   nodes opened or closed by the end user after tree data is loaded - when an entirely
     *   new tree of nodes is loaded from the server, as a consequence of calling
     *   ResultTree.invalidateCache or of changing criteria such that the current cache of
     *   nodes is dropped.
     *  @type {PreserveOpenState}
     *  @default "whenUnique"
     */
    open var autoPreserveOpenState: 
                                    /**
                                     *  Never try to automatically preserve the openState. Nodes will be initially open
                                     *   or closed based solely on the Tree.openProperty optionally set by the server.
                                     *  If either the Tree.idField or Tree.nameProperty has been set on
                                     *   the Tree, (so that nodes have either unique ids or unique paths),
                                     *   preserve openState by respecting the Tree.openProperty set by the server,
                                     *   then applying the openState.
                                     *  Like "whenUnique" but automatically preserves openState even if nodes cannot be
                                     *   uniquely identified. This means that nodes at the same tree positions
                                     *   (eg 3rd child of 5th node under root) will be placed in the same openState,
                                     *   regardless of whether that node has anything to do with the node that previously
                                     *   was at that tree position.
                                     */
                                    String /* never |  whenUnique |  always */ = definedExternally
    /**
     *  Mode of fetching records from server.
     * 
     *   fetchMode:"local" implies that local filtering will always be performed. See
     *   ResultTree.keepParentsOnFilter for additional filtering details.
     * 
     *   fetchMode:"basic" or "paged" implies that if search criteria change, the entire
     *   tree will be discarded and re-fetched from the server. When retrieving the replacement
     *   tree data, the default behavior will be to preserve the ResultTree.getOpenState
     *   for any nodes that the server returns which were previously opened by the user. Note
     *   that this implies that if ResultTree.loadDataOnDemand is enabled and the server returns only
     *   root-level nodes, open state will be preserved only for root-level nodes, and children
     *   of open root-level nodes will be immediately fetched from the server if
     *   they are not included in the server's initial response.
     * 
     *   fetchMode:"paged" enables paging for nodes that have very large numbers of children.
     *   Whenever the children of a folder are loaded, the resultTree will set
     *   DSRequest.startRow and DSRequest.endRow when requesting children
     *   from the DataSource, and will manage loading of further children on demand, similar to
     *   how a ResultSet manages paging for lists. For a deeper discussion see the
     *   Paging large sets of children section of the treeDataBinding
     *   overview.
     *  @type {FetchMode}
     *  @default "basic"
     */
    open var fetchMode: 
                        /**
                         *  All records that match the current filter are fetched. Sorting is        performed on the client.
                         *  Only requested ranges of records are fetched, with predictive fetch        ahead. Sorting is performed on the server.
                         *  All records available from the DataSource are fetched. Filtering by        search criteria and sorting are both performed on the client.
                         */
                        String /* basic |  paged |  local */ = definedExternally
    /**
     *  How many tree nodes to retrieve at once from each large set of children in the tree.
     * 
     *   Applicable only with fetchMode: "paged". When a paged ResultTree is asked
     *   for rows that have not yet been loaded, it will fetch adjacent rows that are likely to
     *   be required soon, in batches of this size.
     *  @type {Integer}
     *  @default "75"
     */
    open var resultSize: Number = definedExternally
    /**
     *  When using FetchMode and providing multiple levels of the tree in
     *   one DSResponse, childCountProperty must be set for any folders that include
     *   only a partial list of children.
     *   For a deeper discussion see the Paging large sets of children section of the
     *   treeDataBinding overview.
     *  @type {string}
     *  @default "childCount"
     */
    open var childCountProperty: String = definedExternally
    /**
     *  When using FetchMode and providing multiple levels of the tree
     *   in one DSResponse, canReturnOpenSubfoldersProperty may be set on any
     *   folder to indicate whether child folders might be returned by the server already open.
     *   If the property is set to false on a folder then subfolders of that folder are never
     *   allowed to be returned already open. This enables the paging mechanism to be more
     *   efficient in the amount of data that it requests from the server.
     * 
     *   For example, setting the canReturnOpenSubfoldersProperty value to
     *   false on a node is appropriate if the server-side code determines that the
     *   the node's children consist of entirely leaf nodes.
     *  @type {string}
     *  @default "canReturnOpenSubfolders"
     */
    open var canReturnOpenSubfoldersProperty: String = definedExternally
    /**
     *  When using FetchMode and providing multiple levels of the tree
     *   in one DSResponse, this property specifies the default value assumed for the
     *   ResultTree.canReturnOpenSubfoldersProperty when no value for that property is provided for
     *   a node.
     *  @type {boolean}
     *  @default false
     */
    open var canReturnOpenFolders: Boolean = definedExternally
    /**
     *  Sets DataSource.progressiveLoading for this
     *   ResultTree. The ResultTree will copy this setting onto the DSRequests that it
     *   issues, overriding the OperationBinding- and DataSource-level settings, in cases where
     *   the use of progressive loading does not affect the correctness of the tree's paging
     *   algorithm.
     * 
     *   This setting is applied automatically by DataBoundComponents that have their own
     *   explicit setting for DataBoundComponent.progressiveLoading.
     * 
     *   Note: This property only has an effect for FetchMode
     *   ResultTrees.
     *  @type {boolean}
     *  @default null
     */
    open var progressiveLoading: Boolean = definedExternally
    /**
     *  Controls whether nodes are assumed to be folders or leaves by default.
     * 
     *   Nodes that have children or have the Tree.isFolderProperty set
     *   to true will always be considered folders. Other nodes will be considered folders or
     *   leaves by default according to this setting.
     * 
     *   If defaultIsFolder is unset, the ResultTree will automatically set it to
     *   match the value of ResultTree.loadDataOnDemand. This means that, when using
     *   folder-by-folder load on demand (loadDataOnDemand:true), by default a newly
     *   loaded node will be considered to be a folder that has not loaded its children yet.
     * 
     *   When not using folder-by-folder load on demand, by default a newly loaded node is
     *   considered a leaf. If you set defaultIsFolder:true explicitly, by default
     *   a newly loaded node is considered to be a folder with no children.
     * 
     *   See Tree.isFolder for details on how to explicitly mark nodes as folders or leaves.
     *  @type {boolean}
     *  @default null
     */
    override var defaultIsFolder: Boolean = definedExternally
    /**
     *  This attribute may be used to specify a root value for the parentIdField of this resultTree.
     *   This overrides the default DataSourceField.rootValue for this tree, allowing
     *   a component to navigate a tree starting at a specific node.
     * 
     *   May be overridden via TreeGrid.treeRootValue for ResultTrees generated by a TreeGrid
     *   component.
     *  @type {any}
     *  @default null
     */
    open var rootNode: dynamic = definedExternally
    /**
     *  Which nodes should be opened automatically - applied whenever
     *   Tree.setRoot is called, including during initialization and as part of
     *   a re-fetch caused, for example, by duplicate() or
     *   ResultTree.invalidateCache.
     * 
     *   Options are:
     * 
     * 
     *  - "none" - no nodes are opened automatically
     * 
     *  - "root" - opens the ResultTree.rootNode - in databound
     *         trees, this node is always hidden
     * 
     *  - "all" - when ResultTree.loadDataOnDemand, opens the
     *         ResultTree.rootNode and all of it's direct
     *         descendants - otherwise, opens all loaded nodes
     * 
     *  @type {string}
     *  @default "none"
     */
    open var autoOpen: String = definedExternally
    /**
     *  When data is loaded from the server, should nodes with an explicit value for
     *   the Tree.parentIdField which doesn't map to a valid parent node be dropped?
     *   If set to false, for TreeGrid.loadDataOnDemand:false trees, parentless nodes will be
     *   added as children of the root node - for TreeGrid.loadDataOnDemand:true, they will be
     *   added as children of the folder currently requesting children.
     * 
     *   This effectively allows nodes to be loaded into the current (or root) folder without
     *   needing an explicit Tree.parentIdField that matches the folder's
     *   ID or rootValue for the resultTree.
     * 
     *   Note: For loadDataOnDemand:false trees, if this property is unset at init time,
     *   it will default to true if an explicit ResultTree.rootNode has been
     *   specified. This ensures that if the data tree retrieved from the server includes ancestors
     *   of the desired root-node we don't display them. Otherwise this property always defaults to
     *   false.
     *  @type {boolean}
     *  @default null
     */
    override var discardParentlessNodes: Boolean = definedExternally
    /**
     *  This attribute governs how to handle cache-synch when a new node is added to this dataSource
     *   with no explicit parentId.
     * 
     *   If set to true, when a new node is added to this dataSource via
     *   DataSource.addData, with no explicit parentId, the node will be added as a
     *   child of the root node of this result tree. Otherwise it will be ignored.
     * 
     *   Similar logic applies to DataSource.updateData - if this property is
     *   true and the parentId of an updated node is cleared, it will be moved to become a child of
     *   root, otherwise it will be dropped from the tree.
     *  @type {boolean}
     *  @default false
     */
    open var defaultNewNodesToRoot: Boolean = definedExternally
    /**
     *  When a successful Add, Update or Remove type operation fires on this ResultTree's
     *   dataSource, if DSResponse.data is unset, should we integrate the submitted
     *   data values (from the request) into our data-set?
     *  @type {boolean}
     *  @default true
     */
    open var updateCacheFromRequest: Boolean = definedExternally
    /**
     *  Criteria that are never shown to or edited by the user and are cumulative with any
     *   criteria provided via DataBoundComponent.initialCriteria, ResultTree.setCriteria
     *   etc.
     *  @type {Criteria}
     *  @default null
     */
    open var implicitCriteria: dynamic = definedExternally
    /**
     *  By default when the data of this ResultTree's dataSource is modified, the ResultTree will
     *   be updated to display these changes.
     *   Set this flag to true to disable this behavior.
     *  @type {boolean}
     *  @default false
     */
    open var disableCacheSync: Boolean = definedExternally
    /**
     *  If set, tree-based filtering is performed such that parent nodes are kept as long as
     *   they have children that match the filter criteria, even if the parents themselves do not
     *   match the filter criteria. If not set, filtering will exclude parent nodes not matching
     *   the criteria and all nodes below it in the tree.
     * 
     *   When keepParentsOnFilter is enabled for paged ResultTrees, server-side
     *   filtering is required.
     * 
     *   When enabled for non-paged trees, FetchMode is automatically
     *   enabled so that all filtering behavior shifts to the client-side and full criteria are
     *   no longer sent to the server. Instead, server fetches will always load all nodes, or
     *   with ResultTree.loadDataOnDemand:true, will always load all nodes under a given parent.
     *   This means that the server does not need to implement special tree filtering logic.
     * 
     *   Optionally, ResultTree.serverFilterFields can be set to a list of field names that
     *   will be sent to the server whenever they are present in the criteria.
     *  @type {boolean}
     *  @default null
     */
    open var keepParentsOnFilter: Boolean = definedExternally
    /**
     *  When ResultTree.keepParentsOnFilter is enabled for FetchMode
     *   ResultTrees, this property lists field names that will be sent to the server if they
     *   are present in the criteria.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var serverFilterFields: Array<dynamic> = definedExternally
    /**
     *  Whether or not we should skip promotion of a simple criteria to an AdvancedCriteria
     *   when sending the DSRequest to load the children of a node in a ResultTree.loadDataOnDemand
     *   or ResultTree.fetchMode ResultTree. If the
     *   DSRequest.textMatchStyle is not "exact", we normally convert the simple criteria to an
     *   AdvancedCriteria for correctness in matching the node name, but setting this property
     *   to true will allow that to be skipped for backcompat with older releases.
     *  @type {boolean}
     *  @default false
     */
    open var useSimpleCriteriaLOD: Boolean = definedExternally
    /**
     *  The filter criteria to use when fetching rows. For usage see
     *   ResultTree.setCriteria.
     *  @type {Criteria}
     *  @default null
     */
    open var criteria: dynamic = definedExternally
    /**
     *   Load the children of a given node.
     * 
     *   For a databound tree this will trigger a fetch against the Tree's DataSource.
     * 
     * 
     * 
     *  @param {TreeNode} node in question
     *  @param {DSCallback=} Optional callback (stringMethod) to fire when loading            completes. Has a single param node - the node whose            children have been loaded, and is fired in the scope of the Tree.
     */
    override fun loadChildren(node: TreeNode, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?)): Unit = definedExternally
    /**
     *   Unload the children of a folder, returning the folder to the "unloaded" state.
     * 
     * 
     *  @param {TreeNode} folder in question
     *  @deprecated \* It's recommended that you instead use Tree.reloadChildren to reload the children of a folder, or Tree.removeChildren if you need to clear the cached children
     *   of a folder to add specific local data.
     */
    override fun unloadChildren(node: TreeNode): Unit = definedExternally
    /**
     *   Replaces the existing children of a parent node. This leaves the node in the loaded state
     *   (unless a partially loaded set of children is specified using the optional
     *   totalChildren argument).
     * 
     *   The supplied array of children may be null or empty to indicate there are none, but
     *   if present must be in the standard format as would be sent from the server, as described
     *   by treeDataBinding.
     * 
     *   In particular, note that for a ResultTree.fetchMode ResultTree,
     *   each child node::
     * 
     *  - can have nested children spcified under the Tree.childrenProperty (but not via
     *   TreeNode.id/TreeNode.parentId linking)
     * 
     *  - cannot be open unless it includes either a complete set of children, or partial set of
     *   children and a childCount
     * 
     * 
     *  @param {TreeNode} parent of children
     *  @param {Array<Partial<TreeNode>>} children to be set
     *  @param {Integer=} number of total children (if not all have been                     provided as newChildren); only allowed if paging
     */
    open fun setChildren(parent: TreeNode, newChildren: Array<dynamic>, totalChildren: Number?): Unit = definedExternally
    /**
     *   Manually invalidate this ResultTree's cache.
     * 
     *   Generally a ResultTree will observe and incorporate updates to the DataSource that provides its
     *   records, but when this is not possible, invalidateCache() allows manual cache
     *   invalidation.
     * 
     *   Components bound to this ResultTree will typically re-request the currently visible portion
     *   of the dataset, causing the ResultTree to re-fetch data from the server.
     * 
     */
    open fun invalidateCache(): Unit = definedExternally
    /**
     *   Get the item in the openList at a particular position.
     * 
     *  @param {number} position of the node to get
     */
    override fun get(pos: Number): TreeNode = definedExternally
    /**
     *     Get a range of items from the open list
     * 
     *  @param {number} start position
     *  @param {number} end position (NOT inclusive)
     */
    override fun getRange(start: Number, end: Number): Array<dynamic> = definedExternally
    /**
     *   Set the filter criteria to use when fetching rows.
     * 
     *   Depending on the result of ResultTree.compareCriteria and setting for
     *   ResultTree.fetchMode, setting criteria may cause a trip to the server to get a new
     *   set of nodes, or may simply cause already-fetched nodes to be re-filtered according to the
     *   new criteria.
     * 
     *   For a basic overview on when server fetches are generally performed, see
     *   ResultTree.fetchMode.
     *   However, this is not the final determination of when server fetches occur. Criteria can
     *   be split into local criteria and server criteria by specifying ResultTree.serverFilterFields.
     *   Thus, even when using fetchMode:"local" a new server fetch will occur if the server
     *   criteria changes. For details on how the criteria is split, see
     *   DataSource.splitCriteria.
     * 
     *   Note: if criteria is being split to retrieve server criteria portion and the criteria
     *   is an AdvancedCriteria, the criteria must consist of a single "and" operator
     *   and one or more simple criteria below it. No other logical operators may be used. In
     *   other words, the AdvancedCriteria provided must be exactly representable by a
     *   simple criteria.
     * 
     * 
     *  @param {Criteria} the filter criteria
     */
    open fun setCriteria(newCriteria: dynamic): Unit = definedExternally
    /**
     *   The ResultTree will call applyFilter() when it needs to locally filter the tree using the
     *   current filter criteria.
     * 
     *   Default behavior is to call Tree.getFilteredTree to obtain a new, filtered tree.
     * 
     *   Override this method or Tree.getFilteredTree to implement your own client-side
     *   filtering behavior. Note that the original tree should not be affected.
     * 
     * 
     *  @param {Tree} the source tree to be filtered
     *  @param {Criteria} the filter criteria
     *  @param {TreeFilterMode} mode to use for filtering
     *  @param {DataSource} dataSource for filtering if the Tree does not                    already have one
     *  @param {DSRequest=} Request properties block. This allows developers to specify properties that would impact the filter such as DSRequest.textMatchStyle
     */
    open fun applyFilter(tree: Tree, criteria: dynamic, filterMode: 
                                                                    /**
                                                                     *  only nodes that actually match criteria are shown. If a parent does not         match the criteria, it will not be shown, even if it has children that do
                                                                     *           match the criteria
                                                                     *  parent nodes are kept if they have children which match the criteria,           or, in a tree with
                                                                     *             ResultTree.loadDataOnDemand, if they have
                                                                     *             not loaded children yet.
                                                                     */
                                                                    String /* strict |  keepParents */, dataSource: DataSource, requestProperties: DSRequest?): Tree = definedExternally
    /**
     *   Default behavior is to call DataSource.compareCriteria to determine whether new
     *   criteria is equivalent to the old criteria (returns 0) or not.
     * 
     *   See DataSource.compareCriteria for a full explanation of the default behavior.
     *   The CriteriaPolicy used is "dropOnChange".
     * 
     *   Override this method or DataSource.compareCriteria to implement your own client-side
     *   filtering behavior.
     * 
     * 
     *  @param {Criteria} new filter criteria
     *  @param {Criteria} old filter criteria
     *  @param {DSRequest=} dataSource request properties
     */
    open fun compareCriteria(newCriteria: dynamic, oldCriteria: dynamic, requestProperties: DSRequest?): Number = definedExternally
    /**
     *   Will changing the criteria for this resultTree require fetching new data from the server
     *   or can the new criteria be satisfied from data already cached on the client?
     * 
     *   This method can be used to determine whether TreeGrid.fetchData or
     *   TreeGrid.filterData will cause a server side fetch when passed a certain set of
     *   criteria.
     * 
     * 
     *  @param {Criteria} new criteria to test.
     */
    open fun willFetchData(newCriteria: dynamic): Boolean = definedExternally
    /**
     *   Returns a snapshot of the current open state of this tree's data as
     *   a TreeGridOpenState object.
     * 
     *   This object can be passed to ResultTree.setOpenState or
     *   TreeGrid.setOpenState to open the same set of folders
     *   within the tree's data (assuming the nodes are still present in the data).
     * 
     */
    open fun getOpenState(): String = definedExternally
    /**
     *   Reset the set of open folders within this tree's data to match the
     *   TreeGridOpenState object passed in.
     * 
     *   Used to restore previous state retrieved from the tree by a call to
     *   ResultTree.getOpenState.
     * 
     * 
     *  @param {TreeGridOpenState} Object describing the desired set of open folders.
     */
    open fun setOpenState(openState: String): Unit = definedExternally
    /**
     *   This callback fires whenever the resultTree receives new nodes from the server, after
     *   the new nodes have been integrated into the tree.
     * 
     * 
     *  @param {TreeNode} The parentNode for which children were just loaded
     */
    open fun dataArrived(parentNode: TreeNode): Unit = definedExternally
    companion object {
        /**
         *  Creates a new ResultTree
         * 
         *  @param typeCheckedProperties {Partial<ResultTree>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ResultTree} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ResultTree = definedExternally
    }
}