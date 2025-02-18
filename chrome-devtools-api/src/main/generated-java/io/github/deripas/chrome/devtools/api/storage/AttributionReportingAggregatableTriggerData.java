package io.github.deripas.chrome.devtools.api.storage;

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
public class AttributionReportingAggregatableTriggerData {
  private final UnsignedInt128AsBase16 keyPiece;

  private final List<String> sourceKeys;

  private final AttributionReportingFilterPair filters;
}
