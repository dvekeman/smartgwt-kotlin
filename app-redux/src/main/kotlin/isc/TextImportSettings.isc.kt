@file:JsQualifier("isc")
package isc

/**
 *  Settings for use with DataSource.recordsFromText.
 */
open external class TextImportSettings : TextSettings {
    /**
     *  If set to true, the data is assumed to have a header line that lists titles for each field,
     *   which should be parsed.
     * 
     *   recordsFromText will then try to find a same-named
     *   DataSourceField by checking parsed titles against both DataSourceField.title and
     *   DataSourceField.name (titles first), doing a case-insensitive comparison with any
     *   leading or trailing whitespace removed from the title. If no field matches, data will
     *   appear in the returned Records under the exact title parsed from the header line.
     * 
     *   If this approach will not find appropriate DataSourceFields, parse the header line before
     *   calling recordsFromText(), and provide the list of field names to use when
     *   parsing data as TextSettings.fieldList.
     *  @type {boolean}
     *  @default false
     */
    open var hasHeaderLine: Boolean = definedExternally
    companion object {
        /**
         *  Creates a new TextImportSettings
         * 
         *  @param typeCheckedProperties {Partial<TextImportSettings>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {TextImportSettings} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): TextImportSettings = definedExternally
    }
}