@file:JsQualifier("isc")
package isc

/**
 *  An object representing a component that is currently being edited within an
 *   EditContext.
 * 
 *   An EditNode is essentially a copy of a PaletteNode, initially with the same properties
 *   as the PaletteNode from which it was generated. However unlike a PaletteNode, an EditNode
 *   always has a EditNode.liveObject - the object created from the
 *   PaletteNode.defaults or other properties defined on a paletteNode.
 * 
 *   Like a Palette, an EditContext may use properties such as PaletteNode.icon or
 *   PaletteNode.title to display EditNodes.
 * 
 *   An EditContext generally offers some means of editing EditNodes and, as edits are made,
 *   updates EditNode.defaults with the information required to re-create the component.
 */
open external class EditNode : PaletteNode {
    /**
     *  Properties required to recreate the current EditNode.liveObject.
     *  @type {Properties}
     *  @default null
     */
    override var defaults: dynamic = definedExternally
    /**
     *  Properties to be applied to the
     *   EditNode.liveObject.Canvas.editProxy when created.
     * 
     *   Note that the editProxy is created the first time a component is placed into
     *   editMode, so any editProxyProperties must be set before then.
     *  @type {EditProxy}
     *  @default null
     */
    override var editProxyProperties: EditProxy = definedExternally
    /**
     *  SCClassName of the EditNode.liveObject
     *   , for example, "ListGrid".
     *  @type {SCClassName}
     *  @default null
     */
    override var type: String = definedExternally
    /**
     *  Live version of the object created from the EditNode.defaults. For example,
     *   if EditNode.type is "ListGrid", liveObject would be a ListGrid.
     *  @type {object}
     *  @default null
     */
    override var liveObject: dynamic = definedExternally
    /**
     *  Shortcut property to be applied to the
     *   EditNode.liveObject.Canvas.editProxy when created.
     *  @type {boolean}
     *  @default null
     */
    open var useEditMask: Boolean = definedExternally
    /**
     *  See PaletteNode.canDuplicate.
     *  @type {boolean}
     *  @default null
     */
    override var canDuplicate: Boolean = definedExternally
}