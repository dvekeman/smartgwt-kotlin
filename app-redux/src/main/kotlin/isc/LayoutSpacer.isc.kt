@file:JsQualifier("isc")
package isc

/**
 *  Add a spacer to a Layout that takes up space just like a normal member, without actually
 *   drawing anything. A LayoutSpacer is semantically equivalent to using an empty canvas,
 *   but higher performance for this particular use case.
 */
open external class LayoutSpacer : Canvas {
    companion object {
        /**
         *  Creates a new LayoutSpacer
         * 
         *  @param typeCheckedProperties {Partial<LayoutSpacer>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {LayoutSpacer} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): LayoutSpacer = definedExternally
    }
}