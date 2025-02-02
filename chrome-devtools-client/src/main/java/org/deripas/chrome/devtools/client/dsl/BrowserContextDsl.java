package org.deripas.chrome.devtools.client.dsl;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.deripas.chrome.devtools.client.session.CDPSession;
import org.deripas.chrome.protocol.api.browser.BrowserContextID;
import org.deripas.chrome.protocol.api.emulation.Emulation;
import org.deripas.chrome.protocol.api.network.Headers;
import org.deripas.chrome.protocol.api.network.Network;
import org.deripas.chrome.protocol.api.security.Security;
import org.deripas.chrome.protocol.api.target.SessionID;
import org.deripas.chrome.protocol.api.target.Target;
import org.deripas.chrome.protocol.api.target.TargetID;

import java.io.Closeable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

@Builder
@RequiredArgsConstructor
public class BrowserContextDsl implements Closeable {

    @Getter
    private final BrowserContextID id;
    private final CDPSession session;
    private final Consumer<BrowserContextDsl> closeCallback;
    private final Map<TargetID, PageDsl> pages = new ConcurrentHashMap<>();

    public PageDsl createPage() {
        final PageDsl page = createTarget(session, id)
            .thenCompose(targetId -> attachToTarget(session, targetId)
                .thenCompose(sessionId -> {
                    final CDPSession withSessionId = session.withSessionId(sessionId);
                    return enableEvents(withSessionId)
                        .thenApply(ignore -> new PageDsl(targetId, withSessionId, this::pageClosed));
                }))
            .join();
        pages.put(page.getId(), page);
        return page;
    }

    public void setIgnoreCertificateErrors(boolean ignore) {
        session.getSecurity()
            .setIgnoreCertificateErrors(Security.SetIgnoreCertificateErrorsRequest.builder()
                .ignore(ignore)
                .build())
            .join();
    }

    public void setUserAgent(String userAgent) {
        session.getEmulation()
            .setUserAgentOverride(Emulation.SetUserAgentOverrideRequest.builder()
                .userAgent(userAgent)
                .build())
            .join();
    }

    public void setLocale(String locale) {
        session.getEmulation()
            .setLocaleOverride(Emulation.SetLocaleOverrideRequest.builder()
                .locale(locale)
                .build())
            .join();
    }

    public void setExtraHeaders(Map<String, String> headers) {
        session.getNetwork()
            .setExtraHTTPHeaders(Network.SetExtraHTTPHeadersRequest.builder()
                .headers(Headers.of(headers))
                .build())
            .join();
    }

    public void configureDevice(Consumer<Emulation.SetDeviceMetricsOverrideRequest.SetDeviceMetricsOverrideRequestBuilder> configurer) {
        Emulation.SetDeviceMetricsOverrideRequest.SetDeviceMetricsOverrideRequestBuilder builder = Emulation.SetDeviceMetricsOverrideRequest.builder();
        session.getEmulation()
            .setDeviceMetricsOverride(builder.build())
            .join();
    }

    @Override
    public void close() {
        pages.values().forEach(PageDsl::close);
        pages.clear();
        closeCallback.accept(this);
    }

    private void pageClosed(PageDsl page) {
        pages.remove(page.getId());
        session.getTarget()
            .closeTarget(Target.CloseTargetRequest.builder()
                .targetId(page.getId())
                .build())
            .join();
    }

    private static CompletableFuture<Void> enableEvents(CDPSession session) {
        return session.getNetwork()
            .enable(Network.EnableRequest.builder().build())
            .thenCompose(ignore -> session.getPage().enable());
    }

    private static CompletableFuture<TargetID> createTarget(
        CDPSession session,
        BrowserContextID contextId
    ) {
        return session.getTarget()
            .createTarget(Target.CreateTargetRequest.builder()
                .url("about:blank")
                .browserContextId(contextId)
                .build())
            .thenApply(Target.CreateTargetResponse::getTargetId);
    }

    private static CompletableFuture<SessionID> attachToTarget(
        CDPSession session,
        TargetID targetId
    ) {
        return session.getTarget()
            .attachToTarget(Target.AttachToTargetRequest.builder()
                .targetId(targetId)
                .flatten(true)
                .build())
            .thenApply(Target.AttachToTargetResponse::getSessionId);
    }
}
