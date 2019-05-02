@file:JsQualifier("isc")
package isc

/**
 *  TreeGrid subclass used, by default, by FormItems which implement
 *   PickList to display a PickList.dataSetType of
 *   selectable options.
 * 
 *   Can be subclassed, customized and assigned to FormItems
 *   via the ComboBoxItem.pickTreeConstructor attribute.
 */
open external class PickTreeMenu : TreeGrid {
    companion object {
        /**
         *  Creates a new PickTreeMenu
         * 
         *  @param typeCheckedProperties {Partial<PickTreeMenu>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {PickTreeMenu} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): PickTreeMenu = definedExternally
    }
}