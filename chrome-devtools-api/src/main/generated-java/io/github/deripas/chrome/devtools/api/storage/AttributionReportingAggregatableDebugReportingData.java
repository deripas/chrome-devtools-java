package io.github.deripas.chrome.devtools.api.storage;

import java.lang.Double;
import java.lang.String;
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
public class AttributionReportingAggregatableDebugReportingData {
  private final UnsignedInt128AsBase16 keyPiece;

  /**
   * number instead of integer because not all uint32 can be represented by
   * int
   */
  private final Double value;

  private final List<String> types;
}
