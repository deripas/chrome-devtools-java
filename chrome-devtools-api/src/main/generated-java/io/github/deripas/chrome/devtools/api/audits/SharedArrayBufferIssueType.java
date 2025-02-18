package io.github.deripas.chrome.devtools.api.audits;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

@Generated
public enum SharedArrayBufferIssueType {
  @JsonProperty("TransferIssue")
  TRANSFER_ISSUE,

  @JsonProperty("CreationIssue")
  CREATION_ISSUE
}
