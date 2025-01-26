package org.deripas.chrome.protocol.api.css.event;

import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.css.FontFace;

/**
 * Fires whenever a web font is updated.  A non-empty font parameter indicates a successfully loaded
 * web font.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class FontsUpdatedEvent {
  public static final EventId<FontsUpdatedEvent> ID = new EventId<>("CSS.fontsUpdated", FontsUpdatedEvent.class);

  /**
   * The web font that has loaded.
   */
  @Nullable
  private final FontFace font;
}
