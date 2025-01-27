package org.deripas.chrome.protocol.api.storage;

import java.lang.Double;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Usage for a storage type.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class UsageForType {
  /**
   * Name of storage type.
   */
  private final StorageType storageType;

  /**
   * Storage usage (bytes).
   */
  private final Double usage;
}
