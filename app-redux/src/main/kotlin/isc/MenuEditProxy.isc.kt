@file:JsQualifier("isc")
package isc

/**
 *  EditProxy that handles MenuButton and MenuBar objects when editMode is enabled.
 */
open external class MenuEditProxy : CanvasEditProxy {
    /**
     *   Returns the text based on the current component state to be edited inline.
     *   Called by the EditProxy.inlineEditForm to obtain the starting edit value.
     * 
     *   Returns the component's menu definition in wiki-style.
     * 
     * 
     */
    override fun getInlineEditText(): Unit = definedExternally
    /**
     *   Save the new value into the component's state. Called by the
     *   EditProxy.inlineEditForm to commit the change.
     * 
     *   Updates the component's menu.
     * 
     *   Lines starting with "--", "==" or "title:" are considered titles for the
     *   MenuButtons. The menuItem definitions follow the title to define the menu
     *   contents.
     * 
     *   Each menuItem title is entered on its own line. A keyTitle can follow the title
     *   separated by a comma. A leading "x" or "o" marks the menuItem as checked.
     *   MenuItems can be marked as disabled with a leading or trailing dash (-).
     *   A sub-menu is indicated with a trailing &gt;. Any line consisting entirely of
     *   one orÂ more dashes (-) or equals (=) indicates a separator line.
     * 
     * 
     *  @param {string} the new component menu
     */
    override fun setInlineEditText(newValue: String): Unit = definedExternally
    companion object {
        /**
         *  Creates a new MenuEditProxy
         * 
         *  @param typeCheckedProperties {Partial<MenuEditProxy>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {MenuEditProxy} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): MenuEditProxy = definedExternally
    }
}