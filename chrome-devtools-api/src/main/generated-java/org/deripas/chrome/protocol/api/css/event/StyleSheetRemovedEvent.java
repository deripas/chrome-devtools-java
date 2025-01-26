package org.deripas.chrome.protocol.api.css.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.css.StyleSheetId;

/**
 * Fired whenever an active document stylesheet is removed.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class StyleSheetRemovedEvent {
  public static final EventId<StyleSheetRemovedEvent> ID = new EventId<>("CSS.styleSheetRemoved", StyleSheetRemovedEvent.class);

  /**
   * Identifier of the removed stylesheet.
   */
  private final StyleSheetId styleSheetId;
}
