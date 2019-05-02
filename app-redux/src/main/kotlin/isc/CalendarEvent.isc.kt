@file:JsQualifier("isc")
package isc

/**
 *  A type of Record which represents an event to occur at a specific time, displayed
 *   within the calendar.
 */
open external class CalendarEvent {
    /**
     *  Date object which represents the start date of a CalendarEvent.
     *   The name of this field within the CalendarEvent can be changed via
     *   Calendar.startDateField
     *  @type {Date}
     *  @default null
     */
    open var startDate: Date = definedExternally
    /**
     *  Date object which represents the end date of a CalendarEvent
     *   The name of this field within the CalendarEvent can be changed via
     *   Calendar.endDateField
     *  @type {Date}
     *  @default null
     */
    open var endDate: Date = definedExternally
    /**
     *  The duration of this event. May be specified instead of an
     *   CalendarEvent.endDate and implies that this is a "Period" type event. If
     *   set to zero, implies an "Instant" type event - an event with a start date but no length.
     *  @type {Integer}
     *  @default null
     */
    open var duration: Number = definedExternally
    /**
     *  When a CalendarEvent.duration is set for this event, this is the unit of
     *   that duration. The default is minutes.
     *  @type {TimeUnit}
     *  @default "minute"
     */
    open var durationUnit: 
                           /**
                            *  a millisecond time-unit
                            *  a second time-unit
                            *  a minute time-unit
                            *  an hour time-unit
                            *  a day time-unit
                            *  a week time-unit
                            *  a month time-unit
                            *  a quarter (3 month) time-unit
                            *  a year time-unit
                            */
                           String /* millisecond |  second |  minute |  hour |  day |  week |  month |  quarter |  year */ = definedExternally
    /**
     *  String which represents the name of a CalendarEvent
     *   The name of this field within the CalendarEvent can be changed via
     *   Calendar.nameField
     *  @type {string}
     *  @default null
     */
    open var name: String = definedExternally
    /**
     *  String which represents the description of a CalendarEvent
     *   The name of this field within the CalendarEvent can be changed via
     *   Calendar.descriptionField
     *  @type {string}
     *  @default null
     */
    open var description: String = definedExternally
    /**
     *  Optional boolean value controlling the editability of this particular calendarEvent.
     *   The name of this field within the CalendarEvent can be changed via
     *   Calendar.canEditField.
     *  @type {boolean}
     *  @default null
     */
    open var canEdit: Boolean = definedExternally
    /**
     *  Optional boolean value controlling whether this event can be dragged with the mouse.
     *   The name of this field within the CalendarEvent can be changed via
     *   Calendar.canDragEventField. Only has an effect when
     *   Calendar.canEditEvents is enabled.
     * 
     *   You can separately disallow drag-resize via CalendarEvent.canResize.
     *  @type {boolean}
     *  @default null
     */
    open var canDrag: Boolean = definedExternally
    /**
     *  Optional boolean value controlling whether this event can be drag-resized with the mouse.
     *   The name of this field within the CalendarEvent can be changed via
     *   Calendar.canResizeEventField.
     * 
     *   Only has an effect if Calendar.canEditEvents and
     *   Calendar.canDragEvents are also enabled.
     *  @type {boolean}
     *  @default null
     */
    open var canResize: Boolean = definedExternally
    /**
     *  Boolean indicating whether this event can be moved between lanes. Can also be set at the
     *   Calendar.canEditLane.
     * 
     *   The name of this field within the CalendarEvent can be changed via
     *   Calendar.canEditLaneField.
     *  @type {boolean}
     *  @default null
     */
    open var canEditLane: Boolean = definedExternally
    /**
     *  Boolean indicating whether this event can be moved between lanes. Can also be set at the
     *   Calendar.canEditSublane.
     * 
     *   The name of this field within the CalendarEvent can be changed via
     *   Calendar.canEditSublaneField.
     *  @type {boolean}
     *  @default null
     */
    open var canEditSublane: Boolean = definedExternally
    /**
     *  An optional background color for the body portion of EventCanvas
     *   representing this event in the various CalendarView.
     * 
     *   Note that the recommended approach for styling events is to set a
     *   CalendarEvent.styleName, which allows more complete customization
     *   of both header and body portions.
     *  @type {string}
     *  @default null
     */
    open var backgroundColor: String = definedExternally
    /**
     *  An optional text color for the body portion of EventCanvas
     *   representing this event in the various CalendarView.
     * 
     *   Note that the recommended approach for styling events is to set a
     *   CalendarEvent.styleName, which allows more complete customization
     *   of both header and body portions.
     *  @type {string}
     *  @default null
     */
    open var textColor: String = definedExternally
    /**
     *  An optional border color for the body portion of EventCanvas
     *   representing this event in the various CalendarView.
     * 
     *   Note that the recommended approach for styling events is to set a
     *   CalendarEvent.styleName, which allows more complete customization
     *   of both header and body portions.
     *  @type {string}
     *  @default null
     */
    open var borderColor: String = definedExternally
    /**
     *  An optional background color for the header portion of EventCanvas
     *   representing this event in the various CalendarView.
     * 
     *   Note that the recommended approach for styling events is to set a
     *   CalendarEvent.styleName, which allows more complete customization
     *   of both header and body portions.
     *  @type {string}
     *  @default null
     */
    open var headerBackgroundColor: String = definedExternally
    /**
     *  An optional text color for the header portion of EventCanvas
     *   representing this event in the various CalendarView.
     * 
     *   Note that the recommended approach for styling events is to set a
     *   CalendarEvent.styleName, which allows more complete customization
     *   of both header and body portions.
     *  @type {string}
     *  @default null
     */
    open var headerTextColor: String = definedExternally
    /**
     *  An optional border color for the header portion of EventCanvas
     *   representing this event in the various CalendarView.
     * 
     *   Note that the recommended approach for styling events is to set a
     *   CalendarEvent.styleName, which allows more complete customization
     *   of both header and body portions.
     *  @type {string}
     *  @default null
     */
    open var headerBorderColor: String = definedExternally
    /**
     *  CSS style series to use for the draggable event window that represents this event. If
     *   specified, overrides Calendar.eventWindowStyle for this specific event.
     * 
     *   The name of this field within the CalendarEvent can be changed via
     *   Calendar.eventWindowStyleField
     *  @deprecated \* in favor of CalendarEvent.styleName
     *  @type {CSSStyleName}
     *  @default null
     */
    open var eventWindowStyle: String = definedExternally
    /**
     *  CSS style series to use for Calendar.eventCanvas that
     *   represent this event in the various CalendarView. The basic
     *   series should include three classes - the base style and others suffixed "Header" and "Body".
     * 
     *   If not specified on the event, the style can be specified on the
     *   Calendar.eventStyleName, the CalendarView.eventStyleName or
     *   individually on each Lane.eventStyleName or Lane.sublanes.
     * 
     *   The name of this field within the CalendarEvent can be changed via
     *   Calendar.eventStyleNameField
     *  @type {CSSStyleName}
     *  @default null
     */
    open var styleName: String = definedExternally
    /**
     *  When in Timeline mode, or when Calendar.showDayLanes is true, a string that
     *   represents the name of the Calendar.lanes this CalendarEvent should
     *   sit in. The name of this field within the CalendarEvent can be changed via
     *   Calendar.laneNameField.
     *  @type {string}
     *  @default null
     */
    open var lane: String = definedExternally
    /**
     *  When in Timeline mode, or when Calendar.showDayLanes is true, a string that
     *   represents the name of the Lane.sublanes this CalendarEvent should
     *   sit in. The name of this field within the CalendarEvent can be changed via
     *   Calendar.sublaneNameField.
     *  @type {string}
     *  @default null
     */
    open var sublane: String = definedExternally
}