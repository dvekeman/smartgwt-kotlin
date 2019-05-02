@file:JsQualifier("isc")
package isc

/**
 *  Simple subclass of Button with appearance appropriate for a ToolStrip button.
 *   Can be used to create an icon-only button, and icon with text, or a text only button by setting the
 *   icon and title attributes as required.
 */
open external class ToolStripButton : Button {
    companion object {
        /**
         *  Creates a new ToolStripButton
         * 
         *  @param typeCheckedProperties {Partial<ToolStripButton>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ToolStripButton} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ToolStripButton = definedExternally
    }
}