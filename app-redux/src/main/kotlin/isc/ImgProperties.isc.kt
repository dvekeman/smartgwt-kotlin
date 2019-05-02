@file:JsQualifier("isc")
package isc

/**
 *  A set of properties that can be used to create an image.
 */
open external class ImgProperties {
    /**
     *  Specifies the URL of the image local to the skin or application directory.
     *  @type {URL}
     *  @default null
     */
    open var src: String = definedExternally
    /**
     *  Specifies the width of the image.
     *  @type {number}
     *  @default null
     */
    open var width: dynamic = definedExternally
    /**
     *  Specifies the height of the image.
     *  @type {number}
     *  @default null
     */
    open var height: dynamic = definedExternally
    /**
     *  Specifies the name of the image. This is an identifier unique to the canvas, and subsequent
     *   calls to Canvas.getImage and
     *   Canvas.setImage
     *   with this name will act on the image object created using this ImgProperties object.
     *  @type {string}
     *  @default null
     */
    open var name: String = definedExternally
    /**
     *  Specifies the additional attributes to write in the tag.
     *  @type {string}
     *  @default null
     */
    open var extraStuff: String = definedExternally
    /**
     *  Specifies the image-specific image directory to override the default.
     *  @type {URL}
     *  @default null
     */
    open var imgDir: String = definedExternally
}