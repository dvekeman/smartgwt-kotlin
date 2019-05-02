@file:JsQualifier("isc")
package isc

/**
 *  Timeline is a trivial subclass of Calendar that configures the Calendar with settings
 *   typical for a standalone timeline view: hides the Calendar.dayView,
 *   Calendar.weekView and Calendar.monthView tabs and the
 *   Calendar.controlsBar by default.
 * 
 *   Note that the loadingOptionalModules must be loaded to make
 *   use of the Timeline class.
 */
open external class Timeline : Calendar {
    companion object {
        /**
         *  Creates a new Timeline
         * 
         *  @param typeCheckedProperties {Partial<Timeline>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Timeline} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Timeline = definedExternally
    }
}