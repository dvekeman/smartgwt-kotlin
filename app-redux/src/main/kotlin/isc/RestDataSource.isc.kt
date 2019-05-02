@file:JsQualifier("isc")
package isc

/**
 *  The RestDataSource implements the 4 core DataSource operations using a simple protocol of
 *   XML or JSON requests and responses sent over HTTP, which can be easily fulfilled by any HTTP
 *   server technology.
 * 
 *   RestDataSource is named for the
 *   REST (REpresentational State
 *   Transfer) pattern, which in brief says that simple messages passed over HTTP is a sufficient
 *   protocol for many web applications, without the need for further protocols such as WSDL or
 *   SOAP.
 * 
 *   A RestDataSource is used just like a normal DataSource. RestDataSources are pre-configured,
 *   using the general-purpose databinding facilities of DataSources, to expect a particular
 *   format for responses and to send requests in a specific format.  These request and
 *   response formats represent Isomorphic's recommended best practices for binding SmartClient
 *   to backends which do not already support a similar, pre-existing request and response
 *   format and where the SmartClient Java Server cannot be used.
 * 
 *   If you have a pre-existing REST or WSDL service which is difficult to change, consider
 *   adapting SmartClient to the existing service instead, by starting with a normal
 *   DataSource and using the
 *   clientDataIntegration facilities to create a
 *   mapping between SmartClient's DSRequest and DSResponse objects and the message
 *   formats of your existing services. NOTE: do not begin this process by
 *   creating or subclassing RestDataSource; for a pre-existing service which is unrelated
 *   to the protocol documented for RestDataSource, start by configuring or subclassing
 *   DataSource instead.
 * 
 *   RestDataSource is typically used with PHP, Ruby, Python, Perl or custom server technologies,
 *   and represents an alternative to installing the SmartClient Server in a Java technology
 *   stack, or using wsdlBinding with .NET or other WSDL-capable
 *   technologies. Note that SmartClient Server also provides built-in support for the REST
 *   protocol via its RESTHandler servlet; this is primarily to allow non-SmartClient clients
 *   to make use of DataSource operations. If you particularly wished to do so, you could use
 *   RestDataSource to make a SmartClient app talk to the SmartClient Server using REST rather
 *   than the proprietary wire format normally used when communicating with SmartClient Server
 *   (this is how we are able to write automated tests for the RESTHandler servlet). However,
 *   doing this provides no benefit, imposes a number of inconveniences, and makes a handful
 *   of server-based features less useful
 *   (DataSourceField.viewRequiresAuthentication, for
 *   example), so we strongly recommend that you do not do this; it is only mentioned
 *   here for completeness while we are discussing REST.
 * 
 *   The request and response formats used by the RestDataSource allow for many of the available
 *   features of SmartClient's databinding system to be used, including data paging, searching &
 *   sorting, DSRequest.oldValues,
 *   ResultSet, relogin and
 *   RPCManager.startQueue. However, advanced
 *   features such as upload and
 *   ListGrid.exportData aren't available with RestDataSource and need to be
 *   re-implemented as needed. Most, though not all, iscServer
 *   are still available when using RestDataSource, as long as you are also using the RESTHandler
 *   servlet that is part of SmartClient Server. However, as noted above, this approach is not
 *   recommended; if you are using Isomorphic technology both client- and server-side, it makes
 *   more sense to use the proprietary wire format.
 * 
 *   RestDataSource and binary data
 * 
 *   Binary data in a response provided to a RestDataSource must be delivered as valid XML or
 *   JSON Strings. Once delivered to the browser as Strings, there is no way to trigger the
 *   browser's "Save As" dialog to download the data, and in most cases no way to trigger other
 *   helper applications that might be launched to handle binary data (such as Excel or a PDF
 *   viewer). Hence for binary it usually makes sense to make a direct request via
 *   RPCManager.sendRequest() with downloadResult:true, separate from RestDataSource.
 * 
 *   If you are using the SmartClient Server included in Pro, Power end Enterprise to handle your
 *   REST requests server-side, there is transparent support for conversion between Java
 *   InputStreams representing binary data, and Strings containing that binary
 *   data encoded using the Base64 algorithm.
 *   Thus, on the server, the binary data is in its raw binary form, with transparent conversion
 *   to or from Base64 for messages to or from the REST client.
 * 
 *   Examples
 * 
 *   XML formatted responses:
 * 
 *   RestDataSource expects a response like the following in response to a "fetch" request:
 * 
 *   &lt;response&gt;
 *    &lt;status&gt;0&lt;/status&gt;
 *    &lt;startRow&gt;0&lt;/startRow&gt;
 *    &lt;endRow&gt;76&lt;/endRow&gt;
 *    &lt;totalRows&gt;546&lt;/totalRows&gt;
 *    &lt;data&gt;
 *     &lt;record&gt;
 *       &lt;field1&gt;value&lt;/field1&gt;
 *       &lt;field2&gt;value&lt;/field2&gt;
 *     &lt;/record&gt;
 *     &lt;record&gt;
 *       &lt;field1&gt;value&lt;/field1&gt;
 *       &lt;field2&gt;value&lt;/field2&gt;
 *     &lt;/record&gt;
 *     ... 76 total records ...
 *    &lt;/data&gt;
 *   &lt;/response&gt;
 * 
 *   The &lt;status&gt; element indicates whether the fetch operation was successful
 *   (see statusCodes).
 * 
 *   The &lt;data&gt; element contains a list of record nodes, each of which represents a record
 *   returned by the server. The optional &lt;startRow&gt;, &lt;endRow&gt; and &lt;totalRows&gt;
 *   elements are needed only if data paging is in use, and populate the
 *   DSResponse.startRow, DSResponse.endRow and
 *   DSResponse.totalRows properties of the DSResponse.
 * 
 *   Note: for a more compact format, simple field values may be specified on record
 *   nodes directly as attributes - in this case a record element might be structured like this:
 * 
 *     &lt;record field1="value" field2="value" /&gt;
 * 
 * 
 *   Note that a RestDataSource will bypass browser caching of all responses by default. See
 *   DataSource.preventHTTPCaching.
 * 
 *   Successful "add" or "update" request responses are similar in format - in this case the data
 *   element would be expected to contain a single record object containing the details of the
 *   record, as saved on the server.
 * 
 *   The response from a "remove" operation would again include status and data elements, but in
 *   this case, only the primary key field value(s) of the removed record would be expected to be
 *   present under the data element.
 * 
 *   If a validation failure occurred on the server, the response would
 *   have status set to RPCResponse.STATUS_VALIDATION_ERROR [-4],
 *   and any validation errors could be included as per-field sub-elements of an "errors"
 *   element. For a validation error, the response is not expected to contain any
 *   &lt;data&gt; element.
 * 
 *   A response showing a validation error might look like this:
 * 
 *   &lt;response&gt;
 *    &lt;status&gt;-4&lt;/status&gt;
 *    &lt;errors&gt;
 *     &lt;field1&gt;
 *       &lt;errorMessage&gt;A validation error occurred for this field&lt;/errorMessage&gt;
 *     &lt;/field1&gt;
 *    &lt;/errors&gt;
 *   &lt;/response&gt;
 * 
 * 
 *   An unrecoverable error, such as an unexpected server failure, can be flagged by setting
 *   &lt;status&gt; to -1 and setting &lt;data&gt; to an error message. In this case the
 *   &lt;errors&gt; element is not used (it's specific to validation errors). An unrecoverable
 *   error causes all response processing to be skipped and RPCManager.handleError to be
 *   invoked, which by default will show the provided error message as an alert using
 *   isc.warn.
 * 
 *   JSON formatted responses:
 * 
 *   JSON format responses are expected to contain the same data / meta-data as XMLresponses,
 *   encapsulated in a simple object with a "response" attribute.
 *   The response to a "fetch" request would therefore have this format:
 * 
 *   {
 *    "response": {
 *      "status": 0,
 *      "startRow": 0,
 *      "endRow": 76,
 *      "totalRows": 546,
 *      "data": [
 *        {"field1": "value", "field2": "value"},
 *        {"field1": "value", "field2": "value"},
 *        ... 76 total records ...
 *      ]
 *    }
 *   }
 * 
 *   The structure successful for "add", "update" and "remove" responses would be similar, though
 *   the data array would be expected to contain only a single object, representing the values as
 *   saved. This allows the server to return values such as an auto-generated sequence
 *   primaryKey, a last modified timestamp, or similar server-generated field values.
 * 
 *   For a remove, only the value for the primaryKey field[s] would be required.
 * 
 *   For a validation error, the status attribute would be set to
 *   RPCResponse.STATUS_VALIDATION_ERROR [-4], and errors would
 *   be specified in the errors attribute of the response. For example:
 * 
 *   {  "response":
 *     {  "status": -4,
 *       "errors":
 *         {  "field1": {"errorMessage": "A validation error on field1"},
 *           "field2": {"errorMessage": "A validation error on field2"}
 *         }
 *     }
 *   }
 * 
 *   An array of errors may also be returned for a single field, like this:
 * 
 *   {  "response":
 *     {  "status": -4,
 *       "errors":
 *         {  "field1": [
 *             {"errorMessage": "First error on field1"},
 *             {"errorMessage": "Second error on field1"}
 *           ]
 *         }
 *     }
 *   }
 * 
 * 
 *   As with the XML format above, an unrecoverable error is indicated by setting the
 *   status attribute to -1 and the data property to the error message.
 * 
 *   Server inbound data formats
 * 
 *   The format of data sent to the server is determined by the OperationBinding.dataProtocol
 *   specified for the operation. Request data is sent as parameters if the format is
 *   specified as "getParams" or "postParams".
 * 
 *   In this case, the parameters sent to the server will consist of the DSRequest's data, and any
 *   parameters explicitly specified on the DSRequest object (as RPCRequest.params.
 *   If RestDataSource.sendMetaData is true, the DSRequest meta
 *   data properties will also be present as parameters, prefixed with
 *   RestDataSource.metaDataPrefix.
 * 
 *   Example URL constructed with the metaDataPrefix set to "_" (the default):
 * 
 * 
 *   &nbsp;&nbsp;&nbsp;[dataURL]?field1=value1&_operationType=fetch&_startRow=0&_endRow=50&_sortBy=-field2&_dataSource=dsName
 * 
 * 
 *   In this case the server would be able to separate the request's data from the meta data
 *   via the "_" prefix.
 * 
 *   If data is sent to the server via the "postMessage" dataProtocol, the data will
 *   be serialized as an XML or JSON message according to the dataFormat setting.
 *   Both XML and JSON messages will contain request metadata such as startRow and endRow, and
 *   will appear exactly as though the subset of the DSRequest that is meaningful to the
 *   server had been passed to DataSource.xmlSerialize or JSON.encode
 *   respectively.
 * 
 *   An example of an XML message might look like this:
 * 
 *    &lt;request&gt;
 *      &lt;data&gt;
 *        &lt;countryCode&gt;US&lt;/countryCode&gt;
 *        &lt;countryName&gt;Edited Value&lt;/countryName&gt;
 *        &lt;capital&gt;Edited Value&lt;/capital&gt;
 *        &lt;continent&gt;Edited Value&lt;/continent&gt;
 *      &lt;/data&gt;
 *      &lt;dataSource&gt;countryDS&lt;/dataSource&gt;
 *      &lt;operationType&gt;update&lt;/operationType&gt;
 *    &lt/request&gt;
 * 
 *   An example of an XML message for a fetch operation passing simple criteria:
 * 
 *    &lt;request&gt;
 *      &lt;data&gt;
 *        &lt;continent&gt;North America&lt;/continent&gt;
 *      &lt;/data&gt;
 *      &lt;dataSource&gt;countryDS&lt;/dataSource&gt;
 *      &lt;operationType&gt;fetch&lt;/operationType&gt;
 *      &lt;startRow&gt;0&lt;/startRow&gt;
 *      &lt;endRow&gt;75&lt;/endRow&gt;
 *      &lt;componentId&gt;worldGrid&lt;/componentId&gt;
 *      &lt;textMatchStyle&gt;exact&lt;/textMatchStyle&gt;
 *    &lt/request&gt;
 * 
 *   And an example of an XML message for a fetch operation passing AdvancedCriteria:
 * 
 *    &lt;request&gt;
 *      &lt;data&gt;
 *        &lt;_constructor&gt;AdvancedCriteria&lt;/_constructor&gt;
 *        &lt;operator&gt;or&lt;/operator&gt;
 *        &lt;criteria&gt;
 *          &lt;criterion&gt;
 *            &lt;fieldName&gt;continent&lt;/fieldName&gt;
 *            &lt;operator&gt;equals&lt;/operator&gt;
 *            &lt;value&gt;North America&lt;/value&gt;
 *          &lt;/criterion&gt;
 *          &lt;criterion&gt;
 *            &lt;operator&gt;and&lt;/operator&gt;
 *            &lt;criteria&gt;
 *              &lt;criterion&gt;
 *                &lt;fieldName&gt;continent&lt;/fieldName&gt;
 *                &lt;operator&gt;equals&lt;/operator&gt;
 *                &lt;value&gt;Europe&lt;/value&gt;
 *              &lt;/criterion&gt;
 *              &lt;criterion&gt;
 *                &lt;fieldName&gt;population&lt;/fieldName&gt;
 *                &lt;operator&gt;greaterThan&lt;/operator&gt;
 *                &lt;value&gt;50000000&lt;/value&gt;
 *              &lt;/criterion&gt;
 *            &lt;/criteria&gt;
 *          &lt;/criterion&gt;
 *        &lt;/criteria&gt;
 *      &lt;/data&gt;
 *      &lt;dataSource&gt;countryDS&lt;/dataSource&gt;
 *      &lt;operationType&gt;fetch&lt;/operationType&gt;
 *      &lt;startRow&gt;0&lt;/startRow&gt;
 *      &lt;endRow&gt;75&lt;/endRow&gt;
 *      &lt;componentId&gt;worldGrid&lt;/componentId&gt;
 *    &lt/request&gt;
 * 
 *   An example of an XML message for a fetch operation when using serverSummaries:
 * 
 *    &lt;request&gt;
 *      &lt;data&gt;&lt;/data&gt;
 *      &lt;dataSource&gt;countryDS&lt;/dataSource&gt;
 *      &lt;operationType&gt;fetch&lt;/operationType&gt;
 *      &lt;summaryFunctions&gt;
 *        &lt;pk&gt;count&lt;/pk&gt;
 *      &lt;/summaryFunctions&gt;
 *      &lt;groupBy&gt;member_g8&lt;/groupBy&gt;
 *    &lt/request&gt;
 * 
 *   JSON messages are just the plain JSON form of the structures shown in the above XML
 *   examples. The advanced criteria XML example above but in JSON form:
 * 
 *   {
 *     data: {
 *       _constructor: "AdvancedCriteria",
 *       operator: "or",
 *       criteria: [
 *         {
 *           fieldName: "continent",
 *           operator: "equals",
 *           value: "North America
 *         },
 *         {
 *           operator: "and", criteria: [
 *             {
 *               fieldName: "continent",
 *               operator: "equals",
 *               value: "Europe"
 *             },
 *             {
 *               fieldName: "population",
 *               operator: "greaterThan",
 *               value: 50000000
 *             }
 *           ]
 *         }
 *       ]
 *     }
 *     dataSource: "countryDS",
 *     operationType: "fetch",
 *     startRow: 0,
 *     endRow: 75,
 *     componentId: "worldGrid"
 *   }
 * 
 *   The RestDataSource.operationBindings for a RestDataSource
 *   specify dataProtocol as "getParams" for the fetch operation, and "postParams" for update,
 *   add and remove operations. Note that most webservers impose a limit on the maximum size
 *   of GET requests (specifically, on the size of the request URL + HTTP headers). Using
 *   dataProtocol:"getParams" for "fetch" operations that involve complex AdvancedCriteria
 *   will result in a JSON serialization of the AdvancedCriteria in the request URL, and when
 *   combined with large cookies this can easily overflow the default limits on certain
 *   webservers (see
 *   http://stackoverflow.com/questions/686217/maximum-on-http-header-values).
 *   For this reason, we recommend that you use the "postMessage" protocol whenever you are
 *   intending to use AdvancedCriteria with RestDataSource.
 * 
 * 
 *   Date, time and datetime values
 * 
 *   Date, time and datetime values must be communicated using XML Schema format, as in the
 *   following examples:
 * 
 *   &nbsp;&nbsp;&lt;dateField&gt;2007-04-22&lt;/dateField&gt;
 *   &nbsp;&nbsp;&lt;timeField&gt;11:07:13&lt;/timeField&gt;
 *   &nbsp;&nbsp;&lt;dateTimeField&gt;2007-04-22T11:07:13&lt;/dateTimeField&gt;
 *   &nbsp;&nbsp;&lt;dateTimeField&gt;2007-04-22T11:07:13.582&lt;/dateTimeField&gt;
 * 
 * 
 *   And the equivalent in JSON:
 * 
 *   &nbsp;&nbsp;dateField: "2007-04-22"
 *   &nbsp;&nbsp;timeField: "11:07:13"
 *   &nbsp;&nbsp;dateTimeField: "2007-04-22T11:07:13"
 *   &nbsp;&nbsp;dateTimeField: "2007-04-22T11:07:13.582"
 * 
 * 
 *   Both RestDataSource on the client-side and the RESTHandler servlet on the server side
 *   automatically handle encoding and decoding temporal values using these formats. Both also
 *   handle datetime formats including or excluding milliseconds automatically. When encoding,
 *   both honor the DataSource.trimMilliseconds setting on the DataSource, falling back
 *   to the server.properties setting rest.trimMilliseconds; when
 *   decoding, both detect whether or not to try to parse milliseconds based on the string they
 *   receive.
 * 
 *   Fields of type "date" and "time" are considered to hold logical date and time values, as
 *   discussed in the dateFormatAndStorage, and are
 *   not affected by timezones. Fields of type "datetime" will be converted to UTC on the
 *   client side by RestDataSource, and will be sent back down to the client as UTC by the
 *   server-side RESTHandler. We recommend that your own REST client and/or server code do the
 *   same thing (ie, transmit all datetime values in both directions as UTC). Note that the
 *   examples given above give no timezone information, and will be treated by the SmartClient
 *   Server as UTC values. If you wish to work with datetime values in a particular timezone,
 *   use a format like this:
 * 
 *   &nbsp;&nbsp;&lt;dateField&gt;2007-04-22T11:07:13-0800&lt;/dateField&gt;
 *   &nbsp;&nbsp;&lt;dateField&gt;2012-11-19T22:12:04+0100&lt;/dateField&gt;
 * 
 * 
 *   And the equivalent in JSON:
 * 
 *   &nbsp;&nbsp;dateTimeField: "2007-04-22T11:07:13-0800"
 *   &nbsp;&nbsp;dateTimeField: "2012-11-19T22:12:04+0100"
 * 
 * 
 *   NOTE: Although we refer above to XML Schema format, the format used for specifying
 *   timezone offset is slightly different from XML Schema - as shown in the above examples, you
 *   specify "+HHMM" or "-HHMM", as opposed to the XML Schema format which requires a ":" character
 *   between the hours and minutes. The reason for this difference is simply that the Java
 *   SimpleDateFormat class imposes it.
 * 
 *   RestDataSource queuing support
 * 
 *   RestDataSource supports RPCManager.startQueue of DSRequests. This allows
 *   you to send multiple requests to the server in a single HTTP turnaround, thus minimizing
 *   network traffic and allowing the server to treat multiple requests as a single transaction,
 *   if the server is able to do so (in Power Edition and above, the SmartClient Server
 *   transparently supports grouping multiple REST requests in a queue into a single database
 *   transaction when using one of the built-in DataSource types). Note that you can disable
 *   queuing support with the RestDataSource.disableQueuing flag.
 * 
 *   If you want to use queuing with RestDataSource, you must use the "postMessage" dataProtocol
 *   with either XML or JSON dataFormat. Message format is similar to the non-queued examples
 *   shown earlier: it is simply extended to cope with the idea of multiple DSRequests
 *   encapsulated in the message.
 * 
 *   An example of the XML message sent from RestDataSource to the server for two update requests
 *   combined into a queue, using XML dataFormat:
 * 
 *   &lt;transaction&gt;
 *     &lt;operations&gt;
 *       &lt;request&gt;
 *         &lt;data&gt;
 *           &lt;pk&gt;1&lt;/pk&gt;
 *           &lt;countryName&gt;Edited Value&lt;/countryName&gt;
 *           &lt;capital&gt;Edited Value&lt;/capital&gt;
 *           &lt;continent&gt;Edited Value&lt;/continent&gt;
 *         &lt;/data&gt;
 *         &lt;dataSource&gt;countryDS&lt;/dataSource&gt;
 *         &lt;operationType&gt;update&lt;/operationType&gt;
 *       &lt/request&gt;
 *       &lt;request&gt;
 *         &lt;data&gt;
 *           &lt;pk&gt;2&lt;/pk&gt;
 *           &lt;capital&gt;Edited Value&lt;/capital&gt;
 *           &lt;population&gt;123456&lt;/population&gt;
 *         &lt;/data&gt;
 *         &lt;dataSource&gt;countryDS&lt;/dataSource&gt;
 *         &lt;operationType&gt;update&lt;/operationType&gt;
 *       &lt/request&gt;
 *     &lt;/operations&gt;
 *   &lt;transaction&gt;
 * 
 *   And the same message in JSON format:
 * 
 *   { 
 *     transaction: { 
 *       operations: [{
 *         dataSource:"countryDS", 
 *         operationType:"update", 
 *         data: {
 *           pk: 1
 *           countryName: "Edited Value",
 *           capital: "Edited Value",
 *           continent: "Edited Value"
 *         }
 *       }, {
 *         dataSource:"countryDS", 
 *         operationType:"update", 
 *         data: {
 *           pk: 2,
 *           capital: "Edited Value",
 *           popuilation: 123456
 *         }
 *       }]
 *     }
 *   }
 * 
 *   RestDataSource expects the response to a queue of requests to be a queue of responses in
 *   the same order as the original requests. Again, the message format is very similar to the
 *   unqueued REST format, it just has an outer container construct. Note also that the
 *   individual DSResponses in a queued response have an extra property,
 *   DSResponse.queueStatus. This allows each individual
 *   response to determine whether the queue as a whole succeeded. For example, if the first
 *   update succeeded but the second failed validation, the first response would have a
 *   status of 0, but a queueStatus of -1, while the second response
 *   would have both properties set to -1.
 * 
 *   The update queue example given above would expect a response like this (in XML):
 * 
 *   &lt;responses&gt;
 *     &lt;response&gt;
 *       &lt;status&gt;0&lt;/status&gt;
 *       &lt;queueStatus&gt;0&lt;/queueStatus&gt;
 *       &lt;data&gt;
 *         &lt;record&gt;
 *           &lt;countryName&gt;Edited Value&lt;/countryName&gt;
 *           &lt;gdp&gt;1700.0&lt;/gdp&gt;
 *           &lt;continent&gt;Edited Value&lt;/continent&gt;
 *           &lt;capital&gt;Edited Value&lt;/capital&gt;
 *           &lt;pk&gt;1&lt;/pk&gt;
 *         &lt;/record&gt;
 *       &lt;/data&gt;
 *     &lt;/response&gt;
 *     &lt;response&gt;
 *       &lt;status&gt;0&lt;/status&gt;
 *       &lt;queueStatus&gt;0&lt;/queueStatus&gt;
 *       &lt;data&gt;
 *         &lt;record&gt;
 *           &lt;countryName&gt;United States&lt;/countryName&gt;
 *           &lt;gdp&gt;7247700.0&lt;/gdp&gt;
 *           &lt;continent&gt;North America&lt;/continent&gt;
 *           &lt;independence&gt;1776-07-04&lt;/independence&gt;
 *           &lt;capital&gt;Washington DC&lt;/capital&gt;
 *           &lt;pk&gt;2&lt;/pk&gt;
 *           &lt;population&gt;123456&lt;/population&gt;
 *         &lt;/record&gt;
 *       &lt;/data&gt;
 *     &lt;/response&gt;
 *   &lt;/responses&gt;
 * 
 *   And in JSON:
 * 
 *   [
 *   {
 *     "response": {
 *       "queueStatus": 0,
 *       "status": 0, 
 *       "data": [{
 *         "countryName": "Edited Value",
 *         "gdp": 1700.0,
 *         "continent": "Edited Value",
 *         "capital": "Edited Value",
 *         "pk": 1
 *       }]
 *     }
 *   },
 *   {
 *     "response": {
 *       "queueStatus": 0,
 *       "status": 0,
 *       "data": [{
 *         "countryName": "United States",
 *         "gdp": 7247700.0,
 *         "continent": "North America",
 *         "independence": "1776-07-04",
 *         "capital": "Washington DC",
 *         "pk": 2,
 *         "population": 123456
 *       }]
 *     }
 *   }
 *   ]
 * 
 *   Hierarchical (Tree) data:
 * 
 *   To create a hierarchical DataSource, in the DataSource's fields array, a field
 *   must be specified as the parent id field - the field which will contain a pointer to the
 *   id of each node's parent.
 *   This can be achieved by setting the DataSourceField.foreignKey and the
 *   DataSourceField.rootValue attributes on the field definition. For example:
 * 
 *   RestDataSource.create({
 *    ID:"supplyItem",
 *    fields : [
 *      {name:"itemId", type:"sequence", primaryKey:true},
 *      {name:"parentId", type:"integer", foreignKey:"supplyItem.itemId", rootValue:0},
 *      ...
 *    ]
 *   });
 * 
 *   Tree Data is then treated on the server as a flat list of records linked by parent id.
 * 
 *   Tree data is typically displayed using a dataBound TreeGrid component. TreeGrids
 *   automatically create a ResultTree data object, which requests data directly
 *   from the DataSource. ResultTrees load data on demand, only requesting currently visible
 *   (open) nodes from the server. This is handled by including a specified value for the parent
 *   id field in the request criteria.
 *   To implement a standard load-on-demand tree RestDataSource back end, you should therefore
 *   simply return the set of nodes that match the criteria passed in.
 *   For example, if your DataSource was defined as the "supplyItem" code snippet above,
 *   a fetch request for all children of a node with itemId set to 12
 *   would have "parentId" set to 12 in the request criteria.
 *   A valid response would then contain all the records that matched this criteria. For example:
 * 
 *   &lt;response&gt;
 *    &lt;status&gt;0&lt;/status&gt;
 *    &lt;data&gt;
 *     &lt;record&gt;
 *       &lt;itemId&gt;15&lt;/itemId&gt;
 *       &lt;parentId&gt;12&lt;/parentId&gt;
 *     &lt;/record&gt;
 *     &lt;record&gt;
 *       &lt;itemId&gt;16&lt;/itemId&gt;
 *       &lt;parentId&gt;12&lt;/parentId&gt;
 *     &lt;/record&gt;
 *    &lt;/data&gt;
 *   &lt;/response&gt;
 * 
 *   The structure of responses for Add, Update and Delete type requests will be the
 *   same regardless of whether the data is hierarchical. However you should be aware that
 *   the underlying data storage may need to be managed slightly differently in some cases.
 * 
 *   Specifically, Add and Update operations may change the structure of the tree by returning a
 *   new parent id field value for the modified node. Depending on how your data is stored you
 *   may need to include special back-end logic to handle this.
 * 
 *   Also, if a user deletes a folder within a databound tree, any children of that folder will
 *   also be dropped from the tree, and can be removed from the back-end data storage.
 * 
 *   Note: For a general overview of binding components to Tree structured data, see
 *   treeDataBinding.
 */
