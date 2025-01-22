package org.deripas.chrome.protocol.api.webaudio;

import java.util.concurrent.CompletableFuture;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * This domain allows inspection of Web Audio API.
 * https://webaudio.github.io/web-audio-api/
 */
@Experimental
@Generated
public interface WebAudio {
  /**
   * Enables the WebAudio domain and starts sending context lifetime events.
   */
  void enable();

  /**
   * Disables the WebAudio domain.
   */
  void disable();

  /**
   * Fetch the realtime data from the registered contexts.
   */
  CompletableFuture<GetRealtimeDataResponse> getRealtimeData(GetRealtimeDataRequest request);

  @Data
  @Builder(
      toBuilder = true
  )
  class GetRealtimeDataRequest {
    private final GraphObjectId contextId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetRealtimeDataResponse {
    private final ContextRealtimeData realtimeData;
  }
}
