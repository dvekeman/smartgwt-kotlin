@file:JsQualifier("isc")
package isc

/**
 *  Dialog shown for editing properties of HTML lists in a RichTextEditor. Contains a
 *   ListPropertiesPane.
 * 
 *   Cannot be directly used; shown in documentation only for skinning purposes.
 */
open external class ListPropertiesDialog : Window {
    /**
     *  The title of this ListPropertiesDialog.
     *  @type {string}
     *  @default "List Properties"
     */
    override var title: String = definedExternally
    /**
     *  The ListPropertiesPane contained by this ListPropertiesDialog.
     *  @type {ListPropertiesPane}
     *  @default null
     */
    open var listPropertiesPane: ListPropertiesPane = definedExternally
    /**
     *  The title of the ListPropertiesDialog.applyButton.
     *  @type {string}
     *  @default "Apply"
     */
    open var applyButtonTitle: String = definedExternally
    /**
     *  The Apply button. When clicked, the ListPropertiesDialog.applyClick
     *   event is fired.
     * 
     *   ListPropertiesDialog.applyButtonTitle is a autoChildUsage
     *   for the button's Button.title.
     *  @type {IButton}
     *  @default null
     */
    open var applyButton: IButton = definedExternally
    /**
     *  The title of the ListPropertiesDialog.cancelButton.
     *  @type {string}
     *  @default "Cancel"
     */
    open var cancelButtonTitle: String = definedExternally
    /**
     *  The Cancel button. When clicked, the ListPropertiesDialog.cancelClick
     *   event is fired.
     * 
     *   ListPropertiesDialog.cancelButtonTitle is a autoChildUsage
     *   for the button's Button.title.
     *  @type {IButton}
     *  @default null
     */
    open var cancelButton: IButton = definedExternally
    /**
     *   Notification method fired when the ListPropertiesDialog.applyButton
     *   is clicked.
     * 
     *  @param {ListProperties} the list properties to apply
     */
    open fun applyClick(listProperties: ListProperties): Unit = definedExternally
    /**
     *   Notification method fired when the ListPropertiesDialog.cancelButton
     *   is clicked.
     * 
     */
    open fun cancelClick(): Unit = definedExternally
    companion object {
        /**
         *  Creates a new ListPropertiesDialog
         * 
         *  @param typeCheckedProperties {Partial<ListPropertiesDialog>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ListPropertiesDialog} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ListPropertiesDialog = definedExternally
    }
}