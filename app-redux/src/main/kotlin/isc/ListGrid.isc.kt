@file:JsQualifier("isc")
package isc

/**
 *  A ListGrid is a DataBoundComponent that displays a list of objects in a grid, where
 *   each row represents one object and each cell in the row represents one property.
 */
open external class ListGrid : VLayout, DataBoundComponent {
    /**
     *  The CSS style name applied to the DataBoundComponent.offlineMessage if displayed.
     *  @type {CSSStyleName}
     *  @default "offlineMessage"
     */
    open var offlineMessageStyle: String = definedExternally
    /**
     *  If true, when this component is first drawn, automatically call this.fetchData().
     *   Criteria for this fetch may be picked up from ListGrid.initialCriteria, and textMatchStyle may
     *   be specified via ListGrid.autoFetchTextMatchStyle.
     * 
     *   NOTE: if autoFetchData is set, calling
     *   ListGrid.fetchData before draw will cause two requests to be issued, one from the manual
     *   call to fetchData() and one from the autoFetchData setting. The second request will use
     *   only ListGrid.initialCriteria and not any other criteria or settings from the first request.
     *   Generally, turn off autoFetchData if you are going to manually call ListGrid.fetchData at any time.
     *  @type {boolean}
     *  @default false
     */
    override var autoFetchData: Boolean = definedExternally
    /**
     *  Criteria to be used when ListGrid.autoFetchData is set.
     * 
     *   This property supports dynamicCriteria - use Criterion.valuePath
     *   to refer to values in the Canvas.ruleScope.
     *  @type {Criteria}
     *  @default null
     */
    override var initialCriteria: dynamic = definedExternally
    /**
     *  Default background color to use when exporting data to Excel/OpenOffice format using
     *   ListGrid.exportData or
     *   ListGrid.exportClientData.
     * 
     *   If unset (the default), cells that are not provided a background color by more specific APIs
     *   will be the default background color used by the spreadsheet program where they are viewed.
     * 
     *   See exportBGColor for an overview.
     *  @type {CSSColor}
     *  @default null
     */
    open var exportDefaultBGColor: String = definedExternally
    /**
     *  When exporting data to Excel/OpenOffice format using ListGrid.exportData or
     *   ListGrid.exportClientData, background color to use
     *   for even-numbered rows, to create a "banded" or "ledger" effect. Odd-numbered rows will
     *   use the ListGrid.exportDefaultBGColor.
     * 
     *   See exportBGColor for an overview.
     *  @type {CSSColor}
     *  @default null
     */
    open var exportAlternateRowBGColor: String = definedExternally
    /**
     *  When exporting data to Excel/OpenOffice format using ListGrid.exportData or
     *   ListGrid.exportClientData, causes the ListGrid.headerHeight and
     *   HeaderSpan.height to be applied to the corresponding cells in the
     *   spreadsheet.
     *  @type {boolean}
     *  @default false
     */
    open var exportHeaderHeights: Boolean = definedExternally
    /**
     *  When exporting data to Excel/OpenOffice format using ListGrid.exportData or
     *   ListGrid.exportClientData, whether widths of fields should be replicated
     *   in the resulting spreadsheet.
     * 
     *   Because Excel's unit of measurement for field widths is based on the default system font,
     *   there is no exact way to translate field widths in pixels to Excel column widths. The
     *   ListGrid.exportWidthScale property can be set to adjust scaling; it's default value errs on
     *   the side of making Excel's columns slightly wider than the ListGrid field's actual width to
     *   avoid clipping.
     * 
     *   Note that you can switch off width export for individual fields with the
     *   ListGridField.exportFieldWidth flag.
     *  @type {boolean}
     *  @default false
     */
    open var exportFieldWidths: Boolean = definedExternally
    /**
     *  Scaling factor to translate from ListGrid field widths in pixels to Excel/OpenOffice units
     *   for field width, which are 1/256th of the width of the widest digit character in the default
     *   font for the spreadsheet. See ListGrid.exportFieldWidths for where this is used.
     *  @type {Float}
     *  @default "0.12"
     */
    open var exportWidthScale: Number = definedExternally
    /**
     *  When exporting data to Excel/OpenOffice format using ListGrid.exportData or
     *   ListGrid.exportClientData, whether titles in the
     *   ListGrid.header and ListGrid.headerSpans should be
     *   allowed to wrap.
     * 
     *   Excel will wrap at the column boundary automatically; for explicit control over wrapping,
     *   insert "&lt;br&gt;" tags into your titles.
     * 
     *   See also ListGrid.exportFieldWidths for replicating the widths of fields in the exported
     *   spreadsheet.
     *  @type {boolean}
     *  @default false
     */
    open var exportWrapHeaderTitles: Boolean = definedExternally
    /**
     *  When exporting data to Excel/OpenOffice format using ListGrid.exportData or
     *   ListGrid.exportClientData, whether field
     *   ListGridField.align and
     *   ListGridField.cellAlign should be replicated in the resulting
     *   spreadsheet.
     * 
     *   If this attribute is not set, cells will be assigned a default alignment by the spreadsheet,
     *   which is typically right-aligned for numeric and date values, and left-aligned for
     *   everything else (including dates and numbers that have been exported as strings, as would
     *   be the case, for example, if DSRequest.exportDatesAsFormattedString is set)
     *  @type {boolean}
     *  @default false
     */
    open var exportFieldAlignments: Boolean = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "GridEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
    /**
     *  Default CSS class for the ListGrid as a whole.
     *  @type {CSSStyleName}
     *  @default "listGrid"
     */
    override var styleName: String = definedExternally
    /**
     *  A list of ListGridRecord objects, specifying the data to be used to populate the
     *   ListGrid. In ListGrids, the data array specifies rows.
     * 
     *   When using a DataSource, rather than directly providing data, you will
     *   typically call ListGrid.fetchData instead, which will automatically establish
     *   data as a ResultSet (see the ListGrid.fetchData docs for details).
     * 
     *   If you call fetchData, any previously supplied data is
     *   discarded. Also, it is not necessary to call setData() after calling
     *   ListGrid.fetchData.
     * 
     *   When calling setData(), direct changes
     *   to the list using Framework APIs such as List.add or
     *   List.remove will be automatically observed and the
     *   ListGrid will redraw in response. However, direct changes to individual Records will not
     *   be automatically observed and require calls to ListGrid.refreshCell or
     *   ListGrid.refreshRow to cause the ListGrid to visually update. Calling methods such as
     *   ListGrid.updateData, ListGrid.removeData or ListGrid.addData always causes
     *   automatic visual refresh.
     * 
     *   Note that direct manipulation of the data object without using the List APIs (for
     *   example by directly assigning a new Record object to some index or calling non-Framework
     *   APIs such as pop(), shift(), etc.) will not be reflected in the grid automatically, but
     *   developers can call List.dataChanged directly to notify the grid of changes.
     * 
     *  @type {Array<Partial<ListGridRecord>>}
     *  @default null
     */
    open var data: Array<dynamic> = definedExternally
    /**
     *  Property name on a record that will be checked to determine whether a record is enabled.
     * 
     *   Setting this property on a record will effect the visual style and interactivity of
     *   the record. If set to false the record (row in a ListGrid or
     *   TreeGrid) will not highlight when the mouse moves over it, nor will it respond to
     *   mouse clicks.
     *  @type {string}
     *  @default "enabled"
     */
    open var recordEnabledProperty: String = definedExternally
    /**
     *  Property name on a record that will be checked to determine whether a record can be
     *   expanded.
     *  @type {string}
     *  @default "canExpand"
     */
    open var canExpandRecordProperty: String = definedExternally
    /**
     *  If set to false on a record and ListGrid.canRemoveRecords is
     *   true, removal of that record is disallowed in the UI. The icon in the remove field
     *   is not shown.
     *  @type {string}
     *  @default "_canRemove"
     */
    open var recordCanRemoveProperty: String = definedExternally
    /**
     *  If true, when folders are opened / closed children will be animated into view.
     * 
     *   For a ListGrid, this property applies when ListGrid.canGroupBy is enabled.
     *  @type {boolean}
     *  @default true
     */
    open var animateFolders: Boolean = definedExternally
    /**
     *  If ListGrid.animateFolders is true for this grid, this number can be set to designate
     *   the maximum number of rows to animate at a time when opening / closing a folder.
     * 
     *   For a ListGrid, this property applies when ListGrid.canGroupBy is enabled.
     *  @type {Integer}
     *  @default null
     */
    open var animateFolderMaxRows: Number = definedExternally
    /**
     *  When animating folder opening / closing, if TreeGrid.animateFolderSpeed is not
     *   set, this property designates the duration of the animation in ms.
     * 
     *   For a ListGrid, this property applies when ListGrid.canGroupBy is enabled.
     *  @type {number}
     *  @default "100"
     */
    open var animateFolderTime: Number = definedExternally
    /**
     *  When animating folder opening / closing, this property designates the speed of the
     *   animation in pixels shown (or hidden) per second. Takes precedence over the
     *   TreeGrid.animateFolderTime property, which allows the developer to specify a
     *   duration for the animation rather than a speed.
     * 
     *   For a ListGrid, this property applies when ListGrid.canGroupBy is enabled.
     *  @type {number}
     *  @default "3000"
     */
    open var animateFolderSpeed: Number = definedExternally
    /**
     *  When animating folder opening / closing, this property can be set to apply an
     *   animated acceleration effect. This allows the animation speed to be "weighted", for
     *   example expanding or collapsing at a faster rate toward the beginning of the animation
     *   than at the end.
     * 
     *   For a ListGrid, this property applies when ListGrid.canGroupBy is enabled.
     *  @type {AnimationAcceleration}
     *  @default null
     */
    open var animateFolderEffect: 
                                  /**
                                   *  - animation will speed up as time elapses
                                   *  - animation will slow down as time elapses
                                   *  - animation will speed up in the middle
                                   *  - no bias
                                   */
                                  String /* smoothStart |  smoothEnd |  smoothStartEnd |  none */ = definedExternally
    /**
     *  An array of field objects, specifying the order, layout, formatting, and
     *   sorting behavior of each field in the listGrid object. In ListGrids, the fields
     *   array specifies columns. Each field in the fields array is a ListGridField object.
     *   Any listGrid that will display data should have at least one visible field.
     * 
     *   If ListGrid.dataSource is also set, this value acts as a set of overrides as
     *   explained in DataBoundComponent.fields.
     *  @type {Array<Partial<ListGridField>>}
     *  @default null
     */
    override var fields: Array<dynamic> = definedExternally
    /**
     *  An array of listGrid field configuration objects. When a listGrid is initialized, if this
     *   property is set and there is no value for the fields attribute, this.fields will
     *   be defaulted to a generated array of field objects duplicated from this array.
     * 
     *   This property is useful for cases where a standard set of fields will be displayed
     *   in multiple listGrids - for example a subclass of ListGrid intended to display a particular
     *   type of data:
     *   In this example we would not assign a single ListGrid.fields array directly to the
     *   class via addProperties() as every generated instance of this class would
     *   then point to the same fields array object. This would cause unexpected behavior such as
     *   changes to the field order in one grid effecting other grids on the page.
     *   Instead we could use addProperties() on our new subclass to set
     *   defaultFields to a standard array of fields to display. Each generated instance
     *   of the subclass would then show up with default fields duplicated from this array.
     *  @type {Array<Partial<ListGridField>>}
     *  @default null
     */
    open var defaultFields: Array<dynamic> = definedExternally
    /**
     *  The DataSource that this component should bind to for default fields and for performing
     *   DSRequest.
     * 
     *   Can be specified as either a DataSource instance or the String ID of a DataSource.
     *  @type {DataSource | GlobalId}
     *  @default null
     */
    override var dataSource: dynamic = definedExternally
    /**
     *  If true, for fields where ListGridField.optionDataSource is specified,
     *   a valueMap will be automatically created by making a DataSource.fetchData call
     *   against the specified dataSource and extracting a valueMap from the returned records
     *   based on the displayField and valueField.
     * 
     *   If set to false, valueMaps will not be automatically fetched. In this case, setting
     *   field.optionDataSource is effectively a shortcut for setting optionDataSource on
     *   the editor via ListGridField.editorProperties.
     * 
     *   Can also be disabled on a per-field basis with ListGridField.autoFetchDisplayMap.
     *  @type {boolean}
     *  @default true
     */
    open var autoFetchDisplayMap: Boolean = definedExternally
    /**
     *  If a field has ListGridField.displayField specified and has no
     *   ListGridField.optionDataSource, this field will display the value from the
     *   displayField of each record by default (for more on this behavior
     *   see ListGridField.optionDataSource).
     * 
     *   If such a field is editable, changing the edit value for the field on some record,
     *   without updating the edit value for the associated display field on the same record
     *   would mean the user would continue to see the unchanged display field value.
     *   Developers can resolve this situation by programmatically setting an edit value for
     *   the display field as well as the data field, or avoid it by specifying an optionDataSource
     *   and ensuring ListGrid.autoFetchDisplayMap is true, or setting an explicit valueMap
     *   for the field.
     * 
     *   By default, when the edit value on a field with a specified displayField and
     *   no optionDataSource is set, we log a warning to notify the developer. This warning may
     *   be disabled by setting warnOnUnmappedValueFieldChange to false.
     * 
     *   Note: There are actually a couple of cases in which the system will automatically
     *   derive a new display-field value and apply it to the record:
     * 
     *  - If the edit value was changed by a user actually editing the record
     *   (rather than a programmatic call to setEditValue()), and the edit-item had
     *   a valueMap or optionDataSource set, we automatically pick up the display value from
     *   that item and store it as an edit-value for the displayField of the record
     * 
     *  - If the listGrid has a loaded record in its data set whose valueField value matches
     *   the edit value for the valueField, we automatically apply the displayField value from that
     *   record as an edit value for the displayField on the newly edited record.
     *   In either case, the display value for the record is updated automatically
     *   (and the warning would not be logged).
     *  @type {boolean}
     *  @default true
     */
    open var warnOnUnmappedValueFieldChange: Boolean = definedExternally
    /**
     *  For grids with a specified ListGrid.dataSource, this property can be set to
     *   true to cause the grid directly update its local data set instead of
     *   performing an operation against it's configured DataSource.
     * 
     *   When using this mode, data must be provided to the grid via ListGrid.setData,
     *   and must be provided as
     *   a simple Array of Records
     *   . Setting saveLocally is invalid if
     *   either ListGrid.fetchData is called or if a ResultSet is provided as the data
     *   model.
     * 
     *   saveLocally mode includes changes made via
     *   ListGrid.canEdit, record removal via ListGrid.canRemoveRecords, as
     *   well as programmatic calls to ListGrid.updateData,
     *   ListGrid.addData and ListGrid.removeData. This
     *   also causes saves to be performed synchronously (unlike normal DataSource operations).
     * 
     *   Note that using this mode also disables the automatic cache synchronization provided by
     *   the DataSource system - changes made to this grid are saved only to this grid's data
     *   set.
     * 
     *   See also ListGrid.filterLocalData to allow filtering, such as filtering performed
     *   by the ListGrid.filterEditor, to also work only with the local data set.
     * 
     *   If saveLocally is unset, and ListGrid.filterLocalData is true, the saveLocally behavior is
     *   enabled by default
     *  @type {boolean}
     *  @default null
     */
    open var saveLocally: Boolean = definedExternally
    /**
     *  For editable grids with a specified ListGrid.dataSource, where
     *   ListGrid.saveLocally is false, this attribute may be used to specify standard
     *   DSRequest properties to apply to all save operations performed by this grid (whether
     *   triggered by user interaction, or explicit saveEdits or saveAllEdits call).
     * 
     *   An example usage would be to customize the prompt displayed while saving is in progress
     *   if ListGrid.waitForSave is true.
     * 
     *   Note that for more advanced customization of save operations,
     *   DataBoundComponent.addOperation and DataBoundComponent.updateOperation
     *   are available to developers, allowing specification of an explicit OperationBinding
     *   for the add / update operation performed on save.
     *  @type {DSRequest}
     *  @default null
     */
    open var saveRequestProperties: DSRequest = definedExternally
    /**
     *  If ListGrid.saveLocally is specified, but this grid is bound to a DataSource which
     *   includes remote field validators, by default edits will be saved synchronously and
     *   these validators will not be executed.
     *   Set this property to true to ensure these remote validators are called when
     *   saving edits in saveLocally mode. Note that since these remote validators need to run on
     *   the server, saving with this property set is asynchronous, even though the data that
     *   ultimately gets updated is already present on the client.
     *  @type {boolean}
     *  @default null
     */
    open var useRemoteValidators: Boolean = definedExternally
    /**
     *  If true, the set of fields given by the "default binding" (see
     *   DataBoundComponent.fields) is used, with any fields specified in
     *   component.fields acting as overrides that can suppress or modify the
     *   display of individual fields, without having to list the entire set of fields that
     *   should be shown.
     * 
     *   If component.fields contains fields that are not found in the DataSource,
     *   they will be shown after the most recently referred to DataSource field. If the new
     *   fields appear first, they will be shown first.
     * 
     *   ${isc.DocUtils.linkForExampleId('validationFieldBinding', 'This example')} shows a mixture of component
     *   fields and DataSource fields, and how they interact for validation.
     * 
     *   This setting may be cleared if a FieldPicker is used to edit the component's field
     *   order.
     *  @type {boolean}
     *  @default null
     */
    override var useAllDataSourceFields: Boolean = definedExternally
    /**
     *  Whether to include fields marked detail:true from this component's
     *   DataSource.
     * 
     *   When this property is true, the ListGrid will include all
     *   detail fields unless fields have been specifically declared using the
     *   ListGrid.fields array.
     * 
     *   Any field which has been included directly in the fields array will be
     *   included regardless of the fields detail attribute.
     * 
     *   Detail fields included will initially be hidden but the user may show these fields via
     *   the default header context menu (ListGrid.showHeaderContextMenu).
     * 
     *   The field's visibility can also be overridden programatically using the standard
     *   ListGrid.showField, ListGrid.hideField and ListGridField.showIf
     *   APIs, for example, set showIf:"true" to show a detail field initially.
     * 
     *   Setting this property to false will completely exclude all detail fields from the list
     *   grid's fields array, such that they cannot be shown by the user or programmatically.
     *  @type {boolean}
     *  @default true
     */
    override var showDetailFields: Boolean = definedExternally
    /**
     *  Best field to use for a user-visible title for an individual record from this grid.
     *   If ListGrid.dataSource is non null, this property may be specified on the
     *   dataSource instead.
     * 
     *   If not explicitly set, titleField looks for fields named "title", "name", and "id"
     *   in that order. If a field exists with one of those names, it becomes the titleField.
     *   If not, then the first field is designated as the titleField.
     *  @type {string}
     *  @default "see below"
     */
    override var titleField: String = definedExternally
    /**
     *  For databound ListGrids, this attribute can be used to customize the ResultSet
     *   object created for this grid when data is fetched
     *  @type {ResultSet}
     *  @default null
     */
    open var dataProperties: ResultSet = definedExternally
    /**
     *  When grouped, a copy of the original ungrouped data.
     *  @type {object}
     *  @default null
     */
    open var originalData: dynamic = definedExternally
    /**
     *  The data tree that results from a call to ListGrid.groupBy.
     *   This will be a ResultTree if ListGrid.dataSource is
     *   present, otherwise it will be a Tree.
     *  @type {Tree}
     *  @default null
     */
    open var groupTree: Tree = definedExternally
    /**
     *  Describes the default state of ListGrid groups when groupBy is called.
     * 
     *   Possible values are:
     * 
     * 
     *  - "all": open all groups
     * 
     *  - "first": open the first group
     * 
     *  - "none": start with all groups closed
     * 
     *  - Array of group values that should be opened
     * 
     *  @type {GroupStartOpen | Array<any>}
     *  @default "first"
     */
    open var groupStartOpen: dynamic = definedExternally
    /**
     *  Can a group be collapsed/expanded? When true a collapse/expand icon is shown
     *   (ListGrid.groupIcon) and the user can collapse or expand the group by
     *   clicking either the row as a whole or the opener icon (see ListGrid.collapseGroupOnRowClick);
     * 
     *   When false the group icon is not shown and clicking on the row does
     *   not change group state. Additionally GroupStartOpen is
     *   initialized to "all".
     *  @type {boolean}
     *  @default true
     */
    open var canCollapseGroup: Boolean = definedExternally
    /**
     *  If ListGrid.canCollapseGroup is true, will a click anywhere on the group row
     *   toggle the group's expanded state? If false, the user must click the
     *   ListGrid.groupIcon directly to toggle the group.
     *  @type {boolean}
     *  @default true
     */
    open var collapseGroupOnRowClick: Boolean = definedExternally
    /**
     *  When a list grid is ListGrid.groupBy, each group shows
     *   under an auto generated header node. By default the title of the group will be
     *   shown, with a hanging indent in this node, and will span all columns in the grid.
     *   Setting this property causes the titles of auto-generated group nodes to appear as
     *   though they were values of the designated field instead of spanning all columns
     *   and record values in the designated groupTitleField will appear indented under
     *   the group title in a manner similar to how a TreeGrid shows a Tree.
     * 
     *   Note if ListGrid.showGroupSummaryInHeader is true, the header nodes will not show
     *   a single spanning title value by default - instead they will show the summary values for
     *   each field. In this case, if groupTitleField is unset, a
     *   ListGrid.showGroupTitleColumn can be automatically generated to
     *   show the title for each group.
     *  @type {string}
     *  @default null
     */
    open var groupTitleField: String = definedExternally
    /**
     *  If this grid is ListGrid.groupBy and ListGrid.showGroupSummaryInHeader
     *   is true, instead of group header nodes showing up with a single cell value spanning the full
     *   set of columns, summaries for each field will show up in the appropriate columns of the
     *   header node.
     * 
     *   In this case there are 2 options for where the group title will show up. Developers may
     *   specify an existing field to put the title values into via ListGrid.groupTitleField.
     *   If no groupTitleField is specified, this property may be set to true
     *   which causes a groupTitleColumn to be automatically generated.
     *   Each group header will show the group title in this column (records within the group will
     *   not show a value for this column). The column appears in the leftmost position within the
     *   grid (unless ListGrid.showRowNumbers is true, in which case this column shows up
     *   in the second-leftmost position), and by default will auto-fit to its data.
     * 
     *   To customize this field, developers may modify
     *   ListGrid.groupTitleColumnProperties
     *   or
     *   ListGrid.groupTitleColumnDefaults at the class level.
     *  @type {boolean}
     *  @default true
     */
    open var showGroupTitleColumn: Boolean = definedExternally
    /**
     *  Custom properties for the automatically generated groupTitleColumn.
     * 
     *   See ListGrid.showGroupTitleColumn for an overview of the groupTitleColumn.
     *  @type {ListGridField}
     *  @default null
     */
    open var groupTitleColumnProperties: ListGridField = definedExternally
    /**
     *  Default properties for the automatically generated groupTitleColumn.
     *   Default object includes properties to enable autoFitWidth to group title values.
     * 
     *   To modify the behavior or appearance of this column, developers may set
     *   ListGrid.groupTitleColumnProperties at the instance level, or override this
     *   object at the class level. If overriding this object, we recommend using
     *   Class.changeDefaults rather than replacing this object entirely.
     * 
     *   See ListGrid.showGroupTitleColumn for an overview of the groupTitleColumn.
     *  @type {ListGridField}
     *  @default "object"
     */
    open var groupTitleColumnDefaults: ListGridField = definedExternally
    /**
     *  If this grid is ListGrid.groupBy, and ListGrid.showGroupSummary
     *   is true, setting this property causes field summary values for each group to be displayed
     *   directly in the group header node, rather than showing up at the bottom of each
     *   expanded group.
     * 
     *   Note that this means the group header node will be showing multiple field values
     *   rather than the default display of a single cell spanning all columns containing the
     *   group title. Developers may specify an explicit ListGrid.groupTitleField, or
     *   rely on the automatically generated ListGrid.showGroupTitleColumn
     *   to have group titles be visible as well as the summary values.
     * 
     *   Also note that multi-line group summaries are not supported when showing
     *   the group summary in the group header. If multiple
     *   ListGridField.summaryFunction are defined for some field
     *   only the first will be displayed when this property is set to true.
     *  @type {boolean}
     *  @default false
     */
    open var showGroupSummaryInHeader: Boolean = definedExternally
    /**
     *  Should group summaries be visible when the group is collapsed?
     * 
     *   This property only applies to ListGrid.groupBy grids showing
     *   ListGrid.showGroupSummary. When set to true, the
     *   group summary row(s) for each group will show up under the group header nodes when
     *   the group is collapsed, or at then end of the grouped set of data if the group
     *   is expanded.
     * 
     *   This property has no effect if ListGrid.showGroupSummaryInHeader is true.
     *  @type {boolean}
     *  @default false
     */
    open var showCollapsedGroupSummary: Boolean = definedExternally
    /**
     *  The CSS style that ListGrid.groupBy rows will have.
     * 
     *   Note that this is not a ListGrid.getBaseStyle, so, if this
     *   property is set, group nodes will not show stateful styling
     *   (different styles for ListGrid.showRollOver,
     *   ListGrid.alternateRecordStyles, etc). To enable stateful styling for
     *   groupNodes, set this property to null and specify a
     *   ListGrid.groupNodeBaseStyle
     *  @type {string}
     *  @default "groupNode"
     */
    open var groupNodeStyle: String = definedExternally
    /**
     *  ListGrid.getBaseStyle for ListGrid.groupBy rows.
     * 
     *   Note that this property has no effect if ListGrid.groupNodeStyle is
     *   non null.
     *  @type {string}
     *  @default null
     */
    open var groupNodeBaseStyle: String = definedExternally
    /**
     *  The URL of the base icon for the group icons in this listGrid. Default value may
     *   be overridden by the skinning.
     *  @type {SCImgURL}
     *  @default "[SKINIMG]/TreeGrid/opener.gif"
     */
    open var groupIcon: String = definedExternally
    /**
     *  Default width and height of group icons for this ListGrid.
     *  @type {number}
     *  @default "16"
     */
    open var groupIconSize: Number = definedExternally
    /**
     *  Default number of pixels by which to indent subgroups relative to parent group.
     *  @type {number}
     *  @default "20"
     */
    open var groupIndentSize: Number = definedExternally
    /**
     *  Default number of pixels by which to indent all groups.
     *  @type {number}
     *  @default "10"
     */
    open var groupLeadingIndent: Number = definedExternally
    /**
     *  If false, grouping via context menu will be disabled.
     *  @type {boolean}
     *  @default true
     */
    open var canGroupBy: Boolean = definedExternally
    /**
     *  Maximum number of records to which a groupBy can be applied. If there are more records,
     *   grouping will not be available via the default header context menu, and calls to
     *   ListGrid.groupBy will be ignored.
     * 
     *   The maximum exists because ListGrid grouping is performed in-browser, hence requires loading of
     *   all records that match the current filter criteria before records can be grouped. The default
     *   maximum represents a number of records which are safe to load in legacy browsers such as Internet
     *   Explorer 8 (modern browsers can handle far more), and is also a good upper limit from the
     *   perspective of loading data from a database.
     * 
     *   Going beyond this limit can cause "script running slowly" errors from legacy browsers (as well as
     *   high database load). To build an interface for grouping that handles arbitrary data volume, use
     *   a TreeGrid with TreeGrid.loadDataOnDemand with server-side grouping code.
     *  @type {Integer}
     *  @default "1000"
     */
    open var groupByMaxRecords: Number = definedExternally
    /**
     *  When grouping is requested with this number of records or more, an asynchronous approach is
     *   used to avoid the browser showing a "script is running slowly.." message prompting the
     *   user to stop execution of JavaScript.
     * 
     *   Note that ListGrid.groupByMaxRecords must be set at least as high as ListGrid.groupByAsyncThreshold
     *   or asynchronous grouping will never be used.
     * 
     *   During async grouping, interactivity is blocked and the ListGrid.asynchGroupingPrompt is shown
     *   to the user, then hidden when grouping completes; ListGrid.groupByComplete then fires.
     * 
     *   Note that this async processing covers grouping only - it does not cover whole grid or
     *   per-group summaries, client-side sort or filter, or other operations that may cause the browser
     *   to show the "script is running slowly" prompt when working with very large sets of records in a
     *   grid.
     * 
     *   At this time, there is no generally effective way to avoid this warning dialog appearing with very
     *   large datasets in Microsoft's Internet Explorer (IE). IE's severely flawed detection algorithm for
     *   runaway scripts has been shown to interrupt computations after only 0.2 seconds elapsed time
     *   even if the computation would have finished in 0.3 seconds. Optimizations that reduce
     *   execution time can sometimes trigger the "script running slowly" dialog sooner. Since not
     *   every operation can reasonably be made asynchronous, the current recommendation is to avoid
     *   working with overly large datasets until the affected versions of IE are obsoleted.
     *  @type {Integer}
     *  @default "50"
     */
    open var groupByAsyncThreshold: Number = definedExternally
    /**
     *  If set to false, do not show the ListGrid.asynchGroupingPrompt dialog during
     *   ListGrid.groupByAsyncThreshold.
     *  @type {boolean}
     *  @default null
     */
    open var showAsynchGroupingPrompt: Boolean = definedExternally
    /**
     *  The prompt to display while interactivity is blocked during ListGrid.groupByAsyncThreshold.
     *  @type {HTMLString}
     *  @default "${loadingImage}&amp;nbsp;Grouping data..."
     */
    open var asynchGroupingPrompt: String = definedExternally
    /**
     *  True if this listGrid is grouped, false otherwise
     *  @type {boolean}
     *  @default false
     */
    open var isGrouped: Boolean = definedExternally
    /**
     *  Default alias to use for groups with no value
     *  @type {string}
     *  @default '-none-'
     */
    open var nullGroupTitle: String = definedExternally
    /**
     *  List of fields to group grid records. If only a single field is used, that field
     *   may be specified as a string. After initialization, use ListGrid.groupBy
     *   to update the grouping field list, instead of modifying groupByField directly.
     *  @type {string | Array<Partial<string>>}
     *  @default "see below"
     */
    open var groupByField: dynamic = definedExternally
    /**
     *  Default width and height of value icons for this ListGrid.
     *   Can be overridden at the listGrid level via explicit ListGrid.valueIconWidth and
     *   ListGrid.valueIconHeight, or at the field level via ListGridField.valueIconSize,
     *   ListGridField.valueIconWidth and {ListGridField.valueIconHeight}
     *  @type {number}
     *  @default "16"
     */
    open var valueIconSize: Number = definedExternally
    /**
     *  Width for value icons for this listGrid.
     *   Overrides ListGrid.valueIconSize.
     *   Can be overridden at the field level
     *  @type {number}
     *  @default null
     */
    open var valueIconWidth: Number = definedExternally
    /**
     *  Height for value icons for this listGrid.
     *   Overrides ListGrid.valueIconSize.
     *   Can be overridden at the field level
     *  @type {number}
     *  @default null
     */
    open var valueIconHeight: Number = definedExternally
    /**
     *  How much padding should there be on the left of valueIcons by default
     *   Can be overridden at the field level
     *  @type {number}
     *  @default "2"
     */
    open var valueIconLeftPadding: Number = definedExternally
    /**
     *  How much padding should there be on the right of valueIcons by default
     *  @type {number}
     *  @default "2"
     */
    open var valueIconRightPadding: Number = definedExternally
    /**
     *  Specifies a list of icons that can be used in DataBoundComponent.editHilites.
     * 
     *   hiliteIcons should be specified as an Array of SCImgURL.
     *   When present, the hilite editing interface shown when DataBoundComponent.editHilites is called
     *   will offer the user a drop down for picking one of these icons when defining either a
     *   simple or advanced hilite rule.
     * 
     *   If the user picks an icon, the created hiliting rule will have Hilite.icon set to
     *   the chosen icon. DataBoundComponent.hiliteIconPosition controls where the icon will
     *   appear for that field -- the default is that it appears in front of the normal cell content.
     *   This can also be overridden at the field level.
     *  @type {Array<Partial<string>>}
     *  @default "["[SKINIMG]/Dialog/notify.png", "[SKINIMG]/Dialog/warn.png", "[SKINIMG]/actions/approve.png"]"
     */
    override var hiliteIcons: Array<dynamic> = definedExternally
    /**
     *  When ListGrid.hiliteIcons are present, where the hilite icon will be placed
     *   relative to the field value. See HiliteIconPosition. Can be overridden at the
     *   field level.
     *  @type {HiliteIconPosition}
     *  @default "before"
     */
    override var hiliteIconPosition: 
                                     /**
                                      *  icon will be placed before the normal cell contents
                                      *  icon will be placed after the normal cell contents
                                      *  icon will be shown instead of the normal cell contents
                                      */
                                     String /* before |  after |  replace */ = definedExternally
    /**
     *  Default width and height of ListGrid.hiliteIcons for this component.
     *   Can be overridden at the component level via explicit
     *   ListGrid.hiliteIconWidth and
     *   ListGrid.hiliteIconHeight, or at the field level via
     *   ListGridField.hiliteIconSize,
     *   ListGridField.hiliteIconWidth and
     *   ListGridField.hiliteIconHeight
     *  @type {number}
     *  @default "12"
     */
    override var hiliteIconSize: Number = definedExternally
    /**
     *  Width for hilite icons for this component.
     *   Overrides ListGrid.hiliteIconSize.
     *   Can be overridden at the field level.
     *  @type {number}
     *  @default null
     */
    override var hiliteIconWidth: Number = definedExternally
    /**
     *  Height for hilite icons for this listGrid.
     *   Overrides ListGrid.hiliteIconSize.
     *   Can be overridden at the field level
     *  @type {number}
     *  @default null
     */
    override var hiliteIconHeight: Number = definedExternally
    /**
     *  How much padding should there be on the left of ListGrid.hiliteIcons by default?
     *   Can be overridden at the field level
     *  @type {number}
     *  @default "2"
     */
    override var hiliteIconLeftPadding: Number = definedExternally
    /**
     *  How much padding should there be on the right of ListGrid.hiliteIcons by default?
     *   Can be overridden at the field level
     *  @type {number}
     *  @default "2"
     */
    override var hiliteIconRightPadding: Number = definedExternally
    /**
     *  Default size of thumbnails shown for fieldTypes image and imageFile. Overrideable on a
     *   per-field basis via ListGridField.imageSize or
     *   ListGridField.imageWidth/ListGridField.imageHeight
     *  @type {number}
     *  @default "16"
     */
    open var imageSize: Number = definedExternally
    /**
     *  Header spans are a second level of headers that appear above the normal ListGrid headers,
     *   spanning one or more listGrid fields in a manner similar to a column-spanning cell in an
     *   HTML table.
     * 
     *   A header span can be created by simply naming the fields the header should span. The
     *   example below creates a headerSpan that spans the first two fields of the ListGrid.
     * 
     * 
     *    isc.ListGrid.create({
     *      headerHeight:40,
     *      fields : [
     *        { name:"field1" },
     *        { name:"field2" },
     *        { name:"field3" }
     *      ],
     *      headerSpans : [
     *        {
     *          fields: ["field1", "field2"],
     *          title: "Field 1 and 2"
     *        }
     *      ]
     *    });
     * 
     * 
     * 
     *   Header spans can be nested, allowing fields to be grouped by multiple levels of
     *   granularity. See HeaderSpan.spans for further information on nesting spans.
     * 
     *   Header spans will automatically react to resizing of the headers they span, and will be
     *   hidden automatically when all of the spanned fields are hidden.
     * 
     *   Header spans appear in the ListGrid.header area of the ListGrid, sharing space
     *   with the existing headers, so it's typical to set ListGrid.headerHeight to
     *   approximately double its normal height when using headerSpans, or if using nested header
     *   spans, the default header height multiplied by the number of levels of header spans to be
     *   shown.
     * 
     *   See HeaderSpan for many properties that allow the control of the appearance of
     *   headerSpans.
     * 
     *   Note that headerSpans are created via the AutoChild pattern, hence
     *   you can change the SmartClient component being used, or any of its properties.
     * 
     * 
     *   Neither headerSpans themselves nor the fields within them may be drag reordered, but other
     *   unspanned headers may be.
     * 
     *   A span can only span adjacent fields - if a span is defined and the spanned fields don't
     *   sit next to each other in the specified fields array, the fields array will be automatically
     *   reordered to match the order specified in the span's HeaderSpan.fields array.
     * 
     *   Note that headerSpans primarily provide a visual cue for grouping multiple headers
     *   together. If you have an OLAP, data "cube" or multi-dimensional data model, the
     *   CubeGrid component is the right choice.
     *  @type {Array<Partial<HeaderSpan>>}
     *  @default null
     */
    open var headerSpans: Array<dynamic> = definedExternally
    /**
     *  Default height for a ListGrid.headerSpans with no height specified.
     * 
     *   If headerSpanHeight is not specified (the default), headerSpans will be 1/2
     *   of ListGrid.headerHeight.
     *  @type {Integer}
     *  @default null
     */
    open var headerSpanHeight: Number = definedExternally
    /**
     *  Default alignment for ListGrid.headerSpans with no
     *   HeaderSpan.valign specified.
     *  @type {string}
     *  @default "center"
     */
    open var headerSpanVAlign: String = definedExternally
    /**
     *  When ListGrid.headerSpans are in use, this property sets the default
     *   vertical alignment for for fields which do not have a headerSpan.
     *  @type {string}
     *  @default null
     */
    open var unspannedHeaderVAlign: String = definedExternally
    /**
     *  SCClassName to use for headerSpans. Typically a Button or
     *   StretchImgButton subclass.
     * 
     *   If unset, headerSpans will be created using the ListGrid.headerButtonConstructor.
     *  @type {SCClassName}
     *  @default null
     */
    open var headerSpanConstructor: String = definedExternally
    /**
     *  ListGrid.headerSpans are created via the AutoChild pattern, hence
     *   headerSpanConstructor, headerSpanDefaults and
     *   headerSpanProperties are valid.
     *  @type {StatefulCanvas}
     *  @default null
     */
    open var headerSpan: StatefulCanvas = definedExternally
    /**
     *  When ListGrid.headerSpans are in use, whether to show a hierarchical column picker
     *   that includes both headerSpans and normal headers, with normal headers indented under
     *   headerSpans similarly to how a TreeGrid displays a Tree.
     * 
     *   If showTreeColumnPicker is false, no column picker will be shown on the
     *   headerSpan itself, and the column picker for a clicked on a normal field header will include
     *   only normal fields.
     *  @type {boolean}
     *  @default true
     */
    open var showTreeColumnPicker: Boolean = definedExternally
    /**
     *  Button.baseStyle to apply to the field header buttons for
     *   this ListGrid when showing header spans.
     *   Note that, depending on the ListGrid.headerButtonConstructor of the header
     *   buttons, you may also need to set ListGrid.headerTitleStyle.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var spannedHeaderBaseStyle: String = definedExternally
    /**
     *  If a page is rendered in Page.isRTL, should
     *   cell alignments specified ListGridField.cellAlign be reversed (so
     *   an align:"right" field will have content aligned on the left and
     *   vice versa)?
     * 
     *   This is true by default to match user expectation that text flows from
     *   start-to end and is aligned with the start of text flow (left in LTR mode,
     *   right in RTL mode) by default. May be set to false to have the specified
     *   alignments be taken literally in RTL mode.
     *  @type {boolean}
     *  @default true
     */
    open var reverseRTLAlign: Boolean = definedExternally
    /**
     *  If this property is true, any mouse click outside of the open cell editors
     *     will end editing mode, hiding the cell editors and saving any changes to those
     *     cell values.
     *  @type {boolean}
     *  @default null
     */
    open var modalEditing: Boolean = definedExternally
    /**
     *  If we're showing the filterEditor (ListGrid.showFilterEditor is true), and we're
     *   re-filtering on every keypress (ListGrid.filterOnKeypress is true), this
     *   property is the delay in milliseconds between the user changing the filter and the
     *   filter request being kicked off. If multiple changes are made to the filter
     *   within this fetch delay, only the most recent will actually cause a re-filter
     *  @type {number}
     *  @default "300"
     */
    open var fetchDelay: Number = definedExternally
    /**
     *  Since ListGrid.body is configured with overflow: auto by default, no overflow
     *   is expected for the ListGrid itself so by default it has overflow: hidden.
     *  @type {Overflow}
     *  @default "hidden"
     */
    override var overflow: 
                           /**
                            *  Content that extends beyond the widget's width or height is               displayed.
                            *                 Note: To have the content be sized only by the drawn size of
                            *                 the content set the overflow to be Canvas.VISIBLE and specify
                            *                 a small size, allowing the size to expand to the size required
                            *                 by the content.
                            *                 Leaving the width / height for the widget undefined will use the
                            *                 default value of 100, and setting the size to zero may cause the
                            *                 widget not to draw.
                            *  Content that extends beyond the widget's width or height is               clipped (hidden).
                            *  Horizontal and/or vertical scrollbars are displayed only if               necessary. Content that extends beyond the remaining visible
                            *                 area is clipped.
                            *  Horizontal and vertical scrollbars are always drawn inside the               widget. Content that extends beyond the remaining visible area
                            *                 is clipped, and can be accessed via scrolling.
                            *  Clip horizontally but extend the canvas's clip region               vertically if necessary. Note: only supported for
                            *                 specific widget subclasses.
                            *  Clip vertically but extend the canvas's clip region               horizontally if necessary. Note: only supported
                            *                 for specific widget subclasses.
                            */
                           String /* visible |  hidden |  auto |  scroll |  clip-h |  clip-v */ = definedExternally
    /**
     *  Minimum height for the entire list (smaller than this doesn't tend to work very well).
     *   If not set, this value will be defaulted when Canvas.draw is called to something
     *   reasonable based on whether we're showing the ListGrid.showFilterEditor,
     *   ListGrid.showHeader, ListGrid.showGridSummary, and/or the
     *   ListGrid.showEmptyMessage.
     * 
     *   Note that any top or bottom CSS padding specified by ListGrid.emptyMessageStyle will be
     *   taken into account, increasing minHeight so that the empty message can be
     *   shown without overflow.
     *  @type {number}
     *  @default "varies"
     */
    override var minHeight: Number = definedExternally
    /**
     *  Whether all rows should be drawn all at once, or only rows visible in the viewport.
     * 
     *   Drawing all rows causes longer initial rendering time, but allows smoother vertical scrolling.
     *   With a very large number of rows, showAllRows will become too slow.
     * 
     *   See also ListGrid.drawAheadRatio and ListGrid.drawAllMaxCells.
     *  @type {boolean}
     *  @default false
     */
    open var showAllRecords: Boolean = definedExternally
    /**
     *  Whether all columns should be drawn all at once, or only columns visible in the viewport.
     * 
     *   Drawing all columns causes longer initial rendering time, but allows smoother horizontal
     *   scrolling. With a very large number of columns, showAllColumns will become too slow.
     *  @type {boolean}
     *  @default false
     */
    open var showAllColumns: Boolean = definedExternally
    /**
     *  If drawing all rows would cause less than drawAllMaxCells cells to be rendered,
     *   the full dataset will instead be drawn even if ListGrid.showAllRecords
     *   is false and the viewport size and ListGrid.drawAheadRatio setting would normally have caused
     *   incremental rendering to be used.
     * 
     *   The drawAllMaxCells setting prevents incremental rendering from being used in
     *   situations where it's really unnecessary, such as a 40 row, 5 column dataset (only 200
     *   cells) which happens to be in a grid with a viewport showing only 20 or so rows.
     *   Incremental rendering causes a brief "flash" during scrolling as the visible portion of the
     *   dataset is redrawn, and a better scrolling experience can be obtained in this situation by
     *   drawing the entire dataset up front, which in this example would have negligible effect on
     *   initial draw time.
     * 
     *   drawAllMaxCells:0 disables this features. You may want to disable this feature
     *   if performance is an issue and:
     * 
     * 
     *  - you are very frequently redraw a grid
     * 
     *  - you do a lot of computation when rendering each cell (eg formulas)
     * 
     *  - you are showing many grids on one screen and the user won't scroll most of them
     * 
     *  @type {Integer}
     *  @default "250"
     */
    open var drawAllMaxCells: Number = definedExternally
    /**
     *  How far should we render rows ahead of the currently visible area? This is expressed as a
     *   ratio from viewport size to rendered area size.
     * 
     *   Tweaking drawAheadRatio allows you to make tradeoffs between continuous scrolling speed vs
     *   initial render time and render time when scrolling by large amounts.
     * 
     *   NOTE: Only applies when showAllRows is false.
     *  @type {Float}
     *  @default "2.0"
     */
    open var drawAheadRatio: Number = definedExternally
    /**
     *  Alternative to ListGrid.drawAheadRatio, to be used when the user
     *   is rapidly changing the grids viewport (for example drag scrolling through the grid).
     *   If unspecified ListGrid.drawAheadRatio will be used in all cases
     *  @type {Float}
     *  @default "2.0"
     */
    open var quickDrawAheadRatio: Number = definedExternally
    /**
     *  If true, if the user clicks on the scroll buttons at the end of the track or clicks once on
     *   the scroll track, there will be an instant redraw of the grid content so that the user
     *   doesn't see any blank space. For drag scrolling or other types of scrolling, the
     *   ListGrid.scrollRedrawDelay applies.
     *  @type {boolean}
     *  @default true
     */
    open var instantScrollTrackRedraw: Boolean = definedExternally
    /**
     *  While drag scrolling in an incrementally rendered grid, time in milliseconds to wait
     *   before redrawing, after the last mouse movement by the user. This delay may be
     *   separately customized for mouse-wheel scrolling via ListGrid.scrollWheelRedrawDelay.
     * 
     *   See also
     *   GridRenderer.instantScrollTrackRedraw for cases where this delay is skipped.
     * 
     *   NOTE: In Browser.isTouch,
     *   GridRenderer.touchScrollRedrawDelay is used instead.
     *  @type {Integer}
     *  @default "0"
     */
    open var scrollRedrawDelay: Number = definedExternally
    /**
     *  Like ListGrid.scrollRedrawDelay, but applies when the component is being
     *   drag-scrolled (via a scrollbar). This value is typically set higher than ListGrid.scrollRedrawDelay
     *   to avoid too many concurrent fetches to the server for ResultSet-backed components
     *   since it's quite easy to induce such a case with a scrollbar and a grid bound to a large databaset.
     *  @type {Integer}
     *  @default "75"
     */
    open var dragScrollRedrawDelay: Number = definedExternally
    /**
     *  While scrolling an incrementally rendered grid, using the mouseWheel, time in
     *   milliseconds to wait before redrawing, after the last mouseWheel movement by the user.
     *   If not specified ListGrid.scrollRedrawDelay will be used as a default for both
     *   drag scrolling and mouseWheel scrolling.
     * 
     *   Note that if specified, this value will typically be larger than
     *   ListGrid.scrollRedrawDelay. From experimentation, the default setting of
     *   250 is typically enough time for a user to rapidly scroll through a
     *   grid (rotating the scroll wheel with repeated flicks), without redrawing between
     *   rotations, but this will differ depending on how long the redraw takes. A larger
     *   delay may be warranted for grids with large numbers of columns, heavy custom
     *   formatting, etc.
     * 
     *   See also
     *   GridRenderer.instantScrollTrackRedraw for cases where this delay is skipped.
     *  @type {Integer}
     *  @default "0"
     */
    open var scrollWheelRedrawDelay: Number = definedExternally
    /**
     *  While scrolling an incrementally rendered grid, using the inertial scrolling, time in
     *   milliseconds to wait before redrawing, after the last touchScroll by the user.
     *   If not specified ListGrid.scrollRedrawDelay will be used as a default for both
     *   drag scrolling and touch scrolling.
     * 
     *   Note that if specified, this value will typically be larger than
     *   ListGrid.scrollRedrawDelay.
     * 
     *   See also
     *   GridRenderer.instantScrollTrackRedraw for cases where this delay is skipped.
     *  @type {Integer}
     *  @default "0"
     */
    open var touchScrollRedrawDelay: Number = definedExternally
    /**
     *  When incremental rendering is switched on and there are variable record heights, the virtual
     *   scrolling mechanism manages the differences in scroll height calculations due to the
     *   unknown sizes of un-rendered rows to make the scrollbar and viewport appear correctly.
     * 
     *   When the virtualScrolling system is active, the last scroll position
     *   scrolls the last record to the top of the viewport, leaving blank space underneath.
     *   This is a necessary and unavoidable consequence of mapping the position of the scrollbar
     *   thumb to an unknown amount of remaining space without being able to know the total
     *   scrollable area in advance (since record heights vary).
     * 
     *   virtualScrolling is switched on automatically when ListGrid.fixedRecordHeights is false and
     *   also when
     *   using the ListGrid.showRecordComponents, as
     *   recordComponents expand the rows that contain them. This flag should be manually enabled
     *   when calling ListGrid.addEmbeddedComponent if embedded components can
     *   cause record sizes to expand beyond specified cellHeight.
     * 
     *   virtualScrolling is also automatically enabled when ListGrid.canExpandRecords is true
     *   to handle the fact that expanded rows may render at variable heights.
     *  @type {boolean}
     *  @default null
     */
    open var virtualScrolling: Boolean = definedExternally
    /**
     *  When using ListGrid.dataFetchMode, how many records to fetch at a time. If set to
     *   a positive integer, dataPageSize will override the default
     *   ResultSet.resultSize for ResultSets automatically created when you call
     *   ListGrid.fetchData (and similarly for the ResultTree.resultSize of
     *   ResultTrees). Leaving dataPageSize at its default means to just use the default page
     *   size of the data container.
     * 
     *   Note that regardless of the dataPageSize setting, a component will always fetch
     *   all of data that it needs to draw. Settings such as
     *   ListGrid.showAllRecords,
     *   ListGrid.drawAllMaxCells and
     *   ListGrid.drawAheadRatio can cause more rows than the configured
     *   dataPageSize to be fetched.
     *  @type {Integer}
     *  @default null
     */
    override var dataPageSize: Number = definedExternally
    /**
     *  How to fetch and manage records retrieve from the server. See FetchMode.
     * 
     *   This setting only applies to the ResultSet automatically created by calling
     *   ListGrid.fetchData. If a pre-existing ResultSet is passed to setData() instead, it's
     *   existing setting for ResultSet.fetchMode applies.
     *  @type {FetchMode}
     *  @default "paged"
     */
    override var dataFetchMode: 
                                /**
                                 *  All records that match the current filter are fetched. Sorting is        performed on the client.
                                 *  Only requested ranges of records are fetched, with predictive fetch        ahead. Sorting is performed on the server.
                                 *  All records available from the DataSource are fetched. Filtering by        search criteria and sorting are both performed on the client.
                                 */
                                String /* basic |  paged |  local */ = definedExternally
    /**
     *  Delay in milliseconds before fetching data.
     * 
     *   Note: the floor value for this attribute is 1. If you set this value to zero, it will
     *   be defaulted to 1 for you instead.
     *  @type {Integer}
     *  @default "1"
     */
    override var dataFetchDelay: Number = definedExternally
    /**
     *  GridRenderer used to render the dataset.
     * 
     *   Note that this is a multi-instance component when there are frozen fields because in
     *   addition to the primary body AutoChild, a "frozen body" AutoChild is created to render
     *   the frozen portion of the dataset.
     *  @type {GridRenderer}
     *  @default null
     */
    open var body: GridRenderer = definedExternally
    /**
     *  Overflow setting for the "body", that is, the area of the grid where data values are
     *   rendered.
     * 
     *   This is a very advanced setting which is typically only changed by subclasses
     *   of ListGrid which never show a header. To achieve auto-fitting, instead use properties
     *   such as ListGrid.autoFitData, ListGrid.autoFitFieldWidths and
     *   ListGrid.fixedRecordHeights.
     *  @type {Overflow}
     *  @default "auto"
     */
    open var bodyOverflow: 
                           /**
                            *  Content that extends beyond the widget's width or height is               displayed.
                            *                 Note: To have the content be sized only by the drawn size of
                            *                 the content set the overflow to be Canvas.VISIBLE and specify
                            *                 a small size, allowing the size to expand to the size required
                            *                 by the content.
                            *                 Leaving the width / height for the widget undefined will use the
                            *                 default value of 100, and setting the size to zero may cause the
                            *                 widget not to draw.
                            *  Content that extends beyond the widget's width or height is               clipped (hidden).
                            *  Horizontal and/or vertical scrollbars are displayed only if               necessary. Content that extends beyond the remaining visible
                            *                 area is clipped.
                            *  Horizontal and vertical scrollbars are always drawn inside the               widget. Content that extends beyond the remaining visible area
                            *                 is clipped, and can be accessed via scrolling.
                            *  Clip horizontally but extend the canvas's clip region               vertically if necessary. Note: only supported for
                            *                 specific widget subclasses.
                            *  Clip vertically but extend the canvas's clip region               horizontally if necessary. Note: only supported
                            *                 for specific widget subclasses.
                            */
                           String /* visible |  hidden |  auto |  scroll |  clip-h |  clip-v */ = definedExternally
    /**
     *  Background color applied to the ListGrid body (that is, the area of the grid where
     *   data values are rendered).
     *   Note that this will typically not be visible to the user unless there are few enough
     *   rows that there is visible space in the body below the last row. To style data cells,
     *   override ListGrid.baseStyle instead.
     *  @type {string}
     *  @default "white"
     */
    open var bodyBackgroundColor: String = definedExternally
    /**
     *  CSS style used for the body of this grid. If applying a background-color to the body
     *   via a CSS style applied using this property, be sure to set
     *   ListGrid.bodyBackgroundColor to null.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var bodyStyleName: String = definedExternally
    /**
     *  The value to display for cells whose value is null or the empty string after applying
     *   ListGrid.formatCellValue and valueMap (if any).
     * 
     *   This is the grid-wide attribute. You may also set the emptyCellValue on a per-field basis.
     *  @type {HTMLString}
     *  @default "&amp;nbsp;"
     */
    open var emptyCellValue: String = definedExternally
    /**
     *  The minimum height of each row in pixels.
     *  @type {number}
     *  @default "20"
     */
    open var minimumCellHeight: Number = definedExternally
    /**
     *  The default height of each row in pixels.
     *  @type {number}
     *  @default "20"
     */
    open var cellHeight: Number = definedExternally
    /**
     *  If ListGrid.baseStyle is unset, base style will be derived from
     *   ListGrid.normalBaseStyle if this grid has fixed row heights and
     *   the specified ListGrid.cellHeight matches this value. Otherwise
     *   ListGrid.tallBaseStyle will be used.
     *  @type {number}
     *  @default "20"
     */
    open var normalCellHeight: Number = definedExternally
    /**
     *  Should we vertically clip cell contents, or allow rows to expand vertically to show all
     *   contents?
     * 
     *   If we allow rows to expand, the row height as derived from
     *   GridRenderer.getRowHeight or the
     *   default ListGrid.cellHeight is treated as a minimum.
     * 
     *   Setting fixedRecordHeights to false enables the ListGrid.virtualScrolling
     *   system.
     * 
     *   NOTE:
     * 
     *  - Setting fixedRecordHeights to false for CubeGrid is not supported, though a
     *   similar option for the row headers is available as CubeGrid.autoSizeHeaders.
     * 
     *  - By default, for performance reasons, clipping is not enforced for
     *   some kinds of content (such as images) on all browsers. Set
     *   ListGrid.enforceVClipping to enforce clipping for
     *   all types of content on all browsers.
     * 
     *  @type {boolean}
     *  @default true
     */
    open var fixedRecordHeights: Boolean = definedExternally
    /**
     *  For performance reasons, even when ListGrid.fixedRecordHeights is set, vertical clipping
     *   is not enforced by default for some kinds of content (such as images) on all browsers.
     *   Set ListGrid.enforceVClipping to enforce clipping for all types of
     *   content on all browsers.
     * 
     *   This additional setting is likely to be phased out as browsers improve.
     *  @type {boolean}
     *  @default false
     */
    open var enforceVClipping: Boolean = definedExternally
    /**
     *  Should we horizontally clip cell contents, or allow columns to expand horizontally to
     *   show all contents?
     * 
     *   If we allow columns to expand, the column width is treated as a minimum.
     * 
     *   NOTE: the header does not automatically respond to expanded field widths.
     *   If your grid is showing a header we'd recommend developers consider
     *   setting ListGrid.autoFitFieldWidths rather than using this attribute.
     *  @type {boolean}
     *  @default true
     */
    open var fixedFieldWidths: Boolean = definedExternally
    /**
     *  Should this ListGrid automatically expand to accommodate the size of records and fields?
     * 
     *   Valid settings are
     * 
     *  - "vertical": expand vertically to accommodate records.
     * 
     *  - "horizontal": expand horizontally to accommodate fields.
     * 
     *  - "both": expand horizontally and vertically to accommodate content.
     * 
     *   How far the ListGrid will expand may be limited via the following properties:
     *   ListGrid.autoFitMaxHeight, ListGrid.autoFitMaxRecords,
     *   ListGrid.autoFitMaxWidth, ListGrid.autoFitMaxColumns.
     * 
     *   Note that this property causes the grid as a whole to expand to fit records or fields.
     *   To have the fields or records themselves expand to fit cell contents, see
     *   ListGrid.autoFitFieldWidths and ListGrid.fixedRecordHeights.
     *  @type {Autofit}
     *  @default null
     */
    open var autoFitData: 
                          /**
                           *  expand vertically to accommodate records.
                           *  expand horizontally to accommodate fields.
                           *  expand horizontally and vertically to accommodate content.
                           */
                          String /* vertical |  horizontal |  both */ = definedExternally
    /**
     *  If ListGrid.autoFitData is set to "vertical" or "both" this
     *   property provides an upper limit on how far the ListGrid will expand vertically to accommodate
     *   its content. If content exceeds this height, scrollbars will be introduced as usual.
     *   In addition to this property, ListGrid.autoFitMaxRecords allows you to limit vertical
     *   expansion based on the number of rows to be rendered.
     *  @type {Integer}
     *  @default null
     */
    open var autoFitMaxHeight: Number = definedExternally
    /**
     *  If ListGrid.autoFitData is set to "vertical" or "both" this
     *   property provides the maximum number of records for which the ListGrid will expand. If more
     *   records are present, scrolling will be introduced to reach them as normal.
     *   If unset, by default the ListGrid will expand to accommodate as many records as are present.
     *  @type {Integer}
     *  @default "50"
     */
    open var autoFitMaxRecords: Number = definedExternally
    /**
     *  If ListGrid.autoFitData is set to "vertical" or "both",
     *   setting this property will cause the ListGrid body to size large enough to accomodate
     *   the actual data and also leave this many extra rows' worth of blank space below the last
     *   record. If a maximum size is specified via ListGrid.autoFitMaxHeight or
     *   ListGrid.autoFitMaxRecords, it will still be respected. Once the data set
     *   is large enough to fill or exceed that space, this property no longer has an effect.
     *  @type {Integer}
     *  @default null
     */
    open var autoFitExtraRecords: Number = definedExternally
    /**
     *  If ListGrid.autoFitData is set to "horizontal" or "both"
     *   this property provides an upper limit on how far the ListGrid will expand horizontally to
     *   accommodate its content. Value may be specified as a numeric pixel value or
     *   a percentage value.
     * 
     *   If content exceeds this width, scrollbars will be introduced as usual.
     *   In addition to this property, ListGrid.autoFitMaxColumns allows you to limit
     *   horizontal expansion based on the number of columns to be rendered.
     *  @type {Integer | string}
     *  @default null
     */
    open var autoFitMaxWidth: dynamic = definedExternally
    /**
     *  If ListGrid.autoFitData is set to "horizontal" or "both"
     *   this property provides the maximum number of columns for which the ListGrid will expand.
     *   If more columns are present, scrolling will be introduced to reach them as normal.
     *   If unset the ListGrid will expand to accommodate as many columns as are defined for the
     *   grid.
     *  @type {Integer}
     *  @default "50"
     */
    open var autoFitMaxColumns: Number = definedExternally
    /**
     *  Can the user perform one-time autofit for specific columns in this grid?
     * 
     *   If set to true, the default header menu will include options to auto fit
     *   ListGrid.autoFitAllText such that they fit their
     *   content or titles as specified via ListGridField.autoFitWidthApproach.
     *   Autofitting of individual fields via a
     *   ListGrid.autoFitFieldText, or the
     *   ListGrid.headerAutoFitEvent will also be enabled when this
     *   property is set unless ListGridField.canAutoFitWidth is explicitly set to false
     * 
     *   Note that the ability to perform one-time autofitting of fields via this
     *   subsystem is separate from the programmatic autofit behavior enabled
     *   via ListGrid.autoFitFieldWidths.
     * 
     *   This subsystem is requires canResizeFields be enabled and will be disabled if
     *   that property is set to false
     *  @type {boolean}
     *  @default true
     */
    open var canAutoFitFields: Boolean = definedExternally
    /**
     *  Event on a ListGrid header that triggers auto fitting to data and/or title.
     * 
     *   Note that if sorting is enabled for the field and the headerAutoFitEvent is "click", both
     *   sorting and autofit occur on a click.
     * 
     *   Only has an impact when ListGrid.canAutoFitFields or
     *   ListGridField.canAutoFitWidth is set to true.
     *  @type {AutoFitEvent}
     *  @default "doubleClick"
     */
    open var headerAutoFitEvent: 
                                 /**
                                  *  React to a double click on the listGrid header.
                                  *  React to a click on the listGrid header.
                                  *  No event will trigger auto-fit.
                                  */
                                 String /* doubleClick |  click |  none */ = definedExternally
    /**
     *  Should ListGrid fields autofit their widths to titles or content?
     *   This property may be overridden on a per-field basis via ListGridField.autoFitWidth.
     *   Developers may wish to consider disabling autoFit for fields known to have
     *   exceptionally long content as this can lead to large horizontal scrollbars and unwieldy UI.
     * 
     *   The ListGrid.autoFitWidthApproach controls whether fitting is to values, titles
     *   or both. This property may also be overridden on a per field basis.
     * 
     *   If ListGridField.width is also set on the field, it will be taken as a minimum width.
     *   ListGrid.minFieldWidth will also be respected.
     * 
     *   By default, the entire available width of the grid will still be used, by allocating any "extra"
     *   space to specific columns - see ListGrid.autoFitFieldsFillViewport for details on
     *   controlling this behavior.
     * 
     *   When this feature is enabled, autofitting is active on an ongoing basis.
     *   Autofitting will be performed:
     * 
     * 
     *  - whenever the dataset is completely changed or rows are added or removed
     * 
     *  - whenever a field which is autofitting is changed
     * 
     *  - on a manual call to ListGrid.autoFitField or
     *      ListGrid.autoFitFields
     * 
     *   Auto-fitting behavior continues until the user resizes the field manually, at which
     *   point it stops. The user can also perform a one-time auto-fit of fields via
     *   the header context menu if ListGrid.canAutoFitFields is enabled.
     * 
     *   When autofitting to column values, ListGrid.getDefaultFieldWidth will be
     *   called to determine the space required for a field's values. This method
     *   uses values from the rendered set of rows to calculate the required column width, which means the
     *   field width may still be smaller than values from non-rendered rows. See
     *   ListGrid.showAllRecords and ListGrid.drawAheadRatio) to control incremental
     *   rendering of rows.
     * 
     *   Note that for icon type fields, the ListGrid.autoFitIconFields
     *   property setting may turn on auto-fit-width behavior for specific fields by default,
     *   even if autoFitFieldWidths is false for the grid as a whole.
     * 
     *   Using this feature has a performance penalty roughly comparable to always rendering
     *   one additional field per field where autofitting is enabled. Specifically, enabling it
     *   for all fields would be comparable to both doubling the number of fields
     *   and disabling ListGrid.showAllColumns.
     *   In a grid where only half the fields are normally visible and hence only half are
     *   normally rendered, this would be roughly 4 times slower overall.
     * 
     *   This performance penalty is a result of ListGrid.getDefaultFieldWidth having to
     *   render out the data set offscreen and measure the rendered content - it does not apply
     *   for cases where this method can return a simple fixed values (as with icon fields).
     * 
     *   Which fields are currently autofitting is saved as part of the
     *   ListGrid.getViewState of the ListGrid.
     *  @type {boolean}
     *  @default null
     */
    open var autoFitFieldWidths: Boolean = definedExternally
    /**
     *  If this listGrid has specified ListGrid.headerSpans, setting this
     *   attribute to true will cause spans to expand to accommodate long titles if necessary.
     *  @type {boolean}
     *  @default false
     */
    open var autoSizeHeaderSpans: Boolean = definedExternally
    /**
     *  If ListGrid.autoFitFieldWidths is enabled and the calculated field sizes
     *   are wide enough that horizontal scrolling would be introduced, this attribute may be
     *   set to an array of fieldNames, causing those fields to be clipped rather than
     *   forcing horizontal scrollbars to appear.
     * 
     *   Note: If any ListGridField.frozen are included in this list they
     *   will not be clipped.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var autoFitClipFields: Array<dynamic> = definedExternally
    /**
     *  If ListGrid.autoFitFieldWidths is enabled, and extra space is available after
     *   autofitting all fields, should the grid automatically expand one field to fill the extra
     *   space.
     * 
     *   When enabled, the field to expand may be specified via ListGrid.autoFitExpandField.
     * 
     *   Note this logic will not expand a ListGridField.frozen.
     *  @type {boolean}
     *  @default true
     */
    open var autoFitFieldsFillViewport: Boolean = definedExternally
    /**
     *  The field to expand if ListGrid.autoFitFieldWidths and
     *   ListGrid.autoFitFieldsFillViewport are enabled and
     *   auto-fitting will not fill all available horizontal space.
     * 
     *   If unset, will default to the text field with the longest
     *   DataSourceField.length if length is set, otherwise, the first text
     *   field with no width specified.
     * 
     *   Note that expanding ListGridField.frozen is not supported.
     *  @type {string}
     *  @default null
     */
    open var autoFitExpandField: String = definedExternally
    /**
     *  When a user requests column autofitting via the
     *   ListGrid.getHeaderContextMenuItems or via a
     *   ListGrid.headerAutoFitEvent, what autofit approach is used.
     *  @type {AutoFitWidthApproach}
     *  @default "value"
     */
    open var autoFitWidthApproach: 
                                   /**
                                    *  Size field to fit to the data value(s) contained in the field.
                                    *  Size field to fit the field title
                                    *  Size field to fit either the field title or the data values in the field (whichever requires more space).
                                    */
                                   String /* value |  title |  both */ = definedExternally
    /**
     *  SmartClient listGrids have special logic to automatically size fields that
     *   are displayed as an icon - that is fields with
     *   ListGridFieldType, fields displaying only
     *   ListGridField.showValueIconOnly, and boolean fields (which
     *   are rendered as a checkmark type icon by default.
     * 
     *   This attribute controls this behavior - governing whether icon fields should
     *   be sized to fit their content (icon), title, or whether to disable this
     *   behavior. Setting this value to "title" or "iconWidth"
     *   will cause ListGridField.autoFitWidth to be enabled by default for all
     *   icon fields with the ListGridField.autoFitWidthApproach set to
     *   "value" or "both" as appropriate. Note that the
     *   width required for the icons is calculated by ListGrid.getDefaultFieldWidth
     *   which performs a simple calculation based on the specified icon width for these
     *   types of fields.
     * 
     *   This setting governs default behavior for icon fields - for specific fields within
     *   a grid, this default behavior can be overridden by setting an explicit
     *   ListGridField.width or
     *   explicitly enabling ListGridField.autoFitWidth and setting
     *   ListGridField.autoFitWidthApproach on the field in question.
     *  @type {AutoFitIconFieldType}
     *  @default "title"
     */
    open var autoFitIconFields: 
                                /**
                                 *  Apply no special sizing to icon fields - treat them like any other  field in the grid
                                 *  size the field to accommodate the width of the icon
                                 *  size the field to accommodate the title (or the width of the icon if  it exceeds the width of the title.
                                 */
                                String /* none |  iconWidth |  title */ = definedExternally
    /**
     *  Should listGrids automatically size date fields to fit their values or titles?
     *   If set to "value", fields of type date will be rendered at the
     *   size specified by ListGrid.defaultDateFieldWidth,
     *   (or ListGrid.defaultEditableDateFieldWidth for editable fields). This static
     *   value is appropriate for dates rendered with the standard short-date formatter.
     *   If set to "title" or "both", the drawn width of the title
     *   will be taken into account when sizing the column.
     * 
     *   This is achieved by enabling ListGridField.autoFitWidth
     *   on date fields when this property is set to anything other than "none",
     *   setting the ListGridField.autoFitWidthApproach to the value specified here
     *   and having logic in ListGrid.getDefaultFieldWidth pick up the
     *   ListGrid.defaultDateFieldWidth or ListGrid.defaultEditableDateFieldWidth
     *   if appropriate.
     *  @type {AutoFitWidthApproach}
     *  @default "value"
     */
    open var autoFitDateFields: 
                                /**
                                 *  Size field to fit to the data value(s) contained in the field.
                                 *  Size field to fit the field title
                                 *  Size field to fit either the field title or the data values in the field (whichever requires more space).
                                 */
                                String /* value |  title |  both */ = definedExternally
    /**
     *  Default width for date type fields. See ListGrid.autoFitDateFields for
     *   details on how this property is used.
     *  @type {Integer}
     *  @default "varies"
     */
    open var defaultDateFieldWidth: Number = definedExternally
    /**
     *  Default width for editable date type fields. See ListGrid.autoFitDateFields for
     *   details on how this property is used.
     *  @type {Integer}
     *  @default "varies"
     */
    open var defaultEditableDateFieldWidth: Number = definedExternally
    /**
     *  Default width for datetime type fields. See ListGrid.autoFitDateFields for
     *   details on how this property is used.
     *  @type {Integer}
     *  @default "varies"
     */
    open var defaultDateTimeFieldWidth: Number = definedExternally
    /**
     *  Default width for editable datetime type fields. See ListGrid.autoFitDateFields
     *   for details on how this property is used.
     *  @type {Integer}
     *  @default "varies"
     */
    open var defaultEditableDateTimeFieldWidth: Number = definedExternally
    /**
     *  Should listGrids automatically size time fields to fit their values or titles?
     *   If set to "value", fields of type time will be rendered at the
     *   size specified by ListGrid.defaultTimeFieldWidth. This static
     *   value is appropriate for dates rendered with the standard time formatter.
     *   If set to "title" or "both", the drawn width of the title
     *   will be taken into account when sizing the column.
     * 
     *   This is achieved by enabling ListGridField.autoFitWidth
     *   on date fields when this property is set to anything other than "none",
     *   setting the ListGridField.autoFitWidthApproach to the value specified here
     *   and having logic in ListGrid.getDefaultFieldWidth pick up the
     *   ListGrid.defaultTimeFieldWidth if appropriate.
     *  @type {AutoFitWidthApproach}
     *  @default "value"
     */
    open var autoFitTimeFields: 
                                /**
                                 *  Size field to fit to the data value(s) contained in the field.
                                 *  Size field to fit the field title
                                 *  Size field to fit either the field title or the data values in the field (whichever requires more space).
                                 */
                                String /* value |  title |  both */ = definedExternally
    /**
     *  Default width for time type fields. See ListGrid.autoFitDateFields for
     *   details on how this property is used.
     *  @type {Integer}
     *  @default "varies"
     */
    open var defaultTimeFieldWidth: Number = definedExternally
    /**
     *  Whether to leave a gap for the vertical scrollbar, even when it's not present.
     * 
     *   Note that if leaveScrollbarGap is false and vertical scrolling is introduced, fields
     *   will be resized to fit the smaller body area if possible, in order to avoid horizontal
     *   scrolling also being required.
     *  @type {boolean}
     *  @default true
     */
    override var leaveScrollbarGap: Boolean = definedExternally
    /**
     *  Should content within cells be allowed to wrap?
     * 
     *   Even if content is allowed to wrap, if ListGrid.fixedRecordHeights is set, the content
     *   will be clipped off at the cell boundary. Either set a larger, fixed ListGrid.cellHeight
     *   to reveal more content, or set ListGrid.fixedRecordHeights to false to allow auto-sizing.
     *  @type {boolean}
     *  @default false
     */
    open var wrapCells: Boolean = definedExternally
    /**
     *  If true and a cell's value is clipped, then a hover containing the full cell value is
     *   enabled.
     * 
     *   Note that standard cell hovers override clipped value hovers. Thus, to enable clipped value
     *   hovers, ListGrid.canHover must be unset or null and the corresponding field must have
     *   ListGridField.showHover unset or null as well.
     *  @type {boolean}
     *  @default null
     */
    open var showClippedValuesOnHover: Boolean = definedExternally
    /**
     *  The amount of empty space, in pixels, surrounding each value in its cell.
     *  @type {number}
     *  @default "2"
     */
    open var cellPadding: Number = definedExternally
    /**
     *  How should Date type values be displayed in this ListGrid by default?
     * 
     *   This property specifies the default DateDisplayFormat to apply to Date values
     *   displayed in this grid for all fields except those of ListGridField.type
     *   (See also ListGrid.timeFormatter).
     *   If ListGrid.datetimeFormatter is specified, that will be applied by default
     *   to fields of type "datetime".
     * 
     *   Note that if ListGridField.dateFormatter or ListGridField.timeFormatter are
     *   specified those properties will take precedence over the component level settings.
     * 
     *   If unset, date values will be formatted according to the system wide
     *   DateUtil.setShortDisplayFormat or
     *   DateUtil.setShortDatetimeDisplayFormat for
     *   datetime type fields.
     * 
     *   If this field is editable the dateFormatter will also be passed to the editor created
     *   to edit this field as DateItem.dateFormatter.
     *   In this case you may also need to set ListGrid.dateInputFormat.
     *  @type {DateDisplayFormat}
     *  @default null
     */
    open var dateFormatter: 
                            /**
                             *  Default native browser 'toString()' implementation. May vary by browser.
                             *   Example: Fri Nov 04 2005 11:03:00 GMT-0800 (Pacific Standard Time)
                             *  Default native browser 'toLocaleString()' implementation. May vary by browser.
                             *   Example: Friday, November 04, 2005 11:03:00 AM
                             *  Short date in format MM/DD/YYYY. Example: 11/4/2005
                             *  Short date with time in format MM/DD/YYYY HH:MM Example: 11/4/2005 11:03
                             *  Short date in format DD/MM/YYYY. Example: 4/11/2005
                             *  Short date with time in format DD/MM/YYYY HH:MM Example: 4/11/2005 11:03
                             *  Short date in format YYYY/MM/DD. Example: 2005/11/4
                             *  Short date with time in format YYYY/MM/DD HH:MM Example: 2005/11/4 11:03
                             *  Date in the format YYYY-MM-DD HH:MM:SS Example: 2005-11-04 11:09:15
                             *  Date in the format &lt;YYYYMMDD&gt;T&lt;HHMMSS&gt;Z Example: 20051104T111001Z
                             * 
                             * 
                             *   Note: In addition to these standard formats, custom formatting can be set by passing
                             *   a function directly to DateUtil.setNormalDisplayFormat et al. This
                             *   function will then be executed whenever the appropriate formatter method is called [eg
                             *   Date.toNormalDate], in the scope of the date instance in question.
                             * 
                             *   Custom formatting can also be applied by passing a FormatString instead of a
                             *   DateDisplayFormat string to DateUtil.setNormalDisplayFormat et al. See
                             *   the FormatString docs for details.
                             */
                            String /* toString |  toLocaleString |  toUSShortDate |  toUSShortDatetime |  toEuropeanShortDate |  toEuropeanShortDatetime |  toJapanShortDate |  toJapanShortDatetime |  toSerializeableDate |  toDateStamp */ = definedExternally
    /**
     *  Display format to use for fields specified as type 'datetime'. Default is to use the
     *   system-wide default date time format, configured via
     *   DateUtil.setShortDatetimeDisplayFormat. Specify any
     *   valid DateDisplayFormat to change the display format for datetimes used by this grid.
     * 
     *   May be specified as a function. If specified as a function, this function will be executed in the scope of the Date
     *   and should return the formatted string.
     * 
     * 
     *   May also be specified at the field level via
     *   ListGridField.dateFormatter
     * 
     *   If this field is editable the dateFormatter will also be passed to the editor created
     *   to edit this field as DateItem.dateFormatter.
     *   In this case you may also need to set ListGrid.dateInputFormat.
     *  @type {DateDisplayFormat}
     *  @default null
     */
    open var datetimeFormatter: 
                                /**
                                 *  Default native browser 'toString()' implementation. May vary by browser.
                                 *   Example: Fri Nov 04 2005 11:03:00 GMT-0800 (Pacific Standard Time)
                                 *  Default native browser 'toLocaleString()' implementation. May vary by browser.
                                 *   Example: Friday, November 04, 2005 11:03:00 AM
                                 *  Short date in format MM/DD/YYYY. Example: 11/4/2005
                                 *  Short date with time in format MM/DD/YYYY HH:MM Example: 11/4/2005 11:03
                                 *  Short date in format DD/MM/YYYY. Example: 4/11/2005
                                 *  Short date with time in format DD/MM/YYYY HH:MM Example: 4/11/2005 11:03
                                 *  Short date in format YYYY/MM/DD. Example: 2005/11/4
                                 *  Short date with time in format YYYY/MM/DD HH:MM Example: 2005/11/4 11:03
                                 *  Date in the format YYYY-MM-DD HH:MM:SS Example: 2005-11-04 11:09:15
                                 *  Date in the format &lt;YYYYMMDD&gt;T&lt;HHMMSS&gt;Z Example: 20051104T111001Z
                                 * 
                                 * 
                                 *   Note: In addition to these standard formats, custom formatting can be set by passing
                                 *   a function directly to DateUtil.setNormalDisplayFormat et al. This
                                 *   function will then be executed whenever the appropriate formatter method is called [eg
                                 *   Date.toNormalDate], in the scope of the date instance in question.
                                 * 
                                 *   Custom formatting can also be applied by passing a FormatString instead of a
                                 *   DateDisplayFormat string to DateUtil.setNormalDisplayFormat et al. See
                                 *   the FormatString docs for details.
                                 */
                                String /* toString |  toLocaleString |  toUSShortDate |  toUSShortDatetime |  toEuropeanShortDate |  toEuropeanShortDatetime |  toJapanShortDate |  toJapanShortDatetime |  toSerializeableDate |  toDateStamp */ = definedExternally
    /**
     *  If this is an editable listGrid, this property will specify the
     *   DateItem.inputFormat applied to editors for fields of type
     *   "date". May be overridden per field via ListGridField.inputFormat.
     *  @type {DateInputFormat}
     *  @default null
     */
    open var dateInputFormat: String = definedExternally
    /**
     *  Display format to use for fields specified as type 'time'. May also be specified at
     *   the field level via ListGridField.timeFormatter.
     *   If unset, time fields will be formatted based on the system wide
     *   Time.shortDisplayFormat.
     *   If this field is editable, the timeFormatter will also be passed to the editor
     *   created to edit any time type fields as TimeItem.timeFormatter
     *  @type {TimeDisplayFormat}
     *  @default "toShortPaddedTime"
     */
    open var timeFormatter: 
                            /**
                             *  String will display with seconds and am/pm indicator:[H]H:MM:SS am|pm.
                             *   Example: 3:25:15 pm
                             *  String will display with seconds in 24 hour time: [H]H:MM:SS.
                             *   Example: 15:25:15
                             *  String will display with seconds, with a 2 digit hour and am/pm indicator:
                             *   HH:MM:SS am|pm
                             *   Example: 03:25:15 pm
                             *  String will display with seconds, with a 2 digit hour in 24 hour format:
                             *   HH:MM:SS
                             *   Examples: 15:25:15, 03:16:45
                             *  String will have no seconds and be in 12 hour format:[H]H:MM am|pm
                             *   Example: 3:25 pm
                             *  String will have no seconds and be in 24 hour format: [H]H:MM
                             *   Example:15:25
                             *  String will have no seconds and will display a 2 digit hour, in 12 hour clock format:
                             *   HH:MM am|pm
                             *   Example: 03:25 pm
                             *  String will have no seconds and will display with a 2 digit hour in 24 hour clock format:
                             *   HH:MM
                             *   Examples: 15:25, 03:16
                             */
                            String /* toTime |  to24HourTime |  toPaddedTime |  toPadded24HourTime |  toShortTime |  toShort24HourTime |  toShortPaddedTime |  toShortPadded24HourTime */ = definedExternally
    /**
     *  Property name on a record that will hold the link text for that record.
     * 
     *   This property is configurable to avoid possible collision with data values in the
     *   record.
     * 
     *   Use ListGridField.linkTextProperty if you have more than one link field and
     *  @type {string}
     *  @default "linkText"
     */
    open var linkTextProperty: String = definedExternally
    /**
     *  Note: This property only has an effect in Internet Explorer
     * 
     *   Advanced property to improve performance for dynamic styling of gridRenderer cells in
     *   Internet Explorer, at the expense of slightly slower initial drawing, and some
     *   limitations on supported styling options.
     * 
     *   fastCellUpdates speeds up the dynamic styling system used by rollovers,
     *   selections, and custom styling that calls GridRenderer.refreshCellStyle, at
     *   the cost of slightly slower draw() and redraw() times.
     * 
     *   Notes:
     * 
     * 
     *  - When this property is set, ListGrid cells may be styled using the
     *     ListGrid.tallBaseStyle. See ListGrid.getBaseStyle for
     *     more information.
     * 
     *  - If any cell styles specify a a background image URL, the URL will be resolved relative
     *     to the page location rather than the location of the CSS stylesheet. This means cell
     *     styles with a background URL should either supply a fully qualified path, or the
     *     background image media should be made available at a second location for IE.
     * 
     *  - fastCellUpdates will not work if the styles involved are in an external stylesheet loaded
     *     from a remote host. Either the stylesheet containing cell styles needs to be loaded
     *     from the same host as the main page, or the cell styles need to be inlined in the html
     *     of the bootstrap page.
     * 
     *  - fastCellUpdates will not work if the css styles for cells are defined in
     *     a .css file loaded via @import. Instead the .css
     *     file should be loaded via a &lt;link ...&gt; tag.
     * 
     *  @type {boolean}
     *  @default true
     */
    open var fastCellUpdates: Boolean = definedExternally
    /**
     *  GridRenderer.baseStyle for this listGrid.
     *   If this property is unset, base style may be derived from ListGrid.normalBaseStyle
     *   or ListGrid.tallBaseStyle as described in
     *   ListGrid.getBaseStyle.
     * 
     *   See cellStyleSuffixes for details on how stateful suffixes are combined
     *   with the base style to generate stateful cell styles.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var baseStyle: String = definedExternally
    /**
     *  "Normal" baseStyle for this listGrid. Only applies if ListGrid.baseStyle is
     *   set to null.
     * 
     *   If baseStyle is unset, this
     *   property will be used as a base cell style if the grid is showing fixed height rows, and
     *   the specified cellHeight matches ListGrid.normalCellHeight (and in Internet Explorer,
     *   ListGrid.fastCellUpdates is false). Otherwise ListGrid.tallBaseStyle will
     *   be used.
     * 
     *   Having separate styles defined for fixed vs. variable height rows allows the developer
     *   to specify css which is designed to render at a specific height (typically using
     *   background images, which won't scale), without breaking support for styling rows
     *   of variable height.
     * 
     *   See cellStyleSuffixes for details on how stateful suffixes are combined
     *   with the base style to generate stateful cell styles.
     *  @type {CSSStyleName}
     *  @default "cell"
     */
    open var normalBaseStyle: String = definedExternally
    /**
     *  "Tall" baseStyle for this listGrid. Only applies if ListGrid.baseStyle is
     *   set to null.
     * 
     *   If baseStyle is unset, this
     *   property will be used as a base cell style unless the grid is showing fixed height
     *   rows with a specified cellHeight that matches ListGrid.normalCellHeight, in
     *   which case ListGrid.normalBaseStyle will be used. Note that in Internet Explorer
     *   if ListGrid.fastCellUpdates is true, tallBaseStyle will also be
     *   used even if the cellHeight matches the specified normalCellHeight for the
     *   grid.
     * 
     *   See cellStyleSuffixes for details on how stateful suffixes are combined
     *   with the base style to generate stateful cell styles.
     *  @type {CSSStyleName}
     *  @default "cell"
     */
    open var tallBaseStyle: String = definedExternally
    /**
     *  A base name for the CSS class applied to cells when editing has failed.
     *   If this listGrid is editable, this style will be applied to any edited cells for which
     *   validation failed.
     *   As with the default 'baseStyle' property, this style will have "Dark", "Over", "Selected",
     *   or "Disabled" appended to it according to the state of the cell.
     *   If null, cells for which editing has failed will be rendered using the normal base style
     *   classNames, but with custom CSSText applied as derived from this.editFailedCSSText
     *  @type {CSSStyleName}
     *  @default null
     */
    open var editFailedBaseStyle: String = definedExternally
    /**
     *  Custom CSS text to be applied to cells when editing has failed.
     *   If this listGrid is editable, this css text will be applied to any edited cells for which
     *   validation failed, on top of the base style for the cell.
     *   For further customization of styling for cells that failed editing validation, use
     *   this.editFailedBaseStyle instead.
     *  @type {string}
     *  @default "color:red;border:1px solid red;"
     */
    open var editFailedCSSText: String = definedExternally
    /**
     *  A base name for the CSS class applied to cells containing pending (unsaved) edits
     *   As with the default 'baseStyle' property, this style will have "Dark", "Over", "Selected",
     *   or "Disabled" appended to it according to the state of the cell.
     * 
     *   If this property is null (the default setting), cells with pending edits will pick up
     *   custom css text to be applied on top of the normal base style from
     *   this.editPendingCSSText.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var editPendingBaseStyle: String = definedExternally
    /**
     *  Custom CSS text to be applied to cells with pending edits that have not yet been
     *   submitted.
     *   For further customization of styling for cells with pending edits use
     *   this.editPendingBaseStyle instead.
     *  @type {string}
     *  @default "color:#0066CC;"
     */
    open var editPendingCSSText: String = definedExternally
    /**
     *  Denotes the name of a property that can be set on records to display a custom style.
     *   For example if this property is set to "customStyle", setting
     *   record.customStyle to a css styleName will cause the record in question to
     *   render out with that styling applied to it. Note that this will be a static
     *   style - it will not be modified as the state of the record (selected / over etc) changes.
     *  @type {string}
     *  @default "customStyle"
     */
    open var recordCustomStyleProperty: String = definedExternally
    /**
     *  This attribute allows custom base styles to be displayed on a per-record basis.
     *   To specify a custom base-style for some record set
     *   record[listGrid.recordBaseStyleProperty] to the desired base style name -
     *   for example if recordBaseStyleProperty is "_baseStyle", set
     *   record._baseStyle to the custom base style name.
     *  @type {string}
     *  @default "_baseStyle"
     */
    open var recordBaseStyleProperty: String = definedExternally
    /**
     *  If this listGrid contains any frozen fields, this property can be used to apply a custom
     *   baseStyle to all cells in those frozen fields. If unset, the standard base style will be
     *   used for both frozen and unfrozen cells.
     *  @type {string}
     *  @default null
     */
    open var frozenBaseStyle: String = definedExternally
    /**
     *  If this list grid is showing any ListGridField.frozen fields, and a horizontal
     *   scrollbar is visible at the bottom of the liquid columns, should an equivalent scrollbar gap
     *   be left visible below the frozen columns?
     *   Note that if set to true any backgroundColor or border applied to the ListGrid
     *   will show up below the bottom row of the frozen column(s).
     *  @type {boolean}
     *  @default false
     */
    open var shrinkForFreeze: Boolean = definedExternally
    /**
     *  Whether alternating rows (or blocks of rows, depending
     *   on GridRenderer.alternateRowFrequency) should be drawn in alternating styles,
     *   in order to create a "ledger" effect for easier reading.
     * 
     *   If enabled, the cell style for alternate rows will have the
     *   GridRenderer.alternateRowSuffix appended to it.
     *   See also GridRenderer.alternateColumnStyles.
     *  @type {boolean}
     *  @default false
     */
    open var alternateRecordStyles: Boolean = definedExternally
    /**
     *  Suffix to append to GridRenderer.alternateRowStyles.
     *   Note that if GridRenderer.alternateColumnStyles is enabled, cells which fall
     *   into both an alternate row and column will have both suffixes appended - for
     *   example "cellDarkAltCol".
     *  @type {string}
     *  @default "Dark"
     */
    open var alternateRecordSuffix: String = definedExternally
    /**
     *  The number of consecutive rows to draw in the same style before alternating, when
     *   GridRenderer.alternateRowStyles is true.
     *  @type {number}
     *  @default "1"
     */
    open var alternateRecordFrequency: Number = definedExternally
    /**
     *  Whether alternating columns (or blocks of columns, depending
     *   on GridRenderer.alternateColumnFrequency) should be drawn in alternating styles,
     *   in order to create a vertical "ledger" effect for easier reading.
     * 
     *   If enabled, the cell style for alternate rows will have the
     *   GridRenderer.alternateColumnSuffix appended to it.
     *   See also GridRenderer.alternateRowStyles.
     *  @type {boolean}
     *  @default false
     */
    open var alternateFieldStyles: Boolean = definedExternally
    /**
     *  Suffix to append to GridRenderer.alternateColumnStyles.
     *   Note that if GridRenderer.alternateRowStyles is enabled, cells which fall
     *   into both an alternate row and column will have both suffixes appended - for
     *   example "cellDarkAltCol".
     *  @type {string}
     *  @default "AltCol"
     */
    open var alternateFieldSuffix: String = definedExternally
    /**
     *  The number of consecutive columns to draw in the same style before alternating, when
     *   GridRenderer.alternateColumnStyles is true.
     *  @type {number}
     *  @default "1"
     */
    open var alternateFieldFrequency: Number = definedExternally
    /**
     *  Optional css style to apply to the body if ListGrid.alternateRecordStyles is true
     *   for this grid. If unset ListGrid.bodyStyleName will be used to style the body
     *   regardless of the ListGrid.alternateRecordStyles setting.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var alternateBodyStyleName: String = definedExternally
    /**
     *  When assembling a value for a ListGrid.canAddSummaryFields, if a referenced
     *   field is hilited, should the hilite HTML be included in the summary field value?
     * 
     *   To control hilites showing in group summaries, see ListGrid.showHilitesInGroupSummary.
     *  @type {boolean}
     *  @default true
     */
    override var includeHilitesInSummaryFields: Boolean = definedExternally
    /**
     *  Determines whether hiliting for any field in this grid is shown in a group summary.
     *   This setting affects all fields of the grid.
     * 
     *   To suppress hilites for a specific field see ListGridField.showHilitesInGroupSummary.
     * 
     *   Hiliting in summary fields (columns) can be enabled by setting
     *   ListGrid.includeHilitesInSummaryFields to true.
     *  @type {boolean}
     *  @default true
     */
    open var showHilitesInGroupSummary: Boolean = definedExternally
    /**
     *  If set, end users can create advanced hiliting rules that will use the
     *   Hilite.replacementValue feature to cause values in hilited cells
     *   to be replaced with a user-entered value. For example, a user could create a hilite rule
     *   that replaces numeric values ranging from 0.5 to 1.0 with the text "LOW".
     * 
     *   Specifically, when the "Add Advanced Rule" button is pressed and
     *   hiliteCanReplaceValue is true, the user will see a text entry field titled
     *   "Replace value with" (ListGrid.hiliteReplaceValueFieldTitle) and if they enter a value, that
     *   value will appear in the grid cell in lieu of the cell's original value.
     *  @type {boolean}
     *  @default null
     */
    open var hiliteCanReplaceValue: Boolean = definedExternally
    /**
     *  Title used for the text box shown when ListGrid.hiliteCanReplaceValue is set.
     *  @type {string}
     *  @default "Replace value with"
     */
    open var hiliteReplaceValueFieldTitle: String = definedExternally
    /**
     *  If set to true, custom HTML applied as part of hiliting will be applied after
     *   ListGrid.formatCellValue for each cell. If false, hilite
     *   HTML will be applied before formatting.
     * 
     *   This applies to the following hilite properties:
     * 
     * 
     *  - Hilite.replacementValue
     * 
     *  - Hilite.htmlBefore
     * 
     *  - Hilite.htmlAfter
     * 
     *  - Hilite.htmlValue
     * 
     * 
     *   May be overridden per field via ListGridField.hiliteHTMLAfterFormat
     *  @type {boolean}
     *  @default true
     */
    open var hiliteHTMLAfterFormat: Boolean = definedExternally
    /**
     *  Should the "Selected" style be applied to selected records?
     *  @type {boolean}
     *  @default true
     */
    open var showSelectedStyle: Boolean = definedExternally
    /**
     *  If true, when the user navigates to a cell using arrow keys and hits space,
     *   the cell will respond to a click event.
     *  @type {boolean}
     *  @default true
     */
    open var generateClickOnSpace: Boolean = definedExternally
    /**
     *  If true, when the user navigates to a cell using arrow keys and hits Enter,
     *   the cell will respond to a click event.
     *  @type {boolean}
     *  @default false
     */
    open var generateClickOnEnter: Boolean = definedExternally
    /**
     *  If true, when the user navigates to a cell using arrow keys and hits Space,
     *   the cell will respond to a double click event.
     *  @type {boolean}
     *  @default false
     */
    open var generateDoubleClickOnSpace: Boolean = definedExternally
    /**
     *  If true, when the user navigates to a cell using arrow keys and hits Enter,
     *   the cell will respond to a double click event.
     *  @type {boolean}
     *  @default true
     */
    open var generateDoubleClickOnEnter: Boolean = definedExternally
    /**
     *  Action to perform when the listGrid has keyboard focus (but not editing focus) and a user
     *   presses the up or down arrow key. Possible values are:
     * 
     * 
     *  - "select" : select the next row in the list (calls recordClick handler)
     * 
     *  - "focus" : move focus to the next row in the list without changing the selection
     * 
     *  - "activate" : select and activate the next row in the list (calls
     *   recordDoubleClick handler)
     * 
     *  - "none" : no action
     * 
     *  - null : if ListGrid.selectionAppearance is "checkbox", behaves as if set
     *   to "focus"; otherwise, behaves as if set to "select"
     * 
     *  @type {string}
     *  @default null
     */
    open var arrowKeyAction: String = definedExternally
    /**
     *  When the grid body gets keyboard focus, should we highlight the current focus row,
     *   using the rollover cell style?
     * 
     *   This property may be explicitly set to control this behavior independently of
     *   ListGrid.showRollOver.
     *   Otherwise (if this property is null), we will show the roll-over styling for the
     *   keyboard focus row if ListGrid.showRollOver is true.
     *  @type {boolean}
     *  @default null
     */
    open var hiliteRowOnFocus: Boolean = definedExternally
    /**
     *  When enabled, ListGrid.createRecordComponent will be called when saved rows are being
     *   rendered, and any returned component will be displayed embedded within the row or cell.
     * 
     *   recordComponents are not created for newly added rows which have not yet been saved.
     *   See the unsavedRecords for more
     *   information.
     * 
     *   Depending on the ListGrid.showRecordComponentsByCell setting,
     *   createRecordComponent() will be called either once per row, or once for
     *   every cell.
     * 
     *   Depending on ListGrid.recordComponentPosition, components can either be placed underneath
     *   normal record or cell content ("expand" setting) or placed so that they overlap normal
     *   cell content ("within" setting). For the "within" setting, the default is to fill the
     *   row or cell, but the component can specify percent size or even use
     *   Canvas.snapTo to place itself within the row or cell.
     * 
     *   The "expand" setting is incompatible with ListGrid.canFreezeFields
     *   unless all recordComponents are the same height and they are present
     *   in every row, in which case the fixed height of all recordComponents can be
     *   set via ListGrid.recordComponentHeight to re-enable frozen fields.
     * 
     *   Using recordComponents potentially means creating one component for every
     *   visible grid row or cell and so can impact performance. Before using this subsystem:
     * 
     * 
     *  - consider using ListGridField.valueIcons (possibly with a specified
     *     ListGridField.valueIconClick handler) for icons based on field values
     *     which may be displayed alone in the cell or alongside standard content
     *     (see ListGridField.showValueIconOnly);
     * 
     *  - for clickable icons representing actions that can be taken on a record, also
     *     consider using ListGridFieldType, or
     *     multiple such fields
     * 
     *  - for controls that only need to appear on rollover, consider
     *     ListGrid.showRollOverCanvas
     * 
     *  - if you are trying to customize the editor for a field, you can provide a custom
     *     control via ListGridField.editorType, and FormItem.icons are a common
     *     way to add clickable buttons. You can also
     *     ListGrid.getEditorType. These options are
     *     usually better that using recordComponents as custom editors, since
     *     you won't have to manage issues like making the recordComponent appear
     *     only when editing, having changes affect editing,
     *     triggering saves and handling validation errors, etc.
     * 
     * 
     *   See RecordComponentPoolingMode for an overview of how best to optimize use of
     *   recordComponents for different data sets.
     * 
     *   Regardless of the pooling mode, you can explicitly refresh record components via
     *   ListGrid.invalidateRecordComponents and
     *   ListGrid.refreshRecordComponent.
     * 
     *   Interaction with ListGrid.autoFitFieldWidths: per-cell record
     *   components are not taken into account when determining the size for column auto fit.
     *   The default ListGrid.getDefaultFieldWidth implementation looks at cell content
     *   only. We typically recommend that, for fields showing record-components,
     *   ListGridField.autoFitWidth and ListGridField.canAutoFitWidth be disabled, or if
     *   the record components are of a predictable size, a ListGridField.defaultWidth
     *   be specified.
     *   This is particularly pertinent where ListGrid.recordComponentPosition
     *   is set to "within", in which case cells' content is often empty or completely covered
     *   by record-components.
     *  @type {boolean}
     *  @default null
     */
    open var showRecordComponents: Boolean = definedExternally
    /**
     *  if ListGrid.showRecordComponents is true, how should the component appear within
     *   the cell. Valid options are
     * 
     *  - "within": the component will be rendered inside the record / cell.
     *   Canvas.snapTo may be set to specify where the component should render within
     *   the row or cell, and Canvas.snapOffsetTop / Canvas.snapOffsetLeft may
     *   be set to indent recordComponents within their parent cells.
     *   Note that if unset, the component will show up at the top/left edge
     *   for components embedded within an entire row, or for per-cell components, cell
     *   align and valign will be respected. Note also that, when rendering components "within"
     *   cells, specified component heights will be respected and will change the height of the
     *   row. However, if you want components to completely fill a cell at it's default height,
     *   set height: "100%" or rows will render at the default height of the component.
     * 
     *  - "expand": the component will be written into the cell below the
     *   normal cell content, causing the cell to expand vertically to accommodate it.
     * 
     *  - null: If this attribute is unset, we will default to showing
     *   recordComponents with position "within" if
     *   ListGrid.showRecordComponentsByCell is true, otherwise using "expand"
     *   logic.
     * 
     *  @type {EmbeddedPosition}
     *  @default null
     */
    open var recordComponentPosition: 
                                      /**
                                       *  component should be placed underneath normal record or cell content,    expanding the records. Expanding records can result in variable height rows,
                                       *      in which case ListGrid.virtualScrolling should be
                                       *      enabled.
                                       *  component should be placed within the normal area of the record or cell.    Percentage sizes will be treated as percentages of the record and
                                       *      Canvas.snapTo positioning settings are also allowed and refer to the
                                       *      rectangle of the record or cell. Note that for components embedded within cells,
                                       *      cell align and vAlign will be used if snapTo is unset (so top / left alignment
                                       *      of cell content will map to snapTo of "TL", etc).
                                       */
                                      String /* expand |  within */ = definedExternally
    /**
     *  If true, shows ListGrid.showRecordComponents in cells, rather
     *   than just in records.
     *  @type {boolean}
     *  @default null
     */
    open var showRecordComponentsByCell: Boolean = definedExternally
    /**
     *  The method of RecordComponentPoolingMode to employ for
     *   ListGrid.showRecordComponents.
     * 
     *   The default mode is "viewport", which means that recordComponents are destroyed as soon
     *   their record is no longer being rendered (scrolled out of the viewport, eliminated by
     *   search criteria, etc).
     * 
     *   For a large or dynamic data set where the components shown on different rows are
     *   similar, switch to "recycle" mode, which pools recordComponents by detaching them from
     *   records that are not visible and re-using them in other records. In this mode, you
     *   should implement ListGrid.updateRecordComponent to apply any changes to make reused
     *   components applicable to the new record they appear in, if necessary. For example, if
     *   you have several controls in your recordComponents, and not all of the
     *   controls apply to every record, your updateRecordComponent() implementation
     *   could simply hide or disable inapplicable controls, and this would be much faster than
     *   creating a whole new set of controls every time a given record is scrolled into view.
     * 
     *   If you are using ListGrid.showRecordComponentsByCell, and you
     *   have components of different types in different columns and still want to take
     *   advantage of component recycling, you can set ListGrid.poolComponentsPerColumn to
     *   ensure that components intended for one column are not recycled for use in another
     *   column that should have a different component.
     * 
     *   Note that, if different records have distinctly different components embedded
     *   in them, or multiple columns in each record embed different components, you should
     *   leave the recordComponentPoolingMode at "viewport" if your dataset is very large or
     *   use "data" otherwise.
     *  @type {RecordComponentPoolingMode}
     *  @default "viewport"
     */
    open var recordComponentPoolingMode: 
                                         /**
                                          *  components are destroyed when the record is not being rendered. Best    for large datasets where embedded components differ greatly per record.
                                          *  components are Canvas.clear when not in the viewport, but    stay with a record until the record is dropped from cache. Best for guaranteed
                                          *      small datasets.
                                          *  components are pooled and will be passed to    ListGrid.updateRecordComponent with the
                                          *      recordChanged parameter set to true. Best for large datasets where
                                          *      embedded components are uniform across different records and can be efficiently
                                          *      reconfigured to work with a new record
                                          */
                                         String /* viewport |  data |  recycle */ = definedExternally
    /**
     *  Should recycled ListGrid.showRecordComponents, be pooled
     *   per column or per record. Only applies if ListGrid.showRecordComponentsByCell is true.
     * 
     *   When ListGrid.recordComponentPoolingMode is "recycle" and you have components of
     *   different types in different columns, set this property to true to ensure that
     *   components intended for one column are not recycled for use in another column that
     *   should have a different component.
     * 
     *   If no components applicable to a particular column are available in the pool, the system
     *   calls ListGrid.createRecordComponent.
     *  @type {boolean}
     *  @default true
     */
    open var poolComponentsPerColumn: Boolean = definedExternally
    /**
     *  Should we show different styling for the cell the mouse is over?
     * 
     *   If true, the cell style will have the suffix "Over" appended.
     * 
     *   Can be overridden on a per-record basis via ListGridRecord.showRollOver.
     *  @type {boolean}
     *  @default true
     */
    open var showRollOver: Boolean = definedExternally
    /**
     *  Are rollovers cell-level or row-level?
     *  @type {boolean}
     *  @default null
     */
    open var useCellRollOvers: Boolean = definedExternally
    /**
     *  When enabled, when the mouse moves over a row or cell (depending on
     *   ListGrid.useCellRollOvers), an arbitrary Canvas can be shown layered on top of the row or
     *   cell (the ListGrid.rollOverCanvas), layered underneath the row or cell (the
     *   ListGrid.rollUnderCanvas), or both.
     * 
     *   This can be used to dynamically show controls or informational displays only on
     *   rollover. For example, controls to delete a row might appear only on rollover so they
     *   do not clutter the static display, or a "rollUnder" Canvas could be used to display
     *   additional information that can appear behind normal cell values (like displaying
     *   percent complete via as a bar of color that appears behind text values).
     * 
     *   Canvas.snapTo can be used to place the
     *   rollOver/rollUnderCanvas. With useCellRollOvers, positioning is relative
     *   to the cell, for row-level rollOver, position is relative to the portion of the
     *   row that is scrolled into view (this implies a row-level rollOver/UnderCanvas can never
     *   be placed horizontally scrolled out of view, but this is possible for a cell-level
     *   rollOver).
     * 
     *   snapTo positioning makes it easy to do something like place a button at the
     *   right edge of the grid, next to the scrollbar: just set snapTo:"R" on the
     *   rollOverCanvas.
     * 
     *   The rollOver/rollUnder Canvas can be a single static component (the same for all
     *   cells/rows) configured via the AutoChild system, or can instead be provided
     *   dynamically by implementing ListGrid.getRollOverCanvas and/or ListGrid.getRollUnderCanvas.
     * 
     *   The rollOver/rollUnder canvas will be automatically added to the grid's
     *   ListGrid.body as an
     *   ListGrid.addEmbeddedComponent.
     *   For grids with ListGridField.frozen, the behavior is as follows:
     * 
     *  - If ListGrid.useCellRollOvers is false (the default), embedded components
     *    will be added to both the body and the frozen body
     * 
     *  - Otherwise the component will be added to whichever body contains the cell the
     *    user is currently over
     *   The rollOver/rollUnder canvas added to the frozen body will be created by calling
     *   the ListGrid.getFrozenRollOverCanvas or ListGrid.getFrozenRollUnderCanvas methods.
     *   The default implementation for these methods matches their equivalents for non-frozen
     *   rollOver / rollUnder canvases - it will use the autoChild subsystem to create a
     *   canvas from the ListGrid.rollOverCanvas autoChild configuration.
     * 
     *   showRollOverCanvas has no effect if ListGrid.showRollOver is false.
     * 
     *   See also ListGrid.showSelectedRollOverCanvas.
     *  @type {boolean}
     *  @default null
     */
    open var showRollOverCanvas: Boolean = definedExternally
    /**
     *  AutoChild created and embedded in the grid if ListGrid.showRollOver
     *   is true and ListGrid.showRollOverCanvas is
     *   true or for selected records, if
     *   ListGrid.showSelectedRollOverCanvas
     *   is true. This component will be created and displayed above the current rollOver
     *   row or cell.
     * 
     *   Note that if this grid has frozen fields, the AutoChild subsystem will use the
     *   rollOverCanvas configuration settings to create the ListGrid.frozenRollOverCanvas
     *   (displayed in the frozen listGrid body).
     * 
     *   The rollOverCanvas has the following read-only attributes set:
     *   - this.grid - a pointer to the grid
     *   - this.record - a pointer to the current roll over record object in the grid
     *  @type {Canvas}
     *  @default null
     */
    open var rollOverCanvas: Canvas = definedExternally
    /**
     *  Automatically generated canvas embedded in the grid's frozen body if
     *   ListGrid.showRollOver
     *   is true and ListGrid.showRollOverCanvas is
     *   true or for selected records, if
     *   ListGrid.showSelectedRollOverCanvas
     *   is true. This component will be created and displayed above the current rollOver
     *   row or cell in the frozen body.
     * 
     *   The frozenRollOverCanvas will be created using the AutoChild subsystem, and
     *   will derive its configuration from the ListGrid.rollOverCanvas
     *   autoChild properties ("rollOverCanvasProperties", et al).
     * 
     *   The frozenRollOverCanvas has the following read-only attributes set:
     *   - this.grid - a pointer to the grid
     *   - this.record - a pointer to the current roll over record object in the grid
     *  @type {Canvas}
     *  @default null
     */
    open var frozenRollOverCanvas: Canvas = definedExternally
    /**
     *  If roll overs are enabled, should the ListGrid.rollUnderCanvas
     *   be displayed?
     * 
     *   Use of the showRollUnderCanvas is enabled if ListGrid.showRollOver
     *   is true, and either ListGrid.showRollOverCanvas
     *   is true and showRollUnderCanvas is unset, or showRollUnderCanvas
     *   is explicitly set to true.
     * 
     *   See also ListGrid.showSelectedRollUnderCanvas.
     *  @type {boolean}
     *  @default null
     */
    open var showRollUnderCanvas: Boolean = definedExternally
    /**
     *  AutoChild created and embedded in the grid if ListGrid.showRollOver
     *   is true, and either ListGrid.showRollOverCanvas
     *   is true and ListGrid.showRollUnderCanvas is
     *   unset, or showRollUnderCanvas is explicitly set to true.
     *   This component will be created and displayed behind the current rollOver row or cell in the
     *   page's z-order, meaning that it will only be visible if the cell styling is transparent.
     * 
     *   Note that if this grid has frozen fields, the AutoChild subsystem will use the
     *   rollUnderCanvas configuration settings to create the ListGrid.frozenRollUnderCanvas
     *   (displayed in the frozen listGrid body).
     * 
     *   The rollUnderCanvas has the following read-only attributes set:
     *   - this.grid - a pointer to the grid
     *   - this.record - a pointer to the current roll over record object in the grid
     *  @type {Canvas}
     *  @default null
     */
    open var rollUnderCanvas: Canvas = definedExternally
    /**
     *  Automatically generated canvas embedded in the grid's frozen body as a
     *   ListGrid.rollUnderCanvas.
     *   This component will be created and displayed above the current rollOver
     *   row or cell in the frozen body.
     * 
     *   The frozenRollUnderCanvas will be created using the AutoChild subsystem, and
     *   will derive its configuration from the ListGrid.rollUnderCanvas
     *   autoChild properties ("rollUnderCanvasProperties", et al).
     * 
     *   The frozenRollUnderCanvas has the following read-only attributes set:
     *   - this.grid - a pointer to the grid
     *   - this.record - a pointer to the current roll over record object in the grid
     *  @type {Canvas}
     *  @default null
     */
    open var frozenRollUnderCanvas: Canvas = definedExternally
    /**
     *  This setting causes the ListGrid.rollOverCanvas to be
     *   displayed when the user rolls over selected records in the grid (but not when
     *   rolling over other records). This can be useful to display a "Selected Over"
     *   appearance which can't be easily achieved via standard cell styling.
     *  @type {boolean}
     *  @default false
     */
    open var showSelectedRollOverCanvas: Boolean = definedExternally
    /**
     *  This setting causes the ListGrid.rollUnderCanvas to be
     *   displayed when the user rolls over selected records in the grid (but not when
     *   rolling over other records). This can be useful to display a "Selected Over"
     *   appearance which can't be easily achieved via standard cell styling.
     * 
     *   As with ListGrid.showRollUnderCanvas, if this property is unset, but
     *   the related ListGrid.showSelectedRollOverCanvas property is true, both the
     *   the roll under and roll under canvases will be displayed as the user rolls
     *   over selected records.
     *  @type {boolean}
     *  @default false
     */
    open var showSelectedRollUnderCanvas: Boolean = definedExternally
    /**
     *  This setting causes the ListGrid.rollOverCanvas to be
     *   sized to cover the normal row and the expansion layout. Otherwise the
     *   rollOverCanvas is only shown for the un-expanded part of the row.
     *  @type {boolean}
     *  @default null
     */
    open var showRollOverInExpansion: Boolean = definedExternally
    /**
     *  If the ListGrid.rollOverCanvas is enabled, setting this property
     *   to true ensures that when the rollOverCanvas is displayed it
     *   is animated into view via Canvas.animateShow. Note that the animation effect
     *   may be customized via Canvas.animateShowEffect, Canvas.animateShowTime and
     *   Canvas.animateShowAcceleration set in rollOverCanvasProperties.
     *  @type {boolean}
     *  @default false
     */
    open var animateRollOver: Boolean = definedExternally
    /**
     *  If the ListGrid.rollUnderCanvas is enabled, setting this property
     *   to true ensures that when the rollUnderCanvas is displayed it
     *   is animated into view via Canvas.animateShow. Note that the animation effect
     *   may be customized via Canvas.animateShowEffect, Canvas.animateShowTime and
     *   Canvas.animateShowAcceleration set in rollUnderCanvasProperties.
     *  @type {boolean}
     *  @default false
     */
    open var animateRollUnder: Boolean = definedExternally
    /**
     *  If true this grid will create and show per-row backgroundComponents
     *   as detailed ListGrid.backgroundComponent.
     *  @type {boolean}
     *  @default false
     */
    open var showBackgroundComponents: Boolean = definedExternally
    /**
     *  Has no effect unless ListGrid.showBackgroundComponents is true.
     * 
     *   Canvas created and embedded in the body behind a given record.  When
     *   ListGridRecord.backgroundComponent is set, this autoChild canvas
     *   will be constructed (if listGridRecord.backgroundComponent is not already a Canvas) and
     *   its properties combined with those of listGridRecord.backgroundComponent and then
     *   displayed behind a specific record in the page's z-order, meaning
     *   it will only be visible if the cell styling is transparent.
     *  @type {Canvas}
     *  @default null
     */
    open var backgroundComponent: Canvas = definedExternally
    /**
     *  If true, cellHover and rowHover events will fire and then a hover will be shown (if not
     *   canceled) when the user leaves the mouse over a row / cell unless the corresponding field has
     *   ListGridField.showHover set to false. If unset or null, the hover will be
     *   shown if the corresponding field has showHover:true. If false, then hovers are disabled.
     * 
     *   Note that standard hovers override ListGrid.showClippedValuesOnHover. Thus,
     *   to enable clipped value hovers, canHover must be unset or null and the corresponding field
     *   must have showHover unset or null as well.
     *  @type {boolean}
     *  @default null
     */
    override var canHover: Boolean = definedExternally
    /**
     *  If true, and canHover is also true, when the user hovers over a cell, hover text will pop up
     *   next to the mouse. The contents of the hover is determined by ListGrid.cellHoverHTML.
     *  @type {boolean}
     *  @default true
     */
    override var showHover: Boolean = definedExternally
    /**
     *  If true and a header button's title is clipped, then a hover containing the full field
     *   title is enabled.
     *  @type {boolean}
     *  @default true
     */
    open var showClippedHeaderTitlesOnHover: Boolean = definedExternally
    /**
     *  Style to apply to hovers shown over this grid.
     *  @type {CSSStyleName}
     *  @default "gridHover"
     */
    override var hoverStyle: String = definedExternally
    /**
     *  The selection associated with the ListGrid.
     *  @deprecated \* in favor of ListGrid.selectionManager
     *  @type {Selection | CellSelection}
     *  @default null
     */
    open var selection: dynamic = definedExternally
    /**
     *  The selection associated with the ListGrid.
     *  @type {Selection | CellSelection}
     *  @default null
     */
    open var selectionManager: dynamic = definedExternally
    /**
     *  How selection of rows should be presented to the user.
     * 
     *   For selectionAppearance:"checkbox" with multiple selection
     *   allowed, you would typically use ListGrid.selectionType:"simple" (the default). Because
     *   selectionType and selectionAppearance are unrelated,
     *   the combination of selectionAppearance:"checkbox" and
     *   selectionType:"multiple" results in a grid where multiple selection can
     *   only be achieved via shift-click or ctrl-click.
     * 
     *   If using "checkbox" for a ListGrid, see also
     *   ListGrid.checkboxField for customization APIs.
     * 
     *   If using "checkbox" for a TreeGrid, an extra icon,
     *   TreeGrid.getExtraIcon is not supported. Additionally only
     *   ListGrid.selectionType:"simple" and "single" are supported.
     *   You can also toggle the display of a disabled checkbox on a treeGrid, displayed
     *   when the node can't be selected, via TreeGrid.showDisabledSelectionCheckbox.
     * 
     *   Note that the default behavior when you enable checkbox selection is to continue to show
     *   the selected style. This can be changed by setting ListGrid.showSelectedStyle to false.
     *  @type {SelectionAppearance}
     *  @default "rowStyle"
     */
    open var selectionAppearance: 
                                  /**
                                   *  selected rows should be shown with different appearance - see          ListGrid.getCellStyle and optionally
                                   *            ListGrid.selectionCanvas.
                                   *  an extra, non-data column should be automatically added to the ListGrid,          showing checkboxes that can be toggled to select rows.
                                   *            See ListGrid.getCheckboxField.
                                   */
                                  String /* rowStyle |  checkbox */ = definedExternally
    /**
     *  Controls whether a checkbox for selecting all records appears in the header with
     *   ListGrid.selectionAppearance set to "checkbox"
     *  @type {boolean}
     *  @default null
     */
    open var canSelectAll: Boolean = definedExternally
    /**
     *  Should partial selection of all records be shown in header with a special icon?
     *   The partial icon will show in the header when ListGrid.canSelectAll is
     *   enabled and at least one record is selected but all records are not selected.
     *   To only show all selected and none selected states, set this attribute to false.
     *  @type {boolean}
     *  @default null
     */
    open var showHeaderPartialSelection: Boolean = definedExternally
    /**
     *  Controls whether a checkbox for selecting ListGrid.groupBy appears
     *   in the group node if SelectionAppearance is set to "checkbox"
     *  @type {boolean}
     *  @default false
     */
    open var canSelectGroups: Boolean = definedExternally
    /**
     *  Should partially selected parents (in a Tree data set) be shown with special icon?
     *   This has an impact in grouped grids where ListGrid.canSelectGroups is true. The
     *   partial icon will show up for the group header node when a group is partially
     *   selected.
     *  @type {boolean}
     *  @default false
     */
    open var showPartialSelection: Boolean = definedExternally
    /**
     *  Defines a listGrid's clickable-selection behavior.
     * 
     *   The default selection appearance is governed by ListGrid.selectionAppearance: if
     *   selectionAppearance is "checkbox", this will be "simple", otherwise, this will be
     *   "multiple".
     *  @type {SelectionStyle}
     *  @default null
     */
    open var selectionType: 
                            /**
                             *  don't select at all
                             *  select only one item at a time
                             *  select one or more items
                             *  select one or more items as a toggle      so you don't need to hold down control keys to select
                             *                   more than one object
                             */
                            String /* none |  single |  multiple |  simple */ = definedExternally
    /**
     *  If specified, the selection object for this list will use this property to mark records
     *   as selected. In other words, if this attribute were set to "isSelected"
     *   any records in the listGrid data where "isSelected" is true
     *   will show up as selected in the grid. Similarly if records are selected within the grid
     *   after the grid has been created, this property will be set to true on the selected
     *   records.
     *  @type {string}
     *  @default null
     */
    open var selectionProperty: String = definedExternally
    /**
     *  If true, when an update operation occurs on a selected record in a
     *   ListGrid.dataSource listGrid, ensure the updated record is
     *   re-selected when the operation completes.
     *   The ListGrid.reselectOnUpdateNotifications attributes governs whether
     *   ListGrid.selectionUpdated and ListGrid.selectionChanged will fire
     *   when this occurs.
     *  @type {boolean}
     *  @default true
     */
    open var reselectOnUpdate: Boolean = definedExternally
    /**
     *  if ListGrid.reselectOnUpdate is true, this property governs what
     *   selection changed notifications should be triggered when a selected record
     *   is edited then automatically reselected when the edited data is merged into
     *   the data set.
     *  @type {SelectionNotificationType}
     *  @default "selectionChanged"
     */
    open var reselectOnUpdateNotifications: 
                                            /**
                                             *  No selection change notification should fire
                                             *  ListGrid.selectionChanged should fire but ListGrid.selectionUpdated should not fire.
                                             *  ListGrid.selectionChanged and ListGrid.selectionUpdated should both fire.
                                             */
                                            String /* none |  selectionChanged |  selectionUpdated */ = definedExternally
    /**
     *  If set to false on a record, selection of that record is disallowed.
     *  @type {string}
     *  @default "canSelect"
     */
    open var recordCanSelectProperty: String = definedExternally
    /**
     *  Enables cell-level selection behavior as well as
     *   ListGrid.useCellRollOvers.
     * 
     *   To query and manipulate cell-level selections, use ListGrid.getCellSelection to retrieve
     *   the CellSelection.
     * 
     *   Note that the ListGrid has a data model of one Record per row, unlike the
     *   CubeGrid which supports one CellRecord per cell. For this reason
     *   record-oriented APIs that act on the selection will act on entire Records that have
     *   any selected cells (examples include drag and drop and transferSelectedData()).
     * 
     *   More generally, canSelectCells is primarily intended to enable developers
     *   to build Excel-like interactions on local datasets, by using ListGrid.setData plus
     *   ListGrid.saveLocally:true rather than record-oriented DataSources and data binding.
     * 
     *   The following keyboard selection behaviors are enabled with this property in
     *   addition to standard single-selection Arrow Key navigation:
     * 
     *   SHIFT +    [Arrow Key]: begin or continue incremental selection
     * 
     *   SHIFT + CTRL + [Arrow Key]: incremental selection to the end of row or column
     * 
     *   CTRL + A: select all cells (enabled only with ListGrid.canSelectAll)
     * 
     *   Incremental selection allows selection of rows and columns of cells via keyboard
     *   or mouse provided the shift key is down. Behavior is designed to match Excel.
     *   Thus, if a previous selection has begun, cells will be selected from that origin.
     * 
     *   Users may also navigate through cells using the Tab and Shift+Tab
     *   keypresses if ListGrid.navigateOnTab is true. When a user tabs to the
     *   end of the row, the ListGrid.rowEndEditAction is used to determine whether
     *   to shift selection to the next row, return to the beginning of the same row, or
     *   simply move on through the page's tab order.
     *  @type {boolean}
     *  @default false
     */
    open var canSelectCells: Boolean = definedExternally
    /**
     *  If ListGrid.canSelectCells is true, this property allows the user
     *   to navigate through the cells of a grid using Tab and Shift+Tab keypresses.
     *   When a user tabs to the
     *   end of the row, the ListGrid.rowEndEditAction is used to determine whether
     *   to shift selection to the next row, return to the beginning of the same row, or
     *   simply move on through the page's tab order.
     *  @type {boolean}
     *  @default true
     */
    open var navigateOnTab: Boolean = definedExternally
    /**
     *  Enables copy/paste shortcuts, provided ListGrid.canSelectCells is true
     * 
     *   The default setting of true means that the value of ListGrid.canSelectCells
     *   determines whether copy/paste shortcuts are enabled. Setting this property to
     *   false disables said shortcuts unconditionally.
     * 
     *   Copying is done via copying to a SmartClient-wide "clipboard" - not the OS-level
     *   clipboard, which is inaccessible on some browsers - via the methods
     *   ListGrid.getSelectedCellData and ListGrid.applyCellData. To copy data to and
     *   from applications outside of the browser, use the technique shown in the
     *   ${isc.DocUtils.linkForExampleId('gridToExcel', 'Grid to Excel')} and
     *   ${isc.DocUtils.linkForExampleId('excelToGrid', 'Excel to Grid')} samples.
     * 
     *   The following shortcuts are available:
     * 
     *   CTRL + D: copy cell values from top row of selected cells down to all rows
     * 
     *   CTRL + R: copy cell values from left column of selected cells right to all columns
     * 
     *   CTRL + C: copy selected cell values into shared clipboard
     * 
     *   CTRL + V: paste from shared clipboard into current selection
     *  @type {boolean}
     *  @default true
     */
    open var useCopyPasteShortcuts: Boolean = definedExternally
    /**
     *  Name of a CSS Style to use as the ListGrid.baseStyle for a cell that
     *   is currently a selection origin for shifted incremental cell selection.
     *   Only has an effect if ListGrid.canSelectCells is true.
     * 
     *  @type {CSSStyleName}
     *  @default null
     */
    open var originBaseStyle: String = definedExternally
    /**
     *  If this property is true, users can drag the mouse to select several rows or cells.
     *   This is mutually exclusive with rearranging rows or cells by dragging.
     * 
     *   NOTE: If canDragSelect is initially enabled or might be
     *   dynamically enabled after the grid is created, it may be desirable to disable
     *   Canvas.useTouchScrolling so that touch-dragging records/cells
     *   selects them rather than starting a scroll. If Canvas.disableTouchScrollingForDrag
     *   is set to true, then touch scrolling will be disabled automatically.
     *   However, for accessibility reasons, it is recommended to
     *   leave touch scrolling enabled and provide an alternative set of controls that can be
     *   used to perform drag-selection.
     *  @type {boolean}
     *  @default false
     */
    open var canDragSelect: Boolean = definedExternally
    /**
     *  If this property is true, users can drag the mouse to select text within grid rows,
     *   ready to be cliped to clipboard.
     *   This is mutually exclusive with
     *   ListGrid.canReorderRecords, and with
     *   ListGrid.canDragSelect.
     * 
     *   To enable selecting cell text on click, see ListGrid.selectCellTextOnClick.
     *  @type {boolean}
     *  @default false
     */
    open var canDragSelectText: Boolean = definedExternally
    /**
     *  If set to false, dropping over an empty part of the grid body is disallowed and the
     *   no-drop indicator is displayed.
     *  @type {boolean}
     *  @default true
     */
    open var canDropInEmptyArea: Boolean = definedExternally
    /**
     *  If ListGrid.selectionType is set to
     *   "single",
     * 
     *   setting this property to true means selection will be displayed to the
     *   user with the ListGrid.selectionCanvas and/or
     *   ListGrid.selectionUnderCanvas rather than with CSS styling.
     * 
     *   If showSelectionCanvas is set to true, then the
     *   selectionUnderCanvas will automatically be enabled unless
     *   ListGrid.showSelectionUnderCanvas is set to false.
     * 
     *   NOTE: It is recommended to use the selectionUnderCanvas rather than the
     *   selectionCanvas if possible because the selectionCanvas is
     *   stacked on top of the selected record and this may interfere with event handling in rare
     *   cases. If no interactive components are shown in the selectionCanvas and it
     *   simply provides custom styling, then the selectionUnderCanvas should be used
     *   instead.
     * 
     *   With ListGrid.canFreezeFields, the selectionCanvas
     *   is displayed only over the non-frozen fields of the selected row.
     *  @type {boolean}
     *  @default null
     */
    open var showSelectionCanvas: Boolean = definedExternally
    /**
     *  AutoChild created and embedded in the grid if ListGrid.showSelectionCanvas
     *   is true and the ListGrid.selectionType is
     *   "single".
     * 
     *   This component will be created and displayed above the selected record whenever the
     *   selection changes.
     * 
     *   NOTE: It is recommended to use the ListGrid.selectionUnderCanvas
     *   rather than the selectionCanvas if possible because the selectionCanvas
     *   is stacked on top of the selected record and this may interfere with event handling in rare
     *   cases. If no interactive components are shown in the selectionCanvas and it
     *   simply provides custom styling, then the selectionUnderCanvas should be used
     *   instead.
     * 
     *   The selectionCanvas has the following read-only attributes set:
     *   - this.grid - a pointer to the grid
     *   - this.record - a pointer to the currently selected record in the grid
     *  @type {Canvas}
     *  @default null
     */
    open var selectionCanvas: Canvas = definedExternally
    /**
     *  If ListGrid.selectionType is set to
     *   "single",
     * 
     *   and either ListGrid.showSelectionCanvas is true and
     *   showSelectionUnderCanvas is unset, or showSelectionUnderCanvas
     *   is explicitly set to true, then selection will be displayed to the
     *   user with the ListGrid.selectionCanvas and/or
     *   ListGrid.selectionUnderCanvas rather than with CSS styling.
     *   Setting showSelectionUnderCanvas to false will disable
     *   the use of the selectionUnderCanvas.
     * 
     *   With ListGrid.canFreezeFields, the selectionUnderCanvas
     *   is displayed only behind the non-frozen fields of the selected row.
     *  @type {boolean}
     *  @default null
     */
    open var showSelectionUnderCanvas: Boolean = definedExternally
    /**
     *  AutoChild created and embedded in the grid if ListGrid.showSelectionCanvas
     *   is true and ListGrid.showSelectionUnderCanvas
     *   is unset, or showSelectionUnderCanvas is explicitly set to true,
     *   and the ListGrid.selectionType is
     *   "single".
     * 
     *   This component will be created and displayed behind the selected record whenever the
     *   selection changes.
     * 
     *   The selectionUnderCanvas has the following read-only attributes set:
     *   - this.grid - a pointer to the grid
     *   - this.record - a pointer to the currently selected record object in the grid
     *  @type {Canvas}
     *  @default null
     */
    open var selectionUnderCanvas: Canvas = definedExternally
    /**
     *  If the ListGrid.selectionCanvas is enabled, setting
     *   this property to true ensures that when the selectionCanvas
     *   is displayed it is animated into view via Canvas.animateShow. Note that the
     *   animation effect may be customized via Canvas.animateShowEffect,
     *   Canvas.animateShowTime and Canvas.animateShowAcceleration set in
     *   selectionCanvasProperties.
     *  @type {boolean}
     *  @default false
     */
    open var animateSelection: Boolean = definedExternally
    /**
     *  If the ListGrid.selectionUnderCanvas is enabled, setting
     *   this property to true ensures that when the selectionUnderCanvas
     *   is displayed it is animated into view via Canvas.animateShow. Note that the
     *   animation effect may be customized via Canvas.animateShowEffect,
     *   Canvas.animateShowTime and Canvas.animateShowAcceleration set in
     *   selectionUnderCanvasProperties.
     *  @type {boolean}
     *  @default false
     */
    open var animateSelectionUnder: Boolean = definedExternally
    /**
     *  Returns the specially generated checkbox field used when SelectionAppearance is
     *   "checkbox". Created via the AutoChild pattern so that
     *   checkboxFieldDefaults and checkboxFieldProperties are available
     *   for skinning purposes. Note that ListGridField.shouldPrint is false
     *   for the checkboxField by default - if you want this column to show up in the grid's print
     *   view, use checkboxFieldProperties to set this property to true.
     * 
     *   This field will render an icon to indicate the selected state of each row, which, when
     *   clicked will toggle the selection state. The icon src may be configured using
     *   ListGrid.checkboxFieldTrueImage and ListGrid.checkboxFieldFalseImage, as
     *   well as ListGrid.checkboxFieldImageWidth and ListGrid.checkboxFieldImageHeight.
     * 
     *   The checkboxField can be detected by calling ListGrid.isCheckboxField on any
     *   ListGridField object.
     *  @type {ListGridField}
     *  @default null
     */
    open var checkboxField: ListGridField = definedExternally
    /**
     *  If ListGrid.selectionAppearance is set to "checkbox" this property
     *   determines the image to display in the checkbox field for a selected row.
     *   If unset, the ListGrid.booleanTrueImage will be used. Note that the special
     *   value "blank" means that no image will be shown.
     *  @type {SCImgURL}
     *  @default null
     */
    open var checkboxFieldTrueImage: String = definedExternally
    /**
     *  If ListGrid.selectionAppearance is set to "checkbox" this property
     *   determines the image to display in the checkbox field for an unselected row.
     *   If unset, the ListGrid.booleanFalseImage will be used. Note that the special
     *   value "blank" means that no image will be shown.
     *  @type {SCImgURL}
     *  @default null
     */
    open var checkboxFieldFalseImage: String = definedExternally
    /**
     *  If ListGrid.selectionAppearance is set to "checkbox" this property
     *   determines the image to display in the checkbox field for a partially selected row.
     *   If unset, the ListGrid.booleanPartialImage will be used. Note that the special
     *   value "blank" means that no image will be shown.
     *  @type {SCImgURL}
     *  @default null
     */
    open var checkboxFieldPartialImage: String = definedExternally
    /**
     *  If set, the ListGrid.checkboxFieldTrueImage to use when printing.
     *  @type {SCImgURL}
     *  @default null
     */
    open var printCheckboxFieldTrueImage: String = definedExternally
    /**
     *  If set, the ListGrid.checkboxFieldFalseImage to use when printing.
     *  @type {SCImgURL}
     *  @default null
     */
    open var printCheckboxFieldFalseImage: String = definedExternally
    /**
     *  If set, the ListGrid.checkboxFieldPartialImage to use when printing.
     *  @type {SCImgURL}
     *  @default null
     */
    open var printCheckboxFieldPartialImage: String = definedExternally
    /**
     *  If ListGrid.selectionAppearance is set to "checkbox" this property
     *   may be set to govern the width of the checkbox image displayed to indicate whether a row is
     *   selected. If unset, the checkboxField image will be sized to match the
     *   ListGrid.booleanImageWidth for this grid.
     *  @type {Integer}
     *  @default null
     */
    open var checkboxFieldImageWidth: Number = definedExternally
    /**
     *  If ListGrid.selectionAppearance is set to "checkbox" this property
     *   may be set to govern the height of the checkbox image displayed to indicate whether a row is
     *   selected. If unset, the checkboxField image will be sized to match the
     *   ListGrid.booleanImageHeight for this grid.
     *  @type {Integer}
     *  @default null
     */
    open var checkboxFieldImageHeight: Number = definedExternally
    /**
     *  Indicates whether the text of the emptyMessage property should be displayed if no data is
     *   available.
     *  @type {boolean}
     *  @default true
     */
    open var showEmptyMessage: Boolean = definedExternally
    /**
     *  The string to display in the body of a listGrid with an empty data array, if
     *   showEmptyMessage is true.
     *  @type {HTMLString}
     *  @default "No items to show."
     */
    open var emptyMessage: String = definedExternally
    /**
     *  The CSS style name applied to the ListGrid.emptyMessage if displayed.
     *  @type {CSSStyleName}
     *  @default "emptyMessage"
     */
    open var emptyMessageStyle: String = definedExternally
    /**
     *  The prompt to show when the mouse hovers over the Filter button in the FilterEditor.
     *  @type {string}
     *  @default "Filter"
     */
    open var filterButtonPrompt: String = definedExternally
    /**
     *  The string to display in the body of a listGrid while data is being loaded.
     *   Use "&#36;{loadingImage}" to include Canvas.loadingImageSrc.
     *  @type {HTMLString}
     *  @default "${loadingImage}&amp;nbsp;Loading data..."
     */
    open var loadingDataMessage: String = definedExternally
    /**
     *  The CSS style name applied to the loadingDataMessage string if displayed.
     *  @type {CSSStyleName}
     *  @default "loadingDataMessage"
     */
    open var loadingDataMessageStyle: String = definedExternally
    /**
     *  If you have a databound listGrid and you scroll out of the currently loaded dataset, by
     *   default you will see blank rows until the server returns the data for those rows. The
     *   loadingMessage attribute allows you to specify arbitrary html that will be shown in each
     *   such "blank" record while the data for that record is loading.
     *  @type {string}
     *  @default "&amp;nbsp;"
     */
    open var loadingMessage: String = definedExternally
    /**
     *  If record[this.singleCellValueProperty] is set for some record, the
     *   record will be displayed as a single cell spanning every column in the grid, with
     *   contents set to the value of record[this.singleCellValueProperty].
     *  @type {string}
     *  @default "singleCellValue"
     */
    open var singleCellValueProperty: String = definedExternally
    /**
     *  If record[this.isSeparatorProperty] is set for some record, the
     *   record will be displayed as a simple separator row.
     *  @type {string}
     *  @default "isSeparator"
     */
    open var isSeparatorProperty: String = definedExternally
    /**
     *  Should this listGrid display a filter row. If true, this ListGrid
     *   will be drawn with a single editable row, (separate from the body) with a filter button.
     * 
     *   Values entered into this row are used as filter criteria to filter this List's data on
     *   enter-keypress or filter button click. ListGrid.autoFetchTextMatchStyle determines
     *   the textMatchStyle for the request passed to ListGrid.fetchData.
     * 
     *   The default FormItem.operator for an item in the filterEditor can
     *   be set via ListGridField.filterOperator.  When field.filterOperator
     *   has been set calls to retrieve the criteria from the grid return AdvancedCriteria.
     *   See also ListGrid.allowFilterOperators for a UI that allows end users to change the search
     *   operator on the fly
     * 
     *   Note that if ListGrid.filterData or ListGrid.fetchData is called
     *   directly while the filter editor is showing, the filter editor values will be updated to
     *   reflect the new set of criteria. If you wish to retain the user entered filter criteria
     *   and modify a subset of field values programmatically, this can be achieved by
     *   copying the existing set of criteria and adding other changes - something
     *   like this:
     * 
     * 
     *    var newCriteria = myListGrid.getFilterEditorCriteria();
     *    isc.DataSource.combineCriteria(newCriteria, {
     *     field1:"new value1",
     *     field2:"new value2"
     *    });
     *    myListGrid.setCriteria(newCriteria);
     * 
     * 
     * 
     *   In this example code we're using ListGrid.getFilterEditorCriteria rather than
     *   ListGrid.getCriteria - this ensures that if the user has typed a new value into
     *   the filter editor, but not yet clicked the filter button, we pick up the value the user
     *   entered. This sample code uses DataSource.combineCriteria to combine the
     *   existing filterEditorCriteria with some new custom criteria. This technique is
     *   applicable to both simple and advanced criteria.
     * 
     *   If you call filterData() and pass in criteria for dataSource
     *   fields that are not present in the ListGrid, these criteria will continue to be applied
     *   along with the user-visible criteria.
     * 
     *   filterEditor and advanced criteria: If a developer calls filterData()
     *   on a ListGrid and passes in AdvancedCriteria, expected behavior of the filter
     *   editor becomes ambiguous, since AdvancedCriteria has far more complex filter
     *   expression support than the ordinary filterEditor can represent.
     * 
     *   Default behavior for AdvancedCriteria will combine the AdvancedCriteria with the values
     *   in the filter editor as follows:
     * 
     * 
     *  - If the top level criteria has operator of type "and":
     *   Each field in the top level
     *   criteria array for which a 'canFilter' true field is shown in the listGrid will show up
     *   if the specified operator matches the default filter behavior
     *   (based on the ListGrid.autoFetchTextMatchStyle).
     *   If the user enters values in the filter editor, these will be combined with the
     *   existing AdvancedCriteria by either replacing or adding field level criteria at the top
     *   level.
     * 
     *  - If the top level criteria is a single field-criteria:
     *   If the field shows up in the listGrid and is canFilter:true, it will be displayed to
     *   the user (if the operator matches the default filter behavior for the field).
     *   If the user enters new filter criteria in the filterEditor, they will be combined with
     *   this existing criterion via a top level "and" operator, or if the user modifies the
     *   field for which the criterion already existed, it will be replaced.
     * 
     *  - Otherwise, if there are multiple top level criteria combined with an "or" operator,
     *   these will not be shown in the filter editor. Any filter parameters the user enters will
     *   be added to the existing criteria via an additional top level "and" operator, meaning
     *   the user will essentially filter a subset of the existing criteria
     * 
     *  @type {boolean}
     *  @default false
     */
    open var showFilterEditor: Boolean = definedExternally
    /**
     *  If ListGrid.showFilterEditor is set to true, the filterEditor
     *   is automatically created as an AutoChild.
     *   Developers may customize the AutoChild using ListGrid.filterEditorProperties.
     *  @type {RecordEditor}
     *  @default null
     */
    open var filterEditor: RecordEditor = definedExternally
    /**
     *  Properties to apply to the automatically generated ListGrid.filterEditor
     *   if ListGrid.showFilterEditor is true.
     *  @type {RecordEditor}
     *  @default null
     */
    open var filterEditorProperties: RecordEditor = definedExternally
    /**
     *  If ListGrid.showFilterEditor is true, this attribute may be used to customize the
     *   filter button shown to the right of the filterEditor row.
     *  @type {Button}
     *  @default null
     */
    open var filterButtonProperties: Button = definedExternally
    /**
     *  Height for the filterEditor, if shown.
     *  @type {number}
     *  @default "22"
     */
    open var filterEditorHeight: Number = definedExternally
    /**
     *  When this grid is initially filtered via ListGrid.autoFetchData, or filtered by the user
     *   via the ListGrid.showFilterEditor, this attribute can be used to set the
     *   textMatchStyle on the dsRequest passed to fetchData().
     * 
     *   To use a mixture of textMatchStyles, set an appropriate
     *   FormItem.operator on a field's
     *   ListGridField.filterEditorProperties.
     *  @type {TextMatchStyle}
     *  @default "substring"
     */
    open var autoFetchTextMatchStyle: 
                                      /**
                                       *  case-insensitive exact match ("foo" matches "foo" and "FoO", but not "FooBar")
                                       *  case-sensitive exact match ("foo" matches only "foo")
                                       *  case-insenstive substring match ("foo" matches "foobar" and "BarFoo")
                                       *  case-insensitive prefix match ("foo" matches "FooBar" but not "BarFoo")
                                       *   textMatchStyle behavior is consistent across the client and all three of the built-in
                                       *   server DataSource implementations - SQL, Hibernate and JPA - to the maximum extent that is
                                       *   practical. Known inconsistencies, some of which can be tweaked with configuration settings,
                                       *   are described below
                                       * 
                                       *  - textMatchStyle can be disabled for any individual field with the
                                       *   DataSourceField.ignoreTextMatchStyle declaration. This behavior is consistent
                                       *   across client and server implementations, with the proviso that case-sensitive behavior
                                       *   is inherently inconsistent in the server-side implementations (see below for a more
                                       *   detailed discussion of this)
                                       * 
                                       *  - textMatchStyle is forced to "exactCase" for DataSourceField.primaryKey
                                       *   fields on update and remove operations, unless
                                       *   OperationBinding.allowMultiUpdate is in force. This means that a normal update
                                       *   or remove operation - which is constrained by a unique primaryKey value or combination, to
                                       *   affect only a single data row - will use an equality match on all primaryKey fields. This
                                       *   is desirable because it makes index usage more likely. Note that this means the key values
                                       *   "foo" and "FOO" are distinct, which is a change from previous behavior. For most databases,
                                       *   this change will have no effect because most databases do not by default allow primaryKey
                                       *   values that only differ in case anyway - if a table has a row with a PK of "foo" and you
                                       *   try to insert a row with a PK of "FOO", most databases will fail with a constraint violation.
                                       *   However, if you are using a database hat allows key values that differ only in case, and you
                                       *   need to support this for some reason, you can switch the framework back to the previous
                                       *   behavior by setting property allow.case.sensitive.pks to true in
                                       *   your server.properties file. Note, we do not recommend this; in fact, we do
                                       *   not recommend the use of text primaryKey fields at all. Where you have control ,we would
                                       *   always recommend the use of automatically incrementing numeric sequence keys.
                                       * 
                                       *  - textMatchStyle does not apply to boolean or temporal (date, datetime, time)
                                       *   DataSourceField.type. Such fields are always checked for equality. If
                                       *   you have a need for more complex matching, such as date-range checking, use AdvancedCriteria
                                       * 
                                       *  - Critiera values for temporal fields must be real dates (Javascript Date
                                       *   objects on the client, instances of java.util.Date on the server). Attempting
                                       *   to match against a string or any other type of value will result in an "always fails"
                                       *   clause being generated. This behavior is how the client code has always worked, but is a
                                       *   change for the server-side DataSources, in the interests of consistency. The previous
                                       *   behavior was:
                                       * 
                                       *  - SQLDataSource used to attempt to match the date column to the criteria value provided;
                                       *    if that value was an appropriately-formatted string, that attempt might have
                                       *    worked, but it would be database-specific. If you have an application that depends on
                                       *    this old behavior, you can switch it back on by adding the following to your
                                       *    server.properties file:
                                       *    sql.temporal.fields.require.date.criteria: false
                                       * 
                                       *  - HibernateDataSource and JPADataSource used to skip such clauses altogether, which
                                       *    results in the opposite behavior (there is an implied "always succeeds" clause, because
                                       *    the clause is not present in the query at all). If you have an application that depends on
                                       *    this old behavior, you can switch it back on by adding the following to your
                                       *    server.properties file:
                                       *    jpa.temporal.fields.require.date.criteria: false or
                                       *    hibernate.temporal.fields.require.date.criteria: false, as appropriate
                                       * 
                                       * 
                                       *  - textMatchStyle does not apply to fields used in the joins generated to satisfy
                                       *   DataSourceField.includeFrom declarations or entity relations in
                                       *   Hibernate or JPA. Again, such comparisons are always for equality
                                       * 
                                       *  - textMatchStyle is applied to numeric fields only if the supplied criteria value
                                       *   is a string. So for a numeric field "myNumber", we will match 10, 100, 110 and 1000 if a
                                       *   criteria value of "10" (the quoted string) is supplied, but we will only match 10 if a
                                       *   criteria value of 10 (the actual number) is supplied
                                       * 
                                       *  - This is a change in behavior for the server-side DataSource implementations, in the
                                       *    interests of consistency with the client behavior. Previously, all three of the built-in
                                       *    DataSource implementations applied textMatchStyle to numeric fields regardless of the
                                       *    criteria value's type. If you have an application that depends on this old behavior,
                                       *    you can switch it back on by adding the following to your server.properties
                                       *    file: sql.substring.numeric.criteria: true or
                                       *    hibernate.substring.numeric.criteria: true or
                                       *    jpa.substring.numeric.criteria: true, as appropriate
                                       * 
                                       * 
                                       *  - "exactCase" matching cannot be made consistent across all database providers because
                                       *   each database has its own idea of whether case-sensitive matching should be the default,
                                       *   and how to switch it on and off (if that is even possible)
                                       * 
                                       *  - Microsoft SQL Server must have case-sensitive matching enabled by setting a
                                       *    case-sensitive collation when the database is created (there are more fine-grained
                                       *    options, but we do not recommend them because of the scope for further inconsistency,
                                       *    where "exactCase" works correctly on table A but not on table B). See
                                       *    MSDN for details
                                       * 
                                       *  - HSQLDB has case sensitivity set with the SET IGNORECASE directive -
                                       *    see here
                                       * 
                                       *  - MySQL is case-insensitive, but since it provides an easy way to do per-query,
                                       *    case-sensitive matching in SQL, we work around it for that database, but only in
                                       *    SQL DataSources
                                       * 
                                       * 
                                       *  - If you are using Hibernate or JPA, whether "exactCase" works as expected depends
                                       *   entirely on the underlying database. Unlike the SQL DataSource, where we have fine-grained
                                       *   control of the SQL that the database executes, we are constrained by what the ORM will
                                       *   allow. This prevents us from compensating for database quirks, like we do with MySQL's
                                       *   case-insensitivity in the SQL DataSource
                                       * 
                                       */
                                      String /* exact |  exactCase |  substring |  startsWith */ = definedExternally
    /**
     *  Causes a menu item titled ListGrid.filterUsingText to appear in the
     *   ListGrid.showHeaderContextMenu that allows the end user to pick an advanced
     *   OperatorId to use for this field.
     * 
     *   Once an operator has been chosen, the active operator is indicated by an
     *   ListGrid.operatorIcon placed within the field (you can alternatively cause the
     *   icon to ListGrid.alwaysShowOperatorIcon). The operatorIcon
     *   shows the same textual representation of the search operator as is used by the
     *   FormItem.allowExpressions feature. Clicking on the icon provides a second way to
     *   modify the search operator.
     * 
     *   This feature is enabled by default if DataSource.supportsAdvancedCriteria is true,
     *   for all fields where it is normally possible to filter by typing in a search string. This
     *   excludes field types such as "date" or "boolean" which show specialized filter controls.
     *   Use ListGridField.allowFilterOperators to disable this interface for individual
     *   fields, or set DataSourceField.canFilter to false to disallow filtering entirely for
     *   a field.
     * 
     *   Note that this feature is similar to ListGrid.allowFilterExpressions, which allows
     *   the end users to directly type in characters such as "&gt;" to control filtering.
     *   allowFilterOperators is easier to use and more discoverable than
     *   allowFilterExpressions, and also avoids the drawback where special characters
     *   like "&gt;" cannot be used in filter values. However, allowFilterExpressions
     *   allows users to make use of certain operators that allowFilterOperators does
     *   not support, such as using the "betweenInclusive" operator by typing "5...10".
     * 
     *   When both allowfilterExpressions and allowFilterOperators are set,
     *   filter expressions entered in to the edit-area are parsed and the operator automatically
     *   applied to the ListGrid.operatorIcon.
     *  @type {boolean}
     *  @default null
     */
    open var allowFilterOperators: Boolean = definedExternally
    /**
     *  When ListGrid.allowFilterOperators is enabled, whether to show the ListGrid.operatorIcon for all
     *   filterable fields, or only for fields where the user has explicitly chosen a search operator
     *   different from the default operator for the field.
     * 
     *   The default operator for a field is determined by ListGrid.autoFetchTextMatchStyle or by
     *   setting ListGridField.filterOperator for a specific field.
     *  @type {boolean}
     *  @default null
     */
    open var alwaysShowOperatorIcon: Boolean = definedExternally
    /**
     *  Inline icon shown inside ListGrid.showFilterEditor fields when
     *   ListGrid.allowFilterOperators is enabled.
     *  @type {FormItemIcon}
     *  @default null
     */
    open var operatorIcon: FormItemIcon = definedExternally
    /**
     *  Text for the menu item shown in the ListGrid.showHeaderContextMenu when
     *   ListGrid.allowFilterOperators is enabled.
     *  @type {string}
     *  @default "Filter using"
     */
    open var filterUsingText: String = definedExternally
    /**
     *  Text to show after the name of the default filterOperator in the
     *   ListGrid.showHeaderContextMenu when ListGrid.allowFilterOperators is enabled.
     *  @type {string}
     *  @default "(default)"
     */
    open var defaultFilterOperatorSuffix: String = definedExternally
    /**
     *  Can the user edit cells in this listGrid? Can be set for the listGrid, and overridden for
     *     individual fields.
     *     If 'canEdit' is false at the listGrid level, fields can never be edited - in this case
     *     the canEdit property on individual fields will be ignored.
     *     If 'canEdit' is set to true at the listGrid level, setting the 'canEdit' property to
     *     false at the field level will prevent the field from being edited inline.
     *     If 'canEdit' is not set at the listGrid level, setting 'canEdit' to true at the field
     *     level enables the field to be edited inline.
     *  @type {boolean}
     *  @default null
     */
    open var canEdit: Boolean = definedExternally
    /**
     *  Property name on a record that should be checked to determine whether the record may be
     *   edited.
     * 
     *   This property is configurable to avoid possible collision with data values in record.
     *   With the default setting of "_canEdit", a record can be set non-editable by ensuring
     *   record._canEdit == false.
     * 
     *   For controlling editability for the entire grid or for a field, set grid.canEdit or
     *   field.canEdit.
     *  @type {string}
     *  @default "_canEdit"
     */
    open var recordEditProperty: String = definedExternally
    /**
     *  When this attribute is set, editors will be rendered into every row of the grid rather than
     *   showing up in a single record at a time.
     *   This attribute is only valid when ListGrid.editByCell is false
     *  @type {boolean}
     *  @default null
     */
    open var alwaysShowEditors: Boolean = definedExternally
    /**
     *  Determines whether when the user edits a cell in this listGrid the entire row becomes
     *   editable, or just the cell that received the edit event.
     * 
     *   No effect if this.canEdit is false or null.
     *  @type {boolean}
     *  @default null
     */
    open var editByCell: Boolean = definedExternally
    /**
     *  Whether edits should be saved whenever the user moves between cells in the current edit
     *   row.
     * 
     *   If unset, defaults to ListGrid.editByCell.
     * 
     *   To avoid automatic saving entirely, set ListGrid.autoSaveEdits:false.
     *  @type {boolean}
     *  @default null
     */
    open var saveByCell: Boolean = definedExternally
    /**
     *  Whether client-side validation checks should be performed when the user moves between
     *   cells in the current edit row. If unset, defaults to ListGrid.editByCell.
     * 
     *   Note that validation always occurs when a row is to be saved, so setting
     *   ListGrid.saveByCell:true forces validation on cell transitions. To completely disable
     *   automatic validation, set ListGrid.neverValidate:true.
     *  @type {boolean}
     *  @default null
     */
    open var validateByCell: Boolean = definedExternally
    /**
     *  If true, validation will be performed on each edited cell when each editor's
     *   "change" handler is fired.
     *  @type {boolean}
     *  @default null
     */
    open var validateOnChange: Boolean = definedExternally
    /**
     *  If true, validation will not occur as a result of cell editing for this grid.
     *  @type {boolean}
     *  @default null
     */
    open var neverValidate: Boolean = definedExternally
    /**
     *  If set, provide UI for the user to remove records from the grid as an additional field
     *   showing the ListGrid.removeIcon, which, when clicked, will call
     *   ListGrid.removeRecordClick which removes the row from the data set (or if
     *   ListGrid.deferRemoval is true changes the ListGrid.markRecordRemoved status
     *   for the record). Individual records can be marked to prevent removal - see
     *   ListGrid.recordCanRemoveProperty.
     * 
     *   To add a confirmation dialog before a record is removed, set
     *   ListGrid.warnOnRemoval.
     * 
     *   If deferring removal, the record will appear marked with the ListGrid.removedCSSText
     *   until the removal is committed via a call to ListGrid.saveEdits.
     *   Otherwise, the record will disappear from view. If ListGrid.animateRemoveRecord
     *   is true, the removed record will appear to shrink out of view when it is removed.
     * 
     *   By default the field will display the ListGrid.removeIcon next to each record, and
     *   will be rendered as the rightmost column. Two mechanisms exist to further modify this field:
     * 
     * 
     *  - To change the position of the remove-field, include an explicitly specified field with
     *     the attribute ListGridField.isRemoveField set. This will then
     *     be used as the remove field instead of adding a field to the beginning of the set of
     *     columns.
     * 
     *  - Additional direct configuration of the remove field may be achieved by modifying
     *     ListGrid.removeFieldProperties.
     * 
     *   If ListGrid.deferRemoval is true, when a record is marked as removed, the the icon will
     *   change to display the ListGrid.unremoveIcon for this row. Clicking on this icon
     *   will call ListGrid.unmarkRecordRemoved to mark the record as no longer pending
     *   deletion.
     *  @type {boolean}
     *  @default false
     */
    open var canRemoveRecords: Boolean = definedExternally
    /**
     *  If ListGrid.canRemoveRecords is true, when the user clicks the remove icon
     *   for some record, should we show a warning message
     *   (defined as ListGrid.warnOnRemovalMessage) and allow the user to cancel removal?
     *  @type {boolean}
     *  @default false
     */
    open var warnOnRemoval: Boolean = definedExternally
    /**
     *  Warning message to show the user on a click on the 'remove' icon
     *   if ListGrid.canRemoveRecords is true and
     *   ListGrid.warnOnRemoval is true.
     *  @type {string}
     *  @default "Are you sure you want to delete this record?"
     */
    open var warnOnRemovalMessage: String = definedExternally
    /**
     *  Custom CSS text to be applied to records that have been
     *   ListGrid.markRecordRemoved.
     * 
     *   This CSS text will be applied on top of standard disabled styling for the cell.
     *  @type {string}
     *  @default "text-decoration:line-through;"
     */
    open var removedCSSText: String = definedExternally
    /**
     *  When enabled, the field shown by ListGrid.canRemoveRecords causes records to be
     *   marked for future removal via ListGrid.markRecordRemoved instead of immediately being
     *   removed.
     * 
     *   When a record has been marked for removal, an icon in the
     *   canRemoveRecords field allowing it to be unmarked will be displayed.
     * 
     *   If not explicitly specified by this property, removal of records will be deferred if
     *   ListGrid.autoSaveEdits is false for the grid.
     *  @type {boolean}
     *  @default null
     */
    open var deferRemoval: Boolean = definedExternally
    /**
     *  When ListGrid.canRemoveRecords is enabled, default icon to show in
     *   the auto-generated field that allows removing records.
     *  @type {SCImgURL}
     *  @default "[SKIN]/actions/remove.png"
     */
    open var removeIcon: String = definedExternally
    /**
     *  When ListGrid.canRemoveRecords is enabled, this icon will be shown in the
     *   auto generated field fro removing records if the record has been marked as removed via
     *   ListGrid.markRecordRemoved. At this point, clicking on the icon will
     *   unmark the record as removed.
     *  @type {SCImgURL}
     *  @default "[SKIN]/actions/undo.png"
     */
    open var unremoveIcon: String = definedExternally
    /**
     *  Default width and height of ListGrid.removeIcon for this ListGrid.
     *  @type {number}
     *  @default "16"
     */
    open var removeIconSize: Number = definedExternally
    /**
     *  When ListGrid.canRemoveRecords is enabled, should records be animated out of view
     *   when they are removed by the user?
     *  @type {boolean}
     *  @default true
     */
    open var animateRemoveRecord: Boolean = definedExternally
    /**
     *  When animating record removal
     *   ListGrid.animateRemoveRecord, if
     *   ListGrid.animateRemoveSpeed is not
     *   set, this property designates the duration of the animation in ms.
     *  @type {number}
     *  @default "100"
     */
    open var animateRemoveTime: Number = definedExternally
    /**
     *  When ListGrid.animateRemoveRecord, this property
     *   designates the speed of the animation in pixels per second. Takes precedence over the
     *   ListGrid.animateRemoveTime property, which allows the developer to specify a
     *   duration for the animation rather than a speed.
     *  @type {number}
     *  @default "200"
     */
    open var animateRemoveSpeed: Number = definedExternally
    /**
     *  The title to use for the ListGrid.removeFieldDefaults.
     * 
     *   By default this title is not displayed in the remove column header button as the
     *   ListGrid.removeFieldDefaults sets ListGridField.showTitle to false.
     *  @type {string}
     *  @default "&amp;nbsp;"
     */
    open var removeFieldTitle: String = definedExternally
    /**
     *  Default configuration properties for the "remove field"
     *   displayed when ListGrid.canRemoveRecords is enabled.
     *   Class.changeDefaults should be used when modifying this object.
     * 
     *   The default configuration includes a ListGridField.recordClick handler which
     *   calls ListGrid.removeData to actually perform the data removal.
     *  @type {ListGridField}
     *  @default "{...}"
     */
    open var removeFieldDefaults: ListGridField = definedExternally
    /**
     *  Configuration properties for the "remove field" displayed when
     *   ListGrid.canRemoveRecords is enabled.
     *   These configuration settings will be overlaid
     *   on top of the ListGrid.removeFieldDefaults.
     *  @type {ListGridField}
     *  @default null
     */
    open var removeFieldProperties: ListGridField = definedExternally
    /**
     *  If we're showing the filterEditor (this.showFilterEditor is true), this property
     *   determines whether this list should be filtered every time the user puts focus in
     *   a different field in the filter editor.
     *  @type {boolean}
     *  @default null
     */
    open var filterByCell: Boolean = definedExternally
    /**
     *  If we're showing the filterEditor (this.showFilterEditor is true), this property
     *   determines whether this list should be filtered every time the user modifies the value
     *   in a field of the filter-editor. Can also be set at the field level.
     *  @type {boolean}
     *  @default null
     */
    open var filterOnKeypress: Boolean = definedExternally
    /**
     *  If this is an editable listGrid, this property determines whether the user will be
     *   able to dismiss the edit form, or navigate to another cell while the save is in
     *   process (before the asynchronous server response returns).
     *  @type {boolean}
     *  @default false
     */
    open var waitForSave: Boolean = definedExternally
    /**
     *  If this is an editable listGrid, this property determines how failure to save due to
     *   validation errors should be displayed to the user.
     * 
     *   If this property is true, when validation errors occur the errors will be displayed
     *   to the user in an alert, and focus will be returned to the first cell to fail validation.
     * 
     *   If false, the cells that failed validation will be silently styled with the
     *   editFailedBaseStyle.
     * 
     *   Note: stopOnErrors being set to true implies that 'waitForSave' is also true.
     *   We will not dismiss the editor until save has completed if stopOnErrors is true.
     *  @type {boolean}
     *  @default false
     */
    open var stopOnErrors: Boolean = definedExternally
    /**
     *  If this ListGrid is editable, should edits be saved out when the user finishes editing
     *   a row (or a cell if ListGrid.saveByCell is true).
     * 
     *   The default of true indicates that edits will be
     *   ListGrid.saveByCell as the
     *   user navigates through the grid and/or ${isc.DocUtils.linkForRef('type:EnterKeyEditAction','hits \'Enter\'')} to end
     *   editing. See the editing overview for details.
     * 
     *   Setting autoSaveEdits false creates a "mass update" / "mass delete"
     *   interaction where edits will be retained for all edited cells (across rows if
     *   appropriate) until ListGrid.saveEdits is called to save a particular row, or
     *   ListGrid.saveAllEdits is called to save all changes in a batch.
     * 
     *   Note: when ListGrid.groupByField is enabled, or when
     *   working with hierarchical data in a TreeGrid, users have the option to hide
     *   records from view by collapsing the parent folder or group. This, in conjunction with
     *   autoSaveEdits being set to false can lead to a case where
     *   a user is unable to save edits due to validation errors on hidden rows. Therefore we
     *   recommend developers consider having validators in place such that errors are caught
     *   and displayed to the user on change or editor exit rather than being caught only when
     *   saving is attempted. If it's not possible for all validation to be performed immediately
     *   on row exit, we recommend that a different UI design be used that does not involve
     *   autoSaveEdits being set to false.
     *  @type {boolean}
     *  @default true
     */
    open var autoSaveEdits: Boolean = definedExternally
    /**
     *  If this grid is editable, and an edit has caused validation failure for some cell,
     *   should we show an icon to indicate validation failure?
     *  @type {boolean}
     *  @default true
     */
    open var showErrorIcons: Boolean = definedExternally
    /**
     *  Height of the error icon, if we're showing icons when validation errors occur.
     *  @type {Integer}
     *  @default "16"
     */
    open var errorIconHeight: Number = definedExternally
    /**
     *  Height of the error icon, if we're showing icons when validation errors occur.
     *  @type {Integer}
     *  @default "16"
     */
    open var errorIconWidth: Number = definedExternally
    /**
     *  Src of the image to show as an error icon, if we're showing icons when validation
     *     errors occur.
     *  @type {SCImgURL}
     *  @default "[SKIN]/ListGrid/validation_error_icon.png"
     */
    open var errorIconSrc: String = definedExternally
    /**
     *  If this is an editable listGrid, when the user attempts to cancel an edit, should we
     *   display a confirmation prompt before discarding the edited values for the record?
     *  @type {boolean}
     *  @default false
     */
    open var confirmCancelEditing: Boolean = definedExternally
    /**
     *  If this is an editable listGrid, and this.confirmCancelEditing is true
     *   this property is used as the message to display in the confirmation dismissal prompt.
     *  @type {string}
     *  @default "Cancelling this edit will discard unsaved changes for this record. Continue?"
     */
    open var cancelEditingConfirmationMessage: String = definedExternally
    /**
     *  For editable listGrids, outstanding unsaved edits when the user performs a new filter
     *   or sort will be discarded. This flag determines whether we should display a confirmation
     *   dialog with options to save or discard the edits, or cancel the action in this case.
     *  @type {boolean}
     *  @default true
     */
    open var confirmDiscardEdits: Boolean = definedExternally
    /**
     *  For editable listGrids, outstanding unsaved edits when the user performs a new filter
     *   or sort will be discarded by default. This flag determines whether we should save such
     *   edits automatically in this case. See also ListGrid.confirmDiscardEdits, which
     *   allows the user to choose whether to save or discard the unsaved edits.
     *  @type {boolean}
     *  @default false
     */
    open var autoConfirmSaveEdits: Boolean = definedExternally
    /**
     *  If this.confirmDiscardEdits is true, this property can be used to customize the
     *   error message string displayed to the user in a dialog with options to
     *   cancel the action, or save or discard pending edits in response to sort/filter actions
     *   that would otherwise drop unsaved edit values.
     *  @type {string}
     *  @default "This action will discard unsaved changes for this list."
     */
    open var confirmDiscardEditsMessage: String = definedExternally
    /**
     *  If ListGrid.confirmDiscardEdits is true this is the title for the save button
     *   appearing in the lost edits confirmation dialog. Override this for localization if necessary.
     *  @type {string}
     *  @default "Save"
     */
    open var discardEditsSaveButtonTitle: String = definedExternally
    /**
     *  If the user is editing a record in this listGrid, and attempts to navigate to a field
     *   beyond the end of the row, via tab (or shift-tab off the first editable field), this
     *   property determines what action to take:
     * 
     *  - "next": start editing the next (or previous) record in the list
     * 
     *  - "same": put focus back into the first editable field of the same record.
     * 
     *  - "done": hide the editor
     * 
     *  - "stop": leave focus in the cell being edited
     * 
     *  - "none": no action
     * 
     *  @type {RowEndEditAction}
     *  @default null
     */
    open var rowEndEditAction: 
                               /**
                                *  navigate to the first editable cell in the same record
                                *  navigate to the first editable cell in the next record
                                *  complete the edit.
                                *  Leave focus in the cell being edited (take no action)
                                *  take no action
                                */
                               String /* same |  next |  done |  stop |  none */ = definedExternally
    /**
     *  If the user is editing the last record in this listGrid, and attempts to navigate
     *   beyond the last row either by tabbing off the last editable field, or using the down
     *   arrow key, this property determines what action to take:
     * 
     *  - "next": start editing a new record at the end of the list.
     * 
     *  - "done": hide the editor
     * 
     *  - "stop": leave focus in the cell being edited
     * 
     *  - "none": no action
     * 
     * 
     *   See the editing and also the
     *   unsavedRecords for context about how newly
     *   added records behave.
     *  @type {RowEndEditAction}
     *  @default null
     */
    open var listEndEditAction: 
                                /**
                                 *  navigate to the first editable cell in the same record
                                 *  navigate to the first editable cell in the next record
                                 *  complete the edit.
                                 *  Leave focus in the cell being edited (take no action)
                                 *  take no action
                                 */
                                String /* same |  next |  done |  stop |  none */ = definedExternally
    /**
     *  What to do when a user hits enter while editing a cell:
     * 
     * 
     *  - "nextCell": start editing the next editable cell in this record (or the first
     *     editable cell in the next record if focus is in the last editable cell in the row)
     * 
     *  - "nextRow": start editing the same field in the next row (skipping any rows where
     *     that would be a non-editable cell.
     * 
     *  - "nextRowStart": start editing the first editable cell in the next row.
     * 
     *  - "done": hide the editor (editing is complete)
     * 
     *   Note that if this.autoSaveEdits is true, this may cause a save of the current edit values
     *  @type {EnterKeyEditAction}
     *  @default "done"
     */
    open var enterKeyEditAction: 
                                 /**
                                  *  end editing (will save edit values if ListGrid.autoSaveEdits is true).
                                  *  edit the next editable cell in the record
                                  *  edit the same field in the next editable record
                                  *  edit the first editable cell in next editable record
                                  */
                                 String /* done |  nextCell |  nextRow |  nextRowStart */ = definedExternally
    /**
     *  What to do when a user hits escape while editing a cell:
     * 
     *  - "cancel": close the editor and discard the current set of edit values
     * 
     *  - "done": just close the editor (the edit is complete, but the edited values are retained).
     * 
     *   Note that if ListGrid.autoSaveEdits is true, this may cause a save of the current edit values
     *  @type {EscapeKeyEditAction}
     *  @default "cancel"
     */
    open var escapeKeyEditAction: 
                                  /**
                                   *  cancels the current edit and discards edit values
                                   *  end editing (will save edit values if ListGrid.autoSaveEdits is true).
                                   *  exit the editor (edit values will be left intact but not saved).
                                   *  do nothing special when the Escape key is pressed (ie, just ignore it)
                                   */
                                  String /* cancel |  done |  exit |  ignore */ = definedExternally
    /**
     *  Event that will trigger inline editing, see ListGridEditEvent for options.
     * 
     *   Note this setting has no effect unless ListGrid.canEdit has been set to enable editing.
     * 
     *   See also ListGrid.editOnFocus and ListGrid.startEditing.
     *  @type {ListGridEditEvent}
     *  @default "doubleClick"
     */
    open var editEvent: 
                        /**
                         *  A single mouse click triggers inline editing
                         *  A double click triggers inline editing
                         *  No mouse event will trigger editing. Editing must be           programmatically started via ListGrid.startEditing
                         *             (perhaps from an external button) or may be triggered by
                         *             keyboard navigation if ListGrid.editOnFocus is set.
                         */
                        String /* click |  doubleClick |  none */ = definedExternally
    /**
     *  Should we start editing when this widget receives focus (if this ListGrid supports
     *   editing)?
     * 
     *   Note that this property being set to true will cause editing to occur on a single
     *   click, even if ListGrid.editEvent is "doubleClick", because single clicking
     *   the grid will place keyboard focus there automatically.
     * 
     *   If this property is set together with ListGrid.listEndEditAction being set to "next",
     *   users can create a new edit row in an empty grid by simply tabbing into the grid.
     *  @type {boolean}
     *  @default null
     */
    open var editOnFocus: Boolean = definedExternally
    /**
     *  Should we start editing when the widget has focus and the user presses the "f2" key
     *   (if this ListGrid supports editing)?
     * 
     *   Note that if ListGrid.editEvent is set to "click" or
     *   "doubleClick", the Space or Enter key may
     *   also be used to start editing, depending on the value for ListGrid.generateClickOnSpace,
     *   ListGrid.generateDoubleClickOnSpace, ListGrid.generateClickOnEnter and
     *   ListGrid.generateDoubleClickOnEnter.
     * 
     *   If ListGrid.canEdit is false, or ListGrid.editEvent is set to "none" this
     *   property has no effect.
     *  @type {boolean}
     *  @default true
     */
    open var editOnF2Keypress: Boolean = definedExternally
    /**
     *  When the user starts editing a row, should the row also be selected?
     * 
     *   See ListGrid.editSelectionType for how edit-selection behaves.
     *  @type {boolean}
     *  @default true
     */
    open var selectOnEdit: Boolean = definedExternally
    /**
     *  If ListGrid.selectOnEdit is true, what should be the edit-selection behavior
     *   be?
     * 
     *   Default setting of "single" will cause the edit row to be automatically
     *   selected and any other selection in the grid to be dropped.
     *   If set to "multiple", selection will be additive (as a record goes
     *   into edit mode, it is selected in addition to any pre-existant selection).
     * 
     *   If set to null behavior is as follows:
     * 
     *  - For grids with ListGrid.selectionType set to
     *   "simple" edit rows will be selected additively - this is the same
     *   behavior as if the editSelectionType was "multiple"
     * 
     *  - Otherwise edit rows will be selected singly - this is the same behavior as
     *   if the editSelectionType was "single"
     * 
     *  @type {SelectionStyle}
     *  @default "single"
     */
    open var editSelectionType: 
                                /**
                                 *  don't select at all
                                 *  select only one item at a time
                                 *  select one or more items
                                 *  select one or more items as a toggle      so you don't need to hold down control keys to select
                                 *                   more than one object
                                 */
                                String /* none |  single |  multiple |  simple */ = definedExternally
    /**
     *  In a ListGrid that has a DataSource and has filter criteria that include values for
     *   fields declared as FieldType in the DataSource, by default a newly
     *   edited row will use those filter criteria as initial values.
     * 
     *   For example, if a ListGrid is showing all Accounts that have status:"Active" and a new row
     *   is created, the new row will default to status:"Active" unless this flag is set to false.
     *  @type {boolean}
     *  @default true
     */
    open var enumCriteriaAsInitialValues: Boolean = definedExternally
    /**
     *  Whether to do inline autoComplete in text fields during inline editing
     *   Overridden by ListGridField.autoComplete if specified.
     *   If unset picks up the default from the appropriate editor class (subclass of FormItem).
     *  @type {AutoComplete}
     *  @default null
     */
    open var autoComplete: 
                           /**
                            *  Disable browser autoComplete. Note that some browsers will disregard  this setting and still perform native autoComplete for certain items - typically
                            *    only for log in / password forms. See the discussion FormItem.autoComplete.
                            *  Allow native browser autoComplete.
                            */
                           String /* none |  native */ = definedExternally
    /**
     *  When the length of the field specified by DataSourceField.length exceeds this
     *   value, the ListGrid shows an edit field of type ListGrid.longTextEditorType
     *   rather than the standard text field when the field enters inline edit mode.
     *  @type {Integer}
     *  @default "255"
     */
    open var longTextEditorThreshold: Number = definedExternally
    /**
     *  When the length of the field specified by DataSourceField.length exceeds
     *   this.longTextEditorThreshold show an edit field of this type
     *   rather than the standard text field when the field enters inline edit mode.
     *  @type {string}
     *  @default "PopUpTextAreaItem"
     */
    open var longTextEditorType: String = definedExternally
    /**
     *  A Toolbar used to manager the headers shown for each column of the grid.
     *  @type {Layout}
     *  @default null
     */
    open var header: Layout = definedExternally
    /**
     *  The context menu displayed for column headers.
     *  @type {Canvas}
     *  @default null
     */
    open var headerContextMenu: Canvas = definedExternally
    /**
     *  The menu displayed when a cell is right clicked on.
     *  @type {Layout}
     *  @default null
     */
    open var cellContextMenu: Layout = definedExternally
    /**
     *  The menu displayed when a cell is right clicked on.
     *  @type {Layout}
     *  @default null
     */
    open var spanContextMenu: Layout = definedExternally
    /**
     *  Should the header be included in the tab-order for the page? If not explicitly specified,
     *   the header will be included in the tab order for the page if
     *   isc.setScreenReaderMode
     * 
     *   is called.
     *  @type {boolean}
     *  @default null
     */
    open var canTabToHeader: Boolean = definedExternally
    /**
     *  The height of this listGrid's header, in pixels.
     *  @type {number}
     *  @default "22"
     */
    open var headerHeight: Number = definedExternally
    /**
     *  Minimum size, in pixels, for ListGrid headers.
     *  @type {Integer}
     *  @default "15"
     */
    open var minFieldWidth: Number = definedExternally
    /**
     *  Should we show the header for this ListGrid?
     *  @type {boolean}
     *  @default true
     */
    open var showHeader: Boolean = definedExternally
    /**
     *  Set the CSS style used for the header as a whole.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var headerBarStyle: String = definedExternally
    /**
     *  BackgroundColor for the header toolbar. Typically this is set to match the color
     *   of the header buttons.
     *  @type {CSSColor}
     *  @default "#CCCCCC"
     */
    open var headerBackgroundColor: String = definedExternally
    /**
     *  Should the header show a drop-shadow?
     *   Shadow will be applied to the header, or for a grid with frozen columns, the
     *   header layout.
     * 
     *   Header shadow will only be displayed if Canvas.useCSSShadow are
     *   being used.
     *  @type {boolean}
     *  @default false
     */
    open var showHeaderShadow: Boolean = definedExternally
    /**
     *  If ListGrid.showHeaderShadow is true, the Canvas.shadowVOffset for
     *   the header shadow
     *  @type {number}
     *  @default "1"
     */
    open var headerShadowVOffset: Number = definedExternally
    /**
     *  If ListGrid.showHeaderShadow is true, the Canvas.shadowHOffset for
     *   the header shadow
     *  @type {number}
     *  @default "0"
     */
    open var headerShadowHOffset: Number = definedExternally
    /**
     *  If ListGrid.showHeaderShadow is true, the Canvas.shadowSoftness for
     *   the header shadow
     *  @type {number}
     *  @default "1"
     */
    open var headerShadowSoftness: Number = definedExternally
    /**
     *  If ListGrid.showHeaderShadow is true, the Canvas.shadowColor for
     *   the header shadow.
     *  @type {CSSColor}
     *  @default null
     */
    open var headerShadowColor: String = definedExternally
    /**
     *  Widget class for this ListGrid's header buttons. If unset, constructor will be
     *   picked up directly from the standard Toolbar button constructor.
     *  @type {Class}
     *  @default null
     */
    open var headerButtonConstructor: Class = definedExternally
    /**
     *  Button.baseStyle to apply to the buttons in the header, and the sorter, for
     *   this ListGrid.
     *   Note that, depending on the ListGrid.headerButtonConstructor of the header
     *   buttons, you may also need to set ListGrid.headerTitleStyle.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var headerBaseStyle: String = definedExternally
    /**
     *  StretchImgButton.titleStyle to apply to the buttons in the header, and the sorter,
     *   for this ListGrid.
     *   Note that this will typically only have an effect if
     *   ListGrid.headerButtonConstructor is set to StretchImgButton or a subclass
     *   thereof.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var headerTitleStyle: String = definedExternally
    /**
     *  If this listGrid contains any frozen fields, this property can be used to apply a custom
     *   headerBaseStyle to the frozen set of fields. If unset, the standard headerBaseStyle
     *   will be used for both frozen and unfrozen cells.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var frozenHeaderBaseStyle: String = definedExternally
    /**
     *  If this listGrid contains any frozen fields, this property can be used to apply a custom
     *   headerTitleStyle to the frozen set of fields. If unset, the standard headerTitleStyle
     *   will be used for both frozen and unfrozen cells.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var frozenHeaderTitleStyle: String = definedExternally
    /**
     *  Defaults to apply to all header buttons. To modify this object,
     *   use Class.changeDefaults
     *   rather than replacing with an entirely new object.
     *  @type {Button}
     *  @default "{...}"
     */
    open var headerButtonDefaults: Button = definedExternally
    /**
     *  Properties to apply to all header buttons.
     *   Overrides defaults applied via ListGrid.headerButtonDefaults.
     *  @type {Button}
     *  @default null
     */
    open var headerButtonProperties: Button = definedExternally
    /**
     *  Whether the ListGrid should manage the clipping of titles of header buttons, showing
     *   ellipses if the title is clipped, and potentially showing the full title
     *   on ListGrid.showClippedHeaderTitlesOnHover.
     * 
     *   In some cases this may be preferable to the button component's default clipping behavior
     *   because if a ListGrid.showSortArrow or sort numeral is displayed for
     *   a header, then the button's default clipping behavior may clip the sort arrow/numeral
     *   whereas ListGrid-managed title clipping utilizes special HTML which keeps the sort
     *   arrow/numeral visible.
     * 
     *   This feature is automatically enabled if supported by the browser. The only supported
     *   use of this attribute is to disable the feature by setting clipHeaderTitles
     *   to false.
     * 
     *   Note that this feature is incompatible with ListGridField.wrap, and will
     *   automatically be disabled for wrapping fields.
     *  @type {boolean}
     *  @default "varies"
     */
    open var clipHeaderTitles: Boolean = definedExternally
    /**
     *  If ListGridField.wrap is not explicitly set, should fields wrap? If autofitting,
     *   see the docs on that property for the details of how the minimum width for a field is
     *   determined.
     *  @type {boolean}
     *  @default null
     */
    open var wrapHeaderTitles: Boolean = definedExternally
    /**
     *  If HeaderSpan.wrap is not explicitly set, should fields wrap? If autofitting,
     *   see the docs on that property for the details of how the minimum width for a field is
     *   determined.
     *  @type {boolean}
     *  @default null
     */
    open var wrapHeaderSpanTitles: Boolean = definedExternally
    /**
     *  Widget class for the corner sort button, if showing. This button displays the current
     *   sort direction of the primary sort field (either the only sorted field or the first in a
     *   ListGrid.canMultiSort grid) and reverses the direction of that field
     *   when clicked. For consistent appearance, this
     *   is usually set to match ListGrid.headerButtonConstructor
     *  @type {Class}
     *  @default "Button"
     */
    open var sorterConstructor: Class = definedExternally
    /**
     *  The title for the corner sort button. The title will only
     *   Class.changeDefaults rather than replacing with an
     *   entirely new object.
     *  @type {string}
     *  @default "corner menu"
     */
    open var sorterButtonTitle: String = definedExternally
    /**
     *  Defaults to apply to the corner sort button. To modify this object, use
     *   Class.changeDefaults rather than replacing with an
     *   entirely new object.
     *  @type {object}
     *  @default "{...}"
     */
    open var sorterDefaults: dynamic = definedExternally
    /**
     *  Properties to apply to the sorter button. Overrides defaults applied via
     *   ListGrid.sorterDefaults.
     *  @type {Button}
     *  @default null
     */
    open var sorterProperties: Button = definedExternally
    /**
     *  If set, whenever grouping is performed by an end user or by a programmatic call to
     *   ListGrid.groupBy, data is implicitly sorted by all of the grouped columns, in the order
     *   they were passed to groupBy. Any user-configured sorting is applied after sorting by
     *   grouped columns.
     * 
     *   Sorting by grouped fields will be in ascending or descending order according to whether
     *   the grid is currently sorted (by any field) in ascending or descending order, defaulting
     *   to ascending if the grid is not sorted. Implicit sorting by group can be forced to be
     *   always ascending or always descending by setting ListGrid.groupSortDirection.
     * 
     *   The sorting is "implicit" in the sense that the sorting is not shown in the ListGrid
     *   headers, and not shown in the MultiSortDialog if enabled. An end user cannot
     *   currently remove the implicit sorting themselves (except by removing the grouping),
     *   though it is possible to override it by providing an explicit sort on the group's column.
     *   Clicking on the grouped field's header reveals the usual sort indicators with all
     *   the same semantics.
     * 
     *   The correct way to remove implicit sorting programmatically is to call
     *   ListGrid.setSortByGroupFirst.
     * 
     *   Programmatic calls to ListGrid.getSort will not include the implicit sort in
     *   the list of return sort specifiers, and calls to ListGrid.setSort will implicitly add
     *   the sorting by grouped columns before the specified sort.
     * 
     *   Note that directly calling ResultSet.getSort() will include the implicit sort
     *   information.
     *  @type {boolean}
     *  @default null
     */
    open var sortByGroupFirst: Boolean = definedExternally
    /**
     *  When ListGrid.sortByGroupFirst is active, the sorting direction applied for implicit
     *   sorting by the field(s) used for grouping. Default of null means that sort direction
     *   is based on the current direction of user-configured sort, or is "ascending" if the
     *   user has not sorted the data.
     *  @type {SortDirection}
     *  @default null
     */
    open var groupSortDirection: 
                                 /**
                                  *  Sort in ascending order (eg: A-Z, larger items later in the list)
                                  *  Sort in descending order (eg: Z-A, larger items earlier in the list)
                                  */
                                 String /* ascending |  descending */ = definedExternally
    /**
     *  For any fields of FieldType, should sorting be performed
     *   against the fileName of the value for the field? For SmartClient server backed
     *   dataSources, this is applied to the record automatically as described in the
     *   binaryFields overview.
     * 
     *   If set to false, binary fields will be sorted against the record value for the
     *   field in question. Client-side sorting does not support this, so developers who
     *   actually want to support a sort against the binary itself would typically set
     *   ResultSet.useClientSorting to false on the ListGrid.dataProperties block for
     *   this grid.
     * 
     *   Note that this setting will have no effect if DataSourceField.sortByField is
     *   specified
     *  @type {boolean}
     *  @default true
     */
    open var sortBinaryByFileName: Boolean = definedExternally
    /**
     *  Enables or disables interactive sorting behavior for this listGrid. Does not
     *   affect sorting by direct calls to the ListGrid.sort or
     *   ListGrid.setSort methods.
     *  @type {boolean}
     *  @default true
     */
    open var canSort: Boolean = definedExternally
    /**
     *  If true, show the field-header for the sorted field (or the first field in a
     *   ListGrid.canMultiSort grid) in the selected state.
     *  @type {boolean}
     *  @default true
     */
    open var selectHeaderOnSort: Boolean = definedExternally
    /**
     *  Specifies the number of the field by which to sort this listGrid. Column numbers
     *   start at 0 for the left-most column.
     *  @deprecated \* as of version 7.0 in favor of ListGrid.sortField
     *  @type {number}
     *  @default null
     */
    open var sortFieldNum: Number = definedExternally
    /**
     *  Specifies the field by which this grid should be initially sorted. Can be set to either a
     *   ListGridField.name or the index of the field in the fields Array.
     * 
     *   ListGrids also support being initialized with multiple-field sort via
     *   ListGrid.initialSort. If initialSort is specified, it will be used in preference
     *   to this property.
     * 
     *   To sort the grid after it has been initialized, use ListGrid.sort or
     *   ListGrid.setSort. Details about the current sort of a live grid can be
     *   retrieved by calling ListGrid.getSortField or ListGrid.getSort
     *  @type {string | Integer}
     *  @default null
     */
    open var sortField: dynamic = definedExternally
    /**
     *  Sorting direction of this ListGrid. If specified when the ListGrid is initialized,
     *   this property will be the default sorting direction for the ListGrid.sortField.
     *   May be overridden by specifying ListGridField.sortDirection.
     * 
     *   After initialization, this property will be updated on ListGrid.sort or
     *   ListGrid.setSort to reflect the current sort direction of the grid. When
     *   this grid is sorted by multiple fields, the grid's sortDirection reflects the
     *   sort direction of the primary sort field.
     *  @type {SortDirection}
     *  @default "ascending"
     */
    open var sortDirection: 
                            /**
                             *  Sort in ascending order (eg: A-Z, larger items later in the list)
                             *  Sort in descending order (eg: Z-A, larger items earlier in the list)
                             */
                            String /* ascending |  descending */ = definedExternally
    /**
     *  Indicates whether a sorting arrow should appear for the listGrid, and its
     *   location. See SortArrow for details.
     * 
     *   Clicking the sort arrow reverses the direction of sorting for the current sort
     *   column (if any), or sorts the listGrid by its first sortable column. The arrow
     *   image on the button indicates the current direction of sorting.
     *   If undefined, the sort arrow will show up in the sorted field, and the
     *   corner sort button will be displayed if a vertical scrollbar is being displayed
     *  @type {SortArrow}
     *  @default null
     */
    open var showSortArrow: 
                            /**
                             *  Don't show a sort arrow at all.
                             *  Display sort arrow in the upper-right corner (above the scrollbar) only.
                             *  Display sort arrow above each field header only.
                             *  Display sort arrow above each field header AND in corner above scrollbar.BOTH:"both", // NOTE: Canvas establishes this constant
                             */
                            String /* none |  corner |  field |  both */ = definedExternally
    /**
     *  When ListGrid.leaveHeaderMenuButtonSpace is true, configures the amount of space beyond the
     *   ListGrid.headerMenuButtonWidth on the right side of a ListGrid header button (left for
     *   Page.isRTL) to reserve for the sort arrow if sorting is active for
     *   that field and the arrow will be shown. May be increased for more separation between
     *   the sort arrow and the title text, at the expense of a reduced space for the title text.
     * 
     *   This value may need to be customized in your skin or if ListGrid.sortAscendingImage or
     *   ListGrid.sortDescendingImage are changed.
     *  @type {Integer}
     *  @default "7"
     */
    open var sortArrowMenuButtonSpaceOffset: Number = definedExternally
    /**
     *  When ListGrid.leaveHeaderMenuButtonSpace is true, configures the amount of space beyond the
     *   ListGrid.headerMenuButtonWidth on the right side of a ListGrid header button (left for
     *   Page.isRTL) to reserve for the sort numeral if
     *   ListGrid.canMultiSort is active for that field and the numeral will be shown.
     *   May be increased for more separation between the title text and the sort arrow when
     *   multi-sorting.
     * 
     *   Note that larger values may required if 10 or more fields are sorted at once, as the
     *   numeral will occupy more space. This value may need to be customized in your skin or if
     *   ListGrid.sortAscendingImage or ListGrid.sortDescendingImage are changed.
     *  @type {Integer}
     *  @default "9"
     */
    open var sortNumeralMenuButtonSpaceOffset: Number = definedExternally
    /**
     *  Indicates whether the field picker item and submenu should be present in the header
     *   context menu. This menu allows the user to hide visible fields and show hidden fields.
     * 
     *   By default only fields explicitly included in the ListGrid.fields array will
     *   be available in this menu, unless ListGrid.canPickOmittedFields is set to true for
     *   a databound grid.
     * 
     *   A specific field can be omitted from the column picker via ListGridField.canHide.
     *  @type {boolean}
     *  @default true
     */
    open var canPickFields: Boolean = definedExternally
    /**
     *  If this grid has a specified ListGrid.dataSource, and
     *   ListGrid.useAllDataSourceFields is false, setting this property to true
     *   will cause all dataSource fields not included in the specified set of fields to
     *   show up in the ListGrid.canPickFields.
     * 
     *   Has no effect if ListGrid.fields is unset (as in this case all dataSource fields
     *   will be displayed by default), or if ListGrid.canPickFields is false.
     *  @type {boolean}
     *  @default false
     */
    open var canPickOmittedFields: Boolean = definedExternally
    /**
     *  Whether an interface should be shown to allow user is allowed to dynamically "freeze" or
     *   "unfreeze" columns with respect to horizontally scrolling. If unset, this property defaults
     *   to true unless:
     * 
     *  - ListGrid.fixedRecordHeights is false
     * 
     *  - ListGrid.bodyOverflow is "visible"
     * 
     *  - ListGrid.autoFitData is set to "horizontal" or
     *   "both"
     * 
     *  - Any field has overflow set to "visible"
     * 
     *   Note that the canFreezeFields setting enables or disables the user
     *   interface for freezing and unfreezing fields only. Fields can be programmatically
     *   frozen via setting ListGridField.frozen to true when the grid is
     *   created, or dynamically frozen and unfrozen via ListGrid.freezeField and
     *   ListGrid.unfreezeField.
     *  @type {boolean}
     *  @default null
     */
    open var canFreezeFields: Boolean = definedExternally
    /**
     *  If the result of a formula evaluation is invalid (specifically, if isNaN(result)==true),
     *   badFormulaResultValue is displayed instead. The default value is ".".
     *  @type {string}
     *  @default "."
     */
    override var badFormulaResultValue: String = definedExternally
    /**
     *  If a summary format string contains an invalid field reference, replace the reference
     *   with the missingSummaryFieldValue. The default value is "-".
     *  @type {string}
     *  @default "-"
     */
    override var missingSummaryFieldValue: String = definedExternally
    /**
     *  Adds an item to the header context menu allowing users to launch a dialog to define a new
     *   field based on values present in other fields, using the FormulaBuilder.
     * 
     *   User-added formula fields can be persisted via ListGrid.getFieldState and
     *   ListGrid.setFieldState.
     *  @type {boolean}
     *  @default false
     */
    override var canAddFormulaFields: Boolean = definedExternally
    /**
     *  Adds an item to the header context menu allowing users to launch a dialog to define a new
     *   text field that can contain both user-defined text and the formatted values present in other
     *   fields, using the SummaryBuilder.
     * 
     *   User-added summary fields can be persisted via ListGrid.getFieldState and
     *   ListGrid.setFieldState.
     *  @type {boolean}
     *  @default false
     */
    override var canAddSummaryFields: Boolean = definedExternally
    /**
     *  Adds an item to the header context menu allowing users to launch a dialog to define
     *   grid hilites using the HiliteEditor.
     * 
     *   User-added hilites can be persisted via DataBoundComponent.getHiliteState and
     *   DataBoundComponent.setHiliteState.
     *  @type {boolean}
     *  @default false
     */
    override var canEditHilites: Boolean = definedExternally
    /**
     *  Whether to show a context menu with standard items for all context clicks on rows in the
     *   body.
     *  @type {boolean}
     *  @default false
     */
    open var showCellContextMenus: Boolean = definedExternally
    /**
     *  Whether to show a context menu on the header with standard items for showing and hiding
     *   fields. Not supported for CubeGrid.
     *  @type {boolean}
     *  @default true
     */
    open var showHeaderContextMenu: Boolean = definedExternally
    /**
     *  If set to true and ListGrid.showHeaderContextMenu is true, the
     *   ListGrid.headerMenuButton will be displayed when the user rolls
     *   over the header buttons in this grid. Not supported for CubeGrid.
     *  @type {boolean}
     *  @default true
     */
    open var showHeaderMenuButton: Boolean = definedExternally
    /**
     *  If ListGrid.showHeaderMenuButton is true, when auto-fitting fields to
     *   the title width via ListGrid.autoFitFieldWidths or ListGridField.autoFitWidth,
     *   should the button be sized such that there is enough space for the header menu button to
     *   show without covering the field title?
     * 
     *   May be explicitly specified at the ListGridField.leaveHeaderMenuButtonSpace
     *   or at the ListGrid.leaveHeaderMenuButtonSpace. If not explicitly
     *   specified space will be left for fields with
     *   ListGridField.align set to "left" or "right", but not for
     *   fields with align set to "center".
     *  @type {boolean}
     *  @default null
     */
    open var leaveHeaderMenuButtonSpace: Boolean = definedExternally
    /**
     *  Constructor for the ListGrid.headerMenuButton. If unset a standard "Button" will
     *   be rendered out. Note that this property may be overridden by different skins.
     *  @type {string}
     *  @default null
     */
    open var headerMenuButtonConstructor: String = definedExternally
    /**
     *  If ListGrid.showHeaderMenuButton is true, when the user rolls over the header buttons in this
     *   grid the headerMenuButton will be shown over the header button in question. When clicked
     *   this button will display the standard header context menu (see
     *   ListGrid.displayHeaderContextMenu).
     * 
     *   headerMenuButton exist to customize the appearance of the
     *   headerMenuButton. Also see the AutoChild documentation for information on how
     *   to make free-form modifications to autoChild widgets
     *  @type {StatefulCanvas}
     *  @default null
     */
    open var headerMenuButton: StatefulCanvas = definedExternally
    /**
     *  If ListGrid.showHeaderMenuButton is true, this property governs the icon shown on the
     *   auto-generated headerMenuButton
     *  @type {URL}
     *  @default "[SKIN]/ListGrid/headerMenuButton_icon.gif"
     */
    open var headerMenuButtonIcon: String = definedExternally
    /**
     *  If ListGrid.showHeaderMenuButton is true, this property governs the width of the icon
     *   shown on the auto-generated headerMenuButton
     *  @type {number}
     *  @default "7"
     */
    open var headerMenuButtonIconWidth: Number = definedExternally
    /**
     *  If ListGrid.showHeaderMenuButton is true, this property governs the height of the icon
     *   shown on the auto-generated headerMenuButton
     *  @type {number}
     *  @default "7"
     */
    open var headerMenuButtonIconHeight: Number = definedExternally
    /**
     *  If ListGrid.showHeaderMenuButton is true, this property governs the width of the
     *   auto-generated headerMenuButton
     *  @type {number}
     *  @default "16"
     */
    open var headerMenuButtonWidth: Number = definedExternally
    /**
     *  If ListGrid.showHeaderMenuButton is true, this property governs the height of the
     *   auto-generated headerMenuButton
     *  @type {any}
     *  @default "100%"
     */
    open var headerMenuButtonHeight: dynamic = definedExternally
    /**
     *  Indicates whether records can be dragged from this listGrid and dropped elsewhere.
     * 
     *   NOTE: If canDragRecordsOut is initially enabled or might be
     *   dynamically enabled after the grid is created, it may be desirable to disable
     *   Canvas.useTouchScrolling so that touch-dragging a record starts
     *   a drag operation rather than a scroll. If Canvas.disableTouchScrollingForDrag
     *   is set to true, then touch scrolling will be disabled automatically. However,
     *   for accessibility reasons, it is recommended to leave touch
     *   scrolling enabled and provide an alternative set of controls that can be used to perform
     *   drag and drop of records out of the grid.
     *  @type {boolean}
     *  @default false
     */
    open var canDragRecordsOut: Boolean = definedExternally
    /**
     *  Indicates whether records can be dropped into this listGrid.
     *  @type {boolean}
     *  @default false
     */
    open var canAcceptDroppedRecords: Boolean = definedExternally
    /**
     *  Indicates whether records can be reordered by dragging within this ListGrid.
     * 
     *   NOTE: If canReorderRecords is initially enabled or might be
     *   ListGrid.setCanReorderRecords after the grid is created,
     *   it may be desirable to disable Canvas.useTouchScrolling
     *   so that touch-dragging a record starts a reorder operation rather than a scroll. If
     *   Canvas.disableTouchScrollingForDrag is set to true, then touch
     *   scrolling will be disabled automatically. However, for accessibility
     *   reasons, it is recommended to leave touch scrolling enabled and provide an alternative
     *   set of controls that can be used to perform drag-reordering of records.
     *  @type {boolean}
     *  @default false
     */
    open var canReorderRecords: Boolean = definedExternally
    /**
     *  Indicates whether fields in this listGrid can be reordered by dragging and
     *   dropping header fields.
     *  @type {boolean}
     *  @default true
     */
    open var canReorderFields: Boolean = definedExternally
    /**
     *  Indicates whether fields in this listGrid can be resized by dragging header
     *   fields.
     *  @type {boolean}
     *  @default true
     */
    open var canResizeFields: Boolean = definedExternally
    /**
     *  When records are being dragged from within a ListGrid, what sort of drag-tracker
     *   should be displayed?
     *   Note that if multiple records are being dragged the displayed tracker will be
     *   based on the first selected record.
     *  @type {DragTrackerMode}
     *  @default "icon"
     */
    open var dragTrackerMode: 
                              /**
                               *  Don't display a drag tracker at all
                               *  Display an icon to represent the record(s) being dragged. Icon src is       derived from ListGrid.getDragTrackerIcon
                               *  Display a title for the record being dragged. Title derived from       ListGrid.getDragTrackerTitle
                               *  Display the entire record being dragged
                               */
                              String /* none |  icon |  title |  record */ = definedExternally
    /**
     *  If true, the grid contents are redrawn in real time as fields are resized.
     *   This can be slow with a large grid and/or on some platforms. By default, this is enabled
     *   in modern desktop browsers. This is automatically switched off in mobile browsers.
     *  @type {boolean}
     *  @default "see below"
     */
    open var resizeFieldsInRealTime: Boolean = definedExternally
    /**
     *  Indicates what to do with data dragged into another DataBoundComponent. See
     *   DragDataAction type for details.
     *  @type {DragDataAction}
     *  @default "move"
     */
    override var dragDataAction: 
                                 /**
                                  *  Don't do anything, resulting in the same data being in both lists.
                                  *  Copy the data leaving the original in our list.
                                  *  Remove the data from this list so it can be moved into the other list.
                                  */
                                 String /* none |  copy |  move */ = definedExternally
    /**
     *  Where do 'skin' images (those provided with the class) live?
     *  @type {SCImgURL}
     *  @default "images/ListGrid/"
     */
    override var skinImgDir: String = definedExternally
    /**
     *  Image to show when sorting ascending. See ImgProperties for format.
     *  @type {ImgProperties}
     *  @default "{...}"
     */
    open var sortAscendingImage: ImgProperties = definedExternally
    /**
     *  Image to show when sorting descending. See ImgProperties for format.
     *  @type {ImgProperties}
     *  @default "{...}"
     */
    open var sortDescendingImage: ImgProperties = definedExternally
    /**
     *  Default image to use for the dragTracker when things are dragged within or out of this
     *   list. See ImgProperties for format.
     *  @type {ImgProperties}
     *  @default "{...}"
     */
    open var trackerImage: ImgProperties = definedExternally
    /**
     *  An optional CSS style to apply to the checkbox image. If supplied, and the checkbox is
     *   enabled, the base style is suffixed with "True", "False", or "Partial" if the checkbox
     *   is selected, unselected, or partially selected; if the checkbox is disabled, the suffix
     *   is "TrueDisabled", "FalseDisabled", or "PartialDisabled".
     * 
     *   NOTE: This attribute is not supported by TreeGrid.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var booleanBaseStyle: String = definedExternally
    /**
     *  If set, the ListGrid.booleanBaseStyle to use when printing.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var printBooleanBaseStyle: String = definedExternally
    /**
     *  Image to display for a true value in a boolean field. The special value "blank" means
     *   that no image will be shown.
     * 
     *   To turn this off explicitly set ListGridField.suppressValueIcon to true.
     * 
     *   If this, ListGrid.booleanFalseImage and ListGrid.booleanPartialImage
     *   are unset, this will be set to the default CheckboxItem.checkedImage.
     * 
     *   skinning can be used for this image, by setting this property to
     *   a SCSpriteConfig formatted string. Alternatively developers can
     *   omit this property and instead use CSS directly in the
     *   ListGrid.booleanBaseStyle property to provide a "boolean true" appearance.
     *  @type {SCImgURL}
     *  @default null
     */
    open var booleanTrueImage: String = definedExternally
    /**
     *  Image to display for a false value in a boolean field. Default null value
     *   or the special value "blank" means no image will be displayed.
     * 
     *   To turn this off explicitly set ListGridField.suppressValueIcon to true
     * 
     *   If this, ListGrid.booleanTrueImage and ListGrid.booleanPartialImage
     *   are unset, this will be set to the default CheckboxItem.uncheckedImage.
     * 
     * 
     *   skinning can be used for this image, by setting this property to
     *   a SCSpriteConfig formatted string. Alternatively developers can
     *   omit this property and instead use CSS directly in the
     *   ListGrid.booleanBaseStyle property to provide a "boolean false" appearance.
     *  @type {SCImgURL}
     *  @default null
     */
    open var booleanFalseImage: String = definedExternally
    /**
     *  Image to display for a partially true value in a boolean field (typically selection).
     *   The special value "blank" means that no image will be shown.
     * 
     *   To turn this off explicitly set ListGridField.suppressValueIcon to true.
     * 
     *   If this, ListGrid.booleanTrueImage and ListGrid.booleanFalseImage
     *   are unset, this will be set to the default CheckboxItem.partialSelectedImage.
     * 
     *   skinning can be used for this image, by setting this property to
     *   a SCSpriteConfig formatted string. Alternatively developers can
     *   omit this property and instead use CSS directly in the
     *   ListGrid.booleanBaseStyle property to provide a "boolean true" appearance.
     *  @type {SCImgURL}
     *  @default null
     */
    open var booleanPartialImage: String = definedExternally
    /**
     *  If set, the ListGrid.booleanTrueImage to use when printing.
     * 
     *   If this, ListGrid.printBooleanFalseImage and ListGrid.printBooleanPartialImage
     *   are unset, this will be set to the default CheckboxItem.printCheckedImage.
     *  @type {SCImgURL}
     *  @default null
     */
    open var printBooleanTrueImage: String = definedExternally
    /**
     *  If set, the ListGrid.booleanFalseImage to use when printing.
     * 
     *   If this, ListGrid.printBooleanTrueImage and ListGrid.printBooleanPartialImage
     *   are unset, this will be set to the default CheckboxItem.printUncheckedImage.
     *  @type {SCImgURL}
     *  @default null
     */
    open var printBooleanFalseImage: String = definedExternally
    /**
     *  If set, the ListGrid.booleanPartialImage to use when printing.
     * 
     *   If this, ListGrid.printBooleanTrueImage and ListGrid.printBooleanFalseImage
     *   are unset, this will be set to the default CheckboxItem.printPartialSelectedImage.
     *  @type {SCImgURL}
     *  @default null
     */
    open var printBooleanPartialImage: String = definedExternally
    /**
     *  Width for the ListGrid.booleanTrueImage, ListGrid.booleanFalseImage
     *   and ListGrid.booleanPartialImage.
     *   Note: If ListGrid.booleanTrueImage is unset, the CheckboxItem.checkedImage
     *   will be used to indicate a true value in a boolean field. In this case this property is
     *   ignored in favor of CheckboxItem.valueIconWidth.
     *  @type {number}
     *  @default "16"
     */
    open var booleanImageWidth: Number = definedExternally
    /**
     *  Height for the ListGrid.booleanTrueImage, ListGrid.booleanFalseImage
     *   and ListGrid.booleanPartialImage.
     *   Note: If ListGrid.booleanTrueImage is unset, the CheckboxItem.checkedImage
     *   will be used to indicate a true value in a boolean field. In this case this property is
     *   ignored in favor of CheckboxItem.valueIconHeight.
     *  @type {number}
     *  @default "16"
     */
    open var booleanImageHeight: Number = definedExternally
    /**
     *  When set to true, shows the ListGrid.dragHandleField on initial draw.
     *  @type {boolean}
     *  @default null
     */
    open var showInitialDragHandles: Boolean = definedExternally
    /**
     *  The title to use for the ListGrid.dragHandleField.
     * 
     *   By default this title is not displayed in the drag column header button as the
     *   autochild defaults for the field set ListGridField.showTitle to
     *   false.
     *  @type {string}
     *  @default "&amp;nbsp;"
     */
    open var dragHandleFieldTitle: String = definedExternally
    /**
     *  Default icon to show in the ListGrid.dragHandleField..
     *  @type {SCImgURL}
     *  @default "[SKIN]/actions/drag.png"
     */
    open var dragHandleIcon: String = definedExternally
    /**
     *  Default width and height of ListGrid.dragHandleIcon for this ListGrid.
     *  @type {number}
     *  @default "16"
     */
    open var dragHandleIconSize: Number = definedExternally
    /**
     *  An automatically generated field that can be dragged to drag the current selection
     *   (where otherwise the grid itself might be scrolled). Visibility is controlled by
     *   ListGrid.showInitialDragHandles, ListGrid.showDragHandles, and ListGrid.hideDragHandles.
     *  @type {ListGridField}
     *  @default null
     */
    open var dragHandleField: ListGridField = definedExternally
    /**
     *  When set to true, shows an additional field at the beginning of the field-list
     *   (respecting RTL) that displays the current rowNum for each record.
     *  @type {boolean}
     *  @default null
     */
    open var showRowNumbers: Boolean = definedExternally
    /**
     *  The CSS Style name for the ListGrid.rowNumberField.
     *  @type {CSSStyleName}
     *  @default "specialCol"
     */
    open var rowNumberStyle: String = definedExternally
    /**
     *  If ListGrid.showRowNumbers is true, should we apply the ListGrid.rowNumberStyle to
     *   the ListGrid.rowNumberField
     *  @type {boolean}
     *  @default true
     */
    open var applyRowNumberStyle: Boolean = definedExternally
    /**
     *  The number to start the row-count from - default value is 1.
     *  @type {number}
     *  @default "1"
     */
    open var rowNumberStart: Number = definedExternally
    /**
     *  An automatically generated field that displays the current row number when
     *   ListGrid.showRowNumbers is true.
     *  @type {ListGridField}
     *  @default null
     */
    open var rowNumberField: ListGridField = definedExternally
    /**
     *  Dictates whether the data in this grid should be exported raw by
     *   ListGrid.exportClientData. If set to true,
     *   data will not be processed by field-formatters during exports.
     *   Decreases the time taken for large exports. This property can also be set at the
     *   ListGridField.exportRawValues.
     *  @type {boolean}
     *  @default null
     */
    open var exportRawValues: Boolean = definedExternally
    /**
     *  The method of RecordComponentPoolingMode to employ for
     *   ListGrid.canExpandRecords.
     * 
     *   The default mode is "destroy", which means that automatically created expansionComponents
     *   are destroyed when rows are collapsed.
     *  @type {ExpansionComponentPoolingMode}
     *  @default "destroy"
     */
    open var expansionComponentPoolingMode: 
                                            /**
                                             *  auto-created, built-in components are destroyed when record are    ListGrid.collapseRecord.
                                             *  all expansion components are deparented from the grid when a record is    ListGrid.collapseRecord but are not destroyed. It is the responsibility
                                             *      of the developer to handle component destruction
                                             */
                                            String /* destroy |  none */ = definedExternally
    /**
     *  When set to true, shows an additional field at the beginning of the field-list
     *   (respecting RTL) to allow users to expand and collapse individual records.
     *   See ListGrid.expandRecord and ListGrid.expansionMode for details
     *   on record expansion.
     * 
     *   ListGrid.virtualScrolling is automatically enabled when canExpandRecords is
     *   set to true.
     * 
     *   Note that expanded records are not currently supported in conjunction
     *   with ListGridField.frozen.
     *  @type {boolean}
     *  @default false
     */
    open var canExpandRecords: Boolean = definedExternally
    /**
     *  When ListGrid.canExpandRecords is true, this property indicates whether multiple
     *   records can be expanded simultaneously. If set to false, expanding a record will
     *   automatically collapse any record which is already expanded. The default value is
     *   true.
     *  @type {boolean}
     *  @default true
     */
    open var canExpandMultipleRecords: Boolean = definedExternally
    /**
     *  When ListGrid.canExpandRecords and ListGrid.canExpandMultipleRecords are
     *   both true, this property dictates the number of
     *   records which can be expanded simultaneously. If the expanded record count hits the
     *   value of this property, further attempts to expand records will result in a popup
     *   warning (see ListGrid.maxExpandedRecordsPrompt) and expansion will be cancelled.
     * 
     *   The default value is null, meaning there is no limit on the number of expanded records.
     *  @type {Integer}
     *  @default null
     */
    open var maxExpandedRecords: Number = definedExternally
    /**
     *  This is a dynamic string - text within &#36;{...} will be evaluated as JS code
     *   when the message is displayed. Note that the local variable count will be
     *   available and set to this.maxExpandedRecords. The string will be executed in the scope of the
     *   ListGrid so this may also be used to determine other information about this grid.
     * 
     *   Default value returns
     * 
     *   This grid is limited to [ListGrid.maxExpandedRecords] simultaneously
     *   expanded records. Please collapse some expanded records and retry.
     * 
     *  @type {HTMLString}
     *  @default "This grid is limited to ${count} simultaneously expanded records.  Please collapse some expanded records and retry."
     */
    open var maxExpandedRecordsPrompt: String = definedExternally
    /**
     *  The field whose contents to show in the expanded portion of a record when
     *   ListGrid.canExpandRecords is true and
     *   ExpansionMode is detailField.
     *  @type {string}
     *  @default null
     */
    open var detailField: String = definedExternally
    /**
     *  The ExpansionMode for records in this grid.
     *   Default null value means no expansion.
     *  @type {ExpansionMode}
     *  @default null
     */
    open var expansionMode: 
                            /**
                             *  Show a single field's value in an HTMLFlow. Field   to use is ListGrid.detailField.
                             *  Show a DetailViewer displaying those fields from the   record which are not already displayed in the grid.
                             *  Show a separate ListGrid containing related-records.   See ListGridRecord.detailDS and ListGrid.recordDetailDSProperty for
                             *     more information.
                             *  Show a DynamicForm to edit those fields from the   record which are not already present in the grid. If the record is collapsed with
                             *     unsaved changes and ListGrid.expansionEditorShowSaveDialog is not set, Edits
                             *     will be saved automatically, or stored as editing if
                             *     ListGrid.autoSaveEdits is false. Otherwise, a confirmation dialog is
                             *     displayed. Can optionally show a
                             *     ListGrid.showExpansionEditorSaveButton and
                             *     ListGrid.expansionEditorCollapseOnSave when save is pressed.
                             *     If a record fails validation on save and the field in question is not visible in
                             *     the grid, the record is automatically expanded and validated to show the errors.
                             *  Show a DetailViewer displaying those fields   from the record not already displayed in the grid, together with a separate
                             *     ListGrid containing related-records.
                             */
                            String /* detailField |  details |  related |  editor |  detailRelated */ = definedExternally
    /**
     *  The field providing the facility to expand and collapse rows.
     *  @type {ListGridField}
     *  @default null
     */
    open var expansionField: ListGridField = definedExternally
    /**
     *  If ListGrid.canExpandRecords is set to true, this property
     *   determines the image to display in the expansion field for expanded rows.
     *   If unset, the ListGrid.booleanTrueImage will be used.
     *  @type {SCImgURL}
     *  @default null
     */
    open var expansionFieldTrueImage: String = definedExternally
    /**
     *  If ListGrid.canExpandRecords is set to true, this property
     *   determines the image to display in the expansion field for collapsed rows.
     *   If unset, the ListGrid.booleanFalseImage will be used.
     *  @type {SCImgURL}
     *  @default null
     */
    open var expansionFieldFalseImage: String = definedExternally
    /**
     *  Should a "_selected" suffix be added to the
     *   ListGrid.expansionFieldTrueImage
     *   and ListGrid.expansionFieldFalseImage image URLs for
     *   selected rows?
     * 
     *   This allows developers to provide separate expansion field media for selected
     *   rows, in case the selected row style does not contrast well with the standard
     *   expansion field image media.
     * 
     *   If both this property and attr:ListGrid.expansionFieldImageShowRTL are true, and
     *   the grid is in RTL mode, both suffixes will be applied to selected rows'
     *   expansion field image (combined as "selected_rtl")
     *  @type {boolean}
     *  @default false
     */
    open var expansionFieldImageShowSelected: Boolean = definedExternally
    /**
     *  If ListGrid.canExpandRecords is set to true, this property
     *   may be set to govern the width of the expansion image displayed to indicate whether a row
     *   is expanded. If unset, the expansionField image will be sized to match the
     *   ListGrid.booleanImageWidth for this grid.
     *  @type {Integer}
     *  @default null
     */
    open var expansionFieldImageWidth: Number = definedExternally
    /**
     *  If ListGrid.canExpandRecords is set to true, this property
     *   may be set to govern the height of the expansion image displayed to indicate whether a
     *   row is expanded. If unset, the expansionField image will be sized to match the
     *   ListGrid.booleanImageHeight for this grid.
     *  @type {Integer}
     *  @default null
     */
    open var expansionFieldImageHeight: Number = definedExternally
    /**
     *  Automatically generated HTMLFlow for displaying the contents of
     *   ListGrid.detailField in a record's expanded section when
     *   ExpansionMode is detailField.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   listGrid.expansionDetailFieldProperties and
     *   listGrid.expansionDetailFieldDefaults.
     * 
     *   Note, however, that this is a multi-instance component (potentially one per record),
     *   so it is created using Class.createAutoChild not
     *   Class.addAutoChild, and no default single instance is created by
     *   name on the grid.
     *  @type {HTMLFlow}
     *  @default null
     */
    open var expansionDetailField: HTMLFlow = definedExternally
    /**
     *  Automatically generated DetailViewer for displaying the details of a record
     *   in its expanded section when
     *   ExpansionMode is details. Note that
     *   only those fields
     *   which do not already appear in the grid are displayed in the expanded section.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   listGrid.expansionDetailsProperties and
     *   listGrid.expansionDetailsDefaults.
     * 
     *   Note, however, that this is a multi-instance component (potentially one per record),
     *   so it is created using Class.createAutoChild not
     *   Class.addAutoChild, and no default single instance is created by
     *   name on the grid.
     *  @type {DetailViewer}
     *  @default null
     */
    open var expansionDetails: DetailViewer = definedExternally
    /**
     *  Automatically generated ListGrid for displaying data related to a record
     *   in its expanded section when
     *   ExpansionMode is related.
     *   The DataSource containing the related data is provided by
     *   ListGrid.getRelatedDataSource which, by default,
     *   returns the DataSource referred to in ListGridRecord.detailDS.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   listGrid.expansionRelatedProperties and
     *   listGrid.expansionRelatedDefaults.
     * 
     *   Note, however, that this is a multi-instance component (potentially one per record),
     *   so it is created using Class.createAutoChild not
     *   Class.addAutoChild, and no default single instance is created by
     *   name on the grid.
     *  @type {ListGrid}
     *  @default null
     */
    open var expansionRelated: ListGrid = definedExternally
    /**
     *  Automatically generated DynamicForm for editing the details of a record
     *   in its expanded section when
     *   ExpansionMode is editor. Note that only
     *   those fields which do not already appear in the grid will appear in the expanded section.
     * 
     *   According to the value of ListGrid.showExpansionEditorSaveButton, a save button is shown
     *   beneath the editor. You can save the values in the editor by clicking this button
     * 
     *   This component is an AutoChild and as such may be customized via
     *   listGrid.expansionEditorProperties and
     *   listGrid.expansionEditorDefaults.
     * 
     *   Note, however, that this is a multi-instance component (potentially one per record),
     *   so it is created using Class.createAutoChild not
     *   Class.addAutoChild, and no default single instance is created by
     *   name on the grid.
     *  @type {DynamicForm}
     *  @default null
     */
    open var expansionEditor: DynamicForm = definedExternally
    /**
     *  When ListGrid.canExpandRecords is true and
     *   ListGrid.expansionMode is editor, whether a dialog should be
     *   displayed when an expanded row is collapsed while it's nested editor has changed values.
     *  @type {boolean}
     *  @default null
     */
    open var expansionEditorShowSaveDialog: Boolean = definedExternally
    /**
     *  When ListGrid.canExpandRecords is true and
     *   ListGrid.expansionMode is editor, the prompt to display
     *   in a dialog when an expanded row is collapsed while it's nested editor has changed values.
     *  @type {string}
     *  @default "You have unsaved changes - do you want to save them now?"
     */
    open var expansionEditorSaveDialogPrompt: String = definedExternally
    /**
     *  When ExpansionMode is editor, should the row be collapsed following a
     *   save initiated by the expansion-component's ListGrid.expansionEditorSaveButton.
     *  @type {boolean}
     *  @default true
     */
    open var expansionEditorCollapseOnSave: Boolean = definedExternally
    /**
     *  When ExpansionMode is editor, should a Save button be shown below the
     *   the expanded editor?
     * 
     *   Note that if an expanded-row containing an editor is collapsed while changes are
     *   outstanding, changes will be either be automatically updated to the grid, or will first
     *   show a confirmation dialog, according to the value of
     *   ListGrid.expansionEditorShowSaveDialog.
     *  @type {boolean}
     *  @default true
     */
    open var showExpansionEditorSaveButton: Boolean = definedExternally
    /**
     *  Automatically generated IButton for saving the values in the expanded
     *   portion of a ListGrid row.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   listGrid.expansionEditorSaveButtonProperties and
     *   listGrid.expansionEditorSaveButtonDefaults.
     * 
     *   Note, however, that this is a multi-instance component (potentially one per record),
     *   so it is created using Class.createAutoChild not
     *   Class.addAutoChild, and no default single instance is created by
     *   name on the grid.
     *  @type {IButton}
     *  @default null
     */
    open var expansionEditorSaveButton: IButton = definedExternally
    /**
     *  The title for the ListGrid.expansionEditorSaveButton.
     *  @type {string}
     *  @default "Save"
     */
    open var expansionEditorSaveButtonTitle: String = definedExternally
    /**
     *  Automatically generated HLayout appearing in a record's expanded section
     *   when ExpansionMode is detailRelated.
     *   This component contains two other autoChild components,
     *   a DetailViewer for viewing fields from the record which are not already
     *   present in the grid and a separate embedded ListGrid for displaying other
     *   data related to this record via record.detailDS. See ListGrid.expansionDetails
     *   and ListGrid.expansionRelated for more information.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   listGrid.expansionDetailRelatedProperties and
     *   listGrid.expansionDetailRelatedDefaults.
     * 
     *   Note, however, that this is a multi-instance component (potentially one per record),
     *   so it is created using Class.createAutoChild not
     *   Class.addAutoChild, and no default single instance is created by
     *   name on the grid.
     *  @type {HLayout}
     *  @default null
     */
    open var expansionDetailRelated: HLayout = definedExternally
    /**
     *  Automatically generated VLayout which fills a record's expanded section
     *   and contains other builtin ExpansionMode. You can also
     *   override ListGrid.getExpansionComponent to provide
     *   components of your own specification.
     * 
     *   This component is an AutoChild and as such may be customized via
     *   listGrid.expansionLayoutProperties and
     *   listGrid.expansionLayoutDefaults.
     * 
     *   Note, however, that this is a multi-instance component (potentially one per record),
     *   so it is created using Class.createAutoChild not
     *   Class.addAutoChild, and no default single instance is created by
     *   name on the grid.
     *  @type {VLayout}
     *  @default null
     */
    open var expansionLayout: VLayout = definedExternally
    /**
     *  If ListGrid.canExpandRecords is true and ExpansionMode
     *   is "related", this property specifies the dataSource for the
     *   related records grid to be shown embedded in expanded records.
     * 
     *   This property may also be specified on a per-record basis - see
     *   ListGrid.recordDetailDSProperty
     *  @type {string}
     *  @default null
     */
    open var detailDS: String = definedExternally
    /**
     *  The name of the ListGridRecord property that specifies the DataSource to use when
     *   ExpansionMode is "related". The default is
     *   ListGridRecord.detailDS. Note that you can set the ListGrid.detailDS at the
     *   grid level instead if the same dataSource is to be used for all records.
     *  @type {string}
     *  @default "detailDS"
     */
    open var recordDetailDSProperty: String = definedExternally
    /**
     *  For ExpansionMode that show another grid or tree, what the
     *   child's expansionMode should be.
     *   Default value null means no further expansion.
     *  @type {ExpansionMode}
     *  @default null
     */
    open var childExpansionMode: 
                                 /**
                                  *  Show a single field's value in an HTMLFlow. Field   to use is ListGrid.detailField.
                                  *  Show a DetailViewer displaying those fields from the   record which are not already displayed in the grid.
                                  *  Show a separate ListGrid containing related-records.   See ListGridRecord.detailDS and ListGrid.recordDetailDSProperty for
                                  *     more information.
                                  *  Show a DynamicForm to edit those fields from the   record which are not already present in the grid. If the record is collapsed with
                                  *     unsaved changes and ListGrid.expansionEditorShowSaveDialog is not set, Edits
                                  *     will be saved automatically, or stored as editing if
                                  *     ListGrid.autoSaveEdits is false. Otherwise, a confirmation dialog is
                                  *     displayed. Can optionally show a
                                  *     ListGrid.showExpansionEditorSaveButton and
                                  *     ListGrid.expansionEditorCollapseOnSave when save is pressed.
                                  *     If a record fails validation on save and the field in question is not visible in
                                  *     the grid, the record is automatically expanded and validated to show the errors.
                                  *  Show a DetailViewer displaying those fields   from the record not already displayed in the grid, together with a separate
                                  *     ListGrid containing related-records.
                                  */
                                 String /* detailField |  details |  related |  editor |  detailRelated */ = definedExternally
    /**
     *  For ExpansionMode that show another grid or tree, is that
     *   component editable?
     *   The default value for this property is false.
     *  @type {boolean}
     *  @default null
     */
    open var expansionCanEdit: Boolean = definedExternally
    /**
     *  Causes filtering to be performed against the local data set, even when a
     *   ListGrid.dataSource is provided.
     * 
     *   When using this mode, data must be provided to the grid via ListGrid.setData,
     *   and must be provided as
     *   a simple Array of Records
     *   .
     * 
     *   Note that a ListGrid.dataSource must be provided for filtering to occur
     *   even when filtering locally.
     * 
     *   If this property is set to true, the supplied data is applied as the
     *   ResultSet.allRows of a ResultSet, which is then
     *   filtered according to the specified criteria, and the results displayed. If false, a
     *   normal databound fetch will occur, retrieving records that match the specified criteria
     *   from this component's ListGrid.dataSource.
     * 
     *   filterLocalData includes both calls to ListGrid.fetchData and
     *   ListGrid.filterData as well as automatic filtering when the
     *   ListGrid.filterEditor is enabled.
     * 
     *   If this property is not explicitly set, default behavior will filter against the
     *   dataSource unless the grid has a specified DataPath, in which case
     *   filtering will occur locally.
     * 
     *   See also ListGrid.saveLocally to cause saves to ignore the DataSource and affect
     *   the local data set only.
     *  @type {boolean}
     *  @default null
     */
    open var filterLocalData: Boolean = definedExternally
    /**
     *  If ListGrid.canAcceptDroppedRecords is true for this listGrid, this property governs
     *   whether the user can drop between, or over records within the grid.
     *   This controls what RecordDropPosition is passed to the ListGrid.recordDrop
     *   event handler.
     *  @type {RecordDropAppearance}
     *  @default "between"
     */
    open var recordDropAppearance: 
                                   /**
                                    *  When the user drops onto a record, dropPosition will always be "over"
                                    *  When the user drops onto a record, dropPosition will be either  "before" or "after" depending on whether the mouse was over the top or bottom of
                                    *    the target record
                                    *  When the user drops onto a record, if the drop occurs centered over the  record, the dropPosition will be reported as "over", otherwise it will be
                                    *    "before" or "after" depending on whether the mouse was over the top or bottom of the
                                    *    target record.
                                    *  No dropPosition will be reported
                                    */
                                   String /* over |  between |  both |  body */ = definedExternally
    /**
     *  If a user is editing a ListGrid.canEdit listGrid, and they hide
     *   a field while the editor is showing, should we discard any edits in the edit row for
     *   the field being hidden?
     * 
     *   Default behavior is to discard the edits - set this flag to false to preserve edits
     *  @type {boolean}
     *  @default true
     */
    open var discardEditsOnHideField: Boolean = definedExternally
    /**
     *  Initial ListGridFieldState for the grid.
     * 
     *   ListGrid.viewState can be used to initialize all view properties of the grid.
     *   When doing so, fieldState is not needed because viewState
     *   includes it as well. If both are provided, fieldState has priority for
     *   field state.
     * 
     * 
     *   To retrieve current state call ListGrid.getFieldState.
     * 
     *  @type {ListGridFieldState}
     *  @default null
     */
    open var fieldState: String = definedExternally
    /**
     *  How much horizontal space should the ListGrid.getCheckboxField leave
     *   around the checkbox icon when ListGrid.selectionAppearance is set to
     *   "checkbox"?
     * 
     *   The automatically generated checkbox field will be sized to the width of the
     *   checkbox icon (specified via ListGrid.checkboxFieldImageWidth or
     *   ListGrid.booleanImageWidth) plus this value.
     *  @type {Integer}
     *  @default "15"
     */
    open var checkboxFieldHSpace: Number = definedExternally
    /**
     *  Returns a snapshot of the current selection within this listGrid as
     *   a ListGridSelectedState object.
     *   This object can be passed to ListGrid.setSelectedState to reset this grid's selection
     *   the current state (assuming the same data is present in the grid).
     *  @type {ListGridSelectedState}
     *  @default null
     */
    open var selectedState: String = definedExternally
    /**
     *  Initial sort state for the grid.
     * 
     *   ListGrid.viewState can be used to initialize all view properties of the grid.
     *   When doing so, sortState is not needed because viewState
     *   includes it as well. If both are provided, sortState has priority for
     *   sort state.
     * 
     * 
     *   To retrieve current state call ListGrid.getSortState.
     * 
     *  @type {ListGridSortState}
     *  @default null
     */
    open var sortState: String = definedExternally
    /**
     *  Initial group state for the grid.
     * 
     *   ListGrid.viewState can be used to initialize all view properties of the grid.
     *   When doing so, groupState is not needed because viewState
     *   includes it as well. If both are provided, groupState has priority for
     *   group state.
     * 
     * 
     *   To retrieve current state call ListGrid.getGroupState.
     * 
     *  @type {ListGridGroupState}
     *  @default null
     */
    open var groupState: String = definedExternally
    /**
     *  Initial ListGridViewState for the grid.
     * 
     *   Since view state contains field state it is not necessary
     *   to set ListGrid.fieldState when also setting viewState.
     *   If both are provided, fieldState has priority for field state.
     * 
     * 
     *   To retrieve current state call ListGrid.getViewState.
     * 
     *  @type {ListGridViewState}
     *  @default null
     */
    open var viewState: String = definedExternally
    /**
     *  Array of components that make up this grid. This array controls which standard and/or custom
     *   parts will be displayed within this ListGrid.
     * 
     *   ListGrid is a subclass of VLayout and consists of a number of member components. The
     *   standard set of members are automatically generated by the grid, and include (for example)
     *   the header (a Toolbar of buttons for each field) and the body
     *   (a GridRenderer displaying the actual data contained in the grid).
     *   The default value of gridComponents is an Array of ListGridComponents listing
     *   the standard components in their default order:
     * 
     * 
     *    gridComponents : ["filterEditor", "header",
     *             "body", "summaryRow"]
     * 
     * 
     * 
     * 
     *   You can override gridComponents to change the order of standard components.
     *   You can also omit standard components this way, although it more efficient to
     *   use the related "show" property if available (eg ListGrid.showFilterEditor). Note that
     *   this array must contain an entry for the "body" - listGrids with no body showing
     *   are unsupported.
     *   Advanced note: The live components generated for each of these standard
     *   ListGridComponent types may differ across different listGrids. For example if this
     *   grid has any ListGridField.frozen, the "body" entry will actually
     *   be created as an HLayout containing two GridRenderers (one for frozen fields,
     *   and one for unfrozen fields). This is really an implementation detail - the "body" entry
     *   in the gridComponents array simply specifies where the UI for the body should render within
     *   the ListGrid layout.
     * 
     *   By embedding a Canvas directly in this list you can add arbitrary additional components to the
     *   listGrid as members, and have them be displayed alongside the standard automatically generated
     *   parts of the ListGrid.
     * 
     *   Note that having added controls to gridComponents, you can still call APIs directly on
     *   those controls to change their appearance, and you can also show() and hide() them if
     *   they should not be shown in some circumstances.
     * 
     *   Tip: custom controls need to set layoutAlign:"center" to appear vertically centered.
     *  @type {Array<Partial<ListGridComponent>> | Array<Partial<any>>}
     *  @default "(see below)"
     */
    open var gridComponents: Array<dynamic> = definedExternally
    /**
     *  If this property is set to true, header buttons for either ListGrid.fields or
     *   ListGrid.headerSpans will automatically expand to accommodate their
     *   titles vertically. This means if you have a "tall" title - typically a long string where
     *   ListGridField.wrap is set to true such that you end up with several lines of text -
     *   the button will render large enough to accommodate it. If necessary this will cause the
     *   header for the grid as a whole to expand beyond the specified ListGrid.headerHeight.
     * 
     *   Note that you need not set HeaderSpan.height or ListGrid.headerSpanHeight if you set
     *   this property, but if you do, they will be used as minimum values.
     *  @type {boolean}
     *  @default null
     */
    open var autoFitHeaderHeights: Boolean = definedExternally
    /**
     *  When using ListGrid.autoFitFieldWidths, padding in pixels left on each side of fields that
     *   show images.
     *  @type {Integer}
     *  @default "2"
     */
    open var iconPadding: Number = definedExternally
    /**
     *  If ListGridField.userFormula is set for some field, and this grid is showing
     *   ListGrid.showGroupSummary or a
     *   ListGrid.showGridSummary, this property determines what field value
     *   should be present in those summary rows. Should the field apply the user-formula to the
     *   calculated summary row, or should it apply a standard grid or group summary to the
     *   user-formula values displayed in the grid?
     * 
     *   May be overridden at the field level via ListGridField.applyAfterSummary
     *  @type {boolean}
     *  @default false
     */
    open var applyFormulaAfterSummary: Boolean = definedExternally
    /**
     *  Should cells in this grid be allowed to span multiple rows?
     *   If set to true, the ListGrid.getRowSpan method will be
     *   called for every cell when rendering out the listGrid to determine how many
     *   rows the cell should span.
     * 
     *   See ListGrid.getRowSpan for more details
     *  @type {boolean}
     *  @default false
     */
    open var allowRowSpanning: Boolean = definedExternally
    /**
     *  Enables various styling behaviors that potentially make sense when ListGrid.getRowSpan has
     *   been overridden to introduce spanning cells, and spanning is largest on the left and
     *   smaller as cells go to the right. Specifically:
     * 
     * 
     *  - computes ListGrid.alternateRecordStyles based on the span of the
     *     cell in the left-most column
     * 
     *  - enables ListGrid.canSelectCells, including
     *     ListGrid.useCellRollOvers styling
     * 
     *  - enables row-span-sensitive cell selection. See also RowSpanSelectionMode
     *     for available behaviors
     * 
     * 
     *   Because this setting enables ListGrid.canSelectCells, it is incompatible with any APIs
     *   that expect a record-oriented data model.
     * 
     *   Because this setting only makes sense when row spanning decreases from the first column
     *   to the last, it has unspecified behavior with ListGrid.canReorderFields.
     *  @type {boolean}
     *  @default null
     */
    open var useRowSpanStyling: Boolean = definedExternally
    /**
     *  Chooses the selection mode when ListGrid.useRowSpanStyling is enabled. See
     *   RowSpanSelectionMode.
     *  @type {RowSpanSelectionMode}
     *  @default "forward"
     */
    open var rowSpanSelectionMode: 
                                   /**
                                    *  when a cell is clicked on, select any cells in subsequent columns which         are at least partially spanned by the clicked cell
                                    *  when a cell is clicked on, selects any cells in any other columns which         are at least partially spanned by the clicked cell
                                    *  behaves like "forward", except as though the cell in the first column          was clicked instead. If the largest row spans are in the first
                                    *            column and all cells in subsequent columns do not extend out of the
                                    *            first cell's span, this creates a row-like selection model where the
                                    *            span of the left-most cell defines the "row" of cells being selected.
                                    */
                                   String /* forward |  both |  outerSpan */ = definedExternally
    /**
     *  If ListGrid.allowRowSpanning is enabled, this property may be used to specify
     *   editing behavior for cells that span multiple rows.
     *  @type {RowSpanEditMode}
     *  @default "first"
     */
    open var rowSpanEditMode: 
                              /**
                               *  This setting assumes that only the field-value for the first record spanned by this cell is significant. In this case the editor will only show for this
                               *   cell if the user is editing the first spanned record. If the user initialized the edit
                               *   on another spanned row, the editor will not show for this field.
                               *  This setting assumes that each row's values are logically separate, so if a cell spans multiple rows, and a user initializes an edit on some cell in the
                               *   second spanned row, the spanning cell will show an editor containing the value for
                               *   the second spanned row. This may differ from the value displayed when not
                               *   in edit mode (which is derived from the first spanned row by default). This setting may
                               *   be useful for developers who which to implement their own logic on how to handle
                               *   spanning cell display values and/or edit values (for example by using custom
                               *   ListGridField.formatCellValue and applying custom logic to handle
                               *   editing on ListGridField.editorEnter and ListGridField.editorExit).
                               */
                              String /* first |  each */ = definedExternally
    /**
     *  If ListGrid.showRecordComponents is true, this attribute may be used to
     *   specify a standard height for record components.
     *   If specified every row in the grid will be sized tall enough to accommodate a recordComponent
     *   of this size.
     * 
     *   Note that if this property is unset, the grid will not be able to know row heights in
     *   advance, and ListGridField.frozen are not currently supported in
     *   this case. If you are putting a recordComponent in every row, and they all have a consistent
     *   height, set recordComponentHeight and you will then be able to use frozen fields
     *   and avoid the whitespace side-effect of virtual scrolling by setting
     *   ListGrid.virtualScrolling:false.
     * 
     *   Similarly, if your recordComponents are never tall enough that they will expand the row
     *   beyond the ListGrid.cellHeight, set ListGrid.virtualScrolling:false to avoid the whitespace
     *   side-effect of ListGrid.virtualScrolling and to allow
     *   ListGridField.frozen to be used. In this mode, you can have
     *   recordComponents on some rows but not others, and recordComponents of different heights, so
     *   long as no recordComponent ever causes a row to grow beyond ListGrid.cellHeight (which would
     *   happen if the recordComponents height + 2\*ListGrid.cellPadding is larger than
     *   ListGrid.cellHeight).
     *  @type {Integer}
     *  @default null
     */
    open var recordComponentHeight: Number = definedExternally
    /**
     *  Whether cell contents should wrap during printing. Equivalent to Autofit, but
     *   specific to printed output.
     *  @type {boolean}
     *  @default true
     */
    open var printAutoFit: Boolean = definedExternally
    /**
     *  Whether cell contents should wrap during printing. Equivalent to ListGrid.wrapCells, but
     *   specific to printed output.
     *  @type {boolean}
     *  @default true
     */
    open var printWrapCells: Boolean = definedExternally
    /**
     *  Style for header cells in printed output. Defaults to ListGrid.headerBaseStyle if null.
     *  @type {CSSStyleName}
     *  @default "printHeader"
     */
    open var printHeaderStyle: String = definedExternally
    /**
     *  Style for non-header cells in printed output. Defaults to ListGrid.baseStyle if null.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var printBaseStyle: String = definedExternally
    /**
     *  Advanced property - when generating printHTML for a large ListGrid, rows are printed in
     *   batches in order to avoid triggering a native "script is running slowly" browser dialog.
     * 
     *   For grids with exceptional numbers of columns or complex formatting logic, this number
     *   might need to be adjusted downward.
     *  @type {Integer}
     *  @default "100"
     */
    open var printMaxRows: Number = definedExternally
    /**
     *  When set to true and canHover is also true, shows a widget hovering at the mouse point.
     * 
     *   A number of builtin modes are provided - see HoverMode.
     * 
     *   Also supported at the ListGridField.showHoverComponents.
     *  @type {boolean}
     *  @default false
     */
    override var showHoverComponents: Boolean = definedExternally
    /**
     *  When ListGrid.showHoverComponents is true, the builtin mode
     *   to use when automatically creating a hover component for rows in this grid.
     * 
     *   A number of builtin modes are provided - see HoverMode. You can also override
     *   ListGrid.getCellHoverComponent to provide a custom hover
     *   widget - in that case, this attribute is ignored.
     *  @type {HoverMode}
     *  @default null
     */
    open var hoverMode: 
                        /**
                         *  Show a single field's value in an HTMLFlow. Field   to use is ListGrid.detailField.
                         *  Show a DetailViewer displaying those fields from the   record which are not already displayed in the grid.
                         *  Show a separate ListGrid containing related-records.   See ListGridRecord.detailDS and ListGrid.recordDetailDSProperty for
                         *     more information.
                         *  Show a DetailViewer displaying those fields   from the record not already displayed in the grid, together with a separate
                         *     ListGrid containing related-records.
                         */
                        String /* detailField |  details |  related |  detailRelated */ = definedExternally
    /**
     *  When set to false, clicking a record's ListGrid.expansionField will
     *   not add the record to the current selection.
     *  @type {boolean}
     *  @default true
     */
    open var selectOnExpandRecord: Boolean = definedExternally
    /**
     *  If this property is set to true, clicking on a cell will natively select the
     *   cell's content, ready to be copied to the browser clipboard.
     * 
     *   For control of this behavior at the field level,
     *   ListGridField.selectCellTextOnClick may be used. These properties interact
     *   as follows:
     * 
     *   listGrid.selectCellTextOnClick value
     *   listGridField.selectCellTextOnClick value
     *   Behavior
     * 
     *   true
     *     unset or true
     *       Cell contents will be natively selected on click.
     * 
     *     false
     *       Cell contents will not be natively selected on click.
     * 
     * 
     *   unset
     *     true
     *       Cell contents will be natively selected on click.
     * 
     *     unset or false
     *       Cell contents will not be natively selected on click.
     * 
     *   false
     *     true, false or unset
     *       Cell contents will not be natively selected on click.
     * 
     * 
     *   This is related to the ListGrid.canDragSelectText attribute which enables
     *   native text selection of grid content by standard browser interactions (drag
     *   selecting or double-click selecting).
     * 
     *   Note that developers may also be interested in the related formItem properties
     *   FormItem.selectOnClick and FormItem.selectOnFocus.
     *  @type {boolean}
     *  @default false
     */
    open var selectCellTextOnClick: Boolean = definedExternally
    /**
     *  When scrollToCell is called, this is used as defaults if xPosition weren't explicitly passed
     *   into the method.
     *  @type {Alignment}
     *  @default "center"
     */
    open var scrollToCellXPosition: 
                                    /**
                                     *  Center within container.
                                     *  Stick to left side of container.
                                     *  Stick to right side of container.
                                     */
                                    String /* center |  left |  right */ = definedExternally
    /**
     *  When scrollToCell is called, this is used as defaults if yPosition weren't explicitly passed
     *   into the method.
     *  @type {VerticalAlignment}
     *  @default "center"
     */
    open var scrollToCellYPosition: 
                                    /**
                                     *  At the top of the container
                                     *  Center within container.
                                     *  At the bottom of the container
                                     */
                                    String /* top |  center |  bottom */ = definedExternally
    /**
     *  If the listGrid is empty, should the user be able to put focus into the grid body by tabbing
     *   to it?
     * 
     *   Note that if ListGrid.editOnFocus is true for this grid and ListGrid.listEndEditAction is set to next,
     *   having this property set to true will allow users to automatically create a new edit row by
     *   simply tabbing into the grid.
     *  @type {boolean}
     *  @default true
     */
    open var canFocusInEmptyGrid: Boolean = definedExternally
    /**
     *  Should this ListGrid show a summary row beneath the last record of the grid. This summary
     *   row will contain per-field summary information. See ListGridField.showGridSummary and
     *   ListGrid.getGridSummaryFunction for details on how the summary value to be displayed
     *   for each column will be calculated.
     * 
     *   Note that the ListGrid.summaryRow will be created to actually
     *   display the summary row.
     *  @type {boolean}
     *  @default false
     */
    open var showGridSummary: Boolean = definedExternally
    /**
     *  Value to display to the user if showing summary values (through ListGrid.showGridSummary,
     *   ListGrid.showGroupSummary or ListGridFieldType), and
     *   the summary function returns "null" (implying it was unable to calculate a
     *   valid summary value). This property will only be used in the default formatting behavior. If
     *   an explicit formatter has been specified - via ListGrid.formatCellValue or
     *   ListGridField.formatGridSummary, for example - this property has
     *   no effect.
     *  @type {string}
     *  @default "&amp;nbsp;"
     */
    open var invalidSummaryValue: String = definedExternally
    /**
     *  Property name on a record that will be checked to determine whether a record should
     *   be included when calculating totals for the ListGrid.showGridSummary.
     *  @type {string}
     *  @default "includeInSummary"
     */
    open var includeInSummaryProperty: String = definedExternally
    /**
     *  If ListGrid.showGridSummary is true, this attribute will be set to true on the
     *   record object representing the grid summary row.
     *  @type {string}
     *  @default "isGridSummary"
     */
    open var gridSummaryRecordProperty: String = definedExternally
    /**
     *  If ListGrid.showGroupSummary is true, this attribute will be set to true on each
     *   record object representing a group-level summary row.
     *  @type {string}
     *  @default "isGroupSummary"
     */
    open var groupSummaryRecordProperty: String = definedExternally
    /**
     *  If ListGrid.showGridSummary is true, by default summary values are calculated on the
     *   client based on the current data-set for the grid (see ListGrid.getGridSummary and
     *   ListGrid.getGridSummaryFunction).
     * 
     *   In some cases however it may make sense to calculate summary values on the server and retrieve
     *   them via a dataSource fetch. If set, this property specifies a dataSource to fetch against for
     *   the summary row. The dataSource should return a single record with summary data for each
     *   field for which summary data should be shown. Note that specifying this property completely
     *   bypasses the standard client-side grid summary calculation logic.
     * 
     *   The fetch may be further customized via ListGrid.summaryRowCriteria and
     *   ListGrid.summaryRowFetchRequestProperties
     *  @type {DataSource}
     *  @default null
     */
    open var summaryRowDataSource: DataSource = definedExternally
    /**
     *  If ListGrid.showGridSummary is true, and a ListGrid.summaryRowDataSource is specified
     *   this property may be used to specify fetch criteria to apply when retrieving summary data
     *   to show in the summary row. If unset, and any filter criteria have been specified for the
     *   grid, they will be used.
     *  @type {Criteria}
     *  @default null
     */
    open var summaryRowCriteria: dynamic = definedExternally
    /**
     *  If ListGrid.showGridSummary is true, and a ListGrid.summaryRowDataSource is specified
     *   this property may be used to customize the fetch request used when retrieving summary data
     *   to show in the summary row. An example use case might be specifying a
     *   DSRequest.operationId to perform a custom fetch operation which retrieved only summary
     *   values based on criteria.
     *  @type {DSRequest}
     *  @default null
     */
    open var summaryRowFetchRequestProperties: DSRequest = definedExternally
    /**
     *  If showing any record summary fields (IE: fields of ListGridFieldType),
     *   this attribute specifies a custom base style to apply to cells in the summary field
     *  @type {CSSStyleName}
     *  @default "recordSummaryCell"
     */
    open var recordSummaryBaseStyle: String = definedExternally
    /**
     *  Automatically generated ListGrid for displaying grid summary information (see
     *   ListGrid.showGridSummary).
     * 
     *   This component is an AutoChild and as such may be customized via
     *   listGrid.summaryRowProperties and listGrid.summaryRowDefaults
     *  @type {ListGrid}
     *  @default null
     */
    open var summaryRow: ListGrid = definedExternally
    /**
     *  Default height for the ListGrid.summaryRow. Note that this
     *   height is a minimum - the summary row has ListGrid.autoFitData set to "vertical" so
     *   if multiple rows are visible in the grid summary, the summaryRow component
     *   will expand to accommodate them.
     *  @type {Integer}
     *  @default "20"
     */
    open var summaryRowHeight: Number = definedExternally
    /**
     *  ListGrid.baseStyle for the ListGrid.summaryRow
     *  @type {CSSStyleName}
     *  @default "gridSummaryCell"
     */
    open var summaryRowStyle: String = definedExternally
    /**
     *  If true, causes the ListGrid.summaryRow component to be hidden if it has
     *   no data after summaries have been recalculated
     *  @type {boolean}
     *  @default null
     */
    open var hideEmptySummaryRow: Boolean = definedExternally
    /**
     *  Default OperatorId to use for text-based fields in this grid's
     *   ListGrid.filterEditor, when producing AdvancedCriteria.
     *   When ListGrid.allowFilterExpressions or
     *   ListGrid.allowFilterOperators are enabled for the grid,
     *   the default is DataSource.translatePatternOperators. Otherwise,
     *   the default is "iContains".
     * 
     *   Does not apply to special fields where exact match is obviously the right default
     *   setting, such as fields of type:"enum", or fields with a
     *   FormItem.valueMap or FormItem.optionDataSource.
     *  @type {OperatorId}
     *  @default null
     */
    open var defaultFilterOperator: 
                                    /**
                                     *  exactly equal to
                                     *  not equal to
                                     *  exactly equal to, if case is disregarded
                                     *  not equal to, if case is disregarded
                                     *  Greater than
                                     *  Less than
                                     *  Greater than or equal to
                                     *  Less than or equal to
                                     *  Contains as sub-string (match case)
                                     *  Starts with (match case)
                                     *  Ends with (match case)
                                     *  Contains as sub-string (case insensitive)
                                     *  Starts with (case insensitive)
                                     *  Ends with (case insensitive)
                                     *  Does not contain as sub-string (match case)
                                     *  Does not start with (match case)
                                     *  Does not end with (match case)
                                     *  Does not contain as sub-string (case insensitive)
                                     *  Does not start with (case insensitive)
                                     *  Does not end with (case insensitive)
                                     *  shortcut for "greaterThan" + "and" + "lessThan" (case insensitive)
                                     *  shortcut for "greaterOrEqual" + "and" + "lessOrEqual" (case insensitive)
                                     *  Basic GLOB matching using wildcards    (see DataSource.translatePatternOperators for more information on available patterns)
                                     *  Basic GLOB matching using wildcards (case insensitive)    (see DataSource.translatePatternOperators for more information on available patterns)
                                     *  GLOB matching using wildcards. Value is considered to meet the    criterion if it contains the pattern. See DataSource.translatePatternOperators
                                     *      for more information on available patterns)
                                     *  GLOB mathcing using wildcards. Value is considered to meet the    criterion if it starts with the pattern.See DataSource.translatePatternOperators
                                     *      for more information on available patterns)
                                     *  GLOB mathcing using wildcards. Value is considered to meet the    criterion if it starts with the pattern.See DataSource.translatePatternOperators
                                     *      for more information on available patterns)
                                     *  GLOB matching using wildcards. Value is considered to meet the    criterion if it contains the pattern. Matching is case insensitive. See
                                     *      DataSource.translatePatternOperators for more information on available patterns)
                                     *  GLOB matching using wildcards. Value is considered to meet the    criterion if it starts with the pattern. Matching is case insensitive.See
                                     *      DataSource.translatePatternOperators for more information on available patterns)
                                     *  GLOB matching using wildcards.Value is considered to meet the    criterion if it ends with the pattern. Matching is case insensitive. See
                                     *      DataSource.translatePatternOperators for more information on available patterns)
                                     *  Regular expression match
                                     *  Regular expression match (case insensitive)
                                     *  value is either null or the empty string. For numeric fields it behaves as isNull
                                     *  value is neither null nor the empty string ("")
                                     *  value is null
                                     *  value is non-null. Note empty string ("") is non-null
                                     *  value is in a set of values. Specify criterion.value as an Array
                                     *  value is not in a set of values. Specify criterion.value as an Array
                                     *  matches another field (match case, specify fieldName as criterion.value)
                                     *  does not match another field (match case, specify fieldName as criterion.value)
                                     *  matches another field (case insensitive, specify fieldName as criterion.value)
                                     *  does not match another field (case insensitive, specify fieldName as criterion.value)
                                     *  Greater than another field (specify fieldName as criterion.value)
                                     *  Less than another field (specify fieldName as criterion.value)
                                     *  Greater than or equal to another field    (specify fieldName as criterion.value)
                                     *  Less than or equal to another field    (specify fieldName as criterion.value)
                                     *  Contains as sub-string (match case) another field value    (specify fieldName as criterion.value)
                                     *  Starts with (match case) another field value    (specify fieldName as criterion.value)
                                     *  Ends with (match case) another field value    (specify fieldName as criterion.value)
                                     *  Contains as sub-string (case insensitive) another field value    (specify fieldName as criterion.value)
                                     *  Starts with (case insensitive) another field value    (specify fieldName as criterion.value)
                                     *  Ends with (case insensitive) another field value    (specify fieldName as criterion.value)
                                     *  Does not contain as sub-string (match case) another field value    (specify fieldName as criterion.value)
                                     *  Does not start with (match case) another field value    (specify fieldName as criterion.value)
                                     *  Does not end with (match case) another field value    (specify fieldName as criterion.value)
                                     *  Does not contain as sub-string (case insensitive) another field value    (specify fieldName as criterion.value)
                                     *  Does not start with (case insensitive) another field value    (specify fieldName as criterion.value)
                                     *  Does not end with (case insensitive) another field value    (specify fieldName as criterion.value)
                                     *  all subcriteria (criterion.criteria) are true
                                     *  all subcriteria (criterion.criteria) are false
                                     *  at least one subcriteria (criterion.criteria) is true
                                     *  shortcut for "greaterThan" + "lessThan" + "and". Specify criterion.start     and criterion.end
                                     *  shortcut for "greaterOrEqual" + "lessOrEqual" + "and". Specify     criterion.start and criterion.end
                                     */
                                    String /* equals |  notEqual |  iEquals |  iNotEqual |  greaterThan |  lessThan |  greaterOrEqual |  lessOrEqual |  contains |  startsWith |  endsWith |  iContains |  iStartsWith |  iEndsWith |  notContains |  notStartsWith |  notEndsWith |  iNotContains |  iNotStartsWith |  iNotEndsWith |  iBetween |  iBetweenInclusive |  matchesPattern |  iMatchesPattern |  containsPattern |  startsWithPattern |  endsWithPattern |  iContainsPattern |  iStartsWithPattern |  iEndsWithPattern |  regexp |  iregexp |  isBlank |  notBlank |  isNull |  notNull |  inSet |  notInSet |  equalsField |  notEqualField |  iEqualsField |  iNotEqualField |  greaterThanField |  lessThanField |  greaterOrEqualField |  lessOrEqualField |  containsField |  startsWithField |  endsWithField |  iContainsField |  iStartsWithField |  iEndsWithField |  notContainsField |  notStartsWithField |  notEndsWithField |  iNotContainsField |  iNotStartsWithField |  iNotEndsWithField |  and |  not |  or |  between |  betweenInclusive */ = definedExternally
    /**
     *  For use with ListGrid.showFilterEditor:true, allows simple search expressions to be entered
     *   into filter fields, as though DynamicForm.allowExpressions were true.
     * 
     *   This attribute can also be set at the ListGridField.allowFilterExpressions.
     *  @type {boolean}
     *  @default null
     */
    open var allowFilterExpressions: Boolean = definedExternally
    /**
     *  If this component is bound to a dataSource, this attribute may be specified to customize
     *   what fields from the dataSource may be edited by default. For example the SearchForm
     *   class has this attribute set to "canFilter" which allows search forms to edit
     *   dataSource fields marked as canEdit:false (but not those marked as
     *   canFilter:false).
     * 
     *   Note that if canEdit is explicitly specified on a field in
     *   the DataBoundComponent.fields array, that property will be respected in preference to
     *   the canEditAttribute value. (See FormItem.canEdit, ListGridField.canEdit).
     *   Also note that individual dataBoundComponents may have additional logic around whether a field
     *   can be edited - for example ListGrid.canEditCell may be overridden.
     *  @type {string}
     *  @default "canEdit"
     */
    override var canEditFieldAttribute: String = definedExternally
    /**
     *  CSS Style to apply to the drag tracker when dragging occurs on this component.
     *  @type {CSSStyleName}
     *  @default "gridDragTracker"
     */
    override var dragTrackerStyle: String = definedExternally
    /**
     *  When isc.setScreenReaderMode is enabled,
     *   this invisible separator string is written out between each cell value. This
     *   string will be picked up by screen readers allowing them to more obviously identify
     *   to the user the different cell values as the contents of a row are read aloud. The
     *   ListGrid.screenReaderRowSeparator string if any will
     *   be written out after the last cell in a row to separate the last cell's value from
     *   the screen reader's announcement of the row's number and total number of rows in the grid
     *   (such as "3 of 20").
     * 
     *   This attribute may be set to null to disable the feature.
     * 
     *   Note that screen readers vary widely on which punctuation symbols are read aloud, and
     *   sometimes it depends on the context of the punctuation. However, the widely-used JAWS, NVDA,
     *   and VoiceOver screen readers all read the forward slash '/' as "slash".
     *   See Why Donâ€™t Screen Readers Always Read Whatâ€™s on the Screen? Part 1: Punctuation and Typographic Symbols
     *   for a table of findings on which punctuation symbols are read aloud by JAWS, NVDA,
     *   and VoiceOver.
     *  @type {HTMLString}
     *  @default "/"
     */
    open var screenReaderCellSeparator: String = definedExternally
    /**
     *  When isc.setScreenReaderMode is enabled,
     *   this invisible string will be written out after the last cell in a row. This
     *   string will be picked up by screen readers allowing them to more obviously identify
     *   to the user the end of the row's contents and the screen reader's announcement of the row's
     *   number and total number of rows in the grid (such as "3 of 20").
     * 
     *   This attribute may be set to null to disable writing out an invisible string at the
     *   end of each row.
     * 
     *   Note that screen readers vary widely on which punctuation symbols are read aloud, and
     *   sometimes it depends on the context of the punctuation. However, the widely-used JAWS, NVDA,
     *   and VoiceOver screen readers all pause briefly for a comma ',' that is within text.
     *   See Why Donâ€™t Screen Readers Always Read Whatâ€™s on the Screen? Part 1: Punctuation and Typographic Symbols
     *   for a table of findings on which punctuation symbols are read aloud by JAWS, NVDA,
     *   and VoiceOver.
     *  @type {HTMLString}
     *  @default ","
     */
    open var screenReaderRowSeparator: String = definedExternally
    /**
     *  If this grid has specified ListGrid.headerSpans, should field titles be
     *   prefixed with the titles of the headerSpans in which they are contained when
     *   using the FormulaBuilder or SummaryBuilder.
     *  @type {boolean}
     *  @default true
     */
    open var showHeaderSpanTitlesInFormulaBuilder: Boolean = definedExternally
    /**
     *  If this grid has specified ListGrid.headerSpans, and
     *   ListGrid.showHeaderSpanTitlesInFormulaBuilder is true,
     *   this string will be inserted between the headerSpan title(s) and the field title in the
     *   field chooser grid in the FormulaBuilder and SummaryBuilder.
     *  @type {string}
     *  @default " - "
     */
    open var formulaBuilderSpanTitleSeparator: String = definedExternally
    /**
     *  If this grid has specified ListGrid.headerSpans, should field titles be
     *   prefixed with the titles of the headerSpans in which they are contained when
     *   using the MultiSortDialog.
     *  @type {boolean}
     *  @default true
     */
    open var showHeaderSpanTitlesInSortEditor: Boolean = definedExternally
    /**
     *  If this grid has specified ListGrid.headerSpans, and
     *   ListGrid.showHeaderSpanTitlesInSortEditor is true, this
     *   string will be inserted between the headerSpan title(s) and the field title in the field
     *   chooser grid on the MultiSortDialog
     *  @type {string}
     *  @default " - "
     */
    open var sortEditorSpanTitleSeparator: String = definedExternally
    /**
     *  If this grid has specified ListGrid.headerSpans, should field titles be
     *   prefixed with the titles of the headerSpans in which they are contained when
     *   using the DataBoundComponent.editHilites.
     *  @type {boolean}
     *  @default true
     */
    open var showHeaderSpanTitlesInHiliteEditor: Boolean = definedExternally
    /**
     *  If this grid has specified ListGrid.headerSpans, and
     *   ListGrid.showHeaderSpanTitlesInHiliteEditor is true, this string will be inserted
     *   between the headerSpan title and the field title in the hiliteEditor field chooser
     *   grid.
     *  @type {string}
     *  @default " - "
     */
    open var hiliteEditorSpanTitleSeparator: String = definedExternally
    /**
     *  This property may be set to customize the css style for the
     *   hover shown on ListGrid.headerHover.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var headerHoverStyle: String = definedExternally
    /**
     *  This property may be set to customize the alignment for the
     *   hover shown on ListGrid.headerHover.
     *  @type {Alignment}
     *  @default null
     */
    open var headerHoverAlign: 
                               /**
                                *  Center within container.
                                *  Stick to left side of container.
                                *  Stick to right side of container.
                                */
                               String /* center |  left |  right */ = definedExternally
    /**
     *  This property may be set to customize the vertical alignment for the
     *   hover shown on ListGrid.headerHover.
     *  @type {VerticalAlignment}
     *  @default null
     */
    open var headerHoverVAlign: 
                                /**
                                 *  At the top of the container
                                 *  Center within container.
                                 *  At the bottom of the container
                                 */
                                String /* top |  center |  bottom */ = definedExternally
    /**
     *  This property may be set to customize the opacity for the
     *   hover shown on ListGrid.headerHover.
     *  @type {Integer}
     *  @default null
     */
    open var headerHoverOpacity: Number = definedExternally
    /**
     *  Optional default height for the
     *   hover shown on ListGrid.headerHover.
     *  @type {Integer}
     *  @default null
     */
    open var headerHoverHeight: Number = definedExternally
    /**
     *  Optional default width for the
     *   hover shown on ListGrid.headerHover.
     *  @type {Integer}
     *  @default null
     */
    open var headerHoverWidth: Number = definedExternally
    /**
     *  This property may be set to customize the wrap attribute for the
     *   hover shown on ListGrid.headerHover.
     *  @type {boolean}
     *  @default null
     */
    open var headerHoverWrap: Boolean = definedExternally
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid and
     *   ListGrid.canFreezeFields is true, this string will be shown as the
     *   title for the menu item to freeze fields on the right of the scrollable body.
     *  @type {string}
     *  @default "Freeze on right"
     */
    open var freezeOnRightText: String = definedExternally
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid and
     *   ListGrid.canFreezeFields is true, this string will be shown as the
     *   title for the menu item to freeze fields on the left of the scrollable body.
     *  @type {string}
     *  @default "Freeze on left"
     */
    open var freezeOnLeftText: String = definedExternally
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid, this
     *   attribute will be shown as the menu item title to sort a field in ascending order.
     *  @type {string}
     *  @default "Sort Ascending"
     */
    open var sortFieldAscendingText: String = definedExternally
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid, this
     *   attribute will be shown as the menu item title to sort a field in descending order.
     *  @type {string}
     *  @default "Sort Descending"
     */
    open var sortFieldDescendingText: String = definedExternally
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid, this
     *   attribute will be shown as the menu item title to clear an existing sort on this field.
     *  @type {string}
     *  @default "Clear Sort"
     */
    open var clearSortFieldText: String = definedExternally
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid, this
     *   attribute will be shown as the menu item title to clear any existing sort on all fields. This
     *   menu-item is displayed only in the context menu for the sorter button.
     *  @type {string}
     *  @default "Clear All Sorting"
     */
    open var clearAllSortingText: String = definedExternally
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid,
     *   and a ListGrid.showFilterEditor is visible, this
     *   attribute will be shown as the menu item title to clear any existing filter. This
     *   menu-item is displayed only in the context menu for the sorter button.
     *  @type {string}
     *  @default "Clear Filter"
     */
    open var clearFilterText: String = definedExternally
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid,
     *   and multi-sorting is enabled, this attribute is used as the title for a menu item that opens
     *   a MultiSortDialog to configure the sort-specification for this grid. This
     *   menu-item is displayed only in the context menu for the sorter button.
     *  @type {string}
     *  @default "Configure Sort..."
     */
    open var configureSortText: String = definedExternally
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid,
     *   and multi-grouping is enabled, this attribute is used as the title for a menu item that opens
     *   a MultiGroupDialog to configure the grouping for this grid.
     *  @type {string}
     *  @default "Configure Grouping..."
     */
    open var configureGroupingText: String = definedExternally
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid,
     *   and user-driven auto fit of fields is enabled via ListGridField.canAutoFitWidth or
     *   ListGrid.canAutoFitFields, this attribute will be shown as the menu
     *   item title for an item to perform a one-time autoFit of the field to its title or content
     *   via a call to ListGrid.autoFitField.
     *  @type {string}
     *  @default "Auto Fit"
     */
    open var autoFitFieldText: String = definedExternally
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid,
     *   and ListGrid.canAutoFitFields is true, this attribute will be shown as the menu
     *   item title for an item to perform a one-time autoFit of all visible fields via
     *   the ListGrid.autoFitField method.
     *  @type {string}
     *  @default "Auto Fit All Columns"
     */
    open var autoFitAllText: String = definedExternally
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid, and
     *   ListGrid.canPickFields is true, this
     *   attribute will be shown as the title for the menu item which contains a submenu with items
     *   allowing the user to show and hide fields in the grid.
     *  @type {string}
     *  @default "Columns"
     */
    open var fieldVisibilitySubmenuTitle: String = definedExternally
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid and
     *   ListGrid.canFreezeFields is true, this string will be shown as the
     *   title for the menu item to freeze a currently unfrozen field.
     * 
     *   This is a dynamic string - text within &#36;{...} will be evaluated as JS code
     *   when the message is displayed, with title available as a variable containing
     *   the field title.
     * 
     *   Default value returns "Freeze " + the field's summary title.
     *  @type {HTMLString}
     *  @default "Freeze ${title}"
     */
    open var freezeFieldText: String = definedExternally
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid and
     *   ListGrid.canFreezeFields is true, this string will be shown as the
     *   title for the menu item to unfreeze a currently frozen field.
     * 
     *   This is a dynamic string - text within &#36;{...} will be evaluated as JS code
     *   when the message is displayed, with title available as a variable containing
     *   the field title.
     * 
     *   Default value returns "Unfreeze " + the field's summary title.
     *  @type {HTMLString}
     *  @default "Unfreeze ${title}"
     */
    open var unfreezeFieldText: String = definedExternally
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid and
     *   ListGrid.canGroupBy is true, this string will be shown as the
     *   title for the menu item to toggle the group by setting for a field.
     * 
     *   This is a dynamic string - text within &#36;{...} will be evaluated as JS code
     *   when the message is displayed, with title available as a variable containing
     *   the field title.
     * 
     *   Default value returns "Group by " + the field's summary title.
     *  @type {HTMLString}
     *  @default "Group by ${title}"
     */
    open var groupByText: String = definedExternally
    /**
     *  If we're showing a ListGrid.showHeaderContextMenu for this grid, and
     *   ListGrid.isGrouped is true, this
     *   attribute will be shown as the title for the menu item to ungroup the grid.
     *  @type {string}
     *  @default "Ungroup"
     */
    open var ungroupText: String = definedExternally
    /**
     *  When true, indicates that this ListGrid supports sorting on multiple fields. Note that even
     *   when set to true, multi-field sorting may not be available if the grid is databound and the
     *   ${isc.DocUtils.linkForRef('attr:DataSource.canMultiSort','DataSource doesn\'t support multi-sort')}, or if sorting for a
     *   field is ListGridField.canSortClientOnly but not all data is available.
     *  @type {boolean}
     *  @default true
     */
    open var canMultiSort: Boolean = definedExternally
    /**
     *  Class level defaults to apply to the MultiSortDialog which gets automatically
     *   generated when DataBoundComponent.askForSort is called.
     * 
     *   See also ListGrid.showHeaderSpanTitlesInSortEditor and ListGrid.sortEditorSpanTitleSeparator
     *  @type {MultiSortDialog}
     *  @default null
     */
    override var multiSortDialogDefaults: MultiSortDialog = definedExternally
    /**
     *  Properties to apply to the MultiSortDialog which gets automatically generated
     *   when DataBoundComponent.askForSort is called.
     * 
     *   See also ListGrid.showHeaderSpanTitlesInSortEditor and ListGrid.sortEditorSpanTitleSeparator
     *  @type {MultiSortDialog}
     *  @default null
     */
    override var multiSortDialogProperties: MultiSortDialog = definedExternally
    /**
     *  When true, indicates that this ListGrid supports grouping on multiple fields.
     *  @type {boolean}
     *  @default false
     */
    open var canMultiGroup: Boolean = definedExternally
    /**
     *  An array of SortSpecifier objects used to set up the initial sort configuration for
     *   this grid. If specified, this will be used instead of any ListGrid.sortField specified.
     *  @type {Array<Partial<SortSpecifier>>}
     *  @default null
     */
    open var initialSort: Array<dynamic> = definedExternally
    /**
     *  When multiple fields are sorted, the Style to apply to the numeral that appears after the
     *   sort-arrows in the header-buttons of sorted fields.
     *  @type {CSSStyleName}
     *  @default "sortNumeral"
     */
    open var sortNumeralStyle: String = definedExternally
    /**
     *  When multiple fields are sorted, set this to false to hide the sort-numeral
     *   displayed by default after the sort-arrows in the header-buttons of sorted fields.
     *  @type {boolean}
     *  @default null
     */
    open var showSortNumerals: Boolean = definedExternally
    /**
     *  Name of the SmartClient Class to be used when creating charts. Must support the
     *   Chart interface.
     *  @type {string}
     *  @default "FacetChart"
     */
    open var chartConstructor: String = definedExternally
    /**
     *  Default type of chart to plot.
     *  @type {ChartType}
     *  @default "Column"
     */
    open var chartType: 
                        /**
                         *  Values represented by area, with stacked values representing multiple          facet values. This is equivalent to ChartType "Line" with stacking enabled.
                         *  Values represented by vertical columns. Typically supports stacking to         represent two facets. May support simultaneous stacking and clustering for
                         *           3 facets.
                         *  Values represented by horizontal bars. Typically supports stacking to         represent two facets. May support simultaneous stacking and clustering for
                         *           3 facets.
                         *  Values represented by a lines between data points, or stacked areas for         multiple facets.
                         *  Values represented on a circular background by a line around the center, or         stacked areas for multiple facets
                         *  Circular chart with wedges representing values. Multiple or stacked pies         for multiple facets.
                         *  Like a pie chart with a central hole. Multiple or stacked doughnuts for         multiple facets.
                         *  A chart with two continuous numeric axes and up to one discrete facet.
                         *  A chart with two continuous numeric axes and up to one discrete facet         that also displays values from a third continuous, numeric domain
                         *           represented as the sizes of the data point shapes.
                         *  Like a column chart, except instead of showing stacked or clustered values         for each position on the horizontal axis, the data values are used together
                         *           with the associated FacetChart.endValueMetric values to show a series
                         *           of line segments.
                         */
                        String /* Area |  Column |  Bar |  Line |  Radar |  Pie |  Doughnut |  Scatter |  Bubble |  Histogram */ = definedExternally
    /**
     *  If this is ListGrid.groupBy and has
     *   frozenFields, should the group title show in the
     *   frozen or unfrozen body?
     * 
     *   Setting this property to false will cause the group title to show in the
     *   unfrozen body in this case, meaning it will appear to the right of the frozen fields,
     *   and scroll horizontally as the user scrolls the unfrozen fields.
     *   This can be useful for grids where there isn't
     *   enough available space to show the group title text in the frozen body.
     * 
     *   Note that if ListGrid.groupTitleField is explicitly set, or
     *   ListGrid.showGroupSummaryInHeader is true, this property has no
     *   effect. In this case rather than the group title showing in a single cell spanning
     *   multiple other fields, it will be rendered into a specific column.
     *  @type {boolean}
     *  @default true
     */
    open var showGroupTitleInFrozenBody: Boolean = definedExternally
    /**
     *  If this listGrid supports ListGrid.canGroupBy, setting this property will cause
     *   the grid to render an extra row at the end of each group when grouped, containing summary
     *   information for the fields.
     *   Summary information will be calculated by the ListGridField.getGroupSummary method
     *   if specified, otherwise via the specified ListGridField.summaryFunction.
     *  @type {boolean}
     *  @default false
     */
    open var showGroupSummary: Boolean = definedExternally
    /**
     *  If this grid is ListGrid.groupByField, and
     *   ListGrid.showGroupSummary is true, this attribute may be set to an array of
     *   groupBy field names for which group summaries should appear.
     * 
     *   This is particularly useful for listGrids grouped by more than one field as it allows developers
     *   to display the group summary for a particular nested group without showing a summary for every
     *   level of the tree.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var groupByFieldSummaries: Array<dynamic> = definedExternally
    /**
     *  ListGridRecord.customStyle for the group-level summary row displayed when
     *   ListGrid.showGroupSummary is true.
     *  @type {CSSStyleName}
     *  @default "gridSummaryCell"
     */
    open var groupSummaryStyle: String = definedExternally
    /**
     *  Class-level defaults to apply to the MultiGroupDialog which gets automatically
     *   generated when ListGrid.configureGrouping is called.
     *  @type {MultiGroupDialog}
     *  @default null
     */
    open var multiGroupDialogDefaults: MultiGroupDialog = definedExternally
    /**
     *  Properties to apply to the MultiGroupDialog which gets automatically
     *   generated when ListGrid.configureGrouping is called.
     *  @type {MultiGroupDialog}
     *  @default null
     */
    open var multiGroupDialogProperties: MultiGroupDialog = definedExternally
    /**
     *  If set to true, an advanced field picker based on the FieldPicker will be shown instead
     *   of the column picker submenu if there are more fields in the grid than
     *   ListGrid.advancedFieldPickerThreshold.
     * 
     *   When there are large numbers of available fields, the FieldPicker-based interface is more
     *   usable for both defining visible fields and defining field order.
     *  @type {boolean}
     *  @default false
     */
    open var useAdvancedFieldPicker: Boolean = definedExternally
    /**
     *  If set to true, the ListGrid.useAdvancedFieldPicker provides
     *   an interface allowing users to modify fields' titles.
     * 
     *   Note that when enabled, the ListGrid.getFieldState for this component
     *   will include field titles.
     *  @type {boolean}
     *  @default false
     */
    open var canEditTitles: Boolean = definedExternally
    /**
     *  Instance of FieldPickerWindow used if ListGrid.useAdvancedFieldPicker is set.
     *  @type {FieldPickerWindow}
     *  @default null
     */
    open var fieldPickerWindow: FieldPickerWindow = definedExternally
    /**
     *  Names of properties on ListGridField for which the FieldPicker should
     *   show an editing interface, for convenience.
     * 
     *   For example, specify ["frozen", "decimalPrecision"] to allow end users to modify
     *   ListGridField.frozen and ListGridField.decimalPrecision respectively.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var fieldPickerFieldProperties: Array<dynamic> = definedExternally
    /**
     *  When ListGrid.useAdvancedFieldPicker is set, total number of available fields that must be
     *   present in the grid before the advanced field picker interface is used instead of the normal
     *   columns submenu.
     * 
     *   Set to 0 to have the advanced picker always used (when useAdvancedFieldPicker is true).
     *  @type {Integer}
     *  @default "25"
     */
    open var advancedFieldPickerThreshold: Number = definedExternally
    /**
     *  When set to false, sample values of the FieldPicker are never shown. This property applies to the entire FieldPicker.
     *  @type {boolean}
     *  @default true
     */
    open var fieldPickerShowSampleValues: Boolean = definedExternally
    /**
     *  When AutoTest.getElement is used to parse locator strings generated by
     *   AutoTest.getLocator for a cell in this grid, how should the row be identified?
     * 
     *   Note that getLocator() will actually store all available information about the row in
     *   the generated string -- this attribute effects how a stored string will be parsed only.
     * 
     *   Valid options area:
     * 
     * 
     *  - "primaryKey" Only applies to databound grids: If the cell in question has
     *   a primary key cell value, use it to identify cells in autoTest locator strings.
     * 
     *  - "titleField" If the cell in question has a value for the
     *   ListGrid.getTitleField, use it to identify cells in autoTest
     *   locator strings
     * 
     *  - "targetCellValue" Identify rows by storing the cell value for the target
     *   row / field in autoTest locator strings
     * 
     *  - "index"The rowNum will be used to identify the row.
     * 
     *   If unset, default behavior is to identify by primary key (if available), otherwise by
     *   titleField (if available), otherwise by cell value (if available), and lastly by index.
     *  @type {string}
     *  @default null
     */
    open var locateRowsBy: String = definedExternally
    /**
     *  When AutoTest.getElement is used to parse locator strings generated by
     *   AutoTest.getLocator for a cell in this grid, how should the column be identified?
     * 
     *   Note that getLocator() will actually store all available information about the column in
     *   the generated string -- this attribute effects how a stored string will be parsed only.
     * 
     *   Valid options area:
     * 
     * 
     *  - "fieldName" Attempt to identify by fieldName.
     * 
     *  - "index" Attempt to identify by colNum (index in the fields array).
     * 
     *   If unset, default behavior is to identify by fieldName (if available), otherwise by index.
     *  @type {string}
     *  @default null
     */
    open var locateColumnsBy: String = definedExternally
    /**
     *  Before we start editing values in this DataBoundComponent, should we perform a deep clone
     *   of the underlying values. See DataSource.deepCloneOnEdit for details of what this means.
     * 
     *   If this value is not explicitly set, it defaults to the value of DataSource.deepCloneOnEdit.
     *   This value can be overridden per-field with DataSourceField.deepCloneOnEdit.
     * 
     *   Like the other deepCloneOnEdit settings, this flag only has an effect if you are
     *   editing a values object that contains nested objects or arrays, using
     *   Canvas.dataPaths.
     *  @type {boolean}
     *  @default null
     */
    override var deepCloneOnEdit: Boolean = definedExternally
    /**
     *  When editing values in this DataBoundComponent, should we perform a deep clone of values
     *   that are not associated with a field (ie, attributes on the record that do not map to a
     *   component field either directly by name, or by FormItem.dataPath. If this value is
     *   not explicitly set, it defaults to the value of
     *   DataSource.deepCloneNonFieldValuesOnEdit if there is a dataSource, or to the value
     *   of the static DataSource.deepCloneNonFieldValuesOnEdit if there is no
     *   dataSource.
     * 
     *   Like the other deepCloneOnEdit settings, this flag only has an effect if you are
     *   editing a values object that contains nested objects or arrays.
     *  @type {boolean}
     *  @default null
     */
    override var deepCloneNonFieldValuesOnEdit: Boolean = definedExternally
    /**
     *  Whether to show fields marked hidden:true when a DataBoundComponent is given a
     *   DataSource but no component.fields.
     * 
     *   The hidden property is used on DataSource fields to mark fields that are
     *   never of meaning to an end user.
     *  @type {boolean}
     *  @default false
     */
    override var showHiddenFields: Boolean = definedExternally
    /**
     *  Whether to show fields of non-atomic types when a DataBoundComponent is given a
     *   DataSource but no component.fields.
     * 
     *   If true, the component will show fields that declare a complex type, for example, a
     *   field 'shippingAddress' that declares type 'Address', where 'Address' is the ID of a
     *   DataSource that declares the fields of a shipping address (city, street name, etc).
     * 
     *   Such fields may need custom formatters or editors in order to create a usable interface,
     *   for example, an Address field in a ListGrid might use a custom formatter to combine the
     *   relevant fields of an address into one column, and might use a pop-up dialog for
     *   editing.
     *  @type {boolean}
     *  @default true
     */
    override var showComplexFields: Boolean = definedExternally
    /**
     *  DSRequest.operationId this component should use when performing fetch operations.
     *  @type {string}
     *  @default null
     */
    override var fetchOperation: String = definedExternally
    /**
     *  DSRequest.operationId this component should use when performing update operations.
     *  @type {string}
     *  @default null
     */
    override var updateOperation: String = definedExternally
    /**
     *  DSRequest.operationId this component should use when performing add operations.
     *  @type {string}
     *  @default null
     */
    override var addOperation: String = definedExternally
    /**
     *  DSRequest.operationId this component should use when performing remove operations.
     *  @type {string}
     *  @default null
     */
    override var removeOperation: String = definedExternally
    /**
     *  The list of field-names to export. If provided, the field-list in the exported output is
     *   limited and sorted as per the list.
     * 
     *   If exportFields is not provided, the exported output includes all visible fields
     *   from this component, sorted as they appear.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    override var exportFields: Array<dynamic> = definedExternally
    /**
     *  Setting exportAll to true prevents the component from passing it's list of fields to the
     *   export call. The result is the export of all visible fields from DataSource.fields.
     * 
     *   If exportAll is false, an export operation will first consider
     *   DataBoundComponent.exportFields, if it's set, and fall back on all visible fields from
     *   DataSource.fields otherwise.
     *  @type {boolean}
     *  @default false
     */
    override var exportAll: Boolean = definedExternally
    /**
     *  If Summary rows exist for this component, whether to include them when exporting client data.
     *  @type {boolean}
     *  @default true
     */
    override var exportIncludeSummaries: Boolean = definedExternally
    /**
     *  Flag controlling when to recategorize records being dropped on a databound
     *   component from another databound component.
     *  @type {RecategorizeMode}
     *  @default "checked"
     */
    override var dragRecategorize: 
                                   /**
                                    *  recategorize is always applied
                                    *  recategorize if normal checks pass
                                    *  never recategorize
                                    */
                                   String /* always |  checked |  never */ = definedExternally
    /**
     *  If set, detect and prevent duplicate records from being transferred to this component, either via
     *   drag and drop or via DataBoundComponent.transferSelectedData. When a duplicate transfer is detected,
     *   a dialog will appear showing the DataBoundComponent.duplicateDragMessage.
     * 
     *   If the component either does not have a DataSource or has a DataSource with no
     *   DataSourceField.primaryKey declared, duplicate checking is off by
     *   default. If duplicate checking is enabled, it looks for an existing record in the dataset
     *   that has all of the properties of the dragged record, and considers that a duplicate.
     * 
     *   For DragDataAction:"copy" where the target DataSource is related to the source
     *   DataSource by foreignKey, a duplicate means that the target list, as filtered by the current
     *   criteria, already has a record whose value for the foreignKey field matches the
     *   primaryKey of the record being transferred.
     * 
     *   For example, consider dragging "employees" to "teams", where "teams" has a field
     *   "teams.employeeId" which is a foreignKey pointing to "employees.id", and the target
     *   grid has search criteria causing it to show all the members of one team. A duplicate -
     *   adding an employee to the same team twice - is when the target grid's dataset contains an
     *   record with "employeeId" matching the "id" field of the dropped employee.
     *  @type {boolean}
     *  @default null
     */
    override var preventDuplicates: Boolean = definedExternally
    /**
     *  Message to show when a user attempts to transfer duplicate records into this component, and
     *   DataBoundComponent.preventDuplicates is enabled.
     * 
     *   If set to null, duplicates will not be reported and the dragged duplicates will not be
     *   saved.
     *  @type {string}
     *  @default "Duplicates not allowed"
     */
    override var duplicateDragMessage: String = definedExternally
    /**
     *  Indicates whether the text of the offlineMessage property should be displayed if no data is
     *   available because we do not have a suitable offline cache
     *  @type {boolean}
     *  @default true
     */
    override var showOfflineMessage: Boolean = definedExternally
    /**
     *  Message to display when this DataBoundComponent attempts to load data that is not available
     *   because the browser is currently offline. Depending on the component, the message is either
     *   displayed in the component's body, or in a pop-up warning dialog.
     *  @type {string}
     *  @default "This data not available while offline"
     */
    override var offlineMessage: String = definedExternally
    /**
     *  Message to display when this DataBoundComponent attempts to save data while the application
     *   is offline.
     *  @type {string}
     *  @default "Data cannot be saved because you are not online"
     */
    override var offlineSaveMessage: String = definedExternally
    /**
     *  Indicates whether to add "drop values" to items dropped on this component, if both
     *       the source and target widgets are databound, either to the same DataSource or
     *       to different DataSources that are related via a foreign key. "Drop values" are
     *       properties of the dropped item that you wish to change (and persist) as a
     *       result of the item being dropped on this grid.
     * 
     *       If this value is true and this component is databound, DataBoundComponent.getDropValues will
     *       be called for every databound item dropped on this grid, and an update performed
     *       on the item
     *  @type {boolean}
     *  @default true
     */
    override var addDropValues: Boolean = definedExternally
    /**
     *  When an item is dropped on this component, and DataBoundComponent.addDropValues is true and both
     *       the source and target widgets are databound, either to the same DataSource or
     *       to different DataSources that are related via a foreign key, this object
     *       provides the "drop values" that SmartClient will apply to the dropped object
     *       before updating it.
     * 
     *       If this property is not defined, SmartClient defaults to returning the selection
     *       criteria currently in place for this component. Thus, any databound items (for example,
     *       rows from other grids bound to the same DataSource) dropped on the grid will,
     *       by default, be subjected to an update that makes them conform to the grid's
     *       current filter criteria.
     *  @type {object}
     *  @default null
     */
    override var dropValues: dynamic = definedExternally
    /**
     *  Does this component represent singular or multiple "records" objects?
     *   Options are "multiple" or "single", or "either"
     *  @type {string}
     *  @default "multiple"
     */
    override var dataArity: String = definedExternally
    /**
     *  Indicates whether or not this component will load its data
     *   DataSource.progressiveLoading.
     *  @type {boolean}
     *  @default null
     */
    override var progressiveLoading: Boolean = definedExternally
    /**
     *  The useFlatFields flag causes all simple type fields anywhere in a nested
     *   set of DataSources to be exposed as a flat list for form binding.
     * 
     *   useFlatFields is typically used with imported metadata, such as
     *   XMLTools.loadXMLSchema from a
     *   XMLTools.loadWSDL, as a means of eliminating levels of XML
     *   nesting that aren't meaningful in a user interface, without the cumbersome and fragile
     *   process of mapping form fields to XML structures.
     * 
     *   For example, having called WebService.getInputDS to retrieve the input message
     *   schema for a web service operation whose input message looks like this:
     * 
     *   &lt;FindServices&gt;
     *     &lt;searchFor&gt;search text&lt;/searchFor&gt;
     *     &lt;Options&gt;
     *       &lt;caseSensitive&gt;false&lt;/caseSensitive&gt;
     *     &lt;/Options&gt;
     *     &lt;IncludeInSearch&gt;
     *       &lt;serviceName&gt;true&lt;/serviceName&gt;
     *       &lt;documentation&gt;true&lt;/documentation&gt;
     *       &lt;keywords&gt;true&lt;/keywords&gt;
     *     &lt;/IncludeInSearch&gt;
     *   &lt;/FindServices&gt;
     * 
     *   Setting useFlatFields on a DynamicForm that is bound to this input
     *   message schema would result in 5 FormItem reflecting the 5 simple type
     *   fields in the message.
     * 
     *   For this form, the result of DynamicForm.getValues might look
     *   like:
     * 
     *   {
     *    searchFor: "search text",
     *    caseSensitive: false,
     *    serviceName: true,
     *    documentation : true,
     *    keywords : true
     *   }
     *   When contacting a WebService, these values can be automatically
     *   mapped to the structure of the input message for a web service operation by setting
     *   WSRequest.useFlatFields (for use with WebService.callOperation) or by setting
     *   DSRequest.useFlatFields (for use with a DataSource that is
     *   wsdlBinding via
     *   OperationBinding.wsOperation).
     * 
     *   Using these two facilities in conjunction (component.useFlatFields and
     *   request.useFlatFields) allows gratuitous nesting to be consistently bypassed in both the user
     *   presentation and when providing the data for XML messages.
     * 
     *   You can also set OperationBinding.useFlatFields to automatically enable
     *   "flattened" XML serialization (request.useFlatFields) for all DataSource requests of a
     *   particular operationType.
     * 
     *   Note that useFlatFields is not generally recommended for use with structures
     *   where multiple simple type fields exist with the same name, however if used with such a
     *   structure, the first field to use a given name wins. "first" means the first field
     *   encountered in a depth first search. "wins" means only the first field will be present as a
     *   field when data binding.
     *  @type {boolean}
     *  @default null
     */
    override var useFlatFields: Boolean = definedExternally
    /**
     *  If this attribute is set to false, any attributes in the component's values object that do
     *   not map to a DataSourceField or FormItem will not
     *   be tracked when checking for changes. You should only set this flag to false if you know
     *   that your code does not store additional, non-field values in the component's data, or if
     *   you do store such values, but you don't care that they are not checked for changes.
     *   This flag is primarily provided to avoid performance issues in cases where developers are
     *   storing large numbers of extra attributes in component data; generally speaking, you should
     *   only consider setting it to false if you have a use case like this.
     * 
     *   Note, even with this flag set to false, these extra values will still be managed and stored
     *   by SmartClient; they just will not be checked when the component's values are inspected to
     *   see if they have changed. This may lead to methods like ListGrid.rowHasChanges
     *   returning false when you are expecting it to return true. In this case, either switch this
     *   flag back to true (or just do not set it false), or provide a field definition for the
     *   affected attribute(s).
     *  @type {boolean}
     *  @default true
     */
    override var canChangeNonFieldValues: Boolean = definedExternally
    /**
     *  Criteria that are never shown to or edited by the user and are cumulative with any criteria
     *   provided via DataBoundComponent.initialCriteria, method:DataBoundComponent.setCriteria
     *   etc.
     *  @type {Criteria}
     *  @default null
     */
    override var implicitCriteria: dynamic = definedExternally
    /**
     *  Hilites to be applied to the data for this component. See hiliting.
     *  @type {Array<Partial<Hilite>>}
     *  @default null
     */
    override var hilites: Array<dynamic> = definedExternally
    /**
     *  Marker that can be set on a record to flag that record as hilited. Should be set to a value
     *   that matches Hilite.id for a hilite defined on this component.
     *  @type {string}
     *  @default "_hilite"
     */
    override var hiliteProperty: String = definedExternally
    /**
     *  Initial hilite state for the grid.
     * 
     *   ListGrid.viewState can be used to initialize all view properties of the grid.
     *   When doing so, hiliteState is not needed because viewState
     *   includes it as well. If both are provided, hiliteState has priority for
     *   hilite state.
     * 
     * 
     *   To retrieve current state call DataBoundComponent.getHiliteState.
     * 
     *  @type {string}
     *  @default null
     */
    override var hiliteState: String = definedExternally
    /**
     *  The strategy to use when generating names for new fields in this component. The default
     *   strategy, "simple", combines the field-type with an index maintained by field-type and
     *   component instance. For example, "formulaField1".
     *  @type {FieldNamingStrategy}
     *  @default "simple"
     */
    override var fieldNamingStrategy: 
                                      /**
                                       *  generate names in the format fieldTypeX, where field type might be     "formulaField" and X is an index specific to the field-type and component instance
                                       *  generates a UUID for all generated field names
                                       */
                                      String /* simple |  uuid */ = definedExternally
    /**
     *  Text for a menu item allowing users to edit grid highlights.
     *  @type {string}
     *  @default "Edit Highlights..."
     */
    override var editHilitesText: String = definedExternally
    /**
     *  The title for the DataBoundComponent.editHilites dialog.
     *  @type {string}
     *  @default "Edit Highlights"
     */
    override var editHilitesDialogTitle: String = definedExternally
    /**
     *  The title for the DataBoundComponent.fieldEditorWindow used to edit calculated
     *   fields.
     * 
     *   This is a dynamic string - text within &#36;{...} are dynamic variables and will
     *   be evaluated as JS code whenever the message is displayed.
     * 
     *   Two dynamic variables are available - "builderType", either Formula or Summary, and
     *   "fieldTitle", which is the title of the calculated field being edited.
     *  @type {HTMLString}
     *  @default "${builderType} Editor [${fieldTitle}]"
     */
    override var fieldEditorWindowTitle: String = definedExternally
    /**
     *  The Window used to edit calculated fields for this component.
     *  @type {Window}
     *  @default null
     */
    override var fieldEditorWindow: Window = definedExternally
    /**
     *  This component's HiliteEditor instance used to allow the user to create, modify, or delete
     *   hilites.
     * 
     *   The following autoChildUsage apply:
     * 
     * 
     *  - DataBoundComponent.hiliteIcons for HiliteEditor.hiliteIcons
     * 
     *  @type {HiliteEditor}
     *  @default null
     */
    override var hiliteEditor: HiliteEditor = definedExternally
    /**
     *  Text for a menu item allowing users to add a formula field
     *  @type {string}
     *  @default "Add formula column..."
     */
    override var addFormulaFieldText: String = definedExternally
    /**
     *  Text for a menu item allowing users to edit a formula field
     *  @type {string}
     *  @default "Edit formula..."
     */
    override var editFormulaFieldText: String = definedExternally
    /**
     *  Text for a menu item allowing users to remove a formula field
     *  @type {string}
     *  @default "Remove formula"
     */
    override var removeFormulaFieldText: String = definedExternally
    /**
     *  Text for a menu item allowing users to add a formula field
     *  @type {string}
     *  @default "Add summary column..."
     */
    override var addSummaryFieldText: String = definedExternally
    /**
     *  Text for a menu item allowing users to edit the formatter for a field
     *  @type {string}
     *  @default "Edit summary format..."
     */
    override var editSummaryFieldText: String = definedExternally
    /**
     *  Text for a menu item allowing users to remove a summary field
     *  @type {string}
     *  @default "Remove summary format..."
     */
    override var removeSummaryFieldText: String = definedExternally
    /**
     *  Designates a field of FieldType:"image" as the field to use when rendering a
     *   record as an image, for example, in a TileGrid.
     * 
     *   This attribute has the same function as DataSource.iconField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var iconField: String = definedExternally
    /**
     *  Name of the field that has the second most pertinent piece of textual information in the
     *   record, for use when a DataBoundComponent needs to show a short summary of a record.
     * 
     *   This attribute has the same function as DataSource.infoField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var infoField: String = definedExternally
    /**
     *  Name of the field that has the most pertinent numeric, date, or enum value, for use when a
     *   DataBoundComponent needs to show a short summary of a record.
     * 
     *   This attribute has the same function as DataSource.dataField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var dataField: String = definedExternally
    /**
     *  Name of the field that has a long description of the record, or has the primary text data
     *   value for a record that represents an email message, SMS, log or similar.
     * 
     *   This attribute has the same function as DataSource.descriptionField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var descriptionField: String = definedExternally
    /**
     *  The message to display to the user if an export of a DataBoundComponent's data is attempted
     *   while the DataBoundComponent's data is null or an empty list.
     *  @type {string}
     *  @default "You are attempting to export an empty dataset"
     */
    override var emptyExportMessage: String = definedExternally
    /**
     *  For databound components that support editing, the error message for a failed validator
     *   that does not specify its own errorMessage.
     *  @type {HTMLString}
     *  @default "Invalid value"
     */
    override var unknownErrorMessage: String = definedExternally
    /**
     *  A message to display to the user if server-side validation fails with an error but the
     *   server did not provide an error message
     *  @type {string}
     *  @default "Error during validation; no error details were provided"
     */
    override var noErrorDetailsMessage: String = definedExternally
    /**
     *   Retrieves data from the DataSource that matches the specified criteria.
     * 
     *   When fetchData() is first called, if data has not already been provided via
     *   ListGrid.setData, this method will create a ResultSet, which will be
     *   configured based on component settings such as DataBoundComponent.fetchOperation
     *   and DataBoundComponent.dataPageSize, as well as the general purpose
     *   ListGrid.dataProperties. The created ResultSet will automatically send a DSRequest
     *   to retrieve data from ListGrid.dataSource, and from then on will
     *   automatically manage paging through large datasets, as well as performing filtering and
     *   sorting operations inside the browser when possible - see the ResultSet docs for
     *   details.
     * 
     *   NOTE: do not use both DataBoundComponent.autoFetchData and a
     *   call to fetchData() - this may result in two DSRequests to fetch data. Use
     *   either DataBoundComponent.autoFetchData and Criteria or a manual call to fetchData()
     *   passing criteria.
     * 
     *   Whether a ResultSet was automatically created or provided via ListGrid.setData, subsequent
     *   calls to fetchData() will simply call ResultSet.setCriteria.
     * 
     *   Changes to criteria may or may not result in a DSRequest to the server due to
     *   ResultSet.useClientFiltering. You can call
     *   DataBoundComponent.willFetchData to determine if new criteria will result in a
     *   server fetch.
     * 
     *   If you need to force data to be re-fetched, you can call
     *   ListGrid.invalidateCache and new data will automatically be fetched
     *   from the server using the current criteria and sort direction. NOTE: when using
     *   invalidateCache() there is no need to also call fetchData()
     *   and in fact this could produce unexpected results.
     * 
     *   This method takes an optional callback parameter (set to a DSCallback) to fire when
     *   the fetch completes. Note that this callback will not fire if no server fetch is performed.
     *   In this case the data is updated synchronously, so as soon as this method completes you
     *   can interact with the new data. If necessary, you can use
     *   DataBoundComponent.willFetchData to determine whether or not a server
     *   fetch will occur when fetchData() is called with new criteria.
     * 
     *   In addition to the callback parameter for this method, developers can use
     *   ListGrid.dataArrived to be notified every time data is loaded.
     * 
     *   By default, this method assumes a TextMatchStyle of "exact"; that can be overridden
     *   by supplying a different value in the requestProperties parameter.
     *   See DataBoundComponent.willFetchData;
     * 
     * 
     *  @param {Criteria=} Search criteria. If a DynamicForm is passed                     in as this argument instead of a raw criteria                      object, will be derived by calling                      DynamicForm.getValuesAsCriteria
     *  @param {DSCallback=} callback to invoke when a fetch is complete. Fires                     only if server contact was required
     *  @param {DSRequest=} additional properties to set on the DSRequest                     that will be issued
     */
    open fun fetchData(criteria: dynamic?, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Sends the current filter criteria and sort direction to the server, then exports data in the
     *   requested DSRequest.exportAs.
     * 
     *   A variety of DSRequest settings, such as
     *   DSRequest.exportAs and DSRequest.exportFilename, affect the
     *   exporting process: see DSRequest.exportResults for further detail.
     * 
     *   Note that data exported via this method does not include any client-side formatting and
     *   relies on both the SmartClient server and server-side DataSources. To export client-data
     *   with formatters applied,
     *   see ListGrid.exportClientData, which still requires the
     *   SmartClient server but does not rely on server-side DataSource definitions (.ds.xml files).
     * 
     *   For more information on exporting data, see DataSource.exportData.
     * 
     * 
     *  @param {DSRequest=} additional properties to set on the DSRequest                      that will be issued
     *  @param {DSCallback=} callback to invoke on completion. Note that this parameter                 only applies where DSRequest.exportToClient is                  explicitly set to false, because file downloads do not                  provide ordinary SmartClient callbacks
     */
    override fun exportData(requestProperties: DSRequest?, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?)): Unit = definedExternally
    /**
     *   Retrieves data that matches the provided criteria and displays the matching data in this
     *   component.
     * 
     *   This method behaves exactly like ListGrid.fetchData except that
     *   DSRequest.textMatchStyle is automatically set to "substring" so that String-valued
     *   fields are matched by case-insensitive substring comparison.
     * 
     * 
     *  @param {Criteria=} Search criteria.            If a DynamicForm is passed in as this argument            instead of a raw criteria object, will be derived by calling            DynamicForm.getValuesAsCriteria
     *  @param {DSCallback=} callback to invoke when a fetch is complete. Fires                     only if server contact was required; see                      ListGrid.fetchData for details
     *  @param {DSRequest=} for databound components only - optional              additional properties to set on the DSRequest that will be issued
     */
    open fun filterData(criteria: dynamic?, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Based on the relationship between the DataSource this component is bound to and the
     *   DataSource specified as the "schema" argument, call fetchData() to retrieve records in this
     *   grid that are related to the passed-in record.
     * 
     *   Relationships between DataSources are declared via DataSourceField.foreignKey.
     * 
     *   For example, given two related DataSources "orders" and "orderItems", where we want to fetch
     *   the "orderItems" that belong to a given "order". "orderItems" should declare a field that
     *   is a DataSourceField.foreignKey to the "orders" table (for example, it
     *   might be named "orderId" with foreignKey="orders.id"). Then, to load the records related to
     *   a given "order", call fetchRelatedData() on the component bound to "orderItems", pass the
     *   "orders" DataSource as the "schema" and pass a record from the "orders" DataSource as the
     *   "record" argument.
     * 
     * 
     *  @param {ListGridRecord} DataSource record
     *  @param {Canvas | DataSource | GlobalId} schema of the DataSource record, or              DataBoundComponent already bound to that schema
     *  @param {DSCallback=} callback to invoke on completion
     *  @param {DSRequest=} additional properties to set on the DSRequest                      that will be issued
     */
    open fun fetchRelatedData(record: ListGridRecord, schema: dynamic, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Clear the current criteria used to filter data.
     * 
     * 
     *  @param {DSCallback=} callback to invoke on completion
     *  @param {DSRequest=} additional properties to set on the DSRequest                      that will be issued
     */
    open fun clearCriteria(callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Retrieves a copy of the current criteria for this component (may be null).
     * 
     *   Note: if ListGrid.showFilterEditor is true, the criteria returned by this method may not
     *   match the values currently displayed in the filter editor, since the user may have entered
     *   values which have not yet been applied to our data. ListGrid.getFilterEditorCriteria
     *   may be used to retrieve the current criteria displayed in the filterEditor.
     * 
     */
    open fun getCriteria(): dynamic = definedExternally
    /**
     *   Sets this component's filter criteria.
     *   Default implementation calls this.data.setCriteria().
     * 
     *   Note: if ListGrid.showFilterEditor is true, the ListGrid.setFilterEditorCriteria
     *   method may be used to update the values displayed in the filter editor without effecting the
     *   data object.
     * 
     *  @param {Criteria | AdvancedCriteria} new criteria to show
     */
    open fun setCriteria(criteria: dynamic): Unit = definedExternally
    /**
     *   Invalidate the current data cache for this databound component via a call to
     *   the dataset's invalidateCache() method, for example,
     *   ResultSet.invalidateCache.
     * 
     *   NOTE: there is no need to call invalidateCache() when a save operation
     *   is performed on a DataSource. Automatic cache synchronization features will automatically
     *   update caches - see ResultSet for details. If automatic cache synchronization isn't
     *   working, troubleshoot the problem using the steps suggested
     *   in the FAQ rather
     *   than just calling invalidateCache(). Calling invalidateCache() unnecessarily
     *   causes extra server load and added code complexity.
     * 
     *   Calling invalidateCache() will automatically cause a new fetch to
     *   be performed with the current set of criteria if data had been previously fetched and the
     *   component is currently drawn with data visible - there is no need to manually call
     *   fetchData() after invalidateCache() and this could result in duplicate fetches.
     * 
     *   While data is being re-loaded after a call to invalidateCache(), the widget is
     *   in a state similar to initial data load - it doesn't know the total length of the dataset
     *   and any APIs that act on records or row indices will necessarily fail and should not be
     *   called. To detect that the widget is in this state, call ResultSet.lengthIsKnown.
     * 
     *   invalidateCache() only has an effect if this components dataset is a data
     *   manager class that manages a cache (eg ResultSet or ResultTree). If data was provided as a
     *   simple Array or List, invalidateCache() does nothing.
     * 
     * 
     */
    open fun invalidateCache(): Unit = definedExternally
    /**
     *   Unlike ListGrid.invalidateCache this will perform an asynchronous
     *   (background) refresh of this components data and then call the provided callback method on
     *   completion.
     * 
     *   If refreshData is called while the grid is waiting for a response from ListGrid.fetchData
     *   the refreshData call will be aborted. This is because the fetch has higher priority.
     * 
     *   If ListGrid.fetchData is called while the grid is waiting for a response from refreshData
     *   and the fetchData call has altered the criteria or sort specifiers, the refreshData call will
     *   be aborted.
     * 
     *   If data is being edited or has been edited without being saved when refreshData is called, the
     *   data will be retained so you can save it after the refresh is complete. If you however want
     *   to throw away your edited but unsaved data when calling refreshData you first need to call
     *   ListGrid.discardAllEdits which will discard any unsaved edited data.
     * 
     *   Note that for a TreeGrid with TreeGrid.loadDataOnDemand: true, all currently opened
     *   parent nodes will be re-fetched, except for TreeGrid.dataFetchMode TreeGrids,
     *   for which only opened parent nodes that are visible or contain visible children
     *   are re-fetched. We do this in a single queued batch of fetches to maximize efficiency.
     * 
     *   In order to use refreshData() this grid needs to have a DataSource associated with it.
     * 
     * 
     *  @param {DSCallback=} callback method to run once the refresh completes.
     */
    open fun refreshData(callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?)): Unit = definedExternally
    /**
     *   Compares the specified criteria with the current criteria applied to this component's
     *   data object and determines whether the new criteria could be satisfied from the currently
     *   cached set of data, or if a new filter/fetch operation will be required.
     * 
     *   This is equivalent to calling this.data.willFetchData(...).
     *   Always returns true if this component is not showing a set of data from the dataSource.
     * 
     *   Note that to predict correctly the decision that will be made by filter/fetch, you'll need to
     *   pass the same TextMatchStyle that will be used by the future filter/fetch. Fetching
     *   manually (e.g. ListGrid.fetchData) will by default use "exact" while filtering
     *   (e.g. ListGrid.filterData) will by default use "substring". If the component
     *   is configured for autofetch (i.e. ListGrid.autoFetchData: true), that will
     *   use ListGrid.autoFetchTextMatchStyle, which defaults to "substring". If nothing/null
     *   is passed for the style, this method assumes you want the style from the last filter/fetch.
     * 
     *   To determine what TextMatchStyle is being used, check the RPC Tab of the
     *   debugging and check the relevant DSRequest.
     * 
     * 
     *  @param {Criteria} new criteria to test.
     *  @param {TextMatchStyle=} New text match style. If not passed assumes    textMatchStyle will not be modified.
     */
    override fun willFetchData(newCriteria: dynamic, textMatchStyle: 
                                                                     /**
                                                                      *  case-insensitive exact match ("foo" matches "foo" and "FoO", but not "FooBar")
                                                                      *  case-sensitive exact match ("foo" matches only "foo")
                                                                      *  case-insenstive substring match ("foo" matches "foobar" and "BarFoo")
                                                                      *  case-insensitive prefix match ("foo" matches "FooBar" but not "BarFoo")
                                                                      *   textMatchStyle behavior is consistent across the client and all three of the built-in
                                                                      *   server DataSource implementations - SQL, Hibernate and JPA - to the maximum extent that is
                                                                      *   practical. Known inconsistencies, some of which can be tweaked with configuration settings,
                                                                      *   are described below
                                                                      * 
                                                                      *  - textMatchStyle can be disabled for any individual field with the
                                                                      *   DataSourceField.ignoreTextMatchStyle declaration. This behavior is consistent
                                                                      *   across client and server implementations, with the proviso that case-sensitive behavior
                                                                      *   is inherently inconsistent in the server-side implementations (see below for a more
                                                                      *   detailed discussion of this)
                                                                      * 
                                                                      *  - textMatchStyle is forced to "exactCase" for DataSourceField.primaryKey
                                                                      *   fields on update and remove operations, unless
                                                                      *   OperationBinding.allowMultiUpdate is in force. This means that a normal update
                                                                      *   or remove operation - which is constrained by a unique primaryKey value or combination, to
                                                                      *   affect only a single data row - will use an equality match on all primaryKey fields. This
                                                                      *   is desirable because it makes index usage more likely. Note that this means the key values
                                                                      *   "foo" and "FOO" are distinct, which is a change from previous behavior. For most databases,
                                                                      *   this change will have no effect because most databases do not by default allow primaryKey
                                                                      *   values that only differ in case anyway - if a table has a row with a PK of "foo" and you
                                                                      *   try to insert a row with a PK of "FOO", most databases will fail with a constraint violation.
                                                                      *   However, if you are using a database hat allows key values that differ only in case, and you
                                                                      *   need to support this for some reason, you can switch the framework back to the previous
                                                                      *   behavior by setting property allow.case.sensitive.pks to true in
                                                                      *   your server.properties file. Note, we do not recommend this; in fact, we do
                                                                      *   not recommend the use of text primaryKey fields at all. Where you have control ,we would
                                                                      *   always recommend the use of automatically incrementing numeric sequence keys.
                                                                      * 
                                                                      *  - textMatchStyle does not apply to boolean or temporal (date, datetime, time)
                                                                      *   DataSourceField.type. Such fields are always checked for equality. If
                                                                      *   you have a need for more complex matching, such as date-range checking, use AdvancedCriteria
                                                                      * 
                                                                      *  - Critiera values for temporal fields must be real dates (Javascript Date
                                                                      *   objects on the client, instances of java.util.Date on the server). Attempting
                                                                      *   to match against a string or any other type of value will result in an "always fails"
                                                                      *   clause being generated. This behavior is how the client code has always worked, but is a
                                                                      *   change for the server-side DataSources, in the interests of consistency. The previous
                                                                      *   behavior was:
                                                                      * 
                                                                      *  - SQLDataSource used to attempt to match the date column to the criteria value provided;
                                                                      *    if that value was an appropriately-formatted string, that attempt might have
                                                                      *    worked, but it would be database-specific. If you have an application that depends on
                                                                      *    this old behavior, you can switch it back on by adding the following to your
                                                                      *    server.properties file:
                                                                      *    sql.temporal.fields.require.date.criteria: false
                                                                      * 
                                                                      *  - HibernateDataSource and JPADataSource used to skip such clauses altogether, which
                                                                      *    results in the opposite behavior (there is an implied "always succeeds" clause, because
                                                                      *    the clause is not present in the query at all). If you have an application that depends on
                                                                      *    this old behavior, you can switch it back on by adding the following to your
                                                                      *    server.properties file:
                                                                      *    jpa.temporal.fields.require.date.criteria: false or
                                                                      *    hibernate.temporal.fields.require.date.criteria: false, as appropriate
                                                                      * 
                                                                      * 
                                                                      *  - textMatchStyle does not apply to fields used in the joins generated to satisfy
                                                                      *   DataSourceField.includeFrom declarations or entity relations in
                                                                      *   Hibernate or JPA. Again, such comparisons are always for equality
                                                                      * 
                                                                      *  - textMatchStyle is applied to numeric fields only if the supplied criteria value
                                                                      *   is a string. So for a numeric field "myNumber", we will match 10, 100, 110 and 1000 if a
                                                                      *   criteria value of "10" (the quoted string) is supplied, but we will only match 10 if a
                                                                      *   criteria value of 10 (the actual number) is supplied
                                                                      * 
                                                                      *  - This is a change in behavior for the server-side DataSource implementations, in the
                                                                      *    interests of consistency with the client behavior. Previously, all three of the built-in
                                                                      *    DataSource implementations applied textMatchStyle to numeric fields regardless of the
                                                                      *    criteria value's type. If you have an application that depends on this old behavior,
                                                                      *    you can switch it back on by adding the following to your server.properties
                                                                      *    file: sql.substring.numeric.criteria: true or
                                                                      *    hibernate.substring.numeric.criteria: true or
                                                                      *    jpa.substring.numeric.criteria: true, as appropriate
                                                                      * 
                                                                      * 
                                                                      *  - "exactCase" matching cannot be made consistent across all database providers because
                                                                      *   each database has its own idea of whether case-sensitive matching should be the default,
                                                                      *   and how to switch it on and off (if that is even possible)
                                                                      * 
                                                                      *  - Microsoft SQL Server must have case-sensitive matching enabled by setting a
                                                                      *    case-sensitive collation when the database is created (there are more fine-grained
                                                                      *    options, but we do not recommend them because of the scope for further inconsistency,
                                                                      *    where "exactCase" works correctly on table A but not on table B). See
                                                                      *    MSDN for details
                                                                      * 
                                                                      *  - HSQLDB has case sensitivity set with the SET IGNORECASE directive -
                                                                      *    see here
                                                                      * 
                                                                      *  - MySQL is case-insensitive, but since it provides an easy way to do per-query,
                                                                      *    case-sensitive matching in SQL, we work around it for that database, but only in
                                                                      *    SQL DataSources
                                                                      * 
                                                                      * 
                                                                      *  - If you are using Hibernate or JPA, whether "exactCase" works as expected depends
                                                                      *   entirely on the underlying database. Unlike the SQL DataSource, where we have fine-grained
                                                                      *   control of the SQL that the database executes, we are constrained by what the ORM will
                                                                      *   allow. This prevents us from compensating for database quirks, like we do with MySQL's
                                                                      *   case-insensitivity in the SQL DataSource
                                                                      * 
                                                                      */
                                                                     String /* exact |  exactCase |  substring |  startsWith */?): Boolean = definedExternally
    /**
     *   Perform a DataSource "add" operation to add new records to this component's DataSource.
     * 
     * 
     *  @param {Record} new record
     *  @param {DSCallback=} method to call on operation completion
     *  @param {DSRequest=} additional properties to set on the DSRequest                     that will be issued
     */
    open fun addData(newRecord: Record, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Perform a DataSource "update" operation to update existing records in this component's
     *   DataSource.
     * 
     * 
     *  @param {Record} updated record
     *  @param {DSCallback=} method to call on operation completion
     *  @param {DSRequest=} additional properties to set on the DSRequest                     that will be issued
     */
    open fun updateData(updatedRecord: Record, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Remove the currently selected records from this component.
     *   If this is a databound grid, the records will be removed directly from the DataSource.
     * 
     *   If no records are selected, no action is taken. The grid will automatically be
     *   updated if the record deletion succeeds.
     * 
     * 
     *  @param {DSCallback=} callback to fire when the data has been removed
     *  @param {DSRequest=} additional properties to set on the DSRequest                     that will be issued
     */
    open fun removeSelectedData(callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Returns the first selected record in this grid.
     * 
     *   This method is appropriate if the ListGrid.selectionType is
     *   "single",
     * 
     *   or if you only care about the first selected record in a multiple-record selection. To access
     *   all selected records, use ListGrid.getSelection instead.
     * 
     *   NOTE: If a record is returned, it should be treated as read-only and not
     *   modified.
     * 
     */
    open fun getSelectedRecord(): ListGridRecord = definedExternally
    /**
     *   Returns all selected records in this grid.
     * 
     *   NOTE: Records in the returned array should be treated as read-only and not
     *   modified.
     * 
     *  @param {boolean=} When true, partially selected records will not be returned.                  Otherwise, both fully and partially selected records are                  returned.
     */
    open fun getSelectedRecords(excludePartialSelections: Boolean?): Array<dynamic> = definedExternally
    /**
     *   Returns true if the record is selected.
     * 
     * 
     *  @param {ListGridRecord} record to check
     */
    open fun isSelected(record: ListGridRecord): Boolean = definedExternally
    /**
     *   When using tree-oriented selection modes like TreeGrid.cascadeSelection, returns true
     *   if the record is considered partially selected because only some of it's children are
     *   selected.
     * 
     * 
     *  @param {ListGridRecord} record to check
     */
    open fun isPartiallySelected(record: ListGridRecord): Boolean = definedExternally
    /**
     *   When exporting data to Excel/OpenOffice format using ListGrid.exportData or
     *   ListGrid.exportClientData, background color to use
     *   for the cell at the given rowNum and colNum.
     * 
     *   See exportBGColor for an overview.
     * 
     * 
     *  @param {Integer} row number of cell
     *  @param {Integer} column number of cell
     *  @param {Record} the record object behind the row being exported
     */
    open fun getExportBGColor(rowNum: Number, colNum: Number, record: Record): String = definedExternally
    /**
     *   When exporting data to Excel/OpenOffice format using ListGrid.exportData or
     *   ListGrid.exportClientData, background color to use
     *   for the given rowNum.
     * 
     *   See exportBGColor for an overview.
     * 
     * 
     *  @param {Integer} row number
     *  @param {Record} the record object behind the row being exported
     */
    open fun getExportRowBGColor(rowNum: Number, record: Record): String = definedExternally
    /**
     *   When exporting data to Excel/OpenOffice format using ListGrid.exportData or
     *   ListGrid.exportClientData, background color to use
     *   for the given colNum.
     * 
     *   See exportBGColor for an overview.
     * 
     * 
     *  @param {Integer} column number
     */
    open fun getExportColumnBGColor(colNum: Number): String = definedExternally
    /**
     *   Exports this component's data with client-side formatters applied, so is suitable for direct
     *   display to users. This feature requires the SmartClient server.
     * 
     *   Ordinarily, calls to this method go through the static classMethod
     *   DataSource.exportClientData. In this case, no server-side DataSources
     *   are required. However, if this component is
     *   DataBoundComponent.setDataSource and you specify a valid
     *   DSRequest.operationId in the properties passed to this method, the call
     *   will go through the instance method DataSource.exportClientData instead. As the
     *   documentation for that method explains, this allows you more control on the server side.
     *   This approach requires both the SmartClient server and server-side DataSource definitions.
     * 
     *   If your ListGrid has custom formatters, formatted values will be exported by default, with
     *   HTML normalized to text where possible. Since some levels of HTML normalizing aren't
     *   possible, this may result in missing or incorrect export values. In this case, you have
     *   two options:
     * 
     *  - Set ListGridField.exportRawValues on the field. This will export
     *     the raw underlying value of the field; your formatter will not be called
     * 
     *  - Have your formatter call ListGrid.isExportingClientData
     *     and perform whatever alternative formatting you require if that method returns true
     * 
     * 
     *   To export data from this component's dataSource,
     *   see DataBoundComponent.exportData, which does not include client-side
     *   formatters, but does include formatters declared in the .ds.xml file.
     *   exportData() relies on both the SmartClient server and server-side DataSources.
     * 
     *  @param {DSRequest=} Request properties for the export. Note that specifying DSRequest.exportData on the request properties  allows the developer to pass in an explicit data set to export.
     *  @param {RPCCallback=} Optional callback. If you specify DSRequest.exportToClient: false in the request  properties, this callback will fire after export completes. Otherwise the callback will  fire right before the download request is made to the server.
     */
    open fun exportClientData(requestProperties: DSRequest?, callback: ((response: RPCResponse, rawData: dynamic, request: RPCRequest) -> Unit?)): Unit = definedExternally
    /**
     *   Returns true if this component is currently
     *   ListGrid.exportClientData. This method can be called from
     *   custom cell formatters if you need to return a different formatted value for an export
     *   than for a live ListGrid
     * 
     */
    open fun isExportingClientData(): Boolean = definedExternally
    /**
     *   Marks the widget as "dirty" so that it will be added to a queue for redraw. Redraw of dirty
     *   components is handled by a looping timer and will after a very short delay (typically less than
     *   100ms). In most cases it is recommended that developers use markForRedraw()
     *   instead of calling Canvas.redraw directly. Since this method queues the redraw, multiple
     *   calls to markForRedraw() within a single thread of execution will only lead to a single DOM
     *   manipulation which greatly improves application performance.
     * 
     * 
     *  @param {string=} ["no reason provided"] reason for performing the redraw
     */
    override fun markForRedraw(reason: String?): Unit = definedExternally
    /**
     *   Get the rows that are currently visible in the viewport, as an array of
     *   [firstRowNum, lastRowNum].
     * 
     *   If the grid contains no records, will return [-1,-1]. Will also return [-1,-1] if called at
     *   an invalid time (for example, data is in the process of being fetched - see
     *   ResultSet.lengthIsKnown).
     * 
     * 
     */
    open fun getVisibleRows(): Array<dynamic> = definedExternally
    /**
     *   Get the rows that are currently drawn (exist in the DOM), as an array of [firstRowNum,
     *   lastRowNum].
     * 
     *   The drawn rows differ from the ListGrid.getVisibleRows because of
     *   ListGrid.drawAheadRatio. The drawn rows are the appropriate range to consider if
     *   you need to, eg, using ListGrid.refreshCell to update all the cells in a column.
     * 
     *   If the grid is undrawn or the ListGrid.emptyMessage is currently shown, returns
     *   [null,null];
     * 
     * 
     */
    open fun getDrawnRows(): Array<dynamic> = definedExternally
    /**
     *   Return the CSS class for a cell. By default this method has the following implementation:
     *   - return any custom style for the record (GridRenderer.recordCustomStyleProperty)
     *    if defined.
     *   - create a style name based on the result of GridRenderer.getBaseStyle and the
     *    state of the record using the rules described in cellStyleSuffixes.
     * 
     *   Cell Styles are customizable by:
     * 
     * 
     *  - attaching a custom style to a record by setting
     *    record[this.recordCustomStyleProperty] to some valid CSS style name.
     * 
     *  - modifying the base style returned by getBaseStyle() [see that method for further
     *     documentation on this]
     * 
     *  - overriding this function
     * 
     * 
     *   In addition to this, GridRenderer.getCellCSSText may be overriden to
     *   provide custom cssText to apply on top of the styling attributes derived from the named
     *   style.
     * 
     * 
     * 
     *  @param {ListGridRecord} record object for this row and column
     *  @param {number} number of the row
     *  @param {number} number of the column
     */
    open fun getCellStyle(record: ListGridRecord, rowNum: Number, colNum: Number): String = definedExternally
    /**
     *   Refresh the styling of an individual cell without redrawing the grid.
     * 
     *   The cell's CSS class and CSS text will be refreshed, to the current values returned by
     *   getCellStyle() and getCellCSSText() respectively.
     * 
     *   The cell's contents (as returned by getCellValue()) will not be refreshed. To
     *   refresh both styling and contents, call refreshCell() instead.
     * 
     * 
     *  @param {number} row number of cell to refresh
     *  @param {number} column number of cell to refresh
     */
    open fun refreshCellStyle(rowNum: Number, colNum: Number): Unit = definedExternally
    /**
     *   Called when the mouse pointer enters a cell
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun cellOver(record: ListGridRecord, rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Called when the mouse pointer enters a row
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun rowOver(record: ListGridRecord, rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Called when the mouse pointer leaves a cell
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun cellOut(record: ListGridRecord, rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Called when the mouse pointer leaves a row
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun rowOut(record: ListGridRecord, rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Called when the mouse hovers over a cell if this.canHover is true.
     *   Returning false will suppress the hover text from being shown if this.showHover is true.
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun cellHover(record: ListGridRecord, rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Optional stringMethod to fire when the user hovers over a cell and the value is clipped.
     *   If this.showClippedValuesOnHover is true, the default behavior is to show a hover canvas
     *   containing the HTML returned by cellValueHoverHTML(). Return false to suppress this default
     *   behavior.
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord()
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun cellValueHover(record: ListGridRecord, rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Called when the mouse hovers over a row if this.canHover is true.
     *   Returning false will suppress the hover text from being shown if this.showHover is true.
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun rowHover(record: ListGridRecord, rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   StringMethod to dynamically assemble an HTML string to show in a hover window over the
     *   appropriate cell/record when this.canHover and this.showHover are both true.
     *   Called when the mouse hovers over a cell.
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun cellHoverHTML(record: ListGridRecord, rowNum: Number, colNum: Number): String = definedExternally
    /**
     *   Returns the HTML that is displayed by the default cellValueHover handler. Return null or
     *   an empty string to cancel the hover.
     * 
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord()
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     *  @param {HTMLString} the HTML that would have been displayed by default
     */
    open fun cellValueHoverHTML(record: ListGridRecord, rowNum: Number, colNum: Number, defaultHTML: String): String = definedExternally
    /**
     *   Called when a cell receives a contextclick event.
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun cellContextClick(record: ListGridRecord, rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Called when a row receives a contextclick event.
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord()
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun rowContextClick(record: ListGridRecord, rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Called when a cell receives a mousedown event.
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord()
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun cellMouseDown(record: ListGridRecord, rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Called when a row receives a mousedown event.
     * 
     * 
     *  @param {ListGridRecord} record object returned from 'getCellRecord()'
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun rowMouseDown(record: ListGridRecord, rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Called when a cell receives a mouseup event.
     * 
     * 
     *  @param {ListGridRecord} Record object (retrieved from getCellRecord(rowNum, colNum))
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun cellMouseUp(record: ListGridRecord, rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Called when a row receives a mouseup event.
     * 
     * 
     *  @param {ListGridRecord} Record object returned from getCellRecord()
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun rowMouseUp(record: ListGridRecord, rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Called when a cell receives a click event.
     * 
     *   Note that returning false from this method will not prevent any
     *   specified ListGrid.rowClick handler from firing.
     * 
     * 
     *  @param {ListGridRecord} Record object returned from getCellRecord()
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun cellClick(record: ListGridRecord, rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Called when a cell receives a double click event.
     * 
     * 
     *  @param {ListGridRecord} Record object returned from getCellRecord()
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun cellDoubleClick(record: ListGridRecord, rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Returns the top coordinate for a given row number, relative to the top of body content. Use
     *   ListGrid.getRowPageTop for a page-relative coordinate.
     * 
     *   This method is reliable only for rows that are currently drawn, which is generally only rows
     *   that are visible in the viewport. If row heights vary (see fixedRowHeights),
     *   coordinates for rows that are not currently shown are rough approximations.
     * 
     * 
     * \* @param {Integer} 
     */
    open fun getRowTop(rowNum: Number): Number = definedExternally
    /**
     *   Returns the Y-coordinate for a given row number as a page-relative coordinate. See
     *   ListGrid.getRowTop.
     * 
     * 
     * \* @param {Integer} 
     */
    open fun getRowPageTop(rowNum: Number): Number = definedExternally
    /**
     *   The DataSource that this component should bind to for default fields and
     *   for performing DSRequest.
     * 
     * 
     */
    open fun getDataSource(): DataSource = definedExternally
    /**
     *   Returns the ListGrid.autoFitMaxWidth. Note that this method always returns
     *   an integer value - autoFitMaxWidth specified as a percentage will be resolved
     *   to a pixel value before being returned.
     * 
     * 
     */
    open fun getAutoFitMaxWidth(): Number = definedExternally
    /**
     *   Setter for GridRenderer.fastCellUpdates. Has no effect in browsers other than
     *   Internet Explorer.
     * 
     *  @param {boolean} whether to enable fastCellUpdates.
     */
    open fun setFastCellUpdates(fastCellUpdates: Boolean): Unit = definedExternally
    /**
     *   When assembling a value for a ListGrid.canAddSummaryFields, if a referenced
     *   field is hilited, should the hilite HTML be included in the summary field value?
     * 
     *   Example use case: Consider a grid containing a numeric field, and a summary field
     *   which contains some string value, plus the contents of the numeric field.
     *   If a hilite is defined for the grid which turns the numeric field text red when
     *   the value is negative, this property will govern whether the number will also be
     *   rendered in red within the summary field cells. Any other text in the summary field
     *   cells would not be effected by this hilite.
     * 
     *   Default implementation returns DataBoundComponent.includeHilitesInSummaryFields.
     * 
     *   To control hilites showing in group summaries, see ListGrid.showHilitesInGroupSummary.
     * 
     * 
     *  @param {string} name of the summary field
     *  @param {string} name of the field referenced by this summary
     */
    override fun shouldIncludeHiliteInSummaryField(summaryFieldName: String, usedFieldName: String): Boolean = definedExternally
    /**
     *   Marks a record deleted such that a later call to ListGrid.saveEdits or ListGrid.saveAllEdits
     *   will cause a "remove" DSRequest to be submitted.
     * 
     *   A removed record is disabled and non-editable, and uses ListGrid.removedCSSText for its CSS
     *   style, which by default will show strikethrough text.
     * 
     *   Contrast this method with removeSelectedData(), which immediately submits a DSRequest to
     *   remove the selected records from the dataset.
     * 
     *   Records that have been marked for removal using this method may be 'unmarked' via a call to
     *   ListGrid.unmarkRecordRemoved, or by discarding edit values (ListGrid.discardEdits).
     * 
     * 
     *  @param {number} row number for the record to mark
     */
    open fun markRecordRemoved(rowNum: Number): Unit = definedExternally
    /**
     *   Marks an array of records deleted such that a later call to ListGrid.saveEdits or
     *   ListGrid.saveAllEdits will cause a "remove" DSRequest to be submitted.
     * 
     *   This method is similar to ListGrid.markRecordRemoved but should be more efficient
     *   in avoiding unneeded duplicate refreshes due to the multiple records getting marked.
     * 
     * 
     *  @param {Array<Partial<ListGridRecord>> | number} records or indices to mark removed
     */
    open fun markRecordsRemoved(records: dynamic): Unit = definedExternally
    /**
     *   Returns true if the specified record is marked as removed via a call to
     *   ListGrid.markRecordRemoved
     * 
     *  @param {Integer} index of row to verify
     */
    open fun recordMarkedAsRemoved(rowNum: Number): Boolean = definedExternally
    /**
     *   Reverses a previous call to ListGrid.markRecordRemoved.
     * 
     *   Note that a record that is marked for removal and then un-marked retains any uncommitted
     *   edits from before it was marked for removal. These can be discarded with
     *   ListGrid.discardEdits.
     * 
     *  @param {Integer} index of record to clear the 'removed'
     */
    open fun unmarkRecordRemoved(rowNum: Number): Unit = definedExternally
    /**
     *   Marks the currently selected records as removed, as though ListGrid.markRecordRemoved had
     *   been called.
     * 
     * 
     */
    open fun markSelectionRemoved(): Unit = definedExternally
    /**
     *   Get the computed value of a ListGrid.canAddFormulaFields.
     * 
     *  @param {ListGridField} field that has a formula
     *  @param {Record} record to use to compute formula value
     */
    override fun getFormulaFieldValue(field: ListGridField, record: Record): dynamic = definedExternally
    /**
     *   Get the computed value of a ListGrid.canAddSummaryFields.
     * 
     *  @param {ListGridField} field that has a summary format
     *  @param {Record} record to use to compute formula value
     */
    override fun getSummaryFieldValue(field: ListGridField, record: Record): String = definedExternally
    /**
     *   Shows an additional field near the beginning of the field list (after any
     *   ListGrid.showRowNumbers field) that can be dragged to drag the current
     *   selection. This feature is useful in Browser.isTouch where
     *   both touch scrolling and dragging are needed on the same grid, and allows scrolling to
     *   be triggered on the other fields so that both operations are available. Targeted touch
     *   environments include both mobile devices, and Windows hardware that supports
     *   Browser.supportsDualInput such as Microsoft Surface.
     * 
     *   Note that the ListGrid.dragHandleField will never be shown unless
     *   ListGrid.canReorderRecords or ListGrid.canDragRecordsOut are true.
     * 
     *   In IE11 or Microsoft Edge, dragging a record in a grid may not be possible using a touch
     *   device without enabling drag handles, or disabling native touch scrolling by setting
     *   &nbsp;window.isc_useNativeTouchScrolling = false&nbsp; before SmartClient
     *   is loaded.
     * 
     *   Background
     * 
     *   One alternative to adding a drag handle field would be to use long touch to start a drag
     *   (with normal touch triggering scrolling). However, this is unsupportable in IE11 or Edge
     *   on Microsoft Surface (with native scrolling) because native scrolling cannot be canceled
     *   on the fly using Event.preventDefault(), but instead must be disabled by applying the
     *   appropriate CSS at rendering time. (Such limitations are not present elsewhere, such as
     *   on Android or IPhone browsers.)
     * 
     *   For more details, some links are provided below. Note that while IE10 is mentioned in
     *   some of the links, the reasoning is still relevant now for IE11 and Edge as the
     *   limitations remain:
     * 
     * 
     *  - Cross-browser support of touchMove
     * 
     *  - preventDefault() doesn't work in IE11 on MS Surface
     * 
     *  - preventDefault() doesn't work in Edge on MS Surface
     * 
     *  - preventDefault() failure reported to Microsoft against IE10
     * 
     * 
     */
    open fun showDragHandles(): Unit = definedExternally
    /**
     *   Hides the ListGrid.dragHandleField, if currently shown.
     * 
     */
    open fun hideDragHandles(): Unit = definedExternally
    /**
     *   Identifies whether the passed-in field is the specially generated
     *   ListGrid.rowNumberField used when ListGrid.showRowNumbers is
     *   true. Use this method in your custom event handlers to avoid inappropriately
     *   performing actions when the rowNumberField is clicked on.
     * 
     * 
     *  @param {ListGridField} field to test
     */
    open fun isRowNumberField(field: ListGridField): Boolean = definedExternally
    /**
     *   Returns the specially generated expansion field used when ListGrid.canExpandRecords is
     *   true.
     * 
     *   Called during ListGrid.setFields, this method can be overridden to add advanced dynamic
     *   defaults to the expansion field (call Super, modify the default field returned by Super,
     *   return the modified field). Normal customization can be handled by just setting
     *   AutoChild properties, as mentioned under the docs for ListGrid.expansionField.
     * 
     * 
     */
    open fun getExpansionField(): ListGridField = definedExternally
    /**
     *   Identifies whether the passed-in field is the specially generated
     *   ListGrid.expansionField used when ListGrid.canExpandRecords is
     *   true. Use this method in your custom event handlers to avoid inappropriately
     *   performing actions when the expansionField is clicked on.
     * 
     * 
     *  @param {ListGridField} field to test
     */
    open fun isExpansionField(field: ListGridField): Boolean = definedExternally
    /**
     *   Indicates whether a given record or rowNum can be expanded. The default implementation
     *   checks the value of ListGrid.canExpandRecords and
     *   record[ListGrid.canExpandRecordProperty].
     * 
     *   Override this method for more specific control over individual record expansion.
     * 
     *   Note: Rows with no underlying record in the data array - for example newly
     *   added edit rows that have not yet been saved - cannot be expanded.
     * 
     * 
     *  @param {ListGridRecord} record to work with
     *  @param {number} rowNum of the record to work with
     */
    open fun canExpandRecord(record: ListGridRecord, rowNum: Number): Boolean = definedExternally
    /**
     *   Setter for ListGrid.canExpandRecords
     * 
     *  @param {boolean} new value for listGrid.canExpandRecords.
     */
    open fun setCanExpandRecords(canExpand: Boolean): Unit = definedExternally
    /**
     *   Expands a given ListGridRecord by creating a subcomponent and inserting it
     *   in to the record's grid-row. A number of built-in ExpansionMode
     *   are supported by the default implementation of
     *   ListGrid.getExpansionComponent and you can override
     *   that method to provide your own expansion behavior.
     * 
     *   Once a record has been expanded, the currently visible expansion component may be
     *   retrieved via ListGrid.getCurrentExpansionComponent.
     * 
     * 
     *  @param {ListGridRecord} record to expand
     */
    open fun expandRecord(record: ListGridRecord): Unit = definedExternally
    /**
     *   Expands the passed list of ListGridRecord by creating a subcomponent for
     *   each record and inserting them it in to the record's grid-row. Calls
     *   ListGrid.expandRecord for each passed record, but only marks the
     *   grid for redraw once, after all expansions are complete.
     * 
     * 
     *  @param {Array<Partial<ListGridRecord>>} records to expand
     */
    open fun expandRecords(records: Array<dynamic>): Unit = definedExternally
    /**
     *   Collapses a given ListGridRecord which has been previously expanded using
     *   ListGrid.expandRecord.
     * 
     *   Depending on the ListGrid.expansionComponentPoolingMode,
     *   this method may automatically destroy expansionComponents. By default, components
     *   created automatically by the ListGrid will be auto-destroyed. This
     *   behavior can be changed by setting a different pooling mode.
     * 
     *   Note that components created via an override to ListGrid.getExpansionComponent
     *   will not be auto-destroyed - developers should override
     *   collapseRecord to take care of clean-up for such components.
     * 
     * 
     *  @param {ListGridRecord} record to collapse
     */
    open fun collapseRecord(record: ListGridRecord): Unit = definedExternally
    /**
     *   Collapses the passed list of expanded ListGridRecord. Calls
     *   ListGrid.collapseRecord for each passed record, but only marks
     *   the grid for redraw once, after all records have been collapsed.
     * 
     * 
     *  @param {Array<Partial<ListGridRecord>>} records to collapse
     */
    open fun collapseRecords(records: Array<dynamic>): Unit = definedExternally
    /**
     *   Whether a given ListGridRecord is expanded or collapsed.
     * 
     * 
     *  @param {ListGridRecord} record in question
     */
    open fun isExpanded(record: ListGridRecord): Boolean = definedExternally
    /**
     *   Returns the list of ListGridRecord from this ListGrid that are
     *   ListGrid.expandRecord
     * 
     * 
     */
    open fun getExpandedRecords(): Array<dynamic> = definedExternally
    /**
     *   Returns the expansion component derived from ListGrid.getExpansionComponent
     *   currently visible in some record, or null if the specified record is not showing
     *   an expansion component.
     * 
     * 
     *  @param {Integer | ListGridRecord} rowNum or record to get the expansionComponent for
     */
    open fun getCurrentExpansionComponent(record: dynamic): Canvas = definedExternally
    /**
     *   Gets the embedded-component to show as a given record's expansionComponent. This
     *   component is then housed in ListGrid.expansionLayout and embedded
     *   into a record's row.
     * 
     *   By default, this method returns one of a set of built-in components, according to the
     *   value of ExpansionMode. You can override this method
     *   to return any component you wish to provide as an expansionComponent.
     * 
     *   As long as the record is expanded, this component may be retrieved via a call to
     *   ListGrid.getCurrentExpansionComponent.
     * 
     *   When an expanded record is collapsed, the component is disassociated from the record and
     *   may or may not be automatically destroyed. By default, built-in components will be
     *   destroyed on unembed according to the ListGrid.expansionComponentPoolingMode being used. Custom expansion components, created via an override of
     *   getExpansionComponents(), will not be auto-destroyed - developers should
     *   override ListGrid.collapseRecord to take care of clean-up for such components.
     * 
     * 
     *  @param {ListGridRecord} record to get the expansionComponent for
     */
    open fun getExpansionComponent(record: ListGridRecord): Canvas = definedExternally
    /**
     *   Returns the DataSource containing data related to the passed record. Used
     *   when ListGrid.canExpandRecords is true and ExpansionMode is "related". The
     *   default implementation returns the DataSource specified in
     *   ListGridRecord.detailDS if set, otherwise ListGrid.detailDS.
     * 
     * 
     *  @param {ListGridRecord} The record to get the Related dataSource for.
     */
    open fun getRelatedDataSource(record: ListGridRecord): DataSource = definedExternally
    /**
     *   Setter for the ListGrid.canReorderRecords attribute.
     * 
     *  @param {boolean} new value for this.canReorderRecords
     */
    open fun setCanReorderRecords(canReorderRecords: Boolean): Unit = definedExternally
    /**
     *   Provides a new data set to the ListGrid after the grid has been created or drawn.
     *   The ListGrid will redraw to show the new data automatically.
     * 
     *  @param {Array<Partial<ListGridRecord>>} data to show in the list
     */
    open fun setData(newData: Array<dynamic>): Unit = definedExternally
    /**
     *   Changes selectionType on the fly.
     * 
     *  @param {SelectionStyle} New selection style.
     */
    open fun setSelectionType(selectionType: 
                                             /**
                                              *  don't select at all
                                              *  select only one item at a time
                                              *  select one or more items
                                              *  select one or more items as a toggle      so you don't need to hold down control keys to select
                                              *                   more than one object
                                              */
                                             String /* none |  single |  multiple |  simple */): Unit = definedExternally
    /**
     *   Changes selectionAppearance on the fly.
     * 
     *  @param {SelectionAppearance} new selection appearance
     */
    open fun setSelectionAppearance(selectionAppearance: 
                                                         /**
                                                          *  selected rows should be shown with different appearance - see          ListGrid.getCellStyle and optionally
                                                          *            ListGrid.selectionCanvas.
                                                          *  an extra, non-data column should be automatically added to the ListGrid,          showing checkboxes that can be toggled to select rows.
                                                          *            See ListGrid.getCheckboxField.
                                                          */
                                                         String /* rowStyle |  checkbox */): Unit = definedExternally
    /**
     *   Update the ListGrid.bodyOverflow for this listGrid.
     * 
     *  @param {Overflow} new overflow setting for the body
     */
    open fun setBodyOverflow(overflow: 
                                       /**
                                        *  Content that extends beyond the widget's width or height is               displayed.
                                        *                 Note: To have the content be sized only by the drawn size of
                                        *                 the content set the overflow to be Canvas.VISIBLE and specify
                                        *                 a small size, allowing the size to expand to the size required
                                        *                 by the content.
                                        *                 Leaving the width / height for the widget undefined will use the
                                        *                 default value of 100, and setting the size to zero may cause the
                                        *                 widget not to draw.
                                        *  Content that extends beyond the widget's width or height is               clipped (hidden).
                                        *  Horizontal and/or vertical scrollbars are displayed only if               necessary. Content that extends beyond the remaining visible
                                        *                 area is clipped.
                                        *  Horizontal and vertical scrollbars are always drawn inside the               widget. Content that extends beyond the remaining visible area
                                        *                 is clipped, and can be accessed via scrolling.
                                        *  Clip horizontally but extend the canvas's clip region               vertically if necessary. Note: only supported for
                                        *                 specific widget subclasses.
                                        *  Clip vertically but extend the canvas's clip region               horizontally if necessary. Note: only supported
                                        *                 for specific widget subclasses.
                                        */
                                       String /* visible |  hidden |  auto |  scroll |  clip-h |  clip-v */): Unit = definedExternally
    /**
     *   Update the ListGrid.bodyStyleName for this listGrid.
     * 
     *  @param {CSSStyleName} new body style name
     */
    open fun setBodyStyleName(styleName: String): Unit = definedExternally
    /**
     *   Update the ListGrid.alternateBodyStyleName for this listGrid.
     * 
     *  @param {CSSStyleName} new body style name when showing alternateRecordStyles
     */
    open fun setAlternateBodyStyleName(styleName: String): Unit = definedExternally
    /**
     *   Setter for ListGrid.alternateRecordStyles
     * 
     *  @param {boolean} New value for this.alternateRecordStyles
     */
    open fun setAlternateRecordStyles(alternateStyles: Boolean): Unit = definedExternally
    /**
     *   Setter for ListGrid.autoFitData.
     * 
     *  @param {Autofit} One of "vertical", "horizontal" or "both". To disable auto fit behavior, pass in null.
     */
    open fun setAutoFitData(autoFitData: 
                                         /**
                                          *  expand vertically to accommodate records.
                                          *  expand horizontally to accommodate fields.
                                          *  expand horizontally and vertically to accommodate content.
                                          */
                                         String /* vertical |  horizontal |  both */): Unit = definedExternally
    /**
     *   Setter for ListGrid.autoFitExtraRecords.
     * 
     *  @param {Integer} Number of extra rows beyond the data-size we'll expand to accommodate if ListGrid.autoFitData is enabled vertically.
     */
    open fun setAutoFitExtraRecords(extraRecords: Number): Unit = definedExternally
    /**
     *   Setter for ListGrid.autoFitMaxRecords.
     * 
     *  @param {Integer} Maximum number of rows we'll expand to accommodate if ListGrid.autoFitData is enabled vertically.
     */
    open fun setAutoFitMaxRecords(maxRecords: Number): Unit = definedExternally
    /**
     *   Setter for ListGrid.autoFitMaxHeight.
     * 
     *  @param {Integer} Maximum height in px we'll expand to accommodate if ListGrid.autoFitData is enabled vertically.
     */
    open fun setAutoFitMaxHeight(height: Number): Unit = definedExternally
    /**
     *   Setter for ListGrid.autoFitMaxColumns.
     * 
     *  @param {Integer} Maximum number of fields we'll expand to accommodate if ListGrid.autoFitData is enabled horizontally.
     */
    open fun setAutoFitMaxColumns(maxColumns: Number): Unit = definedExternally
    /**
     *   Setter for ListGrid.autoFitMaxWidth.
     * 
     *  @param {Integer | string} Width we'll expand to accommodate if ListGrid.autoFitData is enabled horizontally.
     */
    open fun setAutoFitMaxWidth(width: dynamic): Unit = definedExternally
    /**
     *   Programmatically cause a field to auto-fit horizontally to it's contents or title.
     * 
     *   Does not establish permanent auto-fitting - use ListGrid.setAutoFitWidth or
     *   ListGrid.setAutoFitFieldWidths to do so.
     * 
     *   Note that unlike the ongoing autoFit set up by ListGrid.autoFitFieldWidths or
     *   ListGridField.autoFitWidth, any specified ListGridField.width will not be
     *   taken as a minimum width - the field may shrink below the current specified width when
     *   this method is run. However, ListGridField.minWidth will be respected.
     * 
     *   As with ListGrid.autoFitFieldWidths, the auto-fit sizing is determined via the
     *   ListGrid.autoFitWidthApproach.
     * 
     * 
     * \* @param {string} 
     */
    open fun autoFitField(fieldName: String): Number = definedExternally
    /**
     *   Perform a one-time horizontal auto-fit of the fields passed. Fields will be sized
     *   to match their contents or title (as specified in ListGrid.autoFitWidthApproach)
     *   Does not establish permanent auto-fitting - use ListGrid.setAutoFitWidth to do so.
     * 
     *   Note that unlike the ongoing autoFit set up by ListGrid.autoFitFieldWidths or
     *   ListGridField.autoFitWidth, any specified ListGridField.width will not be
     *   taken as a minimum width - the field(s) may shrink below the current specified width when
     *   this method is run. However, ListGridField.minWidth will be respected.
     * 
     * 
     *  @param {Array<Partial<ListGridField>>=} Array of fields to auto fit. If this parameter is not passed, autoFitting will occur on all visible fields.
     */
    open fun autoFitFields(fields: Array<dynamic>?): Unit = definedExternally
    /**
     *   Setter for ListGridField.autoFitWidth. Enables or disables dynamic autoFitWidth behavior
     *   on the specified field. Note if the field is currently autoFitWidth:true, and this method is
     *   disabling autoFit, the field will not be resized by default - if you wish to resize to an
     *   explicit width, use ListGrid.resizeField.
     * 
     * 
     *  @param {string} field to auto-fit
     *  @param {boolean} Should autoFitWidth be enabled or disabled?
     */
    open fun setAutoFitWidth(fieldName: String, autoFit: Boolean): Unit = definedExternally
    /**
     *   Setter for ListGrid.autoFitFieldWidths. Modifies the default auto-fit-width behavior
     *   for fields in this grid. Note that this may be overridden at the field level via
     *   ListGridField.autoFitWidth.
     * 
     *  @param {boolean} New value for autoFitFieldWidths
     *  @param {boolean=} If autoFitFieldWidths was true, and is being set to false, should fields be resized to their originally specified size?  Pass in this parameter to suppress this behavior.
     */
    open fun setAutoFitFieldWidths(autoFit: Boolean, dontResetWidths: Boolean?): Unit = definedExternally
    /**
     *   Setter for the ListGrid.autoFitWidthApproach.
     * 
     *  @param {AutoFitWidthApproach} new AutoFitWidth approach
     */
    open fun setAutoFitWidthApproach(approach: 
                                               /**
                                                *  Size field to fit to the data value(s) contained in the field.
                                                *  Size field to fit the field title
                                                *  Size field to fit either the field title or the data values in the field (whichever requires more space).
                                                */
                                               String /* value |  title |  both */): Unit = definedExternally
    /**
     *   Dynamically set properties for a particular field. This method will update the fields
     *   header-button without having to explicitly reset the fields in the grid.
     * 
     *   NOTE: Where explicit setters exist for field properties (such as
     *   ListGrid.resizeField, ListGrid.setFieldTitle, ListGrid.setFieldIcon, etc.) these should be
     *   used instead.
     * 
     * 
     *  @param {number | string} name of the field, or index.
     *  @param {ListGridField} properties to apply to the header
     */
    open fun setFieldProperties(fieldNum: dynamic, properties: ListGridField): Unit = definedExternally
    /**
     *   Updates ListGridField.minWidth for the specified field and redraws the associated
     *   column if required.
     * 
     * 
     *  @param {Integer | string} name of the field, or index.
     * \* @param {number} 
     */
    open fun setFieldMinWidth(fieldNum: dynamic, width: Number): Unit = definedExternally
    /**
     *   Updates ListGridField.maxWidth for the specified field and redraws the associated
     *   column if required.
     * 
     * 
     *  @param {Integer | string} name of the field, or index.
     * \* @param {number} 
     */
    open fun setFieldMaxWidth(fieldNum: dynamic, width: Number): Unit = definedExternally
    /**
     *   Updates ListGrid.minFieldWidth and redraws any columns as needed.
     * 
     * 
     * \* @param {Integer} 
     */
    open fun setMinFieldWidth(width: Number): Unit = definedExternally
    /**
     *   Change the title of a field after the grid is created.
     * 
     * 
     *  @param {Integer | string} name of the field, or index.
     *  @param {string} new title
     */
    open fun setFieldTitle(fieldNum: dynamic, title: String): Unit = definedExternally
    /**
     *   Update the ListGridField.headerBaseStyle for a field within the grid at runtime.
     * 
     *  @param {string} name of the field.
     *  @param {CSSStyleName} new baseStyle for the field header
     */
    open fun setFieldHeaderBaseStyle(name: String, newStyle: String): Unit = definedExternally
    /**
     *   Update the ListGridField.headerTitleStyle for a field within the grid at runtime.
     * 
     *  @param {string} name of the field.
     *  @param {CSSStyleName} new titleTyle for the field header
     */
    open fun setFieldHeaderTitleStyle(name: String, newStyle: String): Unit = definedExternally
    /**
     *   Change the ListGridField.icon for a field after the grid is created
     * 
     *  @param {string} field to update
     *  @param {SCImgURL} icon for the field
     */
    open fun setFieldIcon(fieldName: String, icon: String): Unit = definedExternally
    /**
     *   Change the ListGridField.cellIcon for a field after the grid is created
     * 
     *  @param {string} field to update
     *  @param {SCImgURL} new cellIcon for the field
     */
    open fun setFieldCellIcon(fieldName: String, cellIcon: String): Unit = definedExternally
    /**
     *   Force an array of fields to be shown. This method does not add new fields to the grid,
     *   it simply changes field visibility. If a field.showIf expression exists, it will be
     *   destroyed.
     * 
     *   Note: for showing multiple fields it is more efficient to call this method than to call
     *   ListGrid.showField repeatedly.
     * 
     * 
     *  @param {Array<Partial<string>> | Array<Partial<ListGridField>>} Fields to show.
     *  @param {boolean=} If passed, don't resize non-explicitly sized columns                    to fill the available space.
     */
    open fun showFields(field: Array<dynamic>, suppressRelayout: Boolean?): Unit = definedExternally
    /**
     *   Force a field to be shown. This method does not add new fields to the grid,
     *   it simply changes field visibility. If a field.showIf expression exists, it will be
     *   destroyed.
     * 
     *   Note: for showing multiple fields it is more efficient to call ListGrid.showFields than
     *   to call this method repeatedly.
     * 
     * 
     *  @param {string | ListGridField} field to show
     *  @param {boolean=} If passed, don't resize non-explicitly sized columns                    to fill the available space.
     */
    open fun showField(field: dynamic, suppressRelayout: Boolean?): Unit = definedExternally
    /**
     *   Force an array of fields to be hidden.
     * 
     *   NOTE: If a field.showIf expression exists, it will be destroyed.
     * 
     *   When hiding multiple fields, this method should be called rather than
     *   calling ListGrid.hideField repeatedly for each field to hide.
     * 
     * 
     *  @param {Array<Partial<string>> | Array<Partial<ListGridField>>} fields to hide
     *  @param {boolean=} if passed, don't relayout non-explicit sized fields                   to fit the available space
     */
    open fun hideFields(fields: Array<dynamic>, suppressRelayout: Boolean?): Unit = definedExternally
    /**
     *   Force a field to be hidden.
     * 
     *   NOTE: If a field.showIf expression exists, it will be destroyed.
     * 
     *   Note also that if multiple fields are to be hidden it is more efficient to
     *   call ListGrid.hideFields passing in the array of fields to hide rather than to call
     *   this method repeatedly.
     * 
     * 
     *  @param {string | ListGridField} field to hide
     *  @param {boolean=} if passed, don't relayout non-explicit sized fields                   to fit the available space
     */
    open fun hideField(field: dynamic, suppressRelayout: Boolean?): Unit = definedExternally
    /**
     *   Check whether a field is currently visible
     * 
     * 
     *  @param {string | ListGridField} field to be checked
     */
    open fun fieldIsVisible(field: dynamic): Boolean = definedExternally
    /**
     *   Method to return the fieldName which represents the "title" for records in this
     *   Component.
     *   If this.titleField is explicitly specified it will always be used.
     *   Otherwise, default implementation will check DataSource.titleField for databound
     *   compounds.
     *   For non databound components returns the first defined field name of "title",
     *   "name", or "id" where the field is visible. If we don't find any
     *   field-names that match these titles, the first field in the component will be used instead.
     * 
     */
    override fun getTitleField(): String = definedExternally
    /**
     *   Sets the fields array and/or field widths to newFields and sizes, respectively.
     * 
     *   If newFields is specified, it is assumed that the new fields may have nothing in common with
     *   the old fields, and the component is substantially rebuilt. Furthermore, it's invalid to
     *   modify any of the existing ListGridFields after they've been passed to this function.
     *   Consider the following methods for more efficient, more incremental changes:
     *   ListGrid.resizeField, ListGrid.reorderField, ListGrid.showField, ListGrid.hideField, or
     *   ListGrid.setFieldProperties.
     * 
     * 
     *  @param {Array<Partial<ListGridField>>=} array of fields to draw
     */
    open fun setFields(newFields: Array<dynamic>?): Unit = definedExternally
    /**
     *   If the filter editor (ListGrid.showFilterEditor) is visible for this grid,
     *   this method will explicitly put focus into the specified field in the filter editor.
     * 
     *  @param {string=} Name of the field to put focus into. If unspecified focus will go               to the first field in the editor
     */
    open fun focusInFilterEditor(fieldName: String?): Unit = definedExternally
    /**
     *   If the filter editor (ListGrid.showFilterEditor) is visible for this grid,
     *   this method will perform a filter based on the current values in the editor.
     * 
     */
    open fun filterByEditor(): Unit = definedExternally
    /**
     *   Returns a snapshot of the current presentation of this listGrid's fields as
     *   a ListGridFieldState object.
     * 
     *   This object can later be passed to ListGrid.setFieldState to reset this grid's
     *   fields to the current state.
     * 
     *   Note that the information stored includes the current width and visibility of each of this
     *   grid's fields, as well as any ListGrid.canAddFormulaFields or
     *   ListGrid.canAddSummaryFields added by the user.
     * 
     * 
     */
    open fun getFieldState(): String = definedExternally
    /**
     *   Sets some presentation properties (visibility, width, userFormula and userSummary) of the
     *   listGrid fields based on the ListGridFieldState object passed in.
     *   Used to restore previous state retrieved from the grid by a call to ListGrid.getFieldState.
     * 
     * 
     *  @param {ListGridFieldState} state to apply to the listGrid's fields.
     */
    open fun setFieldState(fieldState: String): Unit = definedExternally
    /**
     *   Returns the specially generated checkbox field used when SelectionAppearance is
     *   "checkbox".
     * 
     *   Called during ListGrid.setFields, this method can be overridden to add advanced dynamic
     *   defaults to the checkbox field (call Super, modify the default field returned by Super,
     *   return the modified field). Normal customization can be handled by just setting
     *   AutoChild properties, as mentioned under the docs for ListGrid.checkboxField.
     * 
     * 
     */
    open fun getCheckboxField(): ListGridField = definedExternally
    /**
     *   Identifies whether the passed-in field is the specially generated
     *   ListGrid.checkboxField used when SelectionAppearance is
     *   "checkbox". Use this method in your custom event handlers to avoid inappropriately
     *   performing actions when the checkboxField is clicked on.
     * 
     * 
     *  @param {ListGridField} field to test
     */
    open fun isCheckboxField(field: ListGridField): Boolean = definedExternally
    /**
     *   Returns a snapshot of the current selection within this listGrid as
     *   a ListGridSelectedState object.
     *   This object can be passed to ListGrid.setSelectedState to reset this grid's current
     *   selection state (assuming the same data is present in the grid).
     * 
     */
    open fun getSelectedState(): String = definedExternally
    /**
     *   When ListGrid.canSelectCells is active, returns the CellSelection object that tracks
     *   and manages the current selection. Returns null if ListGrid.canSelectCells is false.
     * 
     */
    open fun getCellSelection(): CellSelection = definedExternally
    /**
     *   Reset this grid's selection to match the ListGridSelectedState object passed in.
     *   Used to restore previous state retrieved from the grid by a call to
     *   ListGrid.getSelectedState.
     * 
     * 
     *  @param {ListGridSelectedState} Object describing the desired selection state of                       the grid
     */
    open fun setSelectedState(selectedState: String): Unit = definedExternally
    /**
     *   Returns a snapshot of the current sort state within this listGrid as
     *   a ListGridSortState object.
     *   This object can be passed to ListGrid.setSortState to reset this grid's sort to
     *   the current state (assuming the same fields are present in the grid).
     * 
     */
    open fun getSortState(): String = definedExternally
    /**
     *   Reset this grid's sort state (sort field and direction or list of
     *   SortSpecifiers) to match the
     *   ListGridSortState object passed in.
     *   Used to restore previous state retrieved from the grid by a call to
     *   ListGrid.getSortState.
     * 
     * 
     *  @param {ListGridSortState} Object describing the desired sort state for the grid.
     */
    open fun setSortState(sortState: String): Unit = definedExternally
    /**
     *   Returns a snapshot of the current view state of this ListGrid.
     *   This includes the field, sort, hilite, group, and selected state of the grid, returned
     *   as a string representation of a ListGridViewState object.
     *   This string can be passed to ListGrid.setViewState to reset this grid's view state
     *   to the current state (assuming the same data / fields are present in the grid).
     * 
     */
    open fun getViewState(): String = definedExternally
    /**
     *   Returns a snapshot of the current grouping state of this ListGrid.
     *   This object can be passed to ListGrid.setGroupState to reset this grid's grouping
     *   to the current state (assuming the same data / fields are present in the grid).
     * 
     */
    open fun getGroupState(): String = definedExternally
    /**
     *   Reset this grid's grouping to match the ListGridGroupState object passed in.
     *   Used to restore previous state retrieved from the grid by a call to
     *   ListGrid.getGroupState.
     * 
     * 
     *  @param {ListGridGroupState} Object describing the desired grouping state of                       the grid
     */
    open fun setGroupState(groupState: String): Unit = definedExternally
    /**
     *   Reset this grid's view state to match the ListGridViewState object passed in.
     *   Used to restore previous state retrieved from the grid by a call to
     *   ListGrid.getViewState.
     * 
     * 
     *  @param {ListGridViewState} Object describing the desired view state for the grid
     */
    open fun setViewState(viewState: String): Unit = definedExternally
    /**
     *   Bind to a new DataSource.
     * 
     *   Like passing the "dataSource" property on creation, binding to a DataSource means that the
     *   component will use the DataSource to provide default data for its fields.
     * 
     *   When binding to a new DataSource, if the component has any existing "fields" or has a dataset,
     *   these will be discarded by default, since it is assumed the new DataSource may represent a
     *   completely unrelated set of objects. If the old "fields" are still relevant, pass them to
     *   setDataSource().
     * 
     * 
     *  @param {GlobalId | DataSource} DataSource to bind to
     *  @param {Array<Partial<DataSourceField>>=} optional array of fields to use
     */
    override fun setDataSource(dataSource: dynamic, fields: Array<dynamic>?): Unit = definedExternally
    /**
     *   Re-evaluates ListGridField.showIf for each field, dynamically showing and
     *   hiding the appropriate set of fields
     * 
     */
    open fun refreshFields(): Unit = definedExternally
    /**
     *   Returns an array of widths of the visible fields in this ListGrid, in px. This
     *   method is implemented by calling ListGrid.getFieldWidth for each field.
     *   If field widths cannot be determined, the returned array will contain nulls.
     * 
     */
    open fun getCurrentFieldWidths(): Array<dynamic> = definedExternally
    /**
     *   Returns a numeric value for the width of some field within this ListGrid.
     * 
     *  @param {Integer | FieldName} Index or name of the field for which the width is to be                  determined.
     */
    open fun getFieldWidth(fieldNum: dynamic): Number = definedExternally
    /**
     *   Method to calculate and return the default width of a field. This method is called
     *   to calculate the size of each field's content as part of the
     *   ListGrid.autoFitFieldWidths behavior. Note that this method
     *   returns a size for content, so will not be consulted if
     *   ListGridField.autoFitWidthApproach is set
     *   to "title".
     * 
     *   If ListGridField.defaultWidth is specified, this will be returned.
     * 
     *   Otherwise, the default implementation varies by ListGridFieldType.
     *   For fields of type "icon", or fields which show only a
     *   ListGridField.valueIcons as a value, and for boolean fields which
     *   show a checkbox value, the width will be calculated based on the icon size and
     *   ListGrid.iconPadding.
     *   For other fields the ListGrid.getFieldContentWidth method will be used to calculate
     *   a width based on the rendered width of content. Note that for
     *   "image" type fields, this method will rely on the ListGridField.imageWidth
     *   being specified.
     * 
     *   Note that this width is the default width of "content" - it does not take into account
     *   the rendered size of the field title.
     * 
     * 
     *  @param {ListGridField} Field for which the size should be determined
     */
    open fun getDefaultFieldWidth(field: ListGridField): Number = definedExternally
    /**
     *   Returns the pixel width of the content of a visible field in this grid.
     * 
     *  @param {ListGridField} field to test
     */
    open fun getFieldContentWidth(field: ListGridField): Number = definedExternally
    /**
     *   Get the current grouping of this listGrid as an array of fieldNames.
     * 
     *   This method returns an array containing the names of the field(s) by which this
     *   grid is grouped (either from ListGrid.groupByField having been explicitly set or
     *   from a call to ListGrid.groupBy). If this grid is not currently grouped, this method
     *   will return null.
     * 
     */
    open fun getGroupByFields(): Array<dynamic> = definedExternally
    /**
     *   Opens the node represented by the "record" parameter, if it is a folder and is not already
     *   open. This method only applies to ListGrid.groupBy ListGrids.
     * 
     *  @param {Record} node to open
     */
    open fun openGroup(record: Record): Boolean = definedExternally
    /**
     *   Closes the node represented by the "record" parameter, if it is a folder and is not already
     *   closed. This method only applies to ListGrid.groupBy ListGrids.
     * 
     *  @param {Record} node to close
     */
    open fun closeGroup(record: Record): Boolean = definedExternally
    /**
     *   Redraw just the ListGrid.header
     * 
     * 
     *  @param {boolean} If true, redraw the grid header with a direct inline call     to its redraw() method. Otherwise,      Canvas.markForRedraw
     */
    open fun redrawHeader(rightNow: Boolean): Unit = definedExternally
    /**
     *   Return the base styleName for this cell. Has the following implementation by default:
     * 
     * 
     *  - If ListGrid.editFailedBaseStyle is defined, and the
     *     cell is displaying a validation error return this value.
     * 
     *  - If ListGrid.editPendingBaseStyle is defined, and
     *     the cell is displaying an edit value that has not yet been saved (see
     *     ListGrid.autoSaveEdits) return this value.
     * 
     *  - Otherwise return ListGrid.recordBaseStyleProperty,
     *     if defined, otherwise ListGridField.baseStyle.
     * 
     *   If no custom style is found for the cell as described above, the default baseStyle will be
     *   returned. If ListGrid.baseStyle is specified this will be used. Otherwise for
     *   grids showing fixed height rows which match ListGrid.normalCellHeight
     *   ListGrid.normalBaseStyle will be used. For grids with variable, or modified
     *   cell heights, ListGrid.tallBaseStyle will be used.
     * 
     *   Note also that
     *   enabling ListGrid.fastCellUpdates will cause the tallBaseStyle to be
     *   used rather than ListGrid.normalBaseStyle.
     * 
     *   As noted under ListGrid.enforceVClipping, cell content which renders taller than the
     *   available space within a cell may cause rows to expand even if ListGrid.fixedRecordHeights
     *   is true. This can lead to misaligned rows when frozen columns are used.
     *   Developers should be aware that changing cell styling such that there is increased
     *   borders or padding will reduce the available space for content within the specified cell height,
     *   making this scenario more common. To fix this, specify a larger cellHeight, or set
     *   enforceVClipping to true.
     * 
     * 
     * 
     *  @param {ListGridRecord} Record associated with this cell. May be null                 for a new edit row at the end of this grid's data set.
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun getBaseStyle(record: ListGridRecord, rowNum: Number, colNum: Number): String = definedExternally
    /**
     *   Return CSS text for styling this cell, which will be applied in addition to the CSS class
     *   for the cell, as overrides.
     * 
     *   "CSS text" means semicolon-separated style settings, suitable for inclusion in a CSS
     *   stylesheet or in a STYLE attribute of an HTML element.
     * 
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun getCellCSSText(record: ListGridRecord, rowNum: Number, colNum: Number): String = definedExternally
    /**
     *       Obtains the display value for a specific cell according to the given input
     *       parameters.
     *       To format the value displayed in the cell, make use of the
     *       ListGrid.formatCellValue methods rather than
     *       overriding this method directly.
     * 
     *  @param {object} the current record object
     *  @param {number} number of the record in the current set of displayed                   record (e.g. 0 for the first displayed record)
     *  @param {number} number of the field in the listGrid.fields array
     */
    open fun getCellValue(record: dynamic, recordNum: Number, fieldNum: Number): String = definedExternally
    /**
     *   Is the value in a given cell clipped?
     * 
     *  @param {number} row number of the cell
     *  @param {number} column number of the cell
     */
    open fun cellValueIsClipped(rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Return the horizontal alignment for cell contents. Default implementation returns
     *   ListGridField.cellAlign if specified, otherwise ListGridField.align.
     * 
     * 
     *  @param {ListGridRecord} this cell's record
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun getCellAlign(record: ListGridRecord, rowNum: Number, colNum: Number): 
                                                                                   /**
                                                                                    *  Center within container.
                                                                                    *  Stick to left side of container.
                                                                                    *  Stick to right side of container.
                                                                                    */
                                                                                   String /* center |  left |  right */ = definedExternally
    /**
     *   Return the vertical alignment for cell contents.
     *   Expected values are: 'top', 'center', or 'bottom'
     * 
     * 
     *  @param {ListGridRecord} this cell's record
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun getCellVAlign(record: ListGridRecord, rowNum: Number, colNum: Number): 
                                                                                    /**
                                                                                     *  Center within container.
                                                                                     *  Stick to left side of container.
                                                                                     *  Stick to right side of container.
                                                                                     */
                                                                                    String /* center |  left |  right */ = definedExternally
    /**
     *   Return how many rows this cell should span. Default is 1.
     * 
     *   This method will only be called if ListGrid.allowRowSpanning is set to
     *   true
     * 
     *   When using row spanning, consider setting ListGrid.useRowSpanStyling to enable
     *   row-span-sensitive styling behaviors.
     * 
     *   Note that the standard implementation assumes that the number of rows spanned by cells
     *   decreases or stays the same, starting with the first (leftmost) column in the grid and
     *   moving rightwards.
     * 
     *   When using row spanning:
     * 
     * 
     *  - APIs that allow modifying the contents of cells (such as ListGrid.getCellStyle or
     *   ListGridField.formatCellValue) will be called only once per row-spanning cell
     * 
     *  - when using ListGrid.canSelectCells, only the
     *   spanning cell is considered selected, and not any of the cells spanned through. For
     *   example, if the cell at row 2 column 0 spans 2 cells, CellSelection
     *   will be true for 2,0 but false for 3,0.
     * 
     *  - if using incremental rendering (either horizontal or vertical),
     *   getRowSpan() may be called for a rowNum in the middle of a spanning
     *   cell, and should return the remaining span from that rowNum onward.
     * 
     *  - cell-level events such as ListGrid.recordClick will report the logical
     *   rowNum for spanned cells. In other words if a cell spans two rows, a different
     *   rowNum parameter will be passed to the recordClick handler depending on whether the user
     *   clicks at the top of the spanning cell or the bottom. Developers can normalize
     *   this to the starting cell via the ListGrid.getCellStartRow API.
     * 
     *  - for cells that span multiple records, editing behavior may be controlled by the
     *   RowSpanEditMode attribute.
     * 
     *  - rowSpanning can be used in conjunction with
     *   ListGrid.showRecordComponents. If record
     *   component are enabled on a grid with row-spanning cells the behavior is as follows:
     * 
     * 
     *  - Having ListGrid.recordComponentPosition set to "expand" is not currently supported
     *      for grids that render out spanning cells.
     * 
     *  - The method to retrieve / create record components will not be run for cells that
     *      are "spanned". In other words if the first row in a grid spans 2 rows for some
     *      field, the second logical row is "spanned" for that field - that cell doesn't
     *      render any content and won't attempt to create a recordComponent.
     * 
     *  - If ListGrid.showRecordComponentsByCell is false, the method to create record
     *      components will be called for every non-spanned cell in the first column
     *      of the grid.
     * 
     *  - Percentage sizing of record components spanning multiple cells will be
     *      calculated relative to the set of spanned cells.
     * 
     * 
     * 
     *   More generally, the ListGrid has a data model of one Record per row, and spanning cells
     *   doesn't fit well with this model, meaning that many ListGrid features are incompatible
     *   with rowSpanning.
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun getRowSpan(record: ListGridRecord, rowNum: Number, colNum: Number): Number = definedExternally
    /**
     *   When using ListGrid.getRowSpan, returns the number of cells spanned by the cell
     *   at the given coordinates.
     * 
     *   If the passed coordinates are in the middle of a series of spanned cells, the row span of
     *   the spanning cell is returned. For example, if row 2 col 0 spans 3 cells, calls to
     *   getCellRowSpan() for row 2 col 0, row 3 col 0, row 4 col 0 will all return 3.
     * 
     *   This method returns row span information for the current rendered cells. In contrast, if
     *   the grid is about to be redrawn, a call to getRowSpan() may return row span
     *   values for how the grid is about to be drawn. Also, user-provided getRowSpan() functions
     *   are not required to operate properly when called outside of the grid rendering loop.
     * 
     *   Note: This method is a utility method for developers - it is not called
     *   directly by the grid rendering path and therefore is not intended for override. To
     *   set up custom row-spanning behavior, override ListGrid.getRowSpan instead.
     * 
     * 
     *  @param {Integer} row number of cell to return the row span for
     *  @param {Integer} column number of cell to return the row span for
     */
    open fun getCellRowSpan(rowNum: Number, colNum: Number): Number = definedExternally
    /**
     *   When using ListGrid.getRowSpan, returns the row number where a row-spanning cell
     *   starts.
     * 
     *   For example, if row 2 col 0 spans 3 cells, getCellStartRow() for row 2 col 0,
     *   row 3 col 0, row 4 col 0 will all return 2, because that's the row when spanning starts.
     * 
     * 
     *  @param {Integer} row number of cell for which the start row should be returned
     *  @param {Integer} column number of cell for which the start row should be returned
     */
    open fun getCellStartRow(rowNum: Number, colNum: Number): Number = definedExternally
    /**
     *   Returns the appropriate valueIcon for a cell based on the field and the data value for the
     *   cell. Default implementation returns null if ListGridField.suppressValueIcon is true
     *   otherwise looks at ListGridField.valueIcons.
     * 
     *  @param {ListGridField} field associated with the cell
     *  @param {any} data value for the cell's record in this field.
     *  @param {ListGridRecord} record associated with this cell
     */
    open fun getValueIcon(field: ListGridField, value: dynamic, record: ListGridRecord): String = definedExternally
    /**
     *   Get the value for some cell with default formatters applied.
     * 
     *   This method is useful for cases where a developer wishes to
     *   conditionally customize a cell's formatting, but needs to see what
     *   the default formatted value would be.
     * 
     *   For example - a developer might wish to apply a custom
     *   ListGridField.formatCellValue to some
     *   link type field, and be able to return the default
     *   active link HTML in some cases. In this case a formatter could
     *   check for the conditions in which custom formatting should be applied
     *   and run appropriate custom logic to generate a value for display - otherwise
     *   return the result of this method to leave the standard formatted-value intact.
     * 
     * 
     *  @param {Record} the cell's record object
     *  @param {Integer} rowNum for the cell
     *  @param {Integer} colNum for the cell
     */
    open fun getDefaultFormattedValue(record: Record, rowNum: Number, colNum: Number): String = definedExternally
    /**
     *   Get a field value for some record with default field formatters applied.
     * 
     *   This method differs from ListGrid.getDefaultFormattedValue in a couple of ways.
     *   Firstly, this method does not rely on the rowNum and colNum parameters to find the
     *   record and field in the grid.
     *   Secondly, unlike ListGrid.getDefaultFormattedValue this method will call
     *   any explicit cell formatter specified on the field passed in (though it will not
     *   call a ListGrid.formatCellValue if one exists).
     * 
     *   This is useful for cases where a developer wishes to
     *   display a formatted value for some record and field combination which does not
     *   necessarily map to a cell displayed in the ListGrid.
     * 
     *   If rowNum and colNum parameters are passed through to
     *   the field level cell formatter if one exists. If not explicitly provided these are
     *   defaulted to -1.
     * 
     * 
     *  @param {Record} the record object
     *  @param {ListGridField} the field object
     *  @param {Integer=} rowNum (passed to any field level cell formatter)
     *  @param {Integer=} colNum (passed to any field level cell formatter)
     */
    open fun getDefaultFormattedFieldValue(record: Record, field: ListGridField, rowNum: Number?, colNum: Number?): String = definedExternally
    /**
     *   Setter for the ListGrid.showRecordComponents attribute
     * 
     *  @param {boolean} new value for this.showRecordComponents
     */
    open fun setShowRecordComponents(showRecordComponents: Boolean): Unit = definedExternally
    /**
     *   Returns the extents of the rows and columns currently visible in this grid's viewport.
     * 
     *   Note: if there are any ListGridField.frozen, they are not included
     *   in the draw area range returned by this method. Frozen fields are assumed to never be
     *   scrolled out of view. The column coordinates returned by this method will only include
     *   unfrozen columns.
     * 
     * 
     */
    open fun getDrawArea(): Array<dynamic> = definedExternally
    /**
     *   If ListGrid.showRecordComponents is true, by default any created record components
     *   are destroyed once they are no longer in use (for example, if the ListGrid as a whole is
     *   destroyed). This method may be used to suppress this behavior for some component. Typical
     *   usage might call this method as part of ListGrid.createRecordComponent to suppress
     *   this behavior.
     * 
     *  @param {Canvas} component in question.
     *  @param {boolean} If true, the component will not be destroyed automatically when  the grid is destroyed
     */
    open fun setDontAutoDestroyComponent(component: Canvas, dontAutoDestroy: Boolean): Unit = definedExternally
    /**
     *   Invalidates the currently visible set of ListGrid.showRecordComponents
     *   and gets fresh ones for the visible rows in the grid according to the
     *   ListGrid.recordComponentPoolingMode
     * 
     *   See also ListGrid.refreshRecordComponent which allows you to refresh a specific
     *   recordComponent
     * 
     * 
     */
    open fun invalidateRecordComponents(): Unit = definedExternally
    /**
     *   Discards any ListGrid.showRecordComponents currently assigned to the
     *   specified record (or cell) and gets a fresh one, according to the
     *   ListGrid.recordComponentPoolingMode
     * 
     *   See also ListGrid.invalidateRecordComponents which allows you to refresh all record
     *   components that are currently visible in the grid.
     * 
     * 
     *  @param {Integer} Row to refresh
     *  @param {Integer=} Column to refresh. This parameter should be passed   if ListGrid.showRecordComponentsByCell is true.
     */
    open fun refreshRecordComponent(rowNum: Number, colNum: Number?): Unit = definedExternally
    /**
     *   Setter for the ListGrid.recordComponentHeight
     * 
     *  @param {Integer} recordComponent height
     */
    open fun setRecordComponentHeight(height: Number): Unit = definedExternally
    /**
     * 
     *   Event handler for when rows in the body are clicked upon. The default implementation handles
     *   firing ListGrid.startEditing if appropriate, and fires
     *   ListGridField.recordClick and/or ListGrid.recordClick if set. Developers
     *   should typically implement recordClick rather than overriding this method.
     * 
     *   Note that this method fires in addition to any specified ListGrid.cellClick
     *   handler (even if that method cancels the event as a whole by returning false).
     * 
     * 
     *  @param {ListGridRecord} record object returned from getCellRecord()
     *  @param {Integer} index of the row where the click occurred
     *  @param {Integer} index of the col where the click occurred
     *  @param {boolean=} indicates whether this was a synthesized record                       click in response to a keyboard event
     */
    open fun rowClick(record: ListGridRecord, recordNum: Number, fieldNum: Number, keyboardGenerated: Boolean?): Boolean = definedExternally
    /**
     *   Event handler for when a body record is double-clicked.
     * 
     *   Default implementation fires 'editCell' if appropriate, and handles firing
     *   'recordDoubleClick' stringMethod if defined at the field or LG level (That method has a
     *   different signature from this one)
     * 
     * 
     *  @param {ListGridRecord} record object returned from getCellRecord()
     *  @param {number} index of the row where the click occurred
     *  @param {number} index of the col where the click occurred
     *  @param {boolean=} indicates whether this was a synthesized record                       doubleclick in response to a keyboard event
     */
    open fun rowDoubleClick(record: ListGridRecord, recordNum: Number, fieldNum: Number, keyboardGenerated: Boolean?): Boolean = definedExternally
    /**
     *   When ListGrid.showHoverComponents is set, this method is called to get the component to show
     *   as a hover for the current cell.
     * 
     *   By default, this method returns one of a set of builtin components, according to the
     *   value of HoverMode. You can override this method
     *   to return any component you wish to provide as a hoverComponent, or invoke the superclass
     *   method to have the default hover component generated, then further customize it.
     * 
     *   By default, components returned by getCellHoverComponent() will be
     *   automatically destroyed when the hover is hidden. To prevent this, set
     *   Canvas.hoverAutoDestroy to false on the returned component.
     * 
     *   If you return a component that fetches data or loads content dynamically:
     * 
     * 
     *  - as covered above, your component may have been automatically destroyed by the time your
     *     content has been loaded. Check Canvas.destroyed before taking action in an
     *     asynchronous callback
     * 
     * 
     *  - if your component grows in size after data is loaded, and it would then be rendered
     *     partially off-screen, it will be automatically re-positioned to keep it on-screen.
     *     However this will not automatically happen in cases where you provide HTML content that
     *     changes size after initial render, in which case a call to
     *     Canvas.adjustForContent will be required. See that API for details.
     * 
     * 
     * 
     *  @param {Record} record to get the hoverComponent for
     *  @param {Integer} row number for the cell
     *  @param {Integer} column number of the cell
     */
    open fun getCellHoverComponent(record: Record, rowNum: Number, colNum: Number): Canvas = definedExternally
    /**
     *   Select/deselect a Record passed in explicitly, or by index.
     * 
     *   Note that this method selects records unconditionally, allowing multiple selected
     *   records, even when ListGrid.selectionType is "single". To enforce mutually-exclusive
     *   record-selection, use ListGrid.selectSingleRecord.
     * 
     *  @param {Record | number} record (or row number) to select
     *  @param {boolean=} new selection state (if null, defaults to true)
     */
    override fun selectRecord(record: dynamic, newState: Boolean?): Unit = definedExternally
    /**
     * 
     *   Deselect a Record passed in explicitly, or by index.
     * 
     *   Synonym for selectRecord(record, false)
     * 
     * 
     *  @param {Record | number} record (or row number) to deselect
     */
    override fun deselectRecord(record: dynamic): Unit = definedExternally
    /**
     * 
     *   Select/deselect a list of Records passed in explicitly, or by index.
     * 
     *   Note that developers may wish to use ListGrid.selectRange to select a single
     *   contiguous range.
     * 
     * 
     *  @param {Array<Partial<Record>> | number} records (or row numbers) to select
     *  @param {boolean=} new selection state (if null, defaults to true)
     */
    override fun selectRecords(records: dynamic, newState: Boolean?): Unit = definedExternally
    /**
     * 
     *   Deselect a list of Records passed in explicitly, or by index.
     * 
     *   Synonym for selectRecords(records, false)
     * 
     *   Note that developers may wish to use ListGrid.deselectRange to select a single
     *   contiguous range.
     * 
     * 
     *  @param {Array<Partial<Record>> | number} records (or row numbers) to deselect
     */
    override fun deselectRecords(records: dynamic): Unit = definedExternally
    /**
     *   Select all records.
     * 
     *   Note that this method will select records even if ListGrid.canSelectRecord returns
     *   false for the record in question. See also ListGrid.userSelectAllRecords
     * 
     * 
     *  @param {boolean=} For TreeGrids, or listGrids showing  hierarchical ListGrid.isGrouped, if true is   passed for this parameter, only visible nodes will be selected.   Nodes embedded in a closed parent folder  (and thus hidden from the user) will not be selected.
     */
    override fun selectAllRecords(): Unit = definedExternally
    open fun selectAllRecords(visibleNodesOnly: Boolean?): Unit = definedExternally
    /**
     * 
     *   Deselect all records
     * 
     * 
     */
    override fun deselectAllRecords(): Unit = definedExternally
    /**
     *   Select a contiguous range of records by index
     * 
     *  @param {Integer} start of selection range
     *  @param {Integer} end of selection range (non-inclusive)
     *  @param {boolean=} new selection state (if null, defaults to true)
     */
    override fun selectRange(startRow: Number, endRow: Number, newState: Boolean?): Unit = definedExternally
    /**
     *   Deselect a contiguous range of records by index.
     * 
     *   This is a synonym for selectRange(startRow, endRow, false);
     * 
     *  @param {Integer} start of selection range
     *  @param {Integer} end of selection range (non-inclusive)
     */
    override fun deselectRange(startRow: Number, endRow: Number): Unit = definedExternally
    /**
     *   Selects every user-selectable record in the grid. Unlike ListGrid.selectAllRecords,
     *   if a record is ListGrid.canSelectRecord, this method will not
     *   attempt to select it.
     * 
     */
    open fun userSelectAllRecords(): Unit = definedExternally
    /**
     *   Whether at least one item is selected
     * 
     */
    override fun anySelected(): Boolean = definedExternally
    /**
     *   Select a single Record passed in explicitly, or by index, and deselect everything else.
     *   When programmatic selection of records is a requirement and
     *   ListGrid.selectionType is "single", use this method rather than
     *   DataBoundComponent.selectRecord to
     *   enforce mutually-exclusive record-selection.
     * 
     * 
     *  @param {Record | number} record (or row number) to select
     */
    override fun selectSingleRecord(record: dynamic): Unit = definedExternally
    /**
     *   If ListGrid.canSelectCells is set to true then, whenever an end-user or
     *   programmatic cell-selection is attempted, this method is called for
     *   each cell in the selection. If it returns false, the cell will not be selected.
     * 
     * 
     *  @param {Integer} rowNum being selected
     *  @param {Integer} colNum being selected
     */
    open fun canSelectCell(rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   If ListGrid.selectionType is not set to "none",
     *   This method will be called for each record the user attempts to select. If it returns false, the
     *   record will not be selected.
     * 
     *   The default implementation will return true for any records where
     *   ListGrid.recordCanSelectProperty is not explicitly set to false, and false
     *   if this method was called by a click on the ListGrid.expansionField
     *   and ListGrid.selectOnExpandRecord is set to false.
     * 
     * 
     *   Note this method will not be called at all if ListGrid.canSelectCells is true.
     * 
     * 
     *  @param {ListGridRecord} record being selected
     */
    open fun canSelectRecord(record: ListGridRecord): Boolean = definedExternally
    /**
     *   Handle a keyPress event on the ListGrid as a whole.
     * 
     *   Note that the majority of keyboard handling for a ListGrid is performed by
     *   ListGrid.bodyKeyPress and most overrides are better performed there.
     * 
     * 
     */
    override fun keyPress(): Boolean = definedExternally
    /**
     *   Handle a keyPress event on the body.
     * 
     *   Default implementation handles navigating between records with arrow keys, and activating
     *   records with space and enter.
     * 
     * 
     */
    open fun bodyKeyPress(): Boolean = definedExternally
    /**
     *   Puts keyboard focus into the specified cell, showing a highlighted (roll-over style)
     *   appearance, and ensuring that arrow-key navigation will start from the specified cell.
     * 
     *   Only applies where ListGrid.canSelectCells is true.
     * 
     *  @param {Integer} Index of target row
     *  @param {Integer} Index of target col
     */
    open fun focusInCell(row: Number, col: Number): Unit = definedExternally
    /**
     *   Puts keyboard focus into the specified row, showing a highlighted (roll-over style)
     *   appearance, and ensuring that arrow-key navigation will start from the specified row.
     * 
     *   Only applies where ListGrid.canSelectCells is false.
     * 
     *  @param {Integer} Index of target row
     */
    open fun focusInRow(row: Number): Unit = definedExternally
    /**
     *   Get the row that currently has keyboard focus. Arrow key navigation moves relative to this
     *   row.
     * 
     * 
     */
    open fun getFocusRow(): Number = definedExternally
    /**
     *   Scroll the grid to specified column such that the row appears near the center of the
     *   viewport.
     * 
     *   See ListGrid.scrollToCell for a full description of how
     *   this method interacts with incremental loading and rendering of data.
     * 
     *  @param {number} Index of the column to scroll into view
     *  @param {Alignment=} Horizontal position of scrolled column (optional)
     */
    open fun scrollToColumn(colNum: Number, xPosition: 
                                                       /**
                                                        *  Center within container.
                                                        *  Stick to left side of container.
                                                        *  Stick to right side of container.
                                                        */
                                                       String /* center |  left |  right */?): Unit = definedExternally
    /**
     *   Scroll the grid to specified row such that the row appears near the center of the
     *   viewport, loading data if necessary.
     * 
     *   See ListGrid.scrollToCell for a full description of how
     *   this method interacts with incremental loading and rendering of data.
     * 
     * 
     *  @param {number} Row index of the cell to scroll into view
     *  @param {VerticalAlignment=} Vertical position of scrolled row (optional)
     */
    open fun scrollToRow(rowNum: Number, yPosition: 
                                                    /**
                                                     *  At the top of the container
                                                     *  Center within container.
                                                     *  At the bottom of the container
                                                     */
                                                    String /* top |  center |  bottom */?): Unit = definedExternally
    /**
     *   Will scroll the listGrid body such that the specified cell is visible close to the
     *   center of the viewport.
     * 
     *   This method has no effect if the cell is already visible in the viewport.
     * 
     *   When scrolling vertically, this will cause data to be automatically loaded
     *   if ListGrid.dataFetchMode and you scroll into an area of
     *   the data that isn't loaded. Only rows around the target row will be
     *   loaded, not all intervening rows. See also ResultSet.
     * 
     *   Scrolling into an undrawn area will cause the body area of the grid to
     *   redraw, but this won't happen synchronously unless you explicitly call
     *   redraw(). Scrolling into an area of the data that is not yet loaded
     *   will never synchronously draw new rows, even if you call redraw() -
     *   wait for ListGrid.dataArrived to be notified when new rows have been
     *   loaded.
     * 
     *   Calling this method with a row index larger than the
     *   current dataset will clamp to the end of the dataset (similarly horizontal
     *   scrolling will clamp to the last column).
     * 
     *   If a call to this method is made while data is still loading, such
     *   that the last row of the dataset is not yet known the grid will attempt to compensate
     *   by scrolling the record into view when data arrives, if it is valid.
     *   For better control over scrolling, developers should consider
     *   calling scrollToRow() or scrollToCell
     *   from ListGrid.dataArrived if data is still loading.
     * 
     *   With mixed-height rows it will only reliably work if virtualScrolling
     *   is enabled.
     * 
     * 
     *  @param {Integer} Row index of the cell to scroll into view
     *  @param {Integer} Column index of the cell to scroll into view
     *  @param {Alignment=} Horizontal position of scrolled cell (optional)
     *  @param {VerticalAlignment=} Vertical position of scrolled cell (optional)
     */
    open fun scrollToCell(rowNum: Number, colNum: Number, xPosition: 
                                                                     /**
                                                                      *  Center within container.
                                                                      *  Stick to left side of container.
                                                                      *  Stick to right side of container.
                                                                      */
                                                                     String /* center |  left |  right */?, yPosition: 
                                                                                                                       /**
                                                                                                                        *  At the top of the container
                                                                                                                        *  Center within container.
                                                                                                                        *  At the bottom of the container
                                                                                                                        */
                                                                                                                       String /* top |  center |  bottom */?): Unit = definedExternally
    /**
     *   Executed when the listGrid receives a 'click' event on an enabled, non-separator
     *   record. The default implementation does nothing -- override to perform some action
     *   when any record or field is clicked.
     *   A record event handler can be specified either as
     *   a function to execute, or as a string of script to evaluate. If the handler is defined
     *   as a string of script, all the parameters below will be available as variables for use
     *   in the script.
     *   To do something specific if a particular field is clicked, add a recordClick
     *   method or string of script to that field (same parameters) when you're setting up
     *   the list.
     *   Notes:
     * 
     *  - This will not be called if the click is below the last item of the list.
     * 
     *  - This method is called from the default implementation of
     *   ListGrid.rowClick, so if that method is overridden
     *   this method may not be fired.
     * 
     * 
     *  @param {ListGrid} the listGrid that contains the click event
     *  @param {ListGridRecord} the record that was clicked on
     *  @param {number} number of the record clicked on in the current set of                 displayed records (starts with 0)
     *  @param {ListGridField} the field that was clicked on (field definition)
     *  @param {number} number of the field clicked on in the listGrid.fields                 array
     *  @param {any} value of the cell (after valueMap, etc. applied)
     *  @param {any} raw value of the cell (before valueMap, etc applied)
     */
    open fun recordClick(viewer: ListGrid, record: ListGridRecord, recordNum: Number, field: ListGridField, fieldNum: Number, value: dynamic, rawValue: dynamic): Boolean = definedExternally
    /**
     *   Executed when the listGrid receives a 'doubleClick' event on an enabled, non-separator
     *   record. The default implementation does nothing -- override to perform
     *   some action when any record or field is double clicked.
     *   A record event handler can be specified either as a function to execute, or as a string
     *   of script to evaluate. If the handler is defined as a string of script, all the
     *   parameters below will be available as variables for use in the script.
     *   To do something specific if a particular field is double clicked, add a
     *   recordDoubleClick method or string of script to that field (same parameters) when you're
     *   setting up the list.
     *   Notes:
     * 
     *  - This will not be called if the click is below the last item of the list.
     * 
     *  - This method is called from the default implementation of ListGrid.rowDoubleClick,
     *   so if that method is overridden this method may not be fired.
     * 
     *  @param {ListGrid} the listGrid that contains the doubleclick event
     *  @param {ListGridRecord} the record that was double-clicked
     *  @param {number} number of the record clicked on in the current set of                 displayed records (starts with 0)
     *  @param {ListGridField} the field that was clicked on (field definition)
     *  @param {number} number of the field clicked on in the listGrid.fields                 array
     *  @param {object} value of the cell (after valueMap, etc. applied)
     *  @param {object} raw value of the cell (before valueMap, etc applied)
     */
    open fun recordDoubleClick(viewer: ListGrid, record: ListGridRecord, recordNum: Number, field: ListGridField, fieldNum: Number, value: dynamic, rawValue: dynamic): Boolean = definedExternally
    /**
     *   Setter for the ListGrid.showGridSummary attribute
     * 
     *  @param {boolean} new value for this.showGridSummary
     */
    open fun setShowGridSummary(showGridSummary: Boolean): Unit = definedExternally
    /**
     *   Recalculates values for fields with
     *   ListGridField.recordSummaryFunction or
     *   ListGridField.userFormula defined and for values
     *   displayed in the ListGrid.showGridSummary and
     *   ListGrid.showGroupSummary.
     * 
     *  @param {Array<Partial<Record>>=} Optional array of records to recalculate summaries for,         or null for all records
     *  @param {Array<Partial<ListGridField>>=} Optional array of fields to recalculate summaries         for, or null for all fields  Note that the records should be from ListGrid.data; thus, if the grid is grouped,  the records should be from the grouped data rather than ListGrid.originalData.
     */
    open fun recalculateSummaries(records: Array<dynamic>?, fields: Array<dynamic>?): Unit = definedExternally
    /**
     *   Refresh the ListGrid.showGridSummary, by either re-calculating from
     *   already-loaded data or doing a new fetch from the ListGrid.summaryRowDataSource.
     * 
     *   Note unlike ListGrid.recalculateSummaries, this method will not force a refresh of
     *   field-level summaries (see ListGridField.recordSummaryFunction) or group level
     *   summaries (see ListGrid.showGroupSummary).
     * 
     */
    open fun recalculateGridSummary(): Unit = definedExternally
    /**
     *   Determines the SummaryFunction to use when calculating per-field summary values
     *   describing multiple records in this grid.
     *   Used to determine the summary function to use for both ListGrid.showGridSummary and
     *   ListGrid.showGroupSummary.
     * 
     *   Default implementation picks up ListGridField.summaryFunction if explicitly specified,
     *   otherwise checks for a default summary function based on field type (see
     *   SimpleType.setDefaultSummaryFunction). Note that a default summary function will
     *   not be supplied if the field represents a DataSourceField.primaryKey or
     *   DataSourceField.foreignKey, since it would likely not be meaningful.
     * 
     *  @param {ListGridField} field to check for summary function
     */
    open fun getGridSummaryFunction(field: ListGridField): 
                                                           /**
                                                            *  Client: iterates through the set of records, picking up and summing all numeric values for the specified field. Returns null to indicate invalid summary value if
                                                            *   any non numeric field values are encountered.
                                                            *   Server: acts exactly like SQL SUM function.
                                                            *  Client: iterates through the set of records, picking up all numeric values for the specified field and determining the mean value. Returns null to indicate invalid
                                                            *   summary value if any non numeric field values are encountered.
                                                            *   Server: acts exactly like SQL AVG function.
                                                            *  Client: iterates through the set of records, picking up all values for the specified field and finding the maximum value. Handles numeric fields and
                                                            *   date type fields only. Returns null to indicate invalid
                                                            *   summary value if any non numeric/date field values are encountered.
                                                            *   Server: acts exactly like SQL MAX function.
                                                            *  Client: iterates through the set of records, picking up all values for the specified field and finding the minimum value. Handles numeric fields and
                                                            *   date type fields only. Returns null to indicate invalid summary value if
                                                            *   any non numeric field values are encountered.
                                                            *   Server: acts exactly like SQL MIN function.
                                                            *  Client: iterates through the set of records, picking up all numeric values for the specified field and multiplying them together.
                                                            *   Returns null to indicate invalid summary value if
                                                            *   any non numeric field values are encountered.
                                                            *   Server: not supported.
                                                            *  Client: returns a numeric count of the total number of records passed in. Server: acts exactly like SQL COUNT function.
                                                            *  Client: returns field.summaryValueTitle if specified, otherwise field.title
                                                            *   Server: not supported.
                                                            *  Client: Currently the same as the min function. Server: implemented as SQL MIN function.
                                                            *  Client: iterates through the set of records, producing a string with each value concatenated to the end.
                                                            *   Server: implemented as SQL CONCAT function. Supported only by SQLDataSource. Note that it
                                                            *   is natively supported only by Oracle DB driver, other drivers perform additional query to fetch
                                                            *   values for concatenation. See also DataSourceField.joinPrefix,
                                                            *   DataSourceField.joinString and DataSourceField.joinSuffix
                                                            *   related datasource field attributes.
                                                            */
                                                           String /* sum |  avg |  max |  min |  multiplier |  count |  title |  first |  concat */ = definedExternally
    /**
     *   When ListGrid.showGridSummary is true this method is called for each field
     *   which will show a grid summary value (as described in ListGridField.showGridSummary)
     *   to get the summary value to display below the relevant column.
     * 
     *   The default implementation is as follows:
     * 
     *  - If this is a databound grid and not all data is loaded, returns null for every field
     * 
     *  - Otherwise if ListGridField.getGridSummary is defined, calls that method passing
     *       in the current data set for the grid
     * 
     *  - If ListGridField.getGridSummary is undefined, makes use of the
     *       ListGrid.getGridSummaryFunction for the field to
     *       calculate the summary based on the current data set
     * 
     *   This method may return an array of values. This implies that the grid summary should show
     *   multiple rows. Note that if a field has more than one summaryFunction specified, this method
     *   will pick up values from each summary function and return them in an array, meaning
     *   these summaries will show up on multiple rows in the grid.
     * 
     *   This method may be overridden to completely customize the summary value displayed for
     *   columns in this grid. An example use case would be when summary information is available on
     *   the client and does not need to be calculated directly from the data.
     * 
     *   Note: this method will not be called if ListGrid.summaryRowDataSource is
     *   specified.
     * 
     * 
     *  @param {ListGridField} field for which the summary value should be returned
     */
    open fun getGridSummary(field: ListGridField): dynamic = definedExternally
    /**
     *   This method returns the data to be displayed in the
     *   ListGrid.summaryRow when ListGrid.showGridSummary is true.
     * 
     *   By default this will call ListGrid.getGridSummary for each field and generate an array of records
     *   containing the resulting values.
     * 
     *   This method may be overridden for custom grid-summary display, and
     *   may return multiple records if more than one summary row is desired.
     * 
     * 
     */
    open fun getGridSummaryData(): Array<dynamic> = definedExternally
    /**
     *   If this grid is ListGrid.groupByField, and ListGrid.showGroupSummary is true,
     *   this method will be called for each group to return the
     *   group summary data to display
     *   at the end of the group.
     * 
     *   By default this will call ListGridField.getGroupSummary if defined for each field and
     *   generate an array of records containing the resulting values. If no explicit per-field
     *   getGroupSummary method is present, this method will fall back to calling the appropriate
     *   ListGridField.summaryFunction.
     * 
     *   This method may be overridden for custom group-summary display, and
     *   may return multiple records if more than one summary row per group is desired.
     * 
     * 
     *  @param {Array<Partial<Record>>} the records in the group, for which the summary values                 are being calculated
     *  @param {Record} object with specified groupValue and groupName for this group
     *  @param {boolean=} if set to false and the node has existing summary data,                 returns the stored summary data, rather than recalculating
     */
    open fun getGroupSummaryData(records: Array<dynamic>, groupNode: Record, recalculate: Boolean?): Array<dynamic> = definedExternally
    /**
     *   Provides access to the summary (see ListGridFieldType fields)
     *   value of the record for other fields when called from inside the body of
     *   ListGridField.getRecordSummary (since they're not available directly off
     *   the record). The behavior is unspecified if not called from inside the
     *   ListGridField.getRecordSummary method.
     * 
     * 
     *  @param {ListGridRecord} record for which a summary is being generated
     *  @param {ListGridField | Integer | GlobalId} field, or its number or id
     */
    open fun getRecordSummary(record: ListGridRecord, field: dynamic): dynamic = definedExternally
    /**
     *   Returns whether the supplied record is a group or grid summary record. Useful in conjunction
     *   with ListGrid.getGroupMembers for determining which records are group summary records.
     * 
     *  @param {ListGridRecord} Record object such as from ListGrid.getGroupMembers
     */
    open fun isSummaryRecord(record: ListGridRecord): Boolean = definedExternally
    /**
     *   Updates the user formula of the supplied field. This method is preferred over setting the
     *   the field property directly since it allows any component dependencies to be updated. If
     *   the formula is not passed or undefined, it is assumed it has already been updated and only
     *   the dependency propagation logic will run. Known component dependencies are:
     * 
     *  - the cached record values of the formula for this field
     * 
     *  - the common formula variable =&gt; field name map maintained by the component for
     *   calls to the FormulaBuilder
     * 
     *  @param {ListGridField | string} field owning the userFormula
     *  @param {UserFormula=} optional formula to install
     */
    open fun setUserFormula(field: dynamic, userFormula: UserFormula?): Unit = definedExternally
    /**
     *   Updates the user summary of the supplied field. This method is preferred over setting the
     *   field property directly since it allows any component dependencies to be updated. If the
     *   summary is not passed or undefined, it is assumed it has already been updated and only the
     *   dependency propagation logic will run.
     *   Known component dependencies are:
     * 
     *  - the cached record values of the summary for this field
     * 
     *  @param {ListGridField | string} field owning the userSummary
     *  @param {UserSummary=} optional summary to install
     */
    open fun setUserSummary(field: dynamic, userSummary: UserSummary?): Unit = definedExternally
    /**
     *   Updates the user formula text of the supplied field. This method is preferred over setting
     *   the text property directly since it allows any component dependencies to be updated. If the
     *   formula text is not passed or undefined, it is assumed it has already been updated and only
     *   the dependency propagation logic will run. Known component dependencies are:
     * 
     *  - the cached record values of the formula for this field
     * 
     *  @param {ListGridField | string} field owning the userFormula
     *  @param {string=} optional formula text to install
     */
    open fun setUserFormulaText(field: dynamic, text: String?): Unit = definedExternally
    /**
     *   Updates the user summary text of the supplied field. This method is preferred over setting
     *   the text property directly since it allows any component dependencies to be updated. If the
     *   summary text is not passed or undefined, it is assumed it has already been updated and only
     *   the dependency propagation logic will run. Known component dependencies are:
     * 
     *  - the cached record values of the summary for this field
     * 
     *  @param {ListGridField | string} field owning the userSummary
     *  @param {string=} optional summary text to install
     */
    open fun setUserSummaryText(field: dynamic, text: String?): Unit = definedExternally
    /**
     *   Setter for the ListGrid.showFilterEditor property. Allows the filter editor to be
     *   shown or hidden at runtime.
     * 
     *  @param {boolean} true if the filter editor should be shown, false if it should be hidden
     */
    open fun setShowFilterEditor(value: Boolean): Unit = definedExternally
    /**
     * 
     *   If we're showing the filter (query-by-example) row for this ListGrid, this method is
     *   used to determine the valueMap to display in the filter row for this field.
     *   Default implementation will return the field.filterEditorValueMap if specified, or
     *   field.valueMap.
     * 
     * 
     *  @param {ListGridField} field definition field for which we need a valueMap
     */
    open fun getFilterEditorValueMap(field: ListGridField): dynamic = definedExternally
    /**
     *   If we're showing the filter (query-by-example) row for this ListGrid, this method is
     *   used to determine the type of form item to display in the filter edit row for this field.
     *   Default implementation will return the field.filterEditorType if specified, or
     *   the result of DynamicForm.getEditorType otherwise.
     * 
     * 
     *  @param {ListGridField} field definition to get the editorType for
     */
    open fun getFilterEditorType(field: ListGridField): String = definedExternally
    /**
     *   If ListGrid.showFilterEditor is true, this method will update the criteria shown
     *   in the filterEditor without performing a filter.
     * 
     *  @param {Criteria | AdvancedCriteria} New criteria to show
     */
    open fun setFilterEditorCriteria(criteria: dynamic): Unit = definedExternally
    /**
     *   If ListGrid.showFilterEditor is true, this method will return the criteria currently
     *   displayed in the filterEditor. Note that these values may differ from the
     *   criteria returned by ListGrid.getCriteria if the filter editor values have been modified
     *   without performing an actual filter.
     * 
     *  @param {boolean=} By default this method will include criteria applied to  fields, including criteria that are not actually visible/editable in the filterEditor for the  grid. Pass in this parameter to get only values for visible fields returned.
     */
    open fun getFilterEditorCriteria(omitHiddenFields: Boolean?): dynamic = definedExternally
    /**
     *   Can this cell be edited?
     * 
     *   The default implementation of canEditCell() respects the various property
     *   settings affecting editability:
     * 
     *  - ListGridField.canEdit can be set to disable editing
     *       for a field
     * 
     *  - If the grid is bound to a dataSource, the ListGrid.canEditFieldAttribute value on the
     *       dataSource field may enable / disable editing
     * 
     *  - a record with the ListGrid.recordEditProperty set to
     *       false is not editable
     * 
     *  - disabled records are not editable
     * 
     *   You can override this method to control editability on a cell-by-cell basis. For example,
     *   if you had a grid that allows editing of "orders", and you had a field "shipDate" that is
     *   normally editable, but should not be editable if the order is already "complete", you might
     *   implement canEditCell() as follows:
     * 
     * 
     *    isc.ListGrid.create({
     *      ...
     *      canEditCell : function (rowNum, colNum) {
     *        var record = this.getRecord(rowNum),
     *          fieldName = this.getFieldName(colNum);
     *        if (fieldName == "shipDate" &&
     *          record.orderStatus == "complete")
     *        {
     *          return false;
     *        }
     *        // use default rules for all other fields
     *        return this.Super("canEditCell", arguments);
     *      }
     *    });
     * 
     * 
     * 
     *   Notes on providing custom implementations:
     * 
     * 
     *  - In order to allow complete control over editing, canEditCell() is called
     *   very frequently. If you see delays on row to row navigation, check that your implementation
     *   is efficient
     * 
     *  - If you change the editability of a cell on the fly, for example, during
     *   ListGrid.editorExit on another cell, call refreshCell() to show or hide the editor
     * 
     *  - If this ListGrid allows new records to be created, canEditCell() may be
     *   called when there is no record available, in which case getRecord() will return null. The
     *   values input so far by the user are available via ListGrid.getEditValues.
     * 
     * 
     * 
     * 
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun canEditCell(rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Can the field be edited? This method looks at ListGrid.canEdit for the grid as well as the
     *   ListGridField.canEdit value, to determine whether editing is actually allowed.
     *   For a detailed discussion, see the documentation at ListGrid.canEdit.
     * 
     * 
     *  @param {ListGridField | number | FieldName} field object, number, or name
     */
    override fun fieldIsEditable(field: dynamic): Boolean = definedExternally
    /**
     *   Start inline editing at the provided coordinates.
     * 
     *   Invoked when a cell is editable and the editEvent occurs on that cell. Can
     *   also be invoked explicitly.
     * 
     *   If this method is called while editing is already in progress, the value from the current
     *   editCell will either be stored locally as a temporary edit value, or saved via 'saveEdits()'
     *   depending on this.saveByCell, and the position of the new edit cell.
     *   Will update the UI to show the editor for the new cell, and put focus in it unless
     *   explicitly suppressed by the optional suppressFocus parameter.
     * 
     * 
     *  @param {Integer=} Row number of the cell to edit. Defaults to first                 editable row
     *  @param {Integer=} Column number of the cell to edit. Defaults to first                 editable column
     *  @param {boolean=} If passed this parameter suppresses the default                 behavior of focusing in the edit form item when                  the editor is shown.
     */
    open fun startEditing(rowNum: Number?, colNum: Number?, suppressFocus: Boolean?): Boolean = definedExternally
    /**
     *   Notification that the user is no longer hovering over some cell. Hides the current hover canvas
     *   if one is showing.
     * 
     */
    open fun stopHover(): Unit = definedExternally
    /**
     *   Method to retrieve a live edit form item for an ListGrid.canEdit ListGrid.
     *   This is the automatically generated editor displayed in a cell while editing the grid.
     * 
     *   Note that this is an advanced method and developers should be aware of the following issues:
     * 
     *  - Edit form items are only present while a user is actually editing a cell. This method
     *   will return null if the user is not editing the grid or the field in question is not editable
     *   or not visible. Note that due to ListGrid.showAllColumns columns which are
     *   not currently scrolled into view may be un-rendered, in which case they may have no associated
     *   edit item until the user scrolls them into view.
     * 
     *  - The items' values are managed by the ListGrid through the edit-values subsystem.
     *   If you want to change an edit value for a field, call ListGrid.setEditValue and the
     *   grid will handle updating the value in the live item if necessary. You should not need to call
     *   setValue(); directly on the item and doing so will not always update the
     *   edit value for the grid.
     * 
     *   In general - bear in mind that this is an advanced usage and if there is an equivalent API
     *   available on the ListGrid it is always preferable to use that.
     * 
     *  @param {string | Integer} fieldName or colNum to get the edit item for.
     */
    open fun getEditFormItem(field: dynamic): FormItem = definedExternally
    /**
     * 
     *   Returns the valueMap to display for a field when it is displayed in the editor while
     *   editing some record.
     *   Called when a user starts to edit a field, or whenever the field valueMap is updated via
     *   a call to ListGrid.setValueMap or ListGrid.setEditorValueMap.
     *   Default implementation will return the field.editorValueMap if specified, otherwise
     *   field.valueMap - can be overridden to provide a
     *   different specific valueMap for some field based on the record/field data.
     * 
     * 
     *  @param {ListGridField} field definition field for which we need a valueMap
     *  @param {object} Field values for record being edited. Note that this will include               the current edit values for fields that have not yet been saved.                May be null, if editing a new record.
     */
    open fun getEditorValueMap(field: ListGridField, values: dynamic): dynamic = definedExternally
    /**
     *   Returns the valueIcons for a field when it is displayed in the editor while editing some
     *   record. Default implementation will return ListGridField.editorValueIcons if specified
     *   otherwise ListGridField.valueIcons
     * 
     *  @param {object} field definition
     *  @param {object} current edit values for the record
     */
    open fun getEditorValueIcons(field: dynamic, values: dynamic): dynamic = definedExternally
    /**
     * 
     *   Set a valueMap to display for this field while editing.
     *   This method sets the ListGridField.editorValueMap property -
     *   note that if ListGrid.getEditorValueMap has been overridden it may not make use
     *   of this property.
     * 
     *  @param {object | number | FieldName} field object, number, or name
     *  @param {object} ValueMap to apply to the field
     */
    open fun setEditorValueMap(fieldID: dynamic, map: dynamic): Unit = definedExternally
    /**
     * 
     *   Returns the form item type (Class Name) to display for a field when it is displayed in the
     *   editor while editing some record.
     *   Default implementation will return field.editorType if specified.
     *   If not specified, the default form item for the appropriate data type will be displayed
     *   - can be overridden to provide a different specific form item type for some field based on
     *   the record/field data.
     * 
     * 
     *  @param {ListGridField} field definition field for which we need a valueMap
     *  @param {object} current edit values for the record (may be null, if editing a               new record)
     */
    open fun getEditorType(field: ListGridField, values: dynamic): String = definedExternally
    /**
     *   Get the default properties for editor form items displayed while editing some field.
     *   Overriding this method allows developers to dynamically customize the form item displayed in
     *   an editable grid, based on the cell being edited.
     * 
     *   Note: you should set FormItem.editorType in the returned properties to
     *   control the type of form item that is used.
     * 
     * 
     *  @param {ListGridField} field whose properties are needed
     */
    open fun getEditorProperties(field: ListGridField): dynamic = definedExternally
    /**
     *   Refresh an individual cell without redrawing the grid.
     * 
     *   The cell's value, CSS class, and CSS text will be refreshed, to the current values returned
     *   by getCellValue(), getCellStyle() and getCellCSSText() respectively.
     * 
     * 
     *  @param {number} row number of cell to refresh
     *  @param {number} column number of cell to refresh
     */
    open fun refreshCell(rowNum: Number, colNum: Number): Unit = definedExternally
    /**
     *   Refresh an entire row of cells without redrawing the grid.
     * 
     *   The cells' values, CSS classes, and CSS text will be refreshed, to the current values
     *   returned by getCellValue(), getCellStyle() and getCellCSSText() respectively.
     * 
     * 
     *  @param {number} row number of cell to refresh
     */
    open fun refreshRow(rowNum: Number): Unit = definedExternally
    /**
     * 
     *   Start editing a new row, after the last pre-existing record in the current set of data.
     * 
     *   This new row will be saved via the "add" dataSourceOperations.
     * 
     *   See the editing and also the
     *   unsavedRecords for context about how unsaved
     *   records behave.
     * 
     *   You can optionally pass newValues which are the initial values for the newly
     *   added record. See also ListGridField.defaultValue as a means of setting default
     *   values every time the user begins editing a new record, for instance, by pressing downArrow
     *   on the last normal record in the grid when ListGrid.listEndEditAction is "next".
     * 
     *   If editing is already underway elsewhere in the grid, startEditingNew() behaves just like
     *   ListGrid.startEditing.
     * 
     * 
     *  @param {Map<any> | Record=} Optional initial set of properties for the new record
     *  @param {boolean=} Whether to suppress the default behavior of moving focus                  to the newly shown editor.
     */
    open fun startEditingNew(newValues: dynamic?, suppressFocus: Boolean?): Unit = definedExternally
    /**
     *   Returns an array of every rowNum for which we have pending (unsubmitted) edits.
     *   This will return records that have been marked as removed (see ListGrid.markRecordRemoved
     *   as well as records with unsaved changes to field values.
     * 
     */
    open fun getAllEditRows(): Array<dynamic> = definedExternally
    /**
     *   Returns the current set of unsaved edits for a given row being edited.
     * 
     * 
     *  @param {number | object} rowNum of the record being edited, or an Object                   containing values for all the record's primary keys
     */
    open fun getEditValues(valuesID: dynamic): dynamic = definedExternally
    /**
     *   Returns the combination of unsaved edits (if any) and original values (if any) for a given
     *   row being edited.
     * 
     *   The returned value is never null, and can be freely modified.
     * 
     * 
     *  @param {number | object} rowNum of the record being edited, or an Object                   containing values for all the record's primary keys
     */
    open fun getEditedRecord(valuesID: dynamic): dynamic = definedExternally
    /**
     *   Returns the current value of a cell. If the cell has an outstanding edit value, this will
     *   be returned, otherwise the underlying value of the record will be returned.
     * 
     * 
     *  @param {number | object} rowNum of the record being edited, or an Object                   containing values for all the record's primary keys
     *  @param {number | string} colNum or fieldName of the cell
     */
    open fun getEditedCell(record: dynamic, field: dynamic): dynamic = definedExternally
    /**
     * 
     *   This method sets up a set of editValues for some row / cell. It differs from
     *   'setEditValue()' in that:
     *   &nbsp;- it takes values for multiple fields
     *   &nbsp;- it clears out any previous edit values for the record
     * 
     * 
     *  @param {number} Row number for the record being edited
     *  @param {object} New values for the row
     */
    open fun setEditValues(rowNum: Number, values: dynamic): Unit = definedExternally
    /**
     * 
     *   Modifies a field value being tracked as an unsaved user edit.
     *   Use for suggested or reformatted values for edits that remain unsaved.
     * 
     * 
     *  @param {number} Row number (or edit values ID)
     *  @param {number | string} Column number of cell, or name of field                      having editValue updated
     *  @param {any} New value for the appropriate field.
     */
    open fun setEditValue(rowNum: Number, colNum: dynamic, value: dynamic): Unit = definedExternally
    /**
     * 
     *   Returns the current temporary locally stored edit value for some field within a record
     *   being edited.
     * 
     * 
     *  @param {number} index of the row for which the editValue should be returned
     *  @param {number | string} index of the field, or fieldName, for which value should be               returned
     */
    open fun getEditValue(rowNum: Number, colNum: dynamic): dynamic = definedExternally
    /**
     * 
     *   Clear a field value being tracked as an unsaved user edit.
     *   The saved record value will be displayed in the the appropriate cell instead.
     *   Will also discard any validation errors for the specified field / row.
     * 
     * 
     *  @param {number | object} Row number, primary keys object for the record,                       or editValues object
     *  @param {number | string} Column number, or Name of field for which                   the value is to be cleared
     */
    open fun clearEditValue(editValuesID: dynamic, colNum: dynamic?): Unit = definedExternally
    /**
     *   Returns the index of the row being edited or null
     *   if there is no current edit row.
     * 
     * 
     */
    open fun getEditRow(): Number = definedExternally
    /**
     *   Returns the index of the column being edited or null
     *   if there is no current edit column.
     * 
     * 
     */
    open fun getEditCol(): Number = definedExternally
    /**
     * 
     *   Returns the field object associated with cell currently being edited
     * 
     * 
     */
    open fun getEditField(): dynamic = definedExternally
    /**
     * 
     *   Cancel the current edit without saving.
     * 
     * 
     */
    open fun cancelEditing(): Unit = definedExternally
    /**
     * 
     *   Complete the current edit by storing the value and hiding the inline editor. Note that
     *   if ListGrid.autoSaveEdits is true, the value will be saved to the server.
     * 
     * 
     */
    open fun endEditing(): Unit = definedExternally
    /**
     * 
     *   Method to find the next editable cell given a starting row/col, and a direction,
     *   either iterating through fields within each row, or checking the same field in each row.
     * 
     *   Note, this is potentially an expensive method. For example, consider a listGrid where the
     *   user can add rows but not edit any existing rows; in this case, canEditCell()
     *   would inspect and reject every row in the dataSet before returning true for the last row.
     *   Consider this before making use of this method on grids with large dataSets
     * 
     *  @param {number} Index of starting row
     *  @param {number} Index of starting column
     *  @param {number} +1 if searching forward for the next edit cell, -1 if                 searching backwards
     *  @param {boolean} true if we should check every field in each row -                     false if we should check the same field in each                      row.
     *  @param {boolean=} Should we check whether the cell passed in is                     editable? Default behavior WILL check that cell -                      pass false to suppress checking that cell.
     */
    open fun findNextEditCell(rowNum: Number, colNum: Number, direction: Number, stepThroughFields: Boolean, checkStartingCell: Boolean?): Array<dynamic> = definedExternally
    /**
     * 
     *   Cancel outstanding edits, discarding edit values, and hiding editors for the record[s] passed
     *   in if appropriate.
     * 
     *   If no rows are passed in, all outstanding edit values will be dropped. This will not
     *   automatically end editing; call ListGrid.endEditing before calling discardAllEdits()
     *   if you also want to end editing.
     * 
     *   Note that this also clears the ListGrid.markRecordRemoved state of any records
     *   that have been marked as removed.
     * 
     * 
     *  @param {Array<Partial<number>>=} allows you to specify which row(s) to drop edits for
     *  @param {boolean=} By default this method will hide the editor if               it is currently showing for any row in the grid. Passing in                this parameter will leave the editor visible (and just reset                the edit values underneath the editor).
     */
    open fun discardAllEdits(rows: Array<dynamic>?, dontHideEditor: Boolean?): Unit = definedExternally
    /**
     * 
     *   Cancel outstanding edits for the specified rows, discarding edit values, and hiding editors
     *   if appropriate.
     * 
     *   Note that if this method is called on a new edit row (created via
     *   ListGrid.startEditingNew for example), which has not yet been saved, this method
     *   will remove the row entirely.
     * 
     *   Also note that this method will clear the ListGrid.markRecordRemoved state
     *   of records that have been marked as removed.
     * 
     * 
     *  @param {Integer} Row to cancel
     *  @param {Integer} Column to cancel. Note that this parameter is ignored in ListGrids but            may be required in subclasses of ListGrid where each cell represents             one record in the data set (EG CubeGrid)
     *  @param {boolean=} By default this method will hide the editor if               it is currently showing for the row in question. Passing in                this parameter will leave the editor visible (and just reset                the edit values underneath the editor).
     */
    open fun discardEdits(rowNum: Number, colNum: Number, dontHideEditor: Boolean?): Unit = definedExternally
    /**
     * 
     *   Validates and saves edits within the row currently being edited (or another row with unsaved
     *   edits, if indicated).
     * 
     *   This method can be called to manually trigger saves if the default mechanisms of
     *   ListGrid.saveByCell or row by row saving are not suitable.
     * 
     *   The 'callback' parameter provides a notification when the save attempt completes, which is
     *   likely to be asynchronous for databound grids. Cases under which the callback will fire are:
     * 
     *  - Save completed successfully
     * 
     *  - No changes to the edited row, so save not required
     * 
     *  - Validation failure occurred on the client or on the server
     *   Note that if this method was unable to determine the row to be saved, the callback will NOT
     *   fire - in this case, the method is a no-op.
     * 
     *   Other, standard callbacks such as ListGrid.editComplete, ListGrid.editFailed and
     *   ListGrid.cellChanged will fire normally.
     * 
     *   Note this method does not hide the inline editors if they are showing - to explicitly save
     *   and end editing, use the method 'endEditing()'
     * 
     *   If this method is called for a row which has been marked for deletion
     *   (see ListGrid.markRecordRemoved) it will cause the record to be removed from the
     *   data-set.
     * 
     * 
     *  @param {EditCompletionEvent=} Event used to complete cell editing.     Optional, and defaults to "programmatic". Can be used by the      callback method to perform custom actions such as navigation when the      save completes.
     *  @param {Callback=} Callback to fire on completion of the saving process.                  If no edits were made or client-side validation fails                   the callback will be fired synchronously at the end of this                   method.                   Takes the following parameters:                   - rowNum (Number) edited row number                   - colNum (Number) edited column number                   - editCompletionEvent (EditCompletionEvent) event                    passed in (defaults to "programmatic")                   - success (boolean) false if the save was unable to                    complete due to a validation failure or server-side                    error.
     *  @param {number=} Which row should be saved. If unspecified the current edit row              is saved by default. Note that if there is no current edit row               this method will no op.
     */
    open fun saveEdits(editCompletionEvent: 
                                            /**
                                             *  User clicked outside editor during edit.
                                             *  User started editing another row by clicking on it
                                             *  User started editing another row by double                clicking
                                             *  Enter pressed.
                                             *  User pressed Escape.
                                             *  Up arrow key pressed.
                                             *  down arrow key.
                                             *  User pressed Tab.
                                             *  User pressed Shift+Tab.
                                             *  Edit moved to a different field (same row)
                                             *  Edit completed via explicit function call
                                             */
                                            String /* click_outside |  click |  doubleClick |  enter |  escape |  arrow_up |  arrow_down |  tab |  shift_tab |  field_change |  programmatic */?, callback: dynamic?, rowNum: Number?, colNum: Number?): Unit = definedExternally
    /**
     *   If this listGrid can be edited, this method will return true if the row passed in has been
     *   edited, but the edits have not yet been saved to the ListGrid's data object.
     * 
     *   Note this method will not return true if a record has been marked as
     *   ListGrid.markRecordRemoved, but has no other changes. Developers can use
     *   ListGrid.recordMarkedAsRemoved to check for this case.
     * 
     * 
     *  @param {Integer} index of row to check for changes
     */
    open fun rowHasChanges(rowNum: Number): Boolean = definedExternally
    /**
     *   Whether the grid as a whole has any unsaved edits, in any row. Note that this method will return
     *   true if any rows are ListGrid.markRecordRemoved in addition to any rows that have
     *   pending unsaved edits.
     * 
     */
    open fun hasChanges(): Boolean = definedExternally
    /**
     *   If this listGrid can be edited, this method will return true if the cell passed in has been
     *   edited, but the edits have not yet been saved to the ListGrid's data object.
     * 
     *  @param {Integer} index of row to check for changes
     *  @param {Integer} index of the col to check for changes
     */
    open fun cellHasChanges(rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Save a number of outstanding edits for this ListGrid. If no rows are specified, all
     *   outstanding edits will be saved.
     * 
     *   Note that if ListGrid.saveRequestProperties is specified and the grid is performing
     *   a databound save, these properties will be applied to each generated DSRequest.
     * 
     * 
     *  @param {Array<Partial<number>>=} optionally specify which rows to save
     *  @param {Callback=} If specified this callback will be fired on a successful save of the specified rows. Note that if there are no pending edits to be saved this callback will  not fire - you can check for this condition using ListGrid.hasChanges or  ListGrid.rowHasChanges. Use ListGrid.editFailed to find out about failures  encountered during saving (on a per-row basis).
     */
    open fun saveAllEdits(rows: Array<dynamic>?, saveCallback: dynamic?): Boolean = definedExternally
    /**
     *   Validate the current set of edit values for the row in question.
     * 
     *   Called when the user moves to a new edit row, or when an edited record is to be saved if
     *   client side validation is enabled for this grid.
     * 
     *   This method may also be called directly to perform row level validation at any time.
     * 
     * 
     *  @param {Integer} index of row to be validated.
     */
    open fun validateRow(rowNum: Number): Boolean = definedExternally
    /**
     *   Validate the current edit value for the cell in question. Called when the user moves to a
     *   new edit cell if ListGrid.validateByCell is true.
     *   This method may also be called directly to perform cell level validation at any time.
     * 
     *  @param {number} index of row to be validated.
     *  @param {string | number} field name (or column index) of field to be validated
     */
    open fun validateCell(rowNum: Number, fieldName: dynamic): Boolean = definedExternally
    /**
     *   Returns the message to display when a user attempts to save a required field with an
     *   empty value. By default returns Validator.requiredField.
     * 
     *  @param {object} definition of the field being edited
     *  @param {object} record object being edited
     */
    open fun getRequiredFieldMessage(field: dynamic, record: dynamic): String = definedExternally
    /**
     *   Does this grid currently have errors associated with editValues for any row in the grid.
     * 
     */
    open fun hasErrors(): Boolean = definedExternally
    /**
     *   Does the specified row have unresolved errors?
     * 
     *  @param {Integer} rowNum to check for errors
     */
    open fun rowHasErrors(rowNum: Number): Boolean = definedExternally
    /**
     *   Given a rowNum and a colNum or fieldName, determine whether we currently have stored
     *   validation errors for the record/field in question.
     * 
     *  @param {number} index of row to check for validation errors
     *  @param {string | number} name of field, or index of column to check for validation                   errors
     */
    open fun cellHasErrors(rowNum: Number, fieldID: dynamic): Boolean = definedExternally
    /**
     *   Returns any currently stored validation errors for this row in the following format:
     *   &nbsp;&nbsp;{fieldName:[array of error messages], ...}
     * 
     *  @param {number} index of row to check for validation errors.
     */
    open fun getRowErrors(rowNum: Number): dynamic = definedExternally
    /**
     *   Returns the current set of errors for this cell.
     * 
     *  @param {number} index of row to check for validation errors.
     *  @param {string | number} field to check for validation errors - can be fieldName                     or index of the column.
     */
    open fun getCellErrors(rowNum: Number, fieldName: dynamic): Array<dynamic> = definedExternally
    /**
     *   Set a validation error for some cell.
     * 
     *  @param {number} row index of cell to add validation error for
     *  @param {string | number} col index or field name of cell to add validation error for
     *  @param {string | Array<Partial<string>>} validation error/errors for the cell.
     */
    open fun setFieldError(rowNum: Number, fieldName: dynamic, errorMessage: dynamic): Unit = definedExternally
    /**
     *   Set the validation errors for some row (replacing any pre-existent validation errors)
     * 
     *   Note that in the case of a ListGrid.groupByField, or a
     *   TreeGrid, some records may be hidden form view (part of a collapsed group or
     *   parent folder). In this case there is no meaningful row number associated with a record.
     *   This method cannot be called on such rows - developers should make the row visible first.
     *   This is by design - users should always be able to see errors.
     * 
     * 
     *  @param {number} row to add validation error for
     *  @param {any} validation errors for the row in the format             {fieldName:errorMessage, ...} or              {fieldName:[errorMessage1, errorMessage2], ...}
     */
    open fun setRowErrors(rowNum: Number, errors: dynamic): Unit = definedExternally
    /**
     *   Clears any validation errors for some cell.
     * 
     *  @param {number} row index of cell to add validation error for
     *  @param {number | string} col index or field name of cell to add validation error for
     */
    open fun clearFieldError(rowNum: Number, fieldName: dynamic): Unit = definedExternally
    /**
     *   Clear any stored validation errors for some row
     * 
     *  @param {number} index of row to clear validation error for
     */
    open fun clearRowErrors(rowNum: Number): Unit = definedExternally
    /**
     *   Remove a record from this ListGrid.
     * 
     *   If this grid is bound to a DataSource, it will perform a DataSource "remove" operation to
     *   remove records from this component's DataSource.
     * 
     *   Otherwise the data will be removed from the grid's ListGrid.data object.
     * 
     *   To make changes to the local data object even when a DataSource is present, use
     *   ListGrid.saveLocally.
     * 
     * 
     *  @param {Record} listGrid record, or primary key values of record to delete.
     *  @param {DSCallback=} method to call on operation completion.  Note that if this is method does not trigger a dataSource remove operation, the callback  will still be fired when the data has been removed, but the dsResponse parameter  will be null.
     *  @param {DSRequest=} additional properties to set on any DSRequest                     that will be issued
     */
    open fun removeData(data: Record, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     *   Method fired when the user clicks the "remove" icon if ListGrid.canRemoveRecords is true.
     *   Default behavior will remove the record from the data set, or if we're
     *   ListGrid.deferRemoval mark record as removed [or for records already
     *   marked as removed, clear this removed marker].
     * 
     *   If ListGrid.warnOnRemoval is set, this method will also show a warning dialog to users
     *   allowing them to cancel the removal.
     * 
     *   This method may be called directly to cause a record to be removed or marked for removal
     *   as if the user had hit the "remove" icon.
     * 
     * 
     *   May be overridden to perform custom logic on remove click.
     * 
     *  @param {Integer} Row on which the icon was clicked
     */
    open fun removeRecordClick(rowNum: Number): Unit = definedExternally
    /**
     *   Sets the custom tracker HTML to display next to the mouse when the user initiates a drag
     *   operation on this component. Default implementation will examine ListGrid.dragTrackerMode
     *   and set the custom drag tracker to display the appropriate HTML based on the selected record.
     * 
     *   To display custom drag tracker HTML, this method may be overridden - call
     *   EventHandler.setDragTracker to actually update the drag tracker HTML.
     * 
     */
    override fun setDragTracker(): Boolean = definedExternally
    /**
     *   Return an icon to display as a drag tracker when the user drags some record.
     *   Default implementation:
     *   If ListGridField.valueIcons is specified for the title field of this grid
     *   (see ListGrid.getTitleField), the appropriate value icon will be displayed.
     *   If no appropriate valueIcon can be found, the icon will be derived from
     *   ListGrid.trackerImage.
     *   If multiple records are selected, only the first record is examined for valueIcons.
     * 
     *   Note: Only called if ListGrid.dragTrackerMode is set to "icon".
     * 
     *  @param {Array<Partial<ListGridRecord>>} Records being dragged
     */
    open fun getDragTrackerIcon(records: Array<dynamic>): String = definedExternally
    /**
     *   Return "title" HTML to display as a drag tracker when the user drags some record.
     *   Default implementation will display the cell value for the title field (see
     *   ListGrid.getTitleField) for the record(s) being dragged (including any
     *   icons / custom formatting / styling, etc).
     * 
     *   Note: Only called if ListGrid.dragTrackerMode is set to "title".
     * 
     *  @param {ListGridRecord} First selected record being dragged
     *  @param {number} row index of first record being dragged
     */
    open fun getDragTrackerTitle(record: ListGridRecord, rowNum: Number): String = definedExternally
    /**
     * 
     *   This method overrides Canvas.willAcceptDrop and works as follows:
     * 
     * 
     *  - If Canvas.willAcceptDrop (the superclass definition) returns false, this
     *     method always returns false. This allows Canvas.dragType and
     *     Canvas.dropTypes to be used to configure eligibility for drop. By default,
     *     a ListGrid has no dropTypes configured and so this check will not prevent a drop.
     * 
     *  - If this is a self-drop, that is, the user is dragging a record within this list, this is
     *     an attempted drag-reorder. If ListGrid.canReorderRecords is
     *     false, this method returns false.
     * 
     *  - If the EventHandler.getDragTarget is another widget, if
     *     ListGrid.canAcceptDroppedRecords is false this method returns false.
     * 
     *  - If a call to ListGrid.getDragData on the dragTarget fails to return
     *     an record object or an array of records, this method returns null.
     * 
     *  - If the drop target record is disabled or has ListGridRecord.canAcceptDrop
     *     set to false, return false.
     * 
     *   Note that this method may be called repeatedly during a drag-drop interaction to update the
     *   UI and notify the user as to when they may validly drop data.
     * 
     * 
     */
    override fun willAcceptDrop(): Boolean = definedExternally
    /**
     *   Simulates a drag / drop type transfer of the selected records in some other component to this
     *   component, without requiring any user interaction. This method acts on the dropped records
     *   exactly as if they had been dropped in an actual drag / drop interaction, including any
     *   special databound behavior invoked by calling
     *   DataBoundComponent.getDropValues for each dropped record.
     * 
     *   To transfer all data in, for example, a ListGrid, call
     *   ListGrid.selectAllRecords first.
     * 
     *   Note that drag/drop type transfers of records between components are asynchronous operations:
     *   SmartClient may need to perform server turnarounds to establish whether dropped records
     *   already exist in the target component. Therefore, it is possible to issue a call to
     *   transferSelectedData() and/or the drop() method of a databound
     *   component whilst a transfer is still active. When this happens, SmartClient adds the
     *   second and subsequent transfer requests to a queue and runs them one after the other. If
     *   you want to be notified when a transfer process has actually completed, either provide a
     *   callback to this method or implement DataBoundComponent.dropComplete.
     * 
     *   See the dragging documentation for an overview of list grid drag/drop data
     *   transfer.
     * 
     * 
     *  @param {DataBoundComponent} source component from which the records will be transferred
     *  @param {Integer=} target index (drop position) of the rows within this grid.
     *  @param {Callback=} optional callback to be fired when the transfer process has            completed. The callback will be passed a single parameter "records",            the list of records actually transferred to this component.
     */
    override fun transferSelectedData(source: DataBoundComponent, index: Number?, callback: dynamic?): Unit = definedExternally
    /**
     *   Process a drop of one or more records on a ListGrid record.
     * 
     *   This method can be overridden to provide custom drop behaviors, and is a more appropriate
     *   override point than the lower level Canvas.drop handler.
     * 
     *   If this is a self-drop, records are simply reordered.
     * 
     *   For a drop from another widget, ListGrid.transferDragData is called, which
     *   depending on the ListGrid.dragDataAction specified on the source
     *   widget, may either remove the source records from the original list
     *   (dragDataAction:"move") or just provide a copy to this list
     *   (dragDataAction:"copy").
     * 
     *   If this grid is databound, the new records will be added to the dataset by calling
     *   DataSource.addData. Further, if the new records were dragged from another
     *   databound component, and DataBoundComponent.addDropValues
     *   is true, DataBoundComponent.getDropValues will be called for every item
     *   being dropped.
     * 
     *   For multi-record drops, Queuing is automatically used to combine all DSRequests into a
     *   single HTTP Request (see QuickStart Guide, Server Framework chapter). This allows the
     *   server to persist all changes caused by the drop in a single transaction (and this is
     *   automatically done when using the built-in server DataSources with Power Edition and
     *   above).
     * 
     *   Note that reordering records has no effect on a databound grid.
     * 
     *   The newly dropped data is then selected automatically.
     * 
     *   If these default persistence behaviors are undesirable, return false to cancel them, then
     *   and implement your own behavior, typically by using grid.updateData() or addData() to add
     *   new records.
     *   NOTE: the records you receive in this event are the actual Records from the source
     *   component. Use DataSource.copyRecords to create a copy before modifying the records
     *   or using them with updateData() or addData().
     * 
     *   NOTE: for a drop beyond the last visible record of a ListGrid, targetRecord
     *   will be null and the index will be one higher than the last record. This
     *   includes a drop into an empty ListGrid, where index will be 0.
     * 
     * 
     *  @param {Array<Partial<ListGridRecord>>} records being dropped
     *  @param {ListGridRecord} record being dropped on. May be null
     *  @param {Integer} index of record being dropped on
     *  @param {Canvas} widget where dragging began
     */
    open fun recordDrop(dropRecords: Array<dynamic>, targetRecord: ListGridRecord, index: Number, sourceWidget: Canvas): Unit = definedExternally
    /**
     * 
     *   During a drag-and-drop interaction, this method is called to transfer a set of records that
     *   were dropped onto some other component. This method is called after the set of records has
     *   been copied to the other component. Whether or not this component's data is modified is
     *   determined by the value of DataBoundComponent.dragDataAction.
     * 
     *   With a dragDataAction of "move", a databound component will issue "remove"
     *   dsRequests against its DataSource to actually remove the data, via
     *   DataSource.removeData.
     * 
     * 
     */
    override fun transferDragData(): Array<dynamic> = definedExternally
    /**
     * 
     *   During a drag-and-drop interaction, this method returns the set of records being dragged out
     *   of the component. In the default implementation, this is the list of currently selected
     *   records.
     * 
     *   This method is consulted by ListGrid.willAcceptDrop.
     * 
     * 
     *  @param {DataBoundComponent} source component from which the records will be transferred
     */
    override fun getDragData(source: DataBoundComponent): Array<dynamic> = definedExternally
    /**
     *   Return the pointer to a particular record by record number.
     *   Synonym for ListGrid.getCellRecord.
     * 
     * 
     *  @param {number} row index of record to return.
     */
    open fun getRecord(recordNum: Number): ListGridRecord = definedExternally
    /**
     *   Return the pointer to a particular record by record number.
     *   Notes:
     *   - If this is a databound grid, and the record for some row has not yet been loaded,
     *    returns the ResultSet.getLoadingMarker, and a fetch will be
     *    initialized to retrieve the record from the server.
     *   - If this is a new row in an editable ListGrid, and has not yet been saved, this method will
     *    return null.
     * 
     *  @param {number} row index of record to return.
     */
    open fun getCellRecord(recordNum: Number): ListGridRecord = definedExternally
    /**
     *   Return the total number of rows in the grid.
     * 
     *   Note that, when creating new rows via inline editing, this can be more than the total number
     *   of rows in the dataset (that is, grid.data.getLength())
     * 
     * 
     */
    open fun getTotalRows(): Number = definedExternally
    /**
     *   Get the complete array of fields for this ListGrid, including fields that are not currently
     *   visible or were specified implicitly via ListGrid.dataSource.
     * 
     *   This list of fields is only valid once the ListGrid has been Canvas.draw or once
     *   ListGrid.setFields has been called explicitly. If called earlier, only the list of directly
     *   specified fields will be returned (the Array passed to create()).
     * 
     *   This Array should be treated as read-only. To modify the set of visible fields, use
     *   ListGrid.showField, ListGrid.hideField and related APIs. To update properties of individual
     *   fields, use ListGrid.setFieldProperties or more specific APIs such as
     *   ListGrid.setFieldTitle.
     * 
     * 
     */
    open fun getAllFields(): Array<dynamic> = definedExternally
    /**
     *   Given a column number or field id, return the field name of a field.
     * 
     *  @param {number | GlobalId} number or id of the field.
     */
    open fun getFieldName(colNum: dynamic): String = definedExternally
    /**
     *   Given a field name, return the appropriate field definition. Unlike
     *   ListGrid.getField, this method will return the field definition even if
     *   it's not visible in the grid.
     * 
     * 
     *  @param {FieldName} name of the field to retrieve
     */
    open fun getFieldByName(fieldName: String): ListGridField = definedExternally
    /**
     *   Given a column number or field name, return the field definition of a field which is visible
     *   in the grid. To retrieve the definition of any field, including hidden ones, use
     *   ListGrid.getFieldByName.
     * 
     *   When using DataBoundComponent.fields, the field definition may be
     *   a mix of information derived from ListGrid.fields and ListGrid.dataSource.
     * 
     * 
     *  @param {Integer | FieldName} number or name of the field
     */
    override fun getField(fieldID: dynamic): ListGridField = definedExternally
    /**
     *     Given a field or field id, return it's index in the fields array
     * 
     *  @param {string | number} field number or field.name
     */
    override fun getFieldNum(fieldName: dynamic): Number = definedExternally
    /**
     *   Return the title of a field, specified by name or index.
     * 
     *  @param {string | number} name or index of the field
     */
    open fun getFieldTitle(fieldId: dynamic): String = definedExternally
    /**
     *   Return the summary title of particular field. This is the title of
     *   the field to be used in the show / hide fields context menu. Default implementation will
     *   use ListGridField.getSummaryTitle or ListGridField.summaryTitle if specified,
     *   otherwise ListGridField.title.
     * 
     *  @param {ListGridField} field for which we're returning the title
     */
    open fun getSummaryTitle(field: ListGridField): String = definedExternally
    /**
     *   Set the ListGridField.valueMap for a field.
     *   See also the ListGrid.setEditorValueMap
     *   and ListGrid.getEditorValueMap methods which allow further
     *   customization of the valueMap displayed while the field is in edit mode.
     * 
     *  @param {string | Integer} Name or index of field to update
     *  @param {object} ValueMap for the passed field
     */
    open fun setValueMap(fieldID: dynamic, map: dynamic): Unit = definedExternally
    /**
     *   Given a field with a specified ListGridField.valueMap or ListGridField.displayField
     *   this method will return the display value for any underlying data value.
     * 
     *  @param {string | number | ListGridField} Field or field identifier with valueMap
     *  @param {any} Data value for this field
     */
    open fun getDisplayValue(fieldID: dynamic, valueFieldValue: dynamic): String = definedExternally
    /**
     *   Get the index of the provided record.
     * 
     *   This is essentially the same as calling listGrid.data.indexOf(record), except that
     *   the currently visible range of records is checked first. This is important for
     *   responsiveness in functions that respond to user actions when the user is working near the
     *   end of a very large dataset (eg 500k records).
     * 
     * 
     *  @param {ListGridRecord} the record whose index is to be retrieved
     */
    override fun getRecordIndex(record: Record): Number = definedExternally
    /**
     *   Synonym of ListGrid.getRecordIndex.
     * 
     * 
     *  @param {ListGridRecord} the record whose index is to be retrieved
     */
    open fun getRowNum(record: ListGridRecord): Number = definedExternally
    /**
     *   Returns the row number of the most recent mouse event.
     * 
     *  @param {Integer=} optional y-coordinate to obtain row number, in lieu of the y            coordinate of the last mouse event
     */
    open fun getEventRow(y: Number?): Number = definedExternally
    /**
     *   Returns the column number of the most recent mouse event.
     * 
     *  @param {Integer=} optional x-coordinate to obtain column number for, in lieu of the x            coordinate of the last mouse event
     */
    open fun getEventColumn(x: Number?): Number = definedExternally
    /**
     *   Returns the RecordDropPosition for some record drop operation.
     *   This value is passed to the ListGrid.recordDrop event notification method.
     * 
     *   Default implementation determines the position to return based on
     *   the specified ListGrid.recordDropAppearance for the grid and the
     *   EventHandler.getY.
     * 
     * 
     */
    open fun getRecordDropPosition(): 
                                      /**
                                       *  User dropped directly onto the record
                                       *  User dropped before the record
                                       *  User dropped after the record
                                       *  Drop position is not over a record
                                       */
                                      String /* over |  before |  after |  none */ = definedExternally
    /**
     *   Return the drop-index for a given row and reorderPosition.
     * 
     *   When there are no rows in the grid, getDropIndex() returns zero.
     * 
     *   If parameter recordNum is not passed, the current event row is used, see
     *   ListGrid.getEventRow.
     * 
     *   Parameter ReorderPosition indicates where the drop-item should appear
     *   in relation to the row at index recordNum. If no reorderPosition is provided, it is
     *   calculated based on the physical position of the mouse in the drop-target row when the drop
     *   occurs; if the mouse is in the top half of a row, the drop-index is before
     *   recordNum. Otherwise, the drop-index is after recordNum.
     * 
     * 
     *  @param {number=} Index of the record to drop onto
     *  @param {ReorderPosition=} Where to drop in relation to recordNum
     */
    open fun getDropIndex(recordNum: Number?, reorderPosition: 
                                                               /**
                                                                *  Drop the drag-item before the target-row
                                                                *  Drop the drag-item after the target-row
                                                                *  Drop the drag-item over (onto) the target-row
                                                                */
                                                               String /* before |  after |  over */?): Number = definedExternally
    /**
     *   Called when (cell-based) selection changes within this grid.
     * 
     * 
     *  @param {Array<any>} Array of cells whos selected state was modified.
     */
    open fun cellSelectionChanged(cellList: Array<dynamic>): Boolean = definedExternally
    /**
     *   Called when (row-based) selection changes within this grid. Note this method fires for
     *   each record for which selection is modified - so when a user clicks inside a grid this
     *   method will typically fire twice (once for the old record being deselected, and once for
     *   the new record being selected).
     * 
     *   NOTE: For updating other components based on selections or triggering selection-oriented
     *   events within an application, see the
     *   DataBoundComponent.selectionUpdated event
     *   which is likely more suitable. Calls to ListGrid.getSelection
     *   from within this event may not return a valid set of selected records if the event has
     *   been triggered by a call to DataBoundComponent.selectAllRecords
     *   or DataBoundComponent.deselectAllRecords - in this case
     *   use the DataBoundComponent.selectionUpdated event instead.
     * 
     * 
     *  @param {ListGridRecord} record for which selection changed
     *  @param {boolean} New selection state (true for selected, false for unselected)
     */
    open fun selectionChanged(record: ListGridRecord, state: Boolean): Unit = definedExternally
    /**
     *   Called when the selection changes. Note that this method fires exactly once for any given
     *   change to the selection unlike the ListGrid.selectionChanged event.
     * 
     *   This event is fired once after selection/deselection has completed. The result is
     *   one event per mouse-down event. For a drag selection there will be two events fired:
     *   one when the first record is selected and one when the range is completed.
     * 
     *   This event is also fired when selection is updated by a direct call to one of the
     *   DataBoundComponent select/deselect methods. Calls on the Selection
     *   object do not trigger this event.
     * 
     * 
     *  @param {object} first selected record in the selection, if any, which may or may not be the first record in sort order if the DataBoundComponent is sorted. This parameter is typically used when only one record can be selected at a time.
     *  @param {Array<Partial<object>>} List of records that are now selected
     */
    override fun selectionUpdated(record: dynamic, recordList: Array<dynamic>): Unit = definedExternally
    /**
     *   Setter method for ListGrid.canFreezeFields
     * 
     *  @param {boolean} New value for listGrid.canFreezeFields
     */
    open fun setCanFreezeFields(canFreeze: Boolean): Unit = definedExternally
    /**
     *   Return the left offset (in local coordinate space) of a particular column.
     * 
     *  @param {Integer} number of the column
     */
    open fun getColumnLeft(colNum: Number): Number = definedExternally
    /**
     *   Return the left coordinate for a given column number as a GLOBAL coordinate
     * 
     *  @param {Integer} number of the column
     */
    open fun getColumnPageLeft(colNum: Number): Number = definedExternally
    /**
     *   Return the width of a particular column.
     * 
     *  @param {number} number of the column
     */
    open fun getColumnWidth(colNum: Number): Number = definedExternally
    /**
     *   Returns the page offsets and size of the cell at the passed row and column. If auto-sizing
     *   is enabled, sizes are not definitive until the grid has finished drawing, so calling this
     *   method before drawing completes will return the configured column sizes.
     * 
     *  @param {number} row index of the cell
     *  @param {number} column index of the cell
     */
    open fun getCellPageRect(rowNum: Number, colNum: Number): Array<dynamic> = definedExternally
    /**
     *   Freeze the indicated field, so that it remains in place and visible when horizontal
     *   scrolling occurs.
     * 
     * 
     *  @param {ListGridField | Integer | string | Array<any>} field or fields to freeze. fields may be specified as ListGridField objects, field names or colNum.
     */
    open fun freezeField(field: dynamic): Unit = definedExternally
    /**
     *   Unfreeze a frozen field, so that it will now scroll along with other fields when horizontal
     *   scrolling occurs.
     * 
     * 
     *  @param {ListGridField | Integer | string | Array<any>} field or fields to unfreeze. fields may be specified as ListGridField objects, field names or colNum.
     */
    open fun unfreezeField(field: dynamic): Unit = definedExternally
    /**
     *   Freeze or unfreeze the indicated field according to whether it is currently frozen.
     * 
     *   Called when the ListGrid freezes or unfreezes fields by user action.
     * 
     * 
     *  @param {ListGridField | Integer | string | Array<any>} field or fields to freeze. fields may be specified as ListGridField objects, field names or colNum.
     */
    open fun toggleFrozen(field: dynamic): Unit = definedExternally
    /**
     *   Returns the primary ListGrid.body, which, when there are frozen fields, is the
     *   GridRenderer used to render the non-frozen portion of the dataset; otherwise, the
     *   primary body (the only body) is the GridRenderer used to render the entire dataset.
     * 
     */
    open fun getBody(): GridRenderer = definedExternally
    /**
     *   Get the drawn height of a row.
     * 
     * 
     * \* @param {number} 
     */
    open fun getDrawnRowHeight(rowNum: Number): Number = definedExternally
    /**
     *   Return the height this row should be. Default is this.cellHeight. If
     *   ListGrid.fixedRecordHeights is false, the row may be rendered taller than this
     *   specified size.
     * 
     *   If records will be variable height,
     *   you should switch on ListGrid.virtualScrolling.
     * 
     *   Note if ListGrid.allowRowSpanning is enabled,
     *   this method should return the height of a single row (with rowSpan set to 1).
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord
     *  @param {number} row number
     */
    open fun getRowHeight(record: ListGridRecord, rowNum: Number): Number = definedExternally
    /**
     *   This method is called to retrieve the ListGrid.rollOverCanvas when
     *   the user moves over a new row or cell if ListGrid.showRollOverCanvas is true,
     *   or when the user moves over the selected record if ListGrid.showSelectedRollOverCanvas
     *   is true.
     * 
     *   The default implementation uses the AutoChild subystem to create the ListGrid.rollOverCanvas
     *   auto child. It may be overridden for custom behavior.
     * 
     *   Note that for efficiency this should not typically create a new Canvas every time that it is
     *   called. Instead usually a single rollOver canvas should be created and updated to reflect
     *   the current rollOver row if necessary.
     * 
     *   Return null to avoid showing a rollOverCanvas for this row.
     * 
     *   See also ListGrid.getFrozenRollOverCanvas.
     * 
     * 
     * 
     *  @param {Integer} index of the current rollOver row.
     *  @param {Integer} index of the current rollOver column. This parameter will be null unless ListGrid.useCellRollOvers is true for the grid.
     */
    open fun getRollOverCanvas(rowNum: Number, colNum: Number): Canvas = definedExternally
    /**
     *   For grids with frozen columns, this method is called to retrieve the
     *   ListGrid.frozenRollOverCanvas when
     *   the user moves over a new row or cell if ListGrid.showRollOverCanvas is true,
     *   or when the user moves over the selected record if ListGrid.showSelectedRollOverCanvas
     *   is true.
     * 
     *   The default implementation uses the AutoChild subystem to create the ListGrid.frozenRollOverCanvas
     *   based on the rollOverCanvas auto child settings.
     *   It may be overridden for custom behavior.
     * 
     *   Note that for efficiency this should not typically create a new Canvas every time that it is
     *   called. Instead usually a single rollOver canvas should be created and updated to reflect
     *   the current rollOver row if necessary.
     * 
     *   Return null to avoid showing a rollOverCanvas for this row.
     * 
     *   See also ListGrid.getRollOverCanvas.
     * 
     * 
     * 
     *  @param {Integer} index of the current rollOver row.
     *  @param {Integer} index of the current rollOver column. This parameter will be null unless ListGrid.useCellRollOvers is true for the grid.
     */
    open fun getFrozenRollOverCanvas(rowNum: Number, colNum: Number): Canvas = definedExternally
    /**
     *   This method is called to retrieve the ListGrid.rollUnderCanvas when
     *   the user moves over a new row or cell if
     *   ListGrid.showRollUnderCanvas or showing a
     *   ListGrid.showSelectedRollUnderCanvas.
     * 
     *   The default implementation uses the AutoChild subystem to create the ListGrid.rollUnderCanvas
     *   auto child. It may be overridden for custom behavior.
     * 
     *   Note that for efficiency this should not typically create a new Canvas every time that it is
     *   called. Instead usually a single rollOver canvas should be created and updated to reflect
     *   the current rollOver row if necessary.
     * 
     *   Return null to avoid showing a rollUnderCanvas for this row.
     * 
     *   See also ListGrid.getFrozenRollUnderCanvas.
     * 
     * 
     * 
     *  @param {Integer} index of the current rollOver row.
     *  @param {Integer} index of the current rollOver column. This parameter will be null unless ListGrid.useCellRollOvers is true for the grid.
     */
    open fun getRollUnderCanvas(rowNum: Number, colNum: Number): Canvas = definedExternally
    /**
     *   For grids with frozen columns, this method is called to retrieve the
     *   ListGrid.frozenRollUnderCanvas when
     *   ListGrid.showRollUnderCanvas or showing a
     *   ListGrid.showSelectedRollUnderCanvas.
     * 
     *   The default implementation uses the AutoChild subystem to create the ListGrid.rollUnderCanvas
     *   auto child. It may be overridden for custom behavior.
     * 
     *   Note that for efficiency this should not typically create a new Canvas every time that it is
     *   called. Instead usually a single rollOver canvas should be created and updated to reflect
     *   the current rollOver row if necessary.
     * 
     *   Return null to avoid showing a rollUnderCanvas for frozen fields for this row.
     * 
     *   See also ListGrid.getRollUnderCanvas.
     * 
     * 
     * 
     *  @param {Integer} index of the current rollOver row.
     *  @param {Integer} index of the current rollOver column. This parameter will be null unless ListGrid.useCellRollOvers is true for the grid.
     */
    open fun getFrozenRollUnderCanvas(rowNum: Number, colNum: Number): Canvas = definedExternally
    /**
     *   Method to update properties on a field's header button at runtime.
     *   This property allows customization of any settable properties on the ListGridField's
     *   header button after it has been generated.
     * 
     *  @param {string} Field to update
     *  @param {Canvas} new properties to apply to the header button
     */
    open fun setFieldButtonProperties(name: String, properties: Canvas): Unit = definedExternally
    /**
     *   Method to update properties on a headerSpan's header button at runtime.
     *   This property allows customization of any settable properties on the HeaderSpan's
     *   header button after it has been generated.
     * 
     *  @param {string} HeaderSpan.name of span to update
     *  @param {Canvas} new properties to apply to the header button
     */
    open fun setHeaderSpanButtonProperties(name: String, properties: Canvas): Unit = definedExternally
    /**
     *   Modify the height of a listGrid. To hide the header set height to zero.
     * 
     *  @param {number} new height for the header
     */
    open fun setHeaderHeight(height: Number): Unit = definedExternally
    /**
     *   Show or hide the ListGrid header.
     * 
     *  @param {boolean} true to show the header, false to hide it.
     */
    open fun setShowHeader(show: Boolean): Unit = definedExternally
    /**
     *   Is the field title for the specified field clipped?
     * 
     * 
     *  @param {number} field number for the header button title to test
     */
    open fun headerTitleClipped(fieldNum: Number): Boolean = definedExternally
    /**
     *   Returns the HTML that is displayed by the default ListGrid.headerHover
     *   handler. Return null or an empty string to cancel the hover.
     * 
     * 
     * 
     *  @param {number} field number for the header that was hovered
     *  @param {HTMLString} the HTML that would have been displayed by default
     */
    open fun headerHoverHTML(fieldNum: Number, defaultHTML: String): String = definedExternally
    /**
     *   Handle a click in the list header.
     * 
     *   By default, calls ListGrid.sort to sort by the field that was clicked, if
     *   ListGrid.canSort, and calls ListGrid.autoFitField if
     *   ListGrid.canAutoFitFields is true and ListGrid.headerAutoFitEvent is set to "click".
     * 
     * 
     *  @param {number} field number for the header that was clicked
     */
    open fun headerClick(fieldNum: Number): Unit = definedExternally
    /**
     *   Handle a double click in the list header.
     * 
     *   By default, calls ListGrid.autoFitField if ListGrid.canAutoFitFields is true and
     *   ListGrid.headerAutoFitEvent is "doubleClick".
     * 
     * 
     *  @param {number} field number for the header that was clicked
     */
    open fun headerDoubleClick(fieldNum: Number): Unit = definedExternally
    /**
     *   Reorder a particular field
     * 
     * 
     *  @param {number} Number of the field to reorder
     *  @param {number} New position for that field
     */
    open fun reorderField(fieldNum: Number, moveToPosition: Number): Unit = definedExternally
    /**
     *   Reorder a set of adjacent fields, from start to end exclusive at the end, by distance
     *   moveDelta.
     * 
     *   NOTE: start and end coordinates are in terms of the currently visible fields, not the full set of
     *   fields.
     * 
     * 
     *  @param {number} Start of the range of fields to move, inclusive
     *  @param {number} End of the range of fields to move, non-inclusive
     *  @param {number} Distance to move by
     */
    open fun reorderFields(start: Number, end: Number, moveDelta: Number): Unit = definedExternally
    /**
     *   Setter method for updating ListGrid.canResizeFields at runtime.
     * 
     *  @param {boolean} new value for this.canResizeFields
     */
    open fun setCanResizeFields(canResize: Boolean): Unit = definedExternally
    /**
     *   Resize a particular field to a new width. Note that this method
     *   will also set ListGridField.autoFitWidth to false if it was previously true.
     * 
     * 
     *  @param {number} Number of the field to resize
     *  @param {number} New width of the field
     */
    open fun resizeField(fieldNum: Number, newWidth: Number): Unit = definedExternally
    /**
     *   Notification method fired when the user right-clicks on the corner
     *   ListGrid.sorterConstructor. Return false to suppress the default
     *   behavior of showing the sorter's context menu.
     * 
     * 
     */
    open fun sorterContextClick(): Boolean = definedExternally
    /**
     *   If ListGrid.showHeaderContextMenu is true this method is fired
     *   when the user right-clicks on the header for this grid.
     *   Default implementation will display a menu with entries derived from
     *   ListGrid.getHeaderContextMenuItems for the appropriate column.
     * 
     *  @param {Canvas} which button in the header received the right-click event            (may be the sorter button or header menu button)
     *  @param {Array<any>=} Optional 2-element array specifying position at which the menu should              be shown. If this is not passed in the menu will be shown at the              mouseEvent position (default context menu behavior).
     */
    open fun displayHeaderContextMenu(target: Canvas, position: Array<dynamic>?): Unit = definedExternally
    /**
     *   If we're showing a ListGrid.showHeaderContextMenu for this grid and
     *   ListGrid.canFreezeFields is true, this string will be shown as the
     *   title for the menu item to toggle whether a field is frozen or unfrozen.
     * 
     *   Default implementation evaluates and returns ListGrid.freezeFieldText or
     *   ListGrid.unfreezeFieldText depending on whether the field is currently frozen.
     * 
     *  @param {ListGridField} field to get the menu item title for
     */
    open fun getToggleFreezeText(field: ListGridField): String = definedExternally
    /**
     *   If we're showing a ListGrid.showHeaderContextMenu for this grid and
     *   ListGrid.canGroupBy is true, this string will be shown as the
     *   title for the menu item to toggle the group by setting for a field.
     *   Default implementation evaluates and returns the dynamic ListGrid.groupByText
     *   string.
     * 
     *  @param {ListGridField} field to get the menu item title for
     */
    open fun getGroupByText(field: ListGridField): String = definedExternally
    /**
     *   Return the menus items that should be shown in a menu triggered from a
     *   ListGrid.headerSpans.
     * 
     * 
     *  @param {HeaderSpan} the component representing the headerSpan. This component will              have all the properties specified via ListGrid.headerSpans.
     */
    open fun getHeaderSpanContextMenuItems(headerSpan: HeaderSpan): Array<dynamic> = definedExternally
    /**
     *   If ListGrid.showHeaderContextMenu is true this method returns
     *   the menu items to be displayed in the default header context menu.
     * 
     *   This method is called at various times, including during redraws, as the mouse moves over a
     *   ListGrid header button and each time the menu is actually displayed - this allows for
     *   dynamic content depending on the current state of the grid and its fields.
     * 
     *   Consequently, this method should not instantiate any classes, because they'll be re-created
     *   on each call, resulting in a leak - your implementation should return an array of menuItem
     *   config-blocks only, so you shouldn't instantiate actual Menu instances to apply as the
     *   MenuItem.submenu of items - instead, set submenu to a simple array of
     *   menuItems. If your use-case necessitates that class instances are created, because specific
     *   submenus have a different Menu class, for example, you should keep a reference to them and
     *   either, if their content is dynamic, destroy and recreate them with the new items, or just
     *   return the existing instances otherwise.
     * 
     *   The default set of menu items includes items for built-in ListGrid features like showing
     *   and hiding fields, freezing fields or grouping by them, and other functions.
     * 
     * 
     *  @param {Integer=} Index of the field the user clicked in the  ListGrid.fields array. Note: if the user right-clicked the sorter button   this parameter will be null.
     */
    open fun getHeaderContextMenuItems(fieldNum: Number?): Array<dynamic> = definedExternally
    /**
     *   Notification method fired when the user clicks on the corner
     *   ListGrid.sorterConstructor. Return false to suppress the sort.
     * 
     * 
     */
    open fun sorterClick(): Boolean = definedExternally
    /**
     *   Turn sorting off, typically because data has changed and is no longer sorted.
     * 
     *   Calling unsort() disables visual indication of which columns are sorted,
     *   and calls unsort() on the underlying dataset.
     * 
     *   Note that a grid viewing a paged dataset may not be able to support unsort()
     *   because the sort order is what establishes the row numbering that allows data to be
     *   fetched in batches.
     * 
     *   unsort() is automatically called when records are dropped or the
     *   ListGrid.setSort is altered.
     * 
     * 
     */
    open fun unsort(): Unit = definedExternally
    /**
     *   If a list has become unsorted due to data modification or a call to
     *   ListGrid.unsort, this method will resort the list by the previous
     *   ListGrid.setSort array, if there is one, or by the previous
     *   sort-field and -direction.
     * 
     * 
     */
    open fun resort(): Unit = definedExternally
    /**
     *   Sort this grid's data, with the option to explicitly specify a single field to
     *   sort by and sort direction.
     * 
     *   If sortField is not provided and listGrid.sortField is undefined, the data will be sorted
     *   by the first sortable column according to ListGridField.sortDirection if specified,
     *   or ListGrid.sortDirection.
     * 
     *   ListGrids also support multiple-field sorting. See ListGrid.setSort for details.
     * 
     *   Note that for editable grids, sorting is performed by underlying data values, not
     *   for unsaved ListGrid.getEditValues.
     * 
     * 
     *  @param {string | number=} the field name or column number to sort by
     *  @param {SortDirection=} the direction to sort in
     */
    open fun sort(sortField: dynamic?, sortDirection: 
                                                      /**
                                                       *  Sort in ascending order (eg: A-Z, larger items later in the list)
                                                       *  Sort in descending order (eg: Z-A, larger items earlier in the list)
                                                       */
                                                      String /* ascending |  descending */?): Boolean = definedExternally
    /**
     *   Returns the current sort field for this grid. Note that if ListGrid.setSort has been
     *   used to sort by multiple fields, you can call ListGrid.getSort to retrieve details about
     *   the complete sort applied to the grid.
     * 
     * 
     */
    open fun getSortField(): String = definedExternally
    /**
     *   Show a dialog to configure the sorting of multiple fields on this component. Calls through
     *   to MultiSortDialog.askForSort, passing this component as the fieldSource and the
     *   current DataBoundComponent.getSort if there is one.
     * 
     *   The generated multiSortDialog can be customized via ListGrid.multiSortDialogDefaults,
     *   ListGrid.multiSortDialogProperties.
     * 
     * 
     */
    override fun askForSort(): Unit = definedExternally
    /**
     *   Toggles the sort-direction of the field with the passed name and resorts the grid.
     * 
     *  @param {string} The name of a field, visible, hidden or existing only in the  dataSource
     */
    open fun toggleSort(fieldName: String): Unit = definedExternally
    /**
     *   Adds another SortSpecifier to this grid's sort configuration and resorts.
     * 
     *  @param {SortSpecifier} A SortSpecifier object indicating an additional field  and direction to sort by
     */
    open fun addSort(sortSpecifier: SortSpecifier): Unit = definedExternally
    /**
     *   Returns the current SortSpecifier for this ListGrid. Will return null if this grid
     *   has never been sorted (and has no specified ListGrid.initialSort or ListGrid.sortField).
     * 
     *   Note that if sorting was applied via ListGrid.sort [rather than ListGrid.setSort] the
     *   sortSpecifiers returned will have been created based on the specified sort field / direction
     *   passed into ListGrid.sort.
     * 
     * 
     */
    override fun getSort(): Array<dynamic> = definedExternally
    /**
     *   Returns the SortSpecifier for the passed fieldName, or null if the field is not
     *   sorted.
     * 
     *  @param {string} The name of a field, visible, hidden or existing only in the dataSource
     */
    open fun getSortSpecifier(fieldName: String): SortSpecifier = definedExternally
    /**
     *   Returns the number of fields involved in this grid's current sort configuration.
     * 
     */
    open fun getSortFieldCount(): Number = definedExternally
    /**
     *   Returns true if the passed fieldName is in the current sort-specification.
     * 
     *  @param {string} The name of a field, visible, hidden or existing only in the dataSource
     */
    open fun isSortField(fieldName: String): Boolean = definedExternally
    /**
     *   When multiple fields are sorted, this method returns the HTML for the sort-numeral that
     *   appears after the sort-arrows in the header-buttons of sorted fields. If you don't want
     *   sort-numerals in the header-buttons, you can override this
     *   method to return null or an empty string, or set ListGrid.showSortNumerals to false.
     * 
     *   Note that the sortIndex passed in is zero based. The default implementation of this method
     *   returns an HTML element with the ListGrid.sortNumeralStyle applied to it, containing the
     *   specified sortIndex incremented by 1 (therefore showing the more user-friendly 1-based
     *   numbering system).
     * 
     * 
     *  @param {string} The name of a sort-field to get the ListGrid.sortNumeralStyle HTML for.
     *  @param {Integer} The sort index for the field.
     */
    open fun getSortNumeralHTML(fieldName: String, sortIndex: Number): String = definedExternally
    /**
     *   This method clears any existing sort on this grid by calling ListGrid.setSort with
     *   a null parameter. The internal list of SortSpecifiers is removed and the grid is
     *   unsorted.
     * 
     */
    open fun clearSort(): Unit = definedExternally
    /**
     */
    open fun getSortByGroupFirst(): Unit = definedExternally
    /**
     * \* @param {boolean} 
     */
    open fun setSortByGroupFirst(sortByGroupFirst: Boolean): Unit = definedExternally
    /**
     *   Optional notification fired when either user or framework code calls
     *   ListGrid.setSort. This notification fires before the default behavior;
     *   return false from the handler
     *   to cancel the default behavior. Note,
     *   the notification is fired before the default functionality, but after prechecks
     *   have completed; your method will only be called if the default behavior would have been
     *   called. For example, if there are pending edits and the user does not confirm that these
     *   should be saved, normal sorting would not have gone ahead, so equally your handler will
     *   not be called.
     * 
     *   The default setSort() method does two things to reflect the set of
     *   SortSpecifiers passed to it:
     * 
     *  - Change the grid UI (show directional arrows, numerals to indicate sort priority, etc)
     * 
     *  - Actually sort the grid data
     * 
     *   If your reason for implementing a custom setSortHandler() is to inhibit or
     *   replace one of those behaviors, you should cancel the default behavior and directly invoke
     *   just that part of it you require. The following implementation will replicate the default
     *   behavior:
     *    setSortHander : function(sortSpecifiers) {
     *      this.displaySort(sortSpecifiers);
     *      this.applySortToData(sortSpecifiers);
     *      return false; // Prevent the framework from running its own default impl
     *    }
     * 
     * 
     * 
     *  @param {Array<Partial<SortSpecifier>>} Array of SortSpecifier objects
     */
    open fun setSortHandler(sortSpecifiers: Array<dynamic>): Boolean = definedExternally
    /**
     *   Sort the grid on one or more fields.
     * 
     *   Pass in an array of SortSpecifiers to have the grid's data sorted by the fields in
     *   each SortSpecifier.property and in the directions specified. The
     *   grid can be sorted by any combination of fields, including fields specified in the fields
     *   array, whether visible or hidden, and DataSource.fields, if there is one.
     * 
     *   If multiple fields are sorted, those that are visible show a directional icon and a small
     *   ListGrid.sortNumeralStyle
     *   indicating that field's index in the sort configuration.
     * 
     *   See ListGrid.addSort and ListGrid.toggleSort APIs
     *   for information on making changes to the current sort configuration.
     * 
     *   Note that for editable grids, sorting is performed by underlying data values, not
     *   for unsaved ListGrid.getEditValues.
     * 
     * 
     *  @param {Array<Partial<SortSpecifier>>} Array of SortSpecifier objects
     */
    override fun setSort(sortSpecifiers: Array<dynamic>): Unit = definedExternally
    /**
     *   Modify the grid UI to reflect the parameter sortSpecifiers. For a single sortSpecifier,
     *   this consists of marking the field with a directional arrow in its header button (if it
     *   visible).
     * 
     *   If multiple fields are sorted, those that are visible show a directional icon and a small
     *   ListGrid.sortNumeralStyle indicating that field's index in the sort
     *   configuration.
     * 
     *   See ListGrid.addSort and ListGrid.toggleSort APIs
     *   for information on making changes to the current sort configuration.
     * 
     *   NOTE: This method is primarily used by ListGrid.setSort; it is not intended
     *   to be called by user code, unless you are implementing a custom
     *   ListGrid.setSortHandler). For the normal use case, calling this
     *   method directly will fail to execute vital pre-steps. If you are not implementing a custom
     *   handler as described above, do not call this method directly - call setSort()
     *   instead.
     * 
     * 
     *  @param {Array<Partial<SortSpecifier>>} Array of SortSpecifier objects
     */
    open fun displaySort(sortSpecifiers: Array<dynamic>): Unit = definedExternally
    /**
     *   Sort the grid's data to reflect the parameter sortSpecifiers.
     * 
     *   NOTE: This method is primarily used by ListGrid.setSort; it is not intended
     *   to be called by user code, unless you are implementing a custom
     *   ListGrid.setSortHandler). For the normal use case, calling this
     *   method directly will fail to execute vital pre-steps. If you are not implementing a custom
     *   handler as described above, do not call this method directly - call setSort()
     *   instead.
     * 
     * 
     *  @param {Array<Partial<SortSpecifier>>} Array of SortSpecifier objects
     */
    open fun applySortToData(sortSpecifiers: Array<dynamic>): Unit = definedExternally
    /**
     *   Attaches the component to the provided record. If position is specified as
     *   "within" Canvas.snapTo and Canvas.snapOffsetLeft,
     *   Canvas.snapOffsetTop may be set to specify where the component
     *   will render within the cell or record. If unset, for components embedded within a record
     *   we will default to embedding at the top/left coordinate, and for components embedded within
     *   a cell, we will respect the align / valign properties for the cell in question. Any
     *   percentage sizing will be interpreted as percentage of row size.
     * 
     *   Otherwise it will appear to be embedded within the record, underneath the field values.
     * 
     *   Embedded components become children of the grid and will stay attached to a record through
     *   scrolling, sorting and other operations that cause records to shift position.
     * 
     *   If position is set to "expand", embedded components may offer a
     *   resize interface, eg, by setting ListGridField.canDragResize:true,
     *   and the grid will react accordingly, growing or shrinking the record to match the embedded
     *   component's new extents.
     * 
     *   Embedded components can be explicitly removed with ListGrid.removeEmbeddedComponent.
     * 
     *   If a record is removed from the dataset or is replaced in the dataset, for example, it is
     *   eliminated through filtering (removes record) or is successfully edited in a databound grid
     *   (replaces record), the component is cleared but not logically removed from the grid. It is the
     *   responsibility of code that sets up the embedded component to remove it if the record is removed
     *   from the dataSet.
     * 
     *   When embedding components will result in variable height records,
     *   you should switch on ListGrid.virtualScrolling.
     * 
     * 
     *  @param {Canvas} component to embed
     *  @param {ListGridRecord} record to attach the component to
     *  @param {Integer=} rowNum of the record to attach the component to
     *  @param {Integer=} colNum in which to embed the component
     *  @param {EmbeddedPosition=} positioning with respect to the record or cell (Defaults to "expand").
     */
    open fun addEmbeddedComponent(component: Canvas, record: ListGridRecord, rowNum: Number?, colNum: Number?, position: 
                                                                                                                         /**
                                                                                                                          *  component should be placed underneath normal record or cell content,    expanding the records. Expanding records can result in variable height rows,
                                                                                                                          *      in which case ListGrid.virtualScrolling should be
                                                                                                                          *      enabled.
                                                                                                                          *  component should be placed within the normal area of the record or cell.    Percentage sizes will be treated as percentages of the record and
                                                                                                                          *      Canvas.snapTo positioning settings are also allowed and refer to the
                                                                                                                          *      rectangle of the record or cell. Note that for components embedded within cells,
                                                                                                                          *      cell align and vAlign will be used if snapTo is unset (so top / left alignment
                                                                                                                          *      of cell content will map to snapTo of "TL", etc).
                                                                                                                          */
                                                                                                                         String /* expand |  within */?): Unit = definedExternally
    /**
     *   Removes an embedded component previously associated with the provided record. If a Canvas
     *   is passed as the record parameter, it is assumed to be a component and the
     *   record is detected automatically from it. If
     *   destroyOnUnEmbed is true for the component, it will also be
     *   destroyed.
     * 
     * 
     *  @param {ListGridRecord | Canvas} record that the component was previously attached   to or the component itself
     *  @param {Integer | Canvas=} component to unembed, or the colNum in which it appears
     */
    open fun removeEmbeddedComponent(record: dynamic, component: dynamic?): Unit = definedExternally
    /**
     *   Retrieve the ListGrid.showRecordComponents currently being shown at the given
     *   coordinates.
     * 
     *   recordComponents are dynamically assigned to row/cell coordinates and, depending
     *   on the ListGrid.recordComponentPoolingMode, any kind of redraw of the containing
     *   ListGrid (due to sort change, scrolling, editing etc) may cause a
     *   recordComponent to be assigned to another row, Canvas.clear or
     *   permanently Canvas.destroy.
     * 
     *   Hence you should always call getRecordComponent() right before taking action on
     *   the recordComponent - don't cache the component associated with row/cell
     *   coordinate. Similarly, it's invalid to call getRecordComponent() during a redraw
     *   (for example, from ListGridField.formatCellValue code).
     * 
     *   It's always invalid to try to use a recordComponent outside of a ListGrid (by eg
     *   adding it to some other layout).
     * 
     *   If ListGrid.showRecordComponentsByCell is true and the colNum parameter is not passed, the call
     *   will return the first component in the passed rowNum.
     * 
     *   Returns null if there is no component at the specified coordinates.
     * 
     * 
     *  @param {Integer} row number to get record component for
     *  @param {Integer=} optional column number to get the record component for
     */
    open fun getRecordComponent(rowNum: Number, colNum: Number?): Canvas = definedExternally
    /**
     *   Chart the data in this listGrid as a multi-series chart.
     * 
     *   Each row provides a series of data. Each series of data is labeled by a value from one
     *   column, called the labelField.
     * 
     *   For example, cell values are sales figures, and fields are "Product", "August",
     *   "September", "October". In this case each row gives a series: sales figures for each of 3
     *   months. The labelField in this case is the "Product" field, meaning each row
     *   represents sales figures for each of 3 months for a particular product. This dataset
     *   can be charted via any multi-series chart: stacked or clustered bar or column chart, line
     *   chart with multiple lines, or area chart (stacked lines).
     * 
     *   By default, all visible fields other than the label field are assumed to be labels for
     *   series values, but an explicit list of fields can be provided as dataFields.
     * 
     *   By default, all data is charted if all data is loaded, otherwise, data visible in the
     *   viewport is charted. An explicit set of rows can be provided via dataRows.
     * 
     * 
     *  @param {string} name of the field
     *  @param {Array<Partial<string>>=} optional list of fields to use as labels. By   default, all fields are used.
     *  @param {Array<Partial<ListGridRecord>>=} set of records to chart. Can be obtained by eg   ResultSet.getRange.
     *  @param {FacetChart=} properties to pass to the created chart
     *  @param {boolean=} if true, use the labelField as the "first" set of labels,   for example, as the bar labels in a stacked bar chart, whereas the second set of labels    would appear as the legend.
     */
    open fun chartData(labelField: String, dataFields: Array<dynamic>?, dataRows: Array<dynamic>?, chartProperties: FacetChart?, labelFieldFirst: Boolean?): FacetChart = definedExternally
    /**
     *   Chart a single row of data, with each cell value labeled by the column header.
     * 
     * 
     *  @param {number} row to chart
     *  @param {Array<Partial<string>>=} optional list of fields to use as labels. By   default, all fields are used.
     *  @param {Chart=} properties to pass to the created chart
     */
    open fun chartRow(rowNum: Number, dataFields: Array<dynamic>?, chartProperties: Chart?): Chart = definedExternally
    /**
     *   Chart a single column of data, with each cell value labeled by a value from another
     *   column.
     * 
     * 
     *  @param {string} name of the ListGridField to use as a data
     *  @param {string} name of the ListGridField to use as labels for data
     *  @param {Chart=} properties to pass to the created chart
     */
    open fun chartColumn(dataColumn: String, labelColumn: String, chartProperties: Chart?): Chart = definedExternally
    /**
     *   Programmatically regroup the grid according to the current grouping configuration.
     * 
     * 
     */
    open fun regroup(): Unit = definedExternally
    /**
     *   For a ListGrid.groupByField grid, returns all the direct children of the supplied node
     *   in the ListGrid.groupTree if recordsOnly false. Otherwise, if
     *   recordsOnly is true, returns instead a list of all descendants under the
     *   supplied node that are actual records from the grid's original data - i.e. that are not other
     *   group nodes (for multi-grouping) or summary records.
     * 
     *   Note that null may be returned if the grid is not currently grouped or the supplied node is
     *   not a valid GroupNode.
     * 
     * 
     *  @param {GroupNode} node from ListGrid.groupTree
     *  @param {boolean} true to return all descendants that are actual                 records from the grid's original data, or false                  to return all immediate children of the supplied group node
     */
    open fun getGroupMembers(node: GroupNode, recordsOnly: Boolean): Array<dynamic> = definedExternally
    /**
     *   Display the current set of records grouped by their values for the given field or
     *   fields. With no arguments, disables all grouping.
     * 
     *   Grouping transforms the current dataset into a Tree on the fly, then provides a familiar tree
     *   interface for exploring the grouped data. Note that for performance reasons grouping
     *   is only available for dataSets with less than ListGrid.groupByMaxRecords entries.
     * 
     *   Grouping works automatically with any dataset, providing simple default grouping based on
     *   each field's declared type - see SimpleType.groupingModes for more information.
     *   Additionally, you can use ListGridField.getGroupValue
     *   to control how records are grouped, and
     *   ListGridField.getGroupTitle to control how groups are
     *   titled. You can affect multiple fields of the same data-type via the same-named APIs on an
     *   appropriate custom SimpleType.getGroupValue.
     * 
     *   Grouping can be performed programmatically via this API, or you can set
     *   ListGrid.canGroupBy to enable menus that allow the user to perform
     *   grouping. To group a grid automatically, instantiate the grid with a
     *   ListGrid.groupByField setting. To take action when an end use requests grouping,
     *   see ListGrid.handleGroupBy.
     * 
     *   While grouped, the automatically created Tree is available as
     *   ListGrid.groupTree and the original dataset is available as
     *   ListGrid.originalData.
     * 
     *   Before grouping can be performed, all records that match current
     *   ListGrid.fetchData must be loaded. If ListGrid.dataFetchMode is
     *   in use, not all matching records are cached, and the
     *   ResultSet.getLength is less than
     *   ListGrid.groupByMaxRecords, the grid will automatically request all unloaded records from the
     *   server, then perform grouping once they arrive.
     * 
     *   If the total number of rows available from the server exceeds ListGrid.groupByMaxRecords,
     *   calling groupBy will have no effect, and menu items for grouping will appear
     *   disabled.
     * 
     *   Grouping is often an asynchronous operation, both because of automatic loading of remaining
     *   rows, and because asynchronous processing is required to work around bugs in some browsers
     *   related to misdetection of "hung" scripts (see ListGrid.groupByAsyncThreshold). To be
     *   notified when grouping is complete, see ListGrid.groupByComplete.
     * 
     * 
     *  @param {Array<Partial<string>>=} name of fields to group by
     */
    open fun groupBy(vararg args: Any): Unit = definedExternally
    /**
     *   Returns the HTML code necessary to render a group node, including icon, title, and padding.
     *   The amount of the padding is at least ListGrid.groupLeadingIndent pixels, and
     *   an additional ListGrid.groupIndentSize pixels for each increasing level of the
     *   node.
     * 
     *   The result of this method will be displayed to the user for the
     *   appropriate row, either in a single cell which spans multiple columns, or in
     *   the ListGrid.groupTitleField. For the case where group titles are displayed
     *   in a cell spanning multiple columns, if this grid has frozen fields, this method
     *   may be run for both the frozen and unfrozen body. This method will return the html
     *   described above for the frozen body, and an empty string for the unfrozen body
     *   (or vice versa depending on ListGrid.showGroupTitleInFrozenBody). This ensures
     *   the groupNodeHTML is not displayed twice.
     * 
     * 
     *  @param {object} Specified group node
     *  @param {GridRenderer=} The body in which the returned value will be displayed. This parameter allows the default implementation to return an empty string if appropriate  for the case where there is both a frozen and unfrozen body. Note that if this parameter  may be empty. If not passed, the full group node HTML will be returned.
     */
    open fun getGroupNodeHTML(node: dynamic, gridBody: GridRenderer?): Unit = definedExternally
    /**
     *   If this grid ListGrid.isGrouped, this method will return the
     *   current selection. Unlike the standard ListGrid.getSelection,
     *   this method will return ListGrid.isGroupNode in addition to standard
     *   ListGridRecords within the grid's data.
     * 
     *  @param {boolean=} By default a group header node is considered  selected if any members of the group are selected. If this flag is passed in, only  header nodes where all members of the group are selected will be included  in the returned results.
     *  @param {boolean=} If this parameter is passed as true,  this method will return just the group header nodes from the group tree. If omitted  or false, both header nodes and data records will be returned.
     */
    open fun getGroupTreeSelection(excludePartialSelection: Boolean?, groupNodesOnly: Boolean?): Array<dynamic> = definedExternally
    /**
     *   Returns all selected records in this grid. If this grid is
     *   ListGrid.isGrouped, group header nodes will not be included in the
     *   returned array. Developers can make use of ListGrid.getGroupTreeSelection to
     *   get the selection including the selected group header nodes.
     * 
     *   NOTE: Records in the returned array should be treated as read-only and not
     *   modified.
     * 
     *  @param {boolean=} When true, partially selected records will not be returned.                  Otherwise, both fully and partially selected records are                  returned.
     */
    open fun getSelection(excludePartialSelections: Boolean?): Array<dynamic> = definedExternally
    /**
     *   If this listGrid is ListGrid.groupBy, is the record
     *   passed in a group header node.
     * 
     *  @param {ListGridRecord} record to test
     */
    open fun isGroupNode(record: ListGridRecord): Boolean = definedExternally
    /**
     *   Setter for ListGrid.showGroupSummaryInHeader
     * 
     *  @param {boolean} new showGroupSummaryInHeader state
     */
    open fun setShowGroupSummaryInHeader(showGroupSummaryInHeader: Boolean): Unit = definedExternally
    /**
     *   Setter for ListGrid.showCollapsedGroupSummary
     * 
     *  @param {boolean} new showCollapsedGroupSummary value
     */
    open fun setShowCollapsedGroupSummary(showCollapsedGroupSummary: Boolean): Unit = definedExternally
    /**
     *   Removes the grouping from the listGrid, restoring its original data
     * 
     * 
     */
    open fun ungroup(): Unit = definedExternally
    /**
     *   Update the headerSpans configuration on the grid dynamically.
     * 
     * 
     *  @param {Array<Partial<HeaderSpan>>} same configuration block as that passed to                     ListGrid.headerSpans.
     */
    open fun setHeaderSpans(headerSpans: Array<dynamic>): Unit = definedExternally
    /**
     *   Update the title of a ListGrid.headerSpans dynamically.
     * 
     * 
     *  @param {string} name of the headerSpan, as specified via HeaderSpan.name.
     *  @param {string} new title for the headerSpan
     */
    open fun setHeaderSpanTitle(name: String, newTitle: String): Unit = definedExternally
    /**
     *   Update the headerTitle of a ListGrid.headerSpans dynamically.
     * 
     * 
     *  @param {string} name of the headerSpan, as specified via HeaderSpan.name.
     *  @param {string} new headerTitle for the headerSpan
     */
    open fun setHeaderSpanHeaderTitle(name: String, newTitle: String): Unit = definedExternally
    /**
     *   Update the HeaderSpan.headerBaseStyle for a span within the grid at runtime.
     * 
     *  @param {string} name of the headerSpan, as specified via HeaderSpan.name.
     *  @param {CSSStyleName} new baseStyle for the headerSpan
     */
    open fun setHeaderSpanBaseStyle(name: String, newStyle: String): Unit = definedExternally
    /**
     *   Update the HeaderSpan.headerTitleStyle for a span within the grid at runtime.
     * 
     *  @param {string} name of the headerSpan, as specified via HeaderSpan.name.
     *  @param {CSSStyleName} new titleStyle for the headerSpan
     */
    open fun setHeaderSpanTitleStyle(name: String, newTitle: String): Unit = definedExternally
    /**
     *   Setter for the ListGrid.showGroupSummary attribute
     * 
     *  @param {boolean} new value for this.showGroupSummary
     */
    open fun setShowGroupSummary(showGroupSummary: Boolean): Unit = definedExternally
    /**
     *   Setter for the ListGrid.groupByFieldSummaries attribute
     * 
     *  @param {Array<Partial<string>>} new value for this.groupByFieldSummaries
     */
    open fun setGroupByFieldSummaries(groupByFieldSummaries: Array<dynamic>): Unit = definedExternally
    /**
     *   Open a MultiGroupDialog to configure the fields used for grouping.
     * 
     * 
     */
    open fun configureGrouping(): Unit = definedExternally
    /**
     *   Returns the original, ungrouped data in the grid. If the grid is ungrouped,
     *   returns method:ListGrid.getData.
     * 
     */
    open fun getOriginalData(): dynamic = definedExternally
    /**
     *   Returns the selected cells as a series of Records where each field value is stored under
     *   it's offset from the top-left of the selection. For example, a 2x2 cell selection starting
     *   from the first column would return two Records, each with two values stored under the names
     *   "0" and "1".
     * 
     *   If ListGrid.canSelectCells is not enabled, this API always returns null.
     * 
     * 
     */
    open fun getSelectedCellData(): dynamic = definedExternally
    /**
     *   Applies a set of Records containing coordinate-based data as returned by
     *   ListGrid.getSelectedCellData and applies the data at the current selection.
     * 
     *   For consistency with Excel, given a record in the cellData, after the data value with the
     *   most negative column index is found, the rest of the values in the record are applied
     *   contiguously to the right of it, using the positional data for ordering only.
     * 
     *   Will only modify cells in the grid which are editable, and changes will be applied
     *   as editValues, exactly as though the user had typed the values in (see
     *   editing).
     * 
     *   See also ListGrid.applyRecordData.
     * 
     * 
     *  @param {any} list of Records as described above
     */
    open fun applyCellData(cellData: dynamic): Unit = definedExternally
    /**
     *   Applies a list of Records as changes to the current selection.
     * 
     *   Values found in each of the passed records will be applied to the same-named fields in the
     *   Records starting from the top-left of the current selection, in order.
     * 
     *   Will only modify cells in the grid which are editable, and changes will be applied
     *   as editValues, exactly as though the user had typed the values in (see
     *   editing).
     * 
     *   See also ListGrid.applyCellData.
     * 
     * 
     *  @param {any} list of Records as described above
     */
    open fun applyRecordData(recordData: dynamic): Unit = definedExternally
    /**
     *   Fires after user edits have been successfully saved to the server, only for cells where the
     *   value was actually modified.
     * 
     *   If you want immediate notification of a changes before changes has been saved to the
     *   server, implement ListGridField.change or
     *   ListGridField.changed instead.
     * 
     *   You can alternatively use ListGridField.cellChanged to get notification only of
     *   saved changes for a specific field. If both a listGridField and the containing listGrid
     *   have a handler for this event, only the handler defined on the field is called.
     * 
     * 
     *  @param {ListGridRecord} record for the cell being changed
     *  @param {any} new value for the cell
     *  @param {any} old value for the cell
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     *  @param {ListGrid} grid where cell was changed. Also available as "this"
     */
    open fun cellChanged(record: ListGridRecord, newValue: dynamic, oldValue: dynamic, rowNum: Number, colNum: Number, grid: ListGrid): Unit = definedExternally
    /**
     *   Callback fired when inline edits have been successfully saved.
     * 
     *   No default implementation.
     * 
     * 
     *  @param {number} current index of the row that was saved
     *  @param {number} index of the column that was saved, if applicable
     *  @param {object | Record} new values that were saved
     *  @param {Record} the complete original values from before the save occurred
     *  @param {EditCompletionEvent} Event that led to the save
     *  @param {DSResponse=} for DataSource saves, DSResponse object returned
     */
    open fun editComplete(rowNum: Number, colNum: Number, newValues: dynamic, oldValues: Record, editCompletionEvent: 
                                                                                                                      /**
                                                                                                                       *  User clicked outside editor during edit.
                                                                                                                       *  User started editing another row by clicking on it
                                                                                                                       *  User started editing another row by double                clicking
                                                                                                                       *  Enter pressed.
                                                                                                                       *  User pressed Escape.
                                                                                                                       *  Up arrow key pressed.
                                                                                                                       *  down arrow key.
                                                                                                                       *  User pressed Tab.
                                                                                                                       *  User pressed Shift+Tab.
                                                                                                                       *  Edit moved to a different field (same row)
                                                                                                                       *  Edit completed via explicit function call
                                                                                                                       */
                                                                                                                      String /* click_outside |  click |  doubleClick |  enter |  escape |  arrow_up |  arrow_down |  tab |  shift_tab |  field_change |  programmatic */, dsResponse: DSResponse?): Unit = definedExternally
    /**
     *   Called when an attempt to save inline edits fails, due to a validation error or other
     *   server error.
     * 
     *   The default implementation of editFailed does nothing for normal validation errors,
     *   which are displayed before editFailed() is called. For any other errors, the default
     *   implementation will call RPCManager.handleError, which by default
     *   will result in a warning dialog.
     * 
     * 
     *  @param {number} current index of the row we attempted to save
     *  @param {number} index of the column where the edit failed, if applicable
     *  @param {object | Record} new values that we attempted to save
     *  @param {Record} the complete original values from before the save occurred
     *  @param {EditCompletionEvent} Edit completion event that led to the save                         attempt
     *  @param {DSResponse=} DSResponse, for saves through a DataSource
     */
    open fun editFailed(rowNum: Number, colNum: Number, newValues: dynamic, oldValues: Record, editCompletionEvent: 
                                                                                                                    /**
                                                                                                                     *  User clicked outside editor during edit.
                                                                                                                     *  User started editing another row by clicking on it
                                                                                                                     *  User started editing another row by double                clicking
                                                                                                                     *  Enter pressed.
                                                                                                                     *  User pressed Escape.
                                                                                                                     *  Up arrow key pressed.
                                                                                                                     *  down arrow key.
                                                                                                                     *  User pressed Tab.
                                                                                                                     *  User pressed Shift+Tab.
                                                                                                                     *  Edit moved to a different field (same row)
                                                                                                                     *  Edit completed via explicit function call
                                                                                                                     */
                                                                                                                    String /* click_outside |  click |  doubleClick |  enter |  escape |  arrow_up |  arrow_down |  tab |  shift_tab |  field_change |  programmatic */, dsResponse: DSResponse?): Unit = definedExternally
    /**
     *   Callback fired when the user starts editing a new cell.
     * 
     *   This callback is typically used to establish dynamic default values via
     *   ListGrid.setEditValue or ListGrid.setEditValues.
     * 
     *   Can also be overridden on a per-field basis via
     *   ListGridField.editorEnter.
     * 
     * 
     *  @param {ListGridRecord} record for the cell being edited. Will be null                for a new, unsaved record.
     *  @param {any} value for the cell being edited
     *  @param {Integer} row number for the cell
     *  @param {Integer} column number of the cell
     */
    open fun editorEnter(record: ListGridRecord, value: dynamic, rowNum: Number, colNum: Number): Unit = definedExternally
    /**
     *   Callback fired when the user starts editing a new row.
     * 
     * 
     *  @param {ListGridField} record for the cell being edited
     *  @param {object} edit values for the current row
     *  @param {number} row number for the cell
     */
    open fun rowEditorEnter(record: ListGridField, editValues: dynamic, rowNum: Number): Unit = definedExternally
    /**
     *   Callback fired when the user attempts to navigate away from the current edit cell,
     *   or complete the current edit.
     * 
     *   Return false from this method to cancel the default behavior (Saving / cancelling the
     *   current edit / moving to the next edit cell).
     * 
     *   This callback is typically used to dynamically update values or value maps for related
     *   fields (via ListGrid.setEditValue and ListGrid.setEditorValueMap respectively, or to
     *   implement custom navigation (via ListGrid.startEditing.
     * 
     *   Can be overridden at the field level as field.editorExit.
     * 
     * 
     *  @param {EditCompletionEvent} How was the edit completion fired?
     *  @param {ListGridRecord} record for the cell being edited
     *  @param {any} new value for the cell being edited
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun editorExit(editCompletionEvent: 
                                             /**
                                              *  User clicked outside editor during edit.
                                              *  User started editing another row by clicking on it
                                              *  User started editing another row by double                clicking
                                              *  Enter pressed.
                                              *  User pressed Escape.
                                              *  Up arrow key pressed.
                                              *  down arrow key.
                                              *  User pressed Tab.
                                              *  User pressed Shift+Tab.
                                              *  Edit moved to a different field (same row)
                                              *  Edit completed via explicit function call
                                              */
                                             String /* click_outside |  click |  doubleClick |  enter |  escape |  arrow_up |  arrow_down |  tab |  shift_tab |  field_change |  programmatic */, record: ListGridRecord, newValue: dynamic, rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Callback fired when the user attempts to navigate away from the current edit row,
     *   or complete the current edit.
     * 
     *   Return false from this method to cancel the default behavior (Saving / cancelling the
     *   current edit / moving to the next edit cell).
     * 
     * 
     *  @param {EditCompletionEvent} How was the edit completion fired?
     *  @param {ListGridRecord} record for the cell being edited
     *  @param {object} new values for the record [Note that fields that have                 not been edited will not be included in this object]
     *  @param {number} row number for the row being left
     */
    open fun rowEditorExit(editCompletionEvent: 
                                                /**
                                                 *  User clicked outside editor during edit.
                                                 *  User started editing another row by clicking on it
                                                 *  User started editing another row by double                clicking
                                                 *  Enter pressed.
                                                 *  User pressed Escape.
                                                 *  Up arrow key pressed.
                                                 *  down arrow key.
                                                 *  User pressed Tab.
                                                 *  User pressed Shift+Tab.
                                                 *  Edit moved to a different field (same row)
                                                 *  Edit completed via explicit function call
                                                 */
                                                String /* click_outside |  click |  doubleClick |  enter |  escape |  arrow_up |  arrow_down |  tab |  shift_tab |  field_change |  programmatic */, record: ListGridRecord, newValues: dynamic, rowNum: Number): Boolean = definedExternally
    /**
     *   Formatter to apply to values displayed within cells.
     * 
     *   The value passed to this method is either the field value found in the cell record
     *   or, if there are unsaved edits, the current user-entered value for the cell.
     *   NOTE: unsaved user edits may contain nulls, bad values or values of the wrong
     *   type, so formatters used for editable data should be bulletproof. For example, if you
     *   have a function "myNumberFormatter" that should only be passed actual Numbers, you might
     *   define formatCellValue like so:
     * 
     *     isc.isA.Number(parseInt(value)) ?
     *        myNumberFormatter(parseInt(value)) : value
     * 
     *   Note that this formatter will not be applied to the value displayed within editors for
     *   cells - use formatEditorValue to achieve this.
     * 
     *   If formatCellValue is defined at the field level for some cell being edited,
     *   the field level method will be used to format the edit value and this method will not
     *   be called for that cell.
     * 
     * 
     *  @param {any} raw value for the cell being
     *  @param {ListGridRecord} Record object for the cell. Note: If this is a new row that has not been saved, in an  editable grid, it has no associated record object. In this case the edit values will  be passed in as this parameter.
     *  @param {number} row number for the cell
     *  @param {number} column number for the cell.
     */
    open fun formatCellValue(value: dynamic, record: ListGridRecord, rowNum: Number, colNum: Number): String = definedExternally
    /**
     *   Formatter for inactive content.
     * 
     *   If present, this method will be invoked instead of ListGrid.formatCellValue in cases
     *   where the grid is rendering non-interactive content outside. Examples of cases
     *   where this can happen include:
     * 
     *  - dragTracker HTML for a row when ListGrid.dragTrackerMode is set to
     *    "record"
     * 
     *  - measurement HTML used for sizing columns during autoFit
     * 
     *  - measurement HTML used for sizing rows when ListGrid.fixedRecordHeights
     *     is false and the grid has both frozen and unfrozen fields
     * 
     *   May also be overridden at the ListGridField.formatInactiveCellValue.
     * 
     *   This is useful for cases where it would not be appropriate to render the
     *   standard formatted cell value outside of the body of the grid. An example might be
     *   if the formatted value contains a DOM element with a specified ID - an approach
     *   sometimes used for integrating third party components into SmartClient listGrid
     *   cells. In this case developers will wish to avoid having the framework render an
     *   element with the same ID outside of the grid, and should instead return HTML that
     *   would render at the same size, with an appropriate appearance.
     * 
     * 
     *  @param {any} raw value for the cell being
     *  @param {ListGridRecord} Record object for the cell. Note: If this is a new row that has not been saved, in an  editable grid, it has no associated record object. In this case the edit values will  be passed in as this parameter.
     *  @param {number} row number for the cell
     *  @param {number} column number for the cell.
     */
    open fun formatInactiveCellValue(value: dynamic, record: ListGridRecord, rowNum: Number, colNum: Number): String = definedExternally
    /**
     *   Formatter to apply to values displayed within editors while a cell is being edited.
     *   The value passed to this method is the raw value for the cell.
     *   If formatEditorValue is defined at the field level for some cell being edited,
     *   the field level method will be used to format the edit value and this method will not
     *   be called for that cell.
     *   To convert the formatted value displayed within an editor back to a raw value, the
     *   parseEditorValue method is used.
     * 
     * 
     *  @param {any} raw value for the cell being edited
     *  @param {ListGridRecord} Record object for the cell. Note: If this is a new row that has not been saved,  it has no associated record object. In this case the edit values will  be passed in as this parameter.
     *  @param {number} row number for the cell
     *  @param {number} column number for the cell.
     */
    open fun formatEditorValue(value: dynamic, record: ListGridRecord, rowNum: Number, colNum: Number): dynamic = definedExternally
    /**
     *   Method used to convert the value displayed in an editor for some cell being edited into
     *   a raw value for saving.
     *   If parseEditorValue is defined at the field level for some cell being edited,
     *   the field level method will be used to parse the edit value and this method will not
     *   be called for that cell.
     * 
     * 
     *  @param {any} value displayed in the editor for the cell
     *  @param {ListGridRecord} record object for the row being edited. May be null if this             is a new row being added to the end of the list.
     *  @param {number} row number for the cell
     *  @param {number} column number for the cell.
     */
    open fun parseEditorValue(value: dynamic, record: ListGridRecord, rowNum: Number, colNum: Number): dynamic = definedExternally
    /**
     *   Notification method executed when the ListGrid.setSort change
     *   for this grid.
     * 
     *  @param {Array<Partial<SortSpecifier>>} new sort specifiers - may be empty indicating  the grid was unsorted
     */
    open fun sortChanged(sortSpecifiers: Array<dynamic>): Unit = definedExternally
    /**
     *   Notification method executed when columns are resized or reordered, or fields are
     *   shown or hidden. Has no default implementation.
     * 
     * 
     */
    open fun fieldStateChanged(): Unit = definedExternally
    /**
     *   Notification method executed whenever the groupState of this grid changes.
     *   Group state is accessible via ListGrid.getGroupState, and contains group state
     *   information.
     * 
     * 
     */
    open fun groupStateChanged(): Unit = definedExternally
    /**
     *   Notification method executed whenever the viewState of this grid changes.
     *   View state is accessible via ListGrid.getViewState, and contains field state
     *   information, sort information, selection information, hiliting information and
     *   grouping information.
     * 
     * 
     */
    open fun viewStateChanged(): Unit = definedExternally
    /**
     *   Notification method fired when new data arrives from the server to be displayed in this
     *   ListGrid, (for example in response to the user scrolling a new set of rows into view).
     *   Only applies to databound listGrids where the ListGrid.data attribute is a
     *   ResultSet. This ResultSet may have been created manually and applied to the grid via
     *   a call to ListGrid.setData or may have been created and automatically assigned if
     *   ListGrid.fetchData was used to populate the grid. This method is fired directly in
     *   response to ResultSet.dataArrived firing on the data object.
     * 
     *   Note that dataArrived(), unlike ListGrid.dataChanged, only fires in limited
     *   circumstances - when data for a ResultSet arrives from the server due to a fetch
     *   or cache invalidation, or as a result of filtering. If you want to catch all data
     *   changes, you should instead react to ListGrid.dataChanged.
     * 
     * 
     *  @param {Integer} starting index of the newly loaded set of rows
     *  @param {Integer} ending index of the newly loaded set of rows (non inclusive).
     */
    open fun dataArrived(startRow: Number, endRow: Number): Unit = definedExternally
    /**
     *   Notification method fired when the ListGrid's data changes, for any reason.
     *   If overridden (rather than Class.observe), you must Class.Super to ensure proper Framework behavior.
     * 
     *   Examples of why data changed might be:
     * 
     *  - a call to ListGrid.addData, ListGrid.updateData, or ListGrid.removeData
     * 
     *  - DataSource updates from the server for ResultSet data
     *   (triggered by record editing, etc.)
     * 
     *  - fetches arriving back from the server for ResultSet data
     * 
     *  - changes to array data if made through APIs such as Array.set,
     *   Array.add, etc.
     * 
     *  - cache invalidation
     * 
     *  - filtering
     * 
     *   Calling ListGrid.setData doesn't call this notification directly, but it may
     *   fire if one of the above listed events is triggered (e.g. a server fetch for
     *   ResultSet data).
     * 
     *   Note that the operationType parameter is optional and will be passed and
     *   contain the operation (e.g. "update") if this notification was triggered by a fetch,
     *   an ListGrid.addData, ListGrid.updateData, or ListGrid.removeData, or a DataSource
     *   update for ResultSet data (the first three reasons listed above) but otherwise
     *   will be undefined.
     * 
     * 
     *  @param {string=} optionally passed operation causing the change
     */
    open fun dataChanged(operationType: String?): Unit = definedExternally
    /**
     *   Handle a hover over a button in the header.
     * 
     * 
     *  @param {number} field number for the header that was hovered
     */
    open fun headerHover(fieldNum: Number): Unit = definedExternally
    /**
     *   Notification method that fires when the drawArea changes due to scrolling. Receives
     *   the previous drawArea co-ordinates as parameters. Call ListGrid.getDrawArea to
     *   get the new drawArea co-ordinates.
     * 
     *   Note that if this grid is showing any ListGridField.frozen, they
     *   will not be included in the oldStartCol, oldEndCol range
     *   reported by this method. Frozen fields are assumed never to be scrolled out of view.
     * 
     * 
     *  @param {number} the startRow from before the drawArea changed
     *  @param {number} the endRow from before the drawArea changed
     *  @param {number} the startCol from before the drawArea changed
     *  @param {number} the endCol from before the drawArea changed
     */
    open fun drawAreaChanged(oldStartRow: Number, oldEndRow: Number, oldStartCol: Number, oldEndCol: Number): Unit = definedExternally
    /**
     *   When ListGrid.showRecordComponents is true, return false from this method
     *   to prevent the recordComponent system from processing the passed record or cell.
     * 
     *   If ListGrid.showRecordComponentsByCell is true,
     *   it is important to implement this method - especially if the grid has many fields -
     *   otherwise, the internal automatic detection will process every visible cell, checking,
     *   for example, whether a component already exists for that cell, before eventually running
     *   ListGrid.createRecordComponent to check if one is required. Implementing this
     *   method avoids all that processing for cells that aren't expected to have components.
     * 
     *   The second parameter is only applicable if ListGrid.showRecordComponentsByCell is true.
     * 
     * 
     *  @param {ListGridRecord} record being processed
     *  @param {Integer=} column index of the cell in which the record component  may be shown. Will be null unless showRecordComponentsByCell is true.
     */
    open fun showRecordComponent(record: ListGridRecord, colNum: Number?): Boolean = definedExternally
    /**
     *   When ListGrid.showRecordComponents is true, this method is called to create
     *   per-row or per-cell embedded components to display in the grid.
     * 
     *   The colNum parameter is applicable only when
     *   ListGrid.showRecordComponentsByCell is true.
     * 
     *   If this row should not have a recordComponent, return null.
     * 
     *   This method should create and return a new component for the record passed in every
     *   time it is called and never return the same Canvas instance twice. To re-use components
     *   with different rows, set RecordComponentPoolingMode to "recycle". In this mode,
     *   in addition to implementing this method, developers should also implement
     *   ListGrid.updateRecordComponent which allows already created components to be
     *   altered for re-use in new records. See the ListGrid.showRecordComponents overview
     *   for more information.
     * 
     * 
     *  @param {ListGridRecord} record to create a component for
     *  @param {Integer} cell to which the component applies
     */
    open fun createRecordComponent(record: ListGridRecord, colNum: Number): Canvas = definedExternally
    /**
     *   When ListGrid.showRecordComponents is true, this method is called to update
     *   components created by ListGrid.createRecordComponent when they are to be
     *   applied to a different record in the grid. See the
     *   ListGrid.showRecordComponents
     *   for more information on recordComponents.
     * 
     *   The colNum parameter is applicable only when
     *   ListGrid.showRecordComponentsByCell is true. Note that if
     *   ListGrid.poolComponentsPerColumn is set to false, the component may have been generated
     *   by a ListGrid.createRecordComponent call applied to a different field.
     * 
     *   Return null to avoid re-adding the component to the row or cell.
     * 
     * 
     *  @param {ListGridRecord} record to which the passed component applies
     *  @param {Integer} cell to which the passed component applies
     *  @param {Canvas} the component to update
     *  @param {boolean} was the passed component previously embedded in a   different record?
     */
    open fun updateRecordComponent(record: ListGridRecord, colNum: Number, component: Canvas, recordChanged: Boolean): Canvas = definedExternally
    /**
     *   Optional notification fired when the user performs a filter using the
     *   ListGrid.showFilterEditor. May fire as criteria values are being edited if
     *   ListGrid.filterOnKeypress is true, otherwise will fire when the user clicks the filter
     *   button or presses the Enter key while focus is in the Filter Editor.
     * 
     * 
     *   Return false
     *   to cancel the default behavior - you must cancel the default behavior if your
     *   code is going to call ListGrid.filterData, ListGrid.setCriteria or any other API that
     *   affects the criteria applied to the grid.
     * 
     *   The criteria parameter contains the current criteria applied to the
     *   grid including edits the user has just made using the Filter Editor. This matches
     *   what is returned if you call ListGrid.getFilterEditorCriteria.
     * 
     *   If you wish to access the criteria applied to the grid without picking
     *   up any edits to the Filter Editor, use ListGrid.getCriteria instead.
     * 
     *   Developers may wish to perform a filter using the Filter Editor values from code
     *   running outside the standard filterEditorSubmit flow. For example, if you wanted a
     *   confirmation dialog to be shown before filtering was performed, you would cancel the
     *   default behavior as described above, but then need to replicate the default behavior
     *   once the user confirms that they want to proceed. To replicate the default behavior,
     *   just call:
     * 
     *   grid.filterData(grid.getFilterEditorCriteria());
     * 
     *   or, to ensure the specified ListGrid.autoFetchTextMatchStyle is picked up
     * 
     * 
     *   grid.filterData(grid.getFilterEditorCriteria(),
     *       null, {textMatchStyle:grid.autoFetchTextMatchStyle});
     * 
     * 
     * 
     * 
     * 
     *  @param {Criteria} criteria derived from the filter editor values
     */
    open fun filterEditorSubmit(criteria: dynamic): Boolean = definedExternally
    /**
     *   Callback fired when the user attempts to group or ungroup the listGrid, or when
     *   ListGrid.groupBy is called programmatically.
     *   Return false to cancel grouping.
     * 
     * 
     *   This notification is fired before the ListGrid.groupTree is updated to
     *   reflect the grouping. See also ListGrid.groupByComplete.
     * 
     * 
     *  @param {Array<Partial<string>>} the list of ListGrid field-names by which the grid is         about to be grouped. If the grid is being ungrouped, this param will be         an empty array
     *  @param {Array<Partial<GroupSpecifier>>} list of GroupSpecifier objects detailing         grouping specifics for each grouped field
     */
    open fun handleGroupBy(fields: Array<dynamic>, specifiers: Array<dynamic>): Boolean = definedExternally
    /**
     *   Callback fired when the listGrid is grouped or ungrouped.
     * 
     *   Unlike ListGrid.handleGroupBy, this notification will fire when grouping
     *   is complete, and the ListGrid.data object has been updated.
     *   On successful grouping the fields argument will list the new
     *   grouping and the ListGrid.groupTree will have been updated to reflect the
     *   grouped data.
     * 
     *   Note that the fields argument may be an empty array if the data
     *   is not grouped. This implies that a user or developer explicitly ungrouped the
     *   grid, or that a groupBy attempt failed due to the data length exceeding
     *   ListGrid.groupByMaxRecords.
     * 
     * 
     *  @param {Array<Partial<string>>} ListGrid field names by which the grid is now grouped. If the grid is currently not grouped, this parameter will be an  empty array.
     */
    open fun groupByComplete(fields: Array<dynamic>): Unit = definedExternally
    /**
     *   Notification method executed whenever the end user uses the HiliteEditor to change
     *   the set of hilites applied to this grid. This method will not be called after
     *   a purely programmatic change to the hilites made with a call to
     *   DataBoundComponent.setHilites. The array of currently applied hilite objects is
     *   accessible via DataBoundComponent.getHilites.
     * 
     */
    open fun hilitesChanged(): Unit = definedExternally
    /**
     *   Optional stringMethod to fire when the user hovers over the error icon of a cell with
     *   validation errors. The default behavior is to show a hover canvas containing the
     *   validation error message text. Return false to suppress this default behavior.
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord()
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun cellErrorIconHover(record: ListGridRecord, rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Optional stringMethod to fire when the mouse moves over the error icon of a cell with
     *   validation errors.
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord()
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun cellErrorIconOver(record: ListGridRecord, rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Optional stringMethod to fire when the mouse moves off the error icon of a cell with
     *   validation errors.
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord()
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun cellErrorIconOut(record: ListGridRecord, rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Notification fired when a user either creates a new formula field or edits an existing formula field.
     * 
     *  @param {ListGridField} the formula field
     *  @param {UserFormula} the new or updated formula definition
     */
    open fun formulaUpdated(field: ListGridField, formula: UserFormula): Unit = definedExternally
    /**
     *   Notification fired when a user either creates a new summary field or edits an existing
     *   summary field.
     * 
     *  @param {ListGridField} the summary field
     *  @param {UserSummary} the new or updated summary definition
     */
    open fun summaryUpdated(field: ListGridField, summary: UserSummary): Unit = definedExternally
    /**
     *   This method is invoked on the source component whenever a drag operation or
     *   DataBoundComponent.transferSelectedData completes. This method is called when the entire chain of
     *   operations - including, for databound components, server-side updates and subsequent
     *   integration of the changes into the client-side cache - has completed.
     *   There is no default implementation of this method; you are intended to override it if you
     *   are interested in being notified when drag operations complete.
     * 
     * 
     */
    override fun dragComplete(): Unit = definedExternally
    /**
     *   This method is invoked whenever a drop operation or DataBoundComponent.transferSelectedData
     *   targeting this component completes. A drop is considered to be complete when all the client-
     *   side transfer operations have finished. This includes any server turnarounds SmartClient
     *   needs to make to check for duplicate records in the target component; it specifically does
     *   not include any add or update operations sent to the server for databound components. If
     *   you want to be notified when the entire drag operation - including server updates and cache
     *   synchronization - has completed, override DataBoundComponent.dragComplete
     *   on the source component.
     *   There is no default implementation of this method; you are intended to override it if you
     *   are interested in being notified when drop operations complete.
     * 
     * 
     *  @param {Array<Partial<Record>>} The list of records actually transferred to          this component (note that this is not necessarily the same thing as the           list of records dragged out of the source component because it doesn't           include records that were excluded because of collisions with existing           records)
     */
    override fun dropComplete(transferredRecords: Array<dynamic>): Unit = definedExternally
    /**
     *   For a component with a specified DataSource, find the associated dataSource field object
     *   from a specified DataPath.
     * 
     *  @param {DataPath} dataPath for which the field definition should be returned.
     */
    override fun getDataPathField(dataPath: String): Unit = definedExternally
    /**
     *   This API is equivalent to List.find but searches for a matching record among already-loaded data only.
     *   Use ListGrid.fetchData to load data from the server.
     * 
     *  @param {AdvancedCriteria} AdvancedCriteria to use with
     */
    override fun find(advancedCriteria: AdvancedCriteria): dynamic = definedExternally
    /**
     *   This API is equivalent to List.findAll but searches for a matching record among already-loaded data only.
     *   Use ListGrid.fetchData to load data from the server.
     * 
     *  @param {AdvancedCriteria} AdvancedCriteria to use with
     */
    override fun findAll(advancedCriteria: AdvancedCriteria): Array<dynamic> = definedExternally
    /**
     *   This API is equivalent to List.findIndex but searches for a matching record among already-loaded data only.
     *   Use ListGrid.fetchData to load data from the server.
     * 
     *  @param {AdvancedCriteria} AdvancedCriteria to use with
     */
    override fun findIndex(advancedCriteria: AdvancedCriteria): Number = definedExternally
    /**
     *   This API is equivalent to List.findNextIndex but searches for a matching record among already-loaded data only.
     *   Use ListGrid.fetchData to load data from the server.
     * 
     *  @param {Integer} first index to consider
     *  @param {AdvancedCriteria} AdvancedCriteria to use with
     *  @param {Integer=} last index to consider
     */
    override fun findNextIndex(startIndex: Number, advancedCriteria: AdvancedCriteria, endIndex: Number?): Number = definedExternally
    /**
     *   Returns an array of Alignment for this grid
     * 
     */
    override fun getFieldAlignments(): Array<dynamic> = definedExternally
    /**
     *   Attempt to find the record in the resultSet that has a primary key value that matches the
     *   passed in parameter value. Only the locally cached data will be searched.
     *   Checks only loaded rows and will not trigger a fetch. Returns null if there is no match,
     *   data is not loaded, or there is no ResultSet.dataSource.
     * 
     *   Note, if you pass a simple value to this method, it will be matched against the first
     *   primaryKey field. For DataSources with a composite primary key (multiple primaryKey fields),
     *   pass
     *   a criteria object containing just your primaryKeys, like this:
     *   { firstPkField: "value", secondPkField: 25 }.
     * 
     * 
     * 
     *  @param {object} primary key value to search for
     */
    override fun findByKey(keyValue: dynamic): Record = definedExternally
    /**
     *   Returns the number of selected records.
     * 
     * 
     */
    override fun getSelectionLength(): Number = definedExternally
    /**
     *   Return the set of hilite-objects currently applied to this DataBoundComponent. These
     *   can be serialized for storage and then restored to a component later via
     *   DataBoundComponent.setHilites.
     * 
     * 
     */
    override fun getHilites(): Array<dynamic> = definedExternally
    /**
     *   Accepts an array of hilite objects and applies them to this DataBoundComponent. See also
     *   DataBoundComponent.getHilites for a method of retrieving the hilite
     *   array for storage, including hilites manually added by the user.
     * 
     * 
     *  @param {Array<Partial<Hilite>>} Array of hilite objects
     */
    override fun setHilites(hilites: Array<dynamic>): Unit = definedExternally
    /**
     *   Get the current hilites encoded as a String, for saving.
     * 
     * 
     */
    override fun getHiliteState(): String = definedExternally
    /**
     *   Set the current hilites based on a hiliteState String previously returned from
     *   DataBoundComponent.getHiliteState.
     * 
     *  @param {string} hilites state encoded as a String
     */
    override fun setHiliteState(hiliteState: String): Unit = definedExternally
    /**
     *   Enable / disable a DataBoundComponent.hilites
     * 
     * 
     *  @param {string} ID of hilite to enable
     *  @param {boolean=} new enabled state to apply - if null, defaults to true
     */
    override fun enableHilite(hiliteID: String, enable: Boolean?): Unit = definedExternally
    /**
     *   Disable a hilite
     * 
     * 
     *  @param {string} ID of hilite to disable
     */
    override fun disableHilite(hiliteID: String): Unit = definedExternally
    /**
     *   Enable all hilites.
     * 
     * 
     *  @param {boolean=} new enabled state to apply - if null, defaults to true
     */
    override fun enableHiliting(enable: Boolean?): Unit = definedExternally
    /**
     *   Disable all hilites.
     * 
     * 
     */
    override fun disableHiliting(): Unit = definedExternally
    /**
     *   Shows a HiliteEditor interface allowing end-users to edit
     *   the data-hilites currently in use by this DataBoundComponent.
     * 
     * 
     */
    override fun editHilites(): Unit = definedExternally
    /**
     * 
     *   Transfer a list of Records from another component (does not have to be a databound
     *   component) into this component. This method is only applicable to list-type components,
     *   such as ListGrid, TreeGrid or TileGrid
     * 
     *   This method implements the automatic drag-copy and drag-move behaviors of components like
     *   ListGrid, and calling it is equivalent to completing a drag and drop of the
     *   dropRecords.
     * 
     *   Note that this method is asynchronous - it may need to perform server turnarounds to prevent
     *   duplicates in the target component's data. If you wish to be notified when the transfer
     *   process has completed, you can either pass the optional callback to this method or implement
     *   the DataBoundComponent.dropComplete method on this component.
     * 
     *   See also DataBoundComponent.transferSelectedData.
     * 
     * 
     *  @param {Array<Partial<Record>>} Records to transfer to this component
     *  @param {Record} The target record (eg, of a drop interaction), for context
     *  @param {Integer} Insert point in this component's data for the transferred records
     *  @param {Canvas} The databound or non-databound component from which the records              are to be transferred.
     *  @param {Callback=} optional callback to be fired when the transfer process has completed
     */
    override fun transferRecords(dropRecords: Array<dynamic>, targetRecord: Record, index: Number, sourceWidget: Canvas, callback: dynamic?): Unit = definedExternally
    /**
     *   Returns the "drop values" to apply to a record dropped on this component prior to update. Only
     *   applicable to databound components - see DataBoundComponent.dropValues for more details. If multiple records
     *   are being dropped, this method is called for each of them in turn.
     * 
     *   The default implementation of this method returns the following:
     * 
     * 
     *  - Nothing, if DataBoundComponent.addDropValues is false
     * 
     *  - dropValues, if that property is set. If the component's criteria object is applicable (as explained
     *   in the next item), it is merged into dropValues, with properties in dropValues taking precedence.
     * 
     *  - The component's criteria object, if the most recent textMatchStyle for the component was "exact"
     *     and it is simple criteria (ie, not an AdvancedCriteria object)
     * 
     *  - Otherwise nothing
     * 
     * 
     *   You can override this method if you need more complex setting of drop values than can be
     *   provided by simply supplying a dropValues object.
     * 
     * 
     *  @param {Record} record being dropped
     *  @param {DataSource} dataSource the record being dropped is bound to
     *  @param {Record} record being dropped on
     *  @param {Integer} index of record being dropped on
     *  @param {Canvas} widget where dragging began
     */
    override fun getDropValues(record: Record, sourceDS: DataSource, targetRecord: Record, index: Number, sourceWidget: Canvas): dynamic = definedExternally
    /**
     *   Convenience method to display a FormulaBuilder to create a new Formula Field. This
     *   is equivalent to calling DataBoundComponent.editFormulaField with
     *   no parameter.
     * 
     * 
     */
    override fun addFormulaField(): Unit = definedExternally
    /**
     *   Method to display a FormulaBuilder to edit a formula Field. If the function is called
     *   without a parameter, a new field will be created when the formula is saved.
     * 
     * 
     *  @param {string} Field to edit or null to add a new formula field
     */
    override fun editFormulaField(field: String): Unit = definedExternally
    /**
     *   Convenience method to display a SummaryBuilder to create a new Summary Field. This
     *   is equivalent to calling DataBoundComponent.editSummaryField with
     *   no parameter.
     * 
     * 
     */
    override fun addSummaryField(): Unit = definedExternally
    /**
     *   Method to display a SummaryBuilder to edit a Summary Field. If the function is called
     *   without a parameter, a new field will be created when the summary is saved.
     * 
     * 
     *  @param {string} Field to edit or null to add a new summary column
     */
    override fun editSummaryField(field: String): Unit = definedExternally
    /**
     *   Get the value of the titleField for the passed record
     * 
     *   Override in subclasses
     * 
     * 
     *  @param {Record} the record whose index is to be retrieved
     */
    override fun getTitleFieldValue(record: Record): String = definedExternally
    /**
     *   Return all CSS style declarations associated with the hilites of a record's field.
     * 
     *  @param {Record} \* @param {string} if set, returned CSS will be appended to this text
     *  @param {string} field object identifying whose CSS is to be returned
     */
    override fun getRecordHiliteCSSText(record: Record, cssText: String, field: String): String = definedExternally
    /**
     *   Returns true if the component's current data model is marked as offline. This does not
     *   necessarily mean that the component has no data; it may have data that was supplied from
     *   the Offline.
     * 
     */
    override fun isOffline(): Boolean = definedExternally
    /**
     *   Shows a FieldPicker interface allowing end-users to edit
     *   the fields currently shown by this DataBoundComponent.
     * 
     * 
     */
    override fun editFields(): Unit = definedExternally
    /**
     *   Notification method fired when a user-generated field is added to this component via
     *   DataBoundComponent.editFormulaField or DataBoundComponent.editSummaryField.
     * 
     *   Returning false from this method will prevent the field being added at all. Note that
     *   this also provides an opportunity to modify the generated field object - any changes
     *   made to the field parameter will show up when the field is displayed in the ListGrid.
     * 
     * 
     *  @param {ListGridField} User generated summary or formula field
     */
    override fun userAddedField(field: ListGridField): Boolean = definedExternally
    companion object {
        /**
         *  A declared value of the enum type s
         *   RecordDropPosition and
         *   ReorderPosition.
         *  @type {Constant}
         *  @default "before"
         */
        var BEFORE: String = definedExternally
        /**
         *  A declared value of the enum type s
         *   RecordDropPosition and
         *   ReorderPosition.
         *  @type {Constant}
         *  @default "after"
         */
        var AFTER: String = definedExternally
        /**
         *  A declared value of the enum type s
         *   RecordDropPosition,
         *   ReorderPosition and
         *   RecordDropAppearance.
         *  @type {Constant}
         *  @default "over"
         */
        var OVER: String = definedExternally
        /**
         *  A declared value of the enum type
         *   RecordDropAppearance.
         *  @type {Constant}
         *  @default "between"
         */
        var BETWEEN: String = definedExternally
        /**
         *  A declared value of the enum type
         *   RecordDropAppearance.
         *  @type {Constant}
         *  @default "both"
         */
        var BOTH: String = definedExternally
        /**
         *  A declared value of the enum type
         *   RecordDropAppearance.
         *  @type {Constant}
         *  @default "body"
         */
        var BODY: String = definedExternally
        /**
         *  A declared value of the enum type
         *   RecordDropPosition.
         *  @type {Constant}
         *  @default "none"
         */
        var NONE: String = definedExternally
        /**
         *  A declared value of the enum type
         *   EditCompletionEvent.
         *  @type {Constant}
         *  @default "click_outside"
         */
        var CLICK_OUTSIDE: String = definedExternally
        /**
         *  A declared value of the enum type
         *   EditCompletionEvent.
         *  @type {Constant}
         *  @default "click"
         */
        var CLICK: String = definedExternally
        /**
         *  A declared value of the enum type
         *   EditCompletionEvent.
         *  @type {Constant}
         *  @default "doubleClick"
         */
        var DOUBLE_CLICK: String = definedExternally
        /**
         *  A declared value of the enum type
         *   EditCompletionEvent.
         *  @type {Constant}
         *  @default "enter"
         */
        var ENTER_KEYPRESS: String = definedExternally
        /**
         *  A declared value of the enum type
         *   EditCompletionEvent.
         *  @type {Constant}
         *  @default "escape"
         */
        var ESCAPE_KEYPRESS: String = definedExternally
        /**
         *  A declared value of the enum type
         *   EditCompletionEvent.
         *  @type {Constant}
         *  @default "arrow_up"
         */
        var UP_ARROW_KEYPRESS: String = definedExternally
        /**
         *  A declared value of the enum type
         *   EditCompletionEvent.
         *  @type {Constant}
         *  @default "arrow_down"
         */
        var DOWN_ARROW_KEYPRESS: String = definedExternally
        /**
         *  A declared value of the enum type
         *   EditCompletionEvent.
         *  @type {Constant}
         *  @default "tab"
         */
        var TAB_KEYPRESS: String = definedExternally
        /**
         *  A declared value of the enum type
         *   EditCompletionEvent.
         *  @type {Constant}
         *  @default "shift_tab"
         */
        var SHIFT_TAB_KEYPRESS: String = definedExternally
        /**
         *  A declared value of the enum type
         *   EditCompletionEvent.
         *  @type {Constant}
         *  @default "field_change"
         */
        var EDIT_FIELD_CHANGE: String = definedExternally
        /**
         *  A declared value of the enum type
         *   EditCompletionEvent.
         *  @type {Constant}
         *  @default "programmatic"
         */
        var PROGRAMMATIC: String = definedExternally
        /**
         *  Creates a new ListGrid
         * 
         *  @param typeCheckedProperties {Partial<ListGrid>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ListGrid} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ListGrid = definedExternally
        /**
         *   Returns whether there are any pending DSRequests initiated by this
         *   DataBoundComponent. May not include any requests sent by directly calling the
         *   DataSource APIs (rather than the DataBoundComponent APIs).
         * 
         * 
         */
        fun requestsArePending(): Boolean = definedExternally
    }
}