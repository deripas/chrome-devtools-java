package io.github.deripas.chrome.devtools.client;

import io.github.deripas.chrome.devtools.api.Protocol;
import io.github.deripas.chrome.devtools.api.target.SessionID;

/**
 * Represents a connection to a Chrome DevTools Protocol endpoint.
 */
public interface CDPSession extends Protocol {

    CDPSession withSessionId(SessionID sessionId);

    void close();
}