open external class RestDataSource : DataSource {
    /**
     *  Rather than setting DataSource.dataProtocol, to control the format in which
     *   inputs are sent to the dataURL, you must specify a replacement OperationBinding
     *   and specify OperationBinding.dataProtocol on that operationBinding.
     * 
     *   This is because RestDataSource specifies default
     *   operationBindings for all operationTypes - see
     *   RestDataSource.operationBindings.
     *  @type {DSProtocol}
     *  @default null
     */
    override var dataProtocol: 
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
     *  Expected format for server responses. RestDataSources handle "json" and
     *   "xml" format responses by default. See class overview documentation for
     *   examples of responses in each format.
     *  @type {DSDataFormat}
     *  @default "xml"
     */
    override var dataFormat: 
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
     *  recordXPath mapping to the data node of XML returned by the server.
     *   Applies if this.dataFormat is set to "xml".
     *   The default value will pick up data from a response structured as follows:
     * 
     *   &lt;response&gt;
     *    &lt;status&gt;0&lt;/status&gt;
     *    &lt;data&gt;
     *     &lt;record&gt;
     *       &lt;field1&gt;value&lt;/field1&gt;
     *       &lt;field2&gt;value&lt;/field2&gt;
     *     &lt;/record&gt;
     *     &lt;record&gt;
     *       &lt;field1&gt;value&lt;/field1&gt;
     *       &lt;field2&gt;value&lt;/field2&gt;
     *     &lt;/record&gt;
     *    &lt;/data&gt;
     *   &lt;/response&gt;
     * 
     *  @type {string}
     *  @default "/response/data/\*"
     */
    open var xmlRecordXPath: String = definedExternally
    /**
     *  When RestDataSource.dataFormat is "xml", xmlNamespaces configures the set of
     *   namespace prefixes that are added to the document element of the XML message sent to the
     *   server. Format is the same as DataSource.xmlNamespaces.
     * 
     *   By default, the "xsi" prefix is bound to "http://www.w3.org/2001/XMLSchema-instance" in
     *   order to allow explicit null values in Records to be sent for
     *   DataSourceField.nillable. Set to null to avoid any
     *   prefixes being added.
     *  @type {object}
     *  @default "See below"
     */
    override var xmlNamespaces: dynamic = definedExternally
    /**
     *  recordXPath mapping to the data node of json returned by the server.
     *   Applies if this.dataFormat is set to "json"
     *   The default value will pick up data from a response structured as follows:
     * 
     *   {response:
     *   {status:0,
     *    data:[
     *     {field1:"value", field2:"value"},
     *     {field1:"value", field2:"value"}
     *    ]
     *   }
     *   
     *  @type {string}
     *  @default "/response/data"
     */
    open var jsonRecordXPath: String = definedExternally
    /**
     *  For RestDataSources, by default, either the RestDataSource.xmlRecordXPath or
     *   RestDataSource.jsonRecordXPath is used based on the RestDataSource.dataFormat
     *   setting.
     * 
     *   Note that you can also apply record xpath binding via
     *   OperationBinding.recordXPath.
     *  @type {string}
     *  @default null
     */
    override var recordXPath: String = definedExternally
    /**
     *  When using dataFormat:"json" and dataProtocol:"postMessage" should we use the
     *   JSONEncoder.prettyPrint feature to enable indented, highly readable JSON messages.
     * 
     *   True by default because the bandwidth involved is generally negligible and the benefits for
     *   troubleshooting are key.
     *  @type {boolean}
     *  @default true
     */
    open var prettyPrintJSON: Boolean = definedExternally
    /**
     *  If set, disables RPCManager.startQueue for this RestDataSource.
     *  @type {boolean}
     *  @default false
     */
    open var disableQueuing: Boolean = definedExternally
    /**
     *  Allows you to specify an arbitrary prefix string to apply to all json format responses
     *   sent from the server to this application. The client will expect to find this prefix
     *   on any JSON response received for this DataSource, and will strip it off before evaluating
     *   the response text.
     * 
     *   The default prefix is "&lt;SCRIPT&gt;//'\"]]&gt;&gt;isc_JSONResponseStart&gt;&gt;".
     * 
     *   The inclusion of such a prefix ensures your code is not directly executable outside of
     *   your application, as a preventative measure against
     *   javascript hijacking.
     * 
     *   You can switch off JSON wrapping altogether by setting both this and RestDataSource.jsonSuffix
     *   to empty strings.
     * 
     *   If you are using SmartClient Server's RESTHandler servlet, see the server-side Javadocs
     *   for details of how to change the way JSON wrapping works on the server side.
     *  @type {string}
     *  @default "See below"
     */
    override var jsonPrefix: String = definedExternally
    /**
     *  Allows you to specify an arbitrary suffix string to apply to all json format responses
     *   sent from the server to this application. The client will expect to find this suffix
     *   on any JSON response received for this DataSource, and will strip it off before evaluating
     *   the response text.
     * 
     *   The default suffix is "//isc_JSONResponseEnd".
     *  @type {string}
     *  @default "See below"
     */
    override var jsonSuffix: String = definedExternally
    /**
     *  RestDataSource OperationBindings set to specify default dataProtocol per operationType.
     *   Default databindings are:
     * 
     *    operationBindings : [
     *     {operationType:"fetch", dataProtocol:"getParams"},
     *     {operationType:"add", dataProtocol:"postParams"},
     *     {operationType:"remove", dataProtocol:"postParams"},
     *     {operationType:"update", dataProtocol:"postParams"}
     *    ],
     * 
     *   If you are integrating with a RestDataSource server that requires the more
     *   obscure RPCRequest.httpMethods of "PUT", "DELETE" or "HEAD", you can specify these
     *   httpMethod settings via OperationBinding.requestProperties. dataProtocol settings
     *   that mention "GET" or "POST" are compatible with these additional HTTP methods as well.
     *   Typical DataSource.operationBindings for a REST server that uses
     *   "PUT" and "DELETE" are as follows:
     * 
     *    operationBindings:[
     *     {operationType:"fetch", dataProtocol:"getParams"},
     *     {operationType:"add", dataProtocol:"postParams"},
     *     {operationType:"remove", dataProtocol:"getParams", requestProperties:{httpMethod:"DELETE"}},
     *     {operationType:"update", dataProtocol:"postParams", requestProperties:{httpMethod:"PUT"}}
     *    ],
     * 
     * 
     *   Note that dataProtocol:"postMessage" is always used when
     *   RPCManager.startQueue is used to send multiple DSRequests to the server
     *   as a single HttpRequest. See RestDataSource docs, "queuing support". We also
     *   recommend that you use the "postMessage" protocol whenever you are intending to use
     *   AdvancedCriteria with RestDataSource - this is discussed in the section "Server inbound
     *   data format" in the RestDataSource.
     * 
     *  @type {Array<Partial<OperationBinding>>}
     *  @default "[...]"
     */
    override var operationBindings: Array<dynamic> = definedExternally
    /**
     *  Default URL to contact to fulfill all DSRequests.
     *   RestDataSources also allow per-operationType dataURLs to be set via
     * 
     * 
     *  - RestDataSource.fetchDataURL
     * 
     *  - RestDataSource.addDataURL
     * 
     *  - RestDataSource.updateDataURL
     * 
     *  - RestDataSource.removeDataURL
     * 
     *   NOTE:: when using RPCManager.startQueue with RestDataSource, an
     *   HTTP request containing mixed DSRequest.operationType (such as a
     *   mixture of "add", "update" and "remove" operations resulting from
     *   ListGrid.autoSaveEdits) can only go to one URL, so you
     *   should not set distinct URLs for each operationType; doing so will break
     *   queuing of mixed operationTypes: multiple requests will be sent to distinct URLs, and a
     *   warning logged.
     *  @type {string}
     *  @default null
     */
    override var dataURL: String = definedExternally
    /**
     *  Custom DataSource.dataURL for DSRequest with
     *   DSRequest.operationType "fetch".
     * 
     *   Use RestDataSource.dataURL to configure a single URL for all requests, which is
     *   required to support RPCManager.startQueue.
     *  @type {string}
     *  @default null
     */
    open var fetchDataURL: String = definedExternally
    /**
     *  Custom DataSource.dataURL for DSRequest with
     *   DSRequest.operationType "update".
     * 
     *   See RestDataSource.dataURL to configure a single URL for all requests, which is
     *   required to support RPCManager.startQueue.
     *  @type {string}
     *  @default null
     */
    open var updateDataURL: String = definedExternally
    /**
     *  Custom DataSource.dataURL for DSRequest with
     *   DSRequest.operationType "add".
     * 
     *   See RestDataSource.dataURL to configure a single URL for all requests, which is
     *   required to support RPCManager.startQueue.
     *  @type {string}
     *  @default null
     */
    open var addDataURL: String = definedExternally
    /**
     *  Custom DataSource.dataURL for DSRequest with
     *   DSRequest.operationType "remove".
     * 
     *   See RestDataSource.dataURL to configure a single URL for all requests, which is
     *   required to support RPCManager.startQueue.
     *  @type {string}
     *  @default null
     */
    open var removeDataURL: String = definedExternally
    /**
     *  Should operation meta data be included when assembling parameters to send
     *   to the server? If true, meta data parameters will be prefixed with the
     *   RestDataSource.metaDataPrefix.
     *   Applies to operations where OperationBinding.dataProtocol is set to
     *   "getParams" or "postParams" only.
     *  @type {boolean}
     *  @default true
     */
    open var sendMetaData: Boolean = definedExternally
    /**
     *  If RestDataSource.sendMetaData is true, this attribute is used to specify
     *   the prefix to apply to 'meta data' properties when assembling parameters to send to the
     *   server. Applies to operations where OperationBinding.dataProtocol is set to
     *   "getParams" or "postParams" only.
     *  @type {string}
     *  @default "_"
     */
    open var metaDataPrefix: String = definedExternally
    /**
     *   RestDataSource overrides transformRequest and handles serializing the request in the
     *   appropriate format (determined by the specified
     *   OperationBinding.dataProtocol), including the submitted
     *   DSRequest.data as well as the meta data parameters, which may include -
     *   DSRequest.dataSource,
     *   DSRequest.operationType, DSRequest.operationId;
     *   DSRequest.startRow and DSRequest.endRow (for fetches);
     *   DSRequest.sortBy and DSRequest.textMatchStyle
     *   (for fetches);
     *   DSRequest.oldValues (for update and remove operations);
     *   and possibly DSRequest.componentId.
     * 
     *   If you override this method in order to add additional data to the DSRequest, you must
     *   call Class.Super or you will remove the functionality provided by
     *   RestDataSource. For example:
     * 
     *    transformRequest : function (dsRequest) {
     *      // modify dsRequest.data here, for example, add fixed criteria
     *      dsRequest.data.userId = myApplication.getCurrentUserId();
     *   
     *      return this.Super("transformRequest", arguments);
     *    }
     * 
     * 
     *   See RestDataSource for a description of the
     *   standard formatting applied to requests.
     * 
     * 
     */
    open fun transformRequest(): Unit = definedExternally
    /**
     *   RestDataSource implements transformResponse in order to extract data and meta-data
     *   properties from server responses, as described in the
     *   RestDataSource.
     * 
     *   You can override transformResponse() in order to further modify the
     *   response, but if you do so, call Class.Super as shown below or you will
     *   wipe out the built-in response processing behavior of RestDataSource.
     * 
     *   transformResponse : function (dsResponse, dsRequest, data) {    
     *     var dsResponse = this.Super("transformResponse", arguments);
     *     // ... do something to dsResponse ...
     *     return dsResponse;
     *   }
     * 
     * 
     *  @param {DSResponse} default DSResponse derived from the response data
     *  @param {DSRequest} DSRequest object that initiated this request
     *  @param {XMLDocument | JSON} XML document or JSON objects returned by the web                  service
     */
    override fun transformResponse(dsResponse: DSResponse, dsRequest: DSRequest, data: dynamic): DSResponse = definedExternally
    companion object {
        /**
         *  Creates a new RestDataSource
         * 
         *  @param typeCheckedProperties {Partial<RestDataSource>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {RestDataSource} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): RestDataSource = definedExternally
    }
}