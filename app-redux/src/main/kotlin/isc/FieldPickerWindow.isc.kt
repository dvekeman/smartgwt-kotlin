@file:JsQualifier("isc")
package isc

/**
 *  A dialog for picking fields to display from among the available fields.
 * 
 *   This is typically useful in scenarios where there are many more fields than can reasonably
 *   fit on screen. The application can start off displaying a few of the fields by default (such
 *   as the most commonly-needed fields), and show a FieldPickerWindow to allow the user to
 *   customize which fields to display as well as the order in which to display them.
 */
open external class FieldPickerWindow : Window {
    /**
     *  @type {string}
     *  @default "Field Picker"
     */
    override var title: String = definedExternally
    /**
     *  By default, a FieldPickerWindow will close automatically if the mouse is clicked outside
     *   of it. To have the window shown with true modality, set this attribute to false.
     *  @type {boolean}
     *  @default true
     */
    open var autoDismiss: Boolean = definedExternally
    /**
     *  A FieldPicker for altering the working field-set in a
     *   DataBoundComponent.
     *  @type {FieldPicker}
     *  @default null
     */
    open var fieldPicker: FieldPicker = definedExternally
    companion object {
        /**
         *  Creates a new FieldPickerWindow
         * 
         *  @param typeCheckedProperties {Partial<FieldPickerWindow>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {FieldPickerWindow} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): FieldPickerWindow = definedExternally
    }
}