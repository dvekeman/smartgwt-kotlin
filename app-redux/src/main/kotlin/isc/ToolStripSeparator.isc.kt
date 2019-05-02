@file:JsQualifier("isc")
package isc

/**
 *  Simple subclass of Img with appearance appropriate for a ToolStrip separator
 */
open external class ToolStripSeparator : Img {
    /**
     *  Path to separator image.
     *  @type {SCImgURL}
     *  @default "images/ToolStrip/"
     */
    override var skinImgDir: String = definedExternally
    /**
     *  Image for vertically oriented separator (for horizontal toolstrips).
     *  @type {SCImgURL}
     *  @default "[SKIN]separator.png"
     */
    open var vSrc: String = definedExternally
    /**
     *  Image for horizontally oriented separator (for vertical toolstrips).
     *  @type {SCImgURL}
     *  @default "[SKIN]hseparator.png"
     */
    open var hSrc: String = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "ToolStripSeparatorEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
    companion object {
        /**
         *  Creates a new ToolStripSeparator
         * 
         *  @param typeCheckedProperties {Partial<ToolStripSeparator>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ToolStripSeparator} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ToolStripSeparator = definedExternally
    }
}