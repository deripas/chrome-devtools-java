package org.deripas.chrome.protocol.api.css.event;

import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Fires whenever a MediaQuery result changes (for example, after a browser window has been
 * resized.) The current implementation considers only viewport-dependent media features.
 */
@Generated
public class MediaQueryResultChangedEvent {
  public static final EventId<MediaQueryResultChangedEvent> ID = new EventId<>("CSS.mediaQueryResultChanged", MediaQueryResultChangedEvent.class);
}
