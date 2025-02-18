package io.github.deripas.chrome.devtools.api.webaudio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Enum of AudioNode::ChannelInterpretation from the spec
 */
@Generated
public enum ChannelInterpretation {
  @JsonProperty("discrete")
  DISCRETE,

  @JsonProperty("speakers")
  SPEAKERS
}
