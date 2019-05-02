@file:JsQualifier("isc")
package isc

/**
 *  A button that automatically sizes to the length of its title. Implemented via the
 *   StatefulCanvas.autoFit property.
 *  @deprecated \* As of Isomorphic SmartClient version 5.5, autoFit behavior can be achieved using the Button class instead by setting the property Button.autoFit to true.
 */
open external class AutoFitButton : Button {
    companion object {
        /**
         *  Creates a new AutoFitButton
         * 
         *  @param typeCheckedProperties {Partial<AutoFitButton>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {AutoFitButton} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): AutoFitButton = definedExternally
    }
}