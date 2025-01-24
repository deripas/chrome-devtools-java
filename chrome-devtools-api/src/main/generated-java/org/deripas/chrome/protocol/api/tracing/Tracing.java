package org.deripas.chrome.protocol.api.tracing;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.Long;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Generated
public interface Tracing {
  /**
   * Stop trace events collection.
   */
  CompletableFuture<Void> end();

  /**
   * Gets supported tracing categories.
   */
  CompletableFuture<GetCategoriesResponse> getCategories();

  /**
   * Record a clock sync marker in the trace.
   */
  CompletableFuture<Void> recordClockSyncMarker(RecordClockSyncMarkerRequest request);

  /**
   * Request a global memory dump.
   */
  CompletableFuture<RequestMemoryDumpResponse> requestMemoryDump(RequestMemoryDumpRequest request);

  /**
   * Start trace events collection.
   */
  CompletableFuture<Void> start(StartRequest request);

  @Data
  @Builder(
      toBuilder = true
  )
  class GetCategoriesResponse {
    /**
     * A list of supported tracing categories.
     */
    private final List<String> categories;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RecordClockSyncMarkerRequest {
    /**
     * The ID of this clock sync marker
     */
    private final String syncId;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RequestMemoryDumpRequest {
    /**
     * Enables more deterministic results by forcing garbage collection
     */
    @Nullable
    private final Boolean deterministic;

    /**
     * Specifies level of details in memory dump. Defaults to "detailed".
     */
    @Nullable
    private final MemoryDumpLevelOfDetail levelOfDetail;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class RequestMemoryDumpResponse {
    /**
     * GUID of the resulting global memory dump.
     */
    private final String dumpGuid;

    /**
     * True iff the global memory dump succeeded.
     */
    private final Boolean success;
  }

  @Data
  @Builder(
      toBuilder = true
  )
  class StartRequest {
    /**
     * Category/tag filter
     */
    @Nullable
    @Experimental
    @Deprecated
    private final String categories;

    /**
     * Tracing options
     */
    @Nullable
    @Experimental
    @Deprecated
    private final String options;

    /**
     * If set, the agent will issue bufferUsage events at this interval, specified in milliseconds
     */
    @Nullable
    @Experimental
    private final Long bufferUsageReportingInterval;

    /**
     * Whether to report trace events as series of dataCollected events or to save trace to a
     * stream (defaults to `ReportEvents`).
     */
    @Nullable
    private final TransferMode transferMode;

    /**
     * Trace data format to use. This only applies when using `ReturnAsStream`
     * transfer mode (defaults to `json`).
     */
    @Nullable
    private final StreamFormat streamFormat;

    /**
     * Compression format to use. This only applies when using `ReturnAsStream`
     * transfer mode (defaults to `none`)
     */
    @Nullable
    @Experimental
    private final StreamCompression streamCompression;

    @Nullable
    private final TraceConfig traceConfig;

    /**
     * Base64-encoded serialized perfetto.protos.TraceConfig protobuf message
     * When specified, the parameters `categories`, `options`, `traceConfig`
     * are ignored. (Encoded as a base64 string when passed over JSON)
     */
    @Nullable
    @Experimental
    private final String perfettoConfig;

    /**
     * Backend type (defaults to `auto`)
     */
    @Nullable
    @Experimental
    private final TracingBackend tracingBackend;

    public enum TransferMode {
      @JsonProperty("ReportEvents")
      REPORT_EVENTS,

      @JsonProperty("ReturnAsStream")
      RETURN_AS_STREAM
    }
  }
}
