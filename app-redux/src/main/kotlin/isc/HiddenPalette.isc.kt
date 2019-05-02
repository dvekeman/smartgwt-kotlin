@file:JsQualifier("isc")
package isc

/**
 *  A Palette with no visible representation that handles programmatic creation of components.
 */
open external class HiddenPalette : Class, Palette {
    /**
     *  A list of PaletteNode for component creation.
     *  @type {Array<Partial<PaletteNode>>}
     *  @default null
     */
    open var data: Array<dynamic> = definedExternally
    /**
     *  Default EditContext that this palette should use. Palettes generally create components via
     *   drag and drop, but may also support creation via double-click or other UI idioms when a
     *   defaultEditContext is set.
     *  @type {EditContext | EditTree | EditPane}
     *  @default null
     */
    override var defaultEditContext: dynamic = definedExternally
    /**
     *  Whether created components should have their "ID" or "name" property automatically set
     *   to a unique value based on the component's type, eg, "ListGrid0".
     *  @type {boolean}
     *  @default true
     */
    override var generateNames: Boolean = definedExternally
    /**
     *   Sets the default EditContext that this palette should use. Palettes generally create components via
     *   drag and drop, but may also support creation via double-click or other UI idioms when a
     *   defaultEditContext is set.
     * 
     *  @param {EditContext | EditTree | EditPane} the default EditContext used by this Palette
     */
    override fun setDefaultEditContext(defaultEditContext: dynamic): Unit = definedExternally
    /**
     *   Given a PaletteNode, make an EditNode from it by creating a
     *   EditNode.liveObject from the PaletteNode.defaults
     *   and copying presentation properties (eg PaletteNode.title
     *   to the editNode.
     * 
     *   If editNodeProperties is specified as an object on
     *   on the paletteNode, each property in this object will also be copied across to
     *   the editNode.
     * 
     * 
     *  @param {PaletteNode} paletteNode to create from
     */
    override fun makeEditNode(paletteNode: PaletteNode): EditNode = definedExternally
    companion object {
        /**
         *  Creates a new HiddenPalette
         * 
         *  @param typeCheckedProperties {Partial<HiddenPalette>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {HiddenPalette} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): HiddenPalette = definedExternally
    }
}