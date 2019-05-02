# Redux example

This app is a Kotlin Js frontend application. The output is a JS bundle called `app.bundle.js`.

The app uses [SmartClient][1] to draw widgets on the screen and [Redux][2] to manage state.

The `copyToWeb` gradle task generates the output bundle and copies the necessary files to the `smartgwt` project which will host the app:

**build/app.bundle.js** is copied into `../smartgwt/src/main/webapp/app`

**src/main/web/app-redux.html** is copied into `../smartgwt/src/main/webapp`

It must be in the _root_ of the web application to ease the isomorphic setup.

**src/main/web/app-redux** is copied into `../smartgwt/src/main/webapp/app-redux`

These are some relative assets

See the [main README](../README.md) for more information

[1]: https://www.isomorphic.com
[2]: https://redux.js.org/
 