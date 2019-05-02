@file:JsQualifier("isc")
package isc

/**
 *  ISC abstraction for Flashlets.
 */
open external class Flashlet : BrowserPlugin {
    /**
     *  Sets the 'name' attribute on the flashlet object. If a name is not provided it will be
     *   auto-generated. Note that in general you don't need to set this. If you have a handle to
     *   your ISC Flashlet object you can simply call Flashlet.getPluginHandle to get a
     *   handle to the element.
     *  @type {string}
     *  @default null
     */
    open var name: String = definedExternally
    /**
     *  A map of key/value pairs to pass to the flashlet as parameters. Note that these will be set
     *   on the outer &lt;object&gt; element as well as the inner &lt;embed&gt; element.
     *  @type {object}
     *  @default null
     */
    open var params: dynamic = definedExternally
    /**
     *  This attribute specifies the clsid of the outer &lt;object&gt; tag.
     * 
     *   The default classID is: "clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
     * 
     *  @type {string}
     *  @default "see below"
     */
    open var classID: String = definedExternally
    /**
     *  This attribute specifies the minimum version of the flash player required to show this
     *   flashlet.
     * 
     *   The default codeBase is: "http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0"
     * 
     *  @type {URL}
     *  @default "see below"
     */
    open var codeBase: String = definedExternally
    /**
     *  This attribute specifies the page the user should go to to get the plugin required to view
     *   this flashlet.
     * 
     *   The default pluginsPage is: "http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash"
     * 
     *  @type {URL}
     *  @default "see below"
     */
    open var pluginsPage: String = definedExternally
    /**
     *  Location from which to load the Flashlet.
     *  @type {URL}
     *  @default null
     */
    open var src: String = definedExternally
    /**
     * 
     *   Sets the source file for the flash component
     * 
     * 
     */
    open fun setSrc(): Unit = definedExternally
    /**
     * 
     *   Returns a handle to the flashlet DOM element (valid only after the component has been drawn).
     * 
     * 
     */
    open fun getPluginHandle(): Element = definedExternally
    companion object {
        /**
         *  Creates a new Flashlet
         * 
         *  @param typeCheckedProperties {Partial<Flashlet>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Flashlet} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Flashlet = definedExternally
        /**
         *   Is Shockwave Flash installed on this browser?
         * 
         */
        fun flashAvailable(): Boolean = definedExternally
        /**
         *   Which version of Flash is installed on this browser?
         * 
         */
        fun getFlashVersion(): Number = definedExternally
    }
}