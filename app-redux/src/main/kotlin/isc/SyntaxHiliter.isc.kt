@file:JsQualifier("isc")
package isc

/**
 *  Abstract base class for regular expression-based source code colorizer.
 * 
 *   An instance of this class is never instantiated. Instead, use one of the source-specific
 *   subclasses: XMLSyntaxHiliter or JSSyntaxHiliter.
 * 
 *   NOTE: This class exists only for use with the SmartClient Feature Explorer and
 *   SmartGWT Showcases and cannot be used in any other environment.
 */
open external class SyntaxHiliter : Class {
    /**
     *   Highlights the passed in source by applying span style elements to matched tokens
     *   and returns it as a string.
     * 
     * 
     *  @param {string} the source to be colorized
     */
    open fun hilite(source: String): String = definedExternally
    companion object {
        /**
         *  Creates a new SyntaxHiliter
         * 
         *  @param typeCheckedProperties {Partial<SyntaxHiliter>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {SyntaxHiliter} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): SyntaxHiliter = definedExternally
    }
}