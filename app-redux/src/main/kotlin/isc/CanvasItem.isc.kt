@file:JsQualifier("isc")
package isc

/**
 *  FormItem which renders a Canvas inline in a DynamicForm instance.
 * 
 *   CanvasItem is CanvasItem.shouldSaveValue:false by default, meaning that
 *   no value from the CanvasItem will be present in DynamicForm.getValues and no value will be
 *   saved when DynamicForm.saveData is called. This is appropriate if the Canvas does
 *   not participate in editing a value of the form and is embedded in the form for layout or UI
 *   purposes only (e.g. ButtonItem, SectionItem). Note that some built-in CanvasItem
 *   types override the shouldSaveValue default to true (e.g. MultiComboBoxItem, RichTextItem).
 * 
 *   If you set FormItem.shouldSaveValue:true, a
 *   CanvasItem.showValue event will be raised to provide a value that your
 *   item should display. Handle this event by calling methods on the Canvas you've created
 *   to cause the value to be displayed.
 * 
 *   The CanvasItem.showValue event will be triggered in various situations where
 *   the form receives data, including a call to DynamicForm.setValues,
 *   DynamicForm.editRecord, or if DynamicForm.fetchData is called and a Record
 *   is returned. Bear in mind that the showValue event can be called when the form
 *   and your item have not yet been drawn; in this case, store the value for later display.
 * 
 *   To provide a value to the form, call CanvasItem.storeValue whenever the user changes
 *   the value in your Canvas. Generally, if storeValue() is called then
 *   CanvasItem.shouldSaveValue should be overridden to true. Note that
 *   the form will not call getValue() in order to discover your item's value, so there is
 *   no purpose in overriding this method; instead, call storeValue() to proactively inform the
 *   form about changes to the value. This approach is necessary in order to enable change events.
 * 
 *   If you cannot easily detect changes to values in your Canvas, a workaround is to call
 *   storeValue right before the form saves.
 */
