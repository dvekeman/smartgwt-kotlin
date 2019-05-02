@file:JsQualifier("isc")
package isc

/**
 *  A validator describes a check that should be performed on a value the user is trying to
 *   save.
 * 
 *   Validators are specified for DataSource fields via the DataSourceField.validators
 *   property. Validators that need not be run on the server can also be specified for a
 *   specific FormItem or ListGridField.
 * 
 *   SmartClient supports a powerful library of ValidatorType which
 *   have identical behavior on both the client and the server.
 * 
 *   Beyond this, custom validators can be defined on the client and custom validation logic
 *   added on the server. Note that the regexp and mask validator
 *   types are very flexible and can be used to perform virtually any kind of formatting check
 *   that doesn't involve some large external dataset.
 * 
 *   Custom validators can be reused on the client by adding them to the global validator list,
 *   via the Validator.addValidator method.
 */
open external class Validator : Class {
    /**
     *  Type of the validator.
     * 
     *   This can be one of the built-in ValidatorType, the string "custom" to define
     *   a custom validator, or the string "serverCustom" to define a server-only custom validator.
     *  @type {ValidatorType | string}
     *  @default null
     */
    open var type: dynamic = definedExternally
    /**
     *  Used to create a conditional validator based on AdvancedCriteria.
     *   The criteria defines when the validator applies. The form current values or ListGrid record
     *   is used as reference for the criteria. If the criteria match, then the validator will be
     *   processed. Otherwise the validator is skipped and assumed valid.
     * 
     *   To use an applyWhen criteria the form or grid must use a DataSource.
     * 
     *   NOTE: applyWhen is not supported for "binary" fields.
     * 
     *   Server and client use
     *   Conditional validators are enforced both on the server and on the client-side
     *   when defined on a DataSource field as shown in the examples below. Note the
     *   applyWhen element is treated as a Criterion.
     * 
     *   &lt;!-- Normal format --&gt;
     *   &lt;field name="age" type="integer"&gt;
     *    &lt;validators&gt;
     *     &lt;validator type="integerRange" min="0" max="100"&gt;
     *      &lt;applyWhen operator="or"&gt;
     *       &lt;criteria&gt;
     *        &lt;criterion fieldName="restrictAge" operator="equals" value="true"/&gt;
     *        &lt;criterion fieldName="gender" operator="equals" value="female"/&gt;
     *       &lt;/criteria&gt;
     *      &lt;/applyWhen&gt;
     *     &lt;/validator&gt;
     *    &lt;/validators&gt;
     *   &lt;/field&gt;
     * 
     *   &lt;!-- Conditional requirement --&gt;
     *   &lt;field name="reason" type="text"&gt;
     *    &lt;validators&gt;
     *     &lt;validator type="required"&gt;
     *      &lt;applyWhen fieldName="willAttend" operator="equals" value="false"/&gt;
     *     &lt;/validator&gt;
     *    &lt;/validators&gt;
     *   &lt;/field&gt;
     * 
     *   The last example above shows an alternate to the requiredIf validator
     *   using a xmlCriteriaShorthand which is only available
     *   for client-side use. On the client the reason
     *   field will change appearance to match other required or non-required fields when
     *   willAttend changes. Please see the discussion of conditionally required
     *   fields in the DataSourceField.required documentation for important information
     *   about additional complexities that can be introduced.
     * 
     *   Component XML and client-only use
     *   Conditional validators can also be applied to componentXML
     *   similarly to provide client-only validations or read-only state management. A common
     *   use case is conditionally displaying or enabling fields. Use the readOnly
     *   validator with an applyWhen value to control the read-only appearance of a
     *   field. The example below shows a field which is hidden when willAttend=true.
     * 
     *   &lt;!-- field definition within a Component XML DynamicForm --&gt;
     *   &lt;field name="reason" type="text"&gt;
     *    &lt;validators&gt;
     *     &lt;validator type="readOnly" fieldAppearance="hidden"&gt;
     *      &lt;applyWhen fieldName="willAttend" operator="equals" value="true"/&gt;
     *     &lt;/validator&gt;
     *    &lt;/validators&gt;
     *   &lt;/field&gt;
     * 
     * 
     *   Conditional validators can be applied to DynamicForm or ListGrid fields in
     *   JavaScript code as well.
     *  @type {AdvancedCriteria}
     *  @default null
     */
    open var applyWhen: AdvancedCriteria = definedExternally
    /**
     *  User-defined list of fields on which this validator depends. Primarily used for validators
     *   of type "custom" but can also be used to supplement Validator.applyWhen criteria.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var dependentFields: Array<dynamic> = definedExternally
    /**
     *  For a validator that is not a built-in ValidatorType, a Callback,
     *   function, or JavaScript expression to evaluate to see if this validator passes or fails.
     * 
     *   Because the validator declaration itself is passed as a parameter to
     *   condition(), you can effectively parameterize the validator. For example, to
     *   create a validator that checks that the value is after a certain date:
     *     { type:"custom", afterDate:new Date(), 
     *      condition:"value.getTime() > validator.afterDate.getTime()" }
     * 
     *   Reusable validators, like the above, can be registered as a standard validatorType by
     *   calling Validator.addValidator.
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
     *  For validators of type "serverCustom" only: a scriptlet in any supported JSR223 scripting
     *   language which is run in order to see if validation passes. For example:
     * 
     * 
     *     &lt;validator type="serverCustom"&gt;
     *       &lt;serverCondition language="groovy"&gt;&lt;![CDATA[
     *         value &lt; dataSources.StockItem.fetchById(record.itemId).quantity
     *       ]]&gt;&lt;/serverCondition&gt;
     *     &lt;/validator&gt;
     * 
     *   The scriptlet should return a boolean true or false value - failing to return a value will
     *   be considered a false result (validator failed). If your expression is syntactically
     *   invalid, an exception is thrown and the error message is displayed in the client.
     * 
     *   See serverScript for general information on Server Scripting and JSR223, and
     *   velocitySupport for general information on Velocity support, and also see below
     *   for special rules for Velocity.
     * 
     *   Available variables
     *   The following variables are available in a serverCondition:
     * 
     * 
     *  - dataSource - The current DataSource
     * 
     *  - record - Other submitted values part of the same update
     * 
     *  - value - The value of the field
     * 
     *  - validator - The config of this validator, including all attributes declared on
     *              the &lt;validator&gt; tag, presented as a Map
     * 
     *  - field - The field (as a DSField object)
     * 
     *   Note that "record" will contain only other values submitted at the same time, not the
     *   complete DataSource record. For most types of cross-field validation, you should fetch the
     *   current saved record using the server-side API DataSource.fetchById(). For example, in
     *   Velocity:
     * 
     *     $dataSource.fetchById($record.primaryKeyField).otherFieldName
     * 
     *   Note that, while a DSRequest provides dsRequest.oldValues, these values cannot be relied
     *   upon for a security check since they could be faked.
     * 
     *   Server-side custom validators also have access to the standard set of context variables that
     *   come from the Servlet API. However, be aware that if you write conditions that depend upon
     *   these variables, you preclude your Validator from being used in the widest possible variety
     *   of circumstances; for example, in a command-line process. Rather, it will be tied to
     *   operating in the context of, say, an HttpSession.
     * 
     *   Given the above caveat, the following context variables are also available:
     * 
     * 
     *  - servletRequest - The associated HttpServletRequest
     * 
     *  - session - The associated HttpSession
     * 
     *  - httpParameters - This variable gives you access to the parameters Map
     *       of the associated HttpServletRequest; it is an alternate form of
     *       $servletRequest.getParameter
     * 
     *  - requestAttributes - This variable gives you access to the attributes Map
     *       of the associated HttpServletRequest; it is an alternate form of
     *       $servletRequest.getAttribute
     * 
     *  - sessionAttributes - This variable gives you access to the attributes Map
     *       of the associated HttpSession; it is an alternate form of
     *       $session.getAttribute
     * 
     * 
     *   Special considerations for Velocity
     * 
     *   To return a true or false value in Velocity, you script can either be just an expression
     *   that returns a boolean value, or the result of evaluating the Velocity template can result
     *   in output of "true" or "false". All of the following are valid forms:
     * 
     *   &nbsp;&nbsp;$value &lt; 100
     *   &nbsp;&nbsp;$util.contains($value, "some string")
     *   &nbsp;&nbsp;$record.someField(assuming that "someField" contains a boolean value)
     *   &nbsp;&nbsp;$value &gt; $record.otherField
     * 
     *   For additional troubleshooting information when Velocity expressions aren't working as
     *   expected, set the log category org.apache.Velocity to DEBUG in log4j.isc.config.xml.
     * 
     *   Because it's tricky to call arbitrary Java methods in Velocity, the following special
     *   objects are passed to Velocity for convenience:
     * 
     * 
     *  - dataSources - The list of all DataSources, accessible by name (so, for example,
     *     $dataSources.supplyItem refers to the supplyItem DataSource
     *     object).
     * 
     *  - util - A com.isomorphic.util.DataTools object, giving you access to
     *          all of that class's useful helper functions
     * 
     *  @type {string}
     *  @default null
     */
    open var serverCondition: String = definedExternally
    /**
     *  For validators of type "serverCustom" only, a ServerObject declaration that allows
     *   the SmartClient Server to find a Java class via a variety of possible approaches, and call a
     *   method on it to perform validation.
     * 
     *   The target object must implement a method whose first 4 arguments are:
     * 
     *    Object value, Validator validator, String fieldName, Map record
     * 
     *   (com.isomorphic.datasource.Validator is a subclass of Map that
     *   represents a validator's configuration, and also provides APIs for implementing templated
     *   error messages).
     *   You provide the name of the method to call by specifying
     *   ServerObject.methodName
     *   as part of the serverObject declaration. If you do not specify a methodName, SmartClient
     *   expects to find a compliant method called "condition".
     * 
     *   Additional arguments may be declared and are automatically supplied based on the declared
     *   argument type, via dmiOverview. Available objects include:
     * 
     * 
     *  - DataSource - the DataSource where this validator is declared, an instance of
     *               com.isomorphic.datasource.DataSource or a subclass
     * 
     *  - HttpServletRequest - from standard Java servlets API
     * 
     *  - HttpServletResponse - from standard Java servlets API
     * 
     *  - ServletContext - from standard Java servlets API
     * 
     *  - HttpSession - from standard Java servlets API
     * 
     *  - RequestContext - an instance of com.isomorphic.servlet.RequestContext
     * 
     *  - RPCManager - the RPCManager associated with the transaction this validation is
     *               part of; an instance of com.isomorphic.rpc.RPCManager
     * 
     *  - DSRequest - the DSRequest this validation is part of; an instance of com.isomorphic.datasource.DSRequest
     * 
     *  - DSField - the datasource field which value is validated; an instance of com.isomorphic.datasource.DSField
     * 
     *  - ValidationContext - the context where value is validated; an instance of com.isomorphic.datasource.ValidationContext
     * 
     *   Note that any servlet-related objects will not be available if your validator is run outside
     *   of the scope of an HTTP servlet request, such as a command-line process.
     * 
     *   Note that "record" will contain only other values submitted at the same time, not the
     *   complete DataSource record. For most types of cross-field validation, you should fetch the
     *   current saved record. For example:
     * 
     *     final Map existingRecord = dataSource.fetchById(record);
     * 
     *  @type {ServerObject}
     *  @default null
     */
    open var serverObject: ServerObject = definedExternally
    /**
     *  To transform the incoming value that is validated into a different value or format set this
     *   property from Validator.condition to the desired value.
     *  @type {object}
     *  @default null
     */
    open var resultingValue: dynamic = definedExternally
    /**
     *  Text to display if the value does not pass this validation check.
     * 
     *   If unspecified, default error messages exist for all built-in validators, and a generic
     *   message will be used for a custom validator that is not passed.
     *  @type {string}
     *  @default null
     */
    open var errorMessage: String = definedExternally
    /**
     *  Normally, all validators defined for a field will be run even if one of the validators has
     *   already failed. However, if stopIfFalse is set, validation will not proceed
     *   beyond this validator if the check fails.
     * 
     *   This is useful to prevent expensive validators from being run unnecessarily, or to allow
     *   custom validators that don't need to be robust about handling every conceivable type of
     *   value.
     *  @type {boolean}
     *  @default false
     */
    open var stopIfFalse: Boolean = definedExternally
    /**
     *  Indicates that if this validator is not passed, the user should not be allowed to exit
     *   the field - focus will be forced back into the field until the error is corrected.
     * 
     *   This property defaults to FormItem.stopOnError if unset.
     * 
     *   Enabling this property also implies FormItem.validateOnExit is automatically
     *   enabled. If this is a server-based validator, setting this property also implies that
     *   FormItem.synchronousValidation is forced on.
     *  @type {boolean}
     *  @default null
     */
    open var stopOnError: Boolean = definedExternally
    /**
     *  Indicates this validator runs on the client only.
     * 
     *   Normally, if the server is trying to run validators and finds a validator that it can't
     *   execute, for safety reasons validation is considered to have failed. Use this flag to
     *   explicitly mark a validator that only needs to run on the client.
     *  @type {boolean}
     *  @default false
     */
    open var clientOnly: Boolean = definedExternally
    /**
     *  If true, validator will be validated when each item's "change" handler is fired
     *   as well as when the entire form is submitted or validated. If false, this validator
     *   will not fire on the item's "change" handler.
     * 
     *   Note that this property can also be set at the form/grid or field level;
     *   If true at any level and not explicitly false on the validator, the validator will be
     *   fired on change - displaying errors and rejecting the change on validation failure.
     *  @type {boolean}
     *  @default null
     */
    open var validateOnChange: Boolean = definedExternally
    /**
     *  Applies only to the "isUnique" validator and controls
     *   whether the search for existing records is case sensitive or not.
     *  @type {boolean}
     *  @default false
     */
    open var caseSensitive: Boolean = definedExternally
    /**
     *  Applies only to the "isUnique" validator; allows you to name a specific
     *   DataSource.operationBindings for the uniqueness check.
     *  @type {string}
     *  @default null
     */
    open var operationId: String = definedExternally
    /**
     *  Indicates this validator runs on the server only.
     *  @type {boolean}
     *  @default null
     */
    open var serverOnly: Boolean = definedExternally
    companion object {
        /**
         *  Default error message to display when standard isBoolean type validator
         *   returns false.
         *  @type {string}
         *  @default "Must be a true/false value"
         */
        var notABoolean: String = definedExternally
        /**
         *  Default error message to display when standard isString type validator
         *   returns false.
         *  @type {string}
         *  @default "Must be a string."
         */
        var notAString: String = definedExternally
        /**
         *  Default error message to display when standard isInteger type validator
         *   returns false.
         *  @type {string}
         *  @default "Must be a whole number."
         */
        var notAnInteger: String = definedExternally
        /**
         *  Default error message to display when standard isFloat type validator
         *   returns false.
         *  @type {string}
         *  @default "Must be a valid decimal."
         */
        var notADecimal: String = definedExternally
        /**
         *  Default error message to display when standard isDate type validator
         *   returns false.
         *  @type {string}
         *  @default "Must be a date."
         */
        var notADate: String = definedExternally
        /**
         *  Default error message to display when standard integerRange type validator
         *   returns false because the value passed in is greater than the specified maximum.
         *   This is a dynamic string - text within &#36;{...} will be evaluated as JS code
         *   when the message is displayed, with max and min available as
         *   variables mapped to validator.max and validator.min.
         *  @type {string}
         *  @default "Must be no more than ${max}"
         */
        var mustBeLessThan: String = definedExternally
        /**
         *  Default error message to display when standard integerRange type validator
         *   returns false because the value passed in is less than the specified minimum.
         *   This is a dynamic string - text within &#36;{...} will be evaluated as JS code
         *   when the message is displayed, with max and min available as
         *   variables mapped to validator.max and validator.min.
         *  @type {string}
         *  @default "Must be at least ${min}"
         */
        var mustBeGreaterThan: String = definedExternally
        /**
         *  Default error message to display when standard dateRange type validator
         *   returns false because the value passed in is greater than the specified maximum date.
         *   This is a dynamic string - text within &#36;{...} will be evaluated as JS code
         *   when the message is displayed, with max and min available as
         *   variables mapped to validator.max and validator.min.
         *  @type {string}
         *  @default "Must be later than ${min}"
         */
        var mustBeLaterThan: String = definedExternally
        /**
         *  Default error message to display when standard timeRange type validator
         *   returns false because the time-portion of the date-value passed in is less than the
         *   specified minimum time.
         *   This is a dynamic string - text within &#36;{...} will be evaluated as JS code
         *   when the message is displayed, with max and min available as
         *   variables mapped to validator.max and validator.min.
         *  @type {string}
         *  @default "Must be later than ${isc.Time.toShortTime(min)}"
         */
        var mustBeLaterThanTime: String = definedExternally
        /**
         *  Default error message to display when standard dateRange type validator
         *   returns false because the value passed in is less than the specified maximum date.
         *   This is a dynamic string - text within &#36;{...} will be evaluated as JS code
         *   when the message is displayed, with max and min available as
         *   variables mapped to validator.max and validator.min.
         *  @type {string}
         *  @default "Must be earlier than ${max}"
         */
        var mustBeEarlierThan: String = definedExternally
        /**
         *  Default error message to display when standard timeRange type validator
         *   returns false because the time-portion of the date-value passed in is greater than the
         *   specified minimum time.
         *   This is a dynamic string - text within &#36;{...} will be evaluated as JS code
         *   when the message is displayed, with max and min available as
         *   variables mapped to validator.max and validator.min.
         *  @type {string}
         *  @default "Must be earlier than ${isc.Time.toShortTime(max)}"
         */
        var mustBeEarlierThanTime: String = definedExternally
        /**
         *  Default error message to display when standard lengthRange type validator
         *   returns false because the value passed in has more than validator.max characters.
         *   This is a dynamic string - text within &#36;{...} will be evaluated as JS code
         *   when the message is displayed, with max and min available as
         *   variables mapped to validator.max and validator.min.
         *  @type {string}
         *  @default "Must be no more than ${max} characters"
         */
        var mustBeShorterThan: String = definedExternally
        /**
         *  Default error message to display when standard lengthRange type validator
         *   returns false because the value passed in has fewer than validator.min characters.
         *   This is a dynamic string - text within &#36;{...} will be evaluated as JS code
         *   when the message is displayed, with max and min available as
         *   variables mapped to validator.max and validator.min.
         *  @type {string}
         *  @default "Must be at least ${min} characters"
         */
        var mustBeLongerThan: String = definedExternally
        /**
         *  Default error message to display when standard lengthRange type validator
         *   has validator.max and validator.min set to the same value,
         *   and returns false because the value passed is not the same length as these limits.
         *   This is a dynamic string - text within &#36;{...} will be evaluated as JS code
         *   when the message is displayed, with max and min available as
         *   variables mapped to validator.max and validator.min.
         *  @type {string}
         *  @default "Must be exactly ${max} characters"
         */
        var mustBeExactLength: String = definedExternally
        /**
         *  Default error message to display when validation fails for a field marked as required
         *   or with a standard required type validator.
         *   The message is also displayed for a field with a standard requiredIf type
         *   validator whose condition evaluates to true, because the field has no value.
         *  @type {string}
         *  @default 'Field is required'
         */
        var requiredField: String = definedExternally
        /**
         *  Default error message to display when standard isOneOf type validator
         *   is not passed.
         *  @type {string}
         *  @default 'Not a valid option'
         */
        var notOneOf: String = definedExternally
        /**
         *  Default error message to display when the standard maxFileSize type validator
         *   returns false.
         *  @type {HTMLString}
         *  @default "Size of '${fileName}' (${isc.NumberUtil.toMiBString(fileSize, maxFileSize)} MiB) exceeds maximum allowed file size of ${isc.NumberUtil.toMiBString(maxFileSize, fileSize)} MiB."
         */
        var maxFileSizeExceeded: String = definedExternally
        /**
         *  A declared value of the enum type
         *   FieldAppearance.
         *  @type {Constant}
         *  @default "readOnly"
         */
        var READONLY: String = definedExternally
        /**
         *  A declared value of the enum type
         *   FieldAppearance.
         *  @type {Constant}
         *  @default "hidden"
         */
        var HIDDEN: String = definedExternally
        /**
         *  A declared value of the enum type
         *   FieldAppearance.
         *  @type {Constant}
         *  @default "disabled"
         */
        var DISABLED: String = definedExternally
        /**
         *  Creates a new Validator
         * 
         *  @param typeCheckedProperties {Partial<Validator>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Validator} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Validator = definedExternally
        /**
         *   Add a new validator type that can be specified as Validator.type anywhere
         *   validators are declared, such as DataSourceField.validators or
         *   FormItem.validators.
         * 
         *   The condition argument should be a method of the same signature as
         *   Validator.condition.
         * 
         *   This method is essentially a shortcut for building a ValidatorDefinition object
         *   and passing that to Validator.addValidatorDefinition
         * 
         * 
         *  @param {string} type name for the new validator
         *  @param {ValidatorConditionCallback} callback, function or expression to                  evaluate to determine whether validation was successful
         */
        fun addValidator(type: String, condition: ((item: dynamic, validator: Validator, value: dynamic, record: dynamic, additionalContext: dynamic) -> Unit)): Unit = definedExternally
        /**
         *   Add several new validator types at once, as though Validator.addValidator were called
         *   several times.
         * 
         * 
         *  @param {object} Set of validators to add. This parameter should   be a JavaScript object where the property names are validator type names, and the    property values are condition functions or expressions, for example:    &nbsp;&nbsp;&nbsp;{type1:condition1, type2:condition2}.
         */
        fun addValidators(newValidators: dynamic): Unit = definedExternally
        /**
         *   Add a new validator type that can be specified as Validator.type anywhere
         *   validators are declared, such as DataSourceField.validators or
         *   FormItem.validators.
         * 
         * 
         *  @param {string} type name for the new validator
         *  @param {ValidatorDefinition} the validator definition
         */
        fun addValidatorDefinition(type: String, definition: ValidatorDefinition): Unit = definedExternally
        /**
         *   Add several new validator types at once, as though Validator.addValidatorDefinition
         *   were called several times.
         * 
         * 
         *  @param {object} Set of validators to add. This parameter should   be a JavaScript object where the property names are validator type names, and the    property values are ValidatorDefinitions.
         */
        fun addValidatorDefinitions(newDefinitions: dynamic): Unit = definedExternally
    }
}