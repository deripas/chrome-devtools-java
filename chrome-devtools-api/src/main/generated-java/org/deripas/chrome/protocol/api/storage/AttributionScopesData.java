package org.deripas.chrome.protocol.api.storage;

import java.lang.Long;
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
public class AttributionScopesData {
  private final List<String> values;

  /**
   * number instead of integer because not all uint32 can be represented by
   * int
   */
  private final Long limit;

  private final Long maxEventStates;
}
