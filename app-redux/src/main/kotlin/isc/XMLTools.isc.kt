@file:JsQualifier("isc")
package isc

/**
 *  Utility methods for dealing with XML elements, XML Schema, WSDL files, XSLT, and other
 *   XML-related functionality.
 */
open external class XMLTools : Class {
    companion object {
        /**
         *  Creates a new XMLTools
         * 
         *  @param typeCheckedProperties {Partial<XMLTools>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {XMLTools} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): XMLTools = definedExternally
        /**
         *   Load an XML document from the origin server or from a foreign server by relaying through the
         *   origin server. An asynchronous callback provides both the XML document and raw text of the
         *   response.
         * 
         *   Relaying through the origin server requires that the ISC HttpProxyServlet be installed and
         *   accessible.
         * 
         * 
         *  @param {URL} URL to load the schema from
         *  @param {Callback} callback to fire when the XML is loaded. Signature is               callback(xmlDoc, xmlText)
         *  @param {RPCRequest=} additional properties to set on the RPCRequest                     that will be issued
         */
        fun loadXML(URL: String, callback: dynamic, requestProperties: RPCRequest?): Unit = definedExternally
        /**
         *   Disables an Internet Explorer-specific work around for the MSXML bug that the 'xml' namespace
         *   prefix cannot be explicitly declared.
         * 
         *   Though redundant,
         *   the Namespaces in XML spec allows
         *   XML documents to explicitly declare namespace prefix 'xml' bound to namespace name
         *   http://www.w3.org/XML/1998/namespace; e.g.
         *   xmlns:xml="http://www.w3.org/XML/1998/namespace"
         *   MSXML does not allow the 'xml' namespace prefix to be declared, and will raise the XML
         *   parse error: The namespace prefix is not allowed to start with the reserved string "xml".
         *   Microsoft has disclosed this bug as a Normative Variation in MSXML:
         *   http://msdn.microsoft.com/en-us/library/ff460535(v=vs.85).aspx.
         *   A framework-level work around is used by default in XMLTools.parseXML where if the
         *   string xmlns:xml="http://www.w3.org/XML/1998/namespace" or
         *   xmlns:xml='http://www.w3.org/XML/1998/namespace' is found in the first 1000
         *   characters of the xmlText parameter to parseXML(), then these two strings are
         *   removed from xmlText wherever they appear. This work around may be disabled by
         *   calling disableIEXMLHackaround() at any time before parseXML() is called.
         * 
         */
        fun disableIEXMLHackaround(): Unit = definedExternally
        /**
         *   Parse XML text into an XMLDocument. Parse errors, if any, are reported to the log.
         * 
         *   NOTE: Internet Explorer's XML parser implementation, MSXML, has a bug in its
         *   handling of namespace name http://www.w3.org/XML/1998/namespace. Though redundant,
         *   the Namespaces in XML spec allows
         *   XML documents to explicitly declare namespace prefix 'xml' bound to namespace name
         *   http://www.w3.org/XML/1998/namespace; e.g.
         *   xmlns:xml="http://www.w3.org/XML/1998/namespace"
         *   MSXML does not allow the 'xml' namespace prefix to be declared, and will raise the XML
         *   parse error: The namespace prefix is not allowed to start with the reserved string "xml".
         *   Microsoft has disclosed this bug as a Normative Variation in MSXML:
         *   http://msdn.microsoft.com/en-us/library/ff460535(v=vs.85).aspx.
         *   A framework-level work around is used by default where if the string
         *   xmlns:xml="http://www.w3.org/XML/1998/namespace" or
         *   xmlns:xml='http://www.w3.org/XML/1998/namespace' is found in the first 1000
         *   characters of xmlText, then these two strings are removed from xmlText
         *   wherever they appear. This work around may be disabled by calling XMLTools.disableIEXMLHackaround
         *   at any time before parseXML() is called.
         * 
         * 
         *  @param {string} XML text to be parsed
         */
        fun parseXML(xmlText: String): dynamic = definedExternally
        /**
         * 
         *   Returns true if the current browser exposes an XML parser that can be used for SmartClient
         *   XML operations like web service bindings and XML processing. See
         *   platformDependencies for more information on when the XML parser may not
         *   available and what features are impacted as a result.
         * 
         * 
         */
        fun nativeXMLAvailable(): Boolean = definedExternally
        /**
         *   Translates an XML fragment to JavaScript collections. This method works just like the
         *   server-side method XML.toJS(Element, Writer):
         * 
         * 
         *  -  Elements become JavaScript Objects with each attribute becoming a property
         * 
         *  -  Subelements with just text (no child elements or attributes) become properties
         * 
         *  -  Subelements with child elements or attributes become sub objects
         * 
         *   For example, if you pass the following fragment to this method:
         * 
         *   &lt;foo&nbsp;bar="zoo"&gt;
         *     &nbsp;&nbsp;&lt;x&gt;y&lt;/x&gt;
         *   &lt;/foo&gt;
         * 
         *   You will get back the following JS structure:
         * 
         *   { bar:"zoo", x:"y"}
         * 
         *   All atomic property values will be of String type. Use DataSource.recordsFromXML
         *   to do schema-driven XML to JS transform, which can produce correctly typed values.
         * 
         * 
         *  @param {XMLElement | XMLDocument} The element to transform to JS
         */
        fun toJS(element: dynamic): dynamic = definedExternally
        /**
         *   Applies an XPath expression to JavaScript objects, returning matching objects.
         * 
         *   Both child and attribute names are interpreted as property names, and array access notation
         *   can be used to select elements from Arrays. For example:
         *     var results = {
         *      searchResults:[
         *        { title:"Page One", relevance:6.3 },
         *        { title:"Page Two", relevance:5.2, 
         *         summary: "Summary of Page One" }
         *      ]
         *     };
         * 
         *     // returns the "searchResults" two-item Array
         *     isc.XMLTools.selectObjects(results, "/searchResults");
         * 
         *     // returns the first item under "searchResults", in an Array (NOTE: in XPath, Array
         *     // index starts at 1, not 0)
         *     isc.XMLTools.selectObjects(results, "/searchResults[1]");
         * 
         *     // returns ["Page One"]
         *     isc.XMLTools.selectObjects(results, "/searchResults[1]/title");
         * 
         *     // also returns ["Page One"]
         *     isc.XMLTools.selectObjects(results, "/searchResults[1]@title");
         * 
         *   A limited form of XPath "predicates", that is, expressions with brackets that filter
         *   returned objects, is allowed. A predicate can be either:
         * 
         * 
         *  - a number only, eg [5], for Array access
         * 
         *  - the XPath function call "last()", eg [last()], to retrieve the last item
         * 
         *  - a property name (\*without\* any leading "@"), meaning that the property contains a value
         *     that is considered "true" in JavaScript. For example: [summary]
         * 
         *  - a property name, comparison operator, and either a number or String literal, for
         *     example, [name = "bob"]. In this case the property can also be the XPath function
         *     position(), for example, [position() > 5]
         * 
         *   Some examples of using simple predicates with the sample data above:
         * 
         *     // returns an Array with only the first result
         *     isc.XMLTools.selectObjects(results, "/searchResults[relevance > 5.5]");
         * 
         *     // return an Array with only the second result, since the first has no summary
         *     isc.XMLTools.selectObjects(results, "/searchResults[summary]");
         * 
         *   Details of the XPath -> Objects mapping:
         * 
         * 
         *  - JavaScript Object properties are considered element children, and text children do not
         *     exist (in the XML model, text children exist \*between\* element children, but nothing
         *     exists between JavaScript properties)
         * 
         *  - The contents of Array-valued properties are considered immediate element children (this
         *     is consistent with the predicate "[5]" acting like Array access)
         * 
         *  - "\*" in XML selects all element children, so "\*" in Object XPath selects the values of
         *     all properties, that is, isc.getValues, except
         *     that Array-valued properties are "flattened" into the returned list.
         * 
         * 
         * 
         *  @param {object} Object to select results from
         *  @param {string} XPath expression
         */
        fun selectObjects(`object`: dynamic, xPath: String): Array<dynamic> = definedExternally
        /**
         *   Retrieve a set of nodes from an XML element or document based on an XPath expression.
         * 
         *   If the target document is namespaced, namespace prefixes declared in the document element of
         *   the target document will be available, as well as the default namespace, if declared, under
         *   the prefix "default".
         * 
         *   To declare your own namespace prefixes, provide a prefix to URI mapping as a simple JS
         *   Object, for example:
         * 
         *    {
         *     az : "http://webservices.amazon.com/AWSECommerceService/2005-03-23",
         *     xsd : "http://www.w3.org/2001/XMLSchema"
         *    }
         * 
         * 
         *   NOTE: this API cannot be supported on the Safari web browser for versions earlier
         *   than 3.0.3.
         * 
         * 
         *  @param {XMLElement | XMLDocument | string} Native XMLElement,document, or xml string                           to select from
         *  @param {string} XPath expression to use to select nodes
         *  @param {Map<URI>=} namespace mapping used by the expression
         */
        fun selectNodes(element: dynamic, expression: String, namespaces: Map<String>?): Array<dynamic> = definedExternally
        /**
         *   Retrieve a string value from an XML element or document based on an XPath expression.
         * 
         *   If more than one node matches, only the first node's value will be returned.
         * 
         *   Namespacing works as described under XMLTools.selectNodes
         * 
         *   NOTE: this API cannot be supported on the Safari web browser for versions prior to
         *   3.0.3.
         * 
         * 
         *  @param {XMLElement | XMLDocument | string} Native XMLElement,document, or xml string                           to select from
         *  @param {string} XPath expression to use to select nodes
         *  @param {Map<URI>=} namespace mapping used by the expression
         */
        fun selectString(element: dynamic, expression: String, namespaces: Map<String>?): String = definedExternally
        /**
         *   Retrieve a numeric value from an XML element or document based on an XPath expression.
         * 
         *   If more than one node matches, only the first node's value will be returned.
         * 
         *   Namespacing works as described under XMLTools.selectNodes
         * 
         *   NOTE: this API cannot be supported on the Safari web browser for versions prior to
         *   3.0.3.
         * 
         * 
         *  @param {XMLElement | XMLDocument | string} Native XMLElement,document, or xml string                           to select from
         *  @param {string} XPath expression to use to select nodes
         *  @param {Map<URI>=} namespace mapping used by the expression
         */
        fun selectNumber(element: dynamic, expression: String, namespaces: Map<String>?): Number = definedExternally
        /**
         *   Apply an XSLT Stylesheet to an XML Document.
         * 
         *   This method cannot currently be supported on the Safari web browser versions prior to
         *   3.0.3.
         * 
         * 
         *  @param {XMLDocument} XML document to apply the transform to
         *  @param {XMLDocument} XSLT stylesheet to use for transform
         */
        fun transformNodes(inputDocument: dynamic, styleSheet: dynamic): String = definedExternally
        /**
         *   Takes an XMLDocument and returns it as a String.
         * 
         *   This method is not supported on the Safari web browser versions prior to 3.0.3.
         * 
         * 
         *  @param {XMLDocument} XML document to apply the transform to
         */
        fun serializeToString(inputDocument: dynamic): String = definedExternally
        /**
         *   Load an XML file containing XML schema definitions and create DataSource and SimpleType
         *   objects to represent the schema. You can use to loaded schema to bind ISC components,
         *   perform validation, create editing interfaces, and build other metadata-driven interfaces.
         *   You can also use DataSource.inheritsFrom to overlay
         *   presentation-specific data (such as user-visible titles) on top of XML Schema.
         * 
         *   In the loaded XML Schema, all &lt;xsd:complexType&gt; declarations become SmartClient
         *   DataSources, and all &lt;xsd:simpleType&gt; definitions become SmartClient
         *   SimpleType.
         * 
         *   By default, named complexType definitions and named element definitions containing
         *   complexTypes become global DataSources, that is, they can be fetched with
         *   DataSource.getDataSource. Inline complexType definitions get
         *   automatically generated names.
         * 
         *   Named simpleType declarations become global SimpleType, that is,
         *   subsequently defined DataSources can use them for DataSourceField.type. XML
         *   schema "restrictions" for simple types are automatically translated to
         *   DataSourceField.valueMap or DataSourceField.validators as
         *   appropriate.
         * 
         *   The created SchemaSet object is available in the callback as the single parameter
         *   "schemaSet", or can retrieved via SchemaSet.get(schemaNamespace).
         * 
         *   NOTE: unless you are building an application that dynamically loads XML Schema
         *   without prior knowledge, instead of calling loadXMLSchema(), you should either:
         * 
         * 
         *  - use the loadXMLSchemaTag tag to eliminate the need for an asynchronous
         *   download of an XML Schema file as part of application startup, OR
         * 
         *  - use the "WSDL" tab in the Developer Console to obtain the XML Schema definition as a
         *   JavaScript file that can be loaded via a normal HTML &lt;SCRIPT SRC=&gt; tag and/or
         *   combined with other JavaScript files.
         * 
         * 
         *   NOTE: required fields: the XML Schema concept of "required" for an attribute or subelement,
         *   expressed via use="required" (for an attribute) or minOccurs > 0 (for a subelement), is
         *   that the attribute or element must be present in the XML document but can have any
         *   value, including being empty or null. The SmartClient notion of required means
         *   non-null. You can express the SmartClient notion of required in XML Schema with the
         *   combination of minOccurs>0 and a minLength or length "restriction", and SmartClient
         *   will recognize the field as SmartClient-required, with all of the behaviors that implies
         *   (eg, specially styled form titles, automatic validation, etc).
         * 
         * 
         *  @param {URL} URL to load the schema from
         *  @param {Callback} signature is callback(schemaSet)
         *  @param {RPCRequest} additional properties to set on the RPCRequest                     that will be issued
         *  @param {boolean} if set, xsd:import statements will be processed                 automatically to load dependent XSD files where a                  "location" is specified. The callback will not fire until                  all dependencies have been loaded
         */
        fun loadXMLSchema(schemaURL: String, callback: dynamic, requestProperties: RPCRequest, autoLoadImports: Boolean): Unit = definedExternally
        /**
         *   Load a WSDL file and create an instance of WebService that allows invoking operations and
         *   binding DataSources to web service operations.
         * 
         *   The created WebService object is available in the callback as the single parameter
         *   "service", or can be retrieved via WebService.get(serviceNamespace).
         * 
         *   XML Schema present in the WSDL file will also be processed as described in
         *   XMLTools.loadXMLSchema. However note that imported XML Schema
         *   (&lt;xs:import&gt; tag) will not be automatically loaded and must be loaded manually using
         *   XMLTools.loadXMLSchema before the loaded service will be usable. This is because the WSDL
         *   spec allows but does not require a valid URL to be provided for loading imported XML Schema.
         * 
         *   NOTE: unless you are building an application that dynamically contacts WSDL web services
         *   without prior knowledge, instead of calling loadWSDL(), you should either:
         * 
         * 
         *  - use the loadWSDLTag tag to eliminate the need for an asynchronous
         *   download of a WSDL file as part of application startup, OR
         * 
         *  - use the "WSDL" tab in the Developer Console to obtain the WebService definition as a
         *   JavaScript file that can be loaded via a normal HTML &lt;SCRIPT SRC=&gt; tag and/or combined
         *   with other JavaScript files.
         * 
         *   Platform notes:
         * 
         * 
         *  - loadWSDL() is not supported in Safari 2.0 (but is supported in Safari 3.0.3 and greater)
         *   However, you can use either approach mentioned above (loadWSDLTag or JavaScript file) with
         *   Safari pre 3.0.3.
         * 
         *  - if you are using a non-Java server, in order to obtain a JavaScript file representing a
         *   web service, you must run the Developer Console in the Java-based SmartClient SDK
         * 
         * 
         * 
         *  @param {URL} URL to load the WSDL file from
         *  @param {Callback} signature is callback(service)
         *  @param {RPCRequest} additional properties to set on the RPCRequest                     that will be issued
         *  @param {boolean} if set, xsd:import statements will be processed                 automatically to load dependent XSD files where a                  "location" is specified. The callback will not fire until                  all dependencies have been loaded
         */
        fun loadWSDL(wsdlURL: String, callback: dynamic, requestProperties: RPCRequest, autoLoadImports: Boolean): Unit = definedExternally
    }
}