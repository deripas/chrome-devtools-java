package org.deripas.chrome.protocol.api.indexeddb;

import java.lang.Boolean;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Object store index.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ObjectStoreIndex {
  /**
   * Index name.
   */
  private final String name;

  /**
   * Index key path.
   */
  private final KeyPath keyPath;

  /**
   * If true, index is unique.
   */
  private final Boolean unique;

  /**
   * If true, index allows multiple entries for a key.
   */
  private final Boolean multiEntry;
}
