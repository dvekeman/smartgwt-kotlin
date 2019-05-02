@file:JsQualifier("isc")
package isc

/**
 *  The MultiFilePicker is a pop-up picker used by the MultiFileItem to allow the user to
 *   enter several files for upload.
 */
open external class MultiFilePicker : VStack {
    /**
     *  If set true, the picker will be displayed inside a Window.
     *  @type {boolean}
     *  @default false
     */
    open var showInWindow: Boolean = definedExternally
    /**
     *  Minimum number of upload fields to show. This many fields will show up initially.
     *  @type {Integer}
     *  @default "1"
     */
    open var minUploadFields: Number = definedExternally
    /**
     *  The maximum number of upload fields to show. If not specified, user can add as many
     *   upload fields as he wishes.
     *  @type {Integer}
     *  @default null
     */
    open var maxUploadFields: Number = definedExternally
    /**
     *  Title for the Window implemented as a container for this picker in some skins.
     *  @type {string}
     *  @default "Add files"
     */
    open var title: String = definedExternally
    companion object {
        /**
         *  Creates a new MultiFilePicker
         * 
         *  @param typeCheckedProperties {Partial<MultiFilePicker>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {MultiFilePicker} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): MultiFilePicker = definedExternally
    }
}