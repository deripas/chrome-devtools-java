package io.github.deripas.chrome.devtools.api.session;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.deripas.chrome.devtools.api.Session;
import io.github.deripas.chrome.devtools.api.Transport;

import java.util.concurrent.atomic.AtomicLong;

public class ChildSession extends BaseSession {

    public ChildSession(
        Transport transport,
        ObjectMapper objectMapper,
        AtomicLong idGenerator,
        String sessionId
    ) {
        super(transport, objectMapper, idGenerator, sessionId);
    }

    @Override
    public Session withSessionId(String sessionId) {
        throw new UnsupportedOperationException("Child sessions can't create child sessions");
    }
}
