@file:JsQualifier("isc")
package isc

/**
 *  Use the HTMLPane component to display HTML content in a pane of specified size. If the HTML
 *   content is larger than the size of the pane, the pane will provide scrollbars for viewing
 *   clipped content.
 * 
 *   You can set the size of an HTMLPane directly via the width and height properties, or
 *   indirectly by placing the HTMLPane in a container component (Layout, Window,
 *   SectionStack, etc) that manages the sizes of its members.
 */
open external class HTMLPane : HTMLFlow {
    companion object {
        /**
         *  Creates a new HTMLPane
         * 
         *  @param typeCheckedProperties {Partial<HTMLPane>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {HTMLPane} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): HTMLPane = definedExternally
    }
}