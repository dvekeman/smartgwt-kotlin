@file:JsQualifier("isc")
package isc

/**
 *  Sets up a real inheritance structure for Javascript objects.
 *   We separate out class objects from prototypes, so each gets its own inheritance chain.
 *   This allows us to set up superclass calls, maintain class vs. instance variables and more!
 * 
 *   The ClassFactory is a singleton object that holds the miscellaneous pieces of our inheritance
 *   mechanism.
 * 
 *   Your main interaction with the ClassFactory is to create new classes:
 *   ClassFactory.defineClass("MyClass", "mySuperClass");
 */
open external class ClassFactory {
    companion object {
        /**
         * 
         *   Create a new SmartClient class, which can then be used to create instances of this
         *   object type, via Class.create.
         * 
         *   The new Class is returned by defineClass, is available as
         *   isc.ClassName and is also available in global scope if not in
         *   isc. Typically, Class.addProperties is then
         *   called to establish different defaults in the new class, or to add methods. For
         *   example:
         * 
         *    isc.defineClass("MyListGrid", "ListGrid").addProperties({
         *      headerHeight : 40, // change default for listGrid.headerHeight
         *  
         *      // override listGrid.recordClick
         *      recordClick : function (viewer, record) { 
         *        isc.say(record.description);
         *      }
         *    })
         *    isc.MyListGrid.create(); // create an instance of the new class
         * 
         * 
         *   See also Class.Super for calling superclass methods.
         * 
         *   NOTE: isc.defineClass() also creates a new function
         *   isA.ClassName() object for identifying instances of
         *   this Class.
         * 
         * 
         *  @param {string} Name for the new class.
         *  @param {Class=} Optional SuperClass Class object or name
         */
        fun defineClass(className: String, superClass: Class?): Class = definedExternally
        /**
         * 
         *   Intentionally clobber an existing SmartClient Class, if it already exists. Works
         *   identically to ClassFactory.defineClass, except that no warning is logged to the
         *   console.
         * 
         * 
         */
        fun overwriteClass(): Unit = definedExternally
        /**
         * 
         *   Given a class name, return a pointer to the Class object for that class
         * 
         * 
         *  @param {string} name of a class
         */
        fun getClass(className: String): Class = definedExternally
        /**
         * 
         *   Given the name of a class, create an instance of that class.
         * 
         * 
         *  @param {string} Name of a class.    (ClassObject)  Actual class object to use.
         *  @param {object=} Properties to apply to the instance.
         *  @param {object=} More properties to apply to the instance.
         *  @param {object=} Yet more properties to apply to the instance.
         */
        fun newInstance(className: String, props: dynamic?, props2: dynamic?, props3: dynamic?): Class = definedExternally
    }
}