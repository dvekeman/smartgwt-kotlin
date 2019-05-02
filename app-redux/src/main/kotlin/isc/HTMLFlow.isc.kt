@file:JsQualifier("isc")
package isc

/**
 *  Use the HTMLFlow component to display HTML content that should expand to its natural size
 *   without scrolling.
 * 
 *   HTML content can be loaded and reloaded from a URL via the property
 *   contentsURL. This method of loading is for simple HTML content
 *   only; SmartClient components should be loaded via the ViewLoader class.
 * 
 *   NOTE: Since the size of an HTMLFlow component is determined by its HTML contents, this
 *   component will draw at varying sizes if given content of varying size. When using HTMLFlow
 *   components within a Layout, consider what will happen if the HTMLFlow renders at various
 *   sizes. An HTMLFlow which can expand should be placed in a container where other components
 *   can render smaller, where the container is allowed to scroll, or where there is padding to
 *   expand into.
 * 
 *   HTMLFlow is a DataBoundComponent but only supports one method at this time,
 *   HTMLFlow.fetchRelatedData.
 */
open external class HTMLFlow : Canvas, DataBoundComponent {
    /**
     *  The contents of a canvas or label widget. Any HTML string is acceptable.
     *  @type {HTMLString}
     *  @default "&amp;nbsp;"
     */
    override var contents: String = definedExternally
    /**
     *  Dynamic contents allows the contents string to be treated as a simple, but powerful
     *   template. When this attribute is set to true, expressions of the form &#36;{arbitrary JS
     *   here} are replaced by the result of the evaluation of the JS code inside the curly
     *   brackets. This evaluation happens at draw time. If you want to trigger a re-evaluation
     *   of the expressions in the contents string you can call markForRedraw() on the canvas.
     * 
     *   You can use this feature to build some simple custom components. For example, let's say
     *   you want to show the value of a Slider in a Canvas somewhere on the screen. You can do
     *   this by observing the valueChanged() method on the slider and calling setContents() on
     *   your canvas with the new string or you can set the contents of the canvas to something
     *   like:
     * 
     *   "The slider value is &#36;{sliderInstance.getValue()}."
     * 
     *   Next you set dynamicContents: true on the canvas, observe valueChanged() on the slider
     *   and call canvas.markForRedraw() in that observation. This approach is cleaner than
     *   setContents() when the Canvas is aggregating several values or dynamic expressions.
     *   Like so:
     * 
     * 
     *   Slider.create({
     *     ID: "mySlider"
     *   });
     * 
     *   Canvas.create({
     *     ID: "myCanvas",
     *     dynamicContents: true,
     *     contents: "The slider value is &#36;{mySlider.getValue()}."
     *   });
     * 
     *   myCanvas.observe(mySlider, "valueChanged",
     *           "observer.markForRedraw()");
     * 
     *   You can embed an arbitrary number of dynamic expressions in the contents string. The
     *   search and replace is optimized for speed.
     * 
     *   If an error occurs during the evaluation of one of the expressions, a warning is logged
     *   to the ISC Developer Console and the error string is embedded in place of the expected
     *   value in the Canvas.
     * 
     *   The value of a function is its return value. The value of any variable is the same as
     *   that returned by its toString() representation.
     * 
     *   Inside the evaluation contentext, this points to the canvas instance that
     *   has the dynamicContents string as its contents - in other words the canvas instance on
     *   which the template is declared.
     *  @type {boolean}
     *  @default false
     */
    override var dynamicContents: Boolean = definedExternally
    /**
     *  URL to load content from.
     * 
     *   If specified, this component will load HTML content from the specified URL when it is
     *   first drawn.
     * 
     *   This feature relies on the XMLHttpRequest object which can be disabled by end-users in some
     *   supported browsers. See platformDependencies for more information.
     *  @type {URL}
     *  @default null
     */
    open var contentsURL: String = definedExternally
    /**
     *  HTML to show while content is being fetched, active only if the contentsURL
     *   property has been set.
     *   Use "&#36;{loadingImage}" to include Canvas.loadingImageSrc.
     * 
     *   The loading message will show both during the initial load of content, and during reload if
     *   the contents are reloaded or the contentsURL changed. For a first-time only loading
     *   message, initialize the contents property instead.
     *   Note: the loadingMessage is never displayed when loading complete web pages
     *   rather than HTML fragments (see HTMLFlow.contentsType).
     *  @type {HTMLString}
     *  @default "&amp;nbsp;${loadingImage}"
     */
    open var loadingMessage: String = definedExternally
    /**
     *  Parameters to be sent to the contentsURL when fetching content.
     *  @type {object}
     *  @default null
     */
    open var contentsURLParams: dynamic = definedExternally
    /**
     *  Selects the HTTP method that will be used when fetching content. Valid values are "POST"
     *   and "GET".
     *  @type {SendMethod}
     *  @default "GET"
     */
    open var httpMethod: 
                         /**
                          *  GET method (regular URL encoding)
                          *  POST method (form field encoding)
                          */
                         String /* GET |  POST */ = definedExternally
    /**
     *  The default setting of null or 'fragment' indicates that HTML loaded from
     *   HTMLFlow.contentsURL is assumed to be an HTML fragment rather than a complete page. Set to
     *   "page" to load HTML as a standalone page, via an IFRAME.
     * 
     *   contentsType:"page" should only be used for controlled HTML content, and only
     *   when such content cannot be delivered as an HTML fragment instead (the default). To
     *   dynamically load SmartClient components, use ViewLoader, never this mechanism
     *   (click noFrames for why).
     * 
     *   Loading HTML content as a fragment is less resource intensive and avoids visual artifacts
     *   such as translucent media becoming opaque or disappearing when placed over an IFRAME.
     * 
     *   Loading third-party, uncontrolled content could lead to the surrounding page disappearing if
     *   a user clicks on an HTML link with target=_top.
     * 
     *   With contentsType:"page", HTMLFlow.loadingMessage is not supported, and only
     *   "GET" is supported for HTMLFlow.httpMethod.
     * 
     *   Note that a native bug has been observed in Internet Explorer version 10 whereby
     *   if an HTMLFlow with contentsType set to "page"
     *   loads a page containing an HTML &lt;frameset&gt;, when the HTMLFlow
     *   is Canvas.hide, it can interfere with the rendering of other elements on
     *   the page. Setting Canvas.shrinkElementOnHide to true will work
     *   around this behavior.
     *  @type {ContentsType}
     *  @default null
     */
    open var contentsType: 
                           /**
                            *  the contentsURL is assumed to be a standalone HTML page, and is loaded in an IFRAME.
                            *  the default setting - indicates that HTML loaded from the contentsURL is assumed to be an HTML fragment rather than a complete page.
                            */
                           String /* page |  fragment */ = definedExternally
    /**
     *  By default an HTMLFlow will explicitly prevent browser caching.
     * 
     *   Set to true to allow browser caching if the browser would normally do so, in other
     *   words, if the HTTP headers returned with the response indicate that the response can be
     *   cached.
     *  @type {boolean}
     *  @default false
     */
    open var allowCaching: Boolean = definedExternally
    /**
     *  If evalScriptBlocks is true, HTMLFlow will pre-process the loaded HTML in order to
     *   mimic how the HTML would execute if it were loaded as an independent page or loaded via an
     *   IFRAME.
     * 
     *   This feature is intended to assist with migrating existing applications to SmartClient.
     * 
     *   evalScriptBlocks is enabled by default when loading remote content (via
     *   HTMLFlow.contentsURL) and disabled by default for content supplied via HTMLFlow.setContents.
     * 
     *   Note that, if evalScriptBlocks is false, &lt;SCRIPT&gt; blocks will still be detected and disabled
     *   to avoid the inconsistent results across different browsers.
     * 
     *   Only applies when contentsType is not "page".
     *  @type {boolean}
     *  @default null
     */
    open var evalScriptBlocks: Boolean = definedExternally
    /**
     *  If true, SmartClient components created while executing the loaded HTML are captured
     *   for rendering inside the HTMLFlow.
     * 
     *   Only applies when contentsType is not "page".
     *  @type {boolean}
     *  @default true
     */
    open var captureSCComponents: Boolean = definedExternally
    /**
     *  When this HTMLFlow is focused, causes Ctrl-A / Command-A keypresses to select just
     *   the content, as opposed to all content on the screen becoming selected. This HTMLFlow
     *   must be Canvas.canFocus in order for this setting to have an effect.
     * 
     *   Not valid with HTMLFlow.contentsType
     *   "page".
     * 
     *  @type {boolean}
     *  @default null
     */
    open var selectContentOnSelectAll: Boolean = definedExternally
    /**
     *  When using HTMLFlow.contentsType
     *   "page",
     * 
     *   sets the &lt;iframe&gt; sandbox attribute to the provided value.
     * 
     *   Use the value "\*ALL\*" to cause the "sandbox" attribute to be output with no value
     *   (which causes full sandboxing).
     * 
     *   See any HTML reference for other legal values of the "sandbox" attribute, which allow
     *   you to remove individual restrictions on the loaded content.
     * 
     *   Note that SmartClient simply applies the provided value to the generated &lt;iframe&gt;
     *   element and cannot fix bugs or differences in sandbox behavior across different browsers.
     *  @type {string}
     *  @default null
     */
    open var iframeSandbox: String = definedExternally
    /**
     *  Before we start editing values in this DataBoundComponent, should we perform a deep clone
     *   of the underlying values. See DataSource.deepCloneOnEdit for details of what this means.
     * 
     *   If this value is not explicitly set, it defaults to the value of DataSource.deepCloneOnEdit.
     *   This value can be overridden per-field with DataSourceField.deepCloneOnEdit.
     * 
     *   Like the other deepCloneOnEdit settings, this flag only has an effect if you are
     *   editing a values object that contains nested objects or arrays, using
     *   Canvas.dataPaths.
     *  @type {boolean}
     *  @default null
     */
    override var deepCloneOnEdit: Boolean = definedExternally
    /**
     *  When editing values in this DataBoundComponent, should we perform a deep clone of values
     *   that are not associated with a field (ie, attributes on the record that do not map to a
     *   component field either directly by name, or by FormItem.dataPath. If this value is
     *   not explicitly set, it defaults to the value of
     *   DataSource.deepCloneNonFieldValuesOnEdit if there is a dataSource, or to the value
     *   of the static DataSource.deepCloneNonFieldValuesOnEdit if there is no
     *   dataSource.
     * 
     *   Like the other deepCloneOnEdit settings, this flag only has an effect if you are
     *   editing a values object that contains nested objects or arrays.
     *  @type {boolean}
     *  @default null
     */
    override var deepCloneNonFieldValuesOnEdit: Boolean = definedExternally
    /**
     *  The DataSource that this component should bind to for default fields and for performing
     *   DSRequest.
     * 
     *   Can be specified as either a DataSource instance or the String ID of a DataSource.
     *  @type {DataSource | GlobalId}
     *  @default null
     */
    override var dataSource: dynamic = definedExternally
    /**
     *  How to fetch and manage records retrieve from the server. See FetchMode.
     * 
     *   This setting only applies to the ResultSet automatically created by calling
     *   ListGrid.fetchData. If a pre-existing ResultSet is passed to setData() instead, it's
     *   existing setting for ResultSet.fetchMode applies.
     *  @type {FetchMode}
     *  @default "paged"
     */
    override var dataFetchMode: 
                                /**
                                 *  All records that match the current filter are fetched. Sorting is        performed on the client.
                                 *  Only requested ranges of records are fetched, with predictive fetch        ahead. Sorting is performed on the server.
                                 *  All records available from the DataSource are fetched. Filtering by        search criteria and sorting are both performed on the client.
                                 */
                                String /* basic |  paged |  local */ = definedExternally
    /**
     *  When using DataBoundComponent.dataFetchMode, how many records to fetch at a time. If set to
     *   a positive integer, dataPageSize will override the default
     *   ResultSet.resultSize for ResultSets automatically created when you call
     *   method:DataBoundComponent.fetchData (and similarly for the ResultTree.resultSize of
     *   ResultTrees). Leaving dataPageSize at its default means to just use the default page
     *   size of the data container.
     * 
     *   Note that regardless of the dataPageSize setting, a component will always fetch
     *   all of data that it needs to draw. Settings such as
     *   ListGrid.showAllRecords,
     *   ListGrid.drawAllMaxCells and
     *   ListGrid.drawAheadRatio can cause more rows than the configured
     *   dataPageSize to be fetched.
     *  @type {Integer}
     *  @default null
     */
    override var dataPageSize: Number = definedExternally
    /**
     *  Delay in milliseconds before fetching data.
     * 
     *   This setting only applies to the ResultSet automatically created by calling
     *   ListGrid.fetchData. If a pre-existing ResultSet is passed to setData() instead, it's
     *   existing setting for ResultSet.fetchDelay applies.
     *  @type {Integer}
     *  @default null
     */
    override var dataFetchDelay: Number = definedExternally
    /**
     *  A DataBoundComponent manipulates records with one or more fields, and
     *   component.fields tells the DataBoundComponent which fields to present, in what
     *   order, and how to present each field.
     * 
     *   When both component.fields and
     *   DataBoundComponent.dataSource are set,
     *   any fields in component.fields with the same name as a DataSource field
     *   inherit properties of the DataSource field. This allows you to centralize data model
     *   information in the DataSource, but customize presentation of DataSource fields on a
     *   per-component basic. For example, in a ListGrid, a shorter title or format for a field
     *   might be chosen to save space.
     * 
     *   By default, only fields specified on the component are shown, in the order specified on
     *   the component. The DataBoundComponent.useAllDataSourceFields flag can be set to show all fields
     *   from the DataSource, with component.fields acting as field-by-field
     *   overrides and/or additional fields.
     * 
     *   If a DataBoundComponent is given a DataSource, but no component.fields, the
     *   "default binding" is used: fields are shown in DataSource order, according
     *   to the properties DataBoundComponent.showHiddenFields and
     *   DataBoundComponent.showDetailFields.
     *  @type {Array<Partial<DataSourceField>>}
     *  @default null
     */
    override var fields: Array<dynamic> = definedExternally
    /**
     *  If true, the set of fields given by the "default binding" (see
     *   DataBoundComponent.fields) is used, with any fields specified in
     *   component.fields acting as overrides that can suppress or modify the
     *   display of individual fields, without having to list the entire set of fields that
     *   should be shown.
     * 
     *   If component.fields contains fields that are not found in the DataSource,
     *   they will be shown after the most recently referred to DataSource field. If the new
     *   fields appear first, they will be shown first.
     * 
     *   ${isc.DocUtils.linkForExampleId('validationFieldBinding', 'This example')} shows a mixture of component
     *   fields and DataSource fields, and how they interact for validation.
     * 
     *   This setting may be cleared if a FieldPicker is used to edit the component's field
     *   order.
     *  @type {boolean}
     *  @default false
     */
    override var useAllDataSourceFields: Boolean = definedExternally
    /**
     *  Whether to show fields marked hidden:true when a DataBoundComponent is given a
     *   DataSource but no component.fields.
     * 
     *   The hidden property is used on DataSource fields to mark fields that are
     *   never of meaning to an end user.
     *  @type {boolean}
     *  @default false
     */
    override var showHiddenFields: Boolean = definedExternally
    /**
     *  Whether to show fields marked detail:true when a DataBoundComponent is
     *   given a DataSource but no component.fields.
     * 
     *   The detail property is used on DataSource fields to mark fields that
     *   shouldn't appear by default in a view that tries to show many records in a small space.
     *  @type {boolean}
     *  @default false
     */
    override var showDetailFields: Boolean = definedExternally
    /**
     *  Whether to show fields of non-atomic types when a DataBoundComponent is given a
     *   DataSource but no component.fields.
     * 
     *   If true, the component will show fields that declare a complex type, for example, a
     *   field 'shippingAddress' that declares type 'Address', where 'Address' is the ID of a
     *   DataSource that declares the fields of a shipping address (city, street name, etc).
     * 
     *   Such fields may need custom formatters or editors in order to create a usable interface,
     *   for example, an Address field in a ListGrid might use a custom formatter to combine the
     *   relevant fields of an address into one column, and might use a pop-up dialog for
     *   editing.
     *  @type {boolean}
     *  @default true
     */
    override var showComplexFields: Boolean = definedExternally
    /**
     *  DSRequest.operationId this component should use when performing fetch operations.
     *  @type {string}
     *  @default null
     */
    override var fetchOperation: String = definedExternally
    /**
     *  DSRequest.operationId this component should use when performing update operations.
     *  @type {string}
     *  @default null
     */
    override var updateOperation: String = definedExternally
    /**
     *  DSRequest.operationId this component should use when performing add operations.
     *  @type {string}
     *  @default null
     */
    override var addOperation: String = definedExternally
    /**
     *  DSRequest.operationId this component should use when performing remove operations.
     *  @type {string}
     *  @default null
     */
    override var removeOperation: String = definedExternally
    /**
     *  The list of field-names to export. If provided, the field-list in the exported output is
     *   limited and sorted as per the list.
     * 
     *   If exportFields is not provided, the exported output includes all visible fields
     *   from this component, sorted as they appear.
     *  @type {Array<Partial<string>>}
     *  @default null
     */
    override var exportFields: Array<dynamic> = definedExternally
    /**
     *  Setting exportAll to true prevents the component from passing it's list of fields to the
     *   export call. The result is the export of all visible fields from DataSource.fields.
     * 
     *   If exportAll is false, an export operation will first consider
     *   DataBoundComponent.exportFields, if it's set, and fall back on all visible fields from
     *   DataSource.fields otherwise.
     *  @type {boolean}
     *  @default false
     */
    override var exportAll: Boolean = definedExternally
    /**
     *  If Summary rows exist for this component, whether to include them when exporting client data.
     *  @type {boolean}
     *  @default true
     */
    override var exportIncludeSummaries: Boolean = definedExternally
    /**
     *  Flag controlling when to recategorize records being dropped on a databound
     *   component from another databound component.
     *  @type {RecategorizeMode}
     *  @default "checked"
     */
    override var dragRecategorize: 
                                   /**
                                    *  recategorize is always applied
                                    *  recategorize if normal checks pass
                                    *  never recategorize
                                    */
                                   String /* always |  checked |  never */ = definedExternally
    /**
     *  If set, detect and prevent duplicate records from being transferred to this component, either via
     *   drag and drop or via DataBoundComponent.transferSelectedData. When a duplicate transfer is detected,
     *   a dialog will appear showing the DataBoundComponent.duplicateDragMessage.
     * 
     *   If the component either does not have a DataSource or has a DataSource with no
     *   DataSourceField.primaryKey declared, duplicate checking is off by
     *   default. If duplicate checking is enabled, it looks for an existing record in the dataset
     *   that has all of the properties of the dragged record, and considers that a duplicate.
     * 
     *   For DragDataAction:"copy" where the target DataSource is related to the source
     *   DataSource by foreignKey, a duplicate means that the target list, as filtered by the current
     *   criteria, already has a record whose value for the foreignKey field matches the
     *   primaryKey of the record being transferred.
     * 
     *   For example, consider dragging "employees" to "teams", where "teams" has a field
     *   "teams.employeeId" which is a foreignKey pointing to "employees.id", and the target
     *   grid has search criteria causing it to show all the members of one team. A duplicate -
     *   adding an employee to the same team twice - is when the target grid's dataset contains an
     *   record with "employeeId" matching the "id" field of the dropped employee.
     *  @type {boolean}
     *  @default null
     */
    override var preventDuplicates: Boolean = definedExternally
    /**
     *  Message to show when a user attempts to transfer duplicate records into this component, and
     *   DataBoundComponent.preventDuplicates is enabled.
     * 
     *   If set to null, duplicates will not be reported and the dragged duplicates will not be
     *   saved.
     *  @type {string}
     *  @default "Duplicates not allowed"
     */
    override var duplicateDragMessage: String = definedExternally
    /**
     *  Indicates whether the text of the offlineMessage property should be displayed if no data is
     *   available because we do not have a suitable offline cache
     *  @type {boolean}
     *  @default true
     */
    override var showOfflineMessage: Boolean = definedExternally
    /**
     *  Message to display when this DataBoundComponent attempts to load data that is not available
     *   because the browser is currently offline. Depending on the component, the message is either
     *   displayed in the component's body, or in a pop-up warning dialog.
     *  @type {string}
     *  @default "This data not available while offline"
     */
    override var offlineMessage: String = definedExternally
    /**
     *  Message to display when this DataBoundComponent attempts to save data while the application
     *   is offline.
     *  @type {string}
     *  @default "Data cannot be saved because you are not online"
     */
    override var offlineSaveMessage: String = definedExternally
    /**
     *  Indicates whether to add "drop values" to items dropped on this component, if both
     *       the source and target widgets are databound, either to the same DataSource or
     *       to different DataSources that are related via a foreign key. "Drop values" are
     *       properties of the dropped item that you wish to change (and persist) as a
     *       result of the item being dropped on this grid.
     * 
     *       If this value is true and this component is databound, DataBoundComponent.getDropValues will
     *       be called for every databound item dropped on this grid, and an update performed
     *       on the item
     *  @type {boolean}
     *  @default true
     */
    override var addDropValues: Boolean = definedExternally
    /**
     *  When an item is dropped on this component, and DataBoundComponent.addDropValues is true and both
     *       the source and target widgets are databound, either to the same DataSource or
     *       to different DataSources that are related via a foreign key, this object
     *       provides the "drop values" that SmartClient will apply to the dropped object
     *       before updating it.
     * 
     *       If this property is not defined, SmartClient defaults to returning the selection
     *       criteria currently in place for this component. Thus, any databound items (for example,
     *       rows from other grids bound to the same DataSource) dropped on the grid will,
     *       by default, be subjected to an update that makes them conform to the grid's
     *       current filter criteria.
     *  @type {object}
     *  @default null
     */
    override var dropValues: dynamic = definedExternally
    /**
     *  Does this component represent singular or multiple "records" objects?
     *   Options are "multiple" or "single", or "either"
     *  @type {string}
     *  @default "multiple"
     */
    override var dataArity: String = definedExternally
    /**
     *  Indicates whether or not this component will load its data
     *   DataSource.progressiveLoading.
     *  @type {boolean}
     *  @default null
     */
    override var progressiveLoading: Boolean = definedExternally
    /**
     *  If this component is bound to a dataSource, this attribute may be specified to customize
     *   what fields from the dataSource may be edited by default. For example the SearchForm
     *   class has this attribute set to "canFilter" which allows search forms to edit
     *   dataSource fields marked as canEdit:false (but not those marked as
     *   canFilter:false).
     * 
     *   Note that if canEdit is explicitly specified on a field in
     *   the DataBoundComponent.fields array, that property will be respected in preference to
     *   the canEditAttribute value. (See FormItem.canEdit, ListGridField.canEdit).
     *   Also note that individual dataBoundComponents may have additional logic around whether a field
     *   can be edited - for example ListGrid.canEditCell may be overridden.
     *  @type {Identifier}
     *  @default "canEdit"
     */
    override var canEditFieldAttribute: String = definedExternally
    /**
     *  The useFlatFields flag causes all simple type fields anywhere in a nested
     *   set of DataSources to be exposed as a flat list for form binding.
     * 
     *   useFlatFields is typically used with imported metadata, such as
     *   XMLTools.loadXMLSchema from a
     *   XMLTools.loadWSDL, as a means of eliminating levels of XML
     *   nesting that aren't meaningful in a user interface, without the cumbersome and fragile
     *   process of mapping form fields to XML structures.
     * 
     *   For example, having called WebService.getInputDS to retrieve the input message
     *   schema for a web service operation whose input message looks like this:
     * 
     *   &lt;FindServices&gt;
     *     &lt;searchFor&gt;search text&lt;/searchFor&gt;
     *     &lt;Options&gt;
     *       &lt;caseSensitive&gt;false&lt;/caseSensitive&gt;
     *     &lt;/Options&gt;
     *     &lt;IncludeInSearch&gt;
     *       &lt;serviceName&gt;true&lt;/serviceName&gt;
     *       &lt;documentation&gt;true&lt;/documentation&gt;
     *       &lt;keywords&gt;true&lt;/keywords&gt;
     *     &lt;/IncludeInSearch&gt;
     *   &lt;/FindServices&gt;
     * 
     *   Setting useFlatFields on a DynamicForm that is bound to this input
     *   message schema would result in 5 FormItem reflecting the 5 simple type
     *   fields in the message.
     * 
     *   For this form, the result of DynamicForm.getValues might look
     *   like:
     * 
     *   {
     *    searchFor: "search text",
     *    caseSensitive: false,
     *    serviceName: true,
     *    documentation : true,
     *    keywords : true
     *   }
     *   When contacting a WebService, these values can be automatically
     *   mapped to the structure of the input message for a web service operation by setting
     *   WSRequest.useFlatFields (for use with WebService.callOperation) or by setting
     *   DSRequest.useFlatFields (for use with a DataSource that is
     *   wsdlBinding via
     *   OperationBinding.wsOperation).
     * 
     *   Using these two facilities in conjunction (component.useFlatFields and
     *   request.useFlatFields) allows gratuitous nesting to be consistently bypassed in both the user
     *   presentation and when providing the data for XML messages.
     * 
     *   You can also set OperationBinding.useFlatFields to automatically enable
     *   "flattened" XML serialization (request.useFlatFields) for all DataSource requests of a
     *   particular operationType.
     * 
     *   Note that useFlatFields is not generally recommended for use with structures
     *   where multiple simple type fields exist with the same name, however if used with such a
     *   structure, the first field to use a given name wins. "first" means the first field
     *   encountered in a depth first search. "wins" means only the first field will be present as a
     *   field when data binding.
     *  @type {boolean}
     *  @default null
     */
    override var useFlatFields: Boolean = definedExternally
    /**
     *  If this attribute is set to false, any attributes in the component's values object that do
     *   not map to a DataSourceField or FormItem will not
     *   be tracked when checking for changes. You should only set this flag to false if you know
     *   that your code does not store additional, non-field values in the component's data, or if
     *   you do store such values, but you don't care that they are not checked for changes.
     *   This flag is primarily provided to avoid performance issues in cases where developers are
     *   storing large numbers of extra attributes in component data; generally speaking, you should
     *   only consider setting it to false if you have a use case like this.
     * 
     *   Note, even with this flag set to false, these extra values will still be managed and stored
     *   by SmartClient; they just will not be checked when the component's values are inspected to
     *   see if they have changed. This may lead to methods like ListGrid.rowHasChanges
     *   returning false when you are expecting it to return true. In this case, either switch this
     *   flag back to true (or just do not set it false), or provide a field definition for the
     *   affected attribute(s).
     *  @type {boolean}
     *  @default true
     */
    override var canChangeNonFieldValues: Boolean = definedExternally
    /**
     *  If true, when this component is first drawn, automatically call this.fetchData().
     *   Criteria for this fetch may be picked up from DataBoundComponent.initialCriteria, and textMatchStyle may
     *   be specified via ListGrid.autoFetchTextMatchStyle.
     * 
     *   NOTE: if autoFetchData is set, calling
     *   ListGrid.fetchData before draw will cause two requests to be issued, one from the manual
     *   call to fetchData() and one from the autoFetchData setting. The second request will use
     *   only DataBoundComponent.initialCriteria and not any other criteria or settings from the first request.
     *   Generally, turn off autoFetchData if you are going to manually call ListGrid.fetchData at any time.
     *  @type {boolean}
     *  @default false
     */
    override var autoFetchData: Boolean = definedExternally
    /**
     *  Criteria to be used when DataBoundComponent.autoFetchData is set.
     * 
     *   This property supports dynamicCriteria - use Criterion.valuePath
     *   to refer to values in the Canvas.ruleScope.
     *  @type {Criteria}
     *  @default null
     */
    override var initialCriteria: dynamic = definedExternally
    /**
     *  Criteria that are never shown to or edited by the user and are cumulative with any criteria
     *   provided via DataBoundComponent.initialCriteria, method:DataBoundComponent.setCriteria
     *   etc.
     *  @type {Criteria}
     *  @default null
     */
    override var implicitCriteria: dynamic = definedExternally
    /**
     *  Adds an item to the header context menu allowing users to launch a dialog to define
     *   grid hilites using the HiliteEditor.
     * 
     *   User-added hilites can be persisted via DataBoundComponent.getHiliteState and
     *   DataBoundComponent.setHiliteState.
     *  @type {boolean}
     *  @default false
     */
    override var canEditHilites: Boolean = definedExternally
    /**
     *  Hilites to be applied to the data for this component. See hiliting.
     *  @type {Array<Partial<Hilite>>}
     *  @default null
     */
    override var hilites: Array<dynamic> = definedExternally
    /**
     *  Specifies a list of icons that can be used in DataBoundComponent.editHilites.
     * 
     *   hiliteIcons should be specified as an Array of SCImgURL.
     *   When present, the hilite editing interface shown when DataBoundComponent.editHilites is called
     *   will offer the user a drop down for picking one of these icons when defining either a
     *   simple or advanced hilite rule.
     * 
     *   If the user picks an icon, the created hiliting rule will have Hilite.icon set to
     *   the chosen icon. DataBoundComponent.hiliteIconPosition controls where the icon will
     *   appear for that field -- the default is that it appears in front of the normal cell content.
     *   This can also be overridden at the field level.
     *  @type {Array<Partial<string>>}
     *  @default "["[SKINIMG]/Dialog/notify.png", "[SKINIMG]/Dialog/warn.png", "[SKINIMG]/actions/approve.png"]"
     */
    override var hiliteIcons: Array<dynamic> = definedExternally
    /**
     *  When DataBoundComponent.hiliteIcons are present, where the hilite icon will be placed
     *   relative to the field value. See HiliteIconPosition. Can be overridden at the
     *   field level.
     *  @type {HiliteIconPosition}
     *  @default "before"
     */
    override var hiliteIconPosition: 
                                     /**
                                      *  icon will be placed before the normal cell contents
                                      *  icon will be placed after the normal cell contents
                                      *  icon will be shown instead of the normal cell contents
                                      */
                                     String /* before |  after |  replace */ = definedExternally
    /**
     *  Default width and height of DataBoundComponent.hiliteIcons for this component.
     *   Can be overridden at the component level via explicit
     *   DataBoundComponent.hiliteIconWidth and
     *   DataBoundComponent.hiliteIconHeight, or at the field level via
     *   ListGridField.hiliteIconSize,
     *   ListGridField.hiliteIconWidth and
     *   ListGridField.hiliteIconHeight
     *  @type {number}
     *  @default "12"
     */
    override var hiliteIconSize: Number = definedExternally
    /**
     *  Width for hilite icons for this component.
     *   Overrides DataBoundComponent.hiliteIconSize.
     *   Can be overridden at the field level.
     *  @type {number}
     *  @default null
     */
    override var hiliteIconWidth: Number = definedExternally
    /**
     *  Height for hilite icons for this listGrid.
     *   Overrides DataBoundComponent.hiliteIconSize.
     *   Can be overridden at the field level
     *  @type {number}
     *  @default null
     */
    override var hiliteIconHeight: Number = definedExternally
    /**
     *  How much padding should there be on the left of DataBoundComponent.hiliteIcons by default?
     *   Can be overridden at the field level
     *  @type {number}
     *  @default "2"
     */
    override var hiliteIconLeftPadding: Number = definedExternally
    /**
     *  How much padding should there be on the right of DataBoundComponent.hiliteIcons by default?
     *   Can be overridden at the field level
     *  @type {number}
     *  @default "2"
     */
    override var hiliteIconRightPadding: Number = definedExternally
    /**
     *  Marker that can be set on a record to flag that record as hilited. Should be set to a value
     *   that matches Hilite.id for a hilite defined on this component.
     *  @type {string}
     *  @default "_hilite"
     */
    override var hiliteProperty: String = definedExternally
    /**
     *  Initial hilite state for the grid.
     * 
     *   ListGrid.viewState can be used to initialize all view properties of the grid.
     *   When doing so, hiliteState is not needed because viewState
     *   includes it as well. If both are provided, hiliteState has priority for
     *   hilite state.
     * 
     * 
     *   To retrieve current state call DataBoundComponent.getHiliteState.
     * 
     *  @type {string}
     *  @default null
     */
    override var hiliteState: String = definedExternally
    /**
     *  The strategy to use when generating names for new fields in this component. The default
     *   strategy, "simple", combines the field-type with an index maintained by field-type and
     *   component instance. For example, "formulaField1".
     *  @type {FieldNamingStrategy}
     *  @default "simple"
     */
    override var fieldNamingStrategy: 
                                      /**
                                       *  generate names in the format fieldTypeX, where field type might be     "formulaField" and X is an index specific to the field-type and component instance
                                       *  generates a UUID for all generated field names
                                       */
                                      String /* simple |  uuid */ = definedExternally
    /**
     *  Text for a menu item allowing users to edit grid highlights.
     *  @type {string}
     *  @default "Edit Highlights..."
     */
    override var editHilitesText: String = definedExternally
    /**
     *  The title for the DataBoundComponent.editHilites dialog.
     *  @type {string}
     *  @default "Edit Highlights"
     */
    override var editHilitesDialogTitle: String = definedExternally
    /**
     *  The title for the DataBoundComponent.fieldEditorWindow used to edit calculated
     *   fields.
     * 
     *   This is a dynamic string - text within &#36;{...} are dynamic variables and will
     *   be evaluated as JS code whenever the message is displayed.
     * 
     *   Two dynamic variables are available - "builderType", either Formula or Summary, and
     *   "fieldTitle", which is the title of the calculated field being edited.
     *  @type {HTMLString}
     *  @default "${builderType} Editor [${fieldTitle}]"
     */
    override var fieldEditorWindowTitle: String = definedExternally
    /**
     *  The Window used to edit calculated fields for this component.
     *  @type {Window}
     *  @default null
     */
    override var fieldEditorWindow: Window = definedExternally
    /**
     *  This component's HiliteEditor instance used to allow the user to create, modify, or delete
     *   hilites.
     * 
     *   The following autoChildUsage apply:
     * 
     * 
     *  - DataBoundComponent.hiliteIcons for HiliteEditor.hiliteIcons
     * 
     *  @type {HiliteEditor}
     *  @default null
     */
    override var hiliteEditor: HiliteEditor = definedExternally
    /**
     *  Indicates what to do with data dragged into another DataBoundComponent. See
     *   DragDataAction type for details.
     *  @type {DragDataAction}
     *  @default "move"
     */
    override var dragDataAction: 
                                 /**
                                  *  Don't do anything, resulting in the same data being in both lists.
                                  *  Copy the data leaving the original in our list.
                                  *  Remove the data from this list so it can be moved into the other list.
                                  */
                                 String /* none |  copy |  move */ = definedExternally
    /**
     *  CSS Style to apply to the drag tracker when dragging occurs on this component.
     *  @type {CSSStyleName}
     *  @default "gridDragTracker"
     */
    override var dragTrackerStyle: String = definedExternally
    /**
     *  If the result of a formula evaluation is invalid (specifically, if isNaN(result)==true),
     *   badFormulaResultValue is displayed instead. The default value is ".".
     *  @type {string}
     *  @default "."
     */
    override var badFormulaResultValue: String = definedExternally
    /**
     *  If a summary format string contains an invalid field reference, replace the reference
     *   with the missingSummaryFieldValue. The default value is "-".
     *  @type {string}
     *  @default "-"
     */
    override var missingSummaryFieldValue: String = definedExternally
    /**
     *  Adds an item to the header context menu allowing users to launch a dialog to define a new
     *   field based on values present in other fields, using the FormulaBuilder.
     * 
     *   User-added formula fields can be persisted via ListGrid.getFieldState and
     *   ListGrid.setFieldState.
     *  @type {boolean}
     *  @default false
     */
    override var canAddFormulaFields: Boolean = definedExternally
    /**
     *  Text for a menu item allowing users to add a formula field
     *  @type {string}
     *  @default "Add formula column..."
     */
    override var addFormulaFieldText: String = definedExternally
    /**
     *  Text for a menu item allowing users to edit a formula field
     *  @type {string}
     *  @default "Edit formula..."
     */
    override var editFormulaFieldText: String = definedExternally
    /**
     *  Text for a menu item allowing users to remove a formula field
     *  @type {string}
     *  @default "Remove formula"
     */
    override var removeFormulaFieldText: String = definedExternally
    /**
     *  Adds an item to the header context menu allowing users to launch a dialog to define a new
     *   text field that can contain both user-defined text and the formatted values present in other
     *   fields, using the SummaryBuilder.
     * 
     *   User-added summary fields can be persisted via ListGrid.getFieldState and
     *   ListGrid.setFieldState.
     *  @type {boolean}
     *  @default false
     */
    override var canAddSummaryFields: Boolean = definedExternally
    /**
     *  Text for a menu item allowing users to add a formula field
     *  @type {string}
     *  @default "Add summary column..."
     */
    override var addSummaryFieldText: String = definedExternally
    /**
     *  Text for a menu item allowing users to edit the formatter for a field
     *  @type {string}
     *  @default "Edit summary format..."
     */
    override var editSummaryFieldText: String = definedExternally
    /**
     *  Text for a menu item allowing users to remove a summary field
     *  @type {string}
     *  @default "Remove summary format..."
     */
    override var removeSummaryFieldText: String = definedExternally
    /**
     *  When assembling a value for a DataBoundComponent.canAddSummaryFields, if a referenced
     *   field is hilited, should the hilite HTML be included in the summary field value?
     * 
     *   To control hilites showing in group summaries, see ListGrid.showHilitesInGroupSummary.
     *  @type {boolean}
     *  @default true
     */
    override var includeHilitesInSummaryFields: Boolean = definedExternally
    /**
     *  Best field to use for a user-visible title for an individual record from this
     *   component.
     * 
     *   This attribute has the same function as DataSource.iconField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var titleField: String = definedExternally
    /**
     *  Designates a field of FieldType:"image" as the field to use when rendering a
     *   record as an image, for example, in a TileGrid.
     * 
     *   This attribute has the same function as DataSource.iconField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var iconField: String = definedExternally
    /**
     *  Name of the field that has the second most pertinent piece of textual information in the
     *   record, for use when a DataBoundComponent needs to show a short summary of a record.
     * 
     *   This attribute has the same function as DataSource.infoField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var infoField: String = definedExternally
    /**
     *  Name of the field that has the most pertinent numeric, date, or enum value, for use when a
     *   DataBoundComponent needs to show a short summary of a record.
     * 
     *   This attribute has the same function as DataSource.dataField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var dataField: String = definedExternally
    /**
     *  Name of the field that has a long description of the record, or has the primary text data
     *   value for a record that represents an email message, SMS, log or similar.
     * 
     *   This attribute has the same function as DataSource.descriptionField but can be
     *   set for a component with no dataSource, or can be used to override the dataSource setting.
     *  @type {string}
     *  @default null
     */
    override var descriptionField: String = definedExternally
    /**
     *  The message to display to the user if an export of a DataBoundComponent's data is attempted
     *   while the DataBoundComponent's data is null or an empty list.
     *  @type {string}
     *  @default "You are attempting to export an empty dataset"
     */
    override var emptyExportMessage: String = definedExternally
    /**
     *  Properties to apply to the MultiSortDialog which gets automatically generated
     *   when DataBoundComponent.askForSort is called.
     * 
     *   See also ListGrid.showHeaderSpanTitlesInSortEditor and ListGrid.sortEditorSpanTitleSeparator
     *  @type {MultiSortDialog}
     *  @default null
     */
    override var multiSortDialogProperties: MultiSortDialog = definedExternally
    /**
     *  Class level defaults to apply to the MultiSortDialog which gets automatically
     *   generated when DataBoundComponent.askForSort is called.
     * 
     *   See also ListGrid.showHeaderSpanTitlesInSortEditor and ListGrid.sortEditorSpanTitleSeparator
     *  @type {MultiSortDialog}
     *  @default null
     */
    override var multiSortDialogDefaults: MultiSortDialog = definedExternally
    /**
     *  For databound components that support editing, the error message for a failed validator
     *   that does not specify its own errorMessage.
     *  @type {HTMLString}
     *  @default "Invalid value"
     */
    override var unknownErrorMessage: String = definedExternally
    /**
     *  A message to display to the user if server-side validation fails with an error but the
     *   server did not provide an error message
     *  @type {string}
     *  @default "Error during validation; no error details were provided"
     */
    override var noErrorDetailsMessage: String = definedExternally
    /**
     *   Change the URL this component loads content from. Triggers a fetch for content from the new
     *   URL.
     * 
     *   Can also be called with no arguments to reload content from the existing HTMLFlow.contentsURL.
     * 
     *   This feature relies on the XMLHttpRequest object which can be disabled by end-users in some
     *   supported browsers. See platformDependencies for more information.
     * 
     * 
     *  @param {URL=} URL to retrieve contents from
     *  @param {object=} Parameters to send to the contentsURL. Merged with              component.contentsURLParams if both are set.
     */
    open fun setContentsURL(url: String?, params: dynamic?): Unit = definedExternally
    /**
     *   Returns true if this htmlFlow is currently loading content from the server.
     *   Note: Does not apply to htmlFlows with HTMLFlow.contentsType set to
     *   "page"
     * 
     * 
     */
    open fun loadingContent(): Boolean = definedExternally
    /**
     *   Changes the contents of a widget to newContents, an HTML string.
     * 
     * 
     *  @param {HTMLString=} an HTML string to be set as the contents of this widget
     */
    override fun setContents(newContents: String?): Unit = definedExternally
    /**
     *   Based on the relationship between the DataSource this component is bound to and the
     *   DataSource specified as the "schema" argument, call fetchData() to retrieve records in this
     *   data set that are related to the passed-in record.
     * 
     *   Relationships between DataSources are declared via DataSourceField.foreignKey.
     * 
     *   For example, given two related DataSources "orders" and "orderItems", where we want to fetch
     *   the "orderItems" that belong to a given "order". "orderItems" should declare a field that
     *   is a DataSourceField.foreignKey to the "orders" table (for example, it
     *   might be named "orderId" with foreignKey="orders.id"). Then, to load the records related to
     *   a given "order", call fetchRelatedData() on the component bound to "orderItems", pass the
     *   "orders" DataSource as the "schema" and pass a record from the "orders" DataSource as the
     *   "record" argument.
     * 
     *   Note: When you expect a large number of records to be returned it is not recommended to
     *   display these in the DetailViewer as it doesn't have the same level of support for large
     *   datasets as the ListGrid.
     * 
     * 
     *  @param {ListGridRecord} DataSource record
     *  @param {Canvas | DataSource | GlobalId} schema of the DataSource record, or              DataBoundComponent already bound to that schema
     *  @param {DSCallback=} callback to invoke on completion
     *  @param {DSRequest=} additional properties to set on the DSRequest                      that will be issued
     */
    open fun fetchRelatedData(record: ListGridRecord, schema: dynamic, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?), requestProperties: DSRequest?): Unit = definedExternally
    /**
     * 
     *   This method is called when a transport error occurs. Typically, this is the result of the
     *   server returning an HTTP error code such as 404 - document not found. You can inspect the
     *   RPCResponse object for the reasons for the error and take appropriate action. Typical
     *   properties to look at are rpcResponse.status, and rpcResponse.httpResponseCode.
     * 
     *   This method is called from the response processing pipeline. If you want to provide your
     *   own HTML response that should be rendered into this component as the result of the error,
     *   you can do so by setting rpcResponse.data to your HTML string. Returning false from this
     *   method suppresses any further response handling. The default implementation of this method
     *   causes an error message to be logged to the Developer Console and sets the HTML to the error
     *   string.
     * 
     * 
     *  @param {RPCRequest} The RPCRequest that was made to the server
     *  @param {RPCResponse} The RPCResponse that was received
     */
    open fun handleError(rpcRequest: RPCRequest, rpcResponse: RPCResponse): Boolean = definedExternally
    /**
     *   Override to modify the loaded HTML before it is rendered.
     * 
     * 
     *  @param {HTMLString} the html as loaded from the server return (HTML) html to be rendered
     */
    open fun transformHTML(html: String): Unit = definedExternally
    /**
     *   StringMethod fired when content is completely loaded in this htmlFlow. Has no default
     *   implementation. May be observed or overridden as a notification type method to fire custom
     *   logic when loading completes.
     * 
     *   Notes:
     * 
     *  - A call to Canvas.setContents
     *   will cause this notification to be fired when
     *   the contents have been set. If HTMLFlow.evalScriptBlocks is true, and the HTML passed
     *   into setContents() contains any &lt;script src=... &gt;
     *   tags, this callback will be fired asynchronously once the scripts have been loaded
     *   from the server and executed, as well as having the widget content updated
     * 
     *  - When using HTMLFlow.contentsURL, this does not apply to htmlFlows with
     *   HTMLFlow.contentsType set to "page"
     * 
     * 
     */
    open fun contentLoaded(): Unit = definedExternally
    /**
     *   This method is invoked on the source component whenever a drag operation or
     *   DataBoundComponent.transferSelectedData completes. This method is called when the entire chain of
     *   operations - including, for databound components, server-side updates and subsequent
     *   integration of the changes into the client-side cache - has completed.
     *   There is no default implementation of this method; you are intended to override it if you
     *   are interested in being notified when drag operations complete.
     * 
     * 
     */
    override fun dragComplete(): Unit = definedExternally
    /**
     *   This method is invoked whenever a drop operation or DataBoundComponent.transferSelectedData
     *   targeting this component completes. A drop is considered to be complete when all the client-
     *   side transfer operations have finished. This includes any server turnarounds SmartClient
     *   needs to make to check for duplicate records in the target component; it specifically does
     *   not include any add or update operations sent to the server for databound components. If
     *   you want to be notified when the entire drag operation - including server updates and cache
     *   synchronization - has completed, override DataBoundComponent.dragComplete
     *   on the source component.
     *   There is no default implementation of this method; you are intended to override it if you
     *   are interested in being notified when drop operations complete.
     * 
     * 
     *  @param {Array<Partial<Record>>} The list of records actually transferred to          this component (note that this is not necessarily the same thing as the           list of records dragged out of the source component because it doesn't           include records that were excluded because of collisions with existing           records)
     */
    override fun dropComplete(transferredRecords: Array<dynamic>): Unit = definedExternally
    /**
     *   For a component with a specified DataSource, find the associated dataSource field object
     *   from a specified DataPath.
     * 
     *  @param {DataPath} dataPath for which the field definition should be returned.
     */
    override fun getDataPathField(dataPath: String): Unit = definedExternally
    /**
     *   Can the field be edited? This base method always returns false, but it's
     *   overridden by subclasses such as DynamicForm and ListGrid.
     * 
     * 
     *  @param {object | number | string} field object or identifier
     */
    override fun fieldIsEditable(field: dynamic): Boolean = definedExternally
    /**
     *   Return a field by a field index or field name.
     * 
     * 
     *  @param {FieldName | number} field index or field.name
     */
    override fun getField(fieldID: dynamic): dynamic = definedExternally
    /**
     *   Find the index of a currently visible field.
     * 
     * 
     *  @param {FieldName | string} field name or field
     */
    override fun getFieldNum(fieldName: String): Number = definedExternally
    /**
     *   This API is equivalent to List.find but searches for a matching record among already-loaded data only.
     *   Use ListGrid.fetchData to load data from the server.
     * 
     *  @param {AdvancedCriteria} AdvancedCriteria to use with
     */
    override fun find(advancedCriteria: AdvancedCriteria): dynamic = definedExternally
    /**
     *   This API is equivalent to List.findAll but searches for a matching record among already-loaded data only.
     *   Use ListGrid.fetchData to load data from the server.
     * 
     *  @param {AdvancedCriteria} AdvancedCriteria to use with
     */
    override fun findAll(advancedCriteria: AdvancedCriteria): Array<dynamic> = definedExternally
    /**
     *   This API is equivalent to List.findIndex but searches for a matching record among already-loaded data only.
     *   Use ListGrid.fetchData to load data from the server.
     * 
     *  @param {AdvancedCriteria} AdvancedCriteria to use with
     */
    override fun findIndex(advancedCriteria: AdvancedCriteria): Number = definedExternally
    /**
     *   This API is equivalent to List.findNextIndex but searches for a matching record among already-loaded data only.
     *   Use ListGrid.fetchData to load data from the server.
     * 
     *  @param {Integer} first index to consider
     *  @param {AdvancedCriteria} AdvancedCriteria to use with
     *  @param {Integer=} last index to consider
     */
    override fun findNextIndex(startIndex: Number, advancedCriteria: AdvancedCriteria, endIndex: Number?): Number = definedExternally
    /**
     *   Bind to a new DataSource.
     * 
     *   Like passing the "dataSource" property on creation, binding to a DataSource means that the
     *   component will use the DataSource to provide default data for its fields.
     * 
     *   When binding to a new DataSource, if the component has any existing "fields" or has a dataset,
     *   these will be discarded by default, since it is assumed the new DataSource may represent a
     *   completely unrelated set of objects. If the old "fields" are still relevant, pass them to
     *   setDataSource().
     * 
     * 
     *  @param {GlobalId | DataSource} DataSource to bind to
     *  @param {Array<Partial<DataSourceField>>=} optional array of fields to use
     */
    override fun setDataSource(dataSource: dynamic, fields: Array<dynamic>?): Unit = definedExternally
    /**
     *   Sends the current filter criteria and sort direction to the server, then exports data in the
     *   requested DSRequest.exportAs.
     * 
     *   A variety of DSRequest settings, such as
     *   DSRequest.exportAs and DSRequest.exportFilename, affect the
     *   exporting process: see DSRequest.exportResults for further detail.
     * 
     *   Note that data exported via this method does not include any client-side formatting and
     *   relies on both the SmartClient server and server-side DataSources. To export client-data
     *   with formatters applied,
     *   see ListGrid.exportClientData, which still requires the
     *   SmartClient server but does not rely on server-side DataSource definitions (.ds.xml files).
     * 
     *   For more information on exporting data, see DataSource.exportData.
     * 
     * 
     *  @param {DSRequest=} additional properties to set on the DSRequest                      that will be issued
     *  @param {DSCallback=} callback to invoke on completion. Note that this parameter                 only applies where DSRequest.exportToClient is                  explicitly set to false, because file downloads do not                  provide ordinary SmartClient callbacks
     */
    override fun exportData(requestProperties: DSRequest?, callback: ((dsResponse: DSResponse, data: dynamic, dsRequest: DSRequest) -> Unit?)): Unit = definedExternally
    /**
     *   Returns an array of Alignment for this grid
     * 
     */
    override fun getFieldAlignments(): Array<dynamic> = definedExternally
    /**
     *   Compares the specified criteria with the current criteria applied to this component's
     *   data object and determines whether the new criteria could be satisfied from the currently
     *   cached set of data, or if a new filter/fetch operation will be required.
     * 
     *   This is equivalent to calling this.data.willFetchData(...).
     *   Always returns true if this component is not showing a set of data from the dataSource.
     * 
     *   Note that to predict correctly the decision that will be made by filter/fetch, you'll need to
     *   pass the same TextMatchStyle that will be used by the future filter/fetch. Fetching
     *   manually (e.g. ListGrid.fetchData) will by default use "exact" while filtering
     *   (e.g. ListGrid.filterData) will by default use "substring". If the component
     *   is configured for autofetch (i.e. ListGrid.autoFetchData: true), that will
     *   use ListGrid.autoFetchTextMatchStyle, which defaults to "substring". If nothing/null
     *   is passed for the style, this method assumes you want the style from the last filter/fetch.
     * 
     *   To determine what TextMatchStyle is being used, check the RPC Tab of the
     *   debugging and check the relevant DSRequest.
     * 
     * 
     *  @param {Criteria} new criteria to test.
     *  @param {TextMatchStyle=} New text match style. If not passed assumes    textMatchStyle will not be modified.
     */
    override fun willFetchData(newCriteria: dynamic, textMatchStyle: 
                                                                     /**
                                                                      *  case-insensitive exact match ("foo" matches "foo" and "FoO", but not "FooBar")
                                                                      *  case-sensitive exact match ("foo" matches only "foo")
                                                                      *  case-insenstive substring match ("foo" matches "foobar" and "BarFoo")
                                                                      *  case-insensitive prefix match ("foo" matches "FooBar" but not "BarFoo")
                                                                      *   textMatchStyle behavior is consistent across the client and all three of the built-in
                                                                      *   server DataSource implementations - SQL, Hibernate and JPA - to the maximum extent that is
                                                                      *   practical. Known inconsistencies, some of which can be tweaked with configuration settings,
                                                                      *   are described below
                                                                      * 
                                                                      *  - textMatchStyle can be disabled for any individual field with the
                                                                      *   DataSourceField.ignoreTextMatchStyle declaration. This behavior is consistent
                                                                      *   across client and server implementations, with the proviso that case-sensitive behavior
                                                                      *   is inherently inconsistent in the server-side implementations (see below for a more
                                                                      *   detailed discussion of this)
                                                                      * 
                                                                      *  - textMatchStyle is forced to "exactCase" for DataSourceField.primaryKey
                                                                      *   fields on update and remove operations, unless
                                                                      *   OperationBinding.allowMultiUpdate is in force. This means that a normal update
                                                                      *   or remove operation - which is constrained by a unique primaryKey value or combination, to
                                                                      *   affect only a single data row - will use an equality match on all primaryKey fields. This
                                                                      *   is desirable because it makes index usage more likely. Note that this means the key values
                                                                      *   "foo" and "FOO" are distinct, which is a change from previous behavior. For most databases,
                                                                      *   this change will have no effect because most databases do not by default allow primaryKey
                                                                      *   values that only differ in case anyway - if a table has a row with a PK of "foo" and you
                                                                      *   try to insert a row with a PK of "FOO", most databases will fail with a constraint violation.
                                                                      *   However, if you are using a database hat allows key values that differ only in case, and you
                                                                      *   need to support this for some reason, you can switch the framework back to the previous
                                                                      *   behavior by setting property allow.case.sensitive.pks to true in
                                                                      *   your server.properties file. Note, we do not recommend this; in fact, we do
                                                                      *   not recommend the use of text primaryKey fields at all. Where you have control ,we would
                                                                      *   always recommend the use of automatically incrementing numeric sequence keys.
                                                                      * 
                                                                      *  - textMatchStyle does not apply to boolean or temporal (date, datetime, time)
                                                                      *   DataSourceField.type. Such fields are always checked for equality. If
                                                                      *   you have a need for more complex matching, such as date-range checking, use AdvancedCriteria
                                                                      * 
                                                                      *  - Critiera values for temporal fields must be real dates (Javascript Date
                                                                      *   objects on the client, instances of java.util.Date on the server). Attempting
                                                                      *   to match against a string or any other type of value will result in an "always fails"
                                                                      *   clause being generated. This behavior is how the client code has always worked, but is a
                                                                      *   change for the server-side DataSources, in the interests of consistency. The previous
                                                                      *   behavior was:
                                                                      * 
                                                                      *  - SQLDataSource used to attempt to match the date column to the criteria value provided;
                                                                      *    if that value was an appropriately-formatted string, that attempt might have
                                                                      *    worked, but it would be database-specific. If you have an application that depends on
                                                                      *    this old behavior, you can switch it back on by adding the following to your
                                                                      *    server.properties file:
                                                                      *    sql.temporal.fields.require.date.criteria: false
                                                                      * 
                                                                      *  - HibernateDataSource and JPADataSource used to skip such clauses altogether, which
                                                                      *    results in the opposite behavior (there is an implied "always succeeds" clause, because
                                                                      *    the clause is not present in the query at all). If you have an application that depends on
                                                                      *    this old behavior, you can switch it back on by adding the following to your
                                                                      *    server.properties file:
                                                                      *    jpa.temporal.fields.require.date.criteria: false or
                                                                      *    hibernate.temporal.fields.require.date.criteria: false, as appropriate
                                                                      * 
                                                                      * 
                                                                      *  - textMatchStyle does not apply to fields used in the joins generated to satisfy
                                                                      *   DataSourceField.includeFrom declarations or entity relations in
                                                                      *   Hibernate or JPA. Again, such comparisons are always for equality
                                                                      * 
                                                                      *  - textMatchStyle is applied to numeric fields only if the supplied criteria value
                                                                      *   is a string. So for a numeric field "myNumber", we will match 10, 100, 110 and 1000 if a
                                                                      *   criteria value of "10" (the quoted string) is supplied, but we will only match 10 if a
                                                                      *   criteria value of 10 (the actual number) is supplied
                                                                      * 
                                                                      *  - This is a change in behavior for the server-side DataSource implementations, in the
                                                                      *    interests of consistency with the client behavior. Previously, all three of the built-in
                                                                      *    DataSource implementations applied textMatchStyle to numeric fields regardless of the
                                                                      *    criteria value's type. If you have an application that depends on this old behavior,
                                                                      *    you can switch it back on by adding the following to your server.properties
                                                                      *    file: sql.substring.numeric.criteria: true or
                                                                      *    hibernate.substring.numeric.criteria: true or
                                                                      *    jpa.substring.numeric.criteria: true, as appropriate
                                                                      * 
                                                                      * 
                                                                      *  - "exactCase" matching cannot be made consistent across all database providers because
                                                                      *   each database has its own idea of whether case-sensitive matching should be the default,
                                                                      *   and how to switch it on and off (if that is even possible)
                                                                      * 
                                                                      *  - Microsoft SQL Server must have case-sensitive matching enabled by setting a
                                                                      *    case-sensitive collation when the database is created (there are more fine-grained
                                                                      *    options, but we do not recommend them because of the scope for further inconsistency,
                                                                      *    where "exactCase" works correctly on table A but not on table B). See
                                                                      *    MSDN for details
                                                                      * 
                                                                      *  - HSQLDB has case sensitivity set with the SET IGNORECASE directive -
                                                                      *    see here
                                                                      * 
                                                                      *  - MySQL is case-insensitive, but since it provides an easy way to do per-query,
                                                                      *    case-sensitive matching in SQL, we work around it for that database, but only in
                                                                      *    SQL DataSources
                                                                      * 
                                                                      * 
                                                                      *  - If you are using Hibernate or JPA, whether "exactCase" works as expected depends
                                                                      *   entirely on the underlying database. Unlike the SQL DataSource, where we have fine-grained
                                                                      *   control of the SQL that the database executes, we are constrained by what the ORM will
                                                                      *   allow. This prevents us from compensating for database quirks, like we do with MySQL's
                                                                      *   case-insensitivity in the SQL DataSource
                                                                      * 
                                                                      */
                                                                     String /* exact |  exactCase |  substring |  startsWith */?): Boolean = definedExternally
    /**
     *   Attempt to find the record in the resultSet that has a primary key value that matches the
     *   passed in parameter value. Only the locally cached data will be searched.
     *   Checks only loaded rows and will not trigger a fetch. Returns null if there is no match,
     *   data is not loaded, or there is no ResultSet.dataSource.
     * 
     *   Note, if you pass a simple value to this method, it will be matched against the first
     *   primaryKey field. For DataSources with a composite primary key (multiple primaryKey fields),
     *   pass
     *   a criteria object containing just your primaryKeys, like this:
     *   { firstPkField: "value", secondPkField: 25 }.
     * 
     * 
     * 
     *  @param {object} primary key value to search for
     */
    override fun findByKey(keyValue: dynamic): Record = definedExternally
    /**
     * 
     *   Select/deselect a Record passed in explicitly, or by index.
     * 
     * 
     *  @param {Record | number} record (or row number) to select
     *  @param {boolean=} new selection state (if null, defaults to true)
     */
    override fun selectRecord(record: dynamic, newState: Boolean?): Unit = definedExternally
    /**
     *   Select a single Record passed in explicitly, or by index, and deselect everything else.
     *   When programmatic selection of records is a requirement and
     *   ListGrid.selectionType is "single", use this method rather than
     *   DataBoundComponent.selectRecord to
     *   enforce mutually-exclusive record-selection.
     * 
     * 
     *  @param {Record | number} record (or row number) to select
     */
    override fun selectSingleRecord(record: dynamic): Unit = definedExternally
    /**
     * 
     *   Deselect a Record passed in explicitly, or by index.
     * 
     *   Synonym for selectRecord(record, false)
     * 
     * 
     *  @param {Record | number} record (or row number) to deselect
     */
    override fun deselectRecord(record: dynamic): Unit = definedExternally
    /**
     * 
     *   Select/deselect a list of Records passed in explicitly, or by index.
     * 
     *   Note that developers may wish to use DataBoundComponent.selectRange to select a single
     *   contiguous range.
     * 
     * 
     *  @param {Array<Partial<Record>> | number} records (or row numbers) to select
     *  @param {boolean=} new selection state (if null, defaults to true)
     */
    override fun selectRecords(records: dynamic, newState: Boolean?): Unit = definedExternally
    /**
     * 
     *   Deselect a list of Records passed in explicitly, or by index.
     * 
     *   Synonym for selectRecords(records, false)
     * 
     *   Note that developers may wish to use DataBoundComponent.deselectRange to select a single
     *   contiguous range.
     * 
     * 
     *  @param {Array<Partial<Record>> | number} records (or row numbers) to deselect
     */
    override fun deselectRecords(records: dynamic): Unit = definedExternally
    /**
     *   Select all records
     * 
     * 
     */
    override fun selectAllRecords(): Unit = definedExternally
    /**
     * 
     *   Deselect all records
     * 
     * 
     */
    override fun deselectAllRecords(): Unit = definedExternally
    /**
     *   Select a contiguous range of records by index
     * 
     *  @param {Integer} start of selection range
     *  @param {Integer} end of selection range (non-inclusive)
     *  @param {boolean=} new selection state (if null, defaults to true)
     */
    override fun selectRange(startRow: Number, endRow: Number, newState: Boolean?): Unit = definedExternally
    /**
     *   Deselect a contiguous range of records by index.
     * 
     *   This is a synonym for selectRange(startRow, endRow, false);
     * 
     *  @param {Integer} start of selection range
     *  @param {Integer} end of selection range (non-inclusive)
     */
    override fun deselectRange(startRow: Number, endRow: Number): Unit = definedExternally
    /**
     *   Whether at least one item is selected
     * 
     */
    override fun anySelected(): Boolean = definedExternally
    /**
     *   Returns the number of selected records.
     * 
     * 
     */
    override fun getSelectionLength(): Number = definedExternally
    /**
     *   Return the set of hilite-objects currently applied to this DataBoundComponent. These
     *   can be serialized for storage and then restored to a component later via
     *   DataBoundComponent.setHilites.
     * 
     * 
     */
    override fun getHilites(): Array<dynamic> = definedExternally
    /**
     *   Accepts an array of hilite objects and applies them to this DataBoundComponent. See also
     *   DataBoundComponent.getHilites for a method of retrieving the hilite
     *   array for storage, including hilites manually added by the user.
     * 
     * 
     *  @param {Array<Partial<Hilite>>} Array of hilite objects
     */
    override fun setHilites(hilites: Array<dynamic>): Unit = definedExternally
    /**
     *   Get the current hilites encoded as a String, for saving.
     * 
     * 
     */
    override fun getHiliteState(): String = definedExternally
    /**
     *   Set the current hilites based on a hiliteState String previously returned from
     *   DataBoundComponent.getHiliteState.
     * 
     *  @param {string} hilites state encoded as a String
     */
    override fun setHiliteState(hiliteState: String): Unit = definedExternally
    /**
     *   Enable / disable a DataBoundComponent.hilites
     * 
     * 
     *  @param {string} ID of hilite to enable
     *  @param {boolean=} new enabled state to apply - if null, defaults to true
     */
    override fun enableHilite(hiliteID: String, enable: Boolean?): Unit = definedExternally
    /**
     *   Disable a hilite
     * 
     * 
     *  @param {string} ID of hilite to disable
     */
    override fun disableHilite(hiliteID: String): Unit = definedExternally
    /**
     *   Enable all hilites.
     * 
     * 
     *  @param {boolean=} new enabled state to apply - if null, defaults to true
     */
    override fun enableHiliting(enable: Boolean?): Unit = definedExternally
    /**
     *   Disable all hilites.
     * 
     * 
     */
    override fun disableHiliting(): Unit = definedExternally
    /**
     *   Shows a HiliteEditor interface allowing end-users to edit
     *   the data-hilites currently in use by this DataBoundComponent.
     * 
     * 
     */
    override fun editHilites(): Unit = definedExternally
    /**
     * 
     *   Transfer a list of Records from another component (does not have to be a databound
     *   component) into this component. This method is only applicable to list-type components,
     *   such as ListGrid, TreeGrid or TileGrid
     * 
     *   This method implements the automatic drag-copy and drag-move behaviors of components like
     *   ListGrid, and calling it is equivalent to completing a drag and drop of the
     *   dropRecords.
     * 
     *   Note that this method is asynchronous - it may need to perform server turnarounds to prevent
     *   duplicates in the target component's data. If you wish to be notified when the transfer
     *   process has completed, you can either pass the optional callback to this method or implement
     *   the DataBoundComponent.dropComplete method on this component.
     * 
     *   See also DataBoundComponent.transferSelectedData.
     * 
     * 
     *  @param {Array<Partial<Record>>} Records to transfer to this component
     *  @param {Record} The target record (eg, of a drop interaction), for context
     *  @param {Integer} Insert point in this component's data for the transferred records
     *  @param {Canvas} The databound or non-databound component from which the records              are to be transferred.
     *  @param {Callback=} optional callback to be fired when the transfer process has completed
     */
    override fun transferRecords(dropRecords: Array<dynamic>, targetRecord: Record, index: Number, sourceWidget: Canvas, callback: dynamic?): Unit = definedExternally
    /**
     *   Returns the "drop values" to apply to a record dropped on this component prior to update. Only
     *   applicable to databound components - see DataBoundComponent.dropValues for more details. If multiple records
     *   are being dropped, this method is called for each of them in turn.
     * 
     *   The default implementation of this method returns the following:
     * 
     * 
     *  - Nothing, if DataBoundComponent.addDropValues is false
     * 
     *  - dropValues, if that property is set. If the component's criteria object is applicable (as explained
     *   in the next item), it is merged into dropValues, with properties in dropValues taking precedence.
     * 
     *  - The component's criteria object, if the most recent textMatchStyle for the component was "exact"
     *     and it is simple criteria (ie, not an AdvancedCriteria object)
     * 
     *  - Otherwise nothing
     * 
     * 
     *   You can override this method if you need more complex setting of drop values than can be
     *   provided by simply supplying a dropValues object.
     * 
     * 
     *  @param {Record} record being dropped
     *  @param {DataSource} dataSource the record being dropped is bound to
     *  @param {Record} record being dropped on
     *  @param {Integer} index of record being dropped on
     *  @param {Canvas} widget where dragging began
     */
    override fun getDropValues(record: Record, sourceDS: DataSource, targetRecord: Record, index: Number, sourceWidget: Canvas): dynamic = definedExternally
    /**
     * 
     *   During a drag-and-drop interaction, this method is called to transfer a set of records that
     *   were dropped onto some other component. This method is called after the set of records has
     *   been copied to the other component. Whether or not this component's data is modified is
     *   determined by the value of DataBoundComponent.dragDataAction.
     * 
     *   With a dragDataAction of "move", a databound component will issue "remove"
     *   dsRequests against its DataSource to actually remove the data, via
     *   DataSource.removeData.
     * 
     * 
     */
    override fun transferDragData(): Array<dynamic> = definedExternally
    /**
     * 
     *   During a drag-and-drop interaction, this method returns the set of records being dragged out
     *   of the component. In the default implementation, this is the list of currently selected
     *   records.
     * 
     *   This method is consulted by ListGrid.willAcceptDrop.
     * 
     * 
     *  @param {DataBoundComponent} source component from which the records will be transferred
     */
    override fun getDragData(source: DataBoundComponent): Array<dynamic> = definedExternally
    /**
     *   Simulates a drag / drop type transfer of the selected records in some other component to this
     *   component, without requiring any user interaction. This method acts on the dropped records
     *   exactly as if they had been dropped in an actual drag / drop interaction, including any
     *   special databound behavior invoked by calling
     *   DataBoundComponent.getDropValues for each dropped record.
     * 
     *   To transfer all data in, for example, a ListGrid, call
     *   ListGrid.selectAllRecords first.
     * 
     *   Note that drag/drop type transfers of records between components are asynchronous operations:
     *   SmartClient may need to perform server turnarounds to establish whether dropped records
     *   already exist in the target component. Therefore, it is possible to issue a call to
     *   transferSelectedData() and/or the drop() method of a databound
     *   component whilst a transfer is still active. When this happens, SmartClient adds the
     *   second and subsequent transfer requests to a queue and runs them one after the other. If
     *   you want to be notified when a transfer process has actually completed, either provide a
     *   callback to this method or implement DataBoundComponent.dropComplete.
     * 
     *   See the dragging documentation for an overview of list grid drag/drop data
     *   transfer.
     * 
     * 
     *  @param {DataBoundComponent} source component from which the records will be transferred
     *  @param {Integer=} target index (drop position) of the rows within this grid.
     *  @param {Callback=} optional callback to be fired when the transfer process has            completed. The callback will be passed a single parameter "records",            the list of records actually transferred to this component.
     */
    override fun transferSelectedData(source: DataBoundComponent, index: Number?, callback: dynamic?): Unit = definedExternally
    /**
     *   Sets the custom tracker HTML to display next to the mouse when the user initiates a drag
     *   operation on this component. Default implementation will examine ListGrid.dragTrackerMode
     *   and set the custom drag tracker to display the appropriate HTML based on the selected record.
     * 
     *   To display custom drag tracker HTML, this method may be overridden - call
     *   EventHandler.setDragTracker to actually update the drag tracker HTML.
     * 
     */
    override fun setDragTracker(): Boolean = definedExternally
    /**
     *   Convenience method to display a FormulaBuilder to create a new Formula Field. This
     *   is equivalent to calling DataBoundComponent.editFormulaField with
     *   no parameter.
     * 
     * 
     */
    override fun addFormulaField(): Unit = definedExternally
    /**
     *   Method to display a FormulaBuilder to edit a formula Field. If the function is called
     *   without a parameter, a new field will be created when the formula is saved.
     * 
     * 
     *  @param {string} Field to edit or null to add a new formula field
     */
    override fun editFormulaField(field: String): Unit = definedExternally
    /**
     *   Get the computed value of a DataBoundComponent.canAddFormulaFields.
     * 
     *  @param {string} field that has a formula
     *  @param {Record} record to use to compute formula value
     */
    override fun getFormulaFieldValue(field: ListGridField, record: Record): dynamic = definedExternally
    /**
     *   Convenience method to display a SummaryBuilder to create a new Summary Field. This
     *   is equivalent to calling DataBoundComponent.editSummaryField with
     *   no parameter.
     * 
     * 
     */
    override fun addSummaryField(): Unit = definedExternally
    /**
     *   Method to display a SummaryBuilder to edit a Summary Field. If the function is called
     *   without a parameter, a new field will be created when the summary is saved.
     * 
     * 
     *  @param {string} Field to edit or null to add a new summary column
     */
    override fun editSummaryField(field: String): Unit = definedExternally
    /**
     *   Get the computed value of a DataBoundComponent.canAddSummaryFields.
     * 
     *  @param {string} field that has a summary format
     *  @param {Record} record to use to compute formula value
     */
    override fun getSummaryFieldValue(field: ListGridField, record: Record): String = definedExternally
    /**
     *   When assembling a value for a DataBoundComponent.canAddSummaryFields, if a referenced
     *   field is hilited, should the hilite HTML be included in the summary field value?
     * 
     *   Example use case: Consider a grid containing a numeric field, and a summary field
     *   which contains some string value, plus the contents of the numeric field.
     *   If a hilite is defined for the grid which turns the numeric field text red when
     *   the value is negative, this property will govern whether the number will also be
     *   rendered in red within the summary field cells. Any other text in the summary field
     *   cells would not be effected by this hilite.
     * 
     *   Default implementation returns DataBoundComponent.includeHilitesInSummaryFields.
     * 
     *   To control hilites showing in group summaries, see ListGrid.showHilitesInGroupSummary.
     * 
     * 
     *  @param {string} name of the summary field
     *  @param {string} name of the field referenced by this summary
     */
    override fun shouldIncludeHiliteInSummaryField(summaryFieldName: String, usedFieldName: String): Boolean = definedExternally
    /**
     *   Get the index of the provided record.
     * 
     *   Override in subclasses to provide more specific behavior, for instance, when data holds a
     *   large number of records
     * 
     * 
     *  @param {Record} the record whose index is to be retrieved
     */
    override fun getRecordIndex(record: Record): Number = definedExternally
    /**
     *   Get the value of the titleField for the passed record
     * 
     *   Override in subclasses
     * 
     * 
     *  @param {Record} the record whose index is to be retrieved
     */
    override fun getTitleFieldValue(record: Record): String = definedExternally
    /**
     *   Method to return the fieldName which represents the "title" for records in this
     *   Component.
     *   If this.titleField is explicitly specified it will always be used.
     *   Otherwise, default implementation will check DataSource.titleField for databound
     *   compounds.
     *   For non databound components returns the first defined field name of "title",
     *   "name", or "id" where the field is visible. If we don't find any
     *   field-names that match these titles, the first field in the component will be used instead.
     * 
     */
    override fun getTitleField(): String = definedExternally
    /**
     *   Return all CSS style declarations associated with the hilites of a record's field.
     * 
     *  @param {Record} \* @param {string} if set, returned CSS will be appended to this text
     *  @param {string} field object identifying whose CSS is to be returned
     */
    override fun getRecordHiliteCSSText(record: Record, cssText: String, field: String): String = definedExternally
    /**
     *   Return the SortSpecifiers representing the current sort configuration of this
     *   component.
     * 
     */
    override fun getSort(): Array<dynamic> = definedExternally
    /**
     *   Sort this component by a list of SortSpecifiers. If the component's data is not a
     *   ResultSet, only the first specifier is applied.
     * 
     * 
     *  @param {Array<Partial<SortSpecifier>>} List of SortSpecifier objects, one  per sort-field and direction
     */
    override fun setSort(sortSpecifiers: Array<dynamic>): Unit = definedExternally
    /**
     *   Show a dialog to configure the sorting of multiple fields on this component. Calls through
     *   to MultiSortDialog.askForSort, passing this component as the fieldSource and the
     *   current DataBoundComponent.getSort if there is one.
     * 
     *   The generated multiSortDialog can be customized via DataBoundComponent.multiSortDialogDefaults,
     *   DataBoundComponent.multiSortDialogProperties.
     * 
     * 
     */
    override fun askForSort(): Unit = definedExternally
    /**
     *   Returns true if the component's current data model is marked as offline. This does not
     *   necessarily mean that the component has no data; it may have data that was supplied from
     *   the Offline.
     * 
     */
    override fun isOffline(): Boolean = definedExternally
    /**
     *   Shows a FieldPicker interface allowing end-users to edit
     *   the fields currently shown by this DataBoundComponent.
     * 
     * 
     */
    override fun editFields(): Unit = definedExternally
    /**
     *   Notification method fired when a user-generated field is added to this component via
     *   DataBoundComponent.editFormulaField or DataBoundComponent.editSummaryField.
     * 
     *   Returning false from this method will prevent the field being added at all. Note that
     *   this also provides an opportunity to modify the generated field object - any changes
     *   made to the field parameter will show up when the field is displayed in the ListGrid.
     * 
     * 
     *  @param {ListGridField} User generated summary or formula field
     */
    override fun userAddedField(field: ListGridField): Boolean = definedExternally
    /**
     *   Called when the selection changes. Note that this method fires exactly once for any given
     *   change to the selection unlike the ListGrid.selectionChanged event.
     * 
     *   This event is fired once after selection/deselection has completed. The result is
     *   one event per mouse-down event. For a drag selection there will be two events fired:
     *   one when the first record is selected and one when the range is completed.
     * 
     *   This event is also fired when selection is updated by a direct call to one of the
     *   DataBoundComponent select/deselect methods. Calls on the Selection
     *   object do not trigger this event.
     * 
     * 
     *  @param {object} first selected record in the selection, if any, which may or may not be the first record in sort order if the DataBoundComponent is sorted. This parameter is typically used when only one record can be selected at a time.
     *  @param {Array<Partial<object>>} List of records that are now selected
     */
    override fun selectionUpdated(record: dynamic, recordList: Array<dynamic>): Unit = definedExternally
    companion object {
        /**
         *  Creates a new HTMLFlow
         * 
         *  @param typeCheckedProperties {Partial<HTMLFlow>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {HTMLFlow} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): HTMLFlow = definedExternally
        /**
         *   Returns whether there are any pending DSRequests initiated by this
         *   DataBoundComponent. May not include any requests sent by directly calling the
         *   DataSource APIs (rather than the DataBoundComponent APIs).
         * 
         * 
         */
        fun requestsArePending(): Boolean = definedExternally
    }
}