@file:JsQualifier("isc")
package isc

/**
 *  Configuration of an HTML list in a RichTextEditor.
 */
open external class ListProperties {
    /**
     *  The style of list item marker. If "custom-image", the ListProperties.image
     *   should be specified.
     *  @type {ListStyleType}
     *  @default null
     */
    open var style: 
                    /**
                     *  A filled, black dot (&bull;)
                     *  An unfilled circle (&#9702;)
                     *  A filled, black square (&#9632;)
                     *  Numbers (1., 2., 3., etc.)
                     *  Uppercase Roman numerals (I., II., III., IV., etc.)
                     *  Lowercase Roman numerals (i., ii., iii., iv., etc.)
                     *  Uppercase letters (A., B., C., etc.)
                     *  Lowercase letters (a., b., c., etc.)
                     *  An image used in place of a marker.
                     */
                    String /* disc |  circle |  square |  decimal |  upper-roman |  lower-roman |  upper-alpha |  lower-alpha |  custom-image */ = definedExternally
    /**
     *  When the list item marker ListProperties.style is "custom-image", the image
     *   to use for the markers.
     *  @type {SCImgURL}
     *  @default "[SKIN]/RichTextEditor/bullet_blue.png"
     */
    open var image: String = definedExternally
    /**
     *  For ordered lists, the number to start the first item with. Must be non-negative.
     *  @type {Integer}
     *  @default "1"
     */
    open var startNumber: Number = definedExternally
}