@file:JsQualifier("isc")
package isc

/**
 *  Provides background communication with an HTTP server
 */
open external class Comm : Class {
    companion object {
        /**
         *  If true, SmartClient will use a
         *   web worker to send
         *   RPCRequests and DSRequests concurrent with the main
         *   Javascript thread, if:
         * 
         *  - The RPCRequest.transport is "xmlHttpRequest"
         * 
         *  - The browser is Internet Explorer 10 or greater
         * 
         *   We do this because Internet Explorer sometimes queues the sending of data with other,
         *   timer-delayed tasks on the single Javascript thread. With a busy application, this can
         *   lead to an xmlHttpRequest seeming to block; the HTTP connection is made to the server, and
         *   the server then goes into a wait state while the browser completes other timer-delayed
         *   tasks. If there are expensive timer-delayed tasks in the way, such as a reflow of the
         *   UI, completing the send to the server can block for a significant length of time,
         *   leading in turn to server turnaround times that are significantly longer than they need
         *   to be.
         * 
         *   Internet Explorer is the only browser that behaves like this, so this option does not
         *   apply to other browsers.
         *  @type {boolean}
         *  @default false
         */
        var concurrentXHRsInIE: Boolean = definedExternally
        /**
         *  The message to show the user if Comm.concurrentXHRsInIE is
         *   in force and an error occurs on the concurrent worker thread. If this attribute is
         *   left at its default null value, the user is shown the error message reported by the
         *   browser, along with the URL and line number where the error occurred (this information
         *   is also logged to the developer console, regardless of the message shown to the user)
         *  @type {string}
         *  @default null
         */
        var concurrentXHRErrorMessage: String = definedExternally
        /**
         *  Creates a new Comm
         * 
         *  @param typeCheckedProperties {Partial<Comm>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Comm} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Comm = definedExternally
    }
}