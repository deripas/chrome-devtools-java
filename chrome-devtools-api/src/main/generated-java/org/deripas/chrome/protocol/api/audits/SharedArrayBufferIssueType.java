package org.deripas.chrome.protocol.api.audits;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

@Generated
public enum SharedArrayBufferIssueType {
  @JsonProperty("TransferIssue")
  TRANSFER_ISSUE,

  @JsonProperty("CreationIssue")
  CREATION_ISSUE
}
