@file:JsQualifier("isc")
package isc

/**
 *  A widget that allows the user to set up complex sorting arrangements by defining a group of
 *   SortSpecifiers.
 * 
 *   Each SortSpecifier applies to a single property and direction - so, for instance, in
 *   a grid with two columns, year and monthNumber, you could sort first
 *   by year in descending order and then by monthNumber in ascending
 *   order. This would producing a grid sorted by year from largest (most
 *   recent) to smallest (least recent) and, within each year, by monthNumber from smallest
 *   (January) to largest (December).
 */
open external class MultiSortPanel : Layout {
    /**
     *  The list of fields which the user can choose to sort by.
     *  @type {Array<Partial<DataSourceField>>}
     *  @default null
     */
    open var fields: Array<dynamic> = definedExternally
    /**
     *  The title-text to appear on the addLevelButton
     *  @type {string}
     *  @default "Add Level"
     */
    open var addLevelButtonTitle: String = definedExternally
    /**
     *  The title-text to appear on the deleteLevelButton
     *  @type {string}
     *  @default "Delete Level"
     */
    open var deleteLevelButtonTitle: String = definedExternally
    /**
     *  The title-text to appear on the copyLevelButton
     *  @type {string}
     *  @default "Copy Level"
     */
    open var copyLevelButtonTitle: String = definedExternally
    /**
     *  This is a dynamic string - text within &#36;{...} will be evaluated as JS code
     *   when the message is displayed.
     * 
     *   Default value returns
     * 
     *   Columns may only be used once: [some field's title] is used multiple times
     * 
     *  @type {HTMLString}
     *  @default "Columns may only be used once: '${title}' is used multiple times."
     */
    open var invalidListPrompt: String = definedExternally
    /**
     *  The title-text to appear in the header of the "property" field.
     *  @type {string}
     *  @default "Column"
     */
    open var propertyFieldTitle: String = definedExternally
    /**
     *  The title-text to appear in the header of the "direction" field.
     *  @type {string}
     *  @default "Order"
     */
    open var directionFieldTitle: String = definedExternally
    /**
     *  The title-text to appear in the "direction" field's SelectItem for an "ascending" sort
     *  @type {string}
     *  @default "Ascending"
     */
    open var ascendingTitle: String = definedExternally
    /**
     *  The title-text to appear in the "direction" field's SelectItem for a "descending" sort
     *  @type {string}
     *  @default "Descending"
     */
    open var descendingTitle: String = definedExternally
    /**
     *  The title-text to appear in the first column for the first sort-level.
     *  @type {string}
     *  @default "Sort by"
     */
    open var firstSortLevelTitle: String = definedExternally
    /**
     *  The title-text to appear in the first column for all sort-levels other than the first.
     *  @type {string}
     *  @default "Then by"
     */
    open var otherSortLevelTitle: String = definedExternally
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
     *  The hover-prompt for the Level Up button.
     *  @type {string}
     *  @default "Move Level Up"
     */
    open var levelUpButtonTitle: String = definedExternally
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
     *  The hover-prompt for the Level Down button.
     *  @type {string}
     *  @default "Move Level Down"
     */
    open var levelDownButtonTitle: String = definedExternally
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
     *  The initial sort configuration to show in the
     *   MultiSortPanel.optionsGrid.
     *  @type {Array<Partial<SortSpecifier>>}
     *  @default null
     */
    open var initialSort: Array<dynamic> = definedExternally
    /**
     *  The maximum number of levels of sorting that can be applied. Since each sort-property or
     *   field-name can be used only once in a given multi-sort operation, if no maxLevels value
     *   or a value larger than the total number of available properties is specified, it will
     *   default to the total number of available properties.
     *  @type {number}
     *  @default null
     */
    open var maxLevels: Number = definedExternally
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
    /**
     *   Fired whenever the sort configuration changes. The single parameter is an array of
     *   SortSpecifiers that represent the list of sort-levels as they appear after
     *   whatever change has occurred.
     * 
     * 
     *  @param {Array<Partial<SortSpecifier>>} The current sort configuration, after any changes
     */
    open fun sortChanged(sortLevels: Array<dynamic>): Unit = definedExternally
    companion object {
        /**
         *  Creates a new MultiSortPanel
         * 
         *  @param typeCheckedProperties {Partial<MultiSortPanel>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {MultiSortPanel} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): MultiSortPanel = definedExternally
    }
}