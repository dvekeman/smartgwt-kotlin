# SmartGWT, SmartClient & KotlinJS

This is a proof-of-concept project to develop a SmartClient application in [KotlinJS][4] using some legacy SmartGWT code.

The example SmartGWT project comes from the Isomorphic sample projects (and is published here with permission of Isomorphic Software).
The structure of the sample project has been changed such that it fits in a gradle project. Although not mandatory I have applied a gwt-gradle plugin to 
allow building (and running) the SmartGWT module using gradle. See the README.md file in the smartgwt project directory. 

The Kotlin frontend part uses the [Kotlin Frontend Plugin][5]

## Introduction

SmartClient and SmartGWT are products by [Isomorphic Software][1]. SmartClient is a UI widget library which can (optionally) be used with a Java-based server allowing to use a single Datasource for both the client and server as well as some built in _Direct Method Invocation_.

SmartGWT is a [GWT][2] wrapper around the SmartClient technology allowing you to also write the frontend in Java and have (Smart)GWT compile this to JavaScript.

Instead of using plain JavaScript or TypeScript we will use Kotlin here.

## Build & Deploy

Building and deployment consists of at least two parts: 

- building the kotlin app & copying the output to the war
- building & deploying the war

To build the kotlin frontend app:

```
./gradlew :app:build
```

The above command will compile the Kotlin code to JavaScript and create a bundle javascript file. Afterwards it will copy this 
bundle into the web directory of the smartgwt project.

Building and deploying the war depends on your local setup. Eventually the updated war needs to be (re)deployed on the application server.
(e.g. using a Intellij Ultimate _Tomcat Server_ )

### Registry

To allow the Kotlin application to access (Smart)GWT widgets which might be created on module load, I created a simple Registry (exposed via [GWT JsInterop][3]).

```
@JsType(namespace = "globalgwt")
public class GlobalGWT {
	
	private static Map<String, Object> shared = new HashMap<>();

	public static void register(String name, Object o) {
		shared.put(name, o);
	}

	public static Object lookup(String name) {
		return shared.get(name);
	}
	
}
```

### SmartGWT

Let's first look at the SmartGWT code.

`BuiltInDS` is the main GWT `EntryPoint`. 

Upon startup, it will create the main layout without actually drawing it. Instead it will register the layout in the common `Registry`.

*BuiltInDS.java*

```	

public void onModuleLoad() {
  Layout mainLayout = initializeLayout();
  // mainLayout.draw();
  GlobalGWT.register("mainLayout", mainLayout.getOrCreateJsObj());
  ...
}

```

### Kotlin

In this example, the GWT module will start the kotlin app

*BuiltInDS.java* 

```
	public void onModuleLoad() {
		...
		GlobalGWT.startApp();
	}
```

*GlobalGWT.java*

```
	@JsMethod(namespace = JsPackage.GLOBAL)
	public static native void startApp();
```

*main.kt*

- First of all we need to register the `startApp` function in the global namespace;
- Secondly we define the `startApp` function as a wrapper around `startAppWithState` providing some initial (empty) state.

```
fun main(args: Array<String>) {
    ...

    window.asDynamic().startApp = startApp
}

val startApp: () -> ApplicationBase = { 
    val initialState = emptyMap<String, Any>()
    startAppWithState(initialState)
}

...
```

### KotlinJS + SmartClient/SmartGWT: Pattern

Summary: 

TODO

#### KotlinJS + SmartClient Example

```
// TODO
```

#### KotlinJS + SmartGWT Example

Instead of creating a new SmartClient widget, we get one from the SmartGWT registry instead. The rest is similar to the previous example.

*MyLegacy.kt*

```
TODO
```



[1]: https://www.smartclient.com
[2]: http://www.gwtproject.org
[3]: http://www.gwtproject.org/doc/latest/DevGuideCodingBasicsJsInterop.html
[4]: https://kotlinlang.org/docs/reference/js-overview.html
[5]: https://github.com/Kotlin/kotlin-frontend-plugin

