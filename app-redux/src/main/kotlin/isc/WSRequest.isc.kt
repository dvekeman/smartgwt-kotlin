@file:JsQualifier("isc")
package isc

/**
 *  A WSRequest (or "web service request") is an extended RPCRequest with additional properties
 *   applicable to WSDL/SOAP web services.
 * 
 *   All properties which are legal on RPCRequest are legal on a WSRequest, in
 *   addition to the properties listed here.
 */
open external class WSRequest {
    /**
     *  Name of the web service operation to invoke.
     *  @type {string}
     *  @default null
     */
    open var wsOperation: String = definedExternally
    /**
     *  Data to be serialized to XML to form the SOAP body.
     *  @type {any}
     *  @default null
     */
    open var data: dynamic = definedExternally
    /**
     *  When useFlatFields is set for a request to be sent to a WSDL web service, when
     *   creating the input XML message to send to the web service, properties in
     *   WSRequest.data will be used as the values for XML elements of the same name, at
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
     *  Optional object declaring namespace prefixes for use in evaluating the
     *   resultType parameter of WebService.callOperation, if resultType is an
     *   XPath.
     * 
     *   Format is identical to OperationBinding.xmlNamespaces, and default namespaces
     *   bindings are also identical.
     *  @type {object}
     *  @default null
     */
    open var xmlNamespaces: dynamic = definedExternally
    /**
     *  Valid only with WebService.callOperation. If set, do not transform XML results to
     *   JavaScript. Instead just return the XML nodes selected by the passed XPath or recordName,
     *   or all nodes within the SOAP body if no XPath was passed.
     *  @type {boolean}
     *  @default false
     */
    open var xmlResult: Boolean = definedExternally
    /**
     *  Data to be serialized to form the SOAP headers, as a map from the header part name to the
     *   data. For example, given WSDL like this:
     * 
     *     &lt;soap:header part="SessionHeader" message="tns:HeaderMessage"/&gt;
     *     &lt;soap:header part="CallOptions" message="tns:HeaderMessage/&gt;
     * 
     *   headerData like this might be provided:
     * 
     *     dsRequest.headerData =
     *       { SessionHeader : data
     *        CallOptions : data };
     * 
     *   The provided data will be serialized to XML by the
     *   WebService.getInputHeaderSchema via
     *   DataSource.xmlSerialize
     *  @type {any}
     *  @default null
     */
    open var headerData: dynamic = definedExternally
}