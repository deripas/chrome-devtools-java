package org.deripas.chrome.protocol.api.css.event;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.css.StyleSheetId;

/**
 * Fired whenever a stylesheet is changed as a result of the client operation.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class StyleSheetChangedEvent {
  public static final EventId<StyleSheetChangedEvent> ID = new EventId<>("CSS.styleSheetChanged", StyleSheetChangedEvent.class);

  private final StyleSheetId styleSheetId;
}
