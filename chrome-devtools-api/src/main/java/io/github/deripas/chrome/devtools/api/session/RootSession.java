package io.github.deripas.chrome.devtools.api.session;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.deripas.chrome.devtools.api.Session;
import io.github.deripas.chrome.devtools.api.Transport;

import java.util.concurrent.atomic.AtomicLong;

public class RootSession extends BaseSession {

    public RootSession(
        Transport transport,
        ObjectMapper objectMapper
    ) {
        super(transport, objectMapper, new AtomicLong(), null);
    }

    @Override
    public Session withSessionId(String sessionId) {
        return new ChildSession(transport, objectMapper, idGenerator, sessionId);
    }

    @Override
    public void close() {
        super.close();
        transport.close();
    }
}
