@file:JsQualifier("isc")
package isc

/**
 *  Specially styled Button subclass used by the NavigationBar class.
 */
open external class NavigationButton : Button {
    /**
     *  Default baseStyle for navigation buttons. Note that the special NavigationButton.backBaseStyle and
     *   NavigationButton.forwardBaseStyle are applied if NavigationButton.direction is set.
     *  @type {CSSStyleName}
     *  @default "navButton"
     */
    override var baseStyle: String = definedExternally
    /**
     *  Base style for navigation buttons where Direction is set to "back"
     *  @type {CSSStyleName}
     *  @default "navBackButton"
     */
    open var backBaseStyle: String = definedExternally
    /**
     *  Base style for navigation buttons where Direction is set to "forward"
     *  @type {CSSStyleName}
     *  @default "navForwardButton"
     */
    open var forwardBaseStyle: String = definedExternally
    /**
     *  Navigation direction for this button. If set to "forward" or
     *   "back" the special NavigationButton.forwardBaseStyle or NavigationButton.backBaseStyle
     *   will be applied.
     *  @type {NavigationDirection}
     *  @default "none"
     */
    open var direction: 
                        /**
                         *  Back
                         *  Forward
                         *  none
                         */
                        String /* back |  forward |  none */ = definedExternally
    companion object {
        /**
         *  Creates a new NavigationButton
         * 
         *  @param typeCheckedProperties {Partial<NavigationButton>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {NavigationButton} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): NavigationButton = definedExternally
    }
}