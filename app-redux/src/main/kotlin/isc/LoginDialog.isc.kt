@file:JsQualifier("isc")
package isc

/**
 *  Handle a complete login interaction with a typical login dialog asking for username and
 *   password credentials. Use this
 *   class to quickly present a traditional username/password authentication mechanism in a
 *   SmartClient window.
 * 
 *   To adapt this class to your requirements, first implement LoginDialog.loginFunc to submit
 *   the username and password to the authentication mechanism of your choice, calling
 *   dialogCallback once the authentication process completes.
 */
open external class LoginDialog : Window {
    /**
     *  Whether the user should be able to dismiss the login dialog without entering
     *   credentials. Set to true if logging in is optional. When set, a close button will be
     *   present, and hitting escape will also dismiss the dialog.
     * 
     *   If the Dialog is dismissed, LoginDialog.loginFunc is called with null arguments.
     * 
     *   Note that this attribute overrides the dismissOnEscape and showCloseButton attributes.
     *  @type {boolean}
     *  @default false
     */
    open var dismissable: Boolean = definedExternally
    /**
     *  Do not set LoginDialog.dismissOnEscape; it is controlled by the
     *   LoginDialog.dismissable
     *   property.
     *  @type {boolean}
     *  @default null
     */
    override var dismissOnEscape: Boolean = definedExternally
    /**
     *  Do not set LoginDialog.showCloseButton; it is controlled by the
     *   LoginDialog.dismissable
     *   property.
     *  @type {boolean}
     *  @default true
     */
    override var showCloseButton: Boolean = definedExternally
    /**
     *  If true, the login form will allow blank passwords to be submitted. Otherwise
     *   the form fails to be validated until the user enters at least one character into
     *   the password field.
     *  @type {boolean}
     *  @default false
     */
    open var allowBlankPassword: Boolean = definedExternally
    /**
     *  If true, display a LinkItem (LoginDialog.lostPasswordItem)
     *   meant for the user to click if the account's
     *   credentials are forgotten. The text of the link is controlled by
     *   LoginDialog.lostPasswordItemTitle. If clicked, the link will fire
     *   LoginDialog.lostPassword.
     *  @type {boolean}
     *  @default false
     */
    open var showLostPasswordLink: Boolean = definedExternally
    /**
     *  If true, display a LinkItem (LoginDialog.registrationItem)
     *   meant for the user to click if the user wishes to register a new account.
     *   The text of the link is controlled by
     *   LoginDialog.registrationItemTitle. If clicked, the link will fire
     *   LoginDialog.register.
     *  @type {boolean}
     *  @default false
     */
    open var showRegistrationLink: Boolean = definedExternally
    /**
     *  Specifies the title of the dialog box.
     *  @type {string}
     *  @default "Please log in"
     */
    override var title: String = definedExternally
    /**
     *  Specifies the CSS style of the error text shown for a login failure.
     *  @type {string}
     *  @default "formCellError"
     */
    open var errorStyle: String = definedExternally
    /**
     *  Specifies the title of the "usernameItem" field of the LoginDialog.loginForm.
     *  @type {string}
     *  @default "Username"
     */
    open var usernameItemTitle: String = definedExternally
    /**
     *  Specifies the title of the "passwordItem" field of the LoginDialog.loginForm.
     *  @type {string}
     *  @default "Password"
     */
    open var passwordItemTitle: String = definedExternally
    /**
     *  Specifies the contents of the login submission button of the LoginDialog.loginForm.
     *  @type {string}
     *  @default "Log in"
     */
    open var loginButtonTitle: String = definedExternally
    /**
     *  Specifies the contents of the password request button (if configured) on
     *   the LoginDialog.loginForm.
     *  @type {string}
     *  @default undefined
     */
    open var lostPasswordItemTitle: String = definedExternally
    /**
     *  Specifies the contents of the registration link (if configured) on
     *   the LoginDialog.loginForm.
     *  @type {string}
     *  @default undefined
     */
    open var registrationItemTitle: String = definedExternally
    /**
     *  Specifies the default error message displayed on the login form when
     *   authentication fails.
     *  @type {string}
     *  @default "Invalid username or password"
     */
    open var errorMessage: String = definedExternally
    /**
     *  Specifies the dialog contents. By default, the dialog only contains
     *   LoginDialog.loginForm. If desired, additional widgets may be placed before/after
     *   the loginForm. To specify these widgets as autoChildren, use the syntax
     *   "autoChild:childName" autoChildren.
     *  @type {Array<Partial<Canvas>> | Canvas | string}
     *  @default "["autoChild:loginForm"]"
     */
    override var items: dynamic = definedExternally
    /**
     *  Customizes the fields present in the dialog, or specifies new fields to be
     *   present, in the same manner as with DynamicForm.fields.
     *  @type {Array<Partial<FormItem>>}
     *  @default null
     */
    open var formFields: Array<dynamic> = definedExternally
    /**
     *  Field item containing login error message (if required) in LoginDialog.loginForm.
     *  @type {BlurbItem}
     *  @default null
     */
    open var loginFailureItem: BlurbItem = definedExternally
    /**
     *  Username field item in LoginDialog.loginForm.
     *  @type {TextItem}
     *  @default null
     */
    open var usernameItem: TextItem = definedExternally
    /**
     *  LinkItem to page requesting forgotten password in LoginDialog.loginForm.
     *   To handle user clicks on this link, implement LoginDialog.lostPassword.
     *   To handle a user click as a physical link to another page, set
     *   FormItem.defaultValue via loginDialog.lostPasswordItemProperties:
     * 
     *   lostPasswordItemProperties: {
     *     defaultValue: "register.html"
     *   },
     * 
     *  @type {LinkItem}
     *  @default null
     */
    open var lostPasswordItem: LinkItem = definedExternally
    /**
     *  LinkItem to page requesting new user registration in LoginDialog.loginForm.
     *   To handle user clicks on this link, implement LoginDialog.register.
     *   To handle a user click as a physical link to another page, set
     *   FormItem.defaultValue via loginDialog.registrationItemProperties:
     * 
     *   registrationItemProperties: {
     *     defaultValue: "register.html"
     *   },
     * 
     *  @type {LinkItem}
     *  @default null
     */
    open var registrationItem: LinkItem = definedExternally
    /**
     *  Password field item in LoginDialog.loginForm.
     *  @type {PasswordItem}
     *  @default null
     */
    open var passwordItem: PasswordItem = definedExternally
    /**
     *  Login submission button in LoginDialog.loginForm.
     *  @type {ButtonItem}
     *  @default null
     */
    open var loginButton: ButtonItem = definedExternally
    /**
     *  Form used to request login credentials from the user.
     *  @type {DynamicForm}
     *  @default null
     */
    open var loginForm: DynamicForm = definedExternally
    /**
     *   Called if the user clicks on the LoginDialog.registrationItem
     *   on the login form. Implement this method to allow the user to register for a
     *   new account.
     * 
     *  @param {object} Current values of form fields
     *  @param {DynamicForm} Form on which the link was clicked
     */
    open fun register(values: dynamic, form: DynamicForm): Unit = definedExternally
    /**
     *   Called if the user clicks on the LoginDialog.lostPasswordItem link
     *   on the login form. Implement this method to allow the user to request the password
     *   be resent or reset.
     * 
     *  @param {object} Current values of form fields
     *  @param {DynamicForm} Form on which the link was clicked
     */
    open fun lostPassword(values: dynamic, form: DynamicForm): Unit = definedExternally
    /**
     *   User-supplied callback function to process login transactions.
     *   If the user clicks the "Log in" button, the credentials entered by the user are passed to
     *   loginFunc as an Object with properties "username" and "password" (NOTE: both
     *   property names are all lowercase), as the variable "credentials". For example:
     *   { username: "barney", password: "rUbbL3" }
     * 
     *   This function should then attempt to log in by whatever means is necessary. The second
     *   parameter to the loginFunc, "dialogCallback", is a function, which must be called whether
     *   login succeeds or fails with a true/false value indicating whether login succeeded.
     * 
     *   If the login dialog is dismissable (settable as properties.dismissable, default false) and
     *   the user dismisses it, loginFunc will be fired with null for the credentials.
     * 
     *   The following code shows typical usage. This code assumes you have created a global
     *   function sendCredentials() that send credentials to some authentication system and fires a
     *   callback function with the result:
     * 
     *   ...
     *   loginFunc : function (credentials, dialogCallback) {
     *     if (credentials == null) return; // dismissed
     *  
     *     // send credentials
     *     sendCredentials(credentials, function (loginSucceeded) {
     *       // report success or failure
     *       dialogCallback(loginSucceeded);
     *     })
     *   })
     *   ...
     * 
     * 
     *  @param {object} Login credentials supplied by the user
     *  @param {Function} Function that must be called once the login transaction completes
     */
    open fun loginFunc(credentials: dynamic, dialogCallback: (() -> dynamic)): Unit = definedExternally
    companion object {
        /**
         *  Default title for the dialog displayed by isc.showLoginDialog.
         *   A custom title can alternatively be specified as the title attribute of the
         *   properties parameter passed to that method.
         *  @type {HTMLString}
         *  @default "Please log in"
         */
        var LOGIN_TITLE: String = definedExternally
        /**
         *  Default title for the LoginDialog.usernameItem field in the
         *   dialog displayed by isc.showLoginDialog.
         *  @type {HTMLString}
         *  @default "Username"
         */
        var USERNAME_TITLE: String = definedExternally
        /**
         *  Default title for the LoginDialog.passwordItem field in the
         *   dialog displayed by isc.showLoginDialog.
         *  @type {HTMLString}
         *  @default "Password"
         */
        var PASSWORD_TITLE: String = definedExternally
        /**
         *  Default title for login button in the dialog displayed by
         *   isc.showLoginDialog.
         *  @type {HTMLString}
         *  @default "Log in"
         */
        var LOGIN_BUTTON_TITLE: String = definedExternally
        /**
         *  Default error message displayed on failed login in the dialog shown by
         *   isc.showLoginDialog.
         *  @type {HTMLString}
         *  @default "Invalid username or password"
         */
        var LOGIN_ERROR_MESSAGE: String = definedExternally
        /**
         *  Creates a new LoginDialog
         * 
         *  @param typeCheckedProperties {Partial<LoginDialog>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {LoginDialog} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): LoginDialog = definedExternally
    }
}