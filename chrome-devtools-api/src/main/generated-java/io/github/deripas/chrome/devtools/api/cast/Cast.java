package io.github.deripas.chrome.devtools.api.cast;

import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
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
import lombok.RequiredArgsConstructor;

/**
 * A domain for interacting with Cast, Presentation API, and Remote Playback API
 * functionalities.
 */
@RequiredArgsConstructor
@Experimental
@Generated
public class Cast {
  private final Session session;

  /**
   * Starts observing for sinks that can be used for tab mirroring, and if set,
   * sinks compatible with |presentationUrl| as well. When sinks are found, a
   * |sinksUpdated| event is fired.
   * Also starts observing for issue messages. When an issue is added or removed,
   * an |issueUpdated| event is fired.
   */
  public CompletableFuture<Void> enable(EnableRequest request) {
    return session.send("Cast.enable", request, Void.class);
  }

  /**
   * Stops observing for sinks and issues.
   */
  public CompletableFuture<Void> disable() {
    return session.send("Cast.disable", null, Void.class);
  }

  /**
   * Sets a sink to be used when the web page requests the browser to choose a
   * sink via Presentation API, Remote Playback API, or Cast SDK.
   */
  public CompletableFuture<Void> setSinkToUse(SetSinkToUseRequest request) {
    return session.send("Cast.setSinkToUse", request, Void.class);
  }

  /**
   * Starts mirroring the desktop to the sink.
   */
  public CompletableFuture<Void> startDesktopMirroring(StartDesktopMirroringRequest request) {
    return session.send("Cast.startDesktopMirroring", request, Void.class);
  }

  /**
   * Starts mirroring the tab to the sink.
   */
  public CompletableFuture<Void> startTabMirroring(StartTabMirroringRequest request) {
    return session.send("Cast.startTabMirroring", request, Void.class);
  }

  /**
   * Stops the active Cast session on the sink.
   */
  public CompletableFuture<Void> stopCasting(StopCastingRequest request) {
    return session.send("Cast.stopCasting", request, Void.class);
  }

  public Disposable onSinksUpdated(Consumer<SinksUpdatedEvent> listener) {
    return session.subscribe("Cast.sinksUpdated", listener, SinksUpdatedEvent.class);
  }

  public Disposable onIssueUpdated(Consumer<IssueUpdatedEvent> listener) {
    return session.subscribe("Cast.issueUpdated", listener, IssueUpdatedEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class EnableRequest {
    @Nullable
    private final String presentationUrl;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class SetSinkToUseRequest {
    private final String sinkName;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class StartDesktopMirroringRequest {
    private final String sinkName;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class StartTabMirroringRequest {
    private final String sinkName;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class StopCastingRequest {
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
  public static class SinksUpdatedEvent {
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
  public static class IssueUpdatedEvent {
    private final String issueMessage;
  }
}
