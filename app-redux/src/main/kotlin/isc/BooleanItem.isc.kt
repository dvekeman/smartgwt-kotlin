@file:JsQualifier("isc")
package isc

/**
 *  Boolean form item, implemented with customizable checkbox images
 */
open external class BooleanItem : FormItem {
    companion object {
        /**
         *  Creates a new BooleanItem
         * 
         *  @param typeCheckedProperties {Partial<BooleanItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {BooleanItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): BooleanItem = definedExternally
    }
}