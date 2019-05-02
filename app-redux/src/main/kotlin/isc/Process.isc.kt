@file:JsQualifier("isc")
package isc

/**
 *  A instance of Process represents a stateful process executing a series of Tasks,
 *   which may be:
 * 
 * 
 *  - user interactions
 * 
 *  - calls to DataSources (hence: any database or web service)
 * 
 *  - arbitrary code
 * 
 *  - other Processes
 * 
 *   A Process is stateful in the sense that it maintains Process.state
 *   across the different tasks that are executed. This allows you to maintain context as you
 *   walk a user through a multi-step business process in your application, which may involve
 *   multiple operations on multiple entities. Each Task that executes can use the Process state
 *   as inputs, and can output a result which is stored in the Process state - see
 *   taskIO.
 * 
 *   A Process can have multiple branches, choosing the next Task to execute based on
 *   Criteria - see XORGateway and DecisionGateway.
 * 
 *   Because a Process may return to a previous Task in various situations, the data model of a
 *   Process is strictly speaking a graph (a set of nodes connected by arbitary
 *   interlinks). However, most processes have sequences of several tasks in a row, and the
 *   definition format allows these to be represented as simple Arrays called "sequences",
 *   specified via Process.sequences. This reduces the need to manually specify IDs and
 *   interlinks for Tasks that simply proceed to the next task in a sequence.
 * 
 *   Processes follow all the standard rules for encoding as componentXML, however,
 *   note that the &lt;Process&gt; tag allows any kind of ProcessElement (tasks, gateways
 *   and sequences) to appear as a direct subelement of the &lt;Process&gt; tag without the need
 *   for an intervening &lt;elements&gt; or &lt;sequences&gt; tag. The example below
 *   demonstrates this shorthand format.
 * 
 *   &lt;Process ID="processId"&gt;
 *     &lt;ServiceTask ID="serviceTaskId" nextElement="sequenceId" ..&gt;
 *       &lt;inputFieldList&gt;
 *         &lt;value&gt;order.countryName&lt;/value&gt;
 *       &lt;/inputFieldList&gt;
 *       &lt;outputFieldList&gt;
 *         &lt;value&gt;order.countryName&lt;/value&gt;
 *         &lt;value&gt;order.continent&lt;/value&gt;
 *       &lt;outputFieldList&gt;
 *     &lt;/ServiceTask&gt;
 *     &lt;sequence ID="sequenceId" &gt;
 *       &lt;StateTask ../&gt;
 *       &lt;StateTask ../&gt;
 *       &lt;StateTask ../&gt;
 *       &lt;StateTask nextElement="userTaskId" ../&gt;
 *     &lt;/sequence&gt;
 *     &lt;UserTask ID="userTaskId" ../&gt;
 *     ...
 *   &lt;/Process&gt;
 * 
 *   NOTE: you must load the Workflow module
 *   loadingOptionalModules before you can use Process.
 */
