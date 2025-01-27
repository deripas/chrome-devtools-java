package org.deripas.chrome.protocol.api.layertree;

import java.lang.Double;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Serialized fragment of layer picture along with its offset within the layer.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PictureTile {
  /**
   * Offset from owning layer left boundary
   */
  private final Double x;

  /**
   * Offset from owning layer top boundary
   */
  private final Double y;

  /**
   * Base64-encoded snapshot data. (Encoded as a base64 string when passed over JSON)
   */
  private final String picture;
}
