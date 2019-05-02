@file:JsQualifier("isc")
package isc

/**
 *  The ValuesManager manages data from multiple member forms.
 * 
 *   If a single logical form needs to be separated into multiple DynamicForm instances for
 *   Layout purposes (for example, spanning one logical form across multiple Tabs), a
 *   ValuesManager can be used to make the forms act as one logical form, supporting all
 *   value-related APIs otherwise called on DynamicForm directly.
 * 
 *   A ValuesManager has no visual representation - it is strictly a logical entity, and the
 *   member forms provide the user interface. You can initialize a ValuesManager with a set of
 *   member forms (by setting ValuesManager.members at init) or add and remove member
 *   forms dynamically.
 * 
 *   Calling ValuesManager.setValues on a ValuesManager will automatically route new
 *   field values to whichever member form is showing an editor for that field. Likewise,
 *   calling ValuesManager.validate will validate all member forms, and
 *   ValuesManager.saveData will initiate a save operation which aggregates values from
 *   all member forms.
 * 
 *   Like a DynamicForm, a ValuesManager can be databound by setting
 *   ValuesManager.dataSource. In this case all member forms must also be bound to the
 *   same DataSource.
 * 
 *   In general, when working with a ValuesManager and its member forms, call APIs on the
 *   ValuesManager whenever you are dealing with values that span multiple forms, and only call
 *   APIs on member forms that are specific to that form or its fields.
 * 
 *   Note that, just as a DynamicForm can track values that are not shown in any FormItem, a
 *   ValuesManager may track values for which there is no FormItem in any member form. However,
 *   when using a ValuesManager these extra values are only allowed on the ValuesManager itself.
 *   Member forms will not track values for which they do not have FormItems.
 */
