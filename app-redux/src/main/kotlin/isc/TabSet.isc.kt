@file:JsQualifier("isc")
package isc

/**
 *  The TabSet class allows components on several panes to share the same space. The tabs at
 *   the top can be selected by the user to show each pane.
 * 
 *   Tabs are configured via the tabs property, each of which has a
 *   pane property which will be displayed in the main pane when that tab is
 *   selected.
 */
open external class TabSet : Canvas {
    /**
     *  An array of Tab objects, specifying the title and pane contents of each tab in the TabSet.
     *   When developing in JavaScript, tabs are specified as an array of object literals,
     *   not instances - see Tab.
     * 
     * 
     *   After providing Tab instances to setTabs(), the TabSet creates actual UI
     *   widgets to serve as interactive tabs. Any further modifications to tabs should be performed
     *   via TabSet APIs such as TabSet.setTabTitle, TabSet.setTabIcon and
     *   TabSet.setTabPane.
     * 
     *   You can add and remove tabs after creating the TabSet by calling TabSet.addTab and
     *   TabSet.removeTab
     *  @type {Array<Partial<Tab>>}
     *  @default null
     */
    open var tabs: Array<dynamic> = definedExternally
    /**
     *  TabBar for this TabSet, an instance of TabBar.
     *  @type {TabBar}
     *  @default null
     */
    open var tabBar: TabBar = definedExternally
    /**
     *  Properties to apply to all Tabs created by this TabSet.
     *  @type {Tab}
     *  @default null
     */
    open var tabProperties: Tab = definedExternally
    /**
     *  If set, is passed as "width" to all tabs when TabSet.tabBarPosition is set to
     *   "top" or "bottom".
     * 
     *   If unset, width will be picked up from
     *   the Tab constructor class defaults. Tabs expand to fit their content, so
     *   this width acts as a minimum.
     *   Setting width:1 will result in tabs that are
     *   only as wide as their titles. May be customized by individual
     *   skinning.
     *  @type {number}
     *  @default null
     */
    open var defaultTabWidth: Number = definedExternally
    /**
     *  If set, is passed as "height" to all tabs when TabSet.tabBarPosition is set to
     *   "left" or "right".
     * 
     *   If unset, height will be picked up from
     *   the Tab constructor class defaults. Note that tabs expand to fit their content so
     *   this height acts as a minimum. May be customized by individual
     *   skinning.
     *  @type {number}
     *  @default null
     */
    open var defaultTabHeight: Number = definedExternally
    /**
     *  Should we use simple button based tabs styled with CSS rather than
     *   image based ImgTab tabs?
     * 
     * 
     *   If set to true the TabSet.simpleTabButtonConstructor will be used and tabs will
     *   by styled according to TabSet.simpleTabBaseStyle.
     * 
     * 
     *  @type {boolean}
     *  @default false
     */
    open var useSimpleTabs: Boolean = definedExternally
    /**
     *  If TabSet.useSimpleTabs is true, simpleTabBaseStyle will be the base style
     *   used to determine the css style to apply to the tabs.
     *   This property will be suffixed with the side on which the tab-bar will appear, followed
     *   by with the tab's state (selected, over, etc), resolving to a className like
     *   "tabButtonTopOver".
     *  @type {CSSStyleName}
     *  @default "tabButton"
     */
    open var simpleTabBaseStyle: String = definedExternally
    /**
     *  If TabSet.useSimpleTabs is true, simpleTabIconOnlyBaseStyle will be the
     *   base style used to determine the css style to apply to the tabs if
     *   Tab.canAdaptWidth is set and the title is not being shown.
     * 
     *   This property will be suffixed with the side on which the tab-bar will appear, followed
     *   by with the tab's state (selected, over, etc), resolving to a className like
     *   "iconOnlyTabButtonTopOver".
     * 
     *   Note that this property is only defined for certain skins, where it's needed. If not
     *   defined, TabSet.simpleTabBaseStyle will serve as base style whether or not the title is
     *   hidden.
     *  @type {CSSStyleName}
     *  @default "varies"
     */
    open var simpleTabIconOnlyBaseStyle: String = definedExternally
    /**
     *  Which side of the TabSet the TabBar should appear on.
     *  @type {Side}
     *  @default "top"
     */
    open var tabBarPosition: 
                             /**
                              *  Left side
                              *  Right side
                              *  Top side
                              *  Bottom side
                              */
                             String /* left |  right |  top |  bottom */ = definedExternally
    /**
     *  Alignment of the tabBar.
     * 
     *   If the TabSet.tabBarPosition is "top" or "bottom", then
     *   this attribute may be set to "left", "right" or "center". The default is "left", or
     *   "right" in Page.isRTL.
     * 
     *   If the TabSet.tabBarPosition is "left" or "right", then this
     *   attribute may be set to "top", "bottom" or "center". The default is "top".
     *  @type {Side | Alignment}
     *  @default "see below"
     */
    open var tabBarAlign: dynamic = definedExternally
    /**
     *  Thickness of tabBar, applies to either orientation (specifies height for horizontal,
     *   width for vertical orientation). Note that overriding this value for TabSets that are
     *   skinned with images generally means providing new media for the borders.
     *  @type {number}
     *  @default "21"
     */
    open var tabBarThickness: Number = definedExternally
    /**
     *  Specifies the index of the initially selected tab.
     *  @type {Tab | Integer}
     *  @default "0"
     */
    open var selectedTab: dynamic = definedExternally
    /**
     *  Should tabs in this tabSet show an icon allowing the user to dismiss the tab by
     *   clicking on it directly. May be overridden for individual tabs by setting
     *   Tab.canClose.
     * 
     *   The URL for this icon's image will be derived from TabSet.closeTabIcon by
     *   default, but may be overridden by explicitly specifying Tab.closeIcon.
     * 
     *   Note: Currently, tabs can only show a single icon, so a closable tab will show
     *   the close icon only even if Tab.icon is set. To work around this, add the icon
     *   as an HTML &lt;img&gt; tag to the Tab.title property, for example:
     * 
     * 
     *    title : "&lt;span&gt;" + isc.Canvas.imgHTML("path/to/icon.png") + " Tab Title&lt;/span&gt;"
     * 
     * 
     * 
     *  @type {boolean}
     *  @default null
     */
    open var canCloseTabs: Boolean = definedExternally
    /**
     *  Default src for the close icon for tabs to display if TabSet.canCloseTabs is true.
     *  @type {SCImgURL}
     *  @default "[SKIN]/TabSet/close.png"
     */
    open var closeTabIcon: String = definedExternally
    /**
     *  Size in pixels of the icon for closing tabs, displayed when TabSet.canCloseTabs is true.
     *  @type {Integer}
     *  @default "16"
     */
    open var closeTabIconSize: Number = definedExternally
    /**
     *  When isc.setScreenReaderMode is enabled and a tab is
     *   TabSet.canCloseTabs, the ariaCloseableSuffix is a string
     *   that is appended to the label of closeable tabs. This suffix is hidden from sighted
     *   users, but is announced by screen readers to indicate that the tab may be closed.
     * 
     *   Set to null to disable appending this suffix.
     *  @type {string}
     *  @default ", closeable"
     */
    open var ariaCloseableSuffix: String = definedExternally
    /**
     *  If true, tabs can be reordered by dragging on them.
     * 
     *   To disallow drag-reorder of a specific tab, see Tab.canReorder.
     *  @type {boolean}
     *  @default null
     */
    open var canReorderTabs: Boolean = definedExternally
    /**
     *  Should tabs exceeding TabSet.moreTabCount be shown on a "more" tab?
     * 
     *   This setting is used to emulate an iPhone-style tab bar "more" button.
     *  @type {boolean}
     *  @default null
     */
    open var showMoreTab: Boolean = definedExternally
    /**
     *  This property defines the number tab buttons that should be shown before
     *   automatically adding a "more" button to handle the remaining tabs. This
     *   property is only used when TabSet.showMoreTab is enabled.
     *  @type {number}
     *  @default "5"
     */
    open var moreTabCount: Number = definedExternally
    /**
     *  Title for the "More" tab.
     *  @type {string}
     *  @default "More"
     */
    open var moreTabTitle: String = definedExternally
    /**
     *  If TabSet.showMoreTab is enabled this property determines the image to display on
     *   the "More" tab button.
     *  @type {SCImgURL}
     *  @default "[SKINIMG]/iOS/more.png"
     */
    open var moreTabImage: String = definedExternally
    /**
     *  Tab to be shown when TabSet.showMoreTab is enabled
     *   more than TabSet.moreTabCount tabs are provided.
     *  @type {Tab}
     *  @default null
     */
    open var moreTab: Tab = definedExternally
    /**
     *  Properties to apply to the "more" tab created by this TabSet.
     *  @type {Tab}
     *  @default null
     */
    open var moreTabProperties: Tab = definedExternally
    /**
     *  Pane contents for the "more" tab based on a VLayout. Typically contains
     *   a NavigationBar and TableView.
     *  @type {VLayout}
     *  @default null
     */
    open var moreTabPane: VLayout = definedExternally
    /**
     *  Properties to apply to the "more" tab's pane created by this TabSet.
     *  @type {Canvas}
     *  @default null
     */
    open var moreTabPaneProperties: Canvas = definedExternally
    /**
     *  Default properties for the "more" tab's pane.
     * 
     *   Currently constructs a VLayout with a NavigationBar and TableView.
     *  @type {Canvas}
     *  @default null
     */
    open var moreTabPaneDefaults: Canvas = definedExternally
    /**
     *  Navigation bar shown in the TabSet.moreTabPane;
     *  @type {NavigationBar}
     *  @default null
     */
    open var moreTabPaneNavBar: NavigationBar = definedExternally
    /**
     *  TableView used to show links to other tabs in the TabSet.moreTabPane;
     *  @type {TableView}
     *  @default null
     */
    open var moreTabPaneTable: TableView = definedExternally
    /**
     *  This property determines what controls should show up after the tabBar for this TabSet.
     *   Standard controls can be included using the strings "tabScroller" and
     *   "tabPicker". These correspond to the TabSet.scroller and TabSet.tabPicker
     *   AutoChildren, respectively. The "tabScroller" standard control shows two
     *   buttons for scrolling through the tabs in order and the "tabPicker" standard
     *   control allows tabs to be picked directly from a menu. The standard controls show up only if
     *   TabSet.showTabScroller or TabSet.showTabPicker is true and there is not
     *   enough space available to show all of the tabs in the tabBar.
     * 
     *   ${isc.DocUtils.linkForExampleId('layout_tabs_custom_controls', 'This sample')} illustrates the usage of this property
     * 
     *   Additional controls can be included by adding any widget to this array. Controls will
     *   show up in the order in which they are specified. For example, the following code would
     *   add a button in the tabBar area, while preserving the normal behavior of the tabScroller
     *   and tabPicker:
     * 
     * 
     *   isc.TabSet.create({
     *     width:300,
     *     tabs : [
     *       { title: "Tab one" }
     *     ],
     *     tabBarControls : [
     *       isc.ImgButton.create({
     *         src:"[SKINIMG]/actions/add.png",
     *         width:16, height:16,
     *         layoutAlign:"center"
     *       }),
     *       "tabScroller", "tabPicker"
     *     ]
     *   });
     * 
     * 
     * 
     *   You can also refer to the default tabPicker/tabScroll controls
     *   from Component XML:
     * 
     *   &lt;TabSet width="300"&gt;
     *     &lt;tabBarControls&gt;
     *       &lt;Button title="Custom Button"/&gt;
     *       &lt;value xsi:type="string"&gt;tabPicker&lt;/value&gt;
     *       &lt;value xsi:type="string"&gt;tabScroller&lt;/value&gt;
     *     &lt;/tabBarControls&gt;
     *     &lt;tabs&gt;
     *       &lt;tab title="Foo"/&gt;
     *       &lt;tab title="Bar"/&gt;
     *     &lt;/tabs&gt;
     *   &lt;/TabSet&gt;
     * 
     * 
     *   When Browser.isTouch is true and native touch scrolling is supported,
     *   then by default, only the "tabPicker" is shown. The "tabScroller"
     *   control is omitted by default on touch devices because the tabs in the tab bar are native
     *   touch-scrollable, so the "tabScroller" control is unnecessary. To override
     *   the omission of the "tabScroller", simply add
     *   "tabScroller"
     * 
     *   to the tabBarControls array.
     *  @type {Array<any>}
     *  @default ""tabScroller"|"tabPicker"|Canvas"
     */
    open var tabBarControls: Array<dynamic> = definedExternally
    /**
     *  If there is not enough space to display all the tab-buttons in this tabSet, should
     *   scroll buttons be displayed to allow access to tabs that are clipped? If unset,
     *   defaults to false for Browser.isHandset and true otherwise.
     *  @type {boolean}
     *  @default null
     */
    open var showTabScroller: Boolean = definedExternally
    /**
     *  If there is not enough space to display all the tab-buttons in this tabSet, should
     *   a drop-down "picker" be displayed to allow selection of tabs that are clipped?
     *  @type {boolean}
     *  @default true
     */
    open var showTabPicker: Boolean = definedExternally
    /**
     *  AutoChild of type Layout that holds the TabSet.tabBarControls as well as
     *   the built-in controls such as the TabSet.showTabPicker.
     *  @type {Layout}
     *  @default null
     */
    open var tabBarControlLayout: Layout = definedExternally
    /**
     *  If TabSet.showTabScroller is true, should tabs be scrolled into view via an
     *   animation when the user interacts with the scroller buttons?
     *  @type {boolean}
     *  @default true
     */
    open var animateTabScrolling: Boolean = definedExternally
    /**
     *  A component containing back and forward buttons for scrolling through all of the tabs
     *   of the TabSet. The scroller is created automatically when needed and when "tabScroller"
     *   is specified in the TabSet.tabBarControls.
     * 
     *   By default, the scroller constructor is StretchImgButton. Note that the scroller
     *   StretchImg.items are determined automatically, so any items set in
     *   scrollerProperties will be ignored.
     *  @type {StretchImgButton}
     *  @default null
     */
    open var scroller: StretchImgButton = definedExternally
    /**
     *  If TabSet.showTabScroller is true, this property governs the size of scroller
     *   buttons. Applied as the width of buttons if the tabBar is horizontal, or the height
     *   if tabBar is vertical. Note that the other dimension is determined by
     *   TabSet.tabBarThickness
     *  @type {number}
     *  @default "16"
     */
    open var scrollerButtonSize: Number = definedExternally
    /**
     *  A button control that allows tabs to be picked directly from a popup menu. The tabPicker
     *   is created automatically when needed and when "tabPicker" is specified in
     *   the TabSet.tabBarControls.
     *  @type {ImgButton}
     *  @default null
     */
    open var tabPicker: ImgButton = definedExternally
    /**
     *  If TabSet.showTabPicker is true and Browser.isTouch
     *   is false, this property governs the size of the tab picker button. This value
     *   is applied as the width of the tab picker button if the TabSet.tabBar is
     *   horizontal, or the height if the tabBar is vertical. Note that the other
     *   dimension is determined by TabSet.tabBarThickness.
     * 
     *   On touch browsers (where Browser.isTouch is true),
     *   TabSet.touchPickerButtonSize is used instead.
     *  @type {Integer}
     *  @default "16"
     */
    open var pickerButtonSize: Number = definedExternally
    /**
     *  The size of the tab picker button when Browser.isTouch is true.
     *  @type {Integer}
     *  @default "16"
     */
    open var touchPickerButtonSize: Number = definedExternally
    /**
     *  Default directory for skin images (those defined by the class), relative to the
     *   Page-wide Page.getSkinDir.
     *  @type {SCImgURL}
     *  @default "images/TabSet/"
     */
    override var skinImgDir: String = definedExternally
    /**
     *  If this TabSet is showing TabSet.showTabScroller, this property
     *   determines whether the TabSet.scrollerHSrc and TabSet.scrollerVSrc media
     *   will be used for vertical and horizontal tab-bar scroller buttons, or whether separate
     *   media should be used for each possible TabSet.tabBarPosition based
     *   on the TabSet.scrollerSrc property for this tabSet.
     *  @type {boolean}
     *  @default true
     */
    open var symmetricScroller: Boolean = definedExternally
    /**
     *  If this TabSet is showing TabSet.showTabScroller, and
     *   TabSet.symmetricScroller is false, this property governs the base
     *   URL for the tab bar back and forward scroller button images.
     * 
     *   Note that if TabSet.symmetricScroller is true,
     *   TabSet.scrollerHSrc and TabSet.scrollerVSrc will be used instead.
     * 
     *   To get the path to the image to display, this base URL will be modified as follows:
     * 
     * 
     *  - If appropriate a state suffix of "Down" or "Disabled" will be
     *     appended.
     * 
     *  - The TabSet.tabBarPosition for this tabSet will be appended.
     * 
     *  - A suffix of "forward" or "back" will be appended for the
     *     forward or backward scrolling button.
     * 
     *   For example - if the scrollerSrc is set to "[SKIN]scroll.gif", the image
     *   displayed for the back-scroller button on a tabSet with tabBarPosition set to
     *   "top" and symmetricScroller set to false would be one of
     *   "[SKIN]scroll_top_back.gif", "[SKIN]scroll_Down_top_back.gif",
     *   and "[SKIN]scroll_Disabled_top_back.gif".
     * 
     *   Note that for best results the media should be sized to match the scroller button sizes,
     *   determined by TabSet.tabBarThickness and TabSet.scrollerButtonSize.
     *  @type {SCImgURL}
     *  @default "[SKIN]/scroll.gif"
     */
    open var scrollerSrc: String = definedExternally
    /**
     *  If this TabSet is showing TabSet.showTabScroller, and
     *   TabSet.symmetricScroller is true, this property governs the base
     *   URL for the tab bar back and forward scroller button images for horizontal tab bars [IE for
     *   tab sets with TabSet.tabBarPosition set to "top" or "bottom"].
     * 
     *   Note that if TabSet.symmetricScroller is false,
     *   TabSet.scrollerSrc will be used instead.
     * 
     *   To get the path to the image to display, this base URL will be modified as follows:
     * 
     * 
     *  - If appropriate a state suffix of "Down" or "Disabled" will be
     *     appended.
     * 
     *  - A suffix of "forward" or "back" will be appended for the
     *     forward or backward scrolling button.
     * 
     *   For example - if the scrollerHSrc is set to "[SKIN]hscroll.gif", the image
     *   displayed for the back-scroller button on a tabSet with tabBarPosition set to
     *   "top" and symmetricScroller set to true would be one of
     *   "[SKIN]hscroll_back.gif", "[SKIN]hscroll_Down_back.gif",
     *   and "[SKIN]hscroll_Disabled_back.gif".
     * 
     *   Note that for best results the media should be sized to match the scroller button sizes,
     *   determined by TabSet.tabBarThickness and TabSet.scrollerButtonSize.
     *  @type {SCImgURL}
     *  @default "[SKIN]hscroll.gif"
     */
    open var scrollerHSrc: String = definedExternally
    /**
     *  If this TabSet is showing TabSet.showTabScroller, and
     *   TabSet.symmetricScroller is true, this property governs the base
     *   URL for the tab bar back and forward scroller button images for vertical tab bars [IE for
     *   tab sets with TabSet.tabBarPosition set to "left" or "right"].
     * 
     *   Note that if TabSet.symmetricScroller is false,
     *   TabSet.scrollerSrc will be used instead.
     * 
     *   To get the path to the image to display, this base URL will be modified as follows:
     * 
     * 
     *  - If appropriate a state suffix of "Down" or "Disabled" will be
     *     appended.
     * 
     *  - A suffix of "forward" or "back" will be appended for the
     *     forward or backward scrolling button.
     * 
     *   For example - if the scrollerVSrc is set to "[SKIN]vscroll.gif", the image
     *   displayed for the back-scroller button on a tabSet with tabBarPosition set to
     *   "left" and symmetricScroller set to true would be one of
     *   "[SKIN]vscroll_back.gif", "[SKIN]vscroll_Down_back.gif",
     *   and "[SKIN]vscroll_Disabled_back.gif".
     * 
     *   Note that for best results the media should be sized to match the scroller button sizes,
     *   determined by TabSet.tabBarThickness and TabSet.scrollerButtonSize.
     *  @type {SCImgURL}
     *  @default "[SKIN]vscroll.gif"
     */
    open var scrollerVSrc: String = definedExternally
    /**
     *  If this TabSet is showing a TabSet.showTabPicker, this
     *   property determines whether the TabSet.pickerButtonHSrc and
     *   TabSet.pickerButtonVSrc media will be used for vertical and horizontal tab-bar
     *   picker buttons, or whether separate media should be used for each possible
     *   TabSet.tabBarPosition based on the TabSet.pickerButtonSrc
     *   property for this tabSet.
     *  @type {boolean}
     *  @default true
     */
    open var symmetricPickerButton: Boolean = definedExternally
    /**
     *  If TabSet.showTabPicker is true, this property governs the base URL for the picker
     *   button image, when TabSet.symmetricPickerButton is set to false
     * 
     *   Note that if symmetricPickerButton is true, the TabSet.pickerButtonHSrc
     *   and TabSet.pickerButtonVSrc properties will be used instead.
     * 
     *   To get the path to the image to display, this base URL will be modified as follows:
     * 
     * 
     *  - If appropriate a state suffix of "Down" or "Disabled" will be
     *     appended.
     * 
     *  - The TabSet.tabBarPosition for this tabSet will be appended.
     * 
     *  @type {SCImgURL}
     *  @default "[SKIN]/picker.gif"
     */
    open var pickerButtonSrc: String = definedExternally
    /**
     *  If TabSet.showTabPicker is true, and TabSet.symmetricPickerButton is
     *   set to true, this property governs the base URL for the picker
     *   button image, when displayed in a horizontal tab-bar [IE TabSet.tabBarPosition is
     *   set to "top" or "bottom"].
     * 
     *   Note that if symmetricPickerButton is false, the TabSet.pickerButtonSrc
     *   property will be used instead.
     * 
     *   This base URL will have a suffix of "Down" appended when the user holds the
     *   mouse down over the button, and "Disabled" if the tabset as a whole is
     *   disabled.
     *  @type {SCImgURL}
     *  @default "[SKIN]hpicker.gif"
     */
    open var pickerButtonHSrc: String = definedExternally
    /**
     *  If TabSet.showTabPicker is true, and TabSet.symmetricPickerButton is
     *   set to true, this property governs the base URL for the picker
     *   button image, when displayed in a verricaL tab-bar [IE TabSet.tabBarPosition is
     *   set to "LEFT" or "right"].
     * 
     *   Note that if symmetricPickerButton is false, the TabSet.pickerButtonSrc
     *   property will be used instead.
     * 
     *   This base URL will have a suffix of "Down" appended when the user holds the
     *   mouse down over the button, and "Disabled" if the tabset as a whole is
     *   disabled.
     *  @type {SCImgURL}
     *  @default "[SKIN]vpicker.gif"
     */
    open var pickerButtonVSrc: String = definedExternally
    /**
     *  Container where the component specified by Tab.pane is shown.
     * 
     *   Note: paneContainer and showEdges:true for rounded tabsets: you can enable decorative
     *   image-based edges on the paneContainer by setting Canvas.showEdges
     *   via paneContainerDefaults (to skin all tabsets) or paneContainerProperties (to use
     *   edges on one instance). In this structure, the baseLine should use media
     *   that matches the appearance of the decorative edges and fully overlaps the edge of the
     *   paneContainer that it is adjacent to. In the most typical appearance (symmetric edges
     *   on all 4 sides), both TabBar.baseLineCapSize and TabBar.baseLineThickness
     *   match the Canvas.edgeSize set on the paneContainer. See the
     *   load_skin.js file for the "SmartClient" skin for an example of setting all relevant
     *   properties.
     * 
     *   To disable edges for a particular TabSet, which you may want to do for a TabSet that
     *   is already within a clearly defined container, configure the paneContainer to show only
     *   it's top edge:
     * 
     *     paneContainerProperties : { customEdges:["T"] },
     * 
     *   To completely flatten even the top edge of the TabSet:
     * 
     *     paneContainerProperties : { customEdges:["T"] },
     *     tabBarProperties :{ baseLineCapSize:0 },
     * 
     *   This "flattens" the baseLine so that only the center image is used.
     *  @type {VLayout}
     *  @default null
     */
    open var paneContainer: VLayout = definedExternally
    /**
     *  CSS style used for the paneContainer.
     *  @type {CSSStyleName}
     *  @default null
     */
    open var paneContainerClassName: String = definedExternally
    /**
     *  Specifies the overflow of the pane container (the component that holds the pane contents
     *   for all tabs). By default this is set to "auto", meaning the pane container will
     *   automatically introduce scrolling when the pane contents exceed the TabSet's specified
     *   size.
     * 
     *   For other values and their meaning, see Overflow
     *  @type {Overflow}
     *  @default "auto"
     */
    open var paneContainerOverflow: 
                                    /**
                                     *  Content that extends beyond the widget's width or height is               displayed.
                                     *                 Note: To have the content be sized only by the drawn size of
                                     *                 the content set the overflow to be Canvas.VISIBLE and specify
                                     *                 a small size, allowing the size to expand to the size required
                                     *                 by the content.
                                     *                 Leaving the width / height for the widget undefined will use the
                                     *                 default value of 100, and setting the size to zero may cause the
                                     *                 widget not to draw.
                                     *  Content that extends beyond the widget's width or height is               clipped (hidden).
                                     *  Horizontal and/or vertical scrollbars are displayed only if               necessary. Content that extends beyond the remaining visible
                                     *                 area is clipped.
                                     *  Horizontal and vertical scrollbars are always drawn inside the               widget. Content that extends beyond the remaining visible area
                                     *                 is clipped, and can be accessed via scrolling.
                                     *  Clip horizontally but extend the canvas's clip region               vertically if necessary. Note: only supported for
                                     *                 specific widget subclasses.
                                     *  Clip vertically but extend the canvas's clip region               horizontally if necessary. Note: only supported
                                     *                 for specific widget subclasses.
                                     */
                                    String /* visible |  hidden |  auto |  scroll |  clip-h |  clip-v */ = definedExternally
    /**
     *  If this tabSet will TabSet.showPaneContainerEdges for the paneContainer,
     *   this property determines whether the same edge media will be used regardless of the tab
     *   bar position, or whether different media should be used (necessary if the edge appearance is
     *   not symmetrical on all sides).
     * 
     *   If this property is set to false the paneContainer edge image URLs will be prefixed with
     *   the tabBarPosition of the tabSet - for example "[SKIN]edge_top_T.gif" rather
     *   than just "[SKIN]edge_T.gif".
     * 
     *   When symmetricEdges is false, custom edge sizes for the pane container may be
     *   specified via TabSet.topEdgeSizes et al, and custom edge offsets via
     *   TabSet.topEdgeOffsets et al.
     *  @type {boolean}
     *  @default true
     */
    open var symmetricEdges: Boolean = definedExternally
    /**
     *  If this tabSet will TabSet.showPaneContainerEdges for the paneContainer,
     *   and TabSet.symmetricEdges is set to false, the leftEdgeSizes,
     *   rightEdgeSizes, topEdgeSizes and bottomEdgeSizes
     *   properties allow the sizes of edges for the paneContainer to be customized depending on
     *   the TabSet.tabBarPosition.
     * 
     *   The attribute should be specified an EdgeSizes, specifying the
     *   desired edge sizes where for the appropriate TabSet.tabBarPosition.
     *  @type {EdgeSizes}
     *  @default null
     */
    open var leftEdgeSizes: dynamic = definedExternally
    /**
     *  If this tabSet will TabSet.showPaneContainerEdges for the paneContainer,
     *   and TabSet.symmetricEdges is set to false, the leftEdgeSizes,
     *   rightEdgeSizes, topEdgeSizes and bottomEdgeSizes
     *   properties allow the sizes of edges for the paneContainer to be customized depending on
     *   the TabSet.tabBarPosition.
     * 
     *   The attribute should be specified an EdgeSizes, specifying the
     *   desired edge sizes where for the appropriate TabSet.tabBarPosition.
     *  @type {EdgeSizes}
     *  @default null
     */
    open var topEdgeSizes: dynamic = definedExternally
    /**
     *  If this tabSet will TabSet.showPaneContainerEdges for the paneContainer,
     *   and TabSet.symmetricEdges is set to false, the leftEdgeSizes,
     *   rightEdgeSizes, topEdgeSizes and bottomEdgeSizes
     *   properties allow the sizes of edges for the paneContainer to be customized depending on
     *   the TabSet.tabBarPosition.
     * 
     *   The attribute should be specified an EdgeSizes, specifying the
     *   desired edge sizes where for the appropriate TabSet.tabBarPosition.
     *  @type {EdgeSizes}
     *  @default null
     */
    open var bottomEdgeSizes: dynamic = definedExternally
    /**
     *  If this tabSet will TabSet.showPaneContainerEdges for the paneContainer,
     *   and TabSet.symmetricEdges is set to false, the leftEdgeSizes,
     *   rightEdgeSizes, topEdgeSizes and bottomEdgeSizes
     *   properties allow the sizes of edges for the paneContainer to be customized depending on
     *   the TabSet.tabBarPosition.
     * 
     *   The attribute should be specified an EdgeSizes, specifying the
     *   desired edge sizes where for the appropriate TabSet.tabBarPosition.
     *  @type {EdgeSizes}
     *  @default null
     */
    open var rightEdgeSizes: dynamic = definedExternally
    /**
     *  If this tabSet will TabSet.showPaneContainerEdges for the paneContainer,
     *   and TabSet.symmetricEdges is set to false, the leftEdgeOffsets,
     *   rightEdgeOffsets, topEdgeOffsets and bottomEdgeOffsets
     *   properties allow the offsets of edges for the paneContainer to be customized depending on
     *   the TabSet.tabBarPosition.
     * 
     *   The attribute should be specified an EdgeSizes, specifying the
     *   desired edge offsets where for the appropriate TabSet.tabBarPosition.
     *  @type {EdgeSizes}
     *  @default null
     */
    open var leftEdgeOffsets: dynamic = definedExternally
    /**
     *  If this tabSet will TabSet.showPaneContainerEdges for the paneContainer,
     *   and TabSet.symmetricEdges is set to false, the leftEdgeOffsets,
     *   rightEdgeOffsets, topEdgeOffsets and bottomEdgeOffsets
     *   properties allow the offsets of edges for the paneContainer to be customized depending on
     *   the TabSet.tabBarPosition.
     * 
     *   The attribute should be specified an EdgeSizes, specifying the
     *   desired edge offsets where for the appropriate TabSet.tabBarPosition.
     *  @type {EdgeSizes}
     *  @default null
     */
    open var rightEdgeOffsets: dynamic = definedExternally
    /**
     *  If this tabSet will TabSet.showPaneContainerEdges for the paneContainer,
     *   and TabSet.symmetricEdges is set to false, the leftEdgeOffsets,
     *   rightEdgeOffsets, topEdgeOffsets and bottomEdgeOffsets
     *   properties allow the offsets of edges for the paneContainer to be customized depending on
     *   the TabSet.tabBarPosition.
     * 
     *   The attribute should be specified an EdgeSizes, specifying the
     *   desired edge offsets where for the appropriate TabSet.tabBarPosition.
     *  @type {EdgeSizes}
     *  @default null
     */
    open var topEdgeOffsets: dynamic = definedExternally
    /**
     *  If this tabSet will TabSet.showPaneContainerEdges for the paneContainer,
     *   and TabSet.symmetricEdges is set to false, the leftEdgeOffsets,
     *   rightEdgeOffsets, topEdgeOffsets and bottomEdgeOffsets
     *   properties allow the offsets of edges for the paneContainer to be customized depending on
     *   the TabSet.tabBarPosition.
     * 
     *   The attribute should be specified an EdgeSizes, specifying the
     *   desired edge offsets where for the appropriate TabSet.tabBarPosition.
     *  @type {EdgeSizes}
     *  @default null
     */
    open var bottomEdgeOffsets: dynamic = definedExternally
    /**
     *  Should the paneContainer for this tabset show Canvas.showEdges.
     *  @type {boolean}
     *  @default null
     */
    open var showPaneContainerEdges: Boolean = definedExternally
    /**
     *  Space to leave around the panes in our paneContainer
     * 
     *   Note that this property may be specified on a per-tab basis via Tab.paneMargin.
     *  @type {Integer}
     *  @default "0"
     */
    open var paneMargin: Number = definedExternally
    /**
     *  If true, users can edit the titles of tabs in this TabSet when the
     *   TabSet.titleEditEvent fires. You can override this behavior per tab
     *   with the Tab.canEditTitle property.
     * 
     *   Note that this TabSet's TabSet.titleEditEvent must be set to a
     *   supported TabTitleEditEvent in order for users to be able to edit the titles of
     *   tabs.
     *  @type {boolean}
     *  @default false
     */
    open var canEditTabTitles: Boolean = definedExternally
    /**
     *  The event that triggers title editing on this TabSet.
     *  @type {TabTitleEditEvent}
     *  @default null
     */
    open var titleEditEvent: 
                             /**
                              *  Start editing when the user single-clicks a tab title
                              *  Start editing when the user double-clicks a tab title
                              */
                             String /* click |  doubleClick */ = definedExternally
    /**
     *  TextItem we use to edit tab titles in this TabSet. You can override this property
     *   using the normal AutoChild facilities.
     *  @type {TextItem}
     *  @default null
     */
    open var titleEditor: TextItem = definedExternally
    /**
     *  Properties for the auto-generated TabSet.titleEditor. This is the text item
     *   we use to edit tab titles in this tabSet.
     *  @type {TextItem}
     *  @default null
     */
    open var titleEditorProperties: TextItem = definedExternally
    /**
     *  If set, offsets the tab title editor further in from the left-hand edge of the tab, by
     *   the number of pixels set in this property. Note that the editor is always offset to
     *   avoid overlapping the endcaps of the tab; this property is applied on top of that
     *   default offset.
     *  @type {Integer}
     *  @default null
     */
    open var titleEditorLeftOffset: Number = definedExternally
    /**
     *  If set, offsets the tab title editor further in from the right-hand edge of the tab, by
     *   the number of pixels set in this property. Note that the editor is always offset to
     *   avoid overlapping the endcaps of the tab; this property is applied on top of that
     *   default offset.
     *  @type {Integer}
     *  @default null
     */
    open var titleEditorRightOffset: Number = definedExternally
    /**
     *  If set, offsets the tab title editor further down from the top edge of the tab, by the
     *   number of pixels set in this property. You can use this property, together with the
     *   left and right offset properties, to fine tune positioning of the editor within or
     *   around the tab button.
     *   Note: The height of the editor is an attribute of the editor itself, and can be
     *   set by specifying a "height" property in TabSet.titleEditor.
     *  @type {Integer}
     *  @default null
     */
    open var titleEditorTopOffset: Number = definedExternally
    /**
     *  Setting this to true turns on a different appearance for tabs, similar to iOS tabs from
     *   the "Music" app, where the tab.icon is enlarged and shown as a black and white mask.
     *   This mode does not support a clickable icon - clicking the enlarged icon just switches
     *   tabs.
     * 
     *   This attribute only has an effect for tabs that are not Tab.canClose,
     *   and only for Mobile WebKit.
     *  @type {boolean}
     *  @default false
     */
    open var useIOSTabs: Boolean = definedExternally
    /**
     *  Causes the TabSet.addTabButton to appear after the TabSet.tabs and before the
     *   TabSet.tabBarControls.
     * 
     *   There is no default behavior for what happens when the addTabButton is
     *   clicked. Add a handler for the TabSet.addTabClicked event to implement a behavior.
     *  @type {boolean}
     *  @default null
     */
    open var canAddTabs: Boolean = definedExternally
    /**
     *  Appears when TabSet.canAddTabs is enabled.
     *  @type {ImgButton}
     *  @default null
     */
    open var addTabButton: ImgButton = definedExternally
    /**
     *  Icon for the TabSet.addTabButton.
     *  @type {SCImgURL}
     *  @default "[SKIN]actions/add.png"
     */
    open var addTabButtonIcon: String = definedExternally
    /**
     *  Should the tabBar be displayed or not
     *   If shrinkElementOnHide is true, the paneContainer will expand over the space
     *   occupied by TabBar
     *  @type {boolean}
     *  @default true
     */
    open var showTabBar: Boolean = definedExternally
    /**
     *  Tab button constructor if TabSet.useSimpleTabs is true.
     *  @type {Class}
     *  @default "SimpleTabButton"
     */
    open var simpleTabButtonConstructor: Class = definedExternally
    /**
     *  This attribute allows developers to specify custom properties for this tabset's
     *   TabSet.tabBar
     *  @type {TabBar}
     *  @default null
     */
    open var tabBarProperties: TabBar = definedExternally
    /**
     *  If the paneContainer for this tab set is showing Canvas.showEdges, setting this
     *   attribute to true will set the paneContainer to show
     *   Canvas.customEdges for the three sides opposing the tabBarPosition.
     *  @type {boolean}
     *  @default false
     */
    open var showPartialEdges: Boolean = definedExternally
    /**
     *  Whether Canvas.destroy should be called on Tab.pane when it a tab is
     *   removed via TabSet.removeTab.
     * 
     *   With the default setting of null panes will be automatically destroyed.
     *   An application might set this to false in order to re-use panes in different tabs or in
     *   different parts of the application.
     *  @type {boolean}
     *  @default null
     */
    open var destroyPanes: Boolean = definedExternally
    /**
     *  When AutoTest.getElement is used to parse locator strings generated by
     *   AutoTest.getLocator, how should tabs within this tabset be identified?
     *   By default if tab has a specified Tab.ID this will always be used.
     *   For tabs with no ID, the following options are available:
     * 
     * 
     *  - "title" use the title as an identifier
     * 
     *  - "index" use the index of the tab in the tabset as an identifier
     * 
     * 
     *   If unset, and the tab has no specified ID, default behavior is to
     *   identify by title (if available), otherwise by index.
     *  @type {string}
     *  @default null
     */
    open var locateTabsBy: String = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "TabSetEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
    /**
     *   Update TabSet.paneContainerOverflow after creation.
     * 
     * 
     *  @param {Overflow} new overflow setting
     */
    open fun setPaneContainerOverflow(newOverflow: 
                                                   /**
                                                    *  Content that extends beyond the widget's width or height is               displayed.
                                                    *                 Note: To have the content be sized only by the drawn size of
                                                    *                 the content set the overflow to be Canvas.VISIBLE and specify
                                                    *                 a small size, allowing the size to expand to the size required
                                                    *                 by the content.
                                                    *                 Leaving the width / height for the widget undefined will use the
                                                    *                 default value of 100, and setting the size to zero may cause the
                                                    *                 widget not to draw.
                                                    *  Content that extends beyond the widget's width or height is               clipped (hidden).
                                                    *  Horizontal and/or vertical scrollbars are displayed only if               necessary. Content that extends beyond the remaining visible
                                                    *                 area is clipped.
                                                    *  Horizontal and vertical scrollbars are always drawn inside the               widget. Content that extends beyond the remaining visible area
                                                    *                 is clipped, and can be accessed via scrolling.
                                                    *  Clip horizontally but extend the canvas's clip region               vertically if necessary. Note: only supported for
                                                    *                 specific widget subclasses.
                                                    *  Clip vertically but extend the canvas's clip region               horizontally if necessary. Note: only supported
                                                    *                 for specific widget subclasses.
                                                    */
                                                   String /* visible |  hidden |  auto |  scroll |  clip-h |  clip-v */): Unit = definedExternally
    /**
     *   If the paneContainer for this tab set is showing Canvas.showEdges, this
     *   method can be used to specify (dynamically) which Canvas.customEdges to
     *   show. Called when the pane creator is created.
     * 
     *   Default implementation will return null unless TabSet.showPartialEdges
     *   is true, in which case it will return the three edges opposite the
     *   TabSet.tabBarPosition.
     * 
     */
    open fun getPaneContainerEdges(): Array<dynamic> = definedExternally
    /**
     *   Changes the title of a tab
     * 
     *  @param {Tab | number | GlobalId | TabName} \* @param {HTMLString} new title
     */
    open fun setTabTitle(tab: dynamic, title: String): Unit = definedExternally
    /**
     *   Changes the icon for a tab
     * 
     *  @param {Tab | number | GlobalId | TabName} tab to update
     *  @param {SCImgURL} new icon
     */
    open fun setTabIcon(tab: dynamic, icon: String): Unit = definedExternally
    /**
     *   If the specified tab is disabled, enable it now.
     * 
     * \* @param {Tab | number | GlobalId | TabName} 
     */
    open fun enableTab(tab: dynamic): Unit = definedExternally
    /**
     *   If the specified tab is enabled, disable it now.
     * 
     * \* @param {Tab | number | GlobalId | TabName} 
     */
    open fun disableTab(tab: dynamic): Unit = definedExternally
    /**
     *   Apply properties to an existing tab in a tabSet.
     * 
     *  @param {Tab | number | GlobalId | TabName} Identifier for the tab to be modified
     *  @param {object} Javascript object containing the set of properties to be applied to the tab.
     */
    open fun setTabProperties(tab: dynamic, properties: dynamic): Unit = definedExternally
    /**
     *   Add a tab
     * 
     *  @param {Tab} new tab
     *  @param {number=} position where tab should be added
     */
    open fun addTab(tab: Tab, position: Number?): Unit = definedExternally
    /**
     *   Add one or more tabs
     * 
     *  @param {Tab | Array<Partial<Tab>>} new tab or tabs
     *  @param {number} position where tab should be added (or array of positions)
     */
    open fun addTabs(tabs: dynamic, position: Number): Unit = definedExternally
    /**
     *   Apply a new Tab.pane to an existing tab in this tabSet
     * 
     *  @param {number | string | Tab} Tab to update (may be referenced by ID or index)
     *  @param {Canvas} new Pane for the tab
     */
    open fun setTabPane(tab: dynamic, pane: Canvas): Unit = definedExternally
    /**
     *   Remove a tab.
     * 
     *   The pane associated with the removed tab is automatically destroyed when you
     *   call this method. To avoid this, call TabSet.updateTab with null as the new
     *   pane immediately before removing the tab, or set TabSet.destroyPanes to false.
     * 
     * 
     *  @param {Tab | GlobalId | TabName | number | Array<Partial<Tab>>} list of tabs, tabIDs,                                    or tab numbers
     */
    open fun removeTab(tabs: dynamic): Unit = definedExternally
    /**
     *   Remove one or more tabs. The pane(s) associated with the removed tab(s) is automatically
     *   destroyed when you call this method.
     * 
     * 
     *  @param {Tab | GlobalId | TabName | number} list of tabs, tabIDs, tab names, or                             tab numbers
     */
    open fun removeTabs(tabs: dynamic): Unit = definedExternally
    /**
     *   Removes the last tab in the TabSet, excluding the TabSet.moreTab if present.
     * 
     */
    open fun removeLastTab(): Unit = definedExternally
    /**
     *   Move a tab to another location in the tabset.
     * 
     *  @param {Tab | GlobalId | TabName | number} tab to move
     *  @param {number=} the index to move the tab to - defaults to the end of the                 tabset if not passed
     */
    open fun reorderTab(tab: dynamic, moveToPosition: Number?): Unit = definedExternally
    /**
     *   Sets the given tab's Tab.canClose property to the boolean parameter canClose.
     *   If canClose is null, this will have the effect of causing the tab to fall back on TabSet.canCloseTabs.
     * 
     *  @param {Tab | GlobalId | TabName | number} tab to change
     *  @param {boolean} new value for the tab's canClose property, or null to clear it
     */
    open fun setCanCloseTab(tab: dynamic, canClose: Boolean): Unit = definedExternally
    /**
     *   Changes this TabSet's TabSet.canCloseTabs property.
     * 
     *  @param {boolean} the new value for canCloseTabs.
     */
    open fun setCanCloseTabs(canCloseTabs: Boolean): Unit = definedExternally
    /**
     *   When TabSet.canCloseTabs is set, method fired when the user clicks the "close" icon for a
     *   tab.
     * 
     *   Default implementation will remove the tab from the tabSet via TabSet.removeTab.
     * 
     * 
     *  @param {Tab} tab to close
     */
    open fun closeClick(tab: Tab): Unit = definedExternally
    /**
     *   Method fired when the user clicks the icon for a tab, as specified via Tab.icon.
     * 
     *   Default behavior will fire icon.click() if specified, with two parameters
     *   tab (a pointer to the tab object and tabSet a pointer to the tabSet
     *   instance.
     * 
     *  @param {Tab} with click handler being fired
     */
    open fun tabIconClick(tab: Tab): Unit = definedExternally
    /**
     *   Get the tab Object originally passed to TabSet.tabs, by index, name or ID.
     *   If passed a tab Object, just returns it.
     * 
     * 
     * \* @param {Integer | GlobalId | TabName | Tab} 
     */
    open fun getTabObject(tab: dynamic): Tab = definedExternally
    /**
     *   Get the live Canvas representing a tab by index, ID, reference, or name.
     *   If passed a tab Canvas, just returns it.
     * 
     *   Note that live Tab instances are not available until Canvas.draw.
     * 
     *   The returned Tab is considered an internal component of the TabSet. In order to maximize
     *   forward compatibility, manipulate tabs through APIs such as a TabSet.setTabTitle instead.
     *   Also note that a super-lightweight TabSet implementation may not use a separate Canvas per
     *   Tab, and code that accesses and manipulates Tabs as Canvases won't be compatible with that
     *   implementation.
     * 
     * 
     * \* @param {Integer | GlobalId | TabName | Canvas} 
     */
    open fun getTab(tab: dynamic): StatefulCanvas = definedExternally
    /**
     *   Returns the pane for a given tab.
     * 
     * 
     * \* @param {object | number | GlobalId | TabName | Tab} 
     */
    open fun getTabPane(tab: dynamic): Canvas = definedExternally
    /**
     *   Get the index of a tab, from the tab, tab ID or tab name. If passed a number, just returns it.
     * 
     * \* @param {number | GlobalId | TabName | Tab} 
     */
    open fun getTabNumber(tab: dynamic): Number = definedExternally
    /**
     *   Set the pane for a tab.
     * 
     *   Pass in the index of a tab (or a tab object), and a new pane.
     * 
     *   NOTE: the old pane for the tab is not destroy()d
     * 
     * 
     *  @param {number | GlobalId | TabName | Tab} tab to update
     *  @param {Canvas | GlobalId} new pane for the tab
     */
    open fun updateTab(tab: dynamic, pane: dynamic): Unit = definedExternally
    /**
     *   Reveals the child Canvas passed in by selecting the tab containing that child if it is not
     *   already selected. If no tab in this TabSet contains the passed-in Canvas, this method has
     *   no effect
     * 
     * 
     *  @param {GlobalId | Canvas} the child Canvas to reveal, or its global ID
     */
    override fun revealChild(child: dynamic): Unit = definedExternally
    /**
     *   If there is not enough space to display all the tabs in this tabSet, this method will
     *   scroll the next tab (that first tab that is clipped at the end of the tab-bar) into view.
     * 
     */
    open fun scrollForward(): Unit = definedExternally
    /**
     *   If there is not enough space to display all the tabs in this tabSet, this method will
     *   scroll the previous tab (that first tab that is clipped at the beginning of the tab-bar)
     *   into view.
     * 
     */
    open fun scrollBack(): Unit = definedExternally
    /**
     *   Returns the currently selected tab object. This is the object literal used to configure the
     *   tab, rather than the tab button widget.
     * 
     */
    open fun getSelectedTab(): Tab = definedExternally
    /**
     *   Returns the index of the currently selected tab object.
     * 
     */
    open fun getSelectedTabNumber(): Number = definedExternally
    /**
     *   Select a tab
     * 
     *  @param {number | GlobalId | TabName | Tab} tab to select
     */
    open fun selectTab(tab: dynamic): Unit = definedExternally
    /**
     *  Search for a tab that contains a pane.
     * 
     *  @param {Canvas} pane to show
     */
    open fun tabForPane(pane: Canvas): Tab = definedExternally
    /**
     *   Places an editor in the title of the parameter tab and allows the user to edit the title.
     *   Note that this programmatic method will always allow editing of the specified tab's
     *   title, regardless of the settings of TabSet.canEditTabTitles or Tab.canEditTitle.
     * 
     *  @param {Tab | string | Integer} The tab whose title should be edited (may be  specified by ID or index)
     */
    open fun editTabTitle(tab: dynamic): Unit = definedExternally
    /**
     *   If the user is currently editing a tab title (see TabSet.canEditTabTitles), dismiss
     *   the editor and discard the edit value entered by the user.
     * 
     */
    open fun cancelTabTitleEditing(): Unit = definedExternally
    /**
     *   If the user is currently editing a tab title (see TabSet.canEditTabTitles), save
     *   the edited tab title and hide the editor.
     * 
     */
    open fun saveTabTitle(): Unit = definedExternally
    /**
     *   Event that fires when the TabSet.addTabButton is clicked.
     *   No default behavior.
     * 
     * 
     */
    open fun addTabClicked(): Unit = definedExternally
    /**
     *   Notification fired when a tab is selected. Note that this will only fire if
     *   this tabSet is drawn. If a tab is selected before TabSet.draw()
     *   is called, the tabSelected() notification will fire on
     *   draw()
     * 
     *  @param {number} number of the tab
     *  @param {Canvas} pane for this tab
     *  @param {GlobalId} id of the tab
     *  @param {Tab} the tab object (not tab button instance)
     *  @param {string} the name of the newly selected tab
     */
    open fun tabSelected(tabNum: Number, tabPane: Canvas, ID: String, tab: Tab, name: String): Unit = definedExternally
    /**
     *   Notification fired when a tab is deselected.
     * 
     *  @param {number} number of the deselected tab
     *  @param {Canvas} pane for this deselected tab
     *  @param {GlobalId} id of the deselected tab
     *  @param {Tab} the deselected tab object (not tab button instance)
     *  @param {Tab} the tab object being selected
     */
    open fun tabDeselected(tabNum: Number, tabPane: Canvas, ID: String, tab: Tab, newTab: Tab): Boolean = definedExternally
    /**
     *   This notification method fired when the user changes the title of a tab in this TabSet.
     *   This can happen either through user interaction with the UI if
     *   TabSet.canEditTabTitles is set, or programmatically if application
     *   code calls TabSet.editTabTitle.
     *   Return false from this method to cancel the change.
     * 
     *  @param {string} the new title
     *  @param {string} the old title
     *  @param {Tab} the tab whose title has changed
     */
    open fun titleChanged(newTitle: String, oldTitle: String, tab: Tab): Boolean = definedExternally
    /**
     *   Notification fired when the user right-clicks on a tab.
     *   Event may be cancelled by returning false
     * 
     *  @param {TabSet} This tabset
     *  @param {Tab} the tab object that recieved the context click event
     */
    open fun showTabContextMenu(tabSet: TabSet, tab: Tab): Boolean = definedExternally
    /**
     *   Notification method executed when one or more tabs in the TabSet are reordered.
     * 
     *  @param {StatefulCanvas} the live Canvas representing the tab that was moved
     *  @param {Integer} the new index of the tab in the tabSet
     */
    open fun tabsReordered(tabCanvas: StatefulCanvas, tabIndex: Number): Unit = definedExternally
    companion object {
        /**
         *  Creates a new TabSet
         * 
         *  @param typeCheckedProperties {Partial<TabSet>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {TabSet} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): TabSet = definedExternally
    }
}