@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")

external open class String {
    companion object {
        open fun isValidID(string: kotlin.String): Boolean { definedExternally }
    }
}

external open class Array<T> {
    companion object {
        open fun isLoading(value: Any): Unit { definedExternally }
        open fun compareAscending(a: Any, b: Any): Number { definedExternally }
        open fun compareDescending(first: Any, second: Any): Number { definedExternally }
    }
}

inline fun Array<Any>.get(pos: Number): Any { return this.asDynamic().get(pos) }
inline fun Array<Any>.getLength(): Number { return this.asDynamic().getLength() }
inline fun Array<Any>.isEmpty(): Boolean { return this.asDynamic().isEmpty() }
inline fun Array<Any>.first(): Any { return this.asDynamic().first() }
inline fun Array<Any>.last(): Any { return this.asDynamic().last() }
inline fun Array<Any>.indexOf(obj: Any, pos: Number? = null, endPos: Number? = null): Number { return this.asDynamic().indexOf(obj, pos, endPos) }
inline fun Array<Any>.lastIndexOf(obj: Any, pos: Number? = null, endPos: Number? = null): Number { return this.asDynamic().lastIndexOf(obj, pos, endPos) }
inline fun Array<Any>.contains(obj: Any, pos: Number? = null): Boolean { return this.asDynamic().contains(obj, pos) }
inline fun Array<Any>.containsAll(list: isc.List): Boolean { return this.asDynamic().containsAll(list) }
inline fun Array<Any>.intersect(lists: Any): isc.List { return this.asDynamic().intersect(lists) }
inline fun Array<Any>.equals(list: isc.List): Boolean { return this.asDynamic().equals(list) }
inline fun Array<Any>.getItems(itemList: Array<Number>): Array<Any> { return this.asDynamic().getItems(itemList) }
inline fun Array<Any>.getRange(start: Number, end: Number): Array<Any> { return this.asDynamic().getRange(start, end) }
inline fun Array<Any>.duplicate(): Array<Any> { return this.asDynamic().duplicate() }
inline fun Array<Any>.set(pos: Number, obj: Any): Any { return this.asDynamic().set(pos, obj) }
inline fun Array<Any>.addAt(obj: Any, pos: Number): Any { return this.asDynamic().addAt(obj, pos) }
inline fun Array<Any>.removeAt(pos: Number): Any { return this.asDynamic().removeAt(pos) }
inline fun Array<Any>.add(`object`: Any): Any { return this.asDynamic().add(`object`) }
inline fun Array<Any>.addList(list: Array<Any>, listStartRow: Number? = null, listEndRow: Number? = null): isc.List { return this.asDynamic().addList(list, listStartRow, listEndRow) }
inline fun Array<Any>.setLength(length: Number): Unit { this.asDynamic().setLength(length) }
inline fun Array<Any>.addListAt(list: Array<Any>, pos: Number): Array<Any> { return this.asDynamic().addListAt(list, pos) }
inline fun Array<Any>.remove(obj: Any): Boolean { return this.asDynamic().remove(obj) }
inline fun Array<Any>.removeList(list: Array<Any>): isc.List { return this.asDynamic().removeList(list) }
inline fun Array<Any>.dataChanged(): Unit { this.asDynamic().dataChanged() }
inline fun Array<Any>.getProperty(property: String): Array<Any> { return this.asDynamic().getProperty(property) }
inline fun Array<Any>.getValueMap(idField: String, displayField: String): Any { return this.asDynamic().getValueMap(idField, displayField) }
inline fun Array<Any>.map(method: Function<*>): Array<Any> { return this.asDynamic().map(method) }
inline fun Array<Any>.callMethod(method: String, vararg args: Any): Array<Any> { return this.asDynamic().callMethod(method, args) }
inline fun Array<Any>.setProperty(property: String, value: Any): Unit { this.asDynamic().setProperty(property, value) }
inline fun Array<Any>.clearProperty(property: String): Boolean { return this.asDynamic().clearProperty(property) }
inline fun Array<Any>.getUniqueItems(): Array<Any> { return this.asDynamic().getUniqueItems() }
inline fun Array<Any>.findIndex(propertyName: String, value: Any? = null): Number { return this.asDynamic().findIndex(propertyName, value) }
inline fun Array<Any>.findIndex(propertyName: Any?, value: Any? = null): Number { return this.asDynamic().findIndex(propertyName, value) }
inline fun Array<Any>.findIndex(propertyName: isc.AdvancedCriteria, value: Any? = null): Number { return this.asDynamic().findIndex(propertyName, value) }
inline fun Array<Any>.findNextIndex(startIndex: Number, propertyName: String, value: Any? = null, endIndex: Number? = null): Number { return this.asDynamic().findNextIndex(startIndex, propertyName, value, endIndex) }
inline fun Array<Any>.findNextIndex(startIndex: Number, propertyName: Any?, value: Any? = null, endIndex: Number? = null): Number { return this.asDynamic().findNextIndex(startIndex, propertyName, value, endIndex) }
inline fun Array<Any>.findNextIndex(startIndex: Number, propertyName: Function<*>, value: Any? = null, endIndex: Number? = null): Number { return this.asDynamic().findNextIndex(startIndex, propertyName, value, endIndex) }
inline fun Array<Any>.findNextIndex(startIndex: Number, propertyName: isc.AdvancedCriteria, value: Any? = null, endIndex: Number? = null): Number { return this.asDynamic().findNextIndex(startIndex, propertyName, value, endIndex) }
inline fun Array<Any>.find(propertyName: String, value: Any? = null): Any { return this.asDynamic().find(propertyName, value) }
inline fun Array<Any>.find(propertyName: Any?, value: Any? = null): Any { return this.asDynamic().find(propertyName, value) }
inline fun Array<Any>.find(propertyName: isc.AdvancedCriteria, value: Any? = null): Any { return this.asDynamic().find(propertyName, value) }
inline fun Array<Any>.containsProperty(property: String, value: Any? = null): Boolean { return this.asDynamic().containsProperty(property, value) }
inline fun Array<Any>.findAll(propertyName: String, value: Any? = null): Array<Any> { return this.asDynamic().findAll(propertyName, value) }
inline fun Array<Any>.findAll(propertyName: Any?, value: Any? = null): Array<Any> { return this.asDynamic().findAll(propertyName, value) }
inline fun Array<Any>.findAll(propertyName: isc.AdvancedCriteria, value: Any? = null): Array<Any> { return this.asDynamic().findAll(propertyName, value) }
inline fun Array<Any>.slide(start: Number, destination: Number): Unit { this.asDynamic().slide(start, destination) }
inline fun Array<Any>.slideRange(start: Number, end: Number, destination: Number): Unit { this.asDynamic().slideRange(start, end, destination) }
inline fun Array<Any>.makeIndex(property: String, alwaysMakeArray: Boolean): Any { return this.asDynamic().makeIndex(property, alwaysMakeArray) }
inline fun Array<Any>.sortByProperty(property: String, up: Boolean, normalizer: Any? = null, context: Any? = null): isc.List { return this.asDynamic().sortByProperty(property, up, normalizer, context) }
inline fun Array<Any>.sortByProperty(property: String, up: Boolean, normalizer: Function<*>? = null, context: Any? = null): isc.List { return this.asDynamic().sortByProperty(property, up, normalizer, context) }
inline fun Array<Any>.setSort(sortSpecifiers: Array<Any?>): Array<Any> { return this.asDynamic().setSort(sortSpecifiers) }
inline fun Array<Any>.unsort(): Boolean { return this.asDynamic().unsort() }
inline fun Array<Any>.max(start: Number? = null, end: Number? = null): Number { return this.asDynamic().max(start, end) }
inline fun Array<Any>.min(start: Number? = null, end: Number? = null): Number { return this.asDynamic().min(start, end) }
inline fun Array<Any>.sum(start: Number? = null, end: Number? = null): Number { return this.asDynamic().sum(start, end) }
inline fun Array<Any>.and(start: Number? = null, end: Number? = null): Boolean { return this.asDynamic().and(start, end) }
inline fun Array<Any>.or(start: Number? = null, end: Number? = null): Boolean { return this.asDynamic().or(start, end) }
inline fun Number.stringify(digits: Number? = null): String { return this.asDynamic().stringify(digits) }
inline fun Number.isBetween(number: Number, first: Number? = null, second: Number? = null, inclusive: Number? = null): Boolean { return this.asDynamic().isBetween(number, first, second, inclusive) }
inline fun Number.toCurrencyString(currencyChar: String? = null, decimalChar: String? = null, padDecimal: Boolean? = null, currencyCharLast: Boolean? = null): String { return this.asDynamic().toCurrencyString(currencyChar, decimalChar, padDecimal, currencyCharLast) }
inline fun String.contains(substring: String): Boolean { return this.asDynamic().contains(substring) }
inline fun String.startsWith(substring: String, position: Number? = null): Boolean { return this.asDynamic().startsWith(substring, position) }
inline fun String.endsWith(substring: String, position: Number? = null): Boolean { return this.asDynamic().endsWith(substring, position) }
inline fun Array<Any>.sortByProperty(property: String, up: Boolean): isc.List { return this.asDynamic().sortByProperty(property, up) }
