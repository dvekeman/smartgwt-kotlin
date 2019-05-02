@file:JsQualifier("isc")
package isc

/**
 *  The NativeScrollbar widget will render in the browser as a native
 *   scrollbar, and has APIs allowing it to be applied to scroll content any another widget
 *   on the page. Essentially this behaves similarly to the Scrollbar class but will
 *   be rendered as a native browser scrollbar rather than using media, thus providing the
 *   advantages of an independant scrollbar (support for rendering the scrollbar separate from the
 *   content it effects, support for "virtual scrolling" mechanisms where content size is unknown
 *   at initial render, etc), with a native look and feel and without requiring the loading of
 *   additional media on the page.
 * 
 *   To enable this for a component simply set Canvas.showCustomScrollbars to true and
 *   set Canvas.scrollbarConstructor to "NativeScrollbar"
 */
open external class NativeScrollbar : Canvas {
    /**
     *       Sets or clears the scrollbar's scrollTarget. If no argument is provided, then the
     *       scrollTarget will be set to the scrollbar itself.
     * 
     * 
     *  @param {Canvas=} target canvas to be scrolled
     */
    open fun setScrollTarget(newTarget: Canvas?): Unit = definedExternally
    companion object {
        /**
         *  Creates a new NativeScrollbar
         * 
         *  @param typeCheckedProperties {Partial<NativeScrollbar>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {NativeScrollbar} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): NativeScrollbar = definedExternally
    }
}