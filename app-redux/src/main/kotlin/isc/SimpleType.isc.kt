@file:JsQualifier("isc")
package isc

/**
 *  An atomic type such as a string or number, that is generally stored, displayed and
 *   manipulated as a single value.
 * 
 *   SimpleTypes can be created at any time, and subsequently referred to as a
 *   DataSourceField.type in DataSource and
 *   DataBoundComponent. This allows you to define
 *   SimpleType.validators, SimpleType.normalDisplayFormatter
 *   and SimpleType.editorType behaviors for a type to be reused across all
 *   DataBoundComponent.
 * 
 *   The SimpleType class also allows data to be stored in some opaque format but treated as
 *   simple atomic values as far as SmartClient components are concerned by implementing
 *   SimpleType.getAtomicValue and SimpleType.updateAtomicValue methods.
 *   For example, if some record has a field value set to a javascript object with the
 *   following properties:
 * 
 *   { stringValue:"A String", length: 9 }
 * 
 *   this value could be treated as a simple string by defining a SimpleType with
 *   SimpleType.inheritsFrom set to "text" and a custom
 *   getAtomicValue() method that simply extracted the "stringValue"
 *   attribute from the data object. DataBoundComponents would then display
 *   the string value, and use it for sorting and other standard databinding features.
 * 
 *   Note that the term "simpleType" is used in the same sense as in
 *   http://www.w3.org/TR/xmlschema-0/, and
 *   XMLTools.loadXMLSchema will create new SimpleType definitions.
 * 
 *   When using the SmartClient Server, SimpleTypes can be defined server-side, and should
 *   be defined server-side if validators are going to be declared so that the server will
 *   enforce validation. To define server-side SimpleTypes using Component XML you should create
 *   file {typeName}.type.xml in the following format:
 * 
 *    &lt;SimpleType name="{typeName}" inheritsFrom="{otherSimpleType}"
 *           editorType="{FormItemClassName}"&gt;
 *     &lt;validators&gt;
 *      &lt;!-- validator definition just like DataSourceField --&gt;
 *     &lt;/validators&gt;
 *    &lt;/SimpleType&gt;
 * 
 *   .. and place this file alongside your DataSource files (.ds.xml) files - in any of folders
 *   listed in project.datasources property in server_properties.
 * 
 *   SimpleTypes can be loaded via DataSourceLoader or loadDSTag and
 *   should be loaded before the definitions of any DataSources that use them (so
 *   generally put all SimpleType definitions first).
 * 
 *   Define validators in the server-side type definition, for example:
 * 
 *    &lt;SimpleType name="countryCodeType" inheritsFrom="text"&gt;
 *     &lt;validators&gt;
 *      &lt;validator type="lengthRange" min="2" max="2"
 *       errorMessage="Length of country code should be equal to 2." /&gt;
 *      &lt;validator type="regexp" expression="[A-Z][A-Z]"
 *       errorMessage="CountryCode should have only uppercase letters." /&gt;
 *     &lt;/validators&gt;
 *    &lt;/SimpleType&gt;
 * 
 * 
 *   For client-side formatters, add these to the type definition after loading it from the
 *   server, for example:
 * 
 * 
 *     isc.SimpleType.getType("independenceDateType").addProperties({
 *       normalDisplayFormatter : function (value) {
 *         if (value == null) return "";
 *         return "&lt;i&gt;" + (value.getYear() + 1900) + "&lt;/i&gt;";
 *       }
 *     });
 * 
 * 
 * 
 *   Note that formatters must be added to the SimpleType definition before any
 *   DataBoundComponent binds to a DataSource that uses the SimpleType.
 * 
 *   An example is ${isc.DocUtils.linkForExampleId('formsCustomSimpleType', 'here')}.
 * 
 */
