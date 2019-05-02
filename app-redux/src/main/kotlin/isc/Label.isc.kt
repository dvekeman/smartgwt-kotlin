@file:JsQualifier("isc")
package isc

/**
 *  Labels display a small amount of Label.align Label.contents
 *   with optional Label.icon and Label.autoFit.
 * 
 *   For a general-purpose container for HTML content, use HTMLFlow or HTMLPane
 *   instead.
 */
open external class Label : Button {
    /**
     *  The contents of a canvas or label widget. Any HTML string is acceptable.
     *  @type {HTMLString}
     *  @default "&amp;nbsp;"
     */
    override var contents: String = definedExternally
    /**
     *  Dynamic contents allows the contents string to be treated as a simple, but powerful
     *   template. When this attribute is set to true, expressions of the form &#36;{arbitrary JS
     *   here} are replaced by the result of the evaluation of the JS code inside the curly
     *   brackets. This evaluation happens at draw time. If you want to trigger a re-evaluation
     *   of the expressions in the contents string you can call markForRedraw() on the canvas.
     * 
     *   You can use this feature to build some simple custom components. For example, let's say
     *   you want to show the value of a Slider in a Canvas somewhere on the screen. You can do
     *   this by observing the valueChanged() method on the slider and calling setContents() on
     *   your canvas with the new string or you can set the contents of the canvas to something
     *   like:
     * 
     *   "The slider value is &#36;{sliderInstance.getValue()}."
     * 
     *   Next you set dynamicContents: true on the canvas, observe valueChanged() on the slider
     *   and call canvas.markForRedraw() in that observation. This approach is cleaner than
     *   setContents() when the Canvas is aggregating several values or dynamic expressions.
     *   Like so:
     * 
     * 
     *   Slider.create({
     *     ID: "mySlider"
     *   });
     * 
     *   Canvas.create({
     *     ID: "myCanvas",
     *     dynamicContents: true,
     *     contents: "The slider value is &#36;{mySlider.getValue()}."
     *   });
     * 
     *   myCanvas.observe(mySlider, "valueChanged",
     *           "observer.markForRedraw()");
     * 
     *   You can embed an arbitrary number of dynamic expressions in the contents string. The
     *   search and replace is optimized for speed.
     * 
     *   If an error occurs during the evaluation of one of the expressions, a warning is logged
     *   to the ISC Developer Console and the error string is embedded in place of the expected
     *   value in the Canvas.
     * 
     *   The value of a function is its return value. The value of any variable is the same as
     *   that returned by its toString() representation.
     * 
     *   Inside the evaluation contentext, this points to the canvas instance that
     *   has the dynamicContents string as its contents - in other words the canvas instance on
     *   which the template is declared.
     *  @type {boolean}
     *  @default false
     */
    override var dynamicContents: Boolean = definedExternally
    /**
     *  Horizontal alignment of label text. See Alignment type for details.
     *  @type {Alignment}
     *  @default "left"
     */
    override var align: 
                        /**
                         *  Center within container.
                         *  Stick to left side of container.
                         *  Stick to right side of container.
                         */
                        String /* center |  left |  right */ = definedExternally
    /**
     *  Vertical alignment of label text. See VerticalAlignment type for details.
     *  @type {VerticalAlignment}
     *  @default "center"
     */
    override var valign: 
                         /**
                          *  At the top of the container
                          *  Center within container.
                          *  At the bottom of the container
                          */
                         String /* top |  center |  bottom */ = definedExternally
    /**
     *  If false, the label text will not be wrapped to the next line.
     *  @type {boolean}
     *  @default true
     */
    override var wrap: Boolean = definedExternally
    /**
     *  If true, ignore the specified size of this widget and always size just large
     *   enough to accommodate the title. If setWidth() is explicitly called on an
     *   autoFit:true button, autoFit will be reset to false.
     * 
     *   Note that for StretchImgButton instances, autoFit will occur horizontally only, as
     *   unpredictable vertical sizing is likely to distort the media. If you do want vertical
     *   auto-fit, this can be achieved by simply setting a small height, and having
     *   overflow:"visible"
     *  @type {boolean}
     *  @default null
     */
    override var autoFit: Boolean = definedExternally
    /**
     *  Optional icon to be shown with the button title text.
     * 
     *   Specify as the partial URL to an image, relative to the imgDir of this component.
     *   A sprited image can be specified using the SCSpriteConfig format.
     * 
     *   Note that the string "blank" is a valid setting for this attribute and will always
     *   result in the system blank image, with no state suffixes applied. Typically, this
     *   might be used when an iconStyle is also specified and the iconStyle renders the icon via
     *   a stateful background-image or other CSS approach.
     *  @type {SCImgURL}
     *  @default null
     */
    override var icon: String = definedExternally
    /**
     *  Size in pixels of the icon image.
     * 
     *   The StatefulCanvas.iconWidth and StatefulCanvas.iconHeight
     *   properties can be used to configure width and height separately.
     * 
     *   Note: When configuring the properties of a StatefulCanvas (or derivative)
     *   AutoChild, it is best to set the iconWidth and iconHeight
     *   to the same value rather than setting an iconSize. This is because certain
     *   skins or customizations thereto might set the iconWidth and iconHeight,
     *   making the customization of the AutoChild's iconSize ineffective.
     *  @type {Integer}
     *  @default "16"
     */
    override var iconSize: Number = definedExternally
    /**
     *  Width in pixels of the icon image.
     * 
     *   If unset, defaults to StatefulCanvas.iconSize.
     *  @type {Integer}
     *  @default null
     */
    override var iconWidth: Number = definedExternally
    /**
     *  Height in pixels of the icon image.
     * 
     *   If unset, defaults to StatefulCanvas.iconSize.
     *  @type {Integer}
     *  @default null
     */
    override var iconHeight: Number = definedExternally
    /**
     *  If this button is showing an icon should it appear to the left or right of the title?
     *   valid options are "left" and "right".
     *  @type {string}
     *  @default "left"
     */
    override var iconOrientation: String = definedExternally
    /**
     *  If this button is showing an icon should it be right or left aligned?
     *  @type {string}
     *  @default null
     */
    override var iconAlign: String = definedExternally
    /**
     *  Pixels between icon and title text.
     *  @type {Integer}
     *  @default "6"
     */
    override var iconSpacing: Number = definedExternally
    /**
     *  If using an icon for this button, whether to switch the icon image if the button becomes
     *   disabled.
     *  @type {boolean}
     *  @default true
     */
    override var showDisabledIcon: Boolean = definedExternally
    /**
     *  If using an icon for this button, whether to switch the icon image on mouse rollover.
     *  @type {boolean}
     *  @default false
     */
    override var showRollOverIcon: Boolean = definedExternally
    /**
     *  If using an icon for this button, whether to switch the icon image when the button
     *   receives focus.
     * 
     *   If StatefulCanvas.showFocusedAsOver is true, the "Over" icon will be
     *   displayed when the canvas has focus, otherwise a separate "Focused" icon
     *   will be displayed
     *  @type {boolean}
     *  @default false
     */
    override var showFocusedIcon: Boolean = definedExternally
    /**
     *  If using an icon for this button, whether to switch the icon image when the mouse goes
     *   down on the button.
     *  @type {boolean}
     *  @default false
     */
    override var showDownIcon: Boolean = definedExternally
    /**
     *  If using an icon for this button, whether to switch the icon image when the button
     *   becomes selected.
     *  @type {boolean}
     *  @default false
     */
    override var showSelectedIcon: Boolean = definedExternally
    /**
     *  Set the CSS class for this widget. For a Label, this is equivalent to
     *   setting Button.baseStyle.
     *  @type {CSSStyleName}
     *  @default "normal"
     */
    override var styleName: String = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "LabelEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
    /**
     *   Changes the orientation of the icon relative to the text of the button.
     * 
     * 
     *  @param {string} The new orientation of the icon relative to the text of the button.
     */
    override fun setIconOrientation(orientation: String): Unit = definedExternally
    /**
     *   Change the icon being shown next to the title text.
     * 
     *  @param {SCImgURL} URL of new icon
     */
    override fun setIcon(icon: String): Unit = definedExternally
    /**
     *   Dynamically change the CSS class for this widget. For a Label, this is equivalent to
     *   StatefulCanvas.setBaseStyle.
     * 
     * 
     *  @param {CSSStyleName} new CSS style name
     */
    override fun setStyleName(newStyle: String): Unit = definedExternally
    /**
     *   Changes the contents of a widget to newContents, an HTML string.
     * 
     *   When Canvas.dynamicContents is set, setContents() can
     *   also be called with no arguments to cause contents to be re-evaluated.
     * 
     * 
     *  @param {HTMLString=} an HTML string to be set as the contents of this widget
     */
    override fun setContents(newContents: String?): Unit = definedExternally
    companion object {
        /**
         *  Creates a new Label
         * 
         *  @param typeCheckedProperties {Partial<Label>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Label} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Label = definedExternally
    }
}