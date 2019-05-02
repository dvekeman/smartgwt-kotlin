@file:JsQualifier("isc")
package isc

/**
 *  EditProxy that handles DynamicForm when editMode is enabled.
 */
open external class FormEditProxy : CanvasEditProxy {
    /**
     *  Controls which parts of a FormItem respond to a click
     *   and result in selecting the component.
     *  @type {SelectItemsMode}
     *  @default "item"
     */
    open var selectItemsMode: 
                              /**
                               *  select an individual item if the item itself it clicked on, but not its title cell
                               *  select an individual item if either the item or its title cell is clicked on. NOTE: this mode is not the default because it can be make it difficult to select the form as a whole
                               *  never allow selection of an individual item
                               */
                              String /* item |  itemOrTitle |  never */ = definedExternally
    companion object {
        /**
         *  Creates a new FormEditProxy
         * 
         *  @param typeCheckedProperties {Partial<FormEditProxy>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {FormEditProxy} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): FormEditProxy = definedExternally
    }
}