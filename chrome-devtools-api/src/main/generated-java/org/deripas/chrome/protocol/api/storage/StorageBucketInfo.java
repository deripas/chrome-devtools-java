package org.deripas.chrome.protocol.api.storage;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.network.TimeSinceEpoch;

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
  private final Long quota;

  private final Boolean persistent;

  private final StorageBucketsDurability durability;
}
