@file:JsQualifier("isc")
package isc

/**
 *  ResultSets are an implementation of the List interface that automatically fetches
 *   DataSource records when items are requested from the List. ResultSets provide robust,
 *   customizable, high-performance cache management for ListGrids and other built-in SmartClient
 *   components, and can be used as cache managers by custom components.
 * 
 *   ResultSets manage data paging, that is, loading records in batches as the user navigates
 *   the data set. A ResultSet will switch to using client-side sorting and filtering when
 *   possible to improve responsiveness and reduce server load. ResultSets also participate in
 *   automatic cache synchronization, observing operations on DataSources and automatically
 *   updating their caches.
 * 
 *   Creation
 * 
 *   A ResultSet can be passed to any component that expects a List, and the List APIs can be
 *   called directly on the ResultSet as long as the caller is able to deal with asynchronous
 *   loading; see ResultSet.getRange.
 * 
 *   Generally ResultSets do not need to be created directly, but are created by DataBound
 *   components as an automatic consequence of calling
 *   dataBoundComponentMethods.
 *   For example, the ListGrid.fetchData causes ListGrid.data to become an
 *   automatically created ResultSet object. Automatically created ResultSets
 *   can be customized via properties on ListGrids such as ListGrid.dataPageSize and
 *   ListGrid.dataProperties. All ResultSets for a given DataSource may also be
 *   customized via setting DataSource.resultSetClass to the name of a ResultSet
 *   isc.defineClass in which
 *   Class.addProperties.
 * 
 *   A ResultSet defaults to using data paging, setting DSRequest.startRow and
 *   DSRequest.endRow in issued dsRequests. Server code may always return more rows than
 *   the ResultSet requests and the ResultSet will correctly integrate those rows based on
 *   DSResponse.startRow/DSResponse.endRow.
 *   Hence the server can always avoid paging mode by simply returning all matching rows.
 * 
 *   A ResultSet can be created directly with just the ID of a DataSource:
 * 
 *     isc.ResultSet.create({
 *       dataSource : "dataSourceID"
 *     })
 * 
 * 
 *   Directly created ResultSets are typically used by custom components, or as a means of
 *   managing datasets that will be used by several components.
 * 
 *   When created directly rather than via a dataBoundComponent, a newly created ResultSet will
 *   not issue it's first "fetch" DSRequest until data is accessed (for example, via
 *   ResultSet.get).
 * 
 *   Paging and total dataset length
 * 
 *   When using data paging, the server communicates the total number of records that match the
 *   current search criteria by setting DSResponse.totalRows. The ResultSet will then
 *   return this number from ResultSet.getLength, and ListGrids and other
 *   components will show a scrollbar that allows the user to jump to the end of the dataset
 *   directly.
 * 
 *   However, the ResultSet does not require that the server calculate the true length of the
 *   dataset, which can be costly for an extremely large, searchable dataset. Instead, the
 *   server may simply advertise a totalRows value that is one page larger
 *   than the last row loaded. This results in a UI sometimes called "progressive loading",
 *   where the user may load more rows by scrolling past the end of the currently loaded rows,
 *   but is not allowed to skip to the end of the dataset.
 * 
 *   No client-side settings are required to enable this mode - it is entirely server-driven.
 *   However, it is usually coupled with ListGrid.canSort, since
 *   server-side sorting would also force the server to traverse the entire dataset. Note
 *   also the DataSource.progressiveLoading flag, which can be applied
 *   at a DataSource, operation, request, component or ResultSet level; if you are using the
 *   built-in server-side DataSource implementations with Pro or better, this tells SmartClient
 *   Server to use its pre-built progressive loading mode for that DataSource, operation,
 *   request, component or ResultSet.
 * 
 *   Client-side Sorting and Filtering
 * 
 *   If a ResultSet obtains a full cache for the current set of filter criteria, it will
 *   automatically switch to client-side sorting, and will also use client-side filtering
 *   if the filter criteria are later changed but appear to be more restrictive than the
 *   criteria in use when the ResultSet obtained a full cache.
 * 
 *   The ResultSet.useClientSorting and
 *   ResultSet.useClientFiltering flags can be used to disable
 *   client-side sorting and filtering respectively if these behaviors don't match server-based
 *   sorting and filtering. However, because client-side sorting and filtering radically improve
 *   responsiveness and reduce server load, it is better to customize the ResultSet so that it
 *   can match server-side sorting and filtering behaviors.
 * 
 *   Sorting behavior is primarily customized via the "sort normalizer" passed to
 *   ResultSet.sortByProperty, either via direct calls on a standalone ResultSet, or via
 *   ListGridField.sortNormalizer for a ListGrid-managed ResultSet.
 * 
 *   By default, client-side filtering interprets the Criteria passed to
 *   ResultSet.setCriteria as a set of field values that records must match
 *   (similarly to the built-in SQL/Hibernate connectors built into the SmartClient Server).
 *   Custom client-side filtering logic can be implemented by overriding
 *   ResultSet.applyFilter. Overriding
 *   ResultSet.compareCriteria allows you to control when the ResultSet
 *   uses client-side vs server-side filtering, and the ResultSet has two default
 *   ResultSet.criteriaPolicy built-in.
 * 
 *   Modifying ResultSets
 * 
 *   Records cannot be directly added or removed from a ResultSet via List
 *   APIs such as List.removeAt, since this would break the consistency of
 *   server and client row numbering needed for data paging, and also
 *   create some issues with automatic cache synchronization.
 * 
 *   Use DataSource.addData/DataSource.removeData to add/remove
 *   rows from the DataSource, and the ResultSet will reflect the changes automatically.
 *   Alternatively, the DataSource.updateCaches method may be called to only update
 *   local caches of the DataSource in question, without generating any server traffic.
 * 
 *   To create a locally modifiable cache of Records from a DataSource, you
 *   can use DataSource.fetchData to retrieve a List of Records which can
 *   be modified directly, or you can create a client-only DataSource from
 *   the retrieved data to share a modifiable cache between several
 *   DataBoundComponents.
 * 
 *   Updates and Automatic Cache Synchronization
 * 
 *   Once a ResultSet has retrieved data or has been initialized with data, the ResultSet will observe any
 *   successful "update", "add" or "remove" dsRequests against their DataSource, regardless of the
 *   component that initiated them. A ResultSet with a full cache for the current filter criteria will
 *   integrate updates into the cache automatically.
 * 
 *   Updated rows that no longer match the current filter criteria will be removed
 *   automatically. To prevent this, you can set ResultSet.neverDropUpdatedRows.
 *   Added rows will similarly be added to the cache only if they match current filter criteria.
 * 
 *   Note that the client-side filtering described above is also used to determine whether
 *   updated or added rows should be in the cache. If any aspect of automated cache update is
 *   ever incorrect, ResultSet.dropCacheOnUpdate can be set for the
 *   ResultSet or DSResponse.invalidateCache can be set for an individual dsResponse.
 * 
 *   If automatic cache synchronization isn't working, troubleshoot the problem using the steps
 *   suggested in the FAQ.
 * 
 *   Regarding OperationBinding.operationId and how they affect caching,
 *   take into account that cache sync is based on the fetch used - any add or update operation
 *   uses a fetch to retrieve updated data, and the operationId of that fetch can be set via
 *   OperationBinding.cacheSyncOperation.
 *   If the operationId of the cache is different from the operationId of the cache update data,
 *   it won't be used to update the cache, since the fields included and other aspects of the
 *   data are allowed to be different across different operationIds. This allows to maintain
 *   distinct caches on a per component basis, so when two components are using separate
 *   operationIds they are assumed to have distinct caches, because updates performed with
 *   one operationId will not affect the cache obtained via another operationId.
 *   Also, take into account that operationId must be unique per DataSource, across all
 *   operationTypes for that DataSource.
 * 
 * 
 *   Data Paging with partial cache
 * 
 *   When in paging mode with a partial cache, a ResultSet relies on server side sorting, setting
 *   DSRequest.sortBy to the current sort field and direction. In order for the cache to
 *   remain coherent, row numbering must continue to agree between server and client as new
 *   fetches are issued, otherwise, duplicate rows or missing rows may occur.
 * 
 *   If concurrent modifications by other users are allowed, generally the server should set
 *   DSResponse.invalidateCache to clear the cache when concurrent modification is
 *   detected.
 * 
 *   In paging mode with a partial cache, any successful "update" or "add" operation may cause
 *   client and server row numbering to become out of sync. This happens because the update
 *   may affect the sort order, and client and server cannot be guaranteed to match for sets of
 *   records that have equivalent values for the sort field.
 * 
 *   For this reason, after an "add" or "update" operation with a partial cache, the ResultSet
 *   will automatically mark cache for invalidation the next time a fetch operation is performed.
 *   Alternatively, if ResultSet.updatePartialCache is set to false, the ResultSet will
 *   simply invalidate cache immediately in this circumstance.
 */
