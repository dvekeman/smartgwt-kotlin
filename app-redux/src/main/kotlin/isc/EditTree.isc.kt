@file:JsQualifier("isc")
package isc

/**
 *  A TreeGrid that allows drag and drop creation and manipulation of a tree of
 *   objects described by DataSources.
 * 
 *   Nodes can be added via drag and drop from a Palette or may be programmatically
 *   added via EditContext.addNode. Nodes may be dragged within the tree to reparent
 *   them.
 * 
 *   Eligibility to be dropped on any given node is determined by inspecting the
 *   DataSource of the parent node. Drop is allowed only if the parent schema has
 *   a field which accepts the type of the dropped node.
 * 
 *   On successful drop, the newly created component will be added to the parent node under the
 *   detected field. Array fields, declared by setting
 *   dataSourceField.multiple:true, are supported.
 * 
 *   An EditTree is initialized by setting EditTree.rootComponent or
 *   EditTree.editContext. EditTree.data (the Tree instance) should never be directly
 *   set or looked at.
 * 
 *   EditTree automatically creates an EditContext and provides several APIs and
 *   settings that are passthroughs to the underlying EditContext for convenience.
 */
open external class EditTree : TreeGrid, EditContext {
    /**
     *  The number of pixels to offset a pasted node from the node being copied
     *  @type {Integer}
     *  @default "5"
     */
    override var editNodePasteOffset: Number = definedExternally
    /**
     *  The EditContext managed by this EditTree. If not set an instance
     *   will be automatically created.
     *  @type {EditContext}
     *  @default null
     */
    open var editContext: EditContext = definedExternally
    /**
     *  New nodes added to the editContext are automatically placed
     *   into edit mode if the new node's parent is in edit mode. To
     *   suppress this action set autoEditNewNodes to false.
     *  @type {boolean}
     *  @default null
     */
    override var autoEditNewNodes: Boolean = definedExternally
    /**
     *  Root of data to edit. Must contain the "type" property, with the name of a
     *   valid DataSource or nothing will be able to be dropped on this
     *   EditContext. A "liveObject" property representing the rootComponent is also
     *   suggested. Otherwise, a live object will be created from the palette node.
     * 
     *   Can be retrieved at any time. Use EditTree.getRootEditNode to retrieve the
     *   EditNode created from the rootComponent.
     *  @type {PaletteNode}
     *  @default null
     */
    override var rootComponent: PaletteNode = definedExternally
    /**
     *  Palette to use when an EditNode is being created directly by this EditContext,
     *   instead of being created due to a user interaction with a palette (eg dragging from
     *   a TreePalette, or clicking on MenuPalette).
     * 
     *   If no defaultPalette is provided, the EditContext uses an automatically created
     *   HiddenPalette.
     *  @type {Palette}
     *  @default null
     */
    override var defaultPalette: Palette = definedExternally
    /**
     *  Additional Palette to consult for metadata when
     *   deserializing EditNode. Note that the
     *   EditTree.defaultPalette is always consulted and need not be
     *   provided again here.
     *  @type {Array<Partial<Palette>>}
     *  @default null
     */
    override var extraPalettes: Array<dynamic> = definedExternally
    /**
     *  When enabled, changes to a EditNode.liveObject's position
     *   and size will be persisted to their EditNode by default.
     *   This applies to both programmatic calls and user interaction (drag reposition
     *   or drag resize).
     * 
     *   This feature can be disabled by either setting this property or
     *   EditProxy.persistCoordinates to false. This
     *   property affects all nodes within the EditContext whereas the latter
     *   property affects children of a single node.
     * 
     *   In some use-cases, like VisualBuilder, coordinates should not be
     *   persisted except when a component explicitly enables this feature.
     *   By setting this property to null no component will
     *   persist coordinates of children unless
     *   EditProxy.persistCoordinates is explicitly set to
     *   true.
     *  @type {boolean}
     *  @default true
     */
    override var persistCoordinates: Boolean = definedExternally
    /**
     *  Controls whether components can be dropped into other components which support child
     *   components.
     * 
     *   When enabled, during a drop interaction in which a PaletteNode or EditNode
     *   is the drop data, the componentSchema of the current
     *   candidate drop target is inspected to see whether that parent allows children of the
     *   type being dropped. If it does, the drop will result in a call to EditTree.addNode for
     *   a paletteNode or for an existing EditNode in the same tree.
     * 
     *   Specific components can disable nested drops by explicitly setting EditProxy.allowNestedDrops
     *   to false.
     * 
     *   This mode is enabled by default unless explicitly disabled by setting this property to
     *   false.
     *  @type {boolean}
     *  @default null
     */
    override var allowNestedDrops: Boolean = definedExternally
    /**
     *  Should the selection outline show a label for selected components? A component may
     *   also be highlighted with the selection outline and label to indicate the target of
     *   a drop. To suppress showing a label at any time set this property to false.
     * 
     *   To suppress labels during selection but still show them when targeted for a drop,
     *   see EditContext.showSelectedLabelOnSelect.
     * 
     *   NOTE: A selected component label is only supported when EditProxy.selectedAppearance
     *   is "outlineEdges".
     *  @type {boolean}
     *  @default null
     */
    override var showSelectedLabel: Boolean = definedExternally
    /**
     *  Set the CSS border to be applied to the selection outline of the selected components.
     *   This property is used when EditProxy.selectedAppearance is outlineMask
     *   or outlineEdges.
     * 
     *   This value is applied as a default to EditProxy.selectedBorder.
     *  @type {string}
     *  @default null
     */
    override var selectedBorder: String = definedExternally
    /**
     *  The background color for the selection outline label. The
     *   default is defined on SelectionOutline.
     * 
     *   This value is applied as a default to EditProxy.selectedLabelBackgroundColor.
     * 
     *   NOTE: A selected component label is only supported when EditProxy.selectedAppearance
     *   is "outlineEdges".
     *  @type {string}
     *  @default null
     */
    override var selectedLabelBackgroundColor: String = definedExternally
    /**
     *  Should a group selection outline covering the outermost bounding boxes of all selected
     *   components be shown in this container?
     * 
     *   Treated as true if not set and hoop selection is enabled (see
     *   EditProxy.canSelectChildren and
     *   EditContext.selectionType.
     *  @type {boolean}
     *  @default null
     */
    override var canGroupSelect: Boolean = definedExternally
    /**
     *  Should the group selection box shown when EditContext.canGroupSelect
     *   is true allow dragging the group as a whole?
     * 
     *   Treated as true if not set and EditContext.canGroupSelect
     *   is true.
     *  @type {boolean}
     *  @default null
     */
    override var canDragGroup: Boolean = definedExternally
    /**
     *  Should the group selection box shown when EditContext.canGroupSelect
     *   is true be hidden during drag?
     * 
     *   Treated as true if not explicitly set to false.
     *  @type {boolean}
     *  @default null
     */
    override var hideGroupBorderOnDrag: Boolean = definedExternally
    /**
     *  If set, auto-enables EditProxy.useCopyPasteShortcuts on the EditProxy for the
     *   EditTree.getRootEditNode. This works whether there is currently a root editNode
     *   or one is added later.
     *  @type {boolean}
     *  @default null
     */
    override var useCopyPasteShortcuts: Boolean = definedExternally
    /**
     *  The default parent EditNode to be used when a new
     *   EditNode is added to the EditContext without a specified parent. This
     *   commonly occurs when a paletteNode is double-clicked in a palette.
     * 
     *   If not specified, the root editNode (see EditContext.getRootEditNode) is used.
     * 
     *   Note: this property is automatically cleared if node is removed from the
     *   editTree such as on calls to EditContext.destroyAll or EditContext.removeNode.
     *  @type {EditNode}
     *  @default null
     */
    override var defaultParent: EditNode = definedExternally
    /**
     *  Properties to apply to all EditProxy.editMasks created for components
     *   in edit mode. This mask can be modified when the node is selected by
     *   EditContext.selectedBorder, EditContext.selectedTintColor and
     *   EditContext.selectedTintOpacity depending on the EditContext.selectedAppearance
     *   setting.
     *  @type {object}
     *  @default null
     */
    override var editMaskProperties: dynamic = definedExternally
    /**
     *  Defines selection behavior when in edit mode. Only two styles are supported:
     *   "single" and "multiple". Multiple enables hoop selection.
     *  @type {SelectionStyle}
     *  @default "multiple"
     */
    override var selectionType: 
                                /**
                                 *  don't select at all
                                 *  select only one item at a time
                                 *  select one or more items
                                 *  select one or more items as a toggle      so you don't need to hold down control keys to select
                                 *                   more than one object
                                 */
                                String /* none |  single |  multiple |  simple */ = definedExternally
    /**
     *  Should editNodes added to this EditContext be selectable? When true,
     *   each EditProxy.canSelectChildren property is enabled unless explicitly set to
     *   false. This allows an individual component to override this setting.
     *  @type {boolean}
     *  @default null
     */
    override var canSelectEditNodes: Boolean = definedExternally
    /**
     *  Appearance that is applied to selected component.
     * 
     *   This value is applied as a default to EditProxy.selectedAppearance.
     *  @type {SelectedAppearance}
     *  @default null
     */
    override var selectedAppearance: 
                                     /**
                                      *  editMask on top of the component is updated with EditProxy.selectedTintColor            and EditProxy.selectedTintOpacity
                                      *  editMask on top of the component is updated with EditProxy.selectedBorder
                                      *  MultiAutoChild is created on top of the component. This constructs a border around            the component using 4 separate outlineEdge components so that interactivity is not blocked.
                                      *  no change in appearance. Override EditProxy.showSelectedAppearance to create a custom appearance.
                                      */
                                     String /* tintMask |  outlineMask |  outlineEdges |  none */ = definedExternally
    /**
     *  Mask color applied to EditProxy.editMask of selected component when
     *   EditProxy.selectedAppearance is "tintMask".
     * 
     *   This value is applied as a default to EditProxy.selectedTintColor.
     *  @type {CSSColor}
     *  @default "#cccccc"
     */
    override var selectedTintColor: String = definedExternally
    /**
     *  Opacity applied to EditProxy.editMask of selected component when
     *   EditProxy.selectedAppearance is "tintMask".
     * 
     *   This value is applied as a default to EditProxy.selectedTintOpacity.
     *  @type {number}
     *  @default "25"
     */
    override var selectedTintOpacity: Number = definedExternally
    /**
     *  Should the selection outline show a label when the component is selected? This property
     *   is similar to EditContext.showSelectedLabel. Whereas
     *   EditContext.showSelectedLabel controls whether a label is shown at
     *   any time, this property allows normal selection to suppress the label but still show a label
     *   during the drop process on the target. Leave EditContext.showSelectedLabel
     *   unset and set this property to false.
     * 
     *   NOTE: A selected component label is only supported when EditProxy.selectedAppearance
     *   is "outlineEdges".
     *  @type {boolean}
     *  @default null
     */
    override var showSelectedLabelOnSelect: Boolean = definedExternally
    /**
     *  Defines the mode of inclusion for components encountered during hoop selection which
     *   is enabled when EditContext.selectionType is multiple.
     *   encloses mode causes selection of components that are completely
     *   enclosed by the hoop. intersects mode selects components that come
     *   into contact with the hoop.
     *  @type {HoopSelectionStyle}
     *  @default "encloses"
     */
    override var hoopSelectionMode: 
                                    /**
                                     *  Components completely enclosed by the hoop are selected
                                     *  Components enclosed or intersected by the hoop are selected
                                     */
                                    String /* encloses |  intersects */ = definedExternally
    /**
     *  Properties to apply to EditProxy.hoopSelector.
     *  @type {object}
     *  @default null
     */
    override var hoopSelectorProperties: dynamic = definedExternally
    /**
     *  Whether inline editing should be enabled for any components that are added and are placed into
     *   editMode. Enabling this will turn on inline edit for any EditProxy where
     *   EditProxy.supportsInlineEdit is true.
     *  @type {boolean}
     *  @default null
     */
    override var enableInlineEdit: Boolean = definedExternally
    /**
     *   Returns the EditContext instance managed by the EditTree.
     * 
     */
    open fun getEditContext(): EditContext = definedExternally
    /**
     *   Returns the root EditNode of the EditContext typically created from EditTree.rootComponent.
     * 
     * 
     */
    override fun getRootEditNode(): EditNode = definedExternally
    /**
     *   Creates and returns an EditNode using the EditTree.defaultPalette. Does not add the newly
     *   created EditNode to an EditContext.
     * 
     * 
     *  @param {PaletteNode} the palette node to use to create the new node
     */
    override fun makeEditNode(paletteNode: PaletteNode): EditNode = definedExternally
    /**
     *   Gets the tree of editNodes being edited by this editContext. Standard tree
     *   traversal methods can then be used to locate desired editNodes for interaction.
     * 
     *   Note: the returned tree is read-only and must only be modified by calling
     *   methods on EditContext like EditContext.addNode or EditContext.setNodeProperties.
     * 
     * 
     */
    override fun getEditNodeTree(): Tree = definedExternally
    /**
     *   Add a new EditNode to the EditContext, under the specified parent. If the parentNode
     *   is not provided it will be determined from EditContext.defaultParent.
     * 
     *   The EditContext will interrogate the parent and new nodes to determine what field
     *   within the parent allows a child of this type, and to find a method to add the newNode's
     *   liveObject to the parentNode's liveObject. The new relationship will then be stored
     *   in the tree of EditNodes.
     * 
     *   For example, when a Tab is dropped on a TabSet, the field TabSet.tabs is discovered as
     *   the correct target field via naming conventions, and the method TabSet.addTab() is likewise
     *   discovered as the correct method to add a Tab to a TabSet.
     * 
     * 
     *  @param {EditNode} new node to be added
     *  @param {EditNode=} parent to add the new node under.
     *  @param {Integer=} index within the parent's children array
     *  @param {string=} the property of the liveParent to which the new node should                 be added, if not auto-discoverable from the schema
     *  @param {boolean=} whether to skip adding the liveObject to the liveParent                      (default false)
     *  @param {boolean=} whether to replace existing single field node                       if newNode liveObject is the same (default false)
     */
    override fun addNode(newNode: EditNode, parentNode: EditNode?, index: Number?, parentProperty: String?, skipParentComponentAdd: Boolean?, forceSingularFieldReplace: Boolean?): EditNode = definedExternally
    /**
     *   Creates a new EditNode from a PaletteNode, using the
     *   EditTree.defaultPalette. If you have an array of possibly inter-related
     *   PaletteNodes, then you should use
     *   EditTree.addFromPaletteNodes on the array instead,
     *   in order to preserve the relationships.
     * 
     * 
     *  @param {PaletteNode} the palette node to use to create the new node
     *  @param {EditNode=} optional the parent node if the new node should appear                under a specific parent
     */
    override fun addFromPaletteNode(paletteNode: PaletteNode, parentNode: EditNode?): EditNode = definedExternally
    /**
     *   Add the supplied PaletteNode to the parentNode, preserving internal
     *   references from one supplied PaletteNode to another. This method should
     *   be used with an array of possibly inter-related PaletteNodes (for
     *   instance, those produced as a result of serialization via
     *   EditTree.serializeAllEditNodes, rather than
     *   calling EditTree.addFromPaletteNode on each
     *   individual PaletteNode.
     * 
     * 
     *  @param {Array<Partial<PaletteNode>>} array of PaletteNodes
     *  @param {EditNode=} parent to add to (defaults to the root)
     */
    override fun addFromPaletteNodes(paletteNodes: Array<dynamic>, parentNode: EditNode?): Array<dynamic> = definedExternally
    /**
     *   Removes EditNode from the EditContext. The editNode
     *   liveObject is not destroyed.
     * 
     *  @param {EditNode} node to be removed
     */
    override fun removeNode(editNode: EditNode): Unit = definedExternally
    /**
     *   Moves an EditNode from one child index to another in the EditContext under the specified parent.
     * 
     *   No changes are made to the live objects.
     * 
     * 
     *  @param {EditNode} parent to reorder child nodes
     *  @param {Integer} index within the parent's children array to be moved
     *  @param {Integer} index within the parent's children array at which to place moved node
     */
    open fun reorderNode(parentNode: EditNode, index: Number, moveToIndex: Number): Unit = definedExternally
    /**
     *   Removes all EditNode from the EditContext, but does not destroy
     *   the EditNode.liveObject.
     * 
     */
    override fun removeAll(): Unit = definedExternally
    /**
     *   Removes all EditNode from the EditContext, and calls
     *   Canvas.destroy on the
     *   EditNode.liveObject.
     * 
     */
    override fun destroyAll(): Unit = definedExternally
    /**
     *   Returns true if editNode is in edit mode.
     * 
     * 
     *  @param {EditNode} the EditNode
     */
    override fun isNodeEditingOn(editNode: EditNode): Boolean = definedExternally
    /**
     *   Enable edit mode for an EditNode. This is a shortcut for calling
     *   Canvas.setEditMode.
     * 
     * 
     *  @param {EditNode} the EditNode on which to enable editing
     */
    override fun enableEditing(editNode: EditNode): Unit = definedExternally
    /**
     *   Update an editNode's serializable "defaults" with the supplied properties. If you
     *   wish to remove a property from the defaults (rather than setting it to null), then
     *   use EditTree.removeNodeProperties instead.
     * 
     *  @param {EditNode} the editNode to update
     *  @param {Canvas} the properties to apply
     *  @param {boolean=} whether to skip updating the                     EditNode.liveObject,                     e.g. if you have already updated the liveObject
     */
    override fun setNodeProperties(editNode: EditNode, properties: Canvas, skipLiveObjectUpdate: Boolean?): Unit = definedExternally
    /**
     *   Removes the specified properties from an editNode's serializable "defaults".
     *   Note that the EditNode.liveObject is not updated by this method.
     *   To set a property to null (rather than removing it), use
     *   EditTree.setNodeProperties instead.
     * 
     *  @param {EditNode} the editNode to update
     *  @param {Array<Partial<string>>} an array of property names to remove
     */
    override fun removeNodeProperties(editNode: EditNode, properties: Array<dynamic>): Unit = definedExternally
    /**
     *  Palette to use when an EditNode is being created directly by this EditContext,
     *   instead of being created due to a user interaction with a palette (eg dragging from
     *   a TreePalette, or clicking on MenuPalette).
     * 
     *   If no defaultPalette is provided, the EditContext uses an automatically created
     *   HiddenPalette.
     */
    override fun getDefaultPalette(): Palette = definedExternally
    /**
     *  Palette to use when an EditNode is being created directly by this EditContext,
     *   instead of being created due to a user interaction with a palette (eg dragging from
     *   a TreePalette, or clicking on MenuPalette).
     * 
     *   If no defaultPalette is provided, the EditContext uses an automatically created
     *   HiddenPalette.
     *  @param {Palette} the default Palette
     */
    override fun setDefaultPalette(palette: Palette): Unit = definedExternally
    /**
     *   Creates a PaletteNode from an EditNode in this context's
     *   EditTree.getEditNodeTree.
     * 
     *   This essentially creates a new PaletteNode with the EditNode.defaults from the
     *   passed editNode. The returned paletteNode could then be used with
     *   EditContext.addFromPaletteNode to effectively create a copy of the original editNode -
     *   specifically a new editNode with a new EditNode.liveObject created from the same
     *   defaults.
     * 
     *   However note that makePaletteNode() does not copy descendant nodes - use
     *   EditTree.makePaletteNodeTree for that.
     * 
     *   May return null if the passed editNode cannot validly by transformed into a paletteNode, for
     *   example if EditNode.canDuplicate was set false.
     * 
     * 
     *  @param {EditNode} the editNode to use to make a paletteNode
     */
    override fun makePaletteNode(editNode: EditNode): PaletteNode = definedExternally
    /**
     *   Creates a Tree of PaletteNode from an EditNode in this
     *   context's EditTree.getEditNodeTree, by using EditTree.makePaletteNode on the
     *   passed EditNode and its descendents within the
     *   EditContext.getEditNodeTree.
     * 
     *   The root node of the returned Tree will be a PaletteNode derived from the passed
     *   EditNode.
     * 
     * 
     *  @param {EditNode} root editNode to make Tree of PaletteNodes from
     */
    override fun makePaletteNodeTree(editNode: EditNode): Tree = definedExternally
    /**
     *   Copies the passed editNode or editNodes to an internal "clipboard" space, for later application
     *   via EditTree.pasteEditNodes.
     * 
     * \* @param {EditNode | Array<Partial<EditNode>>} 
     */
    override fun copyEditNodes(editNode: dynamic): Unit = definedExternally
    /**
     *   "Pastes" editNodes previously captured via EditTree.copyEditNodes.
     * 
     *   New editNodes will be added as root-level nodes of the EditTree.getEditNodeTree
     *   unless a targetEditNode is passed.
     * 
     * \* @param {EditNode=} 
     */
    override fun pasteEditNodes(targetEditNode: EditNode?): Unit = definedExternally
    /**
     *   Recreate EditNode from an XML representation of
     *   PaletteNode (possibly created by calling
     *   EditTree.serializeAllEditNodes or EditTree.serializeEditNodes.
     * 
     *   By default, components that have Canvas.ID will not
     *   actually be allowed to take those global IDs - instead, only widgets that have one of the
     *   global IDs passed as the globals parameter will actually receive their global
     *   IDs. To override this behavior, pass the special value RPCManager.ALL_GLOBALS
     *   for the globals parameter.
     * 
     * 
     *  @param {string} XML string
     *  @param {EditNode=} parent node (defaults to the root)
     *  @param {Array<Partial<string>>=} widgets to allow to take their global IDs
     *  @param {Function=} Callback to fire after nodes have been added
     */
    override fun addPaletteNodesFromXML(xmlString: String, parentNode: EditNode?, globals: Array<dynamic>?, callback: (() -> dynamic?)): Unit = definedExternally
    /**
     *   Recreate EditNode from a JSON representation of
     *   PaletteNode (possibly created by calling
     *   EditTree.serializeAllEditNodesAsJSON or EditTree.serializeEditNodesAsJSON.
     * 
     *   By default, components that have Canvas.ID will not
     *   actually be allowed to take those global IDs - instead, only widgets that have one of the
     *   global IDs passed as the globals parameter will actually receive their global
     *   IDs. To override this behavior, pass the special value RPCManager.ALL_GLOBALS
     *   for the globals parameter.
     * 
     * 
     *  @param {string} JSON string
     *  @param {EditNode=} parent node (defaults to the root)
     *  @param {Array<Partial<string>>=} widgets to allow to take their global IDs
     *  @param {Function=} Callback to fire after nodes have been added
     */
    override fun addPaletteNodesFromJSON(jsonString: String, parentNode: EditNode?, globals: Array<dynamic>?, callback: (() -> dynamic?)): Unit = definedExternally
    /**
     *   Obtain PaletteNode from an XML representation,
     *   but do not add them to the EditContext.
     * 
     * 
     *  @param {string} XML string
     *  @param {PaletteNodeCallback} Callback used to return the PaletteNodes
     */
    override fun getPaletteNodesFromXML(xmlString: String, callback: ((paletteNodes: Array<dynamic>) -> Unit)): Unit = definedExternally
    /**
     *   Add PaletteNode from a JavaScript source representation.
     * 
     *   By default, components that have Canvas.ID will not
     *   actually be allowed to take those global IDs - instead, only widgets that have one of the
     *   global IDs passed as the globals parameter will actually receive their global
     *   IDs. To override this behavior, pass the special value RPCManager.ALL_GLOBALS
     *   for the globals parameter.
     * 
     * 
     *  @param {string} JavaScript code to eval.
     *  @param {EditNode=} parent node (defaults to the root)
     *  @param {Array<Partial<string>>=} widgets to allow to take their global IDs
     */
    override fun addPaletteNodesFromJS(jsCode: String, parentNode: EditNode?, globals: Array<dynamic>?): Unit = definedExternally
    /**
     *   Serialize the tree of EditNode to an XML representation
     *   of PaletteNode. The result can be supplied to
     *   EditTree.addPaletteNodesFromXML to recreate
     *   the EditNodes.
     * 
     * 
     *  @param {SerializationSettings=} Additional serialization settings
     */
    override fun serializeAllEditNodes(settings: SerializationSettings?): String = definedExternally
    /**
     *   Encode the tree of EditNode to a JSON representation
     *   of PaletteNode. The result can be supplied to
     *   EditTree.addPaletteNodesFromJSON to recreate
     *   the EditNodes.
     * 
     * 
     *  @param {SerializationSettings=} Additional serialization settings
     */
    override fun serializeAllEditNodesAsJSON(settings: SerializationSettings?): String = definedExternally
    /**
     *   Serialize the provided EditNode to an XML
     *   representation of PaletteNode. Note that the
     *   EditNodes must have been added to this EditContext. The result can be
     *   supplied to EditTree.addPaletteNodesFromXML to
     *   recreate the EditNodes.
     * 
     * 
     *  @param {Array<Partial<EditNode>>} EditNodes to be serialized
     *  @param {SerializationSettings=} Additional serialization settings
     */
    override fun serializeEditNodes(nodes: Array<dynamic>, settings: SerializationSettings?): String = definedExternally
    /**
     *   Serialize the provided EditNode to a JSON
     *   representation of PaletteNode. Note that the
     *   EditNodes must have been added to this EditContext. The result can be
     *   supplied to EditTree.addPaletteNodesFromJSON to
     *   recreate the EditNodes.
     * 
     * 
     *  @param {Array<Partial<EditNode>>} EditNodes to be serialized
     *  @param {SerializationSettings=} Additional serialization settings
     */
    override fun serializeEditNodesAsJSON(nodes: Array<dynamic>, settings: SerializationSettings?): String = definedExternally
    /**
     *   Notification fired when an EditNode has been added to the EditContext
     * 
     * 
     *  @param {EditNode} node that was added
     *  @param {EditNode} parent node of the node that was added
     *  @param {EditNode} root node of the edit context
     */
    override fun nodeAdded(newNode: EditNode, parentNode: EditNode, rootNode: EditNode): Unit = definedExternally
    /**
     *   Obtain PaletteNode from a JavaScript source representation.
     * 
     *   By default, components that have Canvas.ID will not
     *   actually be allowed to take those global IDs - instead, only widgets that have one of the
     *   global IDs passed as the globals parameter will actually receive their global
     *   IDs. To override this behavior, pass the special value RPCManager.ALL_GLOBALS
     *   for the globals parameter.
     * 
     * 
     *  @param {string} JavaScript code to eval.
     *  @param {PaletteNodeCallback} Callback used to return the PaletteNodes
     *  @param {Array<Partial<string>>=} widgets to allow to take their global IDs
     */
    override fun getPaletteNodesFromJS(jsCode: String, callback: ((paletteNodes: Array<dynamic>) -> Unit), globals: Array<dynamic>?): Unit = definedExternally
    /**
     *   Update an editNode's EditProxy properties. If editProxy has not yet
     *   been created, editProxyProperties is updated or created instead.
     * 
     * 
     *  @param {EditNode} the editNode to update
     *  @param {EditProxy} the properties to apply
     */
    override fun setEditProxyProperties(editNode: EditNode, properties: EditProxy): Unit = definedExternally
    /**
     *   Executed when the left mouse is clicked (pressed and then released) on any selectable
     *   component with EditProxy.editMask enabled.
     *   implementation.
     * 
     * 
     *  @param {EditNode} the editNode clicked
     *  @param {object} the object clicked
     */
    override fun editMaskClicked(editNode: EditNode, liveObject: dynamic): Unit = definedExternally
    /**
     *   Overridable method to provide a custom selection outline label. This method
     *   is called when a label is to be shown with an outline. Returning null
     *   causes the default label to be used which is derived from a component.toString()
     *   call.
     * 
     *   There is no default implementation of this method - it is purely an override point.
     * 
     *  @param {object} the Canvas or FormItem component to label
     */
    override fun getSelectedLabelText(component: dynamic): String = definedExternally
    /**
     *   Returns all selected EditNodes as an Array.
     * 
     * 
     */
    override fun getSelectedEditNodes(): Array<dynamic> = definedExternally
    /**
     *   Returns selected EditNode or first selected EditNode if multiple
     *   nodes are selected.
     * 
     * 
     */
    override fun getSelectedEditNode(): EditNode = definedExternally
    /**
     *   Returns true if the editNode is selected.
     * 
     * 
     */
    override fun isEditNodeSelected(): Boolean = definedExternally
    /**
     *   Select an EditNode.
     * 
     * 
     *  @param {EditNode} editNode to select
     */
    override fun selectEditNode(editNode: EditNode): Unit = definedExternally
    /**
     *   Select a single EditNode and deselect everything else.
     * 
     * 
     *  @param {EditNode} editNode to select
     */
    override fun selectSingleEditNode(editNode: EditNode): Unit = definedExternally
    /**
     *   Select all EditNodes.
     * 
     * 
     */
    override fun selectAllEditNodes(): Unit = definedExternally
    /**
     *   Deselect a list of EditNodes.
     * 
     * 
     *  @param {Array<Partial<EditNode>>} editNodes to deselect
     */
    override fun deselectEditNodes(editNodes: Array<dynamic>): Unit = definedExternally
    /**
     *   Deselect all EditNodes.
     * 
     * 
     */
    override fun deselectAllEditNodes(): Unit = definedExternally
    /**
     *   Called when editMode selection changes. Note this method fires exactly once for any given
     *   change.
     * 
     *   This event is fired once after selection/deselection has completed. The result is
     *   one event per mouse-down event. For a drag selection there will be one event fired
     *   when the range is completed.
     * 
     * 
     *  @param {EditNode} first selected node, if any
     *  @param {Array<Partial<EditNode>>} List of nodes that are now selected
     */
    override fun selectedEditNodesUpdated(editNode: EditNode, editNodeList: Array<dynamic>): Unit = definedExternally
    /**
     *   Fires whenever editNode.defaults are modified by setNodeProperties() and/or editProxy
     *   features
     * 
     *  @param {EditNode} currently editing node
     *  @param {EditContext} current context
     *  @param {Array<Partial<string>>} properties that were modified
     */
    override fun editNodeUpdated(editNode: EditNode, editContext: EditContext, modifiedProperties: Array<dynamic>): Unit = definedExternally
    companion object {
        /**
         *  Creates a new EditTree
         * 
         *  @param typeCheckedProperties {Partial<EditTree>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {EditTree} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): EditTree = definedExternally
    }
}