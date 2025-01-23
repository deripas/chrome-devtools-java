package org.deripas.chrome.protocol.api.network;

import java.lang.Long;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class ConnectTiming {
  /**
   * Timing's requestTime is a baseline in seconds, while the other numbers are ticks in
   * milliseconds relatively to this requestTime. Matches ResourceTiming's requestTime for
   * the same request (but not for redirected requests).
   */
  private final Long requestTime;
}
