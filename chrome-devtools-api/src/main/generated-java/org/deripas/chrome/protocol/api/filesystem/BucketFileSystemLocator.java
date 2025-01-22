package org.deripas.chrome.protocol.api.filesystem;

import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.storage.SerializedStorageKey;

@Data
@Builder(
    toBuilder = true
)
@Generated
public class BucketFileSystemLocator {
  /**
   * Storage key
   */
  private final SerializedStorageKey storageKey;

  /**
   * Bucket name. Not passing a `bucketName` will retrieve the default Bucket. (https://developer.mozilla.org/en-US/docs/Web/API/Storage_API#storage_buckets)
   */
  @Nullable
  private final String bucketName;

  /**
   * Path to the directory using each path component as an array item.
   */
  private final List<String> pathComponents;
}
