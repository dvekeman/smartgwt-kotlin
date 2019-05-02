@file:JsQualifier("isc")
package isc

/**
 *  Definition of a linear gradient between two points, (LinearGradient.x1, LinearGradient.y1)
 *   and (LinearGradient.x2, LinearGradient.y2).
 */
open external class LinearGradient : Gradient {
    /**
     *  X coordinate of the start point. This can be a number or a percentage of the width of the
     *   bounding box of the DrawItem to which it is applied.
     *  @type {string}
     *  @default null
     */
    open var x1: String = definedExternally
    /**
     *  Y coordinate of the start point. This can be a number or a percentage of the height of the
     *   bounding box of the DrawItem to which it is applied.
     *  @type {string}
     *  @default null
     */
    open var y1: String = definedExternally
    /**
     *  X coordinate of the end point. This can be a number or a percentage of the width of the
     *   bounding box of the DrawItem to which it is applied.
     *  @type {string}
     *  @default null
     */
    open var x2: String = definedExternally
    /**
     *  Y coordinate of the end point. This can be a number or a percentage of the height of the
     *   bounding box of the DrawItem to which it is applied.
     *  @type {string}
     *  @default null
     */
    open var y2: String = definedExternally
}