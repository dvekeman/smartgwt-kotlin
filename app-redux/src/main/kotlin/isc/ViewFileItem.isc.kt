@file:JsQualifier("isc")
package isc

/**
 *  A simple subclass of FileItem for displaying the contents of "imageFile" fields in
 *   DynamicForms.
 * 
 *   Displays one of two UIs, according to the value of
 *   FileItem.showFileInline. If showFileInline is false, this Item
 *   displays the View and Download icons and the filename. Otherwise, it streams the image-file
 *   and displays it inline.
 */
open external class ViewFileItem : FileItem {
    companion object {
        /**
         *  Creates a new ViewFileItem
         * 
         *  @param typeCheckedProperties {Partial<ViewFileItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ViewFileItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ViewFileItem = definedExternally
    }
}