@file:JsQualifier("isc")
package isc

/**
 *  Class for editable multi-line text areas (uses HTML &lt;TEXTAREA&gt; object)
 */
open external class TextAreaItem : FormItem {
    /**
     *  Text wrapping style.
     *  @type {TEXTAREA_WRAP}
     *  @default "SOFT"
     */
    open var wrap: 
                   /**
                    *  don't allow wrapping at all
                    *  when the entered text reaches the edge of the text area,                 wrap visibly but don't include line breaks in the textarea
                    *                   value
                    *  when the entered text reaches the edge of the text area,                  insert a line break
                    */
                   String /* OFF |  SOFT |  HARD */ = definedExternally
    /**
     *  default width of this item
     *  @type {number}
     *  @default "150"
     */
    override var width: dynamic = definedExternally
    /**
     *  Default height of this item
     * 
     *   Note that when item is rendered as read-only with readOnlyDisplay as "static"
     *   the property FormItem.staticHeight is used instead.
     *  @type {number}
     *  @default "100"
     */
    override var height: dynamic = definedExternally
    /**
     *  TextAreaItem has an explicit pickerIconHeight as we don't want the picker icon, if shown,
     *   to size itself to match the height of the item.
     *  @type {Integer}
     *  @default "20"
     */
    override var pickerIconHeight: Number = definedExternally
    /**
     *  Height of the FormItem when canEdit is false and
     *   readOnlyDisplay is "static". The normal TextAreaItem.height is used
     *   if this property is not set.
     *  @type {Integer}
     *  @default "1"
     */
    override var staticHeight: Number = definedExternally
    /**
     *  Base CSS class to apply to this item's input element.
     *   NOTE: See the CompoundFormItem_skinning discussion for special skinning considerations.
     *  @type {FormItemBaseStyle}
     *  @default "textItem"
     */
    override var textBoxStyle: String = definedExternally
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
     *  If set, maximum number of characters for this field. If TextAreaItem.enforceLength is
     *   set to true, user input will be limited to this value, and values exceeding this
     *   length passed to FormItem.setValue will be trimmed. Otherwise values exceeding the
     *   specified length will raise an error on validation.
     * 
     *   See also DataSourceField.length.
     *  @type {number}
     *  @default null
     */
    open var length: Number = definedExternally
    /**
     *  If a TextAreaItem.length is specified for this item, should user input be limited
     *   to the specified length? If set to true, user input and values passed to
     *   FormItem.setValue will be trimmed to the specified length. Otherwise values
     *   exceeding the specified length will raise an error on validation.
     * 
     *   Note that having this value set to true limits user interactivity in some ways.
     *   For example users would be unable to paste a longer string into the field for
     *   editing without seeing it be truncated. Given how text areas are typically
     *   used to edit longer values than non-wrapping TextItems, this value is
     *   false by default for textAreaItems.
     *  @type {boolean}
     *  @default false
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
     *  Align icons with the top edge of text area icons by default.
     *  @type {VerticalAlignment}
     *  @default "top"
     */
    override var iconVAlign: 
                             /**
                              *  At the top of the container
                              *  Center within container.
                              *  At the bottom of the container
                              */
                             String /* top |  center |  bottom */ = definedExternally
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
     *   TextAreaItem, and only if TextAreaItem.changeOnKeypress is true.
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
     *  If FormItem.showHint, should the hint be shown within the field?
     * 
     *   Unless the HTML5 placeholder attribute is used to display the hint (see TextAreaItem.usePlaceholderForHint),
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
     *  If TextAreaItem.showHintInField and if supported by the browser, should the HTML5
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
     *  When generating a print-view of the component containing this TextArea, should
     *   the form item expand to accommodate its value? If set to false the text box not expand
     *   to fit its content in the print view, instead showing exactly as it does in the
     *   live form, possibly with scrollbars.
     *  @type {boolean}
     *  @default true
     */
    open var printFullText: Boolean = definedExternally
    /**
     *  By default HTML characters will be escaped when FormItem.canEdit is false and
     *   FormItem.readOnlyDisplay is "static", so that the raw value of the field (for
     *   example "&lt;b&gt;AAA&lt;/b&gt;") is displayed to the user rather than
     *   the interpreted HTML (for example "AAA"). Setting
     *   escapeHTML false will instead force HTML values in a textAreaItem to be
     *   interpreted by the browser in that situation.
     *  @type {boolean}
     *  @default true
     */
    open var escapeHTML: Boolean = definedExternally
    /**
     *  Minimum valid height for this TextAreaItem in px. If the specified TextAreaItem.height
     *   is less than this value, the text area will still render at this height.
     *  @type {Integer}
     *  @default "16"
     */
    open var minHeight: Number = definedExternally
    /**
     *  With formatOnBlur enabled, this textAreaItem will format its value
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
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "TextAreaItemEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
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
     *   or otherwise changing the TextAreaItem.getEnteredValue invalidates the past
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
    companion object {
        /**
         *  A declared value of the enum type
         *   TEXTAREA_WRAP.
         *  @type {Constant}
         *  @default "OFF"
         */
        var OFF: String = definedExternally
        /**
         *  A declared value of the enum type
         *   TEXTAREA_WRAP.
         *  @type {Constant}
         *  @default "SOFT"
         */
        var SOFT: String = definedExternally
        /**
         *  A declared value of the enum type
         *   TEXTAREA_WRAP.
         *  @type {Constant}
         *  @default "HARD"
         */
        var HARD: String = definedExternally
        /**
         *  Creates a new TextAreaItem
         * 
         *  @param typeCheckedProperties {Partial<TextAreaItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {TextAreaItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): TextAreaItem = definedExternally
    }
}