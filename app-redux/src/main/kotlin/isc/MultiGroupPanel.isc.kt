@file:JsQualifier("isc")
package isc

/**
 *  A widget that allows the user to set up complex grouping arrangements by defining a group of
 *   GroupSpecifiers.
 * 
 *   Each GroupSpecifier applies to a single property and grouping - so, for instance, in
 *   a grid with two columns, Nationhood and Country, you could group
 *   first by Nationhood with its selected groupingMode and then by
 *   Country with its selected groupingMode.
 * 
 *   Important Note: this class should not be used directly - it is exposed purely for
 *   i18nMessages
 */
open external class MultiGroupPanel : Layout {
    /**
     *  The list of fields which the user can choose to group by.
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
     *  The title-text to appear in the header of the "grouping" field.
     *  @type {string}
     *  @default "Grouping"
     */
    open var groupingFieldTitle: String = definedExternally
    /**
     *  The title-text to appear in the first column for the first group-level.
     *  @type {string}
     *  @default "Group by"
     */
    open var firstGroupLevelTitle: String = definedExternally
    /**
     *  The title-text to appear in the first column for all group-levels other than the first.
     *  @type {string}
     *  @default "Then by"
     */
    open var otherGroupLevelTitle: String = definedExternally
    /**
     *  Automatically generated IButton providing a mechanism for adding new levels
     *   to the group configuration.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   multiGroupPanel.addLevelButtonProperties and
     *   multiGroupPanel.addLevelButtonDefaults.
     *  @type {IButton}
     *  @default null
     */
    open var addLevelButton: IButton = definedExternally
    /**
     *  Automatically generated IButton providing a mechanism for deleting levels
     *   from the group configuration.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   multiGroupPanel.deleteLevelButtonProperties and
     *   multiGroupPanel.deleteLevelButtonDefaults.
     *  @type {IButton}
     *  @default null
     */
    open var deleteLevelButton: IButton = definedExternally
    /**
     *  Automatically generated IButton providing a mechanism for duplicating levels
     *   in the group configuration.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   multiGroupPanel.copyLevelButtonProperties and
     *   multiGroupPanel.copyLevelButtonDefaults.
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
     *   group-levels up in the group configuration.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   multiGroupPanel.levelUpButtonProperties and
     *   multiGroupPanel.levelUpButtonDefaults.
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
     *   group-levels down in the group configuration.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   multiGroupPanel.levelDownButtonProperties and
     *   multiGroupPanel.levelDownButtonDefaults.
     *  @type {ImgButton}
     *  @default null
     */
    open var levelDownButton: ImgButton = definedExternally
    /**
     *  Automatically generated ListGrid allowing the user to configure a set of
     *   GroupSpecifiers.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   multiGroupPanel.optionsGridProperties and
     *   multiGroupPanel.optionsGridDefaults.
     *  @type {ListGrid}
     *  @default null
     */
    open var optionsGrid: ListGrid = definedExternally
    /**
     *  The initial group configuration to show in the
     *   MultiGroupPanel.optionsGrid.
     *  @type {Array<any>}
     *  @default null
     */
    open var initialGrouping: Array<dynamic> = definedExternally
    /**
     *  The maximum number of levels of grouping that can be applied. Since each group-property or
     *   field-name can be used only once in a given multi-group operation, if no maxLevels value
     *   or a value larger than the total number of available properties is specified, it will
     *   default to the total number of available properties.
     *  @type {number}
     *  @default null
     */
    open var maxLevels: Number = definedExternally
    /**
     *   Return the number of levels of grouping that have been configured.
     * 
     * 
     */
    open fun getNumLevels(): Number = definedExternally
    /**
     *   Returns all configured grouping levels, as an array of GroupSpecifiers.
     * 
     * 
     */
    open fun getGroup(): Array<dynamic> = definedExternally
    /**
     *   Validate that no two GroupSpecifiers group on the same
     *   GroupSpecifier.property.
     * 
     * 
     */
    open fun validate(): Boolean = definedExternally
    /**
     *   Fired whenever the group configuration changes. The single parameter is an array of
     *   GroupSpecifiers that represent the list of group-levels as they appear after
     *   whatever change has occurred.
     * 
     * 
     *  @param {Array<Partial<GroupSpecifier>>} The current group configuration, after any changes
     */
    open fun groupChanged(groupLevels: Array<dynamic>): Unit = definedExternally
    companion object {
        /**
         *  Creates a new MultiGroupPanel
         * 
         *  @param typeCheckedProperties {Partial<MultiGroupPanel>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {MultiGroupPanel} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): MultiGroupPanel = definedExternally
    }
}