package io.github.deripas.chrome.devtools.api.performancetimeline;

import io.github.deripas.chrome.devtools.api.Disposable;
import io.github.deripas.chrome.devtools.api.Session;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

/**
 * Reporting of performance timeline events, as specified in
 * https://w3c.github.io/performance-timeline/#dom-performanceobserver.
 */
@RequiredArgsConstructor
@Experimental
@Generated
public class PerformanceTimeline {
  private final Session session;

  /**
   * Previously buffered events would be reported before method returns.
   * See also: timelineEventAdded
   */
  public CompletableFuture<Void> enable(EnableRequest request) {
    return session.send("PerformanceTimeline.enable", request, Void.class);
  }

  public Disposable onTimelineEventAdded(Consumer<TimelineEventAddedEvent> listener) {
    return session.subscribe("PerformanceTimeline.timelineEventAdded", listener, TimelineEventAddedEvent.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class EnableRequest {
    /**
     * The types of event to report, as specified in
     * https://w3c.github.io/performance-timeline/#dom-performanceentry-entrytype
     * The specified filter overrides any previous filters, passing empty
     * filter disables recording.
     * Note that not all types exposed to the web platform are currently supported.
     */
    private final List<String> eventTypes;
  }

  /**
   * Sent when a performance timeline event is added. See reportPerformanceTimeline method.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  public static class TimelineEventAddedEvent {
    private final TimelineEvent event;
  }
}
