package org.deripas.chrome.protocol.api.network.event;

import java.lang.Integer;
import java.lang.String;
import javax.annotation.Nullable;
import jdk.jfr.Experimental;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;
import org.deripas.chrome.protocol.api.network.MonotonicTime;
import org.deripas.chrome.protocol.api.network.RequestId;

/**
 * Fired when data chunk was received over the network.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class DataReceivedEvent {
  public static final EventId<DataReceivedEvent> ID = new EventId<>("Network.dataReceived", DataReceivedEvent.class);

  /**
   * Request identifier.
   */
  private final RequestId requestId;

  /**
   * Timestamp.
   */
  private final MonotonicTime timestamp;

  /**
   * Data chunk length.
   */
  private final Integer dataLength;

  /**
   * Actual bytes received (might be less than dataLength for compressed encodings).
   */
  private final Integer encodedDataLength;

  /**
   * Data that was received. (Encoded as a base64 string when passed over JSON)
   */
  @Nullable
  @Experimental
  private final String data;
}
