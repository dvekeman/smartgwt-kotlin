@file:JsQualifier("isc")
package isc

/**
 *  Base class for creating toolstrips like those found in browsers and office applications: a
 *   mixed set of controls including ImgButton,
 *   Button.radioGroup, MenuButton,
 *   ComboBoxItem, LayoutSpacer, Label and
 *   SelectItem.
 * 
 *   All of the above components are placed in the ToolStrip.members to form
 *   a ToolStrip. Note that the FormItem mentioned above (ComboBox and
 *   drop-down selects) need to be placed within a DynamicForm as usual.
 * 
 * 
 *   The following strings can be used to add special behaviors:
 * 
 * 
 *  - the String "separator" will cause a separator to be created (instance of
 *   ToolStrip.separatorClass)
 * 
 *  - the String "resizer" will cause a resizer to be created (instance of
 *   ToolStrip.resizeBarClass). This is equivalent to setting
 *   Canvas.showResizeBar on the preceding member.
 * 
 *  - the String "starSpacer" will cause a spacer to be created (instance of
 *   LayoutSpacer).
 * 
 * 
 * 
 */
open external class ToolStrip : Layout {
    /**
     *  Array of components that will be contained within this Toolstrip, like
     *   Layout.members. Built-in special behaviors can be indicated as
     *   describe ToolStrip.
     *  @type {Array<Partial<Canvas>>}
     *  @default null
     */
    override var members: Array<dynamic> = definedExternally
    /**
     *  ToolStrips set a default Canvas.height to avoid being stretched by
     *   containing layouts.
     *  @type {number}
     *  @default "20"
     */
    override var height: dynamic = definedExternally
    /**
     *  Default stylename to use if ToolStrip.vertical is true.
     *   If unset, the standard attr:ToolStrip.styleName will be used for both vertical and horizontal
     *   toolstrips.
     * 
     *   Note that this property only applies to the widget at init time. To modify the
     *   styleName after this widget has been initialized, you should
     *   simply call Canvas.setStyleName rather than updating this
     *   property.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var verticalStyleName: String = definedExternally
    /**
     *  Indicates whether the components are drawn horizontally from left to right (false), or
     *   vertically from top to bottom (true).
     *  @type {boolean}
     *  @default false
     */
    override var vertical: Boolean = definedExternally
    /**
     *  Customized resizeBar with typical appearance for a ToolStrip.
     *  @type {string}
     *  @default "ToolStripResizer"
     */
    override var resizeBarClass: String = definedExternally
    /**
     *  Thickness of the resizeBars in pixels.
     *  @type {Integer}
     *  @default "14"
     */
    override var resizeBarSize: Number = definedExternally
    /**
     *  Class to create when the string "separator" appears in ToolStrip.members.
     *  @type {string}
     *  @default "ToolStripSeparator"
     */
    open var separatorClass: String = definedExternally
    /**
     *  Separator thickness in pixels
     *  @type {Integer}
     *  @default "8"
     */
    open var separatorSize: Number = definedExternally
    /**
     *  If set, this attribute affects whether ToolStripGroup
     *   in this ToolStrip show their header control. You can override this at the
     *   ToolStripGroup.setShowTitle level.
     *  @type {boolean}
     *  @default true
     */
    open var showGroupTitle: Boolean = definedExternally
    /**
     *  If set, this attribute affects the alignment of the titles in
     *   ToolStripGroup. You can override this at the
     *   ToolStripGroup.titleAlign level.
     *  @type {Alignment}
     *  @default "center"
     */
    open var groupTitleAlign: 
                              /**
                               *  Center within container.
                               *  Stick to left side of container.
                               *  Stick to right side of container.
                               */
                              String /* center |  left |  right */ = definedExternally
    /**
     *  If set, this attribute affects the orientation of the titles in
     *   ToolStripGroup. You can override this at the
     *   ToolStripGroup.titleAlign level.
     *  @type {VerticalAlignment}
     *  @default "top"
     */
    open var groupTitleOrientation: 
                                    /**
                                     *  At the top of the container
                                     *  Center within container.
                                     *  At the bottom of the container
                                     */
                                    String /* top |  center |  bottom */ = definedExternally
    /**
     *  DynamicForm instance created by ToolStrip.addFormItem to contain form items for
     *   display in this toolStrip. Each time addFormItem() is run, a new formWrapper
     *   autoChild will be created, picking up properties according to the standard
     *   AutoChild pattern.
     *  @type {DynamicForm}
     *  @default null
     */
    open var formWrapper: DynamicForm = definedExternally
    /**
     *  SmartClient class for generated ToolStrip.formWrapper components.
     *  @type {string}
     *  @default "DynamicForm"
     */
    open var formWrapperConstructor: String = definedExternally
    /**
     *  Default properties to apply to ToolStrip.formWrapper components. Default object
     *   is as follows:
     * 
     *   { showTitle:false,
     *    numCols:1,
     *    overflow:"visible",
     *    width:1, height:1 }
     * 
     *  @type {object}
     *  @default "..."
     */
    open var formWrapperDefaults: dynamic = definedExternally
    /**
     *  Properties to apply to ToolStrip.formWrapper components.
     *  @type {object}
     *  @default null
     */
    open var formWrapperProperties: dynamic = definedExternally
    /**
     *   Add a form item to this toolStrip. This method will create a DynamicForm autoChild with the
     *   item passed in as a single item, based on the
     *   ToolStrip.formWrapper, and add it to the toolstrip
     *   as a member.
     *   Returns a pointer to the generated formWrapper component.
     * 
     *  @param {FormItem} properties for the form item to add to this toolStrip.
     *  @param {DynamicForm=} properties to apply to the generated formWrapper component. If passed, specified properties will be overlaid onto the  properties derived from ToolStrip.formWrapperDefaults and  ToolStrip.formWrapperProperties.
     *  @param {Integer=} desired position for the form item in the tools
     */
    open fun addFormItem(formItem: FormItem, formProperties: DynamicForm?, position: Number?): DynamicForm = definedExternally
    companion object {
        /**
         *  Creates a new ToolStrip
         * 
         *  @param typeCheckedProperties {Partial<ToolStrip>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ToolStrip} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ToolStrip = definedExternally
    }
}