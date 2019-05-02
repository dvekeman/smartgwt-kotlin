@file:JsQualifier("isc")
package isc

/**
 *  A Tree is a data model representing a set of objects linked into a hierarchy.
 * 
 *   A Tree has no visual presentation, it is displayed by a TreeGrid or ColumnTree
 *   when supplied as TreeGrid.data or ColumnTree.data.
 * 
 *   A Tree can be constructed out of a List of objects interlinked by IDs or via explicitly
 *   specified Arrays of child objects. See Tree.modelType for an explanation of how
 *   to pass data to a Tree.
 * 
 *   Typical usage is to call TreeGrid.fetchData to cause automatic creation of a
 *   ResultTree, which is a type of Tree that automatically handles loading data on
 *   demand. For information on DataBinding Trees, see treeDataBinding.
 */
open external class Tree : Class, List {
    /**
     *  Selects the model used to construct the tree representation. See TreeModelType for
     *   the available options and their implications.
     * 
     *   If the "parent" modelType is used, you can provide the initial parent-linked data set to the
     *   tree via the Tree.data attribute. If the "children" modelType is used, you can
     *   provide the initial tree structure to the Tree via the Tree.root attribute.
     *  @type {TreeModelType}
     *  @default "children"
     */
    open var modelType: 
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
     *  Name of property that defines whether a node is a folder. By default this is set to
     *   TreeNode.isFolder.
     *  @type {string}
     *  @default "isFolder"
     */
    open var isFolderProperty: String = definedExternally
    /**
     *  Controls whether nodes are assumed to be folders or leaves by default.
     * 
     *   Nodes that have children or have the Tree.isFolderProperty set to true will be considered
     *   folders by default. Other nodes will be considered folders or leaves by default according
     *   to this setting.
     * 
     *   See also ResultTree.defaultIsFolder for more details on how
     *   defaultIsFolder interacts with
     *   TreeGrid.loadDataOnDemand.
     *  @type {boolean}
     *  @default null
     */
    open var defaultIsFolder: Boolean = definedExternally
    /**
     *  If new nodes are added to a tree with modelType:"parent" which have the same
     *   Tree.idField as existing nodes, the existing nodes are removed when
     *   the new nodes are added.
     * 
     *   If reportCollisions is true, the Tree will log a warning in the developer console about this.
     * 
     *   Note that if an id collision occurs between a new node and its ancestor, the ancestor will be
     *   removed and the new node will not be added to the tree.
     *  @type {boolean}
     *  @default true
     */
    open var reportCollisions: Boolean = definedExternally
    /**
     *  Specifies the delimiter between node names. The pathDelim is used to construct a unique
     *   path to each node. A path can be obtained for any node by calling
     *   Tree.getPath and can be used to find any node in the tree by calling
     *   Tree.find. Note that you can also hand-construct a path - in other words
     *   you are not required to call Tree.getPath in order to later use
     *   Tree.find to retrieve it.
     * 
     *   The pathDelim can be any character or sequence of characters, but must be a unique string
     *   with respect to the text that can appear in the Tree.nameProperty that's used
     *   for naming the nodes. So for example, if you have the following tree:
     * 
     *   one
     *    two
     *     three/four
     * 
     *   Then you will be unable to find the three/four node using
     *   Tree.find if your tree is using the default pathDelim of /.
     *   In such a case, you can use a different pathDelim for the tree. For example if you used |
     *   for the path delim, then you can find the three/four node in the tree above by
     *   calling tree.find("one|two|three/four").
     * 
     *   The pathDelim is used only by Tree.getPath and Tree.find and
     *   does not affect any aspect of the tree structure or other forms of tree navigation (such as
     *   via Tree.getChildren).
     *  @type {string}
     *  @default "/"
     */
    open var pathDelim: String = definedExternally
    /**
     *  Name of the property on a TreeNode that holds a name for the node that is unique
     *   among its immediate siblings, thus allowing a unique path to be used to identify the node,
     *   similar to a file system. Default value is "name". See TreeNode.name for usage.
     *  @type {string}
     *  @default "name"
     */
    open var nameProperty: String = definedExternally
    /**
     *  Name of the property on a TreeNode that holds the title of the node as it should be
     *   shown to the user. Default value is "title". See TreeNode.title for usage.
     *  @type {string}
     *  @default "title"
     */
    open var titleProperty: String = definedExternally
    /**
     *  Name of the property on a TreeNode that holds an id for the node which is unique
     *   across the entire Tree. Required for all nodes for trees with modelType "parent".
     *   Default value is "id". See TreeNode.id for usage.
     *  @type {string}
     *  @default "id"
     */
    open var idField: String = definedExternally
    /**
     *  For trees with modelType "parent", this property specifies the name of the property
     *   that contains the unique parent ID of a node. Default value is "parentId". See
     *   TreeNode.parentId for usage.
     *  @type {string}
     *  @default "parentId"
     */
    open var parentIdField: String = definedExternally
    /**
     *  For trees with the modelType "children", this property specifies the name of the property
     *   that contains the list of children for a node.
     *  @type {string}
     *  @default "children"
     */
    open var childrenProperty: String = definedExternally
    /**
     *  The property consulted by the default implementation of Tree.isOpen to determine if the
     *   node is open or not. By default, this property is auto-generated for you, but you can set
     *   it to a custom value if you want to declaratively specify this state, but be careful - if
     *   you display this Tree in multiple TreeGrids at the same time, the open state will not be
     *   tracked independently - see sharingNodes for more info on this.
     *  @type {string}
     *  @default null
     */
    open var openProperty: String = definedExternally
    /**
     *  Optional initial data for the tree. How this data is interpreted depends on this tree's
     *   Tree.modelType.
     * 
     *   If modelType is "parent", the list that you provide will be passed
     *   to Tree.linkNodes, integrating the nodes into the tree.
     * 
     *   In this case the root node may be supplied explicitly via Tree.root, or auto generated,
     *   picking up its id via Tree.rootValue. Any nodes in the data with no
     *   explicitly specified TreeNode.parentId will be added as children to this root element.
     * 
     *   To create this tree:
     * 
     *   foo
     *    bar
     *   zoo
     * 
     *   with modelType:"parent", you can do this:
     * 
     *   Tree.create({
     *    data: [
     *     {name: "foo", id: "foo"},
     *     {name: "bar", id: "bar", parentId: "foo"},
     *     {name: "zoo", id: "zoo"}
     *   });
     * 
     *   Or this (explicitly specified root):
     * 
     *   Tree.create({
     *    root: {id: "root"},
     *    data: [
     *     {name: "foo", id: "foo", parentId: "root"},
     *     {name: "bar", id: "bar", parentId: "foo"},
     *     {name: "zoo", id: "zoo", parentId: "root"}
     *   });
     * 
     *   Or this (explicitly specified rootValue):
     * 
     *   Tree.create({
     *    rootValue: "root",
     *    data: [
     *     {name: "foo", id: "foo", parentId: "root"},
     *     {name: "bar", id: "bar", parentId: "foo"},
     *     {name: "zoo", id: "zoo", parentId: "root"}
     *   });
     * 
     *   Specifying the root node explicitly allows you to give it a name, changing the way path
     *   derivation works (see Tree.root for more on naming the root node).
     * 
     *   For modelType:"children" trees, the data passed in will be assumed to be an
     *   array of children of the tree's root node.
     *  @type {Array<Partial<TreeNode>>}
     *  @default null
     */
    open var data: Array<dynamic> = definedExternally
    /**
     *  If you are using the "parent" modelType and did not specify a root node via Tree.root
     *   with an id (Tree.idField), then you can provide the root node's id via this property.
     *   See the example in Tree.data for more info.
     *  @type {string | number}
     *  @default null
     */
    open var rootValue: dynamic = definedExternally
    /**
     *  If you're using the "parent" modelType, you can provide the root node configuration via this
     *   property. If you don't provide it, one will be auto-created for you with an empty name.
     *   Read on for a description of what omitting the name property on the root node means for path
     *   derivation.
     * 
     *   If you're using the "children" modelType, you can provide the initial tree data via this
     *   property. So, for example, to construct the following tree:
     * 
     *   foo
     *    bar
     *   zoo
     * 
     *   You would initialize the tree as follows:
     * 
     * 
     *   Tree.create({
     *     root: { name:"root", children: [
     *       { name:"foo", children: [
     *         { name: "bar" }
     *       ]},
     *       { name: "zoo" }
     *     ]}
     *   });
     * 
     *   Note that if you provide a name property for the root node, then the path to
     *   any node underneath it will start with that name. So in the example above, the path to the
     *   bar node would be root/foo/bar (assuming you're using the default
     *   Tree.pathDelim. If you omit the name attribute on the root node, then its name
     *   is automatically set to the Tree.pathDelim value. So in the example above, if
     *   you omitted name:"root", then the path to the bar node would be
     *   /foo/bar.
     * 
     * 
     * 
     *   Note: if you initialize a Tree with no root value, a root node will be
     *   auto-created for you. You can then call Tree.add to construct the tree.
     *  @type {TreeNode}
     *  @default null
     */
    open var root: TreeNode = definedExternally
    /**
     *  If this tree has Tree.modelType, should nodes in the data array for the
     *   tree be dropped if they have an explicitly specified value for the Tree.parentIdField
     *   which doesn't match any other nodes in the tree. If set to false these nodes will be added as
     *   children of the root node.
     *  @type {boolean}
     *  @default false
     */
    open var discardParentlessNodes: Boolean = definedExternally
    /**
     *  Controls whether the implicit root node is returned as part of the visible tree,
     *   specifically, whether it is returned in Tree.getOpenList, which is the API view
     *   components typically use to get the list of visible nodes.
     * 
     *   Default is to have the root node be implicit and not included in the open list, which means
     *   that the visible tree begins with the children of root. This allows multiple nodes to
     *   appear at the top level of the tree.
     * 
     *   You can set showRoot:true to show the single, logical root node as the only
     *   top-level node. This property is only meaningful for Trees where you supplied a value for
     *   Tree.root, otherwise, you will see an automatically generated root node that is
     *   meaningless to the user.
     *  @type {boolean}
     *  @default false
     */
    open var showRoot: Boolean = definedExternally
    /**
     *  If true, the root node is automatically opened when the tree is created or
     *   Tree.setRoot is called.
     *  @type {boolean}
     *  @default true
     */
    open var autoOpenRoot: Boolean = definedExternally
    /**
     *  Should folders be sorted separately from leaves or should nodes be ordered according to
     *   their sort field value regardless of whether the node is a leaf or folder?
     *  @type {boolean}
     *  @default false
     */
    open var separateFolders: Boolean = definedExternally
    /**
     *  If Tree.separateFolders is true, should folders be displayed above or below leaves?
     *   When set to true folders will appear above leaves when the
     *   sortDirection applied to the tree is SortDirection
     *  @type {boolean}
     *  @default true
     */
    open var sortFoldersBeforeLeaves: Boolean = definedExternally
    /**
     *  Title assigned to nodes without a Tree.titleProperty value or a
     *   Tree.nameProperty value.
     *  @type {string}
     *  @default "Untitled"
     */
    open var defaultNodeTitle: String = definedExternally
    /**
     * 
     *   Return true if the passed node is the root node.
     * 
     * 
     *  @param {TreeNode} node to test
     */
    open fun isRoot(node: TreeNode): Boolean = definedExternally
    /**
     *   Adds an array of tree nodes into a Tree of Tree.modelType "parent".
     * 
     *   The provided TreeNodes must contain, at a minimum, a field containing a unique ID for the
     *   node (specified by Tree.idField) and a field containing the ID of the node's
     *   parent node (specified by Tree.parentIdField).
     * 
     *   This method handles receiving a mixture of leaf nodes and parent nodes, even out of order and
     *   with any tree depth.
     * 
     *   Nodes may be passed with the Tree.childrenProperty already populated with an Array of
     *   children that should also be added to the Tree, and this is automatically handled.
     * 
     * 
     *  @param {Array<Partial<TreeNode>>} list of nodes to link into the tree.
     */
    open fun linkNodes(nodes: Array<dynamic>): Unit = definedExternally
    /**
     * 
     *   Returns the root node of the tree.
     * 
     * 
     */
    open fun getRoot(): TreeNode = definedExternally
    /**
     * 
     *   Set the root node of the tree. Called automatically on this Tree during initialization
     *   and on the Tree returned from a call to duplicate().
     * 
     * 
     *  @param {TreeNode} new root node
     *  @param {boolean} set to true to automatically open the new root node.
     */
    open fun setRoot(newRoot: TreeNode, autoOpen: Boolean): Unit = definedExternally
    /**
     * 
     *   Get the 'name' of a node. This is node[Tree.nameProperty]. If that value has not
     *   been set on the node, a unique value (within this parent) will be auto-generated and
     *   returned.
     * 
     * 
     *  @param {TreeNode} node in question
     */
    open fun getName(node: TreeNode): String = definedExternally
    /**
     * 
     *   Return the title of a node -- the name as it should be presented to the user. This method
     *   works as follows:
     * 
     * 
     *  - If a Tree.titleProperty is set on the node, the value of that property is
     *   returned.
     * 
     *  - Otherwise, if the Tree.nameProperty is set on the node, that value is
     *   returned, minus any trailing Tree.pathDelim.
     * 
     *  - Finally, if none of the above yielded a title, the value of
     *   Tree.defaultNodeTitle is returned.
     * 
     *   You can override this method to return the title of your choice for a given node.
     * 
     *   To override the title for an auto-constructed tree (for example, in a databound TreeGrid),
     *   override TreeGrid.getNodeTitle instead.
     * 
     * 
     *  @param {TreeNode} node for which the title is being requested
     */
    open fun getTitle(node: TreeNode): String = definedExternally
    /**
     * 
     *   Returns the path of a node - a path has the following format:
     *   ([name][pathDelim]?)\*
     * 
     *   For example, in this tree:
     * 
     *   root
     *    foo
     *     bar
     * 
     *   Assuming that Tree.pathDelim is the default /, the bar
     *   node would have the path root/foo/bar and the path for the foo
     *   node would be root/foo.
     * 
     *   Once you have a path to a node, you can call find(path) to retrieve a reference to the node
     *   later.
     * 
     * 
     *  @param {TreeNode} node in question
     */
    open fun getPath(node: TreeNode): String = definedExternally
    /**
     * 
     *   Given a node, return the path to its parent. This works just like
     *   Tree.getPath except the node itself is not reported as part of the path.
     * 
     * 
     *  @param {TreeNode} node in question
     */
    open fun getParentPath(node: TreeNode): String = definedExternally
    /**
     * 
     *   Returns the parent of this node.
     * 
     * 
     *  @param {TreeNode} node in question
     */
    open fun getParent(node: TreeNode): Node = definedExternally
    /**
     * 
     *   Given a node, return an array of the node's parents with the immediate parent first. The
     *   node itself is not included in the result. For example, for the following tree:
     * 
     *   root
     *    foo
     *     bar
     * 
     *   Calling tree.getParents(bar) would return: [foo, root]. Note that
     *   the returned array will contain references to the nodes, not the names.
     * 
     * 
     *  @param {TreeNode} node in question
     */
    open fun getParents(node: TreeNode): Array<dynamic> = definedExternally
    /**
     * 
     *   Return the number of levels deep this node is in the tree. For example, for this tree:
     * 
     *   root
     *    foo
     *     bar
     * 
     *   Calling tree.getLevel(bar) will return 2.
     * 
     *   Note Tree.showRoot defaults to false so that multiple nodes can be shown at top level. In
     *   this case, the top-level nodes still have root as a parent, so have level 1, even though
     *   they have no visible parents.
     * 
     * 
     *  @param {TreeNode} node in question
     */
    open fun getLevel(node: TreeNode): Number = definedExternally
    /**
     * 
     *   Determines whether a particular node is a folder. The logic works as follows:
     * 
     * 
     *  - If the TreeNode has a value for the Tree.isFolderProperty
     *   (TreeNode.isFolder by default) that value is returned.
     * 
     *  - Next, the existence of the Tree.childrenProperty (by default
     *   TreeNode.children) is checked on the TreeNode. If the node has the children
     *   property defined (regardless of whether it actually has any children), then isFolder()
     *   returns true for that node.
     * 
     * 
     * 
     *   You can override this method to provide your own interpretation of what constitutes a folder.
     *   However, you cannot change the return value for a node after the associated folder is loaded.
     * 
     * 
     * 
     *  @param {TreeNode} node in question
     */
    open fun isFolder(node: TreeNode): Boolean = definedExternally
    /**
     * 
     *   Returns true if the passed in node is a leaf.
     * 
     * 
     *  @param {TreeNode} node in question
     */
    open fun isLeaf(node: TreeNode): Boolean = definedExternally
    /**
     * 
     *   Find the node with the specified ID. Specifically, it returns the node whose idField
     *   matches the id passed to this method. If the tree is using the "parent" modelType, this
     *   lookup will be constant-time. For all other modelTypes, the tree will be searched
     *   recursively.
     * 
     * 
     *  @param {string} ID of the node to return.
     */
    open fun findById(id: String): dynamic = definedExternally
    /**
     * 
     *   Find nodes within this tree using a string path or by attribute value(s).
     * 
     *   This method can be called with 1 or 2 arguments.
     * 
     *   If a single String argument is supplied, the value of the argument is treated as the path to the node. If a
     *   single argument of type Object is provided, it is treated as a set of field name/value
     *   pairs to search for (see List.find).
     * 
     *   If 2 arguments are supplied, this method will treat the first argument as a fieldName, and
     *   return the first node encountered where node[fieldName] matches the second
     *   argument. So for example, given this tree:
     * 
     *   foo
     *    zoo
     *     bar
     *    moo
     *     bar
     * 
     *   Assuming your Tree.pathDelim is the default / and foo
     *   is the name of the root node, then
     *   tree.find("foo/moo/bar") would return the bar node under the
     *   moo node.
     * 
     * 
     *   tree.find("name", "bar") would return the first bar node because
     *   it is the first one in the list whose name (default value of
     *   Tree.nameProperty) property matches the value
     *   bar. The two argument usage is generally more interesting when your tree nodes
     *   have some custom unique property that you wish to search on. For example if your tree nodes
     *   had a unique field called "UID", their serialized form would look something like this:
     * 
     *   { name: "foo", children: [...], UID:"someUniqueId"}
     * 
     *   You could then call tree.find("UID", "someUniqueId") to find that node. Note
     *   that the value doesn't have to be a string - it can be any valid value, but since this
     *   data generally comes from the server, the typical types are string, number, and boolean.
     *   Also note that a find() on the Tree.idField will be constant time, and that find() will
     *   not work on the idField if idField is set to a property that is not unique or not present
     *   on all nodes in the Tree.
     * 
     *   The usage where you pass a single object is interesting when your tree nodes have a number
     *   of custom properties that you want to search for in combination. Say your tree nodes had
     *   properties for "color" and "shape"; tree.find({color: "green", shape: "circle"})
     *   would return the first node in the tree where both properties matched.
     * 
     *   When searching by path, trailing path delimiters are ignored. So for example
     *   tree.find("foo/zoo/bar") is equivalent to
     *   tree.find("foo/zoo/bar/")
     * 
     * 
     *  @param {string} Either the path to the node to be found, or the name of                   a field which should match the value passed as a second                    parameter
     *  @param {any=} If specified, this is the desired value for the                  appropriate field
     */
    override fun find(propertyName: dynamic, value: dynamic?): dynamic = definedExternally
    /**
     *   Like List.findIndex, but operates only on the list of currently opened nodes. To search all loaded nodes
     *   open or closed, use Tree.findNodeIndex.
     * 
     * 
     *  @param {string | object | AdvancedCriteria} property to match, or if an Object is passed, set of                    properties and values to match
     *  @param {any=} value to compare against (if propertyName is a string)
     */
    override fun findIndex(propertyName: dynamic, value: dynamic?): Number = definedExternally
    /**
     *   Like Tree.findIndex, but searches all tree nodes regardless of their open/closed state.
     * 
     * 
     *  @param {string | object | AdvancedCriteria} property to match, or if an Object is passed, set of                    properties and values to match
     *  @param {any=} value to compare against (if propertyName is a string)
     */
    open fun findNodeIndex(propertyName: dynamic, value: dynamic?): Number = definedExternally
    /**
     *   Like Tree.findIndex, but inspects a range from startIndex to endIndex. Note
     *   that as in Tree.findIndex, only open nodes are included. To include both open and closed nodes, use
     *   Tree.findNextNodeIndex.
     * 
     * 
     *   For convenience, findNextIndex() may also be called with a function (called the predicate
     *   function) for the propertyName parameter. In this usage pattern, the predicate
     *   function is invoked for each value of the list until the predicate returns a true value.
     *   The predicate function is passed three parameters: the current value, the current index, and
     *   the list. The value of this when the predicate function is called is the
     *   value parameter. For example:
     *   var currentUserRecord = recordList.findNextIndex(0, function (record, i, recordList) {
     *    if (record.username == currentUsername && !record.accountDisabled) {
     *      return true;
     *    }
     *  });
     * 
     * 
     * 
     *  @param {Integer} first index to consider.
     *  @param {string | Function | object | AdvancedCriteria} property to match; or, if a function is passed, the predicate function to call; or, if an object is passed, set of properties and values to match.
     *  @param {any=} value to compare against (if propertyName is a string) or the value of this when the predicate function is invoked (if propertyName is a function)
     *  @param {Integer=} last index to consider (inclusive).
     */
    override fun findNextIndex(startIndex: Number, propertyName: dynamic, value: dynamic?, endIndex: Number?): Number = definedExternally
    /**
     *   Like Tree.findNextIndex, but includes both open and closed nodes.
     * 
     *  @param {Integer} first index to consider.
     *  @param {string | Function | object | AdvancedCriteria} property to match; or, if a function is passed, the predicate function to call; or, if an object is passed, set of properties and values to match.
     *  @param {any=} value to compare against (if propertyName is a string) or the value of this when the predicate function is invoked (if propertyName is a function)
     *  @param {Integer=} last index to consider (inclusive).
     */
    open fun findNextNodeIndex(startIndex: Number, propertyName: dynamic, value: dynamic?, endIndex: Number?): Number = definedExternally
    /**
     * 
     *   Returns all children of a node. If the node is a leaf, this method returns null.
     * 
     *   For databound trees the return value could be a ResultSet rather than a simple
     *   array - so it's important to access the return value using the List
     *   interface instead of as a native Javascript Array.
     * 
     *   The case that a ResultSet may be returned can only happen if the tree is a
     *   ResultTree and the ResultTree.fetchMode is set to "paged".
     * 
     * 
     * 
     * 
     *  @param {TreeNode} The node whose children you want to fetch.
     */
    open fun getChildren(node: TreeNode): Array<dynamic> = definedExternally
    /**
     *   Returns a ResultSet that provides access to any partially-loaded children of a node. If the
     *   node is a leaf, this method returns null.
     * 
     *  @param {TreeNode} The node whose children you want to fetch.
     */
    open fun getChildrenResultSet(node: TreeNode): ResultSet = definedExternally
    /**
     * 
     *   Returns all the first-level folders of a node.
     * 
     *   For load on demand trees (those that only have a partial representation client-side), this
     *   method will return only nodes that have already been loaded from the server.
     * 
     * 
     *  @param {TreeNode} node in question
     */
    open fun getFolders(node: TreeNode): List = definedExternally
    /**
     * 
     *   Return all the first-level leaves of a node.
     * 
     *   For load on demand trees (those that only have a partial representation client-side), this
     *   method will return only nodes that have already been loaded from the server.
     * 
     * 
     *  @param {TreeNode} node in question
     */
    open fun getLeaves(node: TreeNode): List = definedExternally
    /**
     * 
     *   Returns true if this node has any children.
     * 
     * 
     *  @param {TreeNode} node in question
     */
    open fun hasChildren(node: TreeNode): Boolean = definedExternally
    /**
     * 
     *   Return true if this this node has any children that are folders.
     * 
     * 
     *  @param {TreeNode} node in question
     */
    open fun hasFolders(node: TreeNode): Boolean = definedExternally
    /**
     * 
     *   Return whether this node has any children that are leaves.
     * 
     * 
     *  @param {TreeNode} node in question
     */
    open fun hasLeaves(node: TreeNode): Boolean = definedExternally
    /**
     *     Is one node a descendant of the other?
     * 
     * 
     *  @param {TreeNode} child node
     *  @param {TreeNode} parent node
     */
    open fun isDescendantOf(child: TreeNode, parent: TreeNode): Boolean = definedExternally
    /**
     * 
     *   Returns the list of all descendants of a node. Note: this method can be very slow,
     *   especially on large trees because it assembles a list of all descendants recursively.
     *   Generally, Tree.find in combination with Tree.getChildren will
     *   be much faster.
     * 
     *   For load on demand trees (those that only have a partial representation client-side), this
     *   method will return only nodes that have already been loaded from the server.
     * 
     * 
     *  @param {TreeNode=} node in question (the root node is assumed if none is specified)
     */
    open fun getDescendants(node: TreeNode?): List = definedExternally
    /**
     * 
     *   Returns the list of all descendants of a node that are folders. This works just like
     *   Tree.getDescendants, except leaf nodes are not part of the returned list.
     *   Like Tree.getDescendants, this method can be very slow for large trees.
     *   Generally, Tree.find in combination with Tree.getFolders
     *   will be much faster.
     * 
     *   For load on demand trees (those that only have a partial representation client-side), this
     *   method will return only nodes that have already been loaded from the server.
     * 
     * 
     *  @param {TreeNode=} node in question (the root node is assumed if none is specified)
     */
    open fun getDescendantFolders(node: TreeNode?): List = definedExternally
    /**
     * 
     *   Returns the list of all descendants of a node that are leaves. This works just like
     *   Tree.getDescendants, except folders are not part of the returned list.
     *   Folders are still recursed into, just not returned. Like Tree.getDescendants,
     *   this method can be very slow for large trees. Generally, Tree.find in
     *   combination with Tree.getLeaves will be much faster.
     * 
     *   For load on demand trees (those that only have a partial representation client-side), this
     *   method will return only nodes that have already been loaded from the server.
     * 
     * 
     *  @param {TreeNode=} node in question (the root node is assumed if none specified)
     */
    open fun getDescendantLeaves(node: TreeNode?): List = definedExternally
    /**
     * 
     *   Called when the structure of this tree is changed in any way. Intended to be observed.
     * 
     *   Note that on a big change (many items being added or deleted) this may be called multiple times
     * 
     * 
     */
    override fun dataChanged(): Unit = definedExternally
    override fun add(`object`: dynamic): dynamic = definedExternally
    /**
     * 
     *   Add a single node under the specified parent. See ResultTree
     *   when working with a ResultTree for limitations.
     * 
     * 
     *  @param {TreeNode} node to add
     *  @param {string | TreeNode} Parent of the node being added. You can pass                     in either the TreeNode itself, or a path to                     the node (as a String), in which case a                     Tree.find is performed to find                     the node.
     *  @param {number=} Position of the new node in the children list. If not                 specified, the node will be added at the end of the list.
     */
    open fun add(node: TreeNode, parent: dynamic, position: Number?): TreeNode = definedExternally
    /**
     * 
     *   Add a list of nodes to some parent. See ResultTree
     *   when working with a ResultTree for limitations.
     * 
     * 
     *  @param {Array<Partial<TreeNode>>} The list of nodes to add
     *  @param {string | TreeNode} Parent of the nodes being added. You can pass                     in either the TreeNode itself, or a path to                     the node (as a String), in which case a                     Tree.find is performed to find                     the node.
     *  @param {number=} Position of the new nodes in the children list. If not                 specified, the nodes will be added at the end of the list.
     */
    override fun addList(list: Array<dynamic>, listStartRow: Number?, listEndRow: Number?): List = definedExternally
    /**
     * 
     *   Moves the specified node to a new parent.
     * 
     * 
     *  @param {TreeNode} node to move
     *  @param {TreeNode} new parent to move the node to
     *  @param {Integer=} Position of the new node in the children list. If not                 specified, the node will be added at the end of the list.
     */
    open fun move(node: TreeNode, newParent: TreeNode, position: Number?): Unit = definedExternally
    /**
     * 
     *   Removes a node, along with all its children. See ResultTree
     *   when working with a ResultTree for limitations.
     * 
     * 
     *  @param {TreeNode} node to remove
     */
    override fun remove(obj: TreeNode): Boolean = definedExternally
    /**
     * 
     *   Remove a list of nodes (not necessarily from the same parent), and all children of those
     *   nodes. See ResultTree when working with a
     *   ResultTree for limitations.
     * 
     * 
     *  @param {Array<Partial<TreeNode>>} list of nodes to remove
     */
    override fun removeList(list: Array<dynamic>): List = definedExternally
    @JsName("removeList")
    open fun removeListBoolean(nodeList: Array<dynamic>): Boolean = definedExternally
    /**
     *   What is the loadState of a given folder?
     * 
     * 
     *  @param {TreeNode} folder in question
     */
    open fun getLoadState(node: TreeNode): 
                                           /**
                                            *  children have not been loaded and are not loading
                                            *  currently in the process of loading
                                            *  folders only are already loaded
                                            *  already fully loaded
                                            *  children form a ResultSet having only a partial      cache (applies only to the "paged"
                                            *        ResultTree.fetchMode)
                                            */
                                           String /* unloaded |  loading |  foldersLoaded |  loaded |  loadedPartialChildren */ = definedExternally
    /**
     *   For a databound tree, has this folder either already loaded its children or is it in the
     *   process of loading them.
     * 
     * 
     *  @param {TreeNode} folder in question
     */
    open fun isLoaded(node: TreeNode): Boolean = definedExternally
    /**
     *   For a databound tree, do the children of this folder form a ResultSet with a full cache.
     * 
     *   Note that this method only applies to ResultTree.fetchMode "paged".
     * 
     *  @param {TreeNode} folder in question
     */
    open fun allChildrenLoaded(node: TreeNode): Boolean = definedExternally
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
    open fun loadChildren(node: TreeNode, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?)): Unit = definedExternally
    /**
     *   Unload the children of a folder, returning the folder to the "unloaded" state.
     * 
     * 
     *  @param {TreeNode} folder in question
     *  @deprecated \* It's recommended that you instead use Tree.reloadChildren to reload the children of a folder, or Tree.removeChildren if you need to clear the cached children
     *   of a folder to add specific local data.
     */
    open fun unloadChildren(node: TreeNode): Unit = definedExternally
    /**
     *   Reload the children of a folder.
     * 
     * 
     *  @param {TreeNode} node in question
     */
    open fun reloadChildren(node: TreeNode): Unit = definedExternally
    /**
     *   Removes all children of the node and sets it to a loaded state. For non-ResultTrees,
     *   or non-ResultTree.fetchMode ResultTrees, Tree.add or
     *   Tree.addList can then be used to provide new children. For
     *   ResultTree.fetchMode ResultTrees, DataSource.updateCaches
     *   must be used to insert nodes into the cache as local data, since such
     *   ResultTrees are considered read-only, and Tree.add and Tree.addList are
     *   not perrmitted.
     * 
     * 
     *  @param {TreeNode} folder in question
     */
    open fun removeChildren(node: TreeNode): Unit = definedExternally
    /**
     *   Replaces the existing children of a parent node, leaving the node in the loaded state.
     *   Only a flat list of children nodes is supported, as in Tree.addList.
     * 
     * 
     *  @param {TreeNode} parent of children
     *  @param {Array<Partial<TreeNode>>} children to be set
     */
    open fun setChildren(parent: TreeNode, newChildren: Array<dynamic>): Unit = definedExternally
    /**
     * 
     *   Whether a particular node is open or closed (works for leaves and folders).
     * 
     * 
     *  @param {TreeNode} node in question
     */
    open fun isOpen(node: TreeNode): Boolean = definedExternally
    /**
     * 
     *   Open a particular node
     * 
     * 
     *  @param {TreeNode} node to open
     *  @param {Callback=} Optional callback (stringMethod) to fire when loading            completes. Has a single param node - the node whose            children have been loaded, and is fired in the scope of the Tree.
     */
    open fun openFolder(node: TreeNode, callback: dynamic?): Unit = definedExternally
    /**
     * 
     *   Open a set of folders, specified by path or as pointers to nodes.
     * 
     * 
     *  @param {Array<Partial<TreeNode>>} List of nodes or node paths.
     */
    open fun openFolders(nodeList: Array<dynamic>): Unit = definedExternally
    /**
     * 
     *   Closes a folder
     * 
     * 
     *  @param {TreeNode} folder to close
     */
    open fun closeFolder(node: TreeNode): Unit = definedExternally
    /**
     * 
     *   Close a set of folders, specified by path or as pointers to nodes.
     * 
     * 
     *  @param {Array<Partial<TreeNode>>} List of nodes or node paths.
     */
    open fun closeFolders(nodeList: Array<dynamic>): Unit = definedExternally
    /**
     * 
     *   Open all nodes under a particular node.
     * 
     * 
     *  @param {TreeNode=} node from which to open folders (if not specified, the root               node is used)
     */
    open fun openAll(node: TreeNode?): Unit = definedExternally
    /**
     *   Close all nodes under a particular node
     * 
     * 
     *  @param {TreeNode=} node from which to close folders (if not specified, the root               node is used)
     */
    open fun closeAll(node: TreeNode?): Unit = definedExternally
    /**
     *   Setter for Tree.showRoot.
     * 
     *  @param {boolean} new showRoot value
     */
    open fun setShowRoot(showRoot: Boolean): Unit = definedExternally
    /**
     *   Setter for Tree.separateFolders.
     * 
     *  @param {boolean} new separateFolders value
     */
    open fun setSeparateFolders(separateFolders: Boolean): Unit = definedExternally
    /**
     *   Setter for Tree.sortFoldersBeforeLeaves.
     * 
     *  @param {boolean} new sortFoldersBeforeLeaves value
     */
    open fun setSortFoldersBeforeLeaves(sortFoldersBeforeLeaves: Boolean): Unit = definedExternally
    /**
     *   Return a flattened list of all nodes that are visible under some parent based on whether the node
     *   itself or any folders underneath it are open. Returned list will include the passed node.
     * 
     *   If the passed in node is a leaf, this method returns null.
     * 
     * 
     *  @param {TreeNode=} node in question
     */
    open fun getOpenList(node: TreeNode?): Array<dynamic> = definedExternally
    /**
     *   Get all the nodes that exist in the tree under a particular node, as a flat list, in
     *   depth-first traversal order.
     * 
     * 
     *  @param {TreeNode=} optional node to start from. Default is root.
     */
    open fun getAllNodes(node: TreeNode?): Array<dynamic> = definedExternally
    /**
     * 
     *   Returns the number of items in the current open list.
     * 
     * 
     */
    override fun getLength(): Number = definedExternally
    /**
     *   Return the position in the list of the first instance of the specified object.
     * 
     *   If pos is specified, starts looking after that position.
     * 
     *   Returns -1 if not found.
     * 
     * 
     *  @param {any} object to look for
     *  @param {number=} earliest index to consider
     *  @param {number=} last index to consider
     */
    override fun indexOf(obj: dynamic, pos: Number?, endPos: Number?): Number = definedExternally
    /**
     *   Return the position in the list of the last instance of the specified object.
     * 
     *   If pos is specified, starts looking before that position.
     * 
     *   Returns -1 if not found.
     * 
     * 
     *  @param {any} object to look for
     *  @param {number=} last index to consider
     *  @param {number=} earliest index to consider
     */
    override fun lastIndexOf(obj: dynamic, pos: Number?, endPos: Number?): Number = definedExternally
    /**
     *   Filters this tree by the provided criteria, returning a new Tree containing just the nodes
     *   that match the criteria.
     * 
     *   If filterMode is "keepParents", parents are retained if
     *   any of their children match the criteria even if those parents do not match the criteria.
     * 
     * 
     *  @param {Criteria | AdvancedCriteria} criteria to filter by
     *  @param {TreeFilterMode=} mode to use for filtering, defaults to "strict"
     *  @param {DataSource=} dataSource to use for filtering, if this Tree does not                 already have one
     *  @param {DSRequest=} Request properties block. This allows developers to specify properties that would impact the filter such as DSRequest.textMatchStyle
     */
    open fun getFilteredTree(criteria: dynamic, filterMode: 
                                                            /**
                                                             *  only nodes that actually match criteria are shown. If a parent does not         match the criteria, it will not be shown, even if it has children that do
                                                             *           match the criteria
                                                             *  parent nodes are kept if they have children which match the criteria,           or, in a tree with
                                                             *             ResultTree.loadDataOnDemand, if they have
                                                             *             not loaded children yet.
                                                             */
                                                            String /* strict |  keepParents */?, dataSource: DataSource?, requestProperties: DSRequest?): Tree = definedExternally
    /**
     *   Return the item at a particular position
     * 
     *  @param {number} position of the element to get
     */
    override fun get(pos: Number): dynamic = definedExternally
    /**
     *   Return whether or not this array is empty
     * 
     * 
     */
    override fun isEmpty(): Boolean = definedExternally
    /**
     *   Return the first item in this list
     * 
     * 
     */
    override fun first(): dynamic = definedExternally
    /**
     *   Return the last item in this list
     * 
     * 
     */
    override fun last(): dynamic = definedExternally
    /**
     *   Find all objects where property == value in the object.
     * 
     *   Pass an Object as the propertyName argument to match multiple properties.
     * 
     * 
     *  @param {string | object | AdvancedCriteria} property to match, or if an Object is passed, set of                    properties and values to match
     *  @param {any=} value to compare against (if propertyName is a string)
     */
    override fun findAll(propertyName: dynamic, value: dynamic?): Array<dynamic> = definedExternally
    /**
     *   Return if this list contains the specified object.
     * 
     *   If pos is specified, starts looking after that position.
     * 
     * 
     *  @param {any} item to look for
     *  @param {number=} optional position in the list to look after
     */
    override fun contains(obj: dynamic, pos: Number?): Boolean = definedExternally
    /**
     *   Return whether this list contains all the item in the specified list.
     * 
     * 
     *  @param {List} items to look for
     */
    override fun containsAll(list: List): Boolean = definedExternally
    /**
     *   Return the list of items that are in both this list and the passed-in list(s).
     * 
     * 
     *  @param {any} lists to intersect with
     */
    override fun intersect(lists: dynamic): List = definedExternally
    /**
     *   Return whether this list is equal to another list.
     * 
     *   Two lists are equal only if they have the same length and all contained items are in the same
     *   order and are also equal.
     * 
     * 
     *  @param {List} list to check for equality
     */
    override fun equals(list: List): Boolean = definedExternally
    /**
     *   Return the items at a list of specified positions.
     * 
     * 
     *  @param {Array<Partial<number>>} array of positions
     */
    override fun getItems(itemList: Array<dynamic>): Array<dynamic> = definedExternally
    /**
     *   Return the items between position start and end, non-inclusive at the end.
     * 
     * 
     *  @param {number} start position
     *  @param {number} end position
     */
    override fun getRange(start: Number, end: Number): Array<dynamic> = definedExternally
    /**
     *   Return an Array that is a shallow copy of the list, that is, containing the same items.
     * 
     * 
     */
    override fun duplicate(): Array<dynamic> = definedExternally
    /**
     *   Change the array element at a particular position.
     * 
     *   set() can be used to expand the length of the list.
     * 
     * 
     *  @param {number} position in the list to change
     *  @param {object} new value for that position
     */
    override fun set(pos: Number, obj: dynamic): dynamic = definedExternally
    /**
     *   Add a single item to this array at a specific position in the list, sliding other items over
     *   to fit.
     * 
     * 
     *  @param {object} object to add
     *  @param {number} position in the list to add at
     */
    override fun addAt(obj: dynamic, pos: Number): dynamic = definedExternally
    /**
     *   Remove the item at the specified position, rearranging all subsequent items to fill the gap
     * 
     * 
     *  @param {number} position to remove
     */
    override fun removeAt(pos: Number): dynamic = definedExternally
    /**
     *   Set the length of this list.
     * 
     *   If the length of the list is shortened, any elements past the new length of the list are removed.
     *   If the length is increased, all positions past the old length have the value
     *   undefined.
     * 
     * 
     *  @param {number} new length
     */
    override fun setLength(length: Number): Unit = definedExternally
    /**
     *   Add list of items list to this array at item pos. All items after array[pos] will slide down to
     *   fit new items.
     * 
     * 
     *  @param {Array<any>} new array of items
     *  @param {number} position in this list to put the new items
     */
    override fun addListAt(list: Array<dynamic>, pos: Number): Array<dynamic> = definedExternally
    /**
     *   Sorts the elements of the List in place.
     * 
     *   The optional comparator function should take two parameters "a" and "b" which are the two list
     *   items to compare, and should return:
     * 
     * 
     *  - a value less than zero, if "a" is less than "b" such that "a" should appear earlier in the
     *     list
     * 
     *  - zero, if "a" and "b" are equal
     * 
     *  - a value greater than zero, if "a" is greater than "b" such that "b" should appear earlier in
     *     the list
     * 
     * 
     * 
     *  @param {Function=} comparator function to use
     */
    override fun sort(comparator: (() -> dynamic?)): List = definedExternally
    /**
     *   Return a new Array where the value of item i is the value of "property" of item i in this
     *   array. If an item doesn't have that property or is null, return item will be null.
     * 
     * 
     *  @param {string} name of the property to look for
     */
    override fun getProperty(property: String): Array<dynamic> = definedExternally
    /**
     *   Sort a list of objects by a given property of each item.
     * 
     *   The optional normalizer, if passed as a function, is called for each item in the List, and
     *   should return whatever value should be used for sorting, which does not have to agree with
     *   the property value. By passing a normalizer function you can achieve any kind of sorting
     *   you'd like, including sorting by multiple properties.
     * 
     *   NOTE: string sort is case INsensitive by default
     * 
     * 
     *  @param {string} name of the property to sort by
     *  @param {boolean} true == sort ascending, false == sort descending
     *  @param {Function | ValueMap=} May be specified as a function, with signature        normalize(item, propertyName, context), where item is        a pointer to the item in the array, propertyName is the        property by which the array is being sorted, and context is the        arbitrary context passed into this method. Normalizer function should return        the value normalized for sorting.        May also be specified as a ValueMap which maps property values to sortable values.
     *  @param {any=} Callers may pass an arbitrary context into the sort method, which             will then be made available to the normalizer function
     */
    override fun sortByProperty(property: String, up: Boolean, normalizer: dynamic?, context: dynamic?): List = definedExternally
    /**
     *   Get a map of the form { item[idField] -&gt; item[displayField] }, for all
     *   items in the list. Note that if more than one item has the same idProperty,
     *   the value for the later item in the list will clobber the value for the earlier item.
     * 
     * 
     *  @param {string} Property to use as ID (data value) in the valueMap
     *  @param {string} Property to use a display value in the valueMap
     */
    override fun getValueMap(idField: String, displayField: String): dynamic = definedExternally
    companion object {
        /**
         *  A declared value of the enum type
         *   LoadState.
         *  @type {Constant}
         *  @default "unloaded"
         */
        var UNLOADED: String = definedExternally
        /**
         *  A declared value of the enum type
         *   LoadState.
         *  @type {Constant}
         *  @default "loading"
         */
        var LOADING: String = definedExternally
        /**
         *  A declared value of the enum type
         *   LoadState.
         *  @type {Constant}
         *  @default "foldersLoaded"
         */
        var FOLDERS_LOADED: String = definedExternally
        /**
         *  A declared value of the enum type
         *   LoadState.
         *  @type {Constant}
         *  @default "loaded"
         */
        var LOADED: String = definedExternally
        /**
         *  A declared value of the enum type
         *   LoadState.
         *  @type {Constant}
         *  @default "loadedPartialChildren"
         */
        var LOADED_PARTIAL_CHILDREN: String = definedExternally
        /**
         *  Creates a new Tree
         * 
         *  @param typeCheckedProperties {Partial<Tree>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Tree} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Tree = definedExternally
        /**
         *   heuristically find a property that appears to contain child objects.
         *   Searches through a node and find a property that is either Array or Object valued.
         * 
         * 
         *  @param {TreeNode} the node to check
         *  @param {ChildrenPropertyMode} determines how to chose the property that appears to contain child objects
         */
        fun findChildrenProperty(node: TreeNode, mode: 
                                                       /**
                                                        *  assume the first object or array value we find is the children property
                                                        *  assume the first array we find is the children property, no matter the contents
                                                        *  assume the first object or array of objects we find is the children property     (don't allow arrays that don't have objects)
                                                        *  accept only an array of objects as the children property
                                                        */
                                                       String /* any |  array |  object |  objectArray */): String = definedExternally
        /**
         *   given a hierarchy of objects with children under mixed names, heuristically discover the
         *   property that holds children and copy it to a single, uniform childrenProperty. Label each
         *   discovered child with a configurable "typeProperty" set to the value of the property
         *   that held the children.
         * 
         * 
         *  @param {Array<Partial<TreeNode>>} list of nodes to link into the tree.
         *  @param {DiscoverTreeSettings} configures how the tree will be explored
         * \* @param {string} 
         */
        fun discoverTree(nodes: Array<dynamic>, settings: DiscoverTreeSettings, parentChildrenField: String): Unit = definedExternally
    }
}