@file:JsQualifier("isc")
package isc

/**
 *  PrintCanvas is a subclass of canvas which renders printable content HTML and
 *   provides APIs for printing this content as a separate document.
 */
open external class PrintCanvas : Canvas {
    /**
     *  Location of the special printFrame html file provided as part of the SmartClient libraries.
     *   This file must be present at the specified location for the printCanvas printing APIs.
     *  @type {string}
     *  @default "[HELPERS]printFrame.html"
     */
    open var printFrameURL: String = definedExternally
    /**
     *  Setting this property will cause the specified stylesheet to be loaded in this print
     *   canvas's frame.
     *   The stylesheet should be specified as a URL to load.
     *  @type {string}
     *  @default null
     */
    open var externalStylesheet: String = definedExternally
    /**
     *   Update the HTML content displayed in this print canvas. If the printCanvas is not yet
     *   drawn the HTML will be displayed when the canvas is drawn.
     * 
     *   Note that if the printCanvas is Canvas.redraw, or
     *   Canvas.clear and then Canvas.draw again, the HTML will
     *   be redisplayed inside the print canvas, and the specified callback will be fired again.
     * 
     * 
     *  @param {string} HTML to show in this print canvas
     *  @param {PrintCanvasCallback} callback function to fire when the HTML is displayed. The callback will be passed a pointer to this print canvas as the first parameter with the  name printPreview. If this canvas is not drawn when this method is called,  the callback will not be fired until the canvas is drawn and the HTML rendered out into  the page.
     */
    open fun setHTML(HTML: String, callback: ((printPreview: PrintCanvas) -> Unit)): Unit = definedExternally
    /**
     *   Show the native print dialog and allow the user to print the current HTML for
     *   this printCanvas. Note that the PrintCanvas must be drawn to be printed.
     * 
     */
    open fun print(): Unit = definedExternally
    companion object {
        /**
         *  Creates a new PrintCanvas
         * 
         *  @param typeCheckedProperties {Partial<PrintCanvas>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {PrintCanvas} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): PrintCanvas = definedExternally
    }
}