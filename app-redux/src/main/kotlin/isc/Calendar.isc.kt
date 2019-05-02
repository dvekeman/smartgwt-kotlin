@file:JsQualifier("isc")
package isc

/**
 *  The Calendar component provides several different ways for a user to view and
 *   edit a set of events. Note that the loadingOptionalModules
 *   must be loaded to make use of the Calendar class.
 * 
 *   CalendarEvents
 * 
 *   Events are represented as ordinary JavaScript Objects (see CalendarEvent).
 *   The Calendar expects to be able to read and write a basic set of properties
 *   on events: name, startDate, endDate, description, etc, which can be stored
 *   under configurable property names (see eg Calendar.startDateField).
 * 
 *   Much like a ListGrid manages it's ListGridRecords, the Calendar can
 *   either be passed an ordinary Array of CalendarEvents or can fetch data from a
 *   DataSource. When this is the case, if the DataSource
 *   does not contain fields with the configured property names, an attempt is made to
 *   auto-detect likely-looking fields from those that are present. To see logs indicating that
 *   this has happened, switch default logging preferences to INFO level in the Developer Console.
 * 
 *   If the calendar is bound to a DataSource, event changes by user action or by
 *   calling methods will be saved to the DataSource.
 * 
 *   Navigation
 * 
 *   The calendar supports a number of views by default: Calendar.dayView,
 *   Calendar.weekView, Calendar.monthView and
 *   Calendar.timelineView. The user can navigate using back and forward
 *   buttons or via an attached Calendar.dateChooser.
 * 
 *   Event Manipulation
 * 
 *   Events can be created by clicking directly onto one of the views, or via the
 *   Calendar.addEventButton button. In the day, week and timeline views, the user may
 *   click and drag to create an event of a specific duration.
 * 
 *   Creating an event via click or click and drag pops up the
 *   Calendar.eventDialog, which provides a simple form for
 *   quick event entry (for normal events, only the description is required by default - for
 *   events that are shown in a Calendar.lanes, that field is also required).
 * 
 *   A separate editor called the Calendar.eventEditor provides
 *   an interface for editing all possible properties of an event, including custom
 *   properties. The EventEditor is used whenever a pre-existing event is being
 *   edited, and can also be invoked
 *   by the user wherever the simpler EventDialog appears.
 * 
 *   Events can also be programmatically Calendar.addCalendarEvent,
 *   Calendar.removeEvent, or Calendar.updateCalendarEvent.
 */
