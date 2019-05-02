@file:JsQualifier("isc")
package isc

/**
 *  Form item icon descriptor objects used by Form Items to specify the appearance and
 *   behavior of icons displayed after the item in the page flow.
 */
open external class FormItemIcon {
    /**
     *  Base CSS style. If set, as the component changes state and/or is focused, suffixes
     *   will be added to the base style. Possible suffixes include "Over" if the user mouses
     *   over the icon and FormItemIcon.showOver is true, "Disabled" if
     *   the icon is disabled, and "Focused". In addition, if FormItemIcon.showRTL
     *   is enabled, then an "RTL" suffix will be added.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var baseStyle: String = definedExternally
    /**
     *  Identifier for this form item icon. This identifier (if set) should be unique
     *   within this form item and may be used to get a pointer to the icon object
     *   via FormItem.getIcon.
     *  @type {Identifier}
     *  @default null
     */
    open var name: String = definedExternally
    /**
     *  When set, this icon is rendered inside the FormItem.textBoxStyle area
     *   of the FormItem (where input occurs in a TextItem, TextAreaItem or
     *   ComboBoxItem) as opposed to as a trailing icon.
     * 
     *   Use FormItemIcon.inlineIconAlign to control alignment of the
     *   icon. Multiple icons can be inlined on both the left and right side of the
     *   textBox area. FormItemIcon.hspace is honored for spacing
     *   between multiple adjacent icons.
     * 
     *   Inline icons are not supported in Internet Explorer 6, or when the FormItem
     *   is not a TextItem, TextAreaItem or ComboBoxItem.
     *   When unsupported, the icon will fall back to non-inline mode.
     * 
     *   The FormItem.showPickerIcon, if any, cannot be inlined.
     * 
     *   As an alternative to displaying an image, an inline icon may display a string of
     *   HTML instead. See FormItemIcon.text.
     *  @type {boolean}
     *  @default false
     */
    open var inline: Boolean = definedExternally
    /**
     *  Horizontal alignment for icons marked FormItemIcon.inline.
     * 
     *   By default, the first icon that specifies inline is aligned left, and the second and all
     *   subsequent icons to the right. "center" alignment is invalid and will be
     *   ignored.
     * 
     *   In RTL mode, the alignment is automatically mirrored; inlineIconAlign:"left"
     *   results in the icon being placed on the right and inlineIconAlign:"right"
     *   results in the icon being placed on the left.
     *  @type {Alignment}
     *  @default null
     */
    open var inlineIconAlign: 
                              /**
                               *  Center within container.
                               *  Stick to left side of container.
                               *  Stick to right side of container.
                               */
                              String /* center |  left |  right */ = definedExternally
    /**
     *  If set, this property determines this icon's image source.
     *   If unset the form item's defaultIconSrc property will be used
     *   instead.
     *   As with defaultIconSrc this URL will be modified by adding
     *   "_Over" or "_Disabled" if appropriate to show the icon's over or disabled state.
     *   If FormItemIcon.showRTL is enabled, then "_rtl" will be added to the
     *   source URL before the extension.
     * 
     *   The special value "blank" means that no image will be shown for this icon. This
     *   is particularly useful together with FormItemIcon.baseStyle to implement
     *   spriting of the different icon states.
     * 
     *   For an FormItemIcon.inline FormItemIcon,
     *   FormItemIcon.text may be specified to show a string of HTML instead of
     *   an image.
     * 
     *   skinning can be used for this image, by setting this property to
     *   a SCSpriteConfig formatted string.
     *  @type {SCImgURL}
     *  @default null
     */
    open var src: String = definedExternally
    /**
     *  As an alternative to displaying an image, an FormItemIcon.inline
     *   FormItemIcon can display a string of HTML where the icon's image would
     *   have appeared. This enables advanced customizations such as using text, icon font symbols,
     *   Unicode dingbats and emoji, and/or SVG in place of an image.
     * 
     *   Setting an inline icon's text property will cause the HTML to be used instead of an
     *   image, as long as the browser and form item support inline icons.
     * 
     *   This property only has an effect on inline icons. If the inline property is false,
     *   or the browser or form item does not support inline icons, then the image specified
     *   by FormItemIcon.src (or the form item's FormItem.defaultIconSrc)
     *   will be used.
     * 
     *   Typically, the HTML is styled via FormItemIcon.baseStyle.
     * 
     *   Auto-sizing of the HTML is not supported; the HTML will be clipped to the icon's
     *   FormItemIcon.width and FormItemIcon.height.
     *  @type {HTMLString}
     *  @default null
     */
    open var text: String = definedExternally
    /**
     *  Should this icon's image and/or FormItemIcon.baseStyle switch to the
     *   appropriate "Over" value when the user rolls over or focuses on the icon?
     * 
     *   Note if FormItem.showOver is true and FormItemIcon.showOverWhen
     *   is set to "textBox", this icon will show over state when the user rolls over the
     *   text box (or control table, if visible) for the item. This is most commonly used
     *   for FormItemIcon.inline icons.
     *  @type {boolean}
     *  @default null
     */
    open var showOver: Boolean = definedExternally
    /**
     *  If FormItemIcon.showOver or FormItem.showOverIcons is true,
     *   this property may be set to customize when the 'over' styling is applied to
     *   the item. If unset, rollover styling will be applied when the user is over
     *   the icon only.
     *  @type {IconOverTrigger}
     *  @default null
     */
    open var showOverWhen: 
                           /**
                            *  Show rollover styling and media when the user is over the icon only
                            *  Show rollover styling and media when the user is over the icon or over the textBox (or control-table, if present) for this icon. Only has
                            *   an effect when FormItem.showOver is true.
                            */
                           String /* icon |  textBox */ = definedExternally
    /**
     *  Should this icon's image and/or FormItemIcon.baseStyle switch to the
     *   appropriate "Focused" value when the user puts focus on the form item or icon?
     *  @type {boolean}
     *  @default null
     */
    open var showFocused: Boolean = definedExternally
    /**
     *  Should this icon's FormItemIcon.src and/or FormItemIcon.baseStyle
     *   switch to the appropriate RTL value when the FormItem is in RTL mode? If true, then
     *   the image URL for all states will have "_rtl" added before the extension. Also, if
     *   baseStyle is set, all style names will have an "RTL" suffix. This should only be
     *   enabled if RTL media is available.
     * 
     *   For example, if an icon's src is "[SKINIMG]formItemIcons/myFormIcon.png" and the baseStyle
     *   is "myFormIcon", then in the "Down" state, SmartClient will use "[SKINIMG]formItemIcons/myFormIcon_Down_rtl.png"
     *   for the image source and "myFormIconDownRTL" for the style name.
     *  @type {boolean}
     *  @default null
     */
    open var showRTL: Boolean = definedExternally
    /**
     *  If this icon will be updated to show focus (see FormItemIcon.showFocused,
     *   FormItem.showFocusedIcons), this property governs whether the focused state should
     *   be shown when the item as a whole receives focus or just if the icon receives focus.
     *   If this property is unset, default behavior is to show focused state when the item
     *   receives focus.
     *  @type {boolean}
     *  @default null
     */
    open var showFocusedWithItem: Boolean = definedExternally
    /**
     *  If icon.neverDisable is true, when this form item is disabled, the
     *   icon will remain enabled.
     *   Note that disabling the entire form will disable all items, together with their
     *   icons including those marked as neverDisable - this property only has an effect
     *   if the form is enabled and a specific item is disabled within it.
     * 
     *   If this property is true, the icons will also remain enabled if a form item
     *   is marked as FormItem.canEdit. For finer grained control over
     *   whether icons are enabled for read-only icons see FormItem.disableIconsOnReadOnly
     *   and FormItemIcon.disableOnReadOnly
     *  @type {boolean}
     *  @default null
     */
    open var neverDisable: Boolean = definedExternally
    /**
     *  If FormItem.canEdit is set to false, should this icon be disabled.
     *   If unset this is determined by FormItem.disableIconsOnReadOnly.
     *   Note that if FormItemIcon.neverDisable is set to true, the icons will
     *   be rendered enabled regardless of this setting and whether the item is editable.
     *  @type {boolean}
     *  @default null
     */
    open var disableOnReadOnly: Boolean = definedExternally
    /**
     *  Whether this icon is disabled. Can be updated at runtime via the FormItem.setIconDisabled
     *   method. Note that if the formItem containing this icon is disabled, the icon will
     *   behave in a disabled manner regardless of the setting of the icon.disabled property.
     *  @type {boolean}
     *  @default null
     */
    open var disabled: Boolean = definedExternally
    /**
     *  Criteria to be evaluated to determine whether this icon should appear enabled.
     * 
     *   Criteria are evaluated against the ${isc.DocUtils.linkForRef('method:DynamicForm.getValues','form\'s current values')} as well as
     *   the current Canvas.ruleScope. Criteria are re-evaluated every time
     *   form values or the rule context changes, whether by end user action or by programmatic calls.
     * 
     *   A basic criteria uses textMatchStyle:"exact". When specified in
     *   componentXML this property allows
     *   xmlCriteriaShorthand for defining criteria.
     * 
     *   Note: A FormItemIcon using enableWhen must have a FormItem.name defined on
     *   its FormItem.
     *  @type {AdvancedCriteria}
     *  @default null
     */
    open var enableWhen: AdvancedCriteria = definedExternally
    /**
     *  TabIndex for this formItemIcon.
     * 
     *   Set to -1 to remove the icon from the tab order, but be cautious doing so: if the
     *   icon triggers important application functionality that cannot otherwise be accessed
     *   via the keyboard, it would be a violation of accessibility standard to remove the
     *   icon from the tab order.
     * 
     *   Any usage other than setting to -1 is extremely advanced in the same way as using
     *   FormItem.globalTabIndex.
     *  @type {Integer}
     *  @default null
     */
    open var tabIndex: Number = definedExternally
    /**
     *  If set, this property determines the width of this icon in px.
     *     If unset the form item's iconWidth property will be used instead.
     *  @type {number}
     *  @default null
     */
    open var width: dynamic = definedExternally
    /**
     *  If set, this property determines the height of this icon in px.
     *     If unset the form item's iconHeight property will be used instead.
     *  @type {number}
     *  @default null
     */
    open var height: dynamic = definedExternally
    /**
     *  If set, this property will be displayed as a prompt (and tooltip text) for this form
     *   item icon.
     * 
     *   If unset the form item's iconPrompt property will be used instead.
     *  @type {HTMLString}
     *  @default null
     */
    open var prompt: String = definedExternally
    /**
     *  Show this icon when its item gets focus, and hide it when it loses focus. If
     *   non-null, overrides the default behavior specified by
     *   FormItem.showIconsOnFocus or FormItem.showPickerIconOnFocus, as
     *   appropriate. This feature allows space to be saved in the form for items not being
     *   interacted with, and helps draw attention to the item currently in focus.
     *  @type {boolean}
     *  @default null
     */
    open var showOnFocus: Boolean = definedExternally
    /**
     *  If show-on-focus behavior is enabled for this icon via FormItemIcon.showOnFocus
     *   or related properties at the item level, and this icon is marked as disabled,
     *   should it be shown on focus? If unset, will be derived from the
     *   FormItem.showDisabledIconsOnFocus or
     *   FormItem.showDisabledPickerIconOnFocus settings.
     *  @type {boolean}
     *  @default null
     */
    open var showDisabledOnFocus: Boolean = definedExternally
    /**
     *  If set, this property determines the number of pixels space to be displayed on
     *   the left of this form item icon, or for FormItemIcon.inline icons
     *   whose FormItemIcon.inlineIconAlign is
     *   "left",
     * 
     *   on the right of this form item icon. Must be non-negative.
     *   If unset, the form item's FormItem.iconHSpace will be used instead.
     *  @type {Integer}
     *  @default null
     */
    open var hspace: Number = definedExternally
    /**
     *  Criteria to be evaluated to determine whether this icon should be visible.
     * 
     *   Criteria are evaluated against the ${isc.DocUtils.linkForRef('method:DynamicForm.getValues','form\'s current values')} as well as
     *   the current Canvas.ruleScope. Criteria are re-evaluated every time
     *   form values or the rule context changes, whether by end user action or by programmatic calls.
     * 
     *   A basic criteria uses textMatchStyle:"exact". When specified in
     *   componentXML this property allows
     *   xmlCriteriaShorthand for defining criteria.
     * 
     *   Note: A FormItemIcon using visibleWhen must have a FormItem.name defined on
     *   its FormItem.
     *  @type {AdvancedCriteria}
     *  @default null
     */
    open var visibleWhen: AdvancedCriteria = definedExternally
    /**
     *  For PickList items with PickListItemIconPlacement set such that the pickList does
     *   not render near-origin, should this icon be rendered inline within
     *   the formItem itself, or within the ComboBoxItem.pickerNavigationBar.
     * 
     *   If not explicitly specified at the icon level, this will be picked up from
     *   PickList.iconPlacement.
     * 
     *   For mobile browsing with limited available screen space, icons rendered in
     *   the navigation bar may be easier for the user to interact with.
     *  @type {PickListItemIconPlacement}
     *  @default null
     */
    open var iconPlacement: 
                            /**
                             *  icon will be displayed in the ComboBoxItem.pickerNavigationBar only (and not rendered
                             *   inline within the formItem itself)
                             *  icon will be displayed inline within the form item itself (and not within the
                             *   ComboBoxItem.pickerNavigationBar
                             *  icon will be displayed both inline (within the form item itself) and within the
                             *   ComboBoxItem.pickerNavigationBar
                             */
                            String /* pickerNavigationBar |  formItem |  both */ = definedExternally
    /**
     *   Click handler for this icon.
     * 
     * 
     *   Return false to cancel this event.
     * 
     * 
     *   If this event is not cancelled by the icon-level click handler, it may also
     *   be handled at the FormItem level via FormItem.pickerIconClick [for the
     *   picker icon only], and then FormItem.iconClick
     * 
     * 
     *  @param {DynamicForm} The Dynamic Form to which this icon's item belongs.
     *  @param {FormItem} The Form Item containing this icon
     *  @param {FormItemIcon} A pointer to the form item icon clicked
     */
    open fun click(form: DynamicForm, item: FormItem, icon: FormItemIcon): Boolean = definedExternally
    /**
     *     StringMethod action to fire when this icon has focus and receives a keypress
     *     event.
     *     If unset the form item's iconKeyPress method will be fired instead
     *     (if specified).
     * 
     *  @param {KeyName} Name of the key pressed
     *  @param {string} character produced by the keypress
     *  @param {DynamicForm} The Dynamic Form to which this icon's item belongs.
     *  @param {FormItem} The Form Item containing this icon
     *  @param {FormItemIcon} A pointer to the form item icon
     */
    open fun keyPress(keyName: String, character: String, form: DynamicForm, item: FormItem, icon: FormItemIcon): Unit = definedExternally
    /**
     *   If specified, icon.showIf will be evaluated when the form item is
     *   drawn or redrawn. Return true if the icon should be visible, or false if it
     *   should be hidden. Note that if FormItem.showIcon or FormItem.hideIcon
     *   is called, this method will be overridden.
     * 
     *  @param {DynamicForm} the DynamicForm in which the icon is embedded
     *  @param {FormItem} the item to which this icon is attached.
     */
    open fun showIf(form: DynamicForm, item: FormItem): Boolean = definedExternally
}