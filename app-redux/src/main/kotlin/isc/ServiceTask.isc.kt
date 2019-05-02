@file:JsQualifier("isc")
package isc

/**
 *  A ServiceTask is an element of a Process which calls a DataSource operation,
 *   optionally using part of the Process.state as inputs or storing outputs
 *   in the process state.
 * 
 *   By default a ServiceTask takes the data indicated by Task.inputField and/or
 *   Task.inputFieldList as detailed in taskIO and uses the
 *   inputRecord as DSRequest.data. This means the input data becomes
 *   Criteria for a "fetch" operation, new record values for an "add" operation, etc.
 *   For simplicity, if no inputFieldList is provided and inputField
 *   specifies an object, inputData is used as dsRequest.data.
 * 
 *   Alternatively, you can set ServiceTask.criteria for a "fetch" operation, or
 *   ServiceTask.values for other operationTypes. In both cases, you have the ability to
 *   use simple expressions like $input.fieldName to take portions of the input data and
 *   use it as part of the criteria or values.
 * 
 *   OutputData and outputFieldList work as filters. You should determine which properties should
 *   be fetched into the process state. If you want to load all data without defining every
 *   property manually you can pass a name started with '$' and fetched record or records will be
 *   placed as a record or an array of records by the name without this specific symbol.
 * 
 *   For example if you specify 'id' and 'name' in outputFieldList, only these properties will be
 *   fetched in the process state. If you pass '$orderHeader' in outputField a whole record will be
 *   stored in process state under the 'orderHeader' key.
 */
open external class ServiceTask : Task {
    /**
     *  DataSource ID or DataSource instance to be used.
     *  @type {DataSource | GlobalId}
     *  @default null
     */
    open var dataSource: dynamic = definedExternally
    /**
     *  Type of operation to invoke
     *  @type {DSOperationType}
     *  @default "fetch"
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
     *  The OperationBinding.operationId to invoke.
     *  @type {string}
     *  @default null
     */
    open var operationId: String = definedExternally
    /**
     *  Criteria (including AdvancedCriteria) to use for a "fetch" operation.
     * 
     *   Data values in this criteria prefixed with "$" will be treated as dynamic expressions
     *   which can access the inputs to this task as $input - see
     *   taskInputExpression. Specifically, this means that for simple criteria,
     *   any property value that is a String and is prefixed with "$" will be assumed to be an
     *   expression, and for AdvancedCriteria, the same treatment will be applied to
     *   Criterion.value.
     * 
     *   If any data value should not be treated as dynamic (for example, a "$" should be taken
     *   as literal), you can place it in ServiceTask.fixedCriteria instead.
     * 
     *   Ignored for any operationType other than "fetch". Update or delete operations should
     *   place the primary key to update in ServiceTask.values.
     * 
     *   This property supports dynamicCriteria - use Criterion.valuePath
     *   to refer to values in the Process.ruleScope.
     *  @type {Criteria}
     *  @default null
     */
    open var criteria: dynamic = definedExternally
    /**
     *  Values to be submitted for "update", "add" and "remove" operations.
     * 
     *   Similar to Criteria, data values prefixed with "$" will be treated as a
     *   taskInputExpression. Use ServiceTask.fixedValues for any values that start with
     *   "$" but should be treated as a literal.
     *  @type {Record}
     *  @default null
     */
    open var values: Record = definedExternally
    /**
     *  Criteria to be submitted as part of the DSRequest, regardless of inputs to the task.
     *   Will be combined with the data from the Task.inputField or with
     *   ServiceTask.criteria if specified, via DataSource.combineCriteria.
     *  @type {Criteria}
     *  @default null
     */
    open var fixedCriteria: dynamic = definedExternally
    /**
     *  Values to be submitted as part of the DSRequest, regardless of inputs to the task. Will
     *   be combined with the data from the Task.inputField or with
     *   ServiceTask.values if specified, via simple copying of fields, with
     *   fixedValues overwriting values provided by the inputField, but
     *   explicitly specified ServiceTask.values overriding fixedValues.
     *  @type {Record}
     *  @default null
     */
    open var fixedValues: Record = definedExternally
    /**
     *  Field in the Process.state where this task writes outputs. See
     *   taskIO.
     * 
     *   See ServiceTask.outputFieldList for a shorthand method to save the full operation response
     *   data.
     *  @type {string}
     *  @default null
     */
    override var outputField: String = definedExternally
    /**
     *  List of multiple fields in the Process.state where this task will
     *   write outputs. See taskIO.
     * 
     *   If ServiceTask.outputField is also specified, it will be implicitly added to the
     *   outputFieldList if it is not already present.
     * 
     *   In addition to pulling individual fields from the task operation result and placing
     *   them into the process state the full response data can also be written into the
     *   process state without specifying individual fields. Prefix a destination
     *   field path with a "$" (ex. $orderHeader) causes the entire dsResponse.data
     *   to be saved.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    override var outputFieldList: Array<dynamic> = definedExternally
    companion object {
        /**
         *  Creates a new ServiceTask
         * 
         *  @param typeCheckedProperties {Partial<ServiceTask>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ServiceTask} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ServiceTask = definedExternally
    }
}