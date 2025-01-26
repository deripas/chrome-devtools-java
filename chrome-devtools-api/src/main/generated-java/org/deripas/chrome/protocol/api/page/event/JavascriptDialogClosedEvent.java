package org.deripas.chrome.protocol.api.page.event;

import java.lang.Boolean;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) has been
 * closed.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class JavascriptDialogClosedEvent {
  public static final EventId<JavascriptDialogClosedEvent> ID = new EventId<>("Page.javascriptDialogClosed", JavascriptDialogClosedEvent.class);

  /**
   * Whether dialog was confirmed.
   */
  private final Boolean result;

  /**
   * User input in case of prompt.
   */
  private final String userInput;
}
