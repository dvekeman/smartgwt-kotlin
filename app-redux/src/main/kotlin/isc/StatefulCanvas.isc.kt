@file:JsQualifier("isc")
package isc

/**
 *  A component that has a set of possible states, and which presents itself differently according to
 *   which state it is in. An example is a button, which can be "up", "down", "over" or "disabled".
 */
open external class StatefulCanvas : Canvas {
    /**
     *  The title HTML to display in this button.
     *  @type {HTMLString}
     *  @default null
     */
    open var title: String = definedExternally
    /**
     *  Should horizontal alignment-related attributes StatefulCanvas.align and StatefulCanvas.iconOrientation
     *   be mirrored in RTL mode? This is the default behavior unless ignoreRTL is set to true.
     *  @type {boolean}
     *  @default false
     */
    open var ignoreRTL: Boolean = definedExternally
    /**
     *  Whether this widget needs to redraw to reflect state change
     *  @type {boolean}
     *  @default false
     */
    open var redrawOnStateChange: Boolean = definedExternally
    /**
     *  Whether this component is selected. For some components, selection affects appearance.
     *  @type {boolean}
     *  @default false
     */
    open var selected: Boolean = definedExternally
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
    open var state: 
                    /**
                     *  state when mouse is not acting on this StatefulCanvas
                     *  state when mouse is down
                     *  state when mouse is over
                     *  disabled
                     */
                    String /*  |  Down |  Over |  Disabled */ = definedExternally
    /**
     *  Should we visibly change state when the mouse goes over this object?
     *  @type {boolean}
     *  @default false
     */
    open var showRollOver: Boolean = definedExternally
    /**
     *  Should we visibly change state when the canvas receives focus? Note that by default the
     *   over state is used to indicate focus.
     *  @deprecated \* as of SmartClient version 6.1 in favor of StatefulCanvas.showFocused
     *  @type {boolean}
     *  @default false
     */
    open var showFocus: Boolean = definedExternally
    /**
     *  Should we visibly change state when the canvas receives focus? If
     *   StatefulCanvas.showFocusedAsOver is true, then "over"
     *   will be used to indicate focus. Otherwise a separate "focused" state
     *   will be used.
     *  @type {boolean}
     *  @default false
     */
    open var showFocused: Boolean = definedExternally
    /**
     *  If StatefulCanvas.showFocused is true for this widget, should the
     *   "over" state be used to indicate the widget as focused. If set to false,
     *   a separate "focused" state will be used.
     *  @type {boolean}
     *  @default true
     */
    open var showFocusedAsOver: Boolean = definedExternally
    /**
     *  Should we visibly change state when the mouse goes down in this object?
     *  @type {boolean}
     *  @default false
     */
    open var showDown: Boolean = definedExternally
    /**
     *  Should we visibly change state when disabled?
     *  @type {boolean}
     *  @default true
     */
    open var showDisabled: Boolean = definedExternally
    /**
     *  Behavior on state changes -- BUTTON, RADIO or CHECKBOX
     *  @type {SelectionType}
     *  @default "button"
     */
    open var actionType: 
                         /**
                          *  object moves to "down" state temporarily (normal button)
                          *  object remains in "down" state until clicked again (checkbox)
                          *  object moves to "down" state, causing another object to go up (radio)
                          */
                         String /* button |  checkbox |  radio */ = definedExternally
    /**
     *  String identifier for this canvas's mutually exclusive selection group.
     *  @type {string}
     *  @default null
     */
    open var radioGroup: String = definedExternally
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
     *  @default null
     */
    open var baseStyle: String = definedExternally
    /**
     *  Horizontal alignment of this component's title.
     *  @type {Alignment}
     *  @default "center"
     */
    open var align: 
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
    open var valign: 
                     /**
                      *  At the top of the container
                      *  Center within container.
                      *  At the bottom of the container
                      */
                     String /* top |  center |  bottom */ = definedExternally
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
    open var autoFit: Boolean = definedExternally
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
    open var icon: String = definedExternally
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
    open var iconSize: Number = definedExternally
    /**
     *  Width in pixels of the icon image.
     * 
     *   If unset, defaults to StatefulCanvas.iconSize.
     *  @type {Integer}
     *  @default null
     */
    open var iconWidth: Number = definedExternally
    /**
     *  Height in pixels of the icon image.
     * 
     *   If unset, defaults to StatefulCanvas.iconSize.
     *  @type {Integer}
     *  @default null
     */
    open var iconHeight: Number = definedExternally
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
    open var iconStyle: String = definedExternally
    /**
     *  If this button is showing an icon should it appear to the left or right of the title?
     *   valid options are "left" and "right".
     *  @type {string}
     *  @default "left"
     */
    open var iconOrientation: String = definedExternally
    /**
     *  Pixels between icon and title text.
     *  @type {Integer}
     *  @default "6"
     */
    open var iconSpacing: Number = definedExternally
    /**
     *  If using an icon for this button, whether to switch the icon image if the button becomes
     *   disabled.
     *  @type {boolean}
     *  @default true
     */
    open var showDisabledIcon: Boolean = definedExternally
    /**
     *  If using an icon for this button, whether to switch the icon image on mouse rollover.
     *  @type {boolean}
     *  @default false
     */
    open var showRollOverIcon: Boolean = definedExternally
    /**
     *  If using an icon for this button, whether to switch the icon image when the mouse goes
     *   down on the button.
     *  @type {boolean}
     *  @default false
     */
    open var showDownIcon: Boolean = definedExternally
    /**
     *  If using an icon for this button, whether to switch the icon image when the button
     *   becomes selected.
     *  @type {boolean}
     *  @default false
     */
    open var showSelectedIcon: Boolean = definedExternally
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
    open var showFocusedIcon: Boolean = definedExternally
    /**
     *  Is Page.isRTL media available for the icon? If true, then in RTL mode, the
     *   image's src will have "_rtl" inserted immediately before the file extension. For example,
     *   if StatefulCanvas.icon is "myIcon.png" and showRTLIcon is true, then in RTL mode, the image's
     *   src will be set to "myIcon_rtl.png".
     *  @type {boolean}
     *  @default false
     */
    open var showRTLIcon: Boolean = definedExternally
    /**
     *  When this property is set to true, this widget will create and show the
     *   StatefulCanvas.overCanvas on user rollover.
     *  @type {boolean}
     *  @default false
     */
    open var showOverCanvas: Boolean = definedExternally
    /**
     *  Auto generated child widget to be shown when the user rolls over this canvas if
     *   StatefulCanvas.showOverCanvas is true. See documentation for AutoChild
     *   for information on how to customize this canvas.
     *  @type {Canvas}
     *  @default null
     */
    open var overCanvas: Canvas = definedExternally
    /**
     *  Constructor class name for this widget's StatefulCanvas.overCanvas
     *  @type {string}
     *  @default "Canvas"
     */
    open var overCanvasConstructor: String = definedExternally
    /**
     *  Default properties for this widgets StatefulCanvas.overCanvas. To modify
     *   these defaults, use Class.changeDefaults
     *  @type {Canvas}
     *  @default "{ ... }"
     */
    open var overCanvasDefaults: Canvas = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "StatefulCanvasEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
    /**
     *   Setter for StatefulCanvas.ignoreRTL.
     * 
     *  @param {boolean} new value for ignoreRTL.
     */
    open fun setIgnoreRTL(ignoreRTL: Boolean): Unit = definedExternally
    /**
     *   Sets the base CSS style. As the component changes state and/or is selected, suffixes will be
     *   added to the base style.
     * 
     *  @param {CSSStyleName} new base style
     */
    open fun setBaseStyle(style: String): Unit = definedExternally
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
    open fun setState(newState: 
                                /**
                                 *  state when mouse is not acting on this StatefulCanvas
                                 *  state when mouse is down
                                 *  state when mouse is over
                                 *  disabled
                                 */
                                String /*  |  Down |  Over |  Disabled */): Unit = definedExternally
    /**
     *   Return the state of this StatefulCanvas
     * 
     */
    open fun getState(): 
                         /**
                          *  state when mouse is not acting on this StatefulCanvas
                          *  state when mouse is down
                          *  state when mouse is over
                          *  disabled
                          */
                         String /*  |  Down |  Over |  Disabled */ = definedExternally
    /**
     *   Set this object to be selected or deselected.
     * 
     *  @param {boolean} new boolean value of whether or not the object is                     selected.
     */
    open fun setSelected(newIsSelected: Boolean): Unit = definedExternally
    /**
     *   Select this object.
     * 
     */
    open fun select(): Unit = definedExternally
    /**
     *   Deselect this object.
     * 
     */
    open fun deselect(): Unit = definedExternally
    /**
     *   Find out if this object is selected
     * 
     */
    open fun isSelected(): Boolean = definedExternally
    /**
     *   Return the 'actionType' for this canvas (radio / checkbox / button)
     * 
     */
    open fun getActionType(): Unit = definedExternally
    /**
     *   Update the 'actionType' for this canvas (radio / checkbox / button)
     *   If the canvas is currently selected, and the passed in actionType is 'button'
     *   this method will deselect the canvas.
     * 
     */
    open fun setActionType(): Unit = definedExternally
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
    open fun addToRadioGroup(groupID: String): Unit = definedExternally
    /**
     *   Remove this widget from the specified mutually exclusive selection group with the ID
     *   passed in.
     *   No-op's if this widget is not a member of the groupID passed in.
     *   If no groupID is passed in, defaults to removing from whatever radioGroup this widget
     *   is a member of.
     * 
     *  @param {string=} - optional radio group ID (to ensure the widget is removed                    from the appropriate group.
     */
    open fun removeFromRadioGroup(groupID: String?): Unit = definedExternally
    /**
     *   Enable or disable this object
     * 
     *  @param {boolean} true if this widget is to be disabled
     */
    override fun setDisabled(disabled: Boolean): Unit = definedExternally
    /**
     *   Returns the suffix that will be appended to the StatefulCanvas.baseStyle
     *   as the component changes StatefulCanvas.state and/or is selected / focused.
     * 
     *   The following table lists out the standard set of suffixes which may be applied
     *   to the base style:
     * 
     *   CSS Class AppliedDescription
     *   baseStyleDefault css style
     *   baseStyle+Selected
     *     Applied when StatefulCanvas.selected is set to true
     *   baseStyle+Focused
     *     Applied when the component has keyboard focus, if
     *     StatefulCanvas.showFocused is true, and
     *     StatefulCanvas.showFocusedAsOver is not true.
     *   baseStyle+Over
     *     Applied when StatefulCanvas.showRollOver is set to true and either the user
     *     rolls over the component or StatefulCanvas.showFocusedAsOver is true and the
     *     component has keyboard focus.
     *   baseStyle+Down
     *     Applied when the user presses the mouse button on the component if
     *       StatefulCanvas.showDown is set to true
     *   baseStyle+Disabled
     *     Applied when the component is Canvas.disabled
     *      if StatefulCanvas.showDisabled is true.
     *   Combined styles
     *   baseStyle+SelectedFocused
     *     Combined Selected and focused styling
     *   baseStyle+SelectedOver
     *     Combined Selected and rollOver styling
     *   baseStyle+FocusedOver
     *     Combined Focused and rollOver styling
     *   baseStyle+SelectedFocusedOver
     *     Combined Selected, Focused and rollOver styling
     *   baseStyle+SelectedDown
     *     Combined Selected and mouse-down styling
     *   baseStyle+FocusedDown
     *     Combined Focused and mouse-down styling
     *   baseStyle+SelectedFocusedDown
     *     Combined Selected, Focused and mouse-down styling
     *   baseStyle+SelectedDisabled
     *     Combined Selected and Disabled styling
     * 
     * 
     * 
     */
    open fun getStateSuffix(): String = definedExternally
    /**
     *   Changes the orientation of the icon relative to the text of the button.
     * 
     * 
     *  @param {string} The new orientation of the icon relative to the text of the button.
     */
    open fun setIconOrientation(orientation: String): Unit = definedExternally
    /**
     *   Setter method for the StatefulCanvas.autoFit property. Pass in true or false to turn
     *   autoFit on or off. When autoFit is set to false, canvas will be resized to
     *   it's previously specified size.
     * 
     *  @param {boolean} New autoFit setting.
     */
    open fun setAutoFit(autoFit: Boolean): Unit = definedExternally
    /**
     *   Return the title - HTML drawn inside the component.
     * 
     *   Default is to simply return this.title.
     * 
     */
    open fun getTitle(): String = definedExternally
    /**
     *   Setter for the StatefulCanvas.title.
     * 
     *  @param {HTMLString} the new title HTML.
     */
    open fun setTitle(newTitle: String): Unit = definedExternally
    /**
     *   Change the icon being shown next to the title text.
     * 
     *  @param {SCImgURL} URL of new icon
     */
    open fun setIcon(icon: String): Unit = definedExternally
    /**
     *   Setter for StatefulCanvas.iconStyle.
     * 
     *  @param {CSSStyleName} the new iconStyle (may be null to remove the className on the image).
     */
    open fun setIconStyle(iconStyle: String): Unit = definedExternally
    companion object {
        /**
         *  A declared value of the enum type
         *   State.
         *  @type {Constant}
         *  @default ""
         */
        var STATE_UP: String = definedExternally
        /**
         *  A declared value of the enum type
         *   State.
         *  @type {Constant}
         *  @default "Down"
         */
        var STATE_DOWN: String = definedExternally
        /**
         *  A declared value of the enum type
         *   State.
         *  @type {Constant}
         *  @default "Over"
         */
        var STATE_OVER: String = definedExternally
        /**
         *  A declared value of the enum type
         *   State.
         *  @type {Constant}
         *  @default "Disabled"
         */
        var STATE_DISABLED: String = definedExternally
        /**
         *  A declared value of the enum type
         *   SelectionType.
         *  @type {Constant}
         *  @default "button"
         */
        var BUTTON: String = definedExternally
        /**
         *  A declared value of the enum type
         *   SelectionType.
         *  @type {Constant}
         *  @default "checkbox"
         */
        var CHECKBOX: String = definedExternally
        /**
         *  A declared value of the enum type
         *   SelectionType.
         *  @type {Constant}
         *  @default "radio"
         */
        var RADIO: String = definedExternally
        /**
         *  A declared value of the enum type
         *   Selected.
         *  @type {Constant}
         *  @default "Focused"
         */
        var FOCUSED: String = definedExternally
        /**
         *  A declared value of the enum type
         *   Selected.
         *  @type {Constant}
         *  @default "Selected"
         */
        var SELECTED: String = definedExternally
        /**
         *  A declared value of the enum type
         *   Selected.
         *  @type {Constant}
         *  @default ""
         */
        var UNSELECTED: String = definedExternally
        /**
         *  Creates a new StatefulCanvas
         * 
         *  @param typeCheckedProperties {Partial<StatefulCanvas>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {StatefulCanvas} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): StatefulCanvas = definedExternally
    }
}