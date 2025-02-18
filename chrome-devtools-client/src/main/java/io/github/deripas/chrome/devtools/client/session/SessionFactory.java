package io.github.deripas.chrome.devtools.client.session;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.deripas.chrome.devtools.client.CDPSession;
import lombok.RequiredArgsConstructor;
import io.github.deripas.chrome.devtools.client.CDPTransport;

@RequiredArgsConstructor
public class SessionFactory {

    private final ObjectMapper objectMapper;

    public CDPSession create(CDPTransport transport) {
        final SessionContext context = new SessionContext.Root(transport, objectMapper);
        return new CDPSessionImpl(context);
    }
}
