package org.deripas.chrome.protocol.api.page.event;

import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.LoaderId;
import org.deripas.chrome.protocol.api.page.BackForwardCacheNotRestoredExplanation;
import org.deripas.chrome.protocol.api.page.BackForwardCacheNotRestoredExplanationTree;
import org.deripas.chrome.protocol.api.page.FrameId;

/**
 * Fired for failed bfcache history navigations if BackForwardCache feature is enabled. Do
 * not assume any ordering with the Page.frameNavigated event. This event is fired only for
 * main-frame history navigation where the document changes (non-same-document navigations),
 * when bfcache navigation fails.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class BackForwardCacheNotUsedEvent {
  public static final EventId<BackForwardCacheNotUsedEvent> ID = new EventId<>("Page.backForwardCacheNotUsed", BackForwardCacheNotUsedEvent.class);

  /**
   * The loader id for the associated navigation.
   */
  private final LoaderId loaderId;

  /**
   * The frame id of the associated frame.
   */
  private final FrameId frameId;

  /**
   * Array of reasons why the page could not be cached. This must not be empty.
   */
  private final List<BackForwardCacheNotRestoredExplanation> notRestoredExplanations;

  /**
   * Tree structure of reasons why the page could not be cached for each frame.
   */
  @Nullable
  private final BackForwardCacheNotRestoredExplanationTree notRestoredExplanationsTree;
}
