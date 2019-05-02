@file:JsQualifier("isc")
package isc

/**
 *  A record which specifies files for use with fileSource.
 */
open external class FileSpec {
    /**
     *  The name of the file, without any extension to indicate FileSpec.fileType or
     *   FileSpec.fileFormat.
     *  @type {string}
     *  @default null
     */
    open var fileName: String = definedExternally
    /**
     *  The type of the file, e.g. "ds" for datasource, or "proj" for project.
     *  @type {string}
     *  @default null
     */
    open var fileType: String = definedExternally
    /**
     *  The format of the file, e.g. "xml" or "js"
     *  @type {string}
     *  @default null
     */
    open var fileFormat: String = definedExternally
}