@file:JsQualifier("isc")
package isc

/**
 * 
 *   The ISC system provides a predictable cross-browser event-handling mechanism for ISC
 *   widgets. Events can be handled both at the page level (i.e., globally), and at the level of
 *   individual widgets.
 * 
 *   With the exception of a few page-specific events ('load', 'unload', 'idle' and 'resize'),
 *   events are processed in the following sequence:
 * 
 *   1. The event is sent to any global (page-level) event handlers. These handlers can cancel
 *   further propagation of the event by returning false. You can register to listen for any of the
 *   events linked in the seeAlso section (below) by calling Page.setEvent
 *   method.
 * 
 *   2. If the event occurred on a form element or a link, it is passed on to the browser so that
 *   the element will perform its default action. No widget receives the event.
 * 
 *   3. If the event occurred on an enabled widget (but not on a form element or link inside
 *   the widget), it is sent to that widget's event handler, if any. This handler can cancel
 *   further propagation of the event by returning false. An "enabled" widget is any widget that
 *   defines an event handler for one of the supported events. Interceptable events are defined in
 *   the "widgetEvents" section of Canvas.
 * 
 *   4. The event is "bubbled" up to the widget's parent in the containment hierarchy, if any.
 *   Again, the parent's handler for the event can cancel further propagation by returning
 *   false. This step is repeated, with the event "bubbling" up through the containment
 *   hierarchy, until a top-level widget is reached or the event is explicitly canceled.
 *   In brief, the ISC event model offers the best features of browser event models:
 * 
 * 
 *  - Page-first event handling allows you to reliably process or cancel any event before it
 *     affects the objects on the page.
 * 
 *  - Event "bubbling" ensures that parent widgets receive events sent to their children,
 *     and allows you to create generalized parent-level handlers rather than duplicating
 *     code in each child.
 * 
 *   Note: Canceling propagation of an event may cancel its side effects as well, including the
 *   generation of other (synthetic) events. For example, if a global mouseDown handler returns
 *   false, drag-and-drop events will not be generated. Specific effects are discussed in the
 *   descriptions of the various events in the following sections.
 * 
 *   SmartClient libraries will not interfere with native event handling when events occur
 *   outside of a target widget. You can therefore have HTML that is not ISC-based on the same
 *   page as widget objects that will react to native events as you would expect.
 * 
 *   You can use isc.Event as an alias for isc.EventHandler.
 * 
 * 
 */
