@file:JsQualifier("isc")
package isc

/**
 *  A subclass of Layout that applies a sizing policy along the vertical axis, interpreting
 *   percent and "\*" sizes as proportions of the height of the layout. VLayouts will set any
 *   members that do not have explicit widths to match the layout.
 */
open external class VLayout : Layout {
    companion object {
        /**
         *  Creates a new VLayout
         * 
         *  @param typeCheckedProperties {Partial<VLayout>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {VLayout} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): VLayout = definedExternally
    }
}