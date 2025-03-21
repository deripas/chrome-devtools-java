package io.github.deripas.chrome.devtools.api.performancetimeline;

import io.github.deripas.chrome.devtools.api.network.TimeSinceEpoch;
import java.lang.Boolean;
import java.lang.Double;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

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
  private final Double value;

  private final Boolean hadRecentInput;

  private final TimeSinceEpoch lastInputTime;

  private final List<LayoutShiftAttribution> sources;
}
