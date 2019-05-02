@file:JsQualifier("isc")
package isc

/**
 *  EditProxy that handles ListGrid and TreeGrid components when editMode is enabled.
 */
open external class GridEditProxy : LayoutEditProxy {
    /**
     *  Should changes to grid field order be persisted?
     * 
     *   Note that changes are saved directly into the ListGridFields not via fieldState or viewState settings.
     *   EditNodes will also be introduced for fields as needed if they do not already exist.
     * 
     *   Only valid with SelectedAppearance settings that allow direct interactivity
     *   (such as "outlineEdges").
     *  @type {boolean}
     *  @default true
     */
    open var saveFieldOrder: Boolean = definedExternally
    /**
     *  Should changes to grid field visibility be persisted?
     * 
     *   Note that changes are saved directly into the ListGridFields not via fieldState or viewState settings.
     *   EditNodes will also be introduced for fields as needed if they do not already exist.
     * 
     *   Only valid with SelectedAppearance settings that allow direct interactivity
     *   (such as "outlineEdges").
     *  @type {boolean}
     *  @default true
     */
    open var saveFieldVisibility: Boolean = definedExternally
    /**
     *  Should changes to which fields are ListGridField.frozen be persisted?
     * 
     *   Note that changes are saved directly into the ListGridFields not via fieldState or viewState settings.
     *   EditNodes will also be introduced for fields as needed if they do not already exist.
     * 
     *   Only valid with SelectedAppearance settings that allow direct interactivity
     *   (such as "outlineEdges").
     *  @type {boolean}
     *  @default true
     */
    open var saveFieldFrozenState: Boolean = definedExternally
    /**
     *  Should changes to which fields are sorted be persisted?
     * 
     *   Only valid with SelectedAppearance settings that allow direct interactivity
     *   (such as "outlineEdges").
     *  @type {boolean}
     *  @default true
     */
    open var saveSort: Boolean = definedExternally
    /**
     *  Should changes to grid grouping (including both grouping and ungrouping the grid) be
     *   persisted?
     * 
     *   Only valid with SelectedAppearance settings that allow direct interactivity
     *   (such as "outlineEdges").
     *  @type {boolean}
     *  @default true
     */
    open var saveGroupBy: Boolean = definedExternally
    /**
     *  Should changes to filter criteria by end user editing of criteria in the
     *   ListGrid.showFilterEditor by persisted?
     * 
     *   Only valid with SelectedAppearance settings that allow direct interactivity
     *   (such as "outlineEdges").
     *  @type {boolean}
     *  @default true
     */
    open var saveFilterCriteria: Boolean = definedExternally
    /**
     *  Can highlights be edited from header context menu?
     *   Overrides ListGrid.canEditHilites when in edit mode.
     *  @type {boolean}
     *  @default true
     */
    open var canEditHilites: Boolean = definedExternally
    /**
     *  Can new formula fields be created from header context menu?
     *   Overrides ListGrid.canAddFormulaFields when in edit mode.
     *  @type {boolean}
     *  @default true
     */
    open var canAddFormulaFields: Boolean = definedExternally
    /**
     *  Can new summary fields be created from header context menu?
     *   Overrides ListGrid.canAddSummaryFields when in edit mode.
     *  @type {boolean}
     *  @default true
     */
    open var canAddSummaryFields: Boolean = definedExternally
    /**
     *  Can records be grouped from header context menu?
     *   Overrides ListGrid.canGroupBy when in edit mode.
     *  @type {boolean}
     *  @default true
     */
    open var canGroupBy: Boolean = definedExternally
    /**
     *  Indicates whether fields in this listGrid can be reordered by dragging and
     *   dropping header fields.
     *   Overrides ListGrid.canReorderFields when in edit mode.
     *  @type {boolean}
     *  @default true
     */
    open var canReorderFields: Boolean = definedExternally
    /**
     *  Indicates whether fields in this listGrid can be resized by dragging header
     *   fields.
     *   Overrides ListGrid.canResizeFields when in edit mode.
     *  @type {boolean}
     *  @default true
     */
    open var canResizeFields: Boolean = definedExternally
    /**
     *  Controls whether highlights created while in edit mode are editable by end users at
     *   runtime (when the grid is no longer in edit mode). See Hilite.canEdit.
     *  @type {boolean}
     *  @default true
     */
    open var generateEditableHilites: Boolean = definedExternally
    /**
     *  Controls whether formula fields created while in edit mode are editable by end users at
     *   runtime (when the grid is no longer in edit mode). See
     *   ListGridField.canEditFormula.
     *  @type {boolean}
     *  @default true
     */
    open var generateEditableFormulas: Boolean = definedExternally
    /**
     *  Controls whether summary fields created while in edit mode are editable by end users at
     *   runtime (when the grid is no longer in edit mode). See
     *   ListGridField.canEditSummary.
     *  @type {boolean}
     *  @default true
     */
    open var generateEditableSummaries: Boolean = definedExternally
    /**
     *   Returns the text based on the current component state to be edited inline.
     *   Called by the EditProxy.inlineEditForm to obtain the starting edit value.
     * 
     *   Returns the grid's wiki-style data - see MockDataSource.mockData for a
     *   description of this format.
     * 
     * 
     */
    override fun getInlineEditText(): Unit = definedExternally
    /**
     *   Save the new value into the component's state. Called by the
     *   EditProxy.inlineEditForm to commit the change.
     * 
     *   Updates the grid's data and field configuration.
     * 
     * 
     *  @param {string} the new grid configuration
     */
    override fun setInlineEditText(newValue: String): Unit = definedExternally
    companion object {
        /**
         *  Creates a new GridEditProxy
         * 
         *  @param typeCheckedProperties {Partial<GridEditProxy>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {GridEditProxy} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): GridEditProxy = definedExternally
    }
}