@file:JsQualifier("isc")
package isc

/**
 *  Subclass of PickTreeItem which shows an IMenuButton rather than a
 *   simple MenuButton as it's main button.
 */
open external class IPickTreeItem : PickTreeItem {
    /**
     *  This item is an AutoChild generated Canvas displayed by
     *   the IPickTreeItem and is an instance of ITreeMenuButton by default.
     *  @type {Canvas}
     *  @default null
     */
    override var button: Canvas = definedExternally
    companion object {
        /**
         *  Creates a new IPickTreeItem
         * 
         *  @param typeCheckedProperties {Partial<IPickTreeItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {IPickTreeItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): IPickTreeItem = definedExternally
    }
}