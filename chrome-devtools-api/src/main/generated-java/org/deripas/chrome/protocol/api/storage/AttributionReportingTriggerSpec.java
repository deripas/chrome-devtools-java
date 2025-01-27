package org.deripas.chrome.protocol.api.storage;

import java.lang.Double;
import java.util.List;
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
public class AttributionReportingTriggerSpec {
  /**
   * number instead of integer because not all uint32 can be represented by
   * int
   */
  private final List<Double> triggerData;

  private final AttributionReportingEventReportWindows eventReportWindows;
}
