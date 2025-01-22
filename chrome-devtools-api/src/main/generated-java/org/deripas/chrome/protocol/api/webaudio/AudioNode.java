package org.deripas.chrome.protocol.api.webaudio;

import java.lang.Long;
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

  private final Long numberOfInputs;

  private final Long numberOfOutputs;

  private final Long channelCount;

  private final ChannelCountMode channelCountMode;

  private final ChannelInterpretation channelInterpretation;
}
