package org.deripas.chrome.protocol.api.storage;

import java.lang.Integer;
import java.util.List;
import javax.annotation.Nullable;
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
public class AttributionReportingFilterConfig {
  private final List<AttributionReportingFilterDataEntry> filterValues;

  /**
   * duration in seconds
   */
  @Nullable
  private final Integer lookbackWindow;
}
