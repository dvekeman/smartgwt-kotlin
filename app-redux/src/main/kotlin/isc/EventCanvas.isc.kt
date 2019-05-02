@file:JsQualifier("isc")
package isc

/**
 *  The EventCanvas component is a lightweight VLayout subclass for
 *   displaying a CalendarEvent in a CalendarView.
 * 
 *   Each instance can be CalendarEvent.styleName, and can render a single area,
 *   or separate EventCanvas.showHeader and EventCanvas.showBody
 *   areas, for the look of a Window.
 * 
 *   The component's close and context buttons, and any necessary resizers, are
 *   shown on EventCanvas.showRolloverControls.
 */
open external class EventCanvas : VLayout {
    /**
     *  Renders a header DIV above the main body of the event, an area of limited
     *   height, styled to stand out from the main EventCanvas.showBody of the
     *   event, and typically showing a CalendarEvent.name or title - like a Window.
     *   This header area can be styled via EventCanvas.headerStyle and the HTML it shows
     *   is retrieved from a call to EventCanvas.getHeaderHTML.
     *   The default is taken from Calendar.showEventHeaders.
     *  @type {boolean}
     *  @default null
     */
    open var showHeader: Boolean = definedExternally
    /**
     *  Renders a body DIV that fills the main area of the canvas, or all of it if no
     *   EventCanvas.showHeader is shown. This area typically displays an
     *   CalendarEvent.description. This area can be styled via
     *   EventCanvas.bodyStyle and the HTML it shows is retrieved
     *   from a call to EventCanvas.getBodyHTML. The default is taken
     *   from Calendar.showEventDescriptions.
     *  @type {boolean}
     *  @default null
     */
    open var showBody: Boolean = definedExternally
    /**
     *  Indicates the orientation of the event in its containing view. Affects drag and resize
     *   orientation and which edges of the canvas are available for resizing.
     *  @type {boolean}
     *  @default true
     */
    override var vertical: Boolean = definedExternally
    /**
     *  The CSS class for this EventCanvas. Defaults to the style on
     *   CalendarEvent.styleName, if specified, or on the
     *   Calendar.eventStyleName otherwise.
     * 
     *   Also see EventCanvas.headerStyle and EventCanvas.bodyStyle.
     *  @type {CSSStyleName}
     *  @default null
     */
    override var styleName: String = definedExternally
    /**
     *  The CalendarEvent associated with this EventCanvas.
     *  @type {CalendarEvent}
     *  @default null
     */
    open var event: CalendarEvent = definedExternally
    /**
     *  The Calendar in which this EventCanvas is being rendered.
     *  @type {Calendar}
     *  @default null
     */
    open var calendar: Calendar = definedExternally
    /**
     *  The CalendarView in which this EventCanvas is being rendered.
     *  @type {CalendarView}
     *  @default null
     */
    open var calendarView: CalendarView = definedExternally
    /**
     *  When set to true, the EventCanvas.getHeaderHTML for the
     *   associated event is not rendered inside the eventCanvas itself.
     * 
     *   Instead, it is rendered in it's own EventCanvas.label and shown
     *   as a peer of this eventCanvas, immediately outside of it.
     *  @type {boolean}
     *  @default null
     */
    open var showLabel: Boolean = definedExternally
    /**
     *  When EventCanvas.showLabel is true, this autoChild is
     *   used to display the EventCanvas.getHeaderHTML, adjacent to
     *   this eventCanvas.
     *  @type {Label}
     *  @default null
     */
    open var label: Label = definedExternally
    /**
     *  When set to true, shows the EventCanvas.gripper component, which snaps,
     *   centered, to the top edge of the eventCanvas and can be used to move it with the mouse.
     *  @type {boolean}
     *  @default null
     */
    open var showGripper: Boolean = definedExternally
    /**
     *  The source for the icon displayed as the "gripper" that snaps to the top of an event
     *   canvas and allows an event to be dragged with the mouse.
     *  @type {SCImgURL}
     *  @default null
     */
    open var gripperIcon: String = definedExternally
    /**
     *  When EventCanvas.showGripper is true, this is the component that will
     *   be rendered adjacent to the canvas and allow the canvas to be moved with the mouse.
     *  @type {Img}
     *  @default null
     */
    open var gripper: Img = definedExternally
    /**
     *  Whether the EventCanvas.showHeader should autosize vertically to
     *   display all contents. If true, the header will wrap to multiple lines. If false, the
     *   header will be sized according to the specified EventCanvas.headerHeight,
     *   or to the full height of the canvas is EventCanvas.showBody is false.
     *  @type {boolean}
     *  @default null
     */
    open var headerWrap: Boolean = definedExternally
    /**
     *  The height for the EventCanvas.showHeader, when
     *   EventCanvas.headerWrap is false and
     *   EventCanvas.showBody is true. If showBody is false, the
     *   header area fills the canvas.
     *  @type {Integer}
     *  @default null
     */
    open var headerHeight: Number = definedExternally
    /**
     *  CSS class for the EventCanvas.showHeader of the EventCanvas.
     *   If unset, defaults to the EventCanvas.styleName with the suffix
     *   "Header".
     *  @type {CSSStyleName}
     *  @default null
     */
    open var headerStyle: String = definedExternally
    /**
     *  CSS class for the EventCanvas.showBody of the EventCanvas.
     *   If unset, defaults to the EventCanvas.styleName with the suffix
     *   "Body".
     *  @type {CSSStyleName}
     *  @default null
     */
    open var bodyStyle: String = definedExternally
    /**
     *  When set to the default value of true, this attribute causes a set of components to be
     *   shown when the mouse rolls over this EventCanvas. These components include the
     *   Calendar.eventCanvasCloseButton and
     *   Calendar.eventCanvasContextButton buttons, the latter's
     *   Calendar.eventCanvasContextMenu and the images used for
     *   drag-resizing.
     * 
     *   Using rollover controls is more efficient that showing static buttons in each
     *   eventCanvas, so this is the default behavior. See
     *   Calendar.useEventCanvasRolloverControls for the alternative.
     *  @type {boolean}
     *  @default true
     */
    open var showRolloverControls: Boolean = definedExternally
    /**
     *   Assigns a new CalendarEvent to this EventCanvas, including updates to
     *   drag, style and EventCanvas.showRolloverControls properties.
     * 
     * 
     *  @param {CalendarEvent} the new event to apply to this EventCanvas
     *  @param {CSSStyleName=} optional CSS class to apply to this EventCanvas
     *  @param {CSSStyleName=} optional separate CSS class to apply to the                   EventCanvas.showHeader.
     *  @param {CSSStyleName=} optional separate CSS class to apply to the                   EventCanvas.showBody.
     */
    open fun setEvent(event: CalendarEvent, styleName: String?, headerStyle: String?, bodyStyle: String?): Unit = definedExternally
    /**
     *   Returns the HTML to show in the header of this EventCanvas. The default implementation
     *   returns the Calendar.nameField of the current
     *   EventCanvas.event.
     * 
     * 
     */
    open fun getHeaderHTML(): String = definedExternally
    /**
     *   Return the HTML to show in the body of this EventCanvas. The default implementation
     *   calls Calendar.getEventBodyHTML, which returns the value of the
     *   Calendar.descriptionField for the current
     *   CalendarEvent.
     * 
     * 
     */
    open fun getBodyHTML(): String = definedExternally
    /**
     *   Returns the HTML to show in the EventCanvas as a whole. By default, this method
     *   generates one or two styled DIVs, depending on the values of
     *   EventCanvas.showHeader and EventCanvas.showBody.
     * 
     * 
     */
    override fun getInnerHTML(): String = definedExternally
    companion object {
        /**
         *  Creates a new EventCanvas
         * 
         *  @param typeCheckedProperties {Partial<EventCanvas>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {EventCanvas} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): EventCanvas = definedExternally
    }
}