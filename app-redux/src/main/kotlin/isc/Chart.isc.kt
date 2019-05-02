@file:JsQualifier("isc")
package isc

external interface Chart {
    var valueProperty: String
    var data: dynamic
    var facets: dynamic
    var stacked: Boolean
    var chartType: 
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
                   String /* Area |  Column |  Bar |  Line |  Radar |  Pie |  Doughnut |  Scatter |  Bubble |  Histogram */
    var valueTitle: String
    var title: String
    var subTitle: String
    var threeD: Boolean
    var shouldAnimateShow: Boolean
    var labelValues: Boolean
    fun setupChart (): Unit
    fun getFacet (facetId: String): Facet
    fun getFacetValue (facetId: String, facetValueId: String): FacetValue
    fun getValue (criteria: FacetValueMap): dynamic
    fun setData (newData: dynamic): Unit
}