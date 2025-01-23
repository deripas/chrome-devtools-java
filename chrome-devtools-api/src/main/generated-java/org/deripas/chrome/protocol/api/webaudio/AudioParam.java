package org.deripas.chrome.protocol.api.webaudio;

import java.lang.Long;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Protocol object for AudioParam
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AudioParam {
  private final GraphObjectId paramId;

  private final GraphObjectId nodeId;

  private final GraphObjectId contextId;

  private final ParamType paramType;

  private final AutomationRate rate;

  private final Long defaultValue;

  private final Long minValue;

  private final Long maxValue;
}
