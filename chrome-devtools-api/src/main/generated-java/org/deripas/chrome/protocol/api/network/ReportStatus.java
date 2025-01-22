package org.deripas.chrome.protocol.api.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Experimental;
import lombok.Generated;

/**
 * The status of a Reporting API report.
 */
@Experimental
@Generated
public enum ReportStatus {
  @JsonProperty("Queued")
  QUEUED,

  @JsonProperty("Pending")
  PENDING,

  @JsonProperty("MarkedForRemoval")
  MARKED_FOR_REMOVAL,

  @JsonProperty("Success")
  SUCCESS
}
