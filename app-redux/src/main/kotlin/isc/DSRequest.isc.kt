@file:JsQualifier("isc")
package isc

/**
 *  Request sent to the server to initiate a
 *   dataSourceOperations. All properties which are legal on
 *   RPCRequest are legal, in addition to the properties listed here.
 */
open external class DSRequest : RPCRequest {
    /**
     *  Should the HTTP response to this request be formatted using the
     *   strict JSON subset of the javascript language?
     *   If set to true, responses returned by the server should match the format described
     *   here.
     * 
     *   Only applies to requests sent a server with
     *   DataSource.dataFormat set to "json" or "iscServer".
     *  @type {boolean}
     *  @default null
     */
    open var useStrictJSON: Boolean = definedExternally
    /**
     *  Whether formatting settings should be applied to data being exported. Default behavior and
     *   the effect of setting of exportRawValues is described in the
     *   exportFormatting.
     *  @type {boolean}
     *  @default null
     */
    open var exportRawValues: Boolean = definedExternally
    /**
     *  Determines the PropertyIdentifier to be used in the exported data. This
     *   essentially means, should we export internal field names like "countryCode" or
     *   "EMPLOYEE_NO", or localized descriptive field titles like "code du pays" or
     *   "Employee Number". This setting has a lot in common with DSRequest.exportRawValues;
     *   both are largely dependent on whether the exported data is intended for direct consumption by
     *   an end user (in which case it is appropriate to export formatted values and localized field
     *   titles), or for interface to some downstream computer system (in which case you probably
     *   want raw, unformatted values and internal field names).
     * 
     *   If this property is not set, the following defaults apply:
     * 
     *  - If the export format is a native spreadsheet format (XLS or OOXML), localized field
     *   titles are used
     * 
     *  - If the export format is CSV, XML or JSON and this is a client-driven export (ie it was
     *   initiated by a call to ListGrid.exportClientData),
     *   localized field titles are used
     * 
     *  - If the export format is CSV, XML or JSON and this is not a client-driven export,
     *   internal field names are used
     * 
     *  @type {PropertyIdentifier}
     *  @default null
     */
    open var exportPropertyIdentifier: 
                                       /**
                                        *  Identify properties by internal name
                                        *  Identify properties by localized descriptive title
                                        */
                                       String /* name |  title */ = definedExternally
    /**
     *  DataSource this DSRequest will act on.
     * 
     *   This property is generally automatically populated, for example when calling
     *   DataSource.fetchData the dataSource property is set to the target
     *   DataSource.
     *  @type {string}
     *  @default null
     */
    open var dataSource: dynamic = definedExternally
    /**
     *  Type of operation being performed: "fetch", "add", "remove", "update" or "custom".
     * 
     *   This property is generally automatically populated, for example when calling
     *   fetchData() on a DataSource or DataBound component the operationType is
     *   automatically set to "fetch". Note that "custom" operations are never generated
     *   automatically, they are always fired by your code.
     *  @type {DSOperationType}
     *  @default null
     */
    open var operationType: 
                            /**
                             *  Fetch one or more records that match a set of search criteria.
                             *  Store new records
                             *  Update an existing record
                             *  Remove (delete) an existing record
                             *  perform some arbitrary custom logic that is not a CRUD operation.            Format of the inputs and outputs is unconstrained, and the operation
                             *              will be ignored for cache sync purposes by ResultSets. See
                             *              DataSource.performCustomOperation.
                             *  Run server-side validation for "add" or "update" without actually            adding or updating anything. See DataSource.validateData.
                             *  Retrieve a file stored in a binary field in a DataSource record, and            allow the browser to choose whether to view it directly or prompt the
                             *              user to save. See binaryFields.
                             *  Like "viewFile", but the HTTP header Content-Disposition is used to            suggest that the browser show a save dialog. See binaryFields.
                             *  Takes a List of Maps and stores the data in Admin Console XML test            data format
                             *  Upload formatted client data and export it to Excel, XML and other            formats. Used automatically by
                             *              DataSource.exportClientData
                             *              and cannot be used directly. Usable only with the SmartClient server
                             *              framework.
                             *  Use the DataSource as a fileSource.            Used automatically by DataSource.getFile, and
                             *              would not normally be used directly. Usable only with
                             *              the SmartClient server framework.
                             *  Use the DataSource as a fileSource.            Used automatically by DataSource.hasFile, and
                             *              would not normally be used directly. Usable only with
                             *              the SmartClient server framework.
                             *  Use the DataSource as a fileSource.            Used automatically by DataSource.listFiles, and
                             *              would not normally be used directly. Usable only with
                             *              the SmartClient server framework.
                             *  Use the DataSource as a fileSource.            Used automatically by DataSource.removeFile, and
                             *              would not normally be used directly. Usable only with
                             *              the SmartClient server framework.
                             *  Use the DataSource as a fileSource.            Used automatically by DataSource.saveFile, and
                             *              would not normally be used directly. Usable only with
                             *              the SmartClient server framework.
                             *  Use the DataSource as a fileSource.            Used automatically by DataSource.renameFile, and
                             *              would not normally be used directly. Usable only with
                             *              the SmartClient server framework.
                             *  Use the DataSource as a fileSource.            Used automatically by DataSource.getFileVersion, and
                             *              would not normally be used directly. Usable only with
                             *              the SmartClient server framework.
                             *  Use the DataSource as a fileSource.            Used automatically by DataSource.hasFileVersion, and
                             *              would not normally be used directly. Usable only with
                             *              the SmartClient server framework.
                             *  Use the DataSource as a fileSource.            Used automatically by DataSource.listFileVersions, and
                             *              would not normally be used directly. Usable only with
                             *              the SmartClient server framework.
                             *  Use the DataSource as a fileSource.            Used automatically by DataSource.removeFileVersion, and
                             *              would not normally be used directly. Usable only with
                             *              the SmartClient server framework.
                             */
                            String /* fetch |  add |  update |  remove |  custom |  validate |  viewFile |  downloadFile |  storeTestData |  clientExport |  getFile |  hasFile |  listFiles |  removeFile |  saveFile |  renameFile |  getFileVersion |  hasFileVersion |  listFileVersions |  removeFileVersion */ = definedExternally
    /**
     *  Data, such as search criteria or an updated record, to be acted upon. Contents differ by
     *   operationType, see dataSourceOperations for
     *   details.
     * 
     *   This field is generally filled in by passing the "data" argument to methods such as
     *   ListGrid.fetchData.
     *  @type {object | Array<Partial<object>>}
     *  @default null
     */
    override var data: dynamic = definedExternally
    /**
     *  A callback method that will be called with an instance of DSResponse, as sent by the server.
     *   Queuing does not affect callbacks in any way - your specified callback will be invoked for
     *   each DSRequest that contained a callback regardless of whether the request was sent as part
     *   of a queue or not.
     * 
     *   Note that if the request encounters an error (such as 500 server error), by default the
     *   callback will not be fired. Instead, RPCManager.handleError is called to
     *   invoke the default system-wide error handling. Set RPCRequest.willHandleError:true to have your
     *   callback invoked regardless of whether there are errors; however, make sure your callback
     *   properly handles malformed responses when RPCResponse.status is non-zero. See the
     *   errorHandling below for more details.
     *  @type {DSCallback}
     *  @default null
     */
    override var callback: ((dsResponse: RPCResponse, data: dynamic, dsRequest: RPCRequest) -> Unit) = definedExternally
    /**
     *  Starting row of requested results, used only with fetch operations. If unset, 0 is assumed.
     * 
     *   Note that startRow and endRow are zero-based, inclusive at the beginning and exclusive at
     *   the end (like substring), so startRow: 0, endRow: 1 is a request for the first record.
     *  @type {number}
     *  @default null
     */
    open var startRow: Number = definedExternally
    /**
     *  End row of requested results, used only with fetch operations.
     * 
     *   Note that startRow and endRow are zero-based, inclusive at the beginning and exclusive at
     *   the end (like substring), so startRow: 0, endRow: 1 is a request for the first record.
     *  @type {number}
     *  @default null
     */
    open var endRow: Number = definedExternally
    /**
     *  Field name to sortBy, prefixed with optional "-" indicating descending sort. For example, to
     *   sort by the field "userName" in ascending order, set sortBy to just
     *   "userName". For descending sort on "userName", set sortBy to "-userName".
     * 
     *   To sort by multiple fields, an array of field names is also supported. For example, to sort
     *   by the field "department" in ascending order, followed by the field "userName" in descending
     *   order, set sortBy to:
     * 
     *   [ "department", "-userName" ]
     * 
     *   Additionally, this property supports an array of SortSpecifier objects. Setting
     *   sortBy to the following SortSpecifier array results in the same multi-level
     *   sort mentioned above:
     * 
     * 
     *   [
     *   &nbsp;&nbsp;{ property: "department", direction: "ascending" },
     *   &nbsp;&nbsp;{ property: "userName", direction: "descending" }
     *   ]
     * 
     *  @type {FieldName | Array<Partial<FieldName>> | Array<Partial<SortSpecifier>>}
     *  @default null
     */
    open var sortBy: dynamic = definedExternally
    /**
     *  A mapping from field names to SummaryFunction to be applied
     *   to each field.
     * 
     *   Valid only for an operation of type "fetch". See the
     *   serverSummaries for examples of usage.
     *  @type {Map<SummaryFunction>}
     *  @default null
     */
    open var summaryFunctions: Map<
                                   /**
                                    *  Client: iterates through the set of records, picking up and summing all numeric values for the specified field. Returns null to indicate invalid summary value if
                                    *   any non numeric field values are encountered.
                                    *   Server: acts exactly like SQL SUM function.
                                    *  Client: iterates through the set of records, picking up all numeric values for the specified field and determining the mean value. Returns null to indicate invalid
                                    *   summary value if any non numeric field values are encountered.
                                    *   Server: acts exactly like SQL AVG function.
                                    *  Client: iterates through the set of records, picking up all values for the specified field and finding the maximum value. Handles numeric fields and
                                    *   date type fields only. Returns null to indicate invalid
                                    *   summary value if any non numeric/date field values are encountered.
                                    *   Server: acts exactly like SQL MAX function.
                                    *  Client: iterates through the set of records, picking up all values for the specified field and finding the minimum value. Handles numeric fields and
                                    *   date type fields only. Returns null to indicate invalid summary value if
                                    *   any non numeric field values are encountered.
                                    *   Server: acts exactly like SQL MIN function.
                                    *  Client: iterates through the set of records, picking up all numeric values for the specified field and multiplying them together.
                                    *   Returns null to indicate invalid summary value if
                                    *   any non numeric field values are encountered.
                                    *   Server: not supported.
                                    *  Client: returns a numeric count of the total number of records passed in. Server: acts exactly like SQL COUNT function.
                                    *  Client: returns field.summaryValueTitle if specified, otherwise field.title
                                    *   Server: not supported.
                                    *  Client: Currently the same as the min function. Server: implemented as SQL MIN function.
                                    *  Client: iterates through the set of records, producing a string with each value concatenated to the end.
                                    *   Server: implemented as SQL CONCAT function. Supported only by SQLDataSource. Note that it
                                    *   is natively supported only by Oracle DB driver, other drivers perform additional query to fetch
                                    *   values for concatenation. See also DataSourceField.joinPrefix,
                                    *   DataSourceField.joinString and DataSourceField.joinSuffix
                                    *   related datasource field attributes.
                                    */
                                   String /* sum |  avg |  max |  min |  multiplier |  count |  title |  first |  concat */> = definedExternally
    /**
     *  When using RPCManager.exportContent to produce a .pdf from a SmartClient UI, this property allows
     *   dynamic CSS to be passed to the server. Since the exportContent() system already provides
     *   a way to specify a custom skin or additional stylesheet for export, exportCSS should only be
     *   used for small bits of CSS that are necessarily dynamic.
     * 
     *   For example, when printing a very wide page, such as a grid with many columns or a very wide chart,
     *   you could send the string "@page {size: A4 landscape; }" as exportCSS to cause the
     *   generated PDF to use landscape mode, so that all content fits without clipping.
     *  @type {string}
     *  @default null
     */
    open var exportCSS: String = definedExternally
    /**
     *  List of fields to group by when using serverSummaries.
     * 
     *   Valid only for an operation of type "fetch". See the
     *   serverSummaries for details and examples of usage.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var groupBy: Array<dynamic> = definedExternally
    /**
     *  The list of fields to return in the response, specified as a comma-separated string (eg,
     *   "foo, bar, baz"). You can use this property to indicate to the server that
     *   you are only interested in a subset of the fields that would normally be returned.
     * 
     *   Note that you cannot use this property to request a superset of the fields that
     *   would normally be returned, because that would be a security hole. It is possible to
     *   configure individual OperationBindings to return extra fields, but this must
     *   be done in the server's DataSource descriptor; it cannot be altered on the fly
     *   from the client side.
     *  @type {string}
     *  @default null
     */
    open var outputs: String = definedExternally
    /**
     *  For fetch, add or update operation, an optional comma separated list of fields to fetch from another,
     *   related DataSource.
     * 
     *   Fields should be specified in the format
     *   "localFieldName!relatedDataSourceID.relatedDataSourceFieldName".
     *   where relatedDataSourceID is the ID of the related dataSource, and
     *   relatedDataSourceFieldName is the field for which you want to
     *   fetch related values. The returned field values will be stored on
     *   the data returned to the client under the specified localFieldName.
     *   Note that this will be applied in addition to any specified DSRequest.outputs.
     * 
     *   Note that as with DataSourceField.includeFrom, the related dataSource must be
     *   linked to the primary datasource via a foreignKey relationship.
     * 
     *   Note additionalOutputs sent in request from the browser can be completely disabled in
     *   server_properties by setting
     *   datasource.allowClientAdditionalOutputs:
     * 
     *     datasource.allowClientAdditionalOutputs: false
     * 
     *   In this case DSRequest.additionalOutputs sent from the browser will be cleared before
     *   executing request. Note that programatically configured additionalOutputs are always allowed, but
     *   you can't modify them from within a DMI method, so the only way to execute a request
     *   with additionalOutputs that differ from what was sent by the client is to create a new DSRequest
     *  @type {string}
     *  @default null
     */
    open var additionalOutputs: String = definedExternally
    /**
     *  Specifies should related updates have to be generated.
     *   If not set (or set to null) then related updates will be generated only for
     *   "add" and "update" operations. This property has to be explicitly set to true
     *   to generate related updates for "remove" operation.
     *   This functionality loads related objects from database thus affecting operation performance.
     *   For "add" and "update" operations related objects are loaded anyway and performance impact is minimal.
     *   Simple "remove" operation does not need to load related objects. Depending on database structure
     *   performance impact can be significant if this property is set to true.
     * 
     *   Note this feature works only with Hibernate/JPA data sources, see
     *   jpaHibernateRelations for instructions how to
     *   set up relations. Table below uses "country -&gt; cities" sample data model.
     * 
     * 
     * 
     *     Relation and Operation type
     *     Loading complete related objects
     *     Loading related IDs
     * 
     * 
     *     Many-to-one (cities -&gt; country): ADD/UPDATE
     *     If operation affected country, for example new city added with existing
     *   countryId, then relatedUpdate is generated. Otherwise if city is added or updated without
     *   countryId set, relatedUpdate is not generated.
     *   Note that if provided countryId does not exist, it is created.
     *     Same as with complete related objects, except if provided countryId does not exist,
     *   then it is not created, but reset to NULL.
     * 
     * 
     *     Many-to-one (cities -&gt; country): REMOVE
     *     Removes record, depending on setting generates or not relatedUpdate for parent record.
     *   For example if city record is removed and countryId is sent to the server in remove request, then
     *   country record will be generated in relatedUpdates.
     * 
     * 
     *     One-to-many (country -&gt; cities): ADD/UPDATE
     *     If add or update operation provides value sets for cities as well as for country, then
     *   cities are created/updated if necessary and relatedUpdates are generated.
     *   Note that all fields in cities value sets can be sent to server.
     *     Same as with complete related objects, except you can only sent primary key values for cities.
     * 
     *     One-to-many (country -&gt; cities): REMOVE
     *     Removes country, depending on setting returns or not relatedUpdates for the cities of removed country,
     *   which can be either REMOVE operations of all cities if cascade enabled, or UPDATE operations setting countryId=null to
     *   all cities if cascade is disabled
     * 
     * 
     * 
     *   Note that Many-to-Many works the same way as One-to-Many.
     *  @type {boolean}
     *  @default null
     */
    open var generateRelatedUpdates: Boolean = definedExternally
    /**
     *  For "fetch" operations, how search criteria should be interpreted for text fields: one of
     *   "exact" for exact match, "exactCase" for case-sensitive exact match, "startsWith" for
     *   matching at the beginning only, or "substring" for substring match. All
     *   textMatchStyle settings except "exactCase" are case-insensitive; use
     *   AdvancedCriteria for greater control over matching.
     * 
     *   This property defaults to the value of DataSource.defaultTextMatchStyle if it is not
     *   explicitly provided on the DSRequest. Note, however, that DSRequests issued
     *   by ListGrids and other DataBoundComponent will generally have a
     *   setting for textMatchStyle on the component itself
     *   (see ListGrid.autoFetchTextMatchStyle, for example).
     * 
     *   This setting is respected by the built-in server-side connectors for SQL, JPA and Hibernate.
     *   A custom server-side DataSource implementation should generally respect this flag as well,
     *   or server-side filtering will not match client-side filtering, which will require
     *   ResultSet.useClientFiltering, a huge performance
     *   loss.
     *  @type {TextMatchStyle}
     *  @default null
     */
    open var textMatchStyle: 
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
     *  For an update or remove operation, the original values from the
     *   record that is being updated or removed. oldValues is automatically added to
     *   DSRequests submitted by DataBound Components. Available on the server via
     *   DSRequest.getOldValues().
     * 
     *   The server can compare the oldValues to the most recent stored values in order
     *   to detect that the user was looking at stale values when the user submitted changes (NOTE:
     *   this means of detecting concurrent edit is sometimes called "optimistic concurrency" or
     *   "long transactions").
     * 
     *   In applications where a policy of "last update wins" is not appropriate when updating
     *   certain fields, special UI can be shown for this case. For example, on detecting concurrent
     *   edit, the server may send back a special dsResponse.status code that the client
     *   application detects, offering the user a choice of proceeding with the operation,
     *   discarding edits, or reconciling new and old values in a special interface.
     *  @type {Record}
     *  @default null
     */
    open var oldValues: Record = definedExternally
    /**
     *  For requests submitted by a DataBoundComponent, the Canvas.ID of the
     *   submitting component.
     * 
     *   This ID will be present for operations including automatic saves by a ListGrid
     *   editing, or calls to
     *   DynamicForm.saveData. It will not be present for a direct
     *   call to a DataSource method such as DataSource.fetchData.
     * 
     *   Note this is the component's String ID - you can retrieve the component itself
     *   via Canvas.getById.
     * 
     *   This property should be used for debugging purposes only - do not use it to trigger
     *   differences in server-side behavior, instead, use DSRequest.operationId because only
     *   operationId is considered when assessing
     *   dsRequestEquivalence.
     *  @type {string}
     *  @default null
     */
    open var componentId: String = definedExternally
    /**
     *  When a DataBoundComponent sends a DSRequest, the
     *   dsRequest.operationId will be automatically picked up from the
     *   fetchOperation, addOperation, etc properties of the
     *   DataBoundComponent.
     * 
     *   The operationId serves as an identifier that you can use to create
     *   variations on the 4 basic DataSource operations that are used by different components in
     *   different parts of your application. For example, you may be using a standard
     *   fetch operation in one part of your application, however on another screen you
     *   want to perform a fetch operation on the same DataSource but interpret search
     *   criteria differently (eg full text search).
     * 
     *   If you declare more than one OperationBinding for the same
     *   OperationBinding.operationType, you can specify an operationId
     *   OperationBinding.operationId which will cause that
     *   operationBinding to be used for dsRequests containing a matching operationId.
     *   This allows all the possible settings of an operationBinding, including
     *   OperationBinding.wsOperation or dmiOverview settings, to be switched on a
     *   per-component or per-request basis.
     * 
     *   For example, by setting the fetchOperation on a particular ListGrid, you could
     *   cause it to invoke a different server method via DMI, different
     *   OperationBinding.dataURL or different
     *   OperationBinding.wsOperation.
     * 
     *   The operationId can also be directly received by the server in order to affect
     *   behavior. When using the SmartClient Server, operationId can be accessed via
     *   dsRequest.getOperationId(). The RestDataSource will also send the
     *   operationId to the server as part of the
     *   RestDataSource.metaDataPrefix.
     * 
     *   Note that if you DataSource.fetchData a DataSource operation, you can
     *   also specify operationId via the requestProperties parameter.
     * 
     *   Note that the operationId has special significance in terms of whether two
     *   DSRequests are considered equivalent for caching and synchronization purposes - see
     *   dsRequestEquivalence.
     *  @type {string}
     *  @default null
     */
    open var operationId: String = definedExternally
    /**
     *  DataSource.dataProtocol for this particular request.
     * 
     *   Note: Typically developers should use DataSource.operationBindings
     *   to specify an explicit data protocol for a request.
     * 
     *   One exception: advanced developers may wish to have a custom
     *   DataSource.transformRequest with entirely client-side
     *   handling for some requests. This may be achieved by setting the request's
     *   dataProtocol to DSProtocol within transformRequest,
     *   and also triggering application code which will fire DataSource.processResponse
     *   when complete.
     * 
     *   The DataSource.getDataProtocol method may be used to determine what data protocol
     *   will be used to handle a specific request based on this property (if set), otherwise the
     *   settings at the OperationBinding.dataProtocol or
     *   DataSource.dataProtocol levels.
     *  @type {DSProtocol}
     *  @default null
     */
    open var dataProtocol: 
                           /**
                            *  Data is added to the dataURL, with each property in the data becoming an HTTP parameter,
                            *    eg http://service.com/search?keyword=foo
                            *  Data is POST'd to the dataURL, with each property becoming an HTTP parameter,
                            *    exactly as an HTML form would submit them if it had one input field per property in the
                            *    data.
                            *  Data is serialized as XML via DataSource.xmlSerialize and POST'd as the
                            *    HTTP request body with contentType "text/xml".
                            *  Data is serialized as XML via DataSource.xmlSerialize, wrapped in a SOAP
                            *    envelope, and POST'd as the HTTP request body with contentType "text/xml". Generally
                            *    only used in connection with a wsdlBinding.
                            *  dsRequest.data is assumed to be a String set up by DataSource.transformRequest
                            *    and is POST'd as the HTTP request body.
                            *  This setting entirely bypasses the SmartClient comm system. Instead of the DataSource sending
                            *    an HTTP request to a URL, the developer is expected to implement
                            *    DataSource.transformRequest to perform their own custom logic, and then call
                            *    DataSource.processResponse to handle the results of this action.
                            *    This dataProtocol setting can be used to implement access to in-browser
                            *    resources such as HTML5 "localStorage", native APIs available to applications
                            *    mobileDevelopment, or to implement the
                            *    dsFacade.
                            */
                           String /* getParams |  postParams |  postXML |  soap |  postMessage |  clientCustom */ = definedExternally
    /**
     *  Automatically generated unique ID for this request. This ID will be required by developers
     *   making use of the DSProtocol.
     *  @type {string}
     *  @default "varies"
     */
    open var requestId: String = definedExternally
    /**
     *  An object to be held onto for the duration of the DSRequest turnaround to track
     *   application-specific context.
     * 
     *   When a DataSource request completes, the clientContext is available in the
     *   DSCallback as dsResponse.clientContext. The
     *   clientContext is never sent to the server.
     * 
     *   The clientContext is useful for holding onto state that will be used when the
     *   DSCallback fires, such as the name of a component that will receive the
     *   returned data.
     *  @type {object}
     *  @default "{}"
     */
    override var clientContext: dynamic = definedExternally
    /**
     *  For advanced use in integrating trees that
     *   TreeGrid.loadDataOnDemand with web services,
     *   parentNode is automatically set in "fetch" DSRequests issued by a
     *   databound TreeGrid that is loading children for that parentNode.
     * 
     *   This is sometimes needed if a web service requires that additional properties beyond the
     *   ID of the parentNode must be passed in order to accomplished level-by-level loading.
     *   A custom implementation of DataSource.transformRequest can access
     *   dsRequest.parentNode and add any such properties to DSRequest.data.
     * 
     *   parentNode will also be automatically set by a TreeGrid performing databound
     *   reparenting of nodes, as implemented by method:TreeGrid.folderDrop.
     * 
     *   This property can only be read. There is no meaning to setting this property
     *   yourself.
     *  @type {TreeNode}
     *  @default null
     */
    open var parentNode: TreeNode = definedExternally
    /**
     *  For advanced use in integrating trees that
     *   ResultTree.loadDataOnDemand with web services,
     *   the ResultTree that issued this "fetch" DSRequest is automatically made available as the
     *   resultTree property.
     * 
     *   This property can only be read. There is no meaning to setting this property
     *   yourself.
     *  @type {ResultTree}
     *  @default null
     */
    open var resultTree: ResultTree = definedExternally
    /**
     *  This property is for advanced use in integrating trees that
     *   TreeGrid.loadDataOnDemand using data paging.
     *   When this flag is set, a server fetch operation is expected to return all of the tree nodes
     *   that either match the provided criteria or have one or more children that match the
     *   criteria.
     * 
     *   A ResultTree with ResultTree.fetchMode and with
     *   ResultTree.keepParentsOnFilter enabled will automatically set
     *   this property to true on all DSRequests that it sends to the server.
     * 
     *   Currently, no built-in server-side connectors (SQL, JPA, Hibernate) implement support for
     *   the keepParentsOnFilter flag.
     *  @type {boolean}
     *  @default null
     */
    open var keepParentsOnFilter: Boolean = definedExternally
    /**
     *  For advanced use in integrating dataset paging with web services,
     *   the ResultSet that issued this "fetch" DSRequest is automatically made available as the
     *   resultSet property.
     * 
     *   This property can only be read. There is no meaning to setting this property
     *   yourself.
     *  @type {ResultSet}
     *  @default null
     */
    open var resultSet: ResultSet = definedExternally
    /**
     *  This is a per-request flag for explicitly controlling whether the cache is used (bypassing
     *   it when not wanted, or using it when settings would indicate otherwise). See
     *   DataSource.cacheAllData, DataSource.cacheAllOperationId and
     *   DataSource.cacheAcrossOperationIds for caching management for all requests of a
     *   dataSource.
     *  @type {boolean}
     *  @default null
     */
    open var shouldUseCache: Boolean = definedExternally
    /**
     *  When useFlatFields is set for a request to be sent to a WSDL web service, when
     *   creating the input XML message to send to the web service, properties in
     *   DSRequest.data will be used as the values for XML elements of the same name, at
     *   any level of nesting.
     * 
     *   useFlatFields allows you to ignore gratuitous XML message structure, such as
     *   extra levels of nested elements, and provides some insulation against changes in the
     *   required structure of the input message.
     * 
     *   For example, given this input message:
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
     *   If useFlatFields were not set, in order to fill out this message
     *   correctly, request.data would need to be:
     *   {
     *    searchFor: "search text",
     *    Options : {
     *      caseSensitive: false,
     *    },
     *    IncludeInSearch : {
     *      serviceName: true,
     *      documentation : true,
     *      keywords : true
     *    }
     *   }
     *   However if useFlatFields were set, request.data could be just:
     *   {
     *    searchFor: "search text",
     *    caseSensitive: false,
     *    serviceName: true,
     *    documentation : true,
     *    keywords : true
     *   }
     *   useFlatFields is often set when the input data comes from a DynamicForm
     *   to avoid the cumbersome and fragile process of mapping input fields to an XML structure.
     * 
     *   OperationBinding.useFlatFields can also be set to cause all dsRequests of a
     *   particular type to useFlatFields automatically.
     * 
     *   For DataBoundComponent,
     *   DataBoundComponent.useFlatFields can be set use "flattened"
     *   binding to fields of a WSDL message or XML Schema.
     * 
     *   Note that useFlatFields is not generally recommended for use with XML input
     *   messages where multiple simple type fields exist with the same name, however if used in this
     *   way, the first field to use a given name wins. "first" means the first field encountered in a
     *   depth first search. "wins" means only the first field will be populated in the generated
     *   XML message.
     *  @type {boolean}
     *  @default null
     */
    open var useFlatFields: Boolean = definedExternally
    /**
     *  Cause the DSRequest.useFlatFields XML serialization behavior to be used
     *   for all soap headers in the request. See also DSRequest.headerData.
     *  @type {boolean}
     *  @default null
     */
    open var useFlatHeaderFields: Boolean = definedExternally
    /**
     *  For DataSources using SOAP messaging with a WSDL web service, data to be serialized to form
     *   SOAP headers, as a map from the header part name to the data. See
     *   WSRequest.headerData for more information.
     * 
     *   SOAP headers typically contain request metadata such as a session id for authentication, and
     *   so dsRequest.headerData is typically populated by
     *   DataSource.transformRequest, or, for data that applies to every request sent to the
     *   server, by WebService.getHeaderData.
     * 
     *   Note that this only applies to SOAP headers. General HTTP headers for requests may be
     *   modified using RPCRequest.httpHeaders.
     *  @type {object}
     *  @default null
     */
    open var headerData: dynamic = definedExternally
    /**
     *  When set, causes the results of the DSRequest to be exported to a file, whose name
     *   and format are indicated by DSRequest.exportFilename and
     *   DSRequest.exportAs respectively. When no exportFilename is provided, the default is
     *   Results.csv and the default value of exportAs is csv.
     * 
     *   The export field-list can also be configured, see DSRequest.exportFields. Formats
     *   for exported date and numeric are controlled by several settings - see
     *   exportFormatting for an overview.
     * 
     *   Once the operation completes, DSRequest.exportDisplay specifies whether the exported
     *   data should be downloaded to the file-system or displayed in a new window. The default value
     *   of exportDisplay is "download" which displays the Save As dialog. See ExportDisplay
     *   for more information.
     * 
     *   You can configure the style of LineBreakStyle to use when
     *   generating the output, the DSRequest.exportDelimiter to use when exporting
     *   to CSV and the DSRequest.exportTitleSeparatorChar to use in
     *   field-titles when exporting to XML.
     * 
     *   Additionally, you can output arbitrary text before and after the exported data by setting
     *   DSRequest.exportHeader and DSRequest.exportFooter.
     * 
     *   Note that for security reasons, an export initiated using dsRequest properties does not
     *   provide support for JSON format (see
     *   this post for more detail).
     *   However, you can use operationBinding.exportAs:"json" in a server-side .ds.xml file to force
     *   JSON export to be allowed.
     * 
     *   As well as setting dsRequest.exportResults and related properties, exports can be initiated
     *   in two other ways, via OperationBindings and via custom server code which sets
     *   export-related properties on the DSResponse. Both of those methods support exporting
     *   to JSON format.
     * 
     *   Format Examples
     *   XML format
     * 
     *     &lt;List&gt;
     *       &lt;Object&gt;
     *         &lt;id&gt;10101&lt;/id&gt;
     *         &lt;displayName&gt;Record 10101&lt;/displayName&gt;
     *       &lt;/Object&gt;
     *    &lt;/List&gt;
     * 
     *   JSON Format
     * 
     *     [
     *       { id: 10101, displayName: "Record 10101" }
     *     ]
     * 
     *   CSV Format
     * 
     *     id,displayName
     *     10101,"Record 10101"
     * 
     *  @type {boolean}
     *  @default false
     */
    open var exportResults: Boolean = definedExternally
    /**
     *  The format in which the data should be exported. See ExportFormat for more
     *   information.
     *  @type {ExportFormat}
     *  @default "csv"
     */
    open var exportAs: 
                       /**
                        *  Export data as XML records
                        *  Export data as JSON objects
                        *  Export data in comma-separated format
                        *  Export data in native Microsoft Excel 97 format
                        *  Export data in native Microsoft Excel 2007 format (also called XLSX)
                        */
                       String /* xml |  json |  csv |  xls |  ooxml */ = definedExternally
    /**
     *  The name of the file to save the exported data into. If
     *   DSRequest.exportToFilesystem is set, this is the name of the
     *   file the server creates on its filesystem. If DSRequest.exportToClient
     *   is set, this is the filename that will appear to the browser.
     * 
     *   If the exportFilename that you specify does not include an extension, one will be added to
     *   it based on the ExportFormat specified by DSRequest.exportAs.
     *  @type {string}
     *  @default null
     */
    open var exportFilename: String = definedExternally
    /**
     *  The image format in which the SVG graphic should be exported.
     *  @type {ExportImageFormat}
     *  @default "png"
     */
    open var exportImageFormat: 
                                /**
                                 *  Export as PNG
                                 *  Export as JPEG
                                 */
                                String /* png |  jpeg */ = definedExternally
    /**
     *  If exporting in ExportImageFormat, the output JPEG quality level.
     *   This is a number from 0 to 1, with 1 representing the best quality and 0 representing the
     *   least quality but smallest file size.
     *  @type {Float}
     *  @default null
     */
    open var exportImageQuality: Number = definedExternally
    /**
     *  If DSRequest.exportToFilesystem is set, optionally specifies a
     *   path to use when saving the file. This path is relative to the default export path, which
     *   is set using the server_properties setting export.location; this
     *   is the project webRoot by default. For example, with the default setting of
     *   export.location, an exportPath of "shared/ds" and
     *   an DSRequest.exportFilename of "exportedData.csv",
     *   SmartClient Server would export to file $webRoot/shared/ds/exportedData.csv.
     * 
     *   If you do not specify this property, SmartClient Server will export to the file indicated
     *   by exportFilename directly in the default export location.
     * 
     *   This property is only applicable when DSRequest.exportToFilesystem
     *   is set.
     *  @type {string}
     *  @default null
     */
    open var exportPath: String = definedExternally
    /**
     *  If set, SmartClient Server will export data to a file on the server filesystem. The
     *   file we export to is determined by the DSRequest.exportFilename and
     *   DSRequest.exportPath. Note that filesystem exports are disabled by
     *   default, for security reasons. To enable them, set export.allow.filesystem to
     *   true in your server.properties file. If you enable filesystem exports, you
     *   should also consider setting a default export path, as described in the
     *   DSRequest.exportPath documentation.
     * 
     *   Note that it is perfectly valid to specify both this property and
     *   DSRequest.exportToClient; in this case the data is both exported to a
     *   file on the server filesystem and downloaded to the client. If you specify
     *   neither property, the export no-ops.
     * 
     *   It is possible to redirect the filesystem export to make use of an OutputStream
     *   you provide. You use this when you want to make some use of the export document other than
     *   writing it to a disk file - for example, attaching it to an email or writing it to a
     *   database table. See the server-side Javadocs for DSRequest.setExportTo().
     *  @type {boolean}
     *  @default false
     */
    open var exportToFilesystem: Boolean = definedExternally
    /**
     *  If set, SmartClient Server will export data back to the client, either as a file download
     *   or as content in a new browser window, depending on the setting of
     *   DSRequest.exportDisplay.
     * 
     *   Note that it is perfectly valid to specify both this property and
     *   DSRequest.exportToFilesystem; in this case the data is both
     *   exported to a file on the server filesystem, and downloaded to the client. If you specify
     *   neither property, the export no-ops.
     *  @type {boolean}
     *  @default true
     */
    open var exportToClient: Boolean = definedExternally
    /**
     *  The character with which to replace spaces in field-titles when exporting to XML. If not
     *   specified in the request, the server uses "".
     *  @type {string}
     *  @default null
     */
    open var exportTitleSeparatorChar: String = definedExternally
    /**
     *  Specifies whether the exported data will be downloaded as an attachment or displayed in a
     *   new browser window. See ExportDisplay for more information.
     *  @type {ExportDisplay}
     *  @default "download"
     */
    open var exportDisplay: 
                            /**
                             *  Show the Save As dialog and download the file
                             *  Show the data in a new browser window
                             *  Return the data for further programmatic processing in the browser
                             */
                            String /* download |  window |  return */ = definedExternally
    /**
     *  The style of line-breaks to use in the exported output. See LineBreakStyle for
     *   more information.
     *  @type {string}
     *  @default null
     */
    open var lineBreakStyle: String = definedExternally
    /**
     *  The character to use as a field-separator in CSV exports. The default delimiter is comma.
     *  @type {string}
     *  @default ","
     */
    open var exportDelimiter: String = definedExternally
    /**
     *  When you erxport a ListGrid that has ListGrid.headerSpans,
     *   should headerSpans also be exported. See DSRequest.exportSpanTitleSeparator for details of
     *   of what it means to export headerSpans to different export targets.
     *  @type {boolean}
     *  @default true
     */
    open var exportShowHeaderSpanTitles: Boolean = definedExternally
    /**
     *  When you export a ListGrid that has ListGrid.headerSpans
     *   defined and DSRequest.exportShowHeaderSpanTitles is true, the behavior is dependent
     *   on the export type. Direct exports to Excel formats (both XLS and OOXML) place the
     *   headerSpans in merged cells in the spreadsheet, giving the same visual effect as the
     *   original ListGrid. This is not possible with exports to CSV format; instead, we alter the
     *   exported headers so that they contain the titles of the ancestor headerSpan(s).
     * 
     *   For example, if you had a field titled "Population" inside a headerSpan titled "National",
     *   nested inside another headerSpan titled "Demographics", that would result in the exported
     *   field being titled "Demographics - National - Population".
     * 
     *   The exportSpanTitleSeparator property allows you to override the separator
     *   string used when constructing these amalgamated headers.
     *  @type {string}
     *  @default " - "
     */
    open var exportSpanTitleSeparator: String = definedExternally
    /**
     *  The list of field names to export. If provided, the field list in the exported output is
     *   limited and sorted as per the list.
     * 
     *   If exportFields is not provided:
     * 
     *  - If we are exporting via DSRequest.exportData, the field list in the exported
     *   output is every non-hidden field defined in the DataSource, in DataSource definition order
     * 
     *  - If we are exporting via ListGrid.exportClientData and we are not
     *   exporting to OOXML, or we are exporting to OOXML but we are not
     *   DSRequest.exportStreaming, the field list in the exported output is based on the
     *   client data sent up, taking every row into account (so if there is a value for field "foo"
     *   only in row 57, we will output a column "foo", the cells of which are empty except for
     *   row 57)
     * 
     *  - If we are exporting via ListGrid.exportClientData and we are
     *   exporting to OOXML and streaming is in force (the default for OOXML), the field list in
     *   the exported output is based on the client data sent up, taking just the first row into
     *   account (so if there is a value for field "foo" only in row 57, we will not output a column
     *   "foo" at all)
     * 
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var exportFields: Array<dynamic> = definedExternally
    /**
     *  Optional text to appear at the beginning of the file.
     *  @type {string}
     *  @default null
     */
    open var exportHeader: String = definedExternally
    /**
     *  This property allows omitting column names from CSV and Excel exports (no effect on JSON or XML exports).
     *  @type {boolean}
     *  @default false
     */
    open var exportHeaderless: Boolean = definedExternally
    /**
     *  Optional text to appear at the end of the file.
     *  @type {string}
     *  @default null
     */
    open var exportFooter: String = definedExternally
    /**
     *  Only applies to request properties passed to ListGrid.exportClientData.
     *   If specified this property contains an arbitrary set of data to be exported.
     *  @type {Array<Partial<Record>>}
     *  @default null
     */
    open var exportData: Array<dynamic> = definedExternally
    /**
     *  This flag has a different meaning depending on whether you are doing a client-driven or
     *   server-driven export.
     * 
     *   For ListGrid.exportClientData calls (client-driven), ordinarily
     *   any fields that have a ListGridField.displayField defined
     *   have the value of that displayField exported, rather than the underlying value in the
     *   ListGridField.valueField. If you set the exportValueFields
     *   property, we export both the underlying value and the displayField value.
     * 
     *   Again for exportClientData() calls, any fields that have a
     *   ListGridField.valueMap defined ordinarily have the mapped value of the
     *   field exported, rather than the underlying data value. If you set the
     *   exportValueFields property, we instead export the underlying data value.
     *   Note, there is only one field in this scenario, not a valueField and a
     *   separate displayField, so we export either the underlying data value or
     *   the mapped value, not both as in the displayField/valueField case
     *   described above.
     * 
     *   For DataBoundComponent.exportData calls (server-driven), we ordinarily
     *   export the underlying data value of all fields. However, if you set the
     *   exportValueFields property explicitly to false, any fields that
     *   have a DataSource-defined DataSourceField.valueMap will have the mapped
     *   value exported instead. This is similar to the client-side treatment of valueMaps, except
     *   that the defaults are reversed.
     *  @type {boolean}
     *  @default null
     */
    open var exportValueFields: Boolean = definedExternally
    /**
     *  When exporting via ListGrid.exportClientData to an XLS or
     *   OOXML spreadsheet, forces dates to export as a string rather than a true date
     *   value.
     * 
     *   If a date value is provided to a spreadsheet as a string, Excel or other spreadsheet
     *   applications may not recognize them as being date values that are valid for use in
     *   date-specific functions in formulas, filters, etc.
     * 
     *   For this reason, the default behavior of exportClientData is to provide date
     *   values to the spreadsheet as true date values. If
     *   FormatString are provided via properties like
     *   DataSourceField.format these will be translated to Excel /
     *   OpenOffice format strings and used when generating spreadsheets. Other formatting logic,
     *   such as ListGridField.formatCellValue, will not be used since they
     *   cannot be automatically translated to an Excel format string. If no translatable format
     *   string is available, date values will be provided to the spreadsheet with no formatter and
     *   the spreadsheet program's default formatting for date values will be used.
     * 
     *   If exportDatesAsFormattedString is set to true, date fields will appear as
     *   strings that exactly match the formatting shown in the DataBoundComponent.
     *   As noted above, this means the spreadsheet program will not recognize the value as
     *   a date.
     *  @type {boolean}
     *  @default null
     */
    open var exportDatesAsFormattedString: Boolean = definedExternally
    /**
     *  For server-side export with ExportFormat "xls" or "ooxml" only, timezone to use
     *   when saving values from FieldType "datetime" to the spreadsheet.
     * 
     *   This setting exists because MS Excel&trade; has no concept of providing a true datetime value
     *   that is timezone-independent and will display in the local timezone where the Excel program is
     *   launched. Instead, datetime values must be provided as a rendered string, which implies
     *   rendering in a particular timezone when the spreadsheet is generated.
     * 
     *   exportTZ can either be specified as a timezone offset in the same format
     *   expected by Time.setDefaultDisplayTimezone (for example, "+01:00" for one hour after
     *   GMT) or as the special constants "client" (meaning the current client display timezone) or
     *   "server" (meaning the timezone of the server).
     * 
     *   Default if unspecified is "server".
     * 
     *   This setting does not affect fields of type "date" or "time", which are timezone-independent
     *   values. See dateFormatAndStorage for more information on how SmartClient
     *   handles date, time and datetime values.
     * 
     *   All non-spreadsheet export formats always use UTC. This setting also does not affect
     *   client-driven exports (DataSource.exportClientData), which always use client-side
     *   time.
     *  @type {string}
     *  @default null
     */
    open var exportTZ: String = definedExternally
    /**
     *  When exporting to OOXML format (this is the standard file format used by Excel 2007 and
     *   later), we default to using streaming mode, for memory efficiency. You can override this
     *   for individual exports by setting this flag false. You may wish to do this if you need to
     *   grab the spreadsheet object in a DMI and do something with it. The underlying object in
     *   use - POI's SXSSFWorkbook - is intended for write only and cannot usefully be
     *   read.
     * 
     *   You can switch off Excel streaming altogether by setting "excel.useStreaming" false in
     *   server.properties.
     * 
     *   Note, OOXML is the only native Excel format that supports streaming: when exporting to
     *   the older XLS format, we build the spreadsheet in its entirety in server-side memory
     *   before writing it to disk or returning it to the client. This is unlikely to change:
     *   streaming the XLS format is impractical bcause it is a self-referential binary format, and
     *   in any case the problem of huge exports overflowing JVM memory is less likely to arise with
     *   XLS, because it is innately limited to 65535 rows.
     *  @type {boolean}
     *  @default true
     */
    open var exportStreaming: Boolean = definedExternally
    /**
     *  Mode of validation for entered data.
     *  @type {ValidationMode}
     *  @default "full"
     */
    open var validationMode: 
                             /**
                              *  Assume provided data is complete and run all validation rules
                              *  Validate only the data values that are present ignoring the         absence of required fields, validators that refer to fields
                              *           that are not present, and any conditional validators dependent
                              *           on fields that are not present.
                              */
                             String /* full |  partial */ = definedExternally
    /**
     *  Indicates that a validation request is being made for a record that will ultimately be
     *   saved with an "add" request, as opposed to an "update" request. This context is necessary
     *   for some validators because the nature of the validation depends on whether we are adding
     *   or updating a record. The system sets this flag when processing interim validations, such
     *   as those fired when DynamicForm.validateOnChange is in force.
     *  @type {boolean}
     *  @default null
     */
    open var pendingAdd: Boolean = definedExternally
    /**
     *  If true, results will be streamed on the server, rather than all records being read into
     *   server memory at once; this approach is appropriate for retrieving or exporting large
     *   datasets without swamping the server.
     * 
     *   Although this property can be set without any particular concerns (small datasets can be
     *   streamed just as readily as large ones), bear in mind that although streaming enables the
     *   processing of very large datasets, processing and downloading very large datasets in a
     *   normal client/server flow will very rarely give an acceptable user experience. Streaming
     *   is of more practical use in a batch setting - for example, a disconnected
     *   DSRequest.exportToFilesystem.
     * 
     *   Note that streaming requires specific server support; of SmartClient's built-in DataSource
     *   types, only SQLDataSource is able to stream results. This property is ignored
     *   by other DataSource types. If you wish to implement the necessary server-side behavior to
     *   support streaming with a custom DataSource, see the the server-side Javadocs for
     *   DSResponse.hasNextRecord() and DSResponse.nextRecordAsObject().
     * 
     *   See also the server-side documentation for DSResponse,
     *   SQLDataSource and StreamingResponseIterator.
     * 
     *   Note, that streaming results does not support fields with SummaryFunction
     *   on non-Oracle databases. Such fields will be skipped.
     *  @type {boolean}
     *  @default false
     */
    open var streamResults: Boolean = definedExternally
    /**
     *  Sets DataSource.progressiveLoading for this specific
     *   request, overriding the OperationBinding- and DataSource-level settings. Note that this
     *   setting applies only to fetch requests - it has no effect if specified on any other kind
     *   of request.
     *  @type {boolean}
     *  @default null
     */
    open var progressiveLoading: Boolean = definedExternally
    /**
     *  A set of key:value pairs, mapping field names to expressions that will be evaluated
     *   server-side to derive a value for that field. This property allows for client-driven
     *   transactionChaining, with some restrictions for security
     *   reasons:
     * 
     *  - Normal OperationBinding.values for a
     *   field take precedence over this property, so server-defined rules cannot be overridden
     *   from the client
     * 
     *  - Arbitrary Velocity expressions are not allowed in DSRequests sent from the client
     *   (fieldValueExpressions is also a valid property on a server-side DSRequest,
     *   and normal Velocity expressions are allowed in that case - see the server-side
     *   Javadoc for DSRequest.setFieldValueExpressions()). For client-originated
     *   requests, only the following bindings are allowed - see the
     *   velocitySupport for details of what these values mean:
     * 
     *  - $currentDate
     * 
     *  - $currentDateUTC
     * 
     *  - $transactionDate
     * 
     *  - $transactionDateUTC
     * 
     *  - $userId
     * 
     *  - $masterId - see DSRequestModifier.value for details
     * 
     *  - References to specific fields in prior responses, via $responseData.first and
     *      $responseData.last, with or without parameters. For example,
     *      $responseData.first("myDataSource", "fetch")[0].myField. See the
     *      velocitySupport for details of $responseData
     * 
     *  - References to certain metadata properties of prior responses, via $responses.first
     *      and $responses.last, with or without parameters. For example,
     *      $responses.last("myDataSource", "fetch").totalRows. Note that the only
     *      properties allowed in a client-driven fieldValueExpression are:
     *      "startRow", "endRow", "totalRows" and "status"; this restriction does not apply to
     *      server-driven fieldValueExpressions. See the Velocity overview for
     *      details of $responses
     * 
     * 
     *  - Normal DataSourceField.editRequiresRole apply: if a
     *   field is not valid for writing, its fieldValueExpression will be ignored.
     *   Again, this only applies to client-originated requests.
     * 
     *   Note, it is possible to globally disable fieldValueExpression in
     *   client-originated requests by setting a flag in your server.properties file:
     *    dataSource.allowClientFieldValueExpressions: false
     *  @type {object}
     *  @default null
     */
    open var fieldValueExpressions: dynamic = definedExternally
}