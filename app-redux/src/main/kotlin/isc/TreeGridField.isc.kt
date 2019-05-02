@file:JsQualifier("isc")
package isc

/**
 *  An object literal with a particular set of properties used to configure the display of
 *   and interaction with the columns of a TreeGrid.
 *   TreeGrid is a subclass of ListGrid and as a result, for all fields except
 *   the field containing the Tree itself (specified by
 *   TreeGridField.treeField, all properties settable on
 *   ListGridField apply to TreeGridField as well.
 * 
 *   This class documents just those properties that are specific to TreeGridFields - see
 *   ListGridField for the set of inherited properties.
 */
open external class TreeGridField : ListGridField {
    /**
     *  The field containing treeField: true will display the Tree. If no
     *   field specifies this property, if a field named after the Tree.titleProperty of
     *   the Tree is present in TreeGrid.fields, that field will show the tree. Note that
     *   when using a DataSource, you typically define the title field via
     *   DataSource.titleField and the generated ResultTree automatically uses this
     *   field.
     * 
     *   If none of the above rules apply, the first field in TreeGrid.fields is assigned to
     *   display the Tree.
     *  @type {boolean}
     *  @default "see below"
     */
    open var treeField: Boolean = definedExternally
    /**
     *  Dictates whether the data in this field be exported. Explicitly set this
     *   to false to prevent exporting. Has no effect if the underlying
     *   DataSourceField.canExport is explicitly set to
     *   canExport: false.
     *  @type {boolean}
     *  @default null
     */
    override var canExport: Boolean = definedExternally
}