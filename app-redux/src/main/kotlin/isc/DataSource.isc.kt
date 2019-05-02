@file:JsQualifier("isc")
package isc

/**
 *  A DataSource is data-provider-independent description of a set of objects
 *   that will be loaded, edited and saved within the user interface of your application.
 * 
 *   Each DataSource consists of a list of DataSource.fields that make up a
 *   DataSource record, along with DataSourceField.type,
 *   DataSourceField.validators,
 *   DataSourceField.foreignKey to other DataSources, and other
 *   metadata.
 * 
 *   The abstract object description provided by a DataSource is easily mapped to a variety of
 *   backend object models and storage schemes. The following table shows analogous terminology
 *   across systems.
 * 
 * 
 *    Isomorphic SmartClient
 *    Relational Database
 *    Enterprise Java Beans (EJB)
 *    Entity/Relationship Modeling
 *    OO/UML
 *    XML Schema/WSDL
 *    LDAP
 * 
 *    DataSource
 *    Table
 *    EJB class
 *    Entity
 *    Class
 *    Element Schema (ComplexType)
 *    Objectclass
 * 
 *    Record
 *    Row
 *    EJB instance
 *    Entity instance
 *    Class instance/Object
 *    Element instance (ComplexType)
 *    Entry
 * 
 *    Field
 *    Column
 *    Property
 *    Attribute
 *    Property/Attribute
 *    Attribute or Element (SimpleType)
 *    Attribute
 * 
 * 
 *   DataSources can be dataSourceDeclaration in either JavaScript or XML
 *   format, and can also be metadataImport from existing metadata formats,
 *   including XML Schema.
 * 
 *   Data Binding is the process by which
 *   DataBoundComponent can automatically configure
 *   themselves for viewing, editing and saving data described by DataSources. DataBinding is
 *   covered in the ${isc.DocUtils.linkForDocNode('QuickStartGuide', 'QuickStart Guide')}, Chapter 6, Data
 *   Binding.
 * 
 *   clientServerIntegration is the process by which a DataSource
 *   can be connected to server systems such as SQL DataBases, Java Object models, WSDL web
 *   services and other data providers. Data Integration comes in two variants: client-side and
 *   server-side. serverDataIntegration uses the
 *   SmartClient Java-based server to connect to data represented by Java Objects or
 *   JDBC-accessible databases. clientDataIntegration
 *   connects SmartClient DataSources to XML, JSON or other formats accessible via HTTP.
 * 
 *   DataSources have a concept of dataSourceOperations ("fetch",
 *   "add", "update" and "remove") that can be performed on the set of objects represented by a
 *   DataSource. Once a DataSource has been integrated with your data store, databinding-capable
 *   UI components can leverage the 4 core DataSource operations to provide many complete user
 *   interactions without the need to configure how each individual component loads and saves
 *   data.
 * 
 *   These interactions include ListGrid, TreeGrid,
 *   DetailViewer, DynamicForm-based
 *   DynamicForm.editRecord and DynamicForm.saveData,
 *   grid-based ListGrid.canEdit and ListGrid.saveByCell,
 *   and custom interactions provided by ${isc.DocUtils.linkForExampleId('patternReuse')} custom
 *   databinding-capable components.
 */
