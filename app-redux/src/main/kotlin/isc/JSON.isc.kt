@file:JsQualifier("isc")
package isc

/**
 *  Utilities for working with JSON data.
 */
open external class JSON : Class {
    companion object {
        /**
         *  Creates a new JSON
         * 
         *  @param typeCheckedProperties {Partial<JSON>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {JSON} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): JSON = definedExternally
        /**
         *   Serialize an object as a JSON string by creating a JSONEncoder and calling
         *   JSONEncoder.encode.
         * 
         *   Note that using the String produced by this API with JSON.decode will not
         *   successfully preserve dates. Use JSONEncoder.dateFormat "dateConstructor" or
         *   "logicalDateConstructor" to have dates round-trip properly.
         * 
         * 
         *  @param {any} object to serialize
         *  @param {JSONEncoder=} optional settings for encoding
         */
        fun encode(`object`: dynamic, settings: JSONEncoder?): String = definedExternally
        /**
         *   De-serialize an object from JSON. Currently, this is simply a JavaScript eval() and should
         *   be used for trusted data only.
         * 
         * 
         *  @param {string} JSON data to be de-serialized
         */
        fun decode(jsonString: String): dynamic = definedExternally
    }
}