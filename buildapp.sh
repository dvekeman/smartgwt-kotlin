#!/bin/bash

rm ./out/artifacts/smartgwt_react_Web_exploded/WEB-INF/db/hsqldb/isomorphic.lck

./cleanup.sh

cd app
yarn build
cp -R build/* ../war/
cd ..