open external class DataSource : Class {
    /**
     *  Unique identifier for this DataSource. Required for all DataSources.
     * 
     *   DataSources will make themselves available as JavaScript globals under
     *   the same name as their ID only if DataSource.addGlobalId is set.
     *  @type {string}
     *  @default null
     */
    open var ID: String = definedExternally
    /**
     *  Whether to make this DataSource available as a global variable for convenience.
     *  @type {boolean}
     *  @default true
     */
    open var addGlobalId: Boolean = definedExternally
    /**
     *  Indicates the format to be used for HTTP requests and responses when
     *   fulfilling DSRequests (eg, when DataSource.fetchData is called).
     *  @type {DSDataFormat}
     *  @default "iscServer"
     */
    open var dataFormat: 
                         /**
                          *  Make an HTTP request in a format recognized by the ISC server and expect ISC server
                          *   response format. serverDataIntegration can then be
                          *   used to connect to any kind of data store or web service.
                          *  Expect XML responses. Request format depends on the setting for
                          *   OperationBinding.dataProtocol. This is the correct setting when
                          *   consuming RSS feeds, XML web services (whether SOAP, REST, XML-RPC or custom format),
                          *   and XML flat files directly from the browser.
                          * 
                          *   Values for "date", "time" or "datetime" fields in responses should be specified in the
                          *   applicable XML Schema
                          *   date format.
                          *   If no timezone is explicitly specified, dates / datetimes received by the client are
                          *   assumed to be GMT. Note that "date" type fields represent logical dates and may omit
                          *   time information entirely, and "time" type fields may omit date information.
                          *   See dateFormatAndStorage for more information
                          *   on how date values are serialized in requests sent to the server.
                          * 
                          * 
                          *   A DSResponse will be derived from the returned XML via the process described under
                          *   DataSource.transformResponse.
                          *  Expect response in JSON (Java Script Object Notation)
                          *   format, ready to be eval()'d. Response should either be a naked object literal:
                          * 
                          *     { "property":"value1", "property2" : "value2", ... }
                          * 
                          *   or a string that evals to return a valid response object:
                          * 
                          *     var response = { "property":"value1", "property2" : "value2", ... }
                          *     response;
                          * 
                          * 
                          *   A DSResponse will be derived from the returned JSON via the process described under
                          *   DataSource.transformResponse.
                          * 
                          *   As with "xml" responses, values for "date" or "datetime" fields should be
                          *   specified as a String in
                          *   XML Schema date format
                          *   and may include a timezone. In the absence of a timezone they will be assumed to be GMT.
                          * 
                          *   Request format depends on the setting for OperationBinding.dataProtocol.
                          *   See also XJSONDataSource.
                          *  SmartClient will not attempt to parse the response, instead,
                          *   DataSource.transformResponse must be implemented.
                          *   transformResponse will receive the "data" parameter as a String, and must
                          *   parse this String into an Array of Objects, which should be set as
                          *   DSResponse.data. Request format depends on the setting for
                          *   OperationBinding.dataProtocol.
                          * 
                          *   Note that, unlike either the "json" or "xml" settings of dataFormat, you
                          *   are responsible for ensuring that parsed values are the correct type, for example, using
                          *   the JavaScript built-ins parseInt and parseFloat on integer
                          *   and decimal values respectively, and using new Date() to construct valid
                          *   Dates.
                          */
                         String /* iscServer |  xml |  json |  custom */ = definedExternally
    /**
     *  Should HTTP responses to requests by this dataSource be formatted using the
     *   strict JSON subset of the javascript language?
     *   If set to true, responses returned by the server should match the format described
     *   here.
     * 
     *   Only applies to dataSources which send requests to a server and have
     *   DataSource.dataFormat set to "json" or "iscServer".
     * 
     *   Note: using strict JSON avoids a known issue in Internet Explorer 9 where
     *   datasource transactions can leak memory due to a browser behavior where the native
     *   eval() method fails to clean up references when the objects
     *   go out of scope. See RPCManager.allowIE9Leak for more on this.
     *  @type {boolean}
     *  @default null
     */
    open var useStrictJSON: Boolean = definedExternally
    /**
     *  Controls the format in which inputs are sent to the dataURL when fulfilling DSRequests.
     *   May be overridden for individual request types using
     *   OperationBinding.dataProtocol.
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
     *  Like OperationBinding.useHttpProxy, but serves as a default for this DataSource
     *   that may be overridden by individual operationBindings.
     *  @type {boolean}
     *  @default null
     */
    open var useHttpProxy: Boolean = definedExternally
    /**
     *  Applies only to dataFormat: "json" and DataSource.dataTransport:"scriptInclude". Specifies
     *   the name of the query parameter that tells your JSON service what function to call as
     *   part of the response.
     *  @type {string}
     *  @default "callback"
     */
    open var callbackParam: String = definedExternally
    /**
     *  Additional properties to pass through to the DSRequests made by this
     *   DataSource. This must be set before any DSRequests are issued and before
     *   any component is bound to the DataSource.
     * 
     *   These properties are applied before DataSource.transformRequest is called.
     *  @type {DSRequest}
     *  @default null
     */
    open var requestProperties: DSRequest = definedExternally
    /**
     *  Transport to use for all operations on this DataSource. Defaults to
     *   RPCManager.defaultTransport. This would typically only be set to
     *   enable "scriptInclude" transport for contacting DataSource.dataFormat web
     *   services hosted on servers other than the origin server.
     * 
     *   When using the "scriptInclude" transport, be sure to set DataSource.callbackParam or
     *   OperationBinding.callbackParam to match the name of the query parameter name expected
     *   by your JSON service provider.
     *  @type {RPCTransport}
     *  @default "xmlHttpRequest"
     */
    open var dataTransport: 
                            /**
                             *  Uses the XMLHttpRequest object to make the request to the server. Note that in some browsers with certain configurations, this transport may not be
                             *   available. See platformDependencies for more information. This transport is
                             *   not useful with file uploads. Cannot be used to target cross-domain URLs directly.
                             *  Write a SCRIPT tag into the DOM with a SRC attribute that targets an arbitrary URL. This transport is the only one that allows direct cross-domain URL
                             *   access.
                             * 
                             *   For RPCRequest.callback to work, the server being contacted must support the ability
                             *   to generate JavaScript code in the response that will call a JavaScript function generated
                             *   by SmartClient. SmartClient passes the name of the function to call via a URL parameter,
                             *   which can be controlled with RPCRequest.callbackParam. This callback mechanism is
                             *   sometimes called the "JSONP" (JSON with Padding) approach.
                             *  Available with SmartClient Server only. An HTML form is dynamically assembled that targets a hidden IFRAME. This mechanism is supported on all
                             *   browsers and cannot be disabled by end users.
                             * 
                             *   If using the SmartClient Server and using
                             *   serverDataIntegration, the "hiddenFrame" transport
                             *   is automatically used for all RPCManager and DataSource requests if the "xmlHttpRequest"
                             *   transport is not available.
                             * 
                             *   Cannot be used to target cross-domain URLs directly.
                             */
                            String /* xmlHttpRequest |  scriptInclude |  hiddenFrame */ = definedExternally
    /**
     *  If set, the DataSource will ensure that it never uses a cached HTTP response, even if the
     *   server marks the response as cacheable.
     * 
     *   Note that this does not disable caching at higher levels in the framework, for example, the
     *   caching performed by ResultSet.
     *  @type {boolean}
     *  @default true
     */
    open var preventHTTPCaching: Boolean = definedExternally
    /**
     *  For a DataSource stored in .xml format on the SmartClient server, indicates what server-side
     *   connector to use to execute requests, that is, what happens if you call
     *   dsRequest.execute() in server code.
     *  @type {DSServerType}
     *  @default "generic"
     */
    open var serverType: 
                         /**
                          *  Use SmartClient's sqlDataSource to talk directly
                          *   to relational databases.
                          *  Use Hibernate, either using a real mapped bean or by automatically generating a
                          *   Hibernate configuration based on a SmartClient DataSource file
                          *   (dataSourceID.ds.xml). See hibernateIntegration for details.
                          *  Use SmartClient's built-in JPA 2.0 connector.
                          *  Use SmartClient's built-in JPA 1.0 connector.
                          *  Requests will be delivered to the server and you are expected to write Java code to
                          *   create a valid response. Throws an error if the server side method dsRequest.execute()
                          *   is called. This is appropriate if you intend an entirely custom implementation, and you
                          *   want an error thrown if there is an attempt to call an operation you have not
                          *   implemented.
                          *  Requests will be delivered to the server and processed as
                          *   fileSource, using directories or other DataSources
                          *   which you configure via DataSource.projectFileKey or DataSource.projectFileLocations
                          */
                         String /* sql |  hibernate |  jpa |  jpa1 |  generic |  projectFile */ = definedExternally
    /**
     *  For DataSources using the sqlDataSource for
     *   persistence, what database table name to use. The default is to use the DataSource ID
     *   as the table name.
     *  @type {string}
     *  @default null
     */
    open var tableName: String = definedExternally
    /**
     *  This property only applies to the built-in SQL DataSource provided in Pro and better
     *   editions of SmartClient
     * 
     *   Defines the name of the schema we use to qualify the DataSource.tableName in generated
     *   SQL. If you do not provide this property, table names will not be qualified in generated
     *   SQL, and thus the default schema will be used. Support for multiple schemas (or schemata)
     *   varies quite significantly across the supported databases, as does the meaning of the
     *   phrase "default schema". In addition, some databases allow you to override the default
     *   schema in the JDBC connection URL, which is a preferable approach if all your tables are
     *   in the same (non-default) schema.
     * 
     *   The following table provides information by product:
     * 
     * 
     *   Product Notes
     *   DB2
     *   Arbitrarily named schemas are supported. The default schema is named after the connecting
     *   user, though this can be overridden by specifying the "currentSchema" property on the JDBC
     *   connection URL
     *   DB2 for iSeries
     *   Arbitrarily named schemas are supported. "Schema" is synonymous with "library". The
     *   default schema depends on the setting of the "naming" connection property. When this is
     *   set to "sql", behavior is similar to other DB2 editions: the default schema is named after
     *   the connecting user, unless overridden by specifying a library name in the JDBC connection
     *   URL. When "naming" is set to "system", the schema of an unqualified table is resolved
     *   using a traditional search of the library list; the library list can be provided in the
     *   "libraries" property
     *   Firebird
     *   Firebird does not support the concept of schema at all - all "schema objects" like tables
     *   and indexes belong directly to the database. In addition, Firebird actively rejects
     *   qualified table names in queries as syntax errors; therefore, you should not set
     *   the schema property for a DataSource that will be backed by a Firebird database
     * 
     *   HSQLDB
     *   Arbitrarily named schemas are supported. The default schema is auto-created when the
     *   database is created; by default it is called "PUBLIC", but can be renamed. It is not
     *   possible to set the default schema in the JDBC connection URL
     *   Informix
     *   Informix databases can be flagged as "ANSI mode" at creation time. ANSI-mode databases
     *   behave similarly to DB2 for schema support: arbitrarily named schemas are supported, and
     *   the default schema is the one named after the connected user. Non-ANSI databases have no
     *   real schema support at all. It is not possible to set the default schema in the JDBC
     *   connection URL with either type of database
     *   Microsoft SQL Server
     *   Prior to SQL Server 2005, schema support is similar to Oracle: "schema" is synonymous with
     *   "owner". As of SQL Server 2005, schema is supported as a separate concept, and a user's
     *   default schema can be configured (though it still defaults to a schema with the same name
     *   as the user). It is not possible to set the default schema in the JDBC connection URL
     *   MySQL
     *   MySQL does not have a separate concept of "schema"; it treats the terms "schema" and
     *   "database" interchangeably. In fact MySQL databases actually behave more like schemas, in
     *   that a connection to database X can refer to a table in database Y simply by qualifying
     *   the name in the query. Also, because schema and database are the same concept in MySQL,
     *   overriding the "default schema" is done implicitly when you specify which database to
     *   connect to in your JDBC connection URL
     *   Oracle
     *   Arbitrarily named schemas are not supported; in Oracle, "schema" is synonymous with "user",
     *   so each valid user in the database is associated implicitly with a schema of the same name,
     *   and there are no other schemas possible. It is possible to refer to tables in another
     *   user's schema (assuming you have the privileges to do so) by simply qualifying the table name.
     *   The default schema is always implied by the connecting user and cannot be overridden.
     *   Postgres
     *   Arbitrarily named schemas are supported.
     *   Rather than the concept of a "default schema", Postgres supports the idea of a search path
     *   of schemas, whereby unqualified table references cause a search of the list of schemas in
     *   order, and the first schema in the path is the "current" one for creation purposes.
     *   Unfortunately, there is no way to specify this search path on the JDBC connection URL, so
     *   the default schema comes from the user definition, ultimately defaulting to the default
     *   "public" schema
     * 
     *  @type {string}
     *  @default null
     */
    open var schema: String = definedExternally
    /**
     *  For SQL DataSources, tells the framework whether to surround the associated
     *   DataSource.tableName with quotation marks whenever it appears in
     *   generated queries. This is only required if you have to connect to a table with a name
     *   that is in breach of your database product's naming conventions. For example, some
     *   products (eg, Oracle) internally convert all unquoted references to upper case, so if
     *   you create a table called myTest, the database actually calls it
     *   MYTEST unless you quoted the name in the create command, like this:
     * 
     *   &nbsp;&nbsp;CREATE TABLE "myTest"
     * 
     *   If you do quote the name like this, or if you have to connect to a legacy table
     *   that has been named in this way, then you must set this property to tell the SQL engine
     *   that it must quote any references to this table name (this requirement depends on the
     *   database in use - as noted below, some are not affected by this problem). If you do
     *   not, you will see exceptions along the lines of "Table or view 'myTest' does not exist".
     * 
     *   Note, other database products (eg, Postgres) convert unquoted names to lower case, which
     *   leads to the same issues. Still others (eg, SQL Server) are not case sensitive and are
     *   not affected by this issue.
     * 
     *   Generally, we recommend that you avoid using this property unless you have a specific
     *   reason to do so. It is preferable to avoid the issue altogether by simply not quoting
     *   table names at creation time, if you are able to do so.
     *  @type {boolean}
     *  @default null
     */
    open var quoteTableName: Boolean = definedExternally
    /**
     *  For DataSources using the sqlDataSource for
     *   persistence, which database configuration to use. Database configurations can be
     *   created using the adminConsole. If unset, the default
     *   database configuration is used (which is also settable using the "Databases" tab).
     *  @type {string}
     *  @default null
     */
    open var dbName: String = definedExternally
    /**
     *  For DataSources of DataSource.serverType "hibernate", the name of a Spring
     *   bean to query to obtain Hibernate Configuration for this particular DataSource. Note
     *   that this is intended for DataSource-specific configuration overrides for unusual
     *   circumstances, such as a DataSource whose physical data store is a completely
     *   different database to that used by other DataSources. See the
     *   hibernateIntegration article for more
     *   information
     *  @type {string}
     *  @default null
     */
    open var configBean: String = definedExternally
    /**
     *  If set, tells the SQL engine to quote column names in all generated DML and DDL
     *   statements for this dataSource. This will ensure that queries generated against
     *   tables that do not follow the database product's natural column-naming conventions
     *   will still work.
     * 
     *   In general we recommend that you allow the database to use its natural naming scheme
     *   when creating tables (put more simply, just do not quote column names in the
     *   CREATE TABLE statement); if you do this, you will not need to worry about
     *   quoting column names when querying. However, if you are dealing with pre-existing
     *   tables, or do not have control over the database naming conventions used, this property
     *   may become necessary. This property may also be necessary if you are using field/column
     *   names that clash with reserved words in the underlying database (these vary by database,
     *   but a field called "date" or "timestamp" would have problems with most database products)
     * 
     *   Note: Only applicable to dataSources of DataSource.serverType "sql".
     *  @type {boolean}
     *  @default null
     */
    open var quoteColumnNames: Boolean = definedExternally
    /**
     *  Allows you to specify an arbitrary prefix string to apply to all json format responses
     *   sent from the server to this application.
     * 
     *   The inclusion of such a prefix ensures your code is not directly executable outside of
     *   your application, as a preventative measure against
     *   javascript hijacking.
     * 
     *   Only applies to responses formatted as json objects. Does not apply to responses returned
     *   via scriptInclude type transport.
     *   Note: If the prefix / suffix served by your backend is not a constant, you can use
     *   OperationBinding.dataFormat instead and explicitly parse
     *   the prefix out as part of DataSource.transformResponse.
     *  @type {string}
     *  @default null
     */
    open var jsonPrefix: String = definedExternally
    /**
     *  Allows you to specify an arbitrary suffix string to apply to all json format responses
     *   sent from the server to this application.
     * 
     *   The inclusion of such a suffix ensures your code is not directly executable outside of
     *   your application, as a preventative measure against
     *   javascript hijacking.
     * 
     *   Only applies to responses formatted as json objects. Does not apply to responses returned
     *   via scriptInclude type transport.
     *  @type {string}
     *  @default null
     */
    open var jsonSuffix: String = definedExternally
    /**
     *  The list of fields that compose records from this DataSource.
     * 
     *   Each DataSource field can have type, user-visible title, validators, and other metadata
     *   attached.
     * 
     * 
     *   After a DataSource has been Class.create, access the list of fields via
     *   DataSource.getFieldNames and access individual fields via
     *   DataSource.getField.
     * 
     *  @type {Array<Partial<DataSourceField>>}
     *  @default null
     */
    open var fields: Array<dynamic> = definedExternally
    /**
     *  ID of another DataSource this DataSource inherits its DataSource.fields from.
     * 
     *   Local fields (fields defined in this DataSource) are added to inherited fields
     *   to form the full set of fields. Fields with the same name are merged in the same way
     *   that DataBoundComponent.fields are merged with
     *   DataSource fields.
     * 
     *   The default order of the combined fields is new local fields first (including any fields
     *   present in the parent DataSource which the local DataSource re-declares), then parent
     *   fields. You can set DataSource.useParentFieldOrder to instead use the parent's field
     *   order, with new local fields appearing last. You can set DataSource.showLocalFieldsOnly to
     *   have all non-local fields hidden.
     * 
     *   Note that only fields are inherited - other properties such as dataURL and
     *   dataFormat are not. You can use ordinary inheritance, that is, creating a subclass of
     *   DataSource, in order to share properties such as dataURL across a series of DataSources
     *   that also inherit fields from each other via inheritsFrom.
     * 
     *   This feature can be used for:
     * 
     * 
     *  - creating a customized view (eg, only certain fields shown) which will be used by
     *   multiple DataBoundComponent.
     * 
     *  - adding presentation-specific attributes to metadata that has been automatically
     *   derived from XMLTools.loadXMLSchema or other metadata formats
     * 
     *  - modeling object subclassing and extension in server-side code and storage systems
     * 
     *  - modeling relational database joins, and the equivalents in other systems
     * 
     *  - creating hooks for others to customize your application in a maintainable way. For
     *   example, if you have a dataSource "employee", you can create a dataSource
     *   "customizedEmployee" which inherits from "employee" but does not initially define any
     *   fields, and bind all DataBoundComponent to
     *   "customizedEmployee". Customizations of fields (including appearance changes, field
     *   order, new fields, hiding of fields, and custom validation rules) can be added to
     *   "customizedEmployee", so that they are kept separately from the original field data and
     *   have the best possible chance of working with future versions of the "employee"
     *   dataSource.
     * 
     *  @type {string}
     *  @default null
     */
    open var inheritsFrom: String = definedExternally
    /**
     *  For dataSources of DataSource.serverType "sql" and "hibrenate", specifies the inheritance
     *   mode to use. This property has no effect for any other type of DataSource.
     *  @type {DSInheritanceMode}
     *  @default "full"
     */
    open var inheritanceMode: 
                              /**
                               *  Inherit fields by copying them onto the inheriting DataSource's underlying table. When we
                               *   import a DataSource with this inheritanceMode, we create actual columns for inherited fields
                               *   on the table we create. With this inheritanceMode, inherited fields are updatable.
                               *  Do not physically inherit fields onto the inheriting DataSource's SQL table. Columns will
                               *   not be created for inherited fields on import, and all generated SQL operations will exclude
                               *   inherited fields. However, those fields are still part of the DataSource's schema so you
                               *   can, for example, write customQuerying that returns values for
                               *   the inherited fields, and they will be delivered to the client.
                               */
                              String /* full |  none */ = definedExternally
    /**
     *  For fields of DataSourceField.type "sequence" in a dataSource of
     *   DataSource.serverType "sql", indicates the
     *   SequenceMode to use. This property has no effect for fields or dataSources of
     *   other types.
     * 
     *   You can set a default sequenceMode for all DataSources of a given database type by setting
     *   property "sql.{database_type}.default.sequence.mode" in server.properties.
     *   You set a global default sequenceMode that applies to all database types by setting property
     *   "sql.default.sequence.mode". For example:
     *    sql.mysql.default.sequence.mode: jdbcDriver
     * 
     * 
     *  @type {SequenceMode}
     *  @default "native"
     */
    open var sequenceMode: 
                           /**
                            *  Use the JDBC 3.0 API "getGeneratedKeys()" to get the most recent           sequence value. Obviously, this is only an option for JDBC 3.0+ drivers
                            *  Use a database-specific native technique to obtain the most recent           sequence value. The actual technique used varies widely depending on
                            *             the vagaries of the underlying database (and sometimes the vagaries of
                            *             particular releases of a database product)
                            *  No automatic attempt is made to retrieve the most recent sequence value.           You are expected to handle this by providing a
                            *             OperationBinding.cacheSyncOperation that is
                            *             able to return the entire row without needing generated PK values for
                            *             context. For example, a query that uses MAX(pk) would be
                            *             capable of this. To give a more complex example, say you have a
                            *             sequence value that is retrieved from a legacy system: you could store
                            *             that sequence value in the HTTP session and then have your custom
                            *             cacheSyncOperation reference that session attribute in
                            *             its WHERE clause. Also note that cacheSyncOperations,
                            *             like any other OperationBinding,
                            *             can be OperationBinding.serverObject or any
                            *             OperationBinding.script -
                            *             you do not have to use SQL
                            */
                           String /* jdbcDriver |  native |  none */ = definedExternally
    /**
     *  Like DataBoundComponent.useFlatFields, but applies to all DataBound components
     *   that bind to this DataSource.
     *  @type {boolean}
     *  @default null
     */
    open var useFlatFields: Boolean = definedExternally
    /**
     *  For a DataSource that inherits DataSource.fields from another DataSource
     *   (via DataSource.inheritsFrom), indicates that only the fields listed in this DataSource
     *   should be shown. All other inherited parent fields will be marked "hidden:true".
     *  @type {boolean}
     *  @default null
     */
    open var showLocalFieldsOnly: Boolean = definedExternally
    /**
     *  For a DataSource that inherits DataSource.fields from another DataSource
     *   (via DataSource.inheritsFrom), indicates that the parent's field order should be used
     *   instead of the order of the fields as declared in this DataSource. New fields, if any,
     *   are placed at the end.
     *  @type {boolean}
     *  @default null
     */
    open var useParentFieldOrder: Boolean = definedExternally
    /**
     *  Indicates that for server responses, for any data being interpreted as DataSource records,
     *   only data that
     *   corresponds to declared fields should be retained; any extra fields should be discarded.
     * 
     *   For DataSource.dataFormat data, this means extra properties in selected
     *   objects are dropped.
     * 
     *   By default, for DMI DSResponses, DSResponse.data is filtered on the server to just
     *   the set of fields defined on the DataSource. This type of filtering can also be enabled
     *   for non-DMI DSResponses (see the overview in dmiOverview). Setting this property to
     *   false disables this filtering for this DataSource only. This setting
     *   overrides the configuration in server_properties. This setting can
     *   be overridden by ServerObject.dropExtraFields.
     *  @type {boolean}
     *  @default null
     */
    open var dropExtraFields: Boolean = definedExternally
    /**
     *  Analogous to DataSource.dropExtraFields, for data sent to the server. Setting this
     *   attribute to false ensures that for any records in the data object, only fields that
     *   correspond to declared dataSource fields will be present on the dsRequest data object passed
     *   to DataSource.transformRequest and ultimately sent to the server.
     *  @type {boolean}
     *  @default true
     */
    open var sendExtraFields: Boolean = definedExternally
    /**
     *  This property allows you to specify that your DataSource's schema (field definitions) should
     *   be automatically derived from some kind of metadata. This causes SmartClient to create
     *   a special super-DataSource, which is used purely as a source of default schema for this
     *   DataSource; this is arranged by causing the autoDerived DataSource to automatically
     *   DataSource.inheritsFrom the special super-DataSource. This allows you to
     *   auto-derive schema from existing metadata, whilst still being able to override any or all
     *   of it as required.
     *   This property has a different implementation depending upon the
     *   DataSource.serverType of the DataSource:
     * 
     *  - For a DataSource with serverType: "sql", automatically derive the dataSource's schema
     *   from the Spring bean or Java class specified in DataSource.schemaBean. If
     *   schemaBean is not specified, derive the schema from the columns in the SQL
     *   table specified in DataSource.tableName. More information on SQL DataSources
     *   is sqlDataSource
     * 
     *  - For a DataSource with serverType: "hibernate", automatically derive the dataSource's
     *   schema from the Spring bean, Hibernate mapping or Java class named in the
     *   DataSource.schemaBean property. If no such thing exists, derive the schema from
     *   the Hibernate mapping or Java class specified in the DataSource.beanClassName
     *   property (this allows you to specify schema and mapping separately, in the unusual
     *   circumstance that you have a need to do so). Note that the "mappings" referred to here
     *   can mean either .hbm.xml files or annotated classes; both are supported.
     *   If neither of these is successful, derive the schema from the underlying SQL table
     *   specified in DataSource.tableName. More information on Hibernate DataSources is
     *   hibernateIntegration
     * 
     *  - For a DataSource with serverType: "jpa1" or "jpa", automatically derive the
     *   dataSource's schema from the annotated JPA class named in the DataSource.schemaBean
     *   property. If the schemaBean property is not defined, derive the schema from the
     *   annotated JPA class named in the DataSource.beanClassName property (as with
     *   Hibernate, this allows you to specify schema and mapping separately if you need to do
     *   so). JPA DataSource generation relies on annotations (the orm.xml mapping file is not
     *   supported). More information on JPA DataSources is jpaIntegration
     * 
     *  - For other DataSource types, attempt to find a Spring bean with the name specified in
     *   the DataSource.schemaBean property. If no such bean is found (or Spring is not
     *   present), attempt to instantiate an object whose fully-qualified class name is the value
     *   in the schemaBean property. If one of these approaches succeeds, we derive
     *   the schema from the discovered object (by treating it as a Java Bean and assuming that
     *   each one of its getters corresponds to a like-named field in the DataSource). More
     *   information on custom DataSource implementations is writeCustomDataSource.
     * 
     *   Field types
     *   The following table shows how SQL types are derived into
     *   FieldType when we use an SQL table as a source of metadata
     *   for a SQL or Hibernate DataSource:
     * 
     *   SQL typeDataSourceField.type
     *   CHAR, VARCHAR, LONGVARCHAR, TEXT, CLOBtext
     *   BIT, TINYINT, SMALLINT, INTEGER, BIGINT, DECIMAL\*, NUMBER\*\*integer
     *   REAL, FLOAT, DOUBLE, DECIMAL\*, NUMBER\*\*float
     *   DATEdate
     *   TIMEtime
     *   TIMESTAMPdatetime
     *   BLOB, BINARY, VARBINARY, LONGVARBINARYbinary
     * 
     *   \*For DECIMAL types, we inspect the "DECIMAL_DIGITS" attribute of the JDBC
     *   metadata and designate the field type "integer" if that attribute is 0, or "float" if
     *   it is some other value.
     *   \*\*NUMBER is an Oracle-only type that appears in the JDBC metadata as DECIMAL
     *   and is handled exactly the same way as DECIMAL
     * 
     *   The following table shows how Java types are derived into DataSource types when we use
     *   an unannotated Java class (Spring bean, Hibernate mapping or POJO) as a source of
     *   metadata for a SQL, Hibernate or custom DataSource:
     * 
     *   Java typeDataSourceField.type
     *   boolean, Booleanboolean
     *   char, Character, String, Readertext
     *   byte, short, int, long, Byte, Short, Integer, Long, BigIntegerinteger
     *   float, double, Float, Double, BigDecimalfloat
     *   Enumenum (see discussion below)
     *   InputStreambinary
     *   java.sql.Date, java.util.Date, java.util.Calendardate
     *   java.sql.Timetime
     *   java.sql.Timestampdatetime
     * 
     * 
     *   Finally, this table shows how Java types are derived into DataSource types when we use an
     *   annotated class as a source of metadata. Note annotated classes are necessary for JPA
     *   DataSources, but you can choose to use them for other types of DataSource as well.
     *   For Hibernate DataSources, this is very worthwhile because Hibernate will also make use
     *   of the annotations as config, meaning you don't need to specify .hbm.xml
     *   files. For SQL and custom DataSources, there is no benefit at the persistence level,
     *   but it may still be worthwhile because the use of an annotated class gives us better
     *   metadata and allows us to generate a better, closer-fitting autoDerive DataSource than
     *   we can from examination of SQL schema or plain Java Beans:
     * 
     *   Java typeDataSourceField.type
     *   boolean, Booleanboolean
     *   char, Character, String, Readertext
     *   byte, short, int, long, Byte, Short, Integer, Long, BigIntegerinteger
     *   float, double, Float, Double, BigDecimalfloat
     *   InputStreambinary
     *   java.util.Date (with Temporal set to DATE), java.sql.Datedate
     *   java.util.Date (with Temporal set to TIME), java.sql.Timetime
     *   java.util.Date (with Temporal set to TIMESTAMP), java.util.Calendar, java.sql.Timestampdatetime
     *   Enum (with Enumerated set to STRING)enum (see discussion below)
     *   Enum (with Enumerated set to ORDINAL)intEnum (see discussion below)
     *   Field with Lob annotationbinary
     *   Field with GeneratedValue annotationsequence, if the field is an integer type (see discussion below)
     * 
     * 
     *   Primary keys, sequences and identity columns
     *   We attempt to derive information about primary keys from the metadata we have.
     * 
     *   If the metadata source is an SQL table:
     * 
     * 
     *  - If the table does not have a native primary key constraint, no attempt is made to
     *     identify primary key fields. Otherwise:
     * 
     *  - The column or columns that make up the table's native primary key constraint are
     *     identified using the JDBC DatabaseMetaData.getPrimaryKeys() API
     * 
     *  - Each DataSource field that corresponds to one of these native primary key columns
     *     is marked primaryKey: true
     * 
     *  - For each of these columns, the metadata returned by
     *     DatabaseMetaData.getColumns() is inspected. If the metadata includes
     *     IS_AUTOINCREMENT=YES, we mark the corresponding field as
     *     type="sequence". This information should be reliably provided by
     *     databases that implement "auto-increment" or "identity" column types, such as MySQL
     *     or Microsoft SQL Server
     * 
     *  - If the previous step does not identify a column as a sequence, we inspect the
     *     ResultSetMetaData obtained by running a dummy query on the table. If
     *     the isAutoIncrement() API returns true for that column, we mark the
     *     corresponding field as type="sequence"
     * 
     *  - If the previous steps have not identified the column as a sequence, we check the
     *     TYPE_NAME in the column metadata. If it is "serial", this means the
     *     column is a PostgreSQL "serial" or "serial8" type column. Postgres does not
     *     transparently implement auto-increment columns, but it does provide this serial
     *     type, which causes the column to be implicitly bound to an underlying sequence. So
     *     this type causes us to mark the field type="sequence", and we also set
     *     DataSourceField.implicitSequence true
     * 
     *  - If the previous steps have not identified the column as a sequence, we check the
     *     COLUMN_DEF in the column metadata. If this contains the token "$$ISEQ"
     *     and ends with "NEXTVAL", this means the column is an Oracle "GENERATED AS IDENTITY"
     *     column. This type of column was introduced in Oracle 12c and is conceptually
     *     exactly the same thing as the Postgres "serial" column described above. We treat
     *     it the same way: mark it type="sequence" and
     *     implicitSequence="true"
     * 
     *  - If the previous steps have not identified the column as a sequence, then you may
     *     be using a pure sequence database, such as an Oracle version earlier than 12c, or
     *     you may be using a database where both sequences and identity columns are available
     *     (Oracle, Postgres, DB2), and a sequence is being used either by design or because
     *     the table was created before the database product supported identity columns. In
     *     this case, we cannot determine if the column should be a sequence or not. However,
     *     in many applications, the fact that the column is an integer and is a primary key
     *     would imply that it is also a sequence. Therefore, if the column is an integer and
     *     the server.properties flag auto.derive.integer.pk.always.sequence
     *     is true, we mark the field as type="sequence"
     * 
     *  - If, after all this, SmartClient ends up incorrectly marking a primary key field as
     *     a sequence (or vice versa), you can always override it on a per-field basis by
     *     simply redeclaring the field with the correct type in your .ds.xml
     *     file:
     *   &lt;DataSource serverType="sql" tableName="myTable" autoDeriveSchema="true"&gt;
     *    &lt;fields&gt;
     *     &lt;!-- This field was incorrectly marked as a sequence --&gt;
     *     &lt;field name="notASeq" type="integer" /&gt;
     *     &lt;!-- This field was incorrectly marked as an integer when it should be a sequence --&gt;
     *     &lt;field name="isASeq" type="sequence" /&gt;
     *    &lt;/fields&gt;
     *   &lt;/DataSource&gt;
     * 
     * 
     *   If the metadata source is Hibernate mappings described in a .hbm.xml file:
     * 
     * 
     *  - The first field we encounter that is described in the mapping with an &lt;id&gt; tag
     *     is marked as a primaryKey
     * 
     *  - If that field is marked as being generated, we set its type to "sequence"
     * 
     * 
     *   If the metadata source is an annotated object (whether JPA, Hibernate or just an
     *   annotated POJO):
     * 
     * 
     *  - Any field with an @Id annotation is is marked as a primaryKey (this
     *     differs from the Hibernate .hbm.xml file case because that is specific
     *     to Hibernate, which does support composite keys, but not by specifying multiple
     *     &lt;id&gt; tags. Annotations are supported, via annotated POJOs, for any kind of
     *     persistence strategy, so multiple @Id fields are perfectly valid)
     * 
     *  - Any field with a @GeneratedValue annotation is either marked as
     *     type="sequence" (if it is an integer type) or as
     *     DataSourceField.autoGenerated="true" (for other
     *     field types)
     * 
     *   Finally, if the metadata is a plain, unannotated Java object, no attempt is made to
     *   derive primary key fields.
     *   enums and valueMaps
     *   When we come across Java Enum properties in plain or annotated classes,
     *   as well as setting the field type as noted in the above tables, we also generate a
     *   valueMap for the field, based on the Enum members.
     * 
     *   For cases where we generate a field of SmartClient type "enum" (see the above tables),
     *   the keys of the valueMap are the result of calling name() on each member
     *   of the underlying Java Enum (in other words, its value exactly as declared in its
     *   enum declaration). For cases where we generate a field of SmartClient type "intEnum",
     *   the keys of the valueMap are strings representing the ordinal number of each member
     *   in the Java Enum - "0", "1", etc. Note that this behavior will be overriden by
     *   DataSource.enumTranslateStrategy if both are set.
     * 
     *   In both of these case, the display values generated for the valueMap are the result
     *   of calling toString() on each Enum member. If that gives the same
     *   value as calling name(), the value is passed through
     *   DataTools.deriveTitleFromName(), which applies the same processing rules
     *   as DataSource.getAutoTitle to derive a more user-friendly display value.
     *   Further notes
     *   schemaBean implies autoDeriveSchema, because it has no other
     *   purpose than to name the bean to use for auto-derived schema. Thus, if you specify
     *   schemaBean you do not need to specify autoDeriveSchema as well
     *   (though it does no harm to do so). However, tableName and
     *   beanClassName can be validly specified without implying
     *   autoDeriveSchema, so in those cases you must explicitly specify
     *   autoDeriveSchema.
     * 
     *   The underlying super-DataSource is cached in server memory, so that it does
     *   not have to be derived and created each time you need it. However, the cache manager
     *   will automatically refresh the cached copy if it detects that the deriving DataSource
     *   has changed. Thus, if you change the metadata your DataSource is deriving (if, for
     *   example, you add a column to a table), all you need to do is touch the
     *   .ds.xml file (ie, update its last changed timestamp - you don't actually
     *   have to change it) and the cached copy will be refreshed next time it is needed.
     * 
     *   When autoDeriveSchema is set, SQLDataSource will automatically discover foreignKeys and
     *   deliver table and column name information to the client in hashed form so that two
     *   DataSources that are linked by native SQL foreign keys will automatically discover each
     *   other if loaded into the same application, and set
     *   DataSourceField.foreignKey automatically. Because the table and column
     *   names are delivered as cryptohashes, there is no information leakage, but regardless,
     *   the feature can be disabled via setting datasource.autoLinkFKs to false in
     *   server_properties. This hashed linkage information is
     *   delivered to the client in properties DataSource.tableCode and
     *   DataSourceField.fkTableCode/DataSourceField.fkColumnCode
     *  @type {boolean}
     *  @default null
     */
    open var autoDeriveSchema: Boolean = definedExternally
    /**
     *  For DataSources that specify DataSource.autoDeriveSchema, this property indicates the name
     *   of the Spring bean, Hibernate mapping or fully-qualified Java class to use as parent
     *   schema.
     *  @type {string}
     *  @default null
     */
    open var schemaBean: String = definedExternally
    /**
     *  For JPA and Hibernate DataSources this property indicates, that data source has composite primary key and
     *   specifies fully-qualified Java class:
     * 
     *  - with @EmbeddedId you have to specify class name of declared id
     * 
     *  - with @IdClass you have to specify class specified in annotation declaration
     *  @type {string}
     *  @default null
     */
    open var idClassName: String = definedExternally
    /**
     *  When using the patternOperators OperatorId,
     *   character that matches any single character.
     * 
     *   Pass multiple strings to provide multiple alternative wildcards.
     *  @type {string | Array<Partial<string>>}
     *  @default "["?","%"]"
     */
    open var patternSingleWildcard: dynamic = definedExternally
    /**
     *  When using the patternOperators OperatorId,
     *   character that matches a series of one or more characters.
     * 
     *   Pass multiple strings to provide multiple alternative wildcards.
     *  @type {string | Array<Partial<string>>}
     *  @default "\*"
     */
    open var patternMultiWildcard: dynamic = definedExternally
    /**
     *  When using the patternOperators OperatorId,
     *   character that escapes the DataSource.patternSingleWildcard or DataSource.patternMultiWildcard if placed before
     *   it, so that it is treated as a literal character.
     *  @type {string}
     *  @default "\"
     */
    open var patternEscapeChar: String = definedExternally
    /**
     *  OperatorId like "matchesPattern" use patterns like
     *   "foo\*txt" to match text values. The patterns are similar to the patterns you use to
     *   match names of files in a command-line interface, or to the pattern allowed for the SQL
     *   "LIKE" operator.
     * 
     *   translatePatternOperators controls whether these pattern operators should
     *   be translated to a nested series of "startsWith"/"endsWidth"/"contains" operators before
     *   being sent to the server. This allows a server that only implements simple operators
     *   like "startsWith" to support pattern operators such as "matchesPattern" and
     *   "containsPattern", but with caveats:
     * 
     * 
     *  - single-character wildcards are not supported
     * 
     *  - multiple wildcards are not truly order-dependent, for example \*1\*2\*3\* will
     *         match 1,2,3 as interior characters in any order.
     * 
     *  - may be less efficient than a direct server-side implementation that is able to
     *         translate the pattern directly to the underlying storage engine.
     * 
     * 
     *   Note that since "containsPattern" is essentially equivalent to "matchesPattern" but with
     *   "\*" wildcards at the beginning and end of every pattern, the second limitation (pattern
     *   not really order dependent) may be fairly obvious to users when using this feature. For
     *   example, "m\*t" will match "we meet" and "we teem".
     * 
     *   The following are examples of how patterns are translated to simpler operators. Note
     *   that the case sensitive version of the operator is referred to below, but of course
     *   "iMatchesPattern" and "iContainsPattern" will be translated to case-insensitive versions
     *   of these operators, such as "iStartsWith".
     * 
     *   \*foo (endsWith)
     *   foo\* (startsWith)
     *   \*foo\* (contains)
     *   \*foo\*bar (contains and endsWith)
     *   foo\*bar\* (startsWith and contains)
     *   foo\*bar (startsWith and endsWith)
     *   \*foo\*bar\* (multiple contains)
     * 
     *   Also supported: one startsWith, multiple contains, one endsWith.
     *  @type {boolean}
     *  @default false
     */
    open var translatePatternOperators: Boolean = definedExternally
    /**
     *  Sets the XML namespace prefixes available for XPaths on a DataSource-wide basied. See
     *   OperationBinding.xmlNamespaces for details.
     *  @type {object}
     *  @default "See below"
     */
    open var xmlNamespaces: dynamic = definedExternally
    /**
     *  For an XML DataSource, URN of the WebService to use to invoke operations. This URN
     *   comes from the "targetNamespace" attribute of the &lt;wsdl:definitions&gt; element in a
     *   WSDL (Web Service Description Language) document, and serves as the unique identifier of
     *   the service.
     * 
     *   Having loaded a WebService using XMLTools.loadWSDL, setting
     *   serviceNamespace combined with specifying
     *   OperationBinding
     *   that set OperationBinding.wsOperation will cause a DataSource to invoke web
     *   service operations to fulfill DataSource requests (DSRequest).
     * 
     *   Setting serviceNamespace also defaults
     *   DataSource.dataURL to the service's location,
     *   DataSource.dataFormat to "xml" and
     *   OperationBinding.dataProtocol to "soap".
     *  @type {string}
     *  @default null
     */
    open var serviceNamespace: String = definedExternally
    /**
     *  For a DataSource derived from WSDL or XML schema, the XML namespace this schema belongs
     *   to. This is a read-only attribute automatically present on DataSources returned from
     *   SchemaSet.getSchema and WebService.getSchema.
     *  @type {string}
     *  @default null
     */
    open var schemaNamespace: String = definedExternally
    /**
     *  See OperationBinding.recordXPath. recordXPath can be specified
     *   directly on the DataSource for a simple read-only DataSource only capable of "fetch"
     *   operations.
     *  @type {XPathExpression}
     *  @default null
     */
    open var recordXPath: String = definedExternally
    /**
     *  Default URL to contact to fulfill all DSRequests. Can also be set on a
     *   per-operationType basis via OperationBinding.dataURL.
     * 
     *   NOTE: Best practice is to use the same dataURL for all DataSources which
     *   fulfill DSRequests via the server-side RPCManager API. Otherwise, cross-DataSource
     *   RPCManager.startQueue will not be possible.
     *  @type {URL}
     *  @default null
     */
    open var dataURL: String = definedExternally
    /**
     *  Tag name to use when serializing to XML. If unspecified, the dataSource.ID
     *   will be used.
     *  @type {string}
     *  @default null
     */
    open var tagName: String = definedExternally
    /**
     *  Whether we store server responses for this DataSource into
     *   Offline, and then use those stored responses
     *   at a later time if we are offline (ie, the application cannot connect to the server).
     *   Note that by default we do NOT use offline storage for a dataSource.
     *  @type {boolean}
     *  @default null
     */
    open var useOfflineStorage: Boolean = definedExternally
    /**
     *  A clientOnly DataSource simulates the behavior of a remote data store by manipulating a
     *   static dataset in memory as DSRequest are executed on it. Any changes
     *   are lost when the user reloads the page or navigates away.
     * 
     *   A clientOnly DataSource will return responses asynchronously, just as a DataSource
     *   accessing remote data does. This allows a clientOnly DataSource to be used as a
     *   temporary placeholder while a real DataSource is being implemented - if a clientOnly
     *   DataSource is replaced by a DataSource that accesses a remote data store, UI code for
     *   components that used the clientOnly DataSource will not need be changed.
     * 
     *   A clientOnly DataSource can also be used as a shared cache of modifiable data across
     *   multiple UI components when immediate saving is not desirable. In this case, several
     *   components may interact with a clientOnly DataSource and get the benefit of
     *   ResultSet behaviors such as automatic cache sync and in-browser data filtering
     *   and sorting. When it's finally time to save, DataSource.cacheData can be
     *   inspected for changes and data can be saved to the original DataSource via
     *   DataSource.addData, DataSource.updateData and DataSource.removeData, possibly in a
     *   RPCManager.startQueue. Note that
     *   DataSource.getClientOnlyDataSource lets you easily obtain a
     *   clientOnly DataSource representing a subset of the data available from a
     *   normal DataSource.
     * 
     *   See also DataSource.cacheAllData - a cacheAllData behaves like a write-through
     *   cache, performing fetch and filter operations locally while still performing remote save
     *   operations immediately.
     * 
     *   ClientOnly DataSources can be populated programmatically via DataSource.cacheData - see
     *   clientOnlyDataSources for other ways to populate a
     *   client-only DataSource with data.
     *  @type {boolean}
     *  @default false
     */
    open var clientOnly: Boolean = definedExternally
    /**
     *  If set, causes this DataSource to use a read-only "mock" or "test" dataset, if specified, or if no test
     *   data is available, then to load data normally but then operate similarly to a DataSource.clientOnly
     *   DataSource, never writing changes back to the server.
     * 
     *   mockMode has no effect on MockDataSource or a DataSource.clientOnly DataSource.
     * 
     *   For other DataSources, a one-time fetch will be performed to retrieve sample data, similar to a
     *   DataSource.cacheAllData DataSource, except that changes will never be saved back to the server. Only a
     *   subset of data will be retrieved, based on DataSource.mockDataRows. DataSource.mockDataCriteria can optionally
     *   be set to retrieve specific data.
     * 
     *   Alternatively, mock data can be provided with DataSource.cacheData.
     * 
     *   DataSources can be loaded in mockMode via passing settings to DataSource.load, or
     *   if loaded with a screen or project, by passing settings to RPCManager.loadScreen or
     *   the server-side Project.load() API.
     *  @type {boolean}
     *  @default null
     */
    open var mockMode: Boolean = definedExternally
    /**
     *  When DataSource.mockMode is enabled, number of rows of data to retrieve via an initial "fetch" DSRequest, for
     *   use as sample data. Set to null to retrieve all available rows.
     *  @type {Integer}
     *  @default "75"
     */
    open var mockDataRows: Number = definedExternally
    /**
     *  When DataSource.mockMode is enabled, criteria to use in an initial "fetch" DSRequest to retrieve sample data.
     *  @type {Criteria}
     *  @default null
     */
    open var mockDataCriteria: dynamic = definedExternally
    /**
     *  Decides under what conditions the ResultSet cache should be dropped when the
     *   ResultSet.criteria changes.
     *  @type {CriteriaPolicy}
     *  @default "dropOnShortening"
     */
    open var criteriaPolicy: 
                             /**
                              *  Cache is dropped whenever criteria changes.
                              *  Cache is retained as long as the only changes to criteria               make the criteria more restrictive as determined by
                              *                 ResultSet.compareCriteria.
                              */
                             String /* dropOnChange |  dropOnShortening */ = definedExternally
    /**
     *  The default textMatchStyle to use for DSRequests that do not explicitly state
     *   a DSRequest.textMatchStyle.  Note, however, that DSRequests
     *   issued by ListGrids and other DataBoundComponent will
     *   generally have a setting for textMatchStyle on the component itself (see
     *   ListGrid.autoFetchTextMatchStyle, for example).
     *  @type {TextMatchStyle}
     *  @default "exact"
     */
    open var defaultTextMatchStyle: 
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
     *  For fields on this dataSource that specify
     *   DataSourceField.ignoreTextMatchStyle true, the prevailing
     *   textMatchStyle is ignored and SmartClient matches exact values. This property dictates
     *   whether that match is case-sensitive like the "exactCase" textMatchStyle, or
     *   case-insensitive like the "exact" textMatchStyle (the default). Please see the
     *   TextMatchStyle for a discussion of the nuances
     *   of case-sensitive matching.
     *  @type {boolean}
     *  @default false
     */
    open var ignoreTextMatchStyleCaseSensitive: Boolean = definedExternally
    /**
     *  Class for ResultTrees used by this datasource. If null, defaults to using
     *   ResultTree.
     * 
     *   This can be set to a custom subclass of ResultTree that, for example, hangs on to extra
     *   information necessary for integration with web services.
     *  @type {string}
     *  @default null
     */
    open var resultTreeClass: String = definedExternally
    /**
     *  Class for ResultSets used by this datasource. If null, defaults to using
     *   ResultSet.
     * 
     *   This can be set to a custom subclass of ResultSet that, for example, hangs onto to extra
     *   information necessary for integration with web services.
     *  @type {string}
     *  @default null
     */
    open var resultSetClass: String = definedExternally
    /**
     *  Whether to attempt validation on the client at all for this DataSource. If unset (the
     *   default), client-side validation is enabled.
     * 
     *   Disabling client-side validation entirely is a good way to test server-side validation.
     *  @type {boolean}
     *  @default null
     */
    open var useLocalValidators: Boolean = definedExternally
    /**
     *  The required message when a field that has been marked as
     *   DataSourceField.required is not filled in by the user.
     * 
     *   Note that DataSourceField.requiredMessage wins over this setting if both are set.
     *  @type {HTMLString}
     *  @default null
     */
    open var requiredMessage: String = definedExternally
    /**
     *  Whether RPCRequests sent by this DataSource should enable
     *   RPCRequest.showPrompt in order to block user interactions until the
     *   request completes.
     * 
     *   DataSource requests default to blocking UI interaction because, very often, if the user
     *   continues to interact with an application that is waiting for a server response, some
     *   kind of invalid or ambiguous situation can arise.
     * 
     *   Examples include pressing a "Save" button a second time before the first save completes,
     *   making further edits while edits are still being saved, or trying to initiate editing on
     *   a grid that hasn't loaded data.
     * 
     *   Defaulting to blocking the UI prevents these bad interactions, or alternatively, avoids
     *   the developer having to write repetitive code to block invalid interactions on every
     *   screen.
     * 
     *   If an operation should ever be non-blocking, methods that initiate DataSource requests
     *   (such as DataSource.fetchData) will generally have a
     *   requestProperties argument allowing showPrompt to be set to
     *   false for a specific request.
     *  @type {boolean}
     *  @default true
     */
    open var showPrompt: Boolean = definedExternally
    /**
     *  Sets the strategy this DataSource uses to translate Java enumerated types (objects of type
     *   enum) to and from Javascript.
     * 
     *   This property is only applicable if you are using the SmartClient server
     *  @type {EnumTranslateStrategy}
     *  @default null
     */
    open var enumTranslateStrategy: 
                                    /**
                                     *  Translates to/from a String matching the constant name. This is the default if not set.
                                     *  Translates to/from a String matching the enum.toString().
                                     *  Translates to/from an integer matching the ordinal number of the constant within
                                     *    the enumeration
                                     *  Translates to/from a Javascript object containing one property for each property defined
                                     *    within the enum. The constant itself and the ordinal number are included in the JS object.
                                     *    By default they are called "_constant" and "_ordinal", but this can be overridden with
                                     *    the DataSource.enumOrdinalProperty and DataSource.enumConstantProperty
                                     *    properties
                                     */
                                    String /* name |  string |  ordinal |  bean */ = definedExternally
    /**
     *  The name of the property this DataSource uses for constant name when translating
     *   Java enumerated types to and from Javascript, if the EnumTranslateStrategy is set
     *   to "bean". Defaults to "_constant" if not set.
     * 
     *   This property is only applicable if you are using the SmartClient server
     *  @type {string}
     *  @default null
     */
    open var enumConstantProperty: String = definedExternally
    /**
     *  The name of the property this DataSource uses for ordinal number when translating
     *   Java enumerated types to and from Javascript, if the EnumTranslateStrategy is set
     *   to "bean". Defaults to "_ordinal" if not set.
     * 
     *   This property is only applicable if you are using the SmartClient server
     *  @type {string}
     *  @default null
     */
    open var enumOrdinalProperty: String = definedExternally
    /**
     *  If set, titles are automatically derived from DataSourceField.name for any
     *   field that does not have a DataSourceField.title and is not marked
     *   DataSourceField.hidden:true, by calling the method DataSource.getAutoTitle.
     *  @type {boolean}
     *  @default true
     */
    open var autoDeriveTitles: Boolean = definedExternally
    /**
     *  When true, indicates that this DataSource supports multi-level sorting.
     *  @type {boolean}
     *  @default true
     */
    open var canMultiSort: Boolean = definedExternally
    /**
     *  When true, indicates that any updates for this DataSource include only those fields
     *   that have actually changed (and primaryKey fields); when false (the default), all
     *   field values are included in updates, whether they have changed or not
     *  @type {boolean}
     *  @default false
     */
    open var sparseUpdates: Boolean = definedExternally
    /**
     *  When true, indicates that fields in this DataSource will never be positively updated
     *   to the null value; they may arrive at null values by being omitted, but we will
     *   not send actual null values in update requests. When false (the default), null is
     *   not treated in any special way.
     * 
     *   Setting this value causes null-assigned fields to be replaced with the field's
     *   DataSourceField.nullReplacementValue, if one is declared.
     *   If no nullReplacementValue is declared for the field, the null assignment
     *   is replaced with the DataSource's DataSource.nullStringValue,
     *   DataSource.nullIntegerValue, DataSource.nullFloatValue
     *   or DataSource.nullDateValue, depending on the field type.
     * 
     *   For "add" operations, setting DataSource.omitNullDefaultsOnAdd causes
     *   null-valued fields to be removed from the request entirely, rather than replaced with
     *   default values as described above.
     *  @type {boolean}
     *  @default false
     */
    open var noNullUpdates: Boolean = definedExternally
    /**
     *  When true, and DataSource.noNullUpdates is also true, indicates that "add"
     *   requests on this DataSource will have null-valued fields removed from the request
     *   entirely before it is sent to the server, as opposed to the default behavior of
     *   replacing such null values with defaults.
     *  @type {boolean}
     *  @default false
     */
    open var omitNullDefaultsOnAdd: Boolean = definedExternally
    /**
     *  If DataSource.noNullUpdates is set, the value to use for any text field that has a null
     *   value assigned on an update operation, and does not specify an explicit
     *   DataSourceField.nullReplacementValue.
     *  @type {string}
     *  @default ""
     */
    open var nullStringValue: String = definedExternally
    /**
     *  If DataSource.noNullUpdates is set, the value to use for any integer field that has a null
     *   value assigned on an update operation, and does not specify an explicit
     *   DataSourceField.nullReplacementValue.
     *  @type {Integer}
     *  @default "0"
     */
    open var nullIntegerValue: Number = definedExternally
    /**
     *  If DataSource.noNullUpdates is set, the value to use for any float field that has a null
     *   value assigned on an update operation, and does not specify an explicit
     *   DataSourceField.nullReplacementValue.
     *  @type {Float}
     *  @default "0.0"
     */
    open var nullFloatValue: Number = definedExternally
    /**
     *  If DataSource.noNullUpdates is set, the value to use for any boolean field that has a null
     *   value assigned on an update operation, and does not specify an explicit
     *   DataSourceField.nullReplacementValue.
     *  @type {boolean}
     *  @default false
     */
    open var nullBooleanValue: Boolean = definedExternally
    /**
     *  If DataSource.noNullUpdates is set, the value to use for any date or time field that has a
     *   null value assigned on an update operation, and does not specify an explicit
     *   DataSourceField.nullReplacementValue.
     * 
     *   Unlike strings and numbers, there is no "natural" choice for a null replacement value
     *   for dates. The default value we have chosen is midnight on January 1st 1970, simply
     *   because this is "the epoch" - the value that is returned by calling "new Date(0)"
     *  @type {Date}
     *  @default "See below"
     */
    open var nullDateValue: Date = definedExternally
    /**
     *  Whether a user must be authenticated in order to access this DataSource. This establishes a
     *   default for the DataSource as a whole; individual DataSource.operationBindings within the
     *   DataSource may still override this setting by explicitly setting
     *   OperationBinding.requiresAuthentication.
     * 
     *   Whether the user is authenticated is determined by calling
     *   httpServletRequest.getRemoteUser(), hence works with both simple J2EE security
     *   (realms and form-based authentication) and JAAS (Java Authentication & Authorization
     *   Service).
     * 
     *   If you wish to use an authentication scheme that does not make use of the servlet API's
     *   standards, SmartClient Server also implements the setAuthenticated method
     *   on RPCManager. You can use this API to tell SmartClient that all the
     *   requests in the queue currently being processed are associated with an authenticated
     *   user; in this case, SmartClient will not attempt to authenticate the user via
     *   httpServletRequest.getRemoteUser()
     * 
     *   You can set the default value for this property via setting "authentication.defaultRequired"
     *   in server_properties. This allows you to, for example,
     *   cause all DataSources to require
     *   authentication for all operations by default.
     * 
     *   Note that setting this property does not automatically cause an authentication mechanism to
     *   appear - you still need to separately configure an authentication system. Likewise, setting
     *   requiresAuthentication="false" does not automatically allow users to bypass your authentication
     *   mechanism - you need to set up a URL that will accept DSRequests and process them similar to
     *   the default "IDACall" servlet, and which is not protected by the authentication system. See
     *   servletDetails for details on the IDACall servlet.
     *  @type {boolean}
     *  @default null
     */
    open var requiresAuthentication: Boolean = definedExternally
    /**
     *  Similar to OperationBinding.requiresRole, but controls access to the DataSource as a
     *   whole.
     *  @type {string}
     *  @default null
     */
    open var requiresRole: String = definedExternally
    /**
     *  Indicates that the specified VelocityExpression must evaluate to true for a user
     *   to access this DataSource.
     * 
     *   See also OperationBinding.requires.
     *  @type {VelocityExpression}
     *  @default null
     */
    open var requires: String = definedExternally
    /**
     *  Indicates that declarative security rules are waived for rows that were created by the
     *   current user. Practically, this means that when a security check fails, instead of a
     *   security exception being thrown, we alter the criteria to ensure that the request can
     *   only return or affect rows that were created by the current authenticated user. This
     *   allows you to create security regimes whereby users can see and edit data they created,
     *   but have access to other users' data forbidden or limited.
     * 
     *   In order for this to work, we require two things:
     * 
     *  - The DataSource must specify a field of type "creator" - this field type is described
     *     on FieldType
     * 
     *  - The authentication regime in use must include the idea of a "current user". The
     *     authentication provided by the Servlet API is an example of such a regime.
     * 
     *   This setting can be overridden at operationBinding and field level, allowing extremely
     *   fine-grained control.
     *  @type {boolean}
     *  @default null
     */
    open var creatorOverrides: Boolean = definedExternally
    /**
     *  Requires that the currently authenticated user match the contents of
     *   this field, for client-initiated requests (i.e., where
     *   DSRequest.isClientRequest() returns true on the server).
     * 
     *   When a new row is added by a client-initiated DSRequest, the
     *   ownerIdField will be automatically populated with the currently
     *   authenticated user (clobbering any value supplied by the client).
     *   Client-initiated attempts to update the ownerIdField will also be
     *   prevented.
     * 
     *   If you wish to set the ownerIdField to a different value via an "add"
     *   or "update" operation, you can do so in server-side DMI code (possibly
     *   consulting DSRequest.getClientSuppliedValues() to get the
     *   value that was clobbered).
     * 
     *   For client-initiated "fetch", "update" or "remove" operations, the
     *   server will modify client-supplied criteria so that only rows whose
     *   ownerIdField matches the currently authenticated user can be read,
     *   updated or deleted.
     * 
     *   The ownerIdField setting can be overridden at the
     *   OperationBinding.ownerIdField level.
     * 
     *   If ownerIdField is specified,
     *   DataSource.requiresAuthentication will
     *   default to true. If requiresAuthentication is
     *   explicitly set to false, then unauthenticated users will be
     *   able to see all records. To avoid this, you can use
     *   DataSource.guestUserId to specify a default user to
     *   apply when no one has authenticated.
     *  @type {string}
     *  @default null
     */
    open var ownerIdField: String = definedExternally
    /**
     *  Value to use for the DataSource.ownerIdField if no one
     *   has authenticated.
     * 
     *   This setting can be overridden at the operationBinding level.
     *  @type {string}
     *  @default null
     */
    open var guestUserId: String = definedExternally
    /**
     *  Setting a DataSource to be serverOnly="true" ensures that it will not be visible
     *   to the client. Any request through IDACall to this DataSource will return a failure response.
     *   Only requests which have been initiated on the server-side will be executed against this DataSource.
     *  @type {string}
     *  @default null
     */
    open var serverOnly: String = definedExternally
    /**
     *  If true, causes all operations on this DataSource to automatically start or join a
     *   transaction associated with the current HttpServletRequest. This means that multiple
     *   operations sent to the server in a RPCManager.startQueue will be
     *   committed in a single transaction.
     * 
     *   Note that this includes fetch operations - setting this property to true has the same
     *   effect as a transaction policy of ALL for just this DataSource's operations - see the
     *   server-side RPCManager.setTransactionPolicy() for details of the different
     *   TransactionPolicy settings.
     * 
     *   If this property is explicitly false, this causes all operations on this DataSource
     *   to be committed individually - the same as a transaction policy of NONE, just for this
     *   DataSource's operations.
     * 
     *   In either case, you can override the setting for individual operations - see
     *   OperationBinding.autoJoinTransactions.
     * 
     *   If this property if null or not defined, we fall back to the default setting for this
     *   type of DataSource. These are defined in server_properties
     *   as follows:
     * 
     * 
     *  - Hibernate: hibernate.autoJoinTransactions
     * 
     *  - JPA/JPA2: jpa.autoJoinTransactions
     * 
     *  - SQL: There is one setting per configured database connection (DataSource.dbName).
     *   For example, the setting for the default MySQL connection is
     *   sql.Mysql.autoJoinTransactions
     * 
     *   If the setting is not defined at the DataSource-type level, we use the system global
     *   default, which is defined in server.properties as
     *   autoJoinTransactions.
     * 
     *   At the dbName and global system levels, you can set the autoJoinTransactions attribute
     *   to a valid Transaction Policy, rather than a simple true or false (although these
     *   values work too - true is the same as ALL, false is the same as NONE). For valid
     *   TransactionPolicy values and their meanings, see the server-side Javadoc for
     *   RPCManager.setTransactionPolicy()
     * 
     *   Note that the configuration settings discussed here can be overridden for a particular
     *   queue of requests by setting the server-side RPCManager's transaction policy. Look in
     *   the server-side Javadoc for RPCManager.getTransactionPolicy().
     * 
     *   Transactions can also be initiated manually, separate from the
     *   RPCManager/HttpServletRequest lifecycle, useful for both multi-threaded web
     *   applications, and standalone applications that don't use a servlet container - see
     *   standaloneDataSourceUsage.
     * 
     *   NOTE: Setting this property to true does not cause a transactional persistence
     *   mechanism to automatically appear - you have to ensure that your DataSource supports
     *   transactions. The SmartClient built-in SQL, Hibernate and JPA DataSources support transactions,
     *   but note that they do so at the provider level. This means that you can combine
     *   updates to, say, an Oracle database and a MySQL database in the same queue, but they
     *   will be committed in two transactions - one per database. The SmartClient
     *   server will commit or rollback these two transactions as if they were one, so a
     *   failure in some Oracle update would cause all the updates to both databases to be
     *   rolled back. However, this is not a true atomic transaction; it is possible for one
     *   transaction to be committed whilst the other is not - in the case of hardware failure,
     *   for example.
     * 
     *   NOTE: Not all the supported SQL databases are supported for transactions. Databases
     *   supported in this release are:
     * 
     * 
     *  - DB2
     * 
     *  - HSQLDB
     * 
     *  - Firebird
     * 
     *  - Informix
     * 
     *  - Microsoft SQL Server
     * 
     *  - MySQL (you must use InnoDB tables; the default MyISAM storage engine does not
     *   support transactions)
     * 
     *  - Oracle
     * 
     *  - PostgreSQL
     * 
     *  @type {boolean}
     *  @default null
     */
    open var autoJoinTransactions: Boolean = definedExternally
    /**
     *  This flag is part of the Automatic Transactions feature; it is only applicable in
     *   Power Edition and above.
     * 
     *   If true, causes all transactional operations on this DataSource to use the current
     *   Spring-managed transaction, if one exists. If there is no current Spring transaction
     *   to use at the time of execution, a server-side Exception is thrown. Note, a
     *   "transactional operation" is one that would have joined the SmartClient shared
     *   transaction in the absence of Spring integration - see
     *   DataSource.autoJoinTransactions.
     * 
     *   This feature is primarily intended for situations where you have
     *   dmiOverview that make use of both Spring DAO operations and
     *   SmartClient DSRequest operations, and you would like all of them to share the same
     *   transaction. An example of the primary intended use case:
     *    &#x0040;Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED)
     *    public class WorldService {
     *  
     *     public DSResponse doSomeStuff(DSRequest dsReq, HttpServletRequest servletReq) 
     *     throws Exception 
     *     {
     *      ApplicationContext ac = (ApplicationContext)servletReq.getSession().getServletContext().getAttribute("applicationContext");
     *      WorldDao dao = (WorldDao)ac.getBean("worldDao");
     *      dao.insert(req.getValues());
     *      DSRequest other = new DSRequest("MyOtherDataSource", "add");
     *      // Set up the 'other' dsRequest with critiera, values, etc
     *      // ...
     *  
     *      // This dsRequest execution will use the same transaction that the DAO operation
     *      // above used; if it fails, the DAO operation will be rolled back
     *      other.execute();
     *  
     *      return new DSResponse();
     *     }
     *    }
     *   Note: if you want to rollback an integrated Spring-managed transaction, you can use
     *   any of the normal Spring methods for transaction rollback:
     * 
     *  - Programmatically mark the transaction for rollback with the
     *   setRollbackOnly() API
     * 
     *  - Throw a RuntimeException, or
     * 
     *  - Throw an ordinary checked Exception. but configure Spring to rollback
     *     on that Exception. This can be done in the @Transactional annotation:
     *     &#x0040;Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=MyRollbackException.class)
     * 
     *   Spring's exception-handling model is different from SmartClient's, so care must be
     *   taken to get the correct error processing. If a transactional DSRequest fails,
     *   SmartClient code will throw an ordinary checked Exception; but Spring will
     *   ignore that Exception. So you can either:
     * 
     *  - Wrap every DSRequest.execute() in a try/catch block. Catch
     *   Exception and throw a RuntimeException instead
     * 
     *  - Just use the "rollbackFor" annotation to make your transactional method rollback
     *   for all instances of Exception
     * 
     * 
     *   Note: Spring transaction integration is conceptually different from SmartClient's
     *   DataSource.autoJoinTransactions, because SmartClient
     *   transactions apply to a queue of DSRequests, whereas Spring transactions are scoped to
     *   a single method invocation. If you want to make a whole SmartClient queue share a
     *   single Spring-managed transaction, you can wrap the processing of an entire queue in a
     *   call to a transactional Spring method. See the Using Spring Transactions with
     *   SmartClient DMI section at the bottom of the
     *   springIntegration for more details.
     * 
     *   You can set useSpringTransaction as the default setting for all dataSources
     *   for a given database provider by adding the property
     *   {dbName}.useSpringTransaction to your server.properties file.
     *   For example, Mysql.useSpringTransaction: true or
     *   hibernate.useSpringTransaction: true. You can set it as the default for
     *   all providers with a server.properties setting like this:
     *   useSpringTransaction: true. When useSpringTransaction is
     *   the default, you can switch it off for a specific dataSource by explicitly setting the
     *   flag to false for that DataSource.
     * 
     *   Finally, this setting can be overridden at the operationBinding level - see
     *   OperationBinding.useSpringTransaction
     *   Configuration
     *   When using Spring transactions, SmartClient needs a way to lookup the JNDI connection
     *   being used by Spring, and this needs to be configured. First, register a bean like
     *   this in your applicationContext.xml file:
     *    &lt;bean id="dataSource" class="org.springframework.jndi.JndiObjectFactoryBean"&gt;
     *      &lt;!-- Set this to the JNDI name Spring is using --&gt;
     *      &lt;property name="jndiName" value="isomorphic/jdbc/defaultDatabase"/&gt;
     *    &lt;/bean&gt;
     * 
     *   and then add a line like this to your server.properties:
     *    # Set this property to match the "id" of the JndiObjectFactoryBean registered in Spring
     *    sql.spring.jdbcDataSourceBean: dataSource
     * 
     *  @type {boolean}
     *  @default null
     */
    open var useSpringTransaction: Boolean = definedExternally
    /**
     *  The paging strategy to use for this DataSource. If this property is not set, the
     *   default paging strategy, specified with the server_properties
     *   setting sql.defaultPaging, is used.
     * 
     *   This setting can be overridden with the OperationBinding.sqlPaging property.
     * 
     *   NOTE: Operations that involve a OperationBinding.customSQL
     *   clause ignore this property, because customSQL operations usually need to be treated
     *   as special cases. For these operations, the paging strategy comes from the
     *   server_properties setting
     *   sql.defaultCustomSQLPaging or
     *   sql.defaultCustomSQLProgressivePaging, depending on whether or not
     *   DataSource.progressiveLoading is in force. Note that these
     *   can always be overridden by a sqlPaging setting on the OperationBinding.
     *  @type {SQLPagingStrategy}
     *  @default null
     */
    open var sqlPaging: 
                        /**
                         *  Specify the paging directly in the SQL query we generate. The way this is done varies
                         *   considerably from database to database: with some it is a straightforward built-in
                         *   facility while others require arcane tricks or simply don't support the idea. This is
                         *   the most efficient method, where available. Note that this strategy is not supported
                         *   for operations that make use of a OperationBinding.customSQL clause,
                         *   because it depends upon being able to determine the size of the whole dataset without
                         *   actually retrieving the whole dataset. Ordinary operations do this by means of an
                         *   automatically-generated "row count query", but we cannot generate such a query for a
                         *   customSQL operation.
                         *  Implement the paging behavior by use of the absolute() method of the
                         *   JDBC ResultSet.
                         *  Implement the paging behavior by fetching the entire resultset from the database and
                         *   dropping any unnecessary rows on the server before returning the data to the client.
                         *   This approach is extremely inefficient, but also extremely straightforward; it is
                         *   intended as a fallback option, for situations where the more sophisticated approaches
                         *   cause problems (a JDBC driver that throws vague exceptions when absolute()
                         *   is called, for example)
                         *  No paging behavior: we always return the entire resultset to the client.
                         */
                        String /* sqlLimit |  jdbcScroll |  dropAtServer |  none */ = definedExternally
    /**
     *  If explicitly set true or left null, causes the server to use a "hint" in the SQL we
     *   generate for paged queries. If explicitly set false, forces off the use of hints. This
     *   property can be overridden per operationBinding - see
     *   OperationBinding.sqlUsePagingHint.
     * 
     *   Note this property is only applicable to DataSource.serverType DataSources,
     *   only when a DataSource.sqlPaging of "sqlLimit" is in force,
     *   and it only has an effect for those specific database products where we employ a native
     *   hint in the generated SQL in an attempt to improve performance.
     *  @type {boolean}
     *  @default null
     */
    open var sqlUsePagingHint: Boolean = definedExternally
    /**
     *  This property is only applicable to DataSource.serverType DataSources, and
     *   only for OperationBinding that express a
     *   OperationBinding.customSQL clause. In these circumstances, we
     *   generally switch off paging because we are unable to generate a "row count" query that
     *   tells the framework the size of the complete, unpaged resultset.
     * 
     *   The useSubselectForRowCount flag causes the framework to derive a rowcount
     *   query by simply wrapping the entire customSQL clause in a subselect, like so:
     *   &nbsp;&nbsp;&nbsp;&nbsp;SELECT COUNT(\*) FROM ({customSQL clause here})
     * 
     *   However, this is not guaranteed to give good results. Because the customSQL clause can
     *   contain anything that you can write in SQL, running it inside a subselect in order to
     *   count the rows might not work, might have unintended side-effects (if, for example, it
     *   is a stored procedure call that performs updates as part of its function), or it might
     *   just be a bad idea - for example, if the customSQL query is slow-running, you'll make
     *   it twice as slow with this flag, simply because you'll be running it twice. We
     *   recommend using this flag with care.
     * 
     *   NOTE: This setting can be overridden per-operation - see
     *   OperationBinding.useSubselectForRowCount. You can also set a global default for
     *   this setting, so you don't have to specify it in every dataSource - define
     *   useSubselectForRowCount as true in your
     *   server_properties file.
     *  @type {boolean}
     *  @default null
     */
    open var useSubselectForRowCount: Boolean = definedExternally
    /**
     *  Only applicable to the built-in SQL DataSource
     * 
     *   tableCode and the related properties DataSourceField.columnCode,
     *   DataSourceField.fkTableCode and DataSourceField.fkColumnCode are read-only
     *   attributes that are secure and unique cryptographic hashes of table and column names
     *   used by this DataSource.
     * 
     *   These properties are used automatically by client-side framework code to
     *   link dataSources together by DataSourceField.foreignKey when a
     *   foreignKey is not explicitly declared, but is found in the SQL schema via
     *   the DataSource.autoDeriveSchema feature.
     * 
     *   A secure hash is used rather than the actual SQL table or column name for security
     *   reasons - sending the actual SQL table or column name to the client could aid in
     *   attempted SQL injection attacks.
     * 
     *   This feature can be disabled system-wide via setting datasource.autoLinkFKs
     *   to false in server_properties.
     *  @type {string}
     *  @default null
     */
    open var tableCode: String = definedExternally
    /**
     *  If true, causes SmartClient Server to use the "progressive loading" pattern for
     *   fetches on this dataSource, as described in the Paging and total dataset length
     *   section of the ResultSet. Essentially, this means that
     *   we avoid issuing a row count query and instead advertise total rows as being slightly
     *   more than the number of rows we have already read (see DataSource.endGap). This
     *   allows users to load more of
     *   a dataset by scrolling past the end of the currently-loaded rows, but it prevents them
     *   from scrolling directly to the end of the dataset.
     * 
     *   Generally, progressive loading is appropriate when you have to deal with very large
     *   datasets. Note that by default, a dataSource will switch into progressive loading mode
     *   automatically when it detects that it is dealing with a dataset beyond a certain size -
     *   see DataSource.progressiveLoadingThreshold.
     * 
     *   This setting can be overridden for individual fetch operations with the
     *   OperationBinding.progressiveLoading property, and also at the level of the
     *   individual DSRequest.progressiveLoading. You can also specify
     *   progressiveLoading on
     *   DataBoundComponent.progressiveLoading and certain types of
     *   FormItem - SelectItem.progressiveLoading and
     *   ComboBoxItem.progressiveLoading.
     * 
     *   Currently, this property only applies to users of the built-in SQLDataSource, but you
     *   could use it in custom DataSource implementations to trigger the server behavior
     *   described in the ResultSet documentation linked to above.
     *  @type {boolean}
     *  @default null
     */
    open var progressiveLoading: Boolean = definedExternally
    /**
     *  Indicates the dataset size that will cause SmartClient Server to automatically
     *   switch into DataSource.progressiveLoading for this DataSource.
     *   To prevent automatic switching to progressive loading, set this property to -1.
     *  @type {Integer}
     *  @default "200000"
     */
    open var progressiveLoadingThreshold: Number = definedExternally
    /**
     *  If we are DataSource.progressiveLoading, indicates the number of
     *   extra records SmartClient Server will read beyond the end record requested by the client,
     *   in order to establish if there are more records to view. This property has no effect
     *   if we are not progressive-loading.
     * 
     *   This property can be tweaked in conjunction with DataSource.endGap to change behavior
     *   at the end of a dataset. For example, with the default values of lookAhead: 1
     *   and endGap: 20, we can end up with the viewport shrinking if we get a case
     *   where there really was only one more record (because the client was initially told there
     *   were 20 more). This is not a problem per se, but it may be surprising to the user.
     *   You could prevent this happening (at the cost of larger reads) by setting
     *   lookAhead to be endGap+1.
     *  @type {Integer}
     *  @default "1"
     */
    open var lookAhead: Number = definedExternally
    /**
     *  For DataSource.serverType DataSources, sets the
     *   default DataSourceField.sqlStorageStrategy to use for boolean fields
     *   where no sqlStorageStrategy has been declared on the field.
     * 
     *   Can also be set system-wide via the server_properties setting
     *   sql.defaultBooleanStorageStrategy, or for a particular database configuration by
     *   setting sql.dbName.defaultBooleanStorageStrategy (see
     *   adminConsole for more information on SQL configuration).
     * 
     *   Note that when this property is unset, the default DataSourceField.sqlStorageStrategy
     *   strategy is effectively "string".
     *  @type {string}
     *  @default null
     */
    open var defaultBooleanStorageStrategy: String = definedExternally
    /**
     *  If we are DataSource.progressiveLoading, indicates the number of
     *   extra records SmartClient Server will advertise as being available, if it detects that
     *   there are more records to view (see DataSource.lookAhead). This property has no
     *   effect if we are not progressive-loading.
     *  @type {Integer}
     *  @default "20"
     */
    open var endGap: Number = definedExternally
    /**
     *  Set this property to true to have a DataSource fetch all of its data client-side on the
     *   first fetch request. However, unlike a DataSource.clientOnly DataSource, this DataSource
     *   will still save changes normally, sending remote requests.
     * 
     *   You can manually set this attribute after initialization by calling
     *   DataSource.setCacheAllData; setting DataSource.autoCacheAllData:true causes a DataSource to
     *   automatically switch to cacheAllData:true when a fetch results in the
     *   entire dataset being brought client-side.
     * 
     *   To cause automatic cache updates, you can set DataSource.cacheMaxAge to a number of seconds
     *   and once data has been client-side for that length of time, the next fetch causes the
     *   cache to be dropped and a new cache retrieved.
     * 
     *   Note that multiple DataSource.operationBindings of type "fetch" which return distinct
     *   results will not work with cacheAllData: only one cache is created and is
     *   used for all fetch operations, regardless of whether DSRequest.operationId has
     *   been set. However, "fetch" operationBindings used as a
     *   OperationBinding.cacheSyncOperation will work normally, so long as they return
     *   all data fields that are returned by the default "fetch" operation, so that the cache
     *   can be updated.
     * 
     *   To specify which operationId to use for fetching all data, use
     *   DataSource.cacheAllOperationId.
     * 
     *   To use the cache only for requests that have the cacheAllOperationId,
     *   allowing any other operationId (or absence of an operationId) to contact the server as
     *   normal, set DataSource.cacheAcrossOperationIds.
     *  @type {boolean}
     *  @default null
     */
    open var cacheAllData: Boolean = definedExternally
    /**
     *  DSRequest.operationId to use for fetching data in case DataSource.cacheAllData is
     *   true. By default a standard fetch operation is used (with no operationId
     *   specified).
     *  @type {string}
     *  @default null
     */
    open var cacheAllOperationId: String = definedExternally
    /**
     *  When DataSource.cacheAllData mode is enabled and a
     *   DataSource.cacheAllOperationId has been set, this flag affects whether cached
     *   results are used for all "fetch" requests regardless of their
     *   DSRequest.operationId, or are used only for "fetch" requests that use the
     *   cacheAllOperationId, allowing other requests to go to server normally.
     * 
     *   Default of true means that the cacheAllOperationId will be
     *   used to fetch all rows, but the resulting cache will be used for all "fetch" operations
     *   regardless of the operationId specified on the request.
     * 
     *   Switching to "false" effectively creates caching just for one specific
     *   operationId - the cacheAllOperationId - while allowing all
     *   other requests to go to the server normally.
     *  @type {boolean}
     *  @default true
     */
    open var cacheAcrossOperationIds: Boolean = definedExternally
    /**
     *  The maximum time, in seconds, to maintain the client-side cache. If a fetch occurs after
     *   the cacheMaxAge has expired, the current cache will be dropped and another complete
     *   cache fetched.
     *  @type {number}
     *  @default "60"
     */
    open var cacheMaxAge: Number = definedExternally
    /**
     *  For a DataSource.cacheAllData or client-only DataSource, a set of records to use as a dataset,
     *   specified as an Array of JavaScript Objects representing records.
     * 
     *   See clientOnlyDataSources for ways to populate a
     *   client-only DataSource with cache data.
     * 
     *   Additionally, when a DataSource is loaded in DataSource.mockMode, cacheData,
     *   if provided, is used as the mock data.
     * 
     *   For any other DataSource, cacheData is dropped when loaded.
     *  @type {Array<Partial<Record>>}
     *  @default null
     */
    open var cacheData: Array<dynamic> = definedExternally
    /**
     *  For a client-only DataSource, a set of records to use as a dataset, specified as an
     *   Array of JavaScript Objects.
     * 
     *   See clientOnlyDataSources for ways to populate a
     *   client-only DataSource with test data.
     *  @deprecated \* In favor of DataSource.cacheData.
     *  @type {Array<Partial<Record>>}
     *  @default null
     */
    open var testData: Array<dynamic> = definedExternally
    /**
     *  Set this attribute if you need to send the dsRequest.parentNode to the server-side.
     *  @type {boolean}
     *  @default false
     */
    open var sendParentNode: Boolean = definedExternally
    /**
     *  When a DataSource is not DataSource.cacheAllData:true and a fetch results in the
     *   entire dataset being retrieved, this attribute being set to true causes the DataSource
     *   to automatically switch to cacheAllData:true and prevent further server-trips for fetch
     *   requests.
     * 
     *   DataSource.cacheAllData is automatically enabled in either of these conditions:
     * 
     * 
     *  -
     *     The request has no criteria and no startRow/endRow request properties. The latter can
     *     be accomplished by disabling paging with a DataBoundComponent.dataFetchMode
     *     setting of "basic" or "local" or by an explicit fetchData request with those request properties
     *     excluded.
     * 
     * 
     *  -
     *     The request has no criteria but has startRow/endRow specified and the response received has
     *     all data available (startRow:0 and endRow:totalRows).
     * 
     * 
     *  @type {boolean}
     *  @default false
     */
    open var autoCacheAllData: Boolean = definedExternally
    /**
     *  When set, causes a DataSource.clientOnly or DataSource.cacheAllData DataSource to
     *   create a second DataSource to perform it's one-time fetch. By default, this attribute
     *   will be considered true when clientOnly is true, cacheAllData is false or unset and
     *   a dataURL or testFileName is specified on the DataSource.
     *  @type {boolean}
     *  @default null
     */
    open var useTestDataFetch: Boolean = definedExternally
    /**
     *  Whether to convert relative date values to concrete date values before sending to the
     *   server. Default value is true, which means that the server does not need to understand
     *   how to filter using relative dates - it receives all date values as absolute dates.
     *  @type {boolean}
     *  @default true
     */
    open var autoConvertRelativeDates: Boolean = definedExternally
    /**
     *  Causes Tree.discoverTree to be called on dsResponse.data in order to automatically
     *   discover tree structures in the response data.
     * 
     *   If autoDiscoverTree is set, discoverTree() is called after the default dsResponse.data
     *   has been derived (OperationBinding.recordXPath and
     *   DataSourceField.valueXPath have been applied) and after
     *   DataSource.transformResponse has been called.
     * 
     *   If a DataSourceField is declared with
     *   DataSourceField.childrenProperty, discoverTree() will be invoked with
     *   DiscoverTreeSettings.newChildrenProperty set to the name of
     *   the field marked as the childrenField. Similarly, if the DataSource has a
     *   DataSource.titleField it will be used as the
     *   DiscoverTreeSettings.nameProperty.
     *  @type {boolean}
     *  @default false
     */
    open var autoDiscoverTree: Boolean = definedExternally
    /**
     *  Settings to use when discoverTree() is automatcially called because
     *   DataSource.autoDiscoverTree is set to true for this DataSource
     *  @type {DiscoverTreeSettings}
     *  @default null
     */
    open var discoverTreeSettings: DiscoverTreeSettings = definedExternally
    /**
     *  For DataSources using the sqlDataSource for
     *   persistence, whether to use ANSI-style joins (ie, joins implemented with JOIN directives
     *   in the table clause, as opposed to additional join expressions in the where clause).
     *   The default value of null has the same meaning as setting this flag to false.
     * 
     *   Note, outer joins (see DataSourceField.joinType) only work with certain
     *   database products if you choose not to use ANSI joins. Other than that, the join
     *   strategies are equivalent.
     * 
     *   If you wish to switch on ANSI-style joins for every DataSource, without the need to
     *   manually set this property on all of them, set
     *   server_properties flag
     *   sql.useAnsiJoins to true.
     *  @type {boolean}
     *  @default null
     */
    open var useAnsiJoins: Boolean = definedExternally
    /**
     *  For this dataSource, should the millisecond portion of time and datetime values be
     *   trimmed off before before being sent from client to server or vice versa. By default,
     *   millisecond information is preserved (ie, it is not trimmed). You only need to consider
     *   trimming millisecond values if their presence causes a problem - for example, a custom
     *   server that is not expecting that extra information and so fails parsing.
     * 
     *   Note that there is no inherent support for millisecond precision in SmartClient widgets;
     *   if you need millisecond-precise visibility and editability of values in your client,
     *   you must write custom formatters and editors (or sponsor the addition of such things to
     *   the framework). Server-side, millisecond-precise values are delivered to and obtained
     *   from DataSources, so DataSource implementations that are capable of persisting and
     *   reading millisecond values should work transparently. Of the built-in DataSource types,
     *   the JPA and Hibernate DataSources will transparently handle millisecond-precise values
     *   as long as the underlying database supports millisecond precision, and the underlying
     *   column is of an appropriate type. The SQLDataSource provides accuracy to the nearest
     *   second by default; you can switch on millisecond precision per-field with the
     *   DataSourceField.storeMilliseconds attribute.
     *  @type {boolean}
     *  @default null
     */
    open var trimMilliseconds: Boolean = definedExternally
    /**
     *  If set to "false", transformation of values for
     *   DataSourceField.multiple fields, normally controlled by
     *   DataSourceField.multipleStorage, is instead disabled for this entire DataSource.
     *  @type {boolean}
     *  @default null
     */
    open var transformMultipleFields: Boolean = definedExternally
    /**
     *  Enables saving of a log of changes to this DataSource in a second DataSource with the same
     *   fields, called the "audit DataSource". NOTE: this feature applies to Enterprise
     *   Edition only; for more information on edition-specific features, see
     *   http://smartclient.com/product.
     * 
     *   When auditing is enabled, every time a DSRequest modifies this DataSource, a Record is added
     *   to the audit DataSource that shows the record as it existed after the change was made (or
     *   for a "remove", the values of the record at the time of deletion). In addition, the audit
     *   DataSource has the following additional metadata fields:
     * 
     * 
     *  - DataSource.auditTypeFieldName: type of the change ("update", "add" or "remove")
     * 
     *  - DataSource.auditUserFieldName: username of the user that made the change. The username is
     *     determined in the same way that the
     *     OperationBinding.requiresRole subsystem determines the
     *     current user.
     * 
     *  - DataSource.auditTimeStampFieldName: a field of type "datetime" recording the timestamp of
     *     the change
     * 
     *  - DataSource.auditRevisionFieldName: a field of type "sequence" recording a simple
     *     increasing integer value
     * 
     * 
     *   If any of the field names above collide with field names of the DataSource being audited,
     *   an integer suffix will also be added, starting with 2 (for example, "audit_modifier2", then
     *   "audit_modifier3", etc).
     * 
     *   To omit a data field from the automatically generated audit DataSource, just set
     *   DataSourceField.audit to false.
     * 
     *   Note: audit DataSource feature works only with single row operations, i.e. operations with
     *   OperationBinding.allowMultiUpdate enabled are not supported.
     * 
     *   Note, audit can be disabled for a given DSRequest via server-side API DSRequest.setSkipAudit()
     *   or for specific opreation via OperationBinding.skipAudit setting.
     * 
     *   Auto-generated Audit DataSources
     * 
     *   The audit DataSource is normally automatically generated, and unless otherwise specified
     *   with DataSource.auditDataSourceID, the ID of the audit DataSource will be
     *   audit_[OriginalDSID].
     * 
     *   By default, the automatically generated audit DataSource will be of the same type as the
     *   DataSource being audited, however, if the DataSource being audited is not already a
     *   SQLDataSource, we recommend using DataSource.auditDSConstructor to use
     *   a SQLDataSource as the audit DataSource. This is because a SQLDataSource used an audit
     *   DataSource will automatically generate a SQL table for storing audit data the first time
     *   changes are made. JPA would require manual creation of a Java Bean, and Hibernate requires
     *   hbm2ddl.auto=update to be set,
     *   which is widely considered unsafe for production use.
     * 
     *   Automatically created audit DataSources can be loaded and queried just like other
     *   DataSources, using the DataSourceLoader, and using the server-side API
     *   DataSource.getAuditDataSource(). However, you must load the DataSource
     *   being audited before loading its automatically created audit DataSource.
     * 
     *   Note, that automatic SQL tables creation can be disabled. See
     *   DataSource.autoCreateAuditTable for details.
     * 
     *   Manually created Audit DataSources
     * 
     *   The audit DataSource can also be manually created. In this case, you can
     *   can either follow the naming conventions described above for the ID of the audit DataSource
     *   and the names of metadata fields, or use the linked properties to assign custom names. If
     *   you omit any data fields from the tracked DataSource in your audit DataSource, those fields
     *   will be ignored for auditing purposes, exactly as though DataSourceField.audit had
     *   been set to false for an automatically-generated audit DataSource.
     * 
     *   Also, note that in case of manually defined audit DataSource, if this DataSource
     *   is defined so it inherits the audited DataSource, all the audited DataSource's fields
     *   will be inherited, this including the primary keys. Since for the audit
     *   DataSource the primary key should be the revision field, in order to prevent the
     *   audit DataSource having two primary keys, the inherited DataSource's primary key
     *   will have to be declared in audit DataSource, but with the primaryKey attribute
     *   omitted (as well not being of type "sequence") in the audit DataSource.
     *  @type {boolean}
     *  @default false
     */
    open var audit: Boolean = definedExternally
    /**
     *  For DataSources with DataSource.audit, optionally specifies the ID of the audit
     *   DataSource. If this property is not specified, the ID of the audit DataSource will
     *   be audit_[OriginalDSID]
     *  @type {string}
     *  @default null
     */
    open var auditDataSourceID: String = definedExternally
    /**
     *  For DataSources with DataSource.audit, specifies the field name used to store
     *   the user who performed the operation. If empty string is specified as the field name, the
     *   audit DataSource will not store this field.
     *  @type {string}
     *  @default "audit_modifier"
     */
    open var auditUserFieldName: String = definedExternally
    /**
     *  For DataSources with DataSource.audit, specifies the field name used to store
     *   the timestamp when the operation was performed (in a field of type "datetime"). If empty
     *   string is specified as the field name, the audit DataSource will not store this field.
     *  @type {string}
     *  @default "audit_changeTime"
     */
    open var auditTimeStampFieldName: String = definedExternally
    /**
     *  For DataSources with DataSource.audit, specifies the field name used to store
     *   the revision number for the change (in a field of type "sequence"). If empty
     *   string is specified as the field name, the audit DataSource will not store this field.
     *  @type {string}
     *  @default "audit_revision"
     */
    open var auditRevisionFieldName: String = definedExternally
    /**
     *  For DataSources with DataSource.audit, specifies the field name used to store
     *   the DSOperationType (in a field of type "text"). If empty
     *   string is specified as the field name, the audit DataSource will not store this field.
     *  @type {string}
     *  @default "audit_operationType"
     */
    open var auditTypeFieldName: String = definedExternally
    /**
     *  For DataSources with DataSource.audit, optionally specifies the
     *   DataSource.serverConstructor for the automatically generated audit DataSource. The
     *   default is to use the same serverConstructor as the DataSource where
     *   audit="true" was declared.
     * 
     *   This property is primarily intended to allow the use of SQLDataSource
     *   (DataSource.serverType) as an audit DataSource for a DataSource that
     *   might be of another type. For example, you might have a DataSource that implements all CRUD
     *   operations via Java logic in dmiOverview methods, and so doesn't provide generic
     *   storage; by using SQLDataSource as the type of your audit DataSource, you don't need to
     *   implement your own scheme for storing and querying audit data, and the necessary audit
     *   tables will be automatically generated in the database.
     * 
     *   Similarly, even if you do use a reusable DataSource type such as the built-in JPADataSource,
     *   using SQLDataSource for audit DataSources means there's no need to write a JPA bean just to
     *   achieve storage of an audit trail.
     * 
     *   To simplify this intended usage, the string "sql" is allowed for
     *   auditDSConstructor as a means of specifying that the built-in SQLDataSource class
     *   should be used. For any other type, use the fully qualified Java classname, as is normal
     *   for serverConstructor.
     *  @type {string}
     *  @default null
     */
    open var auditDSConstructor: String = definedExternally
    /**
     *  Setting autoCreateAuditTable to true indicates that audit DataSource
     *   will automatically create SQL table when DataSource.audit is enabled.
     * 
     *   Note, that autoCreateAuditTable attribute takes effect only if framework setting
     *   audit.autoCreateTables in server.properties is set to false,
     *   which by default is set to true.
     *  @type {boolean}
     *  @default true
     */
    open var autoCreateAuditTable: Boolean = definedExternally
    /**
     *  User-visible name for this DataSource.
     * 
     *   For example, for the supplyItem DataSource, "Supply Item".
     * 
     *   If is unset, getAutoTitle() method will be used with dataSource.ID.
     *   value in order to derive a default value for the title.
     * 
     *   For example "employee" ID will be derived to "Employee", "team_member" ID will be
     *   derived to "Team Member".
     *  @type {string}
     *  @default "dataSource.ID"
     */
    open var title: String = definedExternally
    /**
     *  User-visible plural name for this DataSource.
     * 
     *   For example, for the supplyItem DataSource, "Supply Items".
     * 
     *   Defaults to dataSource.title + "s".
     *  @type {string}
     *  @default "dataSource.ID"
     */
    open var pluralTitle: String = definedExternally
    /**
     *  Best field to use for a user-visible title for an individual record from this dataSource.
     * 
     *   For example, for a DataSource of employees, a "full name" field would probably most clearly
     *   label an employee record.
     * 
     *   If not explicitly set, titleField looks for fields named "title", "label", "name", and "id"
     *   in that order. If a field exists with one of those names, it becomes the titleField. If not,
     *   then the first field is designated as the titleField.
     *  @type {string}
     *  @default "see below"
     */
    open var titleField: String = definedExternally
    /**
     *  Designates a field of FieldType:"image" as the field to use when rendering a
     *   record as an image, for example, in a TileGrid.
     * 
     *   For example, for a DataSource of employees, a "photo" field of type "image" should be
     *   designated as the iconField.
     * 
     *   If not explicitly set, iconField looks for fields named "picture", "thumbnail", "icon",
     *   "image" and "img", in that order, and will use any of these fields as the iconField if it
     *   exists and has type "image".
     * 
     *   To avoid any field being used as the iconField, set iconField to null.
     *  @type {string}
     *  @default "see below"
     */
    open var iconField: String = definedExternally
    /**
     *  Name of the field that has the second most pertinent piece of textual information in the
     *   record, for use when a DataBoundComponent needs to show a short summary of a record.
     * 
     *   For example, for a DataSource of employees, a "job title" field would probably be the second
     *   most pertinent text field aside from the employee's "full name".
     * 
     *   Unlike DataSource.titleField, infoField is not automatically determined in the absence of an
     *   explicit setting.
     *  @type {string}
     *  @default null
     */
    open var infoField: String = definedExternally
    /**
     *  Name of the field that has the most pertinent numeric, date, or enum value, for use when a
     *   DataBoundComponent needs to show a short summary of a record.
     * 
     *   For example, for a DataSource of employees, good choices might be the "salary" field, "hire
     *   date" or "status" (active, vacation, on leave, etc).
     * 
     *   Unlike DataSource.titleField, dataField is not automatically determined in the absence of an
     *   explicit setting.
     *  @type {string}
     *  @default null
     */
    open var dataField: String = definedExternally
    /**
     *  Name of the field that has a long description of the record, or has the primary text data
     *   value for a record that represents an email message, SMS, log or similar.
     * 
     *   For example, for a DataSource representing employees, a field containing the employee's
     *   "bio" might be a good choice, or for an email message, the message body.
     * 
     *   If descriptionField is unset, it defaults to any field named "description" or "desc" in the
     *   record, or the first long text field (greater than 255 characters) in the record, or null if
     *   no such field exists.
     *  @type {string}
     *  @default null
     */
    open var descriptionField: String = definedExternally
    /**
     *  fieldName for a field in the dataSource expected to contain an explicit array of child nodes.
     *   Enables loading a databound tree as a hierarchical data structure, rather than a flat list of
     *   nodes linked by foreignKey.
     *   Note this is an alternative to setting DataSourceField.childrenProperty directly on
     *   the childrenField object.
     *   By default the children field will be assumed to be DataSourceField.multiple,
     *   for XML databinding. This implies that child data should be delivered in the format:
     * 
     *     &lt;childrenFieldName&gt;
     *       &lt;item name="firstChild" ...&gt;
     *       &lt;item name="secondChild" ...&gt;
     *     &lt;/childrenFieldName&gt;
     * 
     *   However data may also be delivered as a direct list of childrenFieldName
     *   elements:
     * 
     *     &lt;childrenFieldName name="firstChild" ...&gt;
     *     &lt;childrenFieldName name="secondChild" ...&gt;
     * 
     *   If you want to return your data in this format, you will need to explicitly set
     *   multiple to false in the appropriate dataSource field definition.
     *  @type {string}
     *  @default null
     */
    open var childrenField: String = definedExternally
    /**
     *  This property allows you to write and use custom DataSource subclasses on the server, by
     *   specifying either
     * 
     *  - the fully-qualified name of the DataSource subclass that should be instantiated
     *   server-side for this dataSource, or
     * 
     *  - the token "spring:" followed by a valid Spring bean ID, if you wish to instantiate
     *   your custom dataSource object using Spring dependency injection. For example,
     *   "spring:MyDataSourceBean". See also serverInit for special
     *   concerns with framework initialization when using Spring. It is also particularly important
     *   that you read the discussion of caching and thread-safety linked to below, as there are
     *   special considerations in this area when using Spring.
     * 
     *  - the token "cdi:" followed by a valid CDI bean name, if you wish to instantiate
     *   your custom dataSource object using CDI dependency injection. For example,
     *   "cdi:MyDataSourceBean".
     * 
     * 
     *   One reason you might wish to do this would be to override the validate() method to provide
     *   some arbitrary custom validation (such as complex database lookups, validation embedded in
     *   legacy applications, etc). It is also possible - though obviously a more substantial task -
     *   to override the execute() method in your custom DataSource. This is one way of creating
     *   a completely customized DataSource implementation.
     * 
     *   Note: If you use this property, you are responsible for making sure that it refers to
     *   a valid server-side class that extends com.isomorphic.datasource.BasicDataSource,
     *   or to a Spring bean of the same description.
     *   If your implementation relies on methods or state only present in certain specialized
     *   subclasses of DataSource (for example, you want the normal behavior and features of a
     *   HibernateDataSource, but with a specialized validate() method), then you should extend the
     *   subclass rather than the base class.
     * 
     *   NOTE: Please take note of the points made in
     *   serverDataSourceImplementation of caching and thread-safety
     *   issues in server-side DataSources.
     *  @type {string}
     *  @default null
     */
    open var serverConstructor: String = definedExternally
    /**
     *  For dataSources of DataSource.serverType "sql", determines whether we qualify column
     *   names with table names in any SQL we generate. This property can be overridden on specific
     *   operationBindings.
     *  @type {boolean}
     *  @default true
     */
    open var qualifyColumnNames: Boolean = definedExternally
    /**
     *  If true, indicates that the SmartClient Server should automatically apply a
     *   ValidatorType of "hasRelatedRecord" to every field
     *   on this dataSource that has a DataSourceField.foreignKey defined.
     *  @type {boolean}
     *  @default null
     */
    open var validateRelatedRecords: Boolean = definedExternally
    /**
     *  This property has different meanings depending on the DataSource.serverType:
     * 
     *   For SQL DataSources (DataSources with serverType "sql")
     *   If set, results from the database will be used to create one instance of the indicated Java
     *   bean per database row. Otherwise a Map is used to represent each row retrieved from SQL.
     * 
     *   With this feature active, a DSResponse from this DataSource will contain a Collection of
     *   instances of the indicated beanClassName, available via DSResponse.getData().
     *   This creates a couple of possibilities:
     * 
     * 
     *   Add business logic for derived properties, such as computed formulas
     *   For example, declare a DataSourceField named "revenueProjection". By default this
     *   field will call getRevenueProjection() on your bean to retrieve the value to send to the
     *   client. Your implementation of getRevenueProjection() could apply some kind of formula to
     *   other values loaded from the database.
     *   Call business logic on retrieved beans via DMI
     *   By adding a dmiOverview method that calls DSRequest.execute() to retrieve a DSResponse,
     *   you have an opportunity to call business logic methods on the beans representing each
     *   row affected by the DSRequest. For example, notify a related BPEL process of changes to
     *   certain fields.
     * 
     * 
     *   By using beanClassName on a specific OperationBinding, you can:
     * 
     * 
     *  - Use a bean to represent your data only when it matters; for example, avoid the overhead
     *     of using a bean for "fetch" operations, but do use a bean for "update" operations so
     *     that you can execute relevant business logic after the update completes.
     * 
     *  - Skip the use of beans for complex reporting queries that produce results unrelated to
     *     your persistent object model. Set beanClassName to blank ("") on a specific
     *     operationBinding to override DataSource.beanClassName for that specific operation.
     * 
     *  - For SQL joins that produce additional data fields, use a special, operation-specific
     *     bean that represents a join of multiple entities and contains business logic specific
     *     to that joined dataset
     * 
     * 
     *   Note that beanClassName affects what numeric field types will be used for
     *   inbound DSRequest data. For fields with numeric types, the DSRequest.data
     *   in DSRequests will automatically be converted to the type of the target field, before the
     *   request is received in a DMI. For details, see dsRequestBeanTypes.
     * 
     *   Note that dmiOverview also has a built-in facility for populating a bean
     *   with the inbound DSRequest.data - just declare the bean as a method argument.
     * 
     *   For generic DataSources (DataSources with serverType "generic")
     *   visualBuilder sets this property when it creates a generic
     *   DataSource using the Javabean Wizard. It has no built-in server-side effects.
     * 
     *   For Hibernate DataSources (DataSources with serverType "hibernate")
     *   The name of the Java bean or POJO class that is mapped in Hibernate. This will typically
     *   be the fully-qualified class name - eg com.foo.MyClass - but it may be the
     *   simple class name - just MyClass - or it may be some other value. It all
     *   depends on how your classes have been mapped in Hibernate.
     * 
     *   The declared Java bean will affect how its properties will be mapped to built-in numeric
     *   types, see hibernateIntegration for details.
     * 
     *   Note: If you are intending to use Hibernate as a data-access layer only,
     *   you do not need to create Hibernate mappings or Java objects: SmartClient will generate
     *   everything it needs on the fly.
     * 
     *   For JPA DataSources (DataSources with serverType "jpa" or "jpa1")
     *   The fully qualified class name of the JPA annotated entity.
     * 
     *   NOTE for Hibernate and JPA users: When you use JPA, or use Hibernate as a full ORM
     *   system (ie, not just allowing SmartClient Server to drive Hibernate as a data access layer),
     *   the beans returned on the server-side are live. This means that if you make any
     *   changes to them, the ORM system will persist those changes. This is true even if the beans
     *   were created as part of a fetch operation.
     * 
     *   This causes a problem in the common case where you want to use a DMI or custom DataSource
     *   implementation to apply some post-processing to the beans fetched from the persistent
     *   store. If you change the values in the beans directly, those changes will be persisted.
     * 
     *   If you want to alter the data returned from a JPA or Hibernate persistent store as part of
     *   a fetch request just so you can alter what gets sent to the client, you can use the
     *   server-side DSResponse's getRecords() method. This will return
     *   your bean data in "record" format - ie, as a List of Maps. You can alter these records
     *   without affecting your persistent store, and then call setData() on the
     *   DSResponse), passing the altered list of records. See the server-side Javadocs
     *   for DSResponse for details of these two methods.
     *  @type {string}
     *  @default null
     */
    open var beanClassName: String = definedExternally
    /**
     *  Criteria that are implicitly applied to all fetches made through this DataSource. These
     *   criteria are never shown to or edited by the user and are cumulative with any other
     *   criteria provided on the DSRequest.
     * 
     *   For example, a DataSource might \*always\* implicitly limit its fetch results to records
     *   owned by the current user's department. Components and ResultSets requesting data
     *   from the DataSource can then apply further implicitCriteria of their own, separately
     *   from their regular, user-editable criteria.
     * 
     *   For instance, a grid bound to this dataSource might be further limited to
     *   implicitly show only the subset of records created by the current user. See
     *   DataBoundComponent.implicitCriteria and ResultSet.implicitCriteria for
     *   more on these localized options.
     *  @type {Criteria}
     *  @default null
     */
    open var implicitCriteria: dynamic = definedExternally
    /**
     *  Sets what level of JSON validation will apply for this DataSource.
     * 
     *   Note that the point of "partial" validation mode is that if the JSON ihat's delivered is
     *   correct, we'll still need to validate to get "date" and such in the correct time, but
     *   shouldn't need to for the rest.
     *  @type {SkipJSONValidation}
     *  @default "none"
     */
    open var skipJSONValidation: 
                                 /**
                                  *  Skip validation for all fields. In this mode, valueXPaths and           getFieldValue implementations are skipped.
                                  *  Skip validation for fields with boolean, numeric, or string-drived           types. Note that you must deliver all
                                  *             DataSourceField.multiple:true values as arrays.
                                  *  Always do validation.
                                  */
                                 String /* full |  partial |  none */ = definedExternally
    /**
     *  Namespaces definitions to add to the root element of outbound XML messages sent to a web
     *   service, as a mapping from namespace prefix to namespace URI.
     * 
     *   The default value is:
     * 
     *    globalNamespaces : {
     *     xsi: "http://www.w3.org/2001/XMLSchema-instance",
     *     xsd: "http://www.w3.org/2001/XMLSchema"
     *    },
     * 
     *   This default value allows the use of the xsi:type and xsi:nil attributes without further
     *   declarations.
     * 
     *   Note that some web services will only accept specific revisions of the XML Schema URI.
     *   If xsi-namespaced attributes seem to be ignored by an older webservice, try the URI
     *   "http://www.w3.org/1999/XMLSchema-instance" instead.
     *  @type {object}
     *  @default "..."
     */
    open var globalNamespaces: dynamic = definedExternally
    /**
     *  Very advanced: for servers that do not support paging, and must return large numbers of XML
     *   records in one HTTP response, SmartClient breaks up the processing of the response
     *   in order to avoid the "script running slowly" dialog appearing for an end user.
     * 
     *   If you have a relatively small number of records with a great deal of properties or
     *   subobjects on each record, and you have not set DataSource.dropExtraFields to eliminate unused
     *   data, and you see the "script running slowly" dialog, you may need to set this number
     *   lower.
     *  @type {Integer}
     *  @default "150"
     */
    open var resultBatchSize: Number = definedExternally
    /**
     *  The native field name used by this DataSource on the server to represent the
     *   fileName for fileSource operations. Any
     *   extensions to the fileName to indicate type or format (e.g. ".ds.xml") are stored in the
     *   DataSource.fileTypeField and DataSource.fileFormatField, if specified
     *   for this DataSource.
     * 
     *   If not specified for a DataSource, the fileNameField will be inferred
     *   on the server as follows:
     * 
     * 
     *   -->
     * 
     *  - If there is a field named "fileName", "name", or "title",
     *     then that field is used.
     * 
     *  - Otherwise, if there is a single primary key, and it has the type "text",
     *     then that field is used.
     * 
     *  - Otherwise, an error is logged
     * 
     *  @type {string}
     *  @default null
     */
    open var fileNameField: String = definedExternally
    /**
     *  The native field name used by this DataSource on the server to represent the
     *   fileType for fileSource.
     * 
     *   If the fileTypeField is not configured, then a field named "fileType"
     *   will be used, if it exists. Otherwise, the DataSource will not track
     *   fileTypes -- this may be acceptable if, for instance, you use a separate
     *   DataSource for each fileType.
     * 
     *   The fileType is specified according to the extension that would have been used in the
     *   filesystem -- for instance, the fileType for employees.ds.xml would be "ds".
     *  @type {string}
     *  @default null
     */
    open var fileTypeField: String = definedExternally
    /**
     *  The native field name used by this DataSource on the server to represent
     *   the fileFormat for fileSource.
     * 
     *   If the fileFormatField is not configured, then a field named
     *   "fileFormat" will be used, if it exists. Otherwise, the DataSource will not
     *   track fileFormats -- this may be acceptable if, for instance, the
     *   fileFormat is always the same.
     * 
     *   The fileFormat is specified according to the extension that would have been used in the
     *   filesystem -- for instance, the fileFormat for employees.ds.xml would be "xml".
     *  @type {string}
     *  @default null
     */
    open var fileFormatField: String = definedExternally
    /**
     *  The native field name used by this DataSource on the server to represent
     *   the fileContents for fileSource.
     * 
     *   If the fileContentsField is not configured, then a field named
     *   "fileContents" or "contents" will be used, if it exists. If not found, the longest text field which is not the
     *   DataSource.fileNameField, DataSource.fileTypeField or
     *   DataSource.fileFormatField will be used.
     * 
     *   Note that the only method which will actually return the fileContents
     *   is DataSource.getFile -- the other fileSource
     *   methods omit the fileContents for the sake of efficiency.
     *  @type {string}
     *  @default null
     */
    open var fileContentsField: String = definedExternally
    /**
     *  The native field name used by this DataSource on the server to represent
     *   fileLastModified for fileSource.
     * 
     *   If the fileLastModifiedField is not configured, then a field named
     *   "fileLastModified" will be used, if it exists.
     *   Otherwise, the server will look for a field with a "modifierTimestamp" type.
     *   If that is not found, the DataSource will not keep track of the last
     *   modified date.
     *  @type {string}
     *  @default null
     */
    open var fileLastModifiedField: String = definedExternally
    /**
     *  The native field name used by this DataSource on the server to represent
     *   fileVersion for fileSource.
     * 
     *   Automatic file versioning is configured by the presence of this property: if you want
     *   automatic versioning for a FileSource DataSource, it is sufficient to simply define a
     *   fileVersionField. When automatic versioning is on:
     * 
     *  - Calls to DataSource.saveFile will save a new version of the file, retaining previous
     *   versions up to the maximum configured by DataSource.maxFileVersions; when that
     *   maximum is reached, the oldest version is overwritten
     * 
     *  - The DataSource.getFile API always returns the most recent version
     * 
     *  - The DataSource.listFiles API only includes the most recent version of any file
     * 
     *  - You can view and retrieve earlier versions of a file with the
     *   DataSource.listFileVersions and DataSource.getFileVersion APIs. Note that retrieving a
     *   previous version of a file and then calling saveFile() goes through the
     *   normal process of saving a new version
     * 
     * 
     *   The fileVersion field is expected to be of type "datetime", and automatic
     *   versioning will not work otherwise. Note, to minimize the possibility of version
     *   timestamp collisions, we recommend that fileVersion fields specify
     *   DataSourceField.storeMilliseconds: true.
     * 
     *   If the fileVersionField is not configured, no automatic file versioning will be done.
     *  @type {string}
     *  @default null
     */
    open var fileVersionField: String = definedExternally
    /**
     *  If DataSource.fileVersionField is enabled for a FileSource
     *   DataSource, this property configures the maximum number of versions to retain.
     *  @type {Integer}
     *  @default "20"
     */
    open var maxFileVersions: Number = definedExternally
    /**
     *  For DataSources with type DSServerType, looks
     *   up the locations to use as DataSource.projectFileLocations from the project's configuration (i.e.
     *   project.properties, server_properties
     *   etc.).
     * 
     *   For instance, to look up the value of project.datasources and use it
     *   for projectFileLocations, use "datasources" as the
     *   projectFileKey.
     * 
     *   If you specify both projectFileKey and
     *   projectFileLocations, then both with be used, with the
     *   projectFileLocations applied last.
     *  @type {string}
     *  @default null
     */
    open var projectFileKey: String = definedExternally
    /**
     *  For DataSources with type DSServerType,
     *   specifies locations for the project files. In XML, each location is
     *   expressed with a &lt;location&gt; tag, e.g.:
     * 
     * 
     *     &lt;projectFileLocations&gt;
     *       &lt;location&gt;[WEBROOT]/shared/ds&lt;/location&gt;
     *       &lt;location&gt;ds://datasources&lt;/location&gt;
     *     &lt;/projectFileLocations&gt;
     * 
     * 
     *   Directories should be specified as absolute paths on the server. If you
     *   want to construct a webroot-relative path, then prefix the path with
     *   [WEBROOT] (unlike in
     *   server_properties, where you would use
     *   $webRoot as the prefix).
     * 
     *   To specify another DataSource to be used via
     *   fileSource, use ds://dsName
     *   (where "dsName" is the name of the other DataSource).
     * 
     *   A projectFile DataSource uses the standard
     *   fileSource field names: fileName,
     *   fileType, fileFormat,
     *   fileContents, fileSize and
     *   fileLastModified. When defining a projectFile
     *   DataSource, you can use DataSource.inheritsFrom with
     *   a value of "ProjectFile" to inherit definitions for these fields -- e.g.:
     * 
     * 
     *     &lt;DataSource ID="MyDataSources" type="projectFile" inheritsFrom="ProjectFile"&gt;
     *       &lt;projectFileLocations&gt;
     *         &lt;location&gt;[WEBROOT]/shared/ds&lt;/location&gt;
     *         &lt;location&gt;ds://datasources&lt;/location&gt;
     *       &lt;/projectFileLocations&gt;
     *     &lt;/DataSource&gt;
     * 
     * 
     *   For directory locations, the
     *   fileName is relative to the directory specified. Note that
     *   the fileName does not include any extension for type or
     *   format. For instance, for "employees.ds.xml", the fileName
     *   would be "employees", the fileType would be "ds" and the
     *   fileFormat would be "xml".
     * 
     *   A projectFile DataSource executes the various
     *   fileSource in the following manner.
     *   The general rule is that fileName, fileType,
     *   and fileFormat are treated as primary keys. If files with the
     *   same combination of those attributes exist in more than one of the
     *   configured locations, the locations are considered in reverse
     *   order, with priority given to the location listed last. When modifying
     *   an existing file, the last location which contains the file will be
     *   used. When creating a new file, the file will be created in the last
     *   configured location.
     * 
     * 
     *   DataSource.listFiles
     *   Returns a combined list of files from
     *     all configured locations. Note that listFiles does not
     *     recurse into subdirectories. If the same combination of
     *     fileName / fileType / fileFormat exists in more than
     *     one configured location, then the data for fileSize and
     *     fileLastModified will be taken from the last configured
     *     location which contains the file.
     * 
     *   DataSource.hasFile
     *   Indicates whether the file exists in any of the configured locations.
     * 
     *   DataSource.getFile
     *   Returns file data by searching the locations in reverse order.
     * 
     *   DataSource.saveFile
     *   If the file exists, it will be saved in the last location in which
     *     it exists. If it is a new file, it will be saved in the last
     *     configured location.
     * 
     *   DataSource.renameFile
     *   The file will be renamed in the last location in which it exists.
     *     Note that if the file exists in more than one location, the rename
     *     will not affect other locations. Thus, a subsequent listFiles
     *     operation will return the file from the other location (as well
     *     as the renamed file).
     * 
     *   DataSource.removeFile
     *   The file will be removed from the last location in which it exists.
     *     Note that if the file exists in more than one location, the removal
     *     will not affect other locations. Thus, a subsequent listFiles
     *     operation will return the file from the other location.
     * 
     * 
     * 
     *   For convenience, a projectFile DataSource also responds to the standard
     *   DataSource operations, in the following manner:
     * 
     * 
     *   add
     *   Executes a saveFile operation, either adding the file or updating
     *     an existing file.
     * 
     *   fetch
     *   Executes a listFiles operation. Note that the results will not
     *     include the fileContents. In order to obtain the
     *     fileContents, you must use a
     *     DataSource.getFile.
     * 
     *   update
     *   Executes a renameFile operation. Note that this will not update
     *     the fileContents -- for that, you need to use "add", or
     *     a DataSource.saveFile.
     * 
     *   remove
     *   Executes a removeFile operation.
     * 
     * 
     * 
     *   If you specify both DataSource.projectFileKey and
     *   projectFileLocations, then both with be used, with the
     *   projectFileLocations applied last.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var projectFileLocations: Array<dynamic> = definedExternally
    /**
     *  Before we start editing values in DataBoundComponents bound to this
     *   dataSource, should we perform a deep clone of the underlying values (a "deep clone" is
     *   one created by traversing the original values object recursively, cloning the contents
     *   of nested objects and arrays). If this flag is explicitly set to false, we perform a
     *   shallow clone of the underlying values before edit (a "shallow clone" is a copy created
     *   by simply copying the top-level attributes of an object). Note, this setting only
     *   affects deep-cloning of attributes that are bound to a field; for other, non-field
     *   values, see DataSource.deepCloneNonFieldValuesOnEdit.
     * 
     *   If this flag is not explicitly set, it defaults to the value of the same-named static
     *   property, DataSource.deepCloneOnEdit. This flag can also be overridden
     *   per-component and per-field - see DataBoundComponent.deepCloneOnEdit and
     *   DataSourceField.deepCloneOnEdit.
     * 
     *   Note, this flag only has an effect if you are editing a values object that contains nested
     *   objects or arrays, using Canvas.dataPaths. When editing "flat" data - the
     *   mainstream case - there is no difference between a deep clone and a shallow clone.
     *  @type {boolean}
     *  @default null
     */
    open var deepCloneOnEdit: Boolean = definedExternally
    /**
     *  When editing values in DataBoundComponents bound to this dataSource, should we
     *   perform a deep clone of values that are not associated with a field (ie, attributes on
     *   the record that do not map to a component field either directly by name, or by
     *   FormItem.dataPath). If this flag is not explicitly set, it defaults to
     *   the value of the same-named static property,
     *   DataSource.deepCloneNonFieldValuesOnEdit. This flag can also be
     *   overridden per-component - see DataBoundComponent.deepCloneNonFieldValuesOnEdit.
     * 
     *   Note, a "deep clone" is one created by traversing the original values object
     *   recursively, cloning the contents of nested objects and arrays; a "shallow clone" is a
     *   copy created by simply copying the top-level attributes of an object; if you have
     *   nested objects that are copied like this, the "copies" are actual references to the
     *   original objects.
     * 
     *   Like the other deepCloneOnEdit settings, this flag only has an effect if you are
     *   editing a values object that contains nested objects or arrays.
     *  @type {boolean}
     *  @default null
     */
    open var deepCloneNonFieldValuesOnEdit: Boolean = definedExternally
    /**
     *  Default scriptlet to be executed on the server for each operation. If OperationBinding.script is
     *   specified, it will be executed for the operation binding in question instead of running this scriptlet.
     * 
     *   Scriptlets are used similarly to DMIs configured via DataSource.serverObject or
     *   OperationBinding.serverObject -
     *   they can add business logic by modifying the DSRequest before it's executed, modifying the
     *   default DSResponse, or taking other, unrelated actions.
     * 
     *   For example:
     * 
     *    &lt;DataSource&gt;
     *      &lt;script language="groovy"&gt;
     *       ... Groovy code ...
     *      &lt;/script&gt;
     *     ... other DataSource properties
     *    &lt;/DataSource&gt;
     * 
     * 
     *   Scriptlets can be written in any language supported by the "JSR 223" standard, including Java
     *   itself. See the dmiOverview for rules on how to return data,
     *   add additional imports, and other settings.
     * 
     *   The following variables are available for DMI scriptlets:
     * 
     * 
     *  - requestContext: RequestContext (from com.isomorphic.servlet)
     * 
     *  - dataSource: the current DataSource (same as DSRequest.getDataSource())
     * 
     *  - dsRequest: the current DSRequest
     * 
     *  - criteria: shortcut to DSRequest.getCriteria() (a Map)
     * 
     *  - values: shortcut to DSRequest.getValues() (a Map)
     * 
     *  - oldValues: shortcut to DSRequest.getOldValues() (a Map)
     * 
     *  - sqlConnection: SQLDataSource only: the current SQLConnection object. If
     *   using DataSource.autoJoinTransactions are enabled, this
     *   SQLConnection is in the context of the current transaction.
     * 
     *  - rpcManager: the current RPCManager
     * 
     *  - applicationContext: the Spring ApplicationContext (when applicable)
     * 
     *  - beanFactory: the Spring BeanFactory (when applicable)
     * 
     * 
     *   Scriptlets also have access to a set of contextual variables related to the Servlets
     *   API, as follows:
     * 
     * 
     *  - servletRequest: the current ServletRequest
     * 
     *  - session: the current HttpSession
     * 
     *  - servletResponse: the current ServletResponse (advanced use only)
     * 
     *  - servletContext: the current ServletContext(advanced use only)
     * 
     *   As with DMI in general, be aware that if you write scriptlets that depend upon these variables,
     *   you preclude your DataSource from being used in the widest possible variety of
     *   circumstances. For example, adding a scriptlet that relies on the HttpSession
     *   prevents your DataSource from being used in a command-line process.
     * 
     *   Note that if a dataSource configuration has both a &lt;script&gt; block and
     *   a specified OperationBinding.serverObject for some operation, the
     *   script block will be executed, and the serverObject ignored.
     *  @type {string}
     *  @default null
     */
    open var script: String = definedExternally
    /**
     *  For Direct Method Invocation (DMI) binding, declares the ServerObject to use as the default
     *   target for all DataSource.operationBindings. Specifying this
     *   attribute in an XML DataSource stored on the server enables DMI for this DataSource.
     * 
     *   Note that if a dataSource configuration has both a OperationBinding.script block and
     *   a specified serverObject for some operation, the
     *   script block will be executed, and the serverObject ignored.
     *  @type {ServerObject}
     *  @default null
     */
    open var serverObject: ServerObject = definedExternally
    /**
     *  Optional array of OperationBindings, which provide instructions to the DataSource about how each
     *   DSOperation is to be performed.
     * 
     *   When using the SmartClient Server, OperationBindings are specified in your DataSource
     *   descriptor (.ds.xml file) and control server-side behavior such as what Java object to route
     *   DSRequest to (OperationBinding.serverObject) or customizations to SQL, JQL and HQL queries
     *   (OperationBinding.customSQL, OperationBinding.customJQL and OperationBinding.customHQL).
     *   See the ${isc.DocUtils.linkForExampleId('javaDataIntegration', 'Java Integration samples')}.
     * 
     *   For DataSources bound to WSDL-described web services using
     *   DataSource.serviceNamespace, OperationBindings are used to bind each DataSource
     *   OperationBinding.operationType to an
     *   OperationBinding.wsOperation of a WSDL-described
     *   WebService, so that a DataSource can both fetch and save data to a web
     *   service.
     * 
     *   For example, this code accomplishes part of the binding to the
     *   SalesForce partner web services
     * 
     * 
     *   isc.DataSource.create({
     *    serviceNamespace : "urn:partner.soap.sforce.com",
     *    operationBindings : [
     *      { operationType:"fetch", wsOperation:"query", recordName: "sObject" },
     *      { operationType:"update", wsOperation:"update", recordName: "SaveResult" },
     *      { operationType:"add", wsOperation:"create", recordName: "SaveResult" },
     *      { operationType:"remove", wsOperation:"delete", recordName: "DeleteResult" }
     *    ],
     *    ...
     *   });
     * 
     * 
     * 
     *   NOTE: additional code is required to handle authentication and other details, see the
     *   complete code in smartclientSDK/examples/databinding/SalesForce.
     * 
     *   For DataSources that contact non-WSDL-described XML or JSON services, OperationBindings can
     *   be used to separately configure the URL, HTTP method, input and output processing for each
     *   operationType. This makes it possible to fetch JSON data from one URL for the "fetch"
     *   operationType and save to a web service for the "update" operationType, while appearing as a
     *   single integrated DataSource to a DataBoundComponent such as an
     *   ListGrid.canEdit.
     * 
     *   If no operationBinding is defined for a given DataSource operation, all of the properties
     *   which are valid on the operationBinding are checked for on the DataSource itself.
     * 
     *   This also means that for a read-only DataSource, that is, a DataSource only capable of fetch
     *   operations, operationBindings need not be specified, and instead all operationBinding
     *   properties can be set on the DataSource itself. In the ${isc.DocUtils.linkForExampleId('rssFeed', 'RSS Feed')}
     *   sample, you can see an example of using OperationBinding properties directly on the
     *   DataSource in order to read an RSS feed.
     *  @type {Array<Partial<OperationBinding>>}
     *  @default null
     */
    open var operationBindings: Array<dynamic> = definedExternally
    /**
     *  If a DSRequest arrives from the client that requests
     *   serverSummaries, should it be allowed?
     * 
     *   Note this setting only affects dsRequests that come from the browser (or
     *   another client). This setting has no effect on server summaries declared in .ds.xml files or
     *   summaries configured in DSRequests created programmatically on the server side, which are
     *   always allowed.
     * 
     *   Default value of null means this DataSource will use the system-wide default, which is set via
     *   datasources.allowClientRequestedSummaries in
     *   server_properties, and defaults to allowing client-requested
     *   summaries.
     * 
     *   If client-requested summarization is allowed, but the server-side &lt;operationBinding&gt;
     *   provides specific summarization settings, the client-requested summarization is ignored.
     *  @type {boolean}
     *  @default null
     */
    open var allowClientRequestedSummaries: Boolean = definedExternally
    /**
     *  Provides a default value for OperationBinding.recordName.
     *  @type {string}
     *  @default null
     */
    open var recordName: String = definedExternally
    /**
     *  Controls when primary keys are required for "update" and "remove" server operations, when allowMultiUpdate
     *   has not been explicitly configured on either the OperationBinding.allowMultiUpdate or via the server-side API DSRequest.setAllowMultiUpdate().
     * 
     *   Default value of null means this DataSource will use the system-wide default, which is set via
     *   datasources.defaultMultiUpdatePolicy in
     *   server_properties, and defaults to not allowing multi updates for
     *   requests associated with an RPCManager, see MultiUpdatePolicy for details.
     *  @type {MultiUpdatePolicy}
     *  @default null
     */
    open var defaultMultiUpdatePolicy: 
                                       /**
                                        *  having a PK is never required, even for requests from a browser. Note: dangerous setting
                                        *   that allows end users to wipe out entire tables
                                        *  having a PK is required for requests that come from the client or are specifically marked
                                        *   via dsRequest.setClientRequest(true)
                                        *  having a PK is required for any request that is associated with an RPCManager, which
                                        *   includes clientRequests and server-created DSRequests where an RPCManager was explicitly provided
                                        *  having a PK is always required no matter what
                                        */
                                       String /* never |  clientRequest |  rpcManager |  always */ = definedExternally
    /**
     *  If the criteria applied to a fetch type operation contain fields that are not present
     *   in the dataSource, should they be ignored when performing filtering on the client.
     *   This property is useful for cases where you custom server logic makes use of criteria
     *   values to determine what set of records to return to the client, but the data
     *   does not actually have record values for these fields and as such the client-side filtering
     *   logic should ignore them.
     *  @type {boolean}
     *  @default true
     */
    open var dropUnknownCriteria: Boolean = definedExternally
    /**
     *  If set to true, both client and server-side advanced filtering used by SmartClient will follow
     *   SQL99 behavior for dealing with NULL values, which is often counter-intuitive to users.
     *   Specifically, when a field has NULL value, all of the following expressions are false:
     * 
     *    field == "someValue" (normally false)
     *    field != "someValue" (normally true)
     *    not (field == "someValue")  (normally true)
     *    not (field != "someValue")  (normally false)
     * 
     *   This property can be overridden per-query by specifying strictSQLFiltering
     *   directly as a property on the AdvancedCriteria.
     * 
     *   NOTE: On the server side, this property is only applicable if you are using the
     *   SQL DataSource; the other built-in types (Hibernate and JPA/JPA2) do not offer this mode.
     *  @type {boolean}
     *  @default false
     */
    open var strictSQLFiltering: Boolean = definedExternally
    /**
     *  By default, all DataSources are assumed to be capable of handling
     *   AdvancedCriteria on fetch or filter type operations. This property may be
     *   set to false to indicate that this dataSource does not support
     *   advancedCriteria. See DataSource.supportsAdvancedCriteria for further information on this.
     * 
     *   NOTE: If you specify this property in a DataSource descriptor
     *   (.ds.xml file), it is enforced on the server. This means that if you run
     *   a request containing AdvancedCriteria against a DataSource that advertises itself as
     *   allowAdvancedCriteria:false, it will be rejected.
     *  @type {boolean}
     *  @default null
     */
    open var allowAdvancedCriteria: Boolean = definedExternally
    /**
     *   Call this method to switch cacheAllData on or off after initialization. Passing a
     *   shouldCache value of false clears any existing client-side cache,
     *   cancels any outstanding requests for a full cache and issues any other pending requests
     *   normally.
     * 
     * 
     *  @param {boolean} New value for DataSource.cacheAllData
     */
    open fun setCacheAllData(shouldCache: Boolean): Unit = definedExternally
    /**
     *   Call this method to set the data in the client-side cache after initialization.
     * 
     *  @param {Array<Partial<Record>>} Array of records to apply as the client-side cache
     */
    open fun setCacheData(data: Array<dynamic>): Unit = definedExternally
    /**
     *   Call this method to set the data in the client-side test-data after initialization.
     * 
     *  @param {Array<Partial<Record>>} Array of records to apply as the client-side test-data
     *  @deprecated \* In favor of DataSource.setCacheData.
     */
    open fun setTestData(data: Array<dynamic>): Unit = definedExternally
    /**
     *   Invalidate the cache when DataSource.cacheAllData or DataSource.clientOnly are true.
     * 
     */
    open fun invalidateCache(): Unit = definedExternally
    /**
     *   Switch into clientOnly mode, taking the cache from the cacheAllData ResultSet if it
     *   exists.
     * 
     */
    open fun setClientOnly(): Unit = definedExternally
    /**
     *   When DataSource.cacheAllData is true, has all the data been retrieved to the client?
     * 
     */
    open fun hasAllData(): Boolean = definedExternally
    /**
     *   Takes all relative date values found anywhere within a Criteria / AdvancedCriteria object
     *   and converts them to concrete date values, returning the new criteria object.
     * 
     *  @param {Criteria} criteria to convert
     *  @param {string=} optional timezone offset. Defaults to the current timezone
     *  @param {Integer=} first day of the week (zero is Sunday). Defaults to                DateChooser.firstDayOfWeek
     *  @param {Date=} base value for relative conversion - defaults to now
     */
    open fun convertRelativeDates(criteria: dynamic, timezoneOffset: String?, firstDayOfWeek: Number?, baseDate: Date?): dynamic = definedExternally
    /**
     *   Causes any components using this DataSource to be notified of changes that have been made to
     *   the remote dataset accessed via this DataSource, as though the provided DSResponse had just
     *   successfully completed. This will cause cache managers such as ResultSet or
     *   ResultTree to automatically update their caches, and components using such cache
     *   managers to visually update to show modified data.
     * 
     *   This API should be used when you have found out about changes made by other users or by
     *   automatic processes. For example, using the SmartClient Messaging system to receive
     *   real-time updates via HTTP streaming, you may get updates that should affect a ListGrid
     *   which is using a ResultSet to view a portion of a large dataset.
     * 
     *   The provided DSResponse should have
     *   DSResponse.operationType "update", "add" or "remove" - there is no
     *   way for a "fetch" response to meaningfully update arbitrary caches. However, if you
     *   have a list of updated records (possibly retrieved via DataSource.fetchData) you can still call
     *   updateCaches()with DSResponses of type "update". Typically DataSource operations
     *   that manipulate data operate on a single record at a time, but if you explicitly set the
     *   response.data attribute to an array of records, framework code will handle this
     *   as it would multiple updates.
     * 
     *   Example usage: if you had a ListGrid bound to the supplyItem sample DataSource,
     *   and that ListGrid was showing a Record with itemId 23, and you wanted to update
     *   the unitCost field to a new value, you would use the following code:
     * 
     * 
     *    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// updatedRecord is the record we want to update
     *    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;var record = supplyItemDS.copyRecord(updatedRecord);
     *    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;record.unitCost = 500;
     *    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;var dsResponse = {
     *    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;data: [record],
     *    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;operationType: "update"
     *    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;};
     *    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;supplyItemDS.updateCaches(dsResponse);
     * 
     * 
     * 
     * 
     *   To cause all components that have cache managers to drop their caches, provide a
     *   DSResponse with DSResponse.invalidateCache set.
     * 
     *   As an alternative to calling updateCaches() directly, if updates to other
     *   DataSources occur as a result of server-side logic, you can use the server-side API
     *   DSResponse.addRelatedUpdate(DSResponse) (Pro Edition and above), which ultimately calls
     *   updateCaches() for you - see that method's documentation for details.
     * 
     *   NOTE:: if updateCaches is called for a
     *   DataSource.clientOnly DataSource, it will update
     *   DataSource.cacheData synchronously in addition to notifying all cache managers as
     *   normal.
     * 
     *   If a DataSource has DataSource.cacheAllData set and a full cache has been obtained, calling
     *   updateCaches will automatically update the cache.
     * 
     *   Note that the DSResponse provided to this method will not go through
     *   DataSource.transformResponse or other processing that would normally occur for a
     *   DSResponse resulting from a DSRequest sent by the application in this page.
     * 
     * 
     *  @param {DSResponse} the provided DSResponse must minimally have                 dataSource, operationType, and data set
     *  @param {DSRequest=} optional dsRequest. If not specified, a DSRequest will be                automatically created based on the DataSource and operationType of                 the DSResponse
     */
    open fun updateCaches(dsResponse: DSResponse, dsRequest: DSRequest?): Unit = definedExternally
    /**
     *   For a DataSource that describes a DOM structure, the list of legal child elements that can
     *   be contained by the element described by this DataSource.
     * 
     *   For a DataSource described by XML schema, this is the list of legal subelements of
     *   complexType (elements of simpleType become DataSourceFields with atomic type).
     * 
     *   Note that currently, if an XML schema file contains ordering constraints, DataSources
     *   derived from XML Schema do not capture these constraints.
     * 
     * 
     */
    open fun getLegalChildTags(): Unit = definedExternally
    /**
     *   Copies all DataSource field values of a Record (including a TreeNode) to a new
     *   Record, omitting component-specific metadata such as selected state from grids,
     *   or parent folders for TreeNodes.
     * 
     *  @param {Record} The record to be copied.
     */
    open fun copyRecord(record: Record): Record = definedExternally
    /**
     *   Copies all DataSource field values of an (Array) of Records (including a TreeNode)
     *   to a new array of Records, omitting component-specific metadata such as selected state
     *   from grids, or parent folders for TreeNodes. This method calls
     *   DataSource.copyRecord for each item in the array.
     * 
     *  @param {Array<Partial<Record>>} The array of Record objects to be copied.
     */
    open fun copyRecords(records: Array<dynamic>): Array<dynamic> = definedExternally
    /**
     *   Creates a shallow copy of the given DSRequest. The request's DSRequest.data,
     *   if any, is shallow copied in the cloned request.
     * 
     *   The DSRequest.callback property of the given request is not copied into
     *   the cloned request.
     * 
     *  @param {DSRequest} the DSRequest to clone.
     */
    open fun cloneDSRequest(dsRequest: DSRequest): DSRequest = definedExternally
    /**
     *   Creates a shallow copy of the given DSResponse. All properties that would affect
     *   the processing of the response are copied into the resulting DSResponse so that the cloned
     *   response could substitute for the original response. The response's DSResponse.data,
     *   if any, is shallow copied in the cloned response.
     * 
     *  @param {DSResponse} the DSResponse to clone.
     */
    open fun cloneDSResponse(dsResponse: DSResponse): DSResponse = definedExternally
    /**
     *   For a dataSource using clientDataIntegration,
     *   return the data that should be sent to the DataSource.dataURL.
     * 
     *   By default, HTTP requests sent to non-SmartClient servers do not include DSRequest
     *   metadata such as DSRequest.startRow, DSRequest.endRow,
     *   and DSRequest.oldValues. Only the core
     *   dataSourceOperations is sent, such as the criteria
     *   passed to ListGrid.fetchData or the updated values submitted by
     *   DynamicForm.saveData.
     * 
     *   transformRequest() allows you to transform dsRequest metadata into a
     *   format understood by your server and include it in the HTTP request, so that you can
     *   integrate DataSource features such as data paging with servers that support such
     *   features.
     * 
     *   How the data is actually sent to the URL is controlled by
     *   OperationBinding.dataProtocol. If using the "getParams" or
     *   "postParams" protocol, data is expected to be a JavaScript Object where each property
     *   will become a GET or POST'd parameter. If using dataProtocol:"soap" or "postXML", data
     *   will be serialized as an XML message by DataSource.xmlSerialize.
     * 
     *   As an example, if you have a dataURL that can return paged data given URL parameters
     *   "start" and "end", you could implement transformRequest like so:
     * 
     * 
     *    isc.DataSource.create({
     *     ... 
     *     transformRequest : function (dsRequest) {
     *       if (dsRequest.operationType == "fetch") {
     *         var params = {
     *          start : dsRequest.startRow,
     *          end : dsRequest.endRow
     *         };
     *         // combine paging parameters with criteria
     *         return isc.addProperties({}, dsRequest.data, params);
     *       }
     *     }
     *    });
     * 
     * 
     * 
     *   Other reasons to implement transformRequest():
     * 
     * 
     *  - transform a Criteria object into the custom query language of a web
     *     service
     * 
     *  - add a session id to requests that require authentication
     * 
     *  - detect colliding updates by sending both updated values and the values the user
     *     originally retrieved before editing began (available as DSRequest.oldValues)
     * 
     *   Special case: If the dataProtocol is "clientCustom"
     *   the SmartClient system will not attempt to send data to the server in any way. Instead
     *   transformRequest should be implemented such that it accesses or updates the underlying
     *   data-set and calls DataSource.processResponse when the operation is complete. This
     *   setting allows straightforward integration with non SmartClient comm mechanisms that
     *   directly send requests to the server (such as GWT-RPC), or handle data manipulation without
     *   sending HTTP at all (such as Google Gears).
     *   A transformRequest override may also be used to set the DSRequest.dataProtocol
     *   to clientCustom at runtime, giving developers a way to intercept normal handling for
     *   some particular request, and provide entirely custom handling written on the client.
     * 
     *   Note: The RestDataSource class overrides transformRequest() to handle xml-serializing
     *   the request (including meta data) into a standard format.
     * 
     * 
     *  @param {DSRequest} the DSRequest being processed
     */
    open fun transformRequest(dsRequest: DSRequest): dynamic = definedExternally
    /**
     *   Helper method to retrieve the updated data from a successful dataSource update or add
     *   operation.
     * 
     *  @param {DSRequest} Update request object passed to the server. Note that this request may have been modified by DataSource.transformRequest
     *  @param {DSResponse} Response returned by the server
     *  @param {boolean} If DSResponse.data is empty, should data be derived from the submitted request.
     */
    open fun getUpdatedData(dsRequest: DSRequest, dsResponse: DSResponse, useDataFromRequest: Boolean): dynamic = definedExternally
    /**
     *   Returns the appropriate OperationBinding.dataProtocol for a DSRequest
     * 
     *  @param {DSRequest} DataSource Request object
     */
    open fun getDataProtocol(dsRequest: DSRequest): 
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
     *   Process a dsResponse for a request initiated by a DataSource with
     *   OperationBinding.dataProtocol.
     *   requestId parameter should be dsRequest.requestId as found on the dsRequest
     *   passed to DataSource.transformRequest.
     * 
     *   You must provide a response for both error and non-error cases. For an error case, a
     *   sufficient response is:
     * 
     *   { status : -1 }
     * 
     * 
     *  @param {string} requestId attribute from the associated dataSource request object
     *  @param {DSResponse} Configuration for the dsResponse
     */
    open fun processResponse(requestId: String, dsResponse: DSResponse): Unit = definedExternally
    /**
     *   Get the XML to be posted to the dataURL based on the passed DSRequest.
     * 
     *   This API is intended to be overridden in order to integrate with web services that
     *   expect XML messages rather than simple HTTP parameters, but lack a
     *   WSDL description. For WSDL-described web services, having loaded the service
     *   description, SmartClient knows the correct XML message structure, so customization is
     *   best done by modifying the JavaScript data that is used to form the message.
     * 
     * 
     *  @param {DSRequest} the request to encode as an XML message.
     */
    open fun getXMLRequestBody(dsRequest: DSRequest): String = definedExternally
    /**
     *   Serialize a JavaScript object as XML.
     * 
     *   The JavaScript Object passed to DataSource.xmlSerialize becomes an XML
     *   element named after the DataSource.tagName (or DataSource.ID if
     *   tagName is unset). Each property of the object becomes a subElement. For example,
     *   using a DataSource to serialize like this:
     * 
     *     var inputObject = {
     *      startRow : 5,
     *      endRow : 50,
     *      data : [
     *        { field1 : "value1", field2: new Date() },
     *        { field1 : "value3", field2: null }
     *      ]
     *     };
     *     var myDS = isc.DataSource.create({ tagName:"DSRequest" });
     *     myDS.xmlSerialize(inputObject);
     * 
     *   .. produces the following XML:
     * 
     *     &lt;DSRequest&gt;
     *       &lt;startRow&gt;5&lt;/startRow&gt;
     *       &lt;endRow&gt;50&lt;/endRow&gt;
     *       &lt;data&gt;
     *         &lt;field1&gt;value1&lt;/field1&gt;
     *         &lt;field2&gt;2005-10-14T18:01:16&lt;/field2&gt;
     *       &lt;/data&gt;
     *       &lt;data&gt;
     *         &lt;field1&gt;value3&lt;/field1&gt;
     *         &lt;field2&gt;&lt;/field2&gt;
     *       &lt;/data&gt;
     *     &lt;/DSRequest&gt;
     * 
     * 
     *   Various properties on the DataSource and DataSourceField can affect how serialization is
     *   performed, see for example DataSource.tagName,
     *   DataSource.schemaNamespace,
     *   DataSourceField.xmlAttribute,
     *   DataSourceField.multiple and DataSourceField.childTagName.
     *   By setting the DataSourceField.type to the ID of another
     *   DataSource which has further XML serialization settings, you can control serialization of
     *   nested structures.
     * 
     *   If you are working with a WSDL-described web service, XML serialization is performed
     *   automatically by APIs like WebService.callOperation - you only need to
     *   know about serialization in order to understand how to put together JavaScript data that
     *   will fill in an XML message properly, and for simple messages, setting
     *   DSRequest.useFlatFields makes that unnecessary as well.
     * 
     *   Note: when trying to send data to a web service, it is best to avoid putting
     *   together any XML yourself, instead modify the JavaScript data being fed to SmartClient's
     *   SOAP engine. This is because the WSDL and SOAP rules for correctly namespacing and
     *   encoding Web Service messages are very complex and are subject to change with new
     *   versions of the web service you are contacting, whereas the data itself is easy to
     *   manipulate and less likely to change.
     * 
     *   To troubleshoot message formation, you can set the log category "xmlSerialize" to
     *   INFO or DEBUG level in order to see diagnostics about XML
     *   message formation, and you can use the RPC tab in the Developer Console to see the
     *   actual messages being passed to web services.
     * 
     * 
     *  @param {any} data to be serialized
     *  @param {SerializationContext} options for the serialization engine
     */
    open fun xmlSerialize(data: dynamic, flags: SerializationContext): String = definedExternally
    /**
     *   Transform a list of XML elements to DataSource records.
     * 
     *   recordsFromXML() will create a List of DataSource records in the form of
     *   JavaScript objects. The value for each field is extracted from the XML according to the
     *   rules described under DataSourceField.valueXPath.
     * 
     *   Derived JavaScript values for each field will be the appropriate JavaScript type, eg,
     *   for a field of "date" type, the JS value will be a JavaScript Date object.
     * 
     *   Note that if the set of nodes exceeds DataSource.resultBatchSize, this method
     *   will break the XML processing logic into multiple threads and therefore complete
     *   asynchronously. In this case the return value will be null, and the callback parameter
     *   must be used to process the extracted records.
     * 
     * 
     *  @param {Array<Partial<XMLElement>>} XML elements to transform, eg, the result of a                    call to XMLTools.selectNodes
     *  @param {Callback} Callback to fire when the transform completes. Takes a single  parameter records - the array of DataSource records derived from the   XML elements.
     */
    open fun recordsFromXML(elements: Array<dynamic>, callback: dynamic): List = definedExternally
    /**
     *   Modify the DSResponse object derived from the response returned from the
     *   DataSource.dataURL.
     * 
     *   This is an override point that makes it possible to use DataSource features such as
     *   paging with web services that support such features, by allowing you to fill in metadata
     *   fields in the DSResponse object (such as DSResponse.startRow) based on
     *   service-specific metadata fields contained in the service's response.
     * 
     *   The DSResponse passed to this method already has DSResponse.data, which is
     *   derived differently depending on the DataSource.dataFormat setting:
     * 
     * 
     *  - dataFormat:"xml" : either the
     *   OperationBinding.recordXPath or
     *   OperationBinding.recordName is used to select the XML elements
     *   that represent DataSource records. The selected XML elements are passed to
     *   DataSource.recordsFromXML, which transforms the XML elements to typed
     *   JavaScript data using the DataSource as a schema.
     * 
     *  - dataFormat:"json" : the
     *   OperationBinding.recordXPath, if specified, is used to select
     *   records from the returned JSON data via XMLTools.selectObjects.
     *   DataSourceField.valueXPath is used to derive correctly typed field values.
     * 
     *  - dataFormat:"custom" : dsResponse.data is the raw response
     *   in String form. It must be parsed into an Array of Objects for subsequent processing to
     *   work.
     * 
     * 
     *   In addition to dsResponse.data, DSResponse.status is defaulted
     *   to 0 (indicating no error), and DSResponse.startRow is assumed to be zero,
     *   with DSResponse.endRow and DSResponse.totalRows
     *   both set to dsResponse.data.length - 1, that is, the returned data is
     *   assumed to be all records that matched the filter criteria.
     * 
     *   Examples of using this API include:
     * 
     * 
     *  - setting DSResponse.startRow,
     *     DSResponse.endRow and DSResponse.totalRows
     *     to allow paging for a service that supports it. For example, if an XML service
     *     returns a "resultRow" tag that contained the row number of the first row of the
     *     returned results:
     * 
     *     dsResponse.startRow = isc.XMLTools.selectNumber(xmlData, "//resultRow");
     * 
     * 
     * 
     *  - setting DSResponse.status to recognized ISC error values based on
     *     service-specific errors, in order to trigger standard ISC error handling. For
     *     example, setting dsResponse.status to
     *     RPCResponse.STATUS_VALIDATION_ERROR and filling in
     *     DSResponse.errors in order to cause validation errors to be shown in
     *     forms and grids.
     * 
     *  - for services that either do not return cache update data, or return partial data,
     *     using DSRequest.oldValues to create cache update data (whether this is
     *     appropriate is application-specific), or setting
     *     DSResponse.invalidateCache.
     * 
     * 
     *   NOTE: this method is NOT an appropriate time to call
     *   methods on visual components such as grids, initiate new DSRequests or RPCRequests, or
     *   in general do anything other than fill in fields on the DSResponse based on data that is
     *   already available. Any actions that need to be taken as a result of the web
     *   service response should be implemented exactly as for a DataSource where
     *   transformResponse() has not been overridden, that is, use the callback
     *   passed to high-level methods such as
     *   dataBoundComponentMethods, and do error
     *   handling via either DataSource.handleError or by setting
     *   RPCRequest.willHandleError.
     * 
     * 
     *  @param {DSResponse} default DSResponse derived from the response data
     *  @param {DSRequest} DSRequest object that initiated this request
     *  @param {XMLDocument | JSON} XML document or JSON objects returned by the web                  service
     */
    open fun transformResponse(dsResponse: DSResponse, dsRequest: DSRequest, data: dynamic): DSResponse = definedExternally
    /**
     *   Fetch a single record from the DataSource by DataSourceField.primaryKey.
     *   This simply calls DataSource.fetchData after creating Criteria that contain the primary
     *   key field and value.
     * 
     *   If you call this method on a DataSource with a composite primary key - ie, one with
     *   multiple primaryKey fields - this method returns the first record where the first
     *   defined primary field matches the supplied pkValue; this may or may not be meaningful,
     *   depending on your use case. Generally, for DataSources with composite keys, it makes
     *   more sense to use fetchData() directly, rather than this convenience
     *   method.
     * 
     * 
     *  @param {any} value for the field marked           DataSourceField.primaryKey:true in this DataSource            (or the first field so marked if there is more than one)
     *  @param {DSCallback=} callback to invoke on completion
     *  @param {DSRequest=} additional properties to set on the                          DSRequest that will be issued
     */
    open fun fetchRecord(pkValue: dynamic, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Perform a "fetch" DataSource operation against this DataSource, sending search criteria
     *   and retrieving matching records.
     * 
     *   NOTE: do not attempt to override this method to create a custom DataSource. For
     *   a server-side custom DataSource, use the DataSource.serverConstructor attribute,
     *   and the ${isc.DocUtils.linkForExampleId('customDataSource', 'Custom DataSource samples')}. For a
     *   client-side custom DataSource, see DataSource.dataProtocol.
     * 
     *   In contrast to ListGrid.fetchData, which creates a ResultSet to manage
     *   the returned data, calling dataSource.fetchData() provides the returned
     *   data in the callback as a
     *   simple JavaScript Array of JavaScript Objects.
     *    Calling
     *   dataSource.fetchData() does not automatically update any visual components or
     *   caches: code in the callback passed to fetchData() decides what to do with
     *   the returned data.
     * 
     *   For example, given a ListGrid "myGrid" and a DataSource "employees", the following code
     *   would populate "myGrid" with data fetched from the DataSource:
     * 
     *    isc.DataSource.get("employees").fetchData(null, "myGrid.setData(data)");
     * 
     * 
     *   Unlike calling myGrid.fetchData(), which creates a ResultSet, the
     *   data provided to the grid is "disconnected" data, unmanaged by SmartClient's databinding
     *   facilities and safe to directly modify. This is useful when, for example, a ListGrid is
     *   being used as a more sophisticated version of HTML's multi-select component.
     * 
     *   Disconnected datasets may be used to populate various visual components. For example,
     *   while an individual FormItem can be configured to fetch
     *   FormItem.valueMap options from a DataSource via the
     *   FormItem.optionDataSource property, the following code shows
     *   storing a dataset to derive valueMaps from later:
     * 
     * 
     *    isc.DataSource.get("countries").fetchData(null, "window.countries = data");
     * 
     *    ... later, a form is created dynamically ...
     * 
     *    function showForm() {
     *      isc.DynamicForm.create({
     *        items : [
     *         { name:"country", title:"Pick Country",
     *          valueMap: window.countries.getValueMap("countryId", "countryName")
     *         },
     *      ...
     *    
     *    
     *   
     *   
     *   You can also create a ResultSet from the data retrieved from fetchData(),
     *   like so:
     *   
     *    
     *    isc.DataSource.get("countries").fetchData(null,
     *      function (dsResponse, data) {
     *        isc.ResultSet.create({
     *          dataSource:"countries",
     *          allRows:data
     *        })
     *      }
     *    )
     *    
     *    
     *   
     *   
     *   This gives you a dataset that supports client-side filtering (via
     *   ResultSet.setCriteria), can provide 
     *   ResultSet.getValueMap, will 
     *   ResultSet.disableCacheSync to the DataSource made via
     *   other components, and can be re-used with multiple visual components.
     *   
     *   See also DataSource.getClientOnlyDataSource and DataSource.cacheAllData for
     *   similar capabilities for dealing with smaller datasets entirely within the browser, or working
     *   with modifiable caches representing subsets of the data available from a DataSource.
     *   
     *   See also the server-side com.isomorphic.js.JSTranslater class in the
     *   ${isc.DocUtils.linkForDocNode('JavaServerReference', 'Java Server Reference')} for other, similar approaches
     *   involving dumping data into the page during initial page load. Note: care should
     *   be taken when using this approach. Large datasets degrade the basic performance of some
     *   browsers, so use PickList.optionDataSource and similar
     *   facilities to manage datasets that may become very large.
     *   
     *   Data-Driven Visual Component Creation
     *   
     *   
     *   DataSource.fetchData() can also be used to create SmartClient components in
     *   a data-driven way. Many properties on SmartClient visual components are configured via
     *   an Array of Objects - the same data format that dataSource.fetchData()
     *   returns. These include ListGrid.fields, TabSet.tabs,
     *   DynamicForm.items, Facet.values and even DataSource.fields.
     *   
     *   For example, if you had a DataSource "myFormFields" whose fields included the
     *   basic properties of FormItem (name, title, type, etc), this example
     *   code would create a form based on stored field definitions, loaded from the
     *   "myFormFields" DataSource on the fly:
     *   
     *    isc.DataSource.get("myFormFields").fetchData(null, 
     *      "isc.DynamicForm.create({ items:data })"
     *    )
     *   
     *   
     *   
     *   This capability to dynamically create visual components from dynamically fetched data
     *   provides a foundation for creating interfaces that can be customized by end users.
     *   See also the server-side API com.isomorphic.datasource.DataSource.addDynamicDSGenerator() for
     *   dynamically creating DataSources supporting all server-side DataSource features, and
     *   DataSource.inheritsFrom for sharing field definitions across multiple DataSources.
     *  
     *  
     *  @param {Criteria=} search criteria
     *  @param {DSCallback=} callback to invoke on completion
     *  @param {DSRequest=} additional properties to set on                            the DSRequest that will be issued
     */
    open fun fetchData(criteria: dynamic?, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Perform a "fetch" DataSource operation against this DataSource, sending search criteria
     *   and retrieving matching records.
     * 
     *   This is identical to DataSource.fetchData except that
     *   DSRequest.textMatchStyle is set to "substring" to cause case insensitive
     *   substring matching (if the server respects this setting).
     * 
     * 
     *  @param {Criteria=} search criteria
     *  @param {DSCallback=} callback to invoke on completion
     *  @param {DSRequest=} additional properties to set on                            the DSRequest that will be issued
     */
    open fun filterData(criteria: dynamic?, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Exports arbitrary client-side data, with client-side formatters applied, so is suitable
     *   for direct display to users. This method can be used to export data formatted outside
     *   of any kind of visual component.
     * 
     *   If you do not specify an OperationBinding.operationId in the
     *   requestProperties you pass to this method, it behaves exactly the same as
     *   the DataSource.exportClientData of the same name.
     *   If you do specify an operationId, the framework expects your DataSource to
     *   configure an OperationBinding of OperationBinding.operationType
     *   "clientExport" with the same operationId. The framework will then send the
     *   exportClientData request via the ordinary DSRequest mechanism,
     *   which allows you to use normal framework features in the client data export.
     * 
     *   For example, you could add a dmiOverview to your
     *   operationBinding, which would allow you to write server-side code that
     *   intervenes in the export process - for instance, by calling the
     *   getExportObject() API to do something special with the export document,
     *   like saving it to a database table or sending it to an email list.
     * 
     *   When you use the specific operationId version of this API, both the
     *   SmartClient Server and server-side DataSources are required.
     * 
     *   To export unformatted data, see DataSource.exportData which does
     *   not include client-side formatters, but requires both the SmartClient server and the
     *   presence of server-side DataSources.
     * 
     *   Note that field DataSourceField.displayFormat is honored for
     *   "date" and "datetime" fields when exporting direct to Excel; see the displayFormat
     *   docs for details.
     * 
     * 
     *  @param {Array<Partial<Record>>} Array of Records to export
     *  @param {DSRequest} Request properties for the export
     *  @param {DSCallback} Optional callback. Note that this is only applicable if you also specify DSRequest.exportToClient: false in the  request properties
     */
    open fun exportClientData(data: Array<dynamic>, requestProperties: DSRequest, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit)): Unit = definedExternally
    /**
     *   Perform a "fetch" DataSource operation against this DataSource, sending search criteria,
     *   retrieving matching records and exporting the results. See
     *   OperationBinding.exportResults or DSRequest.exportResults and for more
     *   information.
     * 
     * 
     *  @param {Criteria=} search criteria
     *  @param {DSRequest=} additional properties to set on                            the DSRequest that will be issued
     *  @param {DSCallback=} callback to invoke on completion. Note that this parameter                 only applies where DSRequest.exportToClient is                  explicitly set to false, because file downloads do not                  provide ordinary SmartClient callbacks
     */
    open fun exportData(criteria: dynamic?, requestProperties: DSRequest?, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?)): Unit = definedExternally
    /**
     *   Produces a clientOnly "copy" of a particular subset of data from a normal
     *   DataSource, via calling fetchData() to fetch matching rows, and constructing
     *   a clientOnly DataSource that DataSource.inheritsFrom the original DataSource.
     * 
     *   This clientOnly "copy" can be useful in situations where you want to allow
     *   a series of local changes without immediately committing to the server.
     *   See also ListGrid.autoSaveEdits for more fine-grained tracking of
     *   edits (eg, special styling for uncommitted changes).
     * 
     *   The new DataSource is returned via the "callback" argument. If DataSource.cacheAllData is
     *   enabled and DataSource.hasAllData returns true, the new DataSource is synchronously
     *   returned as the result of the method. In this case, if a callback was passed, it also
     *   is executed synchronously.
     * 
     * 
     *  @param {Criteria} The criteria for the clientOnly DS
     *  @param {ClientOnlyDataSourceCallback} The callback to fire passing the clientOnly DS
     *  @param {DSRequest=} optional properties to pass through to the DSRequest
     *  @param {DataSource=} optional properties to pass                            through to the clientOnly DS
     */
    open fun getClientOnlyDataSource(criteria: dynamic, callback: ((clientOnly: DataSource) -> Unit), requestProperties: DSRequest?, dataSourceProperties: DataSource?): Unit = definedExternally
    /**
     *   Perform an "add" DataSource operation against this DataSource, to create a new DataSource
     *   record.
     * 
     *   NOTE: do not use repeated calls to addData() to provide the initial
     *   dataset for a DataSource.clientOnly DataSource, instead, provide
     *   initial data via DataSource.cacheData. Using addData() for subsequent,
     *   incremental updates from sources like user editing is fine.
     * 
     * 
     *  @param {Record} new record
     *  @param {DSCallback=} callback to invoke on completion
     *  @param {DSRequest=} additional properties to set on                            the DSRequest that will be issued
     */
    open fun addData(newRecord: Record, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Perform an "update" DataSource operation against this DataSource, to update values in an
     *   existing DataSource record.
     * 
     * 
     *  @param {Record} updated record
     *  @param {DSCallback=} callback to invoke on completion
     *  @param {DSRequest=} additional properties to set on                            the DSRequest that will be issued
     */
    open fun updateData(updatedRecord: Record, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Perform a "remove" DataSource operation against this DataSource, to delete an existing
     *   DataSource record.
     * 
     * 
     *  @param {Record | any} primary key values of record to delete, (or complete record)
     *  @param {DSCallback=} callback to invoke on completion
     *  @param {DSRequest=} additional properties to set on                            the DSRequest that will be issued
     */
    open fun removeData(data: dynamic, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Contacts the server to run server-side validation on a DSRequest and either returns
     *   DSResponse.errors validation errors or a DSResponse.status code of 0.
     * 
     *   A "validate" dsRequest is effectively always RPCRequest.willHandleError:true.
     *   It is a normal condition for a "validate" DSResponse to have validation errors and
     *   the response will never go to system-wide handling for unexpected errors
     *   (RPCManager.handleError).
     * 
     * 
     *  @param {Record} record values to validate
     *  @param {DSCallback=} callback to invoke on completion
     *  @param {DSRequest=} additional properties to set on                          the DSRequest that will be issued
     */
    open fun validateData(values: Record, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Invoke an operation declared with OperationBinding.operationType "custom".
     * 
     *   This is a rarely used API. If the operation you are performing can be thought of
     *   as one of the standard "CRUD" DSOperationType, declare it
     *   with a CRUD operationType. For example, if your operation updates a record, declare it
     *   with operationType "update" and invoke it via DataSource.updateData - this will cause
     *   ResultSet to work correctly.
     * 
     *   In particular:
     * 
     * 
     *  - do not use this API just because you need to add additional server-side logic to a
     *   CRUD operation (DMI allows this)
     * 
     *  - do not use this API to implement variants of core CRUD operations
     *   (DSRequest.operationId is the correct way to do this)
     * 
     *  - do not use this API just because an operation affects more than one record. Most
     *   kinds of multi-record operations should use RPCManager.startQueue.
     *   However, a custom operation is appropriate for genuine "batch" updates, as
     *   opposed to just a number of ordinary updates by primaryKey - see
     *   OperationBinding.allowMultiUpdate
     * 
     *  - do not use this API just because you are calling a stored procedure in SQL - if the
     *   stored procedure performs some kind of CRUD operation on the records of this DataSource,
     *   use a standard CRUD operationType
     * 
     * 
     *   Instead, the specific purpose of this API is to bypass all checks and side effects that
     *   normally occur for CRUD operations, for example, that a "fetch" requires valid Criteria
     *   or that an "update" or "remove" operation contains a valid primary key, or that an "add"
     *   operation returns the newly added record. performCustomOperation allows
     *   you to pass an arbitrary Record to the server, act on it with custom code, and return
     *   arbitray results or even no results.
     * 
     *   The "data" parameter becomes DSRequest.data. With the SmartClient
     *   Server Framework, the data is accessible server-side via DSRequest.getValues() and in
     *   velocitySupport (such as &lt;customSQL&gt;) as $values.
     * 
     *   Note that with SQLDataSource, performCustomOperation must be used if you
     *   plan to have a &lt;customSQL&gt; tag in your operationBinding that will execute SQL
     *   operations other than SELECT, UPDATE, INSERT, DELETE (such as creating a new table).
     *   By declaring OperationBinding.operationType "custom" in your .ds.xml file, all
     *   checks related to normal CRUD operations will be skipped and your &lt;customSQL&gt;
     *   can do arbitrary things.
     * 
     * 
     *  @param {string} the operation ID
     *  @param {Record=} data to pass to the server.
     *  @param {DSCallback=} callback to invoke on completion
     *  @param {DSRequest=} additional properties to set on                            the DSRequest that will be issued
     */
    open fun performCustomOperation(operationId: String, data: Record?, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Download a file stored in a field of type:"binary" in a DataSource record.
     * 
     *   This will trigger the browser's "Save As" dialog and allow the user to save the file
     *   associated with some record.
     * 
     *   Note that if this method is called for a record with no associated file, the
     *   download URL may not be functional. By default when dataSources encounter a
     *   FieldType, an additional field,
     *   &lt;fieldName&gt;_filename, is generated to
     *   store the filename for the binary field value. If this field is present in the
     *   data source but has no value for this record, developers can assume they're working
     *   with a record with no stored file. If this field is not present in some custom
     *   dataSource configuration, or the record is not loaded on the client, an additional
     *   server transaction may be required to determine whether the record has an associated
     *   file before calling this method to download a file.
     * 
     *   See the overview of binaryFields for more details.
     * 
     * 
     *  @param {Record} Record to download. Only required to have a value for the            primary key field.
     *  @param {FieldName=} Optional name of the binary field containing the file.                  If not provided, the first binary field is used.
     *  @param {DSRequest=} Additional properties to set on the                           DSRequest that will be issued.
     */
    open fun downloadFile(data: Record, fieldName: String?, requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Display a file stored in a field of type:"binary" in a new browser window.
     * 
     *   This will open a new browser window to show the file. Depending on the file type,
     *   the user's installed plugins and applications, and the user's browser settings, this may
     *   cause the file to be actually displayed in the new browser window, or may prompt the
     *   user to either launch an external application to view the file or save the file to disk.
     * 
     *   Note that if this method is called for a record with no associated file, the
     *   target window's new URL may not be functional. By default when dataSources encounter a
     *   FieldType, an additional field,
     *   &lt;fieldName&gt;_filename, is generated to
     *   store the filename for the binary field value. If this field is present in the
     *   data source but has no value for this record, developers can assume they're working
     *   with a record with no stored file. If this field is not present in some custom
     *   dataSource configuration, or the record is not loaded on the client, an additional
     *   server transaction may be required to determine whether the record has an associated
     *   file before calling this method to view a file.
     * 
     *   See the overview of binaryFields for details.
     * 
     * 
     *  @param {Record} Record to download. Only required to have a value for the            primary key field.
     *  @param {FieldName=} Optional name of the binary field containing the file.                  If not provided, the first binary field is used.
     *  @param {DSRequest=} Additional properties to set on the                           DSRequest that will be issued.
     */
    open fun viewFile(data: Record, fieldName: String?, requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Returns a direct URL to access a file stored in a field of type:"binary".
     * 
     *   This URL can be used as the "src" attribute of an Img widget or &lt;img&gt; tag (if the file is
     *   an image), or can be used in an ordinary HTML link (&lt;a&gt; tag) to download the file.
     *   However, for the latter use case, see also DataSource.downloadFile and DataSource.viewFile.
     * 
     *   The URL returned is not to a static file on disk, rather, the returned URL essentially
     *   encodes a DSRequest as URL parameters, in a format understood by the IDACall servlet
     *   that comes with the Server Framework.
     * 
     *   Hence, this URL will dynamically retrieve whatever file is currently stored in the
     *   binary field via executing a normal DSRequest server side. The request will run through
     *   normal security checks, so if your application requires authentication, the user must
     *   have a valid session and be authorized to access the binary field.
     * 
     *   Note that if this method is called for a record with no associated file, the
     *   returned URL may not be functional. By default when dataSources encounter a
     *   FieldType, an additional field,
     *   &lt;fieldName&gt;_filename, is generated to
     *   store the filename for the binary field value. If this field is present in the
     *   data source but has no value for this record, developers can assume they're working
     *   with a record with no stored file. If this field is not present in some custom
     *   dataSource configuration, or the record is not loaded on the client, an additional
     *   server transaction may be required to determine whether the record has an associated
     *   file before calling this method to retrieve a download URL.
     * 
     * 
     *  @param {Record | any} Record or value of primary key field for record containing                 the file to view.
     *  @param {FieldName=} Optional name of the binary field containing the file. If                  not provided, the first binary field is used.
     *  @param {DSRequest=} Additional properties to set on the                           DSRequest that will be issued.
     */
    open fun getFileURL(data: dynamic, fieldName: String?, requestProperties: DSRequest?): String = definedExternally
    /**
     *   Returns a URL to DataSource fetch operation. This API is intended to return
     *   media such as images or videos to the browser.
     * 
     *   Note that because the entirety of the request is encoded in the URL, there is an
     *   inherent limitation on the amount of data that you can send viat he criteria argument to
     *   the server. The actual length depends on your server configuration and other factors
     *   such as the size of cookies (if any) being sent to the server and other HTTP headers in
     *   use. Conservatively, assume that you have about 2 kilobytes to work with.
     * 
     * 
     *  @param {Criteria} Criteria to be sent to server.
     *  @param {DSRequest=} additional properties to set on                            the DSRequest that will be issued
     */
    open fun getFetchDataURL(criteria: dynamic, requestProperties: DSRequest?): String = definedExternally
    /**
     * 
     *   Gets the contents of a file stored in this DataSource.
     * 
     * 
     *  @param {FileSpec | string} Either a FileSpec, or a String which         will be parsed to determine the fileName, fileType and fileFormat.         For instance, "employees.ds.xml" would be parsed as         {fileName: "employees", fileType: "ds", fileFormat: "xml"}.         If fileType and fileFormat are not provided, will return         the first file with the specified fileName.
     *  @param {GetFileCallback} Callbacks.GetFileCallback executed with the results. The         data parameter is either a String with the         contents of the file, or null to indicate error (such as         file not found).          You can examine DSResponse.status         and DSResponse.data         for additional information about any error.
     */
    open fun getFile(fileSpec: dynamic, callback: ((dsResponse: DSResponse, data: String, dsRequest: DSRequest) -> Unit)): Unit = definedExternally
    /**
     * 
     *   Indicates whether a file exists in this DataSource.
     * 
     * 
     *  @param {FileSpec | string} Either a FileSpec, or a String which         will be parsed to determine the fileName, fileType and fileFormat.         For instance, "employees.ds.xml" would be parsed as         {fileName: "employees", fileType: "ds", fileFormat: "xml"}.         If fileType or fileFormat are not provided, will indicate whether         any file with the provided fileName exists.
     *  @param {HasFileCallback} Callbacks.HasFileCallback executed with the results.         The data parameter is a boolean indicating         whether the file is present.         You can examine DSResponse.status         and DSResponse.data         for additional information about any error.
     */
    open fun hasFile(fileSpec: dynamic, callback: ((dsResponse: DSResponse, data: Boolean, dsRequest: DSRequest) -> Unit)): Unit = definedExternally
    /**
     * 
     *   Get a list of files from the DataSource. Note, if
     *   DataSource.fileVersionField is switched on for the dataSource,
     *   the resulting list contains only the most recent version of each file.
     * 
     * 
     *  @param {Criteria} Criteria to apply. References to fileName,         fileType and fileFormat fields will         be translated to the native field names configured for         this DataSource.
     *  @param {DSCallback} Callback executed with the results.         The data parameter is either an array of records,         or null to indicate an error.          The records will have the DataSource.fileNameField,         DataSource.fileTypeField,         DataSource.fileFormatField,          DataSource.fileLastModifiedField, and          DataSource.fileVersionField fields populated, but          not the DataSource.fileContentsField field. (You          can use DataSource.getFile to get the fileContents).         You can examine DSResponse.status         and DSResponse.data         for additional information about any error.
     */
    open fun listFiles(criteria: dynamic, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit)): Unit = definedExternally
    /**
     * 
     *   Save a file to the DataSource.
     * 
     * 
     *  @param {FileSpec | string} Either a FileSpec, or a String which         will be parsed to determine the fileName, fileType and fileFormat.         For instance, "employees.ds.xml" would be parsed as         {fileName: "employees", fileType: "ds", fileFormat: "xml"}.         Depending on the configuration of the DataSource, the fileType         and fileFormat may be optional.
     *  @param {string} The contents of the file
     *  @param {DSCallback=} Callback executed with the results.         The data parameter is either a record represening         the new file, or null to indicate an error. The record will have its         fileName, fileType and fileFormat         field populated, but not the fileContents         field.         You can examine DSResponse.status         and DSResponse.data         for additional information about any error.
     */
    open fun saveFile(fileSpec: dynamic, contents: String, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?)): Unit = definedExternally
    /**
     * 
     *   Rename a file stored in this DataSource. Note, if
     *   DataSource.fileVersionField is switched on for the dataSource,
     *   all versions of the file are renamed.
     * 
     * 
     *  @param {FileSpec | string} Either a FileSpec, or a String which         will be parsed to determine the fileName, fileType and fileFormat         of the file to rename.         For instance, "employees.ds.xml" would be parsed as         {fileName: "employees", fileType: "ds", fileFormat: "xml"}.         Depending on the configuration of the DataSource, the fileType and fileFormat         may be optional.
     *  @param {FileSpec | string} Either a FileSpec, or a String which         will be parsed to determine the fileName, fileType and fileFormat         to rename the file to.         For instance, "employees.ds.xml" would be parsed as         {fileName: "employees", fileType: "ds", fileFormat: "xml"}.         If the fileType or fileFormat are not provided, then they will not         be changed.
     *  @param {DSCallback=} Callback executed with the results.         The data parameter is either an array of         records represening the renamed file(s), or null to         indicate an error.         The records will have their fileName fields and         fileType fields populated, but not the         fileContents field.         You can examine DSResponse.status         and DSResponse.data         for additional information about any error.
     */
    open fun renameFile(oldFileSpec: dynamic, newFileSpec: dynamic, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?)): Unit = definedExternally
    /**
     * 
     *   Remove a file stored in this DataSource. Note, if
     *   DataSource.fileVersionField is switched on for the dataSource,
     *   all versions of the file are removed (to remove an individual file version, use the
     *   DataSource.removeFileVersion API).
     * 
     * 
     *  @param {FileSpec | string} Either a FileSpec, or a String which         will be parsed to determine the fileName, fileType and fileFormat.         For instance, "employees.ds.xml" would be parsed as         {fileName: "employees", fileType: "ds", fileFormat: "xml"}.         Depending the configuration of the DataSource, the fileType         and fileFormat may be optional.
     *  @param {DSCallback=} Callback executed with the results.         The data parameter is either an array of         records represening the removed file(s), or null to         indicate an error.         The records will have their fileName fields and         fileType fields populated, but not the         fileContents field.         You can examine DSResponse.status         and DSResponse.data         for additional information about any error.
     */
    open fun removeFile(fileSpec: dynamic, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?)): Unit = definedExternally
    /**
     * 
     *   Get the list of a given file's versions from the dataSource, sorted in version order
     *   (most recent version first). If the dataSource does not specify a
     *   DataSource.fileVersionField, this API will return an error
     * 
     * 
     *  @param {FileSpec | string} Either a FileSpec, or a String which         will be parsed to determine the fileName, fileType and fileFormat.         For instance, "employees.ds.xml" would be parsed as         {fileName: "employees", fileType: "ds", fileFormat: "xml"}.         If fileType and fileFormat are not provided, will return         the first file with the specified fileName.
     *  @param {DSCallback} Callback executed with the results.         The data parameter is either an array of records,         or null to indicate an error.          The records will have the DataSource.fileNameField,         DataSource.fileTypeField,         DataSource.fileFormatField,          DataSource.fileLastModifiedField and          DataSource.fileVersionField fields populated, but          not the DataSource.fileContentsField field. (You         can use DataSource.getFileVersion to get the          fileContents).         You can examine DSResponse.status         and DSResponse.data         for additional information about any error.
     */
    open fun listFileVersions(fileSpec: dynamic, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit)): Unit = definedExternally
    /**
     * 
     *   Gets the contents of a particular file version stored in this DataSource.
     * 
     * 
     *  @param {FileSpec | string} Either a FileSpec, or a String which         will be parsed to determine the fileName, fileType and fileFormat.         For instance, "employees.ds.xml" would be parsed as         {fileName: "employees", fileType: "ds", fileFormat: "xml"}.         If fileType and fileFormat are not provided, will return         the first file with the specified fileName.
     *  @param {Date} A version timestamp. This must exactly match the version         timestamp recorded in the DataSource. You can obtain the list of          versions for a given file with the DataSource.listFileVersions API.
     *  @param {GetFileVersionCallback} Callbacks.GetFileVersionCallback executed with the results. The         data parameter is either a String with the         contents of the file, or null to indicate error (such as         file not found).          You can examine DSResponse.status         and DSResponse.data         for additional information about any error.
     */
    open fun getFileVersion(fileSpec: dynamic, version: Date, callback: ((dsResponse: DSResponse, data: String, dsRequest: DSRequest) -> Unit)): Unit = definedExternally
    /**
     * 
     *   Indicates whether a particular file version exists in this DataSource.
     * 
     * 
     *  @param {FileSpec | string} Either a FileSpec, or a String which         will be parsed to determine the fileName, fileType and fileFormat.         For instance, "employees.ds.xml" would be parsed as         {fileName: "employees", fileType: "ds", fileFormat: "xml"}.         If fileType or fileFormat are not provided, will indicate whether         any file with the provided fileName exists.
     *  @param {Date} A version timestamp. This must exactly match the version         timestamp recorded in the DataSource for hasFileVersion to         return true. Note, you can obtain the list of versions for a given          file with the DataSource.listFileVersions API.
     *  @param {HasFileCallback} Callbacks.HasFileVersionCallback         executed with the results. The data parameter is a boolean         indicating whether the file version is present.         You can examine DSResponse.status         and DSResponse.data         for additional information about any error.
     */
    open fun hasFileVersion(fileSpec: dynamic, version: Date, callback: ((dsResponse: DSResponse, data: Boolean, dsRequest: DSRequest) -> Unit)): Unit = definedExternally
    /**
     * 
     *   Remove a particular file version stored in this DataSource. Any other versions of the
     *   file are left untouched.
     * 
     * 
     *  @param {FileSpec | string} Either a FileSpec, or a String which         will be parsed to determine the fileName, fileType and fileFormat.         For instance, "employees.ds.xml" would be parsed as         {fileName: "employees", fileType: "ds", fileFormat: "xml"}.         If fileType and fileFormat are not provided, will return         the first file with the specified fileName.
     *  @param {Date} A version timestamp. This must exactly match the version         timestamp recorded in the DataSource. You can obtain the list of          versions for a given file with the DataSource.listFileVersions API.
     *  @param {DSCallback=} Callback executed with the results.         The data parameter is either a record representing the         removed file version, or null to indicate an error.         The record will have its DataSource.fileNameField,         DataSource.fileTypeField,         DataSource.fileFormatField,          DataSource.fileLastModifiedField, and          DataSource.fileVersionField fields populated, but          not the DataSource.fileContentsField field.         You can examine DSResponse.status         and DSResponse.data         for additional information about any error.
     */
    open fun removeFileVersion(fileSpec: dynamic, version: Date, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?)): Unit = definedExternally
    /**
     *   Executes the given DSRequest on this DataSource.
     * 
     *   This method is typically used by a DataSource whose DataSource.dataProtocol
     *   is set to "clientCustom".
     *   Execution of a DSRequest can be delayed, either after a timeout or until some condition
     *   is met, by saving the DSRequest object passed to the DataSource.transformRequest
     *   override and calling execute() on the DSRequest at a later time.
     * 
     *  @param {DSRequest} the DSRequest to execute.
     */
    open fun execute(dsRequest: DSRequest): Unit = definedExternally
    /**
     *   Override point to allow application code to suppress use of a particular offline
     *   response. For example, application code may wish to examine the response's
     *   DSResponse.offlineTimestamp to make a decision about whether
     *   the response is too stale to be useful.
     * 
     *   This is an application override point only; there is no default implementation.
     * 
     * 
     *  @param {DSRequest} The dsRequest object
     *  @param {DSResponse} The corresponding dsResponse object returned from                 offline cache
     */
    open fun useOfflineResponse(dsRequest: DSRequest, dsResponse: DSResponse): Boolean = definedExternally
    /**
     *   If you define this method on a DataSource, it will be called whenever the server returns
     *   a DSResponse with a status other than RPCResponse.STATUS_SUCCESS. You can use
     *   this hook to do DataSource-specific error handling.
     *   Unless you return false from this method,
     * 
     *   RPCManager.handleError will be called by SmartClient right after this method completes.
     * 
     * 
     *  @param {DSResponse} the DSResponse or DSResponse object returned from the server
     *  @param {DSRequest} the DSRequest or DSRequest that was sent to the server
     */
    open fun handleError(response: DSResponse, request: DSRequest): Boolean = definedExternally
    /**
     *   Return the field definition object.
     * 
     *  @param {FieldName} Name of the field to retrieve
     */
    open fun getField(fieldName: dynamic): DataSourceField = definedExternally
    /**
     *   Return the field definition object corresponding to the supplied dataPath
     * 
     *  @param {string} dataPath of the field to retrieve
     */
    open fun getFieldForDataPath(dataPath: String): DataSourceField = definedExternally
    /**
     *   Given a fieldName and a dataValue, apply any DataSourceField.valueMap for the
     *   field and return the display value for the field
     * 
     *  @param {FieldName} name of the field to retrieve a value for
     *  @param {any} data value for the field
     */
    open fun getDisplayValue(fieldName: String, value: dynamic): dynamic = definedExternally
    /**
     *   Retrieves the list of fields declared on this DataSource.
     * 
     * 
     *  @param {boolean} If true, returns only those fields that are                 not marked as hidden
     */
    open fun getFieldNames(excludeHidden: Boolean): Array<dynamic> = definedExternally
    /**
     *   Returns this DataSource's DataSourceField.primaryKey fields as a map
     *   of fieldName to field.
     * 
     */
    open fun getPrimaryKeyFields(): Record = definedExternally
    /**
     *   Returns a list of the names of this DataSource's
     *   DataSourceField.primaryKey fields.
     * 
     */
    open fun getPrimaryKeyFieldNames(): Array<dynamic> = definedExternally
    /**
     *   Returns a pointer to the primaryKey field for this DataSource. If this dataSource has
     *   a composite primary key (ie, multiple primaryKey fields), returns just the first
     *   primaryKey field.
     * 
     */
    open fun getPrimaryKeyField(): DataSourceField = definedExternally
    /**
     *   Returns the primary key fieldName for this DataSource.  If this dataSource has
     *   a composite primary key (ie, multiple primaryKey fields), returns just the first
     *   primaryKey field name.
     * 
     */
    open fun getPrimaryKeyFieldName(): String = definedExternally
    /**
     *   Return a reasonable user-visible title given a fieldName. Called when
     *   DataSource.autoDeriveTitles is true and by default, calls the class method
     *   DataSource.getAutoTitle. Override to provide a different policy
     *   for auto-deriving titles for a particular DataSource or subclass of DataSource.
     * 
     * 
     *  @param {string} identifier for which a title is desired.
     */
    open fun getAutoTitle(identifier: String): String = definedExternally
    /**
     *   Returns the complete set of data cached by this dataSource. Note that this may
     *   have been supplied via DataSource.cacheData, or may have been fetched
     *   from the server for dataSources with DataSource.cacheAllData set to true.
     * 
     */
    open fun getCacheData(): Array<dynamic> = definedExternally
    /**
     *   Return a "spoofed" response for a DataSource.clientOnly or DataSource.cacheAllData DataSource.
     * 
     *   The default implementation will use DataSource.cacheData to provide an appropriate
     *   response, by using DataSource.applyFilter for a "fetch" request, and
     *   by modifying the cacheData for other requests.
     * 
     *   Override this method to provide simulations of other server-side behavior, such as
     *   modifying other records, or to implement synchronous client-side data providers
     *   (such as Google Gears). For asynchronous third-party data providers, such as
     *   GWT-RPC, HTML5 sockets, or bridges to plug-in based protocols (Java, Flash,
     *   Silverlight..), use DSProtocol instead.
     * 
     *   Overriding this method is also a means of detecting that a normal DataSource (not
     *   clientOnly) would be contacting the server.
     * 
     * 
     *  @param {DSRequest} DataSource request to respond to
     *  @param {Array<Partial<Record>>} for cacheAllData DataSources, the data from the local cache
     */
    open fun getClientOnlyResponse(request: DSRequest, serverData: Array<dynamic>): DSResponse = definedExternally
    /**
     *   Returns records in the passed Array that match the provided filter
     *   Criteria. Handles simple or AdvancedCriteria criteria.
     * 
     *   By default:
     * 
     * 
     *  - any criteria that do not correspond to a DataSource field are ignored
     * 
     *  - for simple criteria, any null or empty string criteria are ignored and
     *     all other criteria are passed to DataSource.fieldMatchesFilter
     * 
     *  - for advanced criteria, each criterion is evaluated via DataSource.evaluateCriterion
     * 
     *   This method is called by ResultSet.applyFilter to provide filtering when a
     *   ResultSet has a complete cache and filtering can be performed client-side. You may want
     *   to override this method in order to mimic the filtering behavior that your server performs.
     * 
     * 
     *  @param {Array<Partial<Record>>} the list of rows
     *  @param {Criteria} the filter criteria
     *  @param {DSRequest=} optional dataSource request properties
     *  @param {Integer=} starting index - earlier rows are excluded
     *  @param {Integer=} ending index (exclusive) - this row and beyond are excluded
     */
    open fun applyFilter(data: Array<dynamic>, criteria: dynamic, requestProperties: DSRequest?, startPos: Number?, endPos: Number?): Array<dynamic> = definedExternally
    /**
     *   Compares a criteria value to a field value and returns whether they match, as follows:
     * 
     * 
     *  - any non-String filter value is directly compared (==) to the field value
     * 
     *  - any String filter value is compared according to
     *     DSRequest.textMatchStyle in the passed requestProperties,
     *     regardless of the actual field type
     * 
     *  - if the filter value is an Array, the comparison is a logical OR. If textMatchStyle
     *     is "exact", it matches if fieldValue (or any of it's entries, if it's also an array)
     *     is contained in the filterValue Array. If textMatchStyle if substring, it matches
     *     if any of the entries in filterValue appear as a case-insensitive substring of any
     *     of the entries in fieldValue.
     * 
     *  - Dates are compared as logical dates if either the field value or the filter value is a logical date.
     *     Only if none of them is a logical date they will be compared as standard Dates
     * 
     * 
     *  @param {any} field value to be compared
     *  @param {any} filter value to be compared
     *  @param {DSRequest=} optional dataSource request properties
     */
    open fun fieldMatchesFilter(fieldValue: dynamic, filterValue: dynamic, requestProperties: DSRequest?): Boolean = definedExternally
    /**
     *   Does this dataSource support the specified "textMatchStyle" when performing a filter
     *   operation against a text field.
     * 
     *  @param {TextMatchStyle} textMatchStyle to check. If passed a null value,   assume an exact match is being requested.
     */
    open fun supportsTextMatchStyle(textMatchStyle: 
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
                                                    String /* exact |  exactCase |  substring |  startsWith */): Unit = definedExternally
    /**
     *   Given two sets of criteria, determine whether they are equivalent, the new criteria is
     *   guaranteed more restrictive, or the new criteria is not guaranteed more restrictive,
     *   returning 0, 1 or -1 respectively.
     * 
     *   Comparisons between AdvancedCriteria are made via recursively calling
     *   Operator.compareCriteria for all criteria involved.
     * 
     *   For simple Criteria, by default (CriteriaPolicy:"dropOnShortening"), returns:
     * 
     * 
     *  - -1 if the new criteria has fewer properties than the old criteria (indicating that it
     *     isn't more restrictive)
     * 
     *  - -1 if the value for any property in the old criteria is an array and 1) the value for
     *     the same property in the new criteria isn't an array, or 2) is an array but
     *     of different length, or 3) the arrays do not contain the exact same set of objects
     *     (order can be different)
     * 
     *  - -1 if the value for any given property in the old criteria is not an array, and the
     *     the value for the same property property in the new criteria is different
     * 
     *  - -1 if both values for a given property are strings and the new criteria value doesn't
     *     contain the old criteria value
     * 
     *  - 1 if none of the above are true and, for at least one of the properties, the
     *     respective criteria values are both strings, and the old criteria value is a substring
     *     of, and is shorter than, the new criteria value
     * 
     *  - 0 otherwise (indicating the sets of criteria are equivalent)
     * 
     * 
     *   For (CriteriaPolicy:"dropOnChange"), returns:
     * 
     * 
     *  - -1 if the two sets of criteria have a different number of properties
     * 
     *  - -1 if the value for any property in the old criteria is an array and 1) the value for
     *     the same property in the new criteria isn't an array, or 2) is an array but
     *     of different length, or 3) the arrays do not contain the exact same set of objects
     *     (order can be different)
     * 
     *  - -1 if the value for any given property in the old criteria is not an array, and the
     *     the value for the same property in the new criteria is different
     * 
     *  - 0 otherwise (indicating the sets of criteria are equivalent)
     * 
     *   This method is called by ResultSet.compareCriteria to determine whether a change
     *   in criteria should cause the cache to be invalidated. You may want
     *   to override this method in order to mimic the filtering behavior that your server performs.
     * 
     * 
     *  @param {Criteria} new filter criteria
     *  @param {Criteria} previous filter criteria
     *  @param {DSRequest=} dataSource request properties
     *  @param {string=} overrides CriteriaPolicy
     */
    open fun compareCriteria(newCriteria: dynamic, oldCriteria: dynamic, requestProperties: DSRequest?, policy: String?): Number = definedExternally
    /**
     *   Returns the depth-first match of a criterion matching the given fieldName.
     * 
     * 
     *  @param {Criteria} the criteria to search
     *  @param {FieldName} the fieldName to find criteria for
     */
    open fun getFieldCriterion(criterion: dynamic, fieldName: String): dynamic = definedExternally
    /**
     *   Convenience method to compare two Date objects appropriately, depending on whether the
     *   passed-in fieldName refers to a field of FieldType "datetime" or
     *   "date". In the former case, the dates are compared using DateUtil.compareDates;
     *   in the latter case, or if the supplied fieldName is null or unknown to this DataSource,
     *   the dates are compared using DateUtil.compareLogicalDates.
     * 
     *  @param {Date} First date in comparison
     *  @param {Date} Second date in comparison
     *  @param {FieldName} The name of the field for which the comparison is being run
     */
    open fun compareDates(date1: Date, date2: Date, fieldName: String): Number = definedExternally
    /**
     *   Convenience method to test if two records are equal. Testing is done only for the
     *   fields defined in the DataSource, anything else is ignored.
     * 
     * 
     *  @param {any} record to be compared against.
     *  @param {any} record to be compared.
     */
    open fun recordsAreEqual(record1: dynamic, record2: dynamic): Boolean = definedExternally
    /**
     *   Converts criteria expressed in SmartClient's simple criteria format to an
     *   AdvancedCriteria object. This instance method differs from the class method
     *   DataSource.convertCriteria in that it makes use of the dataSource
     *   as schema to help in the conversion. For example, this method is able to honor
     *   DataSourceField.ignoreTextMatchStyle and use the dataSource's
     *   DataSource.defaultTextMatchStyle rather than assuming "substring"
     * 
     * 
     *  @param {Criteria} simple criteria
     *  @param {TextMatchStyle=} default style of matching text. Defaults to                     the dataSource's defaultTextMatchStyle
     */
    open fun convertDataSourceCriteria(criteria: dynamic, textMatchStyle: 
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
                                                                          String /* exact |  exactCase |  substring |  startsWith */?): AdvancedCriteria = definedExternally
    /**
     *   Do fetch and filter operations on this dataSource support being passed
     *   AdvancedCriteria?
     * 
     *   For a DataSource to support being passed AdvancedCriteria, it must be
     *   DataSource.clientOnly or DataSource.cacheAllData, or have
     *   server side logic which can process AdvancedCriteria objects passed from the client.
     * 
     *   AdvancedCriteria are supported on the server for standard
     *   sqlDataSource, hibernateIntegration and
     *   jpaIntegration DataSources in SmartClient Enterprise or Power editions
     *   (not supported in SmartClient Pro).
     * 
     *   The framework assumes that custom dataSources support AdvancedCriteria; if you have a
     *   a custom DataSOurce implementation that does not support AdvancedCriteria, you can set
     *   the DataSource.allowAdvancedCriteria property to false.
     * 
     * 
     */
    open fun supportsAdvancedCriteria(): Boolean = definedExternally
    /**
     *   Add a new search operator, only to this DataSource.
     * 
     *   If an existing Operator is passed, restricts the set of FieldTypes to which that
     *   operator can be applied in this DataSource.
     * 
     *   See also DataSource.addSearchOperator for adding operators to all
     *   DataSources.
     * 
     * 
     *  @param {Operator} definition of the operator to add
     *  @param {Array<Partial<FieldType>>=} types to which this operator applies
     */
    open fun addSearchOperator(operator: Operator, types: Array<dynamic>?): Unit = definedExternally
    /**
     *   Get the Operator definition for an OperatorId.
     * 
     * 
     *  @param {OperatorId} the id of the operator
     */
    open fun getSearchOperator(operatorId: 
                                           /**
                                            *  exactly equal to
                                            *  not equal to
                                            *  exactly equal to, if case is disregarded
                                            *  not equal to, if case is disregarded
                                            *  Greater than
                                            *  Less than
                                            *  Greater than or equal to
                                            *  Less than or equal to
                                            *  Contains as sub-string (match case)
                                            *  Starts with (match case)
                                            *  Ends with (match case)
                                            *  Contains as sub-string (case insensitive)
                                            *  Starts with (case insensitive)
                                            *  Ends with (case insensitive)
                                            *  Does not contain as sub-string (match case)
                                            *  Does not start with (match case)
                                            *  Does not end with (match case)
                                            *  Does not contain as sub-string (case insensitive)
                                            *  Does not start with (case insensitive)
                                            *  Does not end with (case insensitive)
                                            *  shortcut for "greaterThan" + "and" + "lessThan" (case insensitive)
                                            *  shortcut for "greaterOrEqual" + "and" + "lessOrEqual" (case insensitive)
                                            *  Basic GLOB matching using wildcards    (see DataSource.translatePatternOperators for more information on available patterns)
                                            *  Basic GLOB matching using wildcards (case insensitive)    (see DataSource.translatePatternOperators for more information on available patterns)
                                            *  GLOB matching using wildcards. Value is considered to meet the    criterion if it contains the pattern. See DataSource.translatePatternOperators
                                            *      for more information on available patterns)
                                            *  GLOB mathcing using wildcards. Value is considered to meet the    criterion if it starts with the pattern.See DataSource.translatePatternOperators
                                            *      for more information on available patterns)
                                            *  GLOB mathcing using wildcards. Value is considered to meet the    criterion if it starts with the pattern.See DataSource.translatePatternOperators
                                            *      for more information on available patterns)
                                            *  GLOB matching using wildcards. Value is considered to meet the    criterion if it contains the pattern. Matching is case insensitive. See
                                            *      DataSource.translatePatternOperators for more information on available patterns)
                                            *  GLOB matching using wildcards. Value is considered to meet the    criterion if it starts with the pattern. Matching is case insensitive.See
                                            *      DataSource.translatePatternOperators for more information on available patterns)
                                            *  GLOB matching using wildcards.Value is considered to meet the    criterion if it ends with the pattern. Matching is case insensitive. See
                                            *      DataSource.translatePatternOperators for more information on available patterns)
                                            *  Regular expression match
                                            *  Regular expression match (case insensitive)
                                            *  value is either null or the empty string. For numeric fields it behaves as isNull
                                            *  value is neither null nor the empty string ("")
                                            *  value is null
                                            *  value is non-null. Note empty string ("") is non-null
                                            *  value is in a set of values. Specify criterion.value as an Array
                                            *  value is not in a set of values. Specify criterion.value as an Array
                                            *  matches another field (match case, specify fieldName as criterion.value)
                                            *  does not match another field (match case, specify fieldName as criterion.value)
                                            *  matches another field (case insensitive, specify fieldName as criterion.value)
                                            *  does not match another field (case insensitive, specify fieldName as criterion.value)
                                            *  Greater than another field (specify fieldName as criterion.value)
                                            *  Less than another field (specify fieldName as criterion.value)
                                            *  Greater than or equal to another field    (specify fieldName as criterion.value)
                                            *  Less than or equal to another field    (specify fieldName as criterion.value)
                                            *  Contains as sub-string (match case) another field value    (specify fieldName as criterion.value)
                                            *  Starts with (match case) another field value    (specify fieldName as criterion.value)
                                            *  Ends with (match case) another field value    (specify fieldName as criterion.value)
                                            *  Contains as sub-string (case insensitive) another field value    (specify fieldName as criterion.value)
                                            *  Starts with (case insensitive) another field value    (specify fieldName as criterion.value)
                                            *  Ends with (case insensitive) another field value    (specify fieldName as criterion.value)
                                            *  Does not contain as sub-string (match case) another field value    (specify fieldName as criterion.value)
                                            *  Does not start with (match case) another field value    (specify fieldName as criterion.value)
                                            *  Does not end with (match case) another field value    (specify fieldName as criterion.value)
                                            *  Does not contain as sub-string (case insensitive) another field value    (specify fieldName as criterion.value)
                                            *  Does not start with (case insensitive) another field value    (specify fieldName as criterion.value)
                                            *  Does not end with (case insensitive) another field value    (specify fieldName as criterion.value)
                                            *  all subcriteria (criterion.criteria) are true
                                            *  all subcriteria (criterion.criteria) are false
                                            *  at least one subcriteria (criterion.criteria) is true
                                            *  shortcut for "greaterThan" + "lessThan" + "and". Specify criterion.start     and criterion.end
                                            *  shortcut for "greaterOrEqual" + "lessOrEqual" + "and". Specify     criterion.start and criterion.end
                                            */
                                           String /* equals |  notEqual |  iEquals |  iNotEqual |  greaterThan |  lessThan |  greaterOrEqual |  lessOrEqual |  contains |  startsWith |  endsWith |  iContains |  iStartsWith |  iEndsWith |  notContains |  notStartsWith |  notEndsWith |  iNotContains |  iNotStartsWith |  iNotEndsWith |  iBetween |  iBetweenInclusive |  matchesPattern |  iMatchesPattern |  containsPattern |  startsWithPattern |  endsWithPattern |  iContainsPattern |  iStartsWithPattern |  iEndsWithPattern |  regexp |  iregexp |  isBlank |  notBlank |  isNull |  notNull |  inSet |  notInSet |  equalsField |  notEqualField |  iEqualsField |  iNotEqualField |  greaterThanField |  lessThanField |  greaterOrEqualField |  lessOrEqualField |  containsField |  startsWithField |  endsWithField |  iContainsField |  iStartsWithField |  iEndsWithField |  notContainsField |  notStartsWithField |  notEndsWithField |  iNotContainsField |  iNotStartsWithField |  iNotEndsWithField |  and |  not |  or |  between |  betweenInclusive */): Operator = definedExternally
    /**
     *   Get the list of OperatorIds available on this DataSource for the given FieldType.
     * 
     *   If DataSource.setTypeOperators has been called for this DataSource and FieldType, returns that
     *   list, otherwise, returns the set of valid operators for the FieldType as specified by
     *   SimpleType.validOperators, otherwise, the system-wide set of valid operators for the
     *   type as registered via DataSource.addSearchOperator.
     * 
     * 
     *  @param {FieldType | string=} Defaults to "text" if not passed.
     */
    open fun getTypeOperators(typeName: dynamic?): Array<dynamic> = definedExternally
    /**
     *   Set the list of OperatorIds valid for a given FieldType.
     * 
     * 
     *  @param {FieldType | string} \* @param {Array<Partial<OperatorId>>} available Operators
     */
    open fun setTypeOperators(typeName: dynamic, operators: Array<dynamic>): Unit = definedExternally
    /**
     *   Get the list of OperatorIds available for this field.
     * 
     *   By default, if DataSourceField.validOperators is set,
     *   returns that list, otherwise returns the result of DataSource.getTypeOperators.
     * 
     *  @param {string | DataSourceField} Field (or field name) to obtain operators for
     */
    open fun getFieldOperators(field: dynamic): Array<dynamic> = definedExternally
    /**
     *   Get the list of Operators available for this field, as a ValueMap from
     *   OperatorId to the Operator.title specified for the Operator, or
     *   the corresponding property in Operators if Operator.titleProperty is set.
     * 
     *   This valueMap is suitable for use in a UI for building queries, similar to the
     *   FilterBuilder, and optionally omits operators marked Operator.hidden:true.
     * 
     *   It is also possible to have this function return only operators of a given
     *   OperatorValueType, or everything except operators of that type. This is useful,
     *   for example, if you want to return all the logical operators (like "and"), or everything
     *   except the logical operators.
     * 
     * 
     *  @param {string | DataSourceField} Field (or field name) to obtain operator map for.
     *  @param {boolean=} whether to include Operators marked hidden:true
     *  @param {OperatorValueType=} If passed, returns only operators of this OperatorValueType
     *  @param {boolean=} If set, reverses the meaning of the valueType     parameter, so operators of that OperatorValueType are the only ones omitted
     */
    open fun getFieldOperatorMap(field: dynamic, includeHidden: Boolean?, valueType: 
                                                                                     /**
                                                                                      *  Criterion.value should contain a value of the same type as the          field.
                                                                                      *  Criterion.value should be the name of another field in the record
                                                                                      *  no criterion.value or other setting required (used for operators like          isBlank or isNull).
                                                                                      *  Criterion.criteria should be an Array of criteria (used for logical          operators like "and").
                                                                                      *  Criterion.start and Criterion.end should contain start and           end values, both of the same type as the field.
                                                                                      *  Criterion.value should contain an Array of valid field values.
                                                                                      *  Criterion.value should contain a value which is not necessarily the         same type as the field (used for regexp and similar operators).
                                                                                      *           Operator.editorType can be specified as a FormItem to use to
                                                                                      *           enter a value for the criterion.
                                                                                      */
                                                                                     String /* fieldType |  fieldName |  none |  criteria |  valueRange |  valueSet |  custom */?, omitValueType: Boolean?): dynamic = definedExternally
    /**
     *   Get the list of Operators available for this FieldType, as a ValueMap from
     *   OperatorId to the Operator.title specified for the Operator, or
     *   the corresponding property in Operators if Operator.titleProperty is set.
     * 
     *   This valueMap is suitable for use in a UI for building queries, similar to the
     *   FilterBuilder, and optionally omits operators marked Operator.hidden:true.
     * 
     *   It is also possible to have this function return only operators of a given
     *   OperatorValueType, or everything except operators of that type. This is useful,
     *   for example, if you want to return all the logical operators (like "and"), or everything
     *   except the logical operators.
     * 
     * 
     *  @param {FieldType=} Type to obtain operator map for. Defaults to "text" if not passed.
     *  @param {boolean=} whether to include Operators marked hidden:true
     *  @param {OperatorValueType=} If passed, returns only operators of this OperatorValueType
     *  @param {boolean=} If set, reverses the meaning of the valueType     parameter, so operators of that OperatorValueType are the only ones omitted
     */
    open fun getTypeOperatorMap(type: 
                                      /**
                                       *  Generic text, e.g. "John Doe". This is the default field type.          Use field.length to set length.
                                       *  A boolean value, e.g. true
                                       *  A whole number, e.g. 123
                                       *  A floating point (decimal) number, e.g. 1.23
                                       *  A logical date, with no time value (such as a holiday or birthday).          Represented on the client as a JavaScript Date object where
                                       *            time values are ignored. See dateFormatAndStorage for more
                                       *            information on date display and serialization formats.
                                       *  A time of day, with no date. Represented on the client as a JavaScript          Date object in UTC/GMT by default (see also
                                       *            dateFormatAndStorage and the Time class).
                                       *  A date and time, accurate to the second. Represented on the client as a           JavaScript Date object. See also
                                       *            dateFormatAndStorage.
                                       *  A text value constrained to a set of legal values specified by the          field's DataSourceField.valueMap, as though a
                                       *            ValidatorType of "isOneOf" had been declared.
                                       *  An enum whose values are numeric.
                                       *  If you are using the SmartClient SQL datasource connector, a          sequence is a unique, increasing whole number, incremented
                                       *            whenever a new record is added. Otherwise, sequence behaves
                                       *            identically to integer. This type is typically used with
                                       *            field.primaryKey to auto-generate unique primary keys.
                                       *            See also DataSourceField.sequenceName and
                                       *            DataSource.sequenceMode
                                       *  A string representing a well-formed URL. Some components          will render this as an HTML link (using an anchor tag for example).
                                       *  A string representing a well-formed URL that points to an          image. Some components will render an IMG tag with the value of this field
                                       *            as the 'src' attribute to render the image.
                                       *  Arbitrary binary data. When this field type is present, three additional fields are automatically generated. They are: &lt;fieldName&gt;_filename, &lt;fieldName&gt;_filesize, and
                                       *   &lt;fieldName&gt;_date_created where &lt;fieldName&gt; is the value of the name
                                       *   attribute of this field. These fields are marked as
                                       *   DataSourceField.hidden:true to suppress their rendering by default. You
                                       *   can show one or more of these fields by specifying the field with a hidden:false
                                       *   override in the fields array of the databound component.
                                       *   Stream / view file support for custom DataSources: a custom DataSource or DMI
                                       *   must implement the "viewFile" and "downloadFile" operationTypes and return a single Record
                                       *   with a byte[] as the field value for the binary field. For more detail see
                                       *   the overview of binaryFields.
                                       *  Binary data comprising an image. Causes ViewFileItem to be used          when the field is displayed in a form, allowing the image to optionally
                                       *            be displayed inline.
                                       *  Fields of this type can contain any data value and have no default           formatting or validation behavior. This is useful as the
                                       *            SimpleType.inheritsFrom for SimpleTypes
                                       *            where you do not want any of the standard validation or formatting logic
                                       *            to be inherited from the standard built-in types.
                                       *  Synonymous with "any".
                                       *  Fields of this type are automatically populated by the SmartClient Server           with the current authenticated userId as part of "add" and "update"
                                       *            operations. By default, fields of this type are hidden and not editable;
                                       *            the server ignores any value that the client sends in a field of this type.
                                       *            Note that the "authenticated user" can be set explicitly on the server-side
                                       *            RPCManager using the setUserId() method, or it can come from
                                       *            the servlet API if you are using its built-in authentication scheme. See
                                       *            the server-side Javadocs for RPCManager.
                                       *  Fields of this type are automatically populated by the SmartClient          Server with the current date and time as part of "add" and "update"
                                       *            operations. By default, fields of this type are hidden and not editable;
                                       *            the server ignores any value that the client sends in a field of this type.
                                       *  Fields of this type are automatically populated by the SmartClient Server           with the current authenticated userId as part of "add" operations.
                                       *            By default, fields of this type are hidden and not editable;
                                       *            the server ignores any value that the client sends in a field of this type.
                                       *            The notes about type "modifier" also apply to fields of this type.
                                       *  Fields of this type are automatically populated by the SmartClient          Server with the current date and time as part of an "add" operation (when
                                       *            the record is first created). By default, fields of this type are hidden
                                       *            and not editable; the server ignores any value that the client sends in a
                                       *            field of this type.
                                       *  Same as "text", but causes PasswordItem to be used by default for          editing (hides typed-in value).
                                       *  A special field type specifically for use with Unicode data in conjunction          with the Microsoft SQL Server database. Field type "ntext" implies the
                                       *            use of DataSourceField.sqlStorageStrategy "ntext";
                                       *            other than that, this type is identical to "text"
                                       *  An integer number with locale-based formatting, e.g. 12,345,678.          See localizedNumberFormatting
                                       *            for more info.
                                       *  A float number with locale-based formatting, e.g. 12,345.67.          See localizedNumberFormatting
                                       *            for more info.
                                       *  A float number with locale-based formatting and using currency          symbol, e.g. $12,345.67.
                                       *            See localizedNumberFormatting
                                       *            for more info.
                                       *  A telephone number. Uses FormItem.browserInputType "tel" to          hint to the device to restrict input. On most mobile devices that have
                                       *            software keyboards, this cause a specialized keyboard to appear which
                                       *            only allows entry of normal phone numbers. When displayed read-only,
                                       *            a "phoneNumber" renders as an HTML link with the "tel:" URL scheme,
                                       *            which will invoke the native phone dialing interface on most mobile
                                       *            devices. In addition, the CSS style "sc_phoneNumber" is applied.
                                       * 
                                       *            By default, "phoneNumber" fields do not include validators, however the
                                       *            following validator definition would limit to digits, dashes and the
                                       *            "+" character:
                                       *            xml:
                                       * 
                                       *            &lt;validator type="regexp" expression="^(\(?\+?[0-9]\*\)?)?[0-9_\- \(\)]\*$"
                                       *              errorMessage="Phone number should be in the correct format e.g. +#(###)###-##-##" /&gt;
                                       * 
                                       * 
                                       *              or directly in JavaScript:
                                       * 
                                       * 
                                       *   {type:"regexp", expression:"^(\\(?\\+?[0-9]\*\\)?)?[0-9_\\- \\(\\)]\*$", 
                                       *     errorMessage:"Phone number should be in the correct format e.g. +#(###)###-##-##"}
                                       * 
                                       * 
                                       * 
                                       *            and adding "#" and "\*" to the regular expressions above would allow for
                                       *            users to enter special keys sometimes used for extension numbers or
                                       *            pauses
                                       */
                                      String /* text |  boolean |  integer |  float |  date |  time |  datetime |  enum |  intEnum |  sequence |  link |  image |  binary |  imageFile |  any |  custom |  modifier |  modifierTimestamp |  creator |  creatorTimestamp |  password |  ntext |  localeInt |  localeFloat |  localeCurrency |  phoneNumber */?, includeHidden: Boolean?, valueType: 
                                                                                                                                                                                                                                                                                                                                                                                                   /**
                                                                                                                                                                                                                                                                                                                                                                                                    *  Criterion.value should contain a value of the same type as the          field.
                                                                                                                                                                                                                                                                                                                                                                                                    *  Criterion.value should be the name of another field in the record
                                                                                                                                                                                                                                                                                                                                                                                                    *  no criterion.value or other setting required (used for operators like          isBlank or isNull).
                                                                                                                                                                                                                                                                                                                                                                                                    *  Criterion.criteria should be an Array of criteria (used for logical          operators like "and").
                                                                                                                                                                                                                                                                                                                                                                                                    *  Criterion.start and Criterion.end should contain start and           end values, both of the same type as the field.
                                                                                                                                                                                                                                                                                                                                                                                                    *  Criterion.value should contain an Array of valid field values.
                                                                                                                                                                                                                                                                                                                                                                                                    *  Criterion.value should contain a value which is not necessarily the         same type as the field (used for regexp and similar operators).
                                                                                                                                                                                                                                                                                                                                                                                                    *           Operator.editorType can be specified as a FormItem to use to
                                                                                                                                                                                                                                                                                                                                                                                                    *           enter a value for the criterion.
                                                                                                                                                                                                                                                                                                                                                                                                    */
                                                                                                                                                                                                                                                                                                                                                                                                   String /* fieldType |  fieldName |  none |  criteria |  valueRange |  valueSet |  custom */?, omitValueType: Boolean?): dynamic = definedExternally
    /**
     *   Converts a list of Records to simple text formats with a Record per line and values separated
     *   by a configurable separator, including both tab-separated-values and comma-separated-values
     *   (aka CSV).
     * 
     *   In addition to the settings parameter for this method,
     *   DataSourceField.exportForceText can be set.
     * 
     *   If two or more different text exports are needed for the same DataSource creating a conflict
     *   for any DataSourceField setting, DataSource.inheritsFrom can be used to create a
     *   child DataSource where these settings can be changed without recapitulating all field
     *   definitions.
     * 
     * 
     *  @param {Array<Partial<Record>>} records to convert
     *  @param {TextExportSettings=} settings for the export
     */
    open fun recordsAsText(records: Array<dynamic>, settings: TextExportSettings?): String = definedExternally
    /**
     *   Derive a list of Records from Microsoft Excel-compatible tab-separated-values format, using
     *   the current DataSource field order, or an explicitly specified list of fields.
     * 
     *   If a specified field does not exist in the DataSource, it's assumed the values for that
     *   field should end up as Strings.
     * 
     * 
     *  @param {string} records as CSV/TSV (separator can be specified)
     *  @param {TextImportSettings=} optional settings for the import
     */
    open fun recordsFromText(text: String, settings: TextImportSettings?): Array<dynamic> = definedExternally
    /**
     *   Evaluate the given criterion with respect to the passed record.
     * 
     *   Typically called by the Operator.condition function of a custom
     *   Operator to evaluate Criterion.criteria.
     * 
     * 
     *  @param {Record} record to evaluate
     *  @param {Criterion} criterion to use
     */
    open fun evaluateCriterion(record: Record, criterion: Criterion): Boolean = definedExternally
    /**
     *   Split a criteria apart based on fields. A new simple criteria
     *   is returned with any criteria applicable to the specified fields. The passed
     *   criteria is then modified to remove these fields resulting in
     *   two distinct criteria.
     * 
     *   Incoming criteria can be a simple or advanced criteria. For an AdvancedCriteria
     *   only a single level of criteria with a top-level operator of "and" is supported.
     * 
     *   To avoid modifying an original criteria, use DataSource.copyCriteria to
     *   make a copy to be passed in.
     * 
     * 
     *  @param {Criteria} criteria to be split. May be modified if criteria is              extracted.
     *  @param {Array<Partial<string>>} list of fields to extract from criteria
     */
    open fun splitCriteria(criteria: dynamic, fields: Array<dynamic>): dynamic = definedExternally
    companion object {
        /**
         *  The URL where the DataSourceLoader servlet has been installed. Defaults to the
         *   Page.setIsomorphicDir plus "/DataSourceLoader". Change by calling
         *   calling DataSource.setLoaderURL
         *  @type {URL}
         *  @default "[ISOMORPHIC]/DataSourceLoader"
         */
        var loaderURL: String = definedExternally
        /**
         *  Default value if DataSourceField.stringInBrowser is not defined. See
         *   stringInBrowser docs for details.
         *   Note this setting should be used only if you are \*not\* using the SmartClient Server.
         *  @type {boolean}
         *  @default null
         */
        var defaultStringInBrowser: Boolean = definedExternally
        /**
         *  Specifies how time field values should be serialized when being sent to the server for
         *   dataSources with dataFormat "xml" or "json".
         *   If false the time field will be serialized as a logical time object in
         *   UTC, using the standard truncated XML Schema format: "HH:MM:SS".
         *   If true the time field will be serialized as a complete dateTime object
         *   matching the value of the underlying JavaScript date object representing this time on the
         *   client.
         *  @type {boolean}
         *  @default false
         */
        var serializeTimeAsDatetime: Boolean = definedExternally
        /**
         *  A message returned by a DataSource when it is returning an empty dataset for a fetch
         *   because the browser is currently offline and there is no suitable cached offline response.
         *  @type {string}
         *  @default "This data not available while offline"
         */
        var offlineMessage: String = definedExternally
        /**
         *  A message returned by a DataSource when an uploaded file's size exceeded
         *   DataSourceField.maxFileSize.
         * 
         *   If this is not set, then Validator.maxFileSizeExceeded value will be used.
         *  @type {HTMLString}
         *  @default "Size of '${uploadedFileName}' (${uploadedFileSize}) exceeded maximum allowed file size of ${maxFileSize}"
         */
        var maxFileSizeExceededMessage: String = definedExternally
        /**
         *  A message returned by a DataSource when an uploaded file was empty, but the
         *   field is DataSourceField.required.
         *  @type {HTMLString}
         *  @default "'${uploadedFileName}' was empty, but empty files are not allowed."
         */
        var requiredFileMessage: String = definedExternally
        /**
         *  Provides the global default setting for deep or shallow cloning of objects prior to
         *   edit. See DataSource.deepCloneOnEdit for details of what this means.
         * 
         *   The default setting of null is the same as false; with this default in place,
         *   deepCloneOnEdit must be set explicitly set at dataSource, component or
         *   field level if you require deep cloning.
         *  @type {boolean}
         *  @default null
         */
        var deepCloneOnEdit: Boolean = definedExternally
        /**
         *  Provides the global default setting for deep or shallow cloning of non-field attributes
         *   of value objects prior to edit. See
         *   DataSource.deepCloneNonFieldValuesOnEdit for details of what this means.
         * 
         *   The default setting of null is the same as false; with this default in place,
         *   deepCloneNonFieldValuesOnEdit must be set explicitly set at dataSource or
         *   component level if you require deep cloning.
         *  @type {boolean}
         *  @default null
         */
        var deepCloneNonFieldValuesOnEdit: Boolean = definedExternally
        /**
         *  Creates a new DataSource
         * 
         *  @param typeCheckedProperties {Partial<DataSource>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DataSource} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DataSource = definedExternally
        /**
         *   Lookup a DataSource by ID.
         * 
         * 
         *  @param {GlobalId} DataSource ID
         */
        fun getDataSource(ID: String): DataSource = definedExternally
        /**
         *   Synonym of DataSource.getDataSource: Lookup a DataSource by ID.
         * 
         * 
         *  @param {GlobalId} DataSource ID
         */
        fun get(ID: String): DataSource = definedExternally
        /**
         *   Helper method to return the value of the supplied field from within the supplied record,
         *   looking up the value from the supplied dataPath. This method is only of real
         *   use when you are dealing with complex nested data via Canvas.dataPath;
         *   it is obviously a trivial matter to obtain a field value from a flat record directly.
         * 
         *   If the dataPath is null, this method will follow any ListGridField.dataPath
         *   specified on the component field instead. In either case, it will also extract
         *   SimpleType.getAtomicValue from custom SimpleType fields
         *   where this is required.
         * 
         * 
         *  @param {DataSourceField | ListGridField | DetailViewerField | FormItem} Field definition from a dataSource or dataBoundComponent.
         *  @param {Record} The valueset in which to look up the field value
         *  @param {string} Optionally, a string expressing the dataPath to use for value lookup.              If null, the dataPath from the field will be used
         *  @param {Canvas} Optionally, a component to prvide extra context for the dataPath               search. This is typically required if the dataPath traverses a list
         *  @param {string} An optional reason for the get request, to be passed into                  any SimpleType.getAtomicValue method - see that                  API for details
         */
        fun getFieldValue(field: dynamic, record: Record, dataPath: String, component: Canvas, reason: String): dynamic = definedExternally
        /**
         *   Helper method to save the argument value inside the argument values record, storing the
         *   value at the supplied dataPath, or at the field's declared dataPath if the argument
         *   dataPath is null. This method is only of real use when you are dealing with complex
         *   nested data via Canvas.dataPath; it is obviously a trivial matter
         *   to store a field value in a flat record directly.
         * 
         *   This method will call the SimpleType.updateAtomicValue
         *   method of custom SimpleType fields where this is required.
         * 
         * 
         *  @param {DataSourceField | ListGridField | DetailViewerField | FormItem} Field definition from a dataSource or dataBoundComponent.
         *  @param {string} The dataPath to store the value at. If null, the dataPath will             be picked up from the field
         *  @param {any} The value to save
         *  @param {Record} The valueset in which to save the field value
         *  @param {string} An optional reason for the save request, to be passed into                  any SimpleType.updateAtomicValue method - see that                  API for details
         */
        fun saveValueViaDataPath(field: dynamic, dataPath: String, value: dynamic, values: Record, reason: String): Unit = definedExternally
        /**
         *   Helper method to save the argument value inside the argument values record, storing the
         *   value at the supplied dataPath, or at the field's declared dataPath if the argument
         *   dataPath is null. This method is only of real use when you are dealing with complex
         *   nested data via Canvas.dataPath; it is obviously a trivial matter
         *   to store a field value in a flat record directly.
         * 
         *   This method will call the SimpleType.updateAtomicValue
         *   method of custom SimpleType fields where this is required.
         * 
         * 
         *  @param {DataSourceField | ListGridField | DetailViewerField | FormItem} Field definition from a dataSource or dataBoundComponent.
         *  @param {string} The dataPath at which to clear the value. If null, the dataPath will             be picked up from the field
         *  @param {Record} The valueset from which to clear the field value
         */
        fun clearValueAtDataPath(field: dynamic, dataPath: String, values: Record): Unit = definedExternally
        /**
         * 
         *   Converts a file path to a FileSpec.
         * 
         * 
         *  @param {string} The path to convert, e.g. "employees.ds.xml"
         */
        fun makeFileSpec(path: String): FileSpec = definedExternally
        /**
         *   Load a DataSource or an array of DataSources using the DataSourceLoader servlet. When
         *   a callback is specified, this is fired after the DataSources are loaded. The callback
         *   is passed a single parameter, the dsID list passed into the method. If
         *   no loading occurs because the requested DataSource(s) are already loaded, a warning is
         *   logged and the callback is fired immediately.
         * 
         *   To force reloading of DataSources that have already been loaded,
         *   pass true for the forceReload parameter.
         * 
         * 
         *  @param {string | Array<Partial<string>>} DataSource ID or Array of DataSource IDs
         *  @param {Function} Callback to fire after DataSource loading completes
         *  @param {boolean | DSLoadSettings=} Forcibly reload a dataSource if it's already loaded
         */
        fun load(dsID: dynamic, callback: (() -> dynamic), forceReload: dynamic?): Unit = definedExternally
        /**
         *   Variation of DataSource.load that will also automatically load any DataSources that
         *   the requested DataSources inherit from (via DataSource.inheritsFrom).
         * 
         *   If the parent DataSource is already loaded, calling loadWithParents will not
         *   automatically reload them unless the forceReload parameter is passed.
         * 
         * 
         *  @param {string | Array<Partial<string>>} DataSource ID or Array of DataSource IDs
         *  @param {Function} Callback to fire after DataSource loading completes
         *  @param {boolean | DSLoadSettings=} Forcibly reload a dataSource if it's already loaded
         */
        fun loadWithParents(dsID: dynamic, callback: (() -> dynamic), forceReload: dynamic?): Unit = definedExternally
        /**
         *   Given an array of SortSpecifiers, return a simple list of Strings in the format
         *   expected by DSRequest.sortBy.
         * 
         * 
         *  @param {Array<Partial<SortSpecifier>>} The list of specifiers to return in  sortBy format
         */
        fun getSortBy(sortSpecifiers: Array<dynamic>): Array<dynamic> = definedExternally
        /**
         *   Return a an array of SortSpecifiers, given an array of Strings in the format
         *   expected by DSRequest.sortBy.
         * 
         * 
         *  @param {Array<Partial<string>>} A list of sortBy strings in the format expected by DSRequest.sortBy
         */
        fun getSortSpecifiers(sortBy: Array<dynamic>): Array<dynamic> = definedExternally
        /**
         *   Create a copy of a criteria.
         * 
         * 
         *  @param {Criteria} criteria to copy
         */
        fun copyCriteria(criteria: dynamic): dynamic = definedExternally
        /**
         *   Returns true if a given AdvancedCriteria is "flat." That is, the criteria consists of either:
         * 
         * 
         *  - a top-level "and" or "or" Criterion, where none of the
         *     Criterion.criteria use LogicalOperator,
         *     hence have no subcriteria of their own
         * 
         *  - a single Criterion that is not a logical operator, hence has no subcriteria
         * 
         * 
         * 
         *  @param {AdvancedCriteria} the AdvancedCriteria to check for flatness
         */
        fun isFlatCriteria(criteria: AdvancedCriteria): Boolean = definedExternally
        /**
         *   Returns new criteria that has at most one top-level LogicalOperator ("and" or "or").
         *   This new criteria will be considered "flat" by DataSource.isFlatCriteria.
         * 
         *   Not all AdvancedCriteria can be flattened and remain logically equivalent. When
         *   criteria will be logically modified by flattening, all criteria that appear anywhere in
         *   the AdvancedCriteria structure will appear under a single top-level operator, which
         *   will be the same top-level operator as the passed AdvancedCriteria.
         * 
         *   For example, given criteria like this (in the JSON representation of AdvancedCriteria):
         * 
         *     { operator: "and", criteria: [
         *       { fieldName: "continent", operator: "equals", value: "Europe"},
         *       { operator: "or", criteria: [
         *        { fieldName: "countryName", operator: "iEndsWith", value: "land"},
         *        { fieldName: "population", operator: "lessThan", value: 3000000}
         *       ]}
         *      ]
         *     }
         * 
         *   The returned criteria would be:
         * 
         *     { operator: "and", criteria: [
         *       { fieldName: "continent", operator: "equals", value: "Europe"},
         *       { fieldName: "countryName", operator: "iEndsWith", value: "land"},
         *       { fieldName: "population", operator: "lessThan", value: 3000000}
         *      ]}
         * 
         *   This returned criteria is not logically equivalent to the passed criteria - the
         *   "iEndsWith" and "lessThan" criteria that were formerly nested under a logical "or"
         *   operator must now both be satisfied instead of either being satisfied.
         *   You can use DataSource.canFlattenCriteria to detect whether an AdvancedCriteria is going
         *   to be changed by flattenCriteria().
         * 
         *   Because the returned criteria may not be logically equivalent,
         *   flattenCriteria should not be used as a means of simplifying criteria to
         *   make server implementation easier or anything of the kind. The primary purpose of
         *   returning logically different criteria is to enable an end user to switch from an
         *   interface for editing nested criteria to an interface that can't handle nested
         *   criteria and convert the criteria while preserving as much as possible.
         * 
         * 
         *  @param {AdvancedCriteria} the AdvancedCriteria to flatten
         */
        fun flattenCriteria(criteria: AdvancedCriteria): AdvancedCriteria = definedExternally
        /**
         *   Returns true if calling DataSource.flattenCriteria on the passed criteria would produce
         *   logically equivalent criteria.
         * 
         * 
         *  @param {AdvancedCriteria} the AdvancedCriteria to check for flatness
         */
        fun canFlattenCriteria(criteria: AdvancedCriteria): Boolean = definedExternally
        /**
         *   Returns a human-readable string describing the clauses in this advanced criteria or criterion.
         * 
         * 
         *  @param {AdvancedCriteria | Criterion} Criteria to convert to a readable string
         *  @param {DataSource} DataSource to provide definitions of operators
         */
        fun getAdvancedCriteriaDescription(criteria: dynamic, dataSource: DataSource): String = definedExternally
        /**
         *   Returns the DataSource.setLoaderURL
         * 
         * 
         */
        fun getLoaderURL(): String = definedExternally
        /**
         *   Sets the URL where the DataSourceLoader servlet has been installed; this is used by the
         *   DataSource.load method. Note, one reason you may wish to modify the loader URL
         *   is to include a Cross-Site Request Forgery (CSRF) token, as described
         *   RPCManager.actionURL
         * 
         * 
         *  @param {string} The new loaderURL
         */
        fun setLoaderURL(url: String): Unit = definedExternally
        /**
         *   Add a new search operator to all DataSources.
         * 
         *   See also DataSource.addSearchOperator for adding operators to specific
         *   DataSources only.
         * 
         * 
         *  @param {Operator} definition of the operator to add
         */
        fun addSearchOperator(operator: Operator): Unit = definedExternally
        /**
         *   Set the list of valid OperatorIds for a given FieldType.
         * 
         * 
         *  @param {string | FieldType} \* @param {Array<Partial<OperatorId>>} available Operators
         */
        fun setTypeOperators(typeName: 
                                       /**
                                        *  Generic text, e.g. "John Doe". This is the default field type.          Use field.length to set length.
                                        *  A boolean value, e.g. true
                                        *  A whole number, e.g. 123
                                        *  A floating point (decimal) number, e.g. 1.23
                                        *  A logical date, with no time value (such as a holiday or birthday).          Represented on the client as a JavaScript Date object where
                                        *            time values are ignored. See dateFormatAndStorage for more
                                        *            information on date display and serialization formats.
                                        *  A time of day, with no date. Represented on the client as a JavaScript          Date object in UTC/GMT by default (see also
                                        *            dateFormatAndStorage and the Time class).
                                        *  A date and time, accurate to the second. Represented on the client as a           JavaScript Date object. See also
                                        *            dateFormatAndStorage.
                                        *  A text value constrained to a set of legal values specified by the          field's DataSourceField.valueMap, as though a
                                        *            ValidatorType of "isOneOf" had been declared.
                                        *  An enum whose values are numeric.
                                        *  If you are using the SmartClient SQL datasource connector, a          sequence is a unique, increasing whole number, incremented
                                        *            whenever a new record is added. Otherwise, sequence behaves
                                        *            identically to integer. This type is typically used with
                                        *            field.primaryKey to auto-generate unique primary keys.
                                        *            See also DataSourceField.sequenceName and
                                        *            DataSource.sequenceMode
                                        *  A string representing a well-formed URL. Some components          will render this as an HTML link (using an anchor tag for example).
                                        *  A string representing a well-formed URL that points to an          image. Some components will render an IMG tag with the value of this field
                                        *            as the 'src' attribute to render the image.
                                        *  Arbitrary binary data. When this field type is present, three additional fields are automatically generated. They are: &lt;fieldName&gt;_filename, &lt;fieldName&gt;_filesize, and
                                        *   &lt;fieldName&gt;_date_created where &lt;fieldName&gt; is the value of the name
                                        *   attribute of this field. These fields are marked as
                                        *   DataSourceField.hidden:true to suppress their rendering by default. You
                                        *   can show one or more of these fields by specifying the field with a hidden:false
                                        *   override in the fields array of the databound component.
                                        *   Stream / view file support for custom DataSources: a custom DataSource or DMI
                                        *   must implement the "viewFile" and "downloadFile" operationTypes and return a single Record
                                        *   with a byte[] as the field value for the binary field. For more detail see
                                        *   the overview of binaryFields.
                                        *  Binary data comprising an image. Causes ViewFileItem to be used          when the field is displayed in a form, allowing the image to optionally
                                        *            be displayed inline.
                                        *  Fields of this type can contain any data value and have no default           formatting or validation behavior. This is useful as the
                                        *            SimpleType.inheritsFrom for SimpleTypes
                                        *            where you do not want any of the standard validation or formatting logic
                                        *            to be inherited from the standard built-in types.
                                        *  Synonymous with "any".
                                        *  Fields of this type are automatically populated by the SmartClient Server           with the current authenticated userId as part of "add" and "update"
                                        *            operations. By default, fields of this type are hidden and not editable;
                                        *            the server ignores any value that the client sends in a field of this type.
                                        *            Note that the "authenticated user" can be set explicitly on the server-side
                                        *            RPCManager using the setUserId() method, or it can come from
                                        *            the servlet API if you are using its built-in authentication scheme. See
                                        *            the server-side Javadocs for RPCManager.
                                        *  Fields of this type are automatically populated by the SmartClient          Server with the current date and time as part of "add" and "update"
                                        *            operations. By default, fields of this type are hidden and not editable;
                                        *            the server ignores any value that the client sends in a field of this type.
                                        *  Fields of this type are automatically populated by the SmartClient Server           with the current authenticated userId as part of "add" operations.
                                        *            By default, fields of this type are hidden and not editable;
                                        *            the server ignores any value that the client sends in a field of this type.
                                        *            The notes about type "modifier" also apply to fields of this type.
                                        *  Fields of this type are automatically populated by the SmartClient          Server with the current date and time as part of an "add" operation (when
                                        *            the record is first created). By default, fields of this type are hidden
                                        *            and not editable; the server ignores any value that the client sends in a
                                        *            field of this type.
                                        *  Same as "text", but causes PasswordItem to be used by default for          editing (hides typed-in value).
                                        *  A special field type specifically for use with Unicode data in conjunction          with the Microsoft SQL Server database. Field type "ntext" implies the
                                        *            use of DataSourceField.sqlStorageStrategy "ntext";
                                        *            other than that, this type is identical to "text"
                                        *  An integer number with locale-based formatting, e.g. 12,345,678.          See localizedNumberFormatting
                                        *            for more info.
                                        *  A float number with locale-based formatting, e.g. 12,345.67.          See localizedNumberFormatting
                                        *            for more info.
                                        *  A float number with locale-based formatting and using currency          symbol, e.g. $12,345.67.
                                        *            See localizedNumberFormatting
                                        *            for more info.
                                        *  A telephone number. Uses FormItem.browserInputType "tel" to          hint to the device to restrict input. On most mobile devices that have
                                        *            software keyboards, this cause a specialized keyboard to appear which
                                        *            only allows entry of normal phone numbers. When displayed read-only,
                                        *            a "phoneNumber" renders as an HTML link with the "tel:" URL scheme,
                                        *            which will invoke the native phone dialing interface on most mobile
                                        *            devices. In addition, the CSS style "sc_phoneNumber" is applied.
                                        * 
                                        *            By default, "phoneNumber" fields do not include validators, however the
                                        *            following validator definition would limit to digits, dashes and the
                                        *            "+" character:
                                        *            xml:
                                        * 
                                        *            &lt;validator type="regexp" expression="^(\(?\+?[0-9]\*\)?)?[0-9_\- \(\)]\*$"
                                        *              errorMessage="Phone number should be in the correct format e.g. +#(###)###-##-##" /&gt;
                                        * 
                                        * 
                                        *              or directly in JavaScript:
                                        * 
                                        * 
                                        *   {type:"regexp", expression:"^(\\(?\\+?[0-9]\*\\)?)?[0-9_\\- \\(\\)]\*$", 
                                        *     errorMessage:"Phone number should be in the correct format e.g. +#(###)###-##-##"}
                                        * 
                                        * 
                                        * 
                                        *            and adding "#" and "\*" to the regular expressions above would allow for
                                        *            users to enter special keys sometimes used for extension numbers or
                                        *            pauses
                                        */
                                       String /* text |  boolean |  integer |  float |  date |  time |  datetime |  enum |  intEnum |  sequence |  link |  image |  binary |  imageFile |  any |  custom |  modifier |  modifierTimestamp |  creator |  creatorTimestamp |  password |  ntext |  localeInt |  localeFloat |  localeCurrency |  phoneNumber */, operators: Array<dynamic>): Unit = definedExternally
        /**
         *   Utility method to derive a reasonable user-visible title from an identifier.
         * 
         *   The following approach is taken:
         * 
         * 
         *  - any underscores (_) or dollar signs ($) become spaces, except that there will never
         *     be either a leading or trailing space.
         * 
         *  - if the fieldName is either entirely uppercase or lowercase, all words separated by
         *     spaces are given a leading capital letter. Example USER_NAME or user_name -> "User
         *     Name".
         * 
         *  - if there is any use of mixed case, camelCaps convention is assumed, and the field name
         *     is split into separate words based on 1) everywhere an uppercase letter appears after a
         *     lowercase letter 2) everywhere a series of uppercase letters ends. Letter case will
         *     not be modified, with the exception that the first word or any word after an
         *     underscore will have its first letter capitalized. Examples: useHTTPProxy -> "Use
         *     HTTP Proxy", audit_userName -> "Audit User Name"
         * 
         * 
         * 
         *  @param {string} identifier for which a title is desired.
         */
        fun getAutoTitle(identifier: String): String = definedExternally
        /**
         *   Converts criteria expressed in SmartClient's simple criteria format to an AdvancedCriteria
         *   object.
         * 
         * 
         *  @param {Criteria} simple criteria
         *  @param {TextMatchStyle=} default style of matching text. Defaults to                     "substring"
         */
        fun convertCriteria(criteria: dynamic, textMatchStyle: 
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
                                                               String /* exact |  exactCase |  substring |  startsWith */?): AdvancedCriteria = definedExternally
        /**
         *   Combines two criteria (either simple criteria objects or AdvancedCriteria) using the
         *   "outerOperator". Note that the combined criteria object will be an AdvancedCriteria
         *   unless:
         * 
         *  - both input criteria objects are simple, and
         * 
         *  - the "outerOperator" is "and", and
         * 
         *  - there is no collision of key names on the two criteria
         * 
         * 
         *  @param {Criteria} first criteria object
         *  @param {Criteria} second criteria object
         *  @param {CriteriaCombineOperator=} operator to use to combine the criteria.                      Defaults to "and"
         *  @param {TextMatchStyle=} style of matching text, if it is necessary to                     convert a simple criteria object to an                      AdvancedCriteria. Defaults to "substring"
         */
        fun combineCriteria(criteria1: dynamic, criteria2: dynamic, outerOperator: String /* and |  or */?, textMatchStyle: 
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
                                                                                                                            String /* exact |  exactCase |  substring |  startsWith */?): dynamic = definedExternally
        /**
         *   Applies a RecordSummaryFunction to a record and returns the result.
         * 
         *  @param {SummaryFunction} Summary Function or identifier for  registered recordSummaryFunction to execute. If passed in as an explicit function  record, fields and summaryField parameters will be passed through to the function.
         *  @param {any} Record to retrieve a summary for
         *  @param {Array<Partial<DataSourceField>>} Set of fields to include in the summary
         *  @param {DataSourceField} field in which this summary will be displayed.
         */
        fun applyRecordSummaryFunction(summaryFunction: 
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
                                                        String /* sum |  avg |  max |  min |  multiplier |  count |  title |  first |  concat */, record: dynamic, fields: Array<dynamic>, summaryField: DataSourceField): dynamic = definedExternally
        /**
         *   Register a new standard RecordSummaryFunction. This will then be available
         *   by calling SimpleType.applySummaryFunction and passing in just the new method name.
         * 
         *  @param {string} identifier for the new summary function
         *  @param {Function | StringMethod} new summary function implementation. This method should take 3 parameters: record (the record for which the  summary is being generated), fields (an array of fields to include in the  generated summary) and summaryField (a pointer to the field in which the  summary will be displayed [may be null].
         */
        fun registerRecordSummaryFunction(methodName: String, summaryFunction: dynamic): Unit = definedExternally
        /**
         *   Exports arbitrary client-side data, with client-side formatters applied, so is suitable
         *   for direct display to users. This method can be used to export data formatted outside
         *   of any kind of visual component.
         * 
         *   Requires the SmartClient server, but does not rely on any server-side DataSources. If
         *   you need to intervene in the export process server-side - for example, if you need to
         *   do something not directly supported with the exported object, such as attach it to an
         *   email - use the DataSource.exportClientData with an
         *   appropriate OperationBinding, as described in the method documentation.
         * 
         *   To export unformatted data, see DataSource.exportData which does
         *   not include client-side formatters, but requires both the SmartClient server and the
         *   presence of server-side DataSources.
         * 
         *   Note that field DataSourceField.displayFormat is honored for
         *   "date" and "datetime" fields when exporting direct to Excel; see the displayFormat
         *   docs for details.
         * 
         * 
         *  @param {Array<Partial<Record>>} Array of Records to export
         *  @param {DSRequest} Request properties for the export
         *  @param {DSCallback} Optional callback. Note that this is only applicable if you also specify DSRequest.exportToClient: false in the  request properties
         */
        fun exportClientData(data: Array<dynamic>, requestProperties: DSRequest, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit)): Unit = definedExternally
        /**
         *   Getter method for extracting server-side validation errors for an attempted
         *   "update" or "add" operation, as a JS Object where each property name is a
         *   field name from the record and each property value is an array of error message strings.
         *   For example:
         *     {
         *       userId : ["A user with this userId already exists"],
         *       orderId : ["Must be a numeric value", "No Order with ID '6A18294' exists"]
         *     }
         * 
         *   The Java API DSResponse.addError(fieldName, errorMessage) is used to send server-side errors
         *   to the client. See the Java Server Reference for details.
         * 
         * 
         *  @param {DSResponse} response from which you want to extract the errors
         */
        fun getSimpleErrors(dsResponse: DSResponse): dynamic = definedExternally
    }
}