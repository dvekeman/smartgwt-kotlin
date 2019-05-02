@file:JsQualifier("isc")
package isc

/**
 *  A component that connects to a database (and, depending on the RDBMS in use, optionally a
 *   particular catalog and/or schema) and displays the currently-defined tables, optionally
 *   filtered in a variety of ways. It also allows you to view the column details
 *   of a selected table, and optionally retrieves and displays the data currently in that table.
 * 
 *   The DatabaseBrowser can also create a SmartClient DataSource from any existing SQL table.
 */
open external class DatabaseBrowser : Window {
    /**
     *  The type of database server this DatabaseBrowser should connect to. Valid values are
     *   "sql" (SmartClient's own built-in support for SQL databases) or "hibernate"
     *  @type {string}
     *  @default "sql"
     */
    open var serverType: String = definedExternally
    /**
     *  The name of the database configuration to use. Database configurations are set up
     *   through the "Databases" tab of the Developer Console. If not set, defaults to the
     *   current default database configuration.
     * 
     *   Note that this property only applies where DatabaseBrowser.serverType is "sql"
     *  @type {string}
     *  @default null
     */
    open var dbName: String = definedExternally
    /**
     *  The name of the database catalog to use, if the RDBMS in use recognizes the concept of
     *   multiple catalogs. Leave this property unset to include all catalogs.
     * 
     *   Note that this property only applies where DatabaseBrowser.serverType is "sql"
     *  @type {string}
     *  @default null
     */
    open var catalog: String = definedExternally
    /**
     *  The name of the database schema to use. Leave this property unset to include all
     *   schemata. Note that this property is not applicable to the MySQL database, which
     *   does not recognize the concept of multiple schemata within a database.
     * 
     *   Note that this property only applies where DatabaseBrowser.serverType is "sql"
     *  @type {string}
     *  @default null
     */
    open var schema: String = definedExternally
    /**
     *  Instance of TreeGrid used to display the database schema (tables and columns)
     *  @type {ListGrid}
     *  @default null
     */
    open var schemaTree: ListGrid = definedExternally
    /**
     *  Instance of DynamicForm used to select a database from the list for display in the
     *   DatabaseBrowser.schemaTree.
     *  @type {ListGrid}
     *  @default null
     */
    open var databaseList: ListGrid = definedExternally
    /**
     *  Instance of ListGrid used to display the actual data in the table selected in the
     *   DatabaseBrowser.schemaTree.
     *  @type {ListGrid}
     *  @default null
     */
    open var dataGrid: ListGrid = definedExternally
    /**
     *  Instance of Button used to continue once a table has been selected.
     *  @type {Button}
     *  @default null
     */
    open var selectButton: Button = definedExternally
    /**
     *  A title to show in the header button of the DatabaseBrowser's schema tree. If not set,
     *   defaults to the name of the connected database
     *  @type {string}
     *  @default null
     */
    override var title: String = definedExternally
    /**
     *  If set, specifies a substring which must exist in a table name for it to be included in
     *   this DatabaseBrowser. If this property is set to a List of strings, table names are
     *   included if they match any one of the strings. The comparison is case-insensitive.
     * 
     *   For example, includeSubstring: ["E", "qry"] would match all the following
     *   table names: "table", "QryTbl", "QRY", "ORDERS"
     *  @type {string | Array<Partial<string>>}
     *  @default null
     */
    open var includeSubstring: dynamic = definedExternally
    /**
     *  If set, specifies a substring which must NOT exist in a table name for it to be included in
     *   this DatabaseBrowser. If this property is set to a List of strings, table names are
     *   excluded if they match any one of the strings. The comparison is case-insensitive.
     * 
     *   For example, excludeSubstring: ["E", "qry"] would exclude all the following
     *   table names: "table", "QryTbl", "QRY", "ORDERS"
     * 
     *   Note that if you specify both include and exclude criteria and they conflict (ie,
     *   according to the criteria you set, a table should be both included and excluded),
     *   exclude wins.
     *  @type {string | Array<Partial<string>>}
     *  @default null
     */
    open var excludeSubstring: dynamic = definedExternally
    /**
     *   Returns the DataSource most recently auto-derived by this DatabaseBrowser. This will
     *   correspond to the currently-selected table.
     * 
     */
    open fun getGeneratedDataSource(): Unit = definedExternally
    /**
     * 
     * 
     */
    open fun getResults(): Unit = definedExternally
    companion object {
        /**
         *  Creates a new DatabaseBrowser
         * 
         *  @param typeCheckedProperties {Partial<DatabaseBrowser>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DatabaseBrowser} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DatabaseBrowser = definedExternally
    }
}