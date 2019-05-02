@file:JsQualifier("isc")
package isc

/**
 *  A subclass of Layout that simply stacks members on the horizontal axis without trying to
 *   manage their width. On the vertical axis, any members that do not have explicit heights will
 *   be sized to match the height of the stack.
 */
open external class HStack : Layout {
    companion object {
        /**
         *  Creates a new HStack
         * 
         *  @param typeCheckedProperties {Partial<HStack>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {HStack} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): HStack = definedExternally
    }
}