Important note: the SmartClient libs are not included here for several reasons:

- reduce the footprint of the git repo
- license (?)

Just copy the full `isomorphic` directory here.

The expected structure is: 

```
/public/lib/
|- isomorphic
  |- locales
  |- login
  |- skins
  |- system
```

For example

```
cp -R <PATH_TO_SmartClient>/smartclientRuntime/isomorphic <PATH_TO_smartclient-react-kotlin>/public/lib
```
