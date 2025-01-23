package org.deripas.chrome.protocol.api.indexeddb;

import java.lang.Long;
import java.lang.String;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Database with an array of object stores.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class DatabaseWithObjectStores {
  /**
   * Database name.
   */
  private final String name;

  /**
   * Database version (type is not 'integer', as the standard
   * requires the version number to be 'unsigned long long')
   */
  private final Long version;

  /**
   * Object stores in this database.
   */
  private final List<ObjectStore> objectStores;
}
