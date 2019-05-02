@file:JsQualifier("isc")
package isc

/**
 *  A ProcessElement is an abstract superclass for elements involved in a Process, such
 *   as a Task or XORGateway.
 */
open external class ProcessElement : Class {
    /**
     *  Optional ID for this process element, allowing it to be referred to from
     *   DecisionGateway, or as the Process.startElement. See ProcessSequence and
     *   Process to understand when this is required or can be omitted.
     * 
     *   Unlike Canvas.ID a processElement's is a not a globally unique
     *   variable, it need only by unique within it's process.
     * 
     *   When assigned an ID, a processElement can be retrieve via
     *   Process.getElement.
     *  @type {string}
     *  @default null
     */
    open var ID: String = definedExternally
    /**
     *  Next Process.sequences or Process.elements to execute
     *   after this one completes.
     * 
     *   nextElement does not need to be specified on most elements if you use
     *   Process.sequences.
     * 
     *   Note that if there is both a sequence and a normal element
     *   with the same name in the current Process, the sequence will
     *   be used.
     *  @type {string}
     *  @default null
     */
    open var nextElement: String = definedExternally
    /**
     *  Optional description for this process element.
     *  @type {string}
     *  @default null
     */
    open var description: String = definedExternally
    /**
     *   Returns a text description of the element derived from
     *   the configuration.
     * 
     *   If no override is provided by the concrete ProcessElement
     *   implementation the ProcessElement.description or ProcessElement.ID is
     *   returned.
     * 
     * 
     */
    open fun getElementDescription(): String = definedExternally
    companion object {
        /**
         *  Creates a new ProcessElement
         * 
         *  @param typeCheckedProperties {Partial<ProcessElement>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ProcessElement} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ProcessElement = definedExternally
    }
}