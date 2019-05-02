@file:JsQualifier("isc")
package isc

/**
 *  A DataView coordinates the asynchronous loading of WSDL WebService and XML Schema
 *   definitions in applications created by Visual Builder.
 * 
 *   For applications that do not use WSDL Web Services and were not created by Visual Builder,
 *   DataView is equivalent to it's superclass VLayout.
 */
open external class DataView : VLayout {
    /**
     * 
     *   Executed when the dataView has loaded all dependencies (such as DataSources or WebServices).
     *   No default implementation.
     * 
     * 
     */
    open fun dataViewLoaded(): Unit = definedExternally
    companion object {
        /**
         *  Creates a new DataView
         * 
         *  @param typeCheckedProperties {Partial<DataView>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DataView} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DataView = definedExternally
    }
}