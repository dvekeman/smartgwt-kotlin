@file:JsQualifier("isc")
package isc

/**
 *  The Class object is root of the Isomorphic SmartClient inheritance tree -- it includes
 *   functionality for creating instances, adding methods and properties, getting prototypes,
 *   etc.
 * 
 *   To add functionality to ALL classes, add them to Class.
 * 
 *   To create a Class, call ClassFactory.defineClass("MyClass", "MySuperClass")
 * 
 *   defineClass will return the created class, and make it available as
 *   isc.MyClass, and as the global variable MyClass if not in
 *   isc.
 * 
 *   You can then:
 * 
 * 
 *  - add class-level (static) properties and methods to the class:
 *    MyClass.addClassProperties()
 *     these methods and properties are accessed through the Class variable itself, eg:
 *    MyClass.someStaticMethod() or MyClass.someStaticProperty
 * 
 * 
 *  - add default instance properties and methods to the class:
 *    MyClass.addProperties()
 *     these methods and properties are accessed through a class instance, eg:
 *    var myInstance = MyClass.create();
 *    myInstance.someInstanceMethod()
 * 
 * 
 *  - create new instances of this class:
 *    var myInstance = MyClass.create()
 * 
 *   NOTE: as a convention, all class names begin with a capital letter and all instances begin
 *   with a lower case letter.
 */
