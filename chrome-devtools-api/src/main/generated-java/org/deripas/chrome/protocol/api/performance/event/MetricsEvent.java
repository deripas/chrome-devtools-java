package org.deripas.chrome.protocol.api.performance.event;

import java.lang.String;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.performance.Metric;

/**
 * Current values of the metrics.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class MetricsEvent {
  public static final EventId<MetricsEvent> ID = new EventId<>("Performance.metrics", MetricsEvent.class);

  /**
   * Current values of the metrics.
   */
  private final List<Metric> metrics;

  /**
   * Timestamp title.
   */
  private final String title;
}
