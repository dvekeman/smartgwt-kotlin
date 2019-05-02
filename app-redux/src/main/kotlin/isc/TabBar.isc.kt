@file:JsQualifier("isc")
package isc

/**
 *  Shows a set of Tabs. TabBars are automatically created by TabSets and shouldn't be used
 *   directly. The TabBar is documented for skinning purposes.
 */
open external class TabBar : Toolbar {
    /**
     *  Tab for this TabBar.
     *  @type {Array<Partial<Tab>>}
     *  @default null
     */
    open var tabs: Array<dynamic> = definedExternally
    /**
     *  Breadth of the tabBar (including baseline breadth)
     *  @type {number}
     *  @default "21"
     */
    open var breadth: Number = definedExternally
    /**
     *  SmartClient component used for the tabs of the tabBar.
     *   Must be Button or Button subclass.
     *  @type {Class}
     *  @default "ImgTab"
     */
    override var buttonConstructor: Class = definedExternally
    /**
     *  An array of shortcut keyboard commands which will close the currently selected tab, if
     *   the currently selected tab is closeable. Either this TabBar or the currently
     *   selected tab must have keyboard focus.
     * 
     *   By default, this is an array of two KeyIdentifiers: Alt+Delete,
     *   which is the keyboard command recommended by
     *   WAI-ARIA Authoring Practices
     *   and
     *   DHTML Style Guide Working Group,
     *   and Ctrl+W.
     *   Notes:
     * 
     * 
     *  - On Mac, the Alt+Delete keyboard command is accomplished via
     *   Fn-Option-Delete.
     * 
     *  - Alt+Delete is a
     *   JAWS Keystroke
     *   to "Say Active Cursor". If using JAWS, pressing Alt+Shift+Delete will close
     *   the tab.
     * 
     *  - In Chrome, Firefox, and Internet Explorer on Windows, Ctrl+W will also
     *   close the browser tab/window if focus is not within a TabBar.
     *   If Ctrl+W will be used frequently by the application's users, it may be useful to
     * 
     *   Page.registerKey to cancel it by default:
     *   isc.Page.registerKey({ctrlKey: true, keyName: "W"}, "return false");
     * 
     * 
     * 
     *  @type {Array<Partial<KeyIdentifier>>}
     *  @default "see below"
     */
    open var closeTabKeys: Array<dynamic> = definedExternally
    /**
     *  Should tabs exceeding TabBar.moreTabCount be shown on a "more" tab?
     * 
     *   This setting is used to emulate an iPhone-style tab bar "more" button.
     *  @type {boolean}
     *  @default null
     */
    open var showMoreTab: Boolean = definedExternally
    /**
     *  This property defines the number tab buttons that should be shown before
     *   automatically adding a "more" button to handle the remaining tabs. This
     *   property is only used when TabBar.showMoreTab is enabled.
     *  @type {Integer}
     *  @default "5"
     */
    open var moreTabCount: Number = definedExternally
    /**
     *  Tab to show as the "more" tab when TabBar.showMoreTab is enabled and the number
     *   of tabs to show exceeds TabBar.moreTabCount.
     *  @type {Tab}
     *  @default null
     */
    open var moreTab: Tab = definedExternally
    /**
     *  Thickness of the baseLine, in pixels. This should be set to match the media specified
     *   by TabBar.baseLineSrc. The baseLineThickness also determines the degree of overlap with
     *   the TabSet's paneContainer when using decorative edges - see TabSet.paneContainer
     *   for details.
     *  @type {number}
     *  @default "1"
     */
    open var baseLineThickness: Number = definedExternally
    /**
     *  Sets StretchImg.src for the baseLine StretchImg.
     *  @type {SCImgURL}
     *  @default "[SKIN]baseline.gif"
     */
    open var baseLineSrc: String = definedExternally
    /**
     *  Set StretchImg.capSize for the baseLine stretchImg.
     *  @type {number}
     *  @default "2"
     */
    open var baseLineCapSize: Number = definedExternally
    /**
     *  Default size (length) in pixels for tabs within this tabBar
     *  @type {number}
     *  @default "80"
     */
    open var defaultTabSize: Number = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "TabBarEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
    /**
     *   Select a tab
     * 
     *  @param {number} index of tab to select
     */
    open fun selectTab(tabNum: Number): Unit = definedExternally
    companion object {
        /**
         *  Creates a new TabBar
         * 
         *  @param typeCheckedProperties {Partial<TabBar>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {TabBar} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): TabBar = definedExternally
    }
}