@file:JsQualifier("isc")
package isc

/**
 *  A widget for editing the criteria of a single DataBoundComponent hilite.
 *   The default implementation presents a series of FormItem
 *   for selecting the various elements of a simple criterion and a foreground or background
 *   color. To specify more complex criteria, specify both foreground and background colors or
 *   to apply the hilite to multiple fields, you can create an
 *   AdvancedHiliteEditor.
 * 
 *   Important Note: this class should not be used directly - it is exposed purely for
 *   i18nMessages
 */
open external class HiliteRule : HLayout {
    /**
     *  AutoChild FilterClause displaying the FormItem used to
     *   specify the criteria for this HiliteRule.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   hiliteRule.clauseProperties.
     *  @type {FilterClause}
     *  @default null
     */
    open var clause: FilterClause = definedExternally
    /**
     *  AutoChild DynamicForm displaying the FormItem used to
     *   specify the hiliting properties of this rule.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   hiliteRule.hiliteFormProperties.
     *  @type {DynamicForm}
     *  @default null
     */
    open var hiliteForm: DynamicForm = definedExternally
    /**
     *  The title for the Color picker field.
     *  @type {string}
     *  @default "Color"
     */
    open var colorFieldTitle: String = definedExternally
    /**
     *  AutoChild Label displaying the human-readable description of an advanced
     *   hilite-rule.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   hiliteRule.advancedClauseLabelProperties.
     *  @type {Label}
     *  @default null
     */
    open var advancedClauseLabel: Label = definedExternally
    /**
     *  AutoChild ImgButton displayed by an advanced hilite-rule and used to open
     *   it for editing in an AdvancedHiliteEditor.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   hiliteRule.advancedClauseEditButtonProperties.
     *  @type {ImgButton}
     *  @default null
     */
    open var advancedClauseEditButton: ImgButton = definedExternally
    /**
     *  If true, show a HiliteRule.removeButton for this HiliteRule, allowing it
     *   to be removed.
     *  @type {boolean}
     *  @default true
     */
    open var showRemoveButton: Boolean = definedExternally
    /**
     *  The hover prompt text for the HiliteRule.removeButton.
     *  @type {string}
     *  @default "Remove"
     */
    open var removeButtonPrompt: String = definedExternally
    /**
     *  The Hilite removal ImgButton that appears before this Hilite if HiliteRule.showRemoveButton
     *   is set.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   hiliteRule.removeButtonProperties.
     *  @type {ImgButton}
     *  @default null
     */
    open var removeButton: ImgButton = definedExternally
    /**
     *  The FormItem.title of the 'Text' color picker.
     *  @type {string}
     *  @default "Text"
     */
    open var foregroundColorTitle: String = definedExternally
    /**
     *  The FormItem.title of the 'Background' color picker.
     *  @type {string}
     *  @default "Background"
     */
    open var backgroundColorTitle: String = definedExternally
    /**
     *  The FormItem.title of the 'Icon' picker.
     *  @type {string}
     *  @default "Icon"
     */
    open var iconFieldTitle: String = definedExternally
    /**
     *   Remove this HiliteRule. Default implementation calls markForDestroy().
     * 
     * 
     */
    open fun remove(): Unit = definedExternally
    /**
     *   Return the hilite definition being edited, including criteria and hilite properties.
     * 
     * 
     */
    open fun getHilite(): Hilite = definedExternally
    companion object {
        /**
         *  Creates a new HiliteRule
         * 
         *  @param typeCheckedProperties {Partial<HiliteRule>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {HiliteRule} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): HiliteRule = definedExternally
    }
}