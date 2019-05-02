@file:JsQualifier("isc")
package isc

/**
 *  The MultiFileItem provides an interface for a user to save one or more files that are
 *   related to a DataSource record, where each file is represented by a record in a
 *   related DataSource.
 * 
 *   Use MultiFileItem when a record may have one or more files associated with it (such as
 *   attachments to an email message) where no information about the files needs to be stored other
 *   than the files themselves. If you have several fields associated with each file (such as an
 *   uploaded document with a version, comments and processes associated with it), consider
 *   instead an ordinary DataSource with on field of type "binary", and using the FileItem
 *   for upload.
 * 
 *   See the upload overview for more information on upload.
 * 
 *   DataSource Setup
 * 
 *   In a relationship sometimes called a "master-detail" relationship, the MultiFileItem stores
 *   files in a "detail" DataSource which are related to a "master" DataSource record being
 *   edited by the form which contains the MultiFileItem.
 * 
 *   To use a MultiFileItem:
 * 
 * 
 *  - declare a "detail" DataSource to store the related files. At a minimum, this
 *   DataSource must have:
 * 
 * 
 *  - a DataSourceField.primaryKey field
 * 
 *  - a field declaring a DataSourceField.foreignKey relationship to the
 *   primaryKey of the "master" DataSource
 * 
 *  - a field of type "binary"
 * 
 * 
 *  - DataBoundComponent.dataSource a DynamicForm to the "master" DataSource
 * 
 *  - in the DynamicForm bound to the "master" DataSource, declare a field with
 *   FormItem.editorType:"MultiFileItem" and a dataSource
 *   property set to the ID of the "detail" DataSource
 * 
 *   An example "detail" DataSource for storing files is shown below. This "detail" DataSource
 *   assumes a "master" DataSource with DataSource.ID "masterRecord" and with a primaryKey
 *   field "id".
 * 
 * 
 *    &lt;DataSource ID="uploadedFiles" serverType="sql"&gt;
 *     &lt;fields&gt;
 *      &lt;field name="fileId" type="sequence" primaryKey="true" hidden="true"/&gt;
 *      &lt;field name="masterRecordId" type="number" foreignKey="masterRecord.id" hidden="true"/&gt;
 *      &lt;field name="file" type="binary" title="File"/&gt;
 *     &lt;/fields&gt;
 *    &lt;/DataSource&gt;
 * 
 * 
 * 
 *   Aside from a single "binary" field, the "detail" DataSource should generally have only
 *   hidden fields, as shown above. Additional internal fields (such as a "lastUpdated" field)
 *   may be added, but will not be editable via MultiFileItem.
 * 
 *   Display
 * 
 *   The MultiFileItem appears as a list of files related to the current record. An optional
 *   button, the MultiFileItem.removeButton allows removing files. A
 *   second optional button, the MultiFileItem.editButton, launches a
 *   picker for uploading further files.
 * 
 *   Saving
 * 
 *   In all cases, uploading a new file is an "add" DSRequest against the
 *   MultiFileItem.dataSource.
 * 
 *   The MultiFileItem has two modes, according to whether the "master" record is being newly created
 *   via an "add" operation or whether the master record is pre-existing ("update" operation).
 * 
 *   If the master record is pre-existing, each file added by the user is uploaded as soon as the
 *   user exits the picker launched from the edit button, and the list of files shown in the main
 *   form reflects the actual list of stored files.
 * 
 *   If the master record is being newly created, files are not actually uploaded until
 *   after the master record is confirmed saved, and the list of fields shown in the main
 *   form reflects files which will be uploaded after the master record is saved.
 * 
 *   In both cases, if there are multiple files to upload, they are uploaded one at a time, as a
 *   series of separate "add" DSRequests against the MultiFileItem.dataSource.
 * 
 *   Also in both cases, deletion of any file is immediate. In the case of a pre-existing master
 *   record, all files shown actually exist as DataSource records, and deletion is performed as a
 *   "remove" DSRequest against the MultiFileItem.dataSource.
 */
open external class MultiFileItem : CanvasItem {
    /**
     *  DataSource where files are stored.
     * 
     *   This DataSource is expected to have a field of type "binary" as well as a primaryKey and
     *   foreignKey declaration to some other DataSource; see the MultiFileItem for an
     *   overview.
     * 
     *   This DataSource need only be capable of "fetch", "add" and "remove" - "update" is unused.
     *  @type {DataSource | GlobalId}
     *  @default null
     */
    open var dataSource: dynamic = definedExternally
    /**
     *  Button for removing files. Supports the properties of a FormItemIcon.
     *  @type {StatefulCanvas}
     *  @default null
     */
    open var removeButton: StatefulCanvas = definedExternally
    /**
     *  Button for launching a picker to add new files for upload. Supports the properties of a
     *   FormItemIcon.
     *  @type {StatefulCanvas}
     *  @default null
     */
    open var editButton: StatefulCanvas = definedExternally
    /**
     *  MultiFileItems use a MultiFilePicker instance as their picker.
     *   The generated picker autoChild may be customized via the standard
     *   AutoChild pattern.
     *  @type {SCClassName}
     *  @default "MultiFilePicker"
     */
    override var pickerConstructor: String = definedExternally
    /**
     *  Empty message to display when there are no files listed.
     *  @type {string}
     *  @default "Click icon to add..."
     */
    open var emptyMessage: String = definedExternally
    /**
     *  The FormItemIcon.prompt of the MultiFileItem.editButton.
     *  @type {string}
     *  @default "Add files"
     */
    open var editButtonPrompt: String = definedExternally
    /**
     *  The FormItemIcon.prompt of the MultiFileItem.removeButton.
     *  @type {string}
     *  @default "Remove selected files"
     */
    open var removeButtonPrompt: String = definedExternally
    /**
     *  The initial title of the upload button in the picker lauched by the
     *   MultiFileItem.editButton that is used before the form is saved.
     *  @type {string}
     *  @default "OK"
     */
    open var pickerUploadButtonInitialTitle: String = definedExternally
    /**
     *  The title of the upload button in the picker lauched by the
     *   MultiFileItem.editButton that is used after the form is saved.
     *  @type {string}
     *  @default "Save"
     */
    open var pickerUploadButtonTitle: String = definedExternally
    /**
     *  The title of the cancel button in the picker lauched by the
     *   MultiFileItem.editButton.
     *  @type {string}
     *  @default "Cancel"
     */
    open var pickerCancelButtonTitle: String = definedExternally
    /**
     *  The contents of the "Add another" file button in the picker launched by the
     *   MultiFileItem.editButton.
     *  @type {HTMLString}
     *  @default "&lt;u&gt;Add&amp;nbsp;another&lt;/u&gt;"
     */
    open var pickerAddAnotherFileButtonTitle: String = definedExternally
    /**
     *  Specifies the label of the progress meter in the picker lauched by the
     *   MultiFileItem.editButton. This property is a dynamic string, similar to the
     *   Canvas.dynamicContents feature, with the variables fileName and
     *   formattedFileSize.
     *  @type {HTMLString}
     *  @default "Saving ${fileName} ${formattedFileSize}"
     */
    open var pickerUploadProgressLabel: String = definedExternally
    companion object {
        /**
         *  Creates a new MultiFileItem
         * 
         *  @param typeCheckedProperties {Partial<MultiFileItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {MultiFileItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): MultiFileItem = definedExternally
    }
}