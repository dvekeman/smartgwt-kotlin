@file:JsQualifier("isc")
package isc

/**
 *  A flexible, high-speed table that offers consistent cross-platform sizing, clipping, and events.
 */
open external class GridRenderer : Canvas {
    /**
     *  Total number of rows in the grid.
     * 
     *   NOTE: in order to create a valid grid, you must either provide a totalRows value or implement
     *   getTotalRows()
     *  @type {number}
     *  @default "0"
     */
    open var totalRows: Number = definedExternally
    /**
     *  Whether all rows should be drawn all at once, or only rows visible in the viewport.
     * 
     *   Drawing all rows causes longer initial rendering time, but allows smoother vertical scrolling.
     *   With a very large number of rows, showAllRows will become too slow.
     * 
     *   See also GridRenderer.drawAheadRatio and GridRenderer.drawAllMaxCells.
     *  @type {boolean}
     *  @default false
     */
    open var showAllRows: Boolean = definedExternally
    /**
     *  When incremental rendering is switched on and there are variable record heights, the virtual
     *   scrolling mechanism manages the differences in scroll height calculations due to the
     *   unknown sizes of unrendered rows to make the scrollbar and viewport appear correctly.
     * 
     *   virtualScrolling is switched on automatically when fixedRowHeights is false but you should
     *   switch it on any time there are variable record heights.
     *  @type {boolean}
     *  @default null
     */
    open var virtualScrolling: Boolean = definedExternally
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
     *   is false and the viewport size and GridRenderer.drawAheadRatio setting would normally have caused
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
     *  If true, if the user clicks on the scroll buttons at the end of the track or clicks once on
     *   the scroll track, there will be an instant redraw of the grid content so that the user
     *   doesn't see any blank space. For drag scrolling or other types of scrolling, the
     *   GridRenderer.scrollRedrawDelay applies.
     *  @type {boolean}
     *  @default true
     */
    open var instantScrollTrackRedraw: Boolean = definedExternally
    /**
     *  While drag scrolling in an incrementally rendered grid, time in milliseconds to wait
     *   before redrawing, after the last mouse movement by the user. This delay may be
     *   separately customized for mouse-wheel scrolling via GridRenderer.scrollWheelRedrawDelay.
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
     *  Like GridRenderer.scrollRedrawDelay, but applies when the component is being
     *   drag-scrolled (via a scrollbar). This value is typically set higher than GridRenderer.scrollRedrawDelay
     *   to avoid too many concurrent fetches to the server for ResultSet-backed components
     *   since it's quite easy to induce such a case with a scrollbar and a grid bound to a large databaset.
     *  @type {Integer}
     *  @default "75"
     */
    open var dragScrollRedrawDelay: Number = definedExternally
    /**
     *  In Browser.isTouch, the time in milliseconds to wait after a scroll
     *   before redrawing. In non-touch browsers, the GridRenderer.scrollRedrawDelay
     *   or GridRenderer.scrollWheelRedrawDelay is used instead.
     *  @type {Integer}
     *  @default "0"
     */
    open var touchScrollRedrawDelay: Number = definedExternally
    /**
     *  While scrolling an incrementally rendered grid, using the mouseWheel, time in
     *   milliseconds to wait before redrawing, after the last mouseWheel movement by the user.
     *   If not specified GridRenderer.scrollRedrawDelay will be used as a default for both
     *   drag scrolling and mouseWheel scrolling.
     * 
     *   See also
     *   GridRenderer.instantScrollTrackRedraw for cases where this delay is skipped.
     *  @type {Integer}
     *  @default null
     */
    open var scrollWheelRedrawDelay: Number = definedExternally
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
     *  Alternative to GridRenderer.drawAheadRatio, to be used when the user
     *   is rapidly changing the grids viewport (for example drag scrolling through the grid).
     *   If unspecified GridRenderer.drawAheadRatio will be used in all cases
     *  @type {Float}
     *  @default "2.0"
     */
    open var quickDrawAheadRatio: Number = definedExternally
    /**
     *  The default height of each row in pixels.
     *  @type {number}
     *  @default "20"
     */
    open var cellHeight: Number = definedExternally
    /**
     *  Should we vertically clip cell contents, or allow rows to expand vertically to show all
     *   contents?
     * 
     *   If we allow rows to expand, the row height as derived from
     *   GridRenderer.getRowHeight or the
     *   default GridRenderer.cellHeight is treated as a minimum.
     *  @type {boolean}
     *  @default true
     */
    open var fixedRowHeights: Boolean = definedExternally
    /**
     *  Should we horizontally clip cell contents, or allow columns to expand horizontally to
     *   show all contents?
     * 
     *   If we allow columns to expand, the column width is treated as a minimum.
     *  @type {boolean}
     *  @default true
     */
    open var fixedColumnWidths: Boolean = definedExternally
    /**
     *  If true, make columns only wide enough to fit content, ignoring any widths specified.
     *   Overrides fixedFieldWidths.
     *  @type {boolean}
     *  @default false
     */
    open var autoFit: Boolean = definedExternally
    /**
     *  Should content within cells be allowed to wrap?
     *  @type {boolean}
     *  @default false
     */
    open var wrapCells: Boolean = definedExternally
    /**
     *  The amount of empty space, in pixels, surrounding each value in its cell.
     *  @type {number}
     *  @default "2"
     */
    open var cellPadding: Number = definedExternally
    /**
     *  If true, rightMouseDown events will fire 'selectOnRightMouseDown()' for the appropriate cells.
     *  @type {boolean}
     *  @default true
     */
    open var canSelectOnRightMouse: Boolean = definedExternally
    /**
     *  If true, cellHover and rowHover events will fire and then a hover will be shown (if not
     *   canceled) when the user leaves the mouse over a row / cell unless the corresponding field has
     *   ListGridField.showHover set to false. If unset or null, the hover will be
     *   shown if the corresponding field has showHover:true. If false, then hovers are disabled.
     * 
     *   Note that standard hovers override GridRenderer.showClippedValuesOnHover. Thus,
     *   to enable clipped value hovers, canHover must be unset or null and the corresponding field
     *   must have showHover unset or null as well.
     *  @type {boolean}
     *  @default null
     */
    override var canHover: Boolean = definedExternally
    /**
     *  If true, and canHover is also true, when the user hovers over a cell, hover text will pop up
     *   next to the mouse. The contents of the hover is determined by GridRenderer.cellHoverHTML.
     *  @type {boolean}
     *  @default null
     */
    override var showHover: Boolean = definedExternally
    /**
     *  If true and a cell's value is clipped, then a hover containing the full cell value is
     *   enabled.
     * 
     *   Note that standard cell hovers override clipped value hovers. Thus, to enable clipped value
     *   hovers, GridRenderer.canHover must be unset or null and the corresponding field must have
     *   ListGridField.showHover unset or null as well.
     *  @type {boolean}
     *  @default null
     */
    open var showClippedValuesOnHover: Boolean = definedExternally
    /**
     *  The base name for the CSS class applied to cells. This style will have "Dark",
     *   "Over", "Selected", or "Disabled" appended to it according to the state of the cell.
     *  @type {CSSStyleName}
     *  @default "cell"
     */
    open var baseStyle: String = definedExternally
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
    open var alternateRowStyles: Boolean = definedExternally
    /**
     *  Suffix to append to GridRenderer.alternateRowStyles.
     *   Note that if GridRenderer.alternateColumnStyles is enabled, cells which fall
     *   into both an alternate row and column will have both suffixes appended - for
     *   example "cellDarkAltCol".
     *  @type {string}
     *  @default "Dark"
     */
    open var alternateRowSuffix: String = definedExternally
    /**
     *  The number of consecutive rows to draw in the same style before alternating, when
     *   GridRenderer.alternateRowStyles is true.
     *  @type {number}
     *  @default "1"
     */
    open var alternateRowFrequency: Number = definedExternally
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
    open var alternateColumnStyles: Boolean = definedExternally
    /**
     *  Suffix to append to GridRenderer.alternateColumnStyles.
     *   Note that if GridRenderer.alternateRowStyles is enabled, cells which fall
     *   into both an alternate row and column will have both suffixes appended - for
     *   example "cellDarkAltCol".
     *  @type {string}
     *  @default "AltCol"
     */
    open var alternateColumnSuffix: String = definedExternally
    /**
     *  The number of consecutive columns to draw in the same style before alternating, when
     *   GridRenderer.alternateColumnStyles is true.
     *  @type {number}
     *  @default "1"
     */
    open var alternateColumnFrequency: Number = definedExternally
    /**
     *  Value to show in empty cells (when getCellValue returns null).
     *  @type {string}
     *  @default "&amp;nbsp;"
     */
    open var emptyCellValue: String = definedExternally
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
     *  @type {string}
     *  @default "No data to display"
     */
    open var emptyMessage: String = definedExternally
    /**
     *  CSS styleName for the table as a whole if we're showing the empty message
     *  @type {CSSStyleName}
     *  @default null
     */
    open var emptyMessageTableStyle: String = definedExternally
    /**
     *  The CSS style name applied to the emptyMessage string if displayed.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var emptyMessageStyle: String = definedExternally
    /**
     *  Indicates whether the text of the offlineMessage property should be displayed if no data
     *   is available because we are offline and there is no suitable cached response
     *  @type {boolean}
     *  @default true
     */
    open var showOfflineMessage: Boolean = definedExternally
    /**
     *  The CSS style name applied to the offlineMessage string if displayed.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var offlineMessageStyle: String = definedExternally
    /**
     *  The string to display in the body of a listGrid with an empty data array, if
     *   showOfflineMessage is true and the data array is empty because we are offline and there
     *   is no suitable cached response
     *  @type {string}
     *  @default "No data available while offline"
     */
    open var offlineMessage: String = definedExternally
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
     *  Should drag-and-drop operations snap the dragged object into line with the nearest cell?
     *  @type {boolean}
     *  @default false
     */
    open var snapToCells: Boolean = definedExternally
    /**
     *  If true, snap-to-cell drops will snap the dropped object inside the selected cell's border.
     *   If false, snap-to-cell drops will snap the dropped object to the edge of the selected cell,
     *   regardless of borders
     *  @type {boolean}
     *  @default false
     */
    open var snapInsideBorder: Boolean = definedExternally
    /**
     *  Denotes the name of a property that can be set on records to display a custom style.
     *   For example if this property is set to "customStyle", setting
     *   record.customStyle to a css styleName will cause the record in question to
     *   render out with that styling applied to it. Note that this will be a static
     *   style - it will not be modified as the state of the record (selected / over etc) changes.
     *  @type {"CustomStyle"}
     *  @default "string"
     */
    open var recordCustomStyleProperty: String /* CustomStyle */ = definedExternally
    /**
     *  Should the "Selected" style be applied to selected records?
     *  @type {boolean}
     *  @default true
     */
    open var showSelectedStyle: Boolean = definedExternally
    /**
     *   Given a pointer to an element in the DOM, this method will check whether this
     *   element is contained within a cell of the gridRenderer, and if so return a
     *   2 element array denoting the [rowNum,colNum] of the element
     *   in question.
     * 
     *  @param {DOMElement} DOM element to test
     */
    open fun getCellFromDomElement(element: DOMElement): Array<dynamic> = definedExternally
    /**
     *   Setter for GridRenderer.fastCellUpdates. Has no effect in browsers other than
     *   Internet Explorer.
     * 
     *  @param {boolean} whether to enable fastCellUpdates.
     */
    open fun setFastCellUpdates(fastCellUpdates: Boolean): Unit = definedExternally
    /**
     *   Is the value in a given cell clipped?
     * 
     *  @param {number} row number of the cell
     *  @param {number} column number of the cell
     */
    open fun cellValueIsClipped(rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Return the total number of rows in the grid.
     * 
     *   NOTE: in order to create a valid grid, you must either provide a totalRows value or implement
     *   getTotalRows()
     * 
     * 
     */
    open fun getTotalRows(): Number = definedExternally
    /**
     *   Sets the width of a single column.
     * 
     * 
     *  @param {number} the number of the column to resize
     *  @param {number} the new width
     */
    open fun setColumnWidth(colNum: Number, newWidth: Number): Unit = definedExternally
    /**
     * 
     *   Sets the width of all columns in the grid.
     * 
     * 
     *  @param {Array<any>} array of new widths - one for each column.
     */
    open fun setColumnWidths(newWidths: Array<dynamic>): Unit = definedExternally
    /**
     *   When using GridRenderer.getRowSpan, returns the row number where a row-spanning cell
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
     *   When using GridRenderer.getRowSpan, returns the number of cells spanned by the cell
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
     *   set up custom row-spanning behavior, override GridRenderer.getRowSpan instead.
     * 
     * 
     *  @param {Integer} row number of cell to return the row span for
     *  @param {Integer} column number of cell to return the row span for
     */
    open fun getCellRowSpan(rowNum: Number, colNum: Number): Number = definedExternally
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
     *   Whether this cell should be considered enabled. Affects whether events will fire for the
     *   cell, and the default styling behavior in getCellStyle.
     * 
     * 
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun cellIsEnabled(rowNum: Number, colNum: Number): Boolean = definedExternally
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
     *   Returns the page offsets and size of the cell at the passed row and column. If auto-sizing
     *   is enabled, sizes are not definitive until the grid has finished drawing, so calling this
     *   method before drawing completes will return the configured column sizes.
     * 
     *  @param {number} row index of the cell
     *  @param {number} column index of the cell
     */
    open fun getCellPageRect(rowNum: Number, colNum: Number): Array<dynamic> = definedExternally
    /**
     *   Return the left coordinate (in local coordinate space) of a particular column.
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
     *  @param {number} number of the column.
     */
    open fun getColumnWidth(colNum: Number): Number = definedExternally
    /**
     *   Returns the top coordinate for a given row number, relative to the top of body content. Use
     *   GridRenderer.getRowPageTop for a page-relative coordinate.
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
     *   GridRenderer.getRowTop.
     * 
     * 
     * \* @param {Integer} 
     */
    open fun getRowPageTop(rowNum: Number): Number = definedExternally
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
     *     Returns the nearest row to the event coordinates
     * 
     */
    open fun getNearestRowToEvent(): Unit = definedExternally
    /**
     *     Returns the nearest column to the event coordinates
     * 
     */
    open fun getNearestColToEvent(): Unit = definedExternally
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
     *   The drawn rows differ from the GridRenderer.getVisibleRows because of
     *   GridRenderer.drawAheadRatio. The drawn rows are the appropriate range to consider if
     *   you need to, eg, using GridRenderer.refreshCell to update all the cells in a column.
     * 
     *   If the grid is undrawn or the GridRenderer.emptyMessage is currently shown, returns
     *   [null,null];
     * 
     * 
     */
    open fun getDrawnRows(): Array<dynamic> = definedExternally
    /**
     *   Return the record that holds the value for this cell.
     * 
     *   Implementing getCellRecord is optional: the actual HTML placed into each
     *   grid cell comes from getCellValue, and a valid grid can be created without any
     *   notion of "records" at all.
     * 
     *   If you do implement getCellRecord, the value you return is passed to you as the
     *   "record" parameter in other methods.
     * 
     * 
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun getCellRecord(rowNum: Number, colNum: Number): dynamic = definedExternally
    /**
     *   Return the HTML to display in this cell. Implementing this is required to get a non-empty
     *   grid.
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun getCellValue(record: ListGridRecord, rowNum: Number, colNum: Number): String = definedExternally
    /**
     *   Given a record displayed in this grid, find and return the rowNum in which the record
     *   appears.
     * 
     *   As with GridRenderer.getCellRecord implementing this method is optional as a valid
     *   grid may be created without any notion of records.
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord
     */
    open fun findRowNum(record: ListGridRecord): Number = definedExternally
    /**
     *   Given a record displayed in this grid, find and return the colNum in which the record
     *   appears.
     * 
     *   As with GridRenderer.getCellRecord implementing this method is optional as a valid
     *   grid may be created without any notion of records, or records may not be displayed in a
     *   single column (as with the ListGrid class where each record is
     *   displayed in an entire row.
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord
     */
    open fun findColNum(record: ListGridRecord): Number = definedExternally
    /**
     *   Return the base stylename for this cell. Default implementation just returns this.baseStyle.
     *   See ListGrid.getCellStyle for a general discussion of how to style cells.
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord
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
     *   Return the height this row should be. Default is this.cellHeight. If
     *   GridRenderer.fixedRowHeights is false, the row may be rendered taller than this
     *   specified size.
     * 
     *   If records will be variable height,
     *   you should switch on GridRenderer.virtualScrolling.
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord
     *  @param {number} row number
     */
    open fun getRowHeight(record: ListGridRecord, rowNum: Number): Number = definedExternally
    /**
     *   Return how many rows this cell should span. Default is 1.
     * 
     *   NOTE: if using horizontal incremental rendering, getRowSpan() may be called for
     *   a rowNum in the middle of a spanning cell, and should return the remaining span from
     *   that rowNum onward.
     * 
     *   NOTE: if a cell spans multiple rows, getCellRecord/Style/etc will be called with the topmost
     *   row coordinates only.
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun getRowSpan(record: ListGridRecord, rowNum: Number, colNum: Number): Number = definedExternally
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
     *   Called when the mouse pointer enters a cell
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun cellOver(record: ListGridRecord, rowNum: Number, colNum: Number): Boolean = definedExternally
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
     *   Called when the mouse pointer enters a row
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun rowOver(record: ListGridRecord, rowNum: Number, colNum: Number): Boolean = definedExternally
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
     *   Called when a row receives a click event.
     * 
     * 
     *  @param {ListGridRecord} Record object returned from getCellRecord()
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun rowClick(record: ListGridRecord, rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Called when a row receives a double click event.
     * 
     * 
     *  @param {ListGridRecord} Record object returned from getCellRecord()
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun rowDoubleClick(record: ListGridRecord, rowNum: Number, colNum: Number): Boolean = definedExternally
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
     *   StringMethod to dynamically create a Canvas-based component to show as a hover window
     *   over the appropriate cell/record when this.canHover and this.showHover are both true and
     *   when an override of getCellHoverComponent() is present.
     *   Called when the mouse hovers over a cell.
     * 
     * 
     *  @param {ListGridRecord} cell record as returned by getCellRecord
     *  @param {number} row number for the cell
     *  @param {number} column number of the cell
     */
    open fun getCellHoverComponent(record: ListGridRecord, rowNum: Number, colNum: Number): Canvas = definedExternally
    /**
     *   Called when (row-based) selection changes within this grid. Note this method fires for
     *   each record for which selection is modified - so when a user clicks inside a grid this
     *   method will typically fire twice (once for the old record being deselected, and once for
     *   the new record being selected).
     * 
     *   NOTE: For updating other components based on selections or triggering selection-oriented
     *   events within an application, see the
     *   DataBoundComponent.selectionUpdated event
     *   which is likely more suitable. Calls to Selection.getSelection
     *   from within this event may not return a valid set of selected records if the event has
     *   been triggered by a call to Selection.selectAll or
     *   Selection.deselectAll - in this case use the
     *   DataBoundComponent.selectionUpdated event instead.
     * 
     * 
     *  @param {ListGridRecord} record for which selection changed
     *  @param {boolean} New selection state (true for selected, false for unselected)
     */
    open fun selectionChanged(record: ListGridRecord, state: Boolean): Unit = definedExternally
    /**
     *   Called when (cell-based) selection changes within this grid.
     * 
     * 
     *  @param {Array<any>} Array of cells whos selected state was modified.
     */
    open fun cellSelectionChanged(cellList: Array<dynamic>): Boolean = definedExternally
    companion object {
        /**
         *  Creates a new GridRenderer
         * 
         *  @param typeCheckedProperties {Partial<GridRenderer>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {GridRenderer} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): GridRenderer = definedExternally
    }
}