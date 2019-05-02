@file:JsQualifier("isc")
package isc

/**
 *  An object containing details for mouse events occurring over a FormItem.
 */
open external class FormItemEventInfo {
    /**
     *  Item over which the event occurred.
     *  @type {FormItem}
     *  @default null
     */
    open var item: FormItem = definedExternally
    /**
     *  True if the event occurred within the item's FormItem.textBoxStyle.
     *  @type {boolean}
     *  @default null
     */
    open var overTextBox: Boolean = definedExternally
    /**
     *  True if the event occurred over the item's data or input element. Note that it can be bad
     *   practice to implement custom context menus when overElement is true, since this will
     *   replace browser-default menus that users might expect.
     *  @type {boolean}
     *  @default null
     */
    open var overElement: Boolean = definedExternally
    /**
     *  True if the event occurred over the main body of the item (for example the text-box), rather
     *   than over the title or within the form item's cell in the DynamicForm but outside the
     *   text box area.
     *  @type {boolean}
     *  @default null
     */
    open var overItem: Boolean = definedExternally
    /**
     *  True if the event occurred over the item's title.
     *  @type {boolean}
     *  @default null
     */
    open var overTitle: Boolean = definedExternally
    /**
     *  True if the event occurred over the form's
     *   DynamicForm.errorItemProperties.
     *  @type {boolean}
     *  @default null
     */
    open var overInlineError: Boolean = definedExternally
    /**
     *  If this event occurred over a formItemIcon this attribute contains the
     *   FormItemIcon.name for the icon.
     *  @type {string}
     *  @default null
     */
    open var icon: String = definedExternally
}