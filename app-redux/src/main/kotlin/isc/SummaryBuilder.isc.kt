@file:JsQualifier("isc")
package isc

/**
 *  Shows an interface allowing a user to create or edit fields by typing simple
 *   format-strings into a text field. The format-strings can include the values of other fields
 *   and additional text as required.
 * 
 *   Available values for the format-string are determined by the DataSource fields, and are given
 *   simple single-letter aliases (such as "A", "B", ...) similar to column names in Excel.
 *   The set of available values is shown in the FormulaBuilder.fieldKey as a simple
 *   mapping between the DataSourceField.title and it's short name.
 * 
 *   To include a field in the format-string, prefix it with a hash sign (#).
 */
open external class SummaryBuilder : FormulaBuilder {
    /**
     *  Indicates whether to use "summary" or some other keyword in various captions and text
     *  @type {string}
     *  @default "Summary"
     */
    override var builderTypeText: String = definedExternally
    /**
     *  DataSource providing the available fields for the formulaBuilder.
     * 
     *   By default the formulaBuilder will include only fields of numeric type or derived
     *   from a numeric type. Set FormulaBuilder.fields to override this.
     *  @type {DataSource | GlobalId}
     *  @default null
     */
    override var dataSource: dynamic = definedExternally
    /**
     *  DataSource providing the available fields for the SummaryBuilder.
     * 
     *   By default the SummaryBuilder will include all fields. Set SummaryBuilder.fields to
     *   override this.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    override var fields: Array<dynamic> = definedExternally
    /**
     *  Are we editing an existing field?
     *  @type {boolean}
     *  @default false
     */
    override var editMode: Boolean = definedExternally
    /**
     *  The Field object representing the field being created or edited.
     *  @type {string}
     *  @default null
     */
    override var field: String = definedExternally
    /**
     *  TextItem that users type into when entering a formula.
     *  @type {TextItem}
     *  @default null
     */
    override var formulaField: TextItem = definedExternally
    /**
     *  TextItem that allows users to set the title for this field.
     *  @type {TextItem}
     *  @default null
     */
    override var titleField: TextItem = definedExternally
    /**
     *  Whether to show the help icon that appears after the SummaryBuilder.formulaField.
     *  @type {boolean}
     *  @default true
     */
    override var showHelpIcon: Boolean = definedExternally
    /**
     *  Icon that appears after the SummaryBuilder.formulaField, showing help on hover.
     *  @type {FormItemIcon}
     *  @default null
     */
    override var helpIcon: FormItemIcon = definedExternally
    /**
     *  Whether to show a checkbox offering the user the ability to automatically
     *   hide any fields involved in the formula.
     *  @type {boolean}
     *  @default true
     */
    override var showAutoHideCheckBox: Boolean = definedExternally
    /**
     *  CheckBox that, when selected, hides columns in the component that are used in this formula.
     *  @type {TextItem}
     *  @default null
     */
    override var autoHideCheckBox: TextItem = definedExternally
    /**
     *  Record to use when showing sample output for the format string.
     * 
     *   If not specified, the selected record in the component that launched the SummaryBuilder will
     *   be used, or if there's no selection, the first visible row, or with no component, a dummy
     *   data row derived automatically from the provided DataSource.
     *  @type {Record}
     *  @default null
     */
    override var testRecord: Record = definedExternally
    /**
     *  Text label for the checkbox that allows the user to automatically hide the
     *   fields used in the summary format.
     *  @type {string}
     *  @default "Auto hide fields used in summary"
     */
    override var autoHideCheckBoxLabel: String = definedExternally
    /**
     *  Text that appears in the hover from the SummaryBuilder.helpIcon, as a pre-amble to the list of
     *   available format-tokens.
     *  @type {string}
     *  @default "Building Summary Columns"
     */
    open var helpTextIntro: String = definedExternally
    /**
     *   Call to set the format-string in this SummaryBuilder.
     * 
     *   Note that calling setSummary() will update the UI, generate the summary's function and
     *   test it automatically.
     * 
     * 
     *  @param {string} The new format-string for the summary
     */
    open fun setSummary(newValue: String): Unit = definedExternally
    /**
     *   Call to retrieve the text the SummaryBuilder would show by default for help, or override to
     *   provide alternate help text.
     * 
     * 
     */
    override fun getHelpText(): String = definedExternally
    /**
     *   Override to execute a callback function when the Format is Cancelled or Saved.
     * 
     * 
     */
    override fun fireOnClose(): Unit = definedExternally
    /**
     *   Call to finish working, test the formula and call
     *   FormulaBuilder.fireOnClose. Called automatically
     *   when the Save button is clicked.
     * 
     * 
     */
    override fun save(): Unit = definedExternally
    companion object {
        /**
         *  Creates a new SummaryBuilder
         * 
         *  @param typeCheckedProperties {Partial<SummaryBuilder>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {SummaryBuilder} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): SummaryBuilder = definedExternally
    }
}