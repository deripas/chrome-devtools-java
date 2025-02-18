package io.github.deripas.chrome.devtools.api.storage;

import java.lang.Double;
import java.lang.Integer;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import io.github.deripas.chrome.devtools.api.network.TimeSinceEpoch;

/**
 * Details for an origin's shared storage.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class SharedStorageMetadata {
  /**
   * Time when the origin's shared storage was last created.
   */
  private final TimeSinceEpoch creationTime;

  /**
   * Number of key-value pairs stored in origin's shared storage.
   */
  private final Integer length;

  /**
   * Current amount of bits of entropy remaining in the navigation budget.
   */
  private final Double remainingBudget;

  /**
   * Total number of bytes stored as key-value pairs in origin's shared
   * storage.
   */
  private final Integer bytesUsed;
}
