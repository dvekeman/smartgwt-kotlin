@file:JsQualifier("isc")
package isc

/**
 *  HiddenItems track a value but have no visible appearance and do not take up space in the form
 *   layout.
 * 
 *   When using SmartClient databinding it is usually not necessary to use a HiddenItem, since
 *   the DynamicForm will track values for which no actual form control exists, and will submit
 *   these 'extra' values when DynamicForm.saveData is called. HiddenItems only apply
 *   to forms that are submitted like ordinary HTML forms, via the
 *   DynamicForm.submitForm method.
 */
open external class HiddenItem : FormItem {
    /**
     *  we never show a separate title cell for hidden fields
     *  @type {boolean}
     *  @default false
     */
    override var showTitle: Boolean = definedExternally
    /**
     *  hidden fields don't take up any columns
     *  @type {Integer | string}
     *  @default "0"
     */
    override var colSpan: dynamic = definedExternally
    /**
     *  hidden fields don't take up any rows
     *  @type {number}
     *  @default "0"
     */
    override var rowSpan: Number = definedExternally
    /**
     *  If this form item has a specified FormItem.optionDataSource, should the
     *   item ever perform a fetch against this dataSource to retrieve the related record.
     * 
     *   This is disabled by default for hiddenItems as there is typically no need to
     *   perform a fetch and retrieve a display-field value to show the user for a
     *   hidden item. This does mean that if a developer needs access to the related record
     *   for a hidden-item's value, they will need to enable both this setting and
     *   FormItem.alwaysFetchMissingValues.
     *  @type {boolean}
     *  @default true
     */
    override var fetchMissingValues: Boolean = definedExternally
    /**
     *  If this form item has a specified FormItem.optionDataSource and
     *   FormItem.fetchMissingValues is true, when the item value changes, a fetch will be
     *   performed against the optionDataSource to retrieve the related record
     *   if FormItem.displayField is specified and the new item value is not present in any
     *   valueMap explicitly specified on the item.
     * 
     *   Setting this property to true means that a fetch will occur against the optionDataSource
     *   to retrieve the related record even if FormItem.displayField is unset, or the
     *   item has a valueMap which explicitly contains this field's value.
     * 
     *   An example of a use case where this might be set would be if FormItem.formatValue
     *   or FormItem.formatEditorValue were written to display properties from the
     *   FormItem.getSelectedRecord.
     * 
     *   Note - for efficiency we cache the associated record once a fetch has been performed, meaning
     *   if the value changes, then reverts to a previously seen value, we do not kick
     *   off an additional fetch even if this property is true. If necessary this cache may be
     *   explicitly invalidated via a call to FormItem.invalidateDisplayValueCache
     * 
     *   Note: For hiddenItem HiddenItem.fetchMissingValues is defaulted
     *   to false so developers wishing to get access to the record related to
     *   the current hiddenItem value would need to explicitly set both that property, and this
     *   one to true.
     *  @type {boolean}
     *  @default false
     */
    override var alwaysFetchMissingValues: Boolean = definedExternally
    companion object {
        /**
         *  Creates a new HiddenItem
         * 
         *  @param typeCheckedProperties {Partial<HiddenItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {HiddenItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): HiddenItem = definedExternally
    }
}