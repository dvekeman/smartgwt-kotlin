@file:JsQualifier("isc")
package isc

/**
 *  ISC Abstraction for ActiveX controls
 */
open external class ActiveXControl : BrowserPlugin {
    /**
     *  Sets the 'id' attribute on the object. If a name is not provided it will be
     *   auto-generated. Note that in general you don't need to set this. If you have a reference to
     *   your ISC ActiveX control object you can simply call
     *   ActiveXControl.getPluginHandle to get a handle to the element.
     *  @type {string}
     *  @default null
     */
    open var id: String = definedExternally
    /**
     *  A map of key/value pairs to pass to the Active X control as parameters.
     *  @type {object}
     *  @default null
     */
    open var params: dynamic = definedExternally
    /**
     *  Set this to the uuid of your Active X control - ISC will then generate the appropriate
     *   classID entry for you.
     *  @type {string}
     *  @default null
     */
    open var uuid: String = definedExternally
    /**
     *  This sets the value of the classID property on the object. This is meant to give you
     *   complete control over the generated HTML. In practice it may be more handy to set the uuid
     *   property on this object and let the classID be generated from that.
     *  @type {string}
     *  @default null
     */
    open var classID: String = definedExternally
    /**
     *  Specifies the URL from which to load the ActiveX control.
     *  @type {URL}
     *  @default null
     */
    open var codeBase: String = definedExternally
    /**
     *   Returns the ID for this ISC ActiveX control object.
     *   If the id property was specified for the object, that will be used, otherwise
     *   the ID will be auto-generated.
     * 
     */
    open fun getPluginID(): Unit = definedExternally
    /**
     *   Returns a handle to the element for this ISC ActiveX control object.
     * 
     */
    open fun getPluginHandle(): Element = definedExternally
    companion object {
        /**
         *  Creates a new ActiveXControl
         * 
         *  @param typeCheckedProperties {Partial<ActiveXControl>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ActiveXControl} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ActiveXControl = definedExternally
    }
}