#!/bin/sh
EXEC_JAR = "chrome-devtools-api-generator/target/api-generator.jar"

echo "Building the project with Jar"
./mvnw -P exec-jar clean install

echo "Check Jar file"
java -jar $EXEC_JAR --help

echo "Generate Java code"
java -jar $EXEC_JAR \
 -p org.deripas.chrome.protocol.api \
 -o chrome-devtools-api/src/main/generated-java \
 protocol/browser_protocol.json \
 protocol/js_protocol.json

echo "Check the project"
./mvnw clean install