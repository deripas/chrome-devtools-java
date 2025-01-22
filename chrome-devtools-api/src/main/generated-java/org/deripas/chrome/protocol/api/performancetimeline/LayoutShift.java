package org.deripas.chrome.protocol.api.performancetimeline;

import java.lang.Boolean;
import java.lang.Long;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.network.TimeSinceEpoch;

/**
 * See https://wicg.github.io/layout-instability/#sec-layout-shift and layout_shift.idl
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class LayoutShift {
  /**
   * Score increment produced by this event.
   */
  private final Long value;

  private final Boolean hadRecentInput;

  private final TimeSinceEpoch lastInputTime;

  private final List<LayoutShiftAttribution> sources;
}
