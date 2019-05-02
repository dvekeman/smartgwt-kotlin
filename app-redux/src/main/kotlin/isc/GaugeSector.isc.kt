@file:JsQualifier("isc")
package isc

/**
 *  Represents a sector on the gauge.
 */
open external class GaugeSector {
    /**
     *  @type {CSSColor}
     *  @default null
     */
    open var fillColor: String = definedExternally
    /**
     *  @type {Float}
     *  @default "0"
     */
    open var startAngle: Number = definedExternally
    /**
     *  @type {Float}
     *  @default "0"
     */
    open var endAngle: Number = definedExternally
    /**
     *  @type {Float}
     *  @default "0"
     */
    open var value: Number = definedExternally
}