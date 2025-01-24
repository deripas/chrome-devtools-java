package org.deripas.chrome.protocol.api.tethering;

import java.lang.Integer;
import java.lang.Void;
import java.util.concurrent.CompletableFuture;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * The Tethering domain defines methods and events for browser port binding.
 */
@Experimental
@Generated
public interface Tethering {
  /**
   * Request browser port binding.
   */
  CompletableFuture<Void> bind(BindRequest request);

  /**
   * Request browser port unbinding.
   */
  CompletableFuture<Void> unbind(UnbindRequest request);

  @Data
  @Builder(
      toBuilder = true
  )
  class BindRequest {
    /**
     * Port number to bind.
     */
    private final Integer port;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class UnbindRequest {
    /**
     * Port number to unbind.
     */
    private final Integer port;
  }
}
