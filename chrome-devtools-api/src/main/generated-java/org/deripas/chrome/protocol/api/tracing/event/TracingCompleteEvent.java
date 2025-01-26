package org.deripas.chrome.protocol.api.tracing.event;

import java.lang.Boolean;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.io.StreamHandle;
import org.deripas.chrome.protocol.api.tracing.StreamCompression;
import org.deripas.chrome.protocol.api.tracing.StreamFormat;

/**
 * Signals that tracing is stopped and there is no trace buffers pending flush, all data were
 * delivered via dataCollected events.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class TracingCompleteEvent {
  public static final EventId<TracingCompleteEvent> ID = new EventId<>("Tracing.tracingComplete", TracingCompleteEvent.class);

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
