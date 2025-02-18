package io.github.deripas.chrome.devtools.api.indexeddb;

import io.github.deripas.chrome.devtools.api.runtime.RemoteObject;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

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
