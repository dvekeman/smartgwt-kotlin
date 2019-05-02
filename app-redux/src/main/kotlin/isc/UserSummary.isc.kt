@file:JsQualifier("isc")
package isc

/**
 *  An object representing a user-created and user-modifiable summary, which can be created and
 *   edited with a SummaryBuilder either directly or via the
 *   ListGrid.canAddSummaryFields behavior.
 */
open external class UserSummary {
    /**
     *  Summary to be evaluated.
     * 
     *   There are two contexts where a UserSummary is used: ListGridField.userSummary and
     *   FormItem.textFormula or ListGridField.editorTextFormula. For the grid field
     *   summary all variables used by the summary
     *   must be all-capital letter names surrounded by braces and escaped with a # sign (eg #{A}).
     *   These are derived from field values for the record in question - see UserSummary.summaryVars.
     * 
     *   In the second usage context variables are dot-separated (.) names representing the nested
     *   hierarchy path to the desired value within the Canvas.ruleScope. No
     *   mapping with UserSummary.summaryVars is needed.
     *  @type {string}
     *  @default null
     */
    open var text: String = definedExternally
    /**
     *  Map from the all-capital letter names used as summary variables in the UserSummary
     *   String to the fieldNames these variables should represent in the context where the
     *   summary is evaluated.
     * 
     *   When used in ListGridField.userSummary context, field names are evaluated against the
     *   grid record.
     * 
     *   When used in FormItem.textFormula or ListGridField.editorTextFormula this property
     *   is not used for summary mapping. Instead, field names are evaluated directly against the
     *   current Canvas.ruleScope.
     *  @type {Map<any>}
     *  @default null
     */
    open var summaryVars: Map<dynamic> = definedExternally
}