@file:JsQualifier("isc")
package isc

/**
 *  Allows the user to pick from pre-set date ranges or choose a custom date range via a
 *   DateRangeDialog.
 * 
 *   To use this item in the ListGrid.showFilterEditor or
 *   FilterBuilder, create a trivial ClassFactory.defineClass which
 *   defines PresetCriteriaItem.options, then set
 *   ListGridField.filterEditorType to use this class with the FilterEditor, or define a
 *   custom operator and set Operator.editorType to use it with the FilterBuilder.
 * 
 *   See the ${isc.DocUtils.linkForExampleId('dateRangeFilterPresets', 'Date Range (Presets)')} example for sample code.
 */
open external class PresetDateRangeItem : PresetCriteriaItem {
    /**
     *   Get the criterion based on the value selected by the user.
     * 
     * 
     */
    override fun getCriterion(): dynamic = definedExternally
    companion object {
        /**
         *  Creates a new PresetDateRangeItem
         * 
         *  @param typeCheckedProperties {Partial<PresetDateRangeItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {PresetDateRangeItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): PresetDateRangeItem = definedExternally
    }
}