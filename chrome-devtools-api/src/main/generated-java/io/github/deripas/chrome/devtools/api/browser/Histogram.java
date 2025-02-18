package io.github.deripas.chrome.devtools.api.browser;

import java.lang.Integer;
import java.lang.String;
import java.util.List;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Chrome histogram.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class Histogram {
  /**
   * Name.
   */
  private final String name;

  /**
   * Sum of sample values.
   */
  private final Integer sum;

  /**
   * Total number of samples.
   */
  private final Integer count;

  /**
   * Buckets.
   */
  private final List<Bucket> buckets;
}
