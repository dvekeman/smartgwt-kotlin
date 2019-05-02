@file:JsQualifier("isc")
package isc

/**
 *  An object representing a user-created and user-modifiable hilite, which can be created and
 *   edited with a HiliteEditor either directly or via the
 *   ListGrid.canEditHilites behavior.
 * 
 *   See hiliting for an overview.
 */
open external class Hilite {
    /**
     *  Unique id for this hilite definition.
     * 
     *   For hilites that include Hilite.criteria this is not required.
     * 
     *   If you are explicitly marking records for hiliting, set
     *   DataBoundComponent.hiliteProperty on the record to this id.
     *  @type {string}
     *  @default null
     */
    open var id: String = definedExternally
    /**
     *  CSS text to be applied to cells where this hilite is applied, for example,
     *   "background-color:#FF0000"
     *  @type {CSSText}
     *  @default null
     */
    open var cssText: String = definedExternally
    /**
     *  Name of the field, or array of fieldNames, this hilite should be applied to.
     * 
     *   If unset, hilite is applied to every field of the record.
     *  @type {FieldName | Array<Partial<FieldName>>}
     *  @default null
     */
    open var fieldName: dynamic = definedExternally
    /**
     *  Criteria defining what records this hilite should apply to.
     *  @type {Criteria | AdvancedCriteria}
     *  @default null
     */
    open var criteria: dynamic = definedExternally
    /**
     *  HTML to pre-pend to cell values where this hilite is applied.
     *  @type {HTMLString}
     *  @default null
     */
    open var htmlBefore: String = definedExternally
    /**
     *  HTML to append to the end of cell values where this hilite is applied.
     *  @type {HTMLString}
     *  @default null
     */
    open var htmlAfter: String = definedExternally
    /**
     *  Value to show in place of the actual value from the record, for a record that matches
     *   this hilite.
     * 
     *   This can be used to take ranges of numeric values and simplify them to "Low", "Medium",
     *   "High" or similar textual values, translate very small or very large values to "Outlier" or
     *   "Negligible", and similar use cases.
     *  @deprecated \* htmlValue is deprecated in favor of Hilite.replacementValue.  Note that unlike replacementValue, this property does not respect
     *   Hilite.disabled, and will be applied even if disabled is set to
     *   true
     *  @type {string}
     *  @default null
     */
    open var htmlValue: String = definedExternally
    /**
     *  Whether this hilite is currently disabled.
     * 
     *   Hilites can be programmatically enabled and disabled via DataBoundComponent.enableHilite.
     *  @type {boolean}
     *  @default false
     */
    open var disabled: Boolean = definedExternally
    /**
     *  Can highlight be edited from header context menu? Setting attribute to
     *   false prevents editing. A null or true
     *   value allows editing.
     *  @type {boolean}
     *  @default null
     */
    open var canEdit: Boolean = definedExternally
    /**
     *  User-visible title for this hilite. Used for interfaces such as menus that can enable or
     *   disable hilites.
     *  @type {string}
     *  @default null
     */
    open var title: String = definedExternally
    /**
     *  When edited via a HiliteEditor, the value for the foreground color of this
     *   hilite. If this is omitted, it will be automatically derived from the textColor
     *   attribute of Hilite.cssText. When a hilite is saved in a HiliteEditor, both
     *   attributes are set automatically.
     *  @type {string}
     *  @default null
     */
    open var textColor: String = definedExternally
    /**
     *  When edited via a HiliteEditor, the value for the background color of this
     *   hilite. If this is omitted, it will be automatically derived from the backgroundColor
     *   attribute of Hilite.cssText. When a hilite is saved in a HiliteEditor, both
     *   attributes are set automatically.
     *  @type {string}
     *  @default null
     */
    open var backgroundColor: String = definedExternally
    /**
     *  URL of an icon to show when this hilite is applied to a cell. Position of the icon
     *   is controlled by DataBoundComponent.hiliteIconPosition or
     *   ListGridField.hiliteIconPosition.
     *  @type {SCImgURL}
     *  @default null
     */
    open var icon: String = definedExternally
    /**
     *  HTML which replaces the cell's textual value where this hilite is applied.
     * 
     *   Note that sorting, filtering, etc behavior will still operate on the underlying value.
     *   For example, if there is a date field with the FilterEditor enabled, the default search
     *   interface will still offer date-range based filtering even if hilites have caused values
     *   to be displayed as text such as "current" or "past due".
     *  @type {HTMLString}
     *  @default null
     */
    open var replacementValue: String = definedExternally
}