package org.deripas.chrome.protocol.api.webaudio;

import java.lang.Double;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Protocol object for AudioNode
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AudioNode {
  private final GraphObjectId nodeId;

  private final GraphObjectId contextId;

  private final NodeType nodeType;

  private final Double numberOfInputs;

  private final Double numberOfOutputs;

  private final Double channelCount;

  private final ChannelCountMode channelCountMode;

  private final ChannelInterpretation channelInterpretation;
}
