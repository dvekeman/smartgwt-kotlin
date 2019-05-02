@file:JsQualifier("isc")
package isc

/**
 *  Defines a simple gradient vertical gradient between Gradient.startColor
 *   Gradient.endColor, or using Gradient.colorStops. See
 *   SimpleGradient, LinearGradient and RadialGradient for further
 *   properties to define more advanced gradients.
 */
open external class Gradient {
    /**
     *  Identifier which can be used by one or more DrawItems when gradient is assigned
     *   to DrawPane.gradients. The ID property is optional when gradient is assigned directly
     *   to a DrawItem.
     * 
     *   The ID must be unique within DrawPane.gradients if defined.
     *  @type {Identifier}
     *  @default null
     */
    open var id: String = definedExternally
    /**
     *  An array of color stops for this gradient.
     *  @type {Array<Partial<ColorStop>>}
     *  @default null
     */
    open var colorStops: Array<dynamic> = definedExternally
    /**
     *  A start color for the gradient. If both startColor and Gradient.endColor
     *   are set then Gradient.colorStops is ignored.
     *  @type {CSSColor}
     *  @default null
     */
    open var startColor: String = definedExternally
    /**
     *  An end color for the gradient. If both Gradient.startColor and endColor
     *   are set then Gradient.colorStops is ignored.
     *  @type {CSSColor}
     *  @default null
     */
    open var endColor: String = definedExternally
}