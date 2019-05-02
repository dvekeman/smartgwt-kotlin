@file:JsQualifier("isc")
package isc

/**
 *  A WSDataSource is a DataSource that is preconfigured to contact the WSDL web service built
 *   into the SDK (see isomorphic/system/schema/SmartClientOperations.wsdl). This WSDL service
 *   can be easily implemented on Java and non-Java backends.
 * 
 *   WSDataSource supports all 4 DataSource operations (fetch, add, update, remove) and can be
 *   used with ListGrids, DynamicForms and other DataBoundComponents just like other
 *   DataSources.
 * 
 *   Note that WSDataSource is specifically designed for use with SmartClientOperations.wsdl. If
 *   you are trying to connect to a pre-existing WSDL service, start with just DataSource,
 *   not WSDataSource, and see the wsdlBinding chapter for an
 *   overview.
 */
open external class WSDataSource : DataSource {
    companion object {
        /**
         *  Creates a new WSDataSource
         * 
         *  @param typeCheckedProperties {Partial<WSDataSource>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {WSDataSource} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): WSDataSource = definedExternally
    }
}