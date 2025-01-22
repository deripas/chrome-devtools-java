package org.deripas.chrome.protocol.api.performancetimeline;

import java.lang.String;
import java.util.List;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

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
  void enable(EnableRequest request);

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
}
