@file:JsQualifier("isc")
package isc

/**
 *  The ColorPicker widget allows the user to select a color from anywhere in the
 *   color spectrum. It also supports selecting the alpha (opacity) value of the
 *   color. The picker supports a simple mode - which allows for one-click selection
 *   from a standard palette of colors - and a complex mode which allow the user to
 *   define any conceivable color. It is possible for the user to switch from simple
 *   mode to complex by interacting with the widget. In general, the widget provides
 *   very similar functionality to the color picker dialogs found in graphics packages
 *   and other desktop software.
 */
open external class ColorPicker : Window {
    /**
     *  "OK" button for the ColorPicker
     *  @type {IButton}
     *  @default null
     */
    open var okButton: IButton = definedExternally
    /**
     *  Should the OK button be visible. Set to false to hide the OK button.
     *  @type {boolean}
     *  @default true
     */
    open var showOkButton: Boolean = definedExternally
    /**
     *  The class of the "OK" button. It is intended that you use either IButton or
     *     Button - other classes are unlikely to work correctly.
     *  @type {Class}
     *  @default "IButton"
     */
    open var okButtonConstructor: Class = definedExternally
    /**
     *  Cancel button for the ColorPicker
     *  @type {IButton}
     *  @default null
     */
    open var cancelButton: IButton = definedExternally
    /**
     *  Should the Cancel button be visible. Set to false to hide the Cancel button.
     *  @type {boolean}
     *  @default true
     */
    open var showCancelButton: Boolean = definedExternally
    /**
     *  The class of the Cancel button. It is intended that you use either IButton or
     *     Button - other classes are unlikely to work correctly.
     *  @type {Class}
     *  @default "IButton"
     */
    open var cancelButtonConstructor: Class = definedExternally
    /**
     *  "More"/"Less" button for the ColorPicker
     *  @type {IButton}
     *  @default null
     */
    open var modeToggleButton: IButton = definedExternally
    /**
     *  Should the Mode Toggle button be visible. Set to false to hide the Mode Toggle button.
     *  @type {boolean}
     *  @default true
     */
    open var showModeToggleButton: Boolean = definedExternally
    /**
     *  The class of the mode toggle button. It is intended that you use either IButton or
     *     Button - other classes are unlikely to work correctly.
     *  @type {Class}
     *  @default "IButton"
     */
    open var modeToggleButtonConstructor: Class = definedExternally
    /**
     *  The default color. This is the color that is selected when the picker first loads
     *  @type {Text}
     *  @default "#808080"
     */
    open var defaultColor: Text = definedExternally
    /**
     *  Width and height of the basic color boxes (they are always square, and they are
     *   all the same size).
     *  @type {number}
     *  @default "20"
     */
    open var colorButtonSize: Number = definedExternally
    /**
     *  Base CSS style applied to the basic color boxes
     *  @type {CSSStyleName}
     *  @default "ColorChooserCell"
     */
    open var colorButtonBaseStyle: String = definedExternally
    /**
     *  Array of 40 HTML color strings, used to render the basic color selection boxes.
     *  @type {Array<Partial<string>>}
     *  @default "[...]"
     */
    open var colorArray: Array<dynamic> = definedExternally
    /**
     *  Displayed width of the color swatch image. The default width is approximately
     *   that used by the Windows&#174; XP color picking window
     *  @type {number}
     *  @default "170"
     */
    open var swatchWidth: Number = definedExternally
    /**
     *  Displayed height of the color swatch image. The default height is approximately
     *   that used by the Windows&#174; XP color picking window
     *  @type {number}
     *  @default "170"
     */
    open var swatchHeight: Number = definedExternally
    /**
     *  Width of the Luminosity bar
     *  @type {number}
     *  @default "15"
     */
    open var lumWidth: Number = definedExternally
    /**
     *  Determines whether to show the opacity slider. This allows the user to select colors
     *   with an alpha element (ie, semi-transparent colors). If this attribute is set to false,
     *   no opacity slider is shown, and all colors are completely opaque.
     *  @type {boolean}
     *  @default true
     */
    open var supportsTransparency: Boolean = definedExternally
    /**
     *  The text to show underneath the selected color box, so that it can
     *   be seen through semi-transparent colors. If you do not want such text, set
     *   this value to blank. This value is irrelevant if
     *   ColorPicker.supportsTransparency is false.
     *  @type {HTMLString}
     *  @default "Lorem ipsum dolor sit amet, consectetuer adipiscing elit."
     */
    open var opacityText: String = definedExternally
    /**
     *  The location of the color swatch image file
     *  @type {SCImgURL}
     *  @default "[SKIN]ColorPicker/spectrum.png"
     */
    open var swatchImageURL: String = definedExternally
    /**
     *  The location of the crosshair image file
     *  @type {SCImgURL}
     *  @default "[SKIN]ColorPicker/crosshair.png"
     */
    open var crosshairImageURL: String = definedExternally
    /**
     *  The title for the button that switches to a less complex view.
     *  @type {HTMLString}
     *  @default "&lt;&lt; Less"
     */
    open var lessButtonTitle: String = definedExternally
    /**
     *  The title for the button that switches to a more complex view.
     *  @type {HTMLString}
     *  @default "More &gt;&gt;"
     */
    open var moreButtonTitle: String = definedExternally
    /**
     *  The label shown above the basic color blocks.
     *  @type {HTMLString}
     *  @default "Basic Colors :"
     */
    open var basicColorLabel: String = definedExternally
    /**
     *  The label shown next to the selected color box.
     *  @type {HTMLString}
     *  @default "Selected Color"
     */
    open var selectedColorLabel: String = definedExternally
    /**
     *  The label shown next to the opacity slider. Ignored if
     *   ColorPicker.supportsTransparency is false.
     *  @type {HTMLString}
     *  @default "Opacity"
     */
    open var opacitySliderLabel: String = definedExternally
    /**
     *  The initial opacity value for the component, as a percentage value between 0 and 100
     *  @type {number}
     *  @default "100"
     */
    open var defaultOpacity: Number = definedExternally
    /**
     *  The title for the 'Red' field in the complex chooser.
     *  @type {HTMLString}
     *  @default "Red"
     */
    open var redFieldTitle: String = definedExternally
    /**
     *  The text to show when the mouse hovers over the 'Red' field in the complex chooser.
     *  @type {HTMLString}
     *  @default "The Red component of the selected color"
     */
    open var redFieldPrompt: String = definedExternally
    /**
     *  The title for the 'Green' field in the complex chooser.
     *  @type {HTMLString}
     *  @default "Green"
     */
    open var greenFieldTitle: String = definedExternally
    /**
     *  The text to show when the mouse hovers over the 'Green' field in the complex chooser.
     *  @type {HTMLString}
     *  @default "The Green component of the selected color"
     */
    open var greenFieldPrompt: String = definedExternally
    /**
     *  The title for the 'Blue' field in the complex chooser.
     *  @type {HTMLString}
     *  @default "Blue"
     */
    open var blueFieldTitle: String = definedExternally
    /**
     *  The text to show when the mouse hovers over the 'Blue' field in the complex chooser.
     *  @type {HTMLString}
     *  @default "The Blue component of the selected color"
     */
    open var blueFieldPrompt: String = definedExternally
    /**
     *  The title for the 'HTML' field in the complex chooser.
     *  @type {HTMLString}
     *  @default "HTML"
     */
    open var htmlFieldTitle: String = definedExternally
    /**
     *  The text to show when the mouse hovers over the 'HTML' field in the complex chooser.
     *  @type {HTMLString}
     *  @default "The selected color&amp;#39;s HTML coding"
     */
    open var htmlFieldPrompt: String = definedExternally
    /**
     *  The title for the 'Hue' field in the complex chooser.
     *  @type {HTMLString}
     *  @default "Hue"
     */
    open var hueFieldTitle: String = definedExternally
    /**
     *  The text to show when the mouse hovers over the 'Hue' field in the complex chooser.
     *  @type {HTMLString}
     *  @default "The Hue (base tone) of the selected color"
     */
    open var hueFieldPrompt: String = definedExternally
    /**
     *  The title for the 'Sat' field in the complex chooser.
     *  @type {HTMLString}
     *  @default "Sat"
     */
    open var satFieldTitle: String = definedExternally
    /**
     *  The text to show when the mouse hovers over the 'Saturation' field in the complex chooser.
     *  @type {HTMLString}
     *  @default "The Saturation (color purity) of the selected color"
     */
    open var satFieldPrompt: String = definedExternally
    /**
     *  The title for the 'Luminosity' field in the complex chooser.
     *  @type {HTMLString}
     *  @default "Luminosity"
     */
    open var lumFieldTitle: String = definedExternally
    /**
     *  The text to show when the mouse hovers over the 'Luminosity' field in the complex chooser.
     *  @type {HTMLString}
     *  @default "The Luminosity (brightness) of the selected color"
     */
    open var lumFieldPrompt: String = definedExternally
    /**
     *  The title for the 'OK' button.
     *  @type {HTMLString}
     *  @default "OK"
     */
    open var okButtonTitle: String = definedExternally
    /**
     *  The title for the 'Cancel' button.
     *  @type {HTMLString}
     *  @default "Cancel"
     */
    open var cancelButtonTitle: String = definedExternally
    /**
     *  If true, causes the ColorPicker to appear near where the mouse was last clicked.
     *   If false, the ColorPicker is centered on first show; depending on the value of
     *   ColorPicker.autoCenterOnShow, it either reappears wherever it was last shown after hide/show(),
     *   or centered regardless of where it was last shown.
     *  @type {boolean}
     *  @default true
     */
    open var autoPosition: Boolean = definedExternally
    /**
     *  If ColorPicker.autoPosition is false, this property controls whether to automatically center the
     *   colorPicker every time it is redisplayed with the show() method.
     *  @type {boolean}
     *  @default true
     */
    open var autoCenterOnShow: Boolean = definedExternally
    /**
     *  When this property is set to true, the ColorPicker will automatically hide when
     *   a color has been selected using the swatch picker, even in "complex" mode. By default it will
     *   only hide the ColorPicker in "simple" defaultPickMode.
     * 
     *   Set this property to false to disable the ColorPicker from automatically hiding,
     *   this can be especially useful when for instance embedding this component inside another component.
     *  @type {boolean}
     *  @default null
     */
    open var autoHide: Boolean = definedExternally
    /**
     *  The ColorPicker can operate in either a "simple" mode (where it displays just the
     *   40 basic colors and allows the user to click one), or a "complex" mode (where the
     *   user can specify a color from anywhere in the spectrum, with an optional alpha
     *   element). The defaultPickMode attribute specifies which of these two modes is
     *   in force when the picker first loads.
     *  @type {ColorPickerMode}
     *  @default "simple"
     */
    open var defaultPickMode: 
                              /**
                               *  Display a palette of 40 basic colors from which to pick.
                               *  In addition to the 40 basic colors, the user can specify a color from anywhere in the spectrum, with an optional alpha component.
                               */
                              String /* simple |  complex */ = definedExternally
    /**
     *  Should the "complex" mode be allowed for this ColorPicker?
     *   If false, no "More" button is shown on the simple picker
     *  @type {boolean}
     *  @default true
     */
    open var allowComplexMode: Boolean = definedExternally
    /**
     *   Set the ColorPicker.supportsTransparency flag.
     * 
     *  @param {boolean} Set to true to enable transparency/opacity
     */
    open fun setSupportsTransparency(transparencyFlag: Boolean): Unit = definedExternally
    /**
     *   Returns the Red element of the currently-selected color, as an integer from 0-255
     * 
     */
    open fun getRed(): Number = definedExternally
    /**
     *   Returns the Green element of the currently-selected color, as an integer from 0-255
     * 
     */
    open fun getGreen(): Number = definedExternally
    /**
     *   Returns the Blue element of the currently-selected color, as an integer from 0-255
     * 
     */
    open fun getBlue(): Number = definedExternally
    /**
     *   Returns the Hue of the currently-selected color, as an integer from 0-239
     * 
     */
    open fun getHue(): Number = definedExternally
    /**
     *   Returns the Saturation of the currently-selected color, as an integer from 0-240
     * 
     */
    open fun getSaturation(): Number = definedExternally
    /**
     *   Returns the Luminosity (brightness) of the currently-selected color, as an
     *   integer from 0-240
     * 
     */
    open fun getLuminosity(): Number = definedExternally
    /**
     *   Returns the currently-selected color, in HTML color representation form, as a string.
     *   HTML color representation is a hash sign, followed by the red, green and blue elements
     *   of the color in 2-digit hex form - for example "#F17F1D"
     * 
     */
    open fun getHtmlColor(): String = definedExternally
    /**
     *   Returns the opacity of the currently-selected color, as an integer from 0-100. If
     *   opacity is switched off, this is always 100.
     * 
     */
    open fun getOpacity(): Number = definedExternally
    /**
     *   Sets the Red element of the selected color
     * 
     *  @param {number} An integer between 0 and 255
     */
    open fun setRed(newValue: Number): Unit = definedExternally
    /**
     *   Sets the Green element of the selected color
     * 
     *  @param {number} An integer between 0 and 255
     */
    open fun setGreen(newValue: Number): Unit = definedExternally
    /**
     *   Sets the Blue element of the selected color
     * 
     *  @param {number} An integer between 0 and 255
     */
    open fun setBlue(newValue: Number): Unit = definedExternally
    /**
     *   Sets the Hue of the selected color
     * 
     *  @param {number} An integer between 0 and 239
     */
    open fun setHue(newValue: Number): Unit = definedExternally
    /**
     *   Sets the Saturation of the selected color
     * 
     *  @param {number} An integer between 0 and 240
     */
    open fun setSaturation(newValue: Number): Unit = definedExternally
    /**
     *   Sets the Luminosity (brightness) of the selected color
     * 
     *  @param {number} An integer between 0 and 240
     */
    open fun setLuminosity(newValue: Number): Unit = definedExternally
    /**
     *   Changes the selected color to the one represented by the supplied HTML color
     *   string. Note that the method only accepts the parameter if it represents a
     *   valid color (otherwise it is simply ignored).
     * 
     *  @param {Text} A string in HTML color representation format (#RRGGBB)
     */
    open fun setHtmlColor(newValue: Text): Unit = definedExternally
    /**
     *   Sets the Opacity of the selected color. Ignored if opacity is switched off.
     * 
     *  @param {number} An integer between 0 and 100
     */
    override fun setOpacity(newOpacity: Number): Unit = definedExternally
    /**
     *   Changes the pick mode of this ColorPicker to pickMode.
     * 
     *   Note: It is not allowed to set the pick mode to
     *   "complex"
     * 
     *   if ColorPicker.allowComplexMode is false.
     * 
     *  @param {ColorPickerMode} the new pick mode.
     */
    open fun setCurrentPickMode(pickMode: 
                                          /**
                                           *  Display a palette of 40 basic colors from which to pick.
                                           *  In addition to the 40 basic colors, the user can specify a color from anywhere in the spectrum, with an optional alpha component.
                                           */
                                          String /* simple |  complex */): Unit = definedExternally
    /**
     *   Override this method to be kept informed when the ColorPicker changes in real-time
     *   (for example, if you need to update your own GUI accordingly). Then use the
     *   getXxxx() methods (for example, ColorPicker.getBlue or
     *   ColorPicker.getLuminosity)to obtain current state as required.
     * 
     */
    open fun colorChanged(): Unit = definedExternally
    /**
     *   Override this method to be notified when the user selects a color
     *   either by clicking a basic color box in simple mode, or by clicking
     *   the OK button in complex mode. It is not intended that client code
     *   call this method. The ColorPicker may automatically hide
     *   itself after calling this method depending on ColorPicker.autoHide and
     *   ColorPicker.defaultPickMode.
     * 
     *  @param {string} The color selected, in HTML format
     *  @param {number} The opacity selected, from 0-100.
     */
    open fun colorSelected(color: String, opacity: Number): Unit = definedExternally
    companion object {
        /**
         *  Creates a new ColorPicker
         * 
         *  @param typeCheckedProperties {Partial<ColorPicker>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ColorPicker} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ColorPicker = definedExternally
        /**
         *   Returns the shared global ColorPicker.
         *   Many applications will only need one ColorPicker instance; for such use
         *   cases, it is a good idea to use the shared object for performance reasons.
         * 
         *   The optional second parameter to this method indicates whether the shared picker
         *   should retain the state (mode, color and opacity) it was in last time it was used,
         *   or revert to defaults.
         *   Generally, you will want the picker to revert to default state; this gives the
         *   same user experience as creating a new instance without incurring the overhead.
         *   However, some use cases will benefit from the picker remembering what the user
         *   did last time.
         * 
         *  @param {object} Properties to apply to the global ColorPicker object
         *  @param {boolean=} Should we keep the current state?                  If false (or not provided), revert to default state
         */
        fun getSharedColorPicker(properties: dynamic, keepCurrentState: Boolean?): Unit = definedExternally
    }
}