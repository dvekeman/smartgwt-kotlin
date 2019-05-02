@file:JsQualifier("isc")
package isc

/**
 *  The Timer class provides a predictable cross-browser system for creating
 *   timed events.
 */
open external class Timer : Class {
    companion object {
        /**
         *  Creates a new Timer
         * 
         *  @param typeCheckedProperties {Partial<Timer>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Timer} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Timer = definedExternally
        /**
         * 
         *   Execute an action in a given amount of time. This method wraps the native setTimeout() method,
         *   correcting for browser-specific memory leaks.
         * 
         * 
         *  @param {string | Function} Function to be called when delay has elapsed.      Can also be a string representation of an expression.     Passing a string is preferred.
         *  @param {number} Time until action is executed (in milliseconds). If not specified, the            default is 100 milliseconds.
         */
        fun setTimeout(action: dynamic, delay: Number): dynamic = definedExternally
        /**
         * 
         *   Cancels the processing of a timerEvent if it has not already fired.
         * 
         * 
         *  @param {object} timerEvent object previously returned from Timer.setTimeout()
         */
        fun clear(timerEvent: dynamic): Unit = definedExternally
    }
}