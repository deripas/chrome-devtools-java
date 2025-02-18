package io.github.deripas.chrome.devtools.api.storage;

import java.lang.String;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class StorageBucket {
  private final SerializedStorageKey storageKey;

  /**
   * If not specified, it is the default bucket of the storageKey.
   */
  @Nullable
  private final String name;
}
