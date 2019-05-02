@file:JsQualifier("isc")
package isc

/**
 *  The CubeGrid is an interactive grid component that presents very large, multi-dimensional
 *   data sets (also known as data cubes) for reporting or analytic applications.
 * 
 *   CubeGrids are often called crosstabs, for their cross-tabular display of data dimensions in
 *   stacked/nested rows and columns, or pivot tables, for their ability to "pivot" dimensions
 *   between rows and columns to view a data cube from different perspectives. They are typically
 *   used in the querying and reporting front-ends of data warehousing, decision support, OLAP,
 *   and business intelligence systems.
 * 
 *   For example, CubeGrids can be connected to Pentaho Mondrian, Jasper Reports, Microsoft
 *   Analysis Services and any other OLAP technology that supports the XMLA standard - the
 *   Isomorphic public wiki has
 *   examples.
 *   of such integration.
 * 
 *   NOTE: you must load the Analytics
 *   loadingOptionalModules before you can use CubeGrid.
 * 
 *   Multi-Dimensional Data Terminology
 * 
 *   The CubeGrid refers to the dimensions of a data cube as facets, to the possible values in
 *   each facet as facet values, and to the values within the data cube as data values or cell
 *   values. Equivalent terms that are commonly used in data warehousing or business intelligence
 *   systems include:
 *   facet: dimension, attribute, feature
 *   facet value: dimension member, attribute value, feature value
 *   cell value: data value, metric value, measure
 * 
 *   Visual Structure
 * 
 *   Like the ListGrid and TreeGrid components, the CubeGrid displays data values in a tabular
 *   "body" with adjacent "headers". While the ListGrid and TreeGrid display rows of records
 *   with field values, the CubeGrid displays a body of individual cell values, each associated
 *   with a combination of facet values. The facet values for a cell are displayed in the column
 *   headers above the cell and row headers to the left of the cell. CubeGrids can display an
 *   arbitrary number of facets, by stacking multiple levels of row and/or column headers.
 * 
 *   Except for the innermost column facet, each facet in a CubeGrid has a facet label adjacent
 *   to its row or column headers. The facet labels serve two main purposes: they display the
 *   titles of the facets, and they provide drag-and-drop reordering or pivoting of facets within
 *   the CubeGrid. The row facet labels also provide interactive selection, resizing, and other
 *   operations on the columns of row facet values.
 * 
 *   The innermost column headers provide special behaviors and controls for manipulating the
 *   columns of data in a CubeGrid. End users may select, resize, reorder, minimize, maximize, or
 *   auto-fit the columns of data via mouse interactions with these headers. Customizable
 *   indicators and controls may be included at the top of each innermost column header.
 * 
 *   If a CubeGrid is not large enough to display all of its cell values, horizontal and/or
 *   vertical scrollbars will appear below and to the right of the body. The body of the CubeGrid
 *   may be scrolled on either axis. The headers are "frozen" from scrolling on one axis - row
 *   headers only scroll vertically, while column headers only scroll horizontally - so the facet
 *   values for the visible cells are always displayed.
 * 
 *   Data Loading
 * 
 *   Data can be provided to the Cube via CubeGrid.data as an Array of
 *   CellRecord, each representing the data for one cell.
 * 
 *   For large datasets, CubeGrid.dataSource with one field per
 *   facetId, and the CubeGrid will load data on demand to fill the visible area, including
 *   lazily loading data for expanding/collapsing tree facets and when facetValues are made
 *   visible programmatically or via menus.
 * 
 *   Picking Facets
 * 
 *   By "facet" we mean an aspect of the data which is orthogonal to other aspects of the data,
 *   that is, combining values from any two "facets" should make sense.
 * 
 *   For example, in sales data, two facets might be "quarter" and "region" - it makes sense to
 *   combine any quarter and region, although for some combinations, there may not be data
 *   available.
 * 
 *   An example of two aspects that would not be independent facets are "state" and "city"
 *   - it's senseless to combine arbitrary states with arbitrary cities - most combinations are
 *   invalid. Consider instead a Facet.isTree that combines "city" and "state"
 *   values.
 * 
 *   Note that if "city" and "state" are represented as facets, they may look correct if they are
 *   both on the same axis of the grid and
 *   CubeGrid.hideEmptyFacetValues is used to trim nonsense
 *   combinations, but if the data is CubeGrid.canMoveFacets such that "state" and
 *   "city" are on opposing axes, there will be a roughly diagonal "stripe" of data for
 *   combinations of "state" and "city" that make sense, and all other space will be blank. This
 *   is a strong indication that two facets should be represented as a single tree facet instead.
 */
