@file:JsQualifier("isc")
package isc

/**
 *  Maintains a representation of selection over a 2-dimensional grid of objects.
 *   Automatically created to manage cell-selection on CubeGrid widgets.
 */
open external class CellSelection : Class {
    /**
     *   Return true if a particular item is selected
     * 
     *  @param {Integer} row index of the cell to check
     *  @param {Integer} column index of the cell to check
     */
    open fun cellIsSelected(rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Is anything in the list selected?
     * 
     */
    open fun anySelected(): Boolean = definedExternally
    /**
     *   Returns an array of the currently selected cells. Each cell is returned as a 2 element
     *   array in the form [rowNum, colNum].
     * 
     */
    open fun getSelectedCells(): Array<dynamic> = definedExternally
    /**
     *   Returns the first record that has any cells selected.
     * 
     */
    open fun getSelectedRecord(): ListGridRecord = definedExternally
    /**
     *   Observable handler fired whenever the cell selection is modified
     * 
     * 
     */
    open fun selectionChanged(): Unit = definedExternally
    /**
     *   Select a particular cell
     * 
     * 
     *  @param {Integer} row index of cell to select
     *  @param {Integer} column index of cell to select
     */
    open fun selectCell(rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *   Deselect a particular cell
     * 
     * 
     *  @param {Integer} row index of the cell to select
     *  @param {Integer} column index of the cell to select
     */
    open fun deselectCell(rowNum: Number, colNum: Number): Boolean = definedExternally
    /**
     *    select an array of cells
     * 
     *  @param {Array<Partial<any>>} Array of cells to select. Each cell can be specified                    as a 2 element array [rowNum, colNum]
     */
    open fun selectCellList(list: Array<dynamic>): Boolean = definedExternally
    /**
     *    deselect an array of cells
     * 
     * 
     *  @param {Array<Partial<any>>} Array of cells to deselect. Each cell can be specified                    as a 2 element array [rowNum, colNum]
     */
    open fun deselectCellList(list: Array<dynamic>): Boolean = definedExternally
    /**
     *    select a single cell and deselect everything else
     * 
     *  @param {Integer} row index of cell to select
     *  @param {Integer} column index of cell to select
     */
    open fun selectSingleCell(rowNum: Number, colNum: Number): Boolean = definedExternally
    companion object {
        /**
         *  Creates a new CellSelection
         * 
         *  @param typeCheckedProperties {Partial<CellSelection>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {CellSelection} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): CellSelection = definedExternally
    }
}