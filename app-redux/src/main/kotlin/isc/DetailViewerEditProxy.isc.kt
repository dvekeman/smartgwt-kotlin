@file:JsQualifier("isc")
package isc

/**
 *  EditProxy that handles DetailViewer components when editMode is enabled.
 */
open external class DetailViewerEditProxy : CanvasEditProxy {
    /**
     *  If EditProxy.inlineEditEvent for this viewer edits the
     *   DetailViewer.data, character that should be used as a separator between
     *   values, or between pairs of field name vs values if the user is entering such
     *   a ValueMap using the DetailViewerEditProxy.dataDisplaySeparatorChar.
     * 
     *   If EditProxy.inlineEditMultiline is enabled, newlines will be used as value
     *   separators and the dataSeparatorChar
     * 
     *   The DetailViewerEditProxy.dataEscapeChar can be used to enter the separator
     *   char as part of a field name or value.
     *  @type {string}
     *  @default ","
     */
    open var dataSeparatorChar: String = definedExternally
    /**
     *  If EditProxy.inlineEditEvent for this viewer edits the
     *   DetailViewer.data, character that should be used as a separator for
     *   entering ValueMap-style entries that map from a field name to a value.
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
     *   Any entry without a separator char has an implied value of null.
     *   For example, for this input:
     * 
     *      Fixed:Reported Fixed, WontFix:Won't Fix, Resolved
     * 
     *   The resulting data would be:
     * 
     *    {
     *     "Fixed" : "Reported Fixed",
     *     "WontFix" : "Won't Fix",
     *     "Resolved" : null
     *    }
     * 
     * 
     *   The DetailViewerEditProxy.dataEscapeChar can be used to enter literal colon characters.
     * 
     *   Set dataDisplaySeparatorChar to null to prevent entry of values
     *   - user input will always be treated as just a list of legal field names.
     *  @type {string}
     *  @default ":"
     */
    open var dataDisplaySeparatorChar: String = definedExternally
    /**
     *  If EditProxy.inlineEditEvent for this viewer edits the
     *   DetailViewer.data, character that can be used to enter literal separator
     *   chars (such as the DetailViewerEditProxy.dataSeparatorChar) or literal
     *   leading or trailing whitespace.
     * 
     *   Repeat this character twice to enter it literally. For example, with the default
     *   of "\", inputting "\\" would result in a literal backslash in the value.
     *  @type {string}
     *  @default "\"
     */
    open var dataEscapeChar: String = definedExternally
    /**
     *   Returns the text based on the current component state to be edited inline.
     *   Called by the EditProxy.inlineEditForm to obtain the starting edit value.
     * 
     *   Returns the component's data one-field-per-line as specified in
     *   DetailViewerEditProxy.dataDisplaySeparatorChar.
     * 
     * 
     */
    override fun getInlineEditText(): Unit = definedExternally
    /**
     *   Save the new value into the component's state. Called by the
     *   EditProxy.inlineEditForm to commit the change.
     * 
     *   Updates the component's data and fields.
     * 
     * 
     *  @param {string} the new component data
     */
    override fun setInlineEditText(newValue: String): Unit = definedExternally
    companion object {
        /**
         *  Creates a new DetailViewerEditProxy
         * 
         *  @param typeCheckedProperties {Partial<DetailViewerEditProxy>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DetailViewerEditProxy} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DetailViewerEditProxy = definedExternally
    }
}