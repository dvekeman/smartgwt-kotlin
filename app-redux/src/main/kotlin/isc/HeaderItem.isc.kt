@file:JsQualifier("isc")
package isc

/**
 *  FormItem for showing a header within a DynamicForm.
 * 
 *   Set the defaultValue of this item to the HTML you want to embed in the form.
 */
open external class HeaderItem : FormItem {
    /**
     *  Header text
     *  @type {string}
     *  @default "Header"
     */
    override var defaultValue: String = definedExternally
    /**
     *  Don't show a separate title cell for headers
     *  @type {boolean}
     *  @default false
     */
    override var showTitle: Boolean = definedExternally
    /**
     *  Base CSS class for this item
     *  @type {FormItemBaseStyle}
     *  @default "headerItem"
     */
    override var textBoxStyle: String = definedExternally
    /**
     *  Should the user be able to select the text in this item?
     *  @type {boolean}
     *  @default true
     */
    override var canSelectText: Boolean = definedExternally
    /**
     *  by default, headers span all remaining columns
     *  @type {Integer | string}
     *  @default "\*"
     */
    override var colSpan: dynamic = definedExternally
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
     *  Alignment of this HeaderItem in its cell.
     * 
     *   Note: Because a HeaderItem fills its cell by default, if the
     *   HeaderItem.applyAlignToText setting is changed to false, then the
     *   FormItem.textAlign setting (rather than the align setting)
     *   of this HeaderItem should be used to control the alignment of the header text.
     *  @type {Alignment}
     *  @default null
     */
    override var align: 
                        /**
                         *  Center within container.
                         *  Stick to left side of container.
                         *  Stick to right side of container.
                         */
                        String /* center |  left |  right */ = definedExternally
    /**
     *  If the FormItem.textAlign is unset, should the HeaderItem.align
     *   setting, if set, be used for this HeaderItem's textAlign?
     *  @type {boolean}
     *  @default true
     */
    override var applyAlignToText: Boolean = definedExternally
    companion object {
        /**
         *  Creates a new HeaderItem
         * 
         *  @param typeCheckedProperties {Partial<HeaderItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {HeaderItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): HeaderItem = definedExternally
    }
}