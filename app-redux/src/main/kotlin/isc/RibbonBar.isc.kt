@file:JsQualifier("isc")
package isc

/**
 *  A ToolStrip class for showing
 *   RibbonGroup of related buttons and other controls.
 */
open external class RibbonBar : ToolStrip {
    /**
     *   Add a new group to this RibbonBar. You can either create your group externally and pass
     *   it in, or you can pass a properties block from which to automatically construct it.
     * 
     * 
     *  @param {RibbonGroup} the new group to add to this ribbon
     *  @param {Integer=} the index at which to insert the new group
     */
    open fun addGroup(group: RibbonGroup, position: Number?): Unit = definedExternally
    companion object {
        /**
         *  Creates a new RibbonBar
         * 
         *  @param typeCheckedProperties {Partial<RibbonBar>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {RibbonBar} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): RibbonBar = definedExternally
    }
}