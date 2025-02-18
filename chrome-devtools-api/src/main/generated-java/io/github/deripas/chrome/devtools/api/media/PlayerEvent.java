package io.github.deripas.chrome.devtools.api.media;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Corresponds to kMediaEventTriggered
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PlayerEvent {
  private final Timestamp timestamp;

  private final String value;
}
