# Chrome DevTools Java

A Java client for the [Chrome DevTools Protocol](https://chromedevtools.github.io/devtools-protocol/).

Playwright

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