open external class ValuesManager : Class {
    /**
     *  Specifies a dataSource for this valuesManager. This dataSource will then be used for
     *   validation and client-server flow methods. Can be specified as a dataSource object or
     *   an identifier for the dataSource.
     *   Note that member forms should have the same dataSource applied to them to allow their
     *   items to inherit properties from the DataSource fields.
     *  @type {DataSource | GlobalId}
     *  @default null
     */
    open var dataSource: dynamic = definedExternally
    /**
     *  DSRequest.operationId to use when performing add operations.
     *  @type {string}
     *  @default null
     */
    open var addOperation: String = definedExternally
    /**
     *  DSRequest.operationId to use when performing update operations.
     *  @type {string}
     *  @default null
     */
    open var updateOperation: String = definedExternally
    /**
     *  DSRequest.operationId to use when performing remove operations.
     *  @type {string}
     *  @default null
     */
    open var removeOperation: String = definedExternally
    /**
     *  DSRequest.operationId to use when performing fetch operations.
     *  @type {string}
     *  @default null
     */
    open var fetchOperation: String = definedExternally
    /**
     *  The set of member components for this valuesManager. These can be specified at init time
     *   via the members property, or updated at runtime via addMember()
     *   and removeMember().
     *   Note: Alternatively a DataBoundComponent can be initialized as a member of a valuesManager
     *   by setting the valuesManager property of the component to a pre-defined
     *   valuesManager instance, or by calling setValuesManager on the component.
     *  @type {Array<Partial<DynamicForm>>}
     *  @default null
     */
    open var members: Array<dynamic> = definedExternally
    /**
     *  If set to true, client-side validators will not run on the form when validate() is
     *   called. Server-side validators (if any) will still run on attempted save.
     *  @type {boolean}
     *  @default null
     */
    open var disableValidation: Boolean = definedExternally
    /**
     *  If explicitly set to false, prevents the ValuesManager from automatically propagating
     *   data value changes to its members. You can manually synchronize member data values
     *   at any time with a call to ValuesManager.synchronizeMembers.
     *  @type {boolean}
     *  @default null
     */
    open var autoSynchronize: Boolean = definedExternally
    /**
     *  Before we start editing the values of this ValuesManager in one or more DataBoundComponents,
     *   should we perform a deep clone of the underlying values. See
     *   DataSource.deepCloneOnEdit for details of what this means.
     * 
     *   If this value is not explicitly set, it defaults to the value of DataSource.deepCloneOnEdit.
     *   This value can be overridden per-field with DataSourceField.deepCloneOnEdit.
     * 
     *   Like the other deepCloneOnEdit settings, this flag only has an effect if you are
     *   editing a values object that contains nested objects or arrays, using
     *   Canvas.dataPaths.
     *  @type {boolean}
     *  @default null
     */
    open var deepCloneOnEdit: Boolean = definedExternally
    /**
     *  What operator should be used to combine sub-criteria from member forms when
     *   ValuesManager.getValuesAsCriteria is called?
     *  @type {OperatorId}
     *  @default "and"
     */
    open var operator: 
                       /**
                        *  exactly equal to
                        *  not equal to
                        *  exactly equal to, if case is disregarded
                        *  not equal to, if case is disregarded
                        *  Greater than
                        *  Less than
                        *  Greater than or equal to
                        *  Less than or equal to
                        *  Contains as sub-string (match case)
                        *  Starts with (match case)
                        *  Ends with (match case)
                        *  Contains as sub-string (case insensitive)
                        *  Starts with (case insensitive)
                        *  Ends with (case insensitive)
                        *  Does not contain as sub-string (match case)
                        *  Does not start with (match case)
                        *  Does not end with (match case)
                        *  Does not contain as sub-string (case insensitive)
                        *  Does not start with (case insensitive)
                        *  Does not end with (case insensitive)
                        *  shortcut for "greaterThan" + "and" + "lessThan" (case insensitive)
                        *  shortcut for "greaterOrEqual" + "and" + "lessOrEqual" (case insensitive)
                        *  Basic GLOB matching using wildcards    (see DataSource.translatePatternOperators for more information on available patterns)
                        *  Basic GLOB matching using wildcards (case insensitive)    (see DataSource.translatePatternOperators for more information on available patterns)
                        *  GLOB matching using wildcards. Value is considered to meet the    criterion if it contains the pattern. See DataSource.translatePatternOperators
                        *      for more information on available patterns)
                        *  GLOB mathcing using wildcards. Value is considered to meet the    criterion if it starts with the pattern.See DataSource.translatePatternOperators
                        *      for more information on available patterns)
                        *  GLOB mathcing using wildcards. Value is considered to meet the    criterion if it starts with the pattern.See DataSource.translatePatternOperators
                        *      for more information on available patterns)
                        *  GLOB matching using wildcards. Value is considered to meet the    criterion if it contains the pattern. Matching is case insensitive. See
                        *      DataSource.translatePatternOperators for more information on available patterns)
                        *  GLOB matching using wildcards. Value is considered to meet the    criterion if it starts with the pattern. Matching is case insensitive.See
                        *      DataSource.translatePatternOperators for more information on available patterns)
                        *  GLOB matching using wildcards.Value is considered to meet the    criterion if it ends with the pattern. Matching is case insensitive. See
                        *      DataSource.translatePatternOperators for more information on available patterns)
                        *  Regular expression match
                        *  Regular expression match (case insensitive)
                        *  value is either null or the empty string. For numeric fields it behaves as isNull
                        *  value is neither null nor the empty string ("")
                        *  value is null
                        *  value is non-null. Note empty string ("") is non-null
                        *  value is in a set of values. Specify criterion.value as an Array
                        *  value is not in a set of values. Specify criterion.value as an Array
                        *  matches another field (match case, specify fieldName as criterion.value)
                        *  does not match another field (match case, specify fieldName as criterion.value)
                        *  matches another field (case insensitive, specify fieldName as criterion.value)
                        *  does not match another field (case insensitive, specify fieldName as criterion.value)
                        *  Greater than another field (specify fieldName as criterion.value)
                        *  Less than another field (specify fieldName as criterion.value)
                        *  Greater than or equal to another field    (specify fieldName as criterion.value)
                        *  Less than or equal to another field    (specify fieldName as criterion.value)
                        *  Contains as sub-string (match case) another field value    (specify fieldName as criterion.value)
                        *  Starts with (match case) another field value    (specify fieldName as criterion.value)
                        *  Ends with (match case) another field value    (specify fieldName as criterion.value)
                        *  Contains as sub-string (case insensitive) another field value    (specify fieldName as criterion.value)
                        *  Starts with (case insensitive) another field value    (specify fieldName as criterion.value)
                        *  Ends with (case insensitive) another field value    (specify fieldName as criterion.value)
                        *  Does not contain as sub-string (match case) another field value    (specify fieldName as criterion.value)
                        *  Does not start with (match case) another field value    (specify fieldName as criterion.value)
                        *  Does not end with (match case) another field value    (specify fieldName as criterion.value)
                        *  Does not contain as sub-string (case insensitive) another field value    (specify fieldName as criterion.value)
                        *  Does not start with (case insensitive) another field value    (specify fieldName as criterion.value)
                        *  Does not end with (case insensitive) another field value    (specify fieldName as criterion.value)
                        *  all subcriteria (criterion.criteria) are true
                        *  all subcriteria (criterion.criteria) are false
                        *  at least one subcriteria (criterion.criteria) is true
                        *  shortcut for "greaterThan" + "lessThan" + "and". Specify criterion.start     and criterion.end
                        *  shortcut for "greaterOrEqual" + "lessOrEqual" + "and". Specify     criterion.start and criterion.end
                        */
                       String /* equals |  notEqual |  iEquals |  iNotEqual |  greaterThan |  lessThan |  greaterOrEqual |  lessOrEqual |  contains |  startsWith |  endsWith |  iContains |  iStartsWith |  iEndsWith |  notContains |  notStartsWith |  notEndsWith |  iNotContains |  iNotStartsWith |  iNotEndsWith |  iBetween |  iBetweenInclusive |  matchesPattern |  iMatchesPattern |  containsPattern |  startsWithPattern |  endsWithPattern |  iContainsPattern |  iStartsWithPattern |  iEndsWithPattern |  regexp |  iregexp |  isBlank |  notBlank |  isNull |  notNull |  inSet |  notInSet |  equalsField |  notEqualField |  iEqualsField |  iNotEqualField |  greaterThanField |  lessThanField |  greaterOrEqualField |  lessOrEqualField |  containsField |  startsWithField |  endsWithField |  iContainsField |  iStartsWithField |  iEndsWithField |  notContainsField |  notStartsWithField |  notEndsWithField |  iNotContainsField |  iNotStartsWithField |  iNotEndsWithField |  and |  not |  or |  between |  betweenInclusive */ = definedExternally
    /**
     *  Default DSOperationType to be performed when DynamicForm.saveData is called.
     *   This property is automatically set on a call to DynamicForm.editRecord or
     *   DynamicForm.editNewRecord, or may be set directly via
     *   DynamicForm.setSaveOperationType.
     * 
     *   If saveOperationType is unset, the form will heuristically determine
     *   whether an "add" or "update" operation is intended based on whether the primaryKey field
     *   is present and editable.
     *  @type {DSOperationType}
     *  @default null
     */
    open var saveOperationType: 
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
     *  When calling ValuesManager.saveData on a form or valuesManager, by default if the server
     *   returns an error code, any callback passed into saveData() will not be fired.
     *   If the error code returned by the server indicates a validation error, it will be
     *   displayed to the user by updating the form items to show the error messages, and firing
     *   any specified hiddenValidationErrors handler, otherwise the standard RPCManager
     *   error handling logic would be invoked.
     * 
     *   Developers who want to handle errors themselves can override this default by specifying
     *   RPCRequest.willHandleError on the DSRequest. In this case the callback passed in
     *   will be fired even if the server returns an error status code.
     * 
     *   If suppressValidationErrorCallback is set to true, if a save attempt returns
     *   a validation error code, the user-specified callback will not be fired
     *   even if willHandleError:true was specified on the dsRequest
     *   - though for other error codes, the callback would be fired if willHandleError is
     *   specified on the request.
     *   Note that this is the historical behavior for
     *   SmartClient builds 8.0 and earlier
     * 
     *  @type {boolean}
     *  @default false
     */
    open var suppressValidationErrorCallback: Boolean = definedExternally
    /**
     *   Update all of this ValuesManager's members to reflect the current values held by the
     *   ValuesManager. It is not normally necessary to manually synchronize members, but you
     *   will need to do so if you switch off ValuesManager.autoSynchronize.
     * 
     */
    open fun synchronizeMembers(): Unit = definedExternally
    /**
     *   Update just those of this ValuesManager's members that have the parameter
     *   Canvas.dataPath, to reflect the current values held by the
     *   ValuesManager. Note, it is not normally necessary to manually synchronize members
     * 
     *  @param {string} dataPath to synchronize
     */
    open fun synchronizeMembersOnDataPath(dataPath: String): Unit = definedExternally
    /**
     *   Update the parameter ValuesManager member to reflect the current values held by the
     *   ValuesManager. Note, it is not normally necessary to manually synchronize members
     * 
     *  @param {Canvas} Member component to synchronize
     */
    open fun synchronizeMember(member: Canvas): Unit = definedExternally
    /**
     *   Fires after a member component's values have been synchronized from the ValuesManager's
     *   values, upon completion of the ValuesManager.synchronizeMember call.
     *   No default implementation.
     * 
     *  @param {Canvas} Member component that has just completed synchronization
     */
    open fun memberSynchronized(member: Canvas): Unit = definedExternally
    /**
     *   Specifies a dataSource for this valuesManager. This dataSource will then be used for
     *   validation and client-server flow methods.
     * 
     *  @param {DataSource | GlobalId} Datasource object or identifier to bind to.
     */
    open fun setDataSource(dataSource: dynamic): Unit = definedExternally
    /**
     *   Returns the dataSource for this valuesManager. Will return null if this is not a
     *   data-bound valuesManager instance.
     * 
     */
    open fun getDataSource(): DataSource = definedExternally
    /**
     *   Retrieve a FormItem from this ValuesManager.
     * 
     *   Takes a field FormItem.name or DataPath, and searches through the
     *   members of this valuesManager for an editor for that field. If found the appropriate
     *   formItem will be returned. If the "retrieveAll" parameter is true, this method will return
     *   all FormItems that are bound to the supplied name or dataPath (a dataPath can be bound
     *   to more than one FormItem, as long as those FormItems are on different forms); if
     *   "retrieveAll" is false or unset, and there is more than one binding for the dataPath,
     *   this method just returns the first one it finds.
     *   Note that if a dataPath is passed in, it should be the full data path for the item,
     *   including any canvas level Canvas.dataPath specified on the member
     *   form containing this form item.
     *   Note: Unlike the DynamicForm class, this method will not return an
     *   item by index
     * 
     *  @param {FieldName | DataPath} item fieldName or dataPath identifier
     *  @param {boolean=} If true, return the list of all FormItems that                   are bound to this name or dataPath on a member                    form of this ValuesManager
     */
    open fun getItem(itemID: String, retrieveAll: Boolean?): FormItem = definedExternally
    /**
     *   Retrieves an array of pointers to all the members for this valuesManager.
     * 
     */
    open fun getMembers(): Array<dynamic> = definedExternally
    /**
     *   Returns a pointer to a specific member.
     * 
     *  @param {string} ID of the member component to retrieve
     */
    open fun getMember(ID: String): Canvas = definedExternally
    /**
     *   Given a fieldName or dataPath, this method will find the member responsible for
     *   interacting with that field's value.
     *   If no form is found, returns null.
     * 
     *  @param {string} fieldName or dataPath to check
     */
    open fun getMemberForField(fieldName: String): Canvas = definedExternally
    /**
     *   Validate the current set of values for this values manager against validators defined
     *   in the member forms. For databound valuesManagers, also perform validation against any
     *   validators defined on datasource fields.
     * 
     *   Note that if validation errors occur for a value that is not shown in any member forms,
     *   those errors will cause a warning and ValuesManager.handleHiddenValidationErrors will be
     *   called. This can occur if:
     *   - A datasource field has no corresponding item in any member form
     *   - The item in question is hidden
     *   - The member form containing the item is hidden.
     * 
     *   If this form has any fields which require server-side validation (see
     *   Validator.serverCondition) this will also be initialized. Such validation will
     *   occur asynchronously. Developers can use ValuesManager.isPendingAsyncValidation
     *   and ValuesManager.handleAsyncValidationReply to detect and respond to
     *   asynchronous validation.
     * 
     * 
     */
    open fun validate(): Boolean = definedExternally
    /**
     *   Call ValuesManager.validate to check for validation errors. If no errors are found,
     *   return the current values for this valuesManager, otherwise return null.
     * 
     */
    open fun getValidatedValues(): dynamic = definedExternally
    /**
     *   Sets validation errors for this valuesManager to the specified set of errors.
     *   Errors should be of the format:
     *   {field1:errors, field2:errors}
     *   where each errors object is either a single error message string or an
     *   array of error messages.
     *   If showErrors is passed in, error messages will be displayed in the
     *   appropriate member form items. For fields with no visible form item,
     *   ValuesManager.handleHiddenValidationErrors will be fired instead.
     *   Note that if showErrors is false, errors may be shown at any time via
     *   a call to ValuesManager.showErrors.
     * 
     * 
     *  @param {object} list of errors as an object with the field names as keys
     *  @param {boolean} If true display errors now.
     */
    open fun setErrors(errors: dynamic, showErrors: Boolean): Unit = definedExternally
    /**
     *   Adds validation errors to the existing set of errors for the field in question.
     *   Errors passed in should be a string (for a single error message) or an array of strings.
     *   Pass in the showErrors parameter to immediately display the errors to the user by
     *   redrawing the appropriate member form item (or if no visible item is found for the field
     *   firing ValuesManager.handleHiddenValidationErrors.
     * 
     *  @param {string} name of field to apply errors to
     *  @param {string | Array<Partial<string>>} error messages for the field
     *  @param {boolean} should the error(s) be immediately displayed to the user?
     */
    open fun addFieldErrors(fieldName: String, errors: dynamic, showErrors: Boolean): Unit = definedExternally
    /**
     *   Sets validation errors for some field in the valuesManager.
     *   Errors passed in should be a string (for a single error message) or an array of strings.
     *   Pass in the showErrors parameter to immediately display the errors to the user by
     *   redrawing the appropriate member form item (or if no visible item is found for the field
     *   firing ValuesManager.handleHiddenValidationErrors.
     * 
     *  @param {string} name of field to apply errors to
     *  @param {string | Array<Partial<string>>} error messages for the field
     *  @param {boolean} should the error(s) be immediately displayed to the user?
     */
    open fun setFieldErrors(fieldName: String, errors: dynamic, showErrors: Boolean): Unit = definedExternally
    /**
     *     Clears all errors from member forms.
     * 
     *  @param {boolean} If true, clear any visible error messages.
     */
    open fun clearErrors(showErrors: Boolean): Unit = definedExternally
    /**
     *   Clear all validation errors associated with some field in this form
     * 
     *  @param {string} field for which errors should be cleared
     *  @param {boolean} if true, and the field is present in one of our member forms,            redraw it to clear any currently visible validation errors
     */
    open fun clearFieldErrors(fieldName: String, show: Boolean): Unit = definedExternally
    /**
     *   Returns the set of errors for this valuesManager.
     *   Errors will be returned as an object of the format
     *   {field1:errors, field2:errors}
     *   Where each errors object is either a single error message or an array of error message
     *   strings.
     * 
     */
    open fun getErrors(): dynamic = definedExternally
    /**
     *   Returns any validation errors for some field in this valuesManager.
     *   Errors will be returned as either a string (a single error message), or an array
     *   of strings. If no errors are present, will return null.
     * 
     *  @param {string} fieldName to check for errors
     */
    open fun getFieldErrors(fieldName: String): dynamic = definedExternally
    /**
     *   Are there any errors associated with any fields in this valuesManager?
     * 
     */
    open fun hasErrors(): Boolean = definedExternally
    /**
     *   Are there any errors associated with a field in this valuesManager?
     * 
     *  @param {string} field to check for errors
     */
    open fun hasFieldErrors(fieldName: String): Boolean = definedExternally
    /**
     *   Method to explicitly show the latest set of validation errors present on this
     *   ValuesManager.
     *   Will redraw all member forms to display (or clear) currently visible errors, and
     *   fire ValuesManager.handleHiddenValidationErrors to allow custom handling of
     *   hidden errors.
     * 
     */
    open fun showErrors(): Unit = definedExternally
    /**
     *   Method to explicitly show the latest set of validation errors present on some field
     *   within this ValuesManager.
     *   If the field in question is present as a visible item in a member form, the form item
     *   will be redrawn to display the error message(s).
     *   Otherwise ValuesManager.handleHiddenValidationErrors will be fired to allow
     *   custom handling of hidden errors.
     * 
     */
    open fun showFieldErrors(): Unit = definedExternally
    /**
     *   Notification fired when an asynchronous validation completes.
     * 
     *  @param {boolean} true if validation succeeded, false if it failed
     *  @param {object} Map of errors by fieldName. Will be null if validation succeeded.
     */
    open fun handleAsyncValidationReply(success: Boolean, errors: dynamic): Unit = definedExternally
    /**
     *   Is this ValuesManager waiting for an asynchronous validation to complete?
     *   This method will return true after ValuesManager.validate is called on a
     *   component with server-side validators for some field(s), until the server responds.
     * 
     *   Note that the notification method ValuesManager.handleAsyncValidationReply will
     *   be fired when validation completes.
     * 
     */
    open fun isPendingAsyncValidation(): Boolean = definedExternally
    /**
     *   Returns the current set of values for the values manager instance. This includes the
     *   values from any form managed by this manager, as well as any values explicitly applied
     *   via ValuesManager.setValues.
     * 
     */
    open fun getValues(): dynamic = definedExternally
    /**
     *   Replaces the current values of the ValuesManager and all member components with the
     *   values passed in.
     * 
     *   Values should be provided as an Object containing the new values as properties, where
     *   each propertyName is the name of a Items in one of the member forms,
     *   and each property value is the value to apply to that form item via
     *   FormItem.setValue.
     * 
     *   Values with no corresponding form item may also be passed, will be tracked by the
     *   valuesManager and returned by subsequent calls to ValuesManager.getValues.
     * 
     *   Any FormItem for which a value is not provided will revert to its
     *   FormItem.defaultValue. To cause all FormItems to revert to default
     *   values, pass null.
     * 
     *   This method also calls ValuesManager.rememberValues so that a subsequent later call to
     *   ValuesManager.resetValues will revert to the passed values.
     * 
     * 
     *  @param {object} new set of values for this values manager.
     */
    open fun setValues(values: dynamic): Unit = definedExternally
    /**
     *   Clear out all the values managed by this values manager.
     * 
     */
    open fun clearValues(): Unit = definedExternally
    /**
     *   Returns the subset of this valuesManager's values associated with some member form.
     * 
     * 
     *  @param {string} ID of the member form for which we want to retrieve the values.
     */
    open fun getMemberValues(ID: String): dynamic = definedExternally
    /**
     *   Set the values for some member form.
     * 
     *  @param {string} ID of the member form to update
     *  @param {object} new values for the form
     */
    open fun setMemberValues(ID: String, values: dynamic): Unit = definedExternally
    /**
     *   Retrieves the combined DynamicForm.getValuesAsCriteria
     *   for all member forms.
     * 
     *   As with the DynamicForm getValuesAsCriteria, this method may return
     *   AdvancedCriteria or simple Criteria depending on whether
     *   the advanced parameter was passed, whether the ValuesManager.operator
     *   is set to "or" rather than "and", and whether any member
     *   forms return AdvancedCriteria.
     * 
     *   Note that developers can also use DataSource.combineCriteria to combine
     *   sub-criteria from various sources, including member forms of a ValuesManager, into
     *   a combined criteria object.
     * 
     * 
     *  @param {boolean} if true, return an AdvancedCriteria object even if the  form item values could be represented in a simple Criterion object.
     *  @param {TextMatchStyle=} This parameter may be passed to indicate whether  the criteria are to be applied to a substring match (filter) or exact match (fetch).  When advanced criteria are returned this parameter will cause the appropriate  operator to be generated for individual fields' criterion clauses.
     */
    open fun getValuesAsCriteria(advanced: Boolean, textMatchStyle: 
                                                                    /**
                                                                     *  case-insensitive exact match ("foo" matches "foo" and "FoO", but not "FooBar")
                                                                     *  case-sensitive exact match ("foo" matches only "foo")
                                                                     *  case-insenstive substring match ("foo" matches "foobar" and "BarFoo")
                                                                     *  case-insensitive prefix match ("foo" matches "FooBar" but not "BarFoo")
                                                                     *   textMatchStyle behavior is consistent across the client and all three of the built-in
                                                                     *   server DataSource implementations - SQL, Hibernate and JPA - to the maximum extent that is
                                                                     *   practical. Known inconsistencies, some of which can be tweaked with configuration settings,
                                                                     *   are described below
                                                                     * 
                                                                     *  - textMatchStyle can be disabled for any individual field with the
                                                                     *   DataSourceField.ignoreTextMatchStyle declaration. This behavior is consistent
                                                                     *   across client and server implementations, with the proviso that case-sensitive behavior
                                                                     *   is inherently inconsistent in the server-side implementations (see below for a more
                                                                     *   detailed discussion of this)
                                                                     * 
                                                                     *  - textMatchStyle is forced to "exactCase" for DataSourceField.primaryKey
                                                                     *   fields on update and remove operations, unless
                                                                     *   OperationBinding.allowMultiUpdate is in force. This means that a normal update
                                                                     *   or remove operation - which is constrained by a unique primaryKey value or combination, to
                                                                     *   affect only a single data row - will use an equality match on all primaryKey fields. This
                                                                     *   is desirable because it makes index usage more likely. Note that this means the key values
                                                                     *   "foo" and "FOO" are distinct, which is a change from previous behavior. For most databases,
                                                                     *   this change will have no effect because most databases do not by default allow primaryKey
                                                                     *   values that only differ in case anyway - if a table has a row with a PK of "foo" and you
                                                                     *   try to insert a row with a PK of "FOO", most databases will fail with a constraint violation.
                                                                     *   However, if you are using a database hat allows key values that differ only in case, and you
                                                                     *   need to support this for some reason, you can switch the framework back to the previous
                                                                     *   behavior by setting property allow.case.sensitive.pks to true in
                                                                     *   your server.properties file. Note, we do not recommend this; in fact, we do
                                                                     *   not recommend the use of text primaryKey fields at all. Where you have control ,we would
                                                                     *   always recommend the use of automatically incrementing numeric sequence keys.
                                                                     * 
                                                                     *  - textMatchStyle does not apply to boolean or temporal (date, datetime, time)
                                                                     *   DataSourceField.type. Such fields are always checked for equality. If
                                                                     *   you have a need for more complex matching, such as date-range checking, use AdvancedCriteria
                                                                     * 
                                                                     *  - Critiera values for temporal fields must be real dates (Javascript Date
                                                                     *   objects on the client, instances of java.util.Date on the server). Attempting
                                                                     *   to match against a string or any other type of value will result in an "always fails"
                                                                     *   clause being generated. This behavior is how the client code has always worked, but is a
                                                                     *   change for the server-side DataSources, in the interests of consistency. The previous
                                                                     *   behavior was:
                                                                     * 
                                                                     *  - SQLDataSource used to attempt to match the date column to the criteria value provided;
                                                                     *    if that value was an appropriately-formatted string, that attempt might have
                                                                     *    worked, but it would be database-specific. If you have an application that depends on
                                                                     *    this old behavior, you can switch it back on by adding the following to your
                                                                     *    server.properties file:
                                                                     *    sql.temporal.fields.require.date.criteria: false
                                                                     * 
                                                                     *  - HibernateDataSource and JPADataSource used to skip such clauses altogether, which
                                                                     *    results in the opposite behavior (there is an implied "always succeeds" clause, because
                                                                     *    the clause is not present in the query at all). If you have an application that depends on
                                                                     *    this old behavior, you can switch it back on by adding the following to your
                                                                     *    server.properties file:
                                                                     *    jpa.temporal.fields.require.date.criteria: false or
                                                                     *    hibernate.temporal.fields.require.date.criteria: false, as appropriate
                                                                     * 
                                                                     * 
                                                                     *  - textMatchStyle does not apply to fields used in the joins generated to satisfy
                                                                     *   DataSourceField.includeFrom declarations or entity relations in
                                                                     *   Hibernate or JPA. Again, such comparisons are always for equality
                                                                     * 
                                                                     *  - textMatchStyle is applied to numeric fields only if the supplied criteria value
                                                                     *   is a string. So for a numeric field "myNumber", we will match 10, 100, 110 and 1000 if a
                                                                     *   criteria value of "10" (the quoted string) is supplied, but we will only match 10 if a
                                                                     *   criteria value of 10 (the actual number) is supplied
                                                                     * 
                                                                     *  - This is a change in behavior for the server-side DataSource implementations, in the
                                                                     *    interests of consistency with the client behavior. Previously, all three of the built-in
                                                                     *    DataSource implementations applied textMatchStyle to numeric fields regardless of the
                                                                     *    criteria value's type. If you have an application that depends on this old behavior,
                                                                     *    you can switch it back on by adding the following to your server.properties
                                                                     *    file: sql.substring.numeric.criteria: true or
                                                                     *    hibernate.substring.numeric.criteria: true or
                                                                     *    jpa.substring.numeric.criteria: true, as appropriate
                                                                     * 
                                                                     * 
                                                                     *  - "exactCase" matching cannot be made consistent across all database providers because
                                                                     *   each database has its own idea of whether case-sensitive matching should be the default,
                                                                     *   and how to switch it on and off (if that is even possible)
                                                                     * 
                                                                     *  - Microsoft SQL Server must have case-sensitive matching enabled by setting a
                                                                     *    case-sensitive collation when the database is created (there are more fine-grained
                                                                     *    options, but we do not recommend them because of the scope for further inconsistency,
                                                                     *    where "exactCase" works correctly on table A but not on table B). See
                                                                     *    MSDN for details
                                                                     * 
                                                                     *  - HSQLDB has case sensitivity set with the SET IGNORECASE directive -
                                                                     *    see here
                                                                     * 
                                                                     *  - MySQL is case-insensitive, but since it provides an easy way to do per-query,
                                                                     *    case-sensitive matching in SQL, we work around it for that database, but only in
                                                                     *    SQL DataSources
                                                                     * 
                                                                     * 
                                                                     *  - If you are using Hibernate or JPA, whether "exactCase" works as expected depends
                                                                     *   entirely on the underlying database. Unlike the SQL DataSource, where we have fine-grained
                                                                     *   control of the SQL that the database executes, we are constrained by what the ORM will
                                                                     *   allow. This prevents us from compensating for database quirks, like we do with MySQL's
                                                                     *   case-insensitivity in the SQL DataSource
                                                                     * 
                                                                     */
                                                                    String /* exact |  exactCase |  substring |  startsWith */?): dynamic = definedExternally
    /**
     *   Return an AdvancedCriteria object based on the current set of values within memberForms.
     * 
     *   Similar to ValuesManager.getValuesAsCriteria, except the returned criteria object
     *   is guaranteed to be an AdvancedCriteria object, even if none of the form's fields has a
     *   specified FormItem.operator
     * 
     * 
     *  @param {TextMatchStyle=} If specified the text match style will be used to  generate the appropriate operator for per field criteria.
     */
    open fun getValuesAsAdvancedCriteria(textMatchStyle: 
                                                         /**
                                                          *  case-insensitive exact match ("foo" matches "foo" and "FoO", but not "FooBar")
                                                          *  case-sensitive exact match ("foo" matches only "foo")
                                                          *  case-insenstive substring match ("foo" matches "foobar" and "BarFoo")
                                                          *  case-insensitive prefix match ("foo" matches "FooBar" but not "BarFoo")
                                                          *   textMatchStyle behavior is consistent across the client and all three of the built-in
                                                          *   server DataSource implementations - SQL, Hibernate and JPA - to the maximum extent that is
                                                          *   practical. Known inconsistencies, some of which can be tweaked with configuration settings,
                                                          *   are described below
                                                          * 
                                                          *  - textMatchStyle can be disabled for any individual field with the
                                                          *   DataSourceField.ignoreTextMatchStyle declaration. This behavior is consistent
                                                          *   across client and server implementations, with the proviso that case-sensitive behavior
                                                          *   is inherently inconsistent in the server-side implementations (see below for a more
                                                          *   detailed discussion of this)
                                                          * 
                                                          *  - textMatchStyle is forced to "exactCase" for DataSourceField.primaryKey
                                                          *   fields on update and remove operations, unless
                                                          *   OperationBinding.allowMultiUpdate is in force. This means that a normal update
                                                          *   or remove operation - which is constrained by a unique primaryKey value or combination, to
                                                          *   affect only a single data row - will use an equality match on all primaryKey fields. This
                                                          *   is desirable because it makes index usage more likely. Note that this means the key values
                                                          *   "foo" and "FOO" are distinct, which is a change from previous behavior. For most databases,
                                                          *   this change will have no effect because most databases do not by default allow primaryKey
                                                          *   values that only differ in case anyway - if a table has a row with a PK of "foo" and you
                                                          *   try to insert a row with a PK of "FOO", most databases will fail with a constraint violation.
                                                          *   However, if you are using a database hat allows key values that differ only in case, and you
                                                          *   need to support this for some reason, you can switch the framework back to the previous
                                                          *   behavior by setting property allow.case.sensitive.pks to true in
                                                          *   your server.properties file. Note, we do not recommend this; in fact, we do
                                                          *   not recommend the use of text primaryKey fields at all. Where you have control ,we would
                                                          *   always recommend the use of automatically incrementing numeric sequence keys.
                                                          * 
                                                          *  - textMatchStyle does not apply to boolean or temporal (date, datetime, time)
                                                          *   DataSourceField.type. Such fields are always checked for equality. If
                                                          *   you have a need for more complex matching, such as date-range checking, use AdvancedCriteria
                                                          * 
                                                          *  - Critiera values for temporal fields must be real dates (Javascript Date
                                                          *   objects on the client, instances of java.util.Date on the server). Attempting
                                                          *   to match against a string or any other type of value will result in an "always fails"
                                                          *   clause being generated. This behavior is how the client code has always worked, but is a
                                                          *   change for the server-side DataSources, in the interests of consistency. The previous
                                                          *   behavior was:
                                                          * 
                                                          *  - SQLDataSource used to attempt to match the date column to the criteria value provided;
                                                          *    if that value was an appropriately-formatted string, that attempt might have
                                                          *    worked, but it would be database-specific. If you have an application that depends on
                                                          *    this old behavior, you can switch it back on by adding the following to your
                                                          *    server.properties file:
                                                          *    sql.temporal.fields.require.date.criteria: false
                                                          * 
                                                          *  - HibernateDataSource and JPADataSource used to skip such clauses altogether, which
                                                          *    results in the opposite behavior (there is an implied "always succeeds" clause, because
                                                          *    the clause is not present in the query at all). If you have an application that depends on
                                                          *    this old behavior, you can switch it back on by adding the following to your
                                                          *    server.properties file:
                                                          *    jpa.temporal.fields.require.date.criteria: false or
                                                          *    hibernate.temporal.fields.require.date.criteria: false, as appropriate
                                                          * 
                                                          * 
                                                          *  - textMatchStyle does not apply to fields used in the joins generated to satisfy
                                                          *   DataSourceField.includeFrom declarations or entity relations in
                                                          *   Hibernate or JPA. Again, such comparisons are always for equality
                                                          * 
                                                          *  - textMatchStyle is applied to numeric fields only if the supplied criteria value
                                                          *   is a string. So for a numeric field "myNumber", we will match 10, 100, 110 and 1000 if a
                                                          *   criteria value of "10" (the quoted string) is supplied, but we will only match 10 if a
                                                          *   criteria value of 10 (the actual number) is supplied
                                                          * 
                                                          *  - This is a change in behavior for the server-side DataSource implementations, in the
                                                          *    interests of consistency with the client behavior. Previously, all three of the built-in
                                                          *    DataSource implementations applied textMatchStyle to numeric fields regardless of the
                                                          *    criteria value's type. If you have an application that depends on this old behavior,
                                                          *    you can switch it back on by adding the following to your server.properties
                                                          *    file: sql.substring.numeric.criteria: true or
                                                          *    hibernate.substring.numeric.criteria: true or
                                                          *    jpa.substring.numeric.criteria: true, as appropriate
                                                          * 
                                                          * 
                                                          *  - "exactCase" matching cannot be made consistent across all database providers because
                                                          *   each database has its own idea of whether case-sensitive matching should be the default,
                                                          *   and how to switch it on and off (if that is even possible)
                                                          * 
                                                          *  - Microsoft SQL Server must have case-sensitive matching enabled by setting a
                                                          *    case-sensitive collation when the database is created (there are more fine-grained
                                                          *    options, but we do not recommend them because of the scope for further inconsistency,
                                                          *    where "exactCase" works correctly on table A but not on table B). See
                                                          *    MSDN for details
                                                          * 
                                                          *  - HSQLDB has case sensitivity set with the SET IGNORECASE directive -
                                                          *    see here
                                                          * 
                                                          *  - MySQL is case-insensitive, but since it provides an easy way to do per-query,
                                                          *    case-sensitive matching in SQL, we work around it for that database, but only in
                                                          *    SQL DataSources
                                                          * 
                                                          * 
                                                          *  - If you are using Hibernate or JPA, whether "exactCase" works as expected depends
                                                          *   entirely on the underlying database. Unlike the SQL DataSource, where we have fine-grained
                                                          *   control of the SQL that the database executes, we are constrained by what the ORM will
                                                          *   allow. This prevents us from compensating for database quirks, like we do with MySQL's
                                                          *   case-insensitivity in the SQL DataSource
                                                          * 
                                                          */
                                                         String /* exact |  exactCase |  substring |  startsWith */?): AdvancedCriteria = definedExternally
    /**
     *     Make a snapshot of the current set of values, so we can reset to them later.
     *     Creates a new object, then adds all non-method properties of values
     *     to the new object. Use resetValues() to revert to these values.
     *       Note that this method is automatically called when the values for this form are
     *       set programmatically via a call to DynamicForm.setValues.
     * 
     * 
     */
    open fun rememberValues(): dynamic = definedExternally
    /**
     *   Returns the set of values last stored by DynamicForm.rememberValues.
     *   Note that rememberValues() is called automatically by
     *   DynamicForm.setValues, and on form initialization, so this typically contains
     *   all values as they were before the user edited them.
     * 
     * 
     */
    open fun getOldValues(): dynamic = definedExternally
    /**
     *   Returns all values within this DynamicForm that have changed since
     *   DynamicForm.rememberValues last ran. Note that DynamicForm.rememberValues
     *   runs on dynamicForm initialization, and with every call to DynamicForm.setValues
     *   so this will typically contain all values the user has explicitly edited since then.
     * 
     */
    open fun getChangedValues(): dynamic = definedExternally
    /**
     * 
     *   Same as DynamicForm.reset.
     * 
     * 
     */
    open fun resetValues(): Unit = definedExternally
    /**
     *   Compares the current set of values with the values stored by the call to the
     *   DynamicForm.rememberValues method. rememberValues() runs when the
     *   form is initialized and on every call to DynamicForm.setValues.
     *   Returns true if the values have changed, and false otherwise.
     * 
     */
    open fun valuesHaveChanged(): Boolean = definedExternally
    /**
     *   Returns the value for some field.
     * 
     *  @param {string} Which value to be returned
     *  @param {Canvas=} Optional, the component for which we are trying to                 retrieve a value. This is used to identify which of                  the potential records to use when the ValuesManager                  is managing a complex structure involving nested Lists
     */
    open fun getValue(fieldName: String, component: Canvas?): dynamic = definedExternally
    /**
     *   Set the value for some field.
     * 
     *  @param {string} Which field to set the value for
     *  @param {any} New value for the field.
     */
    open fun setValue(fieldName: String, newValue: dynamic): Unit = definedExternally
    /**
     *   Clear the value for some field.
     * 
     *  @param {string} Which field to set the value for
     */
    open fun clearValue(fieldName: String): Unit = definedExternally
    /**
     * 
     *   Add a new member to this valuesManager. Any Canvas can be a member of a
     *   valuesManager, even components like Layout or TabSet that do
     *   not actually have any values to manage. When "valueless" components like these bind to
     *   a ValuesManager, it is in order to provide their own child components with a shared
     *   valuesManager so that complex data can be displayed and edited - see
     *   DataPath for more details.
     * 
     *   For components like DynamicForm and ListGrid, which do have
     *   a set of values to manage, the component's values will subsequently be available through
     *   this valuesManager.
     * 
     *   Note on pre-existent values when the member component is a DynamicForm:
     *   If the valuesManager has a value specified for some field, for which the member form has
     *   an item, this value will be applied to the member form. This is true whether the item
     *   has a value or not.
     *   However if the member form has a value for some field, and the ValuesManager does not
     *   have a specified value for the same field, we allow the valuesManager to pick up the
     *   value from the member form.
     * 
     *   Caution: If a DynamicForm without a DataSource is passed to this method,
     *   DataBoundComponent.setDataSource will be called on that form, recreating the
     *   items from copies of the item configuration stored at the time the form was created.
     *   This means that any properties or handlers added to the items after form creation
     *   will be lost. When in doubt, set the DataSource in the form as soon as possible.
     * 
     * 
     *  @param {DynamicForm | string} component (or ID of component) to add to                      this valuesManager as a member.
     */
    open fun addMember(member: dynamic): Unit = definedExternally
    /**
     *   Add multiple new member forms to this valuesManager.
     * 
     *  @param {Array<Partial<DynamicForm>>} array of forms to add to this valuesManager as members.
     */
    open fun addMembers(members: Array<dynamic>): Unit = definedExternally
    /**
     *   Remove a member form from this valuesManager, so its values are no longer managed
     *   by this instance.
     *   This does not clear the values associated with the form from the valuesManager - they
     *   will still be available via valuesManager.getValues(), but will not be
     *   updated as the form is manipulated.
     * 
     *  @param {DynamicForm | string} form (or ID of form) to remove from this valuesManager
     */
    open fun removeMember(member: dynamic): Unit = definedExternally
    /**
     *   Remove multiple member forms from this valuesManager.
     * 
     *  @param {Array<Partial<DynamicForm>>} array of forms to remove
     */
    open fun removeMembers(members: Array<dynamic>): Unit = definedExternally
    /**
     *   Method to display validation error messages for a valuesManager when there is not
     *   currently visible form item displaying the errors.
     *   This will be called when validation fails for
     *   - a field in a hidden or undrawn member form
     *   - a hidden field in a visible member form
     *   - for databound ValuesManagers, a datasource field with specified validators, but not
     *    associated item in any member.
     *   Implement this to provide custom validation error handling for these fields.
     *   By default hidden validation errors will be logged as warnings in the developerConsole.
     *   Return false from this method to suppress that behavior.
     * 
     *  @param {object} The set of errors returned - this is an object of the form           &nbsp;&nbsp;{fieldName:errors}            Where the 'errors' object is either a single string or an array            of strings containing the error messages for the field.
     */
    open fun handleHiddenValidationErrors(errors: dynamic): Boolean = definedExternally
    /**
     *   Optional stringMethods to fire when ValuesManager.submit is called
     *   on this valuesManager (or any form included in this valuesManager).
     * 
     * 
     *  @param {object} the valuesManager values
     *  @param {ValuesManager} the valuesManager being submitted
     */
    open fun submitValues(values: dynamic, valuesManager: ValuesManager): Unit = definedExternally
    /**
     *   Handler fired whenever a change to a FormItem fires itemChanged() on one of the
     *   member forms. Fires after that event.
     * 
     * 
     *  @param {FormItem} the FormItem where the change event occurred
     *  @param {any} new value for the FormItem
     */
    open fun itemChanged(item: FormItem, newValue: dynamic): Unit = definedExternally
    /**
     * 
     *   Prepare to edit a new record by clearing the current set of values (or replacing them
     *   with initialValues if specified).
     * 
     *   This method will also call DynamicForm.setSaveOperationType to ensure
     *   subsequent calls to saveData() will use an add rather than
     *   an update operation.
     * 
     * 
     *  @param {object | Record=} initial set of values for the editor as a map of field names to their corresponding   values
     */
    open fun editNewRecord(initialValues: dynamic?): Unit = definedExternally
    /**
     * 
     *   Edit an existing record. Updates this editors values to match the values of the record
     *   passed in, via ValuesManager.setValues.
     * 
     *   This method will also call DynamicForm.setSaveOperationType to ensure
     *   subsequent calls to saveData() will use an update rather than
     *   an add operation.
     * 
     * 
     *  @param {Record} the record to be edited as a map of field names to their corresponding values
     */
    open fun editRecord(record: Record): Unit = definedExternally
    /**
     *   Setter for the default DSOperationType when DynamicForm.saveData is called.
     *   Note that this property can also be set by calling DynamicForm.editRecord or
     *   DynamicForm.editNewRecord
     * 
     * 
     *  @param {DSOperationType} Operation type to use as a default. Valid values are "add" or "update".
     */
    open fun setSaveOperationType(operationType: 
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
                                                 String /* fetch |  add |  update |  remove |  custom |  validate |  viewFile |  downloadFile |  storeTestData |  clientExport |  getFile |  hasFile |  listFiles |  removeFile |  saveFile |  renameFile |  getFileVersion |  hasFileVersion |  listFileVersions |  removeFileVersion */): Unit = definedExternally
    /**
     *   Returns true if ValuesManager.saveOperationType is currently "add". See
     *   ValuesManager.saveOperationType.
     * 
     * 
     */
    open fun isNewRecord(): Boolean = definedExternally
    /**
     *   Returns the DSOperationType to be performed when DynamicForm.saveData is
     *   called. Valid options are "add" or "update".
     * 
     *   If a DSRequest configuration object is passed in containing an explicit operationType
     *   this will be returned. Otherwise DynamicForm.saveOperationType will be returned.
     *   This attribute is automatically set via calls to data binding methods such as
     *   DynamicForm.editNewRecord, or it may be set explicitly.
     * 
     *   If no explicit saveOperationType is specified for this form, the system will
     *   look at the current values for the form. If the form has no value for
     *   the DataSource.getPrimaryKeyField, or that field is
     *   editable and has been modified we assume an add operation, otherwise an update.
     *   If the form is a member of a ValuesManager, the primary key field value
     *   will be derived from the valuesManager's values object.
     * 
     * 
     *  @param {DSRequest=} Optional DSRequest config block for the save operation
     */
    open fun getSaveOperationType(requestProperties: DSRequest?): 
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
     * 
     *   Edit the record selected in the specified selection component (typically a
     *   ListGrid).
     * 
     *   Updates the values of this editor to match the selected record's values.
     * 
     *   If this form has a dataSource, then saving via ValuesManager.saveData will use the
     *   "update" operation type.
     * 
     * 
     *  @param {ListGrid | GlobalId} the ListGrid or ID of a ListGrid whose currently selected   record(s) is/are to be edited
     */
    open fun editSelectedData(selectionComponent: dynamic): Unit = definedExternally
    /**
     * 
     *   Validate and then save the form's current values to the DataSource this form is
     *   bound to.
     * 
     *   If client-side validators are defined, they are executed first, and if any errors are
     *   found the save is aborted and the form will show the errors.
     * 
     *   If client-side validation passes, a DSRequest will be sent, exactly as though
     *   DataSource.addData or DataSource.updateData had been called with
     *   ${isc.DocUtils.linkForRef('method:DynamicForm.getValues','the form\'s values')} as data. The
     *   DSRequest.operationType will be either "update" or "add", depending on the
     *   current DynamicForm.saveOperationType.
     * 
     *   On either a client-side or server-side validation failure, validation errors will be
     *   displayed in the form. Visible items within a DynamicForm will be redrawn to display
     *   errors. Validation failure occurring on hidden items, or DataSource fields with no
     *   associated form items may be handled via DynamicForm.handleHiddenValidationErrors
     *   or ValuesManager.handleHiddenValidationErrors.
     * 
     *   In the case of a validation error, the callback will not be called by default
     *   since the form has already handled the failed save by displaying the validation errors
     *   to the user. If you need to do something additional in this case, you can set
     *   RPCRequest.willHandleError via the requestProperties parameter to
     *   force your callback to be invoked. However, first consider:
     * 
     * 
     *  - if you are trying to customize display of validation errors, there are several
     *   DynamicForm.showErrorIcons and DynamicForm.showErrors may be a better
     *   place to put customizations.
     * 
     *  - for unrecoverable general errors (eg server is down),
     *   RPCManager.handleError in invoked, so consider placing
     *   customizations there unless an unrecoverable error should be handled specially by this
     *   specific form.
     * 
     * 
     * 
     *  @param {DSCallback=} callback to invoke on completion
     *  @param {DSRequest=} additional properties to set on the DSRequest                      that will be issued
     */
    open fun saveData(callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   submit() is automatically called when a SubmitItem in a member form
     *   is clicked, or if DynamicForm.saveOnEnter is set for some member form,
     *   when the
     *   "Enter" key is pressed in a text input. Submit can also be manually called.
     * 
     *   If ValuesManager.submitValues exists, it
     *   will be called, and no further action will be taken.
     * 
     *   Otherwise, ValuesManager.saveData will be called to
     *   handle saving via SmartClient databinding.
     * 
     *   The parameters to submit() apply only if submit() will be
     *   calling ValuesManager.saveData. If you override submit(), you can safely
     *   ignore the parameters as SmartClient framework code does not pass them.
     * 
     * 
     *  @param {DSCallback=} callback to invoke on completion.
     *  @param {DSRequest=} additional properties to set on the DSRequest                     that will be issued
     */
    open fun submit(callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     * 
     *   This method exists for clean integration with existing server frameworks that have a 'cancel'
     *   feature which typically clears session state associated with the form. When this method is
     *   called, an RPC is sent to the server with a parameter named
     *   DynamicForm.cancelParamName with the value
     *   DynamicForm.cancelParamValue.
     * 
     *   Note that no other form data is sent. By default the current top-level page is replaced with the
     *   reply. If you wish to ignore the server reply instead, call this method like this:
     * 
     *   dynamicFormInstance.cancel({ignoreTimeout: true, target: null});
     * 
     * 
     *  @param {DSRequest=} additional properties to set on the RPCRequest                     that will be issued
     */
    open fun cancel(requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Retrieve data that matches the provided criteria, and edit the first record returned.
     *   Differs from DynamicForm.fetchData in that a case insensitive substring match
     *   will be performed against the criteria to retrieve the data.
     * 
     * 
     *  @param {Criteria=} search criteria
     *  @param {DSCallback=} callback to invoke on completion
     *  @param {DSRequest=} additional properties to set on the DSRequest                      that will be issued
     */
    open fun filterData(criteria: dynamic?, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Retrieve data that matches the provided criteria, and edit the first record returned
     * 
     * 
     *  @param {Criteria=} search criteria
     *  @param {DSCallback=} callback to invoke on completion
     *  @param {DSRequest=} additional properties to set on the DSRequest                      that will be issued
     */
    open fun fetchData(criteria: dynamic?, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    companion object {
        /**
         *  Creates a new ValuesManager
         * 
         *  @param typeCheckedProperties {Partial<ValuesManager>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ValuesManager} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ValuesManager = definedExternally
        /**
         *   Retrieve a ValuesManager by it's global Canvas.ID.
         * 
         *  @param {string} global ID of the ValuesManager
         */
        fun getById(ID: String): ValuesManager = definedExternally
    }
}