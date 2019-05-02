@file:JsQualifier("isc")
package isc

/**
 *  StateTask can either copy fields of Process.state to other fields, or apply hardcoded
 *   values to Process.state via StateTask.value.
 * 
 *   Some examples:
 * 
 * 
 *  - inputField: "a", outputField: "b" - copies "a" to "b"
 * 
 *  - inputField: "a", outputField: "b", type: "integer" - copies "a" to "b" converting "a" to an integer
 * 
 *  - inputFieldList: ["a","b"], outputField: ["c","d"] - copies "a" and "b" to "c" and "d" respectively.
 * 
 */
open external class StateTask : Task {
    /**
     *  If a stateTask does not declare Task.inputField, it must declare a value
     *   which should be assigned to the output field.
     * 
     *   See StateTask.type for how the value is interpreted.
     *  @type {any}
     *  @default null
     */
    open var value: dynamic = definedExternally
    /**
     *  Type of the value for stateTask.outputField.
     * 
     *   This can be used in conjunction with StateTask.value to declare the type of the
     *   value, or can be used to convert the type of the Task.inputField to
     *   the declared type.
     * 
     *   If no type is declared, the value from an inputField is unchanged or provided via a call
     *   to setValue() is unchanged.
     * 
     *   A value specified for stateTask.value via an attribute in
     *   componentXML (see Process.loadProcess) is treated as a boolean if
     *   it is the exact string "true" or "false", treated as a "decimal" or "integer" if it
     *   parsable as a valid number, otherwise treated as a String. If these heuristics don't
     *   work in your case, just declare the type explicitly via stateTask.type.
     * 
     *   A value of "record" type or "array" type can be declared in Component XML using the same
     *   formats allowed for DataSourceField.valueMap. Each array value or
     *   record attribute value undergoes the same heuristics as for StateTask.value
     *   declared as an attribute.
     * 
     *   StateTask.type is invalid to use with multiple outputFields.
     *  @type {ProcessValueType}
     *  @default null
     */
    open var type: 
                   /**
                    *  values that are not already strings are converted via toString()
                    *  the strings "true" and "false" become boolean true and false. All other         Strings non-empty String values are true, all numbers are true except 0, and
                    *           all other non-null values are true
                    *  values are converted via toString() and parsing as a decimal number.         Invalid values trigger a transition to the StateTask.failureElement
                    *  values are converted via toString(), parsing as a number, and rounding to         nearest integer. Invalid values trigger a transition to the
                    *           StateTask.failureElement
                    *  any input which is not already a Record or Map becomes null
                    *  generic array type - will convert value to an array of the same type as the        existing value
                    */
                   String /* string |  boolean |  decimal |  integer |  record |  array */ = definedExternally
    /**
     *  ID of the next sequence or element to proceed to if a failure condition arises, such as
     *   the output data not being convertible to the target StateTask.type.
     *  @type {string}
     *  @default null
     */
    open var failureElement: String = definedExternally
    /**
     *  Not applicable to a StateTask.
     *  @type {string}
     *  @default null
     */
    override var outputExpression: String = definedExternally
    companion object {
        /**
         *  Creates a new StateTask
         * 
         *  @param typeCheckedProperties {Partial<StateTask>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {StateTask} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): StateTask = definedExternally
    }
}