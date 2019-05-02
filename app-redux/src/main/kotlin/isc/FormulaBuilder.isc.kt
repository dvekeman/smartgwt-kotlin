@file:JsQualifier("isc")
package isc

/**
 *  Shows an interface allowing a user to enter simple formulas by typing them into a text
 *   field.
 * 
 *   Available values for the formula are determined by the DataSource fields, and are given
 *   simple single-letter aliases (such as "A", "B", ...) similar to column names in Excel.
 *   The set of available values is shown in the FormulaBuilder.fieldKey as a simple
 *   mapping between the DataSourceField.title and it's short name.
 * 
 *   If FormulaBuilder.targetRuleScope is specified the formula will use full field
 *   path names instead of single-letter aliases and the resulting formula will not include
 *   the formulaVars property.
 * 
 *   By default, available math functions are shown in a hover from the
 *   FormulaBuilder.helpIcon that appears after the formula field.
 */
open external class FormulaBuilder : VLayout {
    /**
     *  DataSource providing the available fields for the formulaBuilder.
     * 
     *   By default the formulaBuilder will include only fields of numeric type or derived
     *   from a numeric type. Set FormulaBuilder.fields to override this.
     *  @type {DataSource | string}
     *  @default null
     */
    open var dataSource: dynamic = definedExternally
    /**
     *  Canvas.ruleScope providing the list of available fields for the formulaBuilder.
     * 
     *   By default the formulaBuilder will include only fields of numeric type or derived
     *   from a numeric type. Set FormulaBuilder.fields to override this.
     * 
     *  @type {string | Canvas}
     *  @default null
     */
    open var targetRuleScope: dynamic = definedExternally
    /**
     *  Set this to override the underlying set of available fields.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var fields: Array<dynamic> = definedExternally
    /**
     *  The Field object representing the field being created or edited.
     *  @type {string}
     *  @default null
     */
    open var field: String = definedExternally
    /**
     *  Are we editing an existing field?
     *  @type {boolean}
     *  @default false
     */
    open var editMode: Boolean = definedExternally
    /**
     *  TextItem that users type into when entering a formula.
     *  @type {TextItem}
     *  @default null
     */
    open var formulaField: TextItem = definedExternally
    /**
     *  TextItem that allows users to set the title for this field.
     *  @type {TextItem}
     *  @default null
     */
    open var titleField: TextItem = definedExternally
    /**
     *  Whether to show the help icon that appears after the FormulaBuilder.formulaField.
     *  @type {boolean}
     *  @default true
     */
    open var showHelpIcon: Boolean = definedExternally
    /**
     *  Icon that appears after the FormulaBuilder.formulaField, showing help on hover.
     *  @type {FormItemIcon}
     *  @default null
     */
    open var helpIcon: FormItemIcon = definedExternally
    /**
     *  Text label for the checkbox that allows the user to automatically hide the
     *   fields used in the formula.
     *  @type {string}
     *  @default "Auto hide fields used in formula"
     */
    open var autoHideCheckBoxLabel: String = definedExternally
    /**
     *  Whether to show a checkbox offering the user the ability to automatically
     *   hide any fields involved in the formula.
     *  @type {boolean}
     *  @default true
     */
    open var showAutoHideCheckBox: Boolean = definedExternally
    /**
     *  CheckBox that, when selected, hides columns in the component that are used in this formula.
     *  @type {TextItem}
     *  @default null
     */
    open var autoHideCheckBox: TextItem = definedExternally
    /**
     *  Indicates whether to use "formula" or some other keyword in various captions and text
     *  @type {string}
     *  @default "Formula"
     */
    open var builderTypeText: String = definedExternally
    /**
     *  The list of math functions available in this FormulaBuilder, as an array of
     *   MathFunction names.
     * 
     *   The following function list is supported in FormulaBuilders by default: min(), max(),
     *   round(), ceil(), floor(), abs(), pow(), sin(), cos(), tan(), ln() and log().
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var mathFunctions: Array<dynamic> = definedExternally
    /**
     *  Was the builder operation cancelled? Set to true when the user cancels with the cancel
     *   button or the dialog's close-button.
     *  @type {boolean}
     *  @default false
     */
    open var cancelled: Boolean = definedExternally
    /**
     *  The prefix to apply to the variable that is inserted in response to a record click in the
     *   grid that shows the list of available fields.
     *  @type {string}
     *  @default null
     */
    open var valuePrefix: String = definedExternally
    /**
     *  The suffix to apply to the variable that is inserted in response to a record click in the
     *   grid that shows the list of available fields.
     *  @type {string}
     *  @default null
     */
    open var valueSuffix: String = definedExternally
    /**
     *  The prompt to show when mouse hovers over a field supplied by
     *   a nearby component through FormulaBuilder.targetRuleScope.
     * 
     *   The prompt is a dynamic string and is formatted like Label.dynamicContents
     *   where the following variables are available:
     * 
     * 
     *  - fieldName
     * 
     *  - componentName
     * 
     *  @type {string}
     *  @default "This value comes from the '${fieldName}' field in the nearby component [${componentName}]"
     */
    open var nearbyComponentFieldPrompt: String = definedExternally
    /**
     *  The prompt to show when mouse hovers over a field supplied by
     *   the current component through FormulaBuilder.targetRuleScope.
     * 
     *   The prompt is a dynamic string and is formatted like Label.dynamicContents
     *   where the following variables are available:
     * 
     * 
     *  - fieldName
     * 
     *  - componentName
     * 
     *  @type {string}
     *  @default "This value comes from the '${fieldName}' field in the current component [${componentName}]"
     */
    open var currentComponentFieldPrompt: String = definedExternally
    /**
     *  The prompt to show when mouse hovers over a field supplied by
     *   a DataSource through FormulaBuilder.targetRuleScope.
     * 
     *   The prompt is a dynamic string and is formatted like Label.dynamicContents
     *   where the following variables are available:
     * 
     * 
     *  - fieldName
     * 
     *  - dataSource
     * 
     *  @type {string}
     *  @default "This value comes from the '${fieldName}' field in any nearby component that uses DataSource '${dataSource}'. Values that are edited by end users are preferred."
     */
    open var dataSourceFieldPrompt: String = definedExternally
    /**
     *  ListGrid displaying the list of available fields and their corresponding formula keys.
     *  @type {ListGrid}
     *  @default null
     */
    open var fieldKey: ListGrid = definedExternally
    /**
     *  The text to display as a preamble to the instruction text that appears in the
     *   FormulaBuilder.instructions.
     * 
     *   This is a dynamic string - text within &#36;{...} are dynamic variables and will
     *   be evaluated as JS code when the message is displayed.
     * 
     *   Only one dynamic variable, builderType, is available and represents the type of this
     *   builder - either Formula or Summary.
     * 
     *   Default value returns
     * 
     *   The following fields are available for use in this [Formula/Summary]
     * 
     *  @type {HTMLString}
     *  @default "The following fields are available for use in this ${builderType}.  Click any field to have it added to the ${builderType}."
     */
    open var instructionsTextStart: String = definedExternally
    /**
     *  Label displaying the instruction text above the fieldKey grid.
     *  @type {Label}
     *  @default null
     */
    open var instructions: Label = definedExternally
    /**
     *  Label used for displaying messages related to the validity of the current formula.
     *  @type {Label}
     *  @default null
     */
    open var messageLabel: Label = definedExternally
    /**
     *  Button to Cancel this FormulaBuilder. The formula is not tested, formulaBuilder.cancelled
     *   is set to true and formulaBuilder.fireOnClose is fired.
     *  @type {Button}
     *  @default null
     */
    open var cancelButton: Button = definedExternally
    /**
     *  Button to Test the formula by generating it's function and executing it
     *  @type {Button}
     *  @default null
     */
    open var testButton: Button = definedExternally
    /**
     *  Button to Save the formula, by generating it's function, testing it and firing
     *   formulaBuilder.fireOnClose, and then start editing another, new one.
     *  @type {Button}
     *  @default null
     */
    open var saveAddAnotherButton: Button = definedExternally
    /**
     *  Button to Save the formula, by generating it's function, testing it and firing
     *   formulaBuilder.fireOnClose
     *  @type {Button}
     *  @default null
     */
    open var saveButton: Button = definedExternally
    /**
     *  When FormulaBuilder.testFunction reports an invalid formula,
     *   this attribute provides the error-text to display in the
     *   FormulaBuilder.messageLabel.
     * 
     *   This is a dynamic string - text within &#36;{...} are dynamic variables and will
     *   be evaluated as JS code when the message is displayed.
     * 
     *   The dynamic variables in this case, builderType and errorText, represent the type of this
     *   builder, either Formula or Summary, and the description of the error, respectively.
     * 
     *   The default output is:
     * 
     *   Invalid [Formula/Summary]: + the description of the error detected
     * 
     *  @type {HTMLString}
     *  @default "Invalid ${builderType}: ${errorText}"
     */
    open var invalidBuilderPrompt: String = definedExternally
    /**
     *  If an invalid builder prompt is displayed, but no explicit error message was returned when
     *   attempting to evaluate the formula, this string will be used as a default.
     *  @type {string}
     *  @default "[No Explicit Error]"
     */
    open var defaultErrorText: String = definedExternally
    /**
     *  When FormulaBuilder.testFunction reports an empty formula,
     *   this attribute provides the error-text to display in the
     *   FormulaBuilder.messageLabel.
     * 
     *   This is a dynamic string - text within &#36;{...} are dynamic variables and will
     *   be evaluated as JS code when the message is displayed.
     * 
     *   Only one dynamic variable, builderType, is available and represents the type of this
     *   builder, either Formula or Summary.
     * 
     *   The default output is:
     * 
     *   Invalid blank [Formula/Summary]
     * 
     *  @type {HTMLString}
     *  @default "Invalid blank ${builderType}"
     */
    open var invalidBlankPrompt: String = definedExternally
    /**
     *  When FormulaBuilder.testFunction reports a valid formula and no other
     *   errors, this attribute provides the error-text to display in the
     *   FormulaBuilder.messageLabel.
     * 
     *   This is a dynamic string - text within &#36;{...} are dynamic variables and will
     *   be evaluated as JS code when the message is displayed.
     * 
     *   Only one dynamic variable, builderType, is available and represents the type of this
     *   builder, either Formula or Summary.
     * 
     *   The default output is:
     * 
     *   Valid [Formula/Summary]
     * 
     *  @type {HTMLString}
     *  @default "Valid ${builderType}"
     */
    open var validBuilderPrompt: String = definedExternally
    /**
     *  The title for the window that opens when the FormulaBuilder.helpIcon
     *   is clicked.
     * 
     *   This is a dynamic string - text within &#36;{...} are dynamic variables and will
     *   be evaluated as JS code when the message is displayed.
     * 
     *   Only one dynamic variable, builderType, is available and represents the type of this
     *   builder, either Formula or Summary.
     * 
     *   The default output is:
     * 
     *   [Formula/Summary] Help
     * 
     *  @type {HTMLString}
     *  @default "${builderType} Help"
     */
    open var helpWindowTitle: String = definedExternally
    /**
     *  The text to display next to the "Title" field.
     *  @type {string}
     *  @default "Title"
     */
    open var titleFieldTitle: String = definedExternally
    /**
     *  The default value for new Formula and Summary fields.
     *  @type {string}
     *  @default "New Field"
     */
    open var defaultNewFieldTitle: String = definedExternally
    /**
     *  The default title for the "Key" column in FormulaBuilder.fields.
     *  @type {string}
     *  @default "Key"
     */
    open var keyColumnTitle: String = definedExternally
    /**
     *  The default title for the "Source Field" column in in FormulaBuilder.fields.
     *  @type {string}
     *  @default "Source Field"
     */
    open var sourceFieldColumnTitle: String = definedExternally
    /**
     *  The default title for the "Cancel" button.
     *  @type {string}
     *  @default "Cancel"
     */
    open var cancelButtonTitle: String = definedExternally
    /**
     *  The default title for the "Save & Add Another" button.
     *  @type {string}
     *  @default "Save /&amp; Add Another"
     */
    open var saveAddAnotherButtonTitle: String = definedExternally
    /**
     *  The default title for the "Save" button.
     *  @type {string}
     *  @default "Save"
     */
    open var saveButtonTitle: String = definedExternally
    /**
     *  The text to display in the dialog that opens when there are unsaved changes and the user
     *   cancels the builder.
     * 
     *   This is a dynamic string - text within &#36;{...} are dynamic variables and will
     *   be evaluated as JS code when the message is displayed.
     * 
     *   Only one dynamic variable, builderType, is available and represents the type of this
     *   builder, either Formula or Summary.
     * 
     *   The default output is:
     * 
     *   Save changes to this [Formula/Summary]?
     * 
     *  @type {HTMLString}
     *  @default "Save changes to this ${builderType}?"
     */
    open var saveConfirmationPrompt: String = definedExternally
    /**
     *  When FormulaBuilder.testFunction reports an attempt to generate a
     *   function from an invalid formula, this is the text to display in the
     *   FormulaBuilder.messageLabel.
     * 
     *   This is a dynamic string - text within &#36;{...} are dynamic variables and will
     *   be evaluated as JS code when the message is displayed.
     * 
     *   Only one dynamic variable, builderType, is available and represents the type of this
     *   builder, either Formula or Summary.
     * 
     *   The default output is:
     * 
     *   The generated function is invalid - Check your [Formula/Summary] and retry.
     * 
     *  @type {HTMLString}
     *  @default "The generated function is invalid - Check your ${builderType} and retry."
     */
    open var invalidGeneratedFunctionPrompt: String = definedExternally
    /**
     *  The default title for the "Sample" panel, which displays a sample result for the formula.
     *  @type {string}
     *  @default "Sample:"
     */
    open var sampleHeaderTitle: String = definedExternally
    /**
     *  The default title for the "Test" button.
     *  @type {string}
     *  @default "Test"
     */
    open var testButtonTitle: String = definedExternally
    /**
     *  Should the user be showed a warning when the entered Title value already exists?
     *  @type {string}
     *  @default null
     */
    open var warnDuplicateTitles: String = definedExternally
    /**
     *  The message to display when warnDuplicateTitles is true
     *   This is a dynamic string - text within &#36;{...} will be evaluated as JS code
     *   when the message is displayed.
     *  @type {HTMLString}
     *  @default "Another field already has the title '${fieldTitle}'.  Continue anyway?"
     */
    open var warnDuplicateTitlesMessage: String = definedExternally
    /**
     *  When set to true, automatically tests the formula by calling
     *   FormulaBuilder.testFunction whenever typing into the
     *   FormulaBuilder.formulaField pauses.
     * 
     *   The default is true.
     *  @type {boolean}
     *  @default true
     */
    open var autoTest: Boolean = definedExternally
    /**
     *  When FormulaBuilder.autoTest is true, this property indicates the delay in
     *   milliseconds between a user pausing and FormulaBuilder.testFunction
     *   being called.
     * 
     *   The default is 200 milliseconds.
     *  @type {Integer}
     *  @default "200"
     */
    open var autoTestDelay: Number = definedExternally
    /**
     *  Record to use when testing the formula dynamically (if FormulaBuilder.autoTest is enabled) or when
     *   showing samples of formula output.
     * 
     *   If not specified, the selected record in the component that launched the FormulaBuilder will
     *   be used, or if there's no selection, the first visible row, or with no component, a dummy
     *   data row derived automatically from the provided DataSource.
     *  @type {Record}
     *  @default null
     */
    open var testRecord: Record = definedExternally
    /**
     *  This is a dynamic string - text within &#36;{...} will be evaluated as JS code
     *   when the message is displayed.
     * 
     *   Default value returns
     * 
     *   For Record: + the value of the rows title-field
     *   Output: + the result of he generated function
     * 
     * 
     *  @type {HTMLString}
     *  @default "&lt;nobr&gt;For record: ${title}&lt;/nobr&gt;&lt;br&gt;&lt;nobr&gt;Output: ${output}&lt;/nobr&gt;"
     */
    open var samplePrompt: String = definedExternally
    /**
     *   Call to set the formula-string in this FormulaBuilder.
     * 
     *   Note that calling setFormula() will update the UI, generate the formula's function and
     *   test it automatically.
     * 
     * 
     *  @param {string} The new formula-string for this builder
     */
    open fun setFormula(newValue: String): Unit = definedExternally
    /**
     *   Call to retrieve the text the FormulaBuilder would show by default for help, or override to
     *   provide alternate help text.
     * 
     * 
     */
    open fun getHelpText(): String = definedExternally
    /**
     *   Returns the entire property-set for the updated field, including title and formula-related
     *   properties
     * 
     * 
     */
    open fun getUpdatedFieldObject(): String = definedExternally
    /**
     *   Test the formula by generating it's function and trying to run it.
     * 
     */
    open fun testFunction(): String = definedExternally
    /**
     *   Gets the FormulaBuilder.testRecord for this formula.
     * 
     */
    open fun getTestRecord(): Record = definedExternally
    /**
     *   Call to finish working, test the formula and call
     *   FormulaBuilder.fireOnClose. If the formula saves ok, don't close
     *   the builder but instead reset it, ready to add a new formula-field.
     * 
     * 
     */
    open fun saveAddAnother(): Unit = definedExternally
    /**
     *   Call to finish working, test the formula and call
     *   FormulaBuilder.fireOnClose. Called automatically
     *   when the Save button is clicked.
     * 
     * 
     */
    open fun save(): Unit = definedExternally
    /**
     *   Override to execute a callback function when the Formula is Cancelled or Saved.
     * 
     * 
     */
    open fun fireOnClose(): Unit = definedExternally
    /**
     *   Evaluates and returns the dynamic FormulaBuilder.samplePrompt string which is
     *   displayed beneath the formulaField and updated when typing pauses.
     * 
     * 
     *  @param {TestFunctionResult} The return value from a call to testFunction().
     */
    open fun getSamplePrompt(result: TestFunctionResult): String = definedExternally
    companion object {
        /**
         *  Creates a new FormulaBuilder
         * 
         *  @param typeCheckedProperties {Partial<FormulaBuilder>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {FormulaBuilder} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): FormulaBuilder = definedExternally
    }
}