@file:JsQualifier("isc")
package isc

/**
 *  EditProxy that handles FormItems when editMode is enabled.
 */
open external class FormItemEditProxy : EditProxy {
    /**
     *  If InlineEditEvent for this FormItem edits the
     *   FormItem.valueMap, character that should be used as a separator between
     *   values, or between pairs of stored vs display values if the user is entering such
     *   a ValueMap using the FormItemEditProxy.valueMapDisplaySeparatorChar.
     * 
     *   If EditProxy.inlineEditMultiline is enabled, newlines will be used as value
     *   separators and the valueMapSeparatorChar
     * 
     *   The FormItemEditProxy.valueMapEscapeChar can be used to enter the separator
     *   char as part of a valueMap value.
     *  @type {string}
     *  @default ","
     */
    open var valueMapSeparatorChar: String = definedExternally
    /**
     *  If InlineEditEvent for this FormItem edits the
     *   FormItem.valueMap, character that should be used as a separator for
     *   entering ValueMaps that map from a stored value to a user-displayed value.
     * 
     *   With the default of ":", the following input:
     * 
     *     1:Fixed, 2:Won't Fix, 3:Resolved
     * 
     *   Would be assumed to be a mapping like this (expressed in JSON):
     * 
     *    {
     *     "1" : "Fixed",
     *     "2" : "Won't Fix",
     *     "3" : "Resolved"
     *    }
     * 
     * 
     *   If the input has inconsistent use of the separator char, the input will be assumed
     *   to be stored-to-displayed mapping if the separator char is present in a majority
     *   of values, and any values that lack a separator will use the same value for
     *   storage and display. For example, for this input:
     * 
     *      Fixed:Reported Fixed, WontFix:Won't Fix, Resolved
     * 
     *   The resulting valueMap would be:
     * 
     *    {
     *     "Fixed" : "Reported Fixed",
     *     "WontFix" : "Won't Fix",
     *     "Resolved" : "Resolved"
     *    }
     * 
     * 
     *   The FormItemEditProxy.valueMapEscapeChar can be used to enter literal colon characters.
     * 
     *   Set valueMapDisplaySeparatorChar to null to prevent entry of stored
     *   vs displayed values - user input will always be treated as just a list of legal
     *   values.
     *  @type {string}
     *  @default ":"
     */
    open var valueMapDisplaySeparatorChar: String = definedExternally
    /**
     *  If InlineEditEvent for this FormItem edits the
     *   FormItem.valueMap, character that can be used to mark the default selected
     *   option. Can appear before or after a value, for example, with this input:
     * 
     *     Fixed,Won't Fix,Resolved\*
     * 
     *   "Resolved" would be the default selected value.
     * 
     *   If multiple values are marked selected for a SelectItem,
     *   SelectItem.multiple will automatically be set.
     * 
     *   The FormItemEditProxy.valueMapEscapeChar can be used to allow the
     *   valueMapSelectedChar to appear at the beginning or end of a
     *   valueMap value.
     *  @type {string}
     *  @default "\*"
     */
    open var valueMapSelectedChar: String = definedExternally
    /**
     *  If InlineEditEvent for this FormItem edits the
     *   FormItem.valueMap, character that can be used to enter literal separator
     *   chars (such as the FormItemEditProxy.valueMapSeparatorChar) or literal
     *   leading or trailing whitespace.
     * 
     *   Repeat this character twice to enter it literally. For example, with the default
     *   of "\", inputting "\\" would result in a literal backslash in the value.
     *  @type {string}
     *  @default "\"
     */
    open var valueMapEscapeChar: String = definedExternally
    companion object {
        /**
         *  Creates a new FormItemEditProxy
         * 
         *  @param typeCheckedProperties {Partial<FormItemEditProxy>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {FormItemEditProxy} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): FormItemEditProxy = definedExternally
    }
}