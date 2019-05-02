@file:JsQualifier("isc")
package isc

/**
 *  A logging system similar to the Java log4j package: messages are logged with a "category" and
 *   "priority", and developers can dynamically set which log messages are being displayed.
 * 
 *   5 log priorities are available, with the following general meaning:
 * 
 * 
 *  - "debug": diagnostic info which is only likely to be understood by a developer with
 *   source access, or would occur too frequently for normal usage
 * 
 *  - "info": reports of significant events in the normal operation of the subsystem
 * 
 *  - "warn": some kind of problem is likely to occur, an API appears is apparently being
 *   misused or will yield a partial or very slow result
 * 
 *  - "error": a definite error has occurred which may be recoverable
 * 
 *  - "fatal": total failure with no possibility of recovery
 * 
 * 
 *   Log categories do not need to be declared in advance - you can simply make up a category name and
 *   start logging to it, and control whether that category's messages will be displayed via
 *   setPriority().
 * 
 *   NOTE: to open the Developer Console in any page that loads ISC, type
 *   javascript:isc.Log.show() in the URL bar - this URL is bookmarkable.
 * 
 *   The Developer Console should always be open while developing any ISC-enabled application,
 *   because ISC logs many important errors and warnings to the Developer Console.
 * 
 *   NOTE: if you have the Microsoft JavaScript Debugger installed, ISC will be unable to log stack
 *   traces on JS errors until you go to Tools->Internet Options->Advanced Tab and check "Disable
 *   script debugging". The ability to see stack traces in the Developer Console is generally much
 *   more useful for debugging ISC-based applications than the generic Javascript Debugging
 *   facilities.
 */
