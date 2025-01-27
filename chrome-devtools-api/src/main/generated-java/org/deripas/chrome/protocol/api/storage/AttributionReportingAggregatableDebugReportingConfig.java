package org.deripas.chrome.protocol.api.storage;

import java.lang.Double;
import java.lang.String;
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
public class AttributionReportingAggregatableDebugReportingConfig {
  /**
   * number instead of integer because not all uint32 can be represented by
   * int, only present for source registrations
   */
  @Nullable
  private final Double budget;

  private final UnsignedInt128AsBase16 keyPiece;

  private final List<AttributionReportingAggregatableDebugReportingData> debugData;

  @Nullable
  private final String aggregationCoordinatorOrigin;
}
