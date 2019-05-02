@file:JsQualifier("isc")
package isc

/**
 *  Defines a set of properties that specify how the tree will be explored by Tree.discoverTree
 */
open external class DiscoverTreeSettings {
    /**
     *  When heuristically finding a property that appears to contain child objects, the childrenMode
     *   determines how to chose the property that appears to contain child objects
     *  @type {ChildrenPropertyMode}
     *  @default "ChildrenPropertyMode.ANY"
     */
    open var childrenMode: 
                           /**
                            *  assume the first object or array value we find is the children property
                            *  assume the first array we find is the children property, no matter the contents
                            *  assume the first object or array of objects we find is the children property     (don't allow arrays that don't have objects)
                            *  accept only an array of objects as the children property
                            */
                           String /* any |  array |  object |  objectArray */ = definedExternally
    /**
     *  Determines how to scan for the Tree.childrenProperty
     *  @type {ScanMode}
     *  @default "ScanMode.BRANCH"
     */
    open var scanMode: 
                       /**
                        *  take each node individually
                        *  scan direct siblings as a group, looking for best fit
                        *  scan entire tree levels as a group, looking for best fit
                        */
                       String /* node |  branch |  level */ = definedExternally
    /**
     *  What to do if there is more than one possible Tree.childrenProperty
     *   when using scanMode "branch" or "level"
     *  @type {TieMode}
     *  @default "TieMode.NODE"
     */
    open var tieMode: 
                      /**
                       *  continue, but pick childrenProperty on a per-node basis (will detect mixed)
                       *  continue, picking the childrenProperty that occurred most as the single choice
                       *  if there's a tie, stop at this level (assume no further children)
                       */
                      String /* node |  highest |  stop */ = definedExternally
    /**
     *  What to rename the array of children once discovered.
     *   If not set, it will default to the value of Tree.childrenProperty inside discoverTree()
     *  @type {string}
     *  @default "null (see below)"
     */
    open var newChildrenProperty: String = definedExternally
    /**
     *  Each discovered child is labeled with a configurable "typeProperty" set to the value
     *   of the property that held the children
     *  @type {string}
     *  @default null
     */
    open var typeProperty: String = definedExternally
    /**
     *  For string leaf nodes (if allowed), the name of the property to store the string under
     *   in the auto-created object
     *  @type {string}
     *  @default null
     */
    open var nameProperty: String = definedExternally
}