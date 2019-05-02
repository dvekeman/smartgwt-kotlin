@file:JsQualifier("isc")
package isc

/**
 *  FormItem that shows a list of options, plus an "Other..." option that allows them to enter
 *   another value.
 */
open external class SelectOtherItem : Class {
    /**
     *  Title for the separator between normal items and the Other... item in the drop
     *   down list. Selecting this item will not change the FormItem's value.
     *  @type {string}
     *  @default "--------------------"
     */
    open var separatorTitle: String = definedExternally
    /**
     *  Value for the separator item between normal items and the Other... value.
     *   If necessary the value may be changed to ensure it doesn't collide with any data values in
     *   this item's FormItem.valueMap.
     *  @type {string}
     *  @default "----"
     */
    open var separatorValue: String = definedExternally
    /**
     *  Title for the Other... item. When this item is selected, the user will be
     *   shown a prompt allowing them to enter a new value for the item.
     *  @type {string}
     *  @default "Other..."
     */
    open var otherTitle: String = definedExternally
    /**
     *  Data value for the Other... item. If necessary this value may be changed to
     *   ensure it doesn't collide with any data values in this item's
     *   FormItem.valueMap.
     *  @type {string}
     *  @default "\*\*\*other\*\*\*"
     */
    open var otherValue: String = definedExternally
    /**
     *  Title to show in prompt for "other" value.
     *   Note this is a dynamic string. JavaScript content is supported within &#36;{...}
     *   tags, with local variables for item (a pointer to this item) and
     *   value a pointer to the currently selected item value.
     *  @type {HTMLString}
     *  @default "Other value for &lt;br&gt;${item.getTitle()}?"
     */
    open var selectOtherPrompt: String = definedExternally
    /**
     *  Width for the "other value" prompt dialog.
     *  @type {Integer}
     *  @default "250"
     */
    open var dialogWidth: Number = definedExternally
    companion object {
        /**
         *  Creates a new SelectOtherItem
         * 
         *  @param typeCheckedProperties {Partial<SelectOtherItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {SelectOtherItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): SelectOtherItem = definedExternally
    }
}