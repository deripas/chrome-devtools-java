package org.deripas.chrome.protocol.api.webaudio.event;

import java.lang.Double;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.webaudio.GraphObjectId;

/**
 * Notifies that an AudioNode is connected to an AudioParam.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class NodeParamConnectedEvent {
  public static final EventId<NodeParamConnectedEvent> ID = new EventId<>("WebAudio.nodeParamConnected", NodeParamConnectedEvent.class);

  private final GraphObjectId contextId;

  private final GraphObjectId sourceId;

  private final GraphObjectId destinationId;

  @Nullable
  private final Double sourceOutputIndex;
}
