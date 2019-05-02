@file:JsQualifier("isc")
package isc

/**
 *  An object representing a criterion to apply to a record.
 * 
 *   A criterion is part of the definition of an AdvancedCriteria object, which is used to
 *   filter records according to search criteria.
 * 
 *   A criterion consists of an Criterion.operator and typically a
 *   DataSourceField.name from a
 *   Record and a Criterion.value to compare to. However some operators
 *   either don't require a value (eg, isNull) or act on other criteria rather than directly on a
 *   Record's fields (eg, the "and" and "or" logical operators).
 * 
 *   A shortcut form is also allowed where only fieldName and value
 *   values are provided. In this case the operator is assumed to be "equals".
 */
open external class Criterion {
    /**
     *  Operator this criterion applies.
     *  @type {OperatorId}
     *  @default null
     */
    open var operator: 
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
     *  Name of the field in each Record that this criterion applies to. Not applicable for a
     *   criterion with Criterion.criteria. Can be specified as a dataPath to
     *   allow matching nested objects. Use '/' as delimiters for dataPath. See
     *   DataPath for more information.
     *  @type {string}
     *  @default null
     */
    open var fieldName: String = definedExternally
    /**
     *  Value to be used in the application of this criterion.
     * 
     *   Value may be required or not required, or may be an Array, according to the
     *   OperatorValueType of the operator.
     *  @type {any}
     *  @default null
     */
    open var value: dynamic = definedExternally
    /**
     *  Wherever dynamicCriteria are supported, valuePath can be
     *   specified as a path in the current Canvas.ruleScope as an alternative to setting a fixed
     *   Criterion.value.
     * 
     *   Note: valuePath vs setting a path for Criterion.fieldName:
     * 
     * 
     *  - use a path for criterion.fieldName when criteria will be matched against a
     *     nested data structure.
     * 
     *  - use criterion.valuePath when the values used in filtering should be
     *     dynamically derived based on the Canvas.ruleScope. This does not imply that the
     *     criteria will be matched against a nested structure.
     * 
     *  @type {string}
     *  @default null
     */
    open var valuePath: String = definedExternally
    /**
     *  For a criterion with an operator that acts on other criteria (eg "and", "or"), a list of
     *   sub-criteria that are grouped together by the operator.
     *  @type {Array<Partial<Criterion>>}
     *  @default null
     */
    open var criteria: Array<dynamic> = definedExternally
    /**
     *  Start value of a criterion with an operator of type "valueRange".
     *  @type {any}
     *  @default null
     */
    open var start: dynamic = definedExternally
    /**
     *  End value of a criterion with an operator of type "valueRange".
     *  @type {any}
     *  @default null
     */
    open var end: dynamic = definedExternally
}