@file:JsQualifier("isc")
package isc

/**
 *  A TestFunctionResult is an ordinary JavaScript Object with properties that indicate the
 *   status of an attempt to generate and execute a function for FormulaBuilder and
 *   it's subclasses.
 * 
 *   Because TestFunctionResult is always an ordinary JavaScript Object, it supports the
 *   normal behaviors of JavaScript Objects, including accessing and assigning to properties
 *   via dot notation:
 * 
 *     var propValue = testFunctionResult.propName;
 *     testFunctionResult.propName = newValue;
 * 
 * 
 */
open external class TestFunctionResult {
    /**
     *  Set to true if there is a syntax error in the formula or summary being checked.
     * 
     *   When set to true, TestFunctionResult.errorText contains the exception message.
     *  @type {boolean}
     *  @default false
     */
    open var failedGeneration: Boolean = definedExternally
    /**
     *  Set to true if calling the formula or summary format resulted in a JavaScript Error.
     *   This would generally indicate a reference to non-existent data values. See
     *   TestFunctionResult.failedGeneration for other types of failure.
     * 
     *   When set to true, TestFunctionResult.errorText contains the exception message.
     *  @type {boolean}
     *  @default false
     */
    open var failedExecution: Boolean = definedExternally
    /**
     *  Set to true if the formula or summary definition passed in was empty.
     *  @type {boolean}
     *  @default false
     */
    open var emptyTestValue: Boolean = definedExternally
    /**
     *  If the formula or summary format caused a JavaScript error, this contains the JavaScript error text.
     *  @type {string}
     *  @default null
     */
    open var errorText: String = definedExternally
    /**
     *  When a formula or summary format is valid, result contains the result returned by the
     *   generated function when it was executed.
     *  @type {string}
     *  @default null
     */
    open var result: String = definedExternally
    /**
     *  Set to the record that was used when testing the generated function. This is the record
     *   selected by FormulaBuilder.getTestRecord.
     *  @type {Record}
     *  @default null
     */
    open var record: Record = definedExternally
}