@file:JsQualifier("isc")
package isc

/**
 *  A container that manages a list of sections of widgets, each with a header. Sometimes called
 *   an "Accordion".
 * 
 *   SectionStack can be configured so that only one section is visible at a time (similar to MS Outlook's
 *   left-hand Nav), or to allow multiple sections to be visible and share the available space.
 */
open external class SectionStack : VLayout {
    /**
     *  Normal Overflow settings can be used on layouts, for example, an
     *   overflow:auto Layout will scroll if sections are resized to exceed the specified size,
     *   whereas an overflow:visible Layout will grow to accommodate the resized sections.
     *  @type {Overflow}
     *  @default "hidden"
     */
    override var overflow: 
                           /**
                            *  Content that extends beyond the widget's width or height is               displayed.
                            *                 Note: To have the content be sized only by the drawn size of
                            *                 the content set the overflow to be Canvas.VISIBLE and specify
                            *                 a small size, allowing the size to expand to the size required
                            *                 by the content.
                            *                 Leaving the width / height for the widget undefined will use the
                            *                 default value of 100, and setting the size to zero may cause the
                            *                 widget not to draw.
                            *  Content that extends beyond the widget's width or height is               clipped (hidden).
                            *  Horizontal and/or vertical scrollbars are displayed only if               necessary. Content that extends beyond the remaining visible
                            *                 area is clipped.
                            *  Horizontal and vertical scrollbars are always drawn inside the               widget. Content that extends beyond the remaining visible area
                            *                 is clipped, and can be accessed via scrolling.
                            *  Clip horizontally but extend the canvas's clip region               vertically if necessary. Note: only supported for
                            *                 specific widget subclasses.
                            *  Clip vertically but extend the canvas's clip region               horizontally if necessary. Note: only supported
                            *                 for specific widget subclasses.
                            */
                           String /* visible |  hidden |  auto |  scroll |  clip-h |  clip-v */ = definedExternally
    /**
     *  Default CSS style for the SectionStack as a whole.
     *  @type {CSSStyleName}
     *  @default "sectionStack"
     */
    override var styleName: String = definedExternally
    /**
     *  Widget to use for section headers.
     * 
     *   Must be a subclass of either ImgSectionHeader or SectionHeader. The
     *   default class used depends on the skin; SectionHeader is the simpler and
     *   lighter-weight class and uses CSS styling rather than image-based styling, and is
     *   recommended for most use cases.
     * 
     * 
     * 
     *   Very advanced developers can use the following information to create custom header
     *   classes.
     * 
     *   The SectionStack will instantiate this class, giving the following properties on init:
     * 
     * 
     *  - layout: the SectionStack
     * 
     *  - expanded: true or false
     * 
     *  - hidden: true or false
     * 
     *  - title: section title
     * 
     *   Whenever the section is hidden or shown, sectionHeader.setExpanded(true|false) will be
     *   called if implemented.
     * 
     * 
     *   If you override event handlers on your custom SectionHeader or radically change it's
     *   structure such that the default event handling no longer works, you can call
     *   SectionStack.sectionHeaderClick to replicate the built-in expand/collapse
     *   handling for clicking a section header.
     *  @type {string}
     *  @default "SectionHeader"
     */
    open var sectionHeaderClass: String = definedExternally
    /**
     *  Height of headers for sections.
     *  @type {number}
     *  @default "20"
     */
    open var headerHeight: Number = definedExternally
    /**
     *  List of sections of components managed by this SectionStack.
     *  @type {Array<Partial<SectionStackSection>>}
     *  @default null
     */
    open var sections: Array<dynamic> = definedExternally
    /**
     *  Whether sections can be drag resized by the user dragging the section header.
     * 
     *   Note that, with canResizeSections:true, not all sections can be resized:
     *   sections that contain only Button.autoFit components or that are
     *   marked with SectionStackSection.resizeable will not be
     *   resizeable.
     *  @type {boolean}
     *  @default true
     */
    open var canResizeSections: Boolean = definedExternally
    /**
     *  SectionStacks provide the same default implementation of drag and drop interactions as
     *   Layout.canDropComponents, except that members are added as items into
     *   the section over which they're dropped.
     * 
     *   If you want to completely suppress the builtin drag and drop logic, but still receive drag
     *   and drop events for your own custom implementation, set Canvas.canAcceptDrop to
     *   true and canDropComponents to false on your
     *   SectionStack.
     *  @type {boolean}
     *  @default true
     */
    override var canDropComponents: Boolean = definedExternally
    /**
     *  Whether sections can be drag reordered by the user dragging the section header.
     * 
     *   Note that, with canReorderSections:true, sections with
     *   SectionStackSection.canReorder will not be
     *   able to be drag-reordered (though their index may still be changed by dropping other
     *   sections above or below them in the section stack).
     *  @type {boolean}
     *  @default false
     */
    open var canReorderSections: Boolean = definedExternally
    /**
     *  If true, the headers for the sections (if shown) will be included in the page's tab
     *   order for accessibility.
     *   May be overridden at the Section level via SectionStackSection.canTabToHeader
     * 
     *   If unset, section headers will be focusable if isc.setScreenReaderMode has been called.
     *   See accessibility.
     *  @type {boolean}
     *  @default null
     */
    open var canTabToHeaders: Boolean = definedExternally
    /**
     *  If an expanded or shown section expands past the current viewport and this property is
     *   true, then the viewport will auto-scroll to fit as much of the section content into the
     *   viewport without scrolling the top of the section out of the viewport.
     *  @type {boolean}
     *  @default true
     */
    open var scrollSectionIntoView: Boolean = definedExternally
    /**
     *  Should any specified SectionStackSection.ID be applied to the generated SectionHeader widget
     *   for the section as a widget ID? If set to false, SectionStackSection.ID will behave as a synonym for
     *   SectionStackSection.name.
     *  @type {boolean}
     *  @default false
     */
    open var useGlobalSectionIDs: Boolean = definedExternally
    /**
     *  If true, sections are animated during expand/collapse and addition/removal of
     *   SectionItems is likewise animated.
     *  @type {boolean}
     *  @default null
     */
    open var animateSections: Boolean = definedExternally
    /**
     *  Whether multiple sections can be expanded.
     *  @type {VisibilityMode}
     *  @default "mutex"
     */
    open var visibilityMode: 
                             /**
                              *  Only one section can be expanded at a time.
                              *  Multiple sections can be expanded at the same time, and will share space.
                              */
                             String /* mutex |  multiple */ = definedExternally
    /**
     *  In SectionStack.visibilityMode
     *   "mutex",
     *   whether to allow the last remaining expanded section to be collapsed. If false, collapsing the
     *   last open section will open the next one (wrapping around at the end).
     *  @type {boolean}
     *  @default true
     */
    open var canCollapseAll: Boolean = definedExternally
    /**
     *  Size, in pixels, of indentation of all member items. Items will be offset
     *   and reduced in width by this amount. Overridden by
     *   SectionStack.itemStartIndent or SectionStack.itemEndIndent.
     *   Setting itemIndent is equivalent to setting itemStartIndent to the same amount
     *   and itemEndIndent to 0.
     *  @type {number}
     *  @default "0"
     */
    open var itemIndent: Number = definedExternally
    /**
     *  Size, in pixels, of indentation of all member items relative to the start of
     *   the alignment axis. For instance, for left-aligned members,
     *   itemStartIndent specifies indentation for every item from the left side of the
     *   section stack. Overrides SectionStack.itemIndent.
     *  @type {number}
     *  @default undefined
     */
    open var itemStartIndent: Number = definedExternally
    /**
     *  Size, in pixels, of indentation of all member items relative to the end of
     *   the alignment axis. For instance, for left-aligned members,
     *   itemStartIndent specifies indentation for every item from the right side of the
     *   section stack.
     *  @type {number}
     *  @default undefined
     */
    open var itemEndIndent: Number = definedExternally
    /**
     *  Whether to show the Expand/Collapse controls in the headers of sections. If false, hides
     *   the expand/collapse controls and, instead, treats a click anywhere on the header as if
     *   it were a click on the expand control.
     *  @type {boolean}
     *  @default true
     */
    open var showExpandControls: Boolean = definedExternally
    /**
     *  When AutoTest.getElement is used to parse locator strings generated by
     *   AutoTest.getLocator, how should sections within this stack be
     *   identified? By default if a section has a specified
     *   SectionStackSection.name this will always be used. For
     *   sections with no name, the following options are available:
     * 
     * 
     *  - "title" use the title as an identifier
     * 
     *  - "index" use the index of the section in the sections array as an identifier
     * 
     * 
     *   If unset, and the section has no specified name, default behavior is to
     *   identify by title (if available), otherwise by index.
     *  @type {LocatorStrategy}
     *  @default null
     */
    open var locateSectionsBy: 
                               /**
                                *  Match by name if possible.
                                *  Match by title if possible.
                                *  Match by index
                                */
                               String /* name |  title |  index */ = definedExternally
    /**
     *  LocatorTypeStrategy to use when finding Sections within this section Stack.
     *  @type {LocatorTypeStrategy}
     *  @default null
     */
    open var locateSectionsType: 
                                 /**
                                  *  Match by class if possible
                                  *  Ignore specific class and match by the SmartClient framework superclass.
                                  *  Ignore class altogether and attempt to match by role
                                  *  Don't attempt to compare type in any way
                                  */
                                 String /* Class |  scClass |  role |  none */ = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "SectionStackEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
    /**
     *   Setter for SectionStack.visibilityMode.
     * 
     *  @param {VisibilityMode} new visibilityMode setting. If this is "mutex" then all but the first expanded section is collapsed.
     */
    open fun setVisibilityMode(newVisibilityMode: 
                                                  /**
                                                   *  Only one section can be expanded at a time.
                                                   *  Multiple sections can be expanded at the same time, and will share space.
                                                   */
                                                  String /* mutex |  multiple */): Unit = definedExternally
    /**
     *   Add a canvas as an item to a section.
     * 
     *  @param {string | number} ID or index of the section to add item to
     *  @param {Canvas} Item to insert into the section
     *  @param {number} Index into section to insert item
     */
    open fun addItem(section: dynamic, item: Canvas, index: Number): Unit = definedExternally
    /**
     *   Remove an item from a section.
     * 
     *  @param {string | number} ID or index of the section to remove item from
     *  @param {Canvas} Item to remove
     */
    open fun removeItem(section: dynamic, item: Canvas): Unit = definedExternally
    /**
     *   Sets a new list of canvii as items into the specified section by removing the existing
     *   items, then adding the new ones. Initial items for a section should be specified using
     *   the property SectionStackSection.items.
     * 
     *  @param {string | number} ID or index of the section to remove item from
     *  @param {Array<Partial<Canvas>>} new items to add
     */
    open fun setItems(section: dynamic, items: Array<dynamic>): Unit = definedExternally
    /**
     *   Set arbitrary properties for a particular section in this SectionStack. Properties will
     *   be applied to the sectionHeader for the section.
     * 
     *   Note that where APIs exist to explicitly manipulate section properties these should be
     *   used in preference to this method. For example, to add or remove items in a section use
     *   SectionStack.addItem or SectionStack.removeItem. To change the title of
     *   a section, use SectionStack.setSectionTitle.
     * 
     *   Also note that to modify properties of items within a section, call
     *   the appropriate setter methods directly on the item you want to modify.
     * 
     * 
     *  @param {string | Integer} ID or index of the section to modify
     *  @param {SectionStackSection} properties to apply to the section.
     */
    open fun setSectionProperties(section: dynamic, properties: SectionStackSection): Unit = definedExternally
    /**
     * 
     *   Add a section to the SectionStack.
     * 
     * 
     *  @param {SectionStackSection | Array<Partial<SectionStackSection>>} Initialization block         for the section or a list of initialization blocks to add.
     *  @param {number=} index for the new section(s) (if not specified, the section           will be added at the end of the SectionStack).
     */
    open fun addSection(sections: dynamic, position: Number?): Unit = definedExternally
    /**
     * 
     *   Remove a section or set of sections from the SectionStack. The removed sections' header
     *   and items (if any) are automatically destroyed.
     * 
     * 
     *  @param {Integer | string | Array<Partial<Integer>> | Array<Partial<string>>} Section(s) to remove.         For this parameter, you can pass the position of the section in the          SectionStack, the name of the section, or a List of          section names or indices.
     */
    open fun removeSection(sections: dynamic): Unit = definedExternally
    /**
     * 
     *   Returns a list of all SectionStackSection.name in the order in which
     *   they appear in the SectionStack.
     * 
     * 
     */
    open fun getSectionNames(): List = definedExternally
    /**
     * 
     *   Returns a list of all SectionStackSection.name in the order in which
     *   they appear in the SectionStack.
     * 
     * 
     *  @deprecated \* in favor of SectionStack.getSectionNames.
     */
    open fun getSections(): List = definedExternally
    /**
     * 
     *   Reorder the sections by shifting the specified section to a new position
     * 
     * 
     *  @param {Integer | string} Section to move. You can pass the position            of the section in the SectionStack or the name of the section.
     *  @param {number} new position index for the section.
     *  @deprecated \* As of SmartClient version 5.5, use SectionStack.moveSection.
     */
    open fun reorderSection(section: dynamic, position: Number): Unit = definedExternally
    /**
     * 
     *   Moves the specified section(s) to a new position in the SectionStack order. If you pass
     *   in multiple sections, then each section will be moved to newPosition in the
     *   order specified by the sections argument.
     * 
     * 
     *  @param {Integer | string | Array<Partial<Integer>> | Array<Partial<string>>} Section(s) to move.         For this parameter, you can pass the position of the section in the          SectionStack, the name of the section, or a List of section names/positions.
     *  @param {Integer} new position index for the section(s).
     */
    open fun moveSection(sections: dynamic, position: Number): Unit = definedExternally
    /**
     * 
     *   Shows a section or sections. This includes the section header and its items. If the
     *   section is collapsed, only the header is shown. If the section is expanded, the section
     *   header and all items are shown.
     * 
     * 
     *  @param {Integer | string | Array<Partial<Integer>> | Array<Partial<string>>} Section(s) to show. For this parameter, you can pass the position            of the section in the SectionStack, the name of the section, or a            List of section names / positions.
     *  @param {ShowSectionCallback=} callback to fire when the sections have been shown.
     */
    open fun showSection(sections: dynamic, callback: (() -> Unit?)): Unit = definedExternally
    /**
     * 
     *   Expands a section or sections. This action shows all the items assigned to the section.
     *   If the section is currently hidden, it is shown first and then expanded. Calling this
     *   method is equivalent to the user clicking on the SectionHeader of a collapsed section.
     *   This method is called when the user clicks on SectionHeaders
     *   to expand / collapse sections and so may be overridden to act as a notification method
     *   for the user expanding or collapsing sections.
     * 
     * 
     *  @param {Integer | string | Array<Partial<Integer>> | Array<Partial<string>>} Section(s) to expand. For this parameter, you can pass the position            of the section in the SectionStack, the name of the section, or a            List of section names/positions.
     *  @param {ExpandSectionCallback=} callback to fire when the section has been expanded.
     */
    open fun expandSection(sections: dynamic, callback: (() -> Unit?)): Unit = definedExternally
    /**
     * 
     *   Search for a section that contains passed item.
     * 
     * 
     *  @param {Canvas} item to show
     */
    open fun sectionForItem(item: Canvas): SectionStackSection = definedExternally
    /**
     *   Reveals the child Canvas passed in by expanding the section containing that child if it
     *   is currently collapsed. If no section in this sectionStack contains the passed-in Canvas,
     *   this method has no effect
     * 
     * 
     *  @param {GlobalId | Canvas} the child Canvas to reveal, or its global ID
     */
    override fun revealChild(child: dynamic): Unit = definedExternally
    /**
     * 
     *   Hides a section or sections. This includes the section header and its items. The space
     *   vacated by this action is reassigned to the nearest visible section item above this
     *   section. If there are no visible section items above this section, the space is
     *   reassigned to the nearest visible section item below this section.
     * 
     * 
     *  @param {Integer | string | Array<Partial<Integer>> | Array<Partial<string>>} Section(s) to hide. For this parameter, you can pass the position            of the section in the SectionStack, the name of the section, or a            List of section names / positions.
     *  @param {HideSectionCallback=} to fire when the section has been hidden
     */
    open fun hideSection(sections: dynamic, callback: (() -> Unit?)): Unit = definedExternally
    /**
     * 
     *   Collapse a section or sections. This action hides all the items assigned to the
     *   section. Calling this method is equivalent to the user clicking on the SectionHeader of
     *   an expanded section.
     *   This method is called when the user clicks on SectionHeaders
     *   to expand / collapse sections and so may be overridden to act as a notification method
     *   for the user expanding or collapsing sections.
     * 
     * 
     *  @param {Integer | string | Array<Partial<Integer>> | Array<Partial<string>>} Section(s) to collapse. For this parameter, you can pass the position            of the section in the SectionStack, the name of the section, or a            List of section positions / names
     *  @param {CollapseSectionCallback=} callback to fire when the section has been collapsed
     */
    open fun collapseSection(sections: dynamic, callback: (() -> Unit?)): Unit = definedExternally
    /**
     * 
     *   Returns true if the specified section is visible, false if it is not. A section is
     *   visible if it shows a header and the header is visible or if it has items and the first
     *   item is visible.
     * 
     * 
     *  @param {Integer | string} Section for which you want to obtain visibility information.            For this parameter, you can pass the position of the section in the            SectionStack, or the name of the section.
     */
    open fun sectionIsVisible(section: dynamic): Boolean = definedExternally
    /**
     * 
     *   Returns the list of currently visible sections. The list items are section names.
     * 
     * 
     */
    open fun getVisibleSections(): List = definedExternally
    /**
     * 
     *   Returns true if the specified section is expanded, false if it is collapsed.
     * 
     * 
     *  @param {Integer | string} Section for which you want to obtain information.            For this parameter, you can pass the position of the section in the            SectionStack, or the name of the section.
     */
    open fun sectionIsExpanded(section: dynamic): Boolean = definedExternally
    /**
     * 
     *   Returns the list of currently expanded sections. The list items are section IDs.
     * 
     * 
     */
    open fun getExpandedSections(): List = definedExternally
    /**
     *   Changes the title of a SectionHeader.
     * 
     * 
     *  @param {string | number} ID or index of the section whose title you want to change
     *  @param {string} new title for the SectionHeader
     */
    open fun setSectionTitle(section: dynamic, newTitle: String): Unit = definedExternally
    /**
     *   Return the SectionHeader for a section.
     * 
     *   This will be an instance of the SectionStack.sectionHeaderClass. Since different
     *   SectionStacks may use different header classes, be careful about what APIs you rely on
     *   for the section header unless you have explicitly set the
     *   sectionHeaderClass. In particular, use APIs such as
     *   SectionStack.setSectionTitle to manipulate headers indirectly wherever possible, as high
     *   performance SectionStacks designed for very large numbers of sections may cache and
     *   re-use headers or use other strategies that would make it invalid to store a pointer to
     *   a section header, assume the header is a layout member, etc.
     * 
     * 
     *  @param {string | number} ID or index of the section for which you want the header
     */
    open fun getSectionHeader(section: dynamic): SectionHeader = definedExternally
    /**
     * 
     *   Returns the position of the specified section in the SectionStack. The numbering is
     *   zero-based.
     * 
     * 
     *  @param {string} name of a section for which you want to obtain the position.
     */
    open fun getSectionNumber(sectionName: String): Number = definedExternally
    /**
     *   Method intended to be called by the sectionHeader when it is clicked on.
     * 
     * 
     *  @param {Canvas} the sectionHeader clicked on
     */
    open fun sectionHeaderClick(sectionHeader: Canvas): Unit = definedExternally
    companion object {
        /**
         *  Creates a new SectionStack
         * 
         *  @param typeCheckedProperties {Partial<SectionStack>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {SectionStack} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): SectionStack = definedExternally
    }
}