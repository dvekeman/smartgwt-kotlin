@file:JsQualifier("isc")
package isc

/**
 *  A device- and orientation-sensitive layout that implements the common pattern of rendering
 *   two panes side-by-side on desktop machines and on tablets in landscape orientation,
 *   while switching to showing a single pane for handset-sized devices or tablets in portrait
 *   orientation (this type of behavior is sometimes called "responsive design").
 * 
 *   A SplitPane can manage either two or three panes &mdash; a
 *   SplitPane.navigationPane and the
 *   SplitPane.detailPane are required, and a
 *   SplitPane.listPane can also be provided which appears in the same place as
 *   the navigation pane, with built-in navigation between the panes based on
 *   NavigationBar. An example of 3-pane usage would be an email application:
 * 
 * 
 *  - navigationPane: TreeGrid of folders
 * 
 *  - listPane: ListGrid showing messages in a folder
 * 
 *  - detailPane: message detail view (perhaps a DetailViewer over an
 *     HTMLFlow or similar arrangement)
 * 
 * 
 *   The placement of the panes is by default sensitive to whether the device is detected as a
 *   handset (phone), tablet or desktop device (see DeviceMode) and to the current
 *   PageOrientation. You can also configure a SplitPane with a fixed
 *   SplitPane.pageOrientation or SplitPane.deviceMode.
 * 
 *   Beyond providing the panes listed above, typical usage is simply to call
 *   SplitPane.showListPane and SplitPane.showDetailPane when the
 *   SplitPane should navigate to a new pane. For example, in an email application,
 *   clicking on a folder in the navigationPane should cause the
 *   listPane to show messages from the folder, then
 *   showListPane("folder name") would be called to show the
 *   listPane and give it a new title reflecting the name of the folder.
 * 
 *   Similarly, clicking on a message in the listPane should show the message
 *   details in the detailPane and call
 *   showDetailPane("message title") to reveal the detailPane
 *   and give it an appropriate title.
 * 
 *   Automatic control placement
 * 
 *   SplitPane.detailToolButtons allows you to define a set of controls that are specially
 *   placed based on the deviceMode and pageOrientation. See
 *   SplitPane.detailToolButtons for details.
 * 
 *   NavigationBar and ToolStrips
 * 
 *   By default, bars are created as follows:
 * 
 * 
 *  - in deviceMode:"tablet" and deviceMode "handset", the
 *     SplitPane.navigationBar is always created.
 * 
 *  - in deviceMode:"desktop", the navigationBar is created by
 *     default only if the SplitPane.navigationTitle is specified and non-empty or
 *     SplitPane.showRightButton and/or SplitPane.showLeftButton is true,
 *     or SplitPane.showNavigationBar is true.
 * 
 *  - in deviceMode:"desktop" and deviceMode "tablet", the
 *     SplitPane.detailToolStrip is shown above the detailPane.
 * 
 *  - in deviceMode:"handset", the SplitPane.detailToolStrip is created
 *     only if detailToolButtons are specified, and is placed
 *     underneath the detailPane.
 * 
 *  - SplitPane.listToolStrip - separate bar for the listPane, only present
 *     for deviceMode:"desktop" when a listPane is provided.
 * 
 *   All of these bars are autoChildUsage and hence completely
 *   optional. You can omit them entirely, or, if you want navigation bars or tool strips but
 *   want to customize them more than the AutoChild system allows, you can prevent the built-in
 *   bars from being created and place your own NavigationBars either inside your
 *   navigation, list or detail panes, or outside the SplitPane as a whole.
 *   This allows you to completely customize your navigation but still use SplitPane
 *   to handle device- and orientation-aware layout. See SplitPane.showNavigationBar,
 *   SplitPane.showListToolStrip, and SplitPane.showDetailToolStrip.
 * 
 *   Note that in addition to the SplitPane.navigationBar, the other automatically
 *   created bars are also instances of NavigationBar despite the "toolStrip" naming convention.
 *   These controls will not generally contain navigation elements; the NavigationBar
 *   class is used for consistent styling, since the navigationBar appears adjacent
 *   to the toolstrips in some modes and orientations, so they should have the same height and
 *   styling.
 */
