@file:JsQualifier("isc")
package isc

/**
 *  Settings to control EditContext serialization.
 */
open external class SerializationSettings {
    /**
     *  When true specify DataSources in full rather than assuming they can be
     *   downloaded from the server.
     *  @type {boolean}
     *  @default null
     */
    open var serverless: Boolean = definedExternally
    /**
     *  Overrides the default indention setting during serialization. XML defaults
     *   to indented and JSON defaults to non-indented.
     *  @type {boolean}
     *  @default null
     */
    open var indent: Boolean = definedExternally
    /**
     *  Overrides the default component output setting during serialization. By default
     *   Canvas and DrawItem components are serialized individually and referenced by their
     *   containers.
     *  @type {boolean}
     *  @default true
     */
    open var outputComponentsIndividually: Boolean = definedExternally
}