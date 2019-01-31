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

There are two ways to run this application:

- Host it all on the same application server
    - SmartClient backend (Java war)
    - SmartGWT frontend (Java -> JavaScript)
    - KotlinJS/SmartClient (Kotlin -> JavaScript)

- Host the new frontend separately 
    - Application server 1 (e.g. Tomcat)
        - SmartClient backend (Java war)
        - SmartGWT frontend (Java -> JavaScript)
    - Application server 2 (e.g. NodeJS)

In the second deployment we need to take into account CORS but the advantage is that we can develop a bit faster (e.g. using webpack development mode).
The code in this example is uses the second approach. 

## Code

There are three sub-projects

- smartgwt: a copy of the `builtinds` project from the SmartGWT samples (with some changes to fit into a gradle project)
- app-redux: an example frontend using Kotlin JS + SmartClient + Redux
- app-react-redux: **ABANDONED** work but I kept it here for reference. The React + SmartClient combination in this setup felt very unnatural.

The rest of this section mainly deals with `app-redux` and talks a little bit about the first one, especially the changes I made to allow communication between SmartGWT and SmartClient.

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
which can be found inside its distribution. Unfortunately there are not Kotlin bindings (yet?).

In this prototype project we used [`ts2kt`][9] to generate kotlin bindings. However these were insufficient (and didn't compile) so they
were manually tweaked (to compile). While updating the code, the bindings will be further patched to reflect the right SmartClient API.

*smartclient.isc.kt*

```
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")
@file:JsQualifier("isc")
package isc
...
external sealed class Canvas : BaseWidget {
    open var canvasItem: CanvasItem = definedExternally
    open var animateTime: Number = definedExternally
    ...    
```

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