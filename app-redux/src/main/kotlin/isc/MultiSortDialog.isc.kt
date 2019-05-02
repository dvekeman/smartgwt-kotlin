@file:JsQualifier("isc")
package isc

/**
 *  A dialog that allows the user to set up complex sorting arrangements by defining a group of
 *   SortSpecifiers.
 * 
 *   Each SortSpecifier applies to a single property and direction - so, for instance, in
 *   a grid with two columns, year and monthNumber, you could sort first
 *   by year in descending order and then by monthNumber in ascending
 *   order. This would producing a grid sorted by year from largest (most
 *   recent) to smallest (least recent) and, within each year, by monthNumber from smallest
 *   (January) to largest (December).
 * 
 *   See MultiSortDialog.askForSort, DataBoundComponent.askForSort
 */
open external class MultiSortDialog : Window {
    /**
     *  Automatically generated MultiSortPanel displayed within this
     *   component.
     *  @type {MultiSortPanel}
     *  @default null
     */
    open var multiSortPanel: MultiSortPanel = definedExternally
    /**
     *  The title-text to appear in this Dialog's Header-bar.
     *  @type {string}
     *  @default "Sort"
     */
    override var title: String = definedExternally
    /**
     *  The title-text to appear on the addLevelButton.
     * 
     *   Note, this is a passthrough property which, when set, is passed through to the
     *   MultiSortPanel contained in this dialog. You only need to
     *   consider the properties on the MultiSortPanel for i18n.
     *  @type {string}
     *  @default "Add Level"
     */
    open var addLevelButtonTitle: String = definedExternally
    /**
     *  The title-text to appear on the deleteLevelButton
     * 
     *   Note, this is a passthrough property which, when set, is passed through to the
     *   MultiSortPanel contained in this dialog. You only need to
     *   consider the properties on the MultiSortPanel for i18n.
     *  @type {string}
     *  @default "Delete Level"
     */
    open var deleteLevelButtonTitle: String = definedExternally
    /**
     *  The title-text to appear on the copyLevelButton
     * 
     *   Note, this is a passthrough property which, when set, is passed through to the
     *   MultiSortPanel contained in this dialog. You only need to
     *   consider the properties on the MultiSortPanel for i18n.
     *  @type {string}
     *  @default "Copy Level"
     */
    open var copyLevelButtonTitle: String = definedExternally
    /**
     *  The hover-prompt for the Level Up button.
     *  @type {string}
     *  @default "Move Level Up"
     */
    open var levelUpButtonTitle: String = definedExternally
    /**
     *  The hover-prompt for the Level Down button.
     *  @type {string}
     *  @default "Move Level Down"
     */
    open var levelDownButtonTitle: String = definedExternally
    /**
     *  This is a dynamic string - text within &#36;{...} will be evaluated as JS code
     *   when the message is displayed.
     * 
     *   Default value returns
     * 
     *   Columns may only be used once: [some field's title] is used multiple times
     * 
     * 
     *   Note, this is a passthrough property which, when set, is passed through to the
     *   MultiSortPanel contained in this dialog. You only need to
     *   consider the properties on the MultiSortPanel for i18n.
     *  @type {HTMLString}
     *  @default "Columns may only be used once: '${title}' is used multiple times."
     */
    open var invalidListPrompt: String = definedExternally
    /**
     *  The title-text to appear in the header of the "property" field.
     * 
     *   Note, this is a passthrough property which, when set, is passed through to the
     *   MultiSortPanel contained in this dialog. You only need to
     *   consider the properties on the MultiSortPanel for i18n.
     *  @type {string}
     *  @default "Column"
     */
    open var propertyFieldTitle: String = definedExternally
    /**
     *  The title-text to appear in the header of the "direction" field.
     * 
     *   Note, this is a passthrough property which, when set, is passed through to the
     *   MultiSortPanel contained in this dialog. You only need to
     *   consider the properties on the MultiSortPanel for i18n.
     *  @type {string}
     *  @default "Order"
     */
    open var directionFieldTitle: String = definedExternally
    /**
     *  The title-text to appear in the "direction" field's SelectItem for an "ascending" sort
     * 
     *   Note, this is a passthrough property which, when set, is passed through to the
     *   MultiSortPanel contained in this dialog. You only need to
     *   consider the properties on the MultiSortPanel for i18n.
     *  @type {string}
     *  @default "Ascending"
     */
    open var ascendingTitle: String = definedExternally
    /**
     *  The title-text to appear in the "direction" field's SelectItem for a "descending" sort
     * 
     *   Note, this is a passthrough property which, when set, is passed through to the
     *   MultiSortPanel contained in this dialog. You only need to
     *   consider the properties on the MultiSortPanel for i18n.
     *  @type {string}
     *  @default "Descending"
     */
    open var descendingTitle: String = definedExternally
    /**
     *  The title-text to appear in the first column for the first sort-level.
     * 
     *   Note, this is a passthrough property which, when set, is passed through to the
     *   MultiSortPanel contained in this dialog. You only need to
     *   consider the properties on the MultiSortPanel for i18n.
     *  @type {string}
     *  @default "Sort by"
     */
    open var firstSortLevelTitle: String = definedExternally
    /**
     *  The title-text to appear in the first column for all sort-levels other than the first.
     * 
     *   Note, this is a passthrough property which, when set, is passed through to the
     *   MultiSortPanel contained in this dialog. You only need to
     *   consider the properties on the MultiSortPanel for i18n.
     *  @type {string}
     *  @default "Then by"
     */
    open var otherSortLevelTitle: String = definedExternally
    /**
     *  The initial sort configuration to show in the
     *   MultiSortPanel.optionsGrid.
     * 
     *   Note, this is a passthrough property which, when set, is passed through to the
     *   MultiSortPanel contained in this dialog.
     *  @type {Array<Partial<SortSpecifier>>}
     *  @default null
     */
    open var initialSort: Array<dynamic> = definedExternally
    /**
     *  The maximum number of levels of sorting that can be applied. Since each sort-property or
     *   field-name can be used only once in a given multi-sort operation, if no maxLevels value
     *   or a value larger than the total number of available properties is specified, it will
     *   default to the total number of available properties.
     * 
     *   Note, this is a passthrough property which, when set, is passed through to the
     *   MultiSortPanel contained in this dialog.
     *  @type {number}
     *  @default null
     */
    open var maxLevels: Number = definedExternally
    /**
     *  The title-text to appear on the applyButton
     *  @type {string}
     *  @default "Apply"
     */
    open var applyButtonTitle: String = definedExternally
    /**
     *  The title-text to appear on the cancelButton
     *  @type {string}
     *  @default "Cancel"
     */
    open var cancelButtonTitle: String = definedExternally
    /**
     *  Automatically generated IButton providing the mechanism for accepting
     *   the current sort configuration. Fires the passed callback with a single parameter,
     *   sortLevels, representing the current sort configuration as an array of
     *   SortSpecifiers.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   multiSortDialog.applyButtonProperties and
     *   multiSortDialog.applyButtonDefaults.
     *  @type {IButton}
     *  @default null
     */
    open var applyButton: IButton = definedExternally
    /**
     *  Automatically generated IButton providing the mechanism for closing this
     *   Dialog without accepting the current sort configuration. The passed callback is fired
     *   with a single null parameter, indicating that the operation was cancelled.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   multiSortDialog.cancelButtonProperties and
     *   multiSortDialog.cancelButtonDefaults.
     *  @type {IButton}
     *  @default null
     */
    open var cancelButton: IButton = definedExternally
    /**
     *  Automatically generated IButton providing a mechanism for adding new levels
     *   to the sort configuration.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   multiSortPanel.addLevelButtonProperties and
     *   multiSortPanel.addLevelButtonDefaults.
     *  @type {IButton}
     *  @default null
     */
    open var addLevelButton: IButton = definedExternally
    /**
     *  Automatically generated IButton providing a mechanism for deleting levels
     *   from the sort configuration.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   multiSortPanel.deleteLevelButtonProperties and
     *   multiSortPanel.deleteLevelButtonDefaults.
     *  @type {IButton}
     *  @default null
     */
    open var deleteLevelButton: IButton = definedExternally
    /**
     *  Automatically generated IButton providing a mechanism for duplicating levels
     *   in the sort configuration.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   multiSortPanel.copyLevelButtonProperties and
     *   multiSortPanel.copyLevelButtonDefaults.
     *  @type {IButton}
     *  @default null
     */
    open var copyLevelButton: IButton = definedExternally
    /**
     *  Automatically generated ImgButton providing a mechanism for moving existing
     *   sort-levels up in the sort configuration.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   multiSortPanel.levelUpButtonProperties and
     *   multiSortPanel.levelUpButtonDefaults.
     *  @type {ImgButton}
     *  @default null
     */
    open var levelUpButton: ImgButton = definedExternally
    /**
     *  Automatically generated ImgButton providing a mechanism for moving existing
     *   sort-levels down in the sort configuration.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   multiSortPanel.levelDownButtonProperties and
     *   multiSortPanel.levelDownButtonDefaults.
     *  @type {ImgButton}
     *  @default null
     */
    open var levelDownButton: ImgButton = definedExternally
    /**
     *  The list of fields which the user can choose to sort by.
     *  @type {Array<Partial<DataSourceField>>}
     *  @default null
     */
    open var fields: Array<dynamic> = definedExternally
    /**
     *  Automatically generated ListGrid allowing the user to configure a set of
     *   SortSpecifiers.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   multiSortPanel.optionsGridProperties and
     *   multiSortPanel.optionsGridDefaults.
     *  @type {ListGrid}
     *  @default null
     */
    open var optionsGrid: ListGrid = definedExternally
    /**
     *   Return the number of levels of sorting that have been configured.
     * 
     * 
     */
    open fun getNumLevels(): Number = definedExternally
    /**
     *   Return a SortSpecifier object for the requested levelNum.
     * 
     * 
     *  @param {number} The index of the level to return a SortSpecifier for
     */
    open fun getSortLevel(levelNum: Number): SortSpecifier = definedExternally
    /**
     *   Returns all configured sorting levels, as an array of SortSpecifiers.
     * 
     * 
     */
    open fun getSort(): Array<dynamic> = definedExternally
    /**
     *   Validate that no two SortSpecifiers sort on the same
     *   SortSpecifier.property.
     * 
     * 
     */
    open fun validate(): Boolean = definedExternally
    companion object {
        /**
         *  Creates a new MultiSortDialog
         * 
         *  @param typeCheckedProperties {Partial<MultiSortDialog>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {MultiSortDialog} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): MultiSortDialog = definedExternally
        /**
         *   Launches a MultiSortDialog and obtains a sort-definition from the user.
         * 
         * 
         *  @param {DataBoundComponent | DataSource | Array<Partial<DataSourceField>>} A source for Fields which the user can choose to sort by
         *  @param {Array<Partial<SortSpecifier>>} The initial sort definition.
         *  @param {Callback} Called when the user defines and accepts one or more SortSpecifiers. Single parameter sortLevels is an Array of  SortSpecifier or null if the user cancelled the dialog.
         *  @param {MultiSortDialog=} Configuration to apply to the generated dialog
         */
        fun askForSort(fieldSource: dynamic, initialSort: Array<dynamic>, callback: dynamic, properties: MultiSortDialog?): Unit = definedExternally
    }
}