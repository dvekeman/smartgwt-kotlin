@file:JsQualifier("isc")
package isc

/**
 *  An object representing one of the image segments displayed by a StretchImg. Each item of
 *   a StretchImg's StretchImg.items array is a StretchItem.
 */
open external class StretchItem {
    /**
     *  The width of the image. This can either be a number (for the number of pixels wide), the string
     *   "\*" (remaining space, divided amongst all items that specify width:"\*"), or the name of a property
     *   on the StretchImg component, such as "capSize" for the StretchImg's StretchImg.capSize.
     * 
     *   NOTE: The width is only used if the StretchImg stacks its images horizontally
     *   (StretchImg.vertical is false).
     *  @type {number | string}
     *  @default null
     */
    open var width: dynamic = definedExternally
    /**
     *  The height of the image. This can either be a number (for the number of pixels tall), the string
     *   "\*" (remaining space, divided amongst all items that specify height:"\*"), or the name of a property
     *   on the StretchImg component, such as "capSize" for the StretchImg's StretchImg.capSize.
     * 
     *   NOTE: The height is only used if the StretchImg stacks its images vertically
     *   (StretchImg.vertical is true).
     *  @type {number | string}
     *  @default null
     */
    open var height: dynamic = definedExternally
    /**
     *  A string that is appended as a suffix to the StretchImg's StretchImg.src
     *   URL in order to fetch the media file for this StretchItem, if a separate StretchItem.src is
     *   not provided. Note that the special name "blank", possibly suffixed by one or more digits
     *   which are used to differentiate blank items, means no image will be shown for this StretchItem.
     * 
     *   For example, for a StretchImg in "Over" state with a StretchImg.src of "button.png"
     *   and a name of "stretch", the resulting URL would be "button_Over_stretch.png".
     *  @type {string}
     *  @default null
     */
    open var name: String = definedExternally
    /**
     *  The URL of the media file for this StretchItem.
     *  @type {SCImgURL}
     *  @default null
     */
    open var src: String = definedExternally
}