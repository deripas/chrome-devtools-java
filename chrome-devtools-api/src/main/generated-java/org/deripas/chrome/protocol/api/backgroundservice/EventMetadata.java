package org.deripas.chrome.protocol.api.backgroundservice;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * A key-value pair for additional event information to pass along.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class EventMetadata {
  private final String key;

  private final String value;
}
