@file:JsQualifier("isc")
package isc

/**
 *  The SmartClient system supports hierarchical data (also referred to as tree data
 *   due to its "branching" organization) with:
 * 
 * 
 *  - the Tree class, which manipulates hierarchical data sets
 * 
 *  - the TreeGrid widget class, which extends the ListGrid class to visually
 *      present tree data in an expandable/collapsible format.
 * 
 *   For information on DataBinding Trees, see treeDataBinding.
 * 
 *   A TreeGrid works just like a ListGrid, except one column (specified by
 *   TreeGridField.treeField) shows a hierarchical Tree. A TreeGrid is not limited
 *   to displaying just the Tree column - you can define additional columns (via
 *   TreeGrid.fields) which will render just like the columns of a ListGrid, and
 *   support all of the functionality of ListGrid columns, such as
 *   ListGridField.formatCellValue.
 * 
 *   Except where explicitly overridden, ListGrid methods, callbacks, and properties
 *   apply to TreeGrids as well. The ListGrid defines some methods as taking/returning
 *   ListGridField and ListGridRecord. When using those methods in a TreeGrid,
 *   those types will be TreeGridField and TreeNode, respectively.
 */
open external class TreeGrid : ListGrid, DataBoundComponent {
    /**
     *  The DataSource that this component should bind to for default fields and for performing
     *   DSRequest.
     * 
     *   Can be specified as either a DataSource instance or the String ID of a DataSource.
     *  @type {DataSource | GlobalId}
     *  @default null
     */
    override var dataSource: dynamic = definedExternally
    /**
     *  A Tree object containing of nested TreeNodes to
     *   display as rows in this TreeGrid.
     *   The data property will typically not be explicitly specified for
     *   databound TreeGrids, where the data is returned from the server via databound component
     *   methods such as fetchData()
     *  @type {Tree}
     *  @default null
     */
    override var data: Array<dynamic> = definedExternally
    /**
     *  You can specify the initial set of data for a databound TreeGrid using this property.
     *   The value of this attribute should be a list of parentId-linked
     *   TreeNodes in a format equivalent to that documented on Tree.data or, for
     *   TreeGrids with TreeGrid.dataFetchMode set to
     *   FetchMode, on ResultTree.data.
     * 
     *   If you create a standalone Tree or ResultTree as the
     *   TreeGrid's TreeGrid.data then you may equivalently specify this initial set
     *   of tree nodes in that tree's Tree.data property.
     *  @type {Array<Partial<TreeNode>>}
     *  @default null
     */
    open var initialData: Array<dynamic> = definedExternally
    /**
     *  For databound treeGrid instances, should the entire tree of data be loaded on initial
     *   fetch, or should folders load their children as they are opened.
     * 
     *   If unset, calling TreeGrid.fetchData will default it to true, otherwise, if a ResultTree
     *   is passed to TreeGrid.setData, the ResultTree.loadDataOnDemand setting is
     *   respected. Must be enabled on the underlying ResultTree when using
     *   TreeGrid.dataFetchMode: "paged".
     * 
     *   Note that when using loadDataOnDemand, every node returned by the server is
     *   assumed be a folder which may load further children. See
     *   ResultTree.defaultIsFolder for how to control this behavior.
     *  @type {boolean}
     *  @default null
     */
    open var loadDataOnDemand: Boolean = definedExternally
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
     *   with TreeGrid.loadDataOnDemand:true, will always load all nodes under a given parent.
     *   This means that the server does not need to implement special tree filtering logic.
     * 
     *   Optionally, ResultTree.serverFilterFields can be set to a list of field names that
     *   will be sent to the server whenever they are present in the criteria.
     *  @type {boolean}
     *  @default null
     */
    open var keepParentsOnFilter: Boolean = definedExternally
    /**
     *  Mode of fetching records from server.
     * 
     *   fetchMode:"local" implies that local filtering will always be performed. See
     *   TreeGrid.keepParentsOnFilter for additional filtering details.
     * 
     *   fetchMode:"basic" or "paged" implies that if search criteria change, the entire
     *   tree will be discarded and re-fetched from the server. When retrieving the replacement
     *   tree data, the default behavior will be to preserve the TreeGrid.getOpenState
     *   for any nodes that the server returns which were previously opened by the user. Note
     *   that this implies that if TreeGrid.loadDataOnDemand is enabled and the server returns only
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
    override var dataFetchMode: 
                                /**
                                 *  All records that match the current filter are fetched. Sorting is        performed on the client.
                                 *  Only requested ranges of records are fetched, with predictive fetch        ahead. Sorting is performed on the server.
                                 *  All records available from the DataSource are fetched. Filtering by        search criteria and sorting are both performed on the client.
                                 */
                                String /* basic |  paged |  local */ = definedExternally
    /**
     *  When TreeGrid.keepParentsOnFilter is enabled for FetchMode
     *   ResultTrees, this property lists field names that will be sent to the server if they
     *   are present in the criteria.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var serverFilterFields: Array<dynamic> = definedExternally
    /**
     *  With TreeGrid.loadDataOnDemand:true, TreeGrids fetch data by selecting the child nodes of
     *   each parent, which should be exact match, so we default to
     *   autoFetchTextMatchStyle:"exact" when autoFetchData is true.
     * 
     *   See ListGrid.autoFetchTextMatchStyle for details.
     *  @type {TextMatchStyle}
     *  @default "exact"
     */
    override var autoFetchTextMatchStyle: 
                                          /**
                                           *  case-insensitive exact match ("foo" matches "foo" and "FoO", but not "FooBar")
                                           *  case-sensitive exact match ("foo" matches only "foo")
                                           *  case-insenstive substring match ("foo" matches "foobar" and "BarFoo")
                                           *  case-insensitive prefix match ("foo" matches "FooBar" but not "BarFoo")
                                           *   textMatchStyle behavior is consistent across the client and all three of the built-in
                                           *   server DataSource implementations - SQL, Hibernate and JPA - to the maximum extent that is
                                           *   practical. Known inconsistencies, some of which can be tweaked with configuration settings,
                                           *   are described below
                                           * 
                                           *  - textMatchStyle can be disabled for any individual field with the
                                           *   DataSourceField.ignoreTextMatchStyle declaration. This behavior is consistent
                                           *   across client and server implementations, with the proviso that case-sensitive behavior
                                           *   is inherently inconsistent in the server-side implementations (see below for a more
                                           *   detailed discussion of this)
                                           * 
                                           *  - textMatchStyle is forced to "exactCase" for DataSourceField.primaryKey
                                           *   fields on update and remove operations, unless
                                           *   OperationBinding.allowMultiUpdate is in force. This means that a normal update
                                           *   or remove operation - which is constrained by a unique primaryKey value or combination, to
                                           *   affect only a single data row - will use an equality match on all primaryKey fields. This
                                           *   is desirable because it makes index usage more likely. Note that this means the key values
                                           *   "foo" and "FOO" are distinct, which is a change from previous behavior. For most databases,
                                           *   this change will have no effect because most databases do not by default allow primaryKey
                                           *   values that only differ in case anyway - if a table has a row with a PK of "foo" and you
                                           *   try to insert a row with a PK of "FOO", most databases will fail with a constraint violation.
                                           *   However, if you are using a database hat allows key values that differ only in case, and you
                                           *   need to support this for some reason, you can switch the framework back to the previous
                                           *   behavior by setting property allow.case.sensitive.pks to true in
                                           *   your server.properties file. Note, we do not recommend this; in fact, we do
                                           *   not recommend the use of text primaryKey fields at all. Where you have control ,we would
                                           *   always recommend the use of automatically incrementing numeric sequence keys.
                                           * 
                                           *  - textMatchStyle does not apply to boolean or temporal (date, datetime, time)
                                           *   DataSourceField.type. Such fields are always checked for equality. If
                                           *   you have a need for more complex matching, such as date-range checking, use AdvancedCriteria
                                           * 
                                           *  - Critiera values for temporal fields must be real dates (Javascript Date
                                           *   objects on the client, instances of java.util.Date on the server). Attempting
                                           *   to match against a string or any other type of value will result in an "always fails"
                                           *   clause being generated. This behavior is how the client code has always worked, but is a
                                           *   change for the server-side DataSources, in the interests of consistency. The previous
                                           *   behavior was:
                                           * 
                                           *  - SQLDataSource used to attempt to match the date column to the criteria value provided;
                                           *    if that value was an appropriately-formatted string, that attempt might have
                                           *    worked, but it would be database-specific. If you have an application that depends on
                                           *    this old behavior, you can switch it back on by adding the following to your
                                           *    server.properties file:
                                           *    sql.temporal.fields.require.date.criteria: false
                                           * 
                                           *  - HibernateDataSource and JPADataSource used to skip such clauses altogether, which
                                           *    results in the opposite behavior (there is an implied "always succeeds" clause, because
                                           *    the clause is not present in the query at all). If you have an application that depends on
                                           *    this old behavior, you can switch it back on by adding the following to your
                                           *    server.properties file:
                                           *    jpa.temporal.fields.require.date.criteria: false or
                                           *    hibernate.temporal.fields.require.date.criteria: false, as appropriate
                                           * 
                                           * 
                                           *  - textMatchStyle does not apply to fields used in the joins generated to satisfy
                                           *   DataSourceField.includeFrom declarations or entity relations in
                                           *   Hibernate or JPA. Again, such comparisons are always for equality
                                           * 
                                           *  - textMatchStyle is applied to numeric fields only if the supplied criteria value
                                           *   is a string. So for a numeric field "myNumber", we will match 10, 100, 110 and 1000 if a
                                           *   criteria value of "10" (the quoted string) is supplied, but we will only match 10 if a
                                           *   criteria value of 10 (the actual number) is supplied
                                           * 
                                           *  - This is a change in behavior for the server-side DataSource implementations, in the
                                           *    interests of consistency with the client behavior. Previously, all three of the built-in
                                           *    DataSource implementations applied textMatchStyle to numeric fields regardless of the
                                           *    criteria value's type. If you have an application that depends on this old behavior,
                                           *    you can switch it back on by adding the following to your server.properties
                                           *    file: sql.substring.numeric.criteria: true or
                                           *    hibernate.substring.numeric.criteria: true or
                                           *    jpa.substring.numeric.criteria: true, as appropriate
                                           * 
                                           * 
                                           *  - "exactCase" matching cannot be made consistent across all database providers because
                                           *   each database has its own idea of whether case-sensitive matching should be the default,
                                           *   and how to switch it on and off (if that is even possible)
                                           * 
                                           *  - Microsoft SQL Server must have case-sensitive matching enabled by setting a
                                           *    case-sensitive collation when the database is created (there are more fine-grained
                                           *    options, but we do not recommend them because of the scope for further inconsistency,
                                           *    where "exactCase" works correctly on table A but not on table B). See
                                           *    MSDN for details
                                           * 
                                           *  - HSQLDB has case sensitivity set with the SET IGNORECASE directive -
                                           *    see here
                                           * 
                                           *  - MySQL is case-insensitive, but since it provides an easy way to do per-query,
                                           *    case-sensitive matching in SQL, we work around it for that database, but only in
                                           *    SQL DataSources
                                           * 
                                           * 
                                           *  - If you are using Hibernate or JPA, whether "exactCase" works as expected depends
                                           *   entirely on the underlying database. Unlike the SQL DataSource, where we have fine-grained
                                           *   control of the SQL that the database executes, we are constrained by what the ORM will
                                           *   allow. This prevents us from compensating for database quirks, like we do with MySQL's
                                           *   case-insensitivity in the SQL DataSource
                                           * 
                                           */
                                          String /* exact |  exactCase |  substring |  startsWith */ = definedExternally
    /**
     *  Should children be selected when parent is selected? And should parent be
     *   selected when any child is selected?
     *  @type {boolean}
     *  @default false
     */
    open var cascadeSelection: Boolean = definedExternally
    /**
     *  Should partially selected parents be shown with special icon?
     *  @type {boolean}
     *  @default false
     */
    override var showPartialSelection: Boolean = definedExternally
    /**
     *  If specified, the selection object for this list will use this property to mark records
     *   as selected. In other words, if this attribute were set to "isSelected"
     *   any records in the listGrid data where "isSelected" is true
     *   will show up as selected in the grid. Similarly if records are selected within the grid
     *   after the grid has been created, this property will be set to true on the selected
     *   records.
     *  @type {string}
     *  @default null
     */
    override var selectionProperty: String = definedExternally
    /**
     *  This property is not supported on TreeGrid, and only applies to the ListGrid
     *   superclass.
     *  @type {boolean}
     *  @default null
     */
    override var canSelectAll: Boolean = definedExternally
    /**
     *  For databound trees, use this attribute to supply a DataSourceField.rootValue for this
     *   component's generated data object.
     * 
     *   This property allows you to have a particular component navigate a tree starting from any
     *   given node as the root.
     *  @type {any}
     *  @default null
     */
    open var treeRootValue: dynamic = definedExternally
    /**
     *  An array of field objects, specifying the order, layout, dynamic calculation, and
     *   sorting behavior of each field in the treeGrid object. In TreeGrids, the fields
     *   array specifies columns. Each field in the fields array is TreeGridField object.
     * 
     *   If TreeGrid.dataSource is also set, this value acts as a set of overrides as
     *   explained in DataBoundComponent.fields.
     *  @type {Array<Partial<TreeGridField>>}
     *  @default null
     */
    override var fields: Array<dynamic> = definedExternally
    /**
     *  Visible title for the tree column (field).
     *  @type {string}
     *  @default "Name"
     */
    open var treeFieldTitle: String = definedExternally
    /**
     *  Specifies whether the root node should be displayed in the treeGrid.
     * 
     *   This property is only available for "children" modelType trees, hence is not allowed for
     *   trees that load data from the server dynamically via TreeGrid.fetchData.
     * 
     *   To get the equivalent of a visible "root" node in a tree that loads data dynamically,
     *   add a singular, top-level parent to the data. However, note that this top-level parent
     *   will technically be the only child of root, and the implicit root object will be
     *   returned by Tree.getRoot.
     *  @type {boolean}
     *  @default false
     */
    open var showRoot: Boolean = definedExternally
    /**
     *  If specified, this attribute will override Tree.separateFolders on the
     *   data for this treeGrid.
     * 
     *   Specifies whether folders and leaves should be segregated in the treeGrid display.
     *   Use Tree.sortFoldersBeforeLeaves to customize whether folders appear before
     *   or after their sibling leaves.
     * 
     *   If unset, at the treeGrid level, the property can be set directly on
     *   TreeGrid.data or for dataBound TreeGrids on the
     *   TreeGrid.dataProperties.
     *  @type {boolean}
     *  @default null
     */
    open var separateFolders: Boolean = definedExternally
    /**
     *  For a TreeGrid that uses a DataSource, these properties will be passed to
     *   the automatically-created ResultTree. This can be used for various customizations such as
     *   modifying the automatically-chosen Tree.parentIdField.
     *  @type {Tree}
     *  @default null
     */
    override var dataProperties: ResultSet = definedExternally
    /**
     *  If specified, this attribute will override Tree.sortFoldersBeforeLeaves on
     *   the data for this treeGrid.
     * 
     *   Specifies whether when Tree.separateFolders is true, folders should be displayed
     *   before or after their sibling leaves in a sorted tree. If set to true, with
     *   sortDirection set to Array.ASCENDING, folders are displayed before their sibling leaves
     *   and with sort direction set to Array.DESCENDING they are displayed after. To invert
     *   this behavior, set this property to false.
     *  @type {boolean}
     *  @default null
     */
    open var sortFoldersBeforeLeaves: Boolean = definedExternally
    /**
     *  Specifies the type of nodes displayed in the treeGrid.
     *  @type {DisplayNodeType}
     *  @default null
     */
    open var displayNodeType: 
                              /**
                               *  operate on both folders and leaves
                               *  operate on folders only, ignoring leaves
                               *  operate on leaves only, ignoring folders
                               */
                              String /* null/unset |  folders |  leaves */ = definedExternally
    /**
     *  For dataBound treeGrids this specifies the ResultTree.autoPreserveOpenState,
     *   governing whether the open state of the tree should be preserved when new data
     *   arrives due to cache invalidation.
     *  @type {PreserveOpenState}
     *  @default null
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
     *  Indicates whether records can be dragged from this listGrid and dropped elsewhere.
     * 
     *   NOTE: If canDragRecordsOut is initially enabled or might be
     *   dynamically enabled after the grid is created, it may be desirable to disable
     *   Canvas.useTouchScrolling so that touch-dragging a record starts
     *   a drag operation rather than a scroll. If Canvas.disableTouchScrollingForDrag
     *   is set to true, then touch scrolling will be disabled automatically. However,
     *   for accessibility reasons, it is recommended to leave touch
     *   scrolling enabled and provide an alternative set of controls that can be used to perform
     *   drag and drop of records out of the grid.
     *  @type {boolean}
     *  @default false
     */
    override var canDragRecordsOut: Boolean = definedExternally
    /**
     *  Indicates whether records can be dropped into this listGrid.
     *  @type {boolean}
     *  @default false
     */
    override var canAcceptDroppedRecords: Boolean = definedExternally
    /**
     *  Indicates whether records can be reordered by dragging within this ListGrid.
     * 
     *   NOTE: If canReorderRecords is initially enabled or might be
     *   ListGrid.setCanReorderRecords after the grid is created,
     *   it may be desirable to disable Canvas.useTouchScrolling
     *   so that touch-dragging a record starts a reorder operation rather than a scroll. If
     *   Canvas.disableTouchScrollingForDrag is set to true, then touch
     *   scrolling will be disabled automatically. However, for accessibility
     *   reasons, it is recommended to leave touch scrolling enabled and provide an alternative
     *   set of controls that can be used to perform drag-reordering of records.
     *  @type {boolean}
     *  @default false
     */
    override var canReorderRecords: Boolean = definedExternally
    /**
     *  Whether drops are allowed on leaf nodes.
     * 
     *   Dropping is ordinarily not allowed on leaf nodes unless TreeGrid.canReorderRecords is
     *   set.
     * 
     *   The default action for a drop on a leaf node is to place the node in that leaf's parent
     *   folder. This can be customized by overriding method:TreeGrid.folderDrop.
     * 
     *   Note that enabling canDropOnLeaves is usually only appropriate where you
     *   intend to add a custom method:TreeGrid.folderDrop implementation that does not add a
     *   child node under the leaf. If you want to add a child nodes to a leaf, instead of
     *   enabling canDropOnLeaves, use empty folders instead - see Tree.isFolder for how
     *   to control whether a node is considered a folder.
     *  @type {boolean}
     *  @default false
     */
    open var canDropOnLeaves: Boolean = definedExternally
    /**
     *  If set this property allows the user to reparent nodes by dragging them from their
     *   current folder to a new folder.
     *   Backcompat: For backwards compatibility with versions prior to SmartClient 1.5,
     *   if this property is unset, but this.canAcceptDroppedRecords is true, we
     *   allow nodes to be dragged to different folders.
     *  @type {boolean}
     *  @default null
     */
    open var canReparentNodes: Boolean = definedExternally
    /**
     *  Specifies what to do with data dragged from this TreeGrid (into another component, or
     *   another node in this TreeGrid. The default action is to move the data. A setting of
     *   "none" is not recommended for trees because Trees maintain the node open state on the nodes
     *   themselves, and hence having multiple Tree objects share a reference to a node can have
     *   unintended consequences (such as opening a folder in one tree also triggering an open in
     *   another tree that shares the same node).
     * 
     *   See method:TreeGrid.folderDrop for a full explanation of default behaviors on drop, and how to
     *   customize them.
     *  @type {DragDataAction}
     *  @default "move"
     */
    override var dragDataAction: 
                                 /**
                                  *  Don't do anything, resulting in the same data being in both lists.
                                  *  Copy the data leaving the original in our list.
                                  *  Remove the data from this list so it can be moved into the other list.
                                  */
                                 String /* none |  copy |  move */ = definedExternally
    /**
     *  Message displayed when user attempts to drag a node into a parent that already contains
     *   a child of the same name.
     *  @type {string}
     *  @default "This item already contains a child item with that name."
     */
    open var parentAlreadyContainsChildMessage: String = definedExternally
    /**
     *  Message displayed when user attempts to drop a dragged node onto itself.
     *  @type {string}
     *  @default "You can't drag an item into itself."
     */
    open var cantDragIntoSelfMessage: String = definedExternally
    /**
     *  Message displayed when user attempts to drop a node into a child of itself.
     *  @type {string}
     *  @default "You can't drag an item into one of it's children."
     */
    open var cantDragIntoChildMessage: String = definedExternally
    /**
     *  The amount of indentation (in pixels) to add to a node's icon/title for each level
     *   down in this tree's hierarchy.
     * 
     *   This value is ignored when TreeGrid.showConnectors is
     *   true because fixed-size images are used to render the connectors.
     *  @type {number}
     *  @default "20"
     */
    open var indentSize: Number = definedExternally
    /**
     *  The amount of gap (in pixels) between the extraIcon (see TreeGrid.getExtraIcon)
     *   or checkbox icon and the TreeGrid.nodeIcon/
     *   TreeGrid.folderIcon or node text.
     *  @type {Integer}
     *  @default "2"
     */
    open var extraIconGap: Number = definedExternally
    /**
     *  The standard size (same height and width, in pixels) of node icons in this
     *       treeGrid.
     *  @type {number}
     *  @default "16"
     */
    open var iconSize: Number = definedExternally
    /**
     *  Default width and height in pixels of the opener icons, that is, the icons which show
     *   the open or closed state of the node, typically a [+] or [-] symbol, if not overridden
     *   by TreeGrid.openerIconWidth/TreeGrid.openerIconHeight.
     * 
     *   If TreeGrid.showConnectors is true, the opener icon includes the connector line, and
     *   defaults to ListGrid.cellHeight.
     * 
     *   Otherwise, openerIconSize defaults to TreeGrid.iconSize.
     *  @type {number}
     *  @default null
     */
    open var openerIconSize: Number = definedExternally
    /**
     *  Width in pixels of the opener icons, that is, the icons which show the open or closed
     *   state of the node, typically a [+] or [-] symbol.
     * 
     *   If not specified, TreeGrid.openerIconSize is used instead.
     *  @type {number}
     *  @default null
     */
    open var openerIconWidth: Number = definedExternally
    /**
     *  Height in pixels of the opener icons, that is, the icons which show the open or closed
     *   state of the node, typically a [+] or [-] symbol.
     * 
     *   If not specified, TreeGrid.openerIconSize is used instead.
     *  @type {number}
     *  @default null
     */
    open var openerIconHeight: Number = definedExternally
    /**
     *  If set, when a folder is loading it's children from the server (Tree.getLoadState
     *   returns "loading"), it uses a distinct icon image given by TreeGrid.loadingIcon. This is
     *   typically used to show a small animating "spinner" icon to let the user know data is being
     *   fetched.
     *  @type {boolean}
     *  @default true
     */
    open var showLoadingIcons: Boolean = definedExternally
    /**
     *  If TreeGrid.showLoadingIcons is set, this icon will be used when the folder is
     *   Tree.getLoadState.
     *  @type {SCImgURL}
     *  @default "[SKIN]folder_loading.gif"
     */
    open var loadingIcon: String = definedExternally
    /**
     *  The URL of the base icon for all folder nodes in this treeGrid. Note that this URL will
     *   have TreeGrid.openIconSuffix, TreeGrid.closedIconSuffix or
     *   TreeGrid.dropIconSuffix appended to indicate state changes if appropriate -
     *   see documentation on TreeGrid.showOpenIcons, TreeGrid.showSelectedIcons
     *   and TreeGrid.showDropIcons.
     *  @type {SCImgURL}
     *  @default "[SKIN]folder.gif"
     */
    open var folderIcon: String = definedExternally
    /**
     *  If TreeGrid.showDropIcons is true, this suffix will be appended to the
     *   TreeGrid.folderIcon when the user drop-hovers over some folder.
     *  @type {string}
     *  @default "drop"
     */
    open var dropIconSuffix: String = definedExternally
    /**
     *  If TreeGrid.showOpenIcons is true, this suffix will be appended to the
     *   TreeGrid.folderIcon for open folders in this grid.
     *  @type {string}
     *  @default "open"
     */
    open var openIconSuffix: String = definedExternally
    /**
     *  This suffix will be appended to the TreeGrid.folderIcon for closed folders.
     *   If TreeGrid.showOpenIcons is set to false this suffix will also be
     *   appended to open folders' icons.
     *  @type {string}
     *  @default "closed"
     */
    open var closedIconSuffix: String = definedExternally
    /**
     *  If TreeGrid.showSelectedIcons is true, this suffix will be appended to the
     *   TreeGrid.folderIcon for selected nodes in this grid.
     *  @type {string}
     *  @default "selected"
     */
    open var selectedIconSuffix: String = definedExternally
    /**
     *  The filename of the default icon for all leaf nodes in this grid. To specify a
     *   custom image for an individual node, set the TreeGrid.customIconProperty directly on
     *   the node.
     *  @type {SCImgURL}
     *  @default "[SKIN]file.gif"
     */
    open var nodeIcon: String = definedExternally
    /**
     *  If true, show a different icon for open folders than closed folders.
     *   This is achieved by appending the TreeGrid.openIconSuffix onto the
     *   TreeGrid.folderIcon URL [for example "[SKIN]/folder.gif" might be
     *   replaced by "[SKIN]/folder_open.gif".
     *   Note If this property is set to false the same icon is shown for
     *   open folders as for closed folders, unless a custom folder icon was specified. This will be
     *   determined by TreeGrid.folderIcon plus the TreeGrid.closedIconSuffix.
     *  @type {boolean}
     *  @default true
     */
    open var showOpenIcons: Boolean = definedExternally
    /**
     *  If true, show a different icon for selected nodes than unselected nodes.
     *   This is achieved by appending the TreeGrid.selectedIconSuffix onto the
     *   TreeGrid.folderIcon URL or TreeGrid.nodeIcon for selected records.
     * 
     *   If appropriate, this suffix will be combined with the
     *   TreeGrid.openIconSuffix or TreeGrid.closedIconSuffix (see
     *   TreeGrid.showOpenIcons. So a treeGrid with its folderIcon
     *   property set to "[SKIN]/folder.gif", with both
     *   showSelectedIcons and showOpenIcons set to true would show
     *   an icon with the URL "[SKIN]/folder_open_selected.gif" for a
     *   folder that was both selected and opened.
     *  @type {boolean}
     *  @default false
     */
    open var showSelectedIcons: Boolean = definedExternally
    /**
     *  If true, when the user drags a droppable target over a folder in this TreeGrid, show
     *   a different icon folder icon.
     *   This is achieved by appending the TreeGrid.dropIconSuffix onto the
     *   TreeGrid.folderIcon URL (for example "[SKIN]/folder.gif" may be
     *   replaced by "[SKIN]/folder_drop.gif").
     *  @type {boolean}
     *  @default true
     */
    open var showDropIcons: Boolean = definedExternally
    /**
     *  This property allows the developer to rename the
     *   TreeNode.icon property.
     *  @type {string}
     *  @default "icon"
     */
    open var customIconProperty: String = definedExternally
    /**
     *  This property allows the developer to rename the
     *   TreeNode.showOpenIcon property.
     *  @type {string}
     *  @default "showOpenIcon"
     */
    open var customIconOpenProperty: String = definedExternally
    /**
     *  This property allows the developer to rename the
     *   TreeNode.showDropIcon property.
     *  @type {string}
     *  @default "showDropIcon"
     */
    open var customIconDropProperty: String = definedExternally
    /**
     *  This property allows the developer to rename the
     *   TreeNode.showSelectedIcon property.
     *  @type {string}
     *  @default "showSelectedIcon"
     */
    open var customIconSelectedProperty: String = definedExternally
    /**
     *  Should folder nodes showing custom icons (set via the TreeGrid.customIconProperty),
     *   show open state images when the folder is opened.
     *   If true, the TreeGrid.openIconSuffix will be appended to the image URL
     *   (so "customFolder.gif" might be replaced with
     *   "customFolder_open.gif").
     *   Note that the TreeGrid.closedIconSuffix is never appended to custom folder icons.
     *   Can be overridden at the node level via the default property TreeNode.showOpenIcon
     *   and that property can be renamed via TreeGrid.customIconOpenProperty.
     *  @type {boolean}
     *  @default false
     */
    open var showCustomIconOpen: Boolean = definedExternally
    /**
     *  Should folder nodes showing custom icons (set via the TreeGrid.customIconProperty,
     *   default TreeNode.icon),
     *   show drop state images when the user is drop-hovering over the folder.
     *   If true, the TreeGrid.dropIconSuffix will be appended to the image URL
     *   (so "customFolder.gif" might be replaced with
     *   "customFolder_drop.gif").
     *   Can be overridden at the node level via the default property TreeNode.showDropIcon
     *   and that property can be renamed via TreeGrid.customIconDropProperty.
     *  @type {boolean}
     *  @default false
     */
    open var showCustomIconDrop: Boolean = definedExternally
    /**
     *  Should folder nodes showing custom icons (set via the TreeGrid.customIconProperty),
     *   show selected state images when the folder is selected,
     *   if TreeGrid.showSelectedIcons is true?
     * 
     *   If true, the TreeGrid.selectedIconSuffix will be appended to the image URL
     *   (so "customFolder.gif" might be replaced with
     *   "customFolder_selected.gif").
     *   Can be overridden at the node level via the default property TreeNode.showSelectedIcon
     *   and that property can be renamed via TreeGrid.customIconSelectedProperty.
     *  @type {boolean}
     *  @default false
     */
    open var showCustomIconSelected: Boolean = definedExternally
    /**
     *  Should tree nodes show a disabled checkbox
     *   ListGrid.selectionAppearance:"checkbox"
     *   is set on the treegrid, and a node can't be selected?
     * 
     *   If set to false the treeGrid will use
     *   TreeGrid.leaveSelectionCheckboxGap to determine whether to leave
     *   a blank space where the checkbox would normally appear.
     *  @type {boolean}
     *  @default false
     */
    open var showDisabledSelectionCheckbox: Boolean = definedExternally
    /**
     *  If ListGrid.selectionAppearance:"checkbox"
     *   is set on the treegrid, and a node can't be selected, should a gap be left where
     *   the checkbox icon would normally appear, in order to make the node's icon and title
     *   line up with the content for other nodes in the same parent?
     * 
     *   Has no effect if TreeGrid.showDisabledSelectionCheckbox is true
     *  @type {boolean}
     *  @default true
     */
    open var leaveSelectionCheckboxGap: Boolean = definedExternally
    /**
     *  The filename of the default icon for all open folder nodes in this treeGrid.
     *  @deprecated \* as part of SmartClient release 5.5 in favor of TreeGrid.folderIcon
     *  @type {string}
     *  @default null
     */
    open var folderOpenImage: String = definedExternally
    /**
     *  The filename of the default icon for all closed folder nodes in this treeGrid. Use
     *   the node.icon property (null by default) to specify a custom image for an individual
     *   folder node. The same custom image will be used for both the open and closed folder
     *   images.
     *  @deprecated \* as part of SmartClient release 5.5 in favor of TreeGrid.folderIcon
     *  @type {string}
     *  @default null
     */
    open var folderClosedImage: String = definedExternally
    /**
     *  The filename of the icon displayed for a folder node that will accept drag-and-drop
     *   data when the mouse is released.
     *  @deprecated \* as part of SmartClient release 5.5 in favor of TreeGrid.folderIcon
     *  @type {string}
     *  @default null
     */
    open var folderDropImage: String = definedExternally
    /**
     *  The filename of the default icon for all leaf nodes in this treeGrid. Use the
     *   node.icon property (null by default) to specify a custom image for an individual
     *   node.
     *  @deprecated \* as part of SmartClient release 5.5 in favor of TreeGrid.nodeIcon
     *  @type {SCImgURL}
     *  @default "[SKIN]file.gif"
     */
    open var fileImage: String = definedExternally
    /**
     *  The filename of the icon displayed use as the default drag tracker when for multiple
     *   files and/or folders are being dragged.
     *  @type {SCImgURL}
     *  @default "[SKIN]folder_file.gif"
     */
    open var manyItemsImage: String = definedExternally
    /**
     *  Should this treeGrid show connector lines illustrating the tree's hierarchy?
     * 
     *   For the set of images used to show connectors, see TreeGrid.connectorImage.
     * 
     *   Note: in order for connector images to be perfectly connected, all styles for
     *   cells must have no top or bottom border or padding. If you see small gaps in connector
     *   lines, check your CSS files. See the example below for an example of correct
     *   configuration, including example CSS.
     *  @type {boolean}
     *  @default false
     */
    open var showConnectors: Boolean = definedExternally
    /**
     *  If TreeGrid.showConnectors is true, this property determines whether we should show
     *   vertical continuation lines for each level of indenting within the tree. Setting to
     *   false will show only the hierarchy lines are only shown for the most indented path ("sparse"
     *   connectors).
     *  @type {boolean}
     *  @default true
     */
    open var showFullConnectors: Boolean = definedExternally
    /**
     *  Should the opener icon be displayed next to folder nodes? This is an icon
     *   which visually indicates whether the folder is opened or closed (typically via
     *   a [+] or [-] image, or a turn-down arrow) and may be clicked to expand or collapse
     *   the folder.
     * 
     *   For folders with no children, this icon is not shown unless
     *   TreeGrid.alwaysShowOpener is true. Note that for trees which
     *   TreeGrid.loadDataOnDemand, we may not know if a folder
     *   has any descendants if it has never been opened. As such we will show the
     *   opener icon next to the folder. Once the user opens the icon and a fetch occurs,
     *   if the folder is empty, and TreeGrid.alwaysShowOpener is false, the opener icon
     *   will be hidden.
     * 
     *   For more information on load on demand trees, and how we determine whether
     *   a node is a a folder or a leaf, please refer to the treeDataBinding
     *   documentation.
     * 
     *   The opener icon URL is derived from the specified
     *   TreeGrid.openerImage or TreeGrid.connectorImage depending on
     *   TreeGrid.showConnectors. If TreeGrid.showSelectedOpener is specified
     *   a separate opener icon will be displayed for selected nodes.
     *  @type {boolean}
     *  @default true
     */
    open var showOpener: Boolean = definedExternally
    /**
     *  If TreeGrid.showOpener is true, should we display the opener icon
     *   for folders even if they have no children?
     * 
     *   Note that for trees which
     *   TreeGrid.loadDataOnDemand, we may not know if a folder
     *   has any descendants if it has never been opened. As such we will show the
     *   opener icon next to the folder. Once the user opens the icon and a fetch occurs,
     *   if the folder is empty, and this property is false, the opener icon
     *   will be hidden.
     * 
     *   For more information on load on demand trees, and how we determine whether
     *   a node is a a folder or a leaf, please refer to the treeDataBinding
     *   documentation.
     *  @type {boolean}
     *  @default false
     */
    open var alwaysShowOpener: Boolean = definedExternally
    /**
     *  a If TreeGrid.showOpener is true, should a different opener icon be displayed
     *   for selected nodes? This provides a way for developers to show a "selected"
     *   version of the opener icon set which looks optimal with the
     *   cellStyleSuffixes applied the selected record.
     * 
     *   The selected icon URL is created by appending the suffix
     *   "_selected" to the TreeGrid.openerImage or
     *   TreeGrid.connectorImage.
     *  @type {boolean}
     *  @default false
     */
    open var showSelectedOpener: Boolean = definedExternally
    /**
     *  The base filename of the opener icon for the folder node when 'showConnectors' is false
     *   for this TreeGrid.
     *   The opener icon is displayed beside the folder icon in the Tree column for folder nodes.
     *   Clicking on this icon will toggle the open state of the folder.
     *   The filenames for these icons are assembled from this base filename and the state of the
     *   node, as follows:
     *   If the openerImage is set to {baseName}.{extension},
     *   {baseName}_opened.{extension} will be displayed next to opened folders, and
     *   {baseName}_closed.{extension} will be displayed next to closed folders, or
     *   if this page is in RTL mode, {baseName}_opened_rtl.{extension} and
     *   {baseName}_closed_rtl.{extension} will be used.
     * 
     *   If TreeGrid.showSelectedOpener is true the URL for selected nodes will append
     *   the string "_selected" to the image URLs described above.
     *   So for an openerImage set to {baseName}.{extension}, the URLs
     *   for selected records would be
     *   {baseName}_opened_selected.{extension},
     *   {baseName}_closed_selected.{extension}, etc.
     *  @type {SCImgURL}
     *  @default "[SKIN]opener.gif"
     */
    open var openerImage: String = definedExternally
    /**
     *  The base filename for connector icons shown when TreeGrid.showConnectors is true.
     *   Connector icons are rendered into the title field of each row and show the dotted
     *   hierarchy lines between siblings of the same parent node. For each node, a connector icon
     *   may be shown:
     * 
     *  - As an opener icon for folder nodes, next to the folder icon
     * 
     *  - In place of an opener icon for leaf nodes, next to the leaf icon
     * 
     *  - As a standalone vertical continuation line in the indent to the left of the node, to show
     *     a connection between some ancestor node's siblings (only relevant if
     *     TreeGrid.showFullConnectors is true).
     * 
     *   Note that TreeGrid.showFullConnectors governs whether connector lines will be
     *   displayed for all indent levels, or just for the innermost level of the tree.
     * 
     *   The filenames for these icons are assembled from this base filename and the state of the
     *   node. Assuming the connectorImage is set to {baseName}.{extension}, the
     *   full set of images to be displayed will be:
     * 
     *   {baseName}_ancestor[_rtl].{extension} if TreeGrid.showFullConnectors
     *   is true, this is the URL for the vertical continuation image to be displayed at the
     *   appropriate indent levels for ancestor nodes with subsequent children.
     * 
     *   For nodes with no children:
     * 
     * 
     *  - {baseName}_single[_rtl].{extension}: Shown when there is no connector line
     *   attached to the parent or previous sibling, and no connector line to the next sibling. For
     *   TreeGrid.showFullConnectors trees, there will always be a
     *   connector leading to the parent or previous sibling if its present in the tree so this
     *   icon can only be displayed for the first row.
     * 
     *  - {baseName}_start[_rtl].{extension}: Shown when the there is no connector
     *   line attached to the parent or previous sibling, but there is a connector to the next
     *   sibling. As with _single this will only ever be used for the first row if
     *   TreeGrid.showFullConnectors is true
     * 
     *  - {baseName}_end[_rtl].{extension}: Shown if we are not showing a connector
     *   line attached to the next sibling of this node (but are showing a connection to the previous
     *   sibling or parent).
     * 
     *  - {baseName}_middle[_rtl].{extension}: Shown where the we have a connector
     *   line leading to both the previous sibling (or parent) and the next sibling.
     * 
     *   For folders with children. Note that if TreeGrid.showFullConnectors is false, open
     *   folders will never show a connector to subsequent siblings:
     * 
     * 
     *  - {baseName}_opened_single[_rtl].{extension} opened folder node with
     *   children when no connector line is shown attaching to either the folder's previous sibling
     *   or parent, or to any subsequent siblings.
     * 
     *  - {baseName}_opened_start[_rtl].{extension}: opened folder with children
     *   when the there is no connector line attached to the parent or previous sibling, but there
     *   is a connector to the next sibling.
     * 
     *  - {baseName}_opened_end[_rtl].{extension}: opened folder with children
     *   if we are not showing a connector line attached to the next sibling of this node (but are
     *   showing a connection to the previous sibling or parent).
     * 
     *  - {baseName}_opened_middle[_rtl].{extension}: opened folder with children
     *   where the we have a connector line leading to both the previous sibling (or parent) and the
     *   next sibling.
     * 
     * 
     * 
     *  - {baseName}_closed_single[_rtl].{extension} closed folder node with
     *   children when no connector line is shown attaching to either the folder's previous sibling
     *   or parent, or to any subsequent siblings.
     * 
     *  - {baseName}_closed_start[_rtl].{extension}: closed folder with children
     *   when the there is no connector line attached to the parent or previous sibling, but there
     *   is a connector to the next sibling.
     * 
     *  - {baseName}_closed_end[_rtl].{extension}: closed folder with children
     *   if we are not showing a connector line attached to the next sibling of this node (but are
     *   showing a connection to the previous sibling or parent).
     * 
     *  - {baseName}_closed_middle[_rtl].{extension}: closed folder with children
     *   where the we have a connector line leading to both the previous sibling (or parent) and the
     *   next sibling.
     * 
     *   (Note '[_rtl]' means that "_rtl" will be attached if isRTL() is true for this widget).
     * 
     *   If TreeGrid.showSelectedOpener is true the URL for selected nodes will append
     *   the string "_selected" to the image URLs described above.
     *   So for a connectorImage set to {baseName}.{extension}, the URLs
     *   for selected records would be
     *   {baseName}_ancestor[_rtl]_selected.{extension},
     *   {baseName}_single[_rtl]_selected.{extension}, etc.
     *  @type {SCImgURL}
     *  @default "[SKIN]connector.gif"
     */
    open var connectorImage: String = definedExternally
    /**
     *  For TreeGrids with loadDataOnDemand: true, a message to show the user if an attempt is
     *   made to open a folder, and thus load that node's children, while we are offline and
     *   there is no offline cache of that data. The message will be presented to the user in
     *   in a pop-up dialog box.
     *  @type {string}
     *  @default "This data not available while offline"
     */
    open var offlineNodeMessage: String = definedExternally
    /**
     *  For record components placed "within" the TreeGridField.treeField
     *   column, should the component be indented to the position where a title would normally
     *   show?
     * 
     *   For more general placement of embedded components, see
     *   ListGrid.addEmbeddedComponent.
     *  @type {boolean}
     *  @default true
     */
    open var indentRecordComponents: Boolean = definedExternally
    /**
     *  If no fields are specified, create a single field with
     *   TreeGridField.treeField set to true to show the tree.
     * 
     *   This automatically generated field will display values derived by calling
     *   TreeGrid.getNodeTitle, and have the column title set to the specified
     *   TreeGrid.treeFieldTitle.
     * 
     *   Has no effect if fields are explicitly specified.
     * 
     *   This is a convenience setting to allow a TreeGrid to be created without specifying a
     *   field list. If fields are specified, refer to the documentation on property
     *   attr:TreeGrid.autoAssignTreeField for a way to automatically have one of the fields be
     *   use as the tree field if no fields have TreeGridField.treeField set.
     * 
     *   For databound treeGrids, if there is no explicit fields array specified, developers
     *   who wish to pick up all fields from the DataSource definition rather than displaying
     *   this single automatically generated tree field may
     *   either set this property to false, or set TreeGrid.useAllDataSourceFields
     *   to true.
     *  @type {boolean}
     *  @default true
     */
    open var createDefaultTreeField: Boolean = definedExternally
    /**
     *  If true, the set of fields given by the "default binding" (see
     *   DataBoundComponent.fields) is used, with any fields specified in
     *   component.fields acting as overrides that can suppress or modify the
     *   display of individual fields, without having to list the entire set of fields that
     *   should be shown.
     * 
     *   If component.fields contains fields that are not found in the DataSource,
     *   they will be shown after the most recently referred to DataSource field. If the new
     *   fields appear first, they will be shown first.
     * 
     *   ${isc.DocUtils.linkForExampleId('validationFieldBinding', 'This example')} shows a mixture of component
     *   fields and DataSource fields, and how they interact for validation.
     * 
     *   This setting may be cleared if a FieldPicker is used to edit the component's field
     *   order.
     *  @type {boolean}
     *  @default null
     */
    override var useAllDataSourceFields: Boolean = definedExternally
    /**
     *  If true, when folders are opened / closed children will be animated into view.
     * 
     *   Folder animations are automatically disabled if ListGrid.autoFitData is set to "vertical" or "both", or
     *   if ListGrid.showRecordComponents are used.
     *  @type {boolean}
     *  @default true
     */
    override var animateFolders: Boolean = definedExternally
    /**
     *  If TreeGrid.animateFolders is true for this grid, this number can be set to designate
     *   the maximum number of rows to animate at a time when opening / closing a folder.
     *  @type {Integer}
     *  @default null
     */
    override var animateFolderMaxRows: Number = definedExternally
    /**
     *  When animating folder opening / closing, if TreeGrid.animateFolderSpeed is not
     *   set, this property designates the duration of the animation in ms.
     *  @type {number}
     *  @default "100"
     */
    override var animateFolderTime: Number = definedExternally
    /**
     *  When animating folder opening / closing, this property designates the speed of the
     *   animation in pixels shown (or hidden) per second. Takes precedence over the
     *   TreeGrid.animateFolderTime property, which allows the developer to specify a
     *   duration for the animation rather than a speed.
     *  @type {number}
     *  @default "3000"
     */
    override var animateFolderSpeed: Number = definedExternally
    /**
     *  When animating folder opening / closing, this property can be set to apply an
     *   animated acceleration effect. This allows the animation speed to be "weighted", for
     *   example expanding or collapsing at a faster rate toward the beginning of the animation
     *   than at the end.
     *  @type {AnimationAcceleration}
     *  @default null
     */
    override var animateFolderEffect: 
                                      /**
                                       *  - animation will speed up as time elapses
                                       *  - animation will slow down as time elapses
                                       *  - animation will speed up in the middle
                                       *  - no bias
                                       */
                                      String /* smoothStart |  smoothEnd |  smoothStartEnd |  none */ = definedExternally
    /**
     *  If TreeGrid.canAcceptDroppedRecords is true for this treeGrid, this property governs
     *   whether the user can drop between, or over records within the grid.
     *   This controls what RecordDropPosition is passed to the TreeGrid.recordDrop
     *   event handler.
     *  @type {RecordDropAppearance}
     *  @default "both"
     */
    override var recordDropAppearance: 
                                       /**
                                        *  When the user drops onto a record, dropPosition will always be "over"
                                        *  When the user drops onto a record, dropPosition will be either  "before" or "after" depending on whether the mouse was over the top or bottom of
                                        *    the target record
                                        *  When the user drops onto a record, if the drop occurs centered over the  record, the dropPosition will be reported as "over", otherwise it will be
                                        *    "before" or "after" depending on whether the mouse was over the top or bottom of the
                                        *    target record.
                                        *  No dropPosition will be reported
                                        */
                                       String /* over |  between |  both |  body */ = definedExternally
    /**
     *  Before we start editing values in this DataBoundComponent, should we perform a deep clone
     *   of the underlying values. See DataSource.deepCloneOnEdit for details of what this means.
     * 
     *   If this value is not explicitly set, it defaults to the value of DataSource.deepCloneOnEdit.
     *   This value can be overridden per-field with DataSourceField.deepCloneOnEdit.
     * 
     *   Like the other deepCloneOnEdit settings, this flag only has an effect if you are
     *   editing a values object that contains nested objects or arrays, using
     *   Canvas.dataPaths.
     *  @type {boolean}
     *  @default null
     */
    override var deepCloneOnEdit: Boolean = definedExternally
    /**
     *  When editing values in this DataBoundComponent, should we perform a deep clone of values
     *   that are not associated with a field (ie, attributes on the record that do not map to a
     *   component field either directly by name, or by FormItem.dataPath. If this value is
     *   not explicitly set, it defaults to the value of
     *   DataSource.deepCloneNonFieldValuesOnEdit if there is a dataSource, or to the value
     *   of the static DataSource.deepCloneNonFieldValuesOnEdit if there is no
     *   dataSource.
     * 
     *   Like the other deepCloneOnEdit settings, this flag only has an effect if you are
     *   editing a values object that contains nested objects or arrays.
     *  @type {boolean}
     *  @default null
     */
    override var deepCloneNonFieldValuesOnEdit: Boolean = definedExternally
    /**
     *  When using DataBoundComponent.dataFetchMode, how many records to fetch at a time. If set to
     *   a positive integer, dataPageSize will override the default
     *   ResultSet.resultSize for ResultSets automatically created when you call
     *   method:DataBoundComponent.fetchData (and similarly for the ResultTree.resultSize of
     *   ResultTrees). Leaving dataPageSize at its default means to just use the default page
     *   size of the data container.
     * 
     *   Note that regardless of the dataPageSize setting, a component will always fetch
     *   all of data that it needs to draw. Settings such as
     *   ListGrid.showAllRecords,
     *   ListGrid.drawAllMaxCells and
     *   ListGrid.drawAheadRatio can cause more rows than the configured
     *   dataPageSize to be fetched.
     *  @type {Integer}
     *  @default null
     */
    override var dataPageSize: Number = definedExternally
    /**
     *  Delay in milliseconds before fetching data.
     * 
     *   This setting only applies to the ResultSet automatically created by calling
     *   ListGrid.fetchData. If a pre-existing ResultSet is passed to setData() instead, it's
     *   existing setting for ResultSet.fetchDelay applies.
     *  @type {Integer}
     *  @default null
     */
    override var dataFetchDelay: Number = definedExternally
    /**
     *  Whether to show fields marked hidden:true when a DataBoundComponent is given a
     *   DataSource but no component.fields.
     * 
     *   The hidden property is used on DataSource fields to mark fields that are
     *   never of meaning to an end user.
     *  @type {boolean}
     *  @default false
     */
    override var showHiddenFields: Boolean = definedExternally
    /**
     *  Whether to show fields marked detail:true when a DataBoundComponent is
     *   given a DataSource but no component.fields.
     * 
     *   The detail property is used on DataSource fields to mark fields that
     *   shouldn't appear by default in a view that tries to show many records in a small space.
     *  @type {boolean}
     *  @default false
     */
    override var showDetailFields: Boolean = definedExternally
    /**
     *  Whether to show fields of non-atomic types when a DataBoundComponent is given a
     *   DataSource but no component.fields.
     * 
     *   If true, the component will show fields that declare a complex type, for example, a
     *   field 'shippingAddress' that declares type 'Address', where 'Address' is the ID of a
     *   DataSource that declares the fields of a shipping address (city, street name, etc).
     * 
     *   Such fields may need custom formatters or editors in order to create a usable interface,
     *   for example, an Address field in a ListGrid might use a custom formatter to combine the
     *   relevant fields of an address into one column, and might use a pop-up dialog for
     *   editing.
     *  @type {boolean}
     *  @default true
     */
    override var showComplexFields: Boolean = definedExternally
    /**
     *  DSRequest.operationId this component should use when performing fetch operations.
     *  @type {string}
     *  @default null
     */
    override var fetchOperation: String = definedExternally
    /**
     *  DSRequest.operationId this component should use when performing update operations.
     *  @type {string}
     *  @default null
     */
    override var updateOperation: String = definedExternally
    /**
     *  DSRequest.operationId this component should use when performing add operations.
     *  @type {string}
     *  @default null
     */
    override var addOperation: String = definedExternally
    /**
     *  DSRequest.operationId this component should use when performing remove operations.
     *  @type {string}
     *  @default null
     */
    override var removeOperation: String = definedExternally
    /**
     *  The list of field-names to export. If provided, the field-list in the exported output is
     *   limited and sorted as per the list.
     * 
     *   If exportFields is not provided, the exported output includes all visible fields
     *   from this component, sorted as they appear.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    override var exportFields: Array<dynamic> = definedExternally
    /**
     *  Setting exportAll to true prevents the component from passing it's list of fields to the
     *   export call. The result is the export of all visible fields from DataSource.fields.
     * 
     *   If exportAll is false, an export operation will first consider
     *   DataBoundComponent.exportFields, if it's set, and fall back on all visible fields from
     *   DataSource.fields otherwise.
     *  @type {boolean}
     *  @default false
     */
    override var exportAll: Boolean = definedExternally
    /**
     *  If Summary rows exist for this component, whether to include them when exporting client data.
     *  @type {boolean}
     *  @default true
     */
    override var exportIncludeSummaries: Boolean = definedExternally
    /**
     *  Flag controlling when to recategorize records being dropped on a databound
     *   component from another databound component.
     *  @type {RecategorizeMode}
     *  @default "checked"
     */
    override var dragRecategorize: 
                                   /**
                                    *  recategorize is always applied
                                    *  recategorize if normal checks pass
                                    *  never recategorize
                                    */
                                   String /* always |  checked |  never */ = definedExternally
    /**
     *  If set, detect and prevent duplicate records from being transferred to this component, either via
     *   drag and drop or via DataBoundComponent.transferSelectedData. When a duplicate transfer is detected,
     *   a dialog will appear showing the DataBoundComponent.duplicateDragMessage.
     * 
     *   If the component either does not have a DataSource or has a DataSource with no
     *   DataSourceField.primaryKey declared, duplicate checking is off by
     *   default. If duplicate checking is enabled, it looks for an existing record in the dataset
     *   that has all of the properties of the dragged record, and considers that a duplicate.
     * 
     *   For DragDataAction:"copy" where the target DataSource is related to the source
     *   DataSource by foreignKey, a duplicate means that the target list, as filtered by the current
     *   criteria, already has a record whose value for the foreignKey field matches the
     *   primaryKey of the record being transferred.
     * 
     *   For example, consider dragging "employees" to "teams", where "teams" has a field
     *   "teams.employeeId" which is a foreignKey pointing to "employees.id", and the target
     *   grid has search criteria causing it to show all the members of one team. A duplicate -
     *   adding an employee to the same team twice - is when the target grid's dataset contains an
     *   record with "employeeId" matching the "id" field of the dropped employee.
     *  @type {boolean}
     *  @default null
     */
    override var preventDuplicates: Boolean = definedExternally
    /**
     *  Message to show when a user attempts to transfer duplicate records into this component, and
     *   DataBoundComponent.preventDuplicates is enabled.
     * 
     *   If set to null, duplicates will not be reported and the dragged duplicates will not be
     *   saved.
     *  @type {string}
     *  @default "Duplicates not allowed"
     */
    override var duplicateDragMessage: String = definedExternally
    /**
     *  Indicates whether the text of the offlineMessage property should be displayed if no data is
     *   available because we do not have a suitable offline cache
     *  @type {boolean}
     *  @default true
     */
    override var showOfflineMessage: Boolean = definedExternally
    /**
     *  Message to display when this DataBoundComponent attempts to load data that is not available
     *   because the browser is currently offline. Depending on the component, the message is either
     *   displayed in the component's body, or in a pop-up warning dialog.
     *  @type {string}
     *  @default "This data not available while offline"
     */
    override var offlineMessage: String = definedExternally
    /**
     *  Message to display when this DataBoundComponent attempts to save data while the application
     *   is offline.
     *  @type {string}
     *  @default "Data cannot be saved because you are not online"
     */
    override var offlineSaveMessage: String = definedExternally
    /**
     *  Indicates whether to add "drop values" to items dropped on this component, if both
     *       the source and target widgets are databound, either to the same DataSource or
     *       to different DataSources that are related via a foreign key. "Drop values" are
     *       properties of the dropped item that you wish to change (and persist) as a
     *       result of the item being dropped on this grid.
     * 
     *       If this value is true and this component is databound, DataBoundComponent.getDropValues will
     *       be called for every databound item dropped on this grid, and an update performed
     *       on the item
     *  @type {boolean}
     *  @default true
     */
    override var addDropValues: Boolean = definedExternally
    /**
     *  When an item is dropped on this component, and DataBoundComponent.addDropValues is true and both
     *       the source and target widgets are databound, either to the same DataSource or
     *       to different DataSources that are related via a foreign key, this object
     *       provides the "drop values" that SmartClient will apply to the dropped object
     *       before updating it.
     * 
     *       If this property is not defined, SmartClient defaults to returning the selection
     *       criteria currently in place for this component. Thus, any databound items (for example,
     *       rows from other grids bound to the same DataSource) dropped on the grid will,
     *       by default, be subjected to an update that makes them conform to the grid's
     *       current filter criteria.
     *  @type {object}
     *  @default null
     */
    override var dropValues: dynamic = definedExternally
    /**
     *  Does this component represent singular or multiple "records" objects?
     *   Options are "multiple" or "single", or "either"
     *  @type {string}
     *  @default "multiple"
     */
    override var dataArity: String = definedExternally
    /**
     *  Indicates whether or not this component will load its data
     *   DataSource.progressiveLoading.
     *  @type {boolean}
     *  @default null
     */
    override var progressiveLoading: Boolean = definedExternally
    /**
     *  If this component is bound to a dataSource, this attribute may be specified to customize
     *   what fields from the dataSource may be edited by default. For example the SearchForm
     *   class has this attribute set to "canFilter" which allows search forms to edit
     *   dataSource fields marked as canEdit:false (but not those marked as
     *   canFilter:false).
     * 
     *   Note that if canEdit is explicitly specified on a field in
     *   the DataBoundComponent.fields array, that property will be respected in preference to
     *   the canEditAttribute value. (See FormItem.canEdit, ListGridField.canEdit).
     *   Also note that individual dataBoundComponents may have additional logic around whether a field
     *   can be edited - for example ListGrid.canEditCell may be overridden.
     *  @type {Identifier}
     *  @default "canEdit"
     */
    override var canEditFieldAttribute: String = definedExternally
    /**
     *  The useFlatFields flag causes all simple type fields anywhere in a nested
     *   set of DataSources to be exposed as a flat list for form binding.
     * 
     *   useFlatFields is typically used with imported metadata, such as
     *   XMLTools.loadXMLSchema from a
     *   XMLTools.loadWSDL, as a means of eliminating levels of XML
     *   nesting that aren't meaningful in a user interface, without the cumbersome and fragile
     *   process of mapping form fields to XML structures.
     * 
     *   For example, having called WebService.getInputDS to retrieve the input message
     *   schema for a web service operation whose input message looks like this:
     * 
     *   &lt;FindServices&gt;
     *     &lt;searchFor&gt;search text&lt;/searchFor&gt;
     *     &lt;Options&gt;
     *       &lt;caseSensitive&gt;false&lt;/caseSensitive&gt;
     *     &lt;/Options&gt;
     *     &lt;IncludeInSearch&gt;
     *       &lt;serviceName&gt;true&lt;/serviceName&gt;
     *       &lt;documentation&gt;true&lt;/documentation&gt;
     *       &lt;keywords&gt;true&lt;/keywords&gt;
     *     &lt;/IncludeInSearch&gt;
     *   &lt;/FindServices&gt;
     * 
     *   Setting useFlatFields on a DynamicForm that is bound to this input
     *   message schema would result in 5 FormItem reflecting the 5 simple type
     *   fields in the message.
     * 
     *   For this form, the result of DynamicForm.getValues might look
     *   like:
     * 
     *   {
     *    searchFor: "search text",
     *    caseSensitive: false,
     *    serviceName: true,
     *    documentation : true,
     *    keywords : true
     *   }
     *   When contacting a WebService, these values can be automatically
     *   mapped to the structure of the input message for a web service operation by setting
     *   WSRequest.useFlatFields (for use with WebService.callOperation) or by setting
     *   DSRequest.useFlatFields (for use with a DataSource that is
     *   wsdlBinding via
     *   OperationBinding.wsOperation).
     * 
     *   Using these two facilities in conjunction (component.useFlatFields and
     *   request.useFlatFields) allows gratuitous nesting to be consistently bypassed in both the user
     *   presentation and when providing the data for XML messages.
     * 
     *   You can also set OperationBinding.useFlatFields to automatically enable
     *   "flattened" XML serialization (request.useFlatFields) for all DataSource requests of a
     *   particular operationType.
     * 
     *   Note that useFlatFields is not generally recommended for use with structures
     *   where multiple simple type fields exist with the same name, however if used with such a
     *   structure, the first field to use a given name wins. "first" means the first field
     *   encountered in a depth first search. "wins" means only the first field will be present as a
     *   field when data binding.
     *  @type {boolean}
     *  @default null
     */
    override var useFlatFields: Boolean = definedExternally
    /**
     *  If this attribute is set to false, any attributes in the component's values object that do
     *   not map to a DataSourceField or FormItem will not
     *   be tracked when checking for changes. You should only set this flag to false if you know
     *   that your code does not store additional, non-field values in the component's data, or if
     *   you do store such values, but you don't care that they are not checked for changes.
     *   This flag is primarily provided to avoid performance issues in cases where developers are
     *   storing large numbers of extra attributes in component data; generally speaking, you should
     *   only consider setting it to false if you have a use case like this.
     * 
     *   Note, even with this flag set to false, these extra values will still be managed and stored
     *   by SmartClient; they just will not be checked when the component's values are inspected to
     *   see if they have changed. This may lead to methods like ListGrid.rowHasChanges
     *   returning false when you are expecting it to return true. In this case, either switch this
     *   flag back to true (or just do not set it false), or provide a field definition for the
     *   affected attribute(s).
     *  @type {boolean}
     *  @default true
     */
    override var canChangeNonFieldValues: Boolean = definedExternally
    /**
     *  If true, when this component is first drawn, automatically call this.fetchData().
     *   Criteria for this fetch may be picked up from DataBoundComponent.initialCriteria, and textMatchStyle may
     *   be specified via ListGrid.autoFetchTextMatchStyle.
     * 
     *   NOTE: if autoFetchData is set, calling
     *   ListGrid.fetchData before draw will cause two requests to be issued, one from the manual
     *   call to fetchData() and one from the autoFetchData setting. The second request will use
     *   only DataBoundComponent.initialCriteria and not any other criteria or settings from the first request.
     *   Generally, turn off autoFetchData if you are going to manually call ListGrid.fetchData at any time.
     *  @type {boolean}
     *  @default false
     */
    override var autoFetchData: Boolean = definedExternally
    /**
     *  Criteria to be used when DataBoundComponent.autoFetchData is set.
     * 
     *   This property supports dynamicCriteria - use Criterion.valuePath
     *   to refer to values in the Canvas.ruleScope.
     *  @type {Criteria}
     *  @default null
     */
    override var initialCriteria: dynamic = definedExternally
    /**
     *  Criteria that are never shown to or edited by the user and are cumulative with any criteria
     *   provided via DataBoundComponent.initialCriteria, method:DataBoundComponent.setCriteria
     *   etc.
     *  @type {Criteria}
     *  @default null
     */
    override var implicitCriteria: dynamic = definedExternally
    /**
     *  Adds an item to the header context menu allowing users to launch a dialog to define
     *   grid hilites using the HiliteEditor.
     * 
     *   User-added hilites can be persisted via DataBoundComponent.getHiliteState and
     *   DataBoundComponent.setHiliteState.
     *  @type {boolean}
     *  @default false
     */
    override var canEditHilites: Boolean = definedExternally
    /**
     *  Hilites to be applied to the data for this component. See hiliting.
     *  @type {Array<Partial<Hilite>>}
     *  @default null
     */
    override var hilites: Array<dynamic> = definedExternally
    /**
     *  Specifies a list of icons that can be used in DataBoundComponent.editHilites.
     * 
     *   hiliteIcons should be specified as an Array of SCImgURL.
     *   When present, the hilite editing interface shown when DataBoundComponent.editHilites is called
     *   will offer the user a drop down for picking one of these icons when defining either a
     *   simple or advanced hilite rule.
     * 
     *   If the user picks an icon, the created hiliting rule will have Hilite.icon set to
     *   the chosen icon. DataBoundComponent.hiliteIconPosition controls where the icon will
     *   appear for that field -- the default is that it appears in front of the normal cell content.
     *   This can also be overridden at the field level.
     *  @type {Array<Partial<string>>}
     *  @default "["[SKINIMG]/Dialog/notify.png", "[SKINIMG]/Dialog/warn.png", "[SKINIMG]/actions/approve.png"]"
     */
    override var hiliteIcons: Array<dynamic> = definedExternally
    /**
     *  When DataBoundComponent.hiliteIcons are present, where the hilite icon will be placed
     *   relative to the field value. See HiliteIconPosition. Can be overridden at the
     *   field level.
     *  @type {HiliteIconPosition}
     *  @default "before"
     */
    override var hiliteIconPosition: 
                                     /**
                                      *  icon will be placed before the normal cell contents
                                      *  icon will be placed after the normal cell contents
                                      *  icon will be shown instead of the normal cell contents
                                      */
                                     String /* before |  after |  replace */ = definedExternally
    /**
     *  Default width and height of DataBoundComponent.hiliteIcons for this component.
     *   Can be overridden at the component level via explicit
     *   DataBoundComponent.hiliteIconWidth and
     *   DataBoundComponent.hiliteIconHeight, or at the field level via
     *   ListGridField.hiliteIconSize,
     *   ListGridField.hiliteIconWidth and
     *   ListGridField.hiliteIconHeight
     *  @type {number}
     *  @default "12"
     */
    override var hiliteIconSize: Number = definedExternally
    /**
     *  Width for hilite icons for this component.
     *   Overrides DataBoundComponent.hiliteIconSize.
     *   Can be overridden at the field level.
     *  @type {number}
     *  @default null
     */
    override var hiliteIconWidth: Number = definedExternally
    /**
     *  Height for hilite icons for this listGrid.
     *   Overrides DataBoundComponent.hiliteIconSize.
     *   Can be overridden at the field level
     *  @type {number}
     *  @default null
     */
    override var hiliteIconHeight: Number = definedExternally
    /**
     *  How much padding should there be on the left of DataBoundComponent.hiliteIcons by default?
     *   Can be overridden at the field level
     *  @type {number}
     *  @default "2"
     */
    override var hiliteIconLeftPadding: Number = definedExternally
    /**
     *  How much padding should there be on the right of DataBoundComponent.hiliteIcons by default?
     *   Can be overridden at the field level
     *  @type {number}
     *  @default "2"
     */
    override var hiliteIconRightPadding: Number = definedExternally
    /**
     *  Marker that can be set on a record to flag that record as hilited. Should be set to a value
     *   that matches Hilite.id for a hilite defined on this component.
     *  @type {string}
     *  @default "_hilite"
     */
    override var hiliteProperty: String = definedExternally
    /**
     *  Initial hilite state for the grid.
     * 
     *   ListGrid.viewState can be used to initialize all view properties of the grid.
     *   When doing so, hiliteState is not needed because viewState
     *   includes it as well. If both are provided, hiliteState has priority for
     *   hilite state.
     * 
     * 
     *   To retrieve current state call DataBoundComponent.getHiliteState.
     * 
     *  @type {string}
     *  @default null
     */
    override var hiliteState: String = definedExternally
    /**
     *  The strategy to use when generating names for new fields in this component. The default
     *   strategy, "simple", combines the field-type with an index maintained by field-type and
     *   component instance. For example, "formulaField1".
     *  @type {FieldNamingStrategy}
     *  @default "simple"
     */
    override var fieldNamingStrategy: 
                                      /**
                                       *  generate names in the format fieldTypeX, where field type might be     "formulaField" and X is an index specific to the field-type and component instance
                                       *  generates a UUID for all generated field names
                                       */
                                      String /* simple |  uuid */ = definedExternally
    /**
     *  Text for a menu item allowing users to edit grid highlights.
     *  @type {string}
     *  @default "Edit Highlights..."
     */
    override var editHilitesText: String = definedExternally
    /**
     *  The title for the DataBoundComponent.editHilites dialog.
     *  @type {string}
     *  @default "Edit Highlights"
     */
    override var editHilitesDialogTitle: String = definedExternally
    /**
     *  The title for the DataBoundComponent.fieldEditorWindow used to edit calculated
     *   fields.
     * 
     *   This is a dynamic string - text within &#36;{...} are dynamic variables and will
     *   be evaluated as JS code whenever the message is displayed.
     * 
     *   Two dynamic variables are available - "builderType", either Formula or Summary, and
     *   "fieldTitle", which is the title of the calculated field being edited.
     *  @type {HTMLString}
     *  @default "${builderType} Editor [${fieldTitle}]"
     */
    override var fieldEditorWindowTitle: String = definedExternally
    /**
     *  The Window used to edit calculated fields for this component.
     *  @type {Window}
     *  @default null
     */
    override var fieldEditorWindow: Window = definedExternally
    /**
     *  This component's HiliteEditor instance used to allow the user to create, modify, or delete
     *   hilites.
     * 
     *   The following autoChildUsage apply:
     * 
     * 
     *  - DataBoundComponent.hiliteIcons for HiliteEditor.hiliteIcons
     * 
     *  @type {HiliteEditor}
     *  @default null
     */
    override var hiliteEditor: HiliteEditor = definedExternally
    /**
     *  CSS Style to apply to the drag tracker when dragging occurs on this component.
     *  @type {CSSStyleName}
     *  @default "gridDragTracker"
     */
    override var dragTrackerStyle: String = definedExternally
    /**
     *  If the result of a formula evaluation is invalid (specifically, if isNaN(result)==true),
     *   badFormulaResultValue is displayed instead. The default value is ".".
     *  @type {string}
     *  @default "."
     */
    override var badFormulaResultValue: String = definedExternally
    /**
     *  If a summary format string contains an invalid field reference, replace the reference
     *   with the missingSummaryFieldValue. The default value is "-".
     *  @type {string}
     *  @default "-"
     */
    override var missingSummaryFieldValue: String = definedExternally
    /**
     *  Adds an item to the header context menu allowing users to launch a dialog to define a new
     *   field based on values present in other fields, using the FormulaBuilder.
     * 
     *   User-added formula fields can be persisted via ListGrid.getFieldState and
     *   ListGrid.setFieldState.
     *  @type {boolean}
     *  @default false
     */
    override var canAddFormulaFields: Boolean = definedExternally
    /**
     *  Text for a menu item allowing users to add a formula field
     *  @type {string}
     *  @default "Add formula column..."
     */
    override var addFormulaFieldText: String = definedExternally
    /**
     *  Text for a menu item allowing users to edit a formula field
     *  @type {string}
     *  @default "Edit formula..."
     */
    override var editFormulaFieldText: String = definedExternally
    /**
     *  Text for a menu item allowing users to remove a formula field
     *  @type {string}
     *  @default "Remove formula"
     */
    override var removeFormulaFieldText: String = definedExternally
    /**
     *  Adds an item to the header context menu allowing users to launch a dialog to define a new
     *   text field that can contain both user-defined text and the formatted values present in other
     *   fields, using the SummaryBuilder.
     * 
     *   User-added summary fields can be persisted via ListGrid.getFieldState and
     *   ListGrid.setFieldState.
     *  @type {boolean}
     *  @default false
     */
    override var canAddSummaryFields: Boolean = definedExternally
    /**
     *  Text for a menu item allowing users to add a formula field
     *  @type {string}
     *  @default "Add summary column..."
     */
    override var addSummaryFieldText: String = definedExternally
    /**
     *  Text for a menu item allowing users to edit the formatter for a field
     *  @type {string}
     *  @default "Edit summary format..."
     */
    override var editSummaryFieldText: String = definedExternally
    /**
     *  Text for a menu item allowing users to remove a summary field
     *  @type {string}
     *  @default "Remove summary format..."
     */
    override var removeSummaryFieldText: String = definedExternally
    /**
     *  When assembling a value for a DataBoundComponent.canAddSummaryFields, if a referenced
     *   field is hilited, should the hilite HTML be included in the summary field value?
     * 
     *   To control hilites showing in group summaries, see ListGrid.showHilitesInGroupSummary.
     *  @type {boolean}
     *  @default true
     */
    override var includeHilitesInSummaryFields: Boolean = definedExternally
    /**
     *  Best field to use for a user-visible title for an individual record from this
     *   component.
     * 
     *   This attribute has the same function as DataSource.iconField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var titleField: String = definedExternally
    /**
     *  Designates a field of FieldType:"image" as the field to use when rendering a
     *   record as an image, for example, in a TileGrid.
     * 
     *   This attribute has the same function as DataSource.iconField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var iconField: String = definedExternally
    /**
     *  Name of the field that has the second most pertinent piece of textual information in the
     *   record, for use when a DataBoundComponent needs to show a short summary of a record.
     * 
     *   This attribute has the same function as DataSource.infoField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var infoField: String = definedExternally
    /**
     *  Name of the field that has the most pertinent numeric, date, or enum value, for use when a
     *   DataBoundComponent needs to show a short summary of a record.
     * 
     *   This attribute has the same function as DataSource.dataField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var dataField: String = definedExternally
    /**
     *  Name of the field that has a long description of the record, or has the primary text data
     *   value for a record that represents an email message, SMS, log or similar.
     * 
     *   This attribute has the same function as DataSource.descriptionField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var descriptionField: String = definedExternally
    /**
     *  The message to display to the user if an export of a DataBoundComponent's data is attempted
     *   while the DataBoundComponent's data is null or an empty list.
     *  @type {string}
     *  @default "You are attempting to export an empty dataset"
     */
    override var emptyExportMessage: String = definedExternally
    /**
     *  Properties to apply to the MultiSortDialog which gets automatically generated
     *   when DataBoundComponent.askForSort is called.
     * 
     *   See also ListGrid.showHeaderSpanTitlesInSortEditor and ListGrid.sortEditorSpanTitleSeparator
     *  @type {MultiSortDialog}
     *  @default null
     */
    override var multiSortDialogProperties: MultiSortDialog = definedExternally
    /**
     *  Class level defaults to apply to the MultiSortDialog which gets automatically
     *   generated when DataBoundComponent.askForSort is called.
     * 
     *   See also ListGrid.showHeaderSpanTitlesInSortEditor and ListGrid.sortEditorSpanTitleSeparator
     *  @type {MultiSortDialog}
     *  @default null
     */
    override var multiSortDialogDefaults: MultiSortDialog = definedExternally
    /**
     *  For databound components that support editing, the error message for a failed validator
     *   that does not specify its own errorMessage.
     *  @type {HTMLString}
     *  @default "Invalid value"
     */
    override var unknownErrorMessage: String = definedExternally
    /**
     *  A message to display to the user if server-side validation fails with an error but the
     *   server did not provide an error message
     *  @type {string}
     *  @default "Error during validation; no error details were provided"
     */
    override var noErrorDetailsMessage: String = definedExternally
    /**
     *   Uses a "fetch" operation on the current DataSource to retrieve data
     *   that matches the provided criteria, and displays the matching data in this component as a
     *   tree.
     * 
     *   This method will create a ResultTree to manage tree data, which will
     *   subsequently be available as treeGrid.data. DataSource records
     *   returned by the "fetch" operation are linked into a tree structure according to
     *   DataSourceField.primaryKey and
     *   DataSourceField.foreignKey declarations on DataSource fields. See the
     *   treeDataBinding topic for complete details.
     * 
     *   By default, the created ResultTree will use folder-by-folder load on demand, asking the
     *   server for the children of each folder as the user opens it.
     * 
     *   The ResultTree created by fetchData() can be customized by setting
     *   ListGrid.dataProperties to an Object containing properties and methods to apply to
     *   the created ResultTree. For example, the property that determines whether a node is a
     *   folder (Tree.isFolderProperty) can be customized, or
     *   level-by-level loading can be disabled via
     *   ResultTree.loadDataOnDemand.
     * 
     *   If TreeGrid.loadDataOnDemand is true, this grid will issue fetch requests each time the
     *   user opens a folder to load its child data.
     *   The criteria on this fetch request will consist of the appropriate value for the
     *   foreignKey field, combined with the criteria passed to fetchData()
     *   when the data was first loaded.
     *   This allows you to retrieve multiple different tree structures from the same DataSource.
     *   However note that the server is expected
     *   to always respond with an intact tree - returned nodes which do not have parents are dropped
     *   from the dataset and not displayed.
     * 
     *   The callback passed to fetchData will fire once, the first time that data is
     *   loaded from the server. If using folder-by-folder load on demand, use the
     *   ResultTree.dataArrived notification to be notified each time new nodes are loaded.
     * 
     *   Note that when calling 'fetchData()', changes to criteria may or may not result in a
     *   DSRequest to the server due to client-side filtering (see ResultTree.fetchMode.
     *   You can call willFetchData(criteria) to determine if new criteria will result in a
     *   server fetch.
     * 
     *   If you need to force data to be re-fetched, you can call invalidateCache() and
     *   new data will automatically be fetched from the server using the current criteria
     *   and sort direction.
     *   When using invalidateCache() there is no need to also call fetchData() and
     *   in fact this could produce unexpected results.
     * 
     * 
     * 
     *  @param {Criteria=} Search criteria. If a DynamicForm is passed                     in as this argument instead of a raw criteria                      object, will be derived by calling                      DynamicForm.getValuesAsCriteria
     *  @param {DSCallback=} callback to invoke when a fetch is complete. Fires                     only if server contact was required
     *  @param {DSRequest=} additional properties to set on the DSRequest                     that will be issued
     */
    override fun fetchData(criteria: dynamic?, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Retrieves data that matches the provided criteria and displays the matching data in this
     *   component.
     * 
     *   This method behaves exactly like TreeGrid.fetchData except that
     *   DSRequest.textMatchStyle is automatically set to "substring" so that String-valued
     *   fields are matched by case-insensitive substring comparison.
     * 
     * 
     *  @param {Criteria=} Search criteria.            If a DynamicForm is passed in as this argument            instead of a raw criteria object, will be derived by calling            DynamicForm.getValuesAsCriteria
     *  @param {DSCallback=} callback to invoke when a fetch is complete. Fires                     only if server contact was required; see                      ListGrid.fetchData for details
     *  @param {DSRequest=} for databound components only - optional              additional properties to set on the DSRequest that will be issued
     */
    override fun filterData(criteria: dynamic?, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Exports this component's data with client-side formatters applied, so is suitable for direct
     *   display to users. See ListGrid.exportClientData for details of the general
     *   requirements and restrictions when exporting client data.
     * 
     *   The following notes apply when exporting client data from TreeGrids:
     * 
     *  - Export only works correctly if you specify TreeGrid.fields; if you allow it to
     *     generate a TreeGrid.createDefaultTreeField, nothing will be exported
     * 
     *  - Only visible nodes are exported; if you close a node, its children are not exported
     *     even if they are loaded and known to the client
     * 
     *  - Tree nodes are exported as a flat list, in the same order they are displayed in the
     *     TreeGrid
     * 
     * 
     *   If your TreeGrid has custom formatters, formatted values will be exported by default, with
     *   HTML normalized to text where possible. Since some levels of HTML normalizing aren't
     *   possible, this may result in missing or incorrect export values. In this case, you have
     *   two possible approaches:
     * 
     *  - Set ListGridField.exportRawValues on the field. This will export
     *     the raw underlying value of the field; your formatter will not be called
     * 
     *  - Have your formatter call TreeGrid.isExportingClientData
     *     and perform whatever alternative formatting you require if that method returns true
     * 
     * 
     *  @param {DSRequest=} Request properties for the export. Note that specifying DSRequest.exportData on the request properties  allows the developer to pass in an explicit data set to export.
     *  @param {RPCCallback=} Optional callback. If you specify DSRequest.exportToClient: false in the request  properties, this callback will fire after export completes. Otherwise the callback will  fire right before the download request is made to the server.
     */
    override fun exportClientData(requestProperties: DSRequest?, callback: ((response: RPCResponse, rawData: dynamic, request: RPCRequest) -> Unit?)): Unit = definedExternally
    /**
     *   Returns true if this component is currently
     *   TreeGrid.exportClientData. This method can be called from
     *   custom cell formatters if you need to return a different formatted value for an export
     *   than for a live TreeGrid
     * 
     */
    override fun isExportingClientData(): Boolean = definedExternally
    /**
     *   Opens the folder specified by node if it's closed, and closes it if it's open.
     *   TreeGrid will redraw if there's a change in the folder's open/closed state.
     * 
     * 
     *  @param {TreeNode} node to toggle
     */
    open fun toggleFolder(node: TreeNode): Unit = definedExternally
    /**
     *   Opens a folder.
     * 
     *   Executed when a folder node receives a 'doubleClick' event.
     *   If you override this method, the single parameter passed will be
     *   a reference to the relevant folder node in the tree's data.
     * 
     *   See the ListGrid Widget Class for inherited recordClick and recordDoubleClick events.
     * 
     * 
     *  @param {TreeNode} node to open
     */
    open fun openFolder(node: TreeNode): Unit = definedExternally
    /**
     *   Closes a folder.
     * 
     * 
     *  @param {TreeNode} node to close
     */
    open fun closeFolder(node: TreeNode): Unit = definedExternally
    /**
     *   Should this folder be animated when opened / closed? Default implementation will
     *   return true if TreeGrid.animateFolders is true, the folder being actioned
     *   has children and the child-count is less than the result of
     *   TreeGrid.getAnimateFolderMaxRows.
     * 
     *  @param {TreeNode} folder being opened or closed.
     */
    open fun shouldAnimateFolder(folder: TreeNode): Boolean = definedExternally
    /**
     *   If TreeGrid.animateFolders is true for this treeGrid, this method returns the
     *   the maximum number of rows to animate at a time when opening / closing a folder.
     *   This method will return TreeGrid.animateFolderMaxRows if set. Otherwise
     *   the value will be calculated as 3x the number of rows required to fill a viewport,
     *   capped at a maximum value of 75.
     * 
     */
    open fun getAnimateFolderMaxRows(): Number = definedExternally
    /**
     *   Returns a snapshot of the current open state of this grid's data as
     *   a TreeGridOpenState object.
     *   This object can be passed to TreeGrid.setOpenState to open the same set of folders
     *   within the treeGrid's data (assuming the nodes are still present in the data).
     * 
     */
    open fun getOpenState(): String = definedExternally
    /**
     *   Reset this set of open folders within this grid's data to match the
     *   TreeGridOpenState object passed in.
     *   Used to restore previous state retrieved from the grid by a call to
     *   TreeGrid.getOpenState.
     * 
     * 
     *  @param {TreeGridOpenState} Object describing the desired set of open folders.
     */
    open fun setOpenState(openState: String): Unit = definedExternally
    /**
     *   Returns a snapshot of the current selection within this treeGrid as
     *   a ListGridSelectedState object.
     *   This object can be passed to TreeGrid.setSelectedPaths to reset this grid's selection
     *   the current state (assuming the same data is present in the grid).
     * 
     */
    open fun getSelectedPaths(): String = definedExternally
    /**
     *   Reset this grid's selection to match the ListGridSelectedState object passed in.
     *   Used to restore previous state retrieved from the grid by a call to
     *   TreeGrid.getSelectedPaths.
     * 
     * 
     *  @param {ListGridSelectedState} Object describing the desired selection state of                       the grid
     */
    open fun setSelectedPaths(selectedPaths: String): Unit = definedExternally
    /**
     *   Overridden to return a TreeGridViewState object for the grid.
     * 
     */
    override fun getViewState(): String = definedExternally
    /**
     *   Overridden to take a TreeGridViewState object.
     * 
     * 
     *  @param {TreeGridViewState} Object describing the desired view state for the grid
     */
    override fun setViewState(viewState: String): Unit = definedExternally
    /**
     *   Set the Tree object this TreeGrid will view and manipulate.
     * 
     * 
     *  @param {Tree} Tree to show
     */
    open fun setData(newData: Tree): Unit = definedExternally
    /**
     *   Overridden to disallow editing of the TreeNode.name field of this grid's data
     *   tree. Also disallows editing of the auto-generated tree field, which displays the result
     *   of Tree.getTitle on the node.
     * 
     */
    open fun canEditCell(): Boolean = definedExternally
    /**
     *   This inherited ListGrid.startEditingNew is not supported by the TreeGrid
     *   since adding a new tree node arbitrarily at the end of the tree is usually not useful.
     *   Instead, to add a new tree node and begin editing it, use either of these two strategies:
     * 
     * 
     *  - add a new node to the client-side Tree model via Tree.add, then use
     *   ListGrid.startEditing to begin editing this node. Note that if using a DataSource, when the
     *   node is saved, an "update" operation will be used since adding a node directly to the
     *   client-side ResultTree effectively means a new node has been added server side.
     * 
     *  - use DataSource.addData to immediately save a new node. Automatic cache sync
     *   by the ResultTree will cause the node to be integrated into the tree. When the
     *   callback to addData() fires, locate the new node by matching primary key and call
     *   ListGrid.startEditing to begin editing it.
     * 
     * 
     * 
     *  @param {object=} Optional initial set of properties for the new record
     *  @param {boolean=} Whether to suppress the default behavior of moving focus                  to the newly shown editor.
     */
    override fun startEditingNew(newValues: dynamic?, suppressFocus: Boolean?): Unit = definedExternally
    /**
     * 
     *   This override to ListGrid.rowClick. This implementation calls through to the
     *   TreeGrid.nodeClick, TreeGrid.folderClick, TreeGrid.leafClick methods, as
     *   appropriate unless the click was on the expand/collapse control of a folder - in which case
     *   those callbacks are not fired.
     * 
     *   Do not override this method unless you need a rowClick callback that fires even when the
     *   user clicks on the expand/collapse control. If you do override this method, be sure to call
     *   return this.Super("rowClick", arguments); at the end of your override to
     *   preserver other handler that are called from the superclass (for example,
     *   ListGrid.recordClick.
     * 
     * 
     * 
     *  @param {TreeNode} record that was clicked on
     *  @param {number} index of the row where the click occurred
     *  @param {number} index of the col where the click occurred
     */
    open fun rowClick(record: TreeNode, recordNum: Number, fieldNum: Number): Unit = definedExternally
    /**
     * 
     *   Handle a doubleClick on a tree node - override of ListGrid stringMethod of same name. If
     *   the node is a folder, this implementation calls TreeGrid.toggleFolder on it. If
     *   the node is a leaf, calls TreeGrid.openLeaf on it.
     * 
     * 
     */
    open fun recordDoubleClick(): Unit = definedExternally
    /**
     *   Executed when a leaf node receives a 'doubleClick' event. This handler must be
     *   specified as a function, whose single parameter is a reference to the relevant leaf node in
     *   the tree's data.
     *   See the ListGrid Widget Class for inherited recordClick and recordDoubleClick events.
     * 
     * 
     *  @param {TreeNode} node to open
     */
    open fun openLeaf(node: TreeNode): Unit = definedExternally
    /**
     * 
     *   During a drag-and-drop interaction, this method is called to transfer a set of records that
     *   were dropped onto some other component. This method is called after the set of records has
     *   been copied to the other component. Whether or not this component's data is modified is
     *   determined by the value of DataBoundComponent.dragDataAction.
     * 
     *   With a dragDataAction of "move", a databound component will issue "remove"
     *   dsRequests against its DataSource to actually remove the data, via
     *   DataSource.removeData.
     * 
     * 
     */
    override fun transferDragData(): Array<dynamic> = definedExternally
    /**
     *   Return an icon to display as a drag tracker when the user drags some node(s).
     *   Default implementation:
     *   If multiple nodes are selected and TreeGrid.manyItemsImage is defined, this
     *   image will be returned.
     *   Otherwise returns the result of TreeGrid.getIcon for the first node being
     *   dragged.
     * 
     *   Note: Only called if ListGrid.dragTrackerMode is set to "icon".
     * 
     *  @param {Array<Partial<ListGridRecord>>} Records being dragged
     */
    override fun getDragTrackerIcon(records: Array<dynamic>): String = definedExternally
    /**
     * 
     *   This method overrides ListGrid.willAcceptDrop and works as follows:
     * 
     *   First, ListGrid.willAcceptDrop (the superclass definition) is consulted. If it
     *   returns false, then this method returns false immediately.
     *   This handles the following cases:
     *   - reordering of records withing this TreeGrid when ListGrid.canReorderRecords is true
     *   - accepting dropped records from another dragTarget when ListGrid.canAcceptDroppedRecords
     *    is true and the dragTarget gives us a valid set of records to drop into place.
     *   - disallowing drop over disabled nodes, or nodes with canAcceptDrop:false
     * 
     *   This method will also return false if the drop occurred over a leaf node whos immediate
     *   parent has canAcceptDrop set to false
     *   If TreeGrid.canReparentNodes is true, and the user is dragging a node from one folder
     *   to another, this method will return true to allow the change of parent folder.
     * 
     *   Otherwise this method returns true.
     * 
     * 
     */
    override fun willAcceptDrop(): Boolean = definedExternally
    /**
     *   Returns the row number of the most recent mouse event.
     * 
     *  @param {Integer=} optional y-coordinate to obtain row number, in lieu of the y            coordinate of the last mouse event
     */
    override fun getEventRow(y: Number?): Number = definedExternally
    /**
     *   When the user is dragging a droppable element over this grid, this method returns the folder
     *   which would contain the item if dropped. This is the current drop node if the user is hovering
     *   over a folder, or the node's parent if the user is hovering over a leaf.
     * 
     */
    open fun getDropFolder(): Node = definedExternally
    /**
     *   Simulates a drag / drop type transfer of the selected records in some other grid to this
     *   treeGrid, without requiring any user interaction.
     *   See the dragging documentation for an overview of grid drag/drop data
     *   transfer.
     * 
     *  @param {ListGrid} source grid from which the records will be transferred
     *  @param {TreeNode=} parent node into which records should be dropped - if null  records will be transferred as children of the root node.
     *  @param {Integer=} target index (drop position) within the parent folder
     *  @param {Callback=} optional callback to be fired when the transfer process has            completed. The callback will be passed a single parameter "records",            the list of nodes actually transferred to this component (it is called             "records" because this logic is shared with ListGrid).
     */
    open fun transferSelectedData(sourceGrid: ListGrid, folder: TreeNode?, index: Number?, callback: dynamic?): Unit = definedExternally
    /**
     *   The superclass event ListGrid.recordDrop does not fire on a TreeGrid, use
     *   method:TreeGrid.folderDrop instead.
     * 
     * 
     */
    open fun recordDrop(): Unit = definedExternally
    /**
     * 
     *   Transfer a list of TreeNodes from another component (does not have to be a databound
     *   component) into this component. This method is only applicable to list-type components,
     *   such as ListGrid, TreeGrid or TileGrid.
     * 
     *   This method implements the automatic drag-copy and drag-move behavior and calling it is
     *   equivalent to completing a drag and drop of the nodes (the default
     *   method:TreeGrid.folderDrop implementation simply calls transferNodes())
     * 
     *   Note that this method is asynchronous - it may need to perform server turnarounds to prevent
     *   duplicates in the target component's data. If you wish to be notified when the transfer
     *   process has completed, you can either pass the optional callback to this method or implement
     *   the DataBoundComponent.dropComplete method on this component.
     * 
     *   See also TreeGrid.transferSelectedData.
     * 
     * 
     *  @param {Array<Partial<TreeNode>>} Nodes to transfer to this component
     *  @param {TreeNode} The target folder (eg, of a drop interaction), for context
     *  @param {Integer} Insert point within the target folder data for the transferred nodes
     *  @param {Canvas} The databound or non-databound component from which the nodes               are to be transferred.
     *  @param {Callback=} optional callback to be fired when the transfer process has            completed. The callback will be passed a single parameter "records",            the list of nodes actually transferred to this component (it is called            "records" because this is logic shared with ListGrid)
     */
    open fun transferNodes(nodes: Array<dynamic>, folder: TreeNode, index: Number, sourceWidget: Canvas, callback: dynamic?): Unit = definedExternally
    /**
     *   Return the horizontal alignment for cell contents. Default implementation will always
     *   left-align the special TreeGridField.treeField [or right-align if the page is in
     *   RTL mode] - otherwise will return ListGridField.cellAlign if specified, otherwise
     *   ListGridField.align.
     * 
     * 
     * 
     *  @param {ListGridRecord} this cell's record
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    override fun getCellAlign(record: ListGridRecord, rowNum: Number, colNum: Number): 
                                                                                       /**
                                                                                        *  Center within container.
                                                                                        *  Stick to left side of container.
                                                                                        *  Stick to right side of container.
                                                                                        */
                                                                                       String /* center |  left |  right */ = definedExternally
    /**
     * 
     *   Returns the title to show for a node in the tree column. If the field specifies the
     *   name attribute, then the current node[field.name] is returned.
     *   Otherwise, the result of calling Tree.getTitle on the node is called.
     * 
     *   You can override this method to return a custom title for node titles in the tree column.
     * 
     *   Note: if a default tree field is generated for you by TreeGrid.createDefaultTreeField
     *   being true, and you've overridden this method, it will be called with recordNum: -1
     *   during sorting of the tree field, if the tree is ResultTree.fetchMode.
     * 
     * 
     *  @param {TreeNode} The node for which the title is being requested.
     *  @param {number} The index of the node.
     *  @param {string} The field for which the title is being requested.
     */
    open fun getNodeTitle(node: TreeNode, recordNum: Number, field: String): String = definedExternally
    /**
     *   Returns true if the last event occurred over the indented area or over the
     *   open / close icon of a folder node in this TreeGrid. Returns false if the event
     *   did not occur over a folder node.
     * 
     * 
     */
    open fun isOverOpenArea(): Boolean = definedExternally
    /**
     *   Returns true if the last event occurred over TreeGrid.getExtraIcon
     *   for the current node.
     * 
     *   Returns false if the event did not occur over an extraIcon, or if no extraIcon is
     *   showing for the node in question.
     * 
     * 
     */
    open fun isOverExtraIcon(): Boolean = definedExternally
    /**
     *   Get the appropriate open/close opener icon for a node. Returns null if TreeGrid.showOpener is
     *   set to false.
     * 
     * 
     *  @param {TreeNode} tree node in question
     */
    open fun getOpenIcon(node: TreeNode): String = definedExternally
    /**
     *   Get an additional icon to show between the open icon and folder/node icon for a particular
     *   node.
     * 
     *   NOTE: If ListGrid.selectionAppearance is "checkbox", this method will
     *   NOT be called. Extra icons cannot be shown for that appearance.
     * 
     * 
     *  @param {TreeNode} tree node in question
     */
    open fun getExtraIcon(node: TreeNode): String = definedExternally
    /**
     *   Get the appropriate icon for a node.
     * 
     *   By default icons are derived from TreeGrid.folderIcon and TreeGrid.nodeIcon.
     *   Custom icons for individual nodes can be overridden by setting the TreeGrid.customIconProperty
     *   on a node.
     * 
     *   If you want to suppress icons altogether, provide an override of this method that simply
     *   returns null.
     * 
     *   Note that the full icon URL will be derived by applying Canvas.getImgURL to the
     *   value returned from this method.
     * 
     * 
     *  @param {TreeNode} tree node in question
     */
    open fun getIcon(node: TreeNode): String = definedExternally
    /**
     *   Set the icon for a particular treenode to a specified URL
     * 
     * 
     *  @param {TreeNode} tree node
     *  @param {SCImgURL} path to the resource
     */
    open fun setNodeIcon(node: TreeNode, icon: String): Unit = definedExternally
    /**
     * 
     *   This method is called when a folder is opened either via the user manipulating the
     *   expand/collapse control in the UI or via TreeGrid.openFolder. You can return
     *   false to cancel the open.
     * 
     * 
     *  @param {TreeNode} the folder (record) that is being opened
     */
    open fun folderOpened(node: TreeNode): Boolean = definedExternally
    /**
     * 
     *   This method is called when a folder is closed either via the user manipulating the
     *   expand/collapse control in the UI or via TreeGrid.closeFolder. You can return
     *   false to cancel the close.
     * 
     * 
     *  @param {TreeNode} the folder (record) that is being closed
     */
    open fun folderClosed(node: TreeNode): Boolean = definedExternally
    /**
     * 
     *   This method is called when a folder record is clicked on.
     * 
     * 
     *  @param {TreeGrid} The TreeGrid on which folderClick() occurred.
     *  @param {TreeNode} The folder (record) that was clicked
     *  @param {number} Index of the row where the click occurred.
     */
    open fun folderClick(viewer: TreeGrid, folder: TreeNode, recordNum: Number): Unit = definedExternally
    /**
     * 
     *   This method is called when a leaf record is clicked on.
     * 
     * 
     *  @param {TreeGrid} The TreeGrid on which leafClick() occurred.
     *  @param {TreeNode} The leaf (record) that was clicked
     *  @param {number} Index of the row where the click occurred.
     */
    open fun leafClick(viewer: TreeGrid, leaf: TreeNode, recordNum: Number): Unit = definedExternally
    /**
     * 
     *   This method is called when a leaf or folder record is clicked on. Note that if you set
     *   up a callback for nodeClick() and e.g. TreeGrid.leafClick, then
     *   both will fire (in that order) if a leaf is clicked on.
     * 
     * 
     *  @param {TreeGrid} The TreeGrid on which leafClick() occurred.
     *  @param {TreeNode} The node (record) that was clicked
     *  @param {number} Index of the row where the click occurred.
     */
    open fun nodeClick(viewer: TreeGrid, node: TreeNode, recordNum: Number): Unit = definedExternally
    /**
     * 
     *   This method is called when a context click occurs on a folder record.
     * 
     * 
     *  @param {TreeGrid} The TreeGrid on which the contextclick occurred.
     *  @param {TreeNode} The folder (record) on which the contextclick occurred.
     *  @param {number} Index of the row where the contextclick occurred.
     */
    open fun folderContextClick(viewer: TreeGrid, folder: TreeNode, recordNum: Number): Boolean = definedExternally
    /**
     * 
     *   This method is called when a context click occurs on a leaf record.
     * 
     * 
     *  @param {TreeGrid} The TreeGrid on which the contextclick occurred.
     *  @param {TreeNode} The leaf (record) on which the contextclick occurred.
     *  @param {number} Index of the row where the contextclick occurred.
     */
    open fun leafContextClick(viewer: TreeGrid, leaf: TreeNode, recordNum: Number): Boolean = definedExternally
    /**
     * 
     *   This method is called when a context click occurs on a leaf or folder record. Note that
     *   if you set up a callback for nodeContextClick() and
     *   e.g. TreeGrid.leafContextClick, then both will fire (in that order) if a leaf
     *   is contextclicked - unless nodeContextClick() returns false, in which case
     *   no further contextClick callbacks will be called.
     * 
     * 
     *  @param {TreeGrid} The TreeGrid on which the contextclick occurred.
     *  @param {TreeNode} The node (record) on which the contextclick occurred.
     *  @param {number} Index of the row where the contextclick occurred.
     */
    open fun nodeContextClick(viewer: TreeGrid, node: TreeNode, recordNum: Number): Boolean = definedExternally
    /**
     *   Notification method fired whenever this TreeGrid receives new data nodes from the
     *   dataSource. Only applies to databound TreeGrids where TreeGrid.data is a
     *   ResultTree - either explicitly created and applied via TreeGrid.setData or
     *   automatically generated via a TreeGrid.fetchData call.
     * 
     *   Note that dataArrived(), unlike TreeGrid.dataChanged, only fires in limited
     *   circumstances - when data for a ResultTree arrives from the server due to a fetch
     *   or cache invalidation, or as a result of filtering. If you want to catch all data
     *   changes, you should instead react to TreeGrid.dataChanged.
     * 
     * 
     *  @param {TreeNode} The parentNode for which children were just loaded
     */
    open fun dataArrived(parentNode: TreeNode): Unit = definedExternally
    /**
     *   Notification method fired when the TreeGrid's data changes, for any reason.
     *   If overridden (rather than Class.observe), you must Class.Super to ensure proper Framework behavior.
     * 
     *   Examples of why data changed might be:
     * 
     *  - a call to ListGrid.addData, ListGrid.updateData, or ListGrid.removeData
     * 
     *  - DataSource updates from the server for ResultTree data
     *   (triggered by record editing, etc.)
     * 
     *  - fetches arriving back from the server for ResultTree data
     * 
     *  - programmatic changes to Tree data if made through APIs such as
     *   Tree.add, Tree.remove, etc.
     * 
     *  - cache invalidation
     * 
     *  - filtering
     * 
     *   Calling TreeGrid.setData doesn't call this notification directly, but it may
     *   fire if one of the above listed events is triggered (e.g. a server fetch for
     *   ResultTree data).
     * 
     *   Note that the operationType parameter is optional and will be passed and
     *   contain the operation (e.g. "update") if this notification was triggered by a fetch,
     *   an ListGrid.addData, ListGrid.updateData, or ListGrid.removeData, or a DataSource
     *   update for ResultTree data (the first three reasons listed above) but otherwise
     *   will be undefined.
     * 
     * 
     *  @param {string=} optionally passed operation causing the change
     */
    override fun dataChanged(operationType: String?): Unit = definedExternally
    /**
     *   This method is invoked on the source component whenever a drag operation or
     *   DataBoundComponent.transferSelectedData completes. This method is called when the entire chain of
     *   operations - including, for databound components, server-side updates and subsequent
     *   integration of the changes into the client-side cache - has completed.
     *   There is no default implementation of this method; you are intended to override it if you
     *   are interested in being notified when drag operations complete.
     * 
     * 
     */
    override fun dragComplete(): Unit = definedExternally
    /**
     *   This method is invoked whenever a drop operation or DataBoundComponent.transferSelectedData
     *   targeting this component completes. A drop is considered to be complete when all the client-
     *   side transfer operations have finished. This includes any server turnarounds SmartClient
     *   needs to make to check for duplicate records in the target component; it specifically does
     *   not include any add or update operations sent to the server for databound components. If
     *   you want to be notified when the entire drag operation - including server updates and cache
     *   synchronization - has completed, override DataBoundComponent.dragComplete
     *   on the source component.
     *   There is no default implementation of this method; you are intended to override it if you
     *   are interested in being notified when drop operations complete.
     * 
     * 
     *  @param {Array<Partial<Record>>} The list of records actually transferred to          this component (note that this is not necessarily the same thing as the           list of records dragged out of the source component because it doesn't           include records that were excluded because of collisions with existing           records)
     */
    override fun dropComplete(transferredRecords: Array<dynamic>): Unit = definedExternally
    /**
     *   For a component with a specified DataSource, find the associated dataSource field object
     *   from a specified DataPath.
     * 
     *  @param {DataPath} dataPath for which the field definition should be returned.
     */
    override fun getDataPathField(dataPath: String): Unit = definedExternally
    /**
     *   Can the field be edited? This base method always returns false, but it's
     *   overridden by subclasses such as DynamicForm and ListGrid.
     * 
     * 
     *  @param {object | number | string} field object or identifier
     */
    override fun fieldIsEditable(field: dynamic): Boolean = definedExternally
    /**
     *   Return a field by a field index or field name.
     * 
     * 
     *  @param {FieldName | number} field index or field.name
     */
    override fun getField(fieldID: dynamic): dynamic = definedExternally
    /**
     *   Find the index of a currently visible field.
     * 
     * 
     *  @param {FieldName | string} field name or field
     */
    override fun getFieldNum(fieldName: String): Number = definedExternally
    /**
     *   This API is equivalent to List.find but searches for a matching record among already-loaded data only.
     *   Use ListGrid.fetchData to load data from the server.
     * 
     *  @param {AdvancedCriteria} AdvancedCriteria to use with
     */
    override fun find(advancedCriteria: AdvancedCriteria): dynamic = definedExternally
    /**
     *   This API is equivalent to List.findAll but searches for a matching record among already-loaded data only.
     *   Use ListGrid.fetchData to load data from the server.
     * 
     *  @param {AdvancedCriteria} AdvancedCriteria to use with
     */
    override fun findAll(advancedCriteria: AdvancedCriteria): Array<dynamic> = definedExternally
    /**
     *   This API is equivalent to List.findIndex but searches for a matching record among already-loaded data only.
     *   Use ListGrid.fetchData to load data from the server.
     * 
     *  @param {AdvancedCriteria} AdvancedCriteria to use with
     */
    override fun findIndex(advancedCriteria: AdvancedCriteria): Number = definedExternally
    /**
     *   This API is equivalent to List.findNextIndex but searches for a matching record among already-loaded data only.
     *   Use ListGrid.fetchData to load data from the server.
     * 
     *  @param {Integer} first index to consider
     *  @param {AdvancedCriteria} AdvancedCriteria to use with
     *  @param {Integer=} last index to consider
     */
    override fun findNextIndex(startIndex: Number, advancedCriteria: AdvancedCriteria, endIndex: Number?): Number = definedExternally
    /**
     *   Bind to a new DataSource.
     * 
     *   Like passing the "dataSource" property on creation, binding to a DataSource means that the
     *   component will use the DataSource to provide default data for its fields.
     * 
     *   When binding to a new DataSource, if the component has any existing "fields" or has a dataset,
     *   these will be discarded by default, since it is assumed the new DataSource may represent a
     *   completely unrelated set of objects. If the old "fields" are still relevant, pass them to
     *   setDataSource().
     * 
     * 
     *  @param {GlobalId | DataSource} DataSource to bind to
     *  @param {Array<Partial<DataSourceField>>=} optional array of fields to use
     */
    override fun setDataSource(dataSource: dynamic, fields: Array<dynamic>?): Unit = definedExternally
    /**
     *   Sends the current filter criteria and sort direction to the server, then exports data in the
     *   requested DSRequest.exportAs.
     * 
     *   A variety of DSRequest settings, such as
     *   DSRequest.exportAs and DSRequest.exportFilename, affect the
     *   exporting process: see DSRequest.exportResults for further detail.
     * 
     *   Note that data exported via this method does not include any client-side formatting and
     *   relies on both the SmartClient server and server-side DataSources. To export client-data
     *   with formatters applied,
     *   see ListGrid.exportClientData, which still requires the
     *   SmartClient server but does not rely on server-side DataSource definitions (.ds.xml files).
     * 
     *   For more information on exporting data, see DataSource.exportData.
     * 
     * 
     *  @param {DSRequest=} additional properties to set on the DSRequest                      that will be issued
     *  @param {DSCallback=} callback to invoke on completion. Note that this parameter                 only applies where DSRequest.exportToClient is                  explicitly set to false, because file downloads do not                  provide ordinary SmartClient callbacks
     */
    override fun exportData(requestProperties: DSRequest?, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?)): Unit = definedExternally
    /**
     *   Returns an array of Alignment for this grid
     * 
     */
    override fun getFieldAlignments(): Array<dynamic> = definedExternally
    /**
     *   Compares the specified criteria with the current criteria applied to this component's
     *   data object and determines whether the new criteria could be satisfied from the currently
     *   cached set of data, or if a new filter/fetch operation will be required.
     * 
     *   This is equivalent to calling this.data.willFetchData(...).
     *   Always returns true if this component is not showing a set of data from the dataSource.
     * 
     *   Note that to predict correctly the decision that will be made by filter/fetch, you'll need to
     *   pass the same TextMatchStyle that will be used by the future filter/fetch. Fetching
     *   manually (e.g. ListGrid.fetchData) will by default use "exact" while filtering
     *   (e.g. ListGrid.filterData) will by default use "substring". If the component
     *   is configured for autofetch (i.e. ListGrid.autoFetchData: true), that will
     *   use ListGrid.autoFetchTextMatchStyle, which defaults to "substring". If nothing/null
     *   is passed for the style, this method assumes you want the style from the last filter/fetch.
     * 
     *   To determine what TextMatchStyle is being used, check the RPC Tab of the
     *   debugging and check the relevant DSRequest.
     * 
     * 
     *  @param {Criteria} new criteria to test.
     *  @param {TextMatchStyle=} New text match style. If not passed assumes    textMatchStyle will not be modified.
     */
    override fun willFetchData(newCriteria: dynamic, textMatchStyle: 
                                                                     /**
                                                                      *  case-insensitive exact match ("foo" matches "foo" and "FoO", but not "FooBar")
                                                                      *  case-sensitive exact match ("foo" matches only "foo")
                                                                      *  case-insenstive substring match ("foo" matches "foobar" and "BarFoo")
                                                                      *  case-insensitive prefix match ("foo" matches "FooBar" but not "BarFoo")
                                                                      *   textMatchStyle behavior is consistent across the client and all three of the built-in
                                                                      *   server DataSource implementations - SQL, Hibernate and JPA - to the maximum extent that is
                                                                      *   practical. Known inconsistencies, some of which can be tweaked with configuration settings,
                                                                      *   are described below
                                                                      * 
                                                                      *  - textMatchStyle can be disabled for any individual field with the
                                                                      *   DataSourceField.ignoreTextMatchStyle declaration. This behavior is consistent
                                                                      *   across client and server implementations, with the proviso that case-sensitive behavior
                                                                      *   is inherently inconsistent in the server-side implementations (see below for a more
                                                                      *   detailed discussion of this)
                                                                      * 
                                                                      *  - textMatchStyle is forced to "exactCase" for DataSourceField.primaryKey
                                                                      *   fields on update and remove operations, unless
                                                                      *   OperationBinding.allowMultiUpdate is in force. This means that a normal update
                                                                      *   or remove operation - which is constrained by a unique primaryKey value or combination, to
                                                                      *   affect only a single data row - will use an equality match on all primaryKey fields. This
                                                                      *   is desirable because it makes index usage more likely. Note that this means the key values
                                                                      *   "foo" and "FOO" are distinct, which is a change from previous behavior. For most databases,
                                                                      *   this change will have no effect because most databases do not by default allow primaryKey
                                                                      *   values that only differ in case anyway - if a table has a row with a PK of "foo" and you
                                                                      *   try to insert a row with a PK of "FOO", most databases will fail with a constraint violation.
                                                                      *   However, if you are using a database hat allows key values that differ only in case, and you
                                                                      *   need to support this for some reason, you can switch the framework back to the previous
                                                                      *   behavior by setting property allow.case.sensitive.pks to true in
                                                                      *   your server.properties file. Note, we do not recommend this; in fact, we do
                                                                      *   not recommend the use of text primaryKey fields at all. Where you have control ,we would
                                                                      *   always recommend the use of automatically incrementing numeric sequence keys.
                                                                      * 
                                                                      *  - textMatchStyle does not apply to boolean or temporal (date, datetime, time)
                                                                      *   DataSourceField.type. Such fields are always checked for equality. If
                                                                      *   you have a need for more complex matching, such as date-range checking, use AdvancedCriteria
                                                                      * 
                                                                      *  - Critiera values for temporal fields must be real dates (Javascript Date
                                                                      *   objects on the client, instances of java.util.Date on the server). Attempting
                                                                      *   to match against a string or any other type of value will result in an "always fails"
                                                                      *   clause being generated. This behavior is how the client code has always worked, but is a
                                                                      *   change for the server-side DataSources, in the interests of consistency. The previous
                                                                      *   behavior was:
                                                                      * 
                                                                      *  - SQLDataSource used to attempt to match the date column to the criteria value provided;
                                                                      *    if that value was an appropriately-formatted string, that attempt might have
                                                                      *    worked, but it would be database-specific. If you have an application that depends on
                                                                      *    this old behavior, you can switch it back on by adding the following to your
                                                                      *    server.properties file:
                                                                      *    sql.temporal.fields.require.date.criteria: false
                                                                      * 
                                                                      *  - HibernateDataSource and JPADataSource used to skip such clauses altogether, which
                                                                      *    results in the opposite behavior (there is an implied "always succeeds" clause, because
                                                                      *    the clause is not present in the query at all). If you have an application that depends on
                                                                      *    this old behavior, you can switch it back on by adding the following to your
                                                                      *    server.properties file:
                                                                      *    jpa.temporal.fields.require.date.criteria: false or
                                                                      *    hibernate.temporal.fields.require.date.criteria: false, as appropriate
                                                                      * 
                                                                      * 
                                                                      *  - textMatchStyle does not apply to fields used in the joins generated to satisfy
                                                                      *   DataSourceField.includeFrom declarations or entity relations in
                                                                      *   Hibernate or JPA. Again, such comparisons are always for equality
                                                                      * 
                                                                      *  - textMatchStyle is applied to numeric fields only if the supplied criteria value
                                                                      *   is a string. So for a numeric field "myNumber", we will match 10, 100, 110 and 1000 if a
                                                                      *   criteria value of "10" (the quoted string) is supplied, but we will only match 10 if a
                                                                      *   criteria value of 10 (the actual number) is supplied
                                                                      * 
                                                                      *  - This is a change in behavior for the server-side DataSource implementations, in the
                                                                      *    interests of consistency with the client behavior. Previously, all three of the built-in
                                                                      *    DataSource implementations applied textMatchStyle to numeric fields regardless of the
                                                                      *    criteria value's type. If you have an application that depends on this old behavior,
                                                                      *    you can switch it back on by adding the following to your server.properties
                                                                      *    file: sql.substring.numeric.criteria: true or
                                                                      *    hibernate.substring.numeric.criteria: true or
                                                                      *    jpa.substring.numeric.criteria: true, as appropriate
                                                                      * 
                                                                      * 
                                                                      *  - "exactCase" matching cannot be made consistent across all database providers because
                                                                      *   each database has its own idea of whether case-sensitive matching should be the default,
                                                                      *   and how to switch it on and off (if that is even possible)
                                                                      * 
                                                                      *  - Microsoft SQL Server must have case-sensitive matching enabled by setting a
                                                                      *    case-sensitive collation when the database is created (there are more fine-grained
                                                                      *    options, but we do not recommend them because of the scope for further inconsistency,
                                                                      *    where "exactCase" works correctly on table A but not on table B). See
                                                                      *    MSDN for details
                                                                      * 
                                                                      *  - HSQLDB has case sensitivity set with the SET IGNORECASE directive -
                                                                      *    see here
                                                                      * 
                                                                      *  - MySQL is case-insensitive, but since it provides an easy way to do per-query,
                                                                      *    case-sensitive matching in SQL, we work around it for that database, but only in
                                                                      *    SQL DataSources
                                                                      * 
                                                                      * 
                                                                      *  - If you are using Hibernate or JPA, whether "exactCase" works as expected depends
                                                                      *   entirely on the underlying database. Unlike the SQL DataSource, where we have fine-grained
                                                                      *   control of the SQL that the database executes, we are constrained by what the ORM will
                                                                      *   allow. This prevents us from compensating for database quirks, like we do with MySQL's
                                                                      *   case-insensitivity in the SQL DataSource
                                                                      * 
                                                                      */
                                                                     String /* exact |  exactCase |  substring |  startsWith */?): Boolean = definedExternally
    /**
     *   Attempt to find the record in the resultSet that has a primary key value that matches the
     *   passed in parameter value. Only the locally cached data will be searched.
     *   Checks only loaded rows and will not trigger a fetch. Returns null if there is no match,
     *   data is not loaded, or there is no ResultSet.dataSource.
     * 
     *   Note, if you pass a simple value to this method, it will be matched against the first
     *   primaryKey field. For DataSources with a composite primary key (multiple primaryKey fields),
     *   pass
     *   a criteria object containing just your primaryKeys, like this:
     *   { firstPkField: "value", secondPkField: 25 }.
     * 
     * 
     * 
     *  @param {object} primary key value to search for
     */
    override fun findByKey(keyValue: dynamic): Record = definedExternally
    /**
     * 
     *   Select/deselect a Record passed in explicitly, or by index.
     * 
     * 
     *  @param {Record | number} record (or row number) to select
     *  @param {boolean=} new selection state (if null, defaults to true)
     */
    override fun selectRecord(record: dynamic, newState: Boolean?): Unit = definedExternally
    /**
     *   Select a single Record passed in explicitly, or by index, and deselect everything else.
     *   When programmatic selection of records is a requirement and
     *   ListGrid.selectionType is "single", use this method rather than
     *   DataBoundComponent.selectRecord to
     *   enforce mutually-exclusive record-selection.
     * 
     * 
     *  @param {Record | number} record (or row number) to select
     */
    override fun selectSingleRecord(record: dynamic): Unit = definedExternally
    /**
     * 
     *   Deselect a Record passed in explicitly, or by index.
     * 
     *   Synonym for selectRecord(record, false)
     * 
     * 
     *  @param {Record | number} record (or row number) to deselect
     */
    override fun deselectRecord(record: dynamic): Unit = definedExternally
    /**
     * 
     *   Select/deselect a list of Records passed in explicitly, or by index.
     * 
     *   Note that developers may wish to use DataBoundComponent.selectRange to select a single
     *   contiguous range.
     * 
     * 
     *  @param {Array<Partial<Record>> | number} records (or row numbers) to select
     *  @param {boolean=} new selection state (if null, defaults to true)
     */
    override fun selectRecords(records: dynamic, newState: Boolean?): Unit = definedExternally
    /**
     * 
     *   Deselect a list of Records passed in explicitly, or by index.
     * 
     *   Synonym for selectRecords(records, false)
     * 
     *   Note that developers may wish to use DataBoundComponent.deselectRange to select a single
     *   contiguous range.
     * 
     * 
     *  @param {Array<Partial<Record>> | number} records (or row numbers) to deselect
     */
    override fun deselectRecords(records: dynamic): Unit = definedExternally
    /**
     *   Select all records
     * 
     * 
     */
    override fun selectAllRecords(): Unit = definedExternally
    /**
     * 
     *   Deselect all records
     * 
     * 
     */
    override fun deselectAllRecords(): Unit = definedExternally
    /**
     *   Select a contiguous range of records by index
     * 
     *  @param {Integer} start of selection range
     *  @param {Integer} end of selection range (non-inclusive)
     *  @param {boolean=} new selection state (if null, defaults to true)
     */
    override fun selectRange(startRow: Number, endRow: Number, newState: Boolean?): Unit = definedExternally
    /**
     *   Deselect a contiguous range of records by index.
     * 
     *   This is a synonym for selectRange(startRow, endRow, false);
     * 
     *  @param {Integer} start of selection range
     *  @param {Integer} end of selection range (non-inclusive)
     */
    override fun deselectRange(startRow: Number, endRow: Number): Unit = definedExternally
    /**
     *   Whether at least one item is selected
     * 
     */
    override fun anySelected(): Boolean = definedExternally
    /**
     *   Returns the number of selected records.
     * 
     * 
     */
    override fun getSelectionLength(): Number = definedExternally
    /**
     *   Return the set of hilite-objects currently applied to this DataBoundComponent. These
     *   can be serialized for storage and then restored to a component later via
     *   DataBoundComponent.setHilites.
     * 
     * 
     */
    override fun getHilites(): Array<dynamic> = definedExternally
    /**
     *   Accepts an array of hilite objects and applies them to this DataBoundComponent. See also
     *   DataBoundComponent.getHilites for a method of retrieving the hilite
     *   array for storage, including hilites manually added by the user.
     * 
     * 
     *  @param {Array<Partial<Hilite>>} Array of hilite objects
     */
    override fun setHilites(hilites: Array<dynamic>): Unit = definedExternally
    /**
     *   Get the current hilites encoded as a String, for saving.
     * 
     * 
     */
    override fun getHiliteState(): String = definedExternally
    /**
     *   Set the current hilites based on a hiliteState String previously returned from
     *   DataBoundComponent.getHiliteState.
     * 
     *  @param {string} hilites state encoded as a String
     */
    override fun setHiliteState(hiliteState: String): Unit = definedExternally
    /**
     *   Enable / disable a DataBoundComponent.hilites
     * 
     * 
     *  @param {string} ID of hilite to enable
     *  @param {boolean=} new enabled state to apply - if null, defaults to true
     */
    override fun enableHilite(hiliteID: String, enable: Boolean?): Unit = definedExternally
    /**
     *   Disable a hilite
     * 
     * 
     *  @param {string} ID of hilite to disable
     */
    override fun disableHilite(hiliteID: String): Unit = definedExternally
    /**
     *   Enable all hilites.
     * 
     * 
     *  @param {boolean=} new enabled state to apply - if null, defaults to true
     */
    override fun enableHiliting(enable: Boolean?): Unit = definedExternally
    /**
     *   Disable all hilites.
     * 
     * 
     */
    override fun disableHiliting(): Unit = definedExternally
    /**
     *   Shows a HiliteEditor interface allowing end-users to edit
     *   the data-hilites currently in use by this DataBoundComponent.
     * 
     * 
     */
    override fun editHilites(): Unit = definedExternally
    /**
     * 
     *   Transfer a list of Records from another component (does not have to be a databound
     *   component) into this component. This method is only applicable to list-type components,
     *   such as ListGrid, TreeGrid or TileGrid
     * 
     *   This method implements the automatic drag-copy and drag-move behaviors of components like
     *   ListGrid, and calling it is equivalent to completing a drag and drop of the
     *   dropRecords.
     * 
     *   Note that this method is asynchronous - it may need to perform server turnarounds to prevent
     *   duplicates in the target component's data. If you wish to be notified when the transfer
     *   process has completed, you can either pass the optional callback to this method or implement
     *   the DataBoundComponent.dropComplete method on this component.
     * 
     *   See also DataBoundComponent.transferSelectedData.
     * 
     * 
     *  @param {Array<Partial<Record>>} Records to transfer to this component
     *  @param {Record} The target record (eg, of a drop interaction), for context
     *  @param {Integer} Insert point in this component's data for the transferred records
     *  @param {Canvas} The databound or non-databound component from which the records              are to be transferred.
     *  @param {Callback=} optional callback to be fired when the transfer process has completed
     */
    override fun transferRecords(dropRecords: Array<dynamic>, targetRecord: Record, index: Number, sourceWidget: Canvas, callback: dynamic?): Unit = definedExternally
    /**
     *   Returns the "drop values" to apply to a record dropped on this component prior to update. Only
     *   applicable to databound components - see DataBoundComponent.dropValues for more details. If multiple records
     *   are being dropped, this method is called for each of them in turn.
     * 
     *   The default implementation of this method returns the following:
     * 
     * 
     *  - Nothing, if DataBoundComponent.addDropValues is false
     * 
     *  - dropValues, if that property is set. If the component's criteria object is applicable (as explained
     *   in the next item), it is merged into dropValues, with properties in dropValues taking precedence.
     * 
     *  - The component's criteria object, if the most recent textMatchStyle for the component was "exact"
     *     and it is simple criteria (ie, not an AdvancedCriteria object)
     * 
     *  - Otherwise nothing
     * 
     * 
     *   You can override this method if you need more complex setting of drop values than can be
     *   provided by simply supplying a dropValues object.
     * 
     * 
     *  @param {Record} record being dropped
     *  @param {DataSource} dataSource the record being dropped is bound to
     *  @param {Record} record being dropped on
     *  @param {Integer} index of record being dropped on
     *  @param {Canvas} widget where dragging began
     */
    override fun getDropValues(record: Record, sourceDS: DataSource, targetRecord: Record, index: Number, sourceWidget: Canvas): dynamic = definedExternally
    /**
     * 
     *   During a drag-and-drop interaction, this method returns the set of records being dragged out
     *   of the component. In the default implementation, this is the list of currently selected
     *   records.
     * 
     *   This method is consulted by ListGrid.willAcceptDrop.
     * 
     * 
     *  @param {DataBoundComponent} source component from which the records will be transferred
     */
    override fun getDragData(source: DataBoundComponent): Array<dynamic> = definedExternally
    /**
     *   Sets the custom tracker HTML to display next to the mouse when the user initiates a drag
     *   operation on this component. Default implementation will examine ListGrid.dragTrackerMode
     *   and set the custom drag tracker to display the appropriate HTML based on the selected record.
     * 
     *   To display custom drag tracker HTML, this method may be overridden - call
     *   EventHandler.setDragTracker to actually update the drag tracker HTML.
     * 
     */
    override fun setDragTracker(): Boolean = definedExternally
    /**
     *   Convenience method to display a FormulaBuilder to create a new Formula Field. This
     *   is equivalent to calling DataBoundComponent.editFormulaField with
     *   no parameter.
     * 
     * 
     */
    override fun addFormulaField(): Unit = definedExternally
    /**
     *   Method to display a FormulaBuilder to edit a formula Field. If the function is called
     *   without a parameter, a new field will be created when the formula is saved.
     * 
     * 
     *  @param {string} Field to edit or null to add a new formula field
     */
    override fun editFormulaField(field: String): Unit = definedExternally
    /**
     *   Get the computed value of a DataBoundComponent.canAddFormulaFields.
     * 
     *  @param {string} field that has a formula
     *  @param {Record} record to use to compute formula value
     */
    override fun getFormulaFieldValue(field: ListGridField, record: Record): dynamic = definedExternally
    /**
     *   Convenience method to display a SummaryBuilder to create a new Summary Field. This
     *   is equivalent to calling DataBoundComponent.editSummaryField with
     *   no parameter.
     * 
     * 
     */
    override fun addSummaryField(): Unit = definedExternally
    /**
     *   Method to display a SummaryBuilder to edit a Summary Field. If the function is called
     *   without a parameter, a new field will be created when the summary is saved.
     * 
     * 
     *  @param {string} Field to edit or null to add a new summary column
     */
    override fun editSummaryField(field: String): Unit = definedExternally
    /**
     *   Get the computed value of a DataBoundComponent.canAddSummaryFields.
     * 
     *  @param {string} field that has a summary format
     *  @param {Record} record to use to compute formula value
     */
    override fun getSummaryFieldValue(field: ListGridField, record: Record): String = definedExternally
    /**
     *   When assembling a value for a DataBoundComponent.canAddSummaryFields, if a referenced
     *   field is hilited, should the hilite HTML be included in the summary field value?
     * 
     *   Example use case: Consider a grid containing a numeric field, and a summary field
     *   which contains some string value, plus the contents of the numeric field.
     *   If a hilite is defined for the grid which turns the numeric field text red when
     *   the value is negative, this property will govern whether the number will also be
     *   rendered in red within the summary field cells. Any other text in the summary field
     *   cells would not be effected by this hilite.
     * 
     *   Default implementation returns DataBoundComponent.includeHilitesInSummaryFields.
     * 
     *   To control hilites showing in group summaries, see ListGrid.showHilitesInGroupSummary.
     * 
     * 
     *  @param {string} name of the summary field
     *  @param {string} name of the field referenced by this summary
     */
    override fun shouldIncludeHiliteInSummaryField(summaryFieldName: String, usedFieldName: String): Boolean = definedExternally
    /**
     *   Get the index of the provided record.
     * 
     *   Override in subclasses to provide more specific behavior, for instance, when data holds a
     *   large number of records
     * 
     * 
     *  @param {Record} the record whose index is to be retrieved
     */
    override fun getRecordIndex(record: Record): Number = definedExternally
    /**
     *   Get the value of the titleField for the passed record
     * 
     *   Override in subclasses
     * 
     * 
     *  @param {Record} the record whose index is to be retrieved
     */
    override fun getTitleFieldValue(record: Record): String = definedExternally
    /**
     *   Method to return the fieldName which represents the "title" for records in this
     *   Component.
     *   If this.titleField is explicitly specified it will always be used.
     *   Otherwise, default implementation will check DataSource.titleField for databound
     *   compounds.
     *   For non databound components returns the first defined field name of "title",
     *   "name", or "id" where the field is visible. If we don't find any
     *   field-names that match these titles, the first field in the component will be used instead.
     * 
     */
    override fun getTitleField(): String = definedExternally
    /**
     *   Return all CSS style declarations associated with the hilites of a record's field.
     * 
     *  @param {Record} \* @param {string} if set, returned CSS will be appended to this text
     *  @param {string} field object identifying whose CSS is to be returned
     */
    override fun getRecordHiliteCSSText(record: Record, cssText: String, field: String): String = definedExternally
    /**
     *   Return the SortSpecifiers representing the current sort configuration of this
     *   component.
     * 
     */
    override fun getSort(): Array<dynamic> = definedExternally
    /**
     *   Sort this component by a list of SortSpecifiers. If the component's data is not a
     *   ResultSet, only the first specifier is applied.
     * 
     * 
     *  @param {Array<Partial<SortSpecifier>>} List of SortSpecifier objects, one  per sort-field and direction
     */
    override fun setSort(sortSpecifiers: Array<dynamic>): Unit = definedExternally
    /**
     *   Show a dialog to configure the sorting of multiple fields on this component. Calls through
     *   to MultiSortDialog.askForSort, passing this component as the fieldSource and the
     *   current DataBoundComponent.getSort if there is one.
     * 
     *   The generated multiSortDialog can be customized via DataBoundComponent.multiSortDialogDefaults,
     *   DataBoundComponent.multiSortDialogProperties.
     * 
     * 
     */
    override fun askForSort(): Unit = definedExternally
    /**
     *   Returns true if the component's current data model is marked as offline. This does not
     *   necessarily mean that the component has no data; it may have data that was supplied from
     *   the Offline.
     * 
     */
    override fun isOffline(): Boolean = definedExternally
    /**
     *   Shows a FieldPicker interface allowing end-users to edit
     *   the fields currently shown by this DataBoundComponent.
     * 
     * 
     */
    override fun editFields(): Unit = definedExternally
    /**
     *   Notification method fired when a user-generated field is added to this component via
     *   DataBoundComponent.editFormulaField or DataBoundComponent.editSummaryField.
     * 
     *   Returning false from this method will prevent the field being added at all. Note that
     *   this also provides an opportunity to modify the generated field object - any changes
     *   made to the field parameter will show up when the field is displayed in the ListGrid.
     * 
     * 
     *  @param {ListGridField} User generated summary or formula field
     */
    override fun userAddedField(field: ListGridField): Boolean = definedExternally
    /**
     *   Called when the selection changes. Note that this method fires exactly once for any given
     *   change to the selection unlike the ListGrid.selectionChanged event.
     * 
     *   This event is fired once after selection/deselection has completed. The result is
     *   one event per mouse-down event. For a drag selection there will be two events fired:
     *   one when the first record is selected and one when the range is completed.
     * 
     *   This event is also fired when selection is updated by a direct call to one of the
     *   DataBoundComponent select/deselect methods. Calls on the Selection
     *   object do not trigger this event.
     * 
     * 
     *  @param {object} first selected record in the selection, if any, which may or may not be the first record in sort order if the DataBoundComponent is sorted. This parameter is typically used when only one record can be selected at a time.
     *  @param {Array<Partial<object>>} List of records that are now selected
     */
    override fun selectionUpdated(record: dynamic, recordList: Array<dynamic>): Unit = definedExternally
    companion object {
        /**
         *  Creates a new TreeGrid
         * 
         *  @param typeCheckedProperties {Partial<TreeGrid>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {TreeGrid} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): TreeGrid = definedExternally
        /**
         *   Returns whether there are any pending DSRequests initiated by this
         *   DataBoundComponent. May not include any requests sent by directly calling the
         *   DataSource APIs (rather than the DataBoundComponent APIs).
         * 
         * 
         */
        fun requestsArePending(): Boolean = definedExternally
    }
}