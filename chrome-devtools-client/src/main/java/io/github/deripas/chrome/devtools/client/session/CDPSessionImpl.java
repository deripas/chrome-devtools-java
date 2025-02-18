package io.github.deripas.chrome.devtools.client.session;

import com.google.common.reflect.Reflection;
import io.github.deripas.chrome.devtools.client.CDPSession;
import lombok.experimental.Delegate;
import io.github.deripas.chrome.devtools.api.Protocol;
import io.github.deripas.chrome.devtools.api.target.SessionID;

public class CDPSessionImpl implements CDPSession {

    @Delegate
    private final Protocol protocol;

    private final SessionContext context;

    public CDPSessionImpl(SessionContext context) {
        this.context = context;
        protocol = Reflection.newProxy(
            Protocol.class,
            new ProtocolInvocationHandler(context)
        );
    }

    @Override
    public CDPSession withSessionId(SessionID sessionId) {
        return new CDPSessionImpl(context.withSessionId(sessionId.getValue()));
    }

    @Override
    public void close() {
        context.dispose();
    }
}
