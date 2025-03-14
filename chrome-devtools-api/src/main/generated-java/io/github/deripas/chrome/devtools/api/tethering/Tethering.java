package io.github.deripas.chrome.devtools.api.tethering;

import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

/**
 * The Tethering domain defines methods and events for browser port binding.
 */
@RequiredArgsConstructor
@Experimental
@Generated
public class Tethering {
  private final Session session;

  /**
   * Request browser port binding.
   */
  public CompletableFuture<Void> bind(BindRequest request) {
    return session.send("Tethering.bind", request, Void.class);
  }

  /**
   * Request browser port unbinding.
   */
  public CompletableFuture<Void> unbind(UnbindRequest request) {
    return session.send("Tethering.unbind", request, Void.class);
  }

  public Disposable onAccepted(Consumer<AcceptedEvent> listener) {
    return session.subscribe("Tethering.accepted", listener, AcceptedEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class BindRequest {
    /**
     * Port number to bind.
     */
    private final Integer port;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class UnbindRequest {
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
  public static class AcceptedEvent {
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
