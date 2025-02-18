package io.github.deripas.chrome.devtools.api.filesystem;

import java.util.concurrent.CompletableFuture;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Experimental
@Generated
public interface FileSystem {
  CompletableFuture<GetDirectoryResponse> getDirectory(GetDirectoryRequest request);

  @Data
  @Builder(
      toBuilder = true
  )
  class GetDirectoryRequest {
    private final BucketFileSystemLocator bucketFileSystemLocator;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class GetDirectoryResponse {
    /**
     * Returns the directory object at the path.
     */
    private final Directory directory;
  }
}
