package org.deripas.chrome.protocol.api.runtime;

import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Experimental
@Generated
public class EntryPreview {
  /**
   * Preview of the key. Specified for map-like collection entries.
   */
  @Nullable
  private final ObjectPreview key;

  /**
   * Preview of the value.
   */
  private final ObjectPreview value;
}
