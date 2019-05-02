@file:JsQualifier("isc")
package isc

/**
 *  Specification of an operator for use in filtering, for example "equals".
 *   Use with DataSource.addSearchOperator to define custom filtering behaviors for
 *   client-side filtering.
 */
open external class Operator {
    /**
     *  Unique id for an operator, which appears within AdvancedCriteria as the
     *   Operator property.
     * 
     *   A list of built-in identifiers is OperatorId.
     *  @type {OperatorId}
     *  @default null
     */
    open var ID: 
                 /**
                  *  exactly equal to
                  *  not equal to
                  *  exactly equal to, if case is disregarded
                  *  not equal to, if case is disregarded
                  *  Greater than
                  *  Less than
                  *  Greater than or equal to
                  *  Less than or equal to
                  *  Contains as sub-string (match case)
                  *  Starts with (match case)
                  *  Ends with (match case)
                  *  Contains as sub-string (case insensitive)
                  *  Starts with (case insensitive)
                  *  Ends with (case insensitive)
                  *  Does not contain as sub-string (match case)
                  *  Does not start with (match case)
                  *  Does not end with (match case)
                  *  Does not contain as sub-string (case insensitive)
                  *  Does not start with (case insensitive)
                  *  Does not end with (case insensitive)
                  *  shortcut for "greaterThan" + "and" + "lessThan" (case insensitive)
                  *  shortcut for "greaterOrEqual" + "and" + "lessOrEqual" (case insensitive)
                  *  Basic GLOB matching using wildcards    (see DataSource.translatePatternOperators for more information on available patterns)
                  *  Basic GLOB matching using wildcards (case insensitive)    (see DataSource.translatePatternOperators for more information on available patterns)
                  *  GLOB matching using wildcards. Value is considered to meet the    criterion if it contains the pattern. See DataSource.translatePatternOperators
                  *      for more information on available patterns)
                  *  GLOB mathcing using wildcards. Value is considered to meet the    criterion if it starts with the pattern.See DataSource.translatePatternOperators
                  *      for more information on available patterns)
                  *  GLOB mathcing using wildcards. Value is considered to meet the    criterion if it starts with the pattern.See DataSource.translatePatternOperators
                  *      for more information on available patterns)
                  *  GLOB matching using wildcards. Value is considered to meet the    criterion if it contains the pattern. Matching is case insensitive. See
                  *      DataSource.translatePatternOperators for more information on available patterns)
                  *  GLOB matching using wildcards. Value is considered to meet the    criterion if it starts with the pattern. Matching is case insensitive.See
                  *      DataSource.translatePatternOperators for more information on available patterns)
                  *  GLOB matching using wildcards.Value is considered to meet the    criterion if it ends with the pattern. Matching is case insensitive. See
                  *      DataSource.translatePatternOperators for more information on available patterns)
                  *  Regular expression match
                  *  Regular expression match (case insensitive)
                  *  value is either null or the empty string. For numeric fields it behaves as isNull
                  *  value is neither null nor the empty string ("")
                  *  value is null
                  *  value is non-null. Note empty string ("") is non-null
                  *  value is in a set of values. Specify criterion.value as an Array
                  *  value is not in a set of values. Specify criterion.value as an Array
                  *  matches another field (match case, specify fieldName as criterion.value)
                  *  does not match another field (match case, specify fieldName as criterion.value)
                  *  matches another field (case insensitive, specify fieldName as criterion.value)
                  *  does not match another field (case insensitive, specify fieldName as criterion.value)
                  *  Greater than another field (specify fieldName as criterion.value)
                  *  Less than another field (specify fieldName as criterion.value)
                  *  Greater than or equal to another field    (specify fieldName as criterion.value)
                  *  Less than or equal to another field    (specify fieldName as criterion.value)
                  *  Contains as sub-string (match case) another field value    (specify fieldName as criterion.value)
                  *  Starts with (match case) another field value    (specify fieldName as criterion.value)
                  *  Ends with (match case) another field value    (specify fieldName as criterion.value)
                  *  Contains as sub-string (case insensitive) another field value    (specify fieldName as criterion.value)
                  *  Starts with (case insensitive) another field value    (specify fieldName as criterion.value)
                  *  Ends with (case insensitive) another field value    (specify fieldName as criterion.value)
                  *  Does not contain as sub-string (match case) another field value    (specify fieldName as criterion.value)
                  *  Does not start with (match case) another field value    (specify fieldName as criterion.value)
                  *  Does not end with (match case) another field value    (specify fieldName as criterion.value)
                  *  Does not contain as sub-string (case insensitive) another field value    (specify fieldName as criterion.value)
                  *  Does not start with (case insensitive) another field value    (specify fieldName as criterion.value)
                  *  Does not end with (case insensitive) another field value    (specify fieldName as criterion.value)
                  *  all subcriteria (criterion.criteria) are true
                  *  all subcriteria (criterion.criteria) are false
                  *  at least one subcriteria (criterion.criteria) is true
                  *  shortcut for "greaterThan" + "lessThan" + "and". Specify criterion.start     and criterion.end
                  *  shortcut for "greaterOrEqual" + "lessOrEqual" + "and". Specify     criterion.start and criterion.end
                  */
                 String /* equals |  notEqual |  iEquals |  iNotEqual |  greaterThan |  lessThan |  greaterOrEqual |  lessOrEqual |  contains |  startsWith |  endsWith |  iContains |  iStartsWith |  iEndsWith |  notContains |  notStartsWith |  notEndsWith |  iNotContains |  iNotStartsWith |  iNotEndsWith |  iBetween |  iBetweenInclusive |  matchesPattern |  iMatchesPattern |  containsPattern |  startsWithPattern |  endsWithPattern |  iContainsPattern |  iStartsWithPattern |  iEndsWithPattern |  regexp |  iregexp |  isBlank |  notBlank |  isNull |  notNull |  inSet |  notInSet |  equalsField |  notEqualField |  iEqualsField |  iNotEqualField |  greaterThanField |  lessThanField |  greaterOrEqualField |  lessOrEqualField |  containsField |  startsWithField |  endsWithField |  iContainsField |  iStartsWithField |  iEndsWithField |  notContainsField |  notStartsWithField |  notEndsWithField |  iNotContainsField |  iNotStartsWithField |  iNotEndsWithField |  and |  not |  or |  between |  betweenInclusive */ = definedExternally
    /**
     *  User-visible title for this operator, such as "doesn't contain".
     * 
     *   To simplify internationalization by separating titles from operator code, you can use
     *   specify Operator.titleProperty instead of this property.
     *  @type {string}
     *  @default null
     */
    open var title: String = definedExternally
    /**
     *  Name of a property on the Operators class that provides the title for this operator.
     *  @type {Identifier}
     *  @default null
     */
    open var titleProperty: String = definedExternally
    /**
     *  User-visible title for this operator when used with text-based fields - eg,
     *   "equals (match case)" rather than just "equals".
     * 
     *   To simplify internationalization by separating titles from operator code, you can use
     *   specify Operator.textTitleProperty instead of this property.
     *  @type {string}
     *  @default null
     */
    open var textTitle: String = definedExternally
    /**
     *  Name of a property on the Operators class that provides the title for this operator
     *   when used with text-based fields.
     *  @type {Identifier}
     *  @default null
     */
    open var textTitleProperty: String = definedExternally
    /**
     *  List of types that this Operator is valid for.
     * 
     *   If omitted, the operator is assumed to be valid for all FieldTypes unless a list of
     *   FieldTypes is passed to DataSource.addSearchOperator.
     *  @type {Array<Partial<FieldType>>}
     *  @default null
     */
    open var fieldTypes: Array<dynamic> = definedExternally
    /**
     *  Whether this operator needs to be executed on the server side.
     * 
     *   This implies that if a Criterion using this operator is either introduced into
     *   AdvancedCriteria or is changed, the server will need to be contacted to
     *   perform filtering.
     *  @type {boolean}
     *  @default false
     */
    open var requiresServer: Boolean = definedExternally
    /**
     *  Whether this operator should be offered to users by default in interfaces such as the
     *   FilterBuilder.
     * 
     *   Setting hidden:true means the operator can be used in a programmatic search, for example,
     *   by calling ResultSet.setCriteria, but does not appear in the UI.
     *  @type {boolean}
     *  @default false
     */
    open var hidden: Boolean = definedExternally
    /**
     *  Indicates the kind of value expected in a Criterion that uses this operator.
     *   OperatorValueType lists possibilities.
     * 
     *   The default of null is equivalent to "fieldType", indicating that
     *   Criterion.value is expected to contain a value of the same type as the field
     *   indicated by Criterion.fieldName.
     *  @type {OperatorValueType}
     *  @default null
     */
    open var valueType: 
                        /**
                         *  Criterion.value should contain a value of the same type as the          field.
                         *  Criterion.value should be the name of another field in the record
                         *  no criterion.value or other setting required (used for operators like          isBlank or isNull).
                         *  Criterion.criteria should be an Array of criteria (used for logical          operators like "and").
                         *  Criterion.start and Criterion.end should contain start and           end values, both of the same type as the field.
                         *  Criterion.value should contain an Array of valid field values.
                         *  Criterion.value should contain a value which is not necessarily the         same type as the field (used for regexp and similar operators).
                         *           Operator.editorType can be specified as a FormItem to use to
                         *           enter a value for the criterion.
                         */
                        String /* fieldType |  fieldName |  none |  criteria |  valueRange |  valueSet |  custom */ = definedExternally
    /**
     *  For an operator with Operator.valueType:"custom", indicates what kind of FormItem to use to
     *   provide a user interface for creating a valid Criterion. The default of
     *   null means an ordinary TextItem is fine.
     *  @type {FormItemClassName}
     *  @default null
     */
    open var editorType: String = definedExternally
    /**
     *  The text use when using this operator as an
     *   FormItem.allowExpressions in a FormItem.
     *  @type {string}
     *  @default null
     */
    open var symbol: String = definedExternally
    /**
     *   Method which actually evaluates whether a given record meets a Criterion.
     * 
     *   For operators that act on Criterion.criteria, call
     *   DataSource.evaluateCriterion to evaluate sub-criteria.
     * 
     *   Because criteria are sometimes applied to user-entered data that has not been validated, a
     *   robust condition() function should expect that data found in a Record
     *   may be null, NaN, not the correct type (eg "NA" for a type:"date" field) or otherwise out of
     *   the expected range.
     * 
     *   Note that an Operator has access both to the Criterion object, allowing operators
     *   that act on more than one field or perform calculations, and access to the Operator
     *   object itself, allowing a condition() function to be shared across a range of
     *   related operators with different OperatorIds.
     * 
     * 
     *  @param {any} value from the field supplied as Criterion.fieldName, if  applicable
     *  @param {Record} record being evaluated
     *  @param {any} fieldName supplied as Criterion.fieldName, if applicable
     *  @param {Criterion} criterion definition
     *  @param {Operator} operator definition
     */
    open fun condition(value: dynamic, record: Record, fieldName: dynamic, criterion: Criterion, operator: Operator): Boolean = definedExternally
    /**
     *   Compare two criteria, both of which use this operator, and report whether the newCriteria is
     *   definitely more restrictive than the previous criteria.
     * 
     *   This is used by the ResultSet to understand whether client-side filtering can
     *   continue using cached data, or whether server-side filtering must be used instead.
     * 
     * 
     *  @param {Criterion} new criterion
     *  @param {Criterion} previous criterion
     */
    open fun compareCriteria(newCriterion: Criterion, oldCriterion: Criterion): Number = definedExternally
    /**
     *   In combination with Operator.editorType, this override point allows you to define a
     *   client-side only Operator that simply provides a custom UI for creating a Criterion based on
     *   one of the built-in operators.
     * 
     *   For example, the "between" operator allows AdvancedCriteria to be created that can select any
     *   date range, however in a given application certain specific date ranges might be more
     *   meaningful (eg "next week", "last quarter") and you might want to offer the user a picker for
     *   those date ranges. You could create an operator "presetDateRange" with an editorType
     *   indicating a custom SelectItem that shows available ranges, and then implement
     *   operation.getCriterion() to take the value from this SelectItem and produce a Criterion
     *   selecting the chosen date range.
     * 
     *   Note that another approach, if it's not required that this custom interface appear in the
     *   FilterBuilder, is just to have a separate DynamicForm for picking special date
     *   ranges, and use DataSource.combineCriteria to merge the criteria with the
     *   FilterBuilder's criteria, as in ${isc.DocUtils.linkForExampleId('dynamicReporting', 'this sample')}.
     * 
     *   If not implemented, returns the result of calling
     *   FormItem.getCriterion on the passed FormItem.
     * 
     * 
     * \* @param {FieldName} \* @param {FormItem} 
     */
    open fun getCriterion(fieldName: String, item: FormItem): Criterion = definedExternally
}