@file:JsQualifier("isc")
package isc

/**
 *  RPCManager is a static singleton class that manages transparent client/server RPC (remote
 *   procedure call). This class provides a generic, low-level client/server communication
 *   integration point.
 * 
 *   SmartClient's powerful databinding subsystem (see DataSource,
 *   DataBoundComponent) automatically make use of this class to issue
 *   RPCs as necessary, based on the
 *   dataSourceOperations. To integrate DataBoundComponents
 *   with your server, clientServerIntegration.
 * 
 *   For arbitrary client/server interactions outside of the DataSource subsystem, the
 *   SmartClient server also provides the dmiOverview feature.
 * 
 *   The RPCManager class can also be used directly to send data to a URL of your
 *   choosing and optionally be called back with server-returned data when the server replies.
 * 
 *   The SmartClient iscServer has APIs for processing RPC requests
 *   providing features such as automatic Java &lt;--&gt; JavaScript object translation
 *   and handling of queued requests.
 *   The servletDetails makes use of these features to handle standard
 *   DataSource requests and DMI calls. Developers can also override the
 *   actionURL of specific requests and use these APIs directly in a
 *   JSP, Servlet or Filter.
 * 
 *   Note: the client-side RPCManager class can also be used without the SmartClient server.
 *   For an overview of client/server interactions without the SmartClient server, see
 *   nonJavaBackend.
 * 
 *   Simple arbitrary Remote Procedure Call example (client code):
 * 
 * 
 * 
 *   var data = { here: "is some data", to: ["send to the server"]};
 *   isc.RPCManager.sendRequest({ data: data, callback: "myCallback(data)", actionURL: "/rpcHandler.jsp"});
 *   function myCallback(data) { alert("response from the server: " + data); }
 * 
 * 
 * 
 * 
 *   Simple arbitrary Remote Procedure Call example (server code: /rpcHandler.jsp):
 * 
 *   RPCManager rpc = new RPCManager(request, response, out);
 *   Object data = rpc.getData();
 *   System.out.println("client sent: " + data.toString());
 *   rpc.send("here's a response");
 * 
 * 
 *   Queuing
 * 
 *   Because of browser limitations on the total number of simultaneous HTTP connections to a given
 *   server, batching multiple RPC requests into a single HTTP request is highly advisable whenever
 *   possible. The RPCManager provides a queuing mechanism that allows this.
 * 
 *   Queuing example (client code):
 * 
 * 
 *   var wasQueuing = isc.RPCManager.startQueue();
 *   isc.RPCManager.send("a string of data", "myCallback(data)", {actionURL: "/rpcHandler.jsp"});
 *   isc.RPCManager.sendRequest({ data: ["some", "more data", 2], callback: "myCallback(data)", actionURL: "/rpcHandler.jsp"});
 *   isc.RPCManager.sendRequest({ data: "different callback", callback: "myCallback2(data)", actionURL: "/rpcHandler.jsp"});
 *   if (!wasQueuing) isc.RPCManager.sendQueue();
 * 
 *   function myCallback(data) { alert("response from the server: " + data); }
 *   function myCallback2(data) { alert("response from the server (other callback): " + data); }
 * 
 * 
 * 
 * 
 *   Queuing example (server code: /rpcHandler.jsp):
 * 
 *   RPCManager rpc = new RPCManager(request, response, out);
 * 
 *   for(Iterator i = rpc.getRequests().iterator(); i.hasNext();) {
 *     RPCRequest rpcRequest = (RPCRequest)i.next();
 *     Object data = rpcRequest.getData();
 *     System.out.println("client sent:" + data.toString());
 *  
 *     //send back the data sent to us by the client
 *     rpc.send(rpcRequest, new RPCResponse(data));
 *   }
 * 
 * 
 *   Error Handling
 *   Please see this errorHandling on error handling.
 * 
 */
