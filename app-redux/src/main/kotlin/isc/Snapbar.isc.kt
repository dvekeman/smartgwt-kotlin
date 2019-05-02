@file:JsQualifier("isc")
package isc

/**
 *  Subclass of the Splitbar class that uses the grip functionality
 *   to show a stateful open / close indicator.
 */
open external class Snapbar : Splitbar {
    /**
     *  Snapbars show rollover styling.
     *  @type {boolean}
     *  @default true
     */
    override var showRollOver: Boolean = definedExternally
    /**
     *  Snapbars show mouse-down styling.
     *  @type {boolean}
     *  @default true
     */
    override var showDown: Boolean = definedExternally
    /**
     *  Should we show a "grip" image floating above the center of this widget?
     *  @type {boolean}
     *  @default true
     */
    override var showGrip: Boolean = definedExternally
    /**
     *  If StretchImg.showGrip is true, this property determines whether to show the
     *   'Down' state on the grip image when the user mousedown's on this widget.
     *   Has no effect if StatefulCanvas.showDown is false.
     *  @type {boolean}
     *  @default true
     */
    override var showDownGrip: Boolean = definedExternally
    /**
     *  If StretchImg.showGrip is true, this property determines whether to show the
     *   'Over' state on the grip image when the user rolls over on this widget.
     *   Has no effect if StatefulCanvas.showRollOver is false.
     *  @type {boolean}
     *  @default true
     */
    override var showRollOverGrip: Boolean = definedExternally
    /**
     *  If Splitbar.showGrip is true, this property determines whether the grip image
     *   displayed should show the "Closed" state when the Splitbar.target
     *   is hidden. Note that if Splitbar.invertClosedGripIfTargetAfter is true, we
     *   may show the "closed" state when the target is visible, rather than when it is hidden.
     *  @type {boolean}
     *  @default true
     */
    override var showClosedGrip: Boolean = definedExternally
    /**
     *  Overridden from Splitbar.gripImgSuffix to simplify providing custom grip media
     *   for this widget.
     *  @type {string}
     *  @default "snap"
     */
    override var gripImgSuffix: String = definedExternally
    companion object {
        /**
         *  Creates a new Snapbar
         * 
         *  @param typeCheckedProperties {Partial<Snapbar>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Snapbar} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Snapbar = definedExternally
    }
}