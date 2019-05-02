@file:JsQualifier("isc")
package isc

/**
 *  Encapsulates an RPC response from the server. Instances of this class are automatically created
 *   and optionally passed to you in the callback you specify as part of your RPCRequest.
 */
open external class RPCResponse : Class {
    /**
     *  The data sent by the server.
     * 
     *   When communicating with the SmartClient server, rpcResponse.data is the data passed to the
     *   server-side method RPCResponse.setData() by your Java code.
     *   This data is translated into JavaScript
     *   objects by the rules described under RPCRequest.data.
     * 
     * 
     *   When not communicating with the SmartClient server rpcResponse.data contains the
     *   raw HTTP response body. See RPCRequest.useSimpleHttp,
     *   RPCRequest.serverOutputAsString, RPCRequest.evalResult for details.
     *  @type {string | object}
     *  @default false
     */
    open var data: dynamic = definedExternally
    /**
     *  Status code for this response. Status codes less than zero are considered errors by the
     *   RPCManager, those greater than or equal to zero are considered successes. Please see the
     *   error handling section the RPCManager for more information on
     *   what the RPCManager does with the status code and how you can override this behavior.
     * 
     *   When using the SmartClient server you can set the rpcResponse.status by calling the
     *   server-side method RPCResponse.setStatus().
     * 
     *   When not using the SmartClient server, the RPCManager makes no assumptions about the
     *   structure of the response, so the status code just reflects the
     *   RPCResponse.httpResponseCode: status will be
     *   RPCResponse.STATUS_TRANSPORT_ERROR if an HTTP-level error
     *   occurred such as "500 server error". If you have a status code you need to transmit you can
     *   simply embed it in the response (as part of RPCResponse.data) and interpret it from
     *   the callback.
     * 
     *   With or without the SmartClient server, the relogin status codes (such as
     *   RPCResponse.STATUS_LOGIN_REQUIRED) are triggered whenever special markers, such as the
     *   loginRequiredMarker, appear in the body of the response. See the relogin for details.
     *  @type {Integer}
     *  @default "0"
     */
    open var status: Number = definedExternally
    /**
     *  This attribute (available when using the the xmlHttpRequest transport) contains
     *   the HTTP response code sent by the server.
     * 
     *   Note that this is different from RPCResponse.status - that attribute is used to
     *   indicate a status code for the RPC itself whereas httpResponseCode is the raw HTTP response
     *   code for the HTTP request that contained the RPCRequest.
     * 
     *   This feature relies on the XMLHttpRequest object which can be disabled by end-users in some
     *   supported browsers. See platformDependencies for more information.
     * 
     *   If you're using this attribute, you'll typically want to avoid the default error
     *   handling response of RPCManager. To do so, set
     *   RPCRequest.willHandleError to true.
     *  @type {Integer}
     *  @default null
     */
    open var httpResponseCode: Number = definedExternally
    /**
     *  HTTP headers returned by the server as a map from header name to header value.
     * 
     *   Headers are available only when the default RPCTransport "xmlHttpRequest" is in use,
     *   and browsers may limit access to headers for cross-domain requests or in other
     *   security-sensitive scenarios.
     *  @type {object}
     *  @default null
     */
    open var httpHeaders: dynamic = definedExternally
    /**
     *  The actual text of the HTTP response. Only available when the default
     *   RPCTransport "xmlHttpRequest" transport is in use,
     *  @type {string}
     *  @default null
     */
    open var httpResponseText: String = definedExternally
    /**
     *  The RPCRequest.clientContext object as set on the RPCRequest.
     *  @type {object}
     *  @default null
     */
    open var clientContext: dynamic = definedExternally
    /**
     *  ID of the transaction sent to the server via RPCManager.sendQueue containing the
     *   RPCRequest associated with this response.
     *  @type {Integer}
     *  @default null
     */
    open var transactionNum: Number = definedExternally
    companion object {
        /**
         *  Indicates successful completion of the request. This is the default status and is
         *   automatically used by the RPCResponse on the server unless you override it with
         *   setStatus().
         * 
         *   See the error handling section in RPCManager
         *   for more information.
         *  @type {Integer}
         *  @default "0"
         */
        var STATUS_SUCCESS: Number = definedExternally
        /**
         *  Indicates that the browser is currently offline, and that we do not hold a cached
         *   response for the request.
         *  @type {Integer}
         *  @default "1"
         */
        var STATUS_OFFLINE: Number = definedExternally
        /**
         *  Indicates a generic failure on the server.
         *   See the error handling section in RPCManager
         *   for more information.
         *  @type {Integer}
         *  @default "-1"
         */
        var STATUS_FAILURE: Number = definedExternally
        /**
         *  Indicates a declarativeSecurity failure on the server.
         *   See the error handling section in RPCManager
         *   for more information.
         *  @type {Integer}
         *  @default "-3"
         */
        var STATUS_AUTHORIZATION_FAILURE: Number = definedExternally
        /**
         *  Indicates a validation failure on the server.
         *   See the error handling section in RPCManager
         *   for more information.
         *  @type {Integer}
         *  @default "-4"
         */
        var STATUS_VALIDATION_ERROR: Number = definedExternally
        /**
         *  Indicates that the RPC has been intercepted by an authenticator that requires the user
         *   to log in.
         *  @type {Integer}
         *  @default "-5"
         */
        var STATUS_LOGIN_INCORRECT: Number = definedExternally
        /**
         *  Indicates that too many authentication attempts have been made and the server refuses to
         *   accept any more login attempts.
         *  @type {Integer}
         *  @default "-6"
         */
        var STATUS_MAX_LOGIN_ATTEMPTS_EXCEEDED: Number = definedExternally
        /**
         *  Indicates that a login is required before this RPCRequest can proceed.
         * 
         *   Applications do not directly set this status code, instead, to trigger the relogin flow,
         *   return the loginRequiredMarker in the response sent by your server when login is
         *   required. See the relogin for details.
         *  @type {Integer}
         *  @default "-7"
         */
        var STATUS_LOGIN_REQUIRED: Number = definedExternally
        /**
         *  Indicates that the login succeeded.
         *  @type {Integer}
         *  @default "-8"
         */
        var STATUS_LOGIN_SUCCESS: Number = definedExternally
        /**
         *  Indicates that the client attempted an update or remove operation without providing
         *   primary key field(s)
         *  @type {Integer}
         *  @default "-9"
         */
        var STATUS_UPDATE_WITHOUT_PK_ERROR: Number = definedExternally
        /**
         *  Indicates that the request was either never attempted or was rolled back, because
         *   automatic or user transactions are in force and another request in the same transaction
         *   failed. Note that the request(s) that actually failed will have a code specific to the
         *   failure; it is only the requests that would otherwise have succeeded that are marked
         *   with this failure code.
         *  @type {Integer}
         *  @default "-10"
         */
        var STATUS_TRANSACTION_FAILED: Number = definedExternally
        /**
         *  Indicates that an uploaded file's size exceeded the maximum file size allowed.
         *  @type {Integer}
         *  @default "-11"
         */
        var STATUS_MAX_FILE_SIZE_EXCEEDED: Number = definedExternally
        /**
         *  Indicates that the total size of the data sent to the server was more than the server is
         *   configured to allow. Most servers limit the post size to prevent out of memory style
         *   attack vectors that push a bunch of data at the server. Apache Tomcat, for example,
         *   is pre-configured to limit post size to 2mb.
         * 
         *   On internal networks, these limits can typically be safely raised or removed. With
         *   Tomcat, for example, you can remove the post limit by specifying the following attribute
         *   on the &lt;Connector&gt; element in conf/server.xml:
         * 
         *   maxPostSize="-1"
         * 
         * 
         *   NOTE: this status code is used whenever the server framework receives a request
         *   where the POST data has been removed, however, there are other possible causes,
         *   including:
         * 
         * 
         *  - security software installed on the server or network that erroneously detects some
         *     kind of exploit attempt, if its behavior is to just strip the POST data but allow
         *     the rest of the request through (SiteMinder is one product known to do this)
         * 
         *  - incorrectly written filter servlets that drop POST'd data
         * 
         *  @type {Integer}
         *  @default "-12"
         */
        var STATUS_MAX_POST_SIZE_EXCEEDED: Number = definedExternally
        /**
         *  Indicates that an empty file was uploaded for a required 'binary' field.
         *  @type {Integer}
         *  @default "-15"
         */
        var STATUS_FILE_REQUIRED_ERROR: Number = definedExternally
        /**
         *  Indicates that a response with invalid format has been received from server.
         *   If the datasource is using "iscServer" dataFormat, this means that the response is
         *   not recognized as a valid ISC frame.
         * 
         *   One possible cause for this error can be the reception of a RestDataSource JSON
         *   response that lacks a valid RestDataSource.jsonPrefix and/or RestDataSource.jsonSuffix
         * 
         *   If it is using "xml" or "json" dataFormat, the response could not be parsed as XML or JSON.
         *  @type {Integer}
         *  @default "-16"
         */
        var INVALID_RESPONSE_FORMAT: Number = definedExternally
        /**
         *  This response code is usable only with the XMLHttpRequest transport and indicates that
         *   the server returned an HTTP response code outside the range 200-299 (all of these statuses
         *   indicate success, but ordinarily only 200 is used). To get the actual
         *   response code, you can query rpcResponse.httpResponseCode in your callback.
         * 
         *   Note that currently this error code will never occur for the hiddenFrame
         *   transport - instead, use RPCResponse.STATUS_SERVER_TIMEOUT to detect
         *   hiddenFrame transport errors.
         *  @type {Integer}
         *  @default "-90"
         */
        var STATUS_TRANSPORT_ERROR: Number = definedExternally
        /**
         *  This response code only occurs when using the HTTP proxy. It is issued by the proxy
         *   servlet when the target host is unknown (ie, cannot be resolved through DNS). This
         *   response probably indicates that you are attempting to contact a nonexistent server
         *   (though it might mean that you have DNS problems).
         *  @type {Integer}
         *  @default "-91"
         */
        var STATUS_UNKNOWN_HOST_ERROR: Number = definedExternally
        /**
         *  This response code only occurs when using the HTTP proxy. It is issued by the proxy
         *   servlet when the attempt to contact the target server results in a Java SocketException.
         *   This response probably indicates that the target server is currently down.
         *  @type {Integer}
         *  @default "-92"
         */
        var STATUS_CONNECTION_RESET_ERROR: Number = definedExternally
        /**
         *  Indicates a request timed out with no server response.
         * 
         *   This is a client-only error code - never sent by the server (since it's the server
         *   that times out).
         * 
         *   NOTE that if using hiddenFrame as the transport (not the default), a
         *   malformed response such as a "500 Server Error" or 404 errors will be reported as a
         *   timeout.
         *  @type {Integer}
         *  @default "-100"
         */
        var STATUS_SERVER_TIMEOUT: Number = definedExternally
        /**
         *  Creates a new RPCResponse
         * 
         *  @param typeCheckedProperties {Partial<RPCResponse>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {RPCResponse} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): RPCResponse = definedExternally
    }
}