open external class ResultSet : Class, List {
    /**
     *  Mode of fetching records from the server. If unset, will default to "local"
     *   if ResultSet.allRows is specified, otherwise "paged".
     *  @type {FetchMode}
     *  @default null
     */
    open var fetchMode: 
                        /**
                         *  All records that match the current filter are fetched. Sorting is        performed on the client.
                         *  Only requested ranges of records are fetched, with predictive fetch        ahead. Sorting is performed on the server.
                         *  All records available from the DataSource are fetched. Filtering by        search criteria and sorting are both performed on the client.
                         */
                        String /* basic |  paged |  local */ = definedExternally
    /**
     *  Initial set of data for the ResultSet.
     * 
     *   This data will be treated exactly as though it were the data returned from the
     *   ResultSet's first server fetch.
     * 
     *   By default, initialData will be considered a complete response
     *   (all rows that match the Criteria which the ResultSet was initialized with).
     * 
     *   Set ResultSet.initialLength to treat initialData as a partial response,
     *   equivalent to receiving a DSResponse with startRow:0,
     *   endRow:initialData.length and totalRows:initialLength.
     *   Normal data paging will then occur if data is requested for row indices not filled via
     *   initialData.
     * 
     *   initialData may be provided as a "sparse" array, that is, slots may be left
     *   null indicating rows that have not been loaded. In this way you can create a ResultSet
     *   that is missing rows at the beginning of the dataset, but has loaded rows toward the end,
     *   so that you can create a component that is scrolled to a particular position of a dataset
     *   without loading rows at the beginning.
     *  @type {Array<Partial<Record>>}
     *  @default null
     */
    open var initialData: Array<dynamic> = definedExternally
    /**
     *  Initial value of the data set length.
     * 
     *   To create a ResultSet with it's cache partly filled, see ResultSet.initialData.
     *  @type {Integer}
     *  @default null
     */
    open var initialLength: Number = definedExternally
    /**
     *  Initial sort specifiers for a ResultSet. Use ResultSet.setSort and
     *   ResultSet.getSort to sort the data after initialization rather than
     *   attempting to read or modify this property directly.
     * 
     *   Note: if ResultSet.initialData was specified, the data is assumed to already
     *   be sorted to match this sort configuration.
     *  @type {Array<Partial<SortSpecifier>>}
     *  @default null
     */
    open var sortSpecifiers: Array<dynamic> = definedExternally
    /**
     *  If the complete set of records for a resultSet is available when the resultSet is created,
     *   it can be made available to the resultSet via this property at initialization time.
     *   This data will then be considered cached meaning sorting and filtering can occur on
     *   the client (no need for server fetch).
     * 
     *   This cached data can be dropped via a call to ResultSet.invalidateCache.
     * 
     *   See also ResultSet.initialData and ResultSet.initialLength as an alternative approach for
     *   initializing a ResultSet with a partial cache, such that data paging will occur as
     *   uncached rows are requested.
     *  @type {Array<Partial<Record>>}
     *  @default null
     */
    open var allRows: Array<dynamic> = definedExternally
    /**
     *  How many rows to retrieve at once.
     * 
     *   Applicable only with fetchMode: "paged". When a paged ResultSet is asked
     *   for rows that have not yet been loaded, it will fetch adjacent rows that are likely to
     *   be required soon, in batches of this size.
     *  @type {Integer}
     *  @default "75"
     */
    open var resultSize: Number = definedExternally
    /**
     *  Delay in milliseconds before fetching rows.
     * 
     *   When a get() or getRange() call asked for rows that haven't been loaded, the
     *   ResultSet will wait before actually triggering the request. If, during the delay, more
     *   get() or getRange() calls are made for missing rows, the final fetch to the server will
     *   reflect the most recently requested rows.
     * 
     *   The intent of this delay is to avoid triggering many unnecessary fetches during
     *   drag-scrolling and similar user interactions.
     *  @type {Integer}
     *  @default "0"
     */
    open var fetchDelay: Number = definedExternally
    /**
     *  What DataSource is this resultSet associated with?
     *  @type {DataSource}
     *  @default null
     */
    open var dataSource: dynamic = definedExternally
    /**
     *  DSRequest.operationId this component should use when performing fetch operations.
     *  @type {string}
     *  @default null
     */
    open var fetchOperation: String = definedExternally
    /**
     *  Allows to set a DSRequest properties to this ResulSet.
     *  @type {DSRequest}
     *  @default null
     */
    open var requestProperties: DSRequest = definedExternally
    /**
     *  Criteria that are never shown to or edited by the user and are cumulative with any
     *   criteria provided via DataBoundComponent.initialCriteria, ResultSet.setCriteria
     *   etc.
     *  @type {Criteria}
     *  @default null
     */
    open var implicitCriteria: dynamic = definedExternally
    /**
     *  Filter criteria used whenever records are retrieved.
     * 
     *   Use ResultSet.setCriteria to change the criteria after initialization.
     *  @type {Criteria}
     *  @default null
     */
    open var criteria: dynamic = definedExternally
    /**
     *  Decides under what conditions the cache should be dropped when the Criteria
     *   changes.
     *  @type {CriteriaPolicy}
     *  @default null
     */
    open var criteriaPolicy: 
                             /**
                              *  Cache is dropped whenever criteria changes.
                              *  Cache is retained as long as the only changes to criteria               make the criteria more restrictive as determined by
                              *                 ResultSet.compareCriteria.
                              */
                             String /* dropOnChange |  dropOnShortening */ = definedExternally
    /**
     *  Whether to sort data locally when all records matching the current criteria have been
     *   cached.
     * 
     *   This may need to be disabled if client-side sort order differs from server-side sort
     *   order in a way that affects functionality or is surprising.
     *  @type {boolean}
     *  @default true
     */
    open var useClientSorting: Boolean = definedExternally
    /**
     *  Whether to filter data locally when all DataSource records have been loaded (that is,
     *   criteria is blank and cache is complete).
     * 
     *   This may need to be disabled if client-side filtering differs from server-side filtering
     *   in a way that affects functionality or is surprising.
     * 
     *   This setting is distinct from fetchMode:"local", which explicitly loads all
     *   available DataSource records up front and always performs all filtering on the client.
     * 
     *   See ResultSet.applyFilter for default filtering behavior.
     * 
     *   NOTE: even with useClientFiltering false, client-side filtering will be used
     *   during cache sync to determine if an updated or added row matches the current criteria.
     *   To avoid relying on client-side filtering in this case, either:
     *   - avoid returning update data when the updated row doesn't match the current filter
     *   - set dropCacheOnUpdate
     *  @type {boolean}
     *  @default true
     */
    open var useClientFiltering: Boolean = definedExternally
    /**
     *  When a successful Add, Update or Remove type operation fires on this ResultSet's
     *   dataSource, if DSResponse.data is unset, should we integrate the submitted
     *   data values (from the request) into our data-set? This attribute will be passed to
     *   DataSource.getUpdatedData as the useDataFromRequest parameter.
     *  @type {boolean}
     *  @default true
     */
    open var updateCacheFromRequest: Boolean = definedExternally
    /**
     *  Whether to discard all cached rows when a modification operation (add, update, remove)
     *   occurs on the ResultSet's DataSource.
     * 
     *   A ResultSet that has a complete cache for the current filter criteria can potentially
     *   incorporate a newly created or updated row based on the data that the server returns
     *   when a modification operation completes. However this is not always possible for
     *   ResultSets that show some types of joins, or when the server cannot easily return update
     *   data. In this case set dropCacheOnUpdate to cause the cache to be
     *   discarded when an update occurs.
     * 
     *   dropCacheOnUpdate can be set either directly on a ResultSet, or on a
     *   DataSource in order to affect all ResultSets on that DataSource.
     *  @type {boolean}
     *  @default false
     */
    open var dropCacheOnUpdate: Boolean = definedExternally
    /**
     *  By default when the data of this ResultSet's dataSource is modified, the ResultSet will
     *   be updated to display these changes.
     *   Set this flag to true to disable this behavior.
     *  @type {boolean}
     *  @default false
     */
    open var disableCacheSync: Boolean = definedExternally
    /**
     *  Sets DataSource.progressiveLoading for this ResultSet.
     *   Any DSRequests issued by this ResultSet will copy this setting onto the request,
     *   overriding the OperationBinding- and DataSource-level settings.
     * 
     *   This setting is applied automatically by DataBoundComponents that have their
     *   own explicit setting for DataBoundComponent.progressiveLoading
     *  @type {boolean}
     *  @default null
     */
    open var progressiveLoading: Boolean = definedExternally
    /**
     *  By default when a row is returned by the server, the current ResultSet.setCriteria are applied to it, and it may disappear from the cache.
     * 
     *   Set this flag to true to disable this behavior.
     *  @type {boolean}
     *  @default false
     */
    open var neverDropUpdatedRows: Boolean = definedExternally
    /**
     *  If set to true, updated and added rows will be integrated into the client-side cache
     *   even if paging is enabled and cache is partial. If updatePartialCache is
     *   false, the cache will be invalidated and new data fetched.
     * 
     *   If updatePartialCache is enabled and an "add" or "update" operation succeeds with a partial
     *   cache:
     * 
     * 
     *  - updated rows will remain in their current position. No attempt will be made to sort
     *   them into a new position even if the sort field was updated.
     * 
     *  - newly added rows will be added at either the end (first preference) or beginning of
     *   the dataset if that part of the dataset is cached and was most recently requested.
     *   If not, the new row is added at the end of the most recently requested contiguously
     *   cached range.
     * 
     *   The cache will then be dropped the next time rows are fetched, to prevent problems with
     *   inconsistent row numbering between the server and client, which could otherwise lead to
     *   duplicate rows or rows being skipped entirely.
     *  @type {boolean}
     *  @default true
     */
    open var updatePartialCache: Boolean = definedExternally
    /**
     *  If true, records requested only for visible area.
     *  @type {boolean}
     *  @default false
     */
    open var alwaysRequestVisibleRows: Boolean = definedExternally
    /**
     *   Do we have a complete client-side cache of records for the current filter criteria?
     * 
     *   Returns false if this is a paged data set, and the entire set of records that
     *   match the current criteria has not been retrieved from the server. In other words, a
     *   return value of false means that this ResultSet has a partial cache.
     * 
     * 
     */
    open fun allMatchingRowsCached(): Boolean = definedExternally
    /**
     *   Do we have a complete client-side cache of all records for this DataSource?
     * 
     *   Becomes true only when the ResultSet obtains a complete cache after a fetch with empty
     *   criteria.
     * 
     * 
     */
    open fun allRowsCached(): Boolean = definedExternally
    /**
     *   Get a map of the form { item[idField] -&gt; item[displayField] }, for all
     *   items in the list. If more than one item has the same idProperty,
     *   the value for the later item in the list will clobber the value for the earlier item.
     * 
     *   If this method is called when the ResultSet.allMatchingRowsCached, it
     *   will trigger fetches, and will return a valueMap reflecting only the currently loaded rows.
     * 
     * 
     *  @param {string} Property to use as ID (data value) in the valueMap
     *  @param {string} Property to use as a display value in the valueMap
     */
    override fun getValueMap(idField: String, displayField: String): dynamic = definedExternally
    /**
     *   Return the total number of records that match the current filter criteria.
     * 
     *   This length can only be known, even approximately, when the first results are retrieved from
     *   the server. Before then, the ResultSet returns a large length in order to encourage viewers
     *   to ask for rows. ResultSet.lengthIsKnown can be called to
     *   determine whether an actual length is known.
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
     *   NOTE: ResultSet.indexOf() only inspects the current cache of records, so it is only
     *   appropriate for temporary presentation purposes. For example, it would not be appropriate
     *   to hold onto a record and attempt to use indexOf() to determine if it had been deleted.
     * 
     * 
     *  @param {any} object to look for
     *  @param {number=} earliest index to consider
     *  @param {number=} last index to consider
     */
    override fun indexOf(obj: dynamic, pos: Number?, endPos: Number?): Number = definedExternally
    /**
     *   Returns the record at the specified position.
     * 
     *   All List access methods of the ResultSet have the semantics described in getRange().
     * 
     *  @param {number} position of the element to get
     */
    override fun get(pos: Number): dynamic = definedExternally
    /**
     *   Return the items between position start and end, non-inclusive at the end, possibly
     *   containing markers for records that haven't loaded yet.
     * 
     *   Calling getRange for records that have not yet loaded will trigger an asynchronous fetch. The
     *   returned data will contain the ResultSet.getLoadingMarker as a placeholder
     *   for records being fetched. If any rows needed to be fetched, dataArrived() will
     *   fire when they arrive.
     * 
     * 
     *  @param {number} start position
     *  @param {number} end position
     */
    override fun getRange(start: Number, end: Number): Array<dynamic> = definedExternally
    /**
     *   Returns all rows that match the current criteria.
     * 
     *   This method will not trigger a fetch to load more records. getAllVisibleRows()
     *   will return null if ResultSet.lengthIsKnown is false.
     * 
     *   Records are returned in a new List but the Records within it are the same
     *   instances that the ResultSet is holding onto. Hence it's safe to add or remove records from
     *   the List without affecting the ResultSet but modifying the Records themselves is a direct
     *   modification of the client-side cache.
     * 
     */
    open fun getAllVisibleRows(): Array<dynamic> = definedExternally
    /**
     *   Determine whether the ResultSet is showing a filtered, proper subset of the cached rows.
     *   This happens if ResultSet.useClientFiltering is enabled. Rows may have been
     *   loaded from the server when a more restrictive criteria is applied such that filtering could
     *   be performed on the client side.
     * 
     *   This method returns false if data is not loaded yet.
     * 
     */
    open fun usingFilteredData(): Boolean = definedExternally
    /**
     *   Returns a list of all rows that have been cached. This is potentially a superset of all rows
     *   that are available via ResultSet.getAllVisibleRows if the ResultSet is using client-side
     *   filtering to display a subset of loaded rows (see the ResultSet).
     * 
     *   If ResultSet.usingFilteredData returns false, this is the same list as would be returned by
     *   ResultSet.getAllVisibleRows.
     * 
     *   This method will not trigger a fetch to load more records. getAllCachedRows() will return
     *   null if ResultSet.lengthIsKnown is false.
     * 
     *   Records are returned in a new List but the Records within it are the same
     *   instances that the ResultSet is holding onto. Hence it's safe to add or remove records from
     *   the List without affecting the ResultSet but modifying the Records themselves is a direct
     *   modification of the client-side cache.
     * 
     */
    open fun getAllCachedRows(): Array<dynamic> = definedExternally
    /**
     *   Returns a clone of this ResultSet sharing the same DataSource, current criteria, sort
     *   direction and cache state.
     * 
     *   Internal caches are copied such that methods such as ResultSet.lengthIsKnown,
     *   ResultSet.allMatchingRowsCached and ResultSet.allRowsCached return identical results for the
     *   new ResultSet.
     * 
     *   Subsequent changes to criteria or sort direction on the original ResultSet with not affect
     *   the duplicate, and vice versa. Outstanding fetches on the original ResultSet will likewise
     *   have no effect on the duplicate when they complete. However, actual Record instances are
     *   shared between the original and copied ResultSet, so direct modification of Records will
     *   affect both ResultSets.
     * 
     *   The new ResultSet will listen for DataSource changes and automatically update caches just
     *   as normal ResultSets do.
     * 
     *   NOTE: if you are looking for a simple list of Records rather than a new, fully
     *   functional ResultSet, consider ResultSet.getAllCachedRows or ResultSet.getAllVisibleRows. If
     *   you are looking to create a filterable, sortable subset of the current ResultSet, consider
     *   creating a new ResultSet and passing the results of getAllCachedRows or
     *   getAllVisibleRows as the initial value of ResultSet.allRows.
     * 
     */
    override fun duplicate(): Array<dynamic> = definedExternally
    /**
     *   Whether the ResultSet actually knows how many records are available from the server.
     *   The ResultSet will not know how many records are available when initially fetching and
     *   filtering data. Note that the value returned from ResultSet.getLength will be
     *   an arbitrary, large value if the actual length is not known.
     * 
     */
    open fun lengthIsKnown(): Boolean = definedExternally
    /**
     *   Whether the given row has been loaded.
     * 
     *   Unlike get(), will not trigger a server fetch.
     * 
     * 
     *  @param {number} row to check
     */
    open fun rowIsLoaded(rowNum: Number): Boolean = definedExternally
    /**
     *   Whether the given range of rows has been loaded.
     * 
     *   Unlike getRange(), will not trigger a server fetch.
     * 
     * 
     *  @param {number} start position, inclusive
     *  @param {number} end position, exclusive
     */
    open fun rangeIsLoaded(startRow: Number, endRow: Number): Boolean = definedExternally
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
    open fun findByKey(keyValue: dynamic): Record = definedExternally
    /**
     *   Set the filter criteria to use when fetching rows.
     * 
     *   Depending on the result of ResultSet.compareCriteria and settings for
     *   ResultSet.useClientFiltering / FetchMode, setting criteria may cause a trip to the
     *   server to get a new set of rows, or may simply cause already-fetched rows to be re-filtered
     *   according to the new Criteria. In either case, the dataset length available from
     *   ResultSet.getLength may change and rows will appear at different indices.
     * 
     *   The filter criteria can be changed while server fetches for data matching the old criteria
     *   are still outstanding. If this is the case, the ResultSet will make sure that any records received
     *   matching the old criteria are not added to the cache for the new criteria. Any callbacks
     *   for responses to the outstanding requests are fired as normal, and the responses'
     *   DSResponse.totalRows counts are kept (as they are still potentially meaningful
     *   to components using the ResultSet), but the response data is cleared so that it won't be used
     *   inadvertently as data matching the new criteria.
     * 
     *   Note: for simple Criteria, any field values in the criteria explicitly specified as null
     *   will be passed to the server. By default the server then returns only records whose value
     *   is null for that field. This differs from certain higher level methods such as
     *   ListGrid.fetchData which prune null criteria fields before performing a fetch
     *   operation.
     * 
     * 
     *  @param {Criteria} the filter criteria
     */
    open fun setCriteria(newCriteria: dynamic): Boolean = definedExternally
    /**
     *   Get the current criteria for this ResultSet.
     * 
     */
    open fun getCriteria(): dynamic = definedExternally
    /**
     *   Default behavior is to call DataSource.compareCriteria to determine whether new
     *   criteria is guaranteed more restrictive, equivalent to the old criteria, or not guaranteed
     *   more restrictive, returning 1, 0 or -1 respectively. See
     *   DataSource.compareCriteria for a full explanation of the default behavior.
     * 
     *   Override this method or DataSource.compareCriteria to implement your own client-side
     *   filtering behavior.
     * 
     * 
     *  @param {Criteria} new filter criteria
     *  @param {Criteria} old filter criteria
     *  @param {DSRequest=} dataSource request properties
     *  @param {string=} overrides CriteriaPolicy
     */
    open fun compareCriteria(newCriteria: dynamic, oldCriteria: dynamic, requestProperties: DSRequest?, policy: String?): Number = definedExternally
    /**
     *   Will changing the criteria for this resultSet require fetching new data from the server,
     *   or can the new criteria be satisfied from data already cached on the client?
     *   Second textMatchStyle parameter determines whether a change of text-match style
     *   will require a server fetch - for example if filter is being changed between
     *   an exact match (from e.g: ListGrid.fetchData) and a substring match
     *   (from e.g: ListGrid.filterData).
     *   This method can be used to determine whether ListGrid.fetchData or
     *   ListGrid.filterData would cause a server side fetch when passed a certain set of
     *   criteria.
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
     *  @param {TextMatchStyle=} New text match style. If not passed, assumes    textMatchStyle will not be modified.
     */
    open fun willFetchData(newCriteria: dynamic, textMatchStyle: 
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
     *   Sort this ResultSet by a property of each record.
     * 
     *   Sorting is performed on the client for a ResultSet that has a full cache for the current
     *   filter criteria. Otherwise, sorting is performed by the server, and changing the sort order
     *   will invalidate the cache.
     * 
     *   NOTE: normalizers are not supported by ResultSets in "paged" mode, although valueMaps
     *   in the DataSource are respected by the SQLDataSource.
     * 
     * 
     *  @param {string} name of the property to sort by
     *  @param {boolean} true == sort ascending, false == sort descending
     *  @param {Function | ValueMap=} May be specified as a function, with signature        normalize(item, propertyName, context), where item is        a pointer to the item in the array, propertyName is the        property by which the array is being sorted, and context is the        arbitrary context passed into this method. Normalizer function should return        the value normalized for sorting.        May also be specified as a ValueMap which maps property values to sortable values.
     *  @param {any=} Callers may pass an arbitrary context into the sort method, which             will then be made available to the normalizer function
     */
    override fun sortByProperty(property: String, up: Boolean, normalizer: dynamic?, context: dynamic?): List = definedExternally
    /**
     *   Return the current sort-specification for this ResultSet as an Array of SortSpecifiers.
     * 
     * 
     */
    open fun getSort(): Array<dynamic> = definedExternally
    /**
     *   Sort this ResultSet by the passed list of SortSpecifiers.
     * 
     *   If the ResultSet is already sorted and this method is called with an identical list of
     *   specifiers, this method will no-op. To cause data to be resorted with the same set of
     *   specifiers, use ResultSet.resort.
     * 
     */
    open fun setSort(): Unit = definedExternally
    /**
     *   Forcibly resort this ResultSet by the current list of SortSpecifiers.
     * 
     */
    open fun resort(): Unit = definedExternally
    /**
     *   Derive the current filtered set of data from the cache of all matching rows.
     * 
     *   This method is automatically called by ResultSet.setCriteria when criteria have actually
     *   changed, as well as in various other situations. You could only need to call this method
     *   directly if:
     * 
     * 
     *  - you know that client-side filtering is enabled (ResultSet.useClientFiltering:true) and
     *   active ResultSet.allMatchingRowsCached.
     * 
     *  - you have directly, programmatically modified data within the ResultSet such that it no
     *   longer matches the filter criteria
     * 
     *  - you want your modified records to disappear from the list of visible records (that is,
     *   those accessible via ResultSet.get)
     * 
     * 
     * 
     */
    open fun filterLocalData(): Unit = definedExternally
    /**
     *   The ResultSet will call applyFilter() when it needs to determine whether rows match the
     *   current filter criteria.
     * 
     *   Default behavior is to call DataSource.applyFilter to determine which rows match
     *   that provided criteria.
     * 
     *   Override this method or DataSource.applyFilter to implement your own client-side
     *   filtering behavior.
     * 
     * 
     *  @param {Array<any>} the list of rows
     *  @param {Criteria} the filter criteria
     *  @param {DSRequest=} dataSource request properties
     */
    open fun applyFilter(data: Array<dynamic>, criteria: dynamic, requestProperties: DSRequest?): Array<dynamic> = definedExternally
    /**
     *   Manually invalidate this ResultSet's cache.
     * 
     *   Generally a ResultSet will observe and incorporate updates to the DataSource that provides its
     *   records, but when this is not possible, invalidateCache() allows manual cache
     *   invalidation.
     * 
     *   invalidateCache() fires dataChanged(), which may cause components
     *   using this ResultSet to request new data for display, triggering server fetches.
     * 
     */
    open fun invalidateCache(): Unit = definedExternally
    /**
     *   transformData() provides an opportunity to modify data that has been
     *   returned from the server, before it has been integrated into the client-side cache.
     * 
     *   If data is not immediately suited for client-side use when it is returned from the
     *   ultimate data store, this method allows it to be transformed on the client so that such
     *   transform operations do not impact server scalability.
     * 
     *   It is legal for transformData() to modify not only the records, but also
     *   their number (by modifying startRow and endRow on the DSResponse object).
     * 
     *   See also DataSource.transformResponse for an alternative entry point which
     *   applies to all DSResponses for a DataSource.
     * 
     * 
     *  @param {any} data returned from the server
     *  @param {DSResponse} the DSResponse object returned by the               server
     */
    open fun transformData(newData: dynamic, dsResponse: DSResponse): Array<dynamic> = definedExternally
    /**
     *   Notification fired when data has arrived from the server and has been successfully
     *   integrated into the cache.
     * 
     *   When dataArrived() fires, an immediate call to getRange() with
     *   the startRow and endRow passed as arguments will return a List
     *   with no ResultSet.getLoadingMarker.
     * 
     * 
     *  @param {Integer} starting index of rows that have just loaded
     *  @param {Integer} ending index of rows that have just loaded, non-inclusive
     */
    open fun dataArrived(startRow: Number, endRow: Number): Unit = definedExternally
    /**
     *   Like List.findAll. Checks only loaded rows and will not trigger a fetch.
     * 
     *  @param {string | object | AdvancedCriteria} property to match, or if an Object is passed, set of                    properties and values to match
     *  @param {any=} value to compare against (if propertyName is a string)
     */
    override fun findAll(propertyName: dynamic, value: dynamic?): Array<dynamic> = definedExternally
    /**
     *   Like List.find. Checks only loaded rows and will not trigger a fetch.
     * 
     *  @param {string | object | AdvancedCriteria} property to match, or if an Object is passed, set of                    properties and values to match
     *  @param {any=} value to compare against (if propertyName is a string)
     */
    override fun find(propertyName: dynamic, value: dynamic?): dynamic = definedExternally
    /**
     *   Like List.findIndex. Checks only loaded rows and will not trigger a fetch.
     * 
     *  @param {string | object | AdvancedCriteria} property to match, or if an Object is passed, set of                    properties and values to match
     *  @param {any=} value to compare against (if propertyName is a string)
     */
    override fun findIndex(propertyName: dynamic, value: dynamic?): Number = definedExternally
    /**
     *   Like List.findNextIndex. Checks only loaded rows and will not trigger a fetch.
     * 
     *  @param {Integer} first index to consider.
     *  @param {string | Function | object | AdvancedCriteria} property to match; or, if a function is passed, the predicate function to call; or, if an object is passed, set of properties and values to match.
     *  @param {any=} value to compare against (if propertyName is a string) or the value of this when the predicate function is invoked (if propertyName is a function)
     *  @param {Integer=} last index to consider (inclusive).
     */
    override fun findNextIndex(startIndex: Number, propertyName: dynamic, value: dynamic?, endIndex: Number?): Number = definedExternally
    /**
     *   Like List.getProperty. Checks only loaded rows and will not trigger a fetch.
     * 
     *  @param {string} name of the property to look for
     */
    override fun getProperty(property: String): Array<dynamic> = definedExternally
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
     *   Add an object to this list, at the end
     * 
     * 
     *  @param {any} object to add
     */
    override fun add(`object`: dynamic): dynamic = definedExternally
    /**
     *   Add a list of items to this array.
     * 
     *   Note: you can specify that a subset range be added by passing start and end indices
     * 
     * 
     *  @param {Array<any>} list of items to add
     *  @param {number=} optional start index in list
     *  @param {number=} optional end index in list (non-inclusive)
     */
    override fun addList(list: Array<dynamic>, listStartRow: Number?, listEndRow: Number?): List = definedExternally
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
     *   Remove first instance of the passed object from this array, sliding other items around to
     *   fill gaps.
     * 
     * 
     *  @param {any} item to remove
     */
    override fun remove(obj: dynamic): Boolean = definedExternally
    /**
     *   Remove all instances of objects in the specified list from this list, sliding the remaining
     *   objects around to fill gaps.
     * 
     * 
     *  @param {Array<any>} list of items to remove
     */
    override fun removeList(list: Array<dynamic>): List = definedExternally
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
     *   Method called when this array changes in some way. Observe the method to react to changes in
     *   this list.
     * 
     *   Note: dataChanged() will only fire when items are added, removed or rearranged. If a list
     *   contains objects, dataChanged() will not fire if changes are made to objects within the list
     *   without changing their position within the list. If an observer of dataChanged() needs to react
     *   to such a change, you can manually fire dataChanged() by simply calling it.
     * 
     *   Note: may be called multiple times as the result of a multi-item add or remove, etc.
     * 
     * 
     */
    override fun dataChanged(): Unit = definedExternally
    companion object {
        /**
         *  Creates a new ResultSet
         * 
         *  @param typeCheckedProperties {Partial<ResultSet>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ResultSet} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ResultSet = definedExternally
        /**
         *   Return the singleton marker object that is used as a placeholder for records that are being
         *   loaded from the server.
         * 
         */
        fun getLoadingMarker(): String = definedExternally
    }
}