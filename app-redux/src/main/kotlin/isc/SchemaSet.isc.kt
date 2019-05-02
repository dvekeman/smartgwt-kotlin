@file:JsQualifier("isc")
package isc

/**
 *  A set of schema derived from the &lt;xsd:schema&gt; element in a WSDL or XML schema file
 *   loaded by XMLTools.loadWSDL or XMLTools.loadXMLSchema.
 */
open external class SchemaSet : Class {
    /**
     *  Namespace of this SchemaSet, derived from the targetNamespace
     *   attribute of the &lt;schema&gt; element.
     *  @type {URI}
     *  @default null
     */
    open var schemaNamespace: String = definedExternally
    /**
     *   Get the schema definition of any complexType or element of complexType defined within
     *   the &lt;schema&gt; element this SchemaSet represents.
     * 
     * 
     *  @param {string} name of the schema to retrieve
     *  @param {string=} optional type of schema to return, either "element" for               xs:element definitions only or "type" for xs:complexType                definitions. If unspecified, either will be returned,                with types preferred if names collide
     */
    open fun getSchema(schemaName: String, schemaType: String?): DataSource = definedExternally
    companion object {
        /**
         *  Creates a new SchemaSet
         * 
         *  @param typeCheckedProperties {Partial<SchemaSet>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {SchemaSet} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): SchemaSet = definedExternally
        /**
         *   Retrieve a SchemaSet object by it's schemaNamespace.
         * 
         * 
         *  @param {string} uri from the "targetNamespace" attribute of the &lt;xsd:schema&gt; element from the XML Schema or WSDL file this SchemaSet was derived from.
         */
        fun get(schemaNamespace: String): SchemaSet = definedExternally
    }
}