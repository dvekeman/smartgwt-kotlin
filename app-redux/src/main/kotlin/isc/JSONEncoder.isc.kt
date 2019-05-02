@file:JsQualifier("isc")
package isc

/**
 *  Class for encoding objects as JSON strings.
 */
open external class JSONEncoder : Class {
    /**
     *  Controls the output of the JSONEncoder when instances of SmartClient classes (eg a ListGrid)
     *   are included in the data to be serialized. See JSONInstanceSerializationMode.
     * 
     *   Note that the JSONEncoder does not support a format that will recreate the instance if
     *   passed to decode() or eval().
     *  @type {JSONInstanceSerializationMode}
     *  @default "long"
     */
    open var serializeInstances: 
                                 /**
                                  *  instances will be shown as a specially formatted JSON listing the most        relevant properties of the instance. Result is not expected to
                                  *          decode()/eval() successfully if instances are included.
                                  *  instances will be shown in a shorter format via a call to isc.echoLeaf.        Result is not expected to decode()/eval() successfully if instances are
                                  *          included.
                                  *  no output will be shown for instances (as though they were not present in the        data). Result should decode()/eval() successfully (depending on other
                                  *          settings)
                                  */
                                 String /* long |  short |  skip */ = definedExternally
    /**
     *  If true, don't show SmartClient internal properties when encoding and object.
     *  @type {boolean}
     *  @default false
     */
    open var skipInternalProperties: Boolean = definedExternally
    /**
     *  If objects that cannot be serialized to JSON are encountered during serialization, show a
     *   placeholder rather than just omitting them.
     * 
     *   The resulting String will not be valid JSON and so cannot be decoded/eval()'d
     *  @type {boolean}
     *  @default false
     */
    open var showDebugOutput: Boolean = definedExternally
    /**
     *  Format for encoding JavaScript Date values in JSON. See JSONDateFormat for
     *   valid options, or override JSONEncoder.encodeDate to do something custom.
     *  @type {JSONDateFormat}
     *  @default "xmlSchema"
     */
    open var dateFormat: 
                         /**
                          *  dates are is encoded as a String in XML Schema date format in UTC,
                          *      for example, "2005-08-02" for logical date fields or "2005-08-01T21:35:48.350"
                          *      for datetime fields. See dateFormatAndStorage for more information.
                          *  dates are encoded as raw JavaScript code for creating a Date object,    that is:
                          * 
                          *      new Date(1238792738633)
                          * 
                          *      This is not strictly valid JSON, but if eval()d, will result in an identical date object,
                          *      regardless of timezone. However, it does not preserve the distinction between
                          *      logical dates vs full datetime values - use "logicalDateConstructor" mode for that.
                          *  serializes Date instances in a way that preserves the    distinction between logical dates, logical times, and full datetime values, as
                          *      explained dateFormatAndStorage. Like 'dateConstructor' mode, this
                          *      does not produce strictly valid JSON, and instead embeds JavaScript calls.
                          * 
                          *      In addition, unlike 'dateConstructor' mode, using eval() to reconstruct the original
                          *      JavaScript objects will only work in the presence of SmartClient, and not just in a
                          *      generic JavaScript interpreter.
                          */
                         String /* xmlSchema |  dateConstructor |  logicalDateConstructor */ = definedExternally
    /**
     *  By default, obscure non-printable characters such as DC3 (Device Control 3, U+0013 hexadecimal)
     *   will be escaped according to JSON standards. ECMA-404 / The JSON Data Interchange Format
     *   requires the quotation mark (U+0022), reverse solidus (U+005C), and control characters (U+0000
     *   through U+001F) to be escaped.
     * 
     *   These characters are very rarely used in JSON data in web applications. If you know that
     *   your application does not use such characters in JSON data, there can be a performance
     *   advantage to setting escapeNonPrintable to false in order to disable the
     *   logic for escaping these characters. This is a detectable difference only when dealing
     *   with very large JSON structures on older browsers that do not provide native support (for
     *   example, Internet Explorer 8).
     *  @type {boolean}
     *  @default true
     */
    open var escapeNonPrintable: Boolean = definedExternally
    /**
     *  Whether all property names should be quoted, or only those property names that are not valid
     *   identifiers or are JavaScript reserved words (such as "true").
     * 
     *   Encoding only where required produces slightly shorter, more readable output which is still
     *   compatible with JavaScript's eval():
     * 
     *   {
     *     someProp : "someValue",
     *     "true" : "otherValue",
     *     otherProp : "otherValue"
     *   }
     * 
     *   .. but is not understood by many server-side JSON parser implementations.
     *  @type {boolean}
     *  @default true
     */
    open var strictQuoting: Boolean = definedExternally
    /**
     *  What the JSONEncoder should do if it encounters a circular reference.
     *  @type {JSONCircularReferenceMode}
     *  @default "path"
     */
    open var circularReferenceMode: 
                                    /**
                                     *  circular references in Arrays will be represented as a null entry, and objects        will have a property with a null value
                                     *  leave a string marker, the JSONEncoder.circularReferenceMarker,         wherever a circular reference is found
                                     *  leave a string marker followed by the path to the first occurrence of        the circular reference from the top of the object tree that was serialized.
                                     *          This potentially allows the original object graph to be reconstructed.
                                     */
                                    String /* omit |  marker |  path */ = definedExternally
    /**
     *  The string marker used to represent circular references. See JSONEncoder.circularReferenceMode.
     *  @type {string}
     *  @default "$$BACKREF$$"
     */
    open var circularReferenceMarker: String = definedExternally
    /**
     *  Whether to add indentation to the returned JSON string. This makes the returned JSON much
     *   easier to read but adds size. Note that when delivering JSON responses compressed, the size
     *   difference between prettyPrinted JSON and normal JSON is negligible.
     *  @type {boolean}
     *  @default true
     */
    open var prettyPrint: Boolean = definedExternally
    /**
     *   Serialize an object as a JSON string.
     * 
     *   Automatically handles circular references - see JSONEncoder.circularReferenceMode.
     * 
     * 
     *   Note that using the String produced by this API with JSON.decode will not
     *   successfully preserve dates. Use JSONEncoder.dateFormat "dateConstructor" or
     *   "logicalDateConstructor" to have dates round-trip properly.
     * 
     * 
     *  @param {any} object to serialize
     */
    open fun encode(`object`: dynamic): String = definedExternally
    /**
     *   Encode a JavaScript Date value.
     * 
     *   By default, follows the JSONEncoder.dateFormat setting. Override to do
     *   custom encoding.
     * 
     * 
     *  @param {Date} JavaScript date object to be serialized
     */
    open fun encodeDate(theDate: Date): String = definedExternally
    companion object {
        /**
         *  Creates a new JSONEncoder
         * 
         *  @param typeCheckedProperties {Partial<JSONEncoder>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {JSONEncoder} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): JSONEncoder = definedExternally
    }
}