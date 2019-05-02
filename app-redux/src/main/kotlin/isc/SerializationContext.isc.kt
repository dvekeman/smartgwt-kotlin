@file:JsQualifier("isc")
package isc

/**
 *  Flags for XML serialization
 */
open external class SerializationContext {
    /**
     *  Enables flat serialization mode, as described for DSRequest.useFlatFields.
     *  @type {boolean}
     *  @default null
     */
    open var useFlatFields: Boolean = definedExternally
}