@file:JsQualifier("isc")
package isc

/**
 *  ListGrid subclass used, by default, by FormItems which implement
 *   PickList to display a PickList.dataSetType of selectable
 *   options.
 * 
 *   Can be subclassed, customized and assigned to FormItems
 *   via the ComboBoxItem.pickListConstructor attribute.
 */
open external class PickListMenu : ListGrid {
    /**
     *  The string to display in the body of a listGrid with an empty data array, if
     *   showEmptyMessage is true.
     *  @type {string}
     *  @default "No Items To Show"
     */
    override var emptyMessage: String = definedExternally
    /**
     *  For databound ListGrids, this attribute can be used to customize the ResultSet
     *   object created for this grid when data is fetched
     *  @type {ResultSet}
     *  @default null
     */
    override var dataProperties: ResultSet = definedExternally
    /**
     *  Default CSS class for the ListGrid as a whole.
     *  @type {CSSStyleName}
     *  @default "pickListMenu"
     */
    override var styleName: String = definedExternally
    /**
     *  CSS style used for the body of this grid. If applying a background-color to the body
     *   via a CSS style applied using this property, be sure to set
     *   ListGrid.bodyBackgroundColor to null.
     *  @type {CSSStyleName}
     *  @default "pickListMenuBody"
     */
    override var bodyStyleName: String = definedExternally
    /**
     *  If ListGrid.baseStyle is unset, base style will be derived from
     *   ListGrid.normalBaseStyle if this grid has fixed row heights and
     *   the specified ListGrid.cellHeight matches this value. Otherwise
     *   ListGrid.tallBaseStyle will be used.
     *  @type {number}
     *  @default "16"
     */
    override var normalCellHeight: Number = definedExternally
    companion object {
        /**
         *  Creates a new PickListMenu
         * 
         *  @param typeCheckedProperties {Partial<PickListMenu>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {PickListMenu} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): PickListMenu = definedExternally
    }
}