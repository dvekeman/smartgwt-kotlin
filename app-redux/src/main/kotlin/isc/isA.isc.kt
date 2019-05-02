@file:JsQualifier("isc")
package isc

/**
 *  A library of functions for determining the types of other objects.
 * 
 *   The "isA" methods for the basic JavaScript types are much faster and more consistent across
 *   platforms than JavaScript's "typeof" operator.
 * 
 *   An isA method is automatically created for every ISC Class and Interface definition, for
 *   example, isA.Canvas().
 */
open external class isA {
    companion object {
        /**
         * 
         *   Is object the empty string?
         * 
         *   NOTE: if you prefer, you can call this as isAn.emptyString()
         * 
         * 
         *  @param {object} object to test
         */
        fun emptyString(`object`: dynamic): Boolean = definedExternally
        /**
         * 
         *   Is object a non-empty String?
         * 
         * 
         *  @param {object} object to test
         */
        fun nonemptyString(`object`: dynamic): Boolean = definedExternally
        /**
         *   Returns whether the passed value is a non-null Object.
         * 
         *   Returns false for values that are Numbers, Strings, Booleans, Functions or are null or
         *   undefined.
         * 
         *   Returns true for Object, Array, Regular Expression, Date and other kinds of
         *   native objects which are considered to extend from window.Object.
         * 
         * 
         *  @param {any} value to test for whether it's an object
         */
        fun Object(`object`: dynamic): Boolean = definedExternally
        /**
         * 
         *   Is object an object with no properties (i.e.: {})?
         * 
         *   Note that an object that has properties with null values is considered non-empty, eg
         *   { propName:null } is non-empty.
         * 
         *   NOTE: if you prefer, you can call this as isAn.emptyObject()
         * 
         * 
         *  @param {object} object to test
         */
        fun emptyObject(`object`: dynamic): Boolean = definedExternally
        /**
         * 
         *   Is object an Array with no items?
         * 
         * 
         *  @param {object} object to test
         */
        fun emptyArray(`object`: dynamic): Boolean = definedExternally
        /**
         * 
         *   Is object a String object?
         * 
         * 
         *  @param {object} object to test
         */
        fun String(`object`: dynamic): Boolean = definedExternally
        /**
         * 
         *   Is object an Array object?
         * 
         *   NOTE: if you prefer, you can call this as isAn.Array()
         * 
         * 
         *  @param {object} object to test
         */
        fun Array(`object`: dynamic): Boolean = definedExternally
        /**
         * 
         *   Is object a Function object?
         * 
         * 
         *  @param {object} object to test
         */
        fun Function(`object`: dynamic): Boolean = definedExternally
        /**
         * 
         *   Is object a Number object?
         * 
         *   NOTE: this returns false if object is an invalid number (isNaN(object) == true)
         * 
         * 
         *  @param {object} object to test
         */
        fun Number(`object`: dynamic): Boolean = definedExternally
        /**
         * 
         *   Is object a Boolean object?
         * 
         * 
         *  @param {object} object to test
         */
        fun Boolean(`object`: dynamic): Boolean = definedExternally
        /**
         * 
         *   Is object a Date object?
         * 
         * 
         *  @param {object} object to test
         */
        fun Date(`object`: dynamic): Boolean = definedExternally
        /**
         * 
         *   Is object a Regular Expression (RegExp) object?
         * 
         * 
         *  @param {object} object to test
         */
        fun RegularExpression(`object`: dynamic): Boolean = definedExternally
        /**
         * 
         *   Is object an instance of some class?
         * 
         * 
         *  @param {object} object to test
         */
        fun Instance(`object`: dynamic): Boolean = definedExternally
        /**
         * 
         *   Is object a class object?
         * 
         * 
         *  @param {object} object to test
         */
        fun ClassObject(`object`: dynamic): Boolean = definedExternally
        /**
         * 
         *   Is object an interface object?
         * 
         * 
         *  @param {object} object to test
         */
        fun Interface(`object`: dynamic): Boolean = definedExternally
        /**
         *   Does object implement the List interface?
         * 
         *  @param {object} object to test
         */
        fun List(`object`: dynamic): Boolean = definedExternally
    }
}