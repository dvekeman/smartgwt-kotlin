@file:JsQualifier("isc")
package isc

/**
 *  Subclass of Window used for displaying a printable view. Includes a "Print" button
 *   header control to trigger printing of content.
 */
open external class PrintWindow : Window {
    /**
     *  Title for the print window
     *  @type {string}
     *  @default "Print Preview"
     */
    override var title: String = definedExternally
    /**
     *  Title for the print button
     *  @type {string}
     *  @default "Print"
     */
    open var printButtonTitle: String = definedExternally
    /**
     *  Setting this property will cause the specified stylesheet to be loaded in this
     *   window's printable HTML frame.
     * 
     *   The stylesheet should be specified as a URL to load.
     *  @type {string}
     *  @default null
     */
    open var externalStylesheet: String = definedExternally
    /**
     *   Setter for title for the print button
     * 
     *  @param {string} new title for the print button
     */
    open fun setPrintButtonTitle(printButtonTitle: String): Unit = definedExternally
    companion object {
        /**
         *  Creates a new PrintWindow
         * 
         *  @param typeCheckedProperties {Partial<PrintWindow>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {PrintWindow} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): PrintWindow = definedExternally
    }
}