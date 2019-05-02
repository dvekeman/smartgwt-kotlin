@file:JsQualifier("isc")
package isc

/**
 *  Facet definition object made use of by the CubeGrid and
 *   FacetChart classes.
 */
open external class Facet : Class {
    /**
     *  id of this facet. Any string or number.
     *  @type {string | number}
     *  @default null
     */
    open var id: dynamic = definedExternally
    /**
     *  User-visible title of this facet. Shown on the facet label in the CubeGrid.
     *  @type {string}
     *  @default null
     */
    open var title: String = definedExternally
    /**
     *  Array of facetValue definitions.
     *  @type {Array<Partial<FacetValue>>}
     *  @default null
     */
    open var values: Array<dynamic> = definedExternally
    /**
     *  When applied to a Chart, does the chart's data contain multiple values per record
     *   for this facet. See Chart.data for a full overview of inlinedValues
     *   behavior.
     *  @type {boolean}
     *  @default null
     */
    open var inlinedValues: Boolean = definedExternally
    /**
     *  facetValueId of the rollup facetValue for this facet.
     * 
     *   Note: This property is specific to CubeGrid. See
     *   CubeGrid.rollupValue.
     *  @type {string}
     *  @default "cubeGrid.rollupValue"
     */
    open var rollupValue: String = definedExternally
    /**
     *  Marks this facet as a hierarchical facet.
     * 
     *   If set, Facet.values will be linked as for a
     *   Tree.modelType Tree, using
     *   FacetValue.id and
     *   FacetValue.parentId.
     *   Expand/collapse controls will be shown allowing navigation of the facet's values.
     * 
     *   The CubeGrid's CubeGrid.dataSource system automatically avoids
     *   fetching data for facetValues that are not currently visible due to the expand/collapse
     *   state of a tree facet.
     * 
     *   Initial open/close state can be controlled via
     *   Facet.collapsed and FacetValue.collapsed.
     * 
     *   Note: This property is specific to CubeGrid.
     *  @type {boolean}
     *  @default false
     */
    open var isTree: Boolean = definedExternally
    /**
     *  Indicates internal hierarchy should be displayed in reverse of normal tree order (so
     *   that parents follow children).
     * 
     *   Note: This property is specific to CubeGrid.
     *  @type {boolean}
     *  @default false
     */
    open var showParentsLast: Boolean = definedExternally
    /**
     *  For tree facets, default collapse state for parent nodes.
     * 
     *   Note: This property is specific to CubeGrid.
     *  @type {boolean}
     *  @default false
     */
    open var collapsed: Boolean = definedExternally
    /**
     *  For tree facets, whether expand/collapse controls should be shown.
     * 
     *   Note: This property is specific to CubeGrid (see, for
     *   example, CubeGrid.canCollapseFacets).
     *  @type {boolean}
     *  @default "facet.isTree"
     */
    open var canCollapse: Boolean = definedExternally
    /**
     *  If facet minimizing is enabled, whether this facet should show controls to minimize the
     *   next facet. Generally a tree facet should not also allow minimizing the next facet -
     *   the interaction of the two types of collapsing can be confusing.
     * 
     *   Note: This property is specific to CubeGrid. See
     *   CubeGrid.canMinimizeFacets.
     *  @type {boolean}
     *  @default "cubeGrid.canMinimizeFacets"
     */
    open var canMinimize: Boolean = definedExternally
    /**
     *  Integer number of pixels. For row facets, width of headers.
     * 
     *   Note: This property is specific to CubeGrid.
     *  @type {number}
     *  @default "cubeGrid.defaultFacetWidth"
     */
    open var width: dynamic = definedExternally
    /**
     *  Integer number of pixels. For column facets, specifies the height of header.
     *   Has no effect on row facets.
     * 
     *   If this property conflicts with a Facet.labelHeight, the greater of the two
     *   properties will be used for determining the height of the affected row.
     * 
     *   Note: This property is specific to CubeGrid.
     *  @type {number}
     *  @default null
     */
    open var height: dynamic = definedExternally
    /**
     *  Integer number of pixels. For column facets other than the innermost, specifies
     *   the height of the header. For row facets, specifies the height of the row
     *   containing that row facet's label (which is the same row containing the
     *   innermost column facet if one or more column facets are present).
     * 
     *   If this property conflicts with a Facet.height, the greater of the two
     *   properties will be used for determining the height of the affected row.
     * 
     *   Note: This property is specific to CubeGrid.
     *  @type {number}
     *  @default null
     */
    open var labelHeight: Number = definedExternally
    /**
     *  Default alignment for facet label title, and cells for this facet.
     *   Can be overridden at the facetValue level, or by setting titleAlign or cellAlign
     *   on the facet.
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
     *  Alignment of facet label title.
     * 
     *   Note: This property is specific to CubeGrid.
     *  @type {Alignment}
     *  @default "cubeGrid.facetTitleAlign"
     */
    open var titleAlign: 
                         /**
                          *  Center within container.
                          *  Stick to left side of container.
                          *  Stick to right side of container.
                          */
                         String /* center |  left |  right */ = definedExternally
    /**
     *  Default alignment of cells (in the body) for this facet.
     * 
     *   Note: This property is specific to CubeGrid.
     *  @type {Alignment}
     *  @default "cubeGrid.cellAlign"
     */
    open var cellAlign: 
                        /**
                         *  Center within container.
                         *  Stick to left side of container.
                         *  Stick to right side of container.
                         */
                        String /* center |  left |  right */ = definedExternally
    /**
     *  CSS line style to apply as a border before this facet, eg "1px dashed blue"
     * 
     *   Note: This property is specific to CubeGrid.
     *  @type {string}
     *  @default null
     */
    open var borderBefore: String = definedExternally
    /**
     *  CSS line style to apply as a border after this facet, eg "1px dashed blue"
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
     *  Value for facet summary.
     * 
     *   Note: This property is specific to CubeGrid.
     *  @type {string}
     *  @default "cubeGrid.summaryValue"
     */
    open var summaryValue: String = definedExternally
    /**
     *  Title for facet summary.
     * 
     *   Note: This property is specific to CubeGrid.
     *  @type {string}
     *  @default "cubeGrid.summaryTitle"
     */
    open var summaryTitle: String = definedExternally
    /**
     *  If true, treat all values in this facet as a facetValueGroup - causes
     *   synched header reorder and resize.
     * 
     *   Note: This property is specific to CubeGrid and is only
     *   supported when all of a facet's values are used.
     *  @type {boolean}
     *  @default true
     */
    open var synchColumnLayout: Boolean = definedExternally
    /**
     *  For FacetChart only, this property specifies the value axis
     *   label when a FacetChart is in FacetChart.proportional
     *   and has this facet as its FacetChart.getLegendFacet. If the
     *   proportionalTitle is not specified then
     *   FacetChart.proportionalAxisLabel is used as the default title.
     *  @type {string}
     *  @default null
     */
    open var proportionalTitle: String = definedExternally
    companion object {
        /**
         *  Creates a new Facet
         * 
         *  @param typeCheckedProperties {Partial<Facet>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Facet} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Facet = definedExternally
    }
}