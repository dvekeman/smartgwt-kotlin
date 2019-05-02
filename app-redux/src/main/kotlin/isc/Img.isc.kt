@file:JsQualifier("isc")
package isc

/**
 *  The Img widget class implements a simple widget that displays a single image.
 */
open external class Img : StatefulCanvas {
    /**
     *  The value of this attribute is specified as the value of the 'name' attribute in the
     *   resulting HTML.
     * 
     *   Note: this attribute is ignored if the imageType is set to "tile"
     *  @type {string}
     *  @default "main"
     */
    open var name: String = definedExternally
    /**
     *  The base filename for the image.
     * 
     *   This value will be combined with any specified StatefulCanvas.state
     *   to form a combined URL, changing the appearance of the component as the
     *   state changes.
     * 
     *   The following table lists out the standard set of combined URLs that
     *   may be generated. Subclasses may support additional state-derived media of course.
     *   Note that the src URL will be split such that the extension is always applied to the
     *   end of the combined string. For example in the following table, if src
     *   was set to "blank.gif", the Selected+Focused URL would be
     *   "blank_Selected_Focused.gif".
     * 
     *   URL for Img sourceDescription
     *   src+extensionDefault URL
     *   src+"_Selected"+extension
     *     Applied when StatefulCanvas.selected is set to true
     *   src+"_Focused"+extension
     *     Applied when the component has keyboard focus, if
     *     StatefulCanvas.showFocused is true, and
     *     StatefulCanvas.showFocusedAsOver is not true.
     *   src+"_Over"+extension
     *     Applied when the user rolls over the component if
     *       StatefulCanvas.showRollOver is set to true
     *   src+"_Down"+extension
     *     Applied when the user presses the mouse button over over the component if
     *       StatefulCanvas.showDown is set to true
     *   src+"_Disabled"+extension
     *     Applied to Canvas.disabled component
     *      if StatefulCanvas.showDisabled is true.
     *   Combined states
     *   src+"_Selected_Focused"+extension
     *     Combined Selected and focused state
     *   src+"_Selected_Over"+extension
     *     Combined Selected and rollOver state
     *   src+"_Focused_Over"+extension
     *     Combined Focused and rollOver state
     *   src+"_Selected_Focused_Over"+extension
     *     Combined Selected, Focused and rollOver state
     *   src+"_Selected_Down"+extension
     *     Combined Selected and mouse-down state
     *   src+"_Focused_Down"+extension
     *     Combined Focused and mouse-down state
     *   src+"_Selected_Focused_Down"+extension
     *     Combined Selected, Focused and mouse-down state
     *   src+"_Selected_Disabled"+extension
     *     Combined Selected and Disabled state
     * 
     *  @type {SCImgURL}
     *  @default "blank.gif"
     */
    open var src: String = definedExternally
    /**
     *  If specified this property will be included as the alt text for the image HMTL
     *   element. This is useful for improving application accessibility.
     * 
     *   altText and hover prompt / tooltip behavior: Note that some
     *   browsers, including Internet Explorer 9, show a native hover tooltip containing the
     *   img tag's alt attribute. Developers should not rely on this behavior to show
     *   the user a hover prompt - instead the Img.prompt attribute should be used.
     *   To set alt text and ensure a hover prompt shows up in all browsers, developers may
     *   set Img.prompt and altText to the same value. If both
     *   these attributes are set, the standard SmartClient prompt behavior will show a hover
     *   prompt in most browsers, but will be suppressed for browsers where a native tooltip
     *   is shown for altText. Note that setting altText and prompt to
     *   different values is not recommended - the prompt value will be ignored in favor of the
     *   altText in this case.
     *  @type {string}
     *  @default null
     */
    open var altText: String = definedExternally
    /**
     *  Prompt displayed in hover canvas if Canvas.showHover is true.
     *  @type {HTMLString}
     *  @default null
     */
    override var prompt: String = definedExternally
    /**
     *  Setting this attribute configures an image map for this image. The value is expected as a
     *   sequence of &lg;AREA&gt tags - e.g:
     * 
     *   Img.create({ 
     *     src: "myChart.gif",
     *     activeAreaHTML:
     *       "&lt;AREA shape='rect' coords='10,50,30,200' title='30' href='javascript:alert(\"30 units\")'&gt;" +
     *       "&lt;AREA shape='rect' coords='50,90,80,200' title='22' href='javascript:alert(\"22 units\")'&gt;"
     *   });
     * 
     *   Implementation notes:
     * 
     * 
     *  - Quotes in the activeAreaHTML must be escaped or alternated appropriately.
     * 
     *  - Image maps do not stretch to fit scaled images. You must ensure that the dimensions of
     *   your Img component match the anticipated width and height of your image map (which will typically
     *   match the native dimensions of your image).
     * 
     *  - To change the image map of an existing Img component, first set yourImg.activeAreaHTML,
     *   then call yourImg.markForRedraw(). Calls to yourImg.setSrc() will not automatically update the
     *   image map.
     * 
     *  - activeAreaHTML is not supported on tiled Img components (imageType:"tile").
     * 
     *  - Native browser support for image map focus/blur, keyboard events, and certain AREA tag
     *   attributes (eg NOHREF, DEFAULT...) varies by platform. If your image map HTML uses attributes
     *   beyond the basics (shape, coords, href, title), you should test on all supported browsers to
     *   ensure that it functions as expected.
     * 
     *  @type {string}
     *  @default null
     */
    open var activeAreaHTML: String = definedExternally
    /**
     *  Indicates whether the image should be tiled/cropped, stretched, or centered when the
     *       size of this widget does not match the size of the image.
     *       CENTER shows the image in it's natural size, but can't do so while the
     *       transparency fix is active for IE. The transparency fix can be manually disabled
     *       by setting Img.usePNGFix to false.
     *       See ImageStyle for further details.
     *  @type {ImageStyle}
     *  @default "stretch"
     */
    open var imageType: 
                        /**
                         *  Center (and don't stretch at all) the image if smaller than its enclosing frame.CENTER:"center",
                         *  Tile (repeat) the image if smaller than its enclosing frame.
                         *  Stretch the image to the size of its enclosing frame.
                         *  Allow the image to have natural size
                         */
                        String /* center |  tile |  stretch |  normal */ = definedExternally
    /**
     *  Explicit size for the image, for Img.imageType settings that would normally use the
     *   image's natural size (applies to Img.imageType "center" and "normal" only).
     *  @type {Integer}
     *  @default null
     */
    open var imageHeight: Number = definedExternally
    /**
     *  Explicit size for the image, for Img.imageType settings that would normally use the
     *   image's natural size (applies to Img.imageType "center" and "normal" only).
     *  @type {Integer}
     *  @default null
     */
    open var imageWidth: Number = definedExternally
    /**
     *  Convenience for setting height and width to the same value, at init time only
     *  @type {number}
     *  @default null
     */
    open var size: Number = definedExternally
    /**
     *  Determines whether any specified StatefulCanvas.getTitle will be
     *   displayed for this component.
     *   Applies to Image-based components only, where the title will be rendered out in a label
     *   floating over the component
     *  @type {boolean}
     *  @default false
     */
    open var showTitle: Boolean = definedExternally
    /**
     *  If false, never apply the png fix needed in Internet Explorer to make png transparency
     *   work correctly.
     *  @type {boolean}
     *  @default true
     */
    open var usePNGFix: Boolean = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "ImgEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
    /**
     *   Change the style of image rendering.
     * 
     * 
     *  @param {ImageStyle} new style of image rendering
     */
    open fun setImageType(imageType: 
                                     /**
                                      *  Center (and don't stretch at all) the image if smaller than its enclosing frame.CENTER:"center",
                                      *  Tile (repeat) the image if smaller than its enclosing frame.
                                      *  Stretch the image to the size of its enclosing frame.
                                      *  Allow the image to have natural size
                                      */
                                     String /* center |  tile |  stretch |  normal */): Unit = definedExternally
    /**
     *   Changes the URL of this image and redraws it.
     * 
     *   Does nothing if the src has not changed - if src has not changed but other
     *   state has changed such that the image needs updating, call Img.resetSrc instead.
     * 
     * 
     *  @param {SCImgURL} new URL for the image
     */
    open fun setSrc(URL: String): Unit = definedExternally
    /**
     *   Refresh the image being shown. Call this when the Img.src attribute has not changed, but
     *   other state that affects the image URL (such as being selected) has changed.
     * 
     * 
     */
    open fun resetSrc(): Unit = definedExternally
    /**
     *   If this.showHover is true, when the user holds the mouse over this Canvas for
     *   long enough to trigger a hover event, a hover canvas is shown by default. This method returns
     *   the contents of that hover canvas.
     * 
     *   Overridden from Canvas:
     *   If Img.prompt is specified, and Img.altText is unset, default implementation is unchanged -
     *   the prompt text will be displayed in the hover.
     *   If Img.altText and Img.prompt are set this method will return null to suppress
     *   the standard hover behavior in browsers where the alt attribute on an img tag causes
     *   a native tooltip to appear, such as Internet Explorer.
     *   On other browsers the altText value will be returned.
     * 
     * 
     */
    override fun getHoverHTML(): String = definedExternally
    companion object {
        /**
         *  Creates a new Img
         * 
         *  @param typeCheckedProperties {Partial<Img>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Img} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Img = definedExternally
    }
}