@file:JsQualifier("isc")
package isc

/**
 *  Class containing properties that configure the display of
 *   and interaction with the fields showing in a FieldPicker.
 */
open external class FieldPickerField : Class {
    companion object {
        /**
         *  The title displayed for the frozen property
         *  @type {string}
         *  @default "Is Frozen"
         */
        var frozenTitle: String = definedExternally
        /**
         *  The title displayed for the precision property
         *  @type {string}
         *  @default "Precision"
         */
        var precisionTitle: String = definedExternally
        /**
         *  The title displayed for the decimalPrecision property
         *  @type {string}
         *  @default "Decimal Precision"
         */
        var decimalPrecisionTitle: String = definedExternally
        /**
         *  The title displayed for the decimalPad property
         *  @type {string}
         *  @default "Decimal Pad"
         */
        var decimalPadTitle: String = definedExternally
        /**
         *  The title displayed for the align property
         *  @type {string}
         *  @default "Header Text Alignment"
         */
        var alignTitle: String = definedExternally
        /**
         *  The title displayed for the cellAlign property
         *  @type {string}
         *  @default "Data Alignment"
         */
        var cellAlignTitle: String = definedExternally
        /**
         *  Creates a new FieldPickerField
         * 
         *  @param typeCheckedProperties {Partial<FieldPickerField>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {FieldPickerField} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): FieldPickerField = definedExternally
    }
}