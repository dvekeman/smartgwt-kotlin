@file:JsQualifier("isc")
package isc

/**
 *  Editor with a minimalist appearance, tuned for editing large numbers of properties in a
 *   constrained space.
 */
open external class PropertySheet : DynamicForm {
    companion object {
        /**
         *  Creates a new PropertySheet
         * 
         *  @param typeCheckedProperties {Partial<PropertySheet>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {PropertySheet} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): PropertySheet = definedExternally
    }
}