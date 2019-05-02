@file:JsQualifier("isc")
package isc

/**
 *  Response sent by the server in response to a DSRequest. Contains
 *   all the properties available on the basic RPCResponse, in addition to the
 *   properties listed here.
 */
open external class DSResponse : RPCResponse {
    /**
     *  The DSRequest.clientContext object as set on the DSRequest.
     *  @type {object}
     *  @default null
     */
    override var clientContext: dynamic = definedExternally
    /**
     *  The DataSource of this DSResponse.
     *  @type {string}
     *  @default null
     */
    open var dataSource: dynamic = definedExternally
    /**
     *  The operation type of the request corresponding to this DSResponse.
     *  @type {DSOperationType}
     *  @default null
     */
    open var operationType: 
                            /**
                             *  Fetch one or more records that match a set of search criteria.
                             *  Store new records
                             *  Update an existing record
                             *  Remove (delete) an existing record
                             *  perform some arbitrary custom logic that is not a CRUD operation.            Format of the inputs and outputs is unconstrained, and the operation
                             *              will be ignored for cache sync purposes by ResultSets. See
                             *              DataSource.performCustomOperation.
                             *  Run server-side validation for "add" or "update" without actually            adding or updating anything. See DataSource.validateData.
                             *  Retrieve a file stored in a binary field in a DataSource record, and            allow the browser to choose whether to view it directly or prompt the
                             *              user to save. See binaryFields.
                             *  Like "viewFile", but the HTTP header Content-Disposition is used to            suggest that the browser show a save dialog. See binaryFields.
                             *  Takes a List of Maps and stores the data in Admin Console XML test            data format
                             *  Upload formatted client data and export it to Excel, XML and other            formats. Used automatically by
                             *              DataSource.exportClientData
                             *              and cannot be used directly. Usable only with the SmartClient server
                             *              framework.
                             *  Use the DataSource as a fileSource.            Used automatically by DataSource.getFile, and
                             *              would not normally be used directly. Usable only with
                             *              the SmartClient server framework.
                             *  Use the DataSource as a fileSource.            Used automatically by DataSource.hasFile, and
                             *              would not normally be used directly. Usable only with
                             *              the SmartClient server framework.
                             *  Use the DataSource as a fileSource.            Used automatically by DataSource.listFiles, and
                             *              would not normally be used directly. Usable only with
                             *              the SmartClient server framework.
                             *  Use the DataSource as a fileSource.            Used automatically by DataSource.removeFile, and
                             *              would not normally be used directly. Usable only with
                             *              the SmartClient server framework.
                             *  Use the DataSource as a fileSource.            Used automatically by DataSource.saveFile, and
                             *              would not normally be used directly. Usable only with
                             *              the SmartClient server framework.
                             *  Use the DataSource as a fileSource.            Used automatically by DataSource.renameFile, and
                             *              would not normally be used directly. Usable only with
                             *              the SmartClient server framework.
                             *  Use the DataSource as a fileSource.            Used automatically by DataSource.getFileVersion, and
                             *              would not normally be used directly. Usable only with
                             *              the SmartClient server framework.
                             *  Use the DataSource as a fileSource.            Used automatically by DataSource.hasFileVersion, and
                             *              would not normally be used directly. Usable only with
                             *              the SmartClient server framework.
                             *  Use the DataSource as a fileSource.            Used automatically by DataSource.listFileVersions, and
                             *              would not normally be used directly. Usable only with
                             *              the SmartClient server framework.
                             *  Use the DataSource as a fileSource.            Used automatically by DataSource.removeFileVersion, and
                             *              would not normally be used directly. Usable only with
                             *              the SmartClient server framework.
                             */
                            String /* fetch |  add |  update |  remove |  custom |  validate |  viewFile |  downloadFile |  storeTestData |  clientExport |  getFile |  hasFile |  listFiles |  removeFile |  saveFile |  renameFile |  getFileVersion |  hasFileVersion |  listFileVersions |  removeFileVersion */ = definedExternally
    /**
     *  The operation ID of the request corresponding to this DSResponse.
     *  @type {string}
     *  @default null
     */
    open var operationId: String = definedExternally
    /**
     *  For "fetch" operations, this is the array of Records fetched. For "update", "add", and
     *   "remove" operations, this is typically an array containing a single Record representing
     *   the record that was updated, added, or removed.
     *  @type {Array<Partial<Record>> | any}
     *  @default null
     */
    override var data: dynamic = definedExternally
    /**
     *  Same meaning as RPCResponse.status, except DSResponses have additional error codes,
     *   such as RPCResponse.STATUS_VALIDATION_ERROR.
     *  @type {Integer}
     *  @default "see below"
     */
    override var status: Number = definedExternally
    /**
     *  An extra property of each DSResponse to a queued request that indicates whether the queue
     *   as a whole succeeded. A queueStatus of RPCResponse.STATUS_SUCCESS, or 0, indicates
     *   that the queue succeeded whereas a queueStatus of RPCResponse.STATUS_FAILURE, or -1,
     *   indicates that the queue failed.
     * 
     *   For example, if two "update" requests are sent in a queue and the first succeeded, but
     *   the second failed validation, then both DSResponses' queueStatus would be -1, but the
     *   DSResponse.status of the first would be RPCResponse.STATUS_SUCCESS and
     *   the status of the second would be an error code such as RPCResponse.STATUS_VALIDATION_ERROR.
     *  @type {Integer}
     *  @default "see below"
     */
    open var queueStatus: Number = definedExternally
    /**
     *  Server-side validation errors for an attempted "update" or "add" operation, as a
     *   JS Object where each property name is a field name from the record and each property
     *   value contains error information.
     * 
     *   To extract just the simple error strings for each field we recommend passing this
     *   object to DataSource.getSimpleErrors
     * 
     *   The Java API DSResponse.addError(fieldName, errorMessage) is used to send server-side
     *   errors to the client. See the Java Server Reference for details.
     *  @type {object}
     *  @default null
     */
    open var errors: dynamic = definedExternally
    /**
     *  Starting row of returned server results, when using paged result fetching
     * 
     *   Note that startRow and endRow are zero-based - the first record is row zero.
     *  @type {number}
     *  @default null
     */
    open var startRow: Number = definedExternally
    /**
     *  End row of returned server results, when using paged result fetching
     * 
     *   Note that startRow and endRow are zero-based - the first record is row zero.
     *  @type {number}
     *  @default null
     */
    open var endRow: Number = definedExternally
    /**
     *  Total number of rows available from the server that match the current filter criteria,
     *   when using paged result fetching.
     *  @type {number}
     *  @default null
     */
    open var totalRows: Number = definedExternally
    /**
     *  Optional flag that can be set by the server to force ResultSets to drop any caches of
     *   records from the DataSource that was the target of the operation.
     *  @type {boolean}
     *  @default null
     */
    open var invalidateCache: Boolean = definedExternally
    /**
     *  Timestamp (millisecond value) to indicate when this dsResponse was cached in
     *   Offline. Not applicable if the response has never been
     *   stored offline.
     *  @type {number}
     *  @default null
     */
    open var offlineTimestamp: Number = definedExternally
    /**
     *  If set, indicates that this response came from the offline cache, not the server. This
     *   flag is the only reliable way for application code to determine the source of a response.
     *  @type {boolean}
     *  @default null
     */
    open var fromOfflineCache: Boolean = definedExternally
    /**
     *  HTTP headers returned by the server as a map from header name to header value.
     * 
     *   Headers are available only when the default RPCTransport "xmlHttpRequest" is in use,
     *   and browsers may limit access to headers for cross-domain requests or in other
     *   security-sensitive scenarios.
     *  @type {object}
     *  @default null
     */
    override var httpHeaders: dynamic = definedExternally
    companion object {
        /**
         *  Creates a new DSResponse
         * 
         *  @param typeCheckedProperties {Partial<DSResponse>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DSResponse} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DSResponse = definedExternally
    }
}