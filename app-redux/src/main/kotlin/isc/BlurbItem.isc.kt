@file:JsQualifier("isc")
package isc

/**
 *  FormItem intended for inserting blurbs of instructional HTML into DynamicForms.
 * 
 *   Set the defaultValue of this item to the HTML you want to embed in the form.
 */
open external class BlurbItem : FormItem {
    /**
     *  Blurb items show no title by default.
     *  @type {boolean}
     *  @default false
     */
    override var showTitle: Boolean = definedExternally
    /**
     *  By default, texts span all remaining columns
     *  @type {Integer | string}
     *  @default "\*"
     */
    override var colSpan: dynamic = definedExternally
    /**
     *  Base css style for this item.
     *  @type {CSSStyleName}
     *  @default "staticTextItem"
     */
    override var textBoxStyle: String = definedExternally
    /**
     *  Should the user be able to select the text in this item?
     *  @type {boolean}
     *  @default true
     */
    override var canSelectText: Boolean = definedExternally
    /**
     *  If true, item contents can wrap. If false, all the contents should appear on a single line.
     *  @type {boolean}
     *  @default null
     */
    open var wrap: Boolean = definedExternally
    /**
     *  If true, text that exceeds the specified size of the form item will be clipped.
     *  @type {boolean}
     *  @default false
     */
    open var clipValue: Boolean = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "TextItemEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
    companion object {
        /**
         *  Creates a new BlurbItem
         * 
         *  @param typeCheckedProperties {Partial<BlurbItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {BlurbItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): BlurbItem = definedExternally
    }
}