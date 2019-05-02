@file:JsQualifier("isc")
package isc

/**
 *  A widget that groups other controls for use in RibbonBar.
 */
open external class RibbonGroup : ToolStripGroup {
    /**
     *  Widget class for controls RibbonGroup.createControl by this
     *   RibbonGroup. Since RibbonGroup.newControlConstructor are created via the
     *   autoChild system, they can be further customized via the newControlProperties property.
     *  @type {Class}
     *  @default "IconButton"
     */
    open var newControlConstructor: Class = definedExternally
    /**
     *  Properties used by RibbonGroup.createControl when creating new
     *   controls.
     *  @type {IconButton}
     *  @default null
     */
    open var newControlDefaults: IconButton = definedExternally
    /**
     *   Creates a new control and adds it to this RibbonGroup. The control is created using the
     *   autoChild system, according to the specified
     *   RibbonGroup.newControlConstructor and the passed properties are
     *   applied to it.
     * 
     * 
     *  @param {Canvas} properties to apply to the new control
     *  @param {Integer=} the index at which to insert the new control
     */
    open fun createControl(properties: Canvas, position: Number?): Unit = definedExternally
    companion object {
        /**
         *  Creates a new RibbonGroup
         * 
         *  @param typeCheckedProperties {Partial<RibbonGroup>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {RibbonGroup} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): RibbonGroup = definedExternally
    }
}