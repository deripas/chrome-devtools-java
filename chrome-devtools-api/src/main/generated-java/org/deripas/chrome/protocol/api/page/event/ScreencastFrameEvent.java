package org.deripas.chrome.protocol.api.page.event;

import java.lang.Integer;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.page.ScreencastFrameMetadata;

/**
 * Compressed image data requested by the `startScreencast`.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ScreencastFrameEvent {
  public static final EventId<ScreencastFrameEvent> ID = new EventId<>("Page.screencastFrame", ScreencastFrameEvent.class);

  /**
   * Base64-encoded compressed image. (Encoded as a base64 string when passed over JSON)
   */
  private final String data;

  /**
   * Screencast frame metadata.
   */
  private final ScreencastFrameMetadata metadata;

  /**
   * Frame number.
   */
  private final Integer sessionId;
}
