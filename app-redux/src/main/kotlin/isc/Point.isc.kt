@file:JsQualifier("isc")
package isc

/**
 *  X/Y position in pixels, specified as an Array with two members, for example: [30, 50]
 */
open external class Point {
    /**
     *  The x coordinate of this point.
     *  @type {Coordinate}
     *  @default "0"
     */
    open var x: Number = definedExternally
    /**
     *  The y coordinate of this point.
     *  @type {Coordinate}
     *  @default "0"
     */
    open var y: Number = definedExternally
}