@file:JsQualifier("isc")
package isc

/**
 *  A task that involves showing a user interface to the end user allowing the user to view and
 *   input data and press a button (or do some other UI gesture) to complete the task.
 * 
 *   A UserTask takes the following steps:
 * 
 * 
 *  - Optionally show() or otherwise make visible the UserTask.targetView
 *     or UserTask.inlineView
 * 
 *  - Provide values to either a DynamicForm designated as the UserTask.targetForm or to
 *     a ValuesManager designated as the UserTask.targetVM, via ValuesManager.setValues
 * 
 *  - Waits for notification of completion or cancellation. The UserTask is notified of
 *     completion if a SubmitItem is pressed in either the targetForm or
 *     any form that is a member of the targetVM. Likewise a CancelItem
 *     triggers cancellation. Direct calls to DynamicForm.cancelEditing or
 *     DynamicForm.completeEditing achieve the same result.
 * 
 *  - if cancellation occurs, the process continues to the UserTask.cancelElement
 *     if specified. Otherwise the workflow is immediately finished.
 * 
 *  - if completion occurs, values are retrieved from the form or valuesManager and applied
 *     to the process state based on Task.outputField,
 *     Task.outputFieldList or Task.inputField, in that order.
 * 
 */
open external class UserTask : Task {
    /**
     *  Widget that should be shown to allow user input. If this widget is a DynamicForm,
     *   it will also be automatically used as the UserTask.targetForm unless either
     *   targetForm or UserTask.targetVM is set.
     * 
     *   UserTask will automatically handle various scenarios of the
     *   targetView not currently visible or draw()n, according to the following
     *   rules:
     * 
     * 
     *  - if the view itself is marked hidden, it will be show()n
     * 
     *  - if the view is inside a hidden parent, the parent will be show()n
     * 
     *  - if the view is the Tab.pane of a tab in a TabSet, the tab will be selected
     * 
     *  - if the view is listed in SectionStackSection.items for a which is either
     *     collapsed or hidden section, the section will be shown and expanded
     * 
     *  - if the view is listed in Window.items for a Window, the Window will be shown
     * 
     *  - if any of these conditions apply to any parent of the targetView, the rules will be
     *     applied to that parent as well. For example, the targetView is in a collapsed section
     *     inside a tab which is not selected, the section will be expanded and the tab
     *     selected
     * 
     *  @type {Canvas | string}
     *  @default null
     */
    open var targetView: dynamic = definedExternally
    /**
     *  An inline definition of the form. Can be used in place of UserTask.targetView to encode form
     *   directly in process xml.
     *  @type {Canvas}
     *  @default null
     */
    open var inlineView: Canvas = definedExternally
    /**
     *  DynamicForm that should be populated with data and that should provide the data for the task
     *   outputs. If UserTask.targetView is a DynamicForm and would also be the targetForm, the
     *   targetForm attribute can be left unset.
     * 
     *   Use UserTask.targetVM to use a ValuesManager instead.
     *  @type {DynamicForm | string}
     *  @default null
     */
    open var targetForm: dynamic = definedExternally
    /**
     *  Optional ValuesManager which will receive task inputs and provide task outputs.
     * 
     *   Use UserTask.targetForm instead if you want to use a DynamicForm.
     *  @type {ValuesManager | string}
     *  @default null
     */
    open var targetVM: dynamic = definedExternally
    /**
     *  If saveToServer is set then the associated form (UserTask.targetForm) will perform the normal
     *   DynamicForm.submit actions when submitted (typically from a SubmitItem).
     *   By default the form submit action is bypassed.
     *  @type {boolean}
     *  @default false
     */
    open var saveToServer: Boolean = definedExternally
    /**
     *  If wizard is set then associated form will be hidden after user goes to next or prev
     *   step of current workflow.
     *  @type {boolean}
     *  @default false
     */
    open var wizard: Boolean = definedExternally
    /**
     *  Next element to proceed to if the task is cancelled because the UserTask.targetForm or
     *   UserTask.targetVM had cancelEditing() called on it.
     * 
     *   if no value is provided the workflow immediately completes.
     *  @type {string}
     *  @default null
     */
    open var cancelElement: String = definedExternally
    /**
     *  Previous workflow Process.sequences or Process.elements
     *   that is helpful for wizards. This element will be executed if UserTask.goToPrevious
     *   method of userTask will be invoked. You can get userTask for attached form by using
     *   DynamicForm.userTask property.
     *  @type {string}
     *  @default null
     */
    open var previousElement: String = definedExternally
    /**
     *   Set UserTask.previousElement as next element of workflow. This method could be used to
     *   create wizard-like UI behavior.
     * 
     */
    open fun goToPrevious(): Unit = definedExternally
    /**
     *   Revert any changes made in a form and finish this userTask execution.
     *   UserTask.cancelElement will be proceed as the next element of current process.
     * 
     */
    open fun cancelEditing(): Unit = definedExternally
    /**
     *   Finish editing and store edited values in Process.state.
     * 
     */
    open fun completeEditing(): Unit = definedExternally
    companion object {
        /**
         *  Creates a new UserTask
         * 
         *  @param typeCheckedProperties {Partial<UserTask>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {UserTask} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): UserTask = definedExternally
    }
}