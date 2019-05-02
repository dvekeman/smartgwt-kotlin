@file:JsQualifier("isc")
package isc

/**
 *  Common base class of TextImportSettings.
 */
open external class TextSettings : Class {
    /**
     *  For export, a set of fields to export. Default is to export all DataSource fields.
     * 
     *   Fields may be specified that are not in the DataSource but for which data values are present
     *   in the provided Records. In this case the field is assumed to be of type "text".
     * 
     *   For import, names of DataSource fields to use to parse values, in order.
     * 
     *   If fieldList is unset, DataSource fields are used, in order.
     * 
     *   If more values exist in a given Record than the listed fields or than all DataSource fields,
     *   remaining values are ignored.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var fieldList: Array<dynamic> = definedExternally
    /**
     *  Separator between field values. Default is a comma character, producing CSV
     *   (comma-separated values) format.
     *  @type {string}
     *  @default ","
     */
    open var fieldSeparator: String = definedExternally
    /**
     *  Separator between Records. For import, default of null means that either the Unix/Mac
     *   format of just a newline ("\n") or the typical DOS/Windows format of a carriage return
     *   and newline ("\r\n") will be accepted. For export, overridden in TextExportSettings.
     *  @type {string}
     *  @default null
     */
    open var lineSeparator: String = definedExternally
    /**
     *  EscapingMode expected for escaping special characters embedded in text values.
     *  @type {EscapingMode}
     *  @default "backslash"
     */
    open var escapingMode: 
                           /**
                            *  Literal double quotes in data values are doubled (""), as expected by Microsoft         Excel when pasting text values
                            *  double quotes in data values have a blackslash (\) prepended, similar to          String escaping in JavaScript and Java
                            */
                           String /* double |  backslash */ = definedExternally
    companion object {
        /**
         *  Creates a new TextSettings
         * 
         *  @param typeCheckedProperties {Partial<TextSettings>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {TextSettings} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): TextSettings = definedExternally
    }
}