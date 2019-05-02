@file:JsQualifier("isc")
package isc

/**
 *  Facet value definition object made use of by the CubeGrid and
 *   FacetChart classes (contained by facets).
 */
open external class FacetValue {
    /**
     *  id of this facetValue. Any string or number.
     *  @type {string | number}
     *  @default null
     */
    open var id: dynamic = definedExternally
    /**
     *  User-visible title of this facetValue. Shown on the field header.
     *  @type {string}
     *  @default null
     */
    open var title: String = definedExternally
    /**
     *  For tree facets (Facet.isTree), id of this facetValue's
     *   parent facetValue.
     * 
     *   Note: This property is specific to CubeGrid.
     *  @type {string | number}
     *  @default null
     */
    open var parentId: dynamic = definedExternally
    /**
     *  Whether cells for this facetValue can be edited. Defaults to CubeGrid.canEdit.
     * 
     *   Note: This property is specific to CubeGrid.
     *  @type {boolean}
     *  @default "cubeGrid.canEdit"
     */
    open var canEdit: Boolean = definedExternally
    /**
     *  For tree facets, initial collapse state for this node. Defaults to Facet.collapsed.
     * 
     *   Note: This property is specific to CubeGrid.
     *  @type {boolean}
     *  @default "facet.collapsed"
     */
    open var collapsed: Boolean = definedExternally
    /**
     *  For individual parent facetValues within a hierarchical facet, this flag controls
     *   whether an expand/collapse control will be shown.
     * 
     *   Note: This property is specific to CubeGrid (see, for
     *   example, CubeGrid.canCollapseFacets).
     *  @type {boolean}
     *  @default true
     */
    open var canCollapse: Boolean = definedExternally
    /**
     *  Used to determine which facetValue is to be shown when the facet is minimized.
     * 
     *   Note: This property is specific to CubeGrid. See
     *   CubeGrid.canMinimizeFacets.
     *  @type {boolean}
     *  @default false
     */
    open var isMinimizeValue: Boolean = definedExternally
    /**
     *  Width of the cube grid facetValue in pixels.
     * 
     *   Note: This property is specific to CubeGrid.
     *  @type {number}
     *  @default "facet.width"
     */
    open var width: dynamic = definedExternally
    /**
     *  Default alignment for facet label title and cells for this facetValue.
     *   Can be overridden by setting titleAlign or cellAlign on the facetValue.
     * 
     *   Note: This property is specific to CubeGrid (see, for
     *   example, CubeGrid.facetValueAlign).
     *  @type {Alignment}
     *  @default null
     */
    open var align: 
                    /**
                     *  Center within container.
                     *  Stick to left side of container.
                     *  Stick to right side of container.
                     */
                    String /* center |  left |  right */ = definedExternally
    /**
     *  Default alignment of cells (in the body) for this facetValue.
     * 
     *   Note: This property is specific to CubeGrid (see, for
     *   example, CubeGrid.cellAlign).
     *  @type {Alignment}
     *  @default "facet.cellAlign"
     */
    open var cellAlign: 
                        /**
                         *  Center within container.
                         *  Stick to left side of container.
                         *  Stick to right side of container.
                         */
                        String /* center |  left |  right */ = definedExternally
    /**
     *  CSS line style to apply as a border before this facetValue.
     * 
     *   Note: This property is specific to CubeGrid.
     *  @type {string}
     *  @default null
     */
    open var borderBefore: String = definedExternally
    /**
     *  CSS line style to apply as a border after this facetValue.
     * 
     *   Note: This property is specific to CubeGrid.
     *  @type {string}
     *  @default null
     */
    open var borderAfter: String = definedExternally
    /**
     *  Selection boundary determining what facets / facetValues can be selected together by
     *   drag selection / shift+click selection.
     * 
     *   Note: This property is specific to CubeGrid.
     *  @type {SelectionBoundary}
     *  @default null
     */
    open var selectionBoundary: 
                                /**
                                 *  selection boundary applies to the bottom / right of the cells
                                 *  selection boundary applies to the top / left of the cells
                                 *  selection boundary applies to both edges.
                                 */
                                String /* after |  before |  both */ = definedExternally
    /**
     *  Hilite style to apply to the title for this facetValue.
     * 
     *   Note: This property is specific to CubeGrid. See
     *   CubeGrid.hilites.
     *  @type {string}
     *  @default null
     */
    open var titleHilite: String = definedExternally
    /**
     *   Callout to determine custom value to display for cells displayed for this facetValue.
     * 
     *   Can only be set on the CubeGrid.metricFacetId or, if no metric facet
     *   is specified, on the innermost column facet.
     * 
     *   Note: This method is specific to CubeGrid.
     * 
     * 
     *  @param {CubeGrid} this facetValue's CubeGrid
     *  @param {object} cell record
     *  @param {number} row value for the cell
     *  @param {number} column value for the cell
     */
    open fun getCellValue(viewer: CubeGrid, record: dynamic, rowNum: Number, colNum: Number): String = definedExternally
    /**
     *   Formatter to apply to values displayed for cells under this facetValue.
     * 
     *   Can only be set on the CubeGrid.metricFacetId or, if no metric facet
     *   is specified, on the innermost column facet.
     * 
     *   If a single, grid-wide formatting style is desired, implement
     *   ListGrid.formatCellValue instead.
     * 
     *   Note: This method is specific to CubeGrid.
     * 
     * 
     *  @param {any} raw value for the cell being
     *  @param {CellRecord} record object for the cell.  Note: If this is a new cell that has not been saved, in an   editable grid, it has no associated record object. In this case the edit values will  be passed in as this parameter.
     *  @param {number} row number for the cell
     *  @param {number} column number for the cell.
     */
    open fun formatCellValue(value: dynamic, record: CellRecord, rowNum: Number, colNum: Number): String = definedExternally
}