open external class RPCManager : Class {
    companion object {
        /**
         *  In milliseconds, how long the RPCManager waits for an RPC request to complete before
         *   returning an error.
         * 
         *   Default of 240000 milliseconds is four minutes. If set to zero, the RPCManager will not
         *   enforce a timeout, however, see RPCRequest.timeout for a discussion of default
         *   timeouts that are built into browsers.
         *  @type {Integer}
         *  @default "240000"
         */
        var defaultTimeout: Number = definedExternally
        /**
         *  If showPrompt is enabled for a given transaction, this is the defaultPrompt to be shown
         *   to the user in a modal dialog while the transaction occurs.
         *   May be overridden at the request level via RPCRequest.prompt.
         *   More targetted default prompts are also supported for certain code-paths. See the following
         *   set of properties for details:
         * 
         *  - RPCManager.removeDataPrompt
         * 
         *  - RPCManager.saveDataPrompt
         * 
         *  - RPCManager.fetchDataPrompt
         * 
         *  @type {HTMLString}
         *  @default "Contacting Server..."
         */
        var defaultPrompt: String = definedExternally
        /**
         *  Default message displayed to user when an operation fails to return from the server within
         *   the timeout period specified by RPCManager.defaultTimeout.
         *  @type {HTMLString}
         *  @default "Operation timed out"
         */
        var timeoutErrorMessage: String = definedExternally
        /**
         *  Default prompt displayed to user while an operation is running to remove data from
         *   the server.
         *   Displayed as a result of the ListGrid.removeSelectedData code path.
         *  @type {HTMLString}
         *  @default "Deleting Record(s)..."
         */
        var removeDataPrompt: String = definedExternally
        /**
         *  Default prompt displayed to the user while an operation is running to save data to
         *   the server.
         *   Displayed as a result of the DynamicForm.saveData code path.
         *  @type {HTMLString}
         *  @default "Saving form..."
         */
        var saveDataPrompt: String = definedExternally
        /**
         *  Default prompt displayed to the user while a server validation is pending.
         *  @type {HTMLString}
         *  @default "Validating..."
         */
        var validateDataPrompt: String = definedExternally
        /**
         *  Controls the default prompt style. Overrideable by RPCRequest.promptStyle.
         *  @type {PromptStyle}
         *  @default "dialog"
         */
        var promptStyle: 
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
         *   This value can be overridden on a per-request basis via RPCRequest.useCursorTracker.
         *  @type {boolean}
         *  @default false
         */
        var useCursorTracker: Boolean = definedExternally
        /**
         *  Controls the default cursor shown when RPCManager.promptStyle is set to
         *   "cursor". Overrideable by RPCRequest.promptCursor.
         *  @type {string}
         *  @default "progress"
         */
        var promptCursor: String = definedExternally
        /**
         *  Default prompt displayed to the user while an operation is running to fetch data from
         *   the server.
         *   Displayed as a result of ListGrid.filterData, ListGrid.fetchData and
         *   ListGrid.clearCriteria code paths.
         *  @type {string}
         *  @default "Finding Records that match your criteria..."
         */
        var fetchDataPrompt: String = definedExternally
        /**
         *  If set to true, the RPCManager will block the UI with a modal dialog containing
         *   the text from RPCManager.defaultPrompt (or the per-RPCRequest override) until the RPC to the
         *   server completes.
         * 
         *   If set to false, the RPC happens transparently, allowing the user to continue
         *   interacting with the UI.
         * 
         *   DataSource requests, which are a particular type of RPCRequest, are controlled by the
         *   more-specific DataSource-level setting DataSource.showPrompt.
         *  @type {boolean}
         *  @default false
         */
        var showPrompt: Boolean = definedExternally
        /**
         *  If the request is configured to block user interactivity (RPCRequest.showPrompt),
         *   this property controls the delay in milliseconds before a visual indication is shown to the
         *   user that interactivity is blocked.
         * 
         *   Studies have shown that users will perceive a short operation as occurring faster if they
         *   are not shown a wait cursor, throbber or other busy indicator, but that a busy indicator
         *   must appear after a briefy delay or the user will perceive the system as broken or
         *   hung.
         * 
         *   Note that, regardless of this setting, interactivity is immediately blocked if showPrompt
         *   is true, since the purpose of blocking is to prevent duplicate requests or prevent
         *   interacting with components while they are in transition. This setting controls only how
         *   fast a visual indication of blocking is shown.
         *  @type {number}
         *  @default "300"
         */
        var promptDelay: Number = definedExternally
        /**
         *  Specifies the default URL for RPCRequests and DSRequests that do not specify a
         *   URL.
         * 
         *   URLs can be set on a per-request basis via RPCRequest.actionURL, or on a
         *   per-DataSource or per-operationType basis via DataSource.dataURL and
         *   OperationBinding.dataURL respectively. However, note that in order to be able to
         *   make use of RPCManager.startQueue, you should have all data loading and
         *   saving requests go to a single URL unless you are forced to use distinct URLs by legacy
         *   services.
         * 
         *   The primary use case for setting the default actionURL is to add a CSRF / XSRF
         *   (Cross-site Request Forgery)
         *   token. Assuming you are using a single URL for all data requests as covered above,
         *   adding a CSRF token to the default actionURL as a simple HTTP parameter
         *   will cause the CSRF token to be included in all RPCRequests and DSRequests from all
         *   DataSources without further effort.
         * 
         *   If the actionURL is changed while transactions are suspended, any suspended
         *   transactions whose actionURL was defaulted to this property (e.g. because
         *   RPCRequest.actionURL wasn't set) will be updated to have the new
         *   actionURL.
         *  @type {URL}
         *  @default "[ISOMORPHIC]/IDACall"
         */
        var actionURL: String = definedExternally
        /**
         *  The screenLoaderURL specifies the URL where ScreenLoaderServlet is installed.
         *  @type {URL}
         *  @default "[ISOMORPHIC]/screenLoader"
         */
        var screenLoaderURL: String = definedExternally
        /**
         *  Passing this special value to RPCManager.loadScreen indicates that
         *   all global names should be preserved when evaluating loaded screen.
         *  @type {string}
         *  @default "-ALL_GLOBALS"
         */
        var ALL_GLOBALS: String = definedExternally
        /**
         *  Selects the default http transport for all RPC requests. If set to true, RPCManager
         *   will use XMLHttp for requests to the server. If set to false, it will use hidden
         *   frames. Overrideable on a per-request basis via RPCRequest.useXmlHttpRequest.
         * 
         *   Note that if the end user disables ActiveX controls in Internet Explorer, the XMLHttpRequest
         *   object will not be available and SmartClient will automatically fall back on frames
         *   communication.
         *  @deprecated \* As of SmartClient 5.5, use RPCManager.defaultTransport. If you specify a value for this property, it will take precedence over
         *   RPCManager.defaultTransport for requests that do not specify a
         *   RPCRequest.transport or RPCRequest.useXmlHttpRequest.
         *  @type {boolean}
         *  @default "true if XMLHttpRequest is supported, false otherwise"
         */
        var useXmlHttpRequest: Boolean = definedExternally
        /**
         *  Selects the transport use for RPC requests by default. You can override this setting on
         *   a per-request basis by setting RPCRequest.transport.
         *  @type {RPCTransport}
         *  @default "xmlHttpRequest"
         */
        var defaultTransport: 
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
         *  Whether the servletDetails should be used in order to get
         *   around the "same origin policy" that prevents web pages from contacting other sites.
         * 
         *   Default behavior is to use the HttpProxyServlet whenever a URL appears to be pointing to
         *   another site. Set RPCRequest.useHttpProxy false to have a particular request
         *   avoid using the HttpProxyServlet even when it appears to be necessary, or set
         *   RPCManager.useHttpProxy to false to avoid ever attempting to use the
         *   HttpProxyServlet.
         *  @type {boolean}
         *  @default true
         */
        var useHttpProxy: Boolean = definedExternally
        /**
         *  The URL to use for proxied requests. This is a global system-wide setting.
         *  @type {string}
         *  @default "[ISOMORPHIC]/HttpProxy"
         */
        var httpProxyURL: String = definedExternally
        /**
         *  Specifies URL where credentials should be submitted to attempt relogin when session
         *   timeout is encountered during a background RPC. See relogin
         *  @type {string}
         *  @default "http://apex:15011/isomorphic/login/loginSuccessMarker.html"
         */
        var credentialsURL: String = definedExternally
        /**
         *  By default SmartClient will show a warning message on attempted requests to another domain as
         *   this is usually not supported at the browser level by default due to
         *   security considerations.
         * 
         *   Some browsers now do support cross domain requests through the use of Http Access Control headers
         *   (See the W3C Cross-Origin Resource Sharing recommendation).
         *   If your application intends to rely on this behavior to perform cross-domain requests,
         *   you can set allowCrossDomainCalls to true to disable the standard SmartClient
         *   warning when such calls occur.
         * 
         *   Note also that this is typically not an issue if you are using the SmartClient server
         *   (part of Pro, Power and Enterprise editions of SmartClient), as this includes the
         *   RPCManager.sendProxied.
         *  @type {boolean}
         *  @default false
         */
        var allowCrossDomainCalls: Boolean = definedExternally
        /**
         *  String sequence which marks the response as a one which contains login status information.
         *  @type {string}
         *  @default "<SCRIPT>//'"]]>>isc_"
         */
        var loginStatusCodeMarker: String = definedExternally
        /**
         *  Marker the system will look for in order to detect when login is required.
         * 
         *   The default loginRequired marker should generally not be customized. It is
         *   designed to be safe to insert into any HTML page or other server response without
         *   affecting display or functionality, for example, within an HTML comment. You should
         *   \*only\* customize the loginRequiredMarker if you have absolutely no ability
         *   to change the response that the server will send when login is required.
         * 
         *   If you do customize the loginRequiredMarker, then the loginRequiredMarker,
         *   RPCManager.loginSuccessMarker and RPCManager.maxLoginAttemptsExceededMarker should all start with the
         *   RPCManager.loginStatusCodeMarker. If they do not, there will be a small impact on
         *   performance as every response must be separately scanned for each marker, instead of just scanning
         *   once for the RPCManager.loginStatusCodeMarker.
         * 
         *   In addition, the RPCManager.loginStatusCodeMarker should ideally contain text that could not possibly
         *   validly appear as a data value in a normal response, since if that were possible, end
         *   users could enter the loginRequiredMarker as a data value and cause SmartClient to
         *   falsely detect session timeout when handling an ordinary data response. This is why the
         *   default marker has characters that make it impossible for it to be validly interpreted
         *   as a JavaScript String, XML document or HTML content - there is no way that an end user
         *   could enter this as a data value in an application and have it appear verbatim in a
         *   server response.
         *  @type {string}
         *  @default "<SCRIPT>//'"]]>>isc_loginRequired"
         */
        var loginRequiredMarker: String = definedExternally
        /**
         *  Marker the system will look for in order to detect when login was successfull.
         *  @type {string}
         *  @default "<SCRIPT>//'"]]>>isc_loginSuccess"
         */
        var loginSuccessMarker: String = definedExternally
        /**
         *  Marker the system will look for in order to detect when the number of maximum logins was exceeded.
         *  @type {string}
         *  @default "<SCRIPT>//'"]]>>isc_maxLoginAttemptsExceeded"
         */
        var maxLoginAttemptsExceededMarker: String = definedExternally
        /**
         *  In Internet Explorer 9, when a string of
         *   JavaScript is evaluated via the native eval() function, objects created
         *   within that evaluation are not released from browser memory until the page is
         *   reloaded.
         * 
         *   SmartClient uses the eval() function to evaluate JSON formatted
         *   responses to RPCRequests by default, making long running applications potentially
         *   susceptible to memory leaks over time.
         * 
         *   Note that this does not apply to DataSources which use
         *   DataSource.useStrictJSON formatted responses as the framework avoids
         *   calling eval() altogether and makes use of the native browser
         *   JSON.parse() method which does not have this issue. By default
         *   we also use strict json formatted responses for all
         *   DataSource.dataFormat dataSources in IE9, so these
         *   leaks are mainly a concern only for dataSources with DataSource.dataFormat
         *   set to "json".
         * 
         *   Setting this property to false enables a workaround suggested on the
         *   Microsoft Knowledge Base to
         *   avoid such memory leaks by evaluating script in a hidden iframe and periodically
         *   refresh that frame. However developers should be aware of the following
         *   limitation with this setting:
         *   attempting to access certain object types including
         *   Date or function objects generated from such an
         *   evaluation can subsequently lead to a JavaScript error with the message
         *   "Can't execute code from a freed script".
         * 
         *   This workaround therefore may not be suitable for all transactions or dataSources
         *   within a given application.
         * 
         *   This property may also be specified for specific RPCRequest.allowIE9Leak.
         * 
         *   This issue is discussed further in the online
         *   SmartClient FAQ.
         *  @type {boolean}
         *  @default true
         */
        var allowIE9Leak: Boolean = definedExternally
        /**
         *  Creates a new RPCManager
         * 
         *  @param typeCheckedProperties {Partial<RPCManager>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {RPCManager} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): RPCManager = definedExternally
        /**
         *   Setter for RPCManager.actionURL.
         * 
         *  @param {URL} new actionURL
         */
        fun setActionURL(actionURL: String): Unit = definedExternally
        /**
         * 
         *   This method is called by the RPCManager every time it sends a queue of requests to the
         *   server (note that if you are not using queuing, the system simply sends queues
         *   containing just one request, so this API is valid regardless).
         *   There is no default implementation of this method; it is simply an override point.
         *   It is intended to be used by user code that needs to be notified when SmartClient sends
         *   requests to the server. Note that the list of RPCRequests passed to this
         *   method is strictly read-only.
         * 
         * 
         *  @param {Array<Partial<RPCRequest>>} The queue of RPCRequests that was sent
         */
        fun queueSent(requests: Array<dynamic>): Unit = definedExternally
        /**
         * 
         *   Returns true if the XMLHttpRequest object is available, false otherwise. See
         *   platformDependencies for more information on when XMLHttpRequest parser may
         *   not available and what features are
         *   impacted as a result.
         * 
         * 
         */
        fun xmlHttpRequestAvailable(): Boolean = definedExternally
        /**
         * 
         *   This method is a convenience wrapper on RPCManager.sendRequest() - it calls
         *   through to sendRequest().
         * 
         * 
         *  @param {any} data to be passed to the server
         *  @param {RPCCallback=} method to call on RPC completion
         *  @param {object=} object literal containing any additional properties                    you want to set - these will be applied to the                     RPCRequest object that will be auto-created for you.
         */
        fun send(data: dynamic, callback: ((response: RPCResponse, rawData: dynamic, request: RPCRequest) -> Unit?), requestParams: dynamic?): Unit = definedExternally
        /**
         *   Send an HTTP request to a remote host, potentially through the HttpProxy servlet installed
         *   on the SmartClient Server.
         * 
         *   This API allows contacting services which are hosted on servers other than the origin server
         *   if the HttpProxy servlet is enabled on the SmartClient Server.
         * 
         *   The HttpProxy will be used if the RPCRequest.actionURL starts with "http" and uses a
         *   hostname other than "localhost" or window.location.hostname, or if the port
         *   number differs, or if request.useHttpProxy is explicitly set. Otherwise the
         *   request goes to the origin server (the server that returned the current page).
         * 
         *   The RPCRequest properties that will be respected when relaying requests via the
         *   HttpProxy are:
         *   RPCRequest.actionURL, RPCRequest.httpMethod,
         *   RPCRequest.params, RPCRequest.contentType,
         *   RPCRequest.httpHeaders, and RPCRequest.data. In this case
         *   "data", if set, will be used as the request body for an HTTP POST.
         * 
         *   Higher-level APIs like DataSource or WebService call through this API, and so
         *   automatically use the HttpProxy if DataSource.dataURL or
         *   WebService.setLocation is set to a foreign server.
         * 
         *   This API is only suitable for direct use when loading unstructured data that will not be
         *   shown in a DataBoundComponent. For a WSDL-described web service, use
         *   XMLTools.loadWSDL instead. For other web services, use a DataSource with
         *   DataSource.dataURL, and use DataSource.transformRequest and
         *   DataSource.transformResponse as necessary to form requests for the service and
         *   transform responses for display.
         * 
         * 
         *  @param {RPCRequest} rpcRequest to be routed through the HttpProxy
         */
        fun sendProxied(request: RPCRequest): Unit = definedExternally
        /**
         * 
         *   Send the passed RPCRequest to the server. If queuing is in effect, this queues
         *   the request instead.
         * 
         * 
         *  @param {RPCRequest} RPCRequest to send to the server
         */
        fun sendRequest(rpcRequest: RPCRequest): Unit = definedExternally
        /**
         *   Start queuing DSRequest and RPCRequest system-wide,
         *   for later sending when RPCManager.sendQueue() is called, at which time all queued
         *   requests will be sent as a single, combined HTTP request.
         * 
         *   Combining requests via queuing:
         * 
         * 
         *  - allows the server to implement transactional saving when multiple records are
         *     affected by actions in the UI
         * 
         *  - can reduce overhead by combining related requests, avoiding the use of multiple
         *     network connections, redundant authentication checks, and other redundant resource
         *     allocations that would otherwise happen if requests were processed separately
         * 
         *  - can simplify application logic that otherwise has to deal with multiple outstanding
         *     server requests that might complete in any order
         * 
         * 
         *   Queuing is used automatically by many, many framework features, including
         *   multi-row grid editing (ListGrid.autoSaveEdits),
         *   ${isc.DocUtils.linkForExampleId('databoundDragCopy', 'multi-row drag &amp; drop')},
         *   ResultTree.fetchMode,
         *   ValidatorType,
         *   ${isc.DocUtils.linkForExampleId('queuedAdd', 'Master-Detail saves')},
         *   CubeGrid, and many others.
         * 
         *   Queuing also has subtler architectural benefits in terms of building reusable services -
         *   see the QuickStart Guide sections on Queuing for details.
         * 
         *   For all the reasons given above, it's extremely important to use DataSources that can
         *   support queuing. Queuing is automatically supported when using server-based DataSources
         *   with the SmartClient Server Framework, and is supported by RestDataSource.
         * 
         *   Order of Execution
         * 
         *   When the SmartClient Server framework receives a queued request, it will process all
         *   requests, in order, in a single thread, before any response is sent to the client. All
         *   client-side actions related to queued requests, such as
         *   ListGrid.fetchData on completion, likewise happen in queue
         *   order, after all server-side processing has taken place.
         * 
         *   Therefore when using queuing you can use the callback argument of RPCManager.sendQueue to
         *   detect that all operations have completed, which is much simpler than the logic needed
         *   to track multiple asynchronous operations and wait for all to complete.
         * 
         *   Nested Queuing
         * 
         *   In some cases you may wish to combine requests being sent by application logic with
         *   queued requests automatically sent by components. For example, you may want to call
         *   ListGrid.saveAllEdits but also add an additional request to the same queue.
         * 
         *   To do this, just call startQueue() before saveAllEdits() (or
         *   whatever other API would also normally perform a queued request), then call
         *   sendQueue(). Framework features that use queuing will automatically notice
         *   that you have already started a queue, and will not automatically call
         *   sendQueue() in this case. You can implement the same behavior in your own
         *   reusable components by checking the return value of startQueue(), which
         *   tells you whether queuing is already active.
         * 
         *   Requests that can't be queued
         * 
         *   When using queuing, all requests in a given queue must go to the same
         *   RPCRequest.actionURL and use the same transport (XMLHttp or frames). If a
         *   request specifies a different actionURL or transport than that of the requests currently
         *   on the queue, it will be sent to the server separately, ahead of the queue, and a
         *   warning will be logged to the Developer Console.
         * 
         *   Implementing your own Queuing
         * 
         *   If you are in the rare situation that:
         * 
         * 
         *  - you can't use the SmartClient Server framework
         * 
         *  - the server you are integrating with some pre-existing support for combining
         *     operations in a flexible way, similar to queuing
         * 
         *  - you are totally unable to implement the RestDataSource protocol for this server,
         *     even through approaches such as adding it as an additional service while leaving
         *     the original services unchanged, or going through an intermediate server
         * 
         *   .. then you can implement a crude version of the built-in queuing feature by using
         *   DataSource.dataProtocol to avoid HTTP requests being
         *   immediately sent when a DataSource executes. In outline:
         * 
         * 
         *  - create an API similar to startQueue() for managing a global setting
         *     reflecting whether your special queuing system is active. Your DataSources should
         *     check for this global setting in DataSource.transformRequest, and, if
         *     queuing is active, store the request you received in
         *     DataSource.transformRequest in memory, for example in an Array
         * 
         *  - implement your own equivalent of RPCManager.sendQueue() which sends an
         *     HTTP request representing your combined requests, then once you receive your
         *     combined response, call DataSource.processResponse for each request.
         * 
         *   Note that attempting to integrate with RPCManager's queuing system doesn't
         *   really make sense - RPCManager won't be aware of your separate, special
         *   queue of requests, so will reject calls to sendQueue() since RPCManager's
         *   queue is empty. Similarly, enabling queuing on RPCManager may cause
         *   inadvertent queuing of unrelated requests you did not intend to queue. Maintaining your
         *   own separate notion of whether queuing is active is simpler and less error prone.
         * 
         * 
         *  @param {boolean=} whether queuing should be enabled, default true. Passing false           will disable queuing but not send the queue yet, so that any            queued requests will be sent along with the next            send()/sendRequest()
         */
        fun startQueue(shouldQueue: Boolean?): Boolean = definedExternally
        /**
         *   Returns true if there is a current transaction (queue of requests)
         * 
         *   This method will return false if no requests are currently queued, even if
         *   RPCManager.startQueue has been called.
         * 
         * 
         */
        fun hasCurrentTransactionQueued(): Boolean = definedExternally
        /**
         *   Synonym of RPCManager.getQueueTransactionId.
         * 
         * 
         */
        fun getCurrentTransactionId(): Number = definedExternally
        /**
         *   Returns the id of the current transaction (a queue of requests).
         * 
         *   This method will return null if no requests are currently queued, even if
         *   RPCManager.startQueue has been called.
         * 
         * 
         */
        fun getQueueTransactionId(): Number = definedExternally
        /**
         *   Cancel a queue of requests (also called a transaction).
         * 
         *   If a transactionId is passed, that transaction will be cancelled, otherwise, the current
         *   (not yet sent) transaction is cancelled. You can retrieve the id of the current
         *   transaction, if there is one, by calling
         *   RPCManager.getQueueTransactionId before the
         *   transaction has been sent.
         * 
         *   Note that cancelQueue() calls RPCManager.clearTransaction
         *   and attempts to abort the request. However, note also that whilst cancelling a
         *   transaction that has already been sent will not necessarily stop the HTTP request that
         *   has been issued - this is only possible on some browsers and with some transports - it
         *   will reliably cause SmartClient to ignore any response returned by the server and not
         *   fire any callbacks that have been passed in.
         * 
         *   Also, take into account that this method removes all queued requests from the current queue,
         *   but queueing is still active, so if you also want to disable queuing you should call
         *   RPCManager.startQueue.
         * 
         * 
         *  @param {Integer=} transactionId of the queue.
         */
        fun cancelQueue(transactionNum: Number?): Unit = definedExternally
        /**
         *   Erase all client-side record of a transaction, such that any response from the server
         *   will be ignored.
         * 
         *   A transaction means a batch of one or more RPCRequests that have already been sent to
         *   the server via RPCManager.sendQueue.
         * 
         *   You can retrieve the id of the current transaction, if there is one, by
         *   RPCManager.getQueueTransactionId before the
         *   transaction is sent.
         * 
         * 
         *  @param {Integer} id of the transaction to be cleared
         */
        fun clearTransaction(transactionNum: Number): Unit = definedExternally
        /**
         *   Suspends the current transaction, such that all processing of the transaction is halted,
         *   any remaining RPCRequest.callback in the transaction won't fire, and
         *   the transaction can never RPCRequest.timeout.
         * 
         *   suspendTransaction() is typically used to handle total failures for an
         *   entire transaction, such as HTTP status 500, or session timeout resulting in
         *   RPCManager.loginRequired being called. In both cases the intent
         *   is to put the transaction on hold so that a transient problem can be resolved, and then
         *   the transaction can be re-sent successfully. By using suspendTransaction(), components
         *   that submitted requests never realize there was a transient failure, and so error
         *   handling logic does not have to be implemented in every component.
         * 
         *   Generally you can only validly suspend a transaction from either
         *   RPCManager.loginRequired or RPCManager.handleError, and in the case of
         *   handleError(), only when the first response in the transaction has an error.
         *   Suspending and re-sending a partially processed transaction means that some responses
         *   will be processed twice, with undefined results for requests issued automatically by UI
         *   components.
         * 
         *   A suspended transaction must ultimately be either cleared via
         *   RPCManager.clearTransaction or re-sent via RPCManager.resendTransaction or memory will be
         *   leaked.
         * 
         * 
         *  @param {any | GlobalId=} transaction to delay. Defaults to the           current transaction if there is one
         */
        fun suspendTransaction(transaction: dynamic?): Unit = definedExternally
        /**
         *   Resend a suspended transaction to the server. See RPCManager.suspendTransaction for
         *   context.
         * 
         *   Note that the transaction must have been previously suspended, and in particular
         *   suspended validly according to the rules described in the docs for
         *   RPCManager.suspendTransaction, or undefined results will occur.
         * 
         *   You can resend all suspended transactions by calling
         *   RPCManager.resendTransaction with no arguments.
         * 
         * 
         *  @param {Integer=} id of the transaction to be re-sent, or null to resend all               suspended transactions
         */
        fun resendTransaction(transactionNum: Number?): Unit = definedExternally
        /**
         * 
         *   Send all currently queued requests to the server. You need only call this method if you are
         *   using queuing otherwise your requests are synchronously submitted to the server.
         * 
         *   This method will do nothing and the callback will not be called if no requests have actually
         *   been queued. You can detect whether the queue is empty by calling
         *   RPCManager.getQueueTransactionId.
         * 
         *   NOTE: if you aren't the caller who first enables queuing (startQueue() returns
         *   true), you should in general avoid calling sendQueue(), because whoever was
         *   first to enable queuing may have more requests to add to the same queue.
         * 
         *   See RPCManager.startQueue for more information about queuing.
         * 
         * 
         *  @param {RPCQueueCallback=} Callback to fire when the queued operations complete. Callback will be fired with 1 parameter: responses an array of DSResponse or  RPCResponse objects that were part of the transaction fired by this method.
         */
        fun sendQueue(callback: ((response: Array<dynamic>) -> Unit?)): Unit = definedExternally
        /**
         *   handleError() will be called if RPCResponse.status is negative and
         *   RPCRequest.willHandleError was not set. It is called for both DSResponses
         *   and RPCResponses that have a non-success status. You can check whether the
         *   response is a DSResponse by checking response.isDSResponse.
         * 
         *   By default handleError() always logs a warning. In addition, if
         *   RPCResponse.data was set to a String, a warning dialog will be
         *   shown to the user with response.data as the message, which allows the server to send
         *   user error messages back without writing custom client-side error handling.
         * 
         *   To do custom error handling that is specific to a particular component or type of
         *   request, set RPCRequest.willHandleError and deal with errors in the
         *   rpcRequest.callback. To change the default system-wide error handling,
         *   override this
         *   method. Note that since handleError() is a class method, to override it
         *   you will call Class.addClassProperties rather than
         *   addProperties(), like so:
         * 
         *     isc.RPCManager.addClassProperties({
         *       handleError : function (response, request) { .. custom handling .. }
         *     })
         * 
         * 
         *   To invoke the default error handling in your new handler, you can simply call the method
         *   RPCManager.runDefaultErrorHandling.
         * 
         *   If you're using the xmlHttpRequest RPCRequest.transport, you can access the
         *   HTTP status code
         *   of the response (eg 404 Not Found or 500 Server Error) as RPCResponse.httpResponseCode.
         * 
         *   For very advanced usage, the response.xmlHttpRequest contains the native XMLHttpRequest
         *   object used to make the request.  Accessing this object is
         *   subject to possible cross-platform bugs and inconsistencies, and Isomorphic recommends
         *   that you wrap any access to the XMLHttpRequest object in a try/catch block because some
         *   browsers may throw exceptions when certain attributes of this object are accessed. For
         *   example, if you try to access XMLHttpRequest.status (for the HTTP status code) when the
         *   network cable is unpluged in Windows, you'll get an Exception in Firefox.
         * 
         *   See the errorHandling for additional guidance.
         * 
         * 
         *  @param {any} the RPCResponse or DSResponse object returned from the server
         *  @param {any} the RPCRequest or DSRequest that was sent to the server
         */
        fun handleError(response: dynamic, request: dynamic): Unit = definedExternally
        /**
         *   Runs the default error handling normally performed by RPCManager.handleError. May be
         *   called from a custom handler to achieve the default behavior if one has been installed.
         * 
         * 
         *  @param {DSResponse} response the response
         *  @param {DSRequest} request the request
         */
        fun runDefaultErrorHandling(response: DSResponse, request: DSRequest): Unit = definedExternally
        /**
         *   handleTransportError() handles server error responses for submitted
         *   transactions. When the server responds to a submitted transaction with an HTTP error
         *   code this method will be called before any individual response callbacks are fired,
         *   regardless of whether RPCRequest.willHandleError was specified on the submitted
         *   request[s].
         * 
         *   This provides the developer with an opportunity to handle a server error by (for example)
         *   suspending and resubmitting the transaction before any other handling occurs.
         * 
         *   The default implementation takes no action - by default transport errors
         *   are handled via RPCManager.handleError, or by the standard request callback
         *   methods, depending on request.willHandleError.
         *   To perform custom handing for transport errors this classMethod may be
         *   overridden as follows
         * 
         *     isc.RPCManager.addClassProperties({
         *       handleTransportError : function (transactionNum, status, httpResponseCode, httpResponseText) 
         *       {
         *          .. custom handling .. 
         *       }
         *     })
         * 
         * 
         *   Return an explicit false from this method to cancel default error handling,
         *   so that RPCManager.handleError is not called for any DSResponse in this transaction.
         * 
         * 
         *   Note: This method only applies to operations submitted via
         *   RPCTransport - it is not possible to provide similar error handling
         *   for other transports.
         * 
         *   See the errorHandling for additional guidance.
         * 
         * 
         *  @param {Integer} The submitted client-server transaction number
         *  @param {Integer} The RPCResponse status code
         *  @param {Integer} The HTTP Response code reported by the server
         *  @param {Text} The raw HTTP Response text
         */
        fun handleTransportError(transactionNum: Number, status: Number, httpResponseCode: Number, httpResponseText: Text): Boolean = definedExternally
        /**
         *   Called when a session timeout is encountered while trying to do a background RPC. See
         *   relogin.
         * 
         *   The transaction with the passed transactionId is suspended, and should either
         *   be RPCManager.clearTransaction or RPCManager.resendTransaction
         *   after the user has been re-authenticated.
         * 
         *   The rpcRequest parameter can be used to determine whether the suspended
         *   transaction can simply be dropped (eg, it's periodic polling request).
         * 
         *   The rpcResponse parameter has rpcResponse.data set to the raw text of the
         *   response that triggered loginRequired(). Some very advanced relogin strategies
         *   may need to inspect the raw response to get information needed for re-authentication.
         * 
         * 
         *  @param {Integer} id of the transaction
         *  @param {RPCRequest} first RPCRequest of the transaction
         *  @param {RPCResponse} RPCResponse containing the session timeout response that                 caused loginRequired() to be invoked
         */
        fun loginRequired(transactionNum: Number, rpcRequest: RPCRequest, rpcResponse: RPCResponse): Unit = definedExternally
        /**
         *   Exports the printable representation of a set of widgets as a .pdf that is then
         *   downloaded to the user (triggering the "Save As.." dialog).
         * 
         *   As with other exports, the resulting file can be
         *   DSRequest.exportToFilesystem instead of, or in
         *   addition to being downloaded to the user. See server-side docs for
         *   com.isomorphic.contentexport.PdfExport for more details on server-side processing and
         *   code samples for redirecting PDF output to a file or in-memory buffer, as well as
         *   instructions for adding additional stylesheets.
         * 
         *   You can either pass any Canvas to exportContent, or you can
         *   pass HTML that you have retrieved by calling Canvas.getPrintHTML. When
         *   calling getPrintHTML() to retrieve HTML for use with
         *   exportContent(), you must pass the PrintProperties.printForExport
         *   or DrawPane and FacetChart instances will not export properly.
         * 
         *   You can use a custom skin when exporting your HTML content. To use a custom skin,
         *   add a line to server_properties:
         * 
         *    skin.{skinName}.location: custom/skin
         * 
         *   Where {skinName} is the name of your custom skin, and the value is the path to your
         *   skin resources from the application webroot.
         * 
         *   Requires the SmartClient server framework, but does not require use of server-based
         *   databinding - no .ds.xml files need to exist.
         * 
         *   You can also inject a small amount of CSS from the browser via
         *   DSRequest.exportCSS - this is intended primarily for switching the page size on
         *   the fly, for exceptionally wide or tall exports.
         * 
         * 
         *  @param {Canvas | Array<Partial<Canvas>> | HTMLString} Canvas or canvas list that has exportable widgets,          or an HTML fragment derived from Canvas.getPrintHTML
         *  @param {DSRequest=} Request properties for the export to pdf object
         */
        fun exportContent(canvas: dynamic, requestProperties: DSRequest?): Unit = definedExternally
        /**
         *   Converts an DrawPane.getSvgString to one of several possible image formats,
         *   and can either initiate a download or return the base64-encoded image data.
         * 
         *   Control the image format via DSRequest.exportImageFormat.
         * 
         *   Default is to download the image (triggering the browser's save dialog).
         *   DSRequest.exportFilename can be used to control the default filename provided in the
         *   save dialog.
         * 
         *   To instead return the data as a normal DSResponse, set DSRequest.exportDisplay to
         *   "return". In this case the data is always base64 encoded.
         * 
         *   Requires the SmartClient server framework, with the same set of
         *   javaModuleDependencies as are required for PDF export of charts in
         *   legacy IE.
         * 
         *   See also DrawPane.getSvgString and DrawPane.getDataURL.
         * 
         * 
         *  @param {string} XML string containing SVG data
         *  @param {DSRequest=} request properties controlling options for export
         *  @param {ExportImageCallback=} optional callback when using                     exportDisplay:"return". Does not                     fire for other exportDisplay modes
         */
        fun exportImage(svgString: String, requestProperties: DSRequest?, callback: ((imageData: String) -> Unit?)): Unit = definedExternally
        /**
         *   Loads a screen saved in componentXML format, using the
         *   servletDetails.
         * 
         *   The ScreenLoaderServlet will look for a file named screenName.ui.xml in
         *   the directory given by the "project.ui" setting, which defaults
         *   webroot/shared/ui and can be configured in
         *   server_properties.
         * 
         *   The screen provided by the callback will be the outermost component if your
         *   loaded screen consists of a hierarchy of widgets all contained under one parent (which
         *   is true of any screens created in Visual Builder).
         * 
         *   If you have multiple widget hierarchies in your screen, the screen returned
         *   will be the last top-level component created.
         * 
         *   By default, components in the loaded screens that have Canvas.ID will not
         *   actually be allowed to take those global IDs - instead, only widgets that have one of the
         *   global IDs passed as the globals parameter will actually receive their global
         *   IDs. To override this behavior, pass the special value RPCManager.ALL_GLOBALS
         *   for the globals parameter.
         * 
         *   When globals are being suppressed, the screen available in the callback
         *   will provide access to widgets that did not receive their global IDs via
         *   Canvas.getByLocalId, and the suppressedGlobals available in the
         *   callback will be a mapping from suppressed global ID to the widget or other component
         *   that would have used that global ID if globals were not suppressed. In addition, any
         *   other Canvas loaded with the screen also provides access to any suppressed
         *   globals from the screen via getByLocalId().
         * 
         *   To load multiple screens at once, use RPCManager.cacheScreens and RPCManager.createScreen
         *   instead.
         * 
         *   Components in the screen will default to having Canvas.autoDraw set to false.
         *   This may be overridden by setting the RPCRequest.suppressAutoDraw attribute
         *   explicitly to false on the request properties object.
         * 
         *   You can optionally provide a locale name to use when resolving any i18n tags in the
         *   screen's component XML. If you do not supply this, the locale will be derived from
         *   the servlet API, and so will generally be a locale appropriate to the client's operating
         *   system settings. Only provide a locale manually if you have a special requirement that
         *   requires the user's operating system locale to be overridden in your application. If
         *   you provide a locale name, it should be of the form "xx" or "xx_YY", where "xx" is a
         *   valid language code and "YY" is a valid country code. For example, "fr" or "en_GB".
         * 
         *   This API assumes the ScreenLoaderServlet is installed at the default location - to use a
         *   different location, use the requestProperties parameter to specify a different
         *   URL via RPCRequest.actionURL. The requestProperties parameter can also
         *   be used to pass additional params to a custom ScreenLoaderServlet - see the "Dynamic
         *   Component XML" section of the componentXML.
         * 
         * 
         *  @param {string} name of the screen to load
         *  @param {LoadScreenCallback} callback for notification of screen being loaded
         *  @param {Array<Partial<string>>=} widgets to allow to take their global IDs
         *  @param {string=} The name of a locale to use for resolving i18n tags in the     component XML of the screen
         *  @param {RPCRequest=} optional properties for the request
         */
        fun loadScreen(screenName: String, callback: ((screen: Canvas?, rpcResponse: RPCResponse?, suppressedGlobals: Map<dynamic>?) -> Unit), globals: Array<dynamic>?, locale: String?, requestProperties: RPCRequest?): Unit = definedExternally
        /**
         *   Creates a screen previously cached by a call to RPCManager.cacheScreens.
         * 
         *   As with RPCManager.loadScreen, the default behavior is to prevent any global widget IDs from
         *   being established, the returned Canvas will be the outermost component of the screen,
         *   and that Canvas will provide access to other widgets in the screen via Canvas.getByLocalId
         * 
         *   Alternatively, as with RPCManager.loadScreen, a list of IDs that should be allowed to become
         *   globals can be passed, allowing those widgets to be retrieved via a call to
         *   Canvas.getById after the screen has been created.
         * 
         *   If you do not pass globals and avoid depending on global IDs within the screen
         *   definition itself (for example, by embedding JavaScript event handlers in the screen definition
         *   that use global IDs), you can create the same screen multiple times.
         * 
         *   Creating a screen may or may not cause it to draw, depending on current global autoDraw
         *   setting (isc.setAutoDraw) and any autoDraw settings
         *   in the screen itself.
         * 
         * 
         *  @param {string} name of the screen to create
         *  @param {Array<Partial<string>>=} widgets to allow to take their global IDs
         */
        fun createScreen(screenName: String, globals: Array<dynamic>?): Canvas = definedExternally
        /**
         *   Loads the definitions of a set of screens saved in componentXML
         *   format, using the servletDetails.
         * 
         *   Unlike RPCManager.loadScreen, cacheScreens() does not cause any UI components to be
         *   created or drawn, it just loads the definitions of the screens. This allows a subsequent,
         *   synchronous call to RPCManager.createScreen to create the actual screen, rather than
         *   contacting the ScreenLoader servlet and showing a loading message.
         * 
         *   See RPCManager.loadScreen for the meaning of the locale parameter.
         * 
         *   Calling cacheScreens twice with the same screenName will re-load the definition of
         *   that screen from the server such that subsequent calls to createScreen() will use
         *   the new definition.
         * 
         * 
         *  @param {Array<Partial<string>>} name of the screens to cache
         *  @param {Function} callback for notification of screens being successfully cached
         *  @param {string=} The name of a locale to use for resolving i18n tags in the             component XML of the screen
         *  @param {RPCRequest=} optional properties for the request
         */
        fun cacheScreens(screenName: Array<dynamic>, callback: (() -> dynamic), locale: String?, requestProperties: RPCRequest?): Unit = definedExternally
        /**
         *   Returns whether there are any pending RPC requests.
         * 
         * 
         */
        fun requestsArePending(): Boolean = definedExternally
    }
}