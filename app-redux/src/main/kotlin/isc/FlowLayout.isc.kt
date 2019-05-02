@file:JsQualifier("isc")
package isc

/**
 *  Arranges a set of Canvas components into rows, flowing into available space so that
 *   different numbers of components may appear in each row.
 * 
 *   FlowLayout is essentially just a subclass of TileLayout where the
 *   default TileLayout.layoutPolicy is "flow" instead of "fit".
 */
open external class FlowLayout : TileLayout {
    companion object {
        /**
         *  Creates a new FlowLayout
         * 
         *  @param typeCheckedProperties {Partial<FlowLayout>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {FlowLayout} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): FlowLayout = definedExternally
    }
}