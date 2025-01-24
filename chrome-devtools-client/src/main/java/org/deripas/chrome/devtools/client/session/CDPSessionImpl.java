package org.deripas.chrome.devtools.client.session;

import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import org.deripas.chrome.devtools.client.transport.CDPTransport;
import org.deripas.chrome.protocol.api.Protocol;
import org.deripas.chrome.protocol.api.target.SessionID;

@RequiredArgsConstructor
public class CDPSessionImpl implements CDPSession {

    @Delegate
    private final Protocol protocol;

    private final CDPTransport transport;
    private final SessionContext context;

    @Override
    public CDPSession withSessionId(SessionID sessionId) {
        context.setSessionId(sessionId.getValue());
        return this;
    }

    @Override
    public void close() {
        transport.close();
    }
}
