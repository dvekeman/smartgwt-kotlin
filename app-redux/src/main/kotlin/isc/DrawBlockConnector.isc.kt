@file:JsQualifier("isc")
package isc

/**
 *  DrawItem subclass to render multi-segment, orthogonal-routing paths.
 */
open external class DrawBlockConnector : DrawCurve {
    companion object {
        /**
         *  Creates a new DrawBlockConnector
         * 
         *  @param typeCheckedProperties {Partial<DrawBlockConnector>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DrawBlockConnector} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DrawBlockConnector = definedExternally
    }
}