package org.deripas.chrome.protocol.api.webaudio;

import java.lang.Double;
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

  private final Double defaultValue;

  private final Double minValue;

  private final Double maxValue;
}
