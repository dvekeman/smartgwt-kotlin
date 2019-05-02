@file:JsQualifier("isc")
package isc

/**
 *  An object representing a user-created and user-modifiable formula, which can be created and
 *   edited with a FormulaBuilder either directly or via the
 *   ListGrid.canAddFormulaFields behavior.
 */
open external class UserFormula {
    /**
     *  Formula to be evaluated.
     * 
     *   There are two contexts where a UserFormula is used: ListGridField.userFormula and
     *   FormItem.formula or ListGridField.editorFormula. For the grid field formula
     *   all variables used by the formula must be single-letter capital characters (eg A). These
     *   are derived from field values for the record in question - see UserFormula.formulaVars.
     * 
     *   In addition to these variables, the keyword record may be used to
     *   refer directly to the record for which the formula is being displayed.
     * 
     *   In the second usage context variables are dot-separated (.) names representing the nested
     *   hierarchy path to the desired value within the Canvas.ruleScope. No
     *   mapping with UserFormula.formulaVars is needed.
     *  @type {string}
     *  @default null
     */
    open var text: String = definedExternally
    /**
     *  Object mapping from variable names to fieldNames. All variable names must be single-letter
     *   capital characters (eg A). For example, for a formula that should divide the field
     *   "population" over the field "area", the formula might be "E/L" and formula vars would be:
     * 
     * 
     *    {
     *      E: "population",
     *      L: "area"
     *    }
     * 
     * 
     * 
     * 
     *   When used in ListGridField.userFormula context, field names are evaluated against the
     *   grid record.
     * 
     *   When used in FormItem.formula or ListGridField.editorFormula this property is
     *   not used for formula mapping. Instead, field names are evaluated directly against the
     *   current Canvas.ruleScope.
     *  @type {Map<any>}
     *  @default null
     */
    open var formulaVars: Map<dynamic> = definedExternally
}