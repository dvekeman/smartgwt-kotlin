@file:JsQualifier("isc")
package isc

/**
 *  Simple subclass of Button used for tabs in a TabSet if TabSet.useSimpleTabs
 *   is true. See also TabSet.simpleTabButtonConstructor.
 */
open external class SimpleTabButton : Button {
    companion object {
        /**
         *  Creates a new SimpleTabButton
         * 
         *  @param typeCheckedProperties {Partial<SimpleTabButton>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {SimpleTabButton} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): SimpleTabButton = definedExternally
    }
}