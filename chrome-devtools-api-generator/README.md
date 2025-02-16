# Chrome DevTools Java API Generator

## Overview
The **Chrome DevTools Java API Generator** is a tool for generating Java API source code based on Chrome DevTools protocol JSON files. It produces code used in the [chrome-devtools-api](../chrome-devtools-api) module.

This generator takes two main source protocol files:
- [`browser_protocol.json`](../protocol/browser_protocol.json)
- [`js_protocol.json`](../protocol/js_protocol.json)

The resulting API provides an abstracted Java interface to interact with the DevTools protocol.

### Build Instructions

To build an executable `jar` of the generator, use the `exec-jar` Maven profile:
```bash
./mvnw -P exec-jar clean install
```

After a successful build, the resulting JAR file will be located in the `target` directory:
- `chrome-devtools-api-generator/target/api-generator.jar`


### Usage Instructions

To generate the source code for the Chrome DevTools Java API, run the following command:
```bash
java -jar chrome-devtools-api-generator/target/api-generator.jar \
 -p 'org.example.chrome.protocol.api' \
 -o 'chrome-devtools-api/src/main/generated-java' \
 protocol/browser_protocol.json \
 protocol/js_protocol.json
```

#### Parameters:
- **`-p`**: Specifies the base package name for the generated Java classes.
- **`-o`**: Specifies the output directory for the generated source files.
- **`protocol files`**: Input protocol definition files (e.g., `browser_protocol.json` and `js_protocol.json`).
