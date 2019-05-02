@file:JsQualifier("isc")
package isc

/**
 *  Subclass of Window used to display events within a Calendar. Customize via
 *   Calendar.eventWindow.
 *  @deprecated \* in favor of EventCanvas
 */
open external class EventWindow : Window {
    companion object {
        /**
         *  Creates a new EventWindow
         * 
         *  @param typeCheckedProperties {Partial<EventWindow>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {EventWindow} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): EventWindow = definedExternally
    }
}