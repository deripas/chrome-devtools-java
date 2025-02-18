package io.github.deripas.chrome.devtools.api.cast;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.Disposable;

/**
 * A domain for interacting with Cast, Presentation API, and Remote Playback API
 * functionalities.
 */
@Experimental
@Generated
public interface Cast {
  /**
   * Starts observing for sinks that can be used for tab mirroring, and if set,
   * sinks compatible with |presentationUrl| as well. When sinks are found, a
   * |sinksUpdated| event is fired.
   * Also starts observing for issue messages. When an issue is added or removed,
   * an |issueUpdated| event is fired.
   */
  CompletableFuture<Void> enable(EnableRequest request);

  /**
   * Stops observing for sinks and issues.
   */
  CompletableFuture<Void> disable();

  /**
   * Sets a sink to be used when the web page requests the browser to choose a
   * sink via Presentation API, Remote Playback API, or Cast SDK.
   */
  CompletableFuture<Void> setSinkToUse(SetSinkToUseRequest request);

  /**
   * Starts mirroring the desktop to the sink.
   */
  CompletableFuture<Void> startDesktopMirroring(StartDesktopMirroringRequest request);

  /**
   * Starts mirroring the tab to the sink.
   */
  CompletableFuture<Void> startTabMirroring(StartTabMirroringRequest request);

  /**
   * Stops the active Cast session on the sink.
   */
  CompletableFuture<Void> stopCasting(StopCastingRequest request);

  Disposable onSinksUpdated(Consumer<SinksUpdatedEvent> listener);

  Disposable onIssueUpdated(Consumer<IssueUpdatedEvent> listener);

  @Data
  @Builder(
      toBuilder = true
  )
  class EnableRequest {
    @Nullable
    private final String presentationUrl;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class SetSinkToUseRequest {
    private final String sinkName;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class StartDesktopMirroringRequest {
    private final String sinkName;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class StartTabMirroringRequest {
    private final String sinkName;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class StopCastingRequest {
    private final String sinkName;
  }

  /**
   * This is fired whenever the list of available sinks changes. A sink is a
   * device or a software surface that you can cast to.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("sinksUpdated")
  class SinksUpdatedEvent {
    private final List<Sink> sinks;
  }

  /**
   * This is fired whenever the outstanding issue/error message changes.
   * |issueMessage| is empty if there is no issue.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("issueUpdated")
  class IssueUpdatedEvent {
    private final String issueMessage;
  }
}
