package org.deripas.chrome.protocol.api.storage;

import java.lang.String;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Bundles a candidate URL with its reporting metadata.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SharedStorageUrlWithMetadata {
  /**
   * Spec of candidate URL.
   */
  private final String url;

  /**
   * Any associated reporting metadata.
   */
  private final List<SharedStorageReportingMetadata> reportingMetadata;
}
