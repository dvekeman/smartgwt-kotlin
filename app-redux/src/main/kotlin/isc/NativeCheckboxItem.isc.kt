@file:JsQualifier("isc")
package isc

/**
 *  A checkbox for manipulating 2-valued fields based on the native checkbox element.
 */
open external class NativeCheckboxItem : FormItem {
    /**
     *  Base CSS class applied to this item's title text (rendered next to the checkbox element).
     *  @type {FormItemBaseStyle}
     *  @default "labelAnchor"
     */
    override var textBoxStyle: String = definedExternally
    /**
     *  Should we show the label text next to the checkbox item.
     *  @type {boolean}
     *  @default true
     */
    open var showLabel: Boolean = definedExternally
    companion object {
        /**
         *  Creates a new NativeCheckboxItem
         * 
         *  @param typeCheckedProperties {Partial<NativeCheckboxItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {NativeCheckboxItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): NativeCheckboxItem = definedExternally
    }
}