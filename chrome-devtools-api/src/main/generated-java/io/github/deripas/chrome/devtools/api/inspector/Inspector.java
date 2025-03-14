package io.github.deripas.chrome.devtools.api.inspector;

import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import java.lang.String;
import java.lang.Void;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Experimental
@Generated
public class Inspector {
  private final Session session;

  /**
   * Disables inspector domain notifications.
   */
  public CompletableFuture<Void> disable() {
    return session.send("Inspector.disable", null, Void.class);
  }

  /**
   * Enables inspector domain notifications.
   */
  public CompletableFuture<Void> enable() {
    return session.send("Inspector.enable", null, Void.class);
  }

  public Disposable onDetached(Consumer<DetachedEvent> listener) {
    return session.subscribe("Inspector.detached", listener, DetachedEvent.class);
  }

  public Disposable onTargetCrashed(Consumer<TargetCrashedEvent> listener) {
    return session.subscribe("Inspector.targetCrashed", listener, TargetCrashedEvent.class);
  }

  public Disposable onTargetReloadedAfterCrash(Consumer<TargetReloadedAfterCrashEvent> listener) {
    return session.subscribe("Inspector.targetReloadedAfterCrash", listener, TargetReloadedAfterCrashEvent.class);
  }

  /**
   * Fired when remote debugging connection is about to be terminated. Contains detach reason.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class DetachedEvent {
    /**
     * The reason why connection has been terminated.
     */
    private final String reason;
  }

  /**
   * Fired when debugging target has crashed
   */
  public static class TargetCrashedEvent {
  }

  /**
   * Fired when debugging target has reloaded after crash
   */
  public static class TargetReloadedAfterCrashEvent {
  }
}
