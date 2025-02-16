package org.deripas.chrome.protocol.api.performancetimeline;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.Disposable;

/**
 * Reporting of performance timeline events, as specified in
 * https://w3c.github.io/performance-timeline/#dom-performanceobserver.
 */
@Experimental
@Generated
public interface PerformanceTimeline {
  /**
   * Previously buffered events would be reported before method returns.
   * See also: timelineEventAdded
   */
  CompletableFuture<Void> enable(EnableRequest request);

  Disposable onTimelineEventAdded(Consumer<TimelineEventAddedEvent> listener);

  @Data
  @Builder(
      toBuilder = true
  )
  class EnableRequest {
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
  @JsonTypeName("timelineEventAdded")
  class TimelineEventAddedEvent {
    private final TimelineEvent event;
  }
}
