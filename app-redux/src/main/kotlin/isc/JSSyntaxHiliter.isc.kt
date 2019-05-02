@file:JsQualifier("isc")
package isc

/**
 *  Regular expression-based source code colorizer for JS source.
 * 
 *   NOTE: This class exists only for use with the SmartClient Feature Explorer and
 *   SmartGWT Showcases and cannot be used in any other environment.
 */
open external class JSSyntaxHiliter : SyntaxHiliter {
    companion object {
        /**
         *  Creates a new JSSyntaxHiliter
         * 
         *  @param typeCheckedProperties {Partial<JSSyntaxHiliter>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {JSSyntaxHiliter} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): JSSyntaxHiliter = definedExternally
    }
}