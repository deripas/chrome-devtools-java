package io.github.deripas.chrome.devtools.api.filesystem;

import io.github.deripas.chrome.devtools.api.Session;
import java.util.concurrent.CompletableFuture;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Experimental
@Generated
public class FileSystem {
  private final Session session;

  public CompletableFuture<GetDirectoryResponse> getDirectory(GetDirectoryRequest request) {
    return session.send("FileSystem.getDirectory", request, GetDirectoryResponse.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetDirectoryRequest {
    private final BucketFileSystemLocator bucketFileSystemLocator;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class GetDirectoryResponse {
    /**
     * Returns the directory object at the path.
     */
    private final Directory directory;
  }
}
