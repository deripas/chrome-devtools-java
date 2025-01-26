package org.deripas.chrome.protocol.api.cast.event;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * This is fired whenever the outstanding issue/error message changes.
 * |issueMessage| is empty if there is no issue.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class IssueUpdatedEvent {
  public static final EventId<IssueUpdatedEvent> ID = new EventId<>("Cast.issueUpdated", IssueUpdatedEvent.class);

  private final String issueMessage;
}
