@file:JsQualifier("isc")
package isc

/**
 *  Static singleton class containing APIs for interacting with Numbers.
 */
open external class NumberUtil : Class {
    companion object {
        /**
         *  The decimal symbol to use when formatting numbers
         * 
         *  @type {string}
         *  @default "."
         */
        var decimalSymbol: String = definedExternally
        /**
         *  The grouping symbol, or thousands separator, to use when formatting numbers
         * 
         *  @type {string}
         *  @default ","
         */
        var groupingSymbol: String = definedExternally
        /**
         *  The negative symbol to use when formatting numbers
         * 
         *  @type {string}
         *  @default "-"
         */
        var negativeSymbol: String = definedExternally
        /**
         *  The currency symbol to use when formatting numbers
         * 
         *  @type {string}
         *  @default "$"
         */
        var currencySymbol: String = definedExternally
        /**
         *  The format to use when formatting nagative numbers. Supported values are: 1 = before,
         *   2 = after, 3 = beforeSpace, 4 = afterSpace, 5 = parens
         * 
         *  @type {number}
         *  @default "1"
         */
        var negativeFormat: Number = definedExternally
        /**
         *  The grouping-format for numbers
         * 
         *  @type {number}
         *  @default "1"
         */
        var groupingFormat: Number = definedExternally
        /**
         *  Creates a new NumberUtil
         * 
         *  @param typeCheckedProperties {Partial<NumberUtil>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {NumberUtil} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): NumberUtil = definedExternally
        /**
         *   Return the passed number as a string padded out to digits length.
         * 
         * 
         *  @param {number} Number object to stringify
         *  @param {number=} Number of digits to pad to. (Default is 2)
         */
        fun stringify(number: Number, digits: Number?): String = definedExternally
        /**
         *   Returns true if the number parameter falls between the 'first' and 'second' parameters.
         * 
         * 
         *  @param {number} Number object to be evaluated
         *  @param {number=} Number at the lower boundary
         *  @param {number=} Number at the upper boundary
         *  @param {number=} Whether or not the numbers at either end of the boundary should be included in the comparison
         */
        fun isBetween(number: Number, first: Number?, second: Number?, inclusive: Number?): Boolean = definedExternally
        /**
         *   Returns a clamped number between a min and max.
         * 
         * 
         *   var clamped = isc.NumberUtil.clamp(10, 0, 5); // Returns 5 because 10 is greater than 5
         *   var clamped = isc.NumberUtil.clamp(-3, 0, 5); // Returns 0 because -3 is less than 0
         *   var clamped = isc.NumberUtil.clamp(4, 0, 5); // Returns 4 because 4 is between 0 and 5
         * 
         * 
         *  @param {number} the number to clamp
         *  @param {number} the number to return if the number is lower than min
         *  @param {number} the number to return if the number is higher than max
         */
        fun clamp(number: Number, min: Number, max: Number): Number = definedExternally
        /**
         *   Return the passed number as a currency-formatted string, or an empty string if not passed a
         *   number.
         * 
         * 
         *  @param {number} the number to convert
         *  @param {string=} Currency symbol, default taken from the locale and can be                 set to an empty string. If not passed and missing from the                 locale, defaults to "$".
         *  @param {string=} Decimal separator symbol, default taken from the locale. If                 if not passed and missing from the locale, defaults to                 ".".
         *  @param {boolean=} Should decimal portion be padded out to two digits? True                by default.
         *  @param {boolean=} Should the currency symbol be shown at the end of the                    string? If unspecified, it will prefix the number.
         */
        fun toCurrencyString(number: Number, currencyChar: String?, decimalChar: String?, padDecimal: Boolean?, currencyCharLast: Boolean?): String = definedExternally
        /**
         *   Format the passed number for readability, with:
         * 
         * 
         *  - separators between three-digit groups
         * 
         *  - optional fixed decimal precision (so decimal points align on right-aligned numbers)
         * 
         *  - localized decimal, grouping, and negative symbols
         * 
         *   NumberUtil.decimalSymbol,
         *   NumberUtil.groupingSymbol, and
         *   NumberUtil.negativeSymbol will normally come from
         *   SmartClient locale settings (which may come from either client OS or application locale
         *   settings), but they are also supported as arguments for mixed-format applications
         *   (eg normalize all currency to NumberUtil.toUSCurrencyString, but use the
         *   current locale format for other numbers).
         * 
         * 
         *  @param {number} the number object to convert
         *  @param {number=} decimal-precision for the formatted value
         *  @param {string=} the symbol that appears before the decimal part of the number
         *  @param {string=} the symbol shown between groups of 3 non-decimal digits
         *  @param {string=} the symbol that indicate a negative number
         */
        fun toLocalizedString(number: Number, decimalPrecision: Number?, decimalSymbol: String?, groupingSymbol: String?, negativeSymbol: String?): String = definedExternally
        /**
         *   Format the passed number as a US string. Returns empty string if not passed a number.
         * 
         * 
         *  @param {number} the number object to format
         * \* @param {number=} 
         */
        fun toUSString(number: Number, decimalPrecision: Number?): String = definedExternally
        /**
         *   Format the passed number as a US Dollar currency string. Returns empty string if not passed
         *   a number.
         * 
         * 
         *  @param {number} the number object to format
         * \* @param {number=} 
         */
        fun toUSCurrencyString(number: Number, decimalPrecision: Number?): String = definedExternally
        /**
         *   Parse string that contains integer number. This method correctly handles locale based
         *   separators and currency symbol.
         * 
         * 
         *  @param {string} the string to parse
         */
        fun parseInt(string: String): Number = definedExternally
        /**
         *   Parse string that contains float number. This method correctly handles locale based
         *   separators, decimal points and currency symbol.
         * 
         * 
         *  @param {string} the string to parse
         */
        fun parseFloat(string: String): Number = definedExternally
        /**
         * 
         *   If given a numeric string (that is, a non-empty string which converts to a
         *   number), will return the equivalent integer. Otherwise, returns the
         *   parameter unchanged. Useful for dealing with values that can be numbers or
         *   strings, but which you want to coerce to a numeric type if possible.
         * 
         * 
         *  @param {any} the string or number to parse
         */
        fun parseIfNumeric(numberOrString: dynamic): dynamic = definedExternally
        /**
         *   Return the parameter number formatted according to the parameter FormatString.
         *   This method is used to implement the DataSourceField.format functionality, but it can
         *   also be used to format arbitrary numbers programmatically.
         * 
         *  @param {number} The number to format
         *  @param {FormatString} The format to apply
         */
        fun format(number: Number, format: String): String = definedExternally
    }
}