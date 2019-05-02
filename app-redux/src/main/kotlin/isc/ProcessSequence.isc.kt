@file:JsQualifier("isc")
package isc

/**
 *  An Array of ProcessElements involved in a Process. A
 *   ProcessSequence is used to reduce the number of explicit
 *   ProcessElement.IDs that need to be assigned, by creating an implicit next element -
 *   the next in the sequence.
 * 
 *   A sequence cannot be executed outside of a Process and has no state.
 */
open external class ProcessSequence : ProcessElement {
    /**
     *  The ProcessElements in this sequence.
     *  @type {Array<Partial<ProcessElement>>}
     *  @default null
     */
    open var elements: Array<dynamic> = definedExternally
    companion object {
        /**
         *  Creates a new ProcessSequence
         * 
         *  @param typeCheckedProperties {Partial<ProcessSequence>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ProcessSequence} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ProcessSequence = definedExternally
    }
}