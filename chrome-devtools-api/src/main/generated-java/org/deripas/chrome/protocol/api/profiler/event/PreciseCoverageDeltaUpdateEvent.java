package org.deripas.chrome.protocol.api.profiler.event;

import java.lang.Double;
import java.lang.String;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.profiler.ScriptCoverage;

/**
 * Reports coverage delta since the last poll (either from an event like this, or from
 * `takePreciseCoverage` for the current isolate. May only be sent if precise code
 * coverage has been started. This event can be trigged by the embedder to, for example,
 * trigger collection of coverage data immediately at a certain point in time.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PreciseCoverageDeltaUpdateEvent {
  public static final EventId<PreciseCoverageDeltaUpdateEvent> ID = new EventId<>("Profiler.preciseCoverageDeltaUpdate", PreciseCoverageDeltaUpdateEvent.class);

  /**
   * Monotonically increasing time (in seconds) when the coverage update was taken in the backend.
   */
  private final Double timestamp;

  /**
   * Identifier for distinguishing coverage events.
   */
  private final String occasion;

  /**
   * Coverage data for the current isolate.
   */
  private final List<ScriptCoverage> result;
}
