@file:JsQualifier("isc")
package isc

/**
 *  Definition of a simple linear gradient defined by 2 colors and a SimpleGradient.direction.
 */
open external class SimpleGradient : Gradient {
    /**
     *  Angle of the direction vector in degrees. The default of 0.0 causes the gradient to sweep
     *   from the start color on the left to the end color on the right. Positive direction angles
     *   correspond to clockwise rotations of the default gradient.
     *  @type {Float}
     *  @default "0.0"
     */
    open var direction: Number = definedExternally
    /**
     *  The start color of the gradient.
     *  @type {CSSColor}
     *  @default null
     */
    override var startColor: String = definedExternally
    /**
     *  The end color of the gradient.
     *  @type {CSSColor}
     *  @default null
     */
    override var endColor: String = definedExternally
}