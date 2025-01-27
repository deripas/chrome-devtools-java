package org.deripas.chrome.devtools.client.session;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import org.deripas.chrome.devtools.client.Disposable;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.Protocol;
import org.deripas.chrome.protocol.api.target.SessionID;

import java.util.function.Consumer;

@RequiredArgsConstructor
public class CDPSessionImpl implements CDPSession {

    @Delegate
    private final Protocol protocol;

    private final SessionContext context;

    @Override
    public CDPSession withSessionId(SessionID sessionId) {
        context.setSessionId(sessionId.getValue());
        return this;
    }

    @Override
    public <T> Disposable subscribe(EventId<T> eventId, Consumer<T> consumer) {
        return context.subscribe(eventId, consumer);
    }

    @Override
    public void close() {
        context.dispose();
    }
}
