@file:JsQualifier("isc")
package isc

/**
 *  FormItem for editing times in a text field or via a set of selector components.
 * 
 *   The display format for this field may be set by TimeItem.timeFormatter. Defaults
 *   are picked up from TimeItem.timeFormatter24Hour and TimeItem.timeFormatter12Hour.
 *   See also Time.setNormalDisplayFormat for system-wide settings.
 * 
 *   TimeItem automatically accepts both 12 and 24 hour time as well as partial times and a
 *   variety of possible time value separators. Examples:
 * 
 *   11:34:45 AM  => 11:34:45
 *   1:3:5 AM  => 01:30:50
 *   1:3p => 13:30:00
 *   11 34 am  => 11:34:00
 *   11-34 => 11:34:00
 *   113445 => 11:34:45
 *   13445 => 01:34:45
 *   1134 => 11:34:00
 *   134  => 01:34:00
 * 
 * 
 *   Values entered by the user are stored as JavaScript Date objects in local time.
 *   The day, month and year values of this Date object are not relevant and should
 *   be ignored.
 * 
 *   By default, when used in a SearchForm or as a field in a ListGrid's
 *   ListGrid.showFilterEditor, TimeItems will automatically generate
 *   AdvancedCriteria - for example, entering "11:00" into the item will generate a
 *   OperatorId Criterion that selects all times between
 *   11:00:00 and 11:59:59. If the form is databound and the DataSource is marked as being
 *   DataSource.allowAdvancedCriteria:false, the criteria generated
 *   will be simple, checking for data with logical time values equal to the displayed value.
 */
