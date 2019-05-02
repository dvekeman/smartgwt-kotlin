@file:JsQualifier("isc")
package isc

/**
 *  Simple modal dialog for collecting a date range from the end user.
 */
open external class DateRangeDialog : Window {
    /**
     *  The title to display in the header-bar of this Dialog.
     *  @type {string}
     *  @default "Select Date Range"
     */
    open var headerTitle: String = definedExternally
    /**
     *  @type {DateRangeItem}
     *  @default null
     */
    open var rangeItem: DateRangeItem = definedExternally
    /**
     *  The title for the "Clear" button on this dialog.
     *  @type {string}
     *  @default "Clear"
     */
    open var clearButtonTitle: String = definedExternally
    /**
     *  Button used for clearing the dialog's values. Note that, since this is an AutoChild,
     *   it can be configured using clearButtonDefaults and clearButtonProperties.
     *  @type {IButton}
     *  @default null
     */
    open var clearButton: IButton = definedExternally
    /**
     *  The title for the "OK" button on this dialog.
     *  @type {string}
     *  @default "OK"
     */
    open var okButtonTitle: String = definedExternally
    /**
     *  Button used for accepting the values entered into the dialog. Note that, since this is an
     *   AutoChild, it can be configured using okButtonDefaults and okButtonProperties.
     *  @type {IButton}
     *  @default null
     */
    open var okButton: IButton = definedExternally
    /**
     *  The title for the "Cancel" button on this dialog.
     *  @type {string}
     *  @default "Cancel"
     */
    open var cancelButtonTitle: String = definedExternally
    /**
     *  Button used for cancelling the dialog. Note that, since this is an AutoChild, it can
     *   be configured using cancelButtonDefaults and cancelButtonProperties.
     *  @type {IButton}
     *  @default null
     */
    open var cancelButton: IButton = definedExternally
    companion object {
        /**
         *  Creates a new DateRangeDialog
         * 
         *  @param typeCheckedProperties {Partial<DateRangeDialog>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DateRangeDialog} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DateRangeDialog = definedExternally
        /**
         *   Helper method to launch a DateRangeDialog to have a date range input by the user.
         * 
         *  @param {boolean} whether to allow relative date entry via                  RelativeDateItems, default true
         *  @param {DateRangeItem} properties for the DateRangeItem
         *  @param {DateRangeDialog} properties for the Window
         *  @param {Callback} method to fire once user has input values, with a single parameter              "criterion" of type Criterion
         */
        fun askForRange(allowRelativeDates: Boolean, rangeItemProperties: DateRangeItem, windowProperties: DateRangeDialog, callback: dynamic): Unit = definedExternally
    }
}