@file:JsQualifier("isc")
package isc

external interface EditContext /*: Class*/ {
    var editNodePasteOffset: Number
    var rootComponent: PaletteNode
    var defaultPalette: Palette
    var extraPalettes: Array<dynamic>
    var persistCoordinates: Boolean
    var allowNestedDrops: Boolean
    var autoEditNewNodes: Boolean
    var defaultParent: EditNode
    var useCopyPasteShortcuts: Boolean
    var editMaskProperties: dynamic
    var selectionType: 
                       /**
                        *  don't select at all
                        *  select only one item at a time
                        *  select one or more items
                        *  select one or more items as a toggle      so you don't need to hold down control keys to select
                        *                   more than one object
                        */
                       String /* none |  single |  multiple |  simple */
    var canSelectEditNodes: Boolean
    var selectedAppearance: 
                            /**
                             *  editMask on top of the component is updated with EditProxy.selectedTintColor            and EditProxy.selectedTintOpacity
                             *  editMask on top of the component is updated with EditProxy.selectedBorder
                             *  MultiAutoChild is created on top of the component. This constructs a border around            the component using 4 separate outlineEdge components so that interactivity is not blocked.
                             *  no change in appearance. Override EditProxy.showSelectedAppearance to create a custom appearance.
                             */
                            String /* tintMask |  outlineMask |  outlineEdges |  none */
    var selectedBorder: String
    var selectedLabelBackgroundColor: String
    var selectedTintColor: String
    var selectedTintOpacity: Number
    var showSelectedLabel: Boolean
    var showSelectedLabelOnSelect: Boolean
    var canGroupSelect: Boolean
    var canDragGroup: Boolean
    var hideGroupBorderOnDrag: Boolean
    var hoopSelectionMode: 
                           /**
                            *  Components completely enclosed by the hoop are selected
                            *  Components enclosed or intersected by the hoop are selected
                            */
                           String /* encloses |  intersects */
    var hoopSelectorProperties: dynamic
    var enableInlineEdit: Boolean
    fun getDefaultPalette (): Palette
    fun setDefaultPalette (palette: Palette): Unit
    fun addNode (newNode: EditNode, parentNode: EditNode?, index: Number?, parentProperty: String?, skipParentComponentAdd: Boolean?, forceSingularFieldReplace: Boolean?): EditNode
    fun getRootEditNode (): EditNode
    fun nodeAdded (newNode: EditNode, parentNode: EditNode, rootNode: EditNode): Unit
    fun addFromPaletteNode (paletteNode: PaletteNode, parentNode: EditNode?): EditNode
    fun makeEditNode (paletteNode: PaletteNode): EditNode
    fun getEditNodeTree (): Tree
    fun removeAll (): Unit
    fun destroyAll (): Unit
    fun removeNode (editNode: EditNode): Unit
    fun serializeAllEditNodes (settings: SerializationSettings?): String
    fun serializeAllEditNodesAsJSON (settings: SerializationSettings?): String
    fun serializeEditNodes (nodes: Array<dynamic>, settings: SerializationSettings?): String
    fun serializeEditNodesAsJSON (nodes: Array<dynamic>, settings: SerializationSettings?): String
    fun addPaletteNodesFromXML (xmlString: String, parentNode: EditNode?, globals: Array<dynamic>?, callback: (() -> dynamic?)): Unit
    fun addPaletteNodesFromJSON (jsonString: String, parentNode: EditNode?, globals: Array<dynamic>?, callback: (() -> dynamic?)): Unit
    fun getPaletteNodesFromXML (xmlString: String, callback: ((paletteNodes: Array<dynamic>) -> Unit)): Unit
    fun addPaletteNodesFromJS (jsCode: String, parentNode: EditNode?, globals: Array<dynamic>?): Unit
    fun getPaletteNodesFromJS (jsCode: String, callback: ((paletteNodes: Array<dynamic>) -> Unit), globals: Array<dynamic>?): Unit
    fun addFromPaletteNodes (paletteNodes: Array<dynamic>, parentNode: EditNode?): Array<dynamic>
    fun isNodeEditingOn (editNode: EditNode): Boolean
    fun enableEditing (editNode: EditNode): Unit
    fun setNodeProperties (editNode: EditNode, properties: Canvas, skipLiveObjectUpdate: Boolean?): Unit
    fun removeNodeProperties (editNode: EditNode, properties: Array<dynamic>): Unit
    fun setEditProxyProperties (editNode: EditNode, properties: EditProxy): Unit
    fun makePaletteNode (editNode: EditNode): PaletteNode
    fun makePaletteNodeTree (editNode: EditNode): Tree
    fun copyEditNodes (editNode: dynamic): Unit
    fun pasteEditNodes (targetEditNode: EditNode?): Unit
    fun editMaskClicked (editNode: EditNode, liveObject: dynamic): Unit
    fun getSelectedLabelText (component: dynamic): String
    fun getSelectedEditNodes (): Array<dynamic>
    fun getSelectedEditNode (): EditNode
    fun isEditNodeSelected (): Boolean
    fun selectEditNode (editNode: EditNode): Unit
    fun selectSingleEditNode (editNode: EditNode): Unit
    fun selectAllEditNodes (): Unit
    fun deselectEditNodes (editNodes: Array<dynamic>): Unit
    fun deselectAllEditNodes (): Unit
    fun selectedEditNodesUpdated (editNode: EditNode, editNodeList: Array<dynamic>): Unit
    fun editNodeUpdated (editNode: EditNode, editContext: EditContext, modifiedProperties: Array<dynamic>): Unit
}