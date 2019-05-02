@file:JsQualifier("isc")
package isc

/**
 *  Form item for selecting a color via a pop-up ColorPicker.
 */
open external class ColorItem : TextItem {
    /**
     *  Should the pick button icon be shown for choosing colors from a ColorPicker
     *  @type {boolean}
     *  @default true
     */
    override var showPickerIcon: Boolean = definedExternally
    /**
     *  If ColorItem.showPickerIcon is true for this item, this property governs the
     *   size of the picker icon. If unset, the picker icon will be sized as a square to fit in the
     *   available height for the icon.
     * 
     *   Note that if spriting is being used, and the image to be displayed is specified
     *   using css properties such as background-image, background-size,
     *   changing this value may result in an unexpected appearance as the image will not
     *   scale.
     *   Scaleable spriting can be achieved using the SCSpriteConfig format.
     *   See the section on spriting in the skinning for
     *   further information.
     *  @type {Integer}
     *  @default "18"
     */
    override var pickerIconWidth: Number = definedExternally
    /**
     *  If ColorItem.showPickerIcon is true for this item, this property governs the
     *   size of the picker icon. If unset, the picker icon will be sized as a square to fit in the
     *   available height for the icon.
     * 
     *   Note that if spriting is being used, and the image to be displayed is specified
     *   using css properties such as background-image, background-size,
     *   changing this value may result in an unexpected appearance as the image will not
     *   scale.
     *   Scaleable spriting can be achieved using the SCSpriteConfig format.
     *   See the section on spriting in the skinning for
     *   further information.
     *  @type {Integer}
     *  @default "18"
     */
    override var pickerIconHeight: Number = definedExternally
    /**
     *  If ColorItem.showPickerIcon is true for this item, this property governs the
     *   FormItemIcon.src of the picker icon image to be displayed.
     * 
     *   skinning can be used for this image, by setting this property to
     *   a SCSpriteConfig formatted string.
     *  @type {SCImgURL}
     *  @default "[SKIN]/DynamicForm/ColorPicker_icon.png"
     */
    override var pickerIconSrc: String = definedExternally
    /**
     *  Prompt to show when the user hovers the mouse over the picker icon.
     *  @type {HTMLString}
     *  @default "Click to select a new color"
     */
    override var pickerIconPrompt: String = definedExternally
    /**
     *  The ColorPicker.defaultPickMode for the ColorPicker associated
     *   with this ColorItem.
     *  @type {ColorPickerMode}
     *  @default "simple"
     */
    open var defaultPickerMode: 
                                /**
                                 *  Display a palette of 40 basic colors from which to pick.
                                 *  In addition to the 40 basic colors, the user can specify a color from anywhere in the spectrum, with an optional alpha component.
                                 */
                                String /* simple |  complex */ = definedExternally
    /**
     *  Should "complex" mode be allowed for the ColorPicker window associated with
     *   this ColorItem?
     *   If false, no "More" button is shown on the simple picker
     *  @type {boolean}
     *  @default true
     */
    open var allowComplexMode: Boolean = definedExternally
    /**
     *  Determines whether the ColorPicker associated with this ColorItem allows the user
     *   to set transparency/opacity information whilst selecting a color. If false, no opacity
     *   slider is shown and all colors are 100% opaque.
     *   Note ColorItems are representations of HTML color strings, they do not implicitly
     *   support transparency. Setting supportsTransparency to true just allows the user to
     *   set opacity with the picker; if you actually want to capture that information, you will
     *   also need to override ColorItem.pickerColorSelected.
     *  @type {boolean}
     *  @default false
     */
    open var supportsTransparency: Boolean = definedExternally
    /**
     *   Store the color value selected by the user from the color picker. You will need to
     *   override this method if you wish to capture opacity information from the ColorPicker
     * 
     *  @param {string} the selected color as a string
     *  @param {Integer} the selected opacity, from 0 (transparent) to 100 (opaque).              Only applicable if ColorItem.supportsTransparency is true.
     */
    open fun pickerColorSelected(color: String, opacity: Number): Unit = definedExternally
    companion object {
        /**
         *  Creates a new ColorItem
         * 
         *  @param typeCheckedProperties {Partial<ColorItem>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ColorItem} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ColorItem = definedExternally
    }
}