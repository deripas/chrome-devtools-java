package org.deripas.chrome.protocol.api.network.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.MonotonicTime;
import org.deripas.chrome.protocol.api.network.RequestId;

/**
 * Fired when EventSource message is received.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class EventSourceMessageReceivedEvent {
  public static final EventId<EventSourceMessageReceivedEvent> ID = new EventId<>("Network.eventSourceMessageReceived", EventSourceMessageReceivedEvent.class);

  /**
   * Request identifier.
   */
  private final RequestId requestId;

  /**
   * Timestamp.
   */
  private final MonotonicTime timestamp;

  /**
   * Message type.
   */
  private final String eventName;

  /**
   * Message identifier.
   */
  private final String eventId;

  /**
   * Message content.
   */
  private final String data;
}
