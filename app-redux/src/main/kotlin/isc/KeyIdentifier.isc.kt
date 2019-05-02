@file:JsQualifier("isc")
package isc

/**
 *  Identifier for a key pressed by the user, optionally specifying whether the Shift, Control,
 *   and/or Alt keys should be held or not held when the key is pressed, used by various methods.
 */
open external class KeyIdentifier {
    /**
     *  Name of the key.
     *  @type {KeyName}
     *  @default null
     */
    open var keyName: String = definedExternally
    /**
     *  If set, whether the Shift key must be held down.
     *  @type {boolean}
     *  @default null
     */
    open var shiftKey: Boolean = definedExternally
    /**
     *  If set, whether the Control key must be held down.
     *  @type {boolean}
     *  @default null
     */
    open var ctrlKey: Boolean = definedExternally
    /**
     *  If set, whether the Alt key must be held down.
     *  @type {boolean}
     *  @default null
     */
    open var altKey: Boolean = definedExternally
}