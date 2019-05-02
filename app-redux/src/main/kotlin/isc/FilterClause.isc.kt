@file:JsQualifier("isc")
package isc

/**
 *  A horizontal, Layout-based widget that allows a user to input a single criterion based on
 *   one field and one operator.
 * 
 *   Note that FilterClauses must be used in conjunction with a FilterBuilder. By default
 *   the FilterBuilder will auto-generate its clauses based on specified criteria, but for advanced
 *   usage a FilterClause may be instantiated directly and passed to a filterBuilder via
 *   FilterBuilder.addClause.
 */
open external class FilterClause : Layout {
    /**
     *  Initial criterion for this FilterClause.
     * 
     *   When initialized with a criterion, the clause will be automatically set up for editing
     *   the supplied criterion.
     * 
     *   Note that an empty or partial criterion is allowed, for example, it may specify
     *   Criterion.fieldName only and will generate an expression with the operator not chosen.
     *  @type {Criteria}
     *  @default null
     */
    open var criterion: dynamic = definedExternally
    /**
     *  If true (the default), show field titles in the drop-down box used to select a field for querying.
     *   If false, show actual field names instead.
     *  @type {boolean}
     *  @default true
     */
    open var showFieldTitles: Boolean = definedExternally
    /**
     *  If true (the default), validates the entered value when it changes, to make sure it is a
     *   a valid value of its type (valid string, number, and so on). No other validation is
     *   carried out. If you switch this property off, it is still possible to validate the
     *   FilterClause by calling FilterClause.validate from your own code.
     *  @type {boolean}
     *  @default true
     */
    open var validateOnChange: Boolean = definedExternally
    /**
     *  AutoChild for the FormItem that allows a user to pick a DataSource field when
     *   creating filter clauses.
     * 
     *   This will be a SelectItem by default, or a ComboBoxItem if
     *   FilterBuilder.fieldDataSource has been specified.
     *  @type {PickList}
     *  @default null
     */
    open var fieldPicker: PickList = definedExternally
    /**
     *  The title for the FieldPicker select-item.
     *  @type {string}
     *  @default "Field Name"
     */
    open var fieldPickerTitle: String = definedExternally
    /**
     *  Properties to combine with the FieldPicker autoChild FormItem.
     *  @type {FormItem}
     *  @default null
     */
    open var fieldPickerProperties: FormItem = definedExternally
    /**
     *  AutoChild for the FormItem that allows a user to select the operator
     *   when creating filter clauses. Each clause will create an operatorPicker automatically.
     *   To customize this item, use FilterClause.operatorPickerProperties
     *  @type {SelectItem}
     *  @default null
     */
    open var operatorPicker: SelectItem = definedExternally
    /**
     *  Properties to combine with the FilterClause.operatorPicker autoChild FormItem.
     *  @type {FormItem}
     *  @default null
     */
    open var operatorPickerProperties: FormItem = definedExternally
    /**
     *  The title for the operator-picker select-item.
     *  @type {string}
     *  @default "Operator"
     */
    open var operatorPickerTitle: String = definedExternally
    /**
     *  The title for the value-item.
     *  @type {string}
     *  @default "Value"
     */
    open var valueItemTitle: String = definedExternally
    /**
     *  A hint to show in the value-item when using an operator that takes an array of values.
     *  @type {string}
     *  @default "Comma-separated values"
     */
    open var valueSetHint: String = definedExternally
    /**
     *  A hint to show in the value-item when using an operator that takes user-entered values.
     *  @type {string}
     *  @default "Enter a value"
     */
    open var valueItemTextHint: String = definedExternally
    /**
     *  A hint to show in the value-item when using an operator that allows users to select values
     *   from a list.
     *  @type {string}
     *  @default "Select a value"
     */
    open var valueItemListHint: String = definedExternally
    /**
     *  A hint to show in the value-item when using an operator that allows users to select
     *   field-names from a list.
     *  @type {string}
     *  @default "Select a field"
     */
    open var valueItemFieldHint: String = definedExternally
    /**
     *  AutoChild containing the UI for the filter-properties in this FilterClause.
     *  @type {SearchForm}
     *  @default null
     */
    open var clause: SearchForm = definedExternally
    /**
     *  If set, show a button for this clause allowing it to be removed.
     *  @type {boolean}
     *  @default true
     */
    open var showRemoveButton: Boolean = definedExternally
    /**
     *  The hover prompt text for the remove button.
     *  @type {string}
     *  @default "Remove"
     */
    open var removeButtonPrompt: String = definedExternally
    /**
     *  The clause removal ImgButton that appears before this clause if
     *   FilterClause.showRemoveButton is set.
     *  @type {ImgButton}
     *  @default null
     */
    open var removeButton: ImgButton = definedExternally
    /**
     *   Returns the FilterBuilder containing this clause, or null if
     *   this filterClause is not embedded in a filterBuilder.
     * 
     */
    open fun getFilterBuilder(): Unit = definedExternally
    /**
     * 
     *   Override to return properties for the FormItem(s) used for the "value" field displayed in this
     *   filterClause.
     * 
     *   Default implementation simply calls FilterBuilder.getValueFieldProperties on the
     *   filterBuilder in which this clause is displayed.
     * 
     *   Note that the Operator.valueType impacts when this method is called. For operators with
     *   valueType "fieldType" or "custom", a single value field is displayed.
     *   For operators with valueType "valueRange" two value-field items are displayed
     *   (one for the start and one for the end position). The valueItemType parameter may
     *   be used to determine which form item is being generated.
     * 
     * 
     *  @param {FieldType} type of the DataSource field for this filter row
     *  @param {string} name of the DataSource field for this filter row
     *  @param {OperatorId} OperatorId for the chosen operator
     *  @param {ValueItemType} What valueItem is being generated.
     */
    open fun getValueFieldProperties(type: 
                                           /**
                                            *  Generic text, e.g. "John Doe". This is the default field type.          Use field.length to set length.
                                            *  A boolean value, e.g. true
                                            *  A whole number, e.g. 123
                                            *  A floating point (decimal) number, e.g. 1.23
                                            *  A logical date, with no time value (such as a holiday or birthday).          Represented on the client as a JavaScript Date object where
                                            *            time values are ignored. See dateFormatAndStorage for more
                                            *            information on date display and serialization formats.
                                            *  A time of day, with no date. Represented on the client as a JavaScript          Date object in UTC/GMT by default (see also
                                            *            dateFormatAndStorage and the Time class).
                                            *  A date and time, accurate to the second. Represented on the client as a           JavaScript Date object. See also
                                            *            dateFormatAndStorage.
                                            *  A text value constrained to a set of legal values specified by the          field's DataSourceField.valueMap, as though a
                                            *            ValidatorType of "isOneOf" had been declared.
                                            *  An enum whose values are numeric.
                                            *  If you are using the SmartClient SQL datasource connector, a          sequence is a unique, increasing whole number, incremented
                                            *            whenever a new record is added. Otherwise, sequence behaves
                                            *            identically to integer. This type is typically used with
                                            *            field.primaryKey to auto-generate unique primary keys.
                                            *            See also DataSourceField.sequenceName and
                                            *            DataSource.sequenceMode
                                            *  A string representing a well-formed URL. Some components          will render this as an HTML link (using an anchor tag for example).
                                            *  A string representing a well-formed URL that points to an          image. Some components will render an IMG tag with the value of this field
                                            *            as the 'src' attribute to render the image.
                                            *  Arbitrary binary data. When this field type is present, three additional fields are automatically generated. They are: &lt;fieldName&gt;_filename, &lt;fieldName&gt;_filesize, and
                                            *   &lt;fieldName&gt;_date_created where &lt;fieldName&gt; is the value of the name
                                            *   attribute of this field. These fields are marked as
                                            *   DataSourceField.hidden:true to suppress their rendering by default. You
                                            *   can show one or more of these fields by specifying the field with a hidden:false
                                            *   override in the fields array of the databound component.
                                            *   Stream / view file support for custom DataSources: a custom DataSource or DMI
                                            *   must implement the "viewFile" and "downloadFile" operationTypes and return a single Record
                                            *   with a byte[] as the field value for the binary field. For more detail see
                                            *   the overview of binaryFields.
                                            *  Binary data comprising an image. Causes ViewFileItem to be used          when the field is displayed in a form, allowing the image to optionally
                                            *            be displayed inline.
                                            *  Fields of this type can contain any data value and have no default           formatting or validation behavior. This is useful as the
                                            *            SimpleType.inheritsFrom for SimpleTypes
                                            *            where you do not want any of the standard validation or formatting logic
                                            *            to be inherited from the standard built-in types.
                                            *  Synonymous with "any".
                                            *  Fields of this type are automatically populated by the SmartClient Server           with the current authenticated userId as part of "add" and "update"
                                            *            operations. By default, fields of this type are hidden and not editable;
                                            *            the server ignores any value that the client sends in a field of this type.
                                            *            Note that the "authenticated user" can be set explicitly on the server-side
                                            *            RPCManager using the setUserId() method, or it can come from
                                            *            the servlet API if you are using its built-in authentication scheme. See
                                            *            the server-side Javadocs for RPCManager.
                                            *  Fields of this type are automatically populated by the SmartClient          Server with the current date and time as part of "add" and "update"
                                            *            operations. By default, fields of this type are hidden and not editable;
                                            *            the server ignores any value that the client sends in a field of this type.
                                            *  Fields of this type are automatically populated by the SmartClient Server           with the current authenticated userId as part of "add" operations.
                                            *            By default, fields of this type are hidden and not editable;
                                            *            the server ignores any value that the client sends in a field of this type.
                                            *            The notes about type "modifier" also apply to fields of this type.
                                            *  Fields of this type are automatically populated by the SmartClient          Server with the current date and time as part of an "add" operation (when
                                            *            the record is first created). By default, fields of this type are hidden
                                            *            and not editable; the server ignores any value that the client sends in a
                                            *            field of this type.
                                            *  Same as "text", but causes PasswordItem to be used by default for          editing (hides typed-in value).
                                            *  A special field type specifically for use with Unicode data in conjunction          with the Microsoft SQL Server database. Field type "ntext" implies the
                                            *            use of DataSourceField.sqlStorageStrategy "ntext";
                                            *            other than that, this type is identical to "text"
                                            *  An integer number with locale-based formatting, e.g. 12,345,678.          See localizedNumberFormatting
                                            *            for more info.
                                            *  A float number with locale-based formatting, e.g. 12,345.67.          See localizedNumberFormatting
                                            *            for more info.
                                            *  A float number with locale-based formatting and using currency          symbol, e.g. $12,345.67.
                                            *            See localizedNumberFormatting
                                            *            for more info.
                                            *  A telephone number. Uses FormItem.browserInputType "tel" to          hint to the device to restrict input. On most mobile devices that have
                                            *            software keyboards, this cause a specialized keyboard to appear which
                                            *            only allows entry of normal phone numbers. When displayed read-only,
                                            *            a "phoneNumber" renders as an HTML link with the "tel:" URL scheme,
                                            *            which will invoke the native phone dialing interface on most mobile
                                            *            devices. In addition, the CSS style "sc_phoneNumber" is applied.
                                            * 
                                            *            By default, "phoneNumber" fields do not include validators, however the
                                            *            following validator definition would limit to digits, dashes and the
                                            *            "+" character:
                                            *            xml:
                                            * 
                                            *            &lt;validator type="regexp" expression="^(\(?\+?[0-9]\*\)?)?[0-9_\- \(\)]\*$"
                                            *              errorMessage="Phone number should be in the correct format e.g. +#(###)###-##-##" /&gt;
                                            * 
                                            * 
                                            *              or directly in JavaScript:
                                            * 
                                            * 
                                            *   {type:"regexp", expression:"^(\\(?\\+?[0-9]\*\\)?)?[0-9_\\- \\(\\)]\*$", 
                                            *     errorMessage:"Phone number should be in the correct format e.g. +#(###)###-##-##"}
                                            * 
                                            * 
                                            * 
                                            *            and adding "#" and "\*" to the regular expressions above would allow for
                                            *            users to enter special keys sometimes used for extension numbers or
                                            *            pauses
                                            */
                                           String /* text |  boolean |  integer |  float |  date |  time |  datetime |  enum |  intEnum |  sequence |  link |  image |  binary |  imageFile |  any |  custom |  modifier |  modifierTimestamp |  creator |  creatorTimestamp |  password |  ntext |  localeInt |  localeFloat |  localeCurrency |  phoneNumber */, fieldName: String, operatorId: 
                                                                                                                                                                                                                                                                                                                                                                                                  /**
                                                                                                                                                                                                                                                                                                                                                                                                   *  exactly equal to
                                                                                                                                                                                                                                                                                                                                                                                                   *  not equal to
                                                                                                                                                                                                                                                                                                                                                                                                   *  exactly equal to, if case is disregarded
                                                                                                                                                                                                                                                                                                                                                                                                   *  not equal to, if case is disregarded
                                                                                                                                                                                                                                                                                                                                                                                                   *  Greater than
                                                                                                                                                                                                                                                                                                                                                                                                   *  Less than
                                                                                                                                                                                                                                                                                                                                                                                                   *  Greater than or equal to
                                                                                                                                                                                                                                                                                                                                                                                                   *  Less than or equal to
                                                                                                                                                                                                                                                                                                                                                                                                   *  Contains as sub-string (match case)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Starts with (match case)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Ends with (match case)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Contains as sub-string (case insensitive)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Starts with (case insensitive)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Ends with (case insensitive)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Does not contain as sub-string (match case)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Does not start with (match case)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Does not end with (match case)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Does not contain as sub-string (case insensitive)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Does not start with (case insensitive)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Does not end with (case insensitive)
                                                                                                                                                                                                                                                                                                                                                                                                   *  shortcut for "greaterThan" + "and" + "lessThan" (case insensitive)
                                                                                                                                                                                                                                                                                                                                                                                                   *  shortcut for "greaterOrEqual" + "and" + "lessOrEqual" (case insensitive)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Basic GLOB matching using wildcards    (see DataSource.translatePatternOperators for more information on available patterns)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Basic GLOB matching using wildcards (case insensitive)    (see DataSource.translatePatternOperators for more information on available patterns)
                                                                                                                                                                                                                                                                                                                                                                                                   *  GLOB matching using wildcards. Value is considered to meet the    criterion if it contains the pattern. See DataSource.translatePatternOperators
                                                                                                                                                                                                                                                                                                                                                                                                   *      for more information on available patterns)
                                                                                                                                                                                                                                                                                                                                                                                                   *  GLOB mathcing using wildcards. Value is considered to meet the    criterion if it starts with the pattern.See DataSource.translatePatternOperators
                                                                                                                                                                                                                                                                                                                                                                                                   *      for more information on available patterns)
                                                                                                                                                                                                                                                                                                                                                                                                   *  GLOB mathcing using wildcards. Value is considered to meet the    criterion if it starts with the pattern.See DataSource.translatePatternOperators
                                                                                                                                                                                                                                                                                                                                                                                                   *      for more information on available patterns)
                                                                                                                                                                                                                                                                                                                                                                                                   *  GLOB matching using wildcards. Value is considered to meet the    criterion if it contains the pattern. Matching is case insensitive. See
                                                                                                                                                                                                                                                                                                                                                                                                   *      DataSource.translatePatternOperators for more information on available patterns)
                                                                                                                                                                                                                                                                                                                                                                                                   *  GLOB matching using wildcards. Value is considered to meet the    criterion if it starts with the pattern. Matching is case insensitive.See
                                                                                                                                                                                                                                                                                                                                                                                                   *      DataSource.translatePatternOperators for more information on available patterns)
                                                                                                                                                                                                                                                                                                                                                                                                   *  GLOB matching using wildcards.Value is considered to meet the    criterion if it ends with the pattern. Matching is case insensitive. See
                                                                                                                                                                                                                                                                                                                                                                                                   *      DataSource.translatePatternOperators for more information on available patterns)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Regular expression match
                                                                                                                                                                                                                                                                                                                                                                                                   *  Regular expression match (case insensitive)
                                                                                                                                                                                                                                                                                                                                                                                                   *  value is either null or the empty string. For numeric fields it behaves as isNull
                                                                                                                                                                                                                                                                                                                                                                                                   *  value is neither null nor the empty string ("")
                                                                                                                                                                                                                                                                                                                                                                                                   *  value is null
                                                                                                                                                                                                                                                                                                                                                                                                   *  value is non-null. Note empty string ("") is non-null
                                                                                                                                                                                                                                                                                                                                                                                                   *  value is in a set of values. Specify criterion.value as an Array
                                                                                                                                                                                                                                                                                                                                                                                                   *  value is not in a set of values. Specify criterion.value as an Array
                                                                                                                                                                                                                                                                                                                                                                                                   *  matches another field (match case, specify fieldName as criterion.value)
                                                                                                                                                                                                                                                                                                                                                                                                   *  does not match another field (match case, specify fieldName as criterion.value)
                                                                                                                                                                                                                                                                                                                                                                                                   *  matches another field (case insensitive, specify fieldName as criterion.value)
                                                                                                                                                                                                                                                                                                                                                                                                   *  does not match another field (case insensitive, specify fieldName as criterion.value)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Greater than another field (specify fieldName as criterion.value)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Less than another field (specify fieldName as criterion.value)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Greater than or equal to another field    (specify fieldName as criterion.value)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Less than or equal to another field    (specify fieldName as criterion.value)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Contains as sub-string (match case) another field value    (specify fieldName as criterion.value)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Starts with (match case) another field value    (specify fieldName as criterion.value)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Ends with (match case) another field value    (specify fieldName as criterion.value)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Contains as sub-string (case insensitive) another field value    (specify fieldName as criterion.value)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Starts with (case insensitive) another field value    (specify fieldName as criterion.value)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Ends with (case insensitive) another field value    (specify fieldName as criterion.value)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Does not contain as sub-string (match case) another field value    (specify fieldName as criterion.value)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Does not start with (match case) another field value    (specify fieldName as criterion.value)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Does not end with (match case) another field value    (specify fieldName as criterion.value)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Does not contain as sub-string (case insensitive) another field value    (specify fieldName as criterion.value)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Does not start with (case insensitive) another field value    (specify fieldName as criterion.value)
                                                                                                                                                                                                                                                                                                                                                                                                   *  Does not end with (case insensitive) another field value    (specify fieldName as criterion.value)
                                                                                                                                                                                                                                                                                                                                                                                                   *  all subcriteria (criterion.criteria) are true
                                                                                                                                                                                                                                                                                                                                                                                                   *  all subcriteria (criterion.criteria) are false
                                                                                                                                                                                                                                                                                                                                                                                                   *  at least one subcriteria (criterion.criteria) is true
                                                                                                                                                                                                                                                                                                                                                                                                   *  shortcut for "greaterThan" + "lessThan" + "and". Specify criterion.start     and criterion.end
                                                                                                                                                                                                                                                                                                                                                                                                   *  shortcut for "greaterOrEqual" + "lessOrEqual" + "and". Specify     criterion.start and criterion.end
                                                                                                                                                                                                                                                                                                                                                                                                   */
                                                                                                                                                                                                                                                                                                                                                                                                  String /* equals |  notEqual |  iEquals |  iNotEqual |  greaterThan |  lessThan |  greaterOrEqual |  lessOrEqual |  contains |  startsWith |  endsWith |  iContains |  iStartsWith |  iEndsWith |  notContains |  notStartsWith |  notEndsWith |  iNotContains |  iNotStartsWith |  iNotEndsWith |  iBetween |  iBetweenInclusive |  matchesPattern |  iMatchesPattern |  containsPattern |  startsWithPattern |  endsWithPattern |  iContainsPattern |  iStartsWithPattern |  iEndsWithPattern |  regexp |  iregexp |  isBlank |  notBlank |  isNull |  notNull |  inSet |  notInSet |  equalsField |  notEqualField |  iEqualsField |  iNotEqualField |  greaterThanField |  lessThanField |  greaterOrEqualField |  lessOrEqualField |  containsField |  startsWithField |  endsWithField |  iContainsField |  iStartsWithField |  iEndsWithField |  notContainsField |  notStartsWithField |  notEndsWithField |  iNotContainsField |  iNotStartsWithField |  iNotEndsWithField |  and |  not |  or |  between |  betweenInclusive */, itemType: 
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       /**
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        *  This is the single form item that will populate the generated  Criterion.value for this clause. This applies for operators with
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        *   Operator.valueType of "fieldType" or "custom".
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        *  This is the single form item that will populate the generated  Criterion.value for Operator.valueType of "fieldName".
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        *  Indicates this item will generate the lower-bound value (or "start") when generating criteria with Operator.valueType "valueRange".
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        *  Indicates this item will generate the higher-bound value (or "end") when generating criteria with Operator.valueType "valueRange".
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        */
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       String /* value |  name |  start |  end */): FormItem = definedExternally
    /**
     *   Remove this clause by destroy()ing it.
     * 
     * 
     */
    open fun remove(): Unit = definedExternally
    /**
     *   Return the criterion specified by this FilterClause.
     * 
     * 
     */
    open fun getCriterion(): dynamic = definedExternally
    /**
     *   Validate this clause.
     * 
     */
    open fun validate(): Boolean = definedExternally
    /**
     *   Get the list of OperatorId that are valid for this field. By default,
     *   calls through to the same method on FilterBuilder.getFieldOperators,
     *   which defaults to all operators returned by DataSource.getFieldOperators.
     * 
     *   Called whenever the fieldName is changed.
     * 
     * 
     *  @param {string} the name of the field for which to return the set of available      operators
     */
    open fun getFieldOperators(fieldName: String): Array<dynamic> = definedExternally
    companion object {
        /**
         *  Creates a new FilterClause
         * 
         *  @param typeCheckedProperties {Partial<FilterClause>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {FilterClause} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): FilterClause = definedExternally
    }
}