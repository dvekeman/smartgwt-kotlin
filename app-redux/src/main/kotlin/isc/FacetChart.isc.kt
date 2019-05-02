@file:JsQualifier("isc")
package isc

/**
 *  HTML5-based charting engine, implementing all Chart.chartType of the
 *   Chart interface.
 * 
 *   Can be used directly, or specified as ListGrid.chartConstructor or
 *   CubeGrid.chartConstructor.
 * 
 *   NOTE: you must load the Drawing and Charts
 *   loadingOptionalModules before you can use FacetChart.  Also,
 *   the Charts Module is available in Pro Edition or better, please see
 *   smartclient.com/product for licensing
 *   information.
 * 
 *   To create a FacetChart, set FacetChart.facets to an Array of Facet objects describing the
 *   chart dimensions and FacetChart.valueProperty to value field name. For example:
 * 
 * 
 *   isc.FacetChart.create({
 *     facets: [{
 *       id: "season",  // the key used for this facet in the data above
 *       title: "Season" // the user-visible title you want in the chart
 *     }],
 *     valueProperty: "temp", // the property in our data that is the numerical value to chart
 *     data: [
 *       {season: "Spring", temp: 79},
 *       {season: "Summer", temp: 102},
 *       {season: "Autumn", temp: 81},
 *       {season: "Winter", temp: 59}
 *     ],
 *     title: "Average temperature in Las Vegas"
 *   });
 * 
 * 
 * 
 * 
 *   The following SDK examples demonstrate charts with a single facet:
 * 
 * 
 *  - ${isc.DocUtils.linkForExampleId('logScalingChart', 'Log Scaling')} example,
 * 
 *  - ${isc.DocUtils.linkForExampleId('dataPointsChart', 'Interactive Data Points')} example, and
 * 
 *  - ${isc.DocUtils.linkForExampleId('addingElements', 'Adding Element')} example.
 * 
 *   See the following SDK examples for examples of charts with multiple facets:
 * 
 * 
 *  - ${isc.DocUtils.linkForExampleId('simpleChart', 'Simple Chart')} example,
 * 
 *  - ${isc.DocUtils.linkForExampleId('multiSeriesChart', 'Multi-Series Chart')} example, and
 * 
 *  - ${isc.DocUtils.linkForExampleId('dynamicDataCharting', 'Dynamic Data')} example.
 * 
 * 
 *   the Inlined Facet
 * 
 *   Having an "inlined facet" is another method to provide data to the chart. In this case each CellRecord
 *   contains multiple data values; one facet definition is considered "inlined", meaning that
 *   the facetValueIds from this facet appear as properties in each Record, and each such
 *   property holds one data value. In this case the singular valueProperty is ignored.
 *   For example:
 * 
 * 
 *   isc.FacetChart.create({
 *     facets: [
 *       {
 *         inlinedValues: true,
 *         values: [
 *           {id: "spring", title: "Spring"},
 *           {id: "summer", title: "Summer"},
 *           {id: "autumn", title: "Autumn"},
 *           {id: "winter", title: "Winter"}
 *         ]
 *       }
 *     ],
 *     data: [
 *       {spring: 79, summer: 102, autumn: 81, winter: 59}
 *     ],
 *     title: "Average temperature in Las Vegas"
 *   });
 * 
 *   Example with two facets:
 * 
 *   isc.FacetChart.create({
 *     facets: [
 *       {
 *         inlinedValues: true,
 *         values: [
 *           {id: "spring", title: "Spring"},
 *           {id: "summer", title: "Summer"},
 *           {id: "autumn", title: "Autumn"},
 *           {id: "winter", title: "Winter"}
 *         ]
 *       },
 *       {id: "city"}
 *     ],
 *     data: [
 *       {city: "Las Vegas", spring: 79, summer: 102, autumn: 81, winter: 59},
 *       {city: "New York", spring: 60, summer: 83, autumn: 66, winter: 40}
 *     ],
 *     stacked: false,
 *     title: "Average temperatures"
 *   });
 * 
 * 
 * 
 * 
 *   Dual axis or multi-axis charts
 * 
 *   FacetChart supports drawing multiple vertical axes. This is commonly used to show values
 *   with different units (for example: sales in dollars, total units shipped) and/or very different
 *   ranges (for example: gross revenue, profit) on the same chart. Each set of values, referred
 *   to as a "metric", gets its own axis and gradation marks.
 * 
 *   To use multiple axes, you add an additional facet called the "metric facet" that specifies
 *   each axis to be plotted as a facetValueId. The metric facet is an inlined facet, so as with
 *   inlined facets in general, each CellRecord has a value for each facetValueId of the metric
 *   facet. You then set FacetChart.extraAxisMetrics to the list of
 *   metrics that should be plotted as additional axes.
 * 
 *   For example, if you were plotting revenue and profit for each month of the year, you would
 *   have one facet named "metric" with facetValueIds "revenue" and "profit" and a second facet
 *   "month". Each CellRecord would have the revenue and profit for one month, stored under the
 *   properties "revenue" and "profit". Setting extraAxisMetrics to ["profit"]
 *   would cause profit to be plotted as the second axis. See the
 *   ${isc.DocUtils.linkForExampleId('dualAxisChartMA', 'Dual Axis')} SDK sample for an example.
 * 
 *   You can have multiple extra axes and the additional axes and gradation tics will be drawn at
 *   increasing distances from the chart. By default, the first metric is drawn as a column chart
 *   and subsequent metrics are drawn as lines; you can override this via
 *   FacetChart.extraAxisSettings. See the
 *   ${isc.DocUtils.linkForExampleId('threePlusChartMA', '3+ Axes')} SDK sample for an example of multiple extra axes.
 * 
 *   Multi-axis, multi-facet charts are also allowed. Extending the previous example, you might
 *   add a new facet "company", for a total of 3 facets. Each CellRecord would have "revenue"
 *   and "profit" for one combination of "company" and "month". The default appearance in this
 *   case would show revenue as clustered columns (one cluster per month, one column per company)
 *   and would show profit as multiple lines (one per company). See the
 *   ${isc.DocUtils.linkForExampleId('multiSeriesChartMA', 'Multi-Series')} SDK sample for an example of a
 *   multi-axis, multi-facet chart.
 * 
 *   Mixed plots
 *   In some cases you want to show some data series as one shape and other data series as
 *   another shape but use the same axis. This is commonly used when one series is of a
 *   fundamentally different kind than the other series (for example, a projection or average)
 *   but still has the same scale.
 * 
 *   To achieve a mixed plot like this, define it as a multi-axis chart as explained above, but
 *   set MetricSettings.showAxis false to avoid a second axis appearing, and set
 *   MetricSettings.matchGradations to cause the same gradations to be used for both
 *   plots.
 * 
 *   See the ${isc.DocUtils.linkForExampleId('mixedPlotsChart', 'Mixed Plots')} SDK example.
 * 
 *   Histogram Charts
 * 
 *   A "histogram" chart is similar to a FacetChart.stacked "column" chart, showing
 *   multiple facet values vertically for each position along the x-axis /
 *   FacetChart.getDataLabelFacet, but instead of each vertical facet
 *   value being defined only by a length, a "histogram" chart defines a segment for each,
 *   represented by both a start point (the FacetChart.valueProperty) and
 *   an end point (the FacetChart.endValueMetric).
 * 
 *   Segments may overlap, with the last segment drawn receiving the highest z-ordering. To
 *   override this default behavior, values may be provided using an additional metric -
 *   FacetChart.zIndexMetric - whose value must be a non-negative integer no greater than
 *   FacetChart.maxDataZIndex.
 * 
 *   Scatter Charts
 * 
 *   Scatter charts differ from other chart types in that both axes represent continuous numeric
 *   data rather than a discrete set of facet values (like months of the year). For this reason
 *   Scatter charts use the same concept of a "metric" facet as is used by Dual-Axis charts,
 *   where the metric facet is expected to have exactly two metrics: the
 *   FacetChart.xAxisMetric and FacetChart.yAxisMetric.
 * 
 *   Unlike all other chart types, a scatter plot may be specified with only the metric facet.
 *   However one additional facet can be defined, which allows multiple sets of x,y points to be
 *   drawn in different colors, analogous to the different colors of a multi-series line chart.
 * 
 *   See the ${isc.DocUtils.linkForExampleId('scatterPlotCharting', 'Scatter Plot')} SDK example.
 * 
 *   Date values on the X axis
 * 
 *   FacetChart also supports scatter charts where the x-axis represents date- or time-valued
 *   data and the y-axis represents numeric data, as normal. To enable this mode all records in
 *   the data must have values for the facetValueId of the
 *   FacetChart.xAxisMetric that are true Date objects, not Strings or
 *   nulls. For these charts, vertical lines are drawn to represent a sequence of
 *   significant datetime values on the x-axis, such as the first day of the month or week. The
 *   mechanism used to select these Dates and format them into the x-axis labels is the same
 *   mechanism used by charts with FacetChart.labelCollapseMode set to
 *   "time".
 * 
 *   Bubble Charts
 * 
 *   A "bubble" chart is a type of scatter chart where the size of each rendered data
 *   point represents an additional metric value, allowing 3 continuous data values to be
 *   visualized together. When using chartType:"Bubble", the additional metric
 *   is configured via FacetChart.pointSizeMetric.
 *   Points will be sized between the FacetChart.minDataPointSize and
 *   FacetChart.maxDataPointSize, optionally with
 *   FacetChart.logScalePointSize. A legend will be included showing
 *   how point size represents data values, and a multi-facet Bubble chart can optionally use a
 *   different shape for each facetValue via
 *   FacetChart.useMultiplePointShapes.
 * 
 *   Variable-size points can also be used with other, non-scatter chart types (such as "Line"
 *   or "Radar") when FacetChart.showDataPoints is enabled, by setting
 *   pointSizeMetric to the FacetValue.id of a Facet.values
 *   of the metric facet. In this case, a legend for point sizes is not shown by default, but can
 *   be enabled via FacetChart.showPointSizeLegend.
 * 
 *   Whenever drawing variable size data points, by default, the largest data points are drawn
 *   first so that smaller data points are less likely to be completely occluded by larger data
 *   points, but this can be disabled by setting
 *   FacetChart.autoSortBubblePoints to false. Visual
 *   appearance of data points can be further customized by setting the
 *   FacetChart.bubbleProperties.
 * 
 *   See the ${isc.DocUtils.linkForExampleId('bubbleChart', 'Bubble Chart')} SDK example.
 * 
 *   Color Scale Charts
 * 
 *   FacetChart supports rendering an additional metric value as the color of each data
 *   point. This feature requires that FacetChart.showDataPoints be
 *   enabled and is configured via FacetChart.colorScaleMetric. Instead
 *   of data points being drawn using a separate color for each facetValue of the
 *   legend facet, the data points will be drawn using a color interpolated between the
 *   FacetChart.scaleStartColor and
 *   FacetChart.scaleEndColor, optionally with
 *   FacetChart.logScalePointColor. A legend is included by default
 *   via FacetChart.showColorScaleLegend that shows how the data
 *   values are mapped to a color via a gradient over the range of colors used in the chart.
 *   Visual appearance of data points in color scale charts can be further customized by setting
 *   the FacetChart.bubbleProperties, just as with bubble charts.
 * 
 *   Note that when color is being used to show values of the colorScaleMetric then
 *   color cannot be used to distinguish between different facetValues. Therefore
 *   color scale charts cannot have a (non-metric) legend facet.
 * 
 *   See the ${isc.DocUtils.linkForExampleId('colorScaleChart', 'Color Scale Chart')} SDK example.
 * 
 *   Notes on printing
 * 
 *   FacetCharts support printing on all supported desktop browsers. When using Pro Edition or
 *   better with the SmartClient Server Framework installed, charts can also be exported to PDF
 *   via RPCManager.exportContent or to images via RPCManager.exportImage.
 */
