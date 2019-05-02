@file:JsQualifier("isc")
package isc

/**
 *  A SearchForm is a DynamicForm specialized for a user to enter search criteria.
 * 
 *   All DynamicForm properties and methods work on SearchForm. SearchForm extends and
 *   specializes DynamicForm for searching; for example, SearchForm sets
 *   hiliteRequiredFields false by default because fields are typically not
 *   required in a search.
 */
open external class SearchForm : DynamicForm {
    /**
     *  This property is overridden in SearchForm to allow editing of dataSource fields marked as
     *   canFilter:true by default.
     *  @type {string}
     *  @default "canFilter"
     */
    override var canEditFieldAttribute: String = definedExternally
    /**
     *  For editable fields with a specified FormItem.displayField and
     *   FormItem.optionDataSource, if the user selects a new value (typically from
     *   PickList based item such as a SelectItem), should the selected displayValue be updated
     *   on the record being edited in addition to the value for the actual item.
     *   Note that this only applies for fields using
     *   FormItem.useLocalDisplayFieldValue.
     * 
     *   Overriden to be false for searchForms. It is typically not necessary
     *   to have the display value as well as the data value be included in generated criteria
     *   when a user selects a new value from a field with a specified
     *   FormItem.displayField.
     * 
     *   See DynamicForm.storeDisplayValues for more information on this property.
     *  @type {boolean}
     *  @default false
     */
    override var storeDisplayValues: Boolean = definedExternally
    /**
     *  If this attribute is true any DataSourceField.canFilter fields
     *   specified on the dataSource will not be shown unless explicitly included in this component's
     *   DataBoundComponent.fields
     *  @type {boolean}
     *  @default true
     */
    open var showFilterFieldsOnly: Boolean = definedExternally
    /**
     *   Triggered when a SubmitItem is included in the form is submitted and gets pressed.
     * 
     * 
     *  @param {Criteria} the search criteria from the form
     *  @param {SearchForm} the form being submitted
     */
    open fun search(criteria: dynamic, form: SearchForm): Unit = definedExternally
    companion object {
        /**
         *  Creates a new SearchForm
         * 
         *  @param typeCheckedProperties {Partial<SearchForm>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {SearchForm} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): SearchForm = definedExternally
    }
}