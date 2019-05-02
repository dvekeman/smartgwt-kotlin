@file:JsQualifier("isc")
package isc

/**
 *  Validator definition for a built-in Validator.type.
 */
open external class ValidatorDefinition {
    /**
     *  Type of the validator unique in ValidatorType.
     *  @type {string}
     *  @default null
     */
    open var type: String = definedExternally
    /**
     *  Optional name to be shown in tools that edit validators. If not specified,
     *   the tools will derive the short name from the ValidatorDefinition.type by assuming it is
     *   camelCaps similar to DataSource.getAutoTitle.
     *  @type {string}
     *  @default null
     */
    open var shortName: String = definedExternally
    /**
     *  Does this validator only run server-side?
     *  @type {boolean}
     *  @default false
     */
    open var requiresServer: Boolean = definedExternally
    /**
     *  Default error message to be shown when validator fails validation. Can be overridden
     *   for an individual validator by setting Validator.errorMessage.
     *  @type {string}
     *  @default null
     */
    open var defaultErrorMessage: String = definedExternally
    /**
     *  Callback, function or JavaScript expression invoked to perform the actual validation
     *   of a value.
     * 
     *   Because the validator itself is passed as a parameter, you can effectively parameterize it.
     *   For example, to create a validator that checks that the value is after a certain date:
     *     { type:"custom", afterDate:new Date(), 
     *      condition:"value.getTime() > validator.afterDate.getTime()" }
     * 
     *   Note that, if a field is declared with a builtin FieldType, the value passed in
     *   will already have been converted to the specified type, if possible.
     * 
     *   For the required parameters, see the documentation for
     *   Callbacks.ValidatorConditionCallback.
     *  @type {StringMethod | ValidatorConditionCallback}
     *  @default null
     */
    open var condition: dynamic = definedExternally
    /**
     *  Callback, function, or JavaScript expression called after every validation (i.e. call
     *   to ValidatorDefinition.condition) whether it passed or failed. This allows the
     *   validator perform an operation on the field based on the validation outcome.
     * 
     *   An action() function is not needed to report an error message only.
     * 
     *   For the required parameters, see the documentation for
     *   Callbacks.ValidatorActionCallback.
     *  @type {StringMethod | ValidatorActionCallback}
     *  @default null
     */
    open var action: dynamic = definedExternally
}