open external class SimpleType : Class {
    /**
     *  Name of the type, used to refer to the type from DataSourceField.type.
     *  @type {Identifier}
     *  @default null
     */
    open var name: String = definedExternally
    /**
     *  Name of another SimpleType from which this type should inherit.
     * 
     *   Validators, if any, will be combined. All other SimpleType properties default to the
     *   inherited type's value.
     *  @type {Identifier}
     *  @default null
     */
    open var inheritsFrom: String = definedExternally
    /**
     *  Validators to apply to value of this type.
     *  @type {Array<Partial<Validator>>}
     *  @default null
     */
    open var validators: Array<dynamic> = definedExternally
    /**
     *  List of legal values for this type, like DataSourceField.valueMap.
     *  @type {ValueMap}
     *  @default null
     */
    open var valueMap: dynamic = definedExternally
    /**
     *  Classname of the FormItem that should be the default for editing values of this type (eg
     *   "SelectItem").
     * 
     *   You can create a simple custom FormItem by adding default FormItem.icons that
     *   launch custom value picking dialogs (an example is in the QuickStart
     *   Guide, Chapter 9, Extending SmartClient). By setting simpleType.editorType
     *   to the name of your custom FormItem, forms will automatically use the custom FormItem,
     *   as will grids performing ListGrid.canEdit.
     *  @type {FormItemClassName}
     *  @default null
     */
    open var editorType: String = definedExternally
    /**
     *  Classname of the FormItem that should be used to display values of this type when a field
     *   is marked as DataSourceField.canEdit and the field is displayed
     *   in an editor type component like a DynamicForm.
     * 
     *   May be overridden by DataSourceField.readOnlyEditorType.
     *  @type {FormItemClassName}
     *  @default null
     */
    open var readOnlyEditorType: String = definedExternally
    /**
     *  Classname of the FormItem that should be used to edit values of this type if it appears
     *   in a filter row.
     * 
     *   May be overridden by DataSourceField.filterEditorType.
     *  @type {FormItemClassName}
     *  @default null
     */
    open var filterEditorType: String = definedExternally
    /**
     *  These are properties that are essentially copied onto any DataSourceField where the
     *   property is applied. The supported properties are only client-side properties.
     *  @type {DataSourceField}
     *  @default null
     */
    open var fieldProperties: DataSourceField = definedExternally
    /**
     *  FormatString for numeric or date formatting. See DataSourceField.format.
     *  @type {FormatString}
     *  @default null
     */
    open var format: String = definedExternally
    /**
     *  FormatString used during exports for numeric or date formatting. See
     *   DataSourceField.exportFormat.
     *  @type {FormatString}
     *  @default null
     */
    open var exportFormat: String = definedExternally
    /**
     *  A set of key-value pairs that represent the names and titles of the grouping modes
     *   available to values of this type, for use in components that support grouping.
     * 
     *   Some types provide a set of builtin groupingModes, as covered
     *   builtinGroupingModes.
     * 
     *   Use SimpleType.getGroupValue and SimpleType.getGroupTitle to implement
     *   custom grouping logic for each of the grouping modes you provide.
     *  @type {ValueMap}
     *  @default null
     */
    open var groupingModes: dynamic = definedExternally
    /**
     *  In components that support grouping, the default mode from the available
     *   SimpleType.groupingModes to use when grouping values of this type.
     *  @type {string}
     *  @default null
     */
    open var defaultGroupingMode: String = definedExternally
    /**
     *  Set of search operators valid for this type.
     * 
     *   If not specified, the SimpleType.inheritsFrom type's operators will be used, finally
     *   defaulting to the default operators for the basic types (eg, integer).
     *  @type {Array<Partial<OperatorId>>}
     *  @default null
     */
    open var validOperators: Array<dynamic> = definedExternally
    /**
     *   Optional method to extract an atomic value (such as a string or number)
     *   from some arbitrary live data value. If defined, this method will be called
     *   for every field value of the specified type in order to convert from the
     *   raw data value to an atomic type to be used for standard DataBinding features
     *   such as sorting and editing.
     * 
     *   The "reason" parameter is passed by the framework to indicate why it is asking for the
     *   atomic value. Your method can use this value to affect the atomic value that is
     *   returned - for example, if the reason is "sort" you could return the atomic value
     *   converted to upper-case, to impose case-insensitive sorting. Reason strings used
     *   by the framework are:
     * 
     *  - "edit" Retrieving the edit value of the field in a DynamicForm or
     *          ListGrid
     * 
     *  - "format" Retrieving the value to format it for display
     * 
     *  - "mask" Retrieving the value to present it for masked input
     * 
     *  - "filter" Retrieving the value for use in a filter comparison
     * 
     *  - "sort" Retrieving the value for use in a sort comparison
     * 
     *  - "group" Retrieving the value for use in a group comparison
     * 
     *  - "formula" Retrieving the value for use in a formula calculation
     * 
     *  - "vm_getValue" Retrieving the value from ValuesManager.getValue
     * 
     *  - "validate" Retrieving the value for validation, or setting the value if validation
     *            caused it to change
     * 
     *  - "compare" Retrieving the "old" or "new" value from ListGrid.cellHasChanges
     * 
     *  - "getRawValue" Retrieving the raw value of a ListGrid cell
     * 
     *  - "criteria" Setting the value from DynamicForm.setValuesAsCriteria
     * 
     *  - "updateValue" Setting the value from internal methods of DynamicForm
     *             or ValuesManager
     * 
     *  - "setRawValue" Setting the raw value of a ListGrid cell
     * 
     *  - "saveLocally" Setting the value from ListGrid.saveLocally
     * 
     * 
     * 
     *  @param {any} Raw data value to convert. Typically this would be a field  value for some record.
     *  @param {string} The reason your getAtomicValue() method is being  called
     */
    open fun getAtomicValue(value: dynamic, reason: String): dynamic = definedExternally
    /**
     *   Optional method to update a live data value with an edited atomic value
     *   (such as a string or number). If defined this method will be called
     *   when the user edits data in a field of this type, allowing the developer
     *   to convert from the atomic type to a raw data value for storage.
     * 
     *   Note that if the user is editing a field which did not previously have a value, the
     *   'currentValue' will be null. This method should handle this (creating a new data value).
     * 
     * 
     *  @param {any} New atomic value. This should match the underlying atomic type specified by the SimpleType.inheritsFrom attribute.
     *  @param {any} Existing data value to be updated.
     *  @param {string} The reason your updateAtomicValue() method is being  called. See SimpleType.getAtomicValue for the reason strings used by the framework
     */
    open fun updateAtomicValue(atomicValue: dynamic, currentValue: dynamic, reason: String): dynamic = definedExternally
    /**
     *   Optional method to allow you to write a custom comparator for this SimpleType. If
     *   implemented, this method will be used by the framework when it needs to compare two
     *   values of a field for equality - for example, when considering if an edited field
     *   value has changed. If you do not implement this method, values will be compared using
     *   standard techniques, so you should only provide an implementation if you have some
     *   unusual requirement.
     * 
     *   Implementations of this method should return the following:
     * 
     *  - 0 if the two values are equal
     * 
     *  - -1 if the first value is greater than the second
     * 
     *  - 1 if the second value is greater than the first
     * 
     * 
     * 
     *  @param {any} First value for comparison
     *  @param {any} Second value for comparison
     *  @param {DataSourceField | ListGridField | DetailViewerField | FormItem} Field definition from a dataSource or dataBoundComponent.
     */
    open fun compareValues(value1: dynamic, value2: dynamic, field: dynamic): Number = definedExternally
    /**
     *   Formatter for values of this type when compact display is required, for example, in a
     *   ListGrid or TreeGrid.
     * 
     *   When this formatter is called, the SimpleType object is available as "this".
     * 
     *   A formatter can make itself configurable on a per-component or per-field basis by
     *   checking properties on the component or field. For example, a formatter for account IDs
     *   may want to omit a prefix in views where it is redundant, and could check a flag
     *   listGridField.omitAccountIdPrefix for this purpose.
     * 
     * 
     *  @param {any} value to be formatted
     *  @param {string=} field descriptor from the component calling the formatter, if           applicable. Depending on the calling component, this could be a            ListGridField, TreeGridField, etc
     *  @param {DataBoundComponent=} component calling this formatter, if applicable
     *  @param {object=} Full record, if applicable
     */
    open fun shortDisplayFormatter(value: dynamic, field: String?, component: DataBoundComponent?, record: dynamic?): Unit = definedExternally
    /**
     *   Normal formatter for values of this type used in a StaticTextItem or
     *   DetailViewer.
     * 
     *   When this formatter is called, the SimpleType object is available as "this".
     * 
     *   A formatter can make itself configurable on a per-component or per-field basis by
     *   checking properties on the component or field. For example, a formatter for account IDs
     *   may want to omit a prefix in views where it is redundant, and could check a flag
     *   detailViewer.omitAccountIdPrefix for this purpose.
     * 
     * 
     *  @param {any} value to be formatted
     *  @param {string=} field descriptor from the component calling the formatter, if           applicable. Depending on the calling component, this could be a            FormItem, DetailViewerField, etc
     *  @param {DataBoundComponent=} component calling this formatter, if applicable
     *  @param {object=} Full record, if applicable
     */
    open fun normalDisplayFormatter(value: dynamic, field: String?, component: DataBoundComponent?, record: dynamic?): Unit = definedExternally
    /**
     *   Formatter for values of this type when displayed in a freeform text editor, such as
     *   a TextItem.
     * 
     *   See also SimpleType.parseInput for parsing an edited text value back to
     *   a data value.
     * 
     *  @param {any} value to be formatted
     *  @param {FormItem=} Editor for this field
     *  @param {DynamicForm=} DynamicForm containing this editor
     *  @param {Record=} Current edit values for this record, as displayed in   the edit component.
     */
    open fun editFormatter(value: dynamic, field: FormItem?, form: DynamicForm?, record: Record?): String = definedExternally
    /**
     *   Parser to convert some user-edited value to an underlying data value of this type.
     *   This parser is called when storing out values edited in a freeform editor such as
     *   a TextItem. Typically this will convert from the format produced by
     *   SimpleType.editFormatter back to a data value.
     * 
     * 
     *  @param {string} edited value provided by the user
     *  @param {FormItem=} Editor for this field
     *  @param {DynamicForm=} DynamicForm containing this editor
     *  @param {Record=} Current edit values for this record, as displayed in   the edit component.
     */
    open fun parseInput(value: String, field: FormItem?, form: DynamicForm?, record: Record?): dynamic = definedExternally
    /**
     *   Returns the set of SimpleType.groupingModes available for values
     *   of this type in components that support grouping.
     * 
     */
    open fun getGroupingModes(): dynamic = definedExternally
    /**
     *   Returns a group value appropriate for the passed record, field and value, in the passed
     *   component.
     * 
     * 
     *  @param {any} the record value to return a group value for
     *  @param {Record} the record containing the passed value
     *  @param {object} the field relating to the value to be processed
     *  @param {string} the name of the field relating to the value to be processed
     *  @param {Canvas} the component, usually a ListGrid, containing the              passed record
     */
    open fun getGroupValue(value: dynamic, record: Record, field: dynamic, fieldName: String, component: Canvas): dynamic = definedExternally
    /**
     *   Returns a string value appropriate for the title of the group containing the passed
     *   value.
     * 
     * 
     *  @param {any} the record value to return a group title for
     *  @param {Record} the record containing the passed group value
     *  @param {object} the field relating to the value to be processed
     *  @param {string} the name of the field relating to the value to be processed
     *  @param {Canvas} the component, usually a ListGrid, containing the              passed record
     */
    open fun getGroupTitle(value: dynamic, record: Record, field: dynamic, fieldName: String, component: Canvas): String = definedExternally
    companion object {
        /**
         *  Creates a new SimpleType
         * 
         *  @param typeCheckedProperties {Partial<SimpleType>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {SimpleType} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): SimpleType = definedExternally
        /**
         *   Retrieve a simpleType definition by type name
         * 
         *  @param {string} the name of the simpleType to return
         */
        fun getType(typeName: String): SimpleType = definedExternally
        /**
         *   Registers a new SummaryFunction by name. After calling this method,
         *   developers may specify the name passed in as a standard summaryFunction
         *   (for example in ListGridField.summaryFunction).
         * 
         *  @param {string} name for the newly registered summaryFunction
         *  @param {Function} New summary function. This function should take 2 parameters
         *  - records: an array of records for which a summary must be generated
         *  - field: a field definition
         *  - summaryConfig: summary configuration (see SummaryConfiguration)  and return a summary value for the field across the records.
         */
        fun registerSummaryFunction(functionName: String, method: (() -> dynamic)): Unit = definedExternally
        /**
         *   Set up a default summary function for some field type.
         * 
         *   Note that the following default summary functions are set up when SmartClient initializes:
         *   - "integer" defaults to "sum"
         *   - "float" defaults to "sum".
         * 
         * 
         *  @param {string} type name
         *  @param {SummaryFunction} summary function to set as the default for  this data type.
         */
        fun setDefaultSummaryFunction(typeName: String, summaryFunction: 
                                                                         /**
                                                                          *  Client: iterates through the set of records, picking up and summing all numeric values for the specified field. Returns null to indicate invalid summary value if
                                                                          *   any non numeric field values are encountered.
                                                                          *   Server: acts exactly like SQL SUM function.
                                                                          *  Client: iterates through the set of records, picking up all numeric values for the specified field and determining the mean value. Returns null to indicate invalid
                                                                          *   summary value if any non numeric field values are encountered.
                                                                          *   Server: acts exactly like SQL AVG function.
                                                                          *  Client: iterates through the set of records, picking up all values for the specified field and finding the maximum value. Handles numeric fields and
                                                                          *   date type fields only. Returns null to indicate invalid
                                                                          *   summary value if any non numeric/date field values are encountered.
                                                                          *   Server: acts exactly like SQL MAX function.
                                                                          *  Client: iterates through the set of records, picking up all values for the specified field and finding the minimum value. Handles numeric fields and
                                                                          *   date type fields only. Returns null to indicate invalid summary value if
                                                                          *   any non numeric field values are encountered.
                                                                          *   Server: acts exactly like SQL MIN function.
                                                                          *  Client: iterates through the set of records, picking up all numeric values for the specified field and multiplying them together.
                                                                          *   Returns null to indicate invalid summary value if
                                                                          *   any non numeric field values are encountered.
                                                                          *   Server: not supported.
                                                                          *  Client: returns a numeric count of the total number of records passed in. Server: acts exactly like SQL COUNT function.
                                                                          *  Client: returns field.summaryValueTitle if specified, otherwise field.title
                                                                          *   Server: not supported.
                                                                          *  Client: Currently the same as the min function. Server: implemented as SQL MIN function.
                                                                          *  Client: iterates through the set of records, producing a string with each value concatenated to the end.
                                                                          *   Server: implemented as SQL CONCAT function. Supported only by SQLDataSource. Note that it
                                                                          *   is natively supported only by Oracle DB driver, other drivers perform additional query to fetch
                                                                          *   values for concatenation. See also DataSourceField.joinPrefix,
                                                                          *   DataSourceField.joinString and DataSourceField.joinSuffix
                                                                          *   related datasource field attributes.
                                                                          */
                                                                         String /* sum |  avg |  max |  min |  multiplier |  count |  title |  first |  concat */): Unit = definedExternally
        /**
         *   Retrieves the default summary function for some field type.
         * 
         *  @param {string} type name
         */
        fun getDefaultSummaryFunction(typeName: String): 
                                                         /**
                                                          *  Client: iterates through the set of records, picking up and summing all numeric values for the specified field. Returns null to indicate invalid summary value if
                                                          *   any non numeric field values are encountered.
                                                          *   Server: acts exactly like SQL SUM function.
                                                          *  Client: iterates through the set of records, picking up all numeric values for the specified field and determining the mean value. Returns null to indicate invalid
                                                          *   summary value if any non numeric field values are encountered.
                                                          *   Server: acts exactly like SQL AVG function.
                                                          *  Client: iterates through the set of records, picking up all values for the specified field and finding the maximum value. Handles numeric fields and
                                                          *   date type fields only. Returns null to indicate invalid
                                                          *   summary value if any non numeric/date field values are encountered.
                                                          *   Server: acts exactly like SQL MAX function.
                                                          *  Client: iterates through the set of records, picking up all values for the specified field and finding the minimum value. Handles numeric fields and
                                                          *   date type fields only. Returns null to indicate invalid summary value if
                                                          *   any non numeric field values are encountered.
                                                          *   Server: acts exactly like SQL MIN function.
                                                          *  Client: iterates through the set of records, picking up all numeric values for the specified field and multiplying them together.
                                                          *   Returns null to indicate invalid summary value if
                                                          *   any non numeric field values are encountered.
                                                          *   Server: not supported.
                                                          *  Client: returns a numeric count of the total number of records passed in. Server: acts exactly like SQL COUNT function.
                                                          *  Client: returns field.summaryValueTitle if specified, otherwise field.title
                                                          *   Server: not supported.
                                                          *  Client: Currently the same as the min function. Server: implemented as SQL MIN function.
                                                          *  Client: iterates through the set of records, producing a string with each value concatenated to the end.
                                                          *   Server: implemented as SQL CONCAT function. Supported only by SQLDataSource. Note that it
                                                          *   is natively supported only by Oracle DB driver, other drivers perform additional query to fetch
                                                          *   values for concatenation. See also DataSourceField.joinPrefix,
                                                          *   DataSourceField.joinString and DataSourceField.joinSuffix
                                                          *   related datasource field attributes.
                                                          */
                                                         String /* sum |  avg |  max |  min |  multiplier |  count |  title |  first |  concat */ = definedExternally
        /**
         *   Applies a SummaryFunction to an array of records
         * 
         *  @param {Array<Partial<object>>} set of records to retrieve a summary value for
         *  @param {DataSourceField} field for which we're picking up a summary value
         *  @param {SummaryFunction} SummaryFunction to apply to the records in order to retrieve the summary value. May be specified as an explicit function  or string of script to execute, or a SummaryFunction identifier
         *  @param {SummaryConfiguration} config that affects summary calculation
         */
        fun applySummaryFunction(records: Array<dynamic>, field: DataSourceField, summaryFunction: 
                                                                                                   /**
                                                                                                    *  Client: iterates through the set of records, picking up and summing all numeric values for the specified field. Returns null to indicate invalid summary value if
                                                                                                    *   any non numeric field values are encountered.
                                                                                                    *   Server: acts exactly like SQL SUM function.
                                                                                                    *  Client: iterates through the set of records, picking up all numeric values for the specified field and determining the mean value. Returns null to indicate invalid
                                                                                                    *   summary value if any non numeric field values are encountered.
                                                                                                    *   Server: acts exactly like SQL AVG function.
                                                                                                    *  Client: iterates through the set of records, picking up all values for the specified field and finding the maximum value. Handles numeric fields and
                                                                                                    *   date type fields only. Returns null to indicate invalid
                                                                                                    *   summary value if any non numeric/date field values are encountered.
                                                                                                    *   Server: acts exactly like SQL MAX function.
                                                                                                    *  Client: iterates through the set of records, picking up all values for the specified field and finding the minimum value. Handles numeric fields and
                                                                                                    *   date type fields only. Returns null to indicate invalid summary value if
                                                                                                    *   any non numeric field values are encountered.
                                                                                                    *   Server: acts exactly like SQL MIN function.
                                                                                                    *  Client: iterates through the set of records, picking up all numeric values for the specified field and multiplying them together.
                                                                                                    *   Returns null to indicate invalid summary value if
                                                                                                    *   any non numeric field values are encountered.
                                                                                                    *   Server: not supported.
                                                                                                    *  Client: returns a numeric count of the total number of records passed in. Server: acts exactly like SQL COUNT function.
                                                                                                    *  Client: returns field.summaryValueTitle if specified, otherwise field.title
                                                                                                    *   Server: not supported.
                                                                                                    *  Client: Currently the same as the min function. Server: implemented as SQL MIN function.
                                                                                                    *  Client: iterates through the set of records, producing a string with each value concatenated to the end.
                                                                                                    *   Server: implemented as SQL CONCAT function. Supported only by SQLDataSource. Note that it
                                                                                                    *   is natively supported only by Oracle DB driver, other drivers perform additional query to fetch
                                                                                                    *   values for concatenation. See also DataSourceField.joinPrefix,
                                                                                                    *   DataSourceField.joinString and DataSourceField.joinSuffix
                                                                                                    *   related datasource field attributes.
                                                                                                    */
                                                                                                   String /* sum |  avg |  max |  min |  multiplier |  count |  title |  first |  concat */, summaryConfig: SummaryConfiguration): dynamic = definedExternally
    }
}