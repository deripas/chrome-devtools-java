package org.deripas.chrome.protocol.api.indexeddb;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.runtime.RemoteObject;

/**
 * Data entry.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class DataEntry {
  /**
   * Key object.
   */
  private final RemoteObject key;

  /**
   * Primary key object.
   */
  private final RemoteObject primaryKey;

  /**
   * Value object.
   */
  private final RemoteObject value;
}
