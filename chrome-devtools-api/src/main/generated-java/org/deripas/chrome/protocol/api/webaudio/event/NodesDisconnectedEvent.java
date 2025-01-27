package org.deripas.chrome.protocol.api.webaudio.event;

import java.lang.Double;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.webaudio.GraphObjectId;

/**
 * Notifies that AudioNodes are disconnected. The destination can be null, and it means all the outgoing connections from the source are disconnected.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class NodesDisconnectedEvent {
  public static final EventId<NodesDisconnectedEvent> ID = new EventId<>("WebAudio.nodesDisconnected", NodesDisconnectedEvent.class);

  private final GraphObjectId contextId;

  private final GraphObjectId sourceId;

  private final GraphObjectId destinationId;

  @Nullable
  private final Double sourceOutputIndex;

  @Nullable
  private final Double destinationInputIndex;
}
