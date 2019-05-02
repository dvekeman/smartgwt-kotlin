@file:JsQualifier("isc")
package isc

/**
 *  Class representing a WebService definition derived from a WSDL file.
 * 
 *   A Web Service object allows you to invoke operations (via
 *   WebService.callOperation), inspect schema declared in the
 *   WSDL file (WebService.getSchema), and perform simple read-only
 *   databinding WebService.getFetchDS.
 * 
 *   Once a WebService has been loaded, a DataSource can be declared with a
 *   DataSource.serviceNamespace to connect it to the web service, allowing DataSource
 *   data to be loaded and saved to the web service using
 *   OperationBinding.
 */
open external class WebService : Class {
    /**
     *  Namespace of this WebService, derived from the targetNamespace
     *   attribute of the &lt;wsdl:definitions&gt; element.
     *  @type {URI}
     *  @default null
     */
    open var serviceNamespace: String = definedExternally
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
     */
    open fun getOperationNames(): Array<dynamic> = definedExternally
    /**
     *   Get the schema definition of any complexType or element of complexType defined in any
     *   &lt;schema&gt; blocks in the WSDL file this WebService represents.
     * 
     * 
     *  @param {string} name of type or element
     *  @param {string=} optional type of schema to return, either "element" for               xs:element definitions only or "type" for xs:complexType                definitions. If unspecified, either will be returned,                with types preferred if names collide
     */
    open fun getSchema(schemaName: String, schemaType: String?): DataSource = definedExternally
    /**
     *   Invoke a web service operation.
     * 
     *   The data parameter will be serialized to XML to form the input message for
     *   the operation, as described by DataSource.xmlSerialize. Namespacing,
     *   element ordering, and SOAP encoding rules are automatically followed. If the web
     *   service you are trying to contact requires a complicated nested structure, consider
     *   using WSRequest.useFlatFields to simplify the required JavaScript input data.
     * 
     *   The resultType selects what part of the message should be decoded to
     *   JavaScript and made available as the "data" variable in the callback. The
     *   resultType parameter can be either:
     * 
     * 
     *  - an XPath. "data" will be always be an Array, containing the selected elements as
     *   decoded by XMLTools.toJS. All properties will have String value.
     * 
     *  - the name of an XML Schema type found somewhere in the response. You can use the
     *   WSDL tab of the Developer Console to analyze the WSDL file for an appropriate type name.
     *   "data" will be an Array, containing the decoded elements as decoded by
     *   DataSource.recordsFromXML. In this case, since the XML Schema type of the
     *   selected data is known, properties will have correct type (eg "date" fields will
     *   have JavaScript Date objects)
     * 
     *  - null. "data" will an Object representing the entire &lt;SOAP:Body&gt; as decoded
     *   to JavaScript. As above, properties will have correct type.
     * 
     *   In the callback, you also receive the XML document returned by the web service as
     *   "xmlDoc".
     * 
     *   NOTE: callOperation() is appropriate for simple operations that do not
     *   involve DataBound Components, such as logging into a web service, or retrieving simple
     *   String data. callOperation() can also be used to retrieve small, read-only
     *   datasets such as the option list for a SelectItem, but only if the dataset is guaranteed
     *   to remain small enough for paging to be unnecessary. For any larger datasets or
     *   anything that will be edited, DataSource integration is more appropriate.
     * 
     * 
     *  @param {string} Name of the operation to invoke
     *  @param {object} data to serialize as XML to form the inbound message of                 the operation
     *  @param {string | string | string} Type, Element name, or XPath that                 should be selected from the result. For XPaths, see                  WSRequest.xmlNamespaces for available namespace                  prefixes and how to add more.
     *  @param {Callback} Callback to invoke on completion. Signature                 callback(data, xmlDoc, rpcResponse, wsRequest)
     *  @param {WSRequest} Additional properties for the WSRequest, such                   as HTTPHeaders
     */
    open fun callOperation(operationName: String, data: dynamic, resultType: String, callback: dynamic, requestProperties: WSRequest): Unit = definedExternally
    /**
     *   Return the SOAP message that will be formed from this WSRequest.
     * 
     * 
     *  @param {WSRequest} web service request object
     */
    open fun getSoapMessage(wsRequest: WSRequest): String = definedExternally
    /**
     *   Get a DataSource representing the input message to a web service operation.
     * 
     *   This DataSource is suitable for use as
     *   DataBoundComponent.dataSource for a form that the user fills out
     *   when providing inputs to call this web service operation.
     * 
     * 
     *  @param {string} name of the web service operation whose inputs the                returned DataSource will represent
     */
    open fun getInputDS(operationName: String): DataSource = definedExternally
    /**
     *   Get the schema for each part of the SOAP header for the input message of a given
     *   operation, as a mapping from part name to schema. For example, given WSDL like:
     * 
     *     &lt;soap:header part="SessionHeader" message="tns:HeaderMessage"/&gt;
     *     &lt;soap:header part="CallOptions" message="tns:HeaderMessage/&gt;
     * 
     *   The following schema would be returned:
     * 
     *     { SessionHeader : sessionHeaderPartSchema,
     *      CallOptions : callOptionsPartSchema }
     * 
     *   The schema are instances of DataSource that can be inspected to discover the
     *   elements and types that are legal in that header part, and can construct a valid SOAP
     *   header part if DataSource.xmlSerialize is invoked.
     * 
     * 
     *  @param {string} name of an operation from this web service
     */
    open fun getInputHeaderSchema(operationName: String): dynamic = definedExternally
    /**
     *   Get the schema for each part of the SOAP header for the output message of a given
     *   operation, as a mapping from part name to schema. For example, given WSDL like:
     * 
     *     &lt;soap:header part="SessionHeader"/&gt;
     *     &lt;soap:header part="CallOptions"/&gt;
     * 
     *   The following schema would be returned:
     * 
     *     { SessionHeader : sessionHeaderPartSchema,
     *      CallOptions : callOptionsPartSchema }
     * 
     *   The schema are instances of DataSource that can be inspected to discover the
     *   elements and types that are legal in that header part, and can construct a valid SOAP
     *   header part if DataSource.xmlSerialize is invoked.
     * 
     * 
     *  @param {string} name of an operation from this web service
     */
    open fun getOutputHeaderSchema(operationName: String): dynamic = definedExternally
    /**
     *   Override this method to return data that should be serialized as SOAP headers for the
     *   current operation, such as a sessionId.
     * 
     *   Format of the returned data is the same as that documented for
     *   DSRequest.headerData.
     * 
     *   The object passed to this method will be a true DSRequest in the case of a DataSource
     *   operation, or just an Object with a "data" property for web service operations
     *   initiated by WebService.callOperation.
     * 
     *   If headerData is instead provided via either dsRequest.headerData or as
     *   part of the requestProperties parameter to
     *   WebService.callOperation, this method will never be called.
     * 
     * 
     * \* @param {DSRequest} 
     */
    open fun getHeaderData(dsRequest: DSRequest): dynamic = definedExternally
    /**
     *   Retrieve a DataSource that provides read-only access to records returned by a web
     *   service operation.
     * 
     *   DataBoundComponent can be bound to the returned
     *   DataSource, and the ListGrid.fetchData method can be invoked
     *   to retrieve data from the web service.
     * 
     *   The returned DataSource is only capable of the "fetch"
     *   dataSourceOperations, not "update", "add" or
     *   "remove". To create a DataSource capable of full read-write access, use
     *   DataSource.operationBindings with the
     *   OperationBinding.wsOperation property set to associate each
     *   DataSource operation with a web service operation.
     * 
     * 
     *  @param {string} name of the web service operation to invoke to fetch                records
     *  @param {string} tag or type name of the XML element to be returned as                DataSource records
     *  @param {OperationBinding=} Optional additional properties for the operationType:"fetch"  OperationBinding which this method automatically creates. This can be used to set properties such as OperationBinding.useFlatFields or OperationBinding.recordXPath
     */
    open fun getFetchDS(operationName: String, resultType: String, operationBindingProperties: OperationBinding?): Unit = definedExternally
    /**
     *   Set location can be used when the actual URL where a service will be accessible isn't
     *   known until runtime, or changes at runtime, hence can't be embedded in the service
     *   definition.
     * 
     *   With an operation parameter, setLocation() can be used to set a distinct
     *   URL for each web service operation. This is a development-time only feature that allows
     *   XML flat files to be placed at various URLs on a server, to serve as spoofed responses
     *   for each web service operation.
     * 
     * 
     *  @param {URL} URL where web service can be contacted
     *  @param {string=} optional operation name to set the location for, for               debugging only
     */
    open fun setLocation(location: String, operation: String?): Unit = definedExternally
    companion object {
        /**
         *  Creates a new WebService
         * 
         *  @param typeCheckedProperties {Partial<WebService>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {WebService} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): WebService = definedExternally
        /**
         *   Retrieve a WebService object by the targetNamespace declared on the &lt;wsdl:definitions&gt;
         *   element in the WSDL file from which the WebService was derived.
         * 
         *   If you have more than one &lt;wsdl:service&gt; in the same target namespace, use
         *   WebService.getByName to disambiguate.
         * 
         * 
         *  @param {string} uri from the "targetNamespace" attribute of the &lt;wsdl:definitions&gt; element in the WSDL file
         */
        fun get(serviceNamespace: String): WebService = definedExternally
        /**
         *   Retrieve a WebService object by the name attribute declared on the &lt;wsdl:service&gt; tag.
         * 
         * 
         *  @param {string} name attribute from the &lt;wsdl:service&gt; tag
         *  @param {string=} optional serviceNamespace if needed to disambiguate
         */
        fun getByName(serviceName: String, serviceNamespace: String?): WebService = definedExternally
    }
}