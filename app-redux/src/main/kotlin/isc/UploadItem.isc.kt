@file:JsQualifier("isc")
package isc

/**
 *  FormItem that creates an HTML &lt;input type="file"&gt; control, with an interface that
 *   allows a user to pick a file from his machine to upload to the server.
 * 
 *   NOTE: use FileItem, not UploadItem, if you are using the SmartClient
 *   Server framework. FileItem is much easier to use and addresses all the limitations of
 *   UploadItem discussed below. See the upload overview for
 *   details.
 * 
 *   If a form containing an UploadItem is Canvas.redraw (which may
 *   happen if other form items are shown or hidden, the form is
 *   Canvas.redrawOnResize, or this or other items show validation errors) then
 *   the value in the upload item is lost (because an HTML upload field may not be created with a
 *   value). For this reason, if you are building a form that combines an UploadItem with other
 *   FormItems that could trigger redraw()s, recommended practice is to place each UploadItem in
 *   a distinct DynamicForm instance and create the visual appearance of a single logical form
 *   via combining the DynamicForms in a Layout. For the same reason, do not apply
 *   Validator to UploadItems: if such a validator fails, it will
 *   cause the form to be redrawn and the UploadItem's value to be lost.
 * 
 *   NOTE: Browser-specific behaviors:
 * 
 * 
 *  - while getDisplayValue() can be used to retrieve the filesystem path of the uploaded file on some
 *   browsers, different browsers will return either just the file name without path or the full path. It
 *   is plausible that some browsers may switch behavior in the future to not supply this value at all. Do
 *   not rely on this value.
 * 
 *  - the appearance of the UploadItem is not consistent across browsers and we do not
 *   recommend trying to make it consistent or trying to apply styling to the upload control at all. It is
 *   a potential security problem if an end user is unable to reliably recognize the upload control, hence,
 *   all browsers limit what styling can be applied. Various hacks exists to get further control of
 *   styling, but it is likely these hacks will be broken by browser upgrades in the future.
 * 
 */
open external class UploadItem : TextItem {
    /**
     *  Base CSS class name for this UploadItem's native file input element.
     * 
     *   Note that the customization via CSS of a native file input element allowable by the
     *   browser varies widely; in some browsers on certain platforms, it may be possible to
     *   customize certain CSS properties, but not in others; or, it may be that the CSS property
     *   (e.g. border) is applied differently in some browsers.
     * 
     *   If the textBoxStyle is changed at runtime, FormItem.updateState must be called
     *   to update the visual state. However, calling updateState() will clear any file selected
     *   by the user to be uploaded.
     *  @type {FormItemBaseStyle}
     *  @default "uploadItem"
     */
    override var textBoxStyle: String = definedExternally
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
     *  Width for this uploadItem. Note that SmartClient will not apply this size to the
     *   native HTML &lt;input ...&gt; element written out by this formItem as this leads to
     *   inconsistent appearance across different browsers. The specified width
     *   acts as a minimum cell width for the item.
     *  @type {number}
     *  @default "150"
     */
    override var width: dynamic = definedExternally
    /**
     *  Height for this uploadItem. Note that SmartClient will not apply this size to the
     *   native HTML &lt;input ...&gt; element written out by this formItem as this leads to
     *   inconsistent appearance across different browsers. The specified height
     *   acts as a minimum cell width for the item.
     *  @type {number}
     *  @default "19"
     */
    override var height: dynamic = definedExternally
    /**
     *   Attempting to set the value for an upload form item is disallowed for security reasons.
     *   Therefore this method will just log a warning, and not modify the value of the item.
     * 
     */
    open fun setValue(): Unit = definedExternally
    /**
     *   This method is not supported by UploadItem.
     * 
     */
    override fun getSelectionRange(): Array<dynamic> = definedExternally
    /**
     *   This method is not supported by UploadItem.
     * 
     */
    open fun setSelectionRange(): Unit = definedExternally
    /**
     *   This method is not supported by UploadItem.
     * 
     */
    override fun selectValue(): Unit = definedExternally
    /**
     *   This method is not supported by UploadItem.
     * 
     *  @param {boolean=} By default the text insertion cursor will be moved to the end of the  current value - pass in this parameter to move to the start instead
     */
    override fun deselectValue(start: Boolean?): Unit = definedExternally
    companion object {
        /**
         *  Creates a new UploadItem
         * 
         *  @param typeCheckedProperties {Partial<UploadItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {UploadItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): UploadItem = definedExternally
    }
}