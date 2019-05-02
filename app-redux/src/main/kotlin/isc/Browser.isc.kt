@file:JsQualifier("isc")
package isc

/**
 *  The Browser class contains various class attributes that indicate basic properties
 *   of the browser and whether certain features are enabled.
 */
open external class Browser : Class {
    companion object {
        /**
         *  Does the browser support both mouse and touch input?
         *  @type {boolean}
         *  @default "varies"
         */
        var supportsDualInput: Boolean = definedExternally
        /**
         *  Is the application running on a touch device (e.g. iPhone, iPad, Android device, etc.)?
         * 
         *   SmartClient's auto-detected value for isTouch can be overridden via
         *   Browser.setIsTouch.
         *  @type {boolean}
         *  @default "auto-detected based on device"
         */
        var isTouch: Boolean = definedExternally
        /**
         *  Is the application running on a tablet device (e.g. iPad, Nexus 7)?
         * 
         *   SmartClient can correctly determine whether the device is a tablet in most cases. On any
         *   uncommon device for which this variable is incorrect, you can define the isc_isTablet
         *   global with the correct value, and SmartClient will use isc_isTablet for
         *   Browser.isTablet instead of its own detection logic. Alternatively, you can use
         *   Browser.setIsTablet to change this global variable before any components are
         *   created.
         * 
         *   The value of this variable is only meaningful on touch devices.
         *  @type {boolean}
         *  @default "auto-detected based on device"
         */
        var isTablet: Boolean = definedExternally
        /**
         *  Is the application running on a handset-sized device, with a typical screen width of around
         *   3-4 inches?
         * 
         *   This typically implies that the application will be working with only 300-400 pixels.
         *  @type {boolean}
         *  @default "auto-detected based on device"
         */
        var isHandset: Boolean = definedExternally
        /**
         *  Is the application running in a desktop browser? This is true if Browser.isTablet
         *   and Browser.isHandset are both false.
         *  @type {boolean}
         *  @default "auto-detected based on device"
         */
        var isDesktop: Boolean = definedExternally
        /**
         *  Whether SmartClient supports the current browser.
         * 
         *   Note that this flag will only be available on browsers that at least support basic
         *   JavaScript.
         *  @type {boolean}
         *  @default "auto-detected based on browser"
         */
        var isSupported: Boolean = definedExternally
        /**
         *  Whether the current browser supports CSS3 and whether SmartClient is configured to use
         *   CSS3 features (via the setting of window.isc_css3Mode).
         * 
         *   If isc_css3Mode is "on" then useCSS3 is set to true. If isc_css3Mode is set to
         *   "supported", "partialSupport", or is unset, then useCSS3 is set to true only if the browser
         *   is a WebKit-based browser, Firefox, IE 9 in standards mode, or IE 10+. If isc_css3Mode is set
         *   to "off" then useCSS3 is set to false.
         *  @type {boolean}
         *  @default "see below"
         */
        var useCSS3: Boolean = definedExternally
        /**
         *  Controls how agressive components based on the GridRenderer are with respect to
         *   redraws and data fetches. Modern browsers can generally handle much more frequent redraws
         *   and most server configurations can handle fetching more data more frequently in order to
         *   reduce the lag the end user perceives when scrolling through databound grids. Starting with
         *   SmartClient 11.0/SmartGWT 6.0, this more aggressive redraw and fetch behavior us the
         *   default, but can be reverted to the old behavior if desired - see below.
         * 
         *   This flag controls the defaults for several other properties (value on left is default for
         *   high performance mode, value on right is default when this mode is disabled.
         * 
         * 
         *  - ListGrid.dataFetchDelay 1 -> 300
         * 
         *  - ListGrid.drawAheadRatio 2.0 -> 1.3
         * 
         *  - ListGrid.quickDrawAheadRatio 2.0 -> 1.3
         * 
         *  - ListGrid.scrollRedrawDelay 0 -> 75
         * 
         *  - ListGrid.scrollWheelRedrawDelay 0 -> 250
         * 
         *  - ListGrid.touchScrollRedrawDelay 0 -> 300
         * 
         *   Note: since TreeGrid is a subclass of ListGrid, the above settings
         *   also apply to TreeGrids.
         * 
         * 
         *  - GridRenderer.drawAheadRatio 2.0 -> 1.3
         * 
         *  - GridRenderer.quickDrawAheadRatio 2.0 -> 1.3
         * 
         *  - GridRenderer.scrollRedrawDelay 0 -> 75
         * 
         *  - GridRenderer.touchScrollRedrawDelay 0 -> 300
         * 
         * 
         *   By default, for all browsers except Android-based Chrome, this flag is set to true, but can
         *   be explicitly disabled by setting isc_useHighPerformanceGridTimings=false in a
         *   script block before loading SmartClient modules. Turning off high performance timings
         *   effectively enables the original SmartClient/SmartGWT behavior prior to the SmartClient
         *   11.0/SmartGWT 6.0 release.
         *  @type {boolean}
         *  @default "see below"
         */
        var useHighPerformanceGridTimings: Boolean = definedExternally
        /**
         *  Creates a new Browser
         * 
         *  @param typeCheckedProperties {Partial<Browser>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Browser} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Browser = definedExternally
        /**
         *   Setter for Browser.isTouch to allow this global variable to be changed at runtime.
         *   This advanced method is provided to override SmartClient's auto-detection logic, since the
         *   framework can only detect touch devices that existed at the time the platform was released.
         *   Any change to Browser.isTouch must be made before any component is created;
         *   it is an application error to attempt to change isTouch after
         *   components have been created.
         * 
         *   Note that setting Browser.isTouch might affect the values of
         *   Browser.isDesktop, Browser.isTablet, and/or Browser.isHandset.
         * 
         * 
         *  @param {boolean} new setting for Browser.isTablet.
         */
        fun setIsTouch(isTouch: Boolean): Unit = definedExternally
        /**
         *   Setter for Browser.isTablet to allow this global variable to be changed at runtime.
         *   This advanced method is provided to override SmartClient's detection of devices, since the
         *   framework can only detect devices that existed at the time the platform was released. Any
         *   changes to Browser.isDesktop, Browser.isHandset, or Browser.isTablet
         *   must be made before any component is created;
         *   it is an application error to attempt to change isDesktop,
         *   isHandset, or isTablet after components have been created.
         * 
         *   Note that setting Browser.isTablet might affect the values of
         *   Browser.isDesktop and Browser.isHandset.
         * 
         * 
         *  @param {boolean} new setting for Browser.isTablet.
         */
        fun setIsTablet(isTablet: Boolean): Unit = definedExternally
        /**
         *   Setter for Browser.isHandset to allow this global variable to be changed at runtime.
         *   This advanced method is provided to override SmartClient's detection of devices, since the
         *   framework can only detect devices that existed at the time the platform was released. Any
         *   changes to Browser.isDesktop, Browser.isHandset, or Browser.isTablet
         *   must be made before any component is created;
         *   it is an application error to attempt to change isDesktop,
         *   isHandset, or isTablet after components have been created.
         * 
         *   Note that setting Browser.isHandset might affect the values of
         *   Browser.isDesktop and Browser.isTablet.
         * 
         * 
         *  @param {boolean} new setting for Browser.isHandset.
         */
        fun setIsHandset(isHandset: Boolean): Unit = definedExternally
        /**
         *   Setter for Browser.isDesktop to allow this global variable to be changed at runtime.
         *   This advanced method is provided to override SmartClient's detection of devices, since the
         *   framework can only detect devices that existed at the time the platform was released. Any
         *   changes to Browser.isDesktop, Browser.isHandset, or Browser.isTablet
         *   must be made before any component is created;
         *   it is an application error to attempt to change isDesktop,
         *   isHandset, or isTablet after components have been created.
         * 
         *   Note that setting Browser.isDesktop might affect the values of
         *   Browser.isHandset and Browser.isTablet.
         * 
         * 
         *  @param {boolean} new setting for Browser.isDesktop.
         */
        fun setIsDesktop(isDesktop: Boolean): Unit = definedExternally
    }
}