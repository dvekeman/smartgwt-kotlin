@file:JsQualifier("isc")
package isc

/**
 *  Set of horizontally arranged buttons.
 */
open external class ToolbarItem : CanvasItem {
    /**
     *  List of buttons for the toolbar.
     *   Each buttons should be specified as a simple JS object with properties to apply to the
     *   button to be displayed. Note that any click stringMethod applied to the
     *   button will be passed 2 parameters: form and item.
     *  @type {Array<Partial<StatefulCanvas>>}
     *  @default null
     */
    open var buttons: Array<dynamic> = definedExternally
    /**
     *  Don't show a title for toolbars
     *  @type {boolean}
     *  @default false
     */
    override var showTitle: Boolean = definedExternally
    /**
     *  these items are in a row by themselves by default
     *  @type {boolean}
     *  @default true
     */
    override var startRow: Boolean = definedExternally
    /**
     *  these items are in a row by themselves by default
     *  @type {boolean}
     *  @default true
     */
    override var endRow: Boolean = definedExternally
    /**
     *  these items span all columns
     *  @type {Integer | string}
     *  @default "\*"
     */
    override var colSpan: dynamic = definedExternally
    /**
     *  This item is an autoChild generated Canvas displayed by
     *   the ToolbarItem and is an instance of Toolbar by defaut, cuztomizeable
     *   via the attr:ToolbarItem.canvasConstructor attribute.
     *  @type {Canvas}
     *  @default null
     */
    override var canvas: Canvas = definedExternally
    /**
     *  Should the toolbar stack its buttons vertically or horizontally?
     *  @type {boolean}
     *  @default false
     */
    open var vertical: Boolean = definedExternally
    /**
     *  Use AutoFitButtons rather than simple Buttons for this toolbar's buttons by default.
     *  @type {Class}
     *  @default "AutoFitButton"
     */
    open var buttonConstructor: Class = definedExternally
    /**
     *  Default properties for this toolbar's buttons.
     *  @type {object}
     *  @default null
     */
    open var buttonProperties: dynamic = definedExternally
    /**
     *  If specified this baseStyle will be applied to the buttons in this toolbar.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var buttonBaseStyle: String = definedExternally
    /**
     *  If set to true, causes the toolbar created by this item to create its child buttons
     *   during initialization, instead of waiting until draw().
     * 
     *   See the corresponding Toolbar.createButtonsOnInit for more
     *   information.
     *  @type {boolean}
     *  @default null
     */
    open var createButtonsOnInit: Boolean = definedExternally
    companion object {
        /**
         *  Creates a new ToolbarItem
         * 
         *  @param typeCheckedProperties {Partial<ToolbarItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ToolbarItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ToolbarItem = definedExternally
    }
}