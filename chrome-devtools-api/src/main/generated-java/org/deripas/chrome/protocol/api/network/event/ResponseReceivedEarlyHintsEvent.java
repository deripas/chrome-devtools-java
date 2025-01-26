package org.deripas.chrome.protocol.api.network.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.Headers;
import org.deripas.chrome.protocol.api.network.RequestId;

/**
 * Fired when 103 Early Hints headers is received in addition to the common response.
 * Not every responseReceived event will have an responseReceivedEarlyHints fired.
 * Only one responseReceivedEarlyHints may be fired for eached responseReceived event.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ResponseReceivedEarlyHintsEvent {
  public static final EventId<ResponseReceivedEarlyHintsEvent> ID = new EventId<>("Network.responseReceivedEarlyHints", ResponseReceivedEarlyHintsEvent.class);

  /**
   * Request identifier. Used to match this information to another responseReceived event.
   */
  private final RequestId requestId;

  /**
   * Raw response headers as they were received over the wire.
   * Duplicate headers in the response are represented as a single key with their values
   * concatentated using `\n` as the separator.
   * See also `headersText` that contains verbatim text for HTTP/1.*.
   */
  private final Headers headers;
}
