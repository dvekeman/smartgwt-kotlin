@file:JsQualifier("isc")
package isc

/**
 *  A widget for editing a single, advanced HiliteRule for use by
 *   DataBoundComponent. Where a simple hilite provides
 *   configuration of a single criterion and either foreground or background color for
 *   application to a single field, an advanced hilite can specify more complex criteria which can
 *   both test and affect multiple fields and allow both background and foreground colors to
 *   be specified in a single rule.
 * 
 *   Important Note: this class should not be used directly - it is exposed purely for
 *   i18nMessages
 */
open external class AdvancedHiliteEditor : VStack {
    /**
     *  AutoChild FilterBuilder for configuring the criteria for this Hilite.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   advancedHiliteEditor.filterBuilderProperties.
     *  @type {FilterBuilder}
     *  @default null
     */
    open var filterBuilder: FilterBuilder = definedExternally
    /**
     *  The title for the Filter group.
     *  @type {string}
     *  @default "Filter"
     */
    open var filterGroupTitle: String = definedExternally
    /**
     *  Specifies a list of icons that can be used in hilites.
     * 
     *   hiliteIcons should be specified as an Array of SCImgURL.
     *   When present, HiliteRule
     *   will offer the user a drop down for picking one of these icons.
     * 
     *   If the user picks an icon, the created hiliting rule will have Hilite.icon set to
     *   the chosen icon. ListGridField.hiliteIconPosition controls where the icon will
     *   appear for that field -- the default is that it appears in front of the normal cell content.
     *  @type {Array<Partial<SCImgURL>>}
     *  @default null
     */
    open var hiliteIcons: Array<dynamic> = definedExternally
    /**
     *  AutoChild DynamicForm for configuring the details of this Hilite.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   advancedHiliteEditor.hiliteFormProperties.
     *  @type {DynamicForm}
     *  @default null
     */
    open var hiliteForm: DynamicForm = definedExternally
    /**
     *  The title for the Appearance group.
     *  @type {string}
     *  @default "Appearance"
     */
    open var appearanceGroupTitle: String = definedExternally
    /**
     *  The title for the Target Field(s) picker.
     *  @type {string}
     *  @default "Target Field(s)"
     */
    open var targetFieldsItemTitle: String = definedExternally
    /**
     *  AutoChild ImgButton that accepts this Hilite and fires the
     *   AdvancedHiliteEditor.callback.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   advancedHiliteEditor.saveButtonProperties.
     *  @type {StatefulCanvas}
     *  @default null
     */
    open var saveButton: StatefulCanvas = definedExternally
    /**
     *  The title text for the AdvancedHiliteEditor.saveButton.
     *  @type {string}
     *  @default "Save"
     */
    open var saveButtonTitle: String = definedExternally
    /**
     *  AutoChild ImgButton that cancels this AdvancedHiliteEditor without saving
     *   any changes, firing the AdvancedHiliteEditor.callback with a null
     *   parameter.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   advancedHiliteEditor.cancelButtonProperties.
     *  @type {StatefulCanvas}
     *  @default null
     */
    open var cancelButton: StatefulCanvas = definedExternally
    /**
     *  The title text for the AdvancedHiliteEditor.cancelButton.
     *  @type {string}
     *  @default "Cancel"
     */
    open var cancelButtonTitle: String = definedExternally
    /**
     *  The message to show when the user clicks "Save" without entering any criteria.
     *  @type {string}
     *  @default "Enter at least one rule, a color or icon, and a target field, or press 'Cancel' to abandon changes."
     */
    open var invalidHilitePrompt: String = definedExternally
    /**
     *  The title text shown in the header bar of this editor's dialog.
     *  @type {string}
     *  @default "Advanced Highlight Editor"
     */
    open var title: String = definedExternally
    /**
     *  The callback to fire when the AdvancedHiliteEditor.saveButton is clicked.
     *  @type {Callback}
     *  @default null
     */
    open var callback: dynamic = definedExternally
    /**
     *   Save changes and fire the AdvancedHiliteEditor.callback.
     * 
     * 
     */
    open fun saveHilite(): Unit = definedExternally
    /**
     *   Discard changes and fire the AdvancedHiliteEditor.callback with a null
     *   parameter.
     * 
     * 
     */
    open fun cancelEditing(): Unit = definedExternally
    companion object {
        /**
         *  Creates a new AdvancedHiliteEditor
         * 
         *  @param typeCheckedProperties {Partial<AdvancedHiliteEditor>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {AdvancedHiliteEditor} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): AdvancedHiliteEditor = definedExternally
    }
}