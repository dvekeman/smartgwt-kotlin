# smartgwt

This gradle module hosts the SmartGWT part of the frontend (represents some legacy GWT module).

## GWT

Tested on GWT 2.8.2. The most important GWT dependency is the `generateJsInteropExports` setting.

## GWT Gradle tasks

I applied the [gwt-gradle plugin from esoco][1]. 

Run the following command from the parent directory (the root gradle project)

```
./gradlew :smartgwt:gwtRun
```

This will startup the _server side_ part. The server will be available at 'http://127.0.0.1:9080/BuiltInDS.html' (see smartgwt/build.gradle for the server configuration options).
By default it does not render anything but a blank page.
Start one of the frontend apps to connect to it.

Another possibility is to automatically load and start a frontend app. See BuiltInDs.java `injectClientKtScript`. 

[1]: https://github.com/esoco/gwt-gradle-plugin