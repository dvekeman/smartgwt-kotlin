@file:JsQualifier("isc")
package isc

/**
 * 
 *   A JavaScript Object where each property name is a facetId and each property value is a
 *   facetValueId for that facet.
 * 
 * 
 * 
 *   The facetId &rarr; facetValueId mappings in a FacetValueMap describe a specific slice of the
 *   dataset. If mappings are included for all facets, a FacetValueMap describes a unique
 *   cell. If some facets are omitted, it describes a row, column, or set of rectangular
 *   areas, or equivalently, a particular row or column header (if all facetIds in the map are
 *   displayed on the same axis)
 * 
 *   FacetValueMaps are used in various contexts to describe headers, datasets to be loaded,
 *   screen regions, etc.
 */
open external class FacetValueMap {
}