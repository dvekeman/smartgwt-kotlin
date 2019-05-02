@file:JsQualifier("isc")
package isc

/**
 *  A simple container that implements the policy that at most one of its contained components
 *   is visible at any given time.
 * 
 *   The set of mutually exclusive components is specified by Deck.panes, and whichever
 *   component is visible fills the space of the Deck automatically.
 * 
 *   To switch to a new pane, call Deck.setCurrentPane, or simply call
 *   Canvas.show on the pane directly - the Deck will notice that you
 *   have shown a different pane and hide other panes automatically.
 * 
 *   Canvas.children may also be used; any components that are specified as children are
 *   unmanaged by the Deck and so can place themselves arbitrarily.
 * 
 *   Deck achieves its mutually-exclusive display behavior by using the superclass
 *   Layout.members property, which means that properties such as Layout.layoutMargin
 *   and Layout.vPolicy do apply to deck. However, trying to manipulate
 *   deck.members with APIs such as Layout.addMember is not supported and
 *   will have undefined results.
 */
open external class Deck : Layout {
    /**
     *  Set of mutually exclusive panes displayed in this Deck.
     * 
     *   If Deck.currentPane is not set, when the Deck is first drawn, the
     *   first pane in this array becomes the currentPane.
     *  @type {Array<Partial<Canvas>>}
     *  @default null
     */
    open var panes: Array<dynamic> = definedExternally
    /**
     *  The pane currently shown in this Deck. All other panes are hidden.
     *  @type {Canvas}
     *  @default null
     */
    open var currentPane: Canvas = definedExternally
    /**
     *   Change the CurrentPane.
     * 
     *   If the passed pane is not contained in this Deck, logs a warning and does
     *   nothing.
     * 
     *  @param {Canvas | GlobalId} the pane to show, as either a Canvas or the Canvas.ID
     */
    open fun setCurrentPane(pane: dynamic): Unit = definedExternally
    /**
     *   Hides the current pane, without showing any other pane.
     * 
     */
    open fun hideCurrentPane(): Unit = definedExternally
    companion object {
        /**
         *  Creates a new Deck
         * 
         *  @param typeCheckedProperties {Partial<Deck>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Deck} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Deck = definedExternally
    }
}