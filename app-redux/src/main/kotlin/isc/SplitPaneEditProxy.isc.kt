@file:JsQualifier("isc")
package isc

/**
 *  EditProxy that handles SplitPane objects when editMode is enabled.
 */
open external class SplitPaneEditProxy : LayoutEditProxy {
    companion object {
        /**
         *  Creates a new SplitPaneEditProxy
         * 
         *  @param typeCheckedProperties {Partial<SplitPaneEditProxy>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {SplitPaneEditProxy} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): SplitPaneEditProxy = definedExternally
    }
}