package io.github.deripas.chrome.devtools.api.webaudio;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Protocol object for AudioListener
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class AudioListener {
  private final GraphObjectId listenerId;

  private final GraphObjectId contextId;
}
