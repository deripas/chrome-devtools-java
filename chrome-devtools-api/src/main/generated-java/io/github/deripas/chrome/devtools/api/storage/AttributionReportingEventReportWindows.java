package io.github.deripas.chrome.devtools.api.storage;

import java.lang.Integer;
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
public class AttributionReportingEventReportWindows {
  /**
   * duration in seconds
   */
  private final Integer start;

  /**
   * duration in seconds
   */
  private final List<Integer> ends;
}
