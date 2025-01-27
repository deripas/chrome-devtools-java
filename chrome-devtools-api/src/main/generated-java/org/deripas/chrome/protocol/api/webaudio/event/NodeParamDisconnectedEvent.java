package org.deripas.chrome.protocol.api.webaudio.event;

import java.lang.Double;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.webaudio.GraphObjectId;

/**
 * Notifies that an AudioNode is disconnected to an AudioParam.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class NodeParamDisconnectedEvent {
  public static final EventId<NodeParamDisconnectedEvent> ID = new EventId<>("WebAudio.nodeParamDisconnected", NodeParamDisconnectedEvent.class);

  private final GraphObjectId contextId;

  private final GraphObjectId sourceId;

  private final GraphObjectId destinationId;

  @Nullable
  private final Double sourceOutputIndex;
}