open external class Log : Class {
    companion object {
        /**
         *  A declared value of the enum type
         *   LogPriority.
         *  @type {Integer}
         *  @default "1"
         */
        var FATAL: Number = definedExternally
        /**
         *  A declared value of the enum type
         *   LogPriority.
         *  @type {Integer}
         *  @default "2"
         */
        var ERROR: Number = definedExternally
        /**
         *  A declared value of the enum type
         *   LogPriority.
         *  @type {Integer}
         *  @default "3"
         */
        var WARN: Number = definedExternally
        /**
         *  A declared value of the enum type
         *   LogPriority.
         *  @type {Integer}
         *  @default "4"
         */
        var INFO: Number = definedExternally
        /**
         *  A declared value of the enum type
         *   LogPriority.
         *  @type {Integer}
         *  @default "5"
         */
        var DEBUG: Number = definedExternally
        /**
         *  Any logs below this priority will be suppressed, unless a more specific setting exists for
         *   the category.
         *  @type {LogPriority}
         *  @default 3
         */
        var defaultPriority: 
                             /**
                              *  unrecoverable error
                              */
                             Number /* 1 */ = definedExternally
        /**
         *  At this priority and above, a stack trace will be included automatically along with the log
         *   message itself.
         *  @type {LogPriority}
         *  @default 2
         */
        var stackTracePriority: 
                                /**
                                 *  unrecoverable error
                                 */
                                Number /* 1 */ = definedExternally
        /**
         *  Maximum number of logged messages to retain in memory.
         * 
         *   Note that if the Developer Console is open, it will accumulate an unbounded number of
         *   messages in the "Log Messages" area. messageCount only affects the number
         *   of messages held in memory in the main application's browser window or tab.
         *  @type {Integer}
         *  @default "1000"
         */
        var messageCount: Number = definedExternally
        /**
         *  Creates a new Log
         * 
         *  @param typeCheckedProperties {Partial<Log>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Log} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Log = definedExternally
        /**
         *   Returns a one-line summary of the current method call, showing method name and passed
         *   arguments.
         *   This function is available as a static on every ISC Class and as an instance
         *   method on every instance of an ISC Class.
         *   General best practice is to call the method as "this.getCallTrace(arguments)" whenever "this" is an
         *   instance, or call the static classMethod on the Log class otherwise.
         * 
         *   Note the arguments object is required in most cases for this method to function. In some
         *   browsers, it can be derived automatically, but developers looking to debug on multiple platforms
         *   should not rely on this.
         * 
         * 
         *  @param {any=} arguments object from the call to trace. If ommitted, where supported,  arguments will be derived from the calling function, or if this is not supported, the method  will not function.
         */
        fun getCallTrace(args: dynamic?): Unit = definedExternally
        /**
         *   Returns a "stack trace" - one line per method in the current call stack, showing the method
         *   name and any parameters passed.
         *   This function is available as a static on every ISC Class and as an instance
         *   method on every instance of an ISC Class.
         *   General best practice is to call the method as "this.getStackTrace" whenever "this" is an
         *   instance, or call the static classMethod on the Log class otherwise.
         * 
         *   Platform Notes: In Mozilla Firefox, if Firebug is enabled, a stack trace will be logged
         *   to the firebug console in addition to the standard stack trace string returned by
         *   this method.
         * 
         *   In browsers other than Internet Explorer a complete stack trace may not be available -
         *   this occurs when a function is re-entrant (meaning it calls itself). In this case the
         *   stack will terminate with text indicating where the recursive function call occurred.
         * 
         *   See debugging for further information information.
         * 
         * 
         */
        fun getStackTrace(): String = definedExternally
        /**
         *   Return a very short (generally less than 40 characters) string representation of any object,
         *   suitable for viewing by a developer for debugging purposes.
         *   This function is available as a static on every ISC Class and as an instance
         *   method on every instance of an ISC Class.
         *   General best practice is to call the method as "this.echoLeaf" whenever "this" is an
         *   instance, or call the static classMethod on the Log class otherwise.
         * 
         * 
         *  @param {any} object to echo
         */
        fun echoLeaf(obj: dynamic): String = definedExternally
        /**
         *   Return a short string representation of any object, suitable for viewing by a developer for
         *   debugging purposes.
         * 
         *   If passed an object containing other objects, echo will not recurse into subobjects,
         *   summarizing them instead via echoLeaf().
         * 
         *   NOTE: echo() is used to generate the output shown in the Log window when evaluating an
         *   expression.
         * 
         *   This function is available as a static on every ISC Class and as an instance
         *   method on every instance of an ISC Class.
         *   General best practice is to call the method as "this.echo()" whenever "this" is an
         *   instance, or call the static classMethod on the Log class otherwise.
         * 
         * 
         *  @param {any} object to echo
         */
        fun echo(obj: dynamic): String = definedExternally
        /**
         *   Like echo(), except that if passed an Array, echoAll() will echo() every element of the
         *   Array.
         *   This function is available as a static on every ISC Class and as an instance
         *   method on every instance of an ISC Class.
         *   General best practice is to call the method as "this.echo()" whenever "this" is an
         *   instance, or call the static classMethod on the Log class otherwise.
         * 
         * 
         *  @param {any} object to echo
         */
        fun echoAll(obj: dynamic): String = definedExternally
        /**
         *   A common usage of Class.logDebug is to call the method directly on
         *   the Log class.
         * 
         *  @param {string} message to log
         *  @param {string=} category to log in
         */
        fun logDebug(message: String, category: String?): Unit = definedExternally
        /**
         *   A common usage of Class.logInfo is to call the method directly on
         *   the Log class.
         * 
         *  @param {string} message to log
         *  @param {string=} category to log in
         */
        fun logInfo(message: String, category: String?): Unit = definedExternally
        /**
         *   A common usage of Class.logWarn is to call the method directly on
         *   the Log class.
         * 
         *  @param {string} message to log
         *  @param {string=} category to log in
         */
        fun logWarn(message: String, category: String?): Unit = definedExternally
        /**
         *   A common usage of Class.logError is to call the method directly on
         *   the Log class.
         * 
         *  @param {string} message to log
         *  @param {string=} category to log in
         */
        fun logError(message: String, category: String?): Unit = definedExternally
        /**
         *   A common usage of Class.logFatal is to call the method directly on
         *   the Log class.
         * 
         *  @param {string} message to log
         *  @param {string=} category to log in
         */
        fun logFatal(message: String, category: String?): Unit = definedExternally
        /**
         *   A common usage of Class.setLogPriority is to call the method
         *   directly on the Log class.
         * 
         *  @param {string} Category for which the log priority will be updated. If not             all logs on this canvas will be logged at the priority passed in.
         *  @param {LogPriority} priority level
         */
        fun setLogPriority(category: String, priority: 
                                                       /**
                                                        *  unrecoverable error
                                                        */
                                                       Number /* 1 */): Unit = definedExternally
        /**
         *   A common usage of Class.setDefaultLogPriority is to call the
         *   method directly on the Log class.
         * 
         *  @param {string} Category for which the log priority will be updated. If not             all logs on this canvas will be logged at the priority passed in.
         *  @param {LogPriority} priority level
         */
        fun setDefaultLogPriority(category: String, priority: 
                                                              /**
                                                               *  unrecoverable error
                                                               */
                                                              Number /* 1 */): Unit = definedExternally
        /**
         *   A common usage of Class.getDefaultLogPriority is to call the
         *   method directly on the Log class.
         * 
         */
        fun getDefaultLogPriority(): 
                                     /**
                                      *  unrecoverable error
                                      */
                                     Number /* 1 */ = definedExternally
        /**
         *   Apply a batch a batch of priority settings, as a object mapping category names to priority
         *   levels.
         * 
         * 
         *  @param {object} priority settings for multiple categories
         */
        fun applyLogPriorities(settings: dynamic): Unit = definedExternally
        /**
         *   Get all priority settings as an object mapping category names to priority levels.
         * 
         * 
         *  @param {Class | object=} Optional param to get priorities specific to                      some ISC class or instance.
         *  @param {boolean=} If this method is retrieving the priorities specific                  to logging for some class or instance, this parameter                  can be used to view only the overrides to the default                  log priorities on this object.
         */
        fun getLogPriorities(`object`: dynamic?, overridesOnly: Boolean?): dynamic = definedExternally
        /**
         *   Return the priority setting for a particular category.
         * 
         *   If there is no priority setting specific to this category, null will be
         *   returned, NOT Log.defaultPriority.
         * 
         * 
         *  @param {string} category name
         *  @param {Class | object=} Optional class or instance to check for                        specific log priority overrides
         */
        fun getPriority(category: String, `object`: dynamic?): 
                                                               /**
                                                                *  unrecoverable error
                                                                */
                                                               Number /* 1 */ = definedExternally
        /**
         *   Set the priority of messages that will be visible for this log category.
         * 
         *   After calling setPriority, any messages logged to the given category whose priority is
         *   below the specified priority will not appear in the Log.
         * 
         * 
         *  @param {string} category name
         *  @param {LogPriority} priority level to set
         *  @param {Class | object=} Optional ISC class or instance - if passed the priority will be set for logging    occurring on the class or instance only.
         */
        fun setPriority(category: String, priority: 
                                                    /**
                                                     *  unrecoverable error
                                                     */
                                                    Number /* 1 */, `object`: dynamic?): Unit = definedExternally
        /**
         *   Set the default priority of messages that will be visible.
         * 
         * 
         *  @param {LogPriority} priority level to set
         *  @param {Class | object=} Optional ISC class or instance - if passed the default priority will be set for logging    occurring on the class or instance only.
         */
        fun setDefaultPriority(priority: 
                                         /**
                                          *  unrecoverable error
                                          */
                                         Number /* 1 */, `object`: dynamic?): Unit = definedExternally
        /**
         *   Retrieves the default priority of messages that will be visible.
         * 
         * 
         *  @param {Class | object=} Optional ISC class or instance - if passed the returns the default priority for    the class or instance only.
         */
        fun getDefaultPriority(`object`: dynamic?): 
                                                    /**
                                                     *  unrecoverable error
                                                     */
                                                    Number /* 1 */ = definedExternally
        /**
         *   Clear the priority setting for a particular category, so that the category's effective
         *   priority returns to Log.defaultPriority
         *   If the optional second parameter is passed, the specific priority setting for the
         *   category on that object will be cleared, so logs in that category on that object will
         *   be logged at the global priority level for the category.
         * 
         * 
         *  @param {string} category name
         *  @param {Class | object=} Optional instance or class object - if passed                    clear logging priority for the appropriate category                     on that object.
         */
        fun clearPriority(category: String, `object`: dynamic?): Unit = definedExternally
        /**
         *   Would a message logged to the given category at the given priority appear in the Log?
         * 
         *   NOTE: if there is no specific priority setting for a given category, the
         *   Log.defaultPriority is used.
         * 
         * 
         *  @param {string} category name
         *  @param {LogPriority} priority level to check
         */
        fun isEnabledFor(category: String, priority: 
                                                     /**
                                                      *  unrecoverable error
                                                      */
                                                     Number /* 1 */): Unit = definedExternally
        /**
         *   Return an Array of the most recently logged messages as an Array of Strings. Up to
         *   Log.messageCount messages may be returned.
         * 
         */
        fun getMessages(): Array<dynamic> = definedExternally
        /**
         *   Open the Developer Console.
         * 
         *   The Developer Console should always be open while developing any ISC-enabled
         *   application, because ISC logs many important errors and warnings to the Developer Console.
         * 
         *   In Internet Explorer, the Developer Console is able to log a stack trace for every JS error,
         *   including errors that occur in non-ISC code.
         * 
         *   NOTE: if you have the Microsoft JavaScript Debugger installed, ISC will be unable to log
         *   stack traces on JS errors until you go to Tools->Internet Options->Advanced Tab and check
         *   "Disable script debugging". The ability to see stack traces in the Developer Console is
         *   generally much more useful for debugging ISC-based applications than the generic Javascript
         *   Debugging facilities.
         * 
         * 
         */
        fun show(): Unit = definedExternally
        /**
         *   Clear all currently displayed Log messages
         * 
         */
        fun clear(): Unit = definedExternally
        /**
         *   Causes a stack trace to be logged any time a message containing the provided pattern is
         *   logged. This can help figure out the origin of warnings or other mysterious logs in a large
         *   complex application.
         * 
         *   The passed messagePattern is interpreted as a JavaScript regular expression.
         * 
         *   Note: log messages that do not appear in the Developer Console because of
         *   Log.setLogPriority will never trigger a stack trace.
         * 
         * 
         * \* @param {string} \* @param {string=} 
         */
        fun traceLogMessage(messagePattern: String, prefix: String?): Unit = definedExternally
        /**
         * 
         *   Observe a method on an object, logging a stack trace whenever the method is called.
         * 
         *   Call a second time with identical arguments to disable tracing.
         * 
         * 
         *  @param {object} object to observe
         *  @param {string} name of the method to observe
         */
        fun traceMethod(`object`: dynamic, methodName: String): Unit = definedExternally
        /**
         * 
         *   Observe a method on an object, logging execution time whenever the method is called.
         * 
         *   Call a second time with identical arguments to disable tracing.
         * 
         * 
         *  @param {object} object to observe
         *  @param {string} name of the method to observe
         */
        fun timeMethod(`object`: dynamic, methodName: String): Unit = definedExternally
    }
}