open external class SplitPane : Layout {
    /**
     *  Should default history-tracking support be enabled? If true, then a history
     *   management scheme utilizing History.addHistoryEntry and History.registerCallback
     *   is enabled. The history callback is registered as an additive callback, allowing other
     *   history callbacks including the primary callback to be registered.
     * 
     *   The default history management scheme is as follows:
     * 
     * 
     *  - History entries are only added after Page.isLoaded and when the
     *   SplitPane is drawn.
     * 
     *  - A history entry is added for a pane that is hidden by SplitPane.showNavigationPane,
     *   SplitPane.showListPane, or SplitPane.showDetailPane for the current SplitPane.deviceMode
     *   and SplitPane.pageOrientation settings.
     * 
     *   Example 1: When deviceMode is "desktop", all 3 panes are shown simultaneously,
     *   so no history entries are added.
     * 
     *   Example 2: When deviceMode is "handset", calling SplitPane.showDetailPane
     *   will hide the current pane (the SplitPane.listPane if present, otherwise the SplitPane.navigationPane).
     *   A history entry is added for the pane that was hidden
     * 
     * 
     *   The default history management scheme can be supplemented with application-specific
     *   history management. For example, when deviceMode is "tablet", the SplitPane.detailPane
     *   is always visible, but changes to the content of the detailPane are transparent
     *   to the SplitPane. The application can add history entries of its own when
     *   the user causes new information to be displayed in the detailPane.
     *  @type {boolean}
     *  @default false
     */
    open var addHistoryEntries: Boolean = definedExternally
    /**
     *  UI layout mode used for this SplitPane.
     * 
     *   A SplitPane can be configured with up to 3 panes: the SplitPane.navigationPane,
     *   SplitPane.listPane and SplitPane.detailPane. Both DeviceMode and PageOrientation
     *   influence the placement of these panes as follows:
     * 
     * 
     *  - "handset" deviceMode: only a single pane is shown at a time. Not
     *     orientation sensitive
     * 
     *  - "tablet" deviceMode with pageOrientation:"landscape": the
     *     detailPane is shown side by side with either the
     *     navigationPane or listPane
     * 
     *  - "tablet" deviceMode with pageOrientation:"portrait": the
     *     detailPane is shown only. End user navigation that would show the
     *     listPane or navigationPane shows those panes on top of the
     *     detailPane (temporarily covering part of its content)
     * 
     *  - "desktop" deviceMode: all 3 panes are shown simultaneously. Not
     *     orientation sensitive
     * 
     *   The listPane is optional; if not present, wherever the listPane
     *   is mentioned above, the navigationPane is shown instead.
     *  @type {DeviceMode}
     *  @default null
     */
    open var deviceMode: 
                         /**
                          *  mode intended for handset-size devices (phones). Generally only one UI         panel will be shown at a time.
                          *  mode intended for tablet-size devices. Generally, up to two panels are         shown side by side in "landscape" PageOrientation, and only one
                          *           panel is shown in "portrait" orientation.
                          *  mode intended for desktop browsers. Three or more panels may be shown         simultaneously.
                          */
                         String /* handset |  tablet |  desktop */ = definedExternally
    /**
     *  Current PageOrientation. The default behavior of the SplitPane is to
     *   register for orientation change notifications from the device (see
     *   Page.getOrientation) and automatically change orientation based on the
     *   SplitPane.deviceMode.
     * 
     *   You can instead set a specific value for pageOrientation if you only want to
     *   use a specific layout, and not respond to orientation information from the device.
     *  @type {PageOrientation}
     *  @default null
     */
    open var pageOrientation: 
                              /**
                               *  Landscape orientation: page is wider than it is tall.
                               *  Portrait orientation: page is taller than it is wide.
                               */
                              String /* landscape |  portrait */ = definedExternally
    /**
     *  LeftLayoutâ€™s initial size
     *  @type {Integer}
     *  @default "320"
     */
    open var navigationPaneWidth: Number = definedExternally
    /**
     *  If enabled, the SplitPane will add resize bars between the
     *   SplitPane.navigationPane and SplitPane.detailPane
     *   when these panes are shown side-by-side, and between the SplitPane.listPane
     *   and SplitPane.detailPane in SplitPane.deviceMode.
     *  @type {boolean}
     *  @default true
     */
    open var showResizeBars: Boolean = definedExternally
    /**
     *  A NavigationBar instance managed by this SplitPane that is
     *   placed above the SplitPane.navigationPane.
     * 
     *   The following autoChildUsage apply:
     * 
     * 
     *  - SplitPane.animateNavigationBarStateChanges
     *     for NavigationBar.animateStateChanges
     * 
     *  - SplitPane.showRightButton for NavigationBar.showRightButton
     * 
     * 
     *   Note that in SplitPane.deviceMode
     *   "desktop"
     * 
     *   with SplitPane.showNavigationBar unset,
     *   the navigationBar is automatically hidden when it would be empty
     *   (SplitPane.navigationTitle is an empty string and
     *   showRightButton and showLeftButton are both false).
     *   The navigationBar will be shown if the navigationTitle
     *   SplitPane.setNavigationTitle to a non-empty string, or
     *   showRightButton or showLeftButton is set to true.
     *  @type {NavigationBar}
     *  @default null
     */
    open var navigationBar: NavigationBar = definedExternally
    /**
     *  If set to false, the SplitPane.navigationBar
     *   will not be shown. If set to true, the navigationBar will
     *   always be shown, even when the SplitPane.deviceMode is
     *   "desktop"
     * 
     *   and the navigationBar would be empty.
     *  @type {boolean}
     *  @default null
     */
    open var showNavigationBar: Boolean = definedExternally
    /**
     *  Whether to animate state changes of the SplitPane.navigationBar.
     *   Enabled by default except when the browser is known to have poor animation
     *   performance.
     *  @type {boolean}
     *  @default true
     */
    open var animateNavigationBarStateChanges: Boolean = definedExternally
    /**
     *  A NavigationButton shown to the left of the
     *   SplitPane.navigationTitle
     *   in the SplitPane.navigationBar.
     * 
     *   In SplitPane.deviceMode other than "desktop", this button is
     *   automatically created and allows transitioning back to the
     *   SplitPane.navigationPane (in tablet and handset modes) or the
     *   SplitPane.listPane (in handset mode). In these
     *   SplitPane.deviceMode, setting
     *   SplitPane.showLeftButton to true shows the
     *   SplitPane.leftButton in addition to the
     *   automatically-created back button.
     * 
     *   When SplitPane.deviceMode is "desktop", this button is never shown.
     *   See SplitPane.showLeftButton for more information.
     * 
     *   This button's Button.title is determined automatically by the
     *   SplitPane. See SplitPane.listTitle and
     *   SplitPane.detailTitle.
     *  @type {NavigationButton}
     *  @default null
     */
    open var backButton: NavigationButton = definedExternally
    /**
     *  An additional NavigationButton which may be shown to the left of the
     *   SplitPane.navigationTitle in the
     *   SplitPane.navigationBar.
     * 
     *   Important note: by default, this button has no
     *   NavigationButton.direction and does not fire the
     *   SplitPane.navigationClick notification. You can provide a
     *   direction and apply a click handler via the autoChild system.
     *  @type {NavigationButton}
     *  @default null
     */
    open var leftButton: NavigationButton = definedExternally
    /**
     *  The most recently shown pane. In handset DeviceMode, the
     *   currentPane is the only pane that is actually visible to the user. In other
     *   modes more than one pane can be simultaneously visible, so the currentPane is
     *   the most recent pane that was brought into view via a call to SplitPane.setCurrentPane or
     *   SplitPane.showNavigationPane.
     * 
     *   The default value of currentPane is "navigation".
     *  @type {CurrentPane}
     *  @default "navigation"
     */
    open var currentPane: 
                          /**
                           *  SplitPane.navigationPane is the most recently shown
                           *  SplitPane.listPane is the most recently shown
                           *  SplitPane.detailPane is the most recently shown
                           */
                          String /* navigation |  list |  detail */ = definedExternally
    /**
     *  The title for the SplitPane.navigationPane, displayed in the
     *   SplitPane.navigationBar and also used for the title of a back
     *   button in some configurations.
     *  @type {HTMLString}
     *  @default null
     */
    open var navigationTitle: String = definedExternally
    /**
     *  An arbitrary widget that is visible in all configurations when the
     *   SplitPane.currentPane is
     *   "navigation"
     * 
     *   (it may also be visible when the currentPane is
     *   "list"
     * 
     *   or
     *   "detail").
     * 
     * 
     *   The navigationPane is typically used for navigation, to initialize the
     *   content of the SplitPane.listPane (when using a listPane)
     *   or the SplitPane.detailPane. For example, in an email application
     *   the navigationPane pane widget could be a TreeGrid of the inboxes
     *   and folders.
     *  @type {Canvas}
     *  @default null
     */
    open var navigationPane: Canvas = definedExternally
    /**
     *  The title for the SplitPane.listPane.
     *  @type {HTMLString}
     *  @default null
     */
    open var listTitle: String = definedExternally
    /**
     *  An optional list pane displayed in the left-hand of the panes or in a side panel
     *   according to the pane layout.
     *  @type {Canvas}
     *  @default null
     */
    open var listPane: Canvas = definedExternally
    /**
     *  Bar displayed above the SplitPane.listPane, if a listPane is present,
     *   only for SplitPane.deviceMode "desktop".
     *  @type {NavigationBar}
     *  @default null
     */
    open var listToolStrip: NavigationBar = definedExternally
    /**
     *  If set to false, the SplitPane.listToolStrip
     *   will not be shown.
     *  @type {boolean}
     *  @default null
     */
    open var showListToolStrip: Boolean = definedExternally
    /**
     *  The title for the SplitPane.detailPane.
     *  @type {HTMLString}
     *  @default null
     */
    open var detailTitle: String = definedExternally
    /**
     *  The right-hand of the two panes managed by this widget, used for viewing details.
     *  @type {Canvas}
     *  @default null
     */
    open var detailPane: Canvas = definedExternally
    /**
     *  Toolstrip servicing the SplitPane.detailPane.
     * 
     *   In SplitPane.deviceMode
     *   "desktop"
     * 
     *   and deviceMode
     *   "tablet",
     * 
     *   the detailToolStrip is shown above the detailPane.
     *   In SplitPane.deviceMode
     *   "handset",
     * 
     *   the detailToolStrip is created only if
     *   SplitPane.detailToolButtons are specified, and is placed
     *   underneath the detailPane.
     *  @type {NavigationBar}
     *  @default null
     */
    open var detailToolStrip: NavigationBar = definedExternally
    /**
     *  If set to false, the SplitPane.detailToolStrip
     *   will not be shown.
     *  @type {boolean}
     *  @default null
     */
    open var showDetailToolStrip: Boolean = definedExternally
    /**
     *  detailToolButtons allows you to specify a set of controls that are specially
     *   placed based on the SplitPane.deviceMode and SplitPane.pageOrientation.
     *   This is generally useful for a compact strip of ImgButton controls, approximately
     *   5 of which will fit comfortably using typically-sized icons and in the most space-constricted
     *   modes.
     * 
     *   These controls are placed as follows:
     * 
     * 
     *  - in deviceMode:"desktop" and deviceMode "tablet" with
     *     pageOrientation "landscape", detailToolButtons appear in the
     *     SplitPane.detailToolStrip shown above of the detailPane.
     * 
     *  - in deviceMode:"handset", detailToolButtons appear in a
     *      SplitPane.detailToolStrip underneath the detailPane. This toolstrip
     *     is only created in "handset" mode if detailToolButtons are provided.
     * 
     *  - in deviceMode:"tablet" and pageOrientation:"portrait",
     *     detailToolButtons appear in splitPane.navigationBar.
     * 
     *  @type {Array<Partial<Canvas>>}
     *  @default null
     */
    open var detailToolButtons: Array<dynamic> = definedExternally
    /**
     *  If true, a MiniNavControl will be shown:
     * 
     * 
     *  - In the SplitPane.navigationBar when the device mode is
     *     "handset"
     * 
     *     and the SplitPane.currentPane is
     *     "detail".
     * 
     * 
     *  - In the SplitPane.detailToolStrip when the device mode is
     *     "tablet"
     * 
     *     and the SplitPane.pageOrientation is
     *     "portrait".
     * 
     * 
     * 
     *  @type {boolean}
     *  @default false
     */
    open var showMiniNav: Boolean = definedExternally
    /**
     *  Should the SplitPane.leftButton be shown in the
     *   SplitPane.navigationBar?
     * 
     *   When set to true, the SplitPane.leftButton is displayed to the left of the
     *   SplitPane.navigationTitle, and to the right of the SplitPane.backButton,
     *   when SplitPane.deviceMode is not "desktop".
     * 
     *  @type {boolean}
     *  @default false
     */
    open var showLeftButton: Boolean = definedExternally
    /**
     *  Should the NavigationBar.rightButton be shown in the
     *   SplitPane.navigationBar?
     *  @type {boolean}
     *  @default false
     */
    open var showRightButton: Boolean = definedExternally
    /**
     *  Navigation control that appears only when the navigation pane is not showing (showing detail
     *   pane on handset, or portrait mode on tablet).
     * 
     *   See also SplitPane.showMiniNav for a way to enable a built-in control.
     *  @type {Canvas}
     *  @default null
     */
    open var detailNavigationControl: Canvas = definedExternally
    /**
     *  Default value chosen for SplitPane.setListTitle when SplitPane.navigateListPane is called.
     * 
     *   Available variables are:
     * 
     * 
     *  - "titleField" - the value of the DataSource.titleField in the selected record from
     *   the SplitPane.navigationPane
     * 
     *  - "index" - position of the selected record
     * 
     *  - "totalRows" - total number of rows in the component where the record is selected
     * 
     *  - "record" - the entire selected Record
     * 
     *  @type {HTMLString}
     *  @default "${titleField}"
     */
    open var listPaneTitleTemplate: String = definedExternally
    /**
     *  Default value chosen for SplitPane.setDetailTitle when SplitPane.navigateDetailPane is called.
     * 
     *   Available variables are the same as for SplitPane.listPaneTitleTemplate.
     *  @type {HTMLString}
     *  @default "${titleField}"
     */
    open var detailPaneTitleTemplate: String = definedExternally
    /**
     *  If set, the SplitPane will automatically monitor selection changes in the
     *   SplitPane.navigationPane or SplitPane.listPane, and call SplitPane.navigateListPane or
     *   SplitPane.navigateDetailPane when selections are changed.
     * 
     *   If any configured panes lack DataSources or there is no DataSource relationship declared
     *   between panes, autoNavigate does nothing.
     *  @type {boolean}
     *  @default null
     */
    open var autoNavigate: Boolean = definedExternally
    /**
     *  Default class used to construct the EditProxy for this component
     *   when the component is Canvas.setEditMode.
     *  @type {SCClassName}
     *  @default "SplitPaneEditProxy"
     */
    override var editProxyConstructor: String = definedExternally
    /**
     *   Setter for SplitPane.addHistoryEntries.
     * 
     *  @param {boolean} the new setting.
     */
    open fun setAddHistoryEntries(addHistoryEntries: Boolean): Unit = definedExternally
    /**
     *   Reveals the pane indicated by the newPane parameter.
     * 
     *   This has different effects based on the DeviceMode and PageOrientation. For
     *   example, in "handset" mode, the new pane will be the only one showing. In other modes such
     *   as "desktop", this method may do nothing, but should still be called in order to ensure
     *   correct behavior with other DeviceMode settings.
     * 
     * 
     *  @param {CurrentPane} new pane to show.
     */
    open fun setCurrentPane(newPane: 
                                     /**
                                      *  SplitPane.navigationPane is the most recently shown
                                      *  SplitPane.listPane is the most recently shown
                                      *  SplitPane.detailPane is the most recently shown
                                      */
                                     String /* navigation |  list |  detail */): Unit = definedExternally
    /**
     *   Updates the SplitPane.detailToolButtons at runtime.
     * 
     * 
     *  @param {Array<Partial<Canvas>>} new controls for the toolstrip.
     */
    open fun setDetailToolButtons(buttons: Array<dynamic>): Unit = definedExternally
    /**
     *   Explicitly sets the page orientation to a fixed value instead of being responsive to device
     *   orientation changes. Pass null to return to responding automatically to device
     *   orientation.
     * 
     *   See PageOrientation for details of how page orientation affects layout.
     * 
     * 
     *  @param {PageOrientation} new orientation to use.
     */
    open fun setPageOrientation(newOrientation: 
                                                /**
                                                 *  Landscape orientation: page is wider than it is tall.
                                                 *  Portrait orientation: page is taller than it is wide.
                                                 */
                                                String /* landscape |  portrait */): Unit = definedExternally
    /**
     *   Show or hide the SplitPane.leftButton in the navigation bar.
     * 
     *  @param {boolean} if true, the leftButton will be shown, otherwise hidden.
     */
    open fun setShowLeftButton(show: Boolean): Unit = definedExternally
    /**
     *   Setter for the NavigationBar.leftButtonTitle of the
     *   SplitPane.navigationBar.
     * 
     * 
     *  @param {HTMLString} new title for the left button.
     */
    open fun setLeftButtonTitle(newTitle: String): Unit = definedExternally
    /**
     *   Show or hide the NavigationBar.rightButton of the
     *   SplitPane.navigationBar.
     * 
     * 
     *  @param {boolean} if true, the button will be shown, otherwise hidden.
     */
    open fun setShowRightButton(visible: Boolean): Unit = definedExternally
    /**
     *   Setter for the NavigationBar.rightButtonTitle of the
     *   SplitPane.navigationBar.
     * 
     * 
     *  @param {HTMLString} new title for the right button.
     */
    open fun setRightButtonTitle(newTitle: String): Unit = definedExternally
    /**
     *   Update the SplitPane.navigationPane at runtime.
     * 
     *  @param {Canvas} new navigation pane for this widget.
     */
    open fun setNavigationPane(pane: Canvas): Unit = definedExternally
    /**
     *   Sets the title for the SplitPane.navigationPane.
     * 
     *  @param {HTMLString} new title for the navigation pane.
     */
    open fun setNavigationTitle(title: String): Unit = definedExternally
    /**
     *   Causes a transition to the SplitPane.navigationPane.
     * 
     *  @param {NavigationDirection=} when SplitPane.animateNavigationBarStateChanges is true, this is the direction passed to NavigationBar.setViewState.
     */
    open fun showNavigationPane(direction: 
                                           /**
                                            *  Back
                                            *  Forward
                                            *  none
                                            */
                                           String /* back |  forward |  none */?): Unit = definedExternally
    /**
     *   Sets a new SplitPane.listPane at runtime.
     * 
     *  @param {Canvas} new list pane for this widget.
     */
    open fun setListPane(pane: Canvas): Unit = definedExternally
    /**
     *   Causes a transition to the SplitPane.listPane, optionally updating the
     *   SplitPane.setListTitle.
     * 
     *   If, based on the SplitPane.deviceMode and SplitPane.pageOrientation,
     *   this causes the SplitPane.navigationPane to be hidden, the
     *   SplitPane.backButton will be updated with the current title of the
     *   navigationPane, or the backButtonTitle passed to this method.
     *   When SplitPane.addHistoryEntries is enabled and backButtonTitle is passed,
     *   then backButtonTitle will be used for the back button title if the user goes
     *   back to the listPane.
     * 
     * 
     *  @param {HTMLString=} optional new list title.
     *  @param {HTMLString=} optional new title for the SplitPane.backButton.
     *  @param {NavigationDirection=} when SplitPane.animateNavigationBarStateChanges is true, this is the direction passed to NavigationBar.setViewState.
     */
    open fun showListPane(listPaneTitle: String?, backButtonTitle: String?, direction: 
                                                                                       /**
                                                                                        *  Back
                                                                                        *  Forward
                                                                                        *  none
                                                                                        */
                                                                                       String /* back |  forward |  none */?): Unit = definedExternally
    /**
     *   Sets the title for the SplitPane.listPane.
     * 
     *  @param {HTMLString} new title for the list pane.
     */
    open fun setListTitle(title: String): Unit = definedExternally
    /**
     *   Sets a new SplitPane.detailPane at runtime.
     * 
     *  @param {Canvas} new detail pane for this widget.
     */
    open fun setDetailPane(pane: Canvas): Unit = definedExternally
    /**
     *   Causes a transition to the SplitPane.detailPane, optionally updating
     *   the SplitPane.setDetailTitle.
     * 
     *   If, based on the SplitPane.deviceMode and SplitPane.pageOrientation,
     *   this causes the SplitPane.navigationPane or SplitPane.listPane
     *   to be hidden, the SplitPane.backButton will be updated
     *   with the current title of the navigationPane or listPane, or the
     *   backButtonTitle passed to this method. When SplitPane.addHistoryEntries
     *   is enabled and backButtonTitle is passed, then backButtonTitle
     *   will be used for the back button title if the user goes back to the detailPane.
     * 
     * 
     *  @param {HTMLString=} optional new SplitPane.detailTitle.
     *  @param {HTMLString=} optional new title for the SplitPane.backButton.
     *  @param {NavigationDirection=} when SplitPane.animateNavigationBarStateChanges is true, this is the direction passed to NavigationBar.setViewState.
     */
    open fun showDetailPane(detailPaneTitle: String?, backButtonTitle: String?, direction: 
                                                                                           /**
                                                                                            *  Back
                                                                                            *  Forward
                                                                                            *  none
                                                                                            */
                                                                                           String /* back |  forward |  none */?): Unit = definedExternally
    /**
     *   Sets the title for the SplitPane.detailPane.
     * 
     *  @param {HTMLString} new title for the detail pane.
     */
    open fun setDetailTitle(title: String): Unit = definedExternally
    /**
     *   Navigation control that appears only when the navigation pane is not showing (showing detail
     *   pane on handset, or portrait mode on tablet).
     * 
     * \* @param {Canvas} 
     */
    open fun setDetailNavigationControl(control: Canvas): Unit = definedExternally
    /**
     *   Sets a new SplitPane.listPaneTitleTemplate at runtime.
     * 
     *   By calling this method it is assumed you want the list pane title to change to the new
     *   template.
     * 
     * 
     *  @param {HTMLString} new template, can use HTML to be styled.
     */
    open fun setListPaneTitleTemplate(template: String): Unit = definedExternally
    /**
     *   Sets a new SplitPane.detailPaneTitleTemplate at runtime.
     * 
     *   By calling this method it is assumed you want the detail pane title to change to the new
     *   template.
     * 
     * 
     *  @param {HTMLString} new template, can use HTML to be styled.
     */
    open fun setDetailPaneTitleTemplate(template: String): Unit = definedExternally
    /**
     *   Causes the target pane component to load data and update its title based on the current
     *   selection in the source pane.
     * 
     *   Both the source pane and target pane must have a DataSource, and either:
     * 
     * 
     *  - the two DataSources must have a Many-To-One relationship declared via
     *   DataSourceField.foreignKey, so that ListGrid.fetchRelatedData can be
     *   used on the target pane.
     * 
     *  - the two DataSources must be the same, so that the record selected in the source pane can
     *   be displayed in the target pane via simply calling DetailViewer.setData.
     * 
     *   The default target is
     *   "list"
     * 
     *   if the SplitPane.listPane is present,
     *   otherwise
     *   "detail".
     * 
     * 
     *   The title applied to the target pane is based on SplitPane.listPaneTitleTemplate if the target
     *   pane is the listPane, otherwise SplitPane.detailPaneTitleTemplate.
     * 
     *   The source pane usually does not need to be specified: if the
     *   target pane is the detailPane, the default source pane
     *   is the listPane if present, otherwise the SplitPane.navigationPane. If the
     *   target pane is the listPane, the source pane is always
     *   the navigationPane.
     * 
     * 
     *  @param {CurrentPane=} pane that should navigate
     *  @param {HTMLString=} optional title to use for target pane. If not specified, the title is based on SplitPane.listPaneTitleTemplate if the target pane is the listPane, otherwise SplitPane.detailPaneTitleTemplate.
     *  @param {CurrentPane=} source pane used for selection
     */
    open fun navigatePane(target: 
                                  /**
                                   *  SplitPane.navigationPane is the most recently shown
                                   *  SplitPane.listPane is the most recently shown
                                   *  SplitPane.detailPane is the most recently shown
                                   */
                                  String /* navigation |  list |  detail */?, title: String?, source: 
                                                                                                      /**
                                                                                                       *  SplitPane.navigationPane is the most recently shown
                                                                                                       *  SplitPane.listPane is the most recently shown
                                                                                                       *  SplitPane.detailPane is the most recently shown
                                                                                                       */
                                                                                                      String /* navigation |  list |  detail */?): Unit = definedExternally
    /**
     *   Calls SplitPane.navigatePane with the SplitPane.listPane as the target pane.
     * 
     *  @param {HTMLString=} optional title to use instead of the automatically chosen one
     */
    open fun navigateListPane(title: String?): Unit = definedExternally
    /**
     *   Calls SplitPane.navigatePane with the SplitPane.detailPane as the target pane.
     * 
     *  @param {HTMLString=} optional title to use instead of the automatically chosen one
     */
    open fun navigateDetailPane(title: String?): Unit = definedExternally
    /**
     *   Notification method fired when the user clicks the default back / forward buttons
     *   on the navigation bar for this SplitPane.
     * 
     *  @param {NavigationDirection} direction in which the user is attempting to navigate.
     */
    open fun navigationClick(direction: 
                                        /**
                                         *  Back
                                         *  Forward
                                         *  none
                                         */
                                        String /* back |  forward |  none */): Unit = definedExternally
    /**
     *   Notification fired when the SplitPane.currentPane changes, either due to end-user
     *   action or due to a programmatic call to SplitPane.setCurrentPane
     *   or other APIs that can change the pane.
     * 
     *   Note that depending on the DeviceMode, this event may not signal that any pane has
     *   actually been shown or hidden, since in some modes multiple panes are shown simultaneously.
     * 
     *   Never fires while the SplitPane is not drawn.
     * 
     * 
     *  @param {CurrentPane} new SplitPane.currentPane value.
     */
    open fun paneChanged(pane: 
                               /**
                                *  SplitPane.navigationPane is the most recently shown
                                *  SplitPane.listPane is the most recently shown
                                *  SplitPane.detailPane is the most recently shown
                                */
                               String /* navigation |  list |  detail */): Unit = definedExternally
    /**
     *   Notification method fired when the SplitPane.showMiniNav and the
     *   up button on the SplitPane.navigationBar's MiniNavControl is
     *   clicked.
     * 
     * 
     */
    open fun upClick(): Unit = definedExternally
    /**
     *   Notification method fired when the SplitPane.showMiniNav and the
     *   down button on the SplitPane.navigationBar's MiniNavControl is
     *   clicked.
     * 
     * 
     */
    open fun downClick(): Unit = definedExternally
    companion object {
        /**
         *  Creates a new SplitPane
         * 
         *  @param typeCheckedProperties {Partial<SplitPane>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {SplitPane} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): SplitPane = definedExternally
    }
}