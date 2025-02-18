package io.github.deripas.chrome.devtools.api.inspector;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.github.deripas.chrome.devtools.api.Disposable;
import java.lang.String;
import java.lang.Void;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Experimental
@Generated
public interface Inspector {
  /**
   * Disables inspector domain notifications.
   */
  CompletableFuture<Void> disable();

  /**
   * Enables inspector domain notifications.
   */
  CompletableFuture<Void> enable();

  Disposable onDetached(Consumer<DetachedEvent> listener);

  Disposable onTargetCrashed(Consumer<TargetCrashedEvent> listener);

  Disposable onTargetReloadedAfterCrash(Consumer<TargetReloadedAfterCrashEvent> listener);

  /**
   * Fired when remote debugging connection is about to be terminated. Contains detach reason.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("detached")
  class DetachedEvent {
    /**
     * The reason why connection has been terminated.
     */
    private final String reason;
  }

  /**
   * Fired when debugging target has crashed
   */
  @JsonTypeName("targetCrashed")
  class TargetCrashedEvent {
  }

  /**
   * Fired when debugging target has reloaded after crash
   */
  @JsonTypeName("targetReloadedAfterCrash")
  class TargetReloadedAfterCrashEvent {
  }
}
