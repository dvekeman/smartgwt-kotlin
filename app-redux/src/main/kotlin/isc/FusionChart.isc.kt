@file:JsQualifier("isc")
package isc

/**
 *  Component that wraps the FusionCharts charting engine.
 * 
 *   Provides multiple-series (area, bar, column, line, radar) and single-series (doughnut, pie)
 *   chart types. These charts all depict a single continuous dimension (eg revenue), broken down
 *   by one or two discrete dimensions (eg product, region).
 * 
 *   NOTE: you must load the PluginBridges and Charts
 *   loadingOptionalModules before you can use FusionChart.
 */
open external class FusionChart : Flashlet, Chart {
    /**
     *  Base URL where FusionCharts are installed. SmartClient expects to find the FusionCharts
     *   ".swf" files under this URL.
     * 
     *   The default value indicates that SmartClient will look for a FusionCharts directory
     *   parallel to the "isomorphic/" directory.
     * 
     *   Note that the URL formation logic automatically compensates for various inconsistencies and
     *   typos in the default names for the chart .swf files, as well as differences between
     *   FusionCharts 2.3 and 3.0.  The chart .swf files should be left exactly as found in the
     *   FusionCharts distribution. If you have renamed the charts for other purposes, you
     *   can set FusionChart.chartURL to the full path to any given chart type.
     *  @type {URL}
     *  @default "[ISOMORPHIC]/../FusionCharts/"
     */
    open var chartsBaseURL: String = definedExternally
    /**
     *  Full URL to the chart. Needed only if you have renamed the charts such that automatic
     *   URL formation won't work.
     *  @type {URL}
     *  @default null
     */
    open var chartURL: String = definedExternally
    /**
     *  Version of FusionCharts to assume. If version is "2.3", different names are used for
     *   the .swf files for each chart (to match the default names in FusionCharts 2.3), and a
     *   lower version of Flash is required (6.0).
     *  @type {string}
     *  @default "3.0"
     */
    open var fusionVersion: String = definedExternally
    /**
     *  Properties to passthrough to the 'graph' element of the XML generated for FusionCharts.
     * 
     *   Some automatic conversions are done:
     * 
     * 
     *  - boolean values become '0' and '1' as FusionCharts expects
     * 
     *  - color values with a leading '#' have the '#' stripped to match FusionCharts
     * 
     *  @type {object}
     *  @default null
     */
    open var chartProperties: dynamic = definedExternally
    /**
     *  An array of colors to use for a series of visual elements representing data (eg columns,
     *   bars, pie slices), any of which may be adjacent to any other.
     * 
     *   Colors are expressed as hexadecimal RRGGBB Strings with no leading '#' character.
     *  @type {Array<Partial<CSSColor>>}
     *  @default "see below"
     */
    open var dataColors: Array<dynamic> = definedExternally
    /**
     *  Property in each record that holds a data value.
     * 
     *   Not used if there is an inline facet, see Chart.data.
     *  @type {string}
     *  @default "_value"
     */
    override var valueProperty: String = definedExternally
    /**
     *  Dataset for this chart.
     * 
     *   Two basic formats are supported:
     * 
     * 
     *  - "Standard model": data is an array of CellRecords where each record
     *   contains one data value. Each record also contains a property named after each facetId
     *   whose value is a facetValueId from that facet.
     * 
     *   For example, with a facet with id "regions" and facetValues "west", "north" and "east", and
     *   with Chart.valueProperty with it's default value "_value", the data property
     *   could be:
     * 
     *    isc.Chart.create({
     *      facets:[{ id:"regions" }],
     *      data : [
     *       {regions:"west", _value:4},
     *       {regions:"north", _value:2},
     *       {regions:"east", _value:5}
     *      ]
     *    })
     *   If there were a second facet with id "product" and facetValues "cars" and "trucks", a Chart
     *   with a complete set of values would be:
     * 
     *    isc.Chart.create({
     *      facets:[{ id:"regions" }, { id:"product" }],
     *      data : [
     *       {product:"cars", regions:"west", _value:4},
     *       {product:"cars", regions:"north", _value:2},
     *       {product:"cars", regions:"east", _value:5},
     *       {product:"trucks", regions:"west", _value:1},
     *       {product:"trucks", regions:"north", _value:9},
     *       {product:"trucks", regions:"east", _value:3}
     *      ]
     *    })
     *   This 2 facet (or "2 dimensional") dataset, if rendered as a bar chart, would use stacked or
     *   clustered bars and a legend.
     * 
     * 
     * 
     *  - "Inlined facet": data is a single CellRecord or Array of CellRecords where
     *   each record contains multiple data values. In this case, one facet definition is considered
     *   "inlined", meaning that the facetValueIds from this facet appear as properties in each
     *   record, and each such property holds one data value. For example, a complete chart
     *   definition whose dataset is equivalent to the previous example would be:
     * 
     *    isc.Chart.create({
     *      facets: [{ 
     *       inlinedValues:true,
     *       values : [ { id:"west" }, { id:"north" }, { id : "east" } ]
     *      }],
     *      data : { west:4, north:5, east:2 }
     *    })
     *   Note that the property "inlinedValues" must be set on the facet definition, and the set of
     *   facetValueIds must be specified outside of the data array (with the "standard model",
     *   facetValueIds can be automatically derived from the data).
     * 
     *   A two facet chart with an inlined facet can be defined as follows:
     * 
     *    isc.Chart.create({
     *      facets: [
     *       { 
     *        inlinedValues:true,
     *        values : [ { id:"west" }, { id:"north" }, { id : "east" } ]
     *       }, 
     *       { id:"product" }
     *      ],
     *      data : [
     *        { product:"cars", west:4, north:5, east:2 },
     *        { product:"trucks", west:1, north:9, east:3 }
     *      ]
     *    })
     * 
     *   Comparing between the formats, the "standard model" format treats all facets identically,
     *   which can be of use when integrating with server technology that likewise treats all facets
     *   identically. The "inlined facet" format is a more compact data representation and allows
     *   easier conversion from data displayed in a ListGrid.
     *  @type {Array<Partial<CellRecord>> | CellRecord}
     *  @default null
     */
    override var data: dynamic = definedExternally
    /**
     *  An Array of facets, exactly analogous to CubeGrid.facets, except that:
     * 
     * 
     *  - the "inlinedValues" property can be set on a facet to change data representation as
     *   described under Chart.data.
     * 
     *  - for a non-inlined facet, Charts support auto-derivation of facetValues from the data.
     * 
     *  @type {Array<Partial<Facet>> | Facet}
     *  @default null
     */
    override var facets: dynamic = definedExternally
    /**
     *  Whether to use stacking for charts where this makes sense (bar, column, line and radar
     *   charts). If stacked is not set and two facets are supplied, clustering is assumed.
     *  @type {boolean}
     *  @default false
     */
    override var stacked: Boolean = definedExternally
    /**
     *  Type of chart to draw, see ChartType for a list of known types.
     *  @type {ChartType}
     *  @default "Column"
     */
    override var chartType: 
                            /**
                             *  Values represented by area, with stacked values representing multiple          facet values. This is equivalent to ChartType "Line" with stacking enabled.
                             *  Values represented by vertical columns. Typically supports stacking to         represent two facets. May support simultaneous stacking and clustering for
                             *           3 facets.
                             *  Values represented by horizontal bars. Typically supports stacking to         represent two facets. May support simultaneous stacking and clustering for
                             *           3 facets.
                             *  Values represented by a lines between data points, or stacked areas for         multiple facets.
                             *  Values represented on a circular background by a line around the center, or         stacked areas for multiple facets
                             *  Circular chart with wedges representing values. Multiple or stacked pies         for multiple facets.
                             *  Like a pie chart with a central hole. Multiple or stacked doughnuts for         multiple facets.
                             *  A chart with two continuous numeric axes and up to one discrete facet.
                             *  A chart with two continuous numeric axes and up to one discrete facet         that also displays values from a third continuous, numeric domain
                             *           represented as the sizes of the data point shapes.
                             *  Like a column chart, except instead of showing stacked or clustered values         for each position on the horizontal axis, the data values are used together
                             *           with the associated FacetChart.endValueMetric values to show a series
                             *           of line segments.
                             */
                            String /* Area |  Column |  Bar |  Line |  Radar |  Pie |  Doughnut |  Scatter |  Bubble |  Histogram */ = definedExternally
    /**
     *  A label for the data values, such as "Sales in Thousands", typically used as the label for
     *   the value axis.
     *  @type {string}
     *  @default null
     */
    override var valueTitle: String = definedExternally
    /**
     *  Title for the chart as a whole.
     *  @type {string}
     *  @default null
     */
    override var title: String = definedExternally
    /**
     *  Subtitle for the chart as a whole, typically used to describe fixed facet values (such as
     *   "for Q1, 1999").
     * 
     *   The subTitle should appear under the title in less emphasized text.
     *  @type {string}
     *  @default null
     */
    override var subTitle: String = definedExternally
    /**
     *  Whether to show chart in a 3D appearance, for charts that support this.
     *  @type {boolean}
     *  @default true
     */
    override var threeD: Boolean = definedExternally
    /**
     *  Whether the chart should animate when shown (eg, bars or columns grow into place)
     *  @type {boolean}
     *  @default true
     */
    override var shouldAnimateShow: Boolean = definedExternally
    /**
     *  Whether to show labels on each individual value (bar, column or line point)
     *  @type {boolean}
     *  @default false
     */
    override var labelValues: Boolean = definedExternally
    /**
     *   Get a color from the FusionChart.dataColors Array, or white ("FFFFFF") if the index is beyond the
     *   end of the Array.
     * 
     *   Override to provide a dynamic color generation scheme.
     * 
     * 
     *  @param {number} index of the visual element to be colored
     */
    open fun getDataColor(index: Number): String = definedExternally
    /**
     *   General facet and data model setup, including auto-derivation of facetValues from data if
     *   necessary. Should be called by any concrete charting implementation before calling any
     *   other Chart method.
     * 
     * 
     */
    override fun setupChart(): Unit = definedExternally
    /**
     *   Get a facet definition by facetId.
     * 
     *  @param {string} the id of the facet to retrieve
     */
    override fun getFacet(facetId: String): Facet = definedExternally
    /**
     *   Get facet value definition by facetId and facetValueId.
     * 
     *  @param {string} the id of the facet to retrieve
     *  @param {string} the id of the facet value to retrieve
     */
    override fun getFacetValue(facetId: String, facetValueId: String): FacetValue = definedExternally
    /**
     *   Lookup a data value by the set of matching facetValues expressed as a
     *   FacetValueMap. Automatically handles the Chart.data, if any.
     * 
     *   This method is designed to be called by a concrete Chart implementation.
     * 
     *   As a special case, if Chart.data is a single Object and the only facet is
     *   Chart.data, any value can be used as the single facetId required. For example, a
     *   legal FacetValueMap in this case would be {inlined:"west"}.
     * 
     * 
     *  @param {FacetValueMap} set of facetValues describing the data value to retrieve
     */
    override fun getValue(criteria: FacetValueMap): dynamic = definedExternally
    /**
     *   Change the dataset for this chart on the fly. May or may not be supported by concrete chart
     *   implementations.
     * 
     * 
     *  @param {Array<Partial<CellRecord>> | CellRecord} new dataset
     */
    override fun setData(newData: dynamic): Unit = definedExternally
    companion object {
        /**
         *  All ChartType that are supported by this class.
         *   Should be defined by concrete implementations of the charting interface.
         *  @type {Array<Partial<ChartType>>}
         *  @default "["Area", "Bar", "Column", "Pie", "Doughnut", "Line", "Radar"]"
         */
        var allChartTypes: Array<dynamic> = definedExternally
        /**
         *  Creates a new FusionChart
         * 
         *  @param typeCheckedProperties {Partial<FusionChart>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {FusionChart} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): FusionChart = definedExternally
    }
}