@file:JsQualifier("isc")
package isc

/**
 *  A ListGridRecord is a JavaScript Object whose properties contain values for each
 *   ListGridField. A ListGridRecord may have additional properties which affect the
 *   record's appearance or behavior, or which hold data for use by custom logic or other,
 *   related components.
 * 
 *   For example a ListGrid that defines the following fields:
 * 
 *   fields : [
 *     {name: "field1"},
 *     {name: "field2"}
 *   ],
 * 
 *   Might have the following data:
 * 
 *   data : [
 *     {field1: "foo", field2: "bar", customProperty:5},
 *     {field1: "field1 value", field2: "field2 value", enabled:false}
 *   ]
 * 
 *   Each line of code in the data array above creates one JavaScript Object via
 *   JavaScript {type:ObjectLiteral,object literal} notation. These JavaScript Objects are
 *   used as ListGridRecords.
 * 
 *   Both records shown above have properties whose names match the name property of a
 *   ListGridField, as well as additional properties. The second record will be disabled due to
 *   enabled:false; the first record has a property "customProperty" which will
 *   have no effect by default but which may be accessed by custom logic.
 * 
 *   After a ListGrid is created and has loaded data, records may be accessed via
 *   ListGrid.data, for example, listGrid.data.get(0) retrieves the first record.
 *   ListGridRecords are also passed to many events, such as
 *   ListGrid.cellClick.
 * 
 *   A ListGridRecord is always an ordinary JavaScript Object regardless of how the grid's
 *   dataset is loaded (static data, java server, XML web service, etc), and so supports the
 *   normal behaviors of JavaScript Objects, including accessing and assigning to properties
 *   via dot notation:
 * 
 *     var fieldValue = record.fieldName;
 *     record.fieldName = newValue;
 * 
 * 
 *   Note however that simply assigning a value to a record won't cause the display to be
 *   automatically refreshed - ListGrid.refreshCell needs to be called. Also,
 *   consider editing when directly modifying
 *   ListGridRecords.
 * 
 *   See the attributes in the API tab for the full list of special properties on
 *   ListGridRecords that will affect the grid's behavior.
 */
