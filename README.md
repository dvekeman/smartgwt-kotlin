# SmartGWT, SmartClient & KotlinJS

This is a proof-of-concept project to develop a SmartClient application in [KotlinJS][4] using some legacy SmartGWT code.

The motivation for this proof-of-concept: You have a (Smart)GWT project but you would like to (gradually) move away from GWT towards Kotlin JS.

The example SmartGWT project is based up the Isomorphic `builtinds` sample project.

The structure of the sample project has been changed such that it fits in a gradle project. 
Although not mandatory I have applied a gwt-gradle plugin to 
allow building (and running) the SmartGWT module using gradle. See the README.md file in the smartgwt project directory. 

The Kotlin frontend part uses the [Kotlin Frontend Plugin][5]

## Disclaimer

This is just experimental work!

## Introduction

SmartClient and SmartGWT are products by [Isomorphic Software][1]. 
SmartClient is a UI widget library which can (optionally) be used with a Java-based server 
allowing to use a single Datasource for both the client and server as well as some built in _Direct Method Invocation_.

SmartGWT is a [GWT][2] wrapper around the SmartClient technology allowing you to also write the 
frontend in Java and have (Smart)GWT compile this to JavaScript.

Instead of using plain JavaScript or TypeScript we will use Kotlin here.

## Demo in action

![Kotlin JS + SmartGWT/SmartClient](doc/img/smartgwt-kotlin-demo.gif)

## Build & Deploy

### Quick start

```
# Compile the frontend app and distribute it into the backend
./gradlew :app-redux:copyToWeb

# Start the 'backend'
./gradlew :smartgwt:gwtRun

# OR

./gradlew :smartgwt:gwtDev
```

When running in GWT Dev mode, recompile the frontend code with this special command

```
./gradlew :app-redux:copyToGwtDevWeb
```

Then refresh the browser window. This updates the web *and* the GWT Dev output folder.

### App Startup

There are a few important timings to load the frontend JS script:

- loading the JS file itself
- starting the frontend app

There are several options to do this.

#### Automatic startup

The `main` function can be called automatically when the JS file is loaded

**build.gradle**

```
compileKotlin2Js {
    kotlinOptions.main = "call"
}
```

This means that the app will startup as soon as the file is loaded.
If the app depends on GWT then it's important to defer this until GWT has finished loading (see section _Deferred Loading_ below)

#### Manual startup

When disabled the automatic call to `main`

**build.gradle**

```
compileKotlin2Js {
    kotlinOptions.main = "noCall"
}
```

The script will not start automatically upon loading. Instead the `startApp` function can be called explicitly

**main.kt**

```
@JsName("startApp")
val startApp: () -> Unit = {
  ...
}
```

Important to remark here: if there is any dependencies to a GWT function, for example

**MainApplication.kt**

```
Section.OLD_LISTGRID -> {
    bodyContainer.addChild(
        globalgwt.lookup("mainLayout").asDynamic(), name = null, autoDraw = true
    )
}

```

Then the script loading must still be deferred until GWT has finished loading (and has successfully registered `lookup` in the `globalgwt` namespace).
(see section _Deferred Loading_ below)
 
#### Defered loading

When loading the app script dynamically using SmartGWTs `onModuleLoad` then the JS does not need to be included in the HTML page.
Instead see the following example on how to load the script. It will automatically inject the script tag into the page.

**BuiltInDs.java**

```
	public void onModuleLoad() {
	    ...
	    
		// To defer loading of the app js until the GWT module has finished loading
		// Needed when the app has dependencies on dynamic JsInterop registrations
		injectClientKtScript();

	}

	private void injectClientKtScript() {
		if (!isInjected()) {
			ScriptInjector.fromUrl("/app/app.bundle.js").setWindow(ScriptInjector.TOP_WINDOW).inject();
		}
	}

	private native boolean isInjected() /*-{
      return !(typeof $wnd.app === "undefined") && !(null === $wnd.app);
    }-*/;
```

## Code

These are the sub-projects

- smartgwt: a copy of the `builtinds` project from the SmartGWT samples (with some changes to fit into a gradle project)
- app-redux: an example frontend using Kotlin JS + SmartClient + Redux

### Registry

To allow the Kotlin JS frontend application to access (Smart)GWT widgets, I created a simple Registry (exposed via [GWT JsInterop][3]).

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

`BuiltInDS` is the main GWT `EntryPoint`. 

Upon startup, it will create the main layout without actually drawing it. Instead it will register the layout in the common `Registry`.

*BuiltInDS.java*

```	

public void onModuleLoad() {
  Layout mainLayout = initializeLayout();
  GlobalGWT.register("mainLayout", mainLayout.getOrCreateJsObj());
  ...
}

```

### Kotlin

The section below discusses the follow topics

- Creating SmartClient widgets in Kotlin using the SmartClient Kotlin Bindings
- Kotlin + Redux example using the [kotlin-wrappers for redux][8]

