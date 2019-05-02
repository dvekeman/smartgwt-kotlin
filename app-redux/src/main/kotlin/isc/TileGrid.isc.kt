@file:JsQualifier("isc")
package isc

/**
 *  A TileGrid is a DataBoundComponent that displays a list of objects as a set
 *   of "tiles", where each tile represents one object, and the tiles are laid out in a grid with
 *   multiple tiles per row. Each tile displays one or more properties of the object it
 *   represents.
 */
open external class TileGrid : TileLayout, DataBoundComponent {
    /**
     *  Array of field definitions to control the default rendering of tiles.
     * 
     *   If not specified, if the DataSource has an DataSource.iconField, only the
     *   iconField and DataSource.titleField will be shown.
     *   Otherwise, all non-DataSourceField.hidden
     *   non-DataSourceField.detail fields will be shown, similar to the default set of
     *   fields shown by a ListGrid.
     * 
     *   Only applicable if using the default SimpleTile class for tiles.
     * 
     *   For SimpleTiles, it is possible to use DetailViewerField.getCellStyle and
     *   StatefulCanvas.getStateSuffix to make a single field statefully styled:
     * 
     * 
     *   isc.TileGrid.create({
     *     fields:[
     *       {name:'animalName',
     *        getCellStyle : function (value, field, record, viewer) {
     *          if (value == "Tiger") return "tigerStyle" + viewer.currentTile.getStateSuffix();
     *          else return viewer.tileGrid.tileValueStyle + viewer.currentTile.getStateSuffix();
     *        }
     *       }
     *     ]
     *   });
     * 
     * 
     * 
     *  @type {Array<Partial<DetailViewerField>>}
     *  @default null
     */
    override var fields: Array<dynamic> = definedExternally
    /**
     *  List of tiles that may be used by the TileGrid to show its current data set. Note that the
     *   SmartClient framework manages this array for optimal performance, and not all tiles in the
     *   array are necessarily visible or assigned a record. This is true regardless of whether
     *   TileGrid.recycleTiles is set or not.
     * 
     *   The number of records in the TileGrid's current TileGrid.data
     *   may be determined by calling List.getLength on it.
     *  @type {Array<Partial<Canvas>>}
     *  @default null
     */
    override var tiles: Array<dynamic> = definedExternally
    /**
     *  By default, TileGrids will not show fields marked DataSourceField.detail
     *   in the DataSource. See also TileGrid.fields.
     *  @type {boolean}
     *  @default false
     */
    override var showDetailFields: Boolean = definedExternally
    /**
     *  When using the default SimpleTile, CSS style for each value shown within a tile.
     *  @type {CSSStyleName}
     *  @default "tileValue"
     */
    open var tileValueStyle: String = definedExternally
    /**
     *  Should tile values change state when the mouse goes over them?
     *  @type {boolean}
     *  @default false
     */
    open var valuesShowRollOver: Boolean = definedExternally
    /**
     *  Should tile values change state when they are selected?
     *  @type {boolean}
     *  @default true
     */
    open var valuesShowSelected: Boolean = definedExternally
    /**
     *  Should tile values change state when the mouse goes down on them?
     *  @type {boolean}
     *  @default false
     */
    open var valuesShowDown: Boolean = definedExternally
    /**
     *  Horizontal alignment for tile values: "left", "right" or "center".
     *  @type {string}
     *  @default "center"
     */
    open var tileValueAlign: String = definedExternally
    /**
     *  Whether values should be allowed to wrap by default, or should be shown on one line
     *   regardless of length.
     *  @type {boolean}
     *  @default false
     */
    open var wrapValues: Boolean = definedExternally
    /**
     *  A List of TileRecord objects, specifying the data to be used to create the
     *   tiles.
     * 
     *   This property will typically not be explicitly specified for databound TileGrids, where
     *   the data is returned from the server via databound component methods such as
     *   TileGrid.fetchData. In this case the data objects will be set to a
     *   ResultSet rather than a simple array.
     *  @type {Array<Partial<Record>> | Array<Partial<TileRecord>> | any}
     *  @default null
     */
    open var data: dynamic = definedExternally
    /**
     *  How many tiles should be present in a line when printing?
     *  @type {number}
     *  @default null
     */
    open var printTilesPerLine: Number = definedExternally
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
     *  If true, when this component is first drawn, automatically call this.fetchData().
     *   Criteria for this fetch may be picked up from TileGrid.initialCriteria, and textMatchStyle may
     *   be specified via ListGrid.autoFetchTextMatchStyle.
     * 
     *   NOTE: if autoFetchData is set, calling
     *   ListGrid.fetchData before draw will cause two requests to be issued, one from the manual
     *   call to fetchData() and one from the autoFetchData setting. The second request will use
     *   only TileGrid.initialCriteria and not any other criteria or settings from the first request.
     *   Generally, turn off autoFetchData if you are going to manually call ListGrid.fetchData at any time.
     *  @type {boolean}
     *  @default false
     */
    override var autoFetchData: Boolean = definedExternally
    /**
     *  If TileGrid.autoFetchData is true, this attribute allows the developer to
     *   specify a textMatchStyle for the initial ListGrid.fetchData call.
     *  @type {TextMatchStyle}
     *  @default "substring"
     */
    open var autoFetchTextMatchStyle: 
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
     *  Criteria to be used when TileGrid.autoFetchData is set.
     * 
     *   This property supports dynamicCriteria - use Criterion.valuePath
     *   to refer to values in the Canvas.ruleScope.
     *  @type {Criteria}
     *  @default null
     */
    override var initialCriteria: dynamic = definedExternally
    /**
     *  How to fetch and manage records retrieve from the server. See FetchMode.
     * 
     *   This setting only applies to the ResultSet automatically created by calling
     *   ListGrid.fetchData. If a pre-existing ResultSet is passed to setData() instead, it's
     *   existing setting for ResultSet.fetchMode applies.
     *  @type {FetchMode}
     *  @default "paged"
     */
    override var dataFetchMode: 
                                /**
                                 *  All records that match the current filter are fetched. Sorting is        performed on the client.
                                 *  Only requested ranges of records are fetched, with predictive fetch        ahead. Sorting is performed on the server.
                                 *  All records available from the DataSource are fetched. Filtering by        search criteria and sorting are both performed on the client.
                                 */
                                String /* basic |  paged |  local */ = definedExternally
    /**
     *  Defines a tileGrid's clickable-selection behavior.
     *  @type {SelectionStyle}
     *  @default "multiple"
     */
    open var selectionType: 
                            /**
                             *  don't select at all
                             *  select only one item at a time
                             *  select one or more items
                             *  select one or more items as a toggle      so you don't need to hold down control keys to select
                             *                   more than one object
                             */
                            String /* none |  single |  multiple |  simple */ = definedExternally
    /**
     *  A TileGrid automatically creates one tile per record in the dataset, via the
     *   AutoChild pattern.
     * 
     *   By default, the SimpleTile class will be used, and will contain content as rendered
     *   by a DetailViewer, based on the provided TileGrid.fields (or on the default
     *   set of fields).
     * 
     * 
     *   To create a completely different appearance, override TileGrid.tileConstructor with the name
     *   of the custom SmartClient class to use for each tile. For example, subclass
     *   SimpleTile and override Canvas.getInnerHTML, returning custom
     *   HTML for each tile.
     * 
     *     isc.defineClass("MyCustomTile", "SimpleTile").addProperties({
     *      getInnerHTML : function () {
     *        return this.Super("getInnerHTML", arguments) +
     *          this.getRecord().width + " x " + this.getRecord().height;
     *      }
     *     });
     * 
     *     isc.TileGrid.create({
     *      tileConstructor:"MyCustomTile"
     *     });
     * 
     * 
     *   Note that you can also override tile behaviors on a per-record basis, via
     *   TileRecord.tileConstructor and TileRecord.tileProperties.
     * 
     * 
     *  @type {SimpleTile}
     *  @default null
     */
    open var tile: SimpleTile = definedExternally
    /**
     *  Common properties to use when creating every tile.
     *  @type {Canvas}
     *  @default null
     */
    open var tileProperties: Canvas = definedExternally
    /**
     *  Classname of a SmartClient component to use for each tile rendered by this TileGrid. Tiles
     *   are created by the AutoChild pattern; see TileGrid.tile.
     * 
     *   Any subclass of Canvas is allowed, but typically any custom class will derive from
     *   SimpleTile.
     * 
     *   When using a custom component for tileConstructor, DataBoundComponents that display multiple
     *   Records (ListGrid, DetailViewer) will have data provided via ListGrid.setData, and
     *   components that display a single Record (DynamicForm) will have
     *   DynamicForm.setValues called on them.
     * 
     *   If the component is not a recognized DataBoundComponent subclass, the Record can be
     *   accessed via
     *   this.record.
     * 
     * 
     *   If you implement particularly simple or particularly complex tile interfaces, you may wish
     *   to adjust the property TileGrid.drawAllMaxTiles.
     *  @type {SCClassName}
     *  @default "SimpleTile"
     */
    open var tileConstructor: String = definedExternally
    /**
     *  DetailViewer instance used to render the content shown in Tiles by default.
     *  @type {DetailViewer}
     *  @default null
     */
    open var detailViewer: DetailViewer = definedExternally
    /**
     *  Properties for the DetailViewer that is automatically created to render the contents of tiles
     *   by default.
     *  @type {DetailViewer}
     *  @default null
     */
    open var detailViewerProperties: DetailViewer = definedExternally
    /**
     *  This property determines whether tiles that are no longer visible (due to scrolling) are
     *   recycled, allowing a large number of records to be displayed using a (potentially) much
     *   smaller set of tiles.
     * 
     *   Recyling tiles may significantly reduce the number of live tile widgets needed to support
     *   a particular TileGrid, but may also result in extra work when the TileGrid is scrolled, as
     *   a scroll that brings off-screen tiles into view will require recycling tiles that have
     *   left the view, even if the new tiles have been visited before (in previous scrolling).
     * 
     *   Recycling will occur when TileGrid.getTile is called, unless the supplied record
     *   (or record specifed by index) is currently bound to an existing tile. Even if recycling
     *   is not enabled, the record associated with a given tile may change if the TileGrid data
     *   changes.
     * 
     *   For more control over the tile creation and recycling process,
     *   see TileGrid.createTile and TileGrid.updateTile.
     *  @type {boolean}
     *  @default true
     */
    open var recycleTiles: Boolean = definedExternally
    /**
     *  Whether tiles are created and drawn for all records, or only for those currently visible.
     *  @type {boolean}
     *  @default false
     */
    open var showAllRecords: Boolean = definedExternally
    /**
     *  If drawing all tiles would cause no more than drawAllMaxTiles tiles to be
     *   rendered, the full dataset will instead be drawn even if TileGrid.showAllRecords
     *   is false and incremental rendering would have otherwise been used.
     * 
     *   The drawAllMaxTiles setting prevents incremental rendering from being used in
     *   situations where it's really unnecessary, such as a 25 record dataset which happens to be
     *   in a grid with a viewport showing only 15 or so tiles. Incremental rendering causes a brief
     *   "flash" during scrolling as the visible portion of the dataset is redrawn, and a better
     *   scrolling experience can be obtained in this situation by drawing the entire dataset up
     *   front, which in this example would have negligible effect on initial draw time.
     * 
     *   drawAllMaxTiles:0 disables this features. You may want to disable this feature
     *   if performance is an issue and:
     * 
     * 
     *  - you very frequently redraw a grid
     * 
     *  - you do a lot of computation when rendering each tile
     * 
     *  - you are showing many grids on one screen and the user won't scroll most of them
     * 
     *  @type {Integer}
     *  @default "25"
     */
    open var drawAllMaxTiles: Number = definedExternally
    /**
     *  If set, when the dataset changes due to filtering, sorting or other actions, any tiles that
     *   were showing before and after the change will animate from their old positions to their new
     *   positions.
     *  @type {boolean}
     *  @default true
     */
    override var animateTileChange: Boolean = definedExternally
    /**
     *  Style for the overall TileGrid component.
     *  @type {CSSStyleName}
     *  @default "tileGrid"
     */
    override var styleName: String = definedExternally
    /**
     *  Visual appearance to show when the tile is being dragged.
     *  @type {DragAppearance}
     *  @default "tracker"
     */
    open var tileDragAppearance: 
                                 /**
                                  *  No default drag appearance is indicated. Your custom dragging routines should
                                  *     implement some behavior that indicates that the user is in a dragging situation,
                                  *     and where the mouse is.
                                  *  A "drag tracker" object is automatically shown and moved around with the
                                  *     mouse. This is generally set to an icon that represents what is being dragged. The
                                  *     default tracker is a 10 pixel black square, but you can customize this icon. This
                                  *     dragAppearance is not recommended for use with drag resizing or drag moving.
                                  *  The target object is actually moved, resized, etc. in real time. This is
                                  *     recommended for drag repositioning, but not for drag resizing of complex objects.
                                  *  An outline the size of the target object is moved, resized, etc. with the
                                  *     mouse. This is recommended for drag resizing, especially for objects that take a
                                  *     significant amount of time to draw.
                                  */
                                 String /* none |  tracker |  target |  outline */ = definedExternally
    /**
     *  Indicates whether tiles can be reordered by dragging within this TileGrid.
     * 
     *   NOTE: If canReorderTiles is initially enabled or might be
     *   TileGrid.setCanReorderTiles after the grid is created,
     *   it may be desirable to disable Canvas.useTouchScrolling
     *   so that touch-dragging a tile starts a reorder operation rather than a scroll. If
     *   Canvas.disableTouchScrollingForDrag is set to true, then touch
     *   scrolling will be disabled automatically. However, for accessibility
     *   reasons, it is recommended to leave touch scrolling enabled and provide an alternative
     *   set of controls that can be used to perform drag-reordering of tiles.
     *  @type {boolean}
     *  @default false
     */
    open var canReorderTiles: Boolean = definedExternally
    /**
     *  Indicates whether tiles can be dragged from this TileGrid and dropped elsewhere.
     * 
     *   NOTE: If canDragTilesOut is initially enabled or might be
     *   TileGrid.setCanDragTilesOut after the grid is created,
     *   it may be desirable to disable Canvas.useTouchScrolling
     *   so that touch-dragging a tile starts a drag operation rather than a scroll. If
     *   Canvas.disableTouchScrollingForDrag is set to true, then touch
     *   scrolling will be disabled automatically. However, for accessibility
     *   reasons, it is recommended to leave touch scrolling enabled and provide an alternative
     *   set of controls that can be used to perform drag and drop of tiles out of the grid.
     *  @type {boolean}
     *  @default false
     */
    open var canDragTilesOut: Boolean = definedExternally
    /**
     *  Indicates whether records can be dropped into this TileGrid.
     *  @type {boolean}
     *  @default false
     */
    open var canAcceptDroppedRecords: Boolean = definedExternally
    /**
     *  CSS Style to apply to the drag tracker when dragging occurs on this component.
     *  @type {CSSStyleName}
     *  @default "gridDragTracker"
     */
    override var dragTrackerStyle: String = definedExternally
    /**
     *  Indicates what to do with data dragged into another DataBoundComponent. See
     *   DragDataAction type for details.
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
     *  If you have a databound tileGrid and you scroll out of the currently loaded dataset, by
     *   default you will see blank tiles until the server returns the data for those rows. The
     *   loadingMessage attribute allows you to specify arbitrary html that will be shown in each
     *   such "blank" tile while the data for that tile is loading.
     *   (e.g. "&lt;DIV ALIGN='CENTER'&gt;LOADING&lt;/DIV&gt;")
     *  @type {HTMLString}
     *  @default null
     */
    open var loadingMessage: String = definedExternally
    /**
     *  Indicates whether the text of the emptyMessage property should be displayed if no data is
     *   available.
     *  @type {boolean}
     *  @default true
     */
    open var showEmptyMessage: Boolean = definedExternally
    /**
     *  The string to display in the body of a tileGrid with an empty data array, if
     *   TileGrid.showEmptyMessage is true.
     *  @type {HTMLString}
     *  @default "No tiles to show."
     */
    open var emptyMessage: String = definedExternally
    /**
     *  The CSS style name applied to the TileGrid.emptyMessage if displayed.
     *  @type {CSSStyleName}
     *  @default "emptyMessage"
     */
    open var emptyMessageStyle: String = definedExternally
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
     *  @default false
     */
    override var useAllDataSourceFields: Boolean = definedExternally
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
     *   Retrieves data from the DataSource that matches the specified criteria.
     * 
     *   When fetchData() is first called, if data has not already been provided via
     *   ListGrid.setData, this method will create a ResultSet, which will be
     *   configured based on component settings such as DataBoundComponent.fetchOperation
     *   and DataBoundComponent.dataPageSize, as well as the general purpose
     *   ListGrid.dataProperties. The created ResultSet will automatically send a DSRequest
     *   to retrieve data from ListGrid.dataSource, and from then on will
     *   automatically manage paging through large datasets, as well as performing filtering and
     *   sorting operations inside the browser when possible - see the ResultSet docs for
     *   details.
     * 
     *   NOTE: do not use both DataBoundComponent.autoFetchData and a
     *   call to fetchData() - this may result in two DSRequests to fetch data. Use
     *   either DataBoundComponent.autoFetchData and Criteria or a manual call to fetchData()
     *   passing criteria.
     * 
     *   Whether a ResultSet was automatically created or provided via ListGrid.setData, subsequent
     *   calls to fetchData() will simply call ResultSet.setCriteria.
     * 
     *   Changes to criteria may or may not result in a DSRequest to the server due to
     *   ResultSet.useClientFiltering. You can call
     *   DataBoundComponent.willFetchData to determine if new criteria will result in a
     *   server fetch.
     * 
     *   If you need to force data to be re-fetched, you can call
     *   ListGrid.invalidateCache and new data will automatically be fetched
     *   from the server using the current criteria and sort direction. NOTE: when using
     *   invalidateCache() there is no need to also call fetchData()
     *   and in fact this could produce unexpected results.
     * 
     *   This method takes an optional callback parameter (set to a DSCallback) to fire when
     *   the fetch completes. Note that this callback will not fire if no server fetch is performed.
     *   In this case the data is updated synchronously, so as soon as this method completes you
     *   can interact with the new data. If necessary, you can use
     *   DataBoundComponent.willFetchData to determine whether or not a server
     *   fetch will occur when fetchData() is called with new criteria.
     * 
     *   In addition to the callback parameter for this method, developers can use
     *   ListGrid.dataArrived to be notified every time data is loaded.
     * 
     *   By default, this method assumes a TextMatchStyle of "exact"; that can be overridden
     *   by supplying a different value in the requestProperties parameter.
     *   See DataBoundComponent.willFetchData;
     * 
     * 
     *  @param {Criteria=} Search criteria. If a DynamicForm is passed                     in as this argument instead of a raw criteria                      object, will be derived by calling                      DynamicForm.getValuesAsCriteria
     *  @param {DSCallback=} callback to invoke when a fetch is complete. Fires                     only if server contact was required
     *  @param {DSRequest=} additional properties to set on the DSRequest                     that will be issued
     */
    open fun fetchData(criteria: dynamic?, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Retrieves data that matches the provided criteria and displays the matching data in this
     *   component.
     * 
     *   This method behaves exactly like ListGrid.fetchData except that
     *   DSRequest.textMatchStyle is automatically set to "substring" so that String-valued
     *   fields are matched by case-insensitive substring comparison.
     * 
     * 
     *  @param {Criteria=} Search criteria.            If a DynamicForm is passed in as this argument            instead of a raw criteria object, will be derived by calling            DynamicForm.getValuesAsCriteria
     *  @param {DSCallback=} callback to invoke when a fetch is complete. Fires                     only if server contact was required; see                      ListGrid.fetchData for details
     *  @param {DSRequest=} for databound components only - optional              additional properties to set on the DSRequest that will be issued
     */
    open fun filterData(criteria: dynamic?, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Invalidate the current data cache for this databound component via a call to
     *   the dataset's invalidateCache() method, for example,
     *   ResultSet.invalidateCache.
     * 
     *   NOTE: there is no need to call invalidateCache() when a save operation
     *   is performed on a DataSource. Automatic cache synchronization features will automatically
     *   update caches - see ResultSet for details. If automatic cache synchronization isn't
     *   working, troubleshoot the problem using the steps suggested
     *   in the FAQ rather
     *   than just calling invalidateCache(). Calling invalidateCache() unnecessarily
     *   causes extra server load and added code complexity.
     * 
     *   Calling invalidateCache() will automatically cause a new fetch to
     *   be performed with the current set of criteria if data had been previously fetched and the
     *   component is currently drawn with data visible - there is no need to manually call
     *   fetchData() after invalidateCache() and this could result in duplicate fetches.
     * 
     *   While data is being re-loaded after a call to invalidateCache(), the widget is
     *   in a state similar to initial data load - it doesn't know the total length of the dataset
     *   and any APIs that act on records or row indices will necessarily fail and should not be
     *   called. To detect that the widget is in this state, call ResultSet.lengthIsKnown.
     * 
     *   invalidateCache() only has an effect if this components dataset is a data
     *   manager class that manages a cache (eg ResultSet or ResultTree). If data was provided as a
     *   simple Array or List, invalidateCache() does nothing.
     * 
     * 
     */
    open fun invalidateCache(): Unit = definedExternally
    /**
     *   Remove the currently selected records from this component.
     *   If this is a databound grid, the records will be removed directly from the DataSource.
     * 
     *   If no records are selected, no action is taken. The grid will automatically be
     *   updated if the record deletion succeeds.
     * 
     * 
     *  @param {DSCallback=} callback to fire when the data has been removed
     *  @param {DSRequest=} additional properties to set on the DSRequest                     that will be issued
     */
    open fun removeSelectedData(callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Returns all selected records, as an Array.
     * 
     * 
     *  @param {boolean=} When true, partially selected records will not be returned.                  Otherwise, both fully and partially selected records are                  returned.
     */
    open fun getSelection(excludePartialSelections: Boolean?): Array<dynamic> = definedExternally
    /**
     *   Returns the first selected record in this component.
     * 
     *   NOTE: If a record is returned, it should be treated as read-only and not
     *   modified.
     * 
     */
    open fun getSelectedRecord(): TileRecord = definedExternally
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
     *   Note that developers may wish to use TileGrid.selectRange to select a single
     *   contiguous range.
     * 
     * 
     *  @param {Array<Partial<Record>> | number} records (or row numbers) to select
     *  @param {boolean=} new selection state (if null, defaults to true)
     */
    override fun selectRecords(records: dynamic, newState: Boolean?): Unit = definedExternally
    /**
     *   Select a contiguous range of records by index
     * 
     *  @param {Integer} start of selection range
     *  @param {Integer} end of selection range (non-inclusive)
     *  @param {boolean=} new selection state (if null, defaults to true)
     */
    override fun selectRange(startRow: Number, endRow: Number, newState: Boolean?): Unit = definedExternally
    /**
     * 
     *   Deselect a list of Records passed in explicitly, or by index.
     * 
     *   Synonym for selectRecords(records, false)
     * 
     *   Note that developers may wish to use TileGrid.deselectRange to select a single
     *   contiguous range.
     * 
     * 
     *  @param {Array<Partial<Record>> | number} records (or row numbers) to deselect
     */
    override fun deselectRecords(records: dynamic): Unit = definedExternally
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
     *   Whether at least one item is selected
     * 
     */
    override fun anySelected(): Boolean = definedExternally
    /**
     *   If defined, this method will be called when a new tile is required. Note that
     *   this method is in complete control of how the tile is constructed, so that
     *   properties such as TileGrid.tileProperties and others needed by TileGrid
     *   will be applied only after this method returns.
     * 
     * 
     *  @param {Record} record that will be associated with new tile
     *  @param {Integer} index of the record in the tileGrid
     */
    open fun createTile(record: Record, tileIndex: Number): Canvas = definedExternally
    /**
     *   If both this method and TileGrid.createTile are defined and
     *   TileGrid.recycleTiles is true, this method will be called when the
     *   framework needs to recycle a tile to be used with a new record. This
     *   notification provides an opportunity to update any widget properties that
     *   depend on the specifics of the record.
     * 
     * 
     *  @param {Record} record that will be associated with the recycled tile
     *  @param {Integer} index of the record in the tileGrid
     *  @param {Canvas} the tile to be recycled
     */
    open fun updateTile(record: Record, tileIndex: Number, reclaimedTile: Canvas): Unit = definedExternally
    /**
     *   Given a tile within this this tile-grid, this method will return the associated record.
     * 
     * 
     *  @param {Canvas} Tile you want to get the record for
     */
    open fun getTileRecord(tile: Canvas): TileRecord = definedExternally
    /**
     *   Provides a new data set to the TileGrid after the grid has been created or drawn.
     *   The TileGrid will redraw to show the new data automatically.
     * 
     *  @param {Array<Partial<Record>> | Array<Partial<TileRecord>> | ResultSet} data to show in the list
     */
    open fun setData(newData: dynamic): Unit = definedExternally
    /**
     *   When using the default SimpleTile class as TileGrid.tileConstructor, this
     *   method provides the HTML to be displayed within each tile. See TileGrid.tile.
     * 
     * 
     *  @param {TileRecord} the tile for which HTML should be retrieved
     */
    open fun getTileHTML(tileRecord: TileRecord): String = definedExternally
    /**
     *   Returns the tile for the passed record or record index.
     * 
     *   Note that this method may be overridden but developers should be aware that this
     *   method may be called repeatedly for the same record each time the TileGrid refreshes
     *   that row. If you override this API, you will need to cache and re-use the same
     *   tile objects per record. Typically this would be achieved by storing a pool of Tile
     *   objects that are re-used if a Record with the same primaryKey is passed to getTile().
     * 
     *   When calling this method directly, if TileGrid.showAllRecords is false, this may
     *   return null for records that are not currently visible.
     * 
     * 
     *  @param {TileRecord | Integer} record or index of record in this.data
     */
    override fun getTile(tile: dynamic): Canvas = definedExternally
    /**
     *   Returns the index of the specified tile.
     * 
     *  @param {Canvas} Tile you want to get the index for
     */
    open fun getTileIndex(tile: Canvas): Number = definedExternally
    /**
     *   Returns the tile currently under the mouse.
     * 
     */
    open fun getCurrentTile(): SimpleTile = definedExternally
    /**
     *   Executed when the tileGrid receives a 'click' event on a
     *   tile. The default implementation does nothing -- override to perform some action
     *   when any record is clicked.
     *   A record event handler can be specified either as
     *   a function to execute, or as a string of script to evaluate. If the handler is defined
     *   as a string of script, all the parameters below will be available as variables for use
     *   in the script.
     *   If you want to cancel the click based on the parameters, return false. Otherwise, return
     *   true so that the click event be registered with the tile.
     * 
     * 
     *  @param {TileGrid} the TileGrid itself
     *  @param {Canvas} the tile that was clicked on
     *  @param {TileRecord} the record that was clicked on
     */
    open fun recordClick(viewer: TileGrid, tile: Canvas, record: TileRecord): Unit = definedExternally
    /**
     *   Executed when the tileGrid receives a 'doubleclick' event on a
     *   tile. The default implementation does nothing -- override to perform some action
     *   when any record is doubleclicked.
     *   A record event handler can be specified either as
     *   a function to execute, or as a string of script to evaluate. If the handler is defined
     *   as a string of script, all the parameters below will be available as variables for use
     *   in the script.
     *   If you want to cancel the doubleclick based on the parameters, return false. Otherwise, return
     *   true so that the doubleclick event be registered with the tile.
     * 
     * 
     *  @param {TileGrid} the TileGrid itself
     *  @param {Canvas} the tile that was doubleclicked on
     *  @param {TileRecord} the record that was doubleclicked on
     */
    open fun recordDoubleClick(viewer: TileGrid, tile: Canvas, record: TileRecord): Unit = definedExternally
    /**
     *   Executed when the tileGrid receives a context-click (right mouse button) event on a
     *   tile. The default implementation does nothing -- override to perform some action
     *   when any record is right-clicked.
     *   Return false to cancel the native behavior (suppressing
     *   the browser context menu).
     * 
     * 
     *   A record event handler can be specified either as
     *   a function to execute, or as a string of script to evaluate. If the handler is defined
     *   as a string of script, all the parameters below will be available as variables for use
     *   in the script.
     *   If you want to cancel the click based on the parameters, return false. Otherwise, return
     *   true so that the click event be registered with the tile.
     * 
     * 
     *  @param {TileGrid} the TileGrid itself
     *  @param {Canvas} the tile that was clicked on
     *  @param {TileRecord} the record that was clicked on
     */
    open fun recordContextClick(viewer: TileGrid, tile: Canvas, record: TileRecord): Boolean = definedExternally
    /**
     *   Called when selection changes within this tileGrid. Note this method fires for
     *   each record for which selection is modified - so when a user clicks inside a tileGrid this
     *   method will typically fire twice (once for the old record being deselected, and once for
     *   the new record being selected).
     * 
     * 
     *  @param {Record} record for which selection changed
     *  @param {boolean} New selection state (true for selected, false for unselected)
     */
    open fun selectionChanged(record: Record, state: Boolean): Unit = definedExternally
    /**
     *   This is not allowed for tileGrid. Instead, use TileGrid.addData.
     * 
     * 
     */
    open fun addTile(): Unit = definedExternally
    /**
     *   This is not allowed for tileGrid. Instead, use TileGrid.removeData.
     * 
     * 
     */
    open fun removeTile(): Unit = definedExternally
    /**
     *   Perform a DataSource "add" operation to add new records to this component's DataSource.
     * 
     * 
     *  @param {Record} new record
     *  @param {DSCallback=} method to call on operation completion
     *  @param {DSRequest=} additional properties to set on the DSRequest                     that will be issued
     */
    open fun addData(newRecord: Record, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Perform a DataSource "remove" operation to remove records from this component's
     *   DataSource.
     * 
     * 
     *  @param {Record} primary key values of record to delete,                      (or complete record)
     *  @param {DSCallback=} method to call on operation completion
     *  @param {DSRequest=} additional properties to set on the DSRequest                     that will be issued
     */
    open fun removeData(data: Record, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Setter for TileGrid.canReorderTiles.
     * 
     */
    open fun setCanReorderTiles(): Unit = definedExternally
    /**
     *   Setter for TileGrid.canDragTilesOut.
     * 
     */
    open fun setCanDragTilesOut(): Unit = definedExternally
    /**
     *   Setter for TileGrid.canAcceptDroppedRecords.
     * 
     */
    open fun setCanAcceptDroppedRecords(): Unit = definedExternally
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
     *   Return "title" HTML to display as a drag tracker when the user drags some record.
     *   Default implementation will display the cell value for the title field (see
     *   ListGrid.getTitleField) for the record(s) being dragged (including any
     *   icons / custom formatting / styling, etc).
     * 
     *   Note: Only called if ListGrid.dragTrackerMode is set to "title".
     * 
     *  @param {ListGridRecord} First selected record being dragged
     *  @param {number} row index of first record being dragged
     */
    open fun getDragTrackerTitle(record: ListGridRecord, rowNum: Number): String = definedExternally
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
     *   Simulates a drag / drop type transfer of the selected records in some other component to this
     *   component, without requiring any user interaction. This method acts on the dropped records
     *   exactly as if they had been dropped in an actual drag / drop interaction, including any
     *   special databound behavior invoked by calling
     *   DataBoundComponent.getDropValues for each dropped record.
     * 
     *   To transfer all data in, for example, a ListGrid, call
     *   ListGrid.selectAllRecords first.
     * 
     *   Note that drag/drop type transfers of records between components are asynchronous operations:
     *   SmartClient may need to perform server turnarounds to establish whether dropped records
     *   already exist in the target component. Therefore, it is possible to issue a call to
     *   transferSelectedData() and/or the drop() method of a databound
     *   component whilst a transfer is still active. When this happens, SmartClient adds the
     *   second and subsequent transfer requests to a queue and runs them one after the other. If
     *   you want to be notified when a transfer process has actually completed, either provide a
     *   callback to this method or implement DataBoundComponent.dropComplete.
     * 
     *   See the dragging documentation for an overview of list grid drag/drop data
     *   transfer.
     * 
     * 
     *  @param {DataBoundComponent} source component from which the records will be transferred
     *  @param {Integer=} target index (drop position) of the rows within this grid.
     *  @param {Callback=} optional callback to be fired when the transfer process has            completed. The callback will be passed a single parameter "records",            the list of records actually transferred to this component.
     */
    override fun transferSelectedData(source: DataBoundComponent, index: Number?, callback: dynamic?): Unit = definedExternally
    /**
     *   Sets some presentation properties (visibility, width, userFormula and userSummary) of the
     *   grid fields based on the ListGridFieldState object passed in.
     *   Used to restore previous state retrieved from the grid by a call to TileGrid.getFieldState.
     * 
     * 
     *  @param {ListGridFieldState} state to apply to the grid's fields.
     */
    open fun setFieldState(fieldState: String): Unit = definedExternally
    /**
     *   Returns a snapshot of the current presentation of this grid's fields as
     *   a ListGridFieldState object.
     * 
     *   This object can be passed to TileGrid.setFieldState to reset this grid's fields to
     *   the current state.
     * 
     *   Note that the information stored includes the current width and visibility of each of this
     *   grid's fields.
     * 
     * 
     */
    open fun getFieldState(): String = definedExternally
    /**
     *   Notification method fired when new data arrives from the server to be displayed in this
     *   tileGrid, (for example in response to the user scrolling a new set of tiles into view).
     *   Only applies to databound tileGrid where the TileGrid.data attribute is a
     *   ResultSet.
     *   This method is fired directly in
     *   response to ResultSet.dataArrived firing on the data object.
     * 
     *  @param {Integer} starting index of the newly loaded set of records
     *  @param {Integer} ending index of the newly loaded set of records (non inclusive).
     */
    open fun dataArrived(startRecord: Number, endRecord: Number): Unit = definedExternally
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
         *  Creates a new TileGrid
         * 
         *  @param typeCheckedProperties {Partial<TileGrid>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {TileGrid} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): TileGrid = definedExternally
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