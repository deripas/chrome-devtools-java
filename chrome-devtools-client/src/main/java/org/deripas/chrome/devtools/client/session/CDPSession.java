package org.deripas.chrome.devtools.client.session;

import org.deripas.chrome.protocol.api.Protocol;
import org.deripas.chrome.protocol.api.target.SessionID;

/**
 * Represents a connection to a Chrome DevTools Protocol endpoint.
 */
public interface CDPSession extends Protocol {

    CDPSession withSessionId(SessionID sessionId);

    void close();
}
