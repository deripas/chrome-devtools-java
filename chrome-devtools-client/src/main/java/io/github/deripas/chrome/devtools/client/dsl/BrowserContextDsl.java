package io.github.deripas.chrome.devtools.client.dsl;

import io.github.deripas.chrome.devtools.api.Protocol;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import io.github.deripas.chrome.devtools.api.browser.Browser;
import io.github.deripas.chrome.devtools.api.browser.BrowserContextID;
import io.github.deripas.chrome.devtools.api.browser.PermissionType;
import io.github.deripas.chrome.devtools.api.network.Network;
import io.github.deripas.chrome.devtools.api.security.Security;
import io.github.deripas.chrome.devtools.api.target.SessionID;
import io.github.deripas.chrome.devtools.api.target.Target;
import io.github.deripas.chrome.devtools.api.target.TargetID;

import java.io.Closeable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

@Builder
@RequiredArgsConstructor
public class BrowserContextDsl implements Closeable {

    @Getter
    private final BrowserContextID id;
    private final Protocol protocol;
    private final Consumer<BrowserContextDsl> closeCallback;
    private final Map<TargetID, PageDsl> pages = new ConcurrentHashMap<>();

    public PageDsl createPage() {
        final PageDsl page = createTarget(protocol, id)
            .thenCompose(targetId -> attachToTarget(protocol, targetId)
                .thenCompose(sessionId -> {
                    final Protocol protocolWithSession = protocol.withSessionId(sessionId.getValue());
                    return enableEvents(protocolWithSession)
                        .thenApply(ignore -> new PageDsl(targetId, protocolWithSession, this::pageClosed));
                }))
            .join();
        pages.put(page.getId(), page);
        return page;
    }

    public void setIgnoreCertificateErrors(boolean ignore) {
        protocol.getSecurity()
            .setIgnoreCertificateErrors(Security.SetIgnoreCertificateErrorsRequest.builder()
                .ignore(ignore)
                .build())
            .join();
    }

    public void grantPermissions(List<PermissionType> permissions) {
        protocol.getBrowser()
            .grantPermissions(Browser.GrantPermissionsRequest.builder()
                .browserContextId(id)
                .permissions(permissions)
                .build())
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
        protocol.getTarget()
            .closeTarget(Target.CloseTargetRequest.builder()
                .targetId(page.getId())
                .build())
            .join();
    }

    private static CompletableFuture<Void> enableEvents(Protocol protocol) {
        return protocol.getNetwork()
            .enable(Network.EnableRequest.builder().build())
            .thenCompose(ignore -> protocol.getPage().enable());
    }

    private static CompletableFuture<TargetID> createTarget(
        Protocol protocol,
        BrowserContextID contextId
    ) {
        return protocol.getTarget()
            .createTarget(Target.CreateTargetRequest.builder()
                .url("about:blank")
                .browserContextId(contextId)
                .build())
            .thenApply(Target.CreateTargetResponse::getTargetId);
    }

    private static CompletableFuture<SessionID> attachToTarget(
        Protocol protocol,
        TargetID targetId
    ) {
        return protocol.getTarget()
            .attachToTarget(Target.AttachToTargetRequest.builder()
                .targetId(targetId)
                .flatten(true)
                .build())
            .thenApply(Target.AttachToTargetResponse::getSessionId);
    }
}
