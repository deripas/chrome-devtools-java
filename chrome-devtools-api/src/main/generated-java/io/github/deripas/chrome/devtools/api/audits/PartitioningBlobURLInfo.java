package io.github.deripas.chrome.devtools.api.audits;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

@Generated
public enum PartitioningBlobURLInfo {
  @JsonProperty("BlockedCrossPartitionFetching")
  BLOCKED_CROSS_PARTITION_FETCHING,

  @JsonProperty("EnforceNoopenerForNavigation")
  ENFORCE_NOOPENER_FOR_NAVIGATION
}
