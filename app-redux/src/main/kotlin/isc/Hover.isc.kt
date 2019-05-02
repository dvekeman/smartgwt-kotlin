@file:JsQualifier("isc")
package isc

/**
 *  The Hover class handles showing a simple SmartClient canvas containing arbitrary HTML, or
 *   triggering some other action in response to a user holding the mouse-pointer (or hovering)
 *   over a specific widget.
 */
open external class Hover : Class {
    companion object {
        /**
         *  When the Hover canvas is shown by default, should it move as the user moves the
         *   mouse pointer?
         *   May be overridden by including a moveWithMouse attribute on the
         *   properties block passed to Hover.show
         *  @type {boolean}
         *  @default false
         */
        var moveWithMouse: Boolean = definedExternally
        /**
         *  When positioning the hover canvas, this will be the default left offset from the
         *   mousepointer, if no explicit position was passed to the Hover.show method
         *  @type {number}
         *  @default "15"
         */
        var leftOffset: Number = definedExternally
        /**
         *  When positioning the hover canvas, this will be the default top offset from the
         *   mousepointer, if no explicit position was passed to the Hover.show method
         *  @type {number}
         *  @default "15"
         */
        var topOffset: Number = definedExternally
        /**
         *  Defaults to apply to the Hover canvas shown when the user hovers over some widget.
         *   By default this property is set to this object:
         *      { defaultWidth:100, 
         *       defaultHeight:1,
         *       baseStyle:"canvasHover",
         *       align:"left",
         *       valign:"top",
         *       opacity:null
         *      }
         * 
         *   Note that these properties can be overridden by individual widgets showing hovers, by
         *   modifying Canvas.hoverWidth, Canvas.hoverHeight,
         *   Canvas.hoverStyle, Canvas.hoverAlign, Canvas.hoverVAlign,
         *   Canvas.hoverOpacity, and Canvas.hoverWrap.
         *  @type {object}
         *  @default "{...}"
         */
        var hoverCanvasDefaults: dynamic = definedExternally
        /**
         *  Creates a new Hover
         * 
         *  @param typeCheckedProperties {Partial<Hover>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Hover} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Hover = definedExternally
        /**
         *   Displays a standard Hover canvas containing the specified HTML content.
         *   This method may also be called to modify the content of the hover if it is already showing.
         *   Call Hover.hide to hide the canvas again.
         *   A common use case for calling this method is to asynchronously fetch detail data from the
         *   server about some component, and display it in the Hover canvas when the data is returned.
         *   Note that in this case you will typically need to verify that the user is still hovering
         *   over the component in question before calling Hover.show() - if the user has moved the mouse
         *   off the component, the information will not apply to whatever is now under the mouse.
         *   Suggested approaches for handling this are to either use a Canvas.mouseOut handler
         *   to track when the user moves off the component, or checking EventHandler.getTarget
         *   as part of the asynchronous callback
         * 
         *   The default Hover canvas position will be based on the mouse pointer position, adjusted by
         *   Hover.leftOffset and Hover.topOffset. If this position would render the
         *   Hover canvas partially clipped, it will be automatically modified to ensure the Hover
         *   is entirely visible.
         * 
         *  @param {HTMLString | Canvas} contents for the hover
         *  @param {Label} object containing attributes for managing the hover canvas'  appearance. Valid properties include:
         *  - left, top, width, height
         *  - baseStyle
         *  - opacity
         *  - wrap
         *  - moveWithMouse [overrides Hover.moveWithMouse]
         *  - autoFitWidth: If true, any specified width will be treated as a minimum and the    hover canvas will expand horizontally to fit the content string (without wrapping)    up to the specified autoFitMaxWidth. This setting differs from    simply setting Label.wrap for the hover in that wrapping of    text will occur if the autoFitMaxWidth is exceeded.
         *  - autoFitMaxWidth: Maximum width to expand to without wrapping (if autoFitWidth is true).
         */
        fun show(contents: dynamic, properties: Label): Unit = definedExternally
        /**
         *   Hide hover hover Canvas shown via Hover.show
         * 
         */
        fun hide(): Unit = definedExternally
    }
}