open external class TimeItem : FormItem {
    /**
     *  Text field to hold the entire time in "type in" format, if
     *   TimeItem.useTextField is true.
     *  @type {TextItem}
     *  @default null
     */
    open var textField: TextItem = definedExternally
    /**
     *  Custom properties to apply to the TimeItem.textField generated for
     *   this timeItem when TimeItem.useTextField is true.
     *  @type {TextItem}
     *  @default null
     */
    open var textFieldProperties: TextItem = definedExternally
    /**
     *  If TimeItem.useTextField is true and browserInputType is set to
     *   "time", then a native HTML5 time input
     *   is used in place of a text input.
     * 
     *   The use of a native HTML5 time input causes certain features to be disabled. Input masks
     *   and a custom TimeItem.timeFormatter are not supported.
     *   TimeItem.showHintInField are currently supported, but future browser
     *   changes might force this support to be removed. Therefore, it is safest to not
     *   use in-field hints (set showHintInField to false) in conjunction with a native HTML5 time
     *   input.
     * 
     *   NOTE: This feature requires specific CSS changes. Currently these changes have
     *   been made to the Enterprise, EnterpriseBlue, and Graphite skins only.
     *  @type {string}
     *  @default null
     */
    override var browserInputType: String = definedExternally
    /**
     *  If this item is showing a FormItem.hint, should the hint text be allowed to
     *   wrap? Setting this property to false will render the hint on a single line
     *   without wrapping, expanding the width required to render the item if necessary.
     * 
     *   If unset this property will be picked up from the DynamicForm.wrapHintText
     *   setting.
     * 
     *   This setting does not apply to hints that are TextItem.showHintInField.
     *  @type {boolean}
     *  @default false
     */
    override var wrapHintText: Boolean = definedExternally
    /**
     *  If TimeItem.useTextField is true and a FormItem.hint is
     *   set, should the hint be shown within the field?
     * 
     *   Note that when using a native HTML5 time input (see TimeItem.browserInputType),
     *   in-field hints are currently supported, but future browser changes might not allow
     *   in-field hints to be supported. Therefore, it is safest to not use in-field
     *   hints in conjunction with a native HTML5 time input.
     * 
     *   To change this attribute after being drawn, it is necessary to call FormItem.redraw
     *   or redraw the form.
     *  @type {boolean}
     *  @default null
     */
    open var showHintInField: Boolean = definedExternally
    /**
     *  If TimeItem.showHintInField and if supported by the browser, should the HTML5
     *   placeholder attribute
     *   be used to display the hint within the field? If set to false, then use of
     *   the placeholder attribute is disabled and an alternative technique to display
     *   the hint in-field is used instead.
     * 
     *   The HTML5 placeholder attribute is supported in the following major browsers:
     * 
     * 
     *  - Chrome 4+
     * 
     *  - Firefox 4+
     * 
     *  - Internet Explorer 10+
     * 
     *  - Safari 5+
     * 
     *  - Opera 11.50+
     * 
     *  - Android 2.1+ WebView (used by the stock Browser app and when
     *     phonegapIntegration)
     * 
     *  - Mobile Safari for iOS 3.2+
     * 
     * 
     *   In browsers other than the above, in-field hints are implemented via a different technique.
     * 
     *   Note that placeholder behavior is known to differ in Internet Explorer and certain old
     *   versions of the above browsers due to a recent change in the HTML5 specification regarding
     *   the placeholder attribute. Under the old rules, the placeholder is cleared
     *   when the element is focused. In the latest HTML5 spec as published by WHATWG, the placeholder
     *   is still displayed when the element is focused as long as the value is an empty string.
     * 
     *   Styling the placeholder
     *   While there isn't a standard way to style the placeholder text, Chrome, Firefox,
     *   Internet Explorer, and Safari provide vendor-prefixed pseudo-classes and/or pseudo-elements
     *   that can be used in CSS selectors:
     * 
     * 
     *    Browser
     *    Pseudo-class or pseudo-element
     * 
     * 
     *    Chrome, Safari
     *    ::-webkit-input-placeholder
     * 
     * 
     *    Firefox 4 - 18
     *    :-moz-placeholder
     * 
     * 
     *    Firefox 19+
     *    ::-moz-placeholder
     * 
     * 
     *    Internet Explorer
     *    :-ms-input-placeholder
     * 
     * 
     * 
     *   Note that unlike other browsers, Firefox 19+ applies opacity:0.4 to the placeholder text.
     *   See Bug 556145 - Placeholder text default style should use opacity instead of GrayText
     * 
     *   Because browsers are required to ignore the entire rule if a selector is invalid,
     *   separate rules are needed for each browser. For example:
     *   ::-webkit-input-placeholder {
     *    color: blue;
     *    opacity: 1;
     *  &#125;
     *  :-moz-placeholder {
     *    color: blue;
     *    opacity: 1;
     *  &#125;
     *  ::-moz-placeholder {
     *    color: blue;
     *    opacity: 1;
     *  &#125;
     *  :-ms-input-placeholder {
     *    color: blue;
     *    opacity: 1;
     *  &#125;
     *   
     *   If using Sass, it may be useful to utilize Sass'
     *   parent selector feature.
     *   For example:
     *   .myCustomItem,
     *  .myCustomItemRTL,
     *  .myCustomItemDisabled,
     *  .myCustomItemDisabledRTL,
     *  .myCustomItemError,
     *  .myCustomItemErrorRTL,
     *  .myCustomItemFocused,
     *  .myCustomItemFocusedRTL,
     *  .myCustomItemHint,
     *  .myCustomItemHintRTL,
     *  .myCustomItemDisabledHint,
     *  .myCustomItemDisabledHintRTL {
     *    // ...
     *  
     *    &amp;::-webkit-input-placeholder {
     *      color: blue;
     *      opacity: 1;
     *    }
     *    &amp;:-moz-placeholder {
     *      color: blue;
     *      opacity: 1;
     *    }
     *    &amp;::-moz-placeholder {
     *      color: blue;
     *      opacity: 1;
     *    }
     *    &amp;:-ms-input-placeholder {
     *      color: blue;
     *      opacity: 1;
     *    }
     *  &#125;
     *   
     *   If using Compass, the
     *   input-placeholder mixin
     *   that was added in version 1.0 can further simplify the code to style the placeholder text
     *   For example:
     *   .myCustomItem,
     *  .myCustomItemRTL,
     *  .myCustomItemDisabled,
     *  .myCustomItemDisabledRTL,
     *  .myCustomItemError,
     *  .myCustomItemErrorRTL,
     *  .myCustomItemFocused,
     *  .myCustomItemFocusedRTL,
     *  .myCustomItemHint,
     *  .myCustomItemHintRTL,
     *  .myCustomItemDisabledHint,
     *  .myCustomItemDisabledHintRTL {
     *    // ...
     *  
     *    &#64;include input-placeholder {
     *      color: blue;
     *      opacity: 1;
     *    }
     *  &#125;
     *   Accessibility concerns
     *   The HTML5 specification notes that a placeholder should not be used as a replacement
     *   for a title. The placeholder is intended to be a short hint that assists the user
     *   who is entering a value into the empty field. The placeholder can be mistaken by some
     *   users for a pre-filled value, particularly in Internet Explorer because the same color
     *   is used, and the placeholder text color may provide insufficient contrast, particularly
     *   in Firefox 19+ because of the default 0.4 opacity. Furthermore, not having a title reduces
     *   the hit area available for setting focus on the item.
     *  @type {boolean}
     *  @default true
     */
    open var usePlaceholderForHint: Boolean = definedExternally
    /**
     *  Controls whether to display the TimeItem.hourItem when TimeItem.useTextField is false.
     *  @type {boolean}
     *  @default true
     */
    open var showHourItem: Boolean = definedExternally
    /**
     *  Select item to hold the hours portion of the time or
     *   TimeItem.getDuration when TimeItem.useTextField
     *   is false.
     *  @type {SelectItem}
     *  @default null
     */
    open var hourItem: SelectItem = definedExternally
    /**
     *  Custom properties to apply to this timeItem's generated
     *   TimeItem.hourItem.
     *  @type {SelectItem}
     *  @default null
     */
    open var hourItemProperties: SelectItem = definedExternally
    /**
     *  Title to show for the TimeItem.hourItem.
     *  @type {HTMLString}
     *  @default "Hour"
     */
    open var hourItemTitle: String = definedExternally
    /**
     *  The hover prompt to show for the TimeItem.hourItem.
     *  @type {HTMLString}
     *  @default "Choose hours"
     */
    open var hourItemPrompt: String = definedExternally
    /**
     *  Controls whether to display the TimeItem.minuteItem when TimeItem.useTextField is false.
     *  @type {boolean}
     *  @default true
     */
    open var showMinuteItem: Boolean = definedExternally
    /**
     *  Select item to hold the minutes portion of the time or
     *   TimeItem.getDuration when TimeItem.useTextField
     *   is false.
     *  @type {SelectItem}
     *  @default null
     */
    open var minuteItem: SelectItem = definedExternally
    /**
     *  Custom properties to apply to this timeItem's generated
     *   TimeItem.minuteItem.
     *  @type {SelectItem}
     *  @default null
     */
    open var minuteItemProperties: SelectItem = definedExternally
    /**
     *  Title to show for the TimeItem.minuteItem.
     *  @type {HTMLString}
     *  @default "Min"
     */
    open var minuteItemTitle: String = definedExternally
    /**
     *  The hover prompt to show for the TimeItem.minuteItem.
     *  @type {HTMLString}
     *  @default "Choose minutes"
     */
    open var minuteItemPrompt: String = definedExternally
    /**
     *  Controls whether to display the TimeItem.secondItem when TimeItem.useTextField is false.
     *  @type {boolean}
     *  @default true
     */
    open var showSecondItem: Boolean = definedExternally
    /**
     *  Select item to hold the seconds portion of the time or
     *   TimeItem.getDuration when TimeItem.useTextField
     *   is false.
     *  @type {SelectItem}
     *  @default null
     */
    open var secondItem: SelectItem = definedExternally
    /**
     *  Custom properties to apply to this timeItem's generated
     *   TimeItem.secondItem.
     *  @type {SelectItem}
     *  @default null
     */
    open var secondItemProperties: SelectItem = definedExternally
    /**
     *  Title to show for the TimeItem.secondItem.
     *  @type {HTMLString}
     *  @default "Sec"
     */
    open var secondItemTitle: String = definedExternally
    /**
     *  The hover prompt to show for the TimeItem.secondItem.
     *  @type {HTMLString}
     *  @default "Choose seconds"
     */
    open var secondItemPrompt: String = definedExternally
    /**
     *  Controls whether to display the TimeItem.millisecondItem when TimeItem.useTextField is false.
     *  @type {boolean}
     *  @default false
     */
    open var showMillisecondItem: Boolean = definedExternally
    /**
     *  Select item to hold the milliseconds portion of the time or
     *   TimeItem.getDuration when TimeItem.useTextField
     *   is false.
     *  @type {SelectItem}
     *  @default null
     */
    open var millisecondItem: SelectItem = definedExternally
    /**
     *  Custom properties to apply to this timeItem's generated
     *   TimeItem.millisecondItem.
     *  @type {SelectItem}
     *  @default null
     */
    open var millisecondItemProperties: SelectItem = definedExternally
    /**
     *  Title to show for the TimeItem.millisecondItem.
     *  @type {HTMLString}
     *  @default "Ms"
     */
    open var millisecondItemTitle: String = definedExternally
    /**
     *  The hover prompt to show for the TimeItem.millisecondItem.
     *  @type {HTMLString}
     *  @default "Choose milliseconds"
     */
    open var millisecondItemPrompt: String = definedExternally
    /**
     *  Select item to hold the AM/PM value for the timeItem when
     *   TimeItem.useTextField is false.
     *  @type {SelectItem}
     *  @default null
     */
    open var ampmItem: SelectItem = definedExternally
    /**
     *  Custom properties to apply to this timeItem's generated
     *   TimeItem.ampmItem.
     *  @type {SelectItem}
     *  @default null
     */
    open var ampmItemProperties: SelectItem = definedExternally
    /**
     *  Title to show for the TimeItem.ampmItem.
     *  @type {HTMLString}
     *  @default "AM/PM"
     */
    open var ampmItemTitle: String = definedExternally
    /**
     *  What format should this item's time string be presented in?
     * 
     *   This attribute does not have an effect if a native HTML5 time input is being used.
     *   See TimeItem.browserInputType.
     *  @deprecated \* in favor of TimeItem.timeFormatter
     *  @type {TimeDisplayFormat}
     *  @default null
     */
    override var displayFormat: 
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
     *  If TimeItem.useTextField is true, what format should this item's time string be
     *   presented in?
     * 
     *   If unset, the default formatter will be TimeItem.timeFormatter24Hour or
     *   TimeItem.timeFormatter12Hour depending on the value of TimeItem.use24HourTime.
     *   If the property cannot be derived in this way (none of these properties are set),
     *   we'll check DynamicForm.timeFormatter, or finally back off to the
     *   standard system-wide Time.displayFormat will be applied.
     * 
     *   This attribute does not have an effect if a native HTML5 time input is being used.
     *   See TimeItem.browserInputType.
     *  @type {TimeDisplayFormat}
     *  @default null
     */
    override var timeFormatter: 
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
     *  If TimeItem.useTextField is true, and TimeItem.use24HourTime is true,
     *   what format should this item's time string be presented in?
     * 
     *   May be overridden via an explicitly specified TimeItem.timeFormatter.
     * 
     *   This attribute does not have an effect if a native HTML5 time input is being used.
     *   See TimeItem.browserInputType.
     *  @type {TimeDisplayFormat}
     *  @default "toShort24HourTime"
     */
    open var timeFormatter24Hour: 
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
     *  If TimeItem.useTextField is true, and TimeItem.use24HourTime is false,
     *   what format should this item's time string be presented in?
     * 
     *   May be overridden via an explicitly specified TimeItem.timeFormatter.
     * 
     *   This attribute does not have an effect if a native HTML5 time input is being used.
     *   See TimeItem.browserInputType.
     *  @type {TimeDisplayFormat}
     *  @default "toShortTime"
     */
    open var timeFormatter12Hour: 
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
     *  If true, a data entry mask will be enabled in the field based on the
     *   TimeItem.timeFormatter.
     * 
     *   Note that if a non-padded TimeItem.timeFormatter is specified, it
     *   will be changed to the corresponding padded version (ex. "toShort24HourTime"
     *   will be changed to "toShortPadded24HourTime").
     * 
     *   This attribute does not have an effect if a native HTML5 time input is being used.
     *   See TimeItem.browserInputType.
     *  @type {boolean}
     *  @default null
     */
    open var useMask: Boolean = definedExternally
    /**
     *  Should we show the time in a text field, or as a number of SelectItems?
     *  @type {boolean}
     *  @default true
     */
    open var useTextField: Boolean = definedExternally
    /**
     *  If TimeItem.useTextField is true, this property governs the alignment
     *   of text within the text field. Defaults to "left" by default or
     *   "right" if the page is in Page.isRTL.
     * 
     *   This attribute does not have an effect if a native HTML5 time input is being used.
     *   See TimeItem.browserInputType.
     *  @type {Alignment}
     *  @default "varies"
     */
    override var textAlign: 
                            /**
                             *  Center within container.
                             *  Stick to left side of container.
                             *  Stick to right side of container.
                             */
                            String /* center |  left |  right */ = definedExternally
    /**
     *  Validation error message to display if the user enters an invalid time string.
     *  @type {HTMLString}
     *  @default "Invalid time"
     */
    open var invalidTimeStringMessage: String = definedExternally
    /**
     *  Whether to enforce 24-hour time in the UI. If unset, assumes to the
     *   Time.use24HourTime.
     *  @type {boolean}
     *  @default null
     */
    open var use24HourTime: Boolean = definedExternally
    /**
     *  Base CSS class for this item's text box.
     *   If specified this style will be applied to the TimeItem.textField if
     *   TimeItem.useTextField is set to true.
     *  @type {CSSStyleName}
     *  @default null
     */
    override var textBoxStyle: String = definedExternally
    /**
     *  An array of values to make available in the TimeItem.hourItem when
     *   TimeItem.useTextField is false.
     *   Used for specifying a limited set of valid Hour values, or when using the
     *   TimeItem to record duration, rather than time per-se.
     *   See TimeItem.hourMinValue,
     *   TimeItem.hourMaxValue and
     *   TimeItem.hourIncrement for another method of controlling the
     *   content in the hour picker.
     *  @type {Array<Partial<number>>}
     *  @default null
     */
    open var hourValues: Array<dynamic> = definedExternally
    /**
     *  When TimeItem.useTextField is false and
     *   TimeItem.hourValues is unset, this attribute specifies the minimum
     *   value present in the hour picker.
     *   Used for specifying a limited set of valid Hour values, or when using the
     *   TimeItem to record duration, rather than time per-se. The default is zero in all cases.
     *   See also TimeItem.hourMaxValue and
     *   TimeItem.hourIncrement.
     *  @type {number}
     *  @default null
     */
    open var hourMinValue: Number = definedExternally
    /**
     *  When TimeItem.useTextField is false and
     *   TimeItem.hourValues is unset, this attribute specifies the maximum
     *   value present in the hour picker.
     *   Used for specifying a limited set of valid Hour values, or when using the
     *   TimeItem to record duration, rather than time per-se. The default is 11 or 23,
     *   according to the value of TimeItem.use24HourTime and
     *   TimeItem.timeFormatter.
     *   See also TimeItem.hourMinValue and
     *   TimeItem.hourIncrement.
     *  @type {number}
     *  @default null
     */
    open var hourMaxValue: Number = definedExternally
    /**
     *  When TimeItem.useTextField is false and
     *   TimeItem.hourValues is unset, this attribute specifies the increment
     *   to use when generating entries for the hour picker. For example, if this attribute is
     *   set to 5, the hour picker will contain only every fifth value between the
     *   TimeItem.hourMinValue and
     *   TimeItem.hourMaxValue.
     *  @type {number}
     *  @default null
     */
    open var hourIncrement: Number = definedExternally
    /**
     *  An array of values to make available in the TimeItem.minuteItem when
     *   TimeItem.useTextField is false.
     *   Used for specifying a limited set of valid Minute values, or when using the
     *   TimeItem to record duration, rather than time per-se.
     *   See TimeItem.minuteMinValue,
     *   TimeItem.minuteMaxValue and
     *   TimeItem.minuteIncrement for another method of controlling the
     *   content in the minute picker.
     *  @type {Array<Partial<number>>}
     *  @default null
     */
    open var minuteValues: Array<dynamic> = definedExternally
    /**
     *  When TimeItem.useTextField is false and
     *   TimeItem.minuteValues is unset, this attribute specifies the minimum
     *   value present in the minute picker.
     *   Used for specifying a limited set of valid Minute values, or when using the
     *   TimeItem to record duration, rather than time per-se. The default is zero in all cases.
     *   See also TimeItem.minuteMaxValue and
     *   TimeItem.minuteIncrement.
     *  @type {number}
     *  @default null
     */
    open var minuteMinValue: Number = definedExternally
    /**
     *  When TimeItem.useTextField is false and
     *   TimeItem.minuteValues is unset, this attribute specifies the maximum
     *   value present in the minute picker.
     *   Used for specifying a limited set of valid Minute values, or when using the
     *   TimeItem to record duration, rather than time per-se. The default 59.
     *   See also TimeItem.minuteMinValue and
     *   TimeItem.minuteIncrement.
     *  @type {number}
     *  @default null
     */
    open var minuteMaxValue: Number = definedExternally
    /**
     *  When TimeItem.useTextField is false and
     *   TimeItem.minuteValues is unset, this attribute specifies the increment
     *   to use when generating entries for the minute picker. For example, if this attribute is
     *   set to 5, the minute picker will contain only every fifth value between the
     *   TimeItem.minuteMinValue and
     *   TimeItem.minuteMaxValue.
     *  @type {number}
     *  @default null
     */
    open var minuteIncrement: Number = definedExternally
    /**
     *  An array of values to make available in the TimeItem.secondItem when
     *   TimeItem.useTextField is false.
     *   Used for specifying a limited set of valid Second values, or when using the
     *   TimeItem to record duration, rather than time per-se.
     *   See TimeItem.secondMinValue,
     *   TimeItem.secondMaxValue and
     *   TimeItem.secondIncrement for another method of controlling the
     *   content in the second picker.
     *  @type {Array<Partial<number>>}
     *  @default null
     */
    open var secondValues: Array<dynamic> = definedExternally
    /**
     *  When TimeItem.useTextField is false and
     *   TimeItem.secondValues is unset, this attribute specifies the minimum
     *   value present in the second picker.
     *   Used for specifying a limited set of valid Second values, or when using the
     *   TimeItem to record duration, rather than time per-se. The default is zero in all cases.
     *   See also TimeItem.secondMaxValue and
     *   TimeItem.secondIncrement.
     *  @type {number}
     *  @default null
     */
    open var secondMinValue: Number = definedExternally
    /**
     *  When TimeItem.useTextField is false and
     *   TimeItem.secondValues is unset, this attribute specifies the maximum
     *   value present in the second picker.
     *   Used for specifying a limited set of valid Second values, or when using the
     *   TimeItem to record duration, rather than time per-se. The default is 59.
     *   See also TimeItem.secondMinValue and
     *   TimeItem.secondIncrement.
     *  @type {number}
     *  @default null
     */
    open var secondMaxValue: Number = definedExternally
    /**
     *  When TimeItem.useTextField is false and
     *   TimeItem.secondValues is unset, this attribute specifies the increment
     *   to use when generating entries for the second picker. For example, if this attribute is
     *   set to 5, the second picker will contain only every fifth value between the
     *   TimeItem.secondMinValue and
     *   TimeItem.secondMaxValue.
     *  @type {number}
     *  @default null
     */
    open var secondIncrement: Number = definedExternally
    /**
     *  An array of values to make available in the
     *   TimeItem.millisecondItem when
     *   TimeItem.useTextField is false.
     *   Used for specifying a limited set of valid Millisecond values, or when using the
     *   TimeItem to record duration, rather than time per-se.
     *   See TimeItem.millisecondMinValue,
     *   TimeItem.millisecondMaxValue and
     *   TimeItem.millisecondIncrement for another method of
     *   controlling the content in the millisecond picker.
     *  @type {Array<Partial<number>>}
     *  @default null
     */
    open var millisecondValues: Array<dynamic> = definedExternally
    /**
     *  When TimeItem.useTextField is false and
     *   TimeItem.millisecondValues is unset, this attribute specifies
     *   the minimum value present in the millisecond picker.
     *   Used for specifying a limited set of valid Millisecond values, or when using the
     *   TimeItem to record duration, rather than time per-se. The default is zero in all cases.
     *   See also TimeItem.millisecondMaxValue and
     *   TimeItem.millisecondIncrement.
     *  @type {number}
     *  @default null
     */
    open var millisecondMinValue: Number = definedExternally
    /**
     *  When TimeItem.useTextField is false and
     *   TimeItem.millisecondValues is unset, this attribute specifies
     *   the maximum value present in the millisecond picker.
     *   Used for specifying a limited set of valid Millisecond values, or when using the
     *   TimeItem to record duration, rather than time per-se. The default is 999.
     *   See also TimeItem.millisecondMinValue and
     *   TimeItem.millisecondIncrement.
     *  @type {number}
     *  @default null
     */
    open var millisecondMaxValue: Number = definedExternally
    /**
     *  When TimeItem.useTextField is false and
     *   TimeItem.millisecondValues is unset, this attribute specifies
     *   the increment to use when generating entries for the millisecond picker. For example,
     *   if this attribute is set to 5, the millisecond picker will contain only every fifth
     *   value between the TimeItem.millisecondMinValue and
     *   TimeItem.millisecondMaxValue.
     *  @type {number}
     *  @default null
     */
    open var millisecondIncrement: Number = definedExternally
    /**
     *   Sets the array of valid TimeItem.hourValues to use when
     *   TimeItem.useTextField is false.
     *   Used for limiting available valid Hour values, or when using the TimeItem to record
     *   duration, rather than time per-se.
     *   See TimeItem.hourMinValue,
     *   TimeItem.hourMaxValue and
     *   TimeItem.hourIncrement for another method of controlling the
     *   content in the hour picker.
     * 
     *  @param {Array<Partial<number>>} array of available Hour values
     */
    open fun setHourValues(values: Array<dynamic>): Unit = definedExternally
    /**
     *   Returns an array of the current valid hour values, whether set directly as
     *   TimeItem.hourValues or generated according to
     *   TimeItem.hourMinValue,
     *   TimeItem.hourMaxValue and
     *   TimeItem.hourIncrement.
     * 
     */
    open fun getHourValues(): Array<dynamic> = definedExternally
    /**
     *   Sets the array of valid TimeItem.minuteValues to use when
     *   TimeItem.useTextField is false.
     *   Used for limiting available valid Minute values, or when using the TimeItem to record
     *   duration, rather than time per-se.
     *   See TimeItem.minuteMinValue,
     *   TimeItem.minuteMaxValue and
     *   TimeItem.minuteIncrement for another method of controlling the
     *   content in the minute picker.
     * 
     *  @param {Array<Partial<number>>} array of available Minute values
     */
    open fun setMinuteValues(values: Array<dynamic>): Unit = definedExternally
    /**
     *   Returns an array of the current valid minute values, whether set directly as
     *   TimeItem.minuteValues or generated according to
     *   TimeItem.minuteMinValue,
     *   TimeItem.minuteMaxValue and
     *   TimeItem.minuteIncrement.
     * 
     */
    open fun getMinuteValues(): Array<dynamic> = definedExternally
    /**
     *   Sets the array of valid TimeItem.secondValues to use when
     *   TimeItem.useTextField is false.
     *   Used for limiting available valid Second values, or when using the TimeItem to record
     *   duration, rather than time per-se.
     *   See TimeItem.secondMinValue,
     *   TimeItem.secondMaxValue and
     *   TimeItem.secondIncrement for another method of controlling the
     *   content in the second picker.
     * 
     *  @param {Array<Partial<number>>} array of available Second values
     */
    open fun setSecondValues(values: Array<dynamic>): Unit = definedExternally
    /**
     *   Returns an array of the current valid second values, whether set directly as
     *   TimeItem.secondValues or generated according to
     *   TimeItem.secondMinValue,
     *   TimeItem.secondMaxValue and
     *   TimeItem.secondIncrement.
     * 
     */
    open fun getSecondValues(): Array<dynamic> = definedExternally
    /**
     *   Sets the array of valid TimeItem.millisecondValues to use when
     *   TimeItem.useTextField is false.
     *   Used for limiting available valid Millisecond values, or when using the TimeItem to record
     *   duration, rather than time per-se.
     *   See TimeItem.millisecondMinValue,
     *   TimeItem.millisecondMaxValue and
     *   TimeItem.millisecondIncrement for another method of controlling the
     *   content in the millisecond picker.
     * 
     *  @param {Array<Partial<number>>} array of available Millisecond values
     */
    open fun setMillisecondValues(values: Array<dynamic>): Unit = definedExternally
    /**
     *   Returns an array of the current valid millisecond values, whether set directly as
     *   TimeItem.millisecondValues or generated according to
     *   TimeItem.millisecondMinValue,
     *   TimeItem.millisecondMaxValue and
     *   TimeItem.millisecondIncrement.
     * 
     */
    open fun getMillisecondValues(): Array<dynamic> = definedExternally
    /**
     *   Set the hour value of this TimeItem.
     *   If the item value has not been initialized with TimeItem.setValue,
     *   the minute will be established to current minute.
     * 
     *   You can use TimeItem.setValue to set both hours and minutes at the same time.
     * 
     * 
     * 
     *  @param {number} new hours value for this TimeItem.
     */
    open fun setHours(hours: Number): Unit = definedExternally
    /**
     *   Set the minute value of this TimeItem.
     *   If the item value has not been initialized with TimeItem.setValue,
     *   the hour will be established to current hour.
     * 
     *   You can use TimeItem.setValue to set both hours and minutes at the same time.
     * 
     * 
     * 
     *  @param {number} new minutes value for this TimeItem.
     */
    open fun setMinutes(minutes: Number): Unit = definedExternally
    /**
     *   Set the seconds value of this TimeItem.
     * 
     *  @param {number} new seconds value for this TimeItem.
     */
    open fun setSeconds(seconds: Number): Unit = definedExternally
    /**
     *   Set the milliseconds value of this TimeItem.
     * 
     *  @param {number} new milliseconds value for this TimeItem.
     */
    open fun setMilliseconds(milliseconds: Number): Unit = definedExternally
    /**
     *   When TimeItem.useTextField is set to false, this method
     *   returns the value of the time expressed as a duration in the TimeUnit
     *   provided. If no timeUnit is passed, the default is the smallest unit for which a
     *   picker is visible.
     * 
     *  @param {TimeUnit=} the unit of the return value
     */
    open fun getDuration(timeUnit: 
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
                                   String /* millisecond |  second |  minute |  hour |  day |  week |  month |  quarter |  year */?): Number = definedExternally
    /**
     *   Notification method called when FormItem.showPending is enabled and
     *   this time item should either clear or show its pending visual state.
     * 
     *   The default behavior is that the FormItem.titleStyle and
     *   FormItem.cellStyle are updated to include/exclude the "Pending" suffix.
     *   In addition, when displayed in the pending state:
     * 
     * 
     *  - If TimeItem.useTextField is true, then the "Pending"
     *     suffix will be appended to the FormItem.textBoxStyle applied to the
     *     TimeItem.textField; otherwise
     * 
     *  - (useTextField is false) the color of the
     *     TimeItem.hourItem, TimeItem.minuteItem,
     *     TimeItem.secondItem, TimeItem.millisecondItem,
     *     and/or TimeItem.ampmItem will change when the hour, minute, second,
     *     millisecond, or whether the time is AM or PM is different, respectively.
     * 
     *   Returning false will cancel this default behavior.
     * 
     *  @param {DynamicForm} the managing DynamicForm instance.
     *  @param {FormItem} the form item itself (also available as "this").
     *  @param {boolean} true if the item should show its pending visual state; false otherwise.
     *  @param {any} the current form item value.
     *  @param {any} the value that would be restored by a call to DynamicForm.resetValues.
     */
    override fun pendingStatusChanged(form: DynamicForm, item: FormItem, pendingStatus: Boolean, newValue: dynamic, value: dynamic): Boolean = definedExternally
    /**
     *   Set the value of the form item to the value passed in
     * 
     *   NOTE: for valueMap'd items, newValue should be data value not displayed value
     * 
     *  @param {any} value to set the element to
     */
    override fun setValue(newValue: dynamic): Unit = definedExternally
    /**
     *   Returns the raw text value typed into this items text field if TimeItem.useTextField
     *   is true (otherwise returns the result of this.getValue()).
     * 
     */
    open fun getEnteredValue(): String = definedExternally
    /**
     *   If TimeItem.useTextField is true, falls through to standard
     *   TextItem.setSelectionRange implementation on this items freeform text entry field.
     *   Otherwise has no effect.
     * 
     *  @param {Integer} character index for start of new selection
     *  @param {Integer} character index for end of new selection
     */
    open fun setSelectionRange(start: Number, end: Number): Unit = definedExternally
    /**
     *   If TimeItem.useTextField is true, falls through to standard
     *   TextItem.getSelectionRange implementation on this items freeform text entry field.
     *   Otherwise has no effect.
     * 
     */
    open fun getSelectionRange(): Array<dynamic> = definedExternally
    /**
     *   If TimeItem.useTextField is true, falls through to standard
     *   TextItem.selectValue implementation on this items freeform text entry field.
     *   Otherwise has no effect.
     * 
     */
    open fun selectValue(): Unit = definedExternally
    /**
     *   If TimeItem.useTextField is true, falls through to standard
     *   TextItem.deselectValue implementation on this items freeform text entry field.
     *   Otherwise has no effect.
     * 
     *  @param {boolean=} If this parameter is passed, new cursor insertion position will be  moved to the start, rather than the end of this item's value.
     */
    open fun deselectValue(start: Boolean?): Unit = definedExternally
    companion object {
        /**
         *  Creates a new TimeItem
         * 
         *  @param typeCheckedProperties {Partial<TimeItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {TimeItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): TimeItem = definedExternally
    }
}