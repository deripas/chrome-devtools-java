# Chrome DevTools Java

A Java client for the [Chrome DevTools Protocol](https://chromedevtools.github.io/devtools-protocol/).

## Alternatives

* [Playwright for Java](https://github.com/microsoft/playwright-java)
* [Chrome Devtools Kotlin](https://github.com/joffrey-bion/chrome-devtools-kotlin)

## Usage

```java
        Protocol protocol = CDP.create()
            .http(URI.create("http://localhost:9222"))
            .get();

        protocol.getTarget()
            .createTarget(Target.CreateTargetRequest.builder()
                .url("about:blank")
                .build());
```

