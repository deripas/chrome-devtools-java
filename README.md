# Chrome DevTools Java

[![maven version](https://img.shields.io/maven-central/v/io.github.deripas/chrome-devtools-client)](https://search.maven.org/search?q=io.github.deripas)

**Chrome DevTools Java** is a Java client for working with the [Chrome DevTools Protocol](https://chromedevtools.github.io/devtools-protocol/).

> **Note:** This project is mainly developed to understand how the Chrome DevTools Protocol works. It is not yet ready for production use.

---

## 👥 Alternatives

If you're looking for other libraries to interact with the Chrome DevTools Protocol, here are some popular alternatives:

- [Playwright for Java](https://github.com/microsoft/playwright-java): A comprehensive browser automation library based on Playwright.
- [Chrome Devtools Kotlin](https://github.com/joffrey-bion/chrome-devtools-kotlin): A Kotlin client for working with the Chrome DevTools Protocol.

---

## 📁 Project Structure

- **[protocol](protocol):** JSON files for the Chrome DevTools Protocol.
- **[chrome-devtools-api-generator](chrome-devtools-api-generator):** A Java API generator using [JavaPoet](https://github.com/palantir/javapoet).
- **[chrome-devtools-api](chrome-devtools-api):** The generated API.
- **[chrome-devtools-client](chrome-devtools-client):** A Java client for interacting with the protocol.

---

## 📦 Adding the Library

To include the library in your project, add the following dependency to your `pom.xml` (if you're using Maven):

```xml
<dependency>
    <groupId>io.github.deripas</groupId>
    <artifactId>chrome-devtools-client</artifactId>
    <version>${chrome-devtools-client.version}</version>
</dependency>
```

---

## 🖥 Usage Examples

### Using the Simplified DSL Wrapper:

> A DSL wrapper was implemented to simplify working with the protocol, minimizing the complexity of the low-level API.

```java
try (final BrowserDsl browser = DSL.connect("http://localhost:9222")) {
    final BrowserContextDsl context = browser.createContext();
    final PageDsl page = context.createPage();
    page.navigate("https://www.google.com");
    Thread.sleep(1000);
    byte[] bytes = page.screenshot(Page.CaptureScreenshotRequest.Format.PNG);
    Files.write(Path.of("screenshot.png"), bytes);
}
```

### Using the Raw API:

> The raw API provides full control over all aspects of interacting with the protocol but can feel less convenient for beginners.

```java
CDPSession session = CDP.createDefault()
        .connect(URI.create("http://localhost:9222"))
        .get();

Target.CreateBrowserContextResponse browserContextResponse = session.getTarget()
        .createBrowserContext(Target.CreateBrowserContextRequest
            .builder()
            .disposeOnDetach(true)
            .build())
        .get();

Target.CreateTargetResponse targetResponse = session.getTarget()
        .createTarget(Target.CreateTargetRequest.builder()
            .url("about:blank")
            .browserContextId(browserContextResponse.getBrowserContextId())
            .build())
        .get();

Target.AttachToTargetResponse attachToTargetResponse = session.getTarget()
        .attachToTarget(Target.AttachToTargetRequest.builder()
            .targetId(targetResponse.getTargetId())
            .flatten(true)
            .build())
        .get();

CDPSession withSessionId = session.withSessionId(attachToTargetResponse.getSessionId());
Page.NavigateResponse pageResponse = withSessionId.getPage()
        .navigate(Page.NavigateRequest.builder()
            .url("https://www.google.com")
            .build())
        .get();

Thread.sleep(1_000); // wait for page rendering

Page.CaptureScreenshotResponse screenshotResponse = withSessionId.getPage()
        .captureScreenshot(Page.CaptureScreenshotRequest.builder()
            .format(Page.CaptureScreenshotRequest.Format.PNG)
            .build())
        .get();

byte[] bytes = Base64.getDecoder().decode(screenshotResponse.getData());
Files.write(Path.of("screenshot.png"), bytes);

session.close();
```

---

## 💡 Notes

- The project is still under development and may contain errors or missing functionality.
- The main goal of the project is to provide an educational and research-oriented tool for working with the Chrome DevTools Protocol.

---

## 📄 License

This project is licensed under the **MIT License**. See the [`LICENSE`](LICENSE) file for details.