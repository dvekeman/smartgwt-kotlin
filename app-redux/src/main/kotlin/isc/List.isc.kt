@file:JsQualifier("isc")
package isc

external interface List {
    fun get (pos: Number): dynamic
    fun getLength (): Number
    fun isEmpty (): Boolean
    fun first (): dynamic
    fun last (): dynamic
    fun indexOf (obj: dynamic, pos: Number?, endPos: Number?): Number
    fun lastIndexOf (obj: dynamic, pos: Number?, endPos: Number?): Number
    fun findIndex (propertyName: dynamic, value: dynamic?): Number
    fun findNextIndex (startIndex: Number, propertyName: dynamic, value: dynamic?, endIndex: Number?): Number
    fun find (propertyName: dynamic, value: dynamic?): dynamic
    fun findAll (propertyName: dynamic, value: dynamic?): Array<dynamic>
    fun contains (obj: dynamic, pos: Number?): Boolean
    fun containsAll (list: List): Boolean
    fun intersect (lists: dynamic): List
    fun equals (list: List): Boolean
    fun getItems (itemList: Array<dynamic>): Array<dynamic>
    fun getRange (start: Number, end: Number): Array<dynamic>
    fun duplicate (): Array<dynamic>
    fun set (pos: Number, obj: dynamic): dynamic
    fun addAt (obj: dynamic, pos: Number): dynamic
    fun removeAt (pos: Number): dynamic
    fun add (`object`: dynamic): dynamic
    fun addList (list: Array<dynamic>, listStartRow: Number?, listEndRow: Number?): List
    fun setLength (length: Number): Unit
    fun addListAt (list: Array<dynamic>, pos: Number): Array<dynamic>
    fun remove (obj: dynamic): Boolean
    fun removeList (list: Array<dynamic>): List
    fun sort (comparator: (() -> dynamic?)): List
    fun getProperty (property: String): Array<dynamic>
    fun sortByProperty (property: String, up: Boolean, normalizer: dynamic?, context: dynamic?): List
    fun getValueMap (idField: String, displayField: String): dynamic
    fun dataChanged (): Unit
}