@file:JsQualifier("isc")
package isc

/**
 *  An object representing the start of a given Fiscal Year in the current locale.
 * 
 *   See FiscalCalendar for more information on how FiscalYears are set up and used.
 */
open external class FiscalYear {
    /**
     *  The actual fiscal year that this date relates to.
     * 
     *   A fiscal year ends when the next one begins. A fiscal year may span the boundary
     *   between two calendar years in which case the FiscalYear.fiscalYear value may
     *   not match the FiscalYear.year value.
     * 
     *   For example fiscalYear 2020 may start in July of 2019 and end in July of 2020. In this
     *   case the fiscalYear would be set to 2020 and the
     *   FiscalYear.year would be set to 2019
     *  @type {Integer}
     *  @default null
     */
    open var fiscalYear: Number = definedExternally
    /**
     *  The 4-digit calendar year when this fiscal year starts.
     *  @type {Integer}
     *  @default null
     */
    open var year: Number = definedExternally
    /**
     *  The zero-based month-number when this fiscal year starts.
     *  @type {Integer}
     *  @default null
     */
    open var month: Number = definedExternally
    /**
     *  The one-based day-number in the FiscalYear.month when this fiscal
     *   year starts.
     *  @type {Integer}
     *  @default null
     */
    open var date: Number = definedExternally
}