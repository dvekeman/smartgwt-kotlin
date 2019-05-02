@file:JsQualifier("isc")
package isc

/**
 *  Definition of a radial gradient.
 */
open external class RadialGradient : Gradient {
    /**
     *  x coordinate of outer radial
     *  @type {string}
     *  @default null
     */
    open var cx: String = definedExternally
    /**
     *  y coordinate of outer radial
     *  @type {string}
     *  @default null
     */
    open var cy: String = definedExternally
    /**
     *  radius
     *  @type {string}
     *  @default null
     */
    open var r: String = definedExternally
    /**
     *  x coordinate of inner radial
     *  @type {string}
     *  @default null
     */
    open var fx: String = definedExternally
    /**
     *  y coordinate of inner radial
     *  @type {string}
     *  @default "0"
     */
    open var fy: String = definedExternally
}