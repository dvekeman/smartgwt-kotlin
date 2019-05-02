@file:JsQualifier("isc")
package isc

/**
 *  FormItem for adding a Button to a form.
 */
open external class ButtonItem : CanvasItem {
    /**
     *  By default buttonItems are sized to match their content (see ButtonItem.autoFit).
     *   Specifying an explicit size for the button will disable this behavior.
     *  @type {number}
     *  @default null
     */
    override var height: dynamic = definedExternally
    /**
     *  Optional baseStyle will be applied to the button.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var baseStyle: String = definedExternally
    /**
     *  Optional icon image to display on the button for this item. See Button.icon.
     *  @type {SCImgURL}
     *  @default null
     */
    open var icon: String = definedExternally
    /**
     *  Buttons do not show a title by default.
     *  @type {boolean}
     *  @default false
     */
    override var showTitle: Boolean = definedExternally
    /**
     *  These items are in a row by themselves by default
     *  @type {boolean}
     *  @default true
     */
    override var startRow: Boolean = definedExternally
    /**
     *  These items are in a row by themselves by default
     *  @type {boolean}
     *  @default true
     */
    override var endRow: Boolean = definedExternally
    /**
     *  This item is an autoChild generated Canvas displayed by
     *   the ButtonItem and is an instance of Button by defaut, cuztomizeable
     *   via the ButtonItem.buttonConstructor attribute.
     *  @type {Canvas}
     *  @default null
     */
    open var button: Canvas = definedExternally
    /**
     *  Constructor class for the button.
     *  @type {Class}
     *  @default "Button"
     */
    open var buttonConstructor: Class = definedExternally
    /**
     *  Should the button auto fit to its title. Maps to Button.autoFit attribute.
     *   Note that if an explicit width or height is specified for this item, it will be respected,
     *   disabling autoFit behavior
     *  @type {boolean}
     *  @default true
     */
    open var autoFit: Boolean = definedExternally
    /**
     *  Custom Properties to apply to our button item.
     *  @type {object}
     *  @default null
     */
    open var buttonProperties: dynamic = definedExternally
    /**
     *  If this item is FormItem.getCanEdit, how should this item be displayed
     *   to the user? If set, overrides the form-level DynamicForm.readOnlyDisplay default.
     *  @type {ReadOnlyDisplayAppearance}
     *  @default "disabled"
     */
    override var readOnlyDisplay: 
                                  /**
                                   *  Item value should appear within the form as a static block of text, similar to the default appearance of a StaticTextItem. This appearance may be
                                   *   modified via FormItem.readOnlyTextBoxStyle and FormItem.clipStaticValue.
                                   *  Item should appear unchanged, but user interaction to edit the item will be disallowed. Note that some interactions will be allowed, such as selecting text
                                   *   within a read-only TextItem for copy and paste. Exact implementation may vary by
                                   *   form item type.
                                   *  Item will appear disabled.
                                   */
                                  String /* static |  readOnly |  disabled */ = definedExternally
    /**
     *  Criteria to be evaluated to determine whether this item should be enabled. This
     *   property is incompatible with FormItem.readOnlyWhen and any setting you provide for
     *   the latter will be ignored if this property is set.
     * 
     *   Criteria are evaluated against the ${isc.DocUtils.linkForRef('method:DynamicForm.getValues','form\'s current values')} as
     *   well as the current Canvas.ruleScope. Criteria are re-evaluated
     *   every time form values or the rule context changes, whether by end user action or by
     *   programmatic calls.
     * 
     *   A basic criteria uses textMatchStyle:"exact". When specified in
     *   componentXML this property allows
     *   xmlCriteriaShorthand for defining criteria.
     * 
     *   Note: A ButtonItem using enableWhen must have a FormItem.name defined.
     *   CanvasItem.shouldSaveValue can be set to false to prevent the field from storing
     *   its value into the form's values.
     *  @type {AdvancedCriteria}
     *  @default null
     */
    open var enableWhen: AdvancedCriteria = definedExternally
    /**
     *  This property governs whether StatefulCanvas.showFocusedAsOver is true
     *   on the automatically created Button for this item.
     *  @type {boolean}
     *  @default null
     */
    open var showFocusedAsOver: Boolean = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "ButtonItemEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
    /**
     *   Called when a ButtonItem is clicked on.
     * 
     * 
     *  @param {DynamicForm} the managing DynamicForm instance
     *  @param {FormItem} the form item itself (also available as "this")
     */
    override fun click(form: DynamicForm, item: FormItem): Boolean = definedExternally
    /**
     *   Set the title.
     * 
     *  @param {string} new title
     */
    open fun setTitle(newTitle: String): Unit = definedExternally
    /**
     *   Sets showFocusedAsOver.
     * 
     * \* @param {boolean} 
     */
    open fun setShowFocusedAsOver(showFocusedAsOver: Boolean): Unit = definedExternally
    companion object {
        /**
         *  Creates a new ButtonItem
         * 
         *  @param typeCheckedProperties {Partial<ButtonItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ButtonItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ButtonItem = definedExternally
    }
}