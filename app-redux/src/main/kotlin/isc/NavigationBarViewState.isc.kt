@file:JsQualifier("isc")
package isc

/**
 *  Encapsulates state of a NavigationBar's view. A NavigationBarViewState
 *   object is created to pass to NavigationBar.setViewState so that multiple properties
 *   of the NavigationBar can be changed at once.
 */
open external class NavigationBarViewState {
    /**
     *  The new NavigationBar.showLeftButton setting. If unset, the
     *   showLeftButton setting is not changed.
     *  @type {boolean}
     *  @default null
     */
    open var showLeftButton: Boolean = definedExternally
    /**
     *  The new NavigationBar.leftButtonTitle setting. If unset, the
     *   leftButtonTitle is not changed.
     *  @type {HTMLString}
     *  @default null
     */
    open var leftButtonTitle: String = definedExternally
    /**
     *  The new NavigationBar.shortLeftButtonTitle setting. If unset, the
     *   shortLeftButtonTitle is not changed.
     *  @type {HTMLString}
     *  @default null
     */
    open var shortLeftButtonTitle: String = definedExternally
    /**
     *  The new NavigationBar.alwaysShowLeftButtonTitle setting. If unset, the
     *   alwaysShowLeftButtonTitle setting is not changed.
     *  @type {boolean}
     *  @default null
     */
    open var alwaysShowLeftButtonTitle: Boolean = definedExternally
    /**
     *  The new NavigationBar.title setting. If unset, the title is not changed.
     *  @type {HTMLString}
     *  @default null
     */
    open var title: String = definedExternally
    /**
     *  The new attr:NavigationBar.controls setting. If unset, the controls array
     *   is not changed.
     *  @type {Array<Partial<string>> | Array<Partial<Canvas>>}
     *  @default null
     */
    open var controls: Array<dynamic> = definedExternally
}