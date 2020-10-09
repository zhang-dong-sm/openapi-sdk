#!/bin/sh

APP=$(cd $(dirname $0); pwd | awk -F '/' '{print $(NF)}')

echo $APP

mvn -U clean package
cd target

# 拷贝openapi-demo工程
mkdir -p $APP
cp -r ../src $APP
cp ../pom.xml $APP

# 拷贝外部jar
mkdir -p $APP/lib
cp ../lib/*.jar $APP/lib

# 拷贝文档
mkdir -p $APP/doc
cp ../doc/* $APP/doc

# 打zip包
zip -r $APP.zip $APP/*

echo "package $APP.zip success !"