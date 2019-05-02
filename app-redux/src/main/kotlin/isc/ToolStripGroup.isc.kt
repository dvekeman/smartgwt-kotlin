@file:JsQualifier("isc")
package isc

/**
 *  A widget that groups other controls for use in ToolStrip.
 */
open external class ToolStripGroup : VLayout {
    /**
     *  CSS class applied to this ToolStripGroup.
     *  @type {CSSStyleName}
     *  @default "toolStripGroup"
     */
    override var styleName: String = definedExternally
    /**
     *  The array of controls to show in this group.
     *  @type {Array<Partial<Canvas>>}
     *  @default null
     */
    open var controls: Array<dynamic> = definedExternally
    /**
     *  HLayout autoChild that houses the ToolStripGroup.label
     *   in which the ToolStripGroup.title is displayed.
     * 
     *   This can be customized via the standard AutoChild pattern.
     *  @type {HLayout}
     *  @default null
     */
    open var labelLayout: HLayout = definedExternally
    /**
     *  SmartClient class for the ToolStripGroup.label AutoChild.
     *  @type {string}
     *  @default "Label"
     */
    open var labelConstructor: String = definedExternally
    /**
     *  AutoChild Label used to display the
     *   ToolStripGroup.title for this group.
     * 
     *   Can be customized via the standard AutoChild pattern, and various
     *   convenience APIs exist for configuring it after initial draw: see
     *   ToolStripGroup.setShowTitle,
     *   ToolStripGroup.setTitle,
     *   ToolStripGroup.setTitleAlign,
     *   ToolStripGroup.setTitleHeight,
     *   ToolStripGroup.setTitleOrientation and
     *   ToolStripGroup.setTitleStyle.
     *  @type {Label}
     *  @default null
     */
    open var label: Label = definedExternally
    /**
     *  Controls the horizontal alignment of the group's
     *   ToolStripGroup.title, within its
     *   ToolStripGroup.label. Setting this
     *   attribute overrides the default specified by
     *   ToolStrip.groupTitleAlign on the containing
     *   ToolStrip.
     *  @type {Alignment}
     *  @default "center"
     */
    open var titleAlign: 
                         /**
                          *  Center within container.
                          *  Stick to left side of container.
                          *  Stick to right side of container.
                          */
                         String /* center |  left |  right */ = definedExternally
    /**
     *  CSS class applied to the ToolStripGroup.label in this group.
     *  @type {CSSStyleName}
     *  @default "toolStripGroupTitle"
     */
    open var titleStyle: String = definedExternally
    /**
     *  By default, ToolStripGroups are assigned a minimum width that allows the entire title
     *   to be visible. To prevent this bahavior and have group-titles cut off when they're
     *   wider than the buttons they contain, set this attribute to false
     *  @type {boolean}
     *  @default true
     */
    open var autoSizeToTitle: Boolean = definedExternally
    /**
     *  Controls the ToolStripGroup.titleOrientation of
     *   this group's ToolStripGroup.label. Setting this
     *   attribute overrides the default specified by
     *   ToolStrip.groupTitleAlign on the containing
     *   ToolStrip.
     *  @type {VerticalAlignment}
     *  @default "top"
     */
    open var titleOrientation: 
                               /**
                                *  At the top of the container
                                *  Center within container.
                                *  At the bottom of the container
                                */
                               String /* top |  center |  bottom */ = definedExternally
    /**
     *  AutoChild properties for fine customization of the
     *   ToolStripGroup.label.
     *  @deprecated \* set these properties directly via the ToolStripGroup.label
     *  @type {Label}
     *  @default null
     */
    open var titleProperties: Label = definedExternally
    /**
     *  Controls the height of the ToolStripGroup.label in this group.
     *  @type {Integer}
     *  @default "18"
     */
    open var titleHeight: Number = definedExternally
    /**
     *  HLayout autoChild that manages multiple ToolStripGroup.columnLayout
     *   containing controls.
     *  @type {HLayout}
     *  @default null
     */
    open var body: HLayout = definedExternally
    /**
     *  SmartClient class for the body.
     *  @type {string}
     *  @default "HLayout"
     */
    open var bodyConstructor: String = definedExternally
    /**
     *  AutoChild VLayouts created automatically by groups. Each manages a single column of
     *   child controls in the group. Child controls that support rowSpan may
     *   specify it in order to occupy more than one row in a single column. See
     *   ToolStripGroup.numRows for related information.
     *  @type {VLayout}
     *  @default null
     */
    open var columnLayout: VLayout = definedExternally
    /**
     *  The number of rows of controls to display in each column. Each control will take one
     *   row in a ToolStripGroup.columnLayout by default, but those that
     *   support the feature may specify rowSpan to override that.
     * 
     *   Note that settings like this, which affect the group's layout, are not applied directly
     *   if changed at runtime - a call to ToolStripGroup.reflowControls
     *   will force the group to reflow.
     *  @type {number}
     *  @default "1"
     */
    open var numRows: Number = definedExternally
    /**
     *  The height of rows in each column.
     *  @type {number}
     *  @default "26"
     */
    open var rowHeight: Number = definedExternally
    /**
     *  The title text to display in this group's
     *   ToolStripGroup.label.
     *  @type {string}
     *  @default null
     */
    open var title: String = definedExternally
    /**
     *   Sets the ToolStripGroup.title to display in this group's
     *   ToolStripGroup.label after initial draw.
     * 
     * 
     *  @param {string} The new title for this group
     */
    open fun setTitle(title: String): Unit = definedExternally
    /**
     *   This method forcibly shows or hides this group's
     *   ToolStripGroup.label after initial draw.
     * 
     * 
     *  @param {boolean} should the title be shown or hidden?
     */
    open fun setShowTitle(showTitle: Boolean): Unit = definedExternally
    /**
     *   This method forcibly sets the horizontal alignment of the
     *   ToolStripGroup.title, within the
     *   ToolStripGroup.label, after initial draw.
     * 
     * 
     *  @param {Alignment} the new alignment for the text, left or right
     */
    open fun setTitleAlign(align: 
                                  /**
                                   *  Center within container.
                                   *  Stick to left side of container.
                                   *  Stick to right side of container.
                                   */
                                  String /* center |  left |  right */): Unit = definedExternally
    /**
     *   This method forcibly sets the ToolStripGroup.titleStyle
     *   for this group's ToolStripGroup.label after initial draw.
     * 
     * 
     *  @param {CSSStyleName} the CSS class to apply to the                 ToolStripGroup.label.
     */
    open fun setTitleStyle(styleName: String): Unit = definedExternally
    /**
     *   This method forcibly sets the
     *   ToolStripGroup.titleOrientation of this group's
     *   ToolStripGroup.label after initial draw.
     * 
     * 
     *  @param {VerticalAlignment} the new orientation for the title, either bottom or top
     */
    open fun setTitleOrientation(orientation: 
                                              /**
                                               *  At the top of the container
                                               *  Center within container.
                                               *  At the bottom of the container
                                               */
                                              String /* top |  center |  bottom */): Unit = definedExternally
    /**
     *   This method forcibly sets the height of this group's
     *   ToolStripGroup.label after initial draw.
     * 
     * 
     *  @param {Integer} the new height for the ToolStripGroup.label
     */
    open fun setTitleHeight(titleHeight: Number): Unit = definedExternally
    /**
     *   Return the ToolStripGroup.columnLayout that contains the passed
     *   control.
     * 
     * 
     *  @param {Canvas} the control to find in this group
     */
    open fun getControlColumn(control: Canvas): Layout = definedExternally
    /**
     *   Clears the array of controls and then adds the passed array to this toolStripGroup,
     *   creating new ToolStripGroup.columnLayout as necessary, according to each
     *   control's rowSpan attribute and the group's
     *   ToolStripGroup.numRows attribute.
     * 
     * 
     *  @param {Array<Partial<Canvas>>} an array of widgets to add to this group
     */
    open fun setControls(controls: Array<dynamic>): Unit = definedExternally
    /**
     *   Forces this group to reflow following changes to attributes that affect layout, like
     *   ToolStripGroup.numRows.
     * 
     * 
     */
    open fun reflowControls(): Unit = definedExternally
    /**
     *   Adds an array of controls to this group, creating new
     *   ToolStripGroup.columnLayout as necessary, according to each control's
     *   rowSpan value and the group's
     *   ToolStripGroup.numRows value.
     * 
     * 
     *  @param {Array<Partial<Canvas>>} an array of widgets to add to this group
     */
    open fun addControls(controls: Array<dynamic>): Unit = definedExternally
    /**
     *   Adds a control to this toolStripGroup, creating a new
     *   ToolStripGroup.columnLayout as necessary, according to the control's
     *   rowSpan value and the group's
     *   ToolStripGroup.numRows value.
     * 
     * 
     *  @param {Canvas} a widget to add to this group
     *  @param {Integer=} optional insertion index for this control
     */
    open fun addControl(control: Canvas, index: Number?): Unit = definedExternally
    /**
     *   Removes a control from this toolStripGroup, destroying an existing
     *   ToolStripGroup.columnLayout if this is the last widget in that column.
     * 
     * 
     *  @param {Canvas} a widget to remove from this group
     */
    open fun removeControl(control: Canvas): Unit = definedExternally
    companion object {
        /**
         *  Creates a new ToolStripGroup
         * 
         *  @param typeCheckedProperties {Partial<ToolStripGroup>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ToolStripGroup} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ToolStripGroup = definedExternally
    }
}