@file:JsQualifier("isc")
package isc

/**
 *  A component that connects to a Hibernate configuration and displays the currently-mapped
 *   entities. It also allows you to view the bean properties of a selected entity, and optionally
 *   retrieves and displays the data currently in the corresponding database table.
 * 
 *   The HibernateBrowser can also create a SmartClient DataSource from any existing Hibernate
 *   mapping.
 */
open external class HibernateBrowser : Window {
    /**
     *  Instance of TreeGrid used to display the Hibernate mappings (beans and properties)
     *  @type {TreeGrid}
     *  @default null
     */
    open var mappingTree: TreeGrid = definedExternally
    /**
     *  Instance of ListGrid used to display the actual data in the database table associated with
     *   the mapping selected in the HibernateBrowser.mappingTree.
     *  @type {ListGrid}
     *  @default null
     */
    open var dataGrid: ListGrid = definedExternally
    /**
     *  A title to show in the header button of the HibernateBrowser's mapping tree.
     *  @type {string}
     *  @default "Hibernate Mappings"
     */
    override var title: String = definedExternally
    /**
     *  Instance of Button used to continue once a table has been selected.
     *  @type {Button}
     *  @default null
     */
    open var selectButton: Button = definedExternally
    /**
     *  If set, specifies a substring which must exist in an entity name for it to be included in
     *   this HibernateBrowser. If this property is set to a List of strings, entity names are
     *   included if they match any one of the strings. The comparison is case-insensitive.
     * 
     *   For example, includeSubstring: ["Order", "inv"] would match all the following
     *   entity names: "ORDERS", "Inventory", "client_invoicing"
     *  @type {string | Array<Partial<string>>}
     *  @default null
     */
    open var includeSubstring: dynamic = definedExternally
    /**
     *  If set, specifies a substring which must NOT exist in an entity name for it to be included in
     *   this HibernateBrowser. If this property is set to a List of strings, entity names are
     *   excluded if they match any one of the strings. The comparison is case-insensitive.
     * 
     *   For example, excludeSubstring: ["Order", "inv"] would exclude all the following
     *   entity names: "ORDERS", "Inventory", "client_invoicing"
     * 
     *   Note that if you specify both include and exclude criteria and they conflict (ie,
     *   according to the criteria you set, an entity should be both included and excluded),
     *   exclude wins.
     *  @type {string | Array<Partial<string>>}
     *  @default null
     */
    open var excludeSubstring: dynamic = definedExternally
    /**
     *   Returns the DataSource most recently auto-derived by this HibernateBrowser. This will
     *   correspond to the currently-selected class mapping.
     * 
     */
    open fun getGeneratedDataSource(): Unit = definedExternally
    /**
     * 
     * 
     */
    open fun getResults(): Unit = definedExternally
    companion object {
        /**
         *  Creates a new HibernateBrowser
         * 
         *  @param typeCheckedProperties {Partial<HibernateBrowser>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {HibernateBrowser} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): HibernateBrowser = definedExternally
    }
}