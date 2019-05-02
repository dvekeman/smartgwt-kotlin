@file:JsQualifier("isc")
package isc

/**
 *  A simple subclass of Menu created by TreeMenuButton.
 *   Shows the selected node's path in a custom style.
 * 
 *   Important Note: this class is not directly usable except for skinning and for
 *   subclassing when setting TreeMenuButton.treeMenuConstructor on a TreeMenuButton.
 */
open external class SelectionTreeMenu : Menu {
    companion object {
        /**
         *  Creates a new SelectionTreeMenu
         * 
         *  @param typeCheckedProperties {Partial<SelectionTreeMenu>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {SelectionTreeMenu} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): SelectionTreeMenu = definedExternally
    }
}