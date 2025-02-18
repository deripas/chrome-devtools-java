package io.github.deripas.chrome.devtools.api.storage;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Pair of reporting metadata details for a candidate URL for `selectURL()`.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SharedStorageReportingMetadata {
  private final String eventType;

  private final String reportingUrl;
}
