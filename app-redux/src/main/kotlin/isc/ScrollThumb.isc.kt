@file:JsQualifier("isc")
package isc

/**
 *  Class used for the draggable "thumb" of a scrollbar. Do not use directly; this class is
 *   documented only for skinning purposes.
 */
open external class ScrollThumb : StretchImg {
    companion object {
        /**
         *  Creates a new ScrollThumb
         * 
         *  @param typeCheckedProperties {Partial<ScrollThumb>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ScrollThumb} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ScrollThumb = definedExternally
    }
}