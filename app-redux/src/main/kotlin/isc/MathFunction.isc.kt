@file:JsQualifier("isc")
package isc

/**
 *  The definition of a function for use in the FormulaBuilder. A function consists of
 *   a name (what the user actually types to use the function), a description (shown in help) and
 *   an actual JavaScript function that executes the calculation.
 * 
 *   The built-in functions cover all static functionality on the JavaScript Math object:
 * 
 * 
 *  - max(val1,val2): Maximum of two values
 * 
 *  - min(val1,val2): Minimum of two values
 * 
 *  - round(value,decimalDigits): Round a value up or down, optionally providing
 *     decimalDigits as the maximum number of decimal places to round to. For fixed
 *     or precision rounding, use toFixed() and toPrecision() respectively.
 * 
 * 
 *  - ceil(value): Round a value up
 * 
 *  - floor(value): Round a value down
 * 
 *  - abs(value): Absolute value
 * 
 *  - pow(value1,value2): value1 to the power of value2
 * 
 *  - sqrt(value): Square root of a value
 * 
 *  - dateAdd(value,interval,amount): Excel&trade;-compatible dataAdd function: adds
 *     quantities of a time interval to a date value. Also supports being passed interval
 *     names, like "hour" or "week".
 * 
 * 
 *  - toPrecision(value,precision): Format a number to a length of precision digits,
 *     rounding or adding a decimal point and zero-padding as necessary. Note that the
 *     values 123, 12.3 and 1.23 have an equal precision of 3. Returns a formatted string
 *     and should be used as the outermost function call in a formula. For rounding, use
 *     round().
 * 
 * 
 *  - toFixed(value,digits): Round or zero-pad a number to digits decimal places.
 *     Returns a formatted string and should be used as the outermost function call in a
 *     formula. To round values or restrict precision, use round() and
 *     toPrecision() respectively.
 * 
 * 
 *  - sin(value): Sine of a value
 * 
 *  - cos(value): Cosine of a value
 * 
 *  - tan(value): Tangent of a value
 * 
 *  - ln(value): natural logarithm of a value
 * 
 *  - log(base,value): logarithm of a value with the specified base
 * 
 *  - asin(value): Arcsine of a value
 * 
 *  - acos(value): Arccosine of a value
 * 
 *  - atan(value): Arctangent of a value (-PI/2 to PI/2 radians)
 * 
 *  - atan2(value1,value2): Angle theta of a point (-PI to PI radians)
 * 
 *  - exp(value): The value of Evalue
 * 
 *  - random(): Random number between 0 and 1
 * 
 */
open external class MathFunction : Class {
    /**
     *  Name of the function (what the user actually types). For example, a name of "min" would
     *   indicate that the user types "min(someValue)" to use this function.
     * 
     *   Mixed-case names may be used. As a convenience, a few aliases are registered by
     *   MathFunction.registerFunction (see that method for details).
     *  @type {Identifier}
     *  @default null
     */
    open var name: String = definedExternally
    /**
     *  A short description of this function
     *  @type {string}
     *  @default null
     */
    open var description: String = definedExternally
    /**
     *  Javascript method to perform the calculation associated with this function
     *  @type {Function}
     *  @default null
     */
    open var jsFunction: (() -> dynamic) = definedExternally
    /**
     *  Indicates the sort-order of this MathFunction in an index returned from static method
     *   MathFunction.getDefaultFunctionIndex. A lower value (&gt;= 0) will cause a function
     *   to appear before a MathFunction with a higher value of the property. The default
     *   of -1 means to exclude the MathFunction from the index entirely.
     *  @type {Integer}
     *  @default "-1"
     */
    open var defaultSortPosition: Number = definedExternally
    companion object {
        /**
         *  Creates a new MathFunction
         * 
         *  @param typeCheckedProperties {Partial<MathFunction>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {MathFunction} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): MathFunction = definedExternally
        /**
         *   Registers a new math function for use with FormulaFields. Mixed-case names are allowed,
         *   and as a convenience, the following aliases are also available:
         * 
         *  - name in all lowercase
         * 
         *  - name in all uppercase
         * 
         *  - name with first letter uppercase, and the rest unchanged
         * 
         *   Note: The aliases are shallow copies of each other, so be aware that if MathFunction.jsFunction
         *   depends on instance state, objects accessed by instance properties will be shared by all
         *   copies.
         * 
         * 
         * \* @param {MathFunction} 
         */
        fun registerFunction(newFunction: MathFunction): Unit = definedExternally
        /**
         *   Returns an index of all registered functions by name
         * 
         * 
         */
        fun getRegisteredFunctionIndex(): Number = definedExternally
        /**
         *   Returns an index of all default registered functions by name, ordered by
         *   MathFunction.defaultSortPosition. (Also includes those user-registered
         *   functions with non-default (&gt;= 0) values for that property.)
         * 
         * 
         */
        fun getDefaultFunctionIndex(): Number = definedExternally
    }
}