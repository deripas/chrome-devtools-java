#!/bin/sh

echo "Building the project with Jar"
./mvnw -P jar clean install

echo "Check Jar file"
java -jar chrome-devtools-protocol/target/chrome-devtools-protocol.jar --help

echo "Generate Java code"
java -jar chrome-devtools-protocol/target/chrome-devtools-protocol.jar \
 -p org.deripas.chrome.protocol.api \
 -o chrome-devtools-api/src/main/generated-java \
 protocol/browser_protocol.json \
 protocol/js_protocol.json

echo "Check the project"
./mvnw clean install