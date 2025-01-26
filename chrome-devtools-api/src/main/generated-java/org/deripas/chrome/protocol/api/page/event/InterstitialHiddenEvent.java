package org.deripas.chrome.protocol.api.page.event;

import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Fired when interstitial page was hidden
 */
@Generated
public class InterstitialHiddenEvent {
  public static final EventId<InterstitialHiddenEvent> ID = new EventId<>("Page.interstitialHidden", InterstitialHiddenEvent.class);
}