open external class CanvasItem : FormItem {
    /**
     *  Height of the Canvas. Can be either a number indicating a fixed height in pixels, a
     *   percentage indicating a percentage of the overall form's height, or "\*" indicating take
     *   whatever remaining space is available. See the formLayout overview for details.
     * 
     *   Height may also be explicitly specified on the CanvasItem.canvas. In this
     *   any canvasItem.height will be ignored in favor of the value applied
     *   to the canvas directly. In either case, percentage values will be resolved using
     *   standard formItem sizing rules as described in formLayout
     *  @type {Integer | string}
     *  @default null
     */
    override var height: dynamic = definedExternally
    /**
     *  Whether this CanvasItem is intended to hold multiple values.
     * 
     *  @type {boolean}
     *  @default null
     */
    override var multiple: Boolean = definedExternally
    /**
     *  Should this item's value be saved in the form's values and hence returned from
     *   DynamicForm.getValues?
     * 
     *   Note that by default, shouldSaveValue is false for CanvasItems,
     *   meaning that no value from the CanvasItem will be present in DynamicForm.getValues
     *   and no value for the CanvasItem will be saved when DynamicForm.saveData is called.
     *   See the CanvasItem class overview for a discussion of values handling in
     *   CanvasItems.
     *  @type {boolean}
     *  @default false
     */
    override var shouldSaveValue: Boolean = definedExternally
    /**
     *  The canvas that will be displayed inside this item. You can pass an instance you've
     *   already created, or its global ID as a String. You can also implement
     *   CanvasItem.createCanvas to dynamically create the canvas when the FormItem
     *   is initialized.
     * 
     *   If canvas and createCanvas() are unspecified, the
     *   canvas for this item will be auto-created using the overrideable defaults:
     *   CanvasItem.canvasProperties and CanvasItem.canvasConstructor
     * 
     * 
     *   Note that subclasses of CanvasItem may use a different AutoChild name than
     *   just "canvas". For example, SliderItem uses "slider", and in that case, you need
     *   to use the specific APIs provided by the subclass.
     * 
     *   Note that Canvas.canvasItem will be set on the canvas to point back to this
     *   item.
     *  @type {Canvas}
     *  @default null
     */
    open var canvas: Canvas = definedExternally
    /**
     *  If CanvasItem.canvas is not specified as a canvas instance at init
     *   time, a canvas will be created instead. This property denotes the class of that widget
     *   (Should be set to the name of a subclass of Canvas).
     *  @type {string}
     *  @default "Canvas"
     */
    open var canvasConstructor: String = definedExternally
    /**
     *  Default properties for the canvas if this.canvas is not already a canvas instance.
     *  @type {object}
     *  @default "{}"
     */
    open var canvasDefaults: dynamic = definedExternally
    /**
     *  Properties to apply to this canvas on creation if this.canvas is not already a canvas
     *   instance.
     *  @type {object}
     *  @default "{}"
     */
    open var canvasProperties: dynamic = definedExternally
    /**
     *  Should this item's CanvasItem.canvas be automatically destroyed when the item
     *   is destroyed? Form items are destroyed automatically when a call to
     *   DynamicForm.setItems removes them from their parent form, or if their
     *   parent form is destroyed. This property governs whether, when this occurs,
     *   the item's canvas should also be Canvas.destroy.
     * 
     *   This property has no effect for canvases automatically created via the "autoChild" pattern,
     *   using CanvasItem.canvasProperties, CanvasItem.canvasDefaults etc. CanvasItems which create their
     *   canvas in this way will always destroy the canvas when the item is destroyed or on an
     *   explicit CanvasItem.setCanvas call, regardless of this property's value.
     * 
     *   Setting this property to true
     *   is typically appropriate for cases where a custom CanvasItem automatically creates
     *   its canvas as part of its initialization flow, and the canvas will not be re-used outside
     *   the item.
     *   Note that once a canvas has been destroyed it can not be re-used elsewhere within
     *   an application.
     *  @type {boolean}
     *  @default false
     */
    open var autoDestroy: Boolean = definedExternally
    /**
     *  CanvasItems support specifying overflow for the Canvas directly on the item.
     *  @type {Overflow}
     *  @default null
     */
    open var overflow: 
                       /**
                        *  Content that extends beyond the widget's width or height is               displayed.
                        *                 Note: To have the content be sized only by the drawn size of
                        *                 the content set the overflow to be Canvas.VISIBLE and specify
                        *                 a small size, allowing the size to expand to the size required
                        *                 by the content.
                        *                 Leaving the width / height for the widget undefined will use the
                        *                 default value of 100, and setting the size to zero may cause the
                        *                 widget not to draw.
                        *  Content that extends beyond the widget's width or height is               clipped (hidden).
                        *  Horizontal and/or vertical scrollbars are displayed only if               necessary. Content that extends beyond the remaining visible
                        *                 area is clipped.
                        *  Horizontal and vertical scrollbars are always drawn inside the               widget. Content that extends beyond the remaining visible area
                        *                 is clipped, and can be accessed via scrolling.
                        *  Clip horizontally but extend the canvas's clip region               vertically if necessary. Note: only supported for
                        *                 specific widget subclasses.
                        *  Clip vertically but extend the canvas's clip region               horizontally if necessary. Note: only supported
                        *                 for specific widget subclasses.
                        */
                       String /* visible |  hidden |  auto |  scroll |  clip-h |  clip-v */ = definedExternally
    /**
     *  Minimum valid height for this CanvasItem in pixels. Used in calculating the row heights
     *   of the containing DynamicForm if the item has a flexible CanvasItem.height.
     *  @type {Integer}
     *  @default null
     */
    open var minHeight: Number = definedExternally
    /**
     *  Maximum valid height for this CanvasItem in pixels. Used in calculating the row heights
     *   of the containing DynamicForm if the item has a flexible CanvasItem.height.
     *  @type {Integer}
     *  @default null
     */
    open var maxHeight: Number = definedExternally
    /**
     *  Flag to disable the criteria editing overrides described in
     *   CanvasItem.getCriterion
     *   whereby
     *   if this item contains a DynamicForm as its canvas, it will be used to edit nested
     *   AdvancedCriteria automatically.
     * 
     *   This flag is required for cases where a canvasItem contains a DynamicForm, but the form
     *   is not set up to show inner field values of nested objects, and therefore should not
     *   attempt to apply nested advanced criteria directly to the form.
     *  @type {boolean}
     *  @default true
     */
    open var editCriteriaInInnerForm: Boolean = definedExternally
    /**
     *  If FormItem.prompt is specified for this item, should the prompt be applied to the
     *   CanvasItem.canvas for this item?
     *  @type {boolean}
     *  @default true
     */
    open var applyPromptToCanvas: Boolean = definedExternally
    /**
     *  This text is shown as a tooltip prompt when the cursor hovers over this item.
     *   When item is FormItem.setCanEdit a different hover can be shown with
     *   FormItem.readOnlyHover.
     *  @type {HTMLString}
     *  @default null
     */
    override var prompt: String = definedExternally
    /**
     *   Store (and optionally show) a value for this form item.
     * 
     *   This method will fire standard FormItem.change and
     *   DynamicForm.itemChanged handlers, and store the value passed in such that
     *   subsequent calls to FormItem.getValue or DynamicForm.getValue will
     *   return the new value for this item.
     * 
     *   This method is intended to provide a way for custom formItems - most commonly
     *   CanvasItem - to provide a new interface to the user, allowing them
     *   to manipulate the item's value, for example in an embedded CanvasItem.canvas,
     *   or a pop-up dialog launched from an FormItemIcon, etc. Developers
     *   should call this method when the user interacts with this custom
     *   interface in order to store the changed value.
     * 
     *   CanvasItem.shouldSaveValue for CanvasItems is
     *   false by default. Custom CanvasItems will need to override shouldSaveValue
     *   to true if the values stored via this API should be included in the form's
     *   DynamicForm.getValues and saved with the form when
     *   DynamicForm.saveData is called.
     * 
     *   If you cannot easily detect interactions that should change the value as the
     *   user performs them, a workaround is to call
     *   storeValue right before the form saves.
     * 
     *   Note that this method is not designed for customizing a value which is already being
     *   saved by a standard user interaction. For example you should not call this method
     *   from a FormItem.change. Other APIs such as
     *   FormItem.transformInput exist for this.
     * 
     * 
     *  @param {any} value to save for this item
     *  @param {boolean=} Should the formItem be updated to display the new value?
     */
    override fun storeValue(value: dynamic, showValue: Boolean?): Unit = definedExternally
    /**
     *   This method will place an entry for the CanvasItem.canvas under this item in the
     *   TabIndexManager. This ensures the user can tab into the canvas (and its
     *   descendants) in the expected position within this item's DynamicForm.
     * 
     *   See also Canvas.updateChildTabPositions.
     * 
     * 
     */
    open fun updateCanvasTabPosition(): Unit = definedExternally
    /**
     *   Setter to update the CanvasItem.canvas at runtime
     * 
     *  @param {Canvas} New canvas to display.
     */
    open fun setCanvas(canvas: Canvas): Unit = definedExternally
    /**
     *   Notification method called when the FormItem.canEdit setting is modified.
     *   Developers may make use of this to toggle between an editable and a read-only appearance
     *   of the CanvasItem.canvas.
     * 
     *   The default behavior is:
     * 
     * 
     *  - If canvas is a DynamicForm, the form's DynamicForm.canEdit
     *   setting is set to canEdit.
     * 
     *  - CanvasItem.shouldDisableCanvas is called to determine if the canvas should
     *   be disabled.
     * 
     * 
     *   Standard CanvasItem-based form items may customize the default behavior.
     *   For example, a MultiComboBoxItem will hide its MultiComboBoxItem.comboForm
     *   if the FormItem.readOnlyDisplay is
     *   "readOnly" or "static"
     * 
     *   and also disable the buttons when made read-only.
     * 
     *  @param {boolean} New canEdit value
     */
    open fun canEditChanged(canEdit: Boolean): Boolean = definedExternally
    /**
     *   Notification method called when the FormItem.readOnlyDisplay setting
     *   is modified. Developers may make use of this to toggle between an editable and a read-only
     *   appearance of the CanvasItem.canvas.
     * 
     *   The default behavior is: when the canvas is a DynamicForm, the form's
     *   DynamicForm.readOnlyDisplay setting is set to appearance.
     * 
     *   Standard CanvasItem-based form items may customize the default behavior.
     * 
     *  @param {ReadOnlyDisplayAppearance} new readOnlyDisplay value
     */
    open fun readOnlyDisplayChanged(appearance: 
                                                /**
                                                 *  Item value should appear within the form as a static block of text, similar to the default appearance of a StaticTextItem. This appearance may be
                                                 *   modified via FormItem.readOnlyTextBoxStyle and FormItem.clipStaticValue.
                                                 *  Item should appear unchanged, but user interaction to edit the item will be disallowed. Note that some interactions will be allowed, such as selecting text
                                                 *   within a read-only TextItem for copy and paste. Exact implementation may vary by
                                                 *   form item type.
                                                 *  Item will appear disabled.
                                                 */
                                                String /* static |  readOnly |  disabled */): Boolean = definedExternally
    /**
     *   Method called to determine whether the CanvasItem.canvas should be
     *   Canvas.setDisabled when this CanvasItem is disabled
     *   or its CanvasItem.canEditChanged.
     *   By default, if the canvas is a DynamicForm, then it is disabled if
     *   and only if this CanvasItem is disabled; otherwise, the canvas
     *   is disabled if and only if this CanvasItem is disabled or
     *   FormItem.getCanEdit.
     * 
     *   This method may be overridden to customize the default return value.
     * 
     */
    open fun shouldDisableCanvas(): Boolean = definedExternally
    /**
     *   Does this CanvasItem have keyboard focus.
     * 
     *   This method will return true if this item's canvas, or any of its descendents, has
     *   keyboard focus
     * 
     */
    override fun isFocused(): Boolean = definedExternally
    /**
     *   Overridden to return true if CanvasItem.canvas is a dynamicForm.
     *   See CanvasItem.getCriterion
     * 
     *   for details of editing advanced criteria using nested
     *   dynamicForms.
     * 
     */
    override fun hasAdvancedCriteria(): Boolean = definedExternally
    /**
     *   AdvancedCriteria objects may be edited via nested dynamicForms as described in
     *   CanvasItem.getCriterion
     * 
     *   This method has been overridden to return true if this item's canvas is a DynamicForm,
     *   where the DynamicForm.operator matches the operator of the criterion passed in
     *   and dynamicForm contains items where FormItem.canEditCriterion returns true
     *   for each sub-criterion in the object passed in.
     * 
     *  @param {Criterion} criteria to test
     */
    override fun canEditCriterion(criterion: Criterion): Boolean = definedExternally
    /**
     *   The standard formItem criteria editing APIs have been overridden in the canvasItem class
     *   to simplify the editing of complex AdvancedCriteria objects using nested
     *   DynamicForms.
     * 
     *   The following pattern is supported without need for further modification:
     *   A complex Advanced criteria object may have nested sub criteria using the "and"
     *   or "or" operators. For example:
     * 
     *   { _constructor:"AdvancedCriteria",
     *    operator:"and",
     *    criteria:[
     *     {fieldName:"field1", value:"value1", operator:"iContains"},
     *     {operator:"or", criteria:[
     *       {fieldName:"innerField1", value:"value1", operator:"equals"},
     *       {fieldName:"innerField2", value:"value2", operator:"iContains"}
     *      ]
     *     }
     *    ]
     *   }
     * 
     *   To create a form capable of editing the above criteria without providing custom overrides
     *   to FormItem.getCriterion et al, you would create a form with 2 items.
     *   The 'field1' criterion could be edited by a simple form item such as a TextItem.
     *   The nested criteria ('innerField1' and 'innerField2') could be edited by a canvasItem
     *   whose canvas property was set to a DynamicForm showing items capable of editing the 2
     *   inner criteria, and whose operator was specified as "or".
     *   For example:
     * 
     *   isc.DynamicForm.create({
     *     items:[
     *       {name:"field1", type:"TextItem"},
     *       {name:"nestedItem", shouldSaveValue:true, type:"CanvasItem",
     *         canvas:isc.DynamicForm.create({
     *           operator:"or",
     *           items:[
     *             {name:"innerField1", type:"TextItem", operator:"equals"},
     *             {name:"innerField2", type:"TextItem"}
     *           ]
     *         })
     *       }
     *     ]
     *   });
     * 
     *   This form would be able to edit the above advanced criteria object via
     *   DynamicForm.setValuesAsCriteria. Edited values would be retrieved via
     *   DynamicForm.getValuesAsCriteria.
     * 
     *   Note that the canvas item has shouldSaveValue set to true - this is required
     *   to ensure the nested form is actually passed the values to edit.
     * 
     *   The default implementation of this method checks for this.canvas being specified as a
     *   dynamicForm, and in that case simply returns the result of
     *   DynamicForm.getValuesAsAdvancedCriteria on the inner form.
     * 
     *   Note that this functionality may be entirely bypassed by
     *   setting CanvasItem.editCriteriaInInnerForm to false. This flag is useful when defining a
     *   dynamicForm based canvasItem which is not intended for editing nested data -- for example
     *   if a standard atomic field value is being displayed in some custom way using a
     *   DynamicForm embedded in the item.
     * 
     * 
     */
    open fun getCriterion(): Criterion = definedExternally
    /**
     *   Display a Criterion object in this item for editing. Overridden from
     *   FormItem.setCriterion in order to support editing nested criteria using
     *   nested dynamicForms as described in CanvasItem.getCriterion.
     * 
     *   Implementation checks for this.canvas being specified as a DynamicForm, and applies
     *   criterion directly to the embedded form via setValuesAsCriteria()
     * 
     *  @param {Criterion} criteria to edit
     */
    override fun setCriterion(criterion: Criterion): Unit = definedExternally
    /**
     *   Set the FormItem.prompt for this item. Default implementation will also apply the
     *   prompt to CanvasItem.canvas if CanvasItem.applyPromptToCanvas is true.
     * 
     *  @param {HTMLString} new prompt for the item.
     */
    override fun setPrompt(newPrompt: String): Unit = definedExternally
    /**
     *   This method allows dynamic creation of a CanvasItem's canvas, rather than
     *   setting CanvasItem.canvas statically.
     *   If specified this stringMethods will be called when the form item is
     *   initialized and should return the Canvas to display for this item.
     * 
     *  @param {DynamicForm} the dynamicForm in which this item is contained
     *  @param {CanvasItem} the live form item instance
     */
    open fun createCanvas(form: DynamicForm, item: CanvasItem): Canvas = definedExternally
    /**
     *   This method will be called whenever this FormItem's value is being set via a programmatic
     *   call to e.g: DynamicForm.setValues or FormItem.setValue and may be
     *   overridden by CanvasItems intended to support displaying data values to update the
     *   embedded Canvas to reflect the value passed in. Note that the first parameter will be a
     *   formatted value - while the second parameter will contain the underlying data value for
     *   the item.
     * 
     *  @param {any} new display value for the item. This is the value after applying  any custom formatter or valueMap
     *  @param {any} underlying data value for the item
     *  @param {DynamicForm} the dynamicForm in which this item is contained
     *  @param {CanvasItem} the live form item instance
     */
    open fun showValue(displayValue: dynamic, dataValue: dynamic, form: DynamicForm, item: CanvasItem): Unit = definedExternally
    companion object {
        /**
         *  Creates a new CanvasItem
         * 
         *  @param typeCheckedProperties {Partial<CanvasItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {CanvasItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): CanvasItem = definedExternally
    }
}