@file:JsQualifier("isc")
package isc

/**
 *  A Task is an abstract superclass for Process and for all Task types that can be
 *   involved in a Process, such as a ServiceTask.
 */
open external class Task : ProcessElement {
    /**
     *  Field in the Process.state which is provided as input data to this
     *   task.
     *   See taskIO.
     *  @type {string}
     *  @default null
     */
    open var inputField: String = definedExternally
    /**
     *  List of multiple fields from the Process.state which are provided
     *   as input data to this task. See taskIO.
     * 
     *   If Task.inputField is also specified, it will be implicitly added to the
     *   inputFieldList if it is not already present.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var inputFieldList: Array<dynamic> = definedExternally
    /**
     *  Field in the Process.state where this task writes outputs. See
     *   taskIO.
     *  @type {string}
     *  @default null
     */
    open var outputField: String = definedExternally
    /**
     *  List of multiple fields in the Process.state where this task will
     *   write outputs. See taskIO.
     * 
     *   If Task.outputField is also specified, it will be implicitly added to the
     *   outputFieldList if it is not already present.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var outputFieldList: Array<dynamic> = definedExternally
    /**
     *  Special expression to write task output directly into a DataBoundComponent. See
     *   taskIO.
     *  @type {string}
     *  @default null
     */
    open var outputExpression: String = definedExternally
    companion object {
        /**
         *  Creates a new Task
         * 
         *  @param typeCheckedProperties {Partial<Task>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Task} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Task = definedExternally
    }
}