package io.github.deripas.chrome.devtools.client.dsl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import io.github.deripas.chrome.devtools.client.CDPSession;
import io.github.deripas.chrome.devtools.api.browser.BrowserContextID;
import io.github.deripas.chrome.devtools.api.target.Target;

import javax.annotation.Nullable;
import java.io.Closeable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
public class BrowserDsl implements Closeable {

    private final CDPSession session;
    private final Map<BrowserContextID, BrowserContextDsl> contexts = new ConcurrentHashMap<>();


    public BrowserContextDsl createContext() {
        return createContext(null);
    }

    @SneakyThrows
    public BrowserContextDsl createContext(@Nullable String proxy) {
        final BrowserContextID contextID = createBrowserContext(session, proxy).join();
        final BrowserContextDsl context = new BrowserContextDsl(contextID, session, this::contextClosed);
        contexts.put(contextID, context);
        return context;
    }

    @Override
    public void close() {
        contexts.values().forEach(BrowserContextDsl::close);
        contexts.clear();
        session.close();
    }

    private void contextClosed(BrowserContextDsl context) {
        contexts.remove(context.getId());
        session.getTarget()
            .disposeBrowserContext(Target.DisposeBrowserContextRequest.builder()
                .browserContextId(context.getId())
                .build())
            .join();
    }

    private static CompletableFuture<BrowserContextID> createBrowserContext(
        CDPSession session,
        String proxy
    ) {
        return session.getTarget()
            .createBrowserContext(Target.CreateBrowserContextRequest.builder()
                .proxyServer(proxy)
                .disposeOnDetach(true)
                .build())
            .thenApply(Target.CreateBrowserContextResponse::getBrowserContextId);
    }
}