#### Kotlin + SmartClient

SmartClient is a JavaScript widget library. The company behind it provides a TypeScript binding (smartclient.d.ts) 
which can be found inside its distribution. Unfortunately there are no official Kotlin bindings (yet?).

In this prototype project we first used [`ts2kt`][9] to generate kotlin bindings. However these were insufficient (and didn't compile).
We developed our own typescript-to-kotlin bindings ([`tsinterop`][10])

**Creating SmartClient JS widgets**

Basic definition

```
val label = isc.Label.create(null, null)
```

Setting properties on widgets can be done in multiple ways

1. Using the typed API

Property example:

```
label.width = "100%"
```

Method example: 

```
label.setContents("Blah")
```

2. Using JS syntax

This is recommended only for simple properties

```
val label = isc.Label.create(js("""
{ width: "100%"
, contents: "blah"
}
"""), null)
```

The `js` function only takes String constants. This means the following is allowed

```
val myContent = "blah"
val label = isc.Label.create(js("""
{ width: "100%"
, contents: "$myContent"
}
"""), null)
```

Only because the `myContent` variable is a final constant. The following is **not** allowed

```
fun createLabel(myContent: String): isc.Label {
  val label = isc.Label.create(js("""
{ contents: "$myContent" }
  """), null)
}
```

Because in the example above, `myContent` is a function variable instead of a constant. However, due to the nature
of how the `js` function works we can just write

```
fun createLabel(myContent: String): isc.Label {
  val label = isc.Label.create(js("""
{ contents: myContent }
  """), null)
}

```
(note: the only difference is `$myContent` vs `myContent`)

This works because the generated JS looks like:

```
function createStandardLabel(contents) {
    return Label$Companion.create({contents: contents}, null);
}
```

!!! To be investigated how this behaves with JS obfuscation and minimization !!!

Similar for **methods**

We could write:

```
private fun createMainLayout(): isc.Layout {
    val mainLayout = isc.HLayout.create(js("""
{ overflow: "hidden"
, width: "100%"
, height: "100%"
}
    """), null)
    mainLayout.addMember(createBody(), position = null)
    ...
}
```

Here we use the typed API to add the member. Or we could write

```
private fun createMainLayout(): isc.Layout {
    val mainLayout = isc.HLayout.create(js("""
{ overflow: "hidden"
, width: "100%"
, height: "100%"
, members: [ createBody() ]
}
    """), null)
    ...
}

@JsName("createBody")
private fun createBody(): isc.VLayout {
  ...
}
```
**Note** the annotation `@JsName("createBody")` to ensure the name in JS exists.

Although the above syntax is correct, it's probably better not to use it and instead use the typed API.

#### Kotlin + Redux

*main.kt*

The main function checks if we should run in `hosted` mode (see first deployment in the `Build & Deploy` section) or 
in standalone mode. In hosted mode we register the `startApp` function in the global namespace such that the GWT module
can invoke it (after it has loaded). In standalone mode we just start the app immediately.

```
fun main(args: Array<String>) {
    println("main")

    if(hosted) {
        window.asDynamic().startApp = startApp
    } else {
        startApp()
    }
}
```

The `startApp` function itself deals with some `Hot Module Reload` stuff (which I just more or less copied from the kotlin frontend plugin example). You can skip it.

```
val startApp: () -> Unit = { ... }
```

The `start` function is more interesting

- Initialize a Redux store (more details later)
- Start the `MainApplication`

```
fun start(initialStore: SampleStore? = null): ApplicationBase {
    val store : SampleStore = initialStore ?: createMainStore()
    val unsubscribe = store.subscribe { 
        println("State changed to: ")
        println(store.state)
    }

    val application = MainApplication(store)
    application.start()
    return application
}
```

Before looking into the `MainApplication`, let's talk about the Redux setup.

For an introduction to Redux, see [their website][6]. Here we are using Redux without React. The concepts are quite simple

- Redux contains the global application state (for example: the selected module from the menu or state which must be shared between different modules)
- Redux also handles events (to trigger state changes)

For that we need to (1) setup a store, (2) define a global state and (3) write some reducers.

*MainStore.kt* 

Let's first look at our (initial) state class

```
data class AppState(
        val mainState: MainState = MainState(visibleModule = Section.NONE)
)
```

The goal is to build a hierarchical state so AppState will eventually be a combination of several sub-states.

Next is to create the store. Here a `reducer` is something which deals with the events (we'll see an example soon).
But important to note is that we compose the _main_ reducer from a set of sub-reducers.

```
fun createMainStore() = createStore(
        reducer = combineReducers(
                mapOf(
                        "mainState" to { state: MainState, action: RAction ->
                            mainReducer(state, action)
                        }
                )
        ),
        preloadedState = AppState(),
        enhancer = rEnhancer()
)
```

*MainApplication.kt*

Here we find the actual state (our model), actions (our messages) and reducers (our update). An alternative introduction to Redux is the [The Elm Architecture (TEA)][7]

I assume it is rather self-explanatory. Although this is stressed enough in the Redux documentation: the only thing
the reducer does is updating some state. It does not 

```
/** STATE / MODEL -------------------------------------------------------------------------------------------------- **/

data class MainState(val visibleModule: Section)

/** ---------------------------------------------------------------------------------------------------------------- **/

/** ACTIONS / MESSAGES --------------------------------------------------------------------------------------------- **/

data class ChangeSection(val activeSection: Section) : RAction

/** ---------------------------------------------------------------------------------------------------------------- **/

/** REDUCER / UPDATE ----------------------------------------------------------------------------------------------- **/

fun mainReducer(mainState: MainState = MainState(visibleModule = Section.NONE), action: RAction) =
        when (action) {

            is ChangeSection ->
                mainState.copy(visibleModule = action.activeSection)

            else -> mainState

        }

/** -----------------------------------------------------------------------------------------------------------------**/

```

Now this is setup there are two remaining parts

- Subscribing to action events
- Dispatching actions

*MainApplication.kt*

The `MainApplication` is a class which receives the store as a constructor parameter.
It subscribes to the store and only cares about its own actions (currently it only cares about the visible module it
has to show).

Our subscribe logic is a bit verbose because we need to check whether the update to the store is actually relevant to us. 
There are other libraries which deal with this and help to reduce the verbosity (e.g. React + `connect`) but they are out of 
scope for this prototype.

```
class MainApplication(val store: SampleStore) : ApplicationBase() {

    ...

    override fun start() {
        requireAll(kotlinext.js.require.context("app-redux", true, js("/\\.css$/")))

        mainLayout = createMainLayout()
        mainLayout.draw()

        var visibleModule = store.getState().mainState.visibleModule
        store.subscribe {
            val newVisibleModule = store.getState().mainState.visibleModule

            if(visibleModule == newVisibleModule){
                println("No changes... (visibleModule: '$visibleModule') ")
                return@subscribe
            }

            visibleModule = newVisibleModule
            bodyContainer.removeChild(bodyContainer.children[0])

            when (store.state.mainState.visibleModule) {
                Section.NONE -> {
                    bodyContainer.addChild(createDefaultBody())
                }

                Section.NEW_LISTGRID -> {
                    bodyContainer.addChild(MainListGrid(store).getCanvas())
                }

                Section.OLD_LISTGRID -> {
                    // The js("...") part is ugly because - for some reason - 
                    // kotlin does not yet find the globalgwt namespace (will be fixed)
                    bodyContainer.addChild(js("globalgwt.GlobalGWT.lookup(\"mainLayout\")"))
                    // bodyContainer.addChild(globalgwt.lookup("mainLayout") as isc.Canvas)
                }
            }
        }
    }
    
    ...
}
```
 
Last be not least: `dispatch`

When the user interacts with the application (e.g. by clicking or typing) we can register a listener using the API
from the widget library (SmartClient in our case) and dispatch an action with some custom data.

For example: 

```
val newListGridMenuButton = isc.IButton.create()
newListGridMenuButton.setTitle(title)
newListGridMenuButton.click = {
   store.dispatch(ChangeSection(Section.NEW_LISTGRID))
}
```

This is what the top menu bar does (although a bit more generic).
For each section we defined, it renders a button 

```

// MainApplication.kt

enum class Section(val title: String) {
    NONE("HOME"), NEW_LISTGRID("SmartClient ListGrid"), OLD_LISTGRID("SmartGWT ListGrid")
}

class MainApplication(val store: SampleStore) : ApplicationBase() {

    ...

    private fun createTopBar(): isc.Canvas {
        val topbar = isc.HLayout.create()

        val menuButtons: Array<isc.Canvas> = Section.values()
                .map {
                    withClickDispatch(createStandardButton(it.title), store, ChangeSection(it))
                }
                .toTypedArray()
        topbar.addMembers(menuButtons)

        return topbar
    }
    
    ...
}

// factory.kt

fun createStandardButton(title: String): isc.Button {
    val button = isc.IButton.create()
    button.setTitle(title)
    return button
}

fun withClickDispatch(canvas: isc.Canvas, store: SampleStore, action: RAction): isc.Canvas {
    canvas.asDynamic().click = {
        store.dispatch(action)
    }
    return canvas
}
```


[1]: https://www.smartclient.com
[2]: http://www.gwtproject.org
[3]: http://www.gwtproject.org/doc/latest/DevGuideCodingBasicsJsInterop.html
[4]: https://kotlinlang.org/docs/reference/js-overview.html
[5]: https://github.com/Kotlin/kotlin-frontend-plugin
[6]: https://redux.js.org/
[7]: https://guide.elm-lang.org/architecture/
[8]: https://github.com/JetBrains/kotlin-wrappers/tree/master/kotlin-redux
[9]: https://github.com/Kotlin/ts2kt
[10]: https://github.com/dvekeman/tsinterop