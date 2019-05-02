@file:JsQualifier("isc")
package isc

/**
 *  Container for a Browser Plugin.
 */
open external class BrowserPlugin : Canvas {
    companion object {
        /**
         *  Creates a new BrowserPlugin
         * 
         *  @param typeCheckedProperties {Partial<BrowserPlugin>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {BrowserPlugin} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): BrowserPlugin = definedExternally
    }
}