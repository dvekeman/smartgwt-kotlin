@file:JsQualifier("isc")
package isc

/**
 *  Task that executes arbitrary code, either synchronous or asynchronous. Override the
 *   ScriptTask.execute method to provide custom logic.
 */
open external class ScriptTask : Task {
    /**
     *  Whether the script task is asynchronous. A synchronous task is expected to return data
     *   directly from execute() and is considered complete once the execute() method exits.
     * 
     *   An asnychronous task is expected to start processing in execute(), and will not be
     *   considered complete until either ScriptTask.setOutputData or ScriptTask.setOutputRecord is
     *   called.
     *  @type {boolean}
     *  @default false
     */
    open var isAsync: Boolean = definedExternally
    /**
     *   Get the inputs to this task as specified by Task.inputField.
     * 
     *   For a task with a Task.inputFieldList, use ScriptTask.getInputRecord
     *   to get access to other inputs.
     * 
     */
    open fun getInputData(): dynamic = definedExternally
    /**
     *   Set the task output as specified by Task.outputField.
     * 
     *   NOTE: for an ScriptTask.isAsync, calling
     *   setOutputData() indicates the task is complete. For a task with
     *   Task.outputFieldList, call ScriptTask.setOutputRecord instead.
     * 
     *  @param {any} task output
     */
    open fun setOutputData(taskOutput: dynamic): Unit = definedExternally
    /**
     *   Get all inputs to the task as specified by the
     *   Task.inputFieldList, as a Record.
     * 
     */
    open fun getInputRecord(): Record = definedExternally
    /**
     *   Set all outputs of the task as specified by the
     *   Task.outputFieldList, by providing a Record.
     * 
     *  @param {Record} output record
     */
    open fun setOutputRecord(outputRecord: Record): Unit = definedExternally
    /**
     *   Execute the task.
     * 
     *  @param {any} the task input
     *  @param {Record} the task input record if an inputFieldList was specified. See taskIO
     */
    open fun execute(input: dynamic, inputRecord: Record): dynamic = definedExternally
    companion object {
        /**
         *  Creates a new ScriptTask
         * 
         *  @param typeCheckedProperties {Partial<ScriptTask>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ScriptTask} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ScriptTask = definedExternally
    }
}