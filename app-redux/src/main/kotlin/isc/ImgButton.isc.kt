@file:JsQualifier("isc")
package isc

/**
 *  A Img that behaves like a button, going through up/down/over state transitions in response to
 *   user events. Supports an optional title, and will auto-size to accommodate the title text if
 *   overflow is set to "visible".
 * 
 *   Example uses are Window minimize/close buttons.
 */
open external class ImgButton : Img {
    /**
     *  The title HTML to display in this button.
     *  @type {HTMLString}
     *  @default null
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
     *  @default "imgButton"
     */
    override var baseStyle: String = definedExternally
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
     *  Should we visibly change state when the canvas receives focus? Note that by default the
     *   over state is used to indicate focus.
     *  @deprecated \* as of SmartClient version 6.1 in favor of StatefulCanvas.showFocused
     *  @type {boolean}
     *  @default false
     */
    override var showFocus: Boolean = definedExternally
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
     *  Determines whether any specified StatefulCanvas.getTitle will be
     *   displayed for this component.
     *   Applies to Image-based components only, where the title will be rendered out in a label
     *   floating over the component
     *  @type {boolean}
     *  @default false
     */
    override var showTitle: Boolean = definedExternally
    /**
     *  Horizontal padding to be applied to this widget's label. If this value is null,
     *   the label will be given a horizontal padding of zero.
     * 
     *   The specified amount of padding is applied to the left and right edges of the button, so
     *   the total amount of padding is 2x the specified value.
     *  @type {number}
     *  @default null
     */
    open var labelHPad: Number = definedExternally
    /**
     *  Vertical padding to be applied to this widget's label. If this value is null,
     *   the label will be given a vertial padding of zero.
     * 
     *   The specified amount of padding is applied to the top and bottom edges of the button, so
     *   the total amount of padding is 2x the specified value.
     *  @type {number}
     *  @default null
     */
    open var labelVPad: Number = definedExternally
    /**
     *  The base filename for the image.
     * 
     *   This value will be combined with any specified StatefulCanvas.state
     *   to form a combined URL, changing the appearance of the component as the
     *   state changes.
     * 
     *   The following table lists out the standard set of combined URLs that
     *   may be generated. Subclasses may support additional state-derived media of course.
     *   Note that the src URL will be split such that the extension is always applied to the
     *   end of the combined string. For example in the following table, if src
     *   was set to "blank.gif", the Selected+Focused URL would be
     *   "blank_Selected_Focused.gif".
     * 
     *   URL for Img sourceDescription
     *   src+extensionDefault URL
     *   src+"_Selected"+extension
     *     Applied when StatefulCanvas.selected is set to true
     *   src+"_Focused"+extension
     *     Applied when the component has keyboard focus, if
     *     StatefulCanvas.showFocused is true, and
     *     StatefulCanvas.showFocusedAsOver is not true.
     *   src+"_Over"+extension
     *     Applied when the user rolls over the component if
     *       StatefulCanvas.showRollOver is set to true
     *   src+"_Down"+extension
     *     Applied when the user presses the mouse button over over the component if
     *       StatefulCanvas.showDown is set to true
     *   src+"_Disabled"+extension
     *     Applied to Canvas.disabled component
     *      if StatefulCanvas.showDisabled is true.
     *   Combined states
     *   src+"_Selected_Focused"+extension
     *     Combined Selected and focused state
     *   src+"_Selected_Over"+extension
     *     Combined Selected and rollOver state
     *   src+"_Focused_Over"+extension
     *     Combined Focused and rollOver state
     *   src+"_Selected_Focused_Over"+extension
     *     Combined Selected, Focused and rollOver state
     *   src+"_Selected_Down"+extension
     *     Combined Selected and mouse-down state
     *   src+"_Focused_Down"+extension
     *     Combined Focused and mouse-down state
     *   src+"_Selected_Focused_Down"+extension
     *     Combined Selected, Focused and mouse-down state
     *   src+"_Selected_Disabled"+extension
     *     Combined Selected and Disabled state
     * 
     *  @type {SCImgURL}
     *  @default "[SKIN]/ImgButton/button.png"
     */
    override var src: String = definedExternally
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
     *   Returns the HTML that is displayed by the default ImgButton.titleHover
     *   handler. Return null or an empty string to cancel the hover.
     * 
     * 
     *  @param {HTMLString} the HTML that would have been displayed by default
     */
    open fun titleHoverHTML(defaultHTML: String): String = definedExternally
    /**
     *   Optional stringMethod to fire when the user hovers over this button and the title is
     *   clipped. If ImgButton.showClippedTitleOnHover is true, the default behavior is to
     *   show a hover canvas containing the HTML returned by ImgButton.titleHoverHTML.
     *   Return false to suppress this default behavior.
     * 
     */
    open fun titleHover(): Boolean = definedExternally
    companion object {
        /**
         *  Creates a new ImgButton
         * 
         *  @param typeCheckedProperties {Partial<ImgButton>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ImgButton} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ImgButton = definedExternally
    }
}