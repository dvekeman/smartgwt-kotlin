#!/bin/bash

rm ./out/artifacts/smartgwt_react_Web_exploded/WEB-INF/db/hsqldb/isomorphic.lck

./gradlew :app:build
./gradlew :smartgwt:war