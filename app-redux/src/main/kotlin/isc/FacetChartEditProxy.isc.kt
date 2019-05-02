@file:JsQualifier("isc")
package isc

/**
 *  EditProxy that handles FacetChart when editMode is enabled.
 */
open external class FacetChartEditProxy : DrawPaneEditProxy {
    /**
     *  If InlineEditEvent for this chart edits the
     *   FacetChart.data, character that should be used as a separator between
     *   values, or between pairs of label vs values.
     * 
     *   The FacetChartEditProxy.dataEscapeChar can be used to enter the separator
     *   char as part of a field name or value.
     *  @type {string}
     *  @default ","
     */
    open var dataSeparatorChar: String = definedExternally
    /**
     *  If InlineEditEvent for this chart edits the
     *   FacetChart.data, character that should be used as a separator for
     *   entering label vs value entries.
     * 
     *   With the default of ":", the following input defines four values with titles:
     * 
     *     North:10, South:20, East:30, West:40
     * 
     * 
     *   The FacetChartEditProxy.dataEscapeChar can be used to enter literal colon characters.
     *  @type {string}
     *  @default ":"
     */
    open var dataDisplaySeparatorChar: String = definedExternally
    /**
     *  If InlineEditEvent for this chart edits the
     *   FacetChart.data, character that can be used to enter literal separator
     *   chars (such as the FacetChartEditProxy.dataSeparatorChar).
     * 
     *   Repeat this character twice to enter it literally. For example, with the default
     *   of "\", inputting "\\" would result in a literal backslash in the value.
     *  @type {string}
     *  @default "\"
     */
    open var dataEscapeChar: String = definedExternally
    /**
     *   Returns the text based on the current component state to be edited inline.
     *   Called by the EditProxy.inlineEditForm to obtain the starting edit value.
     * 
     * 
     */
    override fun getInlineEditText(): Unit = definedExternally
    /**
     *   Save the new value into the component's state. Called by the
     *   EditProxy.inlineEditForm to commit the change.
     * 
     *   Updates the component's facets and data.
     * 
     *   Lines starting with "--" or "==" are considered titles. A single title
     *   is used as the chart title. Titles are matched to the next series of
     *   data. If titles are provided for each series, a legend will be shown.
     * 
     *   Series data can be entered as a list of values separated by commas
     *   (see FacetChartEditProxy.dataSeparatorChar) or as a valueMap-style
     *   list of label:value pairs. The first data series defines the
     *   number of chart values and the titles, if provided.
     * 
     * 
     *  @param {string} the new component data
     */
    override fun setInlineEditText(newValue: String): Unit = definedExternally
    companion object {
        /**
         *  Creates a new FacetChartEditProxy
         * 
         *  @param typeCheckedProperties {Partial<FacetChartEditProxy>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {FacetChartEditProxy} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): FacetChartEditProxy = definedExternally
    }
}