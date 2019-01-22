# SmartGWT, SmartClient & React

The goal of this project is to show how to use React could work together with SmartGWT and SmartClient. 

SmartClient comes with a full architecture and React doesn't play well together with libraries that like to control the DOM themselves.
So whether this is actually a good idea is up to the reader, here I merely investigate how it _could_ work. 

The approach I took was to make React the owner of the layout and use SmartClient / SmartGWT widgets.

The example SmartGWT project comes from the Isomorphic sample projects (and is published here with permission of Isomorphic Software).

The react part was bootstrapped with the [create-react-app][1] using TypeScript bindings

```
create-react-app app --typescript 
```

![SmartGWT React animated gif](doc/img/smartgwt-react.gif)

## Introduction

SmartClient and SmartGWT are products by [Isomorphic Software][2]. SmartClient is a UI widget library which can (optionally) be used with a Java-based server allowing to use a single Datasource for both the client and server as well as some built in _Direct Method Invocation_.

SmartGWT is a [GWT][3] wrapper around the SmartClient technology allowing you to also write the frontend in Java and have (Smart)GWT compile this to JavaScript.

React is a JavaScript framework originally developed by Facebook.

## Build & Deploy

Building and deployment consists of at least two parts: 

- building the react app & copying the output to the war
- building & deploying the war

To build the app:

```

cd app
yarn build
cp -R build/* ../war/
cd ..

```

Building and deploying the war depends on your local setup. Eventually the updated war needs to be (re)deployed on the application server.
(e.g. using a Intellij Ultimate _Tomcat Server_ )

### Registry

To allow the React application to access (Smart)GWT widgets which might be created on module load, I created a simple Registry (exposed via [GWT JsInterop][4]).

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

### React 

By default the React application will start immediately. Generally that's fine but in this case I want the GWT module to load first and start the React app manually:

*BuiltInDS.java* 

```
	public void onModuleLoad() {
		...
		GlobalReact.startApp();
	}
```

*GlobalReact.java*

```
package com.smartgwt.sample.client;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class GlobalReact {

	@JsMethod(namespace = JsPackage.GLOBAL)
	public static native void startApp();

}
```

*index.tsx*

```
function startApp () {
  ReactDOM.render(<App />, document.getElementById('react-app'));
  serviceWorker.unregister();
  
}

export default startApp;
(window as any)
  .startApp = startApp;
```

### React + SmartClient/SmartGWT: Pattern

Summary: 

- Initialize the UI widget as a private variable (optionally use the constructor if needed)
- Assign the SmartClient/SmartGWT widget to the DOM element (using the `id` attribute) in the `componentDidMount` lifecycle method
- Update the UI widget properties in the React `render` lifecycle method
- Clear (or hide?) the UI widget in the React `componentWillUnmount` lifecycle method
- Apply general React principles (try to use `PureComponent` as much as possible)

#### React + SmartClient Example

```
///<reference path="../typings/smartclient.d.ts"/>
import React, {PureComponent} from 'react';

interface MCProps {
  name: string
}

class MyComponent extends PureComponent<MCProps> {
  private nameLabel: isc.Label = isc.Label.create({
    align: "center", 
    width: "100%"
  });

  componentDidMount(): void {
    this.nameLabel.setHtmlElement(document.getElementById("mycomponent-hello-label") as HTMLElement);
    this.nameLabel.position = "relative";
    this.nameLabel.draw();
  }
  
  componentWillUnmount(): void {
    this.nameLabel.clear();
  }
  
  render() {
    this.nameLabel.setContents("Hello " + this.props.name);
    return <div id="mycomponent-hello-label"/>
  }
  
}

export default MyComponent
```

#### React + SmartGWT Example

Instead of create a new SmartClient widget, we get one from the SmartGWT registry instead. The rest is similar to the previous example.

*MyLegacy.tsx*

```
///<reference path="../typings/smartclient.d.ts"/>
import React, {PureComponent} from 'react';

interface MLProps {
  name: string
}

/** I render some Legacy SmartGWT component */
class MyLegacy extends PureComponent<MLProps> {

  private layout: isc.Layout = isc.Layout.create();
  
  componentDidMount(): void {
    this.layout = (window as any)
      .globalgwt
      .GlobalGWT.lookup(this.props.name);
    this.layout.setHtmlElement(
      document.getElementById("mylegacy-container") as HTMLElement);
    this.layout.position = "relative";
    this.layout.draw();
  }
  
  componentWillUnmount(): void {
    this.layout.clear();
  }

  render() {
    return <div id="mylegacy-container"/>
  }
  
}

export default MyLegacy
```



[1]: https://facebook.github.io/create-react-app/docs/adding-typescript
[2]: https://www.smartclient.com
[3]: http://www.gwtproject.org
[4]: http://www.gwtproject.org/doc/latest/DevGuideCodingBasicsJsInterop.html