open external class ListGridRecord : Record {
    /**
     *  Default property name denoting whether this record is enabled. Property name may be
     *   modified for some grid via ListGrid.recordEnabledProperty.
     *  @type {boolean}
     *  @default null
     */
    open var enabled: Boolean = definedExternally
    /**
     *  Default property name denoting whether this record can be expanded. Property name may be
     *   modified for the grid via ListGrid.canExpandRecordProperty.
     *  @type {boolean}
     *  @default null
     */
    open var canExpand: Boolean = definedExternally
    /**
     *  Default property name denoting whether this record can be removed. Property name may be
     *   modified for the grid via ListGrid.recordCanRemoveProperty.
     *  @type {boolean}
     *  @default null
     */
    open var _canRemove: Boolean = definedExternally
    /**
     *  Default property name denoting a separator row.
     *   When set to true, defines a horizontal separator in the listGrid
     *   object. Typically this is specified as the only property of a record object, since a
     *   record with isSeparator:true will not display any values.
     *   Note: this attribute name is governed by ListGrid.isSeparatorProperty.
     *  @type {boolean}
     *  @default null
     */
    open var isSeparator: Boolean = definedExternally
    /**
     *  Name of a CSS style to use for all cells for this particular record.
     * 
     *   Note that using this property assigns a single, fixed style to the record, so rollover
     *   and selection styling are disabled. To provide a series of stateful styles for a record
     *   use ListGridRecord._baseStyle instead.
     * 
     *   See ListGrid.getCellStyle for an overview of various ways to customize styling,
     *   both declarative and programmatic.
     * 
     *   If this property is changed after draw(), to refresh the grid call
     *   ListGrid.refreshRow (or ListGrid.markForRedraw if several rows are
     *   being refreshed).
     * 
     *   If your application's data uses the "customStyle" attribute for something else, the
     *   property name can be changed via ListGrid.recordCustomStyleProperty.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var customStyle: String = definedExternally
    /**
     *  Name of a CSS style to use as the ListGrid.baseStyle for all cells for this
     *   particular record.
     * 
     *   The styleName specified with have suffixes appended to it as the record changes state
     *   ("Over", "Selected" and so forth) as described by ListGrid.getCellStyle. For a
     *   single, fixed style for a record, use ListGridRecord.customStyle instead.
     * 
     *   See ListGrid.getCellStyle for an overview of various ways to customize styling,
     *   both declarative and programmatic.
     * 
     *   If this property is changed after draw(), to refresh the grid call
     *   ListGrid.refreshRow (or ListGrid.markForRedraw if several rows are
     *   being refreshed).
     * 
     *   If your application's data uses the "_baseStyle" attribute for something else, the
     *   property name can be changed via ListGrid.recordBaseStyleProperty.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var _baseStyle: String = definedExternally
    /**
     *  Default property name denoting the single value to display for all fields of this row.
     *   If this property is set for some record, the record will be displayed as a single
     *   cell spanning every column in the grid, with contents set to the value of this
     *   property.
     *   Note: this attribute name is governed by ListGrid.singleCellValueProperty.
     *  @type {HTMLString}
     *  @default null
     */
    open var singleCellValue: String = definedExternally
    /**
     *  When set to false, this record cannot be dragged. If canDrag is false for
     *   any record in the current selection, none of the records will be draggable.
     *  @type {boolean}
     *  @default null
     */
    open var canDrag: Boolean = definedExternally
    /**
     *  When set to false, other records cannot be dropped on (i.e., inserted
     *   via drag and drop) immediately before this record.
     *  @type {boolean}
     *  @default null
     */
    open var canAcceptDrop: Boolean = definedExternally
    /**
     *  The HTML to display in this row for fields with fieldType set to link. This overrides
     *   ListGridField.linkText.
     *  @type {string}
     *  @default null
     */
    open var linkText: String = definedExternally
    /**
     *  Set to false to disable rollover for this individual record when ListGrid.showRollOver
     *   is true.
     * 
     *   Note this property can be renamed to prevent collision with data members - see
     *   attr:ListGrid.recordShowRollOverProperty.
     *  @type {boolean}
     *  @default null
     */
    open var showRollOver: Boolean = definedExternally
    /**
     *  A component that should be rendered on top of this record, similar to a
     *   ListGrid.showRecordComponents but statically defined on the record.
     * 
     *   The embedded component will default to covering all fields of the record, but specific fields
     *   can be specified via ListGridRecord.embeddedComponentFields.
     * 
     *   By default, the embeddedComponent will fill the entire vertical and horizontal space of the
     *   record (or of the specified fields). ListGridRecord.embeddedComponentPosition can be set to control
     *   exact sizing behavior.
     * 
     * 
     *   When creating a component to use as an embedded component the component will most likely
     *   end up drawing before the record it is due to be embedded within, therefore it is recommended
     *   to set Canvas.autoDraw to false on the embedded component.
     * 
     * 
     *   When a record with an embeddedComponent is eliminated from view by filtering or
     *   because it is not currently rendered due to ListGrid.showAllRecords, the
     *   ListGrid may Canvas.hide or Canvas.clear it.
     * 
     *   If the current dataset is completely replaced (by a call to ListGrid.setData or
     *   ListGrid.setDataSource, for example), any embedded component is
     *   Canvas.deparent (which implies being Canvas.clear).
     * 
     *   When a ListGrid is Canvas.destroy, it will destroy() all embedded components
     *   regardless of whether they are currently visible. Use a call to ListGrid.setData immediately
     *   before destroying the ListGrid to avoid this effect when unwanted.
     * 
     *   For more advanced control over the lifecycle of components displayed over records, including
     *   deferred creation and pooling, use the ListGrid.showRecordComponents
     *   subsystem.
     *  @type {Canvas}
     *  @default null
     */
    open var embeddedComponent: Canvas = definedExternally
    /**
     *  Sizing policy applied to the embedded component. Default behavior if unspecified is the same
     *   as EmbeddedPosition "within" (fill space allocated to the record, including the ability
     *   use percentage sizing and snapTo offset). Use "expand" to have the record expand to accomodate
     *   the embedded components' specified sizes instead.
     *  @type {EmbeddedPosition}
     *  @default null
     */
    open var embeddedComponentPosition: 
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
     *  Fields where the ListGridRecord.embeddedComponent will be displayed, if specified.
     * 
     *   Regardless of the order of fields specified, the component will appear from whichever field is
     *   earlier in the current visible order to whichever field is later, inclusive of the specified
     *   fields.
     * 
     *   To have the component appear in just one field, either specify a single-element Array or
     *   specific a two element Array with both fields the same.
     * 
     *   If either field is hidden or invalid (no such field), the component will occupy only a single
     *   field. If both fields are hidden, the component will be hidden until one or more of the fields
     *   are shown.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var embeddedComponentFields: Array<dynamic> = definedExternally
    /**
     *  Default property name denoting whether this record can be selected. Property name may be
     *   modified for the grid via ListGrid.recordCanSelectProperty.
     *  @type {boolean}
     *  @default null
     */
    open var canSelect: Boolean = definedExternally
    /**
     *  Default property name denoting whether this record can be edited. Property name may be
     *   modified for the grid via ListGrid.recordEditProperty.
     *  @type {boolean}
     *  @default null
     */
    open var _canEdit: Boolean = definedExternally
    /**
     *  Has no effect unless ListGrid.showBackgroundComponents is true.
     * 
     *   Canvas created and embedded in the body behind a given record.  When set, either as
     *   a Canvas or Canvas Properties, will be constructed if necessary, combined with the
     *   autoChild properties specified for ListGrid.backgroundComponent and displayed
     *   behind this record in the page's z-order, meaning
     *   it will only be visible if the cell styling is transparent.
     *  @type {Canvas}
     *  @default null
     */
    open var backgroundComponent: Canvas = definedExternally
    /**
     *  The default value of ListGrid.recordDetailDSProperty.
     *  @type {DataSource}
     *  @default null
     */
    open var detailDS: DataSource = definedExternally
    /**
     *  If specified as false this record should be ignored when calculating summary totals
     *   to be shown in the ListGrid.showGridSummary for this grid.
     * 
     *   Note that includeInSummary is the default property name for this attribute,
     *   but it may be modified via ListGrid.includeInSummaryProperty.
     *  @type {boolean}
     *  @default null
     */
    open var includeInSummary: Boolean = definedExternally
    /**
     *  This attribute will automatically be set to true for the record representing the
     *   grid-level summary row shown if ListGrid.showGridSummary is true.
     * 
     *   Note that isGridSummary is the default property name for this attribute but
     *   it may be modified by setting ListGrid.gridSummaryRecordProperty
     *  @type {boolean}
     *  @default null
     */
    open var isGridSummary: Boolean = definedExternally
    /**
     *  This attribute will automatically be set to true for records representing
     *   group-level summary rows shown if ListGrid.showGroupSummary is true.
     * 
     *   Note that isGroupSummary is the default property name for this attribute but
     *   it may be modified by setting ListGrid.groupSummaryRecordProperty
     *  @type {boolean}
     *  @default null
     */
    open var isGroupSummary: Boolean = definedExternally
}