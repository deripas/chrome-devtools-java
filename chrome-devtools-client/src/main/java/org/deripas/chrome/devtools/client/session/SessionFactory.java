package org.deripas.chrome.devtools.client.session;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.deripas.chrome.devtools.client.transport.CDPTransport;

@RequiredArgsConstructor
public class SessionFactory {

    private final ObjectMapper objectMapper;

    public CDPSession create(CDPTransport transport) {
        final SessionContext context = new SessionContext.Root(transport, objectMapper);
        return new CDPSessionImpl(context);
    }
}
