@file:JsQualifier("isc")
package isc

/**
 *  A form item that displays a URL. In the default read-only mode (FormItem.canEdit
 *   is false) the URL is shown as a link; in editable mode the URL is shown in a textbox.
 * 
 *   The link to open is specified as the item value with FormItem.setValue or
 *   FormItem.defaultValue. The link title defaults to the URL unless
 *   LinkItem.linkTitle is specified.
 * 
 *   Additionally, a custom action can be triggered when the link is clicked: see
 *   LinkItem.target for details.
 */
open external class LinkItem : TextItem {
    /**
     *  If FormItem.canEdit is set to false, should FormItem.icons be disabled
     *   by default?
     * 
     *   This may also be specified at the icon level. See FormItemIcon.disableOnReadOnly.
     *  @type {boolean}
     *  @default false
     */
    override var disableIconsOnReadOnly: Boolean = definedExternally
    /**
     *  How should icons be aligned vertically for this form item.
     *  @type {VerticalAlignment}
     *  @default "center"
     */
    override var iconVAlign: 
                             /**
                              *  At the top of the container
                              *  Center within container.
                              *  At the bottom of the container
                              */
                             String /* top |  center |  bottom */ = definedExternally
    /**
     *  If FormItem.canEdit is set to false, how should this
     *   LinkItem be displayed to the user?
     * 
     *   Link items are, by default, canEdit:false. Note that the link remains active regardless
     *   of the readOnlyDisplay setting.
     *  @type {ReadOnlyDisplayAppearance}
     *  @default null
     */
    override var readOnlyDisplay: 
                                  /**
                                   *  Item value should appear within the form as a static block of text, similar to the default appearance of a StaticTextItem. This appearance may be
                                   *   modified via FormItem.readOnlyTextBoxStyle and FormItem.clipStaticValue.
                                   *  Item should appear unchanged, but user interaction to edit the item will be disallowed. Note that some interactions will be allowed, such as selecting text
                                   *   within a read-only TextItem for copy and paste. Exact implementation may vary by
                                   *   form item type.
                                   *  Item will appear disabled.
                                   */
                                  String /* static |  readOnly |  disabled */ = definedExternally
    /**
     *  By default, clicking a link rendered by this item opens it in a new browser window. You
     *   can alter this behavior by setting this property. The value of this property will be
     *   passed as the value to the target attribute of the anchor tag used to render
     *   the link.
     * 
     *   If you set linkItem.target to "javascript", the default behaviour is to catch and consume
     *   mouse-clicks that would result in the link being followed. Instead, the
     *   FormItem.click event is fired.
     *  @type {string}
     *  @default "_blank"
     */
    open var target: String = definedExternally
    /**
     *  Optional title HTML to display for this item's link. If unset, the LinkItem's
     *   value (the URL) will be used for the link's title.
     *  @type {HTMLString}
     *  @default null
     */
    open var linkTitle: String = definedExternally
    /**
     *   Setter for LinkItem.linkTitle.
     * 
     *  @param {HTMLString} new linkTitle HTML.
     */
    open fun setLinkTitle(title: String): Unit = definedExternally
    companion object {
        /**
         *  Creates a new LinkItem
         * 
         *  @param typeCheckedProperties {Partial<LinkItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {LinkItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): LinkItem = definedExternally
    }
}