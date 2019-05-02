# Redux example

## Startup

There are several possibilities

- Run the frontend standalone
- Host the frontend together with the backend (inject the frontend script dynamically, see `BuiltInDS.java`)
    - Start the app automatically (see build.gradle.kts set `main = 'call'` in the compileKotlin2Js)
    - Start the app manually (see build.gradle.kts set `main = 'noCall'` in the compileKotlin2Js)

This app assumes to run standalone. Ensure the _server-side_ SmartGWT is started before starting the app.

 