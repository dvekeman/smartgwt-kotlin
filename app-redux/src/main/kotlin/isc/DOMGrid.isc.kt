@file:JsQualifier("isc")
package isc

/**
 *  Provides a tree view of any DOM-compliant structure, such as an XML or HTML document.
 */
open external class DOMGrid : TreeGrid {
    /**
     *  Root element (or document) to view in the tree.
     *  @type {DOMElement}
     *  @default null
     */
    open var rootElement: DOMElement = definedExternally
    /**
     *   Set the root element (or document) to view in the tree.
     * 
     *  @param {DOMElement} new root element
     */
    open fun setRootElement(rootElement: DOMElement): Unit = definedExternally
    companion object {
        /**
         *  Creates a new DOMGrid
         * 
         *  @param typeCheckedProperties {Partial<DOMGrid>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DOMGrid} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DOMGrid = definedExternally
    }
}