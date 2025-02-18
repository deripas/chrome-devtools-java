package io.github.deripas.chrome.devtools.client;

import io.github.deripas.chrome.devtools.client.dsl.BrowserDsl;

import java.net.URI;

public class DSL {

    public static BrowserDsl connect(String url) {
        final CDP cdp = CDP.createDefault();
        final URI uri = URI.create(url);
        final CDPSession session = cdp.connect(uri).join();
        return new BrowserDsl(session);
    }
}
