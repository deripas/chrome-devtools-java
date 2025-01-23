package org.deripas.chrome.protocol.api.systeminfo;

import java.lang.Integer;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Describes the width and height dimensions of an entity.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class Size {
  /**
   * Width in pixels.
   */
  private final Integer width;

  /**
   * Height in pixels.
   */
  private final Integer height;
}
