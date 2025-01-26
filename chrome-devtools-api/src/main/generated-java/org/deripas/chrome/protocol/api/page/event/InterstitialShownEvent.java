package org.deripas.chrome.protocol.api.page.event;

import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Fired when interstitial page was shown
 */
@Generated
public class InterstitialShownEvent {
  public static final EventId<InterstitialShownEvent> ID = new EventId<>("Page.interstitialShown", InterstitialShownEvent.class);
}
