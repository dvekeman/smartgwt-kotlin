@file:JsQualifier("isc")
package isc

/**
 *  Dialogs are a specialized version of Window used for small windows that contain just
 *   a text message or a text mesage with some standard buttons.
 * 
 *   Many typical modal dialogs such as alerts and confirmations are built into the system with
 *   convenience APIs - see isc.say, isc.warn and
 *   isc.askForValue.
 * 
 *   Dialogs can be modal or non-modal according to Window.isModal.
 * 
 *   NOTE: If you are building a dialog that will involve more than just buttons and a message,
 *   consider starting from the Window class instead, where arbitrary components can be
 *   added to the body area via Window.addItem.
 * 
 *   This is an example of creating a custom dialog:
 * 
 * 
 *   isc.Dialog.create({
 *     message : "Please choose whether to proceed",
 *     icon:"[SKIN]ask.png",
 *     buttons : [
 *       isc.Button.create({ title:"OK" }),
 *       isc.Button.create({ title:"Cancel" })
 *     ],
 *     buttonClick : function (button, index) {
 *       this.hide();
 *     }
 *   });
 * 
 * 
 * 
 */
open external class Dialog : Window {
    /**
     *  @type {Integer}
     *  @default "360"
     */
    override var defaultWidth: Number = definedExternally
    /**
     *  Style of the Dialog background
     *  @type {CSSStyleName}
     *  @default "dialogBackground"
     */
    override var styleName: String = definedExternally
    /**
     *  Message to show in this dialog.
     * 
     *   If a message is set the primary purpose of the dialog will be assumed to be to show a message with
     *   buttons - auto-sizing to the message text will be enabled, and, if Dialog.icon has also
     *   been set, the Dialog.messageLabel and Dialog.messageIcon
     *   AutoChildren will be created and placed together in the Dialog.messageStack
     *   AutoChild, with the toolbar underneath as usual. If any of these behaviors are inconvenient or
     *   you want more precise control over a message and some custom widgets, start from the superclass
     *   Window instead, and add controls via Window.addItem.
     * 
     *   The message string may contain "${loadingImage}", if so, the standard loading spinner will appear at
     *   that location in the text (see Canvas.loadingImageSrc).
     * 
     *   The message will be styled with the Dialog.messageStyle.
     *  @type {HTMLString}
     *  @default null
     */
    open var message: String = definedExternally
    /**
     *  Style to apply to the message text shown in the center of the dialog
     *  @type {CSSStyleName}
     *  @default "normal"
     */
    open var messageStyle: String = definedExternally
    /**
     *  AutoChild that shows Dialog.message.
     *  @type {Label}
     *  @default null
     */
    open var messageLabel: Label = definedExternally
    /**
     *  AutoChild that shows Dialog.icon.
     *  @type {Img}
     *  @default null
     */
    open var messageIcon: Img = definedExternally
    /**
     *  AutoChild that combines Dialog.message and Dialog.icon.
     *  @type {Layout}
     *  @default null
     */
    open var messageStack: Layout = definedExternally
    /**
     *  Icon to show in this dialog - see Dialog.message.
     *  @type {SCImgURL}
     *  @default null
     */
    open var icon: String = definedExternally
    /**
     *  Size of the icon to show in this dialog.
     *  @type {Integer}
     *  @default "32"
     */
    open var iconSize: Number = definedExternally
    /**
     *  Whether to show a toolbar of buttons at the bottom of the Dialog.
     *   Default of null will cause the value to be resolved automatically to true or
     *   false when the Dialog is first drawn according as Dialog.toolbarButtons
     *   contains buttons or not.
     *  @type {boolean}
     *  @default null
     */
    open var showToolbar: Boolean = definedExternally
    /**
     *  If a toolbar is showing, automatically place keyboard focus in the first button.
     *  @type {boolean}
     *  @default true
     */
    open var autoFocus: Boolean = definedExternally
    /**
     *  AutoChild of type Toolbar used to create the Dialog.toolbarButtons.
     *  @type {Toolbar}
     *  @default null
     */
    open var toolbar: Toolbar = definedExternally
    /**
     *  Array of Buttons to show in the Dialog.showToolbar, if shown.
     * 
     *   The set of buttons to use is typically set by calling one of the shortcuts such as
     *   isc.say or isc.confirm. A custom set of
     *   buttons can be passed to these shortcuts methods via the "properties" argument, or to a
     *   directly created Dialog.
     * 
     *   In both cases, a mixture of DialogButtons, custom buttons,
     *   and other components (such as a LayoutSpacer) can be passed.
     * 
     *   Built-in buttons can be referred to as isc.Dialog.OK, for example:
     * 
     *   isc.Dialog.create({
     *    buttons:[
     *      isc.Dialog.OK,
     *      isc.Dialog.CANCEL,
     *      isc.LayoutSpacer.create({width:50}),
     *      { title:"Not now", click:"doSomething()" }
     *    ]
     *   })
     * 
     *   Built-in buttons will call standard methods on the Dialog itself, such as
     *   Dialog.cancelClick, as explained in the
     *   DialogButtons.
     * 
     * 
     *  @type {Array<Partial<Button>> | Array<Partial<Button>>}
     *  @default null
     */
    open var buttons: Array<dynamic> = definedExternally
    /**
     *  This is a synonym for Dialog.buttons
     *  @type {Array<Partial<Button>> | Array<Partial<Button>>}
     *  @default null
     */
    open var toolbarButtons: Array<dynamic> = definedExternally
    /**
     *  Icon to show in the isc.ask
     *   dialog.
     *  @type {SCImgURL}
     *  @default "[SKIN]ask.png"
     */
    open var askIcon: String = definedExternally
    /**
     *  Icon to show in the isc.say
     *   dialog.
     *  @type {SCImgURL}
     *  @default "[SKIN]say.png"
     */
    open var sayIcon: String = definedExternally
    /**
     *  Icon to show in the isc.warn
     *   dialog.
     *  @type {SCImgURL}
     *  @default "[SKIN]warn.png"
     */
    open var warnIcon: String = definedExternally
    /**
     *  Icon to show in the isc.confirm
     *   dialog.
     *  @type {SCImgURL}
     *  @default "[SKIN]confirm.png"
     */
    open var confirmIcon: String = definedExternally
    /**
     *   Set the buttons for the toolbar displayed in this dialog.
     *   Synonym for Dialog.setToolbarButtons
     * 
     *  @param {Array<Partial<Button>> | Array<Partial<Button>>} [null] buttons for the toolbar
     */
    open fun setButtons(newButtons: Array<dynamic>): Unit = definedExternally
    /**
     *   Set the Dialog.toolbarButtons for this dialog.
     *   Synonym for Dialog.setButtons.
     * 
     *  @param {Array<Partial<Button>> | Array<Partial<Button>>} [null] buttons for the toolbar
     */
    open fun setToolbarButtons(newButtons: Array<dynamic>): Unit = definedExternally
    /**
     *   Method to save this Dialog's data. Called from okClick(),
     *   applyClick().
     *   No default implementation - override to perform some action if required.
     * 
     * 
     */
    open fun saveData(): Unit = definedExternally
    /**
     *   Handles a click on the close button of this window. The default implementation
     *   calls Window.close and returns false to prevent bubbling of the click event.
     * 
     *   Override this method if you want
     *   other actions to be taken.
     * 
     *   Custom implementations may call close() to trigger the default behavior.
     * 
     */
    override fun closeClick(): Boolean = definedExternally
    /**
     *   Handle a click on the 'cancel' button of this Dialog.
     *   Default implementation is to return null and hide the Dialog.
     *   Override to do something else.
     * 
     */
    open fun cancelClick(): Unit = definedExternally
    /**
     *   Handle a click on the 'ok' button of this Dialog.
     *   Default implementation is to call saveData(), hide the Dialog, then return
     *   true.
     *   Override to do something else.
     * 
     */
    open fun okClick(): Unit = definedExternally
    /**
     *   Handle a click on the 'apply' button of this Dialog.
     *   Default implementation is to call saveData(), but NOT close the Dialog.
     * 
     */
    open fun applyClick(): Unit = definedExternally
    /**
     *   Handle a click on the 'yes' button of this Dialog.
     *   Default implementation is to return true.
     *   Override to do something else
     * 
     */
    open fun yesClick(): Unit = definedExternally
    /**
     *   Handle a click on the 'no' button of this Dialog.
     *   Default implementation is to return false.
     *   Override to do something else.
     * 
     */
    open fun noClick(): Unit = definedExternally
    /**
     *   Handle a click on the 'done' button of this Dialog.
     *   Default implementation is to hide the dialog then return true.
     *   Override to do something else.
     * 
     */
    open fun doneClick(): Unit = definedExternally
    companion object {
        /**
         *  Title for the "OK" button.
         *  @type {HTMLString}
         *  @default "OK"
         */
        var OK_BUTTON_TITLE: String = definedExternally
        /**
         *  Title for the "Apply" button.
         *  @type {HTMLString}
         *  @default "Apply"
         */
        var APPLY_BUTTON_TITLE: String = definedExternally
        /**
         *  Title for the "Yes" button.
         *  @type {HTMLString}
         *  @default "Yes"
         */
        var YES_BUTTON_TITLE: String = definedExternally
        /**
         *  Title for the "No" button.
         *  @type {HTMLString}
         *  @default "No"
         */
        var NO_BUTTON_TITLE: String = definedExternally
        /**
         *  Title for the "Cancel" button.
         *  @type {HTMLString}
         *  @default "Cancel"
         */
        var CANCEL_BUTTON_TITLE: String = definedExternally
        /**
         *  Title for the "Done" button.
         *  @type {HTMLString}
         *  @default "Done"
         */
        var DONE_BUTTON_TITLE: String = definedExternally
        /**
         *  Default title for the dialog displayed in response to the isc.confirm method.
         *   Note that a custom title can be specified as the title attribute of the
         *   properties parameter passed to that method.
         *  @type {HTMLString}
         *  @default "Confirm"
         */
        var CONFIRM_TITLE: String = definedExternally
        /**
         *  Default title for the dialog displayed in response to the isc.say method.
         *   Note that a custom title can be specified as the title attribute of the
         *   properties parameter passed to that method.
         *  @type {HTMLString}
         *  @default "Note"
         */
        var SAY_TITLE: String = definedExternally
        /**
         *  Default title for the dialog displayed in response to the isc.warn method.
         *   Note that a custom title can be specified as the title attribute of the
         *   properties parameter passed to that method.
         *  @type {HTMLString}
         *  @default "Warning"
         */
        var WARN_TITLE: String = definedExternally
        /**
         *  Default title for the dialog displayed in response to the isc.ask method.
         *   Note that a custom title can be specified as the title attribute of the
         *   properties parameter passed to that method.
         *  @type {HTMLString}
         *  @default "Question"
         */
        var ASK_TITLE: String = definedExternally
        /**
         *  Default title for the dialog displayed by isc.askForValue.
         *   A custom title can alternatively be specified as the title attribute of the
         *   properties parameter passed to that method.
         *  @type {HTMLString}
         *  @default "Please enter a value"
         */
        var ASK_FOR_VALUE_TITLE: String = definedExternally
        /**
         *  The "Prompt" object on the dialog class is a singleton Dialog instance.
         *   The Prompt is used to show text to the user in a modal fashion - it will expand to show
         *   all the text that you put into it.
         *   By default this Dialog has no end-user controls and is expected to be programmatically
         *   dismissed.
         *   Common use-case: During server-interactions, the Prompt will be used to display a suitable
         *   wait message, and suppress user input.
         * 
         *   Notes:
         *   Because this is a singleton object, properties set on the Prompt directly will persist each
         *   time it is shown.
         *   Developers should use the showPrompt() and clearPrompt() methods
         *   to show and hide the prompt rather than manipulating the prompt directly.
         *  @type {Dialog}
         *  @default "dialog instance properties"
         */
        var Prompt: Dialog = definedExternally
        /**
         *  A singleton Dialog instance that will show text to the user and provide buttons for their
         *   response. The Dialog will expand to show all the text that you put into it. This dialog
         *   is shown in response to calls to isc.say,
         *   isc.warn, isc.ask and
         *   isc.confirm.
         * 
         *   This can be used in cases where a developer would alternatively make use of the native
         *   JavaScript alert() and confirm() methods. The main differences
         *   between those methods and using the Warn object are:
         *   - The Warn object can be customized by modifying which buttons are visible, the style
         *    applied to it, etc.
         *   - The isc.ask() and isc.warn() methods are asynchronous - rather
         *    than returning a value indicating the user's response, a callback method will be fired
         *    when the user interacts with the dialog.
         * 
         *   Notes:
         *   Because this is a singleton object, properties set on the Warn object directly will persist
         *   each time it is shown.
         *   Developers should use the warn() or ask() methods to show and
         *   hide this object rather than manipulating the Dialog directly.
         *  @type {Dialog}
         *  @default "dialog instance properties"
         */
        var Warn: Dialog = definedExternally
        /**
         *  A singleton Dialog instance that will be shown in response to a isc.askForValue call.
         * 
         *   Notes:
         *   Because this is a singleton object, properties set on the Ask object directly will persist
         *   each time it is shown.
         *   Developers should use the askForValue() method to show this object rather than
         *   manipulating the Dialog directly.
         *  @type {Dialog}
         *  @default "dialog instance properties"
         */
        var Ask: Dialog = definedExternally
        /**
         *  Creates a new Dialog
         * 
         *  @param typeCheckedProperties {Partial<Dialog>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Dialog} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Dialog = definedExternally
    }
}