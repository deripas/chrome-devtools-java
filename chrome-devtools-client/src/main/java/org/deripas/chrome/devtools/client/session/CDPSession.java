package org.deripas.chrome.devtools.client.session;

import org.deripas.chrome.devtools.client.Disposable;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.Protocol;
import org.deripas.chrome.protocol.api.target.SessionID;

import java.util.function.Consumer;

/**
 * Represents a connection to a Chrome DevTools Protocol endpoint.
 */
public interface CDPSession extends Protocol {

    CDPSession withSessionId(SessionID sessionId);

    <T> Disposable subscribe(EventId<T> eventId, Consumer<T> consumer);

    void close();
}
