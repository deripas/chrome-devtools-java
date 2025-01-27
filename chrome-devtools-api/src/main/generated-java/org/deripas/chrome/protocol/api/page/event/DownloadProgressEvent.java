package org.deripas.chrome.protocol.api.page.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.Double;
import java.lang.String;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.deripas.chrome.protocol.api.EventId;

/**
 * Fired when download makes progress. Last call has |done| == true.
 * Deprecated. Use Browser.downloadProgress instead.
 */
@Data
@Builder(
    toBuilder = true
)
@Generated
public class DownloadProgressEvent {
  public static final EventId<DownloadProgressEvent> ID = new EventId<>("Page.downloadProgress", DownloadProgressEvent.class);

  /**
   * Global unique identifier of the download.
   */
  private final String guid;

  /**
   * Total expected bytes to download.
   */
  private final Double totalBytes;

  /**
   * Total bytes received.
   */
  private final Double receivedBytes;

  /**
   * Download status.
   */
  private final State state;

  public enum State {
    @JsonProperty("inProgress")
    IN_PROGRESS,

    @JsonProperty("completed")
    COMPLETED,

    @JsonProperty("canceled")
    CANCELED
  }
}
