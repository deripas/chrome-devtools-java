package io.github.deripas.chrome.devtools.client.dsl;

import io.github.deripas.chrome.devtools.api.Protocol;
import io.github.deripas.chrome.devtools.api.Session;
import lombok.SneakyThrows;
import io.github.deripas.chrome.devtools.api.browser.BrowserContextID;
import io.github.deripas.chrome.devtools.api.target.Target;

import javax.annotation.Nullable;
import java.io.Closeable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class BrowserDsl implements Closeable {

    private final Protocol protocol;
    private final Map<BrowserContextID, BrowserContextDsl> contexts;

    public BrowserDsl(Session session) {
        protocol = new Protocol(session);
        contexts = new ConcurrentHashMap<>();
    }

    public BrowserContextDsl createContext() {
        return createContext(null);
    }

    @SneakyThrows
    public BrowserContextDsl createContext(@Nullable String proxy) {
        final BrowserContextID contextID = createBrowserContext(protocol, proxy).join();
        final BrowserContextDsl context = new BrowserContextDsl(contextID, protocol, this::contextClosed);
        contexts.put(contextID, context);
        return context;
    }

    @Override
    public void close() {
        contexts.values().forEach(BrowserContextDsl::close);
        contexts.clear();
        protocol.close();
    }

    private void contextClosed(BrowserContextDsl context) {
        contexts.remove(context.getId());
        protocol.getTarget()
            .disposeBrowserContext(Target.DisposeBrowserContextRequest.builder()
                .browserContextId(context.getId())
                .build())
            .join();
    }

    private static CompletableFuture<BrowserContextID> createBrowserContext(
        Protocol protocol,
        String proxy
    ) {
        return protocol.getTarget()
            .createBrowserContext(Target.CreateBrowserContextRequest.builder()
                .proxyServer(proxy)
                .disposeOnDetach(true)
                .build())
            .thenApply(Target.CreateBrowserContextResponse::getBrowserContextId);
    }
}