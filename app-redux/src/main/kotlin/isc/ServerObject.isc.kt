@file:JsQualifier("isc")
package isc

/**
 *  The ServerObject tells the ISC server how to find or create a server-side object involved in
 *   dmiOverview (Direct Method Invocation).
 * 
 *   A ServerObject declaration appears in the XML definition of a DataSource (for
 *   responding to DSRequests) or in an Application configuration file (.app.xml) for
 *   responding to RPCRequests.
 * 
 *   NOTE: Please take note of the points made in
 *   serverDataSourceImplementation of caching and thread-safety
 *   issues in server-side DataSources.
 */
open external class ServerObject {
    /**
     *  Specifies the mechanism for locating the class instance on which to invoke the method.
     *   Valid values are as follows:
     * 
     * 
     *  - "spring": For use with the Spring framework.
     *   ServerObject.bean contains the name of the bean to invoke. Which application context
     *   is used can be configured via web.xml (see the example web.xml in the SDK). See also
     *   serverInit for special concerns with framework initialization when using
     *   Spring.
     * 
     *  - "cdi": For use with
     *   CDI (Contexts and Dependency Injection).
     *   Use ServerObject.bean to configure the name of the
     *   bean to invoke or, alternatively, ServerObject.className to configure its class name.
     * 
     *  - "new": A new instance of the class specified by ServerObject.className will be
     *   created and the DMI method will be invoked on that instance (unless the specified method is
     *   static, in which case no instance is created, but the class specified by
     *   ServerObject.className is still used).
     * 
     *  - "factory": A custom factory provides the class instance on which the DMI method is to be
     *   invoked. In this case, ServerObject.className specifies the className of the factory
     *   that will provide the instance on which the DMI method is to be invoked. The class
     *   specified by ServerObject.className must provide exactly one method named
     *   create that must return the class instance on which you wish the DMI method to
     *   be invoked. Like the DMI methods, the create method can request a standard set of
     *   values as arguments. See dmiOverview for a list of available values.
     * 
     *  - "attribute": The instance on which the DMI method is to be invoked is looked up in the
     *   scope defined by ServerObject.attributeScope via the attribute name specified in
     *   ServerObject.attributeName.
     * 
     *  @type {"new" | "factory" | "attribute" | "spring" | "cdi"}
     *  @default "new"
     */
    open var lookupStyle: String /* new |  factory |  attribute |  spring |  cdi */ = definedExternally
    /**
     *  Specifies the fully-qualified class name that provides the server-side endpoint of the DMI
     *   (ServerObject.lookupStyle:"new") or the class name of the factory that produces the
     *   DMI instance (ServerObject.lookupStyle:"factory").
     * 
     *   This is one of the values that you need to pass to DMI.call to invoke the DMI from
     *   the client.
     * 
     *   The value of this attribute is used for "new" and "factory"
     *   values of ServerObject.lookupStyle.
     * 
     *   It is also used for "cdi" value of ServerObject.lookupStyle, to provide
     *   class name of the bean to ask CDI to create.
     *  @type {string}
     *  @default null
     */
    open var className: String = definedExternally
    /**
     *  Specifies the name of the method to call for operations using this ServerObject. This is
     *   a DataSource-level default; you can override it for individual operations either by
     *   specifying the OperationBinding.serverMethod attribute, or by declaring an
     *   operation-level serverObject that specifies a different methodName (if you specify both
     *   an operationBinding.serverMethod and an operation-level serverObject.methodName, the
     *   latter takes precedence)
     *  @type {string}
     *  @default null
     */
    open var methodName: String = definedExternally
    /**
     *  You can optionally specify an ID on the ServerObject config block - in which case you can
     *   use that value as the "className" argument when calling DMI.call. This allows you to
     *   hide the name of the server-side class used as the factory or implementer of the DMI from
     *   the browser as a security precaution.
     *  @type {string}
     *  @default null
     */
    open var ID: String = definedExternally
    /**
     *  For use when ServerObject.lookupStyle is "spring" or "cdi",
     *   id (name) of the bean to ask Spring (CDI) to create.
     *  @type {string}
     *  @default null
     */
    open var bean: String = definedExternally
    /**
     *  Specifies the name of the attribute by which to look up the DMI instance. This attribute is
     *   consulted only when the value of ServerObject.lookupStyle is "attribute".
     *  @type {string}
     *  @default null
     */
    open var attributeName: String = definedExternally
    /**
     *  Specifies the scope in which the DMI instance is to be looked up. Valid values are:
     *   "request", "session", and "application". If
     *   attributeScope is left out of the ServerObject definition, then
     *   all scopes are searched in the order in which they are listed above.
     * 
     *   This attribute is consulted only when the value of ServerObject.lookupStyle is
     *   "attribute".
     *  @type {"request" | "session" | "application"}
     *  @default null
     */
    open var attributeScope: String /* request |  session |  application */ = definedExternally
    /**
     *  When the ServerObject appears in a .app.xml file (for RPC DMI), this property
     *   specifies the list of methods on the ServerObject that are callable from the client. See
     *   the builtin.app.xml file in the /shared/app directory of the SDK for an example of a
     *   visibleMethods declaration block.
     *  @type {List}
     *  @default null
     */
    open var visibleMethods: List = definedExternally
    /**
     *  By default, for DMI DSResponses, DSResponse.data is filtered on the server to just the set
     *   of fields defined on the DataSource. This behavior can be overridden in several ways - see
     *   the overview in dmiOverview for details. The value of this attribute overrides
     *   DataSource.dropExtraFields.
     *  @type {boolean}
     *  @default null
     */
    open var dropExtraFields: Boolean = definedExternally
    /**
     *  If set, the SmartClient server will use JXPath to call your server code. The
     *   JXPathContext (start point) will be the object arrived at by applying the
     *   ServerObject.lookupStyle and related ServerObject properties. The
     *   intention of this property is to allow easier access to your existing Java objects
     *   and reduce the need to write SmartClient-specific server code.
     *  @type {string}
     *  @default null
     */
    open var targetXPath: String = definedExternally
    /**
     *  For a ServerObject defined at the DataSource.serverObject, by
     *   default we only allow it to intercept standard CRUD operations (ie, ordinary fetches, adds,
     *   updates and removes). To allow the ServerObject to intercept other types of operation -
     *   custom operations, validations, etc - set this property to false. Note that ServerObjects
     *   declared at the OperationBinding.serverObject always intercept
     *   that operation, whatever its type, and this property has no effect.
     * 
     *   NOTE: If you are intercepting operations on the server because you wish to inspect
     *   them before deciding whether to process them with bespoke code or allow them to proceed
     *   with normal processing, the way to invoke normal processing without causing any interference
     *   is:
     *    return dsRequest.execute();
     * 
     *  @type {boolean}
     *  @default null
     */
    open var crudOnly: Boolean = definedExternally
}