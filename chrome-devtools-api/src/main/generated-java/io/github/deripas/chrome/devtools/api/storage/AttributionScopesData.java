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
public class AttributionScopesData {
  private final List<String> values;

  /**
   * number instead of integer because not all uint32 can be represented by
   * int
   */
  private final Double limit;

  private final Double maxEventStates;
}
