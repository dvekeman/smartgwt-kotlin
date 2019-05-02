@file:JsQualifier("isc")
package isc

/**
 *  Specialized StretchImgButton used by TabSet/TabBar for tabs
 */
open external class ImgTab : StretchImgButton {
    /**
     *  How big are the end pieces by default
     *  @type {number}
     *  @default "2"
     */
    override var capSize: Number = definedExternally
    /**
     *  Base path for the images.  Note that when used within a TabSet, the
     *   TabSet.tabBarPosition is appended as an additional path segment, yielding
     *   "images/Tab/top/" et al.
     *  @type {URL}
     *  @default "images/Tab/"
     */
    override var skinImgDir: String = definedExternally
    /**
     *  Base path for images shown within this ImgTab's label. This will be used for
     *   icons (such as the close icon) by default.
     *  @type {URL}
     *  @default "images/"
     */
    override var labelSkinImgDir: String = definedExternally
    /**
     *  @type {CSSStyleName}
     *  @default "tab"
     */
    override var baseStyle: String = definedExternally
    /**
     *  Like StretchImgButton.titleStyle, can set to provide a separate style for the
     *   title text.
     * 
     *   If set and the ImgTab is StretchImgButton.vertical, a "v" will be
     *   automatically prepended to the style name (hence "tabTitle" -> "vtabTitle").
     *  @type {CSSStyleName}
     *  @default null
     */
    override var titleStyle: String = definedExternally
    /**
     *  Base URL for tab images
     *  @type {SCImgURL}
     *  @default "[SKIN]tab.gif"
     */
    override var src: String = definedExternally
    /**
     *  Should we visibly change state when the mouse goes over this tab
     *  @type {boolean}
     *  @default false
     */
    override var showRollOver: Boolean = definedExternally
    /**
     *  Should we visibly change state when the tab receives keyboard focus?
     *  @deprecated \* as of SmartClient 6.1 in favor of ImgTab.showFocused
     *  @type {boolean}
     *  @default true
     */
    override var showFocus: Boolean = definedExternally
    /**
     *  Should we visibly change state when the tab receives keyboard focus?
     *  @type {boolean}
     *  @default true
     */
    override var showFocused: Boolean = definedExternally
    /**
     *  Alignment of title text
     *  @type {Alignment}
     *  @default "center"
     */
    override var align: 
                        /**
                         *  Center within container.
                         *  Stick to left side of container.
                         *  Stick to right side of container.
                         */
                        String /* center |  left |  right */ = definedExternally
    companion object {
        /**
         *  Creates a new ImgTab
         * 
         *  @param typeCheckedProperties {Partial<ImgTab>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ImgTab} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ImgTab = definedExternally
    }
}