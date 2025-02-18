package io.github.deripas.chrome.devtools.api.indexeddb;

import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Object store.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class ObjectStore {
  /**
   * Object store name.
   */
  private final String name;

  /**
   * Object store key path.
   */
  private final KeyPath keyPath;

  /**
   * If true, object store has auto increment flag set.
   */
  private final Boolean autoIncrement;

  /**
   * Indexes in this object store.
   */
  private final List<ObjectStoreIndex> indexes;
}
