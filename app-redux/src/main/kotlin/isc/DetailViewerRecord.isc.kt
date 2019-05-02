@file:JsQualifier("isc")
package isc

/**
 *  A DetailViewerRecord is an object literal with properties that define the values for the
 *   various fields of a DetailViewer.
 * 
 *   For example a DetailViewer that defines the following fields:
 * 
 *   fields : [
 *     {name: "field1"},
 *     {name: "field2"}
 *   ],
 * 
 *   Might have the following data:
 * 
 *   data : [
 *     {field1: "foo", field2: "bar"},
 *     {field1: "field1 value", field2: "field2 value"}
 *   ]
 * 
 *   Each element in the data array above is an instance of DetailViewerRecord - notice that
 *   these are specified simply as object literals with properties.
 */
open external class DetailViewerRecord {
    /**
     *  The HTML to display in this record for fields with type set to "link". This overrides
     *   DetailViewerField.linkText.
     *  @type {string}
     *  @default null
     */
    open var linkText: String = definedExternally
}