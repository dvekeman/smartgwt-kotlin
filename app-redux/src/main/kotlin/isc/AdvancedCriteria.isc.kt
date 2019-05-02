@file:JsQualifier("isc")
package isc

/**
 *  AdvancedCriteria is a format for representing search criteria which may include
 *   operators on field values such as "less than", or may include sub-clauses such as several
 *   criteria applied to fields joined by an "OR" operator.
 * 
 *   SmartClient DataSources can use AdvancedCriteria to search a list of Records, and
 *   the SmartClient Java Server can translate AdvancedCriteria to either SQL or Hibernate
 *   queries (Note: The server-side AdvancedCriteria handling feature is only available
 *   with the Power and Enterprise Editions of SmartClient; the Pro Edition is
 *   limited to ordinary criteria handling on the server side).
 *   If the entire dataset is cached locally, SmartClient can perform AdvancedCriteria filtering
 *   on the client, avoiding a server call.
 * 
 * 
 *   An AdvancedCriteria is an ordinary JavaScript object which can be created directly
 *   with JavaScript literal notation. For example:
 * 
 *   var advancedCriteria = {
 *      _constructor:"AdvancedCriteria",
 *      operator:"and",
 *      criteria:[
 *        // this is a Criterion
 *        { fieldName:"salary", operator:"lessThan", value:80000 },
 *        { operator:"or", criteria:[
 *           { fieldName:"title", operator:"iContains", value:"Manager" },
 *           { fieldName:"reports", operator:"notNull" }
 *         ] 
 *        },
 *        { fieldName:"startDate", operator:"greaterThan", value:new Date(1388552400000) }
 *      ]
 *    }
 * 
 *   This makes AdvancedCriteria very easy to store and retrieve as JSON strings, using
 *   JSON.encode.
 * 
 * 
 * 
 *   AdvancedCriteria can also be specified in componentXML:
 * 
 *   &lt;AdvancedCriteria operator="and" _constructor="AdvancedCriteria"&gt;
 *     &lt;criteria&gt;
 *       &lt;Criterion fieldName="salary" operator="lessThan"&gt;
 *         &lt;value xsi:type="xsd:float"&gt;80000&lt;/value&gt;
 *       &lt;/Criterion&gt;
 *       &lt;Criterion operator="or"&gt;
 *         &lt;criteria&gt;
 *           &lt;Criterion fieldName="title" operator="iContains"&gt;
 *             &lt;value xsi:type="xsd:text"&gt;Manager&lt;/value&gt;
 *           &lt;/Criterion&gt;
 *           &lt;Criterion fieldName="reports" operator="notNull"/&gt;
 *         &lt;/criteria&gt;
 *       &lt;/Criterion&gt;
 *       &lt;Criterion fieldName="startDate" operator="greaterThan"&gt;
 *         &lt;value xsi:type="xsd:datetime"&gt;2014-01-01T05:00:00.000&lt;/value&gt;
 *       &lt;/Criterion&gt;
 *     &lt;/criteria&gt;
 *   &lt;/AdvancedCriteria&gt;
 * 
 *   An AdvancedCriteria is in effect a Criterion that has been marked with
 *   _constructor:"AdvancedCriteria" to mark it as complete criteria.
 * 
 *   In addition to directly creating an AdvancedCriteria object as described above, the
 *   DataSource.convertCriteria and DataSource.combineCriteria methods
 *   may be used to create and modify criteria based on simple fieldName / value mappings.
 * 
 *   When passed to the SmartClient Server, a server-side AdvancedCriteria instance (in the
 *   package com.isomorphic.criteria) can be retrieved from a DSRequest via
 *   com.isomorphic.datasource.DSRequest.getAdvancedCriteria(). These same AdvancedCriteria
 *   objects can be directly created server side, and applied to a DSRequest via
 *   setAdvancedCriteria().
 * 
 *   RestDataSource, the recommended way of integration with servers that are not running
 *   the SmartClient Server Framework, defines a standard XML and JSON serialization of
 *   AdvancedCriteria. Date, DateTime and Time values use the same XML Schema
 *   representation used for other XML serialization like RestDataSource. Further details can
 *   be found at dateFormatAndStorage.
 * 
 *   It's a best practice for XML representation to have &lt;value&gt; as a subelement
 *   with xsi:type. Although most systems will auto-convert criteria explicitly
 *   setting type leaves the least room for error or ambiguity.
 * 
 *   For other servers, you can translate AdvancedCriteria into whatever format is
 *   expected by the server, typically by implementing DataSource.transformRequest.
 * 
 * 
 *   See criteriaEditing for information about
 *   editing AdvancedCriteria in a DynamicForm.
 * 
 *   When using the SmartClient Server, AdvancedCriteria created on the client and stored
 *   as JSON can be used directly by server code (without involvement of the browser and client-side system).
 *   Use the server-side API AdvancedCriteria.decodeClientCriteria() to obtain an AdvancedCriteria that can
 *   then be used with a server-created DSRequest object. Note that the client must be serialized by the
 *   JSONEncoder class, using JSONEncoder.dateFormat "logicalDateConstructor".
 */
open external class AdvancedCriteria : Criterion {
    /**
     *  When set to true, causes filtering using this criteria object to follow SQL99 behavior for
     *   dealing with NULL values. See DataSource.strictSQLFiltering for
     *   more detail.
     *  @type {boolean}
     *  @default null
     */
    open var strictSQLFiltering: Boolean = definedExternally
}