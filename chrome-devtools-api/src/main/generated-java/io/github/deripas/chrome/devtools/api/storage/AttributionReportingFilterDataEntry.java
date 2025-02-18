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
public class AttributionReportingFilterDataEntry {
  private final String key;

  private final List<String> values;
}
