@file:JsQualifier("isc")
package isc

/**
 *  The BatchUploader handles the upload, validation, review and saving of a dataset
 *   expressed in CSV or other upload formats.
 * 
 *   NOTE: BatchUploader is only available with SmartClient Power or better.
 * 
 *   By default, a BatchUploader consists of a single FileItem form field.
 *   This form field will upload a file using the special "batchUpload" built-in DataSource.
 *   The uploaded file data will be parsed and validated using the
 *   BatchUploader.uploadDataSource,
 *   then streamed back to the browser, along with any errors, for display in a ListGrid.
 * 
 *   The BatchUploader.previewShown notification method will be fired when the uploaded records
 *   are being displayed in this grid.
 * 
 *   The user can then correct any errors and submit the final dataset, which will be
 *   added to the DataSource via a series of "add" DSRequests, all submitted as a single
 *   HTTP request via RPCManager.startQueue.
 *   Developers may specify a custom "add" operation to use on the target
 *   BatchUploader.uploadDataSource via the BatchUploader.uploadOperation
 *   property.
 * 
 *   Additional form fields can be added to the form that uploads the data file via
 *   BatchUploader.uploadFormFields. Values entered into these fields
 *   are not included in the "add" DSRequests used to store the uploaded records. Instead, they
 *   are stored as HttpSession attributes with the names corresponding to the
 *   names of the specified uploadFormFields (optionally with a
 *   BatchUploader.uploadFieldPrefix applied, in case
 *   this is necessary to avoid name collisions in the session). This allows any custom logic
 *   for the "add" operation to access these additional fields via httpSession.getAttribute().
 *   If BatchUploader.uploadFormFields are not provided method
 *   httpSession.getAttribute() will not be called.
 * 
 *   Because all records are saved in a single HTTP request, a similar strategy of
 *   storing data as servletRequest or session attributes allows reuse of objects required to
 *   perform the "add" operations (such as field values common to all added records,
 *   or a SQL connection or transaction manager).
 * 
 *   If DataSourceField.uploadFieldName is set on any of the
 *   BatchUploader.uploadDataSource's fields, the BatchUploader will use
 *   that name to map the uploaded file's content.
 * 
 *   Note, that for BatchUploader.dataFormat header line is optional. If
 *   first non-empty line in the uploaded file has no matching field names, it is assumed that
 *   there's no header row, and all rows (including the first one) are treated as data rows.
 * 
 *   Imported data can be transformed during import, see DataSourceField.importStrategy for details.
 * 
 *   A couple of server-side techniques are interesting in conjunction with the BatchUploader.
 *   One is to set the DataSource.serverConstructor property to point at your own class
 *   that inherits from com.isomorphic.datasource.BasicDataSource. The most interesting
 *   reason for doing this is to override the validate method and provide complete
 *   custom validation - for example, checking relations to other tables.
 * 
 *   Another technique is to handle the initial SmartClient call in your own servlet, by setting the
 *   BatchUploader.dataURL property. You then handle the add requests
 *   with a combination of your own code and SmartClient server API calls. This is a
 *   good way to add special pre- and post-processing to the normal server-side flow.
 * 
 *   Note: The special "batchUpload" DataSource, which should reside in the shared/ds
 *   folder of your application's webroot (see
 *   iscInstall)
 *   .
 *   is not part of your application's data flow, and it has nothing to do with the
 *   BatchUploader.uploadDataSource you use to actually persist the validated
 *   and error-corrected data: it is simply a means to uploading the raw data in the first place.
 *   Normally, you should simply ignore its presence and treat it as an internal detail of the
 *   SmartClient framework.
 * 
 *   However, there are circumstances in which you may wish to change it to achieve specific aims.
 *   For example, you may wish to override the Java class it invokes, in order to insert your own
 *   security or other validation logic into the initial upload flow. This is entirely in keeping
 *   with the design, but we regard it as an out-of-the-ordinary use-case: normal usage is simply
 *   to ignore the presence of the batchUpload DataSource.
 * 
 *   BatchUploader is a VStack, that simply stacks members on the vertical axis without
 *   trying to manage their height. If you need to control heights, you can set
 *   Layout.vPolicy to "fill"
 */
