@file:JsQualifier("isc")
package isc

/**
 *  The Slider class implements a GUI slider widget allowing the user to select a numeric
 *   value from within a range by dragging a visual indicator up and down a track.
 * 
 *   The slider will generate events as the user interacts with it and changes its value.
 *   If slider.sliderTarget is specified, moving the slider thumb generates a custom
 *   event named 'sliderMove', sent to the sliderTarget.
 *   If a sliderMove handler stringMethod is defined on the target, it will be
 *   fired when the slider is moved. The second parameter (available via the variable name
 *   eventInfo if the handler is a string) is a pointer back to the slider.
 * 
 *   The slider will also fire a valueChanged() method whenever its value is
 *   changed. This can be observed or overridden on the Slider instance to perform some action.
 */
open external class Slider : Canvas {
    /**
     *  Optional display title for the slider.
     *  @type {string}
     *  @default "Set Value"
     */
    open var title: String = definedExternally
    /**
     *  Used to set slider height if vertical, slider width if horizontal.
     *   Applied to the slider track, not necessarily the entire widget.
     *   Overridden by an explicit width/height specification for the widget.
     *  @type {Integer}
     *  @default "200"
     */
    open var length: Number = definedExternally
    /**
     *  Indicates whether this is a vertical or horizontal slider.
     *  @type {boolean}
     *  @default true
     */
    open var vertical: Boolean = definedExternally
    /**
     *  The dimension of the thumb perpendicular to the slider track.
     *  @type {Integer}
     *  @default "23"
     */
    open var thumbThickWidth: Number = definedExternally
    /**
     *  The dimension of the thumb parallel to the slider track.
     *  @type {Integer}
     *  @default "17"
     */
    open var thumbThinWidth: Number = definedExternally
    /**
     *  The thickness of the track. This is the width, for a vertical slider, or the height, for
     *   a horizontal slider.
     *  @type {Integer}
     *  @default "7"
     */
    open var trackWidth: Number = definedExternally
    /**
     *  Optional CSS style for the thumb for a horizontally oriented slider.
     * 
     *   Will have the suffix "down" added when the mouse is down on the thumb, and "Disabled"
     *   added when the slider is disabled.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var hThumbStyle: String = definedExternally
    /**
     *  Optional CSS style for the thumb for a vertically oriented slider. See
     *   Slider.hThumbStyle for state suffixes.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var vThumbStyle: String = definedExternally
    /**
     *  Optional CSS style for the track for a horizontally oriented slider.
     * 
     *   Will have the suffix "Disabled" added when the slider is disabled.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var hTrackStyle: String = definedExternally
    /**
     *  Optional CSS style for the track for a vertically oriented slider.
     * 
     *   Will have the suffix "Disabled" added when the slider is disabled.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var vTrackStyle: String = definedExternally
    /**
     *  If true, applies a separate Slider.activeTrackStyle to the part of the
     *   track between the minimum and current values.
     *  @type {boolean}
     *  @default null
     */
    open var showActiveTrack: Boolean = definedExternally
    /**
     *  Optional CSS style for the part of the track between it's minimum and current values.
     * 
     *   Will have the suffix "Disabled" added when the slider is disabled.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var activeTrackStyle: String = definedExternally
    /**
     *  The base filename for the slider thumb images.
     *   The filenames for the thumb icons are assembled from this base filename and the state of the
     *   thumb, as follows:
     *   Assume the thumbSrc is set to {baseName}.{extension}
     *   The full set of images to be displayed is:
     *   For horizontal sliders:
     * 
     * 
     *  - h{baseName}.{extension}: default enabled appearance.
     * 
     *  - h{baseName}_down.{extension}: appearance when the slider is enabled and the
     *     thumb is clicked.
     * 
     *  - h{baseName}_Disabled.{extension}: appearance when the slider is disabled.
     * 
     *   For vertical sliders:
     * 
     * 
     *  - v{baseName}.{extension}: default enabled appearance.
     * 
     *  - v{baseName}_down.{extension}: appearance when the slider is enabled and the
     *     thumb is clicked.
     * 
     *  - v{baseName}_Disabled.{extension}: appearance when the slider is disabled.
     * 
     *  @type {string}
     *  @default "thumb.gif"
     */
    open var thumbSrc: String = definedExternally
    /**
     *  The base filename for the slider track images.
     *   The filenames for the track icons are assembled from this base filename and the state of the
     *   slider, as follows:
     *   Assume the trackSrc is set to {baseName}.{extension}
     *   The full set of images to be displayed is:
     *   For horizontal sliders:
     * 
     * 
     *  - h{baseName}_start.{extension}: start (left edge) of the track for a slider
     *     that is enabled.
     * 
     *  - h{baseName}_stretch.{extension}: the track for an enabled slider; this may
     *     be centered, tiled, or stretched.
     * 
     *  - h{baseName}_end.{extension}: end (right edge) of the track for a slider
     *     that is enabled.
     * 
     *  - h{baseName}_Disabled_start.{extension}: start (left edge) of the track for a slider
     *     that is disabled.
     * 
     *  - h{baseName}_Disabled_stretch.{extension}: the track for a disabled slider; this
     *     may be centered, tiled, or stretched.
     * 
     *  - h{baseName}_Disabled_end.{extension}: end (right edge) of the track for a slider
     *     that is disabled.
     * 
     *   For vertical sliders:
     * 
     * 
     *  - v{baseName}_start.{extension}: start (bottom edge) of the track for a slider
     *     that is enabled.
     * 
     *  - v{baseName}_stretch.{extension}: the track for an enabled slider; this may
     *     be centered, tiled, or stretched.
     * 
     *  - v{baseName}_end.{extension}: end (top edge) of the track for a slider
     *     that is enabled.
     * 
     *  - v{baseName}_Disabled_start.{extension}: start (bottom edge) of the track for a slider
     *     that is disabled.
     * 
     *  - v{baseName}_Disabled_stretch.{extension}: the track for a disabled slider; this
     *     may be centered, tiled, or stretched.
     * 
     *  - v{baseName}_end.{extension}: end (top edge) of the track for a slider
     *     that is disabled.
     * 
     *  @type {string}
     *  @default "track.gif"
     */
    open var trackSrc: String = definedExternally
    /**
     *  The height of vertical slider start and end images, or width of horizontal slider start and
     *   end images.
     *  @type {Integer}
     *  @default "6"
     */
    open var trackCapSize: Number = definedExternally
    /**
     *  The imageType setting for the slider track.
     *  @type {ImageStyle}
     *  @default "stretch"
     */
    open var trackImageType: 
                             /**
                              *  Center (and don't stretch at all) the image if smaller than its enclosing frame.CENTER:"center",
                              *  Tile (repeat) the image if smaller than its enclosing frame.
                              *  Stretch the image to the size of its enclosing frame.
                              *  Allow the image to have natural size
                              */
                             String /* center |  tile |  stretch |  normal */ = definedExternally
    /**
     *  Indicates whether the slider's title should be displayed. The default position for this label
     *   is to the left of a horizontal slider, or above a vertical slider.
     *  @type {boolean}
     *  @default true
     */
    open var showTitle: Boolean = definedExternally
    /**
     *  Indicates whether labels for the min and max values of the slider should be displayed. The
     *   default positions for these labels are below the start/end of a horizontal slider, or to the
     *   right of the start/end of a vertical slider.
     *  @type {boolean}
     *  @default true
     */
    open var showRange: Boolean = definedExternally
    /**
     *  Indicates whether a label for the value of the slider should be displayed. The
     *   default position for this label is to the right of a vertical slider, or below a horizontal
     *   slider.
     *  @type {boolean}
     *  @default true
     */
    open var showValue: Boolean = definedExternally
    /**
     *  The width of the labels used to display the minimum, maximum and current values of the
     *   slider.
     *  @type {Integer}
     *  @default "50"
     */
    open var labelWidth: Number = definedExternally
    /**
     *  The height of the labels used to display the minimum, maximum and current values of the
     *   slider.
     *  @type {Integer}
     *  @default "20"
     */
    open var labelHeight: Number = definedExternally
    /**
     *  The space around the labels used to display the minimum, maximum and current values of the
     *   slider.
     *  @type {Integer}
     *  @default "5"
     */
    open var labelSpacing: Number = definedExternally
    /**
     *  The space between the title and the track.
     *  @type {Integer}
     *  @default "5"
     */
    open var titleSpacing: Number = definedExternally
    /**
     *  The slider value. This value should lie between the minValue and maxValue and increases as
     *   the thumb is moved up (for a vertical slider) or right (for a horizontal slider) unless
     *   flipValues is set to true.
     *  @type {Float}
     *  @default "1"
     */
    open var value: Number = definedExternally
    /**
     *  The minimum slider value. The slider value is equal to minValue when the thumb is at the
     *   bottom or left of the slider (unless flipValues is true, in which case the minimum value
     *   is at the top/right of the slider)
     *  @type {Float}
     *  @default "1"
     */
    open var minValue: Number = definedExternally
    /**
     *  The text displayed in the label for the minimum value of the slider. If left as null, then
     *   slider.minValue will be displayed.
     *  @type {string}
     *  @default null
     */
    open var minValueLabel: String = definedExternally
    /**
     *  The maximum slider value. The slider value is equal to maxValue when the thumb is at the
     *   top or right of the slider (unless flipValues is true, in which case the maximum value
     *   is at the bottom/left of the slider)
     *  @type {Float}
     *  @default "100"
     */
    open var maxValue: Number = definedExternally
    /**
     *  The text displayed in the label for the maximum value of the slider. If left as null, then
     *   slider.maxValue will be displayed.
     *  @type {string}
     *  @default null
     */
    open var maxValueLabel: String = definedExternally
    /**
     *  The number of discrete values represented by slider. If specified, the range of valid
     *   values (between minValue and maxValue) will be divided into
     *   this many steps. As the thumb is moved along the track it will only select these values
     *   and appear to jump between the steps.
     *  @type {Integer}
     *  @default null
     */
    open var numValues: Number = definedExternally
    /**
     *  Specifies whether the slider value should be rounded to the nearest integer. If set to
     *   false, values will be rounded to a fixed number of decimal places controlled by
     *   Slider.roundPrecision.
     *  @type {boolean}
     *  @default true
     */
    open var roundValues: Boolean = definedExternally
    /**
     *  If Slider.roundValues is false, the slider value will be rounded to this number of
     *   decimal places. If set to null the value will not be rounded
     *  @type {Integer}
     *  @default "1"
     */
    open var roundPrecision: Number = definedExternally
    /**
     *  Specifies whether the value range of the slider should be flipped so that values increase as
     *   the thumb is moved down (for a vertical slider) or to the left (for a horizontal slider).
     *  @type {boolean}
     *  @default false
     */
    open var flipValues: Boolean = definedExternally
    /**
     *  The target widget for the sliderMove event generated when the slider thumb
     *   is moved.
     *  @type {Canvas}
     *  @default null
     */
    open var sliderTarget: Canvas = definedExternally
    /**
     *  Indicates whether keyboard manipulation of the slider is allowed.
     *  @type {boolean}
     *  @default true
     */
    override var canFocus: Boolean = definedExternally
    /**
     *  The percentage of the total slider that constitutes one discrete step. The slider will move
     *   one step when the appropriate arrow key is pressed.
     *  @type {Float}
     *  @default "5"
     */
    open var stepPercent: Number = definedExternally
    /**
     *  Should the thumb be animated to its new position when the value is changed programmatically,
     *   or by clicking in the slider track.
     *  @type {boolean}
     *  @default true
     */
    open var animateThumb: Boolean = definedExternally
    /**
     *  Duration of thumb animation, in milliseconds.
     *  @type {Integer}
     *  @default "250"
     */
    open var animateThumbTime: Number = definedExternally
    /**
     *  If thumb animation is enabled, should the thumb be animated to its initial value?
     *  @type {boolean}
     *  @default false
     */
    open var animateThumbInit: Boolean = definedExternally
    /**
     *   Sets the slider value to newValue and moves the slider thumb to the appropriate position for this
     *   value. Sends the 'sliderMove' event to the sliderTarget.
     * 
     * 
     *  @param {Float} the new value
     *  @param {boolean} do not animate the slider thumb to the new value
     */
    open fun setValue(newValue: Number, noAnimation: Boolean): Unit = definedExternally
    /**
     *   Returns the current slider value.
     * 
     * 
     */
    open fun getValue(): Number = definedExternally
    /**
     *   This method is called when the slider value changes. This occurs when the Slider.setValue
     *   method is called, or when the slider is moved. Observe this method to be notified when the slider value
     *   changes.
     * 
     * 
     *  @param {Double} the new value.
     */
    open fun valueChanged(value: Number): Unit = definedExternally
    /**
     *   Call this method in your Slider.valueChanged handler to determine whether the
     *   value change is due to an ongoing drag interaction (true) or due to a thumb-release,
     *   mouse click, keypress, or programmatic event (false). You may choose to execute temporary or
     *   partial updates while the slider thumb is dragged, and final updates or persistence of the value
     *   in response to the other events.
     * 
     * 
     */
    open fun valueIsChanging(): Boolean = definedExternally
    /**
     *   Sets the Slider.minValue of the slider
     * 
     * 
     *  @param {Float} the new minimum value
     */
    open fun setMinValue(newValue: Number): Unit = definedExternally
    /**
     *   Sets the Slider.maxValue of the slider
     * 
     * 
     *  @param {Float} the new maximum value
     */
    open fun setMaxValue(newValue: Number): Unit = definedExternally
    /**
     *   Sets the Slider.numValues for the slider
     * 
     * 
     *  @param {Integer} the new number of values
     */
    open fun setNumValues(newNumValues: Number): Unit = definedExternally
    /**
     *   Sets the Slider.title of the slider
     * 
     * 
     *  @param {string} new title for the slider
     */
    open fun setTitle(newTitle: String): Unit = definedExternally
    /**
     *   Sets the Slider.vertical property of the slider
     * 
     * 
     *  @param {boolean} is the slider vertical
     */
    open fun setVertical(isVertical: Boolean): Unit = definedExternally
    /**
     *   Sets the Slider.thumbThickWidth property of the slider
     * 
     * 
     *  @param {Integer} new thumbThickWidth
     */
    open fun setThumbThickWidth(newWidth: Number): Unit = definedExternally
    /**
     *   Sets the Slider.thumbThinWidth property of the slider
     * 
     * 
     *  @param {Integer} new thumbThinWidth
     */
    open fun setThumbThinWidth(newWidth: Number): Unit = definedExternally
    /**
     *   Sets the Slider.trackWidth property of the slider
     * 
     * 
     *  @param {Integer} new trackWidth
     */
    open fun setTrackWidth(newWidth: Number): Unit = definedExternally
    /**
     *   Sets the Slider.thumbSrc property of the slider
     * 
     * 
     *  @param {string} new thumbSrc
     */
    open fun setThumbSrc(newSrc: String): Unit = definedExternally
    /**
     *   Sets the Slider.trackSrc property of the slider
     * 
     * 
     *  @param {string} new trackSrc
     */
    open fun setTrackSrc(newSrc: String): Unit = definedExternally
    /**
     *   Sets the Slider.trackCapSize property of the slider
     * 
     * 
     *  @param {Integer} new trackCapSize
     */
    open fun setTrackCapSize(newSize: Number): Unit = definedExternally
    /**
     *   Sets the Slider.trackImageType property of the slider
     * 
     * 
     *  @param {ImageStyle} new trackImageType
     */
    open fun setTrackImageType(newType: 
                                        /**
                                         *  Center (and don't stretch at all) the image if smaller than its enclosing frame.CENTER:"center",
                                         *  Tile (repeat) the image if smaller than its enclosing frame.
                                         *  Stretch the image to the size of its enclosing frame.
                                         *  Allow the image to have natural size
                                         */
                                        String /* center |  tile |  stretch |  normal */): Unit = definedExternally
    /**
     *   Sets the Slider.showTitle property of the slider
     * 
     * 
     *  @param {boolean} show the slider title?
     */
    open fun setShowTitle(showTitle: Boolean): Unit = definedExternally
    /**
     *   Sets the Slider.showRange property of the slider
     * 
     * 
     *  @param {boolean} show the slider range?
     */
    open fun setShowRange(showRange: Boolean): Unit = definedExternally
    /**
     *   Sets the Slider.showValue property of the slider
     * 
     * 
     *  @param {boolean} show the slider value?
     */
    open fun setShowValue(showValue: Boolean): Unit = definedExternally
    /**
     *   Sets the Slider.labelWidth property of the slider
     * 
     * 
     *  @param {Integer} new label width
     */
    open fun setLabelWidth(labelWidth: Number): Unit = definedExternally
    /**
     *   Sets the Slider.labelHeight property of the slider
     * 
     * 
     *  @param {Integer} new label height
     */
    open fun setLabelHeight(newHeight: Number): Unit = definedExternally
    /**
     *   Sets the Slider.labelSpacing property of the slider
     * 
     * 
     *  @param {Integer} new label spacing
     */
    open fun setLabelSpacing(labelWidth: Number): Unit = definedExternally
    /**
     *   Sets the Slider.maxValueLabel property of the slider
     * 
     * 
     *  @param {string} new label text
     */
    open fun setMaxValueLabel(labelText: String): Unit = definedExternally
    /**
     *   Sets the Slider.roundValues property of the slider
     * 
     * 
     *  @param {boolean} round slider values?
     */
    open fun setRoundValues(roundValues: Boolean): Unit = definedExternally
    /**
     *   Sets the Slider.roundPrecision property of the slider
     * 
     * 
     *  @param {Integer} new round precision
     */
    open fun setRoundPrecision(roundPrecision: Number): Unit = definedExternally
    /**
     *   Sets the Slider.flipValues property of the slider
     * 
     * 
     *  @param {boolean} flip slider values?
     */
    open fun setFlipValues(flipValues: Boolean): Unit = definedExternally
    /**
     *   Sets the Slider.stepPercent property of the slider
     * 
     * 
     *  @param {Float} new slider step percent
     */
    open fun setStepPercent(stepPercent: Number): Unit = definedExternally
    companion object {
        /**
         *  Creates a new Slider
         * 
         *  @param typeCheckedProperties {Partial<Slider>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Slider} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Slider = definedExternally
    }
}