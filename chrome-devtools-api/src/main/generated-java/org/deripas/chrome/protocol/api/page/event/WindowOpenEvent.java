package org.deripas.chrome.protocol.api.page.event;

import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Fired when a new window is going to be opened, via window.open(), link click, form submission,
 * etc.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class WindowOpenEvent {
  public static final EventId<WindowOpenEvent> ID = new EventId<>("Page.windowOpen", WindowOpenEvent.class);

  /**
   * The URL for the new window.
   */
  private final String url;

  /**
   * Window name.
   */
  private final String windowName;

  /**
   * An array of enabled window features.
   */
  private final List<String> windowFeatures;

  /**
   * Whether or not it was triggered by user gesture.
   */
  private final Boolean userGesture;
}
