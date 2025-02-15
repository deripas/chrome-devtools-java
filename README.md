# Chrome DevTools Java

A Java client for the [Chrome DevTools Protocol](https://chromedevtools.github.io/devtools-protocol/).

The project is being developed more to understand how chrome devtools works and is not ready for use in production.

## Alternatives
Here are some alternatives if you want to explore other libraries:

- [Playwright for Java](https://github.com/microsoft/playwright-java): A comprehensive browser automation library based
  on Playwright.
- [Chrome Devtools Kotlin](https://github.com/joffrey-bion/chrome-devtools-kotlin): A Kotlin client for Chrome DevTools
  Protocol.

## Structure
- [Chrome DevTools Protocol Json Files](protocol)
- [Java API Generator](chrome-devtools-api-generator)
- [Generated API](chrome-devtools-api)
- [Java Client](chrome-devtools-client)

## Example Usage

To include the library in your project, add the following dependency to your `pom.xml` if you're using Maven:

```xml
<dependency>
    <groupId>org.deripas.chrome</groupId>
    <artifactId>chrome-devtools-client</artifactId>
    <version>${chrome-devtools-client.version}</version>
</dependency>
```

The raw API turned out to be not so easy to use, and to simplify the use of the client, a simplified DSL was implemented.
Example of use using DSL (wrap API):
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
The original raw API is also available.
An example of using a generated API (raw API):
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

