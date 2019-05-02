@file:JsQualifier("isc")
package isc

/**
 *  A TileRecord is a JavaScript Object whose properties contain values for each
 *   TileField. A TileRecord may have additional properties which affect the record's
 *   appearance or behavior, or which hold data for use by custom logic or other, related
 *   components.
 */
open external class TileRecord {
    /**
     *  SmartClient Class to use to construct the tile for this particular record.
     *  @type {string}
     *  @default null
     */
    open var tileConstructor: String = definedExternally
    /**
     *  Additional properties to be passed when creating a tile for this record.
     *  @type {Canvas}
     *  @default null
     */
    open var tileProperties: Canvas = definedExternally
}