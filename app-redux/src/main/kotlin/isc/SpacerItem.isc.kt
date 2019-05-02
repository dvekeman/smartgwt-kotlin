@file:JsQualifier("isc")
package isc

/**
 *  A SpacerItem takes up a single cell in the FormLayout, of arbitrary size.
 */
open external class SpacerItem : FormItem {
    /**
     *  we never show a separate title cell for spacers
     *  @type {boolean}
     *  @default false
     */
    override var showTitle: Boolean = definedExternally
    /**
     *  default width for the spacer
     *  @type {number}
     *  @default "20"
     */
    override var width: dynamic = definedExternally
    /**
     *  default height for the spacer
     *  @type {number}
     *  @default "20"
     */
    override var height: dynamic = definedExternally
    companion object {
        /**
         *  Creates a new SpacerItem
         * 
         *  @param typeCheckedProperties {Partial<SpacerItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {SpacerItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): SpacerItem = definedExternally
    }
}