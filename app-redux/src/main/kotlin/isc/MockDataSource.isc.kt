@file:JsQualifier("isc")
package isc

/**
 *  A special kind of DataSource.clientOnly that can be configured
 *   with MockDataSource.mockData - a simple text format for table or tree
 *   data.
 * 
 *   MockDataSources are produced by the Reify Mockup Importer when starting from mockup formats
 *   that use the mock data format. The docs for the
 *   balsamiqImport explain various steps for converting a
 *   MockDataSource to a real DataSource.
 * 
 *   MockDataSource is primarily intended as a temporary form of DataSource used
 *   during the process of converting a mockup into a real application. Generally, if creating a
 *   client-only DataSource in JavaScript ,
 *   there is no reason to use the mock data format, as the mock data is not especially readable
 *   when written as a String literal. The mock data format can be a slightly more
 *   compact and readable as compared to declaring DataSource.cacheData in XML.
 */
open external class MockDataSource : DataSource {
    /**
     *  Data intended for a ListGrid or TreeGrid, expressed in a simple text
     *   format popularized by mockup tools such as http://balsamiq.com and now
     *   commonly supported in a variety of mockup tools.
     * 
     *   Balsamiq publishes documentation of the grid format
     *   here,
     *   with a simple example of using tree-specific formatting
     *   here.
     * 
     *   An alternative format of data consisting of an array of Record can
     *   also be provided. In this case the records are converted to "grid" MockDataType.
     *  @type {string | Array<Partial<Record>>}
     *  @default "md"
     */
    open var mockData: dynamic = definedExternally
    /**
     *  Whether MockDataSource.mockData is in the "grid" or "tree" format. See MockDataType.
     *  @type {MockDataType}
     *  @default "grid"
     */
    open var mockDataType: 
                           /**
                            *  Mock data for a ListGrid
                            *  Mock data for a TreeGrid
                            */
                           String /* grid |  tree */ = definedExternally
    companion object {
        /**
         *  Creates a new MockDataSource
         * 
         *  @param typeCheckedProperties {Partial<MockDataSource>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {MockDataSource} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): MockDataSource = definedExternally
    }
}