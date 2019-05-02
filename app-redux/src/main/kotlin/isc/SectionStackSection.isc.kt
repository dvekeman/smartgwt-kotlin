@file:JsQualifier("isc")
package isc

/**
 *  Section descriptor used by a SectionStack to describe a section of items which are shown
 *   or hidden together along with their associated header.
 * 
 *   A section header (see SectionStack.sectionHeaderClass) is created from this
 *   descriptor when the SectionStack is created. Any changes after creation must be made to
 *   the section header: SectionStack.getSectionHeader.
 * 
 *   Additional SectionHeader properties set on the SectionStackSection not explicitly
 *   documented, such as "iconAlign" or "prompt", are supported.
 */
open external class SectionStackSection {
    /**
     *  Identifier for the section. This can be used later in calls to SectionStack APIs such as
     *   SectionStack.expandSection and SectionStack.collapseSection. Note that if no name
     *   is specified for the section, one will be auto-generated when the section is created.
     *   This property should be a string which may be used as a valid JavaScript identifier
     *   (should start with a letter and not contain space or special characters such as "\*").
     *  @type {string}
     *  @default null
     */
    open var name: String = definedExternally
    /**
     *  Optional ID for the section. If SectionStack.useGlobalSectionIDs is true, this property will
     *   be applied to the generated SectionStackHeader widget as a standard widget ID, meaning
     *   it should be unique within a page.
     * 
     *   Backcompat Note: Section stack sections may be uniquely identified within a stack
     *   via the SectionStackSection.name attribute (introduced in Jan 2010). Prior to this,
     *   the section ID attribute was used in this way (and would not be applied to the section header
     *   as a widget ID). For backwards compatibility this is still supported: If
     *   section.name is unspecified for a section but section.ID is set,
     *   the ID will be used as a default name attribute for the section. For backwards compatibility
     *   we also disable the standard behavior of having the section.ID being applied to the generated
     *   section header (thereby avoiding the page-level uniqueness requirement) by defaulting
     *   SectionStack.useGlobalSectionIDs to false.
     *  @type {string}
     *  @default null
     */
    open var ID: String = definedExternally
    /**
     *  Custom controls to be shown on top of this section header.
     * 
     *   These controls are shown in the SectionHeader.controlsLayout.
     * 
     *   Note that this is an init-time property. If you need to dynamically change what
     *   controls are displayed to the user, we would recommend embedding the
     *   controls in a Layout or similar container.
     *   This will allow you to show/hide or add/remove members at runtime
     *   by manipulating the existing control(s) set up at init time.
     *  @type {Array<Partial<Canvas>>}
     *  @default null
     */
    open var controls: Array<dynamic> = definedExternally
    /**
     *  Title to show for the section
     *  @type {HTMLString}
     *  @default null
     */
    open var title: String = definedExternally
    /**
     *  If the title for this section header is too large for the available space, should the title be
     *   clipped?
     * 
     *   This feature is supported only in browsers that support the CSS UI text-overflow
     *   property (IE6+, Firefox 7+, Safari, Chrome, Opera 9+).
     *  @type {boolean}
     *  @default true
     */
    open var clipTitle: Boolean = definedExternally
    /**
     *  If true and the title is clipped, then a hover containing the full title of this section header
     *   is enabled.
     *  @type {boolean}
     *  @default true
     */
    open var showClippedTitleOnHover: Boolean = definedExternally
    /**
     *  List of Canvases that constitute the section. These Canvases will be shown and hidden
     *   together.
     *  @type {Array<Partial<Canvas>>}
     *  @default null
     */
    open var items: Array<dynamic> = definedExternally
    /**
     *  If true, a header will be shown for this section. If false, no header will be shown.
     *  @type {boolean}
     *  @default true
     */
    open var showHeader: Boolean = definedExternally
    /**
     *  If true, the header for this Section will be included in the page's tab
     *   order for accessibility. May also be set at the SectionStack level via
     *   SectionStack.canTabToHeaders.
     * 
     *   See accessibility.
     *  @type {boolean}
     *  @default null
     */
    open var canTabToHeader: Boolean = definedExternally
    /**
     *  Base filename of the icon that represents open and closed states. The default settings
     *   also change the icon for disabled sections, so a total of four images are required
     *   (opened, closed, Disabled_opened, Disabled_closed).
     * 
     *   Not shown if SectionStackSection.canCollapse is false.
     *  @type {SCImgURL}
     *  @default "[SKIN]SectionHeader/opener.gif"
     */
    open var icon: String = definedExternally
    /**
     *  If set to false, then the items in this section will not be resized by sectionHeader
     *   repositioning. You may also set this flag directly on any of the items in any section to
     *   cause that item to not be resizeable.
     *  @type {boolean}
     *  @default null
     */
    open var resizeable: Boolean = definedExternally
    /**
     *  If set to false, then this sectionHeader will not be able to be dragged to perform a drag
     *   reorder, if SectionStack.canReorderSections is true.
     *   You can also disable dropping other sections before this one by setting
     *   Canvas.canDropBefore to false.
     *  @type {boolean}
     *  @default null
     */
    open var canReorder: Boolean = definedExternally
    /**
     *  When explicitly set to false, disallows drop before this member in the Layout.
     *  @type {boolean}
     *  @default null
     */
    open var canDropBefore: Boolean = definedExternally
    /**
     *  Sections default to the collapsed state unless SectionStackSection.showHeader is
     *   set to false in which case they default to the expanded state. This
     *   attribute allows you to explicitly control the expand/collapse state of the
     *   section by overriding the above default behavior.
     *  @type {boolean}
     *  @default false
     */
    open var expanded: Boolean = definedExternally
    /**
     *  Sections default to the visible state. This
     *   attribute allows you to explicitly control the visible/hidden state of the
     *   section by overriding the above default behavior.
     *  @type {boolean}
     *  @default false
     */
    open var hidden: Boolean = definedExternally
    /**
     *  This attribute controls whether or not the expand/collapse UI control is shown on the
     *   header of this section. Any section can still be expanded/collapsed programmatically,
     *   regardless of this setting.
     *  @type {boolean}
     *  @default true
     */
    open var canCollapse: Boolean = definedExternally
}