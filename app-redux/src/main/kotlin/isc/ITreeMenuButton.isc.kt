@file:JsQualifier("isc")
package isc

/**
 *  Button used to display a hierarchical Menu group for representing / selecting tree data.
 *   This is derived from the MenuButton and is StretchImgButton based.
 * 
 *   Important Note: this class should not be used directly - it is exposed purely for
 *   i18nMessages
 */
open external class ITreeMenuButton : TreeMenuButton {
    companion object {
        /**
         *  Creates a new ITreeMenuButton
         * 
         *  @param typeCheckedProperties {Partial<ITreeMenuButton>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {ITreeMenuButton} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): ITreeMenuButton = definedExternally
    }
}