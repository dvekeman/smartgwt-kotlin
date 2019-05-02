@file:JsQualifier("isc")
package isc

/**
 *  Simple subclass of LayoutSpacer with appearance appropriate for a ToolStrip spacer
 */
open external class ToolStripSpacer : LayoutSpacer {
    /**
     *  Size of spacer. If not specified, spacer fills remaining space.
     *  @type {number}
     *  @default null
     */
    open var space: Number = definedExternally
    companion object {
        /**
         *  Creates a new ToolStripSpacer
         * 
         *  @param typeCheckedProperties {Partial<ToolStripSpacer>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ToolStripSpacer} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ToolStripSpacer = definedExternally
    }
}