package io.github.deripas.chrome.devtools.api.preload;

import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Information of headers to be displayed when the header mismatch occurred.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class PrerenderMismatchedHeaders {
  private final String headerName;

  @Nullable
  private final String initialValue;

  @Nullable
  private final String activationValue;
}
