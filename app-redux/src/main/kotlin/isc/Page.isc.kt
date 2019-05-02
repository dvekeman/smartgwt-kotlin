@file:JsQualifier("isc")
package isc

/**
 *  Provides information about the page you're loaded in. We define "page" here to be roughly
 *   equivalent to the browser window or frame the libraries have been loaded in.
 */
open external class Page : Class {
    companion object {
        /**
         *  On a call to Page.checkBrowserAndRedirect(), if no explicit URL
         *     is passed in, and the browser is not supported by ISC, redirect to this URL.
         *  @type {URL}
         *  @default "[SKIN]/unsupported_browser.html"
         */
        var defaultUnsupportedBrowserURL: String = definedExternally
        /**
         *  If a URL provided to various Page APIs begins with one of these Strings, it is treated
         *   as an absolute URL.
         * 
         *   The default of protocols is:
         * 
         *     ["http://","https://","file://","mailto:", "app-resource:", "data:"]
         * 
         *   .. and can be replaced via Class.addClassProperties or
         *   via setting the global variable isc_protocolURLs before SmartClient loads.
         *  @type {Array<Partial<string>>}
         *  @default "[...]"
         */
        var protocolURLs: Array<dynamic> = definedExternally
        /**
         *  Action to take when Page.checkBrowserAndRedirect is called in a browser for which
         *   support is not guaranteed. Valid settings are:
         * 
         * 
         *  - "continue" Load the page without notifying the user of potential issues
         * 
         *  - "confirm" Notify the user via a standard confirm dialog that their browser is
         *   not supported. Provide options to continue anyway, or redirect to another page.
         * 
         *  - "redirect" Automatically redirect to the another URL
         * 
         *  @deprecated \* As discussed in browserSupport, developers are recommended to consider which browsers they wish to support within their specific application rather than relying on framework
         *   supported browser detection.
         *  @type {string}
         *  @default "continue"
         */
        var unsupportedBrowserAction: String = definedExternally
        /**
         *  A declared value of the enum type
         *   FireStyle.
         *  @type {Constant}
         *  @default "once"
         */
        var FIRE_ONCE: String = definedExternally
        /**
         *  By default most modern browsers will navigate back one page when the user hits the
         *   backspace key.
         * 
         *   Setting this attribute to true will suppress this native behavior. Alternatively,
         *   developers can explicitly return false from the keyPress event
         *   (either via event handlers applied to specific widgets, or via Page.registerKey
         *   for example) to suppress the native navigation behavior.
         *  @type {boolean}
         *  @default true
         */
        var suppressBackspaceNavigation: Boolean = definedExternally
        /**
         *  Creates a new Page
         * 
         *  @param typeCheckedProperties {Partial<Page>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Page} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Page = definedExternally
        /**
         *   Has the page finished loading?
         * 
         * 
         */
        fun isLoaded(): Boolean = definedExternally
        /**
         *   Set the title of the page, which is typically shown as part of the browser window title
         * 
         */
        fun setTitle(): Unit = definedExternally
        /**
         *   Returns the base URL of the application, which is the page URL minus the last non-directory
         *   path component. For example, if the page is loaded from
         *   http://foo.com/bar/zoo.jsp, appDir will be http://foo.com/bar/.
         * 
         *   If other page-wide URLs such as Page.setIsomorphicDir are specified as
         *   relative paths, they are considered relative to this URL.
         * 
         * 
         */
        fun getAppDir(): String = definedExternally
        /**
         *   Specify the directory for app-specific images.
         * 
         *   This becomes the default location where any SmartClient component will load images from
         *   unless the special "[SKIN]" prefix is used to indicate that an image is part of a skin.
         * 
         *   Default is "[APP]images/"
         * 
         * 
         *  @param {string=} New imgDir URL.
         */
        fun setAppImgDir(URL: String?): Unit = definedExternally
        /**
         *   Return the directory for app-specific images.
         * 
         * 
         */
        fun getAppImgDir(): String = definedExternally
        /**
         *   Specify the directory for miscellaneous app-specific files other than images, such as
         *   HTMLFlow.contentsURL, ViewLoader,
         *   XML or JSON flat data files, videos, etc.
         * 
         *   This URL also becomes available via the prefix "[APPFILES]" for RPCRequest.actionURL.
         * 
         *   Defaults to the value of Page.getAppDir, that is, the current directory.
         * 
         * 
         *  @param {string=} New app files URL.
         */
        fun setAppFilesDir(URL: String?): Unit = definedExternally
        /**
         *   Returns the directory for application-specific files (other than images).
         * 
         * 
         *  @param {string=} New app files URL.
         */
        fun getAppFilesDir(URL: String?): Unit = definedExternally
        /**
         *   Specify the root directory for Isomorphic-supplied files - the directory containing
         *   the modules/ and system/ subdirectories shipped as part of
         *   the SmartClient package.
         * 
         *   Note that this property is commonly specified directly in the bootstrap HTML file
         *   by setting window.isomorphicDir before loading the SmartClient library files.
         * 
         * 
         *  @param {string=} New IsomorphicDir URL.
         */
        fun setIsomorphicDir(URL: String?): Unit = definedExternally
        /**
         *   Return the root directory for Isomorphic-specific files.
         * 
         * 
         */
        fun getIsomorphicDir(): String = definedExternally
        /**
         *   Specify the root directory for Isomorphic-supplied tools. Typicall tools/ under webRoot.
         * 
         *   Note that this property is commonly specified directly in the bootstrap HTML file
         *   by setting window.isomorphicToolsDir before loading the SmartClient library
         *   files. If unset, it defaults to $isomorphicDir/../tools/
         * 
         * 
         *  @param {string=} New IsomorphicToolsDir URL.
         */
        fun setIsomorphicToolsDir(URL: String?): Unit = definedExternally
        /**
         *   Return the root directory for Isomorphic-supplied tools dir.
         * 
         * 
         */
        fun getIsomorphicToolsDir(): String = definedExternally
        /**
         *   Specify the URL for media that's part of the skin
         * 
         * 
         *  @param {string=} New skinDir URL
         */
        fun setSkinDir(URL: String?): Unit = definedExternally
        /**
         *   Return the directory for media that's part of the skin
         * 
         * 
         */
        fun getSkinDir(): String = definedExternally
        /**
         *   Return the directory for a skin image.
         * 
         * 
         *  @param {URL=} Partial URL (relative to Page._skinDir) where the image lives.     If not supplied, will use "images/"
         */
        fun getSkinImgDir(imgDir: String?): String = definedExternally
        /**
         *   Return the full URL for app-specific or skin image.
         * 
         *   To use a skin image, start the URL with "[SKIN]". Any other relative URL is assumed
         *   relative to the Page.getAppImgDir.
         * 
         * 
         *  @param {SCImgURL} Local file name for the image.
         *  @param {string=} User-specified image directory,     local to
         */
        fun getImgURL(src: String, imgDir: String?): String = definedExternally
        /**
         *   Return a full URL for a relative path that uses a special prefix such as "[APPFILES]" or
         *   "[SKIN]".
         * 
         *   For images, use Page.getImgURL instead.
         * 
         * 
         *  @param {string} Local file name for the image.
         */
        fun getURL(fileName: String): String = definedExternally
        /**
         * 
         *   Return whether the page text direction is right to left. If you set "DIR=RTL" in the BODY tag of
         *   the page, then this method will return true. If you set "DIR=LTR" then this method will return
         *   false.
         * 
         * 
         */
        fun isRTL(): Boolean = definedExternally
        /**
         *   Load a styleSheet for this application.
         * 
         *   The styleSheetURL parameter can use any special directories, eg:
         *     &nbsp;&nbsp;Page.loadStylesheet("[SKIN]/skin_styles.css")
         *     or
         *     &nbsp;&nbsp;Page.loadStylesheet("[APP]/app_styles.css").
         * 
         *   If you don't specify a special directory, the app directory
         *     will be assumed.
         * 
         *   Note:  If the document's ONLOAD handler has already fired, this
         *    will have no effect.
         * 
         * 
         *  @param {URL} URL to the stylesheet.
         */
        fun loadStyleSheet(styleSheetURL: String): Unit = definedExternally
        /**
         *   Resize the outer portion of the window to a specific width and height.
         * 
         *  @param {number} new width for the window
         *  @param {number} new height for the window
         */
        fun resizeTo(width: Number, height: Number): Unit = definedExternally
        /**
         *   Move the window to a specified top and left in screen coordinates.
         * 
         * 
         *  @param {number} new left coordinate for window
         *  @param {number} new top coordinate for window
         */
        fun moveTo(left: Number, top: Number): Unit = definedExternally
        /**
         *   Scroll the window to a specified top and left coordinate.
         * 
         * 
         *  @param {number} new left coordinate for window
         *  @param {number} new top coordinate for window
         */
        fun scrollTo(left: Number, top: Number): Unit = definedExternally
        /**
         *   Get the width of the visible portion of the window, not including browser chrome or the
         *   scrollbar area.
         * 
         *   See also Page.getOrientation.
         * 
         *  @param {object=} the window object
         */
        fun getWidth(wd: dynamic?): Number = definedExternally
        /**
         *   Get the height of the visible portion of the window, not including browser chrome or the
         *   scrollbar area.
         * 
         *   See also Page.getOrientation.
         * 
         *  @param {object=} the window object
         */
        fun getHeight(wd: dynamic?): Number = definedExternally
        /**
         *   Is the current page wider than it is tall ("landscape" orientation) or the reverse
         *   ("portrait" orientation). Note that the PageEvent
         *   will be fired whenever the page orientation changes.
         * 
         *   This method is typically useful for apps developed for display on mobile devices,
         *   though it will also return a valid value when running against a desktop browser.
         *   See also mobileDevelopment on building applications
         *   for mobile devices
         * 
         */
        fun getOrientation(): 
                              /**
                               *  Landscape orientation: page is wider than it is tall.
                               *  Portrait orientation: page is taller than it is wide.
                               */
                              String /* landscape |  portrait */ = definedExternally
        /**
         *   This method only applies to browsers that support the special viewport meta tag, such as
         *   Mobile Safari running on the iPhone.
         * 
         *   This method will dynamically change the viewport configuration, allowing you to set an
         *   initial size or scale level and enable / disable user-scaling. Typically this method will
         *   be called with a value for scale, width or height rather than passing in values for all
         *   three properties.
         * 
         *   See Apple's Safari Web Content Guide on configuring the viewport for more information:
         *   https://developer.apple.com/library/safari/documentation/AppleApplications/Reference/SafariWebContent/UsingtheViewport/UsingtheViewport.html
         * 
         *   Note: Modifying the width/height or initial scale of the viewport has two user-visible
         *   effects:
         * 
         * 
         *  - HTML elements may reflow to fit the specified size (or the implied size calculated
         *     from the specified scale level and the native device size).
         * 
         *  - If the user has not scaled the application explicitly, and no other scaling or sizing
         *     attributes were specified via a viewport meta tag for this page, the application will
         *     zoom to specified scale level (or the scale level required to fit the specified viewport
         *     size to the device's screen).
         * 
         * 
         *  @param {Float=} Desired scale level where 1 indicates no scaling (each css pixel  will be displayed using 1px on the physical device). Pass in null to avoid setting  this property.
         *  @param {Integer=} Desired viewport width in pixels. This indicates how many pixels  should fit within the device screen. Pass in null to avoid setting this property.
         *  @param {Integer=} Desired viewport height in pixels. This indicates how many pixels  should fit within the device screen. Pass in null to avoid setting this property.
         *  @param {boolean=} Should the user be able to scale the application (using  pinch gestures, double tapping, rotating the device, etc.)? Pass in null to avoid setting  this property.
         */
        fun updateViewport(scale: Number?, width: Number?, height: Number?, scalable: Boolean?): Unit = definedExternally
        /**
         *   Get the width of the window contents as they have been drawn.
         *   If the page scrolls, this may be larger than the page.getWidth().
         * 
         */
        fun getScrollWidth(): Number = definedExternally
        /**
         *   Get the height of the window contents as they have been drawn.
         *   If the page scrolls, this may be larger than the page.getHeight().
         * 
         */
        fun getScrollHeight(): Number = definedExternally
        /**
         *   Get the amount that the browser window has been scrolled horizontally.
         * 
         */
        fun getScrollLeft(): Number = definedExternally
        /**
         *   Get the amount that the browser window has been scrolled vertically.
         * 
         */
        fun getScrollTop(): Number = definedExternally
        /**
         *   Get the width of the user's screen, in pixels.
         * 
         */
        fun getScreenWidth(): Unit = definedExternally
        /**
         *   Get the height of the user's screen, in pixels.
         * 
         */
        fun getScreenHeight(): Unit = definedExternally
        /**
         *   Go back in the browser's history.
         * 
         *   If the history is empty and the window.opener is set, we assume we're a child window and just
         *   close the window.
         * 
         * 
         */
        fun goBack(): Unit = definedExternally
        /**
         *   Wait for a method to fire on an object.
         * 
         *   waitFor is similar Class.observe, but fires once only.
         * 
         * 
         *  @param {object} any SmartClient object, eg, a ListGrid
         *  @param {string} name of a method on that object
         *  @param {Function} Callback to fire when the observed method completes
         *  @param {number=} Optional timeout period (in milliseconds). If you want a timeout,              you must also provide a timeoutCallback
         *  @param {Function=} Callback to fire if the timeout period elapses before the                   observed method completes
         */
        fun waitFor(`object`: dynamic, methodName: String, callback: (() -> dynamic), timeout: Number?, timeoutCallback: (() -> dynamic?)): Boolean = definedExternally
        /**
         *   Wait for methods to fire on multiple objects.
         * 
         *   waitForMultiple is similar to Page.waitFor, except that it does not fire
         *   its callback until all of the provided methods have fired.
         * 
         * 
         *  @param {Array<any>} an array of objects, each of which consists of two properties:            "object": any SmartClient object, eg a ListGrid             "method": name of a method on that object
         *  @param {Function} Callback to fire when all observed methods have fired
         *  @param {number=} Optional timeout period (in milliseconds). If you want a timeout,              you must also provide a timeoutCallback
         *  @param {Function=} Callback to fire if the timeout period elapses before all                   observed methods have fired
         */
        fun waitForMultiple(objects: Array<dynamic>, callback: (() -> dynamic), timeout: Number?, timeoutCallback: (() -> dynamic?)): Boolean = definedExternally
        /**
         *   Check whether the browser is supported by the Isomorphic SmartClient system. Behavior depends
         *   upon the value of Page.unsupportedBrowserAction:
         * 
         * 
         *  - "continue" Load the page without notifying the user of potential issues
         * 
         *  - "confirm" Notify the user via a standard confirm dialog that their browser is
         *   not supported. Provide options to continue anyway, or redirect to another page. Text of the
         *   confirm dialog is retrieved by calling Page.getUnsupportedBrowserPromptString.
         * 
         *  - "redirect" Automatically redirect to the another URL
         * 
         *   If redirecting to another page is necessary, and no explicit URL is provided we will use
         *   Page.defaultUnsupportedBrowserURL.
         * 
         *   This method is commonly called as part of the skinning logic after page
         *   load.
         * 
         * 
         *  @param {string=} URL of redirect page. May include Isomorphic special directories   such as [SKIN].
         *  @deprecated \* As discussed in browserSupport, developers are recommended to consider which browsers they wish to support within their specific application rather than relying on framework
         *   supported browser detection.
         */
        fun checkBrowserAndRedirect(URL: String?): Unit = definedExternally
        /**
         *   Returns the text for the prompt shown to user from Page.checkBrowserAndRedirect
         *   if they are accessing this page in an unsupported
         *   browser and Page.unsupportedBrowserAction is set to "confirm". May be
         *   overridden to return a different message.
         * 
         */
        fun getUnsupportedBrowserPromptString(): String = definedExternally
        /**
         *   Setting this to true will cause Page.loadStyleSheet to append
         *   an "isc_version" parameter to the end of the url when loading a stylesheet.
         * 
         * 
         *  @param {boolean} pass in true to turn on automatic adding of version                       parameter to css urls.
         */
        fun setAddVersionToSkinCSS(addVersionToSkinCss: Boolean): Unit = definedExternally
        /**
         *   Returns true if add version to skin CSS is currently turned on.
         * 
         * 
         */
        fun isAddVersionToSkinCSS(): Boolean = definedExternally
        /**
         *   Register to be called whenever a given type of event occurs, at the page level.
         * 
         *   This includes events that also occur on widgets (like "click") and events that only occur at
         *   the page level ("resize" and "load").
         * 
         *   For events that also occur on widgets, page level event registrations will fire BEFORE the
         *   event handlers on Canvases.  If your action returns false, this will prevent
         *   the event from getting to the intended Canvas.
         * 
         *   Capturing events on widgets can be done by setting one of the event methods available on Canvas
         *   (and hence available to all widget classes). See widgetEvents.
         * 
         * 
         *  @param {PageEvent} event type to register for ("mouseDown", "load", etc)
         *  @param {string} string to be eval'd when event fires   (function)  function to be executed when event fires            (object)      an object to call on which a method named "page" +                      eventType will be called
         *  @param {FireStyle=} Flag to set automatic removal of the event after      it fires one or more times
         *  @param {string=} optional - if an object was passed in as the second                     parameter, this is a name of a method to call on that                      object.
         */
        fun setEvent(eventType: 
                                /**
                                 *  Fires repeatedly (every 10 ms by default) when the system is idle (i.e.,
                                 *      not busy running other scripts) after the page is loaded.
                                 *  Fires when the page has finished loading. It corresponds to the
                                 *      browser 'load' event normally handled by window.onload.
                                 *  Fires when the page is exited or unloaded. It corresponds to the
                                 *      browser 'unload' event normally handled by window.onunload.
                                 *  Fires when the browser window is resized by the user. It corresponds
                                 *      to the browser 'resize' event normally handled by window.onresize.
                                 *  Fires when the left mouse button is pressed on the Page.
                                 *  Fires when the right mouse button is pressed on the Page.
                                 *  Fires when the mouse moves on the Page.
                                 *  Fires when the left mouse button released on the Page.
                                 *  Fires when the user clicks the mouse on the Page.
                                 *  Fires when the uesr double-clicks on the Page.
                                 *  Fires when the right mouse button is clicked on the page. If your event handler
                                 *      for this event returns false, the native browser context menu will be suppressed.
                                 *      Note: On the Macintosh platform, Command+Click may be used instead
                                 *      of right-button click to trigger a context menu event.
                                 *      On the Opera browser, Ctrl+Shift+Click should be used instead of
                                 *      right-button click.
                                 *  Fires when a user presses a key on the keyboard.
                                 *  Fires when the Page.getOrientation changes due    to browser-window resize or rotation of a mobile device.
                                 *  Fires when the FontLoader completes loading custom fonts.
                                 *  Fires after a timeout if the FontLoader fails to load all custom
                                 *      fonts.
                                 * 
                                 *   see classMethod:Page.setEvent()
                                 *   see classMethod:Page.clearEvent()
                                 */
                                String /* idle |  load |  unload |  resize |  mouseDown |  rightMouseDown |  mouseMove |  mouseUp |  click |  doubleClick |  showContextMenu |  keyPress |  orientationChange |  fontsLoaded |  fontLoadingFailed */, action: String, fireStyle: dynamic?, functionName: String?): Number = definedExternally
        /**
         *   Clear event(s) under the given eventType.
         *   To clear all events, omit the ID parameter. To clear a specific event,
         *   pass the ID that was returned by Page.setEvent().
         * 
         *  @param {PageEvent | Event} event type to clear
         *  @param {number=} ID of the event to clear.      If not specified, all events in eventType will be cleared.
         */
        fun clearEvent(eventType: dynamic, ID: Number?): Unit = definedExternally
        /**
         *   Fire some action when the Page receives a keyPress event from a certain key.
         *   Note that if a widget has keyboard focus, this action will fire only after any widget-level
         *   keyPress handlers have fired and bubbled the event up to the top of their ancestor chain.
         *   Multiple actions can be registered to fire on a single keyPress using this method, and can
         *   be associated with different target objects (which will then be available as
         *   a parameter when the action is fired).
         * 
         * 
         *   This differs from calling Page.setEvent with the "keyPress"
         *   events registered via setEvent() will fire before widget level handlers
         *   respond to the event, and will fire for every keyPress event, not just those
         *   triggered by some specific key or key-combination.
         * 
         * 
         * 
         * 
         *  @param {KeyIdentifier} key name or identifier object.
         *  @param {string} Action to fire when key is pressed.       This can be a string of script to evaluate or a javascript function.        This action will be passed 2 parameters: The name of the key pressed will be        available as the first parameter or key keyword. The target        passed into this method will be available as the second parameter or        target keyword.
         *  @param {any=} If specified this object will be made available to the                 action fired as a parameter.
         */
        fun registerKey(key: KeyIdentifier, action: String, target: dynamic?): Unit = definedExternally
        /**
         *   Clears an action registered to fire on a specific a keyPress event via the Page.registerKey
         *   method.
         * 
         *  @param {KeyName} Name of key to clear registry entries for.
         *  @param {object=} target specified when the action was registered for the key.
         */
        fun unregisterKey(actionID: String, target: dynamic?): Unit = definedExternally
    }
}