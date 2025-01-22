package org.deripas.chrome.protocol.api.cast;

import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class Sink {
  private final String name;

  private final String id;

  /**
   * Text describing the current session. Present only if there is an active
   * session on the sink.
   */
  @Nullable
  private final String session;
}
