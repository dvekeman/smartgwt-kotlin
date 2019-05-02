@file:JsQualifier("isc")
package isc

/**
 *  The ViewLoader component can be used to load new SmartClient-based user interfaces into a
 *   running application.
 * 
 *   NOTE: before using a ViewLoader, be sure that you have read about and understood the
 *   smartArchitecture. The most responsive and
 *   scalable application architecture preloads views rather than using ViewLoaders.
 * 
 *   A ViewLoader is a Canvas, and can be provided anywhere a Canvas can be provided: as a Tab
 *   pane, and Layout member, etc. When a ViewLoader draws, it shows a
 *   ViewLoader.loadingMessage, then
 *   performs an RPC to the ViewLoader.viewURL to load components.
 * 
 *   The response from the viewURL should be SmartClient components defined in JavaScript, with no
 *   surrounding &lt;SCRIPT&gt; tags or other HTML framing. The returned script can be
 *   dynamically generated, for example, it may be the result of a JSP containing an XML view
 *   description enclosed in xmlTag tags.
 * 
 *   In the returned script, the special variable "viewLoader" is available to refer to the
 *   ViewLoader instance that is loading components. The intended usage is that the returned
 *   script creates a view consisting of SmartClient components, then calls
 *   viewLoader.setView(myView) to place the loaded view into the ViewLoader.
 *   If the view does not call setView() explicitly, the viewLoader will find the last top-level
 *   UI component (Canvas subclass) created by the view and set that as the current view.
 *   Top-level in this case means that the UI component is not contained in another UI component
 *   as a member or child.
 * 
 *   The ViewLoader relies on the XMLHttpRequest object which can be disabled by end-users in some
 *   supported browsers. See platformDependencies for more information.
 */
open external class ViewLoader : Label {
    /**
     *  Message to show while the view is loading.
     *   Use "&#36;{loadingImage}" to include Canvas.loadingImageSrc.
     *  @type {HTMLString}
     *  @default "Loading View...&amp;nbsp;${loadingImage}"
     */
    open var loadingMessage: String = definedExternally
    /**
     *  URL to load components from.
     *  @type {URL}
     *  @default null
     */
    open var viewURL: String = definedExternally
    /**
     *  Parameters to be sent to the viewURL when fetching the view.
     *  @type {object}
     *  @default null
     */
    open var viewURLParams: dynamic = definedExternally
    /**
     *  RPCRequest properties to be sent with every RPCRequest issued by the ViewLoader. Very
     *   advanced; could be used to, for example, set HTTP headers.
     *  @type {RPCRequest}
     *  @default null
     */
    open var viewRPCProperties: RPCRequest = definedExternally
    /**
     *  Selects the HTTP method that will be used when fetching content. Valid values are "POST"
     *   and "GET".
     *  @type {string}
     *  @default "GET"
     */
    open var httpMethod: String = definedExternally
    /**
     *  By default a ViewLoader will explicitly prevent browser caching.
     * 
     *   Set to true to allow browser caching if the browser would normally do so, in other
     *   words, if the HTTP headers returned with the response indicate that the response can be
     *   cached.
     *  @type {boolean}
     *  @default false
     */
    open var allowCaching: Boolean = definedExternally
    /**
     *   Change the URL this component loads a view from. Triggers a fetch from the new URL.
     * 
     *   Can also be called with no arguments to reload the view from the existing
     *   ViewLoader.viewURL.
     * 
     * 
     *  @param {URL=} URL to retrieve view from
     *  @param {object=} Parameters to send to the viewURL. Merged with              component.viewURLParams if both are set.
     *  @param {RPCRequest=} Additional properties for the RPCRequest             sent by the ViewLoader. Very advanced; could be used to, for             example, set HTTP headers.
     */
    open fun setViewURL(url: String?, params: dynamic?, rpcProperties: RPCRequest?): Unit = definedExternally
    /**
     * 
     *   This method is called when a transport error occurs. Typically, this is the result of the
     *   server returning an HTTP error code such as 404 - document not found. You can inspect the
     *   RPCResponse object for the reasons for the error and take appropriate action. Typical
     *   properties to look at are rpcResponse.status, and rpcResponse.httpResponseCode.
     * 
     *   This method is called from the response processing pipeline. If you want to provide your
     *   own HTML response as the result of the error, you can do
     *   so by setting rpcResponse.data to your HTML string. Returning false from this method
     *   suppresses any further response handling. The default implementation of this method causes
     *   an error message to be logged to the Developer Console and sets the HTML to the error
     *   string.
     * 
     * 
     *  @param {RPCRequest} The RPCRequest that was made to the server
     *  @param {RPCResponse} The RPCResponse that was received
     */
    open fun handleError(rpcRequest: RPCRequest, rpcResponse: RPCResponse): Boolean = definedExternally
    /**
     *   Retrieve the current view. May be null if the view has not yet been loaded, or has been
     *   explicitly set to null.
     * 
     * 
     */
    open fun getView(): Canvas = definedExternally
    /**
     *   StringMethod fired when the view has been loaded. Has no default implementation. May be
     *   observed or overridden to fire custom logic when loading completes.
     * 
     * 
     *  @param {Canvas} the view that was loaded
     */
    open fun viewLoaded(view: Canvas): Unit = definedExternally
    companion object {
        /**
         *  Creates a new ViewLoader
         * 
         *  @param typeCheckedProperties {Partial<ViewLoader>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ViewLoader} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ViewLoader = definedExternally
    }
}