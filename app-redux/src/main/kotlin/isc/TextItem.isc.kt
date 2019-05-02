@file:JsQualifier("isc")
package isc

/**
 *  FormItem for managing a text field.
 */
open external class TextItem : FormItem {
    /**
     *  Default width for fields.
     *  @type {number}
     *  @default "150"
     */
    override var width: dynamic = definedExternally
    /**
     *  Default height for text items.
     *  @type {number}
     *  @default "19"
     */
    override var height: dynamic = definedExternally
    /**
     *  Base CSS class name for this item's input element.
     *   NOTE: See the CompoundFormItem_skinning discussion for special skinning considerations.
     * 
     *   For a rounded text item, you can set textBoxStyle to "roundedTextItem".
     *   This style exists only in Enterprise, EnterpriseBlue and Graphite skins. There is
     *   no corresponding rounded style for SelectItem or ComboBoxItem as this creates an
     *   awkward seam with the pop-up list (and a rounded pop-up list wouldn't help: data could
     *   not be flush to corners). For these reasons we recommend rounded inputs only in
     *   limited cases like single standalone fields.
     *  @type {FormItemBaseStyle}
     *  @default "textItem"
     */
    override var textBoxStyle: String = definedExternally
    /**
     *  If set, the maximum number of characters for this field. If
     *   TextItem.enforceLength is set to true, user input will be limited
     *   to this value, and values exceeding this length passed to
     *   FormItem.setValue will be trimmed. Otherwise values exceeding the
     *   specified length will raise an error on validation.
     * 
     *   If the item has a numeric type, like IntegerItem or
     *   FloatItem, length is applied to the raw number value, after any
     *   specified FormItem.decimalPrecision and
     *   FormItem.decimalPad but before any formatters - this means the string
     *   measured includes sign and decimal placeholder, and padded decimal places as required,
     *   but not thousands separators or any custom formatting.
     * 
     *   See also DataSourceField.length.
     *  @type {number}
     *  @default null
     */
    open var length: Number = definedExternally
    /**
     *  If a TextItem.length is specified for this item, should user input be limited
     *   to the specified length? If set to true, user input and values passed to
     *   FormItem.setValue will be trimmed to the specified length. Otherwise values
     *   exceeding the specified length will raise an error on validation.
     * 
     *   Note that having this value set to true limits user interactivity in some ways.
     *   For example users would be unable to paste a longer string into the field for
     *   editing without seeing it be truncated.
     *  @type {boolean}
     *  @default true
     */
    open var enforceLength: Boolean = definedExternally
    /**
     *  How should an empty string entered by the user be stored?
     *   This value is typically set to null or "".
     * 
     *   Note that a call to FormItem.setValue or FormItem.setValue
     *   automatically updates this property to ensure that "empty" values are stored in a
     *   consistent format.
     *  @type {any}
     *  @default null
     */
    open var emptyStringValue: dynamic = definedExternally
    /**
     *  @type {boolean}
     *  @default null
     */
    open var browserAutoCapitalize: Boolean = definedExternally
    /**
     *  In Mobile Safari, should automatic correction be offered for text in the item's text box?
     *   If null, then Mobile Safari determines automatically whether to enable
     *   autocorrect.
     * 
     *   When enabled, Mobile Safari displays "autocorrect bubbles" to suggest automatic corrections:
     * 
     *  @type {boolean}
     *  @default null
     */
    open var browserAutoCorrect: Boolean = definedExternally
    /**
     *  This property corresponds to the HTML5 "inputType" attribute applied to the &lt;input&gt;
     *   element for this TextItem.
     * 
     *   The only currently supported use of this attribute is hinting to touch-enabled mobile
     *   devices that a particular keyboard layout should be used. Even here, be careful; to
     *   take a random example, using type "number" on Android up to at least 3.2 leads to a
     *   keyboard with no "-" key, so negative numbers cannot be entered.
     * 
     *   Valid values:
     * 
     * 
     * 
     *     "text"
     *     Normal text keyboard
     * 
     * 
     *     "digits"
     *     Makes the text field more suitable for entering a string of digits 0 - 9. On iOS,
     *       this causes the virtual keyboard to show a numeric keypad with only "0", "1",
     *       "2", ..., "9", and delete keys.
     * 
     * 
     *     "email"
     *     Makes the text field more suitable for entering an e-mail address. On iOS, this
     *       causes the virtual keyboard to show special "@" and "." keys on the alphabetic
     *       keys screen.
     * 
     * 
     *     "tel"
     *     Makes the text field more suitable for entering a telephone number. On iOS, this
     *       causes the virtual keyboard to show a numeric keypad with a "+\*#" key for
     *       displaying punctuation keys.
     * 
     * 
     *     "number"
     *     Makes the text field more suitable for entering a floating-point value. On iOS,
     *       this causes the virtual keyboard to start on the number and punctuation keys screen.
     * 
     *       NOTE: This is not an appropriate text input type for credit card numbers,
     *       postal codes, ISBNs, and other formats that are not strictly parsable as floating-point
     *       numbers. This is because the browser is required to perform floating-point value
     *       sanitization to ensure that the value is a valid floating-point number.
     * 
     * 
     *     "url"
     *     Makes the text field more suitable for entering a URL. On iOS, this causes the
     *       virtual keyboard to show a special ".com" key.
     * 
     * 
     *     Any&nbsp;vendor-specific value
     *     If a browser supports another input type.
     * 
     * 
     * 
     *  @type {string}
     *  @default null
     */
    override var browserInputType: String = definedExternally
    /**
     *  Allows the DynamicForm.selectOnFocus behavior to be configured on a
     *   per-FormItem basis. Normally all items in a form default to the value of
     *   DynamicForm.selectOnFocus.
     *  @type {boolean}
     *  @default null
     */
    override var selectOnFocus: Boolean = definedExternally
    /**
     *  Allows the DynamicForm.selectOnClick behavior to be configured on a
     *   per-FormItem basis. Normally all items in a form default to the value of
     *   DynamicForm.selectOnClick.
     *  @type {boolean}
     *  @default null
     */
    override var selectOnClick: Boolean = definedExternally
    /**
     *  Should this form item fire its FormItem.change handler (and store its
     *   value in the form) on every keypress? Set to false to suppress the 'change'
     *   handler firing (and the value stored) on every keypress.
     * 
     *   Note: If false, the value returned by FormItem.getValue
     *   will not reflect the value displayed in the form item element as long as focus is in
     *   the form item element.
     *  @type {boolean}
     *  @default true
     */
    override var changeOnKeypress: Boolean = definedExternally
    /**
     *  Does the current formItem support native cut and paste events?
     * 
     *   This attribute only applies to freeform text entry fields such as TextItem and
     *   TextAreaItem, and only if TextItem.changeOnKeypress is true.
     *   If true, developers can detect the user editing the value
     *   via cut or paste interactions (triggered from keyboard shortcuts or the native
     *   browser menu options) using the FormItem.isCutEvent and
     *   FormItem.isPasteEvent methods. This allows custom cut/paste handling
     *   to be added to the various change notification flow methods including
     *   FormItem.change, method:FormItem.handleChange and
     *   FormItem.transformInput.
     *  @type {boolean}
     *  @default true
     */
    override var supportsCutPasteEvents: Boolean = definedExternally
    /**
     *  If this form item has a specified FormItem.optionDataSource, should the
     *   item ever perform a fetch against this dataSource to retrieve the related record.
     * 
     *   Note that for editable textItems, behavior differs slightly than for other
     *   item types as we will not issue fetches unless FormItem.alwaysFetchMissingValues has
     *   been set to true.
     *   See TextItem.shouldFetchMissingValue for more details.
     *  @type {boolean}
     *  @default true
     */
    override var fetchMissingValues: Boolean = definedExternally
    /**
     *  If FormItem.showHint, should the hint be shown within the field?
     * 
     *   Unless the HTML5 placeholder attribute is used to display the hint (see TextItem.usePlaceholderForHint),
     *   the value of the data element will be set to the hint
     *   whenever this item is not focused. Also, when displaying the hint, the CSS style of the
     *   data element will be set to the TextItem.textBoxStyle with the suffix
     *   "Hint" appended to it; or, if the item is disabled, the suffix "DisabledHint" will be used.
     *   In Page.isRTL when FormItem.showRTL is true,
     *   an additional "RTL" suffix will be appended; i.e. the CSS style of the data element when
     *   the hint is displayed will be the textBoxStyle plus "HintRTL" or "DisabledHintRTL".
     * 
     *   To change this attribute after being drawn, it is necessary to call FormItem.redraw
     *   or redraw the form.
     * 
     *   Styling the in-field hint
     *   The in-field hint can be styled with CSS for the textBoxStyle + "Hint" /
     *   "HintRTL" / "DisabledHint" / "DisabledHintRTL" styles. For example, if this item's
     *   textBoxStyle is set to "mySpecialItem", then changing the hint color to
     *   blue can be accomplished with the following CSS:
     *   .mySpecialItemHint,
     *  .mySpecialItemHintRTL,
     *  .mySpecialItemDisabledHint,
     *  .mySpecialItemDisabledHintRTL {
     *    color: blue;
     *  }
     *  @type {boolean}
     *  @default null
     */
    open var showHintInField: Boolean = definedExternally
    /**
     *  If TextItem.showHintInField and if supported by the browser, should the HTML5
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
     *  When generating a print-view of the component containing this TextItem, should
     *   the form item expand to accommodate its value? If set to false the text box will not expand
     *   to fit its content in the print view, instead showing exactly as it does in the
     *   live form.
     *  @type {boolean}
     *  @default false
     */
    open var printFullText: Boolean = definedExternally
    /**
     *  Text items will submit their containing form on enter keypress
     *   if DynamicForm.saveOnEnter is true. Setting this property to
     *   false will disable this behavior.
     *  @type {boolean}
     *  @default true
     */
    override var saveOnEnter: Boolean = definedExternally
    /**
     *  By default HTML characters will be escaped when FormItem.canEdit is false and
     *   FormItem.readOnlyDisplay is "static", so that the raw value of the field (for
     *   example "&lt;b&gt;AAA&lt;/b&gt;") is displayed to the user rather than
     *   the interpreted HTML (for example "AAA"). Setting
     *   escapeHTML false will instead force HTML values in a textItem to be
     *   interpreted by the browser in that situation.
     *  @type {boolean}
     *  @default true
     */
    open var escapeHTML: Boolean = definedExternally
    /**
     *  This attribute currently only has an effect in Internet Explorer.
     *   That browser will dynamically add a native "clear" icon to
     *   &lt;input type="text" &gt; elements when the user enters a value.
     *   Setting suppressBrowserClearIcon to true
     *   will write out HTML to suppress this icon. This can be particularly useful for
     *   items which define their own clear icon as in
     *   ${isc.DocUtils.linkForExampleId('inlineFormIcons', 'this sample')}.
     * 
     *   If this property is not set at the item level,
     *   DynamicForm.suppressBrowserClearIcons will be used instead.
     * 
     *   Note that as an alternative to using this feature, the icon may also be suppressed
     *   (or have other styling applied to it) directly via CSS, using the
     *   ::-ms-clear css pseudo-element (proprietary Internet Explorer feature).
     * 
     *   Implementation note: This feature makes use of the automatically generated
     *   TextItem.suppressClearIconClassName css class.
     *  @type {boolean}
     *  @default null
     */
    open var suppressBrowserClearIcon: Boolean = definedExternally
    /**
     *  Should entered characters be converted to upper or lowercase?
     *   Also applies to values applied with FormItem.setValue.
     * 
     *   Note: character casing cannot be used at the same time as a TextItem.mask.
     *  @type {CharacterCasing}
     *  @default "default"
     */
    open var characterCasing: 
                              /**
                               *  No character translation
                               *  Map characters to uppercase
                               *  Map characters to lowercase
                               */
                              String /* default |  upper |  lower */ = definedExternally
    /**
     *  Sets a keypress filter regular expression to limit valid characters
     *   that can be entered by the user. If defined, keys that match the
     *   regular expression are allowed; all others are suppressed. The
     *   filter is applied after character casing, if defined.
     * 
     *   Note: keypress filtering cannot be used at the same time as a TextItem.mask.
     *  @type {string}
     *  @default null
     */
    open var keyPressFilter: String = definedExternally
    /**
     *  With formatOnBlur enabled, this textItem will format its value
     *   according to the rules described in FormItem.mapValueToDisplay as long as the
     *   item does not have focus. Once the user puts focus into the item
     *   the formatter will be removed. This provides a simple way for developers to
     *   show a nicely formatted display value in a freeform text field, without the need
     *   for an explicit FormItem.formatEditorValue
     *   and FormItem.parseEditorValue pair.
     *  @type {boolean}
     *  @default false
     */
    open var formatOnBlur: Boolean = definedExternally
    /**
     *  Should FormItem.formatEditorValue re-run whenever this item recieves or loses focus?
     *   Setting this property allows developers to conditionally format the display value based on
     *   item.hasFocus, typically to display a longer, more informative string while the item does
     *   not have focus, and simplifying it down to an easier-to-edit string when the user puts
     *   focus into the item.
     *  @type {boolean}
     *  @default false
     */
    open var formatOnFocusChange: Boolean = definedExternally
    /**
     *  Input mask used to filter text entry.
     * 
     *   Sample masks:
     * 
     * 
     *  - Phone number: (###) ###-####
     * 
     *  - Social Security number: ###-##-####
     * 
     *  - First name: &gt;?&lt;??????????
     * 
     *  - Date: ##/##/####
     * 
     *  - State: &gt;LL
     * 
     *   Overview of available mask characters
     * 
     * 
     *   CharacterDescription
     *   0Digit (0 through 9) or plus [+] or minus [-] signs
     *   9Digit or space
     *   #Digit
     *   LLetter (A through Z)
     *   ?Letter (A through Z) or space
     *   ALetter or digit
     *   aLetter or digit
     *   CAny character or space
     *   &nbsp;
     *   &lt;Causes all characters that follow to be converted to lowercase
     *   &gt;Causes all characters that follow to be converted to uppercase
     * 
     * 
     *   Any character not matching one of the above mask characters or that is escaped
     *   with a backslash (\) is considered to be a literal.
     * 
     *   Custom mask characters can be defined by standard regular expression character set
     *   or range. For example, a hexadecimal color code mask could be:
     * 
     * 
     *  - Color: \#>[0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F]
     * 
     * 
     *   Note: input mask cannot be used at the same time as a TextItem.keyPressFilter.
     *   Also note that this property is not supported for
     *   ComboBoxItem or SpinnerItem, or for items with TextItem.browserInputType
     *   set to "digits" or "number".
     *  @type {string}
     *  @default null
     */
    open var mask: String = definedExternally
    /**
     *  During entry into masked field, should keystrokes overwrite current position value?
     *   By default new keystrokes are inserted into the field.
     *  @type {boolean}
     *  @default null
     */
    open var maskOverwriteMode: Boolean = definedExternally
    /**
     *  Should entered mask value be saved with embedded literals?
     *  @type {boolean}
     *  @default null
     */
    open var maskSaveLiterals: Boolean = definedExternally
    /**
     *  Character that is used to fill required empty mask positions
     *   to display text while control has no focus.
     *  @type {string}
     *  @default " "
     */
    open var maskPadChar: String = definedExternally
    /**
     *  Character that is used to fill required empty mask positions
     *   to display text while control has focus.
     *  @type {string}
     *  @default "_"
     */
    open var maskPromptChar: String = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "TextItemEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
    /**
     *   Returns the hint text for this item. Default implementation returns FormItem.hint, or
     *   null if there is no hint to show.
     * 
     * 
     */
    open fun getHint(): String = definedExternally
    /**
     *   For text-based items, this method returns the indices of the start/end of the current
     *   selection if the item currently has the focus. In browsers other than Internet Explorer 6-9,
     *   if this item does not have focus, then this method returns the indices of the start/end
     *   of the selection the last time that this item had focus. In IE 6-9, returns null if the
     *   item does not have focus.
     * 
     *   In all browsers, clicking anywhere outside of the item causes the item to lose focus;
     *   hence, in IE 6-9, this method will not work in other components' event handlers for
     *   certain events. For example, within the Canvas.click handler of a button,
     *   this item will have already lost focus, so in IE 6-9, this method will return null
     *   if called within the button's click() handler. One cross-browser solution to this issue
     *   is to save the selection range for later in a Canvas.mouseDown or
     *   Canvas.mouseOver handler.
     * 
     *   Notes:
     * 
     * 
     *  - In browsers other than IE 6-9, calling FormItem.setValue
     *   or otherwise changing the TextItem.getEnteredValue invalidates the past
     *   selection range.
     * 
     *  - The returned indices are indices within the entered value rather than the item's
     *   value as returned by FormItem.getValue.
     *   The distinction is particularly important for TextAreaItems because browsers
     *   normalize the line endings in the &lt;textarea&gt; element's value.
     *   Internet Explorer 6, 7, and 8 convert line endings to "\r\n" while other browsers
     *   convert line endings to "\n"
     *   as specified by the HTML5 standard.
     * 
     * 
     */
    open fun getSelectionRange(): Array<dynamic> = definedExternally
    /**
     *   Puts focus into this form item and selects characters between the given indices.
     *   Only applies to drawn text based items.
     * 
     *  @param {Integer} selection starting character index
     *  @param {Integer} end of selection character index
     */
    open fun setSelectionRange(start: Number, end: Number): Unit = definedExternally
    /**
     *   Put focus in this item and select the entire value.
     *   Only applies to text based items
     * 
     */
    open fun selectValue(): Unit = definedExternally
    /**
     *   If this item currently has focus, clear the current selection. leaving focus in the item.
     *   Has no effect if the item is undrawn or unfocused.
     *   Only applies to text-based items.
     * 
     *  @param {boolean=} By default the text insertion cursor will be moved to the end of the  current value - pass in this parameter to move to the start instead
     */
    open fun deselectValue(start: Boolean?): Unit = definedExternally
    /**
     *   If this field has a specified FormItem.optionDataSource, should we perform a fetch against
     *   that dataSource to find the record that matches this field's value?
     * 
     *   For textItems this method will return false if the item is
     *   FormItem.canEdit unless FormItem.alwaysFetchMissingValues is true, even
     *   if there is a specified FormItem.displayField.
     *   We do this as, for a freeform text-entry field with a specified displayField, the
     *   correct behavior when the user enters an unrecognized value is somewhat ambiguous.
     *   The user could have entered a complete display-field value, in which case it
     *   might be appropriate to issue a fetch against the display-field of the optionDataSource,
     *   and set the underlying item value.
     *   If a match was not found though, we necessarily treat the entered value as the new "dataValue"
     *   for the field. Should we then issue a second fetch against the optionDataSource comparing
     *   the user-entered value with the value-field of the dataSource?
     * 
     *   There are still cases where it could make sense to issue the fetch against the dataSource,
     *   and developers who want this behavior can set FormItem.alwaysFetchMissingValues to true.
     * 
     *   See FormItem.shouldFetchMissingValue for how this method behaves for other
     *   item types.
     * 
     * 
     *  @param {any} The new data value of the item.
     */
    override fun shouldFetchMissingValue(newValue: dynamic): Boolean = definedExternally
    /**
     *   Setter for the TextItem.suppressBrowserClearIcon
     * 
     *  @param {boolean} new value for suppressBrowserClearIcon
     */
    open fun setSuppressBrowserClearIcon(newValue: Boolean): Unit = definedExternally
    /**
     *   Returns the raw text value that currently appears in the text field, which can differ from
     *   FormItem.getValue in various cases - for example:
     * 
     * 
     *  - for items that constrain the value range, such as a DateItem with
     *   DateItem.enforceDate:true, or a ComboBoxItem with
     *   ComboBoxItem.addUnknownValues:false
     * 
     *  - for items with a defined valueMap or edit value formatter and parser functions
     *   which converts display value to data value
     * 
     *  - while the item has focus if TextItem.changeOnKeypress is false
     * 
     * 
     */
    open fun getEnteredValue(): String = definedExternally
    /**
     *   Set the TextItem.keyPressFilter for this item
     * 
     *  @param {string} new keyPress filter for the item
     */
    open fun setKeyPressFilter(filter: String): Unit = definedExternally
    /**
     *   Notification fired in response to a clipboard "paste" event on freeform text
     *   items, giving developers an opportunity to reformat the pasted text. The
     *   pastedValue argument contains the text pasted from the clipboard.
     *   This method should return the text value to actually insert into the input element.
     * 
     * 
     *  @param {FormItem} Item into which the user pasted a value
     *  @param {DynamicForm} Pointer to the item's form
     *  @param {string} Pasted text value
     */
    open fun transformPastedValue(item: FormItem, form: DynamicForm, pastedValue: String): String = definedExternally
    /**
     *   Set the mask for this item. Pass null to clear an existing mask.
     * 
     *   Note that the current value of the field is cleared when changing the mask.
     * 
     *  @param {string} mask to apply to text item
     */
    open fun setMask(mask: String): Unit = definedExternally
    /**
     *   Notification method called when FormItem.showPending is enabled and
     *   this text item should either clear or show its pending visual state.
     * 
     *   The default behavior is that the FormItem.titleStyle,
     *   FormItem.cellStyle, and TextItem.textBoxStyle are
     *   updated to include/exclude the "Pending" suffix. Returning false will cancel
     *   this default behavior.
     * 
     *  @param {DynamicForm} the managing DynamicForm instance.
     *  @param {FormItem} the form item itself (also available as "this").
     *  @param {boolean} true if the item should show its pending visual state; false otherwise.
     *  @param {any} the current form item value.
     *  @param {any} the value that would be restored by a call to DynamicForm.resetValues.
     */
    override fun pendingStatusChanged(form: DynamicForm, item: FormItem, pendingStatus: Boolean, newValue: dynamic, value: dynamic): Boolean = definedExternally
    companion object {
        /**
         *  A declared value of the enum type
         *   CharacterCasing.
         *  @type {Constant}
         *  @default "default"
         */
        var DEFAULT: String = definedExternally
        /**
         *  A declared value of the enum type
         *   CharacterCasing.
         *  @type {Constant}
         *  @default "upper"
         */
        var UPPER: String = definedExternally
        /**
         *  A declared value of the enum type
         *   CharacterCasing.
         *  @type {Constant}
         *  @default "lower"
         */
        var LOWER: String = definedExternally
        /**
         *  Reserved css className applied to TextItem &lt;input &gt; elements where
         *   TextItem.suppressBrowserClearIcon is true.
         * 
         *   Note that this is an advanced property and in most cases developers do not need to
         *   be aware of it. The style definition for this style-name will be
         *   generated automatically with appropriate css content to suppress the browser
         *   clear icon. It is documented only so that developers are aware that this css className
         *   (and can choose a different name in the extremely rare case where this name has
         *   meaning within their application code).
         *  @type {string}
         *  @default "isc_suppressClearIcon"
         */
        var suppressClearIconClassName: String = definedExternally
        /**
         *  Creates a new TextItem
         * 
         *  @param typeCheckedProperties {Partial<TextItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {TextItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): TextItem = definedExternally
    }
}