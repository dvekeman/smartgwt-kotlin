@file:JsQualifier("isc")
package isc

/**
 *  Binary data interface for use in DynamicForms. Allows users to select a single file for
 *   upload. In read-only mode (canEdit:false), can display the contents of "imageFile" fields.
 * 
 * 
 *   Editable mode
 * 
 *   The FileItem.editForm will be automatically generated and displayed as
 *   CanvasItem.canvas, allowing the user to select file(s) to upload.
 * 
 *   See the upload for information on using this control.
 * 
 * 
 *   Read-only mode
 * 
 *   For fields of type "blob" the raw data value will be displayed in the
 *   generated FileItem.displayForm.
 * 
 *   For other fields, the FileItem.displayCanvas will be displayed.
 * 
 *   For "imageFile" fields with FileItem.showFileInline
 *   set to true, the image-file will be streamed and displayed inline within the displayCanvas.
 * 
 *   Otherwise, the displayCanvas will render out FileItem.viewIconSrc and
 *   FileItem.downloadIconSrc icons and the fileName.
 */
open external class FileItem : CanvasItem {
    /**
     *  Should this item's value be saved in the form's values and hence returned from
     *   DynamicForm.getValues?
     * 
     *   shouldSaveValue:false is used to mark formItems which do not correspond to
     *   the underlying data model and should not save a value into the form's
     *   DynamicForm.values. Example includes visual separators, password re-type fields,
     *   or checkboxes used to show/hide other form items.
     * 
     *   A shouldSaveValue:false item should be given a value either via
     *   FormItem.defaultValue or by calling
     *   DynamicForm.setValue or
     *   FormItem.setValue. Providing a value via
     *   DynamicForm.values or DynamicForm.setValues
     *   will automatically switch the item to shouldSaveValue:true.
     * 
     *   Note that
     * 
     *  - if an item is shouldSaveValue true, but has no name, a warning is logged, and
     *     shouldSaveValue will be set to false.
     * 
     *  @type {boolean}
     *  @default true
     */
    override var shouldSaveValue: Boolean = definedExternally
    /**
     *  When true, allow the file-selection dialog shelled by the browser to select multiple
     *   files.
     * 
     *   Support is not full-cycle at the server - that is, there are server APIs for retrieving
     *   each file that was uploaded, but no built-in support for storing multiple files against
     *   a single DataSource field. However, you can write custom server DMI code to do
     *   something with the files - for instance, you could create multiple new DataSource
     *   records for each file via a server DMI like this below:
     * 
     * 
     *    String fileNameStr = (String)dsRequest.getValues().get("image_filename").toString();
     * 
     *    String[] fileNames = fileNameStr.split(", ");
     *    List files = dsRequest.getUploadedFiles();
     * 
     *    for (int i = 0; i
     *  @type {boolean}
     *  @default true
     */
    override var multiple: Boolean = definedExternally
    /**
     *  A comma-separated list of valid MIME types, used as a filter for the file picker window.
     *  @type {string}
     *  @default null
     */
    open var accept: String = definedExternally
    /**
     *  Indicates whether to stream the image and display it
     *   inline or to display the View and Download icons.
     *  @type {boolean}
     *  @default null
     */
    open var showFileInline: Boolean = definedExternally
    /**
     *  The DynamicForm created automatically when FormItem.canEdit
     *   is true. Displays a single FileItem.uploadItem for manipulating a file.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   fileItem.editFormDefaults and
     *   fileItem.editFormProperties.
     * 
     *  @type {DynamicForm}
     *  @default null
     */
    open var editForm: DynamicForm = definedExternally
    /**
     *  The UploadItem created automatically and displayed in the
     *   FileItem.editForm when FormItem.canEdit is true.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   fileItem.uploadItemDefaults and
     *   fileItem.uploadItemProperties.
     * 
     *  @type {UploadItem}
     *  @default null
     */
    open var uploadItem: UploadItem = definedExternally
    /**
     *  The DynamicForm created automatically when FormItem.canEdit
     *   is false and the field is of type "blob". Displays a single
     *   FileItem.displayItem for viewing the content of a blob file.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   fileItem.displayFormDefaults and
     *   fileItem.displayFormProperties.
     *  @type {DynamicForm}
     *  @default null
     */
    open var displayForm: DynamicForm = definedExternally
    /**
     *  The StaticTextItem created automatically and displayed in the
     *   FileItem.displayForm when FormItem.canEdit is false and the field type is
     *   "blob".
     * 
     *   This component is an AutoChild and as such may be customized via
     *   fileItem.displayItemDefaults and
     *   fileItem.displayItemProperties.
     * 
     *  @type {StaticTextItem}
     *  @default null
     */
    open var displayItem: StaticTextItem = definedExternally
    /**
     *  The Canvas created automatically when FormItem.canEdit
     *   is false and the field is of any type other than "blob".
     * 
     *   If the field is of type "imageFile", and FileItem.showFileInline
     *   is true, the contents of the canvas are set to HTML that streams the image file for
     *   display. Otherwise, the item renders icons that allow the file to be
     *   FileItem.viewIconSrc or FileItem.downloadIconSrc.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   fileItem.displayCanvasDefaults and
     *   fileItem.displayCanvasProperties.
     *  @type {Canvas}
     *  @default null
     */
    open var displayCanvas: Canvas = definedExternally
    /**
     *  Returns the URL for an Icon that will allow the file to be viewed.
     *  @type {SCImgURL}
     *  @default "[SKIN]actions/view.png"
     */
    open var viewIconSrc: String = definedExternally
    /**
     *  Returns the URL for an Icon that will allow the file to be downloaded
     *  @type {SCImgURL}
     *  @default "[SKIN]actions/download.png"
     */
    open var downloadIconSrc: String = definedExternally
    /**
     *   Updates the FileItem.multiple setting at runtime, propagating it to the Browser's
     *   file dialog. Causes a redraw.
     * 
     * 
     *  @param {boolean} the HTML of the view link
     */
    open fun setMultiple(multiple: Boolean): Unit = definedExternally
    companion object {
        /**
         *  Creates a new FileItem
         * 
         *  @param typeCheckedProperties {Partial<FileItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {FileItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): FileItem = definedExternally
    }
}