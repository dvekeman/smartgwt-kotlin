@file:JsQualifier("isc")
package isc

/**
 *  RichTextEditing component. Provides a rich-text editing area along with UI for executing
 *   rich-text commands on selected content.
 * 
 *   The HTML generated from this component may vary by browser, and, as with any HTML
 *   value created on the client, we recommend values be sanitized on the server before
 *   storing and displaying to other users.
 */
open external class RichTextEditor : VLayout {
    /**
     *  The edit canvas created automatically for this RichTextEditor.
     *  @type {Canvas}
     *  @default null
     */
    open var editArea: Canvas = definedExternally
    /**
     *  Background color for the RichTextEditor.editArea.
     *  @type {string}
     *  @default "white"
     */
    open var editAreaBackgroundColor: String = definedExternally
    /**
     *  Initial value for the edit area.  Use getValue() and
     *   setValue() to update at runtime.
     *  @type {string}
     *  @default ""
     */
    open var value: String = definedExternally
    /**
     *  Layout used to contain all of the RichTextEditor.toolbar AutoChildren
     *   that contain the RichTextEditor.controlGroups.
     *  @type {Layout}
     *  @default null
     */
    open var toolArea: Layout = definedExternally
    /**
     *  Layout used to contain each of the RichTextEditor.controlGroups.
     *  @type {Layout}
     *  @default null
     */
    open var toolbar: Layout = definedExternally
    /**
     *  The background color for the toolbar.
     *  @type {string}
     *  @default "#CCCCCC"
     */
    open var toolbarBackgroundColor: String = definedExternally
    /**
     *  An array of control groups specifying which groups of controls should be included in the
     *   editor tool area. The values of this array may be the name of a control group such as
     *   one of the StandardControlGroups, a Canvas, or the special string "break"
     *   which causes the subsequent control groups to continue onto a new line.
     * 
     * 
     *   For each control group name, this[controlGroupName] should be defined as an array of
     *   ControlNames or Canvas instances. This allows the controls of a control
     *   group to be customized.
     * 
     *  @type {Array<any>}
     *  @default "["fontControls", "formatControls", "styleControls", "colorControls"]"
     */
    open var controlGroups: Array<dynamic> = definedExternally
    /**
     *  Default text styling control group. Consists of an array of ControlNames
     *   and/or Canvas instances. To display this group of controls for some RichTextEditor,
     *   include "styleControls" in the RichTextEditor.controlGroups array.
     *  @type {Array<Partial<ControlName>>}
     *  @default "["boldSelection", "italicSelection", "underlineSelection"]"
     */
    open var styleControls: Array<dynamic> = definedExternally
    /**
     *  The AutoChild SelectItem used for choosing the font to apply
     *   to the current selection.
     *  @type {SelectItem}
     *  @default null
     */
    open var fontSelectorItem: SelectItem = definedExternally
    /**
     *  The AutoChild SelectItem used for choosing the font-size to
     *   apply to the current selection.
     *  @type {SelectItem}
     *  @default null
     */
    open var fontSizeSelectorItem: SelectItem = definedExternally
    /**
     *  The prompt for the built-in RichTextEditor.fontSelectorItem.
     *  @type {string}
     *  @default "Set Font..."
     */
    open var fontSelectorPrompt: String = definedExternally
    /**
     *  The prompt for the built-in RichTextEditor.fontSizeSelectorItem.
     *  @type {string}
     *  @default "Set Font Size..."
     */
    open var fontSizeSelectorPrompt: String = definedExternally
    /**
     *  The prompt displayed when editing a hyperlink.
     *  @type {string}
     *  @default "Hyperlink URL:"
     */
    open var linkUrlTitle: String = definedExternally
    /**
     *  The prompt for the built-in ControlName control.
     *  @type {string}
     *  @default "Make selection bold"
     */
    open var boldSelectionPrompt: String = definedExternally
    /**
     *  The prompt for the built-in ControlName control.
     *  @type {string}
     *  @default "Make selection italic"
     */
    open var italicSelectionPrompt: String = definedExternally
    /**
     *  The prompt for the built-in ControlName control.
     *  @type {string}
     *  @default "Make selection underlined"
     */
    open var underlineSelectionPrompt: String = definedExternally
    /**
     *  The prompt for the built-in ControlName control.
     *  @type {string}
     *  @default "Strike through selection"
     */
    open var strikethroughSelectionPrompt: String = definedExternally
    /**
     *  Default font control group. Consists of an array of ControlNames and/or
     *   Canvas instances. To display this group of controls for some RichTextEditor,
     *   include "fontControls" in the RichTextEditor.controlGroups array.
     *  @type {Array<Partial<ControlName>>}
     *  @default "["fontSelector", "fontSizeSelector"]"
     */
    open var fontControls: Array<dynamic> = definedExternally
    /**
     *  ValueMap of css fontName properties to font name titles to display in the font selector
     *   if "fontSelector" is included in RichTextEditor.controlGroups
     *   for this editor.
     *   Default value for this attribute:
     *   {
     *   &nbsp;&nbsp;"arial,helvetica,sans-serif": "Arial",
     *   &nbsp;&nbsp;'courier new,courier,monospace': "Courier New",
     *   &nbsp;&nbsp;'georgia,times new roman,times,serif': "Georgia",
     *   &nbsp;&nbsp;'tahoma,arial,helvetica,sans-serif': "Tahoma",
     *   &nbsp;&nbsp;'times new roman,times,serif': "Times New Roman",
     *   &nbsp;&nbsp;'verdana,arial,helvetica,sans-serif': "Verdana",
     *   &nbsp;&nbsp;"impact": "Impact"}
     *  @type {object}
     *  @default "{}"
     */
    open var fontNames: dynamic = definedExternally
    /**
     *  ValueMap of css font size property values to font size titles to display in the font size
     *   selector if "fontSizeSelector" is included in
     *   RichTextEditor.controlGroups.
     *   Default value for this attribute:
     *   {
     *   &nbsp;&nbsp;"1": "1 (8 pt)",
     *   &nbsp;&nbsp;"2": "2 (10 pt)",
     *   &nbsp;&nbsp;"3": "3 (12 pt)",
     *   &nbsp;&nbsp;"4": "4 (14 pt)",
     *   &nbsp;&nbsp;"5": "5 (18 pt)",
     *   &nbsp;&nbsp;"6": "6 (24 pt)",
     *   &nbsp;&nbsp;"7": "7 (36 pt)"}
     *  @type {object}
     *  @default "{}"
     */
    open var fontSizes: dynamic = definedExternally
    /**
     *  The prompt for the built-in ControlName control.
     *  @type {string}
     *  @default "Copy selection"
     */
    open var copySelectionPrompt: String = definedExternally
    /**
     *  The prompt for the built-in ControlName control.
     *  @type {string}
     *  @default "Cut selection"
     */
    open var cutSelectionPrompt: String = definedExternally
    /**
     *  The prompt for the built-in ControlName control.
     *  @type {string}
     *  @default "Paste"
     */
    open var pasteSelectionPrompt: String = definedExternally
    /**
     *  Default text formatting control group. Consists of an array of ControlNames
     *   and/or Canvas instances. To display this group of controls for some RichTextEditor,
     *   include "formatControls" in the RichTextEditor.controlGroups array.
     *  @type {Array<Partial<ControlName>>}
     *  @default "["alignLeft", "alignRight", "alignCenter", "justify"]"
     */
    open var formatControls: Array<dynamic> = definedExternally
    /**
     *  The prompt for the built-in ControlName control.
     *  @type {string}
     *  @default "Left align selection"
     */
    open var alignLeftPrompt: String = definedExternally
    /**
     *  The prompt for the built-in ControlName control.
     *  @type {string}
     *  @default "Center selection"
     */
    open var alignCenterPrompt: String = definedExternally
    /**
     *  The prompt for the built-in ControlName control.
     *  @type {string}
     *  @default "Right align selection"
     */
    open var alignRightPrompt: String = definedExternally
    /**
     *  The prompt for the built-in ControlName control.
     *  @type {string}
     *  @default "Full justify selection"
     */
    open var justifyPrompt: String = definedExternally
    /**
     *  Control group for modifying text color / background color.
     *   Consists of an array of ControlNames and/or Canvas instances.
     *   To display this group of controls for some RichTextEditor,
     *   include "formatControls" in the RichTextEditor.controlGroups array.
     *  @type {Array<Partial<ControlName>>}
     *  @default "["color", "backgroundColor"]"
     */
    open var colorControls: Array<dynamic> = definedExternally
    /**
     *  The prompt for the built-in ControlName control.
     *  @type {string}
     *  @default "Set selection text color"
     */
    open var colorPrompt: String = definedExternally
    /**
     *  The prompt for the built-in ControlName control.
     *  @type {string}
     *  @default "Set selection background color"
     */
    open var backgroundColorPrompt: String = definedExternally
    /**
     *  The prompt for the built-in ControlName control.
     *  @type {string}
     *  @default "Edit Hyperlink"
     */
    open var linkPrompt: String = definedExternally
    /**
     *  Default HTML list control group. Consists of an array of ControlNames and/or
     *   Canvas instances. To display this group of controls for some RichTextEditor,
     *   include "bulletControls" in the RichTextEditor.controlGroups array.
     *  @type {Array<Partial<ControlName>>}
     *  @default "["indent", "outdent", "orderedList", "unorderedList", "listProperties"]"
     */
    open var bulletControls: Array<dynamic> = definedExternally
    /**
     *  The prompt for the built-in ControlName control.
     *  @type {string}
     *  @default "Increase indent"
     */
    open var indentPrompt: String = definedExternally
    /**
     *  The prompt for the built-in ControlName control.
     *  @type {string}
     *  @default "Decrease indent"
     */
    open var outdentPrompt: String = definedExternally
    /**
     *  The prompt for the built-in ControlName control.
     *  @type {string}
     *  @default "Convert to a numbered list"
     */
    open var orderedListPrompt: String = definedExternally
    /**
     *  The prompt for the built-in ControlName control.
     *  @type {string}
     *  @default "Convert to a bullet list"
     */
    open var unorderedListPrompt: String = definedExternally
    /**
     *  The prompt for the built-in ControlName control.
     *  @type {string}
     *  @default "Configure the list"
     */
    open var listPropertiesPrompt: String = definedExternally
    /**
     *  If the user presses the "Tab" key, should focus be taken from this editor?
     *   If set to false a "Tab" keypress will cause a Tab character
     *   to be inserted into the text, and focus will be left in the edit area.
     *  @type {boolean}
     *  @default true
     */
    open var moveFocusOnTab: Boolean = definedExternally
    /**
     *  Dialog shown when the ControlName is pressed.
     *   Provides options for the user to control formatting of lists.
     *  @type {ListPropertiesDialog}
     *  @default null
     */
    open var listPropertiesDialog: ListPropertiesDialog = definedExternally
    /**
     *  The warning message displayed in a dialog when a user tries to configure a list without
     *   first putting the cursor in an appropriate place.
     *  @type {string}
     *  @default "Place the cursor within a list to configure it"
     */
    open var listPropertiesWarningText: String = definedExternally
    /**
     *   Display a warning if Rich Text Editing is not fully supported in this browser.
     *   Default behavior logs a warning to the developer console - Override this if a user-visible
     *   warning is required
     * 
     */
    open fun doWarn(): Unit = definedExternally
    /**
     *   Does this browser support the full RichTextEditor feature set.
     *   Returns false for browsers in which some features are not natively supported
     *   (Safari before version 3.1 and Opera before version 9.50).
     * 
     */
    open fun richEditorSupported(): Boolean = definedExternally
    /**
     *   Setter for RichTextEditor.moveFocusOnTab.
     * 
     *  @param {boolean} new value for moveFocusOnTab
     */
    open fun setMoveFocusOnTab(moveFocusOnTab: Boolean): Unit = definedExternally
    /**
     *   Retrieves the current value of the edit area.
     * 
     */
    open fun getValue(): Unit = definedExternally
    /**
     *   Updates the current value of the edit area.
     * 
     */
    open fun setValue(): Unit = definedExternally
    companion object {
        /**
         *  Creates a new RichTextEditor
         * 
         *  @param typeCheckedProperties {Partial<RichTextEditor>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {RichTextEditor} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): RichTextEditor = definedExternally
    }
}