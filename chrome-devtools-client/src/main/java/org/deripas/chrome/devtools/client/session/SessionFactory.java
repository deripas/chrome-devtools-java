package org.deripas.chrome.devtools.client.session;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.reflect.Reflection;
import lombok.RequiredArgsConstructor;
import org.deripas.chrome.devtools.client.transport.CDPTransport;
import org.deripas.chrome.protocol.api.Protocol;

@RequiredArgsConstructor
public class SessionFactory {

    private final ObjectMapper objectMapper;

    public CDPSession create(CDPTransport transport) {
        final SessionContext context = new SessionContext(transport, objectMapper);
        final Protocol protocol = Reflection.newProxy(
            Protocol.class,
            new ProtocolInvocationHandler(context)
        );
        return new CDPSessionImpl(protocol, context);
    }
}
