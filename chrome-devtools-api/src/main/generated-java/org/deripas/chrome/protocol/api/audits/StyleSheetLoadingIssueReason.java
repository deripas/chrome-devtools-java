package org.deripas.chrome.protocol.api.audits;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

@Generated
public enum StyleSheetLoadingIssueReason {
  @JsonProperty("LateImportRule")
  LATE_IMPORT_RULE,

  @JsonProperty("RequestFailed")
  REQUEST_FAILED
}
