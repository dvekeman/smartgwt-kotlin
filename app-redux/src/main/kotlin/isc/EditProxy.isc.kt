@file:JsQualifier("isc")
package isc

/**
 *  An EditProxy is attached to an editable component when editMode is enabled. This proxy
 *   has methods and properties which affect the component during editing.
 */
open external class EditProxy : Class {
    /**
     *  When true an EditProxy.editMask will be auto-generated and
     *   placed over the component to allow selection, positioning and resizing.
     * 
     *   If this property is not set it will enabled when added to an EditContext if its
     *   parent component has an editProxy and EditProxy.autoMaskChildren is true.
     *  @type {boolean}
     *  @default null
     */
    open var useEditMask: Boolean = definedExternally
    /**
     *  When child nodes are added to an EditContext, should they be masked by setting
     *   EditProxy.useEditMask true if not explicitly set?
     *  @type {boolean}
     *  @default null
     */
    open var autoMaskChildren: Boolean = definedExternally
    /**
     *  Whether to allow selection of the children of this EditNode. The appearance and
     *   behavior of selected components is controlled by SelectedAppearance, or centrally
     *   across an EditContext via EditContext.selectedAppearance.
     * 
     *   Individual children can be marked non-selectable via setting EditProxy.canSelect
     *   to false.
     * 
     *   Use the EditContext to access and manipulate the currently selected set of
     *   EditNodes, via APIs such as EditContext.getSelectedEditNode,
     *   EditContext.selectSingleEditNode and
     *   EditContext.selectedEditNodesUpdated.
     *  @type {boolean}
     *  @default null
     */
    open var canSelectChildren: Boolean = definedExternally
    /**
     *  If not null the Canvas.childrenSnapToGrid on the component represented by this
     *   EditProxy is set to this value only while in edit mode. This allows snapToGrid functionality
     *   to be enforced during edit mode but not when live.
     *  @type {boolean}
     *  @default null
     */
    open var childrenSnapToGrid: Boolean = definedExternally
    /**
     *  If not null the Canvas.childrenSnapResizeToGrid on the component represented by this
     *   EditProxy is set to this value only while in edit mode. This allows snapResizeToGrid functionality
     *   to be enforced during edit mode but not when live.
     *  @type {boolean}
     *  @default null
     */
    open var childrenSnapResizeToGrid: Boolean = definedExternally
    /**
     *  Can this component be selected? Selection is allowed unless this
     *   property is set to false.
     *  @type {boolean}
     *  @default null
     */
    open var canSelect: Boolean = definedExternally
    /**
     *  This property acts as a component-specific override for the EditContext.allowNestedDrops
     *   property. Unless explicitly set to false, the EditContext.allowNestedDrops controls whether
     *   a drop can be made into this component.
     *  @type {boolean}
     *  @default null
     */
    open var allowNestedDrops: Boolean = definedExternally
    /**
     *  Whether to enable keyboard shortcuts to EditContext.copyEditNodes and
     *   EditContext.pasteEditNodes editNodes.
     * 
     *   Enabled by default if EditProxy.canSelectChildren is also enabled.
     * 
     *   For pasting, if EditContext.allowNestedDrops is enabled, only one editNode is selected and
     *   it is a valid container for the contents of the clipboard, editNodes will be pasted as new
     *   children of the selected container. Otherwise, they will be pasted at the root level of the
     *   EditContext.getEditNodeTree.
     * 
     *   useCopyPasteShortcuts may only be set on the root editNode
     *   within any one EditContext.getEditNodeTree.
     *  @type {boolean}
     *  @default null
     */
    open var useCopyPasteShortcuts: Boolean = definedExternally
    /**
     *  An editMask is created for any component placed into editMode with
     *   EditProxy.useEditMask:true.
     * 
     *   Common customization properties can be provided by EditContext.editMaskProperties.
     *  @type {Canvas}
     *  @default null
     */
    open var editMask: Canvas = definedExternally
    /**
     *  Appearance that is applied to selected component. Default value is determined from
     *   EditContext.selectedAppearance.
     * 
     *   When value is null the appearance is determined by:
     * 
     * 
     *  - If multiple selection is enabled, "tintMask" is used
     * 
     *  - Otherwise, "outlineMask" is used
     * 
     *  @type {SelectedAppearance}
     *  @default null
     */
    open var selectedAppearance: 
                                 /**
                                  *  editMask on top of the component is updated with EditProxy.selectedTintColor            and EditProxy.selectedTintOpacity
                                  *  editMask on top of the component is updated with EditProxy.selectedBorder
                                  *  MultiAutoChild is created on top of the component. This constructs a border around            the component using 4 separate outlineEdge components so that interactivity is not blocked.
                                  *  no change in appearance. Override EditProxy.showSelectedAppearance to create a custom appearance.
                                  */
                                 String /* tintMask |  outlineMask |  outlineEdges |  none */ = definedExternally
    /**
     *  Set the CSS border to be applied to the selection outline of the selected components.
     *   Default value is determined from EditContext.selectedBorder.
     *   This property is used when EditProxy.selectedAppearance is outlineMask
     *   or outlineEdges.
     *  @type {string}
     *  @default null
     */
    open var selectedBorder: String = definedExternally
    /**
     *  The background color for the selection outline label. The
     *   default is defined on SelectionOutline or EditContext.selectedLabelBackgroundColor.
     * 
     *   NOTE: A selected component label is only supported when
     *   EditProxy.selectedAppearance is "outlineEdges".
     *  @type {string}
     *  @default null
     */
    open var selectedLabelBackgroundColor: String = definedExternally
    /**
     *  Mask color applied to EditProxy.editMask of selected component when
     *   EditProxy.selectedAppearance is "tintMask".
     *   Default value is determined from EditContext.selectedTintColor.
     *  @type {CSSColor}
     *  @default null
     */
    open var selectedTintColor: String = definedExternally
    /**
     *  Opacity applied to EditProxy.editMask of selected component when
     *   EditProxy.selectedAppearance is "tintMask".
     *  @type {number}
     *  @default null
     */
    open var selectedTintOpacity: Number = definedExternally
    /**
     *  Whether this EditProxy has an inline edit behavior, which allows an end user to
     *   configure a component by editing a simple text representation of its configuration.
     * 
     *   For example, when inline edit is enabled, a SelectItem allows
     *   SelectItemEditProxy.getInlineEditText as a comma-separated
     *   string, and a ListGrid's columns and data can be edited as several lines of
     *   comma-separated headings and data values.
     * 
     *   See EditProxy.inlineEditEvent for more details and configuration options.
     *  @type {boolean}
     *  @default true
     */
    open var supportsInlineEdit: Boolean = definedExternally
    /**
     *  Should the inline editor be shown when new component is first dropped?
     *  @type {boolean}
     *  @default null
     */
    open var inlineEditOnDrop: Boolean = definedExternally
    /**
     *  Event that triggers inline editing, showing the EditProxy.inlineEditForm, which consists of a single
     *   text input (single or multi-line according to EditProxy.inlineEditMultiline) shown in the
     *   EditProxy.inlineEditForm AutoChild.
     * 
     *   The initial value in the form comes from EditProxy.getInlineEditText and is applied via
     *   EditProxy.setInlineEditText.
     * 
     *   Many EditProxy subclasses have built-in modes for inline editing.
     *  @type {InlineEditEvent}
     *  @default null
     */
    open var inlineEditEvent: 
                              /**
                               *  A single mouse click triggers inline editing
                               *  A double click triggers inline editing
                               *  No mouse event will trigger inline editing, but it can still              be triggered by a call to EditProxy.startInlineEditing.
                               *  A double click triggers inline editing. In addition, if              the widget is selected, starting to type triggers inline editing.
                               */
                              String /* click |  doubleClick |  none |  dblOrKeypress */ = definedExternally
    /**
     *  See EditProxy.inlineEditEvent.
     *  @type {DynamicForm}
     *  @default null
     */
    open var inlineEditForm: DynamicForm = definedExternally
    /**
     *  Label AutoChild used to display EditProxy.inlineEditInstructions below the text entry
     *   area if provided. Defaults to the same styling as the system Hover.
     *  @type {Label}
     *  @default null
     */
    open var inlineEditInstructionLabel: Label = definedExternally
    /**
     *  Instructions that appear below the text entry area if inline editing is enabled. See
     *   EditProxy.inlineEditEvent and EditProxy.inlineEditInstructionLabel.
     *  @type {HTMLString}
     *  @default null
     */
    open var inlineEditInstructions: String = definedExternally
    /**
     *  Whether inline editing should be single or multi-line.
     * 
     *   Single-line input appears at the control's top-left corner, multiline covers the control.
     *  @type {boolean}
     *  @default false
     */
    open var inlineEditMultiline: Boolean = definedExternally
    /**
     *  Should component be brought to front when selected? Applies when EditProxy.useEditMask:true.
     *  @type {boolean}
     *  @default null
     */
    open var bringToFrontOnSelect: Boolean = definedExternally
    /**
     *  Changes to all child EditNode.liveObject's position
     *   and size can be persisted to their EditNode based on this
     *   attribute setting and EditContext.persistCoordinates. This
     *   applies to both programmatic calls and user interaction (drag reposition
     *   or drag resize).
     * 
     *   The default value of null allows EditContext.persistCoordinates
     *   to control all coordinate persistence. An explicit value of false
     *   overrides the EditContext setting so that no children of the component save coordinates.
     * 
     *   All coordinate persisting can be disabled with EditContext.persistCoordinates.
     *   Additionally, all control of persistence can be deferred to each EditProxy by setting
     *   EditContext.persistCoordinates to null.
     *  @type {boolean}
     *  @default null
     */
    open var persistCoordinates: Boolean = definedExternally
    /**
     *  Hoop selector canvas used for selecting multiple components.
     * 
     *   Common customization properties can be provided by EditContext.hoopSelectorProperties.
     *  @type {Canvas}
     *  @default null
     */
    open var hoopSelector: Canvas = definedExternally
    /**
     *   Setter for EditProxy.canSelectChildren.
     * 
     *  @param {boolean} the new canSelectChildren
     */
    open fun setCanSelectChildren(canSelect: Boolean): Unit = definedExternally
    /**
     *   This method applies the EditProxy.selectedAppearance to the selected component
     *   or resets it to the non-selected appearance. Override this method to create a custom
     *   appearance.
     * 
     * 
     *  @param {boolean} true to show component as selected, false otherwise
     */
    open fun showSelectedAppearance(show: Boolean): Unit = definedExternally
    /**
     *   Manual means of triggering inline editing. See InlineEditEvent.
     * 
     * 
     *  @param {string=} optional String to append to current value as editing starts
     */
    open fun startInlineEditing(appendChar: String?): Unit = definedExternally
    /**
     *   Returns the text based on the current component state to be edited inline.
     *   Called by the EditProxy.inlineEditForm to obtain the starting edit value.
     * 
     *   For a canvas with isGroup enabled, the groupTitle
     *   is returned. Otherwise the contents is returned.
     * 
     * 
     */
    open fun getInlineEditText(): Unit = definedExternally
    /**
     *   Save the new value into the component's state. Called by the
     *   EditProxy.inlineEditForm to commit the change.
     * 
     *   For a canvas with isGroup enabled, the groupTitle
     *   is updated. Otherwise the contents is updated.
     * 
     * 
     *  @param {string} the new component state
     */
    open fun setInlineEditText(newValue: String): Unit = definedExternally
    companion object {
        /**
         *  Creates a new EditProxy
         * 
         *  @param typeCheckedProperties {Partial<EditProxy>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {EditProxy} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): EditProxy = definedExternally
    }
}