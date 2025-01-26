package org.deripas.chrome.protocol.api.audits.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.audits.InspectorIssue;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class IssueAddedEvent {
  public static final EventId<IssueAddedEvent> ID = new EventId<>("Audits.issueAdded", IssueAddedEvent.class);

  private final InspectorIssue issue;
}
