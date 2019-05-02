@file:JsQualifier("isc")
package isc

/**
 *  Chooses a next element in a Process by evaluating a series of criteria against the
 *   Process.state and choosing the element associated with the criteria that matched, or
 *   a DecisionGateway.defaultElement if none of the criteria match.
 */
open external class DecisionGateway : ProcessElement {
    /**
     *  A Map from ProcessElement.ID to Criteria that will cause this ProcessElement to
     *   be chosen as the next element if the criteria matches.
     * 
     *   If no criteria is matched the next element is DecisionGateway.defaultElement or the workflow
     *   is finished.
     * 
     *   Data values in this criteria prefixed with "$" will be treated as dynamic expressions
     *   as detailed in taskInputExpression. Specifically, this means that for
     *   simple criteria, any property value that is a String and is prefixed with "$" will be
     *   assumed to be an expression, and for AdvancedCriteria, the same treatment will be
     *   applied to Criterion.value.
     * 
     *   Note that dynamic expressions starting with "$input" are not applicable
     *   for an DecisionGateway but "$inputRecord" can be used for direct reference to Process.state.
     * 
     *   This property supports dynamicCriteria - use Criterion.valuePath
     *   to refer to values in the Process.ruleScope.
     *  @type {Map<Criteria>}
     *  @default null
     */
    open var criteriaMap: Map<dynamic> = definedExternally
    /**
     *  Next element to pick if no criteria match. If this gateway is part of a
     *   Process.sequences and has a next element in the sequence, the
     *   defaultElement is assumed to be the next element and does not need to be
     *   specified.
     *  @type {string}
     *  @default null
     */
    open var defaultElement: String = definedExternally
    /**
     *  Not applicable to a DecisionGateway.
     *  @type {string}
     *  @default null
     */
    override var nextElement: String = definedExternally
    companion object {
        /**
         *  Creates a new DecisionGateway
         * 
         *  @param typeCheckedProperties {Partial<DecisionGateway>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DecisionGateway} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DecisionGateway = definedExternally
    }
}