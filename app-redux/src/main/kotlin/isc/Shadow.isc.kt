@file:JsQualifier("isc")
package isc

/**
 *  A class used to define a shadow used in a Draw&lt;Shape&gt; Types.
 */
open external class Shadow {
    /**
     *  @type {CSSColor}
     *  @default "black"
     */
    open var color: String = definedExternally
    /**
     *  @type {Integer}
     *  @default "10"
     */
    open var blur: Number = definedExternally
    /**
     *  @type {Point}
     *  @default "[0,0]"
     */
    open var offset: Point = definedExternally
}