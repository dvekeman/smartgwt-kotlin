@file:JsQualifier("isc")
package isc

/**
 *  Custom subclass of Window configured to be embedded within a PortalLayout.
 */
open external class Portlet : Window {
    /**
     *  By default, PortalLayout.portletDropTypes is set so that any component can be
     *   dragged into a PortalLayout. If the component is not a Portlet,
     *   it will be automatically be wrapped in a newly created Portlet.
     * 
     *   If you prefer to only allow real Portlet to be dragged into a
     *   PortalLayout, then you can set PortalLayout.portletDropTypes to
     *   ["Portlet"], since Portlet.dragType defaults to
     *   "Portlet".
     * 
     *   if you want to allow some Portlet to be dropped on a PortalLayout
     *   but not others, then you can specify a custom dragType for Portlet,
     *   and then set PortalLayout.portletDropTypes as appropriate.
     *  @type {string}
     *  @default "Portlet"
     */
    override var dragType: String = definedExternally
    /**
     *  Portlets have canDrop set to true to enable drag/drop reposition within the portalLayout
     *  @type {boolean}
     *  @default true
     */
    override var canDrop: Boolean = definedExternally
    /**
     *  Specifies a minimum height for the Portlet. The height of rows within a PortalLayout
     *   will be adjusted to take into account the minHeight of all the Portlets in that row.
     *  @type {number}
     *  @default "60"
     */
    override var minHeight: Number = definedExternally
    /**
     *  Specifies a minimum width for the Portlet.
     *  @type {number}
     *  @default "70"
     */
    override var minWidth: Number = definedExternally
    /**
     *  If you initialize the height of a Portlet, then that height will be used as the
     *   Portlet's Portlet.rowHeight (if no rowHeight is set).
     * 
     *   After initialization, the PortalLayout manages the height of Portlets. If you
     *   want to change the height, use Portlet.setRowHeight.
     *  @type {number | string}
     *  @default null
     */
    override var height: dynamic = definedExternally
    /**
     *  If you set the rowHeight of a Portlet before adding it to a PortalLayout, then
     *   the height will be used when creating the new row. If adding the Portlet
     *   to an existing row (or dragging it there), the Portlet's rowHeight will be used if
     *   the row's height has not already been specified. However, if you
     *   set the rowHeight of a Portlet after adding it to the PortalLayout, then the height
     *   of the entire row will always be adjusted to match.
     * 
     *   You can also just specify Canvas.height when initializing a Portlet, and it
     *   will be applied to the rowHeight when added to a PortalLayout. However, changing the Portlet's
     *   height after initialization will not affect the row.
     * 
     *   Note that getting the rowHeight will indicate the rowHeight specified for this Portlet,
     *   not the actual height of the row it is in.
     *  @type {number | string}
     *  @default null
     */
    open var rowHeight: dynamic = definedExternally
    /**
     *  If true, Portlet.closeConfirmationMessage will be displayed before portlets are closed
     *  @type {boolean}
     *  @default true
     */
    open var showCloseConfirmationMessage: Boolean = definedExternally
    /**
     *  Confirmation message to show the user when closing portlets if
     *   Portlet.showCloseConfirmationMessage is true.
     *  @type {string}
     *  @default "Close portlet?"
     */
    open var closeConfirmationMessage: String = definedExternally
    /**
     *  If specified, this properties block will be passed to isc.confirm as the
     *   properties parameter when the Portlet.closeConfirmationMessage is shown,
     *   allowing developers to customize the appear of the confirmation
     *   dialog (modifying its title, etc).
     *  @type {Dialog}
     *  @default null
     */
    open var closeConfirmationDialogProperties: Dialog = definedExternally
    /**
     *  Whether to call Canvas.destroy when closing the Portlet.
     *  @type {boolean}
     *  @default false
     */
    open var destroyOnClose: Boolean = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "PortletEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
    /**
     * 
     *   The height of a Portlet is managed by the PortalLayout. If you want to change
     *   the Portlet's height, use Portlet.setRowHeight instead.
     * 
     * 
     *  @param {number} new height
     */
    override fun setHeight(height: dynamic): Unit = definedExternally
    /**
     *   Sets the height of the Portlet's row (and, thus, indirectly sets the Portlet's own height).
     *   Use this instead of using Portlet.setHeight directly.
     * 
     *  @param {number} new height
     */
    open fun setRowHeight(height: Number): Unit = definedExternally
    /**
     *   Gets the PortalLayout which encloses this Portlet (or null, if none).
     * 
     */
    open fun getPortalLayout(): PortalLayout = definedExternally
    /**
     *   Gets the position of the Portlet within its PortalLayout. Returns null
     *   if the Portlet is not in a PortalLayout.
     * 
     */
    open fun getPortalPosition(): PortalPosition = definedExternally
    /**
     *   Handles a click on the close button of this portlet. The default implementation
     *   calls Portlet.close.
     * 
     *   Override this method if you want
     *   other actions to be taken.
     * 
     *   Custom implementations may call close() to trigger the default behavior.
     * 
     */
    override fun closeClick(): Boolean = definedExternally
    /**
     *   close() method overridden to show
     *   Portlet.closeConfirmationMessage to the user before
     *   removing the portlet from the PortalLayout via PortalLayout.removePortlet
     * 
     */
    override fun close(): Unit = definedExternally
    companion object {
        /**
         *  Creates a new Portlet
         * 
         *  @param typeCheckedProperties {Partial<Portlet>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Portlet} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Portlet = definedExternally
    }
}