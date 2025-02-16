# Chrome DevTools Java Client

## Overview
The **Chrome DevTools Java Client** is a library that enables developers to interact with Chrome-based browsers via the WebSocket interface provided by the [Chrome DevTools Protocol (CDP)](https://chromedevtools.github.io/devtools-protocol/).

This client allows Java applications to:
- Automate browser actions, such as page navigation, DOM manipulation, and script execution.
- Gather detailed performance, network, and debugging data from the browser.
- Monitor and control browser events in real time.

---

## Installation
Add the following dependency to your project's `pom.xml` if using Maven:

```xml
<dependency>
    <groupId>org.deripas.chrome</groupId>
    <artifactId>chrome-devtools-client</artifactId>
    <version>${chrome-devtools-client.version}</version>
</dependency>
```

---

## Usage
### Prerequisites
- Enable the **remote debugging port** in Chrome by launching it with the `--remote-debugging-port` flag:
    ```bash
    google-chrome --remote-debugging-port=9222
    ```

- Retrieve the WebSocket endpoint URL for the browser by visiting:
    ```
    http://localhost:9222/json/version
    ```

### Example Code
Here’s a quick example of how to use the client library:

```java
try(final BrowserDsl browser = DSL.connect("http://localhost:9222")) {
    final BrowserContextDsl context = browser.createContext();
    final PageDsl page = context.createPage();
    page.navigate("https://www.google.com");
    Thread.sleep(1000);
    byte[] bytes = page.screenshot(Page.CaptureScreenshotRequest.Format.PNG);
    Files.write(Path.of("screenshot.png"), bytes);
}
```
