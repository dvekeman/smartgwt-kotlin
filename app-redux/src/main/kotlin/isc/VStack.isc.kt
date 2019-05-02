@file:JsQualifier("isc")
package isc

/**
 *  A subclass of Layout that simply stacks members on the vertical axis without trying to
 *   manage their height. On the horizontal axis, any members that do not have explicit widths
 *   will be sized to match the width of the stack.
 */
open external class VStack : Layout {
    companion object {
        /**
         *  Creates a new VStack
         * 
         *  @param typeCheckedProperties {Partial<VStack>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {VStack} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): VStack = definedExternally
    }
}