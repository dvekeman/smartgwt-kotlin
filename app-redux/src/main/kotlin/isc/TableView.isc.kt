@file:JsQualifier("isc")
package isc

/**
 *  Shows a listing of records with one or more fields from each record, with
 *   built-in support for navigation and editing of lists of records.
 * 
 *   The TableView provides built-in controls such as TableView.showNavigation and
 *   shows fields from the provided records in one of several built-in RecordLayouts.
 * 
 *   NOTE: This widget is intended primarily for creating handset/phone-sized interfaces
 *   and does not have an appearance in any skin other than Mobile.
 */
open external class TableView : ListGrid {
    /**
     *  This property allows the developer to specify the icon displayed next to a record.
     *   Set record[tableView.iconField] to the URL of the desired icon to display.
     *   Only applies if TableView.showIconField is true.
     *  @type {string}
     *  @default "icon"
     */
    override var iconField: String = definedExternally
    /**
     *  Should an icon field be shown for each record? A column in the table is set
     *   aside for an icon as specified on each record in the TableView.iconField.
     *  @type {boolean}
     *  @default true
     */
    open var showIconField: Boolean = definedExternally
    /**
     *  Field to display for an individual record as the main title.
     *  @type {string}
     *  @default "title"
     */
    override var titleField: String = definedExternally
    /**
     *  Field to display as part of individual record in "summary" RecordLayouts.
     *  @type {string}
     *  @default "info"
     */
    override var infoField: String = definedExternally
    /**
     *  Field to display as part of individual record in "summary" RecordLayouts.
     *  @type {string}
     *  @default "data"
     */
    override var dataField: String = definedExternally
    /**
     *  Field to display as part of individual record in all RecordLayouts
     *   except "titleOnly".
     *  @type {string}
     *  @default "description"
     */
    override var descriptionField: String = definedExternally
    /**
     *  Boolean property on each record that controls whether navigation controls are shown for
     *   that record. If property is not defined on the record a navigation icon is shown
     *   if TableView.showNavigation is true.
     *  @type {string}
     *  @default "_navigate"
     */
    open var recordNavigationProperty: String = definedExternally
    /**
     *  The display mode of the table.
     *  @type {TableMode}
     *  @default "plain"
     */
    open var tableMode: 
                        /**
                         *  The default mode which displays a list of rows
                         *  Grouped table is a set of rows embedded in a rounded                rectangle
                         */
                        String /* plain |  grouped */ = definedExternally
    /**
     *  Sets the arrangement of data fields from the record.
     * 
     *   Note that controls supported by the TableView itself, such as navigation icons, are
     *   implicitly added to the data fields described in the RecordLayout. If an
     *   TableView.iconField has been configured, it too is an implicitly shown field, to the left
     *   of the area controlled by RecordLayout.
     *  @type {RecordLayout}
     *  @default "titleOnly"
     */
    open var recordLayout: 
                           /**
                            *  Show TableView.titleField only
                            *  Show TableView.titleField and                   TableView.descriptionField
                            *                     fields only
                            *  Show TableView.titleField,                    TableView.descriptionField and
                            *                     TableView.infoField fields only
                            *  Show TableView.titleField,                    TableView.descriptionField and
                            *                     TableView.dataField fields only
                            *  Show TableView.titleField,                    TableView.descriptionField,
                            *                     TableView.infoField and
                            *                     TableView.dataField fields similar to
                            *                     the iPhoneOS Mail application
                            */
                           String /* titleOnly |  titleAndDescription |  summaryInfo |  summaryData |  summaryFull */ = definedExternally
    /**
     *  The navigation icon shown next to records when
     *   TableView.showNavigation is true and NavigationMode is set to
     *   "navIconOny".
     *  @type {SCImgURL}
     *  @default "[SKINIMG]/iOS/listArrow_button.png"
     */
    open var navIcon: String = definedExternally
    /**
     *  The navigation icon shown next to records when TableView.showNavigation
     *   is true and NavigationMode is set to "wholeRecord".
     *  @type {SCImgURL}
     *  @default "[SKINIMG]/iOS/listArrow.png"
     */
    open var wholeRecordNavIcon: String = definedExternally
    /**
     *  Whether to show navigation controls by default on all records. Can also be configured
     *   per-record with TableView.recordNavigationProperty.
     *  @type {boolean}
     *  @default null
     */
    open var showNavigation: Boolean = definedExternally
    /**
     *  Set navigation mode for this TableView.
     *  @type {NavigationMode}
     *  @default "wholeRecord"
     */
    open var navigationMode: 
                             /**
                              *  Clicking anywhere on the record navigates
                              *  Only clicking directly on the navigation icon                  triggers navigation
                              */
                             String /* wholeRecord |  navIconOnly */ = definedExternally
    /**
     *  Default style for title.
     *  @type {CSSStyleName}
     *  @default "recordTitle"
     */
    open var recordTitleStyle: String = definedExternally
    /**
     *  Default style for description.
     *  @type {CSSStyleName}
     *  @default "recordDescription"
     */
    open var recordDescriptionStyle: String = definedExternally
    /**
     *  Default style for data field.
     *  @type {CSSStyleName}
     *  @default "recordData"
     */
    open var recordDataStyle: String = definedExternally
    /**
     *  Default style for info field.
     *  @type {CSSStyleName}
     *  @default "recordInfo"
     */
    open var recordInfoStyle: String = definedExternally
    /**
     *   Executed when the user clicks on a record, or on the navigate icon for a
     *   record depending on NavigationMode.
     * 
     * 
     *  @param {ListGridRecord} record clicked
     */
    open fun recordNavigationClick(record: ListGridRecord): Unit = definedExternally
    /**
     *   Executed when the user clicks on the image displayed in a record if
     *   TableView.iconField has been specified.
     * 
     * 
     *  @param {ListGridRecord} record clicked
     */
    open fun imageClick(record: ListGridRecord): Unit = definedExternally
    /**
     *   Formatter to apply to record display.
     * 
     * 
     *  @param {ListGridRecord} record to format
     */
    open fun formatRecord(record: ListGridRecord): String = definedExternally
    companion object {
        /**
         *  A declared value of the enum type
         *   TableMode.
         *  @type {Constant}
         *  @default "plain"
         */
        var PLAIN: String = definedExternally
        /**
         *  A declared value of the enum type
         *   TableMode.
         *  @type {Constant}
         *  @default "grouped"
         */
        var GROUPED: String = definedExternally
        /**
         *  A declared value of the enum type
         *   RecordLayout.
         *  @type {Constant}
         *  @default "titleOnly"
         */
        var TITLE_ONLY: String = definedExternally
        /**
         *  A declared value of the enum type
         *   RecordLayout.
         *  @type {Constant}
         *  @default "titleAndDescription"
         */
        var TITLE_DESCRIPTION: String = definedExternally
        /**
         *  A declared value of the enum type
         *   RecordLayout.
         *  @type {Constant}
         *  @default "summaryInfo"
         */
        var SUMMARY_INFO: String = definedExternally
        /**
         *  A declared value of the enum type
         *   RecordLayout.
         *  @type {Constant}
         *  @default "summaryData"
         */
        var SUMMARY_DATA: String = definedExternally
        /**
         *  A declared value of the enum type
         *   RecordLayout.
         *  @type {Constant}
         *  @default "summaryFull"
         */
        var SUMMARY_FULL: String = definedExternally
        /**
         *  A declared value of the enum type
         *   NavigationMode.
         *  @type {Constant}
         *  @default "wholeRecord"
         */
        var WHOLE_RECORD: String = definedExternally
        /**
         *  A declared value of the enum type
         *   NavigationMode.
         *  @type {Constant}
         *  @default "navIconOnly"
         */
        var NAVICON_ONLY: String = definedExternally
        /**
         *  Creates a new TableView
         * 
         *  @param typeCheckedProperties {Partial<TableView>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {TableView} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): TableView = definedExternally
    }
}