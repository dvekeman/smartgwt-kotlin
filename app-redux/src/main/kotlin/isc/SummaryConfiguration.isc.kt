@file:JsQualifier("isc")
package isc

/**
 *  Settings for use with SimpleType.applySummaryFunction.
 */
open external class SummaryConfiguration {
    /**
     *  The field value to treat as the bad result of a user formula or summary evaluation.
     *   If a summary function actually uses the value (rather than say "count"), this usually
     *   means that the value will simply be skipped rather than voiding evaluation of the
     *   entire summary.
     *  @type {string}
     *  @default "."
     */
    open var badFormulaResultValue: String = definedExternally
    /**
     *  The field value to treat as an invalid value from a summary row (see
     *   ListGrid.showGridSummary or ListGrid.showGroupSummary) or as an invalid value
     *   in a summary-type field (see ListGridFieldType).
     *   If a summary function actually uses the value (rather than say "count"), this usually
     *   means that the value will simply be skipped rather than voiding evaluation of the
     *   entire summary.
     *  @type {string}
     *  @default "&amp;nbsp;"
     */
    open var invalidSummaryValue: String = definedExternally
}