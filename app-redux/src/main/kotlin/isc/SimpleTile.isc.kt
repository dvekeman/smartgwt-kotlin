@file:JsQualifier("isc")
package isc

/**
 *  Default class used by a TileGrid to render each tile. See TileGrid.tile.
 * 
 *   SimpleTiles should not be created directly, instead, use a TileGrid and provide data and
 *   SimpleTile instances are created for you.
 */
open external class SimpleTile : StatefulCanvas {
    /**
     *  CSS style for the tile as a whole. As with StatefulCanvas.baseStyle, suffixes
     *   are appended to this style to represent various states ("Over", "Selected", etc).
     *  @type {CSSStyleName}
     *  @default "simpleTile"
     */
    override var baseStyle: String = definedExternally
    /**
     *  The TileGrid that created this SimpleTile. This property will be null
     *   if the tile was created by a user-provided TileGrid.createTile method.
     *  @deprecated \* As of SmartClient 10.0, use SimpleTile.tileGrid.
     *  @type {TileGrid}
     *  @default null
     */
    open var creator: TileGrid = definedExternally
    /**
     *  The TileGrid that created this SimpleTile.
     *  @type {TileGrid}
     *  @default null
     */
    open var tileGrid: TileGrid = definedExternally
    /**
     *   The default implementation will call TileGrid.getTileHTML.
     * 
     */
    override fun getInnerHTML(): String = definedExternally
    /**
     *   Return the record that this tile should render.
     * 
     *   NOTE: a TileGrid that is doing data paging may reuse tiles with different records, so a
     *   subclass of SimpleTile should not cache the record returned by getRecord().
     * 
     * 
     */
    open fun getRecord(): TileRecord = definedExternally
    companion object {
        /**
         *  Creates a new SimpleTile
         * 
         *  @param typeCheckedProperties {Partial<SimpleTile>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {SimpleTile} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): SimpleTile = definedExternally
    }
}