open external class CubeGrid : ListGrid {
    
    override fun selectAllRecords() = definedExternally

    /**
     *  CSS class for the CubeGrid as a whole
     *  @type {CSSStyleName}
     *  @default "normal"
     */
    override var styleName: String = definedExternally
    /**
     *  CSS class for the CubeGrid body
     *  @type {CSSStyleName}
     *  @default "cubeGridBody"
     */
    override var bodyStyleName: String = definedExternally
    /**
     *  GridRenderer.baseStyle for this listGrid.
     *   If this property is unset, base style may be derived from ListGrid.normalBaseStyle
     *   or ListGrid.tallBaseStyle as described in
     *   ListGrid.getBaseStyle.
     * 
     *   See cellStyleSuffixes for details on how stateful suffixes are combined
     *   with the base style to generate stateful cell styles.
     *  @type {CSSStyleName}
     *  @default "cubeCell"
     */
    override var baseStyle: String = definedExternally
    /**
     *  Whether alternating rows should be drawn in alternating styles, in order to create a "ledger"
     *   effect for easier reading. If enabled, the cell style for alternate rows will have "Dark"
     *   appended to it.
     *  @type {boolean}
     *  @default true
     */
    override var alternateRecordStyles: Boolean = definedExternally
    /**
     *  Default directory for skin images (those defined by the class), relative to the
     *   Page-wide Page.getSkinDir.
     *  @type {SCImgURL}
     *  @default "images/CubeGrid/"
     */
    override var skinImgDir: String = definedExternally
    /**
     *  Button.baseStyle for the buttons in the innermost column header for
     *   this cubeGrid.
     *  @type {CSSStyleName}
     *  @default "innerHeader"
     */
    open var innerHeaderBaseStyle: String = definedExternally
    /**
     *  Button.baseStyle for the buttons in this grid's column headers.
     * 
     *   Exception: The innermost column
     *   header will always be styled using CubeGrid.innerHeaderBaseStyle.
     *  @type {CSSStyleName}
     *  @default "colHeader"
     */
    open var colHeaderBaseStyle: String = definedExternally
    /**
     *  Button.baseStyle for the buttons in this grid's row headers.
     *  @type {CSSStyleName}
     *  @default "rowHeader"
     */
    open var rowHeaderBaseStyle: String = definedExternally
    /**
     *  If specified and this.showHover is true, this is the default width to apply
     *   to hover tips shown for facetValues. If unset, the hover canvas will be sized to
     *   this.hoverWidth if specified instead.
     *  @type {any}
     *  @default null
     */
    open var facetValueHoverWidth: dynamic = definedExternally
    /**
     *  If specified and this.showHover is true, this is the default width to apply
     *   to hover tips shown for facetLabels. If unset, the hover canvas will be sized to
     *   this.hoverWidth if specified instead.
     *  @type {any}
     *  @default null
     */
    open var facetLabelHoverWidth: dynamic = definedExternally
    /**
     *  If specified and this.showHover is true, this is the default height to apply
     *   to hover tips shown for facetValues. If unset, the hover canvas will be sized to
     *   this.hoverHeight if specified instead.
     *  @type {any}
     *  @default null
     */
    open var facetValueHoverHeight: dynamic = definedExternally
    /**
     *  If specified and this.showHover is true, this is the default height to apply
     *   to hover tips shown for facetLabels. If unset, the hover canvas will be sized to
     *   this.hoverHeight if specified instead.
     *  @type {any}
     *  @default null
     */
    open var facetLabelHoverHeight: dynamic = definedExternally
    /**
     *  Allows the developer to override the horizontal text alignment of hover tips shown for
     *   facet values. If unspecified the hover canvas content alignment will be set by
     *   this.hoverAlign if specified.
     *  @type {Alignment}
     *  @default null
     */
    open var facetValueHoverAlign: 
                                   /**
                                    *  Center within container.
                                    *  Stick to left side of container.
                                    *  Stick to right side of container.
                                    */
                                   String /* center |  left |  right */ = definedExternally
    /**
     *  Allows the developer to override the horizontal text alignment of hover tips shown for
     *   facetLabels. If unspecified the hover canvas content alignment will be set by
     *   this.hoverAlign if specified.
     *  @type {Alignment}
     *  @default null
     */
    open var facetLabelHoverAlign: 
                                   /**
                                    *  Center within container.
                                    *  Stick to left side of container.
                                    *  Stick to right side of container.
                                    */
                                   String /* center |  left |  right */ = definedExternally
    /**
     *  Allows the developer to override the vertical text alignment of hover tips shown for
     *   facet values. If unspecified the hover canvas content alignment will be set by
     *   this.hoverVAlign if specified.
     *  @type {VerticalAlignment}
     *  @default null
     */
    open var facetValueHoverVAlign: 
                                    /**
                                     *  At the top of the container
                                     *  Center within container.
                                     *  At the bottom of the container
                                     */
                                    String /* top |  center |  bottom */ = definedExternally
    /**
     *  Allows the developer to override the vertical text alignment of hover tips shown for
     *   facetLabels. If unspecified the hover canvas content alignment will be set by
     *   this.hoverVAlign if specified.
     *  @type {VerticalAlignment}
     *  @default null
     */
    open var facetLabelHoverVAlign: 
                                    /**
                                     *  At the top of the container
                                     *  Center within container.
                                     *  At the bottom of the container
                                     */
                                    String /* top |  center |  bottom */ = definedExternally
    /**
     *  Allows the developer to override the css class applied to hover tips shown for
     *   facet values. If unspecified, and this.hoverStyle is not null, that
     *   css class will be applied to facet value hovers instead.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var facetValueHoverStyle: String = definedExternally
    /**
     *  Allows the developer to override the css class applied to hover tips shown for
     *   facet labels. If unspecified, and this.hoverStyle is not null, that
     *   css class will be applied to facet label hovers instead.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var facetLabelHoverStyle: String = definedExternally
    /**
     *  A FacetValueMap describing the set of facet values that should be regarded as
     *   "fixed" in this cubeGrid. These are used as fixed criteria for load on demand, and also
     *   allow using a dataset with more facets in it than are currently shown in the grid.
     *  @type {FacetValueMap}
     *  @default null
     */
    open var fixedFacetValues: FacetValueMap = definedExternally
    /**
     *  Hilites to be applied to the data for this component. See hiliting.
     *  @type {Array<Partial<Hilite>>}
     *  @default null
     */
    override var hilites: Array<dynamic> = definedExternally
    /**
     *  DataSource to use to fetch CubeGrid data.
     * 
     *   The DataSource should have a field named after each facetId. The CubeGrid will submit
     *   requests for data as DataSource "fetch" operations that request
     *   CellRecord only for currently visible area
     *   (including ListGrid.drawAheadRatio). The Criteria passed
     *   in each fetch operation will be a FacetValueMap that corresponds to a rectangular
     *   swath of cells the CubeGrid needs data for, for example:
     *     { region:"west", product:["chair", "table"], timePeriod:"Q1 2004" }
     * 
     *   Note that in the criteria above, the Array value for the "product" facet indicates the
     *   CubeGrid needs cellRecords for both the "chair" and "table" facetValues.
     * 
     *   CubeGrid.fixedFacetValues, if any, are always sent in each "fetch" operation.
     * 
     *   Scrolling, expanding/collapsing tree facets, pivoting, and changing the currently
     *   visible facets may all trigger data requests.
     * 
     *   The CubeGrid will generally attempt to fetch a minimal set of data to fill the viewport,
     *   sending multiple fetch operations in a batch (via RPCManager.startQueue)
     *   which minimally describe newly revealed areas without specifying each individual cell.
     *   The CubeGrid will automatically handle being provided more data than was asked
     *   for, so server-side fetch-ahead policies can be implemented without any client-side
     *   customization.
     * 
     *   Note that the DataSource.serverType shipped with the SmartClient
     *   SDK is capable of responding to the CubeGrid's data requests without writing any custom
     *   server code.
     *  @type {DataSource}
     *  @default null
     */
    override var dataSource: dynamic = definedExternally
    /**
     *  If true, when this component is first drawn, automatically call this.fetchData().
     *   Criteria for this fetch may be picked up from CubeGrid.initialCriteria, and textMatchStyle may
     *   be specified via ListGrid.autoFetchTextMatchStyle.
     * 
     *   NOTE: if autoFetchData is set, calling
     *   ListGrid.fetchData before draw will cause two requests to be issued, one from the manual
     *   call to fetchData() and one from the autoFetchData setting. The second request will use
     *   only CubeGrid.initialCriteria and not any other criteria or settings from the first request.
     *   Generally, turn off autoFetchData if you are going to manually call ListGrid.fetchData at any time.
     *  @type {boolean}
     *  @default true
     */
    override var autoFetchData: Boolean = definedExternally
    /**
     *  If CubeGrid.autoFetchData is true, this attribute allows the developer to
     *   specify a textMatchStyle for the initial ListGrid.fetchData call.
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
     *  Criteria to be used when CubeGrid.autoFetchData is set.
     * 
     *   This property supports dynamicCriteria - use Criterion.valuePath
     *   to refer to values in the Canvas.ruleScope.
     *  @type {Criteria}
     *  @default null
     */
    override var initialCriteria: dynamic = definedExternally
    /**
     *  Facet definitions for this CubeGrid. Facets, also called "dimensions", are orthogonal
     *   aspects of the data model.
     * 
     *   For example, you can look at profit by the facets "plant and product" or by "product and
     *   plant" and it's the same number, because the facets - plant and product - are the same.
     *   What would change the profit numbers would be to remove a facet, called "summarizing",
     *   or add a new facet, called "drilling down". For example, showing profit by plant and
     *   product, you could "drill down" by adding the region facet, which would divide profit
     *   among each region. Or you could remove the "plant" facet, showing total profit for each
     *   "product", summed across all plants.
     * 
     *   This property need not be set and will automatically be constructed during widget
     *   initialization if data is provided up front and CubeGrid.rowFacets and
     *   CubeGrid.columnFacets have been set. If CubeGrid.facets is not set and
     *   there is no initial data but a DataSource is present, drawing the grid will
     *   automatically issue a fetch to allow CubeGrid.facets to be resolved.
     *  @type {Array<Partial<Facet>>}
     *  @default null
     */
    open var facets: Array<dynamic> = definedExternally
    /**
     *  If true, show facet label context menus with some built-in operations.
     *   Otherwise, use generic context menu handling.
     *  @type {boolean}
     *  @default false
     */
    open var showFacetContextMenus: Boolean = definedExternally
    /**
     *  If true, show facet value context menus with some built-in operations.
     *   Otherwise, use generic context menu handling.
     *   Use this in place of ListGrid.showHeaderContextMenu and
     *   ListGrid.showHeaderMenuButton for CubeGrids.
     *  @type {boolean}
     *  @default true
     */
    open var showFacetValueContextMenus: Boolean = definedExternally
    /**
     *  Determines whether cell values in the body can be selected.
     *  @type {boolean}
     *  @default true
     */
    open var canSelectValues: Boolean = definedExternally
    /**
     *  Determines whether row or column facetValue headers can be selected.
     *  @type {boolean}
     *  @default true
     */
    open var canSelectHeaders: Boolean = definedExternally
    /**
     *  If true, when multiple facets appear on one side in a nested headers presentation, the
     *   selection state of parent/child headers are automatically kept in sync.
     *  @type {boolean}
     *  @default true
     */
    open var autoSelectHeaders: Boolean = definedExternally
    /**
     *  Whether to select cells in the body when row or column headers are selected.
     *  @type {AutoSelectionModel}
     *  @default "both"
     */
    open var autoSelectValues: 
                               /**
                                *  Rows and Columns will be selected on header selection
                                *  Rows will be selected on row-header selection
                                *  Columns will be selected on column-header selection
                                *  Selecting row or column headers will not select cells in the body.
                                */
                               String /* both |  rows |  cols |  none */ = definedExternally
    /**
     *  If true, clicking on the existing selection causes it to be entirely deselected.
     *  @type {boolean}
     *  @default false
     */
    open var simpleDeselect: Boolean = definedExternally
    /**
     *  The list of Facet.id for facets that will appear on top of the body.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var columnFacets: Array<dynamic> = definedExternally
    /**
     *  The list of Facet.id for facets that will appear to the left of the body.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var rowFacets: Array<dynamic> = definedExternally
    /**
     *  This causes the headers for any combination of facetValues for which there are no
     *   cellRecords to be suppressed.
     * 
     *   To use this feature, either:
     * 
     * 
     *  - all must be provided via ListGrid.setData before the CubeGrid is first drawn, OR
     * 
     *  - all data must be returned by the first DataSource fetch, OR
     * 
     *  - CubeGrid.hideEmptyAxis must be set to either "row" or "column" so that empty values
     *   are only automatically hidden for one axis
     * 
     *   This last point is required because there is no way to determine whether a row is empty
     *   unless data for all columns of the row has been loaded (and vice-versa). For this
     *   reason if you set hideEmptyFacetValues but do not set hideEmptyAxis, the default
     *   behavior of DataSource is automatically disabled and
     *   only CubeGrid.fixedFacetValues will be sent as criteria.
     *  @type {boolean}
     *  @default null
     */
    open var hideEmptyFacetValues: Boolean = definedExternally
    /**
     *  With CubeGrid.hideEmptyFacetValues, controls on which axis hiding of empty values is applied,
     *   "row" (only empty rows are hidden), "column" (only empty columns are hidden) or both
     *   (the default).
     *  @type {Axis}
     *  @default null
     */
    open var hideEmptyAxis: 
                            /**
                             *  Row axis
                             *  Column axis
                             */
                            String /* row |  column */ = definedExternally
    /**
     *  An array of "cellRecords", each of which represents data for one cell of the body area.
     *  @type {Array<Partial<CellRecord>>}
     *  @default null
     */
    override var data: Array<dynamic> = definedExternally
    /**
     *  Name of the property in a cell record that holds the cell value.
     *  @type {Identifier}
     *  @default "_value"
     */
    open var valueProperty: String = definedExternally
    /**
     *  Name of the property in a cell record that holds it's unique ID. Note cell record IDs are
     *   optional.
     *  @type {Identifier}
     *  @default "ID"
     */
    open var cellIdProperty: String = definedExternally
    /**
     *  Whether cells can be edited in this grid. Can be overridden on a per-facetValue basis.
     *  @type {boolean}
     *  @default false
     */
    override var canEdit: Boolean = definedExternally
    /**
     *  CubeGrids only support editing by cell.
     *  @type {boolean}
     *  @default true
     */
    override var editByCell: Boolean = definedExternally
    /**
     *  CubeGrids only support editing by cell.
     *  @type {boolean}
     *  @default true
     */
    override var saveByCell: Boolean = definedExternally
    /**
     *  For Browser.isTouch, canDragSelect defaults to false
     *   so that touch scrolling can be used to navigate scrollable CubeGrids. In all other
     *   browsers it defaults to true.
     * 
     *   NOTE: If canDragSelect is enabled, it may be desirable to disable
     *   Canvas.useTouchScrolling so that touch-dragging cells of the CubeGrid
     *   selects them rather than starting a scroll. If Canvas.disableTouchScrollingForDrag
     *   is set to true, then touch scrolling will be disabled automatically.
     *   However, for accessibility reasons, it is recommended to
     *   leave touch scrolling enabled and provide an alternative set of controls that can be
     *   used to perform drag-selection.
     *  @type {boolean}
     *  @default null
     */
    override var canDragSelect: Boolean = definedExternally
    /**
     *  If true, body columns can be reordered via the innermost column headers.
     *  @type {boolean}
     *  @default null
     */
    open var canReorderColumns: Boolean = definedExternally
    /**
     *  If true, body columns can be resized via the innermost column headers.
     *  @type {boolean}
     *  @default null
     */
    open var canResizeColumns: Boolean = definedExternally
    /**
     *  If true, hierarchical facets will show expand/collapse controls to allow the user to
     *   expand and collapse the tree of facetValues for that facet.
     *  @type {boolean}
     *  @default false
     */
    open var canCollapseFacets: Boolean = definedExternally
    /**
     *  If true, when multiple facets are shown on a side, all facetValues in the second level
     *   of headers or higher will show controls to "minimize" the values of the next facet.
     *   Minimizing means showing only one, or very few, of the next facet's values.
     * 
     *   Set FacetValue.isMinimizeValue to indicate which facetValues should be
     *   shown when a facet is minimized.
     *  @type {boolean}
     *  @default false
     */
    open var canMinimizeFacets: Boolean = definedExternally
    /**
     *  FacetValueMap of facet values representing a set of facetValues by which the
     *   cubeGrid data is sorted.
     *  @type {FacetValueMap}
     *  @default null
     */
    open var sortedFacetValues: FacetValueMap = definedExternally
    /**
     *  Direction of sorting if sortedFacet or sortedFacetValues is specified.
     *  @type {SortDirection}
     *  @default "ascending"
     */
    override var sortDirection: 
                                /**
                                 *  Sort in ascending order (eg: A-Z, larger items later in the list)
                                 *  Sort in descending order (eg: Z-A, larger items earlier in the list)
                                 */
                                String /* ascending |  descending */ = definedExternally
    /**
     *  If true, sort controls will be shown on FacetHeaders.
     * 
     *   When clicked, sort controls call CubeGrid.sortByFacetId.
     *  @type {boolean}
     *  @default null
     */
    open var canSortFacets: Boolean = definedExternally
    /**
     *  If true, sort controls will be shown on facet values.
     * 
     *   When clicked, sort controls call CubeGrid.sortByFacetValues.
     *  @type {boolean}
     *  @default null
     */
    open var canSortData: Boolean = definedExternally
    /**
     *  If true, allow columns in the grid body to be minimized (reduced to the width of the
     *   minimize control) by clicking on a minimize control in the innermost column headers.
     *  @type {boolean}
     *  @default null
     */
    open var canMinimizeColumns: Boolean = definedExternally
    /**
     *  Whether row and column facets can be rearranged by the user, by dragging and dropping the
     *   facet labels.
     *  @type {boolean}
     *  @default false
     */
    open var canMoveFacets: Boolean = definedExternally
    /**
     *  If enabled row headers for this cubeGrid will be rendered using a GridRenderer
     *   component. This improves performance for very large cubeGrids.
     * 
     *   Note that this attribute must be set for hierarchical row facets to be indented properly.
     *  @type {boolean}
     *  @default false
     */
    open var rowHeaderGridMode: Boolean = definedExternally
    /**
     *  Automatically size row headers to fit wrapped text.
     *  @type {boolean}
     *  @default false
     */
    open var autoSizeHeaders: Boolean = definedExternally
    /**
     *  Default alignment for facet labels.
     *  @type {Alignment}
     *  @default "center"
     */
    open var facetTitleAlign: 
                              /**
                               *  Center within container.
                               *  Stick to left side of container.
                               *  Stick to right side of container.
                               */
                              String /* center |  left |  right */ = definedExternally
    /**
     *  Default alignment for facet values (in headers).
     *  @type {Alignment}
     *  @default "center"
     */
    open var facetValueAlign: 
                              /**
                               *  Center within container.
                               *  Stick to left side of container.
                               *  Stick to right side of container.
                               */
                              String /* center |  left |  right */ = definedExternally
    /**
     *  Default align for cell values (in body).
     *  @type {Alignment}
     *  @default "center"
     */
    open var cellAlign: 
                        /**
                         *  Center within container.
                         *  Stick to left side of container.
                         *  Stick to right side of container.
                         */
                        String /* center |  left |  right */ = definedExternally
    /**
     *  Whether to allow text wrapping on facet titles.
     *  @type {boolean}
     *  @default false
     */
    open var wrapFacetTitles: Boolean = definedExternally
    /**
     *  Whether to allow text wrapping on facet value titles.
     *  @type {boolean}
     *  @default false
     */
    open var wrapFacetValueTitles: Boolean = definedExternally
    /**
     *  Whether to pad titles so they aren't flush with header borders.
     *  @type {boolean}
     *  @default true
     */
    open var padTitles: Boolean = definedExternally
    /**
     *  Default width of inner column headers.
     *  @type {number}
     *  @default "100"
     */
    open var defaultFacetWidth: Number = definedExternally
    /**
     *  facetValueId of the default rollupValue for each facet. Can be overridden per facet via
     *   facet.rollupValue.
     *  @type {string}
     *  @default "sum"
     */
    open var rollupValue: String = definedExternally
    /**
     *  In a CubeGrid that displays values of different types (eg "Revenue" and "Income"), the
     *   different types of values on display are enumerated as the facet values of the "metric
     *   facet".
     * 
     *   The metric facet is treated identically to any other facet by the CubeGrid: it can be
     *   represented as row or column headers, can be innermost or have other facets under it,
     *   can be moved around, etc. However when a metric facet is used, CubeGrid.metricFacetId
     *   must be set to allow the CubeGrid to generate meaningful descriptions of values shown in
     *   cells for use in hovers and other situations; see CubeGrid.valueTitle for a full
     *   explanation.
     *  @type {string}
     *  @default "metric"
     */
    open var metricFacetId: String = definedExternally
    /**
     *  A label for the data values shown in cells, such as "Sales in Thousands", typically used
     *   when the CubeGrid must generate a description for a cell value or set of cell values.
     * 
     *   For example, in a CubeGrid showing "Revenue" by region and product, a cell with a
     *   CellRecord like:
     * 
     *   {product:"chairs", region:"northwest", _value:"$5k"}
     * 
     *   Should be described as "Revenue for Chairs for Northwest Region", not "Chairs for
     *   Revenue for Northwest Region".
     * 
     *   For CubeGrids that show multiple types of values at once (eg both "Revenue" and
     *   "Income") see CubeGrid.metricFacetId.
     *  @type {string}
     *  @default null
     */
    open var valueTitle: String = definedExternally
    /**
     *  Minimum width for the body of this cubeGrid.
     *  @type {number}
     *  @default null
     */
    open var bodyMinWidth: Number = definedExternally
    /**
     *  Minimum height for the body of this cubeGrid.
     *  @type {number}
     *  @default null
     */
    open var bodyMinHeight: Number = definedExternally
    /**
     *  If set to true, context menu items will be included on the cells and headers providing the
     *   user with an option to create a chart of the cubeGrid's data set.
     *   See CubeGrid.makeChart for more information.
     *  @type {boolean}
     *  @default false
     */
    open var enableCharting: Boolean = definedExternally
    /**
     *  Name of the SmartClient Class to be used when creating charts. Must support the
     *   Chart interface.
     *  @type {string}
     *  @default "FacetChart"
     */
    override var chartConstructor: String = definedExternally
    /**
     *  Default type of chart to plot.
     *  @type {ChartType}
     *  @default "Column"
     */
    override var chartType: 
                            /**
                             *  Values represented by area, with stacked values representing multiple          facet values. This is equivalent to ChartType "Line" with stacking enabled.
                             *  Values represented by vertical columns. Typically supports stacking to         represent two facets. May support simultaneous stacking and clustering for
                             *           3 facets.
                             *  Values represented by horizontal bars. Typically supports stacking to         represent two facets. May support simultaneous stacking and clustering for
                             *           3 facets.
                             *  Values represented by a lines between data points, or stacked areas for         multiple facets.
                             *  Values represented on a circular background by a line around the center, or         stacked areas for multiple facets
                             *  Circular chart with wedges representing values. Multiple or stacked pies         for multiple facets.
                             *  Like a pie chart with a central hole. Multiple or stacked doughnuts for         multiple facets.
                             *  A chart with two continuous numeric axes and up to one discrete facet.
                             *  A chart with two continuous numeric axes and up to one discrete facet         that also displays values from a third continuous, numeric domain
                             *           represented as the sizes of the data point shapes.
                             *  Like a column chart, except instead of showing stacked or clustered values         for each position on the horizontal axis, the data values are used together
                             *           with the associated FacetChart.endValueMetric values to show a series
                             *           of line segments.
                             */
                            String /* Area |  Column |  Bar |  Line |  Radar |  Pie |  Doughnut |  Scatter |  Bubble |  Histogram */ = definedExternally
    /**
     *  If CubeGrid.makeChart is called with a chart specification that will show more than
     *   chartConfirmThreshold data elements, the user will be presented with a
     *   isc.confirm.
     * 
     *   Set to 0 to disable this confirmation.
     *  @type {number}
     *  @default "2000"
     */
    open var chartConfirmThreshold: Number = definedExternally
    /**
     *  Default separator string used by CubeGrid.exportClientData to separate column
     *   and row facet value titles.
     *  @type {string}
     *  @default " - "
     */
    open var exportFacetSeparatorString: String = definedExternally
    /**
     *  Array of MenuItem to replace the default menu.
     *   Call CubeGrid.getDefaultFacetValueContextItems to get a default set of
     *   items to start with.
     *  @type {Array<Partial<MenuItem>>}
     *  @default null
     */
    open var facetValueContextItems: Array<dynamic> = definedExternally
    /**
     *  Sets the background color for the row and column headers of the cube,
     *   if not otherwise set by a more specific property.
     *   (see CubeGrid.exportRowFacetBGColor and
     *   CubeGrid.exportColumnFacetBGColor).
     *   See also exportBGColor.
     *  @type {CSSColor}
     *  @default null
     */
    open var exportFacetBGColor: String = definedExternally
    /**
     *  Sets the background color for the row headers of the cube.
     *   See also exportBGColor.
     *  @type {CSSColor}
     *  @default null
     */
    open var exportRowFacetBGColor: String = definedExternally
    /**
     *  Sets the background color for the column headers of the cube.
     *   See also exportBGColor.
     *  @type {CSSColor}
     *  @default null
     */
    open var exportColumnFacetBGColor: String = definedExternally
    /**
     *  Sets the text color for the row and column headers of the cube,
     *   if not otherwise set by a more specific property.
     *   (see CubeGrid.exportRowFacetTextColor and
     *   CubeGrid.exportColumnFacetTextColor).
     *  @type {CSSColor}
     *  @default null
     */
    open var exportFacetTextColor: String = definedExternally
    /**
     *  Sets the text color for the row headers of the cube.
     *  @type {CSSColor}
     *  @default null
     */
    open var exportRowFacetTextColor: String = definedExternally
    /**
     *  Sets the text color for the column headers of the cube.
     *  @type {CSSColor}
     *  @default null
     */
    open var exportColumnFacetTextColor: String = definedExternally
    /**
     *  FormatString for numeric or date formatting. See DataSourceField.format.
     *  @type {FormatString}
     *  @default null
     */
    open var valueFormat: String = definedExternally
    /**
     *  FormatString used during exports for numeric or date formatting. See
     *   DataSourceField.exportFormat.
     *  @type {FormatString}
     *  @default null
     */
    open var valueExportFormat: String = definedExternally
    /**
     *   Returns the row number of the most recent mouse event.
     * 
     *  @param {Integer=} optional y-coordinate to obtain row number, in lieu of the y            coordinate of the last mouse event
     */
    override fun getEventRow(y: Number?): Number = definedExternally
    /**
     *   Returns the column number of the most recent mouse event.
     * 
     *  @param {Integer=} optional x-coordinate to obtain column number for, in lieu of the x            coordinate of the last mouse event
     */
    override fun getEventColumn(x: Number?): Number = definedExternally
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
     *   Return the base stylename for this cell. Default implementation just returns this.baseStyle.
     *   See ListGrid.getCellStyle for a general discussion of how to style cells.
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    override fun getBaseStyle(record: ListGridRecord, rowNum: Number, colNum: Number): String = definedExternally
    /**
     *   Set the temporary edit values for some cell in the cubeGrid.
     *   Note that only the CubeGrid.valueProperty of the object passed in
     *   will be displayed in the cell.
     * 
     *  @param {Array<Partial<number>>} 2 element array of the form          [rowNum,colNum] indicating the record being edited
     *  @param {object} New values for the record
     */
    open fun setEditValues(cell: Array<dynamic>, values: dynamic): Unit = definedExternally
    /**
     * 
     *   Set the edit value for some cell in the cube grid.
     *   Note that cubeGrids display one record per cell - the value passed in should be the
     *   desired edit value for the CubeGrid.valueProperty of the record.
     * 
     * 
     *  @param {number} Row number
     *  @param {number} Column number
     *  @param {any} New value for the record
     */
    override fun setEditValue(rowNum: Number, colNum: dynamic, value: dynamic): Unit = definedExternally
    /**
     * 
     *   Returns the current temporary locally stored edit value for a cell being edited.
     *   Note this is the CubeGrid.valueProperty that will be saved for the
     *   cell in question.
     * 
     * 
     *  @param {number} index of the row for which the editValue should be returned
     *  @param {number} index of the column for which value should be returned
     */
    override fun getEditValue(rowNum: Number, colNum: dynamic): dynamic = definedExternally
    /**
     *   Returns the combination of unsaved edits (if any) and original values (if any) for a given
     *   cell being edited.
     * 
     *   The returned value is never null, and can be freely modified.
     * 
     * 
     *  @param {number | object} rowNum of the record being edited, or an Object                   containing values for all the record's primary keys
     *  @param {number=} colNum of the record being edited. Only required if the records             rowNum is passed in as the first parameter
     */
    open fun getEditedRecord(valuesID: dynamic, colNum: Number?): dynamic = definedExternally
    /**
     *   Returns the current value of a cell. If the cell has an outstanding edit value, this will
     *   be returned, otherwise the underlying value of the record will be returned.
     * 
     * 
     *  @param {number | object} rowNum of the record being edited, or an Object                   containing values for all the record's primary keys
     *  @param {number} colNum of the cell. Only required if the first parameter is               a rowNum
     */
    override fun getEditedCell(record: dynamic, field: dynamic): dynamic = definedExternally
    /**
     *   Returns the current set of unsaved edits for a given row being edited.
     * 
     * 
     *  @param {number | object} rowNum of the record being edited, or an Object                   containing values for all the record's primary keys
     *  @param {number} colNum of the record being edited. Only required if valuesID             is passed in as a rowNum.
     */
    open fun getEditValues(valuesID: dynamic, colNum: Number): dynamic = definedExternally
    /**
     * 
     *   Clear a field value being tracked as an unsaved user edit for some cell.
     *   The saved record value will be displayed in the the appropriate cell instead.
     * 
     * 
     *  @param {number | object} Row number, primary keys object for the record,                       or editValues object
     *  @param {number=} Column number for the cell in question. Only required if the               first parameter is a row number.
     */
    override fun clearEditValue(editValuesID: dynamic, colNum: dynamic?): Unit = definedExternally
    /**
     * 
     *   Validates and saves edits for some cell. If rowNum and colNum are not passed in, the current
     *   edit cell will be saved.
     * 
     *   The 'callback' parameter provides a notification when the save attempt completes.
     *   Cases under which the callback will fire are:
     * 
     *  - Save completed successfully
     * 
     *  - No changes to the edited cell, so save not required
     * 
     *  - Validation failure occurred on the client or on the server
     *   Note that if no rowNum/colNum were passed in and the editor is not showing for the cell,
     *   the callback will NOT fire - in this case, the method is a no-op.
     * 
     *   Other, standard callbacks such as ListGrid.editComplete,
     *   ListGrid.editFailed and ListGrid.cellChanged will
     *   fire normally.
     * 
     *   Note this method does not hide the inline editors if they are showing - to explicitly save
     *   and end editing, use the method 'endEditing()'
     * 
     * 
     *  @param {EditCompletionEvent=} Event used to complete cell editing.     Optional, and defaults to "programmatic". Can be used by the      callback method to perform custom actions such as navigation when the      save completes.
     *  @param {Callback=} Callback to fire on completion of the saving process.                  If no edits were made or client-side validation fails                   the callback will be fired synchronously at the end of this                   method.                   Takes the following parameters:                   - rowNum (Number) edited row number                   - colNum (Number) edited column number                   - editCompletionEvent (EditCompletionEvent) event                    passed in (defaults to "programmatic")                   - success (boolean) false if the save was unable to                    complete due to a validation failure or server-side                    error.
     *  @param {number=} Which row should be saved. If unspecified the current edit row              is saved by default. Note that if there is no current edit cell               this method will no op.
     *  @param {number=} Which row should be saved. If unspecified the current edit column              is saved by default. Note that if there is no current edit cell               this method will no op.
     */
    override fun saveEdits(editCompletionEvent: 
                                                /**
                                                 *  User clicked outside editor during edit.
                                                 *  User started editing another row by clicking on it
                                                 *  User started editing another row by double                clicking
                                                 *  Enter pressed.
                                                 *  User pressed Escape.
                                                 *  Up arrow key pressed.
                                                 *  down arrow key.
                                                 *  User pressed Tab.
                                                 *  User pressed Shift+Tab.
                                                 *  Edit moved to a different field (same row)
                                                 *  Edit completed via explicit function call
                                                 */
                                                String /* click_outside |  click |  doubleClick |  enter |  escape |  arrow_up |  arrow_down |  tab |  shift_tab |  field_change |  programmatic */?, callback: dynamic?, rowNum: Number?, colNum: Number?): Unit = definedExternally
    /**
     *   Method to determine which records currently have pending (unsubmitted) edits.
     *   Returns an array of 2 element arrays indicating the [rowNum,colNum] of the
     *   cells in question.
     * 
     */
    open fun getAllEditCells(): Array<dynamic> = definedExternally
    /**
     * 
     * 
     *  @param {Array<Partial<any>>=} allows you to specify which cell(s) to drop          edits for. Each record should be identified as an array containing          [rowNum,colNum]
     *  @param {boolean=} By default this method will hide the editor if               it is currently showing for any row in the grid. Passing in                this parameter will leave the editor visible (and just reset                the edit values underneath the editor).
     */
    override fun discardAllEdits(rows: Array<dynamic>?, dontHideEditor: Boolean?): Unit = definedExternally
    /**
     *   If this cubeGrid can be edited, this method will return true if the record passed in has been
     *   edited, but the edits have not yet been saved to the CubeGrid's data object.
     * 
     *  @param {number} row index of record to check for changes
     *  @param {number} column index of the record to check for changes
     */
    open fun recordHasChanges(rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Determines whether any cells in this cubeGrid have been edited but not yet saved to the
     *   underlying data set.
     * 
     */
    override fun hasChanges(): Boolean = definedExternally
    /**
     *   Save a number of outstanding edits for this CubeGrid. If no cells are specified, all
     *   outstanding edits will be saved
     * 
     *  @param {Array<Partial<any>>=} optionally specify which cells to save. Each cell should be specified as a 2 element array in the format [rowNum,colNum].
     *  @param {Callback=} If specified this callback will be fired on a successful save of the specified rows. Note that if there are no pending edits to be saved this callback will  not fire - you can check for this condition using CubeGrid.hasChanges or  CubeGrid.recordHasChanges.
     */
    override fun saveAllEdits(rows: Array<dynamic>?, saveCallback: dynamic?): Boolean = definedExternally
    /**
     *   Get a facet definition by facetId. Constant time.
     * 
     * 
     *  @param {string} the id of the facet to retrieve
     */
    open fun getFacet(facetId: String): Facet = definedExternally
    /**
     *   Get a facet value definition by facetId and facetValueId. Constant time.
     * 
     * 
     *  @param {string} the id of the facet to retrieve
     *  @param {string} the id of the facet value to retrieve
     */
    open fun getFacetValue(facetId: String, facetValueId: String): FacetValue = definedExternally
    /**
     *   Get the facetValue definition for the facetValue to show when this facet is "rolled up" under
     *   another facet, during a breakout.
     * 
     *   A facet is not required to have a rollup value, and if it does not have one, then rollups will
     *   simply be blank rows. The facetValueId of the rollup value can be declared as
     *   cubeGrid.rollupValue or facet.rollupValue.
     * 
     * 
     */
    open fun getRollupValue(): String = definedExternally
    /**
     *   Given a cell coordinate within this CubeGrid return a FacetValueMap
     *   indicating the facet values for the cell.
     * 
     *  @param {number} row index of the cell
     *  @param {number} column index of the cell
     */
    open fun getCellFacetValues(rowNum: Number, colNum: Number): FacetValueMap = definedExternally
    /**
     *   Get the index of the first column in the grid that matches the specified FacetValueMap.
     * 
     *   The facetValues passed in should contain values for at least one column facet. It may
     *   contain properties other than column facets, which will be ignored. If values are
     *   sparse (values not specified for every column facet), the first column matching the specified
     *   facet values will be returned.
     * 
     * 
     *  @param {FacetValueMap} facet values to find
     */
    open fun getFacetValuesColumn(facetValues: FacetValueMap): Number = definedExternally
    /**
     *   Get the index of the first row in the grid that matches the specified FacetValueMap.
     * 
     *   The facetValues passed in should contain values for at least one row facet. It may contain
     *   properties other than row facets, which will be ignored. If values are
     *   sparse (values not specified for every row facet), the first row matching the specified
     *   facet values will be returned.
     * 
     * 
     *  @param {FacetValueMap} facet values to find
     */
    open fun getFacetValuesRow(facetValues: FacetValueMap): Number = definedExternally
    /**
     *   Return a FacetValueMap indicating the facet values for a specific
     *   row in the grid.
     * 
     *  @param {number} index of the row
     */
    open fun getRowFacetValues(rowNum: Number): FacetValueMap = definedExternally
    /**
     *   Return a FacetValueMap indicating the facet values for a specific
     *   column in the grid.
     * 
     *  @param {number} index of the column
     */
    open fun getColumnFacetValues(colNum: Number): FacetValueMap = definedExternally
    /**
     *   Return the pointer to a particular record by record and column number.
     * 
     *  @param {number} row index of record to return.
     *  @param {number} column index of record to return.
     */
    open fun getCellRecord(rowNum: Number, colNum: Number): ListGridRecord = definedExternally
    /**
     *   Given a record in this grid, this method returns the rowNum on which the record is displayed.
     * 
     *  @param {CellRecord} record to find coordinates for
     */
    open fun getCellRow(cellRecord: CellRecord): Number = definedExternally
    /**
     *   Given a record in this grid, this method returns the colNum in which the record is displayed.
     * 
     *  @param {CellRecord} record to find coordinates for
     */
    open fun getCellColumn(cellRecord: CellRecord): Number = definedExternally
    /**
     *   Given a record in this grid, this method returns the coordinates of the cell in which the
     *   record is displayed as a 2 element array.
     * 
     *  @param {CellRecord} record to find coordinates for
     */
    open fun getCellCoordinates(record: CellRecord): Array<dynamic> = definedExternally
    /**
     *   Notification method fired when new data arrives from the server to be displayed in this
     *   CubeGrid. For example in response to the user openng a collapsed facet, or as a result of
     *   an initial fetch request for all data from a CubeGrid where CubeGrid.facets is not
     *   set and there is no initial data. Only applies to databound CubeGrids.
     * 
     */
    open fun dataArrived(): Unit = definedExternally
    /**
     *   Method handler fired when the user clicks on a facet label.
     * 
     * 
     */
    open fun facetLabelClick(): Unit = definedExternally
    /**
     *   Get the HTML for the facet label hover. Default implementation returns null.
     *   methodType callback
     * 
     *  @param {string} ID for the facet
     */
    open fun facetLabelHoverHTML(facetId: String): Unit = definedExternally
    /**
     *   Get the HTML for the facetValue button hover. Default implementation returns null.
     * 
     * 
     *  @param {FacetValueMap} facetValues object for the button
     */
    open fun facetValueHoverHTML(facetValues: FacetValueMap): Unit = definedExternally
    /**
     *   Toggles the open state of the specified field. No-ops if it's not showing.
     * 
     *  @param {FacetValueMap} field specified as a facetValueMap
     */
    open fun toggleFieldOpenState(facetValueMap: FacetValueMap): Boolean = definedExternally
    /**
     *   Expands the specified field. No-ops if it's not showing, or if it's already expanded.
     * 
     *  @param {FacetValueMap} field specified as a facetValueMap
     */
    open fun expandField(facetValueMap: FacetValueMap): Boolean = definedExternally
    /**
     *   Collapses the specified field. No-ops if it's not showing, or it it's already collapsed.
     * 
     *  @param {FacetValueMap} field specified as a facetValueMap
     */
    open fun collapseField(facetValueMap: FacetValueMap): Boolean = definedExternally
    /**
     *   auto-size the header facet horizontally
     * 
     *  @param {string} ID of facet to resize.
     */
    open fun autoSizeFacet(facetId: String): Unit = definedExternally
    /**
     * 
     *   Handler fired when facet is closed
     * 
     *     methodType handler
     * 
     *  @param {string} ID of facet that was closed
     */
    open fun closeFacet(facetId: String): Unit = definedExternally
    /**
     * 
     *   Handler fired when column is closed
     * 
     *     methodType handler
     * 
     *  @param {FacetValue} FacetValues for the appropriate col.
     */
    open fun closeColumn(headerFacetValues: FacetValue): Unit = definedExternally
    /**
     *   Handler/Notification function for facetValue selection change (no default implementation).
     * 
     * 
     *  @param {FacetValueMap} facetValues with new selection state
     *  @param {boolean} new selection state
     */
    open fun facetValueSelectionChanged(facetValues: FacetValueMap, newState: Boolean): Unit = definedExternally
    /**
     *   Returns an array of the selected cell records.
     * 
     *   methodType getter
     * 
     */
    open fun getSelectedCells(): Array<dynamic> = definedExternally
    /**
     *   Returns an array of the IDs of all selected cell records.
     * 
     *   methodType getter
     * 
     */
    open fun getSelectedCellIds(): Array<dynamic> = definedExternally
    /**
     *   Determine whether any cells are selected in this cubeGrid.
     * 
     *   methodType tester
     * 
     */
    open fun anyCellSelected(): Boolean = definedExternally
    /**
     *   Determine whether the cell passed in is selected in this cubeGrid.
     * 
     *   methodType tester
     * 
     *  @param {CellRecord} cell to test
     */
    open fun cellIsSelected(cell: CellRecord): Boolean = definedExternally
    /**
     *   Select / deselect a single cell - accepts cell ID or CellRecord.
     * 
     * 
     *  @param {CellRecord | GlobalId} cell to select / deselect
     *  @param {boolean=} new selection state (if null, defaults to true)
     */
    open fun selectCell(cell: dynamic, newState: Boolean?): Unit = definedExternally
    /**
     *   Deselect a single cell - accepts cell ID or cell record.
     * 
     * 
     *  @param {CellRecord | GlobalId} cell to deselect
     */
    open fun deselectCell(cell: dynamic): Unit = definedExternally
    /**
     *   Select/deselect cells that match a FacetValueMap.
     *   Also supports an explicit list of CellRecords or cell IDs.
     * 
     * 
     *  @param {Array<Partial<CellRecord>> | FacetValueMap | Array<Partial<GlobalId>>} cells to select
     *  @param {boolean=} new selection state (if null, defaults to true)
     */
    open fun selectCells(cellList: dynamic, newState: Boolean?): Unit = definedExternally
    /**
     *   Deselect cells that match a FacetValueMap.
     *   Also supports an explicit list of CellRecords or cell IDs.
     * 
     * 
     *  @param {Array<Partial<CellRecord>> | FacetValueMap | Array<Partial<GlobalId>>} cells to deselect
     */
    open fun deselectCells(cellList: dynamic): Unit = definedExternally
    /**
     *   Select all cells.
     * 
     * 
     */
    open fun selectAllCells(): Unit = definedExternally
    /**
     *   Deselect all cells.
     * 
     * 
     */
    open fun deselectAllCells(): Unit = definedExternally
    /**
     *   Returns an array of facetValues objects indicating the headers that are selected in the
     *   headerBar for this facet. If facetId is not passed, returns selection for all
     *   facets.
     * 
     * 
     *  @param {string=} id for facet for which we are getting selected facetValues
     */
    open fun getSelectedFacetValues(facetId: String?): Array<dynamic> = definedExternally
    /**
     *   Return whether the header indicated by the set of facetValues is selected.
     * 
     * 
     *  @param {FacetValueMap} facetValues to test
     */
    open fun facetValuesSelected(facetValues: FacetValueMap): Boolean = definedExternally
    /**
     *   Return whether any facet value for this facet is selected in headers. If no facetId passed,
     *   return whether any facet has a selection.
     * 
     *   methodType tester
     * 
     *  @param {string} Id for facet to test
     */
    open fun facetHasSelection(facetId: String): Boolean = definedExternally
    /**
     *   Return the list of facets that have any selection in their headers.
     * 
     *   methodType getter
     * 
     */
    open fun getFacetsHavingSelection(): Array<dynamic> = definedExternally
    /**
     *   Select/deselect the header showing a given set of facet values.
     * 
     * 
     *  @param {FacetValueMap} facetValues to select the header of
     *  @param {boolean=} new selection state - if null defaults to true
     */
    open fun selectFacetValues(facetValues: FacetValueMap, newState: Boolean?): Unit = definedExternally
    /**
     *   Deselect the header showing a given set of facet values.
     * 
     *   methodType action
     * 
     *  @param {FacetValueMap} facetValues to deselect
     */
    open fun deselectFacetValues(facetValues: FacetValueMap): Unit = definedExternally
    /**
     *   Select/deselect the header for a given facet value.
     * 
     *   methodType action
     * 
     *  @param {string} ID of facet
     *  @param {string} ID of facetValue to select
     *  @param {boolean=} new selection state - if null defaults to true
     */
    open fun selectFacetValue(facetId: String, facetValueId: String, newState: Boolean?): Unit = definedExternally
    /**
     *   Deselect the header for a given facet value.
     * 
     *   methodType action
     * 
     *  @param {string} ID of facet
     *  @param {string} ID of facetValue to select
     */
    open fun deselectFacetValue(facetId: String, facetValueId: String): Unit = definedExternally
    /**
     *   Select/deselect all headers in a headerBar (specified by facetId) or
     *   all headerBars (if no facetId).
     * 
     *   methodType action
     * 
     *  @param {string=} ID of facet - if null, selects all headerbars' headers
     *  @param {boolean=} new selection state - if null defaults to true
     */
    open fun selectAllFacetValues(facetId: String?, newState: Boolean?): Unit = definedExternally
    /**
     *   Deselect all headers in a headerBar (specified by facetId) or
     *   all headerBars (if no facetId).
     * 
     *   methodType action
     * 
     *  @param {string=} ID of facet - if null, selects all headerbars' headers
     */
    open fun deselectAllFacetValues(facetId: String?): Unit = definedExternally
    /**
     *   Deselect all cells and facetValues.
     * 
     *     methodType action
     * 
     */
    open fun deselectAll(): Unit = definedExternally
    /**
     *   Resizes all columns for the provided facetValueId, which must be a facetValueId from the
     *   innermost column facet.
     * 
     * 
     *  @param {Identifier} facetValueId of columns to be resized
     *  @param {number} column's new width
     */
    open fun resizeFacetValue(facetValueId: String, newWidth: Number): Unit = definedExternally
    /**
     *     Apply a hilite to a specific cell.
     *     Note: can be called either as
     *       hiliteCell(cellObject, hiliteID) or
     *       hiliteCell(row, column, hiliteID)
     * 
     *     methodType action
     * 
     *  @param {any | any} cell to hilite / row of cell to hilite
     *  @param {string | any} hilite ID / column of cell to hilite
     *  @param {string=} optional third parameter - hilite ID.
     */
    open fun hiliteCell(cellObj: dynamic, hiliteID: dynamic, alternateHiliteID: String?): Boolean = definedExternally
    /**
     *     Apply a hilite to an array of cells.
     * 
     *     methodType action
     * 
     *  @param {Array<Partial<any>>} cells to hilite
     *  @param {string} ID of hilite to apply to cells
     */
    open fun hiliteCellList(cellObjList: Array<dynamic>, hiliteID: String): Boolean = definedExternally
    /**
     *     Apply a hilite to all cells corresponding to a facetValue.
     * 
     *     methodType action
     * 
     *  @param {string} facet ID
     *  @param {string} facet value ID
     *  @param {string} hilite ID
     */
    open fun hiliteFacetValue(facetID: String, facetValueID: String, hiliteID: String): Boolean = definedExternally
    /**
     *   Set the title of a facet (appears in facet label).
     * 
     * 
     *  @param {Identifier} facet to update
     *  @param {string} title for the facet
     */
    open fun setFacetTitle(facetId: String, newTitle: String): Unit = definedExternally
    /**
     *   Set the align of a facet title (appears in facet label).
     * 
     * 
     *  @param {Identifier} facet to update
     *  @param {Alignment} new alignment for facet title
     */
    open fun setFacetTitleAlign(facetId: String, align: 
                                                        /**
                                                         *  Center within container.
                                                         *  Stick to left side of container.
                                                         *  Stick to right side of container.
                                                         */
                                                        String /* center |  left |  right */): Unit = definedExternally
    /**
     *   Set the title for a facet value.
     * 
     * 
     *  @param {Identifier} facet to update
     *  @param {Identifier} facetValue to update
     *  @param {string} title for the facet
     */
    open fun setFacetValueTitle(facetId: String, facetValueId: String, newTitle: String): Unit = definedExternally
    /**
     *   Set the align for the title for a facet value.
     * 
     * 
     *  @param {Identifier} facet to update
     *  @param {Identifier} facetValue to update
     *  @param {Alignment} new alignment for facet value title
     */
    open fun setFacetValueTitleAlign(facetId: String, facetValueId: String, align: 
                                                                                   /**
                                                                                    *  Center within container.
                                                                                    *  Stick to left side of container.
                                                                                    *  Stick to right side of container.
                                                                                    */
                                                                                   String /* center |  left |  right */): Unit = definedExternally
    /**
     *   Get the current visual order and width for the facet values of a facet or facetValueGroup as
     *   an object of the form:
     * 
     *   [ {id:facetValueId, width:currentWidth }, ... ]
     * 
     * 
     * 
     *  @param {string | string} Which facet do we want details for?
     */
    open fun getFacetValueLayout(id: String): Array<dynamic> = definedExternally
    /**
     *   Get the current widths of the row facets, as an object of the form:
     * 
     *   [ {facetId:facetId, width:currentWidth }, ... ]
     * 
     * 
     * 
     */
    open fun getRowFacetLayout(): Array<dynamic> = definedExternally
    /**
     *   Get the current heights of the column facets, as an object of the form:
     * 
     *   [ {facetId:facetId, height:currentHeight}, ... ]
     * 
     * 
     * 
     */
    open fun getColumnFacetLayout(): Array<dynamic> = definedExternally
    /**
     *   Setter for the CubeGrid.enableCharting attribute.
     * 
     * \* @param {boolean} 
     */
    open fun setEnableCharting(enableCharting: Boolean): Unit = definedExternally
    /**
     *   Chart the portion of the dataset indicated by fixedFacetValues, for all
     *   values of the variableFacets.
     * 
     *   One, two or more variableFacets may be passed. Two variable facets for a column chart will
     *   result in Chart.stacked or clustering. Three facets or more may be
     *   supported by some CubeGrid.chartType or
     *   CubeGrid.chartConstructor.
     * 
     * 
     *  @param {FacetValueMap} set of facet values to hold constant. Pass null to                     chart the entire dataset.
     *  @param {Array<Partial<string>>} set of facets to be charted
     *  @param {Chart} properties to pass through to the created            Chart
     */
    open fun makeChart(fixedFacetValues: FacetValueMap, variableFacets: Array<dynamic>, chartProperties: Chart): Chart = definedExternally
    /**
     *   Returns a default set of items, which can be updated/modified, and then assigned to
     *   CubeGrid.facetValueContextItems to be used in the context menu of the appropriate
     *   header button.
     * 
     * 
     *  @param {FacetValueMap} FacetValueMap for the appropriate header button
     */
    open fun getDefaultFacetValueContextItems(facetValues: FacetValueMap): Array<dynamic> = definedExternally
    /**
     *   Add a row facet to the view at index "index". Handles the facet already being in the view
     *   (does a pivot).
     * 
     *   The facet being added should currently have a fixed facet value (unless it's already part of the
     *   view), which will be removed from cubeGrid.fixedFacetValues.
     * 
     *   methodType action
     * 
     *  @param {Identifier} facetId to add. Definition must have been provided at init time.
     *  @param {Integer=} index to add the facet at. 0 = outermost (default innermost)
     */
    open fun addRowFacet(facetId: String, index: Number?): Unit = definedExternally
    /**
     *   Add a column facet to the view at index "index". Handles the facet already being in the view
     *   (does a pivot).
     * 
     *   The facet being added should currently have a fixed facet value (unless it's already part of the
     *   view), which will be removed from cubeGrid.fixedFacetValues.
     * 
     *   methodType action
     * 
     *  @param {Identifier} facetId to add. Definition must have been provided at init time.
     *  @param {Integer=} index to add the facet at. 0 = outermost (default innermost)
     */
    open fun addColumnFacet(facetId: String, index: Number?): Unit = definedExternally
    /**
     * 
     *   Add a facet to the view, into the row or column facets (intoRows true or false), at index
     *   "index". Handles the facet already being in the view (does a pivot).
     * 
     *   The facet being added should currently have a fixed facet value (unless it's already part of the
     *   view), which will be removed from cubeGrid.fixedFacetValues.
     * 
     * 
     *  @param {Identifier} facetId to add. Definition must have been provided at init time.
     *  @param {boolean=} [true] whether to add facet as a row facet
     *  @param {Integer=} index to add the facet at. 0 = outermost (default innermost)
     */
    open fun addFacet(facetId: String, intoRows: Boolean?, index: Number?): Unit = definedExternally
    /**
     * 
     *   Remove a facet from the current view, using a fixed value from that facet. For example, remove
     *   the "months" facet from the view, collapsing to just January, or total for all months.
     * 
     * 
     *  @param {Identifier} facetId to remove
     *  @param {Identifier=} New fixed value for the facet, to be added to             CubeGrid.fixedFacetValues. Default is the rollup value for the facet.
     */
    open fun removeFacet(facetId: String, fixedFacetValueId: String?): Unit = definedExternally
    /**
     * 
     *   Modify fixedFacetValues for this cubeGrid.
     * 
     * 
     *  @param {Identifier} facetId
     *  @param {Identifier} New fixed value for the facet, to be added to             CubeGrid.fixedFacetValues. Default is the rollup value for the facet.
     */
    open fun setFixedFacetValue(facetId: String, fixedFacetValueId: String): Unit = definedExternally
    /**
     *   Note that CubeGrid does not support a WYSIWYG print view by default(also used when
     *   RPCManager.exportContent). Instead we recommend
     *   DataSource.exportClientData.
     * 
     * 
     *  @param {PrintProperties=} properties to configure printing behavior - may be null.
     *  @param {Callback=} optional callback. This is required to handle cases where HTML         generation is asynchronous - if a method generates HTML asynchronously, it should return          null, and fire the specified callback on completion of HTML generation. The          first parameter HTML should contain the generated print HTML.          The callback is only called if null is returned. Furthermore, the default          getPrintHTML() implementation always returns null and fires the callback          when a callback is provided.
     */
    override fun getPrintHTML(printProperties: PrintProperties?, callback: dynamic?): String = definedExternally
    /**
     *   Exports this component's data with client-side formatters applied, so is suitable for direct
     *   display to users. This feature requires the SmartClient server.
     * 
     *   The export format will combine the column facet value titles, generating a single row of
     *   column headers at the top with titles such as "All Years - Budget" if Time and Scenario were
     *   column facets. The row facet value titles for separate facets won't be combined, so that
     *   each row facet will have a separate column, with the facet titles at the top in the
     *   "column header" row, and the row facet value titles below their corresponding facet title.
     *   Data values each get their own row and column position.
     * 
     * 
     *  @param {object} contains configuration settings for the export, including:
     *  - facetSeparatorString (String) - if specified, the separator to use in favor   of CubeGrid.exportFacetSeparatorString when combining titles from multiple   facet values.
     *  @param {DSRequest=} Request properties for the export.
     *  @param {RPCCallback=} Optional callback. If you specify DSRequest.exportToClient: false in the request  properties, this callback will fire after export completes. Otherwise the callback will  fire right before the download request is made to the server.
     */
    open fun exportClientData(settings: dynamic, requestProperties: DSRequest?, callback: ((response: RPCResponse, rawData: dynamic, request: RPCRequest) -> Unit?)): Unit = definedExternally
    /**
     *   StringMethod handler fired when mouseover occurs over a facetValues header button
     * 
     * 
     *  @param {FacetValueMap} FacetValueMap for the appropriate header button
     */
    open fun facetValueOver(facetValues: FacetValueMap): Unit = definedExternally
    /**
     *   StringMethod handler fired when mouseout occurs for a facetValues header button
     * 
     *  @param {FacetValueMap} FacetValueMap for the appropriate header button
     */
    open fun facetValueOut(facetValues: FacetValueMap): Unit = definedExternally
    /**
     *   StringMethod handler fired when mouse hovers over a facetValue button in a header.
     * 
     *  @param {FacetValueMap} FacetValueMap for the appropriate header button
     */
    open fun facetValueHover(facetValues: FacetValueMap): Unit = definedExternally
    /**
     *   StringMethod handler fired when context click occurs over a facetValue button in a header.
     * 
     * 
     *  @param {FacetValueMap} FacetValueMap describing the appropriate header button
     */
    open fun facetValueContextClick(facetValues: FacetValueMap): Unit = definedExternally
    /**
     *   StringMethod handler fired when the user right clicks on a facet label.
     * 
     * 
     *  @param {string} ID of facet
     */
    open fun facetContextClick(facetId: String): Unit = definedExternally
    /**
     * 
     *   Notification fired when a facet or facetValueGroup is reordered
     * 
     * 
     *  @param {string} facetValueGroupId or facetId
     */
    open fun facetValueReordered(groupId: String): Unit = definedExternally
    /**
     *     Notification fired when a new facet is added.
     * 
     * 
     *  @param {string} facetId that was added
     */
    open fun facetAdded(facetId: String): Unit = definedExternally
    /**
     *   Notification fired when a facet is removed.
     * 
     * 
     *  @param {string} facetId that was removed
     */
    open fun facetRemoved(facetId: String): Unit = definedExternally
    /**
     *   Notification fired when a facet is moved.
     * 
     * 
     *  @param {string} facetId which moved
     */
    open fun facetMoved(facetId: String): Unit = definedExternally
    /**
     *   Notification fired when a fixed facet value is set for some facet.
     * 
     *  @param {string} facetId
     *  @param {string} new fixed facet value
     */
    open fun fixedFacetValueChanged(facetId: String, facetValueId: String): Unit = definedExternally
    /**
     *   Called when a sort control is clicked on a FacetValueHeader. Does nothing by default.
     * 
     * 
     *  @param {FacetValueMap} facetValues to sort
     *  @param {boolean} true for ascending
     */
    open fun sortByFacetValues(facetValues: FacetValueMap, sortDirection: Boolean): Unit = definedExternally
    /**
     *   Called when a sort control is clicked on a FacetHeader. Does nothing by default.
     * 
     * 
     *  @param {string} ID of facet to sort
     *  @param {boolean} true for ascending
     */
    open fun sortByFacetId(facetId: String, sortDirection: Boolean): Unit = definedExternally
    /**
     *   StringMethod handler fired when mouseover occurs over a facet label
     * 
     * 
     * 
     *  @param {string} ID of the appropriate facet
     */
    open fun facetLabelOver(facetId: String): Unit = definedExternally
    /**
     *   StringMethod handler fired when mouseout occurs over a facet label
     * 
     * 
     *  @param {string} ID of the appropriate facet
     */
    open fun facetLabelOut(facetId: String): Unit = definedExternally
    /**
     *   StringMethod handler fired from hover over a facet label
     * 
     * 
     *  @param {string} ID of the appropriate facet
     */
    open fun facetLabelHover(facetId: String): Unit = definedExternally
    /**
     * 
     *     Handler/Notification function for cell selection change
     *     May update header button styles.
     * 
     *     methodType handler
     * 
     *  @param {Array<Partial<CellRecord>>} array of cells with new selection state
     */
    override fun cellSelectionChanged(cellList: Array<dynamic>): Boolean = definedExternally
    companion object {
        /**
         *  Creates a new CubeGrid
         * 
         *  @param typeCheckedProperties {Partial<CubeGrid>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {CubeGrid} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): CubeGrid = definedExternally
    }
}