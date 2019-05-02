@file:JsQualifier("isc")
package isc

/**
 *  FormItem that uses a Slider component to present an interface for picking
 *   from either a continuous range or a range with a small number of discrete values.
 */
open external class SliderItem : CanvasItem {
    /**
     *  Default width of this item.
     *  @type {number}
     *  @default "150"
     */
    override var width: dynamic = definedExternally
    /**
     *  Indicates whether this is a vertical or horizontal slider.
     *  @type {boolean}
     *  @default false
     */
    open var vertical: Boolean = definedExternally
    /**
     *  The minimum slider value. The slider value is equal to minValue when the thumb is at the
     *   bottom or left of the slider (unless flipValues is true, in which case the minimum value
     *   is at the top/right of the slider)
     *  @type {Float}
     *  @default "1"
     */
    open var minValue: Number = definedExternally
    /**
     *  The maximum slider value. The slider value is equal to maxValue when the thumb is at the
     *   top or right of the slider (unless flipValues is true, in which case the maximum value
     *   is at the bottom/left of the slider)
     *  @type {Float}
     *  @default "100"
     */
    open var maxValue: Number = definedExternally
    /**
     *  The number of discrete values represented by slider. If specified, the range of valid
     *   values (between minValue and maxValue) will be divided into
     *   this many steps. As the thumb is moved along the track it will only select these values
     *   and appear to jump between the steps.
     *  @type {Integer}
     *  @default null
     */
    open var numValues: Number = definedExternally
    /**
     *  Specifies whether the slider value should be rounded to the nearest integer. If set to
     *   false, values will be rounded to a fixed number of decimal places controlled by
     *   SliderItem.roundPrecision.
     *  @type {boolean}
     *  @default true
     */
    open var roundValues: Boolean = definedExternally
    /**
     *  If Slider.roundValues is false, the slider value will be rounded to this number of
     *   decimal places. If set to null the value will not be rounded
     *  @type {number}
     *  @default "1"
     */
    open var roundPrecision: Number = definedExternally
    /**
     *  Default value for this sliderItems is 1.
     *  @type {Integer}
     *  @default "1"
     */
    override var defaultValue: Number = definedExternally
    /**
     *  This item is an autoChild generated Canvas displayed by
     *   the SliderItem and is an instance of Slider by default. It is customizable
     *   via the standard AutoChild pattern, by customizing SliderItem.sliderProperties
     *   and SliderItem.sliderConstructor.
     *  @type {Canvas}
     *  @default null
     */
    open var slider: Canvas = definedExternally
    /**
     *  Properties to add to the automatically created Slider used by this
     *   FormItem. See the Slider class for reference.
     *  @type {Slider}
     *  @default null
     */
    open var sliderProperties: Slider = definedExternally
    /**
     *  Should this item's value be saved in the form's values and hence returned from
     *   DynamicForm.getValues?
     * 
     *   shouldSaveValue:false is used to mark formItems which do not correspond to
     *   the underlying data model and should not save a value into the form's
     *   DynamicForm.values. Example includes visual separators, password re-type fields,
     *   or checkboxes used to show/hide other form items.
     * 
     *   A shouldSaveValue:false item should be given a value either via
     *   FormItem.defaultValue or by calling
     *   DynamicForm.setValue or
     *   FormItem.setValue. Providing a value via
     *   DynamicForm.values or DynamicForm.setValues
     *   will automatically switch the item to shouldSaveValue:true.
     * 
     *   Note that
     * 
     *  - if an item is shouldSaveValue true, but has no name, a warning is logged, and
     *     shouldSaveValue will be set to false.
     * 
     *  @type {boolean}
     *  @default true
     */
    override var shouldSaveValue: Boolean = definedExternally
    /**
     *  Constructor class for this item's Slider.
     *  @type {Class}
     *  @default "Slider"
     */
    open var sliderConstructor: Class = definedExternally
    /**
     *  Should this sliderItem update its value and fire change handlers while the user is
     *   actively dragging the slider.
     *   Setting this attribute value to false will suppress any change notifications
     *   from the user dragging the slider thumb until the user releases the mouse at the final
     *   position.
     *   This can be useful to avoid repeatedly firing expensive operations such as server fetches
     *   while the user drags through a range of values.
     *  @type {boolean}
     *  @default true
     */
    open var changeOnDrag: Boolean = definedExternally
    /**
     *   Notification method called when FormItem.showPending is enabled and
     *   this SliderItem should either clear or show its pending visual state.
     * 
     *   The default behavior is that the FormItem.titleStyle and
     *   FormItem.cellStyle are updated to include/exclude the "Pending" suffix.
     *   In addition, when displayed in the pending state the value label changes color.
     *   Returning false will cancel this default behavior.
     * 
     *  @param {DynamicForm} the managing DynamicForm instance.
     *  @param {FormItem} the form item itself (also available as "this").
     *  @param {boolean} true if the item should show its pending visual state; false otherwise.
     *  @param {any} the current form item value.
     *  @param {any} the value that would be restored by a call to DynamicForm.resetValues.
     */
    override fun pendingStatusChanged(form: DynamicForm, item: FormItem, pendingStatus: Boolean, newValue: dynamic, value: dynamic): Boolean = definedExternally
    /**
     *   Sets the Slider.minValue of the slider
     * 
     * 
     *  @param {Float} the new minimum value
     */
    open fun setMinValue(newValue: Number): Unit = definedExternally
    /**
     *   Sets the Slider.maxValue of the slider
     * 
     * 
     *  @param {Float} the new maximum value
     */
    open fun setMaxValue(newValue: Number): Unit = definedExternally
    /**
     *   Sets the Slider.numValues for the slider
     * 
     * 
     *  @param {Integer} the new number of values
     */
    open fun setNumValues(newNumValues: Number): Unit = definedExternally
    companion object {
        /**
         *  Creates a new SliderItem
         * 
         *  @param typeCheckedProperties {Partial<SliderItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {SliderItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): SliderItem = definedExternally
    }
}