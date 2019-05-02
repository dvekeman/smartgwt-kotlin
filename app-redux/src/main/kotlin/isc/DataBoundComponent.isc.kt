@file:JsQualifier("isc")
package isc

external interface DataBoundComponent {
    var deepCloneOnEdit: Boolean
    var deepCloneNonFieldValuesOnEdit: Boolean
    var dataSource: dynamic
    var dataFetchMode: 
                       /**
                        *  All records that match the current filter are fetched. Sorting is        performed on the client.
                        *  Only requested ranges of records are fetched, with predictive fetch        ahead. Sorting is performed on the server.
                        *  All records available from the DataSource are fetched. Filtering by        search criteria and sorting are both performed on the client.
                        */
                       String /* basic |  paged |  local */
    var dataPageSize: Number
    var dataFetchDelay: Number
    var fields: Array<dynamic>
    var useAllDataSourceFields: Boolean
    var showHiddenFields: Boolean
    var showDetailFields: Boolean
    var showComplexFields: Boolean
    var fetchOperation: String
    var updateOperation: String
    var addOperation: String
    var removeOperation: String
    var exportFields: Array<dynamic>
    var exportAll: Boolean
    var exportIncludeSummaries: Boolean
    var dragRecategorize: 
                          /**
                           *  recategorize is always applied
                           *  recategorize if normal checks pass
                           *  never recategorize
                           */
                          String /* always |  checked |  never */
    var preventDuplicates: Boolean
    var duplicateDragMessage: String
    var showOfflineMessage: Boolean
    var offlineMessage: String
    var offlineSaveMessage: String
    var addDropValues: Boolean
    var dropValues: dynamic
    var dataArity: String
    var progressiveLoading: Boolean
    var canEditFieldAttribute: String
    var useFlatFields: Boolean
    var canChangeNonFieldValues: Boolean
    var autoFetchData: Boolean
    var initialCriteria: dynamic
    var implicitCriteria: dynamic
    var canEditHilites: Boolean
    var hilites: Array<dynamic>
    var hiliteIcons: Array<dynamic>
    var hiliteIconPosition: 
                            /**
                             *  icon will be placed before the normal cell contents
                             *  icon will be placed after the normal cell contents
                             *  icon will be shown instead of the normal cell contents
                             */
                            String /* before |  after |  replace */
    var hiliteIconSize: Number
    var hiliteIconWidth: Number
    var hiliteIconHeight: Number
    var hiliteIconLeftPadding: Number
    var hiliteIconRightPadding: Number
    var hiliteProperty: String
    var hiliteState: String
    var fieldNamingStrategy: 
                             /**
                              *  generate names in the format fieldTypeX, where field type might be     "formulaField" and X is an index specific to the field-type and component instance
                              *  generates a UUID for all generated field names
                              */
                             String /* simple |  uuid */
    var editHilitesText: String
    var editHilitesDialogTitle: String
    var fieldEditorWindowTitle: String
    var fieldEditorWindow: Window
    var hiliteEditor: HiliteEditor
    var dragDataAction: 
                        /**
                         *  Don't do anything, resulting in the same data being in both lists.
                         *  Copy the data leaving the original in our list.
                         *  Remove the data from this list so it can be moved into the other list.
                         */
                        String /* none |  copy |  move */
    var dragTrackerStyle: String
    var badFormulaResultValue: String
    var missingSummaryFieldValue: String
    var canAddFormulaFields: Boolean
    var addFormulaFieldText: String
    var editFormulaFieldText: String
    var removeFormulaFieldText: String
    var canAddSummaryFields: Boolean
    var addSummaryFieldText: String
    var editSummaryFieldText: String
    var removeSummaryFieldText: String
    var includeHilitesInSummaryFields: Boolean
    var titleField: String
    var iconField: String
    var infoField: String
    var dataField: String
    var descriptionField: String
    var emptyExportMessage: String
    var multiSortDialogProperties: MultiSortDialog
    var multiSortDialogDefaults: MultiSortDialog
    var unknownErrorMessage: String
    var noErrorDetailsMessage: String
    fun dragComplete (): Unit
    fun dropComplete (transferredRecords: Array<dynamic>): Unit
    fun getDataPathField (dataPath: String): Unit
    fun fieldIsEditable (field: dynamic): Boolean
    fun getField (fieldID: dynamic): dynamic
    fun getFieldNum (fieldName: String): Number
    fun find (advancedCriteria: AdvancedCriteria): dynamic
    fun findAll (advancedCriteria: AdvancedCriteria): Array<dynamic>
    fun findIndex (advancedCriteria: AdvancedCriteria): Number
    fun findNextIndex (startIndex: Number, advancedCriteria: AdvancedCriteria, endIndex: Number?): Number
    fun setDataSource (dataSource: dynamic, fields: Array<dynamic>?): Unit
    fun exportData (requestProperties: DSRequest?, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?)): Unit
    fun getFieldAlignments (): Array<dynamic>
    fun willFetchData (newCriteria: dynamic, textMatchStyle: 
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
                                                             String /* exact |  exactCase |  substring |  startsWith */?): Boolean
    fun findByKey (keyValue: dynamic): Record
    fun selectRecord (record: dynamic, newState: Boolean?): Unit
    fun selectSingleRecord (record: dynamic): Unit
    fun deselectRecord (record: dynamic): Unit
    fun selectRecords (records: dynamic, newState: Boolean?): Unit
    fun deselectRecords (records: dynamic): Unit
    fun selectAllRecords (): Unit
    fun deselectAllRecords (): Unit
    fun selectRange (startRow: Number, endRow: Number, newState: Boolean?): Unit
    fun deselectRange (startRow: Number, endRow: Number): Unit
    fun anySelected (): Boolean
    fun getSelectionLength (): Number
    fun getHilites (): Array<dynamic>
    fun setHilites (hilites: Array<dynamic>): Unit
    fun getHiliteState (): String
    fun setHiliteState (hiliteState: String): Unit
    fun enableHilite (hiliteID: String, enable: Boolean?): Unit
    fun disableHilite (hiliteID: String): Unit
    fun enableHiliting (enable: Boolean?): Unit
    fun disableHiliting (): Unit
    fun editHilites (): Unit
    fun transferRecords (dropRecords: Array<dynamic>, targetRecord: Record, index: Number, sourceWidget: Canvas, callback: dynamic?): Unit
    fun getDropValues (record: Record, sourceDS: DataSource, targetRecord: Record, index: Number, sourceWidget: Canvas): dynamic
    fun transferDragData (): Array<dynamic>
    fun getDragData (source: DataBoundComponent): Array<dynamic>
    fun transferSelectedData (source: DataBoundComponent, index: Number?, callback: dynamic?): Unit
    fun setDragTracker (): Boolean
    fun addFormulaField (): Unit
    fun editFormulaField (field: String): Unit
    fun getFormulaFieldValue (field: ListGridField, record: Record): dynamic
    fun addSummaryField (): Unit
    fun editSummaryField (field: String): Unit
    fun getSummaryFieldValue (field: ListGridField, record: Record): String
    fun shouldIncludeHiliteInSummaryField (summaryFieldName: String, usedFieldName: String): Boolean
    fun getRecordIndex (record: Record): Number
    fun getTitleFieldValue (record: Record): String
    fun getTitleField (): String
    fun getRecordHiliteCSSText (record: Record, cssText: String, field: String): String
    fun getSort (): Array<dynamic>
    fun setSort (sortSpecifiers: Array<dynamic>): Unit
    fun askForSort (): Unit
    fun isOffline (): Boolean
    fun editFields (): Unit
    fun userAddedField (field: ListGridField): Boolean
    fun selectionUpdated (record: dynamic, recordList: Array<dynamic>): Unit
}