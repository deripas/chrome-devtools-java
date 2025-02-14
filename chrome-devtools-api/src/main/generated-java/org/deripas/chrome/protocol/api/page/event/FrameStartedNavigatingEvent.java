package org.deripas.chrome.protocol.api.page.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.LoaderId;
import org.deripas.chrome.protocol.api.page.FrameId;

/**
 * Fired when a navigation starts. This event is fired for both
 * renderer-initiated and browser-initiated navigations. For renderer-initiated
 * navigations, the event is fired after `frameRequestedNavigation`.
 * Navigation may still be cancelled after the event is issued. Multiple events
 * can be fired for a single navigation, for example, when a same-document
 * navigation becomes a cross-document navigation (such as in the case of a
 * frameset).
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class FrameStartedNavigatingEvent {
  public static final EventId<FrameStartedNavigatingEvent> ID = new EventId<>("Page.frameStartedNavigating", FrameStartedNavigatingEvent.class);

  /**
   * ID of the frame that is being navigated.
   */
  private final FrameId frameId;

  /**
   * The URL the navigation started with. The final URL can be different.
   */
  private final String url;

  /**
   * Loader identifier. Even though it is present in case of same-document
   * navigation, the previously committed loaderId would not change unless
   * the navigation changes from a same-document to a cross-document
   * navigation.
   */
  private final LoaderId loaderId;

  private final NavigationType navigationType;

  public enum NavigationType {
    @JsonProperty("reload")
    RELOAD,

    @JsonProperty("reloadBypassingCache")
    RELOAD_BYPASSING_CACHE,

    @JsonProperty("restore")
    RESTORE,

    @JsonProperty("restoreWithPost")
    RESTORE_WITH_POST,

    @JsonProperty("historySameDocument")
    HISTORY_SAME_DOCUMENT,

    @JsonProperty("historyDifferentDocument")
    HISTORY_DIFFERENT_DOCUMENT,

    @JsonProperty("sameDocument")
    SAME_DOCUMENT,

    @JsonProperty("differentDocument")
    DIFFERENT_DOCUMENT
  }
}
