@file:JsQualifier("isc")
package isc

/**
 *  Form item that renders as a blank row in the form layout.
 *   Set RowSpacerItem.startRow to false to create a rowSpacer that simply
 *   takes up every remaining column in the current row rather than starting a new row.
 */
open external class RowSpacerItem : SpacerItem {
    /**
     *  we never show a separate title cell for separators
     *  @type {boolean}
     *  @default false
     */
    override var showTitle: Boolean = definedExternally
    /**
     *  by default, separators span all remaining columns
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
    companion object {
        /**
         *  Creates a new RowSpacerItem
         * 
         *  @param typeCheckedProperties {Partial<RowSpacerItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {RowSpacerItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): RowSpacerItem = definedExternally
    }
}