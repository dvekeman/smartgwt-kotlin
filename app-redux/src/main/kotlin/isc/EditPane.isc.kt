@file:JsQualifier("isc")
package isc

/**
 *  A container that allows drag and drop instantiation of visual components from a
 *   Palette, and direct manipulation of the position and size of those components.
 * 
 *   Any drag onto an EditPane from a Palette will add an EditNode created from the dragged
 *   PaletteNode.
 * 
 *   EditPane automatically creates an EditContext and provides several APIs and
 *   settings that are passthroughs to the underlying EditContext for convenience.
 */
open external class EditPane : Canvas {
    /**
     *  An EditContext is automatically created to manage EditMode behavior. The public
     *   EditContext APIs exposed by the EditPane are passed through to this object.
     * 
     *   Additional editContext properties can be supplied as
     *   EditPane.editContextProperties.
     *  @type {EditContext}
     *  @default null
     */
    open var editContext: EditContext = definedExternally
    /**
     *  Properties to be applied to the EditPane.editContext when created.
     *  @type {EditContext}
     *  @default null
     */
    open var editContextProperties: EditContext = definedExternally
    /**
     *  New nodes added to the editContext are automatically placed
     *   into edit mode if the new node's parent is in edit mode. To
     *   suppress this action set autoEditNewNodes to false.
     *  @type {boolean}
     *  @default null
     */
    open var autoEditNewNodes: Boolean = definedExternally
    /**
     *  Root of data to edit. Must contain the "type" property, with the name of a
     *   valid DataSource or nothing will be able to be dropped on this
     *   EditContext. A "liveObject" property representing the rootComponent is also
     *   suggested. Otherwise, a live object will be created from the palette node.
     * 
     *   Can be retrieved at any time. Use EditPane.getRootEditNode to retrieve the
     *   EditNode created from the rootComponent.
     *  @type {PaletteNode}
     *  @default null
     */
    open var rootComponent: PaletteNode = definedExternally
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
    open var defaultPalette: Palette = definedExternally
    /**
     *  Additional Palette to consult for metadata when
     *   deserializing EditNode. Note that the
     *   EditPane.defaultPalette is always consulted and need not be
     *   provided again here.
     *  @type {Array<Partial<Palette>>}
     *  @default null
     */
    open var extraPalettes: Array<dynamic> = definedExternally
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
    open var persistCoordinates: Boolean = definedExternally
    /**
     *  Controls whether components can be dropped into other components which support child
     *   components.
     * 
     *   When enabled, during a drop interaction in which a PaletteNode or EditNode
     *   is the drop data, the componentSchema of the current
     *   candidate drop target is inspected to see whether that parent allows children of the
     *   type being dropped. If it does, the drop will result in a call to EditPane.addNode for
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
    open var allowNestedDrops: Boolean = definedExternally
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
    open var showSelectedLabel: Boolean = definedExternally
    /**
     *  Set the CSS border to be applied to the selection outline of the selected components.
     *   This property is used when EditProxy.selectedAppearance is outlineMask
     *   or outlineEdges.
     * 
     *   This value is applied as a default to EditProxy.selectedBorder.
     *  @type {string}
     *  @default null
     */
    open var selectedBorder: String = definedExternally
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
    open var selectedLabelBackgroundColor: String = definedExternally
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
    open var canGroupSelect: Boolean = definedExternally
    /**
     *  Should the group selection box shown when EditContext.canGroupSelect
     *   is true allow dragging the group as a whole?
     * 
     *   Treated as true if not set and EditContext.canGroupSelect
     *   is true.
     *  @type {boolean}
     *  @default null
     */
    open var canDragGroup: Boolean = definedExternally
    /**
     *  Should the group selection box shown when EditContext.canGroupSelect
     *   is true be hidden during drag?
     * 
     *   Treated as true if not explicitly set to false.
     *  @type {boolean}
     *  @default null
     */
    open var hideGroupBorderOnDrag: Boolean = definedExternally
    /**
     *  If set, auto-enables EditProxy.useCopyPasteShortcuts on the EditProxy for the
     *   EditPane.getRootEditNode. This works whether there is currently a root editNode
     *   or one is added later.
     *  @type {boolean}
     *  @default null
     */
    open var useCopyPasteShortcuts: Boolean = definedExternally
    /**
     *   Returns the EditContext instance managed by the EditPane.
     * 
     */
    open fun getEditContext(): EditContext = definedExternally
    /**
     *   Returns an Array of PaletteNodes representing all current EditNodes in this
     *   pane, suitable for saving and restoring via passing each paletteNode to EditContext.addNode.
     * 
     */
    open fun getSaveData(): Array<dynamic> = definedExternally
    /**
     *   Returns the root EditNode of the EditContext typically created from EditPane.rootComponent.
     * 
     * 
     */
    open fun getRootEditNode(): EditNode = definedExternally
    /**
     *   Creates and returns an EditNode using the EditPane.defaultPalette. Does not add the newly
     *   created EditNode to an EditContext.
     * 
     * 
     *  @param {PaletteNode} the palette node to use to create the new node
     */
    open fun makeEditNode(paletteNode: PaletteNode): EditNode = definedExternally
    /**
     *   Gets the tree of editNodes being edited by this editContext. Standard tree
     *   traversal methods can then be used to locate desired editNodes for interaction.
     * 
     *   Note: the returned tree is read-only and must only be modified by calling
     *   methods on EditContext like EditContext.addNode or EditContext.setNodeProperties.
     * 
     * 
     */
    open fun getEditNodeTree(): Tree = definedExternally
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
    open fun addNode(newNode: EditNode, parentNode: EditNode?, index: Number?, parentProperty: String?, skipParentComponentAdd: Boolean?, forceSingularFieldReplace: Boolean?): EditNode = definedExternally
    /**
     *   Creates a new EditNode from a PaletteNode, using the
     *   EditPane.defaultPalette. If you have an array of possibly inter-related
     *   PaletteNodes, then you should use
     *   EditPane.addFromPaletteNodes on the array instead,
     *   in order to preserve the relationships.
     * 
     * 
     *  @param {PaletteNode} the palette node to use to create the new node
     *  @param {EditNode=} optional the parent node if the new node should appear                under a specific parent
     */
    open fun addFromPaletteNode(paletteNode: PaletteNode, parentNode: EditNode?): EditNode = definedExternally
    /**
     *   Add the supplied PaletteNode to the parentNode, preserving internal
     *   references from one supplied PaletteNode to another. This method should
     *   be used with an array of possibly inter-related PaletteNodes (for
     *   instance, those produced as a result of serialization via
     *   EditPane.serializeAllEditNodes, rather than
     *   calling EditPane.addFromPaletteNode on each
     *   individual PaletteNode.
     * 
     * 
     *  @param {Array<Partial<PaletteNode>>} array of PaletteNodes
     *  @param {EditNode=} parent to add to (defaults to the root)
     */
    open fun addFromPaletteNodes(paletteNodes: Array<dynamic>, parentNode: EditNode?): Array<dynamic> = definedExternally
    /**
     *   Removes EditNode from the EditContext. The editNode
     *   liveObject is not destroyed.
     * 
     *  @param {EditNode} node to be removed
     */
    open fun removeNode(editNode: EditNode): Unit = definedExternally
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
    open fun removeAll(): Unit = definedExternally
    /**
     *   Removes all EditNode from the EditContext, and calls
     *   Canvas.destroy on the
     *   EditNode.liveObject.
     * 
     */
    open fun destroyAll(): Unit = definedExternally
    /**
     *   Returns true if editNode is in edit mode.
     * 
     * 
     *  @param {EditNode} the EditNode
     */
    open fun isNodeEditingOn(editNode: EditNode): Boolean = definedExternally
    /**
     *   Enable edit mode for an EditNode. This is a shortcut for calling
     *   Canvas.setEditMode.
     * 
     * 
     *  @param {EditNode} the EditNode on which to enable editing
     */
    open fun enableEditing(editNode: EditNode): Unit = definedExternally
    /**
     *   Update an editNode's serializable "defaults" with the supplied properties. If you
     *   wish to remove a property from the defaults (rather than setting it to null), then
     *   use EditPane.removeNodeProperties instead.
     * 
     *  @param {EditNode} the editNode to update
     *  @param {Canvas} the properties to apply
     *  @param {boolean=} whether to skip updating the                     EditNode.liveObject,                     e.g. if you have already updated the liveObject
     */
    open fun setNodeProperties(editNode: EditNode, properties: Canvas, skipLiveObjectUpdate: Boolean?): Unit = definedExternally
    /**
     *   Removes the specified properties from an editNode's serializable "defaults".
     *   Note that the EditNode.liveObject is not updated by this method.
     *   To set a property to null (rather than removing it), use
     *   EditPane.setNodeProperties instead.
     * 
     *  @param {EditNode} the editNode to update
     *  @param {Array<Partial<string>>} an array of property names to remove
     */
    open fun removeNodeProperties(editNode: EditNode, properties: Array<dynamic>): Unit = definedExternally
    /**
     *  Palette to use when an EditNode is being created directly by this EditContext,
     *   instead of being created due to a user interaction with a palette (eg dragging from
     *   a TreePalette, or clicking on MenuPalette).
     * 
     *   If no defaultPalette is provided, the EditContext uses an automatically created
     *   HiddenPalette.
     */
    open fun getDefaultPalette(): Palette = definedExternally
    /**
     *  Palette to use when an EditNode is being created directly by this EditContext,
     *   instead of being created due to a user interaction with a palette (eg dragging from
     *   a TreePalette, or clicking on MenuPalette).
     * 
     *   If no defaultPalette is provided, the EditContext uses an automatically created
     *   HiddenPalette.
     *  @param {Palette} the default Palette
     */
    open fun setDefaultPalette(palette: Palette): Unit = definedExternally
    /**
     *   Creates a PaletteNode from an EditNode in this context's
     *   EditPane.getEditNodeTree.
     * 
     *   This essentially creates a new PaletteNode with the EditNode.defaults from the
     *   passed editNode. The returned paletteNode could then be used with
     *   EditContext.addFromPaletteNode to effectively create a copy of the original editNode -
     *   specifically a new editNode with a new EditNode.liveObject created from the same
     *   defaults.
     * 
     *   However note that makePaletteNode() does not copy descendant nodes - use
     *   EditPane.makePaletteNodeTree for that.
     * 
     *   May return null if the passed editNode cannot validly by transformed into a paletteNode, for
     *   example if EditNode.canDuplicate was set false.
     * 
     * 
     *  @param {EditNode} the editNode to use to make a paletteNode
     */
    open fun makePaletteNode(editNode: EditNode): PaletteNode = definedExternally
    /**
     *   Creates a Tree of PaletteNode from an EditNode in this
     *   context's EditPane.getEditNodeTree, by using EditPane.makePaletteNode on the
     *   passed EditNode and its descendents within the
     *   EditContext.getEditNodeTree.
     * 
     *   The root node of the returned Tree will be a PaletteNode derived from the passed
     *   EditNode.
     * 
     * 
     *  @param {EditNode} root editNode to make Tree of PaletteNodes from
     */
    open fun makePaletteNodeTree(editNode: EditNode): Tree = definedExternally
    /**
     *   Copies the passed editNode or editNodes to an internal "clipboard" space, for later application
     *   via EditPane.pasteEditNodes.
     * 
     * \* @param {EditNode | Array<Partial<EditNode>>} 
     */
    open fun copyEditNodes(editNode: dynamic): Unit = definedExternally
    /**
     *   "Pastes" editNodes previously captured via EditPane.copyEditNodes.
     * 
     *   New editNodes will be added as root-level nodes of the EditPane.getEditNodeTree
     *   unless a targetEditNode is passed.
     * 
     * \* @param {EditNode=} 
     */
    open fun pasteEditNodes(targetEditNode: EditNode?): Unit = definedExternally
    /**
     *   Recreate EditNode from an XML representation of
     *   PaletteNode (possibly created by calling
     *   EditPane.serializeAllEditNodes or EditPane.serializeEditNodes.
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
    open fun addPaletteNodesFromXML(xmlString: String, parentNode: EditNode?, globals: Array<dynamic>?, callback: (() -> dynamic?)): Unit = definedExternally
    /**
     *   Recreate EditNode from a JSON representation of
     *   PaletteNode (possibly created by calling
     *   EditPane.serializeAllEditNodesAsJSON or EditPane.serializeEditNodesAsJSON.
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
    open fun addPaletteNodesFromJSON(jsonString: String, parentNode: EditNode?, globals: Array<dynamic>?, callback: (() -> dynamic?)): Unit = definedExternally
    /**
     *   Obtain PaletteNode from an XML representation,
     *   but do not add them to the EditContext.
     * 
     * 
     *  @param {string} XML string
     *  @param {PaletteNodeCallback} Callback used to return the PaletteNodes
     */
    open fun getPaletteNodesFromXML(xmlString: String, callback: ((paletteNodes: Array<dynamic>) -> Unit)): Unit = definedExternally
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
    open fun addPaletteNodesFromJS(jsCode: String, parentNode: EditNode?, globals: Array<dynamic>?): Unit = definedExternally
    /**
     *   Serialize the tree of EditNode to an XML representation
     *   of PaletteNode. The result can be supplied to
     *   EditPane.addPaletteNodesFromXML to recreate
     *   the EditNodes.
     * 
     * 
     *  @param {SerializationSettings=} Additional serialization settings
     */
    open fun serializeAllEditNodes(settings: SerializationSettings?): String = definedExternally
    /**
     *   Encode the tree of EditNode to a JSON representation
     *   of PaletteNode. The result can be supplied to
     *   EditPane.addPaletteNodesFromJSON to recreate
     *   the EditNodes.
     * 
     * 
     *  @param {SerializationSettings=} Additional serialization settings
     */
    open fun serializeAllEditNodesAsJSON(settings: SerializationSettings?): String = definedExternally
    /**
     *   Serialize the provided EditNode to an XML
     *   representation of PaletteNode. Note that the
     *   EditNodes must have been added to this EditContext. The result can be
     *   supplied to EditPane.addPaletteNodesFromXML to
     *   recreate the EditNodes.
     * 
     * 
     *  @param {Array<Partial<EditNode>>} EditNodes to be serialized
     *  @param {SerializationSettings=} Additional serialization settings
     */
    open fun serializeEditNodes(nodes: Array<dynamic>, settings: SerializationSettings?): String = definedExternally
    /**
     *   Serialize the provided EditNode to a JSON
     *   representation of PaletteNode. Note that the
     *   EditNodes must have been added to this EditContext. The result can be
     *   supplied to EditPane.addPaletteNodesFromJSON to
     *   recreate the EditNodes.
     * 
     * 
     *  @param {Array<Partial<EditNode>>} EditNodes to be serialized
     *  @param {SerializationSettings=} Additional serialization settings
     */
    open fun serializeEditNodesAsJSON(nodes: Array<dynamic>, settings: SerializationSettings?): String = definedExternally
    companion object {
        /**
         *  Creates a new EditPane
         * 
         *  @param typeCheckedProperties {Partial<EditPane>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {EditPane} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): EditPane = definedExternally
    }
}