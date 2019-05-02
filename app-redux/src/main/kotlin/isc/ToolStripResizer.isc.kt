@file:JsQualifier("isc")
package isc

/**
 *  Simple subclass of ImgSplitbar with appearance appropriate for a ToolStrip resizer.
 */
open external class ToolStripResizer : ImgSplitbar {
    /**
     *  Path to resizer image.
     *  @type {SCImgURL}
     *  @default "images/ToolStrip/"
     */
    override var skinImgDir: String = definedExternally
    /**
     *  Image for resizer
     *  @type {SCImgURL}
     *  @default "[SKIN]resizer.png"
     */
    override var vSrc: String = definedExternally
    /**
     *  Image for horizontal resizer for a vertical Toolstrip
     *  @type {SCImgURL}
     *  @default "[SKIN]hresizer.png"
     */
    override var hSrc: String = definedExternally
    companion object {
        /**
         *  Creates a new ToolStripResizer
         * 
         *  @param typeCheckedProperties {Partial<ToolStripResizer>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ToolStripResizer} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ToolStripResizer = definedExternally
    }
}