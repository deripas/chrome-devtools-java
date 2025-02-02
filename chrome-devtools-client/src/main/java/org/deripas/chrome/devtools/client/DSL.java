package org.deripas.chrome.devtools.client;

import org.deripas.chrome.devtools.client.dsl.BrowserDsl;
import org.deripas.chrome.devtools.client.session.CDPSession;

import java.net.URI;

public class DSL {

    public static BrowserDsl connect(String url) {
        final CDP cdp = CDP.createDefault();
        final URI uri = URI.create(url);
        final CDPSession session = cdp.connect(uri).join();
        return new BrowserDsl(session);
    }
}
