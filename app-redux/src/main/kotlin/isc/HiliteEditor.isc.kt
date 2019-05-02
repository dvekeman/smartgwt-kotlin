@file:JsQualifier("isc")
package isc

/**
 *  A widget for defining and editing a set of HiliteRule for use by
 *   DataBoundComponent. Presents a list of available fields
 *   and allows editing of simple hilites directly and more complex hilites via
 *   AdvancedHiliteEditors.
 * 
 *   Important Note: this class should not be used directly - it is exposed purely for
 *   i18nMessages
 */
open external class HiliteEditor : VLayout {
    /**
     *  AutoChild ListGrid showing the list of fields to create hilites for.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   hiliteEditor.fieldListProperties.
     *  @type {ListGrid}
     *  @default null
     */
    open var fieldList: ListGrid = definedExternally
    /**
     *  The title for the 'Available Fields' column in the
     *   HiliteEditor.fieldList.
     *  @type {string}
     *  @default "Available Fields"
     */
    open var availableFieldsColumnTitle: String = definedExternally
    /**
     *  Specifies a list of icons that can be used in Hilite.
     * 
     *   hiliteIcons should be specified as an Array of SCImgURL.
     *   When present, HiliteRules
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
     *  AutoChild HiliteRule used to create new simple hilites.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   hiliteEditor.hiliteRuleProperties.
     *  @type {HiliteRule}
     *  @default null
     */
    open var hiliteRule: HiliteRule = definedExternally
    /**
     *  AutoChild IButton that opens an AdvancedHiliteEditor to create a new
     *   advanced rule.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   hiliteEditor.addAdvancedRuleButtonProperties.
     *  @type {StatefulCanvas}
     *  @default null
     */
    open var addAdvancedRuleButton: StatefulCanvas = definedExternally
    /**
     *  The title text for the HiliteEditor.addAdvancedRuleButton
     *   button.
     *  @type {string}
     *  @default "Add Advanced Rule"
     */
    open var addAdvancedRuleButtonTitle: String = definedExternally
    /**
     *  AutoChild ImgButton that saves the hilites in this editor and fires the
     *   HiliteEditor.callback.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   hiliteEditor.saveButtonProperties.
     *  @type {StatefulCanvas}
     *  @default null
     */
    open var saveButton: StatefulCanvas = definedExternally
    /**
     *  The title text for the HiliteEditor.saveButton.
     *  @type {string}
     *  @default "Save"
     */
    open var saveButtonTitle: String = definedExternally
    /**
     *  AutoChild ImgButton that cancels this editor without saving
     *   any changes, firing the HiliteEditor.callback with a null
     *   parameter.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   hiliteEditor.cancelButtonProperties.
     *  @type {StatefulCanvas}
     *  @default null
     */
    open var cancelButton: StatefulCanvas = definedExternally
    /**
     *  The title text for the HiliteEditor.cancelButton.
     *  @type {string}
     *  @default "Cancel"
     */
    open var cancelButtonTitle: String = definedExternally
    /**
     *  The callback to fire when HiliteEditor.saveHilites is called.
     *  @type {Callback}
     *  @default null
     */
    open var callback: dynamic = definedExternally
    /**
     *   Removes the passed HiliteRule from this editor.
     * 
     * 
     *  @param {HiliteRule} the hiliteRule to remove
     */
    open fun removeRule(hiliteRule: HiliteRule): Unit = definedExternally
    /**
     *   Clear all Hilites from the editor.
     * 
     * 
     */
    open fun clearHilites(): Unit = definedExternally
    /**
     *   Initialize this editor with a set of Hilites.
     * 
     * 
     *  @param {Array<Partial<Hilite>>} the array of hilite objects to apply
     */
    open fun setHilites(hilites: Array<dynamic>): Unit = definedExternally
    /**
     *   Save the set of Hilites and fire the HiliteEditor.callback.
     * 
     * 
     *  @param {Callback} the function to call when saving is complete
     */
    open fun saveHilites(callback: dynamic): Unit = definedExternally
    companion object {
        /**
         *  Creates a new HiliteEditor
         * 
         *  @param typeCheckedProperties {Partial<HiliteEditor>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {HiliteEditor} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): HiliteEditor = definedExternally
    }
}