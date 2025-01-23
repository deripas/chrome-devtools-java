package org.deripas.chrome.protocol.api.storage;

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
public class AttributionReportingAggregatableDedupKey {
  @Nullable
  private final UnsignedInt64AsBase10 dedupKey;

  private final AttributionReportingFilterPair filters;
}
