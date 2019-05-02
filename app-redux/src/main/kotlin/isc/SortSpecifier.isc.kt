@file:JsQualifier("isc")
package isc

/**
 *  A Javascript object defining the details of a single sort operation.
 * 
 *   You can convert between SortSpecifiers and the string format required by
 *   DSRequest.sortBy by calling DataSource.getSortBy and
 *   DataSource.getSortSpecifiers.
 */
open external class SortSpecifier {
    /**
     *  The property name, eg a ListGridField, to which this sortSpecifier applies.
     *  @type {string}
     *  @default null
     */
    open var property: String = definedExternally
    /**
     *  The direction in which this specifier should sort.
     *  @type {SortDirection}
     *  @default null
     */
    open var direction: 
                        /**
                         *  Sort in ascending order (eg: A-Z, larger items later in the list)
                         *  Sort in descending order (eg: Z-A, larger items earlier in the list)
                         */
                        String /* ascending |  descending */ = definedExternally
    /**
     *  A normalizer function which this sortSpecifier will use to sort.
     *  @type {Function}
     *  @default null
     */
    open var normalizer: (() -> dynamic) = definedExternally
    /**
     *  A DataBoundComponent providing the context for the sort-normalizer.
     *  @type {DataBoundComponent}
     *  @default null
     */
    open var context: DataBoundComponent = definedExternally
}