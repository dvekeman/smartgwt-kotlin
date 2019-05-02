@file:JsQualifier("isc")
package isc

/**
 *  A Toolbar creates a vertical or horizontal strip of similar components (typically Buttons)
 *   and provides managed resizing and reordering behavior over those components.
 * 
 *   If you are creating a bar with a mixture of different elements (eg some MenuButtons, some
 *   Labels, some Buttons, some custom components), you want to use a ToolStrip. A
 *   Toolbar is better suited for managing a set of highly similar, interchangeable components,
 *   such as ListGrid headers.
 */
open external class Toolbar : Layout {
    /**
     *  An array of button object initializers. See the Button Widget Class for standard
     *   button properties. The following additional properties can also be specified for
     *   button sizing and positioning on the toolbar itself:
     * 
     *  - width--Specifies the width of this button as an absolute number of pixels, a
     *   named property of the toolbar that specifies an absolute number of pixels, a
     *   percentage of the remaining space (e.g. '60%'), or "\*" (default) to allocate an
     *   equal portion of the remaining space.
     * 
     *  - height--Specifies the height of this button.
     * 
     *  - extraSpace--Specifies an optional amount of extra space, in pixels, to separate
     *   this button from the next button in the toolbar.
     *  @type {Array<Partial<Button>>}
     *  @default null
     */
    open var buttons: Array<dynamic> = definedExternally
    /**
     *  Indicates whether the buttons are drawn horizontally from left to right (false), or
     *   vertically from top to bottom (true).
     *  @type {boolean}
     *  @default false
     */
    override var vertical: Boolean = definedExternally
    /**
     *  Default constructor for toolbar items.
     *  @type {Class}
     *  @default "Button"
     */
    open var buttonConstructor: Class = definedExternally
    /**
     *  If true, items can be reordered by dragging on them.
     *  @type {boolean}
     *  @default false
     */
    open var canReorderItems: Boolean = definedExternally
    /**
     *  If true, items (buttons) can be resized by dragging on them.
     *  @type {boolean}
     *  @default false
     */
    open var canResizeItems: Boolean = definedExternally
    /**
     *  If true, items (buttons) can be dropped into this toolbar, and the toolbar will
     *   show a drop line at the drop location. Override drop() to decide what happens when the
     *   item is dropped.
     *  @type {boolean}
     *  @default false
     */
    override var canAcceptDrop: Boolean = definedExternally
    /**
     *  Settings to apply to all buttons of a toolbar. Properties that can be applied to
     *   button objects can be applied to all buttons of a toolbar by specifying them in
     *   buttonDefaults using the following syntax:
     *   buttonDefaults:{property1:value1, property2:value2, ...}
     *   See the Button Widget Class for standard button properties.
     *  @type {object}
     *  @default "varies"
     */
    open var buttonDefaults: dynamic = definedExternally
    /**
     *  If set to true, causes child buttons to be created during initialization, instead of waiting until
     *   draw().
     * 
     *   This property principally exists for backwards compatibility; the default behavior of waiting
     *   until draw makes certain pre-draw operations more efficient (such as adding, removing or
     *   reordering buttons). However, if you have code that assumes Buttons are created early
     *   and crashes if they are not, createButtonsOnInit will allow that code to
     *   continue working, with a minor performance penalty.
     *  @type {boolean}
     *  @default null
     */
    open var createButtonsOnInit: Boolean = definedExternally
    /**
     *   Apply a new set of buttons to render in this toolbar as Toolbar.buttons.
     * 
     * 
     *  @param {Array<Partial<Button>>=} properties to create each button from
     */
    open fun setButtons(newButtons: Array<dynamic>?): Unit = definedExternally
    /**
     *   Add a list of buttons to the toolbar
     * 
     *  @param {Array<Partial<object>>=} list of button object initializers.
     *  @param {number=} position to add the new buttons at
     */
    open fun addButtons(buttons: Array<dynamic>?, position: Number?): Unit = definedExternally
    /**
     *   Remove a list of buttons from the toolbar
     * 
     * 
     *  @param {Array<any>=} Array of buttons to remove. Buttons may be specified as pointers to the button instances contained in this toolbar, or numbers indicating the index of the buttons in this.buttons.
     */
    open fun removeButtons(buttons: Array<dynamic>?): Unit = definedExternally
    /**
     *       Retrieves a button widget instance (within this toolbar) from the name / ID / index /
     *       descriptor object for the button (as with the getButtonNumber() method)
     *       This provides a way to access a toolbar button's properties and methods directly.
     * 
     *  @param {number | string | object} identifier for the button to retrieve
     */
    open fun getButton(index: dynamic): Button = definedExternally
    /**
     *     get the index of a button in the buttons array
     *       The button can be specified as -
     * 
     * 
     *  - an index within this.buttons (just returned)
     * 
     *  - the ID property of a button
     * 
     *  - a pointer to the button descriptor object in this.buttons
     * 
     *  - the actual button widget in this.members
     * 
     *     returns -1 if not found
     * 
     * 
     * \* @param {number | string | any | any} 
     */
    open fun getButtonNumber(button: dynamic): Number = definedExternally
    /**
     *   Setter for updating Toolbar.canResizeItems at runtime.
     * 
     *  @param {boolean} New value for this.canResizeItems
     */
    open fun setCanResizeItems(canResizeItems: Boolean): Unit = definedExternally
    /**
     *   Given an identifier for a button, select it.
     *   The button identifier can be a number (index), string (id), or object (widget or init block),
     *   as with the getButtonNumber() method.
     * 
     * 
     *  @param {number | string | object | Canvas} Button / Button identifier
     */
    open fun selectButton(buttonID: dynamic): Unit = definedExternally
    /**
     *   Deselects the specified button from the toolbar, where buttonID is the index of
     *   the button's object initializer. The button will be redrawn if necessary.
     *   The button identifier can be a number (index), string (id), or object (widget or init block),
     *   as with the getButtonNumber() method.
     * 
     *  @param {number | string | object | Canvas} Button / Button identifier
     */
    open fun deselectButton(buttonID: dynamic): Unit = definedExternally
    /**
     *   Called when one of the buttons receives a double-click event
     * 
     *  @param {Button} pointer to the button in question
     *  @param {number} number of the button in question
     */
    open fun itemDoubleClick(item: Button, itemNum: Number): Unit = definedExternally
    /**
     *   Observable, overrideable method - called when one of the Toolbar buttons is drag resized.
     * 
     * 
     *  @param {number} the index of the item that was resized
     *  @param {number} the new size of the item
     */
    open fun itemDragResized(itemNum: Number, newSize: Number): Unit = definedExternally
    companion object {
        /**
         *  Creates a new Toolbar
         * 
         *  @param typeCheckedProperties {Partial<Toolbar>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Toolbar} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Toolbar = definedExternally
    }
}