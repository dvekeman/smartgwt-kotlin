@file:JsQualifier("isc")
package isc

/**
 *  The Gauge widget class implements a graphical speedometer-style gauge for displaying
 *   a measurement by means of a needle on a dial. The dial is divided into sectors, each having
 *   its own color and value.
 * 
 *   NOTE: you must load the Drawing loadingOptionalModules
 *   before you can use Gauge.
 */
open external class Gauge : DrawPane {
    /**
     *  Default height of the Gauge.pivotPoint if no specific pivotPoint is specified.
     * 
     *   Can be specified as a numeric pixel value, or a String percentage value.
     *  @type {number | string}
     *  @default "70%"
     */
    open var pivotPointHeight: dynamic = definedExternally
    /**
     *  AutoChild representing the shape drawn at the Gauge.pivotPoint (where all sectors of the
     *   gauge meet).
     *  @type {DrawItem}
     *  @default null
     */
    open var pivotShape: DrawItem = definedExternally
    /**
     *  AutoChild representing the needle shape that points to the gauge's current value. Default is
     *   to use a DrawTriangle.
     *  @type {DrawItem}
     *  @default null
     */
    open var needle: DrawItem = definedExternally
    /**
     *  MultiAutoChild representing the labels used to different data points on the gauge.
     *  @type {DrawLabel}
     *  @default null
     */
    open var valueLabel: DrawLabel = definedExternally
    /**
     *  MultiAutoChild representing the tick marks drawn along the circumference of the gauge.
     *   Default is to use DrawLine.
     *  @type {DrawItem}
     *  @default null
     */
    open var tickLine: DrawItem = definedExternally
    /**
     *  MultiAutoChild representing the sectors drawn to show different segments of the gauge.
     *  @type {DrawSector}
     *  @default null
     */
    open var sectorShape: DrawSector = definedExternally
    /**
     *  Radius in pixels of the dial.
     *  @type {Float}
     *  @default "150"
     */
    open var dialRadius: Number = definedExternally
    /**
     *  Font size of sector labels. Must be at least 3.
     *  @type {Integer}
     *  @default "11"
     */
    open var fontSize: Number = definedExternally
    /**
     *  Pixel width for gauge sector borders.
     *  @type {Integer}
     *  @default "1"
     */
    open var borderWidth: Number = definedExternally
    /**
     *  Color for gauge sector borders.
     *  @type {CSSColor}
     *  @default "#333333"
     */
    open var borderColor: String = definedExternally
    /**
     *  Array of preset fill colors used by the default implementation of Gauge.getDefaultFillColor
     *   to initialize the fill color of new sectors.
     * 
     *   The default array of colors is:
     * 
     * 
     *     #AFFFFF
     *     #008080
     *     #AAAFFF
     *     #FF0000
     *     #FFCC99
     *     #800080
     * 
     * 
     *  @type {Array<Partial<CSSColor>>}
     *  @default "[ "#AFFFFF", "#008080", "#AAAFFF", "#FF0000", "#FFCC99", "#800080" ]"
     */
    open var sectorColors: Array<dynamic> = definedExternally
    /**
     *  The minimum dial value.
     *  @type {Float}
     *  @default "0"
     */
    open var minValue: Number = definedExternally
    /**
     *  The maximum dial value.
     *  @type {Float}
     *  @default "100"
     */
    open var maxValue: Number = definedExternally
    /**
     *  The current value on the dial.
     *  @type {Float}
     *  @default "0"
     */
    open var value: Number = definedExternally
    /**
     *  The number of major tick lines.
     *  @type {Integer}
     *  @default "0"
     */
    open var numMajorTicks: Number = definedExternally
    /**
     *  The number of minor tick lines.
     *  @type {Integer}
     *  @default "0"
     */
    open var numMinorTicks: Number = definedExternally
    /**
     *  The label prefix.
     *  @type {string}
     *  @default ""
     */
    open var labelPrefix: String = definedExternally
    /**
     *  The label suffix.
     *  @type {string}
     *  @default "%"
     */
    open var labelSuffix: String = definedExternally
    /**
     *  Whether the sectors are drawn clockwise, and increasing the value causes the
     *   needle to move clockwise.
     *  @type {boolean}
     *  @default true
     */
    open var drawnClockwise: Boolean = definedExternally
    /**
     *  The GaugeSectors contained in this Gauge.
     * 
     *   If this this property is not specified, the gauge will
     *   be created with a default sector filling the gauge.
     *  @type {Array<Partial<GaugeSector>>}
     *  @default null
     */
    open var sectors: Array<dynamic> = definedExternally
    /**
     *  The pivot point of the needle.
     *  @type {Point}
     *  @default null
     */
    open var pivotPoint: Point = definedExternally
    /**
     *   Sets the minimum dial value, rescaling all sectors and the dial value.
     * 
     * 
     *  @param {Float} the new minimum dial value. Must be at least 1 less than the maximum dial value. If minValue is not at least 1 less than the maximum value, then it is set to maxValue - 1.
     */
    open fun setMinValue(minValue: Number): Unit = definedExternally
    /**
     *   All DrawItems currently associated with this Gauge are destroyed and
     *   new DrawItems are created instead.
     * 
     * 
     *  @param {Float} Radius in pixels of the dial
     */
    open fun setDialRadius(dialRadius: Number): Unit = definedExternally
    /**
     *   All DrawItems currently associated with this Gauge are destroyed and
     *   new DrawItems are created instead.
     * 
     *   The pivot point is set by default by choosing 1/2 of width and 70% of height of the Gauge. See
     *   Gauge.pivotPointHeight
     * 
     * 
     *  @param {Point} The pivot point of the needle
     */
    open fun setPivotPoint(point: Point): Unit = definedExternally
    /**
     *   Sets the maximum dial value, rescaling all sectors and the dial value.
     * 
     * 
     *  @param {Float} the new maximum dial value. Must be at least 1 greater than the minimum dial value. If maxValue is not at least 1 greater than the minimum value, then it is set to 1 + minValue.
     */
    open fun setMaxValue(maxValue: Number): Unit = definedExternally
    /**
     *   Sets the value on the dial that the needle is displaying.
     * 
     * 
     *  @param {Float} the new dial value. Must be between Gauge.minValue and Gauge.maxValue.
     */
    open fun setValue(value: Number): Unit = definedExternally
    /**
     *   Sets the number of major tick lines.
     * 
     *   NOTE: To divide the dial into n regions, you will need n + 1 ticks.
     *   For example, if the minimum value is 0 and the maximum value is 100, then to place major
     *   tick lines at 0, 10, 20, 30, ..., 90, 100, you need 11 (10 + 1) major ticks.
     * 
     * 
     *  @param {Integer} the number of major tick lines to draw. Must be either 0 or an integer greater than or equal to 2.
     */
    open fun setNumMajorTicks(numMajorTicks: Number): Unit = definedExternally
    /**
     *   Sets the number of minor tick lines.
     * 
     *   NOTE: To divide the dial into n regions, you will need n + 1 ticks.
     *   For example, if the minimum value is 0 and the maximum value is 100, then to place minor
     *   tick lines at 0, 1, 2, 3, 4, 5, ..., 99, 100, you need 101 (100 + 1) minor ticks.
     * 
     * 
     *  @param {Integer} the number of minor tick lines to draw. Must be either 0 or an integer greater than or equal to 2.
     */
    open fun setNumMinorTicks(numMinorTicks: Number): Unit = definedExternally
    /**
     *   Sets the Gauge.labelPrefix property and re-creates all sector labels.
     * 
     * 
     *  @param {string} the new label prefix.
     */
    open fun setLabelPrefix(labelPrefix: String): Unit = definedExternally
    /**
     *   Sets the Gauge.labelSuffix property and re-creates all sector labels.
     * 
     * 
     *  @param {string} the new label suffix.
     */
    open fun setLabelSuffix(labelSuffix: String): Unit = definedExternally
    /**
     *   Sets the Gauge.drawnClockwise property and redraws the gauge.
     * 
     * 
     *  @param {boolean} whether the sectors are drawn clockwise.
     */
    open fun setDrawnClockwise(drawnClockwise: Boolean): Unit = definedExternally
    /**
     *   Formats a value as a string to be used as the contents of a DrawLabel. The default
     *   implementation prepends Gauge.labelPrefix and appends
     *   Gauge.labelSuffix to value.
     * 
     *   NOTE: If a subclass overrides this, then whenever it changes the way that values are
     *   formatted, it must call Gauge.reformatLabelContents.
     * 
     * 
     *  @param {Float} the value to format.
     */
    open fun formatLabelContents(value: Number): String = definedExternally
    /**
     *   Resets the contents of all labels. This involves calling Gauge.formatLabelContents
     *   to get the label contents for each corresponding value and repositioning the label.
     * 
     * 
     */
    open fun reformatLabelContents(): Unit = definedExternally
    /**
     *   Gets the number of sectors.
     * 
     * 
     */
    open fun getNumSectors(): Number = definedExternally
    /**
     *   Gets the value of the sector at sectorIndex.
     * 
     * 
     *  @param {Integer} index of the target sector.
     */
    open fun getSectorValue(sectorIndex: Number): Number = definedExternally
    /**
     *   Gets the default fill color for the sector at index sectorIndex. The default
     *   implementation cycles through Gauge.sectorColors
     *   using modular arithmetic.
     * 
     * 
     *  @param {Integer} index of the target sector.
     */
    open fun getDefaultFillColor(sectorIndex: Number): String = definedExternally
    /**
     *   Gets the fill color of the sector at index sectorIndex.
     * 
     * 
     *  @param {Integer} index of the target sector.
     */
    open fun getSectorFillColor(sectorIndex: Number): String = definedExternally
    /**
     *   Sets the fill color of the sector at sectorIndex.
     * 
     * 
     *  @param {Integer} index of the target sector.
     *  @param {CSSColor} the new fill color.
     */
    open fun setSectorFillColor(sectorIndex: Number, fillColor: String): Unit = definedExternally
    /**
     *   Gets the label contents of the label for the sector at sectorIndex.
     * 
     * 
     *  @param {Integer} index of the target sector.
     */
    open fun getSectorLabelContents(sectorIndex: Number): String = definedExternally
    /**
     *   Sets the sectors for this gauge.
     * 
     *  @param {Array<Partial<GaugeSector>>} the sectors to show on the gauge.
     */
    open fun setSectors(sectors: Array<dynamic>): Unit = definedExternally
    /**
     *   Adds a new sector.
     * 
     * 
     *  @param {GaugeSector | Double} the new GaugeSector or the new sector's value. This is formatted with Gauge.formatLabelContents to get its label.
     */
    open fun addSector(newSector: dynamic): Number = definedExternally
    /**
     *   Removes the sector at sectorIndex.
     * 
     *   NOTE: There must always be one sector and it is not possible to remove the sole remaining
     *   sector. Calling this method to attempt to remove the sole remaining sector is a no-op.
     * 
     * 
     *  @param {Integer} the index of the sector to remove.
     */
    open fun removeSector(sectorIndex: Number): Unit = definedExternally
    companion object {
        /**
         *  Creates a new Gauge
         * 
         *  @param typeCheckedProperties {Partial<Gauge>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Gauge} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Gauge = definedExternally
    }
}