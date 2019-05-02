@file:JsQualifier("isc")
package isc

/**
 *  DrawItem subclass to render a single-line text label.
 */
open external class DrawLabel : DrawItem {
    /**
     *  DrawLabel only supports the
     *   "move"
     * 
     *   knob type.
     *  @type {Array<Partial<KnobType>>}
     *  @default null
     */
    override var knobs: Array<dynamic> = definedExternally
    /**
     *  This is the content that will exist as the label.
     *  @type {string}
     *  @default null
     */
    open var contents: String = definedExternally
    /**
     *  For DrawPane.drawingType DrawPanes, whether to escape the specified
     *   DrawLabel.contents of this label so that any markup syntax is rendered "as is," without being
     *   interpreted as SVG. This setting should not be customized when working with other
     *   DrawPane.drawingTypes, as the DrawLabel.contents are always escaped in such
     *   case.
     * 
     *   In SVG, a DrawLabel's DrawLabel.contents are rendered inside a &lt;text&gt;
     *   tag, so any SVG that's legal inside that tag can be set as the DrawLabel.contents when
     *   DrawLabel.escapeContents is false. See
     *   Mozilla SVG Developer Reference
     *   for more information about what exactly is supported.
     * 
     *   Note that the Framework will not be able to determine the width or height of a
     *   DrawLabel when this property is false, so the Framework will consider both dimensions
     *   to be zero, and centering will not work (e.g. for DrawItem.titleLabel autochildren).
     *   For top-level DrawLabels, you may be able to get the DOM to center your content by
     *   setting DrawLabel.alignment as "center" - the DOM will then interpret the
     *   DrawLabel.left, DrawLabel.top coordinates of the label as its centerpoint even though our Framework
     *   doesn't know the label's actual size.
     * 
     *   For a DrawItem.titleLabel, the DrawLabel.alignment setting
     *   is ignored, as the Framework always positions it using "start" alignment, but SVG code such
     *   as the following demonstrates that centering is possible (via the "style" setting):
     *   &lt;tspan text-decoration='underline' font-size='20px'
     *      style='dominant-baseline:central; text-anchor:middle;'&gt;MyLabel
     *   &lt;/tspan&gt;
     * 
     *  @type {boolean}
     *  @default true
     */
    open var escapeContents: Boolean = definedExternally
    /**
     *  Sets the amount from the left of its positioning that the element should be placed.
     *  @type {Coordinate}
     *  @default "0"
     */
    open var left: Number = definedExternally
    /**
     *  Sets the amount from the top of its positioning that the element should be placed.
     *  @type {Coordinate}
     *  @default "0"
     */
    open var top: Number = definedExternally
    /**
     *  Sets the text alignment from the x position. Similar to HTML5 context.textAlign
     *   with alignment values such as "start", "center", and "end".
     * 
     *   Note that this setting is ignored for DrawItem.titleLabel autochildren, which are
     *   always considered to have "start" alignment to make handling of
     *   DrawItem.titleRotationMode simpler.
     *  @type {LabelAlignment}
     *  @default "start"
     */
    open var alignment: 
                        /**
                         *  Justify label's left edge against its left coordinate              (right in RTL configurations)
                         *  Justify label's right edge against its left coordinate              (left in RTL configurations)
                         *  Center label about its left coordinate
                         *  Justify label's left edge against its left coordinate
                         *  Justify label's right edge against its left coordinate
                         */
                        String /* start |  end |  center |  left |  right */ = definedExternally
    /**
     *  Font family name, similar to the CSS font-family attribute.
     *  @type {string}
     *  @default "Tahoma"
     */
    open var fontFamily: String = definedExternally
    /**
     *  Font size in pixels, similar to the CSS font-size attribute.
     *  @type {Integer}
     *  @default "18"
     */
    open var fontSize: Number = definedExternally
    /**
     *  Font weight, similar to the CSS font-weight attribute, eg "normal", "bold".
     *  @type {string}
     *  @default "bold"
     */
    open var fontWeight: String = definedExternally
    /**
     *  Font style, similar to the CSS font-style attribute, eg "normal", "italic".
     *  @type {string}
     *  @default "normal"
     */
    open var fontStyle: String = definedExternally
    /**
     *  For DrawPane.drawingType "svg" only, the CSS class applied to this label.
     *   Similar to Canvas.styleName. The font properties DrawLabel.fontSize, DrawLabel.fontWeight,
     *   DrawLabel.fontStyle, and DrawLabel.fontFamily, unless set to null, take priority over any CSS
     *   settings. This property can be used in combination with DrawLabel.escapeContents if needed. but
     *   note that in SVG, the precedence of CSS and inline styling applied to an element works
     *   differently that it does in HTML. See
     *   Mozilla SVG Developer Reference
     * 
     *   Note that only font sizes defined in pixels are supported through this property.
     *  @type {CSSStyleName}
     *  @default "normal"
     */
    open var styleName: String = definedExternally
    /**
     *  The text color of the label.
     *  @type {CSSColor}
     *  @default "#808080"
     */
    override var lineColor: String = definedExternally
    /**
     *  Rotation in degrees about the DrawLabel.top DrawLabel.left corner. The positive
     *   direction is clockwise.
     *  @type {Float}
     *  @default "0.0"
     */
    override var rotation: Number = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "DrawLabelEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
    /**
     *   Sets the DrawLabel.escapeContents property for this DrawLabel.
     * 
     *  @param {boolean} whether to escape DrawLabel.contents
     */
    open fun setEscapeContents(escapeContents: Boolean): Unit = definedExternally
    /**
     *   Sets this DrawLabel's DrawLabel.styleName.
     * 
     *  @param {CSSStyleName} the new styleName
     */
    open fun setStyleName(styleName: String): Unit = definedExternally
    /**
     *   Get the center point of the label.
     * 
     */
    override fun getCenter(): Point = definedExternally
    /**
     *   Returns the top, left, top + textHeight, left + textWidth
     * 
     */
    override fun getBoundingBox(): Array<dynamic> = definedExternally
    /**
     *   Sets the text color of the label.
     * 
     *  @param {CSSColor} new text color.
     */
    override fun setLineColor(color: String): Unit = definedExternally
    /**
     *   Sets this DrawLabel's DrawLabel.contents.
     * 
     *  @param {string} the new contents.
     */
    open fun setContents(contents: String): Unit = definedExternally
    /**
     *   Sets this DrawLabel's DrawLabel.fontSize.
     * 
     *  @param {Integer} the new font size in pixels.
     */
    open fun setFontSize(size: Number): Unit = definedExternally
    companion object {
        /**
         *  This setting exists due to platform limitations in some versions of Internet Explorer
         *   where the browser does not recognize the five generic font families
         *   (cursive, fantasy, monospace,
         *   sans-serif, and serif) and instead uses a non-configurable,
         *   default font. This setting specifies a specific font to replace the
         *   cursive keyword should a DrawLabel list it in its
         *   DrawLabel.fontFamily.
         *  @type {string}
         *  @default "Zapf-Chancery"
         */
        var defaultCursiveFont: String = definedExternally
        /**
         *  This setting exists due to platform limitations in some versions of Internet Explorer
         *   where the browser does not recognize the five generic font families
         *   (cursive, fantasy, monospace,
         *   sans-serif, and serif) and instead uses a non-configurable,
         *   default font. This setting specifies a specific font to replace the
         *   fantasy keyword should a DrawLabel list it in its
         *   DrawLabel.fontFamily.
         *  @type {string}
         *  @default "Western"
         */
        var defaultFantasyFont: String = definedExternally
        /**
         *  This setting exists due to platform limitations in some versions of Internet Explorer
         *   where the browser does not recognize the five generic font families
         *   (cursive, fantasy, monospace,
         *   sans-serif, and serif) and instead uses a non-configurable,
         *   default font. This setting specifies a specific font to replace the
         *   monospace keyword should a DrawLabel list it in its
         *   DrawLabel.fontFamily.
         *  @type {string}
         *  @default "Courier"
         */
        var defaultMonospaceFont: String = definedExternally
        /**
         *  This setting exists due to platform limitations in some versions of Internet Explorer
         *   where the browser does not recognize the five generic font families
         *   (cursive, fantasy, monospace,
         *   sans-serif, and serif) and instead uses a non-configurable,
         *   default font. This setting specifies a specific font to replace the
         *   sans-serif keyword should a DrawLabel list it in its
         *   DrawLabel.fontFamily.
         *  @type {string}
         *  @default "Helvetica"
         */
        var defaultSansSerifFont: String = definedExternally
        /**
         *  This setting exists due to platform limitations in some versions of Internet Explorer
         *   where the browser does not recognize the five generic font families
         *   (cursive, fantasy, monospace,
         *   sans-serif, and serif) and instead uses a non-configurable,
         *   default font. This setting specifies a specific font to replace the
         *   serif keyword should a DrawLabel list it in its
         *   DrawLabel.fontFamily.
         *  @type {string}
         *  @default "Times"
         */
        var defaultSerifFont: String = definedExternally
        /**
         *  A declared value of the enum type
         *   LabelAlignment.
         *  @type {Constant}
         *  @default "start"
         */
        var START: String = definedExternally
        /**
         *  A declared value of the enum type
         *   LabelAlignment.
         *  @type {Constant}
         *  @default "end"
         */
        var END: String = definedExternally
        /**
         *  A declared value of the enum type
         *   LabelAlignment.
         *  @type {Constant}
         *  @default "center"
         */
        var CENTER: String = definedExternally
        /**
         *  A declared value of the enum type
         *   LabelAlignment.
         *  @type {Constant}
         *  @default "left"
         */
        var LEFT: String = definedExternally
        /**
         *  A declared value of the enum type
         *   LabelAlignment.
         *  @type {Constant}
         *  @default "right"
         */
        var RIGHT: String = definedExternally
        /**
         *  Creates a new DrawLabel
         * 
         *  @param typeCheckedProperties {Partial<DrawLabel>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {DrawLabel} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): DrawLabel = definedExternally
    }
}