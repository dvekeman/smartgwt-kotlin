@file:JsQualifier("isc")
package isc

/**
 *  An application that allows developers to create and manage SmartClient screens and
 *   datasources. This is an internal only class - do not try to use it directly
 *   in your applications. If you want to create visual tools similar to VisualBuilder,
 *   see devTools
 */
open external class VisualBuilder : Class {
    /**
     *  If set to true the built-in save file mechanism is enabled, allowing you to save files to
     *   offline storage or the server filesystem (if enabled)
     *  @type {boolean}
     *  @default false
     */
    open var saveFileBuiltinIsEnabled: Boolean = definedExternally
    /**
     *  If set to true the built-in load file mechanism is enabled, allowing you to load files from
     *   offline storage or the server filesystem (if enabled)
     *  @type {boolean}
     *  @default false
     */
    open var loadFileBuiltinIsEnabled: Boolean = definedExternally
    /**
     *  If set to true, allows the built-in save file and load file operations to access the server
     *   filesystem. Note, this also requires appropriate server-side permission - your
     *   server.properties file must specify
     *   FilesystemDataSource.enabled: true.
     * 
     *   If this property is false, saving and loading (if enabled) will be to and from local
     *   Offline.
     *  @type {boolean}
     *  @default false
     */
    open var filesystemDataSourceEnabled: Boolean = definedExternally
    /**
     *  The name of a skin to use. Note that Visual Builder may use two skins - the skin
     *   specified here, for the elements of the application you are building, and a high-contrast,
     *   white-on-black "ToolSkin" for the elements of Visual Builder itself. When in "Toolskin"
     *   mode (which is switchable at runtime through the UI), the skin property only
     *   affects the skin used by the visual elements of the application you are building.
     *  @type {string}
     *  @default "Graphite"
     */
    open var skin: String = definedExternally
    /**
     *  The default application mode. Note, this can be changed through the UI - see
     *   VisualBuilder.showModeSwitcher
     *  @type {ApplicationMode}
     *  @default "edit"
     */
    open var defaultApplicationMode: 
                                     /**
                                      *  Components behave as they would in the running application; clicking            a component in the visual design window will cause the response an
                                      *              end-user would expect
                                      *  Components have special design-time behavior layered on top of            ordinary run-time behavior; clicking a component in the visual design
                                      *              window will cause the response an application builder would expect,
                                      *              if any such special behavior is defined for that component
                                      */
                                     String /* live |  edit */ = definedExternally
    /**
     *  If this property is not explicitly set to false, Visual Builder shows a UI to allow the
     *   ApplicationMode to be toggled at runtime.
     *  @type {boolean}
     *  @default null
     */
    open var showModeSwitcher: Boolean = definedExternally
    /**
     *  If true, starts Visual Builder in mockup mode
     *  @type {boolean}
     *  @default false
     */
    open var mockupMode: Boolean = definedExternally
    /**
     *  Whether to use the existing browser window or a new one when opening a Mockup Mode screen
     *   converted to standard Component XML via "Go to Visual Builder".
     *  @type {boolean}
     *  @default true
     */
    open var openFullBuilderSeparately: Boolean = definedExternally
    /**
     *  A PaletteNode describing a component to add to an empty screen as an initial container.
     *  @type {PaletteNode}
     *  @default null
     */
    open var initialComponent: PaletteNode = definedExternally
    /**
     *  Relative URL to Visual Builder's defaultComponents.xml configuration file. The
     *   default value makes the framework look wherever Visual Builder itself was loaded from
     *  @type {string}
     *  @default "defaultComponents.xml"
     */
    open var defaultComponentsURL: String = definedExternally
    /**
     *  Relative URL to Visual Builder's defaultMockupComponents.xml configuration file. The
     *   default value makes the framework look wherever Visual Builder itself was loaded from
     *  @type {string}
     *  @default "defaultMockupComponents.xml"
     */
    open var defaultMockupComponentsURL: String = definedExternally
    /**
     *  Relative URL to Visual Builder's customComponents.xml configuration file. The
     *   default value makes the framework look wherever Visual Builder itself was loaded from
     *  @type {string}
     *  @default "customComponents.xml"
     */
    open var customComponentsURL: String = definedExternally
    /**
     *  Relative URL to Visual Builder's globalDependencies.xml configuration file. The
     *   default value makes the framework look wherever Visual Builder itself was loaded from
     *  @type {string}
     *  @default "globalDependencies.xml"
     */
    open var globalDependenciesURL: String = definedExternally
    companion object {
        /**
         *  Creates a new VisualBuilder
         * 
         *  @param typeCheckedProperties {Partial<VisualBuilder>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {VisualBuilder} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): VisualBuilder = definedExternally
    }
}