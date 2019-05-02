@file:JsQualifier("isc")
package isc

/**
 *  A FormItem for use with the FilterBuilder, allows the user to pick from a set of
 *   pre-configured search criteria such as specific ranges in numeric or date data, and provide
 *   user friendly titles for such criteria, such as "within the next two weeks" or
 *   "High (0.75 - 0.99)".
 */
open external class PresetCriteriaItem : SelectItem {
    /**
     *  This attribute is not applicable to the PresetCriteriaItem. See
     *   PresetCriteriaItem.options instead.
     *  @type {object}
     *  @default null
     */
    override var valueMap: dynamic = definedExternally
    /**
     *  An object whose properties are user-visible titles for the preset ranges, and whose
     *   values are Criteria / AdvancedCriteria objects representing the criteria to be used if
     *   the user selects that choice.
     *  @type {object}
     *  @default null
     */
    open var options: dynamic = definedExternally
    /**
     *  If set, an additional option will be shown with the title PresetCriteriaItem.customOptionTitle,
     *   which will cause PresetCriteriaItem.getCustomCriteria to be called.
     *  @type {boolean}
     *  @default false
     */
    open var showCustomOption: Boolean = definedExternally
    /**
     *  The title to show for the PresetCriteriaItem.showCustomOption.
     *  @type {string}
     *  @default "Custom..."
     */
    open var customOptionTitle: String = definedExternally
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
     *   This method is called when PresetCriteriaItem.showCustomOption is true and the user selects the
     *   custom option. Implement this method by allowing the user to enter custom criteria, for
     *   example, by opening a modal dialog. Once the user has input customer criteria, fire the
     *   callback method with the resulting criteria.
     * 
     * 
     *  @param {Callback} callback to fire when custom criteria has been gathered.       Expects parameters "criteria,title". The "title" will be displayed as the        currently selected value when custom criteria have been chosen.
     */
    open fun getCustomCriteria(callback: dynamic): Unit = definedExternally
    /**
     *   Get the criterion based on the value selected by the user.
     * 
     * 
     */
    open fun getCriterion(): dynamic = definedExternally
    companion object {
        /**
         *  Creates a new PresetCriteriaItem
         * 
         *  @param typeCheckedProperties {Partial<PresetCriteriaItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {PresetCriteriaItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): PresetCriteriaItem = definedExternally
    }
}