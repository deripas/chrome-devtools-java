package org.deripas.chrome.protocol.api.tethering;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.Disposable;

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

  Disposable onAccepted(Consumer<AcceptedEvent> listener);

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

  /**
   * Informs that port was successfully bound and got a specified connection id.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("accepted")
  class AcceptedEvent {
    /**
     * Port number that was successfully bound.
     */
    private final Integer port;

    /**
     * Connection id to be used.
     */
    private final String connectionId;
  }
}
