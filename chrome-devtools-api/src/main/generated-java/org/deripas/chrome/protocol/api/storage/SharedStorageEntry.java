package org.deripas.chrome.protocol.api.storage;

import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Struct for a single key-value pair in an origin's shared storage.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SharedStorageEntry {
  private final String key;

  private final String value;
}
