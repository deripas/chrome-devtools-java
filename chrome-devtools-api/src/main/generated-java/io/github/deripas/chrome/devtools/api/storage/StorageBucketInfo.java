package io.github.deripas.chrome.devtools.api.storage;

import io.github.deripas.chrome.devtools.api.network.TimeSinceEpoch;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class StorageBucketInfo {
  private final StorageBucket bucket;

  private final String id;

  private final TimeSinceEpoch expiration;

  /**
   * Storage quota (bytes).
   */
  private final Double quota;

  private final Boolean persistent;

  private final StorageBucketsDurability durability;
}
