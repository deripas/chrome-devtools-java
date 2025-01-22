package org.deripas.chrome.protocol.api.storage;

import java.lang.Long;
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
  private final Long value;

  private final UnsignedInt64AsBase10 filteringId;
}