open external class FacetChart : DrawPane, Chart {
    /**
     *  Default styleName for the chart.
     *  @type {CSSStyleName}
     *  @default "scChart"
     */
    override var styleName: String = definedExternally
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
     *   with FacetChart.valueProperty with it's default value "_value", the data property
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
     *  - the "inlinedValues" property can be set on a facet to change data representation
     *   as described under Chart.data.
     * 
     *  - for a non-inlined facet, Charts support auto-derivation of facetValues from the
     *   data.
     * 
     * 
     *   In all chart types except "Bubble" and "Scatter", the chart displays a value for each
     *   discrete value of one facet (i.e. single-facet charts) or it displays a value for each
     *   combination of discrete values of two facets (multi-facet charts). The two discrete
     *   facets are the FacetChart.getDataLabelFacet and the
     *   FacetChart.getLegendFacet. They are named based on where the
     *   Facet.values of the facet appear in the chart. The facet whose values
     *   are rendered as labels along the data axis or in the main chart area is the data label
     *   facet, and the facet whose values are rendered in the legend is the legend facet.
     * 
     *   For single-facet charts, most chart types have a data label facet as the first facet
     *   but no legend facet. Single-facet Pie charts have a legend facet as the first facet
     *   but no data label facet. Bubble and Scatter plots may have a legend facet as the
     *   second facet, after the metric facet.
     * 
     *   In all multi-facet charts, the data label facet is always first and the legend facet
     *   is second. In most chart types the data label facet and the legend facet may be
     *   swapped on the fly by the user clicking on the "Swap Facets" item of the context menu.
     *  @type {Array<Partial<Facet>> | Facet}
     *  @default null
     */
    override var facets: dynamic = definedExternally
    /**
     *  Specifies the "id" of the default metric facet value. The default metric is used
     *   with FacetChart.lowErrorMetric and FacetChart.highErrorMetric when showing error bars.
     *  @type {string}
     *  @default "metric"
     */
    open var metricFacetId: String = definedExternally
    /**
     *  See ChartType for a list of known types - Column, Bar, Line, Pie, Doughnut,
     *   Area, Radar, and Histogram charts are supported.
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
     *  Whether to use stacking for charts where this makes sense (column, area, pie, line and
     *   radar charts). If stacked is not set and two facets are supplied, clustering is assumed.
     *   If null (the default), line charts will be unstacked, and others will be stacked.
     *  @type {boolean}
     *  @default null
     */
    override var stacked: Boolean = definedExternally
    /**
     *  Whether shapes are filled, for example, whether a multi-series line chart appears as a
     *   stack of filled regions as opposed to just multiple lines.
     * 
     *   If unset, fills will be automatically used when there are multiple facets and stacking
     *   is active (so Line and Radar charts will show stacked regions).
     * 
     *   You can explicitly set filled:false to create multi-facet Line or Radar charts where
     *   translucent regions overlap, or filled:true to fill in a single-facet Line or Radar
     *   chart.
     *  @type {boolean}
     *  @default null
     */
    open var filled: Boolean = definedExternally
    /**
     *  For multi-facet charts, render data values as a proportion of the sum of all data
     *   values that have the same label.
     * 
     *   Gradation labels will be switched to show percentage instead of absolute values.
     * 
     *   This setting is valid only for Column, Bar, Area and Radar chart types and only in
     *   FacetChart.stacked mode. Stacked columns will be as tall as the chart rect and
     *   stacked bars will be as wide as the chart rect. Area and Radar charts will be
     *   completely filled except for facet values where all values are 0.
     *  @type {boolean}
     *  @default null
     */
    open var proportional: Boolean = definedExternally
    /**
     *  Default title for the value axis label when the chart is in
     *   FacetChart.proportional. This title will be used unless the
     *   FacetChart.getLegendFacet defines a
     *   Facet.proportionalTitle.
     *  @type {string}
     *  @default "Percent"
     */
    open var proportionalAxisLabel: String = definedExternally
    /**
     *  Other ChartType that the end user will be allowed to switch to, using
     *   the built-in context menu.
     * 
     *   The actual list of ChartTypes displayed in the context menu may be a subset of
     *   allowedChartTypes, since the FacetChart will automatically disallow certain
     *   modes that are clearly invalid, for example, not allowing switching to Pie mode if
     *   either FacetChart.canZoom is enabled, or if the chart is FacetChart.extraAxisMetrics.
     *  @type {Array<Partial<ChartType>>}
     *  @default null
     */
    open var allowedChartTypes: Array<dynamic> = definedExternally
    /**
     *  Title for the chart as a whole.
     *  @type {string}
     *  @default null
     */
    override var title: String = definedExternally
    /**
     *  Whether to show a title.
     *  @type {boolean}
     *  @default true
     */
    open var showTitle: Boolean = definedExternally
    /**
     *  if aligning the title left or right, the amount of space before (for left aligned)
     *   or after (for right aligned) to pad the title from the border edge
     *  @type {boolean}
     *  @default null
     */
    open var titlePadding: Boolean = definedExternally
    /**
     *  Properties for title label.
     *  @type {DrawLabel}
     *  @default null
     */
    open var titleProperties: DrawLabel = definedExternally
    /**
     *  The height of the bordered rect around the title - defaults to 0 (assuming no border)
     *  @type {Integer}
     *  @default "5"
     */
    open var titleRectHeight: Number = definedExternally
    /**
     *  Properties for title background (if being drawn).
     *  @type {DrawLabel}
     *  @default null
     */
    open var titleBackgroundProperties: DrawLabel = definedExternally
    /**
     *  Properties for bottom boundary of the title area, when there is already an outer
     *   container around the whole chart. see FacetChart.drawTitleBoundary
     *  @type {DrawLine}
     *  @default null
     */
    open var titleBoundaryProperties: DrawLine = definedExternally
    /**
     *  should a background color be set behind the Title. Use
     *   FacetChart.titleBackgroundProperties to set these values if this is true.
     *  @type {boolean}
     *  @default null
     */
    open var drawTitleBackground: Boolean = definedExternally
    /**
     *  Whether a boundary should be drawn below the title area for circumstances where the
     *   chart area already has an outer border. If the chart has no outer border, then the
     *   FacetChart.titleBackgroundProperties settings should be used instead.
     *  @type {boolean}
     *  @default null
     */
    open var drawTitleBoundary: Boolean = definedExternally
    /**
     *  A label for the data values, such as "Sales in Thousands", typically used as the label for
     *   the value axis.
     *  @type {string}
     *  @default null
     */
    override var valueTitle: String = definedExternally
    /**
     *  Whether to show the FacetChart.valueTitle (or, in the case of
     *   FacetChart.proportional, the
     *   FacetChart.proportionalAxisLabel) as a label on the value axis.
     * 
     *   Automatically disabled for non-rectangular charts (eg Pie, Radar).
     *  @type {boolean}
     *  @default null
     */
    open var showValueAxisLabel: Boolean = definedExternally
    /**
     *  Properties for labels of value axis.
     *  @type {DrawLabel}
     *  @default null
     */
    open var valueAxisLabelProperties: DrawLabel = definedExternally
    /**
     *  Whether to show a label for the data axis as a whole (the data axis is where labels for
     *   each data point appear). If true, Facet.title for the data label facet will be
     *   shown as the label.
     * 
     *   Automatically disabled for non-rectangular charts (eg Pie, Radar).
     *  @type {boolean}
     *  @default null
     */
    open var showDataAxisLabel: Boolean = definedExternally
    /**
     *  Properties for labels of data axis.
     *  @type {DrawLabel}
     *  @default null
     */
    open var dataAxisLabelProperties: DrawLabel = definedExternally
    /**
     *  Ideal number of pixels to leave between each gradation on the primary axis, which is
     *   typically the y (vertical) axis except for Bar charts.
     * 
     *   The chart will detect the range of values being displayed and available pixels on the
     *   vertical axis, and generate gradations that are spaced approximately
     *   pixelsPerGradations apart. Note that the Framework will attempt to
     *   approach the specified target gap from above - the chart will never be drawn with
     *   gradations spaced closer than pixelsPerGradation.
     *  @type {Integer}
     *  @default "28"
     */
    open var pixelsPerGradation: Number = definedExternally
    /**
     *  Ideal number of pixels to leave between each gradation on the x (horizontal axis), for
     *   Scatter plots only.
     * 
     *   Defaults to the value of FacetChart.pixelsPerGradation if unset.
     *  @type {Integer}
     *  @default null
     */
    open var otherAxisPixelsPerGradation: Number = definedExternally
    /**
     *  Candidate gradation gaps to evaluate when trying to determine what gradations should be
     *   displayed on the primary axis, which is typically the y (vertical) axis except for Bar
     *   charts.
     * 
     *   Candidates are expressed as a series of numbers between 1 and 10, representing boundaries
     *   within a given order of magnitude (power of 10).
     * 
     *   For example, the setting [1, 2.5, 5] means that, for a chart showing values that are only
     *   between 0 and 1, gradations of 0.1, 0.25 and 0.5 would be evaluated to see which is a
     *   closer fit given the FacetChart.pixelsPerGradation setting and the chart's height. The same
     *   setting, with a chart showing values from 0 to 1,000,000 would imply that gradation gaps
     *   of 100,000, 250,000 and 500,000 would be evaluated.
     *  @type {Array<Partial<Float>>}
     *  @default "[1, 2, 5]"
     */
    open var gradationGaps: Array<dynamic> = definedExternally
    /**
     *  Like FacetChart.gradationGaps, except allows control of gradations for the X
     *   (horizontal) axis, for Scatter charts only.
     * 
     *   See also FacetChart.otherAxisGradationTimes for control of gradations when the X
     *   axis is time-valued.
     * 
     *   Defaults to the value of FacetChart.pixelsPerGradation if unset.
     *  @type {Array<Partial<Float>>}
     *  @default null
     */
    open var otherAxisGradationGaps: Array<dynamic> = definedExternally
    /**
     *  For charts that have a date/time-valued X-axis, gradations can instead be specified as
     *   Strings, consisting of a number and trailing letter code, where the letter code indicates
     *   the unit of time. Valid time units are "ms" (millisecond), "s" (second), "mn" (minute),
     *   "h" (hour), "d" (day), "w" (week), "m" (month), "q" (quarter, 3-months), "y" (year).
     * 
     *   When time units are used, there is no way to scale the same unit to a much larger or
     *   smaller range of time (as there is with numeric gradations). For example, a setting of
     *   "30mn" meaning "30 minutes" does not mean that 30 hours is a natural choice for chart
     *   with a longer timeline (days should obviously be chosen instead). Therefore, when
     *   specifying time gradations, candidate gradations must be provided for the entire possible
     *   displayed range. If insufficient gradations are specified, this can result in unreadable
     *   charts; for example, if the largest available gradation is "15mn" and the chart is
     *   showing a full week's data in around 500px, there will be more than one gradation per
     *   pixel, and labels will be drawn on top of each other.
     * 
     *   To prevent this, be sure to specify enough gradations to cover the all time ranges your
     *   chart may need to display. However, if gradations are not specified for granularities
     *   under 1 second or over 1 year, further gradations will be chosen based on using
     *   FacetChart.otherAxisGradationGaps to choose fractions of seconds or multiples of years.
     * 
     *   The default setting is effectively:
     * 
     *   ["1s", "15s", "30s", "1mn", "5mn", "15mn", "30mn", "1h", "1d", "1w", "1m", "1q", "1y"]
     * 
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var otherAxisGradationTimes: Array<dynamic> = definedExternally
    /**
     *  If all data values would be spread across less than FacetChart.minDataSpreadPercent of the
     *   axis, the start values of axes will be automatically adjusted to make better use of
     *   space.
     * 
     *   For example, if a column chart has all data values between 500,000 and 500,100, if the
     *   axis starts at 0, differences in column heights will be visually indistinguishable.
     *   In this case, since all data values appear in well under 30% of the axis length, the
     *   default minDataSpreadPercent setting would cause the axis to start at a
     *   value that would make the column heights obviously different (for example, starting the
     *   axis as 500,000).
     * 
     *   Setting an explicit FacetChart.axisStartValue or FacetChart.axisEndValue,
     *   disables this behavior, as does setting
     *   minDataSpreadPercent to 0.
     * 
     *   For multi-axis charts, use MetricSettings.minDataSpreadPercent for per-axis
     *   settings.
     * 
     *   For Bubble and Scatter charts, minDataSpreadPercent affects only the y-axis
     *   of the chart. The property FacetChart.minXDataSpreadPercent must be used to enable the
     *   corresponding feature for the x-axis.
     *  @type {Integer}
     *  @default "30"
     */
    open var minDataSpreadPercent: Number = definedExternally
    /**
     *  Start value for the primary axis of the chart.
     * 
     *   If set to an explicit value, this will be respected.
     *   If unset, the axis start value will default to 0, or to a value that makes good
     *   use of vertical space based on FacetChart.minDataSpreadPercent.
     * 
     *   For multi-axis charts, Bubble charts, and Scatter charts, the
     *   facetChart.axisStartValue affects only the first axis of the chart.
     *   Start values for other axes of multi-axis charts can be set on a per-axis basis via
     *   MetricSettings.axisStartValue. For Scatter charts, the FacetChart.xAxisStartValue
     *   property must be used to set the start value of the x-axis.
     * 
     *   Note that if this chart's data includes points that fall below this value, they
     *   are ommitted and effectively treated as null values. For charts showing a data line,
     *   developers may wish to set FacetChart.discontinuousLines to true in this case.
     *  @type {Float}
     *  @default null
     */
    open var axisStartValue: Number = definedExternally
    /**
     *  End value for the primary axis of the chart.
     * 
     *   If set to an explicit value, this will be respected.
     *   If unset, the axis end value will default to a value large enough to the
     *   largest data point, rounded up to the nearest (next) gradation.
     * 
     *   For multi-axis charts, Bubble charts, and Scatter charts, the
     *   facetChart.axisEndValue affects only the first axis of the chart.
     *   End values for other axes of multi-axis charts can be set on a per-axis basis via
     *   MetricSettings.xAxisEndValue. For Scatter charts, the FacetChart.xAxisEndValue
     *   property must be used to set the end value of the x-axis.
     * 
     *   Note that if this chart's data includes points that fall above this value, they
     *   are ommitted and effectively treated as null values. For charts showing a data line,
     *   developers may wish to set FacetChart.discontinuousLines to true in this case.
     *  @type {Float}
     *  @default null
     */
    open var axisEndValue: Number = definedExternally
    /**
     *  For Bubble and Scatter charts only, the start value for the x-axis.
     * 
     *   Defaults to 0, or to a value that makes good use of horizontal space based on
     *   FacetChart.minXDataSpreadPercent.
     * 
     *   If the x-axis metric is date-valued, this value should be a date (typically
     *   applies to Scatter charts only).
     *  @type {Float | Date}
     *  @default null
     */
    open var xAxisStartValue: dynamic = definedExternally
    /**
     *  For Bubble and Scatter charts only, the end value for the x-axis.
     * 
     *   If set to an explicit value, this will be respected.
     *   If unset, the axis end value will default to a value large enough to show the
     *   largest data point.
     * 
     *   If the x-axis metric is date-valued, this value should be a date (typically
     *   applies to Scatter charts only).
     *  @type {Float | Date}
     *  @default null
     */
    open var xAxisEndValue: dynamic = definedExternally
    /**
     *  For scatter charts only, if all data points would be spread across less than
     *   FacetChart.minXDataSpreadPercent of the x-axis, the start value of x-axis will be automatically
     *   adjusted to make better use of space.
     * 
     *   Setting an explicit FacetChart.xAxisStartValue disables this behavior, as does setting
     *   minXDataSpreadPercent to 0.
     *  @type {Integer}
     *  @default "30"
     */
    open var minXDataSpreadPercent: Number = definedExternally
    /**
     *  Properties for gradation labels
     *  @type {DrawLabel}
     *  @default null
     */
    open var gradationLabelProperties: DrawLabel = definedExternally
    /**
     *  Properties for gradation lines
     *  @type {DrawLine}
     *  @default null
     */
    open var gradationLineProperties: DrawLine = definedExternally
    /**
     *  Properties for the gradation line drawn for zero (slightly thicker by default).
     *  @type {DrawLine}
     *  @default null
     */
    open var gradationZeroLineProperties: DrawLine = definedExternally
    /**
     *  Whether to show alternating color bands in the background of chart. See
     *   FacetChart.backgroundBandProperties.
     *  @type {boolean}
     *  @default true
     */
    open var bandedBackground: Boolean = definedExternally
    /**
     *  Properties for background band
     *  @type {DrawRect}
     *  @default null
     */
    open var backgroundBandProperties: DrawRect = definedExternally
    /**
     *  Whether to show gradation labels in radar charts.
     *  @type {boolean}
     *  @default true
     */
    open var showRadarGradationLabels: Boolean = definedExternally
    /**
     *  For scatter charts only, the "id" of the metric facet value to use for the x-axis.
     * 
     *   The default x-axis metric is the second value of the metric facet.
     *  @type {string}
     *  @default null
     */
    open var xAxisMetric: String = definedExternally
    /**
     *  For scatter charts only, the "id" of the metric facet value to use for the y-axis.
     * 
     *   The default y-axis metric is the first value of the metric facet.
     *  @type {string}
     *  @default null
     */
    open var yAxisMetric: String = definedExternally
    /**
     *  Whether to draw lines between adjacent data points in "Scatter" plots. See also
     *   DataLineType for enabling smoothing.
     *  @type {boolean}
     *  @default false
     */
    open var showScatterLines: Boolean = definedExternally
    /**
     *  How to draw lines between adjacent data points in Line and Scatter charts.
     *   See DataLineType.
     * 
     *   Does not apply to boundary lines for shapes in Area or Radar plots.
     *  @type {DataLineType}
     *  @default null
     */
    open var dataLineType: 
                           /**
                            *  simple straight lines between points that are adjacent in the dataset
                            *  smooth spline curve between points that are adjacent in the dataset
                            */
                           String /* straight |  smooth */ = definedExternally
    /**
     *  The "id" of the metric facet value that assigns a probability to each combination
     *   of facets and their values. Each probability must be a non-negative number.
     *   These probabilities are used by all methods of FacetChart that calculate statistical
     *   values (e.g. FacetChart.getMean and FacetChart.getStdDev). The default value of
     *   this property is null which causes the FacetChart to assign probabilities to the
     *   data records according to a uniform probability distribution.
     * 
     *   Note that the FacetChart handles cases where the sum total of all probabilities
     *   in the FacetChart.data is not exactly one by scaling the assigned probabilities.
     *  @type {string}
     *  @default null
     */
    open var probabilityMetric: String = definedExternally
    /**
     *  If set, the FacetChart.showExpectedValueLine,
     *   FacetChart.showStandardDeviationLines,
     *   FacetChart.bandedStandardDeviations,
     *   and FacetChart.showRegressionLine are drawn on top of the data rather
     *   than underneath.
     *  @type {boolean}
     *  @default false
     */
    open var showStatisticsOverData: Boolean = definedExternally
    /**
     *  Display a line at the FacetChart.getMean.
     * 
     *   Note that this expected value is computed using all of the data points, pooled across all
     *   facets. The computation relies only on the values of the main value axis metric and the
     *   FacetChart.probabilityMetric.
     * 
     *   See http://en.wikipedia.org/wiki/Expected_value.
     *  @type {boolean}
     *  @default false
     */
    open var showExpectedValueLine: Boolean = definedExternally
    /**
     *  Properties for the FacetChart.showExpectedValueLine.
     * 
     *   Note that for rectangular charts the properties are for a DrawLine,
     *   and for radar charts the properties are for a DrawOval.
     *  @type {DrawItem}
     *  @default null
     */
    open var expectedValueLineProperties: DrawItem = definedExternally
    /**
     *  Display multiple FacetChart.getStdDev away from the mean as lines.
     *   The exact deviations to display can be customized with FacetChart.standardDeviations.
     * 
     *   Note that these standard deviations are computed using all of the data points, pooled
     *   across all facets. The computation relies only on the values of the main value axis
     *   metric and the FacetChart.probabilityMetric.
     * 
     *   See http://en.wikipedia.org/wiki/Standard_deviation.
     *  @type {boolean}
     *  @default false
     */
    open var showStandardDeviationLines: Boolean = definedExternally
    /**
     *  Properties for the FacetChart.showStandardDeviationLines.
     * 
     *   Note that for rectangular charts the properties are for a DrawLine,
     *   and for radar charts the properties are for a DrawOval.
     *  @type {DrawItem}
     *  @default null
     */
    open var standardDeviationLineProperties: DrawItem = definedExternally
    /**
     *  Whether to display both the positive and negative of the
     *   FacetChart.standardDeviations.
     *  @type {boolean}
     *  @default true
     */
    open var useSymmetricStandardDeviations: Boolean = definedExternally
    /**
     *  When FacetChart.showStandardDeviationLines is set, the number of standard deviation lines drawn
     *   and their respective standard deviation away from the mean are specified by this property.
     *   The default is to display lines corresponding to the mean plus or minus one standard
     *   deviation.
     * 
     *   Note that having zero in this list of standard deviations is identical to drawing
     *   a line at the mean.
     * 
     *   For example assume that chart1 and chart2 both plot data with mean 1 and standard deviation 0.1.
     *   chart1 will draw a blue line at the value 1 and two red lines at the values 0.7 and 1.2.
     *   chart2 will draw three red lines at values 0.9, 1.0, and 1.1.
     * 
     * 
     * 
     *   isc.FacetChart.create({
     *     ID: "chart1",
     *     standardDeviations: [-3, 2],
     *     showExpectedValueLine: true,
     *     showStandardDeviationLines: true,
     *     expectedValueLineProperties: { lineColor: "blue" },
     *     standardDeviationLineProperties: { lineColor: "red" },
     *     // ...
     *   });
     * 
     *   isc.FacetChart.create({
     *     ID: "chart2",
     *     standardDeviations: [-1, 0, 1],
     *     showExpectedValueLine: false,
     *     showStandardDeviationLines: true,
     *     expectedValueLineProperties: { lineColor: "blue" },
     *     standardDeviationLineProperties: { lineColor: "red" },
     *     // ...
     *   });
     * 
     * 
     * 
     *  @type {Array<Partial<Float>>}
     *  @default "[-1, 1]"
     */
    open var standardDeviations: Array<dynamic> = definedExternally
    /**
     *  Whether to show color bands between the FacetChart.standardDeviations
     *   lines.
     * 
     *   Standard deviation bands are not available for pie or radar charts.
     *  @type {boolean}
     *  @default false
     */
    open var bandedStandardDeviations: Boolean = definedExternally
    /**
     *  An Array of DrawRect properties to specify the bands between the FacetChart.showStandardDeviationLines.
     *   The length of the Array must be one less than the length of the FacetChart.standardDeviations Array.
     * 
     *   Having no band between certain standard deviations from the mean can be specified by
     *   having a null element at the corresponding index of this Array.
     * 
     *   Note that if FacetChart.useSymmetricStandardDeviations is set then for each standard
     *   deviation band that is drawn a corresponding band will also be drawn on the opposite side of the mean line.
     *  @type {Array<Partial<DrawItem>>}
     *  @default null
     */
    open var standardDeviationBandProperties: Array<dynamic> = definedExternally
    /**
     *  For scatter plots only, whether to display a regression curve that best fits the data of
     *   the two metric facet values.
     * 
     *   The type of regression curve used depends on the RegressionLineType property,
     *   which can be:
     * 
     * 
     *  - "line" &ndash; to draw a linear regression curve, or
     * 
     *  - "polynomial" &ndash; to draw a polynomial regression curve (of degree
     *   FacetChart.regressionPolynomialDegree).
     *  -
     * 
     * 
     *   Note that the regression is computed using all of the data points and it does not depend
     *   on the values of any non-metric facets. For example, adding a legend facet will not
     *   change the regression curve.
     * 
     *   See http://en.wikipedia.org/wiki/Simple_linear_regression.
     *   See http://en.wikipedia.org/wiki/Polynomial_regression.
     *  @type {boolean}
     *  @default false
     */
    open var showRegressionLine: Boolean = definedExternally
    /**
     *  Properties for the FacetChart.showRegressionLine.
     *  @type {DrawLine}
     *  @default null
     */
    open var regressionLineProperties: DrawLine = definedExternally
    /**
     *  Regression algorithm used for the FacetChart.showRegressionLine.
     *  @type {RegressionLineType}
     *  @default "line"
     */
    open var regressionLineType: 
                                 /**
                                  *  linear regression
                                  *  polynomial regression
                                  */
                                 String /* line |  polynomial */ = definedExternally
    /**
     *  For scatter plots only, specify the degree of polynomial to use for any polynomial regression
     *   that is calculated.
     *  @type {number}
     *  @default "3"
     */
    open var regressionPolynomialDegree: Number = definedExternally
    /**
     *  For Line, Area, Radar, Scatter or Bubble charts, whether to show data points for each
     *   individual data value.
     * 
     *   If shown, the FacetChart.pointClick and FacetChart.getPointHoverHTML APIs can be used to create
     *   interactivity.
     *  @type {boolean}
     *  @default false
     */
    open var showDataPoints: Boolean = definedExternally
    /**
     *  Size in pixels for data points drawn for line, area, radar and other chart types.
     *  @type {Integer}
     *  @default "5"
     */
    open var dataPointSize: Number = definedExternally
    /**
     *  Common properties to apply for all data points (see FacetChart.showDataPoints).
     *  @type {DrawItem}
     *  @default null
     */
    open var dataPointProperties: DrawItem = definedExternally
    /**
     *  For charts where FacetChart.showDataPoints is enabled, this property specifies an array of
     *   geometric shapes to draw for the data points of each series.
     *  @type {Array<Partial<PointShape>>}
     *  @default "["Oval", "Square", "Diamond", "Triangle"]"
     */
    open var pointShapes: Array<dynamic> = definedExternally
    /**
     *  For charts where FacetChart.showDataPoints is enabled, this property specifies an additional
     *   metric (i.e. an "id" of a metric facet value) that determines the size of the data
     *   points drawn. For example, when a circle is drawn to represent a data point then
     *   the size of the data point is the diameter of the circle, in pixels.
     * 
     *   The size is calculated by linearly scaling the value of the
     *   pointSizeMetric of the point between the FacetChart.minDataPointSize and
     *   FacetChart.maxDataPointSize. The data point that has the lowest value for the
     *   pointSizeMetric will be drawn as a shape minDataPointSize
     *   pixels in size, and the data point that has the highest value for the
     *   pointSizeMetric will be drawn as a shape maxDataPointSize
     *   pixels in size.
     * 
     *   Using a log-scale to calulate the size of the data points is achieved by enabling
     *   FacetChart.logScalePointSize.
     * 
     *   If the ChartType is "Bubble" then the default
     *   pointSizeMetric is "pointSize".
     * 
     *   Note that setting pointSizeMetric to non-null implicitly
     *   enables FacetChart.showDataPoints.
     *  @type {string}
     *  @default null
     */
    open var pointSizeMetric: String = definedExternally
    /**
     *  The minimum allowed data point size when controlled by FacetChart.pointSizeMetric.
     *  @type {Float}
     *  @default "3"
     */
    open var minDataPointSize: Number = definedExternally
    /**
     *  The maximum allowed data point size when controlled by FacetChart.pointSizeMetric.
     *  @type {Float}
     *  @default "14"
     */
    open var maxDataPointSize: Number = definedExternally
    /**
     *  Whether to use logarithmic scaling for the FacetChart.pointSizeMetric.
     *   Defaults to the value of FacetChart.logScale.
     *  @type {boolean}
     *  @default false
     */
    open var logScalePointSize: Boolean = definedExternally
    /**
     *  When FacetChart.logScalePointSize is true, base value for logarithmic point size metric values.
     *  @type {Integer}
     *  @default "10"
     */
    open var pointSizeLogBase: Number = definedExternally
    /**
     *  Properties for the shapes displayed around the data points (for example, in a bubble
     *   chart).
     * 
     *   When either the FacetChart.pointSizeMetric or the
     *   FacetChart.colorScaleMetric is active the default
     *   bubbleProperties displays each data points with a linear gradient.
     *  @type {DrawItem}
     *  @default null
     */
    open var bubbleProperties: DrawItem = definedExternally
    /**
     *  Setting this flag to false prevents the chart from drawing fill gradients
     *   into the bubbles of each data point. This flag is required to be set for IE8 and
     *   earlier in order to draw bubble charts displaying high volumes of data.
     *  @type {boolean}
     *  @default "!(isc.Browser.isIE &amp;&amp; isc.Browser.version &lt;= 8)"
     */
    open var allowBubbleGradients: Boolean = definedExternally
    /**
     *  Whether the chart should use multiple shapes to show data points. If set to
     *   true then the chart is allowed to use all
     *   FacetChart.pointShapes: circles, squares, diamonds, and triangles. If
     *   set to false then just the first supported shape (circles, for example)
     *   will be used. The default is false for bubble charts and
     *   FacetChart.colorScaleMetric and true for all other chart
     *   types.
     *  @type {boolean}
     *  @default null
     */
    open var useMultiplePointShapes: Boolean = definedExternally
    /**
     *  Whether to show an additional legend to the right of the chart to indicate
     *   FacetChart.pointSizeMetric. The default is true for bubble charts and
     *   false for all other chart types.
     *  @type {boolean}
     *  @default null
     */
    open var showPointSizeLegend: Boolean = definedExternally
    /**
     *  When a FacetChart.showPointSizeLegend is shown, this property controls
     *   the number of gradations of the FacetChart.pointSizeMetric that the chart
     *   tries to display.
     * 
     *   Note that if FacetChart.usePointSizeLogGradations is set then the number of gradations is
     *   not given by this property but rather by the entries of FacetChart.pointSizeLogGradations.
     *  @type {Integer}
     *  @default "5"
     */
    open var pointSizeGradations: Number = definedExternally
    /**
     *  Whether to use classic logarithmic gradations, where each order of magnitude is shown
     *   as a gradation as well as a few intervening values, for the
     *   FacetChart.pointSizeMetric values displayed in the
     *   FacetChart.showPointSizeLegend. Gradations also begin and end on an
     *   order of magnitude. For example, 1, 2, 4, 6, 8, 10, 20, 40, 60, 80, 100.
     * 
     *   Default gradations can be overridden via FacetChart.pointSizeLogBase and
     *   FacetChart.pointSizeLogGradations.
     *  @type {boolean}
     *  @default false
     */
    open var usePointSizeLogGradations: Boolean = definedExternally
    /**
     *  When FacetChart.usePointSizeLogGradations is set, this property specifies the
     *   FacetChart.pointSizeMetric value gradations to show in the
     *   FacetChart.showPointSizeLegend in between powers, expressed as a series
     *   of integer or float values between 1 and FacetChart.pointSizeLogBase.
     *  @type {Array<Partial<Float>>}
     *  @default "[1, 5]"
     */
    open var pointSizeLogGradations: Array<dynamic> = definedExternally
    /**
     *  Whether to draw multiple bubble legends horizontally stacked to the right of the chart,
     *   one per shape type.
     * 
     *   Note that this setting has no effect if FacetChart.useMultiplePointShapes is disabled.
     *  @type {boolean}
     *  @default false
     */
    open var showBubbleLegendPerShape: Boolean = definedExternally
    /**
     *  Whether to draw data points in order of descending FacetChart.pointSizeMetric
     *   so that small values are less likely to be completely occluded by larger values. Set
     *   this to false to draw the data points in the same order that they appear
     *   in the data.
     *  @type {boolean}
     *  @default true
     */
    open var autoSortBubblePoints: Boolean = definedExternally
    /**
     *  For charts where FacetChart.showDataPoints is enabled, this property specifies an additional
     *   metric (i.e. an "id" of a metric facet value) that causes the data points to be
     *   colored from FacetChart.scaleStartColor to FacetChart.scaleEndColor based on a linear scale
     *   over the values of this metric. Log-scaling for color scale is also supported with
     *   FacetChart.logScalePointColor.
     *  @type {string}
     *  @default null
     */
    open var colorScaleMetric: String = definedExternally
    /**
     *  Whether to use logarithmic scaling for the FacetChart.colorScaleMetric of the
     *   data points. Defaults to the value of FacetChart.logScale.
     *  @type {boolean}
     *  @default false
     */
    open var logScalePointColor: Boolean = definedExternally
    /**
     *  When FacetChart.logScalePointColor is true, this property specifies the base
     *   value for logarithmic FacetChart.colorScaleMetric values.
     *  @type {Integer}
     *  @default "10"
     */
    open var pointColorLogBase: Number = definedExternally
    /**
     *  Whether to show an additional legend underneath the chart to indicate color values.
     *   The default is true if a valid FacetChart.colorScaleMetric is
     *   specified.
     *  @type {boolean}
     *  @default null
     */
    open var showColorScaleLegend: Boolean = definedExternally
    /**
     *  The starting color of the color scale when the data points are colored according to a
     *   FacetChart.colorScaleMetric. If neither this property nor the
     *   FacetChart.scaleEndColor is set then the whole color range is used by default.
     * 
     *   Note that using CSS color shortcuts (e.g. "lightblue") is not allowed for this property.
     *  @type {CSSColor}
     *  @default null
     */
    open var scaleStartColor: String = definedExternally
    /**
     *  The ending color of the color scale when the data points are colored according to a
     *   FacetChart.colorScaleMetric. If neither this property nor the
     *   FacetChart.scaleStartColor is set then the whole color range is used by
     *   default.
     * 
     *   Note that using CSS color shortcuts (e.g. "lightblue") is not allowed for this property.
     *  @type {CSSColor}
     *  @default null
     */
    open var scaleEndColor: String = definedExternally
    /**
     *  Whether to use logarithmic scaling for values.
     * 
     *   Logarithmic scale charts show an equivalent percentage increase as equivalent distance
     *   on the chart. That is, 10 and 100 are the same distance apart as 100 and 1000 (each
     *   being a 10 times or 1000% increase).
     *  @type {boolean}
     *  @default false
     */
    open var logScale: Boolean = definedExternally
    /**
     *  Whether to use classic logarithmic gradations, where each order of magnitude is shown as
     *   a gradation as well as a few intervening lines.  Gradations also begin and end on an order
     *   of magnitude. For example, 1,2,4,6,8,10,20,40,60,80,100.
     * 
     *   Default gradations can be overridden via FacetChart.logBase and FacetChart.logGradations.
     *  @type {boolean}
     *  @default false
     */
    open var useLogGradations: Boolean = definedExternally
    /**
     *  When FacetChart.useLogGradations, base value for logarithmic gradation lines. Gradation
     *   lines will be shown at every power of this value plus intervening values specified by
     *   FacetChart.logGradations.
     *  @type {Integer}
     *  @default "10"
     */
    open var logBase: Number = definedExternally
    /**
     *  When FacetChart.useLogGradations is set, gradation lines to show in between powers,
     *   expressed as a series of integer or float values between 1 and FacetChart.logBase.
     * 
     *   Some common possibilities (for base 10):
     * 
     *    [ 1 ] // show only orders of magnitude (0.1, 1, 10, 100, etc)
     *    [ 1, 5 ] // show only orders of magnitude plus halfway mark
     *    [ 1, 2, 4, 8 ] // show powers of 2 between orders
     *    [ 1, 2.5, 5, 7.5 ] // show quarters
     * 
     *   Or base 2:
     * 
     *    [ 1 ]
     *    [ 1, 1.5 ]
     * 
     *  @type {Array<Partial<Float>>}
     *  @default "[ 1,2,4,6,8 ]"
     */
    open var logGradations: Array<dynamic> = definedExternally
    /**
     *  Whether to show a rectangular shape around the area of the chart where data is plotted.
     *  @type {boolean}
     *  @default false
     */
    open var showChartRect: Boolean = definedExternally
    /**
     *  Properties for chart rect. By default, DrawRect.rounding of the chart
     *   rect. causes the gradation lines to be automatically inset from the edge so that they
     *   do not run right along the curve. Set FacetChart.padChartRectByCornerRadius to
     *   false to change this default.
     *  @type {DrawRect}
     *  @default null
     */
    open var chartRectProperties: DrawRect = definedExternally
    /**
     *  If FacetChart.showChartRect is enabled and if FacetChart.chartRectProperties specifies a
     *   nonzero DrawRect.rounding, whether the padding around the inside of the
     *   chart rect. should include at least the radius of the rounded corner.
     *  @type {boolean}
     *  @default true
     */
    open var padChartRectByCornerRadius: Boolean = definedExternally
    /**
     *  Margin around the main chart rect: between title and chart, between chart and axis
     *   labels, and chart rect and right edge of chart.
     *  @type {Integer}
     *  @default "5"
     */
    open var chartRectMargin: Number = definedExternally
    /**
     *  For rectangular charts (bar, column, line), margin around the inside of the
     *   main chart area, so that data elements are not flush to edge.
     *  @type {Integer}
     *  @default "10"
     */
    open var dataMargin: Number = definedExternally
    /**
     *  This property controls whether to rotate the labels on the X-axis. If rotateLabels is
     *   "always" then all of the data labels will be rotated by 90 degrees. If rotateLabels is
     *   "auto" (the default) then the labels will only be rotated if it is required in order for
     *   the labels to be legible and non-overlapping. If rotateLabels is "never" then the
     *   labels will not be rotated.
     * 
     *   Note that automatic rotation is incompatible with setting
     * 
     *   FacetChart.getMinClusterSize, so that "auto" will be treated as "never"
     * 
     *   if that method has been specified on a column, bar, or histogram chart.
     *  @type {LabelRotationMode}
     *  @default "auto"
     */
    open var rotateLabels: 
                           /**
                            *  do not rotate labels
                            *  rotate labels if needed in order to make them legible and non-overlapping
                            *  always rotate labels
                            */
                           String /* never |  auto |  always */ = definedExternally
    /**
     *  This property controls whether to rotate the labels on the
     *   FacetChart.getDataLabelFacet of radar or FacetChart.stacked pie charts so that
     *   each label is parallel to its radial gradation (these are the labels that appear around
     *   the perimeter). For now, "auto" means the same thing as "always" - but this may change
     *   in the future if heuristics are added to determine when the affected labels are likely to
     *   overlap and not be legible. If rotateLabels is "never" then the labels will not be
     *   rotated.
     * 
     *  @type {LabelRotationMode}
     *  @default "auto"
     */
    open var radarRotateLabels: 
                                /**
                                 *  do not rotate labels
                                 *  rotate labels if needed in order to make them legible and non-overlapping
                                 *  always rotate labels
                                 */
                                String /* never |  auto |  always */ = definedExternally
    /**
     *  Whether to automatically rotate labels if needed in order to make them legible and
     *   non-overlapping.
     *  @deprecated \* As of SmartClient 9.0 this property is replaced by the property FacetChart.rotateLabels. Setting rotateLabels to "auto" is equivalent to setting
     *   autoRotateLabels to true. Setting rotateLabels to "never" is equivalent
     *   to setting autoRotateLabels to false.
     *  @type {boolean}
     *  @default true
     */
    open var autoRotateLabels: Boolean = definedExternally
    /**
     *  What to do when there are too many data points to be able to show labels for every data point
     *   at the current chart size - see LabelCollapseMode.
     * 
     *   Each of the possible strategies is re-applied when the user resizes the chart as a whole, so if
     *   labels are omitted the user can make them visible via resize or zoom.
     * 
     *   If the labelCollapseMode is "numeric" then vertical lines will be drawn at gradation
     *   values automatically chosen by the chart.
     * 
     *   If the labelCollapseMode is "time" then vertical lines are drawn to represent a
     *   sequence of significant datetime values on the x-axis, such as the first day of the
     *   month or week. The chart automatically chooses the sequence of Dates such that the
     *   spacing between them expresses the smallest granularity of time possible while still
     *   allowing the axis labels to make good use of the space. If, for example, the Date
     *   values in the data span a few years in time then the chart may select January 1 of the
     *   same year of the earliest data point and every January 1 thereafter (in range of the
     *   data) as the sequence of Dates and label each Date by the four-digit year. If the time
     *   span of the data values is on the order of minutes then the chart may select multiples
     *   of 15 minutes as the seqeunce of Dates. FacetChart currently supports the following
     *   granularities of time: years, quarters, months, weeks, days, hours, half-hours,
     *   quarter-hours, 5 minutes, minutes, 30 seconds, and 15 seconds.
     * 
     *   The format of the Date labels is fixed by FacetChart. In particular,
     *   FacetChart.formatAxisValue
     *   will not be called on values for the x-axis. However, FacetChart uses
     *   DateUtil.shortMonthNames
     * 
     *   for the time granularities of quarters, months, and weeks, uses the
     *   Time.setShortDisplayFormat
     * 
     *   to format labels for time granularities from minutes to hours, and uses the
     *   Time.setNormalDisplayFormat
     * 
     *   to format labels for the time granularities of 15 seconds and 30 seconds. The label
     *   format can be customized by changing these three formatters. Also note that for the time
     *   granularity of weeks the sequence of Dates will be the first day of each week, as
     *   specified by DateUtil.setFirstDayOfWeek.
     *   Note that if the labelCollapseMode is "time" or "numeric" then the FacetChart.data must
     *   be initially sorted with the FacetChart.getDataLabelFacet's values in
     *   ascending order.
     *  @type {LabelCollapseMode}
     *  @default null
     */
    open var labelCollapseMode: 
                                /**
                                 *  Show all labels regardless, even though they will overlap
                                 *  Show significant time values such as the first day of the month or week. Data values in Records must be true Date objects, not Strings.
                                 *  Pick round numbers in the range and show labels for just those numbers. Best for continuous datasets that are not time-based
                                 *  Pick periodic values from the dataset and show labels for those. Best when the there are no particular points that would clearly be the best to label
                                 */
                                String /* none |  time |  numeric |  sample */ = definedExternally
    /**
     *  Minimum gap between labels on the X axis before some labels are omitted or larger time
     *   granularity is shown (eg show days instead of hours) based on the
     *   FacetChart.labelCollapseMode.
     * 
     *   Default is based on label orientation. If labels are vertical, the minimum gap is the height
     *   of half a line of text. If horizontal it's the width of 4 "X" letters.
     *  @type {Integer}
     *  @default null
     */
    open var minLabelGap: Number = definedExternally
    /**
     *  Properties for data label
     *  @type {DrawLabel}
     *  @default null
     */
    open var dataLabelProperties: DrawLabel = definedExternally
    /**
     *  If set to false, data labels for values are entirely omitted.
     * 
     *   This property would generally only be set to false if several small charts
     *   are shown together and the data labels are drawn elsewhere on the screen (above an
     *   entire stack of charts, for instance) or are otherwise implicit.
     *  @type {boolean}
     *  @default true
     */
    open var showDataLabels: Boolean = definedExternally
    /**
     *  Default precision used when formatting float numbers for axis labels
     *  @type {Integer}
     *  @default "2"
     */
    open var decimalPrecision: Number = definedExternally
    /**
     *  Enables "zooming" on the X axis, specifically, only a portion of the overall dataset is shown
     *   in the main chart, and a FacetChart.zoomChart appears with slider controls
     *   allowing a range to be selected for display in the main chart.
     * 
     *   A FacetChart.labelCollapseMode is automatically enabled if
     *   unset and is based on the type of the first non-null data value.
     *  @type {boolean}
     *  @default null
     */
    open var canZoom: Boolean = definedExternally
    /**
     *  Mini-chart created to allow zooming when FacetChart.canZoom is enabled.
     * 
     *   This chart automatically has certain visual tweaks applied, including FacetChart.showInlineLabels,
     *   FacetChart.zoomMutePercent and FacetChart.zoomLogScale. It can be
     *   further configured via FacetChart.zoomChartProperties.
     * 
     *   The selected range from this chart defaults to being shown with distinct styling as well (if
     *   FacetChart.zoomShowSelection is set), which can be controlled via
     *   FacetChart.zoomSelectionChartProperties.
     *  @type {FacetChart}
     *  @default null
     */
    open var zoomChart: FacetChart = definedExternally
    /**
     *  Properties to further configure the FacetChart.zoomChart.
     *  @type {FacetChart}
     *  @default null
     */
    open var zoomChartProperties: FacetChart = definedExternally
    /**
     *  Mini-chart created when FacetChart.canZoom is enabled. This chart represents the currently
     *   selected range of data shown in the main chart.
     *  @type {FacetChart}
     *  @default null
     */
    open var zoomSelectionChart: FacetChart = definedExternally
    /**
     *  Properties to further configure the FacetChart.zoomSelectionChart.
     *  @type {FacetChart}
     *  @default null
     */
    open var zoomSelectionChartProperties: FacetChart = definedExternally
    /**
     *  Whether the selected range should be shown in a different style, which can be configured via
     *   FacetChart.zoomSelectionChartProperties. This has performance consequences and makes the rendering
     *   of the mini-chart slightly slower.
     *  @type {boolean}
     *  @default true
     */
    open var zoomShowSelection: Boolean = definedExternally
    /**
     *  Slider controls shown on the mini-chart which is created when FacetChart.canZoom is enabled.
     *  @type {RangeSlider}
     *  @default null
     */
    open var zoomChartSlider: RangeSlider = definedExternally
    /**
     *  Height of the FacetChart.zoomChart. The zoomChart is always as wide as the main chart.
     *  @type {Float}
     *  @default "100"
     */
    open var zoomChartHeight: Number = definedExternally
    /**
     *  By default when FacetChart.canZoom is enabled, the FacetChart.zoomChart uses logarithmic scaling so
     *   that spikes in the data don't result in a zoomed chart that is mostly a flat line.
     * 
     *   Logarithmic scaling is automatically disabled if the dataset spans zero (eg, has negative and
     *   positive values) as this can't be shown in a logarithmic scale.
     * 
     *   Set zoomLogScale to explicitly enable or disable logarithmic scaling.
     *  @type {boolean}
     *  @default null
     */
    open var zoomLogScale: Boolean = definedExternally
    /**
     *  Should be set to a number between -100 and 100. If set, all colors in the chart are "muted" by
     *   this percentage by shifting them toward white (or for negative numbers, toward black).
     *  @type {Float}
     *  @default null
     */
    open var colorMutePercent: Number = definedExternally
    /**
     *  FacetChart.colorMutePercent to use for the FacetChart.zoomChart.
     *  @type {Float}
     *  @default "-35"
     */
    open var zoomMutePercent: Number = definedExternally
    /**
     *  For a FacetChart.canZoom, determines what portion of the overall dataset should be
     *   initially shown in the main chart.
     * 
     *   Default is to show the end of the dataset if the X axis shows time and includes today's date,
     *   otherwise to show the start of the dataset.
     * 
     *   Set this property to override this default, or use FacetChart.zoomStartValue and
     *   FacetChart.zoomEndValue to start with a particular range.
     *  @type {ZoomStartPosition}
     *  @default null
     */
    open var zoomStartPosition: 
                                /**
                                 *  start at the beginning of the range
                                 *  start at the end of the range
                                 */
                                String /* start |  end */ = definedExternally
    /**
     *  For a FacetChart.canZoom, start value of the data range shown in the main
     *   chart. If FacetChart.zoomEndValue is not also set on initialization (or if
     *   FacetChart.setZoomEndValue is called after initialization) then the
     *   range shown will be from zoomStartValue to the end of the dataset.
     * 
     *   The value provided should be a value in the range of the facet for the X axis, for example, for
     *   a time-based axis, a Date instance, for a numeric axis, a Number, for an axis that just has
     *   text labels (such as city names), a String.
     *  @type {any}
     *  @default null
     */
    open var zoomStartValue: dynamic = definedExternally
    /**
     *  For a FacetChart.canZoom, end value of the data range shown in the main chart.
     *   If FacetChart.zoomStartValue is not also set on intialization (or if
     *   FacetChart.setZoomStartValue is called after initialization) then
     *   the range shown will be from the beginning of the dataset up to
     *   zoomEndValue.
     * 
     *   The value provided should be a value in the range of the facet for the X axis, for example, for
     *   a time-based axis, a Date instance, for a numeric axis, a Number, for an axis that just has
     *   text labels (such as city names), a String.
     *  @type {any}
     *  @default null
     */
    open var zoomEndValue: dynamic = definedExternally
    /**
     *  Should the FacetChart.canZoom be printed with this FacetChart?
     *   If true, then the SVG string returned by DrawPane.getSvgString will
     *   include the zoom chart's SVG as well.
     *  @type {boolean}
     *  @default true
     */
    open var printZoomChart: Boolean = definedExternally
    /**
     *  Causes labels for the X axis to be shown above the axis and to the right of the gradation line
     *   they label, making for a vertically more compact chart at the risk of gradation labels being
     *   partially obscured by data values. Also causes the last label to be skipped (no where to place
     *   it).
     *  @type {boolean}
     *  @default false
     */
    open var showInlineLabels: Boolean = definedExternally
    /**
     *  If set, gradation lines are drawn on top of data rather than underneath.
     *  @type {boolean}
     *  @default false
     */
    open var showGradationsOverData: Boolean = definedExternally
    /**
     *  The legend is automatically shown for charts that need it (generally, multi-series
     *   charts) but can be forced off by setting showLegend to false.
     *  @type {boolean}
     *  @default null
     */
    open var showLegend: Boolean = definedExternally
    /**
     *  Space between the legend and the chart rect or axis labels (whatever the legend is
     *   adjacent to.
     *  @type {Integer}
     *  @default "10"
     */
    open var legendMargin: Number = definedExternally
    /**
     *  Padding around the legend as a whole.
     *  @type {Integer}
     *  @default "5"
     */
    open var legendPadding: Number = definedExternally
    /**
     *  If drawing a border around the legend, the height of the drawn Rectangle.
     *  @type {Integer}
     *  @default "5"
     */
    open var legendRectHeight: Number = definedExternally
    /**
     *  Size of individual color swatches in legend.
     *  @type {Integer}
     *  @default "16"
     */
    open var legendSwatchSize: Number = definedExternally
    /**
     *  Properties for the swatches of color shown in the legend.
     *  @type {DrawRect}
     *  @default null
     */
    open var legendSwatchProperties: DrawRect = definedExternally
    /**
     *  Padding between color swatch and its label.
     *  @type {Integer}
     *  @default "5"
     */
    open var legendTextPadding: Number = definedExternally
    /**
     *  Padding between each swatch and label pair.
     *  @type {Integer}
     *  @default "5"
     */
    open var legendItemPadding: Number = definedExternally
    /**
     *  Properties for rectangle around the legend as a whole.
     *  @type {DrawRect}
     *  @default null
     */
    open var legendRectProperties: DrawRect = definedExternally
    /**
     *  Properties for top boundary of the legend are, when there is already an outer
     *   container around the whole chart. see FacetChart.drawLegendBoundary
     *  @type {DrawLine}
     *  @default null
     */
    open var legendBoundaryProperties: DrawLine = definedExternally
    /**
     *  Properties for labels shown next to legend color swatches.
     *  @type {DrawLabel}
     *  @default null
     */
    open var legendLabelProperties: DrawLabel = definedExternally
    /**
     *  Whether a boundary should be drawn above the Legend area for circumstances where the
     *   chart area already has an outer border. If the chart has no outer border, then the
     *   FacetChart.legendRectProperties settings should be used instead.
     *  @type {boolean}
     *  @default null
     */
    open var drawLegendBoundary: Boolean = definedExternally
    /**
     *  Whether to automatically show shadows for various charts.
     *  @type {boolean}
     *  @default true
     */
    open var showShadows: Boolean = definedExternally
    /**
     *  Properties for shadows.
     *  @type {DrawOval}
     *  @default null
     */
    open var shadowProperties: DrawOval = definedExternally
    /**
     *  Distance between bars. May be reduced if bars would be smaller than
     *   FacetChart.minBarThickness.
     *  @type {Integer}
     *  @default "4"
     */
    open var barMargin: Number = definedExternally
    /**
     *  If bars would be smaller than this size, margins are reduced until bars overlap.
     *  @type {Integer}
     *  @default "4"
     */
    open var minBarThickness: Number = definedExternally
    /**
     *  Bars will not be drawn over this thickness, instead, margins will be increased.
     *  @type {Integer}
     *  @default "150"
     */
    open var maxBarThickness: Number = definedExternally
    /**
     *  For clustered charts, ratio between margins between individual bars and margins between
     *   clusters.
     *  @type {Float}
     *  @default "4"
     */
    open var clusterMarginRatio: Number = definedExternally
    /**
     *  Properties for bar
     *  @type {DrawRect}
     *  @default null
     */
    open var barProperties: DrawRect = definedExternally
    /**
     *  Properties for lines that show data (as opposed to gradations or borders around the data
     *   area).
     *  @type {DrawLine}
     *  @default null
     */
    open var dataLineProperties: DrawLine = definedExternally
    /**
     *  Properties for lines that outline a data shape (in filled charts such as area or radar
     *   charts).
     *  @type {DrawItem}
     *  @default null
     */
    open var dataOutlineProperties: DrawItem = definedExternally
    /**
     *  Properties for data shapes (filled areas in area or radar charts).
     *  @type {DrawPath}
     *  @default null
     */
    open var dataShapeProperties: DrawPath = definedExternally
    /**
     *  Properties for a "value line" - a line shows where a particular discrete value is
     *   placed, eg, vertical lines connecting points of a line chart to the X axis, or radial
     *   lines in a Radar chart.
     *  @type {DrawLine}
     *  @default null
     */
    open var valueLineProperties: DrawLine = definedExternally
    /**
     *  Whether to treat non-numeric values in the dataset as indicating a break in the data
     *   line. If set to false then null values are ignored. Defaults to
     *   true for FacetChart.filled charts and to false
     *   for line charts.
     *  @type {boolean}
     *  @default null
     */
    open var discontinuousLines: Boolean = definedExternally
    /**
     *  Properties for radar background
     *  @type {DrawOval}
     *  @default null
     */
    open var radarBackgroundProperties: DrawOval = definedExternally
    /**
     *  Distance in pixels that radial labels are offset from the outside of the circle.
     *   Default can vary depending upon ChartType and FacetChart.radarRotateLabels.
     *  @type {Integer}
     *  @default null
     */
    open var radialLabelOffset: Number = definedExternally
    /**
     *  Default angle in degrees where pie charts start drawing sectors to represent data values.
     *   Default of 0 places the first value starting from the "east" position.
     *   Use 270 or -90 for north.
     *  @type {Integer}
     *  @default "0"
     */
    open var pieStartAngle: Number = definedExternally
    /**
     *  Properties for pie slices
     *  @type {DrawSector}
     *  @default null
     */
    open var pieSliceProperties: DrawSector = definedExternally
    /**
     *  Properties for the border around a pie chart.
     *  @type {DrawOval}
     *  @default null
     */
    open var pieBorderProperties: DrawOval = definedExternally
    /**
     *  Properties for pie ring border
     *  @type {DrawOval}
     *  @default null
     */
    open var pieRingBorderProperties: DrawOval = definedExternally
    /**
     *  Whether to show a "doughnut hole" in the middle of pie charts. Defaults to whether
     *   chartType is set to "Doughnut" (shown) vs "Pie" (not shown) but can be forced on or off
     *   via showDoughnut.
     *  @type {boolean}
     *  @default null
     */
    open var showDoughnut: Boolean = definedExternally
    /**
     *  If showing a doughnut hole (see FacetChart.showDoughnut), ratio of the size of the doughnut
     *   hole to the size of the overall pie chart, as a number between 0 to 1.
     *  @type {Float}
     *  @default "0.2"
     */
    open var doughnutRatio: Number = definedExternally
    /**
     *  Properties for doughnut hole
     *  @type {DrawOval}
     *  @default null
     */
    open var doughnutHoleProperties: DrawOval = definedExternally
    /**
     *  Properties for pie label line
     *  @type {DrawLine}
     *  @default null
     */
    open var pieLabelLineProperties: DrawLine = definedExternally
    /**
     *  Angle where first label is placed in a Pie chart in stacked mode, in degrees.
     *  @type {Integer}
     *  @default "20"
     */
    open var pieLabelAngleStart: Number = definedExternally
    /**
     *  How far label lines stick out of the pie radius in a Pie chart in stacked mode.
     *  @type {Integer}
     *  @default "7"
     */
    open var pieLabelLineExtent: Number = definedExternally
    /**
     *  Specifies the attribute in the metric facet that will define the end point of segments in
     *   a histogram chart. The start point is set via the FacetChart.valueProperty.
     *  @type {string}
     *  @default null
     */
    open var endValueMetric: String = definedExternally
    /**
     *  Specifies the attribute in the metric facet that will define the z-ordering of the
     *   segments in a histogram chart. If the z-ordering isn't specified, it will be assigned
     *   based on data order, with the last data point ordered above the first. Relative
     *   z-ordering is only important between segments within the same data label facet, since
     *   segments that differ in their data label facet value should never overlap,
     * 
     *   Note that zIndex values should be integers between 0 and FacetChart.maxDataZIndex, inclusive,
     *   and don't directly map to the DrawItem.zIndex values of the underlying
     *   DrawRects. This allows the Framework to use automatic z-ordering in the chart
     *   logic without any additional sorting or overhead that would otherwise be required.
     *  @type {string}
     *  @default null
     */
    open var zIndexMetric: String = definedExternally
    /**
     *  Maximum allowed zIndex that can be specified through FacetChart.zIndexMetric in a histogram
     *   chart. Any zIndex values exceeding this property will be internally clipped so as to not
     *   exceed it. While this property can be increased, note that very large values may hit
     *   limitations related to the browser's implementation of the current
     *   DrawPane.drawingType.
     *  @type {Integer}
     *  @default "10000"
     */
    open var maxDataZIndex: Number = definedExternally
    /**
     *  lowErrorMetric and FacetChart.highErrorMetric can be used to cause error
     *   bars to appear above and below the main data point.
     * 
     *   lowErrorMetric and highErrorMetric provide the name of an
     *   additional attributes that appears in each Record holding the low error value and high
     *   error value respectively.
     * 
     *   Error bars are supported for single-axis charts only.
     *  @type {string}
     *  @default null
     */
    open var lowErrorMetric: String = definedExternally
    /**
     *  See FacetChart.lowErrorMetric.
     *  @type {string}
     *  @default null
     */
    open var highErrorMetric: String = definedExternally
    /**
     *  Width of the horizontal line of the "T"-shape portion of the error bar).
     *  @type {Integer}
     *  @default "6"
     */
    open var errorBarWidth: Number = definedExternally
    /**
     *  Properties of the lines used to draw error bars (short, horizontal lines at the low
     *   and high metric values, and a vertical connecting line).
     * 
     *   Note that the DrawItem.lineColor property has no effect as the color
     *   of the error bars is derived from the color of the data line.
     *  @type {DrawLine}
     *  @default null
     */
    open var errorLineProperties: DrawLine = definedExternally
    /**
     *  This property helps specify the color of the error bars and its value must be a
     *   number between -100 and 100. Error bars have the same color as the data line, but the
     *   colors are actually "muted" by this percentage by shifting them toward white (or for
     *   negative numbers, toward black). The default is to darken the data colors by 60%
     *   to get the error bar colors.
     *  @type {Float}
     *  @default "-60"
     */
    open var errorBarColorMutePercent: Number = definedExternally
    /**
     *  Shows the value of the nearest data value in a floating label whenever the mouse moves
     *   within the main chart area. The visual element representing the data
     *   value will also be emphasized by brightening or highlighting it (appearance differs by
     *   chart type).
     * 
     *   Calculates nearest value based on FacetChart.getNearestDrawnValue.
     * 
     *   The data value will be formatted using FacetChart.formatDataValue.
     *   The label's appearance is controlled by FacetChart.hoverLabelProperties.
     *  @type {boolean}
     *  @default null
     */
    open var showValueOnHover: Boolean = definedExternally
    /**
     *  Properties for text in a floating label that represents the data value shown whenever
     *   the mouse moves withing the main chart area when FacetChart.showValueOnHover is enabled.
     *  @type {DrawLabel}
     *  @default null
     */
    open var hoverLabelProperties: DrawLabel = definedExternally
    /**
     *  An extra amount of padding to show around the FacetChart.hoverLabelProperties
     *   when FacetChart.showValueOnHover is enabled.
     *  @type {Integer}
     *  @default "4"
     */
    open var hoverLabelPadding: Number = definedExternally
    /**
     *  Properties for rectangle that draws behind of a floating hover label that represents
     *   the data value. See FacetChart.showValueOnHover for more details.
     *  @type {DrawRect}
     *  @default null
     */
    open var hoverRectProperties: DrawRect = definedExternally
    /**
     *  Should data values be shown as text labels near the shape representing the value, for example,
     *   above columns of a column chart, or adjacent to points in a line chart?
     * 
     *   If set to false, then data values will not be shown.
     * 
     *   If set to true, data values will be shown unless the data density is high enough that
     *   labels will potentially overlap, in which case, data values will not be shown and
     *   hovers will be shown instead, in the same way as FacetChart.showValueOnHover shows hovers.
     *  @type {boolean}
     *  @default false
     */
    open var showDataValues: Boolean = definedExternally
    /**
     *  Maximum distance from the \*outer radius\* of the nearest bubble when hover will be shown.
     *  @type {number}
     *  @default "50"
     */
    open var bubbleHoverMaxDistance: Number = definedExternally
    /**
     *  Margin between FacetChart.extraAxisMetrics.
     *  @type {number}
     *  @default "10"
     */
    open var valueAxisMargin: Number = definedExternally
    /**
     *  When set, ticks are shown for the Y (vertical) axis if it's a value axis.
     * 
     *   Normally, ticks are not shown for the primary axis, since
     *   FacetChart.getGradations show value demarcations. Gradation
     *   lines are always show for FacetChart.extraAxisMetrics in multi-axis charts
     *   (since there are no gradation lines for the additional axes).
     * 
     *   FacetChart.showXTicks can be used to control whether ticks are shown for the horizontal axis,
     *   for certain chart types. See also FacetChart.majorTickGradations for control of which ticks
     *   are shown as major vs minor ticks.
     *  @type {boolean}
     *  @default false
     */
    open var showYTicks: Boolean = definedExternally
    /**
     *  When set, ticks are shown for the X (horizontal) axis for Scatter plots or Bar charts.
     *  @type {boolean}
     *  @default false
     */
    open var showXTicks: Boolean = definedExternally
    /**
     *  Length of the tick marks used when either FacetChart.showXTicks or
     *   FacetChart.showYTicks is enabled, or when FacetChart.extraAxisMetrics
     *   are in use.
     * 
     *   If minor tick marks are also shown, their length is controlled by FacetChart.minorTickLength.
     *  @type {Integer}
     *  @default "5"
     */
    open var tickLength: Number = definedExternally
    /**
     *  Length of minor ticks marks shown along axis, if FacetChart.showMinorTicks
     *   are enabled.
     *  @type {Integer}
     *  @default "2"
     */
    open var minorTickLength: Number = definedExternally
    /**
     *  @deprecated \* use FacetChart.tickLength instead
     *  @type {number}
     *  @default null
     */
    open var gradationTickMarkLength: Number = definedExternally
    /**
     *  Margin between the tick marks and the labels of the
     *   FacetChart.extraAxisMetrics.
     *  @type {number}
     *  @default "7"
     */
    open var tickMarkToValueAxisMargin: Number = definedExternally
    /**
     *  If FacetChart.showYTicks are being shown, controls whether a distinction is made
     *   between major and minor tick marks.
     * 
     *   If minor ticks are used, by default, major ticks are used for powers of 10 and minor
     *   ticks are used for other gradations. See FacetChart.majorTickGradations for control over
     *   which ticks are rendered as major vs minor ticks.
     *  @type {boolean}
     *  @default true
     */
    open var showMinorTicks: Boolean = definedExternally
    /**
     *  List of tick marks that should be drawn as major ticks, expressed as a series of numbers
     *   between 1 and 10, representing boundaries within a given order of magnitude (power of
     *   10). These numbers must be multiples of FacetChart.gradationGaps, or no ticks will end up as
     *   minor ticks.
     * 
     *   The default setting of [1] means that major ticks are used for powers of 10 only. A
     *   setting of [1,5] would mean that major ticks are also used at half-orders of magnitude,
     *   such as 0.5 or 50. For example, if used with a FacetChart.gradationGaps setting of [1,2.5]
     *   for a chart showing values between 0 and 1, this would result in major ticks at 0, 1 and
     *   0.5, and minor ticks at 0.25 and 0.75.
     * 
     *   See also FacetChart.majorTickTimeIntervals for controlling major vs minor ticks for the
     *   X-axis of time/date-valued Scatter plots.
     *  @type {Array<Partial<Float>>}
     *  @default "[1]"
     */
    open var majorTickGradations: Array<dynamic> = definedExternally
    /**
     *  When ticks are being FacetChart.showXTicks for a Scatter plot where the
     *   X axis uses time/date values, controls the intervals which are shown as major ticks.
     * 
     *   The intervals are specified as Strings, in the same way as
     *   FacetChart.otherAxisGradationTimes.
     * 
     *   For any given interval, the first major tick is shown for the next greatest time unit.
     *   For example, for interval such as "2h" (2 hours), the first major tick starts on the day
     *   boundary (whether that day boundary is visible in the chart or not).
     * 
     *   By default, all ticks are shown as major ticks.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var majorTickTimeIntervals: Array<dynamic> = definedExternally
    /**
     *  Whether the positions of value axes can be changed. The default is true
     *   for charts with three or more vertical, value axes.
     *  @type {boolean}
     *  @default null
     */
    open var canMoveAxes: Boolean = definedExternally
    /**
     *  Defines the set of metrics that will be plotted as additional vertical axes. See the
     *   main FacetChart docs for an overview of how multi-axis charts are used.
     * 
     *   Each metric corresponds to different value property
     *   of the data records and superimposes its drawn data onto the chart rectangle.
     *   The value properties are called metrics, and they can be either the FacetChart.valueProperty
     *   or the "id" of a FacetValue of the inlined Facet (which is then called the
     *   metric facet). Each value axis has its own gradations that are shown as tick marks
     *   along the length of the axis. This property, extraAxisMetrics, specifies the metrics
     *   to use for additional value axes to the main value axis.
     * 
     *   The additional value axis may have their own gradations, chart type, log scale, data colors
     *   and gradients, and other chart properties. These properties are specified with
     *   the FacetChart.extraAxisSettings property.
     * 
     *   Value axes, including the main value axis, are labelled in the legend along with
     *   representations of the charted data. The labels are taken from the FacetValue.title of
     *   each metric's FacetValue (or the FacetChart.valueTitle if the metric is the FacetChart.valueProperty).
     * 
     *   The order of the metrics determines the position of the corresponding axes on
     *   the chart as well as the z-ordering of the corresponding data lines.
     *   The first and second extra value axes are placed to the right of the chart rectangle,
     *   and any remaining extra value axes are placed to the left of the main value axis
     *   (and therefore to the left of the chart rectangle).
     *  @type {Array<Partial<string>>}
     *  @default "[]"
     */
    open var extraAxisMetrics: Array<dynamic> = definedExternally
    /**
     *  For charts will multiple vertical axes, optionally provides settings for how each
     *   FacetChart.extraAxisMetrics is plotted. See the main FacetChart
     *   docs for an overview of how multi-axis charts are used.
     * 
     *   The chart of each metric's values may be of any rectangular chart type that uses a
     *   vertical value axis ("Column", "Area", or "Line" - "Histogram" is not supported).
     *   Because the charts will be superimposed over the same drawing area, there can only
     *   be one "Column" chart and one "Area" chart. The column chart is placed on the bottom
     *   followed by the area chart, and then the line charts are drawn on top in the
     *   order of their metric in the FacetChart.extraAxisMetrics array.
     *   If the MetricSettings.chartTypes
     *   are left unspecified then by default the first metric will be drawn as
     *   columns and the remaining will be drawn as lines.
     *  @type {Array<Partial<MetricSettings>>}
     *  @default "[]"
     */
    open var extraAxisSettings: Array<dynamic> = definedExternally
    /**
     *  For a column, histogram, line, or area chart that has FacetChart.getDataLabelFacet, should the chart be expanded automatically
     *   horizontally, showing a scroll bar, if that's needed to make room for the facet value labels
     *   or, for column and histogram charts, to make space for the FacetChart.getMinClusterSize or the margins between them.
     * 
     *   Note that this feature is incompatible with the following properties:
     * 
     *  - LabelCollapseMode (other than the default of "none")
     * 
     *  - FacetChart.rotateLabels (in "auto" mode)
     * 
     *  - DrawPane.canDragScroll
     * 
     *  - FacetChart.canZoom
     *   If FacetChart.rotateLabels is set to "auto" it will be treated as "never" if
     *   autoScrollData has been set. If any of the other properties have non-default
     *   values, a warning will be logged and autoScrollData will be disabled. The
     *   factors used to drive expansion can be limited by setting AutoScrollDataApproach.
     *  @type {boolean}
     *  @default false
     */
    open var autoScrollData: Boolean = definedExternally
    /**
     *  If set, overrides the default behavior of FacetChart.autoScrollData, potentially limiting what
     *   factors drive the automatic horizontal expansion of the chart. (The "both" setting is no
     *   different than the default of null.)
     * 
     *   If you're sizing bars very tightly to labels by defining FacetChart.getMinClusterSize, you may
     *   not want label-driven expansion, as the separation between them assigned automatically is
     *   very generous, and is based on the widest labels. (You may also set FacetChart.minLabelGap to
     *   gain more control over the separation.)
     *  @type {AutoScrollDataApproach}
     *  @default null
     */
    open var autoScrollDataApproach: 
                                     /**
                                      *  Expand the chart to make room for data label facet value.
                                      *  Expand the chart to accommodate FacetChart.barMargin, FacetChart.minBarThickness,          and FacetChart.getMinClusterSize.
                                      *  Expand the chart to make room for both labels and clusters (whichever requires        more space).
                                      */
                                     String /* labels |  clusters |  both */ = definedExternally
    /**
     *  Whether to center the chart title with respect to the full, expanded width of the chart when
     *   FacetChart.autoScrollData is active. The default of false means that the title will be placed
     *   at the center of the visible, non-overflowed region of the chart, for greater visibility.
     *  @type {boolean}
     *  @default false
     */
    open var centerTitle: Boolean = definedExternally
    /**
     *  Whether to center the chart legend with respect to the full, expanded width of the chart when
     *   FacetChart.autoScrollData is active. The default of false means that the legend will be placed
     *   at the center of the visible, non-overflowed region of the chart, for greater visibility.
     * 
     *   Note that this setting has no impact on axis labeling, which always occurs with respect to
     *   the full, expanded width of the chart.
     *  @type {boolean}
     *  @default false
     */
    open var centerLegend: Boolean = definedExternally
    /**
     *  Padding from edge of Y the Axis Label.
     *  @type {Integer}
     *  @default "5"
     */
    open var gradationLabelPadding: Number = definedExternally
    /**
     *  Padding between each swatch and label pair.
     *  @type {Integer}
     *  @default "5"
     */
    open var yAxisLabelPadding: Number = definedExternally
    /**
     *  Whether to call FacetChart.formatAxisValue or FacetChart.formatFacetValueId on a facet value id when
     *   the id is a string. Can be set false to allow the formatting function(s) to be written
     *   without having to handle the string case.
     *  @type {boolean}
     *  @default true
     */
    open var formatStringFacetValueIds: Boolean = definedExternally
    /**
     *  Causes the chart to use the colors specified in FacetChart.dataColors but specify chart-specific
     *   gradients based on the primary data color per chart type.
     *  @type {boolean}
     *  @default true
     */
    open var useAutoGradients: Boolean = definedExternally
    /**
     *  Setting to define whether the border around the bar chart area should be the same color
     *   as the main chart area.
     *  @type {boolean}
     *  @default null
     */
    open var matchBarChartDataLineColor: Boolean = definedExternally
    /**
     *  When hovering over a bar chart block, should the whole bar chart area be brightened
     *   Default behaviour is to just brighten the line color around the bar chart area
     *  @type {boolean}
     *  @default null
     */
    open var brightenAllOnHover: Boolean = definedExternally
    /**
     *  An array of colors to use for a series of visual elements representing data (eg columns,
     *   bars, pie slices), any of which may be adjacent to any other.
     * 
     *   Colors must be in the format of a leading hash (#) plus 6 hexadecimal digits, for example,
     *   "#FFFFFF" is white, "#FF0000" is pure red.
     *  @type {Array<Partial<CSSColor>>}
     *  @default "see below"
     */
    open var dataColors: Array<dynamic> = definedExternally
    /**
     *  A dictionary of gradients to use for a series of visual elements representing data (eg columns,
     *   bars, pie slices), any of which may be adjacent to any other.
     *  @type {any}
     *  @default "see below"
     */
    open var dataGradients: dynamic = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "FacetChartEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
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
     *   Setter for FacetChart.proportional.
     * 
     *  @param {boolean} Whether the chart should now use proportional mode.
     */
    open fun setProportional(proportional: Boolean): Unit = definedExternally
    /**
     *   Setter for FacetChart.pixelsPerGradation.
     * 
     * 
     *  @param {Integer} new FacetChart.pixelsPerGradation value
     */
    open fun setPixelsPerGradation(pixelsPerGradation: Number): Unit = definedExternally
    /**
     *   Setter for FacetChart.otherAxisPixelsPerGradation.
     * 
     * 
     *  @param {Integer} new FacetChart.otherAxisPixelsPerGradation value
     */
    open fun setOtherAxisPixelsPerGradation(pixelsPerGradation: Number): Unit = definedExternally
    /**
     *   Setter for FacetChart.gradationGaps.
     * 
     * 
     *  @param {Array<Partial<Float>>} new FacetChart.gradationGaps value
     */
    open fun setGradationGaps(gradationGaps: Array<dynamic>): Unit = definedExternally
    /**
     *   Setter for FacetChart.otherAxisGradationGaps.
     * 
     * 
     *  @param {Array<Partial<Float>>} new FacetChart.otherAxisGradationGaps value
     */
    open fun setOtherAxisGradationGaps(gradationGaps: Array<dynamic>): Unit = definedExternally
    /**
     *   Setter for FacetChart.otherAxisGradationTimes.
     * 
     * 
     *  @param {Array<Partial<string>>} new FacetChart.otherAxisGradationTimes value
     */
    open fun setOtherAxisGradationTimes(otherAxisGradationTimes: Array<dynamic>): Unit = definedExternally
    /**
     *   Method to change the current ChartType.
     *   Will redraw the chart if drawn.
     * 
     * 
     *  @param {boolean} whether to draw lines between adjacent data points in "Scatter" plots
     */
    open fun setShowScatterLines(showScatterLines: Boolean): Unit = definedExternally
    /**
     *   Method to change the current ChartType.
     *   Will redraw the chart if drawn.
     * 
     * 
     *  @param {DataLineType} ow to draw lines between adjacent data points in Line and Scatter charts
     */
    open fun setDataLineType(dataLineType: 
                                           /**
                                            *  simple straight lines between points that are adjacent in the dataset
                                            *  smooth spline curve between points that are adjacent in the dataset
                                            */
                                           String /* straight |  smooth */): Unit = definedExternally
    /**
     *   Setter for FacetChart.useMultiplePointShapes.
     * 
     *  @param {boolean} Whether the chart should now use multiple shapes to show data points.
     */
    open fun setUseMultiplePointShapes(useMultiplePointShapes: Boolean): Unit = definedExternally
    /**
     *   Setter for FacetChart.scaleStartColor.
     * 
     *  @param {CSSColor} The new start color for the color scale.
     */
    open fun setScaleStartColor(scaleStartColor: String): Unit = definedExternally
    /**
     *   Setter for FacetChart.scaleEndColor.
     * 
     *  @param {CSSColor} The new end color for the color scale.
     */
    open fun setScaleEndColor(scaleEndColor: String): Unit = definedExternally
    /**
     *   Fires when the end user changes the zoom position in a FacetChart.canZoom.
     * 
     *  @param {any} starting value for the data range shown in the main chart
     *  @param {any} ending value for the data range shown in the main chart
     */
    open fun zoomChanged(startValue: dynamic, endValue: dynamic): Unit = definedExternally
    /**
     *   Fires when a data value is clicked, and provides information about the data value that
     *   was clicked as a DrawnValue object.
     * 
     *   Specifically, this fires for clicks on pie slices, bars or columns, areas, lines or
     *   points (in a Bubble or Scatter plot).
     * 
     *   If there are multiple data values at the clicked position, you can use
     *   FacetChart.getNearestDrawnValues to discover the full list of values at the current
     *   coordinate (pass in Canvas.getOffsetX for the coordinates).
     * 
     *   If you want to create behaviors for clicking or moving near shapes without
     *   requiring a direct hit, implement a standard Canvas.click handler on the
     *   FacetChart as a whole and use FacetChart.getNearestDrawnValue to discover the nearest
     *   data values.
     * 
     *  @param {DrawnValue} information about the value that was clicked
     */
    open fun valueClick(drawnValue: DrawnValue): Unit = definedExternally
    /**
     *   Fires when the user clicks on the legend area of the chart.
     * 
     *   If the user specifically clicks on a color swatch or it's label, the FacetValue
     *   clicked on will be provided.
     * 
     *   If the chart is a FacetChart.extraAxisMetrics, the
     *   FacetValue for the clicked-on metric will also be provided.
     * 
     *  @param {FacetValue} facetValue that was clicked, or null if click was in    empty space
     *  @param {FacetValue} for a multi-axis chart, facetValue representing    the clicked metric. Null if click is in empty space or chart is not multi-axis
     */
    open fun legendClick(facetValue: FacetValue, metricFacetValue: FacetValue): Unit = definedExternally
    /**
     *   Fires when the user clicks on a data label, that is, a text label showing values from
     *   the first facet. For example, the labels underneath the X-axis of a column chart,
     *   labelling each column.
     * 
     * 
     *  @param {FacetValue} facetValue that was clicked, or null if click was in    empty space
     */
    open fun dataLabelClick(facetValue: FacetValue): Unit = definedExternally
    /**
     *   Returns the minimum cluster size (for clustered charts), or minimum bar thickness (for
     *   histogram or stacked charts) for the specified FacetChart.getDataLabelFacet value. Only applicable to a column, bar, or histogram chart. No default
     *   implementation. Both this minimum and FacetChart.minBarThickness are used together to
     *   determine the effective minimum of the cluster or bar stack.
     * 
     *   Per-facet-value minimum cluster sizes aren't supported for
     *   MetricSettings charts, in which multiple chart types are overlaid onto
     *   the same chart.
     * 
     * 
     *   Note that this method is simply an override point, since it has no default
     *   implementation.
     * 
     * 
     * 
     *  @param {number} data label axis index of cluster or bar stack
     *  @param {string | number | Date} data label facet value id                       of cluster or bar stack
     */
    open fun getMinClusterSize(index: Number, facetValueId: dynamic): Number = definedExternally
    /**
     *   Defines the format of the label for a segment in a histogram chart. By default, it
     *   simply returns a label of the form "Y1 to Y2" describing the start and end values,
     *   applying FacetChart.formatDataValue to format the values.
     * 
     *   Note that this method has no impact on the facet value labels appearing on the
     *   horizontal axis of the histogram chart.
     * 
     * 
     *  @param {any} raw start value of the segment
     *  @param {any} raw end value of the segment
     */
    open fun formatSegmentLabel(startValue: dynamic, endValue: dynamic): String = definedExternally
    /**
     *   Method to change the current FacetChart.zIndexMetric - see property for more details. Will
     *   redraw the chart if drawn.
     * 
     * 
     *  @param {string} name of zIndex metric
     */
    open fun setZIndexMetric(zIndexMetric: String): Unit = definedExternally
    /**
     *   Fires when the mouse hovers over a data label, that is, a text label showing values from
     *   the first facet. For example, the labels underneath the X-axis of a column chart,
     *   labelling each column.
     * 
     * 
     *  @param {FacetValue} facetValue that was hovered
     */
    open fun dataLabelHover(facetValue: FacetValue): Unit = definedExternally
    /**
     *   Called when the mouse hovers over a data label, that is, a text label showing values from
     *   the first facet. For example, the labels underneath the X-axis of a column chart,
     *   labelling each column.
     * 
     * 
     *  @param {FacetValue} facetValue that was hovered
     */
    open fun getDataLabelHoverHTML(facetValue: FacetValue): String = definedExternally
    /**
     *   Fires when the mouse hovers over a color swatch or its label in the legend area of the
     *   chart.
     * 
     *   The FacetValue that the user is hovering over is provided.
     *   If the chart is a FacetChart.extraAxisMetrics, the
     *   FacetValue for the hovered-over metric will also be provided.
     * 
     * 
     *  @param {FacetValue} facetValue that the mouse is over
     *  @param {FacetValue} for a multi-axis chart, facetValue representing    the hovered-over metric. Null if chart is not multi-axis
     */
    open fun legendHover(facetValue: FacetValue, metricFacetValue: FacetValue): Unit = definedExternally
    /**
     *   Called when the mouse hovers over a color swatch or its label in the legend area of the
     *   chart.
     * 
     *   The FacetValue that the user is hovering over is provided.
     *   If the chart is a FacetChart.extraAxisMetrics, the
     *   FacetValue for the hovered-over metric will also be provided.
     * 
     * 
     *  @param {FacetValue} facetValue that the mouse is over
     *  @param {FacetValue} for a multi-axis chart, facetValue representing    the hovered-over metric. Null if chart is not multi-axis
     */
    open fun getLegendHoverHTML(facetValue: FacetValue, metricFacetValue: FacetValue): String = definedExternally
    /**
     *   Setter for FacetChart.showYTicks.
     * 
     * 
     *  @param {boolean} new FacetChart.showYTicks value
     */
    open fun setShowYTicks(showTicks: Boolean): Unit = definedExternally
    /**
     *   Setter for FacetChart.showXTicks.
     * 
     * 
     *  @param {boolean} new FacetChart.showXTicks value
     */
    open fun setShowXTicks(showTicks: Boolean): Unit = definedExternally
    /**
     *   Setter for FacetChart.tickLength.
     * 
     * 
     *  @param {Integer} new FacetChart.tickLength value
     */
    open fun setTickLength(tickLength: Number): Unit = definedExternally
    /**
     *   Setter for FacetChart.minorTickLength.
     * 
     * 
     *  @param {Integer} new FacetChart.minorTickLength value
     */
    open fun setMinorTickLength(minorTickLength: Number): Unit = definedExternally
    /**
     *   Setter for FacetChart.showMinorTicks.
     * 
     * 
     *  @param {boolean} new FacetChart.showMinorTicks value
     */
    open fun setShowMinorTicks(showMinorTicks: Boolean): Unit = definedExternally
    /**
     *   Setter for FacetChart.majorTickGradations.
     * 
     * 
     *  @param {Array<Partial<Float>>} new FacetChart.majorTickGradations value
     */
    open fun setMajorTickGradations(majorTickGradations: Array<dynamic>): Unit = definedExternally
    /**
     *   Setter for FacetChart.majorTickTimeIntervals.
     * 
     * 
     *  @param {Array<Partial<string>>} new FacetChart.majorTickTimeIntervals value
     */
    open fun setMajorTickTimeIntervals(majorTickTimeIntervals: Array<dynamic>): Unit = definedExternally
    /**
     *   Retrieves printable HTML for this component and all printable subcomponents.
     * 
     *   By default any Canvas with children will simply collect the printable HTML of its
     *   children by calling getPrintHTML() on each child that is considered
     *   Canvas.shouldPrint.
     * 
     *   If overriding this method for a custom component, you should either return a String of
     *   printable HTML string directly or return null, and fire the callback (if provided)
     *   using Class.fireCallback.
     * 
     *   To return an empty print representation, return an empty string ("") rather than null.
     * 
     *   The printProperties argument, if passed, must be passed to any subcomponents on
     *   which getPrintHTML() is called.
     * 
     *   Notes on printing
     * 
     *   To print a FacetChart for export on IE8 and earlier, it is important to pass
     *   PrintProperties with PrintProperties.printForExport:true:
     * 
     *   var exportHTML = chart.getPrintHTML({ printForExport:true });
     * 
     * 
     *  @param {PrintProperties=} properties to configure printing behavior - may be null.
     *  @param {Callback=} optional callback. This is required to handle cases where HTML         generation is asynchronous - if a method generates HTML asynchronously, it should return          null, and fire the specified callback on completion of HTML generation. The          first parameter HTML should contain the generated print HTML.          The callback is only called if null is returned. Furthermore, the default          getPrintHTML() implementation always returns null and fires the callback          when a callback is provided.
     */
    override fun getPrintHTML(printProperties: PrintProperties?, callback: dynamic?): String = definedExternally
    /**
     *   Get the top coordinate of the central chart area, where data elements appear.
     * 
     *   This is only allowed to be called when FacetChart.chartDrawn fires.
     * 
     * 
     */
    open fun getChartTop(): Number = definedExternally
    /**
     *   Get the height the central chart area, where data elements appear.
     * 
     *   This is only allowed to be called when FacetChart.chartDrawn fires.
     * 
     * 
     *  @param {boolean} if false then cached value will be returned, otherwise will be recalculated.
     */
    open fun getChartHeight(recalc: Boolean): Number = definedExternally
    /**
     *   Get the left margin of the central chart area, where data elements appear.
     * 
     *   This is only allowed to be called when FacetChart.chartDrawn fires.
     * 
     * 
     */
    open fun getChartLeft(): Number = definedExternally
    /**
     *   Get the width of the central chart area, where data elements appear.
     * 
     *   This is only allowed to be called when FacetChart.chartDrawn fires.
     * 
     * 
     *  @param {boolean} if false then cached value will be returned, otherwise will be recalculated.
     */
    open fun getChartWidth(recalc: Boolean): Number = definedExternally
    /**
     *   Sets FacetChart.autoScrollData and updates the chart.
     * 
     *  @param {boolean} whether chart should expand automatically                  horizontally to accommodate content.
     */
    open fun setAutoScrollData(autoScrollData: Boolean): Unit = definedExternally
    /**
     *   Sets AutoScrollDataApproach and updates the chart.
     * 
     *  @param {AutoScrollDataApproach} what should drive horizontal expansion                            of the chart?
     */
    open fun setAutoScrollDataApproach(autoScrollDataApproach: 
                                                               /**
                                                                *  Expand the chart to make room for data label facet value.
                                                                *  Expand the chart to accommodate FacetChart.barMargin, FacetChart.minBarThickness,          and FacetChart.getMinClusterSize.
                                                                *  Expand the chart to make room for both labels and clusters (whichever requires        more space).
                                                                */
                                                               String /* labels |  clusters |  both */): Unit = definedExternally
    /**
     *   Method to change FacetChart.stacked. Use null to
     *   apply a default value for the current ChartType.
     * 
     * 
     *  @param {boolean} new value
     */
    open fun setStacked(stacked: Boolean): Unit = definedExternally
    /**
     *   Method to change FacetChart.filled.
     *   Use null to apply a default value for the current ChartType.
     * 
     * 
     *  @param {boolean} new value
     */
    open fun setFilled(filled: Boolean): Unit = definedExternally
    /**
     *   Method to change the current ChartType.
     *   Will redraw the chart if drawn.
     *   Will use default settings for the new chart type for FacetChart.stacked
     *   and FacetChart.filled if those values are null.
     * 
     *   Note that for FacetChart.extraAxisMetrics charts this method changes the
     *   chartType for the main value axis only.
     * 
     * 
     *  @param {ChartType} new chart type
     */
    open fun setChartType(chartType: 
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
                                     String /* Area |  Column |  Bar |  Line |  Radar |  Pie |  Doughnut |  Scatter |  Bubble |  Histogram */): Unit = definedExternally
    /**
     *   Called when most elements of the chart other than data data have been drawn, including
     *   gradations and legend.
     * 
     *   This notification will be fired each time the chart is redrawn (due to resize, data change,
     *   etc). If you want to draw additional information on the chart using DrawPane
     *   (FacetChart's superclass) and various DrawItems, you should do in response to this
     *   notification. Due to auto-sizing, APIs that are typically used to position custom
     *   DrawItems (such as FacetChart.getChartLeft) may return bad values if called at other times.
     * 
     *   Additional DrawItems added in this method will appear underneath data elements such as bars
     *   or columns. See FacetChart.chartDrawn for placing DrawItems on top of data elements.
     * 
     * 
     */
    open fun chartBackgroundDrawn(): Unit = definedExternally
    /**
     *   Called when all elements of the chart (data lines / shapes, gradations, legend, labels etc)
     *   have completed drawing.
     * 
     *   See FacetChart.chartBackgroundDrawn for usage information.
     * 
     * 
     */
    open fun chartDrawn(): Unit = definedExternally
    /**
     *   Return an array of the gradation values used in the current chart. Pass these values
     *   to FacetChart.getXCoord / FacetChart.getYCoord (depending on the orientation of the chart)
     *   to discover the coordinates where gradations are drawn.
     * 
     *   This is only allowed to be called when FacetChart.chartDrawn fires.
     * 
     * 
     */
    open fun getGradations(): Array<dynamic> = definedExternally
    /**
     *   Returns the Y coordinate where the passed data value either was or would be drawn.
     *   For example, this would be the Y coordinate that a line would pass through on
     *   a line chart, or the top of a column on a column chart.
     * 
     *   This is only allowed to be called after FacetChart.chartDrawn fires.
     * 
     *   If the FacetChart.chartType is
     *   "Area", "Bubble", "Column", "Histogram", "Line", or "Scatter"
     * 
     *   then the value argument should be a number. For
     *   "Bar"
     *   charts this method expects a FacetValueMap that uniquely identifies the data cell
     *   whose Y-axis coordinate is to be retrieved.
     * 
     * 
     *  @param {Float | FacetValueMap} the value to be drawn.
     */
    open fun getYCoord(value: dynamic): Number = definedExternally
    /**
     *   Returns the X coordinate where the passed data value either was or would be drawn.
     *   For example, this would be the X coordinate where a bar would end in a bar
     *   chart.
     * 
     *   This is only allowed to be called after FacetChart.chartDrawn fires.
     * 
     *   If the FacetChart.chartType is
     *   "Bar", "Bubble", or "Scatter"
     * 
     *   then the value argument should be a number. For other rectangular charts,
     *   this method expects a FacetValueMap that uniquely identifies the data cell whose
     *   X-axis coordinate is to be retrieved.
     * 
     *   Note that when FacetChart.canZoom is enabled, this API is valid only for
     *   data values between FacetChart.zoomStartValue and
     *   FacetChart.zoomEndValue.
     * 
     * 
     *  @param {Float | FacetValueMap} the value to be drawn.
     */
    open fun getXCoord(value: dynamic): Number = definedExternally
    /**
     *   Returns the centerpoint for radar charts and pie charts.
     * 
     *   Note that unstacked pie charts draw multiple pies, each with their own centers.
     * 
     *   This is only allowed to be called when FacetChart.chartDrawn fires.
     * 
     * 
     */
    open fun getChartCenter(): Point = definedExternally
    /**
     *   Returns the radius for radar charts and pie charts. For stacked pie charts this is radius of
     *   the outermost pie.
     * 
     *   Note that unstacked pie charts draw multiple pies, each with their own radii.
     * 
     *   This is only allowed to be called when FacetChart.chartDrawn fires.
     * 
     * 
     */
    open fun getChartRadius(): Number = definedExternally
    /**
     *   Return the text string to display along the axes for FacetChart.gradationLabelProperties or facet value labels given the raw metric value or facet value id.
     * 
     *   Note that this formatter will be called for the gradation labels on an axis, including those
     *   generated for LabelCollapseMode "numeric". It also will be called for each facet
     *   value along the linear axes of a chart (vertical or horizontal) when LabelCollapseMode
     *   is not active, unless a FacetValue.title has been specified (in
     *   Facet.values) or the raw value is a string and FacetChart.formatStringFacetValueIds is
     *   false.
     * 
     *   Note that the rendering of values in hovers or via FacetChart.showDataValues is handled
     *   by FacetChart.formatDataValue.
     * 
     *  @param {any} raw value of the metric or facet value id
     *  @param {boolean} whether the raw value is for the horizontal/x-axis (true) or for the vertical/y-axis (false)
     */
    open fun formatAxisValue(value: dynamic, forHorizontalAxis: Boolean): String = definedExternally
    /**
     *   Return the text string to display for facet value labels that appear in chart legends or as
     *   labels for FacetChart.chartTypes that have circumference or non-axis labels, such as
     *   for example "Pie" or "Radar" charts.
     * 
     * 
     *  @param {any} raw value of the metric
     *  @param {Facet} facet containing the value
     */
    open fun formatFacetValueId(value: dynamic, facet: Facet): String = definedExternally
    /**
     *   Return the text string to display in FacetChart.showValueOnHover or via FacetChart.showDataValues
     *   given the raw value for the metric displayed on the value axis.
     * 
     *   Note that the rendering of values for gradation labels is handled by
     *   FacetChart.formatAxisValue.
     * 
     *  @param {any} raw value of the metric
     */
    open fun formatDataValue(value: dynamic): String = definedExternally
    /**
     *   Count the number of data points.
     * 
     *  @param {FacetValueMap=} a set of facetValues describing a slice of the data
     */
    open fun getNumDataPoints(criteria: FacetValueMap?): Number = definedExternally
    /**
     *   Calculate the mean, or expected value, of the data over a single metric.
     *   See http://en.wikipedia.org/wiki/Expected_value.
     * 
     *   The first argument, criteria, determines which metric is used to calculate the mean.
     *   The criteria may be a String that is the "id" of some FacetValue of
     *   the metric facet, or a FacetValueMap that contains an entry for the metric facet,
     *   or null to use the FacetChart.valueProperty. A FacetValueMap criteria may also be used to restrict
     *   the calculation to a slice of the data.
     * 
     *  @param {string | FacetValueMap} the "id" of a metric facet value, or a set of mappings describing the data over which to calculate, or null
     */
    open fun getMean(criteria: dynamic): Number = definedExternally
    /**
     *   Calculate the median of the data over a single metric.
     *   See http://en.wikipedia.org/wiki/Median.
     * 
     *   The first argument, criteria, determines which metric is used to calculate the median.
     *   The criteria may be a String that is the "id" of some FacetValue of
     *   the metric facet, or a FacetValueMap that contains an entry for the metric facet,
     *   or null to use the FacetChart.valueProperty. A FacetValueMap criteria may also be used to restrict
     *   the calculation to a slice of the data.
     * 
     *  @param {string | FacetValueMap} the "id" of a metric facet value, or a set of mappings describing the data over which to calculate, or null
     */
    open fun getMedian(criteria: dynamic): Number = definedExternally
    /**
     *   Calculate a percentile of the data over a single metric.
     *   See http://en.wikipedia.org/wiki/Percentile.
     * 
     *   The first argument, criteria, determines which metric is used to calculate a percentile.
     *   The criteria may be a String that is the "id" of some FacetValue of
     *   the metric facet, or a FacetValueMap that contains an entry for the metric facet,
     *   or null to use the FacetChart.valueProperty. A FacetValueMap criteria may also be used to restrict
     *   the calculation to a slice of the data.
     * 
     *   The second argument is the percentile to calculate and it must be a number from 0 to 100.
     * 
     *  @param {string | FacetValueMap} the "id" of a metric facet value, or a set of mappings describing the data over which to calculate, or null
     *  @param {Float} the percentile to calculate
     */
    open fun getPercentile(criteria: dynamic, percentile: Number): Number = definedExternally
    /**
     *   Calculate the range of the data from a single metric.
     * 
     *   The first argument, criteria, determines which metric is used to calculate the range.
     *   The criteria may be a String that is the "id" of some FacetValue of
     *   the metric facet, or a FacetValueMap that contains an entry for the metric facet,
     *   or null to use the FacetChart.valueProperty. A FacetValueMap criteria may also be used to restrict
     *   the calculation to a slice of the data.
     * 
     *  @param {string | FacetValueMap} the "id" of a metric facet value, or a set of mappings describing the data over which to calculate, or null
     */
    open fun getRange(criteria: dynamic): Number = definedExternally
    /**
     *   Calculate the standard deviation of the data from a single metric.
     *   See http://en.wikipedia.org/wiki/Standard_deviation.
     * 
     *   The first argument, criteria, determines which metric is used to calculate the standard deviation.
     *   The criteria may be a String that is the "id" of some FacetValue of
     *   the metric facet, or a FacetValueMap that contains an entry for the metric facet,
     *   or null to use the FacetChart.valueProperty. A FacetValueMap criteria may also be used to restrict
     *   the calculation to a slice of the data.
     * 
     *  @param {string | FacetValueMap} the "id" of a metric facet value, or a set of mappings describing the data over which to calculate, or null
     *  @param {boolean} false to calculate a sample standard deviation, true to calculate a population standard deviation
     */
    open fun getStdDev(criteria: dynamic, population: Boolean): Number = definedExternally
    /**
     *   Calculate the variance of the data from a single metric.
     *   See http://en.wikipedia.org/wiki/Variance.
     * 
     *   The first argument, criteria, determines which metric is used to calculate the variance.
     *   The criteria may be a String that is the "id" of some FacetValue of
     *   the metric facet, or a FacetValueMap that contains an entry for the metric facet,
     *   or null to use the FacetChart.valueProperty. A FacetValueMap criteria may also be used to restrict
     *   the calculation to a slice of the data.
     * 
     *  @param {string | FacetValueMap} the "id" of a metric facet value, or a set of mappings describing the data over which to calculate, or null
     *  @param {boolean} false to calculate a sample variance, true to calculate a population variance
     */
    open fun getVariance(criteria: dynamic, population: Boolean): Number = definedExternally
    /**
     *   Calculate the maximum of the data from a single metric.
     * 
     *   The first argument, criteria, determines which metric is used to calculate the maximum.
     *   The criteria may be a String that is the "id" of some FacetValue of
     *   the metric facet, or a FacetValueMap that contains an entry for the metric facet,
     *   or null to use the FacetChart.valueProperty. A FacetValueMap criteria may also be used to restrict
     *   the calculation to a slice of the data.
     * 
     *  @param {string | FacetValueMap} the "id" of a metric facet value, or a set of mappings describing the data over which to calculate, or null
     */
    open fun getMax(criteria: dynamic): Number = definedExternally
    /**
     *   Calculate the minimum of the data from a single metric.
     * 
     *   The first argument, criteria, determines which metric is used to calculate the minimum.
     *   The criteria may be a String that is the "id" of some FacetValue of
     *   the metric facet, or a FacetValueMap that contains an entry for the metric facet,
     *   or null to use the FacetChart.valueProperty. A FacetValueMap criteria may also be used to restrict
     *   the calculation to a slice of the data.
     * 
     *  @param {string | FacetValueMap} the "id" of a metric facet value, or a set of mappings describing the data over which to calculate, or null
     */
    open fun getMin(criteria: dynamic): Number = definedExternally
    /**
     *   Setter for RegressionLineType.
     * 
     *  @param {RegressionLineType} New value for this.regressionLineType
     */
    open fun setRegressionLineType(regressionLineType: 
                                                       /**
                                                        *  linear regression
                                                        *  polynomial regression
                                                        */
                                                       String /* line |  polynomial */): Unit = definedExternally
    /**
     *   Setter for FacetChart.showRegressionLine.
     * 
     *  @param {boolean} New value for this.showRegressionLine.
     */
    open fun setShowRegressionLine(showRegressionLine: Boolean): Unit = definedExternally
    /**
     *   Setter for FacetChart.regressionPolynomialDegree.
     * 
     *  @param {number} New value for this.regressionPolynomialDegree.
     */
    open fun setRegressionPolynomialDegree(regressionPolynomialDegree: Number): Unit = definedExternally
    /**
     *   For scatter plots only, get a Function from the specified independent variable X to the
     *   specified dependent variable Y that defines the line that best fits the data.
     *   See http://en.wikipedia.org/wiki/Simple_linear_regression.
     * 
     *  @param {string=} ID of an inlined facet value to use as the independent variable. Defaults to the FacetChart.xAxisMetric.
     *  @param {string=} ID of an inlined facet value to use as the dependent variable. Defaults to the FacetChart.yAxisMetric.
     */
    open fun getSimpleLinearRegressionFunction(xMetric: String?, yMetric: String?): Unit = definedExternally
    /**
     *   For scatter plots only, get a Function from the specified independent variable X to the
     *   specified dependent variable Y that defines the polynomial that best fits the data.
     *   See http://en.wikipedia.org/wiki/Polynomial_regression.
     * 
     *  @param {Integer=} the degree of the polynomial. Defaults to FacetChart.regressionPolynomialDegree.
     *  @param {string=} ID of an inlined facet value to use as the independent variable. Defaults to the FacetChart.xAxisMetric.
     *  @param {string=} ID of an inlined facet value to use as the dependent variable. Defaults to the FacetChart.yAxisMetric.
     */
    open fun getPolynomialRegressionFunction(degree: Number?, xMetric: String?, yMetric: String?): Unit = definedExternally
    /**
     *   When FacetChart.showDataPoints is true, fires when a point is clicked on.
     * 
     * 
     *  @param {Float} the value at the point
     *  @param {Record} the record at the point
     *  @param {string} the ID of the metric at the point
     */
    open fun pointClick(value: Number, record: Record, metricId: String): Unit = definedExternally
    /**
     *   When FacetChart.showDataPoints is true and the mouse hovers over a point, this method is called
     *   and may return HTML to show in a hover.
     * 
     * 
     *  @param {Float} the value at the point
     *  @param {Record} the record at the point
     *  @param {string} the ID of the metric at the point
     */
    open fun getPointHoverHTML(value: Number, record: Record, metricId: String): String = definedExternally
    /**
     *   Returns the Facet in the list of FacetChart.facets whose
     *   Facet.values are rendered in the chart's legend.
     * 
     *   Most single-facet charts do not have a legend facet. The exceptions are that single-facet
     *   Pie/Doughnut charts have a legend facet as the first facet and Bubble and Scatter charts
     *   may optionally have a legend facet as the second facet, after the metric facet.
     * 
     *   In all multi-facet charts, the legend facet is the second facet.
     * 
     *   Note that the user may swap the legend facet and the
     *   FacetChart.getDataLabelFacet in most chart types using the context menu.
     * 
     */
    open fun getLegendFacet(): Facet = definedExternally
    /**
     *   Returns the Facet in the list of FacetChart.facets whose
     *   Facet.values are rendered as labels along the data axis of the chart or in
     *   the main chart area.
     * 
     *   Most single-facet charts and all multi-facet charts have the data label facet as their
     *   first facet. The exceptions are that single-facet Pie/Doughnut charts and Bubble and
     *   Scatter charts do not have data label facets.
     * 
     *   Note that the user may swap the data label facet and the
     *   FacetChart.getLegendFacet in most chart types using the context menu.
     * 
     */
    open fun getDataLabelFacet(): Facet = definedExternally
    /**
     *   Setter for FacetChart.dataColors.
     * 
     *  @param {Array<Partial<CSSColor>>} New set of data colors
     */
    open fun setDataColors(dataColors: Array<dynamic>): Unit = definedExternally
    /**
     *   Get a color from the FacetChart.dataColors Array.
     * 
     * 
     *   Override to provide a dynamic color generation scheme - must return a color in the format of
     *   of a leading hash (#) plus 6 hexadecimal digits as specified for FacetChart.dataColors.
     * 
     * 
     * 
     *  @param {number} index of the legend facet value to be colored
     *  @param {string | number | Date} id of the legend facet value to be colored
     *  @param {string} purpose for the requested color - such as "legend", "line",             "area", "points", etc.
     */
    open fun getDataColor(index: Number, facetValueId: dynamic, purpose: String): String = definedExternally
    /**
     *   Specifies the color to use for data lines in the chart. No default implementation. If not
     *   defined or null is returned, the Framework will default to value of FacetChart.getDataColor.
     * 
     * 
     *   Note that this method is simply an override point, since it has no default implementation -
     *   must return a color in the format of of a leading hash (#) plus 6 hexadecimal digits as
     *   specified for FacetChart.dataColors.
     * 
     * 
     * 
     *  @param {number} index of the legend facet value to be colored
     *  @param {string | number | Date} id of the legend facet value to be colored
     *  @param {string} purpose for the requested color - such as "legend", "line",             "area", "points", etc.
     */
    open fun getDataLineColor(index: Number, facetValueId: dynamic, purpose: String): String = definedExternally
    /**
     *   Specifies the width to use for data lines in the chart. No default implementation. If not
     *   defined or null is returned, the line width will be set by the appropriate chart properties,
     *   such as FacetChart.dataLineProperties, FacetChart.barProperties, or FacetChart.bubbleProperties.
     * 
     * 
     *   Note that this method is simply an override point, since it has no default implementation.
     * 
     * 
     * 
     *  @param {number} index of the legend facet value to target
     *  @param {string | number | Date} id of the legend facet value to target
     *  @param {string} purpose for the requested width - such as "legend", "line",             "area", "points", etc.
     */
    open fun getDataLineWidth(index: Number, facetValueId: dynamic, purpose: String): Number = definedExternally
    /**
     *   Get a gradient from the FacetChart.dataGradients Array.
     * 
     *   Override to provide a dynamic gradient generation scheme.
     * 
     * 
     *  @param {number} index of the legend facet value to be colored
     *  @param {string | number | Date} id of the legend facet value to be colored
     *  @param {string} purpose for the requested gradient - such as "legend", "line",             "area", "points", etc.
     */
    open fun getDataGradient(index: Number, facetValueId: dynamic, purpose: String): String = definedExternally
    /**
     *   Returns a DrawnValue object for the data value that is shown nearest to the passed
     *   coordinates only if it's under the given coordinates, or under the current mouse event
     *   coordinates if no coordinates are passed. This method is similar to FacetChart.getNearestDrawnValue,
     *   but the DrawnValue is only returned if it's under the coordinates.
     * 
     *   See FacetChart.drawnValueContainsPoint for the criteria that determine whether a DrawnValue is
     *   under (contains) the coordinates.
     * 
     *  @param {Integer=} X coordinate. If this parameter is specified, then y is a required parameter.
     *  @param {Integer=} Y coordinate
     *  @param {string=} metric over which to determine the drawn value
     */
    open fun getDrawnValueAtPoint(x: Number?, y: Number?, metric: String?): DrawnValue = definedExternally
    /**
     *   Returns an array of DrawnValue objects for the data values of each metric that are shown
     *   nearest to the passed coordinates, but only if they're under the given coordinates, or under
     *   the current mouse event coordinates if no coordinates are passed. This method is similar to
     *   FacetChart.getNearestDrawnValues, but DrawnValues are only included in the returned array if
     *   they're under the coordinates.
     * 
     *   See FacetChart.drawnValueContainsPoint for the criteria that determine whether a DrawnValue is under
     *   (contains) the coordinates.
     * 
     *  @param {Integer=} X coordinate. If this parameter is specified, then y is a required parameter.
     *  @param {Integer=} Y coordinate
     */
    open fun getDrawnValuesAtPoint(x: Number?, y: Number?): Array<dynamic> = definedExternally
    /**
     *   Returns whether a given DrawnValue contains a point. The point's X and Y coordinates may
     *   be passed into this method, or, if unspecified, the coordinates used are the current mouse event
     *   coordinates.
     * 
     *   For Area, Bubble, Line, Radar, and Scatter charts, a DrawnValue is considered to contain a
     *   point if the Euclidean distance from the DrawnValue's center (DrawnValue.x,
     *   DrawnValue.y) to the point is less than
     *   FacetChart.dataPointSize. For Pie charts, the DrawnValue is
     *   considered to contain a point if the point is within the pie slice. Similarly, for Doughnut
     *   charts, the DrawnValue is considered to contain a point if the point is within the pie
     *   slice and not in the doughnut hole. For Bar and Column charts, the DrawnValue is considered
     *   to contain a point if the point is within the bar or column, respectively. Note that for
     *   stacked Bar and Column charts, the point must also be in the stacked portion as opposed to
     *   anywhere within the bar or column.
     * 
     * 
     *  @param {DrawnValue} the DrawnValue to check. The DrawnValue must be a valid DrawnValue from this chart.
     *  @param {Integer=} X coordinate of the point. If this parameter is specified, then y is a required parameter.
     *  @param {Integer=} Y coordinate of the point
     */
    open fun drawnValueContainsPoint(drawnValue: DrawnValue, x: Number?, y: Number?): Boolean = definedExternally
    /**
     *   Returns rendering information for the data value that is shown nearest to the passed
     *   coordinates, as a DrawnValue object.
     * 
     *   Passed X and Y coordinates should be relative to the FacetChart. If neither an X or Y
     *   coordinate is passed, both X and Y will use the current Canvas.getOffsetX and
     *   Canvas.getOffsetY.
     * 
     *   If called before FacetChart.chartDrawn, logs a warning and returns null. For a chart with
     *   multiple vertical axes, returns the nearest point from the first metric only (see
     *   FacetChart). For scatter charts, returns a DrawnValue where the
     *   DrawnValue.value is from the FacetChart.yAxisMetric.
     * 
     *   To get the nearest DrawnValue only if it contains the given coordinates, you can either use
     *   the FacetChart.getDrawnValueAtPoint API or call FacetChart.drawnValueContainsPoint on the return
     *   value.
     * 
     *   Behavior for different chart types is as follows:
     * 
     *   Bar / Column
     * 
     *   Returns the centerpoint of the end of the nearest bar or column by considering the Y
     *   coordinate (bar) or X coordinate (column) only.
     * 
     *   Line / Area
     * 
     *   Returns the nearest point based on which data label is nearest to the passed X coordinate.
     *   For multi-series charts, if Y coordinate is not passed the data point returned is from the
     *   series that has the highest value at the data label.
     * 
     *   Radar
     * 
     *   Returns the data point nearest the passed coordinates by straight line distance.
     *   Passing only one coordinate will cause a warning to be logged and null to be returned;
     *   passing neither coordinate is allowed (getOffsetX/Y will be used).
     * 
     *   Pie
     * 
     *   Returns the data point for the segment that would be hit if a line were drawn from the
     *   passed coordinates to the center of the pie.
     * 
     *   If there are multiple stacked pies, uses the pie that contains the passed coordinates,
     *   otherwise the outermost pie.
     * 
     *   If there are multiple non-stacked pies, uses the pie that is nearest the passed coordinates
     *   by straight-line distance to the center of the pie.
     * 
     *   Passing only one coordinate will cause a warning to be logged and null to be returned;
     *   passing neither coordinate is allowed (getOffsetX/Y will be used).
     * 
     *   If the chart is a FacetChart.extraAxisMetrics then this method takes an
     *   optional parameter, metric, which causes this method to return a DrawnValue
     *   from the specified metric. If a metric is not passed then the first metric of the metric facet
     *   will be used (or just the FacetChart.valueProperty if there is no metric facet).
     * 
     * 
     *  @param {Integer=} X coordinate. If this parameter is specified, then y is a required parameter.
     *  @param {Integer=} Y coordinate
     *  @param {string=} metric over which to determine the drawn value
     */
    open fun getNearestDrawnValue(x: Number?, y: Number?, metric: String?): DrawnValue = definedExternally
    /**
     *   Returns an array of DrawnValue objects containing rendering information for the data
     *   values having each metric that are shown nearest to the passed coordinates.
     * 
     *   Passed X and Y coordinates should be relative to the FacetChart. If neither an X or Y
     *   coordinate is passed, both X and Y will use the current Canvas.getOffsetX and
     *   Canvas.getOffsetY.
     * 
     *   The behavior for different chart types is the same as FacetChart.getNearestDrawnValue. This
     *   method also logs a warning and returns null if called before FacetChart.chartDrawn.
     * 
     *   To get the nearest DrawnValues only if they contain the given coordinates, you can either use
     *   the FacetChart.getDrawnValuesAtPoint API or check whether each DrawnValue in the returned array
     *   contains the point by calling FacetChart.drawnValueContainsPoint.
     * 
     * 
     *  @param {Integer=} X coordinate. If this parameter is specified, then y is a required parameter.
     *  @param {Integer=} Y coordinate
     */
    open fun getNearestDrawnValues(x: Number?, y: Number?): Array<dynamic> = definedExternally
    /**
     *   Returns rendering information for the data value specified by the passed facet values.
     * 
     *   If called before FacetChart.chartDrawn, logs a warning and returns null.
     * 
     * 
     *  @param {FacetValueMap} facet values of desired data value
     */
    open fun getDrawnValue(facetValues: FacetValueMap): DrawnValue = definedExternally
    /**
     *   Returns rendering information for the data values specified by the passed facet values.
     * 
     *   If called before FacetChart.chartDrawn, logs a warning and returns null.
     * 
     *  @param {FacetValueMap=} facet values of desired DrawnValues. If no FacetValueMap is provided, then all DrawnValues are returned.
     */
    open fun getDrawnValues(facetValues: FacetValueMap?): Array<dynamic> = definedExternally
    /**
     *   For a FacetChart.canZoom, simultaneously sets the
     *   FacetChart.setZoomStartValue and
     *   FacetChart.setZoomEndValue.
     * 
     *  @param {any} starting value for the data range shown in the main chart
     *  @param {any} ending value for the data range shown in the main chart
     */
    open fun zoomTo(startValue: dynamic, endValue: dynamic): Unit = definedExternally
    /**
     *   Setter for FacetChart.zoomStartValue.
     * 
     *   Note that the FacetChart.zoomStartValue and FacetChart.zoomEndValue may be set simultaneously using
     *   FacetChart.zoomTo.
     * 
     *  @param {any} New start value for the data range shown in the main chart
     */
    open fun setZoomStartValue(zoomStartValue: dynamic): Unit = definedExternally
    /**
     *   Setter for FacetChart.zoomEndValue.
     * 
     *   Note that the FacetChart.zoomStartValue and FacetChart.zoomEndValue may be set simultaneously using
     *   FacetChart.zoomTo.
     * 
     *  @param {any} New end value for the data range shown in the main chart
     */
    open fun setZoomEndValue(zoomEndValue: dynamic): Unit = definedExternally
    /**
     *   General facet and data model setup, including auto-derivation of facetValues from data if
     *   necessary. Should be called by any concrete charting implementation before calling any
     *   other Chart method.
     * 
     * 
     */
    override fun setupChart(): Unit = definedExternally
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
         *  @default "["Area", "Bar", "Bubble", "Column", "Doughnut", "Histogram", "Line", "Pie", "Radar", "Scatter"]"
         */
        var allChartTypes: Array<dynamic> = definedExternally
        /**
         *  Title for the "Proportional" option of the context menu for charts that
         *   support FacetChart.proportional.
         *  @type {HTMLString}
         *  @default "Proportional"
         */
        var proportionalContextMenuItemTitle: String = definedExternally
        /**
         *  Title for the "Regression Lines" option of the context menu for scatter plots.
         *  @type {HTMLString}
         *  @default "Regression Lines"
         */
        var regressionLinesContextMenuItemTitle: String = definedExternally
        /**
         *  Title for the "None" option of the "Regression Lines" option
         *   in the context menu for scatter plots.
         *  @type {HTMLString}
         *  @default "None"
         */
        var hideRegressionLinesContextMenuItemTitle: String = definedExternally
        /**
         *  Title for the "Straight Line" option of the "Regression Lines"
         *   option in the context menu for scatter plots.
         *  @type {HTMLString}
         *  @default "Straight Line"
         */
        var linearRegressionLinesContextMenuItemTitle: String = definedExternally
        /**
         *  Title for the "Polynomial Curve" option of the "Regression Lines"
         *   option in the context menu for scatter plots.
         *  @type {HTMLString}
         *  @default "Polynomial Curve"
         */
        var polynomialRegressionLinesContextMenuItemTitle: String = definedExternally
        /**
         *  Title for the "Polynomial Degree..." option of the "Regression Lines"
         *   option in the context menu for scatter plots.
         *  @type {HTMLString}
         *  @default "Polynomial Degree..."
         */
        var polynomialDegreeRegressionLinesContextMenuItemTitle: String = definedExternally
        /**
         *  Message of the prompt created by the "Polynomial Degree..." option in the context menu
         *   for scatter plots to ask the user for a polynomial degree to use for polynomial regression.
         *  @type {string}
         *  @default "Enter a degree for the polynomial regression curve (must be a positive integer):"
         */
        var polynomialDegreePrompt: String = definedExternally
        /**
         *  Warning message issued when an invalid polynomial degree is entered into the prompt dialog created
         *   by the "Polynomial Degree..." option in the context menu for scatter plots.
         *  @type {string}
         *  @default "The regression polynomial degree must be a positive integer."
         */
        var invalidPolynomialDegreeMessage: String = definedExternally
        /**
         *  Title for the "Chart Type" submenu in the context menu for
         *   non-scatter/bubble charts.
         *  @type {HTMLString}
         *  @default "Chart Type"
         */
        var chartTypeContextMenuItemTitle: String = definedExternally
        /**
         *  Title for the "Fill" submenu in the context menu for
         *   non-scatter/bubble charts.
         *  @type {HTMLString}
         *  @default "Fill"
         */
        var fillContextMenuItemTitle: String = definedExternally
        /**
         *  Title for the "Filled" item in the
         *   FacetChart.fillContextMenuItemTitle submenu of the context menu for
         *   non-scatter/bubble charts.
         *  @type {HTMLString}
         *  @default "Filled"
         */
        var fillFilledContextMenuItemTitle: String = definedExternally
        /**
         *  Title for the "Unfilled" item in the
         *   FacetChart.fillContextMenuItemTitle submenu of the context menu for
         *   non-scatter/bubble charts.
         *  @type {HTMLString}
         *  @default "Unfilled"
         */
        var fillUnfilledContextMenuItemTitle: String = definedExternally
        /**
         *  Title for the "Auto" item in the
         *   FacetChart.fillContextMenuItemTitle submenu of the context menu for
         *   non-scatter/bubble charts.
         *  @type {HTMLString}
         *  @default "Auto"
         */
        var fillAutoContextMenuItemTitle: String = definedExternally
        /**
         *  Title for the "Stack" submenu in the context menu for
         *   non-scatter/bubble charts.
         *  @type {HTMLString}
         *  @default "Stack"
         */
        var stackContextMenuItemTitle: String = definedExternally
        /**
         *  Title for the "Stacked" item in the
         *   FacetChart.stackContextMenuItemTitle submenu of the context menu for
         *   non-scatter/bubble charts.
         *  @type {HTMLString}
         *  @default "Stacked"
         */
        var stackStackedContextMenuItemTitle: String = definedExternally
        /**
         *  Title for the "Unstacked" item in the
         *   FacetChart.stackContextMenuItemTitle submenu of the context menu for
         *   non-scatter/bubble charts.
         *  @type {HTMLString}
         *  @default "Unstacked"
         */
        var stackUnstackedContextMenuItemTitle: String = definedExternally
        /**
         *  Title for the "Auto" item in the
         *   FacetChart.stackContextMenuItemTitle submenu of the context menu for
         *   non-scatter/bubble charts.
         *  @type {HTMLString}
         *  @default "Auto"
         */
        var stackAutoContextMenuItemTitle: String = definedExternally
        /**
         *  Title for the "Swap Facets" item in the context menu for
         *   non-scatter/bubble charts.
         *  @type {HTMLString}
         *  @default "Swap Facets"
         */
        var swapFacetsContextMenuItemTitle: String = definedExternally
        /**
         *  Title for the "Area" item in the "Chart Type" submenu in the
         *   context menu.
         *  @type {HTMLString}
         *  @default "Area"
         */
        var chartTypeAreaTitle: String = definedExternally
        /**
         *  Title for the "Column" item in the "Chart Type" submenu in the
         *   context menu.
         *  @type {HTMLString}
         *  @default "Column"
         */
        var chartTypeColumnTitle: String = definedExternally
        /**
         *  Title for the "Bar" item in the "Chart Type" submenu in the
         *   context menu.
         *  @type {HTMLString}
         *  @default "Bar"
         */
        var chartTypeBarTitle: String = definedExternally
        /**
         *  Title for the "Line" item in the "Chart Type" submenu in the
         *   context menu.
         *  @type {HTMLString}
         *  @default "Line"
         */
        var chartTypeLineTitle: String = definedExternally
        /**
         *  Title for the "Radar" item in the "Chart Type" submenu in the
         *   context menu.
         *  @type {HTMLString}
         *  @default "Radar"
         */
        var chartTypeRadarTitle: String = definedExternally
        /**
         *  Title for the "Pie" item in the "Chart Type" submenu in the
         *   context menu.
         *  @type {HTMLString}
         *  @default "Pie"
         */
        var chartTypePieTitle: String = definedExternally
        /**
         *  Title for the "Doughnut" item in the "Chart Type" submenu in the
         *   context menu.
         *  @type {HTMLString}
         *  @default "Doughnut"
         */
        var chartTypeDoughnutTitle: String = definedExternally
        /**
         *  Title for the "Scatter" item in the "Chart Type" submenu in the
         *   context menu.
         *  @type {HTMLString}
         *  @default "Scatter"
         */
        var chartTypeScatterTitle: String = definedExternally
        /**
         *  Title for the "Bubble" item in the "Chart Type" submenu in the
         *   context menu.
         *  @type {HTMLString}
         *  @default "Bubble"
         */
        var chartTypeBubbleTitle: String = definedExternally
        /**
         *  Title for the "Histogram" item in the "Chart Type" submenu in the
         *   context menu.
         *  @type {HTMLString}
         *  @default "Histogram"
         */
        var chartTypeHistogramTitle: String = definedExternally
        /**
         *  Creates a new FacetChart
         * 
         *  @param typeCheckedProperties {Partial<FacetChart>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {FacetChart} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): FacetChart = definedExternally
    }
}