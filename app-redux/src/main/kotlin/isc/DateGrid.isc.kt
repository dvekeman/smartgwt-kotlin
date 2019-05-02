@file:JsQualifier("isc")
package isc

/**
 *  A ListGrid subclass that manages calendar views.
 */
open external class DateGrid : ListGrid {
    override fun selectAllRecords() = definedExternally

    companion object {
        /**
         *  Creates a new DateGrid
         * 
         *  @param typeCheckedProperties {Partial<DateGrid>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DateGrid} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DateGrid = definedExternally
    }
}