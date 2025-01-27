package org.deripas.chrome.protocol.api.performance;

import java.lang.Double;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Run-time execution metric.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class Metric {
  /**
   * Metric name.
   */
  private final String name;

  /**
   * Metric value.
   */
  private final Double value;
}
