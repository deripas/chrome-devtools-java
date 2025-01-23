# Chrome DevTools Java API Generator

This component generates code for [chrome-devtools-api](../chrome-devtools-api) module using json files. [browser_protocol.json](../protocol/browser_protocol.json) and [js_protocol.json](../protocol/js_protocol.json).

## Build
The assembly of the executable jar is moved to a separate profile `exec-jar`. To build the executable jar, run the following command:
```bash
./mvnw -P exec-jar clean install
```
Resulting jar will be located in `target` directory.

## Usage
To generate the source code, run the following command:
```bash
java -jar chrome-devtools-api-generator/target/api-generator.jar \
 -p 'org.deripas.chrome.protocol.api' \
 -o 'chrome-devtools-api/src/main/generated-java' \
 protocol/browser_protocol.json \
 protocol/js_protocol.json
```