open external class Class {
    /**
     *  Controls whether arguments passed to Class.create are assumed to be
     *   Objects containing properties that should be added to the newly created instance. This
     *   behavior is how create() works with almost all SmartClient widgets and
     *   other components, allowing the convenient shorthand of setting a batch of properties via
     *   an ObjectLiteral passed to create().
     * 
     *   The setting defaults to true if unset. To disable this behavior for a custom class,
     *   such that create() works more like typical constructors found in Java and
     *   other languages, use:
     * 
     *     isc.[i]ClassName[/i].addProperties({ addPropertiesOnCreate:false })
     * 
     * 
     *   Note that it is not valid to disable this behavior for any subclass of Canvas
     *   (Canvas relies on this property).
     * 
     *   Regardless of the setting for addPropertiesOnCreate, all arguments passed to
     *   Class.create are still passed on to Class.init.
     *  @type {boolean}
     *  @default undefined
     */
    open var addPropertiesOnCreate: Boolean = definedExternally
    /**
     *  Canvas.ID of the component that manages "rule context" for which
     *   this class participates. A non-Canvas class can only use the ruleScope
     *   for supporting Class.dynamicProperties. Unlike Canvas.ruleScope
     *   ruleScope on a standalone class must be explicitly specified.
     *  @type {string}
     *  @default null
     */
    open var ruleScope: String = definedExternally
    /**
     *  Object mapping dynamic property names to the source - a DataPath,
     *   UserSummary or UserFormula. This is a declarative
     *   alternative to calling Class.addDynamicProperty for each property.
     * 
     *   See Class.addDynamicProperty for details on using dynamic properties.
     * 
     * 
     *   In JavaScript dynamicProperties can be declaratively initialized as follows:
     * 
     *   dynamicProperties: {
     *     propName1 : "a/b/c",
     *     propName2 : { formula: .. formula definition .. }
     *     propName3 : { textFormula: .. summary definition .. }
     *   }
     * 
     * 
     * 
     *   In ComponentXML dynamicProperties can be intialized as:
     * 
     *   &lt;dynamicProperties&gt;
     *     &lt;property name="propName" dataPath="a/b/c"/&gt;
     *     &lt;property name="propName2"&gt;
     *       &lt;formula&gt;
     *         &lt;UserFormula ... &gt;
     *       &lt;/formula&gt;
     *     &lt;/property&gt;
     *     &lt;property name="propName3"&gt;
     *       &lt;textFormula&gt;
     *         &lt;UserSummary ... &gt;
     *       &lt;/textFormula&gt;
     *     &lt;/property&gt;
     *   &lt;/dynamicProperties&gt;
     * 
     *  @type {Map<any>}
     *  @default null
     */
    open var dynamicProperties: Map<dynamic> = definedExternally
    /**
     * 
     *   Initialize a new instance of this Class. This method is called automatically by
     *   Class.create.
     * 
     *   Override this method to provide initialization logic for your class. If your class is
     *   a subclass of a UI component (i.e. descendant of Canvas), override
     *   Canvas.initWidget instead.
     * 
     * 
     *  @param {any=} All arguments initially passed to Class.create
     */
    open fun init(vararg args: Any): Unit = definedExternally
    /**
     *   Permanently destroy a class instance and any automatically created resources,
     *   recursively.
     * 
     */
    open fun destroy(): Unit = definedExternally
    /**
     *     Return the global identifier for this object.
     * 
     * 
     */
    open fun getID(): String = definedExternally
    /**
     * 
     *   Gets a pointer to the class object for this instance
     * 
     * 
     */
    open fun getClass(): Class = definedExternally
    /**
     * 
     *   Gets a pointer to the class object for this instance's superclass.
     * 
     * 
     */
    open fun getSuperClass(): Class = definedExternally
    /**
     * 
     *   Gets the name of this class as a string.
     * 
     * 
     */
    open fun getClassName(): String = definedExternally
    /**
     * 
     *   Add properties or methods to this specific instance.
     *   Properties with the same name as existing properties will override.
     * 
     * 
     *  @param {object=} Object containing name:value pairs to be added to this object
     */
    open fun addProperties(vararg args: Any): dynamic = definedExternally
    /**
     * 
     *   Add properties to this instance.
     * 
     * 
     *  @param {Array<Partial<object>>} array of objects with properties to add
     */
    open fun addPropertyList(list: Array<dynamic>): dynamic = definedExternally
    /**
     *   Set a property on this object, calling the setter method if it exists.
     * 
     *   Whenever you set a property on an ISC component, you should call either the specific setter
     *   for that property, or setProperty()/setProperties() if it doesn't have one.
     *   This future-proofs your code against the later addition of required setters.
     * 
     * 
     *  @param {string} name of the property to set
     *  @param {any} new value for the property
     */
    open fun setProperty(propertyName: String, newValue: dynamic): Unit = definedExternally
    /**
     *   Set multiple properties on an object, calling the appropriate setter methods if any are
     *   found.
     * 
     *   Whenever you set a property on an ISC component, you should call either the specific setter
     *   for that property, or setProperty()/setProperties() if it doesn't have one.
     *   This future-proofs your code against the later addition of required setters.
     * 
     *   With setProperties() in particular, some classes may be able to take shortcuts
     *   and be more efficient when 2 or more related properties are set at the same time.
     * 
     * 
     *  @param {object=} objects with properties to add (think named parameters).     all the properties of each argument will be applied one      after another so later properties will override
     */
    open fun setProperties(vararg args: Any): Unit = definedExternally
    /**
     * 
     *   Returns whether this object is of a particular class by class name, either as a direct
     *   instance of that class or as subclass of that class, or by implementing an interface
     *   that has been mixed into the class.
     * 
     *   NOTE: this only applies to ISC's class system, eg: myInstance.isA("Object") will be
     *   false.
     * 
     * 
     *  @param {string} Class name to test against
     */
    open fun isA(className: String): Boolean = definedExternally
    /**
     *   Take an arbitrary action whenever a method is called on an instance.
     * 
     *   When you observe some method of another object, eg:
     *     thisObject.observe(thatObject, "someMethod", "observer.foo()")
     * 
     *   When thatObject.someMethod() is called,
     *     thisObject.foo()
     *   will be called automatically, after the observed method completes.
     * 
     *   Action is typically a string expression. Available variables:
     * 
     * 
     *  - observed: target of the observation, that is, object passed to observe()
     * 
     *  - observer: object that observes, that is, object that observe() was called on
     * 
     *  - returnVal: return value of observed function
     * 
     * 
     *   An unlimited number of observers can observe any message, they will all be notified
     *   automatically in the order that the observations were set up.
     * 
     *   NOTES:
     *   - observation also works on JavaScript Array objects
     *   - a method may trigger an observation of itself by another object, either through code
     *    within the method itself or within an observer's action. In this case the observation
     *    will be set up, but the new observation action will not fire as part of this thread.
     *    When the method is called again in the future the newly added observer will be fired.
     * 
     * 
     * 
     *  @param {object} object to observe
     *  @param {string} name of the method to observe
     *  @param {string=} String for the function to call.     In this string,        observer is the object that is observing,        this is the object that is being observed      If action is not specified,        observer.methodName() will be called.
     */
    open fun observe(`object`: dynamic, methodName: String, action: String?): Boolean = definedExternally
    /**
     *   Stop observing a method on some other object.
     * 
     * 
     *  @param {object} object to observe
     *  @param {string} name of the method to ignore
     */
    open fun ignore(`object`: dynamic, methodName: String): Boolean = definedExternally
    /**
     *  @param {object} object we may be observing
     *  @param {string} name of the method to observed
     */
    open fun isObserving(`object`: dynamic, methodName: String): Boolean = definedExternally
    /**
     * 
     *   Evaluate a string of script in the scope of this instance (so this
     *   is available as a pointer to the instance).
     * 
     * 
     *  @param {string} the expression to be evaluated
     *  @param {object} Optional mapping of argument names to values - each key will   be available as a local variable when the script is executed.
     */
    open fun evaluate(expression: String, evalArgs: dynamic): dynamic = definedExternally
    /**
     * 
     *   Method to fire a callback. Callback will be fired in the scope of the object on
     *   which this method is called.
     *   Falls through to Class.fireCallback
     * 
     * 
     *  @param {Callback} Callback to fire
     *  @param {string=} comma separated string of variables
     *  @param {Array<any>=} array of arguments to pass to the method
     */
    open fun fireCallback(callback: dynamic, argNames: String?, args: Array<dynamic>?): dynamic = definedExternally
    /**
     *   This is a helper to delay a call to some method on this object by some specified
     *   amount of time.
     * 
     *  @param {string} name of the method to call
     *  @param {Array<any>=} array of arguments to pass to the method in question
     *  @param {number=} Number of ms to delay the call by - defaults to zero (so just pulls            execution of the method out of the current execution thread.
     */
    open fun delayCall(methodName: String, arrayArgs: Array<dynamic>?, time: Number?): String = definedExternally
    /**
     *   Creates a component according to the "AutoChild" pattern, and adds it to this component.
     * 
     *   See the autoChildren to understand the general
     *   purpose and usage of this method.
     * 
     *   addAutoChild() takes the following actions:
     * 
     * 
     *  - checks whether this.autoChildName is already populated, and returns it if so
     * 
     *  - checks when there is a showAutoChildName with the value false, and if so
     *   returns without creating a component
     * 
     *  - calls Class.createAutoChild to create the component
     * 
     *  - sets this.autoChildName to the created component
     * 
     *  - adds the component either to this component, or to some other parent, specified
     *   by the "autoParent" property in the autoChild's defaults. The "autoParent" property may
     *   be "none" indicating the autoChild should not be automatically added.
     * 
     * 
     *   When adding an autoChild to a Layout subclass,
     *   Layout.addMember will be called instead of the normal
     *   Canvas.addChild. To prevent this behavior,
     *   addAsChild:true can be set in the autoChild defaults. Similarly,
     *   addAsPeer:true may be set to add an autoChild as a peer.
     * 
     *   Tip: because addAutoChild()
     *   checks specifically for showAutoChildName:false, you do not have to add
     *   showAutoChildName:true in order for an autoChild to be shown by default; leaving
     *   the property undefined is sufficient.
     * 
     *   Note that by default the child created by this method will be destroyed when
     *   Canvas.destroy is called on this instance. To disable this behavior,
     *   set dontAutoDestroy to true on the auto child.
     * 
     * 
     *  @param {string} name of the autoChild
     *  @param {Properties} dynamic properties for the autoChild
     */
    open fun addAutoChild(childName: String, defaults: dynamic): Class = definedExternally
    /**
     *   Unconditionally creates and returns a component created according to the "AutoChild"
     *   pattern.
     * 
     *   In addition to applying defaults and properties as described under the
     *   autoChildUsage, the created autoChild:
     * 
     * 
     *  - is automatically autoDraw:false
     * 
     *  - has a creator property that points to this component, for easy
     *   authoring of event handlers (eg click:"this.creator.doSomething()")
     * 
     * 
     *   Unlike Class.addAutoChild, createAutoChild() does not create a
     *   this.autoChildName reference to the component, check a showAutoChildName
     *   flag, or automatically add the autoChild via Canvas.addChild.
     * 
     *   General you use createAutoChild rather than addAutoChild when:
     * 
     * 
     *  - you are going to create several autoChildren with a common set of defaults (for
     *   example the ColumnTree.column autoChild of the ColumnTree).
     * 
     *  - children need to be created before their parents (eg, for layout/auto-sizing
     *   reasons)
     * 
     * 
     *   Note that by default the child created by this method will be destroyed when
     *   Canvas.destroy is called on this instance. To disable this behavior,
     *   set dontAutoDestroy to true on the auto child.
     * 
     * 
     *  @param {string} name of the autoChild
     *  @param {Properties} dynamic properties for the autoChild
     */
    open fun createAutoChild(childName: String, defaults: dynamic): Class = definedExternally
    /**
     * 
     *   Call method on each item in argsList and return the Array of results.
     * 
     * 
     *  @param {string} Name of the method on this instance which should be called on each element of the Array
     *  @param {Array<any>} Array of items to call the method on
     */
    open fun map(methodName: String, items: Array<dynamic>): Array<dynamic> = definedExternally
    /**
     *   Sets up the value of propertyName to be dynamically derived from the
     *   Canvas.ruleScope, by either a simple DataPath into the ruleScope or via a textual
     *   or numeric formula using the ruleScope as available formula inputs.
     * 
     *   The dataPath or formula is evaluated immediately when addDynamicProperty() is called, then re-evaluated
     *   every time the ruleScope changes.
     * 
     *   It is invalid usage to use addDynamicProperty() on a property that is not runtime settable,
     *   however, addDynamicProperty() will not throw an error or log a warning if this is done.
     * 
     *   If a property is already dynamic and addDynamicProperty() is called again, the new dynamic behavior
     *   replaces the old. If a property should no longer be dynamic, call Class.clearDynamicProperty.
     * 
     *   Dynamic properties can also be declared together via Class.dynamicProperties.
     * 
     * 
     *  @param {Identifier} name of a settable property on this instance
     * \* @param {DataPath | UserSummary | UserFormula} 
     */
    open fun addDynamicProperty(propertyName: String, source: dynamic): Unit = definedExternally
    /**
     *   Clears a dynamic property previously established via Class.addDynamicProperty.
     * 
     *   If the property is not currently dynamic, nothing will be done (and no warning logged).
     * 
     *   The current value of the property will not be changed by this call.
     * 
     * 
     *  @param {Identifier} property name of the dynamic property to clear
     */
    open fun clearDynamicProperty(propertyName: String): Unit = definedExternally
    /**
     *   Returns true if the property is dynamic.
     * 
     * 
     *  @param {Identifier} name of a settable property on this instance
     */
    open fun hasDynamicProperty(propertyName: String): Boolean = definedExternally
    /**
     * 
     *   The default toString() for instances reports that you have an instance of a class and prints
     *   the instance ID if present.
     * 
     */
//    open fun toString(): Unit = definedExternally
    /**
     *   Returns a one-line summary of the current method call, showing method name and passed
     *   arguments.
     *   This function is available as a static on every ISC Class and as an instance
     *   method on every instance of an ISC Class.
     *   General best practice is to call the method as "this.getCallTrace(arguments)" whenever "this" is an
     *   instance, or call the static classMethod on the Log class otherwise.
     * 
     *   Note the arguments object is required in most cases for this method to function. In some
     *   browsers, it can be derived automatically, but developers looking to debug on multiple platforms
     *   should not rely on this.
     * 
     * 
     *  @param {any=} arguments object from the call to trace. If ommitted, where supported,  arguments will be derived from the calling function, or if this is not supported, the method  will not function.
     */
    open fun getCallTrace(args: dynamic?): Unit = definedExternally
    /**
     *   Returns a "stack trace" - one line per method in the current call stack, showing the method
     *   name and any parameters passed.
     *   This function is available as a static on every ISC Class and as an instance
     *   method on every instance of an ISC Class.
     *   General best practice is to call the method as "this.getStackTrace" whenever "this" is an
     *   instance, or call the static classMethod on the Log class otherwise.
     * 
     *   Platform Notes: In Mozilla Firefox, if Firebug is enabled, a stack trace will be logged
     *   to the firebug console in addition to the standard stack trace string returned by
     *   this method.
     * 
     *   In browsers other than Internet Explorer a complete stack trace may not be available -
     *   this occurs when a function is re-entrant (meaning it calls itself). In this case the
     *   stack will terminate with text indicating where the recursive function call occurred.
     * 
     *   See debugging for further information information.
     * 
     * 
     */
    open fun getStackTrace(): String = definedExternally
    /**
     *   Return a very short (generally less than 40 characters) string representation of any object,
     *   suitable for viewing by a developer for debugging purposes.
     *   This function is available as a static on every ISC Class and as an instance
     *   method on every instance of an ISC Class.
     *   General best practice is to call the method as "this.echoLeaf" whenever "this" is an
     *   instance, or call the static classMethod on the Log class otherwise.
     * 
     * 
     *  @param {any} object to echo
     */
    open fun echoLeaf(obj: dynamic): String = definedExternally
    /**
     *   Return a short string representation of any object, suitable for viewing by a developer for
     *   debugging purposes.
     * 
     *   If passed an object containing other objects, echo will not recurse into subobjects,
     *   summarizing them instead via echoLeaf().
     * 
     *   NOTE: echo() is used to generate the output shown in the Log window when evaluating an
     *   expression.
     * 
     *   This function is available as a static on every ISC Class and as an instance
     *   method on every instance of an ISC Class.
     *   General best practice is to call the method as "this.echo()" whenever "this" is an
     *   instance, or call the static classMethod on the Log class otherwise.
     * 
     * 
     *  @param {any} object to echo
     */
    open fun echo(obj: dynamic): String = definedExternally
    /**
     *   Like echo(), except that if passed an Array, echoAll() will echo() every element of the
     *   Array.
     *   This function is available as a static on every ISC Class and as an instance
     *   method on every instance of an ISC Class.
     *   General best practice is to call the method as "this.echo()" whenever "this" is an
     *   instance, or call the static classMethod on the Log class otherwise.
     * 
     * 
     *  @param {any} object to echo
     */
    open fun echoAll(obj: dynamic): String = definedExternally
    /**
     *   Log a message at "debug" priority
     * 
     *   A method named logPriority exists for each priority level, on every ISC Class and
     *   instance of an ISC Class. Messages logged on a Class or instance have a default
     *   category of the classname. Messages logged on an instance will also automatically
     *   incorporate the instance ID. General best practice is to call logDebug() et al as
     *   "this.logDebug" whenever "this" is an instance, or as "Log.logDebug" otherwise.
     * 
     * 
     *  @param {string} message to log
     *  @param {string=} category to log in
     */
    open fun logDebug(message: String, category: String?): Unit = definedExternally
    /**
     *   Log a message at "info" priority
     * 
     * 
     *  @param {string} message to log
     *  @param {string=} category to log in
     */
    open fun logInfo(message: String, category: String?): Unit = definedExternally
    /**
     *   Log a message at "warn" priority
     * 
     * 
     *  @param {string} message to log
     *  @param {string=} category to log in
     */
    open fun logWarn(message: String, category: String?): Unit = definedExternally
    /**
     *   Log a message at "error" priority
     * 
     * 
     *  @param {string} message to log
     *  @param {string=} category to log in
     */
    open fun logError(message: String, category: String?): Unit = definedExternally
    /**
     *   Log a message at "fatal" priority
     * 
     * 
     *  @param {string} message to log
     *  @param {string=} category to log in
     */
    open fun logFatal(message: String, category: String?): Unit = definedExternally
    /**
     *   Check whether a message logged at the given priority would be visible in the log.
     * 
     *   As with logDebug, category is defaulted to the current className. Use this method to avoid
     *   putting together expensive log messages if they will never appear in the log.
     * 
     * 
     *  @param {LogPriority} priority level
     *  @param {string=} category to log in
     */
    open fun logIsEnabledFor(priority: 
                                       /**
                                        *  unrecoverable error
                                        */
                                       Number /* 1 */, category: String?): Unit = definedExternally
    /**
     *   Check whether a message logged at "debug" priority would be visible in the log.
     * 
     *   As with logDebug, category is defaulted to the current className. Use this method to avoid
     *   putting together expensive log messages if they will never appear in the log.
     * 
     * 
     *  @param {string=} category to log in
     */
    open fun logIsDebugEnabled(category: String?): Unit = definedExternally
    /**
     *   Check whether a message logged at "info" priority would be visible in the log.
     * 
     *   As with logDebug, category is defaulted to the current className. Use this method to avoid
     *   putting together expensive log messages if they will never appear in the log.
     * 
     * 
     *  @param {string=} category to log in
     */
    open fun logIsInfoEnabled(category: String?): Unit = definedExternally
    /**
     *   Check whether a message logged at "warn" priority would be visible in the log.
     * 
     *   As with logDebug, category is defaulted to the current className. Use this method to avoid
     *   putting together expensive log messages if they will never appear in the log.
     * 
     * 
     *  @param {string=} category to log in
     */
    open fun logIsWarnEnabled(category: String?): Unit = definedExternally
    /**
     *   Check whether a message logged at "error" priority would be visible in the log.
     * 
     *   As with logDebug, category is defaulted to the current className. Use this method to avoid
     *   putting together expensive log messages if they will never appear in the log.
     * 
     * 
     *  @param {string=} category to log in
     */
    open fun logIsErrorEnabled(category: String?): Unit = definedExternally
    /**
     *   Set the priority of messages that will be visible for some log category, when logged on
     *   this Class or Instance object.
     *   If called with no category, this priority will be applied to every logged message on this
     *   object
     *   To set the visible log priority for some category across the entire page, use
     *   isc.Log.setPriority() instead.
     * 
     *  @param {string} Category for which the log priority will be updated. If not             all logs on this canvas will be logged at the priority passed in.
     *  @param {LogPriority} priority level
     */
    open fun setLogPriority(category: String, priority: 
                                                        /**
                                                         *  unrecoverable error
                                                         */
                                                        Number /* 1 */): Unit = definedExternally
    /**
     *   Set the default priority of logging for messages logged on this Class or Instance object.
     *   All categories for which there is no explicit, instance level logging priority set will
     *   log at this level on this object.
     *   To set the default visible log priority across the entire page, use
     *   isc.Log.setDefaultPriority() instead.
     * 
     *  @param {string} Category for which the log priority will be updated. If not             all logs on this canvas will be logged at the priority passed in.
     *  @param {LogPriority} priority level
     */
    open fun setDefaultLogPriority(category: String, priority: 
                                                               /**
                                                                *  unrecoverable error
                                                                */
                                                               Number /* 1 */): Unit = definedExternally
    /**
     *   Retrieves the default priority of messages for this class or instance.
     * 
     */
    open fun getDefaultLogPriority(): 
                                      /**
                                       *  unrecoverable error
                                       */
                                      Number /* 1 */ = definedExternally
    /**
     *   Clear this object's priority setting for a particular category, so that the category's
     *   effective priority returns to the specified priority for this category at the Log level
     *   (or Log.defaultPriority if not set).
     *   To clear the Page-level priority setting for this log category use
     *   isc.Log.clearPriority() instead.
     * 
     * 
     *  @param {string} Category name. If not specified, all logging on this object               will revert to default priority settings.
     */
    open fun clearLogPriority(category: String): Unit = definedExternally
    companion object {
        /**
         *  Is this a core SmartClient class (part of the SmartClient framework)?
         *   This attribute may be used for debugging, and by the AutoTest subsystem to
         *   differentiate between SmartClient classes (part of the smartClient framework) and
         *   subclasses created by specific applications
         *  @type {boolean}
         *  @default "varies"
         */
        var isFrameworkClass: Boolean = definedExternally
        /**
         *  Creates a new Class
         * 
         *  @param typeCheckedProperties {Partial<Class>=} Object literal containing init properties that will be checked against the class field types.
         *  @param uncheckedProperties {Object} Object literal containing init properties that will not be checked against the class field types.
         *  @return {Class} The new instance
         */
        fun create(typeCheckedProperties: dynamic?, uncheckedProperties: Object?): Class = definedExternally
        /**
         *   Notifies the SmartClient Class system that any new classes created, or changes made
         *   to existing classes should be treated as part of the framework. This ensures that
         *   Class.isFrameworkClass will be set to true on any classes defined after this
         *   method call, until Class.modifyFrameworkDone is called.
         * 
         *   Developers may call this method before applying changes which should be considered
         *   part of the core framework, rather than application code, for example in load_skin.js
         *   files. When changes are complete, Class.modifyFrameworkDone should be called.
         *   Note that this is an alternative approach to calling Class.markAsFrameworkClass
         *   directly on specific classes.
         * 
         * 
         */
        fun modifyFrameworkStart(): Unit = definedExternally
        /**
         *   Notifies the SmartClient Class system that the developer is done making changes
         *   to the SmartClient framework (as originally indicated by a call to
         *   Class.modifyFrameworkStart).
         * 
         *   New classes created or changes made to existing classes after this method call
         *   will be considered application code. This ensures that
         *   Class.isFrameworkClass will not be set to true on Classes defined after
         *   this method call.
         * 
         */
        fun modifyFrameworkDone(): Unit = definedExternally
        /**
         *   Replaces each of the methods named in methodNames with a new implementation
         *   that simply logs a warning the first time the method is called, and nothing else. This can
         *   be used to mark methods of derived classes which do not support certain parent class
         *   methods as unsupported.
         * 
         *   The messageTemplate parameter is a template for the warning message logged
         *   when the unsupported method is first called. The following variables in the template
         *   are substituted as follows:
         * 
         * 
         *    Variable
         *    Substitution
         * 
         * 
         *    $class
         *    The Class.getClassName.
         * 
         * 
         *    $method
         *    The name of the method.
         * 
         * 
         * 
         *   If you want the literal string of a substitution variable to appear in the warning message,
         *   you can escape it by prefixing with a dollar sign. For example, to include "$class" in the
         *   warning message, use "$$class" in the template.
         * 
         *  @param {string} template for the warning message logged when first called. If null, the default template string "$class does not support the $method() method." is used.
         *  @param {Array<Partial<Identifier>>} the method names to mark as unsupported.
         */
        fun markUnsupportedMethods(messageTemplate: String, methodNames: Array<dynamic>): Unit = definedExternally
        /**
         *   Returns true if the method is supported by this class, meaning that it is not null and
         *   was not replaced by Class.markUnsupportedMethods.
         * 
         *  @param {Identifier} the name of a method to test.
         */
        fun isMethodSupported(methodName: String): Boolean = definedExternally
        /**
         * 
         *   Gets the name of this class as a string.
         * 
         * 
         */
        fun getClassName(): String = definedExternally
        /**
         * 
         *   Gets a pointer to the superClass' Class object.
         * 
         * 
         */
        fun getSuperClass(): Class = definedExternally
        /**
         * 
         *   Helper method for adding method definitions to all instances of this class.
         * 
         *   The added methods can be called as myInstance.method().
         * 
         *   Functionally equivalent to Class.addProperties, which works with both properties
         *   and methods.
         * 
         * 
         *  @param {object=} objects with methods to add (think named parameters).                 all the methods of each argument will be applied                  as instance-level methods.
         */
        fun addMethods(vararg args: Any): dynamic = definedExternally
        /**
         * 
         *   Register a method, or set of methods, that can be provided to instances of this class as
         *   Strings (containing a JavaScript expression) and will be automatically converted into
         *   functions.
         * 
         *   For example:
         * 
         *   isc.MyClass.registerStringMethods({
         *     myStringMethod: "arg1, arg2"
         *   });
         * 
         * 
         * 
         *  @param {object} If this is a string, name of the property to register                 If this is an object, assume passing in a set of name/value                  pairs to register
         *  @param {string} named arguments for the property in a comma separated string                 (not used if methodName is an object)
         */
        fun registerStringMethods(methodName: dynamic, argumentString: String): Unit = definedExternally
        /**
         *   Evaluate a string of script and return the result.
         * 
         *   This method is a wrapper around the native javascript method eval(). It
         *   papers over some native issues to ensure evaluation of script behaves consistently across
         *   browsers
         * 
         * 
         *  @param {string} the expression to be evaluated
         *  @param {object} Optional mapping of argument names to values - each key will   be available as a local variable when the script is executed.
         */
        fun evaluate(expression: String, evalArgs: dynamic): dynamic = definedExternally
        /**
         * 
         *   Add static (Class-level) properties and methods to this object
         * 
         *   These properties can then be accessed as MyClass.property, or for functions, called as
         *   MyClass.methodName()
         * 
         * 
         *  @param {object=} objects with properties to add (think named parameters).     all the properties of each argument will be applied      as class-level properties.
         */
        fun addClassProperties(vararg args: Any): dynamic = definedExternally
        /**
         *   Mark this class as a framework class (member of the SmartClient framework).
         *   Sets Class.isFrameworkClass. May be used in debugging and by the
         *   AutoTest subsystem
         * 
         */
        fun markAsFrameworkClass(): Unit = definedExternally
        /**
         * 
         *   Add default properties and methods to all instances of this class.
         * 
         *   These properties can then be accessed as myInstance.property,
         *   and methods can be called via myInstance.methodName()
         * 
         * 
         *  @param {object=} objects with properties to add (think named parameters).     all the properties of each argument will be applied
         */
        fun addProperties(vararg args: Any): dynamic = definedExternally
        /**
         * 
         *   Add default properties to all instances of this class
         * 
         * 
         *  @param {Array<Partial<object>>} array of objects with properties to add
         */
        fun addPropertyList(list: Array<dynamic>): dynamic = definedExternally
        /**
         * 
         *   Changes a set of defaults defined as a JavaScript Object. For these kind of properties,
         *   simply calling Class.addProperties would replace the original Object
         *   with yours, wiping out settings required for the basic functionality of the component.
         *   This method instead applies your overrides over the existing properties, without
         *   destroying non-overridden properties.
         * 
         *   For example let's say you have a component that's defined as follows
         * 
         *   isc.defineClass("MyComponent");
         *   isc.MyComponent.addProperties({
         *     simpleProperty: "some value",
         *     propertyBlock : {
         *      foo: "bar",
         *      zoo: "moo"
         *     }
         *   }
         * 
         *   If you wanted to override simpleProperty, you can just call Class.addProperties
         *   like this:
         * 
         *   isc.MyComponent.addProperties({
         *     simpleProperty: "my override"
         *   });
         * 
         *   If you want to override the value of propertyBlock.moo above,
         *   but you don't want to clobber the value of propertyBlock.zoo. If you use
         *   the above pattern like so:
         * 
         *   isc.MyComponent.addProperties({
         *     propertyBlock: {
         *       foo: "new value",
         *       zoo: "moo"
         *     }
         *   });
         * 
         *   You need to re-specify the value of propertyBlock.zoo which you didn't want
         *   to override. Failing to re-specify it would destroy the value.
         * 
         *   Instead of re-specifying the value, you can use this method to modify the value of
         *   foo - like this:
         * 
         *   isc.MyComponent.changeDefaults("propertyBlock", {
         *     foo: "new value"
         *   });
         * 
         * 
         *   See also the AutoChild system for information about standard sets of defaults
         *   that are available for customization.
         * 
         * 
         *  @param {string} name of the property to change
         *  @param {object} overrides for defaults
         */
        fun changeDefaults(defaultsName: String, newDefaults: dynamic): Unit = definedExternally
        /**
         *   Apply a set of properties to a class object, calling the appropriate setter class methods if
         *   any are found.
         * 
         * 
         *  @param {object=} objects with properties to add (think named parameters).     all the properties of each argument will be applied one after another      so later properties will override
         */
        fun setProperties(vararg args: Any): Unit = definedExternally
        /**
         * 
         *   Returns whether this class object is the provided class or is a subclass of the provided
         *   class, or implements the provided interface.
         * 
         * 
         *  @param {string} Class name to test against
         */
        fun isA(className: String): Boolean = definedExternally
        /**
         * 
         *   Call the SuperClass implementation of a class method.
         * 
         * 
         *  @param {string} name of the superclass method to call
         *  @param {any | Array<any>} native "arguments" object, or array of                     arguments to pass to the Super call
         *  @param {any=} native "arguments" object, required if an Array is                 passed for the "args" parameter in lieu of the native                  arguments object
         */
        fun Super(methodName: String, args: dynamic, nativeArgs: dynamic?): dynamic = definedExternally
        /**
         * 
         *   Call method on each item in argsList and return the Array of results.
         * 
         * 
         *  @param {string} Name of the method on this instance which should be called on each element of the Array
         *  @param {Array<any>} Array of items to call the method on
         */
        fun map(methodName: String, items: Array<dynamic>): Array<dynamic> = definedExternally
        /**
         * 
         *   Gets a named property from the instance defaults for this object.
         * 
         * 
         *  @param {string} name of the property to return
         */
        fun getInstanceProperty(property: String): Unit = definedExternally
        /**
         * 
         *   Sets a named property from the instance defaults for this object.
         * 
         * 
         *  @param {string} name of the property to return
         *  @param {any} value to set to
         */
        fun setInstanceProperty(property: String, value: dynamic): Unit = definedExternally
        /**
         * 
         *   Fire some arbitrary action specified as a Callback.
         *   Returns the value returned by the action.
         * 
         * 
         *  @param {Callback} Action to fire.
         *  @param {string=} Comma separated string of variable names. If the callback              passed in was a string of script, any arguments passed to the               callback will be available as local variables with these names.
         *  @param {Array<any>=} Array of arguments to pass to the method. Note that the number              of arguments should match the number of argNames.
         *  @param {object=} If specified the callback will be evaluated in the scope of this             object - the this keyword will be a pointer to this              target when the callback is fired.
         */
        fun fireCallback(callback: dynamic, argNames: String?, args: Array<dynamic>?, target: dynamic?): dynamic = definedExternally
        /**
         *   This is a helper to delay a call to a method on some target by a specified
         *   amount of time. Can be used to delay a call to a static method on this class by
         *   omitting the target parameter.
         * 
         *  @param {string} name of the method to call
         *  @param {Array<any>=} array of arguments to pass to the method in question
         *  @param {number=} Number of ms to delay the call by - defaults to zero (so just pulls            execution of the method out of the current execution thread.
         *  @param {object=} Target to fire the method on - if unspecified assume this is             a call to a classMethod on this Class.
         */
        fun delayCall(methodName: String, arrayArgs: Array<dynamic>?, time: Number?, target: dynamic?): String = definedExternally
        /**
         * 
         *   The default toString() for a ClassObject reports that you have a ClassObject and what class
         *   it is.
         * 
         */
//        fun toString(): Unit = definedExternally
        /**
         *   Returns a one-line summary of the current method call, showing method name and passed
         *   arguments.
         *   This function is available as a static on every ISC Class and as an instance
         *   method on every instance of an ISC Class.
         *   General best practice is to call the method as "this.getCallTrace(arguments)" whenever "this" is an
         *   instance, or call the static classMethod on the Log class otherwise.
         * 
         *   Note the arguments object is required in most cases for this method to function. In some
         *   browsers, it can be derived automatically, but developers looking to debug on multiple platforms
         *   should not rely on this.
         * 
         * 
         *  @param {any=} arguments object from the call to trace. If ommitted, where supported,  arguments will be derived from the calling function, or if this is not supported, the method  will not function.
         */
        fun getCallTrace(args: dynamic?): Unit = definedExternally
        /**
         *   Returns a "stack trace" - one line per method in the current call stack, showing the method
         *   name and any parameters passed.
         *   This function is available as a static on every ISC Class and as an instance
         *   method on every instance of an ISC Class.
         *   General best practice is to call the method as "this.getStackTrace" whenever "this" is an
         *   instance, or call the static classMethod on the Log class otherwise.
         * 
         *   Platform Notes: In Mozilla Firefox, if Firebug is enabled, a stack trace will be logged
         *   to the firebug console in addition to the standard stack trace string returned by
         *   this method.
         * 
         *   In browsers other than Internet Explorer a complete stack trace may not be available -
         *   this occurs when a function is re-entrant (meaning it calls itself). In this case the
         *   stack will terminate with text indicating where the recursive function call occurred.
         * 
         *   See debugging for further information information.
         * 
         * 
         */
        fun getStackTrace(): String = definedExternally
        /**
         *   Return a very short (generally less than 40 characters) string representation of any object,
         *   suitable for viewing by a developer for debugging purposes.
         *   This function is available as a static on every ISC Class and as an instance
         *   method on every instance of an ISC Class.
         *   General best practice is to call the method as "this.echoLeaf" whenever "this" is an
         *   instance, or call the static classMethod on the Log class otherwise.
         * 
         * 
         *  @param {any} object to echo
         */
        fun echoLeaf(obj: dynamic): String = definedExternally
        /**
         *   Return a short string representation of any object, suitable for viewing by a developer for
         *   debugging purposes.
         * 
         *   If passed an object containing other objects, echo will not recurse into subobjects,
         *   summarizing them instead via echoLeaf().
         * 
         *   NOTE: echo() is used to generate the output shown in the Log window when evaluating an
         *   expression.
         * 
         *   This function is available as a static on every ISC Class and as an instance
         *   method on every instance of an ISC Class.
         *   General best practice is to call the method as "this.echo()" whenever "this" is an
         *   instance, or call the static classMethod on the Log class otherwise.
         * 
         * 
         *  @param {any} object to echo
         */
        fun echo(obj: dynamic): String = definedExternally
        /**
         *   Like echo(), except that if passed an Array, echoAll() will echo() every element of the
         *   Array.
         *   This function is available as a static on every ISC Class and as an instance
         *   method on every instance of an ISC Class.
         *   General best practice is to call the method as "this.echo()" whenever "this" is an
         *   instance, or call the static classMethod on the Log class otherwise.
         * 
         * 
         *  @param {any} object to echo
         */
        fun echoAll(obj: dynamic): String = definedExternally
        /**
         *   Log a message at "debug" priority
         * 
         *   A method named logPriority exists for each priority level, on every ISC Class and
         *   instance of an ISC Class. Messages logged on a Class or instance have a default
         *   category of the classname. Messages logged on an instance will also automatically
         *   incorporate the instance ID. General best practice is to call logDebug() et al as
         *   "this.logDebug" whenever "this" is an instance, or as "Log.logDebug" otherwise.
         * 
         * 
         *  @param {string} message to log
         *  @param {string=} category to log in
         */
        fun logDebug(message: String, category: String?): Unit = definedExternally
        /**
         *   Log a message at "info" priority
         * 
         * 
         *  @param {string} message to log
         *  @param {string=} category to log in
         */
        fun logInfo(message: String, category: String?): Unit = definedExternally
        /**
         *   Log a message at "warn" priority
         * 
         * 
         *  @param {string} message to log
         *  @param {string=} category to log in
         */
        fun logWarn(message: String, category: String?): Unit = definedExternally
        /**
         *   Log a message at "error" priority
         * 
         * 
         *  @param {string} message to log
         *  @param {string=} category to log in
         */
        fun logError(message: String, category: String?): Unit = definedExternally
        /**
         *   Log a message at "fatal" priority
         * 
         * 
         *  @param {string} message to log
         *  @param {string=} category to log in
         */
        fun logFatal(message: String, category: String?): Unit = definedExternally
        /**
         *   Check whether a message logged at the given priority would be visible in the log.
         * 
         *   As with logDebug, category is defaulted to the current className. Use this method to avoid
         *   putting together expensive log messages if they will never appear in the log.
         * 
         * 
         *  @param {LogPriority} priority level
         *  @param {string=} category to log in
         */
        fun logIsEnabledFor(priority: 
                                      /**
                                       *  unrecoverable error
                                       */
                                      Number /* 1 */, category: String?): Unit = definedExternally
        /**
         *   Check whether a message logged at "debug" priority would be visible in the log.
         * 
         *   As with logDebug, category is defaulted to the current className. Use this method to avoid
         *   putting together expensive log messages if they will never appear in the log.
         * 
         * 
         *  @param {string=} category to log in
         */
        fun logIsDebugEnabled(category: String?): Unit = definedExternally
        /**
         *   Check whether a message logged at "info" priority would be visible in the log.
         * 
         *   As with logDebug, category is defaulted to the current className. Use this method to avoid
         *   putting together expensive log messages if they will never appear in the log.
         * 
         * 
         *  @param {string=} category to log in
         */
        fun logIsInfoEnabled(category: String?): Unit = definedExternally
        /**
         *   Check whether a message logged at "warn" priority would be visible in the log.
         * 
         *   As with logDebug, category is defaulted to the current className. Use this method to avoid
         *   putting together expensive log messages if they will never appear in the log.
         * 
         * 
         *  @param {string=} category to log in
         */
        fun logIsWarnEnabled(category: String?): Unit = definedExternally
        /**
         *   Check whether a message logged at "error" priority would be visible in the log.
         * 
         *   As with logDebug, category is defaulted to the current className. Use this method to avoid
         *   putting together expensive log messages if they will never appear in the log.
         * 
         * 
         *  @param {string=} category to log in
         */
        fun logIsErrorEnabled(category: String?): Unit = definedExternally
        /**
         *   Set the priority of messages that will be visible for some log category, when logged on
         *   this Class or Instance object.
         *   If called with no category, this priority will be applied to every logged message on this
         *   object
         *   To set the visible log priority for some category across the entire page, use
         *   isc.Log.setPriority() instead.
         * 
         *  @param {string} Category for which the log priority will be updated. If not             all logs on this canvas will be logged at the priority passed in.
         *  @param {LogPriority} priority level
         */
        fun setLogPriority(category: String, priority: 
                                                       /**
                                                        *  unrecoverable error
                                                        */
                                                       Number /* 1 */): Unit = definedExternally
        /**
         *   Set the default priority of logging for messages logged on this Class or Instance object.
         *   All categories for which there is no explicit, instance level logging priority set will
         *   log at this level on this object.
         *   To set the default visible log priority across the entire page, use
         *   isc.Log.setDefaultPriority() instead.
         * 
         *  @param {string} Category for which the log priority will be updated. If not             all logs on this canvas will be logged at the priority passed in.
         *  @param {LogPriority} priority level
         */
        fun setDefaultLogPriority(category: String, priority: 
                                                              /**
                                                               *  unrecoverable error
                                                               */
                                                              Number /* 1 */): Unit = definedExternally
        /**
         *   Retrieves the default priority of messages for this class or instance.
         * 
         */
        fun getDefaultLogPriority(): 
                                     /**
                                      *  unrecoverable error
                                      */
                                     Number /* 1 */ = definedExternally
        /**
         *   Clear this object's priority setting for a particular category, so that the category's
         *   effective priority returns to the specified priority for this category at the Log level
         *   (or Log.defaultPriority if not set).
         *   To clear the Page-level priority setting for this log category use
         *   isc.Log.clearPriority() instead.
         * 
         * 
         *  @param {string} Category name. If not specified, all logging on this object               will revert to default priority settings.
         */
        fun clearLogPriority(category: String): Unit = definedExternally
    }
}