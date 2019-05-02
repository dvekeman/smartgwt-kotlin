@file:JsQualifier("isc")
package isc

/**
 *  The Progressbar widget class extends the StretchImg class to implement image-based progress
 *   bars (graphical bars whose lengths represent percentages, typically of task completion).
 */
open external class Progressbar : StretchImg {
    /**
     *  Number from 0 to 100, inclusive, for the percentage to be displayed graphically in
     *   this progressbar.
     *  @type {number}
     *  @default "0"
     */
    open var percentDone: Number = definedExternally
    /**
     *  Length of the progressbar in pixels. This is effectively height for a vertical
     *   progressbar, or width for a horizontal progressbar.
     * 
     *   This property must be set instead of setting width or height.
     *  @type {number | string}
     *  @default "100"
     */
    open var length: dynamic = definedExternally
    /**
     *  Thickness of the progressbar in pixels. This is effectively width for a vertical
     *   progressbar, or height for a horizontal progressbar.
     * 
     *   This property must be set instead of setting width or height.
     *  @type {number}
     *  @default "20"
     */
    open var breadth: Number = definedExternally
    /**
     *  Indicates whether this is a vertical or horizontal progressbar.
     *  @type {boolean}
     *  @default false
     */
    override var vertical: Boolean = definedExternally
    /**
     *  The base file name for the progressbar image.
     *  @type {SCImgURL}
     *  @default "[SKIN]progressbar.gif"
     */
    override var src: String = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "ProgressbarProxy"
     */
    override var editProxyConstructor: String = definedExternally
    /**
     *   Sets percentDone to newPercent.
     * 
     * 
     *  @param {number} percent to show as done (0-100)
     */
    open fun setPercentDone(newPercent: Number): Unit = definedExternally
    /**
     *   This method is called when the percentDone value changes. Observe this method to be notified upon
     *   a change to the percentDone value.
     * 
     * 
     */
    open fun percentChanged(): Unit = definedExternally
    /**
     *   Returns the current width of a horizontal progressbar, or height of a vertical progressbar.
     * 
     * 
     */
    open fun getLength(): Number = definedExternally
    /**
     *   Returns the current height of a horizontal progressbar, or width of a vertical progressbar.
     * 
     * 
     */
    open fun getBreadth(): Number = definedExternally
    /**
     *   Sets the length of the progressbar to newLength. This is the width of a horizontal progressbar,
     *   or the height of a vertical progressbar.
     * 
     * 
     *  @param {number} the new length of the progressbar
     */
    open fun setLength(newLength: Number): Unit = definedExternally
    /**
     *   Sets the breadth of the progressbar to newLength. This is the height of a horizontal progressbar,
     *   or the width of a vertical progressbar.
     * 
     * 
     *  @param {number} the new breadth of the progressbar
     */
    open fun setBreadth(newBreadth: Number): Unit = definedExternally
    companion object {
        /**
         *  Creates a new Progressbar
         * 
         *  @param typeCheckedProperties {Partial<Progressbar>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Progressbar} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Progressbar = definedExternally
    }
}