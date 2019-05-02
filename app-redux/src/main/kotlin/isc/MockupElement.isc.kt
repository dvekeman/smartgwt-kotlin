@file:JsQualifier("isc")
package isc

/**
 *  MockupElements are produced by the balsamiqImport as
 *   placeholders for Balsamiq controls that cannot be meaningfully translated to SmartClient
 *   controls (such as the big red X markup control).
 * 
 *   MockupElement is just an instance of Img that uses .png files stored in the
 *   tools/visualBuilder/mockups folder.
 * 
 *   MockupElement is not intended to be included in any final applications.
 */
open external class MockupElement : Img {
    companion object {
        /**
         *  Creates a new MockupElement
         * 
         *  @param typeCheckedProperties {Partial<MockupElement>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {MockupElement} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): MockupElement = definedExternally
    }
}