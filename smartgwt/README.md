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

[1]: https://github.com/esoco/gwt-gradle-plugin