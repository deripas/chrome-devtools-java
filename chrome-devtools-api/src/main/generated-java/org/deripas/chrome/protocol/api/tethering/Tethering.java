package org.deripas.chrome.protocol.api.tethering;

import java.lang.Integer;
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
  void bind(BindRequest request);

  /**
   * Request browser port unbinding.
   */
  void unbind(UnbindRequest request);

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
