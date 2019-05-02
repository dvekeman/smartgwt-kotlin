@file:JsQualifier("isc")
package isc

/**
 *  Settings for generating printable HTML for components.
 */
open external class PrintProperties {
    /**
     *  An array of Strings indicating the classNames of controls that should be omitted from
     *   printing. By default, omitControls includes all button-based controls, menus
     *   and similar interactive controls that are typically useless in printed output.
     * 
     *   All subclasses of the specified classes are also omitted.
     * 
     *   See also PrintProperties.includeControls.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var omitControls: Array<dynamic> = definedExternally
    /**
     *  An array of Strings indicating the classNames of controls that should be specifically
     *   included when printing, even if a superclass is listed in PrintProperties.omitControls.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var includeControls: Array<dynamic> = definedExternally
    /**
     *  If true, generates HTML for export.
     * 
     *   Some components, specifically DrawPane and FacetChart on IE8 and earlier, need to generate
     *   different HTML for export versus in-browser print preview. When using RPCManager.exportContent
     *   the printForExport property is set to true automatically. If not using RPCManager.exportContent(),
     *   but the generated HTML will be sent for export, the PrintProperties passed to
     *   Canvas.getPrintHTML must have printForExport:true.
     *  @type {boolean}
     *  @default null
     */
    open var printForExport: Boolean = definedExternally
}