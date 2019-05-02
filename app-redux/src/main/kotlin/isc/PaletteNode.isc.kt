@file:JsQualifier("isc")
package isc

/**
 *  An object representing a component which the user may create dynamically within an
 *   application.
 * 
 *   A PaletteNode expresses visual properties for how the palette will display it (eg
 *   PaletteNode.title, PaletteNode.icon) as well as instructions for
 *   creating the component the paletteNode represents (PaletteNode.type,
 *   PaletteNode.defaults).
 * 
 *   Various types of palettes (ListPalette, TreePalette, MenuPalette,
 *   TilePalette) render a PaletteNode in different ways, and allow the user to trigger
 *   creation in different ways (eg drag and drop, or just click). All share a common pattern
 *   for how components are created from palettes.
 * 
 *   Note that in a TreePalette, a PaletteNode is essentially a TreeNode and can have
 *   properties expected for a TreeNode (eg,
 *   TreeGrid.customIconDropProperty). Likewise
 *   a PaletteNode in a MenuPalette can have the properties of a MenuItem, such as
 *   MenuItem.enableIf.
 */
open external class PaletteNode {
    /**
     *  Icon for this paletteNode.
     *  @type {SCImgURL}
     *  @default null
     */
    open var icon: String = definedExternally
    /**
     *  Textual title for this paletteNode.
     *  @type {string}
     *  @default null
     */
    open var title: String = definedExternally
    /**
     *  SCClassName this paletteNode creates, for example, "ListGrid".
     *  @type {SCClassName}
     *  @default null
     */
    open var type: String = definedExternally
    /**
     *  Prefix used to create unique component ID. If not specified, PaletteNode.type
     *   is used.
     *  @type {string}
     *  @default null
     */
    open var idPrefix: String = definedExternally
    /**
     *  Defaults for the component to be created from this palette.
     * 
     *   For example, if PaletteNode.type is "ListGrid", properties valid to pass to
     *   Class.create.
     * 
     *   Note that event handlers or method overrides cannot be configured as defaults,
     *   as they cannot be serialized or restored. Instead, create a subclass that implements the
     *   desired behaviors, and use that subclass as PaletteNode.type.
     * 
     *  @type {Properties}
     *  @default null
     */
    open var defaults: dynamic = definedExternally
    /**
     *  Properties to be applied to the
     *   PaletteNode.liveObject.Canvas.editProxy when created.
     *  @type {EditProxy}
     *  @default null
     */
    open var editProxyProperties: EditProxy = definedExternally
    /**
     *  Properties to be applied to the EditNode when created.
     *  @type {EditNode}
     *  @default null
     */
    open var editNodeProperties: EditNode = definedExternally
    /**
     *  For a paletteNode which should be a "singleton", that is, always provides the exact same
     *   object (==) rather than a dynamically created copy, provide the singleton object as
     *   liveObject.
     * 
     *   Instead of dynamically creating an object from defaults, the liveObject will
     *   simply be assigned to EditNode.liveObject for the created editNode.
     *  @type {object}
     *  @default null
     */
    open var liveObject: dynamic = definedExternally
    /**
     *  If set to false, indicates that this node cannot be
     *   EditProxy.useCopyPasteShortcuts, including disallowing calls to
     *   EditContext.makePaletteNode for EditNode created from this
     *   PaletteNode.
     *  @type {boolean}
     *  @default null
     */
    open var canDuplicate: Boolean = definedExternally
}