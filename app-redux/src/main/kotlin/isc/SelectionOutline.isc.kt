@file:JsQualifier("isc")
package isc

/**
 *  This static singleton class implements a component that can be used to highlight any other
 *   Canvas or FormItem by drawing a line around it and optional label. The selection outline
 *   moves, resizes and hides with the target object, and does not occlude any part of it. The
 *   outline is not a peer, child or member of the target object; the target object does not
 *   know about the outline.
 * 
 *   NOTE: This class is for internal use only by EditContext.
 */
open external class SelectionOutline : Class {
    companion object {
        /**
         *  Set the CSS border of this component as a CSS string including border-width,
         *   border-style, and/or color (eg "1px dashed blue").
         * 
         *   This property applies the same border to all four sides of this component.
         *  @type {string}
         *  @default "1px dashed #44ff44"
         */
        var border: String = definedExternally
        /**
         *  The background color for the selection label. It corresponds to the CSS background-color
         *   attribute. You can set this property to an RGB value (e.g. #22AAFF) or a named color
         *   (e.g. red) from a list of browser supported color names.
         *  @type {string}
         *  @default "#44ff44"
         */
        var labelBackgroundColor: String = definedExternally
        /**
         *  Creates a new SelectionOutline
         * 
         *  @param typeCheckedProperties {Partial<SelectionOutline>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {SelectionOutline} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): SelectionOutline = definedExternally
        /**
         *   Set the CSS border of this component as a CSS string including border-width,
         *   border-style, and/or color (eg "1px dashed blue").
         * 
         *   This property applies the same border to all four sides of this component.
         * 
         * 
         *  @param {string} ["1px dashed #44ff44"] css border string
         */
        fun setBorder(border: String): Unit = definedExternally
        /**
         *   Returns the CSS border of this component.
         * 
         * 
         */
        fun getBorder(): Unit = definedExternally
        /**
         *   Set the background color for the selection label. It corresponds to the CSS background-color
         *   attribute. You can set this property to an RGB value (e.g. #22AAFF) or a named color
         *   (e.g. red) from a list of browser supported color names.
         * 
         * 
         *  @param {string} ["#44ff44"] css color
         */
        fun setLabelBackgroundColor(color: String): Unit = definedExternally
        /**
         *   Returns the background color for the selection label.
         * 
         * 
         */
        fun getLabelBackgroundColor(): Unit = definedExternally
    }
}