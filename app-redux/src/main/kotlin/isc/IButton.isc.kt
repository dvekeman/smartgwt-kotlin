@file:JsQualifier("isc")
package isc

/**
 *  The IButton widget class is a class that implements the same APIs as the
 *   Button class. Depending on the current skin, IButtons may be
 *   on the StretchImgButton component, which renders via images, or may be based on the
 *   Button component, which renders via CSS styles.
 */
open external class IButton : Button {
    companion object {
        /**
         *  Creates a new IButton
         * 
         *  @param typeCheckedProperties {Partial<IButton>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {IButton} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): IButton = definedExternally
    }
}