@file:JsQualifier("isc")
package isc

/**
 *  A TileGrid that implements the Palette behavior, so it can be used as the source for
 *   drag and drop instantiation of components when combined with an EditContext as
 *   the drop target.
 * 
 *   Each TileGrid.tile can be a PaletteNode.
 */
open external class TilePalette : TileGrid, Palette {
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
         *  Creates a new TilePalette
         * 
         *  @param typeCheckedProperties {Partial<TilePalette>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {TilePalette} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): TilePalette = definedExternally
    }
}