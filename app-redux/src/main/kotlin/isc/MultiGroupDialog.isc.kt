@file:JsQualifier("isc")
package isc

/**
 *  A dialog that allows the user to set up complex grouping arrangements by defining a group of
 *   GroupSpecifiers.
 * 
 *   Each GroupSpecifier applies to a single property and grouping - so, for instance, in
 *   a grid with two columns, Nationhood and Country, you could group first
 *   by Nationhood with its selected groupingMode and then by Country with its selected groupingMode.
 * 
 *   Important Note: this class should not be used directly - it is exposed purely for
 *   i18nMessages
 */
open external class MultiGroupDialog : Window {
    /**
     *  The title-text to appear in this Dialog's Header-bar.
     *  @type {string}
     *  @default "Group"
     */
    override var title: String = definedExternally
    /**
     *  The title-text to appear on the addLevelButton.
     * 
     *   Note, this is a passthrough property which, when set, is passed through to the
     *   MultiGroupPanel contained in this dialog. You only need to
     *   consider the properties on the MultiGroupPanel for i18n.
     *  @type {string}
     *  @default "Add Level"
     */
    open var addLevelButtonTitle: String = definedExternally
    /**
     *  The title-text to appear on the deleteLevelButton
     * 
     *   Note, this is a passthrough property which, when set, is passed through to the
     *   MultiGroupPanel contained in this dialog. You only need to
     *   consider the properties on the MultiGroupPanel for i18n.
     *  @type {string}
     *  @default "Delete Level"
     */
    open var deleteLevelButtonTitle: String = definedExternally
    /**
     *  The title-text to appear on the copyLevelButton
     * 
     *   Note, this is a passthrough property which, when set, is passed through to the
     *   MultiGroupPanel contained in this dialog. You only need to
     *   consider the properties on the MultiGroupPanel for i18n.
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
     *   MultiGroupPanel contained in this dialog. You only need to
     *   consider the properties on the MultiGroupPanel for i18n.
     *  @type {HTMLString}
     *  @default "Columns may only be used once: '${title}' is used multiple times."
     */
    open var invalidListPrompt: String = definedExternally
    /**
     *  The title-text to appear in the header of the "property" field.
     * 
     *   Note, this is a passthrough property which, when set, is passed through to the
     *   MultiGroupPanel contained in this dialog. You only need to
     *   consider the properties on the MultiGroupPanel for i18n.
     *  @type {string}
     *  @default "Column"
     */
    open var propertyFieldTitle: String = definedExternally
    /**
     *  The title-text to appear in the header of the "property" field.
     * 
     *   Note, this is a passthrough property which, when set, is passed through to the
     *   MultiGroupPanel contained in this dialog. You only need to
     *   consider the properties on the MultiGroupPanel for i18n.
     *  @type {string}
     *  @default "Grouping"
     */
    open var groupingFieldTitle: String = definedExternally
    /**
     *  The initial group configuration to show in the
     *   MultiGroupPanel.optionsGrid.
     * 
     *   Note, this is a passthrough property which, when set, is passed through to the
     *   MultiGroupPanel contained in this dialog.
     *  @type {Array<any>}
     *  @default null
     */
    open var initialGrouping: Array<dynamic> = definedExternally
    /**
     *  The maximum number of levels of grouping that can be applied. Since each group-property or
     *   field-name can be used only once in a given multi-group operation, if no maxLevels value
     *   or a value larger than the total number of available properties is specified, it will
     *   default to the total number of available properties.
     * 
     *   Note, this is a passthrough property which, when set, is passed through to the
     *   MultiGroupPanel contained in this dialog.
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
     *   the current group configuration. Fires the passed callback with a single parameter,
     *   groupLevels, representing the current group configuration as an array of
     *   GroupSpecifiers.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   multiGroupPanel.applyButtonProperties and
     *   multiGroupPanel.applyButtonDefaults.
     *  @type {IButton}
     *  @default null
     */
    open var applyButton: IButton = definedExternally
    /**
     *  Automatically generated IButton providing the mechanism for closing this
     *   Dialog without accepting the current group configuration. The passed callback is fired
     *   with a single null parameter, indicating that the operation was cancelled.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   multiGroupPanel.cancelButtonProperties and
     *   multiGroupPanel.cancelButtonDefaults.
     *  @type {IButton}
     *  @default null
     */
    open var cancelButton: IButton = definedExternally
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
     *  The list of fields which the user can choose to group by.
     *  @type {Array<Partial<DataSourceField>>}
     *  @default null
     */
    open var fields: Array<dynamic> = definedExternally
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
    companion object {
        /**
         *  Creates a new MultiGroupDialog
         * 
         *  @param typeCheckedProperties {Partial<MultiGroupDialog>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {MultiGroupDialog} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): MultiGroupDialog = definedExternally
        /**
         *   Launches a MultiGroupDialog and obtains a group-definition from the user.
         * 
         * 
         *  @param {Array<Partial<string>> | DataSource | DataBoundComponent} A source for Fields                which the user can choose to group by
         *  @param {Array<any>} The initial group definition.
         *  @param {Callback} Called when the user defines and accepts one or more GroupSpecifiers. Single parameter groupLevels is an Array of  GroupSpecifier or null if the user cancelled the dialog.
         *  @param {MultiGroupDialog=} Configuration to apply to the generated dialog
         */
        fun askForGrouping(fieldSource: dynamic, initialGrouping: Array<dynamic>, callback: dynamic, properties: MultiGroupDialog?): Unit = definedExternally
    }
}