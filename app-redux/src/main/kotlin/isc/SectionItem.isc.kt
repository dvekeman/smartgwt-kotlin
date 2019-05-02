@file:JsQualifier("isc")
package isc

/**
 *  Header item for a collapsible section in a DynamicForm. Each SectionItem
 *   is associated with a number of other items in the form, which will be shown or
 *   hidden as a group when the section is expanded or collapsed. Clicking on a
 *   SectionItem will expand or collapse the section.
 * 
 *   To make a form where only one section is expanded at a time, set
 *   DynamicForm.sectionVisibilityMode to "mutex".
 */
open external class SectionItem : CanvasItem {
    /**
     *  Section items show their value as title text for the section.
     *   Therefore the simplest way to specify this text on the form item directly is via the
     *   defaultValue attribute.
     *  @type {string}
     *  @default "Section Header"
     */
    override var defaultValue: String = definedExternally
    /**
     *  IDs of the items that should be considered a member of this section.
     *  @type {Array<Partial<GlobalId>>}
     *  @default null
     */
    open var itemIds: Array<dynamic> = definedExternally
    /**
     *  Whether this form section should initially be visible.
     *  @deprecated \* As of SmartClient version 5.5, use SectionItem.sectionExpanded       instead.
     *  @type {boolean}
     *  @default true
     */
    open var sectionVisible: Boolean = definedExternally
    /**
     *  Whether this form section should be initially collapsed. Can be set programmatically
     *   via SectionItem.expandSection and SectionItem.collapseSection.
     *  @type {boolean}
     *  @default true
     */
    open var sectionExpanded: Boolean = definedExternally
    /**
     *  Name of the Canvas subclass to use as a header that labels the section and allows
     *   showing and hiding. The default class be skinned, or trivial subclasses created to
     *   allow different appearances for SectionItems in different forms.
     *   Very advanced developers can use the following information to create custom header
     *   classes.
     *  @type {string}
     *  @default "SectionHeader"
     */
    open var sectionHeaderClass: String = definedExternally
    /**
     *  Whether this section header can be collapsed. If set false, suppresses open/close state
     *   icon
     *  @type {boolean}
     *  @default true
     */
    open var canCollapse: Boolean = definedExternally
    /**
     *  If true, the header for this Section will be included in the page's tab
     *   order for accessibility.
     *   May also be set at the DynamicForm level via
     *   DynamicForm.canTabToSectionHeaders.
     * 
     *   See accessibility.
     *  @type {boolean}
     *  @default null
     */
    open var canTabToHeader: Boolean = definedExternally
    /**
     *   Returns a boolean indicating whether this SectionItem is expanded.
     * 
     * 
     */
    open fun isExpanded(): Boolean = definedExternally
    /**
     *   Expands a section, showing all the items contained within the section.
     * 
     */
    open fun expandSection(): Unit = definedExternally
    /**
     *   Collapse a sectionItem, and hide all the items within the section (not including
     *   the header).
     * 
     */
    open fun collapseSection(): Unit = definedExternally
    companion object {
        /**
         *  Creates a new SectionItem
         * 
         *  @param typeCheckedProperties {Partial<SectionItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {SectionItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): SectionItem = definedExternally
    }
}