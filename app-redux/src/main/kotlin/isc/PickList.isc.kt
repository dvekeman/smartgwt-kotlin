@file:JsQualifier("isc")
package isc

external interface PickList {
    var pickListHeight: Number
    var emptyPickListHeight: Number
    var emptyPickListMessage: String
    var hideEmptyPickList: Boolean
    var pickListWidth: Number
    var pickListMaxWidth: Number
    var pickListBaseStyle: String
    var pickListTallBaseStyle: String
    var pickListApplyRowNumberStyle: Boolean
    var animatePickList: Boolean
    var pickListAnimationTime: Number
    var fetchDelay: Number
    var pickListCellHeight: Number
    var pickListProperties: ListGrid
    var pickListHeaderHeight: Number
    var rootNodeId: dynamic
    var autoOpenTree: String
    var valueField: String
    var displayField: String
    var useLocalDisplayFieldValue: Boolean
    var dataSetType: String
    var pickListConstructor: String
    var pickTreeConstructor: String
    var pickListFields: Array<dynamic>
    var valueIconField: String
    var pickListCriteria: dynamic
    var optionDataSource: dynamic
    var showOptionsFromDataSource: Boolean
    var fetchDisplayedFieldsOnly: Boolean
    var optionFilterContext: DSRequest
    var filterLocally: Boolean
    var sortField: dynamic
    var initialSort: Array<dynamic>
    var useClientFiltering: Boolean
    var cachePickListResults: Boolean
    var iconPlacement: 
                       /**
                        *  icon will be displayed in the ComboBoxItem.pickerNavigationBar only (and not rendered
                        *   inline within the formItem itself)
                        *  icon will be displayed inline within the form item itself (and not within the
                        *   ComboBoxItem.pickerNavigationBar
                        *  icon will be displayed both inline (within the form item itself) and within the
                        *   ComboBoxItem.pickerNavigationBar
                        */
                       String /* pickerNavigationBar |  formItem |  both */
    var textMatchStyle: 
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
                        String /* exact |  exactCase |  substring |  startsWith */
    var showAllOptions: Boolean
    var separatorRows: Array<dynamic>
    var specialValues: dynamic
    fun fetchData (callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit
    fun getOptionDataSource (): DataSource
    fun getPickListFilterCriteria (): dynamic
    fun getValueFieldName (): String
    fun getDisplayFieldName (): String
    fun getClientPickListData (): Array<dynamic>
    fun dataArrived (startRow: Number, endRow: Number, data: ResultSet): Unit
    fun filterClientPickListData (): Array<dynamic>
}