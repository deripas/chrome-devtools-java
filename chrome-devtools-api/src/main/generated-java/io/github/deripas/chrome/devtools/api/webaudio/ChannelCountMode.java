package io.github.deripas.chrome.devtools.api.webaudio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

/**
 * Enum of AudioNode::ChannelCountMode from the spec
 */
@Generated
public enum ChannelCountMode {
  @JsonProperty("clamped-max")
  CLAMPED_MAX,

  @JsonProperty("explicit")
  EXPLICIT,

  @JsonProperty("max")
  MAX
}
