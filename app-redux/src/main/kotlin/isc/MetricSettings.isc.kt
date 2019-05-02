@file:JsQualifier("isc")
package isc

/**
 *  Defines a set of properties that are applicable to
 *   FacetChart.extraAxisMetrics of a FacetChart.
 * 
 *   These properties behave identically to the same-named properties of FacetChart. Two
 *   exceptions are the properties
 *   MetricSettings.gradationLineProperties and
 *   MetricSettings.gradationZeroLineProperties
 *   because they are used to draw tick marks along an extra value axis instead of lines
 *   through the chart rectangle. Also the default behavior of the
 *   MetricSettings.dataColors property is different, in that the
 *   default is to use unused colors from, and in the order of, the
 *   FacetChart.dataColors.
 * 
 *   The extra value axes that are not positioned directly adjacent to the
 *   FacetChart.showChartRect of the FacetChart may additionally
 *   have an axis line to connect the gradation tick marks. Whether to draw this
 *   line is controlled by the MetricSettings.showAxisLine property,
 *   and the properties of the line are specified using
 *   MetricSettings.axisLineProperties. The default is to draw
 *   the axis lines whenever the chart rect. is drawn and to draw the line using the same
 *   properties as the lines of the chart rect. (for example, lineColor and lineWidth).
 * 
 *   The extra value axis charts may be
 *   MetricSettings.multiFacet charts. If the underlying
 *   FacetChart.data is multi-facet then the extra value axes may use the facet
 *   whose values are labelled on the data axis or the facet used to create the legend (the
 *   first and second facets, respectively). Both types of charts vary the first facet to
 *   get a data series to plot. Multi-facet charts also vary the second facet, but
 *   single-facet charts keep the second facet fixed at a constant FacetValue.
 * 
 *   The exact facet value to use for the second facet is specified using the
 *   MetricSettings.fixedFacetValue property.
 */
