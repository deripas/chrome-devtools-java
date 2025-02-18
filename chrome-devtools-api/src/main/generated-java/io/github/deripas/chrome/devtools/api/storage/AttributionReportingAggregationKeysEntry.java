package io.github.deripas.chrome.devtools.api.storage;

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
public class AttributionReportingAggregationKeysEntry {
  private final String key;

  private final UnsignedInt128AsBase16 value;
}
