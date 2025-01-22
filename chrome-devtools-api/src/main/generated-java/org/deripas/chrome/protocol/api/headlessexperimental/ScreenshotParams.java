package org.deripas.chrome.protocol.api.headlessexperimental;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Boolean;
import java.lang.Integer;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Encoding options for a screenshot.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ScreenshotParams {
  /**
   * Image compression format (defaults to png).
   */
  @Nullable
  private final Format format;

  /**
   * Compression quality from range [0..100] (jpeg and webp only).
   */
  @Nullable
  private final Integer quality;

  /**
   * Optimize image encoding for speed, not for resulting size (defaults to false)
   */
  @Nullable
  private final Boolean optimizeForSpeed;

  public enum Format {
    @JsonProperty("jpeg")
    JPEG,

    @JsonProperty("png")
    PNG,

    @JsonProperty("webp")
    WEBP
  }
}
