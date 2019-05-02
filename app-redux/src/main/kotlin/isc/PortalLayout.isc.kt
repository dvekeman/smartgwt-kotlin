@file:JsQualifier("isc")
package isc

/**
 *  A PortalLayout is a special subclass of Layout designed to display Portlet windows.
 *   A PortalLayout displays Portlets in columns and supports drag-drop interaction for moving
 *   Portlets around within the PortalLayout. Portlets may be drag-reordered within columns, dragged
 *   into other columns, or dragged next to other Portlets to sit next to them horizontally
 *   within a column.
 */
open external class PortalLayout : Layout {
    /**
     *  Controls how the PortalLayout reacts when column widths or Portlet widths
     *   overflow the width of the PortalLayout. By default, the PortalLayout scrolls
     *   when necessary. You can also use overflow: visible or overflow: hidden, with the
     *   usual results -- see PortalLayout.canResizePortlets for a further explanation of column widths.
     * 
     *   Note that overflowing height is also affected by PortalLayout.columnOverflow.
     *   By default, each column will scroll individually -- you can change
     *   columnOverflow to "auto" to scroll the whole PortalLayout instead.
     *  @type {Overflow}
     *  @default "auto"
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
     *  Controls the Canvas.overflow setting for each column. If set to "auto" (the
     *   default) then each column will scroll individually (if its Portlet overflow
     *   the column height). You can also use "hidden" to clip overflowing heights, or "visible" to
     *   show the overflow. The effect of "visible" will depend on the setting for PortalLayout.overflow
     *   -- by default, the PortalLayout as a whole will scroll when necessary.
     *  @type {Overflow}
     *  @default "auto"
     */
    open var columnOverflow: 
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
     *  Controls whether the PortalLayout will stretch column widths, if needed to accommodate the
     *   width of Portlet. If set, columns will overflow their widths in order to accomodate
     *   the widths of their Portlets.
     * 
     *   With the default setting of Overflow: auto, the PortalLayout as a whole will scroll
     *   horizontally if needed. Depending on the setting of PortalLayout.canShrinkColumnWidths,
     *   other columns may shrink to avoid overflow on the PortalLayout as a whole.
     * 
     *   If canStretchColumnWidths is turned off, then individual rows will scroll
     *   horizontally in order to accommodate Portlets that are wider than their column width allows.
     *  @type {boolean}
     *  @default true
     */
    open var canStretchColumnWidths: Boolean = definedExternally
    /**
     *  Controls whether the PortalLayout will shrink column widths to avoid overflowing the PortalLayout
     *   horizontally. If the PortalLayout would otherwise overflow its width, it will check each column
     *   to see whether it is wider than necessary to accommodate its Portlet. If so,
     *   the column may shrink to avoid having to scroll the PortalLayout.
     *  @type {boolean}
     *  @default true
     */
    open var canShrinkColumnWidths: Boolean = definedExternally
    /**
     *  When PortalLayout.canStretchColumnWidths, should we stretch all column widths proportionally,
     *   or just stretch the columns that need extra width?
     * 
     *   Note that this implies turning off PortalLayout.canShrinkColumnWidths.
     *  @type {boolean}
     *  @default false
     */
    open var stretchColumnWidthsProportionally: Boolean = definedExternally
    /**
     *  Controls whether the last column will be stretched to fill the PortalLayout's width,
     *   or left at its specified width.
     *  @type {boolean}
     *  @default true
     */
    open var preventUnderflow: Boolean = definedExternally
    /**
     *  Controls whether the last Portlet in a column will be stretched to fill the column's height,
     *   or left at its specified height.
     *  @type {boolean}
     *  @default true
     */
    open var preventColumnUnderflow: Boolean = definedExternally
    /**
     *  Controls whether the last Portlet in a row will be stretched to fill the row's width,
     *   or left at its specified width.
     *  @type {boolean}
     *  @default true
     */
    open var preventRowUnderflow: Boolean = definedExternally
    /**
     *  A convenience attribute which you can use to populate a PortalLayout with Portlet
     *   on initialization. After initialization, use PortalLayout.addPortlet or drag-and-drop to add
     *   Portlets, and PortalLayout.getPortlets or PortalLayout.getPortletArray
     *   to get Portlets.
     * 
     *   To create one column, you can provide an array of Portlets.
     * 
     *   To create multiple columns, provide an array of arrays (where the first level represents columns,
     *   and the second represents Portlets).
     * 
     *   To put multiple portlets in the same row, provide a third level to the array.
     * 
     *   Note that PortalLayout.numColumns is ignored if you provide the portlets attribute, since
     *   the array will indicate how many columns to create. You can provide an empty second-level
     *   array to create a blank column, if needed.
     *  @type {Array<Partial<Portlet>>}
     *  @default null
     */
    open var portlets: Array<dynamic> = definedExternally
    /**
     *  Initial number of columns to show in this PortalLayout. Note that after initialization
     *   columns should be added / removed via PortalLayout.addColumn and PortalLayout.removeColumn.
     *   numColumns is ignored if you initialize the PortalLayout.portlets attribute, since the portlets
     *   attribute will imply how many columns to create.
     *  @type {Integer}
     *  @default "2"
     */
    open var numColumns: Number = definedExternally
    /**
     *  Should a menu be shown within each column with options to add / remove columns?
     *  @type {boolean}
     *  @default true
     */
    open var showColumnMenus: Boolean = definedExternally
    /**
     *  Border to show around columns in this PortalLayout
     *  @type {string}
     *  @default "1px solid gray"
     */
    open var columnBorder: String = definedExternally
    /**
     *  Are columns in this PortalLayout drag-resizeable?
     * 
     *   Note that the displayed width of a column will automatically shrink and stretch
     *   to accomodate the width of Portlet -- see PortalLayout.canStretchColumnWidths
     *   and PortalLayout.canShrinkColumnWidths for an explanation.
     *   This setting affects the intrinsic width of a column --
     *   that is, the width it will try to return to when not necessary to stretch or shrink
     *   to accomodate Portlet widths.
     *  @type {boolean}
     *  @default true
     */
    open var canResizeColumns: Boolean = definedExternally
    /**
     *  Should vertical drag-resize of portlets within columns be allowed?
     *  @deprecated \* Use PortalLayout.canResizePortlets instead.
     *  @type {boolean}
     *  @default false
     */
    open var canResizeRows: Boolean = definedExternally
    /**
     *  Should the height and width of Portlet be drag-resizable?
     * 
     *   Note that changing the height of a Portlet will change the height of all
     *   the Portlets in the same row to match.
     * 
     *   If the height of Portlets causes a column to overflow, that column will scroll vertically
     *   (independent of other columns), depending on the PortalLayout.columnOverflow setting.
     * 
     *   Changing the width of a Portlet will potentially cause columns to stretch
     *   and shrink their displayed widths in order to accomodate the Portlets,
     *   depending on the value of PortalLayout.canStretchColumnWidths and
     *   PortalLayout.canShrinkColumnWidths.
     * 
     *   However, the instrinsic width of the columns will remain the same,
     *   so that the columns will resume their former widths when no longer necessary
     *   to stretch or shrink to accomodate the widths of Portlets.
     *   To allow drag-resizing of the intrinsic width of columns, see PortalLayout.canResizeColumns.
     * 
     *   The net effect is that (by default) PortalLayouts behave like layouts when Portlet sizes do
     *   not cause overflow, but behave more like stacks when overflow occurs.
     *  @type {boolean}
     *  @default false
     */
    open var canResizePortlets: Boolean = definedExternally
    /**
     *  The Canvas.dropTypes to be applied when dropping Portlet
     *   on this PortalLayout, or when dropping other components to be auto-wrapped in
     *   a Portlet. If you set this, then you will need to set an equivalent Canvas.dragType on
     *   anything to be dragged into this PortalLayout (including Portlet).
     * 
     *   As a convenience, Portlet.dragType defaults to "Portlet". Thus, if you want
     *   to allow Portlet to be dropped on this PortalLayout, but disable
     *   auto-wrapping of other components, you can set portletDropTypes to
     *   ["Portlet"].
     * 
     *   If you want to allow some Portlet to be dropped on this PortalLayout but
     *   not others, then set a custom Portlet.dragType for the Portlet, and
     *   set portletDropTypes to match.
     * 
     *   If you want to have different dropTypes for PortalLayout.row and
     *   PortalLayout.rowLayout, you can specify dropType on the PortalLayout.row
     *   or PortalLayout.rowLayout autochildren instead.
     * 
     *   For more control over what can be dropped, you can also implement
     *   PortalLayout.willAcceptPortletDrop.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    open var portletDropTypes: Array<dynamic> = definedExternally
    /**
     *  dropTypes is set to ["PortalColumn"]
     *   in order to allow the dragging of columns within the PortalLayout.
     *   To control dropTypes when Portlet or other components are dragged
     *   into the PortalLayout, use PortalLayout.portletDropTypes instead.
     *  @type {Array<Partial<string>>}
     *  @default "["PortalColumn"]"
     */
    override var dropTypes: dynamic = definedExternally
    /**
     *  Automatically generated horizontal Layout used to create rows of Portlet via
     *   Class.createAutoChild. Since this is an AutoChild, you can use
     *   rowDefaults and rowProperties to customize the rows.
     * 
     *   Rows are created inside PortalLayout.rowLayout, which in turn are inside PortalLayout.column.
     *  @type {Layout}
     *  @default null
     */
    open var row: Layout = definedExternally
    /**
     *  Automatically generated vertical Layout used to create columns of Portlet via
     *   Class.createAutoChild. Since this is an AutoChild, you can use
     *   rowLayoutDefaults and rowLayoutProperties to customize the layout used to contain the rows.
     * 
     *   The rowLayout is the actual container for PortalLayout.row of Portlet. See PortalLayout.column for
     *   the column as a whole, which may include a menu as well (depending on PortalLayout.showColumnMenus).
     *   If you want to style the columns as a whole,
     *   use columnDefaults or columnProperties, but if you want to style the layout that actually contains the
     *   rows, use rowLayoutDefaults or rowLayoutProperties.
     *  @type {Layout}
     *  @default null
     */
    open var rowLayout: Layout = definedExternally
    /**
     *  Automatically generated vertical Layout used to create columns of Portlet via
     *   Class.createAutoChild. Since this is an AutoChild, you can use
     *   columnDefaults and columnProperties to customize the columns.
     * 
     *   The column includes a menu, if PortalLayout.showColumnMenus is true, and a PortalLayout.rowLayout which
     *   actually contains the PortalLayout.row. Therefore, if you want to style the columns as a whole,
     *   use columnDefaults or columnProperties, but if you want to style the layout that contains the
     *   rows, use rowLayoutDefaults or rowLayoutProperties.
     *  @type {Layout}
     *  @default null
     */
    open var column: Layout = definedExternally
    /**
     *   Sets PortalLayout.columnOverflow and updates existing columns to reflect the new setting.
     * 
     *  @param {Overflow} Overflow setting for columns
     */
    open fun setColumnOverflow(overflow: 
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
                                         String /* visible |  hidden |  auto |  scroll |  clip-h |  clip-v */): Unit = definedExternally
    /**
     *   Sets PortalLayout.canStretchColumnWidths and reflows to reflect the new setting.
     * 
     *  @param {boolean} Whether columns can stretch to accommodate Portlet widths.
     */
    open fun setCanStretchColumnWidths(canStretch: Boolean): Unit = definedExternally
    /**
     *   Sets PortalLayout.canShrinkColumnWidths and reflows to reflect the new setting.
     * 
     *  @param {boolean} Whether columns can shrink to avoid overflowing the PortalLayout's width.
     */
    open fun setCanShrinkColumnWidths(canShrink: Boolean): Unit = definedExternally
    /**
     *   Sets PortalLayout.stretchColumnWidthsProportionally and reflows to reflect the new setting.
     * 
     *  @param {boolean} Whether to stretch column widths proportionally
     */
    open fun setStretchColumnWidthsProportionally(stretchProportionally: Boolean): Unit = definedExternally
    /**
     *   Sets PortalLayout.preventUnderflow and reflows the layout to implement it.
     * 
     *  @param {boolean} Whether to stretch the last column to fill the PortalLayout's width.
     */
    open fun setPreventUnderflow(preventUnderflow: Boolean): Unit = definedExternally
    /**
     *   Sets PortalLayout.preventColumnUnderflow and reflows the layout to implement it.
     * 
     *  @param {boolean} Whether to stretch the last Portlet in a column to fill the column's height.
     */
    open fun setColumnPreventUnderflow(preventColumnUnderflow: Boolean): Unit = definedExternally
    /**
     *   Sets PortalLayout.preventRowUnderflow and reflows the layout to implement it.
     * 
     *  @param {boolean} Whether to stretch the last Portlet in a row to to fill the row's width.
     */
    open fun setPreventRowUnderflow(preventRowUnderflow: Boolean): Unit = definedExternally
    /**
     *   Returns the current number of columns displayed in this PortalLayout.
     * 
     */
    open fun getNumColumns(): Number = definedExternally
    /**
     *   Sets PortalLayout.showColumnMenus and updates existing columns to reflect the new setting.
     * 
     *  @param {boolean} Whether to show column menus
     */
    open fun setShowColumnMenus(showMenus: Boolean): Unit = definedExternally
    /**
     *   Sets the columnBorder for to the specified value and updates any drawn columns to reflect
     *   this.
     * 
     *  @param {string} New border to show around columns
     */
    open fun setColumnBorder(columnBorder: String): Unit = definedExternally
    /**
     *   Set whether columns in this portalLayout are drag-resizable, and update any
     *   drawn columns to reflect this.
     * 
     *  @param {boolean} Whether columns are drag-resizable
     */
    open fun setCanResizeColumns(canResize: Boolean): Unit = definedExternally
    /**
     *   Set whether vertical drag-resize of portlets within columns is allowed, and
     *   update any drawn columns to reflect this.
     * 
     *  @param {boolean} Whether drag-resize of portlets within columns is allowed
     *  @deprecated \* Use PortalLayout.setCanResizePortlets instead.
     */
    open fun setCanResizeRows(canResize: Boolean): Unit = definedExternally
    /**
     *   Set whether the height and width of Portlet should be drag-resizable, and
     *   update any drawn Portlets to reflect this.
     * 
     *  @param {boolean} Whether drag-resizing the height and width of portlets is allowed
     */
    open fun setCanResizePortlets(canResize: Boolean): Unit = definedExternally
    /**
     *   Sets the PortalLayout.portletDropTypes to be applied when dropping Portlet
     *   on this PortalLayout, or when dropping other components to be auto-wrapped in
     *   a Portlet.
     * 
     * 
     *  @param {Array<Partial<string>>} dropTypes to apply when dropping Portlet
     */
    open fun setPortletDropTypes(portletDropTypes: Array<dynamic>): Unit = definedExternally
    /**
     *   Returns true if the dragged Portlet, or other component, can be dropped onto
     *   this PortalLayout (other components would be auto-wrapped in a Portlet).
     * 
     *   The default implementation acts like Canvas.willAcceptDrop, except applying
     *   PortalLayout.portletDropTypes rather than PortalLayout.dropTypes.
     *   You can subclass to apply other (or additional) criteria
     * 
     * 
     *  @param {Canvas} The Portlet, or other component, being dragged
     *  @param {Integer} indicates which column the portlet would be dropped on.
     *  @param {Integer} indicates the row number being dropped on.
     *  @param {Integer=} Drop position within an existing row. If the dropPosition  is null, then that means that a new row will be created.
     */
    open fun willAcceptPortletDrop(dragTarget: Canvas, colNum: Number, rowNum: Number, dropPosition: Number?): Boolean = definedExternally
    /**
     *   This method is called when the user drops components into the rows or columns of this
     *   PortalLayout.
     * 
     *   Overriding this method allows you to modify drop behaviour when creating or reordering
     *   portlets via drag & drop. You can return the dragTarget for the standard behavior,
     *   or null to cancel the drop.
     * 
     *   Otherwise, return the component you want to be dropped (as for Layout.getDropComponent).
     *   You will generally want to return a Portlet or subclass. However, you can return
     *   any Canvas, and it will automatically be wrapped in a Portlet if necessary.
     * 
     *  @param {Canvas} drag target
     *  @param {Integer} indicates which column the portlet is being dropped on.
     *  @param {Integer} indicates the row number being dropped on.
     *  @param {Integer=} Drop position within an existing row. If the dropPosition  is null, then that means that a new row will be created.
     */
    open fun getDropPortlet(dragTarget: Canvas, colNum: Number, rowNum: Number, dropPosition: Number?): Canvas = definedExternally
    /**
     *   Adds a new portal column to this layout at the specified position
     * 
     *  @param {Integer} target position for the new column
     */
    open fun addColumn(index: Number): Unit = definedExternally
    /**
     *   Removes the specified column from this layout.
     *   All portlets displayed within this column will be destroyed when the column is removed.
     * 
     *  @param {Integer} column number to remove
     */
    open fun removeColumn(index: Number): Unit = definedExternally
    /**
     *   Returns a flat array of all the Portlet in this PortalLayout.
     * 
     */
    open fun getPortlets(): Array<dynamic> = definedExternally
    /**
     *   Returns a multi-level array of the Portlet in this PortalLayout,
     *   where the first level corresponds to columns, the second to rows, and the third
     *   to Portlets within rows.
     * 
     */
    open fun getPortletArray(): Array<dynamic> = definedExternally
    /**
     *   Gets the position of the Portlet within this PortalLayout. Returns null
     *   if the Portlet is not in this PortalLayout.
     * 
     *  @param {Portlet} the Portlet for which to get the position
     */
    open fun getPortalPosition(portlet: Portlet): PortalPosition = definedExternally
    /**
     *   Adds a Portlet instance to this portalLayout in the specified position.
     *   PortalLayouts use columns to manage the positions of their portlets.
     *   Each column is a vertical stack containing a number of rows. By default
     *   a portlet within a column will take up the entire width of the column (so there is
     *   one portlet per row within the column), but developers may also place
     *   more than one portlet side-by-side on a row within a column - see the
     *   positionInExistingRow parameter.
     * 
     * 
     *  @param {Portlet} Portlet to add to this layout.
     *  @param {Integer=} Column in which the Portlet should be added. If unspecified, portlet will be added to the first column. If specified, but the  specified column does not exist, a column is automatically added at the specified  colNum index.
     *  @param {Integer=} Row-position within the specified column for this portlet. If unspecified defaults to zero - the portlet will be added to the top of the column.  By default a new row will be added to the column for the portlet. Use the  positionInExistingRow parameter to add the portlet to an existing  row.
     *  @param {Integer=} Position within an existing row in the column. If this parameter is passed, this portlet will be added to the  existing row at rowWithinCol, at the specified position.  This allows developers to place multiple portlets side by side on a row within  the column.  If omitted a new row will be created in the column for the portlet.
     */
    open fun addPortlet(portlet: Portlet, colNum: Number?, rowWithinCol: Number?, positionInExistingRow: Number?): Unit = definedExternally
    /**
     *   Sets the width of a column in the PortalLayout.
     * 
     *   Note that this sets the intrinsic width of the column. Columns may also
     *   automatically stretch and shrink to accomodate the width of
     *   Portlet.
     * 
     *  @param {Integer} Which column's width to set.
     *  @param {number | string} How wide to make the column
     */
    open fun setColumnWidth(colNumber: Number, width: dynamic): Unit = definedExternally
    /**
     *   Gets the width of a column in the PortalLayout.
     * 
     *  @param {Integer} Which column's width to get
     */
    open fun getColumnWidth(colNumber: Number): Number = definedExternally
    /**
     *   Removes a Portlet which is currently rendered in this PortalLayout.
     *   Portlet will not be destroyed by default - if this is desired the calling code should
     *   do this explicitly.
     * 
     *  @param {Portlet} portlet to remove
     */
    open fun removePortlet(portlet: Portlet): Unit = definedExternally
    /**
     *   Method called when a Portlet in this PortalLayout is about to be
     *   maximized. Note that this method is only called when the user explicitly
     *   clicks on the portlet's Window.showMaximizeButton --
     *   it is not called when programmatically maximizing a portlet via
     *   Window.maximize.
     * 
     *   Return false to cancel the action.
     * 
     * 
     *  @param {Portlet} the Portlet which will be maximized
     */
    open fun willMaximizePortlet(portlet: Portlet): Boolean = definedExternally
    /**
     *   Notification method called after a portlet has been maximized (whether by
     *   user action or programmatically).
     * 
     * 
     *  @param {Portlet} the Portlet which was maximized
     */
    open fun portletMaximized(portlet: Portlet): Unit = definedExternally
    /**
     *   Method called when a Portlet in this PortalLayout is about to be
     *   minimized. Note that this method is only called when the user explicitly
     *   clicks on the portlet's Window.showMinimizeButton --
     *   it is not called when programmatically minimizing a portlet via
     *   Window.minimize.
     * 
     *   Return false to cancel the action.
     * 
     * 
     *  @param {Portlet} the Portlet which will be minimized
     */
    open fun willMinimizePortlet(portlet: Portlet): Boolean = definedExternally
    /**
     *   Notification method called after a portlet has been minimized (whether by
     *   user action or programmatically).
     * 
     * 
     *  @param {Portlet} the Portlet which was minimized
     */
    open fun portletMinimized(portlet: Portlet): Unit = definedExternally
    /**
     *   Method called when a Portlet in this PortalLayout is about to be
     *   restored to its normal place (after having been
     *   PortalLayout.portletMaximized. Note that this method is only
     *   called when the user explicitly clicks on the portlet's
     *   Window.restoreButton -- it is not called when
     *   programmatically restoring a portlet via Window.restore.
     * 
     *   Return false to cancel the action.
     * 
     * 
     *  @param {Portlet} the Portlet which will be restored
     */
    open fun willRestorePortlet(portlet: Portlet): Boolean = definedExternally
    /**
     *   Notification method called after a portlet has been restored to its normal place
     *   (after having been maximized). The method is called whether the restore is
     *   via user action or done programmatically.
     * 
     * 
     *  @param {Portlet} the Portlet which was restored
     */
    open fun portletRestored(portlet: Portlet): Unit = definedExternally
    /**
     *   Method called when a Portlet in this PortalLayout is about to be closed.
     *   This method is called before Portlet.showCloseConfirmationMessage is applied.
     *   Note that this method is called only when the user explicitly closes a Portlet.
     *   It is not called when programmatically removing a Portlet via PortalLayout.removePortlet.
     * 
     *   Return false to cancel the action.
     * 
     * 
     *  @param {Portlet} the Portlet which will be closed
     */
    open fun willClosePortlet(portlet: Portlet): Boolean = definedExternally
    /**
     *   Fires at initialization if the PortalLayout has any initial
     *   Portlet, and then fires whenever portlets are added,
     *   removed or reordered.
     * 
     * 
     */
    open fun portletsChanged(): Unit = definedExternally
    /**
     *   Fires when Portlet or columns in this PortalLayout are resized.
     *   Note that this fires on a short delay -- otherwise, it would fire multiple times
     *   for each change, since most portlet size changes will affect multiple portlets.
     *   Does not fire when a portlet is PortalLayout.portletMaximized or
     *   PortalLayout.portletRestored.
     * 
     */
    open fun portletsResized(): Unit = definedExternally
    companion object {
        /**
         *  Creates a new PortalLayout
         * 
         *  @param typeCheckedProperties {Partial<PortalLayout>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {PortalLayout} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): PortalLayout = definedExternally
    }
}