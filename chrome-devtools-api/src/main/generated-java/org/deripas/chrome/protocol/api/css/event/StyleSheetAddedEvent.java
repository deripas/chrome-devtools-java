package org.deripas.chrome.protocol.api.css.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.css.CSSStyleSheetHeader;

/**
 * Fired whenever an active document stylesheet is added.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class StyleSheetAddedEvent {
  public static final EventId<StyleSheetAddedEvent> ID = new EventId<>("CSS.styleSheetAdded", StyleSheetAddedEvent.class);

  /**
   * Added stylesheet metainfo.
   */
  private final CSSStyleSheetHeader header;
}
