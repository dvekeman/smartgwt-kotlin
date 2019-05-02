@file:JsQualifier("isc")
package isc

/**
 *  A general purpose Window class for implementing dialogs, portlets, alerts, prompts, wizards
 *   and desktop-like windowing interfaces.
 * 
 *   Windows can contain arbitrary SmartClient components, configured via the Window.items
 *   property. Windows may be Window.isModal or non-modal.
 * 
 *   Windows provide a series of highly configurable and skinnable AutoChild
 *   including a header, various header controls, footer, and corner resizer.
 * 
 *   The more specialized Dialog subclass of Window has additional functionality targetted
 *   at simple prompts and confirmations, such as buttons with default actions, and single-method
 *   isc.warn for common application dialogs.
 */
open external class Window : Layout {
    /**
     *  If true, this Window may be moved around by the user by dragging on the Window header.
     *   Note that if the header is not showing, the Window can't be drag-repositioned regardless
     *   of this setting.
     *  @type {boolean}
     *  @default true
     */
    override var canDragReposition: Boolean = definedExternally
    /**
     *  If Window.canDragReposition or Window.canDragResize is true, should the
     *   windows size and position be constrained such that it remains within the viewport of
     *   its parent element (or for top level windows, within the viewport of the browser window)?
     * 
     *   Can also be set to an array denoting an arbitrary rect [Left,Top,Width,Height] beyond
     *   which the window cannot be moved.
     * 
     *   Note: keepInParentRect affects only user drag interactions, not programmatic moves.
     *  @type {boolean | any}
     *  @default null
     */
    override var keepInParentRect: dynamic = definedExternally
    /**
     *  Can the window be drag-resized? If true the window may be drag resized from its edges,
     *   and if showing, via the resizer icon in the footer.
     *  @type {boolean}
     *  @default false
     */
    override var canDragResize: Boolean = definedExternally
    /**
     *  By default Windows show a Canvas.useBackMask in Internet Explorer
     *   versions predating Internet Explorer 9. This is a workaround for a native browser
     *   issue whereby certain DOM elements such as IFRAMEs (whether rendered
     *   within SmartClient components via features such as HTMLFlow.contentsURL or
     *   explicitly written into the HTML of the page) will not be properly occluded
     *   by DOM elements which overlap them but have a higher z-index.
     * 
     *   A side-effect of this is that the Canvas.opacity can not be modified
     *   for the entire window. Developers may disable the backmask in order to support
     *   opacity in IE versions less than 9 by setting this property to false, however you
     *   should be aware that in doing this there is a potential for the "burn through"
     *   problem described above.
     *  @type {boolean}
     *  @default "varies"
     */
    override var useBackMask: Boolean = definedExternally
    /**
     *  Renders the widget to be partly transparent. A widget's opacity property may
     *   be set to any number between 0 (transparent) to 100 (opaque).
     *   Null means don't specify opacity directly, 100 is fully opaque.
     *   Note that heavy use of opacity may have a performance impact on some older
     *   browsers.
     * 
     *   In older versions of Internet Explorer (Pre IE9 / HTML5), opacity is achieved
     *   through proprietary filters. If
     *   Canvas.neverUseFilters within this application
     *   developers must set Canvas.useOpacityFilter to true for specific components
     *   on which opacity support is required.
     * 
     *   Also note that opacity is incompatible
     *   with Canvas.useBackMask, and that this property is enabled
     *   by default for Window instances.
     *  @type {Integer}
     *  @default null
     */
    override var opacity: Number = definedExternally
    /**
     *  If true, when shown this Window will intercept and block events to all other existing
     *   components on the page.
     * 
     *   Use Window.showModalMask to darken all other elements on the screen when a modal dialog
     *   is showing.
     * 
     *   Chained modal windows - that is, modal windows that launch other modal windows - are
     *   allowed. You can accomplish this by simply creating a second modal Window while a modal
     *   Window is showing.
     * 
     *   Note only top-level Windows (Windows without parents) can be modal.
     *  @type {boolean}
     *  @default false
     */
    open var isModal: Boolean = definedExternally
    /**
     *  A ScreenSpan instance used to darken the rest of a page when a modal window is
     *   active. To use, set Window.showModalMask to true, add a CSS style
     *   "modalMask" to the active skin (generally with background-color set),
     *   and adjust Window.modalMaskOpacity.
     *  @type {Canvas}
     *  @default null
     */
    open var modalMask: Canvas = definedExternally
    /**
     *  If true, displays a translucent mask over the rest of the page when a modal window
     *   is displayed.
     *  @type {boolean}
     *  @default null
     */
    open var showModalMask: Boolean = definedExternally
    /**
     *  Controls the opacity of the modal mask displayed behind modal windows.
     *  @type {number}
     *  @default "50"
     */
    open var modalMaskOpacity: Number = definedExternally
    /**
     *  Specifies the CSS style for the modal mask.
     *  @type {string}
     *  @default "modalMask"
     */
    open var modalMaskStyle: String = definedExternally
    /**
     *  If true, this Window widget will automatically be centered on the page when shown.
     *     If false, it will show up in the last position it was placed (either programmatically,
     *     or by user interaction).
     * 
     *     Note: If an auto-centering Window is either programmatically moved or dragged
     *     by an end user, auto-centering behavior is automatically turned off. To manually center
     *     a Window, you can use Window.centerInPage.
     *  @type {boolean}
     *  @default false
     */
    open var autoCenter: Boolean = definedExternally
    /**
     *  If true, a click outside the bounds of the Window will have the same effect as
     *     pressing its cancel button.
     *     Note: Applies only to modal windows.
     *  @type {boolean}
     *  @default false
     */
    open var dismissOnOutsideClick: Boolean = definedExternally
    /**
     *  Should this window be dismissed (same effect as pressing the "Cancel" button) when the
     *   user presses the "Escape" key? Behavior will only occur while the window or one of its
     *   descendants has focus, and does not cancel the Escape keypress.
     * 
     *   If unset default behavior depends on whether a close / cancel button is visible for
     *   this item.
     *  @type {boolean}
     *  @default null
     */
    open var dismissOnEscape: Boolean = definedExternally
    /**
     *  Body of the Window, where Items or Window.src
     *   is shown.
     * 
     *   The following autoChildUsage apply:
     * 
     * 
     *  - Window.bodyStyle for the Canvas.styleName
     * 
     *  - Window.printBodyStyle for the styleName to use when
     *     printing
     * 
     *  - Window.bodyColor / Window.hiliteBodyColor for
     *     the Canvas.backgroundColor
     * 
     *  @type {Canvas}
     *  @default null
     */
    open var body: Canvas = definedExternally
    /**
     *  If true, draw the body contents when this Window is drawn.
     *  @type {boolean}
     *  @default true
     */
    open var showBody: Boolean = definedExternally
    /**
     *  Style of the Window body.
     *  @type {CSSStyleName}
     *  @default "windowBody"
     */
    open var bodyStyle: String = definedExternally
    /**
     *  Style for the Window body in printed output.
     *  @type {CSSStyleName}
     *  @default "printHeader"
     */
    open var printBodyStyle: String = definedExternally
    /**
     *  Color of the Window body. Overrides the background color specified in the style.
     *  @type {CSSColor}
     *  @default "#FFFFFF"
     */
    open var bodyColor: String = definedExternally
    /**
     *  Highlight color for the Window body (shown when the body is flashed).
     *  @type {CSSColor}
     *  @default "#EEEEEE"
     */
    open var hiliteBodyColor: String = definedExternally
    /**
     *  The contents of the Window body. Can be specified three different ways:
     * 
     *  - an Array of Canvases that will become the children of the Window's body when it
     *     is initialized; the canvases in this array should be created, but not drawn (autodraw:
     *     false).
     * 
     *  - a single canvas that will become a child of the Window body.
     * 
     *  - a string that will be set as the body's contents.
     *  @type {Array<Partial<Canvas>> | Canvas | string}
     *  @default null
     */
    open var items: dynamic = definedExternally
    /**
     *  A URL to load as content for the Window's body. If specified, this
     *   attribute will take precedence over the items attribute.
     * 
     *   Note that setting window.src is essentially a shortcut for setting Window.items
     *   to a single HTMLflow with a specified HTMLFlow.contentsURL.
     *  @type {string}
     *  @default null
     */
    open var src: String = definedExternally
    /**
     *  If this window has Window.src specified, this property can be used to indicate
     *   whether the source is a standalone HTML page or an HTML fragment.
     * 
     *   This is similar to the HTMLFlow.contentsType property - be sure to read the
     *   HTMLFlow documentation to understand circumstances where contentsType:"page" is
     *   unsafe and not recommended.
     *  @type {string}
     *  @default "page"
     */
    open var contentsType: String = definedExternally
    /**
     *  The name of the widget class (as a string) to use for the body. If unset the appropriate
     *   constructor type will be determined as follows:
     *   - if Window.items is defined as an array of widgets, and Window.contentLayout
     *    is not set to "none", bodyConstructor defaults to a VLayout
     *   - if Window.src is set, bodyConstructor defaults to an HTMLFlow
     *   - otherwise bodyConstructor will default to a simple Canvas
     *   Note that if this property is overridden for some window, the specified constructor
     *   should be a subclass of one of these defaults to ensure the window renders out as
     *   expected.
     *  @type {string}
     *  @default null
     */
    open var bodyConstructor: String = definedExternally
    /**
     *  Default properties for the body of the Window
     *   You can change the class-level bodyDefaults for all Windows by changing this item
     *   or set instance.body to be another object of properties to override for your instance only
     *  @type {object}
     *  @default "..."
     */
    open var bodyDefaults: dynamic = definedExternally
    /**
     *  The layout policy that should be used for widgets within the Window body.
     * 
     *   See ContentLayoutPolicy and Window.bodyConstructor for details.
     *  @type {ContentLayoutPolicy}
     *  @default "vertical"
     */
    open var contentLayout: 
                            /**
                             *  Window does not try to size members at all on either axis. Window body defaults to
                             *   a Canvas if not autosizing. Otherwise a Layout is used with policies on both axes set
                             *   to LayoutPolicy "none".
                             *  Window body defaults to VLayout behavior. (Body is actually just a Layout with
                             *   Layout.vertical: true.)
                             *  Window body defaults to HLayout behavior. (Body is actually just a Layout with
                             *   Layout.vertical: false.)
                             */
                            String /* none |  vertical |  horizontal */ = definedExternally
    /**
     *  If true, the window is resized automatically to accommodate the contents
     *     of the body, if they would otherwise require scrolling.
     *  @type {boolean}
     *  @default false
     */
    open var autoSize: Boolean = definedExternally
    /**
     *  Header for the Window, based on an HLayout. The header contains the title and some standard
     *   controls for the window, which may be configured via Window.headerControls.
     * 
     *   The following autoChildUsage apply:
     * 
     * 
     *  - Window.headerStyle for Canvas.styleName
     * 
     *  - Window.printHeaderStyle for the styleName to use
     *     when printing.
     * 
     *  @type {HLayout}
     *  @default null
     */
    open var header: HLayout = definedExternally
    /**
     *  If true, show a Window.header for this Window.
     * 
     *   Note that in certain Smartclient skins Window.showHeaderBackground may be set to
     *   false and the header's appearance implemented as part of the
     *   window's Canvas.showEdges. In this case suppressing the header can be achieved
     *   by overriding the edge media as well as setting this property to false. For example, to
     *   create a headerless window with a similar appearance to a Menu in the
     *   TreeFrog skin, the following attributes could be used:
     * 
     *     showHeader:false,
     *     edgeImage:"[SKIN]/Menu/m.png",
     *     edgeSize:10, edgeTop:17, edgeBottom:17,
     *     edgeCenterBackgroundColor:"#F7F7F7"
     * 
     *  @type {boolean}
     *  @default true
     */
    open var showHeader: Boolean = definedExternally
    /**
     *  Img background component for the header, for gradient or image-based display
     *  @type {Img}
     *  @default null
     */
    open var headerBackground: Img = definedExternally
    /**
     *  Should the window header show a background image? Default value is true for all browsers
     *   except for Internet Explorer.
     *   If set to true the image source is derived from Window.headerSrc and
     *   Window.hiliteHeaderSrc, otherwise the background will be styled according to
     *   Window.headerStyle / Window.hiliteHeaderStyle.
     *  @type {boolean}
     *  @default "varies"
     */
    open var showHeaderBackground: Boolean = definedExternally
    /**
     *  Style for the Window header.
     *  @type {CSSStyleName}
     *  @default "WindowHeader"
     */
    open var headerStyle: String = definedExternally
    /**
     *  CSS Style for header in printed output
     *  @type {CSSStyleName}
     *  @default "printHeader"
     */
    open var printHeaderStyle: String = definedExternally
    /**
     *  If Window.showHeaderBackground is true, this property provides
     *   the URL of the background image for the header.
     *  @type {SCImgURL}
     *  @default ""[SKIN]Window/headerGradient.gif" | null"
     */
    open var headerSrc: String = definedExternally
    /**
     *  Array of members to show in the Window header.
     * 
     *   The default value of headerControls is an Array of Strings listing the
     *   standard header controls in their default order:
     * 
     *    headerControls : ["headerIcon", "headerLabel",
     *             "minimizeButton", "maximizeButton", "closeButton"]
     * 
     *   You can override headerControls to change the order of standard controls in
     *   the header. You can also omit standard controls this way, although it more efficient to
     *   use the related "show" property if available (eg Window.showMinimizeButton).
     * 
     *   By embedding a Canvas directly in this list you can add arbitrary additional controls to
     *   the header, for example, an additional button (eg return to dock) or a DynamicForm with
     *   various kinds of input controls.
     * 
     *   Note that having added controls to headerControls, you can still call APIs directly on
     *   those controls to change their appearance, and you can also show() and hide() them if
     *   they should not be shown in some circumstances.
     * 
     *   Tip: custom controls need to set layoutAlign:"center" to appear vertically centered.
     * 
     *   Component XML:
     * 
     *   To define headerControls in Component XML a special set of components
     *   are used as markers. The standard header controls can be explicitly specified as:
     * 
     *   &lt;headerControls&gt;
     *     &lt;WindowHeaderIcon/&gt;
     *     &lt;WindowHeaderLabel/&gt;
     *     &lt;WindowMinimizeButton/&gt;
     *     &lt;WindowMaximizeButton/&gt;
     *     &lt;WindowCloseButton/&gt;
     *   &lt;/headerControls&gt;
     * 
     *  @type {Array<Partial<string>>}
     *  @default "(see below)"
     */
    open var headerControls: Array<dynamic> = definedExternally
    /**
     *  Highlight style for the Window header. Displayed when a window
     *   is Window.flash
     *  @type {CSSStyleName}
     *  @default "WindowHeader"
     */
    open var hiliteHeaderStyle: String = definedExternally
    /**
     *  If Window.showHeaderBackground is true, this governs the URL of the image to
     *   use in the header's highlighted state when the window is Window.flash
     *  @type {SCImgURL}
     *  @default ""[SKIN]Window/headerGradient_hilite.gif" | null"
     */
    open var hiliteHeaderSrc: String = definedExternally
    /**
     *  Label that shows Window title in header.
     * 
     *   The following autoChildUsage applies:
     *   Window.title for Label.contents.
     *  @type {Label}
     *  @default null
     */
    open var headerLabel: Label = definedExternally
    /**
     *  Show a title (typically just text) on the header for this window.
     *  @type {boolean}
     *  @default true
     */
    open var showTitle: Boolean = definedExternally
    /**
     *  title for this Window, shown in the header (if drawn)
     *  @type {HTMLString}
     *  @default "Untitled Window"
     */
    open var title: String = definedExternally
    /**
     *  This is an object literal property block specifying various properties of the header
     *   label that displays the Window.title. Overrideable defaults are as follows:
     * 
     * 
     *  - styleName- defaults to "windowHeaderText" and specifies the css style
     *   that is used to render the Window.title text.
     * 
     *   You can override the the above properties by calling Class.changeDefaults.
     *  @type {object}
     *  @default "see below"
     */
    open var headerLabelDefaults: dynamic = definedExternally
    /**
     *  Header icon shown at left end of header by default.
     *  @type {Img}
     *  @default null
     */
    open var headerIcon: Img = definedExternally
    /**
     *  If true, we show an icon on the left in the header.
     *  @type {boolean}
     *  @default true
     */
    open var showHeaderIcon: Boolean = definedExternally
    /**
     *  This is an object literal property block specifying the various properties of the
     *   headerIcon - the icon that appears at the top left of the window and is by default the
     *   Isomorphic logo. Overrideable defaults are as follows:
     * 
     * 
     *  - width - default to 16 and specifies the width of the headerIcon.
     * 
     *  - height - default to 14 and specifies the height of the headerIcon.
     * 
     *  - src - defaults to "[SKIN]/Window/minimize.gif" and specifies the image
     *   for the headerIcon.
     * 
     *   You can override the the above properties by calling Class.changeDefaults.
     *  @type {object}
     *  @default "..."
     */
    open var headerIconDefaults: dynamic = definedExternally
    /**
     *  If true, the user can give the header buttons focus (see Window.minimizeButton,
     *   Window.maximizeButton, Window.restoreButton and Window.closeButton).
     *  @type {boolean}
     *  @default false
     */
    open var canFocusInHeaderButtons: Boolean = definedExternally
    /**
     *  Button show in the header that will close this Window by calling Window.closeClick.
     *  @type {ImgButton}
     *  @default null
     */
    open var closeButton: ImgButton = definedExternally
    /**
     *  If true, show a close button in the header, which will dismiss this window by
     *   calling Window.closeClick.
     *  @type {boolean}
     *  @default true
     */
    open var showCloseButton: Boolean = definedExternally
    /**
     *  ImgButton shown in the header that will minimize this Window by calling Window.minimize.
     *  @type {ImgButton}
     *  @default null
     */
    open var minimizeButton: ImgButton = definedExternally
    /**
     *  If true, show a minimize button in the header--clicking it minimizes the Window.
     *  @type {boolean}
     *  @default true
     */
    open var showMinimizeButton: Boolean = definedExternally
    /**
     *  Is this window minimized. If true at init time, the window will be drawn minimized.
     *   To set this property at runtime use Window.minimize or Window.restore.
     *  @type {boolean}
     *  @default false
     */
    open var minimized: Boolean = definedExternally
    /**
     *  If Window.minimizeHeight is unset, by the window will shrink to the height of the
     *   header when minimized.
     * 
     *   If there is no header, the defaultMinimizeHeight will be used instead.
     *  @type {number}
     *  @default "16"
     */
    open var defaultMinimizeHeight: Number = definedExternally
    /**
     *  Height for the window when minimized.
     *   If unset the window will shrink to the height of the header, if present, otherwise
     *   Window.defaultMinimizeHeight
     *  @type {number}
     *  @default null
     */
    open var minimizeHeight: Number = definedExternally
    /**
     *  Should this window minimize, maximize, and restore as an animation, or as a
     *   simple 1-step transition?
     *  @type {boolean}
     *  @default null
     */
    open var animateMinimize: Boolean = definedExternally
    /**
     *  If this window is minimizeable, and animateMinimize is true, what should the duration of
     *   the minimize / maximize be (in ms)? If unset defaults to canvas.animationTime.
     *  @type {number}
     *  @default null
     */
    open var minimizeTime: Number = definedExternally
    /**
     *  Default acceleration function for performing an animated minimize / maximize. If unset,
     *   this.animateAcceleration will be used by default instead
     *  @type {AnimationAcceleration}
     *  @default null
     */
    open var minimizeAcceleration: 
                                   /**
                                    *  - animation will speed up as time elapses
                                    *  - animation will slow down as time elapses
                                    *  - animation will speed up in the middle
                                    *  - no bias
                                    */
                                   String /* smoothStart |  smoothEnd |  smoothStartEnd |  none */ = definedExternally
    /**
     *  ImgButton that restores the Window via Window.restore.
     *  @type {ImgButton}
     *  @default null
     */
    open var restoreButton: ImgButton = definedExternally
    /**
     *  Is this window maximized. If true at init time, the window will be drawn maximized.
     *   To set this property at runtime use Window.maximize or Window.restore.
     *  @type {boolean}
     *  @default false
     */
    open var maximized: Boolean = definedExternally
    /**
     *  Button that will make this Window fill the browser via Window.maximize.
     *  @type {ImgButton}
     *  @default null
     */
    open var maximizeButton: ImgButton = definedExternally
    /**
     *  If true, show a maximize button in the header - clicking it maximizes the Window
     *  @type {boolean}
     *  @default false
     */
    open var showMaximizeButton: Boolean = definedExternally
    /**
     *  Optional footer for the window, providing space for controls such as the resizer and
     *   status bar.
     *  @type {HLayout}
     *  @default null
     */
    open var footer: HLayout = definedExternally
    /**
     *  If true, show a footer for this Window, including resizer, statusBar, etc.
     *   This setting is commonly overridden for skinning purposes.
     *  @type {boolean}
     *  @default true
     */
    open var showFooter: Boolean = definedExternally
    /**
     *  The height of the footer, in pixels.
     *  @type {number}
     *  @default "18"
     */
    open var footerHeight: Number = definedExternally
    /**
     *  Array of members to show in the Window footer.
     * 
     *   The default value of footerControls is an Array of Strings listing the
     *   standard footer controls in their default order:
     * 
     *    footerControls : ["spacer", "resizer"]
     * 
     *   As with Window.headerControls, you can override footerControls
     *   to change the order of standard controls in the footer. "spacer" is a special
     *   value which will create a LayoutSpacer in the footer bar. "resizer"
     *   will show the Window.resizer in the footer.
     * 
     *   By embedding a Canvas directly in this list you can add arbitrary additional controls to
     *   the footer.
     * 
     *   Note that the Window.statusBar is not part of the set of footer controls - it is a
     *   separate canvas rendered behind all footer controls. If you include some custom status bar
     *   directly in the footerControls you may want to set Window.showFooter to false.
     * 
     *   Tip: custom controls need to set layoutAlign:"center" to appear vertically centered.
     * 
     *   Component XML:
     * 
     *   To define footerControls in Component XML a special set of components
     *   are used as markers. The standard footer controls can be explicitly specified as:
     * 
     *   &lt;footerControls&gt;
     *     &lt;WindowFooterSpacer/&gt;
     *     &lt;WindowResizer/&gt;
     *   &lt;/footerControls&gt;
     * 
     *  @type {Array<Partial<string>>}
     *  @default "(see below)"
     */
    open var footerControls: Array<dynamic> = definedExternally
    /**
     *  Simple Canvas-based status bar, shown in the footer. Window.setStatus can be used to
     *   show text here.
     *  @type {Canvas}
     *  @default null
     */
    open var statusBar: Canvas = definedExternally
    /**
     *  If true, show a statusBar for this Window, including resizer.
     *  @type {boolean}
     *  @default true
     */
    open var showStatusBar: Boolean = definedExternally
    /**
     *  ImgButton-based resizer, shown in the footer.
     *  @type {ImgButton}
     *  @default null
     */
    open var resizer: ImgButton = definedExternally
    /**
     *  If true, show a button in the lower right corner that allows users to resize the Window.
     *   Note that the resizer will only be displayed if the footer is showing for the window
     *   (Window.showFooter) and Window.canDragResize is true.
     *  @type {boolean}
     *  @default true
     */
    open var showResizer: Boolean = definedExternally
    /**
     *  Where should the window be placed on the screen? Valid settings include
     *   "fillScreen", "fillPanel", "halfScreen"
     *   and "none"
     * 
     *   If not explicitly specified, default is to use PanelPlacement "fillScreen"
     *   if Browser.isHandset, and "none" for non-handset devices.
     * 
     *   If window.placement is something other than "none",
     *   sizing and positioning settings (either explicit left, top, width, height settings or
     *   the Window.autoCenter and Window.autoSize features) will have no effect.
     *  @type {PanelPlacement}
     *  @default null
     */
    open var placement: 
                        /**
                         *  classic placement for menus, pop-up lists and pickers in desktop           interfaces: near the control that was clicked (a search field,
                         *             MenuButton, etc). Note: this setting does not apply when there is
                         *             no originating control (such as a dialog that appears due to session
                         *             timeout), in which case centering will generally be used
                         *  fill the nearest containing panel managed by a device-aware layout such as          SplitPane, which will generally be equivalent to "fillScreen" for a
                         *            Browser.isHandset. Note: this setting does not
                         *            apply if there is no clear container for the component originating the UI,
                         *            in which case, "fillScreen" will generally be used.
                         *  fill the entire screen
                         *  fill the bottom half of the screen. This is the default behavior on iOS6/7           for plain HTML &lt;select&gt;, but note that native apps rarely use
                         *             this interface for picking from lists and it is not generally recommended.
                         *  this setting disables all panelPlacement sizing and positioning logic.           Explicitly specified size and positioning will be used.
                         */
                        String /* nearOrigin |  fillPanel |  fillScreen |  halfScreen |  none */ = definedExternally
    /**
     *  showEdges dynamically defaults to false when the Window.placement setting
     *   indicates the Window will be filling a portion of the screen or a panel.
     *  @type {boolean}
     *  @default null
     */
    override var showEdges: Boolean = definedExternally
    /**
     *  Whether to show a drop shadow for this Canvas.
     * 
     *   Developers should be aware that the drop shadow
     *   is drawn outside the specified width and height of the widget meaning a widget with shadows
     *   takes up a little more space than it otherwise would. A full screen canvas with showShadow set
     *   to true as this would be likely to cause browser scrollbars to appear - developers can handle
     *   this by either setting this property to false on full-screen widgets, or by setting
     *   overflow to "hidden" on the &lt;body&gt; element browser-level scrolling is never intended to occur.
     * 
     *   showShadow dynamically defaults to false when the Window.placement setting
     *   indicates the Window will be filling a portion of the screen or a panel.
     *  @type {boolean}
     *  @default null
     */
    override var showShadow: Boolean = definedExternally
    /**
     *  Alternative style for the window used whenever Window.placement settings indicate the
     *   menu will be filling a portion of the screen or a panel. Generally this alternative
     *   style should not have rounded or excessively large edges.
     *  @type {CSSStyleName}
     *  @default "windowBackgroundFill"
     */
    open var fillSpaceStyleName: String = definedExternally
    /**
     *  Should this window automatically be shown at the top of the page's z-order and
     *   be brought to front via Canvas.bringToFront whenever the user clicks it?
     * 
     *   If Window.isModal is true for this window, this setting will have no effect - we
     *   always bring the window to the front on initial display and on mouseDown.
     *   By default we also do this for non-modal windows (which matches user expectation for
     *   most standard interfaces - think of switching between OS-level application windows), but
     *   this may be disabled for cases where it is not appropriate by setting this attribute to
     *   false
     *  @type {boolean}
     *  @default true
     */
    open var bringToFrontOnMouseUp: Boolean = definedExternally
    /**
     *  Text to show in the status bar of the window (if one is visible)
     *  @type {string}
     *  @default null
     */
    open var status: String = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "WindowEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
    /**
     *   Setter for Window.headerStyle.
     * 
     *  @param {CSSStyleName} new Canvas.styleName for the Window.header.
     */
    open fun setHeaderStyle(newHeaderStyle: String): Unit = definedExternally
    /**
     *   Dynamically update Window.showCloseButton to show / hide the closeButton
     * 
     */
    open fun setShowCloseButton(): Unit = definedExternally
    /**
     *   Dynamically update Window.showMinimizeButton to show / hide the minimizeButton
     * 
     */
    open fun setShowMinimizeButton(): Unit = definedExternally
    /**
     *   Dynamically update Window.showMaximizeButton to show / hide the maximizeButton
     * 
     */
    open fun setShowMaximizeButton(): Unit = definedExternally
    /**
     *   Dynamically update Window.showHeaderIcon to show / hide the headerIcon
     * 
     */
    open fun setShowHeaderIcon(): Unit = definedExternally
    /**
     *   Sets the Window.title that appears in the window Window.header.
     *   The header will be redrawn if necessary.
     * 
     *  @param {HTMLString} new title.
     */
    open fun setTitle(newTitle: String): Unit = definedExternally
    /**
     *     Sets the text in the status bar of the window, redrawing if necessary.
     * 
     *  @param {string} new text for the status bar
     */
    open fun setStatus(statusString: String): Unit = definedExternally
    /**
     *   Sets the URL of the contents to display in the body of the window, redrawing if
     *   necessary.
     * 
     *  @param {string} URL of new contents to be displayed in the window body
     */
    open fun setSrc(url: String): Unit = definedExternally
    /**
     *   Setter for Window.bodyStyle.
     * 
     *  @param {CSSStyleName} new Canvas.styleName for the Window.body.
     */
    open fun setBodyStyle(newBodyStyle: String): Unit = definedExternally
    /**
     *   Setter for Window.bodyColor.
     * 
     *  @param {CSSColor} new Canvas.backgroundColor for the Window.body.
     */
    open fun setBodyColor(newBodyColor: String): Unit = definedExternally
    /**
     *   Setter for Window.hiliteBodyColor.
     * 
     *  @param {CSSColor} new hiliteBodyColor.
     */
    open fun setHiliteBodyColor(newHiliteBodyColor: String): Unit = definedExternally
    /**
     *   Adds a widget to the body area of the window.
     * 
     *  @param {Canvas} the widget to be added
     */
    open fun addItem(item: Canvas): Array<dynamic> = definedExternally
    /**
     *   Removes a widget from the body area of the window.
     * 
     *  @param {Canvas} the widget to be removed
     */
    open fun removeItem(item: Canvas): Array<dynamic> = definedExternally
    /**
     *     Adds an array of widgets to the window.
     * 
     *  @param {Array<Partial<Canvas>>} an array of widgets to be added
     */
    open fun addItems(items: Array<dynamic>): Array<dynamic> = definedExternally
    /**
     *     Removes an array of widgets from the window.
     * 
     *  @param {Array<Partial<Canvas>>} an array of widgets to be removed
     */
    open fun removeItems(items: Array<dynamic>): Array<dynamic> = definedExternally
    /**
     *   Same as Layout.addMember. Note that in order to add items to Window.body,
     *   you use Window.addItem rather than addMember. Adding a member to
     *   a Window adds the member as a sibling to the header, body and other built-in Window
     *   subcomponents.
     * 
     *  @param {Canvas} the canvas object to be added to the layout
     *  @param {Integer=} the position in the layout to place newMember (starts with 0);              if omitted, it will be added at the last position
     */
    override fun addMember(newMember: Canvas, position: Number?): Unit = definedExternally
    /**
     *   Same as Layout.addMembers. Note that in order to add items to Window.body,
     *   you use Window.addItem rather than addMembers. Adding a member to
     *   a Window adds the member as a sibling to the header, body and other built-in Window
     *   subcomponents.
     * 
     *  @param {Array<Partial<Canvas>> | Canvas} array of canvases to be added or single Canvas
     *  @param {number=} position to add newMembers; if omitted newMembers will be added              at the last position
     */
    override fun addMembers(newMembers: dynamic, position: Number?): Unit = definedExternally
    /**
     *   Reveals the child Canvas passed in by showing it if it is currently hidden. Note, in the
     *   case of Window, "child Canvas" means widgets in the Window's "items" collection as well as
     *   real children (the children of a Window - ie, the elements of its "children" array - are
     *   its component parts like header and body)
     * 
     * 
     *  @param {GlobalId | Canvas} the child Canvas to reveal, or its global ID
     */
    override fun revealChild(child: dynamic): Unit = definedExternally
    /**
     *   Setter for Window.autoSize
     * 
     *  @param {boolean} true if the window should auto-size to its content
     */
    open fun setAutoSize(autoSize: Boolean): Unit = definedExternally
    /**
     *   Should this window be dismissed (same effect as pressing the "Cancel" button) when the
     *   user presses the "Escape" key?
     *   Default behavior: if Window.dismissOnEscape is set, just return it. Otherwise return
     *   true if this window is showing a "close" control in the header
     *   (see Window.headerControls).
     * 
     */
    open fun shouldDismissOnEscape(): Boolean = definedExternally
    /**
     *   Centers the Window in the page. This is called automatically in window.show() if
     *   Window.autoCenter is true.
     *   Note - if the Window is a child of another widget, we center in the parent widget
     *   rather than centering in the page.
     * 
     */
    open fun centerInPage(): Unit = definedExternally
    /**
     *       Makes the window header flash if it's visible; if there's no header, or the header
     *       is hidden, makes the window body flash instead.
     * 
     *     This method is executed when users click outside the bounds of a modal window
     *     so they'll notice that they have to do something with the window.
     * 
     */
    open fun flash(): Unit = definedExternally
    /**
     *   Minimize the window. Fired when the user clicks the minimize button if
     *   Window.showMinimizeButton is true.
     *   Default implementation shrinks the window to just the height of the header bar, hiding the
     *   body. If Window.animateMinimize is true, the resize will be animated.
     *   A restore button will be displayed in place of the minimize button when the window is
     *   minimized.
     * 
     */
    open fun minimize(): Unit = definedExternally
    /**
     *   Restores the window to its specified height and width after a call to Window.minimize or
     *   Window.maximize. Called from a click on the restore button shown in place of the
     *   minimize or maximize button when the window is minimized or maximized.
     *   Resizing will occur as an animation if Window.animateMinimize is true.
     * 
     */
    open fun restore(): Unit = definedExternally
    /**
     *   Maximize the window. Fired when the user clicks the maximize button if
     *   Window.showMaximizeButton is true.
     *   Default implementation moves the window to 0, 0 and resizes the window to
     *   "100%" on both axes, so it will fill the browser window (or the parent
     *   of the Window instance, if appropriate).
     *   If Window.animateMinimize is true, the maximize will be animated.
     *   A restore button will be displayed in place of the maximize button when the window is
     *   maximized.
     * 
     * 
     */
    open fun maximize(): Unit = definedExternally
    /**
     *   Handles a click on the close button of this window. The default implementation
     *   calls Window.close and returns false to prevent bubbling of the click event.
     * 
     *   Override this method if you want
     *   other actions to be taken.
     * 
     *   Custom implementations may call close() to trigger the default behavior.
     * 
     */
    open fun closeClick(): Boolean = definedExternally
    /**
     *   Close this window.
     *   This method is fired by the default Window.closeClick implementation.
     *   Default implementation will hide the window.
     * 
     */
    open fun close(): Unit = definedExternally
    companion object {
        /**
         *  A declared value of the enum type
         *   ContentLayoutPolicy.
         *  @type {Constant}
         *  @default "none"
         */
        var NONE: String = definedExternally
        /**
         *  A declared value of the enum type
         *   ContentLayoutPolicy.
         *  @type {Constant}
         *  @default "vertical"
         */
        var VERTICAL: String = definedExternally
        /**
         *  A declared value of the enum type
         *   ContentLayoutPolicy.
         *  @type {Constant}
         *  @default "horizontal"
         */
        var HORIZONTAL: String = definedExternally
        /**
         *  Creates a new Window
         * 
         *  @param typeCheckedProperties {Partial<Window>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Window} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Window = definedExternally
    }
}