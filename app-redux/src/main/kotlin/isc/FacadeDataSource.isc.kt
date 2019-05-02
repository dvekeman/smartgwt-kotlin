@file:JsQualifier("isc")
package isc

/**
 *  Extends an arbitrary DataSource with the ability to queue requests made on it and
 *   dispatch the queued requests on demand. To use, create a FacadeDataSource instance with
 *   the DataSource.inheritsFrom property set to the DataSource that you wish
 *   to extend.
 * 
 *   This advanced class is intended to be used for testing data-bound components. This should
 *   not be used in production code.
 * 
 *   See also the overview of the dsFacade.
 */
open external class FacadeDataSource : DataSource {
    /**
     *  Should requests be queued?
     * 
     *   When DS requests are made on the FacadeDataSource, a new, derived DS request on the underlying
     *   DataSource.inheritsFrom DataSource is created. If queueRequests is true,
     *   then the derived DS request is added to the FacadeDataSource.queuedRequests
     *   array. If false, then the derived DS request is DataSource.execute
     *   immediately on the inherited DataSource.
     *  @type {boolean}
     *  @default false
     */
    open var queueRequests: Boolean = definedExternally
    /**
     *  An array of derived DS requests that are queued to be DataSource.execute on the
     *   underlying DataSource.inheritsFrom DataSource.
     * 
     *   When a DS request is made on this FacadeDataSource, if FacadeDataSource.queueRequests
     *   is true, then a new DS request is created based on the given DS request and added to this
     *   queue.
     * 
     *   To clear the queue, set FacadeDataSource.queueRequests to false
     *   or call FacadeDataSource.clearQueue.
     *  @type {Array<Partial<DSRequest>>}
     *  @default null
     */
    open var queuedRequests: Array<dynamic> = definedExternally
    /**
     *   Setter for FacadeDataSource.queueRequests.
     * 
     * \* @param {boolean} 
     */
    open fun setQueueRequests(queueRequests: Boolean): Unit = definedExternally
    /**
     *   Shorthand to clear the FacadeDataSource.queuedRequests without
     *   changing the value of FacadeDataSource.queueRequests.
     * 
     */
    open fun clearQueue(): Unit = definedExternally
    companion object {
        /**
         *  Creates a new FacadeDataSource
         * 
         *  @param typeCheckedProperties {Partial<FacadeDataSource>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {FacadeDataSource} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): FacadeDataSource = definedExternally
    }
}