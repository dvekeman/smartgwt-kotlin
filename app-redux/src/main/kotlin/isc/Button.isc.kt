@file:JsQualifier("isc")
package isc

/**
 *  The Button widget class implements interactive, style-based button widgets.
 */
open external class Button : StatefulCanvas {
    /**
     *  The title HTML to display in this button.
     *  @type {HTMLString}
     *  @default "Untitled Button"
     */
    override var title: String = definedExternally
    /**
     *  If set to true, if the StatefulCanvas.title of this button contains the
     *   specified Canvas.accessKey, when the title is displayed to the user
     *   it will be modified to include HTML to underline the accessKey.
     *   Note that this property may cause titles that include HTML (rather than simple strings)
     *   to be inappropriately modified, so should be disabled if your title string includes
     *   HTML characters.
     *  @type {boolean}
     *  @default null
     */
    open var hiliteAccessKey: Boolean = definedExternally
    /**
     *  If true and the title is clipped, then a hover containing the full title of this button
     *   is enabled.
     *  @type {boolean}
     *  @default false
     */
    open var showClippedTitleOnHover: Boolean = definedExternally
    /**
     *  Optional icon to be shown with the button title text.
     * 
     *   Specify as the partial URL to an image, relative to the imgDir of this component.
     *   A sprited image can be specified using the SCSpriteConfig format.
     * 
     *   Note that the string "blank" is a valid setting for this attribute and will always
     *   result in the system blank image, with no state suffixes applied. Typically, this
     *   might be used when an iconStyle is also specified and the iconStyle renders the icon via
     *   a stateful background-image or other CSS approach.
     *  @type {SCImgURL}
     *  @default null
     */
    override var icon: String = definedExternally
    /**
     *  Size in pixels of the icon image.
     * 
     *   The StatefulCanvas.iconWidth and StatefulCanvas.iconHeight
     *   properties can be used to configure width and height separately.
     * 
     *   Note: When configuring the properties of a StatefulCanvas (or derivative)
     *   AutoChild, it is best to set the iconWidth and iconHeight
     *   to the same value rather than setting an iconSize. This is because certain
     *   skins or customizations thereto might set the iconWidth and iconHeight,
     *   making the customization of the AutoChild's iconSize ineffective.
     *  @type {Integer}
     *  @default "16"
     */
    override var iconSize: Number = definedExternally
    /**
     *  Width in pixels of the icon image.
     * 
     *   If unset, defaults to StatefulCanvas.iconSize.
     *  @type {Integer}
     *  @default null
     */
    override var iconWidth: Number = definedExternally
    /**
     *  Height in pixels of the icon image.
     * 
     *   If unset, defaults to StatefulCanvas.iconSize.
     *  @type {Integer}
     *  @default null
     */
    override var iconHeight: Number = definedExternally
    /**
     *  Base CSS style applied to the icon image. If set, as the StatefulCanvas changes
     *   StatefulCanvas.state and/or is StatefulCanvas.selected,
     *   suffixes will be appended to iconStyle to form the className set on the
     *   image element.
     * 
     *   The following table lists out the standard set of suffixes which may be appended:
     * 
     *   CSS Class AppliedDescription
     *   iconStyleDefault CSS style
     *   iconStyle+Selected
     *     Applied when StatefulCanvas.selected and StatefulCanvas.showSelectedIcon
     *     are true.
     *   iconStyle+Focused
     *     Applied when the component has keyboard focus, if
     *     StatefulCanvas.showFocusedIcon is true, and
     *     StatefulCanvas.showFocusedAsOver is not true.
     *   iconStyle+Over
     *     Applied when StatefulCanvas.showRollOverIcon is set to true and either
     *     the user rolls over the component or StatefulCanvas.showFocusedAsOver is true
     *     and the component has keyboard focus.
     *   iconStyle+Down
     *     Applied when the user presses the mouse button on the component if
     *       StatefulCanvas.showDownIcon is set to true
     *   iconStyle+Disabled
     *     Applied when the component is Canvas.disabled
     *      if StatefulCanvas.showDisabledIcon is true.
     *   Combined styles
     *   iconStyle+SelectedFocused
     *     Combined Selected and focused styling
     *   iconStyle+SelectedOver
     *     Combined Selected and rollOver styling
     *   iconStyle+FocusedOver
     *     Combined Focused and rollOver styling
     *   iconStyle+SelectedFocusedOver
     *     Combined Selected, Focused and rollOver styling
     *   iconStyle+SelectedDown
     *     Combined Selected and mouse-down styling
     *   iconStyle+FocusedDown
     *     Combined Focused and mouse-down styling
     *   iconStyle+SelectedFocusedDown
     *     Combined Selected, Focused and mouse-down styling
     *   iconStyle+SelectedDisabled
     *     Combined Selected and Disabled styling
     * 
     * 
     *   In addition, if StatefulCanvas.showRTLIcon is true, then in RTL mode, a final
     *   "RTL" suffix will be appended.
     *  @type {CSSStyleName}
     *  @default null
     */
    override var iconStyle: String = definedExternally
    /**
     *  If this button is showing an icon should it appear to the left or right of the title?
     *   valid options are "left" and "right".
     *  @type {string}
     *  @default "left"
     */
    override var iconOrientation: String = definedExternally
    /**
     *  If this button is showing an icon should it be right or left aligned?
     *  @type {string}
     *  @default null
     */
    open var iconAlign: String = definedExternally
    /**
     *  Pixels between icon and title text.
     *  @type {Integer}
     *  @default "6"
     */
    override var iconSpacing: Number = definedExternally
    /**
     *  If using an icon for this button, whether to switch the icon image if the button becomes
     *   disabled.
     *  @type {boolean}
     *  @default true
     */
    override var showDisabledIcon: Boolean = definedExternally
    /**
     *  If using an icon for this button, whether to switch the icon image on mouse rollover.
     *  @type {boolean}
     *  @default false
     */
    override var showRollOverIcon: Boolean = definedExternally
    /**
     *  Specifies the cursor to display when the mouse pointer is over the icon image.
     *  @type {Cursor}
     *  @default null
     */
    open var iconCursor: 
                         /**
                          *  Use the default arrow cursor for this browser/OS.
                          *  Use the default cursor for this element type in this                browser/OS
                          *  Use the wait cursor.
                          *  Use the hand cursor.
                          *  Use the "move" (crosshairs) cursor.
                          *  Use the 'help' cursor.
                          *  Use the 'text' (i-beam) cursor.
                          *  Use the normal hand pointer that appears when you hover                over a link
                          *  Use the 'crosshair' ( + ) cursor.
                          *  Use the column resize cursor (horizontal double-tipped arrow)
                          *  Use the row resize cursor (vertical double-tipped arrow)
                          *  Use the "east resize" cursor.
                          *  Use the "west resize" cursor.
                          *  Use the "north resize" cursor.
                          *  Use the "south resize" cursor.
                          *  Use the "south-east resize" cursor.
                          *  Use the "north-east resize" cursor.
                          *  Use the "north-west resize" cursor.
                          *  Use the "south-west resize" cursor.
                          *  Use the "not-allowed" cursor.
                          */
                         String /* default |  auto |  wait |  hand |  move |  help |  text |  pointer |  arrow |  all-scroll |  crosshair |  col-resize |  row-resize |  e-resize |  w-resize |  n-resize |  s-resize |  se-resize |  ne-resize |  nw-resize |  sw-resize |  not-allowed */ = definedExternally
    /**
     *  Specifies the cursor to display when the mouse pointer is over the icon image and this
     *   StatefulCanvas is Canvas.disabled.
     * 
     *   If not set and the mouse pointer is over the icon image, Button.iconCursor
     *   will be used.
     *  @type {Cursor}
     *  @default null
     */
    open var disabledIconCursor: 
                                 /**
                                  *  Use the default arrow cursor for this browser/OS.
                                  *  Use the default cursor for this element type in this                browser/OS
                                  *  Use the wait cursor.
                                  *  Use the hand cursor.
                                  *  Use the "move" (crosshairs) cursor.
                                  *  Use the 'help' cursor.
                                  *  Use the 'text' (i-beam) cursor.
                                  *  Use the normal hand pointer that appears when you hover                over a link
                                  *  Use the 'crosshair' ( + ) cursor.
                                  *  Use the column resize cursor (horizontal double-tipped arrow)
                                  *  Use the row resize cursor (vertical double-tipped arrow)
                                  *  Use the "east resize" cursor.
                                  *  Use the "west resize" cursor.
                                  *  Use the "north resize" cursor.
                                  *  Use the "south resize" cursor.
                                  *  Use the "south-east resize" cursor.
                                  *  Use the "north-east resize" cursor.
                                  *  Use the "north-west resize" cursor.
                                  *  Use the "south-west resize" cursor.
                                  *  Use the "not-allowed" cursor.
                                  */
                                 String /* default |  auto |  wait |  hand |  move |  help |  text |  pointer |  arrow |  all-scroll |  crosshair |  col-resize |  row-resize |  e-resize |  w-resize |  n-resize |  s-resize |  se-resize |  ne-resize |  nw-resize |  sw-resize |  not-allowed */ = definedExternally
    /**
     *  If using an icon for this button, whether to switch the icon image when the button
     *   receives focus.
     * 
     *   If StatefulCanvas.showFocusedAsOver is true, the "Over" icon will be
     *   displayed when the canvas has focus, otherwise a separate "Focused" icon
     *   will be displayed
     *  @type {boolean}
     *  @default false
     */
    override var showFocusedIcon: Boolean = definedExternally
    /**
     *  If using an icon for this button, whether to switch the icon image when the mouse goes
     *   down on the button.
     *  @type {boolean}
     *  @default false
     */
    override var showDownIcon: Boolean = definedExternally
    /**
     *  If using an icon for this button, whether to switch the icon image when the button
     *   becomes selected.
     *  @type {boolean}
     *  @default false
     */
    override var showSelectedIcon: Boolean = definedExternally
    /**
     *  If true, ignore the specified size of this widget and always size just large
     *   enough to accommodate the title. If setWidth() is explicitly called on an
     *   autoFit:true button, autoFit will be reset to false.
     * 
     *   Note that for StretchImgButton instances, autoFit will occur horizontally only, as
     *   unpredictable vertical sizing is likely to distort the media. If you do want vertical
     *   auto-fit, this can be achieved by simply setting a small height, and having
     *   overflow:"visible"
     *  @type {boolean}
     *  @default null
     */
    override var autoFit: Boolean = definedExternally
    /**
     *  Base CSS style className applied to the component.
     * 
     *   As the component changes StatefulCanvas.state and/or is selected,
     *   suffixes will be added to the base style. In some cases more than one suffix will
     *   be appended to reflect a combined state ("Selected" + "Disabled", for example).
     * 
     *   See StatefulCanvas.getStateSuffix for a description of the default set
     *   of suffixes which may be applied to the baseStyle
     *  @type {CSSStyleName}
     *  @default "button"
     */
    override var baseStyle: String = definedExternally
    /**
     *  if defined, iconOnlyBaseStyle is used as the base CSS style className,
     *   instead of Button.baseStyle, if Button.canAdaptWidth is set and the title is not being
     *   shown.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var iconOnlyBaseStyle: String = definedExternally
    /**
     *  Whether this component is selected. For some components, selection affects appearance.
     *  @type {boolean}
     *  @default false
     */
    override var selected: Boolean = definedExternally
    /**
     *  String identifier for this canvas's mutually exclusive selection group.
     *  @type {string}
     *  @default null
     */
    override var radioGroup: String = definedExternally
    /**
     *  Behavior on state changes -- BUTTON, RADIO or CHECKBOX
     *  @type {SelectionType}
     *  @default "button"
     */
    override var actionType: 
                             /**
                              *  object moves to "down" state temporarily (normal button)
                              *  object remains in "down" state until clicked again (checkbox)
                              *  object moves to "down" state, causing another object to go up (radio)
                              */
                             String /* button |  checkbox |  radio */ = definedExternally
    /**
     *  Current "state" of this widget. The state setting is automatically updated as the
     *   user interacts with the component (see StatefulCanvas.showRollOver,
     *   StatefulCanvas.showDown, StatefulCanvas.showDisabled).
     * 
     *   StatefulCanvases will have a different appearance based
     *   on their current state.
     *   By default this is handled by changing the css className applied to
     *   the StatefulCanvas - see StatefulCanvas.baseStyle and
     *   StatefulCanvas.getStateSuffix for a description of how this is done.
     * 
     *   For Img or StretchImg based subclasses of StatefulCanvas, the
     *   appearance may also be updated by changing the src of the rendered image. See
     *   Img.src and StretchImgButton.src for a description of how the URL
     *   is modified to reflect the state of the widget in this case.
     *  @type {State}
     *  @default ""
     */
    override var state: 
                        /**
                         *  state when mouse is not acting on this StatefulCanvas
                         *  state when mouse is down
                         *  state when mouse is over
                         *  disabled
                         */
                        String /*  |  Down |  Over |  Disabled */ = definedExternally
    /**
     *  Should we visibly change state when disabled?
     *  @type {boolean}
     *  @default true
     */
    override var showDisabled: Boolean = definedExternally
    /**
     *  Should we visibly change state when the mouse goes down in this object?
     *  @type {boolean}
     *  @default false
     */
    override var showDown: Boolean = definedExternally
    /**
     *  Should we visibly change state when the canvas receives focus? If
     *   StatefulCanvas.showFocusedAsOver is true, then "over"
     *   will be used to indicate focus. Otherwise a separate "focused" state
     *   will be used.
     *  @type {boolean}
     *  @default false
     */
    override var showFocused: Boolean = definedExternally
    /**
     *  Should we visibly change state when the mouse goes over this object?
     *  @type {boolean}
     *  @default false
     */
    override var showRollOver: Boolean = definedExternally
    /**
     *  Horizontal alignment of this component's title.
     *  @type {Alignment}
     *  @default "center"
     */
    override var align: 
                        /**
                         *  Center within container.
                         *  Stick to left side of container.
                         *  Stick to right side of container.
                         */
                        String /* center |  left |  right */ = definedExternally
    /**
     *  Vertical alignment of this component's title.
     *  @type {VerticalAlignment}
     *  @default "center"
     */
    override var valign: 
                         /**
                          *  At the top of the container
                          *  Center within container.
                          *  At the bottom of the container
                          */
                         String /* top |  center |  bottom */ = definedExternally
    /**
     *  A boolean indicating whether the button's title should word-wrap, if necessary.
     *  @type {boolean}
     *  @default false
     */
    open var wrap: Boolean = definedExternally
    /**
     *  If enabled, the button will collapse to show just its icon when showing the title would
     *   cause overflow of a containing Layout. While collapsed, the button will show its title
     *   on hover, unless an explicit hover has been specified such as by overriding
     *   Button.titleHoverHTML.
     *  @type {boolean}
     *  @default false
     */
    override var canAdaptWidth: Boolean = definedExternally
    /**
     *  Clip the contents of the button if necessary.
     *  @type {Overflow}
     *  @default "hidden"
     */
    override var overflow: 
                           /**
                            *  Content that extends beyond the widget's width or height is               displayed.
                            *                 Note: To have the content be sized only by the drawn size of
                            *                 the content set the overflow to be Canvas.VISIBLE and specify
                            *                 a small size, allowing the size to expand to the size required
                            *                 by the content.
                            *                 Leaving the width / height for the widget undefined will use the
                            *                 default value of 100, and setting the size to zero may cause the
                            *                 widget not to draw.
                            *  Content that extends beyond the widget's width or height is               clipped (hidden).
                            *  Horizontal and/or vertical scrollbars are displayed only if               necessary. Content that extends beyond the remaining visible
                            *                 area is clipped.
                            *  Horizontal and vertical scrollbars are always drawn inside the               widget. Content that extends beyond the remaining visible area
                            *                 is clipped, and can be accessed via scrolling.
                            *  Clip horizontally but extend the canvas's clip region               vertically if necessary. Note: only supported for
                            *                 specific widget subclasses.
                            *  Clip vertically but extend the canvas's clip region               horizontally if necessary. Note: only supported
                            *                 for specific widget subclasses.
                            */
                           String /* visible |  hidden |  auto |  scroll |  clip-h |  clip-v */ = definedExternally
    /**
     *   Return the title - HTML drawn inside the component.
     * 
     *   Default is to simply return this.title.
     * 
     */
    override fun getTitle(): String = definedExternally
    /**
     *   Setter for the StatefulCanvas.title.
     * 
     *  @param {HTMLString} the new title HTML.
     */
    override fun setTitle(newTitle: String): Unit = definedExternally
    /**
     *   Changes the orientation of the icon relative to the text of the button.
     * 
     * 
     *  @param {string} The new orientation of the icon relative to the text of the button.
     */
    override fun setIconOrientation(orientation: String): Unit = definedExternally
    /**
     *   Change the icon being shown next to the title text.
     * 
     *  @param {SCImgURL} URL of new icon
     */
    override fun setIcon(icon: String): Unit = definedExternally
    /**
     *   Setter method for the StatefulCanvas.autoFit property. Pass in true or false to turn
     *   autoFit on or off. When autoFit is set to false, canvas will be resized to
     *   it's previously specified size.
     * 
     *  @param {boolean} New autoFit setting.
     */
    override fun setAutoFit(autoFit: Boolean): Unit = definedExternally
    /**
     *   Sets the base CSS style. As the component changes state and/or is selected, suffixes will be
     *   added to the base style.
     * 
     *  @param {CSSStyleName} new base style
     */
    override fun setBaseStyle(style: String): Unit = definedExternally
    /**
     *   Select this object.
     * 
     */
    override fun select(): Unit = definedExternally
    /**
     *   Select this object.
     * 
     */
    override fun deselect(): Unit = definedExternally
    /**
     *   Find out if this object is selected
     * 
     */
    override fun isSelected(): Boolean = definedExternally
    /**
     *   Select this object.
     * 
     */
    open fun setSelected(): Unit = definedExternally
    /**
     *   Add this widget to the specified mutually exclusive selection group with the ID
     *   passed in.
     *   Selecting this widget will then deselect any other StatefulCanvases with the same
     *   radioGroup ID.
     *   StatefulCanvases can belong to only one radioGroup, so this method will remove from
     *   any other radiogroup of which this button is already a member.
     * 
     *  @param {string} - ID of the radiogroup to which this widget should be added
     */
    override fun addToRadioGroup(groupID: String): Unit = definedExternally
    /**
     *   Remove this widget from the specified mutually exclusive selection group with the ID
     *   passed in.
     *   No-op's if this widget is not a member of the groupID passed in.
     *   If no groupID is passed in, defaults to removing from whatever radioGroup this widget
     *   is a member of.
     * 
     *  @param {string=} - optional radio group ID (to ensure the widget is removed                    from the appropriate group.
     */
    override fun removeFromRadioGroup(groupID: String?): Unit = definedExternally
    /**
     *   Update the 'actionType' for this canvas (radio / checkbox / button)
     *   If the canvas is currently selected, and the passed in actionType is 'button'
     *   this method will deselect the canvas.
     * 
     */
    override fun setActionType(): Unit = definedExternally
    /**
     *   Return the 'actionType' for this canvas (radio / checkbox / button)
     * 
     */
    override fun getActionType(): Unit = definedExternally
    /**
     *   Sets the StatefulCanvas.state of this object, changing its appearance.
     *   Note: newState cannot be
     *   "Disabled"
     * 
     *   if StatefulCanvas.showDisabled is false.
     * 
     * 
     *  @param {State} the new state.
     */
    override fun setState(newState: 
                                    /**
                                     *  state when mouse is not acting on this StatefulCanvas
                                     *  state when mouse is down
                                     *  state when mouse is over
                                     *  disabled
                                     */
                                    String /*  |  Down |  Over |  Disabled */): Unit = definedExternally
    /**
     *   Enable or disable this object
     * 
     *  @param {boolean} true if this widget is to be disabled
     */
    override fun setDisabled(disabled: Boolean): Unit = definedExternally
    /**
     *   Return the state of this StatefulCanvas
     * 
     */
    override fun getState(): 
                             /**
                              *  state when mouse is not acting on this StatefulCanvas
                              *  state when mouse is down
                              *  state when mouse is over
                              *  disabled
                              */
                             String /*  |  Down |  Over |  Disabled */ = definedExternally
    /**
     *   This property contains the default 'action' for the Button to fire when activated.
     * 
     */
    open fun action(): Unit = definedExternally
    /**
     *   Is the title of this button clipped?
     * 
     */
    open fun titleClipped(): Boolean = definedExternally
    /**
     *   Returns the HTML that is displayed by the default Button.titleHover
     *   handler. Return null or an empty string to cancel the hover.
     * 
     * 
     *  @param {HTMLString} the HTML that would have been displayed by default
     */
    open fun titleHoverHTML(defaultHTML: String): String = definedExternally
    /**
     *   Set whether the title of this button should be allowed to wrap if too long for the button's
     *   specified width.
     * 
     * 
     *  @param {boolean} whether to wrap the title
     */
    open fun setWrap(newWrap: Boolean): Unit = definedExternally
    /**
     *   Sets the (horizontal) alignment of this buttons content.
     * 
     */
    open fun setAlign(): Unit = definedExternally
    /**
     *   Sets the vertical alignment of this buttons content.
     * 
     */
    open fun setVAlign(): Unit = definedExternally
    /**
     *   If this button is showing an Button.icon, a separate click handler for the
     *   icon may be defined as this.iconClick.
     *   Returning false will suppress the standard button click handling code.
     * 
     */
    open fun iconClick(): Boolean = definedExternally
    /**
     *   Optional stringMethod to fire when the user hovers over this button and the title is
     *   clipped. If Button.showClippedTitleOnHover is true, the default behavior is to
     *   show a hover canvas containing the HTML returned by Button.titleHoverHTML.
     *   Return false to suppress this default behavior.
     * 
     */
    open fun titleHover(): Boolean = definedExternally
    companion object {
        /**
         *  Creates a new Button
         * 
         *  @param typeCheckedProperties {Partial<Button>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Button} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Button = definedExternally
    }
}