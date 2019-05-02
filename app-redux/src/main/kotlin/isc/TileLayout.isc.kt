@file:JsQualifier("isc")
package isc

/**
 *  Lays out a series of components, calls "tiles", in a grid with multiple tiles per row.
 */
open external class TileLayout : Canvas {
    /**
     *  List of tiles to lay out.
     *  @type {Array<Partial<Canvas>>}
     *  @default null
     */
    open var tiles: Array<dynamic> = definedExternally
    /**
     *  Policy for laying out tiles. See TileLayoutPolicy for options.
     *  @type {TileLayoutPolicy}
     *  @default "fit"
     */
    open var layoutPolicy: 
                           /**
                            *  Each line has the same number of tiles, based on TileLayout.tilesPerLine if set, otherwise,
                            *   based on fitting as many tiles per line as possible consistent with
                            *   TileLayout.tileSize and TileLayout.tileMargin.
                            * 
                            *   Tiles that do not specify a size will be sized to fill available space.
                            *  Tiles are laid out with varying numbers of tiles per line according to each tile's size,
                            *   the TileLayout.tileMargin, and the available space.
                            * 
                            *   Tiles are never resized by the TileLayout and TileLayout.tileSize is ignored.
                            */
                           String /* fit |  flow */ = definedExternally
    /**
     *  Size of each tile in pixels. Depending on the LayoutPolicy, tileSize
     *   may be taken as a maximum, minimum or exact size of tiles, or may be irrelevant.
     * 
     *   Width and height may be separately set via TileLayout.tileHeight and TileLayout.tileWidth.
     *  @type {Integer}
     *  @default "50"
     */
    open var tileSize: Number = definedExternally
    /**
     *  Width of each tile in pixels. See TileLayout.tileSize.
     *   If LayoutPolicy is "fit", TileLayout.expandMargins is false, TileLayout.tilesPerLine is set,
     *   Orientation is "horizontal",
     *   and tileWidth is not set, tileWidth will be computed automatically based on TileLayout.tilesPerLine.
     *  @type {Integer}
     *  @default null
     */
    open var tileWidth: Number = definedExternally
    /**
     *  Height of each tile in pixels. See TileLayout.tileSize.
     *   If LayoutPolicy is "fit", TileLayout.expandMargins is false, TileLayout.tilesPerLine is set,
     *   Orientation is "vertical",
     *   and tileHeight is not set, tileHeight will be computed automatically based on TileLayout.tilesPerLine.
     *  @type {Integer}
     *  @default null
     */
    open var tileHeight: Number = definedExternally
    /**
     *  Margin in between tiles. Can be set on a per-axis basis with TileLayout.tileHMargin and
     *   TileLayout.tileVMargin.
     *  @type {Integer}
     *  @default "10"
     */
    open var tileMargin: Number = definedExternally
    /**
     *  Horizontal margin in between tiles. See TileLayout.tileMargin.
     *  @type {Integer}
     *  @default null
     */
    open var tileHMargin: Number = definedExternally
    /**
     *  Vertical margin in between tiles. See TileLayout.tileMargin.
     *  @type {Integer}
     *  @default null
     */
    open var tileVMargin: Number = definedExternally
    /**
     *  A margin left around the outside of all tiles.
     *  @type {Integer}
     *  @default "5"
     */
    open var layoutMargin: Number = definedExternally
    /**
     *  If this widget has padding specified (as Canvas.padding or in the
     *   CSS style applied to this layout), should it show up as space outside the members,
     *   similar to layoutMargin?
     * 
     *   If this setting is false, padding will not affect member positioning (as CSS padding
     *   normally does not affect absolutely positioned children). Leaving this setting true
     *   allows a designer to more effectively control layout purely from CSS.
     * 
     *   Note that Layout.layoutMargin if specified, takes precedence over this value.
     *  @type {boolean}
     *  @default true
     */
    open var paddingAsLayoutMargin: Boolean = definedExternally
    /**
     *  If set, tiles animate to their new positions when a tile is added, removed, or reordered via
     *   drag and drop.
     *  @type {boolean}
     *  @default true
     */
    open var animateTileChange: Boolean = definedExternally
    /**
     *  Direction of tiling. See also TileLayoutPolicy.
     *  @type {Orientation}
     *  @default "horizontal"
     */
    open var orientation: 
                          /**
                           *  members laid out vertically
                           *  members laid out horizontally
                           */
                          String /* vertical |  horizontal */ = definedExternally
    /**
     *  Number of tiles to show in each line. Auto-derived from TileLayout.tileSize for some layout
     *   modes. See TileLayoutPolicy.
     *   This can also affect TileLayout.tileWidth or TileLayout.tileHeight. See those properties for details.
     *  @type {Integer}
     *  @default null
     */
    open var tilesPerLine: Number = definedExternally
    /**
     *  Normal Overflow settings can be used on TileLayouts, for example, an
     *   overflow:auto TileLayout will scroll if members exceed its specified size, whereas an
     *   overflow:visible TileLayout will grow to accommodate members.
     *  @type {Overflow}
     *  @default "auto"
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
     *  With LayoutPolicy:"fit", should margins be expanded so that tiles fill the
     *   available space in the TileLayout on the breadth axis?
     *   This can also affect TileLayout.tileWidth or TileLayout.tileHeight. See those properties for details.
     *  @type {boolean}
     *  @default true
     */
    open var expandMargins: Boolean = definedExternally
    /**
     *  When LayoutPolicy is "flow", should we automatically start a new line when there's
     *   not enough room to fit the next tile on the same line?
     * 
     *   If set to false, a new line will only be started if a tile specifies tile.startLine or
     *   tile.endLine.
     *  @type {boolean}
     *  @default true
     */
    open var autoWrapLines: Boolean = definedExternally
    /**
     *  Canvas used to display a drop indicator when a another canvas is dragged over this widget.
     *  @type {Canvas}
     *  @default null
     */
    open var dragLine: Canvas = definedExternally
    /**
     *  Indicates what to do with data dragged into another DataBoundComponent. See
     *   DragDataAction type for details.
     *  @type {DragDataAction}
     *  @default "move"
     */
    open var dragDataAction: 
                             /**
                              *  Don't do anything, resulting in the same data being in both lists.
                              *  Copy the data leaving the original in our list.
                              *  Remove the data from this list so it can be moved into the other list.
                              */
                             String /* none |  copy |  move */ = definedExternally
    /**
     *   Retrieve a tile by index.
     * 
     *   The TileLayout consistently uses this method to access tiles, in order to allow subclasses
     *   to create tiles on demand.
     * 
     * 
     *  @param {Integer} index of the tile
     */
    open fun getTile(tile: dynamic): Canvas = definedExternally
    /**
     *   Add a tile to the layout, dynamically.
     * 
     * 
     *  @param {Canvas} new tile to add
     *  @param {Integer=} position where the tile should be added. Defaults to adding the tile at the end.
     */
    open fun addTile(tile: Canvas, index: Number?): Unit = definedExternally
    /**
     *   Remove a tile from the layout.
     * 
     * 
     *  @param {Canvas | Integer | GlobalId} index or String ID of the tile
     */
    open fun removeTile(tileID: dynamic): Boolean = definedExternally
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
    open fun transferDragData(): Array<dynamic> = definedExternally
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
    open fun getDragData(source: DataBoundComponent): Array<dynamic> = definedExternally
    /**
     *   Sets the height and width of tiles.
     * 
     *  @param {Integer} size
     */
    open fun setTileSize(size: Number): Unit = definedExternally
    /**
     *   Sets the width of tiles.
     * 
     *  @param {Integer} width
     */
    open fun setTileWidth(width: Number): Unit = definedExternally
    /**
     *   Sets the height of tiles.
     * 
     *  @param {Integer} height
     */
    open fun setTileHeight(height: Number): Unit = definedExternally
    /**
     *   Sets the number of tiles per line.
     * 
     *  @param {Integer} New TileLayout.tilesPerLine value
     */
    open fun setTilesPerLine(tilesPerLine: Number): Unit = definedExternally
    /**
     *   Sets the vertical and horizontal margin of tiles.
     * 
     *  @param {Integer} margin
     */
    open fun setTileMargin(margin: Number): Unit = definedExternally
    /**
     *   Sets the horizontal margin of tiles.
     * 
     *  @param {Integer} margin
     */
    open fun setTileHMargin(margin: Number): Unit = definedExternally
    /**
     *   Sets the vertical margin of tiles.
     * 
     *  @param {Integer} margin
     */
    open fun setTileVMargin(margin: Number): Unit = definedExternally
    companion object {
        /**
         *  Creates a new TileLayout
         * 
         *  @param typeCheckedProperties {Partial<TileLayout>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {TileLayout} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): TileLayout = definedExternally
    }
}