open external class Calendar : Canvas, DataBoundComponent {
    /**
     *  The date for which events are displayed in the day, week, and month tabs of
     *   the calendar. Default is today.
     *  @type {Date}
     *  @default 'Today'
     */
    open var chosenDate: Date = definedExternally
    /**
     *  The numeric day (0-6) which the calendar should consider as the first day of the week - if
     *   unset, the default is taken from the current locale.
     *  @type {number}
     *  @default null
     */
    open var firstDayOfWeek: Number = definedExternally
    /**
     *  The base name for the CSS class applied to the grid cells of the day and week views
     *   of the calendar. This style will have "Dark", "Over", "Selected", or "Disabled"
     *   appended to it according to the state of the cell.
     * 
     *   See cellStyleSuffixes for details on how stateful suffixes are combined with the
     *   base style to generate stateful cell styles.
     *  @type {CSSStyleName}
     *  @default "calendar"
     */
    open var baseStyle: String = definedExternally
    /**
     *  The base name for the CSS class applied to the day headers of the month view.
     *   This style will have "Dark", "Over", "Selected", or "Disabled"
     *   appended to it according to the state of the cell.
     * 
     *   See cellStyleSuffixes for details on how stateful suffixes are combined with the
     *   base style to generate stateful cell styles.
     *  @type {CSSStyleName}
     *  @default "calMonthDayHeader"
     */
    open var dayHeaderBaseStyle: String = definedExternally
    /**
     *  The base name for the CSS class applied to the day body of the month view
     *   of the calendar. This style will have "Dark", "Over", "Selected", or "Disabled"
     *   appended to it according to the state of the cell.
     * 
     *   See cellStyleSuffixes for details on how stateful suffixes are combined with the
     *   base style to generate stateful cell styles.
     *  @type {CSSStyleName}
     *  @default "calMonthDayBody"
     */
    open var dayBodyBaseStyle: String = definedExternally
    /**
     *  The base name for the CSS class applied to the day headers of the month view.
     *   This style will have "Dark", "Over", "Selected", or "Disabled"
     *   appended to it according to the state of the cell.
     * 
     *   See cellStyleSuffixes for details on how stateful suffixes are combined with the
     *   base style to generate stateful cell styles.
     *  @type {CSSStyleName}
     *  @default "calMonthDayHeader"
     */
    open var otherDayHeaderBaseStyle: String = definedExternally
    /**
     *  The base name for the CSS class applied to the day body of the month view
     *   of the calendar. This style will have "Dark", "Over", "Selected", or "Disabled"
     *   appended to it according to the state of the cell.
     * 
     *   See cellStyleSuffixes for details on how stateful suffixes are combined with the
     *   base style to generate stateful cell styles.
     *  @type {CSSStyleName}
     *  @default "calMonthDayBody"
     */
    open var otherDayBodyBaseStyle: String = definedExternally
    /**
     *  The CSS style applied to both the header and body of days from other months in the
     *   Calendar.monthView, when Calendar.showOtherDays is false.
     *  @type {CSSStyleName}
     *  @default "calMonthOtherDayBlank"
     */
    open var otherDayBlankStyle: String = definedExternally
    /**
     *  In the Calendar.monthView when Calendar.showDayHeaders is true, this is the minimum
     *   height applied to a day cell and its header combined.
     * 
     *   If showDayHeaders is false, this attribute has no effect - the minimum height
     *   of day cells is either an equal share of the available height, or the rendered height of the
     *   cell's HTML content, whichever is greater. If the latter, a vertical scrollbar is shown.
     *  @type {Integer}
     *  @default "80"
     */
    open var minimumDayHeight: Number = definedExternally
    /**
     *  The base name for the CSS class applied to a cell that is selected via a mouse drag.
     *  @type {CSSStyleName}
     *  @default "calendarCellSelected"
     */
    open var selectedCellStyle: String = definedExternally
    /**
     *  The base name for the CSS class applied to event windows within calendars.
     *   This style will have "Header", "HeaderLabel", and "Body" appended to it, according to
     *   which part of the event window is being styled. For example, to style the header, define
     *   a CSS class called 'eventWindowHeader'.
     *  @deprecated \* in favor of Calendar.eventStyleName
     *  @type {CSSStyleName}
     *  @default null
     */
    open var eventWindowStyle: String = definedExternally
    /**
     *  The base name for the CSS class applied to Calendar.eventCanvas when they're
     *   rendered in calendar views.
     *   This style will have "Header" and "Body" appended to it, according to
     *   which part of the event window is being styled. For example, to style the header, define
     *   a CSS class called 'eventWindowHeader'.
     *  @type {CSSStyleName}
     *  @default "eventWindow"
     */
    open var eventStyleName: String = definedExternally
    /**
     *  The base name for the CSS class applied to the links rendered by Calendar.getDayBodyHTML.
     * 
     *   These links are rendered as plain HTML links using A elements, and the CSS style in the
     *   provided skins references the pseudo-classes :link, :visited, :active, :hover.
     * 
     *   Even though it goes against the general policy of not exposing the HTML structures SC writes out
     *   and not relying on them for styling, applying style to these particular selectors is acceptable,
     *   as we're unlikely to use any other kind of HTML structure than a link.
     *  @type {CSSStyleName}
     *  @default "calMonthEventLink"
     */
    open var calMonthEventLinkStyle: String = definedExternally
    /**
     *  If Calendar.showWorkday is set, this is the style used for cells that are within the workday,
     *   as defined by Calendar.workdayStart and Calendar.workdayEnd, or by a date-specific range
     *   provided in Calendar.getWorkdayStart and Calendar.getWorkdayEnd implementations.
     *  @type {CSSStyleName}
     *  @default "calendarWorkday"
     */
    open var workdayBaseStyle: String = definedExternally
    /**
     *  When using Calendar.showWorkday:true, workdayStart and workdayEnd
     *   specify the time of day when the workday starts and ends, specified as a
     *   String acceptable to Time.parseInput.
     * 
     *   Both start and end time must fall on a 30 minute increment (eg 9:30, but not 9:45).
     * 
     *   The hours of the workday can be customized for particular dates by providing implementations
     *   of Calendar.getWorkdayStart and Calendar.getWorkdayEnd.
     *  @type {Time}
     *  @default "9:00am"
     */
    open var workdayStart: Time = definedExternally
    /**
     *  When using Calendar.showWorkday:true, workdayStart and workdayEnd
     *   specify the time of day when the workday starts and ends, specified as a
     *   String acceptable to Time.parseInput.
     * 
     *   Both start and end time must fall on a 30 minute increment (eg 9:30, but not 9:45).
     * 
     *   The hours of the workday can be customized for particular dates by providing implementations
     *   of Calendar.getWorkdayStart and Calendar.getWorkdayEnd.
     *  @type {Time}
     *  @default "5:00pm"
     */
    open var workdayEnd: Time = definedExternally
    /**
     *  If set, causes the calendar to use Calendar.workdayBaseStyle
     *   for cells falling within the workday as defined by Calendar.workdayStart and Calendar.workdayEnd,
     *   in both the Calendar.weekView and Calendar.dayView.
     * 
     *   The hours of the workday can be customized for particular dates by providing implementations
     *   of Calendar.getWorkdayStart and Calendar.getWorkdayEnd.
     *  @type {boolean}
     *  @default false
     */
    open var showWorkday: Boolean = definedExternally
    /**
     *  Array of days that are considered workdays when Calendar.showWorkday is true.
     *   Has no effect if Calendar.dateIsWorkday is implemented.
     *  @type {Array<any>}
     *  @default "[1,2,3,4,5]"
     */
    open var workdays: Array<dynamic> = definedExternally
    /**
     *  If set, causes the Calendar.workdayStart to be sized to fill the available space
     *   in the day view and week view, and automatically scrolls these views to the start of the
     *   workday when the calendar is first displayed and whenever the user switches to a new day or
     *   week.
     *  @type {boolean}
     *  @default false
     */
    open var scrollToWorkday: Boolean = definedExternally
    /**
     *  The number of minutes per row in Calendar.dayView and
     *   Calendar.weekView views. The default of 30 minutes shows two rows per hour.
     *   Note that this value must divide into 60.
     *  @type {Integer}
     *  @default "30"
     */
    open var minutesPerRow: Number = definedExternally
    /**
     *  A minute value that indicates which rows should show times in vertical views, like
     *   Calendar.dayView and Calendar.weekView. The default of 60 minutes
     *   shows titles on the first row of each hour. The value provided must be a multiple of
     *   Calendar.minutesPerRow and be no larger than 60.
     *  @type {Integer}
     *  @default "60"
     */
    open var rowTitleFrequency: Number = definedExternally
    /**
     *  The name of the name field on a CalendarEvent.
     *  @type {string}
     *  @default "name"
     */
    open var nameField: String = definedExternally
    /**
     *  The name of the description field on a CalendarEvent.
     *  @type {string}
     *  @default "description"
     */
    override var descriptionField: String = definedExternally
    /**
     *  The name of the start date field on a CalendarEvent.
     *  @type {string}
     *  @default "startDate"
     */
    open var startDateField: String = definedExternally
    /**
     *  The name of the end date field on a CalendarEvent.
     *  @type {string}
     *  @default "endDate"
     */
    open var endDateField: String = definedExternally
    /**
     *  The name of the CalendarEvent.duration field on a CalendarEvent.
     *  @type {string}
     *  @default "duration"
     */
    open var durationField: String = definedExternally
    /**
     *  The name of the CalendarEvent.durationUnit field on a
     *   CalendarEvent.
     *  @type {string}
     *  @default "durationUnit"
     */
    open var durationUnitField: String = definedExternally
    /**
     *  The name of the field which will determine the Calendar.lanes in which this
     *   event will be displayed in Timelines and in the Calendar.dayView, if
     *   Calendar.showDayLanes is true.
     *  @type {string}
     *  @default "lane"
     */
    open var laneNameField: String = definedExternally
    /**
     *  When set to true, hides any Calendar.lanes that doesn't have any active events
     *   in the current dataset.
     *  @type {boolean}
     *  @default null
     */
    open var hideUnusedLanes: Boolean = definedExternally
    /**
     *  When set to true, causes Calendar.lanes to be sub-divided according to their
     *   set of Lane.sublanes.
     *  @type {boolean}
     *  @default null
     */
    open var useSublanes: Boolean = definedExternally
    /**
     *  The name of the field which will determine the Lane.sublanes in which this
     *   event will be displayed, within its parent Lane, in Timelines and in the
     *   Calendar.dayView, if Calendar.showDayLanes is true.
     *  @type {string}
     *  @default "sublane"
     */
    open var sublaneNameField: String = definedExternally
    /**
     *  The name of the leading date field for each event. When this attribute and
     *   Calendar.trailingDateField are present in the data, a line extends out from the event showing
     *   the extent of the leading and trailing dates - useful for visualizing a pipeline of events
     *   where some can be moved a certain amount without affecting others.
     *  @type {string}
     *  @default "leadingDate"
     */
    open var leadingDateField: String = definedExternally
    /**
     *  The name of the trailing date field for each event. When this attribute and
     *   Calendar.leadingDateField are present in the data, a line extends out from the event showing
     *   the extent of the leading and trailing dates - useful for visualizing a pipeline of events
     *   where some can be moved a certain amount without affecting others.
     *  @type {string}
     *  @default "trailingDate"
     */
    open var trailingDateField: String = definedExternally
    /**
     *  The name of the field used to override Calendar.eventWindowStyle for an individual
     *   CalendarEvent. See CalendarEvent.eventWindowStyle.
     *  @deprecated \* in favor of Calendar.eventStyleNameField
     *  @type {string}
     *  @default "eventWindowStyle"
     */
    open var eventWindowStyleField: String = definedExternally
    /**
     *  The name of the field used to override Calendar.eventStyleName for an individual
     *   CalendarEvent.styleName.
     *  @type {string}
     *  @default "styleName"
     */
    open var eventStyleNameField: String = definedExternally
    /**
     *  Name of the field on each CalendarEvent that determines whether it can be edited in
     *   the Calendar.eventEditor. Note that an event with canEdit
     *   set to true can also have Calendar.canDragEventField or
     *   Calendar.canResizeEventField set to false,
     *   which would still allow editing, but not via drag operations.
     *  @type {string}
     *  @default "canEdit"
     */
    open var canEditField: String = definedExternally
    /**
     *  Name of the field on each CalendarEvent that determines whether that event can be
     *   moved between lanes.
     *  @type {string}
     *  @default "canEditLane"
     */
    open var canEditLaneField: String = definedExternally
    /**
     *  Name of the field on each CalendarEvent that determines whether that event can be
     *   moved between individual Lane.sublanes in a Lane.
     *  @type {string}
     *  @default "canEditSublane"
     */
    open var canEditSublaneField: String = definedExternally
    /**
     *  Name of the field on each CalendarEvent that determines whether an event shows a
     *   remove button.
     *  @type {string}
     *  @default "canRemove"
     */
    open var canRemoveField: String = definedExternally
    /**
     *  Name of the field on each CalendarEvent that determines whether an EventCanvas
     *   can be moved or resized by dragging with the mouse. Note that
     *   Calendar.canEditEvents must be true for dragging to be allowed.
     *  @type {string}
     *  @default "canDrag"
     */
    open var canDragEventField: String = definedExternally
    /**
     *  Name of the field on each CalendarEvent that determines whether an event can be
     *   resized by dragging.
     *  @type {string}
     *  @default "canResize"
     */
    open var canResizeEventField: String = definedExternally
    /**
     *  When set to true, allows events to be managed by duration, as well as by end date. Values
     *   can be set for CalendarEvent.duration and
     *   CalendarEvent.durationUnit on each event, and are then maintained,
     *   instead of the end date, when alterations are made to the event via editors or dragging
     *   with the mouse.
     *  @type {boolean}
     *  @default null
     */
    open var allowDurationEvents: Boolean = definedExternally
    /**
     *  The pixel space to leave between events and the edges of the Calendar.lanes or
     *   Lane.sublanes they appear in. Only applicable to
     *   Calendar.timelineView and to Calendar.dayView showing
     *   Calendar.showDayLanes.
     *  @type {Integer}
     *  @default "0"
     */
    open var laneEventPadding: Number = definedExternally
    /**
     *  The number of pixels to leave to the right of events so overlapping events can still be
     *   added using the mouse.
     *  @type {Integer}
     *  @default "10"
     */
    open var eventDragGap: Number = definedExternally
    /**
     *  Augments the width of week event windows slightly to avoid duplicate adjacent borders
     *   between events.
     *  @type {boolean}
     *  @default false
     */
    open var weekEventBorderOverlap: Boolean = definedExternally
    /**
     *  Configures the levels of HeaderLevel shown above the event area, and
     *   their time units.
     * 
     *   Header levels are provided from the top down, so the first header level should be the largest
     *   time unit and the last one the smallest. The smallest is then used for the actual
     *   field-headers.
     *  @type {Array<Partial<HeaderLevel>>}
     *  @default null
     */
    open var headerLevels: Array<dynamic> = definedExternally
    /**
     *  The number of minutes that determines the positions to which events will snap when rendered,
     *   and when moved or resized with the mouse.
     * 
     *   If unset (the default), all views will snap to each cell boundary; 30 minutes in a default
     *   vertical view, or one Calendar.timelineGranularity in a default Timeline.
     * 
     *   If set to zero, views will snap to one of a set of known "sensible" defaults: for a default
     *   vertical, this will be 5 minutes. For timelines, the eventSnapGap is automatic depending on
     *   the current Calendar.timelineGranularity. If Calendar.timelineUnitsPerColumn
     *   is greater than 1, the snapGap is set to one unit of the current granularity. So, a
     *   cell-resolution of 15 minutes would snap to every minute, assuming there are at least 15
     *   pixels per column. Otherwise, the snapGap is either 15 minutes, 1 hour, one day or one
     *   month, depending on granularity.
     * 
     *   If any other value is specified, it is used where possible.
     * 
     *   If the specified or calculated value is less than the time covered by a single pixel in the
     *   current view, then it can't be represented. In this case, it is rounded up to the lowest of
     *   a set of "sensible" time-spans that can be represented: one of
     *   [1, 5, 10, 15, 20, 30, 60, 120, 240, 360, 480, 720, 1440].
     * 
     *   For example - a Timeline showing "day" columns cannot support an eventSnapGap of 1 minute,
     *   unless each column is at least 1440 pixels wide - if the columns were only 150px wide, then
     *   each pixel would represent around 9.6 minutes, which would result in unpleasant and unexpected
     *   time-offsets when dragging events. So, the calculated eventSnapGap will be rounded
     *   up to the nearest "sensible" time-span - in this case, 10 minutes. If the columns were only
     *   60px wide, it would be 30 minutes.
     *  @type {Integer}
     *  @default null
     */
    open var eventSnapGap: Number = definedExternally
    /**
     *  Determines whether the quick event dialog is displayed when a time is clicked. If this is
     *   false, the full event editor is displayed.
     *  @type {boolean}
     *  @default true
     */
    open var showQuickEventDialog: Boolean = definedExternally
    /**
     *  The set of fields for the Calendar.eventEditor.
     * 
     *   The default set of fields are:
     * 
     *    {name: "startHours", title: "From",   editorType: "SelectItem", type: "integer", width: 60},
     *    {name: "startMinutes", showTitle: false, editorType: "SelectItem", type: "integer", width: 60},
     *    {name: "startAMPM", showTitle: false, type: "select", width: 60},
     *    {name: "invalidDate", type: "blurb", colSpan: 4, visible: false}
     *    {name: "endHours", title: "To",    editorType: "SelectItem", type: "integer", width: 60},
     *    {name: "endMinutes", showTitle: false, editorType: "SelectItem", type: "integer", width: 60},
     *    {name: "endAMPM", showTitle: false, type: "select", width: 60},
     *    {name: "name", title: "Name", type: "text", colSpan: 4},
     *    {name: "description", title: "Description", type: "textArea", colSpan: 4, height: 50}
     * 
     *   See the Customized Binding example below for more information on altering default datasource
     *   fields within forms.
     *  @type {Array<Partial<FormItem>>}
     *  @default "see below"
     */
    open var eventEditorFields: Array<dynamic> = definedExternally
    /**
     *  The set of fields for the Calendar.eventDialog.
     * 
     *   The default set of fields are:
     * 
     *    {name: "name", title: "Event Name", type: nameType, width: 250 },
     *    {name: "save", title: "Save Event", editorType: "SubmitItem", endRow: false},
     *    {name: "details", title: "Edit Details", type: "button", startRow: false}
     * 
     *   See the Customized Binding example below for more information on altering default datasource
     *   fields within forms.
     *  @type {Array<Partial<FormItem>>}
     *  @default "see below"
     */
    open var eventDialogFields: Array<dynamic> = definedExternally
    /**
     *  If true, users can create new events.
     *  @type {boolean}
     *  @default true
     */
    open var canCreateEvents: Boolean = definedExternally
    /**
     *  If true, users can edit existing events.
     *  @type {boolean}
     *  @default true
     */
    open var canEditEvents: Boolean = definedExternally
    /**
     *  If true, users can delete existing events. Defaults to Calendar.canEditEvents.
     *  @deprecated \* in favor of Calendar.canRemoveEvents
     *  @type {boolean}
     *  @default null
     */
    open var canDeleteEvents: Boolean = definedExternally
    /**
     *  If true, users can remove existing events. Defaults to Calendar.canEditEvents.
     *  @type {boolean}
     *  @default true
     */
    open var canRemoveEvents: Boolean = definedExternally
    /**
     *  A boolean value controlling whether users can drag-reposition events. By default, this is
     *   false for Touch devices, where drag gestures scroll the view, and true otherwise.
     * 
     *   Only has an effect when Calendar.canEditEvents is true.
     *  @type {boolean}
     *  @default null
     */
    open var canDragEvents: Boolean = definedExternally
    /**
     *  Can CalendarEvent be resized by dragging appropriate edges of the
     *   EventCanvas.vertical? Only has an effect when both
     *   Calendar.canEditEvents and Calendar.canDragEvents
     *   are true. Set this attribute to false to disallow drag-resizing.
     *  @type {boolean}
     *  @default true
     */
    open var canResizeEvents: Boolean = definedExternally
    /**
     *  Determines whether the Calendar.dateChooser is displayed.
     *  @type {boolean}
     *  @default true
     */
    open var showDateChooser: Boolean = definedExternally
    /**
     *  If true, weekend days appear in a disabled style and events cannot be created on weekends.
     *   Which days are considered weekends is controlled by Calendar.weekendDays.
     *  @type {boolean}
     *  @default true
     */
    open var disableWeekends: Boolean = definedExternally
    /**
     *  An array of integer day-numbers that should be considered to be weekend days by this
     *   Calendar instance. If unset, defaults to the set of days indicated
     *   DateUtil.weekendDays.
     *  @type {Array<Partial<Integer>>}
     *  @default null
     */
    open var weekendDays: Array<dynamic> = definedExternally
    /**
     *  Suppresses the display of weekend days in the Calendar.weekView,
     *   Calendar.monthView and Calendar.timelineView views, and
     *   disallows the creation of events on weekends. Which days are considered weekends is
     *   controlled by Calendar.weekendDays.
     *  @type {boolean}
     *  @default true
     */
    open var showWeekends: Boolean = definedExternally
    /**
     *  If true, the default, show a header cell for each day cell in the
     *   Calendar.monthView, with both cells having a minimum combined height of
     *   Calendar.minimumDayHeight. If false, the header cells will not be shown, and the value
     *   of Calendar.minimumDayHeight is ignored. This causes the available vertical space in month
     *   views to be shared equally between day cells, such that no vertical scrollbar is required
     *   unless the HTML in the cells renders them taller than will fit.
     *  @type {boolean}
     *  @default true
     */
    open var showDayHeaders: Boolean = definedExternally
    /**
     *  If set to true, in the Calendar.monthView, days that fall in an adjacent month are
     *   still shown with a header and body area, and are interactive. Otherwise days from other
     *   months are rendered in the Calendar.otherDayBlankStyle and are non-interactive.
     *  @type {boolean}
     *  @default true
     */
    open var showOtherDays: Boolean = definedExternally
    /**
     *  When true, shows the current Calendar.chosenDate in a selected style
     *   in the Calendar.monthView Has no effect in other views.
     *  @type {boolean}
     *  @default true
     */
    open var selectChosenDate: Boolean = definedExternally
    /**
     *  If set to true, enables the auto-arrangement of events that share time in the calendar. The
     *   default is true.
     *  @type {boolean}
     *  @default true
     */
    open var eventAutoArrange: Boolean = definedExternally
    /**
     *  If set to true, clicking an event will bring it to the front of the zorder.
     *  @type {boolean}
     *  @default null
     */
    open var bringEventsToFront: Boolean = definedExternally
    /**
     *  When Calendar.eventAutoArrange is true, setting eventOverlap to true causes events that
     *   share timeslots to overlap each other by a percentage of their width, specified by
     *   Calendar.eventOverlapPercent. The default is true.
     *  @type {boolean}
     *  @default true
     */
    open var eventOverlap: Boolean = definedExternally
    /**
     *  The size of the overlap, presented as a percentage of the width of events sharing timeslots.
     *  @type {number}
     *  @default "10"
     */
    open var eventOverlapPercent: Number = definedExternally
    /**
     *  When set to true, events that start at the same time will not overlap each other to prevent
     *   events having their close button hidden.
     *  @type {boolean}
     *  @default false
     */
    open var eventOverlapIdenticalStartTimes: Boolean = definedExternally
    /**
     *  A boolean value controlling whether the Calendar shows tabs for available calendar views.
     *   By default, this is true for handsets and false otherwise.
     *  @type {boolean}
     *  @default false
     */
    open var minimalUI: Boolean = definedExternally
    /**
     *  A boolean value controlling whether new events of varying length can be created by dragging
     *   the cursor. By default, this is false for Touch devices and true otherwise.
     *  @type {boolean}
     *  @default null
     */
    open var canDragCreateEvents: Boolean = definedExternally
    /**
     *  TabSet for managing calendar views when multiple views are available (eg,
     *   Calendar.dayView and Calendar.monthView).
     *  @type {TabSet}
     *  @default null
     */
    open var mainView: TabSet = definedExternally
    /**
     *  CalendarView used to display events that pertain to a given day.
     *  @type {CalendarView}
     *  @default null
     */
    open var dayView: CalendarView = definedExternally
    /**
     *  CalendarView used to display events that pertain to a given week.
     *  @type {CalendarView}
     *  @default null
     */
    open var weekView: CalendarView = definedExternally
    /**
     *  CalendarView used to display events that pertain to a given month.
     *  @type {CalendarView}
     *  @default null
     */
    open var monthView: CalendarView = definedExternally
    /**
     *  DateChooser used to select the date for which events will be displayed.
     *  @type {DateChooser}
     *  @default null
     */
    open var dateChooser: DateChooser = definedExternally
    /**
     *  When showing a Calendar.timelineView, or a Calendar.dayView when
     *   Calendar.showDayLanes is true, whether to make lane boundaries more obvious by showing
     *   alternate lanes in a different color.
     *  @type {boolean}
     *  @default null
     */
    open var alternateLaneStyles: Boolean = definedExternally
    /**
     *  When set to true, causes Calendar.timelineView, and Calendar.dayView with
     *   Calendar.showDayLanes set, to highlight the Lane under the mouse with the "Over" style.
     *  @type {boolean}
     *  @default null
     */
    open var showLaneRollOver: Boolean = definedExternally
    /**
     *  A List of CalendarEvent objects, specifying the data to be used to populate the
     *   calendar.
     * 
     *   This property will typically not be explicitly specified for databound Calendars, where
     *   the data is returned from the server via databound component methods such as
     *   Calendar.fetchData. In this case the data objects will be set to a
     *   ResultSet rather than a simple array.
     *  @type {Array<Partial<CalendarEvent>>}
     *  @default null
     */
    open var data: Array<dynamic> = definedExternally
    /**
     *  The DataSource that this component should bind to for default fields and for performing
     *   DSRequest.
     * 
     *   Can be specified as either a DataSource instance or the String ID of a DataSource.
     *  @type {DataSource | GlobalId}
     *  @default null
     */
    override var dataSource: dynamic = definedExternally
    /**
     *  If true, when this component is first drawn, automatically call this.fetchData().
     *   Criteria for this fetch may be picked up from Calendar.initialCriteria, and textMatchStyle may
     *   be specified via ListGrid.autoFetchTextMatchStyle.
     * 
     *   NOTE: if autoFetchData is set, calling
     *   ListGrid.fetchData before draw will cause two requests to be issued, one from the manual
     *   call to fetchData() and one from the autoFetchData setting. The second request will use
     *   only Calendar.initialCriteria and not any other criteria or settings from the first request.
     *   Generally, turn off autoFetchData if you are going to manually call ListGrid.fetchData at any time.
     *  @type {boolean}
     *  @default false
     */
    override var autoFetchData: Boolean = definedExternally
    /**
     *  If Calendar.autoFetchData is true, this attribute allows the developer to
     *   specify a textMatchStyle for the initial ListGrid.fetchData call.
     *  @type {TextMatchStyle}
     *  @default null
     */
    open var autoFetchTextMatchStyle: 
                                      /**
                                       *  case-insensitive exact match ("foo" matches "foo" and "FoO", but not "FooBar")
                                       *  case-sensitive exact match ("foo" matches only "foo")
                                       *  case-insenstive substring match ("foo" matches "foobar" and "BarFoo")
                                       *  case-insensitive prefix match ("foo" matches "FooBar" but not "BarFoo")
                                       *   textMatchStyle behavior is consistent across the client and all three of the built-in
                                       *   server DataSource implementations - SQL, Hibernate and JPA - to the maximum extent that is
                                       *   practical. Known inconsistencies, some of which can be tweaked with configuration settings,
                                       *   are described below
                                       * 
                                       *  - textMatchStyle can be disabled for any individual field with the
                                       *   DataSourceField.ignoreTextMatchStyle declaration. This behavior is consistent
                                       *   across client and server implementations, with the proviso that case-sensitive behavior
                                       *   is inherently inconsistent in the server-side implementations (see below for a more
                                       *   detailed discussion of this)
                                       * 
                                       *  - textMatchStyle is forced to "exactCase" for DataSourceField.primaryKey
                                       *   fields on update and remove operations, unless
                                       *   OperationBinding.allowMultiUpdate is in force. This means that a normal update
                                       *   or remove operation - which is constrained by a unique primaryKey value or combination, to
                                       *   affect only a single data row - will use an equality match on all primaryKey fields. This
                                       *   is desirable because it makes index usage more likely. Note that this means the key values
                                       *   "foo" and "FOO" are distinct, which is a change from previous behavior. For most databases,
                                       *   this change will have no effect because most databases do not by default allow primaryKey
                                       *   values that only differ in case anyway - if a table has a row with a PK of "foo" and you
                                       *   try to insert a row with a PK of "FOO", most databases will fail with a constraint violation.
                                       *   However, if you are using a database hat allows key values that differ only in case, and you
                                       *   need to support this for some reason, you can switch the framework back to the previous
                                       *   behavior by setting property allow.case.sensitive.pks to true in
                                       *   your server.properties file. Note, we do not recommend this; in fact, we do
                                       *   not recommend the use of text primaryKey fields at all. Where you have control ,we would
                                       *   always recommend the use of automatically incrementing numeric sequence keys.
                                       * 
                                       *  - textMatchStyle does not apply to boolean or temporal (date, datetime, time)
                                       *   DataSourceField.type. Such fields are always checked for equality. If
                                       *   you have a need for more complex matching, such as date-range checking, use AdvancedCriteria
                                       * 
                                       *  - Critiera values for temporal fields must be real dates (Javascript Date
                                       *   objects on the client, instances of java.util.Date on the server). Attempting
                                       *   to match against a string or any other type of value will result in an "always fails"
                                       *   clause being generated. This behavior is how the client code has always worked, but is a
                                       *   change for the server-side DataSources, in the interests of consistency. The previous
                                       *   behavior was:
                                       * 
                                       *  - SQLDataSource used to attempt to match the date column to the criteria value provided;
                                       *    if that value was an appropriately-formatted string, that attempt might have
                                       *    worked, but it would be database-specific. If you have an application that depends on
                                       *    this old behavior, you can switch it back on by adding the following to your
                                       *    server.properties file:
                                       *    sql.temporal.fields.require.date.criteria: false
                                       * 
                                       *  - HibernateDataSource and JPADataSource used to skip such clauses altogether, which
                                       *    results in the opposite behavior (there is an implied "always succeeds" clause, because
                                       *    the clause is not present in the query at all). If you have an application that depends on
                                       *    this old behavior, you can switch it back on by adding the following to your
                                       *    server.properties file:
                                       *    jpa.temporal.fields.require.date.criteria: false or
                                       *    hibernate.temporal.fields.require.date.criteria: false, as appropriate
                                       * 
                                       * 
                                       *  - textMatchStyle does not apply to fields used in the joins generated to satisfy
                                       *   DataSourceField.includeFrom declarations or entity relations in
                                       *   Hibernate or JPA. Again, such comparisons are always for equality
                                       * 
                                       *  - textMatchStyle is applied to numeric fields only if the supplied criteria value
                                       *   is a string. So for a numeric field "myNumber", we will match 10, 100, 110 and 1000 if a
                                       *   criteria value of "10" (the quoted string) is supplied, but we will only match 10 if a
                                       *   criteria value of 10 (the actual number) is supplied
                                       * 
                                       *  - This is a change in behavior for the server-side DataSource implementations, in the
                                       *    interests of consistency with the client behavior. Previously, all three of the built-in
                                       *    DataSource implementations applied textMatchStyle to numeric fields regardless of the
                                       *    criteria value's type. If you have an application that depends on this old behavior,
                                       *    you can switch it back on by adding the following to your server.properties
                                       *    file: sql.substring.numeric.criteria: true or
                                       *    hibernate.substring.numeric.criteria: true or
                                       *    jpa.substring.numeric.criteria: true, as appropriate
                                       * 
                                       * 
                                       *  - "exactCase" matching cannot be made consistent across all database providers because
                                       *   each database has its own idea of whether case-sensitive matching should be the default,
                                       *   and how to switch it on and off (if that is even possible)
                                       * 
                                       *  - Microsoft SQL Server must have case-sensitive matching enabled by setting a
                                       *    case-sensitive collation when the database is created (there are more fine-grained
                                       *    options, but we do not recommend them because of the scope for further inconsistency,
                                       *    where "exactCase" works correctly on table A but not on table B). See
                                       *    MSDN for details
                                       * 
                                       *  - HSQLDB has case sensitivity set with the SET IGNORECASE directive -
                                       *    see here
                                       * 
                                       *  - MySQL is case-insensitive, but since it provides an easy way to do per-query,
                                       *    case-sensitive matching in SQL, we work around it for that database, but only in
                                       *    SQL DataSources
                                       * 
                                       * 
                                       *  - If you are using Hibernate or JPA, whether "exactCase" works as expected depends
                                       *   entirely on the underlying database. Unlike the SQL DataSource, where we have fine-grained
                                       *   control of the SQL that the database executes, we are constrained by what the ORM will
                                       *   allow. This prevents us from compensating for database quirks, like we do with MySQL's
                                       *   case-insensitivity in the SQL DataSource
                                       * 
                                       */
                                      String /* exact |  exactCase |  substring |  startsWith */ = definedExternally
    /**
     *  Criteria to be used when Calendar.autoFetchData is set.
     * 
     *   This property supports dynamicCriteria - use Criterion.valuePath
     *   to refer to values in the Canvas.ruleScope.
     *  @type {Criteria}
     *  @default null
     */
    override var initialCriteria: dynamic = definedExternally
    /**
     *  Whether to show fields marked detail:true when a DataBoundComponent is
     *   given a DataSource but no component.fields.
     * 
     *   The detail property is used on DataSource fields to mark fields that
     *   shouldn't appear by default in a view that tries to show many records in a small space.
     *  @type {boolean}
     *  @default true
     */
    override var showDetailFields: Boolean = definedExternally
    /**
     *  How to fetch and manage records retrieve from the server. See FetchMode.
     * 
     *   This setting only applies to the ResultSet automatically created by calling
     *   ListGrid.fetchData. If a pre-existing ResultSet is passed to setData() instead, it's
     *   existing setting for ResultSet.fetchMode applies.
     *  @type {FetchMode}
     *  @default "paged"
     */
    override var dataFetchMode: 
                                /**
                                 *  All records that match the current filter are fetched. Sorting is        performed on the client.
                                 *  Only requested ranges of records are fetched, with predictive fetch        ahead. Sorting is performed on the server.
                                 *  All records available from the DataSource are fetched. Filtering by        search criteria and sorting are both performed on the client.
                                 */
                                String /* basic |  paged |  local */ = definedExternally
    /**
     *  If set to true, show the Calendar.timelineView.
     *  @type {boolean}
     *  @default false
     */
    open var showTimelineView: Boolean = definedExternally
    /**
     *  CalendarView used to display events in lanes in a horizontal Timeline view.
     *  @type {CalendarView}
     *  @default null
     */
    open var timelineView: CalendarView = definedExternally
    /**
     *  When set to true, the default, each EventCanvas is rendered as it
     *   appears in the viewport. If set to false, all events are rendered up-front, whenever the
     *   current range changes.
     *  @type {boolean}
     *  @default true
     */
    open var renderEventsOnDemand: Boolean = definedExternally
    /**
     *  The granularity in which the Calendar.timelineView will display events.
     *   Possible values are those available in the built-in TimeUnit type.
     *  @type {TimeUnit}
     *  @default "day"
     */
    open var timelineGranularity: 
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
     *  How many units of Calendar.timelineGranularity each cell represents.
     *  @type {Integer}
     *  @default "1"
     */
    open var timelineUnitsPerColumn: Number = definedExternally
    /**
     *  Can Timeline events be stretched by their left and right edges?
     *  @deprecated \* in favor of Calendar.canResizeEvents;
     *  @type {boolean}
     *  @default false
     */
    open var canResizeTimelineEvents: Boolean = definedExternally
    /**
     *  Can events be moved between lanes? If so, the event can be dragged to a different
     *   Calendar.lanes, and the event Calendar.eventDialog and
     *   Calendar.eventEditor allow a lane to be selected with a drop-down chooser.
     * 
     *   In either case, the event's Calendar.laneNameField is updated automatically.
     * 
     *   If set to false, cross-lane dragging is disallowed and drop-down Lane-choosers are disabled
     *   when editing existng events. When creating Calendar.canCreateEvents,
     *   the Lane-chooser remains enabled so an initial Lane can be selected.
     * 
     *   This setting can be overridden on each CalendarEvent.canEditLane.
     *  @type {boolean}
     *  @default null
     */
    open var canEditLane: Boolean = definedExternally
    /**
     *  Can events be moved between sublanes?
     * 
     *   If so, the event can be dragged to a different Lane.sublanes within the same
     *   parent Lane and, when it's editor is shown, an additional drop-down widget is provided
     *   allowing the sublane to be altered.
     * 
     *   If the sublane is locked, but the Calendar.canEditLane isn't, an update
     *   to the event's Calendar.laneNameField will be allowed, assuming that the
     *   new Lane has an existing sublane with the same name.
     * 
     *   In either case, the event's Calendar.sublaneNameField is updated
     *   automatically.
     * 
     *   This setting can be overridden on each CalendarEvent.canEditSublane.
     *  @type {boolean}
     *  @default null
     */
    open var canEditSublane: Boolean = definedExternally
    /**
     *  If true, lanes can be reordered by dragging their Calendar.laneFields
     *   with the mouse.
     *  @type {boolean}
     *  @default null
     */
    open var canReorderLanes: Boolean = definedExternally
    /**
     *  The start date of the calendar Timeline. Has no effect in
     *   other views. If not specified, defaults to a timeline starting from the beginning
     *   of the current Calendar.timelineGranularity and spanning
     *   Calendar.defaultTimelineColumnSpan columns of that granularity.
     * 
     *   To set different start and Calendar.endDate dates after initial draw,
     *   see Calendar.setTimelineRange.
     * 
     *   Note that this attribute may be automatically altered if showing
     *   Calendar.headerLevels, to fit to header boundaries.
     *  @type {Date}
     *  @default null
     */
    open var startDate: Date = definedExternally
    /**
     *  The number of columns of the Calendar.timelineGranularity to
     *   give the timeline by default if no Calendar.endDate is provided. The
     *   default is 20.
     *  @type {number}
     *  @default "20"
     */
    open var defaultTimelineColumnSpan: Number = definedExternally
    /**
     *  When using the Next and Previous arrows to scroll a Timeline, this is the number of columns
     *   of the Calendar.timelineGranularity to scroll by. With the
     *   default value of null, the Timeline will scroll by its current length.
     *  @type {number}
     *  @default null
     */
    open var columnsPerPage: Number = definedExternally
    /**
     *  The end date of the calendar timeline view. Has no effect in other views.
     * 
     *   To set different Calendar.startDate and end dates after initial draw,
     *   see Calendar.setTimelineRange.
     * 
     *   Note that this attribute may be automatically altered if showing
     *   Calendar.headerLevels, to fit to header boundaries.
     *  @type {Date}
     *  @default null
     */
    open var endDate: Date = definedExternally
    /**
     *  The text to appear before the week number in the title of TimeUnit
     *   HeaderLevels when this calendar is showing a timeline.
     *  @type {HTMLString}
     *  @default "Week"
     */
    open var weekPrefix: String = definedExternally
    /**
     *  Indicates the type of controls to use in event-windows. Valid values are those in the
     *   DateEditingStyle type.
     * 
     *   If unset, the editing style will be set to the field-type on the DataSource, if there is one.
     *   If there's no DataSource, it will be set to "date" if the
     *   Calendar.timelineGranularity is "day" or larger and "time" if granularity
     *   is "minute" or smaller, otherwise "datetime".
     *  @type {DateEditingStyle}
     *  @default null
     */
    open var dateEditingStyle: 
                               /**
                                *  allows editing of the logical start and end dates of the event
                                *  allows editing of both date and time
                                *  allows editing of the time portion of the event only
                                */
                               String /* date |  datetime |  time */ = definedExternally
    /**
     *  If true, allows the lanes in a Timeline to be grouped by providing a value for
     *   Calendar.laneGroupByField. The fields available for grouping on
     *   are those defined as Calendar.laneFields. Since these are definitions
     *   for ListGridField, you can choose to ListGridField.showIf
     *   the field in the timeline, but still have it available for grouping.
     *  @type {boolean}
     *  @default null
     */
    open var canGroupLanes: Boolean = definedExternally
    /**
     *  For timelines with Calendar.canGroupLanes set to true, this is a
     *   field name or array of field names on which to group the lanes in a timeline.
     *  @type {string | Array<Partial<string>>}
     *  @default null
     */
    open var laneGroupByField: dynamic = definedExternally
    /**
     *  Describes the default state of lane groups in timelines when
     *   Calendar.groupLanesBy is called.
     * 
     *   Possible values are:
     * 
     * 
     *  - "all": open all groups
     * 
     *  - "first": open the first group
     * 
     *  - "none": start with all groups closed
     * 
     *  - Array of values that should be opened
     * 
     *  @type {GroupStartOpen | Array<any>}
     *  @default "first"
     */
    open var laneGroupStartOpen: dynamic = definedExternally
    /**
     *  An array of Lane definitions that represent the rows of the Calendar.timelineView, or
     *   the columns of the Calendar.dayView if Calendar.showDayLanes is true.
     *  @type {Array<Partial<Lane>>}
     *  @default null
     */
    open var lanes: Array<dynamic> = definedExternally
    /**
     *  Field definitions for the frozen area of the Calendar.timelineView, which shows data about the
     *   timeline Calendar.lanes. Each field shows one attribute of the objects provided as
     *   Calendar.lanes.
     * 
     *   When Calendar.canGroupLanes is enabled, only fields that are specified
     *   as lane fields can be used as group fields.
     *  @type {Array<Partial<ListGridField>>}
     *  @default null
     */
    open var laneFields: Array<dynamic> = definedExternally
    /**
     *  If set to true, the Calendar.dayView uses Calendar.lanes to render multiple
     *   vertical "lanes" within the day, very much like a vertical Timeline.
     * 
     *   Day lanes are useful for showing events for various entities on the same day - agendas for
     *   various staff members, for example, or delivery schedules for a fleet of trucks.
     * 
     *   Each day lane is self-contained, showing in a column with a header and individual events
     *   are placed in CalendarEvent.lane, respecting padding and
     *   overlapping. If Calendar.canEditEvents is true, events can be drag-moved or drag-resized
     *   from their top and bottom edges, within the containing lane. To allow events to be dragged
     *   from one lane into another, see Calendar.canEditLane.
     *  @type {boolean}
     *  @default null
     */
    open var showDayLanes: Boolean = definedExternally
    /**
     *  When showing Calendar.showDayLanes in the Calendar.dayView, this attribute sets
     *   the minimum width of each column or field.
     *  @type {Integer}
     *  @default null
     */
    open var minLaneWidth: Number = definedExternally
    /**
     *  A set of SortSpecifier for customizing the render order of events
     *   that overlap.
     * 
     *   In Timeline, this dictates the vertical rendering order of
     *   overlapped events in each Lane.
     * 
     *   In Calendar.dayView and Calendar.weekView views, it dictates the
     *   horizontal rendering order of overlapped events in each column or Lane.
     * 
     *   By default, events that share space in a Lane or column are rendered from top to bottom,
     *   or left to right according to their Calendar.startDateField - the earliest in a
     *   given lane appears top-most in that lane, or left-most in its column.
     * 
     *   Providing overlapSortSpecifiers allows for the events to be ordered by one or
     *   more of the fields stored on the events, or in the underlying DataSource,
     *   if the Calendar is databound.
     *  @type {Array<Partial<SortSpecifier>>}
     *  @default null
     */
    open var overlapSortSpecifiers: Array<dynamic> = definedExternally
    /**
     *  The background color for cells that represent today in all CalendarViews.
     *  @type {string}
     *  @default null
     */
    open var todayBackgroundColor: String = definedExternally
    /**
     *  When rendering the Calendar.eventCanvas for an event, whether to show the
     *   EventCanvas.showBody, typically containing brief details of the event -
     *   Calendar.getEventBodyHTML,
     *   Calendar.descriptionField.
     * 
     *   The default is true - if set to false, the event's EventCanvas.showHeader
     *   will fill the canvas.
     *  @type {boolean}
     *  @default true
     */
    open var showEventDescriptions: Boolean = definedExternally
    /**
     *  When rendering the Calendar.eventCanvas for an event, whether to show the
     *   EventCanvas.showHeader, typically containing suitable title text -
     *   Calendar.getEventHeaderHTML, the event's Calendar.nameField.
     * 
     *   The default is true - if set to false, the event's EventCanvas.showBody
     *   will fill the canvas.
     *  @type {boolean}
     *  @default true
     */
    open var showEventHeaders: Boolean = definedExternally
    /**
     *  When rendering the Calendar.eventCanvas for an event, whether to allow the
     *   content of the EventCanvas.showHeader to wrap to multiple lines.
     * 
     *   The default is true - if set to false, the header area is
     *   Calendar.eventHeaderHeight, unless Calendar.showEventDescriptions is
     *   false, in which case the header area fills the canvas.
     *  @type {boolean}
     *  @default true
     */
    open var eventHeaderWrap: Boolean = definedExternally
    /**
     *  When Calendar.eventHeaderWrap is false and
     *   Calendar.showEventDescriptions is true, this is the fixed
     *   height for the EventCanvas.showHeader in event canvases.
     *  @type {Integer}
     *  @default "14"
     */
    open var eventHeaderHeight: Number = definedExternally
    /**
     *  If true, events will be sized to the grid, even if they start and/or end at times
     *   between grid cells.
     *  @type {boolean}
     *  @default true
     */
    open var sizeEventsToGrid: Boolean = definedExternally
    /**
     *  The title for the Calendar.dayView.
     *  @type {string}
     *  @default "Day"
     */
    open var dayViewTitle: String = definedExternally
    /**
     *  The title for the Calendar.weekView.
     *  @type {string}
     *  @default "Week"
     */
    open var weekViewTitle: String = definedExternally
    /**
     *  The title for the Calendar.monthView.
     *  @type {string}
     *  @default "Month"
     */
    open var monthViewTitle: String = definedExternally
    /**
     *  The title for the Calendar.timelineView.
     *  @type {string}
     *  @default "Timeline"
     */
    open var timelineViewTitle: String = definedExternally
    /**
     *  The title for the Calendar.nameField in the quick
     *   Calendar.eventDialog and the detailed
     *   Calendar.eventEditor.
     *  @type {HTMLString}
     *  @default "Event Name"
     */
    open var eventNameFieldTitle: String = definedExternally
    /**
     *  The title for the Calendar.startDateField in the quick
     *   Calendar.eventDialog and the detailed
     *   Calendar.eventEditor.
     *  @type {HTMLString}
     *  @default "From"
     */
    open var eventStartDateFieldTitle: String = definedExternally
    /**
     *  The title for the Calendar.endDateField in the quick
     *   Calendar.eventDialog and the detailed
     *   Calendar.eventEditor.
     *  @type {HTMLString}
     *  @default "To"
     */
    open var eventEndDateFieldTitle: String = definedExternally
    /**
     *  The title for the Calendar.descriptionField field in the quick
     *   Calendar.eventDialog and the detailed
     *   Calendar.eventEditor.
     *  @type {HTMLString}
     *  @default "Description"
     */
    open var eventDescriptionFieldTitle: String = definedExternally
    /**
     *  The title for the Calendar.laneNameField in the quick
     *   Calendar.eventDialog and the detailed
     *   Calendar.eventEditor.
     *  @type {HTMLString}
     *  @default "Lane"
     */
    open var eventLaneFieldTitle: String = definedExternally
    /**
     *  The title for the Calendar.sublaneNameField in the quick
     *   Calendar.eventDialog and the detailed
     *   Calendar.eventEditor.
     *  @type {HTMLString}
     *  @default "Sublane"
     */
    open var eventSublaneFieldTitle: String = definedExternally
    /**
     *  The title for the Calendar.durationField in the quick
     *   Calendar.eventDialog and the detailed
     *   Calendar.eventEditor.
     *  @type {HTMLString}
     *  @default "Duration"
     */
    open var eventDurationFieldTitle: String = definedExternally
    /**
     *  The title for the Calendar.durationUnitField in the quick
     *   Calendar.eventDialog and the detailed
     *   Calendar.eventEditor.
     *  @type {HTMLString}
     *  @default "&amp;nbsp;"
     */
    open var eventDurationUnitFieldTitle: String = definedExternally
    /**
     *  The title for the Calendar.saveButton in the
     *   Calendar.eventDialog and the
     *   Calendar.eventEditor.
     *  @type {HTMLString}
     *  @default "Save Event"
     */
    open var saveButtonTitle: String = definedExternally
    /**
     *  The title for the edit button in the quick Calendar.eventDialog.
     *  @type {HTMLString}
     *  @default "Edit Details"
     */
    open var detailsButtonTitle: String = definedExternally
    /**
     *  The title for the Calendar.removeButton in the
     *   Calendar.eventEditor.
     *  @type {HTMLString}
     *  @default "Remove Event"
     */
    open var removeButtonTitle: String = definedExternally
    /**
     *  The title for the Calendar.cancelButton in the
     *   Calendar.eventEditor.
     *  @type {HTMLString}
     *  @default "Cancel"
     */
    open var cancelButtonTitle: String = definedExternally
    /**
     *  The title of the Calendar.monthButton, used for showing and hiding the
     *   Calendar.monthView on Handsets.
     * 
     *   This is a dynamic string - text within &#36;{...} are dynamic variables and will
     *   be evaluated as JS code when the message is displayed.
     * 
     *   Only one dynamic variable, monthName, is available and represents the name of the month
     *   containing the currently selected date.
     * 
     *   The default value is a left-facing arrow followed by the Month-name of the selected date.
     * 
     *   When the month view is already visible, the title for the month button is set according to
     *   the value of Calendar.backButtonTitle.
     *  @type {HTMLString}
     *  @default "&amp;lt; ${monthName}"
     */
    open var monthButtonTitle: String = definedExternally
    /**
     *  The title of the link shown in a cell of a Calendar.monthView when there
     *   are too many events to be displayed at once.
     * 
     *   This is a dynamic string - text within &#36;{...} are dynamic variables and will
     *   be evaluated as JS code when the message is displayed.
     * 
     *   Only one dynamic variable, eventCount, is available and represents the number of events that
     *   are not currently displayed and that will appear in the menu displayed when the More Events
     *   link is clicked.
     * 
     *   The default value is a string like "+ 3 more...".
     *  @type {HTMLString}
     *  @default "+ ${eventCount} more..."
     */
    open var monthMoreEventsLinkTitle: String = definedExternally
    /**
     *  The title of the Calendar.monthButton on Handsets when the
     *   Calendar.monthView is the current visible view.
     * 
     *   When the month view is not the current visible view, the title for the month button is set
     *   according to the value of Calendar.monthButtonTitle.
     *  @type {HTMLString}
     *  @default "Back"
     */
    open var backButtonTitle: String = definedExternally
    /**
     *  The text to be displayed when a user hovers over the Calendar.previousButton
     *   toolbar button.
     *  @type {string}
     *  @default "Previous"
     */
    open var previousButtonHoverText: String = definedExternally
    /**
     *  The text to be displayed when a user hovers over the Calendar.nextButton
     *   toolbar button
     *  @type {string}
     *  @default "Next"
     */
    open var nextButtonHoverText: String = definedExternally
    /**
     *  The text to be displayed when a user hovers over the Calendar.addEventButton
     *   toolbar button
     *  @type {string}
     *  @default "Add an event"
     */
    open var addEventButtonHoverText: String = definedExternally
    /**
     *  The text to be displayed when a user hovers over the Calendar.datePickerButton
     *   toolbar button
     *  @type {string}
     *  @default "Choose a date"
     */
    open var datePickerHoverText: String = definedExternally
    /**
     *  The message to display in the Calendar.eventEditor when the 'To' date is greater than
     *   the 'From' date and a save is attempted.
     *  @type {string}
     *  @default "From must be before To"
     */
    open var invalidDateMessage: String = definedExternally
    /**
     *  An AutoChild of type Window that displays a quick event entry form in a
     *   popup window.
     *  @type {Window}
     *  @default null
     */
    open var eventDialog: Window = definedExternally
    /**
     *  An AutoChild of type Window that displays the full
     *   Calendar.eventEditor
     *  @type {Window}
     *  @default null
     */
    open var eventEditorLayout: Window = definedExternally
    /**
     *  An AutoChild of type DynamicForm which displays CalendarEvent.
     *   This form is created within the Calendar.eventEditorLayout
     *  @type {DynamicForm}
     *  @default null
     */
    open var eventEditor: DynamicForm = definedExternally
    /**
     *  An AutoChild of type HLayout which houses the
     *   Calendar.saveButton, Calendar.removeButton
     *   and Calendar.cancelButton buttons in the
     *   Calendar.eventEditor.
     *  @type {HLayout}
     *  @default null
     */
    open var eventEditorButtonLayout: HLayout = definedExternally
    /**
     *  An AutoChild of type IButton, used to save an event from the
     *   Calendar.eventEditor.
     *  @type {IButton}
     *  @default null
     */
    open var saveButton: IButton = definedExternally
    /**
     *  An AutoChild of type IButton, used to permanently remove an event from the
     *   Calendar.eventEditor.
     *  @type {IButton}
     *  @default null
     */
    open var removeButton: IButton = definedExternally
    /**
     *  An AutoChild of type IButton, used to cancel editing of an event and close the
     *   Calendar.eventEditor.
     *  @type {IButton}
     *  @default null
     */
    open var cancelButton: IButton = definedExternally
    /**
     *  Set to false to hide the Calendar.addEventButton button.
     *  @type {boolean}
     *  @default null
     */
    open var showAddEventButton: Boolean = definedExternally
    /**
     *  An ImgButton that appears in a Calendar's week/day/month views and offers an
     *   alternative way to create a new CalendarEvent.
     *  @type {ImgButton}
     *  @default null
     */
    open var addEventButton: ImgButton = definedExternally
    /**
     *  Set to false to hide the Calendar.datePickerButton that allows selecting a new base date for
     *   this Calendar.
     *  @type {boolean}
     *  @default null
     */
    open var showDatePickerButton: Boolean = definedExternally
    /**
     *  An ImgButton that appears above the various views of the
     *   calendar and offers alternative access to a DateChooser to pick the current day.
     *  @type {ImgButton}
     *  @default null
     */
    open var datePickerButton: ImgButton = definedExternally
    /**
     *  If false the controls bar at the top of the calendar will not be displayed - this means
     *   that the Calendar.controlsBar will be hidden, so the autoChildren (Calendar.previousButton,
     *   Calendar.dateLabel, Calendar.nextButton, Calendar.addEventButton, and Calendar.datePickerButton)
     *   will not be created or shown.
     *  @type {boolean}
     *  @default true
     */
    open var showControlsBar: Boolean = definedExternally
    /**
     *  An HLayout shown above the Calendar views and displaying a set of
     *   controls for interacting with the current view - namely, the Calendar.nextButton,
     *   Calendar.previousButton and Calendar.addEventButton buttons,
     *   the Calendar.dateLabel and the Calendar.datePickerButton icon.
     *  @type {HLayout}
     *  @default null
     */
    open var controlsBar: HLayout = definedExternally
    /**
     *  Set to false to prevent the Calendar.monthButton button from displaying on Handset
     *   devices.
     *  @type {boolean}
     *  @default null
     */
    open var showMonthButton: Boolean = definedExternally
    /**
     *  A NavigationButton that appears to the left of other navigation controls in the
     *   Calendar.controlsBar on Handset devices.
     * 
     *   Used to show and hide the Calendar.monthView on devices with limited space.
     *  @type {NavigationButton}
     *  @default null
     */
    open var monthButton: NavigationButton = definedExternally
    /**
     *  Set to false to hide the Calendar.previousButton button.
     *  @type {boolean}
     *  @default null
     */
    open var showPreviousButton: Boolean = definedExternally
    /**
     *  An ImgButton that appears above the week/day/month views of the
     *   calendar and allows the user to move the calendar backwards in time.
     *  @type {ImgButton}
     *  @default null
     */
    open var previousButton: ImgButton = definedExternally
    /**
     *  Set to false to hide the Calendar.nextButton button.
     *  @type {boolean}
     *  @default null
     */
    open var showNextButton: Boolean = definedExternally
    /**
     *  An ImgButton that appears above the week/day/month views of the
     *   calendar and allows the user to move the calendar forwards in time.
     *  @type {ImgButton}
     *  @default null
     */
    open var nextButton: ImgButton = definedExternally
    /**
     *  The AutoChild Label used to display the current date or range above the
     *   selected calendar view.
     *  @type {Label}
     *  @default null
     */
    open var dateLabel: Label = definedExternally
    /**
     *  The height of time-slots in the calendar.
     *  @type {number}
     *  @default "20"
     */
    open var rowHeight: Number = definedExternally
    /**
     *  The name of the view that should be visible initially by default.
     *  @type {ViewName}
     *  @default null
     */
    open var currentViewName: 
                              /**
                               *  day view
                               *  week view
                               *  month view
                               *  timeline view
                               */
                              String /* day |  week |  month |  timeline */ = definedExternally
    /**
     *  Dictates whether times throughout the widget are formatted and edited as 24-hour values. If
     *   unset, defaults to the Time.use24HourTime. If set, and no
     *   Calendar.timeFormatter is installed, causes the
     *   Calendar to choose an appropriate builtin formatter.
     *  @type {boolean}
     *  @default null
     */
    open var twentyFourHourTime: Boolean = definedExternally
    /**
     *  Date formatter for displaying events.
     *   Default is to use the system-wide default short date format, configured via
     *   DateUtil.setShortDisplayFormat. Specify any valid DateDisplayFormat.
     *  @type {DateDisplayFormat}
     *  @default null
     */
    open var dateFormatter: 
                            /**
                             *  Default native browser 'toString()' implementation. May vary by browser.
                             *   Example: Fri Nov 04 2005 11:03:00 GMT-0800 (Pacific Standard Time)
                             *  Default native browser 'toLocaleString()' implementation. May vary by browser.
                             *   Example: Friday, November 04, 2005 11:03:00 AM
                             *  Short date in format MM/DD/YYYY. Example: 11/4/2005
                             *  Short date with time in format MM/DD/YYYY HH:MM Example: 11/4/2005 11:03
                             *  Short date in format DD/MM/YYYY. Example: 4/11/2005
                             *  Short date with time in format DD/MM/YYYY HH:MM Example: 4/11/2005 11:03
                             *  Short date in format YYYY/MM/DD. Example: 2005/11/4
                             *  Short date with time in format YYYY/MM/DD HH:MM Example: 2005/11/4 11:03
                             *  Date in the format YYYY-MM-DD HH:MM:SS Example: 2005-11-04 11:09:15
                             *  Date in the format &lt;YYYYMMDD&gt;T&lt;HHMMSS&gt;Z Example: 20051104T111001Z
                             * 
                             * 
                             *   Note: In addition to these standard formats, custom formatting can be set by passing
                             *   a function directly to DateUtil.setNormalDisplayFormat et al. This
                             *   function will then be executed whenever the appropriate formatter method is called [eg
                             *   Date.toNormalDate], in the scope of the date instance in question.
                             * 
                             *   Custom formatting can also be applied by passing a FormatString instead of a
                             *   DateDisplayFormat string to DateUtil.setNormalDisplayFormat et al. See
                             *   the FormatString docs for details.
                             */
                            String /* toString |  toLocaleString |  toUSShortDate |  toUSShortDatetime |  toEuropeanShortDate |  toEuropeanShortDatetime |  toJapanShortDate |  toJapanShortDatetime |  toSerializeableDate |  toDateStamp */ = definedExternally
    /**
     *  Display format to use for the time portion of events' date information. By default, times
     *   are displayed in the global format, including the influence of the global
     *   Time.use24HourTime option, which is true by default.
     *   P>
     *   Note that this display setting does not affect the way in which time values are edited in the
     *   Calendar.eventEditor - see Calendar.twentyFourHourTime for more
     *   information.
     *  @type {TimeDisplayFormat}
     *  @default null
     */
    open var timeFormatter: 
                            /**
                             *  String will display with seconds and am/pm indicator:[H]H:MM:SS am|pm.
                             *   Example: 3:25:15 pm
                             *  String will display with seconds in 24 hour time: [H]H:MM:SS.
                             *   Example: 15:25:15
                             *  String will display with seconds, with a 2 digit hour and am/pm indicator:
                             *   HH:MM:SS am|pm
                             *   Example: 03:25:15 pm
                             *  String will display with seconds, with a 2 digit hour in 24 hour format:
                             *   HH:MM:SS
                             *   Examples: 15:25:15, 03:16:45
                             *  String will have no seconds and be in 12 hour format:[H]H:MM am|pm
                             *   Example: 3:25 pm
                             *  String will have no seconds and be in 24 hour format: [H]H:MM
                             *   Example:15:25
                             *  String will have no seconds and will display a 2 digit hour, in 12 hour clock format:
                             *   HH:MM am|pm
                             *   Example: 03:25 pm
                             *  String will have no seconds and will display with a 2 digit hour in 24 hour clock format:
                             *   HH:MM
                             *   Examples: 15:25, 03:16
                             */
                            String /* toTime |  to24HourTime |  toPaddedTime |  toPadded24HourTime |  toShortTime |  toShort24HourTime |  toShortPaddedTime |  toShortPadded24HourTime */ = definedExternally
    /**
     *  In Calendar.indicators are showing, this attribute affects where in
     *   the z-order their canvases will be rendered: either in front of, or behind normal calendar
     *   events.
     *  @type {boolean}
     *  @default true
     */
    open var showIndicatorsInFront: Boolean = definedExternally
    /**
     *  When Calendar.showViewHovers is true, dictates whether to display
     *   hover prompts when the mouse rolls over the normal cells in the body of CalendarViews.
     * 
     *   The content of the hover is determined by a call to
     *   Calendar.getCellHoverHTML, which can be overridden to return custom results; by
     *   default, it returns the cell's date as a string.
     *  @type {boolean}
     *  @default false
     */
    open var showCellHovers: Boolean = definedExternally
    /**
     *  When Calendar.showViewHovers is true, dictates whether to display
     *   hover prompts when the mouse rolls over the Calendar.headerLevels in
     *   a CalendarView.
     * 
     *   The content of the hover is determined by a call to
     *   Calendar.getHeaderHoverHTML, which can be overridden to return custom results;
     *  @type {boolean}
     *  @default false
     */
    open var showHeaderHovers: Boolean = definedExternally
    /**
     *  When set to true, the default value, causes the Calendar to show customizable hovers when
     *   the mouse moves over various areas of a CalendarView.
     * 
     *   See Calendar.showEventHovers,
     *   Calendar.showZoneHovers,
     *   Calendar.showHeaderHovers,
     *   Calendar.showCellHovers,
     *   Calendar.showLaneFieldHovers,
     *   Calendar.showDragHovers for further configuration options.
     *  @type {boolean}
     *  @default true
     */
    open var showViewHovers: Boolean = definedExternally
    /**
     *  When Calendar.showViewHovers is true, dictates whether to display
     *   hover prompts when the mouse moves over an EventCanvas in a
     *   calendarView.
     * 
     *   The content of the hover is determined by a call to
     *   Calendar.getCellHoverHTML, which can be overridden to return custom results.
     *  @type {boolean}
     *  @default true
     */
    open var showEventHovers: Boolean = definedExternally
    /**
     *  When Calendar.showViewHovers is true, dictates whether to display
     *   hover prompts when the mouse moves over a Calendar.zones in a calendarView.
     * 
     *   When Calendar.showCellHovers is true, this attribute is ignored and
     *   zone hovers are not displayed.
     * 
     *   The content of the hover is determined by a call to
     *   Calendar.getZoneHoverHTML, which can be overridden to return custom results.
     *  @type {boolean}
     *  @default true
     */
    open var showZoneHovers: Boolean = definedExternally
    /**
     *  When Calendar.showViewHovers is true, dictates whether to display
     *   hover prompts when the mouse moves over the cells in a
     *   Calendar.laneFields.
     * 
     *   The content of the hover is determined by a call to
     *   Calendar.getCellHoverHTML, which can be overridden to return custom results. Note
     *   that getCellHoverHTML() is also called when the mouse moves over cells if
     *   Calendar.showCellHovers is true - when called for a laneField, no
     *   "date" parameter is passed to that method.
     *  @type {boolean}
     *  @default false
     */
    open var showLaneFieldHovers: Boolean = definedExternally
    /**
     *  When Calendar.showViewHovers is true, dictates whether to display
     *   hover prompts when an event is being dragged with the mouse.
     * 
     *   The content of the hover is determined by a call to
     *   Calendar.getDragHoverHTML, which can be overridden to return custom results; by
     *   default, it returns the date range of the drag canvas as a string.
     *  @type {boolean}
     *  @default false
     */
    open var showDragHovers: Boolean = definedExternally
    /**
     *  Context menu displayed when an EventCanvas is right-clicked, or
     *   when the rollover Calendar.eventCanvasContextButton is clicked. The
     *   context button, and the menu itself, will only be displayed if
     *   Calendar.getEventCanvasMenuItems returns
     *   an array of appropriate items for the event.
     *  @type {Menu}
     *  @default null
     */
    open var eventCanvasContextMenu: Menu = definedExternally
    /**
     *  By default, the Calendar.eventCanvasCloseButton and the
     *   Calendar.eventCanvasHResizer and
     *   Calendar.eventCanvasVResizer resizer widgets
     *   for event canvases are shown only when the mouse is over a given event. Set this attribute
     *   to false to have event canvases show these widgets permanently.
     *  @type {boolean}
     *  @default true
     */
    open var useEventCanvasRolloverControls: Boolean = definedExternally
    /**
     *  When set to true, makes individual EventCanvas selectable.
     *   Events may be selected via a single click, as well as being
     *   included in the page's tab order. The current selected event is shown in a special
     *   style and pressing TAB or Shift-TAB will move the selection first among the events
     *   in the same lane, and then among those in the next or previous lane.
     * 
     *   Pressing Enter while an editable event is selected
     *   will show either the event- Calendar.eventDialog or
     *   Calendar.eventEditor. Pressing Delete will remove the event.
     * 
     *   Note that when this property is false, single clicking the event canvas for an
     *   editable event will bring up an editing interface for that event.
     *   When true this is no longer the case - a user can double click to bring up the editing
     *   interface instead (a single click will simply select the event canvas).
     *  @type {boolean}
     *  @default null
     */
    open var canSelectEvents: Boolean = definedExternally
    /**
     *  The selection associated with the Calendar.
     *  @type {Selection}
     *  @default null
     */
    open var selectionManager: Selection = definedExternally
    /**
     *  The "gripper" widget that snaps to the top of an event canvas and allows an
     *   event to be dragged with the mouse.
     *  @type {Img}
     *  @default null
     */
    open var eventCanvasGripper: Img = definedExternally
    /**
     *  Icon used as the default eveng gripper icon.
     *  @type {SCImgURL}
     *  @default "[SKIN]/Calendar/gripper.png"
     */
    open var eventCanvasGripperIcon: String = definedExternally
    /**
     *  @type {Label}
     *  @default null
     */
    open var eventCanvasLabel: Label = definedExternally
    /**
     *  HLayout that snaps to the top-right of an event canvas on rollover and contains the
     *   Calendar.eventCanvasCloseButton and/or
     *   Calendar.eventCanvasContextButton buttons.
     *  @type {HLayout}
     *  @default null
     */
    open var eventCanvasButtonLayout: HLayout = definedExternally
    /**
     *  The close button that snaps to the top-right of an event canvas on rollover and allows an
     *   event to be removed from a CalendarView.
     *  @type {ImgButton}
     *  @default null
     */
    open var eventCanvasCloseButton: ImgButton = definedExternally
    /**
     *  The context button that snaps to the top-right of an event canvas on rollover and shows a
     *   custom Calendar.getEventCanvasMenuItems when clicked.
     *  @type {ImgButton}
     *  @default null
     */
    open var eventCanvasContextButton: ImgButton = definedExternally
    /**
     *  The resizer image that snaps to the bottom of event canvases in Calendar.dayView
     *   and Calendar.weekView views, allowing them to be resized vertically by dragging
     *   with the mouse.
     *  @type {Img}
     *  @default null
     */
    open var eventCanvasVResizer: Img = definedExternally
    /**
     *  The resizer image that snaps to the left and right edges of an editable event canvas in a
     *   Timeline, allowing it to be resized horizontally by dragging with the mouse.
     *  @type {Img}
     *  @default null
     */
    open var eventCanvasHResizer: Img = definedExternally
    /**
     *  Set to true to render any defined Calendar.zones into
     *   Calendar.timelineView.
     *  @type {boolean}
     *  @default null
     */
    open var showZones: Boolean = definedExternally
    /**
     *  An array of CalendarEvent instances representing pre-defined periods of time to be
     *   highlighted in Calendar.timelineView. Each zone renders out a
     *   ZoneCanvas, a special, non-interactive subclass of
     *   EventCanvas, which spans all lanes and draws behind any normal, interactive
     *   events in the zorder.
     * 
     *   The default Calendar.zoneStyleName for these components renders them
     *   semi-transparent and with a bottom-aligned title label.
     *  @type {Array<Partial<CalendarEvent>>}
     *  @default null
     */
    open var zones: Array<dynamic> = definedExternally
    /**
     *  CSS style to apply to the Calendar.zoneCanvas created for each
     *   specified Calendar.zones.
     *  @type {CSSStyleName}
     *  @default "zoneCanvas"
     */
    open var zoneStyleName: String = definedExternally
    /**
     *  AutoChild component created for each Calendar.zones entry.
     *  @type {ZoneCanvas}
     *  @default null
     */
    open var zoneCanvas: ZoneCanvas = definedExternally
    /**
     *  The vertical alignment of the header-text in each Calendar.zones.
     *  @type {VerticalAlignment}
     *  @default "bottom"
     */
    open var zoneTitleOrientation: 
                                   /**
                                    *  At the top of the container
                                    *  Center within container.
                                    *  At the bottom of the container
                                    */
                                   String /* top |  center |  bottom */ = definedExternally
    /**
     *  Set to true to render any defined Calendar.indicators into
     *   Calendar.timelineView.
     *  @type {boolean}
     *  @default null
     */
    open var showIndicators: Boolean = definedExternally
    /**
     *  An array of CalendarEvent instances representing instants in time, to be
     *   highlighted in Calendar.timelineView. Each indicator renders out as
     *   an IndicatorCanvas, a special, non-interactive subclass of
     *   EventCanvas, which spans all lanes and draws behind any normal, interactive
     *   events in the zorder, but in front of any Calendar.zones. The default
     *   Calendar.indicatorStyleName for these components renders them as thin vertical
     *   lines that span all lanes and have a hover but no title.
     *  @type {Array<Partial<CalendarEvent>>}
     *  @default null
     */
    open var indicators: Array<dynamic> = definedExternally
    /**
     *  CSS style to apply to the Calendar.indicatorCanvas created for each
     *   specified Calendar.indicators.
     *  @type {CSSStyleName}
     *  @default "indicatorCanvas"
     */
    open var indicatorStyleName: String = definedExternally
    /**
     *  AutoChild component created for each Calendar.indicators entry.
     *  @type {IndicatorCanvas}
     *  @default null
     */
    open var indicatorCanvas: IndicatorCanvas = definedExternally
    /**
     *  To display events in day and week views, the Calendar creates instance of EventWindow
     *   for each event. Use the AutoChild system to customize these windows.
     *  @deprecated \* in favor of Calendar.eventCanvas
     *  @type {EventWindow}
     *  @default null
     */
    open var eventWindow: EventWindow = definedExternally
    /**
     *  To display events in Calendar.dayView, Calendar.weekView and
     *   Calendar.timelineView views, the Calendar creates instances of
     *   EventCanvas for each event. Use the AutoChild system to customize
     *   these canvases.
     *  @type {EventCanvas}
     *  @default null
     */
    open var eventCanvas: EventCanvas = definedExternally
    /**
     *  AutoChild Menu, shown when a user clicks the
     *   Calendar.monthMoreEventsLinkTitle link in a cell of the
     *   Calendar.monthView. Items in this menu represent additional events,
     *   not already displayed in the cell, and clicking them fires the
     *   Calendar.eventClick notification.
     *  @type {Menu}
     *  @default null
     */
    open var monthMoreEventsMenu: Menu = definedExternally
    /**
     *  Before we start editing values in this DataBoundComponent, should we perform a deep clone
     *   of the underlying values. See DataSource.deepCloneOnEdit for details of what this means.
     * 
     *   If this value is not explicitly set, it defaults to the value of DataSource.deepCloneOnEdit.
     *   This value can be overridden per-field with DataSourceField.deepCloneOnEdit.
     * 
     *   Like the other deepCloneOnEdit settings, this flag only has an effect if you are
     *   editing a values object that contains nested objects or arrays, using
     *   Canvas.dataPaths.
     *  @type {boolean}
     *  @default null
     */
    override var deepCloneOnEdit: Boolean = definedExternally
    /**
     *  When editing values in this DataBoundComponent, should we perform a deep clone of values
     *   that are not associated with a field (ie, attributes on the record that do not map to a
     *   component field either directly by name, or by FormItem.dataPath. If this value is
     *   not explicitly set, it defaults to the value of
     *   DataSource.deepCloneNonFieldValuesOnEdit if there is a dataSource, or to the value
     *   of the static DataSource.deepCloneNonFieldValuesOnEdit if there is no
     *   dataSource.
     * 
     *   Like the other deepCloneOnEdit settings, this flag only has an effect if you are
     *   editing a values object that contains nested objects or arrays.
     *  @type {boolean}
     *  @default null
     */
    override var deepCloneNonFieldValuesOnEdit: Boolean = definedExternally
    /**
     *  When using DataBoundComponent.dataFetchMode, how many records to fetch at a time. If set to
     *   a positive integer, dataPageSize will override the default
     *   ResultSet.resultSize for ResultSets automatically created when you call
     *   method:DataBoundComponent.fetchData (and similarly for the ResultTree.resultSize of
     *   ResultTrees). Leaving dataPageSize at its default means to just use the default page
     *   size of the data container.
     * 
     *   Note that regardless of the dataPageSize setting, a component will always fetch
     *   all of data that it needs to draw. Settings such as
     *   ListGrid.showAllRecords,
     *   ListGrid.drawAllMaxCells and
     *   ListGrid.drawAheadRatio can cause more rows than the configured
     *   dataPageSize to be fetched.
     *  @type {Integer}
     *  @default null
     */
    override var dataPageSize: Number = definedExternally
    /**
     *  Delay in milliseconds before fetching data.
     * 
     *   This setting only applies to the ResultSet automatically created by calling
     *   ListGrid.fetchData. If a pre-existing ResultSet is passed to setData() instead, it's
     *   existing setting for ResultSet.fetchDelay applies.
     *  @type {Integer}
     *  @default null
     */
    override var dataFetchDelay: Number = definedExternally
    /**
     *  A DataBoundComponent manipulates records with one or more fields, and
     *   component.fields tells the DataBoundComponent which fields to present, in what
     *   order, and how to present each field.
     * 
     *   When both component.fields and
     *   DataBoundComponent.dataSource are set,
     *   any fields in component.fields with the same name as a DataSource field
     *   inherit properties of the DataSource field. This allows you to centralize data model
     *   information in the DataSource, but customize presentation of DataSource fields on a
     *   per-component basic. For example, in a ListGrid, a shorter title or format for a field
     *   might be chosen to save space.
     * 
     *   By default, only fields specified on the component are shown, in the order specified on
     *   the component. The DataBoundComponent.useAllDataSourceFields flag can be set to show all fields
     *   from the DataSource, with component.fields acting as field-by-field
     *   overrides and/or additional fields.
     * 
     *   If a DataBoundComponent is given a DataSource, but no component.fields, the
     *   "default binding" is used: fields are shown in DataSource order, according
     *   to the properties DataBoundComponent.showHiddenFields and
     *   DataBoundComponent.showDetailFields.
     *  @type {Array<Partial<DataSourceField>>}
     *  @default null
     */
    override var fields: Array<dynamic> = definedExternally
    /**
     *  If true, the set of fields given by the "default binding" (see
     *   DataBoundComponent.fields) is used, with any fields specified in
     *   component.fields acting as overrides that can suppress or modify the
     *   display of individual fields, without having to list the entire set of fields that
     *   should be shown.
     * 
     *   If component.fields contains fields that are not found in the DataSource,
     *   they will be shown after the most recently referred to DataSource field. If the new
     *   fields appear first, they will be shown first.
     * 
     *   ${isc.DocUtils.linkForExampleId('validationFieldBinding', 'This example')} shows a mixture of component
     *   fields and DataSource fields, and how they interact for validation.
     * 
     *   This setting may be cleared if a FieldPicker is used to edit the component's field
     *   order.
     *  @type {boolean}
     *  @default false
     */
    override var useAllDataSourceFields: Boolean = definedExternally
    /**
     *  Whether to show fields marked hidden:true when a DataBoundComponent is given a
     *   DataSource but no component.fields.
     * 
     *   The hidden property is used on DataSource fields to mark fields that are
     *   never of meaning to an end user.
     *  @type {boolean}
     *  @default false
     */
    override var showHiddenFields: Boolean = definedExternally
    /**
     *  Whether to show fields of non-atomic types when a DataBoundComponent is given a
     *   DataSource but no component.fields.
     * 
     *   If true, the component will show fields that declare a complex type, for example, a
     *   field 'shippingAddress' that declares type 'Address', where 'Address' is the ID of a
     *   DataSource that declares the fields of a shipping address (city, street name, etc).
     * 
     *   Such fields may need custom formatters or editors in order to create a usable interface,
     *   for example, an Address field in a ListGrid might use a custom formatter to combine the
     *   relevant fields of an address into one column, and might use a pop-up dialog for
     *   editing.
     *  @type {boolean}
     *  @default true
     */
    override var showComplexFields: Boolean = definedExternally
    /**
     *  DSRequest.operationId this component should use when performing fetch operations.
     *  @type {string}
     *  @default null
     */
    override var fetchOperation: String = definedExternally
    /**
     *  DSRequest.operationId this component should use when performing update operations.
     *  @type {string}
     *  @default null
     */
    override var updateOperation: String = definedExternally
    /**
     *  DSRequest.operationId this component should use when performing add operations.
     *  @type {string}
     *  @default null
     */
    override var addOperation: String = definedExternally
    /**
     *  DSRequest.operationId this component should use when performing remove operations.
     *  @type {string}
     *  @default null
     */
    override var removeOperation: String = definedExternally
    /**
     *  The list of field-names to export. If provided, the field-list in the exported output is
     *   limited and sorted as per the list.
     * 
     *   If exportFields is not provided, the exported output includes all visible fields
     *   from this component, sorted as they appear.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    override var exportFields: Array<dynamic> = definedExternally
    /**
     *  Setting exportAll to true prevents the component from passing it's list of fields to the
     *   export call. The result is the export of all visible fields from DataSource.fields.
     * 
     *   If exportAll is false, an export operation will first consider
     *   DataBoundComponent.exportFields, if it's set, and fall back on all visible fields from
     *   DataSource.fields otherwise.
     *  @type {boolean}
     *  @default false
     */
    override var exportAll: Boolean = definedExternally
    /**
     *  If Summary rows exist for this component, whether to include them when exporting client data.
     *  @type {boolean}
     *  @default true
     */
    override var exportIncludeSummaries: Boolean = definedExternally
    /**
     *  Flag controlling when to recategorize records being dropped on a databound
     *   component from another databound component.
     *  @type {RecategorizeMode}
     *  @default "checked"
     */
    override var dragRecategorize: 
                                   /**
                                    *  recategorize is always applied
                                    *  recategorize if normal checks pass
                                    *  never recategorize
                                    */
                                   String /* always |  checked |  never */ = definedExternally
    /**
     *  If set, detect and prevent duplicate records from being transferred to this component, either via
     *   drag and drop or via DataBoundComponent.transferSelectedData. When a duplicate transfer is detected,
     *   a dialog will appear showing the DataBoundComponent.duplicateDragMessage.
     * 
     *   If the component either does not have a DataSource or has a DataSource with no
     *   DataSourceField.primaryKey declared, duplicate checking is off by
     *   default. If duplicate checking is enabled, it looks for an existing record in the dataset
     *   that has all of the properties of the dragged record, and considers that a duplicate.
     * 
     *   For DragDataAction:"copy" where the target DataSource is related to the source
     *   DataSource by foreignKey, a duplicate means that the target list, as filtered by the current
     *   criteria, already has a record whose value for the foreignKey field matches the
     *   primaryKey of the record being transferred.
     * 
     *   For example, consider dragging "employees" to "teams", where "teams" has a field
     *   "teams.employeeId" which is a foreignKey pointing to "employees.id", and the target
     *   grid has search criteria causing it to show all the members of one team. A duplicate -
     *   adding an employee to the same team twice - is when the target grid's dataset contains an
     *   record with "employeeId" matching the "id" field of the dropped employee.
     *  @type {boolean}
     *  @default null
     */
    override var preventDuplicates: Boolean = definedExternally
    /**
     *  Message to show when a user attempts to transfer duplicate records into this component, and
     *   DataBoundComponent.preventDuplicates is enabled.
     * 
     *   If set to null, duplicates will not be reported and the dragged duplicates will not be
     *   saved.
     *  @type {string}
     *  @default "Duplicates not allowed"
     */
    override var duplicateDragMessage: String = definedExternally
    /**
     *  Indicates whether the text of the offlineMessage property should be displayed if no data is
     *   available because we do not have a suitable offline cache
     *  @type {boolean}
     *  @default true
     */
    override var showOfflineMessage: Boolean = definedExternally
    /**
     *  Message to display when this DataBoundComponent attempts to load data that is not available
     *   because the browser is currently offline. Depending on the component, the message is either
     *   displayed in the component's body, or in a pop-up warning dialog.
     *  @type {string}
     *  @default "This data not available while offline"
     */
    override var offlineMessage: String = definedExternally
    /**
     *  Message to display when this DataBoundComponent attempts to save data while the application
     *   is offline.
     *  @type {string}
     *  @default "Data cannot be saved because you are not online"
     */
    override var offlineSaveMessage: String = definedExternally
    /**
     *  Indicates whether to add "drop values" to items dropped on this component, if both
     *       the source and target widgets are databound, either to the same DataSource or
     *       to different DataSources that are related via a foreign key. "Drop values" are
     *       properties of the dropped item that you wish to change (and persist) as a
     *       result of the item being dropped on this grid.
     * 
     *       If this value is true and this component is databound, DataBoundComponent.getDropValues will
     *       be called for every databound item dropped on this grid, and an update performed
     *       on the item
     *  @type {boolean}
     *  @default true
     */
    override var addDropValues: Boolean = definedExternally
    /**
     *  When an item is dropped on this component, and DataBoundComponent.addDropValues is true and both
     *       the source and target widgets are databound, either to the same DataSource or
     *       to different DataSources that are related via a foreign key, this object
     *       provides the "drop values" that SmartClient will apply to the dropped object
     *       before updating it.
     * 
     *       If this property is not defined, SmartClient defaults to returning the selection
     *       criteria currently in place for this component. Thus, any databound items (for example,
     *       rows from other grids bound to the same DataSource) dropped on the grid will,
     *       by default, be subjected to an update that makes them conform to the grid's
     *       current filter criteria.
     *  @type {object}
     *  @default null
     */
    override var dropValues: dynamic = definedExternally
    /**
     *  Does this component represent singular or multiple "records" objects?
     *   Options are "multiple" or "single", or "either"
     *  @type {string}
     *  @default "multiple"
     */
    override var dataArity: String = definedExternally
    /**
     *  Indicates whether or not this component will load its data
     *   DataSource.progressiveLoading.
     *  @type {boolean}
     *  @default null
     */
    override var progressiveLoading: Boolean = definedExternally
    /**
     *  If this component is bound to a dataSource, this attribute may be specified to customize
     *   what fields from the dataSource may be edited by default. For example the SearchForm
     *   class has this attribute set to "canFilter" which allows search forms to edit
     *   dataSource fields marked as canEdit:false (but not those marked as
     *   canFilter:false).
     * 
     *   Note that if canEdit is explicitly specified on a field in
     *   the DataBoundComponent.fields array, that property will be respected in preference to
     *   the canEditAttribute value. (See FormItem.canEdit, ListGridField.canEdit).
     *   Also note that individual dataBoundComponents may have additional logic around whether a field
     *   can be edited - for example ListGrid.canEditCell may be overridden.
     *  @type {Identifier}
     *  @default "canEdit"
     */
    override var canEditFieldAttribute: String = definedExternally
    /**
     *  The useFlatFields flag causes all simple type fields anywhere in a nested
     *   set of DataSources to be exposed as a flat list for form binding.
     * 
     *   useFlatFields is typically used with imported metadata, such as
     *   XMLTools.loadXMLSchema from a
     *   XMLTools.loadWSDL, as a means of eliminating levels of XML
     *   nesting that aren't meaningful in a user interface, without the cumbersome and fragile
     *   process of mapping form fields to XML structures.
     * 
     *   For example, having called WebService.getInputDS to retrieve the input message
     *   schema for a web service operation whose input message looks like this:
     * 
     *   &lt;FindServices&gt;
     *     &lt;searchFor&gt;search text&lt;/searchFor&gt;
     *     &lt;Options&gt;
     *       &lt;caseSensitive&gt;false&lt;/caseSensitive&gt;
     *     &lt;/Options&gt;
     *     &lt;IncludeInSearch&gt;
     *       &lt;serviceName&gt;true&lt;/serviceName&gt;
     *       &lt;documentation&gt;true&lt;/documentation&gt;
     *       &lt;keywords&gt;true&lt;/keywords&gt;
     *     &lt;/IncludeInSearch&gt;
     *   &lt;/FindServices&gt;
     * 
     *   Setting useFlatFields on a DynamicForm that is bound to this input
     *   message schema would result in 5 FormItem reflecting the 5 simple type
     *   fields in the message.
     * 
     *   For this form, the result of DynamicForm.getValues might look
     *   like:
     * 
     *   {
     *    searchFor: "search text",
     *    caseSensitive: false,
     *    serviceName: true,
     *    documentation : true,
     *    keywords : true
     *   }
     *   When contacting a WebService, these values can be automatically
     *   mapped to the structure of the input message for a web service operation by setting
     *   WSRequest.useFlatFields (for use with WebService.callOperation) or by setting
     *   DSRequest.useFlatFields (for use with a DataSource that is
     *   wsdlBinding via
     *   OperationBinding.wsOperation).
     * 
     *   Using these two facilities in conjunction (component.useFlatFields and
     *   request.useFlatFields) allows gratuitous nesting to be consistently bypassed in both the user
     *   presentation and when providing the data for XML messages.
     * 
     *   You can also set OperationBinding.useFlatFields to automatically enable
     *   "flattened" XML serialization (request.useFlatFields) for all DataSource requests of a
     *   particular operationType.
     * 
     *   Note that useFlatFields is not generally recommended for use with structures
     *   where multiple simple type fields exist with the same name, however if used with such a
     *   structure, the first field to use a given name wins. "first" means the first field
     *   encountered in a depth first search. "wins" means only the first field will be present as a
     *   field when data binding.
     *  @type {boolean}
     *  @default null
     */
    override var useFlatFields: Boolean = definedExternally
    /**
     *  If this attribute is set to false, any attributes in the component's values object that do
     *   not map to a DataSourceField or FormItem will not
     *   be tracked when checking for changes. You should only set this flag to false if you know
     *   that your code does not store additional, non-field values in the component's data, or if
     *   you do store such values, but you don't care that they are not checked for changes.
     *   This flag is primarily provided to avoid performance issues in cases where developers are
     *   storing large numbers of extra attributes in component data; generally speaking, you should
     *   only consider setting it to false if you have a use case like this.
     * 
     *   Note, even with this flag set to false, these extra values will still be managed and stored
     *   by SmartClient; they just will not be checked when the component's values are inspected to
     *   see if they have changed. This may lead to methods like ListGrid.rowHasChanges
     *   returning false when you are expecting it to return true. In this case, either switch this
     *   flag back to true (or just do not set it false), or provide a field definition for the
     *   affected attribute(s).
     *  @type {boolean}
     *  @default true
     */
    override var canChangeNonFieldValues: Boolean = definedExternally
    /**
     *  Criteria that are never shown to or edited by the user and are cumulative with any criteria
     *   provided via DataBoundComponent.initialCriteria, method:DataBoundComponent.setCriteria
     *   etc.
     *  @type {Criteria}
     *  @default null
     */
    override var implicitCriteria: dynamic = definedExternally
    /**
     *  Adds an item to the header context menu allowing users to launch a dialog to define
     *   grid hilites using the HiliteEditor.
     * 
     *   User-added hilites can be persisted via DataBoundComponent.getHiliteState and
     *   DataBoundComponent.setHiliteState.
     *  @type {boolean}
     *  @default false
     */
    override var canEditHilites: Boolean = definedExternally
    /**
     *  Hilites to be applied to the data for this component. See hiliting.
     *  @type {Array<Partial<Hilite>>}
     *  @default null
     */
    override var hilites: Array<dynamic> = definedExternally
    /**
     *  Specifies a list of icons that can be used in DataBoundComponent.editHilites.
     * 
     *   hiliteIcons should be specified as an Array of SCImgURL.
     *   When present, the hilite editing interface shown when DataBoundComponent.editHilites is called
     *   will offer the user a drop down for picking one of these icons when defining either a
     *   simple or advanced hilite rule.
     * 
     *   If the user picks an icon, the created hiliting rule will have Hilite.icon set to
     *   the chosen icon. DataBoundComponent.hiliteIconPosition controls where the icon will
     *   appear for that field -- the default is that it appears in front of the normal cell content.
     *   This can also be overridden at the field level.
     *  @type {Array<Partial<string>>}
     *  @default "["[SKINIMG]/Dialog/notify.png", "[SKINIMG]/Dialog/warn.png", "[SKINIMG]/actions/approve.png"]"
     */
    override var hiliteIcons: Array<dynamic> = definedExternally
    /**
     *  When DataBoundComponent.hiliteIcons are present, where the hilite icon will be placed
     *   relative to the field value. See HiliteIconPosition. Can be overridden at the
     *   field level.
     *  @type {HiliteIconPosition}
     *  @default "before"
     */
    override var hiliteIconPosition: 
                                     /**
                                      *  icon will be placed before the normal cell contents
                                      *  icon will be placed after the normal cell contents
                                      *  icon will be shown instead of the normal cell contents
                                      */
                                     String /* before |  after |  replace */ = definedExternally
    /**
     *  Default width and height of DataBoundComponent.hiliteIcons for this component.
     *   Can be overridden at the component level via explicit
     *   DataBoundComponent.hiliteIconWidth and
     *   DataBoundComponent.hiliteIconHeight, or at the field level via
     *   ListGridField.hiliteIconSize,
     *   ListGridField.hiliteIconWidth and
     *   ListGridField.hiliteIconHeight
     *  @type {number}
     *  @default "12"
     */
    override var hiliteIconSize: Number = definedExternally
    /**
     *  Width for hilite icons for this component.
     *   Overrides DataBoundComponent.hiliteIconSize.
     *   Can be overridden at the field level.
     *  @type {number}
     *  @default null
     */
    override var hiliteIconWidth: Number = definedExternally
    /**
     *  Height for hilite icons for this listGrid.
     *   Overrides DataBoundComponent.hiliteIconSize.
     *   Can be overridden at the field level
     *  @type {number}
     *  @default null
     */
    override var hiliteIconHeight: Number = definedExternally
    /**
     *  How much padding should there be on the left of DataBoundComponent.hiliteIcons by default?
     *   Can be overridden at the field level
     *  @type {number}
     *  @default "2"
     */
    override var hiliteIconLeftPadding: Number = definedExternally
    /**
     *  How much padding should there be on the right of DataBoundComponent.hiliteIcons by default?
     *   Can be overridden at the field level
     *  @type {number}
     *  @default "2"
     */
    override var hiliteIconRightPadding: Number = definedExternally
    /**
     *  Marker that can be set on a record to flag that record as hilited. Should be set to a value
     *   that matches Hilite.id for a hilite defined on this component.
     *  @type {string}
     *  @default "_hilite"
     */
    override var hiliteProperty: String = definedExternally
    /**
     *  Initial hilite state for the grid.
     * 
     *   ListGrid.viewState can be used to initialize all view properties of the grid.
     *   When doing so, hiliteState is not needed because viewState
     *   includes it as well. If both are provided, hiliteState has priority for
     *   hilite state.
     * 
     * 
     *   To retrieve current state call DataBoundComponent.getHiliteState.
     * 
     *  @type {string}
     *  @default null
     */
    override var hiliteState: String = definedExternally
    /**
     *  The strategy to use when generating names for new fields in this component. The default
     *   strategy, "simple", combines the field-type with an index maintained by field-type and
     *   component instance. For example, "formulaField1".
     *  @type {FieldNamingStrategy}
     *  @default "simple"
     */
    override var fieldNamingStrategy: 
                                      /**
                                       *  generate names in the format fieldTypeX, where field type might be     "formulaField" and X is an index specific to the field-type and component instance
                                       *  generates a UUID for all generated field names
                                       */
                                      String /* simple |  uuid */ = definedExternally
    /**
     *  Text for a menu item allowing users to edit grid highlights.
     *  @type {string}
     *  @default "Edit Highlights..."
     */
    override var editHilitesText: String = definedExternally
    /**
     *  The title for the DataBoundComponent.editHilites dialog.
     *  @type {string}
     *  @default "Edit Highlights"
     */
    override var editHilitesDialogTitle: String = definedExternally
    /**
     *  The title for the DataBoundComponent.fieldEditorWindow used to edit calculated
     *   fields.
     * 
     *   This is a dynamic string - text within &#36;{...} are dynamic variables and will
     *   be evaluated as JS code whenever the message is displayed.
     * 
     *   Two dynamic variables are available - "builderType", either Formula or Summary, and
     *   "fieldTitle", which is the title of the calculated field being edited.
     *  @type {HTMLString}
     *  @default "${builderType} Editor [${fieldTitle}]"
     */
    override var fieldEditorWindowTitle: String = definedExternally
    /**
     *  The Window used to edit calculated fields for this component.
     *  @type {Window}
     *  @default null
     */
    override var fieldEditorWindow: Window = definedExternally
    /**
     *  This component's HiliteEditor instance used to allow the user to create, modify, or delete
     *   hilites.
     * 
     *   The following autoChildUsage apply:
     * 
     * 
     *  - DataBoundComponent.hiliteIcons for HiliteEditor.hiliteIcons
     * 
     *  @type {HiliteEditor}
     *  @default null
     */
    override var hiliteEditor: HiliteEditor = definedExternally
    /**
     *  Indicates what to do with data dragged into another DataBoundComponent. See
     *   DragDataAction type for details.
     *  @type {DragDataAction}
     *  @default "move"
     */
    override var dragDataAction: 
                                 /**
                                  *  Don't do anything, resulting in the same data being in both lists.
                                  *  Copy the data leaving the original in our list.
                                  *  Remove the data from this list so it can be moved into the other list.
                                  */
                                 String /* none |  copy |  move */ = definedExternally
    /**
     *  CSS Style to apply to the drag tracker when dragging occurs on this component.
     *  @type {CSSStyleName}
     *  @default "gridDragTracker"
     */
    override var dragTrackerStyle: String = definedExternally
    /**
     *  If the result of a formula evaluation is invalid (specifically, if isNaN(result)==true),
     *   badFormulaResultValue is displayed instead. The default value is ".".
     *  @type {string}
     *  @default "."
     */
    override var badFormulaResultValue: String = definedExternally
    /**
     *  If a summary format string contains an invalid field reference, replace the reference
     *   with the missingSummaryFieldValue. The default value is "-".
     *  @type {string}
     *  @default "-"
     */
    override var missingSummaryFieldValue: String = definedExternally
    /**
     *  Adds an item to the header context menu allowing users to launch a dialog to define a new
     *   field based on values present in other fields, using the FormulaBuilder.
     * 
     *   User-added formula fields can be persisted via ListGrid.getFieldState and
     *   ListGrid.setFieldState.
     *  @type {boolean}
     *  @default false
     */
    override var canAddFormulaFields: Boolean = definedExternally
    /**
     *  Text for a menu item allowing users to add a formula field
     *  @type {string}
     *  @default "Add formula column..."
     */
    override var addFormulaFieldText: String = definedExternally
    /**
     *  Text for a menu item allowing users to edit a formula field
     *  @type {string}
     *  @default "Edit formula..."
     */
    override var editFormulaFieldText: String = definedExternally
    /**
     *  Text for a menu item allowing users to remove a formula field
     *  @type {string}
     *  @default "Remove formula"
     */
    override var removeFormulaFieldText: String = definedExternally
    /**
     *  Adds an item to the header context menu allowing users to launch a dialog to define a new
     *   text field that can contain both user-defined text and the formatted values present in other
     *   fields, using the SummaryBuilder.
     * 
     *   User-added summary fields can be persisted via ListGrid.getFieldState and
     *   ListGrid.setFieldState.
     *  @type {boolean}
     *  @default false
     */
    override var canAddSummaryFields: Boolean = definedExternally
    /**
     *  Text for a menu item allowing users to add a formula field
     *  @type {string}
     *  @default "Add summary column..."
     */
    override var addSummaryFieldText: String = definedExternally
    /**
     *  Text for a menu item allowing users to edit the formatter for a field
     *  @type {string}
     *  @default "Edit summary format..."
     */
    override var editSummaryFieldText: String = definedExternally
    /**
     *  Text for a menu item allowing users to remove a summary field
     *  @type {string}
     *  @default "Remove summary format..."
     */
    override var removeSummaryFieldText: String = definedExternally
    /**
     *  When assembling a value for a DataBoundComponent.canAddSummaryFields, if a referenced
     *   field is hilited, should the hilite HTML be included in the summary field value?
     * 
     *   To control hilites showing in group summaries, see ListGrid.showHilitesInGroupSummary.
     *  @type {boolean}
     *  @default true
     */
    override var includeHilitesInSummaryFields: Boolean = definedExternally
    /**
     *  Best field to use for a user-visible title for an individual record from this
     *   component.
     * 
     *   This attribute has the same function as DataSource.iconField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var titleField: String = definedExternally
    /**
     *  Designates a field of FieldType:"image" as the field to use when rendering a
     *   record as an image, for example, in a TileGrid.
     * 
     *   This attribute has the same function as DataSource.iconField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var iconField: String = definedExternally
    /**
     *  Name of the field that has the second most pertinent piece of textual information in the
     *   record, for use when a DataBoundComponent needs to show a short summary of a record.
     * 
     *   This attribute has the same function as DataSource.infoField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var infoField: String = definedExternally
    /**
     *  Name of the field that has the most pertinent numeric, date, or enum value, for use when a
     *   DataBoundComponent needs to show a short summary of a record.
     * 
     *   This attribute has the same function as DataSource.dataField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var dataField: String = definedExternally
    /**
     *  The message to display to the user if an export of a DataBoundComponent's data is attempted
     *   while the DataBoundComponent's data is null or an empty list.
     *  @type {string}
     *  @default "You are attempting to export an empty dataset"
     */
    override var emptyExportMessage: String = definedExternally
    /**
     *  Properties to apply to the MultiSortDialog which gets automatically generated
     *   when DataBoundComponent.askForSort is called.
     * 
     *   See also ListGrid.showHeaderSpanTitlesInSortEditor and ListGrid.sortEditorSpanTitleSeparator
     *  @type {MultiSortDialog}
     *  @default null
     */
    override var multiSortDialogProperties: MultiSortDialog = definedExternally
    /**
     *  Class level defaults to apply to the MultiSortDialog which gets automatically
     *   generated when DataBoundComponent.askForSort is called.
     * 
     *   See also ListGrid.showHeaderSpanTitlesInSortEditor and ListGrid.sortEditorSpanTitleSeparator
     *  @type {MultiSortDialog}
     *  @default null
     */
    override var multiSortDialogDefaults: MultiSortDialog = definedExternally
    /**
     *  For databound components that support editing, the error message for a failed validator
     *   that does not specify its own errorMessage.
     *  @type {HTMLString}
     *  @default "Invalid value"
     */
    override var unknownErrorMessage: String = definedExternally
    /**
     *  A message to display to the user if server-side validation fails with an error but the
     *   server did not provide an error message
     *  @type {string}
     *  @default "Error during validation; no error details were provided"
     */
    override var noErrorDetailsMessage: String = definedExternally
    /**
     *   Scroll the calendar Day or Week views to the specified time.
     * 
     *  @param {string} any parsable time-string
     */
    open fun scrollToTime(time: String): Unit = definedExternally
    /**
     *   Rests the current visible range of a calendar view so that it shows the date on which the
     *   passed event occurs.
     * 
     *  @param {CalendarEvent} the event to move the calendar view to
     */
    open fun moveToEvent(event: CalendarEvent): Unit = definedExternally
    /**
     *   For Timelines, configures the levels of HeaderLevel shown above the
     *   event area, and their time units, after initialization.
     * 
     *  @param {Array<Partial<HeaderLevel>>} the array of HeaderLevels to set
     */
    open fun setHeaderLevels(headerLevels: Array<dynamic>): Unit = definedExternally
    /**
     *   Returns true if the passed date should be considered disabled. Disabled dates don't allow
     *   events to be created by clicking on them, and drag operations that would start or end on
     *   such dates are also disallowed.
     * 
     *   The default implementation returns false only for dates that fall on a
     *   DateUtil.getWeekendDays.
     * 
     *  @param {Date} a Date instance
     *  @param {CalendarView=} the view the date appears in
     */
    open fun shouldDisableDate(date: Date, view: CalendarView?): Boolean = definedExternally
    /**
     *   Indicates whether the passed date should be visible in the passed CalendarView.
     * 
     *   The default implementation returns true, unless the date falls on a
     *   DateUtil.getWeekendDays and Calendar.showWeekends is
     *   false.
     * 
     *  @param {Date} a Date instance
     *  @param {CalendarView=} the view the date appears in
     */
    open fun shouldShowDate(date: Date, view: CalendarView?): Boolean = definedExternally
    /**
     *   Indicates whether the passed Calendar.lanes should be visible in the passed
     *   CalendarView.
     * 
     *   The default implementation returns true, unless the lane has no events and
     *   Calendar.hideUnusedLanes is true.
     * 
     *  @param {Lane | string} the lane object or name
     *  @param {CalendarView=} the view the lane appears in
     */
    open fun shouldShowLane(lane: dynamic, view: CalendarView?): Boolean = definedExternally
    /**
     *   Indicates whether the passed CalendarEvent should be visible in the
     *   passed CalendarView.
     * 
     *   The default implementation returns true - note that this method only runs for events that are
     *   known to be in the accessible range and is a mechanism for extended custom filtering.
     * 
     *  @param {CalendarEvent} the event to check
     *  @param {CalendarView=} the view the event will be rendered in
     */
    open fun shouldShowEvent(event: CalendarEvent, view: CalendarView?): Boolean = definedExternally
    /**
     *   Returns the start of the working day on the passed date. By default, this method returns
     *   the value of Calendar.workdayStart.
     * 
     *  @param {Date} a Date instance
     *  @param {string=} the name of the relevant lane - only passed for dayView with               showDayLanes: true
     */
    open fun getWorkdayStart(date: Date, laneName: String?): String = definedExternally
    /**
     *   Returns the end of the working day on the passed date. By default, this method returns
     *   the value of Calendar.workdayEnd.
     * 
     *  @param {Date} a Date instance
     *  @param {string=} the name of the relevant lane - only passed for dayView with               showDayLanes: true
     */
    open fun getWorkdayEnd(date: Date, laneName: String?): String = definedExternally
    /**
     *   Returns the first visible date in the passed, or currently selected, calendar view.
     * 
     *  @param {CalendarView=} the view to get the startDate for, or current view if
     */
    open fun getVisibleStartDate(view: CalendarView?): Date = definedExternally
    /**
     *   Returns the last visible date in the passed, or currently selected, calendar view.
     * 
     *  @param {CalendarView=} the view to get the endDate for, or current view if null
     */
    open fun getVisibleEndDate(view: CalendarView?): Date = definedExternally
    /**
     *   Returns the start of the selected week or month depending on the current calendar view.
     *   For the month view, and for the week view when not showing weekends, this will often be a
     *   different date than that returned by Calendar.getVisibleStartDate.
     * 
     *  @param {CalendarView=} the view to get the periodStartDate for, or current view if null
     */
    open fun getPeriodStartDate(view: CalendarView?): Date = definedExternally
    /**
     *   Returns the end of the period selected in the passed, or current, calendar view.
     *   For the Calendar.monthView, and for the
     *   Calendar.weekView when not showing weekends, this will often be a
     *   different date than that returned by Calendar.getVisibleEndDate.
     * 
     *  @param {CalendarView=} the view to get the periodEndDate for, or current view if null
     */
    open fun getPeriodEndDate(view: CalendarView?): Date = definedExternally
    /**
     *   Retrieves data from the DataSource that matches the specified criteria.
     * 
     *   When fetchData() is first called, if data has not already been provided via
     *   ListGrid.setData, this method will create a ResultSet, which will be
     *   configured based on component settings such as DataBoundComponent.fetchOperation
     *   and DataBoundComponent.dataPageSize, as well as the general purpose
     *   ListGrid.dataProperties. The created ResultSet will automatically send a DSRequest
     *   to retrieve data from ListGrid.dataSource, and from then on will
     *   automatically manage paging through large datasets, as well as performing filtering and
     *   sorting operations inside the browser when possible - see the ResultSet docs for
     *   details.
     * 
     *   NOTE: do not use both DataBoundComponent.autoFetchData and a
     *   call to fetchData() - this may result in two DSRequests to fetch data. Use
     *   either DataBoundComponent.autoFetchData and Criteria or a manual call to fetchData()
     *   passing criteria.
     * 
     *   Whether a ResultSet was automatically created or provided via ListGrid.setData, subsequent
     *   calls to fetchData() will simply call ResultSet.setCriteria.
     * 
     *   Changes to criteria may or may not result in a DSRequest to the server due to
     *   ResultSet.useClientFiltering. You can call
     *   DataBoundComponent.willFetchData to determine if new criteria will result in a
     *   server fetch.
     * 
     *   If you need to force data to be re-fetched, you can call
     *   ListGrid.invalidateCache and new data will automatically be fetched
     *   from the server using the current criteria and sort direction. NOTE: when using
     *   invalidateCache() there is no need to also call fetchData()
     *   and in fact this could produce unexpected results.
     * 
     *   This method takes an optional callback parameter (set to a DSCallback) to fire when
     *   the fetch completes. Note that this callback will not fire if no server fetch is performed.
     *   In this case the data is updated synchronously, so as soon as this method completes you
     *   can interact with the new data. If necessary, you can use
     *   DataBoundComponent.willFetchData to determine whether or not a server
     *   fetch will occur when fetchData() is called with new criteria.
     * 
     *   In addition to the callback parameter for this method, developers can use
     *   ListGrid.dataArrived to be notified every time data is loaded.
     * 
     *   By default, this method assumes a TextMatchStyle of "exact"; that can be overridden
     *   by supplying a different value in the requestProperties parameter.
     *   See DataBoundComponent.willFetchData;
     * 
     * 
     *  @param {Criteria=} Search criteria. If a DynamicForm is passed                     in as this argument instead of a raw criteria                      object, will be derived by calling                      DynamicForm.getValuesAsCriteria
     *  @param {DSCallback=} callback to invoke when a fetch is complete. Fires                     only if server contact was required
     *  @param {DSRequest=} additional properties to set on the DSRequest                     that will be issued
     */
    open fun fetchData(criteria: dynamic?, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Retrieves data that matches the provided criteria and displays the matching data in this
     *   component.
     * 
     *   This method behaves exactly like ListGrid.fetchData except that
     *   DSRequest.textMatchStyle is automatically set to "substring" so that String-valued
     *   fields are matched by case-insensitive substring comparison.
     * 
     * 
     *  @param {Criteria=} Search criteria.            If a DynamicForm is passed in as this argument            instead of a raw criteria object, will be derived by calling            DynamicForm.getValuesAsCriteria
     *  @param {DSCallback=} callback to invoke when a fetch is complete. Fires                     only if server contact was required; see                      ListGrid.fetchData for details
     *  @param {DSRequest=} for databound components only - optional              additional properties to set on the DSRequest that will be issued
     */
    open fun filterData(criteria: dynamic?, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   When Calendar.canGroupLanes is true, this method allows the grouping
     *   in Calendar.timelineViews to be altered at runtime.
     * 
     *  @param {string | Array<Partial<string>>} one or more field names to group by
     */
    open fun groupLanesBy(groupFieldName: dynamic): Unit = definedExternally
    /**
     *   Sets the Calendar.lanes in the current calendar view. Only has an effect
     *   in Calendar.timelineView, and in Calendar.dayView when
     *   Calendar.showDayLanes is true.
     * 
     * 
     *  @param {Array<Partial<Lane>>} array of lanes to display
     */
    open fun setLanes(lanes: Array<dynamic>): Unit = definedExternally
    /**
     *   Adds a new Lane to the calendar, for display in the
     *   Calendar.timelineView, and in the
     *   Calendar.dayView if Calendar.showDayLanes is true.
     * 
     * 
     *  @param {Lane} a new Lane object to add to the calendar
     */
    open fun addLane(lane: Lane): Unit = definedExternally
    /**
     *   Removes a lane from the calendar in Calendar.timelineView, or in Calendar.dayView if
     *   Calendar.showDayLanes is true.
     * 
     *   Accepts either a Lane or a string that represents the
     *   Lane.name of a lane.
     * 
     * 
     *  @param {Lane | string} either the actual Lane object or the name of the lane to remove
     */
    open fun removeLane(lane: dynamic): Unit = definedExternally
    /**
     *   Changes the Calendar.showDayLanes of the day view at runtime - whether to show a
     *   normal day column for the Calendar.chosenDate, or the specified set of
     *   Calendar.lanes.
     * 
     * 
     *  @param {boolean} whether or not to show lanes in the day view
     */
    open fun setShowDayLanes(showDayLanes: Boolean): Unit = definedExternally
    /**
     *   A notification method fired when the events in the current view have been refreshed.
     * 
     */
    open fun eventsRendered(): Unit = definedExternally
    /**
     *   Initialize the data object with the given array. Observes methods of the data object
     *   so that when the data changes, the calendar will redraw automatically.
     * 
     * 
     *  @param {Array<Partial<CalendarEvent>>} data to show in the list
     */
    open fun setData(newData: Array<dynamic>): Unit = definedExternally
    /**
     *   Returns the currently selected CalendarView.
     * 
     */
    open fun getSelectedView(): CalendarView = definedExternally
    /**
     *   Returns the CalendarView with the passed ViewName.
     * 
     *  @param {ViewName} the name of the CalendarView to return
     */
    open fun getView(viewName: 
                               /**
                                *  day view
                                *  week view
                                *  month view
                                *  timeline view
                                */
                               String /* day |  week |  month |  timeline */): CalendarView = definedExternally
    /**
     *   Get the name of the visible view.  Returns one of 'day', 'week', 'month' or 'timeline'.
     * 
     * 
     */
    open fun getCurrentViewName(): 
                                   /**
                                    *  day view
                                    *  week view
                                    *  month view
                                    *  timeline view
                                    */
                                   String /* day |  week |  month |  timeline */ = definedExternally
    /**
     *   Sets the currently visible view.
     * 
     * 
     *  @param {ViewName} The name of the view that should be made visible.
     */
    open fun setCurrentViewName(viewName: 
                                          /**
                                           *  day view
                                           *  week view
                                           *  month view
                                           *  timeline view
                                           */
                                          String /* day |  week |  month |  timeline */): 
                                                                                          /**
                                                                                           *  day view
                                                                                           *  week view
                                                                                           *  month view
                                                                                           *  timeline view
                                                                                           */
                                                                                          String /* day |  week |  month |  timeline */ = definedExternally
    /**
     *   Returns the title text for the passed event, for display in the header area of an event
     *   canvas. The default implementation returns the event's
     *   Calendar.nameField for timelines, and that same value pre-pended with
     *   the event's Calendar.startDateField and Calendar.endDateField
     *   dates for day and week views.
     * 
     * 
     *  @param {CalendarEvent} the event to get the description text for
     *  @param {CalendarView=} the view in which the event is being rendered
     */
    open fun getEventHeaderHTML(event: CalendarEvent, view: CalendarView?): String = definedExternally
    /**
     *   Returns the description text for the passed event, for display in the body area of an event
     *   canvas. The default implementation returns the event's
     *   Calendar.descriptionField.
     * 
     * 
     *  @param {CalendarEvent} the event to get the description text for
     *  @param {CalendarView=} the view in which the event is being rendered
     */
    open fun getEventBodyHTML(event: CalendarEvent, view: CalendarView?): String = definedExternally
    /**
     *   Returns the CalendarEvent.startDate of the passed event.
     * 
     * 
     *  @param {CalendarEvent} the event to get the start date of
     */
    open fun getEventStartDate(event: CalendarEvent): Date = definedExternally
    /**
     *   Returns the Calendar.endDateField of the passed event. If the event is
     *   Calendar.allowDurationEvents, the result is calculated from the
     *   CalendarEvent.startDate and the specified
     *   CalendarEvent.duration and CalendarEvent.durationUnit.
     * 
     * 
     *  @param {CalendarEvent} the event to get the start date of
     */
    open fun getEventEndDate(event: CalendarEvent): Date = definedExternally
    /**
     *   Setter for updating Calendar.showWeekends at runtime.
     * 
     * 
     *  @param {boolean} whether or not to show weekends
     */
    open fun setShowWeekends(showWeekends: Boolean): Unit = definedExternally
    /**
     *   For Timelines, and for Calendar.dayView with
     *   Calendar.showDayLanes set, creates a new event and adds it to a
     *   particular Lane.
     * 
     * 
     *  @param {Lane} the Lane in which to add this event
     *  @param {Date | object} start date of event, or CalendarEvent Object
     *  @param {Date=} end date of event
     *  @param {string=} name of event
     *  @param {string=} description of event
     *  @param {any=} new values of additional fields to be updated
     *  @deprecated \* in favor of Calendar.addCalendarEvent
     */
    open fun addLaneEvent(laneName: Lane, startDate: dynamic, endDate: Date?, name: String?, description: String?, otherFields: dynamic?): Unit = definedExternally
    /**
     *   Create a new event in this calendar instance.
     * 
     * 
     *  @param {Date | CalendarEvent} start date of event, or CalendarEvent Object
     *  @param {Date=} end date of event
     *  @param {string=} name of event
     *  @param {string=} description of event
     *  @param {object=} new values of additional fields to be updated
     *  @deprecated \* in favor of Calendar.addCalendarEvent
     */
    open fun addEvent(startDate: dynamic, endDate: Date?, name: String?, description: String?, otherFields: dynamic?): Unit = definedExternally
    /**
     *   Create a new event in this calendar.
     * 
     *   In all cases, the CalendarEvent passed as the first parameter must have at
     *   least a Calendar.startDateField set. If the calendar is showing
     *   Calendar.lanes, the name of the CalendarEvent.lane and, if
     *   applicable, the CalendarEvent.sublane, must also be set.
     * 
     * 
     *  @param {CalendarEvent} the new calendar event to add
     *  @param {object=} additional, custom values to be saved with the event
     */
    open fun addCalendarEvent(event: CalendarEvent, customValues: dynamic?): Unit = definedExternally
    /**
     *   Remove an event from this calendar.
     * 
     * 
     *  @param {CalendarEvent} The event object to remove from the calendar
     */
    open fun removeEvent(event: CalendarEvent): Unit = definedExternally
    /**
     *   Update an event in this calendar.
     * 
     * 
     *  @param {CalendarEvent} The event object to update
     *  @param {Date} start date of event
     *  @param {Date} end date of event
     *  @param {string} name of event
     *  @param {string} description of event
     *  @param {object} new values of additional fields to be updated
     *  @deprecated \* in favor of Calendar.updateCalendarEvent
     */
    open fun updateEvent(event: CalendarEvent, startDate: Date, endDate: Date, name: String, description: String, otherFields: dynamic): Unit = definedExternally
    /**
     *   Update an event in this calendar.
     * 
     * 
     *  @param {CalendarEvent} The event object that will be updated
     *  @param {CalendarEvent} The new attributes for the event
     *  @param {object} new values of additional fields to be updated
     */
    open fun updateCalendarEvent(event: CalendarEvent, newEvent: CalendarEvent, otherFields: dynamic): Unit = definedExternally
    /**
     *   Refreshes the passed event in the current view.
     * 
     * 
     *  @param {CalendarEvent} The event object to refresh in the current view
     */
    open fun refreshEvent(event: CalendarEvent): Unit = definedExternally
    /**
     *   Update the styleName for the passed event. Refreshes the event's canvas in the current view.
     * 
     * 
     *  @param {CalendarEvent} The event object to refresh in the current view
     *  @param {CSSStyleName} The new CSS style to apply to the canvases showing this event
     */
    open fun setEventStyle(event: CalendarEvent, styleName: String): Unit = definedExternally
    /**
     *   Gets the hover HTML for an event being hovered over. Override here to return custom
     *   HTML based upon the parameter event object.
     * 
     * 
     *  @param {CalendarEvent} The event being hovered
     *  @param {EventCanvas} the event canvas being hovered over
     *  @param {CalendarView} the CalendarView in which the eventCanvas lives
     *  @param {string=} the default HTML to show when hovering over the passed event
     */
    open fun getEventHoverHTML(event: CalendarEvent, eventCanvas: EventCanvas, view: CalendarView, defaultValue: String?): String = definedExternally
    /**
     *   Gets the hover HTML for a Calendar.zones being hovered over. Override here to
     *   return custom HTML based upon the parameter zone object.
     * 
     * 
     *  @param {CalendarEvent} The zone being hovered over
     *  @param {ZoneCanvas} the zone canvas being hovered over
     *  @param {CalendarView} the CalendarView in which the zoneCanvas is displayed
     *  @param {string} the default HTML to show when hovering over the passed Zone
     */
    open fun getZoneHoverHTML(zone: CalendarEvent, zoneCanvas: ZoneCanvas, view: CalendarView, defaultValue: String): String = definedExternally
    /**
     *   Gets the hover HTML for an Calendar.indicators being hovered over.
     *   Override here to return custom HTML based upon the parameter indicator object.
     * 
     * 
     *  @param {CalendarEvent} The indicator being hovered over
     *  @param {IndicatorCanvas} the indicator canvas being hovered over
     *  @param {CalendarView} the CalendarView in which the indicatorCanvas is displayed
     *  @param {string} the default HTML to show when hovering over the passed Indicator
     */
    open fun getIndicatorHoverHTML(indicator: CalendarEvent, indicatorCanvas: IndicatorCanvas, view: CalendarView, defaultValue: String): String = definedExternally
    /**
     *   Returns the hover HTML for the cell at the passed co-ordinates in the passed view. By
     *   default, the hover text is the snap date closest to the mouse, if the cell being hovered is
     *   a normal date cell - otherwise, it is the title of the Calendar.laneFields
     *   being hovered over.
     * 
     *   Override here to return custom HTML for the passed cell.
     * 
     * 
     *  @param {CalendarView} the CalendarView the mouse is hovered over
     *  @param {Record} The record containing the cell being hovered
     *  @param {Integer} The rowNum of the cell being hovered
     *  @param {Integer} the colNum of the cell being hovered
     *  @param {Date} the snap-date at the mouse, which may be different from the result of a           call to Calendar.getCellDate
     *  @param {string} the default hover text for the passed values
     */
    open fun getCellHoverHTML(view: CalendarView, record: Record, rowNum: Number, colNum: Number, date: Date, defaultValue: String): String = definedExternally
    /**
     *   Returns the hover HTML to show in a hover when the mouse moves over the header area.
     * 
     * 
     *  @param {CalendarView} the CalendarView the mouse is hovered over
     *  @param {HeaderLevel} the header level hovered over
     *  @param {Date} the start date of the span being hovered over
     *  @param {Date} the end date of the span being hovered over
     *  @param {string} the default text for the passed header level and date range
     */
    open fun getHeaderHoverHTML(view: CalendarView, headerLevel: HeaderLevel, startDate: Date, endDate: Date, defaultValue: String): String = definedExternally
    /**
     *   Switches the various levels of Calendar.showViewHovers on or off at runtime.
     * 
     * 
     *  @param {boolean} whether to allow CalendarViews to show hovers
     */
    open fun setShowViewHovers(showViewHovers: Boolean): Unit = definedExternally
    /**
     *   Returns the HTML to show in a hover when an existing event is dragged, or when a new event
     *   is being created by dragging with the mouse.
     * 
     * 
     *  @param {CalendarView} the CalendarView the mouse is hovered over
     *  @param {CalendarEvent} the CalendarEvent attached to the EventCanvas being dragged
     *  @param {string} the default text for the passed values
     */
    open fun getDragHoverHTML(view: CalendarView, event: CalendarEvent, defaultValue: String): String = definedExternally
    /**
     *   Returns the CSSStyleName to use for the passed
     *   CalendarEvent, in the passed CalendarView. By default, returns
     *   the style Calendar.eventStyleNameField, if one is specified - otherwise,
     *   in Calendar.lanes views, it returns the style specified on the
     *   Lane.eventStyleName, or the style specified on the
     *   Calendar.eventStyleName.
     * 
     *  @param {CalendarEvent} the event to get the CSS style for
     *  @param {CalendarView=} the CalendarView that contains the canvas being styled
     */
    open fun getEventCanvasStyle(event: CalendarEvent, view: CalendarView?): String = definedExternally
    /**
     *   If this method returns a value, it is expected to return an array of
     *   MenuItem applicable to the passed canvas and its event. If an array
     *   with valid entries is returned, the rollover
     *   Calendar.eventCanvasContextButton is shown for the passed canvas.
     * 
     *  @param {EventCanvas} the canvas to get menu items for
     */
    open fun getEventCanvasMenuItems(canvas: EventCanvas): Array<dynamic> = definedExternally
    /**
     *   Selects a single event in the current view, showing it in a selected style and deselecting
     *   any other selected events.
     * 
     *  @param {CalendarEvent} the event to select
     */
    open fun selectSingleEvent(event: CalendarEvent): Boolean = definedExternally
    /**
     *   Adds an event to the list of selected events in the current view, showing it in a selected
     *   style.
     * 
     *  @param {CalendarEvent} the event to add to the selection
     */
    open fun selectEvent(event: CalendarEvent): Boolean = definedExternally
    /**
     *   Adds one or more events to the list of selected events in the current view, showing them in
     *   a selected style.
     * 
     *  @param {Array<Partial<CalendarEvent>>} the events to add to the selection
     */
    open fun selectEvents(events: Array<dynamic>): Boolean = definedExternally
    /**
     *   Removes an event from the list of selected events in the current view, clearing its selected
     *   style.
     * 
     *  @param {CalendarEvent} the event to deselect
     */
    open fun deselectEvent(event: CalendarEvent): Boolean = definedExternally
    /**
     *   Removes one or more events from the list of selected events in the current view, clearing
     *   their selected styles.
     * 
     *  @param {Array<Partial<CalendarEvent>>} the events to deselect
     */
    open fun deselectEvents(events: Array<dynamic>): Boolean = definedExternally
    /**
     *   Returns the currently selected CalendarEvent, or the first one if more
     *   than one is selected.
     * 
     */
    open fun getSelectedEvent(): CalendarEvent = definedExternally
    /**
     *   Returns the currently selected list of CalendarEvent.
     * 
     */
    open fun getSelectedEvents(): Array<dynamic> = definedExternally
    /**
     *   Returns the Calendar.eventCanvasGripperIcon to use as the gripper for
     *   the passed event canvas.
     * 
     *  @param {EventCanvas} the canvas that will show the gripper
     */
    open fun getEventCanvasGripperIcon(canvas: EventCanvas): String = definedExternally
    /**
     *   Sets the Calendar.zones used to highlight areas of this calendar.
     * 
     * 
     *  @param {Array<Partial<CalendarEvent>>} array of zones to display
     */
    open fun setZones(zones: Array<dynamic>): Unit = definedExternally
    /**
     *   Adds a new Calendar.zones to the calendar.
     * 
     * 
     *  @param {CalendarEvent} a new zone to add to the calendar
     */
    open fun addZone(zone: CalendarEvent): Unit = definedExternally
    /**
     *   Removes a Calendar.zones from the calendar.
     * 
     *   Accepts either a CalendarEvent or a string that represents the
     *   CalendarEvent.name of a zone.
     * 
     * 
     *  @param {CalendarEvent | string} either the actual CalendarEvent representing the zone,         or the name of the zone to remove
     */
    open fun removeZone(zone: dynamic): Unit = definedExternally
    /**
     *   Returns the CSSStyleName to use for the passed
     *   Calendar.zones, in the passed CalendarView. By default,
     *   returns the style Calendar.eventStyleNameField, if one is specified,
     *   or the style specified on the Calendar.zoneStyleName otherwise.
     * 
     *  @param {CalendarEvent} the zone to get the CSS style for
     *  @param {CalendarView=} the CalendarView that contains the canvas being styled
     */
    open fun getZoneCanvasStyle(zone: CalendarEvent, view: CalendarView?): String = definedExternally
    /**
     *   Returns the CSSStyleName to use for the passed
     *   Calendar.indicators, in the passed CalendarView. By default,
     *   returns the style Calendar.eventStyleNameField, if one is specified,
     *   or the style specified on the Calendar.indicatorStyleName otherwise.
     * 
     *  @param {CalendarEvent} the indicator to get the CSS style for
     *  @param {CalendarView=} the CalendarView that contains the canvas being styled
     */
    open fun getIndicatorCanvasStyle(indicator: CalendarEvent, view: CalendarView?): String = definedExternally
    /**
     *   Sets the Calendar.indicators used to highlight instants in time.
     * 
     *  @param {Array<Partial<CalendarEvent>>} array of indicators to display
     */
    open fun setIndicators(indicators: Array<dynamic>): Unit = definedExternally
    /**
     *   Adds a new Calendar.indicators to the calendar.
     * 
     *  @param {CalendarEvent} a new indicator to add to the calendar
     */
    open fun addIndicator(indicator: CalendarEvent): Unit = definedExternally
    /**
     *   Removes a Calendar.indicators from the calendar.
     * 
     *   Accepts either a CalendarEvent or a string that represents the
     *   CalendarEvent.name of anindicator.
     * 
     *  @param {CalendarEvent | string} either the actual CalendarEvent representing the          indicator, or the name of the indicator to remove
     */
    open fun removeIndicator(indicator: dynamic): Unit = definedExternally
    /**
     *   Set the current date for which the calendar will display events.
     * 
     * 
     *  @param {Date} the new date to set as the current date
     */
    open fun setChosenDate(newDate: Date): Unit = definedExternally
    /**
     *   Should the parameter date be considered a workday? By default this method tries to find the
     *   parameter date day in Calendar.workdays, and returns true if found. Override this method to
     *   provide custom logic for determining workday, for example returning false on holidays.
     * 
     *   Note that, when showing Calendar.showDayLanes in the
     *   Calendar.dayView, this method is also passed the name of the associated lane.
     * 
     * 
     *  @param {Date} date to check for being a workday
     *  @param {string} the name of the lane if Calendar.showDayLanes is true, null otherwise
     */
    open fun dateIsWorkday(date: Date, laneName: String): Boolean = definedExternally
    /**
     *   Move to the next day, week, or month, depending on which tab is selected.
     * 
     * 
     */
    open fun next(): Unit = definedExternally
    /**
     *   Move to the previous day, week, month, or timeline range depending on which tab is selected.
     * 
     * 
     */
    open fun previous(): Unit = definedExternally
    /**
     *   For views that support Calendar.lanes, returns the padding to apply to events
     *   rendered in lanes in the passed or current view. By default, returns
     *   Calendar.laneEventPadding.
     * 
     * 
     *  @param {CalendarView=} the view to get the lane padding for
     */
    open fun getLanePadding(view: CalendarView?): Number = definedExternally
    /**
     *   For views that support Calendar.lanes, returns the array of events in the
     *   current dataset that apply to the passed lane in the passed or current view.
     * 
     * 
     *  @param {Lane | string} lane object or name to get the events for
     *  @param {CalendarView=} the view in which the passed lane lives - uses the selected                view if unset
     */
    open fun getLaneEvents(lane: dynamic, view: CalendarView?): Array<dynamic> = definedExternally
    /**
     *   For views that support Calendar.lanes and allow
     *   Calendar.useSublanes, returns the array of events in the
     *   current dataset that apply to the passed lane and sublane in the passed or current view.
     * 
     * 
     *  @param {Lane | string} lane object or name to get the events for
     *  @param {Lane | string} sublane object or name to get the events for
     *  @param {CalendarView=} the view in which the passed sublane lives - uses the selected                view if unset
     */
    open fun getSublaneEvents(lane: dynamic, sublane: dynamic, view: CalendarView?): Array<dynamic> = definedExternally
    /**
     *   Returns the text to display between the navigation buttons above the Calendar - indicates
     *   the visible date range.
     * 
     *  @param {string} one of "day", "week", "month" or "timeline"
     *  @param {Date} the start of the visible date range
     *  @param {Date=} the optional end of the visible date range
     */
    open fun getDateLabelText(viewName: String, startDate: Date, endDate: Date?): String = definedExternally
    /**
     *   Cancels the current edit-session, closing the builtin event
     *   Calendar.eventDialog or Calendar.eventEditor and clearing any
     *   visible edit-selection from the Calendar.getSelectedView.
     * 
     * 
     */
    open fun cancelEditing(): Unit = definedExternally
    /**
     *   Open the Quick Event dialog showing minimal information about an existing
     *   CalendarEvent.
     * 
     *   The Calendar.startDateField field on the event is used to calculate the
     *   display location for the dialog.
     * 
     *   If this method is called when the Event Dialog is already showing another event, and if
     *   changes have been made, a confirmation dialog is displayed and editing of the new event
     *   is cancelled unless confirmed.
     * 
     *   You can override this method to prevent the default action, perhaps instead showing a custom
     *   interface that performs validations or gathers custom data before making a call to
     *   Calendar.addCalendarEvent or
     *   Calendar.updateCalendarEvent when the new data is available.
     * 
     * 
     *  @param {CalendarEvent=} the event to show in the Editor
     *  @param {boolean=} optional boolean indicating that this is a new event, event if                an event is passed - used to pass defaults for a new event
     */
    open fun showEventDialog(event: CalendarEvent?, isNewEvent: Boolean?): Unit = definedExternally
    /**
     *   Open the Quick Event dialog to begin editing a new CalendarEvent.
     * 
     *   If passed, the event parameter is used as defaults for the new event - in addition, the
     *   event's Calendar.startDateField, and its
     *   Calendar.laneNameField, for timeline events, are used to calculate the
     *   display location for the dialog.
     * 
     *   If this method is called when the Event Dialog is already showing another event, and if
     *   changes have been made, a confirmation dialog is displayed and editing of the new event
     *   is cancelled unless confirmed.
     * 
     *   You can override this method to prevent the default action, perhaps instead showing a custom
     *   interface that performs validations or gathers custom data before making a call to
     *   Calendar.addCalendarEvent or
     *   Calendar.updateCalendarEvent when the new data is available.
     * 
     * 
     *  @param {CalendarEvent=} defaults for the new event
     */
    open fun showNewEventDialog(event: CalendarEvent?): Unit = definedExternally
    /**
     *   Show an Event Editor for the passed event. Event Editor's fill the Calendar and allow
     *   for editing of the built-in Event fields, like Calendar.nameField and
     *   Calendar.descriptionField, as well as any
     *   custom fields supplied via Calendar.eventEditorFields.
     * 
     *   If isNewEvent is true, a new event is created - in this case, if an event is passed, it
     *   represents default values to apply to the new event.
     * 
     *   You can override this method to prevent the default action, perhaps instead showing a custom
     *   interface that performs validations or gathers custom data before making a call to
     *   Calendar.addCalendarEvent or
     *   Calendar.updateCalendarEvent when the new data is available.
     * 
     * 
     *  @param {CalendarEvent=} an existing event to show in the Editor
     *  @param {boolean=} optional boolean indicating that this is a new event, even if                an event is passed - used to pass defaults for a new event
     */
    open fun showEventEditor(event: CalendarEvent?, isNewEvent: Boolean?): Unit = definedExternally
    /**
     *   Show an Event Editor for a new event. If an CalendarEvent is passed as the
     *   parameter, it is used as defaults for the new event.
     * 
     * 
     *  @param {CalendarEvent=} defaults for the new event to show in the Editor
     */
    open fun showNewEventEditor(event: CalendarEvent?): Unit = definedExternally
    /**
     *   Return CSS text for styling the cell associated with the passed date and/or rowNum & colNum,
     *   which will be applied in addition to the CSS class for the cell, as overrides.
     * 
     *   "CSS text" means semicolon-separated style settings, suitable for inclusion in a CSS
     *   stylesheet or in a STYLE attribute of an HTML element.
     * 
     * 
     *  @param {Date} the date to return CSS text for
     *  @param {Integer} the row number containing the date to get the CSS for
     *  @param {Integer} the column number containing the date to get the CSS for
     *  @param {CalendarView} the relevant CalendarView
     */
    open fun getDateCSSText(date: Date, rowNum: Number, colNum: Number, view: CalendarView): String = definedExternally
    /**
     *   Return the CSS styleName for the associated date-cell in the passed view.
     * 
     * 
     *  @param {Date} the date to return the CSS styleName for
     *  @param {Integer} the row number containing the date to get the CSS styleName for
     *  @param {Integer} the column number containing the date to get the CSS styleName for
     *  @param {CalendarView} the relevant CalendarView
     */
    open fun getDateStyle(date: Date, rowNum: Number, colNum: Number, view: CalendarView): String = definedExternally
    /**
     *   Return the HTML to be displayed in the associated date-cell in the passed view.
     * 
     *   Note that the Calendar.monthView has default cell HTML, controlled via
     *   Calendar.getDayBodyHTML.
     * 
     * 
     *  @param {Date} the date to get the HTML for
     *  @param {Integer} the row number containing the date to get the HTML for
     *  @param {Integer} the column number containing the date to get the HTML for
     *  @param {CalendarView} the relevant CalendarView
     */
    open fun getDateHTML(date: Date, rowNum: Number, colNum: Number, view: CalendarView): String = definedExternally
    /**
     *   When Calendar.getDateHTML returns a value, this method returns the
     *   horizontal alignment for that value in its cell, in the passed view.
     * 
     * 
     *  @param {Date} the date to get the cell-alignment for
     *  @param {Integer} the row number containing the date to get the cell-alignment for
     *  @param {Integer} the column number containing the date to get the cell-alignment for
     *  @param {CalendarView} the relevant CalendarView
     */
    open fun getDateCellAlign(date: Date, rowNum: Number, colNum: Number, view: CalendarView): String = definedExternally
    /**
     *   When Calendar.getDateHTML returns a value, this method returns the
     *   vertical alignment for that value in its cell, in the passed view.
     * 
     * 
     *  @param {Date} the date to get the cell-alignment for
     *  @param {Integer} the row number containing the date to get the cell-alignment for
     *  @param {Integer} the column number containing the date to get the cell-alignment for
     *  @param {CalendarView} the relevant CalendarView
     */
    open fun getDateCellVAlign(date: Date, rowNum: Number, colNum: Number, view: CalendarView): String = definedExternally
    /**
     *   Return the title text to display in the header-button of the ListGridField showing the
     *   passed date, in the passed view.
     * 
     * 
     *  @param {Date} the date to return the header-title for - note that the           Calendar.monthView does not pass this parameter           because a single column represents multiple dates
     *  @param {Integer} the week-day number of the passed date, except for the              Calendar.monthView, where no date is passed,              because the week-day number represents multiple dates.
     *  @param {string} the default header-title for the passed date and view
     *  @param {CalendarView} the relevant CalendarView
     */
    open fun getDateHeaderTitle(date: Date, dayOfWeek: Number, defaultValue: String, view: CalendarView): String = definedExternally
    /**
     *   Return the Date instance associated with the passed co-ordinates in the passed or selected
     *   view. If the cell at the passed co-ordinates is not a date-cell, returns null. If rowNum
     *   and colNum are both unset, returns the date from the cell under the mouse.
     * 
     *   To determine the date at a more specific point within a cell, see Calendar.getDateFromPoint.
     * 
     * 
     *  @param {Integer=} the row number to get the date for
     *  @param {Integer=} the column number to get the date for
     *  @param {CalendarView=} the view to use - uses the selected view if not passed
     */
    open fun getCellDate(rowNum: Number?, colNum: Number?, view: CalendarView?): Date = definedExternally
    /**
     *   Returns a Date instance representing the point at the passed offsets into the body of the
     *   current view.
     * 
     *   If snapOffsets is passed as false, returns the date representing the
     *   exact position of the passed offsets. If unset or passed as true, returns the date at the
     *   nearest eventSnapGap to the left, for Timelines, or above for Calendar.dayView
     *   and Calendar.weekView views.
     * 
     *   If neither x nor y offsets are passed, assumes them from the last mouse event.
     * 
     *   If the cell at the eventual offsets is not a date-cell, returns null.
     * 
     *   Note that, for the Calendar.monthView, this method is functionally equivalent to
     *   Calendar.getCellDate, which determines the date associated with a cell, without the additional
     *   offset precision offered here.
     * 
     * 
     *  @param {Integer=} the x offset into the body of the selected view - non-functional for            the Calendar.dayView. If this param and "y" are both unset,            assumes both offsets from the last mouse event.
     *  @param {Integer=} the y offset into the body of the selected view - non-functional for the              Calendar.timelineView. If this param and "x" are               both unset, assumes both offsets from the last mouse event.
     *  @param {boolean=} whether to snap the offsets to the nearest eventSnapGap - if                 unset, the default is true
     *  @param {CalendarView=} the view to use - or the selected view if not passed
     */
    open fun getDateFromPoint(x: Number?, y: Number?, snapOffsets: Boolean?, view: CalendarView?): Date = definedExternally
    /**
     *   Returns the Lane with the passed name, in the passed view
     * 
     *  @param {string} the name of the lane to return
     *  @param {CalendarView=} the view to get the lane object from
     */
    open fun getLane(lane: String, view: CalendarView?): Lane = definedExternally
    /**
     *   Returns the Lane associated with the passed event, in the passed view
     * 
     *  @param {CalendarEvent} the event to get the lane for
     *  @param {CalendarView=} the view to get the lane object from
     */
    open fun getEventLane(event: CalendarEvent, view: CalendarView?): Lane = definedExternally
    /**
     *   Returns the Lane.sublanes with the passed name, from the Lane
     *   with the passed name, in the passed view.
     * 
     *  @param {string} the name of the lane containing the sublane to return
     *  @param {string} the name of the sublane to return
     *  @param {CalendarView=} the view to get the sublane object from
     */
    open fun getSublane(lane: String, sublane: String, view: CalendarView?): Lane = definedExternally
    /**
     *   Returns the Lane.sublanes associated with the passed event, in the passed view
     * 
     *  @param {CalendarEvent} the event to get the sublane for
     *  @param {CalendarView=} the view to get the sublane object from
     */
    open fun getEventSublane(event: CalendarEvent, view: CalendarView?): Lane = definedExternally
    /**
     *   Returns the Lane at the passed co-ordinates. To get the lane under the mouse, pass
     *   null for both x and y.
     * 
     *  @param {Integer=} the x offset into the body of the selected view
     *  @param {Integer=} the y offset into the body of the selected view. If this param and "x" are               both unset, assumes both offsets from the last mouse event.
     *  @param {CalendarView=} the view to get the lane from - selected view if not passed
     */
    open fun getLaneFromPoint(x: Number?, y: Number?, view: CalendarView?): Lane = definedExternally
    /**
     *   Returns the Lane.sublanes at the passed co-ordinates. To get the sublane under
     *   the mouse, pass null for both x and y.
     * 
     *  @param {Integer=} optional x offset into the body of the selected view
     *  @param {Integer=} optional y offset into the body of the selected view. If this param and "x" are               both unset, assumes both offsets from the last mouse event.
     *  @param {CalendarView=} the view to get the sublane from - selected view if not passed
     */
    open fun getSublaneFromPoint(x: Number?, y: Number?, view: CalendarView?): Lane = definedExternally
    /**
     *   Notification that fires whenever the current view changes via the
     *   Calendar.mainView.
     * 
     * 
     *  @param {ViewName} the name of the current view after the change
     */
    open fun currentViewChanged(viewName: 
                                          /**
                                           *  day view
                                           *  week view
                                           *  month view
                                           *  timeline view
                                           */
                                          String /* day |  week |  month |  timeline */): Unit = definedExternally
    /**
     *   Return the HTML to be shown in the body of a day in the month view.
     * 
     *   Default is to render a series of links that call Calendar.eventClick to provide details
     *   and/or an editing interface for the events.
     * 
     *   getDayBodyHTML() is not called for days outside of the current month if
     *   Calendar.showOtherDays is false.
     * 
     * 
     *  @param {Date} JavaScript Date object representing this day
     *  @param {Array<Partial<CalendarEvent>>} events that fall on this day
     *  @param {Calendar} the calendar itself
     *  @param {Integer} the row number to which the parameter date belongs
     *  @param {Integer} the column number to which the parameter date belongs
     */
    open fun getDayBodyHTML(date: Date, events: Array<dynamic>, calendar: Calendar, rowNum: Number, colNum: Number): String = definedExternally
    /**
     *   This method returns the hover HTML to be displayed when the user hovers over a cell
     *   displayed in the calendar month view tab.
     * 
     *   Default implementation will display a list of the events occurring on the date the user is
     *   hovering over. Override for custom behavior. Note that returning null will suppress the
     *   hover altogether.
     * 
     * 
     *  @param {Date} Date the user is hovering over
     *  @param {Array<Partial<CalendarEvent>>} array of events occurring on the current date. May be empty.
     */
    open fun getMonthViewHoverHTML(date: Date, events: Array<dynamic>): String = definedExternally
    /**
     *   Called when the body area of a day in the month view is clicked on, outside of any links
     *   to a particular event.
     * 
     *   By default, if the user can add events, shows a dialog for adding a new event for that
     *   day. Return false to cancel this action.
     * 
     *   Not called if the day falls outside the current month and Calendar.showOtherDays is false.
     * 
     * 
     *  @param {Date} JavaScript Date object representing this day
     *  @param {Array<Partial<CalendarEvent>>} events that fall on this day
     *  @param {Calendar} the calendar itself
     *  @param {Integer} the row number to which the parameter date belongs
     *  @param {Integer} the column number to which the parameter date belongs
     */
    open fun dayBodyClick(date: Date, events: Array<dynamic>, calendar: Calendar, rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Called when the header area of a day in the month view is clicked on.
     * 
     *   By default, moves to the day tab and shows the clicked days events.
     *   Return false to cancel this action.
     * 
     *   Not called if the day falls outside the current month and Calendar.showOtherDays is false.
     * 
     * 
     *  @param {Date} JavaScript Date object representing this day
     *  @param {Array<Partial<CalendarEvent>>} events that fall on this day
     *  @param {Calendar} the calendar itself
     *  @param {Integer} the row number to which the parameter date belongs
     *  @param {Integer} the column number to which the parameter date belongs
     */
    open fun dayHeaderClick(date: Date, events: Array<dynamic>, calendar: Calendar, rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Notification fired whenever a user changes an event, whether by dragging the event or by
     *   editing it in a dialog.
     * 
     *   In a calendar with a DataSource, eventChanged() fires after the updated event has
     *   been successfully saved to the server
     * 
     * 
     *  @param {CalendarEvent} the event that changed
     */
    open fun eventChanged(event: CalendarEvent): Unit = definedExternally
    /**
     *   Notification fired whenever a user removes an event.
     * 
     *   In a calendar with a DataSource, eventRemoved() fires after the event has
     *   been successfully removed from the server
     * 
     * 
     *  @param {CalendarEvent} the event that was removed
     */
    open fun eventRemoved(event: CalendarEvent): Unit = definedExternally
    /**
     *   Notification fired whenever a user adds an event.
     * 
     *   In a calendar with a DataSource, eventAdded() fires after the event has
     *   been successfully added at the server
     * 
     * 
     *  @param {CalendarEvent} the event that was added
     */
    open fun eventAdded(event: CalendarEvent): Unit = definedExternally
    /**
     *   Called whenever an event is clicked on in the day, week or month views.
     * 
     *   By default a dialog appears showing details for the event, and offering the ability to
     *   edit events which are editable. Return false to cancel the default action. This is a good
     *   place to, for example, show a completely customized event dialog instead of the default one.
     * 
     * 
     *  @param {CalendarEvent} event that was clicked on
     *  @param {ViewName} view where the event's canvas was clicked
     */
    open fun eventClick(event: CalendarEvent, viewName: 
                                                        /**
                                                         *  day view
                                                         *  week view
                                                         *  month view
                                                         *  timeline view
                                                         */
                                                        String /* day |  week |  month |  timeline */): Boolean = definedExternally
    /**
     *   Called whenever the close icon of an EventCanvas is clicked in the
     *   Calendar.dayView, Calendar.weekView and Calendar.timelineView views, or when
     *   the Calendar.removeButton is pressed in the Calendar.eventEditor.
     * 
     *   Implement this method to intercept the automatic removal of data. You can return false to
     *   prevent the default action (calling Calendar.removeEvent) and instead
     *   take action of your own. For example, returning false from this method and then showing a
     *   custom confirmation dialog - if the user cancels, do nothing, otherwise
     *   make a call to Calendar.removeEvent, passing the event.
     * 
     * 
     *  @param {CalendarEvent} event that was clicked on
     *  @param {string} view where the event was clicked on: "day", "week" or "month"
     */
    open fun eventRemoveClick(event: CalendarEvent, viewName: String): Boolean = definedExternally
    /**
     *   Called when an event is moved via dragging by a user. Return false to disallow the move.
     * 
     *  @param {Date} new start date and time that the event is being moved to
     *  @param {CalendarEvent} the event as it will be after this movement
     *  @param {string} the name of the lane into which the event was moved
     *  @deprecated \* in favor of Calendar.eventRepositionStop
     */
    open fun eventMoved(newDate: Date, event: CalendarEvent, newLane: String): Boolean = definedExternally
    /**
     *   Called when an event is resized with the mouse. The passed date value is the new
     *   \*end\* date for the event, since resizing can only be performed on the bottom edge of an event
     *   in normal calendar views.
     * 
     *  @param {Date} new end date and time that event is being resized to
     *  @param {CalendarEvent} the event as it will be after this resize
     *  @deprecated \* in favor of Calendar.eventResizeStop
     */
    open fun eventResized(newDate: Date, event: CalendarEvent): Boolean = definedExternally
    /**
     *   Called when a Timeline event is moved via dragging by a user. Return false to disallow the
     *   move.
     * 
     *  @param {CalendarEvent} the event that was moved
     *  @param {Date} new start date of the passed event
     *  @param {Date} new end date of the passed event
     *  @param {Lane} the Lane in which this event has been dropped
     *  @deprecated \* in favor of Calendar.eventRepositionStop
     */
    open fun timelineEventMoved(event: CalendarEvent, startDate: Date, endDate: Date, lane: Lane): Boolean = definedExternally
    /**
     *   Called when a Timeline event is resized via dragging by a user. Return false to disallow
     *   the resize.
     * 
     *  @param {CalendarEvent} the event that was resized
     *  @param {Date} new start date of the passed event, after the resize
     *  @param {Date} new end date of the passed event, after the resize
     *  @deprecated \* in favor of Calendar.eventResizeStop
     */
    open fun timelineEventResized(event: CalendarEvent, startDate: Date, endDate: Date): Boolean = definedExternally
    /**
     *   Selects the calendar view in the passed tab number.
     * 
     * 
     *  @param {number} the index of the tab to select
     */
    open fun selectTab(tabnum: Number): Unit = definedExternally
    /**
     *   Fires whenever the user changes the current date, including picking a specific date or
     *   navigating to a new week or month.
     * 
     */
    open fun dateChanged(): Unit = definedExternally
    /**
     *   Gets the day of the week (0-6) that the mouse is currently over.
     * 
     * 
     */
    open fun getActiveDay(): Number = definedExternally
    /**
     *   Gets a date object representing the date over which the mouse is hovering for the current
     *   selected view. For month view, the time will be set to midnight of the active day. For day
     *   and week views, the time will be the rounded to the closest half hour relative to the mouse
     *   position.
     * 
     */
    open fun getActiveTime(): Date = definedExternally
    /**
     *   Sets the range over which the timeline will display events.
     * 
     *   If the end parameter is not passed, the end date of the range will default to
     *   Calendar.defaultTimelineColumnSpan columns of the current
     *   Calendar.timelineGranularity following the start date.
     * 
     * 
     *  @param {Date} start of range
     *  @param {Date=} end of range
     */
    open fun setTimelineRange(start: Date, end: Date?): Unit = definedExternally
    /**
     *   Reset the resolution, the header levels and scrollable range, of the timeline view.
     * 
     *   headerLevels specifies the array of HeaderLevel to show above
     *   the timeline, and the unit and unitCount parameters dictate the
     *   scrollable range (eg, passing "week" and 6 will create a timeline with a scrollable range of
     *   six weeks, irrespective of the number of columns that requires, according to the
     *   Calendar.timelineGranularity).
     * 
     *   If the optional granularityPerColumn parameter is passed, each column will span
     *   that number of units of the granularity, which is determined from the unit of the innermost
     *   of the passed headerLevels. For example, to show a span of 12 hours with inner columns that
     *   each span 15 minutes, you could pass "hour" and "minute" -based headerLevels, unit and
     *   unitCount values of "hour" and 12 respectively, and granularityPerColumn of 15.
     * 
     * 
     *  @param {Array<Partial<HeaderLevel>>} the header levels to show in the timeline
     *  @param {TimeUnit} the time unit to use when calculating the range of the timeline
     *  @param {Integer} the count of the passed unit that the timeline should span
     *  @param {Integer=} how many units of the granularity (the unit of the      innermost headerLevel) should each column span? The default is 1.
     */
    open fun setResolution(headerLevels: Array<dynamic>, unit: 
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
                                                               String /* millisecond |  second |  minute |  hour |  day |  week |  month |  quarter |  year */, unitCount: Number, granularityPerColumn: Number?): Unit = definedExternally
    /**
     *   Returns the length of the passed CalendarEvent in the passed
     *   TimeUnit. If unit isn't passed, returns the length of the event
     *   in milliseconds.
     * 
     * 
     *  @param {CalendarEvent} the event to get the length of
     *  @param {TimeUnit=} the time unit to return the length in, milliseconds if not passed
     */
    open fun getEventLength(event: CalendarEvent, unit: 
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
                                                        String /* millisecond |  second |  minute |  hour |  day |  week |  month |  quarter |  year */?): Unit = definedExternally
    /**
     *   Notification called whenever the drop position of an event being drag-moved changes.
     * 
     *   The newEvent parameter represents the event as it will be after the move,
     *   including CalendarEvent.startDate and CalendarEvent.endDate dates
     *   and CalendarEvent.lane and CalendarEvent.sublane where
     *   applicable.
     * 
     *   Return false to prevent the default action, of positioning the drag canvas to the newEvent.
     * 
     * 
     *  @param {CalendarEvent} the event that's being moved
     *  @param {CalendarEvent} the event as it would be if dropped now
     */
    open fun eventRepositionMove(event: CalendarEvent, newEvent: CalendarEvent): Boolean = definedExternally
    /**
     *   Notification called when an event being drag-moved is dropped.
     * 
     *   The newEvent parameter represents the event as it will be after the move,
     *   including CalendarEvent.startDate and CalendarEvent.endDate dates
     *   and CalendarEvent.lane and CalendarEvent.sublane where
     *   applicable.
     * 
     *   Return false to prevent the default action, of actually
     *   Calendar.updateCalendarEvent the event.
     * 
     * 
     *  @param {CalendarEvent} the event that's about to be moved
     *  @param {CalendarEvent} the event as it will be, unless this method returns false
     *  @param {object=} additional custom values associated with the event
     */
    open fun eventRepositionStop(event: CalendarEvent, newEvent: CalendarEvent, customValues: dynamic?): Boolean = definedExternally
    /**
     *   Notification called on each resize during an event drag-resize operation.
     * 
     *   The newEvent parameter represents the event as it will be after the resize.
     * 
     *   Return false to prevent the default action, of resizing the drag canvas to the newEvent.
     * 
     * 
     *  @param {CalendarEvent} the event that's being drag-resized
     *  @param {CalendarEvent} the event as it would be if dropped now
     */
    open fun eventResizeMove(event: CalendarEvent, newEvent: CalendarEvent): Boolean = definedExternally
    /**
     *   Notification called when an event drag-resize operation completes.
     * 
     *   The newEvent parameter represents the event as it will be after the move.
     * 
     *   Return false to prevent the default action, of actually
     *   Calendar.updateCalendarEvent the event.
     * 
     * 
     *  @param {CalendarEvent} the event that's about to be resized
     *  @param {CalendarEvent} the event as it will be, unless this method returns false
     *  @param {object=} additional custom values associated with the event
     */
    open fun eventResizeStop(event: CalendarEvent, newEvent: CalendarEvent, customValues: dynamic?): Boolean = definedExternally
    /**
     *   Callback fired when the mouse is clicked in a background-cell, ie, one without an
     *   event.
     * 
     * 
     *  @param {Date} start datetime of the selected slot
     *  @param {Date} end datetime of the selected slot
     */
    open fun backgroundClick(startDate: Date, endDate: Date): Boolean = definedExternally
    /**
     *   Callback fired when the mouse button is depressed over a background-cell, ie, one
     *   without an event. Return false to cancel the default behavior of allowing sweep
     *   selection via dragging.
     * 
     * 
     *  @param {Date} start datetime of the selected slot
     */
    open fun backgroundMouseDown(startDate: Date): Boolean = definedExternally
    /**
     *   Notification method fired when the mouse button is released over a background-cell, ie,
     *   one without an event. Return false to cancel the default behavior of showing a dialog
     *   to add a new event with the passed dates.
     * 
     * 
     *  @param {Date} the datetime of the slot where the mouse button was depressed
     *  @param {Date} the datetime of the slot where the mouse button was released
     */
    open fun backgroundMouseUp(startDate: Date, endDate: Date): Boolean = definedExternally
    /**
     *   This method is invoked on the source component whenever a drag operation or
     *   DataBoundComponent.transferSelectedData completes. This method is called when the entire chain of
     *   operations - including, for databound components, server-side updates and subsequent
     *   integration of the changes into the client-side cache - has completed.
     *   There is no default implementation of this method; you are intended to override it if you
     *   are interested in being notified when drag operations complete.
     * 
     * 
     */
    override fun dragComplete(): Unit = definedExternally
    /**
     *   This method is invoked whenever a drop operation or DataBoundComponent.transferSelectedData
     *   targeting this component completes. A drop is considered to be complete when all the client-
     *   side transfer operations have finished. This includes any server turnarounds SmartClient
     *   needs to make to check for duplicate records in the target component; it specifically does
     *   not include any add or update operations sent to the server for databound components. If
     *   you want to be notified when the entire drag operation - including server updates and cache
     *   synchronization - has completed, override DataBoundComponent.dragComplete
     *   on the source component.
     *   There is no default implementation of this method; you are intended to override it if you
     *   are interested in being notified when drop operations complete.
     * 
     * 
     *  @param {Array<Partial<Record>>} The list of records actually transferred to          this component (note that this is not necessarily the same thing as the           list of records dragged out of the source component because it doesn't           include records that were excluded because of collisions with existing           records)
     */
    override fun dropComplete(transferredRecords: Array<dynamic>): Unit = definedExternally
    /**
     *   For a component with a specified DataSource, find the associated dataSource field object
     *   from a specified DataPath.
     * 
     *  @param {DataPath} dataPath for which the field definition should be returned.
     */
    override fun getDataPathField(dataPath: String): Unit = definedExternally
    /**
     *   Can the field be edited? This base method always returns false, but it's
     *   overridden by subclasses such as DynamicForm and ListGrid.
     * 
     * 
     *  @param {object | number | string} field object or identifier
     */
    override fun fieldIsEditable(field: dynamic): Boolean = definedExternally
    /**
     *   Return a field by a field index or field name.
     * 
     * 
     *  @param {FieldName | number} field index or field.name
     */
    override fun getField(fieldID: dynamic): dynamic = definedExternally
    /**
     *   Find the index of a currently visible field.
     * 
     * 
     *  @param {FieldName | string} field name or field
     */
    override fun getFieldNum(fieldName: String): Number = definedExternally
    /**
     *   This API is equivalent to List.find but searches for a matching record among already-loaded data only.
     *   Use ListGrid.fetchData to load data from the server.
     * 
     *  @param {AdvancedCriteria} AdvancedCriteria to use with
     */
    override fun find(advancedCriteria: AdvancedCriteria): dynamic = definedExternally
    /**
     *   This API is equivalent to List.findAll but searches for a matching record among already-loaded data only.
     *   Use ListGrid.fetchData to load data from the server.
     * 
     *  @param {AdvancedCriteria} AdvancedCriteria to use with
     */
    override fun findAll(advancedCriteria: AdvancedCriteria): Array<dynamic> = definedExternally
    /**
     *   This API is equivalent to List.findIndex but searches for a matching record among already-loaded data only.
     *   Use ListGrid.fetchData to load data from the server.
     * 
     *  @param {AdvancedCriteria} AdvancedCriteria to use with
     */
    override fun findIndex(advancedCriteria: AdvancedCriteria): Number = definedExternally
    /**
     *   This API is equivalent to List.findNextIndex but searches for a matching record among already-loaded data only.
     *   Use ListGrid.fetchData to load data from the server.
     * 
     *  @param {Integer} first index to consider
     *  @param {AdvancedCriteria} AdvancedCriteria to use with
     *  @param {Integer=} last index to consider
     */
    override fun findNextIndex(startIndex: Number, advancedCriteria: AdvancedCriteria, endIndex: Number?): Number = definedExternally
    /**
     *   Bind to a new DataSource.
     * 
     *   Like passing the "dataSource" property on creation, binding to a DataSource means that the
     *   component will use the DataSource to provide default data for its fields.
     * 
     *   When binding to a new DataSource, if the component has any existing "fields" or has a dataset,
     *   these will be discarded by default, since it is assumed the new DataSource may represent a
     *   completely unrelated set of objects. If the old "fields" are still relevant, pass them to
     *   setDataSource().
     * 
     * 
     *  @param {GlobalId | DataSource} DataSource to bind to
     *  @param {Array<Partial<DataSourceField>>=} optional array of fields to use
     */
    override fun setDataSource(dataSource: dynamic, fields: Array<dynamic>?): Unit = definedExternally
    /**
     *   Sends the current filter criteria and sort direction to the server, then exports data in the
     *   requested DSRequest.exportAs.
     * 
     *   A variety of DSRequest settings, such as
     *   DSRequest.exportAs and DSRequest.exportFilename, affect the
     *   exporting process: see DSRequest.exportResults for further detail.
     * 
     *   Note that data exported via this method does not include any client-side formatting and
     *   relies on both the SmartClient server and server-side DataSources. To export client-data
     *   with formatters applied,
     *   see ListGrid.exportClientData, which still requires the
     *   SmartClient server but does not rely on server-side DataSource definitions (.ds.xml files).
     * 
     *   For more information on exporting data, see DataSource.exportData.
     * 
     * 
     *  @param {DSRequest=} additional properties to set on the DSRequest                      that will be issued
     *  @param {DSCallback=} callback to invoke on completion. Note that this parameter                 only applies where DSRequest.exportToClient is                  explicitly set to false, because file downloads do not                  provide ordinary SmartClient callbacks
     */
    override fun exportData(requestProperties: DSRequest?, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?)): Unit = definedExternally
    /**
     *   Returns an array of Alignment for this grid
     * 
     */
    override fun getFieldAlignments(): Array<dynamic> = definedExternally
    /**
     *   Compares the specified criteria with the current criteria applied to this component's
     *   data object and determines whether the new criteria could be satisfied from the currently
     *   cached set of data, or if a new filter/fetch operation will be required.
     * 
     *   This is equivalent to calling this.data.willFetchData(...).
     *   Always returns true if this component is not showing a set of data from the dataSource.
     * 
     *   Note that to predict correctly the decision that will be made by filter/fetch, you'll need to
     *   pass the same TextMatchStyle that will be used by the future filter/fetch. Fetching
     *   manually (e.g. ListGrid.fetchData) will by default use "exact" while filtering
     *   (e.g. ListGrid.filterData) will by default use "substring". If the component
     *   is configured for autofetch (i.e. ListGrid.autoFetchData: true), that will
     *   use ListGrid.autoFetchTextMatchStyle, which defaults to "substring". If nothing/null
     *   is passed for the style, this method assumes you want the style from the last filter/fetch.
     * 
     *   To determine what TextMatchStyle is being used, check the RPC Tab of the
     *   debugging and check the relevant DSRequest.
     * 
     * 
     *  @param {Criteria} new criteria to test.
     *  @param {TextMatchStyle=} New text match style. If not passed assumes    textMatchStyle will not be modified.
     */
    override fun willFetchData(newCriteria: dynamic, textMatchStyle: 
                                                                     /**
                                                                      *  case-insensitive exact match ("foo" matches "foo" and "FoO", but not "FooBar")
                                                                      *  case-sensitive exact match ("foo" matches only "foo")
                                                                      *  case-insenstive substring match ("foo" matches "foobar" and "BarFoo")
                                                                      *  case-insensitive prefix match ("foo" matches "FooBar" but not "BarFoo")
                                                                      *   textMatchStyle behavior is consistent across the client and all three of the built-in
                                                                      *   server DataSource implementations - SQL, Hibernate and JPA - to the maximum extent that is
                                                                      *   practical. Known inconsistencies, some of which can be tweaked with configuration settings,
                                                                      *   are described below
                                                                      * 
                                                                      *  - textMatchStyle can be disabled for any individual field with the
                                                                      *   DataSourceField.ignoreTextMatchStyle declaration. This behavior is consistent
                                                                      *   across client and server implementations, with the proviso that case-sensitive behavior
                                                                      *   is inherently inconsistent in the server-side implementations (see below for a more
                                                                      *   detailed discussion of this)
                                                                      * 
                                                                      *  - textMatchStyle is forced to "exactCase" for DataSourceField.primaryKey
                                                                      *   fields on update and remove operations, unless
                                                                      *   OperationBinding.allowMultiUpdate is in force. This means that a normal update
                                                                      *   or remove operation - which is constrained by a unique primaryKey value or combination, to
                                                                      *   affect only a single data row - will use an equality match on all primaryKey fields. This
                                                                      *   is desirable because it makes index usage more likely. Note that this means the key values
                                                                      *   "foo" and "FOO" are distinct, which is a change from previous behavior. For most databases,
                                                                      *   this change will have no effect because most databases do not by default allow primaryKey
                                                                      *   values that only differ in case anyway - if a table has a row with a PK of "foo" and you
                                                                      *   try to insert a row with a PK of "FOO", most databases will fail with a constraint violation.
                                                                      *   However, if you are using a database hat allows key values that differ only in case, and you
                                                                      *   need to support this for some reason, you can switch the framework back to the previous
                                                                      *   behavior by setting property allow.case.sensitive.pks to true in
                                                                      *   your server.properties file. Note, we do not recommend this; in fact, we do
                                                                      *   not recommend the use of text primaryKey fields at all. Where you have control ,we would
                                                                      *   always recommend the use of automatically incrementing numeric sequence keys.
                                                                      * 
                                                                      *  - textMatchStyle does not apply to boolean or temporal (date, datetime, time)
                                                                      *   DataSourceField.type. Such fields are always checked for equality. If
                                                                      *   you have a need for more complex matching, such as date-range checking, use AdvancedCriteria
                                                                      * 
                                                                      *  - Critiera values for temporal fields must be real dates (Javascript Date
                                                                      *   objects on the client, instances of java.util.Date on the server). Attempting
                                                                      *   to match against a string or any other type of value will result in an "always fails"
                                                                      *   clause being generated. This behavior is how the client code has always worked, but is a
                                                                      *   change for the server-side DataSources, in the interests of consistency. The previous
                                                                      *   behavior was:
                                                                      * 
                                                                      *  - SQLDataSource used to attempt to match the date column to the criteria value provided;
                                                                      *    if that value was an appropriately-formatted string, that attempt might have
                                                                      *    worked, but it would be database-specific. If you have an application that depends on
                                                                      *    this old behavior, you can switch it back on by adding the following to your
                                                                      *    server.properties file:
                                                                      *    sql.temporal.fields.require.date.criteria: false
                                                                      * 
                                                                      *  - HibernateDataSource and JPADataSource used to skip such clauses altogether, which
                                                                      *    results in the opposite behavior (there is an implied "always succeeds" clause, because
                                                                      *    the clause is not present in the query at all). If you have an application that depends on
                                                                      *    this old behavior, you can switch it back on by adding the following to your
                                                                      *    server.properties file:
                                                                      *    jpa.temporal.fields.require.date.criteria: false or
                                                                      *    hibernate.temporal.fields.require.date.criteria: false, as appropriate
                                                                      * 
                                                                      * 
                                                                      *  - textMatchStyle does not apply to fields used in the joins generated to satisfy
                                                                      *   DataSourceField.includeFrom declarations or entity relations in
                                                                      *   Hibernate or JPA. Again, such comparisons are always for equality
                                                                      * 
                                                                      *  - textMatchStyle is applied to numeric fields only if the supplied criteria value
                                                                      *   is a string. So for a numeric field "myNumber", we will match 10, 100, 110 and 1000 if a
                                                                      *   criteria value of "10" (the quoted string) is supplied, but we will only match 10 if a
                                                                      *   criteria value of 10 (the actual number) is supplied
                                                                      * 
                                                                      *  - This is a change in behavior for the server-side DataSource implementations, in the
                                                                      *    interests of consistency with the client behavior. Previously, all three of the built-in
                                                                      *    DataSource implementations applied textMatchStyle to numeric fields regardless of the
                                                                      *    criteria value's type. If you have an application that depends on this old behavior,
                                                                      *    you can switch it back on by adding the following to your server.properties
                                                                      *    file: sql.substring.numeric.criteria: true or
                                                                      *    hibernate.substring.numeric.criteria: true or
                                                                      *    jpa.substring.numeric.criteria: true, as appropriate
                                                                      * 
                                                                      * 
                                                                      *  - "exactCase" matching cannot be made consistent across all database providers because
                                                                      *   each database has its own idea of whether case-sensitive matching should be the default,
                                                                      *   and how to switch it on and off (if that is even possible)
                                                                      * 
                                                                      *  - Microsoft SQL Server must have case-sensitive matching enabled by setting a
                                                                      *    case-sensitive collation when the database is created (there are more fine-grained
                                                                      *    options, but we do not recommend them because of the scope for further inconsistency,
                                                                      *    where "exactCase" works correctly on table A but not on table B). See
                                                                      *    MSDN for details
                                                                      * 
                                                                      *  - HSQLDB has case sensitivity set with the SET IGNORECASE directive -
                                                                      *    see here
                                                                      * 
                                                                      *  - MySQL is case-insensitive, but since it provides an easy way to do per-query,
                                                                      *    case-sensitive matching in SQL, we work around it for that database, but only in
                                                                      *    SQL DataSources
                                                                      * 
                                                                      * 
                                                                      *  - If you are using Hibernate or JPA, whether "exactCase" works as expected depends
                                                                      *   entirely on the underlying database. Unlike the SQL DataSource, where we have fine-grained
                                                                      *   control of the SQL that the database executes, we are constrained by what the ORM will
                                                                      *   allow. This prevents us from compensating for database quirks, like we do with MySQL's
                                                                      *   case-insensitivity in the SQL DataSource
                                                                      * 
                                                                      */
                                                                     String /* exact |  exactCase |  substring |  startsWith */?): Boolean = definedExternally
    /**
     *   Attempt to find the record in the resultSet that has a primary key value that matches the
     *   passed in parameter value. Only the locally cached data will be searched.
     *   Checks only loaded rows and will not trigger a fetch. Returns null if there is no match,
     *   data is not loaded, or there is no ResultSet.dataSource.
     * 
     *   Note, if you pass a simple value to this method, it will be matched against the first
     *   primaryKey field. For DataSources with a composite primary key (multiple primaryKey fields),
     *   pass
     *   a criteria object containing just your primaryKeys, like this:
     *   { firstPkField: "value", secondPkField: 25 }.
     * 
     * 
     * 
     *  @param {object} primary key value to search for
     */
    override fun findByKey(keyValue: dynamic): Record = definedExternally
    /**
     * 
     *   Select/deselect a Record passed in explicitly, or by index.
     * 
     * 
     *  @param {Record | number} record (or row number) to select
     *  @param {boolean=} new selection state (if null, defaults to true)
     */
    override fun selectRecord(record: dynamic, newState: Boolean?): Unit = definedExternally
    /**
     *   Select a single Record passed in explicitly, or by index, and deselect everything else.
     *   When programmatic selection of records is a requirement and
     *   ListGrid.selectionType is "single", use this method rather than
     *   DataBoundComponent.selectRecord to
     *   enforce mutually-exclusive record-selection.
     * 
     * 
     *  @param {Record | number} record (or row number) to select
     */
    override fun selectSingleRecord(record: dynamic): Unit = definedExternally
    /**
     * 
     *   Deselect a Record passed in explicitly, or by index.
     * 
     *   Synonym for selectRecord(record, false)
     * 
     * 
     *  @param {Record | number} record (or row number) to deselect
     */
    override fun deselectRecord(record: dynamic): Unit = definedExternally
    /**
     * 
     *   Select/deselect a list of Records passed in explicitly, or by index.
     * 
     *   Note that developers may wish to use DataBoundComponent.selectRange to select a single
     *   contiguous range.
     * 
     * 
     *  @param {Array<Partial<Record>> | number} records (or row numbers) to select
     *  @param {boolean=} new selection state (if null, defaults to true)
     */
    override fun selectRecords(records: dynamic, newState: Boolean?): Unit = definedExternally
    /**
     * 
     *   Deselect a list of Records passed in explicitly, or by index.
     * 
     *   Synonym for selectRecords(records, false)
     * 
     *   Note that developers may wish to use DataBoundComponent.deselectRange to select a single
     *   contiguous range.
     * 
     * 
     *  @param {Array<Partial<Record>> | number} records (or row numbers) to deselect
     */
    override fun deselectRecords(records: dynamic): Unit = definedExternally
    /**
     *   Select all records
     * 
     * 
     */
    override fun selectAllRecords(): Unit = definedExternally
    /**
     * 
     *   Deselect all records
     * 
     * 
     */
    override fun deselectAllRecords(): Unit = definedExternally
    /**
     *   Select a contiguous range of records by index
     * 
     *  @param {Integer} start of selection range
     *  @param {Integer} end of selection range (non-inclusive)
     *  @param {boolean=} new selection state (if null, defaults to true)
     */
    override fun selectRange(startRow: Number, endRow: Number, newState: Boolean?): Unit = definedExternally
    /**
     *   Deselect a contiguous range of records by index.
     * 
     *   This is a synonym for selectRange(startRow, endRow, false);
     * 
     *  @param {Integer} start of selection range
     *  @param {Integer} end of selection range (non-inclusive)
     */
    override fun deselectRange(startRow: Number, endRow: Number): Unit = definedExternally
    /**
     *   Whether at least one item is selected
     * 
     */
    override fun anySelected(): Boolean = definedExternally
    /**
     *   Returns the number of selected records.
     * 
     * 
     */
    override fun getSelectionLength(): Number = definedExternally
    /**
     *   Return the set of hilite-objects currently applied to this DataBoundComponent. These
     *   can be serialized for storage and then restored to a component later via
     *   DataBoundComponent.setHilites.
     * 
     * 
     */
    override fun getHilites(): Array<dynamic> = definedExternally
    /**
     *   Accepts an array of hilite objects and applies them to this DataBoundComponent. See also
     *   DataBoundComponent.getHilites for a method of retrieving the hilite
     *   array for storage, including hilites manually added by the user.
     * 
     * 
     *  @param {Array<Partial<Hilite>>} Array of hilite objects
     */
    override fun setHilites(hilites: Array<dynamic>): Unit = definedExternally
    /**
     *   Get the current hilites encoded as a String, for saving.
     * 
     * 
     */
    override fun getHiliteState(): String = definedExternally
    /**
     *   Set the current hilites based on a hiliteState String previously returned from
     *   DataBoundComponent.getHiliteState.
     * 
     *  @param {string} hilites state encoded as a String
     */
    override fun setHiliteState(hiliteState: String): Unit = definedExternally
    /**
     *   Enable / disable a DataBoundComponent.hilites
     * 
     * 
     *  @param {string} ID of hilite to enable
     *  @param {boolean=} new enabled state to apply - if null, defaults to true
     */
    override fun enableHilite(hiliteID: String, enable: Boolean?): Unit = definedExternally
    /**
     *   Disable a hilite
     * 
     * 
     *  @param {string} ID of hilite to disable
     */
    override fun disableHilite(hiliteID: String): Unit = definedExternally
    /**
     *   Enable all hilites.
     * 
     * 
     *  @param {boolean=} new enabled state to apply - if null, defaults to true
     */
    override fun enableHiliting(enable: Boolean?): Unit = definedExternally
    /**
     *   Disable all hilites.
     * 
     * 
     */
    override fun disableHiliting(): Unit = definedExternally
    /**
     *   Shows a HiliteEditor interface allowing end-users to edit
     *   the data-hilites currently in use by this DataBoundComponent.
     * 
     * 
     */
    override fun editHilites(): Unit = definedExternally
    /**
     * 
     *   Transfer a list of Records from another component (does not have to be a databound
     *   component) into this component. This method is only applicable to list-type components,
     *   such as ListGrid, TreeGrid or TileGrid
     * 
     *   This method implements the automatic drag-copy and drag-move behaviors of components like
     *   ListGrid, and calling it is equivalent to completing a drag and drop of the
     *   dropRecords.
     * 
     *   Note that this method is asynchronous - it may need to perform server turnarounds to prevent
     *   duplicates in the target component's data. If you wish to be notified when the transfer
     *   process has completed, you can either pass the optional callback to this method or implement
     *   the DataBoundComponent.dropComplete method on this component.
     * 
     *   See also DataBoundComponent.transferSelectedData.
     * 
     * 
     *  @param {Array<Partial<Record>>} Records to transfer to this component
     *  @param {Record} The target record (eg, of a drop interaction), for context
     *  @param {Integer} Insert point in this component's data for the transferred records
     *  @param {Canvas} The databound or non-databound component from which the records              are to be transferred.
     *  @param {Callback=} optional callback to be fired when the transfer process has completed
     */
    override fun transferRecords(dropRecords: Array<dynamic>, targetRecord: Record, index: Number, sourceWidget: Canvas, callback: dynamic?): Unit = definedExternally
    /**
     *   Returns the "drop values" to apply to a record dropped on this component prior to update. Only
     *   applicable to databound components - see DataBoundComponent.dropValues for more details. If multiple records
     *   are being dropped, this method is called for each of them in turn.
     * 
     *   The default implementation of this method returns the following:
     * 
     * 
     *  - Nothing, if DataBoundComponent.addDropValues is false
     * 
     *  - dropValues, if that property is set. If the component's criteria object is applicable (as explained
     *   in the next item), it is merged into dropValues, with properties in dropValues taking precedence.
     * 
     *  - The component's criteria object, if the most recent textMatchStyle for the component was "exact"
     *     and it is simple criteria (ie, not an AdvancedCriteria object)
     * 
     *  - Otherwise nothing
     * 
     * 
     *   You can override this method if you need more complex setting of drop values than can be
     *   provided by simply supplying a dropValues object.
     * 
     * 
     *  @param {Record} record being dropped
     *  @param {DataSource} dataSource the record being dropped is bound to
     *  @param {Record} record being dropped on
     *  @param {Integer} index of record being dropped on
     *  @param {Canvas} widget where dragging began
     */
    override fun getDropValues(record: Record, sourceDS: DataSource, targetRecord: Record, index: Number, sourceWidget: Canvas): dynamic = definedExternally
    /**
     * 
     *   During a drag-and-drop interaction, this method is called to transfer a set of records that
     *   were dropped onto some other component. This method is called after the set of records has
     *   been copied to the other component. Whether or not this component's data is modified is
     *   determined by the value of DataBoundComponent.dragDataAction.
     * 
     *   With a dragDataAction of "move", a databound component will issue "remove"
     *   dsRequests against its DataSource to actually remove the data, via
     *   DataSource.removeData.
     * 
     * 
     */
    override fun transferDragData(): Array<dynamic> = definedExternally
    /**
     * 
     *   During a drag-and-drop interaction, this method returns the set of records being dragged out
     *   of the component. In the default implementation, this is the list of currently selected
     *   records.
     * 
     *   This method is consulted by ListGrid.willAcceptDrop.
     * 
     * 
     *  @param {DataBoundComponent} source component from which the records will be transferred
     */
    override fun getDragData(source: DataBoundComponent): Array<dynamic> = definedExternally
    /**
     *   Simulates a drag / drop type transfer of the selected records in some other component to this
     *   component, without requiring any user interaction. This method acts on the dropped records
     *   exactly as if they had been dropped in an actual drag / drop interaction, including any
     *   special databound behavior invoked by calling
     *   DataBoundComponent.getDropValues for each dropped record.
     * 
     *   To transfer all data in, for example, a ListGrid, call
     *   ListGrid.selectAllRecords first.
     * 
     *   Note that drag/drop type transfers of records between components are asynchronous operations:
     *   SmartClient may need to perform server turnarounds to establish whether dropped records
     *   already exist in the target component. Therefore, it is possible to issue a call to
     *   transferSelectedData() and/or the drop() method of a databound
     *   component whilst a transfer is still active. When this happens, SmartClient adds the
     *   second and subsequent transfer requests to a queue and runs them one after the other. If
     *   you want to be notified when a transfer process has actually completed, either provide a
     *   callback to this method or implement DataBoundComponent.dropComplete.
     * 
     *   See the dragging documentation for an overview of list grid drag/drop data
     *   transfer.
     * 
     * 
     *  @param {DataBoundComponent} source component from which the records will be transferred
     *  @param {Integer=} target index (drop position) of the rows within this grid.
     *  @param {Callback=} optional callback to be fired when the transfer process has            completed. The callback will be passed a single parameter "records",            the list of records actually transferred to this component.
     */
    override fun transferSelectedData(source: DataBoundComponent, index: Number?, callback: dynamic?): Unit = definedExternally
    /**
     *   Sets the custom tracker HTML to display next to the mouse when the user initiates a drag
     *   operation on this component. Default implementation will examine ListGrid.dragTrackerMode
     *   and set the custom drag tracker to display the appropriate HTML based on the selected record.
     * 
     *   To display custom drag tracker HTML, this method may be overridden - call
     *   EventHandler.setDragTracker to actually update the drag tracker HTML.
     * 
     */
    override fun setDragTracker(): Boolean = definedExternally
    /**
     *   Convenience method to display a FormulaBuilder to create a new Formula Field. This
     *   is equivalent to calling DataBoundComponent.editFormulaField with
     *   no parameter.
     * 
     * 
     */
    override fun addFormulaField(): Unit = definedExternally
    /**
     *   Method to display a FormulaBuilder to edit a formula Field. If the function is called
     *   without a parameter, a new field will be created when the formula is saved.
     * 
     * 
     *  @param {string} Field to edit or null to add a new formula field
     */
    override fun editFormulaField(field: String): Unit = definedExternally
    /**
     *   Get the computed value of a DataBoundComponent.canAddFormulaFields.
     * 
     *  @param {string} field that has a formula
     *  @param {Record} record to use to compute formula value
     */
    override fun getFormulaFieldValue(field: ListGridField, record: Record): dynamic = definedExternally
    /**
     *   Convenience method to display a SummaryBuilder to create a new Summary Field. This
     *   is equivalent to calling DataBoundComponent.editSummaryField with
     *   no parameter.
     * 
     * 
     */
    override fun addSummaryField(): Unit = definedExternally
    /**
     *   Method to display a SummaryBuilder to edit a Summary Field. If the function is called
     *   without a parameter, a new field will be created when the summary is saved.
     * 
     * 
     *  @param {string} Field to edit or null to add a new summary column
     */
    override fun editSummaryField(field: String): Unit = definedExternally
    /**
     *   Get the computed value of a DataBoundComponent.canAddSummaryFields.
     * 
     *  @param {string} field that has a summary format
     *  @param {Record} record to use to compute formula value
     */
    override fun getSummaryFieldValue(field: ListGridField, record: Record): String = definedExternally
    /**
     *   When assembling a value for a DataBoundComponent.canAddSummaryFields, if a referenced
     *   field is hilited, should the hilite HTML be included in the summary field value?
     * 
     *   Example use case: Consider a grid containing a numeric field, and a summary field
     *   which contains some string value, plus the contents of the numeric field.
     *   If a hilite is defined for the grid which turns the numeric field text red when
     *   the value is negative, this property will govern whether the number will also be
     *   rendered in red within the summary field cells. Any other text in the summary field
     *   cells would not be effected by this hilite.
     * 
     *   Default implementation returns DataBoundComponent.includeHilitesInSummaryFields.
     * 
     *   To control hilites showing in group summaries, see ListGrid.showHilitesInGroupSummary.
     * 
     * 
     *  @param {string} name of the summary field
     *  @param {string} name of the field referenced by this summary
     */
    override fun shouldIncludeHiliteInSummaryField(summaryFieldName: String, usedFieldName: String): Boolean = definedExternally
    /**
     *   Get the index of the provided record.
     * 
     *   Override in subclasses to provide more specific behavior, for instance, when data holds a
     *   large number of records
     * 
     * 
     *  @param {Record} the record whose index is to be retrieved
     */
    override fun getRecordIndex(record: Record): Number = definedExternally
    /**
     *   Get the value of the titleField for the passed record
     * 
     *   Override in subclasses
     * 
     * 
     *  @param {Record} the record whose index is to be retrieved
     */
    override fun getTitleFieldValue(record: Record): String = definedExternally
    /**
     *   Method to return the fieldName which represents the "title" for records in this
     *   Component.
     *   If this.titleField is explicitly specified it will always be used.
     *   Otherwise, default implementation will check DataSource.titleField for databound
     *   compounds.
     *   For non databound components returns the first defined field name of "title",
     *   "name", or "id" where the field is visible. If we don't find any
     *   field-names that match these titles, the first field in the component will be used instead.
     * 
     */
    override fun getTitleField(): String = definedExternally
    /**
     *   Return all CSS style declarations associated with the hilites of a record's field.
     * 
     *  @param {Record} \* @param {string} if set, returned CSS will be appended to this text
     *  @param {string} field object identifying whose CSS is to be returned
     */
    override fun getRecordHiliteCSSText(record: Record, cssText: String, field: String): String = definedExternally
    /**
     *   Return the SortSpecifiers representing the current sort configuration of this
     *   component.
     * 
     */
    override fun getSort(): Array<dynamic> = definedExternally
    /**
     *   Sort this component by a list of SortSpecifiers. If the component's data is not a
     *   ResultSet, only the first specifier is applied.
     * 
     * 
     *  @param {Array<Partial<SortSpecifier>>} List of SortSpecifier objects, one  per sort-field and direction
     */
    override fun setSort(sortSpecifiers: Array<dynamic>): Unit = definedExternally
    /**
     *   Show a dialog to configure the sorting of multiple fields on this component. Calls through
     *   to MultiSortDialog.askForSort, passing this component as the fieldSource and the
     *   current DataBoundComponent.getSort if there is one.
     * 
     *   The generated multiSortDialog can be customized via DataBoundComponent.multiSortDialogDefaults,
     *   DataBoundComponent.multiSortDialogProperties.
     * 
     * 
     */
    override fun askForSort(): Unit = definedExternally
    /**
     *   Returns true if the component's current data model is marked as offline. This does not
     *   necessarily mean that the component has no data; it may have data that was supplied from
     *   the Offline.
     * 
     */
    override fun isOffline(): Boolean = definedExternally
    /**
     *   Shows a FieldPicker interface allowing end-users to edit
     *   the fields currently shown by this DataBoundComponent.
     * 
     * 
     */
    override fun editFields(): Unit = definedExternally
    /**
     *   Notification method fired when a user-generated field is added to this component via
     *   DataBoundComponent.editFormulaField or DataBoundComponent.editSummaryField.
     * 
     *   Returning false from this method will prevent the field being added at all. Note that
     *   this also provides an opportunity to modify the generated field object - any changes
     *   made to the field parameter will show up when the field is displayed in the ListGrid.
     * 
     * 
     *  @param {ListGridField} User generated summary or formula field
     */
    override fun userAddedField(field: ListGridField): Boolean = definedExternally
    /**
     *   Called when the selection changes. Note that this method fires exactly once for any given
     *   change to the selection unlike the ListGrid.selectionChanged event.
     * 
     *   This event is fired once after selection/deselection has completed. The result is
     *   one event per mouse-down event. For a drag selection there will be two events fired:
     *   one when the first record is selected and one when the range is completed.
     * 
     *   This event is also fired when selection is updated by a direct call to one of the
     *   DataBoundComponent select/deselect methods. Calls on the Selection
     *   object do not trigger this event.
     * 
     * 
     *  @param {object} first selected record in the selection, if any, which may or may not be the first record in sort order if the DataBoundComponent is sorted. This parameter is typically used when only one record can be selected at a time.
     *  @param {Array<Partial<object>>} List of records that are now selected
     */
    override fun selectionUpdated(record: dynamic, recordList: Array<dynamic>): Unit = definedExternally
    companion object {
        /**
         *  Creates a new Calendar
         * 
         *  @param typeCheckedProperties {Partial<Calendar>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Calendar} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Calendar = definedExternally
        /**
         *   Returns whether there are any pending DSRequests initiated by this
         *   DataBoundComponent. May not include any requests sent by directly calling the
         *   DataSource APIs (rather than the DataBoundComponent APIs).
         * 
         * 
         */
        fun requestsArePending(): Boolean = definedExternally
    }
}