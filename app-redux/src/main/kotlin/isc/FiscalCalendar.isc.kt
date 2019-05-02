@file:JsQualifier("isc")
package isc

/**
 *  An object representing the start date for fiscal years in the current locale.
 * 
 *   A fiscal year spans a configurable date range - it may not exactly
 *   match a calendar year in length and it can start on any date within the calendar year
 *   and potentially end in the next calendar year.
 * 
 *   Developers may specify explicit fiscal year start dates by adding FiscalYear
 *   objects to the FiscalCalendar.fiscalYears.
 *   If none are provided, or if there is no entry for the given year, one is
 *   manufactured based on the default FiscalCalendar.defaultMonth
 *   and FiscalCalendar.defaultDate.
 */
open external class FiscalCalendar {
    /**
     *  The default zero-based month-number to use for calculating fiscal dates when no
     *   FiscalCalendar.fiscalYears are provided. This value together
     *   with FiscalCalendar.defaultDate will be used as the start date for the
     *   fiscal years where no explicitly specified fiscalYear configuration is present.
     * 
     *   See also FiscalCalendar.defaultYearMode.
     *  @type {Integer}
     *  @default null
     */
    open var defaultMonth: Number = definedExternally
    /**
     *  The default one-based day-number in the FiscalCalendar.defaultMonth
     *   to use for calculating fiscal dates when no FiscalCalendar.fiscalYears
     *   are provided. This value together
     *   with FiscalCalendar.defaultMonth will be used as the start date for the
     *   fiscal years where no explicitly specified fiscalYear configuration is present.
     * 
     *   See also FiscalCalendar.defaultYearMode.
     *  @type {Integer}
     *  @default null
     */
    open var defaultDate: Number = definedExternally
    /**
     *  This attribute controls how the displayed fiscalYear value should be calculated for
     *   dates falling within a period not explicitly listed in the
     *   FiscalCalendar.fiscalYears.
     * 
     *   The FiscalCalendar.defaultMonth and FiscalCalendar.defaultDate will be
     *   used to calculate the start of the fiscal year period. The defaultYearMode
     *   determines whether the reported fiscalYear for this period matches the year in which
     *   the period starts or the year in which it ends (so whether a fiscal year spanning
     *   dates within both 2020 and 2021 is reported as fiscalYear 2020 or 2021).
     *  @type {FiscalYearMode}
     *  @default "end"
     */
    open var defaultYearMode: 
                              /**
                               *  The fiscalYear value for the date range will match the calendar year in which the period ends. For example if the defaultDate and defaultMonth were set
                               *   to represent April 1st, the fiscal year starting on April 1st 2020 would end on
                               *   April 1st 2021. Setting the fiscalYearMode to end would mean the
                               *   fiscalYear value for this block would be 2021.
                               *  The fiscalYear value for the date range will match the calendar year in which the period starts. For example if the defaultDate and defaultMonth were set
                               *   to represent April 1st, the fiscal year starting on April 1st 2020 would end on
                               *   April 1st 2021. Setting the fiscalYearMode to start would mean the
                               *   fiscalYear value for this block would be 2020.
                               */
                              String /* end |  start */ = definedExternally
    /**
     *  An array of FiscalYear which each represent the start date of a
     *   single fiscal year.
     *  @type {Array<Partial<FiscalYear>>}
     *  @default null
     */
    open var fiscalYears: Array<dynamic> = definedExternally
}