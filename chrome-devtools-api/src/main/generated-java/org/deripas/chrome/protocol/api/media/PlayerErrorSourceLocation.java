package org.deripas.chrome.protocol.api.media;

import java.lang.Integer;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Represents logged source line numbers reported in an error.
 * NOTE: file and line are from chromium c++ implementation code, not js.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PlayerErrorSourceLocation {
  private final String file;

  private final Integer line;
}
