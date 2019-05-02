@file:JsQualifier("isc")
package isc

/**
 *  Component for editing a single record.
 *   RecordEditors are implemented as a subclass of ListGrid, showing no header and a single
 *   row always drawn in the editable state, allowing the user to modify the values at any time.
 *   The RecordEditor.actionButton is automatically shown as a way for the user to act
 *   upon the edited values.
 * 
 *   The RecordEditor class exists as a helper class for ListGrids, used to provide
 *   an interface for editing criteria when ListGrid.showFilterEditor
 *   is set to true.
 */
open external class RecordEditor : ListGrid {
    /**
     *  GridRenderer.baseStyle for this listGrid.
     *   If this property is unset, base style may be derived from ListGrid.normalBaseStyle
     *   or ListGrid.tallBaseStyle as described in
     *   ListGrid.getBaseStyle.
     * 
     *   See cellStyleSuffixes for details on how stateful suffixes are combined
     *   with the base style to generate stateful cell styles.
     *  @type {CSSStyleName}
     *  @default "recordEditorCell"
     */
    override var baseStyle: String = definedExternally
    /**
     *  Where do 'skin' images (those provided with the class) live?
     *  @type {SCImgURL}
     *  @default "images/RecordEditor/"
     */
    override var skinImgDir: String = definedExternally
    /**
     *  Button.icon to show on the RecordEditor.actionButton if this
     *   component is being used as a ListGrid.filterEditor.
     * 
     *   Note that this SCImgURL will be resolved using the RecordEditor.skinImgDir defined
     *   for the RecordEditor.
     *  @type {SCImgURL}
     *  @default "[SKIN]filter.png"
     */
    open var filterImg: String = definedExternally
    /**
     *  Automatically created Button auto-child shown at the edge of the recordEditor.
     *   For a recordEditor acting as a ListGrid.filterEditor, this button will
     *   show the RecordEditor.filterImg as an Button.icon by default.
     * 
     *   Clicking this button will call RecordEditor.performAction on the editor.
     * 
     *   May be customized using the standard AutoChild pattern, by overriding
     *   RecordEditor.actionButtonProperties.
     *  @type {Button}
     *  @default null
     */
    open var actionButton: Button = definedExternally
    /**
     *  Properties to apply to the automatically generated RecordEditor.actionButton.
     * 
     *   Note that for a recordEditor being used as a ListGrid.filterEditor, the
     *   ListGrid.filterButtonProperties can be used to specify actionButton properties
     *   directly at the grid level.
     *  @type {Button}
     *  @default null
     */
    open var actionButtonProperties: Button = definedExternally
    /**
     *  Button.baseStyle for the RecordEditor.actionButton
     *  @type {CSSStyleName}
     *  @default "normal"
     */
    open var actionButtonStyle: String = definedExternally
    /**
     *   Fired when the user clicks the RecordEditor.actionButton for this RecordEditor.
     *   May also be triggered from other user interaction with edit values (for
     *   example filter-editor change - see ListGrid.filterOnKeypress).
     * 
     *   This is the method which initiates a filter in a listGrid
     *   ListGrid.showFilterEditor. Note that for custom
     *   filtering behavior, developers can use the ListGrid.filterEditorSubmit
     *   notification method rather than overriding this method directly.
     * 
     * 
     */
    open fun performAction(): Unit = definedExternally
    companion object {
        /**
         *  Creates a new RecordEditor
         * 
         *  @param typeCheckedProperties {Partial<RecordEditor>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {RecordEditor} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): RecordEditor = definedExternally
    }
}