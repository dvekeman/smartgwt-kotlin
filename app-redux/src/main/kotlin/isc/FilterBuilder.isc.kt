@file:JsQualifier("isc")
package isc

/**
 *  A form that allows the user to input advanced search criteria, including operators on
 *   field values such as "less than", and sub-clauses using "AND" and "OR" operators.
 * 
 *   A FilterBuilder produces an AdvancedCriteria object, which the DataSource
 *   subsystem can use to filter datasets, including the ability to perform such filtering within
 *   the browser for datasets that are completely loaded.
 * 
 *   The operators available for each field can be customized at the DataSource level via
 *   DataSourceField.validOperators, DataSource.setTypeOperators and related
 *   APIs.
 */
open external class FilterBuilder : Layout {
    /**
     *  The message to display next to fieldNames that do not exist in the available dataSource.
     *  @type {string}
     *  @default "[missing field definition]"
     */
    open var missingFieldPrompt: String = definedExternally
    /**
     *  If specified, the FilterBuilder will dynamically fetch DataSourceField definitions from
     *   this DataSource rather than using FilterBuilder.dataSource. The FieldPicker
     *   will default to being a ComboBoxItem rather than a SelectItem so that the user
     *   will have type-ahead auto-completion.
     * 
     *   The records returned from the fieldDataSource must have properties
     *   corresponding to a DataSourceField definition, at a minimum,
     *   DataSourceField.name and DataSourceField.type. Any property
     *   legal on a DataSourceField is legal on the returned records, including
     *   DataSourceField.valueMap.
     * 
     *   Even when a fieldDataSource is specified, FilterBuilder.dataSource may
     *   still be specified in order to control the list of
     *   DataSource.setTypeOperators for each field.
     *  @type {DataSource}
     *  @default null
     */
    open var fieldDataSource: DataSource = definedExternally
    /**
     *  Should the FieldPicker items be sorted alphabetically in the drop down list.
     *  @type {boolean}
     *  @default true
     */
    open var sortFields: Boolean = definedExternally
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
     *  The title for the FilterBuilder.fieldPicker select-item.
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
     *   To customize this item, use FilterBuilder.operatorPickerProperties
     *  @type {SelectItem}
     *  @default null
     */
    open var operatorPicker: SelectItem = definedExternally
    /**
     *  Properties to combine with the FilterBuilder.operatorPicker autoChild FormItem.
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
     *  Width for the field picker formItem displayed in clauses within this FilterBuilder.
     *  @type {Integer | string}
     *  @default "\*"
     */
    open var fieldPickerWidth: dynamic = definedExternally
    /**
     *  Width for the operator picker formItem displayed in clauses within this FilterBuilder.
     *  @type {Integer | string}
     *  @default "150"
     */
    open var operatorPickerWidth: dynamic = definedExternally
    /**
     *  Width for the value-chooser formItem displayed in clauses within this FilterBuilder.
     *   Note that depending on the selected operator type, this item may not be displayed, or
     *   may have different characteristics. See FilterBuilder.getValueFieldProperties for information
     *   on customizing the value item.
     *  @type {Integer | string}
     *  @default "150"
     */
    open var valueItemWidth: dynamic = definedExternally
    /**
     *  DataSource this filter should use for field definitions and available Operators.
     *  @type {DataSource | GlobalId}
     *  @default null
     */
    open var dataSource: dynamic = definedExternally
    /**
     *  Initial criteria.
     * 
     *   When initialized with criteria, appropriate clauses for editing the provided criteria will
     *   be automatically generated.
     * 
     *   Note that empty or partial criteria are allowed, for example, criteria that specify
     *   Criterion.fieldName only will generate an expression with the operator not chosen
     *   yet, and a Criterion with a logical operator ("and" or "or") but not
     *   Criterion.criteria defined will generate an empty subclause.
     *  @type {AdvancedCriteria}
     *  @default null
     */
    open var criteria: AdvancedCriteria = definedExternally
    /**
     *  If true, when the user hits the Enter key while focused in a text-item in this
     *   FilterBuilder, we automatically invoke the user-supplied FilterBuilder.search method.
     *  @type {boolean}
     *  @default null
     */
    open var saveOnEnter: Boolean = definedExternally
    /**
     *  If true (the default), show field titles in the drop-down box used to select a field for querying.
     *   If false, show actual field names instead.
     * 
     *   When multiple DataSources are configured,
     *   attr:FilterBuilder.multiDSFieldFormat controls how field names appear
     *   in the field drop-down.
     *  @type {boolean}
     *  @default true
     */
    open var showFieldTitles: Boolean = definedExternally
    /**
     *  If true (the default), validates each entered value when it changes, to make sure it is a
     *   a valid value of its type (valid string, number, and so on). No other validation is
     *   carried out. If you switch this property off, it is still possible to validate the
     *   FilterBuilder by calling FilterBuilder.validate from your own code.
     *  @type {boolean}
     *  @default true
     */
    open var validateOnChange: Boolean = definedExternally
    /**
     *  If set, a button will be shown for each clause allowing it to be removed.
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
     *  The removal ImgButton that appears before each clause if
     *   FilterBuilder.showRemoveButton is set.
     *  @type {ImgButton}
     *  @default null
     */
    open var removeButton: ImgButton = definedExternally
    /**
     *  If set, a button will be shown underneath all current clauses allowing a new clause to be
     *   added.
     *  @type {boolean}
     *  @default true
     */
    open var showAddButton: Boolean = definedExternally
    /**
     *  The hover prompt text for the add button.
     *  @type {string}
     *  @default "Add"
     */
    open var addButtonPrompt: String = definedExternally
    /**
     *  An ImgButton that allows new clauses to be added if FilterBuilder.showAddButton
     *   is set.
     *  @type {ImgButton}
     *  @default null
     */
    open var addButton: ImgButton = definedExternally
    /**
     *  If set to false, the last clause cannot be removed.
     *  @type {boolean}
     *  @default false
     */
    open var allowEmpty: Boolean = definedExternally
    /**
     *  Dictates whether values entered by a user should be retained in the value fields when a
     *   different field is selected. Default value is true.
     * 
     *   Note that, when switching between fields that have an optionDataSource or valueMap, this
     *   property is ignored and the values are never retained.
     *  @type {boolean}
     *  @default true
     */
    open var retainValuesAcrossFields: Boolean = definedExternally
    /**
     *  Logical operators to allow for TopOperatorAppearances of "radio" and "bracket".
     *   Note that this list may be further limited according to the
     *   DataSource.getTypeOperatorMap returned by the
     *   DataSource.
     *  @type {Array<Partial<OperatorId>>}
     *  @default "["and", "or", "not"]"
     */
    open var topOperatorOptions: Array<dynamic> = definedExternally
    /**
     *  Default logical operator for all top-level clauses in the FilterBuilder.
     * 
     *   May be able to be changed by the user via the UI, according to TopOperatorAppearance.
     *  @type {LogicalOperator}
     *  @default "and"
     */
    open var topOperator: 
                          /**
                           *  true if all criteria are true
                           *  true if any criteria are true
                           *  true if all criteria are false
                           */
                          String /* and |  or |  not */ = definedExternally
    /**
     *  Logical operators to allow if we have a TopOperatorAppearance of "radio".
     *  @deprecated \* in favor of FilterBuilder.topOperatorOptions.
     *  @type {Array<Partial<OperatorId>>}
     *  @default "["and", "or", "not"]"
     */
    open var radioOptions: Array<dynamic> = definedExternally
    /**
     *  How to display and edit the FilterBuilder.topOperator for this FilterBuilder.
     * 
     *   See TopOperatorAppearance for a list of options.
     *  @type {TopOperatorAppearance}
     *  @default "bracket"
     */
    open var topOperatorAppearance: 
                                    /**
                                     *  radio buttons appear at the top of the form
                                     *  a SelectItem appears with a "bracket" spanning all top-level clauses, exactly the same appearance used for showing
                                     *   FilterBuilder.showSubClauseButton, if enabled.
                                     *  each line in the FilterBuilder is a top-level item, with a SelectItem shown on the left that allows the user to choose between the main operator in force (either "and"
                                     *   or "or", depending on the setting of topOperator) and "and not".
                                     *  no interface is shown. The top-level operator is expected to be shown to the user outside the FilterBuilder, and, if editable, FilterBuilder.setTopOperator
                                     *   should be called to update it
                                     */
                                    String /* radio |  bracket |  inline |  none */ = definedExternally
    /**
     *  HLayout of radioOperationForm and optional modeSwitcher.
     *  @type {HLayout}
     *  @default null
     */
    open var radioOperatorLayout: HLayout = definedExternally
    /**
     *  With TopOperatorAppearance:"radio", form that appears above the stack of clauses
     *   and allows picking the LogicalOperator for the overall FilterBuilder.
     * 
     *   By default, consists of a simple RadioGroupItem.
     *  @type {DynamicForm}
     *  @default null
     */
    open var radioOperatorForm: DynamicForm = definedExternally
    /**
     *  Label to change between simple and advanced mode. When clicked the filter mode
     *   is switched to the other mode. This label is only shown if
     *   FilterBuilder.showModeSwitcher is true.
     * 
     *   Shows either FilterBuilder.modeSwitcherSimpleMessage or
     *   FilterBuilder.modeSwitcherAdvancedMessage
     *   depending on the current state of the filter.
     *  @type {Label}
     *  @default null
     */
    open var modeSwitcher: Label = definedExternally
    /**
     *  The title for the Operator RadioGroupItem displayed in the FilterBuilder.radioOperatorForm.
     *  @type {string}
     *  @default "Overall Operator"
     */
    open var radioOperatorTitle: String = definedExternally
    /**
     *  If true, causes a CheckboxItem to appear to the left of each clause in "inline"
     *   TopOperatorAppearance. This checkbox allows the user to select
     *   individual clauses so that, for example, clauses can be removed from the filterBuilder
     *   by application code. This property is ignored for appearances other than "inline".
     *  @type {boolean}
     *  @default false
     */
    open var showSelectionCheckbox: Boolean = definedExternally
    /**
     *  With TopOperatorAppearance "bracket" and "inline", a form that appears to the left
     *   of the stack of clauses and allows picking the LogicalOperator for the overall
     *   FilterBuilder (or for that specific FilterClause, in the case of "inline")
     * 
     *   By default, consists of a CheckboxItem if FilterBuilder.showSelectionCheckbox is true, and a
     *   simple SelectItem containing the available logical operators.
     * 
     *   If this FilterBuilder shows nested sub-clauses, the same defaults will be applied to the
     *   top-operator item for each sub-clause.
     *  @type {DynamicForm}
     *  @default null
     */
    open var topOperatorForm: DynamicForm = definedExternally
    /**
     *  Automatically generated SelectItem autoChild shown in the FilterBuilder.topOperatorForm.
     *   Developers may customize this item using the standard autoChild pattern (by
     *   modifying topOperatorItemDefaults and
     *   topOperatorItemProperties).
     * 
     *   If this FilterBuilder shows nested sub-clauses, the same defaults will be applied to the
     *   top-operator item for each sub-clause.
     *  @type {SelectItem}
     *  @default null
     */
    open var topOperatorItem: SelectItem = definedExternally
    /**
     *  Width for the FilterBuilder.topOperatorItem autoChild.
     *  @type {number | string}
     *  @default "\*"
     */
    open var topOperatorItemWidth: dynamic = definedExternally
    /**
     *  The title for the left-aligned Operator selectItem in the FilterBuilder.topOperatorForm.
     *  @type {string}
     *  @default "Clause Operator"
     */
    open var topOperatorTitle: String = definedExternally
    /**
     *  Default operator for subclauses added via the FilterBuilder.subClauseButton.
     *  @type {LogicalOperator}
     *  @default "or"
     */
    open var defaultSubClauseOperator: 
                                       /**
                                        *  true if all criteria are true
                                        *  true if any criteria are true
                                        *  true if all criteria are false
                                        */
                                       String /* and |  or |  not */ = definedExternally
    /**
     *  Title for the "Match All" (and) operator
     *   when using TopOperatorAppearance:"radio".
     *  @type {string}
     *  @default "Match All"
     */
    open var matchAllTitle: String = definedExternally
    /**
     *  Title for the "Match None" (not) operator
     *   when using TopOperatorAppearance:"radio".
     *  @type {string}
     *  @default "Match None"
     */
    open var matchNoneTitle: String = definedExternally
    /**
     *  Title for the "Match Any" (or) operator
     *   when using TopOperatorAppearance:"radio".
     *  @type {string}
     *  @default "Match Any"
     */
    open var matchAnyTitle: String = definedExternally
    /**
     *  Title for the "And" operator (only applicable to the "inline" appearance)
     *  @type {string}
     *  @default "and"
     */
    open var inlineAndTitle: String = definedExternally
    /**
     *  Title for the "Or" operator (only applicable to the "inline" appearance)
     *  @type {string}
     *  @default "or"
     */
    open var inlineOrTitle: String = definedExternally
    /**
     *  Title for the "And Not" operator (only applicable to the "inline" appearance)
     *  @type {string}
     *  @default "and not"
     */
    open var inlineAndNotTitle: String = definedExternally
    /**
     *  Title for the "Advanced.." mode switcher label (only applicable to the "radio" appearance).
     *  @type {string}
     *  @default "Advanced.."
     */
    open var modeSwitcherAdvancedMessage: String = definedExternally
    /**
     *  Title for the "Simple Mode.." mode switcher label (only applicable to the "bracket" appearance).
     *  @type {string}
     *  @default "Simple Mode.."
     */
    open var modeSwitcherSimpleMessage: String = definedExternally
    /**
     *  Message displayed when switching to "radio" mode if the criteria will be logically changed.
     *  @type {string}
     *  @default "Criteria will be modified to fit in simpler editing interface"
     */
    open var modeSwitcherFlattenWarningMessage: String = definedExternally
    /**
     *  When enabled allows FilterBuilder in topOperatorAppearance:"radio" or
     *   topOperatorAppearance:"bracket" mode to be switch to the other view by the user.
     *   "radio" mode is considered simple where "bracket" mode is advanced mode.
     * 
     *   Note that when switching from "bracket" to "radio" mode any entered criteria will be
     *   flattened by calling DataSource.flattenCriteria. If the criteria cannot be
     *   flattened without losing symantics (see DataSource.canFlattenCriteria) the user is
     *   prompted to confirm.
     * 
     *   If showModeSwitcher is set and topOperatorAppearance is unset:
     * 
     * 
     *  - when first drawn, the filterBuilder will choose which mode to use based on the
     *     provided FilterBuilder.criteria if any: advanced mode ("bracket") will be used if
     *     AdvancedCriteria are provided which cannot be flattened without loss of data (see
     *     DataSource.canFlattenCriteria), otherwise simple mode ("radio") will be used.
     * 
     *  - for any calls to FilterBuilder.setCriteria after draw, the FilterBuilder will
     *     switch to advanced mode if the criteria cannot be shown in simple mode without losing
     *     information, but will never automatically switch to simple mode, but an explicit call
     *     FilterBuilder.setTopOperatorAppearance can be used to do so.
     * 
     *  @type {boolean}
     *  @default null
     */
    open var showModeSwitcher: Boolean = definedExternally
    /**
     *  VStack of all clauses that are part of this FilterBuilder
     *  @type {VStack}
     *  @default null
     */
    open var clauseStack: VStack = definedExternally
    /**
     *  For operators that check that a value is within a range, text to show between the start and
     *   end input fields for specifying the limits of the range.
     *  @type {string}
     *  @default "and"
     */
    open var rangeSeparator: String = definedExternally
    /**
     *  Whether to show a button that allows the user to add subclauses. Defaults to false if
     *   the TopOperatorAppearance is "radio" or "inline", true in all other cases.
     *  @type {boolean}
     *  @default "See Description"
     */
    open var showSubClauseButton: Boolean = definedExternally
    /**
     *  The title of the subClauseButton
     *  @type {string}
     *  @default "+()"
     */
    open var subClauseButtonTitle: String = definedExternally
    /**
     *  The hover prompt text for the subClauseButton.
     *  @type {string}
     *  @default "Add Subclause"
     */
    open var subClauseButtonPrompt: String = definedExternally
    /**
     *  Button allowing the user to add subclauses grouped by a LogicalOperator.
     *  @type {IButton}
     *  @default null
     */
    open var subClauseButton: IButton = definedExternally
    /**
     *  Widget used as a "bracket" to hint to the user that a subclause groups several
     *   field-by-field filter criteria under one logical operator.
     * 
     *   By default, a simple CSS-style Canvas with borders on three sides. A vertical StretchImg
     *   could provide a more elaborate appearance.
     *  @type {Canvas}
     *  @default null
     */
    open var bracket: Canvas = definedExternally
    /**
     *   Remove a clause this FilterBuilder is currently showing.
     * 
     *  @param {FilterClause} clause as retrieved from filterBuilder.clauses
     */
    open fun removeClause(clause: FilterClause): Unit = definedExternally
    /**
     *   Programmatically change the FilterBuilder.topOperator for this FilterBuilder.
     * 
     *  @param {LogicalOperator} new top-level operator
     */
    open fun setTopOperator(operator: 
                                      /**
                                       *  true if all criteria are true
                                       *  true if any criteria are true
                                       *  true if all criteria are false
                                       */
                                      String /* and |  or |  not */): Unit = definedExternally
    /**
     *   Modify TopOperatorAppearance at runtime.
     * 
     *   Note that when changing from "bracket" to "radio" mode the criteria
     *   will be flattened by calling DataSource.flattenCriteria which could
     *   result in a logical change to the criteria.
     * 
     * 
     *  @param {TopOperatorAppearance} new topOperatorAppearance
     */
    open fun setTopOperatorAppearance(appearance: 
                                                  /**
                                                   *  radio buttons appear at the top of the form
                                                   *  a SelectItem appears with a "bracket" spanning all top-level clauses, exactly the same appearance used for showing
                                                   *   FilterBuilder.showSubClauseButton, if enabled.
                                                   *  each line in the FilterBuilder is a top-level item, with a SelectItem shown on the left that allows the user to choose between the main operator in force (either "and"
                                                   *   or "or", depending on the setting of topOperator) and "and not".
                                                   *  no interface is shown. The top-level operator is expected to be shown to the user outside the FilterBuilder, and, if editable, FilterBuilder.setTopOperator
                                                   *   should be called to update it
                                                   */
                                                  String /* radio |  bracket |  inline |  none */): Unit = definedExternally
    /**
     *   Add a new FilterClause to this FilterBuilder.
     * 
     *   This API is intended for the rare use case of adding a highly customized FilterClause
     *   component that does not include the standard field/operator/value picking interface, instead
     *   providing a custom interface and returning a criterion via FilterClause.getCriterion.
     * 
     *   If you just want to programmatically add a new FilterClause showing a specific Criterion use
     *   FilterBuilder.addCriterion.
     * 
     *   If you want to use the standard field/operator/value interface but provide a custom control
     *   for editing the value, see DataSource.addSearchOperator and Operator.editorType.
     * 
     * 
     *  @param {FilterClause} A FilterClause instance
     */
    open fun addClause(filterClause: FilterClause): Unit = definedExternally
    /**
     *   Returns an array of child FilterBuilders, representing the list of complex
     *   clauses, or an empty array if there aren't any.
     * 
     * 
     */
    open fun getChildFilters(): Array<dynamic> = definedExternally
    /**
     *   Returns a human-readable string describing the clauses in this filterBuilder.
     * 
     * 
     */
    open fun getFilterDescription(): String = definedExternally
    /**
     *   Validate the clauses of this FilterBuilder.
     * 
     */
    open fun validate(): Boolean = definedExternally
    /**
     *   Get the list of OperatorId that are valid for the passed field. By
     *   default, all operators returned by DataSource.getFieldOperators are used.
     * 
     *   Called automatically by the default implementation of the same method on each
     *   FilterClause.getFieldOperators, whenever its fieldName is changed.
     * 
     * 
     *  @param {string} the name of the field for which to return the set of available operators
     */
    open fun getFieldOperators(fieldName: String): Array<dynamic> = definedExternally
    /**
     * 
     *   Override to return properties for the FormItem(s) used for the "value" field displayed within
     *   clauses within this filterBuilder.
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
     *   Get the criteria entered by the user.
     * 
     * 
     *  @param {boolean=} By default if a user has selected a field and operator  type, but has failed to enter a value for the field it will be skipped. This optional parameter  allows you to retrieve all criteria, including those with an empty value attribute.
     */
    open fun getCriteria(includeEmptyValues: Boolean?): AdvancedCriteria = definedExternally
    /**
     *   Set new criteria for editing.
     * 
     *   An interface for editing the provided criteria will be generated identically to what happens
     *   when initialized with Criteria.
     * 
     *   Any existing criteria entered by the user will be discarded.
     * 
     * 
     *  @param {AdvancedCriteria} new criteria. Pass null or {} to effectively reset the                  filterBuilder to it's initial state when no criteria are                   specified
     */
    open fun setCriteria(criteria: AdvancedCriteria): Unit = definedExternally
    /**
     *   Clear all current criteria.
     * 
     */
    open fun clearCriteria(): Unit = definedExternally
    /**
     *   Add a new criterion, including recursively adding sub-criteria for a criterion that
     *   contains other criteria.
     * 
     * 
     *  @param {Criterion} new criterion to be added
     */
    open fun addCriterion(criterion: Criterion): Unit = definedExternally
    /**
     *   Returns the type of editor to use for the field.
     * 
     *   Default behavior is to use the Operator.editorType for a custom operator, otherwise,
     *   use RelativeDateItem for before/after/between operators on date fields, otherwise,
     *   use the same editor as would be chosen by a SearchForm.
     * 
     * 
     *  @param {DataSourceField} DataSourceField definition
     *  @param {OperatorId} OperatorId for the chosen operator
     */
    open fun getEditorType(field: DataSourceField, operatorId: 
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
                                                               String /* equals |  notEqual |  iEquals |  iNotEqual |  greaterThan |  lessThan |  greaterOrEqual |  lessOrEqual |  contains |  startsWith |  endsWith |  iContains |  iStartsWith |  iEndsWith |  notContains |  notStartsWith |  notEndsWith |  iNotContains |  iNotStartsWith |  iNotEndsWith |  iBetween |  iBetweenInclusive |  matchesPattern |  iMatchesPattern |  containsPattern |  startsWithPattern |  endsWithPattern |  iContainsPattern |  iStartsWithPattern |  iEndsWithPattern |  regexp |  iregexp |  isBlank |  notBlank |  isNull |  notNull |  inSet |  notInSet |  equalsField |  notEqualField |  iEqualsField |  iNotEqualField |  greaterThanField |  lessThanField |  greaterOrEqualField |  lessOrEqualField |  containsField |  startsWithField |  endsWithField |  iContainsField |  iStartsWithField |  iEndsWithField |  notContainsField |  notStartsWithField |  notEndsWithField |  iNotContainsField |  iNotStartsWithField |  iNotEndsWithField |  and |  not |  or |  between |  betweenInclusive */): String = definedExternally
    /**
     *   Returns the list of this FilterBuilder's FilterClauses that are currently selected. A
     *   clause is "selected" if the user has checked the checkbox next to it; therefore, this
     *   method always returns an empty list unless the
     *   FilterBuilder.showSelectionCheckbox property is set. This method is only
     *   applicable where TopOperatorAppearance is "inline" (because that is the only
     *   appearance that supports showSelectionCheckbox)
     * 
     * 
     */
    open fun getSelectedClauses(): Array<dynamic> = definedExternally
    /**
     *   A StringMethod that is automatically invoked if FilterBuilder.saveOnEnter is set
     *   and the user presses Enter whilst in a text-item in any clause or subclause.
     * 
     * 
     *  @param {AdvancedCriteria} The criteria represented by the filterBuilder
     */
    open fun search(criteria: AdvancedCriteria): Unit = definedExternally
    /**
     *   Handler fired when there is a change() event fired on any FormItem within the
     *   filterBuilder.
     * 
     * 
     */
    open fun filterChanged(): Unit = definedExternally
    companion object {
        /**
         *  Creates a new FilterBuilder
         * 
         *  @param typeCheckedProperties {Partial<FilterBuilder>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {FilterBuilder} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): FilterBuilder = definedExternally
        /**
         *   Returns a human-readable string describing the clauses in this advanced criteria or criterion.
         * 
         * 
         *  @param {AdvancedCriteria | Criterion} Criteria to convert to a readable string
         *  @param {DataSource} DataSource to provide definitions of operators
         */
        fun getFilterDescription(criteria: dynamic, dataSource: DataSource): String = definedExternally
    }
}