open external class EventHandler : Class {
    companion object {
        /**
         *  amount of time between idle messages (msec)
         *  @type {Integer}
         *  @default "10"
         */
        var IDLE_DELAY: Number = definedExternally
        /**
         *  Return this constant from a child event to stop the event propagating to its parent,
         *   without suppressing any native browser handling associated with the event.
         *   Developers should not need to modify this value - it should be treated as read-only
         *   in most circumstances.
         *  @type {string}
         *  @default "\*\*\*STOP\*\*\*"
         */
        var STOP_BUBBLING: String = definedExternally
        /**
         *  Constant containing the full set of edges a component may be resized from.
         *   When a component is marked as canDragResize, this will be the default set of edges
         *   from which it may be resized.
         *  @type {Array<Partial<string>>}
         *  @default "["T","L","B","R","TL","TR","BL","BR"]"
         */
        var ALL_EDGES: Array<dynamic> = definedExternally
        /**
         *  If set to true, when the user drags a Canvas.canDrop canvas
         *   over any component with Canvas.canAcceptDrop set to false or where
         *   Canvas.willAcceptDrop returns false, the Canvas.noDropCursor
         *   will be shown automatically to indicate this is not a valid drop point.
         * 
         *   This property can be modified at runtime, meaning a developer could choose to show the
         *   no drop indicator for specific drag/drop interactions by changing the value from
         *   a dragStart handler or similar.
         * 
         *   Note that when this property is false, developers may still use the
         *   Canvas.dropMove handler for potential drop targets and use Canvas.setCursor
         *   to explicitly indicate invalid drop areas within a widget. This is the approach used
         *   by default for TreeGrid drag/drop interactions, for example.
         *  @type {boolean}
         *  @default false
         */
        var showNoDropIndicator: Boolean = definedExternally
        /**
         *  Advanced property governing whether focus and blur notifications throughout the
         *   SmartClient system should be fired synchronously in Internet Explorer and
         *   Microsoft Edge, as they are in other browsers.
         * 
         *   Internet Explorer differs from other supported browsers in that the native
         *   onfocus and onblur browser events are fired asynchronously.
         *   In all other browsers these handlers are fired synchronously.
         *   Historically, SmartClient focus change event notifications such as
         *   Canvas.focusChanged and FormItem.focus / FormItem.blur were
         *   fired from these native event handlers, meaning that they would also be asynchronous in
         *   Internet Explorer and synchronous in all other browsers.
         *   Internet Explorer does provide developers with a separate focus-change notification
         *   which fires synchronously in the form of the focusin and focusout
         *   events (documented here).
         *   When synchronousFocusNotifications is set to true the SmartClient system will leverage
         *   these events to provide synchronous notifications in Internet Explorer.
         * 
         *   For example, consider a Canvas with a 'focusChanged' handler, as follows:
         * 
         * 
         *   // ... Canvas definition
         *   isc.Canvas.create({
         *     ID:"testCanvas", backgroundColor:"lightblue",
         *     contents:"testCanvas",
         *     canFocus:true,
         *     focusChanged:function (hasFocus) {
         *       this.logWarn('focusChanged:' + hasFocus);
         *     },
         *     autoDraw:true
         *   });
         * 
         * 
         * 
         *   ...along with the following code to put focus into that canvas:
         * 
         * 
         *   // ... Code to execute in the flow of the application
         *   isc.logWarn("Before calling focus");
         *   testCanvas.focus();
         *   isc.logWarn("After calling focus");
         * 
         * 
         * 
         * 
         *   If synchronousFocusNotifications is false, the focus changed notification will
         *   be fired asynchronously in Internet Explorer, meaning the order of events logged
         *   in the developer console would be:
         * 
         *   WARN:Log:Before calling focus
         *   WARN:Log:After calling focus
         *   WARN:Canvas:testCanvas:focusChanged:true
         * 
         *   In all other browsers, the focus changed notification is synchronous:
         * 
         *   WARN:Log:Before calling focus
         *   WARN:Canvas:testCanvas:focusChanged:true
         *   WARN:Log:After calling focus
         * 
         *   Setting synchronousFocusNotifications to true makes event notifications synchronous
         *   in Internet Explorer as well.
         * 
         *   As of SmartClient version 11.1 (SmartGWT version 6.1), this property is true
         *   by default. For backwards compatibility purposes, it may be explicitly set
         *   to false to reinstate the previous asynchronous focus notification behavior
         *   in Internet Explorer, should application code depend on this behavior.
         *  @type {boolean}
         *  @default true
         */
        var synchronousFocusNotifications: Boolean = definedExternally
        /**
         *  Creates a new EventHandler
         * 
         *  @param typeCheckedProperties {Partial<EventHandler>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {EventHandler} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): EventHandler = definedExternally
        /**
         *   Returns the natively reported target (or source) DOM element for the current mouse event.
         *   NOTE: SmartClient cannot guarantee that the same element will
         *   be reported in all browser/platform configurations for all event types.
         *   If you wish to make use of this value, we recommend testing your use case
         *   in all target browser configurations.
         * 
         * 
         */
        fun getNativeMouseTarget(): Element = definedExternally
        /**
         *   Method to return the Canvas.canFocus canvas with
         *   current keyboard focus.
         * 
         * 
         */
        fun getFocusCanvas(): Canvas = definedExternally
        /**
         *   This API may be called to set the native HTML5 drag tracker image. The x and
         *   y parameters may be specified to affect the placement of the drag tracker image
         *   relative to the mouse cursor. The size of the drag tracker image is the intrinsic size of the
         *   image. Browsers may apply certain visual effects (such as a slight transparency) to this image.
         * 
         *   Can only be called during the Canvas.dragStart event (or methods called during the
         *   handling of that event).
         * 
         *   NOTES:
         * 
         * 
         *  - Not supported in Opera 12.x or Safari.
         * 
         *  - For best results, this image should be preloaded. Otherwise, the image might not appear
         *   for the first drag using this image.
         * 
         *  - This API does not work in Chrome or Firefox on Windows 7 if the "Use visual styles on windows and buttons"
         *   setting is turned off.
         * 
         * 
         *  @param {SCImgURL} image source
         *  @param {Integer=} offset-x from the mouse cursor
         *  @param {Integer=} offset-y from the mouse cursor
         */
        fun setDragTrackerImage(src: String, x: Number?, y: Number?): Unit = definedExternally
        /**
         *   For a cross-frame drag, retrieves the data made available when the drag was initiated in the
         *   foreign frame via EventHandler.setNativeDragData.
         * 
         *   Can only be called during the Canvas.drop event (or methods called during the handling
         *   of that event, such as ListGrid.recordDrop); will return null if called at any other
         *   time, or if called during a non-HTML5 drag and drop.
         * 
         */
        fun getNativeDragData(): dynamic = definedExternally
        /**
         *   Sets the data available in a cross-frame HTML5 drag (see Canvas.useNativeDrag).
         * 
         *   Data provided to this method must be valid for serialization to JSON via the
         *   JSONEncoder, or can simply be a String.
         * 
         *   Can only be called during the Canvas.dragStart event (or methods called during the
         *   handling of that event).
         * 
         *   Do not pass in sensitive data (e.g. passwords, auth/session tokens, credit card numbers, SSNs, etc.).
         * 
         *  @param {object | string} data to make available to foreign frames
         *  @param {string=} text data to set. This is the text that users may see if the drag is dropped into an external application such as Notepad or a non-Smart&#67;lient/Smart&nbsp;GWT web application.
         */
        fun setNativeDragData(data: dynamic, strData: String?): Unit = definedExternally
        /**
         *   Applies to Canvas.mouseWheel events only.
         *   Returns a numeric value indicating how far the mouse wheel was rotated. This value will be
         *   positive if the user scrolled the mousewheel forward or up, or negative if scrolled in the
         *   other direction. For a standard wheel-mouse, an increment of 1 relates to the smallest
         *   possible rotation of the mouse wheel. For other scrolling devices, such as scroll
         *   gestures on a track pad, wheel delta may be reported in finer grained increments
         *   (causing this method to return a fractional value).
         * 
         *   Note that behavior for trackpad scroll-gestures may differ by browser, but where
         *   separate vertical and horizontal scroll information is available, this method
         *   refers to a vertical scroll gesture.
         * 
         *   Developers should also be aware
         *   that some browsers and operating systems allow the user to configure the sensitivity
         *   of the mouse wheel or trackpad, which may change this value.
         * 
         * 
         *  @deprecated \* in favor of EventHandler.getWheelDeltaY
         */
        fun getWheelDelta(): Number = definedExternally
        /**
         *   Horizontal scroll delta reported by a Canvas.mouseWheel event
         *   (such as a horizontal swipe on a track-pad).
         * 
         *   Returns a numeric value indicating how far the mouse wheel was rotated / the magnitude
         *   of the scroll gesture. This value will be
         *   positive if the user scrolled the mousewheel to the right, negative if scrolled in the
         *   other direction.
         * 
         * 
         */
        fun getWheelDeltaX(): Number = definedExternally
        /**
         *   Applies to Canvas.mouseWheel events only.
         *   Returns a numeric value indicating how far the mouse wheel was rotated. This value will be
         *   positive if the user scrolled the mousewheel forward or up, or negative if scrolled in the
         *   other direction. For a standard wheel-mouse, an increment of 1 relates to the smallest
         *   possible rotation of the mouse wheel. For other scrolling devices, such as scroll
         *   gestures on a track pad, wheel delta may be reported in finer grained increments
         *   (causing this method to return a fractional value).
         * 
         *   Note that behavior for trackpad scroll-gestures may differ by browser, but where
         *   separate vertical and horizontal scroll information is available, this method
         *   refers to a vertical scroll gesture.
         * 
         *   Developers should also be aware
         *   that some browsers and operating systems allow the user to configure the sensitivity
         *   of the mouse wheel or trackpad, which may change this value.
         * 
         * 
         */
        fun getWheelDeltaY(): Number = definedExternally
        /**
         *   Set the HTML for the drag tracker that follows the mouse during a drag and drop interaction.
         * 
         *   Your canvas can use this routine to set the drag tracker to whatever HTML you want like so:
         * 
         *    dragStart : function () {
         *      isc.EventHandler.setDragTracker('Your contents here');
         *    }
         * 
         * 
         * 
         *  @param {string} HTML for the tracker
         *  @param {Integer=} new width for the tracker. Default value: 10
         *  @param {Integer=} new height for the tracker. Default value: 10
         *  @param {Integer=} x-offset for the tracker
         *  @param {Integer=} y-offset for the tracker
         *  @param {Canvas=} properties to configure the dragTracker
         */
        fun setDragTracker(html: String, newWidth: Number?, newHeight: Number?, offsetX: Number?, offsetY: Number?, properties: Canvas?): Unit = definedExternally
        /**
         *   During a drag with Canvas.dragAppearance of either "target" or
         *   "outline", returns the page-relative coordinates of whatever element is being dragged.
         * 
         *   Calling this method allows you to write drag and drop logic that works identically even if
         *   dragAppearance is subsequently changed.
         * 
         * 
         */
        fun getDragRect(): dynamic = definedExternally
        /**
         *   Return the canvas that is the target of the mouse event.
         *   Returns null if no canvas found.
         * 
         * 
         */
        fun getTarget(): Canvas = definedExternally
        /**
         * 
         *   Returns the current dragTarget. This is the component on which the drag and drop
         *   interaction was initiated. This only returns something meaningful during a drag and drop
         *   interaction.
         * 
         * 
         */
        fun getDragTarget(): Canvas = definedExternally
        /**
         *     Return the page-relative X (horizontal) coordinate of an event.
         * 
         * 
         */
        fun getX(): Number = definedExternally
        /**
         *     Return the page-relative Y (vertical) coordinate of an event.
         * 
         * 
         */
        fun getY(): Number = definedExternally
        /**
         *     Returns true if the left mouse button is being pressed.
         * 
         * 
         */
        fun leftButtonDown(): Boolean = definedExternally
        /**
         *     Returns true if the right mouse button is being pressed.
         * 
         * 
         */
        fun rightButtonDown(): Boolean = definedExternally
        /**
         *   Returns true if the middle mouse button is being pressed.
         * 
         *   Checking whether the middle mouse button is pressed can be used to implement power user
         *   shortcuts; however, note that many pointing devices do not have a middle button. Thus, the
         *   application should not require the user to press a middle button in order
         *   to perform some action.
         * 
         */
        fun middleButtonDown(): Boolean = definedExternally
        /**
         *       Returns the numeric characterValue reported by the browser.
         *       Only available on keyPress events, and only for character (or ascii control) keys
         * 
         */
        fun getKeyEventCharacterValue(): Number = definedExternally
        /**
         *     Return the character for the current key being pressed.
         *     Note that this is only set reliably for keyPress events on character keys.
         * 
         * 
         */
        fun getKeyEventCharacter(): String = definedExternally
        /**
         *     Return the name of the key for the event passed in.
         *     Note that this is only set reliably for keyboard events.
         * 
         * 
         */
        fun getKey(): String = definedExternally
        /**
         *     Return true if the shift key is being held down.
         *     Note that this is only set reliably for keyboard events.
         * 
         * 
         */
        fun shiftKeyDown(): Boolean = definedExternally
        /**
         *     Return true if the control key is being held down.
         *     Note that this is only set reliably for keyboard events.
         * 
         * 
         */
        fun ctrlKeyDown(): Boolean = definedExternally
        /**
         *     Return true if the alt (option) key is being held down.
         *     Note that this is only set reliably for keyboard events.
         * 
         * 
         */
        fun altKeyDown(): Boolean = definedExternally
        /**
         *   Return whether this Canvas is masked by a clickMask (see Canvas.showClickMask).
         * 
         * 
         *  @param {Canvas} widget to check
         */
        fun targetIsMasked(target: Canvas): Boolean = definedExternally
    }
}