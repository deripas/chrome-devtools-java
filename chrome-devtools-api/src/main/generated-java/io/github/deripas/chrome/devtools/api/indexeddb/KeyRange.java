package io.github.deripas.chrome.devtools.api.indexeddb;

import java.lang.Boolean;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Key range.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class KeyRange {
  /**
   * Lower bound.
   */
  @Nullable
  private final Key lower;

  /**
   * Upper bound.
   */
  @Nullable
  private final Key upper;

  /**
   * If true lower bound is open.
   */
  private final Boolean lowerOpen;

  /**
   * If true upper bound is open.
   */
  private final Boolean upperOpen;
}
