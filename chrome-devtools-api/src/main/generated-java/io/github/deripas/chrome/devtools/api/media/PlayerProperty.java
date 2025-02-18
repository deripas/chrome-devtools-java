package io.github.deripas.chrome.devtools.api.media;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Corresponds to kMediaPropertyChange
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PlayerProperty {
  private final String name;

  private final String value;
}
