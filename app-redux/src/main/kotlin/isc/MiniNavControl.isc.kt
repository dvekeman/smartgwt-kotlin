@file:JsQualifier("isc")
package isc

/**
 *  Compact control for up/down navigation that roughly looks like an up arrowhead next to a
 *   down arrowhead.
 */
open external class MiniNavControl : StretchImgButton {
    /**
     *  @type {SCImgURL}
     *  @default "images/NavigationBar"
     */
    override var skinImgDir: String = definedExternally
    /**
     *  Image used for the up arrowhead.
     *  @type {SCImgURL}
     *  @default "[SKIN]/up.png"
     */
    open var upButtonSrc: String = definedExternally
    /**
     *  Image used for the down arrowhead.
     *  @type {SCImgURL}
     *  @default "[SKIN]/down.png"
     */
    open var downButtonSrc: String = definedExternally
    /**
     *   Notification method fired when the up button is clicked.
     * 
     * 
     */
    open fun upClick(): Unit = definedExternally
    /**
     *   Notification method fired when the down button is clicked.
     * 
     * 
     */
    open fun downClick(): Unit = definedExternally
    companion object {
        /**
         *  Creates a new MiniNavControl
         * 
         *  @param typeCheckedProperties {Partial<MiniNavControl>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {MiniNavControl} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): MiniNavControl = definedExternally
    }
}