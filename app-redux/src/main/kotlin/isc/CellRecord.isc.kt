@file:JsQualifier("isc")
package isc

/**
 *  A CellRecord represents the data for one cell of the body area.
 * 
 *   Each CellRecord should be an object that minimally has a property named after each
 *   visible facetId with the value being a facetValueId from that facet, and also a value
 *   for CubeGrid.valueProperty.
 * 
 *   Cell records can contain any other properties desired, such as cell ids, or values for
 *   facets not initially shown.
 */
open external class CellRecord {
    /**
     *  Default property name denoting whether this record is enabled. Property name may be
     *   modified for some grid via ListGrid.recordEnabledProperty.
     *  @type {boolean}
     *  @default null
     */
    open var enabled: Boolean = definedExternally
}