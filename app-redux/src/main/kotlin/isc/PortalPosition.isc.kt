@file:JsQualifier("isc")
package isc

/**
 *  Represents the position of a Portlet within a PortalLayout, indicating the
 *   column, row, and position within the row.
 */
open external class PortalPosition {
    /**
     *  The column number occupied by a Portlet within a PortalLayout.
     *  @type {Integer}
     *  @default "0"
     */
    open var colNum: Number = definedExternally
    /**
     *  The row number occupied by a Portlet within a PortalLayout column.
     *  @type {Integer}
     *  @default "0"
     */
    open var rowNum: Number = definedExternally
    /**
     *  The position occupied by a Portlet within a PortalLayout row
     *   (generally 0, unless there is more than one Portlet in the row).
     *  @type {Integer}
     *  @default "0"
     */
    open var position: Number = definedExternally
}