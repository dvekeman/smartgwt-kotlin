@file:JsQualifier("isc")
package isc

/**
 *  Checkbox form item, implemented with customizable checkbox images.
 */
open external class CheckboxItem : FormItem {
    /**
     *  Base CSS class for this item's title cell.
     * 
     *   Note: This styling applies to the standard form item title cell for this item - it
     *   does not apply to item's CheckboxItem.showLabel.
     *   To modify the styling for that text, use CheckboxItem.textBoxStyle instead.
     *  @type {FormItemBaseStyle}
     *  @default null
     */
    override var titleStyle: String = definedExternally
    /**
     *  Base CSS class for this item's title text
     *  @type {FormItemBaseStyle}
     *  @default "labelAnchor"
     */
    override var textBoxStyle: String = definedExternally
    /**
     *  Width for the CheckboxItem, including both checkbox image and CheckboxItem.showLabel.
     *   Note that if CheckboxItem.showLabel is false, this property will have no effect - the
     *   item will render at the size required to contain the icon.
     *  @type {number}
     *  @default "150"
     */
    override var width: dynamic = definedExternally
    /**
     *  CheckboxItem has special behavior for titles, see CheckboxItem.labelAsTitle.
     *  @type {boolean}
     *  @default true
     */
    override var showTitle: Boolean = definedExternally
    /**
     *  By default a checkboxItem sets CheckboxItem.showTitle:true, and so takes up two cells with the
     *   default TitleOrientation of "left" (see formLayout). However, the title cell is left blank by default, and the title specified
     *   by FormItem.title is shown inside the formItem's cell instead, in an element
     *   called the "label".
     * 
     *   To instead show the title in it's original location, set labelAsTitle:true.
     *   You can also set CheckboxItem.showLabel:false to suppress the label and/or title altogether.
     *  @type {boolean}
     *  @default null
     */
    open var labelAsTitle: Boolean = definedExternally
    /**
     *  Should we show the label text next to the checkbox item.
     *  @type {boolean}
     *  @default true
     */
    open var showLabel: Boolean = definedExternally
    /**
     *  Should an "Over" state icon be shown when the user rolls over this checkbox
     *  @type {boolean}
     *  @default true
     */
    open var showValueIconOver: Boolean = definedExternally
    /**
     *  Should a "Down" state icon be shown when the mouse goes down over this checkbox
     *  @type {boolean}
     *  @default true
     */
    open var showValueIconDown: Boolean = definedExternally
    /**
     *  Should a "Disabled" state icon be shown when the item is disabled
     *  @type {boolean}
     *  @default true
     */
    open var showValueIconDisabled: Boolean = definedExternally
    /**
     *  URL for the image to display when this checkbox is selected, or checked.
     * 
     *   This image is implemented using the FormItem.valueIcons,
     *   and may be modified via the standard valueIcons properties such as
     *   CheckboxItem.valueIconWidth
     * 
     *   Note that this is the base image name - if CheckboxItem.showValueIconOver et al are set, the
     *   state ("Over", "Down" and "Disabled") will be
     *   added to this name as the user interacts with the checkbox, as well as the image extension
     * 
     *   The special value "blank" means that no image will be shown.
     * 
     *   skinning can be used for this image, by setting this property to
     *   a SCSpriteConfig formatted string. Alternatively developers can
     *   omit this property and instead use CSS directly in the
     *   CheckboxItem.booleanBaseStyle property to provide a "checked" appearance.
     *  @type {SCImgURL}
     *  @default "[SKIN]/DynamicForm/checked.gif"
     */
    open var checkedImage: String = definedExternally
    /**
     *  URL for the image to display when this checkbox is not selected, or unchecked.
     * 
     *   The special value "blank" means that no image will be shown.
     * 
     *   skinning can be used for this image, by setting this property to
     *   a SCSpriteConfig formatted string. Alternatively developers can
     *   omit this property and instead use CSS directly in the
     *   CheckboxItem.booleanBaseStyle property to provide an "unchecked" appearance.
     *  @type {SCImgURL}
     *  @default "[SKIN]/DynamicForm/unchecked.gif"
     */
    open var uncheckedImage: String = definedExternally
    /**
     *  URL for the image to display when this checkbox is partially selected.
     * 
     *   The special value "blank" means that no image will be shown.
     * 
     *   skinning can be used for this image, by setting this property to
     *   a SCSpriteConfig formatted string. Alternatively developers can
     *   omit this property and instead use CSS directly in the
     *   CheckboxItem.booleanBaseStyle property to provide a "partially checked" appearance.
     *  @type {SCImgURL}
     *  @default "[SKIN]/DynamicForm/partialcheck.gif"
     */
    open var partialSelectedImage: String = definedExternally
    /**
     *  If set, the CheckboxItem.checkedImage to use when printing.
     *  @type {SCImgURL}
     *  @default null
     */
    open var printCheckedImage: String = definedExternally
    /**
     *  If set, the CheckboxItem.uncheckedImage to use when printing.
     *  @type {SCImgURL}
     *  @default null
     */
    open var printUncheckedImage: String = definedExternally
    /**
     *  If set, the CheckboxItem.partialSelectedImage to use when printing.
     *  @type {SCImgURL}
     *  @default null
     */
    open var printPartialSelectedImage: String = definedExternally
    /**
     *  Determines what image to display when the value for this checkbox is unset.
     *   Set to true to display the CheckboxItem.unsetImage for null values, or false to
     *   use the CheckboxItem.uncheckedImage for both null and explicitly unchecked values.
     * 
     *   If this attribute is not set, the CheckboxItem.unsetImage for null values if
     *   CheckboxItem.allowEmptyValue is true for this item, otherwise the unchecked
     *   image will be used.
     *  @type {boolean}
     *  @default null
     */
    open var showUnsetImage: Boolean = definedExternally
    /**
     *  URL for the image to display when this checkbox is unset. Note that if
     *   CheckboxItem.showUnsetImage is false or CheckboxItem.allowEmptyValue is false
     *   the CheckboxItem.uncheckedImage will be used for null values rather than this
     *   image.
     * 
     *   The special value "blank" means that no image will be shown.
     * 
     *   skinning can be used for this image, by setting this property to
     *   a SCSpriteConfig formatted string. Alternatively developers can
     *   omit this property and instead use CSS directly in the
     *   CheckboxItem.booleanBaseStyle property to provide an "unset" appearance.
     *  @type {SCImgURL}
     *  @default "[SKIN]/DynamicForm/unsetcheck.gif"
     */
    open var unsetImage: String = definedExternally
    /**
     *  If set, the CheckboxItem.unsetImage to use when printing.
     *  @type {SCImgURL}
     *  @default null
     */
    open var printUnsetImage: String = definedExternally
    /**
     *  The description shown in a hover when FormItem.showOldValueInHover is enabled
     *   and a value represents the checked state.
     *  @type {HTMLString}
     *  @default "checked"
     */
    open var checkedDescription: String = definedExternally
    /**
     *  The description shown in a hover when FormItem.showOldValueInHover is enabled
     *   and a value represents the unchecked state.
     *  @type {HTMLString}
     *  @default "unchecked"
     */
    open var uncheckedDescription: String = definedExternally
    /**
     *  The description shown in a hover when FormItem.showOldValueInHover is enabled
     *   and a value represents the partial selected state.
     *  @type {HTMLString}
     *  @default "partially selected"
     */
    open var partialSelectedDescription: String = definedExternally
    /**
     *  The description shown in a hover when FormItem.showOldValueInHover is enabled
     *   and a value represents the unset state.
     *  @type {HTMLString}
     *  @default "unset"
     */
    open var unsetDescription: String = definedExternally
    /**
     *  An optional base CSS style to apply to the checkbox image. If supplied, the base style is
     *   suffixed with "True", "False", "Partial", or "Unset" if the checkbox is selected, unselected,
     *   partially selected, or unset. The style is then suffixed with the state of the value icon
     *   ("", "Over", "Down", "Disabled").
     *  @type {CSSStyleName}
     *  @default null
     */
    open var booleanBaseStyle: String = definedExternally
    /**
     *  If set, the CheckboxItem.booleanBaseStyle to use when printing.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var printBooleanBaseStyle: String = definedExternally
    /**
     *  Width of the checkbox image.
     *  @type {number}
     *  @default "13"
     */
    override var valueIconWidth: Number = definedExternally
    /**
     *  Height of the checkbox image.
     *  @type {number}
     *  @default "13"
     */
    override var valueIconHeight: Number = definedExternally
    /**
     *  Object defining how the checkbox "checked" state will be mapped to the field value.
     *   Checkboxes only support 2 states. By default a checked checkbox will have
     *   value true, and an unchecked one will have value false
     *   (or null if there is no default value and the value has never been set).
     * 
     *   A valueMap can modify this in 2 ways:
     *   - If the desired checked/unchecked values can be resolved to true
     *    and false directly in JavaScript, the valueMap may be specified as
     *    a 2-element array containing these values. Examples of this would include
     *    &nbsp;&nbsp;[0,1]:
     *    In this case an unchecked checkbox would have value 0 and a checked box
     *    would have value 1
     *    &nbsp;&nbsp;[null,"Some String"]:
     *    In this case an unchecked checkbox would have value null and a checked
     *    box would have value "Some String"
     *   - More arbitrary data values can be resolved to checked / unchecked values via an
     *    object mapping the arbitrary data values to display values of true and
     *    false. For example:
     *    &nbsp;&nbsp;{"A":false, "B":true}
     *    In this case an unchecked checkbox would have value "A", and a checked box
     *    would have value "B"
     * 
     *   Note: ValueMaps in other formats will be ignored by the CheckboxItem class. To update
     *   the valueMap at runtime, always use CheckboxItem.setValueMap
     *  @type {object | Array<any>}
     *  @default null
     */
    override var valueMap: dynamic = definedExternally
    /**
     *  By default checkboxes allow the user to toggle between true and false values only.
     *   Setting this property to true will allow the user to toggle between three values -
     *   true, false and unset.
     *  @type {boolean}
     *  @default false
     */
    open var allowEmptyValue: Boolean = definedExternally
    /**
     *  If this checkbox item is CheckboxItem.showLabel, should
     *   it ignore any specified FormItem.width and instead size to fit its
     *   CheckboxItem.checkedImage?
     * 
     *   When set to true (the default), the checkbox item ignores any specified width,
     *   ensuring that it does not impact the the containing DynamicForm's table geometry
     *   unnecessarily.
     *  @type {boolean}
     *  @default true
     */
    open var sizeToCheckboxImage: Boolean = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "CheckboxItemEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
    /**
     *   Setter method to apply a valueMap to a checkbox item.
     *   Note that if this method is overridden, the override must call
     *   this.Super("setValueMap", arguments); to maintain functionality in this
     *   class.
     * 
     */
    open fun setValueMap(): Unit = definedExternally
    /**
     *   Return the value tracked by this form item as a Boolean. If the value is not
     *   already a boolean, or is unset and CheckboxItem.allowEmptyValue is true,
     *   then null will be returned.
     * 
     * 
     */
    open fun getValueAsBoolean(): Boolean = definedExternally
    /**
     *   Notification method called when FormItem.showPending is enabled and
     *   this checkbox item should either clear or show its pending visual state.
     * 
     *   The default behavior is that the FormItem.cellStyle and checkbox label
     *   style are updated to include/exclude the "Pending" suffix. Returning false
     *   will cancel this default behavior.
     * 
     *  @param {DynamicForm} the managing DynamicForm instance.
     *  @param {FormItem} the form item itself (also available as "this").
     *  @param {boolean} true if the item should show its pending visual state; false otherwise.
     *  @param {any} the current form item value.
     *  @param {any} the value that would be restored by a call to DynamicForm.resetValues.
     */
    override fun pendingStatusChanged(form: DynamicForm, item: FormItem, pendingStatus: Boolean, newValue: dynamic, value: dynamic): Boolean = definedExternally
    companion object {
        /**
         *  Creates a new CheckboxItem
         * 
         *  @param typeCheckedProperties {Partial<CheckboxItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {CheckboxItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): CheckboxItem = definedExternally
    }
}