open external class Process : Task {
    /**
     *  Sequences of ProcessElements. By defining a sequences of elements you can make the
     *   ProcessElement.nextElement implicit.
     * 
     *   You do not have to explicitly create a ProcessSequence,
     *   you can instead use the shorthand:
     * 
     *   isc.Process.create({
     *     startElement:"firstSequence", 
     *     sequences: [
     *       { ID:"something", elements: [ ... ] },
     *       { ID:"somethingElse", elements: [ ... ] },
     *       ...
     *     ]
     *     ...
     *   });
     * 
     *   .. this is equivalent to ..
     * 
     *   isc.Process.create({
     *     startElement:"firstSequence", 
     *     sequences: [
     *       isc.ProcessSequence.create({ 
     *         ID:"something", 
     *         elements: [ ... ] 
     *       }),
     *       isc.ProcessSequence.create({ 
     *         ID:"somethingElement", 
     *         elements: [ ... ] 
     *       }),
     *       ...              
     *     ]
     *     ...
     *   });
     * 
     * 
     * 
     *  @type {Array<Partial<ProcessSequence>>}
     *  @default null
     */
    open var sequences: Array<dynamic> = definedExternally
    /**
     *  Elements involved in this Process. You can also group elements into Process.sequences
     *   to reduce the need to explicitly define IDs for elements and interlink them.
     *  @type {Array<Partial<ProcessElement>>}
     *  @default null
     */
    open var elements: Array<dynamic> = definedExternally
    /**
     *  The ID of either a Process.sequences or an Process.elements which should
     *   be the starting point of the process. If not specified, the first sequence is chosen,
     *   or if there are no sequences, the first element.
     *   - log a warning and do nothing if there are neither sequences or elements
     * 
     *   - an example of how a Process would be defined
     * 
     *   isc.Process.create({
     *     startElement:"firstSequence", 
     *     sequences: [
     *       { 
     *        id:"firstSequence",
     *        elements : [
     *          isc.ServiceTask.create({ .. }),
     *          isc.DecisionGateway.create({ .. })
     *        ]
     *       },
     *       {
     *        id:"errorFlow",
     *        elements : [ ... ]
     *        
     *       }
     *     ],
     *     elements: [
     *      // standalone process elements not part of sequences
     *      isc.ServiceTask.create({ .. })
     *     ],
     *     state : {
     *       someField:"someValue"
     *     }
     *   })
     * 
     * 
     *  @type {string}
     *  @default null
     */
    open var startElement: String = definedExternally
    /**
     *  If wizard is set then current workflow will be handled as wizard. Every userTask will
     *   hide associated form after user finished step.
     *  @type {boolean}
     *  @default false
     */
    open var wizard: Boolean = definedExternally
    /**
     *  Identifier of canvas where UI elements created by using
     *   UserTask.inlineView property should be added
     *   using addMember.
     *  @type {GlobalId}
     *  @default null
     */
    open var containerId: String = definedExternally
    /**
     *  Current state of a process. As with Records in general, any field of a Record may
     *   contain a nested Record or Array of Records, so the process state is essentially a
     *   hierarchical data structure.
     * 
     *   Transient state
     *   In addition to the explicit process state there is a "transient state." The transient
     *   state represents the complete output of each of the last tasks of each type within the current
     *   process execution. This allows easy reference to the previous task output with
     *   taskInputExpression.
     *  @type {Record}
     *  @default null
     */
    open var state: Record = definedExternally
    /**
     *  Canvas.ID of the component that manages "rule context" for which
     *   this process participates. The rule context can be used in
     *   taskInputExpression.
     *  @type {string}
     *  @default null
     */
    override var ruleScope: String = definedExternally
    /**
     *  Cause the process to automatically call Process.start as soon as it is created.
     *  @type {boolean}
     *  @default false
     */
    open var autoStart: Boolean = definedExternally
    /**
     *  Context object to be passed to Process.traceElement during process
     *   execution.
     *  @type {object}
     *  @default null
     */
    open var traceContext: dynamic = definedExternally
    /**
     *   Retrieve a ProcessElement by it's ID
     * 
     *  @param {string} id of the process element
     */
    open fun getElement(ID: String): ProcessElement = definedExternally
    /**
     *   Set process state for current process
     * 
     *  @param {Record} the new process state
     */
    open fun setState(state: Record): Unit = definedExternally
    /**
     *   Starts this task by executing the Process.startElement.
     * 
     */
    open fun start(): Unit = definedExternally
    /**
     *   Reset process to it's initial state, so process can be started again.
     * 
     *  @param {Record} new state of the process
     */
    open fun reset(state: Record): Unit = definedExternally
    /**
     *   StringMethod called when a process completes, meaning the process executes a
     *   ProcessElement with no next element.
     * 
     *  @param {Record} the final process state
     */
    open fun finished(state: Record): Unit = definedExternally
    /**
     *   StringMethod called during process execution before each task
     *   element is processed.
     * 
     *  @param {Task} the Task being executed
     *  @param {object} the Process.traceContext, if set
     */
    open fun traceElement(element: Task, context: dynamic): Unit = definedExternally
    companion object {
        /**
         *  Creates a new Process
         * 
         *  @param typeCheckedProperties {Partial<Process>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Process} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Process = definedExternally
        /**
         *   Loads an XML process definition stored in XML from the server.
         * 
         *   This method requires server-side support included in SmartClient Pro Edition or better.
         * 
         *   Process files are stored as .proc.xml files in componentXML
         *   format, in the directory indicated by the project.processes setting in
         *   server_properties
         *   (webroot/processes by default). To load a process
         *   saved in a file processId.proc.xml, pass just processId to this method.
         * 
         * 
         *  @param {Identifier | Array<Partial<Identifier>>} process IDs to load
         *  @param {ProcessCallback} called when the process is loaded with argument              "process", the first process. Other processes can be looked               up via Process.getProcess.
         */
        fun loadProcess(processId: dynamic, callback: ((dsResponse: DSResponse, process: Process) -> Unit)): Unit = definedExternally
        /**
         *   Get a Process instance by it's ID. See Process.loadProcess.
         * 
         *  @param {Identifier} process IDs to retrieve
         */
        fun getProcess(processId: String): Process = definedExternally
    }
}