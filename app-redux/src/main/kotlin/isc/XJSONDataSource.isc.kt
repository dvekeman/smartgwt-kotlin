@file:JsQualifier("isc")
package isc

/**
 *  A DataSource preconfigured to use the RPCTransport transport
 *   (sometimes called "JSONP") for cross-domain calls to JSON services.
 * 
 *   To use this DataSource, provide the URL of the service as DataSource.dataURL, and
 *   provide DataSource.fields that describe the structure of the data you want to
 *   extract from the service's response.
 * 
 *   DataSource.recordXPath and DataSourceField.valueXPath can be used to extract
 *   data from the JSON structure returned by the service. See
 *   clientDataIntegration for an overview of how to
 *   control what parts of the JSON structure are included in the DSResponse object, and
 *   hence provided to DataBoundComponents that are bound to this DataSource.
 * 
 *   This XJSONDataSource is really a subclass of DataSource with just a few property settings:
 * 
 *    dataFormat : "json",
 *    dataTransport : "scriptInclude"
 *    callbackParam : "callback"
 * 
 * 
 *   If you are also writing the server side code to respond to requests from this DataSource,
 *   see the
 *   tutorial provided by Yahoo!
 *   for a good overview of how this transport mechanism works. Note, as indicated in the
 *   tutorial above, the server is responsible for writing out not just the data, but also a
 *   JavaScript function call that tells the client that the response has arrived. The client
 *   passes the name of the function to call as the "callback" URL parameter.
 * 
 *   NOTE: if you use this DataSource to contact Yahoo web services, remember to include
 *   output=json in the dataURL, as well as a
 *   Yahoo developer ID.
 */
open external class XJSONDataSource : DataSource {
    companion object {
        /**
         *  Creates a new XJSONDataSource
         * 
         *  @param typeCheckedProperties {Partial<XJSONDataSource>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {XJSONDataSource} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): XJSONDataSource = definedExternally
    }
}