package org.deripas.chrome.protocol.api.audits;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class SharedDictionaryIssueDetails {
  private final SharedDictionaryError sharedDictionaryError;

  private final AffectedRequest request;
}
