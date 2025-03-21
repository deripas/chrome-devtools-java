package io.github.deripas.chrome.devtools.api.storage;

import java.lang.Double;
import java.lang.String;
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
public class AttributionReportingAggregatableValueDictEntry {
  private final String key;

  /**
   * number instead of integer because not all uint32 can be represented by
   * int
   */
  private final Double value;

  private final UnsignedInt64AsBase10 filteringId;
}
