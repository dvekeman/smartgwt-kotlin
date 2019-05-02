@file:JsQualifier("isc")
package isc

/**
 *  An object containing properties that is used in Gradient types
 */
open external class ColorStop {
    /**
     *  The relative offset for the color.
     *  @type {Float}
     *  @default "0.0"
     */
    open var offset: Number = definedExternally
    /**
     *  0 is transparent, 1 is fully opaque
     *  @type {Float}
     *  @default "1.0"
     */
    open var opacity: Number = definedExternally
    /**
     *  eg #ff0000 or red or rgb(255,0,0)
     *  @type {CSSColor}
     *  @default null
     */
    open var color: String = definedExternally
}