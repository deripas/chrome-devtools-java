package org.deripas.chrome.protocol.api.webaudio.event;

import java.lang.Double;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.webaudio.GraphObjectId;

/**
 * Notifies that two AudioNodes are connected.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class NodesConnectedEvent {
  public static final EventId<NodesConnectedEvent> ID = new EventId<>("WebAudio.nodesConnected", NodesConnectedEvent.class);

  private final GraphObjectId contextId;

  private final GraphObjectId sourceId;

  private final GraphObjectId destinationId;

  @Nullable
  private final Double sourceOutputIndex;

  @Nullable
  private final Double destinationInputIndex;
}
