@file:JsQualifier("isc")
package isc

/**
 *  Maintains a 'selected' subset of a List or Array of objects, such as records in a record
 *   set, or widgets in a selectable header.
 * 
 *   Includes methods for selecting objects and checking which objects are selected, and also for
 *   selecting objects as a result of mouse events, including drag selection support.
 *   The selection object is used automatically to handle selection APIs on ListGrid
 *   and TreeGrid instances.
 * 
 *   Note that selection and deselection are skipped for objects that aren't enabled, or that are
 *   marked as non-selectable. For a ListGrid, the relevant properties are
 *   ListGrid.recordEnabledProperty and ListGrid.recordCanSelectProperty. The
 *   recommended approach to affect disabled objects via the Selection APIs is to temporarily
 *   enable them beforehand.
 */
open external class Selection : Class {
    /**
     *  Message to display to the user in a warn dialog if Selection.selectRange is
     *   called for a selection on a ResultSet, where the range of records to be selected has not been
     *   loaded.
     *  @type {string}
     *  @default "Can't select that many records at once.&amp;lt;br&amp;gt;&amp;lt;br&amp;gt;Please try working in smaller batches."
     */
    open var selectionRangeNotLoadedMessage: String = definedExternally
    /**
     *   Return true if a particular item is selected
     * 
     * 
     *  @param {object} object to check
     */
    open fun isSelected(item: dynamic): Boolean = definedExternally
    /**
     *   When using tree-oriented selection modes like TreeGrid.cascadeSelection, returns true
     *   if the record is considered partially selected because only some of it's children are
     *   selected.
     * 
     * 
     *  @param {object} object to check
     */
    open fun isPartiallySelected(item: dynamic): Boolean = definedExternally
    /**
     *   Whether at least one item is selected
     * 
     */
    open fun anySelected(): Boolean = definedExternally
    /**
     *   Returns the number of selected records.
     * 
     * 
     */
    open fun getLength(): Number = definedExternally
    /**
     *   Whether multiple items are selected
     * 
     */
    open fun multipleSelected(): Boolean = definedExternally
    /**
     *   Return an ordered array of all of the selected items
     * 
     *  @param {boolean=} When true, partially selected records will not be returned.                  Otherwise, all fully and partially selected records are                  returned.
     */
    open fun getSelection(excludePartialSelections: Boolean?): Array<dynamic> = definedExternally
    /**
     *     Return the first item in the list that is selected.
     * 
     *     Note that this should only be used if you know that one only one item
     *    may be selected, or you really don't care about items after the first one.
     * 
     *     To get all selected objects, use Selection.getSelection
     * 
     */
    open fun getSelectedRecord(): dynamic = definedExternally
    /**
     *   Select or deselect a particular item.
     *   All other selection routines go through this one, so by observing this routine you can
     *   monitor all selection changes.
     * 
     *  @param {object} object to select
     *  @param {boolean} turn selection on or off
     */
    open fun setSelected(item: dynamic, newState: Boolean): Boolean = definedExternally
    /**
     *     Select a particular item
     * 
     *  @param {object} object to select
     */
    open fun select(item: dynamic): Boolean = definedExternally
    /**
     *     Deselect a particular item
     * 
     *  @param {object} object to select
     */
    open fun deselect(item: dynamic): Boolean = definedExternally
    /**
     *   Select a single item and deselect everything else
     * 
     *  @param {object} object to select
     */
    open fun selectSingle(item: dynamic): Boolean = definedExternally
    /**
     *   Select an array of items (subset of the entire list)
     * 
     *  @param {Array<Partial<object>>} array of objects to select
     */
    open fun selectList(list: Array<dynamic>): Boolean = definedExternally
    /**
     *     Deselect an array of items (subset of the entire list)
     * 
     *  @param {Array<Partial<object>>} array of objects to select
     */
    open fun deselectList(list: Array<dynamic>): Boolean = definedExternally
    /**
     *   Select all records of the list.
     * 
     *  @param {boolean=} If this selection's data object is a tree,  if true is passed for this parameter,  only visible nodes will be selected. Nodes embedded in a closed parent folder  (and thus hidden from the user) will not be selected.
     */
    open fun selectAll(visibleNodesOnly: Boolean?): Boolean = definedExternally
    /**
     *     Deselect ALL records of the list
     * 
     */
    open fun deselectAll(): Boolean = definedExternally
    /**
     *   Select a particular item by its position in the list
     * 
     * 
     *  @param {number} index of the item to be selected
     */
    open fun selectItem(position: Number): Boolean = definedExternally
    /**
     *   Deselect a particular item by its position in the list
     * 
     * 
     *  @param {number} index of the item to be selected
     */
    open fun deselectItem(position: Number): Boolean = definedExternally
    /**
     *     Select range of records from start to end, non-inclusive.
     * 
     *  @param {number} start index to select
     *  @param {number} end index (non-inclusive)
     *  @param {boolean=} optional new selection state to set. True means                   selected, false means unselected. Defaults to true.
     */
    open fun selectRange(start: Number, end: Number, newState: Boolean?): Boolean = definedExternally
    /**
     *     Deselect range of records from start to end, non-inclusive
     * 
     * 
     *  @param {number} start index to select
     *  @param {number} end index (non-inclusive)
     */
    open fun deselectRange(start: Number, end: Number): Boolean = definedExternally
    companion object {
        /**
         *  A declared value of the enum type
         *   SelectionStyle.
         *  @type {Constant}
         *  @default "none"
         */
        var NONE: String = definedExternally
        /**
         *  A declared value of the enum type
         *   SelectionStyle.
         *  @type {Constant}
         *  @default "single"
         */
        var SINGLE: String = definedExternally
        /**
         *  A declared value of the enum type
         *   SelectionStyle.
         *  @type {Constant}
         *  @default "multiple"
         */
        var MULTIPLE: String = definedExternally
        /**
         *  A declared value of the enum type
         *   SelectionStyle.
         *  @type {Constant}
         *  @default "simple"
         */
        var SIMPLE: String = definedExternally
        /**
         *  Creates a new Selection
         * 
         *  @param typeCheckedProperties {Partial<Selection>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Selection} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Selection = definedExternally
    }
}