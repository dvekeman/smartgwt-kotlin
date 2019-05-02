@file:JsQualifier("isc")
package isc

/**
 *  Base class for Canvas and DrawItem.
 */
open external class BaseWidget : Class {
    companion object {
        /**
         *  Creates a new BaseWidget
         * 
         *  @param typeCheckedProperties {Partial<BaseWidget>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {BaseWidget} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): BaseWidget = definedExternally
    }
}