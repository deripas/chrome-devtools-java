package org.deripas.chrome.protocol.api.storage;

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
public class AttributionReportingFilterPair {
  private final List<AttributionReportingFilterConfig> filters;

  private final List<AttributionReportingFilterConfig> notFilters;
}