open external class BatchUploader : VStack {
    /**
     *  Form used to specify file to upload, and any additional fields required.
     *  @type {DynamicForm}
     *  @default null
     */
    open var uploadForm: DynamicForm = definedExternally
    /**
     *  DataSource used to save uploaded records. Should have an operation of type "add".
     * 
     *   Be careful to note that this is the DataSource representing your data as it will be
     *   persisted to your server. It is completely different from the special "batchUpload"
     *   DataSource which is used purely as a medium to upload the raw data to the server in
     *   the first place.
     *  @type {DataSource}
     *  @default null
     */
    open var uploadDataSource: DataSource = definedExternally
    /**
     *  Optional DSRequest.operationId for the "add" operation used to add new
     *   records to the BatchUploader.uploadDataSource.
     *  @type {string}
     *  @default null
     */
    open var uploadOperation: String = definedExternally
    /**
     *  Optional fields for the uploadForm.
     *  @type {Array<Partial<FormItem>>}
     *  @default null
     */
    open var uploadFormFields: Array<dynamic> = definedExternally
    /**
     *  Title to display next to the FileItem field where the user enters a filename to upload
     *  @type {string}
     *  @default "Upload File"
     */
    open var uploadFileLabel: String = definedExternally
    /**
     *  Error message to show when the uploading process detects a file with no data.
     *  @type {string}
     *  @default "The provided file is blank. Please, provide a file with data"
     */
    open var errorMessageFileIsBlank: String = definedExternally
    /**
     *  Error message to show when the uploaded file has rows other than the first row that could not be parsed.
     * 
     *   This is a dynamic string - text within &#36;{...} will be evaluated as JS code
     *   when the message is displayed.
     * 
     *   The following variables are available to be used in this message:
     * 
     * 
     *  - goodRowCount: Total rows that were parsed correctly.
     * 
     *  - totalRows: Total rows to be parsed in the uploaded file.
     * 
     *  - firstBadRow: First row that could not be parsed.
     * 
     *  - badRowCount: Total rows that could not be parsed.
     * 
     *  @type {string}
     *  @default "Some rows could not be parsed; the grid below shows ${goodRowCount} of ${totalRows} data rows. Row number ${firstBadRow} was the first row to fail to be parsed."
     */
    open var errorMessageRowsNotParsed: String = definedExternally
    /**
     *  Error message to show when the uploading process detects an unterminated quote string in the first line.
     *  @type {string}
     *  @default "Unterminated quote string - problem found in the first line at character position: ${errorOffset}."
     */
    open var errorMessageUnterminatedQuote: String = definedExternally
    /**
     *  Error message to show when the uploading process detects a missing delimiter or end of line after quoted value in the first line.
     *  @type {string}
     *  @default "Delimiter or end of line expected after quoted value - problem found in the first line at character position: ${errorOffset}."
     */
    open var errorMessageDelimiterOrEndOfLine: String = definedExternally
    /**
     *  Error message to show when the uploading process detects an invalid inputType.
     *  @type {string}
     *  @default "Invalid inputType value was set!"
     */
    open var errorMessageInputType: String = definedExternally
    /**
     *  Error message to show when the uploading process detects an Excel File, which is not supported.
     *  @type {string}
     *  @default "You uploaded an Excel file. Please save your data as a csv file and re-upload"
     */
    open var errorMessageExcelFileDetected: String = definedExternally
    /**
     *  Error message to show when the uploading process is unable to detect the delimiter.
     *  @type {string}
     *  @default "We were unable to guess the delimiter"
     */
    open var errorMessageUndeterminedDelimiter: String = definedExternally
    /**
     *  Message to display after data has been committed, when
     *   BatchUploader.showCommitConfirmation is true.
     *  @type {string}
     *  @default "Records added"
     */
    open var commitConfirmationMessage: String = definedExternally
    /**
     *  Message to display when the user clicks "Commit" but there is nothing we can commit
     *   because every row in the grid has errors
     *  @type {string}
     *  @default "All records have errors; nothing to commit"
     */
    open var allRecordsInErrorMessage: String = definedExternally
    /**
     *  Message to display after data has been committed, when
     *   BatchUploader.showCommitConfirmation is true.
     *  @type {string}
     *  @default "Valid records added; some records remain in error"
     */
    open var partialCommitConfirmationMessage: String = definedExternally
    /**
     *  Message to display if at least one update was rolled back due to errors in another row.
     *   See the DataSource.autoJoinTransactions for details of
     *   SmartClient's automatic transactional updates feature
     *  @type {string}
     *  @default "One or more updates were rolled-back due to errors on other rows"
     */
    open var updatesRolledBackMessage: String = definedExternally
    /**
     *  Whether to show the BatchUploader.commitConfirmationMessage after
     *   data is successfully committed.
     *  @type {boolean}
     *  @default true
     */
    open var showCommitConfirmation: Boolean = definedExternally
    /**
     *  Title for the BatchUploader.uploadButton.
     *  @type {string}
     *  @default "Upload"
     */
    open var uploadButtonTitle: String = definedExternally
    /**
     *  Button that triggers the upload.
     *  @type {IButton}
     *  @default null
     */
    open var uploadButton: IButton = definedExternally
    /**
     *  Grid which will show a preview of data to be uploaded, with errors flagged
     *  @type {ListGrid}
     *  @default null
     */
    open var grid: ListGrid = definedExternally
    /**
     *  Fields to apply to BatchUploader.grid. These will override the field definitions
     *   in the BatchUploader.uploadDataSource on a field by field basis, as described under
     *   DataBoundComponent.fields.
     *  @type {Array<Partial<ListGridField>>}
     *  @default null
     */
    open var gridFields: Array<dynamic> = definedExternally
    /**
     *  Button that commits changes once the user is happy with the data.
     *  @type {IButton}
     *  @default null
     */
    open var commitButton: IButton = definedExternally
    /**
     *  Title for the BatchUploader.commitButton.
     *  @type {string}
     *  @default "Commit"
     */
    open var commitButtonTitle: String = definedExternally
    /**
     *  Button that cancels the uncommitted upload.
     *  @type {IButton}
     *  @default null
     */
    open var cancelButton: IButton = definedExternally
    /**
     *  Title for the BatchUploader.cancelButton.
     *  @type {string}
     *  @default "Cancel"
     */
    open var cancelButtonTitle: String = definedExternally
    /**
     *  Button that scrolls grid to the previous error.
     *  @type {IButton}
     *  @default null
     */
    open var previousButton: IButton = definedExternally
    /**
     *  Title for the BatchUploader.previousButton.
     *  @type {string}
     *  @default "Previous error"
     */
    open var previousButtonTitle: String = definedExternally
    /**
     *  Button that scrolls grid to the next error.
     *  @type {IButton}
     *  @default null
     */
    open var nextButton: IButton = definedExternally
    /**
     *  Title for the BatchUploader.nextButton.
     *  @type {string}
     *  @default "Next error"
     */
    open var nextButtonTitle: String = definedExternally
    /**
     *  Object containing properties to send with every "add" request this batchUploader sends.
     *  @type {object}
     *  @default null
     */
    open var requestProperties: dynamic = definedExternally
    /**
     *  If set, the batchUploader will copy this value to the queue of "add" requests it sends
     *   to the server to actually populate the data. You can use this facility to route the
     *   queue to your own server-side logic, for example to add pre- or post-processing.
     *  @type {string}
     *  @default null
     */
    open var dataURL: String = definedExternally
    /**
     *  String to prepend to the names of the additional fields specified in BatchUploader.uploadFormFields
     *   before they are stored in the HttpSession on the server. This property provides a basic
     *   namespace facility, allowing you to avoid name collisions with existing session attributes.
     * 
     *   Example usage: if you have an additional field called "someDate" and you set
     *   uploadFieldPrefix to "myFields_", your additionalFormField will be available as an
     *   HttpSession attribute called "myFields_someDate"
     *  @type {string}
     *  @default null
     */
    open var uploadFieldPrefix: String = definedExternally
    /**
     *  Specifies what action to take if the user attempts to commit a partially validated set
     *   of data (ie, one that still contains some errors).
     *  @type {PartialCommitOption}
     *  @default "prompt"
     */
    open var partialCommit: 
                            /**
                             *  Silently allow the partial commit to proceed (note that this will result         in the user losing those records that contain errors)
                             *  Pop up a message window showing the          BatchUploader.partialCommitError and prevent the partial commit
                             *  Pop up a confirmation window with the         BatchUploader.partialCommitPrompt and allow the user to choose
                             *           whether or not to proceed
                             *  Commit any records that are error-free and remove them from the         grid. If any records had errors, leave them in the grid and leave the
                             *           grid visible. If no records had errors, run normal cleanup as we would
                             *           for "allow". This option allows the user to fix errors iteratively,
                             *           rather than having to fix everything upfront before committing
                             */
                            String /* allow |  prevent |  prompt |  retain */ = definedExternally
    /**
     *  If BatchUploader.partialCommit is set to "prompt", the text to display to the user in the
     *   confirmation dialog. By default, this text is "There are errors in your data so it
     *   cannot all be saved. If you proceed, you will lose the records with errors. Click 'OK'
     *   to proceed anyway, or 'Cancel' to return to your data"
     *  @type {string}
     *  @default "See below"
     */
    open var partialCommitPrompt: String = definedExternally
    /**
     *  If BatchUploader.partialCommit is set to "prevent", the text to display to the user if they try
     *   to commit a dataset containing errors. By default, this text is "There are errors in your
     *   data. Please correct all errors before clicking Commit"
     *  @type {string}
     *  @default "See below"
     */
    open var partialCommitError: String = definedExternally
    /**
     *  If set, indicates that a warning dialog should be shown when Cancel is clicked, asking
     *   the user to confirm that this is really what they want to do. The actual warning message
     *   is specified with BatchUploader.cancelConfirmMessage
     *  @type {boolean}
     *  @default true
     */
    open var warnOnCancel: Boolean = definedExternally
    /**
     *  Confirmation message to show if the user clicks the "Cancel" button and BatchUploader.warnOnCancel
     *   is true. Defaults to "You will lose any work you have done on this data. Proceed anyway?"
     *  @type {string}
     *  @default "See below"
     */
    open var cancelConfirmMessage: String = definedExternally
    /**
     *  Format to assume for user-provided data. Use ImportFormat "auto" for
     *   auto-detection.
     *  @type {ImportFormat}
     *  @default "csv"
     */
    open var dataFormat: 
                         /**
                          *  XML format: same as that expected by the adminConsole for         DataSource testData
                          *  JSON format: a JSON Array of JSON Objects
                          *  Comma-separated values, or in general delimiter-separated values based         on a provided delimiter.
                          *  Auto-detect format
                          */
                         String /* xml |  json |  csv |  auto */ = definedExternally
    /**
     *  The delimiter to use when importing character-delimited files. The default is
     *   comma (CSV).
     *  @deprecated \* in favor of BatchUploader.uploadDelimiter
     *  @type {string}
     *  @default ","
     */
    open var defaultDelimiter: String = definedExternally
    /**
     *  The delimiter to use when importing character-delimited files. The default is
     *   comma (CSV).
     *  @type {string}
     *  @default ","
     */
    open var uploadDelimiter: String = definedExternally
    /**
     *  The default character used to quote strings.
     *  @deprecated \* in favor of BatchUploader.uploadQuoteString
     *  @type {string}
     *  @default "\""
     */
    open var defaultQuoteString: String = definedExternally
    /**
     *  The character used to quote strings. The default is double quotes.
     *  @type {string}
     *  @default "\""
     */
    open var uploadQuoteString: String = definedExternally
    /**
     *  The encoding to use when importing files. The default is "UTF-8".
     *  @type {string}
     *  @default "UTF-8"
     */
    open var uploadEncoding: String = definedExternally
    /**
     *  If columns were present in the imported data that were discarded because they could not be
     *   matched to any DataSource fields, whether these should be displayed to the user, using the
     *   BatchUploader.discardedColumnsMessage shown within the BatchUploader.uploadStatusMessages component.
     *  @type {boolean}
     *  @default true
     */
    open var displayDiscardedColumns: Boolean = definedExternally
    /**
     *  Message displayed when columns in the imported file were discarded and
     *   BatchUploader.displayDiscardedColumns is true. Within this message, ${discardedColumns} can be
     *   used to show a comma separated list of the column names that were discarded (example:
     *   "price, saleDate, total").
     * 
     *   Default message is: "The following columns in your uploaded file were ignored because they
     *   did not match any of the expected column names: ${discardedColumns}"
     *  @type {string}
     *  @default "..."
     */
    open var discardedColumnsMessage: String = definedExternally
    /**
     *  Container for informational messages that are shown when a user attempts an upload.
     *   Appears above the BatchUploader.grid.
     *  @type {HTMLFlow}
     *  @default null
     */
    open var uploadStatusMessages: HTMLFlow = definedExternally
    /**
     *  FileItem for selecting the file to upload.
     *  @type {FileItem}
     *  @default null
     */
    open var uploadFileItem: FileItem = definedExternally
    /**
     *   Notification method fired when the BatchUploader.grid is populated with
     *   a new set of data for the user to preview before commit.
     * 
     *   This notification occurs after the user has uploaded a new data file, the data
     *   has been processed on the server, and the preview grid populated with the data
     *   ready for committing. Developers may use this notification to examine or modify
     *   the data set to be uploaded. The ListGrid.data object will be populated with
     *   the array of uploaded records, and standard grid APIs such as
     *   ListGrid.getRowErrors, ListGrid.setEditValue, etc may be used
     *   to interact with this data.
     * 
     *   Note that developers wishing to manipulate the uploaded data can also do this
     *   on the server side when user hits the commit button to submit the data to the
     *   BatchUploader.uploadDataSource. This can be achieved by setting the
     *   BatchUploader.uploadOperation to call a custom
     *   DataSource.operationBindings on the target dataSource.
     * 
     * 
     *  @param {ListGrid} The BatchUploader.grid autoChild.
     */
    open fun previewShown(grid: ListGrid): Unit = definedExternally
    companion object {
        /**
         *  Creates a new BatchUploader
         * 
         *  @param typeCheckedProperties {Partial<BatchUploader>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {BatchUploader} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): BatchUploader = definedExternally
    }
}