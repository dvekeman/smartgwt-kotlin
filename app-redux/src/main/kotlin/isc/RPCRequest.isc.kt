@file:JsQualifier("isc")
package isc

/**
 *  Encapsulates a client/server RPC request. You'll need to provide an instance of this class (or a
 *   constructor for it) to the RPCManager.sendRequest method. If you use the
 *   RPCManager.send method, an instance of RPCRequest will be created for you.
 */
open external class RPCRequest {
    /**
     *  This attribute specifies the payload of the RPCRequest.
     * 
     *   When using the iscServer,
     *   any JavaScript simple type or arbitrarily nested set of Objects and Arrays can be sent
     *   to server and automatically translated to Java Objects.
     * 
     * 
     * 
     *   Here are the
     *   mapping of JavaScript types to their corresponding server object types:
     * 
     * 
     *    JS Type   Java Type
     *    Object: {}     Map
     *    Array: []     List
     *    String       String
     *    Number       Long|Double
     *    Boolean      Boolean
     *    Date        java.util.Date
     *    String       com.smartgwt.client.types.ValueEnum
     * 
     * 
     * 
     *   Note that the order of keys/values in the Maps created on the server is not guaranteed
     *   because JavaScript Object literals do not guarantee order.
     * 
     *   When using JPA or Hibernate Java value used can be affected by the Java Bean declaration.
     *   See dsRequestBeanTypes for details.
     * 
     *   Server->client conversion follows this table as well, with some extras. See the toJS()
     *   method on JSTranslater in the server documentation for a description of additional
     *   behaviors.
     * 
     *   When not communicating with the SmartClient server, rpcRequest.data
     *   becomes simple HTTP parameters or an HTTP request body - see RPCRequest.useSimpleHttp
     *   for details.
     *  @type {string | Record | object}
     *  @default null
     */
    open var data: dynamic = definedExternally
    /**
     *  Overrides RPCManager.actionURL for this request only. If you're using queuing, note that queues
     *   as per-URL - in other words all RPCRequests in a queue must go to a single URL. If you attempt
     *   to send a request with an actionURL that is different from those already in the queue, it
     *   will be sent to the server separately, ahead of the queue, and a warning will be logged to
     *   the Developer Console.
     *  @type {URL}
     *  @default "[ISOMORPHIC]/IDACall"
     */
    open var actionURL: String = definedExternally
    /**
     *  Indicates whether this request should use the HttpProxyServlet in order to enable contacting
     *   hosts other than the origin server (available only in Pro Edition or better).
     * 
     *   When various UI components issues requests automatically, or when a call to
     *   RPCManager.sendProxied is made, the HttpProxy will automatically be used for a URL
     *   that starts with "http" and uses a hostname other than "localhost" or
     *   window.location.hostname, or if the port number differs.
     * 
     *   rpcRequest.useHttpProxy should only be used to force requests to go through the
     *   HttpProxy when the above rules don't work, or to avoid using the HttpProxy when contacting
     *   hosts that allow cross-site calls via the
     *   Http Access Control
     *   standard.
     * 
     *   You can also set RPCManager.useHttpProxy:false to avoid ever using the
     *   HttpProxyServlet.
     *  @type {boolean}
     *  @default null
     */
    open var useHttpProxy: Boolean = definedExternally
    /**
     *  The proxy URL to use for this request (if RPCRequest.useHttpProxy is set for this
     *   request). If unset, the value of RPCManager.httpProxyURL will be used instead.
     *  @type {string}
     *  @default null
     */
    open var httpProxyURL: String = definedExternally
    /**
     *  In browsers that support Cross-Origin Resource Sharing
     *   and XMLHttpRequest 2,
     *   and where the service at the RPCRequest.actionURL allows the origin to send credentials
     *   (see Access-Control-Allow-Credentials),
     *   should user credentials such as cookies,
     *   HTTP authentication, and client-side SSL certificates be sent with the actual CORS request?
     * 
     *   This setting only applies when the request RPCRequest.transport is
     *   "xmlHttpRequest".
     * 
     * 
     *   Note that Internet Explorer 10 and 11 do not send cookies as part of user credentials:
     *   IE10 doesn't support cookies on cross origin XMLHttpRequest withCredentials=true.
     *  @type {boolean}
     *  @default null
     */
    open var withCredentials: Boolean = definedExternally
    /**
     *  Controls the prompt style for this request only. Defaults to
     *   RPCManager.promptStyle.
     *  @type {PromptStyle}
     *  @default "cursor"
     */
    open var promptStyle: 
                          /**
                           *  Displays a centered modal prompt with text specified by         RPCRequest.prompt
                           *  Changes the current cursor to the style specified by         RPCRequest.promptCursor
                           */
                          String /* dialog |  cursor */ = definedExternally
    /**
     *  If true, an image is shown to the right of the cursor when RPCRequest.promptStyle is
     *   set to "cursor", otherwise the cursor itself is modified via css to the value of
     *   RPCRequest.promptCursor.
     * 
     *   If left unspecified, the default value is set by RPCManager.useCursorTracker.
     *  @type {boolean}
     *  @default false
     */
    open var useCursorTracker: Boolean = definedExternally
    /**
     *  Controls the cursor shown when RPCManager.promptStyle is set to
     *   "cursor" for this request only. Defaults to RPCManager.promptCursor.
     *  @type {string}
     *  @default "progress"
     */
    open var promptCursor: String = definedExternally
    /**
     *  Overrides RPCManager.defaultPrompt for this request only. If you're using queuing, note that the
     *   prompt string from the first request in the queue is the one that is shown to the user.
     *  @type {HTMLString}
     *  @default "Contacting server..."
     */
    open var prompt: String = definedExternally
    /**
     *  Overrides RPCManager.showPrompt for this request only.
     * 
     *   If you're using queuing, note that if any of the requests in the queue specify
     *   showPrompt:true, then a prompt will be shown for the entire queue with the prompt text of
     *   the first request in the queue to specify a custom prompt if promptStyle is set to "dialog".
     * 
     *   If promptStyle is set to "cursor" for the request that specified showPrompt: true, then the
     *   entire queue uses the "cursor" style for the prompt.
     *  @type {boolean}
     *  @default null
     */
    open var showPrompt: Boolean = definedExternally
    /**
     *  Overrides RPCManager.promptDelay for this request only. Defaults to RPCManager.promptDelay.
     * 
     *   If you're using queuing, note that the promptDelay of the first request is used for the entire queue.
     *  @type {number}
     *  @default 300
     */
    open var promptDelay: Number = definedExternally
    /**
     *  If you expect to receive a response to your RPC request, you can specify a callback that
     *   will be called with an instance or RPCResponse class as sent by the server. Queuing does
     *   not affect callbacks in any way - your specified callback will be invoked for each
     *   RPCRequest that contained a callback regardless of whether the request was sent as part of a
     *   queue or not.
     * 
     *   Note that if the request encounters an error (such as 500 server error), by default the
     *   callback will not be fired, instead, RPCManager.handleError is called to
     *   invoke the default system-wide error handling. Set RPCRequest.willHandleError:true to have your
     *   callback invoked regardless of whether there are errors, however, make sure your callback
     *   properly handles malformed responses when RPCResponse.status is non-zero. See the
     *   errorHandling for more details.
     *  @type {RPCCallback}
     *  @default null
     */
    open var callback: ((response: RPCResponse, rawData: dynamic, request: RPCRequest) -> Unit) = definedExternally
    /**
     *  An object to be held onto for the duration of the RPC turnaround to track
     *   application-specific context.
     * 
     *   When an RPC turnaround completes, the clientContext is available in the
     *   Callbacks.RPCCallback as rpcResponse.clientContext. The
     *   clientContext is never sent to the server.
     * 
     *   The clientContext is useful for holding onto state that will be used when the
     *   Callbacks.RPCCallback fires, such as the name of a component that will receive the
     *   returned data.
     *  @type {object}
     *  @default null
     */
    open var clientContext: dynamic = definedExternally
    /**
     *  With willHandleError:false, rpcResponses that indicate an error go through centralized
     *   handling in the RPCManager and rpcRequest.callback is never invoked.
     * 
     *   Setting willHandleError:true means that your rpcRequest.callback will receive rpcResponses
     *   that have an error status and must handle them.
     * 
     *   See also the error handling section in the RPCManager docs.
     *  @type {boolean}
     *  @default false
     */
    open var willHandleError: Boolean = definedExternally
    /**
     *  Sets the timeout on this request. Default is to use RPCManager.defaultTimeout.
     * 
     *   If you're using RPCManager.startQueue, note that the timeout setting derived
     *   from the last request in the queue is used for the entire queue. If you want to override
     *   the timeout for the queue, make sure to set your override at least on the last request in
     *   the queue.
     * 
     *   For the "xmlHttpRequest" RPCRequest.transport, this timeout can only happen
     *   if the server actually fails to respond within the specified number of milliseconds. For
     *   the "hiddenFrame" transport, this timeout will occur for non-200 (HTTP_OK) responses.
     * 
     *   If timeout is set to zero, the RPCManager will not enforce a timeout for this
     *   request. However, note that all browsers enforce their own timeouts on HTTP requests, and
     *   may have different timeouts for different kinds of failures (no response at all from server,
     *   hung response after receiving headers, hung response after receiving partial data, etc).
     *   Also, intervening web proxies or firewalls may impose timeouts of their own.
     * 
     *   As a rough rule of thumb, if your server response will have a lengthy pause before data
     *   begins to be sent, 1-2 minutes is the maximum allowable pause for a public site and still may
     *   not work for a minority of users, but up to 4 minutes may be allowable in a controlled
     *   environment (intranet or extranet with well-known user base).
     * 
     *   Above these limits, your code should return some kind of immediate response to the browser,
     *   then kick off a server-side process to complete processing. The browser can then either
     *   poll for completion, or use a server-push notification system such as SmartClient Real-Time
     *   Messaging (see http://smartclient.com/product).
     *  @type {Integer}
     *  @default null
     */
    open var timeout: Number = definedExternally
    /**
     *  Values to be sent as simple HTTP params, as a JavaScript Object where each property/value
     *   pair will become an HTTP parameter name and value. These parameters are then accessible on
     *   the server, for example, using servletRequest.getParameter(paramName) in Java Servlets.
     * 
     *   Array-valued parameters will be submitted as multiple instances of the same parameter,
     *   similar to an HTML form with a multi-select (?paramName=value1&amp;paramName=value2 ...),
     *   accessible as getParameterValues(paramName) in Java Servlets. Any non-atomic type, such as
     *   an Object, will be serialized to JSON by the
     *   JSONEncoder. If this isn't desirable, serialize the data in advance so that the
     *   value provided in rpcRequest.params is a String.
     * 
     *   Note that this API is primarily used in combination with RPCRequest.useSimpleHttp -
     *   when contacting the SmartClient Server, use RPCRequest.data instead, which provides
     *   full JavaScript &lt;-&gt; Java translation of arbitrary structures.
     *   rpcRequest.params can also be used with the SmartClient Server, where it
     *   provides an an opportunity to send additional data aside from the main
     *   RPCRequest.data payload. This is useful for adding data to DataSource requests which
     *   will be kept separate from the automatically sent DataSource data, or for making parts of
     *   the request visible in the URL for HTTP-level logging or layer 4 switches.
     * 
     *   Note that in contrast to RPCRequest.data object, the data in
     *   rpcRequest.params is not deserialized by the SmartClient server, and
     *   all values arrive on the server as String type (like HTTP parameters always do).
     * 
     * 
     *   The params value can also be specified as a componentID or component instance that provides
     *   a method getValues() that returns an Object containing parameter names and values.
     *   SmartClient components DynamicForm, ValuesManager are two such
     *   classes. Lastly, you may specify the ID of a native form element (retrievable via
     *   getElementById()) and the params will be populated from there. If there is an error
     *   resolving your params directive, it will be logged to the Developer Console.
     * 
     * 
     *   Note: The params are submitted once per http transaction. If you are using
     *   RPCManager.startQueue to bundle multiple RPCRequests or DSRequests
     *   into a single HTTP turnaround, the params from the various RPCRequests will be merged,
     *   with the later-queued transactions winning on parameter name collisions. A warning will be
     *   logged in the Developer Console if multiple RPCRequests specified params.
     *  @type {object}
     *  @default null
     */
    open var params: dynamic = definedExternally
    /**
     *  This works similarly to RPCRequest.serverOutputAsString except the resulting String
     *   is automatically evaluated as JavaScript. The result of the evaluation is then passed to
     *   any specified RPCRequest.callback as RPCResponse.data.
     * 
     *   This feature can be used to dynamically load new application modules into a running
     *   application. An RPCRequest with evalResult enabled can be used to fetch a
     *   static .js file or JavaScript dynamically generated by the server. The returned JavaScript
     *   can contain anything that a JavaScript file loaded at init time can contain, including new
     *   views and new SmartClient class definitions.
     * 
     *   Example usage with RPCManager.sendRequest:
     * 
     *   isc.RPCManager.sendRequest({
     *     evalResult:true,
     *     actionURL:"js/loadLabel.js",
     *     evalVars:{var1:"A Value"}
     *   });
     * 
     *   This call would execute the code from loadLabel.js, and make the variable
     *   var1 available to that code. Therefore if the .js file contained this code:
     * 
     *   isc.Label.create({
     *     contents:var1
     *   })
     * 
     *   A label would be created with contents set to the value of var1 - the string
     *   "A Value".
     * 
     * 
     *   This feature relies on the XMLHttpRequest object which can be disabled by end-users in some
     *   supported browsers. See platformDependencies for more information.
     *  @type {boolean}
     *  @default false
     */
    open var evalResult: Boolean = definedExternally
    /**
     *  If you've set RPCRequest.evalResult : true, then the property values of this object
     *   will be available in the evaluation scope of the result under the variable names
     *   specified by the property names.
     * 
     *   So e.g. if evalVars is: {foo: "bar"} then a reference to the
     *   variable foo in the result will evaluate to "bar".
     *  @type {object}
     *  @default null
     */
    open var evalVars: dynamic = definedExternally
    /**
     *  For use only with the RPCTransport transport, this attribute
     *   specifies the name of the URL parameter which is used to specify the callback function that
     *   the server is expected to call by writing out JavaScript code. The actual function to call
     *   is automatically generated and differs for every request (to allow concurrency).
     * 
     *   For example, with callbackParam set to it's default value of "callback", the
     *   server might be contacted with a URL like:
     * 
     *    loadData?callback=isc_scriptIncludeCallback_5
     * 
     *   .. then the server's response should look like:
     * 
     *    isc_scriptIncludeCallback_5({ .. data .. });
     * 
     *   The name "isc_scriptIncludeCallback_5" is automatically generated and will differ each time
     *   the server is contacted.
     * 
     *   SmartClient makes of this server-provided callback mechanism, then calls
     *   RPCRequest.callback normally.
     * 
     *   rpcRequest.callbackParam is ignored by all transport other than
     *   scriptInclude.
     *  @type {string}
     *  @default "callback"
     */
    open var callbackParam: String = definedExternally
    /**
     *  If RPCRequest.evalResult is set, setting this property to true causes
     *   Canvas.autoDraw to be set to false for the duration of the result evaluation -
     *   which is generally what you want if you're returning new components from the server.
     * 
     *   This also effects components loaded via the RPCManager.loadScreen API.
     *  @type {boolean}
     *  @default true
     */
    open var suppressAutoDraw: Boolean = definedExternally
    /**
     *  Setting this flag makes the body of the HTTP response available as a String in the
     *   RPCRequest.callback as RPCResponse.data. This is typically only useful if you
     *   are sending a request that will not be received by the SmartClient Java Server,
     *   however in that case, set RPCRequest.useSimpleHttp:true instead, which implies
     *   serverOutputAsString:true.
     * 
     *   serverOutputAsString:true allows you to, for example, load the contents of
     *   static files off your webserver into a string for processing on the client with no server
     *   support. The RPCRequest.actionURL must be in the same domain as the current page for
     *   this to work.
     * 
     *   This feature relies on the XMLHttpRequest object which can be disabled by end-users in some
     *   supported browsers. See platformDependencies for more information.
     * 
     *   Generally this API is used for either nonJavaBackend
     *   or for advanced usage such as content that requires processing before it can be used in
     *   SmartClient components (such as client-side web scraping). Note that SmartClient provides
     *   higher-level APIs for loading common types of data, see eg HTMLFlow for HTML content,
     *   ViewLoader for loading SmartClient components, XMLTools.loadXML for loading
     *   XML, RPCRequest.evalResult for loading JSON, and
     *   DataSource for loading structured data in various formats.
     *  @type {boolean}
     *  @default false
     */
    open var serverOutputAsString: Boolean = definedExternally
    /**
     *  Advanced flag to avoid a potential memory leak in Internet Explorer 9 for requests
     *   with JSON formatted responses.
     * 
     *   This attribute may be set to false to explicitly enable the
     *   workaround described RPCManager.allowIE9Leak for this request,
     *   avoiding a potential memory leak in Internet Explorer 9.
     * 
     *   This workaround has a limitation in that if parsing the JSON response generates
     *   certain object types including JavaScript Date or function
     *   objects, attempts to interact with these objects can subsequently lead to a
     *   JavaScript error with the message "Can't execute code from a freed script".
     * 
     *   This workaround therefore may not be suitable for all transactions or dataSources
     *   within a given application.
     * 
     *   This property may also be set globally within an application (via
     *   RPCManager.allowIE9Leak)_.
     * 
     *   Note: This memory leak and workaround is discussed further in the online
     *   SmartClient FAQ.
     *  @type {boolean}
     *  @default null
     */
    open var allowIE9Leak: Boolean = definedExternally
    /**
     *  Selects the transport used for this RPCRequest. If unset, the value of
     *   RPCManager.defaultTransport will be used.
     * 
     *   If you're using queueing, note that all requests in the queue must use the same transport.
     *   If you attempt to send a request via a different transport than those that are currently on
     *   the queue, it will be sent to the server separately, ahead of the queue, and a warning will
     *   be logged to the Developer Console.
     * 
     *   If you specify an unknown transport, an error will be logged to the DeveloperConsole and
     *   RPCManager.defaultTransport will be used instead.
     * 
     *   If you specify the xmlHttpRequest transport and it is not available, a warning will be
     *   logged to the Developer Console and the RPCManager will attempt to use the
     *   hiddenFrame transport instead for this request. Note that some features like
     *   RPCRequest.serverOutputAsString require the xmlHttpRequest transport and will not
     *   work if the xmlHttpRequest transport is unavailable (this can happen if the end user is
     *   using Internet Explorer and has disabled ActiveX). You can check whether or not the
     *   xmlHttpRequest transport is currently available by calling
     *   RPCManager.xmlHttpRequestAvailable.
     *  @type {RPCTransport}
     *  @default "xmlHttpRequest"
     */
    open var transport: 
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
     *  Selects the default http transport for this RPCRequest. If set to true, this request will use
     *   XMLHttpRequest for the transport to the server. If set to false it will use a hidden frame. If
     *   left unset, the transport mechanism is determined from the RPCManager default set in
     *   RPCManager.useXmlHttpRequest
     * 
     *   If you're using queueing, note that all requests in the queue must use the same transport.
     *   If you attempt to send a request via a different transport than those that are currently on
     *   the queue, it will be sent to the server separately, ahead of the queue, and a warning will
     *   be logged to the Developer Console.
     * 
     *   If you specify true for this attribute and XMLHttp is not available, a warning
     *   will be logged to the Developer Console and RPCManager will attempt to use the frames
     *   transport for this request. Note that some features like
     *   RPCRequest.serverOutputAsString require the XMLHttp transport and will not work if the
     *   XMLHttp transport is unavailable (this can happen if the end user is using Internet Explorer
     *   and has disabled ActiveX). You can query the availability of XMLHttp by calling
     *   RPCManager.xmlHttpRequestAvailable
     *  @deprecated \* As of SmartClient 5.5, use RPCRequest.transport. If you specify a value for this property, it will take precedence over RPCRequest.transport.
     *  @type {boolean}
     *  @default undefined
     */
    open var useXmlHttpRequest: Boolean = definedExternally
    /**
     *  Selects the HTTP method that will be used for the request. Typical values are "POST" and
     *   "GET".
     * 
     *   The more obscure "PUT", "DELETE" and "HEAD" methods are also valid, however, none of these
     *   are supported by the Safari browser previous to version 3.0.
     *  @type {string}
     *  @default "POST"
     */
    open var httpMethod: String = definedExternally
    /**
     *  Valid with the xmlHttpRequest transport only and only when
     *   RPCRequest.httpMethod is set to "POST".
     *  @type {string}
     *  @default "application/x-www-form-urlencoded"
     */
    open var contentType: String = definedExternally
    /**
     *  HTTP headers to send, as a Object mapping Header name -> Header value, eg
     *   { "Content-Type" : "text/xml" }
     * 
     *   Valid with the xmlHttpRequest RPCRequest.transport only.
     *  @type {object}
     *  @default null
     */
    open var httpHeaders: dynamic = definedExternally
    /**
     *  For use during relogin, this property marks this request an attempt to
     *   login, therefore a response containing the loginRequiredMarker is a normal
     *   condition and should result in the status code RPCResponse.STATUS_LOGIN_INCORRECT
     *   rather than a call to RPCManager.loginRequired.
     * 
     *   It is not required to set containsCredentials, however, it does typically
     *   simplify relogin logic by separating the handling of RPCs that are login attempts from RPCs
     *   that are not.
     *  @type {boolean}
     *  @default false
     */
    open var containsCredentials: Boolean = definedExternally
    /**
     *  When set to true, no reply is expected from the server. However, if a reply is received, it will
     *   be processed.
     * 
     *   Note: setting this to true, forces RPCRequest.sendNoQueue to true for
     *   this request.
     *  @type {boolean}
     *  @default false
     */
    open var ignoreTimeout: Boolean = definedExternally
    /**
     *  When set to true, this request is sent to the server immediately, bypassing any current queue.
     *  @type {boolean}
     *  @default false
     */
    open var sendNoQueue: Boolean = definedExternally
    /**
     *  When set to true, assume the request is not going to the SmartClient server, and hence send
     *   a simple HTTP request. Values specified in RPCRequest.params are sent to to the
     *   server as HTTP request parameters. If RPCRequest.httpMethod method is POST and
     *   RPCRequest.data is supplied, it is assumed to be a string to post as the HTTP
     *   requestBody.
     * 
     *   Setting this to true automatically defaults RPCRequest.serverOutputAsString to true
     *   as well.
     *  @deprecated \* As of SmartClient 5.6, use RPCRequest.useSimpleHttp instead.
     *  @type {boolean}
     *  @default false
     */
    open var paramsOnly: Boolean = definedExternally
    /**
     *  When set to true, assume the request is not going to the SmartClient server, and hence send
     *   a simple HTTP request that does not use SmartClient-specific request encoding.
     * 
     *   Values specified in RPCRequest.params are sent to to the server as HTTP request
     *   parameters. If RPCRequest.httpMethod is "GET", parameters appear in the request URL, otherwise
     *   if httpMethod is "POST", parameters are encoded in the request body (exactly like an HTML form
     *   does). These parameters are then accessible via typical server-side APIs for retrieving
     *   HTTP parameters, eg, servletRequest.getParameter(paramName) in Java Servlets.
     * 
     *   Note that if RPCRequest.httpMethod method is POST and RPCRequest.data is supplied,
     *   RPCRequest.data is assumed to be a string to post as the HTTP request body, and
     *   RPCRequest.params are sent as URL parameters instead. This usage is for sending
     *   custom request bodies such as the XML payloads used for SOAP. In this case,
     *   RPCRequest.contentType is typically also set to indicate the content type of the
     *   request body.
     * 
     *   Setting useSimpleHttp to true also automatically sets
     *   RPCRequest.serverOutputAsString to true as well.
     *  @type {boolean}
     *  @default false
     */
    open var useSimpleHttp: Boolean = definedExternally
    /**
     *  For xmlHttp transport + httpMethod: "GET" only, set to true to force a conditional
     *   GET request even if the browser thinks it has a current cached response.
     *  @type {boolean}
     *  @default false
     */
    open var bypassCache: Boolean = definedExternally
    /**
     *  If enabled, the server omits any key/value pairs in map that have null values from the
     *   response. This can reduce the size of the response when many fields have null values.
     * 
     *   To enable this globally for all responses you can set RPCManager.omitNullMapValuesInResponse
     *   in server_properties.
     *  @type {boolean}
     *  @default false
     */
    open var omitNullMapValuesInResponse: Boolean = definedExternally
    /**
     *  If enabled, causes the RPCRequest to download the requested resource as a file, either
     *   showing the browser's Save dialog or displaying the file-content in
     *   RPCRequest.downloadToNewWindow.
     * 
     *   Setting this attribute to true means that no callback will be fired and implies that the
     *   request will silently use RPCRequest.transport: "hiddenFrame".
     *  @type {boolean}
     *  @default false
     */
    open var downloadResult: Boolean = definedExternally
    /**
     *  When RPCRequest.downloadResult is true, setting this attribute to
     *   true causes the content of the downloaded file to be displayed in a new browser window.
     *  @type {boolean}
     *  @default false
     */
    open var downloadToNewWindow: Boolean = definedExternally
    /**
     *  If enabled and request is applied to RPCManager.cacheScreens or
     *   RPCManager.loadScreen indicates that
     *   referenced DataSources should be loaded in mock mode.
     *  @type {boolean}
     *  @default null
     */
    open var mockMode: Boolean = definedExternally
}