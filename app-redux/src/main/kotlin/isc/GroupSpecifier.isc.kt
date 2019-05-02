@file:JsQualifier("isc")
package isc

/**
 *  A Javascript object defining the details of a single group operation. Used by the
 *   MultiGroupDialog to edit multi-level grouping scenarios for
 *   use by components that support grouping.
 */
open external class GroupSpecifier {
    /**
     *  The property name, eg a ListGridField, to which this groupSpecifier applies.
     *  @type {string}
     *  @default null
     */
    open var property: String = definedExternally
    /**
     *  The grouping mode applied by this specifier. The list of available modes can come either
     *   from the associated ListGridField.groupingModes or from it's specified
     *   SimpleType.groupingModes.
     *  @type {string}
     *  @default null
     */
    open var grouping: String = definedExternally
    /**
     *  A normalizer function which this groupSpecifier will use to group.
     *  @type {Function}
     *  @default null
     */
    open var normalizer: (() -> dynamic) = definedExternally
    /**
     *  A DataBoundComponent providing the context for the group-normalizer.
     *  @type {DataBoundComponent}
     *  @default null
     */
    open var context: DataBoundComponent = definedExternally
}