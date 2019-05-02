@file:JsQualifier("isc")
package isc

/**
 *  An operationBinding tells a DataSource how to execute one of the basic DS operations: fetch,
 *   add, update, remove. See DataSource.operationBindings.
 */
open external class OperationBinding : Class {
    /**
     *  If set to "false", transformation of values for
     *   DataSourceField.multiple fields, normally controlled by
     *   DataSourceField.multipleStorage, is instead disabled for this OperationBinding.
     *  @type {boolean}
     *  @default null
     */
    open var transformMultipleFields: Boolean = definedExternally
    /**
     *  Setting skipAudit to true indicates that DataSource.audit
     *   must be skipped for this operationBinding.
     * 
     *   Note, that this setting can be overrided by server-side API DSRequest.setSkipAudit().
     *  @type {boolean}
     *  @default null
     */
    open var skipAudit: Boolean = definedExternally
    /**
     *  A per-operationBinding setting for beanClassName, otherwise also settable at the top-level
     *   DataSource configuration.
     *  @type {string}
     *  @default null
     */
    open var beanClassName: String = definedExternally
    /**
     *  Which operationType this operationBinding is for. This property is only settable on an
     *   operationBinding, not a DataSource as a whole.
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
     *  Optional operationId if this DataSource supports two or more variants of one of the basic
     *   DataSource operations, for instance, a "fetch" that uses full text search and a "fetch" that
     *   accepts per-field search criteria. See DSRequest.operationId for usage.
     *  @type {string}
     *  @default null
     */
    open var operationId: String = definedExternally
    /**
     *  The name of the method to invoke on the ServerObject for this operationBinding.
     * 
     *   NOTE: If you have a DataSource.serverObject and
     *   wish to override this operation so that it simply calls a different method on the same
     *   server object, it is sufficient to specify just this property on the operationBinding:
     *   there is no need to redefine the serverObject at the operationBinding level.
     *  @type {string}
     *  @default null
     */
    open var serverMethod: String = definedExternally
    /**
     *  You can explicitly declare the arguments to be passed to
     *   OperationBinding.serverMethod using this attribute. This isn't required - in the
     *   absence of methodArguments, the DMI implementation will still automatically
     *   pass a stock set of arguments to your method (see the overview in ServerObject), but
     *   specifying arguments gives you the ability to call pre-existing methods without adding
     *   SmartClient-specific code.
     * 
     *   The format for specifying methodArguments is as a comma separated list of VTL
     *   (Velocity Template Language) expressions. See the
     *   VTL Reference
     *   and Velocity User Guide
     *   for an overview of how to use VTL.
     * 
     *   The Velocity context is pre-populated with the following variables - you can pass these
     *   verbatim as arguments, or call methods on these objects and pass the resulting values:
     * 
     * 
     *  - dsRequest: instance of the current DSRequest
     * 
     *  - request: the current HttpServletRequest
     * 
     *  - response: the current HttpServletResponse
     * 
     *  - rpcManager: the instance of RPCManager for this request
     * 
     *  - dataSource: a DataSource instance for this request
     * 
     *   So, for example, if you had a method signature like the following:
     * 
     *   public DSResponse fetch(SupplyItem criteria, long startRow, long endRow)
     * 
     *   You can invoke it by specifying methodArguments as follows:
     * 
     *   methodArguments="$dsRequest.criteria, $dsRequest.startRow, $dsRequest.endRow"
     * 
     *   Without methodArguments, there would be no way for you to specify
     *   startRow/endRow as arguments. You could, of course, simply declare the method
     *   to take a DSRequest object and call getStartRow()/getEndRow() in
     *   the body of the method.
     *  @type {string}
     *  @default null
     */
    open var methodArguments: String = definedExternally
    /**
     *  Optional ServerObject declaration that specifies the ServerObject configuration for this
     *   operationBinding. In the absence of a serverObject specification here, the one specified on
     *   the DataSource itself is used by default, if present (DataSource.serverObject). If
     *   neither is present, then Direct Method Invocation will not be enabled for this operationBinding.
     * 
     *   Note that if a dataSource configuration has both a OperationBinding.script block and
     *   a specified serverObject for some operation, the
     *   script block will be executed, and the serverObject ignored.
     *  @type {ServerObject}
     *  @default null
     */
    open var serverObject: ServerObject = definedExternally
    /**
     *  Scriptlet to be executed prior to the DataSource operation which is configured by this
     *   operationBinding. This setting overrides any
     *   DataSource.script
     *   for this operation.
     * 
     *   Scriptlets are used similarly to DMIs configured via OperationBinding.serverObject -
     *   they can add business logic by modifying the DSRequest before it's executed, modifying the
     *   default DSResponse, or taking other, unrelated actions.
     * 
     *   Scriptlets are used similarly to DMIs configured via DataSource.serverObject or
     *   OperationBinding.serverObject -
     *   they can add business logic by modifying the DSRequest before it's executed, modifying the
     *   default DSResponse, or taking other, unrelated actions.
     * 
     *   For example:
     * 
     *    &lt;operationBindings&gt;
     *      &lt;operationBinding operationType="add"&gt;
     *        &lt;script language="groovy"&gt;
     *         ... Groovy code ...
     *        &lt;/script&gt;
     *      &lt;/operationBinding&gt;
     *    &lt;/operationBindings&gt;
     * 
     * 
     *   Scriptlets can be written in any language supported by the "JSR 223" standard, including Java
     *   itself. See the dmiOverview for rules on how to return data,
     *   add additional imports, and other settings.
     * 
     *   The following variables are available for DMI scriptlets:
     * 
     * 
     *  - dataSource: the current DataSource
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
     *  - beanFactory: the spring BeanFactory (when applicable)
     * 
     *  - cdiBeanManager: the CDI BeanManager (when applicable)
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
     *  - rpcManager: the current RPCManager
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
     *  Name of the web service operation that will be invoked in order to execute this DataSource
     *   operation.
     * 
     *   Valid only for a DataSource that has a WebService (DataSource.serviceNamespace is
     *   set). Otherwise, use OperationBinding.dataURL.
     * 
     *   Setting wsOperation means that DSRequest.data will be serialized as the
     *   request message for the specified web service operation, with namespacing and soap encoding
     *   handled automatically. See DataSource.transformRequest for how to customize what
     *   data is sent to the server.
     *  @type {string}
     *  @default null
     */
    open var wsOperation: String = definedExternally
    /**
     *  URL to contact to fulfill DSRequests for this operationBinding.
     * 
     *   dataURL is typically set as DataSource.dataURL rather than on each individual
     *   operationBinding.
     * 
     *   dataURL can be omitted for a DataSource using a Web Service
     *   (DataSource.serviceNamespace is set).
     *  @type {URL}
     *  @default null
     */
    open var dataURL: String = definedExternally
    /**
     *  Controls the format in which inputs are sent to the dataURL.
     * 
     *   When a DataSource operation such as fetchData() is invoked on this DataSource or a component
     *   bound to this DataSource, the data passed to the operation, if any, will be sent to the
     *   dataURL. The dataProtocol property controls the format in
     *   which the data is sent: SOAP message, HTTP GET or POST of parameters, etc.
     * 
     *   The dataProtocol property need not be set for a DataSource with a WebService
     *   ( DataSource.serviceNamespace is set), in this case, SOAP messaging is used by
     *   default.
     * 
     *   Developers may completely bypass the SmartClient comm system by setting dataProtocol to
     *   "clientCustom". In this case SmartClient will not attempt to send any data
     *   to the server after calling DataSource.transformRequest. Instead the developer is
     *   expected to implement transformRequest() such that it performs the necessary
     *   data action outside of SmartClient, and then calls DataSource.processResponse,
     *   passing in the DSRequest.requestId and an appropriate set of DSResponse properties to
     *   indicate the result of the action.
     * 
     *   NOTE: when OperationBinding.dataFormat is "iscServer", dataProtocol is not consulted.
     *   Instead, SmartClient uses a proprietary wire format to communicate with the SmartClient
     *   server, and the server-side DSRequest and DSResponse objects should be used to access
     *   request data and form responses.
     *  @type {DSProtocol}
     *  @default "getParams"
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
     *  Format for response data for this operation.
     * 
     *   Typically set once for the DataSource as a whole via DataSource.dataFormat.
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
     *  Transport to use for this operation. Defaults to DataSource.dataTransport, which in
     *   turn defaults to RPCManager.defaultTransport. This would typically only be set to
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
     *  Whether to use the RPCManager.sendProxied servlet to send requests
     *   described by this operationBinding. If unset, automatically detects whether using the
     *   HttpProxy is necessary based on the same-origin policy.
     * 
     *   Valid only with OperationBinding.dataProtocol settings other than ISCServer.
     *  @type {boolean}
     *  @default null
     */
    open var useHttpProxy: Boolean = definedExternally
    /**
     *  Applies only to dataFormat: "json". Specifies the name of the query parameter that
     *   tells your JSON service what function to call as part of the response for this operation.
     * 
     *   Typically set once for the DataSource as a whole via DataSource.callbackParam.
     *  @type {string}
     *  @default "callback"
     */
    open var callbackParam: String = definedExternally
    /**
     *  Additional properties to pass through to the DSRequest created for this operation.
     *   Note that these will be cumulative with and will override on a per-property basis any
     *   properties set via DataSource.requestProperties.
     * 
     *   These properties are applied before DataSource.transformRequest is called.
     *  @type {DSRequest}
     *  @default null
     */
    open var requestProperties: DSRequest = definedExternally
    /**
     *  Configures DataSource.preventHTTPCaching on a per-operationType basis.
     *  @type {boolean}
     *  @default null
     */
    open var preventHTTPCaching: Boolean = definedExternally
    /**
     *  HTTP parameters that should be submitted with every DSRequest.
     * 
     *   Useful for authenticated services that require a sessionId with every request.
     * 
     *   Can be set for all operations of a given DataSource as DataSource.defaultParams.
     *  @type {object}
     *  @default null
     */
    open var defaultParams: dynamic = definedExternally
    /**
     *  Setting useFlatFields on an operationBinding is equivalent to setting
     *   DSRequest.useFlatFields on all DataSource requests with the same OperationBinding.operationType
     *   as this operationBinding.
     * 
     *   Typical usage is to combine operationBinding.useFlatFields with
     *   DataBoundComponent.useFlatFields, with the SearchForm
     *   bound to the WebService.getInputDS of the web service operation set
     *   as OperationBinding.wsOperation. This allows gratuitous nesting to be consistently
     *   bypassed in both the user presentation and in the actual XML messaging.
     * 
     *   Note that useFlatFields is not generally recommended for use with input messages
     *   where multiple simple type fields exist with the same name, however if used in this way,
     *   the first field to use a given name wins. "first" means the first field encountered in a
     *   depth first search. "wins" means only the first field will be available in data binding,
     *   and only the first field will be populated in the generated XML message.
     *  @type {boolean}
     *  @default false
     */
    open var useFlatFields: Boolean = definedExternally
    /**
     *  A mapping from field names to SummaryFunction to be applied
     *   to each field.
     * 
     *   Valid only for an operation of type "fetch". See the
     *   serverSummaries for examples of usage.
     *  @type {object}
     *  @default null
     */
    open var summaryFunctions: dynamic = definedExternally
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
     *  For an XML or JSON DataSource, XPath expression used to retrieve the objects that will
     *   become DataSource records.
     * 
     *   For example, an "ItemSearch" web service might return a "Results" structure containing
     *   metadata along with the set of Items that one might want to display in a grid. An XPath
     *   expression like "/Results/Items" could be used to retrieve just the Items, which would then
     *   become DataSource records.
     * 
     *   For a JSON web service, the recordXPath is applied to the returned JSON data
     *   via XMLTools.selectObjects. Only limited XPath syntax is allowed; see
     *   XMLTools.selectObjects for details.
     * 
     *   For processing XML results, see OperationBinding.xmlNamespaces for information
     *   on the namespaces that are available in this XPath expression. If you are contacting a WSDL
     *   web service, note that OperationBinding.recordName is an alternative way to specify
     *   which records should be selected by their tagName or type, and this is usually simpler.
     * 
     *   To learn about XPath, try the following search:
     *   http://www.google.com/search?q=xpath+tutorial
     *  @type {XPathExpression}
     *  @default null
     */
    open var recordXPath: String = definedExternally
    /**
     *  For an XML DataSource, tagName of the elements to be used as records.
     * 
     *   This is a simple alternative to OperationBinding.recordXPath when the elements to be used as
     *   records all share a tagName.
     * 
     *   When a DataSource has a WebService, recordName can also be set to the name
     *   of any complexType declared within the WebService's WSDL file.
     *  @type {string}
     *  @default null
     */
    open var recordName: String = definedExternally
    /**
     *  For a DataSource contacting a DataSource.serviceNamespace, setting
     *   this flag means the DataSource doesn't actually attempt to contact the server but generates
     *   a sample response instead, based on the XML Schema of the response message embedded in the
     *   WSDL.
     * 
     *   The spoofed response will include all complexType elements and will fill in appropriate
     *   values by type for all simpleType elements, although the spoofed data will not conform to
     *   all xs:restriction declarations (eg xs:pattern).
     * 
     *   Note that if your WSDL does not fully describe the response format (some WSDL services just
     *   have a placeholder &lt;xs:any&gt; element), SmartClient can only produce a partial
     *   response. To use a hand-generated sample response, just save an XML file to disk and use
     *   the OperationBinding.dataURL setting to point to it.
     *  @type {boolean}
     *  @default false
     */
    open var spoofResponses: Boolean = definedExternally
    /**
     *  Optional object declaring namespace prefixes for use in OperationBinding.recordXPath and
     *   DataSourceField.valueXPath XPath expressions.
     * 
     *   xmlNamespaces should be specified as a mapping from namespace prefix to
     *   namespace URI, for example:
     * 
     *    xmlNamespaces : {
     *      az : "http://webservices.amazon.com/AWSECommerceService/2005-03-23"
     *    }
     * 
     *   By default, all namespaces declared on the document element (outermost element of the
     *   response) are made available with the prefix used in the document itself.
     * 
     *   Then, for non-WSDL-described XML results, if there is a default namespace on the document
     *   element, it is made available with the special prefix "default".
     * 
     *   For results of WSDL-described operations, the prefix "service" means the service namespace,
     *   that is, the "targetNamespace" on the &lt;definitions&gt; element from the WSDL file. The prefix
     *   "schema" means the namespace of the outermost element in the output message for the current
     *   operation. "default" will be the schema namespace if there is one, otherwise the service
     *   namespace.
     * 
     *   For basic information on XML Namespaces and their use in XPath, try the following search:
     *   http://www.google.com/search?q=XPath+xml+namespaces
     *  @type {object}
     *  @default null
     */
    open var xmlNamespaces: dynamic = definedExternally
    /**
     *  Optional schema describing how to extract DataSource records from the XML elements selected.
     * 
     *   Once a set of XML elements have been selected via recordXPath or
     *   recordName, those elements are normally transformed to JavaScript objects
     *   using the fields of the DataSource that owns the operationBinding. A
     *   responseDataSchema can be specified instead if the XML differs in some way between
     *   different DataSource operations, such that different values for
     *   DataSourceField.valueXPath may be necessary to extract the same
     *   DataSource record from slightly different XML structures.
     *  @type {DataSource}
     *  @default null
     */
    open var responseDataSchema: DataSource = definedExternally
    /**
     *  When set, causes the results of the DataSource Operation to be exported to a file, whose
     *   name and format are indicated by OperationBinding.exportFilename and
     *   OperationBinding.exportAs respectively. When no exportFilename is provided, the
     *   default is Results and the default value of exportAs is csv. Once the Operation
     *   completes, DSRequest.exportDisplay specifies whether the
     *   exported data will be downloaded to the file-system or displayed in a new window.  The
     *   default value of exportDisplay is "download" which displays the Save As dialog. See
     *   ExportDisplay for more information.
     * 
     *   The export field-list can also be configured, see DSRequest.exportFields.
     * 
     *   You can also configure the style of line-breaks to use when generating the output. See
     *   LineBreakStyle for more information.
     * 
     *   As well as setting this and other properties on the OperationBinding, Exports can be
     *   initiated in two other ways. You can set properties on the dsRequest by passing
     *   requestProperties into DataSource.exportData. Note that this method does
     *   not support exporting to JSON format (see
     *   this post for more detail).
     *   Additionally, custom server code may set export-related properties on the
     *   DSResponse.
     * 
     *   Format Examples
     * 
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
     *  The format in which the data should be exported. Default is "csv".
     *   See ExportFormat for more information.
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
     *  The name of the file to save the exported data into.
     *  @type {string}
     *  @default null
     */
    open var exportFilename: String = definedExternally
    /**
     *  The style of line-breaks to use in the exported output. See LineBreakStyle for
     *   more information.
     *  @type {string}
     *  @default null
     */
    open var lineBreakStyle: String = definedExternally
    /**
     *  The list of field-names to export. If provided, the field-list in the exported output is
     *   limited and sorted as per the list.
     * 
     *   If exportFields is not provided, the exported output includes all visible fields
     *   from the DataSource (field.hidden=false), sorted in the order they're defined.
     *  @type {Array<any>}
     *  @default null
     */
    open var exportFields: Array<dynamic> = definedExternally
    /**
     *  If true, causes requests against this operation to automatically start or join a transaction.
     *   if false, causes requests against this operation to be committed individually. If null,
     *   falls back to DataSource.autoJoinTransactions.
     * 
     *   See DataSource.autoJoinTransactions for further details of SmartClient's automatic
     *   transaction control.
     *  @type {boolean}
     *  @default null
     */
    open var autoJoinTransactions: Boolean = definedExternally
    /**
     *  Sets or clears the useSpringTransaction flag for this specific operation.
     * 
     *   See DataSource.useSpringTransaction for details of the Spring transaction integration
     *   feature
     *  @type {boolean}
     *  @default null
     */
    open var useSpringTransaction: Boolean = definedExternally
    /**
     *  This feature is available with Power or better licenses only. See
     *   smartclient.com/product for details.
     * 
     *   For a dataSource of DataSource.serverType "sql", this
     *   property can be specified on an operationBinding to provide the server with a bespoke
     *   SELECT clause to use when constructing the SQL query to perform this operation. The
     *   property should be a comma-separated list of column names and/or expressions, and you
     *   can refer to any scalar function supported by the underlying database. The server will
     *   insert the text of this property immediately after the "SELECT" token.
     * 
     *   Note that if you also specify a OperationBinding.groupClause, you can use aggregate
     *   functions such as SUM and COUNT in the selectClause.
     * 
     *   This property is only applicable to operationBindings of
     *   OperationBinding.operationType "fetch".
     * 
     *   See the documentation for OperationBinding.customSQL for usage examples
     *  @type {string}
     *  @default null
     */
    open var selectClause: String = definedExternally
    /**
     *  This feature is available with Power or better licenses only. See
     *   smartclient.com/product for details.
     * 
     *   For a dataSource of DataSource.serverType "sql", this
     *   property can be specified on an operationBinding to provide the server with a bespoke
     *   table clause to use when constructing the SQL query to perform this operation. The
     *   property should be a comma-separated list of tables and views, and you can use any
     *   special language constructs supported by the underlying database. The server will
     *   insert the text of this property immediately after the "FROM" token.
     * 
     *   See the documentation for OperationBinding.customSQL for usage examples
     *  @type {string}
     *  @default null
     */
    open var tableClause: String = definedExternally
    /**
     *  This feature is available with Power or better licenses only. See
     *   smartclient.com/product for details.
     * 
     *   For a dataSource of DataSource.serverType "sql", this
     *   property can be specified on an operationBinding to provide the server with a bespoke
     *   WHERE clause to use when constructing the SQL query to perform this operation. The
     *   property should be a valid expression in the syntax of the underlying database. The
     *   server will insert the text of this property immediately after the "WHERE" token.
     * 
     *   You may find the SmartClient-provided $criteria variable of particular use with
     *   this property.
     * 
     *   See the documentation for OperationBinding.customSQL for usage examples
     *  @type {string}
     *  @default null
     */
    open var whereClause: String = definedExternally
    /**
     *  This feature is available with Power or better licenses only. See
     *   smartclient.com/product for details.
     * 
     *   For a dataSource of DataSource.serverType "sql", this
     *   property can be specified on an operationBinding to provide the server with a bespoke
     *   GROUP BY clause to use when constructing the SQL query to perform this operation. The
     *   property should be a comma-separated list of column names and/or expressions, forming
     *   a valid GROUP BY clause in the syntax of the underlying database. The server will
     *   insert the text of this property immediately after the "GROUP BY" token.
     * 
     *   Note that specifying this property enables you to use aggregate functions (such as
     *   COUNT and SUM) in your OperationBinding.selectClause. Also note that care is required
     *   when using groupClause to ensure that the selectClause contains the fields you are grouping
     *   by. Failure to do this correctly will result in a runtime SQL error.
     * 
     *   This property is only applicable to operationBindings of
     *   OperationBinding.operationType "fetch".
     * 
     *   See the documentation for OperationBinding.customSQL for usage examples
     *  @type {string}
     *  @default null
     */
    open var groupClause: String = definedExternally
    /**
     *  This feature is available with Power or better licenses only. See
     *   smartclient.com/product for details.
     * 
     *   For a dataSource of DataSource.serverType "sql", this
     *   property can be specified on an operationBinding to provide the server with a bespoke
     *   ORDER BY clause to use when constructing the SQL query to perform this operation. The
     *   property should be a comma-separated list of column names and/or expressions, forming
     *   a valid ORDER BY clause in the syntax of the underlying database. The server will
     *   insert the text of this property immediately after the "ORDER BY" token.
     * 
     *   This property is only applicable to operationBindings of
     *   OperationBinding.operationType "fetch".
     * 
     *   See the documentation for OperationBinding.customSQL for usage examples
     *  @type {string}
     *  @default null
     */
    open var orderClause: String = definedExternally
    /**
     *  This feature is available with Power or better licenses only. See
     *   smartclient.com/product for details.
     * 
     *   For a dataSource of DataSource.serverType "sql", this
     *   property can be specified on an operationBinding to provide the server with a bespoke
     *   set of values to add or update, for use when constructing the SQL query to perform this
     *   operation. The property should be one of the following, depending on the
     *   OperationBinding.operationType:
     * 
     *   For "add" operations, the syntax that would be valid for an INSERT INTO query: a
     *   comma-separated list of column names enclosed in parentheses, followed by a comma-separated
     *   list of new values, enclosed in parentheses and preceded by the token "VALUES". For example:
     * 
     *   &lt;valuesClause&gt;(name, age) VALUES("Jane Doe", 48)&lt;/valuesClause&gt;
     * 
     *   For "update" operations, the syntax that would be valid for an UPDATE query: a
     *   comma-separated list of expressions equating a column name to its new value. For example:
     * 
     *   &lt;valuesClause&gt;name="Jane Doe", age=48&lt;/valuesClause&gt;
     * 
     *   You may find the SmartClient-provided $values variable of particular use with
     *   this property.
     * 
     *   See the documentation for OperationBinding.customSQL for usage examples
     *  @type {string}
     *  @default null
     */
    open var valuesClause: String = definedExternally
    /**
     *  This feature is available with Power or better licenses only. See
     *   smartclient.com/product for details.
     * 
     *   For a dataSource of DataSource.serverType "sql" or "hibernate", this
     *   property can be specified on an operationBinding to indicate that the server should run
     *   user-specified SQL, rather than the query it would normally generate to satisfy a
     *   dataSource operation. This property allows you to provide a fully-customized query; an
     *   alternative is to provide custom "pieces" to the query generator, via properties such as
     *   OperationBinding.whereClause and OperationBinding.valuesClause. See the
     *   customQuerying for more details.
     * 
     *   For a dataSource of type "sql", the SmartClient server generates a number of useful
     *   DefaultQueryClause,
     *   and makes them available to your custom SQL code via the Velocity templating
     *   language (note that this is not available for "hibernate" dataSources).
     * 
     *   We also make the template variables $criteria and $values available, to give
     *   you direct access to the supplied criteria, and to the new field values for update and add
     *   operations. These variables are available to both "sql" and "hibernate" dataSources.
     * 
     *   Note that you should use this feature with care. In particular, writing customSQL code
     *   that makes use of a particular database engine's features or syntax will make your
     *   application less portable.
     * 
     *   See customQuerying for an overview of writing custom queries and clauses.
     * 
     *   Examples
     *   An example using the SmartClient-supplied query pieces. This custom query will give
     *   exactly the same result as the SmartClient-generated query:
     * 
     * 
     *   &lt;operationBinding operationId="customFetch" operationType="fetch"&gt;
     *   &nbsp;&nbsp;&lt;customSQL&gt;
     *   &nbsp;&nbsp;&nbsp;&nbsp;SELECT $defaultSelectClause FROM $defaultTableClause
     *   WHERE $defaultWhereClause ORDER BY $defaultOrderClause
     *   &nbsp;&nbsp;&lt;/customSQL&gt;
     *   &lt;/operationBinding&gt;
     * 
     * 
     *   An example using the SmartClient-supplied $criteria template variable:
     * 
     * 
     *   &lt;operationBinding operationId="customFetch" operationType="fetch"&gt;
     *   &nbsp;&nbsp;&lt;customSQL&gt;
     *   &nbsp;&nbsp;&nbsp;&nbsp;SELECT foo, bar, baz FROM MyTable WHERE bar &gt; $criteria.someValue
     *   &nbsp;&nbsp;&lt;/customSQL&gt;
     *   &lt;/operationBinding&gt;
     * 
     * 
     *   An update example:
     * 
     * 
     *   &lt;operationBinding operationId="myUpdateOp" operationType="update"&gt;
     *   &nbsp;&nbsp;&lt;customSQL&gt;
     *   &nbsp;&nbsp;&nbsp;&nbsp;UPDATE $defaultTableClause SET $defaultValuesClause WHERE bar
     *   &lt;= $criteria.someValue
     *   &nbsp;&nbsp;&lt;/customSQL&gt;
     *   &lt;/operationBinding&gt;
     * 
     *  @type {string}
     *  @default null
     */
    open var customSQL: String = definedExternally
    /**
     *  This feature is available with Power or better licenses only. See
     *   smartclient.com/product for details.
     * 
     *   For a dataSource of DataSource.serverType "hibernate", this
     *   property can be specified on an operationBinding to indicate that the server should run
     *   user-specified HQL (Hibernate Query Language), rather than the Hibernate criteria query or
     *   saveOrUpdate call it would normally generate to satisfy a dataSource operation
     *   via Hibernate.
     * 
     *   Note that inserting new records via HQL is often impractical, due to intentional restrictions
     *   in the language (it is only possible to perform an insert expressed in terms of a SELECT; the
     *   "VALUES" construct commonly used when inserting new rows singly is not supported). If you are
     *   intending to use customHQL, we recommend that you avoid doing so for OperationBindings
     *   with OperationBinding.operationType "add", unless you have a special
     *   requirement such as a bulk insert; if you need custom queries to perform inserts
     *   on "hibernate" dataSources, we recommend you use OperationBinding.customSQL,
     *   which is valid for "hibernate" DataSources as well as "sql" dataSources.
     * 
     *   For other operations on "hibernate" dataSources, however, HQL has the advantage of
     *   being more portable across different database engines than is plain SQL.
     * 
     *   Note that using customHQL affects paging implementation. If you use it, full data set is fetched
     *   from Hibernate and records that aren't in the requested range are dropped at the server side.
     *  @type {string}
     *  @default null
     */
    open var customHQL: String = definedExternally
    /**
     *  This feature is available with Power or better licenses only. See
     *   smartclient.com/product for details.
     * 
     *   For a dataSource of DataSource.serverType "jpa", this
     *   property can be specified on an operationBinding to indicate that the server should run
     *   user-specified JQL (Java Persistence Query Language).
     * 
     *   Note that inserting new records via JQL is often impractical, due to intentional restrictions
     *   in the language (it is only possible to perform an insert expressed in terms of a SELECT; the
     *   "VALUES" construct commonly used when inserting new rows singly is not supported). If you are
     *   intending to use customJQL, we recommend that you avoid doing so for OperationBindings
     *   with OperationBinding.operationType "add", unless you have a special
     *   requirement such as a bulk insert; if you need custom queries to perform inserts
     *   on "jpa" dataSources, we recommend you use OperationBinding.customSQL,
     *   which is valid for "jpa" DataSources as well as "sql" dataSources.
     * 
     *   For other operations on "jpa" dataSources, however, JQL has the advantage of
     *   being more portable across different database engines than is plain SQL.
     * 
     *   Note that using customJQL affects paging implementation. If you use it, full data set is fetched
     *   from JPA and records that aren't in the requested range are dropped at the server side.
     *  @type {string}
     *  @default null
     */
    open var customJQL: String = definedExternally
    /**
     *  This feature is available with Power or better licenses only. See
     *   smartclient.com/product for details.
     * 
     *   For a dataSource of DataSource.serverType "jpa" or "hibernate", this
     *   property can be specified on an operationBinding to indicate that the server should execute
     *   a named query which has already been defined on an entity.
     * 
     *    &#64;Entity
     *    &#64;Table (name="Countries")
     *    &#64;NamedQuery(name = "Country.withPopulationLessThan", query = "SELECT country FROM Country country WHERE country.population &lt; :population")
     *    public class Country { ... }
     * 
     * 
     * 
     *    &lt;operationBindings&gt;
     *      &lt;operationBinding operationType="custom" operationId="withPopulationLessThan" namedQuery="Country.withPopulationLessThan"/&gt;
     *    &lt;/operationBindings&gt;
     * 
     *   Substitution values can be used in order to build more dynamic named queries. When calling
     *   DataSource.performCustomOperation the values are passed in using the data argument.
     * 
     *   Note that value substitution for named queries is slightly different to other custom queries.
     *   Because of the way the persistence API works the JQL query written in the &#64;NamedQuery annotation
     *   can only contain basic parameter names such as "population". Therefore the value substitution
     *   becomes a simple name based mapping.
     * 
     *   Examples
     *   Using Simple Criteria
     * 
     *   An example using a simple criteria for the above defined Country entity. In this case the named
     *   query parameter ":population" will be swapped out for the value of the criteria objects "population"
     *   field.
     * 
     *    var criteria = {
     *      population: 596000
     *    };
     * 
     *    countryDataSource.performCustomOperation("withPopulationLessThan", criteria);
     * 
     * 
     *   Using Advanced Criteria
     * 
     *   If an advanced criteria is detected, access to all "fieldName" variables and their values will
     *   be provided but still using simple name based mapping. In the below case only the deep-first
     *   occurrence of the "population" fieldName will available. The operator is effectively ignored.
     * 
     *    var criteria = {
     *      _constructor: "AdvancedCriteria",
     *      operator:"or",
     *      criteria:[
     *        {
     *          fieldName:"population",
     *          operator:"lessThan",
     *          value: 12000
     *        },
     *        {
     *          fieldName:"name",
     *          operator:"equals",
     *          value: "Sweden"
     *        },
     *        {
     *          _constructor: "AdvancedCriteria",
     *          operator:"and",
     *          criteria:[
     *            {
     *              fieldName:"population",
     *              operator:"lessThan",
     *              value: 0
     *            }
     *          ]
     *        }
     *      ]
     *    };
     * 
     *    countryDataSource.performCustomOperation("withPopulationLessThan", criteria);
     * 
     * 
     *   Note
     *   Using namedQuery affects paging implementation. If you use it, full data set is fetched
     *   from JPA and records that aren't in the requested range are dropped at the server side.
     *  @type {string}
     *  @default null
     */
    open var namedQuery: String = definedExternally
    /**
     *  A SQLDataSource will normally issue two queries for a "fetch" operation when paging is
     *   enabled: one to determine the total rows available (the "row count query"), and one to fetch
     *   the specific range of rows requested.
     * 
     *   Setting skipRowCount="true" will avoid the "row count query", but as a consequence
     *   DSResponse.totalRows will be set to match the requested DSRequest.endRow since
     *   the totalRows is unknown. You can avoid this by using a
     *   OperationBinding.sqlPaging of "jdbcScroll" or "dropAtServer", but be
     *   aware that these paging strategies can introduce significant delays when used with
     *   potentially large datasets (in fact, "dropAtServer" is almost guaranteed to do so if used
     *   with datasets of more than 1000 or so rows)
     * 
     *   As an alternative, consider enabling
     *   DataSource.progressiveLoading, which avoids doing a query for row
     *   counts, but will still allow the user to load more results using the scrollbar if viewing
     *   results in a ListGrid.
     *  @type {boolean}
     *  @default null
     */
    open var skipRowCount: Boolean = definedExternally
    /**
     *  Indicates that the listed fields should be included in the default
     *   OperationBinding.selectClause and OperationBinding.selectClause generated for this
     *   operationBinding, even if they are marked DataSourceField.customSQL="true".
     * 
     *   If you need to apply different sets of overrides for the selectClause and the
     *   whereClause, use OperationBinding.customValueFields and/or
     *   OperationBinding.customCriteriaFields instead. If you specify both
     *   customFields and customCriteriaFields or
     *   customValueFields, the more specific variant wins. If you specify both
     *   customFields and OperationBinding.excludeCriteriaFields,
     *   customFields wins (this is another use case when you may wish to use
     *   customValueFields instead)
     * 
     *   You can specify this property as a comma-separated list (eg, "foo, bar, baz") or by just
     *   repeating the &lt;customFields&gt; tag multiple times with one field each.
     * 
     *   This property is only applicable to DataSources of DataSource.serverType.
     *  @type {string | Array<any>}
     *  @default null
     */
    open var customFields: dynamic = definedExternally
    /**
     *  Indicates that the listed fields should be included in the default
     *   OperationBinding.selectClause generated for this operationBinding, even if they are marked
     *   DataSourceField.customSQL="true".
     * 
     *   You can specify this property as a comma-separated list (eg, "foo, bar, baz") or by just
     *   repeating the &lt;customValueFields&gt; tag multiple times with one field each.
     * 
     *   This property is only applicable to DataSources of DataSource.serverType.
     *  @type {string | Array<any>}
     *  @default null
     */
    open var customValueFields: dynamic = definedExternally
    /**
     *  Indicates that the listed fields should be included in the default
     *   OperationBinding.whereClause generated for this operationBinding, even if they are marked
     *   DataSourceField.customSQL.
     * 
     *   You can specify this property as a comma-separated list (eg, "foo, bar, baz") or by just
     *   repeating the &lt;customCriteriaFields&gt; tag multiple times with one field each.
     * 
     *   This property is only applicable to DataSources of DataSource.serverType.
     *  @type {string | Array<any>}
     *  @default null
     */
    open var customCriteriaFields: dynamic = definedExternally
    /**
     *  Indicates that the listed fields should be excluded from the default
     *   OperationBinding.whereClause generated for this operationBinding.
     * 
     *   This enables you to use these fields in a customQuerying while
     *   still allowing the $defaultWhereClause to be generated for all other fields. For example,
     *   you might take a particular field and apply it in the WHERE clause of a subquery.
     * 
     *   You can specify this property as a comma-separated list (eg, "foo, bar, baz") or by just
     *   repeating the &lt;customCriteriaFields&gt; tag multiple times with one field each.
     *   Note that if a field is included in both excludeCriteriaFields and
     *   OperationBinding.customCriteriaFields, customCriteriaFields
     *   wins.
     * 
     *   This property is only applicable to DataSources of DataSource.serverType.
     *  @type {string | Array<any>}
     *  @default null
     */
    open var excludeCriteriaFields: dynamic = definedExternally
    /**
     *  For an operationBinding of OperationBinding.operationType "fetch" which specifies no
     *   OperationBinding.operationId, this property determines whether the operationBinding
     *   should be used for cache synchronization purposes (ie, to retrieve the record most recently
     *   added or changed). This property has no effect on an operationBinding that specifies an
     *   operationId - see OperationBinding.cacheSyncOperation.
     * 
     *   In order to work correctly with SmartClient's cache synchronization system, an
     *   operationBinding marked useForCacheSync should have the following properties:
     * 
     * 
     *  - Able to complete its retrieval using no context other than the values of the primary key
     *   fields declared in the dataSource (these will be provided in the $criteria object passed to
     *   the operation)
     * 
     *  - Returns the entire record, including any values that may require joins to other tables
     *   or other complexities
     * 
     *   This property is only applicable to DataSources of type "sql".
     *  @type {boolean}
     *  @default true
     */
    open var useForCacheSync: Boolean = definedExternally
    /**
     *  For an operationBinding of OperationBinding.operationType "add" or "update", this
     *   property is the OperationBinding.operationId of a "fetch" operationBinding to use
     *   for cache synchronization purposes (ie, to fetch the row most recently added or changed).
     *   This property, along with OperationBinding.useForCacheSync and
     *   OperationBinding.canSyncCache is provided so that you can use custom database operations
     *   without sacrificing the benefits of SmartClient's automatic cache synchronization.
     * 
     *   This property is only applicable to DataSources of type "sql".
     *  @type {string}
     *  @default null
     */
    open var cacheSyncOperation: String = definedExternally
    /**
     *  For an operation of type "add" or "update", a SQLDataSource will normally obtain
     *   data to return to the client by performing the "cacheSyncOperation": a SELECT statement that
     *   retrieves the modified record by primary key. This accommodates sequence columns, columns
     *   with default values, database triggers and other database features that may modify data
     *   after insertion or update.
     * 
     *   Certain major SQL customizations can prevent the SQLDataSource from authoritatively
     *   determining the primary key used in the SQL statement, such that re-selecting the saved
     *   record may fail. By default, when canSyncCache has not been explicitly
     *   set, in the following cases it is assumed that the normal cacheSyncOperation cannot be used:
     * 
     * 
     *  - &lt;customSQL&gt; has been used to define an entirely custom query
     * 
     *  - a custom &lt;whereClause&gt; has been defined for an "update" or "remove" operation
     * 
     *  - a custom &lt;valuesClause&gt; has been defined for an "add" operation
     * 
     *   If any of these cases apply or if canSyncCache has been set false, the server
     *   will skip the cacheSyncOperation and return a DSResponse where
     *   DSResponse.invalidateCache has been set to true to notify client-side components that
     *   they may need to refresh their entire cache.
     * 
     *   Alternatively, if the default re-selection behavior will not work but a customized SQL
     *   query would work, you can define that SQL operation as another operationBinding and use
     *   OperationBinding.cacheSyncOperation to declare that it should be used. Setting
     *   cacheSyncOperation implicitly sets canCacheSync to true.
     * 
     *   This property is only applicable to DataSources of type "sql".
     *  @type {boolean}
     *  @default null
     */
    open var canSyncCache: Boolean = definedExternally
    /**
     *  For an operation of type "add" or "update", a SQLDataSource will normally obtain data to
     *   return to the client by performing the OperationBinding.cacheSyncOperation. In certain edge cases
     *   this is either not possible or causes problems (such as record locks); in this case, you
     *   mark the operation with OperationBinding.canSyncCache: false to inhibit this automatic behavior.
     *   However, this gives you an operation that does not properly cooperate with the client in
     *   keeping client-side caches fresh, which in turn leads to an application that must perform
     *   more server turnarounds and explicit database fetches.
     * 
     *   It is possible that the data needed for cache synchronization could be obtained by
     *   application code running in a DMI or serverScript,
     *   even if the normal automatic cache synchronization will not work. However, such application
     *   code is almost certainly going to need to know the primary key(s) of any newly added
     *   record(s).
     * 
     *   When makeKeysAvailable is true, SmartClient Server will go through the process
     *   of obtaining generated keys in accordance with the SequenceMode, even if
     *   canSyncCache is false (note, "in accordance with the sequenceMode"
     *   implies that we do not attempt to get keys if the sequenceMode is "none").
     *   The keys used in the operation (both generated keys, if any, and any keys provided in the
     *   operation's criteria or values) will be stored on the DSResponse and your
     *   server-side DMI or script will have access to them via the server API
     *   dsResponse.getKeys(). Please see the server-side documentation for that
     *   method for further details.
     * 
     *   Note, if you are using SequenceMode "jdbcDriver", the keys are available to SmartClient
     *   Server at no cost, so makeKeysAvailable is always true. If you are using
     *   sequenceMode "native", a separate native query must be run to obtain the keys.
     *   The overhead of this native query is likely to be insignificant, but because it is an extra
     *   step that you may not want or need, makeKeysAvailable defaults to false in
     *   this case. You can override this by adding setting
     *   sql.always.makeKeysAvailable:true to your server.properties file.
     * 
     *   This property is only applicable to DataSources of type "sql".
     *  @type {boolean}
     *  @default "See below"
     */
    open var makeKeysAvailable: Boolean = definedExternally
    /**
     *  For dataSources of DataSource.serverType "sql" and "hibernate" only, this
     *   property determines whether "custom" operations have their custom SQL or HQL sent to the
     *   underlying database via a JDBC executeQuery() or a JDBC
     *   executeUpdate(). The default value of null means the same as "query", so you
     *   only need to use this property when your custom SQL or HQL updates data.
     *  @type {SQLType}
     *  @default null
     */
    open var sqlType: 
                      /**
                       *  The custom SQL or HQL is read-only
                       *  The custom SQL or HQL updates data
                       */
                      String /* query |  update */ = definedExternally
    /**
     *  Ordinarily, "update" and "remove" operations are only allowed for DataSources
     *   that have a DataSourceField.primaryKey, and all primary key values
     *   are present in the request. This is because an update of a DataSource with no primary key,
     *   or an update request that has missing primary key values, cannot be guaranteed to affect
     *   only one record.
     * 
     *   Setting this property on an operationBinding circumvents this restriction for that operation
     *   only.
     * 
     *   Warning: Be aware that this is a potentially dangerous setting and should be used
     *   with care. With this flag set, you have no guarantee that an update will not change or
     *   remove every row in a table.
     * 
     *   Also, running allowMultiUpdate operations directly from the client is not
     *   straightforward because it requires the ability to specify criteria and values separately
     *   in the request, which is not currently supported. This can be worked around in various
     *   ways, but really allowMultiUpdate is primarily intended for server-side
     *   operations. Therefore, the recommended pattern is to use a
     *   DataSource.performCustomOperation from the client to invoke a DMI on
     *   the server which performs the multi-update operation via a second, server-side DSRequest.
     *  @type {boolean}
     *  @default null
     */
    open var allowMultiUpdate: Boolean = definedExternally
    /**
     *  Ordinarily, "update" and "remove" operations are only allowed if all primary key values
     *   are present in the request. This is because an update request that has missing primary
     *   key values cannot be guaranteed to affect only one record.
     * 
     *   Setting this property on an operationBinding circumvents this restriction for that operation
     *   only. Note, this property differs from OperationBinding.allowMultiUpdate in its
     *   intent: allowMultiUpdate tells the framework that this operation deliberately
     *   affects multiple records; providesMissingKeys tells the framework that this
     *   operation will only affect one record, and will ensure this by providing values for missing
     *   keys during its operation. Unlike allowMultiUpdate, setting this flag does not
     *   cause component caches to be ListGrid.invalidateCache
     * 
     *   Providing values for missing keys can be done in various ways:
     * 
     *  - Operations that specify &lt;OperationBinding.customSQL&gt; or
     *     &lt;OperationBinding.whereClause&gt; can provide missing
     *     key values from session storage or elsewhere in the provided record
     * 
     *  - Operations that specify &lt;serverScript&gt; can provide
     *     arbitrary code to manipulate the record in whatever way they like before executing the
     *     underlying built-in functionality
     * 
     *  - Operations can specify &lt;OperationBinding.criteria&gt;
     *     to provide missing keys
     * 
     *  - A request can contain DSRequest.fieldValueExpressions,
     *     which can be used to provide values for missing keys
     * 
     *   Note, you can also use a regular dmiOverview to arbitrarily manipulate the
     *   record sent from the client, including providing values for any missing keys. If you do
     *   this, you do not need to specify providesMissingKeys because the request is
     *   not validated for the presence of key values until after the DMI has run.
     * 
     *   Warning: Be aware that this is a potentially dangerous setting and should be used
     *   with care. With this flag set, the framework cannot guarantee that an update will not
     *   change or remove every row in a table: it becomes your code's responsibility to ensure
     *   that all PK values are provided to the operation by the time it actually needs them.
     *  @type {boolean}
     *  @default null
     */
    open var providesMissingKeys: Boolean = definedExternally
    /**
     *  Specifies, for this specific operationBinding, whether to qualify column names with table
     *   names in any SQL we generate. Overrides the DataSource.qualifyColumnNames property.
     *   Only applicable to dataSources of DataSource.serverType "sql".
     *  @type {boolean}
     *  @default true
     */
    open var qualifyColumnNames: Boolean = definedExternally
    /**
     *  If set, every invocation of this operationBinding will invalidate the local cache, forcing
     *   a server visit to refresh the data.
     *  @type {boolean}
     *  @default null
     */
    open var invalidateCache: Boolean = definedExternally
    /**
     *  Specifies, for this operationBinding only, the list of field names that should be returned
     *   to the client. Typically this will be a subset of the DataSource.fields, but note
     *   that this is not a requirement; outputs can include fields that are not defined
     *   in the DataSource's field list. In this case, the server will return extra fields even if
     *   DataSource.dropExtraFields is true.
     * 
     *   You specify this property as a string containing a comma-separated list of field names
     *   (eg, "foo, bar, baz")
     *  @type {string}
     *  @default null
     */
    open var outputs: String = definedExternally
    /**
     *  The paging strategy to use for this specific OperationBinding. If this property is not
     *   set, we fall back to the DataSource.sqlPaging value, and the defaults described in
     *   the documentation for that property.
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
     *  If explicitly set true or false, forces the use of a "hint" in the SQL we generate for paged
     *   queries on or off as appropriate. If not set, defaults to the
     *   DataSource.sqlUsePagingHint value. Note this property is only applicable to
     *   DataSource.serverType DataSources, only when a
     *   DataSource.sqlPaging of "sqlLimit" is in force, and it only has an
     *   effect for those specific database products where we employ a native hint in the generated
     *   SQL in an attempt to improve performance.
     *  @type {boolean}
     *  @default null
     */
    open var sqlUsePagingHint: Boolean = definedExternally
    /**
     *  Whether to use the subselect technique (see DataSource.useSubselectForRowCount for
     *   details) to derive a rowcount query for this operation. If this property is not
     *   set, we fall back to the useSubselectForRowCount setting on the DataSource,
     *   and the defaults described in the documentation for that property.
     *  @type {boolean}
     *  @default null
     */
    open var useSubselectForRowCount: Boolean = definedExternally
    /**
     *  Sets DataSource.progressiveLoading for this particular
     *   operation, overriding the DataSource-level setting. Note that this setting applies only
     *   to fetch operations - it has no effect if specified on any other kind of operation.
     *  @type {boolean}
     *  @default null
     */
    open var progressiveLoading: Boolean = definedExternally
    /**
     *  This property indicates whether this operation supports AdvancedCriteria. This setting
     *   overrides DataSource.allowAdvancedCriteria for this operation only. See
     *   DataSource.supportsAdvancedCriteria for further information.
     * 
     *   NOTE: If you specify this property in a DataSource descriptor
     *   (.ds.xml file), it is enforced on the server. This means that if you run
     *   a request containing AdvancedCriteria against an OperationBinding that advertises itself
     *   as allowAdvancedCriteria:false, it will be rejected.
     *  @type {boolean}
     *  @default null
     */
    open var allowAdvancedCriteria: Boolean = definedExternally
    /**
     *  Elements of this feature are only available with Power or better licenses. See
     *   smartclient.com/product for details.
     * 
     *   A list of DSRequestModifiers that will be used to modify the criteria of each
     *   DSRequest that uses this operationBinding. Note that the criteria elements are
     *   applied to DSRequest criteria as follows:
     * 
     * 
     *  - Simple criteria: The field and value are just applied as an extra key/value
     *   pair in the criteria map, as long as the DSRequestModifier.operator
     *   attribute is left unset, or is set to "equals". For any other setting of
     *   operator, the criteria is first converted to the equivalent AdvancedCriteria
     *   and then processed as described below
     * 
     *  - AdvancedCriteria: If the topmost operator is "and", we add the new criterion
     *   as an additional criterion directly in the existing list. Otherwise, we create a new
     *   top-level AdvancedCriteria with an operator of "and". This is then set to have two
     *   elements in its criteria: the previous top-level criteria and the new criterion.
     * 
     *   The effect of this is to apply any criteria specifed here as additional constraints on top
     *   of what the user has specified, and of course, the user is unable to affect this. Thus,
     *   this is a suitable and convenient place to enforce rules such as "Users can only ever see
     *   their own records".
     *   Below is an example of the XML as it should be defined in your ds.xml, datasource
     *   definitions.
     *   &lt;operationBindings&gt;
     *    &lt;operationBinding operationType="fetch" operationId="..."&gt;
     *     &lt;criteria fieldName="USER_ROLE" value="ADMIN" operator="equals" /&gt;
     *    &lt;/operationBinding&gt;
     *   &lt;/operationBindings&gt;
     * 
     *  @type {Array<Partial<DSRequestModifier>>}
     *  @default null
     */
    open var criteria: Array<dynamic> = definedExternally
    /**
     *  Elements of this feature are only available with Power or better licenses. See
     *   smartclient.com/product for details.
     * 
     *   A list of DSRequestModifiers that will be used to modify the values object of each
     *   DSRequest that uses this operationBinding. See this example:
     *   ${isc.DocUtils.linkForExampleId('queuedAdd')}.
     *   Below example of the xml as it should be defined in ds.xml:
     *   &lt;operationBinding operationType="add"&gt;
     *    &lt;values fieldName="orderID" value="$responseData.last('queuedAdd_order','add').orderID" /&gt;
     *   &lt;/operationBinding&gt;
     *  @type {Array<Partial<DSRequestModifier>>}
     *  @default null
     */
    open var values: Array<dynamic> = definedExternally
    /**
     *  Whether a user must be authenticated in order to access this operation. For details of
     *   what is meant by "authenticated", see DataSource.requiresAuthentication.
     * 
     *   To protect access to an entire operationType (eg, all "fetch" operations), declare an
     *   operationBinding with requiresAuthentication="true", OperationBinding.operationType set
     *   to the operationType to be protected, but no OperationBinding.operationId. This will then
     *   prevent access to the "fetch" operationType unless another OperationBinding
     *   declares requiresAuthentication="false" with a specific
     *   OperationBinding.operationId.
     *  @type {boolean}
     *  @default null
     */
    open var requiresAuthentication: Boolean = definedExternally
    /**
     *  Comma-separated list of user roles that are allowed to invoke the operation described by
     *   this operationBinding. If the current user has any of the roles listed, they can
     *   invoke the operation. Also note that authentication.superuserRole can be
     *   specified in the server_properties file. If set this denotes a "super user"
     *   role - any user with that role will have access to all operations, regardless of the
     *   "requiresRole" settings for the operation.
     * 
     *   Whether the current user has a given role is determined by calling the standard Java
     *   servlets method httpServletRequest.isUserInRole(), hence works with both simple
     *   J2EE security (realms and form-based authentication) and JAAS (Java Authentication &
     *   Authorization Service).
     * 
     *   If you wish to use a role-based security scheme that does not make use of the servlet API's
     *   standards, SmartClient Server also implements the setAuthenticated and
     *   setUserRoles methods on RPCManager.
     *   You can use this API to tell SmartClient that all the requests in the queue currently
     *   being processed are associated with a user who has the roles you supply; in this case,
     *   SmartClient will not attempt to resolve the user's roles via
     *   httpServletRequest.isUserInRole(). When taking this approach, the
     *   rpcManager.setUserRoles() method should be called on the server for
     *   each transaction received from the client. We recommend doing this by overriding the
     *   special IDACall servlet and checking server side state to determine the current user's
     *   roles, calling the API, and then calling handleDSRequest() or
     *   handleRPCRequest() directly to handle the request(s) passed in.
     *   Here's an example of this approach which assumes the current user's roles has been
     *   set directly on the HttpSession object as a comma-separated-string attribute "roles":
     * 
     *   public class SecureIDACall extends IDACall {
     *   
     *     public void processRequest(HttpServletRequest request,
     *         HttpServletResponse response)
     *      throws ServletException, IOException
     *     {
     *       HttpSession session = request.getSession();
     *       Object roles = session == null ? null : session.getAttribute("roles");
     *   
     *       if (roles != null) {
     *         try {
     *           RequestContext context = RequestContext.instance(this, request, response);  
     *           RPCManager rpc = new RPCManager(request, response);
     *           rpc.setAuthenticated(true);
     *           rpc.setUserRoles((String) roles); 
     *           
     *           // call processRPCTransaction() to iterate through all RPCRequests and
     *           // DSRequests and execute them
     *           processRPCTransaction(rpc, context);
     *   
     *         } catch (Throwable e) {
     *           handleError(response, e);
     *         }
     *       } else {
     *         super.processRequest(request, response);
     *       } 
     *     }
     *   }
     * 
     * 
     *   If there is an operationBinding declared for a given operationType which does not have an
     *   OperationBinding.operationId, that is, it is the default operationBinding for the type, then any other
     *   operationBinding of the same type is assumed to have the same setting for
     *   requiresRole as the default operationBinding for the operationType. For
     *   example, given these declarations:
     * 
     *     &lt;operationBinding operationType="fetch" requiresRole="manager"&gt;
     *        ... settings ...
     *     &lt;/operationBinding&gt;
     *     &lt;operationBinding operationType="fetch" operationId="fetchWithExtraFields"&gt;
     *        ... settings ...
     *     &lt;/operationBinding&gt;
     * 
     *   The second operationBinding requires the "manager" role even though there is no explicit
     *   requiresRole declaration. To prevent the "manager" role being required by the
     *   second operationBinding, add requireRole="".
     * 
     *   Note that if DataSource.requiresRole is set, all operations on the DataSource require
     *   the roles set for the DataSource as a whole, even if they declare individual
     *   requiresRole attributes.
     * 
     *   This property is valid only for a server-side DataSource when using the SmartClient Server.
     * 
     *   Special rules for cache sync
     * 
     *   After successfull "add" or "update" operation cache sync request is performed, which is using
     *   "fetch" operation of the same datasource. It may happen that user is allowed to add records, but
     *   is not allowed to fetch them, for example:
     * 
     *     &lt;operationBinding operationType="fetch" requiresRole="admin"&gt;
     *        ... settings ...
     *     &lt;/operationBinding&gt;
     *     &lt;operationBinding operationType="add"&gt;
     *        ... settings ...
     *     &lt;/operationBinding&gt;
     * 
     *   User without "admin" role will be able to successfully add record, but the cache sync operation
     *   will fail due to security violation. In this case the record will be saved to database, but the
     *   added record will not be fetched from database, instead just DSRequest.oldValues
     *   overlaid with submitted values will be returned. So, any changes made to the new record during
     *   request execution, including generated values for primary key fields of "sequence" type, will not
     *   be returned to the client.
     * 
     *   However, if "add" or "update" operation explicitly declares OperationBinding.cacheSyncOperation,
     *   cache sync request will be executed even if the user does not meet the security checks for the
     *   operationBinding. Note that field-level security still will be respected and disallowed fields will
     *   be excluded from returned data.
     *  @type {string}
     *  @default null
     */
    open var requiresRole: String = definedExternally
    /**
     *  Indicates that the specified VelocityExpression must be true for a user to access
     *   this operationBinding.
     * 
     *   As with OperationBinding.requiresRole, if there an operationBinding that is the
     *   default operationBinding for the operationType, its requires expression is
     *   assumed to apply to all other operationBindings of the same type unless they explicitly set
     *   requires=""
     * 
     *   DataSource.requires, if specified, applies before
     *   operationBinding.requires is evaluated. In this case, both requires
     *   expressions must be true for the request to be accepted.
     *  @type {VelocityExpression}
     *  @default null
     */
    open var requires: String = definedExternally
    /**
     *  Indicates that field-level declarative security rules are waived for rows that were
     *   created by the current user, as described in the discussion of
     *   DataSource.creatorOverrides. This setting overrides
     *   dataSource.creatorOverrides, for this operation only.
     *  @type {boolean}
     *  @default null
     */
    open var creatorOverrides: Boolean = definedExternally
    /**
     *  Requires that the currently authenticated user match the contents of this
     *   field, for client-initiated requests (i.e., where
     *   DSRequest.isClientRequest() returns true on the server).
     * 
     *   When a new row is added by a client-initiated DSRequest, the
     *   ownerIdField will be automatically populated with the currently
     *   authenticated user (clobbering any value supplied by the client).
     *   Client-initiated attempts to update the ownerIdField will also be prevented.
     * 
     *   If you wish to set the ownerIdField to a different value via an "add" or
     *   "update" operation, you can do so in server-side DMI code (possibly
     *   consulting DSRequest.getClientSuppliedValues() to get the value
     *   that was clobbered).
     * 
     *   For client-initiated "fetch", "update" or "remove" operations, the server
     *   will modify client-supplied criteria so that only rows whose ownerIdField
     *   matches the currently authenticated user can be read, updated or deleted.
     * 
     *   Overrides the same setting at the DataSource.ownerIdField level.
     * 
     *   If ownerIdField is specified,
     *   DataSource.requiresAuthentication will default
     *   to true. If requiresAuthentication is explicitly
     *   set to false, then unauthenticated users will be able to see
     *   all records. To avoid this, you can use
     *   DataSource.guestUserId to specify a default user to apply
     *   when no one has authenticated.
     *  @type {string}
     *  @default null
     */
    open var ownerIdField: String = definedExternally
    /**
     *  Value to use for the OperationBinding.ownerIdField if no one
     *   has authenticated.
     * 
     *   Overrides the same setting at the DataSource.guestUserId level.
     *  @type {string}
     *  @default null
     */
    open var guestUserId: String = definedExternally
    /**
     *  Definition of an email message that will be sent as an after-effect of selecting or updating
     *   data.
     * 
     *   Note that if a fixed number of different messages need to be sent, multiple
     *   &lt;mail&gt; tags may be specified. For example, one mail could be sent to an
     *   admin address, and a different message to every member of a user group.
     *  @type {Mail}
     *  @default null
     */
    open var mail: Mail = definedExternally
    companion object {
        /**
         *  Creates a new OperationBinding
         * 
         *  @param typeCheckedProperties {Partial<OperationBinding>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {OperationBinding} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): OperationBinding = definedExternally
    }
}