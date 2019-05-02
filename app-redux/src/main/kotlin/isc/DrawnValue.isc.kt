@file:JsQualifier("isc")
package isc

/**
 *  Returns information about how a data value is rendered in a chart.
 */
open external class DrawnValue {
    /**
     *  X coordinate where the data value is rendered. In pie mode, returns the X coordinate of the
     *   center of the pie where the data value appears.
     *  @type {Integer}
     *  @default null
     */
    open var x: Number = definedExternally
    /**
     *  Y coordinate where the data value is rendered. In pie mode, returns the Y coordinate of the
     *   center of the pie where the data value appears.
     *  @type {Integer}
     *  @default null
     */
    open var y: Number = definedExternally
    /**
     *  For pie mode only, start angle of the segment for the data value.
     *  @type {Integer}
     *  @default null
     */
    open var startAngle: Number = definedExternally
    /**
     *  For pie mode only, start angle of the segment for the data value.
     *  @type {Integer}
     *  @default null
     */
    open var endAngle: Number = definedExternally
    /**
     *  For pie mode only, the radius of the segment for the data value.
     *  @type {Double}
     *  @default null
     */
    open var radius: Number = definedExternally
    /**
     *  For bar and column charts, thickness of the bar representing this data value.
     *  @type {Integer}
     *  @default null
     */
    open var barThickness: Number = definedExternally
    /**
     *  Data value this drawnValue represents.
     *  @type {Float}
     *  @default null
     */
    open var value: Number = definedExternally
    /**
     *  FacetValues for the data value.
     *  @type {FacetValueMap}
     *  @default null
     */
    open var facetValues: FacetValueMap = definedExternally
    /**
     *  The data record of the data point from which this drawnValue was created.
     * 
     *   Note that a chart with an Facet.inlinedValues or a
     *   FacetChart.extraAxisMetrics may define multiple data points in
     *   the same record, each of which will correspond to a different drawnValue.
     *   The way to uniquely identify the data value of this particular drawnValue
     *   is to use the DrawnValue.facetValues.
     *  @type {CellRecord}
     *  @default null
     */
    open var record: CellRecord = definedExternally
}