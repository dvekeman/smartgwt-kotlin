@file:JsQualifier("isc")
package isc

/**
 *  Configuration object for effect to apply during an animated show or hide.
 */
open external class AnimateShowEffect {
    /**
     *  Effect to apply
     *  @type {AnimateShowEffectId}
     *  @default null
     */
    open var effect: 
                     /**
                      *  content slides into or out of view as the widget grows or shrinks
                      *  content is revealed or wiped as the widget grows or shrinks
                      *  widget's opacity smoothly fades into or out of view
                      *  widget moves into position from offscreen
                      */
                     String /* slide |  wipe |  fade |  fly */ = definedExternally
    /**
     *  For show animations of type "wipe" and
     *    "slide" this attribute specifies where the wipe / slide should originate.
     *    Valid values are "T" (vertical animation from the top down, the
     *    default behavior), and "L" (horizontal animation from the left side).
     *  @type {string}
     *  @default null
     */
    open var startFrom: String = definedExternally
    /**
     *  For hide animations of type "wipe and
     *    "slide" this attribute specifies where the wipe / slide should finish.
     *    Valid options are "T" (vertical animation upwards to the top of the canvas,
     *    the default behavior) and "L" (horizontal animation to the left of the
     *    canvas).
     *  @type {string}
     *  @default null
     */
    open var endsAt: String = definedExternally
}