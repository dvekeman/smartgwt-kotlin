@file:JsQualifier("isc")
package isc

/**
 *  A subclass of Layout that applies a sizing policy along the horizontal axis, interpreting
 *   percent and "\*" sizes as proportions of the width of the layout. HLayouts will set any members
 *   that do not have explicit heights to match the layout.
 */
open external class HLayout : Layout {
    companion object {
        /**
         *  Creates a new HLayout
         * 
         *  @param typeCheckedProperties {Partial<HLayout>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {HLayout} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): HLayout = definedExternally
    }
}