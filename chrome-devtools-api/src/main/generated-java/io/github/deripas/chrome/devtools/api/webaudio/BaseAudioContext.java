package io.github.deripas.chrome.devtools.api.webaudio;

import java.lang.Double;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Protocol object for BaseAudioContext
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class BaseAudioContext {
  private final GraphObjectId contextId;

  private final ContextType contextType;

  private final ContextState contextState;

  @Nullable
  private final ContextRealtimeData realtimeData;

  /**
   * Platform-dependent callback buffer size.
   */
  private final Double callbackBufferSize;

  /**
   * Number of output channels supported by audio hardware in use.
   */
  private final Double maxOutputChannelCount;

  /**
   * Context sample rate.
   */
  private final Double sampleRate;
}
