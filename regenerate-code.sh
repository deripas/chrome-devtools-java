#!/bin/sh
EXEC_JAR="chrome-devtools-api-generator/target/api-generator.jar"

if [ ! -f "$EXEC_JAR" ]; then
  echo "Jar file not found. Building the module..."
  ./mvnw -f chrome-devtools-api-generator/pom.xml -P exec-jar clean install
fi

echo "Check Jar file"
java -jar $EXEC_JAR --help

echo "Generate Java code"
java -jar $EXEC_JAR \
 -p 'io.github.deripas.chrome.devtools.api' \
 -o 'chrome-devtools-api/src/main/generated-java' \
 protocol/browser_protocol.json \
 protocol/js_protocol.json
