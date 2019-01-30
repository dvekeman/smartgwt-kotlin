@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")

import kotlin.js.*
import kotlin.js.Json
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*

inline fun Array.get(pos: Number): Any { return this.asDynamic().get(pos) }
inline fun Array.getLength(): Number { return this.asDynamic().getLength() }
inline fun Array.isEmpty(): Boolean { return this.asDynamic().isEmpty() }
inline fun Array.first(): Any { return this.asDynamic().first() }
inline fun Array.last(): Any { return this.asDynamic().last() }
inline fun Array.indexOf(obj: Any, pos: Number? = null, endPos: Number? = null): Number { return this.asDynamic().indexOf(obj, pos, endPos) }
inline fun Array.lastIndexOf(obj: Any, pos: Number? = null, endPos: Number? = null): Number { return this.asDynamic().lastIndexOf(obj, pos, endPos) }
inline fun Array.contains(obj: Any, pos: Number? = null): Boolean { return this.asDynamic().contains(obj, pos) }
inline fun Array.containsAll(list: isc.List): Boolean { return this.asDynamic().containsAll(list) }
inline fun Array.intersect(lists: Any): isc.List { return this.asDynamic().intersect(lists) }
inline fun Array.equals(list: isc.List): Boolean { return this.asDynamic().equals(list) }
inline fun Array.getItems(itemList: Array<Number>): Array<Any> { return this.asDynamic().getItems(itemList) }
inline fun Array.getRange(start: Number, end: Number): Array<Any> { return this.asDynamic().getRange(start, end) }
inline fun Array.duplicate(): Array<Any> { return this.asDynamic().duplicate() }
inline fun Array.set(pos: Number, obj: Any): Any { return this.asDynamic().set(pos, obj) }
inline fun Array.addAt(obj: Any, pos: Number): Any { return this.asDynamic().addAt(obj, pos) }
inline fun Array.removeAt(pos: Number): Any { return this.asDynamic().removeAt(pos) }
inline fun Array.add(`object`: Any): Any { return this.asDynamic().add(`object`) }
inline fun Array.addList(list: Array<Any>, listStartRow: Number? = null, listEndRow: Number? = null): isc.List { return this.asDynamic().addList(list, listStartRow, listEndRow) }
inline fun Array.setLength(length: Number): Unit { this.asDynamic().setLength(length) }
inline fun Array.addListAt(list: Array<Any>, pos: Number): Array<Any> { return this.asDynamic().addListAt(list, pos) }
inline fun Array.remove(obj: Any): Boolean { return this.asDynamic().remove(obj) }
inline fun Array.removeList(list: Array<Any>): isc.List { return this.asDynamic().removeList(list) }
inline fun Array.dataChanged(): Unit { this.asDynamic().dataChanged() }
inline fun Array.getProperty(property: String): Array<Any> { return this.asDynamic().getProperty(property) }
inline fun Array.getValueMap(idField: String, displayField: String): Any { return this.asDynamic().getValueMap(idField, displayField) }
inline fun Array.map(method: Function<*>): Array<Any> { return this.asDynamic().map(method) }
inline fun Array.callMethod(method: String, vararg args: Any): Array<Any> { return this.asDynamic().callMethod(method, args) }
inline fun Array.setProperty(property: String, value: Any): Unit { this.asDynamic().setProperty(property, value) }
inline fun Array.clearProperty(property: String): Boolean { return this.asDynamic().clearProperty(property) }
inline fun Array.getUniqueItems(): Array<Any> { return this.asDynamic().getUniqueItems() }
inline fun Array.findIndex(propertyName: String, value: Any? = null): Number { return this.asDynamic().findIndex(propertyName, value) }
inline fun Array.findIndex(propertyName: Any?, value: Any? = null): Number { return this.asDynamic().findIndex(propertyName, value) }
inline fun Array.findIndex(propertyName: isc.AdvancedCriteria, value: Any? = null): Number { return this.asDynamic().findIndex(propertyName, value) }
inline fun Array.findNextIndex(startIndex: Number, propertyName: String, value: Any? = null, endIndex: Number? = null): Number { return this.asDynamic().findNextIndex(startIndex, propertyName, value, endIndex) }
inline fun Array.findNextIndex(startIndex: Number, propertyName: Any?, value: Any? = null, endIndex: Number? = null): Number { return this.asDynamic().findNextIndex(startIndex, propertyName, value, endIndex) }
inline fun Array.findNextIndex(startIndex: Number, propertyName: Function<*>, value: Any? = null, endIndex: Number? = null): Number { return this.asDynamic().findNextIndex(startIndex, propertyName, value, endIndex) }
inline fun Array.findNextIndex(startIndex: Number, propertyName: isc.AdvancedCriteria, value: Any? = null, endIndex: Number? = null): Number { return this.asDynamic().findNextIndex(startIndex, propertyName, value, endIndex) }
inline fun Array.find(propertyName: String, value: Any? = null): Any { return this.asDynamic().find(propertyName, value) }
inline fun Array.find(propertyName: Any?, value: Any? = null): Any { return this.asDynamic().find(propertyName, value) }
inline fun Array.find(propertyName: isc.AdvancedCriteria, value: Any? = null): Any { return this.asDynamic().find(propertyName, value) }
inline fun Array.containsProperty(property: String, value: Any? = null): Boolean { return this.asDynamic().containsProperty(property, value) }
inline fun Array.findAll(propertyName: String, value: Any? = null): Array<Any> { return this.asDynamic().findAll(propertyName, value) }
inline fun Array.findAll(propertyName: Any?, value: Any? = null): Array<Any> { return this.asDynamic().findAll(propertyName, value) }
inline fun Array.findAll(propertyName: isc.AdvancedCriteria, value: Any? = null): Array<Any> { return this.asDynamic().findAll(propertyName, value) }
inline fun Array.slide(start: Number, destination: Number): Unit { this.asDynamic().slide(start, destination) }
inline fun Array.slideRange(start: Number, end: Number, destination: Number): Unit { this.asDynamic().slideRange(start, end, destination) }
inline fun Array.makeIndex(property: String, alwaysMakeArray: Boolean): Any { return this.asDynamic().makeIndex(property, alwaysMakeArray) }
inline fun Array.sortByProperty(property: String, up: Boolean, normalizer: Any? = null, context: Any? = null): isc.List { return this.asDynamic().sortByProperty(property, up, normalizer, context) }
inline fun Array.sortByProperty(property: String, up: Boolean, normalizer: Function<*>? = null, context: Any? = null): isc.List { return this.asDynamic().sortByProperty(property, up, normalizer, context) }
inline fun Array.setSort(sortSpecifiers: Array<Any?>): Array<Any> { return this.asDynamic().setSort(sortSpecifiers) }
inline fun Array.unsort(): Boolean { return this.asDynamic().unsort() }
inline fun Array.max(start: Number? = null, end: Number? = null): Number { return this.asDynamic().max(start, end) }
inline fun Array.min(start: Number? = null, end: Number? = null): Number { return this.asDynamic().min(start, end) }
inline fun Array.sum(start: Number? = null, end: Number? = null): Number { return this.asDynamic().sum(start, end) }
inline fun Array.and(start: Number? = null, end: Number? = null): Boolean { return this.asDynamic().and(start, end) }
inline fun Array.or(start: Number? = null, end: Number? = null): Boolean { return this.asDynamic().or(start, end) }
inline fun ArrayConstructor.isLoading(value: Any): Unit { this.asDynamic().isLoading(value) }
inline fun ArrayConstructor.compareAscending(a: Any, b: Any): Number { return this.asDynamic().compareAscending(a, b) }
inline fun ArrayConstructor.compareDescending(first: Any, second: Any): Number { return this.asDynamic().compareDescending(first, second) }
inline fun Number.stringify(digits: Number? = null): String { return this.asDynamic().stringify(digits) }
inline fun Number.isBetween(number: Number, first: Number? = null, second: Number? = null, inclusive: Number? = null): Boolean { return this.asDynamic().isBetween(number, first, second, inclusive) }
inline fun Number.toCurrencyString(currencyChar: String? = null, decimalChar: String? = null, padDecimal: Boolean? = null, currencyCharLast: Boolean? = null): String { return this.asDynamic().toCurrencyString(currencyChar, decimalChar, padDecimal, currencyCharLast) }
inline fun String.contains(substring: String): Boolean { return this.asDynamic().contains(substring) }
inline fun String.startsWith(substring: String, position: Number? = null): Boolean { return this.asDynamic().startsWith(substring, position) }
inline fun String.endsWith(substring: String, position: Number? = null): Boolean { return this.asDynamic().endsWith(substring, position) }
inline fun StringConstructor.isValidID(string: String): Boolean { return this.asDynamic().isValidID(string) }
inline fun Array.sortByProperty(property: String, up: Boolean): isc.List { return this.asDynamic().sortByProperty(property, up) }
