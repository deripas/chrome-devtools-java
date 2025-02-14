package org.deripas.chrome.protocol.api.audits;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class PartitioningBlobURLIssueDetails {
  /**
   * The BlobURL that failed to load.
   */
  private final String url;

  /**
   * Additional information about the Partitioning Blob URL issue.
   */
  private final PartitioningBlobURLInfo partitioningBlobURLInfo;
}
