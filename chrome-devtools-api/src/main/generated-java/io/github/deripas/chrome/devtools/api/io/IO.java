package io.github.deripas.chrome.devtools.api.io;

import io.github.deripas.chrome.devtools.api.Session;
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
import lombok.RequiredArgsConstructor;

/**
 * Input/Output operations for streams produced by DevTools.
 */
@RequiredArgsConstructor
@Generated
public class IO {
  private final Session session;

  /**
   * Close the stream, discard any temporary backing storage.
   */
  public CompletableFuture<Void> close(CloseRequest request) {
    return session.send("IO.close", request, Void.class);
  }

  /**
   * Read a chunk of the stream
   */
  public CompletableFuture<ReadResponse> read(ReadRequest request) {
    return session.send("IO.read", request, ReadResponse.class);
  }

  /**
   * Return UUID of Blob object specified by a remote object id.
   */
  public CompletableFuture<ResolveBlobResponse> resolveBlob(ResolveBlobRequest request) {
    return session.send("IO.resolveBlob", request, ResolveBlobResponse.class);
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class CloseRequest {
    /**
     * Handle of the stream to close.
     */
    private final StreamHandle handle;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ReadRequest {
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
  public static class ReadResponse {
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
  public static class ResolveBlobRequest {
    /**
     * Object id of a Blob object wrapper.
     */
    private final RemoteObjectId objectId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  public static class ResolveBlobResponse {
    /**
     * UUID of the specified Blob.
     */
    private final String uuid;
  }
}
