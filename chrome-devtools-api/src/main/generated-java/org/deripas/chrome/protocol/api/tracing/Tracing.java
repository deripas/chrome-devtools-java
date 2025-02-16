package org.deripas.chrome.protocol.api.tracing;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.Double;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.Disposable;
import org.deripas.chrome.protocol.api.io.StreamHandle;

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

  Disposable onBufferUsage(Consumer<BufferUsageEvent> listener);

  Disposable onDataCollected(Consumer<DataCollectedEvent> listener);

  Disposable onTracingComplete(Consumer<TracingCompleteEvent> listener);

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
    private final Double bufferUsageReportingInterval;

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

  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("bufferUsage")
  class BufferUsageEvent {
    /**
     * A number in range [0..1] that indicates the used size of event buffer as a fraction of its
     * total size.
     */
    @Nullable
    private final Double percentFull;

    /**
     * An approximate number of events in the trace log.
     */
    @Nullable
    private final Double eventCount;

    /**
     * A number in range [0..1] that indicates the used size of event buffer as a fraction of its
     * total size.
     */
    @Nullable
    private final Double value;
  }

  /**
   * Contains a bucket of collected trace events. When tracing is stopped collected events will be
   * sent as a sequence of dataCollected events followed by tracingComplete event.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("dataCollected")
  class DataCollectedEvent {
    private final List<Map> value;
  }

  /**
   * Signals that tracing is stopped and there is no trace buffers pending flush, all data were
   * delivered via dataCollected events.
   */
  @Data
  @Builder(
      toBuilder = true
  )
  @JsonTypeName("tracingComplete")
  class TracingCompleteEvent {
    /**
     * Indicates whether some trace data is known to have been lost, e.g. because the trace ring
     * buffer wrapped around.
     */
    private final Boolean dataLossOccurred;

    /**
     * A handle of the stream that holds resulting trace data.
     */
    @Nullable
    private final StreamHandle stream;

    /**
     * Trace data format of returned stream.
     */
    @Nullable
    private final StreamFormat traceFormat;

    /**
     * Compression format of returned stream.
     */
    @Nullable
    private final StreamCompression streamCompression;
  }
}
