@file:JsQualifier("isc")
package isc

/**
 *  Simple subclass of MenuButton with appearance appropriate for a ToolStrip menu button.
 *   Can be used to create an icon-only menu button, and icon with text, or a text only button by setting the
 *   icon and title attibutes as required.
 */
open external class ToolStripMenuButton : MenuButton {
    companion object {
        /**
         *  Creates a new ToolStripMenuButton
         * 
         *  @param typeCheckedProperties {Partial<ToolStripMenuButton>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ToolStripMenuButton} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ToolStripMenuButton = definedExternally
    }
}