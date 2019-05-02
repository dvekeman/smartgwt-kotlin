@file:JsQualifier("isc")
package isc

/**
 *  TextItem subclass for managing a DataPath
 */
open external class DataPathItem : TextItem {
    companion object {
        /**
         *  Creates a new DataPathItem
         * 
         *  @param typeCheckedProperties {Partial<DataPathItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DataPathItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DataPathItem = definedExternally
    }
}