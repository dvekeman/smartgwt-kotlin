@file:JsQualifier("isc")
package isc

/**
 *  A Record is an ordinary JavaScript Object with properties that are treated as data to
 *   be displayed and edited by a DataBoundComponent.
 * 
 *   DataBoundComponents have a concept of DataBoundComponent.fields,
 *   where values for each field are found under the same-named property in a Record.
 * 
 *   A Record is always an ordinary JavaScript Object regardless of how the record is
 *   loaded (static data, java server, XML web service, etc), and so supports the
 *   normal behaviors of JavaScript Objects, including accessing and assigning to properties
 *   via dot notation:
 * 
 *     var fieldValue = record.fieldName;
 *     record.fieldName = newValue;
 * 
 * 
 *   The concept of working with Records is common to all DataBoundComponents, although
 *   individual DataBoundComponents may work with singular records (DynamicForm) or
 *   may work with lists (ListGrid), trees (TreeGrid), or cubes
 *   (CubeGrid) of records.
 * 
 *   Individual DataComponents may also look for special properties on Records which
 *   control styling or behavior for those records, such as
 *   ListGrid.recordEditProperty.
 */
open external class Record {
}