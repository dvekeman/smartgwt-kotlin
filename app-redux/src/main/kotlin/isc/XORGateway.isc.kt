@file:JsQualifier("isc")
package isc

/**
 *  Chooses one or another next process element based on AdvancedCriteria applied to
 *   Process.state.
 * 
 *   If the AdvancedCriteria evaluate to true, the XORGateway.nextElement is
 *   chosen, otherwise the XORGateway.failureElement.
 * 
 *   Note that "XOR" in XORGateway means "exclusive or" - only one next element is
 *   chosen.
 */
open external class XORGateway : ProcessElement {
    /**
     *  Simple or AdvancedCriteria to be applied against the Process.state.
     * 
     *   Data values in this criteria prefixed with "$" will be treated as dynamic expressions
     *   as detailed in taskInputExpression. Specifically, this means that for
     *   simple criteria, any property value that is a String and is prefixed with "$" will be
     *   assumed to be an expression, and for AdvancedCriteria, the same treatment will be
     *   applied to Criterion.value.
     * 
     *   Note that dynamic expressions starting with "$input" are not applicable
     *   for an XORGateway but "$inputRecord" can be used for direct reference to Process.state.
     * 
     *   This property supports dynamicCriteria - use Criterion.valuePath
     *   to refer to values in the Process.ruleScope.
     *  @type {Criteria}
     *  @default null
     */
    open var criteria: dynamic = definedExternally
    /**
     *  Next Process.sequences or Process.elements to execute
     *   if the criteria match the process state.
     * 
     *   nextElement does not need to be specified if this gateway is part of a
     *   Process.sequences and has a next element in the sequence.
     * 
     *   Note that if there is both a sequence and a normal element
     *   with the same name in the current Process, the sequence will
     *   be used.
     *  @type {string}
     *  @default null
     */
    override var nextElement: String = definedExternally
    /**
     *  ID of the next sequence or element to proceed to if the criteria do not match.
     *  @type {string}
     *  @default null
     */
    open var failureElement: String = definedExternally
    companion object {
        /**
         *  Creates a new XORGateway
         * 
         *  @param typeCheckedProperties {Partial<XORGateway>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {XORGateway} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): XORGateway = definedExternally
    }
}