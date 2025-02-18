package io.github.deripas.chrome.devtools.api.io;

import io.github.deripas.chrome.devtools.api.runtime.RemoteObjectId;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

/**
 * Input/Output operations for streams produced by DevTools.
 */
@Generated
public interface IO {
  /**
   * Close the stream, discard any temporary backing storage.
   */
  CompletableFuture<Void> close(CloseRequest request);

  /**
   * Read a chunk of the stream
   */
  CompletableFuture<ReadResponse> read(ReadRequest request);

  /**
   * Return UUID of Blob object specified by a remote object id.
   */
  CompletableFuture<ResolveBlobResponse> resolveBlob(ResolveBlobRequest request);

  @Data
  @Builder(
      toBuilder = true
  )
  class CloseRequest {
    /**
     * Handle of the stream to close.
     */
    private final StreamHandle handle;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ReadRequest {
    /**
     * Handle of the stream to read.
     */
    private final StreamHandle handle;

    /**
     * Seek to the specified offset before reading (if not specified, proceed with offset
     * following the last read). Some types of streams may only support sequential reads.
     */
    @Nullable
    private final Integer offset;

    /**
     * Maximum number of bytes to read (left upon the agent discretion if not specified).
     */
    @Nullable
    private final Integer size;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ReadResponse {
    /**
     * Set if the data is base64-encoded
     */
    @Nullable
    private final Boolean base64Encoded;

    /**
     * Data that were read.
     */
    private final String data;

    /**
     * Set if the end-of-file condition occurred while reading.
     */
    private final Boolean eof;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ResolveBlobRequest {
    /**
     * Object id of a Blob object wrapper.
     */
    private final RemoteObjectId objectId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class ResolveBlobResponse {
    /**
     * UUID of the specified Blob.
     */
    private final String uuid;
  }
}
