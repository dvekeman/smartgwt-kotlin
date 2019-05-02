@file:JsQualifier("isc")
package isc

/**
 *  Item for manipulating Dates.
 * 
 *   Can be rendered as a text field, or as 3 selects for day, month, year. Includes optional
 *   pop-up picker.
 */
open external class DateItem : FormItem {
    /**
     *  Text field to hold the entire date in "type in" format, if DateItem.useTextField
     *   is true.
     *  @type {TextItem}
     *  @default null
     */
    open var textField: TextItem = definedExternally
    /**
     *  Custom properties to apply to this dateItem's generated DateItem.textField.
     *   Only applies if DateItem.useTextField is true.
     *  @type {TextItem}
     *  @default null
     */
    open var textFieldProperties: TextItem = definedExternally
    /**
     *  If DateItem.useTextField is true and browserInputType is set to
     *   "date", then a native HTML5 date input
     *   is used in place of a text input.
     * 
     *   The use of a native HTML5 date input causes certain features to be disabled. Input masks,
     *   the picker icon, and a custom DateItem.dateFormatter are not supported.
     *   DateItem.showHintInField are currently supported, but future browser
     *   changes might force this support to be removed. Therefore, it is safest to not
     *   use in-field hints (set showHintInField to false) in conjunction with a native HTML5 date
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
     *  If DateItem.useTextField is true and a FormItem.hint is
     *   set, should the hint be shown within the field?
     * 
     *   Note that when using a native HTML5 date input (see DateItem.browserInputType),
     *   in-field hints are currently supported, but future browser changes might not allow
     *   in-field hints to be supported. Therefore, it is safest to not use in-field
     *   hints in conjunction with a native HTML5 date input.
     * 
     *   To change this attribute after being drawn, it is necessary to call FormItem.redraw
     *   or redraw the form.
     *  @type {boolean}
     *  @default null
     */
    open var showHintInField: Boolean = definedExternally
    /**
     *  If DateItem.showHintInField and if supported by the browser, should the HTML5
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
     *  Select item to hold the day part of the date.
     *  @type {SelectItem}
     *  @default null
     */
    open var daySelector: SelectItem = definedExternally
    /**
     *  Custom properties to apply to this dateItem's generated DateItem.daySelector.
     *  @type {SelectItem}
     *  @default null
     */
    open var daySelectorProperties: SelectItem = definedExternally
    /**
     *  Select item to hold the month part of the date.
     *  @type {SelectItem}
     *  @default null
     */
    open var monthSelector: SelectItem = definedExternally
    /**
     *  Custom properties to apply to this dateItem's generated DateItem.monthSelector.
     *  @type {SelectItem}
     *  @default null
     */
    open var monthSelectorProperties: SelectItem = definedExternally
    /**
     *  Select item to hold the year part of the date.
     *  @type {SelectItem}
     *  @default null
     */
    open var yearSelector: SelectItem = definedExternally
    /**
     *  Custom properties to apply to this dateItem's generated DateItem.yearSelector.
     *  @type {SelectItem}
     *  @default null
     */
    open var yearSelectorProperties: SelectItem = definedExternally
    /**
     *  When set to true (the default), use a single shared date-picker across all widgets that
     *   use one. When false, create a new picker using the autoChild system. See
     *   picker and
     *   DateItem.pickerProperties for details on setting up an unshared
     *   picker.
     *  @type {boolean}
     *  @default true
     */
    open var useSharedPicker: Boolean = definedExternally
    /**
     *  SmartClient class for the FormItem.picker autoChild displayed to allow the user
     *   to directly select dates.
     *  @type {string}
     *  @default "DateChooser"
     */
    override var pickerConstructor: String = definedExternally
    /**
     *  Properties for the DateChooser created by this form item.
     *  @type {DateChooser}
     *  @default "see below"
     */
    override var pickerProperties: Canvas = definedExternally
    /**
     *  Should we show the date in a text field, or as 3 select boxes?
     *  @type {boolean}
     *  @default null
     */
    open var useTextField: Boolean = definedExternally
    /**
     *  If DateItem.useTextField is true this property governs the alignment
     *   of text within the text field. Defaults to "right" by default or
     *   "left" if the page is in Page.isRTL.
     * 
     *   This attribute does not have an effect if a native HTML5 date input is being used.
     *   See DateItem.browserInputType.
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
     *  If DateItem.useTextField is not false this property determines if
     *   an input mask should be used. The format of the mask is determined by the
     *   DateItem.inputFormat or DateItem.dateFormatter (in that order).
     * 
     *   This attribute does not have an effect if a native HTML5 date input is being used.
     *   See DateItem.browserInputType.
     *  @type {boolean}
     *  @default null
     */
    open var useMask: Boolean = definedExternally
    /**
     *  If DateItem.useTextField and DateItem.useMask are both true
     *   this value is the separator between date components. If unset
     *   DateUtil.getDefaultDateSeparator will be used.
     *  @type {string}
     *  @default null
     */
    open var maskDateSeparator: String = definedExternally
    /**
     *  Can this field be set to a non-date value [other than null]?
     * 
     *   When set to true, FormItem.setValue will return false without setting the item value
     *   and log a warning if passed something other than a valid date value.
     *   If the dateItem is showing a DateItem.useTextField,
     *   and a user enters a text value which cannot be parsed into a valid date, the item will
     *   automatically redraw and display the DateItem.invalidDateStringMessage (though at this
     *   point calling FormItem.getValue will return the string entered by the user).
     * 
     *   When set to false, a user may enter a value that is not a valid date (for example, "Not
     *   applicable") and the value will not immediately be flagged as an error. However note
     *   that for the value to actually pass validation you would need to declare the field as
     *   not of "date" type, for example:
     * 
     *     {name:"startDate", type:"dateOrOther", editorType:"DateItem", useTextField:true },
     * 
     *   The type "dateOrOther" could be declared as a SimpleType, with validators that
     *   will accept either a valid date or certain special Strings (like "Not Available").
     * 
     *   Only applies to dateItems where DateItem.useTextField is true. Non-Date values
     *   are never supported in items where useTextField is false.
     * 
     *   This attribute does not have an effect if a native HTML5 date input is being used.
     *   See DateItem.browserInputType.
     *  @type {boolean}
     *  @default false
     */
    open var enforceDate: Boolean = definedExternally
    /**
     *  Validation error message to display if the user enters an invalid date
     *  @type {string}
     *  @default "Invalid date"
     */
    open var invalidDateStringMessage: String = definedExternally
    /**
     *  Prompt to show when the user hovers the mouse over the picker icon for this DateItem. May
     *   be overridden for localization of your application.
     *  @type {HTMLString}
     *  @default "Show Date Chooser"
     */
    override var pickerIconPrompt: String = definedExternally
    /**
     *  Minimum date the selectors will allow the user to pick. The default value is January
     *   1st, 10 years before the current year.
     * 
     *   NOTE: by design, setting startDate and endDate will not
     *   always prevent the user from picking invalid values. In particular:
     * 
     * 
     *  - the set of available days will only be restricted if the start and end dates fall
     *   within the same month
     * 
     *  - the set of available months will only be restricted if the start and end dates fall
     *   within the same year
     * 
     * 
     *   This is by design as it allows the user to set the day, month and year in
     *   whatever order is convenient, rather than forcing them to pick in a specific order.
     * 
     *   For actual enforcement of a date being in correct range before data is submitted, a
     *   Validator of type "dateRange" should always be declared.
     *  @type {Date}
     *  @default "See below"
     */
    open var startDate: Date = definedExternally
    /**
     *  Maximum date the selectors will allow the user to pick. The default value is December
     *   31st, 5 years after the current year.
     * 
     *   See DateItem.startDate for details on how this restriction works.
     *  @type {Date}
     *  @default "See below"
     */
    open var endDate: Date = definedExternally
    /**
     *  Only used if we're showing the date in a text field. When parsing a date, if the year
     *   is specified with 1 or 2 digits and is less than the centuryThreshold, then the year will
     *   be assumed to be 20xx; otherwise it will be interpreted according to default browser
     *   behaviour, which will consider it to be 19xx.
     * 
     *   If you need to allow 1 and 2 digit years, set this attribute to
     *   null to have the control retain your year-value as entered.
     *  @type {number}
     *  @default "25"
     */
    open var centuryThreshold: Number = definedExternally
    /**
     *  When showing the DateChooser and the field is of type "datetime", whether
     *   the DateChooser.showTimeItem should be set to use 24-hour time. The
     *   default is true.
     * 
     *   Has no effect if DateItem.showPickerTimeItem is explicitly set to false.
     *  @type {boolean}
     *  @default true
     */
    open var use24HourTime: Boolean = definedExternally
    /**
     *  If this field is of type "datetime", when showing the
     *   DateChooser, should the DateChooser.showTimeItem be
     *   displayed?
     * 
     *   Has no effect for fields of type "date".
     * 
     *   This attribute does not have an effect if a native HTML5 date input is being used.
     *   See DateItem.browserInputType.
     *  @type {boolean}
     *  @default true
     */
    open var showPickerTimeItem: Boolean = definedExternally
    /**
     *  A set of properties to apply to the TimeItem displayed in the picker when
     *   DateItem.showPickerTimeItem is true.
     * 
     *   Has no effect for fields of type "date".
     *  @type {TimeItem}
     *  @default null
     */
    open var pickerTimeItemProperties: TimeItem = definedExternally
    /**
     *  If DateItem.useTextField is true this property can be used to
     *   customize the format in which dates are displayed for this item.
     *   Should be set to a standard DateDisplayFormat.
     * 
     *   As with any formItem rendering out a date value, if no explicit dateFormatter is
     *   supplied, dateFormatter will be derived from DynamicForm.dateFormatter or
     *   DynamicForm.datetimeFormatter, depending on the specified FormItem.type for
     *   this field, if set, otherwise from the standard default
     *   DateUtil.setShortDisplayFormat or DateUtil.setShortDatetimeDisplayFormat.
     * 
     *   NOTE: For entirely custom formats, developers may apply a custom
     * 
     *   DateItem.formatEditorValue method. To ensure the
     *   DateItem is able to parse user-entered date strings back into Dates, for most cases
     *   developers can specify an explicit DateItem.inputFormat, or if necessary a
     *   custom DateItem.parseEditorValue.
     * 
     * 
     * 
     *   This attribute does not have an effect if a native HTML5 date or datetime input is being used.
     *   See DateItem.browserInputType.
     *  @type {DateDisplayFormat}
     *  @default null
     */
    override var dateFormatter: 
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
     *  If DateItem.useTextField is true this property can be used to
     *   customize the format in which dates are displayed.
     *   Should be set to a standard DateDisplayFormat or
     *   a function which will return a formatted date string.
     * 
     *   If unset, the standard shortDate format as set up via
     *   DateUtil.setShortDisplayFormat will be used.
     * 
     *   NOTE: you may need to update the DateItem.inputFormat to ensure the
     *   DateItem is able to parse user-entered date strings back into Dates
     * 
     *   This attribute does not have an effect if a native HTML5 date input is being used.
     *   See DateItem.browserInputType.
     *  @deprecated \* Use DateItem.dateFormatter instead.
     *  @type {DateDisplayFormat}
     *  @default null
     */
    override var displayFormat: 
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
     *  If DateItem.useTextField is true this property can be used to specify
     *   the input format for date strings.
     *   If unset, the input format will be determined based on the specified
     *   DateItem.dateFormatter if possible (see DateItem.getInputFormat), otherwise
     *   picked up from the Date class (see DateUtil.setInputFormat).
     * 
     *   Should be set to a standard DateInputFormat
     * 
     *   Note that the DateInputFormat property is sufficient to parse date or datetime
     *   strings specified in most standard date formats. However should an entirely custom
     *   parsing function be required developers can
     *   implement a custom DateItem.parseEditorValue method.
     * 
     * 
     *   This attribute does not have an effect if a native HTML5 date input is being used.
     *   See DateItem.browserInputType.
     *  @type {DateInputFormat}
     *  @default null
     */
    override var inputFormat: String = definedExternally
    /**
     *  If showing date selectors rather than the date text field (so when
     *   this.useTextField is false), this property allows customization of the
     *   order of the day, month and year selector fields. If unset, these fields will match the
     *   specified DateItem.inputFormat for this item, but note that the attribute default will
     *   likely be set by i18n to a valid DateItemSelectorFormat.
     * 
     *   Note: selectors may be omitted entirely by setting selectorFormat to (for example)
     *   "MD". In this case the value for the omitted selector will match the
     *   FormItem.defaultValue specified for the item. For example,
     *   if the selector format is "MD" (month and day only), the year comes from the Date
     *   specified as the defaultValue.
     *  @type {DateItemSelectorFormat}
     *  @default "varies"
     */
    open var selectorFormat: 
                             /**
                              *  Output fields in day, month, year order.
                              *  Output fields in month, day, year order.
                              *  Output fields in year, month, day order.
                              *  Output only day, month fields.
                              *  Output only month, day fields.
                              *  Output only year, month fields.
                              *  Output only month, year fields.
                              */
                             String /* DMY |  MDY |  YMD |  DM |  MD |  YM |  MY */ = definedExternally
    /**
     *  Default date to show in the date chooser. If this items value is currently unset,
     *   this property may be specified to set a default date to highlight in the dateChooser
     *   for this item. If unset, the date chooser will highlight the current date by default.
     *   Note that this has no effect if the item as a whole currently has a value - in that
     *   case the date chooser will always highlight the current value for the item.
     *  @type {Date}
     *  @default null
     */
    open var defaultChooserDate: Date = definedExternally
    /**
     *  When set to true, show a button that allows the calendar to be navigated by fiscal year.
     *  @type {boolean}
     *  @default false
     */
    open var showChooserFiscalYearPicker: Boolean = definedExternally
    /**
     *  When set to true, show a button that allows the calendar to be navigated by week or
     *   fiscal week, depending on the value of DateItem.showChooserFiscalYearPicker.
     *  @type {boolean}
     *  @default false
     */
    open var showChooserWeekPicker: Boolean = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "DateItemEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
    /**
     *   Notification method called when FormItem.showPending is enabled and
     *   this date item should either clear or show its pending visual state.
     * 
     *   The default behavior is that the FormItem.titleStyle and
     *   FormItem.cellStyle are updated to include/exclude the "Pending" suffix.
     *   In addition, when displayed in the pending state:
     * 
     * 
     *  - If DateItem.useTextField is true, then the "Pending"
     *     suffix will be appended to the FormItem.textBoxStyle applied to the
     *     DateItem.textField; otherwise
     * 
     *  - (useTextField is false) the color of the
     *     DateItem.daySelector, DateItem.monthSelector
     *     and/or DateItem.yearSelector will change when the day, month, or year
     *     is different, respectively.
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
     *   Returns the raw text value typed into this items text field if DateItem.useTextField
     *   is true (otherwise returns the result of this.getValue()).
     * 
     */
    open fun getEnteredValue(): String = definedExternally
    /**
     *   Setter for DateItem.startDate.
     *   Note: A DateUtil.createLogicalDate is expected.
     * 
     *  @param {Date | string} the new startDate.
     */
    open fun setStartDate(startDate: dynamic): Unit = definedExternally
    /**
     *   Setter for DateItem.endDate.
     *   Note: A DateUtil.createLogicalDate is expected.
     * 
     *  @param {Date | string} the new endDate.
     */
    open fun setEndDate(endDate: dynamic): Unit = definedExternally
    /**
     *   If DateItem.useTextField is true, falls through to standard
     *   TextItem.setSelectionRange implementation on this items freeform text entry field.
     *   Otherwise has no effect.
     * 
     *  @param {Integer} character index for start of new selection
     *  @param {Integer} character index for end of new selection
     */
    open fun setSelectionRange(start: Number, end: Number): Unit = definedExternally
    /**
     *   If DateItem.useTextField is true, falls through to standard
     *   TextItem.getSelectionRange implementation on this items freeform text entry field.
     *   Otherwise has no effect.
     * 
     */
    open fun getSelectionRange(): Array<dynamic> = definedExternally
    /**
     *   If DateItem.useTextField is true, falls through to standard
     *   TextItem.selectValue implementation on this items freeform text entry field.
     *   Otherwise has no effect.
     * 
     */
    open fun selectValue(): Unit = definedExternally
    /**
     *   If DateItem.useTextField is true, falls through to standard
     *   TextItem.deselectValue implementation on this items freeform text entry field.
     *   Otherwise has no effect.
     * 
     *  @param {boolean=} If this parameter is passed, new cursor insertion position will be  moved to the start, rather than the end of this item's value.
     */
    open fun deselectValue(start: Boolean?): Unit = definedExternally
    /**
     *   Convert a text value entered in this item's text field to a final data value
     *   for storage.
     * 
     *   If DateItem.useTextField is true, entirely custom date formatting and
     *   parsing logic may be applied via overrides to DateItem.parseEditorValue and
     *   DateItem.formatEditorValue. These methods apply to this FormItem only -
     *   system-wide Date and Datetime formatting and parsing may also be customized via
     *   the APIs on the Date class. See dateFormatAndStorage for more
     *   on this.
     * 
     *   Note: custom parsing for this item may also be achieved by modifying the
     *   DateItem.inputFormat. This mechanism provides support many common date formats
     *   without the need for an entirely custom parser function.
     * 
     * 
     *  @param {string} value as entered by the user
     *  @param {DynamicForm} pointer to the dynamicForm containing this item
     *  @param {FormItem} pointer to this item
     */
    override fun parseEditorValue(value: String, form: DynamicForm, item: FormItem): dynamic = definedExternally
    /**
     *   Convert this item's data value to a text value for display in this item's
     *   text field.
     * 
     *   If DateItem.useTextField is true, entirely custom date formatting and
     *   parsing logic may be applied via overrides to DateItem.parseEditorValue and
     *   DateItem.formatEditorValue. These methods apply to this FormItem only -
     *   system-wide Date and Datetime formatting and parsing may also be customized via
     *   the APIs on the Date class. See dateFormatAndStorage for more
     *   on this.
     * 
     *   Note: custom formatting for this item may also be achieved via the
     *   DateItem.dateFormatter which allows you to directly specify various standard
     *   date display formats.
     * 
     *  @param {any} Underlying data value to format. May be null.
     *  @param {ListGridRecord} The record currently being edited by this form.   Essentially the form's current values object.
     *  @param {DynamicForm} pointer to the DynamicForm
     *  @param {FormItem} pointer to the FormItem
     */
    override fun formatEditorValue(value: dynamic, record: ListGridRecord, form: DynamicForm, item: FormItem): String = definedExternally
    /**
     *   If DateItem.useTextField is true this method returns a
     *   standard DateInputFormat, determining how values entered
     *   by the user are to be converted to Javascript Date objects.
     * 
     *   If an explicit DateItem.inputFormat has been specified it will be returned,
     *   otherwise, if a custom DateItem.dateFormatter or FormItem.format are
     *   specified, the input format will be automatically derived from that property.
     * 
     *   Otherwise, the global DateUtil.setInputFormat is used.
     * 
     *   Note that the inputFormat will ignore any separator characters and padding of values.
     *   However if necessary entirely custom date formatting and parsing may be achieved via the
     *   DateItem.formatEditorValue and
     *   DateItem.parseEditorValue methods.
     * 
     * 
     * 
     */
    open fun getInputFormat(): String = definedExternally
    /**
     *   Returns the FiscalCalendar object that will be used by this item's DateChooser.
     * 
     * 
     */
    open fun getFiscalCalendar(): FiscalCalendar = definedExternally
    /**
     *   Sets the FiscalCalendar object that will be used by this item's DateChooser. If
     *   unset, the DateUtil.getFiscalCalendar is used.
     * 
     * 
     *  @param {FiscalCalendar=} the fiscal calendar for this chooser, if set, or the global      one otherwise
     */
    open fun setFiscalCalendar(fiscalCalendar: FiscalCalendar?): Unit = definedExternally
    /**
     *   Returns the default date to display in the date chooser if this form items value is
     *   currently unset.
     * 
     *   Default implementation returns DateItem.defaultChooserDate
     * 
     */
    open fun getDefaultChooserDate(): Date = definedExternally
    companion object {
        /**
         *  A declared value of the enum type
         *   DateItemSelectorFormat.
         *  @type {Constant}
         *  @default "DMY"
         */
        var DAY_MONTH_YEAR: String = definedExternally
        /**
         *  A declared value of the enum type
         *   DateItemSelectorFormat.
         *  @type {Constant}
         *  @default "MDY"
         */
        var MONTH_DAY_YEAR: String = definedExternally
        /**
         *  A declared value of the enum type
         *   DateItemSelectorFormat.
         *  @type {Constant}
         *  @default "YMD"
         */
        var YEAR_MONTH_DAY: String = definedExternally
        /**
         *  A declared value of the enum type
         *   DateItemSelectorFormat.
         *  @type {Constant}
         *  @default "DM"
         */
        var DAY_MONTH: String = definedExternally
        /**
         *  A declared value of the enum type
         *   DateItemSelectorFormat.
         *  @type {Constant}
         *  @default "MD"
         */
        var MONTH_DAY: String = definedExternally
        /**
         *  A declared value of the enum type
         *   DateItemSelectorFormat.
         *  @type {Constant}
         *  @default "YM"
         */
        var YEAR_MONTH: String = definedExternally
        /**
         *  A declared value of the enum type
         *   DateItemSelectorFormat.
         *  @type {Constant}
         *  @default "MY"
         */
        var MONTH_YEAR: String = definedExternally
        /**
         *  Creates a new DateItem
         * 
         *  @param typeCheckedProperties {Partial<DateItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DateItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DateItem = definedExternally
    }
}