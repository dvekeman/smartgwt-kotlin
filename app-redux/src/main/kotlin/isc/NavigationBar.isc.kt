@file:JsQualifier("isc")
package isc

/**
 *  Navigation control implemented as a horizontal layout showing back and forward controls
 *   and a title.
 */
open external class NavigationBar : HLayout {
    /**
     *  Whether to animate a change of the view state via NavigationBar.setViewState.
     * 
     *   Enabling animation of state changes does have a performance impact because more components
     *   need to be created by the NavigationBar to implement the animated transitions.
     *   It is therefore recommended to leave animateStateChanges at its default value
     *   of false unless NavigationBar.setViewState might be called on this
     *   NavigationBar instance and animation is desired.
     * 
     *   Note also that when animation is enabled, certain AutoChild defaults and properties may
     *   be used to create other AutoChildren that are internal to the animation implementation. This
     *   generally does not cause an issue unless certain non-UI event handlers are added to the
     *   defaults and/or properties (e.g. Canvas.visibilityChanged, Canvas.resized).
     *   For those types of handlers, a check should be added to make sure that the handler is
     *   running for the expected component.
     *  @type {boolean}
     *  @default false
     */
    open var animateStateChanges: Boolean = definedExternally
    /**
     *  Button.title for the NavigationBar.leftButton.
     *  @type {HTMLString}
     *  @default null
     */
    open var leftButtonTitle: String = definedExternally
    /**
     *  Short title to display for the left button title if there is not enough room to show the title
     *   for the navigation bar. Setting to null or an empty string ("") will avoid a shortened
     *   title ever being used. See NavigationBar.title for a full description.
     *  @type {HTMLString}
     *  @default "Back"
     */
    open var shortLeftButtonTitle: String = definedExternally
    /**
     *  If set, the left button title will never be omitted in an attempt to fit the full title.
     *   See the documentation of NavigationBar.title for details.
     *  @type {boolean}
     *  @default false
     */
    open var alwaysShowLeftButtonTitle: Boolean = definedExternally
    /**
     *  Button.icon for the NavigationBar.leftButton.
     *  @type {SCImgURL}
     *  @default "[SKIN]back_arrow.png"
     */
    open var leftButtonIcon: String = definedExternally
    /**
     *  If set to false, then the NavigationBar.leftButton is not shown.
     *  @type {boolean}
     *  @default null
     */
    open var showLeftButton: Boolean = definedExternally
    /**
     *  The button displayed to the left of the title in this NavigationBar. By default this
     *   will be a NavigationButton with NavigationButton.direction set
     *   to
     *   "back".
     * 
     * 
     *   The following autoChildUsage apply:
     * 
     * 
     *  - NavigationBar.leftButtonTitle for Button.title
     * 
     *  - NavigationBar.leftButtonIcon for Button.icon
     * 
     *  @type {NavigationButton}
     *  @default null
     */
    open var leftButton: NavigationButton = definedExternally
    /**
     *  The title to display in the center of this navigation bar.
     * 
     *   If there is not enough room for the title with the current titles of the
     *   NavigationBar.leftButton and NavigationBar.rightButton buttons,
     *   space will be used as follows:
     * 
     * 
     *  - if the title can be fully visible without clipping if it is placed slightly off-center, it
     *   will be placed off-center, up to a maximum of NavigationBar.maxCenterOffset pixels
     * 
     *  - if that's not enough space, if a NavigationBar.shortLeftButtonTitle
     *   is provided, it will be used in lieu of the normal left button title
     * 
     *  - if that's still not enough space, the title of the left button will be hidden, leaving
     *   only the icon. This will be skipped if either NavigationBar.alwaysShowLeftButtonTitle
     *   has been set or the button has no icon, which would leave the space blank.
     * 
     *  - if that's still not enough space, the title text will be clipped, showing an ellipsis
     *   (where browser support allows this)
     * 
     *  @type {HTMLString}
     *  @default null
     */
    open var title: String = definedExternally
    /**
     *  Maximum amount in pixels that the title will be placed off center in an effort to avoid
     *   clipping it - see NavigationBar.title.
     *  @type {Integer}
     *  @default "40"
     */
    open var maxCenterOffset: Number = definedExternally
    /**
     *  The AutoChild label used to display the NavigationBar.title in this
     *   NavigationBar.
     *  @type {Label}
     *  @default null
     */
    open var titleLabel: Label = definedExternally
    /**
     *  Button.title for the NavigationBar.rightButton.
     *  @type {HTMLString}
     *  @default "&amp;nbsp;"
     */
    open var rightButtonTitle: String = definedExternally
    /**
     *  Button.icon for the NavigationBar.rightButton.
     *  @type {SCImgURL}
     *  @default null
     */
    open var rightButtonIcon: String = definedExternally
    /**
     *  If set to false, then the NavigationBar.rightButton is not shown.
     *  @type {boolean}
     *  @default null
     */
    open var showRightButton: Boolean = definedExternally
    /**
     *  The button displayed to the right of the title in this NavigationBar. By default this
     *   will be a NavigationButton with NavigationButton.direction set
     *   to "forward".
     * 
     *   The following autoChildUsage apply:
     * 
     * 
     *  - NavigationBar.rightButtonTitle for Button.title
     * 
     *  - NavigationBar.rightButtonIcon for Button.icon
     * 
     *  @type {NavigationButton}
     *  @default null
     */
    open var rightButton: NavigationButton = definedExternally
    /**
     *  AutoChild of type MiniNavControl. Not shown by default (see
     *   NavigationBar.showMiniNavControl). Also, if a
     *   NavigationBar.customNavControl is provided, then the
     *   customNavControl is used instead of an automatically created
     *   miniNavControl.
     *  @type {MiniNavControl}
     *  @default null
     */
    open var miniNavControl: MiniNavControl = definedExternally
    /**
     *  If set to false, then the NavigationBar.miniNavControl
     *   is not shown.
     *  @type {boolean}
     *  @default false
     */
    open var showMiniNavControl: Boolean = definedExternally
    /**
     *  Placement of MiniNavControl, if present:
     * 
     * 
     *  - "right" alignment places the miniNav on the far right
     * 
     *  - "center" alignment places the miniNav in the center, or to the right of the title
     *      if the title is present
     * 
     *  - "left" alignment will place the miniNav on the left, or to the right of the
     *      NavigationBar.leftButton if its present.
     * 
     *  @type {Alignment}
     *  @default "right"
     */
    open var miniNavAlign: 
                           /**
                            *  Center within container.
                            *  Stick to left side of container.
                            *  Stick to right side of container.
                            */
                           String /* center |  left |  right */ = definedExternally
    /**
     *  An arbitrary component that will be placed where the NavigationBar.miniNavControl
     *   AutoChild would normally be placed (see NavigationBar.miniNavAlign).
     *  @type {Canvas}
     *  @default null
     */
    open var customNavControl: Canvas = definedExternally
    /**
     *   Updates the NavigationBar.title for this NavigationBar.
     * 
     *  @param {HTMLString} new title HTML.
     */
    open fun setTitle(newTitle: String): Unit = definedExternally
    /**
     *   Setter for NavigationBar.leftButtonTitle.
     * 
     *  @param {HTMLString} new title HTML for the left button.
     */
    open fun setLeftButtonTitle(newTitle: String): Unit = definedExternally
    /**
     *   Setter for NavigationBar.shortLeftButtonTitle.
     * 
     * 
     *  @param {HTMLString} new short title HTML.
     */
    open fun setShortLeftButtonTitle(newShortLeftButtonTitle: String): Unit = definedExternally
    /**
     *   Setter for NavigationBar.alwaysShowLeftButtonTitle.
     * 
     * 
     *  @param {boolean} new value for alwaysShowLeftButtonTitle.
     */
    open fun setAlwaysShowLeftButtonTitle(newAlwaysShowLeftButtonTitle: Boolean): Unit = definedExternally
    /**
     *   Setter for NavigationBar.leftButtonIcon.
     * 
     *  @param {SCImgURL} new icon for left button.
     */
    open fun setLeftButtonIcon(newIcon: String): Unit = definedExternally
    /**
     *   Show or hide the NavigationBar.leftButton. The leftButton
     *   must be a control of this NavigationBar or else it will
     *   still be hidden.
     * 
     *  @param {boolean} if false, then the leftButton will be hidden. If unset or true then the leftButton will be shown as long as it is a member of the controls array.
     */
    open fun setShowLeftButton(show: Boolean): Unit = definedExternally
    /**
     *   Setter for NavigationBar.rightButtonTitle.
     * 
     *  @param {HTMLString} new title HTML for the right button.
     */
    open fun setRightButtonTitle(newTitle: String): Unit = definedExternally
    /**
     *   Setter for NavigationBar.rightButtonIcon.
     * 
     *  @param {SCImgURL} new icon for the right button.
     */
    open fun setRightButtonIcon(newIcon: String): Unit = definedExternally
    /**
     *   Show or hide the NavigationBar.rightButton. The rightButton
     *   must be a control of this NavigationBar or else it will
     *   still be hidden.
     * 
     *  @param {boolean} if false, then the rightButton will be hidden. If unset or true then the rightButton will be shown as long as it is a member of the controls array.
     */
    open fun setShowRightButton(show: Boolean): Unit = definedExternally
    /**
     *   Setter to update the NavigationBar.customNavControl at runtime.
     * 
     * \* @param {Array<Partial<string>> | Array<Partial<Canvas>>} 
     */
    open fun setCustomNavControl(controls: Array<dynamic>): Unit = definedExternally
    /**
     *   Sets multiple state attributes of this NavigationBar at once. If this
     *   NavigationBar was created with NavigationBar.animateStateChanges
     *   set to true, then the change-over to the new state attributes will be
     *   animated if the direction is either
     *   "forward"
     * 
     *   or
     *   "back".
     * 
     * 
     *  @param {NavigationBarViewState} the new view state.
     *  @param {NavigationDirection=} an optional direction for animation. If not specified or set to "none"  then the state change will not be animated. The direction should be "forward"  for operations that reveal new content and "back"  for operations that reveal previously-displayed content.
     */
    open fun setViewState(viewState: NavigationBarViewState, direction: 
                                                                        /**
                                                                         *  Back
                                                                         *  Forward
                                                                         *  none
                                                                         */
                                                                        String /* back |  forward |  none */?): Unit = definedExternally
    /**
     *   Notification method fired when the user clicks the NavigationBar.leftButton or NavigationBar.rightButton
     * 
     *  @param {NavigationDirection} direction in which the user is attempting to  navigate
     */
    open fun navigationClick(direction: 
                                        /**
                                         *  Back
                                         *  Forward
                                         *  none
                                         */
                                        String /* back |  forward |  none */): Unit = definedExternally
    /**
     *   Notification method fired when the up button on the NavigationBar.miniNavControl
     *   is clicked.
     * 
     * 
     */
    open fun upClick(): Unit = definedExternally
    /**
     *   Notification method fired when the down button on the NavigationBar.miniNavControl
     *   is clicked.
     * 
     * 
     */
    open fun downClick(): Unit = definedExternally
    companion object {
        /**
         *  Creates a new NavigationBar
         * 
         *  @param typeCheckedProperties {Partial<NavigationBar>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {NavigationBar} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): NavigationBar = definedExternally
    }
}