@file:JsQualifier("isc")
package isc

/**
 *  Button used to display a hierarchical Menu group for representing / selecting tree data.
 * 
 *   Important Note: this class should not be used directly - it is exposed purely for
 *   i18nMessages
 */
open external class TreeMenuButton : MenuButton {
    /**
     *  Title for this button. If not specified, the selected value from the tree will
     *   be displayed instead.
     *  @type {string}
     *  @default null
     */
    override var title: String = definedExternally
    /**
     *  If TreeMenuButton.title is null, this value will be displayed as a title
     *   when the user has not selected any value from the hierachichal menu.
     *  @type {HTMLString}
     *  @default "Choose a value"
     */
    open var unselectedTitle: String = definedExternally
    /**
     *  If this button's menu (or any of its submenus) are empty, this property can be used
     *   to specify the message to display (as a disabled item) in the empty menu.
     *  @type {HTMLString}
     *  @default null
     */
    open var emptyMenuMessage: String = definedExternally
    /**
     *  If TreeMenuButton.title is null, when the user selects an item, should we
     *   show the full path to the item, or just the item's title as the button's title?
     *  @type {boolean}
     *  @default false
     */
    open var showPath: Boolean = definedExternally
    /**
     *  If TreeMenuButton.showPath is true, this property specifies what will
     *   appear between the folders in the selected value's path.
     *  @type {HTMLString}
     *  @default "&amp;nbsp;&amp;gt;&amp;nbsp;"
     */
    open var pathSeparatorString: String = definedExternally
    /**
     *  Base style to apply to the selected path within the menu. (The "over" version of this
     *   style should also be defined in the stylesheet applied to this widget).
     *  @type {CSSStyleName}
     *  @default "treeMenuSelected"
     */
    open var selectedBaseStyle: String = definedExternally
    /**
     *  For a TreeMenuButton that uses a DataSource, these properties will be passed to
     *   the automatically-created ResultTree. This can be used for various customizations such as
     *   modifying the automatically-chosen Tree.parentIdField.
     *  @type {Tree}
     *  @default null
     */
    open var dataProperties: Tree = definedExternally
    /**
     *  Widget class for the menu created by this button. The default is
     *   SelectionTreeMenu.
     *  @type {SCClassName}
     *  @default "SelectionTreeMenu"
     */
    open var treeMenuConstructor: String = definedExternally
    /**
     *  AutoChild menu displayed when the button is clicked.
     *  @type {Menu}
     *  @default null
     */
    open var treeMenu: Menu = definedExternally
    companion object {
        /**
         *  Creates a new TreeMenuButton
         * 
         *  @param typeCheckedProperties {Partial<TreeMenuButton>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {TreeMenuButton} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): TreeMenuButton = definedExternally
    }
}