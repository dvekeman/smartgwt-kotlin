@file:JsQualifier("isc")
package isc

/**
 *  Holds the information of a drawing command.
 */
open external class DrawShapeCommand {
    /**
     *  The command type.
     *  @type {DrawShapeCommandType}
     *  @default null
     */
    open var type: 
                   /**
                    *  Draws a straight line from the current point to the last "moveto" point. There are no arguments.
                    *  Start a new sub-path at a given (x,y) coordinate. The args array for this command type is a two-element array of the X and Y coordinates.
                    *  Draw a line from the current point to the given (x,y) coordinate which becomes the new current point. Multiple (x,y) coordinates may be specified to draw a path, in which
                    *   case the last point becomes the new current point. The args array for this command type is
                    *   an array of one or more Points (two-element arrays of the X and Y coordinates).
                    *  Draw a segment of a specified circle. A straight line (the "initial line segment") is drawn from the current point to the start of the circular arc. The args array
                    *   for this command type contains 4 values:
                    * 
                    * 
                    *  - The center (cx,cy) Point (two-element array) of the circle.
                    * 
                    *  - radius
                    * 
                    *  - startAngle - Start angle in degrees
                    * 
                    *  - endAngle - End angle in degrees
                    * 
                    *   Note that the ${isc.DocUtils.linkForExampleId('circletoCommand', '"circleto" Command example')} can be very helpful
                    *   when learning how to write "circleto" commands.
                    */
                   String /* close |  moveto |  lineto |  circleto */ = definedExternally
    /**
     *  The command arguments. The number of arguments and their types depend on this command's DrawShapeCommand.type.
     *  @type {Array<any>}
     *  @default null
     */
    open var args: Array<dynamic> = definedExternally
}