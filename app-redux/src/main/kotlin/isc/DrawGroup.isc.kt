@file:JsQualifier("isc")
package isc

/**
 *  DrawItem subclass to manage a group of other DrawItem instances.
 * 
 *   A DrawGroup has no local visual representation other than that of its drawItems. Adding items
 *   to a drawGroup allows for central event handling, and allows them to be manipulated
 *   (drawn, scaled, etc) together.
 * 
 *   DrawItems are added to a DrawGroup by creating the DrawItems with DrawItem.drawGroup
 *   set to the DrawGroup, or by creating a DrawGroup with DrawGroup.drawItems.
 * 
 *   DrawGroups handle events by having an explicitly specified group rectangle
 *   (see DrawGroup.getGroupRect). This rectangle has no visual representation within the draw pane
 *   (is not visible) but any user-interactions within the specified coordinates will trigger
 *   group level events.
 * 
 *   DrawGroups may contain other DrawGroups.
 */
open external class DrawGroup : DrawItem {
    /**
     *  DrawGroup only supports the
     *   "move"
     * 
     *   knob type.
     *  @type {Array<Partial<KnobType>>}
     *  @default null
     */
    override var knobs: Array<dynamic> = definedExternally
    /**
     *  Should dragging the group (when DrawItem.canDrag is true) or dragging the
     *   move knob also move the items within this DrawGroup?
     *  @type {boolean}
     *  @default true
     */
    open var moveItemsWithGroup: Boolean = definedExternally
    /**
     *  When should this drawGroup receive event notifications?
     *   If set to true, the developer can specify an explicit
     *   DrawGroup.getGroupRect. Whenever the user interacts with this
     *   rectangle, the drawGroup will be notified and the appropriate event handlers will be
     *   fired. Note that rectangle need not contain all DrawItems within the group, and
     *   is manually managed by the developer.
     *   If set to false, the DrawGroup.getGroupRect
     *   coordinates are unused - instead
     *   as a user interacts with specific drawItems within this group, the appropriate event handler
     *   would be fired on the item, then the event would "bubble" to the
     *   drawGroup, firing the appropriate event handler at the group level as well.
     *  @type {boolean}
     *  @default false
     */
    open var useGroupRect: Boolean = definedExternally
    /**
     *  Left coordinate of the DrawGroup.getGroupRect in pixels relative to the
     *   DrawPane (the "drawing coordinate system").
     *  @type {Coordinate}
     *  @default "0"
     */
    open var left: Number = definedExternally
    /**
     *  Top coordinate of the DrawGroup.getGroupRect in pixels relative to the
     *   DrawPane (the "drawing coordinate system").
     *  @type {Coordinate}
     *  @default "0"
     */
    open var top: Number = definedExternally
    /**
     *  Width of the DrawGroup.getGroupRect in pixels relative to the
     *   DrawPane (the "drawing coordinate system").
     *  @type {Distance}
     *  @default "1"
     */
    open var width: dynamic = definedExternally
    /**
     *  Height of the DrawGroup.getGroupRect in pixels relative to the
     *   DrawPane (the "drawing coordinate system").
     *  @type {Distance}
     *  @default "1"
     */
    open var height: dynamic = definedExternally
    /**
     *  Initial list of DrawItems for this DrawGroup.
     * 
     *   DrawItems can be added to a DrawGroup after initialization by setting
     *   DrawItem.drawGroup.
     *  @type {Array<Partial<DrawItem>>}
     *  @default null
     */
    open var drawItems: Array<dynamic> = definedExternally
    /**
     *  If the "move"
     * 
     *   DrawItem.knobs is shown for this group and DrawGroup.useGroupRect
     *   is true, should the DrawGroup.groupRectOutline be shown?
     * 
     *   Set to false to disable showing the groupRectOutline.
     *  @type {boolean}
     *  @default null
     */
    open var showGroupRectOutline: Boolean = definedExternally
    /**
     *  If this group is showing a "move"
     * 
     *   DrawItem.knobs, the groupRectOutline is a DrawRect AutoChild
     *   that identifies the group's group rect (see DrawGroup.useGroupRect).
     * 
     *   useGroupRect must be true and the "move"
     *   control knob must be
     *   showing for the groupRectOutline AutoChild to be created and shown.
     *  @type {DrawRect}
     *  @default null
     */
    open var groupRectOutline: DrawRect = definedExternally
    /**
     *   Erases all DrawItems in the DrawGroup.
     * 
     * 
     */
    override fun erase(): Unit = definedExternally
    /**
     *   Sets the left coordinate of this DrawGroup's DrawGroup.getGroupRect.
     *   Note that setting the left coordinate will not move the items in this DrawGroup.
     * 
     * 
     *  @param {Coordinate} new left coordinate
     */
    open fun setLeft(left: Number): Unit = definedExternally
    /**
     *   Sets the top coordinate of this DrawGroup's DrawGroup.getGroupRect.
     *   Note that setting the top coordinate will not move the items in this DrawGroup.
     * 
     * 
     *  @param {Coordinate} new top coordinate in pixels
     */
    open fun setTop(top: Number): Unit = definedExternally
    /**
     *   Sets the width of this DrawGroup's DrawGroup.getGroupRect.
     *   Note that setting the width will not move or resize the items in this DrawGroup.
     * 
     * 
     *  @param {Distance} new width for the group rectangle
     */
    open fun setWidth(width: dynamic): Unit = definedExternally
    /**
     *   Sets the height of this DrawGroup's DrawGroup.getGroupRect.
     *   Note that setting the height will not move or resize the items in this DrawGroup.
     * 
     * 
     *  @param {Distance} new height for the group rectangle
     */
    open fun setHeight(height: dynamic): Unit = definedExternally
    /**
     *   This method will return an array of integers (left, top, width, height) defining the area
     *   of the "group rectangle" for the group. If DrawGroup.useGroupRect is true, this is
     *   the area of the DrawPane where user interactions will fire event notifications on this DrawGroup.
     * 
     *   This is a convienence method to get the current coordinates of the
     *   DrawGroup.useGroupRect. Developers must use
     *   DrawGroup.setLeft, DrawGroup.setTop, DrawGroup.setWidth or
     *   DrawGroup.setHeight to set each coordinate directly.
     * 
     */
    open fun getGroupRect(): Array<dynamic> = definedExternally
    /**
     *   Sets both the left and top coordinates of this DrawGroup's DrawGroup.getGroupRect.
     *   Note that this does not move or resize the items in this DrawGroup.
     * 
     * 
     *  @param {Integer} new left coordinate in pixels
     *  @param {Integer} new top coordinate in pixels
     */
    override fun moveTo(left: Number, top: Number): Unit = definedExternally
    /**
     *   Updates the DrawGroup's left coordinate by dX and the top coordinate
     *   by dY. Note that this does not move or resize the items in this DrawGroup.
     * 
     * 
     *  @param {Distance} change to left coordinate in pixels
     *  @param {Distance} change to top coordinate in pixels
     */
    override fun moveBy(dX: dynamic, dY: dynamic): Unit = definedExternally
    /**
     *   Rotate each item in the group to the specified number of degrees.
     * 
     * 
     * \* @param {Float} 
     */
    override fun rotateTo(degrees: Number): Unit = definedExternally
    /**
     *   Rotate each item in the group by the specified number of degrees.
     * 
     * 
     * \* @param {Float} 
     */
    override fun rotateBy(degrees: Number): Unit = definedExternally
    /**
     *   Scale all drawItem[] shapes by the x, y multipliers
     * 
     *  @param {Float} scale in the x direction
     *  @param {Float} scale in the y direction
     */
    override fun scaleBy(x: Number, y: Number): Unit = definedExternally
    /**
     *   Get the center point of the DrawGroup.getGroupRect.
     * 
     */
    override fun getCenter(): Point = definedExternally
    /**
     *   Returns the left, top, (left + width), and (top + height) values
     * 
     */
    override fun getBoundingBox(): Array<dynamic> = definedExternally
    /**
     *   Scale the each item in the drawGroup by the x, y multipliers
     * 
     *  @param {Float} scale in the x direction
     *  @param {Float} scale in the y direction
     */
    override fun scaleTo(x: Number, y: Number): Unit = definedExternally
    /**
     *   Notification fired when the user starts to drag this DrawGroup. Will only fire if DrawItem.canDrag
     *   is true for this group.
     * 
     *   Note that if DrawGroup.useGroupRect is true, this notification will be triggered
     *   by the user interacting with the specified DrawGroup.getGroupRect for the group.
     *   If DrawGroup.useGroupRect is false, the notification will bubble up from interactions
     *   with individual items within the group.
     * 
     *   Default drag behavior will be to reposition all items in the group (and update the group
     *   rectangle).
     * 
     */
    override fun dragStart(): Boolean = definedExternally
    /**
     *   Notification fired for every mouseMove event triggered while the user is dragging this
     *   DrawGroup. Will only fire if DrawItem.canDrag is true for this group.
     * 
     *   Note that if DrawGroup.useGroupRect is true, this notification will be triggered
     *   by the user interacting with the specified DrawGroup.getGroupRect for the group.
     *   If DrawGroup.useGroupRect is false, the notification will bubble up from interactions
     *   with individual items within the group.
     * 
     *   Default drag behavior will be to reposition all items in the group (and update the group rectangle).
     * 
     */
    override fun dragMove(): Boolean = definedExternally
    /**
     *   Notification fired when the user stops dragging this DrawGroup. Will only fire if DrawItem.canDrag
     *   is true for this group.
     * 
     *   Note that if DrawGroup.useGroupRect is true, this notification will be triggered
     *   by the user interacting with the specified DrawGroup.getGroupRect for the group.
     *   If DrawGroup.useGroupRect is false, the notification will bubble up from interactions
     *   with individual items within the group.
     * 
     */
    override fun dragStop(): Boolean = definedExternally
    /**
     *   Notification fired when the user presses the left mouse button on this DrawGroup.
     * 
     *   Note that if DrawGroup.useGroupRect is true, this notification will be triggered
     *   by the user interacting with the specified DrawGroup.getGroupRect for the group.
     *   If DrawGroup.useGroupRect is false, the notification will bubble up from interactions
     *   with individual items within the group.
     * 
     */
    override fun mouseDown(): Boolean = definedExternally
    /**
     *   Notification fired when the user releases the left mouse button on this DrawGroup.
     * 
     *   Note that if DrawGroup.useGroupRect is true, this notification will be triggered
     *   by the user interacting with the specified DrawGroup.getGroupRect for the group.
     *   If DrawGroup.useGroupRect is false, the notification will bubble up from interactions
     *   with individual items within the group.
     * 
     */
    override fun mouseUp(): Boolean = definedExternally
    /**
     *   Notification fired when the user clicks on this DrawGroup.
     * 
     *   Note that if DrawGroup.useGroupRect is true, this notification will be triggered
     *   by the user interacting with the specified DrawGroup.getGroupRect for the group.
     *   If DrawGroup.useGroupRect is false, the notification will bubble up from interactions
     *   with individual items within the group.
     * 
     */
    override fun click(): Boolean = definedExternally
    /**
     *   Notification fired when the mouse enters this DrawGroup.
     * 
     *   Note that if DrawGroup.useGroupRect is true, this notification will be triggered
     *   by the user interacting with the specified DrawGroup.getGroupRect for the group.
     *   If DrawGroup.useGroupRect is false, the notification will bubble up from interactions
     *   with individual items within the group.
     * 
     */
    override fun mouseOver(): Boolean = definedExternally
    /**
     *   Notification fired when the user moves the mouse over this DrawGroup.
     * 
     *   Note that if DrawGroup.useGroupRect is true, this notification will be triggered
     *   by the user interacting with the specified DrawGroup.getGroupRect for the group.
     *   If DrawGroup.useGroupRect is false, the notification will bubble up from interactions
     *   with individual items within the group.
     * 
     */
    override fun mouseMove(): Boolean = definedExternally
    /**
     *   Notification fired when the mouse leaves this DrawGroup.
     * 
     *   Note that if DrawGroup.useGroupRect is true, this notification will be triggered
     *   by the user interacting with the specified DrawGroup.getGroupRect for the group.
     *   If DrawGroup.useGroupRect is false, the notification will bubble up from interactions
     *   with individual items within the group.
     * 
     */
    override fun mouseOut(): Boolean = definedExternally
    companion object {
        /**
         *  Creates a new DrawGroup
         * 
         *  @param typeCheckedProperties {Partial<DrawGroup>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DrawGroup} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DrawGroup = definedExternally
    }
}