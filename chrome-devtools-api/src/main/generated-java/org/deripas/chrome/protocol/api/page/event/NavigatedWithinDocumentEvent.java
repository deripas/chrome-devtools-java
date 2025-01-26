package org.deripas.chrome.protocol.api.page.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.page.FrameId;

/**
 * Fired when same-document navigation happens, e.g. due to history API usage or anchor navigation.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class NavigatedWithinDocumentEvent {
  public static final EventId<NavigatedWithinDocumentEvent> ID = new EventId<>("Page.navigatedWithinDocument", NavigatedWithinDocumentEvent.class);

  /**
   * Id of the frame.
   */
  private final FrameId frameId;

  /**
   * Frame's new url.
   */
  private final String url;

  /**
   * Navigation type
   */
  private final NavigationType navigationType;

  public enum NavigationType {
    @JsonProperty("fragment")
    FRAGMENT,

    @JsonProperty("historyApi")
    HISTORY_API,

    @JsonProperty("other")
    OTHER
  }
}
