@file:JsQualifier("isc")
package isc

/**
 *  ISC Abstraction for SVG controls
 */
open external class SVG : BrowserPlugin {
    /**
     *  This attribute specifies the page the user should go to to get the plugin required to view
     *   this SVG.
     * 
     *   The default pluginsPage is: "http://www.adobe.com/svg/viewer/install/"
     * 
     *  @type {URL}
     *  @default "see below"
     */
    open var pluginsPage: String = definedExternally
    /**
     *  Location from which to load the SVG.
     * 
     *   Note: if you do not specify a src value, ISC will load the special svg 'svgCanvas.svg' from
     *   the helpers directory. This SVG is simply an empty root element - essentially a blank
     *   canvas. You can use this feature to write components that programmatically manipulate the
     *   SVG DOM without needing to ship placeholder SVG files.
     * 
     *  @type {URL}
     *  @default "[HELPERS]svgCanvas.svg"
     */
    open var src: String = definedExternally
    companion object {
        /**
         *  Creates a new SVG
         * 
         *  @param typeCheckedProperties {Partial<SVG>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {SVG} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): SVG = definedExternally
    }
}