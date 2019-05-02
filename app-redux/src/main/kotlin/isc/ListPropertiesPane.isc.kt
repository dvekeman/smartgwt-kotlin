@file:JsQualifier("isc")
package isc

/**
 *  Pane containing controls for editing the style of HTML lists in a RichTextEditor.
 * 
 *   Cannot be directly used; shown in documentation only for skinning purposes.
 */
open external class ListPropertiesPane : Layout {
    /**
     *  The properties corresponding to the currently-selected list configuration.
     *  @type {ListProperties}
     *  @default null
     */
    open var listProperties: ListProperties = definedExternally
    /**
     *  Shows available bullet options as a series of tiles.
     *  @type {TileLayout}
     *  @default null
     */
    open var sampleTileLayout: TileLayout = definedExternally
    /**
     *  Tile used to demonstrate each bullet style.
     *  @type {Canvas}
     *  @default null
     */
    open var sampleTile: Canvas = definedExternally
    /**
     *  Form used to show the ListPropertiesPane.startNumberField for
     *   configuring the starting value of a list.
     *  @type {DynamicForm}
     *  @default null
     */
    open var startNumberForm: DynamicForm = definedExternally
    /**
     *  The FormItem.title of the ListPropertiesPane.startNumberField.
     *  @type {string}
     *  @default "Start at"
     */
    open var startNumberFieldTitle: String = definedExternally
    /**
     *  SpinnerItem used to modify the starting value of the list.
     * 
     *   ListPropertiesPane.startNumberFieldTitle is a
     *   autoChildUsage for the field's FormItem.title.
     *  @type {SpinnerItem}
     *  @default null
     */
    open var startNumberField: SpinnerItem = definedExternally
    /**
     *   Notification method fired when the pane's ListPropertiesPane.listProperties changes.
     * 
     *  @param {ListProperties} the new list configuration properties
     */
    open fun listPropertiesChanged(listProperties: ListProperties): Unit = definedExternally
    companion object {
        /**
         *  Creates a new ListPropertiesPane
         * 
         *  @param typeCheckedProperties {Partial<ListPropertiesPane>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ListPropertiesPane} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ListPropertiesPane = definedExternally
    }
}