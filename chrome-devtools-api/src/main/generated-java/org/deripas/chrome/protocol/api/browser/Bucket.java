package org.deripas.chrome.protocol.api.browser;

import java.lang.Integer;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Chrome histogram bucket.
 */
@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class Bucket {
  /**
   * Minimum value (inclusive).
   */
  private final Integer low;

  /**
   * Maximum value (exclusive).
   */
  private final Integer high;

  /**
   * Number of samples.
   */
  private final Integer count;
}
