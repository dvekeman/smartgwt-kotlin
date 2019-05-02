@file:JsQualifier("isc")
package isc

/**
 *  Simple interactive calendar interface used to pick a date.
 *   Used by the DateItem class.
 */
open external class DateChooser : VLayout {
    /**
     *  An AutoChild HLayout, rendered above the DateGrid,
     *   and showing a number of widgets for navigating the DateChooser. These include buttons
     *   for moving to the previous DateChooser.previousYearButton or
     *   DateChooser.previousMonthButton, the next
     *   DateChooser.nextYearButton or DateChooser.nextMonthButton,
     *   and for selecting a specific DateChooser.yearChooserButton,
     *   DateChooser.monthChooserButton or
     *   DateChooser.weekChooserButton.
     *  @type {HLayout}
     *  @default null
     */
    open var navigationLayout: HLayout = definedExternally
    /**
     *  When editing a "date" value, with no time portion, clicking on a date-cell selects the
     *   date and closes the DateChooser. When a DateChooser.showTimeItem
     *   is required, however, the DateChooser.applyButton must be clicked
     *   to close the chooser, by default.
     * 
     *   Set this attribute to true to have the DateChooser close when a user clicks in a
     *   date-cell, even if the DateChooser.timeItem is showing.
     *  @type {boolean}
     *  @default null
     */
    open var closeOnDateClick: Boolean = definedExternally
    /**
     *  When set to true, show a button that allows the calendar to be navigated by fiscal year.
     *  @type {boolean}
     *  @default false
     */
    open var showFiscalYearChooser: Boolean = definedExternally
    /**
     *  A button shown in the DateChooser.navigationLayout which,
     *   when clicked, shows a picker for selecting a specific fiscal year.
     *  @type {IButton}
     *  @default null
     */
    open var fiscalYearChooserButton: IButton = definedExternally
    /**
     *  When set to true, show a button that allows the calendar to be navigated by week or
     *   fiscal week, depending on the value of DateChooser.showFiscalYearChooser.
     *  @type {boolean}
     *  @default false
     */
    open var showWeekChooser: Boolean = definedExternally
    /**
     *  A button shown in the DateChooser.navigationLayout which shows
     *   a picker for selecting a specific week of the year. When DateChooser.showFiscalYearChooser
     *   is true, the week number represents a fiscal week number, one offset from the start of
     *   the fiscal year. Otherwise, it represents a week number offset from the start of the
     *   calendar year.
     *  @type {IButton}
     *  @default null
     */
    open var weekChooserButton: IButton = definedExternally
    /**
     *  A button shown in the DateChooser.navigationLayout that shifts
     *   the calendar view backward by a year.
     *  @type {IButton}
     *  @default null
     */
    open var previousYearButton: IButton = definedExternally
    /**
     *  A button shown in the DateChooser.navigationLayout that shifts
     *   the calendar view backward by a month.
     *  @type {IButton}
     *  @default null
     */
    open var previousMonthButton: IButton = definedExternally
    /**
     *  A button shown in the DateChooser.navigationLayout that shows
     *   a picker for selecting a specific month.
     *  @type {IButton}
     *  @default null
     */
    open var monthChooserButton: IButton = definedExternally
    /**
     *  A button shown in the DateChooser.navigationLayout that shows
     *   a picker for selecting a specific calendar year.
     *  @type {IButton}
     *  @default null
     */
    open var yearChooserButton: IButton = definedExternally
    /**
     *  A button shown in the DateChooser.navigationLayout that shifts
     *   the calendar view forward by a month.
     *  @type {IButton}
     *  @default null
     */
    open var nextMonthButton: IButton = definedExternally
    /**
     *  A button shown in the DateChooser.navigationLayout that shifts
     *   the calendar view forward by a year.
     *  @type {IButton}
     *  @default null
     */
    open var nextYearButton: IButton = definedExternally
    /**
     *  An AutoChild HLayout, rendered below the DateGrid,
     *   and showing the DateChooser.todayButton,
     *   DateChooser.cancelButton and, when working with "datetime" values,
     *   DateChooser.applyButton buttons.
     *  @type {HLayout}
     *  @default null
     */
    open var buttonLayout: HLayout = definedExternally
    /**
     *  A ListGrid subclass, responsible for rendering the calendar view.
     *  @type {DateGrid}
     *  @default null
     */
    open var dateGrid: DateGrid = definedExternally
    /**
     *  A button shown below the DateGrid which, when clicked,
     *   navigates the calendar to today.
     *  @type {IButton}
     *  @default null
     */
    open var todayButton: IButton = definedExternally
    /**
     *  A button shown below the DateGrid which, when clicked,
     *   closes the DateChooser without selecting a value.
     *  @type {IButton}
     *  @default null
     */
    open var cancelButton: IButton = definedExternally
    /**
     *  When a DateChooser is configured for DateChooser.timeItem,
     *   clicking on a date cell in the DateChooser.dateGrid will not automatically
     *   dismiss the DateChooser canvas. In this case, use the Apply button to
     *   accept the selected date and time and dismiss the chooser.
     *  @type {IButton}
     *  @default null
     */
    open var applyButton: IButton = definedExternally
    /**
     *  Height of the header area (containing the navigation buttons) in pixels.
     *  @deprecated \* in favor of DateChooser.navigationLayoutHeight
     *  @type {Integer}
     *  @default "20"
     */
    open var headerHeight: Number = definedExternally
    /**
     *  Height of the DateChooser.navigationLayout, containing the
     *   various buttons for navigating the DateChooser.dateGrid.
     *  @deprecated \* in favor of DateChooser.navigationLayoutHeight
     *  @type {Integer}
     *  @default "20"
     */
    open var navigationLayoutHeight: Number = definedExternally
    /**
     *  Overridden directory where images for this widget (such as the month and year button icons)
     *   may be found.
     *  @type {SCImgURL}
     *  @default "images/common/"
     */
    override var skinImgDir: String = definedExternally
    /**
     *  Icon for the previous year button
     *  @type {URL}
     *  @default "[SKIN]doubleArrow_left.gif"
     */
    open var prevYearIcon: String = definedExternally
    /**
     *  Icon for the previous year button if Page.isRTL is true.
     *   If not set, and the page is in RTL mode, the DateChooser.nextYearIcon will be
     *   used in place of the DateChooser.prevYearIcon and vice versa.
     *  @type {URL}
     *  @default null
     */
    open var prevYearIconRTL: String = definedExternally
    /**
     *  Width of the icon for the previous year button
     *  @type {Integer}
     *  @default "14"
     */
    open var prevYearIconWidth: Number = definedExternally
    /**
     *  Height of the icon for the previous year button
     *  @type {Integer}
     *  @default "7"
     */
    open var prevYearIconHeight: Number = definedExternally
    /**
     *  Icon for the previous month button
     *  @type {URL}
     *  @default "[SKIN]arrow_left.gif"
     */
    open var prevMonthIcon: String = definedExternally
    /**
     *  Icon for the previous month button if Page.isRTL is true.
     *   If not set, and the page is in RTL mode, the DateChooser.nextMonthIcon will be
     *   used in place of the DateChooser.prevMonthIcon and vice versa.
     *  @type {URL}
     *  @default null
     */
    open var prevMonthIconRTL: String = definedExternally
    /**
     *  Width of the icon for the previous month button
     *  @type {Integer}
     *  @default "7"
     */
    open var prevMonthIconWidth: Number = definedExternally
    /**
     *  Height of the icon for the previous month button
     *  @type {Integer}
     *  @default "7"
     */
    open var prevMonthIconHeight: Number = definedExternally
    /**
     *  Icon for the next year button
     *  @type {URL}
     *  @default "[SKIN]doubleArrow_right.gif"
     */
    open var nextYearIcon: String = definedExternally
    /**
     *  Icon for the next year button if Page.isRTL is true.
     *   If not set, and the page is in RTL mode, the DateChooser.nextYearIcon will be
     *   used in place of the DateChooser.prevYearIcon and vice versa.
     *  @type {URL}
     *  @default null
     */
    open var nextYearIconRTL: String = definedExternally
    /**
     *  Width of the icon for the next year button
     *  @type {Integer}
     *  @default "14"
     */
    open var nextYearIconWidth: Number = definedExternally
    /**
     *  Height of the icon for the next year button
     *  @type {Integer}
     *  @default "7"
     */
    open var nextYearIconHeight: Number = definedExternally
    /**
     *  Icon for the next month button
     *  @type {URL}
     *  @default "[SKIN]arrow_right.gif"
     */
    open var nextMonthIcon: String = definedExternally
    /**
     *  Icon for the next month button
     *  @type {URL}
     *  @default null
     */
    open var nextMonthIconRTL: String = definedExternally
    /**
     *  Width of the icon for the next month button if Page.isRTL is true.
     *   If not set, and the page is in RTL mode, the DateChooser.nextMonthIcon will be
     *   used in place of the DateChooser.prevMonthIcon and vice versa.
     *  @type {Integer}
     *  @default "7"
     */
    open var nextMonthIconWidth: Number = definedExternally
    /**
     *  Height of the icon for the next month button
     *  @type {Integer}
     *  @default "7"
     */
    open var nextMonthIconHeight: Number = definedExternally
    /**
     *  If this property is set to true the previous and next year buttons will render out the
     *   previous and next month button icons twice rather than using the
     *   DateChooser.prevYearIcon and DateChooser.nextYearIcon.
     * 
     *   Set to true by default as not all skins contain media for the year icons.
     *  @type {boolean}
     *  @default true
     */
    open var showDoubleYearIcon: Boolean = definedExternally
    /**
     *  Style for the pop-up year menu.
     *  @type {CSSStyleName}
     *  @default "dateChooserYearMenu"
     */
    open var yearMenuStyle: String = definedExternally
    /**
     *  Earliest year that may be selected.
     *  @type {Integer}
     *  @default "1995"
     */
    open var startYear: Number = definedExternally
    /**
     *  Last year that may be selected.
     *  @type {Integer}
     *  @default "2020"
     */
    open var endYear: Number = definedExternally
    /**
     *  Style for the pop-up year menu.
     *  @type {CSSStyleName}
     *  @default "dateChooserMonthMenu"
     */
    open var monthMenuStyle: String = definedExternally
    /**
     *  Style for the pop-up week menu.
     *  @type {CSSStyleName}
     *  @default "dateChooserWeekMenu"
     */
    open var weekMenuStyle: String = definedExternally
    /**
     *  Array of members to show in the DateChooser.buttonLayout.
     * 
     *   The default value of buttonLayoutControls is an Array of Strings listing
     *   the standard buttons in their default order:
     * 
     *    buttonLayoutControls : ["todayButton", "cancelButton", "applyButton"]
     * 
     *   You can override buttonLayoutControls to change the order of the standard
     *   buttons. You can also omit standard buttons this way, although it's more efficient to
     *   use the related "show" property if available (eg DateChooser.showTodayButton).
     * 
     *   By embedding a Canvas directly in this list you can add arbitrary additional controls to
     *   the buttonLayout.
     * 
     *   Note that having added controls to buttonLayoutControls, you can still call APIs directly on
     *   those controls to change their appearance, and you can also show() and hide() them if
     *   they should not be shown in some circumstances.
     * 
     *   Tip: custom controls need to set layoutAlign:"center" to appear vertically centered.
     *  @type {Array<Partial<string>>}
     *  @default "(see below)"
     */
    open var buttonLayoutControls: Array<dynamic> = definedExternally
    /**
     *  Determines whether the "Today" button will be displayed, allowing the user to select
     *   the current date.
     *  @type {boolean}
     *  @default true
     */
    open var showTodayButton: Boolean = definedExternally
    /**
     *  Determines whether the "Cancel" button will be displayed.
     *  @type {boolean}
     *  @default false
     */
    open var showCancelButton: Boolean = definedExternally
    /**
     *  Determines whether the DateChooser.applyButton will be displayed.
     *  @type {boolean}
     *  @default null
     */
    open var showApplyButton: Boolean = definedExternally
    /**
     *  Title for "Today" button.
     *  @type {string}
     *  @default "Today"
     */
    open var todayButtonTitle: String = definedExternally
    /**
     *  Title for the cancellation button.
     *  @type {string}
     *  @default "Cancel"
     */
    open var cancelButtonTitle: String = definedExternally
    /**
     *  Title for the DateChooser.applyButton button.
     *  @type {string}
     *  @default "Apply"
     */
    open var applyButtonTitle: String = definedExternally
    /**
     *  If set specifies a fixed height for the Today and Cancel buttons.
     *  @type {Integer}
     *  @default null
     */
    open var todayButtonHeight: Number = definedExternally
    /**
     *  Whether it should be valid to pick a weekend day. If set to true, weekend days appear
     *   in disabled style and cannot be picked.
     * 
     *   Which days are considered weekends is controlled by DateChooser.weekendDays if
     *   set or by DateUtil.weekendDays otherwise.
     *  @type {boolean}
     *  @default false
     */
    open var disableWeekends: Boolean = definedExternally
    /**
     *  Whether weekend days should be shown. Which days are considered weekends is controlled
     *   by DateChooser.weekendDays if set or by DateUtil.weekendDays otherwise.
     *  @type {boolean}
     *  @default true
     */
    open var showWeekends: Boolean = definedExternally
    /**
     *  An array of integer day-numbers that should be considered to be weekend days by this
     *   DateChooser instance. If unset, defaults to the set of days indicated
     *   DateUtil.weekendDays.
     *  @type {Array<Partial<Integer>>}
     *  @default null
     */
    open var weekendDays: Array<dynamic> = definedExternally
    /**
     *  Day of the week to show in the first column. 0=Sunday, 1=Monday, ..., 6=Saturday. The
     *   default value for this attribute is picked up from the current locale and can also be
     *   altered system-wide with the DateUtil.setFirstDayOfWeek.
     *  @type {Integer}
     *  @default "0"
     */
    open var firstDayOfWeek: Number = definedExternally
    /**
     *  Base CSS style applied to this picker's buttons. Will have "Over", "Selected" and "Down"
     *   suffix appended as the user interacts with buttons.
     * 
     *   See cellStyleSuffixes for details on how stateful suffixes are combined with the
     *   base style to generate stateful cell styles in Grids.
     *  @type {CSSStyleName}
     *  @default "dateChooserButton"
     */
    open var baseButtonStyle: String = definedExternally
    /**
     *  Base CSS style applied to weekdays. Will have "Over", "Selected" and "Down"
     *   suffix appended as the user interacts with buttons. Defaults to DateChooser.baseButtonStyle.
     * 
     *   See cellStyleSuffixes for details on how stateful suffixes are combined with the
     *   base style to generate stateful cell styles in Grids.
     *  @type {CSSStyleName}
     *  @default "dateChooserWeekday"
     */
    open var baseWeekdayStyle: String = definedExternally
    /**
     *  Base CSS style applied to weekends. Will have "Over", "Selected" and "Down"
     *   suffix appended as the user interacts with buttons. Defaults to DateChooser.baseWeekdayStyle.
     * 
     *   See cellStyleSuffixes for details on how stateful suffixes are combined with the
     *   base style to generate stateful cell styles in Grids.
     *  @type {CSSStyleName}
     *  @default "dateChooserWeekend"
     */
    open var baseWeekendStyle: String = definedExternally
    /**
     *  Base CSS style applied to cells in the DateChooser.showFiscalYearChooser.
     * 
     *   See cellStyleSuffixes for details on how stateful suffixes are combined with the
     *   base style to generate stateful cell styles in Grids.
     *  @type {CSSStyleName}
     *  @default "dateChooserFiscalYearCell"
     */
    open var baseFiscalYearStyle: String = definedExternally
    /**
     *  Base CSS style applied to the header of the
     *   DateChooser.showFiscalYearChooser in the
     *   DateChooser.dateGrid.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var fiscalYearHeaderStyle: String = definedExternally
    /**
     *  Base CSS style applied to cells in the DateChooser.showWeekChooser.
     *  @type {CSSStyleName}
     *  @default "dateChooserWeekCell"
     */
    open var baseWeekStyle: String = definedExternally
    /**
     *  Base CSS style applied to the header of the
     *   DateChooser.showWeekChooser in the
     *   DateChooser.dateGrid.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var weekHeaderStyle: String = definedExternally
    /**
     *  An array of Date instances that should be disabled if they appear in the calendar view.
     *  @type {Array<Partial<Date>>}
     *  @default null
     */
    open var disabledDates: Array<dynamic> = definedExternally
    /**
     *  Base CSS style applied to weekday dates which have been DateChooser.disabledDates.
     *  @type {CSSStyleName}
     *  @default "dateChooserDisabledWeekday"
     */
    open var disabledWeekdayStyle: String = definedExternally
    /**
     *  Base CSS style applied to weekend dates which have been DateChooser.disabledDates.
     *  @type {CSSStyleName}
     *  @default "dateChooserDisabledWeekend"
     */
    open var disabledWeekendStyle: String = definedExternally
    /**
     *  CSS style applied to the Fiscal Year and Week columns for the currently selected week
     *   (the one being displayed in the DateChooser.showWeekChooser).
     *  @type {CSSStyleName}
     *  @default "dateChooserSelectedWeek"
     */
    open var selectedWeekStyle: String = definedExternally
    /**
     *  Whether alternating weeks should be drawn in alternating styles. If enabled, the cell style
     *   for alternate rows will have DateChooser.alternateStyleSuffix appended to it.
     *  @type {boolean}
     *  @default null
     */
    open var alternateWeekStyles: Boolean = definedExternally
    /**
     *  The text appended to the style name when using DateChooser.alternateWeekStyles.
     *  @type {string}
     *  @default "Dark"
     */
    open var alternateStyleSuffix: String = definedExternally
    /**
     *  CSS style applied to the day-of-week headers. By default this applies to all days of the
     *   week. To apply a separate style to weekend headers, set
     *   DateChooser.weekendHeaderStyle
     *  @type {CSSStyleName}
     *  @default "dateChooserButtonDisabled"
     */
    open var headerStyle: String = definedExternally
    /**
     *  Optional CSS style applied to the day-of-week headers for weekend days. If unset
     *   DateChooser.headerStyle will be applied to both weekdays and weekend days.
     *  @type {string}
     *  @default null
     */
    open var weekendHeaderStyle: String = definedExternally
    /**
     *  CSS style to apply to navigation buttons and date display at the top of the
     *   component. If null, the CSS style specified in DateChooser.baseButtonStyle is used.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var baseNavButtonStyle: String = definedExternally
    /**
     *  Constructor for navigation buttons at the top of the component.
     *  @type {SCClassName}
     *  @default "IButton"
     */
    open var navButtonConstructor: String = definedExternally
    /**
     *  CSS style to apply to the buttons at the bottom of the DateChooser ("Today" and
     *   "Cancel"). If null, the CSS style specified in DateChooser.baseButtonStyle is used.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var baseBottomButtonStyle: String = definedExternally
    /**
     *  When showing the DateChooser.showFiscalYearChooser, should firstDayOfWeek
     *   be defaulted to the same day as the fiscal start date? If true and a fiscal year
     *   starts on a Tuesday, the calendar will display Tuesday to Monday from left to right.
     *  @type {boolean}
     *  @default true
     */
    open var useFirstDayOfFiscalWeek: Boolean = definedExternally
    /**
     *  Should this dateChooser be dismissed if the user presses the Escape key?
     *  @type {boolean}
     *  @default false
     */
    open var closeOnEscapeKeypress: Boolean = definedExternally
    /**
     *  TimeItem for editing the time portion of dates. Visible by default for fields
     *   of type "datetime" and can be controlled by setting DateChooser.showTimeItem.
     *  @type {TimeItem}
     *  @default null
     */
    open var timeItem: TimeItem = definedExternally
    /**
     *  Custom properties to apply to the DateChooser.timeItem used
     *   for editing the time portion of the date.
     *  @type {TimeItem}
     *  @default null
     */
    open var timeItemProperties: TimeItem = definedExternally
    /**
     *  Whether to show the DateChooser.timeItem for editing the time portion
     *   of the date. When unset, the time field is shown automatically if the field type is
     *   "datetime". Note that the item's DateChooser.showSecondItem is
     *   not shown by default.
     *  @type {boolean}
     *  @default null
     */
    open var showTimeItem: Boolean = definedExternally
    /**
     *  Title for the DateChooser.timeItem.
     *  @type {string}
     *  @default "Time"
     */
    open var timeItemTitle: String = definedExternally
    /**
     *  When showing the DateChooser.showTimeItem, whether the
     *   TimeItem should be set to use 24-hour time. The default is true.
     *  @type {boolean}
     *  @default true
     */
    open var use24HourTime: Boolean = definedExternally
    /**
     *  Title for the DateChooser.showFiscalYearChooser field in the date grid.
     *  @type {string}
     *  @default "Year"
     */
    open var fiscalYearFieldTitle: String = definedExternally
    /**
     *  Title for the DateChooser.showWeekChooser field in the date grid.
     *  @type {string}
     *  @default "Wk"
     */
    open var weekFieldTitle: String = definedExternally
    /**
     *  When showing the DateChooser.timeItem, whether to show the "second"
     *   picker. When unset, the second field is not shown.
     *  @type {boolean}
     *  @default null
     */
    open var showSecondItem: Boolean = definedExternally
    /**
     *  How long (how many characters) should be day names be. May be 1, 2 or 3 characters.
     *  @type {number}
     *  @default "2"
     */
    open var dayNameLength: Number = definedExternally
    /**
     *   Set the picker to show the given date.
     * 
     * 
     *  @param {Date} new value
     */
    open fun setData(date: Date): Unit = definedExternally
    /**
     *   Get the current value of the picker.
     * 
     *   See DateChooser.dataChanged for how to respond to the user picking a date.
     * 
     * 
     */
    open fun getData(): Date = definedExternally
    /**
     *   Returns the FiscalCalendar object that will be used by this DateChooser.
     * 
     * 
     */
    open fun getFiscalCalendar(): FiscalCalendar = definedExternally
    /**
     *   Sets the FiscalCalendar object that will be used by this DateChooser. If unset,
     *   the DateUtil.getFiscalCalendar is used.
     * 
     * 
     *  @param {FiscalCalendar=} the fiscal calendar for this chooser
     */
    open fun setFiscalCalendar(fiscalCalendar: FiscalCalendar?): Unit = definedExternally
    /**
     *   Override this method to alter the year representations that are shown in the DateChooser's
     *   "Select a year" dropdown. The default implementation returns the full four-digit
     *   Gregorian year (ie, the same value that is passed in)
     * 
     * 
     *  @param {Integer} The Gregorian year number to derive a display value for
     */
    open fun getYearTitle(year: Number): String = definedExternally
    /**
     *   Override this method to alter the year representation shown in the DateChooser's header.
     *   The default implementation returns the full four-digit Gregorian year (ie, the same
     *   value that is passed in)
     * 
     * 
     *  @param {Integer} The Gregorian year number to derive a display value for
     */
    open fun getHeaderYearTitle(year: Number): String = definedExternally
    /**
     *   Method to override or observe in order to be notified when a user picks a date value.
     * 
     *   Has no default behavior (so no need to call Super).
     * 
     *   Use DateChooser.getData to get the current date value.
     * 
     * 
     */
    open fun dataChanged(): Unit = definedExternally
    /**
     *   Fired when the user clicks the cancel button in this date chooser. Default implementation
     *   clears the date chooser.
     * 
     */
    open fun cancelClick(): Unit = definedExternally
    /**
     *   Fired when the user clicks the Today button. Default implementation will select the current
     *   date in the date chooser.
     * 
     */
    open fun todayClick(): Unit = definedExternally
    companion object {
        /**
         *  Creates a new DateChooser
         * 
         *  @param typeCheckedProperties {Partial<DateChooser>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DateChooser} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DateChooser = definedExternally
    }
}