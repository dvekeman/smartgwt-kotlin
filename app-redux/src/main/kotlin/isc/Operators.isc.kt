@file:JsQualifier("isc")
package isc

/**
 *  The Operators class provides a collection of class-level properties that can be used to
 *   modify the descriptions associated with the logical Operators used in
 *   AdvancedCriteria. This is primarily intended for internationalization.
 * 
 *   To add or override an operator's description, use
 *   Operators.Class.addClassProperties. For example:
 * 
 *   Operators.addClassProperties({lessOrEqualTitle: "Less than or equal to"});
 */
open external class Operators : Class {
    companion object {
        /**
         *  Title for the "equals" operator
         *  @type {string}
         *  @default "equals (match case)"
         */
        var equalsTitle: String = definedExternally
        /**
         *  Title for the "iEquals" operator
         *  @type {string}
         *  @default "equals"
         */
        var iEqualsTitle: String = definedExternally
        /**
         *  Title for the "notEqual" operator
         *  @type {string}
         *  @default "not equal (match case)"
         */
        var notEqualTitle: String = definedExternally
        /**
         *  Title for the "iNotEqual" operator
         *  @type {string}
         *  @default "not equal"
         */
        var iNotEqualTitle: String = definedExternally
        /**
         *  Title for the "greaterThan" operator
         *  @type {string}
         *  @default "greater than"
         */
        var greaterThanTitle: String = definedExternally
        /**
         *  Title for the "lessThan" operator
         *  @type {string}
         *  @default "less than"
         */
        var lessThanTitle: String = definedExternally
        /**
         *  Title for the "greaterOrEqual" operator
         *  @type {string}
         *  @default "greater than or equal to"
         */
        var greaterOrEqualTitle: String = definedExternally
        /**
         *  Title for the "lessOrEqual" operator
         *  @type {string}
         *  @default "less than or equal to"
         */
        var lessOrEqualTitle: String = definedExternally
        /**
         *  Title for the "between" operator
         *  @type {string}
         *  @default "between (match case)"
         */
        var betweenTitle: String = definedExternally
        /**
         *  Title for the "iBetween" operator
         *  @type {string}
         *  @default "between"
         */
        var iBetweenTitle: String = definedExternally
        /**
         *  Title for the "betweenInclusive" operator
         *  @type {string}
         *  @default "between (inclusive, match case)"
         */
        var betweenInclusiveTitle: String = definedExternally
        /**
         *  Title for the "iBetweenInclusive" operator
         *  @type {string}
         *  @default "between (inclusive)"
         */
        var iBetweenInclusiveTitle: String = definedExternally
        /**
         *  Title for the "startsWith" operator
         *  @type {string}
         *  @default "starts with (match case)"
         */
        var startsWithTitle: String = definedExternally
        /**
         *  Title for the "iStartsWith" operator
         *  @type {string}
         *  @default "starts with"
         */
        var iStartsWithTitle: String = definedExternally
        /**
         *  Title for the "endsWith" operator
         *  @type {string}
         *  @default "ends with (match case)"
         */
        var endsWithTitle: String = definedExternally
        /**
         *  Title for the "iEndsWith" operator
         *  @type {string}
         *  @default "ends with"
         */
        var iEndsWithTitle: String = definedExternally
        /**
         *  Title for the "contains" operator
         *  @type {string}
         *  @default "contains (match case)"
         */
        var containsTitle: String = definedExternally
        /**
         *  Title for the "iContains" operator
         *  @type {string}
         *  @default "contains"
         */
        var iContainsTitle: String = definedExternally
        /**
         *  Title for the "notContains" operator
         *  @type {string}
         *  @default "does not contain (match case)"
         */
        var notContainsTitle: String = definedExternally
        /**
         *  Title for the "iNotContains" operator
         *  @type {string}
         *  @default "does not contain"
         */
        var iNotContainsTitle: String = definedExternally
        /**
         *  Title for the "notStartsWith" operator
         *  @type {string}
         *  @default "does not start with (match case)"
         */
        var notStartsWithTitle: String = definedExternally
        /**
         *  Title for the "iNotStartsWith" operator
         *  @type {string}
         *  @default "does not start with"
         */
        var iNotStartsWithTitle: String = definedExternally
        /**
         *  Title for the "notEndsWith" operator
         *  @type {string}
         *  @default "does not end with (match case)"
         */
        var notEndsWithTitle: String = definedExternally
        /**
         *  Title for the "iNotEndsWith" operator
         *  @type {string}
         *  @default "does not end with"
         */
        var iNotEndsWithTitle: String = definedExternally
        /**
         *  Title for the "regexp" operator
         *  @type {string}
         *  @default "matches expression (match case)"
         */
        var regexpTitle: String = definedExternally
        /**
         *  Title for the "iregexp" operator
         *  @type {string}
         *  @default "matches expression"
         */
        var iregexpTitle: String = definedExternally
        /**
         *  Title for the "matchesPattern" operator
         *  @type {string}
         *  @default "matches pattern (match case)"
         */
        var matchesPatternTitle: String = definedExternally
        /**
         *  Title for the "iMatchesPattern" operator
         *  @type {string}
         *  @default "matches pattern"
         */
        var iMatchesPatternTitle: String = definedExternally
        /**
         *  Title for the "containsPattern" operator
         *  @type {string}
         *  @default "contains pattern (match case)"
         */
        var containsPatternTitle: String = definedExternally
        /**
         *  Title for the "iContainsPattern" operator
         *  @type {string}
         *  @default "contains pattern"
         */
        var iContainsPatternTitle: String = definedExternally
        /**
         *  Title for the "equalsField" operator
         *  @type {string}
         *  @default "matches other field (match case)"
         */
        var equalsFieldTitle: String = definedExternally
        /**
         *  Title for the "iEqualsField" operator
         *  @type {string}
         *  @default "matches other field"
         */
        var iEqualsFieldTitle: String = definedExternally
        /**
         *  Title for the "notEqualField" operator
         *  @type {string}
         *  @default "differs from field (match case)"
         */
        var notEqualFieldTitle: String = definedExternally
        /**
         *  Title for the "iNotEqualField" operator
         *  @type {string}
         *  @default "differs from field"
         */
        var iNotEqualFieldTitle: String = definedExternally
        /**
         *  Title for the "greaterThanField" operator
         *  @type {string}
         *  @default "greater than field"
         */
        var greaterThanFieldTitle: String = definedExternally
        /**
         *  Title for the "lessThanField" operator
         *  @type {string}
         *  @default "less than field"
         */
        var lessThanFieldTitle: String = definedExternally
        /**
         *  Title for the "greaterOrEqualField" operator
         *  @type {string}
         *  @default "greater than or equal to field"
         */
        var greaterOrEqualFieldTitle: String = definedExternally
        /**
         *  Title for the "lessOrEqualField" operator
         *  @type {string}
         *  @default "less than or equal to field"
         */
        var lessOrEqualFieldTitle: String = definedExternally
        /**
         *  Title for the "containsField" operator
         *  @type {string}
         *  @default "contains another field value (match case)"
         */
        var containsFieldTitle: String = definedExternally
        /**
         *  Title for the "iContainsField" operator
         *  @type {string}
         *  @default "contains another field value"
         */
        var iContainsFieldTitle: String = definedExternally
        /**
         *  Title for the "startsWithField" operator
         *  @type {string}
         *  @default "starts with another field value (match case)"
         */
        var startsWithFieldTitle: String = definedExternally
        /**
         *  Title for the "iStartsWithField" operator
         *  @type {string}
         *  @default "starts with another field value"
         */
        var iStartsWithFieldTitle: String = definedExternally
        /**
         *  Title for the "endsWithField" operator
         *  @type {string}
         *  @default "ends with another field value (match case)"
         */
        var endsWithFieldTitle: String = definedExternally
        /**
         *  Title for the "iEndsWithField" operator
         *  @type {string}
         *  @default "ends with another field value"
         */
        var iEndsWithFieldTitle: String = definedExternally
        /**
         *  Title for the "notContainsField" operator
         *  @type {string}
         *  @default "does not contain another field value (match case)"
         */
        var notContainsFieldTitle: String = definedExternally
        /**
         *  Title for the "iNotContainsField" operator
         *  @type {string}
         *  @default "does not contain another field value"
         */
        var iNotContainsFieldTitle: String = definedExternally
        /**
         *  Title for the "notStartsWithField" operator
         *  @type {string}
         *  @default "does not start with another field value (match case)"
         */
        var notStartsWithFieldTitle: String = definedExternally
        /**
         *  Title for the "iNotStartsWithField" operator
         *  @type {string}
         *  @default "does not start with another field value"
         */
        var iNotStartsWithFieldTitle: String = definedExternally
        /**
         *  Title for the "notEndsWithField" operator
         *  @type {string}
         *  @default "does not end with another field value (match case)"
         */
        var notEndsWithFieldTitle: String = definedExternally
        /**
         *  Title for the "iNotEndsWithField" operator
         *  @type {string}
         *  @default "does not end with another field value"
         */
        var iNotEndsWithFieldTitle: String = definedExternally
        /**
         *  Title for the "startsWithPattern" operator
         *  @type {string}
         *  @default "starts with pattern (match case)"
         */
        var startsWithPatternTitle: String = definedExternally
        /**
         *  Title for the "iStartsWithPattern" operator
         *  @type {string}
         *  @default "starts with pattern"
         */
        var iStartsWithPatternTitle: String = definedExternally
        /**
         *  Title for the "endsWithPattern" operator
         *  @type {string}
         *  @default "ends with pattern (match case)"
         */
        var endsWithPatternTitle: String = definedExternally
        /**
         *  Title for the "iEndsWithPattern" operator
         *  @type {string}
         *  @default "ends with pattern"
         */
        var iEndsWithPatternTitle: String = definedExternally
        /**
         *  Title for the "and" operator
         *  @type {string}
         *  @default "Match All"
         */
        var andTitle: String = definedExternally
        /**
         *  Title for the "not" operator
         *  @type {string}
         *  @default "Match None"
         */
        var notTitle: String = definedExternally
        /**
         *  Title for the "or" operator
         *  @type {string}
         *  @default "Match Any"
         */
        var orTitle: String = definedExternally
        /**
         *  Title for the "inSet" operator
         *  @type {string}
         *  @default "is one of"
         */
        var inSetTitle: String = definedExternally
        /**
         *  Title for the "notInSet" operator
         *  @type {string}
         *  @default "is not one of"
         */
        var notInSetTitle: String = definedExternally
        /**
         *  Title for the "isBlank" operator
         *  @type {string}
         *  @default "is blank"
         */
        var isBlankTitle: String = definedExternally
        /**
         *  Title for the "notBlank" operator
         *  @type {string}
         *  @default "not blank"
         */
        var notBlankTitle: String = definedExternally
        /**
         *  Title for the "isNull" operator
         *  @type {string}
         *  @default "is null"
         */
        var isNullTitle: String = definedExternally
        /**
         *  Title for the "notNull" operator
         *  @type {string}
         *  @default "is not null"
         */
        var notNullTitle: String = definedExternally
        /**
         *  Creates a new Operators
         * 
         *  @param typeCheckedProperties {Partial<Operators>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Operators} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Operators = definedExternally
    }
}