open external class MetricSettings {
    /**
     *  Whether this extra value axis plots values while varying the facet values of just the
     *   first facet (single-facet) or both first and second facets (multi-facet).
     *  @type {boolean}
     *  @default true
     */
    open var multiFacet: Boolean = definedExternally
    /**
     *  For a MetricSettings.multiFacet chart of an extra value axis, this property provides a constant facet value
     *   for the second facet. By varying the value of the other facet in multi-facet data, the chart
     *   obtains the series of values to plot. The default facet value is the first facet value of the second facet.
     *  @type {string | number}
     *  @default null
     */
    open var fixedFacetValue: dynamic = definedExternally
    /**
     *  For MetricSettings.multiFacet charts embedded in a multi-facet main
     *   chart, the legendLabel defines the text of the legend label for this chart.
     *   The default text is the FacetValue.title of the metric facet value of this
     *   value axis concatenated with the FacetValue.title of the
     *   MetricSettings.fixedFacetValue in parentheses. Set the
     *   legendLabel to provide custom text for the legend label.
     *  @type {string}
     *  @default null
     */
    open var legendLabel: String = definedExternally
    /**
     *  Whether to show the extra value axis.
     *  @type {boolean}
     *  @default null
     */
    open var showAxis: Boolean = definedExternally
    /**
     *  When this property is set to the metric of another MetricSettings object, the extra
     *   value axis and chart corresponding to these settings will use the same scale for the
     *   gradations as the extra value axis and chart of the other MetricSettings object. The
     *   value of matchGradations can only be one of the metrics of the metric
     *   facet whose values will be displayed by the chart.
     *  @type {string}
     *  @default null
     */
    open var matchGradations: String = definedExternally
    /**
     *  Whether to show an axis line for this extra value axis if it is not placed
     *   directly adjacent to the chart rect. The default setting is the value
     *   of the FacetChart.showChartRect property of the FacetChart.
     *  @type {boolean}
     *  @default null
     */
    open var showAxisLine: Boolean = definedExternally
    /**
     *  Properties for the axis line drawn if this extra value axis is not positioned
     *   directly adjacent to the chart rect. The default is to match the
     *   DrawItem.lineCap, DrawItem.lineColor,
     *   DrawItem.lineOpacity, DrawItem.linePattern,
     *   and DrawItem.lineWidth of the FacetChart's
     *   FacetChart.chartRectProperties for each axis line.
     *  @type {DrawLine}
     *  @default null
     */
    open var axisLineProperties: DrawLine = definedExternally
    /**
     *  A label for the data values, such as "Sales in Thousands", typically used as the label for
     *   the value axis.
     *  @type {string}
     *  @default null
     */
    open var valueTitle: String = definedExternally
    /**
     *  Whether to show the MetricSettings.valueTitle (or, in the case of
     *   MetricSettings.proportional,
     *   MetricSettings.proportionalAxisLabel) as a label on this extra value axis.
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
     *  See ChartType for a list of known types - Column, Bar, Line, Pie, Doughnut,
     *   Area, Radar, and Histogram charts are supported.
     *  @type {ChartType}
     *  @default null
     */
    open var chartType: 
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
     *  If the ChartType is "Column" then the metric settings may include
     *   a setting for FacetChart.stacked.
     * 
     *  @type {boolean}
     *  @default null
     */
    open var stacked: Boolean = definedExternally
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
     *   MetricSettings.stacked mode. Stacked columns will be as tall as the chart rect and
     *   stacked bars will be as wide as the chart rect. Area and Radar charts will be
     *   completely filled except for facet values where all values are 0.
     *  @type {boolean}
     *  @default null
     */
    open var proportional: Boolean = definedExternally
    /**
     *  Default title for the value axis label when the chart is in
     *   MetricSettings.proportional. This title will be used unless the
     *   FacetChart.getLegendFacet defines a
     *   Facet.proportionalTitle.
     *  @type {string}
     *  @default "Percent"
     */
    open var proportionalAxisLabel: String = definedExternally
    /**
     *  Same as FacetChart.minDataSpreadPercent but affects only one metric. Default of
     *   null means that the chart-wide setting facetChart.minDataSpreadPercent
     *   will be used.
     *  @type {Integer}
     *  @default null
     */
    open var minDataSpreadPercent: Number = definedExternally
    /**
     *  Same as FacetChart.axisStartValue but affects only one metric.
     *  @type {Float}
     *  @default null
     */
    open var axisStartValue: Number = definedExternally
    /**
     *  Same as FacetChart.xAxisEndValue but affects only one metric.
     *  @type {Float}
     *  @default null
     */
    open var xAxisEndValue: Number = definedExternally
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
     *  For Line, Area, Radar, Scatter or Bubble charts, whether to show data points for each
     *   individual data value.
     * 
     *   If shown, the MetricSettings.pointClick and MetricSettings.getPointHoverHTML APIs can be used to create
     *   interactivity.
     *  @type {boolean}
     *  @default false
     */
    open var showDataPoints: Boolean = definedExternally
    /**
     *  Size in pixels for data points drawn for line, area, radar and other chart types.
     *  @type {Integer}
     *  @default "6"
     */
    open var dataPointSize: Number = definedExternally
    /**
     *  Common properties to apply for all data points (see MetricSettings.showDataPoints).
     *  @type {DrawItem}
     *  @default null
     */
    open var dataPointProperties: DrawItem = definedExternally
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
     *   Default gradations can be overridden via MetricSettings.logBase and MetricSettings.logGradations.
     *  @type {boolean}
     *  @default false
     */
    open var useLogGradations: Boolean = definedExternally
    /**
     *  When MetricSettings.useLogGradations, base value for logarithmic gradation lines. Gradation
     *   lines will be shown at every power of this value plus intervening values specified by
     *   MetricSettings.logGradations.
     *  @type {Integer}
     *  @default "10"
     */
    open var logBase: Number = definedExternally
    /**
     *  When MetricSettings.useLogGradations is set, gradation lines to show in between powers,
     *   expressed as a series of integer or float values between 1 and MetricSettings.logBase.
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
     *  The FacetChart.decimalPrecision used to render the numeric labels of this metric axis.
     *  @type {Integer}
     *  @default "2"
     */
    open var decimalPrecision: Number = definedExternally
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
     *  Should data values be shown as text labels near the shape representing the value, for example,
     *   above columns of a column chart, or adjacent to points in a line chart?
     * 
     *   If set to false, then data values will not be shown.
     * 
     *   If set to true, data values will be shown unless the data density is high enough that
     *   labels will potentially overlap, in which case, data values will not be shown and
     *   hovers will be shown instead, in the same way as MetricSettings.showValueOnHover shows hovers.
     *  @type {boolean}
     *  @default null
     */
    open var showDataValues: Boolean = definedExternally
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
     *  @param {Float} the value to be drawn.
     */
    open fun getYCoord(value: Number): Number = definedExternally
    /**
     *   Return an array of the gradation values used in the current chart. Pass these values
     *   to MetricSettings.getXCoord / MetricSettings.getYCoord (depending on the orientation of the chart)
     *   to discover the coordinates where gradations are drawn.
     * 
     *   This is only allowed to be called when FacetChart.chartDrawn fires.
     * 
     * 
     */
    open fun getGradations(): Array<dynamic> = definedExternally
    /**
     *   Method to change the current ChartType.
     *   Will redraw the chart if drawn.
     *   Will use default settings for the new chart type for MetricSettings.stacked
     *   and MetricSettings.filled if those values are null.
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
     *   Method to change MetricSettings.stacked. Use null to
     *   apply a default value for the current ChartType.
     * 
     * 
     *  @param {boolean} new value
     */
    open fun setStacked(stacked: Boolean): Unit = definedExternally
    /**
     *   Method to change MetricSettings.filled.
     *   Use null to apply a default value for the current ChartType.
     * 
     * 
     *  @param {boolean} new value
     */
    open fun setFilled(filled: Boolean): Unit = definedExternally
    /**
     *   Setter for MetricSettings.proportional.
     * 
     *  @param {boolean} Whether the chart should now use proportional mode.
     */
    open fun setProportional(proportional: Boolean): Unit = definedExternally
    /**
     *   Setter for MetricSettings.dataColors.
     * 
     *  @param {Array<Partial<CSSColor>>} New set of data colors
     */
    open fun setDataColors(dataColors: Array<dynamic>): Unit = definedExternally
    /**
     *   Get a color from the MetricSettings.dataColors Array.
     * 
     * 
     *   Override to provide a dynamic color generation scheme - must return a color in the format of
     *   of a leading hash (#) plus 6 hexadecimal digits as specified for MetricSettings.dataColors.
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
     *   defined or null is returned, the Framework will default to value of MetricSettings.getDataColor.
     * 
     * 
     *   Note that this method is simply an override point, since it has no default implementation -
     *   must return a color in the format of of a leading hash (#) plus 6 hexadecimal digits as
     *   specified for MetricSettings.dataColors.
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
     *   Get a gradient from the MetricSettings.dataGradients Array.
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
     *   When MetricSettings.showDataPoints is true, fires when a point is clicked on.
     * 
     * 
     *  @param {Float} the value at the point
     *  @param {Record} the record at the point
     *  @param {string} the ID of the metric at the point
     */
    open fun pointClick(value: Number, record: Record, metricId: String): Unit = definedExternally
    /**
     *   When MetricSettings.showDataPoints is true and the mouse hovers over a point, this method is called
     *   and may return HTML to show in a hover.
     * 
     * 
     *  @param {Float} the value at the point
     *  @param {Record} the record at the point
     *  @param {string} the ID of the metric at the point
     */
    open fun getPointHoverHTML(value: Number, record: Record, metricId: String): String = definedExternally
    /**
     *   Return the text string to display in MetricSettings.gradationLabelProperties
     *   given the raw value for the metric to show on the value axis. This formatter will only
     *   be called if the axis has gradation labels, meaning labels drawn at regular intervals not
     *   associated with any particular facet value.
     * 
     *   Note that the rendering of values in hovers or via MetricSettings.showDataValues is handled by
     *   MetricSettings.formatDataValue.
     * 
     *  @param {any} raw value of the metric
     */
    open fun formatAxisValue(value: dynamic): String = definedExternally
    /**
     *   Return the text string to display in MetricSettings.showValueOnHover or via MetricSettings.showDataValues
     *   given the raw value for the metric displayed on the value axis.
     * 
     *   Note that the rendering of values for gradation labels is handled by
     *   MetricSettings.formatAxisValue.
     * 
     *  @param {any} raw value of the metric
     */
    open fun formatDataValue(value: dynamic): String = definedExternally
}