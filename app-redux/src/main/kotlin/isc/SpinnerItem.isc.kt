@file:JsQualifier("isc")
package isc

/**
 *  Item for picking a number. Includes arrow buttons to increase / decrease the value
 */
open external class SpinnerItem : TextItem {
    /**
     *  Not applicable to a SpinnerItem.
     *  @type {string}
     *  @default null
     */
    override var mask: String = definedExternally
    /**
     *  Not applicable to a SpinnerItem.
     *  @type {boolean}
     *  @default null
     */
    override var maskSaveLiterals: Boolean = definedExternally
    /**
     *  Not applicable to a SpinnerItem.
     *  @type {string}
     *  @default " "
     */
    override var maskPadChar: String = definedExternally
    /**
     *  Not applicable to a SpinnerItem.
     *  @type {string}
     *  @default "_"
     */
    override var maskPromptChar: String = definedExternally
    /**
     *  Not applicable to a SpinnerItem.
     *  @type {boolean}
     *  @default null
     */
    override var maskOverwriteMode: Boolean = definedExternally
    /**
     *  In SpinnerItem.writeStackedIcons, the base CSS class name for the
     *   SpinnerItem's text box element.
     * 
     *   NOTE: See the CompoundFormItem_skinning discussion for special
     *   skinning considerations.
     *  @type {FormItemBaseStyle}
     *  @default "textItem"
     */
    open var unstackedTextBoxStyle: String = definedExternally
    /**
     *  In SpinnerItem.writeStackedIcons, the base CSS class name for the
     *   SpinnerItem's text box element when printed. If unset, then SpinnerItem.unstackedTextBoxStyle
     *   is used.
     *  @type {FormItemBaseStyle}
     *  @default null
     */
    open var unstackedPrintTextBoxStyle: String = definedExternally
    /**
     *  @type {FormItemBaseStyle}
     *  @default null
     */
    open var unstackedReadOnlyTextBoxStyle: String = definedExternally
    /**
     *  How much should the value be incremented / decremented when the user hits the icons
     *   to increase / decrease the value?
     * 
     * 
     *   When overriding SpinnerItem.getNextValue and/or SpinnerItem.getPreviousValue,
     *   the sign of the step value determines whether these methods
     * 
     *   are expected to induce monotonically increasing or decreasing functions.
     *  @type {Double}
     *  @default "1"
     */
    open var step: Number = definedExternally
    /**
     *  Maximum valid value for this item. If this and SpinnerItem.min are both
     *   null or unspecified, then
     * 
     *   SpinnerItem.getNextValue and SpinnerItem.getPreviousValue
     *   are used to increase or decrease the value and these methods
     * 
     *   are also used to determine the maximum value.
     *  @type {Double}
     *  @default null
     */
    open var max: Number = definedExternally
    /**
     *  Minimum valid value for this item. If this and SpinnerItem.max are both
     *   null or unspecified, then
     * 
     *   SpinnerItem.getNextValue and SpinnerItem.getPreviousValue
     *   are used to increase or decrease the value and these methods
     * 
     *   are also used to determine the minimum value.
     *  @type {Double}
     *  @default null
     */
    open var min: Number = definedExternally
    /**
     *  In SpinnerItem.writeStackedIcons, the icon to increase the spinner's
     *   value (an up arrow by default). This icon is generated automatically using
     *   the AutoChild pattern. For skinning purposes, increaseIconDefaults
     *   may be modified using Class.changeDefaults.
     * 
     *   If sizes for the increase and decrease icons are not explicitly specified in their
     *   autoChild configuration, they will be derived from the specified
     *   SpinnerItem.stackedIconsHeight and SpinnerItem.stackedIconsWidth
     *   properties.
     * 
     *   See the
     *   skinning for details on how to provide a sprited
     *   image for these icons.
     *  @type {FormItemIcon}
     *  @default null
     */
    open var increaseIcon: FormItemIcon = definedExternally
    /**
     *  FormItemIcon properties applied to the SpinnerItem.increaseIcon AutoChild of this
     *   SpinnerItem.
     *  @type {FormItemIcon}
     *  @default null
     */
    open var increaseIconProperties: FormItemIcon = definedExternally
    /**
     *  In SpinnerItem.writeStackedIcons, the icon to decrease the spinner's
     *   value (a down arrow by default). This icon is generated automatically using
     *   the AutoChild pattern. For skinning purposes, decreaseIconDefaults
     *   may be modified using Class.changeDefaults.
     * 
     *   If sizes for the increase and decrease icons are not explicitly specified in their
     *   autoChild configuration, they will be derived from the specified
     *   SpinnerItem.stackedIconsHeight and SpinnerItem.stackedIconsWidth
     *   properties.
     * 
     *   See the
     *   skinning for details on how to provide a sprited
     *   image for these icons.
     *  @type {FormItemIcon}
     *  @default null
     */
    open var decreaseIcon: FormItemIcon = definedExternally
    /**
     *  FormItemIcon properties applied to the SpinnerItem.decreaseIcon AutoChild of this
     *   SpinnerItem.
     *  @type {FormItemIcon}
     *  @default null
     */
    open var decreaseIconProperties: FormItemIcon = definedExternally
    /**
     *  When set to true, the increase and decrease icons are stacked on top of
     *   each other, also called stacked mode. When false, the increase and decrease
     *   icons are placed on the same line as the SpinnerItem's text box, also called
     *   unstacked mode. When null, a default setting depending on Browser.isTouch
     *   is used (for touch browsers, the default is false/unstacked mode).
     * 
     *   In stacked mode, SpinnerItem.increaseIcon and SpinnerItem.decreaseIcon
     *   control the appearance of the stacked icons.
     * 
     *   In unstacked mode, SpinnerItem.unstackedIncreaseIcon and SpinnerItem.unstackedDecreaseIcon
     *   control the appearance of the unstacked icons.
     *  @type {boolean}
     *  @default null
     */
    open var writeStackedIcons: Boolean = definedExternally
    /**
     *  In SpinnerItem.writeStackedIcons this property can be
     *   used to specify the width of both the increase and decrease icon.
     *   If a width property is explicitly
     *   set for the icon via SpinnerItem.increaseIconProperties,
     *   SpinnerItem.decreaseIconProperties, or related Defaults property
     *   blocks, that will take precedence over any specified stackedIconsWidth.
     * 
     *   See also SpinnerItem.stackedIconsHeight.
     *  @type {Integer}
     *  @default "16"
     */
    open var stackedIconsWidth: Number = definedExternally
    /**
     *  In SpinnerItem.writeStackedIcons this property can be
     *   used to specify the height of both the increase and decrease icon. Since the
     *   icons are stacked vertically, each icon will be sized to half this specified value.
     *   If a height property is explicitly
     *   set for the icon via SpinnerItem.increaseIconProperties,
     *   SpinnerItem.decreaseIconProperties, or related Defaults property
     *   blocks, that will take precedence over any specified stackedIconsHeight.
     * 
     *   See also SpinnerItem.stackedIconsWidth.
     *  @type {Integer}
     *  @default "18"
     */
    open var stackedIconsHeight: Number = definedExternally
    /**
     *  In SpinnerItem.writeStackedIcons, the icon to increase the
     *   SpinnerItem's value.
     * 
     *   By default, "[SKIN]/DynamicForm/Spinner_increase_icon.png" is stretched to
     *   an 18x18 icon.
     * 
     *   When skinning is enabled, this property will not
     *   be used to locate an image, instead, the image is drawn via CSS based on the
     *   FormItemIcon.baseStyle property.
     *  @type {FormItemIcon}
     *  @default null
     */
    open var unstackedIncreaseIcon: FormItemIcon = definedExternally
    /**
     *  In SpinnerItem.writeStackedIcons, the icon to decrease the
     *   SpinnerItem's value.
     * 
     *   By default, "[SKIN]/DynamicForm/Spinner_decrease_icon.png" is stretched to
     *   an 18x18 icon.
     * 
     *   When skinning is enabled, this property will not
     *   be used to locate an image, instead, the image is drawn via CSS based on the
     *   FormItemIcon.baseStyle property.
     *  @type {FormItemIcon}
     *  @default null
     */
    open var unstackedDecreaseIcon: FormItemIcon = definedExternally
    /**
     *   When SpinnerItem.min and SpinnerItem.max are both null or unspecified,
     *   this method is called to get the next higher value from the currentValue. The default
     *   implementation returns (currentValue&nbsp;+&nbsp;step).
     * 
     *   To indicate that the given currentValue is the maximum value, return currentValue again.
     * 
     *   Implementations should expect to be passed any value for currentValue. Also, if
     *   SpinnerItem.step is non-negative, getNextValue() must induce a
     *   monotonically increasing (non-decreasing) function;
     *   otherwise, getNextValue() must induce a monotonically decreasing function.
     * 
     *  @param {number} the current value of this SpinnerItem
     *  @param {number} a suggested step value based on SpinnerItem.step and how long the user has been continuously increasing the value.
     */
    open fun getNextValue(currentValue: Number, step: Number): Number = definedExternally
    /**
     *   When SpinnerItem.min and SpinnerItem.max are both null or unspecified,
     *   this method is called to get the previous lower value from the currentValue. The default
     *   implementation returns (currentValue&nbsp;+&nbsp;step) because the step parameter
     *   is based on the opposite of SpinnerItem.step.
     * 
     *   To indicate that the given currentValue is the minimum value, return currentValue again.
     * 
     *   Implementations should expect to be passed any value for currentValue. Also, if
     *   SpinnerItem.step is non-negative, getPreviousValue() must induce a
     *   monotonically decreasing (non-increasing) function;
     *   otherwise, getPreviousValue() must induce a monotonically increasing function.
     * 
     *  @param {number} the current value of this SpinnerItem
     *  @param {number} a suggested step value based on the opposite of SpinnerItem.step and how long the user has been continuously decreasing the value.
     */
    open fun getPreviousValue(currentValue: Number, step: Number): Number = definedExternally
    companion object {
        /**
         *  Creates a new SpinnerItem
         * 
         *  @param typeCheckedProperties {Partial<SpinnerItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {SpinnerItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): SpinnerItem = definedExternally
    }
}