@file:JsQualifier("isc")
package isc

/**
 *  FieldPicker provides a configuration dialog that displays, side-by-side, the available and
 *   currently-displayed fields of a DataBoundComponent. It allows for easy customization
 *   of the order in which the fields of a DataBoundComponent are displayed, and of which
 *   are visible. If so configured, it also allows for convenient launching of the HiliteEditor,
 *   FormulaBuilder, and SummaryBuilder. A FieldPicker instance runs in its own window,
 *   a FieldPickerWindow
 */
open external class FieldPicker : VLayout {
    /**
     *  The component whose fields should be edited.
     * 
     *   Note that if DataBoundComponent.useAllDataSourceFields is set on the component, it
     *   will be cleared when the FieldPicker applies the requested ordering since that setting
     *   imposes a fixed ordering on the fields.
     *  @type {Canvas}
     *  @default null
     */
    open var dataBoundComponent: Canvas = definedExternally
    /**
     *  An optional DataSource that is used to create a disposable
     *   FieldPicker.dataBoundComponent if none is provided.
     *   Has no effect if a FieldPicker.dataBoundComponent is specified.
     *  @type {DataSource}
     *  @default null
     */
    open var dataSource: dynamic = definedExternally
    /**
     *  If a sampleRecord is provided, the FieldPicker will show a second column in the
     *   Current Fields dialog showing the cell value that will appear for that field given the
     *   provided sample record.
     * 
     *   A value of "first" means the first record. If the underlying
     *   FieldPicker.dataBoundComponent is a TreeGrid, you can specify "firstOpenLeaf"
     *   to use the first open leaf as the sampleRecord (this is often desirable in trees where the
     *   first record may be a folder that's used for organizational purposes only and hence would
     *   have no actual data for columns other than the tree column).
     *  @type {Record | DefaultSampleRecord}
     *  @default "first"
     */
    open var sampleRecord: dynamic = definedExternally
    /**
     *  Shows a "Highlights..." button that shows an interface for editing hilites in the attached
     *   DataBoundComponent.
     *  @type {boolean}
     *  @default true
     */
    open var showHilitesButton: Boolean = definedExternally
    /**
     *  When set to false, hides the right-most set of buttons, used for re-ordering fields in the
     *   Visible Fields list.
     *  @type {boolean}
     *  @default true
     */
    open var showFieldOrderButtons: Boolean = definedExternally
    /**
     *  @type {string}
     *  @default "Highlights..."
     */
    open var hilitesText: String = definedExternally
    /**
     *  @type {string}
     *  @default "Available Fields"
     */
    open var availableFieldsTitle: String = definedExternally
    /**
     *  @type {string}
     *  @default "Visible Fields"
     */
    open var currentFieldsTitle: String = definedExternally
    /**
     *  The title displayed for the Add Custom Fields Button
     *  @type {string}
     *  @default "Add Custom Fields"
     */
    open var addCustomFieldsButtonTitle: String = definedExternally
    /**
     *  The title displayed for the title property of the available fields
     *  @type {string}
     *  @default "Name"
     */
    open var availableTitleTitle: String = definedExternally
    /**
     *  The title displayed for the title property of the current fields
     *  @type {string}
     *  @default "Field Title"
     */
    open var currentTitleTitle: String = definedExternally
    /**
     *  The title displayed for the sample value property of the current fields
     *  @type {string}
     *  @default "Sample Value"
     */
    open var sampleValueTitle: String = definedExternally
    /**
     *  Whether the current fields' filter row allows the sample value column to be filtered.
     *  @type {boolean}
     *  @default false
     */
    open var canFilterSampleValue: Boolean = definedExternally
    /**
     *  @type {string}
     *  @default "Must save pending changes to proceed. OK?"
     */
    open var confirmText: String = definedExternally
    /**
     *  @type {string}
     *  @default "You are about to remove the field. Are you sure?"
     */
    open var removeText: String = definedExternally
    /**
     *  @type {HTMLString}
     *  @default "Drag and drop or use arrows to move fields.  Drag reorder to change field order."
     */
    open var instructions: String = definedExternally
    /**
     *  A Label displaying the text assigned as the FieldPicker's
     *   FieldPicker.instructions. Shown across the top of the widget.
     *  @type {Label}
     *  @default null
     */
    open var instructionLabel: Label = definedExternally
    /**
     *  The title shown on the Save and Exit button
     *  @type {string}
     *  @default "Apply"
     */
    open var saveAndExitButtonTitle: String = definedExternally
    /**
     *  The title shown on the Cancel button
     *  @type {string}
     *  @default "Cancel"
     */
    open var cancelButtonTitle: String = definedExternally
    /**
     *  The title shown on the 'Visible Fields' grid's context menu item, whose click handler puts the
     *  selected item back in the 'Available Fields' collection.
     *  @type {string}
     *  @default "Remove"
     */
    open var removeItemTitle: String = definedExternally
    /**
     *  The hint shown when editing a field with no title defined.
     *  @type {string}
     *  @default "[No title specified]"
     */
    open var emptyTitleHint: String = definedExternally
    /**
     *  Provides a set of controls to appear as
     *   SectionHeader.controls above the available fields grid.
     *  @type {Array<Partial<Canvas>>}
     *  @default null
     */
    open var availableFieldsHeaderControls: Array<dynamic> = definedExternally
    /**
     *  A ListGrid showing the list of available fields.
     *  @type {ListGrid}
     *  @default null
     */
    open var availableFieldsGrid: ListGrid = definedExternally
    /**
     *  A HLayout used to show the
     *   FieldPicker.saveAndExitButton and FieldPicker.cancelChangesButton
     *   buttons.
     *  @type {HLayout}
     *  @default null
     */
    open var buttonLayout: HLayout = definedExternally
    /**
     *  An AutoChild IButton that saves the current field-set and exits the
     *   Field Picker.
     *  @type {IButton}
     *  @default null
     */
    open var saveAndExitButton: IButton = definedExternally
    /**
     *  An AutoChild IButton that saves the current field-set and exits the
     *   Field Picker.
     *  @type {IButton}
     *  @default null
     */
    open var cancelChangesButton: IButton = definedExternally
    /**
     *  A ListGrid showing the list of currently selected fields.
     *  @type {ListGrid}
     *  @default null
     */
    open var currentFieldsGrid: ListGrid = definedExternally
    /**
     *   Callback invoked when picker changes are committed, if a disposable
     *   DataBoundComponent is present.
     * 
     *  @param {Array<Partial<ListGridField>>} committed fields from disposable component
     *  @param {Array<Partial<Hilite>>} Array of hilite objects
     */
    open fun callback(fields: Array<dynamic>, hilites: Array<dynamic>): Unit = definedExternally
    /**
     *   Provides a new set of available fields.
     * 
     * \* @param {Array<Partial<DataSourceField>>} 
     */
    open fun setAvailableFields(newFields: Array<dynamic>): Unit = definedExternally
    companion object {
        /**
         *  Creates a new FieldPicker
         * 
         *  @param typeCheckedProperties {Partial<FieldPicker>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {FieldPicker} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): FieldPicker = definedExternally
    }
}