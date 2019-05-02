@file:JsQualifier("isc")
package isc

/**
 *  Settings to control optional DataSource.load features.
 */
open external class DSLoadSettings {
    /**
     *  Forcibly reload a dataSource if it's already loaded.
     *  @type {boolean}
     *  @default null
     */
    open var forceReload: Boolean = definedExternally
    /**
     *  Load parent DataSources
     *  @type {boolean}
     *  @default null
     */
    open var loadParents: Boolean = definedExternally
    /**
     *  Place loaded DataSource into DataSource.mockMode
     *  @type {boolean}
     *  @default null
     */
    open var mockMode: Boolean = definedExternally
}